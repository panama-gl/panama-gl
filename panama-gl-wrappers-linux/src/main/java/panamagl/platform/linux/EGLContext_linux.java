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

import static panamagl.platform.linux.EGL_linux.*;
import java.lang.foreign.MemorySegment;
import panamagl.Debug;
import panamagl.opengl.AGLContext;
import panamagl.opengl.GLContext;

/**
 * A headless OpenGL context created with EGL, without any X11 window or display.
 *
 * <p>PanamaGL always renders into an {@link panamagl.offscreen.FBO} and reads the pixels back, so
 * the context never needs a window. EGL lets the driver loader choose the OpenGL implementation,
 * which makes it possible to run the unchanged {@link panamagl.opengl.GL} calls on OpenGL
 * implementations layered over another graphics API, such as Mesa Zink (OpenGL over Vulkan) :
 *
 * <pre>
 * -Dpanamagl.linux.context=egl       select this context (GLX remains the default),
 *                                    or the environment variable PANAMAGL_LINUX_CONTEXT=egl
 * GALLIUM_DRIVER=zink                OpenGL over Vulkan
 * LIBGL_ALWAYS_SOFTWARE=1            only to let Zink use a CPU Vulkan device such as lavapipe
 * </pre>
 *
 * <p>The context is created on the <code>EGL_MESA_platform_surfaceless</code> platform when
 * available, on the default EGL display otherwise, without config
 * (<code>EGL_KHR_no_config_context</code>) nor surface (<code>EGL_KHR_surfaceless_context</code>).
 * It requests a compatibility profile by default, since Jzy3D relies on immediate mode, or a core
 * profile of a given version with {@link #setCoreProfile(int, int)}.
 *
 * <p>It also runs on macOS with Mesa (e.g. from Homebrew), through {@link PanamaGLFactory_linux}
 * with {@link APanamaGLFactory_linux#setUseEGL(boolean)} : see {@link MesaLibraries}.
 *
 * <p>The OpenGL functions are then resolved with <code>eglGetProcAddress</code> by
 * {@link GLFunctionLoader_linux}. GLUT functions remain available if an X display is available
 * (see {@link GLUT_linux}).
 *
 * <p>How EGL plugs into the OpenGL bindings of PanamaGL : only the creation of the context and the
 * resolution of the functions change.
 *
 * <p><img src="doc-files/egl-gl-glext.svg" alt="EGL, GL and GLEXT in PanamaGL" style="max-width:100%"/>
 *
 * <p>The layers below EGL, from Mesa to the hardware, through Zink and Vulkan :
 *
 * <p><img src="doc-files/egl-zink-stack.svg" alt="EGL, Mesa, Zink and Vulkan" style="max-width:100%"/>
 *
 * <p>The backends available on each OS, and their native dependencies :
 *
 * <p><img src="doc-files/backends-per-platform.svg" alt="Backends on each OS" style="max-width:100%"/>
 *
 * <p><img src="doc-files/native-dependencies.svg" alt="Native dependencies" style="max-width:100%"/>
 */
public class EGLContext_linux extends AGLContext implements GLContext {
  /** System property selecting the kind of context created by the Linux factory : glx or egl. */
  public static final String PROPERTY = "panamagl.linux.context";

  /** Environment variable read when the system property {@link #PROPERTY} is not set. */
  public static final String ENVIRONMENT_VARIABLE = "PANAMAGL_LINUX_CONTEXT";

  /** The EGL platform the display was obtained from. */
  public enum Platform {
    SURFACELESS, DEFAULT
  }

  protected boolean debug = Debug.check(GLContext.class, EGLContext_linux.class);

  protected MemorySegment display = MemorySegment.NULL;
  protected MemorySegment context = MemorySegment.NULL;
  protected Platform platform;
  protected int[] eglVersion;

  protected boolean coreProfile = false;
  protected int coreMajor = 3;
  protected int coreMinor = 3;

  /** True once an EGL context has been created in this process. */
  protected static volatile boolean used = false;

  /**
   * @return true if the system property <code>panamagl.linux.context</code>, or if not set the
   *         environment variable <code>PANAMAGL_LINUX_CONTEXT</code>, asks PanamaGL to use EGL
   *         rather than GLX on Linux.
   */
  public static boolean isRequested() {
    String value = System.getProperty(PROPERTY);
    if (value == null)
      value = System.getenv(ENVIRONMENT_VARIABLE);
    return "egl".equalsIgnoreCase(value);
  }

