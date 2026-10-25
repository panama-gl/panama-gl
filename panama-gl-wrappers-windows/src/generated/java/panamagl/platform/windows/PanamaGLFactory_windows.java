package panamagl.platform.windows; 


public class PanamaGLFactory_windows extends panamagl.platform.windows.APanamaGLFactory_windows implements panamagl.factory.PanamaGLFactory {
  public panamagl.opengl.GL newGL() {
    return new panamagl.platform.windows.GL_windows();
  }

  public boolean matches(panamagl.platform.Platform platform) {
    return new panamagl.platform.windows.PlatformMatcher_windows().matches(platform);
  }

}
