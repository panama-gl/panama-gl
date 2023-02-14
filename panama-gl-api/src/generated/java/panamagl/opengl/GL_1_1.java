package panamagl.opengl; 

import java.lang.foreign.*;

public interface GL_1_1 extends GL_1_0 {
  public static int GL_COLOR_LOGIC_OP = 0x0BF2;
  public static int GL_POLYGON_OFFSET_UNITS = 0x2A00;
  public static int GL_POLYGON_OFFSET_POINT = 0x2A01;
  public static int GL_POLYGON_OFFSET_LINE = 0x2A02;
  public static int GL_POLYGON_OFFSET_FILL = 0x8037;
  public static int GL_POLYGON_OFFSET_FACTOR = 0x8038;
  public static int GL_TEXTURE_BINDING_1D = 0x8068;
  public static int GL_TEXTURE_BINDING_2D = 0x8069;
  public static int GL_TEXTURE_INTERNAL_FORMAT = 0x1003;
  public static int GL_TEXTURE_RED_SIZE = 0x805C;
  public static int GL_TEXTURE_GREEN_SIZE = 0x805D;
  public static int GL_TEXTURE_BLUE_SIZE = 0x805E;
  public static int GL_TEXTURE_ALPHA_SIZE = 0x805F;
  public static int GL_DOUBLE = 0x140A;
  public static int GL_PROXY_TEXTURE_1D = 0x8063;
  public static int GL_PROXY_TEXTURE_2D = 0x8064;
  public static int GL_R3_G3_B2 = 0x2A10;
  public static int GL_RGB4 = 0x804F;
  public static int GL_RGB5 = 0x8050;
  public static int GL_RGB8 = 0x8051;
  public static int GL_RGB10 = 0x8052;
  public static int GL_RGB12 = 0x8053;
  public static int GL_RGB16 = 0x8054;
  public static int GL_RGBA2 = 0x8055;
  public static int GL_RGBA4 = 0x8056;
  public static int GL_RGB5_A1 = 0x8057;
  public static int GL_RGBA8 = 0x8058;
  public static int GL_RGB10_A2 = 0x8059;
  public static int GL_RGBA12 = 0x805A;
  public static int GL_RGBA16 = 0x805B;
  public static int GL_CLIENT_PIXEL_STORE_BIT = 0x00000001;
  public static int GL_CLIENT_VERTEX_ARRAY_BIT = 0x00000002;
  public static int GL_CLIENT_ALL_ATTRIB_BITS = 0xFFFFFFFF;
  public static int GL_VERTEX_ARRAY_POINTER = 0x808E;
  public static int GL_NORMAL_ARRAY_POINTER = 0x808F;
  public static int GL_COLOR_ARRAY_POINTER = 0x8090;
  public static int GL_INDEX_ARRAY_POINTER = 0x8091;
  public static int GL_TEXTURE_COORD_ARRAY_POINTER = 0x8092;
  public static int GL_EDGE_FLAG_ARRAY_POINTER = 0x8093;
  public static int GL_FEEDBACK_BUFFER_POINTER = 0x0DF0;
  public static int GL_SELECTION_BUFFER_POINTER = 0x0DF3;
  public static int GL_CLIENT_ATTRIB_STACK_DEPTH = 0x0BB1;
  public static int GL_INDEX_LOGIC_OP = 0x0BF1;
  public static int GL_MAX_CLIENT_ATTRIB_STACK_DEPTH = 0x0D3B;
  public static int GL_FEEDBACK_BUFFER_SIZE = 0x0DF1;
  public static int GL_FEEDBACK_BUFFER_TYPE = 0x0DF2;
  public static int GL_SELECTION_BUFFER_SIZE = 0x0DF4;
  public static int GL_VERTEX_ARRAY = 0x8074;
  public static int GL_NORMAL_ARRAY = 0x8075;
  public static int GL_COLOR_ARRAY = 0x8076;
  public static int GL_INDEX_ARRAY = 0x8077;
  public static int GL_TEXTURE_COORD_ARRAY = 0x8078;
  public static int GL_EDGE_FLAG_ARRAY = 0x8079;
  public static int GL_VERTEX_ARRAY_SIZE = 0x807A;
  public static int GL_VERTEX_ARRAY_TYPE = 0x807B;
  public static int GL_VERTEX_ARRAY_STRIDE = 0x807C;
  public static int GL_NORMAL_ARRAY_TYPE = 0x807E;
  public static int GL_NORMAL_ARRAY_STRIDE = 0x807F;
  public static int GL_COLOR_ARRAY_SIZE = 0x8081;
  public static int GL_COLOR_ARRAY_TYPE = 0x8082;
  public static int GL_COLOR_ARRAY_STRIDE = 0x8083;
  public static int GL_INDEX_ARRAY_TYPE = 0x8085;
  public static int GL_INDEX_ARRAY_STRIDE = 0x8086;
  public static int GL_TEXTURE_COORD_ARRAY_SIZE = 0x8088;
  public static int GL_TEXTURE_COORD_ARRAY_TYPE = 0x8089;
  public static int GL_TEXTURE_COORD_ARRAY_STRIDE = 0x808A;
  public static int GL_EDGE_FLAG_ARRAY_STRIDE = 0x808C;
  public static int GL_TEXTURE_LUMINANCE_SIZE = 0x8060;
  public static int GL_TEXTURE_INTENSITY_SIZE = 0x8061;
  public static int GL_TEXTURE_PRIORITY = 0x8066;
  public static int GL_TEXTURE_RESIDENT = 0x8067;
  public static int GL_ALPHA4 = 0x803B;
  public static int GL_ALPHA8 = 0x803C;
  public static int GL_ALPHA12 = 0x803D;
  public static int GL_ALPHA16 = 0x803E;
  public static int GL_LUMINANCE4 = 0x803F;
  public static int GL_LUMINANCE8 = 0x8040;
  public static int GL_LUMINANCE12 = 0x8041;
  public static int GL_LUMINANCE16 = 0x8042;
  public static int GL_LUMINANCE4_ALPHA4 = 0x8043;
  public static int GL_LUMINANCE6_ALPHA2 = 0x8044;
  public static int GL_LUMINANCE8_ALPHA8 = 0x8045;
  public static int GL_LUMINANCE12_ALPHA4 = 0x8046;
  public static int GL_LUMINANCE12_ALPHA12 = 0x8047;
  public static int GL_LUMINANCE16_ALPHA16 = 0x8048;
  public static int GL_INTENSITY = 0x8049;
  public static int GL_INTENSITY4 = 0x804A;
  public static int GL_INTENSITY8 = 0x804B;
  public static int GL_INTENSITY12 = 0x804C;
  public static int GL_INTENSITY16 = 0x804D;
  public static int GL_V2F = 0x2A20;
  public static int GL_V3F = 0x2A21;
  public static int GL_C4UB_V2F = 0x2A22;
  public static int GL_C4UB_V3F = 0x2A23;
  public static int GL_C3F_V3F = 0x2A24;
  public static int GL_N3F_V3F = 0x2A25;
  public static int GL_C4F_N3F_V3F = 0x2A26;
  public static int GL_T2F_V3F = 0x2A27;
  public static int GL_T4F_V4F = 0x2A28;
  public static int GL_T2F_C4UB_V3F = 0x2A29;
  public static int GL_T2F_C3F_V3F = 0x2A2A;
  public static int GL_T2F_N3F_V3F = 0x2A2B;
  public static int GL_T2F_C4F_N3F_V3F = 0x2A2C;
  public static int GL_T4F_C4F_N3F_V4F = 0x2A2D;
  public void glDrawArrays(int mode, int first, int count);
  public void glDrawElements(int mode, int count, int type, Addressable indices);
  public void glGetPointerv(int pname, Addressable params);
  public void glPolygonOffset(float factor, float units);
  public void glCopyTexImage1D(int target, int level, int internalformat, int x, int y, int width, int border);
  public void glCopyTexImage2D(int target, int level, int internalformat, int x, int y, int width, int height, int border);
  public void glCopyTexSubImage1D(int target, int level, int xoffset, int x, int y, int width);
  public void glCopyTexSubImage2D(int target, int level, int xoffset, int yoffset, int x, int y, int width, int height);
  public void glTexSubImage1D(int target, int level, int xoffset, int width, int format, int type, Addressable pixels);
  public void glTexSubImage2D(int target, int level, int xoffset, int yoffset, int width, int height, int format, int type, Addressable pixels);
  public void glBindTexture(int target, int texture);
  public void glDeleteTextures(int n, Addressable textures);
  public void glGenTextures(int n, Addressable textures);
  public byte glIsTexture(int texture);
  public void glArrayElement(int i);
  public void glColorPointer(int size, int type, int stride, Addressable pointer);
  public void glDisableClientState(int array);
  public void glEdgeFlagPointer(int stride, Addressable pointer);
  public void glEnableClientState(int array);
  public void glIndexPointer(int type, int stride, Addressable pointer);
  public void glInterleavedArrays(int format, int stride, Addressable pointer);
  public void glNormalPointer(int type, int stride, Addressable pointer);
  public void glTexCoordPointer(int size, int type, int stride, Addressable pointer);
  public void glVertexPointer(int size, int type, int stride, Addressable pointer);
  public byte glAreTexturesResident(int n, Addressable textures, Addressable residences);
  public void glPrioritizeTextures(int n, Addressable textures, Addressable priorities);
  public void glIndexub(byte c);
  public void glIndexubv(Addressable c);
  public void glPopClientAttrib();
  public void glPushClientAttrib(int mask);
}
