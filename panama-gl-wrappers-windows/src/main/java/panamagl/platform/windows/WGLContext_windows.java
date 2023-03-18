package panamagl.platform.windows;

import java.lang.foreign.MemoryAddress;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import opengl.ubuntu.v20.glut_h;
import panamagl.Debug;
import panamagl.opengl.AGLContext;
import panamagl.opengl.GLContext;
import panamagl.opengl.GLError;
import wgl.windows.x86.PFNWGLCHOOSEPIXELFORMATARBPROC;
import wgl.windows.x86.PFNWGLCREATECONTEXTATTRIBSARBPROC;
import wgl.windows.x86.PIXELFORMATDESCRIPTOR;
import wgl.windows.x86.wgl_h;

/**
 * WIP Windows context
 * 
 * 
 * @see https://www.khronos.org/opengl/wiki/Creating_an_OpenGL_Context_(WGL)
 * @see https://learn.microsoft.com/en-us/windows/win32/opengl/wgl-and-windows-reference
 * @see https://www.cprogramming.com/tutorial/wgl_wiggle_functions.html
 * @see https://www.khronos.org/opengl/wiki/Tutorial:_OpenGL_3.1_The_First_Triangle_(C++/Win)#Rendering_Context_Creation
 * 
 * @author Martin Pernollet
 */
public class WGLContext_windows extends AGLContext implements GLContext{
  // A Handle to the Window
  protected int[] windowHandle = new int[1];
  protected MemorySegment hWnd;
  
  // A Handle to the DEVICE context
  protected MemoryAddress hdc;
  protected MemoryAddress context;
  
  protected boolean debug = Debug.check(GLContext.class, WGLContext_windows.class);
  
  protected boolean advanced = false;
  
  protected PFNWGLCHOOSEPIXELFORMATARBPROC wglChoosePixelFormatARB;
  protected PFNWGLCREATECONTEXTATTRIBSARBPROC wglCreateContextAttribsARB;
  //protected PFNWGLGETPIXELFORMATATTRIBFVARBPROC wglGetPixelFormatAttribivARB;

  public WGLContext_windows() {
    this(false);
  }
  
  public WGLContext_windows(boolean advanced) {
    super();
    this.advanced = advanced;
    loadNativeLibraries();
    initScope();
  }
  
  protected void loadNativeLibraries() {
    // to invoke getDC() on Windows
    System.loadLibrary("User32"); 
    
    // to invoke ChoosePixelFormat()
    System.loadLibrary("Gdi32");
    
    // to invoke GetLastError()
    System.loadLibrary("Kernel32");
    
    // to use OpenGL and GLUT
    System.loadLibrary("opengl32");
    System.loadLibrary("glu32");
    System.loadLibrary("freeglut");
  }

  @Override
  public void init() {
    init(true);
  }
  
  public void init(boolean loadGlut) {

    // Init glut so that it can be used
    if(loadGlut) {
      var argc = allocator.allocate(ValueLayout.JAVA_INT, 0);
      glut_h.glutInit(argc, argc);
    }

    if(advanced)
      initAdvanced();
    else
      initSimple();

    initialized = true;
  }
  
  @Override
  public void destroy() {
    wgl_h.wglMakeCurrent (wgl_h.NULL(), wgl_h.NULL()) ;
    wgl_h.wglDeleteContext(context);
    context = null;
    initialized = false;
  }
  
  public void makeCurrent() {
    // https://learn.microsoft.com/en-us/windows/win32/api/wingdi/nf-wingdi-wglmakecurrent
    wgl_h.wglMakeCurrent(hdc, context);
    System.out.println("WGL : MAKE CURRENT OK");
  }
  
  // ----------------------------------------------------------
  
