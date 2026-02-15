/*******************************************************************************
 * Copyright (c) 2023 Christoph Läubrich, Martin Pernollet and others
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
import panamagl.opengl.GL;
import panamagl.opengl.GLContext;
import panamagl.performance.RenderCounter;

public class GLCanvasSWT extends org.eclipse.swt.opengl.GLCanvas
    implements panamagl.canvas.GLCanvas {

  protected GL gl;
  protected GLEventListener listener;
  protected OffscreenRenderer offscreen;
  protected panamagl.Image<?> image;
  protected RenderCounter renderCounter = new RenderCounter();
  protected final Runnable paintLoop;
  protected AtomicBoolean rendering = new AtomicBoolean();
  protected GLContext context;
  protected Color color;
  protected Flip flip = Flip.VERTICAL;
  
  

  public GLCanvasSWT(Composite parent, int style, PanamaGLFactory glFactory) {
    this(parent, style, createDefaultGLData(), glFactory);
  }

  public GLCanvasSWT(Composite parent, int style, GLData data, PanamaGLFactory glFactory) {
    super(parent, style, data);

    // On macOS Cocoa, SWT's Widget.drawRect assumes NSGraphicsContext.currentContext()
    // is non-null, but for GLCanvas (backed by NSOpenGLView) there is no NSGraphicsContext.
    // Disabling SWT redraw prevents the NPE in drawRect. GL rendering is unaffected
    // because it goes through setCurrent()/swapBuffers(), not SWT's 2D paint pipeline.
    if ("cocoa".equals(SWT.getPlatform())) {
      setRedraw(false);
    }

    gl = glFactory.newGL();
    paintLoop = () -> {
      if (isDisposed()) {
        return;
      }
      rendering.set(true);
      try {
        setCurrent();
        if (listener != null) {
          listener.display(gl);
        }
        swapBuffers();
      } finally {
        rendering.set(false);
      }
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
      // Wait for any in-progress render to complete before cleaning up
      while (rendering.get()) {
        Thread.yield();
      }
      if (this.listener != null) {
        this.listener.dispose(gl);
        this.listener = null;
      }
      gl = null;
    });
  }
  
  PanamaGLFactory factory;
  
  public PanamaGLFactory getFactory() {
	return factory;
}

  public void setFactory(PanamaGLFactory factory) {
	this.factory = factory;
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
  }

  @Override
  public boolean isRendering() {
    return rendering.get();
  }

  @Override
  public GLEventListener getGLEventListener() {
    return this.listener;
  }

  /**
   * Does not call display(). Should be called explicitely.
   */
  @Override
  public void setGLEventListener(GLEventListener listener) {
    if (isDisposed()) {
      throw new IllegalStateException("Widget is disposed!");
    }
    if (this.listener != listener) {
      if (this.listener != null) {
        this.listener.dispose(gl);
      }
      if (listener != null) {
        setCurrent();
        listener.init(gl);
      }
      this.listener = listener;
    }
  }

  @Override
  public boolean isInitialized() {
    return true;
  }

  @Override
  public GLContext getContext() {
    // we have a native context here
    //GLData glData = getGLData(); // --> only drawing infos
    // maybe enhance SWT to return vendor data?
    
	if(factory==null)
      return null;
    return factory.newGLContext();
    
    /*return new GLContext() {

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
    };*/
  }

  @Override
  public GL getGL() {
    if (gl == null || isDisposed()) {
      throw new SWTError(SWT.ERROR_WIDGET_DISPOSED);
    }
    return gl;
  }

  @Override
  public RenderCounter getMonitoring() {
    return renderCounter;
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
    redraw();
  }

  @Override
  public void setScreenshot(panamagl.Image<?> image) {
    this.image = image;
  }

  @Override
  public panamagl.Image<?> getScreenshot() {
    return this.image;
  }

  @Override
  public OffscreenRenderer getOffscreenRenderer() {
    return this.offscreen;
  }

  @Override
  public void setOffscreenRenderer(OffscreenRenderer offscreen) {
    this.offscreen = offscreen;
  }

  protected static GLData createDefaultGLData() {
    GLData data = new GLData();
    data.doubleBuffer = true;
    data.depthSize = 24;
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
    gl.glClearColor(background.getRed() / 255f, background.getGreen() / 255f,
        background.getBlue() / 255f, 1.0f);
    gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
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

  @Override
  public Flip getFlip() {
    return flip;
  }

  @Override
  public void setFlip(Flip flip) {
    this.flip = flip;
  }

}
