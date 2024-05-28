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


import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import java.util.Arrays;
import cgl.macos.arm.cgl_h;
import opengl.macos.NativeLibLoader;
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
 * Use the Console app and select system.log
 *
 * @see https://developer.apple.com/library/archive/documentation/GraphicsImaging/Conceptual/OpenGL-MacProgGuide/opengl_pg_concepts/opengl_pg_concepts.html
 * @see CGLImpl.makeCurrent in JOGL
 *
 * @author Martin Pernollet
 */
public class CGLContext_macOS extends AGLContext implements GLContext {
  // I/O data for CGLChoosePixelFormat
  protected MemorySegment attribs; // input
  protected MemorySegment pixelFormat; // output
  protected MemorySegment numberOfPixels; // output

  protected int pixelFormatLength = 0;
  protected int contextArraySize = 2; // seams to be 2

  // I/O data for CGLCreateContext
  protected MemorySegment context; // output

  protected boolean debug = Debug.check(CGLContext_macOS.class);

  public CGLContext_macOS() {
    NativeLibLoader.load();

    initArena();
  }

  // https://stackoverflow.com/questions/11383510/setting-up-an-opengl-context-with-cgl-on-mac-os-x
  // https://developer.apple.com/library/archive/documentation/GraphicsImaging/Conceptual/OpenGL-MacProgGuide/opengl_offscreen/opengl_offscreen.html
  // http://renderingpipeline.com/2012/05/windowless-opengl-on-macos-x/
  @Override
  public void init() {
    choosePixelFormat();

    context = createContext();

    initialized = true;
    
    Debug.debug(debug, "CGLContext : initialized");
  }

  @Override
  public void destroy() {
    setCurrentContextZero();
    destroyContext(context);

    initialized = false;

    Debug.debug(debug, "CGLContext : destroyed");
  }

  public void makeCurrent() {
    /*
     * CGLContextObj contextToLock = ...; // context handle to lock CGLContextObj currentContext =
     * CGLGetCurrentContext(); // get the current context handle
     * 
     * if (contextToLock == NULL || currentContext == NULL) { // context handles are invalid //
     * handle error accordingly } else if (contextToLock == currentContext) { // context is valid
     * and can be locked CGLError error = CGLLockContext(contextToLock); if (error != kCGLNoError) {
     * // handle locking error accordingly } } else { // context is not the current context //
     * handle error accordingly }
     */

    // MemoryAddress currentContext = getCurrentContext();
    // Debug.debug("Current context : " + currentContext);

    setCurrentContext(context);
  }

  public void release() {
    releaseContext(context);
  }

  // -------------------------------------------------------------------------------------

