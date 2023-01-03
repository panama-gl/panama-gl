package panamagl;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * A naive animator to ease testing.
 * 
 * @author Martin Pernollet
 */
public class Animator {
  protected ExecutorService exec = Executors.newSingleThreadExecutor();
  protected int sleepTimeMs = 41; // a bit more than 40ms, retinian persistance
  protected boolean loop = true;
  protected GLAutoDrawable drawable;
  protected boolean adaptive = true;

  public Animator(GLAutoDrawable drawable) {
    super();
    this.drawable = drawable;
  }

  public void start() {
    loop = true;
    exec.execute(getRunnable());
  }

  protected Runnable getRunnable() {
    return new Runnable() {
      public void run() {
        while (loop) {

          // Don't try repainting if we did not initialized fully
          if (drawable.isVisible()) {

            if (adaptive) {
              // Is it worth trying to display?
              RenderCounter counter = drawable.getMonitoring();

              // If render time exceed sleep time
              if (counter.renderDriftDerivative() > 0) {
                // Skip rendering and simply reset derivative
                counter.updatePrevDiff();
              }

              // If render / update event diff is decreasing
              else if (counter.eventDiffDerivative() < 0) {
                // Skip rendering and simply reset derivative
                counter.updatePrevDiff();
              }
              // Otherwise, let's render
              else {
                drawable.display();
              }
            } else {
              drawable.display();

            }

            // Try to wait a bit before retrying to update display
            try {
              Thread.sleep(sleepTimeMs);
            } catch (InterruptedException e) {
              e.printStackTrace();
              loop = false;
            }
          }
        }
      }
    };
  }

  public void stop() {
    loop = false;
  }

  public int getSleepTime() {
    return sleepTimeMs;
  }

  public void setSleepTime(int sleepTimeMs) {
    this.sleepTimeMs = sleepTimeMs;
  }
}
