package jextract.gl;

import org.junit.Test;
import org.junit.Assert;
import jextract.gl.APIPlatform.OS;

public class TestAPIPlatform {
  @Test
  public void test() {
    Assert.assertEquals("linux", new APIPlatform(OS.linux).getName());
    Assert.assertEquals("macOS", new APIPlatform(OS.macOS).getName());
    Assert.assertEquals("windows", new APIPlatform(OS.windows).getName());
  }
}
