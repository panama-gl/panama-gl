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

import java.io.IOException;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HexFormat;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import opengl.windows.NativeLibLoader;
import panamagl.platform.natives.NativeBundle;
import panamagl.platform.natives.NativeBundleException;
import panamagl.platform.natives.OpenGLImplementation;

/**
 * Load the DLL required by the Windows bindings.
 *
 * <h2>OpenGL</h2>
 *
 * By default, {@link #load()} loads the <code>opengl32.dll</code> of Windows, which dispatches to
 * the OpenGL driver of the GPU, and <code>glu32.dll</code>.
 *
 * <p>With the optional <code>panama-gl-bindings-windows-mesa</code> jar, an application can render
 * with <a href="https://mesa3d.org">Mesa</a> instead, e.g. on computers without GPU driver, where
 * Windows only provides OpenGL 1.1. Mesa is never used unless selected, before the first OpenGL
 * call, by the system property {@value #OPENGL_PROPERTY} or the environment variable
 * {@value #OPENGL_ENVIRONMENT}, with one of the values of {@link OpenGL} :
 *
 * <pre>
 * -Dpanamagl.windows.opengl=mesa-llvmpipe        OpenGL over the CPU
 * -Dpanamagl.windows.opengl=mesa-d3d12           OpenGL over Direct3D 12 (GPU, or WARP)
 * -Dpanamagl.windows.opengl=mesa-zink            OpenGL over the Vulkan driver of the GPU
 * -Dpanamagl.windows.opengl=mesa-zink-lavapipe   OpenGL over Vulkan over the CPU
 * </pre>
 *
 * The <code>opengl32.dll</code> of Mesa then replaces the one of Windows for the whole process : the
 * WGL and GLUT contexts, and <code>glu32.dll</code> and <code>freeglut.dll</code> which import
 * <code>opengl32.dll</code> by name, all use Mesa. A process cannot use both : selecting Mesa after
 * the <code>opengl32.dll</code> of Windows was loaded fails (see {@link OpenGLImplementation}).
 *
 * <p>The DLLs are native bundles of the jar (<code>natives/windows-&lt;cpu&gt;/mesa-&lt;driver&gt;/</code>),
 * extracted and verified by {@link NativeBundle}.
 *
 * <h2>freeglut</h2>
 *
 * freeglut is not part of Windows and optional : it is only loaded by {@link #loadGLUT()}, which
 * {@link GLUT_windows} invokes at the first use of GLUT. It is loaded from the
 * <code>java.library.path</code> if available, otherwise from the freeglut.dll of the optional
 * <code>panama-gl-bindings-windows-freeglut</code> jar for the CPU of the JVM (x86_64 or aarch64),
 * extracted by {@link NativeBundle}.
 */
public class NativeLibLoader_windows {
  public static final String GLUT = "freeglut";

  /** Folder of the embedded native libraries in the classpath, followed by the CPU name. */
  public static final String NATIVES = "natives/windows-";

  /** The optional jar embedding freeglut.dll. */
  public static final String GLUT_ARTIFACT = "org.jzy3d:panama-gl-bindings-windows-freeglut";

  /** The optional jar embedding Mesa. */
  public static final String MESA_ARTIFACT = "org.jzy3d:panama-gl-bindings-windows-mesa";

  /** System property selecting the OpenGL implementation, see {@link OpenGL}. */
  public static final String OPENGL_PROPERTY = "panamagl.windows.opengl";

  /** Environment variable read when {@link #OPENGL_PROPERTY} is not set. */
  public static final String OPENGL_ENVIRONMENT = "PANAMAGL_WINDOWS_OPENGL";

  /** Origin of a library loaded from the <code>java.library.path</code>. */
  public static final String LIBRARY_PATH = "java.library.path";

  /** The OpenGL implementations that can be selected. */
  public enum OpenGL {
    /** The opengl32.dll of Windows, and the OpenGL driver of the GPU : the default. */
    SYSTEM("system", null, null),
    /** Mesa llvmpipe : OpenGL over the CPU. */
    MESA_LLVMPIPE("mesa-llvmpipe", "mesa-llvmpipe", null),
    /** Mesa d3d12 : OpenGL over Direct3D 12, on the GPU or WARP. */
    MESA_D3D12("mesa-d3d12", "mesa-d3d12", null),
    /** Mesa Zink : OpenGL over the Vulkan driver of the GPU. */
    MESA_ZINK("mesa-zink", "mesa-zink", null),
    /** Mesa Zink over Mesa lavapipe : OpenGL over Vulkan over the CPU. */
    MESA_ZINK_LAVAPIPE("mesa-zink-lavapipe", "mesa-zink", "mesa-lavapipe");

    final String value;
    final String bundle;
    final String vulkanBundle;

    OpenGL(String value, String bundle, String vulkanBundle) {
      this.value = value;
      this.bundle = bundle;
      this.vulkanBundle = vulkanBundle;
    }

    /** @return the value of {@link NativeLibLoader_windows#OPENGL_PROPERTY} selecting it. */
    public String value() {
      return value;
    }

    /** @return the native bundle of the OpenGL driver, null for the system one. */
    public String bundle() {
      return bundle;
    }

