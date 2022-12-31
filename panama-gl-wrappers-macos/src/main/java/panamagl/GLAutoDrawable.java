package panamagl;

/**
 * A toy JOGL-like auto drawable interface that all canvas should implement
 * 
 * @author Martin Pernollet
 *
 */
public interface GLAutoDrawable {
  /** Trigger display */
  void display();
  
  public GLEventListener getGLEventListener();

  public void setGLEventListener(GLEventListener glEvents);
}
