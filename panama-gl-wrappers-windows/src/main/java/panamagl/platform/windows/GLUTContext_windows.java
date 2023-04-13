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

  /** Initialize GLUT and create a window */
  @Override
  public void init() {
    init(true);
  }
  
  //static int glutInitDone = 0;

  /** Initialize GLUT if input arg is true, and create a window */
  public void init(boolean forceLoadGlut) {
    loadNativeLibraries();
    initScope();
    
    if (forceLoadGlut) {
      MemorySegment argc = allocator.allocate(ValueLayout.JAVA_INT, 0);
      
      freeglut_h.glutInit(argc, argc);
    }
    
    freeglut_h.glutInitDisplayMode(freeglut_h.GLUT_DOUBLE() | freeglut_h.GLUT_RGBA() | freeglut_h.GLUT_DEPTH());
    freeglut_h.glutInitWindowSize(initWidth, initHeight);
    freeglut_h.glutInitWindowPosition(initX, initY);
    
    windowHandle = freeglut_h.glutCreateWindow(allocator.allocateUtf8String(windowName));
    
    // Hacky!! Use it while WGLContext is not working
    freeglut_h.glutHideWindow();   
    //freeglut_h.glutIconifyWindow();
    
    //Addressable hnd = allocator.allocate(ValueLayout.JAVA_INT, windowHandle);
    //https://learn.microsoft.com/en-us/windows/win32/api/winuser/nf-winuser-showwindow
    //wgl_h.ShowWindow(hnd, 5);
    
    initialized = true;
  }

  protected void loadNativeLibraries() {
    System.loadLibrary("opengl32");
    System.loadLibrary("glu32");
    System.loadLibrary("freeglut");
    
    // To use ShowWindow()
    //System.loadLibrary("User32");

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

  protected void glutDisplayFunc(glutDisplayFunc$callback fi) {
    MemorySegment displayStub = glutDisplayFunc$callback.allocate(fi, scope);
    freeglut_h.glutDisplayFunc(displayStub);
  }

  protected void glutIdleFunc(glutIdleFunc$callback fi) {
    MemorySegment idleStub = glutIdleFunc$callback.allocate(fi, scope);
    freeglut_h.glutIdleFunc(idleStub);
  }
}
