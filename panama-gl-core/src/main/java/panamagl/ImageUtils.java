package panamagl;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageUtils {
  public static BufferedImage copy(BufferedImage source) {
    BufferedImage b = new BufferedImage(source.getWidth(), source.getHeight(), source.getType());
    Graphics g = b.createGraphics();
    g.drawImage(source, 0, 0, null);
    g.dispose();
    return b;
  }
  
  public static void save(BufferedImage image, String path) {
    try {
      ImageIO.write(image, "png", new File(path));
      System.out.println("ImageUtils.save() " + path);
    } catch (IOException e1) {
      throw new RuntimeException(e1);
    }
  }
}
