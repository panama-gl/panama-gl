package jextract.gl;

import org.junit.Test;
import org.jzy3d.junit.Assert;
import jextract.gl.APIPlatform.CPU;
import jextract.gl.APIPlatform.OS;

public class TestAPIPlatform {
  @Test
  public void test() {
    Assert.assertEquals("linux_x64", new APIPlatform(OS.linux, CPU.x64).getName());
    Assert.assertEquals("linux_arm", new APIPlatform(OS.linux, CPU.arm).getName());
    Assert.assertEquals("macOS_x64", new APIPlatform(OS.macOS, CPU.x64).getName());
    Assert.assertEquals("macOS_arm", new APIPlatform(OS.macOS, CPU.arm).getName());
    Assert.assertEquals("windows_x32", new APIPlatform(OS.windows, CPU.x32).getName());
    Assert.assertEquals("windows_x64", new APIPlatform(OS.windows, CPU.x64).getName());
    Assert.assertEquals("windows_arm", new APIPlatform(OS.windows, CPU.arm).getName());
  }
}
