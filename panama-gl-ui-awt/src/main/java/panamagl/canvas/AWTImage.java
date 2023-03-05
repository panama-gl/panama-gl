package panamagl.canvas;

import java.awt.image.BufferedImage;
import panamagl.Image;

public class AWTImage implements Image<BufferedImage>{
  BufferedImage image;

  public AWTImage(BufferedImage image) {
    super();
    this.image = image;
  }

  public BufferedImage getImage() {
    return image;
  }
}
