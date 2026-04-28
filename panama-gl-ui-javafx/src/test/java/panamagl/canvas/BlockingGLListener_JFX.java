package panamagl.canvas;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import javafx.application.Platform;
import panamagl.GLEventListener;
import panamagl.opengl.GL;

/**
 * JavaFX equivalent of {@code panamagl.canvas.BlockingGLListener} from the Swing module.
 *
 * <p>Used for tests where the unit test thread invokes a GUI method that in turn triggers
 * {@code init()}, {@code display()}, {@code reshape()}, {@code dispose()} on the JavaFX
 * Application Thread (different from the test thread). The latches let the test thread
 * block until each of these events has fired at least once.
 *
 * <p>{@link #resetLatches()} drains the JavaFX queue before swapping latches, analogous to
 * Swing's {@code EventQueue.invokeAndWait} — any stale render already in {@code Platform.runLater}
 * will run to completion and harmlessly {@code countDown()} the old latches rather than the new ones.
 */
public class BlockingGLListener_JFX implements GLEventListener {
  CountDownLatch initLatch = new CountDownLatch(1);
  CountDownLatch displayLatch = new CountDownLatch(1);
  CountDownLatch disposeLatch = new CountDownLatch(1);

  EventCounter counter = new EventCounter();


  public void resetLatches() throws InterruptedException {
    // Drain pending JFX tasks before swapping latches. Any stale render still in the
    // Platform.runLater queue will run now and countDown the *old* latches (already
    // at 0, no-op), not the new ones.
    if (!Platform.isFxApplicationThread()) {
      CountDownLatch drain = new CountDownLatch(1);
      Platform.runLater(drain::countDown);
      drain.await(5, TimeUnit.SECONDS);
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
    initLatch.countDown();
    counter.init++;
  }

  @Override
  public void display(GL gl) {
    displayLatch.countDown();
    counter.display++;
  }

  @Override
  public void reshape(GL gl, int x, int y, int width, int height) {
    counter.reshape++;
  }

  @Override
  public void dispose(GL gl) {
    disposeLatch.countDown();
    counter.dispose++;
  }

  public class EventCounter {
    public volatile int init = 0;
    public volatile int display = 0;
    public volatile int reshape = 0;
    public volatile int dispose = 0;
  }
}
