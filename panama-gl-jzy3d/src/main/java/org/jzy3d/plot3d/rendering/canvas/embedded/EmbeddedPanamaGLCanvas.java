package org.jzy3d.plot3d.rendering.canvas.embedded;

import java.awt.GridLayout;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import org.apache.logging.log4j.LogManager;
import org.jzy3d.awt.AWTHelper;
import org.jzy3d.chart.IAnimator;
import org.jzy3d.chart.factories.IChartFactory;
import org.jzy3d.maths.Coord2d;
import org.jzy3d.maths.Dimension;
import org.jzy3d.plot3d.rendering.canvas.ICanvasListener;
import org.jzy3d.plot3d.rendering.canvas.IScreenCanvas;
import org.jzy3d.plot3d.rendering.canvas.Quality;
import org.jzy3d.plot3d.rendering.scene.Scene;
import org.jzy3d.plot3d.rendering.view.View;
import panamagl.GLCanvas;
import panamagl.GLEventListener;
import panamagl.canvas.GLCanvasSwing;

public class EmbeddedPanamaGLCanvas extends JPanel implements IScreenCanvas{
  private static final long serialVersionUID = 2488043741850146830L;
  
  protected double pixelScaleX;
  protected double pixelScaleY;
  protected View view;
  protected Renderer3D renderer;
  protected IAnimator animator;
  protected List<ICanvasListener> canvasListeners = new ArrayList<>();
  
  protected GLCanvasSwing glCanvas;

  public EmbeddedPanamaGLCanvas(IChartFactory factory, Scene scene, Quality quality, GLCanvasSwing glCanvas) {
    super();
    
    this.glCanvas = glCanvas;
    
    setLayout(new GridLayout(0, 1));
    add(glCanvas);

    view = scene.newView(this, quality);
    view.getPainter().setCanvas(this);

    renderer = new Renderer3D(view);
    glCanvas.setGLEventListener(renderer);
    //addGLEventListener(renderer);

    //setAutoSwapBufferMode(quality.isAutoSwapBuffer());

    animator = factory.getPainterFactory().newAnimator(this);
    if (quality.isAnimated()) {
      animator.start();
    } else {
      animator.stop();
    }

    //if(ALLOW_WATCH_PIXEL_SCALE)
    //  watchPixelScale();
    
    //if (quality.isPreserveViewportSize())
    //  setPixelScale(newPixelScaleIdentity());
  }
  
  public GLCanvas getGLCanvas() {
    return glCanvas;
  }
  
  //@Override
  public GLEventListener getGLEventListener() {
    return glCanvas.getGLEventListener();
  }

  //@Override
  public void setGLEventListener(GLEventListener glEvents) {
    this.glCanvas.setGLEventListener(glEvents);
  }
  
  @Override
  public boolean isNative() {
    return true;
  }

  @Override
  public View getView() {
    return view;
  }

  @Override
  public int getRendererWidth() {
    return getWidth();
  }

  @Override
  public int getRendererHeight() {
    return getHeight();
  }

  @Override
  public void screenshot(File file) throws IOException {
    // TODO Auto-generated method stub
    
  }

  @Override
  public Object screenshot() {
    return glCanvas.getScreenshot();
  }

  @Override
  public void forceRepaint() {
    /*SwingUtilities.invokeLater(new Runnable() {
      @Override
      public void run() {*/
        //glCanvas.repaint();
        glCanvas.display();
        /*System.out.println("Embedded.repaint()");
      }
    });*/
  }

  @Override
  public void dispose() {
    
  }

  @Override
  public void addMouseController(Object o) {
    addMouseListener((java.awt.event.MouseListener) o);
    if (o instanceof MouseWheelListener)
      addMouseWheelListener((MouseWheelListener) o);
    if (o instanceof MouseMotionListener)
      addMouseMotionListener((MouseMotionListener) o);
    
  }

  @Override
  public void addKeyController(Object o) {
    addKeyListener((java.awt.event.KeyListener) o);
    
  }
  @Override
  public void removeMouseController(Object o) {
    removeMouseListener((java.awt.event.MouseListener) o);
    if (o instanceof MouseWheelListener)
      removeMouseWheelListener((MouseWheelListener) o);
    if (o instanceof MouseMotionListener)
      removeMouseMotionListener((MouseMotionListener) o);
  }

  @Override
  public void removeKeyController(Object o) {
    removeKeyListener((java.awt.event.KeyListener) o);
  }


  @Override
  public String getDebugInfo() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void setPixelScale(float[] scale) {
    LogManager.getLogger(EmbeddedPanamaGLCanvas.class)
    .info("Not implemented. Pixel scale is driven by AWT Canvas itself and Panama adapts to it");
  }

  @Override
  public Coord2d getPixelScale() {
    return new Coord2d(AWTHelper.getPixelScaleX(this), AWTHelper.getPixelScaleY(this));
  }

  @Override
  public Coord2d getPixelScaleJVM() {
    return new Coord2d(AWTHelper.getPixelScaleX(this), AWTHelper.getPixelScaleY(this));
  }

  @Override
  public double getLastRenderingTimeMs() {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public void addCanvasListener(ICanvasListener listener) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void removeCanvasListener(ICanvasListener listener) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public List<ICanvasListener> getCanvasListeners() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void display() {
    repaint();
  }

  @Override
  public IAnimator getAnimation() {
    // TODO Auto-generated method stub
    return animator;
  }

  @Override
  public Dimension getDimension() {
    return new Dimension(getRendererWidth(), getRendererHeight());
  }

}
