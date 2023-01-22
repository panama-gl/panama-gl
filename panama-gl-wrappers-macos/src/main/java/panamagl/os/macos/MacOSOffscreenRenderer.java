package panamagl.os.macos;

import java.awt.image.BufferedImage;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.SwingUtilities;

import com.jogamp.opengl.GLProfile;

import jogamp.nativewindow.macosx.OSXUtil;
import opengl.GL;
import opengl.GLContext;
import opengl.GLError;
import panamagl.Debug;
import panamagl.GLAutoDrawable;
import panamagl.GLEventListener;
import panamagl.OffscreenRenderer;
import panamagl.PanamaGLFactory;
import panamagl.canvas.swing.GLCanvasSwing;
import panamagl.fbo.FBO;
import panamagl.macos.cgl.CGLContext;
import panamagl.macos.gl.GL_macOS_10_15_7;
import panamagl.macos.glut.GLUTContext_macOS_10_15_7;
import panamagl.utils.ImageUtils;

public class MacOSOffscreenRenderer implements OffscreenRenderer{
  protected boolean debug = Debug.check(MacOSOffscreenRenderer.class, GLCanvasSwing.class);
  protected String debugFile = null;// "target/glpanel";
  /** Only used to export debug images if a debug file is given */
  protected ExecutorService exec = Executors.newSingleThreadExecutor();
  
  protected PanamaGLFactory factory;

  protected GL gl;
  protected GLContext context;
  protected CGLContext cglContext;
  protected GLUTContext_macOS_10_15_7 glutContext;
  
  protected FBO fbo;
  
  protected boolean useCGL = false;
  protected boolean useGLUT = true;
  
  protected boolean initialized = false;
  
  protected static final int INIT_FBO_WIDTH = 10;
  protected static final int INIT_FBO_HEIGHT = 10;

  public MacOSOffscreenRenderer(PanamaGLFactory factory) {
    this.factory = factory;
	  
  }
  
  public String getDebugFile() {
    return debugFile;
  }

  /**
   * If not null, the input pattern will be used to save offscreen generated image to disk.
   * 
   * Example setDebugFile("target/glpanel");
   * 
   * Creates images in target/ folder under anme glpanel-1.png, glpanel-2.png, etc.
   * 
   */
  public void setDebugFile(String debugFile) {
    if(exec==null) {
      exec = Executors.newSingleThreadExecutor();
    }
    this.debugFile = debugFile;
  }
  
  /** Indicates if the renderer has already been initialized. */
  @Override
  public boolean isInitialized() {
    return initialized;
  }

  
  public GL getGL() {
    return gl;
  }

  public GLContext getContext() {
    return context;
  }


  @Override
  public void onInit(GLAutoDrawable drawable, GLEventListener listener) {
    initContext_OnMainThread(listener);
    
  }

  @Override
  public void onDisplay(GLAutoDrawable drawable, GLEventListener listener) {
    // FIXME : why does it work with this
    renderGLToImage_OnMainThread(drawable, listener, drawable.getWidth(), drawable.getHeight(), false, true);
    // FIXME : and not with this?
    // renderGLToImage_OnMainThread(false, true);
    
  }

  @Override
  public void onResize(GLAutoDrawable drawable, GLEventListener listener, int x, int y, int width, int height) {
 // wait=true causes deadlocks! So we do not wait
    // and then ask the rendering to asynchronously notify
    // this panel that a repaint should occur.
    boolean wait = false;

    renderGLToImage_OnMainThread(drawable, listener, width, height, wait, true);

    // here we need a callback to invoke repaint, otherwise we are always one frame late!
    // if resize too fast, we see that we display the previous image.
    //
    // Hence, following method is useless
    // paintComponent(getGraphics());    
  }

  @Override
  public void onDestroy(GLAutoDrawable drawable, GLEventListener glEventListener) {
    destroyContext();
  }
  
  // ******************************$
  
  /** */
  
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
    System.out.println("MacOSOffscreenRenderer : initContext");

    //counter = new RenderCounter();

    // GL Context  init
    context = factory.newGLContext();
    
    // OpenGL init
    this.gl = factory.newGL();
    GLError.checkAndThrow(gl);

    // FBO init
    this.fbo = factory.newFBO(INIT_FBO_WIDTH, INIT_FBO_HEIGHT);
    this.fbo.prepare(gl);

    Debug.debug(debug, "MacOSOffscreenRenderer : initContext : FBO done");

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
    /*// Clean up CGL context
    if (cglContext != null)
      cglContext.destroy();

    // Clean up GLUT context
    if (glutContext != null)
      glutContext.destroy();*/
    factory.destroyContext();
    
