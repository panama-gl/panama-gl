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

import java.awt.BorderLayout;
import java.io.File;
import java.util.concurrent.atomic.AtomicInteger;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import demos.panamagl.swing.DemoTeapot_Onscreen_Swing;
import panamagl.Animator;
import panamagl.GLEventAdapter;
import panamagl.GLProfile;
import panamagl.Image;
import panamagl.canvas.GLCanvasSwing;
import panamagl.factory.PanamaGLFactory;
import panamagl.opengl.GL;
import panamagl.platform.linux.APanamaGLFactory_linux;

/**
 * A Swing window whose OpenGL rendering goes through a headless EGL context : the window is a
 * regular Swing component, the OpenGL implementation is the one EGL selects, e.g. Mesa Zink to run
 * OpenGL over Vulkan. The title shows the OpenGL renderer.
 *
 * <pre>
 * GALLIUM_DRIVER=zink mvn -pl panama-gl-samples exec:java -Dexec.mainClass=demos.panamagl.linux.DemoEGL_Onscreen_Swing
 * </pre>
 *
 * VM ARGS : --enable-native-access=ALL-UNNAMED -Djava.library.path=.:/usr/lib/x86_64-linux-gnu/
 *
 * <p>Arguments (optional) : <code>--screenshot file.png</code> saves the canvas after 60 frames,
 * then exits.
 */
public class DemoEGL_Onscreen_Swing {

  public static void main(String[] args) throws Exception {
    String screenshot = args.length > 1 && "--screenshot".equals(args[0]) ? args[1] : null;

    PanamaGLFactory factory = PanamaGLFactory.select();
    if (!(factory instanceof APanamaGLFactory_linux)) {
      System.err.println("This demo runs on Linux only : " + factory.getClass().getSimpleName());
      return;
    }
    ((APanamaGLFactory_linux) factory).setUseEGL(true);

    final JFrame frame = new JFrame(DemoEGL_Onscreen_Swing.class.getSimpleName());

    final AtomicInteger frames = new AtomicInteger();

    // The teapot of the Swing demo, reporting the renderer in the window title at init
    GLEventAdapter teapot = DemoTeapot_Onscreen_Swing.TeapotGLEventListener();
    GLEventAdapter listener = new GLEventAdapter() {
      @Override
      public void init(GL gl) {
        GLProfile profile = new GLProfile(gl);
        System.out.println("OpenGL   : " + profile.getVersion());
        System.out.println("Renderer : " + profile.getRenderer());
        SwingUtilities.invokeLater(() -> frame.setTitle("PanamaGL on EGL : " + profile.getRenderer()));
        teapot.init(gl);
      }

      @Override
      public void display(GL gl) {
        teapot.display(gl);
        frames.incrementAndGet();
      }

      @Override
      public void reshape(GL gl, int x, int y, int width, int height) {
        teapot.reshape(gl, x, y, width, height);
      }
    };

    GLCanvasSwing canvas = new GLCanvasSwing(factory);
    canvas.setGLEventListener(listener);

    frame.getContentPane().setLayout(new BorderLayout());
    frame.setBounds(0, 0, 640, 480);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    SwingUtilities.invokeAndWait(() -> {
      frame.add(canvas, BorderLayout.CENTER);
      frame.setVisible(true);
    });

    Animator animator = new Animator(canvas);
    animator.start();

    if (screenshot != null) {
      while (frames.get() < 60)
        Thread.sleep(50);
      Image<?> image = canvas.getScreenshot();
      File out = new File(screenshot);
      if (out.getParentFile() != null)
        out.getParentFile().mkdirs();
      image.save(out.getPath());
      System.out.println("Screenshot : " + out.getAbsolutePath());
      System.exit(0);
    }
  }
}
