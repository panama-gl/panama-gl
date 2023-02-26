/*******************************************************************************
 * Copyright (c) 2022, 2023 Martin Pernollet & contributors.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301, USA
 *******************************************************************************/
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
    String message = gl.gluErrorString(code).getUtf8String(0);
    
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
