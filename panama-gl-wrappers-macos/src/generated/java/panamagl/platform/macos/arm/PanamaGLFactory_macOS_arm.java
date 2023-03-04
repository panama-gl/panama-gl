package panamagl.platform.macos.arm; 


public class PanamaGLFactory_macOS_arm extends panamagl.platform.macos.APanamaGLFactory_macOS implements panamagl.factory.PanamaGLFactory {
  public panamagl.opengl.GL newGL() {
    return new panamagl.platform.macos.arm.GL_macOS_arm();
  }

  public boolean matches(panamagl.platform.Platform platform) {
    return new panamagl.platform.macos.arm.PlatformMatcher_macOS_arm().matches(platform);
  }

}
