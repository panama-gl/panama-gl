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
package panamagl.platform.windows;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
// le vrai import peut etre le suivant 
//import glext.linux.x86.PFNGLBINDFRAMEBUFFEREXTPROC;
//import glx.linux.x86.PFNGLBINDFRAMEBUFFEREXTPROC;
import opengl.linux.x86.PFNGLBINDFRAMEBUFFEREXTPROC;
import opengl.linux.x86.PFNGLBINDRENDERBUFFEREXTPROC;
import opengl.linux.x86.PFNGLCHECKFRAMEBUFFERSTATUSEXTPROC;
import opengl.linux.x86.PFNGLDELETEFRAMEBUFFERSEXTPROC;
import opengl.linux.x86.PFNGLDELETERENDERBUFFERSEXTPROC;
import opengl.linux.x86.PFNGLFRAMEBUFFERRENDERBUFFEREXTPROC;
import opengl.linux.x86.PFNGLFRAMEBUFFERTEXTURE2DEXTPROC;
import opengl.linux.x86.PFNGLGENFRAMEBUFFERSEXTPROC;
import opengl.linux.x86.PFNGLGENRENDERBUFFERSEXTPROC;
import opengl.linux.x86.PFNGLRENDERBUFFERSTORAGEEXTPROC;
import opengl.linux.x86.glut_h;
import panamagl.Debug;
import panamagl.Image;
import panamagl.offscreen.AFBO;
import panamagl.offscreen.FBO;
import panamagl.opengl.GL;
import panamagl.opengl.GLError;
import wgl.windows.x86.wgl_h;






/**
 * A frame buffer object, or {@link FBO_windows}, can render OpenGL into an offscreen buffer that can later
 * be converted to an {@link Image}.
 *
 * See : 
 * https://www.khronos.org/opengl/wiki/Framebuffer_Object
 * https://www.khronos.org/opengl/wiki/Common_Mistakes
 * https://www.khronos.org/opengl/wiki/Framebuffer_Object_Extension_Examples#Quick_example,_render_to_texture_(2D)
 *
 * Hint : to debug this class, invoke a program using it with flag -Dpanamagl.offscreen.FBO
 *
 * NB : the implementation intentionnaly uses linux extension loader because
 * the windows one could not be found in the generated bindings.
 *
 * @author Martin Pernollet
 */
public class FBO_windows extends AFBO implements FBO {
  // default
  protected int level = 0;
  protected int border = 0;
  protected int channels = 4; // RGBA



  // supposed to copy to BufferedImage faster when true
  // using false allows to make copy by tweaking bytes
  // which is useful for debugging
  protected boolean arrayExport = true;

  

  /** Memory arena to load OpenGL extension. Will live until this class dies. */
  protected Arena classArena;

  // dynamically loaded OpenGL functions
  protected MemorySegment glGenFramebuffers;
  protected MemorySegment glBindFramebuffer;
  protected MemorySegment glFramebufferTexture2D;

  protected MemorySegment glGenRenderbuffers;
  protected MemorySegment glBindRenderbuffer;
  protected MemorySegment glRenderbufferStorage;
  
  protected MemorySegment glFramebufferRenderbuffer;
  protected MemorySegment glCheckFramebufferStatus;
  
  protected MemorySegment glDeleteRenderbuffers;
  protected MemorySegment glDeleteFramebuffers;

  
  public FBO_windows() {
    this(0, 0);
  }

  public FBO_windows(int width, int height) {
    resize(width, height);
    
    this.debug = Debug.check(FBO.class, FBO_windows.class);
    
    init();
  }
  
