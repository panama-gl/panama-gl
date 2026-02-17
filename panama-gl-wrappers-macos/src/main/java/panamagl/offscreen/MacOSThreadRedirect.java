package panamagl.offscreen;

import panamagl.platform.macos.AppKitMainThread;

/**
 * Allows redirecting a task execution on macOS main thread, which is required for OpenGL
 * rendering tasks (e.g. when using GLUT).
 *
 * <p>Two implementations are available, selected via {@link #setUseJOGL(boolean)}:
 * <ul>
 *   <li><b>Panama (default)</b> — uses {@link AppKitMainThread}, which calls macOS system APIs
 *       directly through the Panama FFI. No external dependency required.</li>
 *   <li><b>JOGL</b> — uses {@code OSXUtil.RunOnMainThread()} from JOGL's native window library.
 *       Requires JOGL on the classpath.</li>
 * </ul>
 *
 * @author Martin Pernollet
 */
public class MacOSThreadRedirect implements ThreadRedirect {

  /** When {@code true}, delegate to JOGL's OSXUtil. When {@code false}, use Panama-based AppKitMainThread. */
  private boolean useJOGL = false;

  /** Tracks whether JOGL's GLProfile has been initialized (only relevant when {@code useJOGL == true}). */
  private boolean joglInitialized = false;

  public MacOSThreadRedirect() {}

  public MacOSThreadRedirect(boolean useJOGL) {
    this.useJOGL = useJOGL;
  }

  @Override
  public void run(Runnable runnable) {
    if (useJOGL) {
      runViaJOGL(runnable);
    } else {
      runViaPanama(runnable);
    }
  }

  // ---------------------------------------------------------------
  // Panama implementation (default)
  // ---------------------------------------------------------------

  protected void runViaPanama(Runnable runnable) {
    AppKitMainThread.runOnMainThread(runnable);
  }

  // ---------------------------------------------------------------
  // JOGL implementation (legacy)
  // ---------------------------------------------------------------

  protected void runViaJOGL(Runnable runnable) {
    if (!joglInitialized) {
      com.jogamp.opengl.GLProfile.initSingleton();
      joglInitialized = true;
    }

    if (jogamp.nativewindow.macosx.OSXUtil.IsMainThread()) {
      runnable.run();
    } else {
      jogamp.nativewindow.macosx.OSXUtil.RunOnMainThread(false, true, runnable);
    }
  }

  // ---------------------------------------------------------------
  // Configuration
  // ---------------------------------------------------------------

  public boolean isUseJOGL() {
    return useJOGL;
  }

  /**
   * Switch between JOGL-based and Panama-based main thread dispatch.
   *
   * @param useJOGL {@code true} to use JOGL's OSXUtil, {@code false} to use AppKitMainThread (Panama)
   */
  public void setUseJOGL(boolean useJOGL) {
    this.useJOGL = useJOGL;
  }
}
