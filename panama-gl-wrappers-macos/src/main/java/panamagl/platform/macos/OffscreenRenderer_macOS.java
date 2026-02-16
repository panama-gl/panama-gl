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
package panamagl.platform.macos;

import panamagl.factory.PanamaGLFactory;
import panamagl.offscreen.AOffscreenRenderer;
import panamagl.offscreen.FBOReader;
import panamagl.offscreen.MacOSThreadRedirect;
import panamagl.offscreen.OffscreenRenderer;

/**
 * This offscreen renderer is able to ensure that OpenGL queries are performed inside the main macOS thread.
 * 
 * <img src="doc-files/threading-macOS.png"/>
 * 
 * @author Martin Pernollet
 */
public class OffscreenRenderer_macOS extends AOffscreenRenderer implements OffscreenRenderer{
  public OffscreenRenderer_macOS(PanamaGLFactory factory, FBOReader reader) {
    super(factory, reader);
    
    // TODO : make something better
    // CGL contexts are thread-portable and do not require the macOS main thread.
    // Using AWTThreadRedirect avoids deadlocks when the main thread is not pumping
    // AppKit events (e.g. with -XstartOnFirstThread or after main() returns).
    //
    // GLUT contexts require the macOS main thread, so we keep MacOSThreadRedirect for them.

    threadRedirect = new MacOSThreadRedirect();
  }
}
