package panamagl.offscreen;

import panamagl.GLCanvas;
import panamagl.Image;
import panamagl.opengl.GL;

public interface FBOReader {
  Image<?> read(FBO fbo, GL gl, GLCanvas canvas);
  
  boolean isFlipY();
  void setFlipY(boolean flipY);
}
