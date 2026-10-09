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
package panamagl.platform.macos;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.SymbolLookup;
import java.nio.file.Path;
import panamagl.opengl.GLFunctionLoader;

/**
 * Resolve OpenGL functions that are not part of the static bindings by looking for their symbol in
 * the OpenGL framework.
 * 
 * Note that the macOS legacy profile only supports OpenGL 2.1 : functions of later versions are
 * exported by the framework but only work with a core profile context.
 * 
 * @author Martin Pernollet
 */
public class GLFunctionLoader_macOS implements GLFunctionLoader {
  public static final String OPENGL_FRAMEWORK = "/System/Library/Frameworks/OpenGL.framework/OpenGL";

  protected SymbolLookup lookup;

  @Override
  public MemorySegment getProcAddress(String function) {
    if (lookup == null) {
      lookup = SymbolLookup.libraryLookup(Path.of(OPENGL_FRAMEWORK), Arena.global());
    }
    return lookup.find(function).orElse(MemorySegment.NULL);
  }
}
