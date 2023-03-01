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

public interface GL_3_1 extends GL_3_0 {
  public static final int GL_SAMPLER_2D_RECT = 0x8B63;
  public static final int GL_SAMPLER_2D_RECT_SHADOW = 0x8B64;
  public static final int GL_SAMPLER_BUFFER = 0x8DC2;
  public static final int GL_INT_SAMPLER_2D_RECT = 0x8DCD;
  public static final int GL_INT_SAMPLER_BUFFER = 0x8DD0;
  public static final int GL_UNSIGNED_INT_SAMPLER_2D_RECT = 0x8DD5;
  public static final int GL_UNSIGNED_INT_SAMPLER_BUFFER = 0x8DD8;
  public static final int GL_TEXTURE_BUFFER = 0x8C2A;
  public static final int GL_MAX_TEXTURE_BUFFER_SIZE = 0x8C2B;
  public static final int GL_TEXTURE_BINDING_BUFFER = 0x8C2C;
  public static final int GL_TEXTURE_BUFFER_DATA_STORE_BINDING = 0x8C2D;
  public static final int GL_TEXTURE_RECTANGLE = 0x84F5;
  public static final int GL_TEXTURE_BINDING_RECTANGLE = 0x84F6;
  public static final int GL_PROXY_TEXTURE_RECTANGLE = 0x84F7;
  public static final int GL_MAX_RECTANGLE_TEXTURE_SIZE = 0x84F8;
  public static final int GL_R8_SNORM = 0x8F94;
  public static final int GL_RG8_SNORM = 0x8F95;
  public static final int GL_RGB8_SNORM = 0x8F96;
  public static final int GL_RGBA8_SNORM = 0x8F97;
  public static final int GL_R16_SNORM = 0x8F98;
  public static final int GL_RG16_SNORM = 0x8F99;
  public static final int GL_RGB16_SNORM = 0x8F9A;
  public static final int GL_RGBA16_SNORM = 0x8F9B;
  public static final int GL_SIGNED_NORMALIZED = 0x8F9C;
  public static final int GL_PRIMITIVE_RESTART = 0x8F9D;
  public static final int GL_PRIMITIVE_RESTART_INDEX = 0x8F9E;
  public void glDrawArraysInstanced(int mode, int first, int count, int instancecount);
  public void glDrawElementsInstanced(int mode, int count, int type, Addressable indices, int instancecount);
  public void glTexBuffer(int target, int internalformat, int buffer);
  public void glPrimitiveRestartIndex(int index);
  public static final int GL_COPY_READ_BUFFER = 0x8F36;
  public static final int GL_COPY_WRITE_BUFFER = 0x8F37;
  public void glCopyBufferSubData(int readTarget, int writeTarget, long readOffset, long writeOffset, long size);
  public static final int GL_UNIFORM_BUFFER = 0x8A11;
  public static final int GL_UNIFORM_BUFFER_BINDING = 0x8A28;
  public static final int GL_UNIFORM_BUFFER_START = 0x8A29;
  public static final int GL_UNIFORM_BUFFER_SIZE = 0x8A2A;
  public static final int GL_MAX_VERTEX_UNIFORM_BLOCKS = 0x8A2B;
  public static final int GL_MAX_GEOMETRY_UNIFORM_BLOCKS = 0x8A2C;
  public static final int GL_MAX_FRAGMENT_UNIFORM_BLOCKS = 0x8A2D;
  public static final int GL_MAX_COMBINED_UNIFORM_BLOCKS = 0x8A2E;
  public static final int GL_MAX_UNIFORM_BUFFER_BINDINGS = 0x8A2F;
  public static final int GL_MAX_UNIFORM_BLOCK_SIZE = 0x8A30;
  public static final int GL_MAX_COMBINED_VERTEX_UNIFORM_COMPONENTS = 0x8A31;
  public static final int GL_MAX_COMBINED_GEOMETRY_UNIFORM_COMPONENTS = 0x8A32;
  public static final int GL_MAX_COMBINED_FRAGMENT_UNIFORM_COMPONENTS = 0x8A33;
  public static final int GL_UNIFORM_BUFFER_OFFSET_ALIGNMENT = 0x8A34;
  public static final int GL_ACTIVE_UNIFORM_BLOCK_MAX_NAME_LENGTH = 0x8A35;
  public static final int GL_ACTIVE_UNIFORM_BLOCKS = 0x8A36;
  public static final int GL_UNIFORM_TYPE = 0x8A37;
  public static final int GL_UNIFORM_SIZE = 0x8A38;
  public static final int GL_UNIFORM_NAME_LENGTH = 0x8A39;
  public static final int GL_UNIFORM_BLOCK_INDEX = 0x8A3A;
  public static final int GL_UNIFORM_OFFSET = 0x8A3B;
  public static final int GL_UNIFORM_ARRAY_STRIDE = 0x8A3C;
  public static final int GL_UNIFORM_MATRIX_STRIDE = 0x8A3D;
  public static final int GL_UNIFORM_IS_ROW_MAJOR = 0x8A3E;
  public static final int GL_UNIFORM_BLOCK_BINDING = 0x8A3F;
  public static final int GL_UNIFORM_BLOCK_DATA_SIZE = 0x8A40;
  public static final int GL_UNIFORM_BLOCK_NAME_LENGTH = 0x8A41;
  public static final int GL_UNIFORM_BLOCK_ACTIVE_UNIFORMS = 0x8A42;
  public static final int GL_UNIFORM_BLOCK_ACTIVE_UNIFORM_INDICES = 0x8A43;
  public static final int GL_UNIFORM_BLOCK_REFERENCED_BY_VERTEX_SHADER = 0x8A44;
  public static final int GL_UNIFORM_BLOCK_REFERENCED_BY_GEOMETRY_SHADER = 0x8A45;
  public static final int GL_UNIFORM_BLOCK_REFERENCED_BY_FRAGMENT_SHADER = 0x8A46;
  public static final int GL_INVALID_INDEX = 0xFFFFFFFF;
  public void glGetUniformIndices(int program, int uniformCount, Addressable uniformNames, Addressable uniformIndices);
  public void glGetActiveUniformsiv(int program, int uniformCount, Addressable uniformIndices, int pname, Addressable params);
  public void glGetActiveUniformName(int program, int uniformIndex, int bufSize, Addressable length, Addressable uniformName);
  public int glGetUniformBlockIndex(int program, Addressable uniformBlockName);
  public void glGetActiveUniformBlockiv(int program, int uniformBlockIndex, int pname, Addressable params);
  public void glGetActiveUniformBlockName(int program, int uniformBlockIndex, int bufSize, Addressable length, Addressable uniformBlockName);
  public void glUniformBlockBinding(int program, int uniformBlockIndex, int uniformBlockBinding);
  public void glBindBufferRange(int target, int index, int buffer, long offset, long size);
  public void glBindBufferBase(int target, int index, int buffer);
  public void glGetIntegeri_v(int target, int index, Addressable data);
}
