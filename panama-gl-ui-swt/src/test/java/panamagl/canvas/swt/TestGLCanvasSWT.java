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

import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.opengl.GLData;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import panamagl.GLEventAdapter;
import panamagl.GLEventListener;
import panamagl.factory.PanamaGLFactory;
import panamagl.opengl.GL;

/**
 * VM ARGS : -XstartOnFirstThread --enable-native-access=ALL-UNNAMED
 * -Djava.library.path=.:/System/Library/Frameworks/OpenGL.framework/Versions/Current/Libraries/
 */
public class TestGLCanvasSWT {

  Display display;
  Shell shell;
  PanamaGLFactory factory;
  GL mockGL;

  @Before
  public void setup() {
    display = Display.getCurrent();
    if (display == null) {
      display = new Display();
    }
    shell = new Shell(display);
    shell.setLayout(new FillLayout());

    mockGL = mock(GL.class);
    factory = mock(PanamaGLFactory.class);
    when(factory.newGL()).thenReturn(mockGL);
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

  // ==================== createDefaultGLData ====================

  @Test
  public void defaultGLData_hasDoubleBuffer() {
    GLData data = GLCanvasSWT.createDefaultGLData();
    Assert.assertTrue("GLData should have doubleBuffer enabled", data.doubleBuffer);
  }

  @Test
  public void defaultGLData_hasDepthBuffer() {
    GLData data = GLCanvasSWT.createDefaultGLData();
    Assert.assertEquals("GLData should request a 24-bit depth buffer", 24, data.depthSize);
  }

  // ==================== setGLEventListener lifecycle ====================

  @Test
  public void setGLEventListener_callsInitOnListener() {
    GLCanvasSWT canvas = new GLCanvasSWT(shell, SWT.NONE, factory);

    GLEventListener listener = mock(GLEventListener.class);
    canvas.setGLEventListener(listener);

    verify(listener).init(mockGL);
  }

  @Test
  public void setGLEventListener_callsSetCurrentBeforeInit() {
    List<String> callOrder = new ArrayList<>();

    // Subclass to track setCurrent() calls
    GLCanvasSWT canvas = new GLCanvasSWT(shell, SWT.NONE, factory) {
      @Override
      public void setCurrent() {
        callOrder.add("setCurrent");
        super.setCurrent();
      }
    };

    GLEventListener listener = new GLEventAdapter() {
      @Override
      public void init(GL gl) {
        callOrder.add("init");
      }
    };

    canvas.setGLEventListener(listener);

    Assert.assertTrue("setCurrent should be called", callOrder.contains("setCurrent"));
    Assert.assertTrue("init should be called", callOrder.contains("init"));
    int setCurrentIndex = callOrder.indexOf("setCurrent");
    int initIndex = callOrder.indexOf("init");
    Assert.assertTrue("setCurrent must be called before init", setCurrentIndex < initIndex);
  }

  @Test
  public void setGLEventListener_disposesOldListener() {
    GLCanvasSWT canvas = new GLCanvasSWT(shell, SWT.NONE, factory);

    GLEventListener first = mock(GLEventListener.class);
    GLEventListener second = mock(GLEventListener.class);

    canvas.setGLEventListener(first);
    canvas.setGLEventListener(second);

    verify(first).dispose(mockGL);
    verify(second).init(mockGL);
  }

  @Test
  public void setGLEventListener_doesNotCallInitForNull() {
    GLCanvasSWT canvas = new GLCanvasSWT(shell, SWT.NONE, factory);

    // Should not throw
    canvas.setGLEventListener(null);
    Assert.assertNull(canvas.getGLEventListener());
  }

  @Test
  public void setGLEventListener_sameListenerIsIgnored() {
    GLCanvasSWT canvas = new GLCanvasSWT(shell, SWT.NONE, factory);
    GLEventListener listener = mock(GLEventListener.class);

    canvas.setGLEventListener(listener);
    // Setting the same listener again should not re-init
    canvas.setGLEventListener(listener);

    // init should only be called once
    verify(listener).init(mockGL);
    verify(listener, never()).dispose(mockGL);
  }

  // ==================== display() ====================

  @Test
  public void display_callsListenerDisplay() {
    GLCanvasSWT canvas = new GLCanvasSWT(shell, SWT.NONE, factory);
    GLEventListener listener = mock(GLEventListener.class);
    canvas.setGLEventListener(listener);

    canvas.display();

    verify(listener).display(mockGL);
  }

  @Test
  public void display_doesNothingWhenDisposed() {
    GLCanvasSWT canvas = new GLCanvasSWT(shell, SWT.NONE, factory);
    GLEventListener listener = mock(GLEventListener.class);
    canvas.setGLEventListener(listener);

    canvas.dispose();

    // Should not throw
    canvas.display();
  }

  @Test
  public void display_doesNothingWithNoListener() {
    GLCanvasSWT canvas = new GLCanvasSWT(shell, SWT.NONE, factory);

    // Should not throw
    canvas.display();
  }

  // ==================== getGL ====================

  @Test
  public void getGL_returnsFactoryGL() {
    GLCanvasSWT canvas = new GLCanvasSWT(shell, SWT.NONE, factory);
    Assert.assertSame(mockGL, canvas.getGL());
  }

  @Test(expected = org.eclipse.swt.SWTError.class)
  public void getGL_throwsAfterDispose() {
    GLCanvasSWT canvas = new GLCanvasSWT(shell, SWT.NONE, factory);
    canvas.dispose();
    canvas.getGL();
  }

  // ==================== dispose ====================

  @Test
  public void dispose_callsListenerDispose() {
    GLCanvasSWT canvas = new GLCanvasSWT(shell, SWT.NONE, factory);
    GLEventListener listener = mock(GLEventListener.class);
    canvas.setGLEventListener(listener);

    canvas.dispose();

    verify(listener).dispose(mockGL);
  }

  @Test
  public void dispose_clearsListener() {
    GLCanvasSWT canvas = new GLCanvasSWT(shell, SWT.NONE, factory);
    GLEventListener listener = mock(GLEventListener.class);
    canvas.setGLEventListener(listener);

    canvas.dispose();

    Assert.assertNull(canvas.getGLEventListener());
  }

  // ==================== rendering state ====================

  @Test
  public void isRendering_falseByDefault() {
    GLCanvasSWT canvas = new GLCanvasSWT(shell, SWT.NONE, factory);
    Assert.assertFalse(canvas.isRendering());
  }

  // ==================== macOS Cocoa setRedraw(false) ====================

  @Test
  public void constructor_doesNotCrashOnCurrentPlatform() {
    // Validates that the setRedraw(false) workaround for macOS Cocoa
    // does not break canvas creation on any platform.
    GLCanvasSWT canvas = new GLCanvasSWT(shell, SWT.NONE, factory);
    Assert.assertNotNull(canvas);
    Assert.assertFalse(canvas.isDisposed());
  }

  // ==================== isInitialized ====================

  @Test
  public void isInitialized_alwaysTrue() {
    GLCanvasSWT canvas = new GLCanvasSWT(shell, SWT.NONE, factory);
    Assert.assertTrue(canvas.isInitialized());
  }

  // ==================== dispose waits for rendering (#4) ====================

  @Test
  public void dispose_waitsForRenderingToComplete() throws InterruptedException {
    GLCanvasSWT canvas = new GLCanvasSWT(shell, SWT.NONE, factory);

    AtomicBoolean glWasAliveAtDispose = new AtomicBoolean(false);

    GLEventListener listener = new GLEventAdapter() {
      @Override
      public void dispose(GL gl) {
        glWasAliveAtDispose.set(gl != null);
      }
    };
    canvas.setGLEventListener(listener);

    // Simulate an in-progress render
    canvas.rendering.set(true);

    // A background thread will clear the rendering flag after a short delay,
    // simulating a render completing on another thread while dispose spin-waits.
    Thread renderSimulator = new Thread(() -> {
      try {
        Thread.sleep(100);
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
      }
      canvas.rendering.set(false);
    });
    renderSimulator.start();

    // dispose() runs on the current (UI) thread. The disposeListener will
    // spin-wait until rendering becomes false, then proceed with cleanup.
    canvas.dispose();
    renderSimulator.join(2000);

    Assert.assertFalse("rendering should be false after dispose",
        canvas.isRendering());
    Assert.assertTrue("gl should have been non-null when listener.dispose was called",
        glWasAliveAtDispose.get());
    Assert.assertNull("listener should be null after dispose",
        canvas.getGLEventListener());
  }

  @Test
  public void dispose_setsGlToNull() {
    GLCanvasSWT canvas = new GLCanvasSWT(shell, SWT.NONE, factory);
    GLEventListener listener = mock(GLEventListener.class);
    canvas.setGLEventListener(listener);

    Assert.assertNotNull("gl should be available before dispose", canvas.getGL());

    canvas.dispose();

    // gl is now null - getGL should throw
    boolean threw = false;
    try {
      canvas.getGL();
    } catch (org.eclipse.swt.SWTError e) {
      threw = true;
    }
    Assert.assertTrue("getGL should throw after dispose nullifies gl", threw);
  }

  @Test
  public void dispose_renderingFlagIsFalseAfterDisplay() {
    GLCanvasSWT canvas = new GLCanvasSWT(shell, SWT.NONE, factory);
    GLEventListener listener = mock(GLEventListener.class);
    canvas.setGLEventListener(listener);

    canvas.display();

    Assert.assertFalse("rendering flag should be false after display completes",
        canvas.isRendering());
  }

  @Test
  public void display_renderingFlagResetEvenOnException() {
    GLCanvasSWT canvas = new GLCanvasSWT(shell, SWT.NONE, factory);

    GLEventListener listener = new GLEventAdapter() {
      @Override
      public void display(GL gl) {
        throw new RuntimeException("simulated rendering error");
      }
    };
    canvas.setGLEventListener(listener);

    try {
      canvas.display();
    } catch (RuntimeException e) {
      // expected
    }

    Assert.assertFalse("rendering flag must be reset even after exception",
        canvas.isRendering());
  }
}
