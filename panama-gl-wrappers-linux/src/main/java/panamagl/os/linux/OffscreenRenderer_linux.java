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
package panamagl.os.linux;

import panamagl.AOffscreenRenderer;
import panamagl.GLAutoDrawable;
import panamagl.GLEventListener;
import panamagl.OffscreenRenderer;
import panamagl.factory.PanamaGLFactory;

public class OffscreenRenderer_linux extends AOffscreenRenderer implements OffscreenRenderer{
  public OffscreenRenderer_linux(PanamaGLFactory factory) {
    super(factory);
  }
  
  @Override
  public void onInit(GLAutoDrawable drawable, GLEventListener listener) {
    // MACOS
    //GLProfile.initSingleton();
    //OSXUtil.RunOnMainThread(true, false, getTask_initContext(listener));
    Runnable r = getTask_initContext(listener);
    r.run();
  }

  @Override
  public void onDisplay(GLAutoDrawable drawable, GLEventListener listener) {
    Runnable r = getTask_renderGLToImage(drawable, listener, drawable.getWidth(), drawable.getHeight());
    r.run();
  }

  @Override
  public void onResize(GLAutoDrawable drawable, GLEventListener listener, int x, int y, int width, int height) {
    Runnable r = getTask_renderGLToImage(drawable, listener, drawable.getWidth(), drawable.getHeight());
    r.run();
  }
}
