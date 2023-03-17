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
package panamagl.platform.linux;

import org.junit.Assert;
import org.junit.Test;
import panamagl.GLProfile;
import panamagl.opengl.GL;

// VM ARGS : --enable-native-access=ALL-UNNAMED --enable-preview -Djava.library.path=.://usr/lib/x86_64-linux-gnu/
public class TestGLXContext_linux extends LinuxTest {
  @Test
  public void createContext() {
    if (!checkPlatform())
      return;

    // Given
    GLXContext_linux context = new GLXContext_linux();

    // --------------------------
    // When
    context.init();
    
    // Then
    Assert.assertTrue(context.initialized);

    // --------------------------
    // When
    
    context.makeCurrent();

    GL gl = new panamagl.platform.linux.x86.GL_linux_x86();
    GLProfile p = new GLProfile(gl);

    // Then
    Assert.assertNotNull(p.getVersion());
    Assert.assertNotNull(p.getVendor());

    System.out.println(TestGLXContext_linux.class.getSimpleName()
        + " running with OpenGL version : " + p.getVersion() + "/" + p.getVendor());

    // --------------------------
    // When
    context.destroy();
    
    // Then
    Assert.assertFalse(context.initialized);
  }
}
