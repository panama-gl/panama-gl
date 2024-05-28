package panamagl.opengl; 

import java.lang.foreign.*;

public interface GLU  {
  public void gluBeginCurve(MemorySegment arg0);
  public void gluBeginPolygon(MemorySegment arg0);
  public void gluBeginSurface(MemorySegment arg0);
  public void gluBeginTrim(MemorySegment arg0);
  public int gluBuild1DMipmapLevels(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, MemorySegment arg8);
  public int gluBuild1DMipmaps(int arg0, int arg1, int arg2, int arg3, int arg4, MemorySegment arg5);
  public int gluBuild2DMipmapLevels(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, MemorySegment arg9);
  public int gluBuild2DMipmaps(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, MemorySegment arg6);
  public int gluBuild3DMipmapLevels(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, MemorySegment arg10);
  public int gluBuild3DMipmaps(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, MemorySegment arg7);
  public byte gluCheckExtension(MemorySegment arg0, MemorySegment arg1);
  public void gluCylinder(MemorySegment arg0, double arg1, double arg2, double arg3, int arg4, int arg5);
  public void gluDeleteNurbsRenderer(MemorySegment arg0);
  public void gluDeleteQuadric(MemorySegment arg0);
  public void gluDeleteTess(MemorySegment arg0);
  public void gluDisk(MemorySegment arg0, double arg1, double arg2, int arg3, int arg4);
  public void gluEndCurve(MemorySegment arg0);
  public void gluEndPolygon(MemorySegment arg0);
  public void gluEndSurface(MemorySegment arg0);
  public void gluEndTrim(MemorySegment arg0);
  public java.lang.foreign.MemorySegment gluErrorString(int arg0);
  public void gluGetNurbsProperty(MemorySegment arg0, int arg1, MemorySegment arg2);
  public java.lang.foreign.MemorySegment gluGetString(int arg0);
  public void gluGetTessProperty(MemorySegment arg0, int arg1, MemorySegment arg2);
  public void gluLoadSamplingMatrices(MemorySegment arg0, MemorySegment arg1, MemorySegment arg2, MemorySegment arg3);
  public void gluLookAt(double arg0, double arg1, double arg2, double arg3, double arg4, double arg5, double arg6, double arg7, double arg8);
  public java.lang.foreign.MemorySegment gluNewNurbsRenderer();
  public java.lang.foreign.MemorySegment gluNewQuadric();
  public java.lang.foreign.MemorySegment gluNewTess();
  public void gluNextContour(MemorySegment arg0, int arg1);
  public void gluNurbsCallback(MemorySegment arg0, int arg1, MemorySegment arg2);
  public void gluNurbsCallbackData(MemorySegment arg0, MemorySegment arg1);
  public void gluNurbsCallbackDataEXT(MemorySegment arg0, MemorySegment arg1);
  public void gluNurbsCurve(MemorySegment arg0, int arg1, MemorySegment arg2, int arg3, MemorySegment arg4, int arg5, int arg6);
  public void gluNurbsProperty(MemorySegment arg0, int arg1, float arg2);
  public void gluNurbsSurface(MemorySegment arg0, int arg1, MemorySegment arg2, int arg3, MemorySegment arg4, int arg5, int arg6, MemorySegment arg7, int arg8, int arg9, int arg10);
  public void gluOrtho2D(double arg0, double arg1, double arg2, double arg3);
  public void gluPartialDisk(MemorySegment arg0, double arg1, double arg2, int arg3, int arg4, double arg5, double arg6);
  public void gluPerspective(double arg0, double arg1, double arg2, double arg3);
  public void gluPickMatrix(double arg0, double arg1, double arg2, double arg3, MemorySegment arg4);
  public int gluProject(double arg0, double arg1, double arg2, MemorySegment arg3, MemorySegment arg4, MemorySegment arg5, MemorySegment arg6, MemorySegment arg7, MemorySegment arg8);
  public void gluPwlCurve(MemorySegment arg0, int arg1, MemorySegment arg2, int arg3, int arg4);
  public void gluQuadricCallback(MemorySegment arg0, int arg1, MemorySegment arg2);
  public void gluQuadricDrawStyle(MemorySegment arg0, int arg1);
  public void gluQuadricNormals(MemorySegment arg0, int arg1);
  public void gluQuadricOrientation(MemorySegment arg0, int arg1);
  public void gluQuadricTexture(MemorySegment arg0, byte arg1);
  public int gluScaleImage(int arg0, int arg1, int arg2, int arg3, MemorySegment arg4, int arg5, int arg6, int arg7, MemorySegment arg8);
  public void gluSphere(MemorySegment arg0, double arg1, int arg2, int arg3);
  public void gluTessBeginContour(MemorySegment arg0);
  public void gluTessBeginPolygon(MemorySegment arg0, MemorySegment arg1);
  public void gluTessCallback(MemorySegment arg0, int arg1, MemorySegment arg2);
  public void gluTessEndContour(MemorySegment arg0);
  public void gluTessEndPolygon(MemorySegment arg0);
  public void gluTessNormal(MemorySegment arg0, double arg1, double arg2, double arg3);
  public void gluTessProperty(MemorySegment arg0, int arg1, double arg2);
  public void gluTessVertex(MemorySegment arg0, MemorySegment arg1, MemorySegment arg2);
  public int gluUnProject(double arg0, double arg1, double arg2, MemorySegment arg3, MemorySegment arg4, MemorySegment arg5, MemorySegment arg6, MemorySegment arg7, MemorySegment arg8);
  public int gluUnProject4(double arg0, double arg1, double arg2, double arg3, MemorySegment arg4, MemorySegment arg5, MemorySegment arg6, double arg7, double arg8, MemorySegment arg9, MemorySegment arg10, MemorySegment arg11, MemorySegment arg12);
}
