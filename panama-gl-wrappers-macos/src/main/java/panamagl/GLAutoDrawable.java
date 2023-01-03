package panamagl;

import opengl.GL;
import opengl.GLContext;

/**
 * A toy JOGL-like auto drawable interface that all canvas should implement
 * 
 * @author Martin Pernollet
 *
 */
public interface GLAutoDrawable {
  /** Trigger display */
  void display();
  
  GLEventListener getGLEventListener();

  void setGLEventListener(GLEventListener glEvents);
  
  boolean isVisible();
  
  GLContext getContext();
  
  GL getGL();
}
