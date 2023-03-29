package panamagl.canvas;

import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import panamagl.GLCanvas;
import panamagl.GLEventListener;
import panamagl.Image;
import panamagl.factory.PanamaGLFactory;
import panamagl.image.JFXImage;
import panamagl.offscreen.FBOReader_JFX;
import panamagl.offscreen.OffscreenRenderer;
import panamagl.opengl.GL;
import panamagl.opengl.GLContext;
import panamagl.performance.RenderCounter;

public class GLCanvasJavaFX implements GLCanvas {
  PanamaGLFactory factory;
  GLEventListener listener;
  OffscreenRenderer offscreen;

  ImageView imageView;
  Scene scene;
  
  JFXImage image;

  public GLCanvasJavaFX(PanamaGLFactory factory, ImageView target, Scene scene) {
    this.factory = factory;
    this.offscreen = factory.newOffscreenRenderer(new FBOReader_JFX());

    this.imageView = target;
    this.scene = scene;
  }

  @Override
  public void display() {
    // Skip potential too early calls to display to avoid exceptions
    if (!offscreen.isInitialized()) {
      return;
    }

    // Does the actual work of rendering
    offscreen.onDisplay(this, listener);

  }

  @Override
  public boolean isRendering() {
    return false;
  }


  @Override
  public boolean isVisible() {
    return imageView.isVisible();
  }


  @Override
  public RenderCounter getMonitoring() {
    return null;
  }

  @Override
  public int getWidth() {
    
    return (int)scene.widthProperty().get();
  }

  @Override
  public int getHeight() {
    return (int)scene.heightProperty().get();
  }

  @Override
  public void repaint() {
    display();
  }

  @Override
  public void setScreenshot(Image<?> image) {
    this.image = (JFXImage) image;
    
    imageView.setImage(this.image.getImage());
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

}
