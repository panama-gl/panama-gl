package panamagl;

import org.junit.Assert;
import org.junit.Test;

public class TestDebug {
  @Test
  public void testFlag() {
    
    // Given DEBUG FLAG on a class given by command line
    System.setProperty("sun.java.command", "MyProgram -Dpanamagl.TestDebug$TestClass1");
    
    // When checking it same class, returns true
    //System.out.println(TestClass1.class.getName());
    Assert.assertTrue(Debug.check(TestClass1.class));
    
    // When checking another class, return false
    Assert.assertFalse(Debug.check(TestClass2.class));
    
    // When checking the two classes, return true
    Assert.assertTrue(Debug.check(TestClass1.class, TestClass2.class));


  }
  
  class TestClass1{}
  class TestClass2{}
}
