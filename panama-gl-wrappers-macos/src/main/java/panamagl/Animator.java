package panamagl;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/** A naive animator to ease testing.
 * 
 * 
 * @author Martin Pernollet
 */
public class Animator {
  protected ExecutorService exec = Executors.newSingleThreadExecutor();
  protected int sleepTimeMs = 41; // a bit more than 40ms, retinian persistance
  protected boolean loop = true;
  protected GLAutoDrawable drawable;
  
  

  public Animator(GLAutoDrawable drawable) {
    super();
    this.drawable = drawable;
  }

  public void start() {
    
    loop = true;
    
    exec.execute(new Runnable() {
      
      public void run() {
        while(loop) {
          
          // Don't try repainting if we did not initialized fully
          if(drawable.isVisible())
            drawable.display();
          
          
          try {
            Thread.sleep(sleepTimeMs);
          } catch (InterruptedException e) {
            e.printStackTrace();
            loop = false;
          }
        }
      }
    });
  }
  
  public void stop() {
    loop = false;
    //exec.shutdownNow();
  }

  public int getSleepTime() {
    return sleepTimeMs;
  }

  public void setSleepTime(int sleepTimeMs) {
    this.sleepTimeMs = sleepTimeMs;
  }
  
  

}
