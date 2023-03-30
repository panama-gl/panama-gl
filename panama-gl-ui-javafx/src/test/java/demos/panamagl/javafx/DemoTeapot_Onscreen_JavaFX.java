/**
 * Copyright (c) 2019, 2023 Gluon All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification, are permitted
 * provided that the following conditions are met: * Redistributions of source code must retain the
 * above copyright notice, this list of conditions and the following disclaimer. * Redistributions
 * in binary form must reproduce the above copyright notice, this list of conditions and the
 * following disclaimer in the documentation and/or other materials provided with the distribution.
 * * Neither the name of Gluon, any associated website, nor the names of its contributors may be
 * used to endorse or promote products derived from this software without specific prior written
 * permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR
 * IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
 * FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL GLUON BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR
 * BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT
 * LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package demos.panamagl.javafx;

import java.lang.foreign.MemorySession;
import java.lang.foreign.SegmentAllocator;
import java.lang.foreign.ValueLayout;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import panamagl.Animator;
import panamagl.GLEventAdapter;
import panamagl.canvas.GLCanvasJFX;
import panamagl.canvas.ResizableCanvas;
import panamagl.factory.PanamaGLFactory;
import panamagl.factory.PanamaGLFactory_macOS_JFX;
import panamagl.opengl.GL;
import panamagl.opengl.GLError;

/**
 * TODO
 * 
 * - All FBO must keep spare readPixel buffer usage like on windows
 * 
 * - macOS OffscreenRenderer should use a ThreadRedirect implementation
 * 
 * - Provide a CanvasFactory or ToolkitFactory to init ThreadRedirect, Canvas and Image. Rename
 * PanamaGLFactory to OpenGLFactory, then provide ToolkitFactory to OpenGLFactory.
 * 
 * - animator sleepTime is not considered!!
 * 
 * - JavaFX isRendering is not properly working
 * 
 * - Verifier que le resize marche encore sur Swing et macOS/linux. AOffscreenRenderer doit soit ne pas utiliser la taille du drawable, soit dégager les arguments
 * 
 * - Trouver une bonne manière de connaître la taille du canvas sans faire appel à la scene!! ET CORRIGER 
 * 
 * - Trouver la propriété pour permettre au canvas de grandir dans la scene
 * 
 * - Pourquoi ça saute quand on resize? Conflit de rendu car le flag isRendering n'est en réalité pas effectif?
 * 
 * - https://stackoverflow.com/questions/24533556/how-to-make-canvas-resizable-in-javafx
 * 
 * @author Martin
 *
 */
//--module-path "/Library/Java/JavaVirtualMachines/javafx-sdk-19.0.2.1/lib" --add-modules javafx.controls --add-exports=java.desktop/sun.awt=ALL-UNNAMED
// --module-path "C:\Program Files\Java\javafx-sdk-17.0.6\lib" --add-modules javafx.controls --add-exports=java.desktop/sun.awt=ALL-UNNAMED
public class DemoTeapot_Onscreen_JavaFX extends Application {

  public void start(Stage stage) {




    Canvas canvas = new ResizableCanvas();
    canvas.setWidth(600);
    canvas.setHeight(500);
    
    //canvas.setResi

    VBox vbox = new VBox(canvas);
    vbox.setFillWidth(true);
    
    Scene scene = new Scene(vbox);
    
    stage.setScene(scene);
    stage.setResizable(true);
    
    stage.show();

    // MUST BE INIT AFTER UI POPS
    
    // PanamaGLFactory factory = PanamaGLFactory.select();

    //PanamaGLFactory factory = new PanamaGLFactory_windows_JFX();
    PanamaGLFactory factory = new PanamaGLFactory_macOS_JFX();

    GLCanvasJFX glcanvas = new GLCanvasJFX(factory, canvas);
    glcanvas.setGLEventListener(Teapot());

    Animator anim = new Animator(glcanvas);
    //anim.setSleepTime(1000);
    anim.start();

    System.out.println("started");
  }


  public static void main(String[] args) {
    launch(args);
  }


  public static GLEventAdapter Teapot() {
    return new GLEventAdapter() {

      public void init(GL gl) {
        // The segments created in this function will be destroyed
        // one the below scope and allocator are collected by GC.
        MemorySession scope = MemorySession.openConfined();
        SegmentAllocator allocator = SegmentAllocator.newNativeArena(scope);

        // Reset Background
        gl.glClearColor(1f, 1f, 1f, 1f);

        // Setup Lighting
        gl.glShadeModel(GL.GL_SMOOTH);
        
        var pos = allocator.allocateArray(ValueLayout.JAVA_FLOAT, new float[] {0.0f, 15.0f, -15.0f, 0});
        gl.glLightfv(GL.GL_LIGHT0, GL.GL_POSITION, pos);
        
        var spec = allocator.allocateArray(ValueLayout.JAVA_FLOAT, new float[] {1, 1, 1, 0});
        gl.glLightfv(GL.GL_LIGHT0, GL.GL_AMBIENT, spec);
        gl.glLightfv(GL.GL_LIGHT0, GL.GL_DIFFUSE, spec);
        gl.glLightfv(GL.GL_LIGHT0, GL.GL_SPECULAR, spec);
        
        var shini = allocator.allocate(ValueLayout.JAVA_FLOAT, 113);
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
