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
package panamagl.platform.macos.x86;

import org.junit.Assert;
import org.junit.Test;
import panamagl.factory.PanamaGLFactory;

public class TestPanamaGLFactory_macOS_x86 extends MacOSx86Test{
  @Test
  public void test() {
    if (!checkPlatform())
      return;
  
    PanamaGLFactory f = PanamaGLFactory.select();
    
    boolean matched = f instanceof PanamaGLFactory_macOS_x86;
    
    Assert.assertTrue(matched);

    // Issue on context init
    //Assert.assertNotNull(f.newGLContext());

    Assert.assertNotNull(f.newGL());
    Assert.assertNotNull(f.newOffscreenRenderer());
    Assert.assertNotNull(f.newFBO(800, 600));
    Assert.assertNotNull(f.newCanvasSwing());

    ;
  }
}
