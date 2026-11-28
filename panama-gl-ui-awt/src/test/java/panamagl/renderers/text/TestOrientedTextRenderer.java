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

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import java.awt.Color;
import java.awt.Font;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import org.junit.Assert;
import org.junit.Test;
import panamagl.opengl.GL;
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

  @Test
  public void whenDrawingTheSameTextAgain_ThenImageIsTakenFromCache() {
    OrientedTextRenderer r = new OrientedTextRenderer();

    TextImage first = r.getTextImage(font, "Coucou", Color.BLUE);

    Assert.assertSame(first, r.getTextImage(font, "Coucou", Color.BLUE));
    Assert.assertSame(first.getRGBA(), r.getTextImage(font, "Coucou", Color.BLUE).getRGBA());
    Assert.assertEquals(1, r.getCachedTextCount());
  }

  @Test
  public void whenTextFontColorOrScaleDiffer_ThenImageIsNotTakenFromCache() {
    OrientedTextRenderer r = new OrientedTextRenderer();

    TextImage image = r.getTextImage(font, "Coucou", Color.BLUE);

    Assert.assertNotSame(image, r.getTextImage(font, "Hello", Color.BLUE));
    Assert.assertNotSame(image, r.getTextImage(font, "Coucou", Color.RED));
    Assert.assertNotSame(image, r.getTextImage(font.deriveFont(20f), "Coucou", Color.BLUE));

    r.setPixelScale(2);
    TextImage scaled = r.getTextImage(font, "Coucou", Color.BLUE);
    Assert.assertNotSame(image, scaled);
    assertTwice(image.getWidth(), scaled.getWidth());

    r.setAntialiasing(false);
    Assert.assertNotSame(scaled, r.getTextImage(font, "Coucou", Color.BLUE));

    Assert.assertEquals(6, r.getCachedTextCount());
  }

  @Test
  public void whenCacheIsFull_ThenLeastRecentlyDrawnTextIsRemoved() {
    OrientedTextRenderer r = new OrientedTextRenderer();
    r.setCacheSize(2);

    TextImage a = r.getTextImage(font, "a", Color.BLUE);
    TextImage b = r.getTextImage(font, "b", Color.BLUE);

    // a is now the most recently drawn
    Assert.assertSame(a, r.getTextImage(font, "a", Color.BLUE));

    r.getTextImage(font, "c", Color.BLUE);

    Assert.assertEquals(2, r.getCachedTextCount());
    Assert.assertSame(a, r.getTextImage(font, "a", Color.BLUE));
    Assert.assertNotSame(b, r.getTextImage(font, "b", Color.BLUE));

    // Reducing the size drops the extra texts, 0 disables the cache
    r.setCacheSize(0);
    Assert.assertEquals(0, r.getCachedTextCount());
    Assert.assertNotSame(r.getTextImage(font, "a", Color.BLUE),
        r.getTextImage(font, "a", Color.BLUE));
    Assert.assertEquals(0, r.getCachedTextCount());
  }

  @Test
  public void whenRGBAIsRead_ThenItHoldsTheImagePixelsBottomRowFirst() {
    TextImage image = new OrientedTextRenderer().createTextImage(font, "Coucou", Color.BLUE);
    MemorySegment rgba = image.getRGBA();

    int w = image.getWidth();
    int h = image.getHeight();
    Assert.assertEquals((long) w * h * 4, rgba.byteSize());

    for (int y = 0; y < h; y++) {
      for (int x = 0; x < w; x++) {
        int argb = image.getImage().getRGB(x, y);
        long i = ((long) (h - 1 - y) * w + x) * 4;
        Assert.assertEquals((byte) (argb >> 16), rgba.get(ValueLayout.JAVA_BYTE, i));
        Assert.assertEquals((byte) (argb >> 24), rgba.get(ValueLayout.JAVA_BYTE, i + 3));
      }
    }
  }

  @Test
  public void whenDrawingTextAtEachFrame_ThenTextIsDrawnWithAWTOnce() {
    int[] created = {0};

    OrientedTextRenderer r = new OrientedTextRenderer() {
      @Override
      public TextImage createTextImage(Font font, String text, Color color) {
        created[0]++;
        return super.createTextImage(font, text, color);
      }
    };

    // A GL reporting a 200x100 viewport
    GL gl = mock(GL.class);
    doAnswer(inv -> {
      MemorySegment viewport = inv.getArgument(1);
      viewport.setAtIndex(ValueLayout.JAVA_INT, 2, 200);
      viewport.setAtIndex(ValueLayout.JAVA_INT, 3, 100);
      return null;
    }).when(gl).glGetIntegerv(eq(GL.GL_VIEWPORT), any());

    for (int frame = 0; frame < 10; frame++) {
      r.draw(gl, font, "Coucou", 10, 10, 0, Color.BLUE, 0);
      r.draw(gl, font, "Coucou", 10, 10, 0, Color.BLUE, (float) Math.PI / 2);
    }

    Assert.assertEquals(1, created[0]);

    // The texture is still uploaded at each draw, from the cached pixels
    MemorySegment rgba = r.getTextImage(font, "Coucou", Color.BLUE).getRGBA();
    verify(gl, times(20)).glTexImage2D(eq(GL.GL_TEXTURE_2D), eq(0), eq(GL.GL_RGBA), anyInt(),
        anyInt(), eq(0), eq(GL.GL_RGBA), eq(GL.GL_UNSIGNED_BYTE), eq(rgba));
  }
}
