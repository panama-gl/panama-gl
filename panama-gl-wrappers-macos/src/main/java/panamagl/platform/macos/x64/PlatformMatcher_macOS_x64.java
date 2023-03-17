package panamagl.platform.macos.x64;

import panamagl.platform.Platform;
import panamagl.platform.PlatformMatcher;

public class PlatformMatcher_macOS_x64 implements PlatformMatcher{

  @Override
  public boolean matches(Platform platform) {
    return platform.isMac()  && "x86_64".equals( platform.getCPU());
  }

}
