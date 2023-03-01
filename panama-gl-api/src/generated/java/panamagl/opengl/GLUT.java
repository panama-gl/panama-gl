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
package panamagl.opengl; 


public interface GLUT  {
public void glutAddMenuEntry(java.lang.foreign.Addressable arg0, int arg1);
public void glutAddSubMenu(java.lang.foreign.Addressable arg0, int arg1);
public void glutAttachMenu(int arg0);
public void glutBitmapCharacter(java.lang.foreign.Addressable arg0, int arg1);
public int glutBitmapLength(java.lang.foreign.Addressable arg0, java.lang.foreign.Addressable arg1);
public int glutBitmapWidth(java.lang.foreign.Addressable arg0, int arg1);
public void glutButtonBoxFunc(java.lang.foreign.Addressable arg0);
public void glutChangeToMenuEntry(int arg0, java.lang.foreign.Addressable arg1, int arg2);
public void glutChangeToSubMenu(int arg0, java.lang.foreign.Addressable arg1, int arg2);
public void glutCheckLoop();
public void glutCopyColormap(int arg0);
public int glutCreateMenu(java.lang.foreign.Addressable arg0);
public int glutCreateSubWindow(int arg0, int arg1, int arg2, int arg3, int arg4);
public int glutCreateWindow(java.lang.foreign.Addressable arg0);
public void glutDestroyMenu(int arg0);
public void glutDestroyWindow(int arg0);
public void glutDetachMenu(int arg0);
public int glutDeviceGet(int arg0);
public void glutDialsFunc(java.lang.foreign.Addressable arg0);
public void glutDisplayFunc(java.lang.foreign.Addressable arg0);
public int glutEnterGameMode();
public void glutEntryFunc(java.lang.foreign.Addressable arg0);
public void glutEstablishOverlay();
public int glutExtensionSupported(java.lang.foreign.Addressable arg0);
public void glutForceJoystickFunc();
public void glutFullScreen();
public int glutGameModeGet(int arg0);
public void glutGameModeString(java.lang.foreign.Addressable arg0);
public int glutGet(int arg0);
public float glutGetColor(int arg0, int arg1);
public int glutGetMenu();
public int glutGetModifiers();
public java.lang.foreign.MemoryAddress glutGetProcAddress(java.lang.foreign.Addressable arg0);
public int glutGetWindow();
public void glutHideOverlay();
public void glutHideWindow();
public void glutIconifyWindow();
public void glutIdleFunc(java.lang.foreign.Addressable arg0);
public void glutIgnoreKeyRepeat(int arg0);
public void glutInit(java.lang.foreign.Addressable arg0, java.lang.foreign.Addressable arg1);
public void glutInitDisplayMode(int arg0);
public void glutInitDisplayString(java.lang.foreign.Addressable arg0);
public void glutInitWindowPosition(int arg0, int arg1);
public void glutInitWindowSize(int arg0, int arg1);
public void glutJoystickFunc(java.lang.foreign.Addressable arg0, int arg1);
public void glutKeyboardFunc(java.lang.foreign.Addressable arg0);
public void glutKeyboardUpFunc(java.lang.foreign.Addressable arg0);
public int glutLayerGet(int arg0);
public void glutLeaveGameMode();
public void glutMainLoop();
public void glutMenuStateFunc(java.lang.foreign.Addressable arg0);
public void glutMenuStatusFunc(java.lang.foreign.Addressable arg0);
public void glutMotionFunc(java.lang.foreign.Addressable arg0);
public void glutMouseFunc(java.lang.foreign.Addressable arg0);
public void glutOverlayDisplayFunc(java.lang.foreign.Addressable arg0);
public void glutPassiveMotionFunc(java.lang.foreign.Addressable arg0);
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
public void glutReshapeFunc(java.lang.foreign.Addressable arg0);
public void glutReshapeWindow(int arg0, int arg1);
public void glutSetColor(int arg0, float arg1, float arg2, float arg3);
public void glutSetCursor(int arg0);
public void glutSetIconTitle(java.lang.foreign.Addressable arg0);
public void glutSetKeyRepeat(int arg0);
public void glutSetMenu(int arg0);
public void glutSetWindow(int arg0);
public void glutSetWindowTitle(java.lang.foreign.Addressable arg0);
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
public void glutSpaceballButtonFunc(java.lang.foreign.Addressable arg0);
public void glutSpaceballMotionFunc(java.lang.foreign.Addressable arg0);
public void glutSpaceballRotateFunc(java.lang.foreign.Addressable arg0);
public void glutSpecialFunc(java.lang.foreign.Addressable arg0);
public void glutSpecialUpFunc(java.lang.foreign.Addressable arg0);
public void glutStopVideoResizing();
public void glutStrokeCharacter(java.lang.foreign.Addressable arg0, int arg1);
public int glutStrokeLength(java.lang.foreign.Addressable arg0, java.lang.foreign.Addressable arg1);
public int glutStrokeWidth(java.lang.foreign.Addressable arg0, int arg1);
public void glutSurfaceTexture(int arg0, int arg1, int arg2);
public void glutSwapBuffers();
public void glutTabletButtonFunc(java.lang.foreign.Addressable arg0);
public void glutTabletMotionFunc(java.lang.foreign.Addressable arg0);
public void glutTimerFunc(int arg0, java.lang.foreign.Addressable arg1, int arg2);
public void glutUseLayer(int arg0);
public void glutVideoPan(int arg0, int arg1, int arg2, int arg3);
public void glutVideoResize(int arg0, int arg1, int arg2, int arg3);
public int glutVideoResizeGet(int arg0);
public void glutVisibilityFunc(java.lang.foreign.Addressable arg0);
public void glutWMCloseFunc(java.lang.foreign.Addressable arg0);
public void glutWarpPointer(int arg0, int arg1);
public void glutWindowStatusFunc(java.lang.foreign.Addressable arg0);
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
