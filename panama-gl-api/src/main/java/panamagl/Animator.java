/*******************************************************************************
 * Copyright (c) 2022, 2023 Martin Pernollet & contributors.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301, USA
 *******************************************************************************/
package panamagl;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import panamagl.canvas.GLCanvas;
import panamagl.performance.RenderCounter;

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
  protected GLCanvas canvas;
  protected boolean adaptive = true;
  
  protected boolean yieldWhenDone = true;
  
  protected int loops = 0;

  public Animator(GLCanvas canvas) {
    this.canvas = canvas;
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
          if (canvas.isVisible()) {

            if (adaptive) {
              adaptiveDisplayWithLock();
            } 
            else {
              canvas.display();
            }
            
            // Try to wait a bit before retrying to update display
            pause(sleepTimeMs);
            
            // Avoid flooding the CPU, let other thread work
            // ... but creates a very short blank panel when
            // the window is moved to a secondary screen so
            // keep this as an option
            if(yieldWhenDone)
              Thread.yield();
            
            loops++;
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
    if(!canvas.isRendering()) {
      canvas.display();
    }
  }

  /** Query a drawable display if previous time or number of event is not diverging. */
  @Deprecated
  protected void adaptiveDisplayWithDerivative() {
    // Is it worth trying to display?
    RenderCounter counter = canvas.getMonitoring();

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
      canvas.display();
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

  public int getLoops() {
    return loops;
  }
}
