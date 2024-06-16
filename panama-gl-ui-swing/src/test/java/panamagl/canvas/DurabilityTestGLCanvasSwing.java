/*******************************************************************************
 * Copyright (c) 2022, 2023 Martin Pernollet & contributors.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301, USA
 *******************************************************************************/
package panamagl.canvas;

import org.junit.Test;
import junit.framework.Assert;
import me.tongfei.progressbar.ProgressBar;
import panamagl.GLEventAdapter;
import panamagl.factory.PanamaGLFactory;
import panamagl.opengl.GL;

/**
 * This test is intentionnaly named DurabilityTest* to be ignored by maven
 * while running tests (surefire config keeps Test* or *Test or ITTest*)
 * 
 * The goal is to run a canvas for a long time to verify potential memory leaks.
 * 
 * 
 * VM ARGS : --enable-native-access=ALL-UNNAMED -Djava.library.path=.://usr/lib/x86_64-linux-gnu/
 *
 */
public class DurabilityTestGLCanvasSwing {
  public static int WAIT_FOR_RENDER_DISPATCHED_MS = 200;
  public static int WAIT_FOR_INIT_AND_DESTROY = 1500;
  
  static int PANEL_SIZE = 2000;
  static int PAUSE_BETWEEN_DISPLAY = 80; //ms
  static int NUMBER_OF_DISPLAYS = 10000;

  @Test
  public void whenPanelIsAdded_ThenGLEventListenerIsInvoked() throws InterruptedException {
    PanamaGLFactory factory = PanamaGLFactory.select();
    
    whenPanelIsAdded_ThenGLEventListenerIsInvoked(factory);
  }


  public static void whenPanelIsAdded_ThenGLEventListenerIsInvoked(PanamaGLFactory factory) throws InterruptedException {
    
    // ------------------------------------------------
    // Given a panel with an event counter
    
    EventCounter event = new EventCounter();
    
    GLCanvasSwing panel = new GLCanvasSwing(factory);
    
    panel.setGLEventListener(new GLEventAdapter() {
      @Override
      public void init(GL gl) {
        event.initCounter++;
        System.out.println("DurabilityTestGLCanvasSwing : init callback get called (to let test work ???!!!)");
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
    
    // Let AWT or macOS main thread to perform initialization
    Thread.yield();
    Thread.sleep(WAIT_FOR_INIT_AND_DESTROY); // TODO : find a better way

    // Then : should trigger glEventListener.init()
    Assert.assertEquals(1, event.initCounter); // FIXME : flacky
    Assert.assertEquals(0, event.displayCounter);
    Assert.assertEquals(0, event.reshapeCounter);
    
    // Then context is initialized
    Assert.assertTrue(panel.getContext().isInitialized());

    // Then panel is initialized
    Assert.assertTrue(panel.isInitialized());


    
    // ------------------------------------------------
    // When : resize, and after a while
    
    
    panel.setSize(PANEL_SIZE, PANEL_SIZE);
    
    System.out.println("Will render " + NUMBER_OF_DISPLAYS + " times every " + PAUSE_BETWEEN_DISPLAY + " ms which last " + ((PAUSE_BETWEEN_DISPLAY*NUMBER_OF_DISPLAYS)/1000) + "s");
    
    ProgressBar progressBar = new ProgressBar("DurabilityTestGLCanvasSwing", NUMBER_OF_DISPLAYS);
    
   
    for(int i=0; i<NUMBER_OF_DISPLAYS; i++) {
      panel.display(); 
      progressBar.step();
      
      // avoid flooding AWT event queue and ensure we do not 
      // have display events coallesced because of being to close
      // in time.
      Thread.sleep(PAUSE_BETWEEN_DISPLAY);
    }
    progressBar.close();
    
    // Wait for the event to dispatch
    Thread.sleep(WAIT_FOR_RENDER_DISPATCHED_MS);
    
    // Then : should trigger glEventListener.display() and reshape()
    Assert.assertTrue(0 < event.initCounter);
    Assert.assertTrue(0 < event.displayCounter);
    Assert.assertTrue(0 < event.reshapeCounter);
    
    System.out.println("DurabilityTestGLCanvasSwing : display count : " + event.displayCounter + " (expect " + NUMBER_OF_DISPLAYS + " but can be smaller due to event coallesced)");
    
    // Then : the displayed image should be available as screenshot
    Assert.assertNotNull(panel.getScreenshot());
    

    
    // ------------------------------------------------
    // When : remove from component hierarchy

    panel.removeNotify();
    
    // Let AWT or macOS main thread to perform initialization
    Thread.sleep(WAIT_FOR_INIT_AND_DESTROY);
    
    // Then : all components are not initialized anymore
    Assert.assertFalse(panel.getContext().isInitialized());
    Assert.assertFalse(panel.isInitialized());

  }
  
  
  protected static class EventCounter{
    int initCounter = 0;
    int displayCounter = 0;
    int reshapeCounter = 0;
  }
}
