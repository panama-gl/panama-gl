/*******************************************************************************
 * Copyright (c) 2022 Martin Pernollet & contributors.
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
package org.jzy3d.chart.factories.natives;

import org.jzy3d.painters.IPainter;
import org.jzy3d.painters.natives.PanamaGLPainter_Ubuntu_20_04;

public class PanamaGLPainterFactory_Ubuntu_20_04 extends AbstractPanamaGLPainterFactory {


  public PanamaGLPainterFactory_Ubuntu_20_04() {
  }

  @Override
  public IPainter newPainter() {
    return new PanamaGLPainter_Ubuntu_20_04();
  }

  ///////////////////////

}