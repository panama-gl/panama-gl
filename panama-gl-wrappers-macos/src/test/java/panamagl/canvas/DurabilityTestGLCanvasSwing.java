package panamagl.canvas;

import org.junit.Ignore;
import org.junit.Test;
import org.jzy3d.os.OperatingSystem;
import junit.framework.Assert;
import opengl.GL;
import panamagl.GLEventAdapter;
import panamagl.factory.AbstractPanamaGLFactory;
import panamagl.macos.PanamaGLMacOSFactory;

@Ignore("Will add to specific build profile later.")
public class DurabilityTestGLCanvasSwing {
  public static int WAIT_FOR_RENDER_DISPATCHED_MS = 200;

  @Test
  public void whenPanelIsAdded_ThenGLEventListenerIsInvoked() throws InterruptedException {
    if (!new OperatingSystem().isMac())
      return;
    
    // ------------------------------------------------
    // Given a panel with an event counter
    
    EventCounter event = new EventCounter();
    
    AbstractPanamaGLFactory factory = new PanamaGLMacOSFactory();
    GLCanvasSwing panel = (GLCanvasSwing)factory.newCanvas(GLCanvasSwing.class);
    
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
    
    Thread.yield();
    
    // Then : should trigger glEventListener.init()
    Assert.assertEquals(1, event.initCounter);
    Assert.assertEquals(0, event.displayCounter);
    Assert.assertEquals(0, event.reshapeCounter);
    
    // Then context is initialized
    Assert.assertTrue(panel.getContext().isInitialized());

    // Then panel is initialized
    Assert.assertTrue(panel.isInitialized());


    
    // ------------------------------------------------
    // When : resize, and after a while
    
    int SIZE = 2000;
    int PAUSE = 80; //ms
    int DISPLAYS = 500;
    
    panel.setSize(SIZE, SIZE);
    
    for(int i=0; i<DISPLAYS; i++) {
      panel.display(); 
      // avoid flooding AWT event queue and ensure we do not 
      // have display events coallesced because of being to close
      // in time.
      Thread.sleep(PAUSE);
    }
    
    // Wait for the event to dispatch
    Thread.sleep(WAIT_FOR_RENDER_DISPATCHED_MS);
    
    // Then : should trigger glEventListener.display() and reshape()
    Assert.assertTrue(0 < event.initCounter);
    Assert.assertTrue(0 < event.displayCounter);
    Assert.assertTrue(0 < event.reshapeCounter);
    
    System.out.println(this.getClass() + " : display count : " + event.displayCounter + " (expect " + DISPLAYS + " but can be smaller due to event coallesced)");
    
    // Then : the displayed image should be available as screenshot
    Assert.assertNotNull(panel.getScreenshot());
    

    
    // ------------------------------------------------
    // When : remove from component hierarchy

    panel.removeNotify();
    
    // Then : all components are not initialized anymore
    Assert.assertFalse(panel.getContext().isInitialized());
    Assert.assertFalse(panel.isInitialized());

  }
  
  
  protected class EventCounter{
    int initCounter = 0;
    int displayCounter = 0;
    int reshapeCounter = 0;
  }
}
