package panamagl.offscreen;

import java.awt.EventQueue;

/** 
 * Ensure the task is executed by the AWT Event Thread.
 * 
 * OpenGL being single threaded, we need to always perform rendering queries from the same UI thread.
 */
public class AWTThreadRedirect implements ThreadRedirect{

  @Override
  public void run(Runnable runnable) {
    // If we are already in AWT thread, just run
    if (EventQueue.isDispatchThread()) {
        runnable.run();
    }
    // Otherwise, push the request to AWT
    else {
      // On Windows and Linux, we need to 
      EventQueue.invokeLater(runnable);
      
      // The below code can fail
      /*try {
        EventQueue.invokeAndWait(r);
      } catch (InvocationTargetException | InterruptedException e) {
        throw new RuntimeException(e);
      } */     
    }
    
  }

}
