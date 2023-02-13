package jextract.gl;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import javax.xml.bind.JAXBElement;
import com.google.common.collect.ArrayListMultimap;
import jextract.gl.generate.java.Arg;
import jextract.gl.generate.java.ClassCompiler;
import jextract.gl.generate.java.InterfaceWriter;
import jextract.gl.xml.OpenGLRegistry;
import jextract.gl.xml.model.CommandWrap;
import jextractgl.Registry;
import jextractgl.Registry.Feature;
import jextractgl.Registry.Feature.Remove;
import jextractgl.Registry.Feature.Require;

public class GenerateInterfaceFromRegistry {
  OpenGLRegistry registry;
  Map<String, Registry.Enums.Enum> enumIndex;
  Map<String, CommandWrap> commandIndex;



  public static void main(String[] args) throws Exception {
    GenerateInterfaceFromRegistry gen = new GenerateInterfaceFromRegistry();

    List<String> javaFiles = gen.generateInterfaces("target/", "panama.opengl");

    gen.compile(javaFiles);
  }

  public GenerateInterfaceFromRegistry() throws Exception {
    registry = new OpenGLRegistry();
    enumIndex = registry.getEnumIndex();
    commandIndex = registry.getCommandIndex();
  }



  public List<String> generateInterfaces(String folder, String packge) throws Exception {
    List<String> javaFiles = new ArrayList<>();


    // ------------------------------------------
    // Create writers

    Map<String, InterfaceWriter> interfaceWriters = new HashMap<>();

    for (Feature feature : registry.getRegistry().getFeature()) {
      String name = registryFeatureToGLInterfaceName(feature);

      InterfaceWriter interfaceWriter = new InterfaceWriter(packge, name);

      interfaceWriters.put(name, interfaceWriter);
    }

    // ------------------------------------------
    // Rank & link GL versions
    //
    // create GL_4_6 -> GL_4_5 -> etc

    Map<String, String> versionMesh = new HashMap<>();

    List<String> interfaceInOrder = new ArrayList<>(new TreeSet<>(interfaceWriters.keySet()));

    System.out.println(interfaceInOrder);
     
     ArrayListMultimap<String, String> dependencies = ArrayListMultimap.create();
     
    for(int i=0; i<interfaceInOrder.size()-1; i++) {
      String i1 = interfaceInOrder.get(i);
      String i2 = interfaceInOrder.get(i+1);
      
      String[] i1s = i1.split("_");
      String[] i2s = i2.split("_");
      
      int name = 0;
      int major = 1;
      int minor = 2;
      
      if(i1s[name].equals(i2s[name]) && i1s[major].equals(i2s[major])) {
        dependencies.put(i2, i1);
      }
      
      //System.out.println(i1s[0] + " " + i1s[1]+ " " + i1s[2]);
    }

    // ------------------------------------------
    // Write each interface body

    for (Feature feature : registry.getRegistry().getFeature()) {

      String name = registryFeatureToGLInterfaceName(feature);
      String javaFile = folder + name + ".java";

      InterfaceWriter interfaceWriter = interfaceWriters.get(name);
      
      for(String dependency: dependencies.get(name)) {
        interfaceWriter.addExtension(dependency);
      }
      
      StringBuffer javaCode = new StringBuffer();

      interfaceWriter.start(javaCode);
      generateInterfaceContent(feature, javaCode);
      interfaceWriter.close(javaCode);

      // Write code to disk
      interfaceWriter.writeTo(javaCode, javaFile);

      // Keep track of the java file
      javaFiles.add(javaFile);

    }

    return javaFiles;
  }

  protected void generateInterfaceContent(Feature feature, StringBuffer javaCode) {
    for (Remove remove : feature.getRemove()) {
      // System.out.println(" Remove : " + remove);
    }

    for (Require require : feature.getRequire()) {
      // System.out.println(" Require : " + require.getComment());

      for (Serializable s : require.getContent()) {


        if (s instanceof Feature.Require.Enum) {
          Feature.Require.Enum renum = (Feature.Require.Enum) s;
          handleEnum(renum, javaCode);
        }


        else if (s instanceof Registry.Feature.Require.Command) {
          Registry.Feature.Require.Command com = (Registry.Feature.Require.Command) s;
          handleCommand(com, javaCode);
        }


        else if (s instanceof Feature.Require.Type) {
          Feature.Require.Type com = (Feature.Require.Type) s;
          handleType(com, javaCode);
        }

        else if (s instanceof String) {
        }


        else if (s instanceof JAXBElement) {
          JAXBElement e = (JAXBElement) s;

          Object oo = e.getValue();

          if (oo instanceof Feature.Require.Enum) {
            Feature.Require.Enum renum = (Feature.Require.Enum) oo;
            handleEnum(renum, javaCode);
          } else if (oo instanceof Registry.Feature.Require.Command) {
            Registry.Feature.Require.Command com = (Registry.Feature.Require.Command) oo;
            handleCommand(com, javaCode);
          } else if (oo instanceof Feature.Require.Type) {
            Feature.Require.Type com = (Feature.Require.Type) oo;
            handleType(com, javaCode);
          }

          else {
            System.out.println(" Jaxb : " + oo);
          }

        } else {
          System.out.println(" ? : " + s.getClass().getName());
        }
      }
    }
  }

  protected String registryFeatureToGLInterfaceName(Feature feature) {
    String version = feature.getNumber().toString();
    String name = feature.getApi().toUpperCase() + "_" + version.replace(".", "_");
    return name;
  }

  protected void handleType(Feature.Require.Type com, StringBuffer javaCode) {
    // System.out.println(" Type : " + com.getName());
  }
  
  public CommandWrap getCommand(String name) {
    return commandIndex.get(name);
  }

  protected void handleCommand(Registry.Feature.Require.Command com, StringBuffer javaCode) {
    // System.out.println(" Command : " + com.getName() + "=" + com.getValue());

    CommandWrap command = getCommand(com.getName());

    String methodName = "public void " + command.getName() + "(";

    // if(javaCode.con)
    StringBuffer argBuffer = new StringBuffer();

    argBuffer.append(methodName);

    int k = 0;
    for (Arg arg : command.getArgs()) {
      String declare = arg.getTypeName() + " " + arg.getName();

      if (argBuffer.toString().contains(declare)) {
        k++;
        continue;
      } else {
        if (k == 0) {
          argBuffer.append(declare);
        } else {
          argBuffer.append(", " + declare);
        }
        k++;
      }
    }

    argBuffer.append(");\n");

    if (!javaCode.toString().contains(argBuffer.toString())) {
      javaCode.append("  " + argBuffer.toString());
    }
  }

  private void handleEnum(Feature.Require.Enum renum, StringBuffer javaCode) {
    Registry.Enums.Enum enumC = enumIndex.get(renum.getName());

    String value = enumC.getValue1();
    String type = "int";

    if ("0xFFFFFFFFFFFFFFFF".equals(value)) {
      value = "0xFFFFFFFF";
      type = "long";
    }

    String line = "public static " + type + " " + enumC.getName() + " = " + value + ";";

    // Check if this line of code as allready been writen
    if (!javaCode.toString().contains(line))
      javaCode.append("  " + line + "\n");

    // System.out.println(" Enum : " + line);

  }


  // ---------------------------------------------------------------

  public void compile(List<String> javaFile) throws IOException {
    ClassCompiler c = new ClassCompiler();
    c.compile(javaFile);
  }

}
