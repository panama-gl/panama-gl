/*******************************************************************************
 * Copyright (c) 2022, 2023 Martin Pernollet & contributors.
 *
 * This library is free software; you can redistribute it and/or modify it under the terms of the
 * GNU Lesser General Public License as published by the Free Software Foundation; either version
 * 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License along with this library;
 * if not, write to the Free Software Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA
 * 02110-1301, USA
 *******************************************************************************/
package panamagl.opengl;

import java.lang.foreign.MemoryAddress;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.MemorySession;
import java.lang.foreign.SegmentAllocator;
import java.lang.foreign.ValueLayout;


/**
 * A base abstract class for Panama based OpenGL binding, implementing part of {@link GL}.
 * 
 * Mainly provides helpers for the Panama API, hiding the API that will change in future Java
 * version.
 * 
 * Also provides methods with base Java types instead of the usual {@link MemorySegment} and
 * {@link MemoryAddress} used in JExtract generated bindings.
 * 
 * @author Martin Pernollet
 */
public abstract class AGL implements GL {
  protected MemorySession scope;
  protected SegmentAllocator allocator;

  public AGL() {
    try {
      scope = MemorySession.openImplicit();
      allocator = SegmentAllocator.newNativeArena(scope);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public MemorySession getScope() {
    return scope;
  }

  public SegmentAllocator getAllocator() {
    return allocator;
  }

  public MemorySegment alloc(String value) {
    return allocator.allocateUtf8String(value);
  }

  public MemorySegment alloc(double[] value) {
    return allocator.allocateArray(ValueLayout.JAVA_DOUBLE, value);
  }

  public MemorySegment alloc(float[] value) {
    return allocator.allocateArray(ValueLayout.JAVA_FLOAT, value);
  }

  public MemorySegment alloc(int[] value) {
    return allocator.allocateArray(ValueLayout.JAVA_INT, value);
  }

  public MemorySegment allocDouble(int length) {
    return allocator.allocateArray(ValueLayout.JAVA_DOUBLE, length);
  }

  public MemorySegment allocDouble(float[] value) {
    MemorySegment s = allocator.allocateArray(ValueLayout.JAVA_DOUBLE, value.length);

    for (int i = 0; i < value.length; i++) {
      s.setAtIndex(ValueLayout.JAVA_DOUBLE, i, (double) value[i]);
    }

    return s;
  }

  public MemorySegment allocFloat(int length) {
    return allocator.allocateArray(ValueLayout.JAVA_FLOAT, length);
  }

  public MemorySegment allocInt(int length) {
    return allocator.allocateArray(ValueLayout.JAVA_INT, length);
  }

  public MemorySegment allocFloat(double[] value) {
    MemorySegment s = allocator.allocateArray(ValueLayout.JAVA_FLOAT, value.length);

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

  /**
   * A float-based gluProject
   */
  public boolean gluProject(float objX, float objY, float objZ, float[] model, float[] proj,
      int[] view, float[] winPos) {

    MemorySegment winX = allocDouble(1);
    MemorySegment winY = allocDouble(1);
    MemorySegment winZ = allocDouble(1);

    MemorySegment sm = allocDouble(model);
    MemorySegment sp = allocDouble(proj);
    MemorySegment sv = alloc(view);

    int out = gluProject((double) objX, (double) objY, (double) objZ, sm, sp, sv, winX, winY, winZ);

    winPos[0] = (float) winX.get(ValueLayout.JAVA_DOUBLE, 0);
    winPos[1] = (float) winY.get(ValueLayout.JAVA_DOUBLE, 0);
    winPos[2] = (float) winZ.get(ValueLayout.JAVA_DOUBLE, 0);

    return out == 1;
  }

  /**
   * A float-based gluUnProject
   */
  public boolean gluUnProject(float winX, float winY, float winZ, float[] model, float[] proj,
      int[] view, float[] objPos) {

    MemorySegment objX = allocDouble(1);
    MemorySegment objY = allocDouble(1);
    MemorySegment objZ = allocDouble(1);

    MemorySegment sm = allocDouble(model);
    MemorySegment sp = allocDouble(proj);
    MemorySegment sv = alloc(view);

    int out =
        gluUnProject((double) winX, (double) winY, (double) winZ, sm, sp, sv, objX, objY, objZ);

    objPos[0] = (float) objX.get(ValueLayout.JAVA_DOUBLE, 0);
    objPos[1] = (float) objY.get(ValueLayout.JAVA_DOUBLE, 0);
    objPos[2] = (float) objZ.get(ValueLayout.JAVA_DOUBLE, 0);

    return out == 1;
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
