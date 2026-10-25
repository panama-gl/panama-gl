package panamagl.platform.linux; 


public class PanamaGLFactory_linux extends panamagl.platform.linux.APanamaGLFactory_linux implements panamagl.factory.PanamaGLFactory {
  public panamagl.opengl.GL newGL() {
    return new panamagl.platform.linux.GL_linux();
  }

  public boolean matches(panamagl.platform.Platform platform) {
    return new panamagl.platform.linux.PlatformMatcher_linux().matches(platform);
  }

}
