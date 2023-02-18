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
package org.jzy3d.demos.embedded;

import org.jzy3d.chart.Chart;
import org.jzy3d.chart.factories.ChartFactory;
import org.jzy3d.chart.factories.SwingChartFactory;
import org.jzy3d.colors.Color;
import org.jzy3d.colors.ColorMapper;
import org.jzy3d.colors.colormaps.ColorMapRainbow;
import org.jzy3d.maths.Range;
import org.jzy3d.plot3d.builder.Func3D;
import org.jzy3d.plot3d.builder.SurfaceBuilder;
import org.jzy3d.plot3d.builder.concrete.OrthonormalGrid;
import org.jzy3d.plot3d.primitives.Shape;
import org.jzy3d.plot3d.rendering.canvas.Quality;

/**
 * Demo an surface chart made with Panama (JEP-412).
 *
 * @author Martin Pernollet
 *
 */
//VM ARGS :  --enable-preview -Djava.library.path=.:/System/Library/Frameworks/OpenGL.framework/Versions/Current/Libraries/
// DO NOT USE -XstartOnFirstThread!!

// Making context current in MacOSXCGLContext line 1474 

public class SurfaceDemo_JOGL {
  static final float ALPHA_FACTOR = 0.75f;// .61f;

  public static void main(String[] args) {

    ChartFactory factory = new SwingChartFactory();

    Quality q = Quality.Advanced().setAnimated(false);
    Chart chart = factory.newChart(q);
    chart.add(surface());
    //chart.getView().setAxisDisplayed(false);
    
    Runnable open = new Runnable() {
      @Override
      public void run() {
        System.out.println("Before open");
        chart.open(800,600);
        System.out.println("After open");
      }
    };

    // Lock at unsafe.park
    open.run();
    
    chart.addMouse();    
  }


  private static Shape surface() {
    SurfaceBuilder builder = new SurfaceBuilder();

    Func3D func = new Func3D((x, y) -> x * Math.sin(x * y));
    Range range = new Range(-3, 3);
    int steps = 50;

    Shape surface = builder.orthonormal(new OrthonormalGrid(range, steps), func);

    ColorMapper colorMapper = new ColorMapper(new ColorMapRainbow(), surface, new Color(1, 1, 1, ALPHA_FACTOR));
    surface.setColorMapper(colorMapper);
    surface.setFaceDisplayed(true);
    surface.setWireframeDisplayed(true);
    surface.setWireframeColor(Color.BLACK);
    surface.setWireframeWidth(1);
    return surface;
  }

}
