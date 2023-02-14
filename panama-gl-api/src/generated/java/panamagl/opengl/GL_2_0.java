package panamagl.opengl; 

import java.lang.foreign.*;

public interface GL_2_0  {
  public static int GL_BLEND_EQUATION_RGB = 0x8009;
  public static int GL_VERTEX_ATTRIB_ARRAY_ENABLED = 0x8622;
  public static int GL_VERTEX_ATTRIB_ARRAY_SIZE = 0x8623;
  public static int GL_VERTEX_ATTRIB_ARRAY_STRIDE = 0x8624;
  public static int GL_VERTEX_ATTRIB_ARRAY_TYPE = 0x8625;
  public static int GL_CURRENT_VERTEX_ATTRIB = 0x8626;
  public static int GL_VERTEX_PROGRAM_POINT_SIZE = 0x8642;
  public static int GL_VERTEX_ATTRIB_ARRAY_POINTER = 0x8645;
  public static int GL_STENCIL_BACK_FUNC = 0x8800;
  public static int GL_STENCIL_BACK_FAIL = 0x8801;
  public static int GL_STENCIL_BACK_PASS_DEPTH_FAIL = 0x8802;
  public static int GL_STENCIL_BACK_PASS_DEPTH_PASS = 0x8803;
  public static int GL_MAX_DRAW_BUFFERS = 0x8824;
  public static int GL_DRAW_BUFFER0 = 0x8825;
  public static int GL_DRAW_BUFFER1 = 0x8826;
  public static int GL_DRAW_BUFFER2 = 0x8827;
  public static int GL_DRAW_BUFFER3 = 0x8828;
  public static int GL_DRAW_BUFFER4 = 0x8829;
  public static int GL_DRAW_BUFFER5 = 0x882A;
  public static int GL_DRAW_BUFFER6 = 0x882B;
  public static int GL_DRAW_BUFFER7 = 0x882C;
  public static int GL_DRAW_BUFFER8 = 0x882D;
  public static int GL_DRAW_BUFFER9 = 0x882E;
  public static int GL_DRAW_BUFFER10 = 0x882F;
  public static int GL_DRAW_BUFFER11 = 0x8830;
  public static int GL_DRAW_BUFFER12 = 0x8831;
  public static int GL_DRAW_BUFFER13 = 0x8832;
  public static int GL_DRAW_BUFFER14 = 0x8833;
  public static int GL_DRAW_BUFFER15 = 0x8834;
  public static int GL_BLEND_EQUATION_ALPHA = 0x883D;
  public static int GL_MAX_VERTEX_ATTRIBS = 0x8869;
  public static int GL_VERTEX_ATTRIB_ARRAY_NORMALIZED = 0x886A;
  public static int GL_MAX_TEXTURE_IMAGE_UNITS = 0x8872;
  public static int GL_FRAGMENT_SHADER = 0x8B30;
  public static int GL_VERTEX_SHADER = 0x8B31;
  public static int GL_MAX_FRAGMENT_UNIFORM_COMPONENTS = 0x8B49;
  public static int GL_MAX_VERTEX_UNIFORM_COMPONENTS = 0x8B4A;
  public static int GL_MAX_VARYING_FLOATS = 0x8B4B;
  public static int GL_MAX_VERTEX_TEXTURE_IMAGE_UNITS = 0x8B4C;
  public static int GL_MAX_COMBINED_TEXTURE_IMAGE_UNITS = 0x8B4D;
  public static int GL_SHADER_TYPE = 0x8B4F;
  public static int GL_FLOAT_VEC2 = 0x8B50;
  public static int GL_FLOAT_VEC3 = 0x8B51;
  public static int GL_FLOAT_VEC4 = 0x8B52;
  public static int GL_INT_VEC2 = 0x8B53;
  public static int GL_INT_VEC3 = 0x8B54;
  public static int GL_INT_VEC4 = 0x8B55;
  public static int GL_BOOL = 0x8B56;
  public static int GL_BOOL_VEC2 = 0x8B57;
  public static int GL_BOOL_VEC3 = 0x8B58;
  public static int GL_BOOL_VEC4 = 0x8B59;
  public static int GL_FLOAT_MAT2 = 0x8B5A;
  public static int GL_FLOAT_MAT3 = 0x8B5B;
  public static int GL_FLOAT_MAT4 = 0x8B5C;
  public static int GL_SAMPLER_1D = 0x8B5D;
  public static int GL_SAMPLER_2D = 0x8B5E;
  public static int GL_SAMPLER_3D = 0x8B5F;
  public static int GL_SAMPLER_CUBE = 0x8B60;
  public static int GL_SAMPLER_1D_SHADOW = 0x8B61;
  public static int GL_SAMPLER_2D_SHADOW = 0x8B62;
  public static int GL_DELETE_STATUS = 0x8B80;
  public static int GL_COMPILE_STATUS = 0x8B81;
  public static int GL_LINK_STATUS = 0x8B82;
  public static int GL_VALIDATE_STATUS = 0x8B83;
  public static int GL_INFO_LOG_LENGTH = 0x8B84;
  public static int GL_ATTACHED_SHADERS = 0x8B85;
  public static int GL_ACTIVE_UNIFORMS = 0x8B86;
  public static int GL_ACTIVE_UNIFORM_MAX_LENGTH = 0x8B87;
  public static int GL_SHADER_SOURCE_LENGTH = 0x8B88;
  public static int GL_ACTIVE_ATTRIBUTES = 0x8B89;
  public static int GL_ACTIVE_ATTRIBUTE_MAX_LENGTH = 0x8B8A;
  public static int GL_FRAGMENT_SHADER_DERIVATIVE_HINT = 0x8B8B;
  public static int GL_SHADING_LANGUAGE_VERSION = 0x8B8C;
  public static int GL_CURRENT_PROGRAM = 0x8B8D;
  public static int GL_POINT_SPRITE_COORD_ORIGIN = 0x8CA0;
  public static int GL_LOWER_LEFT = 0x8CA1;
  public static int GL_UPPER_LEFT = 0x8CA2;
  public static int GL_STENCIL_BACK_REF = 0x8CA3;
  public static int GL_STENCIL_BACK_VALUE_MASK = 0x8CA4;
  public static int GL_STENCIL_BACK_WRITEMASK = 0x8CA5;
  public static int GL_VERTEX_PROGRAM_TWO_SIDE = 0x8643;
  public static int GL_POINT_SPRITE = 0x8861;
  public static int GL_COORD_REPLACE = 0x8862;
  public static int GL_MAX_TEXTURE_COORDS = 0x8871;
  public void glBlendEquationSeparate(int modeRGB, int modeAlpha);
  public void glDrawBuffers(int n, Addressable bufs);
  public void glStencilOpSeparate(int face, int sfail, int dpfail, int dppass);
  public void glStencilFuncSeparate(int face, int func, int ref, int mask);
  public void glStencilMaskSeparate(int face, int mask);
  public void glAttachShader(int program, int shader);
  public void glBindAttribLocation(int program, int index, Addressable name);
  public void glCompileShader(int shader);
  public int glCreateProgram();
  public int glCreateShader(int type);
  public void glDeleteProgram(int program);
  public void glDeleteShader(int shader);
  public void glDetachShader(int program, int shader);
  public void glDisableVertexAttribArray(int index);
  public void glEnableVertexAttribArray(int index);
  public void glGetActiveAttrib(int program, int index, int bufSize, Addressable length, Addressable size, Addressable type, Addressable name);
  public void glGetActiveUniform(int program, int index, int bufSize, Addressable length, Addressable size, Addressable type, Addressable name);
  public void glGetAttachedShaders(int program, int maxCount, Addressable count, Addressable shaders);
  public int glGetAttribLocation(int program, Addressable name);
  public void glGetProgramiv(int program, int pname, Addressable params);
  public void glGetProgramInfoLog(int program, int bufSize, Addressable length, Addressable infoLog);
  public void glGetShaderiv(int shader, int pname, Addressable params);
  public void glGetShaderInfoLog(int shader, int bufSize, Addressable length, Addressable infoLog);
  public void glGetShaderSource(int shader, int bufSize, Addressable length, Addressable source);
  public int glGetUniformLocation(int program, Addressable name);
  public void glGetUniformfv(int program, int location, Addressable params);
  public void glGetUniformiv(int program, int location, Addressable params);
  public void glGetVertexAttribdv(int index, int pname, Addressable params);
  public void glGetVertexAttribfv(int index, int pname, Addressable params);
  public void glGetVertexAttribiv(int index, int pname, Addressable params);
  public void glGetVertexAttribPointerv(int index, int pname, Addressable pointer);
  public byte glIsProgram(int program);
  public byte glIsShader(int shader);
  public void glLinkProgram(int program);
  public void glShaderSource(int shader, int count, Addressable string, Addressable length);
  public void glUseProgram(int program);
  public void glUniform1f(int location, float v0);
  public void glUniform2f(int location, float v0, float v1);
  public void glUniform3f(int location, float v0, float v1, float v2);
  public void glUniform4f(int location, float v0, float v1, float v2, float v3);
  public void glUniform1i(int location, int v0);
  public void glUniform2i(int location, int v0, int v1);
  public void glUniform3i(int location, int v0, int v1, int v2);
  public void glUniform4i(int location, int v0, int v1, int v2, int v3);
  public void glUniform1fv(int location, int count, Addressable value);
  public void glUniform2fv(int location, int count, Addressable value);
  public void glUniform3fv(int location, int count, Addressable value);
  public void glUniform4fv(int location, int count, Addressable value);
  public void glUniform1iv(int location, int count, Addressable value);
  public void glUniform2iv(int location, int count, Addressable value);
  public void glUniform3iv(int location, int count, Addressable value);
  public void glUniform4iv(int location, int count, Addressable value);
  public void glUniformMatrix2fv(int location, int count, byte transpose, Addressable value);
  public void glUniformMatrix3fv(int location, int count, byte transpose, Addressable value);
  public void glUniformMatrix4fv(int location, int count, byte transpose, Addressable value);
  public void glValidateProgram(int program);
  public void glVertexAttrib1d(int index, double x);
  public void glVertexAttrib1dv(int index, Addressable v);
  public void glVertexAttrib1f(int index, float x);
  public void glVertexAttrib1fv(int index, Addressable v);
  public void glVertexAttrib1s(int index, short x);
  public void glVertexAttrib1sv(int index, Addressable v);
  public void glVertexAttrib2d(int index, double x, double y);
  public void glVertexAttrib2dv(int index, Addressable v);
  public void glVertexAttrib2f(int index, float x, float y);
  public void glVertexAttrib2fv(int index, Addressable v);
  public void glVertexAttrib2s(int index, short x, short y);
  public void glVertexAttrib2sv(int index, Addressable v);
  public void glVertexAttrib3d(int index, double x, double y, double z);
  public void glVertexAttrib3dv(int index, Addressable v);
  public void glVertexAttrib3f(int index, float x, float y, float z);
  public void glVertexAttrib3fv(int index, Addressable v);
  public void glVertexAttrib3s(int index, short x, short y, short z);
  public void glVertexAttrib3sv(int index, Addressable v);
  public void glVertexAttrib4Nbv(int index, Addressable v);
  public void glVertexAttrib4Niv(int index, Addressable v);
  public void glVertexAttrib4Nsv(int index, Addressable v);
  public void glVertexAttrib4Nub(int index, byte x, byte y, byte z, byte w);
  public void glVertexAttrib4Nubv(int index, Addressable v);
  public void glVertexAttrib4Nuiv(int index, Addressable v);
  public void glVertexAttrib4Nusv(int index, Addressable v);
  public void glVertexAttrib4bv(int index, Addressable v);
  public void glVertexAttrib4d(int index, double x, double y, double z, double w);
  public void glVertexAttrib4dv(int index, Addressable v);
  public void glVertexAttrib4f(int index, float x, float y, float z, float w);
  public void glVertexAttrib4fv(int index, Addressable v);
  public void glVertexAttrib4iv(int index, Addressable v);
  public void glVertexAttrib4s(int index, short x, short y, short z, short w);
  public void glVertexAttrib4sv(int index, Addressable v);
  public void glVertexAttrib4ubv(int index, Addressable v);
  public void glVertexAttrib4uiv(int index, Addressable v);
  public void glVertexAttrib4usv(int index, Addressable v);
  public void glVertexAttribPointer(int index, int size, int type, byte normalized, int stride, Addressable pointer);
}
