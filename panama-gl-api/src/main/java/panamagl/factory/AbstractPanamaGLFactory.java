package panamagl.factory;

import panamagl.GLAutoDrawable;
import panamagl.canvas.GLCanvasAWT;
import panamagl.canvas.GLCanvasSwing;
import panamagl.fbo.FBO;

public abstract class AbstractPanamaGLFactory implements PanamaGLFactory {

  @Override
  public GLAutoDrawable newCanvas(Class<? extends GLAutoDrawable> type) {
    if (type.equals(GLCanvasAWT.class)) {
      return new GLCanvasAWT(this);
    } else if (type.equals(GLCanvasSwing.class)) {
      return new GLCanvasSwing(this);
    }
    return null;
  }

  @Override
  public FBO newFBO(int width, int height) {
    return new FBO(width, height);
  }

}
