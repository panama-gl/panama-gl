package jextract.gl.api.panamagl;

import org.junit.Test;
import jextract.gl.APILayout;

public class TestGenerateAPI {
  @Test
  public void test() throws Exception {
    APILayout layout = new PanamaGLLayout("./target/panama-gl/");

    GenerateAPI gen = new GenerateAPI();
    gen.run(layout);
    
    //Assert.

  }
}
