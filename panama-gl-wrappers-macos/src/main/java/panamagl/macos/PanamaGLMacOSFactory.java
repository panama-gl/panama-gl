package panamagl.macos;

import opengl.GL;
import opengl.GLContext;
import panamagl.Debug;
import panamagl.OffscreenRenderer;
import panamagl.factory.AbstractPanamaGLFactory;
import panamagl.factory.PanamaGLFactory;
import panamagl.macos.cgl.CGLContext_macOS;
import panamagl.macos.gl.GL_macOS;
import panamagl.macos.glut.GLUTContext_macOS;
import panamagl.macos.offscreen.MacOSOffscreenRenderer;

public class PanamaGLMacOSFactory extends AbstractPanamaGLFactory implements PanamaGLFactory {
  protected boolean debug = Debug.check(PanamaGLMacOSFactory.class);
  
  protected CGLContext_macOS cglContext;
  protected GLUTContext_macOS glutContext;
  protected boolean useGLUT = true;
  protected boolean useCGL = false;


  /**
   * Initialize GL, GLContext and FBO
   */
  @Override
  public OffscreenRenderer newOffscreenRenderer() {
    return new MacOSOffscreenRenderer(this);
  }

  @Override
  public GL newGL() {
    return new GL_macOS();
  }

  @Override
  public GLContext newGLContext() {
    
 // --------------------------------------
    // A GL Context with CGL
    if (useCGL) {
      cglContext = new CGLContext_macOS();
      cglContext.init();
      Debug.debug(debug, "MacOSOffscreenRenderer : initContext : CGL done");
    }

    // --------------------------------------
    // A GL Context with GLUT
    // - hanging while ONSCREEN
    // - not generating FBO properly if omitted
    if (useGLUT) {
      glutContext = new GLUTContext_macOS();
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
}
