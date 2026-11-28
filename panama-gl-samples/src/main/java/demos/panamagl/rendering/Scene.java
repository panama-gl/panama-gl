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

/**
 * A 3D scene rendered by the same OpenGL calls on every backend, to compare them. A scene draws in
 * the framebuffer bound by the caller (a FBO of PanamaGL), and only uses OpenGL 2.1 and GLSL 1.20
 * so that it runs on every OS, including the legacy profile of macOS.
 *
 * <p>{@link #display(GL, float)} is deterministic for a given time : the renderings made at
 * {@link #referenceTime()} can be compared pixel by pixel.
 */
public interface Scene {
  /** @return a short name, used in the names of the renderings, e.g. "fractal". */
  String getName();

  /** Create the resources of the scene : shaders, buffers, textures, display lists. */
  void init(GL gl, Arena arena, int width, int height);

  /** Draw the scene at the given time, in seconds. */
  void display(GL gl, float time);

  /** Release the resources of the scene. */
  void dispose(GL gl);

  /** @return the time of the renderings that are compared. */
  default float referenceTime() {
    return 2f;
  }

  /** @return the number of frames rendered to measure the time per frame. */
  default int timedFrames() {
    return 10;
  }
}
