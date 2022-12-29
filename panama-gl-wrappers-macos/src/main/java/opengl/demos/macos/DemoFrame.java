package opengl.demos.macos;

import java.awt.BorderLayout;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.util.List;
import java.util.Properties;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class DemoFrame {

  public static void main(String[] args) throws Exception {
    System.out.println("SwingUtilities.isEventDispatchThread: " + SwingUtilities.isEventDispatchThread());
    /*System.out.println("-XstartOnFirstThread? " + System.getProperty("-XstartOnFirstThread"));

    Properties properties = System.getProperties();
    for (String propertyName : properties.stringPropertyNames()) {
        System.out.println(propertyName + ": " + properties.getProperty(propertyName));
    }

    RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
    List<String> jvmOptions = runtimeMXBean.getInputArguments();
    for (String jvmOption : jvmOptions) {
        System.out.println(jvmOption);
    }*/
    
    JFrame frame = new JFrame("Rendering offscreen with Panama GL");
    frame.getContentPane().setLayout(new BorderLayout());
    //frame.pack();
    frame.setBounds(0, 0, 800, 600);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    //frame.add(panel, BorderLayout.CENTER);
    
    //Thread.sleep(1000);
    System.out.println("WILL SET VISIBLE");
    frame.setVisible(true);
    System.out.println("EXEC ALL");
    frame.show();
    frame.pack();

  }
}
