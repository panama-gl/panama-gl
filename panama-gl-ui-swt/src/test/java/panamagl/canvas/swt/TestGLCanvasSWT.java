/*******************************************************************************
 * Copyright (c) 2022, 2023 Martin Pernollet & contributors.
 *
 * This library is free software; you can redistribute it and/or modify it under the terms of the
 * GNU Lesser General Public License as published by the Free Software Foundation; either version
 * 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License along with this library;
 * if not, write to the Free Software Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA
 * 02110-1301, USA
 *******************************************************************************/
package panamagl.canvas.swt;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.PaletteData;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import java.util.concurrent.atomic.AtomicReference;
import panamagl.GLEventAdapter;
import panamagl.GLEventListener;
import panamagl.canvas.GLCanvas;
import panamagl.canvas.GLCanvas.Flip;
import panamagl.factory.PanamaGLFactory;
import panamagl.image.SWTImage;
import panamagl.offscreen.AOffscreenRenderer;
import panamagl.offscreen.FBOReader_SWT;
import panamagl.offscreen.OffscreenRenderer;
import panamagl.offscreen.ThreadRedirect;
import panamagl.offscreen.ThreadRedirect_SWT;
import panamagl.opengl.GL;
import panamagl.opengl.GLContext;
import panamagl.performance.RenderCounter;

/**
 * Unit tests for {@link GLCanvasSWT}, mirroring the structure of
 * {@code TestGLCanvasSWT}, {@code TestGLCanvasSwing_all}, and {@code TestGLCanvasJFX_all}.
 *
 * VM ARGS : -XstartOnFirstThread --enable-native-access=ALL-UNNAMED
 * -Djava.library.path=.:/System/Library/Frameworks/OpenGL.framework/Versions/Current/Libraries/
 */
public class TestGLCanvasSWT {

  Display display;
  Shell shell;
  PanamaGLFactory factory;
  OffscreenRenderer mockOffscreen;

  @Before
  public void setup() {
    display = Display.getCurrent();
    if (display == null) {
      display = new Display();
    }
    shell = new Shell(display);
    shell.setLayout(new FillLayout());

    // Mock the factory to return a mock offscreen renderer
    mockOffscreen = mock(OffscreenRenderer.class);
    factory = mock(PanamaGLFactory.class);
    when(factory.newOffscreenRenderer(any(FBOReader_SWT.class))).thenReturn(mockOffscreen);
  }

  @After
  public void teardown() {
    if (shell != null && !shell.isDisposed()) {
      shell.dispose();
    }
    if (display != null && !display.isDisposed()) {
      display.dispose();
    }
  }

  // ==================== constructor ====================

  @Test
  public void constructor_setsThreadRedirectOnOffscreenRenderer() {
    GLCanvasSWT canvas = new GLCanvasSWT(shell, SWT.NONE, factory);

    Assert.assertFalse(canvas.isDisposed());

    verify(mockOffscreen).setThreadRedirect(any(ThreadRedirect_SWT.class));
  }

  // ==================== setGLEventListener ====================

  @Test
  public void setGLEventListener_callsOffscreenOnInit() {
    GLCanvasSWT canvas = new GLCanvasSWT(shell, SWT.NONE, factory);
    GLEventListener listener = mock(GLEventListener.class);

    canvas.setGLEventListener(listener);

    verify(mockOffscreen).onInit(canvas, listener);
  }

  @Test
  public void setGLEventListener_storesListener() {
    GLCanvasSWT canvas = new GLCanvasSWT(shell, SWT.NONE, factory);
    GLEventListener listener = mock(GLEventListener.class);

    canvas.setGLEventListener(listener);

    Assert.assertSame(listener, canvas.getGLEventListener());
  }

  // ==================== display() ====================

  @Test
  public void display_callsOffscreenOnDisplay() {
    GLCanvasSWT canvas = new GLCanvasSWT(shell, SWT.NONE, factory);
    GLEventListener listener = mock(GLEventListener.class);
    canvas.setGLEventListener(listener);

    when(mockOffscreen.isInitialized()).thenReturn(true);

    canvas.display();

    verify(mockOffscreen).onDisplay(canvas, listener);
  }

