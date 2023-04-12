package jextract.gl;

public class APIPlatform {
  public final CPU cpu;
  public final OS os;
  
  public APIPlatform(OS os, CPU cpu) {
    this.os = os;
    this.cpu = cpu;
  }
  
  public String getName() {
    return os + "_" + cpu;
  }

  public enum CPU{
    x64, x32, arm;
  }
  
  public enum OS{
    macOS, linux, windows;
  }
}
