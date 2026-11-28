package panamagl.platform.windows;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Assume;
import org.junit.Test;
import opengl.windows.NativeLibLoader;
import panamagl.platform.windows.NativeLibLoader_windows.OpenGL;

/**
 * Mesa cannot replace the opengl32.dll of Windows once loaded : a process would then have two
 * OpenGL implementations. Selecting it too late fails with an explicit message.
 */
public class TestMesa_windows_afterSystemOpenGL extends WindowsTest {
  @Test
  public void mesaAfterTheOpenGLOfWindowsIsRefused() {
    Assume.assumeTrue("Windows only", new panamagl.platform.Platform().isWindows());

    // Given the opengl32.dll of Windows, loaded as without selection
    NativeLibLoader.loadGL();
    String system = Kernel32_windows.loadedModule("opengl32.dll").orElseThrow();
    assertTrue(system, system.toLowerCase().contains("system32"));

    // When loading Mesa
    try {
      NativeLibLoader_windows.loadMesa(OpenGL.MESA_LLVMPIPE);
      fail();
    } catch (IllegalStateException e) {
      // Then
      assertTrue(e.getMessage(), e.getMessage().contains("already loaded"));
      assertTrue(e.getMessage(), e.getMessage().contains(system));
    }
  }
}
