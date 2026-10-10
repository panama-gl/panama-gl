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

import static org.mockito.Mockito.CALLS_REAL_METHODS;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.withSettings;
import java.lang.foreign.Arena;
import java.lang.foreign.FunctionDescriptor;
import java.lang.foreign.Linker;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/**
 * Check the resolution of functions through a {@link GLFunctionLoader}, using the C function
 * <code>strlen</code> as a stand-in for an OpenGL function, so that no GL context is required.
 */
public class TestAGL_FunctionLoader {
  static final FunctionDescriptor STRLEN =
      FunctionDescriptor.of(ValueLayout.JAVA_LONG, ValueLayout.ADDRESS);

  /** A loader resolving the C library, recording the resolved functions. */
  static class RecordingLoader implements GLFunctionLoader {
    List<String> resolved = new ArrayList<>();

    @Override
    public MemorySegment getProcAddress(String function) {
      resolved.add(function);
      return Linker.nativeLinker().defaultLookup().find(function).orElse(MemorySegment.NULL);
    }
  }

  AGL newGL() {
    return mock(AGL.class, withSettings().useConstructor().defaultAnswer(CALLS_REAL_METHODS));
  }

  @Test
  public void withoutLoader_FunctionsAreNotAvailable() {
    AGL gl = newGL();

    Assert.assertEquals(MemorySegment.NULL, gl.getProcAddress("strlen"));
    Assert.assertFalse(gl.isFunctionAvailable("strlen"));
  }

  @Test
  public void functionIsResolvedOnce() throws Throwable {
    AGL gl = newGL();
    RecordingLoader loader = new RecordingLoader();
    gl.setFunctionLoader(loader);

    MemorySegment address = gl.address("strlen");
    Assert.assertEquals(address, gl.address("strlen"));

    // Resolved at the first invocation only
    Assert.assertEquals(List.of("strlen"), loader.resolved);

    // Available from the cache without resolving again
    Assert.assertTrue(gl.isFunctionAvailable("strlen"));
    Assert.assertEquals(List.of("strlen"), loader.resolved);

    // The address is the one of the function
    try (Arena arena = Arena.ofConfined()) {
      MemorySegment text = arena.allocateFrom("panama");
      Assert.assertEquals(6L,
          (long) Linker.nativeLinker().downcallHandle(address, STRLEN).invokeExact(text));
    }
  }

  @Test
  public void unresolvedFunctionThrowsAnExceptionNamingIt() {
    AGL gl = newGL();
    gl.setFunctionLoader(new RecordingLoader());

    Assert.assertFalse(gl.isFunctionAvailable("glNotAnOpenGLFunction"));

    try {
      gl.address("glNotAnOpenGLFunction");
      Assert.fail("expect an exception");
    } catch (UnsupportedOperationException e) {
      Assert.assertTrue(e.getMessage(), e.getMessage().contains("glNotAnOpenGLFunction"));
    }
  }

  @Test
  public void loaderReturningNullResolvesNothing() {
    AGL gl = newGL();
    gl.setFunctionLoader(function -> null);

    Assert.assertFalse(gl.isFunctionAvailable("strlen"));

    try {
      gl.address("strlen");
      Assert.fail("expect an exception");
    } catch (UnsupportedOperationException e) {
      Assert.assertTrue(e.getMessage(), e.getMessage().contains("strlen"));
    }
  }

  @Test
  public void changingLoaderClearsResolvedFunctions() {
    AGL gl = newGL();
    gl.setFunctionLoader(new RecordingLoader());
    gl.address("strlen");

    RecordingLoader other = new RecordingLoader();
    gl.setFunctionLoader(other);
    gl.address("strlen");

    Assert.assertSame(other, gl.getFunctionLoader());
    Assert.assertEquals(List.of("strlen"), other.resolved);
  }

  @Test
  public void stringReadsCStrings() {
    AGL gl = newGL();

    Assert.assertNull(gl.string(null));
    Assert.assertNull(gl.string(MemorySegment.NULL));

    try (Arena arena = Arena.ofConfined()) {
      MemorySegment string = arena.allocateFrom("4.6 Mesa");
      // a native function returns a zero length segment
      Assert.assertEquals("4.6 Mesa", gl.string(MemorySegment.ofAddress(string.address())));
    }
  }
}
