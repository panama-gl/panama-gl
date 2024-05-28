package org.jzy3d.demos.benchmark;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import opengl.macos.arm.glutDisplayFunc$func;
import opengl.macos.arm.glutIdleFunc$func;
import opengl.macos.arm.glut_h;

/**
 * Paints some polygons at screen.
 */
public class Performances_Panama_macOS {
  private static Arena arena;
  private static int   drawingCount = 0;
  private static long  elapsedTime  = 0;

  public static void display() {
    glut_h.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
    glut_h.glClearDepth(1.0f);
    glut_h.glLoadIdentity();
    glut_h.glScalef(1, 2, 1);
    glut_h.gluLookAt(0, 0, 5, 0, 0, 0, 0, 1, 0);
    long time = System.currentTimeMillis();
    int max = 400;
    MemorySegment matrix = arena.allocateFrom(ValueLayout.JAVA_FLOAT, 
        new float [] {1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1});
    for (int i = 0; i < max; i++) {
      matrix.setAtIndex(ValueLayout.JAVA_FLOAT, 12, 2f * i / max - 1f);
      for (int j = 0; j < max; j++) {
        matrix.setAtIndex(ValueLayout.JAVA_FLOAT, 13, 2f * j / max - 1f);
        glut_h.glLoadMatrixf(matrix);
        glut_h.glColor3d(Math.random(), Math.random(), Math.random());
        drawPolygon(.9f / max);
      }
    }
    glut_h.glFlush();
    elapsedTime += System.currentTimeMillis() - time;
    drawingCount++;
    System.out.println(elapsedTime / drawingCount);
  }

  private static void drawPolygon(float size) {
    glut_h.glBegin(glut_h.GL_POLYGON());
    glut_h.glVertex2f(size, size);
    glut_h.glVertex2f(-size, size);
    glut_h.glVertex2f(-size, -size);
    glut_h.glVertex2f(size, -size);
    glut_h.glEnd();
  }

  public static void onIdle() {
    glut_h.glutPostRedisplay();
  }

  public static void main(String [] args) {
    arena = Arena.ofConfined();
    MemorySegment argc = arena.allocate(glut_h.C_INT, 0);
    glut_h.glutInit(argc, argc);
    glut_h.glutInitDisplayMode(glut_h.GLUT_SINGLE() | glut_h.GLUT_RGB());
    glut_h.glutInitWindowSize(800, 800);
    glut_h.glutCreateWindow(arena.allocateFrom("Panama frame"));

    MemorySegment displayStub = glutDisplayFunc$func.allocate(Performances_Panama_macOS::display, arena);
    MemorySegment idleStub = glutIdleFunc$func.allocate(Performances_Panama_macOS::onIdle, arena);
    glut_h.glutDisplayFunc(displayStub);
    glut_h.glutIdleFunc(idleStub);
    glut_h.glutMainLoop();
  }
}
