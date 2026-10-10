package panamagl.canvas;

import java.awt.EventQueue;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.CountDownLatch;
import panamagl.GLEventListener;
import panamagl.opengl.GL;

/**
 * This listener is used for tests where the unit test threads invokes a GUI component methods that
 * triggers init(), display(), resize(), dispose() that happens in the AWT thread, hence in a
 * different thread than the calling thread.
 */
public class BlockingGLListener implements GLEventListener {
  CountDownLatch initLatch = new CountDownLatch(1);
  CountDownLatch displayLatch = new CountDownLatch(1);
  CountDownLatch disposeLatch = new CountDownLatch(1);

  EventCounter counter = new EventCounter();


  public void resetLatches() throws InvocationTargetException, InterruptedException {
    // Drain all pending AWT tasks before swapping latches.
    // Any stale render still in the EventQueue will run now and countDown
    // the *old* latches (already at 0, no-op), not the new ones.
    if (!EventQueue.isDispatchThread()) {
      EventQueue.invokeAndWait(() -> {
      });
    }
    initLatch = new CountDownLatch(1);
    displayLatch = new CountDownLatch(1);
    disposeLatch = new CountDownLatch(1);
  }

  public void awaitInit() throws InterruptedException {
    initLatch.await();
  }

  public void awaitDisplay() throws InterruptedException {
    displayLatch.await();
  }

  public void awaitDispose() throws InterruptedException {
    disposeLatch.await();
  }

  public EventCounter getCounter() {
    return counter;
  }

  @Override
  public void init(GL gl) {
    // count before releasing the waiting thread, which then reads the counter
    counter.init++;
    initLatch.countDown();
  }

  @Override
  public void display(GL gl) {
    // count before releasing the waiting thread, which then reads the counter
    counter.display++;
    displayLatch.countDown();
  }

  @Override
  public void reshape(GL gl, int x, int y, int width, int height) {
    counter.reshape++;
  }

  @Override
  public void dispose(GL gl) {
    // count before releasing the waiting thread, which then reads the counter
    counter.dispose++;
    disposeLatch.countDown();
  }

  public class EventCounter {
    public volatile int init = 0;
    public volatile int display = 0;
    public volatile int reshape = 0;
    public volatile int dispose = 0;
  }
}
