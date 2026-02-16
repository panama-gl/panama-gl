package panamagl.offscreen;

import com.jogamp.opengl.GLProfile;
import jogamp.nativewindow.macosx.OSXUtil;

/**
 * Allows redirecting a task execution on macOS main thread, which is required for OpenGL rendering tasks.
 *
 * When using {@code -XstartOnFirstThread}, the Java main thread IS the macOS main thread.
 * In that case, posting a blocking task to the main thread from the main thread would deadlock,
 * so we detect this situation and run the task directly.
 *
 * @author Martin Pernollet
 *
 */
public class MacOSThreadRedirect implements ThreadRedirect{
  boolean initialized = false;

  @Override
  public void run(Runnable runnable) {
    if(!initialized) {
      // required to be able to bind OSXUTil later
      GLProfile.initSingleton();
      initialized = true;
    }

    if(OSXUtil.IsMainThread()) {
      // Already on main thread (e.g. -XstartOnFirstThread), run directly to avoid deadlock
      runnable.run();
    } else {
      OSXUtil.RunOnMainThread(false, true, runnable);
    }
  }

}
