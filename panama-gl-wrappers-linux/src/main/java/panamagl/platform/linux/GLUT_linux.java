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

import panamagl.platform.natives.OpenGLImplementation;
import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import java.util.function.Supplier;
import opengl.linux.NativeLibLoader;
import opengl.linux.gl_h;

/**
 * Initialize GLUT at the first GLUT call of {@link GL_linux}, once per process.
 *
 * <p>The GLX and GLUT contexts initialize GLUT themselves. A headless {@link EGLContext_linux} does
 * not : GLUT functions (e.g. <code>glutSolidTeapot</code>, <code>glutBitmapString</code>) then
 * initialize it here. freeglut requires an X display for <code>glutInit</code>, even though the
 * GLUT drawing functions only issue OpenGL calls in the current context : without a display, this
 * class throws an {@link UnsupportedOperationException} instead of letting freeglut terminate the
 * JVM, which it does when a GLUT function is invoked before <code>glutInit</code>.
 */
public class GLUT_linux {
  /** Environment variable giving the X display that freeglut connects to. */
  public static final String DISPLAY = "DISPLAY";

  /** Reads the X display, replaceable by tests. */
  static Supplier<String> display = () -> System.getenv(DISPLAY);

  /**
   * Invoke glutInit if no PanamaGL context did it yet.
   *
   * @throws UnsupportedOperationException if GLUT is not initialized and no X display is available.
   */
  public static void init() {
    if (GLUTContext_linux.hasInit)
      return;
    synchronized (GLUT_linux.class) {
      if (GLUTContext_linux.hasInit)
        return;
      if (!hasDisplay())
        throw new UnsupportedOperationException("GLUT functions require an X display : "
            + "DISPLAY is not set, e.g. with a headless EGL context");

      OpenGLImplementation.claim(MesaLibraries.SYSTEM_LIBGL, "libGL of the system");
      NativeLibLoader.load();

      // glutInit(&argc, argv) with argc = 0 : no command line argument for GLUT
      Arena arena = Arena.global();
      MemorySegment argc = arena.allocateFrom(ValueLayout.JAVA_INT, 0);
      MemorySegment argv = arena.allocateFrom(ValueLayout.ADDRESS, arena.allocateFrom(""));
      gl_h.glutInit(argc, argv);
      GLUTContext_linux.hasInit = true;
    }
  }

  /** @return true if GLUT has been initialized in this process. */
  public static boolean isInitialized() {
    return GLUTContext_linux.hasInit;
  }

  /** @return true if an X display is available to GLUT. */
  public static boolean hasDisplay() {
    String value = display.get();
    return value != null && !value.isBlank();
  }
}
