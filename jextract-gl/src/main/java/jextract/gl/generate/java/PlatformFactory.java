package jextract.gl.generate.java;

public class PlatformFactory {
  public String name;
  public Class<?> base;
  public String javaFile;
  public String packge;
  
  public void setFileIn(String folder) {
    javaFile = folder + packge.replace(".", "/") + "/" + name + ".java";
  }
}
