package panamagl.opengl; 

import java.lang.foreign.*;

public interface GL_1_0  {
  public static int GL_DEPTH_BUFFER_BIT = 0x00000100;
  public static int GL_STENCIL_BUFFER_BIT = 0x00000400;
  public static int GL_COLOR_BUFFER_BIT = 0x00004000;
  public static int GL_FALSE = 0;
  public static int GL_TRUE = 1;
  public static int GL_POINTS = 0x0000;
  public static int GL_LINES = 0x0001;
  public static int GL_LINE_LOOP = 0x0002;
  public static int GL_LINE_STRIP = 0x0003;
  public static int GL_TRIANGLES = 0x0004;
  public static int GL_TRIANGLE_STRIP = 0x0005;
  public static int GL_TRIANGLE_FAN = 0x0006;
  public static int GL_QUADS = 0x0007;
  public static int GL_NEVER = 0x0200;
  public static int GL_LESS = 0x0201;
  public static int GL_EQUAL = 0x0202;
  public static int GL_LEQUAL = 0x0203;
  public static int GL_GREATER = 0x0204;
  public static int GL_NOTEQUAL = 0x0205;
  public static int GL_GEQUAL = 0x0206;
  public static int GL_ALWAYS = 0x0207;
  public static int GL_ZERO = 0;
  public static int GL_ONE = 1;
  public static int GL_SRC_COLOR = 0x0300;
  public static int GL_ONE_MINUS_SRC_COLOR = 0x0301;
  public static int GL_SRC_ALPHA = 0x0302;
  public static int GL_ONE_MINUS_SRC_ALPHA = 0x0303;
  public static int GL_DST_ALPHA = 0x0304;
  public static int GL_ONE_MINUS_DST_ALPHA = 0x0305;
  public static int GL_DST_COLOR = 0x0306;
  public static int GL_ONE_MINUS_DST_COLOR = 0x0307;
  public static int GL_SRC_ALPHA_SATURATE = 0x0308;
  public static int GL_NONE = 0;
  public static int GL_FRONT_LEFT = 0x0400;
  public static int GL_FRONT_RIGHT = 0x0401;
  public static int GL_BACK_LEFT = 0x0402;
  public static int GL_BACK_RIGHT = 0x0403;
  public static int GL_FRONT = 0x0404;
  public static int GL_BACK = 0x0405;
  public static int GL_LEFT = 0x0406;
  public static int GL_RIGHT = 0x0407;
  public static int GL_FRONT_AND_BACK = 0x0408;
  public static int GL_NO_ERROR = 0;
  public static int GL_INVALID_ENUM = 0x0500;
  public static int GL_INVALID_VALUE = 0x0501;
  public static int GL_INVALID_OPERATION = 0x0502;
  public static int GL_OUT_OF_MEMORY = 0x0505;
  public static int GL_CW = 0x0900;
  public static int GL_CCW = 0x0901;
  public static int GL_POINT_SIZE = 0x0B11;
  public static int GL_POINT_SIZE_RANGE = 0x0B12;
  public static int GL_POINT_SIZE_GRANULARITY = 0x0B13;
  public static int GL_LINE_SMOOTH = 0x0B20;
  public static int GL_LINE_WIDTH = 0x0B21;
  public static int GL_LINE_WIDTH_RANGE = 0x0B22;
  public static int GL_LINE_WIDTH_GRANULARITY = 0x0B23;
  public static int GL_POLYGON_MODE = 0x0B40;
  public static int GL_POLYGON_SMOOTH = 0x0B41;
  public static int GL_CULL_FACE = 0x0B44;
  public static int GL_CULL_FACE_MODE = 0x0B45;
  public static int GL_FRONT_FACE = 0x0B46;
  public static int GL_DEPTH_RANGE = 0x0B70;
  public static int GL_DEPTH_TEST = 0x0B71;
  public static int GL_DEPTH_WRITEMASK = 0x0B72;
  public static int GL_DEPTH_CLEAR_VALUE = 0x0B73;
  public static int GL_DEPTH_FUNC = 0x0B74;
  public static int GL_STENCIL_TEST = 0x0B90;
  public static int GL_STENCIL_CLEAR_VALUE = 0x0B91;
  public static int GL_STENCIL_FUNC = 0x0B92;
  public static int GL_STENCIL_VALUE_MASK = 0x0B93;
  public static int GL_STENCIL_FAIL = 0x0B94;
  public static int GL_STENCIL_PASS_DEPTH_FAIL = 0x0B95;
  public static int GL_STENCIL_PASS_DEPTH_PASS = 0x0B96;
  public static int GL_STENCIL_REF = 0x0B97;
  public static int GL_STENCIL_WRITEMASK = 0x0B98;
  public static int GL_VIEWPORT = 0x0BA2;
  public static int GL_DITHER = 0x0BD0;
  public static int GL_BLEND_DST = 0x0BE0;
  public static int GL_BLEND_SRC = 0x0BE1;
  public static int GL_BLEND = 0x0BE2;
  public static int GL_LOGIC_OP_MODE = 0x0BF0;
  public static int GL_DRAW_BUFFER = 0x0C01;
  public static int GL_READ_BUFFER = 0x0C02;
  public static int GL_SCISSOR_BOX = 0x0C10;
  public static int GL_SCISSOR_TEST = 0x0C11;
  public static int GL_COLOR_CLEAR_VALUE = 0x0C22;
  public static int GL_COLOR_WRITEMASK = 0x0C23;
  public static int GL_DOUBLEBUFFER = 0x0C32;
  public static int GL_STEREO = 0x0C33;
  public static int GL_LINE_SMOOTH_HINT = 0x0C52;
  public static int GL_POLYGON_SMOOTH_HINT = 0x0C53;
  public static int GL_UNPACK_SWAP_BYTES = 0x0CF0;
  public static int GL_UNPACK_LSB_FIRST = 0x0CF1;
  public static int GL_UNPACK_ROW_LENGTH = 0x0CF2;
  public static int GL_UNPACK_SKIP_ROWS = 0x0CF3;
  public static int GL_UNPACK_SKIP_PIXELS = 0x0CF4;
  public static int GL_UNPACK_ALIGNMENT = 0x0CF5;
  public static int GL_PACK_SWAP_BYTES = 0x0D00;
  public static int GL_PACK_LSB_FIRST = 0x0D01;
  public static int GL_PACK_ROW_LENGTH = 0x0D02;
  public static int GL_PACK_SKIP_ROWS = 0x0D03;
  public static int GL_PACK_SKIP_PIXELS = 0x0D04;
  public static int GL_PACK_ALIGNMENT = 0x0D05;
  public static int GL_MAX_TEXTURE_SIZE = 0x0D33;
  public static int GL_MAX_VIEWPORT_DIMS = 0x0D3A;
  public static int GL_SUBPIXEL_BITS = 0x0D50;
  public static int GL_TEXTURE_1D = 0x0DE0;
  public static int GL_TEXTURE_2D = 0x0DE1;
  public static int GL_TEXTURE_WIDTH = 0x1000;
  public static int GL_TEXTURE_HEIGHT = 0x1001;
  public static int GL_TEXTURE_BORDER_COLOR = 0x1004;
  public static int GL_DONT_CARE = 0x1100;
  public static int GL_FASTEST = 0x1101;
  public static int GL_NICEST = 0x1102;
  public static int GL_BYTE = 0x1400;
  public static int GL_UNSIGNED_BYTE = 0x1401;
  public static int GL_SHORT = 0x1402;
  public static int GL_UNSIGNED_SHORT = 0x1403;
  public static int GL_INT = 0x1404;
  public static int GL_UNSIGNED_INT = 0x1405;
  public static int GL_FLOAT = 0x1406;
  public static int GL_STACK_OVERFLOW = 0x0503;
  public static int GL_STACK_UNDERFLOW = 0x0504;
  public static int GL_CLEAR = 0x1500;
  public static int GL_AND = 0x1501;
  public static int GL_AND_REVERSE = 0x1502;
  public static int GL_COPY = 0x1503;
  public static int GL_AND_INVERTED = 0x1504;
  public static int GL_NOOP = 0x1505;
  public static int GL_XOR = 0x1506;
  public static int GL_OR = 0x1507;
  public static int GL_NOR = 0x1508;
  public static int GL_EQUIV = 0x1509;
  public static int GL_INVERT = 0x150A;
  public static int GL_OR_REVERSE = 0x150B;
  public static int GL_COPY_INVERTED = 0x150C;
  public static int GL_OR_INVERTED = 0x150D;
  public static int GL_NAND = 0x150E;
  public static int GL_SET = 0x150F;
  public static int GL_TEXTURE = 0x1702;
  public static int GL_COLOR = 0x1800;
  public static int GL_DEPTH = 0x1801;
  public static int GL_STENCIL = 0x1802;
  public static int GL_STENCIL_INDEX = 0x1901;
  public static int GL_DEPTH_COMPONENT = 0x1902;
  public static int GL_RED = 0x1903;
  public static int GL_GREEN = 0x1904;
  public static int GL_BLUE = 0x1905;
  public static int GL_ALPHA = 0x1906;
  public static int GL_RGB = 0x1907;
  public static int GL_RGBA = 0x1908;
  public static int GL_POINT = 0x1B00;
  public static int GL_LINE = 0x1B01;
  public static int GL_FILL = 0x1B02;
  public static int GL_KEEP = 0x1E00;
  public static int GL_REPLACE = 0x1E01;
  public static int GL_INCR = 0x1E02;
  public static int GL_DECR = 0x1E03;
  public static int GL_VENDOR = 0x1F00;
  public static int GL_RENDERER = 0x1F01;
  public static int GL_VERSION = 0x1F02;
  public static int GL_EXTENSIONS = 0x1F03;
  public static int GL_NEAREST = 0x2600;
  public static int GL_LINEAR = 0x2601;
  public static int GL_NEAREST_MIPMAP_NEAREST = 0x2700;
  public static int GL_LINEAR_MIPMAP_NEAREST = 0x2701;
  public static int GL_NEAREST_MIPMAP_LINEAR = 0x2702;
  public static int GL_LINEAR_MIPMAP_LINEAR = 0x2703;
  public static int GL_TEXTURE_MAG_FILTER = 0x2800;
  public static int GL_TEXTURE_MIN_FILTER = 0x2801;
  public static int GL_TEXTURE_WRAP_S = 0x2802;
  public static int GL_TEXTURE_WRAP_T = 0x2803;
  public static int GL_REPEAT = 0x2901;
  public static int GL_CURRENT_BIT = 0x00000001;
  public static int GL_POINT_BIT = 0x00000002;
  public static int GL_LINE_BIT = 0x00000004;
  public static int GL_POLYGON_BIT = 0x00000008;
  public static int GL_POLYGON_STIPPLE_BIT = 0x00000010;
  public static int GL_PIXEL_MODE_BIT = 0x00000020;
  public static int GL_LIGHTING_BIT = 0x00000040;
  public static int GL_FOG_BIT = 0x00000080;
  public static int GL_ACCUM_BUFFER_BIT = 0x00000200;
  public static int GL_VIEWPORT_BIT = 0x00000800;
  public static int GL_TRANSFORM_BIT = 0x00001000;
  public static int GL_ENABLE_BIT = 0x00002000;
  public static int GL_HINT_BIT = 0x00008000;
  public static int GL_EVAL_BIT = 0x00010000;
  public static int GL_LIST_BIT = 0x00020000;
  public static int GL_TEXTURE_BIT = 0x00040000;
  public static int GL_SCISSOR_BIT = 0x00080000;
  public static int GL_ALL_ATTRIB_BITS = 0xFFFFFFFF;
  public static int GL_QUAD_STRIP = 0x0008;
  public static int GL_POLYGON = 0x0009;
  public static int GL_ACCUM = 0x0100;
  public static int GL_LOAD = 0x0101;
  public static int GL_RETURN = 0x0102;
  public static int GL_MULT = 0x0103;
  public static int GL_ADD = 0x0104;
  public static int GL_AUX0 = 0x0409;
  public static int GL_AUX1 = 0x040A;
  public static int GL_AUX2 = 0x040B;
  public static int GL_AUX3 = 0x040C;
  public static int GL_2D = 0x0600;
  public static int GL_3D = 0x0601;
  public static int GL_3D_COLOR = 0x0602;
  public static int GL_3D_COLOR_TEXTURE = 0x0603;
  public static int GL_4D_COLOR_TEXTURE = 0x0604;
  public static int GL_PASS_THROUGH_TOKEN = 0x0700;
  public static int GL_POINT_TOKEN = 0x0701;
  public static int GL_LINE_TOKEN = 0x0702;
  public static int GL_POLYGON_TOKEN = 0x0703;
  public static int GL_BITMAP_TOKEN = 0x0704;
  public static int GL_DRAW_PIXEL_TOKEN = 0x0705;
  public static int GL_COPY_PIXEL_TOKEN = 0x0706;
  public static int GL_LINE_RESET_TOKEN = 0x0707;
  public static int GL_EXP = 0x0800;
  public static int GL_EXP2 = 0x0801;
  public static int GL_COEFF = 0x0A00;
  public static int GL_ORDER = 0x0A01;
  public static int GL_DOMAIN = 0x0A02;
  public static int GL_PIXEL_MAP_I_TO_I = 0x0C70;
  public static int GL_PIXEL_MAP_S_TO_S = 0x0C71;
  public static int GL_PIXEL_MAP_I_TO_R = 0x0C72;
  public static int GL_PIXEL_MAP_I_TO_G = 0x0C73;
  public static int GL_PIXEL_MAP_I_TO_B = 0x0C74;
  public static int GL_PIXEL_MAP_I_TO_A = 0x0C75;
  public static int GL_PIXEL_MAP_R_TO_R = 0x0C76;
  public static int GL_PIXEL_MAP_G_TO_G = 0x0C77;
  public static int GL_PIXEL_MAP_B_TO_B = 0x0C78;
  public static int GL_PIXEL_MAP_A_TO_A = 0x0C79;
  public static int GL_CURRENT_COLOR = 0x0B00;
  public static int GL_CURRENT_INDEX = 0x0B01;
  public static int GL_CURRENT_NORMAL = 0x0B02;
  public static int GL_CURRENT_TEXTURE_COORDS = 0x0B03;
  public static int GL_CURRENT_RASTER_COLOR = 0x0B04;
  public static int GL_CURRENT_RASTER_INDEX = 0x0B05;
  public static int GL_CURRENT_RASTER_TEXTURE_COORDS = 0x0B06;
  public static int GL_CURRENT_RASTER_POSITION = 0x0B07;
  public static int GL_CURRENT_RASTER_POSITION_VALID = 0x0B08;
  public static int GL_CURRENT_RASTER_DISTANCE = 0x0B09;
  public static int GL_POINT_SMOOTH = 0x0B10;
  public static int GL_LINE_STIPPLE = 0x0B24;
  public static int GL_LINE_STIPPLE_PATTERN = 0x0B25;
  public static int GL_LINE_STIPPLE_REPEAT = 0x0B26;
  public static int GL_LIST_MODE = 0x0B30;
  public static int GL_MAX_LIST_NESTING = 0x0B31;
  public static int GL_LIST_BASE = 0x0B32;
  public static int GL_LIST_INDEX = 0x0B33;
  public static int GL_POLYGON_STIPPLE = 0x0B42;
  public static int GL_EDGE_FLAG = 0x0B43;
  public static int GL_LIGHTING = 0x0B50;
  public static int GL_LIGHT_MODEL_LOCAL_VIEWER = 0x0B51;
  public static int GL_LIGHT_MODEL_TWO_SIDE = 0x0B52;
  public static int GL_LIGHT_MODEL_AMBIENT = 0x0B53;
  public static int GL_SHADE_MODEL = 0x0B54;
  public static int GL_COLOR_MATERIAL_FACE = 0x0B55;
  public static int GL_COLOR_MATERIAL_PARAMETER = 0x0B56;
  public static int GL_COLOR_MATERIAL = 0x0B57;
  public static int GL_FOG = 0x0B60;
  public static int GL_FOG_INDEX = 0x0B61;
  public static int GL_FOG_DENSITY = 0x0B62;
  public static int GL_FOG_START = 0x0B63;
  public static int GL_FOG_END = 0x0B64;
  public static int GL_FOG_MODE = 0x0B65;
  public static int GL_FOG_COLOR = 0x0B66;
  public static int GL_ACCUM_CLEAR_VALUE = 0x0B80;
  public static int GL_MATRIX_MODE = 0x0BA0;
  public static int GL_NORMALIZE = 0x0BA1;
  public static int GL_MODELVIEW_STACK_DEPTH = 0x0BA3;
  public static int GL_PROJECTION_STACK_DEPTH = 0x0BA4;
  public static int GL_TEXTURE_STACK_DEPTH = 0x0BA5;
  public static int GL_MODELVIEW_MATRIX = 0x0BA6;
  public static int GL_PROJECTION_MATRIX = 0x0BA7;
  public static int GL_TEXTURE_MATRIX = 0x0BA8;
  public static int GL_ATTRIB_STACK_DEPTH = 0x0BB0;
  public static int GL_ALPHA_TEST = 0x0BC0;
  public static int GL_ALPHA_TEST_FUNC = 0x0BC1;
  public static int GL_ALPHA_TEST_REF = 0x0BC2;
  public static int GL_LOGIC_OP = 0x0BF1;
  public static int GL_AUX_BUFFERS = 0x0C00;
  public static int GL_INDEX_CLEAR_VALUE = 0x0C20;
  public static int GL_INDEX_WRITEMASK = 0x0C21;
  public static int GL_INDEX_MODE = 0x0C30;
  public static int GL_RGBA_MODE = 0x0C31;
  public static int GL_RENDER_MODE = 0x0C40;
  public static int GL_PERSPECTIVE_CORRECTION_HINT = 0x0C50;
  public static int GL_POINT_SMOOTH_HINT = 0x0C51;
  public static int GL_FOG_HINT = 0x0C54;
  public static int GL_TEXTURE_GEN_S = 0x0C60;
  public static int GL_TEXTURE_GEN_T = 0x0C61;
  public static int GL_TEXTURE_GEN_R = 0x0C62;
  public static int GL_TEXTURE_GEN_Q = 0x0C63;
  public static int GL_PIXEL_MAP_I_TO_I_SIZE = 0x0CB0;
  public static int GL_PIXEL_MAP_S_TO_S_SIZE = 0x0CB1;
  public static int GL_PIXEL_MAP_I_TO_R_SIZE = 0x0CB2;
  public static int GL_PIXEL_MAP_I_TO_G_SIZE = 0x0CB3;
  public static int GL_PIXEL_MAP_I_TO_B_SIZE = 0x0CB4;
  public static int GL_PIXEL_MAP_I_TO_A_SIZE = 0x0CB5;
  public static int GL_PIXEL_MAP_R_TO_R_SIZE = 0x0CB6;
  public static int GL_PIXEL_MAP_G_TO_G_SIZE = 0x0CB7;
  public static int GL_PIXEL_MAP_B_TO_B_SIZE = 0x0CB8;
  public static int GL_PIXEL_MAP_A_TO_A_SIZE = 0x0CB9;
  public static int GL_MAP_COLOR = 0x0D10;
  public static int GL_MAP_STENCIL = 0x0D11;
  public static int GL_INDEX_SHIFT = 0x0D12;
  public static int GL_INDEX_OFFSET = 0x0D13;
  public static int GL_RED_SCALE = 0x0D14;
  public static int GL_RED_BIAS = 0x0D15;
  public static int GL_ZOOM_X = 0x0D16;
  public static int GL_ZOOM_Y = 0x0D17;
  public static int GL_GREEN_SCALE = 0x0D18;
  public static int GL_GREEN_BIAS = 0x0D19;
  public static int GL_BLUE_SCALE = 0x0D1A;
  public static int GL_BLUE_BIAS = 0x0D1B;
  public static int GL_ALPHA_SCALE = 0x0D1C;
  public static int GL_ALPHA_BIAS = 0x0D1D;
  public static int GL_DEPTH_SCALE = 0x0D1E;
  public static int GL_DEPTH_BIAS = 0x0D1F;
  public static int GL_MAX_EVAL_ORDER = 0x0D30;
  public static int GL_MAX_LIGHTS = 0x0D31;
  public static int GL_MAX_CLIP_PLANES = 0x0D32;
  public static int GL_MAX_PIXEL_MAP_TABLE = 0x0D34;
  public static int GL_MAX_ATTRIB_STACK_DEPTH = 0x0D35;
  public static int GL_MAX_MODELVIEW_STACK_DEPTH = 0x0D36;
  public static int GL_MAX_NAME_STACK_DEPTH = 0x0D37;
  public static int GL_MAX_PROJECTION_STACK_DEPTH = 0x0D38;
  public static int GL_MAX_TEXTURE_STACK_DEPTH = 0x0D39;
  public static int GL_INDEX_BITS = 0x0D51;
  public static int GL_RED_BITS = 0x0D52;
  public static int GL_GREEN_BITS = 0x0D53;
  public static int GL_BLUE_BITS = 0x0D54;
  public static int GL_ALPHA_BITS = 0x0D55;
  public static int GL_DEPTH_BITS = 0x0D56;
  public static int GL_STENCIL_BITS = 0x0D57;
  public static int GL_ACCUM_RED_BITS = 0x0D58;
  public static int GL_ACCUM_GREEN_BITS = 0x0D59;
  public static int GL_ACCUM_BLUE_BITS = 0x0D5A;
  public static int GL_ACCUM_ALPHA_BITS = 0x0D5B;
  public static int GL_NAME_STACK_DEPTH = 0x0D70;
  public static int GL_AUTO_NORMAL = 0x0D80;
  public static int GL_MAP1_COLOR_4 = 0x0D90;
  public static int GL_MAP1_INDEX = 0x0D91;
  public static int GL_MAP1_NORMAL = 0x0D92;
  public static int GL_MAP1_TEXTURE_COORD_1 = 0x0D93;
  public static int GL_MAP1_TEXTURE_COORD_2 = 0x0D94;
  public static int GL_MAP1_TEXTURE_COORD_3 = 0x0D95;
  public static int GL_MAP1_TEXTURE_COORD_4 = 0x0D96;
  public static int GL_MAP1_VERTEX_3 = 0x0D97;
  public static int GL_MAP1_VERTEX_4 = 0x0D98;
  public static int GL_MAP2_COLOR_4 = 0x0DB0;
  public static int GL_MAP2_INDEX = 0x0DB1;
  public static int GL_MAP2_NORMAL = 0x0DB2;
  public static int GL_MAP2_TEXTURE_COORD_1 = 0x0DB3;
  public static int GL_MAP2_TEXTURE_COORD_2 = 0x0DB4;
  public static int GL_MAP2_TEXTURE_COORD_3 = 0x0DB5;
  public static int GL_MAP2_TEXTURE_COORD_4 = 0x0DB6;
  public static int GL_MAP2_VERTEX_3 = 0x0DB7;
  public static int GL_MAP2_VERTEX_4 = 0x0DB8;
  public static int GL_MAP1_GRID_DOMAIN = 0x0DD0;
  public static int GL_MAP1_GRID_SEGMENTS = 0x0DD1;
  public static int GL_MAP2_GRID_DOMAIN = 0x0DD2;
  public static int GL_MAP2_GRID_SEGMENTS = 0x0DD3;
  public static int GL_TEXTURE_COMPONENTS = 0x1003;
  public static int GL_TEXTURE_BORDER = 0x1005;
  public static int GL_AMBIENT = 0x1200;
  public static int GL_DIFFUSE = 0x1201;
  public static int GL_SPECULAR = 0x1202;
  public static int GL_POSITION = 0x1203;
  public static int GL_SPOT_DIRECTION = 0x1204;
  public static int GL_SPOT_EXPONENT = 0x1205;
  public static int GL_SPOT_CUTOFF = 0x1206;
  public static int GL_CONSTANT_ATTENUATION = 0x1207;
  public static int GL_LINEAR_ATTENUATION = 0x1208;
  public static int GL_QUADRATIC_ATTENUATION = 0x1209;
  public static int GL_COMPILE = 0x1300;
  public static int GL_COMPILE_AND_EXECUTE = 0x1301;
  public static int GL_2_BYTES = 0x1407;
  public static int GL_3_BYTES = 0x1408;
  public static int GL_4_BYTES = 0x1409;
  public static int GL_EMISSION = 0x1600;
  public static int GL_SHININESS = 0x1601;
  public static int GL_AMBIENT_AND_DIFFUSE = 0x1602;
  public static int GL_COLOR_INDEXES = 0x1603;
  public static int GL_MODELVIEW = 0x1700;
  public static int GL_PROJECTION = 0x1701;
  public static int GL_COLOR_INDEX = 0x1900;
  public static int GL_LUMINANCE = 0x1909;
  public static int GL_LUMINANCE_ALPHA = 0x190A;
  public static int GL_BITMAP = 0x1A00;
  public static int GL_RENDER = 0x1C00;
  public static int GL_FEEDBACK = 0x1C01;
  public static int GL_SELECT = 0x1C02;
  public static int GL_FLAT = 0x1D00;
  public static int GL_SMOOTH = 0x1D01;
  public static int GL_S = 0x2000;
  public static int GL_T = 0x2001;
  public static int GL_R = 0x2002;
  public static int GL_Q = 0x2003;
  public static int GL_MODULATE = 0x2100;
  public static int GL_DECAL = 0x2101;
  public static int GL_TEXTURE_ENV_MODE = 0x2200;
  public static int GL_TEXTURE_ENV_COLOR = 0x2201;
  public static int GL_TEXTURE_ENV = 0x2300;
  public static int GL_EYE_LINEAR = 0x2400;
  public static int GL_OBJECT_LINEAR = 0x2401;
  public static int GL_SPHERE_MAP = 0x2402;
  public static int GL_TEXTURE_GEN_MODE = 0x2500;
  public static int GL_OBJECT_PLANE = 0x2501;
  public static int GL_EYE_PLANE = 0x2502;
  public static int GL_CLAMP = 0x2900;
  public static int GL_CLIP_PLANE0 = 0x3000;
  public static int GL_CLIP_PLANE1 = 0x3001;
  public static int GL_CLIP_PLANE2 = 0x3002;
  public static int GL_CLIP_PLANE3 = 0x3003;
  public static int GL_CLIP_PLANE4 = 0x3004;
  public static int GL_CLIP_PLANE5 = 0x3005;
  public static int GL_LIGHT0 = 0x4000;
  public static int GL_LIGHT1 = 0x4001;
  public static int GL_LIGHT2 = 0x4002;
  public static int GL_LIGHT3 = 0x4003;
  public static int GL_LIGHT4 = 0x4004;
  public static int GL_LIGHT5 = 0x4005;
  public static int GL_LIGHT6 = 0x4006;
  public static int GL_LIGHT7 = 0x4007;
  public void glCullFace(int mode);
  public void glFrontFace(int mode);
  public void glHint(int target, int mode);
  public void glLineWidth(float width);
  public void glPointSize(float size);
  public void glPolygonMode(int face, int mode);
  public void glScissor(int x, int y, int width, int height);
  public void glTexParameterf(int target, int pname, float param);
  public void glTexParameterfv(int target, int pname, Addressable params);
  public void glTexParameteri(int target, int pname, int param);
  public void glTexParameteriv(int target, int pname, Addressable params);
  public void glTexImage1D(int target, int level, int internalformat, int width, int border, int format, int type, Addressable pixels);
  public void glTexImage2D(int target, int level, int internalformat, int width, int height, int border, int format, int type, Addressable pixels);
  public void glDrawBuffer(int buf);
  public void glClear(int mask);
  public void glClearColor(float red, float green, float blue, float alpha);
  public void glClearStencil(int s);
  public void glClearDepth(double depth);
  public void glStencilMask(int mask);
  public void glColorMask(byte red, byte green, byte blue, byte alpha);
  public void glDepthMask(byte flag);
  public void glDisable(int cap);
  public void glEnable(int cap);
  public void glFinish();
  public void glFlush();
  public void glBlendFunc(int sfactor, int dfactor);
  public void glLogicOp(int opcode);
  public void glStencilFunc(int func, int ref, int mask);
  public void glStencilOp(int fail, int zfail, int zpass);
  public void glDepthFunc(int func);
  public void glPixelStoref(int pname, float param);
  public void glPixelStorei(int pname, int param);
  public void glReadBuffer(int src);
  public void glReadPixels(int x, int y, int width, int height, int format, int type, Addressable pixels);
  public void glGetBooleanv(int pname, Addressable data);
  public void glGetDoublev(int pname, Addressable data);
  public int glGetError();
  public void glGetFloatv(int pname, Addressable data);
  public void glGetIntegerv(int pname, Addressable data);
  public String glGetString(int name);
  public void glGetTexImage(int target, int level, int format, int type, Addressable pixels);
  public void glGetTexParameterfv(int target, int pname, Addressable params);
  public void glGetTexParameteriv(int target, int pname, Addressable params);
  public void glGetTexLevelParameterfv(int target, int level, int pname, Addressable params);
  public void glGetTexLevelParameteriv(int target, int level, int pname, Addressable params);
  public byte glIsEnabled(int cap);
  public void glDepthRange(double n, double f);
  public void glViewport(int x, int y, int width, int height);
  public void glNewList(int list, int mode);
  public void glEndList();
  public void glCallList(int list);
  public void glCallLists(int n, int type, Addressable lists);
  public void glDeleteLists(int list, int range);
  public int glGenLists(int range);
  public void glListBase(int base);
  public void glBegin(int mode);
  public void glBitmap(int width, int height, float xorig, float yorig, float xmove, float ymove, Addressable bitmap);
  public void glColor3b(byte red, byte green, byte blue);
  public void glColor3bv(Addressable v);
  public void glColor3d(double red, double green, double blue);
  public void glColor3dv(Addressable v);
  public void glColor3f(float red, float green, float blue);
  public void glColor3fv(Addressable v);
  public void glColor3i(int red, int green, int blue);
  public void glColor3iv(Addressable v);
  public void glColor3s(short red, short green, short blue);
  public void glColor3sv(Addressable v);
  public void glColor3ub(byte red, byte green, byte blue);
  public void glColor3ubv(Addressable v);
  public void glColor3ui(int red, int green, int blue);
  public void glColor3uiv(Addressable v);
  public void glColor3us(short red, short green, short blue);
  public void glColor3usv(Addressable v);
  public void glColor4b(byte red, byte green, byte blue, byte alpha);
  public void glColor4bv(Addressable v);
  public void glColor4d(double red, double green, double blue, double alpha);
  public void glColor4dv(Addressable v);
  public void glColor4f(float red, float green, float blue, float alpha);
  public void glColor4fv(Addressable v);
  public void glColor4i(int red, int green, int blue, int alpha);
  public void glColor4iv(Addressable v);
  public void glColor4s(short red, short green, short blue, short alpha);
  public void glColor4sv(Addressable v);
  public void glColor4ub(byte red, byte green, byte blue, byte alpha);
  public void glColor4ubv(Addressable v);
  public void glColor4ui(int red, int green, int blue, int alpha);
  public void glColor4uiv(Addressable v);
  public void glColor4us(short red, short green, short blue, short alpha);
  public void glColor4usv(Addressable v);
  public void glEdgeFlag(byte flag);
  public void glEdgeFlagv(Addressable flag);
  public void glEnd();
  public void glIndexd(double c);
  public void glIndexdv(Addressable c);
  public void glIndexf(float c);
  public void glIndexfv(Addressable c);
  public void glIndexi(int c);
  public void glIndexiv(Addressable c);
  public void glIndexs(short c);
  public void glIndexsv(Addressable c);
  public void glNormal3b(byte nx, byte ny, byte nz);
  public void glNormal3bv(Addressable v);
  public void glNormal3d(double nx, double ny, double nz);
  public void glNormal3dv(Addressable v);
  public void glNormal3f(float nx, float ny, float nz);
  public void glNormal3fv(Addressable v);
  public void glNormal3i(int nx, int ny, int nz);
  public void glNormal3iv(Addressable v);
  public void glNormal3s(short nx, short ny, short nz);
  public void glNormal3sv(Addressable v);
  public void glRasterPos2d(double x, double y);
  public void glRasterPos2dv(Addressable v);
  public void glRasterPos2f(float x, float y);
  public void glRasterPos2fv(Addressable v);
  public void glRasterPos2i(int x, int y);
  public void glRasterPos2iv(Addressable v);
  public void glRasterPos2s(short x, short y);
  public void glRasterPos2sv(Addressable v);
  public void glRasterPos3d(double x, double y, double z);
  public void glRasterPos3dv(Addressable v);
  public void glRasterPos3f(float x, float y, float z);
  public void glRasterPos3fv(Addressable v);
  public void glRasterPos3i(int x, int y, int z);
  public void glRasterPos3iv(Addressable v);
  public void glRasterPos3s(short x, short y, short z);
  public void glRasterPos3sv(Addressable v);
  public void glRasterPos4d(double x, double y, double z, double w);
  public void glRasterPos4dv(Addressable v);
  public void glRasterPos4f(float x, float y, float z, float w);
  public void glRasterPos4fv(Addressable v);
  public void glRasterPos4i(int x, int y, int z, int w);
  public void glRasterPos4iv(Addressable v);
  public void glRasterPos4s(short x, short y, short z, short w);
  public void glRasterPos4sv(Addressable v);
  public void glRectd(double x1, double y1, double x2, double y2);
  public void glRectdv(Addressable v1, Addressable v2);
  public void glRectf(float x1, float y1, float x2, float y2);
  public void glRectfv(Addressable v1, Addressable v2);
  public void glRecti(int x1, int y1, int x2, int y2);
  public void glRectiv(Addressable v1, Addressable v2);
  public void glRects(short x1, short y1, short x2, short y2);
  public void glRectsv(Addressable v1, Addressable v2);
  public void glTexCoord1d(double s);
  public void glTexCoord1dv(Addressable v);
  public void glTexCoord1f(float s);
  public void glTexCoord1fv(Addressable v);
  public void glTexCoord1i(int s);
  public void glTexCoord1iv(Addressable v);
  public void glTexCoord1s(short s);
  public void glTexCoord1sv(Addressable v);
  public void glTexCoord2d(double s, double t);
  public void glTexCoord2dv(Addressable v);
  public void glTexCoord2f(float s, float t);
  public void glTexCoord2fv(Addressable v);
  public void glTexCoord2i(int s, int t);
  public void glTexCoord2iv(Addressable v);
  public void glTexCoord2s(short s, short t);
  public void glTexCoord2sv(Addressable v);
  public void glTexCoord3d(double s, double t, double r);
  public void glTexCoord3dv(Addressable v);
  public void glTexCoord3f(float s, float t, float r);
  public void glTexCoord3fv(Addressable v);
  public void glTexCoord3i(int s, int t, int r);
  public void glTexCoord3iv(Addressable v);
  public void glTexCoord3s(short s, short t, short r);
  public void glTexCoord3sv(Addressable v);
  public void glTexCoord4d(double s, double t, double r, double q);
  public void glTexCoord4dv(Addressable v);
  public void glTexCoord4f(float s, float t, float r, float q);
  public void glTexCoord4fv(Addressable v);
  public void glTexCoord4i(int s, int t, int r, int q);
  public void glTexCoord4iv(Addressable v);
  public void glTexCoord4s(short s, short t, short r, short q);
  public void glTexCoord4sv(Addressable v);
  public void glVertex2d(double x, double y);
  public void glVertex2dv(Addressable v);
  public void glVertex2f(float x, float y);
  public void glVertex2fv(Addressable v);
  public void glVertex2i(int x, int y);
  public void glVertex2iv(Addressable v);
  public void glVertex2s(short x, short y);
  public void glVertex2sv(Addressable v);
  public void glVertex3d(double x, double y, double z);
  public void glVertex3dv(Addressable v);
  public void glVertex3f(float x, float y, float z);
  public void glVertex3fv(Addressable v);
  public void glVertex3i(int x, int y, int z);
  public void glVertex3iv(Addressable v);
  public void glVertex3s(short x, short y, short z);
  public void glVertex3sv(Addressable v);
  public void glVertex4d(double x, double y, double z, double w);
  public void glVertex4dv(Addressable v);
  public void glVertex4f(float x, float y, float z, float w);
  public void glVertex4fv(Addressable v);
  public void glVertex4i(int x, int y, int z, int w);
  public void glVertex4iv(Addressable v);
  public void glVertex4s(short x, short y, short z, short w);
  public void glVertex4sv(Addressable v);
  public void glClipPlane(int plane, Addressable equation);
  public void glColorMaterial(int face, int mode);
  public void glFogf(int pname, float param);
  public void glFogfv(int pname, Addressable params);
  public void glFogi(int pname, int param);
  public void glFogiv(int pname, Addressable params);
  public void glLightf(int light, int pname, float param);
  public void glLightfv(int light, int pname, Addressable params);
  public void glLighti(int light, int pname, int param);
  public void glLightiv(int light, int pname, Addressable params);
  public void glLightModelf(int pname, float param);
  public void glLightModelfv(int pname, Addressable params);
  public void glLightModeli(int pname, int param);
  public void glLightModeliv(int pname, Addressable params);
  public void glLineStipple(int factor, short pattern);
  public void glMaterialf(int face, int pname, float param);
  public void glMaterialfv(int face, int pname, Addressable params);
  public void glMateriali(int face, int pname, int param);
  public void glMaterialiv(int face, int pname, Addressable params);
  public void glPolygonStipple(Addressable mask);
  public void glShadeModel(int mode);
  public void glTexEnvf(int target, int pname, float param);
  public void glTexEnvfv(int target, int pname, Addressable params);
  public void glTexEnvi(int target, int pname, int param);
  public void glTexEnviv(int target, int pname, Addressable params);
  public void glTexGend(int coord, int pname, double param);
  public void glTexGendv(int coord, int pname, Addressable params);
  public void glTexGenf(int coord, int pname, float param);
  public void glTexGenfv(int coord, int pname, Addressable params);
  public void glTexGeni(int coord, int pname, int param);
  public void glTexGeniv(int coord, int pname, Addressable params);
  public void glFeedbackBuffer(int size, int type, Addressable buffer);
  public void glSelectBuffer(int size, Addressable buffer);
  public int glRenderMode(int mode);
  public void glInitNames();
  public void glLoadName(int name);
  public void glPassThrough(float token);
  public void glPopName();
  public void glPushName(int name);
  public void glClearAccum(float red, float green, float blue, float alpha);
  public void glClearIndex(float c);
  public void glIndexMask(int mask);
  public void glAccum(int op, float value);
  public void glPopAttrib();
  public void glPushAttrib(int mask);
  public void glMap1d(int target, double u1, double u2, int stride, int order, Addressable points);
  public void glMap1f(int target, float u1, float u2, int stride, int order, Addressable points);
  public void glMap2d(int target, double u1, double u2, int ustride, int uorder, double v1, double v2, int vstride, int vorder, Addressable points);
  public void glMap2f(int target, float u1, float u2, int ustride, int uorder, float v1, float v2, int vstride, int vorder, Addressable points);
  public void glMapGrid1d(int un, double u1, double u2);
  public void glMapGrid1f(int un, float u1, float u2);
  public void glMapGrid2d(int un, double u1, double u2, int vn, double v1, double v2);
  public void glMapGrid2f(int un, float u1, float u2, int vn, float v1, float v2);
  public void glEvalCoord1d(double u);
  public void glEvalCoord1dv(Addressable u);
  public void glEvalCoord1f(float u);
  public void glEvalCoord1fv(Addressable u);
  public void glEvalCoord2d(double u, double v);
  public void glEvalCoord2dv(Addressable u);
  public void glEvalCoord2f(float u, float v);
  public void glEvalCoord2fv(Addressable u);
  public void glEvalMesh1(int mode, int i1, int i2);
  public void glEvalPoint1(int i);
  public void glEvalMesh2(int mode, int i1, int i2, int j1, int j2);
  public void glEvalPoint2(int i, int j);
  public void glAlphaFunc(int func, float ref);
  public void glPixelZoom(float xfactor, float yfactor);
  public void glPixelTransferf(int pname, float param);
  public void glPixelTransferi(int pname, int param);
  public void glPixelMapfv(int map, int mapsize, Addressable values);
  public void glPixelMapuiv(int map, int mapsize, Addressable values);
  public void glPixelMapusv(int map, int mapsize, Addressable values);
  public void glCopyPixels(int x, int y, int width, int height, int type);
  public void glDrawPixels(int width, int height, int format, int type, Addressable pixels);
  public void glGetClipPlane(int plane, Addressable equation);
  public void glGetLightfv(int light, int pname, Addressable params);
  public void glGetLightiv(int light, int pname, Addressable params);
  public void glGetMapdv(int target, int query, Addressable v);
  public void glGetMapfv(int target, int query, Addressable v);
  public void glGetMapiv(int target, int query, Addressable v);
  public void glGetMaterialfv(int face, int pname, Addressable params);
  public void glGetMaterialiv(int face, int pname, Addressable params);
  public void glGetPixelMapfv(int map, Addressable values);
  public void glGetPixelMapuiv(int map, Addressable values);
  public void glGetPixelMapusv(int map, Addressable values);
  public void glGetPolygonStipple(Addressable mask);
  public void glGetTexEnvfv(int target, int pname, Addressable params);
  public void glGetTexEnviv(int target, int pname, Addressable params);
  public void glGetTexGendv(int coord, int pname, Addressable params);
  public void glGetTexGenfv(int coord, int pname, Addressable params);
  public void glGetTexGeniv(int coord, int pname, Addressable params);
  public byte glIsList(int list);
  public void glFrustum(double left, double right, double bottom, double top, double zNear, double zFar);
  public void glLoadIdentity();
  public void glLoadMatrixf(Addressable m);
  public void glLoadMatrixd(Addressable m);
  public void glMatrixMode(int mode);
  public void glMultMatrixf(Addressable m);
  public void glMultMatrixd(Addressable m);
  public void glOrtho(double left, double right, double bottom, double top, double zNear, double zFar);
  public void glPopMatrix();
  public void glPushMatrix();
  public void glRotated(double angle, double x, double y, double z);
  public void glRotatef(float angle, float x, float y, float z);
  public void glScaled(double x, double y, double z);
  public void glScalef(float x, float y, float z);
  public void glTranslated(double x, double y, double z);
  public void glTranslatef(float x, float y, float z);
}
