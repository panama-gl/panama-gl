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
package panamagl.platform.windows;

import org.junit.Assert;
import org.junit.Assume;
import org.junit.Test;
import panamagl.opengl.GL;

/**
 * Check that freeglut is optional : rendering with a WGL context does not open freeglut.dll, which
 * is only loaded and initialized at the first GLUT call.
 *
 * On CI, where freeglut is not installed, check that it is loaded from the freeglut.dll of the
 * optional panama-gl-bindings-windows-freeglut jar, so that CI always tests the DLL of this jar.
 * {@link TestGLUT_windows_withoutFreeglut} checks what happens when freeglut is missing.
 *
 * Each test class runs in its own JVM on Windows (see the Windows profile of the root pom.xml),
 * hence freeglut can not have been loaded by another test before.
 */
public class TestGLUT_windows extends WindowsTest {

  @Test
  public void freeglutIsOnlyOpenedAtTheFirstGLUTCall() {
    if (!checkPlatform())
      return;

    Assume.assumeFalse("GLUT already initialized in this JVM", GLUT_windows.isInitialized());

    WGLContext_windows context = new WGLContext_windows();
    context.init();
    context.makeCurrent();

    try {
      GL gl = new GL_windows();

      // When rendering without GLUT
      gl.glClearColor(1f, 1f, 1f, 1f);
      gl.glClear(GL.GL_COLOR_BUFFER_BIT);
      gl.glFinish();

      // Then freeglut.dll is not opened
      Assert.assertFalse(GLUT_windows.isInitialized());
      Assert.assertFalse(NativeLibLoader_windows.isGLUTLoaded());
      Assert.assertFalse("freeglut.dll is not opened", isModuleLoaded("freeglut.dll"));

      // When invoking a GLUT function
      gl.glutSolidTeapot(0.5);

      // Then freeglut.dll is opened and initialized
      Assert.assertTrue(GLUT_windows.isInitialized());
      Assert.assertTrue(NativeLibLoader_windows.isGLUTLoaded());
      Assert.assertTrue("freeglut.dll is opened", isModuleLoaded("freeglut.dll"));

      String origin = NativeLibLoader_windows.getGLUTOrigin();
      System.out.println(TestGLUT_windows.class.getSimpleName() + " : freeglut loaded from " + origin);
      if (isCI())
        Assert.assertNotEquals("On CI, freeglut must be loaded from panama-gl-bindings-windows-freeglut, "
            + "not from an installed freeglut.dll", NativeLibLoader_windows.LIBRARY_PATH, origin);

      // When invoking GLUT again, it is not initialized again (glutInit would exit the process)
      GLUT_windows.init();
      gl.glutSolidTeapot(0.5);
    } finally {
      context.destroy();
    }
  }
}
