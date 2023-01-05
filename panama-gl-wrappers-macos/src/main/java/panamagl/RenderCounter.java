package panamagl;

public class RenderCounter {
  protected int update = 0;
  protected int paint = 0;
  protected int display = 0;
  protected int diff = 0;
  protected int prevDiff = 0;
  protected int renderDrift = 0;
  protected int prevRenderDrift = 0;

  /**
   * Should starts upon invocation of display() or receival of resize events, stop once
   * paintComponent() has completed image rendering.
   */
  protected TicToc renderTimer = new TicToc();

  /** Measure time between each repaint query. */
  protected TicToc paintInterval = new TicToc();

  // ** MONITORING ********************** //

  public void onPaintComponentBefore() {
    renderTimer.toc();
    paintInterval.toc();
  }

  public void onStartRendering() {
    renderTimer.tic();
  }

  public void onStartPainting() {
    paintInterval.tic();
  }

  public void onUpdate() {
    update++;
  }

  public void onPaint() {
    paint++;
  }

  public void onDisplay() {
    // Count calls to display
    display++;

    // Start counting elapsed time for rendering
    renderTimer.tic();
  }

  /**
   * Update difference between the number of paint and update events.
   */
  public void update() {
    updatePrevDiff();
    diff = display - paint;
    renderDrift = renderTimeMs() - paintIntervalMs();
  }

  public void updatePrevDiff() {
    prevDiff = diff;
    prevRenderDrift = renderDrift;
    
  }

  // ** STATS & INFOS ********************** //

  /**
   * Return true if the difference between the number of paint and update has changed since last
   * counter update.
   */
  public boolean diffChanged() {
    return prevDiff != diff;
  }

  public String renderTimeMsInfo() {
    return "Render time : " + renderTimeMs() + "ms";
  }

  public String eventCountInfo() {
    return "Display - Paint Events Diff : " + diff;
  }

  public String paintIntervalVsRenderTimeDiffInfo() {
    return "Paint interval - render time diff : " + (paintIntervalMs() - renderTimeMs() + "ms");
  }

  public String paintIntervalMsInfo() {
    return "Paint interval : " + paintIntervalMs() + "ms";
  }

  public boolean renderLongerThanRepaintInterval() {
    return paintIntervalMs() < renderTimeMs();
  }

  public int paintIntervalMs() {
    return (int) Math.round(paintInterval.elapsedMilisecond());
  }

  public int renderTimeMs() {
    return (int) Math.round(renderTimer.elapsedMilisecond());
  }
  
  /**
   * @return variation between now and previous measure of the difference between display and paint events count. 
   */
  public int eventDiffDerivative() {
    return diff - prevDiff;
  }
  
  public int renderDriftDerivative() {
    return renderDrift - prevRenderDrift;
  }


}
