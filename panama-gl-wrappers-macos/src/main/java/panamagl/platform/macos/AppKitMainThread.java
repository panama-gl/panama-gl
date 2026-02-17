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

import java.lang.foreign.Arena;
import java.lang.foreign.FunctionDescriptor;
import java.lang.foreign.Linker;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.SymbolLookup;
import java.lang.foreign.ValueLayout;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Provides main thread detection and dispatch on macOS using only the Panama FFI — no JNI and
 * no native companion library required.
 *
 * <p>This is functionally equivalent to JOGL's {@code OSXUtil.IsMainThread()} and
 * {@code OSXUtil.RunOnMainThread()}, with the following advantages:
 * <ul>
 *   <li>No dependency on any external native library.</li>
 *   <li>Implemented entirely with the standard {@code java.lang.foreign} API (Panama FFI).</li>
 *   <li>Consistent with the rest of PanamaGL's approach of calling native APIs directly from Java.</li>
 * </ul>
 *
 * <p>Uses two macOS system APIs from {@code libSystem}:
 * <ul>
 *   <li>{@code pthread_main_np()} — returns 1 if the calling thread is the main POSIX thread.</li>
 *   <li>{@code dispatch_sync_f(queue, context, work)} — synchronously dispatches a C function
 *       pointer to a GCD queue and blocks until it completes.</li>
 * </ul>
 *
 * <h2>Important limitation</h2>
 *
 * {@link #runOnMainThread(Runnable)} uses {@code dispatch_sync_f} on the main dispatch queue.
 * This requires the main thread to be running a CFRunLoop or pumping its dispatch queue.
 * If the main thread is idle (e.g., {@code main()} has returned without entering a run loop),
 * the call will <b>deadlock</b>.
 *
 * <p>Calling {@code runOnMainThread} while already on the main thread is safe — the task is
 * executed directly to avoid deadlock.
 *
 * @author Martin Pernollet
 */
public class AppKitMainThread {

  // -----------------------------------------------------------------------
  // Native handles (resolved once at class load)
  // -----------------------------------------------------------------------

  private static final Linker LINKER = Linker.nativeLinker();

  private static final SymbolLookup LOOKUP =
      SymbolLookup.loaderLookup().or(LINKER.defaultLookup());

  /** {@code int pthread_main_np(void)} — returns non-zero if calling thread is the main thread. */
  private static final MethodHandle PTHREAD_MAIN_NP;

  /**
   * {@code void dispatch_sync_f(dispatch_queue_t queue, void *context,
   * void (*work)(void *context))} — synchronous dispatch to a GCD queue.
   */
  private static final MethodHandle DISPATCH_SYNC_F;

  /**
   * Pointer to {@code _dispatch_main_q}, the global main dispatch queue.
   * Equivalent to what {@code dispatch_get_main_queue()} returns (which is a macro
   * expanding to {@code &_dispatch_main_q}).
   */
  private static final MemorySegment MAIN_QUEUE;

  /**
   * Upcall stub for the work function: {@code void work(void *context)}.
   * When GCD calls this function pointer, it invokes {@link #workCallback(MemorySegment)}.
   */
  private static final MemorySegment WORK_STUB;

  /** The task currently being dispatched (guarded by {@link #dispatchLock}). */
  private static Runnable pendingTask;

  /**
   * Guards the GCD dispatch path (worker → main thread) so that only one worker thread
   * dispatches at a time. The main-thread inline path does NOT acquire this lock,
   * avoiding deadlock when a worker thread is blocked inside {@code dispatch_sync_f}
   * while the main thread needs to call {@code runOnMainThread}.
   */
  private static final ReentrantLock dispatchLock = new ReentrantLock();

  static {
    try {
      // -- pthread_main_np --
      PTHREAD_MAIN_NP = LINKER.downcallHandle(
          LOOKUP.find("pthread_main_np").orElseThrow(
              () -> new UnsatisfiedLinkError("pthread_main_np not found")),
          FunctionDescriptor.of(ValueLayout.JAVA_INT));

      // -- dispatch_sync_f --
      DISPATCH_SYNC_F = LINKER.downcallHandle(
          LOOKUP.find("dispatch_sync_f").orElseThrow(
              () -> new UnsatisfiedLinkError("dispatch_sync_f not found")),
          FunctionDescriptor.ofVoid(
              ValueLayout.ADDRESS,  // dispatch_queue_t
              ValueLayout.ADDRESS,  // void *context
              ValueLayout.ADDRESS   // void (*work)(void *)
          ));

      // -- main dispatch queue --
      MAIN_QUEUE = LOOKUP.find("_dispatch_main_q").orElseThrow(
          () -> new UnsatisfiedLinkError("_dispatch_main_q not found"));

      // -- upcall stub for the work function --
      MethodHandle callback = MethodHandles.lookup().findStatic(
          AppKitMainThread.class, "workCallback",
          MethodType.methodType(void.class, MemorySegment.class));

      WORK_STUB = LINKER.upcallStub(
          callback,
          FunctionDescriptor.ofVoid(ValueLayout.ADDRESS),
          Arena.global());

    } catch (NoSuchMethodException | IllegalAccessException e) {
      throw new ExceptionInInitializerError(e);
    }
  }

  // -----------------------------------------------------------------------
  // Public API
  // -----------------------------------------------------------------------

  /**
   * Returns {@code true} if the calling thread is the macOS main (AppKit) thread.
   */
  public static boolean isMainThread() {
    try {
      return (int) PTHREAD_MAIN_NP.invokeExact() != 0;
    } catch (Throwable t) {
      throw new RuntimeException("pthread_main_np() call failed", t);
    }
  }

  /**
   * Executes the given task on the macOS main thread and blocks until it completes.
   *
   * <p>If the calling thread is already the main thread, the task is executed directly
   * to avoid a deadlock (dispatching synchronously to the main queue from the main thread
   * would block forever).
   *
   * @param task the task to run on the main thread
   * @throws RuntimeException if the native dispatch call fails or the task throws
   */
  public static void runOnMainThread(Runnable task) {
    // Inline path: already on the main thread — run directly without any lock.
    // This avoids deadlock when a worker thread holds dispatchLock inside
    // dispatch_sync_f while the main thread also needs to run a task.
    if (isMainThread()) {
      task.run();
      return;
    }

    // GCD path: dispatch to the main queue from a worker thread.
    // The lock serializes concurrent worker dispatches so that pendingTask
    // is not overwritten between the assignment and the upcall.
    dispatchLock.lock();
    try {
      pendingTask = task;
      try {
        DISPATCH_SYNC_F.invokeExact(MAIN_QUEUE, MemorySegment.NULL, WORK_STUB);
      } catch (Throwable t) {
        throw new RuntimeException("dispatch_sync_f() call failed", t);
      } finally {
        pendingTask = null;
      }
    } finally {
      dispatchLock.unlock();
    }
  }

  // -----------------------------------------------------------------------
  // Upcall target (called from native code by GCD)
  // -----------------------------------------------------------------------

  /**
   * Called by GCD on the main thread via the upcall stub. Runs the pending task.
   */
  @SuppressWarnings("unused") // referenced via MethodHandle
  private static void workCallback(MemorySegment context) {
    Runnable r = pendingTask;
    if (r != null) {
      r.run();
    }
  }

  // -----------------------------------------------------------------------

  /** Prevent instantiation. */
  private AppKitMainThread() {}
}
