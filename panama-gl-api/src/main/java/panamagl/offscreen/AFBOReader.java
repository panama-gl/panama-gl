package panamagl.offscreen;

public abstract class AFBOReader implements FBOReader{
  protected boolean flipY = true;

  @Override
  public boolean isFlipY() {
    return flipY;
  }

  @Override
  public void setFlipY(boolean flipY) {
    this.flipY = flipY;
  }

}