    /** @return the native bundle of the Vulkan driver used by Zink, or null. */
    public String vulkanBundle() {
      return vulkanBundle;
    }

    public boolean isMesa() {
      return bundle != null;
    }

    /**
     * @return the implementation of the given value, SYSTEM for null or blank.
     * @throws IllegalArgumentException for an unknown value, listing the valid ones.
     */
    public static OpenGL parse(String value) {
      if (value == null || value.isBlank())
        return SYSTEM;
      String v = value.trim().toLowerCase(Locale.ROOT);
      for (OpenGL gl : values())
        if (gl.value.equals(v))
          return gl;
      throw new IllegalArgumentException("Unknown OpenGL implementation '" + value + "' for "
          + OPENGL_PROPERTY + " : use one of " + Arrays.stream(values()).map(OpenGL::value).toList());
    }
  }

  protected static boolean glLoaded = false;
  protected static String glOrigin = null;
  protected static OpenGL glImplementation = null;

  protected static boolean glutLoaded = false;
  protected static String glutOrigin = null;

  /** @return the OpenGL implementation selected by the system property or environment variable. */
  public static OpenGL selectedOpenGL() {
    String value = System.getProperty(OPENGL_PROPERTY);
    if (value == null)
      value = System.getenv(OPENGL_ENVIRONMENT);
    return OpenGL.parse(value);
  }

  /**
   * Load OpenGL related DLL, once : opengl32 (of Windows, or of Mesa if selected) and glu32.
   * freeglut is loaded by {@link #loadGLUT()}.
   */
  public static synchronized void load() {
    if (glLoaded)
      return;
    OpenGL gl = selectedOpenGL();
    if (gl.isMesa()) {
      loadMesa(gl);
    } else {
      OpenGLImplementation.claim("Windows opengl32", "opengl32.dll of Windows");
      NativeLibLoader.loadGL();
      glOrigin = Kernel32_windows.loadedModule("opengl32.dll").orElse(LIBRARY_PATH);
    }
    NativeLibLoader.loadGLU();
    glImplementation = gl;
    glLoaded = true;
  }

  /**
   * Load the opengl32.dll of Mesa from <code>panama-gl-bindings-windows-mesa</code>, and for Zink
   * over lavapipe, declare the Vulkan driver of the bundle to the Vulkan loader.
   */
  protected static void loadMesa(OpenGL gl) {
    NativeBundle bundle = find(gl.bundle());
    Optional<String> loaded = Kernel32_windows.loadedModule("opengl32.dll");
    Path folder = bundle.extract();
    if (loaded.isPresent() && !isIn(loaded.get(), folder))
      throw new IllegalStateException("Cannot use Mesa (" + OPENGL_PROPERTY + "=" + gl.value()
          + ") : the opengl32.dll of Windows is already loaded in this process (" + loaded.get()
          + "). Select Mesa before any use of OpenGL, e.g. on the command line.");
    OpenGLImplementation.claim("Mesa " + bundle.getName() + " " + bundle.getVersion(),
        folder.toString());

    // The Gallium driver of the bundle : without it, the WGL of Mesa picks its default driver,
    // which is not Zink
    Kernel32_windows.setenv("GALLIUM_DRIVER", gl.bundle().substring("mesa-".length()));

    if (gl.bundle().equals(OpenGL.MESA_ZINK.bundle()))
      loadVulkanLoader();

    if (gl.vulkanBundle() != null) {
      NativeBundle vulkan = find(gl.vulkanBundle());
      Path icd = vulkan.extract().resolve(vulkan.getProperty("vulkan.icd"));
      // VK_ICD_FILENAMES : name read by Vulkan loaders older than 1.3.207. The Vulkan loader
      // ignores both in elevated processes, which need the driver declared in the registry.
      Kernel32_windows.setenv("VK_DRIVER_FILES", icd.toString());
      Kernel32_windows.setenv("VK_ICD_FILENAMES", icd.toString());
      // Let Zink use a CPU Vulkan device
      Kernel32_windows.setenv("LIBGL_ALWAYS_SOFTWARE", "1");
    }

    // Bound to the class loader of this class, where the bindings look the functions up
    List<Path> libraries = bundle.load(library -> System.load(library.toString()));
    glOrigin = libraries.get(libraries.size() - 1).toString();
  }

  /** The Vulkan loader of Khronos, which Zink opens by name. */
  public static final String VULKAN_LOADER = "vulkan-1";

  /**
   * Load the Vulkan loader before Zink, which opens <code>vulkan-1.dll</code> by name, with the
   * search order of Windows : the folder of Windows where GPU drivers and the Vulkan Runtime
   * install it, or the PATH.
   */
  protected static void loadVulkanLoader() {
    if (Kernel32_windows.loadedModule(VULKAN_LOADER + ".dll").isPresent())
      return;
    try {
      // LoadLibrary by name, with the search order of Windows (system folder, PATH...)
      java.lang.foreign.SymbolLookup.libraryLookup(VULKAN_LOADER + ".dll", java.lang.foreign.Arena.global());
    } catch (IllegalArgumentException e) {
      throw new IllegalStateException("Mesa Zink needs the Vulkan loader " + VULKAN_LOADER + ".dll, "
          + "not found : it is installed by GPU drivers, or by the Vulkan Runtime of LunarG, or can "
          + "be put in a folder of the PATH", e);
    }
  }

