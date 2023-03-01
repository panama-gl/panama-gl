/*
 * Copyright (c) 2010-2014, Martin Pernollet All rights reserved.
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


import java.util.List;
import org.jzy3d.analysis.AWTAbstractAnalysis;
import org.jzy3d.analysis.AnalysisLauncher;
import org.jzy3d.analysis.IAnalysis;
import org.jzy3d.chart.controllers.mouse.picking.IMousePickingController;
import org.jzy3d.chart.controllers.mouse.picking.IObjectPickedListener;
import org.jzy3d.chart.controllers.mouse.picking.PickingSupport;
import org.jzy3d.chart.factories.AWTChartFactory;
import org.jzy3d.chart.factories.ChartFactory;
import org.jzy3d.chart.factories.PanamaGLChartFactory;
import org.jzy3d.colors.Color;
import org.jzy3d.maths.graphs.IGraph;
import org.jzy3d.maths.graphs.StringGraphGenerator;
import org.jzy3d.plot3d.primitives.graphs.impl.PointGraph2d;
import org.jzy3d.plot3d.primitives.graphs.layout.DefaultGraphFormatter;
import org.jzy3d.plot3d.primitives.graphs.layout.IGraphFormatter;
import org.jzy3d.plot3d.primitives.graphs.layout.IGraphLayout2d;
import org.jzy3d.plot3d.rendering.canvas.Quality;
import org.jzy3d.plot3d.rendering.view.modes.ViewPositionMode;



public class PickableGraphDemo_PanamaGL extends AWTAbstractAnalysis {
  public static int NODES = 500;
  public static int EDGES = 100;
  public static float GL_LAYOUT_SIZE = 10;
  public static float VERTEX_WIDTH = 10;

  public static void main(String[] args) throws Exception {
    IAnalysis demo = new PickableGraphDemo_PanamaGL();
    AnalysisLauncher.openStatic(demo);
  }

  @Override
  public void init() {
    // Init graph
    IGraph<String, String> graph = StringGraphGenerator.getGraph(NODES, EDGES);
    IGraphLayout2d<String> layout = StringGraphGenerator.getRandomLayout(graph, GL_LAYOUT_SIZE);
    IGraphFormatter<String, String> formatter = new DefaultGraphFormatter<String, String>();
    formatter.setVertexColor(new Color(0, 64 / 255f, 84 / 255f));
    formatter.setVertexLabelColor(new Color(0, 64 / 255f, 84 / 255f));
    formatter.setEdgeColor(new Color(0, 64 / 255f, 84 / 255f));
    formatter.setHighlightedVertexColor(new Color(247 / 255f, 79 / 255f, 119 / 255f));

    // Setup a chart
    Quality quality = Quality.Advanced();
    quality.setPreserveViewportSize(true);
    // quality.setDepthActivated(false);

    ChartFactory factory = new PanamaGLChartFactory();
    chart = factory.newChart(quality);
    chart.getView().setAxisDisplayed(false);
    chart.getView().setViewPositionMode(ViewPositionMode.TOP);
    chart.getView().setSquared(false);
    // chart.getView().setMaximized(true);

    // Build a drawable graph
    final PointGraph2d<String, String> dGraph = new PointGraph2d<String, String>();

    IMousePickingController mouse = chart.addMousePickingController((int) VERTEX_WIDTH);
    mouse.getPickingSupport().addObjectPickedListener(new IObjectPickedListener() {
      @Override
      public void objectPicked(List<? extends Object> vertices, PickingSupport picking) {
        for (Object vertex : vertices) {
          System.out.println("picked: " + vertex);
          dGraph.setVertexHighlighted((String) vertex, true);
        }
        chart.render();
      }
    });

    dGraph.setGraphModel(graph, mouse.getPickingSupport());
    // dGraph.setGraphModel(graph);
    dGraph.setGraphFormatter(formatter);
    dGraph.setGraphLayout(layout);

    chart.getScene().getGraph().add(dGraph);
  }

}