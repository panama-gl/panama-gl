package panamagl.offscreen;

import panamagl.platform.macos.AppKitMainThread;

/**
 * Allows redirecting a task execution on macOS main thread, which is required for OpenGL
 * rendering tasks (e.g. when using GLUT).
 *
 * @author Martin Pernollet
 */
public class MacOSThreadRedirect implements ThreadRedirect {

  @Override
  public void run(Runnable runnable) {
    AppKitMainThread.runOnMainThread(runnable);
  }
}
