package panamagl.offscreen;

public class NoRedirect implements ThreadRedirect{

  @Override
  public void run(Runnable runnable) {
    runnable.run();
  }

}
