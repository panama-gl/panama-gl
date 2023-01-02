package opengl.demos.macos;

import static jdk.incubator.foreign.CLinker.C_FLOAT;

import static opengl.macos.v10_15_3.glut_h.GL_AMBIENT;
import static opengl.macos.v10_15_3.glut_h.GL_COLOR_BUFFER_BIT;
import static opengl.macos.v10_15_3.glut_h.GL_DEPTH_BUFFER_BIT;
import static opengl.macos.v10_15_3.glut_h.GL_DEPTH_TEST;
import static opengl.macos.v10_15_3.glut_h.GL_DIFFUSE;
import static opengl.macos.v10_15_3.glut_h.GL_FRONT;
import static opengl.macos.v10_15_3.glut_h.GL_LIGHT0;
import static opengl.macos.v10_15_3.glut_h.GL_LIGHTING;
import static opengl.macos.v10_15_3.glut_h.GL_POSITION;
import static opengl.macos.v10_15_3.glut_h.GL_SHININESS;
import static opengl.macos.v10_15_3.glut_h.GL_SMOOTH;
import static opengl.macos.v10_15_3.glut_h.GL_SPECULAR;
import static opengl.macos.v10_15_3.glut_h.GLUT_DEPTH;
import static opengl.macos.v10_15_3.glut_h.GLUT_DOUBLE;
import static opengl.macos.v10_15_3.glut_h.GLUT_RGB;
import static opengl.macos.v10_15_3.glut_h.glClear;
import static opengl.macos.v10_15_3.glut_h.glClearColor;
import static opengl.macos.v10_15_3.glut_h.glEnable;
import static opengl.macos.v10_15_3.glut_h.glLightfv;
import static opengl.macos.v10_15_3.glut_h.glMaterialfv;
import static opengl.macos.v10_15_3.glut_h.glPopMatrix;
import static opengl.macos.v10_15_3.glut_h.glPushMatrix;
import static opengl.macos.v10_15_3.glut_h.glRotatef;
import static opengl.macos.v10_15_3.glut_h.glShadeModel;
import static opengl.macos.v10_15_3.glut_h.glutCreateWindow;
import static opengl.macos.v10_15_3.glut_h.glutDisplayFunc;
import static opengl.macos.v10_15_3.glut_h.glutIdleFunc;
import static opengl.macos.v10_15_3.glut_h.glutInit;
import static opengl.macos.v10_15_3.glut_h.glutInitDisplayMode;
import static opengl.macos.v10_15_3.glut_h.glutInitWindowSize;
import static opengl.macos.v10_15_3.glut_h.glutMainLoop;
import static opengl.macos.v10_15_3.glut_h.glutPostRedisplay;
import static opengl.macos.v10_15_3.glut_h.glutSolidTeapot;
import static opengl.macos.v10_15_3.glut_h.glutSwapBuffers;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import jdk.incubator.foreign.ResourceScope;
import jdk.incubator.foreign.SegmentAllocator;

import opengl.GL;
import opengl.GLError;

import panamagl.GLEventAdapter;
import panamagl.GLPanel;
import panamagl.Animator;

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
public class DemoTeapot_Onscreen_macOS {

  public static void main(String[] args) throws Exception {
    System.out.println("SwingUtilities.isEventDispatchThread: " + SwingUtilities.isEventDispatchThread());
    
    // This is the GL Scene to render
    GLEventAdapter listener = TeapotGLEventListener();
    //GLEventAdapter listener = DemoFBO_Onscreen_macOS.RGBTriangleEventListener();

    // Using a panel to ensure that GL get initialized in the main AWT thread.
    GLPanel panel = new GLPanel();
    panel.setGLEventListener(listener);
    
    // Create frame
    final JFrame frame = new JFrame(DemoTeapot_Onscreen_macOS.class.getSimpleName());
    frame.getContentPane().setLayout(new BorderLayout());
    //frame.pack();
    frame.setBounds(0, 0, 800, 600);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    // Use this to avoid Swing hangs
    SwingUtilities.invokeLater(new Runnable() {
      @Override
      public void run() {
       // doDemo(); 
        
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
    
    
    Animator a = new Animator(panel);
    a.start();
    
    /*while(true) {
      panel.display();
      try {
        Thread.sleep(100);
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }*/

  }

  public static GLEventAdapter TeapotGLEventListener() {
    return new GLEventAdapter() {
      public void init(GL gl) {
        
        System.out.println("GLEventAdapter : init");
        var scope = ResourceScope.newConfinedScope();
        var allocator = SegmentAllocator.ofScope(scope);
    
        // Reset Background
        glClearColor(0f, 0f, 0f, 0f);
        
        // Setup Lighting
        glShadeModel(GL_SMOOTH());
        var pos = allocator.allocateArray(C_FLOAT, new float[] { 0.0f, 15.0f, -15.0f, 0 });
        glLightfv(GL_LIGHT0(), GL_POSITION(), pos);
        var spec = allocator.allocateArray(C_FLOAT, new float[] { 1, 1, 1, 0 });
        glLightfv(GL_LIGHT0(), GL_AMBIENT(), spec);
        glLightfv(GL_LIGHT0(), GL_DIFFUSE(), spec);
        glLightfv(GL_LIGHT0(), GL_SPECULAR(), spec);
        var shini = allocator.allocate(C_FLOAT, 113);
        glMaterialfv(GL_FRONT(), GL_SHININESS(), shini);
        glEnable(GL_LIGHTING());
        glEnable(GL_LIGHT0());
        glEnable(GL_DEPTH_TEST());
        
        if(gl!=null)
          GLError.checkAndThrow(gl);
      }
      
      public void display(GL gl) {
        
        glClear(GL_COLOR_BUFFER_BIT() | GL_DEPTH_BUFFER_BIT());
        glPushMatrix();
        glRotatef(-20f, 1f, 1f, 0f);
        glRotatef(rot, 0f, 1f, 0f);
        glutSolidTeapot(0.5d);
        glPopMatrix();
        //glutSwapBuffers();
        
        rot += 0.1;
        
        System.out.println("GLEventAdapter : display");
        
        if(gl!=null)
          GLError.checkAndThrow(gl);

      }
      
      protected float rot = 0;
      
      @Override
      public void reshape(GL gl, int x, int y, int width, int height) {
        System.out.println("GLEventAdapter : reshape");
      }
    };
  }
  
}
