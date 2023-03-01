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
package jextract.gl;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import javax.xml.bind.JAXBElement;
import com.google.common.collect.ArrayListMultimap;
import jextract.gl.generate.java.Arg;
import jextract.gl.generate.java.ClassCompiler;
import jextract.gl.generate.java.Interf;
import jextract.gl.generate.java.InterfaceWriter;
import jextract.gl.xml.OpenGLRegistry;
import jextract.gl.xml.model.GLCommand;
import jextractgl.Registry;
import jextractgl.Registry.Feature;
import jextractgl.Registry.Feature.Remove;
import jextractgl.Registry.Feature.Require;

public class GenerateInterfaceFromRegistry {
  protected OpenGLRegistry registry;
  protected Map<String, Registry.Enums.Enum> enumIndex;
  protected Map<String, GLCommand> commandIndex;

  public static void main(String[] args) throws Exception {
    GenerateInterfaceFromRegistry gen = new GenerateInterfaceFromRegistry();
    Interf interf = new Interf();
    interf.javaFolder = "target/";
    interf.packge = "panama.opengl";
    
    List<String> javaFiles = gen.generateInterfaces(interf);

    gen.compile(javaFiles);
  }

  public GenerateInterfaceFromRegistry() throws Exception {
    registry = new OpenGLRegistry();
    enumIndex = registry.getEnumIndex();
    commandIndex = registry.getCommandIndex();
  }



