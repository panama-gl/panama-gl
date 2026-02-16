package panamagl.offscreen;

import com.jogamp.opengl.GLProfile;
import jogamp.nativewindow.macosx.OSXUtil;

/**
 * Allows redirecting a task execution on macOS main thread, which is required for OpenGL rendering tasks.
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
