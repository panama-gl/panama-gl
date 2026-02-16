package panamagl.offscreen;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.RGB;
import org.junit.Assert;
import org.junit.Test;
import panamagl.image.SWTImage;
import panamagl.opengl.GL;

/**
 * Tests for {@link FBOReader_SWT}, mirroring the structure of {@code TestFBOReader_JFX}.
 */
public class TestFBOReader_SWT {
  Arena arena = Arena.ofConfined();

  @Test
  public void read_returnsImageWithCorrectDimensions() {
    int WIDTH = 800;
    int HEIGHT = 600;
    int CHANNELS = 4;
    int nBytes = WIDTH * HEIGHT * CHANNELS;

    // Given
    MemorySegment pixels = arena.allocate(nBytes);

    FBO fbo = mock(FBO.class);
    when(fbo.getWidth()).thenReturn(WIDTH);
    when(fbo.getHeight()).thenReturn(HEIGHT);
    when(fbo.readPixels(any())).thenReturn(pixels);

    GL gl = mock(GL.class);

    FBOReader_SWT reader = new FBOReader_SWT();

    // When
    SWTImage image = reader.read(fbo, gl);

    // Then
    Assert.assertNotNull(image);

    ImageData id = image.getImage();
    Assert.assertEquals(WIDTH, id.width);
    Assert.assertEquals(HEIGHT, id.height);
  }

  @Test
  public void read_zeroPixelsAreBlackTransparent() {
    int WIDTH = 4;
    int HEIGHT = 4;
    int nBytes = WIDTH * HEIGHT * 4;

    // Given: all-zero pixel buffer (BGRA = 0,0,0,0)
    MemorySegment pixels = arena.allocate(nBytes);

    FBO fbo = mock(FBO.class);
    when(fbo.getWidth()).thenReturn(WIDTH);
    when(fbo.getHeight()).thenReturn(HEIGHT);
    when(fbo.readPixels(any())).thenReturn(pixels);

    GL gl = mock(GL.class);

    FBOReader_SWT reader = new FBOReader_SWT();

    // When
    SWTImage image = reader.read(fbo, gl);

    // Then pixel (0,0) should be black (R=0, G=0, B=0) with alpha=0
    ImageData id = image.getImage();
    int pixel = id.getPixel(0, 0);
    Assert.assertEquals(0, pixel);
    Assert.assertEquals(0, id.getAlpha(0, 0));
  }

  @Test
  public void read_correctColorMapping() {
    int WIDTH = 2;
    int HEIGHT = 1;

    // Given: BGRA buffer with a known pixel
    // Pixel 0: B=0xFF, G=0x00, R=0x00, A=0xFF → should display as blue
    // Pixel 1: B=0x00, G=0xFF, R=0xFF, A=0x80 → should display as yellow, half-transparent
    byte[] bgra = {
        (byte) 0xFF, 0x00, 0x00, (byte) 0xFF,  // blue pixel
        0x00, (byte) 0xFF, (byte) 0xFF, (byte) 0x80   // yellow pixel
    };
    MemorySegment pixels = arena.allocate(bgra.length);
    pixels.copyFrom(MemorySegment.ofArray(bgra));

    FBO fbo = mock(FBO.class);
    when(fbo.getWidth()).thenReturn(WIDTH);
    when(fbo.getHeight()).thenReturn(HEIGHT);
    when(fbo.readPixels(any())).thenReturn(pixels);

    GL gl = mock(GL.class);

    FBOReader_SWT reader = new FBOReader_SWT();

    // When
    SWTImage image = reader.read(fbo, gl);

    // Then
    ImageData id = image.getImage();

    // Pixel 0: blue (R=0, G=0, B=255)
    RGB rgb0 = id.palette.getRGB(id.getPixel(0, 0));
    Assert.assertEquals("Red component of blue pixel", 0, rgb0.red);
    Assert.assertEquals("Green component of blue pixel", 0, rgb0.green);
    Assert.assertEquals("Blue component of blue pixel", 255, rgb0.blue);
    Assert.assertEquals("Alpha of blue pixel", 255, id.getAlpha(0, 0));

    // Pixel 1: yellow (R=255, G=255, B=0)
    RGB rgb1 = id.palette.getRGB(id.getPixel(1, 0));
    Assert.assertEquals("Red component of yellow pixel", 255, rgb1.red);
    Assert.assertEquals("Green component of yellow pixel", 255, rgb1.green);
    Assert.assertEquals("Blue component of yellow pixel", 0, rgb1.blue);
    Assert.assertEquals("Alpha of yellow pixel", 128, id.getAlpha(1, 0));
  }

  @Test
  public void read_returnsNullForZeroDimensions() {
    FBO fbo = mock(FBO.class);
    when(fbo.getWidth()).thenReturn(0);
    when(fbo.getHeight()).thenReturn(0);

    GL gl = mock(GL.class);

    FBOReader_SWT reader = new FBOReader_SWT();

    Assert.assertNull(reader.read(fbo, gl));
  }

  @Test
  public void read_reusesImageDataWhenSameDimensions() {
    int WIDTH = 10;
    int HEIGHT = 10;
    int nBytes = WIDTH * HEIGHT * 4;

    MemorySegment pixels = arena.allocate(nBytes);

    FBO fbo = mock(FBO.class);
    when(fbo.getWidth()).thenReturn(WIDTH);
    when(fbo.getHeight()).thenReturn(HEIGHT);
    when(fbo.readPixels(any())).thenReturn(pixels);

    GL gl = mock(GL.class);

    FBOReader_SWT reader = new FBOReader_SWT();

    // When: read twice with same dimensions
    SWTImage first = reader.read(fbo, gl);
    SWTImage second = reader.read(fbo, gl);

    // Then: same underlying ImageData instance is reused
    Assert.assertSame(first.getImage(), second.getImage());
  }

  @Test
  public void read_createsNewImageDataWhenDimensionsChange() {
    GL gl = mock(GL.class);

    // First read: 10x10
    MemorySegment pixels1 = arena.allocate(10 * 10 * 4);
    FBO fbo = mock(FBO.class);
    when(fbo.getWidth()).thenReturn(10);
    when(fbo.getHeight()).thenReturn(10);
    when(fbo.readPixels(any())).thenReturn(pixels1);

    FBOReader_SWT reader = new FBOReader_SWT();
    SWTImage first = reader.read(fbo, gl);

    // Second read: 20x20
    MemorySegment pixels2 = arena.allocate(20 * 20 * 4);
    when(fbo.getWidth()).thenReturn(20);
    when(fbo.getHeight()).thenReturn(20);
    when(fbo.readPixels(any())).thenReturn(pixels2);

    SWTImage second = reader.read(fbo, gl);

    // Then: different ImageData instances
    Assert.assertNotSame(first.getImage(), second.getImage());
    Assert.assertEquals(20, second.getImage().width);
    Assert.assertEquals(20, second.getImage().height);
  }
}
