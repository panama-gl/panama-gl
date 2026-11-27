package panamagl.rendering;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.lang.foreign.Arena;
import java.util.Locale;
import java.util.Properties;
import javax.imageio.ImageIO;
import org.junit.Assert;
import org.junit.Test;
import demos.panamagl.rendering.ReferenceScene;
import demos.panamagl.rendering.RenderingBackend;
import panamagl.GLProfile;
import panamagl.Image;
import panamagl.factory.PanamaGLFactory;
import panamagl.offscreen.FBO;
import panamagl.offscreen.FBOReader_AWT;
import panamagl.opengl.GL;
import panamagl.opengl.GLContext;
import panamagl.opengl.GLError;

/**
 * Render the {@link ReferenceScene} with the OpenGL context of the platform, as the factory creates
 * it (GLX, EGL, WGL or CGL), and save the image in <code>target/renderings</code> under a name
 * describing the backend (see {@link RenderingBackend}), with a <code>.properties</code> file giving
 * the renderer, the OpenGL version and the time per frame.
 *
 * <p>The CI runs it on every OS and on OpenGL implementations layered over other graphics APIs
 * (Mesa Zink over Vulkan, Mesa d3d12 over Direct3D 12, Apple OpenGL over Metal), then compares the
 * images.
 */
public class TestBackendRendering {
  public static final String SCENE = "reference-scene";
  public static final String OUTPUT = "target/renderings";
  static final int W = 480;
  static final int H = 360;
  static final int FRAMES = 30;

  @Test
  public void renderReferenceScene() throws Exception {
    PanamaGLFactory factory = PanamaGLFactory.select();
    GLContext context = factory.newGLContext();
    GL gl = factory.newGL();
    GLProfile profile = new GLProfile(gl);
    RenderingBackend backend = new RenderingBackend(context, profile);
    System.out.println("TestBackendRendering : " + backend);

    FBO fbo = factory.newFBO(W, H);
    fbo.prepare(gl);

    try (Arena arena = Arena.ofConfined()) {
      ReferenceScene.init(gl, arena, W, H);

      long start = System.nanoTime();
      for (int i = 0; i < FRAMES; i++) {
        ReferenceScene.display(gl, i * 12f);
        gl.glFinish();
      }
      double msPerFrame = (System.nanoTime() - start) / 1e6 / FRAMES;

      ReferenceScene.display(gl, 30);
      GLError.checkAndThrow(gl);

      Image<?> image = new FBOReader_AWT().read(fbo, gl);
      BufferedImage rendering = ReferenceScene.flipVertically((BufferedImage) image.getImage());

      // Then the scene is rendered : a blue sphere and a floor on a white background
      int blue = 0, notWhite = 0;
      for (int x = 0; x < W; x++) {
        for (int y = 0; y < H; y++) {
          int rgb = rendering.getRGB(x, y);
          int r = (rgb >> 16) & 0xFF, g = (rgb >> 8) & 0xFF, b = rgb & 0xFF;
          if (r < 250 || g < 250 || b < 250)
            notWhite++;
          if (b > r + 60 && b > g + 30)
            blue++;
        }
      }

      // Save the rendering and its description
      File dir = new File(OUTPUT);
      dir.mkdirs();
      String name = backend.getName(SCENE);
      ImageIO.write(rendering, "png", new File(dir, name + ".png"));

      Properties p = backend.toProperties();
      p.setProperty("scene", SCENE);
      p.setProperty("image", name + ".png");
      p.setProperty("width", String.valueOf(W));
      p.setProperty("height", String.valueOf(H));
      p.setProperty("ms.per.frame", String.format(Locale.ROOT, "%.2f", msPerFrame));
      p.setProperty("pixels.not.white", String.valueOf(notWhite));
      p.setProperty("pixels.blue", String.valueOf(blue));
      try (OutputStream out = new FileOutputStream(new File(dir, name + ".properties"))) {
        p.store(out, "PanamaGL rendering backend");
      }
      System.out.println("TestBackendRendering : " + new File(dir, name + ".png").getAbsolutePath()
          + String.format(Locale.ROOT, " (%.2f ms per frame)", msPerFrame));

      Assert.assertTrue("scene not rendered : " + notWhite + " pixels", notWhite > W * H / 20);
      Assert.assertTrue("no blue sphere : " + blue + " pixels", blue > W * H / 50);
    } finally {
      fbo.release(gl);
      factory.destroyContext();
    }
  }
}
