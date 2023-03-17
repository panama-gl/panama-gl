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
package panamagl.platform.macos;

import org.junit.Ignore;
import org.junit.Test;
import junit.framework.Assert;
import panamagl.opengl.GL;
import panamagl.platform.macos.arm.GL_macOS_arm;

// VM ARGS : -XstartOnFirstThread --enable-native-access=ALL-UNNAMED --enable-preview
// -Djava.library.path=.:/System/Library/Frameworks/OpenGL.framework/Versions/Current/Libraries/

public class TestCGLContext extends MacOSTest {
 @Ignore("Not able to detroy CGL context yet")
  @Test
  public void createCGLContext() {
    if (!checkPlatform())
      return;

    // Given
    CGLContext_macOS cgl = new CGLContext_macOS();

    // When : init
    cgl.init();

    cgl.makeCurrent();

    
    // Then
    Assert.assertTrue(cgl.initialized);

    // When : Cleanup
    cgl.destroy();

    // Then
    Assert.assertFalse(cgl.initialized);
  }

  @Ignore("CRASHING")
  @Test
  public void getVersion() {
    if (!checkPlatform())
      return;

    // Given
    CGLContext_macOS cgl = new CGLContext_macOS();

    // When : init
    cgl.init();


    // Then
    Assert.assertTrue(cgl.initialized);

    
    cgl.makeCurrent();

    GL gl = new GL_macOS_arm();
    System.out.println("version" + gl.glGetString(GL.GL_VERSION));
    
    
    // When : Cleanup
    //cgl.destroy();

    // Then
    //Assert.assertFalse(cgl.initialized);
  }

  @Ignore("Not able to make CGL context current yet")
  @Test
  public void makeProfileFromCGLContext() {
    if (!checkPlatform())
      return;

    System.out.println("-----------");

    // Given
    GL gl = new GL_macOS_arm();
    CGLContext_macOS cgl = new CGLContext_macOS();
    cgl.init();

    System.out.println("DONE INIT CONTEXT");

    // When
    cgl.makeCurrent();

    System.out.println("DONE MAKING CURRENT");

    gl.glClearColor(0, 0, 0, 0);
    gl.glClear(GL.GL_COLOR_BUFFER_BIT);
    //GLProfile profile = new GLProfile(gl);
    // Assert.assertNotNull(profile.getVendor());

    cgl.release();

    // When : Cleanup
    cgl.destroy();

    // Then
    Assert.assertFalse(cgl.initialized);

  }

}
