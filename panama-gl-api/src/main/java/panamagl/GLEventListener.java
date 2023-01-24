package panamagl;

import panamagl.opengl.GL;

public interface GLEventListener {
  void init(GL gl);
  void display(GL gl);
  void reshape(GL gl, int x, int y, int width, int height);
  void dispose(GL gl);
}
