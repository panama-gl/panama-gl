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
package panamagl.factory;

import org.junit.Assert;
import org.junit.Test;
import panamagl.offscreen.FBO;
import panamagl.offscreen.OffscreenRenderer;
import panamagl.opengl.GL;
import panamagl.opengl.GLContext;
import panamagl.platform.Platform;

public class TestPanamaGLFactory {

  @Test
  public void select() {
    MockFactory p1 = new MockFactoryMac();
    MockFactory p2 = new MockFactoryWin();
    
    
    
    Assert.assertEquals(p1.getClass(), PanamaGLFactory.selectFor(Platform.MACOS).getClass());
    Assert.assertEquals(p2.getClass(), PanamaGLFactory.selectFor(Platform.WINDOWS).getClass());
  }

  public static class MockFactoryWin extends MockFactory implements PanamaGLFactory{
    public MockFactoryWin() {
      super(Platform.WINDOWS);
    }
  }
  public static class MockFactoryMac extends MockFactory implements PanamaGLFactory{
    public MockFactoryMac() {
      super(Platform.MACOS);
    }
  }
  
  public static class MockFactory extends APanamaGLFactory implements PanamaGLFactory{
    Platform platform = Platform.UNIX;
    
    public MockFactory(Platform platform) {
      super();
      this.platform = platform;
    }
    public MockFactory() {
      super();
    }
    
    public Platform getPlatform() {
      return platform;
    }
    @Override
    public OffscreenRenderer newOffscreenRenderer() {
      // TODO Auto-generated method stub
      return null;
    }
    
    @Override
    public GLContext newGLContext() {
      // TODO Auto-generated method stub
      return null;
    }
    
    @Override
    public GL newGL() {
      // TODO Auto-generated method stub
      return null;
    }
    
    @Override
    public FBO newFBO(int width, int height) {
      // TODO Auto-generated method stub
      return null;
    }
    
    @Override
    public boolean matches(Platform os) {
      // TODO Auto-generated method stub
      return platform.equals(os);
    }
    
    @Override
    public void destroyContext() {
      // TODO Auto-generated method stub
      
    }
  }
  
}
