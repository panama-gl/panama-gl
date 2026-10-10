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
package jextract.gl.generate.java;

import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import jextract.gl.xml.model.GLCommand;
import opengl.linux.x86.PFNGLCREATEPROGRAMPROC;
import opengl.linux.x86.PFNGLGENBUFFERSPROC;
import opengl.linux.x86.PFNGLGETSTRINGIPROC;

/**
 * Wrappers of functions missing from the static symbols of the bindings, invoked through the
 * function pointer classes of the bindings.
 */
public class TestClassWriter_FunctionPointer {

  ClassWriter writer = new ClassWriter("panamagl.platform.windows.x64", "GL_windows_x64");

  @Test
  public void voidFunction() {
    GLCommand command = new GLCommand("glGenBuffers",
        List.of(new Arg(Integer.class, "n"), new Arg("MemorySegment", "buffers")), "void");

    StringBuffer java = new StringBuffer();

    Assert.assertTrue(writer.wrapperFunctionPointer(java, PFNGLGENBUFFERSPROC.class, command));
    Assert.assertTrue(java.toString(), java.toString().contains("public void glGenBuffers(int n, MemorySegment buffers) {"));
    Assert.assertTrue(java.toString(), java.toString().contains(
        "PFNGLGENBUFFERSPROC.invoke(address(\"glGenBuffers\"), n, buffers);"));
  }

  @Test
  public void functionReturningAValue() {
    GLCommand command = new GLCommand("glCreateProgram", List.of(), "int");

    StringBuffer java = new StringBuffer();

    Assert.assertTrue(writer.wrapperFunctionPointer(java, PFNGLCREATEPROGRAMPROC.class, command));
    Assert.assertTrue(java.toString(), java.toString().contains(
        "return PFNGLCREATEPROGRAMPROC.invoke(address(\"glCreateProgram\"));"));
  }

  @Test
  public void functionReturningAString() {
    GLCommand command = new GLCommand("glGetStringi",
        List.of(new Arg(Integer.class, "name"), new Arg(Integer.class, "index")), "String");

    StringBuffer java = new StringBuffer();

    Assert.assertTrue(writer.wrapperFunctionPointer(java, PFNGLGETSTRINGIPROC.class, command));
    Assert.assertTrue(java.toString(), java.toString().contains("public String glGetStringi(int name, int index) {"));
    Assert.assertTrue(java.toString(), java.toString().contains(
        "return string(PFNGLGETSTRINGIPROC.invoke(address(\"glGetStringi\"), name, index));"));
  }

  @Test
  public void functionPointerNotMatchingTheSpecificationIsNotWritten() {
    GLCommand command = new GLCommand("glGenBuffers", List.of(new Arg(Integer.class, "n")), "void");

    StringBuffer java = new StringBuffer();

    Assert.assertFalse(writer.wrapperFunctionPointer(java, PFNGLGENBUFFERSPROC.class, command));
    Assert.assertFalse(writer.wrapperFunctionPointer(java, String.class, command));
    Assert.assertEquals("", java.toString());
  }

  @Test
  public void constructorRegistersTheFunctionLoader() {
    writer.start();
    writer.constructorWithFunctionLoader("panamagl.platform.windows.GLFunctionLoader_windows");

    Assert.assertTrue(writer.getCode(), writer.getCode().contains("public GL_windows_x64() {"));
    Assert.assertTrue(writer.getCode(), writer.getCode().contains(
        "setFunctionLoader(new panamagl.platform.windows.GLFunctionLoader_windows());"));
  }
}
