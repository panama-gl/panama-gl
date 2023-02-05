package panamagl.renderers.text;

import java.awt.Color;
import java.awt.Font;
import panamagl.opengl.GL;


public interface TextRenderer {
  void draw(GL gl, Font font, String text, float x, float y, float z, Color color, float rotation);
}
