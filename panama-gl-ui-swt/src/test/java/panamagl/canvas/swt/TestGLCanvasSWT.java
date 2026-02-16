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
package panamagl.canvas.swt;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.PaletteData;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import panamagl.GLEventAdapter;
import panamagl.GLEventListener;
import panamagl.canvas.GLCanvas.Flip;
import panamagl.factory.PanamaGLFactory;
import panamagl.image.SWTImage;
import panamagl.offscreen.FBOReader_SWT;
import panamagl.offscreen.OffscreenRenderer;
import panamagl.offscreen.ThreadRedirect;
import panamagl.offscreen.ThreadRedirect_SWT;
import panamagl.opengl.GL;
import panamagl.opengl.GLContext;
import panamagl.performance.RenderCounter;

/**
 * Unit tests for {@link GLCanvasSWT}, mirroring the structure of
 * {@code TestGLCanvasSWT}, {@code TestGLCanvasSwing_all}, and {@code TestGLCanvasJFX_all}.
 *
 * VM ARGS : -XstartOnFirstThread --enable-native-access=ALL-UNNAMED
 * -Djava.library.path=.:/System/Library/Frameworks/OpenGL.framework/Versions/Current/Libraries/
 */
public class TestGLCanvasSWT {

  Display display;
  Shell shell;
  PanamaGLFactory factory;
  OffscreenRenderer mockOffscreen;

  @Before
  public void setup() {
    display = Display.getCurrent();
    if (display == null) {
      display = new Display();
    }
    shell = new Shell(display);
    shell.setLayout(new FillLayout());

    // Mock the factory to return a mock offscreen renderer
    mockOffscreen = mock(OffscreenRenderer.class);
    factory = mock(PanamaGLFactory.class);
    when(factory.newOffscreenRenderer(any(FBOReader_SWT.class))).thenReturn(mockOffscreen);
  }

  @After
  public void teardown() {
    if (shell != null && !shell.isDisposed()) {
      shell.dispose();
    }
    if (display != null && !display.isDisposed()) {
      display.dispose();
    }
  }

  // ==================== constructor ====================

  @Test
  public void constructor_setsThreadRedirectOnOffscreenRenderer() {
    GLCanvasSWT canvas = new GLCanvasSWT(shell, SWT.NONE, factory);

    Assert.assertFalse(canvas.isDisposed());

    verify(mockOffscreen).setThreadRedirect(any(ThreadRedirect_SWT.class));
  }

  // ==================== setGLEventListener ====================

  @Test
  public void setGLEventListener_callsOffscreenOnInit() {
    GLCanvasSWT canvas = new GLCanvasSWT(shell, SWT.NONE, factory);
    GLEventListener listener = mock(GLEventListener.class);

    canvas.setGLEventListener(listener);

    verify(mockOffscreen).onInit(canvas, listener);
  }

  @Test
  public void setGLEventListener_storesListener() {
    GLCanvasSWT canvas = new GLCanvasSWT(shell, SWT.NONE, factory);
    GLEventListener listener = mock(GLEventListener.class);

    canvas.setGLEventListener(listener);

    Assert.assertSame(listener, canvas.getGLEventListener());
  }

  // ==================== display() ====================

  @Test
  public void display_callsOffscreenOnDisplay() {
    GLCanvasSWT canvas = new GLCanvasSWT(shell, SWT.NONE, factory);
    GLEventListener listener = mock(GLEventListener.class);
    canvas.setGLEventListener(listener);

    when(mockOffscreen.isInitialized()).thenReturn(true);

    canvas.display();

    verify(mockOffscreen).onDisplay(canvas, listener);
  }

  @Test
  public void display_doesNothingWhenNotInitialized() {
    GLCanvasSWT canvas = new GLCanvasSWT(shell, SWT.NONE, factory);

    when(mockOffscreen.isInitialized()).thenReturn(false);

    // Should not throw, and should not call onDisplay
    canvas.display();
  }

  // ==================== isInitialized ====================

  @Test
  public void isInitialized_delegatesToOffscreen() {
    GLCanvasSWT canvas = new GLCanvasSWT(shell, SWT.NONE, factory);

    when(mockOffscreen.isInitialized()).thenReturn(false);
    Assert.assertFalse(canvas.isInitialized());

    when(mockOffscreen.isInitialized()).thenReturn(true);
    Assert.assertTrue(canvas.isInitialized());
  }

