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
package panamagl.platform.windows.arm;

import org.junit.Assert;
import org.junit.Test;
import panamagl.factory.PanamaGLFactory;
import panamagl.opengl.GL;
import panamagl.opengl.GLContext;
import panamagl.platform.windows.WindowsTest;

public class TestPanamaGLFactory_windows_arm extends WindowsTest{
  @Test
  public void test() {
    if (!checkPlatform(new PlatformMatcher_windows_arm()))
      return;
  
    // When seek a factory
    PanamaGLFactory f = PanamaGLFactory.select();
    
    // Then expect to find the Windows ARM one
    Assert.assertTrue(f.getClass().getName(), f instanceof PanamaGLFactory_windows_arm);

    // ----------------------------
    // When initializing the factory objects, then get not null
    
    GLContext context = f.newGLContext();
    Assert.assertNotNull(context);
    
    GL gl = f.newGL();
    Assert.assertTrue(gl instanceof GL_windows_arm);
    Assert.assertNotNull(f.newOffscreenRenderer(null));
    Assert.assertNotNull(f.newFBO(800, 600));

    // Then the x64 bindings can invoke the ARM64 OpenGL library
    String version = gl.glGetString(GL.GL_VERSION).getString(0);
    System.out.println("TestPanamaGLFactory_windows_arm running with OpenGL version : " + version);
    Assert.assertFalse(version.isEmpty());
    
    // ----------------------------
    // When
    context.destroy();
    
    // Then
    Assert.assertFalse(context.isInitialized());
  }
}
