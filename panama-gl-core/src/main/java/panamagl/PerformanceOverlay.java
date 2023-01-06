package panamagl;

import java.awt.Color;
import java.awt.Graphics;

public class PerformanceOverlay implements Overlay{
  protected GLAutoDrawable drawable;
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

  
  public PerformanceOverlay(GLAutoDrawable drawable) {
    super();
    this.drawable = drawable;
    this.counter = drawable.getMonitoring();
  }



  @Override
  public void paint(Graphics g) {
    // Overlay performance info
    g.setColor(Color.GRAY);

    // -------------------------------------------------
    // Interval between rendering query and repaint achieved. The real rendering time during which
    // OpenGL worked.

    // int renderTimeMs = counter.renderTimeMs();

    g.drawString(counter.renderTimeMsInfo(), perfOverlay.x,
        drawable.getHeight() - perfOverlay.yRenderTimeInterval);

    // -------------------------------------------------
    // Interval between two repaint, which show how we stress the AWT Event Queue
    // https://github.com/jzy3d/jzy3d-api/tree/master/jzy3d-emul-gl-awt#integrating-in-awt

    // Highlight render time longer than paint interval
    if (counter.renderLongerThanRepaintInterval())
      g.setColor(Color.ORANGE);

    g.drawString(counter.paintIntervalMsInfo(), perfOverlay.x,
        drawable.getHeight() - perfOverlay.yPaintInterval);

    g.drawString(counter.paintIntervalVsRenderTimeDiffInfo(), perfOverlay.x,
        drawable.getHeight() - perfOverlay.yIntervalDiff);

    // -------------------------------------------------
    // Count coalesced events.

    // FIXME : should not appear in the info display method
    counter.onStartPainting();

    // Update diff computations
    counter.update();

    // Highlight when count display vs paint differ
    if (counter.diffChanged()) {
      g.setColor(Color.ORANGE);
    } else {
      g.setColor(Color.GRAY);
    }

    g.drawString(counter.eventCountInfo(), perfOverlay.x,
        drawable.getHeight() - perfOverlay.yCountCoalesced);

  }
}
