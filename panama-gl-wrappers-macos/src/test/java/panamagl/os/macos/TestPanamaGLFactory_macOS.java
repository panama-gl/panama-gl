package panamagl.os.macos;

import org.junit.Assert;
import org.junit.Test;
import org.jzy3d.os.OperatingSystem;
import panamagl.factory.PanamaGLFactory;

public class TestPanamaGLFactory_macOS {
  @Test
  public void test() {
    if (!new OperatingSystem().isMac())
      return;
  
    PanamaGLFactory f = PanamaGLFactory.select();
    
    boolean matched = f instanceof PanamaGLFactory_macOS;
    
    Assert.assertTrue(matched);

    // Issue on context init
    //Assert.assertNotNull(f.newGLContext());

    Assert.assertNotNull(f.newGL());
    Assert.assertNotNull(f.newOffscreenRenderer());
    Assert.assertNotNull(f.newFBO(800, 600));
    Assert.assertNotNull(f.newCanvasSwing());

    ;
  }
}
