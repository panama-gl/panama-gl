package panamagl;
import java.util.HashMap;
import java.util.Map;

public class ThreadUtils {
  /**
   * Print all threads, their status and priority in console.
   * 
   * Statuses :
   * <ul>
   * <li>NEW: The thread has been created, but has not yet started.
   * <li>RUNNABLE: The thread is currently executing.
   * <li>BLOCKED: The thread is blocked and waiting for a monitor lock.
   * <li>WAITING: The thread is waiting indefinitely for another thread to perform a particular action.
   * <li>TIMED_WAITING: The thread is waiting for another thread to perform an action for up to a specified waiting time.
   * <li>TERMINATED: The thread has completed execution.
   * </ul>
   */
  public static void print() {
    //Runtime.getRuntime().
    
    Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
    
    Map<Long,Thread> ranked = new HashMap<>();
    for (Thread thread : allStackTraces.keySet()) {
      ranked.put(thread.getId(), thread);
    }

    System.out.println("---- THREADS -----------------------");
    
    for (Long threadId : ranked.keySet()) {
      Thread thread = ranked.get(threadId);
      
      if(thread.getStackTrace().length>0)      
        System.out.println("Thread[" + thread.getId()+ "]/" + thread.getPriority() + "\t: " + thread.getName() + "\t(is " + thread.getState() + ") " + thread.getStackTrace()[0].toString() );
      else
        System.out.println("Thread[" + thread.getId()+ "]/" + thread.getPriority() + "\t: " + thread.getName() + "\t(is " + thread.getState() + ") no stack");
    }
    System.out.println("-----------------------------------");


  }
}
