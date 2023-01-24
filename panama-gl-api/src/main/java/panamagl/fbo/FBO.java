package panamagl.fbo;

import java.awt.image.BufferedImage;
import panamagl.opengl.GL;


public interface FBO {
  void prepare(GL gl);
  void release(GL gl);
  BufferedImage getImage(GL gl);
  void resize(int width, int height);
  int getWidth();
  int getHeight();
  boolean isFlipY();
  void setFlipY(boolean flipY);
}
