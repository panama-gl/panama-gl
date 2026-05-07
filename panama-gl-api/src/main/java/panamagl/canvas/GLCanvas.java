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

import javax.swing.JPanel;
import panamagl.GLEventListener;
import panamagl.Image;
import panamagl.offscreen.OffscreenRenderer;
import panamagl.opengl.GL;
import panamagl.opengl.GLContext;
import panamagl.performance.RenderCounter;

/**
 * A canvas able to perform OpenGL calls through the {@link GLEventListener} interface.
 * 
 * @author Martin Pernollet
 */
public interface GLCanvas {
  /** Trigger display. The component is responsible for routing the request to the appropriate threads.*/
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
  
  void setScreenshot(Image<?> image);
  Image<?> getScreenshot();
  
  OffscreenRenderer getOffscreenRenderer();
  void setOffscreenRenderer(OffscreenRenderer offscreen);
  
  void setFlip(Flip flip);
  Flip getFlip();

  enum Flip{
    NONE, VERTICAL, HORIZONTAL;
  }

  /* ===================================================== */
  // HiDPI / pixel scale

  /**
   * Return the current pixel scale (ratio between physical pixels and logical pixels).
   *
   * <p>Returns {@link PixelScale#IDENTITY} for canvases that have not been displayed yet, or
   * for implementations that do not yet support HiDPI detection.
   */
  default PixelScale getPixelScale() {
    return PixelScale.IDENTITY;
  }

  /**
   * Width of the rendering surface (FBO) in physical pixels.
   *
   * <p>When HiDPI is enabled, this is {@code getWidth() * pixelScale.x()}; otherwise it equals
   * {@link #getWidth()}.
   */
  default int getPhysicalWidth() {
    return isHiDPIEnabled() ? (int) Math.round(getWidth() * getPixelScale().x()) : getWidth();
  }

  /**
   * Height of the rendering surface (FBO) in physical pixels.
   *
   * @see #getPhysicalWidth()
   */
  default int getPhysicalHeight() {
    return isHiDPIEnabled() ? (int) Math.round(getHeight() * getPixelScale().y()) : getHeight();
  }

  /**
   * Register a listener notified when {@link #getPixelScale()} changes.
   *
   * <p>Default implementation is a no-op for canvases that do not yet support HiDPI events.
   */
  default void addPixelScaleListener(PixelScaleListener listener) {}

  /** Remove a previously registered {@link PixelScaleListener}. */
  default void removePixelScaleListener(PixelScaleListener listener) {}

  /**
   * Whether HiDPI rendering is enabled.
   *
   * <p>When {@code true} (the default), the FBO is dimensioned in physical pixels — sharp
   * rendering on Retina/HiDPI displays at the cost of more pixels to fill.
   *
   * <p>When {@code false}, the FBO is dimensioned in logical pixels — equivalent to setting a
   * pixel scale of {@code (1, 1)}: faster but the image is upscaled by the toolkit on HiDPI
   * displays. Mirrors Jzy3D's {@code Quality.preserveViewportSize=true}.
   */
  default boolean isHiDPIEnabled() {
    return true;
  }

  /** Toggle HiDPI rendering. @see #isHiDPIEnabled() */
  default void setHiDPIEnabled(boolean enabled) {}

}
