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
        if(parameterDescription instanceof JAXBElement) {
          
          JAXBElement<?> j = (JAXBElement<?>) parameterDescription;

          // We get the parameter type name
          if("ptype".equals(j.getName().toString())) {
            currentTypeName = GLToJavaType(j.getValue().toString());
          }
          // We get the parameter name
          else if("name".equals(j.getName().toString())) {
            currentParamName = j.getValue().toString();
          }
          
          // When both are available, can declare an argument
          if(currentParamName!=null && currentTypeName!=null) {
            // CREATE 
            Arg arg = new Arg(Object.class, currentParamName);
            arg.setTypeName(currentTypeName);
            args.add(arg);
          }
        }
        // These cases should not occur
        else if (parameterDescription instanceof String){
        }
        else {
          throw new RuntimeException("Unexpected type !!" + parameterDescription.getClass() + " for " + parameterDescription);
        }

      }
      
    }
  }
  
  public String GLToJavaType(String type) {
    if("GLenum".equals(type) || "mask".equals(type)|| "GLsync".equals(type) || 
       "GLsizei".equals(type) ||"GLsizeiptr".equals(type) || "GLbitfield".equals(type) || 
       "GLfixed".equals(type) || "GLclampx".equals(type)|| "GLDEBUGPROC".equals(type)) {
      type = "int";
    }
    else if("GLint".equals(type) || "GLuint".equals(type)|| "GLint64".equals(type)|| "GLuint64".equals(type)|| "GLintptr".equals(type)) {
      type = "int";
    }
    else if("GLboolean".equals(type)){
      type = "boolean";
    }
    else if("GLdouble".equals(type)){
      type = "double";
    }
    else if("GLfloat".equals(type)){
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
