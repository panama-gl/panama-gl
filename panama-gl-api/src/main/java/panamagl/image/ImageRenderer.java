package panamagl.image;

import java.awt.image.BufferedImage;
import java.lang.foreign.MemorySegment;
import panamagl.opengl.GL;

public interface ImageRenderer {
  void draw(GL gl, BufferedImage image, MemorySegment foreign, float x, float y, float z);
}
