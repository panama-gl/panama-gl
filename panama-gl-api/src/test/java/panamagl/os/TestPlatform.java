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
package panamagl.os;

import org.junit.Assert;
import org.junit.Test;
import panamagl.platform.Platform;

public class TestPlatform {
  @Test
  public void windows() {
    Assert.assertTrue(new Platform("Windows").isWindows());
    Assert.assertTrue(new Platform("Windows 10").isWindows());
    Assert.assertTrue(new Platform("Windows 11").isWindows());
    Assert.assertFalse(new Platform("Windows").isMac());
    Assert.assertFalse(new Platform("Windows").isUnix());
    Assert.assertFalse(new Platform("Windows").isSolaris());

    Assert.assertTrue(new Platform("mac os x").isMac());
    Assert.assertFalse(new Platform("mac os x").isWindows());
    
    Assert.assertTrue(Platform.WINDOWS.isWindows());
  }
  
  @Test
  public void macos() {
    Assert.assertTrue(new Platform("mac os x").isMac());
    Assert.assertFalse(new Platform("mac os x").isWindows());
    
    Assert.assertTrue(Platform.MACOS.isMac());
  }
  
  @Test
  public void unix() {
    Assert.assertTrue(Platform.UNIX.isUnix());
  }
}
