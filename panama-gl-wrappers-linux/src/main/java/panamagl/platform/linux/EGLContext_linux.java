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
import java.lang.foreign.FunctionDescriptor;
import java.lang.foreign.Linker;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.SymbolLookup;
import java.lang.invoke.MethodHandle;
import opengl.linux.NativeLibLoader;
import panamagl.Debug;
import panamagl.opengl.AGLContext;
import panamagl.opengl.GLContext;

/**
 * PROOF OF CONCEPT. A headless OpenGL context created with EGL, without any X11 window or display.
 *
 * <p>PanamaGL always renders into an {@link panamagl.offscreen.FBO} and reads the pixels back, so
 * the context never needs a window. EGL lets the GL implementation be chosen by the driver loader,
 * which makes it possible to run the unchanged {@link panamagl.opengl.GL} calls on OpenGL
 * implementations layered over another graphics API, e.g. Mesa Zink (OpenGL over Vulkan) :
 *
 * <pre>
 * -Dpanamagl.linux.context=egl
 * GALLIUM_DRIVER=zink                (OpenGL over Vulkan)
 * LIBGL_ALWAYS_SOFTWARE=1            (only to let Zink use a CPU Vulkan device such as lavapipe)
 * </pre>
 *
 * <p>The context is created on the {@code EGL_MESA_platform_surfaceless} platform when available,
 * on the default EGL display otherwise, with {@code EGL_KHR_no_config_context} and
 * {@code EGL_KHR_surfaceless_context}. It requests a compatibility profile since Jzy3D relies on
 * immediate mode.
 *
 * <p>The EGL entry points are invoked with hand written downcalls since only seven of them are
 * needed : this avoids generating EGL bindings with JExtract for a proof of concept.
 */
public class EGLContext_linux extends AGLContext implements GLContext {
  public static final String PROPERTY = "panamagl.linux.context";

  static final int EGL_NONE = 0x3038;
  static final int EGL_OPENGL_API = 0x30A2;
  static final int EGL_PLATFORM_SURFACELESS_MESA = 0x31DD;
  static final int EGL_CONTEXT_OPENGL_PROFILE_MASK = 0x30FD;
  static final int EGL_CONTEXT_OPENGL_COMPATIBILITY_PROFILE_BIT = 0x00000002;

  protected boolean debug = Debug.check(GLContext.class, EGLContext_linux.class);

  protected MemorySegment display = MemorySegment.NULL;
  protected MemorySegment context = MemorySegment.NULL;

  protected MethodHandle eglGetProcAddress;
  protected MethodHandle eglGetDisplay;
  protected MethodHandle eglInitialize;
  protected MethodHandle eglBindAPI;
  protected MethodHandle eglCreateContext;
  protected MethodHandle eglMakeCurrent;
  protected MethodHandle eglDestroyContext;
  protected MethodHandle eglTerminate;

  /** @return true if the system property asks PanamaGL to use EGL rather than GLX on Linux. */
  public static boolean isRequested() {
    return "egl".equalsIgnoreCase(System.getProperty(PROPERTY));
  }

  public EGLContext_linux() {
    super();
    initArena();
    // Let the GL bindings resolve libGL, which shares its dispatch with libEGL through GLVND
    NativeLibLoader.load();
    bindEGL();
  }

  protected void bindEGL() {
    Linker linker = Linker.nativeLinker();
    SymbolLookup egl = SymbolLookup.libraryLookup("libEGL.so.1", arena);

    eglGetProcAddress = downcall(linker, egl, "eglGetProcAddress", FunctionDescriptor.of(ADDRESS, ADDRESS));
    eglGetDisplay = downcall(linker, egl, "eglGetDisplay", FunctionDescriptor.of(ADDRESS, ADDRESS));
    eglInitialize = downcall(linker, egl, "eglInitialize", FunctionDescriptor.of(JAVA_INT, ADDRESS, ADDRESS, ADDRESS));
    eglBindAPI = downcall(linker, egl, "eglBindAPI", FunctionDescriptor.of(JAVA_INT, JAVA_INT));
    eglCreateContext = downcall(linker, egl, "eglCreateContext", FunctionDescriptor.of(ADDRESS, ADDRESS, ADDRESS, ADDRESS, ADDRESS));
    eglMakeCurrent = downcall(linker, egl, "eglMakeCurrent", FunctionDescriptor.of(JAVA_INT, ADDRESS, ADDRESS, ADDRESS, ADDRESS));
    eglDestroyContext = downcall(linker, egl, "eglDestroyContext", FunctionDescriptor.of(JAVA_INT, ADDRESS, ADDRESS));
    eglTerminate = downcall(linker, egl, "eglTerminate", FunctionDescriptor.of(JAVA_INT, ADDRESS));
  }

