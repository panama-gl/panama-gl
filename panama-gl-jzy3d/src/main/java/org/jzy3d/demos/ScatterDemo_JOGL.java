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
package org.jzy3d.demos;

import java.util.Random;
import org.jzy3d.chart.Chart;
import org.jzy3d.chart.factories.ChartFactory;
import org.jzy3d.chart.factories.SwingChartFactory;
import org.jzy3d.colors.Color;
import org.jzy3d.maths.Coord3d;
import org.jzy3d.plot3d.primitives.Scatter;
import org.jzy3d.plot3d.rendering.canvas.Quality;

/**
 * Demo an scatter chart with JOGL.
 *
 * @author Martin Pernollet
 *
 */
public class ScatterDemo_JOGL {
  static final float ALPHA_FACTOR = 0.25f;// .61f;

  public static void main(String[] args) {

    ChartFactory factory = new SwingChartFactory();

    //ChartFactory factory = new SwingChartFacto

    Quality q = Quality.Advanced().setAnimated(false);
    Chart chart = factory.newChart(q);
    chart.add(scatter());
    
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

  private static Scatter scatter() {
    int size = 500000;
    float x;
    float y;
    float z;
    float a;

    Coord3d[] points = new Coord3d[size];
    Color[] colors = new Color[size];

    Random r = new Random();
    r.setSeed(0);

    for (int i = 0; i < size; i++) {
      x = r.nextFloat() - 0.5f;
      y = r.nextFloat() - 0.5f;
      z = r.nextFloat() - 0.5f;
      points[i] = new Coord3d(x, y, z);
      a = ALPHA_FACTOR;
      colors[i] = new Color(x, y, z, a);
    }

    return new Scatter(points, colors);
  }

}
