/*******************************************************************************
 * Copyright (c) 2026 Martin Pernollet & contributors.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301, USA
 *******************************************************************************/
package panamagl.renderers.text;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import panamagl.opengl.GL;

/**
 * Render text drawn with AWT in a texture mapped on a quad in screen coordinates, as JOGL's
 * <code>TextRenderer</code> does. Hence any AWT font can be used, text can be rotated, and text
 * partially out of the viewport is partially drawn (unlike {@link BasicTextRenderer} which draws
 * pixels at a raster position).
 *
 * On HiDPI screens, set the {@link #setPixelScale(float) pixel scale} to draw glyphs with a font
 * scaled accordingly, as JOGL does with the surface scale. Text widths given by
 * {@link #getTextWidth(Font, String)} remain in logical pixels.
 *
 * This renderer only relies on AWT and OpenGL 1.x (no GLUT) and requires a context supporting the
 * fixed pipeline (e.g. a compatibility profile).
 */
public class OrientedTextRenderer implements TextRenderer<Font, Color> {
  protected float pixelScale = 1;
  protected boolean antialiasing = true;

  /**
   * Draw a text with the left of its baseline at the given position, in pixels from the bottom left
   * corner of the current viewport.
   *
   * @param z ignored, the text is always drawn over the scene.
   * @param rotation in radians, counter-clockwise, applied at the center of the text.
   */
  @Override
  public void draw(GL gl, Font font, String text, float x, float y, float z, Color color,
      float rotation) {
    if (font == null || text == null || text.isEmpty()) {
      return;
    }

    TextImage image = createTextImage(font, text, color);

    float rotationD = (float) Math.toDegrees(rotation);

    // Pre-shift the text to make it rotate from the center of the string and not from its left
    // point. As JOGL, the center is evaluated in logical pixels.
    int xPreShift = 0;
    int yPreShift = 0;

    if (rotationD != 0) {
      xPreShift = getTextWidth(font, text) / 2;
      yPreShift = font.getSize() / 2;
    }

    int[] viewport = getViewport(gl);

    // Text baseline is at the origin, shifted to deal with rotation
    drawTexture(gl, image.getImage(), x + xPreShift, y + yPreShift, rotationD, -xPreShift,
        -yPreShift - image.getDescent(), viewport[2], viewport[3]);
  }

  /**
   * Draw a text at the current raster position, as GLUT bitmap strings : the raster position is
   * the left of the text baseline and is moved to the end of the text once drawn.
   */
  public void drawAtRasterPosition(GL gl, Font font, String text, Color color) {
    if (font == null || text == null || text.isEmpty()) {
      return;
    }

    TextImage image = createTextImage(font, text, color);

    try (Arena arena = Arena.ofConfined()) {
      // Move the raster position from the baseline to the bottom of the text image
      gl.glBitmap(0, 0, 0, 0, 0, -image.getDescent(), MemorySegment.NULL);

      gl.glDrawPixels(image.getWidth(), image.getHeight(), GL.GL_RGBA, GL.GL_UNSIGNED_BYTE,
          toRGBA(arena, image.getImage()));

      // Move the raster position to the end of the text on the baseline
      gl.glBitmap(0, 0, 0, 0, image.getAdvance(), image.getDescent(), MemorySegment.NULL);
    }
  }

  /**
   * Draw an image, without scaling, with its bottom left corner at the given position in pixels
   * from the bottom left corner of the current viewport. The image is drawn as a textured quad, so
   * that it can be partially out of the viewport.
   */
  public void drawImage(GL gl, BufferedImage image, float x, float y) {
    int[] viewport = getViewport(gl);
    drawTexture(gl, image, x, y, 0, 0, 0, viewport[2], viewport[3]);
  }

