package panamagl.platform.macos.x86; 


public class PanamaGLFactory_macOS_x86 extends panamagl.os.macos.APanamaGLFactory_macOS {
  public panamagl.opengl.GL_2 newGL_() {
    return new panamagl.platform.macos.x86.GLImpl();
  }

  public panamagl.opengl.GL newGL() {
    throw new RuntimeException("Not implemented!");
  }

}
