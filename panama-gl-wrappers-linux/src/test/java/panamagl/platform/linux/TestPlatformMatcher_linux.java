/*******************************************************************************
 * Copyright (c) 2022, 2023 Martin Pernollet & contributors.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301, USA
 *******************************************************************************/
package panamagl.platform.linux;

import org.junit.Assert;
import org.junit.Test;
import panamagl.factory.PanamaGLFactory;
import panamagl.platform.Platform;
import panamagl.platform.linux.arm.PanamaGLFactory_linux_arm;
import panamagl.platform.linux.arm.PlatformMatcher_linux_arm;
import panamagl.platform.linux.x64.PanamaGLFactory_linux_x64;
import panamagl.platform.linux.x64.PlatformMatcher_linux_x64;

/** Runs on any OS : verify the factory selected for each Linux CPU architecture. */
public class TestPlatformMatcher_linux {
  static Platform platform(String os, String cpu) {
    return new Platform(os, "6.8", cpu, "22", false, false, os.toLowerCase().contains("linux"), false);
  }

  static final Platform LINUX_X64 = platform("Linux", "amd64");
  static final Platform LINUX_ARM = platform("Linux", "aarch64");
  static final Platform WINDOWS_X64 = platform("Windows 11", "amd64");

  @Test
  public void whenLinuxX64_ThenX64MatcherOnly() {
    Assert.assertTrue(new PlatformMatcher_linux_x64().matches(LINUX_X64));
    Assert.assertFalse(new PlatformMatcher_linux_arm().matches(LINUX_X64));
  }

  @Test
  public void whenLinuxARM_ThenARMMatcherOnly() {
    Assert.assertTrue(new PlatformMatcher_linux_arm().matches(LINUX_ARM));
    Assert.assertFalse(new PlatformMatcher_linux_x64().matches(LINUX_ARM));
  }

  @Test
  public void whenNotLinux_ThenNoMatch() {
    Assert.assertFalse(new PlatformMatcher_linux_x64().matches(WINDOWS_X64));
    Assert.assertFalse(new PlatformMatcher_linux_arm().matches(WINDOWS_X64));
  }

  @Test
  public void whenSelectingFactory_ThenGetTheOneOfTheCPU() {
    Assert.assertTrue(PanamaGLFactory.selectFor(LINUX_X64) instanceof PanamaGLFactory_linux_x64);
    Assert.assertTrue(PanamaGLFactory.selectFor(LINUX_ARM) instanceof PanamaGLFactory_linux_arm);
  }
}
