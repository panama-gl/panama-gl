/*******************************************************************************
 * Copyright (c) 2022, 2023 Martin Pernollet & contributors.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301, USA
 *******************************************************************************/
package panamagl.utils;

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
