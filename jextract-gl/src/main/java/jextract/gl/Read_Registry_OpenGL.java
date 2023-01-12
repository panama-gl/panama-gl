package jextract.gl;

import jextract.gl.xml.OpenGLRegistry;

public class Read_Registry_OpenGL {

  public static void main(String[] args) throws Exception {

    OpenGLRegistry registry = new OpenGLRegistry("src/main/resources/gl-original.xml");
    
    /*registry.printTypes();
    registry.printEnums();
    registry.printFeatures();*/
    registry.printCommands();
  }



}