  /**
   * Create a context, assuming the pixel attributes and format have already been defined.
   * 
   * The context is supposed to valid when the function returns since errors are checked. Any error
   * is thrown as a RuntimeException. Possible source of errors are clarified below.
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
   * The kCGLBadCodeModule error that you're getting when calling CGLCreateContext usually indicates
   * that there's a problem with the graphics driver or framework that you're using. Here are some
   * possible reasons why you might be seeing this error:
   * <ul>
   * <li>Incorrect graphics driver or framework installation: Make sure that you have the correct
   * graphics driver and framework installed on your system. If you're using an external graphics
   * card, make sure that the driver for that card is installed and up-to-date.</li>
   * <li>Incompatible graphics driver or framework: Make sure that the graphics driver or framework
   * you're using is compatible with your system and the version of macOS you're running.</li>
   * <li>Corrupt graphics driver or framework: If the graphics driver or framework installation is
   * corrupt, it can cause issues when creating an OpenGL context. Try reinstalling the graphics
   * driver or framework to see if that resolves the issue.</li>
   * <li>Conflicting third-party software: Some third-party software can interfere with the graphics
   * driver or framework and cause issues when creating an OpenGL context. Try disabling any
   * third-party software that might be causing conflicts.</li>
   * </ul>
   * 
   * <h2>SUPPOSED DATA STRUCTURE</h2>
   * 
   * A CGLContext is a data structure in macOS's Core Graphics framework that represents an OpenGL
   * rendering context. It is used to manage and execute OpenGL commands within a particular
   * graphics context. The CGLContext data structure is defined in the CGLTypes.h header file and
   * contains the following fields:
   * <ul>
   * <li>CGLError error: An error code that indicates whether any errors have occurred in the
   * context.
   * <li>CGLPixelFormatObj pixelFormat: A reference to a CGLPixelFormat object that describes the
   * attributes of the pixel format for the context.
   * <li>CGLShareGroupObj shareGroup: A reference to a CGLShareGroup object that provides a
   * mechanism for sharing OpenGL objects and resources between contexts.
   * <li>void* contextID: A platform-specific identifier for the context that is used by the
   * underlying graphics system to manage and execute OpenGL commands.
   * <li>CGLContextObj prev: A reference to the previous context in a linked list of contexts.
   * <li>CGLContextObj next: A reference to the next context in the linked list.
   * <li>void* reserved: A reserved field for future use.
   * </ul>
   * Overall, the CGLContext data structure provides a way to encapsulate and manage the state of an
   * OpenGL rendering context, including the pixel format, sharing resources, and the context
   * itself.
   */
  protected MemorySegment createContext() {

    // Inspect pixel format
    boolean inspect = false;
    if (inspect) {

      // Log the pixel format configuration before creating context
      Debug.debug(debug, "CGLContext : CGLCreateContext input pixel format : "
          + Arrays.toString(pixelFormat.toArray(ValueLayout.JAVA_INT)));
      Debug.debug(debug, "CGLContext : CGLCreateContext input npix : "
          + Arrays.toString(numberOfPixels.toArray(ValueLayout.JAVA_INT)));


      int v1 = describePixelFormat(attribs, cgl_h.kCGLPFAOpenGLProfile(), pixelFormatLength);
      System.out.println("kCGLPFAOpenGLProfile : " + v1);
      int v2 = describePixelFormat(attribs, cgl_h.kCGLPFAColorSize(), pixelFormatLength);
      System.out.println("kCGLPFAColorSize : " + v2);
    }

    MemorySegment c_share = cgl_h.__DARWIN_NULL();

    // The CGL context seams to be described by an array of 2 ints / 1 long
    MemorySegment context = arena.allocate(contextArraySize * 4);
    // allocator.allocate(cgl_h.CGLContextObj, ??);


    // WARNING : most example online give pixelFormat as first argument, which always
    // fail in our case. However, we experimentally noticed that attribs allow
    // initializing a context with OK status, with a retrievable array with
    // not only zero values.

    int status = cgl_h.CGLCreateContext(attribs, c_share, context);
    // int status = cgl_h.CGLCreateContext(pixelFormat, c_share, context);

    // TODO : should this be INT or LONG?
    int[] contextArray = context.toArray(ValueLayout.JAVA_INT);
    Debug.debug(debug, "CGLContext : CGLCreateContext output : " + Arrays.toString(contextArray));

    throwExceptionUponError("CGLContext.createContext : ", status);

    // Destroy pixel format
    status = cgl_h.CGLDestroyPixelFormat(pixelFormat);
    throwExceptionUponError("CGLDestroyPixelFormat : ", status);

    // context.


    // Do we need to unreference the context value?
    // MemoryAddress a = context.get(ValueLayout.ADDRESS, 0);
    // MemorySegment tc = MemorySegment.ofAddress(a, 8, scope);
    // System.out.println(Arrays.toString(tc.toArray(ValueLayout.JAVA_INT)));
    // context = tc;

    return context;
  }

  /**
   * CGLDestroyContext is used to destroy an OpenGL rendering context created with CGLCreateContext.
   * 
   * <h2>Errors</h2>
   * 
   * When CGLDestroyContext returns a kCGLBadContext error code, it means that the context provided
   * to CGLDestroyContext is not a valid OpenGL rendering context.
   * 
   * There are several possible reasons why CGLDestroyContext might return a kCGLBadContext error
   * code. Some of the common ones are:
   * <ul>
   * <li>The context was not created with CGLCreateContext.
   * <li>The context has already been destroyed.
   * <li>The context was created on a different thread.
   * <li>The OpenGL driver encountered an error.
   * </ul>
   * To diagnose the specific cause of the kCGLBadContext error code, you may need to consult the
   * macOS system logs (Console app).
   */
  protected void destroyContext(MemorySegment context) {
    int s = cgl_h.CGLDestroyContext(context);

    throwExceptionUponError("CGLDestroyContext : ", s);
  }

