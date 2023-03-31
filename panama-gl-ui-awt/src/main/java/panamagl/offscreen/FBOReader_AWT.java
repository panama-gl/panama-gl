package panamagl.offscreen;

import java.awt.image.BufferedImage;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import java.lang.foreign.ValueLayout.OfByte;
import java.nio.ByteOrder;
import panamagl.Debug;
import panamagl.image.AWTImage;
import panamagl.opengl.GL;
import panamagl.utils.ByteUtils;
import panamagl.utils.GraphicsUtils;

public class FBOReader_AWT implements FBOReader{

  // supposed to copy to BufferedImage faster when true
  // using false allows to make copy by tweaking bytes
  // which is useful for debugging
  protected boolean arrayExport = true;

  protected boolean debug = Debug.check(FBOReader.class, FBOReader_AWT.class);
  
  @Override
  public AWTImage read(FBO fbo, GL gl) {
    MemorySegment pixels = fbo.readPixels(gl);
    
    
    int width = fbo.getWidth();
    int height = fbo.getHeight();
    
    if(width==0 || height==0) {
      return null;
    }
    
    // Try an image format derived from default screen/gpu to avoid conversion
    BufferedImage out = GraphicsUtils.createCompatibleImage(width, height);


    // Copy pixels to buffered image
    if (arrayExport)
      fromBGRABufferToImageArray(pixels, out, width, height);
    else {
      int channels = 4;
      fromBGRABufferToImage(pixels, out, width, height, channels);
    }
    
    //if(flipY)
    //  out = ImageUtils.flipVertically(out);
    

    Debug.debug(debug, "FBOReader: Image created !");


    // FIXME : Not mapped exception is not relevant
    // FIXME : See if later versions of Panama do not throw exception
    //Debug.debug(debug, "FBO.pixelsRead state - loaded:" + pixelsRead.isLoaded() + " mapped:" + pixelsRead.isMapped() + " native:" + pixelsRead.isNative());
    Debug.debug(debug, "FBOReader.pixels state - mapped:" + pixels.isMapped() + " native:" + pixels.isNative());

    
    return new AWTImage(out);
  }

  public boolean isArrayExport() {
    return arrayExport;
  }

  public void setArrayExport(boolean arrayExport) {
    this.arrayExport = arrayExport;
  }
  
  /**
   * Faster? to be evaluated Read a BGRA (GL.GL_BGRA()) pixel buffer and export its content to a
   * {@link BufferedImage}.
   *
   * Warning : flipped
   */
  protected void fromBGRABufferToImageArray(MemorySegment pixelsBuffer, BufferedImage out, int width, int height) {
    int[] px = pixelsBuffer.toArray(ValueLayout.JAVA_INT);
    out.setRGB(0, 0, width, height, px, 0, width);
    
    /*Graphics2D g2d = out.createGraphics();
    System.out.println("AWTImageCopy scale : " + GraphicsUtils.getPixelScaleX(g2d));
    g2d.dispose();*/

  }

  /**
   * Read a BGRA (GL.GL_BGRA()) pixel buffer and export its content to a {@link BufferedImage}.
   *
   * @param pixelsBuffer
   * @param out
   */
  protected void fromBGRABufferToImage(MemorySegment pixelsBuffer, BufferedImage out, int width, int height, int channels) {
    int nPixels = width * height;
    int k = 0;

    /*Graphics2D g2d = out.createGraphics();
    System.out.println("AWTImageCopy scale : " + GraphicsUtils.getPixelScaleX(g2d));
    g2d.dispose();*/
    
    OfByte byteHandle = ValueLayout.JAVA_BYTE.withOrder(ByteOrder.nativeOrder());

    for (int i = 0; i < nPixels * channels; i += channels) {
      // BGRA as specified by "format" field
      byte byB = pixelsBuffer.get(byteHandle, i);
      byte byG = pixelsBuffer.get(byteHandle, i + 1);
      byte byR = pixelsBuffer.get(byteHandle, i + 2);
      byte byA = pixelsBuffer.get(byteHandle, i + 3);
      //byte non = 0;
      //byte one = (byte) 0xff;
      int rgba = ByteUtils.RGBAtoIntARGB(byR, byG, byB, byA); // ARGB
      // rgba = ByteUtils.RGBAtoIntARGB(byR, non, non, one);
      // rgba = ByteUtils.RGBAtoIntARGB(non, byG, non, one);
      // rgba = ByteUtils.RGBAtoIntARGB(non, non, byB, one);

      // Pixel position
      int h = k % width;
      int w = k / width;

      out.setRGB(w, h, rgba);

      // Console out
      boolean console = false;

      if (console) {
        int intB = ByteUtils.BtoI(byB);
        int intG = ByteUtils.BtoI(byG);
        int intR = ByteUtils.BtoI(byR);
        int intA = ByteUtils.BtoI(byA);

        int red = ByteUtils.ItoR(intR);
        int green = ByteUtils.ItoG(intG);
        int blue = ByteUtils.ItoB(intB);
        int alpha = ByteUtils.ItoA(intA);

        System.out
            .println(w + "," + h + " : \t r=" + red + " g=" + green + " b=" + blue + " a=" + alpha);
      }
      k++;
    }
  }

}
