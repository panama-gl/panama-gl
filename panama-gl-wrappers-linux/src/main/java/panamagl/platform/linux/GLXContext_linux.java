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
import glx.linux.x86.glx_h;
import opengl.linux.NativeLibLoader;
import opengl.linux.x86.glut_h;
import panamagl.Debug;
import panamagl.opengl.AGLContext;
import panamagl.opengl.GLContext;

// https://stackoverflow.com/questions/28378891/glxcreatecontext-magically-maps-window
// https://community.khronos.org/t/minimal-glx-opengl3-0-example/55859
// https://learnopengl.com/Advanced-OpenGL/Framebufferss
// https://stackoverflow.com/questions/21851688/linux-rendering-offscreen-with-opengl-3-2-w-fbos
public class GLXContext_linux extends AGLContext implements GLContext{
  protected MemorySegment display;
  protected MemorySegment context;
  
  protected boolean debug = Debug.check(GLContext.class, GLXContext_linux.class);
  
  public GLXContext_linux() {
    super();
    
    NativeLibLoader.load();
    
    initArena();
  }
  
  @Override
  public void init() {
    Debug.debug(debug, "GLXContext : from thread " + Thread.currentThread().getName());
    
    // Init glut so that it can be used
    if(!GLUTContext_linux.hasInit) {
      Debug.debug(debug, "GLXContext : will glutInit");

      MemorySegment argc = arena.allocate(ValueLayout.JAVA_INT, 1);
      glut_h.glutInit(argc, argc);
      GLUTContext_linux.hasInit = true;
    }
    
    // Make display and choose default screen
    display = glx_h.XOpenDisplay(glx_h.NULL());
    int screen = glx_h.XDefaultScreen(display);
    
    Debug.debug(debug, "GLXContext : screen : " + screen);

    
    // Define visual info (rendering settings)
    MemorySegment visualInfo = chooseVisual(screen);
    
    // Make context
    createContext(visualInfo);

    
    // This shows how to load an open gl version
    
    /*PFNGLXCREATECONTEXTATTRIBSARBPROC glXCreateContextAttribsARB = 
        (PFNGLXCREATECONTEXTATTRIBSARBPROC) glx_h.glXGetProcAddressARB(allocator.allocateUtf8String("glXCreateContextAttribsARB"));
    PFNGLXMAKECONTEXTCURRENTPROC glXMakeContextCurrentARB = 
        (PFNGLXMAKECONTEXTCURRENTPROC) glx_h.glXGetProcAddressARB(allocator.allocateUtf8String("glXMakeContextCurrent"));

    
    int context_attribs[] = {
        glx_h.GLX_CONTEXT_MAJOR_VERSION_ARB() ,3,
        glx_h.GLX_CONTEXT_MINOR_VERSION_ARB(), 2,
        glx_h.GLX_CONTEXT_FLAGS_ARB(), glx_h.GLX_CONTEXT_DEBUG_BIT_ARB(),
        glx_h.GLX_CONTEXT_PROFILE_MASK_ARB(), glx_h.GLX_CONTEXT_CORE_PROFILE_BIT_ARB(),
        (int)glx_h.None()
    };

    MemorySegment contextAttrib = allocator.allocateArray(ValueLayout.JAVA_INT, context_attribs);
    
    Addressable contextARB = glXCreateContextAttribsARB.apply(display, visual_info, shareList.address(), direct, contextAttrib.address());
    
    glXMakeContextCurrentARB.apply(display, 0, 0, contextARB);*/
    
    initialized = true;
  }
  
  @Override
  public void destroy() {
    glx_h.glXDestroyContext(display, context);
    
    initialized = false;
  }
  
  //-------------------------------------------------------------------------------------

  /** Specifies the visual that defines the frame buffer resources available 
   * to the rendering context. 
   * It is a pointer to an XVisualInfo structure, not a visual ID or a pointer 
   * to a Visual structure.
   */
  protected MemorySegment chooseVisual(int screen) {
    
    int[] attributes = { 
        glx_h.GLX_RGBA(), 
        glx_h.GLX_RED_SIZE(),    8,
        glx_h.GLX_GREEN_SIZE(),  8,
        glx_h.GLX_BLUE_SIZE(),   8,
        glx_h.GLX_ALPHA_SIZE(),  8,
        glx_h.GLX_DEPTH_SIZE(), 24, //Ideally, the size would be 32 (or at least 24)
        //glx_h.GLX_DOUBLEBUFFER(), True,
        (int) glx_h.None() // Should always finish by NONE
    };
    
    MemorySegment attrib = arena.allocateFrom(ValueLayout.JAVA_INT, attributes);

    MemorySegment visualInfo;
    
    AttribMode mode = AttribMode.CHOSEN;
    
    // This one WORK!!
    if(AttribMode.CHOSEN.equals(mode)){
      visualInfo = glx_h.glXChooseVisual(display, screen, attrib);
    }
    
    // XXX This one actually do not work
    else if(AttribMode.DEFAULT.equals(mode)) {
      visualInfo = glx_h.XDefaultVisual(display, screen);
    }
    
    // XXX This one actually do not work
    else if(AttribMode.FRAMEBUFFER.equals(mode)){
      
      int[] fboC = {1};
      MemorySegment fboCount = arena.allocateFrom(ValueLayout.JAVA_INT, fboC);
      MemorySegment frameBufferConfig = glx_h.glXChooseFBConfig(display, screen, attrib, fboCount);

      visualInfo = glx_h.glXGetVisualFromFBConfig(display, frameBufferConfig);
    }
    else {
      throw new RuntimeException("Unsupported mode");
    }
    
    Debug.debug(debug, "GLXContext : Got visual info " + visualInfo);
    
    return visualInfo;
  }

  /**
   * 
   * @param visualInfo
   */
  protected void createContext(MemorySegment visualInfo) {
    MemorySegment shareList = glx_h.NULL();
    
    // A value of True specifies that rendering be done through a direct connection to the 
    // graphics system if possible; a value of False specifies rendering through the X server.
    int direct = glx_h.GL_TRUE();
    
    // https://www.ibm.com/docs/en/aix/7.1?topic=environment-glxcreatecontext-subroutine
    context = glx_h.glXCreateContext(display, visualInfo, shareList, direct);
    
    Debug.debug(debug, "GLXContext : Got context " + context);
  }
  
  /**
   * 
   */
  public void makeCurrent() {
    // https://opengl.developpez.com/docs/man/man/glXMakeCurrent
    glx_h.glXMakeCurrent(display, 0, context);

    Debug.debug(debug, "GLXContext : Made current " + context);
  }

  /**
   * 
   */
  /*public void release() {
  }*/
  
  enum AttribMode{
    DEFAULT, 
    CHOSEN, 
    FRAMEBUFFER
  }
}
