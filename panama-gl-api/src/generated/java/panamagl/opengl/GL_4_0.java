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

public interface GL_4_0  {
  public static final int GL_SAMPLE_SHADING = 0x8C36;
  public static final int GL_MIN_SAMPLE_SHADING_VALUE = 0x8C37;
  public static final int GL_MIN_PROGRAM_TEXTURE_GATHER_OFFSET = 0x8E5E;
  public static final int GL_MAX_PROGRAM_TEXTURE_GATHER_OFFSET = 0x8E5F;
  public static final int GL_TEXTURE_CUBE_MAP_ARRAY = 0x9009;
  public static final int GL_TEXTURE_BINDING_CUBE_MAP_ARRAY = 0x900A;
  public static final int GL_PROXY_TEXTURE_CUBE_MAP_ARRAY = 0x900B;
  public static final int GL_SAMPLER_CUBE_MAP_ARRAY = 0x900C;
  public static final int GL_SAMPLER_CUBE_MAP_ARRAY_SHADOW = 0x900D;
  public static final int GL_INT_SAMPLER_CUBE_MAP_ARRAY = 0x900E;
  public static final int GL_UNSIGNED_INT_SAMPLER_CUBE_MAP_ARRAY = 0x900F;
  public void glMinSampleShading(float value);
  public void glBlendEquationi(int buf, int mode);
  public void glBlendEquationSeparatei(int buf, int modeRGB, int modeAlpha);
  public void glBlendFunci(int buf, int src, int dst);
  public void glBlendFuncSeparatei(int buf, int srcRGB, int dstRGB, int srcAlpha, int dstAlpha);
  public static final int GL_DRAW_INDIRECT_BUFFER = 0x8F3F;
  public static final int GL_DRAW_INDIRECT_BUFFER_BINDING = 0x8F43;
  public void glDrawArraysIndirect(int mode, Addressable indirect);
  public void glDrawElementsIndirect(int mode, int type, Addressable indirect);
  public static final int GL_GEOMETRY_SHADER_INVOCATIONS = 0x887F;
  public static final int GL_MAX_GEOMETRY_SHADER_INVOCATIONS = 0x8E5A;
  public static final int GL_MIN_FRAGMENT_INTERPOLATION_OFFSET = 0x8E5B;
  public static final int GL_MAX_FRAGMENT_INTERPOLATION_OFFSET = 0x8E5C;
  public static final int GL_FRAGMENT_INTERPOLATION_OFFSET_BITS = 0x8E5D;
  public static final int GL_MAX_VERTEX_STREAMS = 0x8E71;
  public static final int GL_DOUBLE_VEC2 = 0x8FFC;
  public static final int GL_DOUBLE_VEC3 = 0x8FFD;
  public static final int GL_DOUBLE_VEC4 = 0x8FFE;
  public static final int GL_DOUBLE_MAT2 = 0x8F46;
  public static final int GL_DOUBLE_MAT3 = 0x8F47;
  public static final int GL_DOUBLE_MAT4 = 0x8F48;
  public static final int GL_DOUBLE_MAT2x3 = 0x8F49;
  public static final int GL_DOUBLE_MAT2x4 = 0x8F4A;
  public static final int GL_DOUBLE_MAT3x2 = 0x8F4B;
  public static final int GL_DOUBLE_MAT3x4 = 0x8F4C;
  public static final int GL_DOUBLE_MAT4x2 = 0x8F4D;
  public static final int GL_DOUBLE_MAT4x3 = 0x8F4E;
  public void glUniform1d(int location, double x);
  public void glUniform2d(int location, double x, double y);
  public void glUniform3d(int location, double x, double y, double z);
  public void glUniform4d(int location, double x, double y, double z, double w);
  public void glUniform1dv(int location, int count, Addressable value);
  public void glUniform2dv(int location, int count, Addressable value);
  public void glUniform3dv(int location, int count, Addressable value);
  public void glUniform4dv(int location, int count, Addressable value);
  public void glUniformMatrix2dv(int location, int count, byte transpose, Addressable value);
  public void glUniformMatrix3dv(int location, int count, byte transpose, Addressable value);
  public void glUniformMatrix4dv(int location, int count, byte transpose, Addressable value);
  public void glUniformMatrix2x3dv(int location, int count, byte transpose, Addressable value);
  public void glUniformMatrix2x4dv(int location, int count, byte transpose, Addressable value);
  public void glUniformMatrix3x2dv(int location, int count, byte transpose, Addressable value);
  public void glUniformMatrix3x4dv(int location, int count, byte transpose, Addressable value);
  public void glUniformMatrix4x2dv(int location, int count, byte transpose, Addressable value);
  public void glUniformMatrix4x3dv(int location, int count, byte transpose, Addressable value);
  public void glGetUniformdv(int program, int location, Addressable params);
  public static final int GL_ACTIVE_SUBROUTINES = 0x8DE5;
  public static final int GL_ACTIVE_SUBROUTINE_UNIFORMS = 0x8DE6;
  public static final int GL_ACTIVE_SUBROUTINE_UNIFORM_LOCATIONS = 0x8E47;
  public static final int GL_ACTIVE_SUBROUTINE_MAX_LENGTH = 0x8E48;
  public static final int GL_ACTIVE_SUBROUTINE_UNIFORM_MAX_LENGTH = 0x8E49;
  public static final int GL_MAX_SUBROUTINES = 0x8DE7;
  public static final int GL_MAX_SUBROUTINE_UNIFORM_LOCATIONS = 0x8DE8;
  public static final int GL_NUM_COMPATIBLE_SUBROUTINES = 0x8E4A;
  public static final int GL_COMPATIBLE_SUBROUTINES = 0x8E4B;
  public int glGetSubroutineUniformLocation(int program, int shadertype, Addressable name);
  public int glGetSubroutineIndex(int program, int shadertype, Addressable name);
  public void glGetActiveSubroutineUniformiv(int program, int shadertype, int index, int pname, Addressable values);
  public void glGetActiveSubroutineUniformName(int program, int shadertype, int index, int bufSize, Addressable length, Addressable name);
  public void glGetActiveSubroutineName(int program, int shadertype, int index, int bufSize, Addressable length, Addressable name);
  public void glUniformSubroutinesuiv(int shadertype, int count, Addressable indices);
  public void glGetUniformSubroutineuiv(int shadertype, int location, Addressable params);
  public void glGetProgramStageiv(int program, int shadertype, int pname, Addressable values);
  public static final int GL_PATCHES = 0x000E;
  public static final int GL_PATCH_VERTICES = 0x8E72;
  public static final int GL_PATCH_DEFAULT_INNER_LEVEL = 0x8E73;
  public static final int GL_PATCH_DEFAULT_OUTER_LEVEL = 0x8E74;
  public static final int GL_TESS_CONTROL_OUTPUT_VERTICES = 0x8E75;
  public static final int GL_TESS_GEN_MODE = 0x8E76;
  public static final int GL_TESS_GEN_SPACING = 0x8E77;
  public static final int GL_TESS_GEN_VERTEX_ORDER = 0x8E78;
  public static final int GL_TESS_GEN_POINT_MODE = 0x8E79;
  public static final int GL_ISOLINES = 0x8E7A;
  public static final int GL_QUADS = 0x0007;
  public static final int GL_FRACTIONAL_ODD = 0x8E7B;
  public static final int GL_FRACTIONAL_EVEN = 0x8E7C;
  public static final int GL_MAX_PATCH_VERTICES = 0x8E7D;
  public static final int GL_MAX_TESS_GEN_LEVEL = 0x8E7E;
  public static final int GL_MAX_TESS_CONTROL_UNIFORM_COMPONENTS = 0x8E7F;
  public static final int GL_MAX_TESS_EVALUATION_UNIFORM_COMPONENTS = 0x8E80;
  public static final int GL_MAX_TESS_CONTROL_TEXTURE_IMAGE_UNITS = 0x8E81;
  public static final int GL_MAX_TESS_EVALUATION_TEXTURE_IMAGE_UNITS = 0x8E82;
  public static final int GL_MAX_TESS_CONTROL_OUTPUT_COMPONENTS = 0x8E83;
  public static final int GL_MAX_TESS_PATCH_COMPONENTS = 0x8E84;
  public static final int GL_MAX_TESS_CONTROL_TOTAL_OUTPUT_COMPONENTS = 0x8E85;
  public static final int GL_MAX_TESS_EVALUATION_OUTPUT_COMPONENTS = 0x8E86;
  public static final int GL_MAX_TESS_CONTROL_UNIFORM_BLOCKS = 0x8E89;
  public static final int GL_MAX_TESS_EVALUATION_UNIFORM_BLOCKS = 0x8E8A;
  public static final int GL_MAX_TESS_CONTROL_INPUT_COMPONENTS = 0x886C;
  public static final int GL_MAX_TESS_EVALUATION_INPUT_COMPONENTS = 0x886D;
  public static final int GL_MAX_COMBINED_TESS_CONTROL_UNIFORM_COMPONENTS = 0x8E1E;
  public static final int GL_MAX_COMBINED_TESS_EVALUATION_UNIFORM_COMPONENTS = 0x8E1F;
  public static final int GL_UNIFORM_BLOCK_REFERENCED_BY_TESS_CONTROL_SHADER = 0x84F0;
  public static final int GL_UNIFORM_BLOCK_REFERENCED_BY_TESS_EVALUATION_SHADER = 0x84F1;
  public static final int GL_TESS_EVALUATION_SHADER = 0x8E87;
  public static final int GL_TESS_CONTROL_SHADER = 0x8E88;
  public void glPatchParameteri(int pname, int value);
  public void glPatchParameterfv(int pname, Addressable values);
  public static final int GL_TRANSFORM_FEEDBACK = 0x8E22;
  public static final int GL_TRANSFORM_FEEDBACK_BUFFER_PAUSED = 0x8E23;
  public static final int GL_TRANSFORM_FEEDBACK_BUFFER_ACTIVE = 0x8E24;
  public static final int GL_TRANSFORM_FEEDBACK_BINDING = 0x8E25;
  public void glBindTransformFeedback(int target, int id);
  public void glDeleteTransformFeedbacks(int n, Addressable ids);
  public void glGenTransformFeedbacks(int n, Addressable ids);
  public byte glIsTransformFeedback(int id);
  public void glPauseTransformFeedback();
  public void glResumeTransformFeedback();
  public void glDrawTransformFeedback(int mode, int id);
  public static final int GL_MAX_TRANSFORM_FEEDBACK_BUFFERS = 0x8E70;
  public void glDrawTransformFeedbackStream(int mode, int id, int stream);
  public void glBeginQueryIndexed(int target, int index, int id);
  public void glEndQueryIndexed(int target, int index);
  public void glGetQueryIndexediv(int target, int index, int pname, Addressable params);
}
