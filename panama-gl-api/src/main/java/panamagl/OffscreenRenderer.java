package panamagl;

import panamagl.fbo.FBO;
import panamagl.opengl.GL;
import panamagl.opengl.GLContext;

/**
 * The interface through which various {@link GLAutoDrawable} implementation can query
 * an offscreen rendering. 
 * 
 * This allows 
 * 
 * @author Martin
 */
public interface OffscreenRenderer {
  void onInit(GLAutoDrawable drawable, GLEventListener glEventListener);
  void onDisplay(GLAutoDrawable drawable, GLEventListener glEventListener);
  void onResize(GLAutoDrawable drawable, GLEventListener glEventListener, int x, int y, int width, int height);
  void onDestroy(GLAutoDrawable drawable, GLEventListener glEventListener);
  
  GL getGL();
  GLContext getContext();
  
  boolean isFlipY();
  void setFlipY(boolean flipY);
  void setFBO(FBO fbo);
  FBO getFBO();
  
  boolean isInitialized();
  
  public void setDebugFile(String debugFile);
  public String getDebugFile();
}
