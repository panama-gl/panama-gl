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
package panamagl.platform.macos;

import org.junit.Ignore;
import org.junit.Test;
import junit.framework.Assert;
import panamagl.GLProfile;
import panamagl.opengl.GL;
import panamagl.platform.macos.arm.GL_macOS_arm;

//VM ARGS : -XstartOnFirstThread --enable-native-access=ALL-UNNAMED --add-modules jdk.incubator.foreign -Djava.library.path=.:/System/Library/Frameworks/OpenGL.framework/Versions/Current/Libraries/

public class TestCGLContext extends MacOSTest{
  @Ignore("Not working yet")
  @Test
  public void createCGLContext() {
    if (!checkPlatform())
      return;
    
    // Given
    CGLContext_macOS cgl = new CGLContext_macOS();
    
    // When : init
    cgl.init();
    
    // Then
    Assert.assertTrue(cgl.initialized);
        
    // When : Cleanup
    cgl.destroy();
    
    // Then
    Assert.assertFalse(cgl.initialized);
  }
  
  //@Test
  public void makeProfileFromCGLContext() {
    if (!checkPlatform())
      return;
    
    // Given
    GL gl = new GL_macOS_arm();
    CGLContext_macOS cgl = new CGLContext_macOS();
    cgl.init();
    
    // When
    cgl.makeCurrent();
    
    GLProfile profile = new GLProfile(gl);
    
    Assert.assertNotNull(profile.getVendor());
    
    // When : Cleanup
    cgl.destroy();
    
    // Then
    Assert.assertFalse(cgl.initialized);

  }

}
