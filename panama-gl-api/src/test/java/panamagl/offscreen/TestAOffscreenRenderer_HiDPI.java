/*******************************************************************************
 * Copyright (c) 2022, 2023 Martin Pernollet & contributors.
 *
 * This library is free software; you can redistribute it and/or modify it under the terms of the
 * GNU Lesser General Public License as published by the Free Software Foundation; either version
 * 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License along with this library;
 * if not, write to the Free Software Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA
 * 02110-1301, USA
 *******************************************************************************/
package panamagl.offscreen;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.Test;
import panamagl.GLEventListener;
import panamagl.canvas.GLCanvas;
import panamagl.factory.PanamaGLFactory;
import panamagl.opengl.GL;
import panamagl.opengl.GLContext;

/**
 * Regression guard: {@link AOffscreenRenderer#onDisplay} must dimension the FBO and call
 * {@link GLEventListener#reshape} with <b>physical</b> pixel sizes (matching what the
 * canvas's ResizeHandler already passes to onResize), not the logical sizes returned by
 * {@code getWidth()/getHeight()}.
 *
 * <p>Without this, on Retina the FBO would be allocated at logical {@code W x H} during
 * {@code forceRepaint()} flows that go through {@code onDisplay} (e.g. mouse hover), while
 * the rest of the pipeline expects {@code 2W x 2H} — only the bottom-left quarter of the
 * scene would render.
 */
public class TestAOffscreenRenderer_HiDPI {
  static int WAIT_AWT_EVENT_MS = 100;

  @Test
  public void onDisplay_readsPhysicalPixelsFromGLCanvas() throws InterruptedException {
    FBO fbo = mock(FBO.class);

    PanamaGLFactory factory = mock(PanamaGLFactory.class);
    when(factory.newGL()).thenReturn(mock(GL.class));
    when(factory.newGLContext()).thenReturn(mock(GLContext.class));
    when(factory.newOffscreenRenderer(any())).thenReturn(mock(OffscreenRenderer.class));
    when(factory.newFBO(anyInt(), anyInt())).thenReturn(fbo);

    FBOReader reader = mock(FBOReader.class);
    GLEventListener listener = mock(GLEventListener.class);

    // Canvas reports logical 100x50 but physical 200x100 — typical Retina case.
    GLCanvas canvas = mock(GLCanvas.class);
    when(canvas.getWidth()).thenReturn(100);
    when(canvas.getHeight()).thenReturn(50);
    when(canvas.getPhysicalWidth()).thenReturn(200);
    when(canvas.getPhysicalHeight()).thenReturn(100);

    AOffscreenRenderer renderer = new AOffscreenRenderer(factory, reader);
    renderer.onInit(canvas, listener);
    Thread.sleep(WAIT_AWT_EVENT_MS);

    // When onDisplay fires (no resize event in between)
    renderer.onDisplay(canvas, listener);
    Thread.sleep(WAIT_AWT_EVENT_MS);

    // Then reshape must have been called with physical pixels.
    verify(listener, atLeastOnce()).reshape(any(), eq(0), eq(0), eq(200), eq(100));

    // Sanity: the listener must NOT have been called with the logical dimensions, otherwise
    // it would mean we regressed to getWidth/getHeight.
    verify(listener, never()).reshape(any(), eq(0), eq(0), eq(100), eq(50));
  }
}
