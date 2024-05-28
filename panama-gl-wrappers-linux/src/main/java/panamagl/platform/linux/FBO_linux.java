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

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import glx.linux.x86.glx_h;
//import glext.linux.x86.PFNGLBINDFRAMEBUFFEREXTPROC;
//import glext.linux.x86.PFNGLGENFRAMEBUFFERSEXTPROC;
//import glext.linux.x86.PFNGLGENRENDERBUFFERSEXTPROC;
import opengl.linux.x86.PFNGLBINDFRAMEBUFFEREXTPROC;
import opengl.linux.x86.PFNGLGENFRAMEBUFFERSEXTPROC;
import opengl.linux.x86.PFNGLGENRENDERBUFFERSEXTPROC;
import opengl.linux.x86.PFNGLBINDRENDERBUFFEREXTPROC;
import opengl.linux.x86.PFNGLCHECKFRAMEBUFFERSTATUSEXTPROC;
import opengl.linux.x86.PFNGLDELETEFRAMEBUFFERSEXTPROC;
import opengl.linux.x86.PFNGLDELETERENDERBUFFERSEXTPROC;
import opengl.linux.x86.PFNGLFRAMEBUFFERRENDERBUFFEREXTPROC;
import opengl.linux.x86.PFNGLFRAMEBUFFERTEXTURE2DEXTPROC;
import opengl.linux.x86.PFNGLRENDERBUFFERSTORAGEEXTPROC;
import opengl.linux.x86.glut_h;
import panamagl.Debug;
import panamagl.Image;
import panamagl.offscreen.AFBO;
import panamagl.offscreen.FBO;
import panamagl.opengl.GL;
import panamagl.opengl.GLError;

/**
 * A frame buffer object, or {@link FBO_linux}, can render OpenGL into an offscreen buffer that can later
 * be converted to an {@link Image}.
 *
 * See : https://www.khronos.org/opengl/wiki/Framebuffer_Object
 * https://www.khronos.org/opengl/wiki/Common_Mistakes
 * https://www.khronos.org/opengl/wiki/Framebuffer_Object_Extension_Examples#Quick_example,_render_to_texture_(2D)
 *
 *
 * Hint : to debug this class, invoke a program using it with flag -Dpanamagl.offscreen.FBO
 *
 * @author Martin Pernollet
 */
public class FBO_linux extends AFBO implements FBO {
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
  
  protected static int INT_SIZE = 4;
  

  public FBO_linux() {
    this(0, 0);
  }

  public FBO_linux(int width, int height) {
    this.width = width;
    this.height = height;
    this.debug = Debug.check(FBO.class, FBO_linux.class);
    
    init();
  }
  
  /** 
   * Initialize pointers to OpenGL extensions allowing to perform offscreen rendering
   */
  protected void init() {
    classArena = Arena.ofShared();
    
    MemorySegment function;
    
    // glGenFramebuffers
    function = classArena.allocateFrom("glGenFramebuffersEXT");
    glGenFramebuffers = glx_h.glXGetProcAddress(function);
        
    // glBindFramebuffer
    function = classArena.allocateFrom("glBindFramebufferEXT");
    glBindFramebuffer = glx_h.glXGetProcAddress(function);
    
    // glFramebufferTexture2D
    function = classArena.allocateFrom("glFramebufferTexture2DEXT");
    glFramebufferTexture2D = glx_h.glXGetProcAddress(function);

    // glGenRenderbuffers
    function = classArena.allocateFrom("glGenRenderbuffersEXT");
    glGenRenderbuffers = glx_h.glXGetProcAddress(function);
    
    // glBindRenderbuffer
    function = classArena.allocateFrom("glBindRenderbufferEXT");
    glBindRenderbuffer = glx_h.glXGetProcAddress(function);
    
    // glRenderbufferStorage
    function = classArena.allocateFrom("glRenderbufferStorageEXT");
    glRenderbufferStorage = glx_h.glXGetProcAddress(function);
    
    // glFramebufferRenderbuffer
    function = classArena.allocateFrom("glFramebufferRenderbufferEXT");
    glFramebufferRenderbuffer = glx_h.glXGetProcAddress(function);
    
    // glCheckFramebufferStatus
    function = classArena.allocateFrom("glCheckFramebufferStatusEXT");
    glCheckFramebufferStatus = glx_h.glXGetProcAddress(function);
   
    // glDeleteRenderbuffers
    function = classArena.allocateFrom("glDeleteRenderbuffersEXT");
    glDeleteRenderbuffers = glx_h.glXGetProcAddress(function);
    
    // glDeleteFramebuffers
    function = classArena.allocateFrom("glDeleteFramebuffersEXT");
    glDeleteFramebuffers = glx_h.glXGetProcAddress(function);
    
  }
  
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
    /*if(!"AWT-EventQueue-0".equals(Thread.currentThread().getName())) {
      System.err.println("FBO_linux: Not IN AWT THREAD");
      return;
    }*/
    
    if (prepared)
      release(gl);

    prepareRenderArena();
    
    // transfert pixel Format
    Debug.debug(debug, "FBO.internalFormat : " + internalFormat + " (default GL.GL_RGBA8)");
    Debug.debug(debug, "FBO.format         : " + format + " (default GL.GL_BGRA)");

    // ------------------------
    // Generate TEXTURE buffer

    if(idTexture<=0) {
      int nTextures = 1;
      textureBufferIds = renderArena.allocate(nTextures * INT_SIZE * 1);
      gl.glGenTextures(nTextures, textureBufferIds);
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
    
    if (idFrameBuffer <= 0) {
      int nFramebuffers = 1;
      frameBufferIds = renderArena.allocate(nFramebuffers * INT_SIZE);
      PFNGLGENFRAMEBUFFERSEXTPROC.invoke(glGenFramebuffers, nFramebuffers, frameBufferIds);
      // replace >> glut_h.glGenFramebuffers(1, frameBufferIds);
      
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

    if(idRenderBuffer<=0) {
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
  public void release(GL gl) {
    // Skip release step if the FBO wasn't prepared
    if(!prepared)
      return;
    
    // Delete resources
    gl.glDeleteTextures(1, textureBufferIds);
    PFNGLDELETERENDERBUFFERSEXTPROC.invoke(glDeleteRenderbuffers, 1, renderBufferIds);
    
    // Bind 0, which means render to back buffer, as a result, fb is unbound
    PFNGLBINDFRAMEBUFFEREXTPROC.invoke(glBindFramebuffer, glut_h.GL_FRAMEBUFFER(), 0);
 
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
    // once they are collected by GC.
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
