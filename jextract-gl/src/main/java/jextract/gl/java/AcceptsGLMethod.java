package jextract.gl.java;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Only accepts OpenGL public methods.
 * 
 * Reject GL constants, an non GL methods.
 * 
 * @author Martin Pernollet
 *
 */
public class AcceptsGLMethod implements AcceptsMethod {
  @Override
  public boolean accepts(Method method) {
    // reject non public
    if (!Modifier.isPublic(method.getModifiers())) {
      return false;
    } 
    else {
      String name = method.getName();
      return acceptsName(name);
    }
  }

  protected boolean acceptsName(String name) {
    // reject method handle
    if (name.endsWith("$MH")) {
      return false;
    }

    // only keep methods in gl, glu, glut
    else if (name.startsWith("gl")) {

      // but reject constants
      // 
      //if (name.contains("_")) {
      //  return false;
      //} else {
        return true;
      //}
    }
    else if (name.startsWith("_")) {
      return false;
    }
    else
      return false;
  }
}
