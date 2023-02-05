package panamagl.renderers.image;

import java.awt.image.BufferedImage;
import java.lang.foreign.MemorySegment;

public class ForeignImage{
  public BufferedImage image;
  public MemorySegment segment;
}
