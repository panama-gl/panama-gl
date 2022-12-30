package panamagl;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import com.jogamp.opengl.GLProfile;
import jogamp.nativewindow.macosx.OSXUtil;
import opengl.GL;
import opengl.GLError;
import opengl.cgl.macos.CGLContext;
import opengl.fbo.FBO;
import opengl.glut.macos.GLUTContext_macOS_10_15_7;
import opengl.macos.GL_macOS_10_15_7;

public class GLPanel extends JPanel {
  private static final long serialVersionUID = -4601832524814661585L;

  protected GL gl;
  protected GLEventListener glListener;
  protected CGLContext cglContext;
  protected GLUTContext_macOS_10_15_7 glutContext;
  protected FBO fbo;

  protected BufferedImage out = null;
  
  protected boolean useCGL = true;
  protected boolean useGLUT = true;
  
  public GLPanel() {
    //setPreferredSize(new Dimension(600, 400));

    // Resize FBO on panel resize
    addComponentListener(new ComponentAdapter() {
      @Override
      public void componentResized(ComponentEvent e) {
        super.componentResized(e);

        Dimension size = e.getComponent().getSize();

        int w = (int) Math.round(size.getWidth());
        int h = (int) Math.round(size.getHeight());
        
        if (fbo != null) {
          
          
          //resizeFBOOnMainThread(w, h);

          renderGLToImageOnMainThread();
          
          
        }
      }
    });
  }

  /**
   * Called after the JPanel has been added to the Swing hierarchy but before it is made visible.
   */
  @Override
  public void addNotify() {
    super.addNotify();

    
    // Force context init in main thread.
    initContextOnMainThread();
  }

  /**
   * Called before the JPanel is removed from the Swing hierarchy.
   */
  @Override
  public void removeNotify() {
    // Clean up CGL context
    if (cglContext != null)
      cglContext.destroy();

    super.removeNotify();
  }

  @Override
  public void repaint() {
    //if (cglContext != null)
    //  cglContext.lockContext();


    if (glListener != null) {
      renderGLToImageOnMainThread();
      
      
      //paintComponent(getGraphics());
    }
    
    System.out.println("GLPanel : repaint");
    super.repaint();


  }

  @Override
  public void paintComponent(Graphics g) {
    if (out != null) {
      g.drawImage(out, 0, 0, null);
    }
  }
  
  /* ===================================================== */

  public GLEventListener getGLEventListener() {
    return glListener;
  }

  public void setGLEventListener(GLEventListener glEvents) {
    this.glListener = glEvents;
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
   * <li>By having the context initialization performed by the AWT thread (through the GLPanel+GLEventListener)
   * </ul>
   */
  protected void initContext() {
    System.out.println("GLPanel : initContext");

    // A GL Context with CGL
    if(useCGL) {
      cglContext = new CGLContext();
      cglContext.init();
      System.out.println("GLPanel : initContext : CGL done");
    }
    
    // A GL Context with GLUT
    // - hanging while ONSCREEN
    // - not generating FBO properly if omitted
    if(useGLUT) {
      glutContext = new GLUTContext_macOS_10_15_7();
      glutContext.init(false); // do not init GLUT a second time
      System.out.println("GLPanel : initContext : GLUT done");
    }
    
    // OpenGL
    this.gl = new GL_macOS_10_15_7();

    GLError.checkAndThrow(gl);
    
    // FBO
    this.fbo = new FBO(getFBOWidth(), getFBOHeight());

    this.fbo.prepare(gl); // WEIRD BUT ONLY SUCCEED TO PREPARE AT INIT
    // NOT DURING 
    System.out.println("GLPanel : initContext : FBO done");

    // this.getWidth(), this.getHeight());

    // this.cglContext.makeCurrent();
    // this.cglContext.lockContext();

    // this.fbo.prepare(gl); // NOT NEEDED HERE

    // this.cglContext.release();
  }

  protected int getFBOHeight() {
    return (int) Math.max(800, this.getHeight());
  }

  protected int getFBOWidth() {
    return (int) Math.max(600, this.getWidth());
  }

  protected void renderGLToImage() {
    
    boolean hasNewImage = false;
    
    // Acquire context
    //if (cglContext != null)
    //  cglContext.lockContext();//makeCurrent();

    // Prepare FBO
    //fbo.prepare(gl);
    
    // Render GL
    if(glListener!=null)
      glListener.display(gl);


    // FBO To image
    if(fbo!=null) {
      out = fbo.getImage(gl);
      hasNewImage = true;

      // Release context
      //if (cglContext != null)
      //  cglContext.release();
    }
    
    
    if(hasNewImage) {
      try {
        File debugPath = new File("target/GLPanel.png");
        
        ImageIO.write(out, "png", debugPath);
        System.out.println("GLPanel : saved GLPanel image as " + debugPath.getPath());
      } catch (IOException e) {
        e.printStackTrace();
      }

    }
    
    
  }
  
  /* ===================================================== */

  protected void resizeFBOOnMainThread(int width, int height) {
    OSXUtil.RunOnMainThread(true, false, new Runnable() {
      @Override
      public void run() {
        fbo.resize(width, height); 
        System.out.println("Resized FBO to " + width + " x " + height);

      }
    });
  }

  
  protected void renderGLToImageOnMainThread() {
    OSXUtil.RunOnMainThread(true, false, new Runnable() {
      @Override
      public void run() {
        renderGLToImage();
      }
    });
  }

  protected void initContextOnMainThread() {
    // ---------------------------------------------
    // THIS USAGE OF JOGL CLASS SEAMS TO WORK
    // TODO : port/include in panama
    
    boolean useJOGL = true;
    if(useJOGL) {
      GLProfile.initSingleton();
      OSXUtil.RunOnMainThread(true, false, new Runnable() {
        @Override
        public void run() {
          initContext();
        }
      });
    }
    
    // ---------------------------------------------
    // Classical way we should follow
    else {
      boolean direct = SwingUtilities.isEventDispatchThread();
      
      if(direct) {
        System.out.println("GLPanel : direct init");
        initContext();
        
  
        
      }
      
      // ---------------------------------------------
      else {
        final AtomicBoolean initialized = new AtomicBoolean(false);
  
        /**
         * Causes doRun.run() to be executed synchronously on the AWT event dispatching thread. This
         * call blocks until all pending AWT events have been processed and (then) doRun.run() returns.
         * This method should be used when an application thread needs to update the GUI. It shouldn't
         * be called from the event dispatching thread. Here's an example that creates a new application
         * thread that uses invokeAndWait to print a string from the event dispatching thread and then,
         * when that's finished, print a string from the application thread.
         */
        try {
          SwingUtilities.invokeAndWait(new Runnable() {
            public void run() {
              initContext();
              initialized.set(true);
           }
          });
        } catch (InvocationTargetException e) {
          //e.printStackTrace();
        } catch (InterruptedException e) {
          //e.printStackTrace();
        }
      }
    
    }
  }



}
