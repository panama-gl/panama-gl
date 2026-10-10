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
package panamagl.platform.linux;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import glx.linux.x86.glx_h;
import panamagl.opengl.GLFunctionLoader;

/**
 * Resolve OpenGL functions with <code>glXGetProcAddress</code>.
 * 
 * GLX returns context-independent addresses, so functions can be resolved before a context is made
 * current. Note that Mesa returns a dispatch stub even for functions that the driver does not
 * implement.
 * 
 * @author Martin Pernollet
 */
public class GLFunctionLoader_linux implements GLFunctionLoader {
  @Override
  public MemorySegment getProcAddress(String function) {
    try (Arena arena = Arena.ofConfined()) {
      MemorySegment address = glx_h.glXGetProcAddress(arena.allocateFrom(function));
      return address == null ? MemorySegment.NULL : address;
    }
  }
}