    initialized = false;
  }

  /**
   * This method will resize the FBO and then update the component
   * 
   * @see {@link #renderGLToImage()}
   */
  protected void renderGLToImage(GLAutoDrawable drawable, GLEventListener listener, int width, int height) {
    Debug.debug(debug, "------------------------------------------------------");
    Debug.debug(debug, "renderGLToImage " + width + " x " + height);

    fbo.release(gl);
    fbo.resize(width, height);
    fbo.prepare(gl);

    Debug.debug(debug, "Resized FBO to " + width + " x " + height);

    if (listener != null)
      listener.reshape(gl, 0, 0, width, height);

    renderGLToImage(drawable, listener);
  }

  /**
   * This method will render in FBO and then query a component repaint to ensure it is repainted
   * ONCE the image is available.
   * 
   * This method can potentially execute in a separate thread (namely the main macOS thread) and
   * hence triggers repaint through SwingUtilities.invokeLater()
   */
  protected void renderGLToImage(GLAutoDrawable drawable, GLEventListener listener) {

    // Render GL
    if (listener != null)
      listener.display(gl);


    // FBO To image
    if (fbo != null) {
      BufferedImage out = fbo.getImage(gl);

      if (out == null)
        throw new RuntimeException("FBO returned a null image!");

      // Give back the image to the onscreen panel
      drawable.setScreenshot(out);
      

      // The image has been rendered in macOS main thread, 
      // now we want to notify the component that it is ready
      // for rendering in the AWT Thread
      SwingUtilities.invokeLater(new Runnable() {
        @Override
        public void run() {
          drawable.repaint();
        }
      });

      if (debugFile != null) {
        exec.execute(getTask_saveImage(out, debugFile + "-" + (k++) + ".png"));
      }
    } else {
      System.err.println("FBO is null!");
    }
  }

  int k = 0;
  
  public boolean isFlipY() {
    return fbo.isFlipY();
  }

  /**
   * Sets if image will be flipped vertically while being painted.
   */
  public void setFlipY(boolean flipY) {
    this.fbo.setFlipY(flipY);
  }

  public FBO getFBO() {
    return fbo;
  }

  public void setFBO(FBO fbo) {
    this.fbo = fbo;
  }
  
  
  /* ===================================================== */
  // BELOW FUNC ALLOW EXECUTING IN APPKIT MAIN THREAD


  protected Runnable getTask_renderGLToImage(GLAutoDrawable drawable, GLEventListener listener, int width, int height) {
    return new Runnable() {
      @Override
      public void run() {
        renderGLToImage(drawable, listener, width, height);
      }
    };
  }

  protected Runnable getTask_renderGLToImage(GLAutoDrawable drawable, GLEventListener listener) {
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

  protected Runnable getTask_saveImage(BufferedImage image, String file) {
    return new Runnable() {
      @Override
      public void run() {
        ImageUtils.save(image, file);
      }
    };
  }

  protected void renderGLToImage_OnMainThread(GLAutoDrawable drawable, GLEventListener listener, boolean waitUntilDone, boolean kickNSApp) {
    OSXUtil.RunOnMainThread(waitUntilDone, kickNSApp, getTask_renderGLToImage(drawable, listener));
  }


  protected void renderGLToImage_OnMainThread(GLAutoDrawable drawable, GLEventListener listener, int width, int height, boolean waitUntilDone,
      boolean kickNSApp) {
    OSXUtil.RunOnMainThread(waitUntilDone, kickNSApp, getTask_renderGLToImage(drawable, listener, width, height));
  }

  protected void initContext_OnMainThread(GLEventListener listener) {
    // ---------------------------------------------
    // THIS USAGE OF JOGL CLASS SEAMS TO WORK
    // TODO : port/include OSXUTil in panama

    GLProfile.initSingleton();
    OSXUtil.RunOnMainThread(true, false, getTask_initContext(listener));

    // ---------------------------------------------
    // Classical way we should follow
    /*
     * else { boolean direct = SwingUtilities.isEventDispatchThread();
     * 
     * if (direct) { System.out.println("GLPanel : direct init"); initContext(); }
     * 
     * // --------------------------------------------- else { final AtomicBoolean initialized = new
     * AtomicBoolean(false);
     * 
     * try { SwingUtilities.invokeAndWait(new Runnable() { public void run() { initContext();
     * initialized.set(true); } }); } catch (InvocationTargetException e) { // e.printStackTrace();
     * } catch (InterruptedException e) { // e.printStackTrace(); } }
     * 
     * }
     */
  }


}
