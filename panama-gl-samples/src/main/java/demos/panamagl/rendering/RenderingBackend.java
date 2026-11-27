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
package demos.panamagl.rendering;

import java.util.Locale;
import java.util.Properties;
import panamagl.GLProfile;
import panamagl.opengl.GLContext;

/**
 * Describe the backend that actually renders the OpenGL calls of PanamaGL : the OS and CPU, the API
 * that created the context (GLX, EGL, WGL, CGL, GLUT), and the graphics API reached by the OpenGL
 * implementation, guessed from its renderer string :
 *
 * <ul>
 * <li><code>vulkan-zink-*</code> : Mesa Zink, OpenGL over Vulkan (lavapipe, MoltenVK, a GPU...)</li>
 * <li><code>d3d12-*</code> : Mesa d3d12, OpenGL over Direct3D 12 (WARP or a GPU)</li>
 * <li><code>cpu-llvmpipe</code>, <code>cpu-softpipe</code> : Mesa, OpenGL on the CPU</li>
 * <li><code>apple-opengl-metal</code> : Apple OpenGL on the GPU of Apple Silicon, which Apple
 * implements over Metal ; <code>apple-opengl-software</code> : the Apple Software Renderer (CPU),
 * e.g. on CI runners without GPU</li>
 * <li><code>gdi-generic</code> : the OpenGL 1.1 software renderer of Windows</li>
 * <li><code>opengl-native</code> : any other OpenGL driver (GPU vendor)</li>
 * </ul>
 *
 * The file name of a rendering gathers these informations, e.g.
 * <code>reference-scene__linux-x86_64__egl__vulkan-zink-lavapipe__zink-vulkan-1-4-llvmpipe.png</code>.
 */
public class RenderingBackend {
  protected String os;
  protected String arch;
  protected String context;
  protected String backend;
  protected String renderer;
  protected String version;
  protected String vendor;

  public RenderingBackend(GLContext context, GLProfile profile) {
    this(System.getProperty("os.name"), System.getProperty("os.arch"),
        context.getClass().getSimpleName(), profile.getRenderer(), profile.getVersion(),
        profile.getVendor());
  }

  public RenderingBackend(String osName, String osArch, String contextClass, String renderer,
      String version, String vendor) {
    this.os = os(osName);
    this.arch = arch(osArch);
    this.context = context(contextClass);
    this.renderer = renderer == null ? "" : renderer;
    this.version = version == null ? "" : version;
    this.vendor = vendor == null ? "" : vendor;
    this.backend = backend(this.os, this.arch, this.renderer, this.vendor);
  }

  /**
   * The backend expected from the environment, when the context could not be created : the OpenGL
   * driver of Mesa (GALLIUM_DRIVER) and the Vulkan driver of Zink (VK_DRIVER_FILES).
   */
  public static RenderingBackend expected(String contextClass, String error) {
    String gallium = System.getenv("GALLIUM_DRIVER");
    String icd = System.getenv("VK_DRIVER_FILES");
    String renderer = gallium == null ? "unknown" : gallium;
    if ("zink".equalsIgnoreCase(gallium)) {
      String vulkan = icd == null ? "" : new java.io.File(icd).getName().toLowerCase(Locale.ROOT);
      renderer = "zink Vulkan ("
          + (vulkan.contains("kosmickrisp") ? "kosmickrisp" : vulkan.contains("moltenvk") ? "MoltenVK"
              : vulkan.contains("lvp") ? "lavapipe" : vulkan.contains("dzn") ? "dzn" : vulkan)
          + ")";
    }
    RenderingBackend b = new RenderingBackend(System.getProperty("os.name"),
        System.getProperty("os.arch"), contextClass, renderer, "failed : " + error, "");
    return b;
  }

  static String os(String name) {
    String n = name.toLowerCase(Locale.ROOT);
    if (n.contains("win"))
      return "windows";
    if (n.contains("mac") || n.contains("darwin"))
      return "macos";
    if (n.contains("linux"))
      return "linux";
    return slug(n);
  }