  /** 
   * Initialize pointers to OpenGL extensions allowing to perform offscreen rendering
   */
  protected void init() {
    classArena = Arena.ofAuto();
    
    MemorySegment function;
    
    // glGenFramebuffers
    function = classArena.allocateFrom("glGenFramebuffersEXT");
    glGenFramebuffers = wgl_h.wglGetProcAddress(function);
    
    if (glGenFramebuffers.address() == 0L) {
      throw new RuntimeException(
          "OpenGL EXT_framebuffer_object extension not available: wglGetProcAddress returned NULL for glGenFramebuffersEXT. "
        + "This may mean the OpenGL context is a software renderer (no GPU driver).");
    }
    
    // glBindFramebuffer
    function = classArena.allocateFrom("glBindFramebufferEXT");
    glBindFramebuffer = wgl_h.wglGetProcAddress(function);
    
    // glFramebufferTexture2D
    function = classArena.allocateFrom("glFramebufferTexture2DEXT");
    glFramebufferTexture2D = wgl_h.wglGetProcAddress(function);

    // glGenRenderbuffers
    function = classArena.allocateFrom("glGenRenderbuffersEXT");
    glGenRenderbuffers = wgl_h.wglGetProcAddress(function);
    
    // glBindRenderbuffer
    function = classArena.allocateFrom("glBindRenderbufferEXT");
    glBindRenderbuffer = wgl_h.wglGetProcAddress(function);
    
    // glRenderbufferStorage
    function = classArena.allocateFrom("glRenderbufferStorageEXT");
    glRenderbufferStorage = wgl_h.wglGetProcAddress(function);
    
    // glFramebufferRenderbuffer
    function = classArena.allocateFrom("glFramebufferRenderbufferEXT");
    glFramebufferRenderbuffer = wgl_h.wglGetProcAddress(function);
    
    // glCheckFramebufferStatus
    function = classArena.allocateFrom("glCheckFramebufferStatusEXT");
    glCheckFramebufferStatus = wgl_h.wglGetProcAddress(function);
   
    // glDeleteRenderbuffers
    function = classArena.allocateFrom("glDeleteRenderbuffersEXT");
    glDeleteRenderbuffers = wgl_h.wglGetProcAddress(function);
    
    // glDeleteFramebuffers
    function = classArena.allocateFrom("glDeleteFramebuffersEXT");
    glDeleteFramebuffers = wgl_h.wglGetProcAddress(function);
  }
  
  // could avoid renewing buffers, but keep the same behaviour
  // than macOS for now
  //boolean renewBuffers = true;

  /** 
   * Allocate memory segments required to perform offscreen rendering using the frame buffer object, unless resource have already been prepared.
   * 
   * All memory segments are freed by calling {@link #release(GL)}.
   */
  @Override
  public void prepare(GL gl) {
    Debug.debug(debug, "FBO: from thread " + Thread.currentThread().getName());
    
    // Check that this happens in AWT event queue, otherwise skip rendering
    // to avoid opengl exception.
    //if(!"AWT-EventQueue-0".equals(Thread.currentThread().getName()))
    //  return;
    
    if (prepared)
      release(gl);
    
    prepareRenderArena();

    // transfert pixel Format
    Debug.debug(debug, "FBO.internalFormat : " + internalFormat + " (default GL.GL_RGBA8)");
    Debug.debug(debug, "FBO.format         : " + format + " (default GL.GL_BGRA)");

    // ------------------------
    // Generate TEXTURE buffer

    if(idTexture<=0 ){
      textureBufferIds = renderArena.allocate(1 * 4 * 3);
      gl.glGenTextures(1, textureBufferIds);
      idTexture = (int) textureBufferIds.get(ValueLayout.JAVA_INT, 0);
    }
    Debug.debug(debug, "FBO: Got texture ID : " + idTexture);

    // Check errors
    if (idTexture == 0) {
      diagnoseError(gl, "texture");
    }

    // Bind texture and set parameters
    gl.glBindTexture(GL.GL_TEXTURE_2D, idTexture);
    gl.glTexParameteri(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_S, GL.GL_REPEAT);
    gl.glTexParameteri(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_T, GL.GL_REPEAT);
    gl.glTexParameteri(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MIN_FILTER, GL.GL_NEAREST);
    gl.glTexParameteri(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MAG_FILTER, GL.GL_NEAREST);

    // Create a texture to write to
    int byteSize = width * height * channels;
    
    pixelBuffer = renderArena.allocate(byteSize);
    gl.glTexImage2D(GL.GL_TEXTURE_2D, level, internalFormat, width, height, border, format,
        textureType, pixelBuffer);
    

    // -------------------------
    // Generate FRAME buffer
    
    if (idFrameBuffer <= 0 ){
      frameBufferIds = renderArena.allocate(4);
      PFNGLGENFRAMEBUFFERSEXTPROC.invoke(glGenFramebuffers, 1, frameBufferIds);
      
      idFrameBuffer = (int) frameBufferIds.get(ValueLayout.JAVA_INT, 0);
    }
    Debug.debug(debug, "FBO: Got FB ID : " + idFrameBuffer);

    // Check errors
    if (idFrameBuffer == 0) {
      diagnoseError(gl, "framebuffer");
    }

    // Bind frame buffer
    PFNGLBINDFRAMEBUFFEREXTPROC.invoke(glBindFramebuffer, glut_h.GL_FRAMEBUFFER(), idFrameBuffer);

    // Attach 2D texture to this FBO
    PFNGLFRAMEBUFFERTEXTURE2DEXTPROC.invoke(glFramebufferTexture2D, glut_h.GL_FRAMEBUFFER_EXT(), glut_h.GL_COLOR_ATTACHMENT0_EXT(), GL.GL_TEXTURE_2D, idTexture, 0);

    
    // -------------------------
    // Generate RENDER buffer

    if(idRenderBuffer<=0 ){//|| renewBuffers) {
      renderBufferIds = renderArena.allocate(4);
      PFNGLGENRENDERBUFFERSEXTPROC.invoke(glGenRenderbuffers, 1, renderBufferIds);
      idRenderBuffer = (int) renderBufferIds.get(ValueLayout.JAVA_INT, 0);
    }
    
    // Check for error after reading
    GLError.checkAndThrow(gl);
    
    Debug.debug(debug, "FBO: Got RenderBuffer ID : " + idRenderBuffer);

    // Bind render buffer
    PFNGLBINDRENDERBUFFEREXTPROC.invoke(glBindRenderbuffer, glut_h.GL_RENDERBUFFER_EXT(), idRenderBuffer);
    PFNGLRENDERBUFFERSTORAGEEXTPROC.invoke(glRenderbufferStorage, glut_h.GL_RENDERBUFFER_EXT(), GL.GL_DEPTH_COMPONENT24, width, height);

    
    // -------------------------
    // Attach depth buffer to FBO

    PFNGLFRAMEBUFFERRENDERBUFFEREXTPROC.invoke(glFramebufferRenderbuffer, glut_h.GL_FRAMEBUFFER_EXT(), glut_h.GL_DEPTH_ATTACHMENT_EXT(), glut_h.GL_RENDERBUFFER_EXT(), idRenderBuffer);

    
    // -------------------------
    // Does the GPU support current FBO configuration?

    int status = PFNGLCHECKFRAMEBUFFERSTATUSEXTPROC.invoke(glCheckFramebufferStatus, glut_h.GL_FRAMEBUFFER_EXT());

    if (status != glut_h.GL_FRAMEBUFFER_COMPLETE_EXT()) {
      throw new RuntimeException("Incomplete framebuffer, not supporting current FBO config : "
          + status + " != GL_FRAMEBUFFER_COMPLETE (" + glut_h.GL_FRAMEBUFFER_COMPLETE_EXT() + ")");
    }

    // -------------------------
    // and now you can render to GL_TEXTURE_2D
    
    PFNGLBINDFRAMEBUFFEREXTPROC.invoke(glBindFramebuffer, glut_h.GL_FRAMEBUFFER(), idFrameBuffer);
    
    gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
    gl.glClearDepth(1.0f);
    gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);

