package panamagl.opengl;

/**
 * A toy helper to track GL errors.
 * 
 * Should later be improved as made in JOGL with a pipeline approach.
 * 
 * @author Martin Pernollet
 *
 */
public class GLError {
  int code;
  String message;
  
  public GLError(int code, String message) {
    this.code = code;
    this.message = message;
  }

  @Override
  public String toString() {
    return message + " (" + code + ")";
  }

  /** Throw a runtime exception with this message and error code */
  public void throwRuntimeException() {
    throw new RuntimeException(toString());
  }


  /** Print error on system.err */
  public void systemErrPrint() {
    System.err.println(toString());
    //throw new RuntimeException(message);
  }


  /** 
   * Check if the open gl pipeline is in an erroenous state. Return an error if it is, null otherwise.
   * 
   * @see https://registry.khronos.org/OpenGL-Refpages/gl4/html/glGetError.xhtml 
   */
  public static GLError get(GL gl) {
    
    
    int code = gl.glGetError();
    String message = gl.gluErrorString(code);
    
    if(code!=0) {
      return new GLError(code, message);
    }
    else {
      return null;
    }
  }
  
  public static void checkAndThrow(GL gl) {
    GLError e = get(gl);
    if(e!=null) {
      e.throwRuntimeException();
    }
  }
  
  public static void checkAndPrint(GL gl) {
    GLError e = get(gl);
    if(e!=null) {
      e.systemErrPrint();
    }
  }

}
