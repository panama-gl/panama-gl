/*******************************************************************************
<<<<<<< HEAD
 * Copyright (c) 2023 Martin Pernollet and others
=======
 * Copyright (c) 2023 Christoph Läubrich and others
>>>>>>> 9941f59 (init swt)
 *
 * This program and the accompanying materials are made available under the terms of the Eclipse
 * Public License 2.0 which is available at http://www.eclipse.org/legal/epl-2.0.
 *
 * This Source Code may also be made available under the following Secondary Licenses when the
 * conditions for such availability set forth in the Eclipse Public License, v. 2.0 are satisfied:
 * GNU General Public License, version 2 with the GNU Classpath Exception which is available at
 * https://www.gnu.org/software/classpath/license.html.
 *
 * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
 ********************************************************************************/
package panamagl.canvas.swt;

<<<<<<< HEAD
import java.util.concurrent.atomic.AtomicBoolean;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.graphics.Transform;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import panamagl.GLEventListener;
import panamagl.factory.PanamaGLFactory;
import panamagl.image.SWTImage;
import panamagl.offscreen.FBO;
import panamagl.offscreen.FBOReader_SWT;
import panamagl.offscreen.OffscreenRenderer;
import panamagl.offscreen.ThreadRedirect;
import panamagl.offscreen.ThreadRedirect_SWT;
=======
import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.SWTError;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.PaletteData;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.opengl.GLData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import panamagl.GLEventListener;
import panamagl.GLProfile;
import panamagl.factory.PanamaGLFactory;
import panamagl.offscreen.OffscreenRenderer;
>>>>>>> 9941f59 (init swt)
import panamagl.opengl.GL;
import panamagl.opengl.GLContext;
import panamagl.performance.RenderCounter;

<<<<<<< HEAD
/**
 * An SWT {@link Canvas} that renders OpenGL offscreen via FBO and paints the result as an image.
 *
 * Unlike {@link GLCanvasSWT_direct} which uses SWT's native {@code GLCanvas} with a real GL context, this
 * canvas uses the {@link OffscreenRenderer} pipeline (FBO rendering + pixel readback) consistent
 * with the Swing and JavaFX offscreen canvases.
 *
 * The rendering pipeline is:
 * <ol>
 * <li>{@link #display()} triggers {@link OffscreenRenderer#onDisplay}</li>
 * <li>{@link ThreadRedirect_SWT} routes to the appropriate thread</li>
 * <li>FBO render + {@link FBOReader_SWT#read} produces a {@link SWTImage}</li>
 * <li>{@link #setScreenshot} stores the image and calls {@link #redraw()}</li>
 * <li>SWT Paint event draws the {@link ImageData} to screen via {@link GC}</li>
 * </ol>
 */
public class GLCanvasSWT extends Canvas implements panamagl.canvas.GLCanvas {

  protected PanamaGLFactory factory;
  protected GLEventListener listener;
  protected OffscreenRenderer offscreen;
  protected SWTImage out;
  protected RenderCounter counter = new RenderCounter();
  protected AtomicBoolean rendering = new AtomicBoolean();
  protected Flip flip = Flip.VERTICAL;
  protected Color color;

  public GLCanvasSWT(Composite parent, int style, PanamaGLFactory factory) {
    super(parent, style | SWT.NO_BACKGROUND);

    this.factory = factory;

    Display display = parent.getDisplay();

    // Set up the offscreen renderer with SWT-specific reader and thread redirect
    this.offscreen = factory.newOffscreenRenderer(new FBOReader_SWT());
    this.offscreen.setThreadRedirect(new ThreadRedirect_SWT(display));

    // Paint listener: draw the current screenshot to the canvas
    addListener(SWT.Paint, event -> {
      paintComponentNow(event.display, event.gc);
    });

    // Resize listener: notify offscreen renderer of new dimensions
    addListener(SWT.Resize, new ResizeHandler());

    // Dispose listener: clean up offscreen resources
    addDisposeListener(_ -> {
      offscreen.onDestroy(GLCanvasSWT.this, listener);
    });
  }
  

