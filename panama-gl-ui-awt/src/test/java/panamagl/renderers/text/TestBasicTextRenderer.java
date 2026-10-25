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
package panamagl.renderers.text;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.io.InputStream;
import org.junit.Assert;
import org.junit.Test;
import panamagl.renderers.image.ForeignImage;

public class TestBasicTextRenderer {
  /**
   * A font shipped with the tests, so that the text has the same size on all OS, which do not have
   * the same fonts (e.g. Arial is usually missing on Linux).
   */
  public static Font font(float size) throws IOException, FontFormatException {
    try (InputStream in = TestBasicTextRenderer.class.getResourceAsStream("/fonts/DejaVuSansMono.ttf")) {
      return Font.createFont(Font.TRUETYPE_FONT, in).deriveFont(Font.PLAIN, size);
    }
  }

  @Test
  public void createForeignImage() throws IOException, FontFormatException {
    BasicTextRenderer r = new BasicTextRenderer();
    
    ForeignImage i = r.createForeignImage(font(12), "Coucou", Color.BLUE);
    
    Assert.assertNotNull(i.image);
    Assert.assertNotNull(i.segment);
    
    // 6 characters of 7 pixels advance (DejaVu Sans Mono at 12 points), on all OS
    Assert.assertEquals(42, i.image.getWidth());
    Assert.assertEquals(13, i.image.getHeight());
  }
}
