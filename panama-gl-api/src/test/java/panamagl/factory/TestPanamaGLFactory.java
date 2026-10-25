package panamagl.factory;

import org.junit.Assert;
import org.junit.Test;
import panamagl.platform.Platform;

public class TestPanamaGLFactory {
  @Test
  public void givenNoWrapper_whenSelectingFactory_thenSuggestTheWrapperOfTheOS() {
    Platform linux = new Platform("Linux", "6.8", "amd64", "25", false, false, true, false);

    try {
      PanamaGLFactory.selectFor(linux);
      Assert.fail("No wrapper is on the classpath of panama-gl-api");
    } catch (IllegalStateException e) {
      Assert.assertTrue(e.getMessage(), e.getMessage().contains("panama-gl-wrappers-linux"));
      Assert.assertTrue(e.getMessage(), e.getMessage().contains("panama-gl-wrappers-all"));
    }
  }

  @Test
  public void wrapperArtifact() {
    Assert.assertEquals("panama-gl-wrappers-windows", PanamaGLFactory.wrapperArtifact(
        new Platform("Windows 11", "10.0", "aarch64", "25", true, false, false, false)));
    Assert.assertEquals("panama-gl-wrappers-macos", PanamaGLFactory.wrapperArtifact(
        new Platform("Mac OS X", "15.0", "aarch64", "25", false, true, true, false)));
    Assert.assertEquals("panama-gl-wrappers-linux", PanamaGLFactory.wrapperArtifact(
        new Platform("Linux", "6.8", "amd64", "25", false, false, true, false)));
  }
}
