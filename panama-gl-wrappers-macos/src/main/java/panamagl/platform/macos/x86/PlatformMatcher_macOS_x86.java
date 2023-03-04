package panamagl.platform.macos.x86;

import panamagl.platform.Platform;
import panamagl.platform.PlatformMatcher;

public class PlatformMatcher_macOS_x86 implements PlatformMatcher{

  @Override
  public boolean matches(Platform platform) {
    return platform.isMac()  && "x86_64".equals( platform.getCPU());
  }

}
