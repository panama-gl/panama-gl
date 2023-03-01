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

import java.io.IOException;
import java.util.List;
import org.junit.Test;
import junit.framework.Assert;

public class TestInterfaceWriter {
  @Test
  public void test() throws IOException {

    
    StringBuffer sb = new StringBuffer();
    
    InterfaceWriter c = new InterfaceWriter("panamagl.gen", "GL");
    c.addImport("java.util.List");
    c.start(sb);
    

    /*Arg r = new Arg("float", "r");
    Arg g = new Arg("float", "g");
    Arg b = new Arg("float", "b");
    Arg a = new Arg("float", "a");
    c.method(sb, "glColor4f", List.of(r,g,b,a), null, null);*/
    

    // End class
    c.close(sb);
    
    // The
    /*String java = sb.toString();
    
    System.out.println(java);
    
    Assert.assertTrue(java.contains("package panamagl.gen;"));
    Assert.assertTrue(java.contains("import java.util.List;"));
    Assert.assertTrue(java.contains("public class GL"));
    Assert.assertTrue(java.contains("  public void glPolygonOffset(float factor, float unit) {"));
  
  
    c.writeTo(sb, "target/GL.java");
    
    ClassCompiler compiler=  new ClassCompiler();
    Assert.assertTrue(compiler.compile(List.of("target/GL.java")));*/
  }
}
