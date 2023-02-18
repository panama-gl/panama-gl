package jextract.gl.generate.java;
public class Code{
  String line;
  public Code(String line) {
    this.line = line;
  }
  
  public static Code throwNewRuntimeException(String message) {
    return new Code("throw new RuntimeException(\""+message+"\");");
  }
  
  public static Code throwNotImplemented() {
    return throwNewRuntimeException("Not implemented!");
  }

}
