package panamagl.os.linux;



import panamagl.Debug;
import panamagl.GLCanvas;
import panamagl.factory.APanamaGLFactory;
import panamagl.factory.PanamaGLFactory;
import panamagl.offscreen.FBO;
import panamagl.offscreen.OffscreenRenderer;
import panamagl.opengl.GL;
import panamagl.opengl.GLContext;
import panamagl.os.Platform;

public abstract class APanamaGLFactory_linux extends APanamaGLFactory {
protected boolean debug = Debug.check(APanamaGLFactory_linux.class);
  
  protected GLXContext_linux glxContext;
  protected GLUTContext_linux glutContext;
  protected boolean useGLUT = true;
  protected boolean useCGL = false;

  public APanamaGLFactory_linux() {
    super();
  }
  
  @Override
  public abstract GL newGL();


  @Override
  public boolean matches(Platform os) {
    return os.isUnix();
  }

  /**
   * Invoked by the {@link GLCanvas}, i.e. canvas that wishes to draw
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
