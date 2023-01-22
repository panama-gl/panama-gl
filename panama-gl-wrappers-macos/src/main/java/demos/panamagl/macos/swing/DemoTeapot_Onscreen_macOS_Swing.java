package demos.panamagl.macos.swing;

import java.awt.BorderLayout;
import java.lang.foreign.MemorySession;
import java.lang.foreign.SegmentAllocator;
import java.lang.foreign.ValueLayout;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import opengl.GL;
import opengl.GLError;
import panamagl.Animator;
import panamagl.GLEventAdapter;
import panamagl.PanamaMemorySession;
import panamagl.macos.cgl.PanamaGLMacOSFactory;
import panamagl.toolkits.swing.GLCanvasSwing;

/**
 * VM ARGS : --enable-native-access=ALL-UNNAMED --enable-preview
 * -Djava.library.path=.:/System/Library/Frameworks/OpenGL.framework/Versions/Current/Libraries/
 * 
 * @author Martin
 *
 */
public class DemoTeapot_Onscreen_macOS_Swing {

  public static void main(String[] args) throws Exception {
    System.out
        .println("SwingUtilities.isEventDispatchThread: " + SwingUtilities.isEventDispatchThread());

    // This is the GL Scene to render
    GLEventAdapter listener = TeapotGLEventListener();

    // Using a panel to ensure that GL get initialized in the main AWT thread.
    PanamaGLMacOSFactory factory = new PanamaGLMacOSFactory();
    GLCanvasSwing panel = (GLCanvasSwing)factory.newCanvas(GLCanvasSwing.class);
    panel.setGLEventListener(listener);

    // Create frame
    final JFrame frame = new JFrame(DemoTeapot_Onscreen_macOS_Swing.class.getSimpleName());
    frame.getContentPane().setLayout(new BorderLayout());
    frame.setBounds(0, 0, 800, 600);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Init action
    Runnable show = new Runnable() {
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
    };
    
    
    // Use this to avoid Swing hangs
    SwingUtilities.invokeLater(show);
    //show.run();
    
    // Start animating
    Animator a = new Animator(panel);
    a.start();
  }

  public static GLEventAdapter TeapotGLEventListener() {
    return new GLEventAdapter() {

      public void init(GL gl) {
        MemorySession scope = PanamaMemorySession.get();
        SegmentAllocator allocator = SegmentAllocator.newNativeArena(scope);

        // Reset Background
        gl.glClearColor(1f, 1f, 1f, 1f);

        // Setup Lighting
        gl.glShadeModel(gl.GL_SMOOTH());
        
        var pos = allocator.allocateArray(ValueLayout.JAVA_FLOAT, new float[] {0.0f, 15.0f, -15.0f, 0});
        gl.glLightfv(gl.GL_LIGHT0(), gl.GL_POSITION(), pos);
        
        var spec = allocator.allocateArray(ValueLayout.JAVA_FLOAT, new float[] {1, 1, 1, 0});
        gl.glLightfv(gl.GL_LIGHT0(), gl.GL_AMBIENT(), spec);
        gl.glLightfv(gl.GL_LIGHT0(), gl.GL_DIFFUSE(), spec);
        gl.glLightfv(gl.GL_LIGHT0(), gl.GL_SPECULAR(), spec);
        
        var shini = allocator.allocate(ValueLayout.JAVA_FLOAT, 113);
        gl.glMaterialfv(gl.GL_FRONT(), gl.GL_SHININESS(), shini);
        gl.glEnable(gl.GL_LIGHTING());
        gl.glEnable(gl.GL_LIGHT0());
        gl.glEnable(gl.GL_DEPTH_TEST());

        GLError.checkAndThrow(gl);
      }

      public void display(GL gl) {
        // Reset Background
        gl.glClearColor(1f, 1f, 1f, 1f);
        gl.glClear(gl.GL_COLOR_BUFFER_BIT() | gl.GL_DEPTH_BUFFER_BIT());

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
