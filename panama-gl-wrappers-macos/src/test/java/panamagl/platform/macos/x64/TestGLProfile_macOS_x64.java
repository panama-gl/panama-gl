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
package panamagl.platform.macos.x64;

import org.junit.Assert;
import org.junit.Test;
import panamagl.GLProfile;
import panamagl.opengl.GL;
import panamagl.platform.macos.GLUTContext_macOS;

// VM ARGS : -XstartOnFirstThread --enable-native-access=ALL-UNNAMED --add-modules
// jdk.incubator.foreign
// -Djava.library.path=.:/System/Library/Frameworks/OpenGL.framework/Versions/Current/Libraries/
public class TestGLProfile_macOS_x64 extends MacOSx86Test{

  @Test
  public void glProfile() {
    if (!checkPlatform())
      return;

    // Given a GL caller
    GL gl = new panamagl.platform.macos.x64.GL_macOS_x64();

    // Given a GLUT context
    GLUTContext_macOS glutContext = new GLUTContext_macOS();
    glutContext.init(false);


    GLProfile p = new GLProfile(gl);

    Assert.assertNotNull(p.getVersion());
    Assert.assertNotNull(p.getVendor());
  }

}
