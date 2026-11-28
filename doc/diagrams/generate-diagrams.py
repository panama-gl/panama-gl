#!/usr/bin/env python3
"""
Generate the SVG diagrams of the OpenGL backends of PanamaGL into the doc-files folders of the
packages that document them, so that the javadoc of their classes can show them with
<img src="doc-files/....svg"/>. They are also linked from doc/OpenGL-Ecosystem.md.

Usage : python3 doc/diagrams/generate-diagrams.py   (from the root of the repository)

Edit STATUS below when the CI results of a backend change.
"""
from pathlib import Path
from xml.sax.saxutils import escape

ROOT = Path(__file__).resolve().parents[2]
LINUX_DOC = ROOT / "panama-gl-wrappers-linux/src/main/java/panamagl/platform/linux/doc-files"
FACTORY_DOC = ROOT / "panama-gl-api/src/main/java/panamagl/factory/doc-files"

FONT = "DejaVu Sans, Helvetica, Arial, sans-serif"
MONO = "DejaVu Sans Mono, Menlo, Consolas, monospace"

# Colors by kind of layer
JAVA = "#dbe9ff"        # PanamaGL Java code
BINDING = "#eeeeee"     # native entry points, loaders
MESA = "#dff3df"        # Mesa OpenGL implementations
VULKAN = "#fde2e1"      # Vulkan loader and drivers
METAL = "#efe2fb"       # Metal (Apple)
D3D = "#fff0d6"         # Direct3D (Microsoft)
HW = "#d9d9d9"          # GPU, CPU
VENDOR = "#e3f1f8"      # GPU vendor or OS OpenGL implementations
STROKE = "#555555"

# CI status of each rendering path, shown as badges
OK, KO, EXP, NA = "ok", "ko", "exp", "na"
BADGE = {OK: ("#2e7d32", "CI ✓"), KO: ("#c62828", "fails"), EXP: ("#ef6c00", "experimental"),
         NA: ("#757575", "not in CI")}
STATUS = {
    "linux-glx-llvmpipe": OK, "linux-glx-gpu": NA, "linux-egl-llvmpipe": OK,
    "linux-egl-zink-lavapipe": OK, "linux-egl-zink-gpu": NA,
    "windows-wgl-gpu": NA, "windows-wgl-d3d12": OK, "windows-wgl-llvmpipe": OK,
    "windows-wgl-zink-lavapipe": OK, "windows-wgl-zink-dzn": KO,
    "macos-cgl-apple": OK, "macos-egl-llvmpipe": OK,
    "macos-egl-zink-kosmickrisp": KO, "macos-egl-zink-moltenvk": KO,
}


