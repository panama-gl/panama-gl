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

package panamagl.platform.macos;

import java.lang.foreign.MemoryAddress;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.MemorySession;
import java.lang.foreign.SegmentAllocator;
import java.lang.foreign.ValueLayout;
import java.util.Arrays;
import cgl.macos.x86.cgl_h;
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
 * 
 * <h2>Help on debugging</h2>
 * 
 * Hint : to debug this class, invoke a program using it with flag
 * -Danamagl.platform.macos.CGLContext_macOS
 *
 * @see https://developer.apple.com/library/archive/documentation/GraphicsImaging/Conceptual/OpenGL-MacProgGuide/opengl_pg_concepts/opengl_pg_concepts.html
 * @see CGLImpl.makeCurrent in JOGL
 *
 * @author Martin Pernollet
 */
public class CGLContext_macOS extends AGLContext implements GLContext {
  protected MemorySession scope;
  protected SegmentAllocator allocator;

  // I/O data for CGLChoosePixelFormat
  protected MemorySegment attribs; // input
  protected MemorySegment pixelFormat; // output
  protected MemorySegment numberOfPixels; // output

  // I/O data for CGLCreateContext
  protected MemorySegment context; // output

  // status
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
  public void init() {
    choosePixelFormat();

    createContext();

    // makeCurrent();

    initialized = true;
  }

