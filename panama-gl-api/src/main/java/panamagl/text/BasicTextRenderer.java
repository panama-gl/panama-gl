package panamagl.text;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.foreign.MemorySegment;
import javax.imageio.ImageIO;
import panamagl.image.BasicImageRenderer;
import panamagl.opengl.GL;

/**
 * Render text to image which can then be drawn at a given 3D position.
 */
public class BasicTextRenderer extends BasicImageRenderer implements TextRenderer{
  
  public BasicTextRenderer() {
    /*try {
      image = ImageIO.read(new File("logo.png"));
    } catch (IOException e) {
      e.printStackTrace();
    }
    setImage(image);*/
  }

  @Override
  public void draw(GL gl, String text, float x, float y, float z) {
    
    int height = 12;
    Font f = new Font("Arial", Font.PLAIN, height);
    int width = stringWidth(text, f);

    BufferedImage i = new BufferedImage(width, height, BufferedImage.TYPE_4BYTE_ABGR);
    
    Graphics2D g = i.createGraphics();
    g.setFont(f);
    g.setColor(Color.black);
    //g.drawString(text, 0, height);
    
    drawString(g, f, false, text, 0, height);
    
    setImage(i);
    
    draw(gl, image, imageForeign, x, y, z);
  }


  
  
  /**
   * A draw string method allowing to bypass OS font rendering if noticing font rendering glitches.
   *
   * It may be worth invoking {@link #configureRenderingHints(Graphics2D)} right before.
   */
  public static void drawString(Graphics2D g2d, Font font, boolean useOSFontRendering,
      String string, int x, int y) {
    if (useOSFontRendering) {
      g2d.setFont(font);
      g2d.drawString(string, x, y);
    } else {
      FontRenderContext frc = g2d.getFontRenderContext();
      GlyphVector gv = font.createGlyphVector(frc, string);
      g2d.drawGlyphVector(gv, x, y);
    }
  }

  /** Compute string width using the Graphics2D instance of a hidden image. */
  public static int stringWidth(String string, Font font) {
    Graphics2D g = i.createGraphics();
    g.setFont(font);
    return stringWidth(g, string);
  }
  
  static BufferedImage i = new BufferedImage(1,1, BufferedImage.TYPE_4BYTE_ABGR);
  
  public static int stringWidth(Graphics2D g2d, String string) {
    FontMetrics fm = g2d.getFontMetrics();
    if (fm != null) {
      return fm.stringWidth(string);
    } else {
      return -1;
    }

  }
}
