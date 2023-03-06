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
package demos.panamagl.awt;

//import static jdk.incubator.foreign.CLinker.C_FLOAT;
import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.lang.foreign.MemorySession;
import java.lang.foreign.SegmentAllocator;
import javax.swing.SwingUtilities;
import opengl.macos.x86.glut_h;
import panamagl.Animator;
import panamagl.GLEventAdapter;
import panamagl.canvas.GLCanvasAWT;
import panamagl.factory.PanamaGLFactory;
import panamagl.opengl.GL;
import panamagl.opengl.GLError;
import panamagl.platform.macos.x86.PanamaGLFactory_macOS_x86;

/**
 * VM ARGS : --enable-native-access=ALL-UNNAMED --add-modules jdk.incubator.foreign
 * -Djava.library.path=.:/System/Library/Frameworks/OpenGL.framework/Versions/Current/Libraries/
 * 
 * @author Martin
 *
 */
public class DemoTeapot_Onscreen_AWT {

  public static void main(String[] args) throws Exception {
    System.out
        .println("SwingUtilities.isEventDispatchThread: " + SwingUtilities.isEventDispatchThread());

    // This is the GL Scene to render
    GLEventAdapter listener = TeapotGLEventListener();

    // Using a panel to ensure that GL get initialized in the main AWT thread.
    PanamaGLFactory factory = new PanamaGLFactory_macOS_x86();
    GLCanvasAWT panel = new GLCanvasAWT(factory);
    panel.setGLEventListener(listener);

    // Create frame
    final Frame frame = new Frame(DemoTeapot_Onscreen_AWT.class.getSimpleName());
    frame.setLayout(new BorderLayout());
    frame.setBounds(0, 0, 800, 600);
    frame.addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        frame.dispose();
        System.exit(0);
      }
    });

    // Init action
    Runnable show = new Runnable() {
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
        frame.setBounds(0, 0, 800, 700);

      }
    };
    
    
    // Use this to avoid Swing hangs
    SwingUtilities.invokeLater(show);
    //show.run();
    
    // Start animating
    Animator a = new Animator(panel);
    a.start();
  }

  public static GLEventAdapter TeapotGLEventListener() {
    return new GLEventAdapter() {

      public void init(GL gl) {
        MemorySession scope = MemorySession.openConfined();
        SegmentAllocator allocator = SegmentAllocator.newNativeArena(scope);
        
        // Reset Background
        gl.glClearColor(0f, 0f, 0f, 1f);

        // Setup Lighting
        gl.glShadeModel(GL.GL_SMOOTH);
        
        var pos = allocator.allocateArray(glut_h.C_FLOAT, new float[] {0.0f, 15.0f, -15.0f, 0});
        gl.glLightfv(GL.GL_LIGHT0, GL.GL_POSITION, pos);
        
        var spec = allocator.allocateArray(glut_h.C_FLOAT, new float[] {1, 1, 1, 0});
        gl.glLightfv(GL.GL_LIGHT0, GL.GL_AMBIENT, spec);
        gl.glLightfv(GL.GL_LIGHT0, GL.GL_DIFFUSE, spec);
        gl.glLightfv(GL.GL_LIGHT0, GL.GL_SPECULAR, spec);
        
        var shini = allocator.allocate(glut_h.C_FLOAT, 113);
        gl.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, shini);
        gl.glEnable(GL.GL_LIGHTING);
        gl.glEnable(GL.GL_LIGHT0);
        gl.glEnable(GL.GL_DEPTH_TEST);

        GLError.checkAndThrow(gl);
      }

      public void display(GL gl) {
        gl.glClearColor(0f, 0f, 0f, 1f);

        gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
        gl.glPushMatrix();
        gl.glRotatef(-20f, 1f, 1f, 0f);
        gl.glRotatef(rot, 0f, 1f, 0f);
        gl.glutSolidTeapot(0.5d);
        gl.glPopMatrix();

        rot += 0.45;

        GLError.checkAndThrow(gl);
      }

      protected float rot = 0;

      @Override
      public void reshape(GL gl, int x, int y, int width, int height) {
        gl.glViewport(x, y, width, height);
      }
    };
  }

}
