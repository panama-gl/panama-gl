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
package panamagl.utils;

import java.awt.image.BufferedImage;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import java.lang.foreign.ValueLayout.OfByte;
import java.nio.ByteOrder;

public class AWTImageCopy implements ImageCopy<BufferedImage>{
  /**
   * Faster? to be evaluated Read a BGRA (GL.GL_BGRA()) pixel buffer and export its content to a
   * {@link BufferedImage}.
   *
   * Warning : flipped
   */
  @Override
  public void fromBGRABufferToImageArray(MemorySegment pixelsBuffer, BufferedImage out, int width, int height) {
    int[] px = pixelsBuffer.toArray(ValueLayout.JAVA_INT);
    out.setRGB(0, 0, width, height, px, 0, width);
  }

  /**
   * Read a BGRA (GL.GL_BGRA()) pixel buffer and export its content to a {@link BufferedImage}.
   *
   * @param pixelsBuffer
   * @param out
   */
  @Override
  public void fromBGRABufferToImage(MemorySegment pixelsBuffer, BufferedImage out, int width, int height, int channels) {
    int nPixels = width * height;
    int k = 0;

    OfByte byteHandle = ValueLayout.JAVA_BYTE.withOrder(ByteOrder.nativeOrder());

    for (int i = 0; i < nPixels * channels; i += channels) {
      // BGRA as specified by "format" field
      byte byB = pixelsBuffer.get(byteHandle, i);
      byte byG = pixelsBuffer.get(byteHandle, i + 1);
      byte byR = pixelsBuffer.get(byteHandle, i + 2);
      byte byA = pixelsBuffer.get(byteHandle, i + 3);
      //byte non = 0;
      //byte one = (byte) 0xff;
      int rgba = ByteUtils.RGBAtoIntARGB(byR, byG, byB, byA); // ARGB
      // rgba = ByteUtils.RGBAtoIntARGB(byR, non, non, one);
      // rgba = ByteUtils.RGBAtoIntARGB(non, byG, non, one);
      // rgba = ByteUtils.RGBAtoIntARGB(non, non, byB, one);

      // Pixel position
      int h = k % width;
      int w = k / width;

      out.setRGB(w, h, rgba);

      // Console out
      boolean console = false;

      if (console) {
        int intB = ByteUtils.BtoI(byB);
        int intG = ByteUtils.BtoI(byG);
        int intR = ByteUtils.BtoI(byR);
        int intA = ByteUtils.BtoI(byA);

        int red = ByteUtils.ItoR(intR);
        int green = ByteUtils.ItoG(intG);
        int blue = ByteUtils.ItoB(intB);
        int alpha = ByteUtils.ItoA(intA);

        System.out
            .println(w + "," + h + " : \t r=" + red + " g=" + green + " b=" + blue + " a=" + alpha);
      }
      k++;
    }
  }
}
