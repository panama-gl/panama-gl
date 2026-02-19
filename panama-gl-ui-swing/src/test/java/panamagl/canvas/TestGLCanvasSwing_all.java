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
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.Ignore;
import org.junit.Test;
import junit.framework.Assert;
import panamagl.GLEventListener;
import panamagl.factory.PanamaGLFactory;
import panamagl.offscreen.FBOReader_AWT;
import panamagl.offscreen.OffscreenRenderer;
import panamagl.opengl.GL;
import panamagl.platform.macos.OffscreenRenderer_macOS;
import panamagl.utils.ThreadUtils;
import panamagl.utils.TicToc;


// VM ARGS : --enable-native-access=ALL-UNNAMED 
//
// -Djava.library.path=.:/System/Library/Frameworks/OpenGL.framework/Versions/Current/Libraries/
//
// or
// -Djava.library.path=.:/usr/lib/x86_64-linux-gnu/
//
// or
// -Djava.library.path="C:\Windows\system32;C:\Users\Martin\Downloads\freeglut-MSVC-3.0.0-2.mp\freeglut\bin\x64"
public class TestGLCanvasSwing_all {
  // the time needed to init/destroy a Swing canvas differ
  // with OS. Windows needed 1s
  // TODO : allow locking on the execution of addNotify
  public static int WAIT_FOR_INIT_AND_DESTROY = 1000;
  public static int WAIT_FOR_RENDER_DISPATCHED_MS = 1000;

  /*@Test
  public void whenPanelIsAdded_ThenGLEventListenerIsInvoked() throws InterruptedException {
    System.err.println("!!\n\tFLAKKY TEST WARNING : may fail because of race condition before asserts");

    // ------------------------------------------------
    // Given a panel 

    PanamaGLFactory factory = PanamaGLFactory.select();
    
    GLCanvasSwing panel = new GLCanvasSwing(factory);

    GLEventListener listener = mock(GLEventListener.class);
    panel.setGLEventListener(listener);

    Assert.assertFalse(panel.isInitialized());
    
    verify(listener, times(0)).init(any());
    verify(listener, times(0)).display(any());
    verify(listener, times(0)).reshape(any(), anyInt(), anyInt(), anyInt(), anyInt());
    verify(listener, times(0)).dispose(any());


    // ------------------------------------------------
    // When : GL initialization is triggered by panel addition
    // to its parent frame

    panel.addNotify();
    
    // Let AWT or macOS main thread to perform initialization
    Thread.yield();
    Thread.sleep(WAIT_FOR_INIT_AND_DESTROY);

    verify(listener, times(1)).init(any());
    
    // Then context is initialized
    Assert.assertTrue(panel.getContext().isInitialized());

    // Then panel is initialized
    Assert.assertTrue(panel.isInitialized());



    // ------------------------------------------------
    // When : resize, and after a while

    panel.setSize(20, 20);
    //panel.display(); // used to be required from maven

    // Wait for the event to dispatch
    Thread.sleep(WAIT_FOR_RENDER_DISPATCHED_MS);

    // Then : should trigger glEventListener.display() and reshape()
    verify(listener, times(1)).init(any());
    verify(listener, times(1)).display(any());
    verify(listener, times(1)).reshape(any(), anyInt(), anyInt(), anyInt(), anyInt());
    verify(listener, times(0)).dispose(any());

    // Then : the displayed image should be available as screenshot
    Assert.assertNotNull(panel.getScreenshot());



    // ------------------------------------------------
    // When : remove from component hierarchy

    panel.removeNotify();

    // Let AWT or macOS main thread to perform initialization
    Thread.sleep(WAIT_FOR_INIT_AND_DESTROY);

    // Then : all components are not initialized anymore
    Assert.assertFalse(panel.getContext().isInitialized());
    Assert.assertFalse(panel.isInitialized());
    
    verify(listener, times(1)).init(any());
    verify(listener, times(1)).display(any());
    verify(listener, times(1)).reshape(any(), anyInt(), anyInt(), anyInt(), anyInt());
    verify(listener, times(1)).dispose(any());

  }*/

