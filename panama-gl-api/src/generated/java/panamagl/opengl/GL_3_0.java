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

public interface GL_3_0  {
  public static final int GL_COMPARE_REF_TO_TEXTURE = 0x884E;
  public static final int GL_CLIP_DISTANCE0 = 0x3000;
  public static final int GL_CLIP_DISTANCE1 = 0x3001;
  public static final int GL_CLIP_DISTANCE2 = 0x3002;
  public static final int GL_CLIP_DISTANCE3 = 0x3003;
  public static final int GL_CLIP_DISTANCE4 = 0x3004;
  public static final int GL_CLIP_DISTANCE5 = 0x3005;
  public static final int GL_CLIP_DISTANCE6 = 0x3006;
  public static final int GL_CLIP_DISTANCE7 = 0x3007;
  public static final int GL_MAX_CLIP_DISTANCES = 0x0D32;
  public static final int GL_MAJOR_VERSION = 0x821B;
  public static final int GL_MINOR_VERSION = 0x821C;
  public static final int GL_NUM_EXTENSIONS = 0x821D;
  public static final int GL_CONTEXT_FLAGS = 0x821E;
  public static final int GL_COMPRESSED_RED = 0x8225;
  public static final int GL_COMPRESSED_RG = 0x8226;
  public static final int GL_CONTEXT_FLAG_FORWARD_COMPATIBLE_BIT = 0x00000001;
  public static final int GL_RGBA32F = 0x8814;
  public static final int GL_RGB32F = 0x8815;
  public static final int GL_RGBA16F = 0x881A;
  public static final int GL_RGB16F = 0x881B;
  public static final int GL_VERTEX_ATTRIB_ARRAY_INTEGER = 0x88FD;
  public static final int GL_MAX_ARRAY_TEXTURE_LAYERS = 0x88FF;
  public static final int GL_MIN_PROGRAM_TEXEL_OFFSET = 0x8904;
  public static final int GL_MAX_PROGRAM_TEXEL_OFFSET = 0x8905;
  public static final int GL_CLAMP_READ_COLOR = 0x891C;
  public static final int GL_FIXED_ONLY = 0x891D;
  public static final int GL_MAX_VARYING_COMPONENTS = 0x8B4B;
  public static final int GL_TEXTURE_1D_ARRAY = 0x8C18;
  public static final int GL_PROXY_TEXTURE_1D_ARRAY = 0x8C19;
  public static final int GL_TEXTURE_2D_ARRAY = 0x8C1A;
  public static final int GL_PROXY_TEXTURE_2D_ARRAY = 0x8C1B;
  public static final int GL_TEXTURE_BINDING_1D_ARRAY = 0x8C1C;
  public static final int GL_TEXTURE_BINDING_2D_ARRAY = 0x8C1D;
  public static final int GL_R11F_G11F_B10F = 0x8C3A;
  public static final int GL_UNSIGNED_INT_10F_11F_11F_REV = 0x8C3B;
  public static final int GL_RGB9_E5 = 0x8C3D;
  public static final int GL_UNSIGNED_INT_5_9_9_9_REV = 0x8C3E;
  public static final int GL_TEXTURE_SHARED_SIZE = 0x8C3F;
  public static final int GL_TRANSFORM_FEEDBACK_VARYING_MAX_LENGTH = 0x8C76;
  public static final int GL_TRANSFORM_FEEDBACK_BUFFER_MODE = 0x8C7F;
  public static final int GL_MAX_TRANSFORM_FEEDBACK_SEPARATE_COMPONENTS = 0x8C80;
  public static final int GL_TRANSFORM_FEEDBACK_VARYINGS = 0x8C83;
  public static final int GL_TRANSFORM_FEEDBACK_BUFFER_START = 0x8C84;
  public static final int GL_TRANSFORM_FEEDBACK_BUFFER_SIZE = 0x8C85;
  public static final int GL_PRIMITIVES_GENERATED = 0x8C87;
  public static final int GL_TRANSFORM_FEEDBACK_PRIMITIVES_WRITTEN = 0x8C88;
  public static final int GL_RASTERIZER_DISCARD = 0x8C89;
  public static final int GL_MAX_TRANSFORM_FEEDBACK_INTERLEAVED_COMPONENTS = 0x8C8A;
  public static final int GL_MAX_TRANSFORM_FEEDBACK_SEPARATE_ATTRIBS = 0x8C8B;
  public static final int GL_INTERLEAVED_ATTRIBS = 0x8C8C;
  public static final int GL_SEPARATE_ATTRIBS = 0x8C8D;
  public static final int GL_TRANSFORM_FEEDBACK_BUFFER = 0x8C8E;
  public static final int GL_TRANSFORM_FEEDBACK_BUFFER_BINDING = 0x8C8F;
  public static final int GL_RGBA32UI = 0x8D70;
  public static final int GL_RGB32UI = 0x8D71;
  public static final int GL_RGBA16UI = 0x8D76;
  public static final int GL_RGB16UI = 0x8D77;
  public static final int GL_RGBA8UI = 0x8D7C;
  public static final int GL_RGB8UI = 0x8D7D;
  public static final int GL_RGBA32I = 0x8D82;
  public static final int GL_RGB32I = 0x8D83;
  public static final int GL_RGBA16I = 0x8D88;
  public static final int GL_RGB16I = 0x8D89;
  public static final int GL_RGBA8I = 0x8D8E;
  public static final int GL_RGB8I = 0x8D8F;
  public static final int GL_RED_INTEGER = 0x8D94;
  public static final int GL_GREEN_INTEGER = 0x8D95;
  public static final int GL_BLUE_INTEGER = 0x8D96;
  public static final int GL_RGB_INTEGER = 0x8D98;
  public static final int GL_RGBA_INTEGER = 0x8D99;
  public static final int GL_BGR_INTEGER = 0x8D9A;
  public static final int GL_BGRA_INTEGER = 0x8D9B;
  public static final int GL_SAMPLER_1D_ARRAY = 0x8DC0;
  public static final int GL_SAMPLER_2D_ARRAY = 0x8DC1;
  public static final int GL_SAMPLER_1D_ARRAY_SHADOW = 0x8DC3;
  public static final int GL_SAMPLER_2D_ARRAY_SHADOW = 0x8DC4;
  public static final int GL_SAMPLER_CUBE_SHADOW = 0x8DC5;
  public static final int GL_UNSIGNED_INT_VEC2 = 0x8DC6;
  public static final int GL_UNSIGNED_INT_VEC3 = 0x8DC7;
  public static final int GL_UNSIGNED_INT_VEC4 = 0x8DC8;
  public static final int GL_INT_SAMPLER_1D = 0x8DC9;
  public static final int GL_INT_SAMPLER_2D = 0x8DCA;
  public static final int GL_INT_SAMPLER_3D = 0x8DCB;
  public static final int GL_INT_SAMPLER_CUBE = 0x8DCC;
  public static final int GL_INT_SAMPLER_1D_ARRAY = 0x8DCE;
  public static final int GL_INT_SAMPLER_2D_ARRAY = 0x8DCF;
  public static final int GL_UNSIGNED_INT_SAMPLER_1D = 0x8DD1;
  public static final int GL_UNSIGNED_INT_SAMPLER_2D = 0x8DD2;
  public static final int GL_UNSIGNED_INT_SAMPLER_3D = 0x8DD3;
  public static final int GL_UNSIGNED_INT_SAMPLER_CUBE = 0x8DD4;
  public static final int GL_UNSIGNED_INT_SAMPLER_1D_ARRAY = 0x8DD6;
  public static final int GL_UNSIGNED_INT_SAMPLER_2D_ARRAY = 0x8DD7;
  public static final int GL_QUERY_WAIT = 0x8E13;
  public static final int GL_QUERY_NO_WAIT = 0x8E14;
  public static final int GL_QUERY_BY_REGION_WAIT = 0x8E15;
  public static final int GL_QUERY_BY_REGION_NO_WAIT = 0x8E16;
  public static final int GL_BUFFER_ACCESS_FLAGS = 0x911F;
  public static final int GL_BUFFER_MAP_LENGTH = 0x9120;
  public static final int GL_BUFFER_MAP_OFFSET = 0x9121;
  public void glColorMaski(int index, byte r, byte g, byte b, byte a);
  public void glGetBooleani_v(int target, int index, Addressable data);
  public void glGetIntegeri_v(int target, int index, Addressable data);
  public void glEnablei(int target, int index);
  public void glDisablei(int target, int index);
  public byte glIsEnabledi(int target, int index);
  public void glBeginTransformFeedback(int primitiveMode);
  public void glEndTransformFeedback();
  public void glBindBufferRange(int target, int index, int buffer, long offset, long size);
  public void glBindBufferBase(int target, int index, int buffer);
  public void glTransformFeedbackVaryings(int program, int count, Addressable varyings, int bufferMode);
  public void glGetTransformFeedbackVarying(int program, int index, int bufSize, Addressable length, Addressable size, Addressable type, Addressable name);
  public void glClampColor(int target, int clamp);
  public void glBeginConditionalRender(int id, int mode);
  public void glEndConditionalRender();
  public void glVertexAttribIPointer(int index, int size, int type, int stride, Addressable pointer);
  public void glGetVertexAttribIiv(int index, int pname, Addressable params);
  public void glGetVertexAttribIuiv(int index, int pname, Addressable params);
  public void glVertexAttribI1i(int index, int x);
  public void glVertexAttribI2i(int index, int x, int y);
  public void glVertexAttribI3i(int index, int x, int y, int z);
  public void glVertexAttribI4i(int index, int x, int y, int z, int w);
  public void glVertexAttribI1ui(int index, int x);
  public void glVertexAttribI2ui(int index, int x, int y);
  public void glVertexAttribI3ui(int index, int x, int y, int z);
  public void glVertexAttribI4ui(int index, int x, int y, int z, int w);
  public void glVertexAttribI1iv(int index, Addressable v);
  public void glVertexAttribI2iv(int index, Addressable v);
  public void glVertexAttribI3iv(int index, Addressable v);
  public void glVertexAttribI4iv(int index, Addressable v);
  public void glVertexAttribI1uiv(int index, Addressable v);
  public void glVertexAttribI2uiv(int index, Addressable v);
  public void glVertexAttribI3uiv(int index, Addressable v);
  public void glVertexAttribI4uiv(int index, Addressable v);
  public void glVertexAttribI4bv(int index, Addressable v);
  public void glVertexAttribI4sv(int index, Addressable v);
  public void glVertexAttribI4ubv(int index, Addressable v);
  public void glVertexAttribI4usv(int index, Addressable v);
  public void glGetUniformuiv(int program, int location, Addressable params);
  public void glBindFragDataLocation(int program, int color, Addressable name);
  public int glGetFragDataLocation(int program, Addressable name);
  public void glUniform1ui(int location, int v0);
  public void glUniform2ui(int location, int v0, int v1);
  public void glUniform3ui(int location, int v0, int v1, int v2);
  public void glUniform4ui(int location, int v0, int v1, int v2, int v3);
  public void glUniform1uiv(int location, int count, Addressable value);
  public void glUniform2uiv(int location, int count, Addressable value);
  public void glUniform3uiv(int location, int count, Addressable value);
  public void glUniform4uiv(int location, int count, Addressable value);
  public void glTexParameterIiv(int target, int pname, Addressable params);
  public void glTexParameterIuiv(int target, int pname, Addressable params);
  public void glGetTexParameterIiv(int target, int pname, Addressable params);
  public void glGetTexParameterIuiv(int target, int pname, Addressable params);
  public void glClearBufferiv(int buffer, int drawbuffer, Addressable value);
  public void glClearBufferuiv(int buffer, int drawbuffer, Addressable value);
  public void glClearBufferfv(int buffer, int drawbuffer, Addressable value);
  public void glClearBufferfi(int buffer, int drawbuffer, float depth, int stencil);
  public String glGetStringi(int name, int index);
  public static final int GL_DEPTH_COMPONENT32F = 0x8CAC;
  public static final int GL_DEPTH32F_STENCIL8 = 0x8CAD;
  public static final int GL_FLOAT_32_UNSIGNED_INT_24_8_REV = 0x8DAD;
  public static final int GL_INVALID_FRAMEBUFFER_OPERATION = 0x0506;
  public static final int GL_FRAMEBUFFER_ATTACHMENT_COLOR_ENCODING = 0x8210;
  public static final int GL_FRAMEBUFFER_ATTACHMENT_COMPONENT_TYPE = 0x8211;
  public static final int GL_FRAMEBUFFER_ATTACHMENT_RED_SIZE = 0x8212;
  public static final int GL_FRAMEBUFFER_ATTACHMENT_GREEN_SIZE = 0x8213;
  public static final int GL_FRAMEBUFFER_ATTACHMENT_BLUE_SIZE = 0x8214;
  public static final int GL_FRAMEBUFFER_ATTACHMENT_ALPHA_SIZE = 0x8215;
  public static final int GL_FRAMEBUFFER_ATTACHMENT_DEPTH_SIZE = 0x8216;
  public static final int GL_FRAMEBUFFER_ATTACHMENT_STENCIL_SIZE = 0x8217;
  public static final int GL_FRAMEBUFFER_DEFAULT = 0x8218;
  public static final int GL_FRAMEBUFFER_UNDEFINED = 0x8219;
  public static final int GL_DEPTH_STENCIL_ATTACHMENT = 0x821A;
  public static final int GL_MAX_RENDERBUFFER_SIZE = 0x84E8;
  public static final int GL_DEPTH_STENCIL = 0x84F9;
  public static final int GL_UNSIGNED_INT_24_8 = 0x84FA;
  public static final int GL_DEPTH24_STENCIL8 = 0x88F0;
  public static final int GL_TEXTURE_STENCIL_SIZE = 0x88F1;
  public static final int GL_TEXTURE_RED_TYPE = 0x8C10;
  public static final int GL_TEXTURE_GREEN_TYPE = 0x8C11;
  public static final int GL_TEXTURE_BLUE_TYPE = 0x8C12;
  public static final int GL_TEXTURE_ALPHA_TYPE = 0x8C13;
  public static final int GL_TEXTURE_DEPTH_TYPE = 0x8C16;
  public static final int GL_UNSIGNED_NORMALIZED = 0x8C17;
  public static final int GL_FRAMEBUFFER_BINDING = 0x8CA6;
  public static final int GL_DRAW_FRAMEBUFFER_BINDING = 0x8CA6;
  public static final int GL_RENDERBUFFER_BINDING = 0x8CA7;
  public static final int GL_READ_FRAMEBUFFER = 0x8CA8;
  public static final int GL_DRAW_FRAMEBUFFER = 0x8CA9;
  public static final int GL_READ_FRAMEBUFFER_BINDING = 0x8CAA;
  public static final int GL_RENDERBUFFER_SAMPLES = 0x8CAB;
  public static final int GL_FRAMEBUFFER_ATTACHMENT_OBJECT_TYPE = 0x8CD0;
  public static final int GL_FRAMEBUFFER_ATTACHMENT_OBJECT_NAME = 0x8CD1;
  public static final int GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_LEVEL = 0x8CD2;
  public static final int GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_CUBE_MAP_FACE = 0x8CD3;
  public static final int GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_LAYER = 0x8CD4;
  public static final int GL_FRAMEBUFFER_COMPLETE = 0x8CD5;
  public static final int GL_FRAMEBUFFER_INCOMPLETE_ATTACHMENT = 0x8CD6;
  public static final int GL_FRAMEBUFFER_INCOMPLETE_MISSING_ATTACHMENT = 0x8CD7;
  public static final int GL_FRAMEBUFFER_INCOMPLETE_DRAW_BUFFER = 0x8CDB;
  public static final int GL_FRAMEBUFFER_INCOMPLETE_READ_BUFFER = 0x8CDC;
  public static final int GL_FRAMEBUFFER_UNSUPPORTED = 0x8CDD;
  public static final int GL_MAX_COLOR_ATTACHMENTS = 0x8CDF;
  public static final int GL_COLOR_ATTACHMENT0 = 0x8CE0;
  public static final int GL_COLOR_ATTACHMENT1 = 0x8CE1;
  public static final int GL_COLOR_ATTACHMENT2 = 0x8CE2;
  public static final int GL_COLOR_ATTACHMENT3 = 0x8CE3;
  public static final int GL_COLOR_ATTACHMENT4 = 0x8CE4;
  public static final int GL_COLOR_ATTACHMENT5 = 0x8CE5;
  public static final int GL_COLOR_ATTACHMENT6 = 0x8CE6;
  public static final int GL_COLOR_ATTACHMENT7 = 0x8CE7;
  public static final int GL_COLOR_ATTACHMENT8 = 0x8CE8;
  public static final int GL_COLOR_ATTACHMENT9 = 0x8CE9;
  public static final int GL_COLOR_ATTACHMENT10 = 0x8CEA;
  public static final int GL_COLOR_ATTACHMENT11 = 0x8CEB;
  public static final int GL_COLOR_ATTACHMENT12 = 0x8CEC;
  public static final int GL_COLOR_ATTACHMENT13 = 0x8CED;
  public static final int GL_COLOR_ATTACHMENT14 = 0x8CEE;
  public static final int GL_COLOR_ATTACHMENT15 = 0x8CEF;
  public static final int GL_COLOR_ATTACHMENT16 = 0x8CF0;
  public static final int GL_COLOR_ATTACHMENT17 = 0x8CF1;
  public static final int GL_COLOR_ATTACHMENT18 = 0x8CF2;
  public static final int GL_COLOR_ATTACHMENT19 = 0x8CF3;
  public static final int GL_COLOR_ATTACHMENT20 = 0x8CF4;
  public static final int GL_COLOR_ATTACHMENT21 = 0x8CF5;
  public static final int GL_COLOR_ATTACHMENT22 = 0x8CF6;
  public static final int GL_COLOR_ATTACHMENT23 = 0x8CF7;
  public static final int GL_COLOR_ATTACHMENT24 = 0x8CF8;
  public static final int GL_COLOR_ATTACHMENT25 = 0x8CF9;
  public static final int GL_COLOR_ATTACHMENT26 = 0x8CFA;
  public static final int GL_COLOR_ATTACHMENT27 = 0x8CFB;
  public static final int GL_COLOR_ATTACHMENT28 = 0x8CFC;
  public static final int GL_COLOR_ATTACHMENT29 = 0x8CFD;
  public static final int GL_COLOR_ATTACHMENT30 = 0x8CFE;
  public static final int GL_COLOR_ATTACHMENT31 = 0x8CFF;
  public static final int GL_DEPTH_ATTACHMENT = 0x8D00;
  public static final int GL_STENCIL_ATTACHMENT = 0x8D20;
  public static final int GL_FRAMEBUFFER = 0x8D40;
  public static final int GL_RENDERBUFFER = 0x8D41;
  public static final int GL_RENDERBUFFER_WIDTH = 0x8D42;
  public static final int GL_RENDERBUFFER_HEIGHT = 0x8D43;
  public static final int GL_RENDERBUFFER_INTERNAL_FORMAT = 0x8D44;
  public static final int GL_STENCIL_INDEX1 = 0x8D46;
  public static final int GL_STENCIL_INDEX4 = 0x8D47;
  public static final int GL_STENCIL_INDEX8 = 0x8D48;
  public static final int GL_STENCIL_INDEX16 = 0x8D49;
  public static final int GL_RENDERBUFFER_RED_SIZE = 0x8D50;
  public static final int GL_RENDERBUFFER_GREEN_SIZE = 0x8D51;
  public static final int GL_RENDERBUFFER_BLUE_SIZE = 0x8D52;
  public static final int GL_RENDERBUFFER_ALPHA_SIZE = 0x8D53;
  public static final int GL_RENDERBUFFER_DEPTH_SIZE = 0x8D54;
  public static final int GL_RENDERBUFFER_STENCIL_SIZE = 0x8D55;
  public static final int GL_FRAMEBUFFER_INCOMPLETE_MULTISAMPLE = 0x8D56;
  public static final int GL_MAX_SAMPLES = 0x8D57;
  public static final int GL_INDEX = 0x8222;
  public byte glIsRenderbuffer(int renderbuffer);
  public void glBindRenderbuffer(int target, int renderbuffer);
  public void glDeleteRenderbuffers(int n, Addressable renderbuffers);
  public void glGenRenderbuffers(int n, Addressable renderbuffers);
  public void glRenderbufferStorage(int target, int internalformat, int width, int height);
  public void glGetRenderbufferParameteriv(int target, int pname, Addressable params);
  public byte glIsFramebuffer(int framebuffer);
  public void glBindFramebuffer(int target, int framebuffer);
  public void glDeleteFramebuffers(int n, Addressable framebuffers);
  public void glGenFramebuffers(int n, Addressable framebuffers);
  public int glCheckFramebufferStatus(int target);
  public void glFramebufferTexture1D(int target, int attachment, int textarget, int texture, int level);
  public void glFramebufferTexture2D(int target, int attachment, int textarget, int texture, int level);
  public void glFramebufferTexture3D(int target, int attachment, int textarget, int texture, int level, int zoffset);
  public void glFramebufferRenderbuffer(int target, int attachment, int renderbuffertarget, int renderbuffer);
  public void glGetFramebufferAttachmentParameteriv(int target, int attachment, int pname, Addressable params);
  public void glGenerateMipmap(int target);
  public void glBlitFramebuffer(int srcX0, int srcY0, int srcX1, int srcY1, int dstX0, int dstY0, int dstX1, int dstY1, int mask, int filter);
  public void glRenderbufferStorageMultisample(int target, int samples, int internalformat, int width, int height);
  public void glFramebufferTextureLayer(int target, int attachment, int texture, int level, int layer);
  public static final int GL_TEXTURE_LUMINANCE_TYPE = 0x8C14;
  public static final int GL_TEXTURE_INTENSITY_TYPE = 0x8C15;
  public static final int GL_FRAMEBUFFER_SRGB = 0x8DB9;
  public static final int GL_HALF_FLOAT = 0x140B;
  public static final int GL_MAP_READ_BIT = 0x0001;
  public static final int GL_MAP_WRITE_BIT = 0x0002;
  public static final int GL_MAP_INVALIDATE_RANGE_BIT = 0x0004;
  public static final int GL_MAP_INVALIDATE_BUFFER_BIT = 0x0008;
  public static final int GL_MAP_FLUSH_EXPLICIT_BIT = 0x0010;
  public static final int GL_MAP_UNSYNCHRONIZED_BIT = 0x0020;
  public MemoryAddress glMapBufferRange(int target, long offset, long length, int access);
  public void glFlushMappedBufferRange(int target, long offset, long length);
  public static final int GL_COMPRESSED_RED_RGTC1 = 0x8DBB;
  public static final int GL_COMPRESSED_SIGNED_RED_RGTC1 = 0x8DBC;
  public static final int GL_COMPRESSED_RG_RGTC2 = 0x8DBD;
  public static final int GL_COMPRESSED_SIGNED_RG_RGTC2 = 0x8DBE;
  public static final int GL_RG = 0x8227;
  public static final int GL_RG_INTEGER = 0x8228;
  public static final int GL_R8 = 0x8229;
  public static final int GL_R16 = 0x822A;
  public static final int GL_RG8 = 0x822B;
  public static final int GL_RG16 = 0x822C;
  public static final int GL_R16F = 0x822D;
  public static final int GL_R32F = 0x822E;
  public static final int GL_RG16F = 0x822F;
  public static final int GL_RG32F = 0x8230;
  public static final int GL_R8I = 0x8231;
  public static final int GL_R8UI = 0x8232;
  public static final int GL_R16I = 0x8233;
  public static final int GL_R16UI = 0x8234;
  public static final int GL_R32I = 0x8235;
  public static final int GL_R32UI = 0x8236;
  public static final int GL_RG8I = 0x8237;
  public static final int GL_RG8UI = 0x8238;
  public static final int GL_RG16I = 0x8239;
  public static final int GL_RG16UI = 0x823A;
  public static final int GL_RG32I = 0x823B;
  public static final int GL_RG32UI = 0x823C;
  public static final int GL_VERTEX_ARRAY_BINDING = 0x85B5;
  public static final int GL_CLAMP_VERTEX_COLOR = 0x891A;
  public static final int GL_CLAMP_FRAGMENT_COLOR = 0x891B;
  public static final int GL_ALPHA_INTEGER = 0x8D97;
  public void glBindVertexArray(int array);
  public void glDeleteVertexArrays(int n, Addressable arrays);
  public void glGenVertexArrays(int n, Addressable arrays);
  public byte glIsVertexArray(int array);
}
