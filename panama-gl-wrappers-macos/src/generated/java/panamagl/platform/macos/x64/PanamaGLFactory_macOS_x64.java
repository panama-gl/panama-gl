package panamagl.platform.macos.x64; 


public class PanamaGLFactory_macOS_x64 extends panamagl.platform.macos.APanamaGLFactory_macOS implements panamagl.factory.PanamaGLFactory {
  public panamagl.opengl.GL newGL() {
    return new panamagl.platform.macos.x64.GL_macOS_x64();
  }

  public boolean matches(panamagl.platform.Platform platform) {
    return new panamagl.platform.macos.x64.PlatformMatcher_macOS_x64().matches(platform);
  }

}
