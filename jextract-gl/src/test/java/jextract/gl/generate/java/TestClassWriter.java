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

public class TestClassWriter {
  @Test
  public void test() throws IOException {

    
    StringBuffer sb = new StringBuffer();
    
    ClassWriter c = new ClassWriter("panamagl.gen", "GL");
    c.addImport("java.util.List");
    c.addImport("opengl.macos.x86.glut_h");
    c.addImport("static opengl.macos.x86.glut_h.*");
    c.start(sb);
    
    
    // Generate s void methods
    String wrappedBinding = "glut_h";

    Arg a1 = new Arg(Integer.class, "value");

    c.wrapper(sb, "glBegin", List.of(a1), wrappedBinding);
    c.wrapper(sb, "glEnd", wrappedBinding);
    
    Arg p1 = new Arg(Integer.class, "frontOrBack");
    Arg p2 = new Arg(Integer.class, "fill");
    
    c.wrapper(sb, "glPolygonMode", List.of(p1, p2), wrappedBinding);      

    p1 = new Arg(Float.class, "factor");
    p2 = new Arg(Float.class, "unit");
    c.wrapper(sb, "glPolygonOffset", List.of(p1, p2), wrappedBinding);      

    
    // Generates a method with arguments
    //Arg a1 = new Arg(Integer.class, "value");
    //Arg a2 = new Arg(String.class, "name");
    //Arg out = new Arg(Integer.class);

    //c.method(sb, "method", List.of(a1, a2), out, List.of(new Code("glut_h.glPolygonMode(name, value);")), null);
    
    // Generates wrapper methods following gl patterns
    /*List<String> wrappedMethodNames = List.of("glWrappedMethod", "glWrappedMethod2");
    
    for(String wrappedMethodName: wrappedMethodNames) {
      c.wrapper(sb, wrappedMethodName, List.of(a1, a2), out, wrappedBinding, null);      
    }*/

    // End class
    c.close(sb);
    
    // The
    String java = sb.toString();
    
    System.out.println(java);
    
    Assert.assertTrue(java.contains("package panamagl.gen;"));
    Assert.assertTrue(java.contains("import java.util.List;"));
    Assert.assertTrue(java.contains("public class GL"));
    Assert.assertTrue(java.contains("  public void glPolygonOffset(float factor, float unit) {"));
  
  
    c.writeTo(sb, "target/GL.java");
    
    ClassCompiler compiler=  new ClassCompiler();
    Assert.assertTrue(compiler.compile(List.of("target/GL.java")));
  }
}
