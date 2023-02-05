package panamagl.renderers.text;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import panamagl.opengl.GL;
import panamagl.renderers.image.BasicImageRenderer;
import panamagl.renderers.image.BufferedImageForeign;
import panamagl.renderers.image.ForeignImage;
import panamagl.utils.GraphicsUtils;

/**
 * Render text to image which can then be drawn at a given 3D position.
 */
public class BasicTextRenderer extends BasicImageRenderer implements TextRenderer{
  @Override
  public void draw(GL gl, Font font, String text, float x, float y, float z, Color color, float rotation) {
    ForeignImage fi = createForeignImage(font, text, color);
    
    draw(gl, fi.image, fi.segment, x, y, z, rotation);
  }
  
  protected ForeignImage createForeignImage(Font font, String text, Color color) {
    ForeignImage fi;
    int width = GraphicsUtils.stringWidth(text, font);
    //int height = (int)(font.getSize()*1.25f);
    int height =font.getSize();
    
    BufferedImage i = new BufferedImage(width, height, BufferedImage.TYPE_4BYTE_ABGR);
    
    Graphics2D g = i.createGraphics();
    
    //g.setColor(Color.GRAY);
    //g.drawRect(1, 1, width-2, height-2);

    // Draw text
    g.setFont(font);
    g.setColor(color);
    
    int y = height - (int)(height*0.25);
    
    GraphicsUtils.drawString(g, font, false, text, 0, y);
    //GraphicsUtils.drawString(g, font, false, text, 0, 0);
    

    fi = new ForeignImage();
    fi.image = i;
    fi.segment = BufferedImageForeign.toMemorySegment(i);
    return fi;
  }
  
}
