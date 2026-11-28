package panamagl.platform.linux;

import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import java.util.function.Supplier;
import org.junit.Assert;
import org.junit.Assume;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import panamagl.offscreen.FBO;
import panamagl.opengl.GL;

/**
 * GLUT functions of {@link GL_linux} with a headless EGL context : GLUT is initialized at the first
 * GLUT call when an X display is available, and an explicit exception is thrown otherwise, instead
 * of freeglut terminating the JVM.
 */
// GLUT is initialized once per JVM : check the case without display first
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestGLUT_linux extends LinuxTest {
  static final int W = 64;
  static final int H = 64;

  @Test
  public void test1_withoutDisplay_GLUTFunctionsThrowAnExplicitException() {
    if (!checkPlatform())
      return;
    Assume.assumeFalse("GLUT already initialized in this JVM", GLUT_linux.isInitialized());

    Supplier<String> display = GLUT_linux.display;
    GLUT_linux.display = () -> null;

    try {
      GL_linux gl = new GL_linux();
      gl.glutSolidTeapot(0.5);
      Assert.fail("expect an exception");
    } catch (UnsupportedOperationException e) {
      Assert.assertTrue(e.getMessage(), e.getMessage().contains("DISPLAY"));
      Assert.assertFalse(GLUT_linux.isInitialized());
    } finally {
      GLUT_linux.display = display;
    }
  }

  @Test
  public void test2_withDisplay_GLUTDrawsInTheEGLContext() {
    if (!checkPlatform())
      return;
    Assume.assumeTrue("No X display", GLUT_linux.hasDisplay());

    EGLContext_linux context = new EGLContext_linux();
    try {
      context.init();
    } catch (IllegalStateException | IllegalArgumentException e) {
      Assume.assumeNoException("No EGL available", e);
    }

    try {
      GL_linux gl = new GL_linux();
      FBO fbo = new FBO_linux(W, H);
      fbo.prepare(gl);

      gl.glViewport(0, 0, W, H);
      gl.glClearColor(1, 1, 1, 1);
      gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
      gl.glColor3f(0, 0, 1);

      // When drawing a GLUT teapot : GLUT is initialized on demand
      gl.glutSolidTeapot(0.5);

      // Then
      Assert.assertTrue(GLUT_linux.isInitialized());
      Assert.assertEquals(GL.GL_NO_ERROR, gl.glGetError());

      MemorySegment pixels = fbo.readPixels(gl);
      int blue = 0;
      for (int i = 0; i < W * H; i++) {
        int b = Byte.toUnsignedInt(pixels.get(ValueLayout.JAVA_BYTE, i * 4L));
        int r = Byte.toUnsignedInt(pixels.get(ValueLayout.JAVA_BYTE, i * 4L + 2));
        if (b > 128 && r < 64)
          blue++;
      }
      Assert.assertTrue("teapot pixels : " + blue, blue > 100);

      fbo.release(gl);
    } finally {
      context.destroy();
    }
  }
}
