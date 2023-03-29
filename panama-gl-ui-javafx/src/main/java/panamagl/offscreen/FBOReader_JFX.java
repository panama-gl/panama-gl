package panamagl.offscreen;

import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import javafx.scene.image.PixelFormat;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import panamagl.GLCanvas;
import panamagl.Image;
import panamagl.image.JFXImage;
import panamagl.opengl.GL;

// https://docs.oracle.com/javafx/2/image_ops/jfxpub-image_ops.htm
// https://stackoverflow.com/questions/38095984/convert-javafx-image-object-to-byte-array
public class FBOReader_JFX extends AFBOReader implements FBOReader{
  FBOReader_AWT reader = new FBOReader_AWT();

  //AWTImage i = reader.read(fbo, gl, canvas);
  //WritableImage image = SwingFXUtils.toFXImage(i.getImage(), null);

  @Override
  public Image<?> read(FBO fbo, GL gl, GLCanvas canvas) {
    int width = fbo.getWidth();
    int height = fbo.getHeight();    
    
    MemorySegment pixels = fbo.readPixels(gl);
    WritableImage image = new WritableImage(width, height);
    PixelWriter writer = image.getPixelWriter();
    
    PixelFormat<ByteBuffer> formatB = PixelFormat.getByteBgraInstance();
    byte[] bixels = pixels.toArray(ValueLayout.JAVA_BYTE);
    writer.setPixels(0, 0, width, height, formatB, bixels, 0, width*4);

    /*PixelFormat<IntBuffer> formatI = PixelFormat.getIntArgbInstance();
    int[] iixels = pixels.toArray(ValueLayout.JAVA_INT);
    writer.setPixels(0, 0, width, height, formatI, iixels, 0, width*4);*/
    
    return new JFXImage(image);
  }

}
