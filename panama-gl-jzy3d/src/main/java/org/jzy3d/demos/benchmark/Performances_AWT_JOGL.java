package org.jzy3d.demos.benchmark;

import java.awt.Frame;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.util.FPSAnimator;

/**
 * Paints some polygons at screen.
 */
public class Performances_AWT_JOGL {
  private static int  drawingCount = 0;
  private static long elapsedTime  = 0;

  private static void display(GLAutoDrawable drawable) {
    GL2 gl = (GL2)drawable.getGL();
    
    System.out.println(drawable.getGL().getGLProfile().getName());
    System.out.println(drawable.getGL().getContext().getGLVersion());
    
    
    gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
    gl.glClearDepth(1.0f);
    gl.glLoadIdentity();
    gl.glScalef(1, 2, 1);
    GLU glu = new GLU();
    glu.gluLookAt(0, 0, 5, 0, 0, 0, 0, 1, 0);
    long time = System.currentTimeMillis();
    int max = 400;
    float [] matrix = new float [] {1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1};
    for (int i = 0; i < max; i++) {
      matrix [12] = 2f * i / max - 1f;
      for (int j = 0; j < max; j++) {
        matrix [13] = 2f * j / max - 1f;
        gl.glLoadMatrixf(matrix, 0);
        gl.glColor3d(Math.random(), Math.random(), Math.random());
        drawPolygon(gl, .9f / max);
      }
    }
    gl.glFlush();
    elapsedTime += System.currentTimeMillis() - time;
    drawingCount++;
    System.out.println(elapsedTime / drawingCount);
  }

  private static void drawPolygon(GL2 gl, float size) {
    gl.glBegin(gl.GL_POLYGON);
    gl.glVertex2f(size, size);
    gl.glVertex2f(-size, size);
    gl.glVertex2f(-size, -size);
    gl.glVertex2f(size, -size);
    gl.glEnd();
  }

  public static void main(String [] args) {
    GLProfile profile = GLProfile.getMaxProgrammable(true);
    //GLProfile profile = GLProfile.getMaxFixedFunc(true);//get(GLProfile.GL2);
    //System.out.println(profile.getClass());
    GLCapabilities capabilities = new GLCapabilities(profile);

    GLCanvas glcanvas = new GLCanvas(capabilities);
    Performances_AWT_JOGL b = new Performances_AWT_JOGL();
    
    glcanvas.addGLEventListener(new GLEventListener() {
      public void display(GLAutoDrawable drawable) {
        Performances_AWT_JOGL.display(drawable);
      }

      public void reshape(GLAutoDrawable arg0, int arg1, int arg2, int arg3, int arg4) {
      }

      public void init(GLAutoDrawable arg0) {
      }

      public void dispose(GLAutoDrawable arg0) {
      }
    });
    glcanvas.setSize(800, 800);

    Frame frame = new Frame("JOGL Frame");
    frame.add(glcanvas);
    frame.pack();
    frame.setVisible(true);
    new FPSAnimator(glcanvas, 25).start();
  }
}
