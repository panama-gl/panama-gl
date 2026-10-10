/*******************************************************************************
 * Copyright (c) 2022, 2023 Martin Pernollet & contributors.
 *
 * This library is free software; you can redistribute it and/or modify it under the terms of the
 * GNU Lesser General Public License as published by the Free Software Foundation; either version
 * 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License along with this library;
 * if not, write to the Free Software Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA
 * 02110-1301, USA
 *******************************************************************************/
package panamagl.canvas;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.awt.Color;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferedImage;
import org.junit.Assert;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;
import panamagl.canvas.GLCanvas.Flip;
import panamagl.factory.PanamaGLFactory;
import panamagl.image.AWTImage;
import panamagl.offscreen.AOffscreenRenderer;
import panamagl.offscreen.FBO;
import panamagl.offscreen.FBOReader_AWT;
import panamagl.opengl.GL;
import panamagl.opengl.GLContext;

/** The screenshot must be oriented as the image displayed by the canvas. */
public class TestGLCanvasSwing_Screenshot {

  @Before
  public void requireHeadful() {
    Assume.assumeFalse(GraphicsEnvironment.isHeadless());
  }

  private GLCanvasSwing newCanvas() {
    PanamaGLFactory factory = mock(PanamaGLFactory.class);
    when(factory.newOffscreenRenderer(any()))
        .thenReturn(new AOffscreenRenderer(factory, new FBOReader_AWT()));
    when(factory.newGL()).thenReturn(mock(GL.class));
    when(factory.newGLContext()).thenReturn(mock(GLContext.class));
    when(factory.newFBO(anyInt(), anyInt())).thenReturn(mock(FBO.class));
    return new GLCanvasSwing(factory);
  }

  /** An image read from GL : red on the first row, which is the bottom of the GL frame */
  private BufferedImage glImage() {
    BufferedImage image = new BufferedImage(4, 4, BufferedImage.TYPE_INT_ARGB);
    for (int x = 0; x < 4; x++)
      image.setRGB(x, 0, Color.RED.getRGB());
    return image;
  }

  @Test
  public void screenshotIsFlippedAsDisplayed() {
    GLCanvasSwing canvas = newCanvas();
    canvas.setFlip(Flip.VERTICAL);
    canvas.setScreenshot(new AWTImage(glImage()));

    BufferedImage screenshot = (BufferedImage) canvas.getScreenshot().getImage();

    Assert.assertEquals(Color.RED.getRGB(), screenshot.getRGB(0, 3));
    Assert.assertNotEquals(Color.RED.getRGB(), screenshot.getRGB(0, 0));
  }

  @Test
  public void screenshotIsNotFlippedIfNotDisplayedFlipped() {
    GLCanvasSwing canvas = newCanvas();
    canvas.setFlip(Flip.NONE);
    canvas.setScreenshot(new AWTImage(glImage()));

    BufferedImage screenshot = (BufferedImage) canvas.getScreenshot().getImage();

    Assert.assertEquals(Color.RED.getRGB(), screenshot.getRGB(0, 0));
  }

  @Test
  public void screenshotIsFlippedHorizontallyAsDisplayed() {
    GLCanvasSwing canvas = newCanvas();
    canvas.setFlip(Flip.HORIZONTAL);

    // An image read from GL : red on the first column
    BufferedImage image = new BufferedImage(4, 4, BufferedImage.TYPE_INT_ARGB);
    for (int y = 0; y < 4; y++)
      image.setRGB(0, y, Color.RED.getRGB());
    canvas.setScreenshot(new AWTImage(image));

    BufferedImage screenshot = (BufferedImage) canvas.getScreenshot().getImage();

    Assert.assertEquals(Color.RED.getRGB(), screenshot.getRGB(3, 0));
    Assert.assertNotEquals(Color.RED.getRGB(), screenshot.getRGB(0, 0));
  }

  @Test
  public void noScreenshotBeforeRendering() {
    Assert.assertNull(newCanvas().getScreenshot());
  }
}
