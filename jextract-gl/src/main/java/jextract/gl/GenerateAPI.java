package jextract.gl;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import jextract.gl.generate.java.Arg;
import jextract.gl.generate.java.ClassCompiler;
import jextract.gl.generate.java.ClassWriter;
import jextract.gl.generate.java.Code;
import jextract.gl.generate.java.Interf;
import jextract.gl.generate.java.InterfaceWriter;
import jextract.gl.generate.java.PlatformFactory;
import jextract.gl.generate.java.Wrapper;
import jextract.gl.java.AcceptsGLMethod;
import panamagl.os.linux.APanamaGLFactory_linux;
import panamagl.os.macos.APanamaGLFactory_macOS;

public class GenerateAPI {
  public static String ROOT = "../";
  public static String GL_INTERFACE_SOURCES = ROOT+"panama-gl-api/src/generated/java/";
  public static String GL_MACOS_SOURCES = ROOT+"panama-gl-wrappers-macos/src/generated/java/";
  public static String GL_LINUX_SOURCES = ROOT+"panama-gl-wrappers-linux/src/generated/java/";
  public static String GL_WINDOWS_SOURCES = ROOT+"panama-gl-wrappers-windows/src/generated/java/";
  
  public static String GL_PACKAGE = "panamagl.opengl";
  
  /*public static String GL_PACKAGE_MACOS = "panamagl.platform.macos";
  public static String GL_PACKAGE_LINUX = "panamagl.platform.linux";
  public static String GL_PACKAGE_WINDOWS = "panamagl.platform.windows";*/

  public static String GL_PACKAGE_MACOS_x86 = "panamagl.platform.macos.x86";
  public static String GL_PACKAGE_LINUX_x86 = "panamagl.platform.linux.x86";
  public static String GL_PACKAGE_WINDOWS_x86 = "panamagl.platform.windows.x86";
  
  public static String GL_IMPL = "GLImpl";

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

  //enum Platform{ MACOS, LINUX}


