package panamagl.macos.glut;

import java.lang.foreign.MemorySegment;
import java.lang.foreign.MemorySession;
import java.lang.foreign.SegmentAllocator;
import java.lang.foreign.ValueLayout;
import opengl.GL;
import opengl.GLContext;
import opengl.macos.v10_15_7.glutDisplayFunc$func;
import opengl.macos.v10_15_7.glutIdleFunc$func;
import opengl.macos.v10_15_7.glut_h;

/**
 * This GLUT {@link GLContext} initialize a GLUT offscreen context allowing to then invoke
 * {@link GL} methods.
 *
 * NB : glutInit() should only be called once. In case part of the program invokes it, it is
 * possible to initialize the window without calling glutInit by instead calling
 * GLUTContext.init(false)
 * 
 * @author Martin Pernollet
 */
public class GLUTContext_macOS_10_15_7 implements GLContext {
  protected MemorySession scope;
  protected SegmentAllocator allocator;
  protected String windowName = "InvisiblePanamaGLWindowForGLContext";

  protected int initWidth = 100;
  protected int initHeight = 100;

  protected boolean initialized = true;


  public GLUTContext_macOS_10_15_7() {
    try {
      scope = MemorySession.openImplicit();//openConfined();
      allocator = SegmentAllocator.newNativeArena(scope);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /** Initialize GLUT and create a window */
  @Override
  public void init() {
    init(true);
  }

  /** Initialize GLUT if input arg is true, and create a window */
  public void init(boolean forceLoadGlut) {

    if (forceLoadGlut) {
      var argc = allocator.allocate(ValueLayout.JAVA_INT, 0);

      glut_h.glutInit(argc, argc);
    }
    glut_h.glutInitDisplayMode(glut_h.GLUT_DOUBLE() | glut_h.GLUT_RGBA() | glut_h.GLUT_DEPTH());

    glutInitWindowSize(initWidth, initHeight);

    glut_h.glutInitWindowPosition(-initWidth, -initHeight);
    glut_h.glutCreateWindow(allocator.allocateUtf8String(windowName));

    // This dummy stub registration is required to get macOS onscreen rendering working
    // It will avoid error message
    // "GLUT Fatal Error: redisplay needed for window 1, but no display callback."
    glutDisplayFunc(GLUTContext_macOS_10_15_7::dummy);

    initialized = true;
  }

  private static void dummy() {}

  @Override
  public boolean isInitialized() {
    return initialized;
  }
  
  @Override
  public void destroy() {
    initialized = false;
  }

  protected void glutDisplayFunc(glutDisplayFunc$func fi) {
    MemorySegment displayStub = glutDisplayFunc$func.allocate(fi, scope);
    glut_h.glutDisplayFunc(displayStub);
  }

  protected void glutIdleFunc(glutIdleFunc$func fi) {
    MemorySegment idleStub = glutIdleFunc$func.allocate(fi, scope);
    glut_h.glutIdleFunc(idleStub);

  }

  protected void glutInitWindowSize(int width, int height) {
    glut_h.glutInitWindowSize(width, height);
  }



}
