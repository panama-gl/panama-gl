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

import java.lang.foreign.MemoryAddress;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.MemorySession;
import java.lang.foreign.SegmentAllocator;
import java.lang.foreign.ValueLayout;
import java.util.Arrays;
import cgl.macos.v10_15_7.cgl_h;
import panamagl.Debug;
import panamagl.opengl.AGLContext;
import panamagl.opengl.GLContext;

/**
 * The CGL API is a low-level, platform-independent API for creating, managing, and rendering 2D and
 * 3D graphics in macOS and other operating systems. It provides functions for creating and managing
 * graphics contexts, setting up rendering pipelines, and rendering 2D and 3D graphics.
 * 
 * <h2>Help on deadlocks</h2>
 * 
 * There are a few reasons why you might experience a deadlock when using FBO (Framebuffer Object)
 * offscreen rendering and opening a JPanel in a CGL (Core Graphics Library) context. Some possible
 * causes of this issue include:
 * 
 * <ul>
 * <li>Concurrent access to the CGL context: If multiple threads or processes are trying to access
 * the CGL context concurrently, it can cause a deadlock. To avoid this, you should use
 * synchronization mechanisms such as mutexes or semaphores to ensure that only one thread or
 * process is accessing the CGL context at a time.
 * <li>Incomplete initialization: If the CGL context or FBO offscreen rendering is not fully
 * initialized before the JPanel is opened, it can cause a deadlock. Make sure that all necessary
 * initialization steps have been completed before opening the JPanel.
 * <li>Incorrect use of locking and unlocking: The CGL context must be locked before it can be used
 * for rendering or other graphics operations, and unlocked when the operations are complete. If the
 * CGL context is not properly locked and unlocked, it can cause a deadlock. Make sure that the CGL
 * context is locked and unlocked correctly.
 * <li>Incorrect rendering order: If you are using multiple rendering contexts or FBOs, it is
 * important to render them in the correct order to avoid deadlocks. Make sure that you are
 * rendering the contexts or FBOs in the correct sequence to avoid deadlocks.
 * </ul>
 * It is difficult to say exactly what is causing a deadlock without more information about your
 * specific situation. If you are experiencing a deadlock when using FBO offscreen rendering and
 * opening a JPanel in a CGL context, you should try to identify the root cause by looking at the
 * code and debugging the issue.
 * 
 * <h2>Help on debugging</h2>
 * Hint : to debug this class, invoke a program using it with flag -Dopengl.cgl.macos.CGLContext
 *
 * 
 * @see CGLImpl.makeCurrent in JOGL
 *
 * @author Martin Pernollet
 */
public class CGLContext_macOS extends AGLContext implements GLContext {
  protected MemorySession scope;
  protected SegmentAllocator allocator;

  protected MemorySegment attribs;
  protected MemorySegment pixelFormat;
  protected MemorySegment context;

  protected boolean initialized = true;

  protected boolean debug = Debug.check(CGLContext_macOS.class);

  public CGLContext_macOS() {
    // Manually load CGL
    // System.load("/System/Library/Frameworks/GLUT.framework/Versions/Current/GLUT");
    System.load("/System/Library/Frameworks/GLUT.framework/Versions/Current/GLUT");

    // The segments created in this function will be destroyed
    // one the below scope and allocator are collected by GC.
    scope = MemorySession.openConfined();
    allocator = SegmentAllocator.newNativeArena(scope);
  }

  // https://stackoverflow.com/questions/11383510/setting-up-an-opengl-context-with-cgl-on-mac-os-x
  // https://developer.apple.com/library/archive/documentation/GraphicsImaging/Conceptual/OpenGL-MacProgGuide/opengl_offscreen/opengl_offscreen.html
  // http://renderingpipeline.com/2012/05/windowless-opengl-on-macos-x/
  @Override
  public synchronized void init() {
    MemorySegment npix = choosePixelFormat();

    createContext(npix);

    // makeCurrent();

    initialized = true;
  }
  
  @Override
  public boolean isInitialized() {
    return initialized;
  }


  public synchronized void makeCurrent() {
    lockContext();
    setCurrentContext();
  }

  public synchronized void release() {
    setCurrentContextZero();
    unlockContext();
  }


  /*
   * In the CGL API, a CGL context must be locked before it can be used for rendering or other
   * graphics operations. This is done using the CGLLockContext() function. If another thread or
   * process has already locked the context, CGLLockContext() will return error 10004, indicating
   * that the context is already locked and cannot be used.
   */
  public void lockContext() {
    int err = cgl_h.CGLLockContext(context);

    if (cgl_h.kCGLNoError() == err) {
      Debug.debug(debug, "CGLContext : lock : " + err + " = no error");

    } 
    else if(cgl_h.kCGLBadContext() == err) {
      System.err.println("Got CGL bad context error while locking context : " + err);
    }
    else {
      System.err.println("Got CGL error while locking context : " + err);
      // throw new RuntimeException("Got CGL error while locking context : " + err);
    }
  }


