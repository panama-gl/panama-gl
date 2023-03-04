/*******************************************************************************
 * Copyright (c) 2022, 2023 Martin Pernollet & contributors.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301, USA
 *******************************************************************************/
package demos.panamagl.swing;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import demos.panamagl.offscreen.SampleTriangle;
import panamagl.Animator;
import panamagl.GLEventAdapter;
import panamagl.canvas.GLCanvasSwing;
import panamagl.canvas.SwingCanvasFactory;
import panamagl.factory.PanamaGLFactory;
import panamagl.opengl.GL;

/**
 * VM ARGS : --enable-native-access=ALL-UNNAMED --add-modules jdk.incubator.foreign
 * -Djava.library.path=.:/System/Library/Frameworks/OpenGL.framework/Versions/Current/Libraries/
 * 
 * or
 * -Djava.library.path=.:/usr/lib/x86_64-linux-gnu/
 * 
 * @author Martin
 *
 */
public class DemoTriangle_Onscreen_Swing {

  public static void main(String[] args) throws Exception {
    System.out
        .println("SwingUtilities.isEventDispatchThread: " + SwingUtilities.isEventDispatchThread());

    // This is the GL Scene to render
    GLEventAdapter listener = RGBTriangleEventListenerAnim();

    // Using a panel to ensure that GL get initialized in the main AWT thread.
    PanamaGLFactory factory = PanamaGLFactory.select();
    GLCanvasSwing panel = (GLCanvasSwing)factory.newCanvas(new SwingCanvasFactory());
    panel.setGLEventListener(listener);

    // Create frame
    final JFrame frame = new JFrame(DemoTriangle_Onscreen_Swing.class.getSimpleName());
    frame.getContentPane().setLayout(new BorderLayout());
    // frame.pack();
    frame.setBounds(0, 0, 800, 600);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Use this to avoid Swing hangs
    SwingUtilities.invokeLater(new Runnable() {
      @Override
      public void run() {

        // Add panel to frame
        frame.add(panel, BorderLayout.CENTER);

        // Open frame
        System.out.println("-----------------------------");
        System.out.println("BEFORE Frame.setVisible(true)");
        System.out.println("-----------------------------");
        frame.setVisible(true);
        System.out.println("-----------------------------");
        System.out.println("AFTER Frame.setVisible(true)");
        System.out.println("-----------------------------");

      }
    });

    // ---------------------------------------
    // Animate

    //Thread.sleep(5000);
    System.out.println("Start loop");

    Animator a = new Animator(panel);
    a.start();

    // Thread.sleep(5000);
    // a.stop();

  }

  /** Draw a fullcanvas triangle. */
  public static GLEventAdapter RGBTriangleEventListener() {
    return new GLEventAdapter() {
      public void display(GL gl) {
        SampleTriangle.rgbaTriangle2D(w, h);
        // System.out.println("GLEventAdapter : Triangle rendered!");
      }

      @Override
      public void reshape(GL gl, int x, int y, int width, int height) {
        w = width;
        h = height;
        // super.reshape(gl, x, y, width, height);
      }

      int w = 800;
      int h = 600;
    };
  }

  /** Draw a fullcanvas triangle. Then reduce size then grow size */
  public static GLEventAdapter RGBTriangleEventListenerAnim() {
    return new GLEventAdapter() {
      public void display(GL gl) {

        if (h - inc == 10) {
          dir *= -1;
        } else if (h - inc == 600) {
          dir *= 1;
        }
        inc += dir;

        // System.out.println("w:" + (w-inc) + " h:" + (h-inc));

        SampleTriangle.rgbaTriangle2D(w - inc, h - inc);
      }

      @Override
      public void reshape(GL gl, int x, int y, int width, int height) {
        w = width;
        h = height;
        // super.reshape(gl, x, y, width, height);
      }

      int w = 800;
      int h = 600;

      int inc = 0;
      int dir = 1;
    };
  }

}
