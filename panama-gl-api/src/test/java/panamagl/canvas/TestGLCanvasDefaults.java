/*******************************************************************************
 * Copyright (c) 2022, 2023 Martin Pernollet & contributors.
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
package panamagl.canvas;

import org.junit.Assert;
import org.junit.Test;
import panamagl.GLEventListener;
import panamagl.Image;
import panamagl.offscreen.OffscreenRenderer;
import panamagl.opengl.GL;
import panamagl.opengl.GLContext;
import panamagl.performance.RenderCounter;

/**
 * Verifies the {@link GLCanvas} default methods behave as documented for an implementation that
 * only overrides {@link #getWidth()}, {@link #getHeight()}, and the HiDPI-related methods.
 */
public class TestGLCanvasDefaults {

  @Test
  public void physicalSize_followsLogicalSize_whenHiDPIDisabled() {
    StubCanvas canvas = new StubCanvas(100, 50, new PixelScale(2.0, 2.0), false);
    Assert.assertEquals(100, canvas.getPhysicalWidth());
    Assert.assertEquals(50, canvas.getPhysicalHeight());
  }

  @Test
  public void physicalSize_isScaled_whenHiDPIEnabled() {
    StubCanvas canvas = new StubCanvas(100, 50, new PixelScale(2.0, 2.0), true);
    Assert.assertEquals(200, canvas.getPhysicalWidth());
    Assert.assertEquals(100, canvas.getPhysicalHeight());
  }

  @Test
  public void physicalSize_supportsFractionalScale() {
    StubCanvas canvas = new StubCanvas(100, 50, new PixelScale(1.5, 1.5), true);
    Assert.assertEquals(150, canvas.getPhysicalWidth());
    Assert.assertEquals(75, canvas.getPhysicalHeight());
  }

  @Test
  public void defaultMethods_areNoOpButCallable() {
    GLCanvas canvas = new GLCanvas() {
      @Override public void display() {}
      @Override public boolean isRendering() { return false; }
      @Override public GLEventListener getGLEventListener() { return null; }
      @Override public void setGLEventListener(GLEventListener listener) {}
      @Override public boolean isInitialized() { return false; }
      @Override public boolean isVisible() { return false; }
      @Override public GLContext getContext() { return null; }
      @Override public GL getGL() { return null; }
      @Override public RenderCounter getMonitoring() { return null; }
      @Override public int getWidth() { return 0; }
      @Override public int getHeight() { return 0; }
      @Override public void repaint() {}
      @Override public void setScreenshot(Image<?> image) {}
      @Override public Image<?> getScreenshot() { return null; }
      @Override public OffscreenRenderer getOffscreenRenderer() { return null; }
      @Override public void setOffscreenRenderer(OffscreenRenderer offscreen) {}
      @Override public void setFlip(Flip flip) {}
      @Override public Flip getFlip() { return null; }
    };

    Assert.assertEquals(PixelScale.IDENTITY, canvas.getPixelScale());
    Assert.assertTrue(canvas.isHiDPIEnabled());
    canvas.addPixelScaleListener((o, n) -> {});
    canvas.removePixelScaleListener((o, n) -> {});
    canvas.setHiDPIEnabled(false);
  }

  /** Minimal GLCanvas overriding only what's needed to test the HiDPI default methods. */
  private static class StubCanvas implements GLCanvas {
    private final int width, height;
    private final PixelScale scale;
    private final boolean hiDPI;

    StubCanvas(int width, int height, PixelScale scale, boolean hiDPI) {
      this.width = width;
      this.height = height;
      this.scale = scale;
      this.hiDPI = hiDPI;
    }

    @Override public PixelScale getPixelScale() { return scale; }
    @Override public boolean isHiDPIEnabled() { return hiDPI; }
    @Override public int getWidth() { return width; }
    @Override public int getHeight() { return height; }

    // Unused for these tests
    @Override public void display() {}
    @Override public boolean isRendering() { return false; }
    @Override public GLEventListener getGLEventListener() { return null; }
    @Override public void setGLEventListener(GLEventListener listener) {}
    @Override public boolean isInitialized() { return true; }
    @Override public boolean isVisible() { return true; }
    @Override public GLContext getContext() { return null; }
    @Override public GL getGL() { return null; }
    @Override public RenderCounter getMonitoring() { return null; }
    @Override public void repaint() {}
    @Override public void setScreenshot(Image<?> image) {}
    @Override public Image<?> getScreenshot() { return null; }
    @Override public OffscreenRenderer getOffscreenRenderer() { return null; }
    @Override public void setOffscreenRenderer(OffscreenRenderer offscreen) {}
    @Override public void setFlip(Flip flip) {}
    @Override public Flip getFlip() { return null; }
  }
}
