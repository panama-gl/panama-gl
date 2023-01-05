package demos.panamagl.macos;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import demos.panamagl.macos.swing.DemoRotatingStuff_Onscreen_macOS;
import opengl.GL;
import opengl.GLContext;
import opengl.glut.macos.GLUTContext_macOS_10_15_7;
import opengl.macos.GL_macOS_10_15_7;
import panamagl.GLEventListener;
import panamagl.fbo.FBO;

/**
 * https://github.com/jzy3d/panama-gl/issues/5
 */
// VM ARGS : -XstartOnFirstThread --enable-native-access=ALL-UNNAMED --add-modules jdk.incubator.foreign -Djava.library.path=.:/System/Library/Frameworks/OpenGL.framework/Versions/Current/Libraries/
public class DemoRotatingStuff_Offscreen_macOS {

  public static void main(String[] args) {
    GLContext context = new GLUTContext_macOS_10_15_7();
    context.init();

    GL gl = new GL_macOS_10_15_7();

    //-------------------------
    // Prepare VBO
    int width = 256;
    int height = 256;
    FBO fbo = new FBO(width, height);
    fbo.prepare(gl);

    //-------------------------
    // Render something

    GLEventListener glL = DemoRotatingStuff_Onscreen_macOS.RotatingStuff();
    
    glL.init(null);
    glL.reshape(null, 0, 0, width, height);    
    glL.display(null);
    
    //-------------------------
    // Get image
    BufferedImage out = fbo.getImage(gl);

    saveImage(out);

    fbo.release(gl);

  }
  
  private static void saveImage(BufferedImage out) {
    try {
      ImageIO.write(out, "png", new File("target/rotatingStuff.png"));

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
