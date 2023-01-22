package demos.panamagl.macos.swing;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import opengl.GL;
import panamagl.Animator;
import panamagl.GLEventAdapter;
import panamagl.canvas.swing.GLCanvasSwing;
import panamagl.factory.AbstractPanamaGLFactory;
import panamagl.macos.PanamaGLMacOSFactory;

/**
 * VM ARGS : --enable-native-access=ALL-UNNAMED --enable-preview
 * -Djava.library.path=.:/System/Library/Frameworks/OpenGL.framework/Versions/Current/Libraries/
 * 
 * @author Martin
 *
 */
public class DemoRotatingQuad_Onscreen_macOS_Swing {

  public static void main(String[] args) throws Exception {
    System.out
        .println("SwingUtilities.isEventDispatchThread: " + SwingUtilities.isEventDispatchThread());

    // This is the GL Scene to render
    GLEventAdapter listener = RotatingStuff();

    // Using a panel to ensure that GL get initialized in the main AWT thread.
    AbstractPanamaGLFactory factory = new PanamaGLMacOSFactory();
    GLCanvasSwing panel = (GLCanvasSwing)factory.newCanvas(GLCanvasSwing.class);
    panel.setGLEventListener(listener);

    // Create frame
    final JFrame frame = new JFrame(DemoRotatingQuad_Onscreen_macOS_Swing.class.getSimpleName());
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
  public static GLEventAdapter RotatingStuff() {
    return new GLEventAdapter() {
      private float rotateT = 0.0f;

      public void init(GL gl) {
        gl.glShadeModel(gl.GL_SMOOTH());
        gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        gl.glClearDepth(1.0f);
        gl.glEnable(gl.GL_DEPTH_TEST());
        gl.glDepthFunc(gl.GL_LEQUAL());
        gl.glHint(gl.GL_PERSPECTIVE_CORRECTION_HINT(), gl.GL_NICEST());

        // GLError.checkAndThrow(gl);
      }

      public void reshape(GL gl, int x, int y, int width, int height) {

        final float aspect = (float) width / (float) height;
        gl.glMatrixMode(gl.GL_PROJECTION());
        gl.glLoadIdentity();
        final float fh = 0.5f;
        final float fw = fh * aspect;
        gl.glFrustum(-fw, fw, -fh, fh, 1.0f, 1000.0f);

        gl.glViewport(x, y, width, height);

        gl.glMatrixMode(gl.GL_MODELVIEW());
        gl.glLoadIdentity();

      }

      public void display(final GL gl) {
        gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        gl.glClearDepth(1.0f);


        gl.glClear(gl.GL_COLOR_BUFFER_BIT());
        gl.glClear(gl.GL_DEPTH_BUFFER_BIT());
        gl.glLoadIdentity();
        gl.glTranslatef(0.0f, 0.0f, -5.0f);

        // rotate about the three axes
        gl.glRotatef(rotateT, 1.0f, 0.0f, 0.0f);
        gl.glRotatef(rotateT, 0.0f, 1.0f, 0.0f);
        gl.glRotatef(rotateT, 0.0f, 0.0f, 1.0f);

        // Draw A Quad
        gl.glBegin(gl.GL_QUADS());
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
