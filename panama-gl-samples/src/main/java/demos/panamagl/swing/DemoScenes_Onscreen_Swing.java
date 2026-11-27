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
package demos.panamagl.swing;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.lang.foreign.Arena;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import demos.panamagl.rendering.RenderingBackend;
import demos.panamagl.rendering.Scene;
import demos.panamagl.rendering.SceneRenderer;
import demos.panamagl.rendering.Scenes;
import panamagl.Animator;
import panamagl.GLEventAdapter;
import panamagl.GLProfile;
import panamagl.Image;
import panamagl.canvas.GLCanvasSwing;
import panamagl.factory.PanamaGLFactory;
import panamagl.opengl.GL;
import panamagl.platform.linux.APanamaGLFactory_linux;

/**
 * The scenes used to compare the rendering backends ({@link Scenes}), animated in a Swing window.
 * The window shows the backend that renders them : OpenGL renderer, context (GLX, EGL, WGL, CGL)
 * and the graphics API below OpenGL (Vulkan through Zink, Direct3D 12, Metal...).
 *
 * <p>Change the scene with the combo box, or the left and right arrow keys.
 *
 * <pre>
 * mvn -pl panama-gl-samples exec:java -Dexec.mainClass=demos.panamagl.swing.DemoScenes_Onscreen_Swing
 *
 * # Linux : OpenGL over Vulkan, through a headless EGL context
 * GALLIUM_DRIVER=zink mvn ... -Dexec.args="--egl"
 * </pre>
 *
 * VM ARGS : --enable-native-access=ALL-UNNAMED -Djava.library.path=.:/usr/lib/x86_64-linux-gnu/
 *
 * <p>Arguments, all optional :
 * <ul>
 * <li><code>--egl</code> : on Linux, use an EGL context rather than GLX (as
 * <code>PANAMAGL_LINUX_CONTEXT=egl</code>, or <code>PANAMAGL_FACTORY=mesa-egl</code> on macOS)</li>
 * <li><code>--scene name</code> : the scene shown first, e.g. <code>planet</code></li>
 * <li><code>--screenshots dir</code> : save a screenshot of each scene in the directory, then
 * exit</li>
 * </ul>
 */
public class DemoScenes_Onscreen_Swing {
  /** Frames rendered before a screenshot, to let the canvas settle at its size. */
  static final int SCREENSHOT_FRAMES = 12;

  public static void main(String[] args) throws Exception {
    boolean egl = false;
    String first = null;
    String screenshots = null;
    for (int i = 0; i < args.length; i++) {
      switch (args[i]) {
        case "--egl" -> egl = true;
        case "--scene" -> first = args[++i];
        case "--screenshots" -> screenshots = args[++i];
        default -> System.err.println("Unknown argument : " + args[i]);
      }
    }

    PanamaGLFactory factory = SceneRenderer.defaultFactory();
    if (egl) {
      if (factory instanceof APanamaGLFactory_linux linux)
        linux.setUseEGL(true);
      else
        System.err.println("--egl ignored : EGL is used on Linux, or with PANAMAGL_FACTORY=mesa-egl");
    }

    List<String> names = Scenes.all().stream().map(s -> s.get().getName()).toList();
    SceneListener listener = new SceneListener(first != null ? first : names.get(1));

    JFrame frame = new JFrame("PanamaGL scenes");
    JLabel backend = new JLabel("...");
    JComboBox<String> combo = new JComboBox<>(names.toArray(new String[0]));
    combo.setSelectedItem(listener.requested.get());
    combo.addActionListener(e -> listener.show((String) combo.getSelectedItem()));
    combo.setFocusable(false);

    listener.onInit = profile -> SwingUtilities.invokeLater(() -> {
      frame.setTitle("PanamaGL scenes - " + profile.getRenderer());
      backend.setText(listener.backend.toString());
    });
    listener.onSceneChange = name -> SwingUtilities.invokeLater(() -> combo.setSelectedItem(name));

    GLCanvasSwing canvas = new GLCanvasSwing(factory);
    listener.canvas = canvas;
    canvas.setGLEventListener(listener);

    JPanel bar = new JPanel(new FlowLayout(FlowLayout.LEFT));
    bar.add(combo);
    bar.add(backend);

    frame.getContentPane().setLayout(new BorderLayout());
    frame.setBounds(0, 0, 800, 640);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.addKeyListener(new KeyAdapter() {
      @Override
      public void keyPressed(KeyEvent e) {
        int step = e.getKeyCode() == KeyEvent.VK_RIGHT ? 1
            : e.getKeyCode() == KeyEvent.VK_LEFT ? -1 : 0;
        if (step != 0) {
          int index = names.indexOf(listener.requested.get());
          combo.setSelectedItem(names.get((index + step + names.size()) % names.size()));
        }
      }
    });

    SwingUtilities.invokeAndWait(() -> {
      frame.add(bar, BorderLayout.NORTH);
      frame.add(canvas, BorderLayout.CENTER);
      frame.setVisible(true);
    });

    Animator animator = new Animator(canvas);
    animator.start();

    if (screenshots != null)
      screenshots(new File(screenshots), names, listener, canvas);
  }

