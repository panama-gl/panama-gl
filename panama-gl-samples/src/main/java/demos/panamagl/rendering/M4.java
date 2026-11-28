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

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import panamagl.opengl.GL;

/** Column major 4x4 matrices and 3D vectors, to know the camera of a scene on the Java side. */
public class M4 {
  public static float[] perspective(float fovyDegrees, float aspect, float near, float far) {
    float f = (float) (1 / Math.tan(Math.toRadians(fovyDegrees) / 2));
    float[] m = new float[16];
    m[0] = f / aspect;
    m[5] = f;
    m[10] = (far + near) / (near - far);
    m[11] = -1;
    m[14] = 2 * far * near / (near - far);
    return m;
  }

  public static float[] lookAt(float[] eye, float[] center, float[] up) {
    float[] f = normalize(sub(center, eye));
    float[] s = normalize(cross(f, up));
    float[] u = cross(s, f);
    float[] m = new float[16];
    m[0] = s[0]; m[4] = s[1]; m[8] = s[2];
    m[1] = u[0]; m[5] = u[1]; m[9] = u[2];
    m[2] = -f[0]; m[6] = -f[1]; m[10] = -f[2];
    m[12] = -dot(s, eye);
    m[13] = -dot(u, eye);
    m[14] = dot(f, eye);
    m[15] = 1;
    return m;
  }

  /** Transform a direction by the upper 3x3 part of a matrix. */
  public static float[] direction(float[] m, float[] v) {
    return new float[] {m[0] * v[0] + m[4] * v[1] + m[8] * v[2],
        m[1] * v[0] + m[5] * v[1] + m[9] * v[2], m[2] * v[0] + m[6] * v[1] + m[10] * v[2]};
  }

  public static void load(GL gl, int mode, float[] m) {
    gl.glMatrixMode(mode);
    try (Arena arena = Arena.ofConfined()) {
      gl.glLoadMatrixf(arena.allocateFrom(ValueLayout.JAVA_FLOAT, m));
    }
  }

  public static float[] v(double x, double y, double z) {
    return new float[] {(float) x, (float) y, (float) z};
  }

  public static float[] sub(float[] a, float[] b) {
    return new float[] {a[0] - b[0], a[1] - b[1], a[2] - b[2]};
  }

  public static float[] add(float[] a, float[] b) {
    return new float[] {a[0] + b[0], a[1] + b[1], a[2] + b[2]};
  }

  public static float[] scale(float[] a, float s) {
    return new float[] {a[0] * s, a[1] * s, a[2] * s};
  }

  public static float dot(float[] a, float[] b) {
    return a[0] * b[0] + a[1] * b[1] + a[2] * b[2];
  }

  public static float[] cross(float[] a, float[] b) {
    return new float[] {a[1] * b[2] - a[2] * b[1], a[2] * b[0] - a[0] * b[2],
        a[0] * b[1] - a[1] * b[0]};
  }

  public static float[] normalize(float[] a) {
    float l = (float) Math.sqrt(dot(a, a));
    return new float[] {a[0] / l, a[1] / l, a[2] / l};
  }

  public static MemorySegment floats(Arena arena, float... values) {
    return arena.allocateFrom(ValueLayout.JAVA_FLOAT, values);
  }
}
