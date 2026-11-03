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
package panamagl.offscreen;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.awt.EventQueue;
import java.lang.foreign.MemorySegment;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.junit.Assert;
import org.junit.Test;
import panamagl.GLEventListener;
import panamagl.canvas.GLCanvas;
import panamagl.factory.PanamaGLFactory;
import panamagl.opengl.GL;
import panamagl.opengl.GLContext;

/**
 * Reproduce deterministically, without GPU, the failure reported on macOS with Jzy3D :
 *
 * <pre>
 * RuntimeException: Incomplete framebuffer, not supporting current FBO config : 36054 != GL_FRAMEBUFFER_COMPLETE (36053)
 *   at FBO_macOS.prepare
 *   at AOffscreenRenderer.renderGLToImage
 *   at AOffscreenRenderer.onDisplay
 *   at GLCanvasSwing.display
 *   at (Jzy3D) View.shoot <- View.init <- Renderer3D.init          = GLEventListener.init(gl)
 *   at AOffscreenRenderer.initContext
 *   at AOffscreenRenderer.onInit
 *   at GLCanvasSwing.addNotify                                     on AWT-EventQueue-0
 * </pre>
 *
 * <h2>The scenario</h2>
 *
 * <ol>
 * <li>{@code addNotify()} is invoked by Swing <b>on the AWT Event Dispatch Thread</b>, when the
 * canvas is added to a displayable parent. The canvas has not been laid out yet : it is 0x0.</li>
 * <li>{@link AWTThreadRedirect} sees we already are on the EDT, so {@code initContext} runs
 * <b>synchronously</b>, inside {@code addNotify()}.</li>
 * <li>{@code initContext} marks the renderer initialized, then calls
 * {@link GLEventListener#init(GL)}.</li>
 * <li>The listener asks for a display from its init (Jzy3D does it to compute the view bounds). As
 * the renderer already says {@code isInitialized()==true}, the display is not skipped, and since
 * we are still on the EDT it runs <b>synchronously, re-entering the renderer while it is still
 * initializing</b>.</li>
 * <li>{@code onDisplay} reads the canvas size (0x0), resizes the FBO to 0x0 and prepares it. An FBO
 * with a 0x0 attachment is not complete for OpenGL (GL_FRAMEBUFFER_INCOMPLETE_ATTACHMENT = 36054),
 * hence the exception.</li>
 * </ol>
 *
 * <h2>Why this looked like a concurrency issue</h2>
 *
 * Whether it fails depends on the thread that calls {@code addNotify()} and on when the layout
 * happens : if {@code addNotify()} is called from another thread, {@code initContext} is posted to
 * the EDT with {@code invokeLater} and generally runs after the layout, when the canvas has a size.
 * Existing tests call {@code addNotify()} from the test thread, which is why they never hit it.
 *
 * <h2>How this test makes it deterministic</h2>
 *
 * <ul>
 * <li>{@code onInit} is invoked from the EDT through {@link EventQueue#invokeAndWait(Runnable)}
 * exactly like Swing does with {@code addNotify()} : init and the re-entrant display run
 * synchronously, in a fixed order, without any sleep.</li>
 * <li>The canvas reports a 0x0 size, as a canvas that has not been laid out yet.</li>
 * <li>The listener requests a display from {@code init()} through the same gate as
 * {@code GLCanvasSwing.display()} : {@code if(renderer.isInitialized()) renderer.onDisplay(..)}.</li>
 * <li>The FBO enforces the OpenGL framebuffer completeness rule on its size : it records and throws
 * like {@code FBO_macOS} when prepared with an empty size.</li>
 * </ul>
 */
public class TestAOffscreenRenderer_DisplayDuringInit {

  /**
   * An FBO that does not need a GPU but enforces the OpenGL rule that matters here : a framebuffer
   * which attachment has a zero width or height is not complete (see the "Framebuffer Completeness"
   * section of the OpenGL specification).
   */
  static class SizeCheckingFBO extends AFBO {
    /** GL_FRAMEBUFFER_INCOMPLETE_ATTACHMENT */
    static final int INCOMPLETE_ATTACHMENT = 36054;
    /** GL_FRAMEBUFFER_COMPLETE */
    static final int COMPLETE = 36053;

    final List<String> incompletePrepares = new CopyOnWriteArrayList<>();

