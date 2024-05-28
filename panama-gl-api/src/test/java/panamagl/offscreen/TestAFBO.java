package panamagl.offscreen;

import java.lang.foreign.MemorySegment;
import org.junit.Test;
import junit.framework.Assert;
import panamagl.opengl.GL;

public class TestAFBO {
  @Test
  public void whenPrepareRelease() {
    
    // Given an abstract FBO with dummy implementation
    AFBO afbo = new AFBO() {
      @Override
      public void prepare(GL gl) {
      }
      @Override
      public void release(GL gl) {
      }
      @Override
      public MemorySegment readPixels(GL gl) {
        return null;
      }
    };

    // When init
    
    // Then no arena
    Assert.assertNull(afbo.renderArena);
    
    
    // When prepare
    afbo.prepareRenderArena();
    
    // Then an arena
    Assert.assertNotNull(afbo.renderArena);

    // When prepare
    afbo.releaseRenderArena();
    
    // Then no arena
    Assert.assertNull(afbo.renderArena);
    
    // Then Everything get reset
    Assert.assertNull(afbo.textureBufferIds);
    Assert.assertNull(afbo.renderBufferIds);
    Assert.assertNull(afbo.frameBufferIds);
    Assert.assertNull(afbo.pixelBuffer);
    Assert.assertNull(afbo.pixels);

    Assert.assertEquals(afbo.idTexture, -1);
    Assert.assertEquals(afbo.idFrameBuffer, -1);
    Assert.assertEquals(afbo.idRenderBuffer, -1);

  }
}