  public List<String> generateInterfaces(Interf interf) throws Exception {
    List<String> javaFiles = new ArrayList<>();
    
    


    // ------------------------------------------
    // Create writers

    Map<String, InterfaceWriter> interfaceWriters = new HashMap<>();

    for (Feature feature : registry.getRegistry().getFeature()) {
      String name = registryFeatureToGLInterfaceName(feature);

      InterfaceWriter interfaceWriter = new InterfaceWriter(interf.packge, name);

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

    writeInterfaceMinorVersion(interf.javaFolder, javaFiles, interfaceWriters, dependencies);
    
    // Create a single interface for MAJOR GL versions, including all minors
    
    writeInterfaceMajorVersion(interf.javaFolder, javaFiles, interf.packge, interfaceWriters, "GL_1");
    writeInterfaceMajorVersion(interf.javaFolder, javaFiles, interf.packge, interfaceWriters, "GL_2");
    writeInterfaceMajorVersion(interf.javaFolder, javaFiles, interf.packge, interfaceWriters, "GL_3");
    writeInterfaceMajorVersion(interf.javaFolder, javaFiles, interf.packge, interfaceWriters, "GL_4");


    return javaFiles;
  }

  /**
   * Create a major GL version interface embedding all minor versions
   * @param folder
   * @param javaFiles
   * @param packge
   * @param interfaceWriters
   * @param major
   * @throws IOException
   */
  private void writeInterfaceMajorVersion(String folder, List<String> javaFiles, String packge,
      Map<String, InterfaceWriter> interfaceWriters, String major) throws IOException {
    List<String> minors = new ArrayList<>();
    for(String minor: interfaceWriters.keySet()) {
      String[] i1s = major.split("_");
      String[] i2s = minor.split("_");
      
      int name = 0;
      int maj = 1;
      int min = 2;
      
      if(i1s[name].equals(i2s[name]) && i1s[maj].equals(i2s[maj])) {
        minors.add(minor);
      }

    }
    
    InterfaceWriter interfaceWriter = new InterfaceWriter(packge, major);
    
    for(String minor: minors) {
      interfaceWriter.addExtension(minor);      
    }
    
    StringBuffer javaCode = new StringBuffer();

    interfaceWriter.start(javaCode);
    interfaceWriter.close(javaCode);

    // Write code to disk
    String javaFile = folder + major + ".java";
    interfaceWriter.writeTo(javaCode, javaFile);

    // Keep track of the java file
    javaFiles.add(javaFile);
    
  }

  private void writeInterfaceMinorVersion(String folder, List<String> javaFiles,
      Map<String, InterfaceWriter> interfaceWriters, ArrayListMultimap<String, String> dependencies)
      throws IOException {
    for (Feature feature : registry.getRegistry().getFeature()) {

      // -----------------
      // Get and configure writer
      String name = registryFeatureToGLInterfaceName(feature);
      String javaFile = folder + name + ".java";

      InterfaceWriter interfaceWriter = interfaceWriters.get(name);
      interfaceWriter.addImport("java.lang.foreign.*");
      for(String dependency: dependencies.get(name)) {
        interfaceWriter.addExtension(dependency);
      }
      
      // ----------------
      // Does Write
      StringBuffer javaCode = new StringBuffer();

      interfaceWriter.start(javaCode);
      generateInterfaceContent(interfaceWriter, feature, javaCode);
      interfaceWriter.close(javaCode);

      // Write code to disk
      interfaceWriter.writeTo(javaCode, javaFile);

      // Keep track of the java file
      javaFiles.add(javaFile);

    }
  }

  protected void generateInterfaceContent(InterfaceWriter interfaceWriter, Feature feature, StringBuffer javaCode) {
    for (Remove remove : feature.getRemove()) {
      // System.out.println(" Remove : " + remove);
    }

    for (Require require : feature.getRequire()) {
      // System.out.println(" Require : " + require.getComment());

      for (Serializable s : require.getContent()) {


        if (s instanceof Feature.Require.Enum) {
          Feature.Require.Enum renum = (Feature.Require.Enum) s;
          handleEnum(interfaceWriter, renum, javaCode);
        }

        else if (s instanceof Registry.Feature.Require.Command) {
          Registry.Feature.Require.Command com = (Registry.Feature.Require.Command) s;
          handleCommand(interfaceWriter, com, javaCode);
        }

        else if (s instanceof Feature.Require.Type) {
          Feature.Require.Type com = (Feature.Require.Type) s;
          handleType(interfaceWriter, com, javaCode);
        }

        else if (s instanceof String) {
        }


        else if (s instanceof JAXBElement) {
          JAXBElement e = (JAXBElement) s;

          Object oo = e.getValue();

          if (oo instanceof Feature.Require.Enum) {
            Feature.Require.Enum renum = (Feature.Require.Enum) oo;
            handleEnum(interfaceWriter, renum, javaCode);
          } else if (oo instanceof Registry.Feature.Require.Command) {
            Registry.Feature.Require.Command com = (Registry.Feature.Require.Command) oo;
            handleCommand(interfaceWriter, com, javaCode);
          } else if (oo instanceof Feature.Require.Type) {
            Feature.Require.Type com = (Feature.Require.Type) oo;
            handleType(interfaceWriter, com, javaCode);
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

  protected void handleType(InterfaceWriter interfaceWriter, Feature.Require.Type com, StringBuffer javaCode) {
    // System.out.println(" Type : " + com.getName());
  }
  

  protected void handleCommand(InterfaceWriter interfaceWriter, Registry.Feature.Require.Command com, StringBuffer javaCode) {
    // System.out.println(" Command : " + com.getName() + "=" + com.getValue());

    GLCommand command = getCommand(com.getName());
    
    String outputType = command.getOutputType();
    
 // TODO : EXTRACT SPECIAL CASE    
    if("glMapBuffer".equals(command.getName())
     || "glMapBufferRange".equals(command.getName())
     || "glMapNamedBuffer".equals(command.getName())
     || "glMapNamedBufferRange".equals(command.getName())){
      outputType = "MemoryAddress";
    }
    
    String methodName = command.getName();
    List<Arg> input = command.getArgs();
    
    
    interfaceWriter.method(javaCode, methodName, input, outputType);
  }



  private void handleEnum(InterfaceWriter interfaceWriter, Feature.Require.Enum renum, StringBuffer javaCode) {
    Registry.Enums.Enum enumC = enumIndex.get(renum.getName());

    String value = enumC.getValue1();
    String type = "int";

    if ("0xFFFFFFFFFFFFFFFF".equals(value)) {
      value = "0xFFFFFFFF";
      type = "long";
    }

    String name = enumC.getName();
    interfaceWriter.constant(javaCode, name, type, value);

    // System.out.println(" Enum : " + line);

  }

  public GLCommand getCommand(String name) {
    return commandIndex.get(name);
  }


  // ---------------------------------------------------------------

  public void compile(List<String> javaFile) throws IOException {
    ClassCompiler c = new ClassCompiler();
    c.compile(javaFile);
  }

}
