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
package panamagl.offscreen;

import java.awt.EventQueue;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import panamagl.Debug;
import panamagl.GLCanvas;
import panamagl.GLEventListener;
import panamagl.GLProfile;
import panamagl.Image;
import panamagl.factory.PanamaGLFactory;
import panamagl.opengl.GL;
import panamagl.opengl.GLContext;
import panamagl.opengl.GLError;

public class AOffscreenRenderer implements OffscreenRenderer {

  protected boolean debug = Debug.check(AOffscreenRenderer.class);
  protected String debugFile = null;
  /** Only used to export debug images if a debug file is given */
  protected ExecutorService exec = Executors.newSingleThreadExecutor();
  protected PanamaGLFactory factory;
  protected GL gl;
  protected GLContext context;
  protected FBO fbo;
  protected boolean initialized = false;
  protected static final int INIT_FBO_WIDTH = 10;
  protected static final int INIT_FBO_HEIGHT = 10;
  int k = 0;


  public AOffscreenRenderer(PanamaGLFactory factory) {
    this.factory = factory;
  }

  // -------------------------------------------------------------

  @Override
  public void onInit(GLCanvas drawable, GLEventListener listener) {
    Runnable r = getTask_initContext(listener);
    
    executeFromAWTMainThread(r);
  }

  @Override
  public void onDisplay(GLCanvas drawable, GLEventListener listener) {
    Runnable r = getTask_renderGLToImage(drawable, listener, drawable.getWidth(), drawable.getHeight());
    
    executeFromAWTMainThread(r);
  }

  /** 
   * Ensure the task is executed by the AWT Event Thread.
   * OpenGL being single threaded, we need to always perform rendering queries from the same UI thread. */
  protected void executeFromAWTMainThread(Runnable r) {
    // If we are already in AWT thread, just run
    if (EventQueue.isDispatchThread()) {
        r.run();
    }
    // Otherwise, push the request to AWT
    else {
      try {
        EventQueue.invokeAndWait(r);
      } catch (InvocationTargetException | InterruptedException e) {
        e.printStackTrace();
      }      
    }
  }

  @Override
  public void onResize(GLCanvas drawable, GLEventListener listener, int x, int y, int width, int height) {
    Runnable r = getTask_renderGLToImage(drawable, listener, drawable.getWidth(), drawable.getHeight());
    
    executeFromAWTMainThread(r);
  }
  @Override
  public void onDestroy(GLCanvas drawable, GLEventListener glEventListener) {
    destroyContext();
  }

  // -------------------------------------------------------------

  /**
   * In general, you should initialize any resources that are needed for rendering or other
   * functionality in the JPanel after the JPanel has been added to the Swing hierarchy, but before
   * it is made visible. This ensures that the JPanel has a valid parent container and can be
   * properly displayed on the screen.
   * 
   * On macOS, this should be performed in the main thread
   * <ul>
   * <li>By using -XstartOnMainThread (but warning with Swing and JavaFX that may be hanging)
   * <li>By having the context initialization performed by the AWT thread (through the
   * GLPanel+GLEventListener)
   * </ul>
   */
  protected void initContext(GLEventListener listener) {
    Debug.debug(debug, "AOffscreenRenderer : initContext");

    // counter = new RenderCounter();

    // GL Context init
    context = factory.newGLContext();

    Debug.debug(debug, "AOffscreenRenderer : initContext : Got GLContext : " + context);

    // OpenGL init
    this.gl = factory.newGL();
    GLError.checkAndThrow(gl);
    
    
    GLProfile profile = new GLProfile(gl);
    context.setProfile(profile);
    

    Debug.debug(debug, "AOffscreenRenderer : initContext : Got GL : " + gl);

    // FBO init
    this.fbo = factory.newFBO(INIT_FBO_WIDTH, INIT_FBO_HEIGHT);
    this.fbo.prepare(gl);

    Debug.debug(debug, "AOffscreenRenderer : initContext : Got FBO : " + fbo);

    // --------------------------------------
    // Invoke GLEventListener.init(..)
    if (listener != null) {
      listener.init(gl);

      // Not needed, only needed if we use GLUT MAIN LOOP
      // glutContext.glutDisplayFunc(this::invokeDisplay);
    }

    // Mark as ready for display
    initialized = true;
  }

