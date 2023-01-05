package panamagl;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.image.BufferedImage;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.swing.JPanel;
import opengl.GL;
import opengl.GLContext;
import opengl.fbo.FBO;
import panamagl.macos.MacOSOffscreenRenderer;

/**
 * This panel push to the screen an OpenGL image rendered offscreen by an {@link FBO}.
 * 
 * The panel mainly deals with
 * <ul>
 * <li>OpenGL context initialization, after the panel is added to a parent, and before it is made
 * visible.</li>
 * <li>repaint and resize events that are propagated to the OpenGL application through a
 * {@link GLEventListener}, which must be provided by the user of this panel through
 * {@link #setGLEventListener(GLEventListener)}.</li>
 * </ul>
 * 
 * <h2>Threading</h2> The panel is also reponsible for triggering OpenGL initialization and
 * rendering in the appropriate threads, which may depend on the running operating system.
 * 
 * <h3>Threading on macOS</h3> <img src="./doc-files/GLPanel-threads.png"/>
 * 
 * 
 * <h2>Debugging</h2>
 * 
 * Hint : to debug this class, invoke a program using it with flag -Dpanamagl.GLPanel
 * 
 * @author Martin Pernollet
 *
 */
public class GLPanel extends JPanel implements GLAutoDrawable {
  private static final long serialVersionUID = -4601832524814661585L;

  protected GLEventListener glListener;
  protected OffscreenRenderer offscreen = new MacOSOffscreenRenderer();
  protected BufferedImage out = null;
  
  protected AtomicBoolean rendering = new AtomicBoolean();
  protected RenderCounter counter = new RenderCounter();
  protected PerfOverlay perfOverlay = new PerfOverlay();

  protected boolean debug = Debug.check(GLPanel.class);
  protected boolean debugPerf = true;


  /**
   * Initialize a panel able to render OpenGL through a {@link GLEventListener} and related
   * {@link GL} interface.
   */
  public GLPanel() {
    // Load OSXUtil native as soon as possible for macOS!
    // GLProfile.initSingleton();

    // Show debug info
    if (debug)
      GraphicsUtils.printGraphicsEnvironment("GLPanel");

    // This listener hold the most important part of the rendering flow
    addComponentListener(new ResizeHandler());
  }



  /* ===================================================== */
  //
  // AWT OVERRIDES


  /**
   * Called after the JPanel has been added to the Swing hierarchy but before it is made visible.
   * 
   * Initialization may occur in other threads and not be completed when this method returns.
   * 
   * To ensure the component is initialized, call {@link #ini
   */
  @Override
  public void addNotify() {
    super.addNotify();

    // Initialize GL context from main macOS thread
    offscreen.onInit(this, glListener);
  }

  /**
   * Called before the JPanel is removed from the Swing hierarchy.
   */
  @Override
  public void removeNotify() {
    offscreen.onDestroy(null, glListener);

    super.removeNotify();

  }

  /**
   * Invoked each time redraw should be performed, even if the redraw query is coalesced with other
   * redraw queries by the AWT Event Queue.
   * 
   * @see {@link #update()}
   */
  @Override
  public void update(Graphics g) {
    counter.onUpdate();
    super.update(g);
  }

  /**
   * Invoked only for redraw query that are not coalesced with other redraw queries by the AWT Event
   * Queue.
   * 
   * @see {@link #paint()}
   */
  @Override
  public void paint(Graphics g) {
    counter.onPaint();
    super.paint(g);
  }

  /**
   * Render GL image and stop counting elapsed time for rendering (started at {@link #display()})
   */
  @Override
  public void paintComponent(Graphics g) {
    System.out.println("paint ");
    if (out != null) {
      g.drawImage(out, 0, 0, null);

      counter.onPaintComponent();

      if(debugPerf)
        overlayPerformance(g);
      
      rendering.set(false);
    }
  }
  
  /**
   * If the panel initialization has achieved, this triggers an offscreen rendering, maybe on a
   * separated thread (macOS case), from which an asynchronous repaint will be triggered.
   */
  @Override
  public void display() {
    // Skip potential too early calls to display to avoid
    // exceptions
    if (!offscreen.isInitialized()) {
      return;
    }
    
    setRendering();

    // Start monitoring
    counter.onDisplay();

    offscreen.onDisplay(this, glListener);
  }
  
  /** Return true if display has started but has not yet finished */
  @Override
  public boolean isRendering(){
    return rendering.get();
  }
  
  protected void setRendering() {
    rendering.set(true);

  }

