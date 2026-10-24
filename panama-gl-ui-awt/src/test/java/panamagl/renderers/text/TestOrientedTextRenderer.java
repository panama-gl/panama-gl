/*******************************************************************************
 * Copyright (c) 2026 Martin Pernollet & contributors.
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
package panamagl.renderers.text;

import java.awt.Color;
import java.awt.Font;
import org.junit.Assert;
import org.junit.Test;
import panamagl.renderers.text.OrientedTextRenderer.TextImage;

public class TestOrientedTextRenderer {
  Font font = new Font("Arial", Font.PLAIN, 12);

  @Test
  public void whenPixelScaleIsTwo_ThenTextImageIsTwiceLarger() {
    OrientedTextRenderer r = new OrientedTextRenderer();

    TextImage normal = r.createTextImage(font, "Coucou", Color.BLUE);

    r.setPixelScale(2);
    TextImage scaled = r.createTextImage(font, "Coucou", Color.BLUE);

    // Glyph metrics are hinted, hence not exactly proportional to the font size
    assertTwice(normal.getAdvance(), scaled.getAdvance());
    assertTwice(normal.getHeight(), scaled.getHeight());
    assertTwice(normal.getDescent(), scaled.getDescent());
  }

  @Test
  public void whenPixelScaleIsTwo_ThenTextWidthRemainsLogical() {
    OrientedTextRenderer r = new OrientedTextRenderer();
    int width = r.getTextWidth(font, "Coucou");

    r.setPixelScale(2);
    Assert.assertEquals(width, r.getTextWidth(font, "Coucou"));
    assertTwice(width, r.createTextImage(font, "Coucou", Color.BLUE).getAdvance());
  }

  /** Verify a value is about twice another one, as hinted glyph metrics are not proportional. */
  protected void assertTwice(int value, int twice) {
    Assert.assertEquals(value + " is not about half of " + twice, 2, (double) twice / value, 0.2);
  }

  @Test
  public void whenPixelScaleIsInvalid_ThenUseOne() {
    OrientedTextRenderer r = new OrientedTextRenderer();

    r.setPixelScale(Float.NaN);
    Assert.assertEquals(1, r.getPixelScale(), 0);

    r.setPixelScale(0);
    Assert.assertEquals(1, r.getPixelScale(), 0);
  }

  @Test
  public void whenDrawingText_ThenImageHoldsTextPixels() {
    TextImage image = new OrientedTextRenderer().createTextImage(font, "Coucou", Color.BLUE);

    boolean blue = false;
    for (int x = 0; x < image.getWidth() && !blue; x++) {
      for (int y = 0; y < image.getHeight() && !blue; y++) {
        int argb = image.getImage().getRGB(x, y);
        blue = (argb >>> 24) > 0 && (argb & 0xFF) > 200 && ((argb >> 16) & 0xFF) < 50;
      }
    }
    Assert.assertTrue(blue);
  }
}
