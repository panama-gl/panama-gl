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
import opengl.linux.gl_h;
import panamagl.opengl.GLFunctionLoader;

/**
 * Resolve OpenGL functions with <code>glXGetProcAddress</code>, or with
 * <code>eglGetProcAddress</code> once PanamaGL created an {@link EGLContext_linux} in this process.
 * 
 * GLX returns context-independent addresses, so functions can be resolved before a context is made
 * current. Note that Mesa returns a dispatch stub even for functions that the driver does not
 * implement.
 * 
 * With GLVND, the addresses returned by GLX are dispatch stubs that also work with an EGL context,
 * but only EGL is guaranteed to return the functions of the implementation that EGL selected : the
 * EGL path hence uses <code>eglGetProcAddress</code>, without loading libEGL when EGL is not used.
 * 
 * @author Martin Pernollet
 * 
 * <p><img src="doc-files/egl-gl-glext.svg" alt="EGL, GL and GLEXT in PanamaGL" style="max-width:100%"/>
 */
public class GLFunctionLoader_linux implements GLFunctionLoader {
  @Override
  public MemorySegment getProcAddress(String function) {
    if (EGLContext_linux.isUsed()) {
      return EGL_linux.get().procAddress(function);
    }
    try (Arena arena = Arena.ofConfined()) {
      return gl_h.glXGetProcAddress(arena.allocateFrom(function));
    }
  }

  /** @return the API resolving the functions : "EGL" or "GLX". */
  public String getResolver() {
    return EGLContext_linux.isUsed() ? "EGL" : "GLX";
  }
}
