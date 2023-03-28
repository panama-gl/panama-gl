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
package panamagl.platform.linux;

import panamagl.factory.PanamaGLFactory;
import panamagl.offscreen.AOffscreenRenderer;
import panamagl.offscreen.FBOReader;
import panamagl.offscreen.OffscreenRenderer;

// Now does not do anything else more than the abstract class
public class OffscreenRenderer_linux extends AOffscreenRenderer implements OffscreenRenderer{
  public OffscreenRenderer_linux(PanamaGLFactory factory, FBOReader reader) {
    super(factory, reader);
  }
}
