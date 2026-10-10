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
package jextract.gl.xml.model;

import org.junit.Assert;
import org.junit.Test;

public class TestGLCommand {
  @Test
  public void commandsReturningAPointerAreMappedToMemorySegment() {
    for (String name : new String[] {"glMapBuffer", "glMapBufferRange", "glMapNamedBuffer",
        "glMapNamedBufferRange", "glGetString"}) {
      Assert.assertEquals(name, GLTypeInJava.ADDRESSABLE, new GLCommand(name, "void").getJavaOutputType());
    }
  }

  @Test
  public void otherCommandsKeepTheirOutputType() {
    Assert.assertEquals("int", new GLCommand("glGetError", "int").getJavaOutputType());
    Assert.assertEquals("void", new GLCommand("glFlush", "void").getJavaOutputType());
  }
}
