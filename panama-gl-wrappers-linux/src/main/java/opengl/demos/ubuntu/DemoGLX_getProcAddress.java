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
