package panamagl.platform.windows;

import java.lang.foreign.MemoryAddress;
import glext.ubuntu.v20.glext_h;
import panamagl.utils.ForeignMemoryUtils;
import wgl.windows.x86.PROC;
import wgl.windows.x86.wgl_h;
import wglext.windows.x86.wglext_h;

import opengl.ubuntu.v20.PFNGLGENFRAMEBUFFERSEXTPROC;

// Experiment something similar to FBO_linux
//--enable-preview -Djava.library.path="C:\Windows\System32"
public class LoadGLExtOnWindows {

  public static void main(String[] args) {
    //System.loadLibrary("opengl32");
    
    
    ForeignMemoryUtils ffm = new ForeignMemoryUtils();

    MemoryAddress address = wgl_h.wglGetProcAddress(ffm.alloc("glGenFramebuffers"));

    // Need a more accurate data type to access the function datatype
    // We should get an equivalent of PFNGLGENFRAMEBUFFERSEXTPROC (linux)
    // which should be named pfnWgl*
    PFNGLGENFRAMEBUFFERSEXTPROC glGenFramebuffers = PFNGLGENFRAMEBUFFERSEXTPROC.ofAddress(address, ffm.getScope());

    //glGenFramebuffers.apply();
  }

}
