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

import static org.mockito.Mockito.mock;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BooleanSupplier;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import javafx.application.Platform;
import javafx.scene.canvas.Canvas;
import junit.framework.Assert;
import panamagl.GLEventAdapter;
import panamagl.GLEventListener;
import panamagl.factory.PanamaGLFactory;
import panamagl.offscreen.FBOReader_AWT;
import panamagl.offscreen.OffscreenRenderer;
import panamagl.offscreen.ThreadRedirect;
import panamagl.offscreen.ThreadRedirect_JFX;
import panamagl.opengl.GL;
import panamagl.platform.macos.OffscreenRenderer_macOS;
import panamagl.utils.ThreadUtils;
import panamagl.utils.TicToc;

public class TestGLCanvasJFX_all {
  /** Generous timeout for async operations: CI VMs can be much slower than dev machines. */
  public static long WAIT_TIMEOUT_MS = 10_000;
  /** Poll interval inside waitFor(). Short enough to be reactive, long enough not to spin. */
  public static long WAIT_POLL_MS = 20;

  @BeforeClass
  public static void initJfxRuntime() {
    System.out.println("init.1");
    CountDownLatch latch = new CountDownLatch(1);
    Platform.startup(() -> {
      System.out.println("init.2");
      latch.countDown();
      System.out.println("init.3");
    });

    System.out.println("init.4");
    try {
      latch.await(5, TimeUnit.SECONDS);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("init.5");
  }

  @Test
  public void whenPanelIsAdded_ThenGLEventListenerIsInvoked() throws InterruptedException {
    System.out.println("go");

    // ------------------------------------------------
    // Given a panel with an event counter

    EventCounter event = new EventCounter();

    PanamaGLFactory factory = PanamaGLFactory.select();

    System.out.println("FACTORY  " + factory);

    Canvas canvas = new ResizableCanvas();
    canvas.setWidth(600);
    canvas.setHeight(500);

    // When create a panel
    GLCanvasJFX panel = new GLCanvasJFX(factory, canvas);

    // Then JFX thread redirection is enabled
    ThreadRedirect redirect = panel.getOffscreenRenderer().getThreadRedirect();
    Assert.assertTrue(redirect instanceof ThreadRedirect_JFX);

    // Given a listener to verify events count
    GLEventListener listener = new GLEventAdapter() {
      @Override
      public void init(GL gl) {
        event.initCounter++;
      }

      @Override
      public void display(GL gl) {
        event.displayCounter++;
      }

      @Override
      public void reshape(GL gl, int x, int y, int width, int height) {
        event.reshapeCounter++;
      }

      @Override
      public void dispose(GL gl) {
        event.disposeCounter++;
      }
    };


    Assert.assertFalse(panel.isInitialized());

    // When add listener
    panel.setGLEventListener(listener);

    // Wait until the JFX thread has completed GL initialization (condition-based, not time-based)
    waitFor(panel::isInitialized, "Panel should be initialized after setGLEventListener");

    // Then immediately initialized
    Assert.assertTrue(panel.isInitialized());


    // ------------------------------------------------
    // When : GL initialization is triggered by panel addition
    // to its parent frame

    // panel.addNotify();

    // Let AWT or macOS main thread to perform initialization
    // Thread.sleep(WAIT_FOR_INIT_AND_DESTROY);

    // Then : should trigger glEventListener.init()
    Assert.assertEquals(1, event.initCounter);
    Assert.assertEquals(0, event.displayCounter);
    Assert.assertEquals(0, event.reshapeCounter);

    // Then context is initialized
    Assert.assertTrue(panel.getContext().isInitialized());

    // Then panel is initialized
    Assert.assertTrue(panel.isInitialized());



    // ------------------------------------------------
    // When : resize, and after a while

    canvas.resize(20, 20);

    // FIXME : not needed from IDE but from CLI (?!)
    panel.display();

    // Wait for the screenshot to be set, which is the LAST step of the rendering pipeline in
    // AOffscreenRenderer.renderGLToImage():
    //   1. listener.reshape()              → reshapeCounter++
    //   2. listener.display()              → displayCounter++
    //   3. readImageAndPaintInCanvas()     → setScreenshot()   ← we wait for THIS
    //
    // Waiting for displayCounter > 0 would fire at step 2, before setScreenshot() at step 3,
    // causing a race where assertNotNull(getScreenshot()) still sees null.
    waitFor(() -> panel.getScreenshot() != null,
        "Screenshot should be set after the full rendering pipeline completes");

    // Then : should trigger glEventListener.display() and reshape()
    // (guaranteed: both are called before setScreenshot in renderGLToImage)
    Assert.assertTrue(0 < event.initCounter);
    Assert.assertTrue(0 < event.displayCounter);
    Assert.assertTrue(0 < event.reshapeCounter);

    // Then : the displayed image should be available as screenshot
    Assert.assertNotNull(panel.getScreenshot());



    // ------------------------------------------------
    // When : remove from component hierarchy

    // TODO : handle deletion
    // panel.removeNotify();

    // (teardown — assertions below are commented out, no condition to wait for)

    // Then : all components are not initialized anymore
    // Assert.assertFalse(panel.getContext().isInitialized());
    // Assert.assertFalse(panel.isInitialized());
    // Assert.assertTrue(0 < event.disposeCounter);

  }


  protected class EventCounter {
    // volatile: written by the JFX thread, read by the test thread
    volatile int initCounter = 0;
    volatile int displayCounter = 0;
    volatile int reshapeCounter = 0;
    volatile int disposeCounter = 0;
  }



  @Test
  public void whenPanelIsResized_ThenFBOIsResized() throws InterruptedException {

    int WIDTH = 100;
    int HEIGHT = 100;

    // Given an initialized panel
    PanamaGLFactory factory = PanamaGLFactory.select();
    factory.setThreadRedirect(new ThreadRedirect_JFX());

    System.out.println("FACTORY  " + factory);

    Canvas canvas = new ResizableCanvas();
    canvas.setWidth(600);
    canvas.setHeight(500);

    // When create a panel
    GLCanvasJFX panel = new GLCanvasJFX(factory, canvas);

    // Then JFX thread redirection is enabled
    ThreadRedirect redirect = panel.getOffscreenRenderer().getThreadRedirect();
    Assert.assertTrue(redirect instanceof ThreadRedirect_JFX);

    // Given a listener to verify events count
    GLEventListener listener = new GLEventAdapter();

    Assert.assertFalse("Panel is not initialized", panel.isInitialized());

    // When add listener
    panel.setGLEventListener(listener);

    // When panel is added
    // panel.addNotify();

    // Wait until the JFX thread has completed GL initialization (condition-based, not time-based)
    waitFor(panel::isInitialized, "Panel should be initialized after setGLEventListener");

    // Then it is initialized
    Assert.assertTrue("Panel has initialized", panel.isInitialized());

    // -------------------------------
    // When panel is resized

    canvas.resize(WIDTH, HEIGHT);

    panel.display();

    // Wait until the FBO has been resized to the new dimensions
    waitFor(
        () -> panel.getFBO() != null && panel.getFBO().getWidth() == WIDTH
            && panel.getFBO().getHeight() == HEIGHT,
        "FBO width should be resized to " + WIDTH + "x" + HEIGHT);

    // Then FBO is resized as well
    Assert.assertEquals(WIDTH, panel.getFBO().getWidth());
    Assert.assertEquals(HEIGHT, panel.getFBO().getHeight());

    // -------------------------------
    // When panel is resized again

    canvas.resize(3 * WIDTH, 2 * HEIGHT);

    panel.display();

    // Wait until the FBO has been resized to the new dimensions
    waitFor(() -> panel.getFBO() != null && panel.getFBO().getWidth() == 3 * WIDTH,
        "FBO width should be resized to " + (3 * WIDTH));

    // Then FBO is resized as well
    Assert.assertEquals(3 * WIDTH, panel.getFBO().getWidth());
    Assert.assertEquals(2 * HEIGHT, panel.getFBO().getHeight());


  }

  @Ignore("Not working in CLI yet (hanging, despite using surefire unlimited threads)")
  @Test
  public void whenPanelIsRendering_DisplayWillDoNothing() throws InterruptedException {
    // ThreadUtils.print();

    AtomicInteger countRenderQueries = new AtomicInteger();

    // Duration of freezing task
    int FREEZE_TASK_MS = 5000;

    int WAIT_FOR_DISPLAY_DISPATCH_MS = 500;

    TicToc t = new TicToc();

    PanamaGLFactory factory = PanamaGLFactory.select();

    System.out.println("FACTORY : " + factory);


    // ----------------------------------------------------------
    // Given an initialized panel with a test offscreen renderer
    // performing a long task

    OffscreenRenderer renderer = new OffscreenRenderer_macOS(factory, new FBOReader_AWT()) {

      // Customize rendering task so that it is very very long
      @Override
      protected Runnable getTask_renderGLToImage(GLCanvas drawable, GLEventListener listener,
          int width, int height) {
        return new Runnable() {
          @Override
          public void run() {

            countRenderQueries.incrementAndGet();

            System.out
                .println("Start freezing render for test - count = " + countRenderQueries.get());
            try {
              Thread.sleep(FREEZE_TASK_MS);
            } catch (InterruptedException e) {
              e.printStackTrace();
            }

            System.out.println("Done freezing render for test");

            t.tocShow("Elasped for counter " + countRenderQueries.get());

          }
        };
      }
    };
    renderer.setThreadRedirect(new ThreadRedirect_JFX());

    Canvas c = mock(Canvas.class);

    GLCanvasJFX panel = new GLCanvasJFX(factory, c);

    panel.setOffscreenRenderer(renderer);

    // -------------------------------
    // When it is added
    // panel.addNotify();

    // Then it is considered initialized but never
    // rendered yet
    Assert.assertTrue(panel.isInitialized());
    Assert.assertFalse(panel.isRendering());
    Assert.assertTrue(countRenderQueries.get() == 0);

    t.tic();

    // -------------------------------
    // When display() is invoked a first time

    panel.display();

    Assert.assertTrue(panel.isRendering());

    // wait few ms that the task is triggered to macos main thread
    Thread.sleep(WAIT_FOR_DISPLAY_DISPATCH_MS);
    System.out.println("Waited " + WAIT_FOR_DISPLAY_DISPATCH_MS + " ms");

    // the freezing task has started and increments its counter
    Assert.assertTrue(countRenderQueries.get() == 1);

    ThreadUtils.print();

    // -------------------------------
    // When display() is invoked again

    int N_DISPLAY_ATTEMPTS = 100;
    for (int i = 0; i < N_DISPLAY_ATTEMPTS; i++) {
      panel.display();
    }

    System.out.println("Tried to display " + N_DISPLAY_ATTEMPTS + " times");

    // wait few ms that the task is triggered to macos main thread
    Thread.sleep(WAIT_FOR_DISPLAY_DISPATCH_MS);
    System.out.println("Waited " + WAIT_FOR_DISPLAY_DISPATCH_MS + " ms");


    // Then : did not trigger any new display
    Assert.assertTrue(countRenderQueries.get() == 1);

    System.out.println("Finished test");

  }

  /**
   * Polls {@code condition} every {@link #WAIT_POLL_MS} ms until it returns {@code true} or
   * {@link #WAIT_TIMEOUT_MS} elapses, then fails with {@code failMessage}.
   * <p>
   * Use this instead of a fixed {@code Thread.sleep()} whenever the condition to wait for is
   * directly observable. It is faster on fast machines and robust on slow CI runners.
   */
  static void waitFor(BooleanSupplier condition, String failMessage) throws InterruptedException {
    long deadline = System.currentTimeMillis() + WAIT_TIMEOUT_MS;
    while (!condition.getAsBoolean()) {
      if (System.currentTimeMillis() >= deadline) {
        Assert.fail(failMessage + " (timeout after " + WAIT_TIMEOUT_MS + "ms)");
      }
      Thread.sleep(WAIT_POLL_MS);
    }
  }

}
