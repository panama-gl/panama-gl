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

import panamagl.platform.Platform;
import panamagl.platform.PlatformMatcher;

public class LinuxTest {
  /**
   * Print a message in console if not running on linux
   * @return
   */
  public boolean checkPlatform() {
    Platform platform = new Platform();
    boolean isPlatform = platform.isUnix();

    if(!isPlatform) {
      System.err.println(" !! \n    Skip test since not on Linux : " + platform + "\n !!");
    }
    
    return isPlatform;
  }

  /**
   * Print a message in console if not running on the CPU architecture of the given matcher
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
  

}
