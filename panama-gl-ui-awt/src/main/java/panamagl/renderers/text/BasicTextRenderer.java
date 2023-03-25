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
package panamagl.renderers.text;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import panamagl.opengl.GL;
import panamagl.renderers.image.BasicImageRenderer;
import panamagl.renderers.image.BufferedImageForeign;
import panamagl.renderers.image.ForeignImage;
import panamagl.utils.GraphicsUtils;

/**
 * Render text to image which can then be drawn at a given 3D position.
 */
public class BasicTextRenderer extends BasicImageRenderer implements TextRenderer<Font, Color>{
  boolean drawBorder = true;
  
  @Override
  public void draw(GL gl, Font font, String text, float x, float y, float z, Color color, float rotation) {
    ForeignImage fi = createForeignImage(font, text, color);
    
    draw(gl, fi.image, fi.segment, x, y, z, rotation);
  }
  
  protected ForeignImage createForeignImage(Font font, String text, Color color) {
    ForeignImage fi;
    Rectangle2D bounds = GraphicsUtils.stringBounds(text, font);
    int width = (int)bounds.getWidth();//GraphicsUtils.stringWidth(text, font);
    int height = (int)bounds.getHeight();//font.getSize();
    
    if(width<=0) {
      throw new IllegalArgumentException("Width<=0 for \"" + text + "\" : " + width );
    }
    if(height<=0) {
      throw new IllegalArgumentException("Height<=0 for \"" + text + "\" : " + height );
    }
    
    //System.out.println(width + "," + height + " " + text);
    
    BufferedImage i = new BufferedImage(width, height, BufferedImage.TYPE_4BYTE_ABGR);
    
    Graphics2D g = i.createGraphics();
    
    if(drawBorder) {
      g.setColor(Color.GRAY);
      g.drawRect(1, 1, width-2, height-2);
    }
    
    // Draw text
    g.setFont(font);
    g.setColor(color);
    
    int y = height - (int)Math.round(height*0.25);
    //int y = height;
    
    GraphicsUtils.drawString(g, font, false, text, 0, y);
    //GraphicsUtils.drawString(g, font, false, text, 0, 0);
    
    g.dispose();

    fi = new ForeignImage();
    fi.image = i;
    fi.segment = BufferedImageForeign.toMemorySegment(i);
    return fi;
  }
  
}
