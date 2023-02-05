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
package panamagl.os.macos;

import panamagl.GLCanvas;
import panamagl.factory.APanamaGLFactory;
import panamagl.factory.PanamaGLFactory;
import panamagl.offscreen.FBO;
import panamagl.offscreen.OffscreenRenderer;
import panamagl.opengl.GL;
import panamagl.opengl.GLContext;

public abstract class APanamaGLFactory_macOS extends APanamaGLFactory {

	public APanamaGLFactory_macOS() {
		super();
	}

	/**
	   * Invoked by the {@link GLCanvas}, i.e. canvas that wishes to draw
	   * offscreen rendered image.
	   * 
	   * The offscreen renderer will initialize {@link GL}, {@link GLContext} and {@link FBO} 
	   * instances through this factory.
	   */
	@Override
	public OffscreenRenderer newOffscreenRenderer() {
	    return new OffscreenRenderer_macOS(this);
	  }

}