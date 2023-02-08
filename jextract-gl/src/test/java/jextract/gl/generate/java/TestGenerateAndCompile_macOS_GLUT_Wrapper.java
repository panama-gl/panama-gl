package jextract.gl.generate.java;

import java.io.IOException;
import java.util.List;
import org.junit.Test;
import junit.framework.Assert;

public class TestGenerateAndCompile_macOS_GLUT_Wrapper {
  @Test
  public void test() throws IOException {

    
    StringBuffer sb = new StringBuffer();
    
    ClassWriter c = new ClassWriter("panamagl.gen", "GL");
    c.addImport("java.util.List");
    c.addImport("opengl.macos.v10_15_7.glut_h");
    c.addImport("static opengl.macos.v10_15_7.glut_h.*");
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
    Arg a2 = new Arg(String.class, "name");
    Arg out = new Arg(Integer.class);

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
    Assert.assertTrue(java.contains("public class GL {"));
    //Assert.assertTrue(java.contains("  public void glPolygonMode(int frontOrBack, int fill) {"));
    Assert.assertTrue(java.contains("  public void glPolygonOffset(float factor, float unit) {"));
  
  
    c.writeTo(sb, "target/GL.java");
    
    ClassCompiler compiler=  new ClassCompiler();
    Assert.assertTrue(compiler.compile(List.of("target/GL.java")));
  }
}