class Svg:
    def __init__(self, width, height, title):
        self.w, self.h, self.items = width, height, []
        self.items.append(f'<rect width="{width}" height="{height}" fill="white"/>')
        self.text(20, 34, title, size=20, weight="bold")

    def text(self, x, y, s, size=13, weight="normal", anchor="start", color="#222", font=FONT,
             italic=False):
        style = ' font-style="italic"' if italic else ""
        self.items.append(f'<text x="{x}" y="{y}" font-family="{font}" font-size="{size}" '
                          f'font-weight="{weight}" text-anchor="{anchor}" fill="{color}"{style}>'
                          f'{escape(s)}</text>')

    def box(self, x, y, w, h, lines, fill, size=13, bold_first=True, mono_rest=False, dash=False):
        d = ' stroke-dasharray="5,3"' if dash else ""
        self.items.append(f'<rect x="{x}" y="{y}" width="{w}" height="{h}" rx="7" fill="{fill}" '
                          f'stroke="{STROKE}" stroke-width="1.2"{d}/>')
        n = len(lines)
        line_h = size + 4
        top = y + h / 2 - (n * line_h) / 2 + size
        for i, s in enumerate(lines):
            self.text(x + w / 2, top + i * line_h, s, size=size if i == 0 else size - 1,
                      weight="bold" if (i == 0 and bold_first) else "normal", anchor="middle",
                      font=MONO if (mono_rest and i > 0) else FONT)

    def arrow(self, x1, y1, x2, y2, label=None, dash=False, color=STROKE, lx=None, ly=None):
        d = ' stroke-dasharray="5,3"' if dash else ""
        self.items.append(f'<line x1="{x1}" y1="{y1}" x2="{x2}" y2="{y2}" stroke="{color}" '
                          f'stroke-width="1.6" marker-end="url(#arrow)"{d}/>')
        if label:
            self.text(lx if lx is not None else (x1 + x2) / 2 + 6,
                      ly if ly is not None else (y1 + y2) / 2 + 4, label, size=11, color="#444",
                      font=MONO)

    def polyline(self, points, dash=False):
        d = ' stroke-dasharray="5,3"' if dash else ""
        pts = " ".join(f"{x},{y}" for x, y in points)
        self.items.append(f'<polyline points="{pts}" fill="none" stroke="{STROKE}" '
                          f'stroke-width="1.6" marker-end="url(#arrow)"{d}/>')

    def badge(self, x, y, status):
        color, label = BADGE[status]
        w = 9 + 7 * len(label)
        self.items.append(f'<rect x="{x}" y="{y}" width="{w}" height="18" rx="9" fill="{color}"/>')
        self.text(x + w / 2, y + 13, label, size=11, weight="bold", anchor="middle", color="white")
        return w

    def legend(self, x, y, entries):
        for i, (fill, label) in enumerate(entries):
            self.items.append(f'<rect x="{x}" y="{y + i * 20}" width="16" height="14" rx="3" '
                              f'fill="{fill}" stroke="{STROKE}"/>')
            self.text(x + 24, y + 12 + i * 20, label, size=12)

    def save(self, *paths):
        defs = ('<defs><marker id="arrow" viewBox="0 0 10 10" refX="9" refY="5" markerWidth="7" '
                'markerHeight="7" orient="auto-start-reverse"><path d="M0,0 L10,5 L0,10 z" '
                f'fill="{STROKE}"/></marker></defs>')
        svg = (f'<svg xmlns="http://www.w3.org/2000/svg" width="{self.w}" height="{self.h}" '
               f'viewBox="0 0 {self.w} {self.h}">{defs}' + "".join(self.items) + "</svg>\n")
        for p in paths:
            p.parent.mkdir(parents=True, exist_ok=True)
            p.write_text(svg, encoding="utf-8")
            print("wrote", p.relative_to(ROOT))


LAYERS = [(JAVA, "PanamaGL (Java)"), (BINDING, "native entry points, loaders"),
          (MESA, "Mesa OpenGL"), (VENDOR, "OS or GPU vendor OpenGL"), (VULKAN, "Vulkan"),
          (METAL, "Metal (Apple)"), (D3D, "Direct3D 12 (Microsoft)"), (HW, "GPU / CPU")]


