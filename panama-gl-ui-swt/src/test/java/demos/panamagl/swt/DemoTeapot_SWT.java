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

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import opengl.macos.NativeLibLoader;
import panamagl.GLEventAdapter;
import panamagl.canvas.swt.GLCanvasSWT;
import panamagl.factory.PanamaGLFactory;

/**
 * Demonstrates the offscreen-rendering SWT canvas ({@link GLCanvasSWT}).
 *
 * Unlike {@link DemoSWTTeapot_direct} which uses the native SWT {@code GLCanvas} with
 * {@code setCurrent()/swapBuffers()}, this demo uses the FBO offscreen pipeline
 * shared with the Swing and JavaFX canvases. The GL scene is rendered into an FBO,
 * read back as an {@code ImageData}, and painted onto a plain SWT {@code Canvas}.
 *
 * VM ARGS : --enable-native-access=ALL-UNNAMED
 *
 * -Djava.library.path=.:/System/Library/Frameworks/OpenGL.framework/Versions/Current/Libraries/
 *
 * or
 * -Djava.library.path=.:/usr/lib/x86_64-linux-gnu/
 *
 * @author Martin Pernollet
 */
public class DemoTeapot_SWT {

  public static void main(String[] args) throws Exception {
    // Load GLUT native lib (required for glutSolidTeapot)
    NativeLibLoader.load();

    // Reuse the same teapot GL scene as the onscreen demo
    GLEventAdapter listener = DemoSWTTeapot_direct.TeapotGLEventListener();

    // Select the appropriate factory for the current platform
    PanamaGLFactory factory = PanamaGLFactory.select();
    //System.out.println("Factory selected: " + factory);

    // Create SWT display and shell
    final Display display = new Display();
    Shell shell = new Shell(display);
    shell.setText("SWT GL (Offscreen)");
    shell.setLayout(new FillLayout());

    // Create the offscreen canvas — this is the key difference:
    // GLCanvasSWT_Offscreen extends plain Canvas (not SWT GLCanvas),
    // and renders via FBO + pixel readback instead of a native GL surface.
    GLCanvasSWT canvas = new GLCanvasSWT(shell, SWT.NONE, factory);

    // Attach the GL scene
    // this triggers offscreen renderer initialization - TODO : think twice
    canvas.setGLEventListener(listener);

    shell.setSize(640, 480);
    shell.open();

    // Animation loop: schedule continuous redraw via the SWT event queue
    display.asyncExec(new Runnable() {
      @Override
      public void run() {
        if (!canvas.isDisposed()) {
          canvas.display();
          display.asyncExec(this);
        }
      }
    });

    // Standard SWT event loop
    while (!shell.isDisposed()) {
      if (!display.readAndDispatch()) {
        display.sleep();
      }
    }
    display.dispose();
  }
}