  @Test
  public void display_doesNothingWhenNotInitialized() {
    GLCanvasSWT canvas = new GLCanvasSWT(shell, SWT.NONE, factory);

    when(mockOffscreen.isInitialized()).thenReturn(false);

    // Should not throw, and should not call onDisplay
    canvas.display();
  }

  // ==================== isInitialized ====================

  @Test
  public void isInitialized_delegatesToOffscreen() {
    GLCanvasSWT canvas = new GLCanvasSWT(shell, SWT.NONE, factory);

    when(mockOffscreen.isInitialized()).thenReturn(false);
    Assert.assertFalse(canvas.isInitialized());

    when(mockOffscreen.isInitialized()).thenReturn(true);
    Assert.assertTrue(canvas.isInitialized());
  }

  // ==================== getGL / getContext ====================

  @Test
  public void getGL_delegatesToOffscreen() {
    GLCanvasSWT canvas = new GLCanvasSWT(shell, SWT.NONE, factory);
    GL mockGL = mock(GL.class);
    when(mockOffscreen.getGL()).thenReturn(mockGL);

    Assert.assertSame(mockGL, canvas.getGL());
  }

  @Test
  public void getContext_delegatesToOffscreen() {
    GLCanvasSWT canvas = new GLCanvasSWT(shell, SWT.NONE, factory);
    GLContext mockContext = mock(GLContext.class);
    when(mockOffscreen.getContext()).thenReturn(mockContext);

    Assert.assertSame(mockContext, canvas.getContext());
  }

  // ==================== rendering state ====================

  @Test
  public void isRendering_falseByDefault() {
    GLCanvasSWT canvas = new GLCanvasSWT(shell, SWT.NONE, factory);
    Assert.assertFalse(canvas.isRendering());
  }

  @Test
  public void display_setsRenderingTrue() {
    GLCanvasSWT canvas = new GLCanvasSWT(shell, SWT.NONE, factory);
    when(mockOffscreen.isInitialized()).thenReturn(true);

    canvas.display();

    Assert.assertTrue(canvas.isRendering());
  }

  // ==================== screenshot ====================

  @Test
  public void setScreenshot_storesImage() {
    GLCanvasSWT canvas = new GLCanvasSWT(shell, SWT.NONE, factory);
    ImageData data = new ImageData(10, 10, 32, new PaletteData(0xFF0000, 0xFF00, 0xFF));
    SWTImage image = new SWTImage(data);

    canvas.setScreenshot(image);

    Assert.assertSame(image, canvas.getScreenshot());
  }

  // ==================== offscreen renderer ====================

  @Test
  public void getOffscreenRenderer_returnsRenderer() {
    GLCanvasSWT canvas = new GLCanvasSWT(shell, SWT.NONE, factory);
    Assert.assertSame(mockOffscreen, canvas.getOffscreenRenderer());
  }

  // ==================== flip ====================

  @Test
  public void flip_defaultIsVertical() {
    GLCanvasSWT canvas = new GLCanvasSWT(shell, SWT.NONE, factory);
    Assert.assertEquals(Flip.VERTICAL, canvas.getFlip());
  }

  @Test
  public void setFlip_changesFlip() {
    GLCanvasSWT canvas = new GLCanvasSWT(shell, SWT.NONE, factory);
    canvas.setFlip(Flip.HORIZONTAL);
    Assert.assertEquals(Flip.HORIZONTAL, canvas.getFlip());

    canvas.setFlip(Flip.NONE);
    Assert.assertEquals(Flip.NONE, canvas.getFlip());
  }



  // ==================== dimensions ====================

