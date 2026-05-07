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
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import org.junit.Assert;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;
import panamagl.canvas.GLCanvas.Flip;
import panamagl.factory.PanamaGLFactory;
import panamagl.image.AWTImage;
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

  // ---------------------------------------------------------------------------------
  // paintComponent stale-frame guard

  /** Build a canvas configured for deterministic paintComponent testing. */
  private GLCanvasSwing newCanvasForPaintTest(int panelW, int panelH) {
    GLCanvasSwing canvas = newCanvas();
    canvas.setSize(panelW, panelH);
    // HiDPI off so getPhysicalWidth() == getWidth(), independent of the host display's pixel
    // scale — keeps the test deterministic on Retina, Linux 1x, etc.
    canvas.setHiDPIEnabled(false);
    canvas.setFlip(Flip.NONE);                  // simplest drawImage signature
    canvas.setShowRenderingTime(false);         // skip overlay drawing
    return canvas;
  }

  /**
   * Regression guard for the ~200ms pixelated flash on chart open: the 10x10 init frame
   * produced by {@code listener.init()} (Jzy3D's View.init synchronous shoot) used to be blitted
   * scaled-up to the panel size by AWT's first paint() after layout. {@code paintComponent} now
   * detects the stale frame (smaller than half the panel's expected physical size) and skips the
   * blit so the next properly-sized frame replaces the background instead.
   */
  @Test
  public void paintComponent_skipsBlit_whenScreenshotIsMuchSmallerThanPanel() {
    GLCanvasSwing canvas = newCanvasForPaintTest(200, 200);
    BufferedImage stale = new BufferedImage(10, 10, BufferedImage.TYPE_INT_ARGB);
    canvas.setScreenshot(new AWTImage(stale));

    Graphics g = mock(Graphics.class);
    canvas.paintComponent(g);

    // The stale 10x10 image must not have been blitted.
    verify(g, never()).drawImage(eq(stale), anyInt(), anyInt(), anyInt(), anyInt(),
        any(ImageObserver.class));
  }

  /**
   * The skip path must still reset the rendering flag so the next {@code display()} at the
   * proper size is not gated by {@code isRendering()==true}.
   */
  @Test
  public void paintComponent_resetsRenderingFlag_evenWhenSkipped() {
    GLCanvasSwing canvas = newCanvasForPaintTest(200, 200);
    canvas.setScreenshot(new AWTImage(new BufferedImage(10, 10, BufferedImage.TYPE_INT_ARGB)));
    canvas.setRendering(true);

    canvas.paintComponent(mock(Graphics.class));

    Assert.assertFalse("rendering must be reset to false after a skipped paint",
        canvas.isRendering());
  }

  @Test
  public void paintComponent_blits_whenScreenshotMatchesPanelSize() {
    GLCanvasSwing canvas = newCanvasForPaintTest(200, 200);
    BufferedImage proper = new BufferedImage(200, 200, BufferedImage.TYPE_INT_ARGB);
    canvas.setScreenshot(new AWTImage(proper));

    Graphics g = mock(Graphics.class);
    canvas.paintComponent(g);

    verify(g).drawImage(eq(proper), eq(0), eq(0), eq(200), eq(200), any(ImageObserver.class));
  }

  /**
   * The 50% threshold tolerates fractional Windows scaling (1.25x, 1.5x, 1.75x): a Retina-style
   * 2x scale produces a 400-pixel-wide frame for a 200-logical-wide panel — that's well above
   * the threshold so it's blitted normally even with HiDPI on.
   */
  @Test
  public void paintComponent_blits_whenFrameIsAtRetinaScale() {
    GLCanvasSwing canvas = newCanvasForPaintTest(200, 200);
    // Re-enable HiDPI and stub the scale so getPhysicalWidth() reports 400.
    // We can't set a custom PixelScale on the support directly, so we rely on the fact that
    // a 400x400 frame (twice the logical size) is comfortably above the panel's threshold —
    // the panel's getPhysicalWidth() is at least getWidth() = 200 here, so 400 > 200/2 = 100
    // satisfies the guard whatever the actual pixel scale of the host.
    canvas.setHiDPIEnabled(true);
    BufferedImage proper = new BufferedImage(400, 400, BufferedImage.TYPE_INT_ARGB);
    canvas.setScreenshot(new AWTImage(proper));

    Graphics g = mock(Graphics.class);
    canvas.paintComponent(g);

    verify(g).drawImage(eq(proper), eq(0), eq(0), eq(200), eq(200), any(ImageObserver.class));
  }

  /**
   * When the panel itself has not been sized yet (getWidth/Height &lt;= 1), there is no
   * sensible reference to compare the frame against. Don't classify the frame as stale, otherwise
   * an explicit pre-shown render would be discarded.
   */
  @Test
  public void paintComponent_doesNotSkip_whenPanelIsNotSizedYet() {
    GLCanvasSwing canvas = newCanvasForPaintTest(0, 0);
    BufferedImage frame = new BufferedImage(10, 10, BufferedImage.TYPE_INT_ARGB);
    canvas.setScreenshot(new AWTImage(frame));

    Graphics g = mock(Graphics.class);
    canvas.paintComponent(g);

    verify(g).drawImage(eq(frame), anyInt(), anyInt(), anyInt(), anyInt(),
        any(ImageObserver.class));
  }
}
