package opengl.demos.macos;

public class IdentifyMainThreadFromJava {
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

}