  /**
   * Verify that event listener get invoked when panel is added.
   * 
   * This check the whole chain panel->listener->offscreen_renderer->fbo.
   * 
   * Having multiple tests here is important to detect issue related to multiple calls to 
   * <code>glutInit(...)</code>. Please keep them here.
   */
  @Test
  public void whenPanelIsAdded_ThenGLEventListenerIsInvoked() throws InterruptedException {

    BlockingGLListener glGate = new BlockingGLListener();
    
    // ------------------------------------------------
    // Given a panel with an event counter


    PanamaGLFactory factory = PanamaGLFactory.select();
    
    System.out.println("FACTORY  " + factory);
    
    GLCanvasSwing panel = new GLCanvasSwing(factory);
    panel.setGLEventListener(glGate);


    Assert.assertFalse(panel.isInitialized());


    // ------------------------------------------------
    // When : GL initialization is triggered by panel addition
    // to its parent frame

    panel.addNotify();
    
    // Let AWT or macOS main thread to perform initialization
    glGate.awaitInit();

    // Then : should trigger glEventListener.init()
    Assert.assertEquals(1, glGate.getCounter().init);
    Assert.assertEquals(0, glGate.getCounter().display);
    Assert.assertEquals(0, glGate.getCounter().reshape);

    // Then context is initialized
    Assert.assertTrue(panel.getContext().isInitialized());

    // Then panel is initialized
    Assert.assertTrue(panel.isInitialized());



    // ------------------------------------------------
    // When : resize, and after a while

    panel.setSize(20, 20);

    // FIXME : not needed from IDE but from CLI (?!)
    panel.display();

    // Wait for the event to dispatch
    glGate.awaitDisplay();
    
    // Then : should trigger glEventListener.display() and reshape()
    Assert.assertTrue(0 < glGate.getCounter().init);
    Assert.assertTrue(0 < glGate.getCounter().display);
    Assert.assertTrue(0 < glGate.getCounter().reshape);
    Assert.assertTrue(0 == glGate.getCounter().dispose);

    // Wait for the image to be transfered to panel
    Thread.sleep(200);
    
    // Then : the displayed image should be available as screenshot
    Assert.assertNotNull(panel.getScreenshot());



    // ------------------------------------------------
    // When : remove from component hierarchy

    panel.removeNotify();

    // Let AWT or macOS main thread to perform dispose
    glGate.awaitDispose();
    
    // Then : all components are not initialized anymore
    Assert.assertFalse(panel.getContext().isInitialized());
    Assert.assertFalse(panel.isInitialized());
    Assert.assertTrue(0 < glGate.getCounter().dispose);

  }






