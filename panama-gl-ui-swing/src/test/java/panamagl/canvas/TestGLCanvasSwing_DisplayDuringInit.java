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
package panamagl.canvas;

import java.awt.EventQueue;
import java.awt.GraphicsEnvironment;
import java.lang.reflect.InvocationTargetException;
import org.junit.Assert;
import org.junit.Assume;
import org.junit.Test;
import panamagl.GLEventListener;
import panamagl.factory.PanamaGLFactory;
import panamagl.opengl.GL;

/**
 * Reproduce with the real OpenGL of the running OS the failure reported on macOS with Jzy3D :
 *
 * <pre>
 * Exception in thread "AWT-EventQueue-0" java.lang.RuntimeException: Incomplete framebuffer, not supporting current FBO config : 36054 != GL_FRAMEBUFFER_COMPLETE (36053)
 *   at panamagl.platform.macos.FBO_macOS.prepare(FBO_macOS.java:177)
 *   at panamagl.offscreen.AOffscreenRenderer.renderGLToImage(AOffscreenRenderer.java:192)
 *   ...
 *   at panamagl.canvas.GLCanvasSwing.display(GLCanvasSwing.java:275)
 *   at org.jzy3d.plot3d.rendering.canvas.PanamaGLCanvasSupport.forceRepaint(PanamaGLCanvasSupport.java:101)
 *   at org.jzy3d.plot3d.rendering.view.View.shoot(View.java:316)
 *   at org.jzy3d.plot3d.rendering.view.View.init(View.java:691)
 *   at org.jzy3d.plot3d.rendering.canvas.Renderer3D.init(Renderer3D.java:69)
 *   at panamagl.offscreen.AOffscreenRenderer.initContext(AOffscreenRenderer.java:165)
 *   ...
 *   at panamagl.canvas.GLCanvasSwing.addNotify(GLCanvasSwing.java:147)
 * </pre>
 *
 * The listener requests a display from its init, as Jzy3D does, and {@code addNotify()} is invoked
 * from the AWT Event Dispatch Thread, as Swing does when the canvas is added to a displayable
 * parent, before it is laid out (0x0). This makes the init and the re-entrant display run
 * synchronously in a fixed order : the failure is deterministic, no sleep is involved.
 *
 * Existing tests invoke {@code addNotify()} from the test thread, hence the init is posted to the
 * EDT and the display requested from init is never re-entrant, which is why they did not catch it.
 *
 * @see panamagl.offscreen.TestAOffscreenRenderer_DisplayDuringInit for the same scenario without GPU
 */
public class TestGLCanvasSwing_DisplayDuringInit {

  /** Request a display from init, as Jzy3D's Renderer3D.init -> View.init -> View.shoot does. */
  static class DisplayFromInitListener implements GLEventListener {
    GLCanvasSwing canvas;
    volatile int init = 0;
    volatile int display = 0;
    volatile int dispose = 0;

    @Override
    public void init(GL gl) {
      init++;
      canvas.display();
    }

    @Override
    public void display(GL gl) {
      display++;
    }

    @Override
    public void reshape(GL gl, int x, int y, int width, int height) {}

    @Override
    public void dispose(GL gl) {
      dispose++;
    }
  }

  @Test
  public void whenListenerRequestsDisplayFromInit_andAddNotifyIsCalledByAWTThread_thenInitDoesNotFail()
      throws Exception {
    Assume.assumeFalse(GraphicsEnvironment.isHeadless());

    // Given a canvas with a listener that requests a display from its init
    GLCanvasSwing canvas = new GLCanvasSwing(PanamaGLFactory.select());

    DisplayFromInitListener listener = new DisplayFromInitListener();
    listener.canvas = canvas;
    canvas.setGLEventListener(listener);

    // Given the canvas is not laid out yet
    Assert.assertEquals(0, canvas.getWidth());
    Assert.assertEquals(0, canvas.getHeight());

    // When the canvas is notified it was added to a parent, from the AWT thread, as Swing does
    Throwable failure = null;
    try {
      EventQueue.invokeAndWait(canvas::addNotify);
    } catch (InvocationTargetException e) {
      failure = e.getCause();
      failure.printStackTrace();
    }

    try {
      // Let any task that the canvas may have posted to the EDT run as well
      EventQueue.invokeAndWait(() -> {});

      // Then the init went through without error
      Assert.assertNull("addNotify() should not throw, but threw : " + failure, failure);
      Assert.assertEquals(1, listener.init);
      Assert.assertTrue(canvas.isInitialized());
    } finally {
      if (canvas.isInitialized()) {
        EventQueue.invokeAndWait(canvas::removeNotify);
      }
    }
  }
}
