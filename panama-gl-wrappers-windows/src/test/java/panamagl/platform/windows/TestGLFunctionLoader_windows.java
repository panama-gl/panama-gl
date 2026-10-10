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
package panamagl.platform.windows;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import org.junit.Assert;
import org.junit.Test;
import panamagl.opengl.GL;
import panamagl.platform.windows.x64.GL_windows_x64;

/**
 * Check that OpenGL functions that are not exported as static symbols by opengl32.dll (VBO, shaders,
 * ...) are resolved at runtime with wglGetProcAddress.
 */
// VM ARGS : --enable-native-access=ALL-UNNAMED -Djava.library.path="C:\Windows\system32;<freeglut x64 bin>"
public class TestGLFunctionLoader_windows extends WindowsTest {

  @Test
  public void glHasAFunctionLoader() {
    if (!checkPlatform())
      return;

    GL_windows_x64 gl = new GL_windows_x64();

    Assert.assertTrue(gl.getFunctionLoader() instanceof GLFunctionLoader_windows);
  }

  @Test
  public void unresolvedFunctionThrowsAnExplicitException() {
    if (!checkPlatform())
      return;

    GL_windows_x64 gl = new GL_windows_x64();
    gl.setFunctionLoader(function -> MemorySegment.NULL);

    try (Arena arena = Arena.ofConfined()) {
      gl.glGenBuffers(1, arena.allocate(ValueLayout.JAVA_INT));
      Assert.fail("expect an exception");
    } catch (UnsupportedOperationException e) {
      Assert.assertTrue(e.getMessage(), e.getMessage().contains("glGenBuffers"));
    }
  }

  @Test
  public void gl11FunctionsAreResolvedInLoadedOpengl32() {
    if (!checkPlatform())
      return;

    WGLContext_windows context = new WGLContext_windows();
    context.init();
    context.makeCurrent();

    try {
      GLFunctionLoader_windows loader = new GLFunctionLoader_windows();

      // wglGetProcAddress returns nothing for GL 1.1 functions, which are found in the opengl32.dll
      // loaded by NativeLibLoader
      Assert.assertNotEquals(MemorySegment.NULL, loader.getProcAddress("glClear"));

      // Unknown functions are not resolved
      Assert.assertEquals(MemorySegment.NULL, loader.getProcAddress("glNotAnOpenGLFunction"));
    } finally {
      context.destroy();
    }
  }

  @Test
  public void vertexBufferObjects() {
    if (!checkPlatform())
      return;

    WGLContext_windows context = new WGLContext_windows();
    context.init();
    context.makeCurrent();

    try (Arena arena = Arena.ofConfined()) {
      GL gl = new GL_windows_x64();

      // When generating a buffer
      MemorySegment ids = arena.allocate(ValueLayout.JAVA_INT);
      gl.glGenBuffers(1, ids);
      int id = ids.get(ValueLayout.JAVA_INT, 0);

      // Then
      Assert.assertTrue(id > 0);

      // When filling the buffer
      float[] vertices = {0, 0, 0, 1, 0, 0, 0, 1, 0};
      MemorySegment data = arena.allocateFrom(ValueLayout.JAVA_FLOAT, vertices);

      gl.glBindBuffer(GL.GL_ARRAY_BUFFER, id);
      gl.glBufferData(GL.GL_ARRAY_BUFFER, data.byteSize(), data, GL.GL_STATIC_DRAW);

      // Then the buffer has the expected size
      MemorySegment size = arena.allocate(ValueLayout.JAVA_INT);
      gl.glGetBufferParameteriv(GL.GL_ARRAY_BUFFER, GL.GL_BUFFER_SIZE, size);

      Assert.assertEquals(vertices.length * Float.BYTES, size.get(ValueLayout.JAVA_INT, 0));
      Assert.assertEquals(1, gl.glIsBuffer(id));

      // When deleting the buffer
      gl.glBindBuffer(GL.GL_ARRAY_BUFFER, 0);
      gl.glDeleteBuffers(1, ids);

      // Then
      Assert.assertEquals(0, gl.glIsBuffer(id));
      Assert.assertEquals(GL.GL_NO_ERROR, gl.glGetError());
    } finally {
      context.destroy();
    }
  }

  @Test
  public void shaders() {
    if (!checkPlatform())
      return;

    WGLContext_windows context = new WGLContext_windows();
    context.init();
    context.makeCurrent();

    try (Arena arena = Arena.ofConfined()) {
      GL gl = new GL_windows_x64();

      int vertex = compile(gl, arena, GL.GL_VERTEX_SHADER,
          "#version 110\n uniform float scale; void main() { gl_Position = gl_Vertex * scale; }");
      int fragment = compile(gl, arena, GL.GL_FRAGMENT_SHADER,
          "#version 110\n void main() { gl_FragColor = vec4(1.0, 0.0, 0.0, 1.0); }");

      // When linking a program
      int program = gl.glCreateProgram();
      gl.glAttachShader(program, vertex);
      gl.glAttachShader(program, fragment);
      gl.glLinkProgram(program);

      // Then
      MemorySegment status = arena.allocate(ValueLayout.JAVA_INT);
      gl.glGetProgramiv(program, GL.GL_LINK_STATUS, status);
      Assert.assertEquals(GL.GL_TRUE, status.get(ValueLayout.JAVA_INT, 0));

      // When using the program
      gl.glUseProgram(program);
      int scale = gl.glGetUniformLocation(program, arena.allocateFrom("scale"));
      gl.glUniform1f(scale, 2f);

      // Then
      Assert.assertTrue(scale >= 0);
      Assert.assertEquals(GL.GL_NO_ERROR, gl.glGetError());

      gl.glUseProgram(0);
      gl.glDeleteProgram(program);
      gl.glDeleteShader(vertex);
      gl.glDeleteShader(fragment);
    } finally {
      context.destroy();
    }
  }

  protected int compile(GL gl, Arena arena, int type, String source) {
    int shader = gl.glCreateShader(type);
    Assert.assertTrue(shader > 0);

    MemorySegment sources = arena.allocate(ValueLayout.ADDRESS);
    sources.set(ValueLayout.ADDRESS, 0, arena.allocateFrom(source));
    gl.glShaderSource(shader, 1, sources, MemorySegment.NULL);
    gl.glCompileShader(shader);

    MemorySegment status = arena.allocate(ValueLayout.JAVA_INT);
    gl.glGetShaderiv(shader, GL.GL_COMPILE_STATUS, status);
    Assert.assertEquals(GL.GL_TRUE, status.get(ValueLayout.JAVA_INT, 0));
    return shader;
  }
}
