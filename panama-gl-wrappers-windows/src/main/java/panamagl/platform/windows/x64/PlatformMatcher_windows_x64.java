package panamagl.platform.windows.x64;

import panamagl.platform.Platform;
import panamagl.platform.PlatformMatcher;

public class PlatformMatcher_windows_x64 implements PlatformMatcher{

  /** Java reports amd64 as os.arch of 64 bit Windows on Intel/AMD CPUs. */
  @Override
  public boolean matches(Platform platform) {
    return platform.isWindows()
        && ("amd64".equals(platform.getCPU()) || "x86_64".equals(platform.getCPU()));
  }

}