  @Test
  public void getWidth_getHeight_returnBounds() {
    GLCanvasSWT canvas = new GLCanvasSWT(shell, SWT.NONE, factory);
    shell.setSize(320, 240);
    shell.layout();

    // Canvas fills the shell via FillLayout, so dimensions should be > 0
    Assert.assertTrue(canvas.getWidth() > 0);
    Assert.assertTrue(canvas.getHeight() > 0);
  }

  // ==================== dispose ====================

  @Test
  public void dispose_callsOffscreenOnDestroy() {
    GLCanvasSWT canvas = new GLCanvasSWT(shell, SWT.NONE, factory);
    GLEventListener listener = mock(GLEventListener.class);
    canvas.setGLEventListener(listener);

    canvas.dispose();

    verify(mockOffscreen).onDestroy(canvas, listener);
  }

  // ==================== repaint ====================

  @Test
  public void repaint_doesNotThrowWhenNotDisposed() {
    GLCanvasSWT canvas = new GLCanvasSWT(shell, SWT.NONE, factory);
    // Should not throw
    canvas.repaint();
  }

  @Test
  public void repaint_doesNotThrowWhenDisposed() {
    GLCanvasSWT canvas = new GLCanvasSWT(shell, SWT.NONE, factory);
    canvas.dispose();
    // Should not throw
    canvas.repaint();
  }

  // ==================== full lifecycle with real factory ====================

  /**
   * Integration test verifying the full chain:
   * panel → offscreen_renderer → fbo → listener events.
   *
   * Mirrors {@code TestGLCanvasSwing_all.whenPanelIsAdded_ThenGLEventListenerIsInvoked}
   * and {@code TestGLCanvasJFX_all.whenPanelIsAdded_ThenGLEventListenerIsInvoked}.
   */
  @Ignore("Requires native GL context - run with VM args: -XstartOnFirstThread --enable-native-access=ALL-UNNAMED")
  @Test
  public void whenListenerIsSet_ThenGLEventListenerIsInvoked() throws InterruptedException {
    // Given
    EventCounter event = new EventCounter();
    PanamaGLFactory realFactory = PanamaGLFactory.select();

    GLCanvasSWT canvas = new GLCanvasSWT(shell, SWT.NONE, realFactory);

    GLEventListener listener = new GLEventAdapter() {
      @Override
      public void init(GL gl) {
        event.init++;
      }

      @Override
      public void display(GL gl) {
        event.display++;
      }

      @Override
      public void reshape(GL gl, int x, int y, int width, int height) {
        event.reshape++;
      }

      @Override
      public void dispose(GL gl) {
        event.dispose++;
      }
    };

    Assert.assertFalse(canvas.isInitialized());

    // When: set listener triggers offscreen.onInit
    canvas.setGLEventListener(listener);

    // Process SWT events to allow async init
    processEvents(500);

    // Then
    Assert.assertTrue(canvas.isInitialized());
    Assert.assertEquals(1, event.init);

    // When: display
    shell.setSize(200, 200);
    shell.open();

    canvas.display();
    processEvents(500);

    // Then
    Assert.assertTrue(event.display > 0);
    Assert.assertTrue(event.reshape > 0);
    Assert.assertNotNull(canvas.getScreenshot());

    // Then: thread redirect is SWT type
    ThreadRedirect redirect = canvas.getOffscreenRenderer().getThreadRedirect();
    Assert.assertTrue(redirect instanceof ThreadRedirect_SWT);
  }

