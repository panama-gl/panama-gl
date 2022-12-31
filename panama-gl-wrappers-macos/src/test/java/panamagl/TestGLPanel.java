package panamagl;

import org.junit.Test;
import junit.framework.Assert;
import opengl.GL;

//VM ARGS : --enable-native-access=ALL-UNNAMED --add-modules jdk.incubator.foreign -Djava.library.path=.:/System/Library/Frameworks/OpenGL.framework/Versions/Current/Libraries/
public class TestGLPanel {
  @Test
  public void listeners() throws InterruptedException {
    
    // ------------------------------------------------
    // Given a panel with an event counter
    
    EventCounter event = new EventCounter();
    
    GLPanel panel = new GLPanel();
    
    panel.setGLEventListener(new GLEventAdapter() {
      @Override
      public void init(GL gl) {
        event.initCounter++;
      }

      @Override
      public void display(GL gl) {
        event.displayCounter++;
      }

      @Override
      public void reshape(GL gl, int x, int y, int width, int height) {
        event.reshapeCounter++;
      }
    });

    
    // ------------------------------------------------
    // When : GL initialization is triggered by panel addition
    // to its parent frame
    
    panel.addNotify();
    
    // Then : should trigger glEventListener.init()
    Assert.assertEquals(1, event.initCounter);
    Assert.assertEquals(0, event.displayCounter);
    Assert.assertEquals(0, event.reshapeCounter);

    
    // ------------------------------------------------
    // When : resize, and after a while
    
    panel.setSize(20, 20);
    
    Thread.sleep(100);
    
    // Then : should trigger glEventListener.display() and reshape()
    Assert.assertEquals(1, event.initCounter);
    Assert.assertEquals(1, event.displayCounter);
    Assert.assertEquals(1, event.reshapeCounter);


  }
  
  
  protected class EventCounter{
    int initCounter = 0;
    int displayCounter = 0;
    int reshapeCounter = 0;
  }
}
