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
package panamagl.utils;

import java.lang.foreign.MemorySegment;
import java.lang.foreign.Arena;
import java.lang.foreign.ValueLayout;

public class ForeignMemoryUtils {
  protected Arena allocator;
  
  public ForeignMemoryUtils() {
    allocator = Arena.ofAuto();
  }

  public MemorySegment alloc(String value) {
    return allocator.allocateFrom(value);
  }

  public MemorySegment alloc(double[] value) {
    return allocator.allocateFrom(ValueLayout.JAVA_DOUBLE, value);
  }

  public MemorySegment alloc(float[] value) {
    return allocator.allocateFrom(ValueLayout.JAVA_FLOAT, value);
  }

  public MemorySegment alloc(int[] value) {
    return allocator.allocateFrom(ValueLayout.JAVA_INT, value);
  }

  public MemorySegment allocDouble(int length) {
    return allocator.allocate(ValueLayout.JAVA_DOUBLE, length);
  }

  public MemorySegment allocDouble(float[] value) {
    MemorySegment s = allocator.allocate(ValueLayout.JAVA_DOUBLE, value.length);

    for (int i = 0; i < value.length; i++) {
      s.setAtIndex(ValueLayout.JAVA_DOUBLE, i, (double) value[i]);
    }

    return s;
  }

  public MemorySegment allocFloat(int length) {
    return allocator.allocate(ValueLayout.JAVA_FLOAT, length);
  }

  public MemorySegment allocInt(int length) {
    return allocator.allocate(ValueLayout.JAVA_INT, length);
  }

  public MemorySegment allocFloat(double[] value) {
    MemorySegment s = allocator.allocate(ValueLayout.JAVA_FLOAT, value.length);

    for (int i = 0; i < value.length; i++) {
      s.setAtIndex(ValueLayout.JAVA_FLOAT, i, (float) value[i]);
    }

    return s;
  }

  public int[] toInt(MemorySegment value) {
    return value.toArray(ValueLayout.JAVA_INT);
  }

  public float[] toFloat(MemorySegment value) {
    return value.toArray(ValueLayout.JAVA_FLOAT);
  }

  public double[] toDouble(MemorySegment value) {
    return value.toArray(ValueLayout.JAVA_DOUBLE);
  }

  public void copySegmentToArray(MemorySegment segment, int[] data) {
    for (int i = 0; i < data.length; i++) {
      data[i] = segment.getAtIndex(ValueLayout.JAVA_INT, i);
    }
  }

  public void copySegmentToArray(MemorySegment segment, float[] data) {
    for (int i = 0; i < data.length; i++) {
      data[i] = segment.getAtIndex(ValueLayout.JAVA_FLOAT, i);
    }
  }

  public void copySegmentToArray(MemorySegment segment, double[] data) {
    for (int i = 0; i < data.length; i++) {
      data[i] = segment.getAtIndex(ValueLayout.JAVA_DOUBLE, i);
    }
  }

  protected double[] dbl(float[] values) {
    double[] dbl = new double[values.length];
    for (int i = 0; i < values.length; i++) {
      dbl[i] = values[i];
    }
    return dbl;
  }

  protected double[] dbl(int[] values) {
    double[] dbl = new double[values.length];
    for (int i = 0; i < values.length; i++) {
      dbl[i] = values[i];
    }
    return dbl;
  }

}
