package panamagl.opengl; 

import java.lang.foreign.*;

public interface GL_4_4 extends GL_4_3 {
  public static final int GL_MAX_VERTEX_ATTRIB_STRIDE = 0x82E5;
  public static final int GL_PRIMITIVE_RESTART_FOR_PATCHES_SUPPORTED = 0x8221;
  public static final int GL_TEXTURE_BUFFER_BINDING = 0x8C2A;
  public static final int GL_MAP_READ_BIT = 0x0001;
  public static final int GL_MAP_WRITE_BIT = 0x0002;
  public static final int GL_MAP_PERSISTENT_BIT = 0x0040;
  public static final int GL_MAP_COHERENT_BIT = 0x0080;
  public static final int GL_DYNAMIC_STORAGE_BIT = 0x0100;
  public static final int GL_CLIENT_STORAGE_BIT = 0x0200;
  public static final int GL_CLIENT_MAPPED_BUFFER_BARRIER_BIT = 0x00004000;
  public static final int GL_BUFFER_IMMUTABLE_STORAGE = 0x821F;
  public static final int GL_BUFFER_STORAGE_FLAGS = 0x8220;
  public void glBufferStorage(int target, long size, MemorySegment data, int flags);
  public static final int GL_CLEAR_TEXTURE = 0x9365;
  public void glClearTexImage(int texture, int level, int format, int type, MemorySegment data);
  public void glClearTexSubImage(int texture, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int format, int type, MemorySegment data);
  public static final int GL_LOCATION_COMPONENT = 0x934A;
  public static final int GL_TRANSFORM_FEEDBACK_BUFFER = 0x8C8E;
  public static final int GL_TRANSFORM_FEEDBACK_BUFFER_INDEX = 0x934B;
  public static final int GL_TRANSFORM_FEEDBACK_BUFFER_STRIDE = 0x934C;
  public void glBindBuffersBase(int target, int first, int count, MemorySegment buffers);
  public void glBindBuffersRange(int target, int first, int count, MemorySegment buffers, MemorySegment offsets, MemorySegment sizes);
  public void glBindTextures(int first, int count, MemorySegment textures);
  public void glBindSamplers(int first, int count, MemorySegment samplers);
  public void glBindImageTextures(int first, int count, MemorySegment textures);
  public void glBindVertexBuffers(int first, int count, MemorySegment buffers, MemorySegment offsets, MemorySegment strides);
  public static final int GL_QUERY_BUFFER = 0x9192;
  public static final int GL_QUERY_BUFFER_BARRIER_BIT = 0x00008000;
  public static final int GL_QUERY_BUFFER_BINDING = 0x9193;
  public static final int GL_QUERY_RESULT_NO_WAIT = 0x9194;
  public static final int GL_MIRROR_CLAMP_TO_EDGE = 0x8743;
  public static final int GL_STENCIL_INDEX = 0x1901;
  public static final int GL_STENCIL_INDEX8 = 0x8D48;
  public static final int GL_UNSIGNED_INT_10F_11F_11F_REV = 0x8C3B;
}
