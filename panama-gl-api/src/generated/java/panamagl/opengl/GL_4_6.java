package panamagl.opengl; 

import java.lang.foreign.*;

public interface GL_4_6 extends GL_4_5 {
  public static final int GL_CONTEXT_RELEASE_BEHAVIOR = 0x82FB;
  public static final int GL_NONE = 0;
  public static final int GL_CONTEXT_RELEASE_BEHAVIOR_FLUSH = 0x82FC;
  public static final int GL_SHADER_BINARY_FORMAT_SPIR_V = 0x9551;
  public static final int GL_SPIR_V_BINARY = 0x9552;
  public void glSpecializeShader(int shader, Addressable pEntryPoint, int numSpecializationConstants, Addressable pConstantIndex, Addressable pConstantValue);
  public static final int GL_PARAMETER_BUFFER = 0x80EE;
  public static final int GL_PARAMETER_BUFFER_BINDING = 0x80EF;
  public void glMultiDrawArraysIndirectCount(int mode, Addressable indirect, long drawcount, int maxdrawcount, int stride);
  public void glMultiDrawElementsIndirectCount(int mode, int type, Addressable indirect, long drawcount, int maxdrawcount, int stride);
  public static final int GL_CONTEXT_FLAG_NO_ERROR_BIT = 0x00000008;
  public static final int GL_VERTICES_SUBMITTED = 0x82EE;
  public static final int GL_PRIMITIVES_SUBMITTED = 0x82EF;
  public static final int GL_VERTEX_SHADER_INVOCATIONS = 0x82F0;
  public static final int GL_TESS_CONTROL_SHADER_PATCHES = 0x82F1;
  public static final int GL_TESS_EVALUATION_SHADER_INVOCATIONS = 0x82F2;
  public static final int GL_GEOMETRY_SHADER_INVOCATIONS = 0x887F;
  public static final int GL_GEOMETRY_SHADER_PRIMITIVES_EMITTED = 0x82F3;
  public static final int GL_FRAGMENT_SHADER_INVOCATIONS = 0x82F4;
  public static final int GL_COMPUTE_SHADER_INVOCATIONS = 0x82F5;
  public static final int GL_CLIPPING_INPUT_PRIMITIVES = 0x82F6;
  public static final int GL_CLIPPING_OUTPUT_PRIMITIVES = 0x82F7;
  public static final int GL_POLYGON_OFFSET_CLAMP = 0x8E1B;
  public void glPolygonOffsetClamp(float factor, float units, float clamp);
  public static final int GL_SPIR_V_EXTENSIONS = 0x9553;
  public static final int GL_NUM_SPIR_V_EXTENSIONS = 0x9554;
  public static final int GL_TEXTURE_MAX_ANISOTROPY = 0x84FE;
  public static final int GL_MAX_TEXTURE_MAX_ANISOTROPY = 0x84FF;
  public static final int GL_TRANSFORM_FEEDBACK_OVERFLOW = 0x82EC;
  public static final int GL_TRANSFORM_FEEDBACK_STREAM_OVERFLOW = 0x82ED;
}
