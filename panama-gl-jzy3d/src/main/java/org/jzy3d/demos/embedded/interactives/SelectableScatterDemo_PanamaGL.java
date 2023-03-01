/*
 * Copyright (c) 2010-2011, Martin Pernollet All rights reserved.
 *
 * Redistribution in binary form, with or without modification, is permitted. Edition of source
 * files is allowed. Redistribution of original or modified source files is FORBIDDEN.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR
 * IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
 * FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY,
 * WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY
 * WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.jzy3d.demos.embedded.interactives;

import java.util.Random;
import org.jzy3d.analysis.AbstractAnalysis;
import org.jzy3d.chart.Chart;
import org.jzy3d.chart.controllers.mouse.AWTDualModeMouseSelector;
import org.jzy3d.chart.controllers.mouse.selection.AWTScatterMouseSelector;
import org.jzy3d.chart.factories.ChartFactory;
import org.jzy3d.chart.factories.PanamaGLChartFactory;
import org.jzy3d.colors.Color;
import org.jzy3d.maths.Coord3d;
import org.jzy3d.plot3d.primitives.selectable.SelectableScatter;
import org.jzy3d.plot3d.rendering.canvas.Quality;


/**
 * @author Martin Pernollet
 */
public class SelectableScatterDemo_PanamaGL {
  static int POINTS = 500000;

  public static void main(String[] args) throws Exception {

    SelectableScatter scatter = generateScatter(POINTS);

    Quality q = Quality.Advanced();
    q.setPreserveViewportSize(false); // needed for working with selection on retina
    q.setAnimated(true);

    ChartFactory factory = new PanamaGLChartFactory();
    Chart chart = factory.newChart(q);
    chart.getScene().add(scatter);
    chart.getView().setMaximized(true);

    AWTScatterMouseSelector selector = new AWTScatterMouseSelector(scatter, chart);
    new AWTDualModeMouseSelector(chart, selector);
  }

  protected static SelectableScatter generateScatter(int npt) {
    Coord3d[] points = new Coord3d[npt];
    Color[] colors = new Color[npt];
    Random rng = new Random();
    rng.setSeed(0);
    for (int i = 0; i < npt; i++) {
      colors[i] = new Color(0, 64 / 255f, 84 / 255f);
      points[i] = new Coord3d(rng.nextFloat(), rng.nextFloat(), rng.nextFloat());
    }
    SelectableScatter dots = new SelectableScatter(points, colors);
    dots.setWidth(1);
    dots.setHighlightColor(Color.YELLOW);
    return dots;
  }
}