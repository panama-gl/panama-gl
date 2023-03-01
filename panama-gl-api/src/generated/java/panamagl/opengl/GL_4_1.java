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

public interface GL_4_1 extends GL_4_0 {
  public static final int GL_FIXED = 0x140C;
  public static final int GL_IMPLEMENTATION_COLOR_READ_TYPE = 0x8B9A;
  public static final int GL_IMPLEMENTATION_COLOR_READ_FORMAT = 0x8B9B;
  public static final int GL_LOW_FLOAT = 0x8DF0;
  public static final int GL_MEDIUM_FLOAT = 0x8DF1;
  public static final int GL_HIGH_FLOAT = 0x8DF2;
  public static final int GL_LOW_INT = 0x8DF3;
  public static final int GL_MEDIUM_INT = 0x8DF4;
  public static final int GL_HIGH_INT = 0x8DF5;
  public static final int GL_SHADER_COMPILER = 0x8DFA;
  public static final int GL_SHADER_BINARY_FORMATS = 0x8DF8;
  public static final int GL_NUM_SHADER_BINARY_FORMATS = 0x8DF9;
  public static final int GL_MAX_VERTEX_UNIFORM_VECTORS = 0x8DFB;
  public static final int GL_MAX_VARYING_VECTORS = 0x8DFC;
  public static final int GL_MAX_FRAGMENT_UNIFORM_VECTORS = 0x8DFD;
  public static final int GL_RGB565 = 0x8D62;
  public static final int GL_PROGRAM_BINARY_RETRIEVABLE_HINT = 0x8257;
  public static final int GL_PROGRAM_BINARY_LENGTH = 0x8741;
  public static final int GL_NUM_PROGRAM_BINARY_FORMATS = 0x87FE;
  public static final int GL_PROGRAM_BINARY_FORMATS = 0x87FF;
  public static final int GL_VERTEX_SHADER_BIT = 0x00000001;
  public static final int GL_FRAGMENT_SHADER_BIT = 0x00000002;
  public static final int GL_GEOMETRY_SHADER_BIT = 0x00000004;
  public static final int GL_TESS_CONTROL_SHADER_BIT = 0x00000008;
  public static final int GL_TESS_EVALUATION_SHADER_BIT = 0x00000010;
  public static final int GL_ALL_SHADER_BITS = 0xFFFFFFFF;
  public static final int GL_PROGRAM_SEPARABLE = 0x8258;
  public static final int GL_ACTIVE_PROGRAM = 0x8259;
  public static final int GL_PROGRAM_PIPELINE_BINDING = 0x825A;
  public static final int GL_MAX_VIEWPORTS = 0x825B;
  public static final int GL_VIEWPORT_SUBPIXEL_BITS = 0x825C;
  public static final int GL_VIEWPORT_BOUNDS_RANGE = 0x825D;
  public static final int GL_LAYER_PROVOKING_VERTEX = 0x825E;
  public static final int GL_VIEWPORT_INDEX_PROVOKING_VERTEX = 0x825F;
  public static final int GL_UNDEFINED_VERTEX = 0x8260;
  public void glReleaseShaderCompiler();
  public void glShaderBinary(int count, Addressable shaders, int binaryFormat, Addressable binary, int length);
  public void glGetShaderPrecisionFormat(int shadertype, int precisiontype, Addressable range, Addressable precision);
  public void glDepthRangef(float n, float f);
  public void glClearDepthf(float d);
  public void glGetProgramBinary(int program, int bufSize, Addressable length, Addressable binaryFormat, Addressable binary);
  public void glProgramBinary(int program, int binaryFormat, Addressable binary, int length);
  public void glProgramParameteri(int program, int pname, int value);
  public void glUseProgramStages(int pipeline, int stages, int program);
  public void glActiveShaderProgram(int pipeline, int program);
  public int glCreateShaderProgramv(int type, int count, Addressable strings);
  public void glBindProgramPipeline(int pipeline);
  public void glDeleteProgramPipelines(int n, Addressable pipelines);
  public void glGenProgramPipelines(int n, Addressable pipelines);
  public byte glIsProgramPipeline(int pipeline);
  public void glGetProgramPipelineiv(int pipeline, int pname, Addressable params);
  public void glProgramUniform1i(int program, int location, int v0);
  public void glProgramUniform1iv(int program, int location, int count, Addressable value);
  public void glProgramUniform1f(int program, int location, float v0);
  public void glProgramUniform1fv(int program, int location, int count, Addressable value);
  public void glProgramUniform1d(int program, int location, double v0);
  public void glProgramUniform1dv(int program, int location, int count, Addressable value);
  public void glProgramUniform1ui(int program, int location, int v0);
  public void glProgramUniform1uiv(int program, int location, int count, Addressable value);
  public void glProgramUniform2i(int program, int location, int v0, int v1);
  public void glProgramUniform2iv(int program, int location, int count, Addressable value);
  public void glProgramUniform2f(int program, int location, float v0, float v1);
  public void glProgramUniform2fv(int program, int location, int count, Addressable value);
  public void glProgramUniform2d(int program, int location, double v0, double v1);
  public void glProgramUniform2dv(int program, int location, int count, Addressable value);
  public void glProgramUniform2ui(int program, int location, int v0, int v1);
  public void glProgramUniform2uiv(int program, int location, int count, Addressable value);
  public void glProgramUniform3i(int program, int location, int v0, int v1, int v2);
  public void glProgramUniform3iv(int program, int location, int count, Addressable value);
  public void glProgramUniform3f(int program, int location, float v0, float v1, float v2);
  public void glProgramUniform3fv(int program, int location, int count, Addressable value);
  public void glProgramUniform3d(int program, int location, double v0, double v1, double v2);
  public void glProgramUniform3dv(int program, int location, int count, Addressable value);
  public void glProgramUniform3ui(int program, int location, int v0, int v1, int v2);
  public void glProgramUniform3uiv(int program, int location, int count, Addressable value);
  public void glProgramUniform4i(int program, int location, int v0, int v1, int v2, int v3);
  public void glProgramUniform4iv(int program, int location, int count, Addressable value);
  public void glProgramUniform4f(int program, int location, float v0, float v1, float v2, float v3);
  public void glProgramUniform4fv(int program, int location, int count, Addressable value);
  public void glProgramUniform4d(int program, int location, double v0, double v1, double v2, double v3);
  public void glProgramUniform4dv(int program, int location, int count, Addressable value);
  public void glProgramUniform4ui(int program, int location, int v0, int v1, int v2, int v3);
  public void glProgramUniform4uiv(int program, int location, int count, Addressable value);
  public void glProgramUniformMatrix2fv(int program, int location, int count, byte transpose, Addressable value);
  public void glProgramUniformMatrix3fv(int program, int location, int count, byte transpose, Addressable value);
  public void glProgramUniformMatrix4fv(int program, int location, int count, byte transpose, Addressable value);
  public void glProgramUniformMatrix2dv(int program, int location, int count, byte transpose, Addressable value);
  public void glProgramUniformMatrix3dv(int program, int location, int count, byte transpose, Addressable value);
  public void glProgramUniformMatrix4dv(int program, int location, int count, byte transpose, Addressable value);
  public void glProgramUniformMatrix2x3fv(int program, int location, int count, byte transpose, Addressable value);
  public void glProgramUniformMatrix3x2fv(int program, int location, int count, byte transpose, Addressable value);
  public void glProgramUniformMatrix2x4fv(int program, int location, int count, byte transpose, Addressable value);
  public void glProgramUniformMatrix4x2fv(int program, int location, int count, byte transpose, Addressable value);
  public void glProgramUniformMatrix3x4fv(int program, int location, int count, byte transpose, Addressable value);
  public void glProgramUniformMatrix4x3fv(int program, int location, int count, byte transpose, Addressable value);
  public void glProgramUniformMatrix2x3dv(int program, int location, int count, byte transpose, Addressable value);
  public void glProgramUniformMatrix3x2dv(int program, int location, int count, byte transpose, Addressable value);
  public void glProgramUniformMatrix2x4dv(int program, int location, int count, byte transpose, Addressable value);
  public void glProgramUniformMatrix4x2dv(int program, int location, int count, byte transpose, Addressable value);
  public void glProgramUniformMatrix3x4dv(int program, int location, int count, byte transpose, Addressable value);
  public void glProgramUniformMatrix4x3dv(int program, int location, int count, byte transpose, Addressable value);
  public void glValidateProgramPipeline(int pipeline);
  public void glGetProgramPipelineInfoLog(int pipeline, int bufSize, Addressable length, Addressable infoLog);
  public void glVertexAttribL1d(int index, double x);
  public void glVertexAttribL2d(int index, double x, double y);
  public void glVertexAttribL3d(int index, double x, double y, double z);
  public void glVertexAttribL4d(int index, double x, double y, double z, double w);
  public void glVertexAttribL1dv(int index, Addressable v);
  public void glVertexAttribL2dv(int index, Addressable v);
  public void glVertexAttribL3dv(int index, Addressable v);
  public void glVertexAttribL4dv(int index, Addressable v);
  public void glVertexAttribLPointer(int index, int size, int type, int stride, Addressable pointer);
  public void glGetVertexAttribLdv(int index, int pname, Addressable params);
  public void glViewportArrayv(int first, int count, Addressable v);
  public void glViewportIndexedf(int index, float x, float y, float w, float h);
  public void glViewportIndexedfv(int index, Addressable v);
  public void glScissorArrayv(int first, int count, Addressable v);
  public void glScissorIndexed(int index, int left, int bottom, int width, int height);
  public void glScissorIndexedv(int index, Addressable v);
  public void glDepthRangeArrayv(int first, int count, Addressable v);
  public void glDepthRangeIndexed(int index, double n, double f);
  public void glGetFloati_v(int target, int index, Addressable data);
  public void glGetDoublei_v(int target, int index, Addressable data);
}
