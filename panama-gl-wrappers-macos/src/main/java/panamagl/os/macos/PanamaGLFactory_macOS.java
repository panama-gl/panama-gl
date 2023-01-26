/*******************************************************************************
 * Copyright (c) 2022, 2023 Martin Pernollet & contributors.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301, USA
 *******************************************************************************/
package panamagl.os.macos;

import panamagl.Debug;
import panamagl.GLAutoDrawable;
import panamagl.OffscreenRenderer;
import panamagl.factory.APanamaGLFactory;
import panamagl.factory.PanamaGLFactory;
import panamagl.fbo.FBO;
import panamagl.opengl.GL;
import panamagl.opengl.GLContext;
import panamagl.os.OperatingSystem;

public class PanamaGLFactory_macOS extends APanamaGLFactory implements PanamaGLFactory {
  protected boolean debug = Debug.check(PanamaGLFactory_macOS.class);
  
  protected CGLContext_macOS cglContext;
  protected GLUTContext_macOS glutContext;
  protected boolean useGLUT = true;
  protected boolean useCGL = false;

  public PanamaGLFactory_macOS() {}
  
  @Override
  public boolean matches(OperatingSystem os) {
    return os.isMac();
  }

  /**
   * Invoked by the {@link GLAutoDrawable}, i.e. canvas that wishes to draw
   * offscreen rendered image.
   * 
   * The offscreen renderer will initialize {@link GL}, {@link GLContext} and {@link FBO_macOS} 
   * instances through this factory.
   */
  @Override
  public OffscreenRenderer newOffscreenRenderer() {
    return new OffscreenRenderer_macOS(this);
  }
  
  @Override
  public FBO newFBO(int width, int height) {
    return new FBO_macOS(width, height);
  }


  @Override
  public GL newGL() {
    return new GL_macOS();
  }

  @Override
  public GLContext newGLContext() {
    
 // --------------------------------------
    // A GL Context with CGL
    if (useCGL) {
      cglContext = new CGLContext_macOS();
      cglContext.init();
      Debug.debug(debug, "PanamaGLMacOSFactory : initContext : CGL done");
      
      return cglContext;
    }

    // --------------------------------------
    // A GL Context with GLUT
    // - hanging while ONSCREEN
    // - not generating FBO properly if omitted
    if (useGLUT) {
      glutContext = new GLUTContext_macOS();
      glutContext.init(false); // do not init GLUT a second time
      Debug.debug(debug, "PanamaGLMacOSFactory : initContext : GLUT done");
      
      return glutContext;
    }

    
    return null;
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
