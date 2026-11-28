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

/**
 * Triangles stored in vertex buffer objects : positions, normals, optional colors (RGBA) and
 * indices, drawn with the client arrays of OpenGL 1.5, available on every backend.
 */
public class Mesh {
  protected final GL gl;
  protected final int[] buffers = new int[4];
  protected final int count;
  protected final boolean colors;

  public Mesh(GL gl, float[] positions, float[] normals, float[] rgba, int[] indices) {
    this.gl = gl;
    this.count = indices.length;
    this.colors = rgba != null;
    try (Arena arena = Arena.ofConfined()) {
      MemorySegment ids = arena.allocate(ValueLayout.JAVA_INT, 4);
      gl.glGenBuffers(4, ids);
      for (int i = 0; i < 4; i++)
        buffers[i] = ids.getAtIndex(ValueLayout.JAVA_INT, i);
      upload(arena, GL.GL_ARRAY_BUFFER, buffers[0], arena.allocateFrom(ValueLayout.JAVA_FLOAT, positions));
      upload(arena, GL.GL_ARRAY_BUFFER, buffers[1], arena.allocateFrom(ValueLayout.JAVA_FLOAT, normals));
      if (colors)
        upload(arena, GL.GL_ARRAY_BUFFER, buffers[2], arena.allocateFrom(ValueLayout.JAVA_FLOAT, rgba));
      upload(arena, GL.GL_ELEMENT_ARRAY_BUFFER, buffers[3], arena.allocateFrom(ValueLayout.JAVA_INT, indices));
      gl.glBindBuffer(GL.GL_ARRAY_BUFFER, 0);
      gl.glBindBuffer(GL.GL_ELEMENT_ARRAY_BUFFER, 0);
    }
  }

  protected void upload(Arena arena, int target, int id, MemorySegment data) {
    gl.glBindBuffer(target, id);
    gl.glBufferData(target, data.byteSize(), data, GL.GL_STATIC_DRAW);
  }

  public void draw() {
    gl.glBindBuffer(GL.GL_ARRAY_BUFFER, buffers[0]);
    gl.glEnableClientState(GL.GL_VERTEX_ARRAY);
    gl.glVertexPointer(3, GL.GL_FLOAT, 0, MemorySegment.NULL);
    gl.glBindBuffer(GL.GL_ARRAY_BUFFER, buffers[1]);
    gl.glEnableClientState(GL.GL_NORMAL_ARRAY);
    gl.glNormalPointer(GL.GL_FLOAT, 0, MemorySegment.NULL);
    if (colors) {
      gl.glBindBuffer(GL.GL_ARRAY_BUFFER, buffers[2]);
      gl.glEnableClientState(GL.GL_COLOR_ARRAY);
      gl.glColorPointer(4, GL.GL_FLOAT, 0, MemorySegment.NULL);
    }
    gl.glBindBuffer(GL.GL_ELEMENT_ARRAY_BUFFER, buffers[3]);
    gl.glDrawElements(GL.GL_TRIANGLES, count, GL.GL_UNSIGNED_INT, MemorySegment.NULL);

    gl.glDisableClientState(GL.GL_VERTEX_ARRAY);
    gl.glDisableClientState(GL.GL_NORMAL_ARRAY);
    if (colors)
      gl.glDisableClientState(GL.GL_COLOR_ARRAY);
    gl.glBindBuffer(GL.GL_ARRAY_BUFFER, 0);
    gl.glBindBuffer(GL.GL_ELEMENT_ARRAY_BUFFER, 0);
  }

  public int getTriangles() {
    return count / 3;
  }

  public void dispose() {
    try (Arena arena = Arena.ofConfined()) {
      gl.glDeleteBuffers(4, arena.allocateFrom(ValueLayout.JAVA_INT, buffers));
    }
  }

  /** A unit sphere centered on the origin, normals equal to positions. */
  public static Mesh sphere(GL gl, int slices, int stacks) {
    int n = (slices + 1) * (stacks + 1);
    float[] pos = new float[n * 3];
    int k = 0;
    for (int j = 0; j <= stacks; j++) {
      double v = Math.PI * j / stacks;
      for (int i = 0; i <= slices; i++) {
        double u = 2 * Math.PI * i / slices;
        pos[k++] = (float) (Math.sin(v) * Math.cos(u));
        pos[k++] = (float) Math.cos(v);
        pos[k++] = (float) (Math.sin(v) * Math.sin(u));
      }
    }
    int[] idx = new int[slices * stacks * 6];
    k = 0;
    for (int j = 0; j < stacks; j++) {
      for (int i = 0; i < slices; i++) {
        int a = j * (slices + 1) + i, b = a + slices + 1;
        idx[k++] = a; idx[k++] = a + 1; idx[k++] = b;
        idx[k++] = a + 1; idx[k++] = b + 1; idx[k++] = b;
      }
    }
    return new Mesh(gl, pos, pos.clone(), null, idx);
  }
}
