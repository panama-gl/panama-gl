package panamagl.platform.natives;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestOpenGLImplementation {
  String previous;
  String previousOrigin;

  @Before
  public void before() {
    previous = OpenGLImplementation.current();
    previousOrigin = OpenGLImplementation.origin();
    OpenGLImplementation.reset();
  }

  @After
  public void after() {
    OpenGLImplementation.reset();
    if (previous != null)
      OpenGLImplementation.claim(previous, previousOrigin);
  }

  @Test
  public void sameImplementationCanBeClaimedByEveryContext() {
    assertNull(OpenGLImplementation.current());
    OpenGLImplementation.claim("system libGL", "GLX");
    OpenGLImplementation.claim("system libGL", "EGL");
    assertEquals("system libGL", OpenGLImplementation.current());
    assertEquals("GLX", OpenGLImplementation.origin());
  }

  @Test
  public void anotherImplementationIsRefused() {
    OpenGLImplementation.claim("Apple OpenGL", "/System/Library/Frameworks/OpenGL.framework");
    try {
      OpenGLImplementation.claim("Mesa (Homebrew)", "/opt/homebrew/opt/mesa/lib/libGL.dylib");
      fail();
    } catch (IllegalStateException e) {
      assertTrue(e.getMessage(), e.getMessage().contains("already uses Apple OpenGL"));
      assertTrue(e.getMessage(), e.getMessage().contains("Mesa (Homebrew)"));
    }
    // The first one stays
    assertEquals("Apple OpenGL", OpenGLImplementation.current());
  }
}
