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

import java.lang.foreign.MemorySegment;
import java.util.ArrayList;
import java.util.List;
import panamagl.opengl.GL;
import panamagl.platform.Platform;

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

    vendor = glGetString(gl, GL.GL_VENDOR);
    version = glGetString(gl, GL.GL_VERSION);
    renderer = glGetString(gl, GL.GL_RENDERER);

    extensions = readExtensions(gl);
  }

  /**
   * Read extensions via glGetString(GL_EXTENSIONS).
   *
   * In Core Profile, this call generates GL_INVALID_ENUM (the Core Profile way is
   * glGetStringi in a loop). We consume the GL error so it does not pollute subsequent
   * GL calls. Extensions will simply be empty in that case.
   */
  protected List<String> readExtensions(GL gl) {
    List<String> result = new ArrayList<>();

    String ext = glGetString(gl, GL.GL_EXTENSIONS);

    // Consume any GL error that glGetString(GL_EXTENSIONS) may have produced
    // (GL_INVALID_ENUM in Core Profile) - appened when querying this with CGL.
    // Consuming the error avoid getting an error flag active later in the execution.
    int err = gl.glGetError();

    if (ext != null) {
      for (String e : ext.split(" ")) {
        result.add(e);
      }
    }
    return result;
  }
  
  /** 
   * Mainly deal with 
   * - null return to avoid crashing tests with mocks
   * - with native NULL pointers (e.g. CGL Core Profile where glGetString(GL_EXTENSIONS) returns NULL). 
   */
  protected String glGetString(GL gl, int name) {
    MemorySegment segment = gl.glGetString(name);
    if(segment != null && segment.address() != 0)
      return segment.getString(0);
    return null;
  }

  public String getVendor() {
    return vendor;
  }

  public String getRenderer() {
    return renderer;
  }

  public String getVersion() {
    return version;
  }

  public List<String> getExtensions() {
    return extensions;
  }

  public String toString() {
    return "GLProfile GL.version:" + version + " GL.renderer:" + renderer + " GL.vendor:" + vendor 
        + "\nGLProfile " + platform;
  }
}
