package jextract.gl.java;

import java.lang.reflect.Method;

public interface AcceptsMethod {
  boolean accepts(Method method);
}
