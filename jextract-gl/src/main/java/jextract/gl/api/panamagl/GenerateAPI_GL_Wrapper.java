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
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import jextract.gl.generate.java.ClassCompiler;
import jextract.gl.generate.java.ClassWriter;
import jextract.gl.generate.java.Wrapper;
import jextract.gl.java.AcceptsGLMethod;
import jextract.gl.java.AcceptsMethod;
import jextract.gl.java.ClassMethodRegistry;
import jextract.gl.xml.OpenGLRegistry;
import jextract.gl.xml.model.GLCommand;

/**
 * Run me with VM args : --enable-preview
 */
public class GenerateAPI_GL_Wrapper {
  OpenGLRegistry registry;

  boolean addUnimplementedMethodsUponMissingBinding = true;
  boolean skipAlreadyBindedMethodNAME = true;
  boolean debug = false;

  // public Set<String> addUnimplementedMethodsFor = new HashSet<>();

  protected List<Method> autoWrappedMethods = new ArrayList<>();

  protected int methodNotFound;
  protected int methodFound;
  protected int missingJava;
  protected int nUnimplemented;


  public GenerateAPI_GL_Wrapper() throws Exception {
    registry = new OpenGLRegistry();
  }

  public static void main(String[] args) throws Exception {

    Wrapper wrapper = new Wrapper();
    wrapper.wrapped = Set.of(opengl.macos.arm.glut_h.class);

    wrapper.accepts = new AcceptsGLMethod();
    wrapper.className = "GL_macOS";
    wrapper.javaFile = "target/" + wrapper.className + ".java";


    // Write class
    GenerateAPI_GL_Wrapper gen = new GenerateAPI_GL_Wrapper();
    gen.generateWrapper(wrapper);

    // Compile class
    gen.compile(List.of(wrapper.javaFile));

  }

  public void compile(List<String> javaFile) throws IOException {
    ClassCompiler c = new ClassCompiler();
    c.compile(javaFile);
  }

  /**
   * Generate a wrapper for all provided bindings as long as they match a method name in the
   * {@link OpenGLRegistry}.
   * 
   * Special cases
   * <ul>
   * <li>If the binded method is not declared in the GL, GLU or GLUT registry, it is skipped
   * <li>If the registry contains methods that are not available in the generated binding, it is
   * skipped if {@link addUnimplementedMethodsUponMissingBinding} is false, otherwise a wrapper with
   * a body throwing a NotImplemented exception is created.
   * </ul>
   */
  public void generateWrapper(Wrapper wrapper) throws IllegalAccessException, IOException {
    autoWrappedMethods = new ArrayList<>();
    // addUnimplementedMethodsFor = new HashSet<>();

    methodNotFound = 0;
    methodFound = 0;


    // ----------------------------------------------------
    // REGISTRIES

    Map<String, GLCommand> glRegistry = getXMLRegistryCommands();
    Map<Class<?>, List<Method>> javaMethodRegistry = initJavaMethodRegistry(wrapper);
    Map<Class<?>, Map<String, Method>> javaMethodNameRegistry = initJavaMethodNameRegistry(wrapper);


    // ----------------------------------------------------
    // ANALYSE IMPOSSIBLE BINDINGS
    
    computeMissingBindingsStats(glRegistry, javaMethodNameRegistry);

    
    // ----------------------------------------------------
    // INIT CLASS WRITER

    ClassWriter classWriter = newClassWriter(wrapper.packge, wrapper.wrapped, wrapper.className);
    classWriter.addImplement(wrapper.implement);
    classWriter.addExtension(wrapper.extend);

    classWriter.start();



    // ---------------------------------------------------------------------------
    // Wrap all binded methods under GL interfaces.
    //
    // If a binding method can not be associated with a specification, then
    // 1. GLUT or GLU methods are automatically wrapped (they are not in the GL spec)
    // 2. All other are ignored and increase the methodNotFound counter

    List<GLCommand> wrappedCommands =
        wrapJavaBinding(classWriter, wrapper, glRegistry, javaMethodRegistry);

    // ---------------------------------------------------------------------------
    // Create default implementation throwing NOT IMPL EXCEPT if the registry command has
    // not been implement already (and is part of the target GL versions)

    wrapUnavailableMethods(classWriter, glRegistry, wrappedCommands);


    // ---------------------------------------------------------------------------
    // Finish

    classWriter.close();

    System.out.println("------------------------------------------------------------------");
    System.out.println("Methods wrapped                                 : " + methodFound);
    System.out.println("Methods not wrapped (not found in XML registry) : " + methodNotFound);
    System.out.println("Methods missed (not found in java bindings)     : " + missingJava);
    System.out.println("Generated unimplemented methods                 : " + nUnimplemented);
    System.out.println("------------------------------------------------------------------");


    // Write code to disk
    classWriter.writeTo(wrapper.javaFile);
    
    System.out.println("Created Java File : " + wrapper.javaFile);

  }

