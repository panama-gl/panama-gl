package panamagl;

import org.junit.Assert;
import org.junit.Test;

public class TestDebug {
  @Test
  public void testFlag() {
    
    // Given TRUE flag
    //System.setProperty("-Dorg.pack.Myclass", "true");
    
    
    System.setProperty("sun.java.command", "MyProgram -Dorg.pack.Myclass");
    Assert.assertTrue(Debug.check("org.pack.Myclass"));
    
    // Given NO flag
  
    Assert.assertFalse(Debug.check("-D.NOT.DEBUGGED"));

  }
}
