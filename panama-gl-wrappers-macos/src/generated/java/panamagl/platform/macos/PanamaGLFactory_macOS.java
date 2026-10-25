package panamagl.platform.macos; 


public class PanamaGLFactory_macOS extends panamagl.platform.macos.APanamaGLFactory_macOS implements panamagl.factory.PanamaGLFactory {
  public panamagl.opengl.GL newGL() {
    return new panamagl.platform.macos.GL_macOS();
  }

  public boolean matches(panamagl.platform.Platform platform) {
    return new panamagl.platform.macos.PlatformMatcher_macOS().matches(platform);
  }

}
