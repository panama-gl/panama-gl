package jextract.gl;

import java.util.ArrayList;
import java.util.List;
import jextract.gl.java.AcceptsGLMethod;
import jextract.gl.java.AcceptsMethod;

public class GenerateAPI {
  public static void main(String[] args) throws Exception {
    GenerateAPI gen = new GenerateAPI();
    gen.run();
  }

  GenerateInterfaceFromRegistry interfGen;
  GenerateWrapperFromBindings wrapperGen;

  public GenerateAPI() throws Exception {
    interfGen = new GenerateInterfaceFromRegistry();
    wrapperGen = new GenerateWrapperFromBindings();
  }
  
  public static class Wrapper{
    Class<?> wrapped;
    //Class<?> wrapped = opengl.ubuntu.v20.glut_h.class;
    AcceptsMethod accepts ;
    String className;
    String javaFile;
    List<String> implement = new ArrayList<>();
    
    public void addImplement(String impl) {
      implement.add(impl);
    }
  }
  
  public static class Interf{
    String packge;
    String javaFolder;
  }
  
  public void run() throws Exception {
    Interf interf = new Interf();
    interf.javaFolder = "target/";
    interf.packge = "panama.opengl";

    System.out.println("----------------------------------------------------------");
    System.out.println("[Interfaces]");

    List<String> javaInterfaces = interfGen.generateInterfaces(interf.javaFolder, interf.packge);

    interfGen.compile(javaInterfaces);

    // ============================================================================
    // Configure macOS wrapper 
    Wrapper wrapper = new Wrapper();
    wrapper.wrapped = opengl.macos.v10_15_7.glut_h.class;
    
    wrapper.addImplement(interf.packge  + ".GL_1_0");
    wrapper.addImplement(interf.packge  + ".GL_1_1");
    wrapper.addImplement(interf.packge  + ".GL_1_2");
    
    wrapper.accepts = new AcceptsGLMethod();
    wrapper.className = "GL_macOS";
    wrapper.javaFile = "target/"+wrapper.className+".java";

    // Write and compile
    System.out.println("----------------------------------------------------------");
    System.out.println("[Wrapping] " + wrapper.wrapped + " in " + wrapper.className);
    wrapperGen.generateWrapper(wrapper);
    
    List<String> cmp = new ArrayList<>(javaInterfaces);
    cmp.add(wrapper.javaFile);
    
    wrapperGen.compile(cmp);
    
    // ============================================================================
    // Configure Linux wrapper 
    wrapper = new Wrapper();
    wrapper.wrapped = opengl.ubuntu.v20.glut_h.class;
    wrapper.accepts = new AcceptsGLMethod();
    wrapper.className = "GL_linux";
    wrapper.javaFile = "target/"+wrapper.className+".java";

    // Write and compile
    System.out.println("----------------------------------------------------------");
    System.out.println("[Wrapping] " + wrapper.wrapped + " in " + wrapper.className);
    wrapperGen.generateWrapper(wrapper);
    wrapperGen.compile(List.of(wrapper.javaFile));
    
    // ============================================================================
    // Configure GLX wrapper 
    wrapper = new Wrapper();
    wrapper.wrapped = glx.ubuntu.v20.glx_h.class;
    wrapper.accepts = new AcceptsGLMethod();
    wrapper.className = "GLX_linux";
    wrapper.javaFile = "target/"+wrapper.className+".java";

    // Write and compile
    System.out.println("----------------------------------------------------------");
    System.out.println("Wrapping " + wrapper.wrapped + " in " + wrapper.className);
    wrapperGen.generateWrapper(wrapper);
    wrapperGen.compile(List.of(wrapper.javaFile));

  }

}
