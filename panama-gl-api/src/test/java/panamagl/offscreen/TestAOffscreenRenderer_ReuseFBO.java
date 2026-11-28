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

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.lang.foreign.MemorySegment;
import org.junit.Assert;
import org.junit.Test;
import panamagl.GLEventListener;
import panamagl.canvas.GLCanvas;
import panamagl.factory.PanamaGLFactory;
import panamagl.opengl.GL;
import panamagl.opengl.GLContext;

/**
 * A display is requested for each frame, e.g. 60 times per second by an animator. When the canvas
 * keeps its size, the renderer must neither recreate the FBO, which allocates its texture and pixel
 * buffer again, nor reshape the listener, which renders the scene once more for Jzy3D.
 */
public class TestAOffscreenRenderer_ReuseFBO {

  /** An FBO counting how often it is prepared, released and bound, without GPU. */
  static class CountingFBO extends AFBO {
    int prepares = 0;
    int releases = 0;
    int binds = 0;

    CountingFBO(int width, int height) {
      this.width = width;
      this.height = height;
    }

    @Override
    public void prepare(GL gl) {
      prepares++;
      prepared = true;
    }

    @Override
    public void release(GL gl) {
      if (prepared) {
        releases++;
      }
      prepared = false;
    }

    @Override
    public void bind(GL gl) {
      binds++;
      super.bind(gl);
    }

    @Override
    public MemorySegment readPixels(GL gl) {
      return MemorySegment.NULL;
    }

    @Override
    protected void bindFramebuffer(int id) {}
  }

  static class CountingListener implements GLEventListener {
    int displays = 0;
    int reshapes = 0;
    int lastWidth = -1;
    int lastHeight = -1;

    @Override
    public void init(GL gl) {}

    @Override
    public void display(GL gl) {
      displays++;
    }

    @Override
    public void reshape(GL gl, int x, int y, int width, int height) {
      reshapes++;
      lastWidth = width;
      lastHeight = height;
    }

    @Override
    public void dispose(GL gl) {}
  }

  @Test
  public void whenDisplayedAgainWithTheSameSize_thenFBOIsReusedAndListenerNotReshaped() {
    // Given a renderer with GL mocks, running its tasks on the calling thread
    CountingFBO[] fbo = new CountingFBO[1];

    PanamaGLFactory factory = mock(PanamaGLFactory.class);
    when(factory.newGL()).thenReturn(mock(GL.class));
    when(factory.newGLContext()).thenReturn(mock(GLContext.class));
    when(factory.newFBO(anyInt(), anyInt())).thenAnswer(
        inv -> fbo[0] = new CountingFBO(inv.getArgument(0), inv.getArgument(1)));

    GLCanvas canvas = mock(GLCanvas.class);
    when(canvas.getWidth()).thenReturn(300);
    when(canvas.getHeight()).thenReturn(200);
    when(canvas.getPhysicalWidth()).thenReturn(300);
    when(canvas.getPhysicalHeight()).thenReturn(200);

    AOffscreenRenderer renderer = new AOffscreenRenderer(factory, mock(FBOReader.class));
    renderer.setThreadRedirect(new NoRedirect());

    CountingListener listener = new CountingListener();

    renderer.onInit(canvas, listener);
    Assert.assertEquals(1, fbo[0].prepares);

    // When displaying several frames with the same size
    for (int i = 0; i < 10; i++) {
      renderer.onDisplay(canvas, listener);
    }

    // Then the FBO prepared at init is only bound, and the listener reshaped once
    Assert.assertEquals(10, listener.displays);
    Assert.assertEquals(1, listener.reshapes);
    Assert.assertEquals(300, listener.lastWidth);
    Assert.assertEquals(200, listener.lastHeight);
    Assert.assertEquals(1, fbo[0].prepares);
    Assert.assertEquals(0, fbo[0].releases);
    Assert.assertEquals(10, fbo[0].binds);

    // When resizing the canvas
    when(canvas.getPhysicalWidth()).thenReturn(400);
    when(canvas.getPhysicalHeight()).thenReturn(300);
    renderer.onResize(canvas, listener, 0, 0, 400, 300);

    // Then the FBO is recreated for the new size and the listener reshaped
    Assert.assertEquals(2, fbo[0].prepares);
    Assert.assertEquals(1, fbo[0].releases);
    Assert.assertEquals(400, fbo[0].getWidth());
    Assert.assertEquals(300, fbo[0].getHeight());
    Assert.assertEquals(2, listener.reshapes);
    Assert.assertEquals(400, listener.lastWidth);
    Assert.assertEquals(300, listener.lastHeight);

    // When displaying again with the new size
    renderer.onDisplay(canvas, listener);
    renderer.onDisplay(canvas, listener);

    // Then nothing is recreated nor reshaped
    Assert.assertEquals(13, listener.displays);
    Assert.assertEquals(2, listener.reshapes);
    Assert.assertEquals(2, fbo[0].prepares);
    Assert.assertEquals(1, fbo[0].releases);
  }

  @Test
  public void whenContextIsInitializedAgain_thenListenerIsReshapedAgain() {
    PanamaGLFactory factory = mock(PanamaGLFactory.class);
    when(factory.newGL()).thenReturn(mock(GL.class));
    when(factory.newGLContext()).thenReturn(mock(GLContext.class));
    when(factory.newFBO(anyInt(), anyInt()))
        .thenAnswer(inv -> new CountingFBO(inv.getArgument(0), inv.getArgument(1)));

    GLCanvas canvas = mock(GLCanvas.class);
    when(canvas.getWidth()).thenReturn(300);
    when(canvas.getHeight()).thenReturn(200);
    when(canvas.getPhysicalWidth()).thenReturn(300);
    when(canvas.getPhysicalHeight()).thenReturn(200);

    AOffscreenRenderer renderer = new AOffscreenRenderer(factory, mock(FBOReader.class));
    renderer.setThreadRedirect(new NoRedirect());
    CountingListener listener = new CountingListener();

    renderer.onInit(canvas, listener);
    renderer.onDisplay(canvas, listener);
    Assert.assertEquals(1, listener.reshapes);

    // When the context is created again, e.g. after the canvas was removed and added back
    renderer.onDestroy(canvas, listener);
    renderer.onInit(canvas, listener);
    renderer.onDisplay(canvas, listener);

    // Then the listener of the new context is given its size
    Assert.assertEquals(2, listener.reshapes);
  }
}
