/*******************************************************************************
 * Copyright (c) 2023 Martin Pernollet and others
 *
 * This program and the accompanying materials are made available under the terms of the Eclipse
 * Public License 2.0 which is available at http://www.eclipse.org/legal/epl-2.0.
 *
 * This Source Code may also be made available under the following Secondary Licenses when the
 * conditions for such availability set forth in the Eclipse Public License, v. 2.0 are satisfied:
 * GNU General Public License, version 2 with the GNU Classpath Exception which is available at
 * https://www.gnu.org/software/classpath/license.html.
 *
 * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
 ********************************************************************************/
package panamagl.offscreen;

import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.PaletteData;
import panamagl.Debug;
import panamagl.image.SWTImage;
import panamagl.opengl.GL;

/**
 * Reads FBO pixels and produces an SWT {@link ImageData} wrapped in a {@link SWTImage}.
 *
 * The FBO provides BGRA bytes. On little-endian systems, reading as {@code int[]} yields
 * ARGB-packed integers (0xAARRGGBB), the same format used by {@code FBOReader_AWT}.
 * We then use {@link ImageData#setPixel} / {@link ImageData#setAlpha} which handle
 * the internal byte layout regardless of platform.
 */
public class FBOReader_SWT implements FBOReader {
  protected boolean debug = Debug.check(FBOReader.class, FBOReader_SWT.class);
  protected ImageData imageData;

  @Override
  public SWTImage read(FBO fbo, GL gl) {
    int width = fbo.getWidth();
    int height = fbo.getHeight();

    if (width == 0 || height == 0) {
      return null;
    }

    MemorySegment pixels = fbo.readPixels(gl);

    // Reuse ImageData when dimensions are unchanged
    if (imageData == null || imageData.width != width || imageData.height != height) {
      PaletteData palette = new PaletteData(0xFF0000, 0xFF00, 0xFF);
      imageData = new ImageData(width, height, 32, palette);
      imageData.alphaData = new byte[width * height];
    }

    // BGRA bytes in memory → ARGB packed ints on little-endian (same as FBOReader_AWT)
    int[] intPixels = pixels.toArray(ValueLayout.JAVA_INT);

    for (int y = 0; y < height; y++) {
      int rowOffset = y * width;
      for (int x = 0; x < width; x++) {
        int argb = intPixels[rowOffset + x];
        // Strip alpha, keep 0x00RRGGBB matching palette (0xFF0000, 0xFF00, 0xFF)
        imageData.setPixel(x, y, argb & 0x00FFFFFF);
        imageData.setAlpha(x, y, (argb >> 24) & 0xFF);
      }
    }

    return new SWTImage(imageData);
  }
}
