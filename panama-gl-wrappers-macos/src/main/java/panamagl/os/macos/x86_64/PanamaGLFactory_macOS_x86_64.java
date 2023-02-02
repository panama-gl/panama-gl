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
package panamagl.os.macos.x86_64;

import panamagl.Debug;
import panamagl.factory.PanamaGLFactory;
import panamagl.fbo.FBO;
import panamagl.opengl.GL;
import panamagl.opengl.GLContext;
import panamagl.os.Platform;
import panamagl.os.macos.APanamaGLFactory_macOS;

public class PanamaGLFactory_macOS_x86_64 extends APanamaGLFactory_macOS implements PanamaGLFactory {
  protected boolean debug = Debug.check(PanamaGLFactory_macOS_x86_64.class);
  
  protected CGLContext_macOS cglContext;
  protected GLUTContext_macOS glutContext;
  protected boolean useGLUT = true;
  protected boolean useCGL = false;

  public PanamaGLFactory_macOS_x86_64() {
	super();}
  
  @Override
  public boolean matches(Platform os) {
    return os.isMac();
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