package panamagl.renderers.image;



import java.awt.image.BufferedImage;
import java.lang.foreign.MemorySegment;
import panamagl.opengl.GL;

public class BasicImageRenderer implements ImageRenderer{
  public void draw(GL gl, BufferedImage image, MemorySegment foreign, float x, float y, float z, float rotation) {
    
    // Zoom and layout
    gl.glMatrixMode(gl.GL_MODELVIEW());
    gl.glPushMatrix();
    gl.glLoadIdentity();

    
    //
    

    
    if(rotation==0) {
    }
    else {
      float rotationD = -(float) (360 * rotation / (2 * Math.PI));

      // Pre-shift text to make it rotate from center
      // of string and not from left point
      int xPreShift = 0, yPreShift = 0;

      if (rotationD != 0) {
        xPreShift = image.getWidth() / 2;
        yPreShift = image.getHeight() / 2;
      }

      //gl.glMatrixMode(gl.GL_MODELVIEW());
      //gl.glPushMatrix();
      //gl.glTranslatef(xPreShift, yPreShift, 0);
      gl.glScalef(1, 1, 1);
      gl.glRotatef(rotationD, 0, 0, 1);

      // Shifting text to deal with rotation
      int xPostShift = -xPreShift;
      int yPostShift = -yPreShift;



    }
    
    
    
    
    
    // Draw image
    gl.glPixelZoom(1, 1);
    gl.glRasterPos3f(x, y, z);
    // painter.glRasterPos2f(xpict, ypict);
    gl.glDrawPixels(image.getWidth(), image.getHeight(), gl.GL_RGBA(), gl.GL_UNSIGNED_BYTE(), foreign);

    gl.glPopMatrix();

    
  }
}
