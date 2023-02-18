package jextract.gl;

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
import jextract.gl.xml.model.CommandWrap;

/**
 * Run me with VM args : --enable-preview
 */
public class GenerateWrapperFromBindings {
  OpenGLRegistry registry;
  
  boolean addUnimplementedMethodsUponMissingBinding = true;
  boolean skipAlreadyBindedMethodNAME = true;
  boolean debug = true;

  public Set<String> addUnimplementedMethodsFor = new HashSet<>();
  
  protected List<Method> autoWrappedMethods;
  
  public GenerateWrapperFromBindings() throws Exception {
    registry = new OpenGLRegistry();
  }
  
  public static void main(String[] args) throws Exception {

    Wrapper wrapper = new Wrapper();
    wrapper.wrapped = Set.of(opengl.macos.v10_15_7.glut_h.class);
    
    wrapper.accepts = new AcceptsGLMethod();
    wrapper.className = "GL_macOS";
    wrapper.javaFile = "target/"+wrapper.className+".java";


    // Write class
    GenerateWrapperFromBindings gen = new GenerateWrapperFromBindings();
    gen.generateWrapper(wrapper);

    // Compile class
    gen.compile(List.of(wrapper.javaFile));
    
  }
  
  public void compile(List<String> javaFile) throws IOException {
    ClassCompiler c = new ClassCompiler();
    c.compile(javaFile);    
  }

  public void generateWrapper(Wrapper wrapper) throws IllegalAccessException, IOException {
    autoWrappedMethods = new ArrayList<>();
    addUnimplementedMethodsFor = new HashSet<>();
    
    // ----------------------------------------------------
    // -------- REGISTRIES --------------------------------
    // ----------------------------------------------------
    
    Map<String, CommandWrap> xmlRegistry = getXMLRegistryCommands();
    
    // ----------------------------------------------------
    // -------- ANALYSE IMPOSSIBLE BINDINGS ---------------
    // ----------------------------------------------------

    int missingJava = 0;

    Map<Class<?>,Map<String, Method>> javaRegistry = new HashMap<>();
    
    for(Class<?> binding: wrapper.wrapped) {
      javaRegistry.put(binding, getJavaRegistryMethods(binding, wrapper.accepts));
    }
    
    //getJavaRegistryMethods(wrapper.wrapped, wrapper.accepts);

    for(String xmlMethod: xmlRegistry.keySet()) {

      // Search this method in all binding registries
      boolean found = false;
      
      if(xmlMethod.startsWith("glu") || xmlMethod.startsWith("glut"))
        found = true;
      
      for(Map<String, Method> bindingRegistry: javaRegistry.values()) {
        if(bindingRegistry.get(xmlMethod)!=null) {
          found = true;
        }
      }

      if(!found) {
        if(debug)
          System.out.println("Not found in Java bindings ! " + xmlMethod);
        missingJava++;
      }
    }

    // ----------------------------------------------------
    // -------- GENERATES METHOD WRAPPERS -----------------
    // ----------------------------------------------------

    ClassWriter classWriter = newClassWriter(wrapper.packge, wrapper.wrapped, wrapper.className);
    
    classWriter.addImplement(wrapper.implement);
    StringBuffer javaCode = new StringBuffer();
    
    classWriter.start(javaCode);
    
    int methodNotFound = 0;
    int methodFound = 0;
    
    // Index all methods provided by each binding to wrap
    Map<Class<?>,List<Method>> methods = new HashMap<>();
    
    for(Class<?> binding: wrapper.wrapped) {
      List<Method> bindingMethods = getJavaMethods(binding, wrapper.accepts);
      methods.put(binding, bindingMethods);

      System.out.println(bindingMethods.size() + " methods in generated bindings for " +  binding.getName());
    }
    
    
    // ---------------------------------------------------------------------------
    // Wrap all binded methods under GL interfaces
    //

    List<CommandWrap> wrappedCommands = new ArrayList<>();
    
    Set<String> autoWrappedMethodNames = new HashSet<>();

    // For each binding class to wrap
    for(Class<?> wrapped: wrapper.wrapped) {
      
      // For each of its method
      for(Method bindedMethod: methods.get(wrapped)) {
        CommandWrap registryCommand = xmlRegistry.get(bindedMethod.getName());
        
        // Skip command if already handled
        if(skipAlreadyBindedMethodNAME && wrappedCommands.contains(registryCommand)) {
          continue;
        }
        
        // Write a wrapper method for this method if a registry command was found
        if(registryCommand!=null) {
          methodFound++;
          
          classWriter.wrapper(javaCode, wrapped, bindedMethod, registryCommand);
          
          wrappedCommands.add(registryCommand);
        }
        else {
          // Deal with known but out of registry methods : automatic interface generation
          
          if((bindedMethod.getName().startsWith("glu") || bindedMethod.getName().startsWith("glut")) && ! bindedMethod.getName().contains("$")) {
            
            // check the method name and not the method itself, since the same
            // method may appear in multiple wrapped binding.
            if(!autoWrappedMethodNames.contains(bindedMethod.getName())) {
              
              autoWrappedMethods.add(bindedMethod);
              autoWrappedMethodNames.add(bindedMethod.getName());
              
              classWriter.wrapperAuto(javaCode, wrapped, bindedMethod);
            }
            
            
          }
          // Skip wrapping if this method can't be found in the OpenGL specification
          else {
            methodNotFound++;
            if(debug)
              System.out.println("Not found in XML registry! " + bindedMethod.getName());
            
          }

        }
        
      }
    }
    
    // ---------------------------------------------------------------------------
    // Create default implementation throwing NOT IMPL EXCEPT if the registry command has
    // not been implement already (and is part of the target GL versions)
    
    int nUnimplemented = 0;
    
    if(addUnimplementedMethodsUponMissingBinding) {
      for(CommandWrap registryCommand : xmlRegistry.values()) {
        if(!wrappedCommands.contains(registryCommand)) {
          
          classWriter.wrapperNotImplemented(javaCode, registryCommand);
          
          wrappedCommands.add(registryCommand);
          
          nUnimplemented++;
          
          if(debug)
            System.out.println(registryCommand.getName() + "(..) \twrapped but not implemented!");
        }
      }
    }
    else {
      for(String stubRequested: addUnimplementedMethodsFor) {
        CommandWrap registryCommand = xmlRegistry.get(stubRequested);
        
        classWriter.wrapperNotImplemented(javaCode, registryCommand);

      }
    }

    
    // ---------------------------------------------------------------------------
    // Finish
    
    classWriter.close(javaCode);

    System.out.println("------------------------------------------------------------------");
    System.out.println("Methods wrapped                                 : " + methodFound);
    System.out.println("Methods not wrapped (not found in XML registry) : " + methodNotFound);
    System.out.println("Methods missed (not found in java bindings)     : " + missingJava);
    System.out.println("Generated unimplemented methods                 : " + nUnimplemented);
    System.out.println("------------------------------------------------------------------");


    // Write code to disk
    classWriter.writeTo(javaCode, wrapper.javaFile);
  }
  
  


