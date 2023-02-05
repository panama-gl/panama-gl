package panamagl.image;



import java.awt.image.BufferedImage;
import java.lang.foreign.MemorySegment;
import panamagl.opengl.GL;

public class BasicImageRenderer implements ImageRenderer{
  protected BufferedImage image;
  protected MemorySegment imageForeign;

  public void draw(GL gl, BufferedImage image, MemorySegment foreign, float x, float y, float z) {
    
    // Zoom and layout
    gl.glMatrixMode(gl.GL_MODELVIEW());
    gl.glPushMatrix();
    gl.glLoadIdentity();

    // Draw image
    gl.glPixelZoom(1, 1);
    gl.glRasterPos3f(x, y, z);
    // painter.glRasterPos2f(xpict, ypict);
    gl.glDrawPixels(image.getWidth(), image.getHeight(), gl.GL_RGBA(), gl.GL_UNSIGNED_BYTE(), foreign);

    //imageWidth, imageHeight, GL_RGBA, GL_UNSIGNED_BYTE, imageBuffer);
    gl.glPopMatrix();

  }

  public void setImage(BufferedImage image) {
    this.image = image;
    this.imageForeign = BufferedImageForeign.toMemorySegment(image);
  }

  public BufferedImage getImage() {
    return image;
  }

  public MemorySegment getForeignImage() {
    return imageForeign;
  }
}
