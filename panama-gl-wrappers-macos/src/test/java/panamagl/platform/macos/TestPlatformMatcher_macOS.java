package panamagl.platform.macos;

import org.junit.Assert;
import org.junit.Test;
import panamagl.factory.PanamaGLFactory;
import panamagl.platform.Platform;

/** Runs on any OS : verify the factory selected for macOS on each 64-bit CPU. */
public class TestPlatformMatcher_macOS {
  static Platform platform(String os, String cpu) {
    return new Platform(os, "15.0", cpu, "22", false, os.toLowerCase().contains("mac"), false, false);
  }

  static final Platform X64 = platform("Mac OS X", "amd64");
  static final Platform X86_64 = platform("Mac OS X", "x86_64");
  static final Platform ARM64 = platform("Mac OS X", "aarch64");
  static final Platform X86 = platform("Mac OS X", "x86");
  static final Platform OTHER_OS = platform("Linux", "amd64");

  @Test
  public void when64BitCPU_ThenMatch() {
    Assert.assertTrue(new PlatformMatcher_macOS().matches(X64));
    Assert.assertTrue(new PlatformMatcher_macOS().matches(X86_64));
    Assert.assertTrue(new PlatformMatcher_macOS().matches(ARM64));
  }

  @Test
  public void when32BitCPU_ThenNoMatch() {
    Assert.assertFalse(new PlatformMatcher_macOS().matches(X86));
  }

  @Test
  public void whenNotMacOS_ThenNoMatch() {
    Assert.assertFalse(new PlatformMatcher_macOS().matches(OTHER_OS));
  }

  @Test
  public void whenSelectingFactory_ThenGetTheOneOfTheOSWhateverTheCPU() {
    Assert.assertTrue(PanamaGLFactory.selectFor(X64) instanceof PanamaGLFactory_macOS);
    Assert.assertTrue(PanamaGLFactory.selectFor(ARM64) instanceof PanamaGLFactory_macOS);
  }
}
