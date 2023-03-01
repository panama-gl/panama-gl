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
import java.lang.foreign.MemorySession;
import java.lang.foreign.SegmentAllocator;
import java.lang.foreign.ValueLayout;
import opengl.ubuntu.v20.glutDisplayFunc$callback;
import opengl.ubuntu.v20.glutIdleFunc$callback;
import opengl.ubuntu.v20.glut_h;
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
  protected MemorySession scope;
  protected SegmentAllocator allocator;
  protected String windowName = "InvisiblePanamaGLWindowForGLContext";

  protected int initWidth = 100;
  protected int initHeight = 100;
  protected boolean initialized = true;


  /** Initialize GLUT and create a window */
  @Override
  public void init() {
    init(true);
  }

  /** Initialize GLUT if input arg is true, and create a window */
  public void init(boolean forceLoadGlut) {
    initScope();
    
    if (forceLoadGlut) {
      var argc = allocator.allocate(ValueLayout.JAVA_INT, 0);

      glut_h.glutInit(argc, argc);
    }
    glut_h.glutInitDisplayMode(glut_h.GLUT_DOUBLE() | glut_h.GLUT_RGBA() | glut_h.GLUT_DEPTH());

    glutInitWindowSize(initWidth, initHeight);

    glut_h.glutInitWindowPosition(-initWidth, -initHeight);
    glut_h.glutCreateWindow(allocator.allocateUtf8String(windowName));

    // This dummy stub registration is required to get macOS onscreen rendering working
    // It will avoid error message
    // "GLUT Fatal Error: redisplay needed for window 1, but no display callback."
    glutDisplayFunc(GLUTContext_linux::dummy);

    initialized = true;
  }

  private static void dummy() {}

  @Override
  public boolean isInitialized() {
    return initialized;
  }
  
  protected void initScope() {
    try {
      scope = MemorySession.openImplicit();
      allocator = SegmentAllocator.newNativeArena(scope);
      
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  
  @Override
  public void destroy() {
    // do not scope.close() as it is implicit
    initialized = false;
  }

  protected void glutDisplayFunc(glutDisplayFunc$callback fi) {
    MemorySegment displayStub = glutDisplayFunc$callback.allocate(fi, scope);
    glut_h.glutDisplayFunc(displayStub);
  }

  protected void glutIdleFunc(glutIdleFunc$callback fi) {
    MemorySegment idleStub = glutIdleFunc$callback.allocate(fi, scope);
    glut_h.glutIdleFunc(idleStub);

  }

  protected void glutInitWindowSize(int width, int height) {
    glut_h.glutInitWindowSize(width, height);
  }



}
