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

import java.awt.image.BufferedImage;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.MemorySession;
import java.lang.foreign.ValueLayout;
import opengl.ubuntu.v20.glut_h;
import panamagl.Debug;
import panamagl.Image;
import panamagl.canvas.AWTImage;
import panamagl.offscreen.FBO;
import panamagl.opengl.GL;
import panamagl.opengl.GLError;
import panamagl.utils.AWTImageCopy;
import panamagl.utils.GraphicsUtils;
import panamagl.utils.ImageCopy;
import panamagl.utils.ImageUtils;

/**
 * A frame buffer object, or {@link FBO_linux}, can render OpenGL into an offscreen buffer that can later
 * be converted to a {@link BufferedImage}.
 *
 * See : https://www.khronos.org/opengl/wiki/Framebuffer_Object
 * https://www.khronos.org/opengl/wiki/Common_Mistakes
 * https://www.khronos.org/opengl/wiki/Framebuffer_Object_Extension_Examples#Quick_example,_render_to_texture_(2D)
 *
 *
 * Hint : to debug this class, invoke a program using it with flag -Dopengl.fbo.FBO
 *
 * @author Martin Pernollet
 */
public class FBO_linux implements FBO {
  // default
  int level = 0;
  int width = 256;
  int height = 256;
  int border = 0;
  int channels = 4; // RGBA

  boolean flipY = true;

  // undefined yes
  int format = -1;
  int internalFormat = -1;
  int textureType = -1;

  boolean debug = Debug.check(FBO_linux.class);

  // supposed to copy to BufferedImage faster when true
  // using false allows to make copy by tweaking bytes
  // which is useful for debugging
  boolean arrayExport = true;

  int idTexture = -1;
  int idFrameBuffer = -1;
  int idRenderBuffer = -1;
  
  //MemorySession scope;
  MemorySegment frameBufferIds;
  MemorySegment renderBufferIds;
  MemorySegment textureBufferIds;
  MemorySegment pixelBuffer;
  
  
  @SuppressWarnings("rawtypes")
  ImageCopy copy = new AWTImageCopy();


  // indicates dimensions have changed
  // and FBO must reprepared
  boolean prepared = false;


  public FBO_linux() {}

  public FBO_linux(int width, int height) {
    this.width = width;
    this.height = height;
  }

  /** Prepare resources held by this FBO utility.*/
  @Override
  public void prepare(GL gl) {
    
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
    internalFormat = GL.GL_RGBA8;// GL.GL_BGRA;
    textureType = GL.GL_UNSIGNED_BYTE;

    Debug.debug(debug, "FBO.internalFormat : " + internalFormat + " (default GL.GL_RGBA8)");
    Debug.debug(debug, "FBO.format         : " + format + " (default GL.GL_BGRA)");

    // ------------------------
    // Generate TEXTURE buffer

    textureBufferIds = MemorySegment.allocateNative(1 * 4 * 3, MemorySession.openImplicit());
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
    
    pixelBuffer = MemorySegment.allocateNative(byteSize, MemorySession.openImplicit());
    gl.glTexImage2D(GL.GL_TEXTURE_2D, level, internalFormat, width, height, border, format,
        textureType, pixelBuffer);
    

    // -------------------------
    // Generate FRAME buffer
    frameBufferIds = MemorySegment.allocateNative(4, MemorySession.openImplicit());
 // >>>>>> glut_h.glGenFramebuffers(1, frameBufferIds);
    idFrameBuffer = (int) frameBufferIds.get(ValueLayout.JAVA_INT, 0);

    Debug.debug(debug, "FBO: Got FB ID : " + idFrameBuffer);

    // Check errors
    if (idFrameBuffer == 0) {
      diagnoseError(gl, "framebuffer");
    }


    // Bind frame buffer
 // >>>>>> glut_h.glBindFramebuffer(glut_h.GL_FRAMEBUFFER(), idFrameBuffer);

    // Attach 2D texture to this FBO
 // >>>>>> glut_h.glFramebufferTexture2D(glut_h.GL_FRAMEBUFFER(), glut_h.GL_COLOR_ATTACHMENT0(), GL.GL_TEXTURE_2D, idTexture, 0);

    // -------------------------
    // Generate RENDER buffer

    renderBufferIds = MemorySegment.allocateNative(4, MemorySession.openImplicit());
 // >>>>>> glut_h.glGenRenderbuffers(1, renderBufferIds);
    idRenderBuffer = (int) renderBufferIds.get(ValueLayout.JAVA_INT, 0);

    // Check for error after reading
    GLError.checkAndThrow(gl);
    
    Debug.debug(debug, "FBO: Got RenderBuffer ID : " + idRenderBuffer);

    // Bind render buffer
 // >>>>>>  glut_h.glBindRenderbuffer(glut_h.GL_RENDERBUFFER(), idRenderBuffer);
 // >>>>>> glut_h.glRenderbufferStorage(glut_h.GL_RENDERBUFFER(), GL.GL_DEPTH_COMPONENT24, width, height);

    
    // -------------------------
    // Attach depth buffer to FBO

 // >>>>>> glut_h.glFramebufferRenderbuffer(glut_h.GL_FRAMEBUFFER(), glut_h.GL_DEPTH_ATTACHMENT(), glut_h.GL_RENDERBUFFER(), idRenderBuffer);

    // -------------------------
    // Does the GPU support current FBO configuration?

    int status = -1;// >>>>>> glut_h.glCheckFramebufferStatus(glut_h.GL_FRAMEBUFFER());

    if (status != glut_h.GL_FRAMEBUFFER_COMPLETE()) {
      throw new RuntimeException("Incomplete framebuffer, not supporting current FBO config : "
          + status + " != GL_FRAMEBUFFER_COMPLETE (" + glut_h.GL_FRAMEBUFFER_COMPLETE() + ")");
    }

    // -------------------------
    // and now you can render to GL_TEXTURE_2D

 // >>>>>> glut_h.glBindFramebuffer(glut_h.GL_FRAMEBUFFER(), idFrameBuffer);
    gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
    gl.glClearDepth(1.0f);
    gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);

