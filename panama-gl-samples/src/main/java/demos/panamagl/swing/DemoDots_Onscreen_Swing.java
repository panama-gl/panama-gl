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
import panamagl.Animator;
import panamagl.GLEventAdapter;
import panamagl.canvas.GLCanvasSwing;
import panamagl.factory.PanamaGLFactory;
import panamagl.opengl.GL;
import panamagl.opengl.GLError;

/**
 * VM ARGS : --enable-native-access=ALL-UNNAMED --enable-preview
 * -Djava.library.path=.:/System/Library/Frameworks/OpenGL.framework/Versions/Current/Libraries/
 * 
 * or
 * -Djava.library.path=.:/usr/lib/x86_64-linux-gnu/
 * 
 * or 
 * -Djava.library.path="C:\Windows\system32;C:\Users\Martin\Downloads\freeglut-MSVC-3.0.0-2.mp\freeglut\bin\x64"
 * 
 * @author Martin Pernollet
 *
 */
public class DemoDots_Onscreen_Swing {

  public static void main(String[] args) throws Exception {
    System.out
        .println("SwingUtilities.isEventDispatchThread: " + SwingUtilities.isEventDispatchThread());

    // This is the GL Scene to render
    GLEventAdapter listener = Dots();

    // Using a panel to ensure that GL get initialized in the main AWT thread.
    PanamaGLFactory factory = PanamaGLFactory.select();
    GLCanvasSwing panel = new GLCanvasSwing(factory);
    panel.setGLEventListener(listener);

    // Create frame
    final JFrame frame = new JFrame(DemoDots_Onscreen_Swing.class.getSimpleName());
    frame.getContentPane().setLayout(new BorderLayout());
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

    Animator a = new Animator(panel);
    a.start();
  }

  /** Draw a fullcanvas triangle. */
  public static GLEventAdapter Dots() {
    return new GLEventAdapter() {
      private float rotateT = 0.0f;

      public void init(GL gl) {
        gl.glShadeModel(GL.GL_SMOOTH);
        gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        gl.glClearDepth(1.0f);
        gl.glEnable(GL.GL_DEPTH_TEST);
        gl.glDepthFunc(GL.GL_LEQUAL);
      }

      public void reshape(GL gl, int x, int y, int width, int height) {

        final float aspect = (float) width / (float) height;
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
        final float fh = 0.25f;
        final float fw = fh * aspect;
        gl.glFrustum(-fw, fw, -fh, fh, 1.0f, 1000.0f);

        gl.glViewport(x, y, width, height);

        gl.glMatrixMode(GL.GL_MODELVIEW);
        gl.glLoadIdentity();

      }

      public void display(final GL gl) {
        gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        gl.glClearDepth(1.0f);

        gl.glClear(GL.GL_COLOR_BUFFER_BIT);
        gl.glClear(GL.GL_DEPTH_BUFFER_BIT);
        gl.glLoadIdentity();
        gl.glTranslatef(0.0f, 0.0f, -5.0f);

        // rotate about the three axes
        gl.glRotatef(rotateT, 1.0f, 0.0f, 0.0f);
        gl.glRotatef(rotateT, 0.0f, 1.0f, 0.0f);
        gl.glRotatef(rotateT, 0.0f, 0.0f, 1.0f);

        // Draw dots
        gl.glBegin(GL.GL_POINTS);
        gl.glColor3f(0.0f, 1.0f, 1.0f); // set the color of the quad
        
        float step = 0.1f;
        for (float i = -1; i <= 1; i+=step) {
          for (float j = -1; j <= 1; j+=step) {
            float z = i*j;
            gl.glVertex3f(i, j, z); 
          }
        }        
        gl.glEnd();
        
        GLError.checkAndThrow(gl);
        
        // increasing rotation for the next iteration
        rotateT += 0.4f;
      }
    };
  }

}
