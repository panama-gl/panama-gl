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
package demos.panamagl.swt;

import java.awt.BorderLayout;
import java.lang.foreign.Arena;
import java.lang.foreign.ValueLayout;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import panamagl.Animator;
import panamagl.GLEventAdapter;
import panamagl.canvas.GLCanvasSwing;
import panamagl.canvas.swt.GLCanvasSWT;
import panamagl.factory.PanamaGLFactory;
import panamagl.opengl.GL;
import panamagl.opengl.GLError;

/**
 * VM ARGS : --enable-native-access=ALL-UNNAMED 
 * 
 * -Djava.library.path=.:/System/Library/Frameworks/OpenGL.framework/Versions/Current/Libraries/
 * 
 * or
 * -Djava.library.path=.:/usr/lib/x86_64-linux-gnu/
 * 
 * or
 * -Djava.library.path="C:\Windows\system32;C:\Users\Martin\Downloads\freeglut-MSVC-3.0.0-2.mp\freeglut\bin\x64"
 * 
 * @author Martin Pernollet
 */
public class DemoSWTTeapot {

  public static void main(String[] args) throws Exception {
    System.out
        .println("SwingUtilities.isEventDispatchThread: " + SwingUtilities.isEventDispatchThread());

    // This is the GL Scene to render
    GLEventAdapter listener = TeapotGLEventListener();
    
    
    PanamaGLFactory factory = PanamaGLFactory.select();
    System.out.println("Factory selected: "+factory);
    
    
    final Display display = new Display();
    Shell shell = new Shell(display);
    shell.setText("SWT GL");
    shell.setLayout(new FillLayout());
    GLCanvasSWT canvas = new GLCanvasSWT(shell, SWT.NONE, factory);
    canvas.setGLEventListener(listener);

    display.asyncExec(new Runnable() {
        @Override
        public void run() {
            canvas.display();
            display.asyncExec(this);
        }
    });
    shell.setSize(640, 480);
    shell.open();
    
    while(!shell.isDisposed()) {
        if(!display.readAndDispatch()) {
            display.sleep();
        }
    }
    display.dispose();

    
    // Start animating
    //Animator a = new Animator(panel);
    //a.start();
  }

  public static GLEventAdapter TeapotGLEventListener() {
    return new GLEventAdapter() {

      public void init(GL gl) {
        Arena arena = Arena.ofConfined();

        // Reset Background
        gl.glClearColor(1f, 1f, 1f, 1f);

        // Setup Lighting
        gl.glShadeModel(GL.GL_SMOOTH);
        
        var pos = arena.allocateFrom(ValueLayout.JAVA_FLOAT, new float[] {0.0f, 15.0f, -15.0f, 0});
        gl.glLightfv(GL.GL_LIGHT0, GL.GL_POSITION, pos);
        
        var spec = arena.allocateFrom(ValueLayout.JAVA_FLOAT, new float[] {1, 1, 1, 0});
        gl.glLightfv(GL.GL_LIGHT0, GL.GL_AMBIENT, spec);
        gl.glLightfv(GL.GL_LIGHT0, GL.GL_DIFFUSE, spec);
        gl.glLightfv(GL.GL_LIGHT0, GL.GL_SPECULAR, spec);
        
        var shini = arena.allocateFrom(ValueLayout.JAVA_FLOAT, 113);
        gl.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, shini);
        gl.glEnable(GL.GL_LIGHTING);
        gl.glEnable(GL.GL_LIGHT0);
        gl.glEnable(GL.GL_DEPTH_TEST);

        GLError.checkAndThrow(gl);
      }

      public void display(GL gl) {
        // Reset Background
        gl.glClearColor(1f, 1f, 1f, 1f);
        gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);

        gl.glPushMatrix();
        gl.glRotatef(-20f, 1f, 1f, 0f);
        gl.glRotatef(rot, 0f, 1f, 0f);
        gl.glColor3f(0.2f, 0.2f, 1f);
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
