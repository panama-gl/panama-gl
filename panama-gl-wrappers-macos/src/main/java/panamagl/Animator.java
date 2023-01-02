package panamagl;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/** A naive animator to ease testing. */
public class Animator {
  protected ExecutorService exec = Executors.newSingleThreadExecutor();
  protected int sleepTimeMs = 100;
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
  
  

}
