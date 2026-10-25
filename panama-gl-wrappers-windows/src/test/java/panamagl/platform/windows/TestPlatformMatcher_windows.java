package panamagl.platform.windows;

import org.junit.Assert;
import org.junit.Test;
import panamagl.factory.PanamaGLFactory;
import panamagl.platform.Platform;

/** Runs on any OS : verify the factory selected for Windows on each 64-bit CPU. */
public class TestPlatformMatcher_windows {
  static Platform platform(String os, String cpu) {
    return new Platform(os, "10.0", cpu, "22", os.toLowerCase().contains("win"), false, false, false);
  }

  static final Platform X64 = platform("Windows 11", "amd64");
  static final Platform X86_64 = platform("Windows 11", "x86_64");
  static final Platform ARM64 = platform("Windows 11", "aarch64");
  static final Platform X86 = platform("Windows 11", "x86");
  static final Platform OTHER_OS = platform("Linux", "amd64");

  @Test
  public void when64BitCPU_ThenMatch() {
    Assert.assertTrue(new PlatformMatcher_windows().matches(X64));
    Assert.assertTrue(new PlatformMatcher_windows().matches(X86_64));
    Assert.assertTrue(new PlatformMatcher_windows().matches(ARM64));
  }

  @Test
  public void when32BitCPU_ThenNoMatch() {
    Assert.assertFalse(new PlatformMatcher_windows().matches(X86));
  }

  @Test
  public void whenNotWindows_ThenNoMatch() {
    Assert.assertFalse(new PlatformMatcher_windows().matches(OTHER_OS));
  }

  @Test
  public void whenSelectingFactory_ThenGetTheOneOfTheOSWhateverTheCPU() {
    Assert.assertTrue(PanamaGLFactory.selectFor(X64) instanceof PanamaGLFactory_windows);
    Assert.assertTrue(PanamaGLFactory.selectFor(ARM64) instanceof PanamaGLFactory_windows);
  }
}
