package panamagl;

import org.junit.Assert;
import org.junit.Test;

public class TestDebug {
  @Test
  public void testFlag() {
    
    // Given TRUE flag
    System.setProperty("-Dorg.pack.Myclass", "true");
    
    Assert.assertTrue(Debug.check("-Dorg.pack.Myclass"));

    
    // Given FALSE flag
    System.setProperty("-Dorg.pack.Myclass", "false");
    
    Assert.assertFalse(Debug.check("-Dorg.pack.Myclass"));

    
    // Given NO flag
  
    Assert.assertFalse(Debug.check("-D.NOT.DEBUGGED"));

  }
}