  /**
   * The {@link ResizeHandler} will trigger rendering on the main macOS thread and then trigger
   * repaint through {@link SwingUtilities.invokeLater()}.
   */
  protected class ResizeHandler extends ComponentAdapter {
    @Override
    public void componentResized(ComponentEvent e) {
      super.componentResized(e);

      Dimension size = e.getComponent().getSize();

      int w = (int) Math.round(size.getWidth());
      int h = (int) Math.round(size.getHeight());

      Debug.debug(debug, "GLPanel resizing to " + w + "x" + h);


      // Skip rendering we are already in the middle of rendering
      // the previous frame
      if(isRendering()) {
        return;
      }
      else {
        setRendering();
        counter.renderTimer.tic();

        offscreen.onResize(GLPanel.this, glListener, 0, 0, w, h);
      }
    }
  }

  /* ===================================================== */
  //
  // BASIC PERFORMANCE MONITORING AND REPORTING

  /**
   * Show performance in a 2D text overlay.
   */
  protected void overlayPerformance(Graphics g) {
    // Overlay performance info
    g.setColor(Color.GRAY);

    // -------------------------------------------------
    // Interval between rendering query and repaint achieved. The real rendering time during which
    // OpenGL worked.

    // int renderTimeMs = counter.renderTimeMs();

    g.drawString(counter.renderTimeMsInfo(), perfOverlay.x,
        getHeight() - perfOverlay.yRenderTimeInterval);

    // -------------------------------------------------
    // Interval between two repaint, which show how we stress the AWT Event Queue
    // https://github.com/jzy3d/jzy3d-api/tree/master/jzy3d-emul-gl-awt#integrating-in-awt

    // Highlight render time longer than paint interval
    if (counter.renderLongerThanRepaintInterval())
      g.setColor(Color.ORANGE);

    g.drawString(counter.paintIntervalMsInfo(), perfOverlay.x,
        getHeight() - perfOverlay.yPaintInterval);

    g.drawString(counter.paintIntervalVsRenderTimeDiffInfo(), perfOverlay.x,
        getHeight() - perfOverlay.yIntervalDiff );

    

    counter.paintInterval.tic();

    // -------------------------------------------------
    // Count coalesced events.

    counter.update();

    // Highlight when count display vs paint differ
    if (counter.diffChanged()) {
      g.setColor(Color.ORANGE);
    } else {
      g.setColor(Color.GRAY);
    }

    g.drawString(counter.eventCountInfo(), perfOverlay.x,
        getHeight() - perfOverlay.yCountCoalesced);

  }

  protected class PerfOverlay {
    protected int interline = 20;
    protected int x = 10;
    protected int yPaintInterval = x;
    protected int yRenderTimeInterval = yPaintInterval + interline;
    protected int yIntervalDiff = yRenderTimeInterval + interline;
    protected int yCountCoalesced = yIntervalDiff + interline;
  }


  /* ===================================================== */
  //
  // FROM GL AUTO DRAWABLE INTERFACE


  @Override
  public GLEventListener getGLEventListener() {
    return glListener;
  }

  @Override
  public void setGLEventListener(GLEventListener glEvents) {
    this.glListener = glEvents;
  }

  @Override
  public GL getGL() {
    return offscreen.getGL();
  }

  @Override
  public GLContext getContext() {
    return offscreen.getContext();
  }

  /* ===================================================== */

  @Override
  public BufferedImage getScreenshot() {
    if (out == null) {
      return null;
    }
    return ImageUtils.copy(out);
  }
  
  // should not be used by anything else than backend
  @Override
  public void setScreenshot(BufferedImage image) {
    out = image;
  }

  /* ===================================================== */
  
  protected int getFBOHeight() {
    return (int) Math.max(800, this.getHeight());
  }

  protected int getFBOWidth() {
    return (int) Math.max(600, this.getWidth());
  }



  @Override
  public boolean isInitialized() {
    return offscreen.isInitialized();
  }

  /**
   * Indicates if image will be flipped vertically while being painted.
   * @return
   */
  public boolean isFlipY() {
    return offscreen.getFBO().isFlipY();
  }

  /**
   * Sets if image will be flipped vertically while being painted.
   */
  public void setFlipY(boolean flipY) {
    this.offscreen.getFBO().setFlipY(flipY);
  }

  public FBO getFBO() {
    return offscreen.getFBO();
  }

  public void setFBO(FBO fbo) {
    this.offscreen.setFBO(fbo);
  }

  @Override
  public RenderCounter getMonitoring() {
    return counter;
  }

  public void setMonitoring(RenderCounter counter) {
    this.counter = counter;
  }
  
  
}
