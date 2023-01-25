package panamagl.os.macos;

import com.jogamp.opengl.GLProfile;
import jogamp.nativewindow.macosx.OSXUtil;
import panamagl.AOffscreenRenderer;
import panamagl.GLAutoDrawable;
import panamagl.GLEventListener;
import panamagl.OffscreenRenderer;
import panamagl.factory.PanamaGLFactory;

/**
 * This offscreen renderer is able to ensure that OpenGL queries are performed inside the main macOS thread.
 * 
 * @author Martin Pernollet
 */
public class OffscreenRenderer_macOS extends AOffscreenRenderer implements OffscreenRenderer{
  public OffscreenRenderer_macOS(PanamaGLFactory factory) {
    super(factory);
  }
  
  @Override
  public void onInit(GLAutoDrawable drawable, GLEventListener listener) {
    initContext_OnMainThread(listener);
    
  }

  @Override
  public void onDisplay(GLAutoDrawable drawable, GLEventListener listener) {
    // FIXME : why does it work with this
    renderGLToImage_OnMainThread(drawable, listener, drawable.getWidth(), drawable.getHeight(), false, true);
    // FIXME : and not with this?
    // renderGLToImage_OnMainThread(false, true);
    
  }

  @Override
  public void onResize(GLAutoDrawable drawable, GLEventListener listener, int x, int y, int width, int height) {
 // wait=true causes deadlocks! So we do not wait
    // and then ask the rendering to asynchronously notify
    // this panel that a repaint should occur.
    boolean wait = false;

    renderGLToImage_OnMainThread(drawable, listener, width, height, wait, true);

    // here we need a callback to invoke repaint, otherwise we are always one frame late!
    // if resize too fast, we see that we display the previous image.
    //
    // Hence, following method is useless
    // paintComponent(getGraphics());    
  }

  
  /* ===================================================== */
  // BELOW FUNC ALLOW EXECUTING IN APPKIT MAIN THREAD


  protected void renderGLToImage_OnMainThread(GLAutoDrawable drawable, GLEventListener listener, boolean waitUntilDone, boolean kickNSApp) {
    OSXUtil.RunOnMainThread(waitUntilDone, kickNSApp, getTask_renderGLToImage(drawable, listener));
  }


  protected void renderGLToImage_OnMainThread(GLAutoDrawable drawable, GLEventListener listener, int width, int height, boolean waitUntilDone,
      boolean kickNSApp) {
    OSXUtil.RunOnMainThread(waitUntilDone, kickNSApp, getTask_renderGLToImage(drawable, listener, width, height));
  }

  protected void initContext_OnMainThread(GLEventListener listener) {
    // ---------------------------------------------
    // THIS USAGE OF JOGL CLASS SEAMS TO WORK
    // TODO : port/include OSXUTil in panama

    GLProfile.initSingleton();
    OSXUtil.RunOnMainThread(true, false, getTask_initContext(listener));

    // ---------------------------------------------
    // Classical way we should follow
    /*
     * else { boolean direct = SwingUtilities.isEventDispatchThread();
     * 
     * if (direct) { System.out.println("GLPanel : direct init"); initContext(); }
     * 
     * // --------------------------------------------- else { final AtomicBoolean initialized = new
     * AtomicBoolean(false);
     * 
     * try { SwingUtilities.invokeAndWait(new Runnable() { public void run() { initContext();
     * initialized.set(true); } }); } catch (InvocationTargetException e) { // e.printStackTrace();
     * } catch (InterruptedException e) { // e.printStackTrace(); } }
     * 
     * }
     */
  }


}
