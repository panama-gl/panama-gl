package panamagl.platform.macos.arm;

import panamagl.platform.Platform;
import panamagl.platform.PlatformMatcher;

public class PlatformMatcher_macOS_arm implements PlatformMatcher{

  @Override
  public boolean matches(Platform platform) {
    return platform.isMac() && "aarch64".equals( platform.getCPU());
  }

}
