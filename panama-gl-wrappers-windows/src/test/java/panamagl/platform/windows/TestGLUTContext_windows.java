/*******************************************************************************
 * Copyright (c) 2022, 2023 Martin Pernollet & contributors.
 *
 * This library is free software; you can redistribute it and/or modify it under the terms of the
 * GNU Lesser General Public License as published by the Free Software Foundation; either version
 * 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License along with this library;
 * if not, write to the Free Software Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA
 * 02110-1301, USA
 *******************************************************************************/
package panamagl.platform.windows;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import panamagl.GLProfile;
import panamagl.opengl.GL;

// VM ARGS : --enable-native-access=ALL-UNNAMED -Djava.library.path="C:\Windows\system32;C:\Users\Martin\Downloads\freeglut-MSVC-3.0.0-2.mp\freeglut\bin\x64"
public class TestGLUTContext_windows extends WindowsTest {
  
//@Ignore("Crashing JVM since JDK22 / EXCEPTION_ACCESS_VIOLATION (0xc0000005) at pc=0x00007ff9fa68c4ec")
  @Test
  public void createContext() {
    if (!checkPlatform())
      return;

    // Given
    GLUTContext_windows context = new GLUTContext_windows();

    // When
    context.init();
    
    // Then 
    Assert.assertTrue(context.isInitialized());

    // When
    GL gl = new panamagl.platform.windows.x64.GL_windows_x64();
    GLProfile p = new GLProfile(gl);

    // Then
    Assert.assertNotNull(p.getVersion());
    Assert.assertNotNull(p.getVendor());

    System.out.println(TestGLUTContext_windows.class.getSimpleName()
        + " running with OpenGL version : " + p.getVersion() + "/" + p.getVendor());

    // When
    context.destroy();
    
    // Then
    Assert.assertFalse(context.isInitialized());
  }
}
