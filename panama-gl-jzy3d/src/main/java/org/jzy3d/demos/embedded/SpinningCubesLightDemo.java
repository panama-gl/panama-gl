package org.jzy3d.demos.embedded;

import java.util.List;
import org.jzy3d.chart.Chart;
import org.jzy3d.chart.factories.AWTChartFactory;
import org.jzy3d.chart.factories.ChartFactory;
import org.jzy3d.colors.Color;
import org.jzy3d.plot3d.primitives.Composite;
import org.jzy3d.plot3d.primitives.Geometry;
import org.jzy3d.plot3d.primitives.RandomGeom;
import org.jzy3d.plot3d.rendering.canvas.Quality;
import org.jzy3d.plot3d.rendering.view.HiDPI;

public class SpinningCubesLightDemo {
  
  
  public static void main(String[] args) throws Exception {
    Quality q = Quality.Intermediate();
    q.setHiDPI(HiDPI.ON);
    q.setAlphaActivated(false); 
    
    RandomGeom r = new RandomGeom();
    List<Composite> drawables = r.spinningCubes(4, 45, 0.08f);
    
    for(Composite c: drawables) {
      c.setReflectLight(true);
      c.setColor(Color.ORANGE);
    }

    ChartFactory factory = new AWTChartFactory();
    //ChartFactory factory = new PanamaGLChartFactory();
    Chart chart = factory.newChart(q);
    chart.add(drawables);
    chart.addMouse();
    chart.addLightOnCamera();
    chart.getView().setAxisDisplayed(false);
    //chart.getView().setViewPositionMode(ViewPositionMode.PROFILE);
    Geometry.SHOW_NORMALS = false;
    
    
    chart.open();
    
    
  }
}