/*******************************************************************************
 * Copyright (c) 2022, 2023 Martin Pernollet & contributors.
 *
 * This library is free software; you can redistribute it and/or modify it under the terms of the
 * GNU Lesser General Public License as published by the Free Software Foundation; either version
 * 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License along with this library;
 * if not, write to the Free Software Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA
 * 02110-1301, USA
 *******************************************************************************/
package jextract.gl.api.panamagl;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import jextract.gl.APILayout;
import jextract.gl.APIPlatform;
import jextract.gl.APIPlatform.CPU;
import jextract.gl.APIPlatform.OS;
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
import panamagl.platform.macos.x64.PlatformMatcher_macOS_x64;
import panamagl.platform.windows.APanamaGLFactory_windows;

/**
 * Generate an OpenGL API with per-platform implementations wrapping the bindings made available by
 * JExtract. <br>
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
  private static final String CLASS_NAME_AGL = "AGL";
  private static final String CLASS_NAME_GLUT = "GLUT";
  private static final String CLASS_NAME_GLU = "GLU";
  private static final String CLASS_BASE_NAME_GL = "GL_";
  private static final String CLASS_BASE_NAME_PANAMA_GL_FACTORY = "PanamaGLFactory_";
  private static final String GL_PACKAGE = "panamagl.opengl";

  String superGL = "GL";

  Interf interf = new Interf();



  public static void main(String[] args) throws Exception {
    APILayout layout = new PanamaGLLayout();

    GenerateAPI gen = new GenerateAPI();
    gen.run(layout);
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
  public void run(APILayout layout) throws Exception {
    boolean MACOS_x64 = false;
    boolean MACOS_ARM = false;
    boolean LINUX_x64 = false;
    boolean WINDOWS_x64 = true;

    // ============================================================================
    // GL SPECIFICATION

    interf = new Interf();
    interf.packge = GL_PACKAGE;
    interf.javaFolder =
        layout.getOutputFolder(new APIPlatform(OS.api)) + interf.packge.replace(".", "/") + "/";

    List<String> interfaceFiles = makeGLInterfaces();

    // ============================================================================
    // GL IMPLEMENTATION

    wrapperGen.addUnimplementedMethodsUponMissingBinding = false;
    // wrapperGen.addUnimplementedMethodsFor = Sets.of("glDebugMessageCallback");
    wrapperGen.skipAlreadyBindedMethodNAME = true;


    // ========================================================
    // Configure macOS wrapper

    if (MACOS_x64) {

      APIPlatform platform = new APIPlatform(OS.macOS, CPU.x64);
      Set<Class<?>> wrapped = Set.of(opengl.macos.x86.glut_h.class);
      Class<?> factoryBase = APanamaGLFactory_macOS.class;
      Class<?> factorymatcher = PlatformMatcher_macOS_x64.class;
      boolean genGlut = true;

      makeGLWrapperAndFactory(layout, platform, wrapped, factoryBase, factorymatcher, genGlut,
          interfaceFiles);
    }

    if (MACOS_ARM) {

      APIPlatform platform = new APIPlatform(OS.macOS, CPU.arm);
      Set<Class<?>> wrapped = Set.of(opengl.macos.arm.glut_h.class);
      Class<?> factoryBase = APanamaGLFactory_macOS.class;
      Class<?> factorymatcher = PlatformMatcher_macOS_arm.class;
      boolean genGlut = true;


      makeGLWrapperAndFactory(layout, platform, wrapped, factoryBase, factorymatcher, genGlut,
          interfaceFiles);
    }

    // Compile ALL
    compile(interfaceFiles);


    // ========================================================
    // Configure Linux wrapper

    if (LINUX_x64) {

      wrapperGen.addUnimplementedMethodsUponMissingBinding = true;

      APIPlatform platform = new APIPlatform(OS.linux, CPU.x64);
      Set<Class<?>> wrapped = Set.of(glext.ubuntu.v20.glext_h.class);
      Class<?> factoryBase = APanamaGLFactory_linux.class;
      Class<?> factorymatcher = null;
      boolean genGlut = false;

      makeGLWrapperAndFactory(layout, platform, wrapped, factoryBase, factorymatcher, genGlut,
          interfaceFiles);

    }

    // ========================================================
    // Configure Windows wrapper

    if (WINDOWS_x64) {

      wrapperGen.addUnimplementedMethodsUponMissingBinding = true;

      APIPlatform platform = new APIPlatform(OS.windows, CPU.x64);
      Set<Class<?>> wrapped = Set.of(freeglut.windows.x86.freeglut_h.class);
      Class<?> factoryBase = APanamaGLFactory_windows.class;
      Class<?> factorymatcher = null;
      boolean genGlut = false;

      makeGLWrapperAndFactory(layout, platform, wrapped, factoryBase, factorymatcher, genGlut,
          interfaceFiles);

    }

    // Compile ALL
    compile(interfaceFiles);
  }

  protected List<String> makeGLInterfaces() throws IOException, Exception {
    System.out.println("----------------------------------------------------------");
    System.out.println("[Interfaces]");

    InterfaceWriter glInterfaceWriter = new InterfaceWriter(interf.packge, superGL);

    glInterfaceWriter.addExtension("GL_1");
    glInterfaceWriter.addExtension("GL_2");
    // glInterfaceWriter.addExtension("GL_3");
    // glInterfaceWriter.addExtension("GL_4");
    glInterfaceWriter.addExtension(CLASS_NAME_GLU);
    glInterfaceWriter.addExtension(CLASS_NAME_GLUT);

    StringBuffer javaCode = new StringBuffer();

    String javaFile = interf.javaFolder + "/" + superGL + ".java";
    glInterfaceWriter.start(javaCode);
    glInterfaceWriter.close(javaCode);
    glInterfaceWriter.writeTo(javaCode, javaFile);

    List<String> interfaceFiles = interfGen.generateInterfaces(interf);
    return interfaceFiles;
  }

  protected void makeGLWrapperAndFactory(APILayout layout, APIPlatform platform,
      Set<Class<?>> wrapped, Class<?> factoryBase, Class<?> factorymatcher, boolean genGlut,
      List<String> javaInterfacesFiles) throws IllegalAccessException, IOException {


    Wrapper wrapper = new Wrapper();
    wrapper.wrapped = wrapped;
    wrapper.platform = platform.getName();
    wrapper.accepts = new AcceptsGLMethod();
    wrapper.className = CLASS_BASE_NAME_GL + wrapper.platform;
    wrapper.packge = layout.getPlatformPackage(platform);
    wrapper.setFileIn(layout.getOutputFolder(platform));

    wrapper.addImplement(interf.packge + "." + superGL);
    wrapper.addImplement(interf.packge + "." + CLASS_NAME_GLU);
    wrapper.addImplement(interf.packge + "." + CLASS_NAME_GLUT);

    wrapper.addExtension(interf.packge + "." + CLASS_NAME_AGL);

    // Write and compile
    List<Method> extra = makeWrapper(javaInterfacesFiles, wrapper);

    if (genGlut)
      makeGLUT(interf, extra);

    // Configure macOS factory
    PlatformFactory factory = new PlatformFactory();
    factory.name = CLASS_BASE_NAME_PANAMA_GL_FACTORY + wrapper.platform;
    factory.packge = layout.getPlatformPackage(platform);
    factory.base = factoryBase;
    factory.matcher = factorymatcher;
    factory.setFileIn(layout.getOutputFolder(platform));

    makeFactory(javaInterfacesFiles, wrapper, factory);
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

    if (factory.matcher != null) {
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
    InterfaceWriter gluWriter = new InterfaceWriter(interf.packge, CLASS_NAME_GLU);
    InterfaceWriter glutWriter = new InterfaceWriter(interf.packge, CLASS_NAME_GLUT);

    gluWriter.addImport("java.lang.foreign.*");
    glutWriter.addImport("java.lang.foreign.*");

    String glutFile = interf.javaFolder + "/"+CLASS_NAME_GLUT+".java";
    String gluFile = interf.javaFolder + "/"+CLASS_NAME_GLU+".java";

    StringBuffer glutCode = new StringBuffer();
    StringBuffer gluCode = new StringBuffer();

    glutWriter.start(glutCode);
    gluWriter.start(gluCode);
    for (Method method : extra) {
      if (method.getName().startsWith("glut") && !method.getName().contains("$")) {
        glutWriter.method(glutCode, method);
      } else if (method.getName().startsWith("glu") && !method.getName().contains("$")) {
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
