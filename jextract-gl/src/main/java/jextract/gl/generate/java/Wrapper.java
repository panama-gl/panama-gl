package jextract.gl.generate.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import jextract.gl.java.AcceptsMethod;

public class Wrapper {
  public Set<Class<?>> wrapped;
  // Class<?> wrapped = opengl.ubuntu.v20.glut_h.class;
  public AcceptsMethod accepts;
  public String className;
  public String packge;
  public String javaFile;
  public List<String> implement = new ArrayList<>();
  public List<String> extend = new ArrayList<>();
  public String platform;
  
  public void setFileIn(String folder) {
    javaFile = folder + packge.replace(".", "/") + "/" + className + ".java";
  }


  public void addImplement(String impl) {
    implement.add(impl);
  }

  public void addImplement(List<String> impl) {
    implement.addAll(impl);
  }
  public void addExtension(String impl) {
    extend.add(impl);
  }

  public void addExtension(List<String> impl) {
    extend.addAll(impl);
  }

}
