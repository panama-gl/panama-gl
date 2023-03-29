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

import java.lang.foreign.MemoryAddress;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.MemorySession;
import java.lang.foreign.ValueLayout;
import glext.ubuntu.v20.PFNGLBINDFRAMEBUFFEREXTPROC;
import opengl.ubuntu.v20.PFNGLBINDRENDERBUFFEREXTPROC;
import opengl.ubuntu.v20.PFNGLCHECKFRAMEBUFFERSTATUSEXTPROC;
import opengl.ubuntu.v20.PFNGLDELETEFRAMEBUFFERSEXTPROC;
import opengl.ubuntu.v20.PFNGLDELETERENDERBUFFERSEXTPROC;
import opengl.ubuntu.v20.PFNGLFRAMEBUFFERRENDERBUFFEREXTPROC;
import opengl.ubuntu.v20.PFNGLFRAMEBUFFERTEXTURE2DEXTPROC;
import opengl.ubuntu.v20.PFNGLGENFRAMEBUFFERSEXTPROC;
import opengl.ubuntu.v20.PFNGLGENRENDERBUFFERSEXTPROC;
import opengl.ubuntu.v20.PFNGLRENDERBUFFERSTORAGEEXTPROC;
import opengl.ubuntu.v20.glut_h;
import panamagl.Debug;
import panamagl.Image;
import panamagl.offscreen.AFBO;
import panamagl.offscreen.FBO;
import panamagl.opengl.GL;
import panamagl.opengl.GLError;
import panamagl.utils.ForeignMemoryUtils;
import panamagl.utils.ForeignMemoryUtils.Mode;
import wgl.windows.x86.wgl_h;

