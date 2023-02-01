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
package panamagl.os.macos.x86_64;

import panamagl.opengl.GL;

public class SampleTriangle {
    /*public static void rgbaTriangle2D(int width, int height) {
        glViewport(0, 0, width, height);
        glMatrixMode(GL_PROJECTION());
        glLoadIdentity();
        glOrtho(0.0, width, 0.0, height, -1.0, 1.0);
        glMatrixMode(GL_MODELVIEW());
        glLoadIdentity();

        //-------------------------
        //glDisable(GL_TEXTURE_2D());
        glDisable(GL_BLEND());
        glEnable(GL_DEPTH_TEST());

        //-------------------------

        glut_h.glBegin(glut_h.GL_TRIANGLES());

        // bottom left / red
        glut_h.glColor4d(1,0,0,1);
        glut_h.glVertex3d(0,0,0);

        // bottom right / green
        glut_h.glColor4d(0,1,0, 1);
        glut_h.glVertex3d(width,0,0);

        // top right / blue
        glut_h.glColor4d(0,0,1,1);
        glut_h.glVertex3d(width, height,0);
        glut_h.glEnd();
        
        glut_h.glFlush();
    }*/
    
    public static void rgbaTriangle2D(GL gl, int width, int height) {
      gl.glViewport(0, 0, width, height);
      gl.glMatrixMode(gl.GL_PROJECTION());
      gl.glLoadIdentity();
      gl.glOrtho(0.0, width, 0.0, height, -1.0, 1.0);
      gl.glMatrixMode(gl.GL_MODELVIEW());
      gl.glLoadIdentity();

      //-------------------------
      //glDisable(GL_TEXTURE_2D());
      gl.glDisable(gl.GL_BLEND());
      gl.glEnable(gl.GL_DEPTH_TEST());

      //-------------------------

      gl.glBegin(gl.GL_TRIANGLES());

      // bottom left / red
      gl.glColor4f(1,0,0,1);
      gl.glVertex3d(0,0,0);

      // bottom right / green
      gl.glColor4f(0,1,0, 1);
      gl.glVertex3d(width,0,0);

      // top right / blue
      gl.glColor4f(0,0,1,1);
      gl.glVertex3d(width, height,0);
      gl.glEnd();
      
      gl.glFlush();
  }

}