def egl_gl_glext():
    """How EGL plugs into the GL and GLEXT bindings of PanamaGL."""
    s = Svg(1060, 640, "EGL in PanamaGL : EGL only replaces GLX, the GL and GLEXT calls do not change")
    # Java column
    s.box(30, 70, 300, 70, ["EGLContext_linux", "creates the context, makes it current"], JAVA)
    s.box(380, 70, 300, 70, ["GL_linux", "the GL interface of PanamaGL"], JAVA)
    s.box(750, 70, 280, 70, ["FBO_linux", "render target, glReadPixels"], JAVA)
    # EGL calls
    s.box(30, 200, 300, 160, ["EGL_linux (libEGL)", "eglGetPlatformDisplay(SURFACELESS)",
                              "eglInitialize", "eglBindAPI(EGL_OPENGL_API)",
                              "eglCreateContext(compatibility)", "eglMakeCurrent(no surface)",
                              "eglGetProcAddress"], BINDING, size=13, mono_rest=True)
    s.arrow(180, 140, 180, 200)
    # GL direct calls
    s.box(380, 200, 220, 70, ["opengl.linux.gl_h", "GL 1.0 to 1.3", "called directly"], BINDING)
    s.arrow(490, 140, 490, 200)
    s.text(484, 175, "glClear, glBegin...", size=11, font=MONO, color="#444", anchor="end")
    # GLEXT calls
    s.box(380, 290, 300, 70, ["opengl.glext.PFNGL...PROC", "GL 1.4 and later : by pointer"],
          BINDING)
    s.arrow(650, 140, 650, 290)
    s.text(656, 175, "glGenFramebuffers...", size=11, font=MONO, color="#444")
    s.box(750, 200, 280, 160, ["GLFunctionLoader_linux", "eglGetProcAddress of EGL_linux",
                               "once an EGL context exists,", "glXGetProcAddress otherwise.",
                               "Resolved at the first call,", "then cached."], BINDING)
    s.arrow(750, 325, 682, 325)
    s.text(716, 316, "pointer", size=11, font=MONO, color="#444", anchor="middle")
    s.arrow(890, 140, 890, 200)
    # Implementation
    s.box(30, 420, 1000, 70, ["OpenGL implementation chosen by EGL",
                              "Mesa : llvmpipe (CPU), Zink (OpenGL over Vulkan), radeonsi, iris, nouveau...   "
                              "or the GPU vendor (NVIDIA via EGL_EXT_platform_device)"], MESA)
    for x in (180, 530, 890):
        s.arrow(x, 362, x, 420)
    s.text(30, 525, "• EGL is the Khronos binding API : it replaces GLX (Linux), WGL (Windows), CGL (macOS) "
           "to create the context and resolve functions.", size=13)
    s.text(30, 547, "• The headers do not change : gl.h of the OS for the functions exported by libGL, "
           "glext.h of Khronos for the others (types PFNGL...PROC).", size=13)
    s.text(30, 569, "• Surfaceless : no window nor display. PanamaGL always renders in a FBO, then reads "
           "the pixels back to show them in AWT, Swing, JavaFX or SWT.", size=13)
    s.text(30, 591, "• Selected with PANAMAGL_LINUX_CONTEXT=egl, -Dpanamagl.linux.context=egl or "
           "APanamaGLFactory_linux.setUseEGL(true). GLX remains the default.", size=13)
    s.text(30, 613, "• On macOS, the same classes run with Mesa's libEGL and libGL (Homebrew) : see "
           "MesaLibraries.", size=13)
    s.save(LINUX_DOC / "egl-gl-glext.svg")


