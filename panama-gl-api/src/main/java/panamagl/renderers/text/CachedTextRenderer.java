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
public class CachedTextRenderer extends BasicTextRenderer implements TextRenderer{
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
