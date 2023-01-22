package jextract.gl;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jextract.gl.java.AcceptsMethodGL;
import jextract.gl.java.ClassMethodRegistry;
import jextract.gl.xml.OpenGLRegistry;
import jextract.gl.xml.model.CommandWrap;
import opengl.ubuntu.v20.glut_h;

/**
 * Run me with VM args : --enable-preview
 */
public class GenerateBottomUp {

  public static void main(String[] args) throws Exception {
    
    // ----------------------------------------------------
    // -------- XML REGISTRY ------------------------------
    // ----------------------------------------------------
    
    OpenGLRegistry registry = new OpenGLRegistry();

    List<CommandWrap> cw = registry.getCommands();
    
    Map<String, CommandWrap> commandName = new HashMap<>();
    
    System.out.println("OpenGL Commands : ");
    for (CommandWrap c : cw) {
      //System.out.println(c.getName());
      
      commandName.put(c.getName(), c);
    }
    System.out.println("------------------------");
    System.out.println(cw.size() + " GL commands");

    
    // ----------------------------------------------------
    // -------- BINDING ANALYSIS --------------------------
    // ----------------------------------------------------
    
    ClassMethodRegistry registryGLUT = new ClassMethodRegistry();
    List<Method> methods = registryGLUT.selectMethods(glut_h.class, new AcceptsMethodGL());
    registryGLUT.sort(methods);
    //registryGLUT.print(methods);
    
    System.out.println(methods.size() + " methods in generated bindings (initially " + glut_h.class.getMethods().length + ")");
    
    int kNotFound = 0;
    int kFound = 0;
    for(Method method: methods) {
      CommandWrap command = commandName.get(method.getName());
      
      if(command==null) {
        kNotFound++;
        System.out.println("Not found in registry! " + method.getName());
      }
      else {
        kFound++;
      }
      
    }

    System.out.println("N not found : " + kNotFound + " - found : " + kFound);
    
  }

}
