package panamagl.platform.windows;

import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import freeglut.windows.x86.freeglut_h;
import opengl.windows.NativeLibLoader;
import panamagl.Debug;
import panamagl.opengl.AGLContext;
import panamagl.opengl.GLContext;
import panamagl.opengl.GLError;
import wgl.windows.x86.PFNWGLCHOOSEPIXELFORMATARBPROC;
import wgl.windows.x86.PFNWGLCREATECONTEXTATTRIBSARBPROC;
import wgl.windows.x86.PIXELFORMATDESCRIPTOR;
import wgl.windows.x86.WNDPROC;
import wgl.windows.x86.tagWNDCLASSEXA;
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
  protected MemorySegment hdc;
  protected MemorySegment context;
  
  protected boolean debug = Debug.check(GLContext.class, WGLContext_windows.class);
  
  protected boolean advanced = true;
  
  protected MemorySegment wglChoosePixelFormatARB;
  protected MemorySegment wglCreateContextAttribsARB;
 

  public WGLContext_windows() {
    this(false);
  }
  
  public WGLContext_windows(boolean advanced) {
    super();
    this.advanced = advanced;
    
    NativeLibLoader.load();
    NativeLibLoader.loadWindowsDLL();
    
    initArena();
  }
  
  @Override
  public void init() {
    Debug.debug(debug, "WGLContext : from thread " + Thread.currentThread().getName());
    
    // Init glut so that it can be used
    if(!GLUTContext_windows.hasInit) {
      Debug.debug(debug, "WGLContext : will glutInit");

      MemorySegment argc = arena.allocateFrom(ValueLayout.JAVA_INT, 0);
      MemorySegment argv = arena.allocateFrom("");
      freeglut_h.glutInit(argc, argv);
      GLUTContext_windows.hasInit = true;
    }
    
    //freeglut_h.glutInitDisplayMode(freeglut_h.GLUT_DOUBLE() | freeglut_h.GLUT_RGBA() | freeglut_h.GLUT_DEPTH());
    //freeglut_h.glutInitWindowSize(1, 1);
    //freeglut_h.glutInitWindowPosition(1000000, 1000000);
    
    //int windowHandle = freeglut_h.glutCreateWindow(arena.allocateFrom("...."));
    
    // Hacky!! Use it while WGLContext is not working
    //freeglut_h.glutHideWindow();   
    
    //freeglut_h.glutDestroyWindow(windowHandle);

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

    // PFD_DRAW_TO_WINDOW is required: modern drivers (e.g. Mesa) reject formats
    // that do not specify a drawable target. Standard bit depths are also needed.
    int flags = wgl_h.PFD_DRAW_TO_WINDOW()
              | wgl_h.PFD_SUPPORT_OPENGL();
    PIXELFORMATDESCRIPTOR.dwFlags(pixelFormat, flags);
    PIXELFORMATDESCRIPTOR.iPixelType(pixelFormat, (byte)wgl_h.PFD_TYPE_RGBA());
    PIXELFORMATDESCRIPTOR.cColorBits(pixelFormat, (byte)32); // was 13 before using mesa
    PIXELFORMATDESCRIPTOR.cAlphaBits(pixelFormat, (byte)8); // was 11 before using mesa
    PIXELFORMATDESCRIPTOR.cDepthBits(pixelFormat, (byte)24); // was 15 before using mesa
    PIXELFORMATDESCRIPTOR.iLayerType(pixelFormat, (byte)wgl_h.PFD_MAIN_PLANE());
    
    // https://learn.microsoft.com/en-us/windows/win32/api/wingdi/nf-wingdi-choosepixelformat
    int format = wgl_h.ChoosePixelFormat(hdc, pixelFormat);
    
    if(format==0) {
      throw new RuntimeException("Fail to choose pixel format");
    }
    else {
      Debug.debug(debug, "WGL : format " + format );      
    }
    
    // ----------------------------
    // Set a pixel format
    // https://learn.microsoft.com/en-us/windows/win32/api/wingdi/nf-wingdi-setpixelformat
    status = wgl_h.SetPixelFormat(hdc, format, pixelFormat);
    
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
    
    status = wgl_h.DescribePixelFormat(hdc, format, (int)nBytes, pixelFormatOut);
    
    if(status==0) {
      throw new RuntimeException("Fail to get pixel format description");
    }
    else {
      //printPixelFormat(pixelFormatOut);
    }

    
    // ----------------------------
    // Create the context

    //https://learn.microsoft.com/en-us/windows/win32/api/wingdi/nf-wingdi-wglcreatecontext
    context = wgl_h.wglCreateContext(hdc);
    
    if(context.equals(wgl_h.NULL())) {
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
          wgl_h.WGL_DRAW_TO_WINDOW_ARB(), wgl_h.GL_TRUE(),
          wgl_h.WGL_SUPPORT_OPENGL_ARB(), wgl_h.GL_TRUE(),
          wgl_h.WGL_DOUBLE_BUFFER_ARB(), wgl_h.GL_TRUE(),
          wgl_h.WGL_PIXEL_TYPE_ARB(), wgl_h.WGL_TYPE_RGBA_ARB(),
          wgl_h.WGL_COLOR_BITS_ARB(), 32,
          wgl_h.WGL_DEPTH_BITS_ARB(), 24,
          wgl_h.WGL_STENCIL_BITS_ARB(), 8,
          0, // End
      };
    
    MemorySegment attribsInt = arena.allocateFrom(ValueLayout.JAVA_INT, attribList);
    //MemoryAddress attribsFloat = wgl_h.NULL();
    MemorySegment attribsFloat = arena.allocateFrom(ValueLayout.JAVA_FLOAT, new float[0]);
    int nMaxFormats = 1;
    MemorySegment pixelFormat = arena.allocateFrom(ValueLayout.JAVA_INT, new int[nMaxFormats]);
    MemorySegment numberOfFormats = arena.allocateFrom(ValueLayout.JAVA_INT, new int[1]);

    Debug.debug(debug, "WGL : HDC " + hdc);
    int status = PFNWGLCHOOSEPIXELFORMATARBPROC.invoke(wglChoosePixelFormatARB, hdc, attribsInt, attribsFloat, nMaxFormats, pixelFormat, numberOfFormats);
    
    Debug.debug(debug, "WGL : status " + status + " expect " + wgl_h.GL_TRUE() );
    
    context = PFNWGLCREATECONTEXTATTRIBSARBPROC.invoke(wglCreateContextAttribsARB, hdc,  wgl_h.NULL(), attribsInt);
    
    if(context.equals(wgl_h.NULL())) {
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
    wglChoosePixelFormatARB = wgl_h.wglGetProcAddress(name);
    //wglChoosePixelFormatARB = PFNWGLCHOOSEPIXELFORMATARBPROC.ofAddress(address, arena);

    name = arena.allocateFrom("wglCreateContextAttribsARB");
    wglCreateContextAttribsARB = wgl_h.wglGetProcAddress(name);
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

    hdc = wgl_h.GetDC(hWnd);
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
    tagWNDCLASSEXA.style(wc, wgl_h.CS_OWNDC());
    tagWNDCLASSEXA.lpfnWndProc(wc, WNDPROC.allocate((hwnd, msg, wp, lp) -> 0L, arena));
    tagWNDCLASSEXA.cbClsExtra(wc, 0);
    tagWNDCLASSEXA.cbWndExtra(wc, 0);
    tagWNDCLASSEXA.hInstance(wc, wgl_h.NULL());
    tagWNDCLASSEXA.hIcon(wc, wgl_h.NULL());
    tagWNDCLASSEXA.hCursor(wc, wgl_h.NULL());
    tagWNDCLASSEXA.hbrBackground(wc, wgl_h.NULL());
    tagWNDCLASSEXA.lpszMenuName(wc, wgl_h.NULL());
    tagWNDCLASSEXA.lpszClassName(wc, className);
    tagWNDCLASSEXA.hIconSm(wc, wgl_h.NULL());

    // Ignore return value: if the class is already registered (e.g. previous test in
    // the same JVM), CreateWindowExA will still succeed with the existing class.
    wgl_h.RegisterClassExA(wc);

    return wgl_h.CreateWindowExA(
        0,                              // no extended styles
        className,                      // class registered above
        arena.allocateFrom(""),         // empty title
        wgl_h.WS_POPUP(),              // no title bar / borders
        0, 0, 1, 1,                    // 1x1 pixel, top-left corner
        wgl_h.NULL(),                  // no parent
        wgl_h.NULL(),                  // no menu
        wgl_h.NULL(),                  // hInstance = current process
        wgl_h.NULL()                   // no extra param
    );
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
    
    Debug.debug(debug, "Error getting context : " + errorCode);

    //wgl_h.LPVOID.bitAlignment();
    
    int size = 1000;
    MemorySegment mess = arena.allocate(size);
    
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
        mess,
        size,
        wgl_h.NULL()
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
