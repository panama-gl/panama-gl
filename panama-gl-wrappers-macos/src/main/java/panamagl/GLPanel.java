package panamagl;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.image.BufferedImage;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import opengl.GL;
import opengl.GLContext;
import opengl.cgl.macos.CGLContext;
import opengl.fbo.FBO;
import opengl.glut.macos.GLUTContext_macOS_10_15_7;
import opengl.macos.GL_macOS_10_15_7;

public class GLPanel extends JPanel {

  private static final long serialVersionUID = -4601832524814661585L;

  protected BufferedImage out = null;

  protected GL gl;
  protected GLContext context;

  CGLContext cglContext;
  GLUTContext_macOS_10_15_7 glutContext;


  protected GLEventListener glListener;

  protected FBO fbo;


  public GLPanel() {
    setPreferredSize(new Dimension(600, 400));

    // Resize FBO on panel resize
    addComponentListener(new ComponentAdapter() {
      @Override
      public void componentResized(ComponentEvent e) {
        super.componentResized(e);

        Dimension size = e.getComponent().getSize();

        if (fbo != null)
          fbo.resize((int) Math.round(size.getWidth()), (int) Math.round(size.getHeight()));
        System.out.println("Resized to " + size.getWidth() + " " + size.getHeight());
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
    
    final AtomicBoolean initialized = new AtomicBoolean(false);

    /**
     * Causes doRun.run() to be executed synchronously on the AWT event dispatching thread. This
     * call blocks until all pending AWT events have been processed and (then) doRun.run() returns.
     * This method should be used when an application thread needs to update the GUI. It shouldn't
     * be called from the event dispatching thread. Here's an example that creates a new application
     * thread that uses invokeAndWait to print a string from the event dispatching thread and then,
     * when that's finished, print a string from the application thread.
     */
    /*try {
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
    }*/
    
    if(!initialized.get()) {
      System.out.println("Initialize from current thread then! ");
      initContext();
    }

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
    if (cglContext != null)
      cglContext.lockContext();

    System.out.println("GLPanel : repaint");
    super.repaint();

    if (glListener == null)
      return;

    renderGLToImage();
  }

  @Override
  public void paintComponent(Graphics g) {
    if (out != null) {
      g.drawImage(out, 0, 0, null);
    }
  }



  /**
   * In general, you should initialize any resources that are needed for rendering or other
   * functionality in the JPanel after the JPanel has been added to the Swing hierarchy, but before
   * it is made visible. This ensures that the JPanel has a valid parent container and can be
   * properly displayed on the screen.
   */
  private void initContext() {
    System.out.println("GLPanel : initContext");

    // A GL Context with CGL
    // cglContext = new CGLContext();
    // cglContext.init();

    // System.out.println("GLPanel : initContext : CGL done");

    // A GL Context with GLUT
    // - hanging while ONSCREEN
    // - not generating FBO properly if omitted
    glutContext = new GLUTContext_macOS_10_15_7();
    glutContext.init(false); // do not init GLUT a second time

    System.out.println("GLPanel : initContext : GLUT done");

    this.context = cglContext;

    // OpenGL
    this.gl = new GL_macOS_10_15_7();

    // FBO
    this.fbo = new FBO((int) Math.max(10, this.getWidth()), (int) Math.max(10, this.getHeight()));

    System.out.println("GLPanel : initContext : FBO done");

    // this.getWidth(), this.getHeight());

    // this.cglContext.makeCurrent();
    // this.cglContext.lockContext();

    // this.fbo.prepare(gl); // NOT NEEDED HERE

    // this.cglContext.release();

    System.out.println("GLPanel : initContext : prepared");

  }

  protected void renderGLToImage() {
    // Acquire context
    if (cglContext != null)
      cglContext.makeCurrent();

    // Render
    glListener.display(gl);


    // To image
    out = fbo.getImage(gl);

    // Release context
    if (cglContext != null)
      cglContext.release();
  }



  public GLEventListener getGLEventListener() {
    return glListener;
  }

  public void setGLEventListener(GLEventListener glEvents) {
    this.glListener = glEvents;
  }


}
