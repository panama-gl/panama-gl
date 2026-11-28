package panamagl.platform.windows;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Test;
import panamagl.platform.windows.NativeLibLoader_windows.OpenGL;

/** The selection of the OpenGL implementation of Windows : pure Java, runs on every OS. */
public class TestOpenGLSelection_windows {
  @Test
  public void systemByDefault() {
    assertEquals(OpenGL.SYSTEM, OpenGL.parse(null));
    assertEquals(OpenGL.SYSTEM, OpenGL.parse(""));
    assertEquals(OpenGL.SYSTEM, OpenGL.parse("  "));
    assertEquals(OpenGL.SYSTEM, OpenGL.parse("system"));
    assertFalse(OpenGL.SYSTEM.isMesa());
    assertNull(OpenGL.SYSTEM.bundle());
  }

  @Test
  public void mesaDrivers() {
    assertEquals(OpenGL.MESA_LLVMPIPE, OpenGL.parse("mesa-llvmpipe"));
    assertEquals(OpenGL.MESA_D3D12, OpenGL.parse(" MESA-D3D12 "));
    assertEquals(OpenGL.MESA_ZINK, OpenGL.parse("mesa-zink"));
    assertEquals(OpenGL.MESA_ZINK_LAVAPIPE, OpenGL.parse("mesa-zink-lavapipe"));

    assertTrue(OpenGL.MESA_D3D12.isMesa());
    assertEquals("mesa-d3d12", OpenGL.MESA_D3D12.bundle());
    assertNull(OpenGL.MESA_ZINK.vulkanBundle());
    // Zink over lavapipe : the OpenGL bundle of Zink, and the Vulkan bundle of lavapipe
    assertEquals("mesa-zink", OpenGL.MESA_ZINK_LAVAPIPE.bundle());
    assertEquals("mesa-lavapipe", OpenGL.MESA_ZINK_LAVAPIPE.vulkanBundle());
  }

  @Test
  public void unknownValueListsTheValidOnes() {
    try {
      OpenGL.parse("mesa-softpipe");
      fail();
    } catch (IllegalArgumentException e) {
      assertTrue(e.getMessage(), e.getMessage().contains("mesa-softpipe"));
      assertTrue(e.getMessage(), e.getMessage().contains("mesa-zink-lavapipe"));
      assertTrue(e.getMessage(), e.getMessage().contains(NativeLibLoader_windows.OPENGL_PROPERTY));
    }
  }
}
