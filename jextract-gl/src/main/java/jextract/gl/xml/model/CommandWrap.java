package jextract.gl.xml.model;

import java.util.List;
import javax.xml.bind.JAXBElement;
import jextractgl.Registry.Commands.Command;
import jextractgl.Registry.Commands.Command.Alias;
import jextractgl.Registry.Commands.Command.Param;
import jextractgl.Registry.Commands.Command.Proto;

public class CommandWrap {
  String name;
  String alias;
  
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
      //param.getGroup();
      //String len = param.getLen();
      
      
      // Each param content is a list containing, e.g. :
      // ptype:GLuint64   name:vkSemaphore
      
      List<?> ls = (List<?>)param.getContent();

      for(Object parameterDescription: ls) {
        if(parameterDescription instanceof JAXBElement) {
          readParam(parameterDescription);
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

  protected void readParam(Object parameterDescription) {
    JAXBElement<?> j = (JAXBElement<?>) parameterDescription;
    String parameterType = j.getName().toString();
    String parameterName = (String)j.getValue();
  }
  
  // *****************************************
  
  public String getName() {
    return name;
  }

  public String getAlias() {
    return alias;
  }
  
  
}
