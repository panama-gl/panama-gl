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
package panamagl.os.linux;


import java.lang.foreign.Addressable;
import java.lang.foreign.MemoryAddress;
import glx.ubuntu.v20.glx_h;
import panamagl.opengl.AGLContext;
import panamagl.opengl.GLContext;

// https://stackoverflow.com/questions/28378891/glxcreatecontext-magically-maps-window
// https://community.khronos.org/t/minimal-glx-opengl3-0-example/55859
// https://learnopengl.com/Advanced-OpenGL/Framebufferss
// https://stackoverflow.com/questions/21851688/linux-rendering-offscreen-with-opengl-3-2-w-fbos
public class GLXContext_linux extends AGLContext implements GLContext{
  protected boolean initialized =false;
  public GLXContext_linux() {
    init();
  }
  public void init() {
    /* ##### MAKE DISPLAY ##### */
    MemoryAddress display = glx_h.XOpenDisplay(null);
    
    
    /* ##### MAKE VISUAL INFO. ##### */
    int attributes[] = { //can't be const b/c X11 doesn't like it.  Not sure if that's intentional or just stupid.
        glx_h.GLX_RGBA(), //apparently nothing comes after this?
        glx_h.GLX_RED_SIZE(),    8,
        glx_h.GLX_GREEN_SIZE(),  8,
        glx_h.GLX_BLUE_SIZE(),   8,
        glx_h.GLX_ALPHA_SIZE(),  8,
        //Ideally, the size would be 32 (or at least 24), but I have actually seen
        //  this size (on a modern OS even).
        glx_h.GLX_DEPTH_SIZE(), 16,
        glx_h.GLX_DOUBLEBUFFER()//, True,
        //glx_h.None()
    };

    
    //XVisualInfo* 
    //MemoryAddress visual_info = glx_h.glXChooseVisual(display, glx_h.DefaultScreen(display), attributes);
    
    /* ##### MAKE WINDOW ##### */
    
    
    // Specifies the connection to the X server.
    Addressable dpy = null;
    // Specifies the visual that defines the frame buffer resources available to the rendering context. 
    // It is a pointer to an XVisualInfo structure, not a visual ID or a pointer to a Visual structure.
    Addressable vis = null;
    // Specifies the visual that defines the frame buffer resources available to the rendering context. 
    // It is a pointer to an XVisualInfo structure, not a visual ID or a pointer to a Visual structure.
    Addressable shareList = null;  
    // A value of True specifies that rendering be done through a direct connection to the graphics system 
    // if possible; a value of False specifies rendering through the X server.
    int direct = 0;
    glx_h.glXCreateContext(dpy, vis, shareList, direct);
    
    initialized = true;
  }
  
  
  @Override
  public void destroy() {
    // TODO Auto-generated method stub
    
  }
  @Override
  public boolean isInitialized() {
    // TODO Auto-generated method stub
    return initialized;
  }
}
