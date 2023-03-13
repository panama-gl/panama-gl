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
package panamagl.platform.linux;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import panamagl.offscreen.TestFBO;
import panamagl.opengl.GL;
import panamagl.opengl.GLContext;

// VM ARGS : --enable-native-access=ALL-UNNAMED --enable-preview -Djava.library.path=.://usr/lib/x86_64-linux-gnu/
public class TestFBO_linux extends LinuxTest{
  // TODO
@Ignore("Works from IDE but not from CLI yet")
  @Test
  public void given_GLUTContext_ONLY_whenRenderSomething_ThenGetBufferedImage() {
    if (!checkPlatform())
      return;

    // Given a GLUT context
    GLContext glutContext = new GLUTContext_linux();
    glutContext.init();

    // Given a GL caller
    GL gl = new panamagl.platform.linux.x86.GL_linux_x86();
    
    // Given a FBO UNDER TEST
    int width = 256;
    int height = 256;
    FBO_linux fbo = new FBO_linux(width, height);
    
    // Ensure does not leave this debug flag to false
    Assert.assertTrue(fbo.arrayExport);
    
    // Ensure conforms to configuration
    Assert.assertEquals(width, fbo.getWidth());
    Assert.assertEquals(height, fbo.getHeight());

    // Execute validation scenario
    TestFBO.givenFBO_whenRenderSomething_ThenGetBufferedImage(fbo, gl);

  }

  /*@Test
  public void given_CGLContext_ONLY_whenRenderSomething_ThenGetBufferedImage() {
    if (!checkPlatform())
      return;

    // Given a CGL context ONLY
    GLContext context = new CGLContext_macOS();
    context.init();

    GL gl = new panamagl.platform.macos.x86.GL_macOS_x86();

    TestFBO.givenFBO_whenRenderSomething_ThenGetBufferedImage(gl);

  }*/

}
