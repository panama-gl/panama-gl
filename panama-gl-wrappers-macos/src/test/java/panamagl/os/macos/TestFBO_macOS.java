package panamagl.os.macos;

import org.junit.Test;
import org.jzy3d.os.OperatingSystem;
import panamagl.opengl.GL;
import panamagl.opengl.GLContext;
import panamagl.os.macos.CGLContext_macOS;
import panamagl.os.macos.GLUTContext_macOS;
import panamagl.os.macos.GL_macOS_x86_64;

// VM ARGS : -XstartOnFirstThread --enable-native-access=ALL-UNNAMED --add-modules
// jdk.incubator.foreign
// -Djava.library.path=.:/System/Library/Frameworks/OpenGL.framework/Versions/Current/Libraries/
public class TestFBO_macOS {

  @Test
  public void given_CGLAndGLUTContext_whenRenderSomething_ThenGetBufferedImage() {
    if (!new OperatingSystem().isMac())
      return;

    // Given a CGL Context
    GLContext cglContext = new CGLContext_macOS();
    cglContext.init();

    // Given a GLUT context
    GLContext glutContext = new GLUTContext_macOS();
    glutContext.init();

    // Given a GL caller
    GL gl = new GL_macOS_x86_64();

    TestFBO.givenFBO_whenRenderSomething_ThenGetBufferedImage(gl);

  }

  @Test
  public void given_GLUTContext_ONLY_whenRenderSomething_ThenGetBufferedImage() {

    OperatingSystem os = new OperatingSystem();
    if (!os.isMac())
      return;

    // Given a GLUT context
    GLContext glutContext = new GLUTContext_macOS();
    glutContext.init();

    // Given a GL caller
    GL gl = new GL_macOS_x86_64();

    TestFBO.givenFBO_whenRenderSomething_ThenGetBufferedImage(gl);

  }

  @Test
  public void given_CGLContext_ONLY_whenRenderSomething_ThenGetBufferedImage() {
    OperatingSystem os = new OperatingSystem();
    if (!os.isMac())
      return;

    // Given a CGL context ONLY
    GLContext context = new CGLContext_macOS();
    context.init();

    GL gl = new GL_macOS_x86_64();

    TestFBO.givenFBO_whenRenderSomething_ThenGetBufferedImage(gl);

  }



}
