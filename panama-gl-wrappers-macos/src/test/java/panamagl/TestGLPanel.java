package panamagl;

import java.util.concurrent.atomic.AtomicInteger;
import org.junit.Ignore;
import org.junit.Test;
import junit.framework.Assert;
import opengl.GL;

//VM ARGS : --enable-native-access=ALL-UNNAMED --add-modules jdk.incubator.foreign -Djava.library.path=.:/System/Library/Frameworks/OpenGL.framework/Versions/Current/Libraries/
public class TestGLPanel {
  public static int WAIT_FOR_RENDER_DISPATCHED_MS = 200;
  
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
    Thread.sleep(WAIT_FOR_RENDER_DISPATCHED_MS);
    
    // Then : should trigger glEventListener.display() and reshape()
    Assert.assertTrue(0 < event.initCounter);
    Assert.assertTrue(0 < event.displayCounter);
    Assert.assertTrue(0 < event.reshapeCounter);
    
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
    
    // Wait for the event to dispatch
    Thread.sleep(WAIT_FOR_RENDER_DISPATCHED_MS);

    // Then FBO is resized as well
    Assert.assertEquals(WIDTH, panel.getFBO().getWidth());
    Assert.assertEquals(HEIGHT, panel.getFBO().getHeight());
    
    // -------------------------------
    // When panel is resized again
    
    panel.setSize(3*WIDTH, 2*HEIGHT);
    panel.display();
    
    // Wait for the event to dispatch
    Thread.sleep(WAIT_FOR_RENDER_DISPATCHED_MS);

    // Then FBO is resized as well
    Assert.assertEquals(3*WIDTH, panel.getFBO().getWidth());
    Assert.assertEquals(2*HEIGHT, panel.getFBO().getHeight());


  }
  
 @Ignore("Not working in CLI yet")
  @Test
  public void whenPanelIsRendering_DisplayWillDoNothing() throws InterruptedException {
    
    AtomicInteger countRenderQueries = new AtomicInteger();
    
    // Duration of freezing task
    int FREEZE_TASK_MS = 5000;
    
    TicToc t = new TicToc();
    
    // Given an initialized panel
    GLPanel panel = new GLPanel() {
      
      // Customize rendering task so that it is very very long
      protected Runnable getTask_renderGLToImage(int width, int height) {
        return new Runnable() {
          @Override
          public void run() {
            //renderGLToImage(width, height);
            
            countRenderQueries.incrementAndGet();
            
            System.out.println("Start freezing render for test - count = " + countRenderQueries.get());
            try {
              Thread.sleep(FREEZE_TASK_MS);
            } catch (InterruptedException e) {
              e.printStackTrace();
            }
            
            System.out.println("Done freezing render for test");
            
            t.tocShow("Elasped for counter " + countRenderQueries.get());

          }
        };
      }

    };
    
    panel.addNotify();

    Assert.assertTrue(panel.isInitialized());
    
    //RenderCounter counter = panel.getMonitoring();

    Assert.assertFalse(panel.isRendering());
    Assert.assertTrue (countRenderQueries.get()==0);
    
    t.tic();

    // -------------------------------
    // When display() is invoked a first time
    
    panel.display();
    
    Assert.assertTrue(panel.isRendering());
    
    // wait few ms that the task is triggered to macos main thread
    Thread.sleep(500);
    
    // the freezing task has started and increments its counter
    Assert.assertTrue (countRenderQueries.get()==1);

    
    // -------------------------------
    // When display() is invoked again
    
    panel.display();
    
    // wait few ms that the task is triggered to macos main thread
    Thread.sleep(500);

    // do not trigger a new display
    Assert.assertTrue (countRenderQueries.get()==1);
    
    System.out.println("Finished test");

  }
  
}
