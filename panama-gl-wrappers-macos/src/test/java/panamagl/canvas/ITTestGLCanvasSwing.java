package panamagl.canvas;

import java.awt.BorderLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import demos.panamagl.macos.SampleTriangle;
import opengl.GL;
import panamagl.GLEventAdapter;
import panamagl.factory.PanamaGLFactory;
import panamagl.utils.ImageUtils;

/**
 * Not working yet, threading issue. See demofbo_onscreen_macos
 * 
 * 
 * @author Martin
 *
 */
// VM ARGS : --enable-native-access=ALL-UNNAMED --add-modules jdk.incubator.foreign -Djava.library.path=.:/System/Library/Frameworks/OpenGL.framework/Versions/Current/Libraries/

public class ITTestGLCanvasSwing {
  
  BufferedImage screenshotWhenShown = null;
  List<BufferedImage> screenshotWhenResize = new ArrayList<>();

@Ignore("Work in progress")
  @Test
  public void main() throws InterruptedException {
    
    CountDownLatch latch = new CountDownLatch(1);
    
    
    System.out.println("SwingUtilities.isEventDispatchThread: " + SwingUtilities.isEventDispatchThread());
    
    // --------------------------------------------
    // This is the GL Scene to render
    
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

    // --------------------------------------------
    // Using a panel to ensure that GL get initialized in the main AWT thread.
    
    PanamaGLFactory factory = PanamaGLFactory.select();
    GLCanvasSwing panel = factory.newCanvasSwing();

    panel.setGLEventListener(listener);
    
    // --------------------------------------------
    // Assertions and defered assertions
    
    // Expect initial state to be null
    Assert.assertNull(panel.getScreenshot());
    
    // Define a way to get following states
    panel.addComponentListener(new ComponentAdapter() {
      public void componentShown(ComponentEvent e) {
        screenshotWhenShown = panel.getScreenshot();
        System.err.println("GOT SCREENSHOT! SHOWN");
      }
      
      int k = 0;
      public void componentResized(ComponentEvent e) {
        BufferedImage i = panel.getScreenshot();
        
        if(i!=null) {
          ImageUtils.save(i, "target/TestGLPanel-"+(k++)+".png");
          screenshotWhenResize.add(i);
          System.err.println("GOT SCREENSHOT! RESIZED");
        }
        else {
          Assert.fail("expected a non null image");
        }

      }
    });
    
    // --------------------------------------------
    // Create and open a test frame
    
    final JFrame frame = new JFrame("Rendering offscreen with Panama GL");
    frame.getContentPane().setLayout(new BorderLayout());
    //frame.pack();
    frame.setBounds(0, 0, 800, 600);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    // Use this to avoid Swing hangs to open frame
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
        frame.repaint();
        System.out.println("-----------------------------");
        System.out.println("AFTER Frame.setVisible(true)");
        System.out.println("-----------------------------");
        

        // --------------------------------
        // Test scenario
        
        // Let the window open for a while
        //sleep(1000);
        
        //frame.repaint();
        //sleep(1000);
        frame.setSize(400, 400);
        sleep(1000);
        frame.setSize(600, 600);
        sleep(1000);
        

        sleep(2000);
        latch.countDown();
      
      }

    });
    
    latch.await(6, TimeUnit.SECONDS);
    System.err.println("UNDERSTAND WHY RESIZE EVENT APPEAR AFTER THIS  :(");
    
    //Assert.assertNotNull(screenshotWhenShown);  
    //Assert.assertEquals(1, screenshotWhenResize.size());  

  }

  protected void sleep(int mili) {
    try {
      Thread.sleep(mili);
    } catch (InterruptedException e1) {
      e1.printStackTrace();
    }
  }

  
  public static void doDemo() {
    
    System.out.println("SwingUtilities.isEventDispatchThread: " + SwingUtilities.isEventDispatchThread());
    
    // This is the GL Scene to render
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
    PanamaGLFactory factory = PanamaGLFactory.select();
    GLCanvasSwing panel = factory.newCanvasSwing();

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
