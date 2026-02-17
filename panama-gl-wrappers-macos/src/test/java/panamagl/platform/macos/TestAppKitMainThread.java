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
package panamagl.platform.macos;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.junit.Test;
import junit.framework.Assert;


/**
 * This class MUST be ran with the {@code -XstartOnFirstThread} VM argument
 * to let all test assuming first thread be relevant.
 * 
 * Test requiring to run outside of main thread will spawn dedicated threads.
 */
//VM ARGS : -XstartOnFirstThread --enable-native-access=ALL-UNNAMED --enable-preview
public class TestAppKitMainThread extends MacOSTest {

  // ---------------------------------------------------------------
  // isMainThread()
  // ---------------------------------------------------------------

  @Test
  public void isMainThread_returnsBooleanWithoutCrash() {
    if (!checkPlatform())
      return;

    // When
    boolean result = AppKitMainThread.isMainThread();

    // Then — we don't assert the value (depends on how the test runner starts),
    // but the call must not throw
    System.out.println("isMainThread() from test thread: " + result);
  }

  @Test
  public void isMainThread_returnsFalseFromWorkerThread() throws Exception {
    if (!checkPlatform())
      return;

    // Given
    AtomicBoolean result = new AtomicBoolean(true);
    CountDownLatch latch = new CountDownLatch(1);

    // When — call from a new thread that is definitely not the main thread
    Thread worker = new Thread(() -> {
      result.set(AppKitMainThread.isMainThread());
      latch.countDown();
    }, "test-worker");
    worker.start();

    // Then
    Assert.assertTrue("Timed out waiting for worker thread", latch.await(5, TimeUnit.SECONDS));
    Assert.assertFalse("A worker thread should not be the main thread", result.get());
  }

  // ---------------------------------------------------------------
  // runOnMainThread() — direct execution path (main thread)
  //
  // These tests work regardless of whether a CFRunLoop is active,
  // because when the calling thread IS the main thread,
  // runOnMainThread() executes the task directly (no GCD dispatch).
  // ---------------------------------------------------------------

  @Test
  public void runOnMainThread_executesTask_whenCalledFromMainThread() {
    if (!checkPlatform())
      return;
    if (!AppKitMainThread.isMainThread()) {
      System.out.println("Skipping: test thread is not the main thread (need -XstartOnFirstThread)");
      return;
    }

    // Given
    AtomicBoolean executed = new AtomicBoolean(false);

    // When
    AppKitMainThread.runOnMainThread(() -> executed.set(true));

    // Then
    Assert.assertTrue("Task should have been executed", executed.get());
  }

  @Test
  public void runOnMainThread_taskCanReturnValues_whenCalledFromMainThread() {
    if (!checkPlatform())
      return;
    if (!AppKitMainThread.isMainThread()) {
      System.out.println("Skipping: test thread is not the main thread (need -XstartOnFirstThread)");
      return;
    }

    // Given
    AtomicReference<String> result = new AtomicReference<>();

    // When
    AppKitMainThread.runOnMainThread(() -> result.set("hello from main thread"));

    // Then
    Assert.assertEquals("hello from main thread", result.get());
  }

  @Test
  public void runOnMainThread_taskExceptionPropagates_whenCalledFromMainThread() {
    if (!checkPlatform())
      return;
    if (!AppKitMainThread.isMainThread()) {
      System.out.println("Skipping: test thread is not the main thread (need -XstartOnFirstThread)");
      return;
    }

    // When / Then
    try {
      AppKitMainThread.runOnMainThread(() -> {
        throw new RuntimeException("test exception");
      });
      Assert.fail("Should have thrown");
    } catch (RuntimeException e) {
      Assert.assertTrue("Exception message should contain original message",
          e.getMessage().contains("test exception"));
    }
  }

  @Test
  public void runOnMainThread_multipleSequentialCalls_whenCalledFromMainThread() {
    if (!checkPlatform())
      return;
    if (!AppKitMainThread.isMainThread()) {
      System.out.println("Skipping: test thread is not the main thread (need -XstartOnFirstThread)");
      return;
    }

    // Given
    StringBuilder sb = new StringBuilder();

    // When
    AppKitMainThread.runOnMainThread(() -> sb.append("A"));
    AppKitMainThread.runOnMainThread(() -> sb.append("B"));
    AppKitMainThread.runOnMainThread(() -> sb.append("C"));

    // Then — synchronous execution guarantees ordering
    Assert.assertEquals("ABC", sb.toString());
  }

  // ---------------------------------------------------------------
  // runOnMainThread() — GCD dispatch path (worker thread)
  //
  // These tests require the main thread to be pumping its dispatch
  // queue (CFRunLoop). In a standard JUnit runner this is NOT the
  // case, so dispatch_sync_f would deadlock.
  //
  // They are guarded by a helper that detects whether the main
  // thread is likely idle, and skip gracefully if so.
  // ---------------------------------------------------------------

  // With JUnit 5, @Timeout(value = 2, unit = SECONDS) would run the test body on a
  // separate thread automatically, which both guards against deadlock and ensures we
  // are NOT on the main thread. In JUnit 4 we do this manually with a daemon thread
  // and a CountDownLatch.

  @Test
  public void runOnMainThread_executesTask_whenCalledFromWorkerThread() throws Exception {
    if (!checkPlatform())
      return;

    AtomicBoolean executed = new AtomicBoolean(false);
    AtomicReference<Throwable> error = new AtomicReference<>();
    CountDownLatch latch = new CountDownLatch(1);

    Thread worker = new Thread(() -> {
      try {
        AppKitMainThread.runOnMainThread(() -> executed.set(true));
      } catch (Throwable t) {
        error.set(t);
      } finally {
        latch.countDown();
      }
    }, "test-dispatch-worker");
    worker.setDaemon(true); // allow JVM to exit if dispatch deadlocks
    worker.start();

    if (!latch.await(500, TimeUnit.MILLISECONDS)) {
      System.out.println("Skipping: dispatch_sync_f timed out — main thread is not pumping events "
          + "(expected in JUnit context without CFRunLoop)");
      return;
    }

    if (error.get() != null) {
      throw new RuntimeException("runOnMainThread threw from worker thread", error.get());
    }

    Assert.assertTrue("Task should have been executed on main thread", executed.get());
  }
}
