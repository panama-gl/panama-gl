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
package panamagl.canvas.overlay;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import panamagl.canvas.GLCanvas;
import panamagl.performance.RenderCounter;

public class PerformanceOverlay_JFX implements Overlay{
  protected GLCanvas drawable;
  protected RenderCounter counter;
  protected PerfOverlay perfOverlay = new PerfOverlay();
  
  protected class PerfOverlay {
    protected int interline = 20;
    protected int x = 10;
    protected int yPaintInterval = x;
    protected int yRenderTimeInterval = yPaintInterval + interline;
    protected int yIntervalDiff = yRenderTimeInterval + interline;
    protected int yCountCoalesced = yIntervalDiff + interline;
  }

  
  public PerformanceOverlay_JFX(GLCanvas drawable) {
    super();
    this.drawable = drawable;
    this.counter = drawable.getMonitoring();
  }



  @Override
  public void paint(GraphicsContext g) {
    // Overlay performance info
    g.setFill(Color.GRAY);
    
    // -------------------------------------------------
    // Interval between rendering query and repaint achieved. The real rendering time during which
    // OpenGL worked.

    // int renderTimeMs = counter.renderTimeMs();
    
    g.fillText(counter.renderTimeMsInfo(), perfOverlay.x,
        drawable.getHeight() - perfOverlay.yRenderTimeInterval);

    // -------------------------------------------------
    // Interval between two repaint, which show how we stress the AWT Event Queue
    // https://github.com/jzy3d/jzy3d-api/tree/master/jzy3d-emul-gl-awt#integrating-in-awt

    // Highlight render time longer than paint interval
    if (counter.renderLongerThanRepaintInterval())
      g.setFill(Color.ORANGE);

    g.fillText(counter.paintIntervalMsInfo(), perfOverlay.x,
        drawable.getHeight() - perfOverlay.yPaintInterval);

    g.fillText(counter.paintIntervalVsRenderTimeDiffInfo(), perfOverlay.x,
        drawable.getHeight() - perfOverlay.yIntervalDiff);

    // -------------------------------------------------
    // Count coalesced events.

    // FIXME : should not appear in the info display method
    counter.onStartPainting();

    // Update diff computations
    counter.update();

    // Highlight when count display vs paint differ
    if (counter.diffChanged()) {
      g.setFill(Color.ORANGE);
    } else {
      g.setFill(Color.GRAY);
    }

    g.fillText(counter.eventCountInfo(), perfOverlay.x,
        drawable.getHeight() - perfOverlay.yCountCoalesced);

  }
}
