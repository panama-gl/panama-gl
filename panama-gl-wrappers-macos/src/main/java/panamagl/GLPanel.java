package panamagl;

import java.awt.BufferCapabilities;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.ImageCapabilities;
import java.awt.Transparency;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.image.BufferedImage;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import org.jzy3d.maths.TicToc;
import com.jogamp.opengl.GLProfile;
import jogamp.nativewindow.macosx.OSXUtil;
import opengl.GL;
import opengl.GLContext;
import opengl.GLError;
import opengl.cgl.macos.CGLContext;
import opengl.fbo.FBO;
import opengl.glut.macos.GLUTContext_macOS_10_15_7;
import opengl.macos.GL_macOS_10_15_7;

/**
 * This panel push to the screen an OpenGL image rendered offscreen by an {@link FBO}.
 * 
 * The panel mainly deals with
 * <ul>
 * <li>OpenGL context initialization, after the panel is added to a parent, and before it is made
 * visible.</li>
 * <li>repaint and resize events that are propagated to the OpenGL application through a
 * {@link GLEventListener}, which must be provided by the user of this panel through
 * {@link #setGLEventListener(GLEventListener)}.</li>
 * </ul>
 * 
 * <h2>Threading</h2>
 * The panel is also reponsible for triggering OpenGL initialization and rendering in the
 * appropriate threads, which may depend on the running operating system.
 * 
 * <h3>Threading on macOS</h3>
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
public class GLPanel extends JPanel implements GLAutoDrawable {
  private static final long serialVersionUID = -4601832524814661585L;

  protected GL gl;
  protected GLEventListener glListener;
  protected CGLContext cglContext;
  protected GLUTContext_macOS_10_15_7 glutContext;
  protected FBO fbo;

  protected BufferedImage out = null;

  protected boolean useCGL = false;
  protected boolean useGLUT = true;
  
  protected boolean debug = Debug.check(GLPanel.class);
  
  protected String debugFile = null;//"target/glpanel";
  
  protected TicToc renderTimer = new TicToc();
  protected TicToc paintInterval = new TicToc();
  
  protected ExecutorService exec = Executors.newSingleThreadExecutor();


  public GLPanel() {
    GraphicsUtils.printGraphicsEnvironment("GLPanel");
    
    // This listener hold the most important part of the rendering flow
    addComponentListener(new ResizeHandler());
  }
  
  

  
  /* ===================================================== */
  // AWT OVERRIDES


  /**
   * Called after the JPanel has been added to the Swing hierarchy but before it is made visible.
   */
  @Override
  public void addNotify() {
    super.addNotify();

    // Initialize GL context from main macOS thread
    initContext_OnMainThread();
  }

  /**
   * Called before the JPanel is removed from the Swing hierarchy.
   */
  @Override
  public void removeNotify() {
    destroyContext();
    
    super.removeNotify();
  }
  
  /** 
   * Invoked each time redraw should be performed, even if the redraw query is coalesced with other redraw 
   * queries by the AWT Event Queue. 
   * 
   * @see {@link #update()}
   */
  @Override
  public void update(Graphics g) {
    countUpdate++;
    super.update(g);
  }
  


  /** 
   * Invoked only for redraw query that are not coalesced with other redraw queries by the AWT Event Queue. 
   * 
   * @see {@link #paint()}
   */
  @Override
  public void paint(Graphics g) {
    countPaint++;
    super.paint(g);
  }

  
  @Override
  public void paintComponent(Graphics g) {
    if (out != null) {
      g.drawImage(out, 0, 0, null);
      
      overlayPerformance(g);
    }
  }

  
  /**
   * The {@link ResizeHandler} will trigger rendering on the main macOS thread
   * and then trigger repaint through SwingUtilities.invokeLater.
   * 
   * @author Martin Pernollet
   *
   */
  protected class ResizeHandler extends ComponentAdapter{
    @Override
    public void componentResized(ComponentEvent e) {
      super.componentResized(e);

      Dimension size = e.getComponent().getSize();

      int w = (int) Math.round(size.getWidth());
      int h = (int) Math.round(size.getHeight());

      Debug.debug(debug, "GLPanel resize to " + w + "x" + h);

      if (fbo != null) {

        renderTimer.tic();
        
        // wait=true causes deadlocks! So we do not wait
        // and then ask the rendering to asynchronously notify
        // this panel that a repaint should occur.
        boolean wait = false; 

        renderGLToImage_OnMainThread(w, h, wait, true);

        // here we need a callback to invoke repaint, otherwise we are always one frame late!
        // if resize too fast, we see that we display the previous image.
        //
        // Hence, following method is useless
        // paintComponent(getGraphics());

      }
    }
  }
  
  /** Show performance in a 2D text overlay. */
  protected void overlayPerformance(Graphics g) {
    // Overlay performance info
    g.setColor(Color.GRAY);

    // -------------------------------------------------
    // Interval between rendering query and repaint achieved. The real rendering time during which OpenGL worked.
    renderTimer.toc();
    int renderTimeMs = (int)Math.round(renderTimer.elapsedMilisecond());
    
    g.drawString("Render time : " + renderTimeMs + "ms", x, getHeight()-yRenderTimeInterval);
    
    // -------------------------------------------------
    // Interval between two repaint, which show how we stress the AWT Event Queue
    // https://github.com/jzy3d/jzy3d-api/tree/master/jzy3d-emul-gl-awt#integrating-in-awt
    paintInterval.toc();
    int paintIntervalMs = (int)Math.round(paintInterval.elapsedMilisecond());

    // Highlight render time longer than paint interval
    if(paintIntervalMs < renderTimeMs)
      g.setColor(Color.ORANGE);
    
    g.drawString("Paint interval : " + paintIntervalMs + "ms", x, getHeight()-yPaintInterval);

    paintInterval.tic();
    
    // -------------------------------------------------
    // Count coalesced events.
    
    int prev = countDiff;
    countDiff =  countDisplay-countPaint;

    // Highlight when count display vs paint differ
    if(prev!=countDiff){
      g.setColor(Color.ORANGE);      
    }
    else {
      g.setColor(Color.GRAY);
    }
    
    g.drawString("Paint events : " + countPaint + " / Display events : " + countDisplay + " / Diff : " + countDiff + " / Update events : " + countUpdate, x, getHeight()-yCountCoalesced);

  }  
  
  int countUpdate = 0;
  int countPaint = 0;
  int countDisplay = 0;
  int countDiff = 0;
  
  int x = 10;
  int yPaintInterval = 5;
  int yCountCoalesced = 25;
  int yRenderTimeInterval = 45;

  /* ===================================================== */
  // FROM GL AUTO DRAWABLE INTERFACE
  
  @Override
  public void display() {
    countDisplay++;
    
    renderTimer.tic();

    // FIXME : why does it work with this
    renderGLToImage_OnMainThread(getWidth(), getHeight(), false, true);
    // FIXME : and not with this?
    //renderGLToImage_OnMainThread(false, true);
  }
  




  @Override
  public GLEventListener getGLEventListener() {
    return glListener;
  }

  @Override
  public void setGLEventListener(GLEventListener glEvents) {
    this.glListener = glEvents;
  }
  
  @Override
  public GL getGL() {
    return gl;
  }
  
  @Override
  public GLContext getContext() {
    return glutContext;
  }
  
  /* ===================================================== */

  
  public BufferedImage getScreenshot() {
    if(out==null) {
      return null;
    }
    return ImageUtils.copy(out);
  }
  
  public String getDebugFile() {
    return debugFile;
  }


  public void setDebugFile(String debugFile) {
    this.debugFile = debugFile;
  }

  /* ===================================================== */

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
  protected void initContext() {
    System.out.println("GLPanel : initContext");

    // --------------------------------------
    // A GL Context with CGL
    if (useCGL) {
      cglContext = new CGLContext();
      cglContext.init();
      Debug.debug(debug, "GLPanel : initContext : CGL done");
    }

    // --------------------------------------
    // A GL Context with GLUT
    // - hanging while ONSCREEN
    // - not generating FBO properly if omitted
    if (useGLUT) {
      glutContext = new GLUTContext_macOS_10_15_7();
      glutContext.init(false); // do not init GLUT a second time
      Debug.debug(debug, "GLPanel : initContext : GLUT done");
    }

    // --------------------------------------
    // OpenGL
    this.gl = new GL_macOS_10_15_7();

    GLError.checkAndThrow(gl);

    // FBO
    this.fbo = new FBO(getFBOWidth(), getFBOHeight());
    this.fbo.prepare(gl); 
    
    Debug.debug(debug, "GLPanel : initContext : FBO done");

    // --------------------------------------
    // Invoke GLEventListener.init(..)
    if(glListener!=null) {
      glListener.init(gl);
      
      // Not needed, only needed if we use GLUT MAIN LOOP 
      //glutContext.glutDisplayFunc(this::invokeDisplay);
    }
  }
  
  
  protected void invokeDisplay() {
    if(glListener!=null) {
      glListener.display(gl);
    }
  }

  protected int getFBOHeight() {
    return (int) Math.max(800, this.getHeight());
  }

  protected int getFBOWidth() {
    return (int) Math.max(600, this.getWidth());
  }
  
  protected void destroyContext() {
    // Clean up CGL context
    if (cglContext != null)
      cglContext.destroy();
  }



  /**
   * This method will resize the FBO and then update the component 
   * 
   * @see {@link #renderGLToImage()}
   */
  protected void renderGLToImage(int width, int height) {
    Debug.debug(debug, "------------------------------------------------------");
    Debug.debug(debug, "renderGLToImage " + width + " x " + height);

    fbo.release(gl);
    fbo.resize(width, height);
    fbo.prepare(gl);

    Debug.debug(debug, "Resized FBO to " + width + " x " + height);

    if (glListener != null)
      glListener.reshape(gl, 0, 0, width, height);

    renderGLToImage();
  }

  /**
   * This method will render in FBO and then query a component repaint to ensure it is repainted
   * ONCE the image is available.
   * 
   * This method can potentially execute in a separate thread (namely the main macOS thread) and hence
   * triggers repaint through SwingUtilities.invokeLater()
   */
  protected void renderGLToImage() {

    // Render GL
    if (glListener != null)
      glListener.display(gl);


    // FBO To image
    if (fbo != null) {
      out = fbo.getImage(gl);
      
      if(out==null)
        System.err.println("OUT image is null!");

      // The image has been rendered in macOS main thread, now we want
      // to notify the component that it is ready for rendering in the AWT Thread
      SwingUtilities.invokeLater(new Runnable() {
        @Override
        public void run() {
          repaint();
        }
      });
      
      if(debugFile!=null) {
        exec.execute(getTask_saveImage(out, debugFile + "-" + (k++) + ".png"));
      }
    }
    else {
      System.err.println("FBO is null!");
    }
  }
  
  int k = 0;

  /* ===================================================== */
  // BELOW FUNC ALLOW EXECUTING IN APPKIT MAIN THREAD
  
  
  protected Runnable getTask_renderGLToImage(int width, int height) {
    return new Runnable() {
      @Override
      public void run() {
        renderGLToImage(width, height);
      }
    };
  }
  
  protected Runnable getTask_renderGLToImage() {
    return new Runnable() {
      @Override
      public void run() {
        renderGLToImage();
      }
    };
  }
  
  protected Runnable getTask_initContext() {
    return new Runnable() {
      @Override
      public void run() {
        initContext();
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

  protected void renderGLToImage_OnMainThread(boolean waitUntilDone,
      boolean kickNSApp) {
    OSXUtil.RunOnMainThread(waitUntilDone, kickNSApp, getTask_renderGLToImage());
  }


  protected void renderGLToImage_OnMainThread(int width, int height, boolean waitUntilDone,
      boolean kickNSApp) {
    OSXUtil.RunOnMainThread(waitUntilDone, kickNSApp, getTask_renderGLToImage(width, height));
  }

  protected void initContext_OnMainThread() {
    // ---------------------------------------------
    // THIS USAGE OF JOGL CLASS SEAMS TO WORK
    // TODO : port/include in panama

    GLProfile.initSingleton();
    OSXUtil.RunOnMainThread(true, false, getTask_initContext());

    // ---------------------------------------------
    // Classical way we should follow
    /*else {
      boolean direct = SwingUtilities.isEventDispatchThread();

      if (direct) {
        System.out.println("GLPanel : direct init");
        initContext();
      }

      // ---------------------------------------------
      else {
        final AtomicBoolean initialized = new AtomicBoolean(false);

        try {
          SwingUtilities.invokeAndWait(new Runnable() {
            public void run() {
              initContext();
              initialized.set(true);
            }
          });
        } catch (InvocationTargetException e) {
          // e.printStackTrace();
        } catch (InterruptedException e) {
          // e.printStackTrace();
        }
      }

    }*/
  }
  
  
  
  public boolean isFlipY() {
    return fbo.isFlipY();
  }

  public void setFlipY(boolean flipY) {
    this.fbo.setFlipY(flipY);
  }

}
