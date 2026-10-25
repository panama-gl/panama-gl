package jextract.gl;

/**
 * The OS for which an API is generated. The generated wrappers do not depend on the CPU : the
 * bindings of an OS are the same for x86_64 and ARM64.
 */
public class APIPlatform {
  public final OS os;

  public APIPlatform(OS os) {
    this.os = os;
  }

  public String getName() {
    return os.toString();
  }

  public enum OS{
    api, macOS, linux, windows;
  }
}
