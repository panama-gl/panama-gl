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
package panamagl.canvas;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.image.BufferedImage;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.swing.JPanel;
import panamagl.Debug;
import panamagl.GLEventListener;
import panamagl.Image;
import panamagl.canvas.overlay.PerformanceOverlay_AWT;
import panamagl.factory.PanamaGLFactory;
import panamagl.image.AWTImage;
import panamagl.offscreen.FBO;
import panamagl.offscreen.FBOReader_AWT;
import panamagl.offscreen.OffscreenRenderer;
import panamagl.opengl.GL;
import panamagl.opengl.GLContext;
import panamagl.performance.RenderCounter;
import panamagl.utils.ImageUtils;

/**
 * This panel push to the screen an OpenGL image rendered offscreen by an {@link OffscreenRenderer}.
 * 
 * The panel mainly deals with
 * <ul>
 * <li>OpenGL context initialization, after the panel is added to a parent, and before it is made
 * visible.</li>
 * <li>repaint and resize events that are propagated to the OpenGL application through a
 * {@link GLEventListener}, which must be provided by the user of this panel through
 * {@link #setGLEventListener(GLEventListener)}.</li>
 * <li>measuring performance, that is evaluating the time required to trigger offscreen image
 * rendering and image painting onscreen.</li>
 * </ul>
 * 
 * <h2>Threading</h2>
 * 
 * The panel is also responsible for triggering OpenGL initialization and rendering in the
 * appropriate threads, which may depend on the running operating system.
 * 
 * <h3>Threading on macOS</h3>
 * 
 * <img src="./doc-files/GLPanel-threads.png"/>
 * 
 * 
 * <h2>Debugging</h2>
 * 
 * Hint : to debug this class, invoke a program using it with flag -Dpanamagl.canvas.GLCanvasSwing
 * 
 * @author Martin Pernollet
 *
 */
public class GLCanvasSwing extends JPanel implements GLCanvas {
  private static final long serialVersionUID = -4601832524814661585L;

  protected GLEventListener listener;
  protected OffscreenRenderer offscreen;
  protected BufferedImage out = null;

  protected AtomicBoolean rendering = new AtomicBoolean();
  protected RenderCounter counter = new RenderCounter();
  protected PerformanceOverlay_AWT overlay;

  protected boolean debug = Debug.check(GLCanvasSwing.class);
  protected boolean debugPerf = false;

  protected Flip flip = Flip.VERTICAL;

  // Initialized at field-declaration time (rather than in the factory constructor) so that the
  // mocking-only no-arg constructor below still produces a usable support instance — Jzy3D test
  // code that calls Mockito spy(GLCanvasSwing.class) would otherwise NPE on addPixelScaleListener.
  protected PixelScaleSupportAWT pixelScaleSupport = new PixelScaleSupportAWT(this);
  protected volatile boolean hiDPIEnabled = true;

  // For mocking
  public GLCanvasSwing() {}

  /**
   * Initialize a panel able to render OpenGL through a {@link GLEventListener} and related
   * {@link GL} interface.
   */
  public GLCanvasSwing(PanamaGLFactory factory) {
    this.offscreen = factory.newOffscreenRenderer(new FBOReader_AWT());
    this.overlay = new PerformanceOverlay_AWT(this);

    // Show debug info
    // if (debug)
    // GraphicsUtils.printGraphicsEnvironment("GLCanvasSwing");

    // This listener hold the most important part of the rendering flow
    addComponentListener(new ResizeHandler());

    // HiDPI / pixel scale plumbing (support is constructed at field init).
    pixelScaleSupport.addListener((oldScale, newScale) -> onPixelScaleChanged());
  }

  /** Re-resize the FBO with new physical dimensions when the pixel scale changes. */
  protected void onPixelScaleChanged() {
    if (!offscreen.isInitialized() || isRendering()) {
      return;
    }
    setRendering(true);
    counter.onStartRendering();
    offscreen.onResize(this, listener, 0, 0, getPhysicalWidth(), getPhysicalHeight());
  }



  /* ===================================================== */
  //
  // AWT OVERRIDES


  /**
   * Called after the JPanel has been added to the Swing hierarchy but before it is made visible.
   * 
   * Initialization may occur in other threads and not be completed when this method returns.
   * 
   * To ensure the component is initialized, call {@link #isInitialized()}.
   */
  @Override
  public void addNotify() {
    super.addNotify();

    // Initialize GL context from the appropriate thread
    // Main OS thread for macOS
    // AWT thread for Linux/Windows
    offscreen.onInit(this, listener);

    pixelScaleSupport.start();
  }

