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

import java.io.File;
import java.lang.foreign.Arena;
import java.nio.file.Files;
import java.nio.file.Path;
import org.junit.Assert;
import org.junit.Assume;
import opengl.windows.gl_h;
import panamagl.platform.Platform;
import panamagl.platform.PlatformMatcher;

public class WindowsTest {
  /**
   * Indicate a message in console if not running on macos
   * @return
   */
  public boolean checkPlatform() {
    Platform platform = new Platform();
    boolean isPlatform = platform.isWindows();

    if(!isPlatform) {
      System.err.println(" !! \n    Skip test since not on Windows : " + platform + "\n !!");
    }
    
    return isPlatform;
  }

  /**
   * Indicate a message in console if not running on the CPU architecture of the given matcher
   * @return
   */
  public boolean checkPlatform(PlatformMatcher matcher) {
    Platform platform = new Platform();
    boolean isPlatform = matcher.matches(platform);

    if(!isPlatform) {
      System.err.println(" !! \n    Skip test since not on " + matcher.getClass().getSimpleName() + " : " + platform + "\n !!");
    }
    
    return isPlatform;
  }
  


  /** True when running on a CI server, which sets the CI environment variable (e.g. GitHub). */
  public static boolean isCI() {
    return System.getenv("CI") != null;
  }

  /**
   * Skip the test if the condition does not hold on a developer computer, but fail on CI, whose
   * configuration guarantees it : a skipped test would hide that CI no longer tests it.
   */
  public static void assumeOrFailOnCI(String message, boolean condition) {
    if (isCI())
      Assert.assertTrue(message, condition);
    else
      Assume.assumeTrue(message, condition);
  }

  /** The file of the given name in a folder of the java.library.path, or null. */
  public static Path findInLibraryPath(String file) {
    for (String folder : System.getProperty("java.library.path", "").split(File.pathSeparator)) {
      if (!folder.isBlank() && Files.isRegularFile(Path.of(folder, file)))
        return Path.of(folder, file);
    }
    return null;
  }

  /** Ask Windows whether a module of the given name (e.g. freeglut.dll) is loaded in this process. */
  public static boolean isModuleLoaded(String module) {
    try (Arena arena = Arena.ofConfined()) {
      return gl_h.GetModuleHandleA(arena.allocateFrom(module)).address() != 0;
    }
  }
}
