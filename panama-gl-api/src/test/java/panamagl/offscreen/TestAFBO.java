package panamagl.offscreen;

import java.lang.foreign.MemorySegment;
import java.util.ArrayList;
import java.util.List;
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
      @Override
      protected void bindFramebuffer(int id) {
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

  /** An AFBO recording the prepare and bind invocations, which mimics the GPU ids. */
  class RecordingFBO extends AFBO {
    int preparations = 0;
    List<Integer> bound = new ArrayList<>();

    @Override
    public void prepare(GL gl) {
      preparations++;
      idFrameBuffer = 7;
      bindFramebuffer(idFrameBuffer);
      super.prepared = true;
    }
    @Override
    public void release(GL gl) {
    }
    @Override
    public MemorySegment readPixels(GL gl) {
      return null;
    }
    @Override
    protected void bindFramebuffer(int id) {
      bound.add(id);
    }
  }

  @Test
  public void whenBindingBeforePreparation_ThenFBOIsPreparedAndBound() {
    RecordingFBO fbo = new RecordingFBO();

    fbo.bind(null);

    Assert.assertEquals(1, fbo.preparations);
    Assert.assertEquals(List.of(7), fbo.bound);
  }

  @Test
  public void whenBindingAPreparedFBO_ThenItIsBoundWithoutBeingRecreated() {
    RecordingFBO fbo = new RecordingFBO();
    fbo.prepare(null);
    fbo.bound.clear();

    fbo.bind(null);

    Assert.assertEquals(1, fbo.preparations);
    Assert.assertEquals(List.of(7), fbo.bound);
  }

  @Test
  public void whenUnbinding_ThenDefaultFramebufferIsBound() {
    RecordingFBO fbo = new RecordingFBO();
    fbo.prepare(null);
    fbo.bound.clear();

    fbo.unbind(null);

    Assert.assertEquals(List.of(0), fbo.bound);
  }
}
