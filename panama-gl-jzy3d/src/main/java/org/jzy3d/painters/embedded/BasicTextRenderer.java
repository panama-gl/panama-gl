package org.jzy3d.painters.embedded;

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
import panamagl.opengl.GL;
import panamagl.text.TextRenderer;

/**
 * Port AWTImageConvert.getImageAsByteBuffer to Panama
 * AWTImageViewport & NativeDesktopPainter to draw Legends
 *
 */
public class BasicTextRenderer implements TextRenderer{
  BufferedImage image;
  MemorySegment imageForeign;
  
  public BasicTextRenderer() {
    
    try {
      image = ImageIO.read(new File("logo.png"));
    } catch (IOException e) {
      e.printStackTrace();
    }
    
    setImage(image);
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
    g.drawString(text, 0, height);
    
    setImage(i);
    
    //if(imageForeign!=null && image!=null) {
      drawForeignImage(gl, image, imageForeign, x, y, z);
    //}
  }

  public void drawForeignImage(GL gl, BufferedImage image, MemorySegment foreign, float x, float y, float z) {
    
 // Set viewport and projection
    /*gl.glMatrixMode(gl.GL_PROJECTION());
    gl.glPushMatrix();
    gl.glLoadIdentity();*/
    //applyViewport(painter);
    
    //gl.glOrtho(0, screenWidth, 0, screenHeight, -1, 1);

    // Zoom and layout
    gl.glMatrixMode(gl.GL_MODELVIEW());
    gl.glPushMatrix();
    gl.glLoadIdentity();

    //painter.drawImage(imageData, imageWidth, imageHeight, iLayout.zoom, iLayout.position);
    gl.glPixelZoom(1, 1);
    gl.glRasterPos3f(x, y, z);
    // painter.glRasterPos2f(xpict, ypict);
    gl.glDrawPixels(image.getWidth(), image.getHeight(), gl.GL_RGBA(), gl.GL_UNSIGNED_BYTE(), foreign);

    //imageWidth, imageHeight, GL_RGBA, GL_UNSIGNED_BYTE, imageBuffer);
    gl.glPopMatrix();

    // Restore matrices state
    /*gl.glPopMatrix();
    gl.glMatrixMode(gl.GL_PROJECTION());
    gl.glPopMatrix();*/
  }
  
  
  public BufferedImage getImage() {
    return image;
  }

  public void setImage(BufferedImage image) {
    this.image = image;
    this.imageForeign = BufferedImageForeign.toMemorySegment(image);
  }

  public MemorySegment getImageForeign() {
    return imageForeign;
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
