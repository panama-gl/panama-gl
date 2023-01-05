package demos.panamagl.macos.swing;

import static jdk.incubator.foreign.CLinker.C_FLOAT;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import jdk.incubator.foreign.ResourceScope;
import jdk.incubator.foreign.SegmentAllocator;

import opengl.GL;
import opengl.GLError;
import panamagl.GLEventAdapter;
import panamagl.toolkits.swing.GLCanvasSwing;
import panamagl.Animator;

/**
 * VM ARGS : --enable-native-access=ALL-UNNAMED --add-modules jdk.incubator.foreign
 * -Djava.library.path=.:/System/Library/Frameworks/OpenGL.framework/Versions/Current/Libraries/
 * 
 * @author Martin
 *
 */
public class DemoTeapot_Onscreen_macOS {

  public static void main(String[] args) throws Exception {
    System.out
        .println("SwingUtilities.isEventDispatchThread: " + SwingUtilities.isEventDispatchThread());

    // This is the GL Scene to render
    GLEventAdapter listener = TeapotGLEventListener();

    // Using a panel to ensure that GL get initialized in the main AWT thread.
    GLCanvasSwing panel = new GLCanvasSwing();
    panel.setGLEventListener(listener);

    // Create frame
    final JFrame frame = new JFrame(DemoTeapot_Onscreen_macOS.class.getSimpleName());
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

        frame.setBounds(0, 0, 800, 700);

      }
    });

    // Start animating
    Animator a = new Animator(panel);
    a.start();
  }

  public static GLEventAdapter TeapotGLEventListener() {
    return new GLEventAdapter() {

      public void init(GL gl) {
        ResourceScope scope = ResourceScope.newConfinedScope();
        SegmentAllocator allocator = SegmentAllocator.ofScope(scope);

        // Reset Background
        gl.glClearColor(0f, 0f, 0f, 1f);

        // Setup Lighting
        gl.glShadeModel(gl.GL_SMOOTH());
        
        var pos = allocator.allocateArray(C_FLOAT, new float[] {0.0f, 15.0f, -15.0f, 0});
        gl.glLightfv(gl.GL_LIGHT0(), gl.GL_POSITION(), pos);
        
        var spec = allocator.allocateArray(C_FLOAT, new float[] {1, 1, 1, 0});
        gl.glLightfv(gl.GL_LIGHT0(), gl.GL_AMBIENT(), spec);
        gl.glLightfv(gl.GL_LIGHT0(), gl.GL_DIFFUSE(), spec);
        gl.glLightfv(gl.GL_LIGHT0(), gl.GL_SPECULAR(), spec);
        
        var shini = allocator.allocate(C_FLOAT, 113);
        gl.glMaterialfv(gl.GL_FRONT(), gl.GL_SHININESS(), shini);
        gl.glEnable(gl.GL_LIGHTING());
        gl.glEnable(gl.GL_LIGHT0());
        gl.glEnable(gl.GL_DEPTH_TEST());

        GLError.checkAndThrow(gl);
      }

      public void display(GL gl) {
        gl.glClearColor(0f, 0f, 0f, 1f);

        gl.glClear(gl.GL_COLOR_BUFFER_BIT() | gl.GL_DEPTH_BUFFER_BIT());
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
