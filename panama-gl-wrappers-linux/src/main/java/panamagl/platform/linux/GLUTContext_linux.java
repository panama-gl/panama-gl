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
package panamagl.platform.linux;

import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import opengl.linux.NativeLibLoader;
import opengl.linux.x86.glutDisplayFunc$callback;
import opengl.linux.x86.glutIdleFunc$callback;
import opengl.linux.x86.glut_h;
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
public class GLUTContext_linux extends AGLContext implements GLContext {
  protected String windowName = "InvisiblePanamaGLWindowForGLContext";

  protected int initWidth = 1;
  protected int initHeight = 1;
  protected int initX = 0;
  protected int initY = 0;

  protected int windowHandle = -1;
  
  /** this is used to prevent multiple instance of
   * GLUTContext to run glutInit more than one time
   * in the life of a JVM. */
  protected static boolean hasInit = false; 

  public GLUTContext_linux() {
    super();
    
    NativeLibLoader.load();
    
    initArena();
  }
  
  /** Initialize GLUT and create a window */
  @Override
  public void init() {

    if(!hasInit) {
      MemorySegment argc = arena.allocate(ValueLayout.JAVA_INT, 1);
      glut_h.glutInit(argc, argc);
      hasInit = true;
    }
    
    glut_h.glutInitDisplayMode(glut_h.GLUT_DOUBLE() | glut_h.GLUT_RGBA() | glut_h.GLUT_DEPTH());
    glut_h.glutInitWindowSize(initWidth, initHeight);
    glut_h.glutInitWindowPosition(initX, initY);
    
    windowHandle = glut_h.glutCreateWindow(arena.allocateFrom(windowName));
    
    //System.out.println("WINDOW HANDLE :  " + windowHandle);
    
    // Hacky!! Use it while GLXContext is not working
    glut_h.glutHideWindow();

    // This dummy stub registration is required to get macOS onscreen rendering working
    // It will avoid error message
    // "GLUT Fatal Error: redisplay needed for window 1, but no display callback."
    glutDisplayFunc(GLUTContext_linux::dummy);

    initialized = true;
  }

  private static void dummy() {}
  
  @Override
  public void destroy() {
    if(windowHandle>=0) {
      glut_h.glutDestroyWindow(windowHandle);
      windowHandle = -1;
    }
    
    // do not scope.close() as it is implicit
    initialized = false;
  }

  protected void glutDisplayFunc(glutDisplayFunc$callback.Function fi) {
    MemorySegment displayStub = glutDisplayFunc$callback.allocate(fi, arena);
    glut_h.glutDisplayFunc(displayStub);
  }

  protected void glutIdleFunc(glutIdleFunc$callback.Function fi) {
    MemorySegment idleStub = glutIdleFunc$callback.allocate(fi, arena);
    glut_h.glutIdleFunc(idleStub);
  }
}
