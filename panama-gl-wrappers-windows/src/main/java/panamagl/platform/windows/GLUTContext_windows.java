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
import java.lang.foreign.ValueLayout;
import freeglut.windows.x86.freeglut_h;
import freeglut.windows.x86.glutDisplayFunc$callback;
import freeglut.windows.x86.glutIdleFunc$callback;
import opengl.windows.NativeLibLoader;
import panamagl.opengl.AGLContext;
import panamagl.opengl.GL;
import panamagl.opengl.GLContext;

/**
 * This GLUT {@link GLContext} initialize a GLUT offscreen context allowing to then invoke
 * {@link GL} methods.
 *
 * NB : glutInit() should only be called once. In case part of the program invokes it, it is
 * possible to initialize the window without calling glutInit by instead calling
 * GLUTContext.init(false)
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
  

  /** this is used to prevent multiple instance of
   * GLUTContext to run glutInit more than one time
   * in the life of a JVM. */
  protected static boolean hasInit = false;
  
  public GLUTContext_windows() {
    NativeLibLoader.load();
    
    initArena();
  }

  /** Initialize GLUT and create a window */
  @Override
  public void init() {
    
    if (!hasInit) {
      MemorySegment argc = arena.allocate(ValueLayout.JAVA_INT, 1);
      freeglut_h.glutInit(argc, argc);
      hasInit = true;
    }
    
    freeglut_h.glutInitDisplayMode(freeglut_h.GLUT_DOUBLE() | freeglut_h.GLUT_RGBA() | freeglut_h.GLUT_DEPTH());
    freeglut_h.glutInitWindowSize(initWidth, initHeight);
    freeglut_h.glutInitWindowPosition(initX, initY);
    
    windowHandle = freeglut_h.glutCreateWindow(arena.allocateFrom(windowName));
    
    // Hacky!! Use it while WGLContext is not working
    freeglut_h.glutHideWindow();   
    //freeglut_h.glutIconifyWindow();
    
    //Addressable hnd = allocator.allocate(ValueLayout.JAVA_INT, windowHandle);
    //https://learn.microsoft.com/en-us/windows/win32/api/winuser/nf-winuser-showwindow
    //wgl_h.ShowWindow(hnd, 5);
    
    initialized = true;
  }
  
  @Override
  public void destroy() {
    if(windowHandle>=0) {
      freeglut_h.glutDestroyWindow(windowHandle);
      windowHandle = -1;
    }
    
    // do not scope.close() as it is implicit
    initialized = false;
  }

  protected void glutDisplayFunc(glutDisplayFunc$callback.Function fi) {
    MemorySegment displayStub = glutDisplayFunc$callback.allocate(fi, arena);
    freeglut_h.glutDisplayFunc(displayStub);
  }

  protected void glutIdleFunc(glutIdleFunc$callback.Function fi) {
    MemorySegment idleStub = glutIdleFunc$callback.allocate(fi, arena);
    freeglut_h.glutIdleFunc(idleStub);
  }
}
