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
package demos.panamagl.linux;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import javax.imageio.ImageIO;
import panamagl.GLProfile;
import panamagl.Image;
import panamagl.factory.PanamaGLFactory;
import panamagl.offscreen.FBO;
import panamagl.offscreen.FBOReader_AWT;
import panamagl.opengl.GL;
import panamagl.opengl.GLError;
import panamagl.platform.linux.APanamaGLFactory_linux;
import panamagl.platform.linux.EGLContext_linux;

/**
 * Render a fixed function OpenGL scene without any window nor X display, through a headless EGL
 * context, then save it as a PNG image.
 *
 * <p>The scene uses features that an OpenGL implementation layered over another API has to emulate
 * : immediate mode, lighting, quads, wide and stippled lines, large points, GLU quadrics.
 *
 * <p>Run it on the default OpenGL implementation, or on OpenGL over Vulkan with Mesa Zink :
 *
 * <pre>
 * mvn -pl panama-gl-samples exec:java -Dexec.mainClass=demos.panamagl.linux.DemoEGL_Offscreen
 *
 * GALLIUM_DRIVER=zink mvn -pl panama-gl-samples exec:java -Dexec.mainClass=demos.panamagl.linux.DemoEGL_Offscreen
 *
 * # on a computer without GPU, let Zink use the lavapipe CPU Vulkan driver (mesa-vulkan-drivers) :
 * LIBGL_ALWAYS_SOFTWARE=1 GALLIUM_DRIVER=zink ...
 * </pre>
 *
 * VM ARGS : --enable-native-access=ALL-UNNAMED -Djava.library.path=.:/usr/lib/x86_64-linux-gnu/
 *
 * <p>Arguments (optional) : output file, width, height, number of frames to time.
 */
public class DemoEGL_Offscreen {

  public static void main(String[] args) throws Exception {
    String file = args.length > 0 ? args[0] : "target/DemoEGL_Offscreen.png";
    int width = args.length > 1 ? Integer.parseInt(args[1]) : 480;
    int height = args.length > 2 ? Integer.parseInt(args[2]) : 360;
    int frames = args.length > 3 ? Integer.parseInt(args[3]) : 100;

    // Select the Linux factory and ask it a headless EGL context
    PanamaGLFactory factory = PanamaGLFactory.select();
    if (!(factory instanceof APanamaGLFactory_linux)) {
      System.err.println("This demo runs on Linux only : " + factory.getClass().getSimpleName());
      return;
    }
    ((APanamaGLFactory_linux) factory).setUseEGL(true);

    EGLContext_linux context = (EGLContext_linux) factory.newGLContext();
    GL gl = factory.newGL();
    GLProfile profile = new GLProfile(gl);

    System.out.println("EGL      : " + context.getEGLVersion() + " " + context.getEGLVendor()
        + ", " + context.getPlatform() + " platform");
    System.out.println("OpenGL   : " + profile.getVersion());
    System.out.println("Renderer : " + profile.getRenderer());
    System.out.println("Over Vulkan (Zink) : " + profile.getRenderer().startsWith("zink"));

    // Render in a FBO, as PanamaGL canvases do
    FBO fbo = factory.newFBO(width, height);
    fbo.prepare(gl);

    try (Arena arena = Arena.ofConfined()) {
      init(gl, arena, width, height);

      long start = System.nanoTime();
      for (int i = 0; i < frames; i++) {
        display(gl, i * 360f / Math.max(frames, 1));
        gl.glFinish();
      }
      double ms = (System.nanoTime() - start) / 1e6 / Math.max(frames, 1);
      System.out.printf("Frames   : %d, %.2f ms per frame (%dx%d)%n", frames, ms, width, height);

      display(gl, 30);
      GLError.checkAndThrow(gl);

      // Read the pixels back and save them
      Image<?> image = new FBOReader_AWT().read(fbo, gl);
      File out = new File(file);
      if (out.getParentFile() != null)
        out.getParentFile().mkdirs();
      // OpenGL rows start at the bottom : flip the image vertically before saving it
      ImageIO.write(flipVertically((BufferedImage) image.getImage()), "png", out);
      System.out.println("Image    : " + out.getAbsolutePath());
    } finally {
      fbo.release(gl);
      factory.destroyContext();
    }
  }

  static BufferedImage flipVertically(BufferedImage in) {
    BufferedImage out = new BufferedImage(in.getWidth(), in.getHeight(), BufferedImage.TYPE_INT_ARGB);
    Graphics2D g = out.createGraphics();
    g.drawImage(in, 0, in.getHeight(), in.getWidth(), -in.getHeight(), null);
    g.dispose();
    return out;
  }

