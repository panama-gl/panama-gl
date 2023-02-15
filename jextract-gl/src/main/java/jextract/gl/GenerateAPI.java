package jextract.gl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import jextract.gl.java.AcceptsGLMethod;
import jextract.gl.java.AcceptsMethod;

public class GenerateAPI {
  public static String ROOT = "../";
  public static String GL_INTERFACE_SOURCES = ROOT+"panama-gl-api/src/generated/java/";
  public static String GL_MACOS_SOURCES = ROOT+"panama-gl-wrappers-macos/src/generated/java/";
  public static String GL_LINUX_SOURCES = ROOT+"panama-gl-wrappers-linux/src/generated/java/";
  public static String GL_WINDOWS_SOURCES = ROOT+"panama-gl-wrappers-windows/src/generated/java/";
  
  public static String GL_PACKAGE = "panamagl.opengl";

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

  public static class Wrapper {
    Class<?> wrapped;
    // Class<?> wrapped = opengl.ubuntu.v20.glut_h.class;
    AcceptsMethod accepts;
    String className;
    String packge;
    String javaFile;
    List<String> implement = new ArrayList<>();

    public void addImplement(String impl) {
      implement.add(impl);
    }
    public void addImplement(List<String> impl) {
      implement.addAll(impl);
    }

  }

  public static class Interf {
    String packge;
    String javaFolder;
  }

  public void run() throws Exception {
    
    // ============================================================================
    // SPECIFICATION
    
    Interf interf = new Interf();
    interf.javaFolder = GL_INTERFACE_SOURCES + GL_PACKAGE.replace(".", "/") + "/";
    interf.packge = GL_PACKAGE;

    System.out.println("----------------------------------------------------------");
    System.out.println("[Interfaces]");

    List<String> javaInterfacesFiles = interfGen.generateInterfaces(interf.javaFolder, interf.packge);

    interfGen.compile(javaInterfacesFiles);
    
    //List<String> GL = List.of("GL_1");//, "GL_1_2");
    List<String> GL = List.of("GL_1_0", "GL_1_1", "GL_1_2", "GL_1_3");//skip , "GL_1_4"//, "GL_1_5");
    //GL.add("GL_2");
    
    // ============================================================================
    // IMPLEMENTATION
    
    wrapperGen.addUnimplementedMethodsUponMissingBinding = false;
    
    // Configure macOS wrapper
    Wrapper wrapper = new Wrapper();
    wrapper.wrapped = opengl.macos.v10_15_7.glut_h.class;
    wrapper.accepts = new AcceptsGLMethod();
    wrapper.className = "GL_macOS";
    wrapper.packge = GL_PACKAGE;
    wrapper.javaFile = GL_MACOS_SOURCES + GL_PACKAGE.replace(".", "/") + "/" + wrapper.className + ".java";
    wrapper.addImplement(GL);

    // Write and compile
    makeWrapper(javaInterfacesFiles, wrapper);

    // ============================================================================
    // Configure Linux wrapper
    wrapper = new Wrapper();
    wrapper.wrapped = opengl.ubuntu.v20.glut_h.class;
    wrapper.accepts = new AcceptsGLMethod();
    wrapper.className = "GL_linux";
    wrapper.packge = GL_PACKAGE;
    wrapper.javaFile = GL_LINUX_SOURCES + GL_PACKAGE.replace(".", "/") + "/" + wrapper.className + ".java";
    wrapper.addImplement(GL);

    // Write and compile
    makeWrapper(javaInterfacesFiles, wrapper);

    // ============================================================================
    // Configure GLX wrapper
    wrapper = new Wrapper();
    wrapper.wrapped = glx.ubuntu.v20.glx_h.class;
    wrapper.accepts = new AcceptsGLMethod();
    wrapper.className = "GLX_linux";
    wrapper.packge = GL_PACKAGE;
    wrapper.javaFile = GL_LINUX_SOURCES + GL_PACKAGE.replace(".", "/") + "/" + wrapper.className + ".java";
    wrapper.addImplement(GL);

    // Write and compile
    makeWrapper(javaInterfacesFiles, wrapper);

  }

  private void makeWrapper(List<String> javaInterfacesFiles, Wrapper wrapper)
      throws IllegalAccessException, IOException {
    System.out.println("----------------------------------------------------------");
    System.out.println("[Wrapping] " + wrapper.wrapped + " in " + wrapper.className);
    wrapperGen.generateWrapper(wrapper);

    List<String> cmp = new ArrayList<>(javaInterfacesFiles);
    cmp.add(wrapper.javaFile);

    wrapperGen.compile(cmp);
  }

}
