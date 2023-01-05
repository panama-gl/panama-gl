package panamagl;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import panamagl.toolkits.swing.GLCanvasSwing;

/**
 * A naive animator to ease testing.
 * 
 * @author Martin Pernollet
 */
public class Animator {
  protected static int RETINAL_PERSISTENCE = 40;
  protected ExecutorService exec = Executors.newSingleThreadExecutor();
  protected int sleepTimeMs = RETINAL_PERSISTENCE; 
  protected boolean loop = true;
  protected GLAutoDrawable drawable;
  protected boolean adaptive = true;
  
  protected boolean yieldWhenDone = true;

  public Animator(GLAutoDrawable drawable) {
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
              adaptiveDisplayWithLock();
            } 
            else {
              drawable.display();
            }
            
            // Try to wait a bit before retrying to update display
            pause(sleepTimeMs);
            
            // Avoid flooding the CPU, let other thread work
            // ... but creates a very short blank panel when
            // the window is moved to a secondary screen so
            // keep this as an option
            if(yieldWhenDone)
              Thread.yield();
          }
        }
      }
    };
  }
  
  protected void pause(int mili) {
    try {
      Thread.sleep(mili);
    } catch (InterruptedException e) {
      e.printStackTrace();
      loop = false;
    }
  }

  
  protected void pauseNotifyWait(int mili) {
    Thread.currentThread().notifyAll();
    
    // Try to wait a bit before retrying to update display
    try {

      Thread.currentThread().wait(mili);
    }
    catch (InterruptedException e) {
      e.printStackTrace();
      loop = false;
    }
  }

  /** Query a drawable display if it is not currently rendering. */
  protected void adaptiveDisplayWithLock() {
    if(!drawable.isRendering()) {
      drawable.display();
    }
  }

  /** Query a drawable display if previous time or number of event is not diverging. */
  protected void adaptiveDisplayWithDerivative() {
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

  public boolean isAdaptive() {
    return adaptive;
  }

  public void setAdaptive(boolean adaptive) {
    this.adaptive = adaptive;
  }

  public boolean isYieldWhenDone() {
    return yieldWhenDone;
  }

  /** */
  public void setYieldWhenDone(boolean yieldWhenDone) {
    this.yieldWhenDone = yieldWhenDone;
  }
  
  
}
