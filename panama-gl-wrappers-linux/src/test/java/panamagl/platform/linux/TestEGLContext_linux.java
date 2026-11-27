package panamagl.platform.linux;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import org.junit.Assert;
import org.junit.Assume;
import org.junit.Test;
import panamagl.GLProfile;
import panamagl.factory.PanamaGLFactory;
import panamagl.offscreen.FBO;
import panamagl.opengl.GL;
import panamagl.opengl.GLContext;

/**
 * Headless EGL context : lifecycle, function resolution through <code>eglGetProcAddress</code>,
 * OpenGL functions of glext (buffers, shaders), profiles, and rendering into a {@link FBO}.
 *
 * <p>These tests require no X display. They run on any EGL implementation, and on OpenGL over Vulkan
 * with :
 *
 * <pre>
 * LIBGL_ALWAYS_SOFTWARE=1 GALLIUM_DRIVER=zink mvn test -pl panama-gl-wrappers-linux -Dtest=TestEGLContext_linux
 * </pre>
 */
public class TestEGLContext_linux extends LinuxTest {
  static final int W = 64;
  static final int H = 64;

  /** Create and init an EGL context, or skip the test if EGL is not available. */
  protected EGLContext_linux newContext() {
    EGLContext_linux context = new EGLContext_linux();
    try {
      context.init();
    } catch (IllegalStateException | IllegalArgumentException e) {
      Assume.assumeNoException("No EGL available", e);
    }
    return context;
  }

  @Test
  public void lifecycle() {
    if (!checkPlatform())
      return;

    // When
    EGLContext_linux context = newContext();

    // Then the context is current on this thread, without any surface
    Assert.assertTrue(context.isInitialized());
    Assert.assertTrue(context.isCurrent());
    Assert.assertNotNull(context.getPlatform());
    Assert.assertTrue(EGLContext_linux.isUsed());

    String[] version = context.getEGLVersion().split("\\.");
    int major = Integer.parseInt(version[0]);
    int minor = Integer.parseInt(version[1]);
    Assert.assertTrue("EGL >= 1.4 : " + context.getEGLVersion(), major > 1 || minor >= 4);
    Assert.assertNotNull(context.getEGLVendor());
    Assert.assertTrue(context.getEGLClientAPIs(), context.getEGLClientAPIs().contains("OpenGL"));

    System.out.println("TestEGLContext_linux : EGL " + context.getEGLVersion() + " ("
        + context.getEGLVendor() + ") on " + context.getPlatform() + " platform");

    // When releasing then making current again
    context.release();
    Assert.assertFalse(context.isCurrent());
    context.makeCurrent();
    Assert.assertTrue(context.isCurrent());

    // When destroying
    context.destroy();
    Assert.assertFalse(context.isInitialized());
    Assert.assertFalse(context.isCurrent());

    // Then destroying twice does nothing
    context.destroy();
  }

  @Test
  public void factorySelectsEGL() {
    if (!checkPlatform())
      return;

    APanamaGLFactory_linux factory = (APanamaGLFactory_linux) PanamaGLFactory.select();
    Assert.assertEquals(EGLContext_linux.isRequested(), factory.isUseEGL());

    // When selecting EGL by API rather than with the system property
    factory.setUseEGL(true);
    GLContext context;
    try {
      context = factory.newGLContext();
    } catch (IllegalStateException | IllegalArgumentException e) {
      Assume.assumeNoException("No EGL available", e);
      return;
    }

    // Then
    Assert.assertTrue(context instanceof EGLContext_linux);
    Assert.assertSame(context, factory.getContext());

    GL gl = factory.newGL();
    GLProfile profile = new GLProfile(gl);
    Assert.assertNotNull(profile.getVersion());
    Assert.assertNotNull(profile.getRenderer());
    System.out.println("TestEGLContext_linux : " + profile.getVersion() + " / " + profile.getRenderer());

    factory.destroyContext();
    Assert.assertFalse(context.isInitialized());
  }

