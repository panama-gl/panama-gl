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
package panamagl.utils;
import java.util.HashMap;
import java.util.Map;

public class ThreadUtils {
  public static void main(String[] args) {
    listThreads();
    
    String name = "main";
    Thread t = getThreads(name);
    if(t!=null) {
      System.out.println("Found a thread with name : " + t.getName());
    }
    else {
      System.out.println("Did not find : " + name);
    }
  }


  protected static void listThreads() {
    // Walk up all the way to the root thread group
    ThreadGroup rootGroup = Thread.currentThread().getThreadGroup();
    ThreadGroup parent;
    while ((parent = rootGroup.getParent()) != null) {
      rootGroup = parent;
    }

    listThreads(rootGroup, "");
  }


  // List all threads and recursively list all subgroup
  public static void listThreads(ThreadGroup group, String indent) {
    System.out.println(indent + "Group[" + group.getName() + ":" + group.getClass() + "]");
    int nt = group.activeCount();
    Thread[] threads = new Thread[nt * 2 + 10]; // nt is not accurate
    nt = group.enumerate(threads, false);

    // List every thread in the group
    for (int i = 0; i < nt; i++) {
      Thread t = threads[i];
      System.out.println(indent + "  Thread[" + t.getName() + ":" + t.getClass() + "]");
    }

    // Recursively list all subgroups
    int ng = group.activeGroupCount();
    ThreadGroup[] groups = new ThreadGroup[ng * 2 + 10];
    ng = group.enumerate(groups, false);

    for (int i = 0; i < ng; i++) {
      listThreads(groups[i], indent + "  ");
    }
  }


  protected static Thread getThreads(String threadName) {
    // Walk up all the way to the root thread group
    ThreadGroup rootGroup = Thread.currentThread().getThreadGroup();
    ThreadGroup parent;
    while ((parent = rootGroup.getParent()) != null) {
      rootGroup = parent;
    }

    return getThreads(rootGroup, threadName);
  }


  // List all threads and recursively list all subgroup
  public static Thread getThreads(ThreadGroup group, String threadName) {
    int nt = group.activeCount();
    Thread[] threads = new Thread[nt * 2 + 10]; // nt is not accurate
    nt = group.enumerate(threads, false);

    // List every thread in the group
    for (int i = 0; i < nt; i++) {
      Thread t = threads[i];
      if (t.getName().equals(threadName)) {
        return t;
      }
      // System.out.println(indent + " Thread[" + t.getName() + ":" + t.getClass() + "]");
    }

    // Recursively list all subgroups
    int ng = group.activeGroupCount();
    ThreadGroup[] groups = new ThreadGroup[ng * 2 + 10];
    ng = group.enumerate(groups, false);

    for (int i = 0; i < ng; i++) {
      Thread t = getThreads(groups[i], threadName);
      if (t != null) {
        return t;
      }
    }
    return null;
  }
  
  
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
  @SuppressWarnings("deprecation")
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
