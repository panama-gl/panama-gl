package opengl.demos.macos;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import opengl.GL;
import opengl.GLContext;
import opengl.demos.SampleTriangle;
import opengl.fbo.FBO;
import opengl.glut.macos.GLUTContext_macOS_10_15_7;
import opengl.macos.GL_macOS_10_15_7;

/**
 * https://github.com/jzy3d/panama-gl/issues/5
 */
// VM ARGS : -XstartOnFirstThread --enable-native-access=ALL-UNNAMED --add-modules jdk.incubator.foreign -Djava.library.path=.:/System/Library/Frameworks/OpenGL.framework/Versions/Current/Libraries/
public class DemoTeapot_Offscreen_macOS {

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

    DemoTeapot_Onscreen_macOS.TeapotGLEventListener().display(null);
    
    //-------------------------
    // Get image
    BufferedImage out = fbo.getImage(gl);

    saveImage(out);

    fbo.release(gl);

  }
  
  private static void saveImage(BufferedImage out) {
    try {
      ImageIO.write(out, "png", new File("target/teapot.png"));

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
