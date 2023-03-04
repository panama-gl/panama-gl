package panamagl.canvas;

import panamagl.GLCanvas;
import panamagl.factory.PanamaGLFactory;

public class AWTCanvasFactory implements GLCanvasFactory{
  @Override
  public GLCanvas newCanvas(PanamaGLFactory factory) {
    return new GLCanvasAWT(factory);
  }
}
