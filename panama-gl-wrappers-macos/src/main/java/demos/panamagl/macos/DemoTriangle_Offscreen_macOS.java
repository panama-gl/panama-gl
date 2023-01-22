package demos.panamagl.macos;

import opengl.GL;
import opengl.GLContext;
import panamagl.macos.gl.GL_macOS;
import panamagl.macos.glut.GLUTContext_macOS;

/**
 * https://github.com/jzy3d/panama-gl/issues/5
 */
// VM ARGS : -XstartOnFirstThread --enable-native-access=ALL-UNNAMED --add-modules jdk.incubator.foreign -Djava.library.path=.:/System/Library/Frameworks/OpenGL.framework/Versions/Current/Libraries/
public class DemoTriangle_Offscreen_macOS {

  public static void main(String[] args) {
    GLContext context = new GLUTContext_macOS();
    context.init();

    GL gl = new GL_macOS();

    demos.panamagl.macos.Demo_Offscreen.fbo_offscreen(gl);
  }
}
