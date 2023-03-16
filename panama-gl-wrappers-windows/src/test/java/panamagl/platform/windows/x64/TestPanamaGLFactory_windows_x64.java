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
package panamagl.platform.windows.x64;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import panamagl.factory.PanamaGLFactory;
import panamagl.opengl.GLContext;
import panamagl.platform.windows.WindowsTest;

//VM ARGS : --enable-native-access=ALL-UNNAMED --enable-preview -Djava.library.path="C:\Windows\system32;C:\Users\Martin\Downloads\freeglut-MSVC-3.0.0-2.mp\freeglut\bin\x64"
public class TestPanamaGLFactory_windows_x64 extends WindowsTest{
//FIXME : https://gitlab.com/jzy3d/panama-gl/-/issues/27
//@Ignore("Works from IDE but not from CLI yet")
  @Test
  public void test() {
    if (!checkPlatform())
      return;
  
    // When seek a factory
    PanamaGLFactory f = PanamaGLFactory.select();
    
    // Then expect to find the linux one
    boolean matched = f instanceof PanamaGLFactory_windows_x64;
    
    Assert.assertTrue(matched);

    // ----------------------------
    // When initializing the factory objects, then get not null
    
    GLContext context = f.newGLContext();
    Assert.assertNotNull(context);
    Assert.assertNotNull(f.newGL());
    Assert.assertNotNull(f.newOffscreenRenderer());
    Assert.assertNotNull(f.newFBO(800, 600));
    
    // ----------------------------
    // When
    context.destroy();
    
    // Then
    Assert.assertFalse(context.isInitialized());
  }
}
