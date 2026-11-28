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
package demos.panamagl.rendering;

import java.lang.foreign.Arena;
import panamagl.opengl.GL;

/** The {@link ReferenceScene} as a {@link Scene} : fixed function features of OpenGL 1.x. */
public class BasicScene implements Scene {
  @Override
  public String getName() {
    return "reference-scene";
  }

  @Override
  public void init(GL gl, Arena arena, int width, int height) {
    ReferenceScene.init(gl, arena, width, height);
  }

  @Override
  public void display(GL gl, float time) {
    ReferenceScene.display(gl, time * 15);
  }

  @Override
  public void dispose(GL gl) {
    gl.glDisable(GL.GL_LIGHTING);
    gl.glDisable(GL.GL_COLOR_MATERIAL);
    gl.glDisable(GL.GL_DEPTH_TEST);
  }

  @Override
  public float referenceTime() {
    return 2f;
  }

  @Override
  public int timedFrames() {
    return 30;
  }
}
