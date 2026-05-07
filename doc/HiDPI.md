# HiDPI in PanamaGL canvases

PanamaGL renders the OpenGL scene to an offscreen FBO and blits the resulting
image onto a toolkit-specific component (`GLCanvasAWT`, `GLCanvasSwing`,
`GLCanvasJFX`, `GLCanvasSWT`). On a HiDPI / Retina display the host toolkit
already operates in **logical pixels** while the FBO must be allocated in
**physical pixels** so the rendering stays sharp. This document describes how
that adaptation happens automatically, how to observe and override it, and
what differs between toolkits and operating systems.

## Logical vs. physical pixels

| Term              | Meaning                                                                      |
|-------------------|------------------------------------------------------------------------------|
| Logical pixel     | What the toolkit's `getWidth()` / `getHeight()` reports — what the layout sees.   |
| Physical pixel    | What the GPU actually drives. On a 2× display, `physical = 2 × logical`.     |
| Pixel scale       | The ratio `physical / logical`. Identity (`1, 1`) on standard displays, `2, 2` on Retina, fractional on Windows (`1.25`, `1.5`, `1.75`). |

On panama-gl, the FBO is sized in **physical pixels** when HiDPI is enabled and
the resulting image is blitted to the toolkit using **logical pixel**
coordinates. The toolkit then upscales the blit on its own when the display
has a non-identity scale, producing a 1:1 pixel mapping.

## Automatic adaptation

The `GLCanvas` interface (`panama-gl-api`) defines:

```java
PixelScale getPixelScale();
int        getPhysicalWidth();
int        getPhysicalHeight();
boolean    isHiDPIEnabled();
void       setHiDPIEnabled(boolean enabled);
void       addPixelScaleListener(PixelScaleListener listener);
void       removePixelScaleListener(PixelScaleListener listener);
```

Every concrete canvas (`GLCanvasAWT`, `GLCanvasSwing`, `GLCanvasJFX`,
`GLCanvasSWT`) implements these by delegating to a per-toolkit
`PixelScaleSupport*` helper. The chain is:

1. The toolkit reports a logical resize (`componentResized`,
   `widthProperty.changed`, `SWT.Resize`).
2. The canvas reads the current pixel scale via its support helper.
3. The canvas resizes the FBO to `logical × scale` (physical pixels).
4. `AOffscreenRenderer.onDisplay` reads `getPhysicalWidth()/getPhysicalHeight()`
   so subsequent renders without resize stay at the same resolution.
5. The blit happens in logical coordinates so the image fills the component
   exactly.

When the canvas is moved to a monitor with a different scale, the
`PixelScaleListener` registered by each canvas internally re-runs step 3 with
the new dimensions. Listeners registered by the application are also notified.

### `setHiDPIEnabled(false)`

Disables the multiplication by the scale. The FBO follows the logical size,
which means a softer image on HiDPI displays but lower GPU cost. This mirrors
Jzy3D's `Quality.preserveViewportSize=true`.

## Observing pixel scale changes

```java
canvas.addPixelScaleListener((oldScale, newScale) -> {
  System.out.println("Scale changed " + oldScale + " -> " + newScale);
});
```

Listeners fire when the canvas is moved between monitors of different DPI, or
when the user changes the OS display scaling at runtime.

## Stale-frame guard during initialization

The first `Renderer3D.init()` call (or `View.init()` if PanamaGL is wrapped by
Jzy3D) triggers a synchronous render while the host component is still at its
construction-time size (`0×0` or `1×1`). The offscreen renderer falls back to
its safety minimum of `10×10` pixels for that very first frame. If that frame
were blitted to the component after layout, AWT/SWT would scale `10×10` up to
the final size, producing a brief pixelated flash before the next frame
replaced it.

Each canvas's paint method drops any frame whose dimensions are smaller than
half the component's expected physical size, leaving the background in place
until the first properly sized frame arrives. The frame is not skipped — only
its blit is.

