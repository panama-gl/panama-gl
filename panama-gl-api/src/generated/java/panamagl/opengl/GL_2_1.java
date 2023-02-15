package panamagl.opengl; 

import java.lang.foreign.*;

public interface GL_2_1 extends GL_2_0 {
  public static final int GL_PIXEL_PACK_BUFFER = 0x88EB;
  public static final int GL_PIXEL_UNPACK_BUFFER = 0x88EC;
  public static final int GL_PIXEL_PACK_BUFFER_BINDING = 0x88ED;
  public static final int GL_PIXEL_UNPACK_BUFFER_BINDING = 0x88EF;
  public static final int GL_FLOAT_MAT2x3 = 0x8B65;
  public static final int GL_FLOAT_MAT2x4 = 0x8B66;
  public static final int GL_FLOAT_MAT3x2 = 0x8B67;
  public static final int GL_FLOAT_MAT3x4 = 0x8B68;
  public static final int GL_FLOAT_MAT4x2 = 0x8B69;
  public static final int GL_FLOAT_MAT4x3 = 0x8B6A;
  public static final int GL_SRGB = 0x8C40;
  public static final int GL_SRGB8 = 0x8C41;
  public static final int GL_SRGB_ALPHA = 0x8C42;
  public static final int GL_SRGB8_ALPHA8 = 0x8C43;
  public static final int GL_COMPRESSED_SRGB = 0x8C48;
  public static final int GL_COMPRESSED_SRGB_ALPHA = 0x8C49;
  public static final int GL_CURRENT_RASTER_SECONDARY_COLOR = 0x845F;
  public static final int GL_SLUMINANCE_ALPHA = 0x8C44;
  public static final int GL_SLUMINANCE8_ALPHA8 = 0x8C45;
  public static final int GL_SLUMINANCE = 0x8C46;
  public static final int GL_SLUMINANCE8 = 0x8C47;
  public static final int GL_COMPRESSED_SLUMINANCE = 0x8C4A;
  public static final int GL_COMPRESSED_SLUMINANCE_ALPHA = 0x8C4B;
  public void glUniformMatrix2x3fv(int location, int count, byte transpose, Addressable value);
  public void glUniformMatrix3x2fv(int location, int count, byte transpose, Addressable value);
  public void glUniformMatrix2x4fv(int location, int count, byte transpose, Addressable value);
  public void glUniformMatrix4x2fv(int location, int count, byte transpose, Addressable value);
  public void glUniformMatrix3x4fv(int location, int count, byte transpose, Addressable value);
  public void glUniformMatrix4x3fv(int location, int count, byte transpose, Addressable value);
}
