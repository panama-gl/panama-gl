/*******************************************************************************
 * Copyright (c) 2022, 2023 Martin Pernollet & contributors.
 *
 * This library is free software; you can redistribute it and/or modify it under the terms of the
 * GNU Lesser General Public License as published by the Free Software Foundation; either version
 * 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License along with this library;
 * if not, write to the Free Software Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA
 * 02110-1301, USA
 *******************************************************************************/
package panamagl.platform.macos;

import panamagl.Debug;
import panamagl.GLCanvas;
import panamagl.factory.APanamaGLFactory;
import panamagl.factory.PanamaGLFactory;
import panamagl.offscreen.FBO;
import panamagl.offscreen.FBOReader;
import panamagl.offscreen.OffscreenRenderer;
import panamagl.opengl.GL;
import panamagl.opengl.GLContext;
import panamagl.platform.Platform;

public abstract class APanamaGLFactory_macOS extends APanamaGLFactory {
  protected boolean debug = Debug.check(APanamaGLFactory_macOS.class, PanamaGLFactory.class);

  protected CGLContext_macOS cglContext;
  protected GLUTContext_macOS glutContext;
  protected boolean useGLUT = true;
  
  @Override
  public boolean matches(Platform os) {
    return os.isMac();
  }

  /**
   * Invoked by the {@link GLCanvas}, i.e. canvas that wishes to draw offscreen rendered image.
   * 
   * The offscreen renderer will initialize {@link GL}, {@link GLContext} and {@link FBO} instances
   * through this factory.
   */
  @Override
  public OffscreenRenderer newOffscreenRenderer(FBOReader reader) {
    return new OffscreenRenderer_macOS(this, reader);
  }

  @Override
  public FBO newFBO(int width, int height) {
    return new FBO_macOS(width, height);
  }

  @Override
  public GLContext newGLContext() {

    // --------------------------------------
    // A GL Context with GLUT
    
    if (useGLUT) {
      glutContext = new GLUTContext_macOS();
      glutContext.init(false); // do not init GLUT a second time
      Debug.debug(debug, "PanamaGLMacOSFactory : initContext : GLUT done");

      return glutContext;
    }
    
    // --------------------------------------
    // A GL Context with CGL
    
    else {
      cglContext = new CGLContext_macOS();
      cglContext.init();
      cglContext.makeCurrent();
      Debug.debug(debug, "PanamaGLMacOSFactory : initContext : CGL done");

      return cglContext;
    }
  }

  @Override
  public void destroyContext() {
    // Clean up CGL context
    if (cglContext != null)
      cglContext.destroy();

    // Clean up GLUT context
    if (glutContext != null)
      glutContext.destroy();

  }
}
