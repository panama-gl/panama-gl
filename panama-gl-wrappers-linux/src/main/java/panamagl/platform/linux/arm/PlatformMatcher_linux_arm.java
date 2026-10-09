package panamagl.platform.linux.arm;

import panamagl.platform.Platform;
import panamagl.platform.PlatformMatcher;

public class PlatformMatcher_linux_arm implements PlatformMatcher{

  /** Java reports aarch64 as os.arch of 64 bit Linux on ARM CPUs. */
  @Override
  public boolean matches(Platform platform) {
    return platform.isUnix()
        && ("aarch64".equals(platform.getCPU()) || "arm64".equals(platform.getCPU()));
  }

}
