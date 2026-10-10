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

import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import panamagl.utils.ForeignMemoryUtils;


/**
 * A base abstract class for Panama based OpenGL binding, implementing part of {@link GL}.
 * 
 * Mainly provides helpers for the PanamaGL API by using {@link ForeignMemoryUtils}.
 * 
 * Also provides methods with base Java types instead of the usual {@link MemorySegment} 
 * used in JExtract generated bindings.
 * 
 * @author Martin Pernollet
 */
public abstract class AGL extends ForeignMemoryUtils implements GL {

  /** Resolve functions that are not exported as static symbols by the system GL library. */
  protected GLFunctionLoader functionLoader;

  /** Addresses of the functions resolved by the {@link #functionLoader}. */
  protected Map<String, MemorySegment> addresses = new ConcurrentHashMap<>();

  public GLFunctionLoader getFunctionLoader() {
    return functionLoader;
  }

  public void setFunctionLoader(GLFunctionLoader functionLoader) {
    this.functionLoader = functionLoader;
    this.addresses.clear();
  }

  /**
   * Return the address of an OpenGL function that is resolved at runtime by the
   * {@link GLFunctionLoader}, which is how OpenGL functions beyond the static exports of the system
   * library (VBO, shaders, FBO, ...) are reached. The function is then invoked through the
   * <code>PFN...PROC</code> class of the binding, as <code>FBO_linux</code> or
   * <code>FBO_windows</code> do.
   * 
   * The function is resolved at its first invocation and then cached. Some platforms (Windows)
   * require a current GL context to resolve a function.
   * 
   * @param function the OpenGL function name, e.g. "glGenBuffers"
   * @throws UnsupportedOperationException if the function can not be resolved
   */
  protected MemorySegment address(String function) {
    MemorySegment address = addresses.get(function);

    if (address == null) {
      address = getProcAddress(function);

      if (address == null || MemorySegment.NULL.equals(address)) {
        throw new UnsupportedOperationException("OpenGL function '" + function
            + "' is not available : the driver does not provide it, or no GL context is current");
      }
      addresses.put(function, address);
    }
    return address;
  }

  /**
   * Return the address of a function using the {@link #functionLoader}, or
   * {@link MemorySegment#NULL} if there is no loader or the function is unknown.
   */
  public MemorySegment getProcAddress(String function) {
    if (functionLoader == null) {
      return MemorySegment.NULL;
    }
    return functionLoader.getProcAddress(function);
  }

  /**
   * Return true if the given OpenGL function can be resolved by the {@link #functionLoader}.
   */
  public boolean isFunctionAvailable(String function) {
    if (addresses.containsKey(function)) {
      return true;
    }
    MemorySegment address = getProcAddress(function);
    return address != null && !MemorySegment.NULL.equals(address);
  }

  /** Read a C string returned by a function resolved at runtime. */
  protected String string(MemorySegment string) {
    if (string == null || MemorySegment.NULL.equals(string)) {
      return null;
    }
    return string.reinterpret(Long.MAX_VALUE).getString(0);
  }

  /** A float-based gluProject */
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

  /** A float-based gluUnProject */
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

  // TODO : generate me
  public void glGetIntegerv(int pname, int[] data) {
    MemorySegment segment = allocator.allocate(ValueLayout.JAVA_INT, data.length);
    glGetIntegerv(pname, segment);
    copySegmentToArray(segment, data);
  }

  // TODO : generate me
  public void glGetDoublev(int pname, double[] params) {
    MemorySegment segment = allocator.allocate(ValueLayout.JAVA_DOUBLE, params.length);
    glGetDoublev(pname, segment);
    copySegmentToArray(segment, params);
  }

  // TODO : generate me
  public void glGetFloatv(int pname, float[] data) {
    MemorySegment segment = allocator.allocate(ValueLayout.JAVA_FLOAT, data.length);
    glGetFloatv(pname, segment);
    copySegmentToArray(segment, data);
  }
}
