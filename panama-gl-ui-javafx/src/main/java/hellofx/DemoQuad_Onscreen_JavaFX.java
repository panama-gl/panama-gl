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
package hellofx;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import panamagl.Animator;
import panamagl.GLEventAdapter;
import panamagl.canvas.GLCanvasJavaFX;
import panamagl.factory.PanamaGLFactory;
import panamagl.opengl.GL;

// --module-path "C:\Program Files\Java\javafx-sdk-17.0.6\lib" --add-modules javafx.controls
// --add-exports=java.desktop/sun.awt=ALL-UNNAMED
public class DemoQuad_Onscreen_JavaFX extends Application {

  public void start(Stage stage) {

    PanamaGLFactory factory = PanamaGLFactory.select();

    ImageView imageView = new ImageView();

    VBox root = new VBox(30, imageView);
    root.setAlignment(Pos.CENTER);

    Scene scene = new Scene(root, 640, 480);
    scene.getStylesheets()
        .add(DemoQuad_Onscreen_JavaFX.class.getResource("styles.css").toExternalForm());

    stage.setScene(scene);
    stage.show();


    GLCanvasJavaFX canvas = new GLCanvasJavaFX(factory, imageView, scene);
    canvas.setGLEventListener(Quad());

    Animator anim = new Animator(canvas);
    anim.start();

    System.out.println("started");
    
    /*Exception in thread "AWT-EventQueue-0" java.lang.OutOfMemoryError: Java heap space
    at java.base/jdk.internal.foreign.AbstractMemorySegmentImpl.lambda$toArray$3(AbstractMemorySegmentImpl.java:317)
    at java.base/jdk.internal.foreign.AbstractMemorySegmentImpl$$Lambda$306/0x000000080119e718.apply(Unknown Source)
    at java.base/jdk.internal.foreign.AbstractMemorySegmentImpl.toArray(AbstractMemorySegmentImpl.java:337)
    at java.base/jdk.internal.foreign.AbstractMemorySegmentImpl.toArray(AbstractMemorySegmentImpl.java:317)
    at panamagl.utils.AWTImageCopy.fromBGRABufferToImageArray(AWTImageCopy.java:35)
    at panamagl.offscreen.FBOReader_AWT.read(FBOReader_AWT.java:38)
    at panamagl.offscreen.FBOReader_JFX.read(FBOReader_JFX.java:17)
    at panamagl.offscreen.AOffscreenRenderer.renderGLToImage(AOffscreenRenderer.java:207)*/
  }


  public static void main(String[] args) {
    launch(args);
  }


  public static GLEventAdapter Quad() {
    return new GLEventAdapter() {
      private float rotateT = 0.0f;

      public void init(GL gl) {
        gl.glShadeModel(GL.GL_SMOOTH);
        gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        gl.glClearDepth(1.0f);
        gl.glEnable(GL.GL_DEPTH_TEST);
        gl.glDepthFunc(GL.GL_LEQUAL);
        // gl.glHint(gl.GL_PERSPECTIVE_CORRECTION_HINT(), gl.GL_NICEST());

        // GLError.checkAndThrow(gl);
      }

      public void reshape(GL gl, int x, int y, int width, int height) {

        final float aspect = (float) width / (float) height;
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
        final float fh = 0.5f;
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

        // Draw A Quad
        gl.glBegin(GL.GL_QUADS);
        gl.glColor3f(0.0f, 1.0f, 1.0f); // set the color of the quad
        gl.glVertex3f(-1.0f, 1.0f, 0.0f); // Top Left
        gl.glVertex3f(1.0f, 1.0f, 0.0f); // Top Right
        gl.glVertex3f(1.0f, -1.0f, 0.0f); // Bottom Right
        gl.glVertex3f(-1.0f, -1.0f, 0.0f); // Bottom Left
        // Done Drawing The Quad
        gl.glEnd();

        // increasing rotation for the next iteration
        rotateT += 0.2f;

        // gl.glFlush();
      }
    };
  }
}
