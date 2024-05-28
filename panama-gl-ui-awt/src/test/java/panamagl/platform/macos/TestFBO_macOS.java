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

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import panamagl.offscreen.FBOReader_AWT;
import panamagl.offscreen.TestFBO;
import panamagl.opengl.GL;
import panamagl.opengl.GLContext;

// VM ARGS : -XstartOnFirstThread --enable-native-access=ALL-UNNAMED --enable-preview -Djava.library.path=.:/System/Library/Frameworks/OpenGL.framework/Versions/Current/Libraries/
public class TestFBO_macOS extends MacOSTest{
  @Test
  public void given_GLUTContext_whenRenderSomething_ThenGetBufferedImage() {
    if (!checkPlatform())
      return;

    // Given a GLUT context
    GLContext glutContext = new GLUTContext_macOS();
    glutContext.init();

    // Given a GL caller
    GL gl = new panamagl.platform.macos.arm.GL_macOS_arm();

    // ---------------------------------------
    // When initialize a FBO UNDER TEST
    int width = 256;
    int height = 256;
    FBO_macOS fbo = new FBO_macOS(width, height);
    FBOReader_AWT reader = new FBOReader_AWT();

    // Ensure does not leave this debug flag to false
    Assert.assertTrue(reader.isArrayExport());
    
    // Ensure conforms to configuration
    Assert.assertEquals(width, fbo.getWidth());
    Assert.assertEquals(height, fbo.getHeight());

    // Execute validation scenario
    TestFBO.givenFBO_whenRenderSomething_ThenGetBufferedImage(fbo, reader, gl);

    // ---------------------------------------
    // When Release context resources
    glutContext.destroy();

    // Then
    Assert.assertFalse(glutContext.isInitialized());
  }

  @Ignore("CGL Not working yet")
  @Test
  public void given_CGLContext_whenRenderSomething_ThenGetBufferedImage() {
    if (!checkPlatform())
      return;

    // Given a CGL context ONLY
    GLContext context = new CGLContext_macOS();
    context.init();

    GL gl = new panamagl.platform.macos.arm.GL_macOS_arm();

    // Given a FBO UNDER TEST
    int width = 256;
    int height = 256;
    FBO_macOS fbo = new FBO_macOS(width, height);
    FBOReader_AWT reader = new FBOReader_AWT();
    
    // Ensure does not leave this debug flag to false
    Assert.assertTrue(reader.isArrayExport());
    
    // Ensure conforms to configuration
    Assert.assertEquals(width, fbo.getWidth());
    Assert.assertEquals(height, fbo.getHeight());

    // Execute validation scenario
    TestFBO.givenFBO_whenRenderSomething_ThenGetBufferedImage(fbo, reader, gl);

  }

}