  // ==================== getGL / getContext ====================

  @Test
  public void getGL_delegatesToOffscreen() {
    GLCanvasSWT canvas = new GLCanvasSWT(shell, SWT.NONE, factory);
    GL mockGL = mock(GL.class);
    when(mockOffscreen.getGL()).thenReturn(mockGL);

    Assert.assertSame(mockGL, canvas.getGL());
  }

  @Test
  public void getContext_delegatesToOffscreen() {
    GLCanvasSWT canvas = new GLCanvasSWT(shell, SWT.NONE, factory);
    GLContext mockContext = mock(GLContext.class);
    when(mockOffscreen.getContext()).thenReturn(mockContext);

    Assert.assertSame(mockContext, canvas.getContext());
  }

  // ==================== rendering state ====================

  @Test
  public void isRendering_falseByDefault() {
    GLCanvasSWT canvas = new GLCanvasSWT(shell, SWT.NONE, factory);
    Assert.assertFalse(canvas.isRendering());
  }

  @Test
  public void display_setsRenderingTrue() {
    GLCanvasSWT canvas = new GLCanvasSWT(shell, SWT.NONE, factory);
    when(mockOffscreen.isInitialized()).thenReturn(true);

    canvas.display();

    Assert.assertTrue(canvas.isRendering());
  }

  // ==================== screenshot ====================

  @Test
  public void setScreenshot_storesImage() {
    GLCanvasSWT canvas = new GLCanvasSWT(shell, SWT.NONE, factory);
    ImageData data = new ImageData(10, 10, 32, new PaletteData(0xFF0000, 0xFF00, 0xFF));
    SWTImage image = new SWTImage(data);

    canvas.setScreenshot(image);

    Assert.assertSame(image, canvas.getScreenshot());
  }

  // ==================== offscreen renderer ====================

  @Test
  public void getOffscreenRenderer_returnsRenderer() {
    GLCanvasSWT canvas = new GLCanvasSWT(shell, SWT.NONE, factory);
    Assert.assertSame(mockOffscreen, canvas.getOffscreenRenderer());
  }

  // ==================== flip ====================

  @Test
  public void flip_defaultIsVertical() {
    GLCanvasSWT canvas = new GLCanvasSWT(shell, SWT.NONE, factory);
    Assert.assertEquals(Flip.VERTICAL, canvas.getFlip());
  }

  @Test
  public void setFlip_changesFlip() {
    GLCanvasSWT canvas = new GLCanvasSWT(shell, SWT.NONE, factory);
    canvas.setFlip(Flip.HORIZONTAL);
    Assert.assertEquals(Flip.HORIZONTAL, canvas.getFlip());

    canvas.setFlip(Flip.NONE);
    Assert.assertEquals(Flip.NONE, canvas.getFlip());
  }



  // ==================== dimensions ====================

  @Test
  public void getWidth_getHeight_returnBounds() {
    GLCanvasSWT canvas = new GLCanvasSWT(shell, SWT.NONE, factory);
    shell.setSize(320, 240);
    shell.layout();

    // Canvas fills the shell via FillLayout, so dimensions should be > 0
    Assert.assertTrue(canvas.getWidth() > 0);
    Assert.assertTrue(canvas.getHeight() > 0);
  }

  // ==================== dispose ====================

  @Test
  public void dispose_callsOffscreenOnDestroy() {
    GLCanvasSWT canvas = new GLCanvasSWT(shell, SWT.NONE, factory);
    GLEventListener listener = mock(GLEventListener.class);
    canvas.setGLEventListener(listener);

    canvas.dispose();

    verify(mockOffscreen).onDestroy(canvas, listener);
  }

  // ==================== repaint ====================

  @Test
  public void repaint_doesNotThrowWhenNotDisposed() {
    GLCanvasSWT canvas = new GLCanvasSWT(shell, SWT.NONE, factory);
    // Should not throw
    canvas.repaint();
  }

  @Test
  public void repaint_doesNotThrowWhenDisposed() {
    GLCanvasSWT canvas = new GLCanvasSWT(shell, SWT.NONE, factory);
    canvas.dispose();
    // Should not throw
    canvas.repaint();
  }