  /**
   * Integration test verifying FBO resize follows canvas resize.
   *
   * Mirrors {@code TestGLCanvasSwing_all.whenPanelIsResized_ThenFBOIsResized}
   * and {@code TestGLCanvasJFX_all.whenPanelIsResized_ThenFBOIsResized}.
   */
  @Ignore("Requires native GL context - run with VM args: -XstartOnFirstThread --enable-native-access=ALL-UNNAMED")
  @Test
  public void whenCanvasIsResized_ThenFBOIsResized() throws InterruptedException {
    int WIDTH = 100;
    int HEIGHT = 100;

    PanamaGLFactory realFactory = PanamaGLFactory.select();

    GLCanvasSWT canvas = new GLCanvasSWT(shell, SWT.NONE, realFactory);
    canvas.setGLEventListener(new GLEventAdapter());

    processEvents(500);
    Assert.assertTrue(canvas.isInitialized());

    // When: resize + display
    shell.setSize(WIDTH, HEIGHT);
    shell.layout();
    canvas.display();
    processEvents(500);

    // Then: FBO matches
    Assert.assertEquals(canvas.getWidth(), canvas.getFBO().getWidth());
    Assert.assertEquals(canvas.getHeight(), canvas.getFBO().getHeight());

    // When: resize again
    shell.setSize(3 * WIDTH, 2 * HEIGHT);
    shell.layout();
    canvas.display();
    processEvents(500);

    // Then: FBO updated
    Assert.assertEquals(canvas.getWidth(), canvas.getFBO().getWidth());
    Assert.assertEquals(canvas.getHeight(), canvas.getFBO().getHeight());
  }

  // ==================== cross-thread display() — regression for AOffscreenRenderer.onDisplay ====================

  /**
   * Regression guard for {@link AOffscreenRenderer#onDisplay}.
   *
   * <p><b>Bug.</b> {@code onDisplay} used to call {@code drawable.getWidth()} /
   * {@code getHeight()} on the <i>caller</i> thread <b>before</b> handing off to
   * {@link ThreadRedirect_SWT}. Those getters bottom out in {@code Control.getBounds()} which
   * {@code checkWidget()}s and throws {@code SWTException: Invalid thread access} when the
   * caller is not on the SWT display thread. This bit any non-UI thread that asked the canvas
   * to repaint — typically the {@code CameraThreadController} behind double-click auto-rotate
   * in the jzy3d SWT bindings.
   *
   * <p><b>Fix.</b> {@code onDisplay} now snapshots the dimensions <i>inside</i> the runnable
   * passed to {@code threadRedirect.run(...)}, so the SWT widget access is performed on the
   * SWT display thread.
   *
   * <p><b>What this test does.</b> Wires a real {@link AOffscreenRenderer} (subclassed to skip
   * actual GL work) into a real {@link GLCanvasSWT} (which sets up a real
   * {@link ThreadRedirect_SWT}). Calls {@link GLCanvasSWT#display()} from a non-SWT background
   * thread, drains the SWT event queue so the {@code asyncExec} fires, and asserts:
   * <ul>
   *   <li>no {@code SWTException} escaped to the background thread,</li>
   *   <li>the runnable observed by {@code threadRedirect} actually ran on the SWT display
   *       thread (i.e. the dimension sampling happened where SWT allows it).</li>
   * </ul>
   */
  @Test
  public void displayFromNonSwtThread_doesNotThrowInvalidThreadAccess() throws Exception {
    AtomicReference<Thread> renderTaskThread = new AtomicReference<>();

    PanamaGLFactory realFactory = mock(PanamaGLFactory.class);
    AOffscreenRenderer recordingRenderer =
        new AOffscreenRenderer(realFactory, mock(FBOReader_SWT.class)) {
          @Override
          public boolean isInitialized() {
            // Force GLCanvasSWT.display() to proceed past its early-out guard without going
            // through the real init path (which would need a live GL context).
            return true;
          }

          @Override
          public void onDestroy(GLCanvas drawable, GLEventListener listener) {
            // Avoid the NPE in destroyContext(listener.dispose(gl)) when the dispose
            // listener fires during shell teardown without a real listener bound.
          }

          @Override
          protected Runnable getTask_renderGLToImage(GLCanvas drawable, GLEventListener listener,
              int width, int height) {
            // Capture the thread that built the render task — i.e. the thread on which
            // drawable.getWidth() / getHeight() were sampled. With the fix, this must be the
            // SWT display thread; without the fix, it would be the caller thread (and the
            // getWidth() call would already have thrown before we got here).
            renderTaskThread.set(Thread.currentThread());
            return () -> {
              /* no GL work — we are only verifying threading */
            };
          }
        };
    when(realFactory.newOffscreenRenderer(any(FBOReader_SWT.class))).thenReturn(recordingRenderer);

    GLCanvasSWT canvas = new GLCanvasSWT(shell, SWT.NONE, realFactory);
    // Skip setGLEventListener: it would trigger AOffscreenRenderer.onInit() which needs a
    // live GL context. isInitialized() is forced to true above so display() proceeds anyway.

    // Trigger display() from a non-SWT thread — this is what a CameraThreadController does.
    Throwable[] err = new Throwable[1];
    Thread bg = new Thread(() -> {
      try {
        canvas.display();
      } catch (Throwable t) {
        err[0] = t;
      }
    }, "non-swt-display-caller");
    bg.start();
    bg.join(2000);

    // Drain the SWT queue so the asyncExec scheduled by ThreadRedirect_SWT actually runs.
    long deadline = System.currentTimeMillis() + 2000;
    while (renderTaskThread.get() == null && System.currentTimeMillis() < deadline) {
      if (!display.readAndDispatch()) {
        // Briefly yield then keep draining; we cannot use display.sleep() because no native
        // event will wake it in this isolated unit-test environment.
        try { Thread.sleep(10); } catch (InterruptedException ignored) {}
      }
    }

    if (err[0] != null) {
      throw new AssertionError(
          "Calling GLCanvasSWT.display() from a non-SWT thread must not throw, but got: "
              + err[0],
          err[0]);
    }
    Assert.assertNotNull(
        "Render task was never executed — ThreadRedirect_SWT did not deliver to the display "
            + "thread within the timeout",
        renderTaskThread.get());
    Assert.assertSame(
        "AOffscreenRenderer.onDisplay must build the render task on the SWT display thread "
            + "(so that drawable.getWidth/getHeight is sampled where SWT permits it), "
            + "not on the caller thread",
        display.getThread(),
        renderTaskThread.get());
  }

