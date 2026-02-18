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
package panamagl.platform.linux;



import panamagl.Debug;
import panamagl.factory.APanamaGLFactory;
import panamagl.offscreen.FBO;
import panamagl.offscreen.FBOReader;
import panamagl.offscreen.OffscreenRenderer;
import panamagl.opengl.GL;
import panamagl.opengl.GLContext;
import panamagl.platform.Platform;

public abstract class APanamaGLFactory_linux extends APanamaGLFactory {
  protected boolean debug = Debug.check(APanamaGLFactory_linux.class);

  protected GLXContext_linux glxContext;
  protected GLUTContext_linux glutContext;
  protected boolean useGLUT = false;

  public APanamaGLFactory_linux() {
    super();
  }

  @Override
  public abstract GL newGL();


  @Override
  public boolean matches(Platform os) {
    return os.isUnix();
  }

  @Override
  public OffscreenRenderer newOffscreenRenderer(FBOReader reader) {
    OffscreenRenderer_linux renderer = new OffscreenRenderer_linux(this, reader);
    if (getThreadRedirect() != null) {
      renderer.setThreadRedirect(getThreadRedirect());
    }
    return renderer;
  }

  @Override
  public FBO newFBO(int width, int height) {
    return new FBO_linux(width, height);
  }

  @Override
  public GLContext newGLContext() {

    // --------------------------------------
    // A GL Context with GLUT

    if (useGLUT) {
      glutContext = new GLUTContext_linux();
      glutContext.init(); // Linux VM seams to WANT full init
      Debug.debug(debug, "PanamaGLFactory_linux : initContext : GLUT done");

      return glutContext;
    }

    // --------------------------------------
    // A GL Context with GLX

    else {


      glxContext = new GLXContext_linux();
      glxContext.init();
      glxContext.makeCurrent();
      Debug.debug(debug, "PanamaGLFactory_linux : initContext : GLX done");

      return glxContext;
    }
  }

  @Override
  public void destroyContext() {
    // Clean up CGL context
    if (glxContext != null)
      glxContext.destroy();

    // Clean up GLUT context
    if (glutContext != null)
      glutContext.destroy();

  }

}
