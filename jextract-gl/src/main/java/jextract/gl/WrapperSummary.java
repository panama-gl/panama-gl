package jextract.gl;

import java.lang.reflect.Method;
import java.util.List;
import jextract.gl.java.AcceptsMethodGL;
import jextract.gl.java.ClassMethodRegistry;
import jextract.gl.xml.OpenGLRegistry;
import jextract.gl.xml.model.CommandWrap;
import opengl.ubuntu.v20.glut_h;

// --enable-native-access=ALL-UNNAMED --add-modules jdk.incubator.foreign
public class WrapperSummary {

  public static void main(String[] args) throws Exception {
    
    // ----------------------------------------------------
    // -------- XML REGISTRY ------------------------------
    // ----------------------------------------------------
    
    OpenGLRegistry registry = new OpenGLRegistry();

    List<CommandWrap> cw = registry.getCommands();
    
    System.out.println("OpenGL Commands : ");
    for (CommandWrap c : cw) {
      System.out.println(c.getName());
    }
    System.out.println("------------------------");
    System.out.println(cw.size() + " GL commands");

    
    // ----------------------------------------------------
    // -------- BINDING ANALYSIS --------------------------
    // ----------------------------------------------------
    
    ClassMethodRegistry registryGLUT = new ClassMethodRegistry();
    List<Method> methods = registryGLUT.selectMethods(glut_h.class, new AcceptsMethodGL());
    
    registryGLUT.sort(methods);
    registryGLUT.print(methods);
    
    System.out.println("Filtered to " + methods.size() + " methods (initially " + glut_h.class.getMethods().length + ")");

    
  }

}
