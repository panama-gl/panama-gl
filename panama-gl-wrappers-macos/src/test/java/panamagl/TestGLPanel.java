package panamagl;

import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import org.junit.Test;
import junit.framework.Assert;
import opengl.GL;
import opengl.fbo.FBO;

//VM ARGS : --enable-native-access=ALL-UNNAMED --add-modules jdk.incubator.foreign -Djava.library.path=.:/System/Library/Frameworks/OpenGL.framework/Versions/Current/Libraries/
public class TestGLPanel {
  @Test
  public void whenPanelIsAdded_ThenGLEventListenerIsInvoked() throws InterruptedException {
    
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
    
    Assert.assertFalse(panel.isInitialized());

    
    // ------------------------------------------------
    // When : GL initialization is triggered by panel addition
    // to its parent frame
    
    panel.addNotify();
    
    // Then : should trigger glEventListener.init()
    Assert.assertEquals(1, event.initCounter);
    Assert.assertEquals(0, event.displayCounter);
    Assert.assertEquals(0, event.reshapeCounter);
    
    Assert.assertTrue(panel.isInitialized());


    
    // ------------------------------------------------
    // When : resize, and after a while
    
    panel.setSize(20, 20);
    panel.display(); // not needed from IDE but from CLI
    
    Thread.sleep(1000);
    
    // Then : should trigger glEventListener.display() and reshape()
    Assert.assertTrue(0 < event.initCounter);
    Assert.assertTrue(0 < event.displayCounter);
    Assert.assertTrue(0 < event.reshapeCounter);


  }
  
  
  protected class EventCounter{
    int initCounter = 0;
    int displayCounter = 0;
    int reshapeCounter = 0;
  }
  
  
  
  @Test
  public void whenPanelIsResized_ThenFBOIsResized() throws InterruptedException {
    
    int WIDTH = 100;
    int HEIGHT= 100;

    // Given an initialized panel
    GLPanel panel = new GLPanel();
    panel.addNotify();
    Assert.assertTrue(panel.isInitialized());
    
    // -------------------------------
    // When panel is resized
    
    panel.setSize(WIDTH, HEIGHT);
    panel.display();
    
    //Thread.sleep(200);

    // Then FBO is resized as well
    Assert.assertEquals(WIDTH, panel.getFBO().getWidth());
    Assert.assertEquals(HEIGHT, panel.getFBO().getHeight());
    
    // -------------------------------
    // When panel is resized again
    
    panel.setSize(3*WIDTH, 2*HEIGHT);
    panel.display();
    
    //Thread.sleep(200);

    // Then FBO is resized as well
    Assert.assertEquals(3*WIDTH, panel.getFBO().getWidth());
    Assert.assertEquals(2*HEIGHT, panel.getFBO().getHeight());


  }
  
}
