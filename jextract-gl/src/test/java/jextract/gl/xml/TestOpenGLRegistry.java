package jextract.gl.xml;

import java.util.List;
import org.junit.Test;
import jextract.gl.xml.model.CommandWrap;
import junit.framework.Assert;

public class TestOpenGLRegistry {
  @Test
  public void test() throws Exception {
    OpenGLRegistry registry = new OpenGLRegistry();

    List<CommandWrap> cw = registry.getCommands();
    Assert.assertEquals(3291, cw.size());
  }
}
