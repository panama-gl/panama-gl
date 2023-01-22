package panamagl.factory;

import opengl.GL;
import opengl.GLContext;
import panamagl.GLAutoDrawable;
import panamagl.OffscreenRenderer;
import panamagl.fbo.FBO;
import panamagl.os.WindowingToolkit;

public interface PanamaGLFactory {


  GLAutoDrawable newCanvas(Class<? extends GLAutoDrawable> toolkit);

  GL newGL();

  GLContext newGLContext();

  FBO newFBO(int width, int height);

  OffscreenRenderer newOffscreenRenderer();

  void destroyContext();

}