    // Mark as prepared
    prepared = true;

    Debug.debug(debug, "FBO: Prepared! ");
  }

  protected void diagnoseError(GL gl, String item) {
    GLError e = GLError.get(gl);

    if (e != null) {
      e.throwRuntimeException();
    } else {
      System.err.println("FBO: " + item
          + " handle=0 but get no OpenGL error. This may happen if the call was not issued from main thread on macOS");
    }
    // https://stackoverflow.com/questions/2985034/glgentextures-keeps-returing-0s
  }

  /** Release resources held by this FBO utility.*/
  @Override
  public void release(GL gl) {
    // Delete resources
    gl.glDeleteTextures(1, textureBufferIds);
    
 // >>>>>> glut_h.glDeleteRenderbuffers(1, renderBufferIds);
    // Bind 0, which means render to back buffer, as a result, fb is unbound
 // >>>>>> glut_h.glBindFramebuffer(glut_h.GL_FRAMEBUFFER(), 0);
 // >>>>>> glut_h.glDeleteFramebuffers(1, frameBufferIds);

    // FIXME : Not mapped exception is not relevant
    // FIXME : See if later versions of Panama do not throw exception
    boolean unload = false;
    if(unload) {
      textureBufferIds.unload(); 
      renderBufferIds.unload(); 
      frameBufferIds.unload();
      pixelBuffer.unload();
    }
    else {
      Debug.debug(debug, "FBO : Skip unload as it fails with 'not mapped segment' error");
    }

    prepared = false;

    Debug.debug(debug, "FBO: Resources released !");

  }

  @SuppressWarnings("unchecked")
  @Override
  public Image<?> getImage(GL gl) {

    // Initialize buffers if they are not ready or if their expected size changed
    if (!prepared)
      prepare(gl);

    // Init output image with the buffer size and color encoding
    //BufferedImage out = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
    
    // Try an image format derived from default screen/gpu to avoid conversion
    BufferedImage out = GraphicsUtils.createCompatibleImage(width, height);
    
    // Reading pixels
    int nBytes = width * height * channels;
    
    // The segments created in this function will be destroyed
    // one the below scope and allocator are collected by GC.
    MemorySession session = MemorySession.openImplicit();
    MemorySegment pixelsRead = MemorySegment.allocateNative(nBytes, session);
    gl.glReadPixels(0, 0, width, height, format, textureType, pixelsRead);
    
    // Check for error after reading
    GLError.checkAndThrow(gl);
    
    Debug.debug(debug, "FBO: Will read " + nBytes + " bytes due to " + width + "x" + height + " pixels");


    // Copy pixels to buffered image
    if (arrayExport)
      copy.fromBGRABufferToImageArray(pixelsRead, out, width, height);
    else
      copy.fromBGRABufferToImage(pixelsRead, out, width, height, channels);
    
    if(flipY)
      out = ImageUtils.flipVertically(out);
    

    Debug.debug(debug, "FBO: Image created !");


    // FIXME : Not mapped exception is not relevant
    // FIXME : See if later versions of Panama do not throw exception
    //Debug.debug(debug, "FBO.pixelsRead state - loaded:" + pixelsRead.isLoaded() + " mapped:" + pixelsRead.isMapped() + " native:" + pixelsRead.isNative());
    Debug.debug(debug, "FBO.pixelsRead state - mapped:" + pixelsRead.isMapped() + " native:" + pixelsRead.isNative());
    
    
    // Bind 0, which means render to back buffer
    // >>>>>> glut_h.glBindFramebuffer(glut_h.GL_FRAMEBUFFER(), 0);

    
    //pixelsRead.unload();
    //pixelsRead.
    //session.close();
    
    return new AWTImage(out);
  }

  @Override
  public void resize(int width, int height) {
    if (this.width != width || this.height != height) {
      this.width = width;
      this.height = height;
      this.prepared = false;
    }
  }

  @Override
  public int getWidth() {
    return width;
  }

  @Override
  public int getHeight() {
    return height;
  }

  @Override
  public boolean isFlipY() {
    return flipY;
  }

  @Override
  public void setFlipY(boolean flipY) {
    this.flipY = flipY;
  }
}
