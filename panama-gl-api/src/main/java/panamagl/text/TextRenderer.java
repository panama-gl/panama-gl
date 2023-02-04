package panamagl.text;

import panamagl.opengl.GL;


public interface TextRenderer {
  void draw(GL gl, String text, float x, float y, float z);
}