  /**
   * Render GL image and stop counting elapsed time for rendering (started at {@link #display()}).
   * 
   * Equivalent to GLCanvasSwing.paintComponent(..)
   */
  protected void paintComponentNow(Display display, GC gc) {
    if (out != null) {
      
      ImageData imageData = out.getImage();
      
      if (imageData != null) {
        Image swtImage = new Image(display, imageData);
        try {
          
          
          // Standard
          if (flip == null || Flip.NONE.equals(flip)) {
            gc.drawImage(swtImage, 0, 0, imageData.width, imageData.height, 0, 0, getWidth(), getHeight());
          } 
          
          // vertical flip
          else if (Flip.VERTICAL.equals(flip)) {
            Transform transform = new Transform(display);
            try {
              transform.setElements(1, 0, 0, -1, 0, getHeight());
              gc.setTransform(transform);
              gc.drawImage(swtImage, 0, 0, imageData.width, imageData.height, 0, 0, getWidth(), getHeight());
              gc.setTransform(null);
            } finally {
              transform.dispose();
            }
          } 
          
          // horizontal flip
          else if (Flip.HORIZONTAL.equals(flip)) {
            Transform transform = new Transform(display);
            try {
              transform.setElements(-1, 0, 0, 1, getWidth(), 0);
              gc.setTransform(transform);
              gc.drawImage(swtImage, 0, 0, imageData.width, imageData.height, 0, 0, getWidth(), getHeight());
              gc.setTransform(null);
            } finally {
              transform.dispose();
            }
          }
        } finally {
          swtImage.dispose();
        }

        getMonitoring().onPaintComponentBefore();
        rendering.set(false);
      }
    }
  }

  // ---------------------------------------------------------------
  // GLCanvas interface
  // ---------------------------------------------------------------

  @Override
  public void display() {
    
    // Skip potential too early calls to display to avoid exceptions
    if (!offscreen.isInitialized()) {
      return;
    }
    
    // Indicates we started to render
    setRendering(true);
    
    // Start monitoring
    getMonitoring().onDisplay();
    
    // Does the actual work of rendering
    offscreen.onDisplay(this, listener);
    
    // setRendering(false) will be invoked when painting is done
  }
  
  /**
   * The {@link ResizeHandler} will trigger rendering on the main macOS thread 
   * and then trigger repaint by the thread selected by {@link ThreadRedirect} 
   * attached to the {@link OffscreenRenderer}.
   */
  protected class ResizeHandler implements Listener{

