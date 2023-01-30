package org.jzy3d.chart.factories.embedded;

import org.jzy3d.bridge.awt.FrameAWT;
import org.jzy3d.chart.Chart;
import org.jzy3d.chart.IAnimator;
import org.jzy3d.chart.PanamaGLAnimator;
import org.jzy3d.chart.PanamaGLFrame;
import org.jzy3d.chart.controllers.keyboard.camera.AWTCameraKeyController;
import org.jzy3d.chart.controllers.keyboard.camera.ICameraKeyController;
import org.jzy3d.chart.controllers.keyboard.screenshot.AWTScreenshotKeyController;
import org.jzy3d.chart.controllers.keyboard.screenshot.IScreenshotKeyController;
import org.jzy3d.chart.controllers.mouse.camera.AWTCameraMouseController;
import org.jzy3d.chart.controllers.mouse.camera.ICameraMouseController;
import org.jzy3d.chart.controllers.mouse.picking.IMousePickingController;
import org.jzy3d.chart.factories.IChartFactory;
import org.jzy3d.chart.factories.IFrame;
import org.jzy3d.chart.factories.IPainterFactory;
import org.jzy3d.maths.Dimension;
import org.jzy3d.maths.Rectangle;
import org.jzy3d.painters.IPainter;
import org.jzy3d.painters.embedded.EmbeddedPanamaGLPainter;
import org.jzy3d.plot3d.pipelines.NotImplementedException;
import org.jzy3d.plot3d.primitives.symbols.SymbolHandler;
import org.jzy3d.plot3d.rendering.canvas.ICanvas;
import org.jzy3d.plot3d.rendering.canvas.IScreenCanvas;
import org.jzy3d.plot3d.rendering.canvas.Quality;
import org.jzy3d.plot3d.rendering.canvas.embedded.EmbeddedPanamaGLCanvas;
import org.jzy3d.plot3d.rendering.image.IImageWrapper;
import org.jzy3d.plot3d.rendering.scene.Scene;
import org.jzy3d.plot3d.rendering.view.IViewOverlay;
import org.jzy3d.plot3d.rendering.view.layout.IViewportLayout;
import org.jzy3d.plot3d.rendering.view.layout.PanamaGLViewAndColorbarsLayout;
import com.jogamp.opengl.GLException;
import panamagl.canvas.GLCanvasSwing;
import panamagl.factory.PanamaGLFactory;

public class EmbeddedPanamaGLPainterFactory implements IPainterFactory{
  protected PanamaGLFactory f = PanamaGLFactory.select();
  
  
  protected IChartFactory chartFactory;
  protected boolean offscreen = false;
  protected int width;
  protected int height;

  @Override
  public IPainter newPainter() {
    EmbeddedPanamaGLPainter p = new EmbeddedPanamaGLPainter();
    p.setGL(f.newGL());
    return p;
  }

  
  @Override
  public ICanvas newCanvas(IChartFactory factory, Scene scene, Quality quality) {
      GLCanvasSwing glCanvas = f.newCanvasSwing();
      EmbeddedPanamaGLCanvas icanvas = new EmbeddedPanamaGLCanvas(factory, scene, quality, glCanvas);
      return icanvas;
  }
  
  
  @Override
  public IViewOverlay newViewOverlay() {
      return null;
  }

  @Override
  public IViewportLayout newViewportLayout() {
      return new PanamaGLViewAndColorbarsLayout();
  }

  @Override
  public SymbolHandler newSymbolHandler(IImageWrapper image) {
      // TODO Auto-generated method stub
      return null;
  }

  @Override
  public IAnimator newAnimator(ICanvas canvas) {
      return new PanamaGLAnimator((IScreenCanvas)canvas);
  }

  @Override
  public ICameraMouseController newMouseCameraController(Chart chart) {
      return new AWTCameraMouseController(chart);
  }

  @Override
  public IMousePickingController newMousePickingController(Chart chart, int clickWidth) {
      // TODO Auto-generated method stub
      return null;
  }

  @Override
  public ICameraKeyController newKeyboardCameraController(Chart chart) {
      return new AWTCameraKeyController(chart);
  }

  @Override
  public IScreenshotKeyController newKeyboardScreenshotController(Chart chart) {
      return new AWTScreenshotKeyController(chart, "target/out.png");
  }

  @Override
  public IFrame newFrame(Chart chart) {
      return new PanamaGLFrame(chart);
  }

  @Override
  public IFrame newFrame(Chart chart, Rectangle bounds, String title) {
    FrameAWT f = new FrameAWT();
    f.initialize(chart, bounds, title);
    
    return f;
  }

  @Override
  public IChartFactory getChartFactory() {
      return chartFactory;
  }

  @Override
  public void setChartFactory(IChartFactory chartFactory) {
      this.chartFactory = chartFactory;
  }

  @Override
  public boolean isOffscreen() {
      return offscreen;
  }

  @Override
  public void setOffscreenDisabled() {
      this.offscreen = false;
  }

  @Override
  public void setOffscreen(int width, int height) {
      this.offscreen = true;
      this.width = width;
      this.height = height;
  }

  @Override
  public void setOffscreen(Rectangle rectangle) {
      setOffscreen(rectangle.width, rectangle.height);
  }

  @Override
  public Dimension getOffscreenDimension() {
      return new Dimension(width, height);
  }
  

  @Override
  public boolean isDebugGL() {
    return false;
  }

  /** If true, will let GL trigger {@link GLException} if an error occur in OpenGL which ease debugging. Default is false. */
  @Override
  public void setDebugGL(boolean debugGL) {
    throw new NotImplementedException();
  }



}
