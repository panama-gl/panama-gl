package panamagl.platform.windows.x64; 


public class PanamaGLFactory_windows_x64 extends panamagl.platform.windows.APanamaGLFactory_windows implements panamagl.factory.PanamaGLFactory {
  public panamagl.opengl.GL newGL() {
    return new panamagl.platform.windows.x64.GL_windows_x64();
  }

}
