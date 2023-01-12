package jextract.gl.java;

import org.junit.Test;
import junit.framework.Assert;

public class TestAcceptsMethodGL {
  @Test
  public void test() {
    
    AcceptsMethodGL a = new AcceptsMethodGL();
    
    Assert.assertTrue(a.acceptsName("glBegin"));
    Assert.assertTrue(a.acceptsName("gluTruc"));
    Assert.assertTrue(a.acceptsName("glutMachinruc"));
    
    Assert.assertFalse(a.acceptsName("GL_CONSTANT"));
    Assert.assertFalse(a.acceptsName("GLU_CONSTANT"));
    Assert.assertFalse(a.acceptsName("GLUT_CONSTANT"));
    Assert.assertFalse(a.acceptsName("WhateverWithUpperCaseFirstLetter"));
    
    Assert.assertFalse(a.acceptsName("wait"));
    Assert.assertFalse(a.acceptsName("mbstowcs"));

  }
}
