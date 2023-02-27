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
package demos.panamagl.offscreen;

import panamagl.opengl.GL;
import panamagl.opengl.GLContext;
import panamagl.os.macos.x86_64.GLUTContext_macOS;

/**
 * https://github.com/jzy3d/panama-gl/issues/5
 */
// VM ARGS : -XstartOnFirstThread --enable-native-access=ALL-UNNAMED --add-modules jdk.incubator.foreign -Djava.library.path=.:/System/Library/Frameworks/OpenGL.framework/Versions/Current/Libraries/
public class DemoTriangle_Offscreen_macOS {

  public static void main(String[] args) {
    GLContext context = new GLUTContext_macOS();
    context.init();

    GL gl = new panamagl.platform.macos.x86.GL_macOS_x86();

    demos.panamagl.offscreen.Demo_Offscreen.fbo_offscreen(gl);
  }
}
