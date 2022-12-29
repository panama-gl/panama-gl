package panamagl;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.image.BufferedImage;
import java.lang.reflect.InvocationTargetException;
import javax.swing.JPanel;
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


  public GLPanel() throws InvocationTargetException, InterruptedException {
    setPreferredSize(new Dimension(600, 400));

    /*
     * javax.swing.SwingUtilities.invokeAndWait(new Runnable() {
     * 
     * @Override public void run() { init(); } });
     */

    // Resize FBO on panel resize
    addComponentListener(new ComponentAdapter() {
      @Override
      public void componentResized(ComponentEvent e) {
        super.componentResized(e);

        Dimension size = e.getComponent().getSize();

        if (fbo != null)
          fbo.resize((int) Math.round(size.getWidth()), (int) Math.round(size.getHeight()));
      }
    });


  }

  /**
   * called after the JPanel has been added to the Swing hierarchy but before it is made visible.
   */
  @Override
  public void addNotify() {
    super.addNotify();

    initContext();
  }

  /**
   * called before the JPanel is removed from the Swing hierarchy.
   */
  @Override
  public void removeNotify() {
    // Clean up CGL context
    if(cglContext!=null)
      cglContext.destroy();

    super.removeNotify();
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
    cglContext = new CGLContext();
    cglContext.init();
    
    // A GL Context with GLUT
    // - hanging while ONSCREEN
    // - not generating FBO properly if omitted
    glutContext = new GLUTContext_macOS_10_15_7();
    // context.init(true);
    glutContext.init(false);
    
    this.context = cglContext;

    // OpenGL
    this.gl = new GL_macOS_10_15_7();

    // FBO
    this.fbo = new FBO(10, 10);// this.getWidth(), this.getHeight());
    this.fbo.prepare(gl);
    System.out.println("GLPanel : prepared");

  }

  @Override
  public void repaint() {
    System.out.println("REPAINTING");
    super.repaint();

    if (glListener == null)
      return;

    // Acquire context
    cglContext.makeCurrent();
    
    // Render
    glListener.display(gl);
   

    // To image
    out = fbo.getImage(gl);
    
    // Release context
    cglContext.release();
  }



  public GLEventListener getGLEventListener() {
    return glListener;
  }

  public void setGLEventListener(GLEventListener glEvents) {
    this.glListener = glEvents;
  }

  @Override
  public void paintComponent(Graphics g) {
    //synchronized (out) {
      if (out != null) {
        g.drawImage(out, 0, 0, null);
      }
    //}
  }

}
