/*******************************************************************************
 * Copyright (c) 2023 Martin Pernollet and others
 *
 * This program and the accompanying materials are made available under the terms of the Eclipse
 * Public License 2.0 which is available at http://www.eclipse.org/legal/epl-2.0.
 *
 * This Source Code may also be made available under the following Secondary Licenses when the
 * conditions for such availability set forth in the Eclipse Public License, v. 2.0 are satisfied:
 * GNU General Public License, version 2 with the GNU Classpath Exception which is available at
 * https://www.gnu.org/software/classpath/license.html.
 *
 * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
 ********************************************************************************/
package panamagl.canvas.swt;

import java.util.concurrent.atomic.AtomicBoolean;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.graphics.Transform;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import panamagl.GLEventListener;
import panamagl.factory.PanamaGLFactory;
import panamagl.image.SWTImage;
import panamagl.offscreen.FBO;
import panamagl.offscreen.FBOReader_SWT;
import panamagl.offscreen.OffscreenRenderer;
import panamagl.offscreen.ThreadRedirect;
import panamagl.offscreen.ThreadRedirect_SWT;
import panamagl.opengl.GL;
import panamagl.opengl.GLContext;
import panamagl.performance.RenderCounter;

/**
 * An SWT {@link Canvas} that renders OpenGL offscreen via FBO and paints the result as an image.
 *
 * Unlike {@link GLCanvasSWT_direct} which uses SWT's native {@code GLCanvas} with a real GL context, this
 * canvas uses the {@link OffscreenRenderer} pipeline (FBO rendering + pixel readback) consistent
 * with the Swing and JavaFX offscreen canvases.
 *
 * The rendering pipeline is:
 * <ol>
 * <li>{@link #display()} triggers {@link OffscreenRenderer#onDisplay}</li>
 * <li>{@link ThreadRedirect_SWT} routes to the appropriate thread</li>
 * <li>FBO render + {@link FBOReader_SWT#read} produces a {@link SWTImage}</li>
 * <li>{@link #setScreenshot} stores the image and calls {@link #redraw()}</li>
 * <li>SWT Paint event draws the {@link ImageData} to screen via {@link GC}</li>
 * </ol>
 */
public class GLCanvasSWT extends Canvas implements panamagl.canvas.GLCanvas {

  protected PanamaGLFactory factory;
  protected GLEventListener listener;
  protected OffscreenRenderer offscreen;
  protected SWTImage out;
  protected RenderCounter counter = new RenderCounter();
  protected AtomicBoolean rendering = new AtomicBoolean();
  protected Flip flip = Flip.VERTICAL;
  protected Color color;

  public GLCanvasSWT(Composite parent, int style, PanamaGLFactory factory) {
    super(parent, style | SWT.NO_BACKGROUND);

    this.factory = factory;

    Display display = parent.getDisplay();

    // Set up the offscreen renderer with SWT-specific reader and thread redirect
    this.offscreen = factory.newOffscreenRenderer(new FBOReader_SWT());
    this.offscreen.setThreadRedirect(new ThreadRedirect_SWT(display));

    // Paint listener: draw the current screenshot to the canvas
    addListener(SWT.Paint, event -> {
      paintComponentNow(event.display, event.gc);
    });

    // Resize listener: notify offscreen renderer of new dimensions
    addListener(SWT.Resize, new ResizeHandler());

    // Dispose listener: clean up offscreen resources
    addDisposeListener(_ -> {
      offscreen.onDestroy(GLCanvasSWT.this, listener);
    });
  }
  

