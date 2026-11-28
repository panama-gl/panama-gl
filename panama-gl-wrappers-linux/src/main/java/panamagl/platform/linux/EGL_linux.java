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

import static java.lang.foreign.ValueLayout.ADDRESS;
import static java.lang.foreign.ValueLayout.JAVA_INT;
import java.lang.foreign.Arena;
import java.lang.foreign.FunctionDescriptor;
import java.lang.foreign.Linker;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.SymbolLookup;
import java.lang.invoke.MethodHandle;

/**
 * The few EGL entry points used by PanamaGL on Linux, invoked through downcalls written by hand
 * rather than a JExtract binding of <code>EGL/egl.h</code>.
 *
 * <p><code>libEGL.so.1</code> is only opened at the first use of this class, so that the GLX path
 * of PanamaGL never loads it.
 *
 * <p>Constants are those of the Khronos <code>EGL/egl.h</code> and <code>EGL/eglext.h</code>.
 */
public final class EGL_linux {
  /** The EGL library : libEGL.so.1 on Linux, Mesa's libEGL.dylib on macOS (see MesaLibraries). */
  public static final String LIBRARY = MesaLibraries.egl();

  public static final int EGL_FALSE = 0;
  public static final int EGL_NONE = 0x3038;
  public static final int EGL_SUCCESS = 0x3000;
  public static final int EGL_VENDOR = 0x3053;
  public static final int EGL_VERSION = 0x3054;
  public static final int EGL_EXTENSIONS = 0x3055;
  public static final int EGL_CLIENT_APIS = 0x308D;
  public static final int EGL_OPENGL_API = 0x30A2;
  public static final int EGL_CONTEXT_MAJOR_VERSION = 0x3098;
  public static final int EGL_CONTEXT_MINOR_VERSION = 0x30FB;
  public static final int EGL_CONTEXT_OPENGL_PROFILE_MASK = 0x30FD;
  public static final int EGL_CONTEXT_OPENGL_CORE_PROFILE_BIT = 0x00000001;
  public static final int EGL_CONTEXT_OPENGL_COMPATIBILITY_PROFILE_BIT = 0x00000002;
  /** EGL_MESA_platform_surfaceless */
  public static final int EGL_PLATFORM_SURFACELESS_MESA = 0x31DD;

  private static volatile EGL_linux instance;

  /** @return the EGL entry points, opening <code>libEGL.so.1</code> at the first invocation. */
  public static EGL_linux get() {
    EGL_linux egl = instance;
    if (egl == null) {
      synchronized (EGL_linux.class) {
        egl = instance;
        if (egl == null) {
          egl = new EGL_linux();
          instance = egl;
        }
      }
    }
    return egl;
  }

  /** @return true if this class already opened libEGL, i.e. EGL is in use in this process. */
  public static boolean isLoaded() {
    return instance != null;
  }

  private final Arena arena = Arena.global();

  private final MethodHandle eglGetProcAddress;
  private final MethodHandle eglGetDisplay;
  private final MethodHandle eglInitialize;
  private final MethodHandle eglTerminate;
  private final MethodHandle eglBindAPI;
  private final MethodHandle eglQueryString;
  private final MethodHandle eglCreateContext;
  private final MethodHandle eglDestroyContext;
  private final MethodHandle eglMakeCurrent;
  private final MethodHandle eglGetCurrentContext;
  private final MethodHandle eglGetError;
  private final MethodHandle eglGetPlatformDisplay; // EGL 1.5 or EGL_EXT_platform_base, may be null

  private EGL_linux() {
    Linker linker = Linker.nativeLinker();
    SymbolLookup egl;
    try {
      egl = SymbolLookup.libraryLookup(LIBRARY, arena);
    } catch (IllegalArgumentException e) {
      throw new IllegalStateException("EGL library not found : " + LIBRARY + (MesaLibraries.isMacOS()
          ? " (install Mesa with '" + MesaLibraries.INSTALL + "' or set -D" + MesaLibraries.EGL_PROPERTY + ")"
          : " (install libegl1, e.g. 'apt install libegl1 libgl1-mesa-dri')"), e);
    }

    eglGetProcAddress = downcall(linker, egl, "eglGetProcAddress", FunctionDescriptor.of(ADDRESS, ADDRESS));
    eglGetDisplay = downcall(linker, egl, "eglGetDisplay", FunctionDescriptor.of(ADDRESS, ADDRESS));
    eglInitialize = downcall(linker, egl, "eglInitialize", FunctionDescriptor.of(JAVA_INT, ADDRESS, ADDRESS, ADDRESS));
    eglTerminate = downcall(linker, egl, "eglTerminate", FunctionDescriptor.of(JAVA_INT, ADDRESS));
    eglBindAPI = downcall(linker, egl, "eglBindAPI", FunctionDescriptor.of(JAVA_INT, JAVA_INT));
    eglQueryString = downcall(linker, egl, "eglQueryString", FunctionDescriptor.of(ADDRESS, ADDRESS, JAVA_INT));
    eglCreateContext = downcall(linker, egl, "eglCreateContext", FunctionDescriptor.of(ADDRESS, ADDRESS, ADDRESS, ADDRESS, ADDRESS));
    eglDestroyContext = downcall(linker, egl, "eglDestroyContext", FunctionDescriptor.of(JAVA_INT, ADDRESS, ADDRESS));
    eglMakeCurrent = downcall(linker, egl, "eglMakeCurrent", FunctionDescriptor.of(JAVA_INT, ADDRESS, ADDRESS, ADDRESS, ADDRESS));
    eglGetCurrentContext = downcall(linker, egl, "eglGetCurrentContext", FunctionDescriptor.of(ADDRESS));
    eglGetError = downcall(linker, egl, "eglGetError", FunctionDescriptor.of(JAVA_INT));

    MemorySegment platformDisplay = procAddress("eglGetPlatformDisplay");
    if (platformDisplay.address() == 0)
      platformDisplay = procAddress("eglGetPlatformDisplayEXT");
    eglGetPlatformDisplay = platformDisplay.address() == 0 ? null
        : linker.downcallHandle(platformDisplay, FunctionDescriptor.of(ADDRESS, JAVA_INT, ADDRESS, ADDRESS));
  }

