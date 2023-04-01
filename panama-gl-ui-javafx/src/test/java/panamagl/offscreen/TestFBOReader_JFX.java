package panamagl.offscreen;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.MemorySession;
import org.junit.Assert;
import org.junit.Test;
import javafx.scene.image.WritableImage;
import panamagl.image.JFXImage;
import panamagl.opengl.GL;

public class TestFBOReader_JFX {
  MemorySession session = MemorySession.openImplicit();

  @Test
  public void read() {
    int WIDTH = 800;
    int HEIGHT = 600;
    int CHANNELS = 4;
    int nBytes = WIDTH * HEIGHT * CHANNELS;

    // Given
    MemorySegment pixels = MemorySegment.allocateNative(nBytes, session);
    

    FBO fbo = mock(FBO.class);
    when(fbo.getWidth()).thenReturn(800);
    when(fbo.getHeight()).thenReturn(600);    
    when(fbo.readPixels(any())).thenReturn(pixels);
    
    GL gl = mock(GL.class);
    
    FBOReader_JFX reader = new FBOReader_JFX();
    
    // When
    JFXImage image = reader.read(fbo, gl);
    
    // Then
    Assert.assertNotNull(image);
    
    WritableImage wi = image.getImage();
    
    Assert.assertEquals(WIDTH, wi.getWidth(), DELTA);
    Assert.assertEquals(HEIGHT, wi.getHeight(), DELTA);
    
    int argb = wi.getPixelReader().getArgb(0, 0);
    
    Assert.assertEquals(0, argb, DELTA);
    
    
    //pixels.unload();
    //session.close();
    
    
  }
  
  static double DELTA = 0.1;
}