  // -------------------------------------------------------------------------------------

  /**
   * In the CGL API, a CGL context must be locked before it can be used for rendering or other
   * graphics operations. This is done using the CGLLockContext() function.
   * 
   * <h2>Errors</h2>
   * 
   * The kCGLBadContext error can be generated by the CGLLockContext function in the following
   * scenarios:
   * <ul>
   * <li>Invalid context handle: The CGLLockContext function requires a valid context handle to lock
   * the context for rendering. If the handle is not valid or has been deallocated, the function
   * returns the kCGLBadContext error.
   * <li>Context not current: The function requires that the context specified by the context handle
   * is the current context. 
   * <li>Context already locked.
   * <li>Thread not owner: CGLLockContext can be called from any thread, but only the thread that
   * locks the context can make GL calls to that context. If a thread other than the one that locked
   * the context attempts to make a GL call, then the function returns the kCGLBadContext error.
   * <li>Graphics hardware issue: A kCGLBadContext error can also be caused by a graphics hardware
   * issue, such as a driver error or a failure to allocate memory on the GPU.
   * </ul>
   */
  protected void lockContext(MemorySegment context) {
    System.out.println("CONTEXT : " + context.getAtIndex(ValueLayout.JAVA_INT, 0));
    int status = cgl_h.CGLLockContext(context);

    throwExceptionUponError("CGLContext.lockContext : ", status);
  }

  protected void unlockContext(MemorySegment context) {
    final int status = cgl_h.CGLUnlockContext(context);

    throwExceptionUponError("CGLContext.unlockContext : ", status);
  }

  // -------------------------------------------------------------------------------------

  /*
   * CGLSetCurrentContext is a function in the CGL (Core Graphics Library) API that sets the current
   * graphics context for the calling thread. It is used to specify the graphics context that should
   * be used for rendering or other graphics operations in the current thread.
   */
  protected void setCurrentContext(MemorySegment context) {
    int status = cgl_h.CGLSetCurrentContext(context);

    throwExceptionUponError("CGLContext.setCurrentContext : " + context, status);
  }

  protected void setCurrentContextZero() {
    setCurrentContext(cgl_h.__DARWIN_NULL());
  }

  protected MemorySegment getCurrentContext() {
	MemorySegment currentContext = cgl_h.CGLGetCurrentContext();

    Debug.debug(debug, "CGLContext : Current context = " + currentContext.toString());

    return currentContext;
  }

  protected void releaseContext(MemorySegment context) {
    cgl_h.CGLReleaseContext(context);
  }

  // -------------------------------------------------------------------------------------

