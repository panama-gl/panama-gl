package panamagl.platform.linux.x86; 


public class PanamaGLFactory_linux_x86 extends panamagl.os.linux.APanamaGLFactory_linux {
  public panamagl.opengl.GL_2 newGL_() {
    return new panamagl.platform.linux.x86.GLImpl();
  }

  public panamagl.opengl.GL newGL() {
    throw new RuntimeException("Not implemented!");
  }

}
