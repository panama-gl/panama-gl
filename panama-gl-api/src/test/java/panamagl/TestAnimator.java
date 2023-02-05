package panamagl;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.Assert;
import org.junit.Test;

public class TestAnimator {
  @Test
  public void animator() throws InterruptedException {
    
    GLCanvas canvas=  mock(GLCanvas.class);//new GLCanvasSwing(p);
    
    when(canvas.isVisible()).thenReturn(true);
    
    float DURATION = 1000.0f;
    
    Animator a= new Animator(canvas);
    a.setSleepTime(Animator.RETINAL_PERSISTENCE); // 40ms
    
    Assert.assertTrue(a.getLoops() == 0);
    a.start();
    Thread.sleep((int)DURATION);
    a.stop();
    
    // Verify number of image per second is relevant
    float expectedLoops = DURATION/Animator.RETINAL_PERSISTENCE;
    float dist = Math.abs(expectedLoops-a.getLoops());
    //System.out.println(dist + " to " + expectedLoops);
    int margin = 5;
    Assert.assertTrue(a.getLoops() <= (expectedLoops+margin));
    Assert.assertTrue(a.getLoops() >= (expectedLoops-margin));
    
    
  }
}
