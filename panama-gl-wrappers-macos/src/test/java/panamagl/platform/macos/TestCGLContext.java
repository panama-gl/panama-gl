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
package panamagl.platform.macos;

import java.lang.foreign.ValueLayout;
import org.junit.Test;
import junit.framework.Assert;

//VM ARGS : -XstartOnFirstThread --enable-native-access=ALL-UNNAMED --add-modules jdk.incubator.foreign -Djava.library.path=.:/System/Library/Frameworks/OpenGL.framework/Versions/Current/Libraries/

public class TestCGLContext extends MacOSTest{
  @Test
  public void createCGLContext() {
    if (!checkPlatform())
      return;
    
    // Given
    CGLContext_macOS cgl = new CGLContext_macOS();
    
    // When
    cgl.init();
    
    
    // Then
    int[] attribs = cgl.attribs.toArray(ValueLayout.JAVA_INT);
    Assert.assertEquals(73, attribs[0]); // 
    Assert.assertEquals(99, attribs[1]);
    Assert.assertEquals(12800, attribs[2]); // OpenGL version
    Assert.assertEquals(0, attribs[3]);

    // Cleanup
    cgl.destroy();
  }
}