  /**
   * Called before the JPanel is removed from the Swing hierarchy.
   */
  @Override
  public void removeNotify() {
    pixelScaleSupport.stop();
    offscreen.onDestroy(null, listener);

    super.removeNotify();

  }

  /**
   * Invoked each time redraw should be performed, even if the redraw query is coalesced with other
   * redraw queries by the AWT Event Queue.
   * 
   * @see {@link #update()}
   */
  @Override
  public void update(Graphics g) {
    getMonitoring().onUpdate();
    super.update(g);
  }

  /**
   * Invoked only for redraw query that are not coalesced with other redraw queries by the AWT Event
   * Queue.
   * 
   * @see {@link #paint()}
   */
  @Override
  public void paint(Graphics g) {
    getMonitoring().onPaint();
    super.paint(g);
  }

  boolean antialiasing = false;

  /**
   * Render GL image and stop counting elapsed time for rendering (started at {@link #display()})
   */
  @Override
  public void paintComponent(Graphics g) {
    if (out != null) {

      // Drop stale frames produced before the panel had its real size — typically the
      // 10x10 init frame {@link panamagl.offscreen.AOffscreenRenderer} renders synchronously from
      // listener.init() (Jzy3D's View.init -> updateBounds -> shoot -> forceRepaint chain) when
      // the JPanel is still 0x0. Without this guard, AWT's first paint() after layout would blit
      // that tiny image scaled up to the final panel size, producing a ~200ms pixelated flash
      // before the first proper-size frame replaces it.
      if (isStaleFrame(out)) {
        // Reset the rendering flag so the next display() at the proper size is not gated.
        rendering.set(false);
        return;
      }

      if (antialiasing) {
        Graphics2D g2d = (Graphics2D) out.getGraphics();

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
            RenderingHints.VALUE_INTERPOLATION_BICUBIC);
      }

      // Standard
      if (flip == null || Flip.NONE.equals(flip)) {
        g.drawImage(out, 0, 0, getWidth(), getHeight(), this);
      }
      // vertical flip
      else if (Flip.VERTICAL.equals(flip)) {
        g.drawImage(out, 0, 0 + getHeight(), getWidth(), -getHeight(), this);
      }
      // horizontal flip
      else if (Flip.HORIZONTAL.equals(flip)) {
        g.drawImage(out, 0 + getWidth(), 0, -getWidth(), getHeight(), this);
      }

      getMonitoring().onPaintComponentBefore();

      if (debugPerf)
        overlayPerformance(g);

      rendering.set(false);
    }
  }

  /**
   * A frame is stale if its resolution is significantly smaller than the panel currently expects.
   * Threshold is half the expected physical width/height: comfortable margin against fractional
   * pixel scales (1.5x, 1.75x) without missing the genuine 10x10 init frame.
   */
  private boolean isStaleFrame(BufferedImage frame) {
    int expectedW = getPhysicalWidth();
    int expectedH = getPhysicalHeight();
    if (expectedW <= 1 || expectedH <= 1) {
      return false; // panel itself is not yet sized; nothing better to compare against
    }
    return frame.getWidth() < expectedW / 2 || frame.getHeight() < expectedH / 2;
  }



  /**
   * If the panel initialization has achieved, triggers an offscreen rendering from the AWT thread,
   * hence happening asynchronously.
   */
  @Override
  public void display() {

    // Skip potential too early calls to display to avoid exceptions
    if (!offscreen.isInitialized()) {
      return;
    }

    // Indicates we started to render
    setRendering(true);

    // Start monitoring
    getMonitoring().onDisplay();

    // Does the actual work of rendering
    offscreen.onDisplay(this, listener);

    // setRendering(false) will be invoked when painting is done
  }


  /**
   * The {@link ResizeHandler} will trigger rendering on the main macOS thread and then trigger
   * repaint by the thread selected by {@link ThreadRedirect} attached to the
   * {@link OffscreenRenderer}.
   */
  protected class ResizeHandler extends ComponentAdapter {
    @Override
    public void componentResized(ComponentEvent e) {

      // Skip rendering if we are already in the middle of rendering
      // the previous frame
      if (isRendering()) {
        // System.err.println("GLCanvasSwing : SKIP RENDER");
        return;
      }
      // Otherwise indicates that we start to render and do the
      // job required for resizing.
      else {

        // Get the new dimensions
        Dimension size = e.getComponent().getSize();
        int w = (int) Math.round(size.getWidth());
        int h = (int) Math.round(size.getHeight());

        Debug.debug(debug, this.getClass(), "resizing to " + w + "x" + h);

        setRendering(true);

        getMonitoring().onStartRendering();

        // FBO is dimensioned in physical pixels when HiDPI is enabled, in logical pixels
        // otherwise. paintComponent always blits using getWidth()/getHeight() (logical).
        PixelScale s = pixelScaleSupport.read();
        int physW = hiDPIEnabled ? (int) Math.round(w * s.x()) : w;
        int physH = hiDPIEnabled ? (int) Math.round(h * s.y()) : h;
        offscreen.onResize(GLCanvasSwing.this, listener, 0, 0, physW, physH);

        // setRendering(false) will be invoked when painting is done
      }
    }
  }

  /**
   * Return true if the offscreen renderer has been initialized, which means that this panel has
   * been added to a parent component.
   */
  @Override
  public boolean isInitialized() {
    return offscreen.isInitialized();
  }


  /** Return true if display has started but has not yet finished */
  @Override
  public boolean isRendering() {
    return rendering.get();
  }

  protected void setRendering(boolean status) {
    rendering.set(status);
  }

  /* ===================================================== */
  //
  // BASIC PERFORMANCE MONITORING AND REPORTING

  /**
   * Show performance in a 2D text overlay.
   */
  protected void overlayPerformance(Graphics g) {
    if (overlay != null)
      overlay.paint(g);
  }

  /* ===================================================== */
  //
  // FROM GL AUTO DRAWABLE INTERFACE


  @Override
  public GLEventListener getGLEventListener() {
    return listener;
  }

  @Override
  public void setGLEventListener(GLEventListener glEvents) {
    this.listener = glEvents;
  }

  @Override
  public GL getGL() {
    return offscreen.getGL();
  }

  @Override
  public GLContext getContext() {
    return offscreen.getContext();
  }

  /* ===================================================== */

  @Override
  public Image<?> getScreenshot() {
    if (out == null) {
      return null;
    }
    return new AWTImage(ImageUtils.copy(out));
  }

  /**
   * Update the image to be displayed.
   * 
   * Should not be used by anything else than offscreen rendering.
   * 
   * TODO : make method name clearer and visibility hidden?
   */
  @Override
  public void setScreenshot(Image<?> image) {
    if (image != null)
      out = ((AWTImage) image).getImage();
  }

  @Override
  public RenderCounter getMonitoring() {
    return counter;
  }

  public void setMonitoring(RenderCounter counter) {
    this.counter = counter;
  }


  @Override
  public OffscreenRenderer getOffscreenRenderer() {
    return offscreen;
  }

  @Override
  public void setOffscreenRenderer(OffscreenRenderer offscreen) {
    this.offscreen = offscreen;
  }

  @Override
  public Flip getFlip() {
    return flip;
  }

  @Override
  public void setFlip(Flip flip) {
    this.flip = flip;
  }

  /* ===================================================== */

  public FBO getFBO() {
    return offscreen.getFBO();
  }

  public void setFBO(FBO fbo) {
    this.offscreen.setFBO(fbo);
  }

  public boolean isShowRenderingTime() {
    return debugPerf;
  }

  public void setShowRenderingTime(boolean status) {
    this.debugPerf = status;
  }

  /* ===================================================== */
  // HiDPI / pixel scale

  @Override
  public PixelScale getPixelScale() {
    return pixelScaleSupport != null ? pixelScaleSupport.read() : PixelScale.IDENTITY;
  }

  @Override
  public int getPhysicalWidth() {
    return hiDPIEnabled ? (int) Math.round(getWidth() * getPixelScale().x()) : getWidth();
  }

  @Override
  public int getPhysicalHeight() {
    return hiDPIEnabled ? (int) Math.round(getHeight() * getPixelScale().y()) : getHeight();
  }

  @Override
  public void addPixelScaleListener(PixelScaleListener l) {
    pixelScaleSupport.addListener(l);
  }

  @Override
  public void removePixelScaleListener(PixelScaleListener l) {
    pixelScaleSupport.removeListener(l);
  }

  @Override
  public boolean isHiDPIEnabled() {
    return hiDPIEnabled;
  }

  @Override
  public void setHiDPIEnabled(boolean enabled) {
    if (this.hiDPIEnabled == enabled) {
      return;
    }
    this.hiDPIEnabled = enabled;
    onPixelScaleChanged();
  }

  /** Test/diagnostics access to the pixel-scale support. */
  public PixelScaleSupportAWT getPixelScaleSupport() {
    return pixelScaleSupport;
  }
}
