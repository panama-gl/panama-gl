/*******************************************************************************
 * Copyright (c) 2022, 2023 Martin Pernollet & contributors.
 *
 * This library is free software; you can redistribute it and/or modify it under the terms of the
 * GNU Lesser General Public License as published by the Free Software Foundation; either version
 * 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License along with this library;
 * if not, write to the Free Software Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA
 * 02110-1301, USA
 *******************************************************************************/
package panamagl.platform.linux;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import org.junit.Assert;
import org.junit.Test;
import panamagl.opengl.GL;
import panamagl.platform.linux.x64.GL_linux_x64;

// VM ARGS : --enable-native-access=ALL-UNNAMED -Djava.library.path=.://usr/lib/x86_64-linux-gnu/
public class TestFBO_linux extends LinuxTest {
  static final int GL_FRAMEBUFFER_BINDING = 0x8CA6;

  @Test
  public void bindAndUnbind() {
    if (!checkPlatform())
      return;

    GLXContext_linux context = new GLXContext_linux();
    context.init();
    context.makeCurrent();

    try {
      GL gl = new GL_linux_x64();
      FBO_linux fbo = new FBO_linux(32, 32);

      // When binding before preparation, then the FBO is prepared and bound
      fbo.bind(gl);
      Assert.assertTrue(fbo.isPrepared());
      int id = boundFramebuffer(gl);
      Assert.assertTrue(id > 0);

      // When unbinding
      fbo.unbind(gl);
      Assert.assertEquals(0, boundFramebuffer(gl));

      // When binding again, the same FBO is bound without being recreated
      fbo.bind(gl);
      Assert.assertEquals(id, boundFramebuffer(gl));

      fbo.release(gl);
      Assert.assertEquals(GL.GL_NO_ERROR, gl.glGetError());
    } finally {
      context.destroy();
    }
  }

  protected int boundFramebuffer(GL gl) {
    try (Arena arena = Arena.ofConfined()) {
      MemorySegment id = arena.allocate(ValueLayout.JAVA_INT);
      gl.glGetIntegerv(GL_FRAMEBUFFER_BINDING, id);
      return id.get(ValueLayout.JAVA_INT, 0);
    }
  }
}
