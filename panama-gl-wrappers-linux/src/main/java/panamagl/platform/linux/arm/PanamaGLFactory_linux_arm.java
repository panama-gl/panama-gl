package panamagl.platform.linux.arm;

public class PanamaGLFactory_linux_arm extends panamagl.platform.linux.APanamaGLFactory_linux implements panamagl.factory.PanamaGLFactory {
  public panamagl.opengl.GL newGL() {
    return new panamagl.platform.linux.arm.GL_linux_arm();
  }

  public boolean matches(panamagl.platform.Platform platform) {
    return new panamagl.platform.linux.arm.PlatformMatcher_linux_arm().matches(platform);
  }

}
