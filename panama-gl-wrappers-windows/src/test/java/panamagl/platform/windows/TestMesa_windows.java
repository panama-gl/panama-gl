package panamagl.platform.windows;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import java.lang.foreign.MemorySegment;
import java.nio.file.Path;
import org.junit.Assume;
import org.junit.BeforeClass;
import org.junit.Test;
import panamagl.opengl.GL;
import panamagl.platform.natives.NativeBundle;
import panamagl.platform.natives.OpenGLImplementation;
import panamagl.platform.windows.NativeLibLoader_windows.OpenGL;

/**
 * A WGL context on Mesa, loaded from <code>panama-gl-bindings-windows-mesa</code> : the driver
 * selected by <code>PANAMAGL_WINDOWS_OPENGL</code>, or llvmpipe. Each test class runs in its own
 * JVM, which can only use one OpenGL implementation.
 */
public class TestMesa_windows extends WindowsTest {
  static OpenGL selected;

  @BeforeClass
  public static void selectMesa() {
    Assume.assumeTrue("Windows only", new panamagl.platform.Platform().isWindows());
    selected = NativeLibLoader_windows.selectedOpenGL();
    if (!selected.isMesa()) {
      System.setProperty(NativeLibLoader_windows.OPENGL_PROPERTY, OpenGL.MESA_LLVMPIPE.value());
      selected = OpenGL.MESA_LLVMPIPE;
    }
  }

  /** Print the DLLs involved, to understand a failure of the context. */
  @org.junit.After
  public void printModules() {
    for (String dll : new String[] {"opengl32.dll", "vulkan-1.dll", "vulkan_lvp.dll"})
      System.out.println("TestMesa_windows : " + dll + " : " + Kernel32_windows.loadedModule(dll).orElse("not loaded"));
    for (String v : new String[] {"GALLIUM_DRIVER", "LIBGL_ALWAYS_SOFTWARE", "VK_DRIVER_FILES"})
      System.out.println("TestMesa_windows : " + v + " = " + Kernel32_windows.getenv(v).orElse("") + " / CRT : "
          + Kernel32_windows.crtGetenv(v).orElse(""));
  }

  @Test
  public void environmentSetForMesaIsSeenByNativeCode() {
    String name = "PANAMAGL_TEST_" + System.nanoTime();
    Kernel32_windows.setenv(name, "value é");
    // by the Vulkan loader (GetEnvironmentVariable) and by Mesa (getenv of the C runtime)
    assertEquals("value é", Kernel32_windows.getenv(name).orElse(null));
    assertTrue(Kernel32_windows.crtGetenv(name).isPresent());
  }

  @Test
  public void wglContextRendersWithMesa() {
    WGLContext_windows wgl = new WGLContext_windows();
    wgl.init();
    wgl.makeCurrent();
    GL gl = new GL_windows();
    String renderer = gl.glGetString(GL.GL_RENDERER).getString(0);
    String version = gl.glGetString(GL.GL_VERSION).getString(0);
    System.out.println("TestMesa_windows : " + selected.value() + " : " + renderer + " / " + version);

    // Then the opengl32.dll of the bundle is the one loaded, not the one of Windows
    assertEquals(selected, NativeLibLoader_windows.getOpenGL());
    Path origin = Path.of(NativeLibLoader_windows.getOpenGLOrigin());
    assertEquals("opengl32.dll", origin.getFileName().toString().toLowerCase());
    assertTrue(origin.toString(), origin.getParent().getFileName().toString().startsWith(selected.bundle() + "-"));
    String loaded = Kernel32_windows.loadedModule("opengl32.dll").orElseThrow();
    assertTrue(loaded + " is not " + origin, NativeLibLoader_windows.isIn(loaded, origin.getParent()));
    assertTrue(OpenGLImplementation.current(), OpenGLImplementation.current().startsWith("Mesa " + selected.bundle()));

    // A recent OpenGL, and the driver of the bundle
    assertTrue(version, version.contains("Mesa"));
    int major = Integer.parseInt(version.substring(0, version.indexOf('.')));
    assertTrue(version, major >= 3);
    String expected = switch (selected) {
      case MESA_LLVMPIPE -> "llvmpipe";
      case MESA_D3D12 -> "D3D12";
      default -> "zink";
    };
    assertTrue(renderer, renderer.contains(expected));

    // glu32.dll of Windows imports opengl32.dll by name : it works with the one of Mesa
    MemorySegment quadric = gl.gluNewQuadric();
    assertNotEquals(0, quadric.address());
    gl.gluDeleteQuadric(quadric);

    wgl.destroy();
  }

  @Test
  public void bundlesAreInTheClasspathForThisCPU() {
    for (OpenGL gl : OpenGL.values())
      if (gl.isMesa())
        assertTrue(gl.bundle(), NativeBundle.exists(gl.bundle()));
    assertTrue(NativeBundle.exists("mesa-lavapipe"));
  }
}
