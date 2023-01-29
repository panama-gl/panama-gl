package jextract.gl.java;

import java.lang.reflect.Method;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import opengl.ubuntu.v20.glut_h;

// vm args : --enable-native-access=ALL-UNNAMED --add-modules jdk.incubator.foreign
public class TestClassMethodRegistry {
  @Test
  public void test() throws IllegalAccessException {
    ClassMethodRegistry registry = new ClassMethodRegistry();
    
    List<Method> methods = registry.selectMethods(glut_h.class, new AcceptsGLMethod());

    Assert.assertEquals(673, methods.size());
  }
}
