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
import java.util.HashMap;
import java.util.Map;
import panamagl.opengl.GL;

/** A GLSL program : compiles, links and sets uniforms, reporting the compiler log on failure. */
public class GLSL {
  protected final GL gl;
  protected final int program;
  protected final Map<String, Integer> locations = new HashMap<>();

  public GLSL(GL gl, String vertex, String fragment) {
    this.gl = gl;
    int vs = compile(GL.GL_VERTEX_SHADER, vertex);
    int fs = compile(GL.GL_FRAGMENT_SHADER, fragment);
    program = gl.glCreateProgram();
    gl.glAttachShader(program, vs);
    gl.glAttachShader(program, fs);
    gl.glLinkProgram(program);
    try (Arena arena = Arena.ofConfined()) {
      MemorySegment status = arena.allocate(ValueLayout.JAVA_INT);
      gl.glGetProgramiv(program, GL.GL_LINK_STATUS, status);
      if (status.get(ValueLayout.JAVA_INT, 0) != GL.GL_TRUE) {
        MemorySegment log = arena.allocate(8192);
        gl.glGetProgramInfoLog(program, 8192, MemorySegment.NULL, log);
        throw new IllegalStateException("GLSL link failed : " + log.getString(0));
      }
    }
    gl.glDeleteShader(vs);
    gl.glDeleteShader(fs);
  }

  protected int compile(int type, String source) {
    int shader = gl.glCreateShader(type);
    try (Arena arena = Arena.ofConfined()) {
      MemorySegment sources = arena.allocate(ValueLayout.ADDRESS);
      sources.set(ValueLayout.ADDRESS, 0, arena.allocateFrom(source));
      gl.glShaderSource(shader, 1, sources, MemorySegment.NULL);
      gl.glCompileShader(shader);
      MemorySegment status = arena.allocate(ValueLayout.JAVA_INT);
      gl.glGetShaderiv(shader, GL.GL_COMPILE_STATUS, status);
      if (status.get(ValueLayout.JAVA_INT, 0) != GL.GL_TRUE) {
        MemorySegment log = arena.allocate(8192);
        gl.glGetShaderInfoLog(shader, 8192, MemorySegment.NULL, log);
        throw new IllegalStateException((type == GL.GL_VERTEX_SHADER ? "Vertex" : "Fragment")
            + " shader compilation failed : " + log.getString(0));
      }
    }
    return shader;
  }

  public void use() {
    gl.glUseProgram(program);
  }

  public static void none(GL gl) {
    gl.glUseProgram(0);
  }

  protected int location(String name) {
    return locations.computeIfAbsent(name, n -> {
      try (Arena arena = Arena.ofConfined()) {
        return gl.glGetUniformLocation(program, arena.allocateFrom(n));
      }
    });
  }

  public GLSL set(String name, float v) {
    gl.glUniform1f(location(name), v);
    return this;
  }

  public GLSL set(String name, float x, float y) {
    gl.glUniform2f(location(name), x, y);
    return this;
  }

  public GLSL set(String name, float x, float y, float z) {
    gl.glUniform3f(location(name), x, y, z);
    return this;
  }

  public GLSL set(String name, float[] v3) {
    return set(name, v3[0], v3[1], v3[2]);
  }

  public GLSL setInt(String name, int v) {
    gl.glUniform1i(location(name), v);
    return this;
  }

  public void dispose() {
    gl.glDeleteProgram(program);
  }
}
