package panamagl.os.linux;

import panamagl.AOffscreenRenderer;
import panamagl.GLAutoDrawable;
import panamagl.GLEventListener;
import panamagl.OffscreenRenderer;
import panamagl.factory.PanamaGLFactory;

public class OffscreenRenderer_linux extends AOffscreenRenderer implements OffscreenRenderer{
  public OffscreenRenderer_linux(PanamaGLFactory factory) {
    super(factory);
  }
  
  @Override
  public void onInit(GLAutoDrawable drawable, GLEventListener listener) {
    // MACOS
    //GLProfile.initSingleton();
    //OSXUtil.RunOnMainThread(true, false, getTask_initContext(listener));
    Runnable r = getTask_initContext(listener);
    r.run();
  }

  @Override
  public void onDisplay(GLAutoDrawable drawable, GLEventListener listener) {
    Runnable r = getTask_renderGLToImage(drawable, listener, drawable.getWidth(), drawable.getHeight());
    r.run();
  }

  @Override
  public void onResize(GLAutoDrawable drawable, GLEventListener listener, int x, int y, int width, int height) {
    Runnable r = getTask_renderGLToImage(drawable, listener, drawable.getWidth(), drawable.getHeight());
    r.run();
  }
}
