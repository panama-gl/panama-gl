package panamagl.platform.linux.x64;

import panamagl.platform.Platform;
import panamagl.platform.PlatformMatcher;

public class PlatformMatcher_linux_x64 implements PlatformMatcher{

  /** Java reports amd64 as os.arch of 64 bit Linux on Intel/AMD CPUs. */
  @Override
  public boolean matches(Platform platform) {
    return platform.isUnix()
        && ("amd64".equals(platform.getCPU()) || "x86_64".equals(platform.getCPU()));
  }

}
