package panamagl.rendering;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.function.Supplier;
import javax.imageio.ImageIO;
import org.junit.Assert;
import org.junit.Test;
import demos.panamagl.rendering.RenderingBackend;
import demos.panamagl.rendering.Scene;
import demos.panamagl.rendering.SceneRenderer;
import demos.panamagl.rendering.Scenes;
import panamagl.factory.PanamaGLFactory;
import panamagl.platform.linux.APanamaGLFactory_linux;

/**
 * Render every {@link Scenes scene} with the OpenGL context of the platform, as the factory creates
 * it (GLX, EGL, WGL or CGL), and save the images in <code>target/renderings</code> under names
 * describing the scene and the backend (see {@link RenderingBackend}), with a <code>.properties</code>
 * file giving the renderer, the OpenGL version and the time per frame. A scene or a context that
 * fails is recorded with its error.
 *
 * <p>The CI runs it on every OS and on OpenGL implementations layered over other graphics APIs
 * (Mesa Zink over Vulkan, Mesa d3d12 over Direct3D 12, Apple OpenGL), then compares the images.
 *
 * <p>With the environment variable <code>PANAMAGL_FACTORY=mesa-egl</code>, the scenes are rendered
 * through a headless EGL context of Mesa, on any OS where Mesa provides EGL.
 */
public class TestBackendRendering {
  public static final String OUTPUT = "target/renderings";
  static final int W = 480;
  static final int H = 360;

  @Test
  public void renderScenes() throws Exception {
    PanamaGLFactory factory = SceneRenderer.defaultFactory();
    SceneRenderer renderer;
    try {
      renderer = new SceneRenderer(factory);
    } catch (RuntimeException | Error e) {
      // Keep a trace of the backend that could not render, for the comparison
      for (Supplier<Scene> s : Scenes.all())
        saveFailure(expected(factory, e), s.get().getName(), e);
      throw e;
    }

    List<String> failures = new ArrayList<>();
    try {
      RenderingBackend backend = new RenderingBackend(renderer.getContext(), renderer.getProfile());
      System.out.println("TestBackendRendering : " + backend);
      for (Supplier<Scene> supplier : Scenes.all()) {
        Scene scene = supplier.get();
        try {
          SceneRenderer.Rendering r = renderer.render(scene, W, H);
          save(backend, scene, r);
        } catch (RuntimeException | Error e) {
          failures.add(scene.getName() + " : " + e.getMessage());
          saveFailure(backend, scene.getName(), e);
        }
      }
    } finally {
      renderer.close();
    }
    Assert.assertTrue("scenes failed : " + failures, failures.isEmpty());
  }

  protected void save(RenderingBackend backend, Scene scene, SceneRenderer.Rendering r)
      throws Exception {
    BufferedImage image = r.image();
    int notBackground = 0, background = image.getRGB(0, 0);
    for (int x = 0; x < W; x += 2)
      for (int y = 0; y < H; y += 2)
        if (image.getRGB(x, y) != background)
          notBackground++;

    File dir = new File(OUTPUT);
    dir.mkdirs();
    String name = backend.getName(scene.getName());
    ImageIO.write(image, "png", new File(dir, name + ".png"));

    Properties p = backend.toProperties();
    p.setProperty("scene", scene.getName());
    p.setProperty("status", "rendered");
    p.setProperty("image", name + ".png");
    p.setProperty("width", String.valueOf(W));
    p.setProperty("height", String.valueOf(H));
    p.setProperty("time", String.valueOf(scene.referenceTime()));
    p.setProperty("ms.per.frame", String.format(Locale.ROOT, "%.2f", r.msPerFrame()));
    try (OutputStream out = new FileOutputStream(new File(dir, name + ".properties"))) {
      p.store(out, "PanamaGL rendering backend");
    }
    System.out.println("TestBackendRendering : " + scene.getName() + " "
        + String.format(Locale.ROOT, "%.2f ms per frame", r.msPerFrame()) + " -> " + name + ".png");

    Assert.assertTrue(scene.getName() + " not rendered", notBackground > (W / 2) * (H / 2) / 20);
  }

  static RenderingBackend expected(PanamaGLFactory factory, Throwable e) {
    String os = System.getProperty("os.name").toLowerCase(Locale.ROOT);
    String contextClass = factory instanceof APanamaGLFactory_linux linux
        ? (linux.isUseEGL() ? "EGLContext_linux" : "GLXContext_linux")
        : os.contains("win") ? "WGLContext_windows" : "CGLContext_macOS";
    return RenderingBackend.expected(contextClass, String.valueOf(e.getMessage()));
  }

  /** Write a .properties file without image, giving the backend and the error. */
  static void saveFailure(RenderingBackend backend, String scene, Throwable e) throws Exception {
    String error = String.valueOf(e.getMessage()).replaceAll("\\s+", " ");
    File dir = new File(OUTPUT);
    dir.mkdirs();
    String name = backend.getName(scene);
    Properties p = backend.toProperties();
    p.setProperty("scene", scene);
    p.setProperty("status", "failed");
    p.setProperty("error", e.getClass().getSimpleName() + " : " + error);
    try (OutputStream out = new FileOutputStream(new File(dir, name + ".properties"))) {
      p.store(out, "PanamaGL rendering backend, failed");
    }
    System.out.println("TestBackendRendering : FAILED " + scene + " on " + backend + " : " + error);
  }
}