  /** Show each scene, save the canvas, and exit. */
  static void screenshots(File dir, List<String> names, SceneListener listener, GLCanvasSwing canvas)
      throws Exception {
    dir.mkdirs();
    for (String name : names) {
      listener.show(name);
      int start = -1;
      while (start < 0 || listener.frames.get() < start + SCREENSHOT_FRAMES) {
        Thread.sleep(50);
        if (start < 0 && name.equals(listener.current()))
          start = listener.frames.get();
      }
      Image<?> image = canvas.getScreenshot();
      File file = new File(dir, "swing__" + listener.backend.getName(name) + ".png");
      image.save(file.getPath());
      System.out.println("Screenshot : " + file.getPath());
    }
    System.exit(0);
  }

  /**
   * Draws the current scene. The scene changes on the rendering thread : a change requested from
   * the UI is applied at the next frame, by releasing the resources of the previous scene.
   */
  public static class SceneListener extends GLEventAdapter {
    final AtomicReference<String> requested = new AtomicReference<>();
    final AtomicInteger frames = new AtomicInteger();
    volatile java.util.function.Consumer<GLProfile> onInit = p -> {
    };
    volatile java.util.function.Consumer<String> onSceneChange = n -> {
    };
    volatile RenderingBackend backend;

    protected Scene scene;
    protected Arena arena;
    protected volatile String shown;
    protected int width = 1;
    protected int height = 1;
    protected boolean resized = false;
    protected long start = System.nanoTime();
    protected GLCanvasSwing canvas;

    public SceneListener(String first) {
      requested.set(first);
    }

    /** Ask to show the scene of the given name, from any thread. */
    public void show(String name) {
      if (name != null && !name.equals(requested.getAndSet(name)))
        onSceneChange.accept(name);
    }

    /** @return the name of the scene drawn by the last frame. */
    public String current() {
      return shown;
    }

    @Override
    public void init(GL gl) {
      GLProfile profile = new GLProfile(gl);
      System.out.println("OpenGL   : " + profile.getVersion());
      System.out.println("Renderer : " + profile.getRenderer());
      backend = new RenderingBackend(canvas.getContext(), profile);
      onInit.accept(profile);
    }

    @Override
    public void reshape(GL gl, int x, int y, int width, int height) {
      this.width = Math.max(1, width);
      this.height = Math.max(1, height);
      // The scenes size their viewport and their textures at init
      resized = true;
    }

    @Override
    public void display(GL gl) {
      String name = requested.get();
      if (scene == null || resized || !name.equals(scene.getName())) {
        release(gl);
        scene = Scenes.byName(name);
        arena = Arena.ofShared();
        scene.init(gl, arena, width, height);
        resized = false;
        if (!name.equals(shown))
          start = System.nanoTime();
      }
      scene.display(gl, scene.referenceTime() + (System.nanoTime() - start) / 1e9f);
      shown = name;
      frames.incrementAndGet();
    }

    @Override
    public void dispose(GL gl) {
      release(gl);
    }

    protected void release(GL gl) {
      if (scene != null)
        scene.dispose(gl);
      if (arena != null)
        arena.close();
      scene = null;
      arena = null;
    }
  }
}