  static MethodHandle downcall(Linker linker, SymbolLookup lib, String name, FunctionDescriptor fd) {
    MemorySegment symbol = lib.find(name)
        .orElseThrow(() -> new IllegalStateException("EGL symbol not found : " + name));
    return linker.downcallHandle(symbol, fd);
  }

  @Override
  public void init() {
    try {
      display = surfacelessDisplay();
      if (display.address() == 0) {
        display = (MemorySegment) eglGetDisplay.invokeExact(MemorySegment.NULL);
      }
      if (display.address() == 0)
        throw new IllegalStateException("EGL : no display");

      int ok = (int) eglInitialize.invokeExact(display, MemorySegment.NULL, MemorySegment.NULL);
      if (ok == 0)
        throw new IllegalStateException("EGL : eglInitialize failed");

      ok = (int) eglBindAPI.invokeExact(EGL_OPENGL_API);
      if (ok == 0)
        throw new IllegalStateException("EGL : desktop OpenGL API not available");

      int[] attributes = {EGL_CONTEXT_OPENGL_PROFILE_MASK,
          EGL_CONTEXT_OPENGL_COMPATIBILITY_PROFILE_BIT, EGL_NONE};
      MemorySegment attribs = arena.allocateFrom(JAVA_INT, attributes);

      // EGL_NO_CONFIG_KHR, EGL_NO_CONTEXT
      context = (MemorySegment) eglCreateContext.invokeExact(display, MemorySegment.NULL,
          MemorySegment.NULL, attribs);
      if (context.address() == 0)
        throw new IllegalStateException("EGL : eglCreateContext failed");

      makeCurrent();

      Debug.debug(debug, "EGLContext : context " + context + " on display " + display);
      initialized = true;
    } catch (RuntimeException e) {
      throw e;
    } catch (Throwable t) {
      throw new IllegalStateException(t);
    }
  }

  protected MemorySegment surfacelessDisplay() throws Throwable {
    MemorySegment name = arena.allocateFrom("eglGetPlatformDisplayEXT");
    MemorySegment fn = (MemorySegment) eglGetProcAddress.invokeExact(name);
    if (fn.address() == 0)
      return MemorySegment.NULL;

    MethodHandle getPlatformDisplay = Linker.nativeLinker().downcallHandle(fn,
        FunctionDescriptor.of(ADDRESS, JAVA_INT, ADDRESS, ADDRESS));
    return (MemorySegment) getPlatformDisplay.invokeExact(EGL_PLATFORM_SURFACELESS_MESA,
        MemorySegment.NULL, MemorySegment.NULL);
  }

  /** Make the context current on the calling thread, without any draw or read surface. */
  public void makeCurrent() {
    try {
      int ok = (int) eglMakeCurrent.invokeExact(display, MemorySegment.NULL, MemorySegment.NULL,
          context);
      if (ok == 0)
        throw new IllegalStateException("EGL : eglMakeCurrent failed");
    } catch (RuntimeException e) {
      throw e;
    } catch (Throwable t) {
      throw new IllegalStateException(t);
    }
  }

  @Override
  public void destroy() {
    try {
      if (context.address() != 0) {
        int ignored = (int) eglMakeCurrent.invokeExact(display, MemorySegment.NULL,
            MemorySegment.NULL, MemorySegment.NULL);
        ignored = (int) eglDestroyContext.invokeExact(display, context);
      }
      if (display.address() != 0) {
        int ignored = (int) eglTerminate.invokeExact(display);
      }
    } catch (Throwable t) {
      throw new IllegalStateException(t);
    }
    context = MemorySegment.NULL;
    display = MemorySegment.NULL;
    initialized = false;
  }
}
