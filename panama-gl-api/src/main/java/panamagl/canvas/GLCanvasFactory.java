package panamagl.canvas;

import panamagl.GLCanvas;
import panamagl.factory.PanamaGLFactory;

public interface GLCanvasFactory {
  GLCanvas newCanvas(PanamaGLFactory factory);
}