  public void unlockContext() {
    final int err2 = cgl_h.CGLUnlockContext(context);

    /*
     * Error 0x2714 is a common error that can occur while trying to unlock a CGL (Core Graphics
     * Library) context. It indicates that the CGL context is not locked, and cannot be unlocked.
     */
    if (cgl_h.kCGLBadContext() == err2) {
      System.err.println("CGL: Could not unlock context that is not locked : err 0x"
          + Integer.toHexString(err2) + " (" + err2 + ") : " + this);

    } else if (cgl_h.kCGLNoError() != err2) {
      System.err.println("CGL: Could not unlock context: err 0x" + Integer.toHexString(err2) + " ("
          + err2 + ") : " + this);
      // System.err.println("CGL : " + glut_h.gluGetString(err2));
    }
  }

  /*
   * CGLSetCurrentContext is a function in the CGL (Core Graphics Library) API that sets the current
   * graphics context for the calling thread. It is used to specify the graphics context that should
   * be used for rendering or other graphics operations in the current thread.
   */
  protected void setCurrentContext() {
    int err = cgl_h.CGLSetCurrentContext(context);

    if (cgl_h.kCGLNoError() == err) {
      Debug.debug(debug, "CGLContext : set current : " + err + " = no error");

    } else if (cgl_h.kCGLBadContext() == err) {
      System.err.println("CGLContext : set current : " + err
          + " = kCGLBadContext(). The specified context is invalid.");

    } else if (cgl_h.kCGLBadConnection() == err) {
      System.err.println("CGLContext : set current : " + err
          + " = kCGLBadConnection(). The specified context is not connected to a window or drawable.");

    } else {
      System.err.println("Got CGL error while setting context current : " + err);
      // throw new RuntimeException("Got CGL error while locking context : " + err);
    }
  }

  protected void setCurrentContextZero() {
    MemorySegment zero = allocator.allocateArray(ValueLayout.JAVA_INT, new int[1]);
    final int err = cgl_h.CGLSetCurrentContext(zero);
    if (cgl_h.kCGLNoError() != err) {
      System.err.println("CGL: Could not release current context: err 0x" + Integer.toHexString(err)
          + ": " + this);
    }
  }

  protected MemoryAddress getCurrentContext() {
    MemoryAddress currentContext = cgl_h.CGLGetCurrentContext();

    Debug.debug(debug, "CGLContext : Current context = " + currentContext.toRawLongValue());

    return currentContext;
  }

  public void createContext(MemorySegment npix) {
    MemorySegment c_share = allocator.allocateUtf8String("");

    context = allocator.allocateUtf8String("");
    cgl_h.CGLCreateContext(pixelFormat, c_share, context);

    Debug.debug(debug, "CGLContext : " + Arrays.toString(pixelFormat.toArray(ValueLayout.JAVA_INT)));
    Debug.debug(debug, "CGLContext : " + Arrays.toString(npix.toArray(ValueLayout.JAVA_INT)));
    Debug.debug(debug, "CGLContext : CREATED!!");
    

  }

  protected MemorySegment choosePixelFormat() {
    int[] at = new int[4];



    // The kCGLPFAAccelerated parameter is used to specify whether the pixel format object should be
    // created using hardware acceleration, which can improve the performance of graphics rendering.
    at[0] = cgl_h.kCGLPFAAccelerated();
    // The kCGLPFAOpenGLProfile parameter is used to specify the OpenGL profile that the pixel
    // format object should support.
    at[1] = cgl_h.kCGLPFAOpenGLProfile();
    at[2] = cgl_h.kCGLOGLPVersion_3_2_Core();
    at[3] = 0;

    attribs = allocator.allocateArray(ValueLayout.JAVA_INT, at);
    pixelFormat = allocator.allocateArray(ValueLayout.JAVA_INT, new int[1]);

    // int[] pixFormats = new int[1];
    MemorySegment npix = allocator.allocateArray(ValueLayout.JAVA_INT, new int[1]);

    cgl_h.CGLChoosePixelFormat(attribs, pixelFormat, npix);


    Debug.debug(debug, "CGLContext : CGLChoosePixelFormat attributes " + Arrays.toString(attribs.toArray(ValueLayout.JAVA_INT)));
    Debug.debug(debug, "CGLContext : CGLChoosePixelFormat format " + Arrays.toString(pixelFormat.toArray(ValueLayout.JAVA_INT)));
    Debug.debug(debug, "CGLContext : CGLChoosePixelFormat max number of sample per pixel "
        + Arrays.toString(npix.toArray(ValueLayout.JAVA_INT)));
    
    return npix;
  }

  @Override
  public synchronized void destroy() {
    cgl_h.CGLDestroyPixelFormat(pixelFormat);
    cgl_h.CGLDestroyContext(context);
    
    initialized = false;

    Debug.debug(debug, "CGLContext destroyed");

  }
}