  /**
   * Configure pixel format attributes and retrieve pixel format and max number of sample per pixel.
   * 
   * Signature of <code>CGLChoosePixelFormat</code> used in this implementation :
   * 
   * <ul>
   * <li>attribs: A pointer to an array of integers representing the attributes that you want to
   * specify for the pixel format. The array should be terminated with a value of 0 to indicate the
   * end of the attribute list. You can find a full list of pixel format attributes in the
   * CGLPixelFormat.h header file.
   * <li>pix: A pointer to a CGLPixelFormatObj object where the chosen pixel format will be stored.
   * If the function call is successful, this object will be a valid pixel format object that you
   * can use to create an OpenGL context.
   * <li>npix: A pointer to an integer where the number of matching pixel formats will be stored. If
   * the function call is successful, this integer will be greater than 0, indicating the number of
   * matching pixel formats that were found.
   * </ul>
   * Returns: A CGLError value indicating whether the function call was successful or not. If the
   * function call was successful, it will return kCGLNoError. If there was an error, it will return
   * a different error code indicating the nature of the error.
   */
  protected void choosePixelFormat() {
    int[] at = new int[4];

    // The kCGLPFAAccelerated parameter is used to specify whether the pixel format object should be
    // created using hardware acceleration, which can improve the performance of graphics rendering.
    at[0] = cgl_h.kCGLPFAAccelerated();// cgl_h.kCGLPFAAccelerated();

    // The kCGLPFAOpenGLProfile parameter is used to specify the OpenGL profile that the pixel
    // format object should support.
    at[1] = cgl_h.kCGLPFAOpenGLProfile();
    at[2] = cgl_h.kCGLOGLPVersion_GL4_Core();


    //System.out.println("Queried OpenGL version ID : " + at[2]);

    // Ending the attributes
    at[3] = 0;


    // ANOTHER WAY
    /*
     * at = new int[3]; at[0] = cgl_h.kCGLPFAOpenGLProfile(); at[1] =
     * cgl_h.kCGLOGLPVersion_GL4_Core(); at[2] = 0;
     * System.out.println("Queried OpenGL version ID : " + at[1]);
     */


    // ANOTHER WAY OF CONFIGURING
    at = new int[9];
    at[0] = cgl_h.kCGLPFAOpenGLProfile();
    at[1] = cgl_h.kCGLOGLPVersion_GL3_Core();
    at[2] = cgl_h.kCGLPFAColorSize();
    at[3] = 24;
    at[4] = cgl_h.kCGLPFAAlphaSize();
    at[5] = 8;
    at[6] = cgl_h.kCGLPFADoubleBuffer();
    at[7] = cgl_h.kCGLPFAAccelerated();
    at[8] = 0;


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


    pixelFormatLength = at.length;

    // Input : CGLPixelFormatAttribute
    attribs = arena.allocateFrom(ValueLayout.JAVA_INT, at);

    
    // Output : CGLPixelFormatObj
    pixelFormat = arena.allocateFrom(ValueLayout.JAVA_INT, new int[1]);

    // Output : GLint
    numberOfPixels = arena.allocateFrom(ValueLayout.JAVA_INT, new int[1]);

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
   * Retrieve a pixel format value for a given attribute.
   * 
   * Signature of <code>CGLDescribePixelFormat</code> used in this implementation :
   * 
   * <ul>
   * <li>pix: A CGLPixelFormatObj object representing the pixel format that you want to describe.
   * You can obtain a pixel format object by calling CGLChoosePixelFormat or CGLCreateContext.
   * <li>attrib: An integer representing the attribute that you want to query. This can be one of
   * many attributes, such as the number of color bits, the number of depth bits, or the number of
   * stencil bits. You can find a full list of pixel format attributes in the CGLPixelFormat.h
   * header file.
   * <li>value: A pointer to an integer where the value of the queried attribute will be stored.
   * </ul>
   * Returns: A CGLError value indicating whether the function call was successful or not. If the
   * function call was successful, it will return kCGLNoError. If there was an error, it will return
   * a different error code indicating the nature of the error.
   * 
   * @param attribute the ID of the attribute we want to check
   * @param length MAYBE!! The number of elements int pixel format array
   * @return the attribute value
   */
  protected int describePixelFormat(MemorySegment pixelFormat, int attribute, int length) {
    MemorySegment value = arena.allocate(ValueLayout.JAVA_INT, 1);

    int status = cgl_h.CGLDescribePixelFormat(pixelFormat, length, attribute, value);

    throwExceptionUponError("CGLContext.describePixelFormat : ", status);

    return value.getAtIndex(ValueLayout.JAVA_INT, 0);
  }

  // -------------------------------------------------------------------------------------

  /**
   * Check the status returned by CGL invocation and throw a runtime exception if not success
   */
  protected void throwExceptionUponError(String info, int status) {
    if (cgl_h.kCGLNoError() == status) {
      Debug.debug(debug, info + " OK");

    } else if (cgl_h.kCGLBadAttribute() == status) {
      throw new RuntimeException(info + status + " = kCGLBadAttribute.");

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
      throw new RuntimeException(info + status + " = kCGLBadContext. ");

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
