package jextract.gl;

public class APIPlatform {
  public final CPU cpu;
  public final OS os;
  
  public APIPlatform(OS os, CPU cpu) {
    this.os = os;
    this.cpu = cpu;
  }

  public APIPlatform(OS os) {
    this.os = os;
    this.cpu = null;
  }

  public String getName() {
    return os + "_" + cpu;
  }

  public enum CPU{
    x64, x32, arm;
  }
  
  public enum OS{
    api, macOS, linux, windows;
  }
}
