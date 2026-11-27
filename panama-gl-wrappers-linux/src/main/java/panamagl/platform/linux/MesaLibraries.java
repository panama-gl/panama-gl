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

import java.io.File;
import java.util.Locale;
import opengl.linux.NativeLibLoader;

/**
 * The native libraries used with an {@link EGLContext_linux}.
 *
 * <p>On Linux, they are the libraries of the system : <code>libEGL.so.1</code>, and the OpenGL,
 * GLU, GLUT and GLX libraries loaded by {@link NativeLibLoader}.
 *
 * <p>The EGL context and the OpenGL functions of {@link GL_linux} only use the C API of EGL and
 * OpenGL, which is the same on macOS. They hence also run on macOS with <b>Mesa</b>, e.g. as installed
 * by Homebrew (<code>brew install mesa mesa-glu</code>), which provides the OpenGL implementations
 * of Mesa on macOS : llvmpipe (CPU) and Zink, i.e. OpenGL over Vulkan, Vulkan being implemented over
 * Metal by KosmicKrisp or MoltenVK. On macOS, the libraries are loaded from absolute paths, which
 * the following system properties can change :
 *
 * <ul>
 * <li><code>panamagl.mesa.egl</code> : default <code>/opt/homebrew/opt/mesa/lib/libEGL.dylib</code></li>
 * <li><code>panamagl.mesa.gl</code> : default <code>/opt/homebrew/opt/mesa/lib/libGL.dylib</code></li>
 * <li><code>panamagl.mesa.glu</code> : default <code>/opt/homebrew/opt/mesa-glu/lib/libGLU.dylib</code>,
 * optional</li>
 * </ul>
 *
 * The OpenGL functions of the bindings are looked up in the libraries loaded by the class loader
 * (<code>SymbolLookup.loaderLookup()</code>) : loading Mesa's <code>libGL.dylib</code> makes them
 * call Mesa rather than the OpenGL framework of Apple.
 */
public class MesaLibraries {
  public static final String EGL_PROPERTY = "panamagl.mesa.egl";
  public static final String GL_PROPERTY = "panamagl.mesa.gl";
  public static final String GLU_PROPERTY = "panamagl.mesa.glu";

  static final String HOMEBREW_MESA = "/opt/homebrew/opt/mesa/lib/";
  static final String HOMEBREW_GLU = "/opt/homebrew/opt/mesa-glu/lib/";

  private static volatile boolean loaded = false;

  /** @return true when running on macOS, where Mesa replaces the OpenGL framework of Apple. */
  public static boolean isMacOS() {
    String os = System.getProperty("os.name").toLowerCase(Locale.ROOT);
    return os.contains("mac") || os.contains("darwin");
  }

  /** @return the EGL library to open : a library name on Linux, an absolute path on macOS. */
  public static String egl() {
    return isMacOS() ? System.getProperty(EGL_PROPERTY, HOMEBREW_MESA + "libEGL.dylib")
        : System.getProperty(EGL_PROPERTY, "libEGL.so.1");
  }

  /** Load the OpenGL libraries used with EGL, once. */
  public static synchronized void load() {
    if (loaded)
      return;
    if (isMacOS()) {
      String gl = System.getProperty(GL_PROPERTY, HOMEBREW_MESA + "libGL.dylib");
      if (!new File(gl).exists())
        throw new IllegalStateException("Mesa OpenGL library not found : " + gl
            + " (install it with 'brew install mesa' or set -D" + GL_PROPERTY + ")");
      System.load(gl);

      // GLU is optional : only needed by the GLU functions of GL
      String glu = System.getProperty(GLU_PROPERTY, HOMEBREW_GLU + "libGLU.dylib");
      if (new File(glu).exists())
        System.load(glu);
    } else {
      NativeLibLoader.load();
    }
    loaded = true;
  }
}
