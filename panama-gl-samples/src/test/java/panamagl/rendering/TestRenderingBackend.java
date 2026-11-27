package panamagl.rendering;

import org.junit.Assert;
import org.junit.Test;
import demos.panamagl.rendering.RenderingBackend;

/** Naming of the renderings after the backend guessed from the OpenGL renderer string. */
public class TestRenderingBackend {

  @Test
  public void zinkOnLavapipe() {
    RenderingBackend b = new RenderingBackend("Linux", "amd64", "EGLContext_linux",
        "zink Vulkan 1.4(llvmpipe (LLVM 20.1.2, 256 bits) (MESA_LLVMPIPE))",
        "4.6 (Compatibility Profile) Mesa 25.2.8", "Mesa");
    Assert.assertEquals("vulkan-zink-lavapipe", b.getBackend());
    Assert.assertEquals(
        "reference-scene__linux-x86_64__egl__vulkan-zink-lavapipe__zink-vulkan-1-4-llvmpipe",
        b.getName("Reference scene"));
  }

  @Test
  public void mesaOnCPU() {
    RenderingBackend b = new RenderingBackend("Linux", "aarch64", "GLXContext_linux",
        "llvmpipe (LLVM 20.1.2, 128 bits)", "4.5 (Compatibility Profile) Mesa", "Mesa");
    Assert.assertEquals("cpu-llvmpipe", b.getBackend());
    Assert.assertEquals("llvmpipe", b.getRendererSlug());
    Assert.assertEquals("glx", b.getContext());
    Assert.assertEquals("arm64", b.getArch());
  }

  @Test
  public void mesaD3D12OnWarp() {
    RenderingBackend b = new RenderingBackend("Windows 11", "amd64", "WGLContext_windows",
        "D3D12 (Microsoft Basic Render Driver)", "4.6 (Compatibility Profile) Mesa", "Microsoft Corporation");
    Assert.assertEquals("d3d12-warp", b.getBackend());
    Assert.assertEquals("d3d12-microsoft-basic-render-driver", b.getRendererSlug());
    Assert.assertEquals("wgl", b.getContext());
    Assert.assertEquals("windows", b.getOs());
  }

  @Test
  public void appleOpenGL() {
    RenderingBackend silicon = new RenderingBackend("Mac OS X", "aarch64", "CGLContext_macOS",
        "Apple M1 (Virtual)", "2.1 Metal - 89.3", "Apple");
    Assert.assertEquals("apple-opengl-metal", silicon.getBackend());
    Assert.assertEquals("cgl", silicon.getContext());

    RenderingBackend intel = new RenderingBackend("Mac OS X", "x86_64", "CGLContext_macOS",
        "Intel(R) UHD Graphics 630", "2.1 INTEL-20.4", "Intel Inc.");
    Assert.assertEquals("opengl-native", intel.getBackend());
  }

  @Test
  public void zinkOnMoltenVKAndGPUDriver() {
    Assert.assertEquals("vulkan-zink-moltenvk", new RenderingBackend("Mac OS X", "aarch64",
        "EGLContext_macOS", "zink Vulkan 1.2(Apple M1 (MoltenVK))", "4.6", "Mesa").getBackend());
    Assert.assertEquals("opengl-native", new RenderingBackend("Linux", "amd64", "GLXContext_linux",
        "NVIDIA GeForce RTX 3060/PCIe/SSE2", "4.6.0 NVIDIA 550", "NVIDIA Corporation").getBackend());
  }
}
