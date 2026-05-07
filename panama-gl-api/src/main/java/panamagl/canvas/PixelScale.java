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

/**
 * Ratio between physical pixels and logical pixels for a {@link GLCanvas}.
 *
 * <p>A scale of {@code (1, 1)} means one logical pixel equals one physical pixel.
 * On a Retina or Windows HiDPI display, the scale is typically {@code (2, 2)} or
 * a fractional value such as {@code (1.5, 1.5)}.
 */
public record PixelScale(double x, double y) {
  public static final PixelScale IDENTITY = new PixelScale(1.0, 1.0);

  public boolean isIdentity() {
    return x == 1.0 && y == 1.0;
  }
}
