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
package panamagl.offscreen;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.util.concurrent.atomic.AtomicBoolean;
import org.junit.Assert;
import org.junit.Test;
import panamagl.GLCanvas;
import panamagl.GLEventAdapter;
import panamagl.factory.PanamaGLFactory;
import panamagl.opengl.GL;
import panamagl.opengl.GLContext;

public class TestAOffscreenRenderer {
  @Test
  public void init() {
    PanamaGLFactory p = mock(PanamaGLFactory.class);
    GLCanvas canvas = mock(GLCanvas.class);

    // Given
    AOffscreenRenderer r = new AOffscreenRenderer(p);

    // When
    when(p.newFBO(anyInt(), anyInt())).thenReturn(mock(FBO.class));
    when(p.newGL()).thenReturn(mock(GL.class));
    when(p.newGLContext()).thenReturn(mock(GLContext.class));
    when(p.newOffscreenRenderer()).thenReturn(r);
    
    AtomicBoolean listenerInit = new AtomicBoolean(false);
    GLEventAdapter listener = new GLEventAdapter() {
      public void init(GL gl) {
        listenerInit.set(true);
      }
    };
    
    r.initContext(canvas, listener);
    
    // Then
    Assert.assertNotNull(r.getGL());
    Assert.assertNotNull(r.getContext());
    Assert.assertNotNull(r.getFBO());
    //Assert.assertNotNull(r.getContext().getProfile());
    
    // Could verify FBO was prepared
    
    Assert.assertTrue(listenerInit.get());
    
    Assert.assertTrue(r.isInitialized());
  }
}
