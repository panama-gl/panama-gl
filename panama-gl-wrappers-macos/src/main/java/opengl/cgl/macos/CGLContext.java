package opengl.cgl.macos;

import static jdk.incubator.foreign.CLinker.C_INT;
import java.util.Arrays;
import jdk.incubator.foreign.CLinker;
import jdk.incubator.foreign.MemorySegment;
import jdk.incubator.foreign.MemoryAddress;
import jdk.incubator.foreign.ResourceScope;
import jdk.incubator.foreign.SegmentAllocator;
import opengl.GLContext;
import opengl.cgl.macos.v10_15_7.OpenGL_h;
import opengl.macos.v11_4.glut_h;

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
 * @author Martin Pernollet
 * 
 * @see CGLImpl.makeCurrent in JOGL
 *
 */
public class CGLContext implements GLContext {
  ResourceScope scope;
  SegmentAllocator allocator;

  MemorySegment attribs;
  MemorySegment pixelFormat;
  MemorySegment context;


  boolean debug = true;

  public CGLContext() {
    // Manually load CGL
    // System.load("/System/Library/Frameworks/GLUT.framework/Versions/Current/GLUT");
    System.load("/System/Library/Frameworks/GLUT.framework/Versions/Current/GLUT");

    scope = ResourceScope.newConfinedScope();
    allocator = SegmentAllocator.ofScope(scope);

  }

  /*
   * int[] numPixelFormats = new int[1]; CGLChoosePixelFormat(attributes, 0, 0, numPixelFormats);
   * 
   * int[] pixelFormat = new int[1]; CGLChoosePixelFormat(attributes, 1, pixelFormat,
   * numPixelFormats);
   * 
   * // Describe the pixel format to get the maximum number of samples per pixel int[] maxSamples =
   * new int[1]; CGLDescribePixelFormat(pixelFormat[0], 0, CGL.kCGLPFAMaximumSampleBuffers,
   * maxSamples);
   * 
   * // Create an OpenGL context PointerByReference context = new PointerByReference();
   * CGLCreateContext(pixelFormat[0], 0, context);
   * 
   * // ...
   * 
   * // Destroy the pixel format and the OpenGL context when you are done with them
   * CGLDestroyPixelFormat(pixelFormat[0]); CGLDestroyContext(context.getValue());
   */

  // https://stackoverflow.com/questions/11383510/setting-up-an-opengl-context-with-cgl-on-mac-os-x
  // https://developer.apple.com/library/archive/documentation/GraphicsImaging/Conceptual/OpenGL-MacProgGuide/opengl_offscreen/opengl_offscreen.html
  // http://renderingpipeline.com/2012/05/windowless-opengl-on-macos-x/


  @Override
  public synchronized void init() {
    MemorySegment npix = choosePixelFormat();

    createContext(npix);

    // makeCurrent();

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
    int err = OpenGL_h.CGLLockContext(context);

    if (OpenGL_h.kCGLNoError() == err) {
      System.out.println("CGLContext : lock : " + err + " = no error");

    } 
    else if(OpenGL_h.kCGLBadContext() == err) {
      System.err.println("Got CGL bad context error while locking context : " + err);
    }
    else {
      System.err.println("Got CGL error while locking context : " + err);
      // throw new RuntimeException("Got CGL error while locking context : " + err);
    }
  }


  public void unlockContext() {
    final int err2 = OpenGL_h.CGLUnlockContext(context);

    /*
     * Error 0x2714 is a common error that can occur while trying to unlock a CGL (Core Graphics
     * Library) context. It indicates that the CGL context is not locked, and cannot be unlocked.
     */
    if (OpenGL_h.kCGLBadContext() == err2) {
      System.err.println("CGL: Could not unlock context that is not locked : err 0x"
          + Integer.toHexString(err2) + " (" + err2 + ") : " + this);

    } else if (OpenGL_h.kCGLNoError() != err2) {
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
    int err = OpenGL_h.CGLSetCurrentContext(context);

    if (OpenGL_h.kCGLNoError() == err) {
      System.out.println("CGLContext : set current : " + err + " = no error");

    } else if (OpenGL_h.kCGLBadContext() == err) {
      System.err.println("CGLContext : set current : " + err
          + " = kCGLBadContext(). The specified context is invalid.");

    } else if (OpenGL_h.kCGLBadConnection() == err) {
      System.err.println("CGLContext : set current : " + err
          + " = kCGLBadConnection(). The specified context is not connected to a window or drawable.");

    } else {
      System.err.println("Got CGL error while setting context current : " + err);
      // throw new RuntimeException("Got CGL error while locking context : " + err);
    }
  }

  protected void setCurrentContextZero() {
    MemorySegment zero = allocator.allocateArray(C_INT, new int[1]);
    final int err = OpenGL_h.CGLSetCurrentContext(zero);
    if (OpenGL_h.kCGLNoError() != err) {
      System.err.println("CGL: Could not release current context: err 0x" + Integer.toHexString(err)
          + ": " + this);
    }
  }

  protected MemoryAddress getCurrentContext() {
    MemoryAddress currentContext = OpenGL_h.CGLGetCurrentContext();

    if (debug)
      System.out.println("CGLContext : Current context = " + currentContext.toRawLongValue());

    return currentContext;
  }

  public void createContext(MemorySegment npix) {
    MemorySegment c_share = CLinker.toCString("", scope);

    context = CLinker.toCString("", scope);
    OpenGL_h.CGLCreateContext(pixelFormat, c_share, context);

    if (debug) {
      System.out.println("CGLContext : " + Arrays.toString(pixelFormat.toIntArray()));
      System.out.println("CGLContext : " + Arrays.toString(npix.toIntArray()));
      System.out.println("CGLContext : CREATED!!");
    }

  }

  protected MemorySegment choosePixelFormat() {
    int[] at = new int[4];



    // The kCGLPFAAccelerated parameter is used to specify whether the pixel format object should be
    // created using hardware acceleration, which can improve the performance of graphics rendering.
    at[0] = OpenGL_h.kCGLPFAAccelerated();
    // The kCGLPFAOpenGLProfile parameter is used to specify the OpenGL profile that the pixel
    // format object should support.
    at[1] = OpenGL_h.kCGLPFAOpenGLProfile();
    at[2] = OpenGL_h.kCGLOGLPVersion_3_2_Core();
    at[3] = 0;

    attribs = allocator.allocateArray(C_INT, at);
    pixelFormat = allocator.allocateArray(C_INT, new int[1]);

    // int[] pixFormats = new int[1];
    MemorySegment npix = allocator.allocateArray(C_INT, new int[1]);

    OpenGL_h.CGLChoosePixelFormat(attribs, pixelFormat, npix);

    if (debug) {
      System.out.println(
          "CGLContext : CGLChoosePixelFormat attributes " + Arrays.toString(attribs.toIntArray()));
      System.out.println(
          "CGLContext : CGLChoosePixelFormat format " + Arrays.toString(pixelFormat.toIntArray()));
      System.out.println("CGLContext : CGLChoosePixelFormat max number of sample per pixel "
          + Arrays.toString(npix.toIntArray()));
    }
    return npix;
  }

  @Override
  public synchronized void destroy() {
    OpenGL_h.CGLDestroyPixelFormat(pixelFormat);
    OpenGL_h.CGLDestroyContext(context);

    if (debug)
      System.out.println("CGLContext destroyed");

  }
}