  @Test
  public void functionsAreResolvedByEGL() {
    if (!checkPlatform())
      return;

    EGLContext_linux context = newContext();
    try {
      GL_linux gl = new GL_linux();
      GLFunctionLoader_linux loader = (GLFunctionLoader_linux) gl.getFunctionLoader();

      // Then the loader resolves with EGL, core and extension functions alike
      Assert.assertEquals("EGL", loader.getResolver());
      Assert.assertNotEquals(0, loader.getProcAddress("glGenFramebuffers").address());
      Assert.assertNotEquals(0, loader.getProcAddress("glCreateShader").address());
      Assert.assertNotEquals(0, loader.getProcAddress("glGenVertexArrays").address());
    } finally {
      context.destroy();
    }
  }

  @Test
  public void vertexBufferObjects() {
    if (!checkPlatform())
      return;

    EGLContext_linux context = newContext();

    try (Arena arena = Arena.ofConfined()) {
      GL gl = new GL_linux();

      // When generating and filling a buffer
      MemorySegment ids = arena.allocate(ValueLayout.JAVA_INT);
      gl.glGenBuffers(1, ids);
      int id = ids.get(ValueLayout.JAVA_INT, 0);
      Assert.assertTrue(id > 0);

      float[] vertices = {0, 0, 0, 1, 0, 0, 0, 1, 0};
      MemorySegment data = arena.allocateFrom(ValueLayout.JAVA_FLOAT, vertices);
      gl.glBindBuffer(GL.GL_ARRAY_BUFFER, id);
      gl.glBufferData(GL.GL_ARRAY_BUFFER, data.byteSize(), data, GL.GL_STATIC_DRAW);

      // Then the buffer has the expected size
      MemorySegment size = arena.allocate(ValueLayout.JAVA_INT);
      gl.glGetBufferParameteriv(GL.GL_ARRAY_BUFFER, GL.GL_BUFFER_SIZE, size);
      Assert.assertEquals(vertices.length * Float.BYTES, size.get(ValueLayout.JAVA_INT, 0));
      Assert.assertEquals(1, gl.glIsBuffer(id));

      // When deleting the buffer
      gl.glBindBuffer(GL.GL_ARRAY_BUFFER, 0);
      gl.glDeleteBuffers(1, ids);

      // Then
      Assert.assertEquals(0, gl.glIsBuffer(id));
      Assert.assertEquals(GL.GL_NO_ERROR, gl.glGetError());
    } finally {
      context.destroy();
    }
  }

  @Test
  public void shaders() {
    if (!checkPlatform())
      return;

    EGLContext_linux context = newContext();

    try (Arena arena = Arena.ofConfined()) {
      GL gl = new GL_linux();

      int vertex = compile(gl, arena, GL.GL_VERTEX_SHADER,
          "#version 110\n uniform float scale; void main() { gl_Position = gl_Vertex * scale; }");
      int fragment = compile(gl, arena, GL.GL_FRAGMENT_SHADER,
          "#version 110\n void main() { gl_FragColor = vec4(1.0, 0.0, 0.0, 1.0); }");

      int program = gl.glCreateProgram();
      gl.glAttachShader(program, vertex);
      gl.glAttachShader(program, fragment);
      gl.glLinkProgram(program);

      MemorySegment status = arena.allocate(ValueLayout.JAVA_INT);
      gl.glGetProgramiv(program, GL.GL_LINK_STATUS, status);
      Assert.assertEquals(GL.GL_TRUE, status.get(ValueLayout.JAVA_INT, 0));

      gl.glUseProgram(program);
      int scale = gl.glGetUniformLocation(program, arena.allocateFrom("scale"));
      gl.glUniform1f(scale, 2f);
      Assert.assertTrue(scale >= 0);
      Assert.assertEquals(GL.GL_NO_ERROR, gl.glGetError());

      gl.glUseProgram(0);
      gl.glDeleteProgram(program);
      gl.glDeleteShader(vertex);
      gl.glDeleteShader(fragment);
    } finally {
      context.destroy();
    }
  }

