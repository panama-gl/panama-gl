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
import org.junit.Assert;
import org.junit.Test;
import panamagl.platform.Platform;
import panamagl.renderers.image.ForeignImage;

public class TestBasicTextRenderer {
  @Test
  public void createForeignImage() {
    BasicTextRenderer r = new BasicTextRenderer();
    
    ForeignImage i = r.createForeignImage(new Font("Arial", Font.PLAIN, 12), "Coucou", Color.BLUE);
    
    Assert.assertNotNull(i.image);
    Assert.assertNotNull(i.segment);
    
    Platform p = new Platform();
    if(p.isWindows() || p.isMac()) {
      Assert.assertEquals(43, i.image.getWidth());
      Assert.assertEquals(13, i.image.getHeight());
    }
    else if(p.isUnix()) {
      Assert.assertEquals(47, i.image.getWidth());
      Assert.assertEquals(13, i.image.getHeight());
    }
  }
}
