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
package panamagl.platform.windows;

import org.junit.Assert;
import org.junit.Test;

public class TestAPanamaGLFactory_windows extends WindowsTest {

  static class TestableFactory extends APanamaGLFactory_windows {
    @Override
    public panamagl.opengl.GL newGL() {
      return null; // not needed for this test
    }
  }

  @Test
  public void whenCGL_thenRendererUsesAWTThreadRedirect() {
    if (!checkPlatform())
      return;

    TestableFactory factory = new TestableFactory();

    Assert.assertFalse(factory.useGLUT);
  }
}
