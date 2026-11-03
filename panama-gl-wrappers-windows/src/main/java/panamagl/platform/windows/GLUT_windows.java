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
import java.lang.foreign.ValueLayout;
import opengl.windows.gl_h;

/**
 * Load and initialize freeglut lazily, as it is optional on Windows : the WGL context and the
 * OpenGL and GLU functions do not need it.
 *
 * {@link #init()} must be invoked before any GLUT function of the binding (<code>gl_h.glut*</code>),
 * which it does for :
 * <ul>
 * <li>the GLUT methods of {@link GL_windows}, whose generated code invokes it first,</li>
 * <li>{@link GLUTContext_windows}.</li>
 * </ul>
 * Code invoking GLUT functions of the binding directly must invoke {@link #init()} first :
 * <ul>
 * <li>the binding resolves the address of a function at its first invocation, and fails for good if
 * freeglut is not loaded yet,</li>
 * <li>freeglut exits the process if a function is invoked before glutInit.</li>
 * </ul>
 */
public class GLUT_windows {
  protected static volatile boolean initialized = false;

  /**
   * Load freeglut with {@link NativeLibLoader_windows#loadGLUT()} and invoke glutInit, once per
   * process. Following invocations return immediately.
   *
   * @throws UnsatisfiedLinkError if freeglut is neither in the <code>java.library.path</code> nor
   *         embedded in the classpath by <code>panama-gl-bindings-windows-freeglut</code>.
   */
  public static void init() {
    if (initialized)
      return;

    synchronized (GLUT_windows.class) {
      if (initialized)
        return;

      NativeLibLoader_windows.loadGLUT();

      // glutInit(&argc, argv) with argc = 0 : no command line argument for GLUT
      Arena arena = Arena.global();
      MemorySegment argc = arena.allocateFrom(ValueLayout.JAVA_INT, 0);
      MemorySegment argv = arena.allocateFrom(ValueLayout.ADDRESS, arena.allocateFrom(""));
      gl_h.glutInit(argc, argv);

      initialized = true;
    }
  }

  /** True once {@link #init()} has loaded and initialized freeglut. */
  public static boolean isInitialized() {
    return initialized;
  }
}
