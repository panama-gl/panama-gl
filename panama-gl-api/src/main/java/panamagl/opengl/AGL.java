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

import java.lang.foreign.MemorySegment;
import java.lang.foreign.MemorySession;
import java.lang.foreign.SegmentAllocator;
import java.lang.foreign.ValueLayout;


/**
 * A base abstract class for Panama based OpenGL binding, implementing part of {@link GL}
 * 
 * @author Martin Pernollet
 */
public abstract class AGL implements GL {
  protected MemorySession scope;
  protected SegmentAllocator allocator;
  //protected MemorySession scopeConfined;
  //protected SegmentAllocator allocatorConfined;

  public AGL() {
    try {
      scope = MemorySession.openImplicit(); 
      allocator = SegmentAllocator.newNativeArena(scope);
      
      //scopeConfined = MemorySession.openConfined();
      //allocatorConfined = SegmentAllocator.newNativeArena(scopeConfined);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /////////////////////////////////////////////

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
  public boolean gluProject(float objX, float objY, float objZ, float[] model, int model_offset,
      float[] proj, int proj_offset, int[] view, int view_offset, float[] winPos,
      int winPos_offset) {
    
    MemorySegment winX = alloc(new double[1]);
    MemorySegment winY = alloc(new double[1]);
    MemorySegment winZ = alloc(new double[1]);

    MemorySegment sm = alloc(dbl(model));
    MemorySegment sp = alloc(dbl(proj));    
    MemorySegment sv = alloc(dbl(view));
    
    int out = gluProject((double)objX, (double)objY, (double)objZ, sm, sp, sv, winX, winY, winZ);

    winPos[0] = (float)winX.get(ValueLayout.JAVA_DOUBLE, 0);
    winPos[1] = (float)winY.get(ValueLayout.JAVA_DOUBLE, 0);
    winPos[2] = (float)winZ.get(ValueLayout.JAVA_DOUBLE, 0);

    return out == 1;
  }
  
  /**
   * A float-based gluUnProject
   */
  public boolean gluUnProject(float winX, float winY, float winZ, float[] model, int model_offset, float[] proj,
      int proj_offset, int[] view, int view_offset, float[] objPos, int objPos_offset) {

    MemorySegment objX = alloc(new double[1]);
    MemorySegment objY = alloc(new double[1]);
    MemorySegment objZ = alloc(new double[1]);

    MemorySegment sm = alloc(dbl(model));
    MemorySegment sp = alloc(dbl(proj));
    MemorySegment sv = alloc(dbl(view));

    int out = gluUnProject((double)winX, (double)winY, (double)winZ, sm, sp, sv, objX, objY, objZ);

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
