package panamagl.offscreen;

public abstract class AFBO implements FBO{
  protected int width = 0;
  protected int height = 0;
  protected boolean flipY = true;
  
  // indicates dimensions have changed
  // and FBO must reprepared
  protected boolean prepared = false;
  
  @Override
  public void resize(int width, int height) {
    if (this.width != width || this.height != height) {

      this.width = (int)Math.round(width * 1.25);
      this.height = (int)Math.round(height * 1.25);

      this.width = width;
      this.height = height;

      this.prepared = false;

    }
  }

  @Override
  public int getWidth() {
    return width;
  }

  @Override
  public int getHeight() {
    return height;
  }

  @Override
  public boolean isFlipY() {
    return flipY;
  }

  @Override
  public void setFlipY(boolean flipY) {
    this.flipY = flipY;
  }
  
  @Override
  public boolean isPrepared() {
    return prepared;
  }
}
