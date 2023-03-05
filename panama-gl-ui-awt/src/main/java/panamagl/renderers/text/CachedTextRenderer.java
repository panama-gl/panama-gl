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
import java.util.HashMap;
import java.util.Map;
import panamagl.opengl.GL;
import panamagl.renderers.image.ForeignImage;

/**
 * Render text to image which can then be drawn at a given 3D position.
 * 
 * Put labels in cache to avoid regenerating the same labels.
 */
public class CachedTextRenderer extends BasicTextRenderer implements TextRenderer<Font, Color>{
  Map<String,ForeignImage> cache = new HashMap<>();
  
  
  @Override
  public void draw(GL gl, Font font, String text, float x, float y, float z, Color color, float rotation) {
    ForeignImage fi = cache.get(text);
    
    // Generate image
    if(fi==null) {
      fi = createForeignImage(font, text, color);
      
      cache.put(text, fi);
    }
    
    // Draw image
    draw(gl, fi.image, fi.segment, x, y, z, rotation);
  }
  
  public void cacheClear() {
    cache.clear();
  }
}
