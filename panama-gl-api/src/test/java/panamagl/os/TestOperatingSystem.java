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

public class TestOperatingSystem {
  @Test
  public void windows() {
    Assert.assertTrue(new OperatingSystem("Windows").isWindows());
    Assert.assertTrue(new OperatingSystem("Windows 10").isWindows());
    Assert.assertTrue(new OperatingSystem("Windows 11").isWindows());
    Assert.assertFalse(new OperatingSystem("Windows").isMac());
    Assert.assertFalse(new OperatingSystem("Windows").isUnix());
    Assert.assertFalse(new OperatingSystem("Windows").isSolaris());

    Assert.assertTrue(new OperatingSystem("mac os x").isMac());
    Assert.assertFalse(new OperatingSystem("mac os x").isWindows());
    
    Assert.assertTrue(OperatingSystem.WINDOWS.isWindows());
  }
  
  @Test
  public void macos() {
    Assert.assertTrue(new OperatingSystem("mac os x").isMac());
    Assert.assertFalse(new OperatingSystem("mac os x").isWindows());
    
    Assert.assertTrue(OperatingSystem.MACOS.isMac());
  }
  
  @Test
  public void unix() {
    Assert.assertTrue(OperatingSystem.UNIX.isUnix());
  }
}
