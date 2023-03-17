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
package panamagl.platform.macos.x64;

import panamagl.platform.Platform;
import panamagl.platform.macos.x64.PlatformMatcher_macOS_x64;

public class MacOSx86Test {
  /**
   * Print a message in console if not running on macos x64
   * @return
   */
  public boolean checkPlatform() {
    Platform platform = new Platform();
    boolean isPlatform = new PlatformMatcher_macOS_x64().matches(platform);

    if(!isPlatform) {
      System.err.println(" !! \n    Skip test since not on appropriate platform : " + platform + "\n !!");
    }
    
    return isPlatform;
  }
  

}
