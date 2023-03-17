package panamagl.platform.windows;

import java.lang.foreign.MemoryAddress;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import opengl.ubuntu.v20.glut_h;
import panamagl.Debug;
import panamagl.opengl.AGLContext;
import panamagl.opengl.GLContext;
import wgl.windows.x86.PFNWGLCHOOSEPIXELFORMATARBPROC;
import wgl.windows.x86.PFNWGLCREATECONTEXTATTRIBSARBPROC;
import wgl.windows.x86.PFNWGLGETPIXELFORMATATTRIBFVARBPROC;
import wgl.windows.x86.PIXELFORMATDESCRIPTOR;
import wgl.windows.x86.wgl_h;

/**
 * 
 * @see https://www.khronos.org/opengl/wiki/Creating_an_OpenGL_Context_(WGL)
 * @see https://learn.microsoft.com/en-us/windows/win32/opengl/wgl-and-windows-reference
 * 
 * @author Martin Pernollet
 */
public class WGLContext_windows extends AGLContext implements GLContext{
  protected MemoryAddress hdc;
  protected MemoryAddress context;
  
  protected boolean debug = Debug.check(GLContext.class, WGLContext_windows.class);
  
  //protected wgl_h.HDC hdc;
  
  protected PFNWGLCHOOSEPIXELFORMATARBPROC wglChoosePixelFormatARB;
  protected PFNWGLCREATECONTEXTATTRIBSARBPROC wglCreateContextAttribsARB;
  protected PFNWGLGETPIXELFORMATATTRIBFVARBPROC wglGetPixelFormatAttribivARB;
  
  public WGLContext_windows() {
    super();
    loadNativeLibraries();
    initScope();
    initFunctions();
  }
  
  protected void loadNativeLibraries() {
    //System.loadLibrary("wingdib");
    System.loadLibrary("opengl32");
    System.loadLibrary("glu32");
    System.loadLibrary("freeglut");
  }
  
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

    initSimple();
    //initAdvanced();
    
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
    
  }
  
  // ----------------------------------------------------------
  
  protected void initSimple() {
    
    hdc = wgl_h.wglGetCurrentDC();    
    
    MemorySegment pixelFormat = PIXELFORMATDESCRIPTOR.allocate(allocator);
    
    //PIXELFORMATDESCRIPTOR.cAccumAlphaBits$set(descriptor, 0L, (byte)0x8);
    
    // WinGDI Functions : https://en.wikipedia.org/wiki/WinG
    // Not available on my computer?
    // https://learn.microsoft.com/en-us/windows/win32/api/wingdi/nf-wingdi-choosepixelformat
    //wgl_h.ChoosePixelFormat(hdc, pixelFormat.address());
    //wgl_h.SetPixelFormat();
    
    //https://learn.microsoft.com/en-us/windows/win32/api/wingdi/nf-wingdi-wglcreatecontext
    context = wgl_h.wglCreateContext(hdc);
  }

  protected void initAdvanced() {
    hdc = wgl_h.wglGetCurrentDC();
    
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
    
    MemorySegment attribs = allocator.allocateArray(ValueLayout.JAVA_INT, attribList);
    MemorySegment pixelFormat = allocator.allocateArray(ValueLayout.JAVA_INT, new int[10000]);
    MemorySegment numberOfFormats = allocator.allocateArray(ValueLayout.JAVA_INT, new int[100]);

    int status = wglChoosePixelFormatARB.apply(hdc, attribs.address(), wgl_h.NULL(), 1, pixelFormat.address(), numberOfFormats.address());
    
    System.out.println(status); // either TRUE or FALSE
    
    context = wglCreateContextAttribsARB.apply(hdc,  wgl_h.NULL(), attribs.address()).address();
  }
}
