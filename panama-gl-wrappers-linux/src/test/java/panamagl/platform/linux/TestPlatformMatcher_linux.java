package panamagl.platform.linux;

import org.junit.Assert;
import org.junit.Test;
import panamagl.factory.PanamaGLFactory;
import panamagl.platform.Platform;

/** Runs on any OS : verify the factory selected for Linux on each 64-bit CPU. */
public class TestPlatformMatcher_linux {
  static Platform platform(String os, String cpu) {
    return new Platform(os, "6.8", cpu, "22", false, false, os.toLowerCase().contains("linux"), false);
  }

  static final Platform X64 = platform("Linux", "amd64");
  static final Platform X86_64 = platform("Linux", "x86_64");
  static final Platform ARM64 = platform("Linux", "aarch64");
  static final Platform X86 = platform("Linux", "x86");
  static final Platform OTHER_OS = platform("Windows 11", "amd64");

  @Test
  public void when64BitCPU_ThenMatch() {
    Assert.assertTrue(new PlatformMatcher_linux().matches(X64));
    Assert.assertTrue(new PlatformMatcher_linux().matches(X86_64));
    Assert.assertTrue(new PlatformMatcher_linux().matches(ARM64));
  }

  @Test
  public void when32BitCPU_ThenNoMatch() {
    Assert.assertFalse(new PlatformMatcher_linux().matches(X86));
  }

  @Test
  public void whenNotLinux_ThenNoMatch() {
    Assert.assertFalse(new PlatformMatcher_linux().matches(OTHER_OS));
  }

  @Test
  public void whenSelectingFactory_ThenGetTheOneOfTheOSWhateverTheCPU() {
    Assert.assertTrue(PanamaGLFactory.selectFor(X64) instanceof PanamaGLFactory_linux);
    Assert.assertTrue(PanamaGLFactory.selectFor(ARM64) instanceof PanamaGLFactory_linux);
  }
}
