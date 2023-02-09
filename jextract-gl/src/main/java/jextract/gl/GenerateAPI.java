package jextract.gl;

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
  
  public void run() throws Exception {
    List<String> javaFiles = interfGen.generateInterfaces("target/");

    interfGen.compile(javaFiles);

    
    // Configure wrapper 
    Class<?> wrapped = opengl.macos.v10_15_7.glut_h.class;
    //Class<?> wrapped = opengl.ubuntu.v20.glut_h.class;
    AcceptsMethod accepts = new AcceptsGLMethod();
    String className = "GL_macOS";
    String javaFile = "target/"+className+".java";

    // Write class
    wrapperGen.generateWrapper(wrapped, accepts, className, javaFile);

    // Compile class
    wrapperGen.compile(List.of(javaFile));

  }
  

}
