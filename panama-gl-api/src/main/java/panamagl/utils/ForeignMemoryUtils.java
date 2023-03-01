package panamagl.utils;

import java.lang.foreign.MemorySegment;
import java.lang.foreign.MemorySession;
import java.lang.foreign.SegmentAllocator;
import java.lang.foreign.ValueLayout;

public class ForeignMemoryUtils {
  protected MemorySession scope;
  protected SegmentAllocator allocator;

  public ForeignMemoryUtils() {
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
