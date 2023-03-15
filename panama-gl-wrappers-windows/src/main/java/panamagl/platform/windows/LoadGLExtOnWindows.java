package panamagl.platform.windows;

import java.lang.foreign.MemoryAddress;
import panamagl.utils.ForeignMemoryUtils;
import wgl.windows.x86.PROC;
import wgl.windows.x86.wgl_h;

// Experiment something similar to FBO_linux
//--enable-preview -Djava.library.path="C:\Windows\System32"
public class LoadGLExtOnWindows {

  public static void main(String[] args) {
    System.loadLibrary("opengl32");
    
    
    ForeignMemoryUtils ffm = new ForeignMemoryUtils();

    MemoryAddress address = wgl_h.wglGetProcAddress(ffm.alloc("glGenFramebuffers"));

    // Need a more accurate data type to access the function datatype
    // We should get an equivalent of PFNGLGENFRAMEBUFFERSEXTPROC (linux)
    // which should be named pfnWgl*
    PROC glGenFramebuffers = PROC.ofAddress(address, ffm.getScope());

    //glGenFramebuffers.apply();
  }

}