  static String arch(String arch) {
    String a = arch.toLowerCase(Locale.ROOT);
    if (a.equals("amd64") || a.equals("x86_64"))
      return "x86_64";
    if (a.equals("aarch64") || a.equals("arm64"))
      return "arm64";
    return slug(a);
  }

  /** GLXContext_linux -> glx, EGLContext_linux -> egl, CGLContext_macOS -> cgl, ... */
  static String context(String contextClass) {
    String c = contextClass;
    int underscore = c.indexOf('_');
    if (underscore > 0)
      c = c.substring(0, underscore);
    if (c.endsWith("Context"))
      c = c.substring(0, c.length() - "Context".length());
    return c.toLowerCase(Locale.ROOT);
  }

  static String backend(String os, String arch, String renderer, String vendor) {
    String r = renderer.toLowerCase(Locale.ROOT);
    if (r.startsWith("zink")) {
      if (r.contains("llvmpipe") || r.contains("lavapipe"))
        return "vulkan-zink-lavapipe";
      if (r.contains("moltenvk"))
        return "vulkan-zink-moltenvk";
      if (r.contains("kosmickrisp"))
        return "vulkan-zink-kosmickrisp";
      if (r.contains("microsoft") || r.contains("dzn") || r.contains("dozen") || r.contains("d3d12"))
        return "vulkan-zink-dozen";
      return "vulkan-zink";
    }
    if (r.contains("d3d12"))
      return r.contains("basic render") || r.contains("warp") ? "d3d12-warp" : "d3d12";
    if (r.contains("llvmpipe"))
      return "cpu-llvmpipe";
    if (r.contains("softpipe"))
      return "cpu-softpipe";
    if (r.contains("gdi generic"))
      return "gdi-generic";
    if ("macos".equals(os) && vendor.toLowerCase(Locale.ROOT).contains("apple")) {
      if (r.contains("software"))
        return "apple-opengl-software";
      return "arm64".equals(arch) ? "apple-opengl-metal" : "apple-opengl";
    }
    return "opengl-native";
  }

  /** Lower case, letters and digits, other characters as single dashes, at most 48 characters. */
  public static String slug(String text) {
    String s = text.toLowerCase(Locale.ROOT).replaceAll("[^a-z0-9]+", "-").replaceAll("(^-|-$)", "");
    return s.length() > 48 ? s.substring(0, 48).replaceAll("-$", "") : s;
  }

  /**
   * The renderer without the details that make names long and unstable : LLVM version, vector
   * width, Mesa driver identifier, e.g. "zink Vulkan 1.4(llvmpipe (LLVM 20.1.2, 256 bits)
   * (MESA_LLVMPIPE))" gives "zink-vulkan-1-4-llvmpipe".
   */
  public String getRendererSlug() {
    String r = renderer.replaceAll("\\((LLVM|MESA_)[^)]*\\)", " ");
    String s = slug(r);
    if (s.length() > 40) {
      s = s.substring(0, 40);
      int dash = s.lastIndexOf('-');
      if (dash > 20)
        s = s.substring(0, dash);
    }
    return s;
  }

  /** @return e.g. reference-scene__linux-x86_64__egl__vulkan-zink-lavapipe__zink-vulkan-1-4-llvmpipe */
  public String getName(String scene) {
    return slug(scene) + "__" + os + "-" + arch + "__" + context + "__" + backend + "__"
        + getRendererSlug();
  }

  public Properties toProperties() {
    Properties p = new Properties();
    p.setProperty("os", os);
    p.setProperty("arch", arch);
    p.setProperty("context", context);
    p.setProperty("backend", backend);
    p.setProperty("renderer", renderer);
    p.setProperty("version", version);
    p.setProperty("vendor", vendor);
    p.setProperty("java.version", System.getProperty("java.version"));
    return p;
  }

  public String getOs() {
    return os;
  }

  public String getArch() {
    return arch;
  }

  public String getContext() {
    return context;
  }

  public String getBackend() {
    return backend;
  }

  public String getRenderer() {
    return renderer;
  }

  public String getVersion() {
    return version;
  }

  @Override
  public String toString() {
    return os + "-" + arch + " / " + context + " / " + backend + " / " + renderer + " / " + version;
  }
}
