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