  public void run() throws Exception {
    
    // ============================================================================
    // GL SPECIFICATION
    
    Interf interf = new Interf();
    interf.packge = GL_PACKAGE;
    interf.javaFolder = GL_INTERFACE_SOURCES + interf.packge.replace(".", "/") + "/";
    
    
    
    System.out.println("----------------------------------------------------------");
    System.out.println("[Interfaces]");

    String superGL = "GL";
    InterfaceWriter glInterfaceWriter = new InterfaceWriter(interf.packge, superGL);
    
    glInterfaceWriter.addExtension("GL_1");
    glInterfaceWriter.addExtension("GL_2");
    glInterfaceWriter.addExtension("GLU");
    glInterfaceWriter.addExtension("GLUT");
    
    StringBuffer javaCode = new StringBuffer();

    String javaFile = interf.javaFolder + "/"+superGL+".java";
    glInterfaceWriter.start(javaCode);
    glInterfaceWriter.close(javaCode);    
    glInterfaceWriter.writeTo(javaCode, javaFile);

    
    
    List<String> javaInterfacesFiles = interfGen.generateInterfaces(interf);

    
    // ============================================================================
    // GL IMPLEMENTATION
    
    boolean MACOS = true;
    boolean LINUX = true;
    
    wrapperGen.addUnimplementedMethodsUponMissingBinding = false;
    //wrapperGen.addUnimplementedMethodsFor = Sets.of("glDebugMessageCallback");
    wrapperGen.skipAlreadyBindedMethodNAME = true;
    
    Wrapper wrapper;
    PlatformFactory factory;
    
    // ========================================================
    // Configure macOS wrapper
    
    if(MACOS) {
      wrapper = new Wrapper();
      wrapper.platform = "macOS_x86";
      wrapper.wrapped = Set.of(opengl.macos.v10_15_7.glut_h.class, glext.macos.v10_15_7.glext_h.class, cgl.macos.v10_15_7.cgl_h.class);
      wrapper.accepts = new AcceptsGLMethod();
      wrapper.className = GL_IMPL;
      wrapper.packge = GL_PACKAGE_MACOS_x86;
      wrapper.setFileIn(GL_MACOS_SOURCES);
  
      wrapper.addImplement(interf.packge + "." + superGL);
      wrapper.addImplement(interf.packge + ".GLU");
      wrapper.addImplement(interf.packge + ".GLUT");
      
      // Write and compile
      List<Method> extra = makeWrapper(javaInterfacesFiles, wrapper);
      
      // Create GLU et GLUT interface
      InterfaceWriter gluWriter = new InterfaceWriter(interf.packge, "GLU");
      InterfaceWriter glutWriter = new InterfaceWriter(interf.packge, "GLUT");
      String glutFile = interf.javaFolder + "/GLUT.java";
      String gluFile = interf.javaFolder + "/GLU.java";

      StringBuffer glutCode= new StringBuffer();
      StringBuffer gluCode= new StringBuffer();   
      
      glutWriter.start(glutCode);
      gluWriter.start(gluCode);
      for(Method method: extra) {
        if(method.getName().startsWith("glut") && ! method.getName().contains("$")) {
          glutWriter.method(glutCode, method);
        }
        else if(method.getName().startsWith("glu") && ! method.getName().contains("$")) {
          gluWriter.method(gluCode, method);
        }
      }
      glutWriter.close(glutCode);
      gluWriter.close(gluCode);
      
      glutWriter.writeTo(glutCode, glutFile);
      gluWriter.writeTo(gluCode, gluFile);
      
      // Configure macOS factory
      factory = new PlatformFactory();
      factory.base = APanamaGLFactory_macOS.class;
      factory.name = "PanamaGLFactory_" + wrapper.platform;
      factory.packge = GL_PACKAGE_MACOS_x86;
      factory.setFileIn(GL_MACOS_SOURCES);
      
      makeFactory(javaInterfacesFiles, wrapper, factory);
    }
    
    // Compile ALL
    compile(javaInterfacesFiles);


    // ========================================================
    // Configure Linux wrapper
    if(LINUX) {
      wrapper = new Wrapper();
      wrapper.platform = "linux_x86";
      wrapper.wrapped = Set.of(opengl.ubuntu.v20.glut_h.class, glext.ubuntu.v20.glext_h.class, glxext.ubuntu.v20.glxext_h.class);
      wrapper.accepts = new AcceptsGLMethod();
      wrapper.className = GL_IMPL;
      wrapper.packge = GL_PACKAGE_LINUX_x86;
      wrapper.setFileIn(GL_LINUX_SOURCES);
      wrapper.addImplement(interf.packge + "." + superGL);
      wrapper.addImplement(interf.packge + ".GLU");
      wrapper.addImplement(interf.packge + ".GLUT");

      // Write and compile
      List<Method> extra = makeWrapper(javaInterfacesFiles, wrapper);
  
      // Configure Linux factory
      factory = new PlatformFactory();
      factory.base = APanamaGLFactory_linux.class;
      factory.name = "PanamaGLFactory_" + wrapper.platform;
      factory.packge = GL_PACKAGE_LINUX_x86;
      factory.setFileIn(GL_LINUX_SOURCES);
      
      makeFactory(javaInterfacesFiles, wrapper, factory);

    }    
    
    // Compile ALL
    compile(javaInterfacesFiles);
  }




  private void makeFactory(List<String> javaInterfacesFiles, Wrapper wrapper,
      PlatformFactory factory) throws IOException {
    ClassWriter factoryWriter = new ClassWriter(factory.packge, factory.name);
    factoryWriter.addExtension(factory.base.getName());
    
    Code c = new Code("return new " + wrapper.packge + "." + wrapper.className + "();");
    
    StringBuffer javaCode = new StringBuffer();
    factoryWriter.start(javaCode);
    factoryWriter.method(javaCode, "newGL", null, new Arg(/*wrapper.packge +*/ "panamagl.opengl.GL", "out"), c);
    //factoryWriter.method(javaCode, "newGL", null, new Arg("panamagl.opengl.GL", "out"), Code.throwNotImplemented());
    factoryWriter.close(javaCode);
    factoryWriter.writeTo(javaCode, factory.javaFile);
    
    javaInterfacesFiles.add(factory.javaFile);
  }


  protected List<Method> makeWrapper(List<String> javaInterfacesFiles, Wrapper wrapper)
      throws IllegalAccessException, IOException {
    List<String> cmp = new ArrayList<>(javaInterfacesFiles);
    cmp.add(wrapper.javaFile);
    
    System.out.println("----------------------------------------------------------");
    System.out.println("[Wrapping] " + wrapper.wrapped + " in " + wrapper.className);
    wrapperGen.generateWrapper(wrapper);
    return wrapperGen.getAutoWrappedMethods();
  }
  
  public void compile(List<String> javaFile) throws IOException {
    ClassCompiler c = new ClassCompiler();
    c.compile(javaFile);
  }


}
