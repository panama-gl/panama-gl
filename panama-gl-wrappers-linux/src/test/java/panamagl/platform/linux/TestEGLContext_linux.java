package panamagl.platform.linux;

import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import org.junit.Assert;
import org.junit.Assume;
import org.junit.Test;
import panamagl.factory.PanamaGLFactory;
import panamagl.offscreen.FBO;
import panamagl.opengl.GL;
import panamagl.opengl.GLContext;

/**
 * PROOF OF CONCEPT. Render legacy immediate mode OpenGL into a {@link FBO} through a headless EGL
 * context, then read the pixels back, as PanamaGL canvases do.
 *
 * <p>Run it on OpenGL over Vulkan (Mesa Zink, here on the lavapipe CPU Vulkan driver) with :
 *
 * <pre>
 * LIBGL_ALWAYS_SOFTWARE=1 GALLIUM_DRIVER=zink mvn test -pl panama-gl-wrappers-linux -Dtest=TestEGLContext_linux
 * </pre>
 *
 * The renderer string then reads "zink Vulkan 1.x(...)".
 */
public class TestEGLContext_linux extends LinuxTest {
  static final int W = 64;
  static final int H = 64;

  @Test
  public void renderImmediateModeInFBO() {
    if (!checkPlatform())
      return;

    String previous = System.getProperty(EGLContext_linux.PROPERTY);
    System.setProperty(EGLContext_linux.PROPERTY, "egl");

    try {
      // Given a factory creating an EGL context
      PanamaGLFactory factory = PanamaGLFactory.select();
      GLContext context;
      try {
        context = factory.newGLContext();
      } catch (IllegalStateException | IllegalArgumentException e) {
        Assume.assumeNoException("No EGL available", e);
        return;
      }
      Assert.assertTrue(context instanceof EGLContext_linux);
      Assert.assertTrue(context.isInitialized());

      GL gl = factory.newGL();
      String renderer = gl.glGetString(GL.GL_RENDERER).getString(0);
      String version = gl.glGetString(GL.GL_VERSION).getString(0);
      System.out.println("TestEGLContext_linux : " + version + " / " + renderer);

      // When rendering a red triangle with immediate mode in a FBO
      FBO fbo = factory.newFBO(W, H);
      fbo.prepare(gl);

      gl.glViewport(0, 0, W, H);
      gl.glClearColor(1, 1, 1, 1);
      gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);

      gl.glMatrixMode(GL.GL_PROJECTION);
      gl.glLoadIdentity();
      gl.glOrtho(-1, 1, -1, 1, -1, 1);
      gl.glMatrixMode(GL.GL_MODELVIEW);
      gl.glLoadIdentity();

      gl.glBegin(GL.GL_TRIANGLES);
      gl.glColor3f(1, 0, 0);
      gl.glVertex3f(-1, -1, 0);
      gl.glVertex3f(1, -1, 0);
      gl.glVertex3f(0, 1, 0);
      gl.glEnd();

      MemorySegment pixels = fbo.readPixels(gl);

      // Then the center is red and the top left corner is the white background (BGRA)
      int[] center = bgra(pixels, W / 2, H / 3);
      int[] corner = bgra(pixels, 1, H - 2);

      Assert.assertArrayEquals(new int[] {0, 0, 255, 255}, center);
      Assert.assertArrayEquals(new int[] {255, 255, 255, 255}, corner);

      fbo.release(gl);
      factory.destroyContext();
      Assert.assertFalse(context.isInitialized());
    } finally {
      if (previous == null)
        System.clearProperty(EGLContext_linux.PROPERTY);
      else
        System.setProperty(EGLContext_linux.PROPERTY, previous);
    }
  }

  static int[] bgra(MemorySegment pixels, int x, int y) {
    long i = ((long) y * W + x) * 4;
    int[] p = new int[4];
    for (int c = 0; c < 4; c++)
      p[c] = Byte.toUnsignedInt(pixels.get(ValueLayout.JAVA_BYTE, i + c));
    return p;
  }
}
