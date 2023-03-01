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

public interface GL_3_2 extends GL_3_1 {
  public static final int GL_CONTEXT_CORE_PROFILE_BIT = 0x00000001;
  public static final int GL_CONTEXT_COMPATIBILITY_PROFILE_BIT = 0x00000002;
  public static final int GL_LINES_ADJACENCY = 0x000A;
  public static final int GL_LINE_STRIP_ADJACENCY = 0x000B;
  public static final int GL_TRIANGLES_ADJACENCY = 0x000C;
  public static final int GL_TRIANGLE_STRIP_ADJACENCY = 0x000D;
  public static final int GL_PROGRAM_POINT_SIZE = 0x8642;
  public static final int GL_MAX_GEOMETRY_TEXTURE_IMAGE_UNITS = 0x8C29;
  public static final int GL_FRAMEBUFFER_ATTACHMENT_LAYERED = 0x8DA7;
  public static final int GL_FRAMEBUFFER_INCOMPLETE_LAYER_TARGETS = 0x8DA8;
  public static final int GL_GEOMETRY_SHADER = 0x8DD9;
  public static final int GL_GEOMETRY_VERTICES_OUT = 0x8916;
  public static final int GL_GEOMETRY_INPUT_TYPE = 0x8917;
  public static final int GL_GEOMETRY_OUTPUT_TYPE = 0x8918;
  public static final int GL_MAX_GEOMETRY_UNIFORM_COMPONENTS = 0x8DDF;
  public static final int GL_MAX_GEOMETRY_OUTPUT_VERTICES = 0x8DE0;
  public static final int GL_MAX_GEOMETRY_TOTAL_OUTPUT_COMPONENTS = 0x8DE1;
  public static final int GL_MAX_VERTEX_OUTPUT_COMPONENTS = 0x9122;
  public static final int GL_MAX_GEOMETRY_INPUT_COMPONENTS = 0x9123;
  public static final int GL_MAX_GEOMETRY_OUTPUT_COMPONENTS = 0x9124;
  public static final int GL_MAX_FRAGMENT_INPUT_COMPONENTS = 0x9125;
  public static final int GL_CONTEXT_PROFILE_MASK = 0x9126;
  public static final int GL_DEPTH_CLAMP = 0x864F;
  public void glDrawElementsBaseVertex(int mode, int count, int type, Addressable indices, int basevertex);
  public void glDrawRangeElementsBaseVertex(int mode, int start, int end, int count, int type, Addressable indices, int basevertex);
  public void glDrawElementsInstancedBaseVertex(int mode, int count, int type, Addressable indices, int instancecount, int basevertex);
  public void glMultiDrawElementsBaseVertex(int mode, Addressable count, int type, Addressable indices, int drawcount, Addressable basevertex);
  public static final int GL_QUADS_FOLLOW_PROVOKING_VERTEX_CONVENTION = 0x8E4C;
  public static final int GL_FIRST_VERTEX_CONVENTION = 0x8E4D;
  public static final int GL_LAST_VERTEX_CONVENTION = 0x8E4E;
  public static final int GL_PROVOKING_VERTEX = 0x8E4F;
  public void glProvokingVertex(int mode);
  public static final int GL_TEXTURE_CUBE_MAP_SEAMLESS = 0x884F;
  public static final int GL_MAX_SERVER_WAIT_TIMEOUT = 0x9111;
  public static final int GL_OBJECT_TYPE = 0x9112;
  public static final int GL_SYNC_CONDITION = 0x9113;
  public static final int GL_SYNC_STATUS = 0x9114;
  public static final int GL_SYNC_FLAGS = 0x9115;
  public static final int GL_SYNC_FENCE = 0x9116;
  public static final int GL_SYNC_GPU_COMMANDS_COMPLETE = 0x9117;
  public static final int GL_UNSIGNALED = 0x9118;
  public static final int GL_SIGNALED = 0x9119;
  public static final int GL_ALREADY_SIGNALED = 0x911A;
  public static final int GL_TIMEOUT_EXPIRED = 0x911B;
  public static final int GL_CONDITION_SATISFIED = 0x911C;
  public static final int GL_WAIT_FAILED = 0x911D;
  public static final long GL_TIMEOUT_IGNORED = 0xFFFFFFFF;
  public static final int GL_SYNC_FLUSH_COMMANDS_BIT = 0x00000001;
  public Addressable glFenceSync(int condition, int flags);
  public byte glIsSync(Addressable sync);
  public void glDeleteSync(Addressable sync);
  public int glClientWaitSync(Addressable sync, int flags, long timeout);
  public void glWaitSync(Addressable sync, int flags, long timeout);
  public void glGetInteger64v(int pname, Addressable data);
  public void glGetSynciv(Addressable sync, int pname, int count, Addressable length, Addressable values);
  public static final int GL_SAMPLE_POSITION = 0x8E50;
  public static final int GL_SAMPLE_MASK = 0x8E51;
  public static final int GL_SAMPLE_MASK_VALUE = 0x8E52;
  public static final int GL_MAX_SAMPLE_MASK_WORDS = 0x8E59;
  public static final int GL_TEXTURE_2D_MULTISAMPLE = 0x9100;
  public static final int GL_PROXY_TEXTURE_2D_MULTISAMPLE = 0x9101;
  public static final int GL_TEXTURE_2D_MULTISAMPLE_ARRAY = 0x9102;
  public static final int GL_PROXY_TEXTURE_2D_MULTISAMPLE_ARRAY = 0x9103;
  public static final int GL_TEXTURE_BINDING_2D_MULTISAMPLE = 0x9104;
  public static final int GL_TEXTURE_BINDING_2D_MULTISAMPLE_ARRAY = 0x9105;
  public static final int GL_TEXTURE_SAMPLES = 0x9106;
  public static final int GL_TEXTURE_FIXED_SAMPLE_LOCATIONS = 0x9107;
  public static final int GL_SAMPLER_2D_MULTISAMPLE = 0x9108;
  public static final int GL_INT_SAMPLER_2D_MULTISAMPLE = 0x9109;
  public static final int GL_UNSIGNED_INT_SAMPLER_2D_MULTISAMPLE = 0x910A;
  public static final int GL_SAMPLER_2D_MULTISAMPLE_ARRAY = 0x910B;
  public static final int GL_INT_SAMPLER_2D_MULTISAMPLE_ARRAY = 0x910C;
  public static final int GL_UNSIGNED_INT_SAMPLER_2D_MULTISAMPLE_ARRAY = 0x910D;
  public static final int GL_MAX_COLOR_TEXTURE_SAMPLES = 0x910E;
  public static final int GL_MAX_DEPTH_TEXTURE_SAMPLES = 0x910F;
  public static final int GL_MAX_INTEGER_SAMPLES = 0x9110;
  public void glGetInteger64i_v(int target, int index, Addressable data);
  public void glGetBufferParameteri64v(int target, int pname, Addressable params);
  public void glFramebufferTexture(int target, int attachment, int texture, int level);
  public void glTexImage2DMultisample(int target, int samples, int internalformat, int width, int height, byte fixedsamplelocations);
  public void glTexImage3DMultisample(int target, int samples, int internalformat, int width, int height, int depth, byte fixedsamplelocations);
  public void glGetMultisamplefv(int pname, int index, Addressable val);
  public void glSampleMaski(int maskNumber, int mask);
}
