package panamagl.offscreen;

import com.jogamp.opengl.GLProfile;
import jogamp.nativewindow.macosx.OSXUtil;

/**
 * Allows redirecting a taks execution on macOS main thread, which is required for OpenGL rendering tasks.
 * 
 * @author Martin Pernollet
 *
 */
public class MacOSThreadRedirect implements ThreadRedirect{
  boolean initialized = false;
  
  @Override
  public void run(Runnable runnable) {
    if(!initialized) {
      GLProfile.initSingleton();
      initialized = true;
    }
    
    OSXUtil.RunOnMainThread(false, true, runnable);
  }

}
