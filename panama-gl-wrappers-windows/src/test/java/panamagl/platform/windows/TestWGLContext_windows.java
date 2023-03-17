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

import org.junit.Ignore;
import org.junit.Test;
import junit.framework.Assert;
import panamagl.opengl.GL;
import panamagl.platform.windows.x64.GL_windows_x64;

// VM ARGS : -XstartOnFirstThread --enable-native-access=ALL-UNNAMED --enable-preview
// -Djava.library.path="C:\Windows\system32;C:\Users\Martin\Downloads\freeglut-MSVC-3.0.0-2.mp\freeglut\bin\x64"

public class TestWGLContext_windows extends WindowsTest {
  @Test
  public void createWGLContext_simple() {
    if (!checkPlatform())
      return;

    // Given
    WGLContext_windows wgl = new WGLContext_windows(false);
    
    // When : init
    wgl.init();

    // Then
    Assert.assertNotNull(wgl.context);
    Assert.assertTrue(wgl.isInitialized());
    
    // When : makeCurrent
    wgl.makeCurrent();

    // When : Cleanup
    wgl.destroy();

    // Then
    Assert.assertNull(wgl.context);
    Assert.assertFalse(wgl.isInitialized());
  }
  
@Ignore("Not working yet : can not invoke OpenGL after making context current, maybe because of the HDC being null")
  @Test
  public void getOpenGLVersion() {
    if (!checkPlatform())
      return;

    // Given
    WGLContext_windows wgl = new WGLContext_windows();
    
    // When : init
    wgl.init(false);

    // Then
    Assert.assertNotNull(wgl.context);
    Assert.assertTrue(wgl.isInitialized());
    
    // When : makeCurrent
    wgl.makeCurrent();
    
    GL gl = new GL_windows_x64();
    
    String version = gl.glGetString(GL.GL_VERSION);
    System.out.println(version);

    // When : Cleanup
    wgl.destroy();

    // Then
    Assert.assertNull(wgl.context);
    Assert.assertFalse(wgl.isInitialized());
  }
  
@Ignore("Not working yet : can not choose pixel format, maybe because of the HDC being null")
  @Test
  public void createWGLContext_advanced() {
    if (!checkPlatform())
      return;

    // Given
    WGLContext_windows wgl = new WGLContext_windows(true);

    // Then functions are properly loaded
    Assert.assertNotNull(wgl.wglChoosePixelFormatARB);
    Assert.assertNotNull(wgl.wglCreateContextAttribsARB);
    
    // When : init
    wgl.init(false);

    // Then
    Assert.assertNotNull(wgl.context);
    Assert.assertTrue(wgl.isInitialized());
    
    // When : makeCurrent
    wgl.makeCurrent();

    // When : Cleanup
    wgl.destroy();

    // Then
    Assert.assertNull(wgl.context);
    Assert.assertFalse(wgl.isInitialized());
  }

}