  /**
   * Verify that FBO is resized when Panel is resized.
   *
   * <p>This checks the whole chain panel-&gt;listener-&gt;offscreen_renderer-&gt;fbo.
   *
   * <p>Having multiple tests here is important to detect issues related to multiple calls to
   * {@code glutInit(...)}. Please keep them here.
   *
   * <h3>Synchronization design</h3>
   *
   * <p>Each {@code panel.setSize()} call produces <em>two</em> renders on the AWT EDT:
   * one from {@code ResizeHandler.componentResized()} and one from the explicit
   * {@code panel.display()} call. {@code BlockingGLListener} uses one
   * {@code CountDownLatch} per event type; {@code awaitDisplay()} unblocks on the
   * <em>first</em> render, leaving the second one still queued ("stale").
   * {@code resetLatches()} must drain that stale render before creating new latches,
   * otherwise the stale event would prematurely release the new latch.
   *
   * <pre>
   * Test thread              AWT EDT                   BlockingGLListener
   * -----------              -------                   ------------------
   *
   * setSize(100,100) ------> componentResized()
   *                            onResize() [direct call, EDT]
   *                            renderGLToImage(100,100)
   *                              fbo.resize(100)
   *                              listener.display() ---------> displayLatch.countDown()
   *                                                             (latch: 1 -> 0)
   * panel.display() -------> invokeLater(r1=render100)  &lt;-- r1 still queued
   *
   * awaitDisplay() &lt;----------------------------------------- unblocks (latch=0)
   * [asserts ok, FBO=100]
   *
   *                          r1 runs: renderGLToImage(100,100)   &lt;-- STALE
   *                            fbo.resize(100)
   * resetLatches()             listener.display() ---------> would hit NEW latch!
   *   invokeAndWait( {} ) ---> [barrier: wait for r1 to finish first]
   *   &lt;----------------------- barrier passed, queue empty
   *   new displayLatch(1)                                        (safe: r1 already done)
   *
   * setSize(300,200) ------> componentResized()
   *                            renderGLToImage(300,200)
   *                              fbo.resize(300)
   *                              listener.display() ---------> displayLatch.countDown()
   *                                                             (latch: 1 -> 0)
   * panel.display() -------> invokeLater(r2=render300)
   *
   * awaitDisplay() &lt;----------------------------------------- unblocks (latch=0)
   * [asserts ok, FBO=300]    r2 runs later, no-op on latch
   * </pre>
   *
   * @throws InvocationTargetException if the AWT barrier in {@code resetLatches()} fails
   */
  @Test
  public void whenPanelIsResized_ThenFBOIsResized() throws InterruptedException, InvocationTargetException {
    //System.err.println("!!\n\tFLAKKY TEST WARNING : may fail because of race condition before asserts");
    
    BlockingGLListener glGate = new BlockingGLListener();
    
    
    
    int WIDTH = 100;
    int HEIGHT = 100;

    // Given an initialized panel
    PanamaGLFactory factory = PanamaGLFactory.select();
    
    System.out.println("FACTORY  " + factory);
    
    GLCanvasSwing panel = new GLCanvasSwing(factory);
    panel.setGLEventListener(glGate);

    // When panel is added
    panel.addNotify();
    
    // Let AWT or macOS main thread to perform initialization
    glGate.awaitInit();
    
    // Then it is initialized
    Assert.assertTrue(panel.isInitialized());

    // -------------------------------
    // When panel is resized
    
    panel.setSize(WIDTH, HEIGHT);
    panel.display();

    // Wait for the event to dispatch
    glGate.awaitDisplay();

    // Then FBO is resized as well
    Assert.assertEquals(WIDTH, panel.getFBO().getWidth());
    Assert.assertEquals(HEIGHT, panel.getFBO().getHeight());

    // -------------------------------
    // When panel is resized again
    glGate.resetLatches();
    
    panel.setSize(3 * WIDTH, 2 * HEIGHT);
    panel.display();

    // Wait for the event to dispatch
    glGate.awaitDisplay();

    // Then FBO is resized as well
    Assert.assertEquals(3 * WIDTH, panel.getFBO().getWidth());
    Assert.assertEquals(2 * HEIGHT, panel.getFBO().getHeight());

  }
  
  /**
   * This listener is used for tests where the unit test threads invokes
   * a GUI component methods that triggers init(), display(), resize(), dispose() 
   * that happens in the AWT thread, hence in a different thread than the calling thread. 
   */
  class BlockingGLListener implements GLEventListener{
    CountDownLatch initLatch = new CountDownLatch(1);
    CountDownLatch displayLatch = new CountDownLatch(1);
    CountDownLatch disposeLatch = new CountDownLatch(1);
    
    EventCounter counter = new EventCounter();


    public void resetLatches() throws InvocationTargetException, InterruptedException {
      // Drain all pending AWT tasks before swapping latches.
      // Any stale render still in the EventQueue will run now and countDown
      // the *old* latches (already at 0, no-op), not the new ones.
      if (!EventQueue.isDispatchThread()) {
        EventQueue.invokeAndWait(() -> {});
      }
      initLatch = new CountDownLatch(1);
      displayLatch = new CountDownLatch(1);
      disposeLatch = new CountDownLatch(1);
    }
    