  private static MethodHandle downcall(Linker linker, SymbolLookup lib, String name, FunctionDescriptor fd) {
    MemorySegment symbol = lib.find(name)
        .orElseThrow(() -> new IllegalStateException("EGL symbol not found in " + LIBRARY + " : " + name));
    return linker.downcallHandle(symbol, fd);
  }

  // ---------------------------------------------------------------------------------------------

  /**
   * @return the address of an EGL or OpenGL function, or {@link MemorySegment#NULL}. Mesa resolves
   *         every OpenGL function, core ones included (EGL_KHR_get_all_proc_addresses).
   */
  public MemorySegment procAddress(String function) {
    try (Arena a = Arena.ofConfined()) {
      MemorySegment address = (MemorySegment) eglGetProcAddress.invokeExact(a.allocateFrom(function));
      return address == null ? MemorySegment.NULL : address;
    } catch (Throwable t) {
      throw rethrow(t);
    }
  }

  /** @return the display of a platform, or NULL if the platform or eglGetPlatformDisplay is missing. */
  public MemorySegment platformDisplay(int platform) {
    if (eglGetPlatformDisplay == null)
      return MemorySegment.NULL;
    try {
      return (MemorySegment) eglGetPlatformDisplay.invokeExact(platform, MemorySegment.NULL,
          MemorySegment.NULL);
    } catch (Throwable t) {
      throw rethrow(t);
    }
  }

  public MemorySegment defaultDisplay() {
    try {
      return (MemorySegment) eglGetDisplay.invokeExact(MemorySegment.NULL);
    } catch (Throwable t) {
      throw rethrow(t);
    }
  }

  /** @return {major, minor} EGL version, or null if the initialization failed. */
  public int[] initialize(MemorySegment display) {
    try (Arena a = Arena.ofConfined()) {
      MemorySegment major = a.allocate(JAVA_INT);
      MemorySegment minor = a.allocate(JAVA_INT);
      int ok = (int) eglInitialize.invokeExact(display, major, minor);
      if (ok == EGL_FALSE)
        return null;
      return new int[] {major.get(JAVA_INT, 0), minor.get(JAVA_INT, 0)};
    } catch (Throwable t) {
      throw rethrow(t);
    }
  }

  public boolean terminate(MemorySegment display) {
    try {
      return (int) eglTerminate.invokeExact(display) != EGL_FALSE;
    } catch (Throwable t) {
      throw rethrow(t);
    }
  }

  public boolean bindAPI(int api) {
    try {
      return (int) eglBindAPI.invokeExact(api) != EGL_FALSE;
    } catch (Throwable t) {
      throw rethrow(t);
    }
  }

  /** @return the string, or null if the query failed. */
  public String queryString(MemorySegment display, int name) {
    try {
      MemorySegment s = (MemorySegment) eglQueryString.invokeExact(display, name);
      if (s == null || s.address() == 0)
        return null;
      return s.reinterpret(Integer.MAX_VALUE).getString(0);
    } catch (Throwable t) {
      throw rethrow(t);
    }
  }

  /** Create a context without config (EGL_KHR_no_config_context) nor shared context. */
  public MemorySegment createContext(MemorySegment display, int[] attributes) {
    try (Arena a = Arena.ofConfined()) {
      MemorySegment attribs = a.allocateFrom(JAVA_INT, attributes);
      return (MemorySegment) eglCreateContext.invokeExact(display, MemorySegment.NULL,
          MemorySegment.NULL, attribs);
    } catch (Throwable t) {
      throw rethrow(t);
    }
  }

  public boolean destroyContext(MemorySegment display, MemorySegment context) {
    try {
      return (int) eglDestroyContext.invokeExact(display, context) != EGL_FALSE;
    } catch (Throwable t) {
      throw rethrow(t);
    }
  }

  /** Make the context current without draw nor read surface (EGL_KHR_surfaceless_context). */
  public boolean makeCurrent(MemorySegment display, MemorySegment context) {
    try {
      return (int) eglMakeCurrent.invokeExact(display, MemorySegment.NULL, MemorySegment.NULL,
          context) != EGL_FALSE;
    } catch (Throwable t) {
      throw rethrow(t);
    }
  }

  /** @return the EGL context current on the calling thread, or NULL. */
  public MemorySegment currentContext() {
    try {
      MemorySegment c = (MemorySegment) eglGetCurrentContext.invokeExact();
      return c == null ? MemorySegment.NULL : c;
    } catch (Throwable t) {
      throw rethrow(t);
    }
  }

  public int error() {
    try {
      return (int) eglGetError.invokeExact();
    } catch (Throwable t) {
      throw rethrow(t);
    }
  }

  private static RuntimeException rethrow(Throwable t) {
    if (t instanceof RuntimeException r)
      return r;
    if (t instanceof Error e)
      throw e;
    return new IllegalStateException(t);
  }
}
