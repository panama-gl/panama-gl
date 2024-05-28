/*******************************************************************************
 * Copyright (c) 2022, 2023 Martin Pernollet & contributors.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301, USA
 *******************************************************************************/
package panamagl.renderers.image;


import java.awt.Image;
import java.awt.image.PixelGrabber;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.Arena;
import java.lang.foreign.ValueLayout;
import panamagl.opengl.GL;

/**
 * Convert AWT {@link Image}s to {@link MemorySegment} or <code>int[]</code> pixel buffers suitable
 * for direct OpenGL rendering via {@link GL#glDrawPixels(int, int, int, int, MemorySegment)}.
 * 
 * @author Martin Pernollet
 */
public class BufferedImageForeign {
  static Arena allocator = Arena.ofConfined();
      

  public static MemorySegment toMemorySegment(Image image) {
    return toMemorySegment(image, image.getWidth(null), image.getHeight(null));
  }

  /**
   * Create a {@link ByteBuffer} containing a RGBA pixels out of an Image made of ARGB pixels.
   * 
   * The buffer can later be drawn by <code>
   * GL2.glDrawPixels(imgW, imgH, GL2.GL_RGBA, GL2.GL_UNSIGNED_BYTE, byteBuffer);
   * </code>
   * 
   * @param image
   * @param width
   * @param height
   * @return
   */
  public static MemorySegment toMemorySegment(Image image, int width, int height) {
    int[] px = getImagePixels(image, width, height);
    return convertARGBtoRGBA(px, width, height, true);
  }
  
  public static int[] getImagePixels(Image image) {
    return getImagePixels(image, image.getWidth(null), image.getHeight(null));
  }

  /**
   * Return the image pixels in default Java int ARGB format.
   * 
   * @param image
   * @param width
   * @param height
   * @return
   */
  public static int[] getImagePixels(Image image, int width, int height) {
    int[] pixels = null;

    if (image != null) {
      pixels = new int[width * height];
      PixelGrabber pg = new PixelGrabber(image, 0, 0, width, height, pixels, 0, width);
      try {
        pg.grabPixels();
      } catch (Exception e) {
        throw new RuntimeException(e);
      }
    }
    return pixels;
  }

  /**
   * Convert ARGB pixels to a {@link MemorySegment} containing RGBA pixels.
   * 
   * Can be drawn in ORTHO mode using:
   * 
   * <code>
   * GL2.glDrawPixels(imgW, imgH, GL2.GL_RGBA, GL2.GL_UNSIGNED_BYTE, segment);
   * </code>
   * 
   * If flipVertically is true, pixels will be flipped vertically for OpenGL coord system.
   * 
   * @param imgFilename
   * @return MemorySegment
   */
  public static MemorySegment convertARGBtoRGBA(int[] pixels, int width, int height,
      boolean flipVertically) {
    if (flipVertically) {
      pixels = flipPixels(pixels, width, height); // flip Y axis
    }
    return allocBytes(convertARGBtoRGBA(pixels));
  }

  /**
   * Convert pixels from java default ARGB int format to byte array in RGBA format.
   * 
   * @param pixels
   * @return
   */
  public static byte[] convertARGBtoRGBA(int[] pixels) {
    byte[] bytes = new byte[pixels.length * 4]; // will hold pixels as RGBA
                                                // bytes
    int p, r, g, b, a;
    int j = 0;
    for (int i = 0; i < pixels.length; i++) {
      // int outPixel = 0x00000000; // AARRGGBB
      p = pixels[i];
      a = (p >> 24) & 0xFF; // get pixel bytes in ARGB order
      r = (p >> 16) & 0xFF;
      g = (p >> 8) & 0xFF;
      b = (p >> 0) & 0xFF;
      bytes[j + 0] = (byte) r; // fill in bytes in RGBA order
      bytes[j + 1] = (byte) g;
      bytes[j + 2] = (byte) b;
      bytes[j + 3] = (byte) a;
      j += 4;
    }
    return bytes;
  }

  public static byte[] getRGBABytes(int[] pixels) {
    byte[] bytes = new byte[pixels.length * 4]; // will hold pixels as RGBA
                                                // bytes
    int p, r, g, b, a;
    int j = 0;
    for (int i = 0; i < pixels.length; i++) {
      // int outPixel = 0x00000000; // AARRGGBB
      p = pixels[i];
      r = (p >> 24) & 0xFF; // get pixel bytes in RGBA order
      g = (p >> 16) & 0xFF;
      b = (p >> 8) & 0xFF;
      a = (p >> 0) & 0xFF;
      bytes[j + 0] = (byte) r; // fill in bytes in RGBA order
      bytes[j + 1] = (byte) g;
      bytes[j + 2] = (byte) b;
      bytes[j + 3] = (byte) a;
      j += 4;
    }
    return bytes;
  }

  /**
   * Flip an array of pixels vertically
   * 
   * @param imgPixels
   * @param imgw
   * @param imgh
   * @return int[]
   */
  public static int[] flipPixels(int[] imgPixels, int imgw, int imgh) {
    int[] flippedPixels = null;
    if (imgPixels != null) {
      flippedPixels = new int[imgw * imgh];
      for (int y = 0; y < imgh; y++) {
        for (int x = 0; x < imgw; x++) {
          flippedPixels[((imgh - y - 1) * imgw) + x] = imgPixels[(y * imgw) + x];
        }
      }
    }
    return flippedPixels;
  }


  /**
   * Allocates a {@link ByteBuffer} to hold the given array of bytes.
   * 
   * @param byteArray
   * @return ByteBuffer containing the contents of the byte array
   */
  public static MemorySegment allocBytes(byte[] byteArray) {
    return allocator.allocateFrom(ValueLayout.JAVA_BYTE, byteArray);
  }
}
