package panamagl.platform.windows;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import opengl.windows.gl_h;
import panamagl.Debug;
import panamagl.opengl.AGLContext;
import panamagl.opengl.GLContext;
import panamagl.opengl.GLError;
import opengl.windows.PFNWGLCHOOSEPIXELFORMATARBPROC;
import opengl.windows.PFNWGLCREATECONTEXTATTRIBSARBPROC;
import opengl.windows.PIXELFORMATDESCRIPTOR;
import opengl.windows.WNDPROC;
import opengl.windows.tagWNDCLASSEXA;

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
  protected MemorySegment hdc;
  protected MemorySegment context;
  
  protected boolean debug = Debug.check(GLContext.class, WGLContext_windows.class);
  
  protected boolean advanced = true;
  
  protected MemorySegment wglChoosePixelFormatARB;
  protected MemorySegment wglCreateContextAttribsARB;

  /**
   * Window procedure of the dummy window, delegating to the default procedure. Returning 0 to all
   * messages makes CreateWindowExA fail (e.g. on WM_NCCREATE). Allocated once for the process, as
   * the window class registered with it is never unregistered.
   */
  protected static final MemorySegment DUMMY_WINDOW_PROC = WNDPROC.allocate(
      (hwnd, msg, wp, lp) -> gl_h.DefWindowProcA(hwnd, msg, wp, lp), Arena.global());
 

  public WGLContext_windows() {
    this(false);
  }
  
  public WGLContext_windows(boolean advanced) {
    super();
    this.advanced = advanced;
    
    // freeglut is not needed by WGL, but only loaded at the first use of GLUT (see GLUT_windows)
    NativeLibLoader_windows.load();
    NativeLibLoader_windows.loadWindowsDLLs();
    
    initArena();
  }
  
  @Override
  public void init() {
    Debug.debug(debug, "WGLContext : from thread " + Thread.currentThread().getName());
    
    if(advanced)
      initAdvanced();
    else
      initSimple();

    initialized = true;
  }
  
  @Override
  public void destroy() {
    gl_h.wglMakeCurrent (gl_h.NULL(), gl_h.NULL()) ;
    gl_h.wglDeleteContext(context);
    context = null;
    initialized = false;
  }
  
  public void makeCurrent() {
    // https://learn.microsoft.com/en-us/windows/win32/api/wingdi/nf-wingdi-wglmakecurrent
    gl_h.wglMakeCurrent(hdc, context);
    
    Debug.debug(debug, "WGL : make context current");
  }
  
  // ----------------------------------------------------------
  
  /**
   * Init context the simpl way
   */
  // https://chgi.developpez.com/windows/hdc/
  //EXCEPTION_ACCESS_VIOLATION (0xc0000005) = segmentation fault (accessing the memory segment of another application)
  protected void initSimple() {
    Debug.debug(debug, "WGL : InitSimple");
    
    initHDC();
    
    int status = 0; // used to get status
    
    // ----------------------------
    // Choose a pixel format

    MemorySegment pixelFormat = PIXELFORMATDESCRIPTOR.allocate(arena);

    // nSize and nVersion are mandatory : Mesa rejects a descriptor without them
    PIXELFORMATDESCRIPTOR.nSize(pixelFormat, (short) pixelFormat.byteSize());
    PIXELFORMATDESCRIPTOR.nVersion(pixelFormat, (short) 1);

    // PFD_DRAW_TO_WINDOW is required: modern drivers (e.g. Mesa) reject formats
    // that do not specify a drawable target. Standard bit depths are also needed.
    int flags = gl_h.PFD_DRAW_TO_WINDOW()
              | gl_h.PFD_SUPPORT_OPENGL();
    PIXELFORMATDESCRIPTOR.dwFlags(pixelFormat, flags);
    PIXELFORMATDESCRIPTOR.iPixelType(pixelFormat, (byte)gl_h.PFD_TYPE_RGBA());
    PIXELFORMATDESCRIPTOR.cColorBits(pixelFormat, (byte)32); // was 13 before using mesa
    PIXELFORMATDESCRIPTOR.cAlphaBits(pixelFormat, (byte)8); // was 11 before using mesa
    PIXELFORMATDESCRIPTOR.cDepthBits(pixelFormat, (byte)24); // was 15 before using mesa
    PIXELFORMATDESCRIPTOR.iLayerType(pixelFormat, (byte)gl_h.PFD_MAIN_PLANE());
    
    // https://learn.microsoft.com/en-us/windows/win32/api/wingdi/nf-wingdi-choosepixelformat
    int format = gl_h.ChoosePixelFormat(hdc, pixelFormat);
    
    if(format==0) {
      throw new RuntimeException("Fail to choose pixel format");
    }
    else {
      Debug.debug(debug, "WGL : format " + format );      
    }
    
    // ----------------------------
    // Set a pixel format
    // https://learn.microsoft.com/en-us/windows/win32/api/wingdi/nf-wingdi-setpixelformat
    status = gl_h.SetPixelFormat(hdc, format, pixelFormat);
    
    if(status==0) {
      throw new RuntimeException("Fail to set pixel format");
    }
    else {
      Debug.debug(debug, "WGL : status " + status );      
    }
    
    // ----------------------------
    // Describe pixel format to check we properly set it
    long nBytes = pixelFormat.byteSize();
    
    MemorySegment pixelFormatOut = PIXELFORMATDESCRIPTOR.allocate(arena);
    
    status = gl_h.DescribePixelFormat(hdc, format, (int)nBytes, pixelFormatOut);
    
    if(status==0) {
      throw new RuntimeException("Fail to get pixel format description");
    }
    else {
      //printPixelFormat(pixelFormatOut);
    }

    
    // ----------------------------
    // Create the context

    //https://learn.microsoft.com/en-us/windows/win32/api/wingdi/nf-wingdi-wglcreatecontext
    context = gl_h.wglCreateContext(hdc);
    
    if(context.equals(gl_h.NULL())) {
      GLError error = getWindowsLastError();
      error.throwRuntimeException();
    }
    else {
      Debug.debug(debug, "WGL : context address : " + context);
    }
  }

  @SuppressWarnings("unused")
  private void printPixelFormat(MemorySegment pixelFormatOut) {
    System.out.println("WGL : PFD.flag " + PIXELFORMATDESCRIPTOR.dwFlags(pixelFormatOut));
    System.out.println("WGL : PFD.iPixelType " + PIXELFORMATDESCRIPTOR.iPixelType(pixelFormatOut));
    System.out.println("WGL : PFD.cAlphaBits " + PIXELFORMATDESCRIPTOR.cAlphaBits(pixelFormatOut));
    System.out.println("WGL : PFD.cColorBits " + PIXELFORMATDESCRIPTOR.cColorBits(pixelFormatOut));
    System.out.println("WGL : PFD.cDepthBits " + PIXELFORMATDESCRIPTOR.cDepthBits(pixelFormatOut));
    System.out.println("WGL : PFD.iLayerType " + PIXELFORMATDESCRIPTOR.iLayerType(pixelFormatOut));
  }
  
  // -------------------------------------------

  /**
   * Init context the advanced way
   */
  protected void initAdvanced() {
    Debug.debug(debug, "WGL : InitAdvanced");

    initHDC();
    initFunctions();
    
    // Pixel configuration
    int attribList[] =
      {
          gl_h.WGL_DRAW_TO_WINDOW_ARB(), gl_h.GL_TRUE(),
          gl_h.WGL_SUPPORT_OPENGL_ARB(), gl_h.GL_TRUE(),
          gl_h.WGL_DOUBLE_BUFFER_ARB(), gl_h.GL_TRUE(),
          gl_h.WGL_PIXEL_TYPE_ARB(), gl_h.WGL_TYPE_RGBA_ARB(),
          gl_h.WGL_COLOR_BITS_ARB(), 32,
          gl_h.WGL_DEPTH_BITS_ARB(), 24,
          gl_h.WGL_STENCIL_BITS_ARB(), 8,
          0, // End
      };
    
    MemorySegment attribsInt = arena.allocateFrom(ValueLayout.JAVA_INT, attribList);
    //MemoryAddress attribsFloat = gl_h.NULL();
    MemorySegment attribsFloat = arena.allocateFrom(ValueLayout.JAVA_FLOAT, new float[0]);
    int nMaxFormats = 1;
    MemorySegment pixelFormat = arena.allocateFrom(ValueLayout.JAVA_INT, new int[nMaxFormats]);
    MemorySegment numberOfFormats = arena.allocateFrom(ValueLayout.JAVA_INT, new int[1]);

    Debug.debug(debug, "WGL : HDC " + hdc);
    int status = PFNWGLCHOOSEPIXELFORMATARBPROC.invoke(wglChoosePixelFormatARB, hdc, attribsInt, attribsFloat, nMaxFormats, pixelFormat, numberOfFormats);
    
    Debug.debug(debug, "WGL : status " + status + " expect " + gl_h.GL_TRUE() );
    
    context = PFNWGLCREATECONTEXTATTRIBSARBPROC.invoke(wglCreateContextAttribsARB, hdc,  gl_h.NULL(), attribsInt);
    
    if(context.equals(gl_h.NULL())) {
      GLError error = getWindowsLastError();
      //error.throwRuntimeException();
      System.err.println("Error getting context : " + error);
      System.exit(0);
    }
    else {
      Debug.debug(debug, "WGL : context " + context);
      Debug.debug(debug, "WGL : context " + context.get(ValueLayout.JAVA_INT, 0));      
    }
  }
  
  /**
   * Function pointers for advanced context initialization.
   */
  protected void initFunctions() {
    MemorySegment name;
    MemorySegment address;
    
    name = arena.allocateFrom("wglChoosePixelFormatARB");
    wglChoosePixelFormatARB = gl_h.wglGetProcAddress(name);
    //wglChoosePixelFormatARB = PFNWGLCHOOSEPIXELFORMATARBPROC.ofAddress(address, arena);

    name = arena.allocateFrom("wglCreateContextAttribsARB");
    wglCreateContextAttribsARB = gl_h.wglGetProcAddress(name);
   // wglCreateContextAttribsARB = PFNWGLCREATECONTEXTATTRIBSARBPROC.ofAddress(address, arena);

    name = null;
    address = null;
  }
  
  //----------------------------------------
  
  /**
   * Retrieve a handle to the device context required for initializing the WGL context.
   *
   * When no window handle is provided, a small invisible dummy window is created to
   * obtain a valid HWND-based DC. GetDC(NULL) (screen DC) must not be used: it is
   * not valid for WGL context creation with modern drivers such as Mesa that require
   * a real HWND to set up their rendering backend.
   */
  protected void initHDC() {
    if (windowHandle[0] != 0) {
      hWnd = arena.allocateFrom(ValueLayout.JAVA_INT, windowHandle[0]);
      Debug.debug(debug, "WGL : HWND : " + windowHandle[0]);
    }
    else {
      hWnd = createDummyWindow();
      Debug.debug(debug, "WGL : dummy HWND : " + hWnd);
    }

    hdc = gl_h.GetDC(hWnd);
    Debug.debug(debug, "WGL : HDC : " + hdc);
  }

  /**
   * Create a minimal invisible 1x1 popup window whose sole purpose is to provide a
   * valid HWND+DC for WGL pixel format selection and context creation.
   *
   * CS_OWNDC ensures the DC is permanently associated with the window (required by WGL).
   */
  protected MemorySegment createDummyWindow() {
    MemorySegment className = arena.allocateFrom("PanamaGLDummy");

    MemorySegment wc = tagWNDCLASSEXA.allocate(arena);
    tagWNDCLASSEXA.cbSize(wc, (int) wc.byteSize());
    tagWNDCLASSEXA.style(wc, gl_h.CS_OWNDC());
    tagWNDCLASSEXA.lpfnWndProc(wc, DUMMY_WINDOW_PROC);
    tagWNDCLASSEXA.cbClsExtra(wc, 0);
    tagWNDCLASSEXA.cbWndExtra(wc, 0);
    tagWNDCLASSEXA.hInstance(wc, gl_h.NULL());
    tagWNDCLASSEXA.hIcon(wc, gl_h.NULL());
    tagWNDCLASSEXA.hCursor(wc, gl_h.NULL());
    tagWNDCLASSEXA.hbrBackground(wc, gl_h.NULL());
    tagWNDCLASSEXA.lpszMenuName(wc, gl_h.NULL());
    tagWNDCLASSEXA.lpszClassName(wc, className);
    tagWNDCLASSEXA.hIconSm(wc, gl_h.NULL());

    // Ignore return value: if the class is already registered (e.g. previous test in
    // the same JVM), CreateWindowExA will still succeed with the existing class.
    gl_h.RegisterClassExA(wc);

    MemorySegment window = gl_h.CreateWindowExA(
        0,                              // no extended styles
        className,                      // class registered above
        arena.allocateFrom(""),         // empty title
        gl_h.WS_POPUP(),              // no title bar / borders
        0, 0, 1, 1,                    // 1x1 pixel, top-left corner
        gl_h.NULL(),                  // no parent
        gl_h.NULL(),                  // no menu
        gl_h.NULL(),                  // hInstance = current process
        gl_h.NULL()                   // no extra param
    );

    if (window.equals(gl_h.NULL())) {
      getWindowsLastError().throwRuntimeException();
    }
    return window;
  }
  
  /**
   * Retrieve last error code while setting up the WGL context.
   * 
   * Different from GL error.
   * 
   */
  protected GLError getWindowsLastError() {
    //https://learn.microsoft.com/en-us/windows/win32/api/errhandlingapi/nf-errhandlingapi-getlasterror
    int errorCode = gl_h.GetLastError();
    
    Debug.debug(debug, "Error getting context : " + errorCode);

    //gl_h.LPVOID.bitAlignment();
    
    int size = 1000;
    MemorySegment mess = arena.allocate(size);
    
    //gl_h.MAKE
    
    //https://community.khronos.org/t/wglcreatecontext-failed/38840/23
    gl_h.FormatMessageW(
        gl_h.FORMAT_MESSAGE_ALLOCATE_BUFFER() |
        gl_h.FORMAT_MESSAGE_FROM_SYSTEM() |
        //gl_h.FORMAT_MESSAGE_FROM_STRING(),
        gl_h.FORMAT_MESSAGE_IGNORE_INSERTS(),
        gl_h.NULL(),
        errorCode,
        0,//gl_h.MAKELANGID(gl_h.LANG_NEUTRAL(), gl_h.SUBLANG_DEFAULT()), // Default language
        mess,
        size,
        gl_h.NULL()
        );
    
    String e127 = "The specified procedure could not be found";
    String e6 = "Invalid handle";
    
    //char[] c = mess.get(ValueLayout.JAVA_CHAR, size);
    String m = new String(mess.toArray(ValueLayout.JAVA_BYTE));
    System.err.println(m);
    
    GLError error = new GLError(errorCode, mess.getString(0));
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
