package panamagl.factory;

import panamagl.canvas.GLCanvasAWT;
import panamagl.canvas.GLCanvasSwing;

public abstract class APanamaGLFactory implements PanamaGLFactory {
  @Override
  public GLCanvasSwing newCanvasSwing() {
    return new GLCanvasSwing(this);
  }
  
  @Override
  public GLCanvasAWT newCanvasAWT() {
    return new GLCanvasAWT(this);
  }  
}
