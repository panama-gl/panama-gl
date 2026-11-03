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
import org.junit.Test;
import panamagl.opengl.GL;

/**
 * Check what happens when freeglut is missing : neither in the java.library.path nor in the
 * classpath. WGL rendering works, and GLUT fails with an UnsatisfiedLinkError naming the jar to add,
 * instead of crashing or exiting the process.
 *
 * Runs in the <code>without-freeglut</code> surefire execution of this module, which excludes
 * panama-gl-bindings-windows-freeglut from the classpath. On CI, where freeglut is not installed,
 * the test fails if freeglut is found anyway, so that it can not be skipped silently.
 */
public class TestGLUT_windows_withoutFreeglut extends WindowsTest {

  @Test
  public void glutFailsExplicitlyWithoutFreeglut() {
    if (!checkPlatform())
      return;

    // Given freeglut missing
    String resource =
        NativeLibLoader_windows.resource(NativeLibLoader_windows.GLUT, System.getProperty("os.arch"));
    assumeOrFailOnCI(NativeLibLoader_windows.GLUT_ARTIFACT + " is excluded from the classpath",
        getClass().getClassLoader().getResource(resource) == null);
    assumeOrFailOnCI("freeglut.dll is not installed in the java.library.path : "
        + findInLibraryPath("freeglut.dll"), findInLibraryPath("freeglut.dll") == null);

    WGLContext_windows context = new WGLContext_windows();
    context.init();
    context.makeCurrent();

    try {
      GL gl = new GL_windows();

      // When rendering without GLUT, then it works
      gl.glClearColor(1f, 1f, 1f, 1f);
      gl.glClear(GL.GL_COLOR_BUFFER_BIT);
      gl.glFinish();

      // When invoking a GLUT function, then it fails explicitly
      try {
        gl.glutSolidTeapot(0.5);
        Assert.fail("expect an UnsatisfiedLinkError");
      } catch (UnsatisfiedLinkError e) {
        Assert.assertTrue(e.getMessage(),
            e.getMessage().contains(NativeLibLoader_windows.GLUT_ARTIFACT));
      }

      Assert.assertFalse(GLUT_windows.isInitialized());
      Assert.assertFalse(NativeLibLoader_windows.isGLUTLoaded());
      Assert.assertFalse(isModuleLoaded("freeglut.dll"));

      // When invoking GLUT again, it fails again the same way
      try {
        GLUT_windows.init();
        Assert.fail("expect an UnsatisfiedLinkError");
      } catch (UnsatisfiedLinkError e) {
        Assert.assertTrue(e.getMessage(),
            e.getMessage().contains(NativeLibLoader_windows.GLUT_ARTIFACT));
      }

      // Then WGL rendering still works
      gl.glClear(GL.GL_COLOR_BUFFER_BIT);
      gl.glFinish();
    } finally {
      context.destroy();
    }
  }
}