  /** @return true if the file is in the folder, comparing real paths (long names, any case). */
  static boolean isIn(String file, Path folder) {
    try {
      return Path.of(file).toRealPath().startsWith(folder.toRealPath());
    } catch (java.io.IOException | RuntimeException e) {
      return file.toLowerCase(Locale.ROOT).startsWith(folder.toString().toLowerCase(Locale.ROOT));
    }
  }

  static NativeBundle find(String name) {
    try {
      return NativeBundle.find(name, NativeBundle.platform(), NativeLibLoader_windows.class.getClassLoader());
    } catch (NativeBundleException e) {
      if (e.getReason() == NativeBundleException.Reason.NOT_FOUND)
        throw new NativeBundleException(e.getReason(), e.getMessage() + " : add " + MESA_ARTIFACT
            + " to the classpath, or remove -D" + OPENGL_PROPERTY + " to use the OpenGL of Windows", e);
      throw e;
    }
  }

  /** @return the OpenGL implementation loaded by {@link #load()}, null before. */
  public static synchronized OpenGL getOpenGL() {
    return glImplementation;
  }

  /** @return the path of the loaded opengl32.dll, null before {@link #load()}. */
  public static synchronized String getOpenGLOrigin() {
    return glOrigin;
  }

  /** Load required windows DLL : user32, gdi32, kernel32 */
  public static void loadWindowsDLLs() {
    NativeLibLoader.loadWindowsDLLs();
  }

  /**
   * Load freeglut from the <code>java.library.path</code>, or from the freeglut.dll embedded in
   * the optional <code>panama-gl-bindings-windows-freeglut</code> jar if not found there.
   */
  public static synchronized void loadGLUT() {
    if (glutLoaded)
      return;

    try {
      System.loadLibrary(GLUT);
      glutOrigin = LIBRARY_PATH;
    } catch (UnsatisfiedLinkError notInLibraryPath) {
      String resource = resource(GLUT, System.getProperty("os.arch"));
      try {
        NativeBundle bundle = NativeBundle.ofResources(GLUT, NativeBundle.platform(),
            NativeLibLoader_windows.class.getClassLoader(), List.of(resource), List.of(GLUT + ".dll"));
        List<Path> loaded = bundle.load(library -> System.load(library.toString()));
        glutOrigin = loaded.get(0).toString();
      } catch (NativeBundleException | UnsatisfiedLinkError e) {
        UnsatisfiedLinkError error = new UnsatisfiedLinkError("Could not load " + GLUT
            + ", required by GLUT functions and the GLUT context : it is not in the java.library.path"
            + " and " + resource + " could not be loaded from the classpath. Install freeglut or add "
            + GLUT_ARTIFACT + " to the classpath. Cause : " + e.getMessage());
        error.addSuppressed(notInLibraryPath);
        error.initCause(e);
        throw error;
      }
    }
    glutLoaded = true;
  }

  /** True once freeglut has been loaded by {@link #loadGLUT()}. */
  public static synchronized boolean isGLUTLoaded() {
    return glutLoaded;
  }

  /**
   * Where freeglut was loaded from : {@link #LIBRARY_PATH}, or the path of the freeglut.dll
   * extracted from the classpath. Null if freeglut is not loaded.
   */
  public static synchronized String getGLUTOrigin() {
    return glutOrigin;
  }

  /**
   * Path of an embedded DLL in the classpath for the given CPU, as given by the
   * <code>os.arch</code> system property.
   */
  public static String resource(String library, String cpu) {
    return NATIVES + normalizeCPU(cpu) + "/" + library + ".dll";
  }

  /** Java reports amd64 on Intel/AMD CPUs and aarch64 on ARM64 CPUs. */
  protected static String normalizeCPU(String cpu) {
    return NativeBundle.cpu(cpu);
  }

  /**
   * Extract a resource of the classpath in a sub-folder of the given directory named after the
   * resource and the hash of its content, and return the path of the extracted file, reusing a
   * file already extracted by a previous run or by another running JVM. See {@link NativeBundle}.
   */
  public static Path extract(String resource, Path directory) throws IOException {
    String file = resource.substring(resource.lastIndexOf('/') + 1);
    try {
      NativeBundle bundle = NativeBundle.ofResources(file, NativeBundle.platform(),
          NativeLibLoader_windows.class.getClassLoader(), List.of(resource), List.of());
      return bundle.extract(List.of(directory)).resolve(file);
    } catch (NativeBundleException e) {
      throw new IOException(e.getMessage(), e);
    }
  }

  protected static Path tempDirectory() {
    return NativeBundle.candidateDirectories().get(0);
  }

  protected static String sha256(byte[] content) {
    try {
      return HexFormat.of().formatHex(MessageDigest.getInstance("SHA-256").digest(content));
    } catch (NoSuchAlgorithmException e) {
      throw new IllegalStateException(e);
    }
  }
}