  // ==================== full lifecycle with real factory ====================

  /**
   * Integration test verifying the full chain:
   * panel → offscreen_renderer → fbo → listener events.
   *
   * Mirrors {@code TestGLCanvasSwing_all.whenPanelIsAdded_ThenGLEventListenerIsInvoked}
   * and {@code TestGLCanvasJFX_all.whenPanelIsAdded_ThenGLEventListenerIsInvoked}.
   */
  @Ignore("Requires native GL context - run with VM args: -XstartOnFirstThread --enable-native-access=ALL-UNNAMED")
  @Test
  public void whenListenerIsSet_ThenGLEventListenerIsInvoked() throws InterruptedException {
    // Given
    EventCounter event = new EventCounter();
    PanamaGLFactory realFactory = PanamaGLFactory.select();

    GLCanvasSWT canvas = new GLCanvasSWT(shell, SWT.NONE, realFactory);

    GLEventListener listener = new GLEventAdapter() {
      @Override
      public void init(GL gl) {
        event.init++;
      }

      @Override
      public void display(GL gl) {
        event.display++;
      }

      @Override
      public void reshape(GL gl, int x, int y, int width, int height) {
        event.reshape++;
      }

      @Override
      public void dispose(GL gl) {
        event.dispose++;
      }
    };

    Assert.assertFalse(canvas.isInitialized());

    // When: set listener triggers offscreen.onInit
    canvas.setGLEventListener(listener);

    // Process SWT events to allow async init
    processEvents(500);

    // Then
    Assert.assertTrue(canvas.isInitialized());
    Assert.assertEquals(1, event.init);

    // When: display
    shell.setSize(200, 200);
    shell.open();

    canvas.display();
    processEvents(500);

    // Then
    Assert.assertTrue(event.display > 0);
    Assert.assertTrue(event.reshape > 0);
    Assert.assertNotNull(canvas.getScreenshot());

    // Then: thread redirect is SWT type
    ThreadRedirect redirect = canvas.getOffscreenRenderer().getThreadRedirect();
    Assert.assertTrue(redirect instanceof ThreadRedirect_SWT);
  }

  /**
   * Integration test verifying FBO resize follows canvas resize.
   *
   * Mirrors {@code TestGLCanvasSwing_all.whenPanelIsResized_ThenFBOIsResized}
   * and {@code TestGLCanvasJFX_all.whenPanelIsResized_ThenFBOIsResized}.
   */
  @Ignore("Requires native GL context - run with VM args: -XstartOnFirstThread --enable-native-access=ALL-UNNAMED")
  @Test
  public void whenCanvasIsResized_ThenFBOIsResized() throws InterruptedException {
    int WIDTH = 100;
    int HEIGHT = 100;

    PanamaGLFactory realFactory = PanamaGLFactory.select();

    GLCanvasSWT canvas = new GLCanvasSWT(shell, SWT.NONE, realFactory);
    canvas.setGLEventListener(new GLEventAdapter());

    processEvents(500);
    Assert.assertTrue(canvas.isInitialized());

    // When: resize + display
    shell.setSize(WIDTH, HEIGHT);
    shell.layout();
    canvas.display();
    processEvents(500);

    // Then: FBO matches
    Assert.assertEquals(canvas.getWidth(), canvas.getFBO().getWidth());
    Assert.assertEquals(canvas.getHeight(), canvas.getFBO().getHeight());

    // When: resize again
    shell.setSize(3 * WIDTH, 2 * HEIGHT);
    shell.layout();
    canvas.display();
    processEvents(500);

    // Then: FBO updated
    Assert.assertEquals(canvas.getWidth(), canvas.getFBO().getWidth());
    Assert.assertEquals(canvas.getHeight(), canvas.getFBO().getHeight());
  }

  // ==================== helpers ====================

  /** Process SWT events for the given duration in milliseconds. */
  private void processEvents(long durationMs) {
    long deadline = System.currentTimeMillis() + durationMs;
    while (System.currentTimeMillis() < deadline) {
      if (!display.readAndDispatch()) {
        display.sleep();
      }
    }
  }

  protected class EventCounter {
    int init = 0;
    int display = 0;
    int reshape = 0;
    int dispose = 0;
  }
}
