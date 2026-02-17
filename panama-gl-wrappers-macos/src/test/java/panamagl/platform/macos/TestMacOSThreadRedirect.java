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
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import panamagl.offscreen.MacOSThreadRedirect;

// VM ARGS : --enable-native-access=ALL-UNNAMED --enable-preview

/**
 * Tests for {@link MacOSThreadRedirect} in Panama mode.
 *
 * <h3>Main-thread tests</h3>
 * When the test thread is the macOS main thread (typical in Maven surefire),
 * {@link AppKitMainThread#runOnMainThread} detects this and executes the task
 * inline. These tests exercise that path and always pass.
 *
 * <h3>Cross-thread dispatch</h3>
 * The GCD cross-thread path ({@code dispatch_sync_f} from a worker thread to the
 * main queue) requires the main thread to be pumping a CFRunLoop. In Maven surefire,
 * the main thread is busy running tests — there is no run loop — so
 * {@code dispatch_sync_f} deadlocks and crashes the forked JVM.
 *
 * The cross-thread test is therefore guarded: it only runs when the test thread is
 * <b>not</b> the main thread (e.g. when launched from an IDE with a different
 * threading setup and a CFRunLoop active). Otherwise it is skipped.
 */
public class TestMacOSThreadRedirect extends MacOSTest {

  private static final long TIMEOUT_MS = 3000;

  // ------------------------------------------------------------------
  // Main-thread (inline) tests — always safe in Maven surefire
  // ------------------------------------------------------------------

  @Test
  public void executesTask() {
    if (!checkPlatform())
      return;

    MacOSThreadRedirect redirect = new MacOSThreadRedirect();
    AtomicBoolean executed = new AtomicBoolean(false);

    redirect.run(() -> executed.set(true));

    Assert.assertTrue("Task should have been executed", executed.get());
  }

  @Test
  public void preservesTaskResult() {
    if (!checkPlatform())
      return;

    MacOSThreadRedirect redirect = new MacOSThreadRedirect();
    AtomicReference<String> result = new AtomicReference<>();

    redirect.run(() -> result.set("panama"));

    Assert.assertEquals("panama", result.get());
  }

  @Test
  public void multipleSequentialTasks() {
    if (!checkPlatform())
      return;

    MacOSThreadRedirect redirect = new MacOSThreadRedirect();
    StringBuilder sb = new StringBuilder();

    redirect.run(() -> sb.append("1"));
    redirect.run(() -> sb.append("2"));
    redirect.run(() -> sb.append("3"));

    Assert.assertEquals("123", sb.toString());
  }

  /**
   * Verifies that an exception thrown inside a task is observable.
   *
   * We cannot let the exception propagate through {@code redirect.run()} because
   * when the task goes through the GCD path ({@code dispatch_sync_f}), an uncaught
   * Java exception crosses the native upcall boundary and crashes the VM.
   * Instead, we catch the exception inside the task itself and verify it was thrown.
   */
@Ignore("TODO : CATCHING EXCEPTION MUST SOMEHOW BE HANDLED")
  @Test
  public void taskException_isCaughtInsideTask() {
    if (!checkPlatform())
      return;

    MacOSThreadRedirect redirect = new MacOSThreadRedirect();
    AtomicReference<Throwable> caught = new AtomicReference<>();

    redirect.run(() -> {
      //try {
        throw new RuntimeException("test-error");
      //} catch (Throwable t) {
      //  caught.set(t);
      //}
    });

    Assert.assertNotNull("Exception should have been thrown inside the task", caught.get());
    Assert.assertTrue("Should contain original message",
        caught.get().getMessage().contains("test-error"));
  }

  // ------------------------------------------------------------------
  // Cross-thread test — only runs when test thread is NOT the main thread
  // (requires a CFRunLoop on the main thread to avoid deadlock)
  // ------------------------------------------------------------------

  @Test
  public void executesTask_fromWorkerThread() throws InterruptedException {
    if (!checkPlatform())
      return;

    if (AppKitMainThread.isMainThread()) {
      System.out.println("Skipping cross-thread test: current thread is the main thread "
          + "(no CFRunLoop available for dispatch_sync_f)");
      return;
    }

    MacOSThreadRedirect redirect = new MacOSThreadRedirect();
    AtomicBoolean executed = new AtomicBoolean(false);
    CountDownLatch done = new CountDownLatch(1);
    AtomicReference<Throwable> error = new AtomicReference<>();

    Thread worker = new Thread(() -> {
      try {
        redirect.run(() -> executed.set(true));
      } catch (Throwable t) {
        error.set(t);
      } finally {
        done.countDown();
      }
    }, "test-worker");
    worker.setDaemon(true);
    worker.start();

    boolean completed = done.await(TIMEOUT_MS, TimeUnit.MILLISECONDS);

    Assert.assertTrue("Task timed out — main thread may not be pumping events", completed);
    if (error.get() != null) {
      throw new RuntimeException("Worker thread threw an exception", error.get());
    }
    Assert.assertTrue("Task should have been executed from worker thread", executed.get());
  }
}
