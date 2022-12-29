package opengl.demos.macos;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import opengl.GL;
import opengl.demos.SampleTriangle;
import panamagl.GLEventAdapter;
import panamagl.GLPanel;

/**
 * https://github.com/jzy3d/panama-gl/issues/5
 */
// VM ARGS : -XstartOnFirstThread --enable-native-access=ALL-UNNAMED --add-modules
// jdk.incubator.foreign
// -Djava.library.path=.:/System/Library/Frameworks/OpenGL.framework/Versions/Current/Libraries/
// VM is FREEZING WITH -XstartOnFirstThread, crashing without
public class DemoFBO_Onscreen_macOS {

  public static void main(String[] args) throws Exception {

    // Thread.join();
    // Thread.sleep(1000);

    // -------------------------
    // Render something

    GLEventAdapter listener = new GLEventAdapter() {
      public void display(GL gl) {
        SampleTriangle.rgbaTriangle2D(800, 600);
      }
    };

    // Using a panel to ensure that GL get initialized in the main AWT thread.
    GLPanel panel = new GLPanel();
    panel.setGLEventListener(listener);

    /**
     * There are a few reasons why you might experience a deadlock when using FBO (Framebuffer
     * Object) offscreen rendering and opening a JPanel in a CGL (Core Graphics Library) context.
     * Some possible causes of this issue include:
     * 
     * 1.Concurrent access to the CGL context: If multiple threads or processes are trying to access
     * the CGL context concurrently, it can cause a deadlock. To avoid this, you should use
     * synchronization mechanisms such as mutexes or semaphores to ensure that only one thread or
     * process is accessing the CGL context at a time.
     * 
     * 2.Incomplete initialization: If the CGL context or FBO offscreen rendering is not fully
     * initialized before the JPanel is opened, it can cause a deadlock. Make sure that all
     * necessary initialization steps have been completed before opening the JPanel.
     * 
     * 3.Incorrect use of locking and unlocking: The CGL context must be locked before it can be used
     * for rendering or other graphics operations, and unlocked when the operations are complete. If
     * the CGL context is not properly locked and unlocked, it can cause a deadlock. Make sure that
     * the CGL context is locked and unlocked correctly.
     * 
     * 4.Incorrect rendering order: If you are using multiple rendering contexts or FBOs, it is
     * important to render them in the correct order to avoid deadlocks. Make sure that you are
     * rendering the contexts or FBOs in the correct sequence to avoid deadlocks.
     * 
     * It is difficult to say exactly what is causing a deadlock without more information about your
     * specific situation. If you are experiencing a deadlock when using FBO offscreen rendering and
     * opening a JPanel in a CGL context, you should try to identify the root cause by looking at
     * the code and debugging the issue.
     */

    JFrame frame = new JFrame("Rendering offscreen with Panama GL");
    frame.getContentPane().setLayout(new BorderLayout());
    frame.pack();
    frame.setBounds(0, 0, 800, 600);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    frame.add(panel, BorderLayout.CENTER);
    
    Thread.sleep(1000);
    frame.setVisible(true);


  }
}
