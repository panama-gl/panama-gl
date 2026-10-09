package panamagl.platform.windows.arm;

public class PanamaGLFactory_windows_arm extends panamagl.platform.windows.APanamaGLFactory_windows implements panamagl.factory.PanamaGLFactory {
  public panamagl.opengl.GL newGL() {
    return new panamagl.platform.windows.arm.GL_windows_arm();
  }

  public boolean matches(panamagl.platform.Platform platform) {
    return new panamagl.platform.windows.arm.PlatformMatcher_windows_arm().matches(platform);
  }

}
