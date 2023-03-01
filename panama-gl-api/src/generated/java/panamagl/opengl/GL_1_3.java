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

public interface GL_1_3 extends GL_1_2 {
  public static final int GL_TEXTURE0 = 0x84C0;
  public static final int GL_TEXTURE1 = 0x84C1;
  public static final int GL_TEXTURE2 = 0x84C2;
  public static final int GL_TEXTURE3 = 0x84C3;
  public static final int GL_TEXTURE4 = 0x84C4;
  public static final int GL_TEXTURE5 = 0x84C5;
  public static final int GL_TEXTURE6 = 0x84C6;
  public static final int GL_TEXTURE7 = 0x84C7;
  public static final int GL_TEXTURE8 = 0x84C8;
  public static final int GL_TEXTURE9 = 0x84C9;
  public static final int GL_TEXTURE10 = 0x84CA;
  public static final int GL_TEXTURE11 = 0x84CB;
  public static final int GL_TEXTURE12 = 0x84CC;
  public static final int GL_TEXTURE13 = 0x84CD;
  public static final int GL_TEXTURE14 = 0x84CE;
  public static final int GL_TEXTURE15 = 0x84CF;
  public static final int GL_TEXTURE16 = 0x84D0;
  public static final int GL_TEXTURE17 = 0x84D1;
  public static final int GL_TEXTURE18 = 0x84D2;
  public static final int GL_TEXTURE19 = 0x84D3;
  public static final int GL_TEXTURE20 = 0x84D4;
  public static final int GL_TEXTURE21 = 0x84D5;
  public static final int GL_TEXTURE22 = 0x84D6;
  public static final int GL_TEXTURE23 = 0x84D7;
  public static final int GL_TEXTURE24 = 0x84D8;
  public static final int GL_TEXTURE25 = 0x84D9;
  public static final int GL_TEXTURE26 = 0x84DA;
  public static final int GL_TEXTURE27 = 0x84DB;
  public static final int GL_TEXTURE28 = 0x84DC;
  public static final int GL_TEXTURE29 = 0x84DD;
  public static final int GL_TEXTURE30 = 0x84DE;
  public static final int GL_TEXTURE31 = 0x84DF;
  public static final int GL_ACTIVE_TEXTURE = 0x84E0;
  public static final int GL_MULTISAMPLE = 0x809D;
  public static final int GL_SAMPLE_ALPHA_TO_COVERAGE = 0x809E;
  public static final int GL_SAMPLE_ALPHA_TO_ONE = 0x809F;
  public static final int GL_SAMPLE_COVERAGE = 0x80A0;
  public static final int GL_SAMPLE_BUFFERS = 0x80A8;
  public static final int GL_SAMPLES = 0x80A9;
  public static final int GL_SAMPLE_COVERAGE_VALUE = 0x80AA;
  public static final int GL_SAMPLE_COVERAGE_INVERT = 0x80AB;
  public static final int GL_TEXTURE_CUBE_MAP = 0x8513;
  public static final int GL_TEXTURE_BINDING_CUBE_MAP = 0x8514;
  public static final int GL_TEXTURE_CUBE_MAP_POSITIVE_X = 0x8515;
  public static final int GL_TEXTURE_CUBE_MAP_NEGATIVE_X = 0x8516;
  public static final int GL_TEXTURE_CUBE_MAP_POSITIVE_Y = 0x8517;
  public static final int GL_TEXTURE_CUBE_MAP_NEGATIVE_Y = 0x8518;
  public static final int GL_TEXTURE_CUBE_MAP_POSITIVE_Z = 0x8519;
  public static final int GL_TEXTURE_CUBE_MAP_NEGATIVE_Z = 0x851A;
  public static final int GL_PROXY_TEXTURE_CUBE_MAP = 0x851B;
  public static final int GL_MAX_CUBE_MAP_TEXTURE_SIZE = 0x851C;
  public static final int GL_COMPRESSED_RGB = 0x84ED;
  public static final int GL_COMPRESSED_RGBA = 0x84EE;
  public static final int GL_TEXTURE_COMPRESSION_HINT = 0x84EF;
  public static final int GL_TEXTURE_COMPRESSED_IMAGE_SIZE = 0x86A0;
  public static final int GL_TEXTURE_COMPRESSED = 0x86A1;
  public static final int GL_NUM_COMPRESSED_TEXTURE_FORMATS = 0x86A2;
  public static final int GL_COMPRESSED_TEXTURE_FORMATS = 0x86A3;
  public static final int GL_CLAMP_TO_BORDER = 0x812D;
  public static final int GL_CLIENT_ACTIVE_TEXTURE = 0x84E1;
  public static final int GL_MAX_TEXTURE_UNITS = 0x84E2;
  public static final int GL_TRANSPOSE_MODELVIEW_MATRIX = 0x84E3;
  public static final int GL_TRANSPOSE_PROJECTION_MATRIX = 0x84E4;
  public static final int GL_TRANSPOSE_TEXTURE_MATRIX = 0x84E5;
  public static final int GL_TRANSPOSE_COLOR_MATRIX = 0x84E6;
  public static final int GL_MULTISAMPLE_BIT = 0x20000000;
  public static final int GL_NORMAL_MAP = 0x8511;
  public static final int GL_REFLECTION_MAP = 0x8512;
  public static final int GL_COMPRESSED_ALPHA = 0x84E9;
  public static final int GL_COMPRESSED_LUMINANCE = 0x84EA;
  public static final int GL_COMPRESSED_LUMINANCE_ALPHA = 0x84EB;
  public static final int GL_COMPRESSED_INTENSITY = 0x84EC;
  public static final int GL_COMBINE = 0x8570;
  public static final int GL_COMBINE_RGB = 0x8571;
  public static final int GL_COMBINE_ALPHA = 0x8572;
  public static final int GL_SOURCE0_RGB = 0x8580;
  public static final int GL_SOURCE1_RGB = 0x8581;
  public static final int GL_SOURCE2_RGB = 0x8582;
  public static final int GL_SOURCE0_ALPHA = 0x8588;
  public static final int GL_SOURCE1_ALPHA = 0x8589;
  public static final int GL_SOURCE2_ALPHA = 0x858A;
  public static final int GL_OPERAND0_RGB = 0x8590;
  public static final int GL_OPERAND1_RGB = 0x8591;
  public static final int GL_OPERAND2_RGB = 0x8592;
  public static final int GL_OPERAND0_ALPHA = 0x8598;
  public static final int GL_OPERAND1_ALPHA = 0x8599;
  public static final int GL_OPERAND2_ALPHA = 0x859A;
  public static final int GL_RGB_SCALE = 0x8573;
  public static final int GL_ADD_SIGNED = 0x8574;
  public static final int GL_INTERPOLATE = 0x8575;
  public static final int GL_SUBTRACT = 0x84E7;
  public static final int GL_CONSTANT = 0x8576;
  public static final int GL_PRIMARY_COLOR = 0x8577;
  public static final int GL_PREVIOUS = 0x8578;
  public static final int GL_DOT3_RGB = 0x86AE;
  public static final int GL_DOT3_RGBA = 0x86AF;
  public void glActiveTexture(int texture);
  public void glSampleCoverage(float value, byte invert);
  public void glCompressedTexImage3D(int target, int level, int internalformat, int width, int height, int depth, int border, int imageSize, Addressable data);
  public void glCompressedTexImage2D(int target, int level, int internalformat, int width, int height, int border, int imageSize, Addressable data);
  public void glCompressedTexImage1D(int target, int level, int internalformat, int width, int border, int imageSize, Addressable data);
  public void glCompressedTexSubImage3D(int target, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int format, int imageSize, Addressable data);
  public void glCompressedTexSubImage2D(int target, int level, int xoffset, int yoffset, int width, int height, int format, int imageSize, Addressable data);
  public void glCompressedTexSubImage1D(int target, int level, int xoffset, int width, int format, int imageSize, Addressable data);
  public void glGetCompressedTexImage(int target, int level, Addressable img);
  public void glClientActiveTexture(int texture);
  public void glMultiTexCoord1d(int target, double s);
  public void glMultiTexCoord1dv(int target, Addressable v);
  public void glMultiTexCoord1f(int target, float s);
  public void glMultiTexCoord1fv(int target, Addressable v);
  public void glMultiTexCoord1i(int target, int s);
  public void glMultiTexCoord1iv(int target, Addressable v);
  public void glMultiTexCoord1s(int target, short s);
  public void glMultiTexCoord1sv(int target, Addressable v);
  public void glMultiTexCoord2d(int target, double s, double t);
  public void glMultiTexCoord2dv(int target, Addressable v);
  public void glMultiTexCoord2f(int target, float s, float t);
  public void glMultiTexCoord2fv(int target, Addressable v);
  public void glMultiTexCoord2i(int target, int s, int t);
  public void glMultiTexCoord2iv(int target, Addressable v);
  public void glMultiTexCoord2s(int target, short s, short t);
  public void glMultiTexCoord2sv(int target, Addressable v);
  public void glMultiTexCoord3d(int target, double s, double t, double r);
  public void glMultiTexCoord3dv(int target, Addressable v);
  public void glMultiTexCoord3f(int target, float s, float t, float r);
  public void glMultiTexCoord3fv(int target, Addressable v);
  public void glMultiTexCoord3i(int target, int s, int t, int r);
  public void glMultiTexCoord3iv(int target, Addressable v);
  public void glMultiTexCoord3s(int target, short s, short t, short r);
  public void glMultiTexCoord3sv(int target, Addressable v);
  public void glMultiTexCoord4d(int target, double s, double t, double r, double q);
  public void glMultiTexCoord4dv(int target, Addressable v);
  public void glMultiTexCoord4f(int target, float s, float t, float r, float q);
  public void glMultiTexCoord4fv(int target, Addressable v);
  public void glMultiTexCoord4i(int target, int s, int t, int r, int q);
  public void glMultiTexCoord4iv(int target, Addressable v);
  public void glMultiTexCoord4s(int target, short s, short t, short r, short q);
  public void glMultiTexCoord4sv(int target, Addressable v);
  public void glLoadTransposeMatrixf(Addressable m);
  public void glLoadTransposeMatrixd(Addressable m);
  public void glMultTransposeMatrixf(Addressable m);
  public void glMultTransposeMatrixd(Addressable m);
}
