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

import java.awt.image.BufferedImage;
import java.io.File;
import java.lang.foreign.Arena;
import javax.imageio.ImageIO;
import panamagl.GLProfile;
import panamagl.factory.PanamaGLFactory;
import panamagl.offscreen.FBO;
import panamagl.offscreen.FBOReader_AWT;
import panamagl.opengl.GL;
import panamagl.opengl.GLContext;
import panamagl.opengl.GLError;
import panamagl.platform.linux.APanamaGLFactory_linux;
import panamagl.platform.linux.PanamaGLFactory_linux;

/**
 * Render scenes offscreen, in a FBO, and read them back as images.
 *
 * <pre>
 * java ... demos.panamagl.rendering.SceneRenderer [scene|all] [output dir] [width] [height]
 * </pre>
 *
 * With <code>PANAMAGL_FACTORY=mesa-egl</code>, renders through Mesa's EGL (Linux, macOS with
 * Homebrew's Mesa), e.g. on Zink with <code>GALLIUM_DRIVER=zink</code>.
 */
public class SceneRenderer implements AutoCloseable {
  /** The result of a rendering. */
  public record Rendering(BufferedImage image, double msPerFrame) {
  }

  protected final PanamaGLFactory factory;
  protected final GLContext context;
  protected final GL gl;
  protected final GLProfile profile;

  public SceneRenderer(PanamaGLFactory factory) {
    this.factory = factory;
    this.context = factory.newGLContext();
    this.gl = factory.newGL();
    this.profile = new GLProfile(gl);
  }

  /** The factory of the platform, or the EGL factory of Mesa if PANAMAGL_FACTORY=mesa-egl. */
  public static PanamaGLFactory defaultFactory() {
    if ("mesa-egl".equalsIgnoreCase(System.getenv("PANAMAGL_FACTORY"))) {
      APanamaGLFactory_linux mesa = new PanamaGLFactory_linux();
      mesa.setUseEGL(true);
      return mesa;
    }
    return PanamaGLFactory.select();
  }

  public Rendering render(Scene scene, int width, int height) {
    FBO fbo = factory.newFBO(width, height);
    fbo.prepare(gl);
    try (Arena arena = Arena.ofConfined()) {
      scene.init(gl, arena, width, height);
      GLError.checkAndThrow(gl);

      int frames = Math.max(1, scene.timedFrames());
      long start = System.nanoTime();
      for (int i = 0; i < frames; i++) {
        scene.display(gl, scene.referenceTime() + i * 0.04f);
        gl.glFinish();
      }
      double ms = (System.nanoTime() - start) / 1e6 / frames;

      scene.display(gl, scene.referenceTime());
      GLError.checkAndThrow(gl);
      BufferedImage image = (BufferedImage) new FBOReader_AWT().read(fbo, gl).getImage();
      scene.dispose(gl);
      return new Rendering(ReferenceScene.flipVertically(image), ms);
    } finally {
      fbo.release(gl);
    }
  }

  public GLContext getContext() {
    return context;
  }

  public GLProfile getProfile() {
    return profile;
  }

  @Override
  public void close() {
    factory.destroyContext();
  }

  public static void main(String[] args) throws Exception {
    String which = args.length > 0 ? args[0] : "all";
    File dir = new File(args.length > 1 ? args[1] : "target/scenes");
    int width = args.length > 2 ? Integer.parseInt(args[2]) : 480;
    int height = args.length > 3 ? Integer.parseInt(args[3]) : 360;
    dir.mkdirs();

    try (SceneRenderer renderer = new SceneRenderer(defaultFactory())) {
      RenderingBackend backend = new RenderingBackend(renderer.getContext(), renderer.getProfile());
      System.out.println("Backend : " + backend);
      for (var supplier : Scenes.all()) {
        Scene scene = supplier.get();
        if (!"all".equals(which) && !scene.getName().equals(which))
          continue;
        Rendering r = renderer.render(scene, width, height);
        File file = new File(dir, backend.getName(scene.getName()) + ".png");
        ImageIO.write(r.image(), "png", file);
        System.out.printf("%-16s %8.1f ms per frame  %s%n", scene.getName(), r.msPerFrame(), file);
      }
    }
  }
}