  @Test
  public void compatibilityProfileByDefault_coreProfileOnRequest() {
    if (!checkPlatform())
      return;

    // Given the default context
    EGLContext_linux compat = newContext();
    GL gl = new GL_linux();
    String compatVersion = new GLProfile(gl).getVersion();
    compat.destroy();

    // Then it is not a core profile : immediate mode is available
    Assert.assertFalse(compatVersion, compatVersion.contains("Core"));

    // When requesting a core profile
    EGLContext_linux core = new EGLContext_linux();
    core.setCoreProfile(3, 3);
    try {
      core.init();
    } catch (IllegalStateException e) {
      Assume.assumeNoException("No OpenGL 3.3 core profile", e);
    }
    try {
      String coreVersion = new GLProfile(new GL_linux()).getVersion();
      Assert.assertTrue(core.isCoreProfile());
      Assert.assertTrue(coreVersion, coreVersion.contains("Core"));
    } finally {
      core.destroy();
    }
  }

  @Test
  public void destroyingAContextKeepsTheOthersUsable() {
    if (!checkPlatform())
      return;

    // Given two contexts, e.g. of two canvases
    EGLContext_linux first = newContext();
    EGLContext_linux second = newContext();

    // When destroying the second one
    second.destroy();

    // Then the first one can still render
    first.makeCurrent();
    GL gl = new GL_linux();
    FBO fbo = new FBO_linux(W, H);
    fbo.prepare(gl);
    gl.glClearColor(0, 0, 0, 1);
    gl.glClear(GL.GL_COLOR_BUFFER_BIT);
    Assert.assertEquals(GL.GL_NO_ERROR, gl.glGetError());
    fbo.release(gl);
    first.destroy();
  }

  @Test
  public void surfacelessContextHasNoDefaultFramebuffer() {
    if (!checkPlatform())
      return;

    EGLContext_linux context = newContext();
    Assume.assumeTrue("Display without surfaceless platform",
        EGLContext_linux.Platform.SURFACELESS.equals(context.getPlatform()));

    try {
      GL gl = new GL_linux();

      // When drawing without binding a FBO
      gl.glClear(GL.GL_COLOR_BUFFER_BIT);

      // Then the default framebuffer is incomplete : PanamaGL must render in a FBO
      Assert.assertEquals(GL.GL_INVALID_FRAMEBUFFER_OPERATION, gl.glGetError());
    } finally {
      context.destroy();
    }
  }

  @Test
  public void renderImmediateModeInFBO() {
    if (!checkPlatform())
      return;

    APanamaGLFactory_linux factory = (APanamaGLFactory_linux) PanamaGLFactory.select();
    factory.setUseEGL(true);
    try {
      factory.newGLContext();
    } catch (IllegalStateException | IllegalArgumentException e) {
      Assume.assumeNoException("No EGL available", e);
    }

    GL gl = factory.newGL();

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
    Assert.assertArrayEquals(new int[] {0, 0, 255, 255}, bgra(pixels, W / 2, H / 3));
    Assert.assertArrayEquals(new int[] {255, 255, 255, 255}, bgra(pixels, 1, H - 2));

    fbo.release(gl);
    factory.destroyContext();
  }

  protected int compile(GL gl, Arena arena, int type, String source) {
    int shader = gl.glCreateShader(type);
    Assert.assertTrue(shader > 0);

    MemorySegment sources = arena.allocate(ValueLayout.ADDRESS);
    sources.set(ValueLayout.ADDRESS, 0, arena.allocateFrom(source));
    gl.glShaderSource(shader, 1, sources, MemorySegment.NULL);
    gl.glCompileShader(shader);

    MemorySegment status = arena.allocate(ValueLayout.JAVA_INT);
    gl.glGetShaderiv(shader, GL.GL_COMPILE_STATUS, status);
    Assert.assertEquals(GL.GL_TRUE, status.get(ValueLayout.JAVA_INT, 0));
    return shader;
  }

  static int[] bgra(MemorySegment pixels, int x, int y) {
    long i = ((long) y * W + x) * 4;
    int[] p = new int[4];
    for (int c = 0; c < 4; c++)
      p[c] = Byte.toUnsignedInt(pixels.get(ValueLayout.JAVA_BYTE, i + c));
    return p;
  }
}