  /**
   * Sanity check: when {@link GLCanvasSWT#display()} is called <i>from</i> the SWT display
   * thread, the redirect should run synchronously (no event-queue hop required) and the
   * render task should also execute on the SWT thread.
   *
   * Locks in that the cross-thread fix above did not regress the common single-threaded path.
   */
  @Test
  public void displayFromSwtThread_runsSynchronouslyOnSwtThread() {
    AtomicReference<Thread> renderTaskThread = new AtomicReference<>();

    PanamaGLFactory realFactory = mock(PanamaGLFactory.class);
    AOffscreenRenderer recordingRenderer =
        new AOffscreenRenderer(realFactory, mock(FBOReader_SWT.class)) {
          @Override
          public boolean isInitialized() {
            return true;
          }

          @Override
          public void onDestroy(GLCanvas drawable, GLEventListener listener) {
            // Avoid the NPE in destroyContext when shell teardown fires the dispose listener
            // without a real listener bound.
          }

          @Override
          protected Runnable getTask_renderGLToImage(GLCanvas drawable, GLEventListener listener,
              int width, int height) {
            renderTaskThread.set(Thread.currentThread());
            return () -> {};
          }
        };
    when(realFactory.newOffscreenRenderer(any(FBOReader_SWT.class))).thenReturn(recordingRenderer);

    GLCanvasSWT canvas = new GLCanvasSWT(shell, SWT.NONE, realFactory);
    // Skip setGLEventListener: it would trigger AOffscreenRenderer.onInit() which needs a
    // live GL context. isInitialized() is forced to true above so display() proceeds anyway.

    canvas.display();

    Assert.assertSame(
        "Same-thread display() must build the render task on the SWT thread without an "
            + "asyncExec hop",
        display.getThread(),
        renderTaskThread.get());
  }

  // ==================== HiDPI: stale-frame guard ====================

  private static ImageData newImageData(int w, int h) {
    return new ImageData(w, h, 32, new PaletteData(0xFF0000, 0xFF00, 0xFF));
  }

