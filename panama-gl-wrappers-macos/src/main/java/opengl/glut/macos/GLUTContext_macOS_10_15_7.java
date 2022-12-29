package opengl.glut.macos;

import jdk.incubator.foreign.*;
import opengl.GL;
import opengl.GLContext;
import opengl.macos.v10_15_3.glutDisplayFunc$func;
import opengl.macos.v10_15_3.glutIdleFunc$func;
import opengl.macos.v10_15_3.glut_h;

import static jdk.incubator.foreign.CLinker.*;
import static opengl.macos.v10_15_3.glut_h.*;
import static opengl.macos.v10_15_3.glut_h.glutDisplayFunc;

/**
 * This GLUT {@link GLContext} initialize a GLUT offscreen context allowing to then
 * invoke {@link GL} methods.
 *
 * NB : glutInit() should only be called once. In case part of the program invokes it,
 * it is possible to initialize the window without calling glutInit by instead calling GLUTContext.init(false)
 * 
 * @author Martin Pernollet
 */
public class GLUTContext_macOS_10_15_7 implements GLContext {
    ResourceScope scope;
    SegmentAllocator allocator;
    String windowName= "InvisiblePanamaGLWindowForGLContext";

    public GLUTContext_macOS_10_15_7(){
        try {
            scope = ResourceScope.newConfinedScope();
            allocator = SegmentAllocator.ofScope(scope);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /** Initialize GLUT and create a window */
    @Override
    public void init(){
        init(true);
    }

    /** Initialize GLUT if input arg is true, and create a window */
    public void init(boolean forceLoadGlut){

        if(forceLoadGlut) {
            var argc = allocator.allocate(C_INT, 0);

            glut_h.glutInit(argc, argc);
            glut_h.glutInitDisplayMode(0);//GLUT_DOUBLE() | GLUT_RGBA() | GLUT_DEPTH());
        }
        glut_h.glutInitWindowSize(1, 1);
        glut_h.glutInitWindowPosition(-100, -100);
        glut_h.glutCreateWindow(CLinker.toCString(windowName, scope));
        
        // This dummy stub registration is required to get macOS onscreen rendering working
        addDummyCallback();
    }
    
    protected void addDummyCallback() {
      MemoryAddress displayStub = glutDisplayFunc$func.allocate(GLUTContext_macOS_10_15_7::dummy, scope);
      //var idleStub = glutIdleFunc$func.allocate(teapot::onIdle, scope);
      glut_h.glutDisplayFunc(displayStub);
    }

    private static void dummy() {}

    @Override
    public void destroy() {
      
    }
}
