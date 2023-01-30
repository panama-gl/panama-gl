package org.jzy3d.painters.natives;

import org.jzy3d.chart.Chart;
import org.jzy3d.maths.Rectangle;
import org.jzy3d.painters.PanamaGLPainter;

public interface PanamaGLNativePainter extends PanamaGLPainter{
  /**
   * This temporary helper allows starting a GLUT window like an AWT Frame would start
   * for a Jzy3D chart.
   *
   * IT IS NOT the name of an existing GLUT function.
   *
   * @param chart
   * @param bounds
   * @param title
   * @param message
   */
  public void glutStart(Chart chart, Rectangle bounds, String title, String message);
  public void glutSwapBuffers();
  public void glutPostRedisplay();
  public int glutGetWindowWidth();
  public int glutGetWindowHeight();
}
