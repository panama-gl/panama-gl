package panamagl.canvas;

import java.util.concurrent.atomic.AtomicBoolean;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import panamagl.GLEventListener;
import panamagl.Image;
import panamagl.canvas.overlay.PerformanceOverlay_JFX;
import panamagl.factory.PanamaGLFactory;
import panamagl.image.JFXImage;
import panamagl.offscreen.FBO;
import panamagl.offscreen.FBOReader_JFX;
import panamagl.offscreen.OffscreenRenderer;
import panamagl.offscreen.ThreadRedirect_JFX;
import panamagl.opengl.GL;
import panamagl.opengl.GLContext;
import panamagl.performance.RenderCounter;

// https://docs.oracle.com/javafx/2/canvas/jfxpub-canvas.htm
// https://github.com/openjdk/jdk/blob/master/src/java.desktop/share/classes/sun/java2d/opengl/OGLUtilities.java
// How Sun draw image with
// https://github.com/openjdk/jdk/blob/master/src/java.desktop/share/classes/sun/java2d/SunGraphics2D.java#L3358
// using DrawImagePipe
public class GLCanvasJFX implements GLCanvas {
  protected PanamaGLFactory factory;
  protected GLEventListener listener;
  protected OffscreenRenderer offscreen;

  protected JFXImage image;
  protected Canvas canvas;

  protected Flip flip = Flip.VERTICAL;
  
  protected PerformanceOverlay_JFX overlay;
  protected RenderCounter counter = new RenderCounter();
  protected boolean debugPerf = true;

  protected AtomicBoolean rendering = new AtomicBoolean();


  public GLCanvasJFX(PanamaGLFactory factory, Canvas canvas) {
    factory.setThreadRedirect(new ThreadRedirect_JFX());

    this.factory = factory;
    this.canvas = canvas;
    this.offscreen = factory.newOffscreenRenderer(new FBOReader_JFX());

    this.overlay = new PerformanceOverlay_JFX(this);

    ResizeHandler resize = new ResizeHandler();
    this.canvas.widthProperty().addListener(resize);
    this.canvas.heightProperty().addListener(resize);
  }

  @Override
  public void display() {
    // Skip potential too early calls to display to avoid exceptions
    if (!offscreen.isInitialized()) {
      return;
    }

    setRendering(true);

    // Start monitoring
    getMonitoring().onDisplay();

    // Does the actual work of rendering
    offscreen.onDisplay(this, listener);

    // setRendering(false) will be invoked when painting is done
  }


  @Override
  public boolean isRendering() {
    return rendering.get();
  }

  public void setRendering(boolean value) {
    rendering.set(value);
  }

  protected class ResizeHandler implements ChangeListener<Number> {
    @Override
    public void changed(ObservableValue<? extends Number> observable, Number oldValue,
        Number newValue) {

      //System.out.println(canvas.getScene());
      //int w = (int) canvas.getScene().widthProperty().get();
      //int h = (int) canvas.getScene().heightProperty().get();
      int w = (int)canvas.widthProperty().get();
      int h = (int)canvas.heightProperty().get();



      // Skip rendering we are already in the middle of rendering
      // the previous frame
      /*if (isRendering()) {
        return;
      }

      // Otherwise indicates that we start to render and do the
      // job required for resizing.
      else {*/
        setRendering(true);

        getMonitoring().onStartRendering();

        //System.out.println("GLCanvasJFX : " + w + " " + h);

        offscreen.onResize(GLCanvasJFX.this, listener, 0, 0, w, h);
      //}
    }
  }

  @Override
  public boolean isVisible() {
    return canvas.isVisible();
  }

  @Override
  public int getWidth() {
    return canvas.widthProperty().intValue();
  }

  @Override
  public int getHeight() {
    return canvas.heightProperty().intValue();
  }

  @Override
  public RenderCounter getMonitoring() {
    return counter;
  }

  @Override
  public void repaint() {
    display();
  }

  @Override
  public void setScreenshot(Image<?> image) {
    this.image = (JFXImage) image;

    // System.out.println(Thread.currentThread());

    getMonitoring().onPaint();

    GraphicsContext gc = canvas.getGraphicsContext2D();
    
    // Draw Image
    if(flip==null || Flip.NONE.equals(flip)) {
      gc.drawImage(this.image.getImage(), 0, 0, getWidth(), getHeight());
    }
    // vertical flip
    else if(Flip.VERTICAL.equals(flip)) {
      gc.drawImage(this.image.getImage(), 0, 0+getHeight(), getWidth(), -getHeight());
    }
    // horizontal flip
    else if(Flip.HORIZONTAL.equals(flip)) {
      gc.drawImage(this.image.getImage(), 0+getWidth(), 0, -getWidth(), getHeight());
    }
    
    getMonitoring().onPaintComponentBefore();

    // Draw overlay
    if (debugPerf)
      overlay.paint(gc);

    rendering.set(false);
  }

  @Override
  public Image<?> getScreenshot() {
    return image;
  }



  // =========================================

  @Override
  public OffscreenRenderer getOffscreenRenderer() {
    return offscreen;
  }

  @Override
  public void setOffscreenRenderer(OffscreenRenderer offscreen) {
    this.offscreen = offscreen;
  }

  @Override
  public boolean isInitialized() {
    return offscreen.isInitialized();
  }

  @Override
  public GLEventListener getGLEventListener() {
    return listener;
  }

  @Override
  public void setGLEventListener(GLEventListener listener) {
    this.listener = listener;

    offscreen.onInit(this, listener);
  }

  @Override
  public GLContext getContext() {
    return offscreen.getContext();
  }

  @Override
  public GL getGL() {
    return offscreen.getGL();
  }

  @Override
  public Flip getFlip() {
    return flip;
  }

  @Override
  public void setFlip(Flip flip) {
    this.flip = flip;
  }

  public FBO getFBO() {
    return offscreen.getFBO();
  }

  public void setFBO(FBO fbo) {
    this.offscreen.setFBO(fbo);
  }


}
