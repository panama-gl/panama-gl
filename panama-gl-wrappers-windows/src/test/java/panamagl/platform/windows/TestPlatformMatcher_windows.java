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
package panamagl.platform.windows;

import org.junit.Assert;
import org.junit.Test;
import panamagl.factory.PanamaGLFactory;
import panamagl.platform.Platform;
import panamagl.platform.windows.arm.PanamaGLFactory_windows_arm;
import panamagl.platform.windows.arm.PlatformMatcher_windows_arm;
import panamagl.platform.windows.x64.PanamaGLFactory_windows_x64;
import panamagl.platform.windows.x64.PlatformMatcher_windows_x64;

/** Runs on any OS : verify the factory selected for each Windows CPU architecture. */
public class TestPlatformMatcher_windows {
  static Platform platform(String os, String cpu) {
    return new Platform(os, "10.0", cpu, "22", os.toLowerCase().contains("win"), false, false, false);
  }

  static final Platform WINDOWS_X64 = platform("Windows 11", "amd64");
  static final Platform WINDOWS_ARM = platform("Windows 11", "aarch64");
  static final Platform LINUX_X64 = platform("Linux", "amd64");

  @Test
  public void whenWindowsX64_ThenX64MatcherOnly() {
    Assert.assertTrue(new PlatformMatcher_windows_x64().matches(WINDOWS_X64));
    Assert.assertFalse(new PlatformMatcher_windows_arm().matches(WINDOWS_X64));
  }

  @Test
  public void whenWindowsARM_ThenARMMatcherOnly() {
    Assert.assertTrue(new PlatformMatcher_windows_arm().matches(WINDOWS_ARM));
    Assert.assertFalse(new PlatformMatcher_windows_x64().matches(WINDOWS_ARM));
  }

  @Test
  public void whenNotWindows_ThenNoMatch() {
    Assert.assertFalse(new PlatformMatcher_windows_x64().matches(LINUX_X64));
    Assert.assertFalse(new PlatformMatcher_windows_arm().matches(LINUX_X64));
  }

  @Test
  public void whenSelectingFactory_ThenGetTheOneOfTheCPU() {
    Assert.assertTrue(PanamaGLFactory.selectFor(WINDOWS_X64) instanceof PanamaGLFactory_windows_x64);
    Assert.assertTrue(PanamaGLFactory.selectFor(WINDOWS_ARM) instanceof PanamaGLFactory_windows_arm);
  }
}
