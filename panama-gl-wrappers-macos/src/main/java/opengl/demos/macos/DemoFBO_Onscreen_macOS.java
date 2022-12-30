package opengl.demos.macos;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import opengl.GL;
import opengl.demos.SampleTriangle;
import panamagl.GLEventAdapter;
import panamagl.GLPanel;

/**
 * VM ARGS : -XstartOnFirstThread --enable-native-access=ALL-UNNAMED --add-modules jdk.incubator.foreign -Djava.library.path=.:/System/Library/Frameworks/OpenGL.framework/Versions/Current/Libraries/
 * 
 * OpenGL on macOS requires to run on main thread, hence the need for -XstartOnFirstThread
 * 
 * BUT Swing and JFX seamingly freeze when started on main thread.
 * 
 * @author Martin
 *
 */
public class DemoFBO_Onscreen_macOS {

  public static void main(String[] args) throws Exception {
    SwingUtilities.invokeLater(new Runnable() {
      @Override
      public void run() {
        doDemo();        
      }
    });
    
    //doDemo();

  }
  
  public static void doDemo() {
    
    System.out.println("SwingUtilities.isEventDispatchThread: " + SwingUtilities.isEventDispatchThread());
    
    GLEventAdapter listener = new GLEventAdapter() {
      public void display(GL gl) {
        SampleTriangle.rgbaTriangle2D(w, h);
        //System.out.println("GLEventAdapter : Triangle rendered!");
      }
      @Override
      public void reshape(GL gl, int x, int y, int width, int height) {
        w = width;
        h = height;
        //super.reshape(gl, x, y, width, height);
      }
      int w=800;
      int h=600;
    };

    // Using a panel to ensure that GL get initialized in the main AWT thread.
    GLPanel panel = new GLPanel();
    panel.setGLEventListener(listener);
    
    // Create frame
    final JFrame frame = new JFrame("Rendering offscreen with Panama GL");
    frame.getContentPane().setLayout(new BorderLayout());
    //frame.pack();
    frame.setBounds(0, 0, 800, 600);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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
}
