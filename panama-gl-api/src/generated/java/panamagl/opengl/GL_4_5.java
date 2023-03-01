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
package panamagl.opengl; 

import java.lang.foreign.*;

public interface GL_4_5 extends GL_4_4 {
  public static final int GL_CONTEXT_LOST = 0x0507;
  public void glClipControl(int origin, int depth);
  public static final int GL_LOWER_LEFT = 0x8CA1;
  public static final int GL_UPPER_LEFT = 0x8CA2;
  public static final int GL_NEGATIVE_ONE_TO_ONE = 0x935E;
  public static final int GL_ZERO_TO_ONE = 0x935F;
  public static final int GL_CLIP_ORIGIN = 0x935C;
  public static final int GL_CLIP_DEPTH_MODE = 0x935D;
  public static final int GL_QUERY_WAIT_INVERTED = 0x8E17;
  public static final int GL_QUERY_NO_WAIT_INVERTED = 0x8E18;
  public static final int GL_QUERY_BY_REGION_WAIT_INVERTED = 0x8E19;
  public static final int GL_QUERY_BY_REGION_NO_WAIT_INVERTED = 0x8E1A;
  public static final int GL_MAX_CULL_DISTANCES = 0x82F9;
  public static final int GL_MAX_COMBINED_CLIP_AND_CULL_DISTANCES = 0x82FA;
  public static final int GL_TEXTURE_TARGET = 0x1006;
  public static final int GL_QUERY_TARGET = 0x82EA;
  public static final int GL_TEXTURE_BINDING_1D = 0x8068;
  public static final int GL_TEXTURE_BINDING_1D_ARRAY = 0x8C1C;
  public static final int GL_TEXTURE_BINDING_2D = 0x8069;
  public static final int GL_TEXTURE_BINDING_2D_ARRAY = 0x8C1D;
  public static final int GL_TEXTURE_BINDING_2D_MULTISAMPLE = 0x9104;
  public static final int GL_TEXTURE_BINDING_2D_MULTISAMPLE_ARRAY = 0x9105;
  public static final int GL_TEXTURE_BINDING_3D = 0x806A;
  public static final int GL_TEXTURE_BINDING_BUFFER = 0x8C2C;
  public static final int GL_TEXTURE_BINDING_CUBE_MAP = 0x8514;
  public static final int GL_TEXTURE_BINDING_CUBE_MAP_ARRAY = 0x900A;
  public static final int GL_TEXTURE_BINDING_RECTANGLE = 0x84F6;
  public void glCreateTransformFeedbacks(int n, Addressable ids);
  public void glTransformFeedbackBufferBase(int xfb, int index, int buffer);
  public void glTransformFeedbackBufferRange(int xfb, int index, int buffer, long offset, long size);
  public void glGetTransformFeedbackiv(int xfb, int pname, Addressable param);
  public void glGetTransformFeedbacki_v(int xfb, int pname, int index, Addressable param);
  public void glGetTransformFeedbacki64_v(int xfb, int pname, int index, Addressable param);
  public void glCreateBuffers(int n, Addressable buffers);
  public void glNamedBufferStorage(int buffer, long size, Addressable data, int flags);
  public void glNamedBufferData(int buffer, long size, Addressable data, int usage);
  public void glNamedBufferSubData(int buffer, long offset, long size, Addressable data);
  public void glCopyNamedBufferSubData(int readBuffer, int writeBuffer, long readOffset, long writeOffset, long size);
  public void glClearNamedBufferData(int buffer, int internalformat, int format, int type, Addressable data);
  public void glClearNamedBufferSubData(int buffer, int internalformat, long offset, long size, int format, int type, Addressable data);
  public MemoryAddress glMapNamedBuffer(int buffer, int access);
  public MemoryAddress glMapNamedBufferRange(int buffer, long offset, long length, int access);
  public byte glUnmapNamedBuffer(int buffer);
  public void glFlushMappedNamedBufferRange(int buffer, long offset, long length);
  public void glGetNamedBufferParameteriv(int buffer, int pname, Addressable params);
  public void glGetNamedBufferParameteri64v(int buffer, int pname, Addressable params);
  public void glGetNamedBufferPointerv(int buffer, int pname, Addressable params);
  public void glGetNamedBufferSubData(int buffer, long offset, long size, Addressable data);
  public void glCreateFramebuffers(int n, Addressable framebuffers);
  public void glNamedFramebufferRenderbuffer(int framebuffer, int attachment, int renderbuffertarget, int renderbuffer);
  public void glNamedFramebufferParameteri(int framebuffer, int pname, int param);
  public void glNamedFramebufferTexture(int framebuffer, int attachment, int texture, int level);
  public void glNamedFramebufferTextureLayer(int framebuffer, int attachment, int texture, int level, int layer);
  public void glNamedFramebufferDrawBuffer(int framebuffer, int buf);
  public void glNamedFramebufferDrawBuffers(int framebuffer, int n, Addressable bufs);
  public void glNamedFramebufferReadBuffer(int framebuffer, int src);
  public void glInvalidateNamedFramebufferData(int framebuffer, int numAttachments, Addressable attachments);
  public void glInvalidateNamedFramebufferSubData(int framebuffer, int numAttachments, Addressable attachments, int x, int y, int width, int height);
  public void glClearNamedFramebufferiv(int framebuffer, int buffer, int drawbuffer, Addressable value);
  public void glClearNamedFramebufferuiv(int framebuffer, int buffer, int drawbuffer, Addressable value);
  public void glClearNamedFramebufferfv(int framebuffer, int buffer, int drawbuffer, Addressable value);
  public void glClearNamedFramebufferfi(int framebuffer, int buffer, int drawbuffer, float depth, int stencil);
  public void glBlitNamedFramebuffer(int readFramebuffer, int drawFramebuffer, int srcX0, int srcY0, int srcX1, int srcY1, int dstX0, int dstY0, int dstX1, int dstY1, int mask, int filter);
  public int glCheckNamedFramebufferStatus(int framebuffer, int target);
  public void glGetNamedFramebufferParameteriv(int framebuffer, int pname, Addressable param);
  public void glGetNamedFramebufferAttachmentParameteriv(int framebuffer, int attachment, int pname, Addressable params);
  public void glCreateRenderbuffers(int n, Addressable renderbuffers);
  public void glNamedRenderbufferStorage(int renderbuffer, int internalformat, int width, int height);
  public void glNamedRenderbufferStorageMultisample(int renderbuffer, int samples, int internalformat, int width, int height);
  public void glGetNamedRenderbufferParameteriv(int renderbuffer, int pname, Addressable params);
  public void glCreateTextures(int target, int n, Addressable textures);
  public void glTextureBuffer(int texture, int internalformat, int buffer);
  public void glTextureBufferRange(int texture, int internalformat, int buffer, long offset, long size);
  public void glTextureStorage1D(int texture, int levels, int internalformat, int width);
  public void glTextureStorage2D(int texture, int levels, int internalformat, int width, int height);
  public void glTextureStorage3D(int texture, int levels, int internalformat, int width, int height, int depth);
  public void glTextureStorage2DMultisample(int texture, int samples, int internalformat, int width, int height, byte fixedsamplelocations);
  public void glTextureStorage3DMultisample(int texture, int samples, int internalformat, int width, int height, int depth, byte fixedsamplelocations);
  public void glTextureSubImage1D(int texture, int level, int xoffset, int width, int format, int type, Addressable pixels);
  public void glTextureSubImage2D(int texture, int level, int xoffset, int yoffset, int width, int height, int format, int type, Addressable pixels);
  public void glTextureSubImage3D(int texture, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int format, int type, Addressable pixels);
  public void glCompressedTextureSubImage1D(int texture, int level, int xoffset, int width, int format, int imageSize, Addressable data);
  public void glCompressedTextureSubImage2D(int texture, int level, int xoffset, int yoffset, int width, int height, int format, int imageSize, Addressable data);
  public void glCompressedTextureSubImage3D(int texture, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int format, int imageSize, Addressable data);
  public void glCopyTextureSubImage1D(int texture, int level, int xoffset, int x, int y, int width);
  public void glCopyTextureSubImage2D(int texture, int level, int xoffset, int yoffset, int x, int y, int width, int height);
  public void glCopyTextureSubImage3D(int texture, int level, int xoffset, int yoffset, int zoffset, int x, int y, int width, int height);
  public void glTextureParameterf(int texture, int pname, float param);
  public void glTextureParameterfv(int texture, int pname, Addressable param);
  public void glTextureParameteri(int texture, int pname, int param);
  public void glTextureParameterIiv(int texture, int pname, Addressable params);
  public void glTextureParameterIuiv(int texture, int pname, Addressable params);
  public void glTextureParameteriv(int texture, int pname, Addressable param);
  public void glGenerateTextureMipmap(int texture);
  public void glBindTextureUnit(int unit, int texture);
  public void glGetTextureImage(int texture, int level, int format, int type, int bufSize, Addressable pixels);
  public void glGetCompressedTextureImage(int texture, int level, int bufSize, Addressable pixels);
  public void glGetTextureLevelParameterfv(int texture, int level, int pname, Addressable params);
  public void glGetTextureLevelParameteriv(int texture, int level, int pname, Addressable params);
  public void glGetTextureParameterfv(int texture, int pname, Addressable params);
  public void glGetTextureParameterIiv(int texture, int pname, Addressable params);
  public void glGetTextureParameterIuiv(int texture, int pname, Addressable params);
  public void glGetTextureParameteriv(int texture, int pname, Addressable params);
  public void glCreateVertexArrays(int n, Addressable arrays);
  public void glDisableVertexArrayAttrib(int vaobj, int index);
  public void glEnableVertexArrayAttrib(int vaobj, int index);
  public void glVertexArrayElementBuffer(int vaobj, int buffer);
  public void glVertexArrayVertexBuffer(int vaobj, int bindingindex, int buffer, long offset, int stride);
  public void glVertexArrayVertexBuffers(int vaobj, int first, int count, Addressable buffers, Addressable offsets, Addressable strides);
  public void glVertexArrayAttribBinding(int vaobj, int attribindex, int bindingindex);
  public void glVertexArrayAttribFormat(int vaobj, int attribindex, int size, int type, byte normalized, int relativeoffset);
  public void glVertexArrayAttribIFormat(int vaobj, int attribindex, int size, int type, int relativeoffset);
  public void glVertexArrayAttribLFormat(int vaobj, int attribindex, int size, int type, int relativeoffset);
  public void glVertexArrayBindingDivisor(int vaobj, int bindingindex, int divisor);
  public void glGetVertexArrayiv(int vaobj, int pname, Addressable param);
  public void glGetVertexArrayIndexediv(int vaobj, int index, int pname, Addressable param);
  public void glGetVertexArrayIndexed64iv(int vaobj, int index, int pname, Addressable param);
  public void glCreateSamplers(int n, Addressable samplers);
  public void glCreateProgramPipelines(int n, Addressable pipelines);
  public void glCreateQueries(int target, int n, Addressable ids);
  public void glGetQueryBufferObjecti64v(int id, int buffer, int pname, long offset);
  public void glGetQueryBufferObjectiv(int id, int buffer, int pname, long offset);
  public void glGetQueryBufferObjectui64v(int id, int buffer, int pname, long offset);
  public void glGetQueryBufferObjectuiv(int id, int buffer, int pname, long offset);
  public static final int GL_BACK = 0x0405;
  public void glMemoryBarrierByRegion(int barriers);
  public void glGetTextureSubImage(int texture, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int format, int type, int bufSize, Addressable pixels);
  public void glGetCompressedTextureSubImage(int texture, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int bufSize, Addressable pixels);
  public static final int GL_NO_ERROR = 0;
  public static final int GL_GUILTY_CONTEXT_RESET = 0x8253;
  public static final int GL_INNOCENT_CONTEXT_RESET = 0x8254;
  public static final int GL_UNKNOWN_CONTEXT_RESET = 0x8255;
  public static final int GL_RESET_NOTIFICATION_STRATEGY = 0x8256;
  public static final int GL_LOSE_CONTEXT_ON_RESET = 0x8252;
  public static final int GL_NO_RESET_NOTIFICATION = 0x8261;
  public static final int GL_CONTEXT_FLAG_ROBUST_ACCESS_BIT = 0x00000004;
  public int glGetGraphicsResetStatus();
  public void glGetnCompressedTexImage(int target, int lod, int bufSize, Addressable pixels);
  public void glGetnTexImage(int target, int level, int format, int type, int bufSize, Addressable pixels);
  public void glGetnUniformdv(int program, int location, int bufSize, Addressable params);
  public void glGetnUniformfv(int program, int location, int bufSize, Addressable params);
  public void glGetnUniformiv(int program, int location, int bufSize, Addressable params);
  public void glGetnUniformuiv(int program, int location, int bufSize, Addressable params);
  public void glReadnPixels(int x, int y, int width, int height, int format, int type, int bufSize, Addressable data);
  public void glGetnMapdv(int target, int query, int bufSize, Addressable v);
  public void glGetnMapfv(int target, int query, int bufSize, Addressable v);
  public void glGetnMapiv(int target, int query, int bufSize, Addressable v);
  public void glGetnPixelMapfv(int map, int bufSize, Addressable values);
  public void glGetnPixelMapuiv(int map, int bufSize, Addressable values);
  public void glGetnPixelMapusv(int map, int bufSize, Addressable values);
  public void glGetnPolygonStipple(int bufSize, Addressable pattern);
  public void glGetnColorTable(int target, int format, int type, int bufSize, Addressable table);
  public void glGetnConvolutionFilter(int target, int format, int type, int bufSize, Addressable image);
  public void glGetnSeparableFilter(int target, int format, int type, int rowBufSize, Addressable row, int columnBufSize, Addressable column, Addressable span);
  public void glGetnHistogram(int target, byte reset, int format, int type, int bufSize, Addressable values);
  public void glGetnMinmax(int target, byte reset, int format, int type, int bufSize, Addressable values);
  public static final int GL_COLOR_TABLE = 0x80D0;
  public static final int GL_POST_CONVOLUTION_COLOR_TABLE = 0x80D1;
  public static final int GL_POST_COLOR_MATRIX_COLOR_TABLE = 0x80D2;
  public static final int GL_PROXY_COLOR_TABLE = 0x80D3;
  public static final int GL_PROXY_POST_CONVOLUTION_COLOR_TABLE = 0x80D4;
  public static final int GL_PROXY_POST_COLOR_MATRIX_COLOR_TABLE = 0x80D5;
  public static final int GL_CONVOLUTION_1D = 0x8010;
  public static final int GL_CONVOLUTION_2D = 0x8011;
  public static final int GL_SEPARABLE_2D = 0x8012;
  public static final int GL_HISTOGRAM = 0x8024;
  public static final int GL_PROXY_HISTOGRAM = 0x8025;
  public static final int GL_MINMAX = 0x802E;
  public void glTextureBarrier();
  public static final int GL_CONTEXT_RELEASE_BEHAVIOR = 0x82FB;
  public static final int GL_NONE = 0;
  public static final int GL_CONTEXT_RELEASE_BEHAVIOR_FLUSH = 0x82FC;
}
