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

import java.lang.foreign.MemorySegment;
import panamagl.Image;
import panamagl.opengl.GL;

/**
 * A frame buffer object, or {@link FBO}, can render OpenGL into an offscreen buffer that can later
 * be read to an {@link Image} by a {@link FBOReader} which will access the FBO content through {@link FBO#readPixels(GL)}.
 *
 * @author Martin Pernollet
 */
public interface FBO {
  void prepare(GL gl);
  void release(GL gl);
  void resize(int width, int height);
  int getWidth();
  int getHeight();
  
  boolean isPrepared();
  
  MemorySegment readPixels(GL gl);

  /**
   * Bind this FBO so that the following GL commands target it, e.g. to perform GL work out of the
   * rendering of a canvas such as picking from a mouse event. The FBO is prepared if it is not
   * already, otherwise it is bound as is, i.e. without being recreated nor cleared.
   * 
   * The GL context of the canvas must be current on the calling thread. Out of a
   * {@link panamagl.GLEventListener} method, the work must therefore be performed with the
   * {@link ThreadRedirect} of the canvas renderer, which may run it later (see
   * <code>doc/Multithreading.md</code>) :
   * 
   * <pre>
   * <code>
   * OffscreenRenderer renderer = canvas.getOffscreenRenderer();
   * 
   * renderer.getThreadRedirect().run(() -&gt; {
   *   GL gl = renderer.getGL();
   *   renderer.getFBO().bind(gl);
   *   // GL work targeting the canvas framebuffer
   *   renderer.getFBO().unbind(gl);
   * });
   * </code>
   * </pre>
   * 
   * @see #unbind(GL)
   */
  void bind(GL gl);

  /**
   * Bind back the default framebuffer, so that the following GL commands do not target this FBO
   * anymore. Same thread requirement as {@link #bind(GL)}.
   */
  void unbind(GL gl);
}
