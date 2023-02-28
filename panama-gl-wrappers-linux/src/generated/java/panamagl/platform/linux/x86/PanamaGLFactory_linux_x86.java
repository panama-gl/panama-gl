package panamagl.platform.linux.x86; 


public class PanamaGLFactory_linux_x86 extends panamagl.os.linux.APanamaGLFactory_linux implements panamagl.factory.PanamaGLFactory {
  public panamagl.opengl.GL newGL() {
    return new panamagl.platform.linux.x86.GL_linux_x86();
  }

}
