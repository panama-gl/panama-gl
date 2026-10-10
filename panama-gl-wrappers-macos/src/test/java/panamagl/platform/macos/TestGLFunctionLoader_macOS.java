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
package panamagl.platform.macos;

import java.lang.foreign.MemorySegment;
import org.junit.Assert;
import org.junit.Test;
import opengl.macos.NativeLibLoader;

/**
 * Check that OpenGL functions missing from the static bindings are resolved in the OpenGL framework
 * loaded by {@link NativeLibLoader}.
 */
// VM ARGS : --enable-native-access=ALL-UNNAMED
public class TestGLFunctionLoader_macOS extends MacOSTest {

  @Test
  public void resolveFunctionOfLoadedFramework() {
    if (!checkPlatform())
      return;

    NativeLibLoader.load();

    GLFunctionLoader_macOS loader = new GLFunctionLoader_macOS();

    // GL 3.0 function exported by the OpenGL framework but missing from the static bindings
    Assert.assertNotEquals(MemorySegment.NULL, loader.getProcAddress("glBindFragDataLocation"));
  }

  @Test
  public void unknownFunctionIsNotResolved() {
    if (!checkPlatform())
      return;

    NativeLibLoader.load();

    GLFunctionLoader_macOS loader = new GLFunctionLoader_macOS();

    Assert.assertEquals(MemorySegment.NULL, loader.getProcAddress("glNotAnOpenGLFunction"));
  }
}
