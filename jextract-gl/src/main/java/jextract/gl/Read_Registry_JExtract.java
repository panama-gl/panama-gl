package jextract.gl;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;
import com.google.common.collect.ArrayListMultimap;
import jextract.gl.java.AcceptsMethodGL;
import jextract.gl.java.ClassMethodRegistry;
import opengl.ubuntu.v20.glut_h;

/**
 * Enumerate all OpenGL methods available for generated binding.
 *
 * Run me with VM args : <code>
 *     --enable-native-access=ALL-UNNAMED --add-modules jdk.incubator.foreign -Djava.library.path=.:/usr/lib/x86_64-linux-gnu/
 * </code>
 *
 */
@SuppressWarnings("rawtypes")
public class Read_Registry_JExtract {

  public static void main(String[] args)
      throws IOException, ClassNotFoundException, IllegalAccessException {

    // By direct usage
    byDirectLink();

    

  }

  protected static void byDirectLink() throws IllegalAccessException {
    ClassMethodRegistry registry = new ClassMethodRegistry();
    List<Method> methods = registry.selectMethods(glut_h.class, new AcceptsMethodGL());
    
    registry.sort(methods);
    registry.print(methods);
    
    System.out.println("Filtered to " + methods.size() + " methods (initially " + glut_h.class.getMethods().length + ")");
  }

  protected static ClassMethodRegistry byIntrospection()
      throws ClassNotFoundException, IOException, IllegalAccessException {
    ClassMethodRegistry registry  = new ClassMethodRegistry();

    // By introspection
    
    // use reflection to load all classes allowing to invok gl* methods
    String packageName = "opengl.ubuntu.v20";
    // String classPattern = "constants\\$(\\d+)";
    String classPattern = "glut_h";
    ArrayListMultimap<Class, Method> cm = registry.selectClassMethods(packageName, classPattern, new AcceptsMethodGL());
    System.out.println(cm.values().size() + " GL/GLU/GLUT methods");
    return registry;
  }

  
}
