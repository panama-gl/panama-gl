package panamagl.os.linux;

import panamagl.Debug;
import panamagl.GLAutoDrawable;
import panamagl.OffscreenRenderer;
import panamagl.factory.APanamaGLFactory;
import panamagl.factory.PanamaGLFactory;
import panamagl.fbo.FBO;
import panamagl.opengl.GL;
import panamagl.opengl.GLContext;
import panamagl.os.OperatingSystem;

public class PanamaGLFactory_linux extends APanamaGLFactory implements PanamaGLFactory {
  protected boolean debug = Debug.check(PanamaGLFactory_linux.class);
  
  protected GLXContext_linux glxContext;
  protected GLUTContext_linux glutContext;
  protected boolean useGLUT = true;
  protected boolean useCGL = false;

  public PanamaGLFactory_linux() {}
  
  @Override
  public boolean matches(OperatingSystem os) {
    return os.isUnix();
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
    return new OffscreenRenderer_linux(this);
  }
  
  @Override
  public FBO newFBO(int width, int height) {
    return new FBO_linux(width, height);
  }


  @Override
  public GL newGL() {
    return new GL_linux();
  }

  @Override
  public GLContext newGLContext() {
    
 // --------------------------------------
    // A GL Context with CGL
    if (useCGL) {
      glxContext = new GLXContext_linux();
      glxContext.init();
      Debug.debug(debug, "PanamaGLFactory_linux : initContext : GLX done");
      
      return glxContext;
    }

    // --------------------------------------
    // A GL Context with GLUT
    // - hanging while ONSCREEN
    // - not generating FBO properly if omitted
    if (useGLUT) {
      glutContext = new GLUTContext_linux();
      glutContext.init(true); // do not init GLUT a second time
      Debug.debug(debug, "PanamaGLFactory_linux : initContext : GLUT done");
      
      return glutContext;
    }

    
    return null;
  }
  
  @Override
  public void destroyContext() {
    // Clean up CGL context
    if (glxContext != null)
      glxContext.destroy();

    // Clean up GLUT context
    if (glutContext != null)
      glutContext.destroy();

  }

}
