
package demos.panamagl.javafx;

import java.lang.foreign.MemorySession;
import java.lang.foreign.SegmentAllocator;
import java.lang.foreign.ValueLayout;
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
import panamagl.opengl.GLError;


// --module-path "/Library/Java/JavaVirtualMachines/javafx-sdk-19.0.2.1/lib" --add-modules javafx.controls --add-exports=java.desktop/sun.awt=ALL-UNNAMED
// --module-path "C:\Program Files\Java\javafx-sdk-17.0.6\lib" --add-modules javafx.controls
// --add-exports=java.desktop/sun.awt=ALL-UNNAMED
//--module-path "/usr/lib/jvm/javafx-sdk-20/lib" --add-modules javafx.controls --add-exports=java.desktop/sun.awt=ALL-UNNAMED

public class DemoTeapot_Onscreen_JavaFX extends Application {

  PanamaGLFactory factory;
  GLCanvasJFX glcanvas;
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


    // -------------------------------------------------
    // MUST BE INIT AFTER UI POPS

    PanamaGLFactory factory = PanamaGLFactory.select();

    glcanvas = new GLCanvasJFX(factory, canvas);
    glcanvas.setGLEventListener(Teapot());

    anim = new Animator(glcanvas);
    anim.start();
    // anim.setSleepTime(1000);

    System.out.println("started");
  }
  
  private void closeWindowEvent(WindowEvent event) {
    anim.stop();
    Platform.exit();
  }

  @Override
  public void stop(){
    System.out.println("stopped");
    System.exit(0);
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

        var pos =
            allocator.allocateArray(ValueLayout.JAVA_FLOAT, new float[] {0.0f, 15.0f, -15.0f, 0});
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
