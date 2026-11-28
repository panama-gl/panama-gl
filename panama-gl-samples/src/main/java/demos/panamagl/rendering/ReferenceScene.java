/*******************************************************************************
 * Copyright (c) 2022, 2023 Martin Pernollet & contributors.
 *
 * This library is free software; you can redistribute it and/or modify it under the terms of the
 * GNU Lesser General Public License as published by the Free Software Foundation; either version
 * 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License along with this library;
 * if not, write to the Free Software Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA
 * 02110-1301, USA
 *******************************************************************************/
package demos.panamagl.rendering;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import panamagl.opengl.GL;

/**
 * A fixed function OpenGL scene used to compare rendering backends : immediate mode, lighting,
 * color material, quads, wide and stippled lines, large points and a GLU quadric. These are the
 * features that an OpenGL implementation layered over another API (Vulkan, Direct3D 12, Metal) has
 * to emulate.
 *
 * <p>The camera looks at a lit blue sphere standing on a checkered floor.
 */
public class ReferenceScene {
  /** OpenGL rows start at the bottom : flip the image read from a FBO before saving it. */
  public static BufferedImage flipVertically(BufferedImage in) {
    BufferedImage out = new BufferedImage(in.getWidth(), in.getHeight(), BufferedImage.TYPE_INT_ARGB);
    Graphics2D g = out.createGraphics();
    g.drawImage(in, 0, in.getHeight(), in.getWidth(), -in.getHeight(), null);
    g.dispose();
    return out;
  }

  protected static MemorySegment quadric;

  public static void init(GL gl, Arena arena, int width, int height) {
    gl.glViewport(0, 0, width, height);
    gl.glMatrixMode(GL.GL_PROJECTION);
    gl.glLoadIdentity();
    gl.gluPerspective(40, (double) width / height, 0.1, 20);
    gl.glMatrixMode(GL.GL_MODELVIEW);
    gl.glLoadIdentity();
    gl.gluLookAt(0, 1.2, 4, 0, 0, 0, 0, 1, 0);

    gl.glEnable(GL.GL_DEPTH_TEST);
    gl.glShadeModel(GL.GL_SMOOTH);

    var position = arena.allocateFrom(ValueLayout.JAVA_FLOAT, 2f, 4f, 3f, 0f);
    var white = arena.allocateFrom(ValueLayout.JAVA_FLOAT, 1f, 1f, 1f, 1f);
    var ambient = arena.allocateFrom(ValueLayout.JAVA_FLOAT, .15f, .15f, .15f, 1f);
    gl.glLightfv(GL.GL_LIGHT0, GL.GL_POSITION, position);
    gl.glLightfv(GL.GL_LIGHT0, GL.GL_DIFFUSE, white);
    gl.glLightfv(GL.GL_LIGHT0, GL.GL_SPECULAR, white);
    gl.glLightfv(GL.GL_LIGHT0, GL.GL_AMBIENT, ambient);
    gl.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, white);
    gl.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, arena.allocateFrom(ValueLayout.JAVA_FLOAT, 60f));
    gl.glColorMaterial(GL.GL_FRONT, GL.GL_AMBIENT_AND_DIFFUSE);
    gl.glEnable(GL.GL_COLOR_MATERIAL);

    quadric = gl.gluNewQuadric();
  }

  public static void display(GL gl, float angle) {
    gl.glClearColor(1f, 1f, 1f, 1f);
    gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);

    gl.glPushMatrix();
    gl.glRotatef(angle, 0, 1, 0);

    // Floor : colored quads, flat lighting off
    gl.glDisable(GL.GL_LIGHTING);
    gl.glBegin(GL.GL_QUADS);
    for (int i = -4; i < 4; i++) {
      for (int j = -4; j < 4; j++) {
        float c = ((i + j) & 1) == 0 ? 0.85f : 0.65f;
        gl.glColor3f(c, c, (i + 4) / 8f);
        gl.glVertex3f(i * .25f, -.6f, j * .25f);
        gl.glVertex3f((i + 1) * .25f, -.6f, j * .25f);
        gl.glVertex3f((i + 1) * .25f, -.6f, (j + 1) * .25f);
        gl.glVertex3f(i * .25f, -.6f, (j + 1) * .25f);
      }
    }
    gl.glEnd();

    // Wide stippled line loop around the floor
    gl.glLineWidth(4f);
    gl.glEnable(GL.GL_LINE_STIPPLE);
    gl.glLineStipple(2, (short) 0x0F0F);
    gl.glColor3f(0.8f, 0.1f, 0.1f);
    gl.glBegin(GL.GL_LINE_LOOP);
    gl.glVertex3f(-1, -.6f, -1);
    gl.glVertex3f(1, -.6f, -1);
    gl.glVertex3f(1, -.6f, 1);
    gl.glVertex3f(-1, -.6f, 1);
    gl.glEnd();
    gl.glDisable(GL.GL_LINE_STIPPLE);
    gl.glLineWidth(1f);

    // Large points at the corners
    gl.glPointSize(10f);
    gl.glBegin(GL.GL_POINTS);
    gl.glColor3f(0.1f, 0.6f, 0.1f);
    gl.glVertex3f(-1, -.6f, -1);
    gl.glVertex3f(1, -.6f, -1);
    gl.glVertex3f(1, -.6f, 1);
    gl.glVertex3f(-1, -.6f, 1);
    gl.glEnd();
    gl.glPointSize(1f);

    // Lit sphere (GLU quadric)
    gl.glEnable(GL.GL_LIGHTING);
    gl.glEnable(GL.GL_LIGHT0);
    gl.glColor3f(0.2f, 0.35f, 0.9f);
    gl.gluSphere(quadric, 0.55, 48, 32);
    gl.glDisable(GL.GL_LIGHTING);

    gl.glPopMatrix();
  }
}
