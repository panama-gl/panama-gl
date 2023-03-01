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

public interface GL_3_3 extends GL_3_2 {
  public static final int GL_VERTEX_ATTRIB_ARRAY_DIVISOR = 0x88FE;
  public static final int GL_SRC1_COLOR = 0x88F9;
  public static final int GL_ONE_MINUS_SRC1_COLOR = 0x88FA;
  public static final int GL_ONE_MINUS_SRC1_ALPHA = 0x88FB;
  public static final int GL_MAX_DUAL_SOURCE_DRAW_BUFFERS = 0x88FC;
  public void glBindFragDataLocationIndexed(int program, int colorNumber, int index, Addressable name);
  public int glGetFragDataIndex(int program, Addressable name);
  public static final int GL_ANY_SAMPLES_PASSED = 0x8C2F;
  public static final int GL_SAMPLER_BINDING = 0x8919;
  public void glGenSamplers(int count, Addressable samplers);
  public void glDeleteSamplers(int count, Addressable samplers);
  public byte glIsSampler(int sampler);
  public void glBindSampler(int unit, int sampler);
  public void glSamplerParameteri(int sampler, int pname, int param);
  public void glSamplerParameteriv(int sampler, int pname, Addressable param);
  public void glSamplerParameterf(int sampler, int pname, float param);
  public void glSamplerParameterfv(int sampler, int pname, Addressable param);
  public void glSamplerParameterIiv(int sampler, int pname, Addressable param);
  public void glSamplerParameterIuiv(int sampler, int pname, Addressable param);
  public void glGetSamplerParameteriv(int sampler, int pname, Addressable params);
  public void glGetSamplerParameterIiv(int sampler, int pname, Addressable params);
  public void glGetSamplerParameterfv(int sampler, int pname, Addressable params);
  public void glGetSamplerParameterIuiv(int sampler, int pname, Addressable params);
  public static final int GL_RGB10_A2UI = 0x906F;
  public static final int GL_TEXTURE_SWIZZLE_R = 0x8E42;
  public static final int GL_TEXTURE_SWIZZLE_G = 0x8E43;
  public static final int GL_TEXTURE_SWIZZLE_B = 0x8E44;
  public static final int GL_TEXTURE_SWIZZLE_A = 0x8E45;
  public static final int GL_TEXTURE_SWIZZLE_RGBA = 0x8E46;
  public static final int GL_TIME_ELAPSED = 0x88BF;
  public static final int GL_TIMESTAMP = 0x8E28;
  public void glQueryCounter(int id, int target);
  public void glGetQueryObjecti64v(int id, int pname, Addressable params);
  public void glGetQueryObjectui64v(int id, int pname, Addressable params);
  public static final int GL_INT_2_10_10_10_REV = 0x8D9F;
  public void glVertexAttribDivisor(int index, int divisor);
  public void glVertexAttribP1ui(int index, int type, byte normalized, int value);
  public void glVertexAttribP1uiv(int index, int type, byte normalized, Addressable value);
  public void glVertexAttribP2ui(int index, int type, byte normalized, int value);
  public void glVertexAttribP2uiv(int index, int type, byte normalized, Addressable value);
  public void glVertexAttribP3ui(int index, int type, byte normalized, int value);
  public void glVertexAttribP3uiv(int index, int type, byte normalized, Addressable value);
  public void glVertexAttribP4ui(int index, int type, byte normalized, int value);
  public void glVertexAttribP4uiv(int index, int type, byte normalized, Addressable value);
  public void glVertexP2ui(int type, int value);
  public void glVertexP2uiv(int type, Addressable value);
  public void glVertexP3ui(int type, int value);
  public void glVertexP3uiv(int type, Addressable value);
  public void glVertexP4ui(int type, int value);
  public void glVertexP4uiv(int type, Addressable value);
  public void glTexCoordP1ui(int type, int coords);
  public void glTexCoordP1uiv(int type, Addressable coords);
  public void glTexCoordP2ui(int type, int coords);
  public void glTexCoordP2uiv(int type, Addressable coords);
  public void glTexCoordP3ui(int type, int coords);
  public void glTexCoordP3uiv(int type, Addressable coords);
  public void glTexCoordP4ui(int type, int coords);
  public void glTexCoordP4uiv(int type, Addressable coords);
  public void glMultiTexCoordP1ui(int texture, int type, int coords);
  public void glMultiTexCoordP1uiv(int texture, int type, Addressable coords);
  public void glMultiTexCoordP2ui(int texture, int type, int coords);
  public void glMultiTexCoordP2uiv(int texture, int type, Addressable coords);
  public void glMultiTexCoordP3ui(int texture, int type, int coords);
  public void glMultiTexCoordP3uiv(int texture, int type, Addressable coords);
  public void glMultiTexCoordP4ui(int texture, int type, int coords);
  public void glMultiTexCoordP4uiv(int texture, int type, Addressable coords);
  public void glNormalP3ui(int type, int coords);
  public void glNormalP3uiv(int type, Addressable coords);
  public void glColorP3ui(int type, int color);
  public void glColorP3uiv(int type, Addressable color);
  public void glColorP4ui(int type, int color);
  public void glColorP4uiv(int type, Addressable color);
  public void glSecondaryColorP3ui(int type, int color);
  public void glSecondaryColorP3uiv(int type, Addressable color);
}
