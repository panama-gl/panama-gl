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
package panamagl.utils;

import java.awt.BufferCapabilities;
import java.awt.Component;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.ImageCapabilities;
import java.awt.Transparency;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import javax.swing.SwingUtilities;

public class GraphicsUtils {
  /**
   * A draw string method allowing to bypass OS font rendering if noticing font rendering glitches.
   *
   * It may be worth invoking {@link #configureRenderingHints(Graphics2D)} right before.
   */
  public static void drawString(Graphics2D g2d, Font font, boolean useOSFontRendering,
      String string, int x, int y) {
    
    if (useOSFontRendering) {
      g2d.setFont(font);
      g2d.drawString(string, x, y);
    } else {
      FontRenderContext frc = g2d.getFontRenderContext();
      GlyphVector gv = font.createGlyphVector(frc, string);
      g2d.drawGlyphVector(gv, x, y);
    }
  }

  /** Compute string width using the Graphics2D instance of a hidden image. */
  public static int stringWidth(String string, Font font) {
    Graphics2D g = i.createGraphics();
    g.setFont(font);
    return stringWidth(g, string);
  }

  static BufferedImage i = new BufferedImage(1, 1, BufferedImage.TYPE_4BYTE_ABGR);

  public static int stringWidth(Graphics2D g2d, String string) {
    FontMetrics fm = g2d.getFontMetrics();
    if (fm != null) {
      return SwingUtilities.computeStringWidth(fm, string);

      // return fm.stringWidth(string);
    } else {
      return -1;
    }
  }

  public static Rectangle2D stringBounds(String string, Font font) {
    Graphics2D g = i.createGraphics();
    g.setFont(font);
    return stringBounds(g, string);
  }


  public static Rectangle2D stringBounds(Graphics2D g2d, String string) {
    FontMetrics fm = g2d.getFontMetrics();
    if (fm != null) {
      return fm.getStringBounds(string, g2d);
    } else {
      return null;
    }
  }

  public static double getPixelScaleX(Component component) {
    return getPixelScaleX((Graphics2D) component.getGraphics());
  }

  public static double getPixelScaleX(Graphics2D g2d) {
    if (g2d == null)
      return 1;
    AffineTransform globalTransform = g2d.getTransform();
    return globalTransform.getScaleX();
  }

  public static double getPixelScaleY(Component component) {
    return getPixelScaleY((Graphics2D) component.getGraphics());
  }

  public static double getPixelScaleY(Graphics2D g2d) {
    if (g2d == null)
      return 1;
    AffineTransform globalTransform = g2d.getTransform();
    return globalTransform.getScaleY();
  }


  public static BufferedImage createCompatibleImage(int width, int height) {
    GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
    GraphicsDevice device = env.getDefaultScreenDevice();
    GraphicsConfiguration config = device.getDefaultConfiguration();
    BufferedImage image = config.createCompatibleImage(width, height, Transparency.TRANSLUCENT);
    return image;
  }

  public static void printGraphicsEnvironment(String header) {
    System.out.println(header + " : sun.java2d.opengl=" + System.getProperty("sun.java2d.opengl"));
    System.out
        .println(header + " : sun.java2d.noddraw:" + System.getProperty("sun.java2d.noddraw"));

    GraphicsEnvironment graphEnv = GraphicsEnvironment.getLocalGraphicsEnvironment();
    GraphicsDevice[] graphDevsOrig = graphEnv.getScreenDevices();

    // GraphicsConfiguration gcDef = graphDevsOrig[0].getDefaultConfiguration();

    for (int i = 0; i < graphDevsOrig.length; i++) {
      System.out
          .println(header + " : Screen device # " + i + ": " + graphDevsOrig[i].getIDstring());
      GraphicsConfiguration[] graphConfs = graphDevsOrig[i].getConfigurations();

      for (int j = 0; j < graphConfs.length; j++) {
        GraphicsConfiguration gc = graphConfs[j];

        System.out.println(" Screen device # " + i + ", configuration # " + j + ":" + gc);

        print(gc);

        // BufferedImage buffy = config.createCompatibleImage(width, height,
        // Transparency.TRANSLUCENT);
        // Graphics g = buffy.getGraphics();

      }
    }
  }

  // see JoglContextTestCase in Jzy3D
  public static void print(GraphicsConfiguration gc) {
    System.out.println("" + gc);
    System.out.println("  ColorModel   : " + gc.getColorModel());

    ImageCapabilities ic = gc.getImageCapabilities();
    System.out.println("  Img Caps     : " + str(ic));
    System.out.println("  Bounds       : " + gc.getBounds());
    System.out.println("  Translucency : " + gc.isTranslucencyCapable());

    BufferCapabilities bc = gc.getBufferCapabilities();
    System.out.println("  Buffer caps / Back       : " + str(bc.getBackBufferCapabilities()));
    System.out.println("  Buffer caps / Front      : " + str(bc.getFrontBufferCapabilities()));
    System.out.println("  Buffer caps / FullScreen : " + bc.isFullScreenRequired());
  }

  public static String str(ImageCapabilities ic) {
    return "accelerated: " + ic.isAccelerated() + " true volatile: " + ic.isTrueVolatile();
  }
}
