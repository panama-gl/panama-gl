package panamagl;

import java.awt.Graphics;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
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

  
  public static BufferedImage flip(BufferedImage image, boolean vertically, boolean horizontally) {
    
    if(vertically && !horizontally) {
      // Flip the image vertically
      AffineTransform tx = AffineTransform.getScaleInstance(1, -1);
      tx.translate(0, -image.getHeight(null));
      AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
      image = op.filter(image, null);
    }
    else if(!vertically && horizontally) {
      // Flip the image horizontally
      AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
      tx.translate(-image.getWidth(null), 0);
      AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
      image = op.filter(image, null);
      
    }
    else if(vertically && horizontally) {
      // Flip the image vertically and horizontally; equivalent to rotating the image 180 degrees
      AffineTransform tx = AffineTransform.getScaleInstance(-1, -1);
      tx.translate(-image.getWidth(null), -image.getHeight(null));
      AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
      image = op.filter(image, null);
    }
    
    return image;
  }
  
  public static BufferedImage flipVertically(BufferedImage image) {
    return flip(image, true, false);
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
