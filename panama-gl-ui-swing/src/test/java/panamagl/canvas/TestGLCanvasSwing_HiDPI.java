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
package panamagl.canvas;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.awt.GraphicsEnvironment;
import org.junit.Assert;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;
import panamagl.factory.PanamaGLFactory;
import panamagl.offscreen.AOffscreenRenderer;
import panamagl.offscreen.FBO;
import panamagl.offscreen.FBOReader_AWT;
import panamagl.opengl.GL;
import panamagl.opengl.GLContext;

public class TestGLCanvasSwing_HiDPI {

  @Before
  public void requireHeadful() {
    Assume.assumeFalse(GraphicsEnvironment.isHeadless());
  }

  private GLCanvasSwing newCanvas() {
    PanamaGLFactory factory = mock(PanamaGLFactory.class);
    when(factory.newOffscreenRenderer(any()))
        .thenReturn(new AOffscreenRenderer(factory, new FBOReader_AWT()));
    when(factory.newGL()).thenReturn(mock(GL.class));
    when(factory.newGLContext()).thenReturn(mock(GLContext.class));
    when(factory.newFBO(anyInt(), anyInt())).thenReturn(mock(FBO.class));
    return new GLCanvasSwing(factory);
  }

  @Test
  public void getPixelScale_isNotNull_evenBeforeAddNotify() {
    GLCanvasSwing canvas = newCanvas();
    PixelScale s = canvas.getPixelScale();
    Assert.assertNotNull(s);
    Assert.assertTrue(s.x() > 0);
    Assert.assertTrue(s.y() > 0);
  }

  @Test
  public void hiDPIEnabled_defaultsToTrue() {
    GLCanvasSwing canvas = newCanvas();
    Assert.assertTrue(canvas.isHiDPIEnabled());
  }

  @Test
  public void physicalSize_followsLogical_whenHiDPIDisabled() {
    GLCanvasSwing canvas = newCanvas();
    canvas.setHiDPIEnabled(false);
    Assert.assertEquals(canvas.getWidth(), canvas.getPhysicalWidth());
    Assert.assertEquals(canvas.getHeight(), canvas.getPhysicalHeight());
  }

  @Test
  public void pixelScaleSupport_isInstantiated() {
    GLCanvasSwing canvas = newCanvas();
    Assert.assertNotNull(canvas.getPixelScaleSupport());
  }

  @Test
  public void addAndRemoveListener_doesNotThrow() {
    GLCanvasSwing canvas = newCanvas();
    PixelScaleListener l = (o, n) -> {};
    canvas.addPixelScaleListener(l);
    canvas.removePixelScaleListener(l);
  }
}
