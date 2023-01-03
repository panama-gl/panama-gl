package opengl.demos.macos;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import opengl.GL;
import opengl.macos.v10_15_3.glut_h;
import panamagl.Animator;
import panamagl.GLEventAdapter;
import panamagl.GLPanel;

/**
 * VM ARGS : --enable-native-access=ALL-UNNAMED --add-modules jdk.incubator.foreign
 * -Djava.library.path=.:/System/Library/Frameworks/OpenGL.framework/Versions/Current/Libraries/
 * 
 * @author Martin
 *
 */
public class DemoRotatingStuff_Onscreen_macOS {

  public static void main(String[] args) throws Exception {
    System.out
        .println("SwingUtilities.isEventDispatchThread: " + SwingUtilities.isEventDispatchThread());

    // This is the GL Scene to render
    GLEventAdapter listener = RotatingStuff();

    // Using a panel to ensure that GL get initialized in the main AWT thread.
    GLPanel panel = new GLPanel();
    panel.setGLEventListener(listener);

    // Create frame
    final JFrame frame = new JFrame(DemoRotatingStuff_Onscreen_macOS.class.getSimpleName());
    frame.getContentPane().setLayout(new BorderLayout());
    // frame.pack();
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

    // Thread.sleep(5000);
    // System.out.println("Start loop");

    Animator a = new Animator(panel);
    // a.setSleepTime(30);
    a.start();
  }

  /** Draw a fullcanvas triangle. */
  public static GLEventAdapter RotatingStuff() {
    return new GLEventAdapter() {
      private float rotateT = 0.0f;

      public void init(GL gl) {
        glut_h.glShadeModel(glut_h.GL_SMOOTH());
        glut_h.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        glut_h.glClearDepth(1.0f);
        glut_h.glEnable(glut_h.GL_DEPTH_TEST());
        glut_h.glDepthFunc(glut_h.GL_LEQUAL());
        glut_h.glHint(glut_h.GL_PERSPECTIVE_CORRECTION_HINT(), glut_h.GL_NICEST());

        // GLError.checkAndThrow(gl);
      }

      public void reshape(GL gl, int x, int y, int width, int height) {

        final float aspect = (float) width / (float) height;
        glut_h.glMatrixMode(glut_h.GL_PROJECTION());
        glut_h.glLoadIdentity();
        final float fh = 0.5f;
        final float fw = fh * aspect;
        glut_h.glFrustum(-fw, fw, -fh, fh, 1.0f, 1000.0f);

        glut_h.glViewport(x, y, width, height);

        glut_h.glMatrixMode(glut_h.GL_MODELVIEW());
        glut_h.glLoadIdentity();

      }

      public void display(final GL gl) {
        glut_h.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        glut_h.glClearDepth(1.0f);


        glut_h.glClear(glut_h.GL_COLOR_BUFFER_BIT());
        glut_h.glClear(glut_h.GL_DEPTH_BUFFER_BIT());
        glut_h.glLoadIdentity();
        glut_h.glTranslatef(0.0f, 0.0f, -5.0f);

        // rotate about the three axes
        glut_h.glRotatef(rotateT, 1.0f, 0.0f, 0.0f);
        glut_h.glRotatef(rotateT, 0.0f, 1.0f, 0.0f);
        glut_h.glRotatef(rotateT, 0.0f, 0.0f, 1.0f);

        // Draw A Quad
        glut_h.glBegin(glut_h.GL_QUADS());
        glut_h.glColor3f(0.0f, 1.0f, 1.0f); // set the color of the quad
        glut_h.glVertex3f(-1.0f, 1.0f, 0.0f); // Top Left
        glut_h.glVertex3f(1.0f, 1.0f, 0.0f); // Top Right
        glut_h.glVertex3f(1.0f, -1.0f, 0.0f); // Bottom Right
        glut_h.glVertex3f(-1.0f, -1.0f, 0.0f); // Bottom Left
        // Done Drawing The Quad
        glut_h.glEnd();

        // increasing rotation for the next iteration
        rotateT += 0.2f;

        // glut_h.glFlush();
      }
    };
  }

}