  // --------------------------------------------------------------------
  //
  // WRAPPING CASES
  //
  // --------------------------------------------------------------------

  /**
   * Create a wrapper for methods that are not declared in the GL specification.
   * 
   * Method names starting with GLU and GLUT are not in the GL spec but will be wrapped and added to
   * the list of extra methods {@link #getAutoWrappedMethods()}.
   */
  protected List<GLCommand> wrapJavaBinding(ClassWriter classWriter, Wrapper wrapper,
      Map<String, GLCommand> glRegistry, Map<Class<?>, List<Method>> javaMethodRegistry) {
    List<GLCommand> wrappedCommands = new ArrayList<>();

    Set<String> autoWrappedMethodNames = new HashSet<>();

    methodNotFound = 0;
    methodFound = 0;

    // For each binding class to wrap
    for (Class<?> wrapped : wrapper.wrapped) {

      // For each of its method
      for (Method bindedMethod : javaMethodRegistry.get(wrapped)) {
        GLCommand registryCommand = glRegistry.get(bindedMethod.getName());

        // Skip command if already handled
        if (skipAlreadyBindedMethodNAME && wrappedCommands.contains(registryCommand)) {
          continue;
        }

        // Write a wrapper method for this method if a registry command was found
        if (registryCommand != null) {
          methodFound++;

          classWriter.wrapper(wrapped, bindedMethod, registryCommand);

          wrappedCommands.add(registryCommand);
        } else {
          // Deal with known but out of registry methods : automatic interface generation

          if (isGLUTorGLUMethod(bindedMethod)) {

            wrapUnspecifiedMethod(classWriter, wrapped, bindedMethod, autoWrappedMethodNames);


          }
          // Skip wrapping if this method can't be found in the OpenGL specification
          else {
            methodNotFound++;
            if (debug)
              System.out.println("Not found in XML registry! " + bindedMethod.getName());

          }

        }

      }
    }
    return wrappedCommands;
  }

  /**
   * Create a wrapper for methods that are NOT declared in the specification. On can later fetch
   * unspecified wrapped methods by calling {@link #getAutoWrappedMethods()}.
   */
  protected void wrapUnspecifiedMethod(ClassWriter classWriter, Class<?> wrapped,
      Method bindedMethod, Set<String> autoWrappedMethodNames) {
    // check the method name and not the method itself, since the same
    // method may appear in multiple wrapped binding.
    if (!autoWrappedMethodNames.contains(bindedMethod.getName())) {

      autoWrappedMethods.add(bindedMethod);
      autoWrappedMethodNames.add(bindedMethod.getName());

      classWriter.wrapperAuto(wrapped, bindedMethod);
    }
  }

  /**
   * Create a wrapper for methods that are declared in the specification but not found in binding.
   * The method body simply throw an exception stating that no implementation is available.
   */
  protected int wrapUnavailableMethods(ClassWriter classWriter, Map<String, GLCommand> glRegistry,
      List<GLCommand> wrappedCommands) {
    nUnimplemented = 0;

    if (addUnimplementedMethodsUponMissingBinding) {

      // OpenGL : Create a method throwing "not implemented" exception
      for (GLCommand registryCommand : glRegistry.values()) {
        if (!wrappedCommands.contains(registryCommand)) {

          classWriter.wrapperNotImplemented(registryCommand);

          wrappedCommands.add(registryCommand);

          nUnimplemented++;

          if (debug)
            System.out.println(registryCommand.getName() + "(..) \twrapped but not implemented!");
        }
      }

      // GLUT


    } /*
       * else { for (String stubRequested : addUnimplementedMethodsFor) { CommandWrap
       * registryCommand = glRegistry.get(stubRequested);
       * 
       * classWriter.wrapperNotImplemented(javaCode, registryCommand);
       * 
       * } }
       */
    return nUnimplemented;
  }


  // --------------------------------------------------------------------
  //
  // STATS
  //
  // --------------------------------------------------------------------

