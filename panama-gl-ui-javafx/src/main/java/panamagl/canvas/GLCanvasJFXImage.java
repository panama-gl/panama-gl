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

// https://docs.oracle.com/javafx/2/canvas/jfxpub-canvas.htm
// https://github.com/openjdk/jdk/blob/master/src/java.desktop/share/classes/sun/java2d/opengl/OGLUtilities.java
// How Sun draw image with 
// https://github.com/openjdk/jdk/blob/master/src/java.desktop/share/classes/sun/java2d/SunGraphics2D.java#L3358
// using DrawImagePipe
@Deprecated
public class GLCanvasJFXImage implements GLCanvas {
  PanamaGLFactory factory;
  GLEventListener listener;
  OffscreenRenderer offscreen;

  ImageView imageView;
  Scene scene;
  
  JFXImage image;

  public GLCanvasJFXImage(PanamaGLFactory factory, ImageView target, Scene scene) {
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

    rendering = true;
    
    // Does the actual work of rendering
    offscreen.onDisplay(this, listener);
    
    rendering = false;

  }
  
  boolean rendering = false;

  @Override
  public boolean isRendering() {
    return rendering;
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