  public ClassWriter newClassWriter(String packge, Set<Class<?>> wrapped, String className) {
    ClassWriter classWriter = new ClassWriter(packge, className);
    
    for(Class<?> wrpd: wrapped) {
      classWriter.addImport(wrpd.getName());
      classWriter.addImport("static " + wrpd.getName() + ".*");
    }
    classWriter.addImport("java.lang.foreign.*");
    return classWriter;
  }


  public List<Method> getJavaMethods(Class<?> wrapped, AcceptsMethod accepts) throws IllegalAccessException {
    ClassMethodRegistry registryGLUT = new ClassMethodRegistry();
    List<Method> methods = registryGLUT.selectMethods(wrapped, accepts);
    registryGLUT.sort(methods);
    return methods;
  }

  public Map<String, Method> getJavaRegistryMethods(Class<?> wrapped, AcceptsMethod accepts) throws IllegalAccessException {
    Map<String, Method> methodRegistry = new HashMap<> ();

    
    List<Method> methods = getJavaMethods(wrapped, accepts);

    
    for(Method m: methods) {
      methodRegistry.put(m.getName(), m);
    }
    
    return methodRegistry;
  }

  public Map<String, CommandWrap> getXMLRegistryCommands() {
    List<CommandWrap> cw = registry.getCommands();
    
    Map<String, CommandWrap> commandName = new HashMap<>();
    
    //System.out.println("OpenGL Commands : ");
    for (CommandWrap c : cw) {
      commandName.put(c.getName(), c);
    }
    //System.out.println("------------------------");
    //System.out.println(cw.size() + " GL commands");
    return commandName;
  }

  /** Methods that have been added to the wrapper despite they are not visible in the GL registry. That may be the case for GLU or GLUT methods that are not in registry but available in all bindings */
  public List<Method> getAutoWrappedMethods() {
    return autoWrappedMethods;
  }

  

}
