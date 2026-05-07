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
package panamagl.canvas;

import org.junit.Assert;
import org.junit.Test;

public class TestPixelScale {

  @Test
  public void identity_isOneOne() {
    Assert.assertEquals(1.0, PixelScale.IDENTITY.x(), 0.0);
    Assert.assertEquals(1.0, PixelScale.IDENTITY.y(), 0.0);
    Assert.assertTrue(PixelScale.IDENTITY.isIdentity());
  }

  @Test
  public void isIdentity_detectsRetinaScale() {
    Assert.assertFalse(new PixelScale(2.0, 2.0).isIdentity());
    Assert.assertFalse(new PixelScale(1.5, 1.5).isIdentity());
    Assert.assertFalse(new PixelScale(1.0, 2.0).isIdentity());
  }

  @Test
  public void equals_andHashCode_holdForRecord() {
    PixelScale a = new PixelScale(2.0, 2.0);
    PixelScale b = new PixelScale(2.0, 2.0);
    PixelScale c = new PixelScale(1.5, 2.0);

    Assert.assertEquals(a, b);
    Assert.assertEquals(a.hashCode(), b.hashCode());
    Assert.assertNotEquals(a, c);
  }
}
