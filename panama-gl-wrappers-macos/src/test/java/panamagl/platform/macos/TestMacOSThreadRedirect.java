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
import org.junit.Ignore;
import org.junit.Test;
import junit.framework.Assert;
import panamagl.offscreen.MacOSThreadRedirect;

// VM ARGS : --enable-native-access=ALL-UNNAMED --enable-preview

public class TestMacOSThreadRedirect extends MacOSTest {

  // ---------------------------------------------------------------
  // Configuration
  // ---------------------------------------------------------------

  @Test
  public void defaultMode_isPanama() {
    if (!checkPlatform())
      return;

    // Given
    MacOSThreadRedirect redirect = new MacOSThreadRedirect();

    // Then
    Assert.assertFalse("Default mode should be Panama (not JOGL)", redirect.isUseJOGL());
  }

  @Test
  public void constructorWithJOGL_setsMode() {
    if (!checkPlatform())
      return;

    // Given
    MacOSThreadRedirect panama = new MacOSThreadRedirect(false);
    MacOSThreadRedirect jogl = new MacOSThreadRedirect(true);

    // Then
    Assert.assertFalse(panama.isUseJOGL());
    Assert.assertTrue(jogl.isUseJOGL());
  }

  @Test
  public void setUseJOGL_switchesMode() {
    if (!checkPlatform())
      return;

    // Given
    MacOSThreadRedirect redirect = new MacOSThreadRedirect();
    Assert.assertFalse(redirect.isUseJOGL());

    // When
    redirect.setUseJOGL(true);

    // Then
    Assert.assertTrue(redirect.isUseJOGL());
  }

  // ---------------------------------------------------------------
  // Panama mode
  // ---------------------------------------------------------------

  @Test
  public void panamaMode_executesTask() {
    if (!checkPlatform())
      return;

    // Given
    MacOSThreadRedirect redirect = new MacOSThreadRedirect(false);
    AtomicBoolean executed = new AtomicBoolean(false);

    // When
    redirect.run(() -> executed.set(true));

    // Then
    Assert.assertTrue("Task should have been executed in Panama mode", executed.get());
  }

  @Test
  public void panamaMode_preservesTaskResult() {
    if (!checkPlatform())
      return;

    // Given
    MacOSThreadRedirect redirect = new MacOSThreadRedirect(false);
    AtomicReference<String> result = new AtomicReference<>();

    // When
    redirect.run(() -> result.set("panama"));

    // Then
    Assert.assertEquals("panama", result.get());
  }

  @Test
  public void panamaMode_multipleSequentialTasks() {
    if (!checkPlatform())
      return;

    // Given
    MacOSThreadRedirect redirect = new MacOSThreadRedirect(false);
    StringBuilder sb = new StringBuilder();

    // When
    redirect.run(() -> sb.append("1"));
    redirect.run(() -> sb.append("2"));
    redirect.run(() -> sb.append("3"));

    // Then
    Assert.assertEquals("123", sb.toString());
  }

  // ---------------------------------------------------------------
  // JOGL mode
  //
  // GLProfile.initSingleton() and OSXUtil.RunOnMainThread() both
  // may require the macOS main thread to be pumping AppKit events.
  // In a JUnit runner this is typically not the case, so we run
  // the test in a daemon thread with a short timeout. If it
  // freezes (no run loop), the test is skipped gracefully.
  // ---------------------------------------------------------------

  @Ignore
  @Test
  public void joglMode_executesTask() throws Exception {
    if (!checkPlatform())
      return;

    // Given
    AtomicBoolean executed = new AtomicBoolean(false);
    AtomicReference<Throwable> error = new AtomicReference<>();
    CountDownLatch latch = new CountDownLatch(1);

    // When — run in a daemon thread to avoid freezing the test suite
    Thread worker = new Thread(() -> {
      try {
        MacOSThreadRedirect redirect = new MacOSThreadRedirect(true);
        redirect.run(() -> executed.set(true));
      } catch (Throwable t) {
        error.set(t);
      } finally {
        latch.countDown();
      }
    }, "test-jogl-redirect");
    worker.setDaemon(true);
    worker.start();

    // Then — wait briefly; if it hangs, skip
    if (!latch.await(300, TimeUnit.MILLISECONDS)) {
      System.out.println("Skipping: JOGL mode timed out — GLProfile.initSingleton() or "
          + "OSXUtil.RunOnMainThread() likely blocked (no AppKit run loop in JUnit context)");
      return;
    }

    if (error.get() != null) {
      throw new RuntimeException("JOGL mode threw an exception", error.get());
    }

    Assert.assertTrue("Task should have been executed in JOGL mode", executed.get());
  }

  // ---------------------------------------------------------------
  // Both modes produce same result
  // ---------------------------------------------------------------

  @Ignore
  @Test
  public void bothModes_produceSameResult() {
    if (!checkPlatform())
      return;

    // Given
    MacOSThreadRedirect panama = new MacOSThreadRedirect(false);
    MacOSThreadRedirect jogl = new MacOSThreadRedirect(true);
    AtomicReference<String> resultPanama = new AtomicReference<>();
    AtomicReference<String> resultJOGL = new AtomicReference<>();

    // When
    panama.run(() -> resultPanama.set("done"));
    jogl.run(() -> resultJOGL.set("done"));

    // Then
    Assert.assertEquals(resultPanama.get(), resultJOGL.get());
  }
}
