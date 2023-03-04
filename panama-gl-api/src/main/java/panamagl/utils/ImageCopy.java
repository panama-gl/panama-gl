package panamagl.utils;

import java.awt.image.BufferedImage;
import java.lang.foreign.MemorySegment;

public interface ImageCopy<T> {
  /**
   * Faster? to be evaluated Read a BGRA (GL.GL_BGRA()) pixel buffer and export its content to a
   * {@link BufferedImage}.
   *
   * Warning : flipped
   */
  public void fromBGRABufferToImageArray(MemorySegment pixelsBuffer, T out, int width, int height);

  /**
   * Read a BGRA (GL.GL_BGRA()) pixel buffer and export its content to a {@link BufferedImage}.
   *
   * @param pixelsBuffer
   * @param out
   */
  public void fromBGRABufferToImage(MemorySegment pixelsBuffer, T out, int width, int height, int channels);
}
