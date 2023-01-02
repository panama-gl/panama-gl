package opengl.demos.macos;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import org.apache.logging.log4j.core.util.ExecutorServices;
import opengl.GL;
import opengl.demos.SampleTriangle;
import panamagl.Animator;
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
public class DemoRGBTriangle_Onscreen_macOS {

  public static void main(String[] args) throws Exception {
    System.out.println("SwingUtilities.isEventDispatchThread: " + SwingUtilities.isEventDispatchThread());
    
    // This is the GL Scene to render
    GLEventAdapter listener = RGBTriangleEventListenerAnim();

    // Using a panel to ensure that GL get initialized in the main AWT thread.
    GLPanel panel = new GLPanel();
    panel.setGLEventListener(listener);
    
    // Create frame
    final JFrame frame = new JFrame(DemoRGBTriangle_Onscreen_macOS.class.getSimpleName());
    frame.getContentPane().setLayout(new BorderLayout());
    //frame.pack();
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
    
    Thread.sleep(5000);
    System.out.println("Start loop");
    
    Animator a = new Animator(panel);
    a.start();
    
    //Thread.sleep(5000);
    //a.stop();

  }

  /** Draw a fullcanvas triangle. */
  public static GLEventAdapter RGBTriangleEventListener() {
    return new GLEventAdapter() {
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
  }

  /** Draw a fullcanvas triangle. Then reduce size then grow size */
  public static GLEventAdapter RGBTriangleEventListenerAnim() {
    return new GLEventAdapter() {
      public void display(GL gl) {
        
        if(h-inc == 10) {
          dir*=-1;
        }
        else if(h-inc == 600) {
          dir*=1;
        }
        inc+=dir;
        
        //System.out.println("w:" + (w-inc) + " h:" + (h-inc));

        SampleTriangle.rgbaTriangle2D(w-inc, h-inc);
      }
      
      @Override
      public void reshape(GL gl, int x, int y, int width, int height) {
        w = width;
        h = height;
        //super.reshape(gl, x, y, width, height);
      }
      int w=800;
      int h=600;
      
      int inc = 0;
      int dir = 1;
    };
  }

}
