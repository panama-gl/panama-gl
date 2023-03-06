/*******************************************************************************
 * Copyright (c) 2022, 2023 Martin Pernollet & contributors.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301, USA
 *******************************************************************************/
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
import panamagl.GLEventAdapter;
import panamagl.factory.PanamaGLFactory;
import panamagl.opengl.GL;
import panamagl.platform.macos.SampleTriangle;
import panamagl.utils.ImageUtils;

/**
 * Not working yet, threading issue. See demofbo_onscreen_macos
 * 
 * 
 * @author Martin
 *
 */
// VM ARGS : --enable-native-access=ALL-UNNAMED --add-modules jdk.incubator.foreign -Djava.library.path=.:/System/Library/Frameworks/OpenGL.framework/Versions/Current/Libraries/

public class ITTestGLCanvasSwing_macOS {
  
  BufferedImage screenshotWhenShown = null;
  List<BufferedImage> screenshotWhenResize = new ArrayList<>();

@Ignore("Work in progress : can't get GL invoked to draw")
  @Test
  public void main() throws InterruptedException {

    CountDownLatch latch = new CountDownLatch(1);
    
    
    System.out.println("SwingUtilities.isEventDispatchThread: " + SwingUtilities.isEventDispatchThread());
    
    // --------------------------------------------
    // This is the GL Scene to render
    
    GLEventAdapter listener = new GLEventAdapter() {
      public void display(GL gl) {
        SampleTriangle.rgbaTriangle2D(gl, w, h);
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
    GLCanvasSwing panel = new GLCanvasSwing(factory);
    panel.setGLEventListener(listener);
    
    // --------------------------------------------
    // Assertions and defered assertions
    
    // Expect initial state to be null
    Assert.assertNull(panel.getScreenshot());
    
    // Define a way to get following states
    panel.addComponentListener(new ComponentAdapter() {
      public void componentShown(ComponentEvent e) {
        screenshotWhenShown = (BufferedImage)panel.getScreenshot().getImage();
        System.err.println("GOT SCREENSHOT! SHOWN");
      }
      
      int k = 0;
      public void componentResized(ComponentEvent e) {
        BufferedImage i = (BufferedImage)panel.getScreenshot().getImage();
        
        //System.out.println(panel.getWidth());
        
        if(i!=null) {
          ImageUtils.save(i, "target/TestGLPanel-"+(k++)+".png");
          screenshotWhenResize.add(i);
          System.err.println("GOT SCREENSHOT! RESIZED " + k);
        }
        else {
          Assert.fail("expected a non null image " + k);
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
        frame.repaint();
        Thread.yield();
        frame.setSize(400, 400);
        frame.repaint();
        Thread.yield();
        frame.repaint();
        sleep(1000);
        frame.setSize(600, 600);
        Thread.yield();
        frame.repaint();
        sleep(1000);
        frame.setSize(500, 400);
        sleep(1000);
        

        //sleep(2000);
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
        SampleTriangle.rgbaTriangle2D(gl, w, h);
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
    GLCanvasSwing panel = new GLCanvasSwing(factory);
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
