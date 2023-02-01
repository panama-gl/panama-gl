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

import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import panamagl.opengl.GL;
import panamagl.opengl.GLContext;
import panamagl.performance.RenderCounter;

/**
 * A canvas able to perform OpenGL calls through the {@link GLEventListener} interface.
 * 
 * @author Martin Pernollet
 */
public interface GLCanvas {
  /** Trigger display. The component is responsible for rooting the request to the appropriate threads.*/
  void display();
  
  /** Return true if a frame rendering has started and not yet finished. */
  boolean isRendering();

  /** Return the event listener handling init, drawing and resize requests. */
  GLEventListener getGLEventListener();

  /** Set the event listener handling init, drawing and resize requests. */
  void setGLEventListener(GLEventListener listener);

  /** Return true if the panel has initialized GL ressource and is ready for display. */
  boolean isInitialized();

  /** Return true if the component is visible on screen (depend on windowing toolkit implementation, e.g. {@link JPanel#isVisible()}). */
  boolean isVisible();

  /** Return the GL context. */
  GLContext getContext();

  /** Return the GL instance allowing to invoke OpenGL. */
  GL getGL();
  
  /** Return the performance information about this panel. */
  RenderCounter getMonitoring();
  
  int getWidth();
  int getHeight();
  
  void repaint();
  
  void setScreenshot(BufferedImage image);
  BufferedImage getScreenshot();
  
  OffscreenRenderer getOffscreenRenderer();
  void setOffscreenRenderer(OffscreenRenderer offscreen);
  
}
