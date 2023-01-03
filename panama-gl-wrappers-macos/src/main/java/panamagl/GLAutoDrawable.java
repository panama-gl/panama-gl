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
  /**
   * Trigger display. The component is responsible for rooting the request to the appropriate
   * threads.
   */
  void display();

  /** Return the event listener handling init, drawing and resize requests. */
  GLEventListener getGLEventListener();

  /** Set the event listener handling init, drawing and resize requests. */
  void setGLEventListener(GLEventListener glEvents);

  /** Return true if the panel has initialized GL ressource and is ready for display. */
  boolean isInitialized();

  /** Return true if the component is visible on screen. */
  boolean isVisible();

  /** Return the GL context. */
  GLContext getContext();

  /** Return the GL instance allowing to invoke OpenGL. */
  GL getGL();
}