def egl_zink_stack():
    """The layers from PanamaGL to the hardware through EGL, Mesa, Zink and Vulkan."""
    s = Svg(1110, 760, "From PanamaGL to the hardware with EGL, Mesa and Zink")
    s.box(300, 60, 500, 56, ["PanamaGL : GL_linux, EGLContext_linux, FBO_linux",
                             "the same OpenGL calls whatever the backend"], JAVA)
    s.box(300, 150, 500, 56, ["libEGL + libGL", "Linux : GLVND dispatch (libEGL.so.1, libGL.so.1)   "
                              "macOS : Mesa (Homebrew)"], BINDING)
    s.arrow(550, 116, 550, 150)
    s.box(300, 240, 500, 56, ["Mesa : OpenGL 4.6 compatibility profile",
                              "fixed function, display lists, selection... emulated by Mesa"], MESA)
    s.arrow(550, 206, 550, 240)
    # Gallium drivers
    s.box(40, 340, 240, 70, ["llvmpipe", "OpenGL on the CPU"], MESA)
    s.box(330, 340, 240, 70, ["radeonsi, iris, nouveau", "OpenGL on a GPU (Linux)"], MESA)
    s.box(620, 340, 240, 70, ["Zink", "OpenGL over Vulkan"], MESA)
    s.box(900, 340, 170, 70, ["d3d12", "OpenGL over D3D12", "(Windows)"], MESA)
    for x in (160, 450, 740, 985):
        s.arrow(550, 296, x, 340)
    s.text(40, 330, "GALLIUM_DRIVER=llvmpipe | zink | d3d12 ...", size=12, font=MONO, color="#444")
    # Vulkan
    s.box(560, 450, 360, 56, ["Vulkan loader", "libvulkan.so.1 / vulkan-1.dll / libvulkan.1.dylib"],
          VULKAN)
    s.arrow(740, 410, 740, 450)
    s.text(930, 470, "VK_DRIVER_FILES", size=12, font=MONO, color="#444")
    s.text(930, 486, "=...icd.json", size=12, font=MONO, color="#444")
    s.box(380, 550, 170, 70, ["lavapipe", "Vulkan on CPU"], VULKAN)
    s.box(565, 550, 170, 70, ["radv, anv, nvk,", "NVIDIA, AMD...", "Vulkan on GPU"], VULKAN)
    s.box(750, 550, 170, 70, ["KosmicKrisp,", "MoltenVK", "Vulkan over Metal"], VULKAN)
    s.box(935, 550, 150, 70, ["dzn", "Vulkan over", "Direct3D 12"], VULKAN)
    for x in (465, 650, 835, 1010):
        s.arrow(740, 506, x, 550)
    s.box(750, 660, 170, 46, ["Metal", "macOS"], METAL)
    s.box(935, 660, 150, 46, ["Direct3D 12", "WARP or GPU"], D3D)
    s.arrow(835, 620, 835, 660)
    s.arrow(1010, 620, 1010, 660)
    s.polyline([(1070, 375), (1094, 375), (1094, 640), (1060, 640), (1060, 660)], dash=True)
    s.box(40, 660, 680, 46, ["CPU or GPU"], HW)
    s.arrow(160, 410, 160, 660)
    s.arrow(450, 410, 450, 660)
    s.arrow(465, 620, 465, 660)
    s.arrow(650, 620, 650, 660)
    s.legend(40, 450, LAYERS[:3] + LAYERS[4:7])
    s.text(40, 740, "LIBGL_ALWAYS_SOFTWARE=1 lets Zink use a CPU Vulkan device (lavapipe). "
           "Zink needs Vulkan features that MoltenVK lacks (nullDescriptor of robustness2).",
           size=12, italic=True, color="#444")
    s.save(LINUX_DOC / "egl-zink-stack.svg")


