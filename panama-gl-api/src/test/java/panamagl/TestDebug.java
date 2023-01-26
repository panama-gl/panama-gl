/*******************************************************************************
 * Copyright (c) 2022, 2023 Martin Pernollet & contributors.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301, USA
 *******************************************************************************/
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