  /** @return true once an EGL context has been created in this process. */
  public static boolean isUsed() {
    return used;
  }

  public EGLContext_linux() {
    super();
    initArena();
    // Load libGL, which shares its dispatch with libEGL through GLVND on Linux, or Mesa on macOS
    MesaLibraries.load();
  }

  /** Request a core profile of the given version instead of the default compatibility profile. */
  public void setCoreProfile(int major, int minor) {
    this.coreProfile = true;
    this.coreMajor = major;
    this.coreMinor = minor;
  }

  public boolean isCoreProfile() {
    return coreProfile;
  }

  @Override
  public void init() {
    EGL_linux egl = EGL_linux.get();

    display = egl.platformDisplay(EGL_PLATFORM_SURFACELESS_MESA);
    platform = Platform.SURFACELESS;
    eglVersion = display.address() == 0 ? null : egl.initialize(display);

    if (eglVersion == null) {
      display = egl.defaultDisplay();
      platform = Platform.DEFAULT;
      if (display.address() == 0)
        throw new IllegalStateException("EGL : no display");
      eglVersion = egl.initialize(display);
      if (eglVersion == null)
        throw new IllegalStateException("EGL : eglInitialize failed, error 0x"
            + Integer.toHexString(egl.error()));
    }

    if (!egl.bindAPI(EGL_OPENGL_API))
      throw new IllegalStateException("EGL : desktop OpenGL API not available");

    int[] attributes = coreProfile
        ? new int[] {EGL_CONTEXT_MAJOR_VERSION, coreMajor, EGL_CONTEXT_MINOR_VERSION, coreMinor,
            EGL_CONTEXT_OPENGL_PROFILE_MASK, EGL_CONTEXT_OPENGL_CORE_PROFILE_BIT, EGL_NONE}
        : new int[] {EGL_CONTEXT_OPENGL_PROFILE_MASK,
            EGL_CONTEXT_OPENGL_COMPATIBILITY_PROFILE_BIT, EGL_NONE};

    context = egl.createContext(display, attributes);
    if (context.address() == 0)
      throw new IllegalStateException("EGL : eglCreateContext failed, error 0x"
          + Integer.toHexString(egl.error()));

    makeCurrent();

    used = true;
    initialized = true;

    Debug.debug(debug, "EGLContext : EGL " + getEGLVersion() + " on " + platform + " platform, "
        + getEGLVendor());
  }

  /** Make the context current on the calling thread, without any draw or read surface. */
  public void makeCurrent() {
    if (!EGL_linux.get().makeCurrent(display, context))
      throw new IllegalStateException("EGL : eglMakeCurrent failed, error 0x"
          + Integer.toHexString(EGL_linux.get().error()));
  }

  /** Release the context from the calling thread. */
  public void release() {
    EGL_linux.get().makeCurrent(display, MemorySegment.NULL);
  }

  /** @return true if this context is current on the calling thread. */
  public boolean isCurrent() {
    return context.address() != 0
        && EGL_linux.get().currentContext().address() == context.address();
  }

  @Override
  public void destroy() {
    if (!EGL_linux.isLoaded())
      return;
    EGL_linux egl = EGL_linux.get();
    if (context.address() != 0) {
      if (isCurrent())
        release();
      egl.destroyContext(display, context);
    }
    // The display is not terminated : eglGetPlatformDisplay returns the same display to all the
    // contexts of the process, and eglTerminate would invalidate the contexts of other canvases.

    context = MemorySegment.NULL;
    display = MemorySegment.NULL;
    initialized = false;
  }

  /** @return the EGL platform of the display, null before {@link #init()}. */
  public Platform getPlatform() {
    return platform;
  }

  /** @return the EGL version, e.g. "1.5", null before {@link #init()}. */
  public String getEGLVersion() {
    return eglVersion == null ? null : eglVersion[0] + "." + eglVersion[1];
  }

  /** @return the EGL vendor, e.g. "Mesa Project", null before {@link #init()}. */
  public String getEGLVendor() {
    return display.address() == 0 ? null : EGL_linux.get().queryString(display, EGL_VENDOR);
  }

  /** @return the EGL client APIs, e.g. "OpenGL OpenGL_ES", null before {@link #init()}. */
  public String getEGLClientAPIs() {
    return display.address() == 0 ? null : EGL_linux.get().queryString(display, EGL_CLIENT_APIS);
  }
}