  /**
   * Init context the simpl way
   */
  // https://chgi.developpez.com/windows/hdc/
  protected void initSimple() {
    System.out.println("WGL : InitSimple");
    initHDC();
    
    MemorySegment pixelFormat = PIXELFORMATDESCRIPTOR.allocate(allocator);
    //PIXELFORMATDESCRIPTOR.cAccumAlphaBits$set(descriptor, 0L, (byte)0x8);

    // ----------------------------
    // Choose a pixel format
    // https://learn.microsoft.com/en-us/windows/win32/api/wingdi/nf-wingdi-choosepixelformat
    int format = wgl_h.ChoosePixelFormat(hdc, pixelFormat);
    
    if(format==0) {
      throw new RuntimeException("Fail to choose pixel format");
    }
    else {
      System.out.println("WGL : format " + format );      
    }
  
    // ----------------------------
    // Set a pixel format
    // https://learn.microsoft.com/en-us/windows/win32/api/wingdi/nf-wingdi-setpixelformat
    int status = wgl_h.SetPixelFormat(hdc, format, pixelFormat);
    
    if(status==0) {
      throw new RuntimeException("Fail to set pixel format");
    }
    else {
      System.out.println("WGL : status " + status );      
    }
    
    // ----------------------------
    // Create the context

    //https://learn.microsoft.com/en-us/windows/win32/api/wingdi/nf-wingdi-wglcreatecontext
    context = wgl_h.wglCreateContext(hdc);
    
    if(context.address().equals(wgl_h.NULL())) {
      GLError error = getWindowsLastError();
      //error.throwRuntimeException();
      System.err.println("Error getting context : " + error);
      System.exit(0);
    }
    else {
      System.out.println("WGL : context address : " + context);
      //System.out.println("WGL : context value : " + context.get(ValueLayout.JAVA_INT, 0));      
    }
  }
  
  // -------------------------------------------

  /**
   * Init context the advanced way
   */
  protected void initAdvanced() {
    System.out.println("WGL : InitAdvanced");

    initHDC();
    initFunctions();
    
    // Pixel configuration
    int attribList[] =
      {
          wgl_h.WGL_DRAW_TO_WINDOW_ARB(), wgl_h.GL_TRUE(),
          wgl_h.WGL_SUPPORT_OPENGL_ARB(), wgl_h.GL_TRUE(),
          wgl_h.WGL_DOUBLE_BUFFER_ARB(), wgl_h.GL_TRUE(),
          wgl_h.WGL_PIXEL_TYPE_ARB(), wgl_h.WGL_TYPE_RGBA_ARB(),
          wgl_h.WGL_COLOR_BITS_ARB(), 32,
          wgl_h.WGL_DEPTH_BITS_ARB(), 24,
          wgl_h.WGL_STENCIL_BITS_ARB(), 8,
          0, // End
      };
    
    MemorySegment attribsInt = allocator.allocateArray(ValueLayout.JAVA_INT, attribList);
    //MemoryAddress attribsFloat = wgl_h.NULL();
    MemorySegment attribsFloat = allocator.allocateArray(ValueLayout.JAVA_FLOAT, new float[0]);
    int nMaxFormats = 1;
    MemorySegment pixelFormat = allocator.allocateArray(ValueLayout.JAVA_INT, new int[nMaxFormats]);
    MemorySegment numberOfFormats = allocator.allocateArray(ValueLayout.JAVA_INT, new int[1]);

    System.out.println("WGL : HDC " + hdc);
    int status = wglChoosePixelFormatARB.apply(hdc.address(), attribsInt.address(), attribsFloat.address(), nMaxFormats, pixelFormat.address(), numberOfFormats.address());
    
    System.out.println("WGL : status " + status + " expect " + wgl_h.GL_TRUE() );
    
    context = wglCreateContextAttribsARB.apply(hdc.address(),  wgl_h.NULL(), attribsInt.address()).address();
    
    if(context.address().equals(wgl_h.NULL())) {
      GLError error = getWindowsLastError();
      //error.throwRuntimeException();
      System.err.println("Error getting context : " + error);
      System.exit(0);
    }
    else {
      System.out.println("WGL : context " + context);
      System.out.println("WGL : context " + context.get(ValueLayout.JAVA_INT, 0));      
    }
  }
  
