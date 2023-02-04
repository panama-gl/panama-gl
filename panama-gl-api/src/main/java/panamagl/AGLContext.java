package panamagl;

import panamagl.opengl.GLContext;

public abstract class AGLContext implements GLContext{
  protected GLProfile profile;

  @Override
  public GLProfile getProfile() {
    return profile;
  }

  @Override
  public void setProfile(GLProfile profile) {
    this.profile = profile;
  }
}
