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
