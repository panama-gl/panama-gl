package panamagl.fbo;

import java.awt.image.BufferedImage;
import opengl.GL;


public interface FBO {

  void prepare(GL gl);

  /**
   * Release resources held by this FBO utility.
   *
   * @param gl
   */
  void release(GL gl);

  BufferedImage getImage(GL gl);

  void resize(int width, int height);

  int getWidth();

  int getHeight();

  boolean isFlipY();

  void setFlipY(boolean flipY);

}
