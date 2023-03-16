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
import panamagl.platform.Platform;
import panamagl.platform.linux.APanamaGLFactory_linux;
import panamagl.platform.macos.APanamaGLFactory_macOS;
import panamagl.platform.macos.arm.PlatformMatcher_macOS_arm;
import panamagl.platform.macos.x86.PlatformMatcher_macOS_x86;
import panamagl.platform.windows.APanamaGLFactory_windows;

/**
 * Generate an OpenGL API with per-platform implementations wrapping the bindings made available by JExtract.
 * <br>
 * 
 * The API roughly takes the bellow form :
 * 
 * 
 * <img src="doc-files/JExtract-GL.png"/>
 * 
 * @author Martin Pernollet
 *
 */
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
  public static String GL_PACKAGE_MACOS_arm = "panamagl.platform.macos.arm";
  public static String GL_PACKAGE_LINUX_x86 = "panamagl.platform.linux.x86";
  public static String GL_PACKAGE_WINDOWS_x64 = "panamagl.platform.windows.x64";
  
  //public static String GL_IMPL = "GLImpl";

  public static void main(String[] args) throws Exception {
    GenerateAPI gen = new GenerateAPI();
    gen.run();
  }

  GenerateAPI_GL_Interface interfGen;
  GenerateAPI_GL_Wrapper wrapperGen;

  public GenerateAPI() throws Exception {
    interfGen = new GenerateAPI_GL_Interface();
    wrapperGen = new GenerateAPI_GL_Wrapper();
  }

  /**
   * 
   * @throws Exception
   */
  public void run() throws Exception {
    
    boolean MACOS_x86 = false;
    boolean MACOS_ARM = false;
    boolean LINUX_x86 = false;
    boolean WINDOWS_x86 = true;
    
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
    //glInterfaceWriter.addExtension("GL_3");
    //glInterfaceWriter.addExtension("GL_4");
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
    

    
    wrapperGen.addUnimplementedMethodsUponMissingBinding = false;
    //wrapperGen.addUnimplementedMethodsFor = Sets.of("glDebugMessageCallback");
    wrapperGen.skipAlreadyBindedMethodNAME = true;
    
    Wrapper wrapper;
    PlatformFactory factory;
    
    // ========================================================
    // Configure macOS wrapper
    
    if(MACOS_x86) {
      wrapper = new Wrapper();
      wrapper.platform = "macOS_x86";
      wrapper.wrapped = Set.of(opengl.macos.x86.glut_h.class/*, glext.macos.v10_15_7.glext_h.class, cgl.macos.v10_15_7.cgl_h.class*/);
      wrapper.accepts = new AcceptsGLMethod();
      wrapper.className = "GL_" + wrapper.platform;
      wrapper.packge = GL_PACKAGE_MACOS_x86;
      wrapper.setFileIn(GL_MACOS_SOURCES);
  
      wrapper.addImplement(interf.packge + "." + superGL);
      wrapper.addImplement(interf.packge + ".GLU");
      wrapper.addImplement(interf.packge + ".GLUT");
      
      wrapper.addExtension(interf.packge + ".AGL");
      
      // Write and compile
      List<Method> extra = makeWrapper(javaInterfacesFiles, wrapper);
      
      makeGLUT(interf, extra);
      
      // Configure macOS factory
      factory = new PlatformFactory();
      factory.base = APanamaGLFactory_macOS.class;
      factory.name = "PanamaGLFactory_" + wrapper.platform;
      factory.packge = wrapper.packge;
      factory.matcher = PlatformMatcher_macOS_x86.class;
      factory.setFileIn(GL_MACOS_SOURCES);
      
      makeFactory(javaInterfacesFiles, wrapper, factory);
    }
    
    if(MACOS_ARM) {
      wrapper = new Wrapper();
      wrapper.platform = "macOS_arm";
      wrapper.wrapped = Set.of(/*glext.macos.x86.glext_h.class, */opengl.macos.arm.glut_h.class);
      wrapper.accepts = new AcceptsGLMethod();
      wrapper.className = "GL_" + wrapper.platform;
      wrapper.packge = GL_PACKAGE_MACOS_arm;
      wrapper.setFileIn(GL_MACOS_SOURCES);
  
      wrapper.addImplement(interf.packge + "." + superGL);
      wrapper.addImplement(interf.packge + ".GLU");
      wrapper.addImplement(interf.packge + ".GLUT");
      
      wrapper.addExtension(interf.packge + ".AGL");
      
      // Write and compile
      List<Method> extra = makeWrapper(javaInterfacesFiles, wrapper);
      
      makeGLUT(interf, extra);
      
      // Configure macOS factory
      factory = new PlatformFactory();
      factory.base = APanamaGLFactory_macOS.class;
      factory.name = "PanamaGLFactory_" + wrapper.platform;
      factory.packge = wrapper.packge;
      factory.matcher = PlatformMatcher_macOS_arm.class;
      factory.setFileIn(GL_MACOS_SOURCES);
      
      makeFactory(javaInterfacesFiles, wrapper, factory);
    }
    
    // Compile ALL
    compile(javaInterfacesFiles);


    // ========================================================
    // Configure Linux wrapper
    
    if(LINUX_x86) {
      wrapper = new Wrapper();
      wrapper.platform = "linux_x86";
      wrapper.wrapped = Set.of(glext.ubuntu.v20.glext_h.class/*, opengl.ubuntu.v20.glut_h.class, glxext.ubuntu.v20.glxext_h.class*/);
      wrapper.accepts = new AcceptsGLMethod();
      wrapper.className = "GL_" + wrapper.platform;
      wrapper.packge = GL_PACKAGE_LINUX_x86;
      wrapper.setFileIn(GL_LINUX_SOURCES);
      
      wrapper.addImplement(interf.packge + "." + superGL);
      wrapper.addImplement(interf.packge + ".GLU");
      wrapper.addImplement(interf.packge + ".GLUT");
      
      wrapper.addExtension(interf.packge + ".AGL");


      // Write and compile
      wrapperGen.addUnimplementedMethodsUponMissingBinding = true;
      makeWrapper(javaInterfacesFiles, wrapper);
  
      // Configure Linux factory
      factory = new PlatformFactory();
      factory.base = APanamaGLFactory_linux.class;
      factory.name = "PanamaGLFactory_" + wrapper.platform;
      factory.packge = GL_PACKAGE_LINUX_x86;
      factory.setFileIn(GL_LINUX_SOURCES);
      
      makeFactory(javaInterfacesFiles, wrapper, factory);

    }   
    
    // ========================================================
    // Configure Windows wrapper
    
    if(WINDOWS_x86) {
      wrapper = new Wrapper();
      wrapper.platform = "windows_x64";
      wrapper.wrapped = Set.of(freeglut.windows.x86.freeglut_h.class);
      wrapper.accepts = new AcceptsGLMethod();
      wrapper.className = "GL_" + wrapper.platform;
      wrapper.packge = GL_PACKAGE_WINDOWS_x64;
      wrapper.setFileIn(GL_WINDOWS_SOURCES);
      
      wrapper.addImplement(interf.packge + "." + superGL);
      wrapper.addImplement(interf.packge + ".GLU");
      wrapper.addImplement(interf.packge + ".GLUT");
      
      wrapper.addExtension(interf.packge + ".AGL");


      // Write and compile
      wrapperGen.addUnimplementedMethodsUponMissingBinding = true;
      makeWrapper(javaInterfacesFiles, wrapper);
  
      // Configure Linux factory
      factory = new PlatformFactory();
      factory.base = APanamaGLFactory_windows.class;
      factory.name = "PanamaGLFactory_" + wrapper.platform;
      factory.packge = GL_PACKAGE_WINDOWS_x64;
      factory.setFileIn(GL_WINDOWS_SOURCES);
      
      makeFactory(javaInterfacesFiles, wrapper, factory);

    }   
    
    // Compile ALL
    compile(javaInterfacesFiles);
  }




  /**
   * 
   * @param javaInterfacesFiles
   * @param wrapper
   * @param factory
   * @throws IOException
   */
  protected void makeFactory(List<String> javaInterfacesFiles, Wrapper wrapper,
      PlatformFactory factory) throws IOException {
    ClassWriter factoryWriter = new ClassWriter(factory.packge, factory.name);
    factoryWriter.addExtension(factory.base.getName());
    factoryWriter.addImplement(panamagl.factory.PanamaGLFactory.class.getName());
    
    
    StringBuffer javaCode = new StringBuffer();
    factoryWriter.start(javaCode);

    // -------------------------------------------------------------------
    // Create a method to instanciate the appropriate GL wrapper
    
    Code c = new Code("return new " + wrapper.packge + "." + wrapper.className + "();");
    factoryWriter.method(javaCode, "newGL", null, new Arg(panamagl.opengl.GL.class.getName()), c);
    
    // -------------------------------------------------------------------
    // Create a method to instanciate the appropriate platform matcher
    
    if(factory.matcher!=null) {
      Arg input = new Arg(Platform.class.getName(), "platform");
      Code cn = new Code("return new " + factory.matcher.getName() + "().matches(platform);");
      factoryWriter.method(javaCode, "matches", List.of(input), new Arg("boolean"), cn);
    }
    
    
    factoryWriter.close(javaCode);
    factoryWriter.writeTo(javaCode, factory.javaFile);
    
    javaInterfacesFiles.add(factory.javaFile);
  }


  /**
   * 
   * @param javaInterfacesFiles
   * @param wrapper
   * @return
   * @throws IllegalAccessException
   * @throws IOException
   */
  protected List<Method> makeWrapper(List<String> javaInterfacesFiles, Wrapper wrapper)
      throws IllegalAccessException, IOException {
    List<String> cmp = new ArrayList<>(javaInterfacesFiles);
    cmp.add(wrapper.javaFile);
    
    System.out.println("----------------------------------------------------------");
    System.out.println("[Wrapping] " + wrapper.wrapped + " in " + wrapper.className);
    wrapperGen.generateWrapper(wrapper);
    return wrapperGen.getAutoWrappedMethods();
  }
  
  /**
   * 
   * @param interf
   * @param extra
   * @throws IOException
   */
  protected void makeGLUT(Interf interf, List<Method> extra) throws IOException {
    // Create GLU et GLUT interface
    InterfaceWriter gluWriter = new InterfaceWriter(interf.packge, "GLU");
    InterfaceWriter glutWriter = new InterfaceWriter(interf.packge, "GLUT");
    
    gluWriter.addImport("java.lang.foreign.*");
    glutWriter.addImport("java.lang.foreign.*");
    
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
  }
  
  public void compile(List<String> javaFile) throws IOException {
    ClassCompiler c = new ClassCompiler();
    c.compile(javaFile);
  }
}
