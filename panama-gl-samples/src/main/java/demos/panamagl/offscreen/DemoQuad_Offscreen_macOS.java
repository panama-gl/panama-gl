package demos.panamagl.offscreen;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import demos.panamagl.swing.DemoQuad_Onscreen_Swing;
import panamagl.GLEventListener;
import panamagl.fbo.FBO;
import panamagl.opengl.GL;
import panamagl.opengl.GLContext;
import panamagl.os.macos.FBO_macOS;
import panamagl.os.macos.GLUTContext_macOS;
import panamagl.os.macos.GL_macOS;

/**
 * https://github.com/jzy3d/panama-gl/issues/5
 */
// VM ARGS : -XstartOnFirstThread --enable-native-access=ALL-UNNAMED --add-modules jdk.incubator.foreign -Djava.library.path=.:/System/Library/Frameworks/OpenGL.framework/Versions/Current/Libraries/
public class DemoQuad_Offscreen_macOS {

  public static void main(String[] args) {
    GLContext context = new GLUTContext_macOS();
    context.init();

    GL gl = new GL_macOS();

    //-------------------------
    // Prepare VBO
    int width = 256;
    int height = 256;
    FBO fbo = new FBO_macOS(width, height);
    fbo.prepare(gl);

    //-------------------------
    // Render something

    GLEventListener glL = DemoQuad_Onscreen_Swing.RotatingStuff();
    
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
