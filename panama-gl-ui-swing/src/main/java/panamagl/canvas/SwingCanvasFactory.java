package panamagl.canvas;

import panamagl.GLCanvas;
import panamagl.factory.PanamaGLFactory;

public class SwingCanvasFactory implements GLCanvasFactory{
  @Override
  public GLCanvas newCanvas(PanamaGLFactory factory) {
    return new GLCanvasSwing(factory);
  }
}
