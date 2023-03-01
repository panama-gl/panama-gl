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

public interface GL_4_2 extends GL_4_1 {
  public static final int GL_COPY_READ_BUFFER_BINDING = 0x8F36;
  public static final int GL_COPY_WRITE_BUFFER_BINDING = 0x8F37;
  public static final int GL_TRANSFORM_FEEDBACK_ACTIVE = 0x8E24;
  public static final int GL_TRANSFORM_FEEDBACK_PAUSED = 0x8E23;
  public static final int GL_UNPACK_COMPRESSED_BLOCK_WIDTH = 0x9127;
  public static final int GL_UNPACK_COMPRESSED_BLOCK_HEIGHT = 0x9128;
  public static final int GL_UNPACK_COMPRESSED_BLOCK_DEPTH = 0x9129;
  public static final int GL_UNPACK_COMPRESSED_BLOCK_SIZE = 0x912A;
  public static final int GL_PACK_COMPRESSED_BLOCK_WIDTH = 0x912B;
  public static final int GL_PACK_COMPRESSED_BLOCK_HEIGHT = 0x912C;
  public static final int GL_PACK_COMPRESSED_BLOCK_DEPTH = 0x912D;
  public static final int GL_PACK_COMPRESSED_BLOCK_SIZE = 0x912E;
  public static final int GL_NUM_SAMPLE_COUNTS = 0x9380;
  public static final int GL_MIN_MAP_BUFFER_ALIGNMENT = 0x90BC;
  public static final int GL_ATOMIC_COUNTER_BUFFER = 0x92C0;
  public static final int GL_ATOMIC_COUNTER_BUFFER_BINDING = 0x92C1;
  public static final int GL_ATOMIC_COUNTER_BUFFER_START = 0x92C2;
  public static final int GL_ATOMIC_COUNTER_BUFFER_SIZE = 0x92C3;
  public static final int GL_ATOMIC_COUNTER_BUFFER_DATA_SIZE = 0x92C4;
  public static final int GL_ATOMIC_COUNTER_BUFFER_ACTIVE_ATOMIC_COUNTERS = 0x92C5;
  public static final int GL_ATOMIC_COUNTER_BUFFER_ACTIVE_ATOMIC_COUNTER_INDICES = 0x92C6;
  public static final int GL_ATOMIC_COUNTER_BUFFER_REFERENCED_BY_VERTEX_SHADER = 0x92C7;
  public static final int GL_ATOMIC_COUNTER_BUFFER_REFERENCED_BY_TESS_CONTROL_SHADER = 0x92C8;
  public static final int GL_ATOMIC_COUNTER_BUFFER_REFERENCED_BY_TESS_EVALUATION_SHADER = 0x92C9;
  public static final int GL_ATOMIC_COUNTER_BUFFER_REFERENCED_BY_GEOMETRY_SHADER = 0x92CA;
  public static final int GL_ATOMIC_COUNTER_BUFFER_REFERENCED_BY_FRAGMENT_SHADER = 0x92CB;
  public static final int GL_MAX_VERTEX_ATOMIC_COUNTER_BUFFERS = 0x92CC;
  public static final int GL_MAX_TESS_CONTROL_ATOMIC_COUNTER_BUFFERS = 0x92CD;
  public static final int GL_MAX_TESS_EVALUATION_ATOMIC_COUNTER_BUFFERS = 0x92CE;
  public static final int GL_MAX_GEOMETRY_ATOMIC_COUNTER_BUFFERS = 0x92CF;
  public static final int GL_MAX_FRAGMENT_ATOMIC_COUNTER_BUFFERS = 0x92D0;
  public static final int GL_MAX_COMBINED_ATOMIC_COUNTER_BUFFERS = 0x92D1;
  public static final int GL_MAX_VERTEX_ATOMIC_COUNTERS = 0x92D2;
  public static final int GL_MAX_TESS_CONTROL_ATOMIC_COUNTERS = 0x92D3;
  public static final int GL_MAX_TESS_EVALUATION_ATOMIC_COUNTERS = 0x92D4;
  public static final int GL_MAX_GEOMETRY_ATOMIC_COUNTERS = 0x92D5;
  public static final int GL_MAX_FRAGMENT_ATOMIC_COUNTERS = 0x92D6;
  public static final int GL_MAX_COMBINED_ATOMIC_COUNTERS = 0x92D7;
  public static final int GL_MAX_ATOMIC_COUNTER_BUFFER_SIZE = 0x92D8;
  public static final int GL_MAX_ATOMIC_COUNTER_BUFFER_BINDINGS = 0x92DC;
  public static final int GL_ACTIVE_ATOMIC_COUNTER_BUFFERS = 0x92D9;
  public static final int GL_UNIFORM_ATOMIC_COUNTER_BUFFER_INDEX = 0x92DA;
  public static final int GL_UNSIGNED_INT_ATOMIC_COUNTER = 0x92DB;
  public static final int GL_VERTEX_ATTRIB_ARRAY_BARRIER_BIT = 0x00000001;
  public static final int GL_ELEMENT_ARRAY_BARRIER_BIT = 0x00000002;
  public static final int GL_UNIFORM_BARRIER_BIT = 0x00000004;
  public static final int GL_TEXTURE_FETCH_BARRIER_BIT = 0x00000008;
  public static final int GL_SHADER_IMAGE_ACCESS_BARRIER_BIT = 0x00000020;
  public static final int GL_COMMAND_BARRIER_BIT = 0x00000040;
  public static final int GL_PIXEL_BUFFER_BARRIER_BIT = 0x00000080;
  public static final int GL_TEXTURE_UPDATE_BARRIER_BIT = 0x00000100;
  public static final int GL_BUFFER_UPDATE_BARRIER_BIT = 0x00000200;
  public static final int GL_FRAMEBUFFER_BARRIER_BIT = 0x00000400;
  public static final int GL_TRANSFORM_FEEDBACK_BARRIER_BIT = 0x00000800;
  public static final int GL_ATOMIC_COUNTER_BARRIER_BIT = 0x00001000;
  public static final int GL_ALL_BARRIER_BITS = 0xFFFFFFFF;
  public static final int GL_MAX_IMAGE_UNITS = 0x8F38;
  public static final int GL_MAX_COMBINED_IMAGE_UNITS_AND_FRAGMENT_OUTPUTS = 0x8F39;
  public static final int GL_IMAGE_BINDING_NAME = 0x8F3A;
  public static final int GL_IMAGE_BINDING_LEVEL = 0x8F3B;
  public static final int GL_IMAGE_BINDING_LAYERED = 0x8F3C;
  public static final int GL_IMAGE_BINDING_LAYER = 0x8F3D;
  public static final int GL_IMAGE_BINDING_ACCESS = 0x8F3E;
  public static final int GL_IMAGE_1D = 0x904C;
  public static final int GL_IMAGE_2D = 0x904D;
  public static final int GL_IMAGE_3D = 0x904E;
  public static final int GL_IMAGE_2D_RECT = 0x904F;
  public static final int GL_IMAGE_CUBE = 0x9050;
  public static final int GL_IMAGE_BUFFER = 0x9051;
  public static final int GL_IMAGE_1D_ARRAY = 0x9052;
  public static final int GL_IMAGE_2D_ARRAY = 0x9053;
  public static final int GL_IMAGE_CUBE_MAP_ARRAY = 0x9054;
  public static final int GL_IMAGE_2D_MULTISAMPLE = 0x9055;
  public static final int GL_IMAGE_2D_MULTISAMPLE_ARRAY = 0x9056;
  public static final int GL_INT_IMAGE_1D = 0x9057;
  public static final int GL_INT_IMAGE_2D = 0x9058;
  public static final int GL_INT_IMAGE_3D = 0x9059;
  public static final int GL_INT_IMAGE_2D_RECT = 0x905A;
  public static final int GL_INT_IMAGE_CUBE = 0x905B;
  public static final int GL_INT_IMAGE_BUFFER = 0x905C;
  public static final int GL_INT_IMAGE_1D_ARRAY = 0x905D;
  public static final int GL_INT_IMAGE_2D_ARRAY = 0x905E;
  public static final int GL_INT_IMAGE_CUBE_MAP_ARRAY = 0x905F;
  public static final int GL_INT_IMAGE_2D_MULTISAMPLE = 0x9060;
  public static final int GL_INT_IMAGE_2D_MULTISAMPLE_ARRAY = 0x9061;
  public static final int GL_UNSIGNED_INT_IMAGE_1D = 0x9062;
  public static final int GL_UNSIGNED_INT_IMAGE_2D = 0x9063;
  public static final int GL_UNSIGNED_INT_IMAGE_3D = 0x9064;
  public static final int GL_UNSIGNED_INT_IMAGE_2D_RECT = 0x9065;
  public static final int GL_UNSIGNED_INT_IMAGE_CUBE = 0x9066;
  public static final int GL_UNSIGNED_INT_IMAGE_BUFFER = 0x9067;
  public static final int GL_UNSIGNED_INT_IMAGE_1D_ARRAY = 0x9068;
  public static final int GL_UNSIGNED_INT_IMAGE_2D_ARRAY = 0x9069;
  public static final int GL_UNSIGNED_INT_IMAGE_CUBE_MAP_ARRAY = 0x906A;
  public static final int GL_UNSIGNED_INT_IMAGE_2D_MULTISAMPLE = 0x906B;
  public static final int GL_UNSIGNED_INT_IMAGE_2D_MULTISAMPLE_ARRAY = 0x906C;
  public static final int GL_MAX_IMAGE_SAMPLES = 0x906D;
  public static final int GL_IMAGE_BINDING_FORMAT = 0x906E;
  public static final int GL_IMAGE_FORMAT_COMPATIBILITY_TYPE = 0x90C7;
  public static final int GL_IMAGE_FORMAT_COMPATIBILITY_BY_SIZE = 0x90C8;
  public static final int GL_IMAGE_FORMAT_COMPATIBILITY_BY_CLASS = 0x90C9;
  public static final int GL_MAX_VERTEX_IMAGE_UNIFORMS = 0x90CA;
  public static final int GL_MAX_TESS_CONTROL_IMAGE_UNIFORMS = 0x90CB;
  public static final int GL_MAX_TESS_EVALUATION_IMAGE_UNIFORMS = 0x90CC;
  public static final int GL_MAX_GEOMETRY_IMAGE_UNIFORMS = 0x90CD;
  public static final int GL_MAX_FRAGMENT_IMAGE_UNIFORMS = 0x90CE;
  public static final int GL_MAX_COMBINED_IMAGE_UNIFORMS = 0x90CF;
  public static final int GL_COMPRESSED_RGBA_BPTC_UNORM = 0x8E8C;
  public static final int GL_COMPRESSED_SRGB_ALPHA_BPTC_UNORM = 0x8E8D;
  public static final int GL_COMPRESSED_RGB_BPTC_SIGNED_FLOAT = 0x8E8E;
  public static final int GL_COMPRESSED_RGB_BPTC_UNSIGNED_FLOAT = 0x8E8F;
  public static final int GL_TEXTURE_IMMUTABLE_FORMAT = 0x912F;
  public void glDrawArraysInstancedBaseInstance(int mode, int first, int count, int instancecount, int baseinstance);
  public void glDrawElementsInstancedBaseInstance(int mode, int count, int type, Addressable indices, int instancecount, int baseinstance);
  public void glDrawElementsInstancedBaseVertexBaseInstance(int mode, int count, int type, Addressable indices, int instancecount, int basevertex, int baseinstance);
  public void glGetInternalformativ(int target, int internalformat, int pname, int count, Addressable params);
  public void glGetActiveAtomicCounterBufferiv(int program, int bufferIndex, int pname, Addressable params);
  public void glBindImageTexture(int unit, int texture, int level, byte layered, int layer, int access, int format);
  public void glMemoryBarrier(int barriers);
  public void glTexStorage1D(int target, int levels, int internalformat, int width);
  public void glTexStorage2D(int target, int levels, int internalformat, int width, int height);
  public void glTexStorage3D(int target, int levels, int internalformat, int width, int height, int depth);
  public void glDrawTransformFeedbackInstanced(int mode, int id, int instancecount);
  public void glDrawTransformFeedbackStreamInstanced(int mode, int id, int stream, int instancecount);
}
