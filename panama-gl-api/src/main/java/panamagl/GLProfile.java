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

import java.util.ArrayList;
import java.util.List;
import panamagl.opengl.GL;
import panamagl.os.Platform;

public class GLProfile {
  protected String vendor;
  protected String renderer;
  protected String version;
  protected List<String> extensions;
  protected Platform platform;

  public GLProfile() {}

  public GLProfile(GL gl) {
    read(gl);
  }

  public void read(GL gl) {
    platform = new Platform();
    
    vendor = gl.glGetString(gl.GL_VENDOR());
    version = gl.glGetString(gl.GL_VERSION());
    renderer = gl.glGetString(gl.GL_RENDERER());

    extensions = new ArrayList<>();
    String ext = gl.glGetString(gl.GL_EXTENSIONS());

    if (ext != null) {
      for (String e : ext.split(" ")) {
        extensions.add(e);
      }
    }
  }

  public String getVendor() {
    return vendor;
  }

  public String getRenderer() {
    return renderer;
  };

  public List<String> getExtensions() {
    return extensions;
  }

  public String toString() {
    return "GLProfile GL.version:" + version + " GL.renderer:" + renderer + " GL.vendor:" + vendor 
        + "\nGLProfile " + platform;
  }
}