    public void awaitInit() throws InterruptedException {
      initLatch.await();
    }

    public void awaitDisplay() throws InterruptedException {
      displayLatch.await();
    }

    public void awaitDispose() throws InterruptedException {
      disposeLatch.await();
    }

    public EventCounter getCounter() {
      return counter;
    }

    @Override
    public void init(GL gl) {
      initLatch.countDown();
      counter.init++;
    }

    @Override
    public void display(GL gl) {
      displayLatch.countDown();
      counter.display++;
    }

    @Override
    public void reshape(GL gl, int x, int y, int width, int height) {
      counter.reshape++;
    }

    @Override
    public void dispose(GL gl) {
      disposeLatch.countDown();
      counter.dispose++;
    }
  }
  
  protected class EventCounter {
    volatile int init = 0;
    volatile int display = 0;
    volatile int reshape = 0;
    volatile int dispose = 0;
  }

    
  

 @Ignore("Not working in CLI yet (hanging, despite using surefire unlimited threads)")
  @Test
  public void whenPanelIsRendering_DisplayWillDoNothing() throws InterruptedException {
    // ThreadUtils.print();

    AtomicInteger renderCounter = new AtomicInteger();

    // Duration of freezing task
    int FREEZE_TASK_MS = 5000;

    int WAIT_FOR_DISPLAY_DISPATCH_MS = 500;

    TicToc t = new TicToc();

    PanamaGLFactory factory = PanamaGLFactory.select();

    System.out.println("FACTORY : " + factory);


    // ----------------------------------------------------------
    // Given an initialized panel with a test offscreen renderer
    // performing a long task

    OffscreenRenderer renderer = new OffscreenRenderer_macOS(factory, new FBOReader_AWT()) {

      // Customize rendering task so that it is very very long
      @Override
      protected Runnable getTask_renderGLToImage(GLCanvas drawable, GLEventListener listener,
          int width, int height) {
        return new Runnable() {
          @Override
          public void run() {

            renderCounter.incrementAndGet();

            System.out
                .println("Start freezing render for test - count = " + renderCounter.get());
            try {
              Thread.sleep(FREEZE_TASK_MS);
            } catch (InterruptedException e) {
              e.printStackTrace();
            }

            System.out.println("Done freezing render for test");

            t.tocShow("Elasped for counter " + renderCounter.get());

          }
        };
      }
    };


    GLCanvasSwing panel = new GLCanvasSwing(factory);
    panel.setOffscreenRenderer(renderer);

    // -------------------------------
    // When it is added
    panel.addNotify();

    // Then it is considered initialized but never
    // rendered yet
    Assert.assertTrue(panel.isInitialized());
    Assert.assertFalse(panel.isRendering());
    Assert.assertTrue(renderCounter.get() == 0);

    t.tic();

    // -------------------------------
    // When display() is invoked a first time

    panel.display();

    Assert.assertTrue(panel.isRendering());

    // wait few ms that the task is triggered to macos main thread
    Thread.sleep(WAIT_FOR_DISPLAY_DISPATCH_MS);
    System.out.println("Waited " + WAIT_FOR_DISPLAY_DISPATCH_MS + " ms");

    // the freezing task has started and increments its counter
    Assert.assertTrue(renderCounter.get() == 1);

    ThreadUtils.print();

    // -------------------------------
    // When display() is invoked again

    int N_DISPLAY_ATTEMPTS = 100;
    for (int i = 0; i < N_DISPLAY_ATTEMPTS; i++) {
      panel.display();
    }

    System.out.println("Tried to display " + N_DISPLAY_ATTEMPTS + " times");

    // wait few ms that the task is triggered to macos main thread
    Thread.sleep(WAIT_FOR_DISPLAY_DISPATCH_MS);
    System.out.println("Waited " + WAIT_FOR_DISPLAY_DISPATCH_MS + " ms");


    // Then : did not trigger any new display
    Assert.assertTrue(renderCounter.get() == 1);

    System.out.println("Finished test");

  }

}
