package panamagl.offscreen;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.Test;
import junit.framework.Assert;
import panamagl.GLEventListener;
import panamagl.canvas.GLCanvas;
import panamagl.factory.PanamaGLFactory;
import panamagl.opengl.GL;
import panamagl.opengl.GLContext;

public class TestAOffscreenRenderer {
  static int WAIT_AWT_EVENT_MS = 100;
  
  @Test
  public void whenRendererInvoked_thenGLListenerInvoked() throws InterruptedException {
    // Mocks
    FBO fbo = mock(FBO.class);
    
    PanamaGLFactory factory = mock(PanamaGLFactory.class);
    when(factory.newGL()).thenReturn(mock(GL.class));
    when(factory.newGLContext()).thenReturn(mock(GLContext.class));
    when(factory.newOffscreenRenderer(any())).thenReturn(mock(OffscreenRenderer.class));
    when(factory.newFBO(anyInt(), anyInt())).thenReturn(fbo);
    
    FBOReader reader = mock(FBOReader.class);
    GLCanvas canvas = mock(GLCanvas.class);
    
    GLEventListener listener = mock(GLEventListener.class);
    
    
    // -------------------------------------------
    // -------------------------------------------
    // Given

    AOffscreenRenderer renderer = new AOffscreenRenderer(factory, reader);

    // -------------------------------------------
    // Check precondition
    verify(fbo, times(0)).prepare(any());
    Assert.assertNull(renderer.getContext());
    Assert.assertFalse(renderer.isInitialized());
    
    // When
    renderer.onInit(canvas, listener);
    
    // Then, after AWT receives the event
    Thread.sleep(WAIT_AWT_EVENT_MS);
    
    verify(listener, times(1)).init(any()); // INIT WAS CALLED
    verify(fbo, times(1)).prepare(any());
    
    Assert.assertNotNull(renderer.getContext());
    Assert.assertTrue(renderer.isInitialized());

    // -------------------------------------------
    // Check precondition
    verify(fbo, times(1)).prepare(any());
    verify(canvas, times(0)).setScreenshot(any());
    verify(canvas, times(0)).repaint();
    
    // When
    renderer.onDisplay(canvas, listener);
    
    // Then, after AWT receives the event
    Thread.sleep(WAIT_AWT_EVENT_MS);
    
    verify(listener, times(1)).display(any()); // DISPLAY WAS CALLED
    verify(fbo, times(2)).prepare(any());
    verify(canvas, times(1)).setScreenshot(any());
    verify(canvas, times(1)).repaint();


    // -------------------------------------------
    // Check precondition
    
    // hack on AOffscreenRenderer.onDisplay
    verify(fbo, times(1)).release(any());
    verify(fbo, times(1)).resize(anyInt(), anyInt());

    //verify(fbo, times(0)).release(any());
    //verify(fbo, times(0)).resize(anyInt(), anyInt());
    verify(fbo, times(2)).prepare(any());
    verify(canvas, times(1)).setScreenshot(any());
    verify(canvas, times(1)).repaint();

    // When resize
    renderer.onResize(canvas, listener, 0, 0, 800, 600);
    
    // Then, after AWT receives the event
    Thread.sleep(WAIT_AWT_EVENT_MS);
    
    verify(listener, times(2)).display(any()); // DISPLAY WAS CALLED
    verify(listener, times(2)).reshape(any(), anyInt(), anyInt(), anyInt(), anyInt()); // RESIZE WAS CALLED
    verify(fbo, times(2)).release(any());
    verify(fbo, times(2)).resize(anyInt(), anyInt());
    
    //verify(listener, times(1)).reshape(any(), anyInt(), anyInt(), anyInt(), anyInt()); // RESIZE WAS CALLED
    //verify(fbo, times(1)).release(any());
    //verify(fbo, times(1)).resize(anyInt(), anyInt());
    verify(fbo, times(3)).prepare(any());
    verify(canvas, times(2)).setScreenshot(any());
    verify(canvas, times(2)).repaint();

    // -------------------------------------------
    // Check precondition
    verify(factory, times(0)).destroyContext();
    Assert.assertTrue(renderer.isInitialized());

    // When dispose
    renderer.onDestroy(canvas, listener);
    
    // Then, after AWT receives the event
    Thread.sleep(WAIT_AWT_EVENT_MS);
    
    verify(listener, times(1)).dispose(any()); // DISPOSE WAS CALLED
    verify(factory, times(1)).destroyContext(); 
    
    Assert.assertFalse(renderer.isInitialized());

  }
}
