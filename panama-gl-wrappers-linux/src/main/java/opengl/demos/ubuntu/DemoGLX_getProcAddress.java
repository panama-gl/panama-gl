package opengl.demos.ubuntu;

import java.lang.foreign.MemorySegment;
import java.lang.foreign.MemorySession;
import java.lang.foreign.SegmentAllocator;

public class DemoGLX_getProcAddress {
  public static void main(String[] args) {
    MemorySession scope;
    SegmentAllocator allocator;
    
    scope = MemorySession.openConfined();
    allocator = SegmentAllocator.newNativeArena(scope);
    
    MemorySegment glGenFramebuffersName = null;
    MemorySegment glGenFramebuffers = null;
    
   /* if(glGenFramebuffersName==null) {
      glGenFramebuffersName = CLinker.toCString("glGenFramebuffers", scope);  
      
      
      CLinker linker = CLinker.systemCLinker();
      MethodHandle strlen = linker.downcallHandle(
              linker.lookup("strlen").get(),
              FunctionDescriptor.of(JAVA_LONG, ADDRESS)
      );
      
      glGenFramebuffers = (MemorySegment) glx_h.glXGetProcAddress(glGenFramebuffersName);
      
      MemoryHandles
    }
    
    glGenFramebuffers.in
    
    glx_h.glGenFramebuffers(1, frameBuffer);*/

  }
}
