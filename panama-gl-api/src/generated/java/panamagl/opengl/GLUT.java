package panamagl.opengl; 

import java.lang.foreign.*;

public interface GLUT  {
  public void glutAddMenuEntry(MemorySegment arg0, int arg1);
  public void glutAddSubMenu(MemorySegment arg0, int arg1);
  public void glutAttachMenu(int arg0);
  public void glutBitmap8By13(MemorySegment arg0);
  public java.lang.foreign.MemorySegment glutBitmap9By15();
  public void glutBitmapCharacter(MemorySegment arg0, int arg1);
  public java.lang.foreign.MemorySegment glutBitmapHelvetica10();
  public void glutBitmapHelvetica12(MemorySegment arg0);
  public java.lang.foreign.MemorySegment glutBitmapHelvetica18();
  public int glutBitmapLength(MemorySegment arg0, MemorySegment arg1);
  public java.lang.foreign.MemorySegment glutBitmapTimesRoman10();
  public java.lang.foreign.MemorySegment glutBitmapTimesRoman24();
  public int glutBitmapWidth(MemorySegment arg0, int arg1);
  public void glutButtonBoxFunc(MemorySegment arg0);
  public void glutChangeToMenuEntry(int arg0, MemorySegment arg1, int arg2);
  public void glutChangeToSubMenu(int arg0, MemorySegment arg1, int arg2);
  public void glutCheckLoop();
  public void glutCopyColormap(int arg0);
  public int glutCreateMenu(MemorySegment arg0);
  public int glutCreateSubWindow(int arg0, int arg1, int arg2, int arg3, int arg4);
  public int glutCreateWindow(MemorySegment arg0);
  public void glutDestroyMenu(int arg0);
  public void glutDestroyWindow(int arg0);
  public void glutDetachMenu(int arg0);
  public int glutDeviceGet(int arg0);
  public void glutDialsFunc(MemorySegment arg0);
  public void glutDisplayFunc(MemorySegment arg0);
  public int glutEnterGameMode();
  public void glutEntryFunc(MemorySegment arg0);
  public void glutEstablishOverlay();
  public int glutExtensionSupported(MemorySegment arg0);
  public void glutForceJoystickFunc();
  public void glutFullScreen();
  public int glutGameModeGet(int arg0);
  public void glutGameModeString(MemorySegment arg0);
  public int glutGet(int arg0);
  public float glutGetColor(int arg0, int arg1);
  public int glutGetMenu();
  public int glutGetModifiers();
  public java.lang.foreign.MemorySegment glutGetProcAddress(MemorySegment arg0);
  public int glutGetWindow();
  public void glutHideOverlay();
  public void glutHideWindow();
  public void glutIconifyWindow();
  public void glutIdleFunc(MemorySegment arg0);
  public void glutIgnoreKeyRepeat(int arg0);
  public void glutInit(MemorySegment arg0, MemorySegment arg1);
  public void glutInitDisplayMode(int arg0);
  public void glutInitDisplayString(MemorySegment arg0);
  public void glutInitWindowPosition(int arg0, int arg1);
  public void glutInitWindowSize(int arg0, int arg1);
  public void glutJoystickFunc(MemorySegment arg0, int arg1);
  public void glutKeyboardFunc(MemorySegment arg0);
  public void glutKeyboardUpFunc(MemorySegment arg0);
  public int glutLayerGet(int arg0);
  public void glutLeaveGameMode();
  public void glutMainLoop();
  public void glutMenuStateFunc(MemorySegment arg0);
  public void glutMenuStatusFunc(MemorySegment arg0);
  public void glutMotionFunc(MemorySegment arg0);
  public void glutMouseFunc(MemorySegment arg0);
  public void glutOverlayDisplayFunc(MemorySegment arg0);
  public void glutPassiveMotionFunc(MemorySegment arg0);
  public void glutPopWindow();
  public void glutPositionWindow(int arg0, int arg1);
  public void glutPostOverlayRedisplay();
  public void glutPostRedisplay();
  public void glutPostWindowOverlayRedisplay(int arg0);
  public void glutPostWindowRedisplay(int arg0);
  public void glutPushWindow();
  public void glutRemoveMenuItem(int arg0);
  public void glutRemoveOverlay();
  public void glutReportErrors();
  public void glutReshapeFunc(MemorySegment arg0);
  public void glutReshapeWindow(int arg0, int arg1);
  public void glutSetColor(int arg0, float arg1, float arg2, float arg3);
  public void glutSetCursor(int arg0);
  public void glutSetIconTitle(MemorySegment arg0);
  public void glutSetKeyRepeat(int arg0);
  public void glutSetMenu(int arg0);
  public void glutSetWindow(int arg0);
  public void glutSetWindowTitle(MemorySegment arg0);
  public void glutSetupVideoResizing();
  public void glutShowOverlay();
  public void glutShowWindow();
  public void glutSolidCone(double arg0, double arg1, int arg2, int arg3);
  public void glutSolidCube(double arg0);
  public void glutSolidDodecahedron();
  public void glutSolidIcosahedron();
  public void glutSolidOctahedron();
  public void glutSolidSphere(double arg0, int arg1, int arg2);
  public void glutSolidTeapot(double arg0);
  public void glutSolidTetrahedron();
  public void glutSolidTorus(double arg0, double arg1, int arg2, int arg3);
  public void glutSpaceballButtonFunc(MemorySegment arg0);
  public void glutSpaceballMotionFunc(MemorySegment arg0);
  public void glutSpaceballRotateFunc(MemorySegment arg0);
  public void glutSpecialFunc(MemorySegment arg0);
  public void glutSpecialUpFunc(MemorySegment arg0);
  public void glutStopVideoResizing();
  public void glutStrokeCharacter(MemorySegment arg0, int arg1);
  public int glutStrokeLength(MemorySegment arg0, MemorySegment arg1);
  public void glutStrokeMonoRoman(MemorySegment arg0);
  public void glutStrokeRoman(MemorySegment arg0);
  public int glutStrokeWidth(MemorySegment arg0, int arg1);
  public void glutSurfaceTexture(int arg0, int arg1, int arg2);
  public void glutSwapBuffers();
  public void glutTabletButtonFunc(MemorySegment arg0);
  public void glutTabletMotionFunc(MemorySegment arg0);
  public void glutTimerFunc(int arg0, MemorySegment arg1, int arg2);
  public void glutUseLayer(int arg0);
  public void glutVideoPan(int arg0, int arg1, int arg2, int arg3);
  public void glutVideoResize(int arg0, int arg1, int arg2, int arg3);
  public int glutVideoResizeGet(int arg0);
  public void glutVisibilityFunc(MemorySegment arg0);
  public void glutWMCloseFunc(MemorySegment arg0);
  public void glutWarpPointer(int arg0, int arg1);
  public void glutWindowStatusFunc(MemorySegment arg0);
  public void glutWireCone(double arg0, double arg1, int arg2, int arg3);
  public void glutWireCube(double arg0);
  public void glutWireDodecahedron();
  public void glutWireIcosahedron();
  public void glutWireOctahedron();
  public void glutWireSphere(double arg0, int arg1, int arg2);
  public void glutWireTeapot(double arg0);
  public void glutWireTetrahedron();
  public void glutWireTorus(double arg0, double arg1, int arg2, int arg3);
}
