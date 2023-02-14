package jextract.gl;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jextract.gl.GenerateAPI.Wrapper;
import jextract.gl.generate.java.ClassCompiler;
import jextract.gl.generate.java.ClassWriter;
import jextract.gl.java.AcceptsGLMethod;
import jextract.gl.java.AcceptsMethod;
import jextract.gl.java.ClassMethodRegistry;
import jextract.gl.xml.OpenGLRegistry;
import jextract.gl.xml.model.CommandWrap;
import opengl.ubuntu.v20.glut_h;

/**
 * Run me with VM args : --enable-preview
 */
public class GenerateWrapperFromBindings {
  OpenGLRegistry registry;
  
  boolean debug = false;
  
  public GenerateWrapperFromBindings() throws Exception {
    registry = new OpenGLRegistry();
  }
  
  public static void main(String[] args) throws Exception {

    Wrapper wrapper = new Wrapper();
    wrapper.wrapped = opengl.macos.v10_15_7.glut_h.class;
    
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
    
    // ----------------------------------------------------
    // -------- REGISTRIES --------------------------------
    // ----------------------------------------------------
    
    Map<String, CommandWrap> xmlRegistry = getXMLRegistryCommands();
    Map<String, Method> javaRegistry = getJavaRegistryMethods(wrapper.wrapped, wrapper.accepts);

    // ----------------------------------------------------
    // -------- ANALYSE IMPOSSIBLE BINDINGS ---------------
    // ----------------------------------------------------

    int missingJava = 0;
    for(String xmlMethod: xmlRegistry.keySet()) {
      if(javaRegistry.get(xmlMethod)==null) {
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
    
    List<Method> methods = getJavaMethods(wrapper.wrapped, wrapper.accepts);
    
    System.out.println(methods.size() + " methods in generated bindings (initially " + glut_h.class.getMethods().length + ")");

    
    for(Method method: methods) {
      CommandWrap command = xmlRegistry.get(method.getName());
      
      if(command==null) {
        
        methodNotFound++;
        if(debug)
          System.out.println("Not found in XML registry! " + method.getName());
      }
      else {
        methodFound++;
        
        // --------------------------------------------
        // Write a wrapper method for this method
        
        classWriter.wrapper(javaCode, wrapper.wrapped, method, command);
        
        // --------------------------------------------
        
      }
      
    }
    classWriter.close(javaCode);

    System.out.println("------------------------------------------------------------------");
    System.out.println("Methods wrapped                                 : " + methodFound);
    System.out.println("Methods not wrapped (not found in XML registry) : " + methodNotFound);
    System.out.println("Methods missed (not found in java bindings)     : " + missingJava);
    System.out.println("------------------------------------------------------------------");


    // Write code to disk
    classWriter.writeTo(javaCode, wrapper.javaFile);
  }


  public ClassWriter newClassWriter(String packge, Class<?> wrapped, String className) {
    ClassWriter classWriter = new ClassWriter(packge, className);
    classWriter.addImport(wrapped.getName());
    classWriter.addImport("static " + wrapped.getName() + ".*");
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
    List<Method> methods = getJavaMethods(wrapped, accepts);

    Map<String, Method> methodRegistry = new HashMap<> ();
    
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


}
