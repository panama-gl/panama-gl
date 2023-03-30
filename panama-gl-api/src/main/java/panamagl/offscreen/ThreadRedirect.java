package panamagl.offscreen;

/**
 * A {@link ThreadRedirect} allows to redirect a {@link Runnable} execution to a choosen thread.
 * 
 * This is used to customize which thread will execute OpenGL rendering tasks which differ among
 * platforms as well as windowing toolkits.
 * 
 * @author Martin Pernollet
 *
 */
public interface ThreadRedirect {
  void run(Runnable runnable);
}
