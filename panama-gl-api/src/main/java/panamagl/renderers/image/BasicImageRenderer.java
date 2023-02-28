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
package panamagl.renderers.image;



import java.awt.image.BufferedImage;
import java.lang.foreign.MemorySegment;
import panamagl.opengl.GL;

public class BasicImageRenderer implements ImageRenderer{
  public void draw(GL gl, BufferedImage image, MemorySegment foreign, float x, float y, float z, float rotation) {
    
    // Zoom and layout
    gl.glMatrixMode(GL.GL_MODELVIEW);
    gl.glPushMatrix();
    gl.glLoadIdentity();

    //
    
    /*if(rotation==0) {
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
      //gl.glPushMatrix();o
      //gl.glTranslatef(xPreShift, yPreShift, 0);
      gl.glScalef(1, 1, 1);
      gl.glRotatef(rotationD, 0, 0, 1);

      // Shifting text to deal with rotation
      int xPostShift = -xPreShift;
      int yPostShift = -yPreShift;

    }*/
    
    
    // Draw image
    gl.glPixelZoom(1, 1);
    gl.glRasterPos3f(x, y, z);
    // painter.glRasterPos2f(xpict, ypict);
    gl.glDrawPixels(image.getWidth(), image.getHeight(), GL.GL_RGBA, GL.GL_UNSIGNED_BYTE, foreign);

    gl.glPopMatrix();
  }
}
