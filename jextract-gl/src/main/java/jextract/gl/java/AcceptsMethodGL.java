package jextract.gl.java;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class AcceptsMethodGL implements AcceptsMethod {
  @Override
  public boolean accepts(Method method) {
    // reject non public
    if (!Modifier.isPublic(method.getModifiers())) {
      return false;
    } 
    /*else if(method.getDeclaringClass().equals(Object.class)) {
      return false;
    }*/
    else {
      String name = method.getName();
      return acceptsName(name);
    }
  }

  protected boolean acceptsName(String name) {
    if( Character.isUpperCase(name.charAt(0)) ) {
      return false;
    }
    
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
    /*else if (name.startsWith("GL")) {
      return false;
    }*/

    else if (name.startsWith("_")) {
      return false;
    }
    else
      return false;
  }

  /*private static boolean isStringUpperCase(String str) {
    // convert String to char array
    char[] charArray = str.toCharArray();

    for (int i = 0; i < charArray.length; i++) {

      // if any character is not in upper case, return false
      if (!Character.isUpperCase(charArray[i]))
        return false;
    }

    return true;
  }*/
}
