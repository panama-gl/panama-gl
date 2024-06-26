package panamagl.opengl; 

import java.lang.foreign.*;

public interface GL_4_3 extends GL_4_2 {
  public static final int GL_NUM_SHADING_LANGUAGE_VERSIONS = 0x82E9;
  public static final int GL_VERTEX_ATTRIB_ARRAY_LONG = 0x874E;
  public static final int GL_COMPRESSED_RGB8_ETC2 = 0x9274;
  public static final int GL_COMPRESSED_SRGB8_ETC2 = 0x9275;
  public static final int GL_COMPRESSED_RGB8_PUNCHTHROUGH_ALPHA1_ETC2 = 0x9276;
  public static final int GL_COMPRESSED_SRGB8_PUNCHTHROUGH_ALPHA1_ETC2 = 0x9277;
  public static final int GL_COMPRESSED_RGBA8_ETC2_EAC = 0x9278;
  public static final int GL_COMPRESSED_SRGB8_ALPHA8_ETC2_EAC = 0x9279;
  public static final int GL_COMPRESSED_R11_EAC = 0x9270;
  public static final int GL_COMPRESSED_SIGNED_R11_EAC = 0x9271;
  public static final int GL_COMPRESSED_RG11_EAC = 0x9272;
  public static final int GL_COMPRESSED_SIGNED_RG11_EAC = 0x9273;
  public static final int GL_PRIMITIVE_RESTART_FIXED_INDEX = 0x8D69;
  public static final int GL_ANY_SAMPLES_PASSED_CONSERVATIVE = 0x8D6A;
  public static final int GL_MAX_ELEMENT_INDEX = 0x8D6B;
  public static final int GL_COMPUTE_SHADER = 0x91B9;
  public static final int GL_MAX_COMPUTE_UNIFORM_BLOCKS = 0x91BB;
  public static final int GL_MAX_COMPUTE_TEXTURE_IMAGE_UNITS = 0x91BC;
  public static final int GL_MAX_COMPUTE_IMAGE_UNIFORMS = 0x91BD;
  public static final int GL_MAX_COMPUTE_SHARED_MEMORY_SIZE = 0x8262;
  public static final int GL_MAX_COMPUTE_UNIFORM_COMPONENTS = 0x8263;
  public static final int GL_MAX_COMPUTE_ATOMIC_COUNTER_BUFFERS = 0x8264;
  public static final int GL_MAX_COMPUTE_ATOMIC_COUNTERS = 0x8265;
  public static final int GL_MAX_COMBINED_COMPUTE_UNIFORM_COMPONENTS = 0x8266;
  public static final int GL_MAX_COMPUTE_WORK_GROUP_INVOCATIONS = 0x90EB;
  public static final int GL_MAX_COMPUTE_WORK_GROUP_COUNT = 0x91BE;
  public static final int GL_MAX_COMPUTE_WORK_GROUP_SIZE = 0x91BF;
  public static final int GL_COMPUTE_WORK_GROUP_SIZE = 0x8267;
  public static final int GL_UNIFORM_BLOCK_REFERENCED_BY_COMPUTE_SHADER = 0x90EC;
  public static final int GL_ATOMIC_COUNTER_BUFFER_REFERENCED_BY_COMPUTE_SHADER = 0x90ED;
  public static final int GL_DISPATCH_INDIRECT_BUFFER = 0x90EE;
  public static final int GL_DISPATCH_INDIRECT_BUFFER_BINDING = 0x90EF;
  public static final int GL_COMPUTE_SHADER_BIT = 0x00000020;
  public static final int GL_DEBUG_OUTPUT_SYNCHRONOUS = 0x8242;
  public static final int GL_DEBUG_NEXT_LOGGED_MESSAGE_LENGTH = 0x8243;
  public static final int GL_DEBUG_CALLBACK_FUNCTION = 0x8244;
  public static final int GL_DEBUG_CALLBACK_USER_PARAM = 0x8245;
  public static final int GL_DEBUG_SOURCE_API = 0x8246;
  public static final int GL_DEBUG_SOURCE_WINDOW_SYSTEM = 0x8247;
  public static final int GL_DEBUG_SOURCE_SHADER_COMPILER = 0x8248;
  public static final int GL_DEBUG_SOURCE_THIRD_PARTY = 0x8249;
  public static final int GL_DEBUG_SOURCE_APPLICATION = 0x824A;
  public static final int GL_DEBUG_SOURCE_OTHER = 0x824B;
  public static final int GL_DEBUG_TYPE_ERROR = 0x824C;
  public static final int GL_DEBUG_TYPE_DEPRECATED_BEHAVIOR = 0x824D;
  public static final int GL_DEBUG_TYPE_UNDEFINED_BEHAVIOR = 0x824E;
  public static final int GL_DEBUG_TYPE_PORTABILITY = 0x824F;
  public static final int GL_DEBUG_TYPE_PERFORMANCE = 0x8250;
  public static final int GL_DEBUG_TYPE_OTHER = 0x8251;
  public static final int GL_MAX_DEBUG_MESSAGE_LENGTH = 0x9143;
  public static final int GL_MAX_DEBUG_LOGGED_MESSAGES = 0x9144;
  public static final int GL_DEBUG_LOGGED_MESSAGES = 0x9145;
  public static final int GL_DEBUG_SEVERITY_HIGH = 0x9146;
  public static final int GL_DEBUG_SEVERITY_MEDIUM = 0x9147;
  public static final int GL_DEBUG_SEVERITY_LOW = 0x9148;
  public static final int GL_DEBUG_TYPE_MARKER = 0x8268;
  public static final int GL_DEBUG_TYPE_PUSH_GROUP = 0x8269;
  public static final int GL_DEBUG_TYPE_POP_GROUP = 0x826A;
  public static final int GL_DEBUG_SEVERITY_NOTIFICATION = 0x826B;
  public static final int GL_MAX_DEBUG_GROUP_STACK_DEPTH = 0x826C;
  public static final int GL_DEBUG_GROUP_STACK_DEPTH = 0x826D;
  public static final int GL_BUFFER = 0x82E0;
  public static final int GL_SHADER = 0x82E1;
  public static final int GL_PROGRAM = 0x82E2;
  public static final int GL_VERTEX_ARRAY = 0x8074;
  public static final int GL_QUERY = 0x82E3;
  public static final int GL_PROGRAM_PIPELINE = 0x82E4;
  public static final int GL_SAMPLER = 0x82E6;
  public static final int GL_MAX_LABEL_LENGTH = 0x82E8;
  public static final int GL_DEBUG_OUTPUT = 0x92E0;
  public static final int GL_CONTEXT_FLAG_DEBUG_BIT = 0x00000002;
  public static final int GL_MAX_UNIFORM_LOCATIONS = 0x826E;
  public static final int GL_FRAMEBUFFER_DEFAULT_WIDTH = 0x9310;
  public static final int GL_FRAMEBUFFER_DEFAULT_HEIGHT = 0x9311;
  public static final int GL_FRAMEBUFFER_DEFAULT_LAYERS = 0x9312;
  public static final int GL_FRAMEBUFFER_DEFAULT_SAMPLES = 0x9313;
  public static final int GL_FRAMEBUFFER_DEFAULT_FIXED_SAMPLE_LOCATIONS = 0x9314;
  public static final int GL_MAX_FRAMEBUFFER_WIDTH = 0x9315;
  public static final int GL_MAX_FRAMEBUFFER_HEIGHT = 0x9316;
  public static final int GL_MAX_FRAMEBUFFER_LAYERS = 0x9317;
  public static final int GL_MAX_FRAMEBUFFER_SAMPLES = 0x9318;
  public static final int GL_INTERNALFORMAT_SUPPORTED = 0x826F;
  public static final int GL_INTERNALFORMAT_PREFERRED = 0x8270;
  public static final int GL_INTERNALFORMAT_RED_SIZE = 0x8271;
  public static final int GL_INTERNALFORMAT_GREEN_SIZE = 0x8272;
  public static final int GL_INTERNALFORMAT_BLUE_SIZE = 0x8273;
  public static final int GL_INTERNALFORMAT_ALPHA_SIZE = 0x8274;
  public static final int GL_INTERNALFORMAT_DEPTH_SIZE = 0x8275;
  public static final int GL_INTERNALFORMAT_STENCIL_SIZE = 0x8276;
  public static final int GL_INTERNALFORMAT_SHARED_SIZE = 0x8277;
  public static final int GL_INTERNALFORMAT_RED_TYPE = 0x8278;
  public static final int GL_INTERNALFORMAT_GREEN_TYPE = 0x8279;
  public static final int GL_INTERNALFORMAT_BLUE_TYPE = 0x827A;
  public static final int GL_INTERNALFORMAT_ALPHA_TYPE = 0x827B;
  public static final int GL_INTERNALFORMAT_DEPTH_TYPE = 0x827C;
  public static final int GL_INTERNALFORMAT_STENCIL_TYPE = 0x827D;
  public static final int GL_MAX_WIDTH = 0x827E;
  public static final int GL_MAX_HEIGHT = 0x827F;
  public static final int GL_MAX_DEPTH = 0x8280;
  public static final int GL_MAX_LAYERS = 0x8281;
  public static final int GL_MAX_COMBINED_DIMENSIONS = 0x8282;
  public static final int GL_COLOR_COMPONENTS = 0x8283;
  public static final int GL_DEPTH_COMPONENTS = 0x8284;
  public static final int GL_STENCIL_COMPONENTS = 0x8285;
  public static final int GL_COLOR_RENDERABLE = 0x8286;
  public static final int GL_DEPTH_RENDERABLE = 0x8287;
  public static final int GL_STENCIL_RENDERABLE = 0x8288;
  public static final int GL_FRAMEBUFFER_RENDERABLE = 0x8289;
  public static final int GL_FRAMEBUFFER_RENDERABLE_LAYERED = 0x828A;
  public static final int GL_FRAMEBUFFER_BLEND = 0x828B;
  public static final int GL_READ_PIXELS = 0x828C;
  public static final int GL_READ_PIXELS_FORMAT = 0x828D;
  public static final int GL_READ_PIXELS_TYPE = 0x828E;
  public static final int GL_TEXTURE_IMAGE_FORMAT = 0x828F;
  public static final int GL_TEXTURE_IMAGE_TYPE = 0x8290;
  public static final int GL_GET_TEXTURE_IMAGE_FORMAT = 0x8291;
  public static final int GL_GET_TEXTURE_IMAGE_TYPE = 0x8292;
  public static final int GL_MIPMAP = 0x8293;
  public static final int GL_MANUAL_GENERATE_MIPMAP = 0x8294;
  public static final int GL_AUTO_GENERATE_MIPMAP = 0x8295;
  public static final int GL_COLOR_ENCODING = 0x8296;
  public static final int GL_SRGB_READ = 0x8297;
  public static final int GL_SRGB_WRITE = 0x8298;
  public static final int GL_FILTER = 0x829A;
  public static final int GL_VERTEX_TEXTURE = 0x829B;
  public static final int GL_TESS_CONTROL_TEXTURE = 0x829C;
  public static final int GL_TESS_EVALUATION_TEXTURE = 0x829D;
  public static final int GL_GEOMETRY_TEXTURE = 0x829E;
  public static final int GL_FRAGMENT_TEXTURE = 0x829F;
  public static final int GL_COMPUTE_TEXTURE = 0x82A0;
  public static final int GL_TEXTURE_SHADOW = 0x82A1;
  public static final int GL_TEXTURE_GATHER = 0x82A2;
  public static final int GL_TEXTURE_GATHER_SHADOW = 0x82A3;
  public static final int GL_SHADER_IMAGE_LOAD = 0x82A4;
  public static final int GL_SHADER_IMAGE_STORE = 0x82A5;
  public static final int GL_SHADER_IMAGE_ATOMIC = 0x82A6;
  public static final int GL_IMAGE_TEXEL_SIZE = 0x82A7;
  public static final int GL_IMAGE_COMPATIBILITY_CLASS = 0x82A8;
  public static final int GL_IMAGE_PIXEL_FORMAT = 0x82A9;
  public static final int GL_IMAGE_PIXEL_TYPE = 0x82AA;
  public static final int GL_SIMULTANEOUS_TEXTURE_AND_DEPTH_TEST = 0x82AC;
  public static final int GL_SIMULTANEOUS_TEXTURE_AND_STENCIL_TEST = 0x82AD;
  public static final int GL_SIMULTANEOUS_TEXTURE_AND_DEPTH_WRITE = 0x82AE;
  public static final int GL_SIMULTANEOUS_TEXTURE_AND_STENCIL_WRITE = 0x82AF;
  public static final int GL_TEXTURE_COMPRESSED_BLOCK_WIDTH = 0x82B1;
  public static final int GL_TEXTURE_COMPRESSED_BLOCK_HEIGHT = 0x82B2;
  public static final int GL_TEXTURE_COMPRESSED_BLOCK_SIZE = 0x82B3;
  public static final int GL_CLEAR_BUFFER = 0x82B4;
  public static final int GL_TEXTURE_VIEW = 0x82B5;
  public static final int GL_VIEW_COMPATIBILITY_CLASS = 0x82B6;
  public static final int GL_FULL_SUPPORT = 0x82B7;
  public static final int GL_CAVEAT_SUPPORT = 0x82B8;
  public static final int GL_IMAGE_CLASS_4_X_32 = 0x82B9;
  public static final int GL_IMAGE_CLASS_2_X_32 = 0x82BA;
  public static final int GL_IMAGE_CLASS_1_X_32 = 0x82BB;
  public static final int GL_IMAGE_CLASS_4_X_16 = 0x82BC;
  public static final int GL_IMAGE_CLASS_2_X_16 = 0x82BD;
  public static final int GL_IMAGE_CLASS_1_X_16 = 0x82BE;
  public static final int GL_IMAGE_CLASS_4_X_8 = 0x82BF;
  public static final int GL_IMAGE_CLASS_2_X_8 = 0x82C0;
  public static final int GL_IMAGE_CLASS_1_X_8 = 0x82C1;
  public static final int GL_IMAGE_CLASS_11_11_10 = 0x82C2;
  public static final int GL_IMAGE_CLASS_10_10_10_2 = 0x82C3;
  public static final int GL_VIEW_CLASS_128_BITS = 0x82C4;
  public static final int GL_VIEW_CLASS_96_BITS = 0x82C5;
  public static final int GL_VIEW_CLASS_64_BITS = 0x82C6;
  public static final int GL_VIEW_CLASS_48_BITS = 0x82C7;
  public static final int GL_VIEW_CLASS_32_BITS = 0x82C8;
  public static final int GL_VIEW_CLASS_24_BITS = 0x82C9;
  public static final int GL_VIEW_CLASS_16_BITS = 0x82CA;
  public static final int GL_VIEW_CLASS_8_BITS = 0x82CB;
  public static final int GL_VIEW_CLASS_S3TC_DXT1_RGB = 0x82CC;
  public static final int GL_VIEW_CLASS_S3TC_DXT1_RGBA = 0x82CD;
  public static final int GL_VIEW_CLASS_S3TC_DXT3_RGBA = 0x82CE;
  public static final int GL_VIEW_CLASS_S3TC_DXT5_RGBA = 0x82CF;
  public static final int GL_VIEW_CLASS_RGTC1_RED = 0x82D0;
  public static final int GL_VIEW_CLASS_RGTC2_RG = 0x82D1;
  public static final int GL_VIEW_CLASS_BPTC_UNORM = 0x82D2;
  public static final int GL_VIEW_CLASS_BPTC_FLOAT = 0x82D3;
  public static final int GL_UNIFORM = 0x92E1;
  public static final int GL_UNIFORM_BLOCK = 0x92E2;
  public static final int GL_PROGRAM_INPUT = 0x92E3;
  public static final int GL_PROGRAM_OUTPUT = 0x92E4;
  public static final int GL_BUFFER_VARIABLE = 0x92E5;
  public static final int GL_SHADER_STORAGE_BLOCK = 0x92E6;
  public static final int GL_VERTEX_SUBROUTINE = 0x92E8;
  public static final int GL_TESS_CONTROL_SUBROUTINE = 0x92E9;
  public static final int GL_TESS_EVALUATION_SUBROUTINE = 0x92EA;
  public static final int GL_GEOMETRY_SUBROUTINE = 0x92EB;
  public static final int GL_FRAGMENT_SUBROUTINE = 0x92EC;
  public static final int GL_COMPUTE_SUBROUTINE = 0x92ED;
  public static final int GL_VERTEX_SUBROUTINE_UNIFORM = 0x92EE;
  public static final int GL_TESS_CONTROL_SUBROUTINE_UNIFORM = 0x92EF;
  public static final int GL_TESS_EVALUATION_SUBROUTINE_UNIFORM = 0x92F0;
  public static final int GL_GEOMETRY_SUBROUTINE_UNIFORM = 0x92F1;
  public static final int GL_FRAGMENT_SUBROUTINE_UNIFORM = 0x92F2;
  public static final int GL_COMPUTE_SUBROUTINE_UNIFORM = 0x92F3;
  public static final int GL_TRANSFORM_FEEDBACK_VARYING = 0x92F4;
  public static final int GL_ACTIVE_RESOURCES = 0x92F5;
  public static final int GL_MAX_NAME_LENGTH = 0x92F6;
  public static final int GL_MAX_NUM_ACTIVE_VARIABLES = 0x92F7;
  public static final int GL_MAX_NUM_COMPATIBLE_SUBROUTINES = 0x92F8;
  public static final int GL_NAME_LENGTH = 0x92F9;
  public static final int GL_TYPE = 0x92FA;
  public static final int GL_ARRAY_SIZE = 0x92FB;
  public static final int GL_OFFSET = 0x92FC;
  public static final int GL_BLOCK_INDEX = 0x92FD;
  public static final int GL_ARRAY_STRIDE = 0x92FE;
  public static final int GL_MATRIX_STRIDE = 0x92FF;
  public static final int GL_IS_ROW_MAJOR = 0x9300;
  public static final int GL_ATOMIC_COUNTER_BUFFER_INDEX = 0x9301;
  public static final int GL_BUFFER_BINDING = 0x9302;
  public static final int GL_BUFFER_DATA_SIZE = 0x9303;
  public static final int GL_NUM_ACTIVE_VARIABLES = 0x9304;
  public static final int GL_ACTIVE_VARIABLES = 0x9305;
  public static final int GL_REFERENCED_BY_VERTEX_SHADER = 0x9306;
  public static final int GL_REFERENCED_BY_TESS_CONTROL_SHADER = 0x9307;
  public static final int GL_REFERENCED_BY_TESS_EVALUATION_SHADER = 0x9308;
  public static final int GL_REFERENCED_BY_GEOMETRY_SHADER = 0x9309;
  public static final int GL_REFERENCED_BY_FRAGMENT_SHADER = 0x930A;
  public static final int GL_REFERENCED_BY_COMPUTE_SHADER = 0x930B;
  public static final int GL_TOP_LEVEL_ARRAY_SIZE = 0x930C;
  public static final int GL_TOP_LEVEL_ARRAY_STRIDE = 0x930D;
  public static final int GL_LOCATION = 0x930E;
  public static final int GL_LOCATION_INDEX = 0x930F;
  public static final int GL_IS_PER_PATCH = 0x92E7;
  public static final int GL_SHADER_STORAGE_BUFFER = 0x90D2;
  public static final int GL_SHADER_STORAGE_BUFFER_BINDING = 0x90D3;
  public static final int GL_SHADER_STORAGE_BUFFER_START = 0x90D4;
  public static final int GL_SHADER_STORAGE_BUFFER_SIZE = 0x90D5;
  public static final int GL_MAX_VERTEX_SHADER_STORAGE_BLOCKS = 0x90D6;
  public static final int GL_MAX_GEOMETRY_SHADER_STORAGE_BLOCKS = 0x90D7;
  public static final int GL_MAX_TESS_CONTROL_SHADER_STORAGE_BLOCKS = 0x90D8;
  public static final int GL_MAX_TESS_EVALUATION_SHADER_STORAGE_BLOCKS = 0x90D9;
  public static final int GL_MAX_FRAGMENT_SHADER_STORAGE_BLOCKS = 0x90DA;
  public static final int GL_MAX_COMPUTE_SHADER_STORAGE_BLOCKS = 0x90DB;
  public static final int GL_MAX_COMBINED_SHADER_STORAGE_BLOCKS = 0x90DC;
  public static final int GL_MAX_SHADER_STORAGE_BUFFER_BINDINGS = 0x90DD;
  public static final int GL_MAX_SHADER_STORAGE_BLOCK_SIZE = 0x90DE;
  public static final int GL_SHADER_STORAGE_BUFFER_OFFSET_ALIGNMENT = 0x90DF;
  public static final int GL_SHADER_STORAGE_BARRIER_BIT = 0x00002000;
  public static final int GL_MAX_COMBINED_SHADER_OUTPUT_RESOURCES = 0x8F39;
  public static final int GL_DEPTH_STENCIL_TEXTURE_MODE = 0x90EA;
  public static final int GL_TEXTURE_BUFFER_OFFSET = 0x919D;
  public static final int GL_TEXTURE_BUFFER_SIZE = 0x919E;
  public static final int GL_TEXTURE_BUFFER_OFFSET_ALIGNMENT = 0x919F;
  public static final int GL_TEXTURE_VIEW_MIN_LEVEL = 0x82DB;
  public static final int GL_TEXTURE_VIEW_NUM_LEVELS = 0x82DC;
  public static final int GL_TEXTURE_VIEW_MIN_LAYER = 0x82DD;
  public static final int GL_TEXTURE_VIEW_NUM_LAYERS = 0x82DE;
  public static final int GL_TEXTURE_IMMUTABLE_LEVELS = 0x82DF;
  public static final int GL_VERTEX_ATTRIB_BINDING = 0x82D4;
  public static final int GL_VERTEX_ATTRIB_RELATIVE_OFFSET = 0x82D5;
  public static final int GL_VERTEX_BINDING_DIVISOR = 0x82D6;
  public static final int GL_VERTEX_BINDING_OFFSET = 0x82D7;
  public static final int GL_VERTEX_BINDING_STRIDE = 0x82D8;
  public static final int GL_MAX_VERTEX_ATTRIB_RELATIVE_OFFSET = 0x82D9;
  public static final int GL_MAX_VERTEX_ATTRIB_BINDINGS = 0x82DA;
  public static final int GL_VERTEX_BINDING_BUFFER = 0x8F4F;
  public void glClearBufferData(int target, int internalformat, int format, int type, MemorySegment data);
  public void glClearBufferSubData(int target, int internalformat, long offset, long size, int format, int type, MemorySegment data);
  public void glDispatchCompute(int num_groups_x, int num_groups_y, int num_groups_z);
  public void glDispatchComputeIndirect(long indirect);
  public void glCopyImageSubData(int srcName, int srcTarget, int srcLevel, int srcX, int srcY, int srcZ, int dstName, int dstTarget, int dstLevel, int dstX, int dstY, int dstZ, int srcWidth, int srcHeight, int srcDepth);
  public void glFramebufferParameteri(int target, int pname, int param);
  public void glGetFramebufferParameteriv(int target, int pname, MemorySegment params);
  public void glGetInternalformati64v(int target, int internalformat, int pname, int count, MemorySegment params);
  public void glInvalidateTexSubImage(int texture, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth);
  public void glInvalidateTexImage(int texture, int level);
  public void glInvalidateBufferSubData(int buffer, long offset, long length);
  public void glInvalidateBufferData(int buffer);
  public void glInvalidateFramebuffer(int target, int numAttachments, MemorySegment attachments);
  public void glInvalidateSubFramebuffer(int target, int numAttachments, MemorySegment attachments, int x, int y, int width, int height);
  public void glMultiDrawArraysIndirect(int mode, MemorySegment indirect, int drawcount, int stride);
  public void glMultiDrawElementsIndirect(int mode, int type, MemorySegment indirect, int drawcount, int stride);
  public void glGetProgramInterfaceiv(int program, int programInterface, int pname, MemorySegment params);
  public int glGetProgramResourceIndex(int program, int programInterface, MemorySegment name);
  public void glGetProgramResourceName(int program, int programInterface, int index, int bufSize, MemorySegment length, MemorySegment name);
  public void glGetProgramResourceiv(int program, int programInterface, int index, int propCount, MemorySegment props, int count, MemorySegment length, MemorySegment params);
  public int glGetProgramResourceLocation(int program, int programInterface, MemorySegment name);
  public int glGetProgramResourceLocationIndex(int program, int programInterface, MemorySegment name);
  public void glShaderStorageBlockBinding(int program, int storageBlockIndex, int storageBlockBinding);
  public void glTexBufferRange(int target, int internalformat, int buffer, long offset, long size);
  public void glTexStorage2DMultisample(int target, int samples, int internalformat, int width, int height, byte fixedsamplelocations);
  public void glTexStorage3DMultisample(int target, int samples, int internalformat, int width, int height, int depth, byte fixedsamplelocations);
  public void glTextureView(int texture, int target, int origtexture, int internalformat, int minlevel, int numlevels, int minlayer, int numlayers);
  public void glBindVertexBuffer(int bindingindex, int buffer, long offset, int stride);
  public void glVertexAttribFormat(int attribindex, int size, int type, byte normalized, int relativeoffset);
  public void glVertexAttribIFormat(int attribindex, int size, int type, int relativeoffset);
  public void glVertexAttribLFormat(int attribindex, int size, int type, int relativeoffset);
  public void glVertexAttribBinding(int attribindex, int bindingindex);
  public void glVertexBindingDivisor(int bindingindex, int divisor);
  public void glDebugMessageControl(int source, int type, int severity, int count, MemorySegment ids, byte enabled);
  public void glDebugMessageInsert(int source, int type, int id, int severity, int length, MemorySegment buf);
  public void glDebugMessageCallback(MemorySegment callback, MemorySegment userParam);
  public int glGetDebugMessageLog(int count, int bufSize, MemorySegment sources, MemorySegment types, MemorySegment ids, MemorySegment severities, MemorySegment lengths, MemorySegment messageLog);
  public void glPushDebugGroup(int source, int id, int length, MemorySegment message);
  public void glPopDebugGroup();
  public void glObjectLabel(int identifier, int name, int length, MemorySegment label);
  public void glGetObjectLabel(int identifier, int name, int bufSize, MemorySegment length, MemorySegment label);
  public void glObjectPtrLabel(MemorySegment ptr, int length, MemorySegment label);
  public void glGetObjectPtrLabel(MemorySegment ptr, int bufSize, MemorySegment length, MemorySegment label);
  public void glGetPointerv(int pname, MemorySegment params);
  public static final int GL_DISPLAY_LIST = 0x82E7;
  public static final int GL_STACK_UNDERFLOW = 0x0504;
  public static final int GL_STACK_OVERFLOW = 0x0503;
}
