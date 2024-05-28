package demos.opengl;

import static opengl.linux.x86.glut_h.*;
import java.lang.foreign.Arena;

/*
 * Copyright (c) 2020, 2023, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle nor the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

import java.lang.foreign.ValueLayout;
import opengl.linux.NativeLibLoader;
import opengl.linux.x86.glutDisplayFunc$callback;
import opengl.linux.x86.glutIdleFunc$callback;

/**
 * This is the original demonstration program provided at https://github.com/sundararajana/panama-jextract-samples/tree/master/opengl.
 *
 * Requires VM args for Ubuntu
 * <code>
 * --enable-native-access=ALL-UNNAMED -Djava.library.path=.:/usr/lib/x86_64-linux-gnu/
 * </code>
 */
public class Teapot_Panama_Ubuntu {
  private float rot = 0;

  Teapot_Panama_Ubuntu(Arena arena) {
    // Reset Background
    glClearColor(0f, 0f, 0f, 0f);
    // Setup Lighting
    glShadeModel(GL_SMOOTH());
    var pos = arena.allocateFrom(C_FLOAT, new float[] { 0.0f, 15.0f, -15.0f, 0 });
    glLightfv(GL_LIGHT0(), GL_POSITION(), pos);
    var spec = arena.allocateFrom(C_FLOAT, new float[] { 1, 1, 1, 0 });
    glLightfv(GL_LIGHT0(), GL_AMBIENT(), spec);
    glLightfv(GL_LIGHT0(), GL_DIFFUSE(), spec);
    glLightfv(GL_LIGHT0(), GL_SPECULAR(), spec);
    var shini = arena.allocate(C_FLOAT, 113);
    glMaterialfv(GL_FRONT(), GL_SHININESS(), shini);
    glEnable(GL_LIGHTING());
    glEnable(GL_LIGHT0());
    glEnable(GL_DEPTH_TEST());
  }

  void display() {
    glClear(GL_COLOR_BUFFER_BIT() | GL_DEPTH_BUFFER_BIT());
    glPushMatrix();
    glRotatef(-20f, 1f, 1f, 0f);
    glRotatef(rot, 0f, 1f, 0f);
    glutSolidTeapot(0.5d);
    glPopMatrix();
    glutSwapBuffers();

  }

  void onIdle() {
    rot += 0.1;
    glutPostRedisplay();
  }

  public static void main(String[] args) {
    NativeLibLoader.load();
    
    try (var arena = Arena.ofConfined()) {
      var argc = arena.allocateFrom(ValueLayout.JAVA_INT, 0);
      glutInit(argc, argc);
      glutInitDisplayMode(GLUT_DOUBLE() | GLUT_RGB() | GLUT_DEPTH());
      glutInitWindowSize(500, 500);
      glutCreateWindow(arena.allocateFrom("Hello Panama!"));
      var teapot = new Teapot_Panama_Ubuntu(arena);
      var displayStub = glutDisplayFunc$callback.allocate(teapot::display, arena);
      var idleStub = glutIdleFunc$callback.allocate(teapot::onIdle, arena);
      glutDisplayFunc(displayStub);
      glutIdleFunc(idleStub);
      glutMainLoop();
    }
  }
}
