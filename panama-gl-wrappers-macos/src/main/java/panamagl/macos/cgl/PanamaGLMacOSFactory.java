package panamagl.macos.cgl;

import opengl.GL;
import opengl.GLContext;
import panamagl.Debug;
import panamagl.GLAutoDrawable;
import panamagl.OffscreenRenderer;
import panamagl.PanamaGLFactory;
import panamagl.canvas.awt.GLCanvasAWT;
import panamagl.canvas.swing.GLCanvasSwing;
import panamagl.fbo.FBO;
import panamagl.macos.gl.GL_macOS_10_15_7;
import panamagl.macos.glut.GLUTContext_macOS_10_15_7;
import panamagl.os.macos.MacOSOffscreenRenderer;

public class PanamaGLMacOSFactory implements PanamaGLFactory {
  protected boolean debug = Debug.check(PanamaGLMacOSFactory.class);

  protected CGLContext cglContext;
  protected GLUTContext_macOS_10_15_7 glutContext;

  protected boolean useGLUT = true;
  protected boolean useCGL = false;

  
  @Override
  public GLAutoDrawable newCanvas(Class<? extends GLAutoDrawable> type) {
    if (type.equals(GLCanvasAWT.class)) {
      return new GLCanvasAWT(this);
    } else if (type.equals(GLCanvasSwing.class)) {
      return new GLCanvasSwing(this);
    }
    return null;
  }

  /**
   * Initialize GL, GLContext and FBO
   */
  @Override
  public OffscreenRenderer newOffscreenRenderer() {
    return new MacOSOffscreenRenderer(this);
  }

  @Override
  public GL newGL() {
    return new GL_macOS_10_15_7();
  }

  @Override
  public GLContext newGLContext() {
    
 // --------------------------------------
    // A GL Context with CGL
    if (useCGL) {
      cglContext = new CGLContext();
      cglContext.init();
      Debug.debug(debug, "MacOSOffscreenRenderer : initContext : CGL done");
    }

    // --------------------------------------
    // A GL Context with GLUT
    // - hanging while ONSCREEN
    // - not generating FBO properly if omitted
    if (useGLUT) {
      glutContext = new GLUTContext_macOS_10_15_7();
      glutContext.init(false); // do not init GLUT a second time
      Debug.debug(debug, "MacOSOffscreenRenderer : initContext : GLUT done");
    }

    
    return null;
  }
  
  @Override
  public void destroyContext() {
    // Clean up CGL context
    if (cglContext != null)
      cglContext.destroy();

    // Clean up GLUT context
    if (glutContext != null)
      glutContext.destroy();

  }

  @Override
  public FBO newFBO(int width, int height) {
    return new FBO(width, height);
  }
}
