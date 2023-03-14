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
package panamagl.offscreen;

import panamagl.Image;
import panamagl.opengl.GL;

/**
 * A frame buffer object, or {@link FBO}, can render OpenGL into an offscreen buffer that can later
 * be converted to an {@link Image}.
 *
 * @author Martin Pernollet
 */
public interface FBO {
  void prepare(GL gl);
  void release(GL gl);
  Image<?> getImage(GL gl);
  void resize(int width, int height);
  int getWidth();
  int getHeight();
  boolean isFlipY();
  void setFlipY(boolean flipY);
  
  boolean isPrepared();
}
