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
package panamagl.platform.natives;

/**
 * The OpenGL implementation loaded in this JVM : a process can only use one.
 *
 * <p>The OpenGL functions of the bindings are looked up among the libraries loaded by the class
 * loader (<code>SymbolLookup.loaderLookup()</code>), by name. If two OpenGL implementations were
 * loaded, e.g. the OpenGL framework of Apple for CGL and the libGL of Mesa for EGL on macOS, or
 * the <code>opengl32.dll</code> of Windows and the one of Mesa, which one a function resolves to
 * would be undefined. Each context hence claims the implementation it loads before loading it :
 * claiming another one afterwards fails with an explicit message instead.
 *
 * <p>Contexts sharing an implementation claim the same name : on Linux, GLX and EGL contexts both
 * use the libGL of the system (dispatched by GLVND), and the WGL and GLUT contexts of Windows both
 * use the loaded <code>opengl32.dll</code>.
 */
public final class OpenGLImplementation {
  private static String name;
  private static String origin;

  private OpenGLImplementation() {}

  /**
   * Claim the OpenGL implementation of the given name for this JVM, before loading it.
   *
   * @param name e.g. "Apple OpenGL", "Mesa (Homebrew)", "Windows opengl32", "Mesa llvmpipe"
   * @param origin where it is loaded from, for the messages
   * @throws IllegalStateException if another implementation was claimed.
   */
  public static synchronized void claim(String name, String origin) {
    if (OpenGLImplementation.name == null) {
      OpenGLImplementation.name = name;
      OpenGLImplementation.origin = origin;
    } else if (!OpenGLImplementation.name.equals(name)) {
      throw new IllegalStateException("Cannot use " + name + " (" + origin + ") : this JVM already "
          + "uses " + OpenGLImplementation.name + " (" + OpenGLImplementation.origin + "), and a "
          + "process can only use one OpenGL implementation. Use a single kind of context, or "
          + "another JVM.");
    }
  }

  /** @return the name of the implementation claimed in this JVM, or null. */
  public static synchronized String current() {
    return name;
  }

  /** @return where the implementation claimed in this JVM is loaded from, or null. */
  public static synchronized String origin() {
    return origin;
  }

  /** For tests only : forget the claimed implementation. */
  static synchronized void reset() {
    name = null;
    origin = null;
  }
}
