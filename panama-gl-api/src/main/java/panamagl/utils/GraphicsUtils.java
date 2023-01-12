package panamagl.utils;

import java.awt.BufferCapabilities;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.ImageCapabilities;
import java.awt.Transparency;
import java.awt.image.BufferedImage;

public class GraphicsUtils {
  public static BufferedImage createCompatibleImage(int width, int height) {
    GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
    GraphicsDevice device = env.getDefaultScreenDevice();
    GraphicsConfiguration config = device.getDefaultConfiguration();
    BufferedImage image = config.createCompatibleImage(width, height, Transparency.TRANSLUCENT);
    return image;
    //Graphics g = buffy.getGraphics();
  }
  
  public static void printGraphicsEnvironment(String header) {
    System.out.println(header + " : sun.java2d.opengl=" + System.getProperty("sun.java2d.opengl"));
    System.out.println(header + " : sun.java2d.noddraw:" + System.getProperty("sun.java2d.noddraw"));

    GraphicsEnvironment graphEnv = GraphicsEnvironment.getLocalGraphicsEnvironment();
    GraphicsDevice[] graphDevsOrig = graphEnv.getScreenDevices();

    //GraphicsConfiguration gcDef = graphDevsOrig[0].getDefaultConfiguration();

    for (int i = 0; i < graphDevsOrig.length; i++) {
        System.out.println(header + " : Screen device # " + i + ": " + graphDevsOrig[i].getIDstring());
        GraphicsConfiguration[] graphConfs = graphDevsOrig[i].getConfigurations();

        for (int j = 0; j < graphConfs.length; j++) {
            GraphicsConfiguration gc = graphConfs[j];

            System.out.println(" Screen device # " + i + ", configuration # " + j + ":" + gc);

            print(gc);
            
          //BufferedImage buffy = config.createCompatibleImage(width, height, Transparency.TRANSLUCENT);
            //Graphics g = buffy.getGraphics();
            
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
    System.out.println("  Translucency :  " + gc.isTranslucencyCapable());

    BufferCapabilities bc = gc.getBufferCapabilities();
    System.out.println("  Buffer caps / Back:  " + str(bc.getBackBufferCapabilities()));
    System.out.println("  Buffer caps / Front:  " + str(bc.getFrontBufferCapabilities()));
    System.out.println("  Buffer caps / FullScreen:  " + bc.isFullScreenRequired());
  }

  public static String str(ImageCapabilities ic) {
    return "accelerated: " + ic.isAccelerated()
    + " true volatile: " + ic.isTrueVolatile();
  }
}
