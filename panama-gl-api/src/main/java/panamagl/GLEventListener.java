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
package panamagl;

import panamagl.opengl.GL;

/**
 * The interface to implement to let a {@link GLCanvas} perform OpenGL calls.
 * 
 * @author Martin Pernollet
 *
 */
public interface GLEventListener {
  void init(GL gl);
  void display(GL gl);
  void reshape(GL gl, int x, int y, int width, int height);
  void dispose(GL gl);
}
