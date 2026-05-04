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
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import javafx.application.Platform;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.WritableImage;
import org.junit.Assert;
import org.junit.Assume;
import org.junit.BeforeClass;
import org.junit.Test;
import panamagl.factory.PanamaGLFactory;
import panamagl.image.JFXImage;
import panamagl.offscreen.AOffscreenRenderer;
import panamagl.offscreen.FBO;
import panamagl.offscreen.FBOReader_JFX;
import panamagl.opengl.GL;
import panamagl.opengl.GLContext;

/**
 * Regression guard for the JavaFX-side HiDPI fixes:
 * <ul>
 * <li>{@link GLCanvasJFX#isStaleFrame(javafx.scene.image.Image)} classifies frames smaller than
 *     half the canvas's expected physical size as stale (init-time 10x10 frame produced by
 *     listener.init()'s synchronous shoot);</li>
 * <li>{@link GLCanvasJFX#setScreenshot(panamagl.Image)} skips drawing stale frames yet still
 *     resets the {@code rendering} flag so the next display() at the proper size is not gated.</li>
 * </ul>
 */
public class TestGLCanvasJFX_HiDPI {

  @BeforeClass
  public static void startFx() {
    Assume.assumeFalse(GraphicsEnvironment.isHeadless());
    try {
      Platform.startup(() -> {});
    } catch (IllegalStateException alreadyStarted) {
      // OK
    }
  }

  private static PanamaGLFactory newMockPanamaGLFactory() {
    PanamaGLFactory f = mock(PanamaGLFactory.class);
    when(f.newOffscreenRenderer(any())).thenReturn(new AOffscreenRenderer(f, new FBOReader_JFX()));
    when(f.newGL()).thenReturn(mock(GL.class));
    when(f.newGLContext()).thenReturn(mock(GLContext.class));
    when(f.newFBO(anyInt(), anyInt())).thenReturn(mock(FBO.class));
    return f;
  }

  /** Run a task on the JavaFX thread and wait for it to complete. */
  private static void runFx(Runnable r) throws InterruptedException {
    CountDownLatch latch = new CountDownLatch(1);
    Platform.runLater(() -> {
      try {
        r.run();
      } finally {
        latch.countDown();
      }
    });
    Assert.assertTrue("FX task timed out", latch.await(5, TimeUnit.SECONDS));
  }

  /** Build a GLCanvasJFX with an inner Canvas pre-sized for deterministic testing. */
  private static GLCanvasJFX newCanvas(double w, double h) {
    Canvas fxCanvas = new Canvas();
    fxCanvas.setWidth(w);
    fxCanvas.setHeight(h);
    GLCanvasJFX glCanvas = new GLCanvasJFX(newMockPanamaGLFactory(), fxCanvas);
    // HiDPI off so getPhysicalWidth() == getWidth(), independent of the host display's pixel
    // scale — keeps the test deterministic on Retina, Linux 1x, etc.
    glCanvas.setHiDPIEnabled(false);
    return glCanvas;
  }

  // ---------------------------------------------------------------------------------
  // isStaleFrame logic

  @Test
  public void isStaleFrame_returnsTrue_whenFrameMuchSmallerThanCanvas() throws Exception {
    runFx(() -> {
      GLCanvasJFX glCanvas = newCanvas(200, 200);
      Assert.assertTrue("10x10 frame on a 200x200 canvas must be stale",
          glCanvas.isStaleFrame(new WritableImage(10, 10)));
    });
  }

  @Test
  public void isStaleFrame_returnsFalse_whenFrameMatchesCanvas() throws Exception {
    runFx(() -> {
      GLCanvasJFX glCanvas = newCanvas(200, 200);
      Assert.assertFalse("200x200 frame on a 200x200 canvas must not be stale",
          glCanvas.isStaleFrame(new WritableImage(200, 200)));
    });
  }

  @Test
  public void isStaleFrame_returnsFalse_whenCanvasNotYetSized() throws Exception {
    runFx(() -> {
      GLCanvasJFX glCanvas = newCanvas(0, 0);
      Assert.assertFalse(
          "with no canvas reference size, no frame should be classified as stale",
          glCanvas.isStaleFrame(new WritableImage(10, 10)));
    });
  }

  /**
   * The 50% threshold tolerates fractional Windows scaling (1.25x, 1.5x, 1.75x): a frame larger
   * than half the canvas's expected size must be blitted normally even if smaller than the
   * canvas itself (e.g. transient scaling state).
   */
  @Test
  public void isStaleFrame_returnsFalse_whenFrameAtHalfThreshold() throws Exception {
    runFx(() -> {
      GLCanvasJFX glCanvas = newCanvas(200, 200);
      // 100x100 = exactly half — must NOT be stale (boundary case).
      Assert.assertFalse(glCanvas.isStaleFrame(new WritableImage(100, 100)));
      // 99x100 — just below half on the X axis — IS stale.
      Assert.assertTrue(glCanvas.isStaleFrame(new WritableImage(99, 100)));
    });
  }

  // ---------------------------------------------------------------------------------
  // setScreenshot integration

  /**
   * The stale-frame skip path must still reset the rendering flag, otherwise the next
   * {@code display()} at the proper size would be gated by {@code isRendering()==true} and
   * effectively never render.
   */
  @Test
  public void setScreenshot_resetsRenderingFlag_evenWhenStale() throws Exception {
    runFx(() -> {
      GLCanvasJFX glCanvas = newCanvas(200, 200);
      glCanvas.setRendering(true);

      glCanvas.setScreenshot(new JFXImage(new WritableImage(10, 10)));

      Assert.assertFalse("rendering must be reset to false after a skipped paint",
          glCanvas.isRendering());
    });
  }

  @Test
  public void setScreenshot_resetsRenderingFlag_forProperFrame() throws Exception {
    runFx(() -> {
      GLCanvasJFX glCanvas = newCanvas(200, 200);
      glCanvas.setRendering(true);

      glCanvas.setScreenshot(new JFXImage(new WritableImage(200, 200)));

      Assert.assertFalse(glCanvas.isRendering());
    });
  }
}