  protected void destroyContext() {
    factory.destroyContext();

    initialized = false;
  }

  /**
   * This method will resize the FBO and then update the component
   * 
   * @see {@link #renderGLToImage()}
   */
  protected void renderGLToImage(GLCanvas canvas, GLEventListener listener, int width,
      int height) {
    Debug.debug(debug, "------------------------------------------------------");
    Debug.debug(debug, "AOffscreenRenderer : renderGLToImage " + width + " x " + height);

    fbo.release(gl);
    fbo.resize(width, height);
    fbo.prepare(gl);

    Debug.debug(debug, "Resized FBO to " + width + " x " + height);

    if (listener != null)
      listener.reshape(gl, 0, 0, width, height);

    renderGLToImage(canvas, listener);
  }

  /**
   * This method will render in FBO and then query a component repaint to ensure it is repainted
   * ONCE the image is available.
   * 
   * This method can potentially execute in a separate thread (namely the main macOS thread) and
   * hence triggers repaint through SwingUtilities.invokeLater()
   */
  protected void renderGLToImage(GLCanvas canvas, GLEventListener listener) {

    // Render GL
    if (listener != null)
      listener.display(gl);


    // FBO To image
    if (fbo != null) {
      Image<?> out = fbo.getImage(gl);
      // System.gc();

      //if (out == null)
      //  throw new RuntimeException("FBO returned a null image!");

      // Give back the image to the onscreen panel
      canvas.setScreenshot(out);


      // The image has been rendered in macOS main thread,
      // now we want to notify the component that it is ready
      // for rendering in the AWT Thread

      canvas.repaint();
      
      /*if (!SwingUtilities.isEventDispatchThread()) {
        canvas.repaint();
      } else {
        SwingUtilities.invokeLater(new Runnable() {
          @Override
          public void run() {
            canvas.repaint();
          }
        });*/
      //}

      /*if (debugFile != null) {
        exec.execute(getTask_saveImage(out, debugFile + "-" + (k++) + ".png"));
      }*/
    } else {
      System.err.println("FBO is null!");
    }
  }

  @Override
  public boolean isFlipY() {
    return fbo.isFlipY();
  }

  /**
   * Sets if image will be flipped vertically while being painted.
   */
  @Override
  public void setFlipY(boolean flipY) {
    this.fbo.setFlipY(flipY);
  }

  @Override
  public FBO getFBO() {
    return fbo;
  }

  @Override
  public void setFBO(FBO fbo) {
    this.fbo = fbo;
  }

  @Override
  public String getDebugFile() {
    return debugFile;
  }

  /** Indicates if the renderer has already been initialized. */
  @Override
  public boolean isInitialized() {
    return initialized;
  }

  @Override
  public GL getGL() {
    return gl;
  }

  @Override
  public GLContext getContext() {
    return context;
  }


  /**
   * If not null, the input pattern will be used to save offscreen generated image to disk.
   * 
   * Example setDebugFile("target/glpanel");
   * 
   * Creates images in target/ folder under anme glpanel-1.png, glpanel-2.png, etc.
   */
  @Override
  public void setDebugFile(String debugFile) {
    if (exec == null) {
      exec = Executors.newSingleThreadExecutor();
    }
    this.debugFile = debugFile;
  }

  // -------------------------------------------------------------

  protected Runnable getTask_renderGLToImage(GLCanvas drawable, GLEventListener listener, int width,
      int height) {
    return new Runnable() {
      @Override
      public void run() {
        renderGLToImage(drawable, listener, width, height);
      }
    };
  }

  protected Runnable getTask_renderGLToImage(GLCanvas drawable, GLEventListener listener) {
    return new Runnable() {
      @Override
      public void run() {
        renderGLToImage(drawable, listener);
      }
    };
  }

  protected Runnable getTask_initContext(GLEventListener listener) {
    return new Runnable() {
      @Override
      public void run() {
        initContext(listener);
      }
    };
  }

  /*protected Runnable getTask_saveImage(BufferedImage image, String file) {
    return new Runnable() {
      @Override
      public void run() {
        ImageUtils.save(image, file);
      }
    };
  }*/
  
  

}
