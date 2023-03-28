/*******************************************************************************
 * Copyright (c) 2022, 2023 Martin Pernollet & contributors.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301, USA
 *******************************************************************************/
package panamagl.canvas;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.image.BufferedImage;
import java.util.concurrent.atomic.AtomicBoolean;
import panamagl.Debug;
import panamagl.GLCanvas;
import panamagl.GLEventListener;
import panamagl.Image;
import panamagl.factory.PanamaGLFactory;
import panamagl.offscreen.FBO;
import panamagl.offscreen.FBOReader_AWT;
import panamagl.offscreen.OffscreenRenderer;
import panamagl.opengl.GL;
import panamagl.opengl.GLContext;
import panamagl.performance.PerformanceOverlay;
import panamagl.performance.RenderCounter;
import panamagl.utils.GraphicsUtils;
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
 * Hint : to debug this class, invoke a program using it with flag -Dpanamagl.GLPanel
 * 
 * @author Martin Pernollet
 *
 */
public class GLCanvasAWT extends Panel implements GLCanvas {
  private static final long serialVersionUID = -4601832524814661585L;

  protected GLEventListener listener;
  protected OffscreenRenderer offscreen;
  protected BufferedImage out = null;

  protected AtomicBoolean rendering = new AtomicBoolean();
  protected RenderCounter counter = new RenderCounter();
  protected PerformanceOverlay overlay;

  protected boolean debug = Debug.check(GLCanvasAWT.class);
  protected boolean debugPerf = true;


  /**
   * Initialize a panel able to render OpenGL through a {@link GLEventListener} and related
   * {@link GL} interface.
   */
  public GLCanvasAWT(PanamaGLFactory factory) {
	this.offscreen = factory.newOffscreenRenderer(new FBOReader_AWT());
    this.overlay = new PerformanceOverlay(this);

    // Load OSXUtil native as soon as possible for macOS!
    // GLProfile.initSingleton();

    // Show debug info
    if (debug)
      GraphicsUtils.printGraphicsEnvironment(this.getClass().getSimpleName());

    // This listener hold the most important part of the rendering flow
    addComponentListener(new ResizeHandler());
  }



  /* ===================================================== */
  //
  // AWT OVERRIDES





/**
   * Called after the JPanel has been added to the Swing hierarchy but before it is made visible.
   * 
   * Initialization may occur in other threads and not be completed when this method returns.
   * 
   * To ensure the component is initialized, call {@link #ini
   */
  @Override
  public void addNotify() {
    super.addNotify();

    // Initialize GL context from main macOS thread
    offscreen.onInit(this, listener);
  }

  /**
   * Called before the JPanel is removed from the Swing hierarchy.
   */
  @Override
  public void removeNotify() {
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
    counter.onUpdate();
    super.update(g);
  }

  /**
   * Invoked only for redraw query that are not coalesced with other redraw queries by the AWT Event
   * Queue.
   * 
   * Render GL image and stop counting elapsed time for rendering (started at {@link #display()})
   * 
   * @see {@link #paint()}
   */
  @Override
  public void paint(Graphics g) {
//  super.paint(g);
    
    counter.onPaint();
  
    if (out != null) {
      g.drawImage(out, 0, 0, null);

      counter.onPaintComponentBefore();

      if (debugPerf)
        overlayPerformance(g);

      rendering.set(false);
    }
  }

  /**
   * If the panel initialization has achieved, this triggers an offscreen rendering, maybe on a
   * separated thread (macOS case), from which an asynchronous repaint will be triggered.
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
    counter.onDisplay();

    // Does the actual work of rendering
    offscreen.onDisplay(this, listener);
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

  /**
   * The {@link ResizeHandler} will trigger rendering on the main macOS thread and then trigger
   * repaint through {@link SwingUtilities.invokeLater()}.
   */
  protected class ResizeHandler extends ComponentAdapter {
    @Override
    public void componentResized(ComponentEvent e) {

      // Get the new dimensions
      Dimension size = e.getComponent().getSize();
      int w = (int) Math.round(size.getWidth());
      int h = (int) Math.round(size.getHeight());

      Debug.debug(debug, this.getClass(), "resizing to " + w + "x" + h);


      // Skip rendering we are already in the middle of rendering
      // the previous frame
      if (isRendering()) {
        return;
      } 
      
      // Otherwise indicates that we start to render and do the 
      // job required for resizing.
      else {
        setRendering(true);

        getMonitoring().onStartRendering();

        offscreen.onResize(GLCanvasAWT.this, listener, 0, 0, w, h);
      }
    }
  }

  /* ===================================================== */
  //
  // BASIC PERFORMANCE MONITORING AND REPORTING

  /**
   * Show performance in a 2D text overlay.
   */
  protected void overlayPerformance(Graphics g) {
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

  // should not be used by anything else than backend
  @Override
  public void setScreenshot(Image<?> image) {
    out = ((AWTImage)image).getImage();
  }

  /* ===================================================== */


  /**
   * Indicates if image will be flipped vertically while being painted.
   * 
   * @return
   */
  public boolean isFlipY() {
    return offscreen.isFlipY();
  }

  /**
   * Sets if image will be flipped vertically while being painted.
   */
  public void setFlipY(boolean flipY) {
    this.offscreen.setFlipY(flipY);
  }

  public FBO getFBO() {
    return offscreen.getFBO();
  }

  public void setFBO(FBO fbo) {
    this.offscreen.setFBO(fbo);
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
  
  


}
