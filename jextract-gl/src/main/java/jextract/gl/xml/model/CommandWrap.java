package jextract.gl.xml.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import jextract.gl.generate.java.Arg;
import jextractgl.Registry.Commands.Command;
import jextractgl.Registry.Commands.Command.Alias;
import jextractgl.Registry.Commands.Command.Param;
import jextractgl.Registry.Commands.Command.Proto;

public class CommandWrap {
  private static final String ADDRESSABLE = "java.lang.foreign.Addressable";
  String name;
  String alias;
  List<Arg> args = new ArrayList<>();
  
  public CommandWrap(Command c) {
    readCommand(c);
  }

  protected void readCommand(Command c) {
    // Command name
    Proto proto = c.getProto();
    Alias alias = c.getAlias();

    name = proto.getName();
    
    if(alias!=null) {
      this.alias = alias.getName();
    }
    

    readParams(c);
  }

  protected void readParams(Command c) {
    // Command parameters
    for(Param param: c.getParam()) {
      
      List<?> content = (List<?>)param.getContent();
      
      // We get either a type name OR a param name.
      // For 4 float we get the "GLfloat" type name followed by 4 param name (e.g. red, blue, green, alpha) 
      String currentTypeName = null;
      String currentParamName = null;

      for(Object parameterDescription: content) {
        
        // Get type (only) in content (not often, seamingly for buffers)
        if(parameterDescription instanceof String) {
          String innerType = (String)parameterDescription ;
          
          if( isPointer(innerType)) {
            currentTypeName = ADDRESSABLE;
          }
          
        }
        
        // Get type or name in dedicated elements
        else if(parameterDescription instanceof JAXBElement) {
          
          JAXBElement<?> j = (JAXBElement<?>) parameterDescription;

          // We get the parameter type name
          if("ptype".equals(j.getName().toString())) {
            currentTypeName = GLToJavaType(j.getValue().toString());
          }
          // We get the parameter name
          else if("name".equals(j.getName().toString())) {
            currentParamName = j.getValue().toString();
          }
        }
        else {
          throw new RuntimeException("Unexpected type !!" + parameterDescription.getClass() + " for " + parameterDescription);
        }
        
        // When both are available, can declare an argument
        if(currentParamName!=null && currentTypeName!=null) {
          // CREATE 
          Arg arg = new Arg(Object.class, currentParamName);
          arg.setTypeName(currentTypeName);
          args.add(arg);
        }


      }
      
    }
  }

  private boolean isPointer(String innerType) {
    return " *".equals(innerType) 
        || "void *".equals(innerType) 
        || "void **".equals(innerType) 
        || " *const*".equals(innerType)
        || "const void *".equals(innerType) 
        || "const void *const*".equals(innerType) 
        || "const <ptype>GLsizei</ptype> *".equals(innerType);
  }
  
  public String GLToJavaType(String type) {
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
    else if("GLintptr".equals(type) || "GLintptrARB".equals(type)) {
      type = "long";
    }
    else if( 
        "GLsizeiptr".equals(type) || 
        "GLsizeiptrARB".equals(type) ) {
       type = "long";
     }

    else if( 
        "GLsizeiptr".equals(type) || 
        "GLfixed".equals(type) || "GLclampx".equals(type)|| "GLDEBUGPROC".equals(type)) {
       //type = "int";
     }

    return type;
  }
  
  // *****************************************
  
  public String getName() {
    return name;
  }

  public String getAlias() {
    return alias;
  }

  public List<Arg> getArgs() {
    return args;
  }
}