    SizeCheckingFBO(int width, int height) {
      this.width = width;
      this.height = height;
    }

    @Override
    public void prepare(GL gl) {
      if (width <= 0 || height <= 0) {
        String status = "FBO prepared with an empty size " + width + "x" + height + " on thread "
            + Thread.currentThread().getName();
        incompletePrepares.add(status);

        // same message as FBO_macOS
        throw new RuntimeException(
            "Incomplete framebuffer, not supporting current FBO config : " + INCOMPLETE_ATTACHMENT
                + " != GL_FRAMEBUFFER_COMPLETE (" + COMPLETE + ") : " + status);
      }
      prepared = true;
    }

    @Override
    public void release(GL gl) {
      prepared = false;
    }

    @Override
    public MemorySegment readPixels(GL gl) {
      return MemorySegment.NULL;
    }

    @Override
    protected void bindFramebuffer(int id) {}
  }

  /**
   * A listener requesting a display from its init, as Jzy3D does (Renderer3D.init -> View.init ->
   * View.updateBounds -> View.shoot -> canvas.forceRepaint -> GLCanvasSwing.display).
   */
  static class DisplayFromInitListener implements GLEventListener {
    AOffscreenRenderer renderer;
    GLCanvas canvas;

    volatile int init = 0;
    volatile int display = 0;

    @Override
    public void init(GL gl) {
      init++;

      // Same gate as GLCanvasSwing.display()
      if (renderer.isInitialized()) {
        renderer.onDisplay(canvas, this);
      }
    }

    @Override
    public void display(GL gl) {
      display++;
    }

    @Override
    public void reshape(GL gl, int x, int y, int width, int height) {}

    @Override
    public void dispose(GL gl) {}
  }


  @Test
  public void whenListenerRequestsDisplayFromInit_onAWTThread_withNotYetLaidOutCanvas_thenFBOIsNeverPreparedWithAnEmptySize()
      throws Exception {

    // ------------------------------------------------
    // Given a renderer with GL mocks but an FBO enforcing the completeness rule on its size

    PanamaGLFactory factory = mock(PanamaGLFactory.class);
    when(factory.newGL()).thenReturn(mock(GL.class));
    when(factory.newGLContext()).thenReturn(mock(GLContext.class));
    when(factory.newFBO(anyInt(), anyInt()))
        .thenAnswer(inv -> new SizeCheckingFBO(inv.getArgument(0), inv.getArgument(1)));

    FBOReader reader = mock(FBOReader.class);

    // Given a canvas that is not laid out yet (as when Swing calls addNotify())
    GLCanvas canvas = mock(GLCanvas.class);
    when(canvas.getWidth()).thenReturn(0);
    when(canvas.getHeight()).thenReturn(0);
    when(canvas.getPhysicalWidth()).thenReturn(0);
    when(canvas.getPhysicalHeight()).thenReturn(0);

    AOffscreenRenderer renderer = new AOffscreenRenderer(factory, reader);
    // Use the default redirection, the one used with GLCanvasSwing on macOS (CGL), Linux, Windows
    Assert.assertTrue(renderer.getThreadRedirect() instanceof AWTThreadRedirect);

    // Given a listener that requests a display from its init
    DisplayFromInitListener listener = new DisplayFromInitListener();
    listener.renderer = renderer;
    listener.canvas = canvas;

    // ------------------------------------------------
    // When the renderer is initialized from the AWT thread, as GLCanvasSwing.addNotify() is

    Throwable failure = null;
    try {
      EventQueue.invokeAndWait(() -> renderer.onInit(canvas, listener));
    } catch (InvocationTargetException e) {
      failure = e.getCause();
    }

    // Let any task that the renderer may have posted to the EDT run as well
    EventQueue.invokeAndWait(() -> {});

    // ------------------------------------------------
    // Then the initialization went through

    Assert.assertEquals(1, listener.init);

    SizeCheckingFBO fbo = (SizeCheckingFBO) renderer.getFBO();

    if (failure != null) {
      failure.printStackTrace();
    }

    Assert.assertTrue(
        "The FBO must never be prepared with an empty size, but : " + fbo.incompletePrepares,
        fbo.incompletePrepares.isEmpty());
    Assert.assertNull("onInit should not throw, but threw : " + failure, failure);
    Assert.assertTrue(renderer.isInitialized());
  }
}
