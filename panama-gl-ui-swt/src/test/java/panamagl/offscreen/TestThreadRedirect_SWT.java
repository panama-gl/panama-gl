package panamagl.offscreen;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.eclipse.swt.widgets.Display;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests for {@link ThreadRedirect_SWT}, mirroring the patterns of
 * {@code ThreadRedirect_JFX} and {@code AWTThreadRedirect}.
 */
public class TestThreadRedirect_SWT {

  Display display;

  @Before
  public void setup() {
    display = Display.getCurrent();
    if (display == null) {
      display = new Display();
    }
  }

  @After
  public void teardown() {
    if (display != null && !display.isDisposed()) {
      display.dispose();
    }
  }

  @Test
  public void run_executesRunnableFromDisplayThread() {
    // Given: we are on the display thread (test runs on main thread where Display was created)
    ThreadRedirect_SWT redirect = new ThreadRedirect_SWT(display);
    AtomicBoolean executed = new AtomicBoolean(false);

    // When
    redirect.run(() -> executed.set(true));

    // Then: executed synchronously since we are on the display thread
    Assert.assertTrue("Runnable should have been executed", executed.get());
  }

  @Test
  public void run_executesRunnableFromNonDisplayThread() throws InterruptedException {
    ThreadRedirect_SWT redirect = new ThreadRedirect_SWT(display);
    CountDownLatch latch = new CountDownLatch(1);
    AtomicBoolean executed = new AtomicBoolean(false);
    AtomicReference<Thread> executionThread = new AtomicReference<>();

    // When: run from a non-display thread
    Thread t = new Thread(() -> {
      redirect.run(() -> {
        executed.set(true);
        executionThread.set(Thread.currentThread());
        latch.countDown();
      });
    });
    t.start();

    // Process async events on display thread
    long deadline = System.currentTimeMillis() + 2000;
    while (!executed.get() && System.currentTimeMillis() < deadline) {
      if (!display.readAndDispatch()) {
        display.sleep();
      }
    }
    latch.await(2, TimeUnit.SECONDS);

    // Then: runnable was executed on the display thread
    Assert.assertTrue("Runnable should have been executed", executed.get());
    Assert.assertSame("Runnable should run on display thread",
        display.getThread(), executionThread.get());
  }

  @Test
  public void run_doesNothingWhenDisplayDisposed() {
    ThreadRedirect_SWT redirect = new ThreadRedirect_SWT(display);
    display.dispose();

    AtomicBoolean executed = new AtomicBoolean(false);

    // Should not throw
    redirect.run(() -> executed.set(true));

    Assert.assertFalse("Runnable should not execute on disposed display", executed.get());

    // Prevent teardown from re-disposing
    display = null;
  }

  @Test
  public void run_synchronousOnDisplayThread() {
    // Given: we are on the display thread
    ThreadRedirect_SWT redirect = new ThreadRedirect_SWT(display);

    // When: verify it runs synchronously (not async) when already on display thread
    StringBuilder order = new StringBuilder();
    redirect.run(() -> order.append("A"));
    order.append("B");

    // Then: A runs before B (synchronous)
    Assert.assertEquals("AB", order.toString());
  }
}
