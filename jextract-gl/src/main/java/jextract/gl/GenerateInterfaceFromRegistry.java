package jextract.gl;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.xml.bind.JAXBElement;
import jextract.gl.generate.java.ClassCompiler;
import jextract.gl.generate.java.InterfaceWriter;
import jextract.gl.xml.OpenGLRegistry;
import jextractgl.Registry;
import jextractgl.Registry.Feature;
import jextractgl.Registry.Feature.Remove;
import jextractgl.Registry.Feature.Require;

public class GenerateInterfaceFromRegistry {
  OpenGLRegistry registry;
  Map<String, Registry.Enums.Enum>  enumIndex;

  
  
  public static void main(String[] args) throws Exception {
    GenerateInterfaceFromRegistry gen = new GenerateInterfaceFromRegistry();
    
    List<String> javaFiles = gen.generateInterfaces("target/");
    
    gen.compile(javaFiles);
  }
  
  public GenerateInterfaceFromRegistry() throws Exception {
    registry = new OpenGLRegistry();
    enumIndex = registry.getEnums();
  }

  


  public List<String> generateInterfaces(String folder) throws Exception {
    List<String> javaFiles = new ArrayList<>();

    

    boolean printRequire = true;

    System.err.println("FEATURES");

    for (Feature feature : registry.getRegistry().getFeature()) {
      
      
      String version = feature.getNumber().toString();
      String name = feature.getApi().toUpperCase() + "_" + version.replace(".", "_");
      
      String javaFile = folder+name+".java";

      InterfaceWriter interfaceWriter = new InterfaceWriter("panama.opengl", name);
      StringBuffer javaCode = new StringBuffer();

      
      /*System.out.println("Feature : " + feature.getApi() + " " + feature.getNumber() + " ("
          + feature.getName() + ")");*/
      
      
      interfaceWriter.start(javaCode);
      

      for (Remove remove : feature.getRemove()) {
        System.out.println(" Remove : " + remove);
      }

      if (printRequire)
        for (Require require : feature.getRequire()) {
          System.out.println(" Require : " + require.getComment());

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
              } 
              else if (oo instanceof Registry.Feature.Require.Command) {
                Registry.Feature.Require.Command com = (Registry.Feature.Require.Command) oo;
                handleCommand(com, javaCode);
              } 
              else if (oo instanceof Feature.Require.Type) {
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
      // break;
      
      
      interfaceWriter.close(javaCode);
      
      // Write code to disk
      interfaceWriter.writeTo(javaCode, javaFile);
      
      javaFiles.add(javaFile);

    }
    
    return javaFiles;
  }

  private void handleType(Feature.Require.Type com, StringBuffer javaCode) {
    System.out.println("  Type : " + com.getName());
  }

  private void handleCommand(Registry.Feature.Require.Command com, StringBuffer javaCode) {
    System.out.println("  Command : " + com.getName() + "=" + com.getValue());
  }

  private void handleEnum(Feature.Require.Enum renum, StringBuffer javaCode) {
    
    Registry.Enums.Enum enumC = enumIndex.get(renum.getName());
    
    String value = enumC.getValue1();
    // 0x8CA5
    // 0xFFFFFFFFFFFFFFFF
    String type = "int";
    
    //if(value.length()>6)
    //  type  = "long";
    
    if("0xFFFFFFFFFFFFFFFF".equals(value)) {
      value = "0xFFFFFFFF";
      type  = "long";
    }
    
    String line = /*enumC.getType()*/ "public static " + type + " " + enumC.getName() + " = " + value+ ";";
    
    //registry.getRegistry().
    
    // Check if this line of code as allready been writen
    if(!javaCode.toString().contains(line))
      javaCode.append("  " + line + "\n");
    
    System.out.println("  Enum : " + line);

  }
  
  
  public void compile(List<String> javaFile) throws IOException {
    ClassCompiler c = new ClassCompiler();
    c.compile(javaFile);    
  }

}
