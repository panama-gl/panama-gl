package panamagl.offscreen;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.util.concurrent.atomic.AtomicBoolean;
import org.junit.Assert;
import org.junit.Test;
import panamagl.GLCanvas;
import panamagl.GLEventAdapter;
import panamagl.GLEventListener;
import panamagl.factory.PanamaGLFactory;
import panamagl.offscreen.AOffscreenRenderer;
import panamagl.offscreen.FBO;
import panamagl.opengl.GL;
import panamagl.opengl.GLContext;

public class TestAOffscreenRenderer {
  @Test
  public void init() {
    PanamaGLFactory p = mock(PanamaGLFactory.class);
    
    // Given
    AOffscreenRenderer r = new AOffscreenRenderer(p);
    
    // When
    when(p.newFBO(anyInt(), anyInt())).thenReturn(mock(FBO.class));
    when(p.newGL()).thenReturn(mock(GL.class));
    when(p.newGLContext()).thenReturn(mock(GLContext.class));
    when(p.newOffscreenRenderer()).thenReturn(r);
    
    AtomicBoolean listenerInit = new AtomicBoolean(false);
    GLEventAdapter listener = new GLEventAdapter() {
      public void init(GL gl) {
        listenerInit.set(true);
      }
    };
    
    r.initContext(listener);
    
    // Then
    Assert.assertNotNull(r.getGL());
    Assert.assertNotNull(r.getContext());
    Assert.assertNotNull(r.getFBO());
    //Assert.assertNotNull(r.getContext().getProfile());
    
    // Could verify FBO was prepared
    
    Assert.assertTrue(listenerInit.get());
    
    Assert.assertTrue(r.isInitialized());
  }
}
