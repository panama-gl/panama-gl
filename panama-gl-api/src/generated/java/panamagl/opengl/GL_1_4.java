package panamagl.opengl; 

import java.lang.foreign.*;

public interface GL_1_4 extends GL_1_3 {
  public static int GL_BLEND_DST_RGB = 0x80C8;
  public static int GL_BLEND_SRC_RGB = 0x80C9;
  public static int GL_BLEND_DST_ALPHA = 0x80CA;
  public static int GL_BLEND_SRC_ALPHA = 0x80CB;
  public static int GL_POINT_FADE_THRESHOLD_SIZE = 0x8128;
  public static int GL_DEPTH_COMPONENT16 = 0x81A5;
  public static int GL_DEPTH_COMPONENT24 = 0x81A6;
  public static int GL_DEPTH_COMPONENT32 = 0x81A7;
  public static int GL_MIRRORED_REPEAT = 0x8370;
  public static int GL_MAX_TEXTURE_LOD_BIAS = 0x84FD;
  public static int GL_TEXTURE_LOD_BIAS = 0x8501;
  public static int GL_INCR_WRAP = 0x8507;
  public static int GL_DECR_WRAP = 0x8508;
  public static int GL_TEXTURE_DEPTH_SIZE = 0x884A;
  public static int GL_TEXTURE_COMPARE_MODE = 0x884C;
  public static int GL_TEXTURE_COMPARE_FUNC = 0x884D;
  public static int GL_POINT_SIZE_MIN = 0x8126;
  public static int GL_POINT_SIZE_MAX = 0x8127;
  public static int GL_POINT_DISTANCE_ATTENUATION = 0x8129;
  public static int GL_GENERATE_MIPMAP = 0x8191;
  public static int GL_GENERATE_MIPMAP_HINT = 0x8192;
  public static int GL_FOG_COORDINATE_SOURCE = 0x8450;
  public static int GL_FOG_COORDINATE = 0x8451;
  public static int GL_FRAGMENT_DEPTH = 0x8452;
  public static int GL_CURRENT_FOG_COORDINATE = 0x8453;
  public static int GL_FOG_COORDINATE_ARRAY_TYPE = 0x8454;
  public static int GL_FOG_COORDINATE_ARRAY_STRIDE = 0x8455;
  public static int GL_FOG_COORDINATE_ARRAY_POINTER = 0x8456;
  public static int GL_FOG_COORDINATE_ARRAY = 0x8457;
  public static int GL_COLOR_SUM = 0x8458;
  public static int GL_CURRENT_SECONDARY_COLOR = 0x8459;
  public static int GL_SECONDARY_COLOR_ARRAY_SIZE = 0x845A;
  public static int GL_SECONDARY_COLOR_ARRAY_TYPE = 0x845B;
  public static int GL_SECONDARY_COLOR_ARRAY_STRIDE = 0x845C;
  public static int GL_SECONDARY_COLOR_ARRAY_POINTER = 0x845D;
  public static int GL_SECONDARY_COLOR_ARRAY = 0x845E;
  public static int GL_TEXTURE_FILTER_CONTROL = 0x8500;
  public static int GL_DEPTH_TEXTURE_MODE = 0x884B;
  public static int GL_COMPARE_R_TO_TEXTURE = 0x884E;
  public void glBlendFuncSeparate(int sfactorRGB, int dfactorRGB, int sfactorAlpha, int dfactorAlpha);
  public void glMultiDrawArrays(int mode, Addressable first, Addressable count, int drawcount);
  public void glMultiDrawElements(int mode, Addressable count, int type, Addressable indices, int drawcount);
  public void glPointParameterf(int pname, float param);
  public void glPointParameterfv(int pname, Addressable params);
  public void glPointParameteri(int pname, int param);
  public void glPointParameteriv(int pname, Addressable params);
  public void glFogCoordf(float coord);
  public void glFogCoordfv(Addressable coord);
  public void glFogCoordd(double coord);
  public void glFogCoorddv(Addressable coord);
  public void glFogCoordPointer(int type, int stride, Addressable pointer);
  public void glSecondaryColor3b(byte red, byte green, byte blue);
  public void glSecondaryColor3bv(Addressable v);
  public void glSecondaryColor3d(double red, double green, double blue);
  public void glSecondaryColor3dv(Addressable v);
  public void glSecondaryColor3f(float red, float green, float blue);
  public void glSecondaryColor3fv(Addressable v);
  public void glSecondaryColor3i(int red, int green, int blue);
  public void glSecondaryColor3iv(Addressable v);
  public void glSecondaryColor3s(short red, short green, short blue);
  public void glSecondaryColor3sv(Addressable v);
  public void glSecondaryColor3ub(byte red, byte green, byte blue);
  public void glSecondaryColor3ubv(Addressable v);
  public void glSecondaryColor3ui(int red, int green, int blue);
  public void glSecondaryColor3uiv(Addressable v);
  public void glSecondaryColor3us(short red, short green, short blue);
  public void glSecondaryColor3usv(Addressable v);
  public void glSecondaryColorPointer(int size, int type, int stride, Addressable pointer);
  public void glWindowPos2d(double x, double y);
  public void glWindowPos2dv(Addressable v);
  public void glWindowPos2f(float x, float y);
  public void glWindowPos2fv(Addressable v);
  public void glWindowPos2i(int x, int y);
  public void glWindowPos2iv(Addressable v);
  public void glWindowPos2s(short x, short y);
  public void glWindowPos2sv(Addressable v);
  public void glWindowPos3d(double x, double y, double z);
  public void glWindowPos3dv(Addressable v);
  public void glWindowPos3f(float x, float y, float z);
  public void glWindowPos3fv(Addressable v);
  public void glWindowPos3i(int x, int y, int z);
  public void glWindowPos3iv(Addressable v);
  public void glWindowPos3s(short x, short y, short z);
  public void glWindowPos3sv(Addressable v);
  public static int GL_BLEND_COLOR = 0x8005;
  public static int GL_BLEND_EQUATION = 0x8009;
  public static int GL_CONSTANT_COLOR = 0x8001;
  public static int GL_ONE_MINUS_CONSTANT_COLOR = 0x8002;
  public static int GL_CONSTANT_ALPHA = 0x8003;
  public static int GL_ONE_MINUS_CONSTANT_ALPHA = 0x8004;
  public static int GL_FUNC_ADD = 0x8006;
  public static int GL_FUNC_REVERSE_SUBTRACT = 0x800B;
  public static int GL_FUNC_SUBTRACT = 0x800A;
  public static int GL_MIN = 0x8007;
  public static int GL_MAX = 0x8008;
  public void glBlendColor(float red, float green, float blue, float alpha);
  public void glBlendEquation(int mode);
}
