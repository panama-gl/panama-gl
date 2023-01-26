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
package panamagl.os.macos;

import org.junit.Test;
import org.jzy3d.os.OperatingSystem;
import panamagl.opengl.GL;
import panamagl.opengl.GLContext;

// VM ARGS : -XstartOnFirstThread --enable-native-access=ALL-UNNAMED --add-modules
// jdk.incubator.foreign
// -Djava.library.path=.:/System/Library/Frameworks/OpenGL.framework/Versions/Current/Libraries/
public class TestFBO_macOS {

  @Test
  public void given_CGLAndGLUTContext_whenRenderSomething_ThenGetBufferedImage() {
    if (!new OperatingSystem().isMac())
      return;

    // Given a CGL Context
    GLContext cglContext = new CGLContext_macOS();
    cglContext.init();

    // Given a GLUT context
    GLContext glutContext = new GLUTContext_macOS();
    glutContext.init();

    // Given a GL caller
    GL gl = new GL_macOS();

    TestFBO.givenFBO_whenRenderSomething_ThenGetBufferedImage(gl);

  }

  @Test
  public void given_GLUTContext_ONLY_whenRenderSomething_ThenGetBufferedImage() {

    OperatingSystem os = new OperatingSystem();
    if (!os.isMac())
      return;

    // Given a GLUT context
    GLContext glutContext = new GLUTContext_macOS();
    glutContext.init();

    // Given a GL caller
    GL gl = new GL_macOS();

    TestFBO.givenFBO_whenRenderSomething_ThenGetBufferedImage(gl);

  }

  @Test
  public void given_CGLContext_ONLY_whenRenderSomething_ThenGetBufferedImage() {
    OperatingSystem os = new OperatingSystem();
    if (!os.isMac())
      return;

    // Given a CGL context ONLY
    GLContext context = new CGLContext_macOS();
    context.init();

    GL gl = new GL_macOS();

    TestFBO.givenFBO_whenRenderSomething_ThenGetBufferedImage(gl);

  }



}