def backends_per_platform():
    """The rendering paths available on each OS, with their CI status."""
    s = Svg(1240, 860, "OpenGL backends of PanamaGL on each OS : the same GL calls, different paths")
    cols = [("Linux", 20), ("Windows", 430), ("macOS", 840)]
    for name, x in cols:
        s.items.append(f'<rect x="{x}" y="55" width="390" height="740" rx="10" fill="#fafafa" '
                       f'stroke="#bbbbbb"/>')
        s.text(x + 195, 82, name, size=18, weight="bold", anchor="middle")

    def path(x, y, key, boxes, note=None):
        """A path : context API box then a chain of boxes."""
        bx = x + 12
        for i, (label, fill) in enumerate(boxes):
            w = 110 if i == 0 else 0
            s.box(bx, y, 366, 28, [label], fill, size=12, bold_first=(i == 0))
            if i < len(boxes) - 1:
                s.arrow(bx + 183, y + 28, bx + 183, y + 36)
            y += 36
        s.badge(x + 12, y, STATUS[key])
        if note:
            s.text(x + 12 + 9 + 7 * len(BADGE[STATUS[key]][1]) + 8, y + 13, note, size=11,
                   color="#444", italic=True)
        return y + 34

    x = 20
    y = 100
    y = path(x, y, "linux-glx-llvmpipe", [("GLX (default)", JAVA), ("Mesa llvmpipe : OpenGL on CPU", MESA)],
             "reference of the comparisons")
    y = path(x, y, "linux-glx-gpu", [("GLX (default)", JAVA), ("NVIDIA, AMD, Intel OpenGL driver", VENDOR)])
    y = path(x, y, "linux-egl-llvmpipe", [("EGL surfaceless", JAVA), ("Mesa llvmpipe", MESA)], "no X display")
    y = path(x, y, "linux-egl-zink-lavapipe", [("EGL surfaceless", JAVA), ("Mesa Zink", MESA),
                                               ("Vulkan : lavapipe (CPU)", VULKAN)], "236 tests in CI")
    y = path(x, y, "linux-egl-zink-gpu", [("EGL surfaceless", JAVA), ("Mesa Zink", MESA),
                                          ("Vulkan : radv, anv, nvk, NVIDIA", VULKAN), ("GPU", HW)])

    x = 430
    y = 100
    y = path(x, y, "windows-wgl-gpu", [("WGL (default)", JAVA), ("opengl32.dll + GPU vendor ICD", VENDOR)])
    y = path(x, y, "windows-wgl-d3d12", [("WGL", JAVA), ("Mesa opengl32.dll : d3d12", MESA),
                                         ("Direct3D 12 : WARP (CPU)", D3D)],
             "no wide nor stippled lines")
    y = path(x, y, "windows-wgl-llvmpipe", [("WGL", JAVA), ("Mesa opengl32.dll : llvmpipe", MESA)])
    y = path(x, y, "windows-wgl-zink-lavapipe", [("WGL", JAVA), ("Mesa opengl32.dll : Zink", MESA),
                                                 ("Vulkan : lavapipe (CPU)", VULKAN)],
             "ICD declared in the registry")
    y = path(x, y, "windows-wgl-zink-dzn", [("WGL", JAVA), ("Mesa opengl32.dll : Zink", MESA),
                                            ("Vulkan : dzn", VULKAN), ("Direct3D 12 : WARP", D3D)],
             "Zink does not start on dzn (WARP)")

    x = 840
    y = 100
    y = path(x, y, "macos-cgl-apple", [("CGL (default)", JAVA), ("Apple OpenGL.framework (2.1, 4.1 core)", VENDOR),
                                       ("Metal on Apple GPU, or software", METAL)],
             "CI : Apple Software Renderer")
    y = path(x, y, "macos-egl-llvmpipe", [("EGL (Mesa, Homebrew)", JAVA), ("Mesa llvmpipe", MESA)])
    y = path(x, y, "macos-egl-zink-kosmickrisp", [("EGL (Mesa, Homebrew)", JAVA), ("Mesa Zink", MESA),
                                                  ("Vulkan : KosmicKrisp", VULKAN), ("Metal", METAL)],
             "no Vulkan device on the CI runner")
    y = path(x, y, "macos-egl-zink-moltenvk", [("EGL (Mesa, Homebrew)", JAVA), ("Mesa Zink", MESA),
                                               ("Vulkan : MoltenVK", VULKAN), ("Metal", METAL)],
             "lacks nullDescriptor (robustness2)")

    s.legend(20, 805, LAYERS[:1] + LAYERS[2:4])
    s.legend(330, 805, LAYERS[4:7])
    bx = 640
    for st in (OK, EXP, KO, NA):
        bx += s.badge(bx, 808, st) + 10
    s.text(640, 848, "Images : CI job « Rendering comparison », artifact rendering-comparison.",
           size=12, italic=True, color="#444")
    s.save(FACTORY_DOC / "backends-per-platform.svg", LINUX_DOC / "backends-per-platform.svg")