    // Mark as prepared
    prepared = true;

    Debug.debug(debug, "FBO: Prepared a " + width + "x" + height);
  }

  /** Release resources held by this FBO utility.*/
  @Override
  public synchronized void release(GL gl) {
    // Skip release step if the FBO wasn't prepared
    if(!prepared)
      return;
    
    // Delete render buffer
    gl.glDeleteTextures(1, textureBufferIds);
    PFNGLDELETERENDERBUFFERSEXTPROC.invoke(glDeleteRenderbuffers, 1, renderBufferIds);
    
    // Bind 0, which means render to back buffer, as a result, fb is unbound
    PFNGLBINDFRAMEBUFFEREXTPROC.invoke(glBindFramebuffer, glut_h.GL_FRAMEBUFFER(), 0);
 
    // Delete frame buffer
    PFNGLDELETEFRAMEBUFFERSEXTPROC.invoke(glDeleteFramebuffers, 1, frameBufferIds);

    // Free memory
    releaseRenderArena();

    prepared = false;

    Debug.debug(debug, "FBO: Resources released !");
  }
  
  /** Return all pixels. Their lifetime is bounded to the {@link #renderArena}. */
  @Override
  public MemorySegment readPixels(GL gl) {
    // Initialize buffers if they are not ready or if their expected size changed
    if (!prepared)
      prepare(gl);

    // Reading pixels
    int nBytes = width * height * channels;
    
    // The segments created in this function will be destroyed
    // one the below scope and allocator are collected by GC.
    if(pixels==null || pixels.byteSize()!=nBytes) {
      pixels = renderArena.allocate(nBytes);
    }

    gl.glReadPixels(0, 0, width, height, format, textureType, pixels);
    
    // Check for error after reading
    GLError.checkAndThrow(gl);

    Debug.debug(debug, "FBO: PixelBuffer red !");
    
    unbindFramebuffer();
    
    return pixels;
  }

  protected void unbindFramebuffer() {
    // Bind 0, which means render to back buffer
    PFNGLBINDFRAMEBUFFEREXTPROC.invoke(glBindFramebuffer, glut_h.GL_FRAMEBUFFER(), 0);    
  }
  
}
