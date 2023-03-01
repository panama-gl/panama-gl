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

import com.jogamp.opengl.GLProfile;
import jogamp.nativewindow.macosx.OSXUtil;
import panamagl.GLCanvas;
import panamagl.GLEventListener;
import panamagl.factory.PanamaGLFactory;
import panamagl.offscreen.AOffscreenRenderer;
import panamagl.offscreen.OffscreenRenderer;

/**
 * This offscreen renderer is able to ensure that OpenGL queries are performed inside the main macOS thread.
 * 
 * 
 * <img src="doc-files/threading-macOS.png"/>
 * 
 * @author Martin Pernollet
 */
public class OffscreenRenderer_macOS extends AOffscreenRenderer implements OffscreenRenderer{
  public OffscreenRenderer_macOS(PanamaGLFactory factory) {
    super(factory);
  }
  
  @Override
  public void onInit(GLCanvas drawable, GLEventListener listener) {
    initContext_OnMainThread(listener);
  }

  @Override
  public void onDisplay(GLCanvas drawable, GLEventListener listener) {
    // FIXME : why does it work with this
    renderGLToImage_OnMainThread(drawable, listener, drawable.getWidth(), drawable.getHeight(), false, true);
    // FIXME : and not with this?
    // renderGLToImage_OnMainThread(false, true);
  }

  @Override
  public void onResize(GLCanvas drawable, GLEventListener listener, int x, int y, int width, int height) {
    // wait=true causes deadlocks! So we do not wait
    // and then ask the rendering to asynchronously notify
    // this panel that a repaint should occur.
    boolean wait = false;

    renderGLToImage_OnMainThread(drawable, listener, width, height, wait, true);

    // here we need a callback to invoke repaint, otherwise we are always one frame late!
    // if resize too fast, we see that we display the previous image.
    //
    // Hence, following method is useless
    // paintComponent(getGraphics());    
  }
  
  /* ===================================================== */
  // BELOW FUNC ALLOW EXECUTING IN APPKIT MAIN THREAD

  protected void initContext_OnMainThread(GLEventListener listener) {
    GLProfile.initSingleton();
    OSXUtil.RunOnMainThread(true, false, getTask_initContext(listener));
  }

  protected void renderGLToImage_OnMainThread(GLCanvas drawable, GLEventListener listener, boolean waitUntilDone, boolean kickNSApp) {
    OSXUtil.RunOnMainThread(waitUntilDone, kickNSApp, getTask_renderGLToImage(drawable, listener));
  }

  protected void renderGLToImage_OnMainThread(GLCanvas drawable, GLEventListener listener, int width, int height, boolean waitUntilDone,
      boolean kickNSApp) {
    OSXUtil.RunOnMainThread(waitUntilDone, kickNSApp, getTask_renderGLToImage(drawable, listener, width, height));
  }
}
