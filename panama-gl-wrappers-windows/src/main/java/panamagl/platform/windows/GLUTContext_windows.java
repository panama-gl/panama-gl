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

import java.lang.foreign.MemorySegment;
import opengl.windows.gl_h;
import opengl.windows.glutDisplayFunc$callback;
import opengl.windows.glutIdleFunc$callback;
import panamagl.opengl.AGLContext;
import panamagl.opengl.GL;
import panamagl.opengl.GLContext;

/**
 * This GLUT {@link GLContext} initialize a GLUT offscreen context allowing to then invoke
 * {@link GL} methods.
 *
 * freeglut is loaded and glutInit invoked once per process by {@link GLUT_windows#init()}.
 * 
 * @author Martin Pernollet
 */
public class GLUTContext_windows extends AGLContext implements GLContext {
  protected String windowName = "InvisiblePanamaGLWindowForGLContext";

  protected int initWidth = 1;
  protected int initHeight = 1;
  protected int initX = Integer.MAX_VALUE;
  protected int initY = Integer.MAX_VALUE;

  protected int windowHandle = -1;

  public GLUTContext_windows() {
    NativeLibLoader_windows.load();
    
    initArena();
  }

  /** Initialize GLUT and create a window */
  @Override
  public void init() {
    
    GLUT_windows.init();
    
    gl_h.glutInitDisplayMode(gl_h.GLUT_DOUBLE() | gl_h.GLUT_RGBA() | gl_h.GLUT_DEPTH());
    gl_h.glutInitWindowSize(initWidth, initHeight);
    gl_h.glutInitWindowPosition(initX, initY);
    
    windowHandle = gl_h.glutCreateWindow(arena.allocateFrom(windowName));
    
    // Hacky!! Use it while WGLContext is not working
    gl_h.glutHideWindow();   
    //gl_h.glutIconifyWindow();
    
    //Addressable hnd = allocator.allocate(ValueLayout.JAVA_INT, windowHandle);
    //https://learn.microsoft.com/en-us/windows/win32/api/winuser/nf-winuser-showwindow
    //gl_h.ShowWindow(hnd, 5);
    
    initialized = true;
  }
  
  @Override
  public void destroy() {
    if(windowHandle>=0) {
      gl_h.glutDestroyWindow(windowHandle);
      windowHandle = -1;
    }
    
    // do not scope.close() as it is implicit
    initialized = false;
  }

  protected void glutDisplayFunc(glutDisplayFunc$callback.Function fi) {
    MemorySegment displayStub = glutDisplayFunc$callback.allocate(fi, arena);
    gl_h.glutDisplayFunc(displayStub);
  }

  protected void glutIdleFunc(glutIdleFunc$callback.Function fi) {
    MemorySegment idleStub = glutIdleFunc$callback.allocate(fi, arena);
    gl_h.glutIdleFunc(idleStub);
  }
}