  @Override
  public synchronized void destroy() {
    cgl_h.CGLDestroyPixelFormat(pixelFormat);
    cgl_h.CGLDestroyContext(context);

    initialized = false;

    Debug.debug(debug, "CGLContext destroyed");

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
   * that the context is already locked and cannot be used (kCGLBadContext).
   */
  public void lockContext() {
    int status = cgl_h.CGLLockContext(context);

    throwExceptionUponError("CGLContext.lockContext : ", status);
  }

  public void unlockContext() {
    final int status = cgl_h.CGLUnlockContext(context);

    throwExceptionUponError("CGLContext.unlockContext : ", status);
  }

  /*
   * CGLSetCurrentContext is a function in the CGL (Core Graphics Library) API that sets the current
   * graphics context for the calling thread. It is used to specify the graphics context that should
   * be used for rendering or other graphics operations in the current thread.
   */
  protected void setCurrentContext() {
    int status = cgl_h.CGLSetCurrentContext(context);

    throwExceptionUponError("CGLContext.setCurrentContext : ", status);
  }

  protected void setCurrentContextZero() {
    MemorySegment zero = allocator.allocateArray(ValueLayout.JAVA_INT, new int[1]);

    final int status = cgl_h.CGLSetCurrentContext(zero);

    throwExceptionUponError("CGLContext.setCurrentContextZero : ", status);
  }

  protected MemoryAddress getCurrentContext() {
    MemoryAddress currentContext = cgl_h.CGLGetCurrentContext();

    Debug.debug(debug, "CGLContext : Current context = " + currentContext.toRawLongValue());

    return currentContext;
  }

  // https://stackoverflow.com/questions/11383510/setting-up-an-opengl-context-with-cgl-on-mac-os-x

  /**
   * Create a context, assuming the pixel format
   * 
   * <h2>Errors</h2>
   * 
   * <h3>kCGLBadPixelFormat</h3>
   * 
   * There are several reasons why calling <code>CGLCreateContext</code> can trigger a
   * <code>kCGLBadPixelFormat</code> error. Here are some possible reasons:
   * <ul>
   * <li>The pixel format specified is not valid: Make sure that the pixel format you're passing to
   * <code>CGLCreateContext</code> is valid and supported by the system. You can use the
   * <code>CGLDescribePixelFormat</code> function to inspect the properties of a given pixel
   * format.</li>
   * <li>The pixel format specified is not compatible with the requested OpenGL profile: Make sure
   * that the OpenGL profile you're requesting is compatible with the pixel format you're using. For
   * example, if you're requesting a Core 3.2 OpenGL profile, you need to use a pixel format that
   * supports that profile version.</li>
   * <li>The requested OpenGL feature set is not compatible with the requested OpenGL profile: If
   * you're requesting a Core OpenGL profile, make sure that the OpenGL functions you're using are
   * compatible with that profile. For example, immediate-mode OpenGL functions such as
   * <code>glBegin</code> and <code>glEnd</code> are not supported in Core OpenGL profiles.</li>
   * <li>There is an OpenGL context conflict: Make sure that there are no other active OpenGL
   * contexts on the same thread or in the same application that could conflict with your
   * context.</li>
   * </ul>
   * 
   * <h3>kCGLBadCodeModule</h3>
   * 
   */
  protected void createContext() {
    Debug.debug(debug, "CGLContext : CGLCreateContext input pixel format : "
        + Arrays.toString(pixelFormat.toArray(ValueLayout.JAVA_INT)));
    Debug.debug(debug, "CGLContext : CGLCreateContext input npix : "
        + Arrays.toString(numberOfPixels.toArray(ValueLayout.JAVA_INT)));


    MemoryAddress c_share = cgl_h.__DARWIN_NULL();

    context = allocator.allocate(10000);
    //allocator.allocate(cgl_h.CGLContextObj, ??);

    int status = cgl_h.CGLCreateContext(pixelFormat, c_share, context);

    // Debug.debug(debug, "CGLContext : CGLCreateContext output : " + status);

    throwExceptionUponError("CGLContext.createContext : ", status);
  }

  /**
   * Configure pixel format attributes and retrieve pixel format and max number of sample per pixel.
   */
  protected void choosePixelFormat() {
    int[] at = new int[4];

    // The kCGLPFAAccelerated parameter is used to specify whether the pixel format object should be
    // created using hardware acceleration, which can improve the performance of graphics rendering.
    at[0] = cgl_h.kCGLPFAAcceleratedCompute();// cgl_h.kCGLPFAAccelerated();

    // The kCGLPFAOpenGLProfile parameter is used to specify the OpenGL profile that the pixel
    // format object should support.
    at[1] = cgl_h.kCGLPFAOpenGLProfile();
    at[2] = cgl_h.kCGLOGLPVersion_GL4_Core();

    // Ending the attributes
    at[3] = 0;

    
    // ANOTHER WAY
//    at = new int[3];
//    at[0] = cgl_h.kCGLPFAOpenGLProfile();
//    at[1] = cgl_h.kCGLOGLPVersion_GL3_Core();
//    at[2] = 0;
    

    // ANOTHER WAY OF CONFIGURING
    // at = new int[9];
    // at[0] = cgl_h.kCGLPFAOpenGLProfile();
    // at[1] = cgl_h.kCGLOGLPVersion_3_2_Core();
    // at[2] = cgl_h.kCGLPFAColorSize();
    // at[3] = 24;
    // at[4] = cgl_h.kCGLPFAAlphaSize();
    // at[5] = 8;
    // at[6] = cgl_h.kCGLPFADoubleBuffer();
    // at[7] = cgl_h.kCGLPFAAccelerated();
    // at[8] = 0;


    // NO REQUIREMENT
    // at = new int[1];


    // ANOTHER WAY OF CONFIGURING : INVALID
    // at = new int[13];
    // at[0] = cgl_h.kCGLPFAOpenGLProfile();
    // at[1] = cgl_h.kCGLOGLPVersion_3_2_Core();
    // at[2] = cgl_h.kCGLPFAColorSize();
    // at[3] = 24;
    // at[4] = cgl_h.kCGLPFAAlphaSize();
    // at[5] = 8;
    // at[6] = cgl_h.kCGLPFAAccelerated();
    // at[7] = cgl_h.kCGLPFAFullScreen();
    // at[8] = cgl_h.kCGLPFADoubleBuffer();
    // at[8] = cgl_h.kCGLPFASampleBuffers();
    // at[9] = 1;
    // at[10] = cgl_h.kCGLPFASamples();
    // at[11] = 4;
    // at[12] = 0;



    // Input : CGLPixelFormatAttribute
    attribs = allocator.allocateArray(ValueLayout.JAVA_INT, at);

    // Output : CGLPixelFormatObj
    pixelFormat = allocator.allocateArray(ValueLayout.JAVA_INT, new int[1]);

    // Output : GLint
    numberOfPixels = allocator.allocateArray(ValueLayout.JAVA_INT, new int[1]);

    // Invocation
    int status = cgl_h.CGLChoosePixelFormat(attribs, pixelFormat, numberOfPixels);

    // Logs
    Debug.debug(debug, "CGLContext : CGLChoosePixelFormat input : attributes "
        + Arrays.toString(attribs.toArray(ValueLayout.JAVA_INT)));
    Debug.debug(debug, "CGLContext : CGLChoosePixelFormat output : format "
        + Arrays.toString(pixelFormat.toArray(ValueLayout.JAVA_INT)));
    Debug.debug(debug, "CGLContext : CGLChoosePixelFormat output : max number of sample per pixel "
        + Arrays.toString(numberOfPixels.toArray(ValueLayout.JAVA_INT)));

    // Check status and throw exception if error
    throwExceptionUponError("CGLContext.choosePixelFormat : ", status);
  }



  /**
   * Check the status returned by CGL invocation and throw a runtime exception if not success
   */
  protected void throwExceptionUponError(String info, int status) {
    if (cgl_h.kCGLNoError() == status) {
      Debug.debug(debug, info + status + " = OK");

    } else if (cgl_h.kCGLBadAttribute() == status) {
      throw new RuntimeException(
          info + status + " = kCGLBadAttribute. The attributes are invalid.");

    } else if (cgl_h.kCGLBadProperty() == status) {
      throw new RuntimeException(info + status + " = kCGLBadProperty.");

    } else if (cgl_h.kCGLBadProperty() == status) {
      throw new RuntimeException(info + status + " = kCGLBadProperty.");

    } else if (cgl_h.kCGLBadPixelFormat() == status) {
      throw new RuntimeException(info + status + " = kCGLBadPixelFormat.");

    } else if (cgl_h.kCGLBadRendererInfo() == status) {
      throw new RuntimeException(info + status + " = kCGLBadRendererInfo.");

    } else if (cgl_h.kCGLBadProperty() == status) {
      throw new RuntimeException(info + status + " = kCGLBadProperty.");

    } else if (cgl_h.kCGLBadContext() == status) {
      throw new RuntimeException(info + status + " = kCGLBadContext. The context is invalid.");

    } else if (cgl_h.kCGLBadDrawable() == status) {
      throw new RuntimeException(info + status + " = kCGLBadDrawable.");

    } else if (cgl_h.kCGLBadDisplay() == status) {
      throw new RuntimeException(info + status + " = kCGLBadDisplay.");

    } else if (cgl_h.kCGLBadState() == status) {
      throw new RuntimeException(info + status + " = kCGLBadState.");

    } else if (cgl_h.kCGLBadValue() == status) {
      throw new RuntimeException(info + status + " = kCGLBadValue.");

    } else if (cgl_h.kCGLBadMatch() == status) {
      throw new RuntimeException(info + status + " = kCGLBadMatch.");

    } else if (cgl_h.kCGLBadEnumeration() == status) {
      throw new RuntimeException(info + status + " = kCGLBadEnumeration.");

    } else if (cgl_h.kCGLBadOffScreen() == status) {
      throw new RuntimeException(info + status + " = kCGLBadOffScreen.");

    } else if (cgl_h.kCGLBadFullScreen() == status) {
      throw new RuntimeException(info + status + " = kCGLBadFullScreen.");

    } else if (cgl_h.kCGLBadWindow() == status) {
      throw new RuntimeException(info + status + " = kCGLBadWindow.");

    } else if (cgl_h.kCGLBadAddress() == status) {
      throw new RuntimeException(info + status + " = kCGLBadAddress.");

    } else if (cgl_h.kCGLBadCodeModule() == status) {
      throw new RuntimeException(info + status + " = kCGLBadCodeModule.");

    } else if (cgl_h.kCGLBadAlloc() == status) {
      throw new RuntimeException(info + status + " = kCGLBadAlloc.");

    } else if (cgl_h.kCGLBadConnection() == status) {
      throw new RuntimeException(info + status
          + " = kCGLBadConnection. The context is not connected to a window or drawable.");
    } else {
      throw new RuntimeException(info + status + " = error");
    }
  }
}