  /**
   * Compute the number of methods that are delclared in the spec bug not found in the generated
   * java bindings.
   * 
   * @param xmlRegistry
   * @param javaRegistry
   * @return
   */
  protected void computeMissingBindingsStats(Map<String, GLCommand> xmlRegistry,
      Map<Class<?>, Map<String, Method>> javaRegistry) {
    missingJava = 0;

    for (String xmlMethod : xmlRegistry.keySet()) {

      // Search this method in all binding registries
      boolean found = false;

      if (isGLUTorGLUMethod(xmlMethod))
        found = true;

      for (Map<String, Method> bindingRegistry : javaRegistry.values()) {
        if (bindingRegistry.get(xmlMethod) != null) {
          found = true;
        }
      }

      if (!found) {
        if (debug)
          System.out.println("Not found in Java bindings ! " + xmlMethod);
        missingJava++;
      }
    }
  }

  protected boolean isGLUTorGLUMethod(Method method) {
    return isGLUTorGLUMethod(method.getName());
  }

  protected boolean isGLUTorGLUMethod(String name) {
    return (name.startsWith("glu") || name.startsWith("glut")) && !name.contains("$");
  }

  // --------------------------------------------------------------------
  //
  // DATA STRUCTURES TO FIND GENERATED METHODS
  //
  // --------------------------------------------------------------------

  protected Map<Class<?>, List<Method>> initJavaMethodRegistry(Wrapper wrapper)
      throws IllegalAccessException {
    Map<Class<?>, List<Method>> methods = new HashMap<>();

    for (Class<?> binding : wrapper.wrapped) {
      List<Method> bindingMethods = getJavaMethodsForClass(binding, wrapper.accepts);
      methods.put(binding, bindingMethods);

      System.out.println(
          bindingMethods.size() + " methods in generated bindings for " + binding.getName());
    }
    return methods;
  }

  protected Map<Class<?>, Map<String, Method>> initJavaMethodNameRegistry(Wrapper wrapper)
      throws IllegalAccessException {
    Map<Class<?>, Map<String, Method>> javaRegistry = new HashMap<>();

    for (Class<?> binding : wrapper.wrapped) {
      javaRegistry.put(binding, getJavaRegistryMethods(binding, wrapper.accepts));
    }
    return javaRegistry;
  }

  protected List<Method> getJavaMethodsForClass(Class<?> wrapped, AcceptsMethod accepts)
      throws IllegalAccessException {
    ClassMethodRegistry registryGLUT = new ClassMethodRegistry();
    List<Method> methods = registryGLUT.selectMethods(wrapped, accepts);
    registryGLUT.sort(methods);
    return methods;
  }

  protected Map<String, Method> getJavaRegistryMethods(Class<?> wrapped, AcceptsMethod accepts)
      throws IllegalAccessException {
    Map<String, Method> methodRegistry = new HashMap<>();


    List<Method> methods = getJavaMethodsForClass(wrapped, accepts);


    for (Method m : methods) {
      methodRegistry.put(m.getName(), m);
    }

    return methodRegistry;
  }


  // --------------------------------------------------------------------
  //
  // DATA STRUCTURES TO FIND DECLARED METHODS IN SPECIFICATION
  //
  // --------------------------------------------------------------------

  public Map<String, GLCommand> getXMLRegistryCommands() {
    List<GLCommand> cw = registry.getCommands();

    Map<String, GLCommand> commandName = new HashMap<>();

    // System.out.println("OpenGL Commands : ");
    for (GLCommand c : cw) {
      commandName.put(c.getName(), c);
    }
    // System.out.println("------------------------");
    // System.out.println(cw.size() + " GL commands");
    return commandName;
  }

  // --------------------------------------------------------------------
  //
  // REMAINING METHODS
  //
  // --------------------------------------------------------------------


  /**
   * Methods that have been added to the wrapper despite they are not visible in the GL registry.
   * That may be the case for GLU or GLUT methods that are not in registry but available in all
   * bindings
   */
  public List<Method> getAutoWrappedMethods() {
    return autoWrappedMethods;
  }



  public ClassWriter newClassWriter(String packge, Set<Class<?>> wrapped, String className) {
    ClassWriter classWriter = new ClassWriter(packge, className);

    for (Class<?> wrpd : wrapped) {
      classWriter.addImport(wrpd.getName());
      classWriter.addImport("static " + wrpd.getName() + ".*");
    }
    classWriter.addImport("java.lang.foreign.*");
    return classWriter;
  }



}
