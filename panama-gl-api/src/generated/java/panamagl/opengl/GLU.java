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


public interface GLU  {
public void gluBeginCurve(java.lang.foreign.Addressable arg0);
public void gluBeginPolygon(java.lang.foreign.Addressable arg0);
public void gluBeginSurface(java.lang.foreign.Addressable arg0);
public void gluBeginTrim(java.lang.foreign.Addressable arg0);
public int gluBuild1DMipmapLevels(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, java.lang.foreign.Addressable arg8);
public int gluBuild1DMipmaps(int arg0, int arg1, int arg2, int arg3, int arg4, java.lang.foreign.Addressable arg5);
public int gluBuild2DMipmapLevels(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, java.lang.foreign.Addressable arg9);
public int gluBuild2DMipmaps(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, java.lang.foreign.Addressable arg6);
public int gluBuild3DMipmapLevels(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, java.lang.foreign.Addressable arg10);
public int gluBuild3DMipmaps(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, java.lang.foreign.Addressable arg7);
public byte gluCheckExtension(java.lang.foreign.Addressable arg0, java.lang.foreign.Addressable arg1);
public void gluCylinder(java.lang.foreign.Addressable arg0, double arg1, double arg2, double arg3, int arg4, int arg5);
public void gluDeleteNurbsRenderer(java.lang.foreign.Addressable arg0);
public void gluDeleteQuadric(java.lang.foreign.Addressable arg0);
public void gluDeleteTess(java.lang.foreign.Addressable arg0);
public void gluDisk(java.lang.foreign.Addressable arg0, double arg1, double arg2, int arg3, int arg4);
public void gluEndCurve(java.lang.foreign.Addressable arg0);
public void gluEndPolygon(java.lang.foreign.Addressable arg0);
public void gluEndSurface(java.lang.foreign.Addressable arg0);
public void gluEndTrim(java.lang.foreign.Addressable arg0);
public java.lang.foreign.MemoryAddress gluErrorString(int arg0);
public void gluGetNurbsProperty(java.lang.foreign.Addressable arg0, int arg1, java.lang.foreign.Addressable arg2);
public java.lang.foreign.MemoryAddress gluGetString(int arg0);
public void gluGetTessProperty(java.lang.foreign.Addressable arg0, int arg1, java.lang.foreign.Addressable arg2);
public void gluLoadSamplingMatrices(java.lang.foreign.Addressable arg0, java.lang.foreign.Addressable arg1, java.lang.foreign.Addressable arg2, java.lang.foreign.Addressable arg3);
public void gluLookAt(double arg0, double arg1, double arg2, double arg3, double arg4, double arg5, double arg6, double arg7, double arg8);
public java.lang.foreign.MemoryAddress gluNewNurbsRenderer();
public java.lang.foreign.MemoryAddress gluNewQuadric();
public java.lang.foreign.MemoryAddress gluNewTess();
public void gluNextContour(java.lang.foreign.Addressable arg0, int arg1);
public void gluNurbsCallback(java.lang.foreign.Addressable arg0, int arg1, java.lang.foreign.Addressable arg2);
public void gluNurbsCallbackData(java.lang.foreign.Addressable arg0, java.lang.foreign.Addressable arg1);
public void gluNurbsCallbackDataEXT(java.lang.foreign.Addressable arg0, java.lang.foreign.Addressable arg1);
public void gluNurbsCurve(java.lang.foreign.Addressable arg0, int arg1, java.lang.foreign.Addressable arg2, int arg3, java.lang.foreign.Addressable arg4, int arg5, int arg6);
public void gluNurbsProperty(java.lang.foreign.Addressable arg0, int arg1, float arg2);
public void gluNurbsSurface(java.lang.foreign.Addressable arg0, int arg1, java.lang.foreign.Addressable arg2, int arg3, java.lang.foreign.Addressable arg4, int arg5, int arg6, java.lang.foreign.Addressable arg7, int arg8, int arg9, int arg10);
public void gluOrtho2D(double arg0, double arg1, double arg2, double arg3);
public void gluPartialDisk(java.lang.foreign.Addressable arg0, double arg1, double arg2, int arg3, int arg4, double arg5, double arg6);
public void gluPerspective(double arg0, double arg1, double arg2, double arg3);
public void gluPickMatrix(double arg0, double arg1, double arg2, double arg3, java.lang.foreign.Addressable arg4);
public int gluProject(double arg0, double arg1, double arg2, java.lang.foreign.Addressable arg3, java.lang.foreign.Addressable arg4, java.lang.foreign.Addressable arg5, java.lang.foreign.Addressable arg6, java.lang.foreign.Addressable arg7, java.lang.foreign.Addressable arg8);
public void gluPwlCurve(java.lang.foreign.Addressable arg0, int arg1, java.lang.foreign.Addressable arg2, int arg3, int arg4);
public void gluQuadricCallback(java.lang.foreign.Addressable arg0, int arg1, java.lang.foreign.Addressable arg2);
public void gluQuadricDrawStyle(java.lang.foreign.Addressable arg0, int arg1);
public void gluQuadricNormals(java.lang.foreign.Addressable arg0, int arg1);
public void gluQuadricOrientation(java.lang.foreign.Addressable arg0, int arg1);
public void gluQuadricTexture(java.lang.foreign.Addressable arg0, byte arg1);
public int gluScaleImage(int arg0, int arg1, int arg2, int arg3, java.lang.foreign.Addressable arg4, int arg5, int arg6, int arg7, java.lang.foreign.Addressable arg8);
public void gluSphere(java.lang.foreign.Addressable arg0, double arg1, int arg2, int arg3);
public void gluTessBeginContour(java.lang.foreign.Addressable arg0);
public void gluTessBeginPolygon(java.lang.foreign.Addressable arg0, java.lang.foreign.Addressable arg1);
public void gluTessCallback(java.lang.foreign.Addressable arg0, int arg1, java.lang.foreign.Addressable arg2);
public void gluTessEndContour(java.lang.foreign.Addressable arg0);
public void gluTessEndPolygon(java.lang.foreign.Addressable arg0);
public void gluTessNormal(java.lang.foreign.Addressable arg0, double arg1, double arg2, double arg3);
public void gluTessProperty(java.lang.foreign.Addressable arg0, int arg1, double arg2);
public void gluTessVertex(java.lang.foreign.Addressable arg0, java.lang.foreign.Addressable arg1, java.lang.foreign.Addressable arg2);
public int gluUnProject(double arg0, double arg1, double arg2, java.lang.foreign.Addressable arg3, java.lang.foreign.Addressable arg4, java.lang.foreign.Addressable arg5, java.lang.foreign.Addressable arg6, java.lang.foreign.Addressable arg7, java.lang.foreign.Addressable arg8);
public int gluUnProject4(double arg0, double arg1, double arg2, double arg3, java.lang.foreign.Addressable arg4, java.lang.foreign.Addressable arg5, java.lang.foreign.Addressable arg6, double arg7, double arg8, java.lang.foreign.Addressable arg9, java.lang.foreign.Addressable arg10, java.lang.foreign.Addressable arg11, java.lang.foreign.Addressable arg12);
}
