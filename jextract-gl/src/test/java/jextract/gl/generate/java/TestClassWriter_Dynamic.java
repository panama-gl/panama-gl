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

/** Wrappers of functions missing from the bindings, resolved at runtime by a function loader. */
public class TestClassWriter_Dynamic {

  ClassWriter writer = new ClassWriter("panamagl.platform.windows.x64", "GL_windows_x64");

  @Test
  public void voidFunction() {
    GLCommand command = new GLCommand("glGenBuffers",
        List.of(new Arg(Integer.class, "n"), new Arg("MemorySegment", "buffers")), "void");

    StringBuffer java = new StringBuffer();

    Assert.assertTrue(writer.wrapperDynamic(java, command));
    Assert.assertTrue(java.toString(), java.toString().contains("public void glGenBuffers(int n, MemorySegment buffers) {"));
    Assert.assertTrue(java.toString(), java.toString().contains(
        "dynamic(\"glGenBuffers\", () -> FunctionDescriptor.ofVoid(ValueLayout.JAVA_INT, ValueLayout.ADDRESS)).invokeExact(n, buffers);"));
    Assert.assertTrue(java.toString(), java.toString().contains("throw dynamicError(\"glGenBuffers\", e);"));
  }

  @Test
  public void functionReturningAValue() {
    GLCommand command = new GLCommand("glCreateProgram", List.of(), "int");

    StringBuffer java = new StringBuffer();

    Assert.assertTrue(writer.wrapperDynamic(java, command));
    Assert.assertTrue(java.toString(), java.toString().contains(
        "return (int) dynamic(\"glCreateProgram\", () -> FunctionDescriptor.of(ValueLayout.JAVA_INT)).invokeExact();"));
  }

  @Test
  public void functionReturningAString() {
    GLCommand command = new GLCommand("glGetStringi",
        List.of(new Arg(Integer.class, "name"), new Arg(Integer.class, "index")), "String");

    StringBuffer java = new StringBuffer();

    Assert.assertTrue(writer.wrapperDynamic(java, command));
    Assert.assertTrue(java.toString(), java.toString().contains(
        "return dynamicString((MemorySegment) dynamic(\"glGetStringi\", () -> FunctionDescriptor.of(ValueLayout.ADDRESS, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT)).invokeExact(name, index));"));
  }

  @Test
  public void functionReturningAPointer() {
    GLCommand command = new GLCommand("glMapBuffer",
        List.of(new Arg(Integer.class, "target"), new Arg(Integer.class, "access")), "void");

    StringBuffer java = new StringBuffer();

    Assert.assertTrue(writer.wrapperDynamic(java, command));
    Assert.assertTrue(java.toString(), java.toString().contains(
        "return (MemorySegment) dynamic(\"glMapBuffer\", () -> FunctionDescriptor.of(ValueLayout.ADDRESS, ValueLayout.JAVA_INT, ValueLayout.JAVA_INT)).invokeExact(target, access);"));
  }

  @Test
  public void unsupportedTypeIsNotWritten() {
    GLCommand command =
        new GLCommand("glDebugMessageCallback", List.of(new Arg("Object", "callback")), "void");

    StringBuffer java = new StringBuffer();

    Assert.assertFalse(writer.wrapperDynamic(java, command));
    Assert.assertEquals("", java.toString());
  }

  @Test
  public void constructorRegistersTheFunctionLoader() {
    StringBuffer java = new StringBuffer();

    writer.constructorWithFunctionLoader(java, "panamagl.platform.windows.GLFunctionLoader_windows");

    Assert.assertTrue(java.toString(), java.toString().contains("public GL_windows_x64() {"));
    Assert.assertTrue(java.toString(), java.toString().contains(
        "setFunctionLoader(new panamagl.platform.windows.GLFunctionLoader_windows());"));
  }
}
