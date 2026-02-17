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
package panamagl.platform.macos;

import org.junit.Assert;
import org.junit.Test;
import panamagl.offscreen.AWTThreadRedirect;
import panamagl.offscreen.FBO;
import panamagl.offscreen.FBOReader;
import panamagl.offscreen.MacOSThreadRedirect;
import panamagl.offscreen.OffscreenRenderer;
import panamagl.offscreen.ThreadRedirect;
import panamagl.opengl.GL;

/**
 * Verify that {@link APanamaGLFactory_macOS} assigns the correct {@link ThreadRedirect}
 * depending on whether CGL or GLUT is used.
 *
 * <ul>
 *   <li>CGL (default) → {@link AWTThreadRedirect} (CGL is thread-portable, no need for the macOS main thread)</li>
 *   <li>GLUT → {@link MacOSThreadRedirect} (GLUT requires the macOS main thread)</li>
 * </ul>
 */
public class TestAPanamaGLFactory_macOS_ThreadRedirect extends MacOSTest {

  /**
   * A minimal concrete subclass of {@link APanamaGLFactory_macOS} that avoids
   * creating real GL bindings (not needed to test ThreadRedirect wiring).
   */
  static class TestableFactory extends APanamaGLFactory_macOS {
    @Override
    public panamagl.opengl.GL newGL() {
      return null; // not needed for this test
    }

    /** Expose the protected field for testing. */
    public void setUseGLUT(boolean useGLUT) {
      this.useGLUT = useGLUT;
    }
  }

  @Test
  public void whenCGL_thenRendererUsesAWTThreadRedirect() {
    if (!checkPlatform())
      return;

    TestableFactory factory = new TestableFactory();
    factory.setUseGLUT(false);

    OffscreenRenderer renderer = factory.newOffscreenRenderer(mockReader());

    Assert.assertNotNull(renderer.getThreadRedirect());
    Assert.assertTrue("CGL should use AWTThreadRedirect, got " + renderer.getThreadRedirect().getClass().getSimpleName(),
        renderer.getThreadRedirect() instanceof AWTThreadRedirect);
  }

  @Test
  public void whenGLUT_thenRendererUsesMacOSThreadRedirect() {
    if (!checkPlatform())
      return;

    TestableFactory factory = new TestableFactory();
    factory.setUseGLUT(true);

    OffscreenRenderer renderer = factory.newOffscreenRenderer(mockReader());

    Assert.assertNotNull(renderer.getThreadRedirect());
    Assert.assertTrue("GLUT should use MacOSThreadRedirect, got " + renderer.getThreadRedirect().getClass().getSimpleName(),
        renderer.getThreadRedirect() instanceof MacOSThreadRedirect);
  }

  @Test
  public void whenUserSetsExplicitThreadRedirect_thenItTakesPrecedence() {
    if (!checkPlatform())
      return;

    ThreadRedirect custom = new ThreadRedirect() {
      @Override
      public void run(Runnable runnable) {
        runnable.run();
      }
    };

    TestableFactory factory = new TestableFactory();
    factory.setUseGLUT(false);
    factory.setThreadRedirect(custom);

    OffscreenRenderer renderer = factory.newOffscreenRenderer(mockReader());

    Assert.assertSame("User-provided ThreadRedirect should take precedence", custom, renderer.getThreadRedirect());
  }

  /** Dummy FBOReader — never called, only needed to construct the renderer. */
  private FBOReader mockReader() {
    return (FBO fbo, GL gl) -> null;
  }
}
