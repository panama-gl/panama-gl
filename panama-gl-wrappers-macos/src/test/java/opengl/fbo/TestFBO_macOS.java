package opengl.fbo;

import org.junit.Ignore;
import org.junit.Test;
import org.jzy3d.os.OperatingSystem;
import opengl.GL;
import opengl.GLContext;
import opengl.cgl.macos.CGLContext;
import opengl.glut.macos.GLUTContext_macOS_10_15_7;
import opengl.macos.GL_macOS_10_15_7;

// VM ARGS : -XstartOnFirstThread --enable-native-access=ALL-UNNAMED --add-modules jdk.incubator.foreign -Djava.library.path=.:/System/Library/Frameworks/OpenGL.framework/Versions/Current/Libraries/
public class TestFBO_macOS {

    @Test
    public void given_GLUTContext_whenRenderSomething_ThenGetBufferedImage(){
        OperatingSystem os = new OperatingSystem();
        if(!os.isMac())
          return;
        
        
        //GLContext cglContext = new CGLContext();
        //cglContext.init();

        // Given a GLUT context
        GLContext glutContext = new GLUTContext_macOS_10_15_7();
        glutContext.init();

        // Given a GL caller
        GL gl = new GL_macOS_10_15_7();
        
        TestFBO.givenFBO_whenRenderSomething_ThenGetBufferedImage(gl);

    }

  @Ignore /** Crashing for now */
    @Test
    public void given_CGLContext_whenRenderSomething_ThenGetBufferedImage(){
        OperatingSystem os = new OperatingSystem();
        if(!os.isMac())
          return;
        
        // Given a GL context
        GLContext context = new CGLContext();
        context.init();

        GL gl = new GL_macOS_10_15_7();
        
        TestFBO.givenFBO_whenRenderSomething_ThenGetBufferedImage(gl);

    }
    


}