def native_dependencies():
    """What to install for each configuration."""
    rows = [
        ("Linux, GLX (default)", "system", "libGL.so.1, libGLX, libGLU, libglut",
         "apt install libgl1 libglu1-mesa freeglut3", "(none)"),
        ("Linux, EGL", "system", "libEGL.so.1, libGL.so.1 (GLVND)", "apt install libegl1 libgl1",
         "PANAMAGL_LINUX_CONTEXT=egl"),
        ("Linux, EGL + Zink", "system", "+ libvulkan.so.1\n+ a Vulkan driver",
         "apt install mesa-vulkan-drivers\n(lavapipe, radv, anv, nvk) or GPU driver",
         "GALLIUM_DRIVER=zink\n+ LIBGL_ALWAYS_SOFTWARE=1 on CPU"),
        ("Windows, WGL (default)", "system", "opengl32.dll, glu32.dll\n+ GPU driver (ICD)", "(none)",
         "(none)"),
        ("Windows, Mesa", "shipped", "Mesa opengl32.dll\n(llvmpipe | d3d12 | zink)",
         "mmozeiko/build-mesa\nor mesa-dist-win",
         "-Dnative.lib.path.windows=\n<mesa dir>;C:\\Windows\\system32"),
        ("Windows, Mesa Zink", "shipped", "+ vulkan-1.dll\n+ lavapipe or dzn ICD",
         "GPU driver or Vulkan runtime ; ICD in\nHKLM\\SOFTWARE\\Khronos\\Vulkan\\Drivers",
         "GALLIUM_DRIVER=zink"),
        ("macOS, CGL (default)", "system", "OpenGL.framework\nGLUT.framework", "(none)", "(none)"),
        ("macOS, Mesa EGL", "Homebrew", "libEGL.dylib, libGL.dylib\nlibGLU.dylib",
         "brew install mesa mesa-glu", "PanamaGLFactory_linux\n+ setUseEGL(true)"),
        ("macOS, Mesa Zink", "Homebrew", "+ libvulkan.1.dylib\n+ KosmicKrisp or MoltenVK",
         "brew install vulkan-loader molten-vk",
         "GALLIUM_DRIVER=zink\nVK_DRIVER_FILES=...icd.json"),
    ]
    widths = [200, 110, 250, 380, 330]
    head = ["Configuration", "Provided by", "Native libraries", "Install", "Select"]
    row_h = 46
    s = Svg(sum(widths) + 40, 90 + row_h * (len(rows) + 1) + 40,
            "Native dependencies of each OpenGL backend")
    x0, y0 = 20, 60
    fills = {"system": "#f4f4f4", "shipped": D3D, "Homebrew": METAL}
    x = x0
    for w, h in zip(widths, head):
        s.items.append(f'<rect x="{x}" y="{y0}" width="{w}" height="{row_h}" fill="#dddddd" '
                       f'stroke="#bbbbbb"/>')
        s.text(x + 8, y0 + 28, h, size=13, weight="bold")
        x += w
    for i, row in enumerate(rows):
        y = y0 + row_h * (i + 1)
        x = x0
        for j, (w, cell) in enumerate(zip(widths, row)):
            fill = fills.get(row[1], "white") if j == 1 else ("white" if i % 2 == 0 else "#fbfbfb")
            s.items.append(f'<rect x="{x}" y="{y}" width="{w}" height="{row_h}" fill="{fill}" '
                           f'stroke="#cccccc"/>')
            lines = cell.split("\n")
            top = y + row_h / 2 - (len(lines) * 16) / 2 + 12
            for k, line in enumerate(lines):
                s.text(x + 8, top + k * 16, line, size=12, weight="bold" if j == 0 else "normal",
                       font=MONO if j in (3, 4) else FONT)
            x += w
    s.text(20, y0 + row_h * (len(rows) + 1) + 28,
           "« system » : installed with the OS or its packages.  « shipped » : to distribute with "
           "the application.  « Homebrew » : to install on the Mac.", size=12, italic=True,
           color="#444")
    s.save(LINUX_DOC / "native-dependencies.svg", FACTORY_DOC / "native-dependencies.svg")


if __name__ == "__main__":
    egl_gl_glext()
    egl_zink_stack()
    backends_per_platform()
    native_dependencies()
