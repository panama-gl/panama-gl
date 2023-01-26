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
import org.jzy3d.os.OperatingSystem;
import junit.framework.Assert;
import panamagl.GLEventAdapter;
import panamagl.factory.PanamaGLFactory;
import panamagl.opengl.GL;

/**
 * This test is intentionnaly named DurabilityTest* to be ignored by maven
 * while running tests (surefire config keeps Test* or *Test or ITTest*)
 */
//@Ignore("Will add to specific build profile later.")
public class DurabilityTestGLCanvasSwing_macOS {
  public static int WAIT_FOR_RENDER_DISPATCHED_MS = 200;

  @Test
  public void whenPanelIsAdded_ThenGLEventListenerIsInvoked() throws InterruptedException {
    if (!new OperatingSystem().isMac())
      return;
    
    // ------------------------------------------------
    // Given a panel with an event counter
    
    EventCounter event = new EventCounter();
    
    PanamaGLFactory factory = PanamaGLFactory.select();
    GLCanvasSwing panel = factory.newCanvasSwing();
    
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
