package jextract.gl.xml.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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
  String outputType;
  
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
    
    if(proto.getPtype()!=null && !proto.getPtype().equals("void")) {
      if("String".equals(proto.getGroup())) {
        outputType = "String";
      }
      else {
        outputType = GLTypeInJava.toJava(proto.getPtype());
      }
    }
    else {
      outputType = "void";
    }
    
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
          
          if( GLTypeInJava.isPointer(innerType)) {
            currentTypeName = GLTypeInJava.ADDRESSABLE;
          }
          
        }
        
        // Get type or name in dedicated elements
        else if(parameterDescription instanceof JAXBElement) {
          
          JAXBElement<?> j = (JAXBElement<?>) parameterDescription;

          // We get the parameter type name
          if("ptype".equals(j.getName().toString())) {
            currentTypeName = GLTypeInJava.toJava(j.getValue().toString());
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
  
  public String getOutputType() {
    return outputType;
  }

  @Override
  public int hashCode() {
    return Objects.hash(alias, args, name, outputType);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    CommandWrap other = (CommandWrap) obj;
    return Objects.equals(alias, other.alias) && Objects.equals(args, other.args)
        && Objects.equals(name, other.name) && Objects.equals(outputType, other.outputType);
  }
  
  
}