## Per-toolkit specifics

### AWT (`java.awt.Panel`) and Swing (`javax.swing.JPanel`)

Pixel scale is read from `Component.getGraphicsConfiguration().getDefaultTransform()`
(Java 9+). Change events come from three signals:

- `PropertyChangeListener("graphicsConfiguration", …)` — fired when the
  component is moved between monitors of different DPI;
- `HierarchyListener` for `DISPLAYABILITY_CHANGED` — captures the initial
  value once the component is attached to a peer;
- A polling thread (default 200 ms) — fallback for JVMs that do not publish
  `graphicsConfiguration` property changes consistently.

Listener callbacks always run on the EDT.

### JavaFX (`javafx.scene.canvas.Canvas`)

Pixel scale is read by walking
`canvas.getScene().getWindow().getRenderScaleX/Y()`, with
`Screen.getPrimary().getOutputScaleX/Y()` as a fallback when the canvas is not
yet attached. Change events come natively from JavaFX:

```
canvas.sceneProperty → scene.windowProperty → window.renderScaleX/Y
```

The cascade rewires automatically when the canvas is reparented to a different
scene/stage. No polling is needed because JavaFX publishes a property change
on every scale transition.

### SWT (`org.eclipse.swt.widgets.Canvas`)

Pixel scale is read differently per platform (see *Operating systems* below).
Change events come from `display.addListener(SWT.ZoomChanged, …)` (SWT 4.24+,
confirmed available on 3.126.0). On macOS, `SWT.ZoomChanged` does not fire
when the window moves between monitors of different backing scales, so an
additional `SWT.Move` listener on the canvas re-checks the value.

## Per-OS specifics

### macOS (Retina)

- **AWT/Swing**: `GraphicsConfiguration.getDefaultTransform()` returns `2.0`
  natively on Retina.
- **JavaFX**: `Window.getRenderScaleX/Y()` returns `2.0`.
- **SWT**: `Monitor.getZoom()` returns `100` even on Retina because SWT-Cocoa
  applies its own auto-scaling transparently. The actual backing scale is
  read by reflecting into `org.eclipse.swt.internal.cocoa` —
  `Control.view → NSView.window() → NSWindow.screen() → NSScreen.backingScaleFactor()`.
  See `MacOSBackingScaleFactor` in `panama-gl-ui-swt`. The reflection chain
  fails gracefully back to `1.0` on non-cocoa SWT jars.

### Windows

- **AWT/Swing**: from JDK 9 onwards, `getDefaultTransform()` returns the
  fractional scale picked in *Display settings* (`1.25`, `1.5`, `1.75`,
  `2.0`). Requires the JVM to be DPI-aware (the default for recent JDKs).
- **JavaFX**: `Window.getRenderScaleX/Y()` mirrors the OS scale, including
  fractional values.
- **SWT**: `Monitor.getZoom() / 100.0` returns the OS scale.

### Linux

- **AWT/Swing**: respects `GDK_SCALE` for integer scales (`1`, `2`).
  Fractional Wayland scales are only inconsistently surfaced.
- **JavaFX**: respects `glass.gtk.uiScale` and `GDK_SCALE`.
- **SWT**: `Monitor.getZoom() / 100.0` reflects the GTK scale.

## Disabling HiDPI

`canvas.setHiDPIEnabled(false)` switches the FBO back to logical pixel size.
The reported `getPixelScale()` is unchanged — only `getPhysicalWidth/Height()`
collapses to the logical dimensions. This is the right setting when:

- The pixel cost of a HiDPI FBO is too high for interactive frame rates;
- The application explicitly preserves the viewport size (Jzy3D's
  `Quality.preserveViewportSize=true`).

## Testing without a display

The unit tests use `Assume.assumeFalse(GraphicsEnvironment.isHeadless())` to
skip on headless CI. JavaFX tests additionally tolerate the cold-start of
`Platform.runLater` on Linux runners by using a 30 s timeout and draining the
queue between tests.
