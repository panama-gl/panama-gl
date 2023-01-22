package panamagl.macos.cgl;

import java.lang.foreign.ValueLayout;
import org.junit.Test;
import org.jzy3d.os.OperatingSystem;
import junit.framework.Assert;

//VM ARGS : -XstartOnFirstThread --enable-native-access=ALL-UNNAMED --add-modules jdk.incubator.foreign -Djava.library.path=.:/System/Library/Frameworks/OpenGL.framework/Versions/Current/Libraries/

public class TestCGLContext {
  @Test
  public void createCGLContext() {
    if (!new OperatingSystem().isMac())
      return;
    
    // Given
    CGLContext_macOS cgl = new CGLContext_macOS();
    
    // When
    cgl.init();
    
    
    // Then
    int[] attribs = cgl.attribs.toArray(ValueLayout.JAVA_INT);
    Assert.assertEquals(73, attribs[0]); // 
    Assert.assertEquals(99, attribs[1]);
    Assert.assertEquals(12800, attribs[2]); // OpenGL version
    Assert.assertEquals(0, attribs[3]);

    // Cleanup
    cgl.destroy();
  }
}
