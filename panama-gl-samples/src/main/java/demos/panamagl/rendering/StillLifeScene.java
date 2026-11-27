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

import static demos.panamagl.rendering.M4.*;
import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.util.Random;
import panamagl.opengl.GL;

/**
 * A still life with the fixed function pipeline only, no shader : objects of copper, ceramic, glass
 * and lacquer on a marble floor reflecting them, lit by a warm spot, a cool fill and a magenta rim
 * light, in a dark fog.
 *
 * <p>Exercises what Jzy3D uses : OpenGL lighting with spot and attenuated lights, materials, color
 * material, display lists, GLU quadrics, clip planes (the mirror), blending (marble, glass), depth
 * mask, polygon offset (edges of a cube), wide stippled lines, smooth points and linear fog. An
 * OpenGL implementation layered over another API has to emulate all of them.
 */
public class StillLifeScene implements Scene {
  protected int objects, floor;
  protected int width, height;
  protected Arena arena;
  protected float[] dust;

  protected final float[] eye = v(0.3, 1.55, 4.3);
  protected final float[] target = v(0, 0.45, 0);

  @Override
  public String getName() {
    return "still-life";
  }

  @Override
  public void init(GL gl, Arena arena, int width, int height) {
    this.width = width;
    this.height = height;
    this.arena = arena;
    MemorySegment quadric = gl.gluNewQuadric();
    gl.gluQuadricNormals(quadric, 100000 /* GLU_SMOOTH */);

    objects = gl.glGenLists(2);
    floor = objects + 1;

    gl.glNewList(objects, GL.GL_COMPILE);
    // Copper torus, standing
    gl.glPushMatrix();
    gl.glTranslatef(-0.95f, 0.62f, 0.1f);
    gl.glRotatef(70, 0, 1, 0);
    material(gl, v(0.75, 0.38, 0.16), v(1.0, 0.8, 0.6), 90);
    torus(gl, 0.42f, 0.17f, 64, 24);
    gl.glPopMatrix();
    // Lacquered red sphere
    gl.glPushMatrix();
    gl.glTranslatef(0.95f, 0.38f, 0.35f);
    material(gl, v(0.62, 0.04, 0.05), v(1, 1, 1), 120);
    gl.gluSphere(quadric, 0.38, 48, 32);
    gl.glPopMatrix();
    // Ceramic vase : cylinder, belly and lip
    gl.glPushMatrix();
    gl.glTranslatef(0.05f, 0, -0.75f);
    gl.glRotatef(-90, 1, 0, 0);
    material(gl, v(0.12, 0.28, 0.58), v(0.7, 0.7, 0.8), 60);
    gl.gluCylinder(quadric, 0.22, 0.32, 0.45, 40, 8);
    gl.glTranslatef(0, 0, 0.45f);
    gl.gluCylinder(quadric, 0.32, 0.12, 0.55, 40, 8);
    gl.glTranslatef(0, 0, 0.55f);
    gl.gluCylinder(quadric, 0.12, 0.17, 0.12, 40, 2);
    gl.glPopMatrix();
    // Dark cube with bright edges, drawn over with a polygon offset
    gl.glPushMatrix();
    gl.glTranslatef(-0.25f, 0.25f, 0.85f);
    gl.glRotatef(28, 0, 1, 0);
    material(gl, v(0.08, 0.08, 0.09), v(0.6, 0.6, 0.6), 40);
    gl.glEnable(GL.GL_POLYGON_OFFSET_FILL);
    gl.glPolygonOffset(1f, 1f);
    cube(gl, 0.25f, GL.GL_QUADS);
    gl.glDisable(GL.GL_POLYGON_OFFSET_FILL);
    gl.glDisable(GL.GL_LIGHTING);
    gl.glColor3f(0.95f, 0.85f, 0.6f);
    gl.glLineWidth(1.5f);
    cube(gl, 0.25f, GL.GL_LINE_LOOP);
    gl.glLineWidth(1f);
    gl.glEnable(GL.GL_LIGHTING);
    gl.glPopMatrix();
    gl.glEndList();

    // Marble checkerboard
    gl.glNewList(floor, GL.GL_COMPILE);
    gl.glBegin(GL.GL_QUADS);
    gl.glNormal3f(0, 1, 0);
    int n = 12;
    float s = 6f / n;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        boolean dark = ((i + j) & 1) == 0;
        float x = -3 + i * s, z = -3 + j * s;
        if (dark)
          gl.glColor4f(0.10f, 0.10f, 0.12f, 0.72f);
        else
          gl.glColor4f(0.78f, 0.76f, 0.72f, 0.72f);
        gl.glVertex3f(x, 0, z);
        gl.glVertex3f(x, 0, z + s);
        gl.glVertex3f(x + s, 0, z + s);
        gl.glVertex3f(x + s, 0, z);
      }
    }
    gl.glEnd();
    gl.glEndList();
    gl.gluDeleteQuadric(quadric);

    Random r = new Random(5);
    // Dust floating in the cone of the warm spot
    dust = new float[140 * 3];
    for (int i = 0; i < dust.length; i += 3) {
      float t = r.nextFloat();
      dust[i] = 2.2f * t + (r.nextFloat() - 0.5f) * 0.9f * t;
      dust[i + 1] = 3.6f * t + 0.2f;
      dust[i + 2] = 2.2f * t + (r.nextFloat() - 0.5f) * 0.9f * t;
    }
  }

  protected void material(GL gl, float[] diffuse, float[] specular, float shininess) {
    gl.glColor4f(diffuse[0], diffuse[1], diffuse[2], 1f);
    gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_SPECULAR, floats(arena, specular[0], specular[1], specular[2], 1));
    gl.glMaterialf(GL.GL_FRONT_AND_BACK, GL.GL_SHININESS, shininess);
  }

  /** A torus around the z axis, as quad strips with smooth normals. */
  static void torus(GL gl, float major, float minor, int sides, int rings) {
    for (int i = 0; i < sides; i++) {
      gl.glBegin(GL.GL_QUAD_STRIP);
      for (int j = 0; j <= rings; j++) {
        for (int k = 0; k <= 1; k++) {
          double u = 2 * Math.PI * (i + k) / sides, w = 2 * Math.PI * j / rings;
          float cx = (float) Math.cos(u), cy = (float) Math.sin(u);
          float nx = (float) (Math.cos(w) * cx), ny = (float) (Math.cos(w) * cy), nz = (float) Math.sin(w);
          gl.glNormal3f(nx, ny, nz);
          gl.glVertex3f(major * cx + minor * nx, major * cy + minor * ny, minor * nz);
        }
      }
      gl.glEnd();
    }
  }

  /** A cube of the given half size, as filled quads or as line loops of its faces. */
  static void cube(GL gl, float h, int mode) {
    float[][] normals = {{0, 0, 1}, {0, 0, -1}, {1, 0, 0}, {-1, 0, 0}, {0, 1, 0}, {0, -1, 0}};
    for (float[] nrm : normals) {
      // Two axes spanning the face
      float[] a = nrm[0] != 0 ? new float[] {0, 1, 0} : new float[] {1, 0, 0};
      float[] b = cross(nrm, a);
      gl.glBegin(mode);
      gl.glNormal3f(nrm[0], nrm[1], nrm[2]);
      float[][] corners = {{-1, -1}, {1, -1}, {1, 1}, {-1, 1}};
      for (float[] c : corners) {
        gl.glVertex3f(h * (nrm[0] + a[0] * c[0] + b[0] * c[1]), h * (nrm[1] + a[1] * c[0] + b[1] * c[1]),
            h * (nrm[2] + a[2] * c[0] + b[2] * c[1]));
      }
      gl.glEnd();
    }
  }

  protected void lights(GL gl) {
    // Warm key spot, cool fill, magenta rim : positions in world coordinates
    gl.glLightfv(GL.GL_LIGHT0, GL.GL_POSITION, floats(arena, 2.2f, 3.6f, 2.2f, 1));
    gl.glLightfv(GL.GL_LIGHT0, GL.GL_SPOT_DIRECTION, floats(arena, -2.2f, -3.6f, -2.2f));
    gl.glLightfv(GL.GL_LIGHT1, GL.GL_POSITION, floats(arena, -3.5f, 1.4f, 1.5f, 1));
    gl.glLightfv(GL.GL_LIGHT2, GL.GL_POSITION, floats(arena, -0.8f, 1.8f, -3.2f, 1));
  }

  @Override
  public void display(GL gl, float time) {
    // The parameters of each frame are allocated in a frame arena, released at the end of the frame
    Arena sceneArena = arena;
    try (Arena frame = Arena.ofConfined()) {
      arena = frame;
      drawFrame(gl, time);
    } finally {
      arena = sceneArena;
    }
  }

  protected void drawFrame(GL gl, float time) {
    gl.glViewport(0, 0, width, height);
    gl.glClearColor(0.05f, 0.045f, 0.08f, 1);
    gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
    load(gl, GL.GL_PROJECTION, perspective(42, (float) width / height, 0.1f, 30f));
    load(gl, GL.GL_MODELVIEW, lookAt(eye, target, v(0, 1, 0)));
    gl.glRotatef(time * 6, 0, 1, 0);

    gl.glEnable(GL.GL_DEPTH_TEST);
    gl.glEnable(GL.GL_NORMALIZE);
    gl.glShadeModel(GL.GL_SMOOTH);

    // Lights
    gl.glEnable(GL.GL_LIGHTING);
    gl.glLightModelfv(GL.GL_LIGHT_MODEL_AMBIENT, floats(arena, 0.06f, 0.06f, 0.08f, 1));
    gl.glLightfv(GL.GL_LIGHT0, GL.GL_DIFFUSE, floats(arena, 1.0f, 0.86f, 0.68f, 1));
    gl.glLightfv(GL.GL_LIGHT0, GL.GL_SPECULAR, floats(arena, 1.0f, 0.9f, 0.8f, 1));
    gl.glLightf(GL.GL_LIGHT0, GL.GL_SPOT_CUTOFF, 32);
    gl.glLightf(GL.GL_LIGHT0, GL.GL_SPOT_EXPONENT, 6);
    gl.glLightfv(GL.GL_LIGHT1, GL.GL_DIFFUSE, floats(arena, 0.22f, 0.34f, 0.62f, 1));
    gl.glLightfv(GL.GL_LIGHT1, GL.GL_SPECULAR, floats(arena, 0.2f, 0.3f, 0.5f, 1));
    gl.glLightf(GL.GL_LIGHT1, GL.GL_LINEAR_ATTENUATION, 0.15f);
    gl.glLightfv(GL.GL_LIGHT2, GL.GL_DIFFUSE, floats(arena, 0.75f, 0.15f, 0.55f, 1));
    gl.glLightfv(GL.GL_LIGHT2, GL.GL_SPECULAR, floats(arena, 0.9f, 0.3f, 0.7f, 1));
    gl.glLightf(GL.GL_LIGHT2, GL.GL_QUADRATIC_ATTENUATION, 0.08f);
    gl.glEnable(GL.GL_LIGHT0);
    gl.glEnable(GL.GL_LIGHT1);
    gl.glEnable(GL.GL_LIGHT2);
    gl.glColorMaterial(GL.GL_FRONT_AND_BACK, GL.GL_AMBIENT_AND_DIFFUSE);
    gl.glEnable(GL.GL_COLOR_MATERIAL);

    // Fog
    gl.glEnable(GL.GL_FOG);
    gl.glFogi(GL.GL_FOG_MODE, GL.GL_LINEAR);
    gl.glFogf(GL.GL_FOG_START, 3.5f);
    gl.glFogf(GL.GL_FOG_END, 9f);
    gl.glFogfv(GL.GL_FOG_COLOR, floats(arena, 0.05f, 0.045f, 0.08f, 1));

    // 1. Reflection : the objects mirrored under the floor, clipped to it
    gl.glPushMatrix();
    gl.glClipPlane(GL.GL_CLIP_PLANE0, arena.allocateFrom(java.lang.foreign.ValueLayout.JAVA_DOUBLE, 0, -1, 0, 0));
    gl.glEnable(GL.GL_CLIP_PLANE0);
    gl.glScalef(1, -1, 1);
    lights(gl);
    gl.glFrontFace(GL.GL_CW);
    gl.glCallList(objects);
    gl.glFrontFace(GL.GL_CCW);
    gl.glDisable(GL.GL_CLIP_PLANE0);
    gl.glPopMatrix();

    // 2. The marble floor, translucent over the reflection
    lights(gl);
    gl.glEnable(GL.GL_BLEND);
    gl.glBlendFunc(GL.GL_SRC_ALPHA, GL.GL_ONE_MINUS_SRC_ALPHA);
    gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_SPECULAR, floats(arena, 0.5f, 0.5f, 0.5f, 1));
    gl.glMaterialf(GL.GL_FRONT_AND_BACK, GL.GL_SHININESS, 30);
    gl.glCallList(floor);
    gl.glDisable(GL.GL_BLEND);

    // 3. The objects
    gl.glCallList(objects);

    // 4. Wide stippled orbit around the objects
    gl.glDisable(GL.GL_LIGHTING);
    gl.glEnable(GL.GL_LINE_STIPPLE);
    gl.glLineStipple(3, (short) 0x5F5F);
    gl.glLineWidth(2.5f);
    gl.glColor3f(0.95f, 0.75f, 0.35f);
    gl.glBegin(GL.GL_LINE_LOOP);
    for (int i = 0; i < 96; i++) {
      double a = 2 * Math.PI * i / 96;
      gl.glVertex3f((float) Math.cos(a) * 1.75f, 0.015f, (float) Math.sin(a) * 1.45f);
    }
    gl.glEnd();
    gl.glDisable(GL.GL_LINE_STIPPLE);
    gl.glLineWidth(1f);

    // 5. Dust in the light : smooth blended points
    gl.glEnable(GL.GL_BLEND);
    gl.glBlendFunc(GL.GL_SRC_ALPHA, GL.GL_ONE);
    gl.glEnable(GL.GL_POINT_SMOOTH);
    gl.glPointSize(3f);
    gl.glBegin(GL.GL_POINTS);
    for (int i = 0; i < dust.length; i += 3) {
      gl.glColor4f(1f, 0.85f, 0.6f, 0.35f);
      gl.glVertex3f(dust[i], dust[i + 1], dust[i + 2]);
    }
    gl.glEnd();
    gl.glDisable(GL.GL_POINT_SMOOTH);
    gl.glPointSize(1f);

    // 6. Glass sphere : translucent, specular, without writing the depth
    gl.glEnable(GL.GL_LIGHTING);
    gl.glBlendFunc(GL.GL_SRC_ALPHA, GL.GL_ONE_MINUS_SRC_ALPHA);
    gl.glDepthMask((byte) 0);
    gl.glPushMatrix();
    gl.glTranslatef(0.55f, 0.3f, 1.25f);
    gl.glColor4f(0.55f, 0.8f, 0.85f, 0.32f);
    gl.glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_SPECULAR, floats(arena, 1, 1, 1, 1));
    gl.glMaterialf(GL.GL_FRONT_AND_BACK, GL.GL_SHININESS, 128);
    MemorySegment quadric = gl.gluNewQuadric();
    gl.gluQuadricNormals(quadric, 100000);
    gl.gluSphere(quadric, 0.3, 40, 28);
    gl.gluDeleteQuadric(quadric);
    gl.glPopMatrix();
    gl.glDepthMask((byte) 1);
    gl.glDisable(GL.GL_BLEND);

    gl.glDisable(GL.GL_FOG);
    gl.glDisable(GL.GL_LIGHTING);
    gl.glDisable(GL.GL_COLOR_MATERIAL);
    gl.glDisable(GL.GL_LIGHT0);
    gl.glDisable(GL.GL_LIGHT1);
    gl.glDisable(GL.GL_LIGHT2);
    gl.glDisable(GL.GL_NORMALIZE);
  }

  @Override
  public void dispose(GL gl) {
    gl.glDeleteLists(objects, 2);
    gl.glDisable(GL.GL_DEPTH_TEST);
  }

  @Override
  public float referenceTime() {
    return 1f;
  }

  @Override
  public int timedFrames() {
    return 10;
  }
}
