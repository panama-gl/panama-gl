package panamagl.os.macos;

import panamagl.Debug;
import panamagl.GLAutoDrawable;
import panamagl.OffscreenRenderer;
import panamagl.factory.APanamaGLFactory;
import panamagl.factory.PanamaGLFactory;
import panamagl.fbo.FBO;
import panamagl.opengl.GL;
import panamagl.opengl.GLContext;
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
   * The offscreen renderer will initialize {@link GL}, {@link GLContext} and {@link FBO_macOS} 
   * instances through this factory.
   */
  @Override
  public OffscreenRenderer newOffscreenRenderer() {
    return new OffscreenRenderer_macOS(this);
  }
  
  @Override
  public FBO newFBO(int width, int height) {
    return new FBO_macOS(width, height);
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