  /** Build a canvas with a deterministic physical size (HiDPI off → physical == logical). */
  private GLCanvasSWT newCanvasForPaintTest(int w, int h) {
    GLCanvasSWT canvas = new GLCanvasSWT(shell, SWT.NONE, factory);
    canvas.setSize(w, h);
    canvas.setHiDPIEnabled(false);
    canvas.setFlip(Flip.NONE); // simplest drawImage signature
    return canvas;
  }

  @Test
  public void isStaleFrame_returnsTrue_whenFrameMuchSmallerThanCanvas() {
    GLCanvasSWT canvas = newCanvasForPaintTest(200, 200);
    Assert.assertTrue("10x10 frame on a 200x200 canvas must be stale",
        canvas.isStaleFrame(newImageData(10, 10)));
  }

  @Test
  public void isStaleFrame_returnsFalse_whenFrameMatchesCanvas() {
    GLCanvasSWT canvas = newCanvasForPaintTest(200, 200);
    Assert.assertFalse("200x200 frame on a 200x200 canvas must not be stale",
        canvas.isStaleFrame(newImageData(200, 200)));
  }

  @Test
  public void isStaleFrame_returnsFalse_whenCanvasNotYetSized() {
    GLCanvasSWT canvas = new GLCanvasSWT(shell, SWT.NONE, factory);
    canvas.setHiDPIEnabled(false);
    // Canvas defaults to 0x0 before layout; the guard must not flag any frame as stale here.
    Assert.assertFalse(canvas.isStaleFrame(newImageData(10, 10)));
  }

  /**
   * The 50% threshold tolerates fractional Windows scaling (1.25x, 1.5x, 1.75x): a frame larger
   * than half the canvas's expected size must be blitted normally even if smaller than the
   * canvas itself.
   */
  @Test
  public void isStaleFrame_returnsFalse_whenFrameAtHalfThreshold() {
    GLCanvasSWT canvas = newCanvasForPaintTest(200, 200);
    Assert.assertFalse(canvas.isStaleFrame(newImageData(100, 100)));
    Assert.assertTrue(canvas.isStaleFrame(newImageData(99, 100)));
  }

  /**
   * Regression guard for the brief pixelated flash on chart open: the stale-frame skip path must
   * reset the rendering flag so the next display() at the proper size is not gated by
   * {@code isRendering()==true}.
   *
   * <p>The "stale 10x10 image is not actually blitted" property is covered by the
   * {@link #isStaleFrame_returnsTrue_whenFrameMuchSmallerThanCanvas} unit test on the predicate
   * itself: SWT's {@link GC} is a {@code final} class and cannot be mocked here, so we cannot
   * verify {@code drawImage} interactions directly without an integration-grade test rig.
   */
  @Test
  public void paintComponentNow_resetsRenderingFlag_evenWhenSkipped() {
    GLCanvasSWT canvas = newCanvasForPaintTest(200, 200);
    canvas.setScreenshot(new SWTImage(newImageData(10, 10)));
    canvas.setRendering(true);

    // SWT's GC is final → can't be mocked. Use a real one backed by a temporary Image.
    Image scratch = new Image(display, 1, 1);
    GC gc = new GC(scratch);
    try {
      canvas.paintComponentNow(display, gc);
    } finally {
      gc.dispose();
      scratch.dispose();
    }

    Assert.assertFalse("rendering must be reset to false after a skipped paint",
        canvas.isRendering());
  }

  // ==================== helpers ====================

  /** Process SWT events for the given duration in milliseconds. */
  private void processEvents(long durationMs) {
    long deadline = System.currentTimeMillis() + durationMs;
    while (System.currentTimeMillis() < deadline) {
      if (!display.readAndDispatch()) {
        display.sleep();
      }
    }
  }

  protected class EventCounter {
    int init = 0;
    int display = 0;
    int reshape = 0;
    int dispose = 0;
  }
}
