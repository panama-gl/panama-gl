package panamagl;

import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import opengl.GL;
import opengl.GLContext;

/**
 * A toy JOGL-like auto drawable interface that all canvas should implement
 * 
 * @author Martin Pernollet
 */
public interface GLAutoDrawable {
  /** Trigger display. The component is responsible for rooting the request to the appropriate threads.*/
  void display();
  
  /** Return true if a frame rendering has started and not yet finished. */
  boolean isRendering();

  /** Return the event listener handling init, drawing and resize requests. */
  GLEventListener getGLEventListener();

  /** Set the event listener handling init, drawing and resize requests. */
  void setGLEventListener(GLEventListener glEvents);

  /** Return true if the panel has initialized GL ressource and is ready for display. */
  boolean isInitialized();

  /** Return true if the component is visible on screen (depend on windowing toolkit implementation, e.g. {@link JPanel#isVisible()}). */
  boolean isVisible();

  /** Return the GL context. */
  GLContext getContext();

  /** Return the GL instance allowing to invoke OpenGL. */
  GL getGL();
  
  /** Return the performance information about this panel. */
  RenderCounter getMonitoring();
  
  int getWidth();
  int getHeight();
  
  void repaint();
  
  void setScreenshot(BufferedImage image);
  BufferedImage getScreenshot();
  
}
