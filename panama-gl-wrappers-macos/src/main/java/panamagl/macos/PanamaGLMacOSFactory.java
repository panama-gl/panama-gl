package panamagl.macos;

import opengl.GL;
import opengl.GLContext;
import panamagl.Debug;
import panamagl.OffscreenRenderer;
import panamagl.factory.APanamaGLFactory;
import panamagl.factory.PanamaGLFactory;
import panamagl.macos.cgl.CGLContext_macOS;
import panamagl.macos.gl.GL_macOS_x86_64;
import panamagl.macos.glut.GLUTContext_macOS;
import panamagl.macos.offscreen.MacOSOffscreenRenderer;
import panamagl.os.OperatingSystem;

public class PanamaGLMacOSFactory extends APanamaGLFactory implements PanamaGLFactory {
  protected boolean debug = Debug.check(PanamaGLMacOSFactory.class);
  
  protected CGLContext_macOS cglContext;
  protected GLUTContext_macOS glutContext;
  protected boolean useGLUT = true;
  protected boolean useCGL = false;

  public PanamaGLMacOSFactory() {}
  
  @Override
  public boolean matches(OperatingSystem os) {
    return os.isMac();
  }

  /**
   * Invoked by the {@link GLAutoDrawable}, i.e. canvas that wishes to draw
   * offscreen rendered image.
   * 
   * The offscreen renderer will initialize {@link GL}, {@link GLContext} and {@link FBO} 
   * instances through this factory.
   */
  @Override
  public OffscreenRenderer newOffscreenRenderer() {
    return new MacOSOffscreenRenderer(this);
  }

  @Override
  public GL newGL() {
    return new GL_macOS_x86_64();
  }

  @Override
  public GLContext newGLContext() {
    
 // --------------------------------------
    // A GL Context with CGL
    if (useCGL) {
      cglContext = new CGLContext_macOS();
      cglContext.init();
      Debug.debug(debug, "PanamaGLMacOSFactory : initContext : CGL done");
      
      return cglContext;
    }

    // --------------------------------------
    // A GL Context with GLUT
    // - hanging while ONSCREEN
    // - not generating FBO properly if omitted
    if (useGLUT) {
      glutContext = new GLUTContext_macOS();
      glutContext.init(false); // do not init GLUT a second time
      Debug.debug(debug, "PanamaGLMacOSFactory : initContext : GLUT done");
      
      return glutContext;
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