  /**
   * Draw an image as a texture mapped on a quad in screen coordinates.
   *
   * @param x, y the position where the quad origin is translated, in pixels.
   * @param rotationD a counter-clockwise rotation around the quad origin, in degrees.
   * @param x0, y0 the position of the bottom left corner of the quad, relative to its origin.
   */
  protected void drawTexture(GL gl, BufferedImage image, float x, float y, float rotationD,
      float x0, float y0, int viewportWidth, int viewportHeight) {
    int width = image.getWidth();
    int height = image.getHeight();

    // Nothing is visible in an empty viewport, and glOrtho would fail
    if (viewportWidth <= 0 || viewportHeight <= 0 || width <= 0 || height <= 0) {
      return;
    }

    try (Arena arena = Arena.ofConfined()) {
      gl.glPushAttrib(GL.GL_ENABLE_BIT | GL.GL_TEXTURE_BIT | GL.GL_COLOR_BUFFER_BIT
          | GL.GL_POLYGON_BIT | GL.GL_CURRENT_BIT | GL.GL_TRANSFORM_BIT);

      gl.glMatrixMode(GL.GL_PROJECTION);
      gl.glPushMatrix();
      gl.glLoadIdentity();
      gl.glOrtho(0, viewportWidth, 0, viewportHeight, -1, 1);

      gl.glMatrixMode(GL.GL_MODELVIEW);
      gl.glPushMatrix();
      gl.glLoadIdentity();
      gl.glTranslatef(x, y, 0);
      gl.glRotatef(rotationD, 0, 0, 1);

      gl.glDisable(GL.GL_LIGHTING);
      gl.glDisable(GL.GL_DEPTH_TEST);
      gl.glDisable(GL.GL_CULL_FACE);
      gl.glEnable(GL.GL_BLEND);
      gl.glBlendFunc(GL.GL_SRC_ALPHA, GL.GL_ONE_MINUS_SRC_ALPHA);
      gl.glPolygonMode(GL.GL_FRONT_AND_BACK, GL.GL_FILL);
      gl.glEnable(GL.GL_TEXTURE_2D);

      MemorySegment textureId = arena.allocate(ValueLayout.JAVA_INT);
      gl.glGenTextures(1, textureId);
      gl.glBindTexture(GL.GL_TEXTURE_2D, textureId.get(ValueLayout.JAVA_INT, 0));
      gl.glTexParameteri(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MIN_FILTER, GL.GL_LINEAR);
      gl.glTexParameteri(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MAG_FILTER, GL.GL_LINEAR);
      gl.glTexEnvi(GL.GL_TEXTURE_ENV, GL.GL_TEXTURE_ENV_MODE, GL.GL_MODULATE);
      gl.glPixelStorei(GL.GL_UNPACK_ALIGNMENT, 4);
      gl.glTexImage2D(GL.GL_TEXTURE_2D, 0, GL.GL_RGBA, width, height, 0, GL.GL_RGBA,
          GL.GL_UNSIGNED_BYTE, toRGBA(arena, image));

      float x1 = x0 + width;
      float y1 = y0 + height;

      gl.glColor4f(1, 1, 1, 1);
      gl.glBegin(GL.GL_QUADS);
      gl.glTexCoord2f(0, 0);
      gl.glVertex2f(x0, y0);
      gl.glTexCoord2f(1, 0);
      gl.glVertex2f(x1, y0);
      gl.glTexCoord2f(1, 1);
      gl.glVertex2f(x1, y1);
      gl.glTexCoord2f(0, 1);
      gl.glVertex2f(x0, y1);
      gl.glEnd();

      gl.glDeleteTextures(1, textureId);

      gl.glMatrixMode(GL.GL_MODELVIEW);
      gl.glPopMatrix();
      gl.glMatrixMode(GL.GL_PROJECTION);
      gl.glPopMatrix();

      gl.glPopAttrib();
    }
  }

