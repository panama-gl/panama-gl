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

import panamagl.GLCanvas;
import panamagl.GLEventListener;
import panamagl.opengl.GL;
import panamagl.opengl.GLContext;

/**
 * The interface through which various {@link GLCanvas} implementation can query
 * an offscreen rendering. 
 * 
 * This allows various platforms to use different threading policies, the macOS one being the most particular.
 * 
 * @author Martin
 */
public interface OffscreenRenderer {
  void onInit(GLCanvas drawable, GLEventListener glEventListener);
  void onDisplay(GLCanvas drawable, GLEventListener glEventListener);
  void onResize(GLCanvas drawable, GLEventListener glEventListener, int x, int y, int width, int height);
  void onDestroy(GLCanvas drawable, GLEventListener glEventListener);
  
  GL getGL();
  GLContext getContext();
  
  boolean isFlipY();
  void setFlipY(boolean flipY);
  void setFBO(FBO fbo);
  FBO getFBO();
  
  boolean isInitialized();
  
  ThreadRedirect getThreadRedirect();
  void setThreadRedirect(ThreadRedirect threadRedirect);
  
  void setDebugFile(String debugFile);
  String getDebugFile();
}
