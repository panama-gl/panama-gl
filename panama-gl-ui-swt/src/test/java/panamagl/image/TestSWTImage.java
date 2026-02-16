package panamagl.image;

import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.PaletteData;
import org.junit.Assert;
import org.junit.Test;

public class TestSWTImage {

  @Test
  public void getImage_returnsImageData() {
    ImageData data = new ImageData(100, 50, 32, new PaletteData(0xFF0000, 0xFF00, 0xFF));
    SWTImage image = new SWTImage(data);

    Assert.assertSame(data, image.getImage());
  }

  @Test
  public void getWidth_returnsImageDataWidth() {
    ImageData data = new ImageData(800, 600, 32, new PaletteData(0xFF0000, 0xFF00, 0xFF));
    SWTImage image = new SWTImage(data);

    Assert.assertEquals(800, image.getWidth());
  }

  @Test
  public void getHeight_returnsImageDataHeight() {
    ImageData data = new ImageData(800, 600, 32, new PaletteData(0xFF0000, 0xFF00, 0xFF));
    SWTImage image = new SWTImage(data);

    Assert.assertEquals(600, image.getHeight());
  }

  @Test
  public void setImageData_changesImage() {
    ImageData first = new ImageData(100, 50, 32, new PaletteData(0xFF0000, 0xFF00, 0xFF));
    ImageData second = new ImageData(200, 100, 32, new PaletteData(0xFF0000, 0xFF00, 0xFF));

    SWTImage image = new SWTImage(first);
    Assert.assertSame(first, image.getImage());

    image.setImageData(second);
    Assert.assertSame(second, image.getImage());
    Assert.assertEquals(200, image.getWidth());
    Assert.assertEquals(100, image.getHeight());
  }

  @Test
  public void save_writesFile() throws Exception {
    // Create a small image with known pixel
    ImageData data = new ImageData(2, 2, 32, new PaletteData(0xFF0000, 0xFF00, 0xFF));
    data.setPixel(0, 0, 0xFF0000); // red
    data.setPixel(1, 0, 0x00FF00); // green
    data.setPixel(0, 1, 0x0000FF); // blue
    data.setPixel(1, 1, 0xFFFFFF); // white

    SWTImage image = new SWTImage(data);

    String path = "target/test-swt-image.png";
    image.save(path);

    java.io.File file = new java.io.File(path);
    Assert.assertTrue("Saved file should exist", file.exists());
    Assert.assertTrue("Saved file should not be empty", file.length() > 0);

    // Clean up
    file.delete();
  }
}
