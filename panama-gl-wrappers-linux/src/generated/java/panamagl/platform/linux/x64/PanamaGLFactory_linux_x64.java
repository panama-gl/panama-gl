package panamagl.platform.linux.x64; 


public class PanamaGLFactory_linux_x64 extends panamagl.platform.linux.APanamaGLFactory_linux implements panamagl.factory.PanamaGLFactory {
  public panamagl.opengl.GL newGL() {
    return new panamagl.platform.linux.x64.GL_linux_x64();
  }

}
