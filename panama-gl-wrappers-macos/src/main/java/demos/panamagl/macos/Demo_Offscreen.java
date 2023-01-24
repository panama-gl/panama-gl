package demos.panamagl.macos;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import opengl.GL;
import panamagl.fbo.FBO;
import panamagl.macos.FBO_macOS;

/**
 * https://github.com/jzy3d/panama-gl/issues/5
 */
// VM ARGS : -XstartOnFirstThread --enable-native-access=ALL-UNNAMED --add-modules jdk.incubator.foreign -Djava.library.path=.:/System/Library/Frameworks/OpenGL.framework/Versions/Current/Libraries/
public class Demo_Offscreen {
  public static void fbo_offscreen(GL gl) {
    //-------------------------
    // Prepare VBO
    int width = 256;
    int height = 256;
    FBO fbo = new FBO_macOS(width, height);
    fbo.prepare(gl);

    //-------------------------
    // Render something
    SampleTriangle.rgbaTriangle2D(width, height);

    //-------------------------
    // Get image
    BufferedImage out = fbo.getImage(gl);

    saveImage(out);

    fbo.release(gl);
  }

  private static void saveImage(BufferedImage out) {
    try {
      ImageIO.write(out, "png", new File("target/outFBO.png"));

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
