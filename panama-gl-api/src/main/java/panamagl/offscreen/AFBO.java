package panamagl.offscreen;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import panamagl.Debug;
import panamagl.opengl.GL;
import panamagl.opengl.GLError;

public abstract class AFBO implements FBO{
  protected boolean debug = Debug.check(FBO.class);

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

  protected int format = GL.GL_BGRA;
  protected int internalFormat = GL.GL_RGBA8;
  protected int textureType = GL.GL_UNSIGNED_BYTE;
  
  
  /** width of the canvas using this FBO for rendering */
  protected int width = 0;

  /** height of the canvas using this FBO for rendering */
  protected int height = 0;
  
  /** indicates that dimensions have changed and that buffers must be resized. */
  protected boolean prepared = false;
  
  /** id of the texture returned by the GPU */
  protected int idTexture = -1;
  /** id of the frame buffer returned by the GPU */
  protected int idFrameBuffer = -1;
  /** if of the render buffer returned by the GPU */
  protected int idRenderBuffer = -1;
  
  
  /** Data arena to create buffers shared with GPU. Will live until the buffers are necessary anymore (e.g. when the FBO is resized and pixel number changes). */
  protected Arena renderArena;

  protected MemorySegment frameBufferIds;
  protected MemorySegment renderBufferIds;
  protected MemorySegment textureBufferIds;
  protected MemorySegment pixelBuffer;  
  protected MemorySegment pixels;
  
  protected boolean auto = false;
  

  
  /** Prepare the memory manager for offscreen rendering by the GPU. */
  protected void prepareRenderArena() {
    if(renderArena ==null) {
      if(auto)
        renderArena = Arena.ofAuto();
      else
        renderArena = Arena.ofShared();
    }
  }  
  
  /** Release all memory used to manage offscreen rendering by the GPU. */
  protected void releaseRenderArena() {
    textureBufferIds = null; 
    renderBufferIds = null; 
    frameBufferIds = null;
    pixelBuffer = null;
    pixels = null;

    idTexture = -1;
    idFrameBuffer = -1;
    idRenderBuffer = -1;
    
    // free memory
    if(!auto) {
      renderArena.close();
    }
    renderArena = null;

    Debug.debug(debug, "FBO: Arena released");
  }
  
  /** Print error in console */ 
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

  // --------------------------------------------------------- //
  
  /** Set dimensions and reset 'prepared' state if the dimensions actually changed. */
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
  public boolean isPrepared() {
    return prepared;
  }
  
  
}
