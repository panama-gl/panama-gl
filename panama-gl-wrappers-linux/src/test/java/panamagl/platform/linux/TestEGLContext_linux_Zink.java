package panamagl.platform.linux;

import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import org.junit.Assert;
import org.junit.Assume;
import org.junit.Test;
import panamagl.GLProfile;
import panamagl.offscreen.FBO;
import panamagl.opengl.GL;

/**
 * OpenGL over Vulkan : the EGL context runs on Mesa Zink when <code>GALLIUM_DRIVER=zink</code>.
 * Skipped otherwise.
 *
 * <pre>
 * # lavapipe (CPU Vulkan) : sudo apt-get install mesa-vulkan-drivers
 * LIBGL_ALWAYS_SOFTWARE=1 GALLIUM_DRIVER=zink mvn test -pl panama-gl-wrappers-linux -Dtest=TestEGLContext_linux_Zink
 * </pre>
 *
 * <code>LIBGL_ALWAYS_SOFTWARE=1</code> only lets Zink use a CPU Vulkan device : on a GPU,
 * <code>GALLIUM_DRIVER=zink</code> is enough.
 */
public class TestEGLContext_linux_Zink extends LinuxTest {
  static final int W = 32;
  static final int H = 32;

  @Test
  public void openGLCompatibilityProfileRunsOnVulkan() {
    if (!checkPlatform())
      return;
    Assume.assumeTrue("GALLIUM_DRIVER=zink not set", isZinkRequested());

    EGLContext_linux context = new EGLContext_linux();
    context.init();

    try {
      GL gl = new GL_linux();
      GLProfile profile = new GLProfile(gl);
      System.out.println("TestEGLContext_linux_Zink : " + profile.getVersion() + " / "
          + profile.getRenderer());

      // Then the renderer is Zink, over a Vulkan driver, with a compatibility profile
      Assert.assertTrue(profile.getRenderer(), profile.getRenderer().startsWith("zink"));
      Assert.assertTrue(profile.getRenderer(), profile.getRenderer().contains("Vulkan"));
      Assert.assertTrue(profile.getVersion(), profile.getVersion().contains("Compatibility"));

      // When clearing a FBO and drawing a point with immediate mode
      FBO fbo = new FBO_linux(W, H);
      fbo.prepare(gl);
      gl.glViewport(0, 0, W, H);
      gl.glClearColor(0, 1, 0, 1);
      gl.glClear(GL.GL_COLOR_BUFFER_BIT);
      gl.glPointSize(8);
      gl.glBegin(GL.GL_POINTS);
      gl.glColor3f(1, 0, 0);
      gl.glVertex3f(0, 0, 0);
      gl.glEnd();
      MemorySegment pixels = fbo.readPixels(gl);

      // Then (BGRA) the background is green and the center is red
      Assert.assertEquals(255, pixel(pixels, 1, 1, 1));
      Assert.assertEquals(0, pixel(pixels, 1, 1, 2));
      Assert.assertEquals(255, pixel(pixels, W / 2, H / 2, 2));
      Assert.assertEquals(0, pixel(pixels, W / 2, H / 2, 1));
      Assert.assertEquals(GL.GL_NO_ERROR, gl.glGetError());

      fbo.release(gl);
    } finally {
      context.destroy();
    }
  }

  public static boolean isZinkRequested() {
    return "zink".equalsIgnoreCase(System.getenv("GALLIUM_DRIVER"));
  }

  static int pixel(MemorySegment pixels, int x, int y, int channel) {
    return Byte.toUnsignedInt(pixels.get(ValueLayout.JAVA_BYTE, ((long) y * W + x) * 4 + channel));
  }
}
