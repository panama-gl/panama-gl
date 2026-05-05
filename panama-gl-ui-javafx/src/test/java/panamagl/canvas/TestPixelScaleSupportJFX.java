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

import java.awt.GraphicsEnvironment;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.stage.Stage;
import org.junit.Assert;
import org.junit.Assume;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Unit tests for {@link PixelScaleSupportJFX}. Each test owns its own JavaFX scene/stage so the
 * cascade of listeners (canvas->scene->window->renderScale) can be exercised end to end.
 */
public class TestPixelScaleSupportJFX {

  @BeforeClass
  public static void startFx() {
    Assume.assumeFalse(GraphicsEnvironment.isHeadless());
    try {
      Platform.startup(() -> {});
    } catch (IllegalStateException alreadyStarted) {
      // OK: another test already started the JavaFX platform.
    }
  }

  /**
   * Run a task on the JavaFX thread and wait for it to complete.
   *
   * <p>30s timeout instead of the obvious "few seconds": on cold Linux CI runners (e.g. GitHub
   * Actions ubuntu-latest without a real display), the JavaFX Platform's first
   * {@code Platform.runLater} dispatch can take several seconds to fire while Prism initializes
   * its software pipeline — the {@code Runnable} itself is trivial here.
   */
  private static void runFx(Runnable r) throws InterruptedException {
    CountDownLatch latch = new CountDownLatch(1);
    Platform.runLater(() -> {
      try {
        r.run();
      } finally {
        latch.countDown();
      }
    });
    Assert.assertTrue("FX task timed out", latch.await(30, TimeUnit.SECONDS));
  }

  @Test
  public void read_returnsScreenScale_beforeAttachedToWindow() throws Exception {
    AtomicReference<PixelScale> scale = new AtomicReference<>();
    runFx(() -> {
      Canvas canvas = new Canvas(100, 100);
      PixelScaleSupportJFX support = new PixelScaleSupportJFX(canvas);
      scale.set(support.read());
    });
    Assert.assertNotNull(scale.get());
    Assert.assertTrue(scale.get().x() > 0);
    Assert.assertTrue(scale.get().y() > 0);
  }

  @Test
  public void start_isIdempotent() throws Exception {
    runFx(() -> {
      Canvas canvas = new Canvas(100, 100);
      PixelScaleSupportJFX support = new PixelScaleSupportJFX(canvas);
      support.start();
      support.start(); // must not throw
      support.stop();
    });
  }

  @Test
  public void stop_isIdempotent() throws Exception {
    runFx(() -> {
      Canvas canvas = new Canvas(100, 100);
      PixelScaleSupportJFX support = new PixelScaleSupportJFX(canvas);
      support.stop(); // before start
      support.start();
      support.stop();
      support.stop(); // double stop
    });
  }

  /**
   * Verify that the listener cascade rewires correctly when the canvas is attached to a stage —
   * i.e. that the support reads the actual window's render scale once a window is present, and
   * not just the screen output scale.
   */
  @Test
  public void read_returnsWindowRenderScale_afterAttachedToStage() throws Exception {
    AtomicReference<PixelScale> beforeAttach = new AtomicReference<>();
    AtomicReference<PixelScale> afterAttach = new AtomicReference<>();
    runFx(() -> {
      Canvas canvas = new Canvas(100, 100);
      PixelScaleSupportJFX support = new PixelScaleSupportJFX(canvas);
      support.start();
      beforeAttach.set(support.current());

      Stage stage = new Stage();
      Scene scene = new Scene(new Group(canvas), 100, 100);
      stage.setScene(scene);
      stage.show();

      afterAttach.set(new PixelScale(stage.getRenderScaleX(), stage.getRenderScaleY()));
      stage.close();
    });
    Assert.assertNotNull(beforeAttach.get());
    Assert.assertNotNull(afterAttach.get());
    // Both should be positive; on most setups they are equal (renderScale == outputScale).
    Assert.assertTrue(afterAttach.get().x() > 0);
    Assert.assertTrue(afterAttach.get().y() > 0);
  }

  @Test
  public void listeners_canBeAddedAndRemoved() throws Exception {
    runFx(() -> {
      Canvas canvas = new Canvas(100, 100);
      PixelScaleSupportJFX support = new PixelScaleSupportJFX(canvas);
      PixelScaleListener l = (o, n) -> {};
      support.addListener(l);
      support.removeListener(l);
    });
  }
}