    @Override
    public void handleEvent(Event event) {
      if (isDisposed() || !offscreen.isInitialized()) {
        return;
      }
      
      // Skip rendering if we are already in the middle of rendering
      // the previous frame
      if (isRendering()) {
        return;
      }
      
      // Otherwise indicates that we start to render and do the 
      // job required for resizing.
      else {
        Rectangle bounds = getBounds();
        
        setRendering(true);
        
        counter.onStartRendering();
        
        offscreen.onResize(GLCanvasSWT.this, listener, 0, 0, bounds.width, bounds.height);
        
        // setRendering(false) will be invoked when painting is done        
      }
    }
    
  }

  
  @Override
  public boolean isInitialized() {
    return offscreen.isInitialized();
=======
public class GLCanvasSWT extends org.eclipse.swt.opengl.GLCanvas
    implements panamagl.canvas.GLCanvas {

  protected GL gl;
  protected GLEventListener listener;
  protected OffscreenRenderer offscreen;
  protected panamagl.Image<?> image;
  protected RenderCounter renderCounter = new RenderCounter();
  protected final Runnable paintLoop;
  protected AtomicBoolean rendering = new AtomicBoolean();
  protected Color color;
  protected Flip flip = Flip.VERTICAL;

  public GLCanvasSWT(Composite parent, int style, PanamaGLFactory glFactory) {
    this(parent, style, createDefaultGLData(), glFactory);
  }

  public GLCanvasSWT(Composite parent, int style, GLData data, PanamaGLFactory glFactory) {
    super(parent, style, data);
    gl = glFactory.newGL();
    paintLoop = () -> {
      if (isDisposed()) {
        return;
      }
      rendering.set(true);
      setCurrent();
      if (listener != null) {
        listener.display(gl);
      }
      swapBuffers();
      rendering.set(false);
    };
    addListener(SWT.Resize, event -> {
      if (isDisposed()) {
        return;
      }
      Rectangle bounds = getBounds();
      setCurrent();
      if (listener != null) {
        listener.reshape(gl, bounds.x, bounds.y, bounds.width, bounds.height);
      }
    });
    addListener(SWT.Paint, event -> {
      paintLoop.run();
    });
    addDisposeListener(e -> {
      if (this.listener != null) {
        this.listener.dispose(gl);
        this.listener = null;
      }
      gl = null;
    });
  }

  @Override
  public void display() {
    if (isDisposed()) {
      return;
    }
    if (Display.getCurrent() == null) {
      Display.getDefault().syncExec(paintLoop);
    } else {
      paintLoop.run();
    }
>>>>>>> 9941f59 (init swt)
  }

  @Override
  public boolean isRendering() {
    return rendering.get();
  }

<<<<<<< HEAD
  protected void setRendering(boolean value) {
    rendering.set(value);
  }

  @Override
  public GLEventListener getGLEventListener() {
    return listener;
=======
  @Override
  public GLEventListener getGLEventListener() {
    return this.listener;
>>>>>>> 9941f59 (init swt)
  }

  @Override
  public void setGLEventListener(GLEventListener listener) {
<<<<<<< HEAD
    this.listener = listener;
    
    offscreen.onInit(this, listener);
  }

  @Override
  public GL getGL() {
    return offscreen.getGL();
=======
    if (isDisposed()) {
      throw new IllegalStateException("Widget is disposed!");
    }
    if (this.listener != listener) {
      if (this.listener != null) {
        this.listener.dispose(gl);
      }
      if (listener != null) {
        listener.init(gl);
      }
      this.listener = listener;
      display();
    }
  }

  @Override
  public boolean isInitialized() {
    return true;
>>>>>>> 9941f59 (init swt)
  }

  @Override
  public GLContext getContext() {
<<<<<<< HEAD
    return offscreen.getContext();
=======
    // we have a native context here
    GLData glData = getGLData(); // --> only drawing infos
    // maybe enhance SWT to return vendor data?
    return new GLContext() {

      protected boolean init;
      protected GLProfile profile;

      @Override
      public void setProfile(GLProfile profile) {
        this.profile = profile;
      }

      @Override
      public boolean isInitialized() {
        return init;
      }

      @Override
      public void init() {
        init = true;
      }

      @Override
      public GLProfile getProfile() {
        if (profile == null) {
          return new GLProfile(getGL());
        }
        return profile;
      }

      @Override
      public void destroy() {
        init = false;
      }
    };
  }

  @Override
  public GL getGL() {
    if (gl == null || isDisposed()) {
      throw new SWTError(SWT.ERROR_WIDGET_DISPOSED);
    }
    return gl;
>>>>>>> 9941f59 (init swt)
  }

  @Override
  public RenderCounter getMonitoring() {
<<<<<<< HEAD
    return counter;
=======
    return renderCounter;
>>>>>>> 9941f59 (init swt)
  }

  @Override
  public int getWidth() {
    return getBounds().width;
  }

  @Override
  public int getHeight() {
    return getBounds().height;
  }

  @Override
  public void repaint() {
<<<<<<< HEAD
    if (!isDisposed()) {
      redraw();
    }
  }

  /**
   * Update the image to be displayed.
   *  
   * Should not be used by anything else than offscreen rendering.
   * 
   * TODO : make method name clearer and visibility hidden?
   */
  @Override
  public void setScreenshot(panamagl.Image<?> image) {
    this.out = (SWTImage) image;
    
    counter.onPaint();
    if (!isDisposed()) {
      redraw();
    }
=======
    redraw();
  }

  @Override
  public void setScreenshot(panamagl.Image<?> image) {
    this.image = image;
>>>>>>> 9941f59 (init swt)
  }

  @Override
  public panamagl.Image<?> getScreenshot() {
<<<<<<< HEAD
    return out;
=======
    return this.image;
>>>>>>> 9941f59 (init swt)
  }

  @Override
  public OffscreenRenderer getOffscreenRenderer() {
<<<<<<< HEAD
    return offscreen;
=======
    return this.offscreen;
>>>>>>> 9941f59 (init swt)
  }

  @Override
  public void setOffscreenRenderer(OffscreenRenderer offscreen) {
    this.offscreen = offscreen;
  }

<<<<<<< HEAD
=======
  protected static GLData createDefaultGLData() {
    GLData data = new GLData();
    data.doubleBuffer = true;
    return data;
  }

  public Color getColor() {
    return color;
  }

  /**
   * Clear the background and fill it with the widgets background color
   */
  public void clear() {
    Color background = getBackground();
    GL gl = getGL();
    gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
    gl.glClearColor(background.getRed() / 255f, background.getGreen() / 255f,
        background.getBlue() / 255f, 1.0f);

  }

  public void setColor(Color color) {
    getGL().glColor4d(color.getRed() / 255d, color.getGreen() / 255d, color.getBlue() / 255d,
        color.getAlpha() / 255d);
    this.color = color;
  }

  public void orthographic() {
    GL gl = getGL();
    gl.glMatrixMode(GL.GL_PROJECTION);
    gl.glLoadIdentity();
    Rectangle bounds = getBounds();
    gl.glOrtho(0.0f, bounds.width, bounds.height, 0.0f, 0.0f, 1.0f);
  }

  public void drawImage(ImageData image, double x, double y, boolean alpha) {
    GL gl = getGL();
    gl.glPushMatrix();
    if (alpha) {
      gl.glBlendFunc(GL.GL_SRC_ALPHA, GL.GL_ONE_MINUS_SRC_ALPHA);
      gl.glEnable(GL.GL_BLEND);
    }
    orthographic();
    byte[] bytes = getPixelData(image, alpha);

    try (Arena allocator = Arena.ofConfined()) {
      MemorySegment s = allocator.allocate(ValueLayout.JAVA_BYTE, bytes.length);

      for (int i = 0; i < bytes.length; i++) {
        s.setAtIndex(ValueLayout.JAVA_BYTE, i, bytes[i]);
      }

      gl.glRasterPos2d(x, y);
      gl.glDrawPixels(image.width, image.height, alpha ? GL.GL_RGBA : GL.GL_RGB,
          GL.GL_UNSIGNED_BYTE, s);
    }
    gl.glPopMatrix();
  }

  public void drawRaster(double x, double y, int width, int height, boolean transparent,
      Consumer<GC> paintHandler) {
    Image image = transparent ? createImageWithTransparentBackground(getDisplay(), width, height)
        : new Image(getDisplay(), width, height);
    try {
      GC gc = new GC(image);
      try {
        gc.setFont(getFont());
        gc.setForeground(getForeground());
        gc.setBackground(getBackground());
        paintHandler.accept(gc);
      } finally {
        gc.dispose();
      }
      drawImage(image.getImageData(), x, y, transparent);
    } finally {
      image.dispose();
    }
  }

  public Point drawString(String text, double x, double y) {
    return drawString(text, measureText(text, getFont()), x, y);
  }

  public Point drawString(String text, Point measure, double x, double y) {
    int width = measure.x;
    int height = measure.y;
    drawRaster(x, y, width, height, true, gc -> {
      gc.setForeground(getColor());
      gc.drawString(text, 0, 0, true);
    });
    return measure;
  }

  public static Image createImageWithTransparentBackground(Device device, int width, int height) {

    PaletteData palette = new PaletteData(0xFF0000, 0xFF00, 0xFF);
    ImageData tempImgData = new ImageData(width, height, 24, palette);
    tempImgData.alphaData = new byte[width * height];
    return new Image(device, tempImgData);
  }

  /**
   * Measure the the text size of the given string and font
   * 
   * @param text the text to measure
   * @param font the font to use
   * @return
   */
  public static Point measureText(String text, Font font) {

    GC gc = new GC(font.getDevice());
    try {
      gc.setFont(font);
      return gc.stringExtent(text);
    } finally {
      gc.dispose();
    }
  }

  public static byte[] getPixelData(Image image, boolean withAlphaChannel) {
    return getPixelData(image.getImageData(), withAlphaChannel);
  }

  public static byte[] getPixelData(ImageData imageData, boolean withAlphaChannel) {

    PaletteData palette = imageData.palette;
    byte[] bytes = new byte[imageData.width * imageData.height * (withAlphaChannel ? 4 : 3)];
    if (palette.isDirect) {
      int i = 0;
      for (int y = 0; y < imageData.height; y++) {
        for (int x = 0; x < imageData.width; x++) {
          int pixel = imageData.getPixel(x, imageData.height - 1 - y);
          int red = extractValue(pixel, palette.redMask, palette.redShift);
          int green = extractValue(pixel, palette.greenMask, palette.greenShift);
          int blue = extractValue(pixel, palette.blueMask, palette.blueShift);
          bytes[i++] = (byte) (red & 0xFF);
          bytes[i++] = (byte) (green & 0xFF);
          bytes[i++] = (byte) (blue & 0xFF);
          if (withAlphaChannel) {
            int alpha = imageData.getAlpha(x, imageData.height - 1 - y);
            bytes[i++] = (byte) (alpha & 0xFF);
          }
        }
      }
    } else {
      RGB[] rgbs = imageData.getRGBs();
      // TODO need and example here! Can this even happen with a dynamic image?
      throw new RuntimeException(
          "Not implemented- need and example here! Can this even happen with a dynamic image?");
    }
    return bytes;
  }

  protected static int extractValue(int pixel, int mask, int shift) {
    int value = pixel & mask;
    value = (shift < 0) ? value >>> -shift : value << shift;
    return value;
  }

>>>>>>> 9941f59 (init swt)
  @Override
  public Flip getFlip() {
    return flip;
  }

  @Override
  public void setFlip(Flip flip) {
    this.flip = flip;
  }

<<<<<<< HEAD
  public FBO getFBO() {
    return offscreen.getFBO();
  }

  public void setFBO(FBO fbo) {
    this.offscreen.setFBO(fbo);
  }
=======
>>>>>>> 9941f59 (init swt)
}
