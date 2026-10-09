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

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import panamagl.opengl.GLFunctionLoader;
import wgl.windows.x86.wgl_h;

/**
 * Resolve OpenGL functions with <code>wglGetProcAddress</code>, falling back on the symbols
 * exported by opengl32.dll (GL 1.1) for which <code>wglGetProcAddress</code> returns nothing.
 * 
 * A GL context must be current on the calling thread. Addresses may depend on the context pixel
 * format, which is why each {@link panamagl.opengl.GL} instance keeps its own cache.
 * 
 * @author Martin Pernollet
 */
public class GLFunctionLoader_windows implements GLFunctionLoader {
  @Override
  public MemorySegment getProcAddress(String function) {
    try (Arena arena = Arena.ofConfined()) {
      MemorySegment name = arena.allocateFrom(function);
      MemorySegment address = wgl_h.wglGetProcAddress(name);

      if (isValid(address)) {
        return address;
      }

      MemorySegment opengl32 = wgl_h.GetModuleHandleA(arena.allocateFrom("opengl32.dll"));
      if (isValid(opengl32)) {
        address = wgl_h.GetProcAddress(opengl32, name);
        if (isValid(address)) {
          return address;
        }
      }
      return MemorySegment.NULL;
    }
  }

  /**
   * wglGetProcAddress may return 1, 2, 3 or -1 instead of NULL to report a failure.
   * 
   * @see https://www.khronos.org/opengl/wiki/Load_OpenGL_Functions
   */
  protected boolean isValid(MemorySegment address) {
    if (address == null)
      return false;
    long a = address.address();
    return a != 0 && a != 1 && a != 2 && a != 3 && a != -1;
  }
}
