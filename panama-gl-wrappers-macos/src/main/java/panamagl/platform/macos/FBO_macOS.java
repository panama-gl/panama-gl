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
package panamagl.platform.macos;

import java.awt.image.BufferedImage;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import opengl.macos.arm.glut_h;
import panamagl.Debug;
import panamagl.offscreen.AFBO;
import panamagl.offscreen.FBO;
import panamagl.opengl.GL;
import panamagl.opengl.GLError;

/**
 * A frame buffer object, or {@link FBO_macOS}, can render OpenGL into an offscreen buffer that can later
 * be converted to a {@link BufferedImage}.
 *
 * See : https://www.khronos.org/opengl/wiki/Framebuffer_Object
 * https://www.khronos.org/opengl/wiki/Common_Mistakes
 * https://www.khronos.org/opengl/wiki/Framebuffer_Object_Extension_Examples#Quick_example,_render_to_texture_(2D)
 * https://developer.apple.com/library/archive/documentation/GraphicsImaging/Conceptual/OpenGL-MacProgGuide/opengl_offscreen/opengl_offscreen.html
 *
 * Hint : to debug this class, invoke a program using it with flag -Dopengl.fbo.FBO
 *
 * @author Martin Pernollet
 */
public class FBO_macOS extends AFBO implements FBO {
  // default
  protected int level = 0;
  protected int border = 0;
  protected int channels = 4; // RGBA
  
  public FBO_macOS() {
    this(0, 0);
  }

  public FBO_macOS(int width, int height) {
    this.width = width;
    this.height = height;
    this.debug = Debug.check(FBO.class, FBO_macOS.class);
    
    init();
  }
  
  /** 
   * Initialize pointers to OpenGL extensions allowing to perform offscreen rendering
   */
  protected void init() {
    //classArena = Arena.ofShared();
  }
  
  /** Prepare resources held by this FBO utility.*/
  @Override
  public void prepare(GL gl) {
    
    if (prepared)
      release(gl);
    
    prepareRenderArena();


    // transfert pixel Format
    Debug.debug(debug, "FBO.internalFormat : " + internalFormat + " (default GL.GL_RGBA8)");
    Debug.debug(debug, "FBO.format         : " + format + " (default GL.GL_BGRA)");

    // ------------------------
    // Generate TEXTURE buffer
    
    textureBufferIds = renderArena.allocate(1 * 4 * 3);
    gl.glGenTextures(1, textureBufferIds);
    idTexture = (int) textureBufferIds.get(ValueLayout.JAVA_INT, 0);

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

    frameBufferIds = renderArena.allocate(4);
    glut_h.glGenFramebuffers(1, frameBufferIds);
    idFrameBuffer = (int) frameBufferIds.get(ValueLayout.JAVA_INT, 0);

    Debug.debug(debug, "FBO: Got FB ID : " + idFrameBuffer);

    // Check errors
    if (idFrameBuffer == 0) {
      diagnoseError(gl, "framebuffer");
    }


    // Bind frame buffer
    glut_h.glBindFramebuffer(glut_h.GL_FRAMEBUFFER(), idFrameBuffer);

    // Attach 2D texture to this FBO
    glut_h.glFramebufferTexture2D(glut_h.GL_FRAMEBUFFER(), glut_h.GL_COLOR_ATTACHMENT0(), glut_h.GL_TEXTURE_2D(),
        idTexture, 0);

    // -------------------------
    // Generate RENDER buffer

    renderBufferIds = renderArena.allocate(4);
    glut_h.glGenRenderbuffers(1, renderBufferIds);
    idRenderBuffer = (int) renderBufferIds.get(ValueLayout.JAVA_INT, 0);

    // Check for error after reading
    GLError.checkAndThrow(gl);
    
    Debug.debug(debug, "FBO: Got RenderBuffer ID : " + idRenderBuffer);

    // Bind render buffer
    glut_h.glBindRenderbuffer(glut_h.GL_RENDERBUFFER(), idRenderBuffer);
    glut_h.glRenderbufferStorage(glut_h.GL_RENDERBUFFER(), GL.GL_DEPTH_COMPONENT24, width, height);

    
    // -------------------------
    // Attach depth buffer to FBO

    glut_h.glFramebufferRenderbuffer(glut_h.GL_FRAMEBUFFER(), glut_h.GL_DEPTH_ATTACHMENT(),
        glut_h.GL_RENDERBUFFER(), idRenderBuffer);

    // -------------------------
    // Does the GPU support current FBO configuration?

    int status = glut_h.glCheckFramebufferStatus(glut_h.GL_FRAMEBUFFER());

    if (status != glut_h.GL_FRAMEBUFFER_COMPLETE()) {
      throw new RuntimeException("Incomplete framebuffer, not supporting current FBO config : "
          + status + " != GL_FRAMEBUFFER_COMPLETE (" + glut_h.GL_FRAMEBUFFER_COMPLETE() + ")");
    }

    // -------------------------
    // and now you can render to GL_TEXTURE_2D

    glut_h.glBindFramebuffer(glut_h.GL_FRAMEBUFFER(), idFrameBuffer);
    gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
    gl.glClearDepth(1.0f);
    gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);

    // Mark as prepared
    prepared = true;

    Debug.debug(debug, "FBO: Prepared! ");
  }

  /** Release resources held by this FBO utility.*/
  @Override
  public void release(GL gl) {
    // Delete resources
    gl.glDeleteTextures(1, textureBufferIds);
    
    glut_h.glDeleteRenderbuffers(1, renderBufferIds);
    unbindFramebuffer();
    glut_h.glDeleteFramebuffers(1, frameBufferIds);

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
    glut_h.glBindFramebuffer(glut_h.GL_FRAMEBUFFER(), 0);
  }
}