  static MemorySegment quadric;

  public static void init(GL gl, Arena arena, int width, int height) {
    gl.glViewport(0, 0, width, height);
    gl.glMatrixMode(GL.GL_PROJECTION);
    gl.glLoadIdentity();
    gl.gluPerspective(40, (double) width / height, 0.1, 20);
    gl.glMatrixMode(GL.GL_MODELVIEW);
    gl.glLoadIdentity();
    gl.gluLookAt(0, 1.2, 4, 0, 0, 0, 0, 1, 0);

    gl.glEnable(GL.GL_DEPTH_TEST);
    gl.glShadeModel(GL.GL_SMOOTH);

    var position = arena.allocateFrom(ValueLayout.JAVA_FLOAT, 2f, 4f, 3f, 0f);
    var white = arena.allocateFrom(ValueLayout.JAVA_FLOAT, 1f, 1f, 1f, 1f);
    var ambient = arena.allocateFrom(ValueLayout.JAVA_FLOAT, .15f, .15f, .15f, 1f);
    gl.glLightfv(GL.GL_LIGHT0, GL.GL_POSITION, position);
    gl.glLightfv(GL.GL_LIGHT0, GL.GL_DIFFUSE, white);
    gl.glLightfv(GL.GL_LIGHT0, GL.GL_SPECULAR, white);
    gl.glLightfv(GL.GL_LIGHT0, GL.GL_AMBIENT, ambient);
    gl.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, white);
    gl.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, arena.allocateFrom(ValueLayout.JAVA_FLOAT, 60f));
    gl.glColorMaterial(GL.GL_FRONT, GL.GL_AMBIENT_AND_DIFFUSE);
    gl.glEnable(GL.GL_COLOR_MATERIAL);

    quadric = gl.gluNewQuadric();
  }

  public static void display(GL gl, float angle) {
    gl.glClearColor(1f, 1f, 1f, 1f);
    gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);

    gl.glPushMatrix();
    gl.glRotatef(angle, 0, 1, 0);

    // Floor : colored quads, flat lighting off
    gl.glDisable(GL.GL_LIGHTING);
    gl.glBegin(GL.GL_QUADS);
    for (int i = -4; i < 4; i++) {
      for (int j = -4; j < 4; j++) {
        float c = ((i + j) & 1) == 0 ? 0.85f : 0.65f;
        gl.glColor3f(c, c, (i + 4) / 8f);
        gl.glVertex3f(i * .25f, -.6f, j * .25f);
        gl.glVertex3f((i + 1) * .25f, -.6f, j * .25f);
        gl.glVertex3f((i + 1) * .25f, -.6f, (j + 1) * .25f);
        gl.glVertex3f(i * .25f, -.6f, (j + 1) * .25f);
      }
    }
    gl.glEnd();

    // Wide stippled line loop around the floor
    gl.glLineWidth(4f);
    gl.glEnable(GL.GL_LINE_STIPPLE);
    gl.glLineStipple(2, (short) 0x0F0F);
    gl.glColor3f(0.8f, 0.1f, 0.1f);
    gl.glBegin(GL.GL_LINE_LOOP);
    gl.glVertex3f(-1, -.6f, -1);
    gl.glVertex3f(1, -.6f, -1);
    gl.glVertex3f(1, -.6f, 1);
    gl.glVertex3f(-1, -.6f, 1);
    gl.glEnd();
    gl.glDisable(GL.GL_LINE_STIPPLE);
    gl.glLineWidth(1f);

    // Large points at the corners
    gl.glPointSize(10f);
    gl.glBegin(GL.GL_POINTS);
    gl.glColor3f(0.1f, 0.6f, 0.1f);
    gl.glVertex3f(-1, -.6f, -1);
    gl.glVertex3f(1, -.6f, -1);
    gl.glVertex3f(1, -.6f, 1);
    gl.glVertex3f(-1, -.6f, 1);
    gl.glEnd();
    gl.glPointSize(1f);

    // Lit sphere (GLU quadric)
    gl.glEnable(GL.GL_LIGHTING);
    gl.glEnable(GL.GL_LIGHT0);
    gl.glColor3f(0.2f, 0.35f, 0.9f);
    gl.gluSphere(quadric, 0.55, 48, 32);
    gl.glDisable(GL.GL_LIGHTING);

    gl.glPopMatrix();
  }
}
