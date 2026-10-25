package panamagl.platform.windows;

import panamagl.platform.Platform;
import panamagl.platform.PlatformMatcher;

/**
 * Matches Windows on the 64-bit CPUs PanamaGL is tested on : x86_64 (reported by Java as
 * <code>amd64</code> or <code>x86_64</code>) and ARM64 (<code>aarch64</code> or <code>arm64</code>).
 *
 * The bindings of Windows are the same for both CPUs : the Foreign Function and Memory API applies the
 * calling convention of the running CPU.
 */
public class PlatformMatcher_windows implements PlatformMatcher{

  @Override
  public boolean matches(Platform platform) {
    return platform.isWindows() && is64Bit(platform.getCPU());
  }

  protected boolean is64Bit(String cpu) {
    return "amd64".equals(cpu) || "x86_64".equals(cpu) || "aarch64".equals(cpu)
        || "arm64".equals(cpu);
  }

}