  /**
   * Draw a text with AWT in an image, with a font scaled by the {@link #getPixelScale() pixel
   * scale}. The dimensions of the returned image are hence in physical pixels.
   */
  public TextImage createTextImage(Font font, String text, Color color) {
    Font scaled = scale(font);
    FontMetrics fm = metrics(scaled);

    TextImage out = new TextImage();
    out.advance = fm.stringWidth(text);
    out.descent = fm.getDescent();

    int width = Math.max(1, out.advance);
    int height = Math.max(1, fm.getAscent() + fm.getDescent());

    out.image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
    Graphics2D g = out.image.createGraphics();
    if (antialiasing) {
      g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
          RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
    }
    g.setFont(scaled);
    g.setColor(color);
    g.drawString(text, 0, fm.getAscent());
    g.dispose();

    return out;
  }

  /** Width of a text in logical pixels, i.e. not scaled by the {@link #getPixelScale()}. */
  public int getTextWidth(Font font, String text) {
    return metrics(font).stringWidth(text);
  }

  protected Font scale(Font font) {
    return pixelScale == 1 ? font : font.deriveFont(font.getSize2D() * pixelScale);
  }

  protected FontMetrics metrics(Font font) {
    BufferedImage image = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
    Graphics2D g = image.createGraphics();
    try {
      return g.getFontMetrics(font);
    } finally {
      g.dispose();
    }
  }

  protected int[] getViewport(GL gl) {
    try (Arena arena = Arena.ofConfined()) {
      MemorySegment viewport = arena.allocate(ValueLayout.JAVA_INT, 4);
      gl.glGetIntegerv(GL.GL_VIEWPORT, viewport);
      return viewport.toArray(ValueLayout.JAVA_INT);
    }
  }

  /** Convert an AWT image to RGBA pixels, bottom row first as expected by OpenGL. */
  protected static MemorySegment toRGBA(Arena arena, BufferedImage image) {
    int width = image.getWidth();
    int height = image.getHeight();
    MemorySegment pixels = arena.allocate((long) width * height * 4);

    int[] row = new int[width];

    for (int y = 0; y < height; y++) {
      image.getRGB(0, y, width, 1, row, 0, width);

      // OpenGL reads rows from bottom to top
      long offset = (long) (height - 1 - y) * width * 4;

      for (int x = 0; x < width; x++) {
        int argb = row[x];
        long i = offset + x * 4L;
        pixels.set(ValueLayout.JAVA_BYTE, i, (byte) ((argb >> 16) & 0xFF));
        pixels.set(ValueLayout.JAVA_BYTE, i + 1, (byte) ((argb >> 8) & 0xFF));
        pixels.set(ValueLayout.JAVA_BYTE, i + 2, (byte) (argb & 0xFF));
        pixels.set(ValueLayout.JAVA_BYTE, i + 3, (byte) ((argb >> 24) & 0xFF));
      }
    }
    return pixels;
  }

  /**
   * Scale applied to fonts to draw glyphs, e.g. 2 on a HiDPI screen. Non positive or undefined
   * values are replaced by 1.
   */
  public void setPixelScale(float pixelScale) {
    this.pixelScale = (Float.isNaN(pixelScale) || pixelScale <= 0) ? 1 : pixelScale;
  }

  public float getPixelScale() {
    return pixelScale;
  }

  public boolean isAntialiasing() {
    return antialiasing;
  }

  public void setAntialiasing(boolean antialiasing) {
    this.antialiasing = antialiasing;
  }

  /** A text drawn in an image, with metrics in physical pixels. */
  public static class TextImage {
    protected BufferedImage image;
    protected int descent;
    protected int advance;

    public BufferedImage getImage() {
      return image;
    }

    public int getWidth() {
      return image.getWidth();
    }

    public int getHeight() {
      return image.getHeight();
    }

    /** Distance from the baseline to the bottom of the image. */
    public int getDescent() {
      return descent;
    }

    /** Distance from the left of the text to the position following it on the baseline. */
    public int getAdvance() {
      return advance;
    }
  }
}
