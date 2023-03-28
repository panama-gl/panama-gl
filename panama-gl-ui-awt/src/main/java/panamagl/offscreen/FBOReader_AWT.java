package panamagl.offscreen;

import java.awt.image.BufferedImage;
import java.lang.foreign.MemorySegment;
import panamagl.Debug;
import panamagl.GLCanvas;
import panamagl.canvas.AWTImage;
import panamagl.opengl.GL;
import panamagl.utils.AWTImageCopy;
import panamagl.utils.GraphicsUtils;
import panamagl.utils.ImageUtils;

public class FBOReader_AWT extends AFBOReader implements FBOReader{

  // supposed to copy to BufferedImage faster when true
  // using false allows to make copy by tweaking bytes
  // which is useful for debugging
  protected boolean arrayExport = true;

  protected AWTImageCopy copy = new AWTImageCopy();

  protected boolean debug = Debug.check(FBOReader.class, FBOReader_AWT.class);
  
  @Override
  public AWTImage read(FBO fbo, GL gl, GLCanvas canvas) {
    MemorySegment pixels = fbo.readPixels(gl);
    
    
    int width = fbo.getWidth();
    int height = fbo.getHeight();
    
    // Try an image format derived from default screen/gpu to avoid conversion
    BufferedImage out = GraphicsUtils.createCompatibleImage(width, height);


    // Copy pixels to buffered image
    if (arrayExport)
      copy.fromBGRABufferToImageArray(pixels, out, width, height);
    else {
      int channels = 4;
      copy.fromBGRABufferToImage(pixels, out, width, height, channels);
    }
    
    if(flipY)
      out = ImageUtils.flipVertically(out);
    

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

}
