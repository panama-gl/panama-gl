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
package panamagl;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.Assert;
import org.junit.Test;
import panamagl.canvas.GLCanvas;

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
    //float dist = Math.abs(expectedLoops-a.getLoops());
    //System.out.println(dist + " to " + expectedLoops);
    int margin = 5;
    Assert.assertTrue(a.getLoops() <= (expectedLoops+margin));
    Assert.assertTrue(a.getLoops() >= (expectedLoops-margin));
    
    
  }
}
