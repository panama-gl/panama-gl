package panamagl.offscreen;

import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import java.nio.ByteBuffer;
import javafx.scene.image.PixelFormat;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import panamagl.Debug;
import panamagl.image.JFXImage;
import panamagl.opengl.GL;


public class FBOReader_JFX implements FBOReader{
  protected boolean debug = Debug.check(FBOReader.class, FBOReader_JFX.class);


  protected WritableImage image;
  
  @Override
  public JFXImage read(FBO fbo, GL gl) {
    int width = fbo.getWidth();
    int height = fbo.getHeight();    
    
    MemorySegment pixels = fbo.readPixels(gl);
    
    if(image==null || image.getWidth()!=width || image.getHeight()!=height) {
      image = new WritableImage(width, height);
    }
    
    //WritableImage image = new WritableImage(width, height);
    PixelWriter writer = image.getPixelWriter();
    
    PixelFormat<ByteBuffer> formatB = PixelFormat.getByteBgraInstance();
    byte[] bixels = pixels.toArray(ValueLayout.JAVA_BYTE);
    writer.setPixels(0, 0, width, height, formatB, bixels, 0, width*4);

    /*PixelFormat<IntBuffer> formatI = PixelFormat.getIntArgbInstance();
    int[] iixels = pixels.toArray(ValueLayout.JAVA_INT);
    writer.setPixels(0, 0, width, height, formatI, iixels, 0, width*4);*/
    
    //pixels.unload();
    
    
    return new JFXImage(image);
  }

}
