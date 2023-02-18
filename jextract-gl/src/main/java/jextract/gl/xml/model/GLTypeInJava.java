package jextract.gl.xml.model;

public class GLTypeInJava {
  public static final String ADDRESSABLE = "Addressable"; // java.lang.foreign.

  public static boolean isPointer(String innerType) {
    return " *".equals(innerType) 
        || "void *".equals(innerType) 
        || "void **".equals(innerType) 
        || " *const*".equals(innerType)
        || "const void *".equals(innerType) 
        || "const void **".equals(innerType) 
        || "const void *const*".equals(innerType) 
        || "const <ptype>GLsizei</ptype> *".equals(innerType);
  }
  
  public static String toJava(String type) {
    if("GLenum".equals(type) || "mask".equals(type)|| "GLsizei".equals(type) || "GLbitfield".equals(type) ) {
      type = "int";
    }
    else if("GLint".equals(type) || "GLuint".equals(type)|| "GLint64".equals(type)) {
      type = "int";
    }
    else if("GLuint64".equals(type)) {
      type = "long";      
    }
    else if("GLboolean".equals(type)){
      type = "byte";//"boolean";
    }
    else if("GLdouble".equals(type) || "GLclampd".equals(type)){
      type = "double";
    }
    else if("GLfloat".equals(type) || "GLclampf".equals(type)){
      type = "float";
    }
    else if("GLshort".equals(type) || "GLushort".equals(type) ){
      type = "short";
    }
    else if("GLbyte".equals(type) || "GLubyte".equals(type)) {
      type = "byte";
    }
    else if("GLchar".equals(type)){
      type = "char";
    }
    else if("GLhandleARB".equals(type) || "GLcharARB".equals(type) || "GLsync".equals(type)) {
      type = ADDRESSABLE;
    }
    // GLsizeiptrARB
    else if("GLintptr".equals(type) || "GLintptrARB".equals(type) || "GLuint64EXT".equals(type)|| "GLint64EXT".equals(type)) {
      type = "long";
    }
    else if( 
        "GLsizeiptr".equals(type) || 
        "GLsizeiptrARB".equals(type) ) {
       type = "long";
     }
    else if( 
        "GLsizeiptr".equals(type) || 
        "GLfixed".equals(type) || "GLclampx".equals(type)) {
       type = "int";
     }
    else if("GLhalfNV".equals(type)) {
      type = "short";
    }
    else if("GLeglClientBufferEXT".equals(type)) {
      type = ADDRESSABLE;
    }
    else if( 
        "GLDEBUGPROCARB".equals(type) || "GLDEBUGPROCAMD".equals(type)|| "GLDEBUGPROCKHR".equals(type) || "GLDEBUGPROC".equals(type) ) {
       type = ADDRESSABLE;
     }

    // DON T KNOW
    else if( 
        "GLvdpauSurfaceNV".equals(type) || 
        "GLeglImageOES".equals(type) ||  
        "GLVULKANPROCNV".equals(type)) {
       type = "int";
     }

    return type;
  }
}