/**
 * A frame buffer object, or {@link FBO_windows}, can render OpenGL into an offscreen buffer that can later
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
public class FBO_windows extends AFBO implements FBO {
  // default
  protected int level = 0;
  protected int border = 0;
  protected int channels = 4; // RGBA

  // formats
  protected int format = -1;
  protected int internalFormat = -1;
  protected int textureType = -1;

  protected boolean debug = Debug.check(FBO.class, FBO_windows.class);

  // supposed to copy to BufferedImage faster when true
  // using false allows to make copy by tweaking bytes
  // which is useful for debugging
  protected boolean arrayExport = true;

  protected int idTexture = -1;
  protected int idFrameBuffer = -1;
  protected int idRenderBuffer = -1;
  
  protected MemorySession scope;
  protected MemorySegment frameBufferIds;
  protected MemorySegment renderBufferIds;
  protected MemorySegment textureBufferIds;
  protected MemorySegment pixelBuffer;
  
  // dynamically loaded OpenGL functions
  protected ForeignMemoryUtils ffm;
  
  protected PFNGLGENFRAMEBUFFERSEXTPROC glGenFramebuffers;
  protected PFNGLBINDFRAMEBUFFEREXTPROC glBindFramebuffer;
  protected PFNGLFRAMEBUFFERTEXTURE2DEXTPROC glFramebufferTexture2D;

  protected PFNGLGENRENDERBUFFERSEXTPROC glGenRenderbuffers;
  protected PFNGLBINDRENDERBUFFEREXTPROC glBindRenderbuffer;
  protected PFNGLRENDERBUFFERSTORAGEEXTPROC glRenderbufferStorage;
  
  protected PFNGLFRAMEBUFFERRENDERBUFFEREXTPROC glFramebufferRenderbuffer;
  protected PFNGLCHECKFRAMEBUFFERSTATUSEXTPROC glCheckFramebufferStatus;
  
  protected PFNGLDELETERENDERBUFFERSEXTPROC glDeleteRenderbuffers;
  protected PFNGLDELETEFRAMEBUFFERSEXTPROC glDeleteFramebuffers;
  
  public FBO_windows() {
    init();
  }

  public FBO_windows(int width, int height) {
    //this.width = width;
    //this.height = height;
    
    resize(width, height);
    
    init();
  }
  
  protected void init() {
    ffm = new ForeignMemoryUtils(Mode.IMPLICIT);
    
    MemorySegment function;
    MemoryAddress address;
    
    // glGenFramebuffers
    function = ffm.alloc("glGenFramebuffersEXT");
    address = wgl_h.wglGetProcAddress(function);
    glGenFramebuffers = PFNGLGENFRAMEBUFFERSEXTPROC.ofAddress(address, ffm.getScope());
    
    // glBindFramebuffer
    function = ffm.alloc("glBindFramebufferEXT");
    address = wgl_h.wglGetProcAddress(function);
    glBindFramebuffer = PFNGLBINDFRAMEBUFFEREXTPROC.ofAddress(address, ffm.getScope());
    
    // glFramebufferTexture2D
    function = ffm.alloc("glFramebufferTexture2DEXT");
    address = wgl_h.wglGetProcAddress(function);
    glFramebufferTexture2D = PFNGLFRAMEBUFFERTEXTURE2DEXTPROC.ofAddress(address, ffm.getScope());

    // glGenRenderbuffers
    function = ffm.alloc("glGenRenderbuffersEXT");
    address = wgl_h.wglGetProcAddress(function);
    glGenRenderbuffers = PFNGLGENRENDERBUFFERSEXTPROC.ofAddress(address, ffm.getScope());
    
    // glBindRenderbuffer
    function = ffm.alloc("glBindRenderbufferEXT");
    address = wgl_h.wglGetProcAddress(function);
    glBindRenderbuffer = PFNGLBINDRENDERBUFFEREXTPROC.ofAddress(address, ffm.getScope());
    
    // glRenderbufferStorage
    function = ffm.alloc("glRenderbufferStorageEXT");
    address = wgl_h.wglGetProcAddress(function);
    glRenderbufferStorage = PFNGLRENDERBUFFERSTORAGEEXTPROC.ofAddress(address, ffm.getScope());
    
    // glFramebufferRenderbuffer
    function = ffm.alloc("glFramebufferRenderbufferEXT");
    address = wgl_h.wglGetProcAddress(function);
    glFramebufferRenderbuffer = PFNGLFRAMEBUFFERRENDERBUFFEREXTPROC.ofAddress(address, ffm.getScope());
    
    // glCheckFramebufferStatus
    function = ffm.alloc("glCheckFramebufferStatusEXT");
    address = wgl_h.wglGetProcAddress(function);
    glCheckFramebufferStatus = PFNGLCHECKFRAMEBUFFERSTATUSEXTPROC.ofAddress(address, ffm.getScope());
   
    // glDeleteRenderbuffers
    function = ffm.alloc("glDeleteRenderbuffersEXT");
    address = wgl_h.wglGetProcAddress(function);
    glDeleteRenderbuffers = PFNGLDELETERENDERBUFFERSEXTPROC.ofAddress(address, ffm.getScope());
    
    // glDeleteFramebuffers
    function = ffm.alloc("glDeleteFramebuffersEXT");
    address = wgl_h.wglGetProcAddress(function);
    glDeleteFramebuffers = PFNGLDELETEFRAMEBUFFERSEXTPROC.ofAddress(address, ffm.getScope());
    
  }
  
  // could avoid renewing buffers, but keep the same behaviour
  // than macOS for now
  boolean renewBuffers = true;

  /** Prepare resources held by this FBO utility.*/
  @Override
  public void prepare(GL gl) {
    Debug.debug(debug, "FBO: from thread " + Thread.currentThread().getName());
    
    // Check that this happens in AWT event queue, otherwise skip rendering
    // to avoid opengl exception.
    //if(!"AWT-EventQueue-0".equals(Thread.currentThread().getName()))
    //  return;
    
    if (prepared)
      release(gl);

    // ---------------------------
    // Transfert pixel Format
    // ---------------------------
    // Most GPU support BGRA
    // If you supply GL_RGBA, then the driver may have to do the swapping for you which is slow.
    // If you do use GL_BGRA, the call to pixel transfer will be much faster.
    // Note that GL_BGRA pixel transfer format is only preferred when uploading to GL_RGBA8 images.
    // When dealing with other formats, like GL_RGBA16, GL_RGBA8UI or even GL_RGBA8_SNORM, then the
    // regular GL_RGBA
    // ordering may be preferred.
    //
    // On which platforms is GL_BGRA preferred? Making a list would be too long but one example is
    // Microsoft Windows.
    // Note that with GL 4.3 or ARB_internalformat_query2, you can simply ask the implementation
    // what is the
    // preferred format with glGetInternalFormativ(GL_TEXTURE_2D, GL_RGBA8, GL_TEXTURE_IMAGE_FORMAT,
    // 1, &preferred_format).
    format = GL.GL_BGRA;
    internalFormat = GL.GL_RGBA8;
    textureType = GL.GL_UNSIGNED_BYTE;

    Debug.debug(debug, "FBO.internalFormat : " + internalFormat + " (default GL.GL_RGBA8)");
    Debug.debug(debug, "FBO.format         : " + format + " (default GL.GL_BGRA)");

    // ------------------------
    // Generate TEXTURE buffer

    if(idTexture<=0 || renewBuffers) {
      textureBufferIds = MemorySegment.allocateNative(1 * 4 * 3, MemorySession.openImplicit());
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
    
    pixelBuffer = MemorySegment.allocateNative(byteSize, MemorySession.openImplicit());
    gl.glTexImage2D(GL.GL_TEXTURE_2D, level, internalFormat, width, height, border, format,
        textureType, pixelBuffer);
    

    // -------------------------
    // Generate FRAME buffer
    
    if (idFrameBuffer <= 0 || renewBuffers) {
      frameBufferIds = MemorySegment.allocateNative(4, MemorySession.openImplicit());
      glGenFramebuffers.apply(1, frameBufferIds.address());
      // replace >> glut_h.glGenFramebuffers(1, frameBufferIds);
      
      idFrameBuffer = (int) frameBufferIds.get(ValueLayout.JAVA_INT, 0);
    }
    Debug.debug(debug, "FBO: Got FB ID : " + idFrameBuffer);

    // Check errors
    if (idFrameBuffer == 0) {
      diagnoseError(gl, "framebuffer");
    }

    // Bind frame buffer
    glBindFramebuffer.apply(glut_h.GL_FRAMEBUFFER(), idFrameBuffer);

    // Attach 2D texture to this FBO
    glFramebufferTexture2D.apply(glut_h.GL_FRAMEBUFFER_EXT(), glut_h.GL_COLOR_ATTACHMENT0_EXT(), GL.GL_TEXTURE_2D, idTexture, 0);

    
    // -------------------------
    // Generate RENDER buffer

    if(idRenderBuffer<=0 || renewBuffers) {
      renderBufferIds = MemorySegment.allocateNative(4, MemorySession.openImplicit());
      glGenRenderbuffers.apply(1, renderBufferIds.address());
      idRenderBuffer = (int) renderBufferIds.get(ValueLayout.JAVA_INT, 0);
    }
    
    // Check for error after reading
    GLError.checkAndThrow(gl);
    
    Debug.debug(debug, "FBO: Got RenderBuffer ID : " + idRenderBuffer);

    // Bind render buffer
    glBindRenderbuffer.apply(glut_h.GL_RENDERBUFFER_EXT(), idRenderBuffer);
    glRenderbufferStorage.apply(glut_h.GL_RENDERBUFFER_EXT(), GL.GL_DEPTH_COMPONENT24, width, height);

    
    // -------------------------
    // Attach depth buffer to FBO

    glFramebufferRenderbuffer.apply(glut_h.GL_FRAMEBUFFER_EXT(), glut_h.GL_DEPTH_ATTACHMENT_EXT(), glut_h.GL_RENDERBUFFER_EXT(), idRenderBuffer);

    
    // -------------------------
    // Does the GPU support current FBO configuration?

    int status = glCheckFramebufferStatus.apply(glut_h.GL_FRAMEBUFFER_EXT());

    if (status != glut_h.GL_FRAMEBUFFER_COMPLETE_EXT()) {
      throw new RuntimeException("Incomplete framebuffer, not supporting current FBO config : "
          + status + " != GL_FRAMEBUFFER_COMPLETE (" + glut_h.GL_FRAMEBUFFER_COMPLETE_EXT() + ")");
    }

    // -------------------------
    // and now you can render to GL_TEXTURE_2D
    
    glBindFramebuffer.apply(glut_h.GL_FRAMEBUFFER(), idFrameBuffer);
    
    gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
    gl.glClearDepth(1.0f);
    gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);

    // Mark as prepared
    prepared = true;

    Debug.debug(debug, "FBO: Prepared!");
  }

  protected void diagnoseError(GL gl, String item) {
    GLError e = GLError.get(gl);

    if (e != null) {
      e.throwRuntimeException();
    } else {
      System.err.println("FBO: " + item
          + " handle=0 but get no OpenGL error. This may happen if the call was not issued from AWT thread on linux");
    }
    // https://stackoverflow.com/questions/2985034/glgentextures-keeps-returing-0s
  }

  /** Release resources held by this FBO utility.*/
  @Override
  public void release(GL gl) {
    if(!renewBuffers)
      return ;
    
    // Delete resources
    gl.glDeleteTextures(1, textureBufferIds);
    glDeleteRenderbuffers.apply(1, renderBufferIds.address());
    
    // Bind 0, which means render to back buffer, as a result, fb is unbound
    glBindFramebuffer.apply(glut_h.GL_FRAMEBUFFER(), 0);
 
    glDeleteFramebuffers.apply(1, frameBufferIds.address());

    // TODO : requires shared scope to support unload
    boolean unload = false;
    if(unload) {
      textureBufferIds.unload(); 
      renderBufferIds.unload(); 
      frameBufferIds.unload();
      pixelBuffer.unload();
    }

    prepared = false;

    Debug.debug(debug, "FBO: Resources released !");
  }
  
  @Override
  public MemorySegment readPixels(GL gl) {
    // Initialize buffers if they are not ready or if their expected size changed
    if (!prepared)
      prepare(gl);

    // Reading pixels
    int nBytes = width * height * channels;
    
    // The segments created in this function will be destroyed
    // once the below scope and allocator are collected by GC.
    //MemorySession session = MemorySession.openImplicit();
    //MemorySegment pixels = MemorySegment.allocateNative(nBytes, session);
    
    if(pixels==null || pixels.byteSize()!=nBytes) {
      pixels = MemorySegment.allocateNative(nBytes, session);
    }
    else {
      //System.out.println("REUSE!!");
    }
    gl.glReadPixels(0, 0, width, height, format, textureType, pixels);
    
    // Check for error after reading
    GLError.checkAndThrow(gl);

    Debug.debug(debug, "FBO: PixelBuffer red !");
    
    // Bind 0, which means render to back buffer
    glBindFramebuffer.apply(glut_h.GL_FRAMEBUFFER(), 0);
    
    return pixels;
  }
  
  MemorySession session = MemorySession.openImplicit();
  
  MemorySegment pixels;
  
}