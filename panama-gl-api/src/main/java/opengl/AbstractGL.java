package opengl;

import java.lang.foreign.MemorySegment;
import java.lang.foreign.MemorySession;
import java.lang.foreign.SegmentAllocator;
import java.lang.foreign.ValueLayout;
import panamagl.performance.PanamaMemorySession;


/**
 * A base class for Panama based OpenGL binding, implementing part of {@lin GL}
 * 
 * @author Martin Pernollet
 */
public abstract class AbstractGL implements GL {
    protected MemorySession scope;
    protected SegmentAllocator allocator;

    public AbstractGL(){
        try {
            scope = MemorySession.openConfined();//PanamaMemorySession.get();
            allocator = SegmentAllocator.newNativeArena(scope);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /////////////////////////////////////////////

    @Override
    public MemorySession getScope() {
        return scope;
    }

    @Override
    public SegmentAllocator getAllocator() {
        return allocator;
    }

    @Override
    public MemorySegment alloc(String value) {
        return allocator.allocateUtf8String(value);
    }
    
    @Override
    public MemorySegment alloc(double[] value) {
        return allocator.allocateArray(ValueLayout.JAVA_DOUBLE, value);
    }

    @Override
    public MemorySegment alloc(float[] value) {
        return allocator.allocateArray(ValueLayout.JAVA_FLOAT, value);
    }

    @Override
    public MemorySegment alloc(int[] value) {
        return allocator.allocateArray(ValueLayout.JAVA_INT, value);
    }

}