  /**
   * Render GL image and stop counting elapsed time for rendering (started at {@link #display()}).
   * 
   * Equivalent to GLCanvasSwing.paintComponent(..)
   */
  protected void paintComponentNow(Display display, GC gc) {
    if (out != null) {
      
      ImageData imageData = out.getImage();
      
      if (imageData != null) {
        Image swtImage = new Image(display, imageData);
        try {
          
          
          // Standard
          if (flip == null || Flip.NONE.equals(flip)) {
            gc.drawImage(swtImage, 0, 0, imageData.width, imageData.height, 0, 0, getWidth(), getHeight());
          } 
          
          // vertical flip
          else if (Flip.VERTICAL.equals(flip)) {
            Transform transform = new Transform(display);
            try {
              transform.setElements(1, 0, 0, -1, 0, getHeight());
              gc.setTransform(transform);
              gc.drawImage(swtImage, 0, 0, imageData.width, imageData.height, 0, 0, getWidth(), getHeight());
              gc.setTransform(null);
            } finally {
              transform.dispose();
            }
          } 
          
          // horizontal flip
          else if (Flip.HORIZONTAL.equals(flip)) {
            Transform transform = new Transform(display);
            try {
              transform.setElements(-1, 0, 0, 1, getWidth(), 0);
              gc.setTransform(transform);
              gc.drawImage(swtImage, 0, 0, imageData.width, imageData.height, 0, 0, getWidth(), getHeight());
              gc.setTransform(null);
            } finally {
              transform.dispose();
            }
          }
        } finally {
          swtImage.dispose();
        }

        getMonitoring().onPaintComponentBefore();
        rendering.set(false);
      }
    }
  }

  // ---------------------------------------------------------------
  // GLCanvas interface
  // ---------------------------------------------------------------

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
   * The {@link ResizeHandler} will trigger rendering on the main macOS thread 
   * and then trigger repaint by the thread selected by {@link ThreadRedirect} 
   * attached to the {@link OffscreenRenderer}.
   */
  protected class ResizeHandler implements Listener{

    @Override
    public void handleEvent(Event event) {
      if (isDisposed() || !offscreen.isInitialized()) {
        return;
      }
      
      // Skip rendering if we are already in the middle of rendering
      // the previous frame
      if (isRendering()) {
        return;
      }
      
      // Otherwise indicates that we start to render and do the 
      // job required for resizing.
      else {
        Rectangle bounds = getBounds();
        
        setRendering(true);
        
        counter.onStartRendering();
        
        offscreen.onResize(GLCanvasSWT.this, listener, 0, 0, bounds.width, bounds.height);
        
        // setRendering(false) will be invoked when painting is done        
      }
    }
    
  }

  
  @Override
  public boolean isInitialized() {
    return offscreen.isInitialized();
  }

  @Override
  public boolean isRendering() {
    return rendering.get();
  }

  protected void setRendering(boolean value) {
    rendering.set(value);
  }

  @Override
  public GLEventListener getGLEventListener() {
    return listener;
  }

  @Override
  public void setGLEventListener(GLEventListener listener) {
    this.listener = listener;
    
    offscreen.onInit(this, listener);
  }

  @Override
  public GL getGL() {
    return offscreen.getGL();
  }

  @Override
  public GLContext getContext() {
    return offscreen.getContext();
  }

  @Override
  public RenderCounter getMonitoring() {
    return counter;
  }

  @Override
  public int getWidth() {
    return getBounds().width;
  }

  @Override
  public int getHeight() {
    return getBounds().height;
  }

  @Override
  public void repaint() {
    if (!isDisposed()) {
      redraw();
    }
  }

  /**
   * Update the image to be displayed.
   *  
   * Should not be used by anything else than offscreen rendering.
   * 
   * TODO : make method name clearer and visibility hidden?
   */
  @Override
  public void setScreenshot(panamagl.Image<?> image) {
    this.out = (SWTImage) image;
    
    counter.onPaint();
    if (!isDisposed()) {
      redraw();
    }
  }

  @Override
  public panamagl.Image<?> getScreenshot() {
    return out;
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

  public FBO getFBO() {
    return offscreen.getFBO();
  }

  public void setFBO(FBO fbo) {
    this.offscreen.setFBO(fbo);
  }
}
