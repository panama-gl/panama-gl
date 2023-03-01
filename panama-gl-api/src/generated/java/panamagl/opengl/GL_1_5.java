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

public interface GL_1_5 extends GL_1_4 {
  public static final int GL_BUFFER_SIZE = 0x8764;
  public static final int GL_BUFFER_USAGE = 0x8765;
  public static final int GL_QUERY_COUNTER_BITS = 0x8864;
  public static final int GL_CURRENT_QUERY = 0x8865;
  public static final int GL_QUERY_RESULT = 0x8866;
  public static final int GL_QUERY_RESULT_AVAILABLE = 0x8867;
  public static final int GL_ARRAY_BUFFER = 0x8892;
  public static final int GL_ELEMENT_ARRAY_BUFFER = 0x8893;
  public static final int GL_ARRAY_BUFFER_BINDING = 0x8894;
  public static final int GL_ELEMENT_ARRAY_BUFFER_BINDING = 0x8895;
  public static final int GL_VERTEX_ATTRIB_ARRAY_BUFFER_BINDING = 0x889F;
  public static final int GL_READ_ONLY = 0x88B8;
  public static final int GL_WRITE_ONLY = 0x88B9;
  public static final int GL_READ_WRITE = 0x88BA;
  public static final int GL_BUFFER_ACCESS = 0x88BB;
  public static final int GL_BUFFER_MAPPED = 0x88BC;
  public static final int GL_BUFFER_MAP_POINTER = 0x88BD;
  public static final int GL_STREAM_DRAW = 0x88E0;
  public static final int GL_STREAM_READ = 0x88E1;
  public static final int GL_STREAM_COPY = 0x88E2;
  public static final int GL_STATIC_DRAW = 0x88E4;
  public static final int GL_STATIC_READ = 0x88E5;
  public static final int GL_STATIC_COPY = 0x88E6;
  public static final int GL_DYNAMIC_DRAW = 0x88E8;
  public static final int GL_DYNAMIC_READ = 0x88E9;
  public static final int GL_DYNAMIC_COPY = 0x88EA;
  public static final int GL_SAMPLES_PASSED = 0x8914;
  public static final int GL_SRC1_ALPHA = 0x8589;
  public static final int GL_VERTEX_ARRAY_BUFFER_BINDING = 0x8896;
  public static final int GL_NORMAL_ARRAY_BUFFER_BINDING = 0x8897;
  public static final int GL_COLOR_ARRAY_BUFFER_BINDING = 0x8898;
  public static final int GL_INDEX_ARRAY_BUFFER_BINDING = 0x8899;
  public static final int GL_TEXTURE_COORD_ARRAY_BUFFER_BINDING = 0x889A;
  public static final int GL_EDGE_FLAG_ARRAY_BUFFER_BINDING = 0x889B;
  public static final int GL_SECONDARY_COLOR_ARRAY_BUFFER_BINDING = 0x889C;
  public static final int GL_FOG_COORDINATE_ARRAY_BUFFER_BINDING = 0x889D;
  public static final int GL_WEIGHT_ARRAY_BUFFER_BINDING = 0x889E;
  public static final int GL_FOG_COORD_SRC = 0x8450;
  public static final int GL_FOG_COORD = 0x8451;
  public static final int GL_CURRENT_FOG_COORD = 0x8453;
  public static final int GL_FOG_COORD_ARRAY_TYPE = 0x8454;
  public static final int GL_FOG_COORD_ARRAY_STRIDE = 0x8455;
  public static final int GL_FOG_COORD_ARRAY_POINTER = 0x8456;
  public static final int GL_FOG_COORD_ARRAY = 0x8457;
  public static final int GL_FOG_COORD_ARRAY_BUFFER_BINDING = 0x889D;
  public static final int GL_SRC0_RGB = 0x8580;
  public static final int GL_SRC1_RGB = 0x8581;
  public static final int GL_SRC2_RGB = 0x8582;
  public static final int GL_SRC0_ALPHA = 0x8588;
  public static final int GL_SRC2_ALPHA = 0x858A;
  public void glGenQueries(int n, Addressable ids);
  public void glDeleteQueries(int n, Addressable ids);
  public byte glIsQuery(int id);
  public void glBeginQuery(int target, int id);
  public void glEndQuery(int target);
  public void glGetQueryiv(int target, int pname, Addressable params);
  public void glGetQueryObjectiv(int id, int pname, Addressable params);
  public void glGetQueryObjectuiv(int id, int pname, Addressable params);
  public void glBindBuffer(int target, int buffer);
  public void glDeleteBuffers(int n, Addressable buffers);
  public void glGenBuffers(int n, Addressable buffers);
  public byte glIsBuffer(int buffer);
  public void glBufferData(int target, long size, Addressable data, int usage);
  public void glBufferSubData(int target, long offset, long size, Addressable data);
  public void glGetBufferSubData(int target, long offset, long size, Addressable data);
  public MemoryAddress glMapBuffer(int target, int access);
  public byte glUnmapBuffer(int target);
  public void glGetBufferParameteriv(int target, int pname, Addressable params);
  public void glGetBufferPointerv(int target, int pname, Addressable params);
}
