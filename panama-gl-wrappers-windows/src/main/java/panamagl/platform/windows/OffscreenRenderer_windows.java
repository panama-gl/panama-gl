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
package panamagl.platform.windows;

import panamagl.factory.PanamaGLFactory;
import panamagl.offscreen.AOffscreenRenderer;
import panamagl.offscreen.FBOReader;
import panamagl.offscreen.OffscreenRenderer;

// Now does not do anything else more than the abstract class
public class OffscreenRenderer_windows extends AOffscreenRenderer implements OffscreenRenderer{
  public OffscreenRenderer_windows(PanamaGLFactory factory, FBOReader reader) {
    super(factory, reader);
  }
  
  /*Win32.loadLibrary("C:\\Users\\Martin\\Dev\\jzy3d\\public\\panama-gl-bindings\\panama-gl-native-windows-jawt\\src\\main\\resources\\Win32.dll");
  int handle = Win32.getParentWindowHandle((Component)drawable);
  System.out.println("Parent window handle : " + handle);*/

  /*boolean GET_HANDLE_FOR_WGL = true;
  
  protected void initContext(GLCanvas drawable, GLEventListener listener) {
    if(!GET_HANDLE_FOR_WGL) {
      super.initContext(drawable, listener);
      return;
    }
    
    
    
    // ---------------
    Debug.debug(debug, "AOffscreenRenderer : initContext");

    // --------------------------------------
    // GL Context init
    //context = factory.newGLContext();

    context = new WGLContext_windows(false);
    
    
    if(context instanceof WGLContext_windows) {
      WGLContext_windows wglContext = (WGLContext_windows)context;
      //wglContext.setWindowHandle(handle);
      wglContext.init(true);
      wglContext.makeCurrent();
    }
    
    
    Debug.debug(debug, "PanamaGLFactory_windows : initContext : WGL done");
    
    Debug.debug(debug, "AOffscreenRenderer : initContext : Got GLContext : " + context);

    // --------------------------------------
    // OpenGL init
    this.gl = factory.newGL();
    GLError.checkAndThrow(gl);

    Debug.debug(debug, "AOffscreenRenderer : initContext : Got GL : " + gl);

    GLProfile profile = new GLProfile(gl);
    context.setProfile(profile);
    
    Debug.debug(debug, "AOffscreenRenderer : initContext : Got Profile : " + profile);
    


    // --------------------------------------
    // FBO init
    this.fbo = factory.newFBO(INIT_FBO_WIDTH, INIT_FBO_HEIGHT);
    this.fbo.prepare(gl);

    Debug.debug(debug, "AOffscreenRenderer : initContext : Got FBO : " + fbo);

    // --------------------------------------
    // Invoke GLEventListener.init(..)
    if (listener != null) {
      listener.init(gl);

      // Not needed, only needed if we use GLUT MAIN LOOP
      // glutContext.glutDisplayFunc(this::invokeDisplay);
    }

    // Mark as ready for display
    initialized = true;

  }*/
}
