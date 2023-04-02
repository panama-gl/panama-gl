package demos.panamagl.javafx;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import panamagl.Animator;
import panamagl.GLEventAdapter;
import panamagl.canvas.GLCanvasJFX;
import panamagl.canvas.ResizableCanvas;
import panamagl.factory.PanamaGLFactory;
import panamagl.opengl.GL;

/**
 * VM ARGS :
 * 
 * MacOS
 * 
 * --module-path "/Library/Java/JavaVirtualMachines/javafx-sdk-19.0.2.1/" --add-modules
 * javafx.controls --add-exports=java.desktop/sun.awt=ALL-UNNAMED
 * 
 * Linux
 * 
 * -Djava.library.path=.:/usr/lib/x86_64-linux-gnu/ --module-path "/usr/lib/jvm/javafx-sdk-20/lib"
 * --add-modules javafx.controls --add-exports=java.desktop/sun.awt=ALL-UNNAMED
 * 
 * Windows
 * 
 * --module-path "C:\Program Files\Java\javafx-sdk-17.0.6\lib" --add-modules javafx.controls
 * --add-exports=java.desktop/sun.awt=ALL-UNNAMED
 * 
 * @author Martin Pernollet
 *
 */

//
// --module-path "C:\Program Files\Java\javafx-sdk-17.0.6\lib" --add-modules javafx.controls
// --add-exports=java.desktop/sun.awt=ALL-UNNAMED
public class DemoQuad_Onscreen_JavaFX extends Application {
  Animator anim;
  
  public void start(Stage stage) {
    Canvas canvas = new ResizableCanvas();
    canvas.setWidth(600);
    canvas.setHeight(500);

    VBox vbox = new VBox(canvas);
    vbox.setFillWidth(true);
    
    for (Node child : vbox.getChildren()) {
      VBox.setVgrow(child, Priority.ALWAYS);
    }
    
    Scene scene = new Scene(vbox);

    stage.setScene(scene);
    stage.setResizable(true);
    stage.show();
    stage.addEventFilter(WindowEvent.WINDOW_CLOSE_REQUEST, this::closeWindowEvent);

    // MUST BE INIT AFTER UI POPS

    PanamaGLFactory factory = PanamaGLFactory.select();

    GLCanvasJFX glcanvas = new GLCanvasJFX(factory, canvas);
    glcanvas.setGLEventListener(Quad());

    anim = new Animator(glcanvas);
    // anim.setSleepTime(1000);
    anim.start();

    System.out.println("started");
  }

  private void closeWindowEvent(WindowEvent event) {
    anim.stop();
    Platform.exit();
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
