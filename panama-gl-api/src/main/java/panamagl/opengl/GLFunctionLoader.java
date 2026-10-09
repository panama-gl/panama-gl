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
package panamagl.opengl;

import java.lang.foreign.MemorySegment;

/**
 * Resolve the native address of an OpenGL function at runtime.
 *
 * The system OpenGL libraries only export a subset of the OpenGL API as static symbols (GL 1.1 for
 * opengl32.dll on Windows, a variable subset on Linux). All other functions (VBO, shaders, FBO,
 * etc) must be queried from the driver, e.g. with <code>glXGetProcAddress</code> or
 * <code>wglGetProcAddress</code>.
 *
 * @see AGL#dynamic(String, java.util.function.Supplier)
 *
 * @author Martin Pernollet
 */
public interface GLFunctionLoader {
  /**
   * Return the address of the given OpenGL function, or {@link MemorySegment#NULL} if the function
   * can not be resolved.
   */
  MemorySegment getProcAddress(String function);
}
