package panamagl.platform.windows.arm;

import panamagl.platform.Platform;
import panamagl.platform.PlatformMatcher;

public class PlatformMatcher_windows_arm implements PlatformMatcher{

  /** Java reports aarch64 as os.arch of Windows on ARM64 CPUs. */
  @Override
  public boolean matches(Platform platform) {
    return platform.isWindows()
        && ("aarch64".equals(platform.getCPU()) || "arm64".equals(platform.getCPU()));
  }

}