  /**
   * Function pointers for advanced context initialization.
   */
  protected void initFunctions() {
    MemorySegment name;
    MemoryAddress address;
    
    name = allocator.allocateUtf8String("wglChoosePixelFormatARB");
    address = wgl_h.wglGetProcAddress(name);
    wglChoosePixelFormatARB = PFNWGLCHOOSEPIXELFORMATARBPROC.ofAddress(address, scope);

    name = allocator.allocateUtf8String("wglCreateContextAttribsARB");
    address = wgl_h.wglGetProcAddress(name);
    wglCreateContextAttribsARB = PFNWGLCREATECONTEXTATTRIBSARBPROC.ofAddress(address, scope);

    name = null;
    address = null;
  }
  
  //----------------------------------------
  
  /**
   * Retrieve a handle to the device context required for initializing the WGL context.
   */
  protected void initHDC() {
    
    // Get a Handle on the window
    if(windowHandle[0]!=0) {
      long[] wh = {windowHandle[0]};
      //hWnd = allocator.allocateArray(ValueLayout.JAVA_LONG, wh);
      hWnd = allocator.allocateArray(ValueLayout.JAVA_INT, windowHandle[0]);

      System.out.println("WGL : HWND : " + windowHandle[0]);

      // Get a Handle on Current Device Context
      // https://learn.microsoft.com/fr-fr/windows/win32/api/winuser/nf-winuser-getdc
      hdc = wgl_h.GetDC(hWnd);
    }
    else {
      // If hWND is NULL, we get a DEVICE CONTEXT for the whole screen
      // (and not for the window only)
      hdc = wgl_h.GetDC(wgl_h.NULL());      
    }
    
    System.out.println("WGL : HDC : " + hdc);
    
    //wgl_h.wglGetCurrentDC(); 
  }
  
  /**
   * Retrieve last error code while setting up the WGL context.
   * 
   * Different from GL error.
   * 
   */
  protected GLError getWindowsLastError() {
    //https://learn.microsoft.com/en-us/windows/win32/api/errhandlingapi/nf-errhandlingapi-getlasterror
    int errorCode = wgl_h.GetLastError();
    
    System.out.println("Error getting context : " + errorCode);

    //wgl_h.LPVOID.bitAlignment();
    
    int size = 1000;
    MemorySegment mess = allocator.allocate(size);
    
    //wgl_h.MAKE
    
    //https://community.khronos.org/t/wglcreatecontext-failed/38840/23
    wgl_h.FormatMessageW(
        wgl_h.FORMAT_MESSAGE_ALLOCATE_BUFFER() |
        wgl_h.FORMAT_MESSAGE_FROM_SYSTEM() |
        //wgl_h.FORMAT_MESSAGE_FROM_STRING(),
        wgl_h.FORMAT_MESSAGE_IGNORE_INSERTS(),
        wgl_h.NULL(),
        errorCode,
        0,//wgl_h.MAKELANGID(wgl_h.LANG_NEUTRAL(), wgl_h.SUBLANG_DEFAULT()), // Default language
        mess.address(),
        size,
        wgl_h.NULL()
        );
    
    String e127 = "The specified procedure could not be found";
    String e6 = "Invalid handle";
    
    //char[] c = mess.get(ValueLayout.JAVA_CHAR, size);
    String m = new String(mess.toArray(ValueLayout.JAVA_BYTE));
    System.err.println(m);
    
    GLError error = new GLError(errorCode, mess.getUtf8String(0));
    return error;
  }
  //----------------------------------------

  public int getWindowHandle() {
    return windowHandle[0];
  }

  public void setWindowHandle(int handle) {
    this.windowHandle[0] = handle;
  }
}
