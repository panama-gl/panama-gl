package opengl.glut.macos;

import jdk.incubator.foreign.*;
import opengl.GL;
import opengl.GLContext;
import opengl.macos.v10_15_3.glutDisplayFunc$func;
import opengl.macos.v10_15_3.glutIdleFunc$func;
import opengl.macos.v10_15_3.glut_h;

import static jdk.incubator.foreign.CLinker.*;

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
  protected ResourceScope scope;
  protected SegmentAllocator allocator;
  protected String windowName = "InvisiblePanamaGLWindowForGLContext";

  protected int initWidth = 100;
  protected int initHeight = 100;

  protected boolean initialized = true;


  public GLUTContext_macOS_10_15_7() {
    try {
      scope = ResourceScope.newConfinedScope();
      allocator = SegmentAllocator.ofScope(scope);
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
      var argc = allocator.allocate(C_INT, 0);

      glut_h.glutInit(argc, argc);
    }
    glut_h.glutInitDisplayMode(glut_h.GLUT_DOUBLE() | glut_h.GLUT_RGBA() | glut_h.GLUT_DEPTH());

    glutInitWindowSize(initWidth, initHeight);

    glut_h.glutInitWindowPosition(-initWidth, -initHeight);
    glut_h.glutCreateWindow(CLinker.toCString(windowName, scope));

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
    MemoryAddress displayStub = glutDisplayFunc$func.allocate(fi, scope);
    glut_h.glutDisplayFunc(displayStub);
  }

  protected void glutIdleFunc(glutIdleFunc$func fi) {
    MemoryAddress idleStub = glutIdleFunc$func.allocate(fi, scope);
    glut_h.glutIdleFunc(idleStub);

  }

  protected void glutInitWindowSize(int width, int height) {
    glut_h.glutInitWindowSize(width, height);
  }



}
