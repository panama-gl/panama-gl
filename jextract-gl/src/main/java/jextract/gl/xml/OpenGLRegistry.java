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
package jextract.gl.xml;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.bind.JAXBElement;
import jextract.gl.xml.model.GLCommand;
import jextract.gl.xml.parser.Registry;
import jextract.gl.xml.parser.Registry.Enums;
import jextract.gl.xml.parser.Registry.Feature;
import jextract.gl.xml.parser.Registry.Types;
import jextract.gl.xml.parser.Registry.Commands.Command;
import jextract.gl.xml.parser.Registry.Commands.Command.Alias;
import jextract.gl.xml.parser.Registry.Commands.Command.Param;
import jextract.gl.xml.parser.Registry.Commands.Command.Proto;
import jextract.gl.xml.parser.Registry.Feature.Remove;
import jextract.gl.xml.parser.Registry.Feature.Require;

public class OpenGLRegistry {
  JAXBHandler h = new JAXBHandler("jextract.gl.xml.parser");
  jextract.gl.xml.parser.Registry registry;

  public OpenGLRegistry() throws Exception {
    this("src/main/resources/gl-original.xml");
  }

  public OpenGLRegistry(String xml) throws Exception {
    registry = (jextract.gl.xml.parser.Registry) h.unmarshall(xml);
  }
  
  public Registry getRegistry(){
    return registry;
  }

  // ************************************************ //

  
  public Map<String,GLCommand> getCommandIndex() {
    Map<String,GLCommand> index = new HashMap<>();
    
    for(GLCommand com: getCommands()) {
      index.put(com.getName(), com);
    }
    
    return index;
    
  }
  
  public List<GLCommand> getCommands() {
    List<GLCommand> out = new ArrayList<>();

    Registry.Commands commands = registry.getCommands();

    for (Command c : commands.getCommand()) {
      GLCommand cw = new GLCommand(c);
      out.add(cw);
    }

    return out;
  }

  // ************************************************ //

  public void printTypes() {
    Types t = registry.getTypes();

    for (Types.Type type : t.getType()) {
      System.out.print(" type : ");

      List<?> v = (List<?>) type.getContent();

      for (Object oo : v) {
        System.out.print(oo);

      }
      System.out.println();
    }

    System.out.println(t);
  }

  public void printCommands() {
    // Commands
    System.err.println("COMMANDS");

    StringBuffer sb = new StringBuffer();

    Registry.Commands commands = registry.getCommands();



    System.out.println("Namespace : " + commands.getNamespace());

    int k = 0;

    for (Command c : commands.getCommand()) {
      // Command name
      Proto proto = c.getProto();
      Alias a = c.getAlias();

      String name = proto.getName();

      if (a != null) {
        name = (name + "(aka:" + proto.getName() + ")");
      }

      sb.append(name + "\t {");

      // Command parameters
      for (Param param : c.getParam()) {

        param.getGroup();
        String len = param.getLen();

        List<?> ls = (List<?>) param.getContent();

        // Each param content is a list containing, e.g. :
        // ptype:GLuint64 name:vkSemaphore
        for (Object parameterDescription : ls) {
          if (parameterDescription instanceof JAXBElement) {
            JAXBElement<?> j = (JAXBElement<?>) parameterDescription;
            String parameterType = j.getName().toString();
            String parameterName = (String) j.getValue();

            sb.append(parameterType + ":" + parameterName);

          }
          // These cases should not occur
          else if (parameterDescription instanceof String) {
            sb.append(parameterDescription);
          } else {
            throw new RuntimeException("Unexpected type !!" + parameterDescription.getClass()
                + " for " + parameterDescription);
          }

        }

        sb.append(", ");

      }
      sb.append("}");
      sb.append("\n");

      k++;
    }

    System.out.println(sb);
    System.out.println(k + " GL commands");
  }

  public void printFeatures() {

    boolean printRequire = false;

    System.err.println("FEATURES");

    for (Feature feature : registry.getFeature()) {
      System.out.println("Feature : " + feature.getApi() + " " + feature.getNumber() + " ("
          + feature.getName() + ")");

      for (Remove remove : feature.getRemove()) {
        System.out.println(" Remove : " + remove);
      }

      if (printRequire)
        for (Require require : feature.getRequire()) {
          System.out.println(" Require : " + require);

          for (Serializable s : require.getContent()) {
            if (s instanceof Feature.Require.Enum) {
              Feature.Require.Enum renum = (Feature.Require.Enum) s;
              System.out.println("  Enum : " + renum.getName());

            } else if (s instanceof Registry.Feature.Require.Command) {
              Registry.Feature.Require.Command com = (Registry.Feature.Require.Command) s;
              System.out.println("  Command : " + com.getName());
            } else if (s instanceof Feature.Require.Type) {
              Feature.Require.Type com = (Feature.Require.Type) s;
              System.out.println("  Type : " + com.getName());
            } else if (s instanceof String) {
            } else if (s instanceof JAXBElement) {
              JAXBElement e = (JAXBElement) s;

              Object oo = e.getValue();

              if (oo instanceof Feature.Require.Enum) {
                Feature.Require.Enum renum = (Feature.Require.Enum) oo;
                System.out.println("  Enum : " + renum.getName());

              } else if (oo instanceof Registry.Feature.Require.Command) {
                Registry.Feature.Require.Command com = (Registry.Feature.Require.Command) oo;
                System.out.println("  Command : " + com.getName());
              } else if (oo instanceof Feature.Require.Type) {
                Feature.Require.Type com = (Feature.Require.Type) oo;
                System.out.println("  Type : " + com.getName());
              } else {
                System.out.println(" Jaxb : " + oo);
              }

            } else {
              System.out.println(" ? : " + s.getClass().getName());
            }
          }
        }
      // break;
    }
  }

  public void printEnums() {
    System.err.println("ENUMS");

    for (Enums ee : registry.getEnums()) {
      System.out.println(
          " Enums block : " + ee.getNamespace() + "/" + ee.getVendor() + " " + ee.getComment());
      for (Serializable c : ee.getContent()) {
        if (c instanceof JAXBElement) {
          Object o = ((JAXBElement) c).getValue();

          if (o instanceof Registry.Enums.Enum) {
            Registry.Enums.Enum enu = (Registry.Enums.Enum) o;
            System.out.println(
                "  Enum : " + enu.getValue1() /* + " " + enu.getGroup() */ + "  " + enu.getName());
          }


        } else {
          // System.out.println(" Enum : " + c);
        }
      }
    }
  }
  
  public Map<String, Registry.Enums.Enum> getEnumIndex() {
    
    Map<String, Registry.Enums.Enum> index = new HashMap<>();
    
    for (Enums ee : registry.getEnums()) {

      for (Serializable c : ee.getContent()) {
        if (c instanceof JAXBElement) {
          Object o = ((JAXBElement) c).getValue();

          if (o instanceof Registry.Enums.Enum) {
            Registry.Enums.Enum enu = (Registry.Enums.Enum) o;
            
            index.put(enu.getName(), enu);
          }
        } else {
        }
      }
    }
    return index;
  }
  


}
