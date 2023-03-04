package panamagl.platform.macos.x86; 


public class PanamaGLFactory_macOS_x86 extends panamagl.platform.macos.APanamaGLFactory_macOS implements panamagl.factory.PanamaGLFactory {
  public panamagl.opengl.GL newGL() {
    return new panamagl.platform.macos.x86.GL_macOS_x86();
  }

  public boolean matches(panamagl.platform.Platform platform) {
    return new panamagl.platform.macos.x86.PlatformMatcher_macOS_x86().matches(platform);
  }

}
