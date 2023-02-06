package org.jzy3d.plot3d.rendering.canvas.embedded;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.Test;
import org.jzy3d.chart.factories.PanamaGLChartFactory;
import org.jzy3d.chart.factories.embedded.EmbeddedPanamaGLPainterFactory;
import org.jzy3d.plot3d.rendering.canvas.Quality;
import panamagl.canvas.GLCanvasSwing;
import panamagl.factory.PanamaGLFactory;
import panamagl.offscreen.AOffscreenRenderer;
import panamagl.offscreen.FBO;
import panamagl.opengl.GL;
import panamagl.opengl.GLContext;

public class TestEmbeddedPanamaGLCanvas {
  @Test
  public void forceRepaint() {
    
    // Mock panamaGL factory
    PanamaGLFactory f = mock(PanamaGLFactory.class);
    when(f.newOffscreenRenderer()).thenReturn(new AOffscreenRenderer(f));
    when(f.newGL()).thenReturn(mock(GL.class));
    when(f.newGLContext()).thenReturn(mock(GLContext.class));
    when(f.newFBO(anyInt(),anyInt())).thenReturn(mock(FBO.class));
    
    // Add this mock factory to the chart painter factory
    PanamaGLChartFactory factory = new PanamaGLChartFactory();
    EmbeddedPanamaGLPainterFactory p = (EmbeddedPanamaGLPainterFactory)factory.getPainterFactory();
    p.setPanamaGLFactory(f);


    // Spy the component on which we will perform tests
    GLCanvasSwing glCanvas = spy(GLCanvasSwing.class);
    glCanvas.setOffscreenRenderer(f.newOffscreenRenderer());
    
    // Given
    EmbeddedPanamaGLCanvas c = new EmbeddedPanamaGLCanvas(factory, factory.newScene(false), Quality.Advanced(), glCanvas);
    
    // Then
    verify(glCanvas, times(0)).display();
    
    // When
    c.forceRepaint();// check invoke GLCanvas.update and 
    
    // Then
    verify(glCanvas, times(1)).display();
  }
}
