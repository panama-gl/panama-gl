package panamagl.renderers.text;

import java.awt.Color;
import java.awt.Font;
import org.junit.Assert;
import org.junit.Test;
import panamagl.renderers.image.ForeignImage;

public class TestBasicTextRenderer {
  @Test
  public void createForeignImage() {
    BasicTextRenderer r = new BasicTextRenderer();
    
    ForeignImage i = r.createForeignImage(new Font("Arial", Font.PLAIN, 12), "Coucou", Color.BLUE);
    
    Assert.assertNotNull(i.image);
    Assert.assertNotNull(i.segment);
  }
}
