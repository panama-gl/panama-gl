package panamagl.opengl; 

import opengl.ubuntu.v20.glut_h;
import static opengl.ubuntu.v20.glut_h.*;
import java.lang.foreign.*;

public class GL_linux implements GL_1_0, GL_1_1, GL_1_2, GL_1_3 {
  public void glAccum(int arg0, float arg1) {
    glut_h.glAccum(arg0, arg1);
  }

  public void glActiveTexture(int arg0) {
    glut_h.glActiveTexture(arg0);
  }

  public void glActiveTextureARB(int arg0) {
    glut_h.glActiveTextureARB(arg0);
  }

  public void glAlphaFunc(int arg0, float arg1) {
    glut_h.glAlphaFunc(arg0, arg1);
  }

  public byte glAreTexturesResident(int arg0, Addressable arg1, Addressable arg2) {
    return glut_h.glAreTexturesResident(arg0, arg1, arg2);
  }

  public void glArrayElement(int arg0) {
    glut_h.glArrayElement(arg0);
  }

  public void glBegin(int arg0) {
    glut_h.glBegin(arg0);
  }

  public void glBindTexture(int arg0, int arg1) {
    glut_h.glBindTexture(arg0, arg1);
  }

  public void glBitmap(int arg0, int arg1, float arg2, float arg3, float arg4, float arg5, Addressable arg6) {
    glut_h.glBitmap(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
  }

  public void glBlendColor(float arg0, float arg1, float arg2, float arg3) {
    glut_h.glBlendColor(arg0, arg1, arg2, arg3);
  }

  public void glBlendEquation(int arg0) {
    glut_h.glBlendEquation(arg0);
  }

  public void glBlendFunc(int arg0, int arg1) {
    glut_h.glBlendFunc(arg0, arg1);
  }

  public void glCallList(int arg0) {
    glut_h.glCallList(arg0);
  }

  public void glCallLists(int arg0, int arg1, Addressable arg2) {
    glut_h.glCallLists(arg0, arg1, arg2);
  }

  public void glClear(int arg0) {
    glut_h.glClear(arg0);
  }

  public void glClearAccum(float arg0, float arg1, float arg2, float arg3) {
    glut_h.glClearAccum(arg0, arg1, arg2, arg3);
  }

  public void glClearColor(float arg0, float arg1, float arg2, float arg3) {
    glut_h.glClearColor(arg0, arg1, arg2, arg3);
  }

  public void glClearDepth(double arg0) {
    glut_h.glClearDepth(arg0);
  }

  public void glClearIndex(float arg0) {
    glut_h.glClearIndex(arg0);
  }

  public void glClearStencil(int arg0) {
    glut_h.glClearStencil(arg0);
  }

  public void glClientActiveTexture(int arg0) {
    glut_h.glClientActiveTexture(arg0);
  }

  public void glClientActiveTextureARB(int arg0) {
    glut_h.glClientActiveTextureARB(arg0);
  }

  public void glClipPlane(int arg0, Addressable arg1) {
    glut_h.glClipPlane(arg0, arg1);
  }

  public void glColor3b(byte arg0, byte arg1, byte arg2) {
    glut_h.glColor3b(arg0, arg1, arg2);
  }

  public void glColor3bv(Addressable arg0) {
    glut_h.glColor3bv(arg0);
  }

  public void glColor3d(double arg0, double arg1, double arg2) {
    glut_h.glColor3d(arg0, arg1, arg2);
  }

  public void glColor3dv(Addressable arg0) {
    glut_h.glColor3dv(arg0);
  }

  public void glColor3f(float arg0, float arg1, float arg2) {
    glut_h.glColor3f(arg0, arg1, arg2);
  }

  public void glColor3fv(Addressable arg0) {
    glut_h.glColor3fv(arg0);
  }

  public void glColor3i(int arg0, int arg1, int arg2) {
    glut_h.glColor3i(arg0, arg1, arg2);
  }

  public void glColor3iv(Addressable arg0) {
    glut_h.glColor3iv(arg0);
  }

  public void glColor3s(short arg0, short arg1, short arg2) {
    glut_h.glColor3s(arg0, arg1, arg2);
  }

  public void glColor3sv(Addressable arg0) {
    glut_h.glColor3sv(arg0);
  }

  public void glColor3ub(byte arg0, byte arg1, byte arg2) {
    glut_h.glColor3ub(arg0, arg1, arg2);
  }

  public void glColor3ubv(Addressable arg0) {
    glut_h.glColor3ubv(arg0);
  }

  public void glColor3ui(int arg0, int arg1, int arg2) {
    glut_h.glColor3ui(arg0, arg1, arg2);
  }

  public void glColor3uiv(Addressable arg0) {
    glut_h.glColor3uiv(arg0);
  }

  public void glColor3us(short arg0, short arg1, short arg2) {
    glut_h.glColor3us(arg0, arg1, arg2);
  }

  public void glColor3usv(Addressable arg0) {
    glut_h.glColor3usv(arg0);
  }

  public void glColor4b(byte arg0, byte arg1, byte arg2, byte arg3) {
    glut_h.glColor4b(arg0, arg1, arg2, arg3);
  }

  public void glColor4bv(Addressable arg0) {
    glut_h.glColor4bv(arg0);
  }

  public void glColor4d(double arg0, double arg1, double arg2, double arg3) {
    glut_h.glColor4d(arg0, arg1, arg2, arg3);
  }

  public void glColor4dv(Addressable arg0) {
    glut_h.glColor4dv(arg0);
  }

  public void glColor4f(float arg0, float arg1, float arg2, float arg3) {
    glut_h.glColor4f(arg0, arg1, arg2, arg3);
  }

  public void glColor4fv(Addressable arg0) {
    glut_h.glColor4fv(arg0);
  }

  public void glColor4i(int arg0, int arg1, int arg2, int arg3) {
    glut_h.glColor4i(arg0, arg1, arg2, arg3);
  }

  public void glColor4iv(Addressable arg0) {
    glut_h.glColor4iv(arg0);
  }

  public void glColor4s(short arg0, short arg1, short arg2, short arg3) {
    glut_h.glColor4s(arg0, arg1, arg2, arg3);
  }

  public void glColor4sv(Addressable arg0) {
    glut_h.glColor4sv(arg0);
  }

  public void glColor4ub(byte arg0, byte arg1, byte arg2, byte arg3) {
    glut_h.glColor4ub(arg0, arg1, arg2, arg3);
  }

  public void glColor4ubv(Addressable arg0) {
    glut_h.glColor4ubv(arg0);
  }

  public void glColor4ui(int arg0, int arg1, int arg2, int arg3) {
    glut_h.glColor4ui(arg0, arg1, arg2, arg3);
  }

  public void glColor4uiv(Addressable arg0) {
    glut_h.glColor4uiv(arg0);
  }

  public void glColor4us(short arg0, short arg1, short arg2, short arg3) {
    glut_h.glColor4us(arg0, arg1, arg2, arg3);
  }

  public void glColor4usv(Addressable arg0) {
    glut_h.glColor4usv(arg0);
  }

  public void glColorMask(byte arg0, byte arg1, byte arg2, byte arg3) {
    glut_h.glColorMask(arg0, arg1, arg2, arg3);
  }

  public void glColorMaterial(int arg0, int arg1) {
    glut_h.glColorMaterial(arg0, arg1);
  }

  public void glColorPointer(int arg0, int arg1, int arg2, Addressable arg3) {
    glut_h.glColorPointer(arg0, arg1, arg2, arg3);
  }

  public void glColorSubTable(int arg0, int arg1, int arg2, int arg3, int arg4, Addressable arg5) {
    glut_h.glColorSubTable(arg0, arg1, arg2, arg3, arg4, arg5);
  }

  public void glColorTable(int arg0, int arg1, int arg2, int arg3, int arg4, Addressable arg5) {
    glut_h.glColorTable(arg0, arg1, arg2, arg3, arg4, arg5);
  }

  public void glColorTableParameterfv(int arg0, int arg1, Addressable arg2) {
    glut_h.glColorTableParameterfv(arg0, arg1, arg2);
  }

  public void glColorTableParameteriv(int arg0, int arg1, Addressable arg2) {
    glut_h.glColorTableParameteriv(arg0, arg1, arg2);
  }

  public void glCompressedTexImage1D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, Addressable arg6) {
    glut_h.glCompressedTexImage1D(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
  }

  public void glCompressedTexImage2D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, Addressable arg7) {
    glut_h.glCompressedTexImage2D(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7);
  }

  public void glCompressedTexImage3D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, Addressable arg8) {
    glut_h.glCompressedTexImage3D(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
  }

  public void glCompressedTexSubImage1D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, Addressable arg6) {
    glut_h.glCompressedTexSubImage1D(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
  }

  public void glCompressedTexSubImage2D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, Addressable arg8) {
    glut_h.glCompressedTexSubImage2D(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
  }

  public void glCompressedTexSubImage3D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, Addressable arg10) {
    glut_h.glCompressedTexSubImage3D(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10);
  }

  public void glConvolutionFilter1D(int arg0, int arg1, int arg2, int arg3, int arg4, Addressable arg5) {
    glut_h.glConvolutionFilter1D(arg0, arg1, arg2, arg3, arg4, arg5);
  }

  public void glConvolutionFilter2D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, Addressable arg6) {
    glut_h.glConvolutionFilter2D(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
  }

  public void glConvolutionParameterf(int arg0, int arg1, float arg2) {
    glut_h.glConvolutionParameterf(arg0, arg1, arg2);
  }

  public void glConvolutionParameterfv(int arg0, int arg1, Addressable arg2) {
    glut_h.glConvolutionParameterfv(arg0, arg1, arg2);
  }

  public void glConvolutionParameteri(int arg0, int arg1, int arg2) {
    glut_h.glConvolutionParameteri(arg0, arg1, arg2);
  }

  public void glConvolutionParameteriv(int arg0, int arg1, Addressable arg2) {
    glut_h.glConvolutionParameteriv(arg0, arg1, arg2);
  }

  public void glCopyColorSubTable(int arg0, int arg1, int arg2, int arg3, int arg4) {
    glut_h.glCopyColorSubTable(arg0, arg1, arg2, arg3, arg4);
  }

  public void glCopyColorTable(int arg0, int arg1, int arg2, int arg3, int arg4) {
    glut_h.glCopyColorTable(arg0, arg1, arg2, arg3, arg4);
  }

  public void glCopyConvolutionFilter1D(int arg0, int arg1, int arg2, int arg3, int arg4) {
    glut_h.glCopyConvolutionFilter1D(arg0, arg1, arg2, arg3, arg4);
  }

  public void glCopyConvolutionFilter2D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5) {
    glut_h.glCopyConvolutionFilter2D(arg0, arg1, arg2, arg3, arg4, arg5);
  }

  public void glCopyPixels(int arg0, int arg1, int arg2, int arg3, int arg4) {
    glut_h.glCopyPixels(arg0, arg1, arg2, arg3, arg4);
  }

  public void glCopyTexImage1D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6) {
    glut_h.glCopyTexImage1D(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
  }

  public void glCopyTexImage2D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7) {
    glut_h.glCopyTexImage2D(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7);
  }

  public void glCopyTexSubImage1D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5) {
    glut_h.glCopyTexSubImage1D(arg0, arg1, arg2, arg3, arg4, arg5);
  }

  public void glCopyTexSubImage2D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7) {
    glut_h.glCopyTexSubImage2D(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7);
  }

  public void glCopyTexSubImage3D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8) {
    glut_h.glCopyTexSubImage3D(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
  }

  public void glCullFace(int arg0) {
    glut_h.glCullFace(arg0);
  }

  public void glDeleteLists(int arg0, int arg1) {
    glut_h.glDeleteLists(arg0, arg1);
  }

  public void glDeleteTextures(int arg0, Addressable arg1) {
    glut_h.glDeleteTextures(arg0, arg1);
  }

  public void glDepthFunc(int arg0) {
    glut_h.glDepthFunc(arg0);
  }

  public void glDepthMask(byte arg0) {
    glut_h.glDepthMask(arg0);
  }

  public void glDepthRange(double arg0, double arg1) {
    glut_h.glDepthRange(arg0, arg1);
  }

  public void glDisable(int arg0) {
    glut_h.glDisable(arg0);
  }

  public void glDisableClientState(int arg0) {
    glut_h.glDisableClientState(arg0);
  }

  public void glDrawArrays(int arg0, int arg1, int arg2) {
    glut_h.glDrawArrays(arg0, arg1, arg2);
  }

  public void glDrawBuffer(int arg0) {
    glut_h.glDrawBuffer(arg0);
  }

  public void glDrawElements(int arg0, int arg1, int arg2, Addressable arg3) {
    glut_h.glDrawElements(arg0, arg1, arg2, arg3);
  }

  public void glDrawPixels(int arg0, int arg1, int arg2, int arg3, Addressable arg4) {
    glut_h.glDrawPixels(arg0, arg1, arg2, arg3, arg4);
  }

  public void glDrawRangeElements(int arg0, int arg1, int arg2, int arg3, int arg4, Addressable arg5) {
    glut_h.glDrawRangeElements(arg0, arg1, arg2, arg3, arg4, arg5);
  }

  public void glEdgeFlag(byte arg0) {
    glut_h.glEdgeFlag(arg0);
  }

  public void glEdgeFlagPointer(int arg0, Addressable arg1) {
    glut_h.glEdgeFlagPointer(arg0, arg1);
  }

  public void glEdgeFlagv(Addressable arg0) {
    glut_h.glEdgeFlagv(arg0);
  }

  public void glEnable(int arg0) {
    glut_h.glEnable(arg0);
  }

  public void glEnableClientState(int arg0) {
    glut_h.glEnableClientState(arg0);
  }

  public void glEnd() {
    glut_h.glEnd();
  }

  public void glEndList() {
    glut_h.glEndList();
  }

  public void glEvalCoord1d(double arg0) {
    glut_h.glEvalCoord1d(arg0);
  }

  public void glEvalCoord1dv(Addressable arg0) {
    glut_h.glEvalCoord1dv(arg0);
  }

  public void glEvalCoord1f(float arg0) {
    glut_h.glEvalCoord1f(arg0);
  }

  public void glEvalCoord1fv(Addressable arg0) {
    glut_h.glEvalCoord1fv(arg0);
  }

  public void glEvalCoord2d(double arg0, double arg1) {
    glut_h.glEvalCoord2d(arg0, arg1);
  }

  public void glEvalCoord2dv(Addressable arg0) {
    glut_h.glEvalCoord2dv(arg0);
  }

  public void glEvalCoord2f(float arg0, float arg1) {
    glut_h.glEvalCoord2f(arg0, arg1);
  }

  public void glEvalCoord2fv(Addressable arg0) {
    glut_h.glEvalCoord2fv(arg0);
  }

  public void glEvalMesh1(int arg0, int arg1, int arg2) {
    glut_h.glEvalMesh1(arg0, arg1, arg2);
  }

  public void glEvalMesh2(int arg0, int arg1, int arg2, int arg3, int arg4) {
    glut_h.glEvalMesh2(arg0, arg1, arg2, arg3, arg4);
  }

  public void glEvalPoint1(int arg0) {
    glut_h.glEvalPoint1(arg0);
  }

  public void glEvalPoint2(int arg0, int arg1) {
    glut_h.glEvalPoint2(arg0, arg1);
  }

  public void glFeedbackBuffer(int arg0, int arg1, Addressable arg2) {
    glut_h.glFeedbackBuffer(arg0, arg1, arg2);
  }

  public void glFinish() {
    glut_h.glFinish();
  }

  public void glFlush() {
    glut_h.glFlush();
  }

  public void glFogf(int arg0, float arg1) {
    glut_h.glFogf(arg0, arg1);
  }

  public void glFogfv(int arg0, Addressable arg1) {
    glut_h.glFogfv(arg0, arg1);
  }

  public void glFogi(int arg0, int arg1) {
    glut_h.glFogi(arg0, arg1);
  }

  public void glFogiv(int arg0, Addressable arg1) {
    glut_h.glFogiv(arg0, arg1);
  }

  public void glFrontFace(int arg0) {
    glut_h.glFrontFace(arg0);
  }

  public void glFrustum(double arg0, double arg1, double arg2, double arg3, double arg4, double arg5) {
    glut_h.glFrustum(arg0, arg1, arg2, arg3, arg4, arg5);
  }

  public int glGenLists(int arg0) {
    return glut_h.glGenLists(arg0);
  }

  public void glGenTextures(int arg0, Addressable arg1) {
    glut_h.glGenTextures(arg0, arg1);
  }

  public void glGetBooleanv(int arg0, Addressable arg1) {
    glut_h.glGetBooleanv(arg0, arg1);
  }

  public void glGetClipPlane(int arg0, Addressable arg1) {
    glut_h.glGetClipPlane(arg0, arg1);
  }

  public void glGetColorTable(int arg0, int arg1, int arg2, Addressable arg3) {
    glut_h.glGetColorTable(arg0, arg1, arg2, arg3);
  }

  public void glGetColorTableParameterfv(int arg0, int arg1, Addressable arg2) {
    glut_h.glGetColorTableParameterfv(arg0, arg1, arg2);
  }

  public void glGetColorTableParameteriv(int arg0, int arg1, Addressable arg2) {
    glut_h.glGetColorTableParameteriv(arg0, arg1, arg2);
  }

  public void glGetCompressedTexImage(int arg0, int arg1, Addressable arg2) {
    glut_h.glGetCompressedTexImage(arg0, arg1, arg2);
  }

  public void glGetConvolutionFilter(int arg0, int arg1, int arg2, Addressable arg3) {
    glut_h.glGetConvolutionFilter(arg0, arg1, arg2, arg3);
  }

  public void glGetConvolutionParameterfv(int arg0, int arg1, Addressable arg2) {
    glut_h.glGetConvolutionParameterfv(arg0, arg1, arg2);
  }

  public void glGetConvolutionParameteriv(int arg0, int arg1, Addressable arg2) {
    glut_h.glGetConvolutionParameteriv(arg0, arg1, arg2);
  }

  public void glGetDoublev(int arg0, Addressable arg1) {
    glut_h.glGetDoublev(arg0, arg1);
  }

  public int glGetError() {
    return glut_h.glGetError();
  }

  public void glGetFloatv(int arg0, Addressable arg1) {
    glut_h.glGetFloatv(arg0, arg1);
  }

  public void glGetHistogram(int arg0, byte arg1, int arg2, int arg3, Addressable arg4) {
    glut_h.glGetHistogram(arg0, arg1, arg2, arg3, arg4);
  }

  public void glGetHistogramParameterfv(int arg0, int arg1, Addressable arg2) {
    glut_h.glGetHistogramParameterfv(arg0, arg1, arg2);
  }

  public void glGetHistogramParameteriv(int arg0, int arg1, Addressable arg2) {
    glut_h.glGetHistogramParameteriv(arg0, arg1, arg2);
  }

  public void glGetIntegerv(int arg0, Addressable arg1) {
    glut_h.glGetIntegerv(arg0, arg1);
  }

  public void glGetLightfv(int arg0, int arg1, Addressable arg2) {
    glut_h.glGetLightfv(arg0, arg1, arg2);
  }

  public void glGetLightiv(int arg0, int arg1, Addressable arg2) {
    glut_h.glGetLightiv(arg0, arg1, arg2);
  }

  public void glGetMapdv(int arg0, int arg1, Addressable arg2) {
    glut_h.glGetMapdv(arg0, arg1, arg2);
  }

  public void glGetMapfv(int arg0, int arg1, Addressable arg2) {
    glut_h.glGetMapfv(arg0, arg1, arg2);
  }

  public void glGetMapiv(int arg0, int arg1, Addressable arg2) {
    glut_h.glGetMapiv(arg0, arg1, arg2);
  }

  public void glGetMaterialfv(int arg0, int arg1, Addressable arg2) {
    glut_h.glGetMaterialfv(arg0, arg1, arg2);
  }

  public void glGetMaterialiv(int arg0, int arg1, Addressable arg2) {
    glut_h.glGetMaterialiv(arg0, arg1, arg2);
  }

  public void glGetMinmax(int arg0, byte arg1, int arg2, int arg3, Addressable arg4) {
    glut_h.glGetMinmax(arg0, arg1, arg2, arg3, arg4);
  }

  public void glGetMinmaxParameterfv(int arg0, int arg1, Addressable arg2) {
    glut_h.glGetMinmaxParameterfv(arg0, arg1, arg2);
  }

  public void glGetMinmaxParameteriv(int arg0, int arg1, Addressable arg2) {
    glut_h.glGetMinmaxParameteriv(arg0, arg1, arg2);
  }

  public void glGetPixelMapfv(int arg0, Addressable arg1) {
    glut_h.glGetPixelMapfv(arg0, arg1);
  }

  public void glGetPixelMapuiv(int arg0, Addressable arg1) {
    glut_h.glGetPixelMapuiv(arg0, arg1);
  }

  public void glGetPixelMapusv(int arg0, Addressable arg1) {
    glut_h.glGetPixelMapusv(arg0, arg1);
  }

  public void glGetPointerv(int arg0, Addressable arg1) {
    glut_h.glGetPointerv(arg0, arg1);
  }

  public void glGetPolygonStipple(Addressable arg0) {
    glut_h.glGetPolygonStipple(arg0);
  }

  public void glGetSeparableFilter(int arg0, int arg1, int arg2, Addressable arg3, Addressable arg4, Addressable arg5) {
    glut_h.glGetSeparableFilter(arg0, arg1, arg2, arg3, arg4, arg5);
  }

  public String glGetString(int arg0) {
    return glut_h.glGetString(arg0).getUtf8String(0);
  }

  public void glGetTexEnvfv(int arg0, int arg1, Addressable arg2) {
    glut_h.glGetTexEnvfv(arg0, arg1, arg2);
  }

  public void glGetTexEnviv(int arg0, int arg1, Addressable arg2) {
    glut_h.glGetTexEnviv(arg0, arg1, arg2);
  }

  public void glGetTexGendv(int arg0, int arg1, Addressable arg2) {
    glut_h.glGetTexGendv(arg0, arg1, arg2);
  }

  public void glGetTexGenfv(int arg0, int arg1, Addressable arg2) {
    glut_h.glGetTexGenfv(arg0, arg1, arg2);
  }

  public void glGetTexGeniv(int arg0, int arg1, Addressable arg2) {
    glut_h.glGetTexGeniv(arg0, arg1, arg2);
  }

  public void glGetTexImage(int arg0, int arg1, int arg2, int arg3, Addressable arg4) {
    glut_h.glGetTexImage(arg0, arg1, arg2, arg3, arg4);
  }

  public void glGetTexLevelParameterfv(int arg0, int arg1, int arg2, Addressable arg3) {
    glut_h.glGetTexLevelParameterfv(arg0, arg1, arg2, arg3);
  }

  public void glGetTexLevelParameteriv(int arg0, int arg1, int arg2, Addressable arg3) {
    glut_h.glGetTexLevelParameteriv(arg0, arg1, arg2, arg3);
  }

  public void glGetTexParameterfv(int arg0, int arg1, Addressable arg2) {
    glut_h.glGetTexParameterfv(arg0, arg1, arg2);
  }

  public void glGetTexParameteriv(int arg0, int arg1, Addressable arg2) {
    glut_h.glGetTexParameteriv(arg0, arg1, arg2);
  }

  public void glHint(int arg0, int arg1) {
    glut_h.glHint(arg0, arg1);
  }

  public void glHistogram(int arg0, int arg1, int arg2, byte arg3) {
    glut_h.glHistogram(arg0, arg1, arg2, arg3);
  }

  public void glIndexMask(int arg0) {
    glut_h.glIndexMask(arg0);
  }

  public void glIndexPointer(int arg0, int arg1, Addressable arg2) {
    glut_h.glIndexPointer(arg0, arg1, arg2);
  }

  public void glIndexd(double arg0) {
    glut_h.glIndexd(arg0);
  }

  public void glIndexdv(Addressable arg0) {
    glut_h.glIndexdv(arg0);
  }

  public void glIndexf(float arg0) {
    glut_h.glIndexf(arg0);
  }

  public void glIndexfv(Addressable arg0) {
    glut_h.glIndexfv(arg0);
  }

  public void glIndexi(int arg0) {
    glut_h.glIndexi(arg0);
  }

  public void glIndexiv(Addressable arg0) {
    glut_h.glIndexiv(arg0);
  }

  public void glIndexs(short arg0) {
    glut_h.glIndexs(arg0);
  }

  public void glIndexsv(Addressable arg0) {
    glut_h.glIndexsv(arg0);
  }

  public void glIndexub(byte arg0) {
    glut_h.glIndexub(arg0);
  }

  public void glIndexubv(Addressable arg0) {
    glut_h.glIndexubv(arg0);
  }

  public void glInitNames() {
    glut_h.glInitNames();
  }

  public void glInterleavedArrays(int arg0, int arg1, Addressable arg2) {
    glut_h.glInterleavedArrays(arg0, arg1, arg2);
  }

  public byte glIsEnabled(int arg0) {
    return glut_h.glIsEnabled(arg0);
  }

  public byte glIsList(int arg0) {
    return glut_h.glIsList(arg0);
  }

  public byte glIsTexture(int arg0) {
    return glut_h.glIsTexture(arg0);
  }

  public void glLightModelf(int arg0, float arg1) {
    glut_h.glLightModelf(arg0, arg1);
  }

  public void glLightModelfv(int arg0, Addressable arg1) {
    glut_h.glLightModelfv(arg0, arg1);
  }

  public void glLightModeli(int arg0, int arg1) {
    glut_h.glLightModeli(arg0, arg1);
  }

  public void glLightModeliv(int arg0, Addressable arg1) {
    glut_h.glLightModeliv(arg0, arg1);
  }

  public void glLightf(int arg0, int arg1, float arg2) {
    glut_h.glLightf(arg0, arg1, arg2);
  }

  public void glLightfv(int arg0, int arg1, Addressable arg2) {
    glut_h.glLightfv(arg0, arg1, arg2);
  }

  public void glLighti(int arg0, int arg1, int arg2) {
    glut_h.glLighti(arg0, arg1, arg2);
  }

  public void glLightiv(int arg0, int arg1, Addressable arg2) {
    glut_h.glLightiv(arg0, arg1, arg2);
  }

  public void glLineStipple(int arg0, short arg1) {
    glut_h.glLineStipple(arg0, arg1);
  }

  public void glLineWidth(float arg0) {
    glut_h.glLineWidth(arg0);
  }

  public void glListBase(int arg0) {
    glut_h.glListBase(arg0);
  }

  public void glLoadIdentity() {
    glut_h.glLoadIdentity();
  }

  public void glLoadMatrixd(Addressable arg0) {
    glut_h.glLoadMatrixd(arg0);
  }

  public void glLoadMatrixf(Addressable arg0) {
    glut_h.glLoadMatrixf(arg0);
  }

  public void glLoadName(int arg0) {
    glut_h.glLoadName(arg0);
  }

  public void glLoadTransposeMatrixd(Addressable arg0) {
    glut_h.glLoadTransposeMatrixd(arg0);
  }

  public void glLoadTransposeMatrixf(Addressable arg0) {
    glut_h.glLoadTransposeMatrixf(arg0);
  }

  public void glLogicOp(int arg0) {
    glut_h.glLogicOp(arg0);
  }

  public void glMap1d(int arg0, double arg1, double arg2, int arg3, int arg4, Addressable arg5) {
    glut_h.glMap1d(arg0, arg1, arg2, arg3, arg4, arg5);
  }

  public void glMap1f(int arg0, float arg1, float arg2, int arg3, int arg4, Addressable arg5) {
    glut_h.glMap1f(arg0, arg1, arg2, arg3, arg4, arg5);
  }

  public void glMap2d(int arg0, double arg1, double arg2, int arg3, int arg4, double arg5, double arg6, int arg7, int arg8, Addressable arg9) {
    glut_h.glMap2d(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9);
  }

  public void glMap2f(int arg0, float arg1, float arg2, int arg3, int arg4, float arg5, float arg6, int arg7, int arg8, Addressable arg9) {
    glut_h.glMap2f(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9);
  }

  public void glMapGrid1d(int arg0, double arg1, double arg2) {
    glut_h.glMapGrid1d(arg0, arg1, arg2);
  }

  public void glMapGrid1f(int arg0, float arg1, float arg2) {
    glut_h.glMapGrid1f(arg0, arg1, arg2);
  }

  public void glMapGrid2d(int arg0, double arg1, double arg2, int arg3, double arg4, double arg5) {
    glut_h.glMapGrid2d(arg0, arg1, arg2, arg3, arg4, arg5);
  }

  public void glMapGrid2f(int arg0, float arg1, float arg2, int arg3, float arg4, float arg5) {
    glut_h.glMapGrid2f(arg0, arg1, arg2, arg3, arg4, arg5);
  }

  public void glMaterialf(int arg0, int arg1, float arg2) {
    glut_h.glMaterialf(arg0, arg1, arg2);
  }

  public void glMaterialfv(int arg0, int arg1, Addressable arg2) {
    glut_h.glMaterialfv(arg0, arg1, arg2);
  }

  public void glMateriali(int arg0, int arg1, int arg2) {
    glut_h.glMateriali(arg0, arg1, arg2);
  }

  public void glMaterialiv(int arg0, int arg1, Addressable arg2) {
    glut_h.glMaterialiv(arg0, arg1, arg2);
  }

  public void glMatrixMode(int arg0) {
    glut_h.glMatrixMode(arg0);
  }

  public void glMinmax(int arg0, int arg1, byte arg2) {
    glut_h.glMinmax(arg0, arg1, arg2);
  }

  public void glMultMatrixd(Addressable arg0) {
    glut_h.glMultMatrixd(arg0);
  }

  public void glMultMatrixf(Addressable arg0) {
    glut_h.glMultMatrixf(arg0);
  }

  public void glMultTransposeMatrixd(Addressable arg0) {
    glut_h.glMultTransposeMatrixd(arg0);
  }

  public void glMultTransposeMatrixf(Addressable arg0) {
    glut_h.glMultTransposeMatrixf(arg0);
  }

  public void glMultiTexCoord1d(int arg0, double arg1) {
    glut_h.glMultiTexCoord1d(arg0, arg1);
  }

  public void glMultiTexCoord1dARB(int arg0, double arg1) {
    glut_h.glMultiTexCoord1dARB(arg0, arg1);
  }

  public void glMultiTexCoord1dv(int arg0, Addressable arg1) {
    glut_h.glMultiTexCoord1dv(arg0, arg1);
  }

  public void glMultiTexCoord1dvARB(int arg0, Addressable arg1) {
    glut_h.glMultiTexCoord1dvARB(arg0, arg1);
  }

  public void glMultiTexCoord1f(int arg0, float arg1) {
    glut_h.glMultiTexCoord1f(arg0, arg1);
  }

  public void glMultiTexCoord1fARB(int arg0, float arg1) {
    glut_h.glMultiTexCoord1fARB(arg0, arg1);
  }

  public void glMultiTexCoord1fv(int arg0, Addressable arg1) {
    glut_h.glMultiTexCoord1fv(arg0, arg1);
  }

  public void glMultiTexCoord1fvARB(int arg0, Addressable arg1) {
    glut_h.glMultiTexCoord1fvARB(arg0, arg1);
  }

  public void glMultiTexCoord1i(int arg0, int arg1) {
    glut_h.glMultiTexCoord1i(arg0, arg1);
  }

  public void glMultiTexCoord1iARB(int arg0, int arg1) {
    glut_h.glMultiTexCoord1iARB(arg0, arg1);
  }

  public void glMultiTexCoord1iv(int arg0, Addressable arg1) {
    glut_h.glMultiTexCoord1iv(arg0, arg1);
  }

  public void glMultiTexCoord1ivARB(int arg0, Addressable arg1) {
    glut_h.glMultiTexCoord1ivARB(arg0, arg1);
  }

  public void glMultiTexCoord1s(int arg0, short arg1) {
    glut_h.glMultiTexCoord1s(arg0, arg1);
  }

  public void glMultiTexCoord1sARB(int arg0, short arg1) {
    glut_h.glMultiTexCoord1sARB(arg0, arg1);
  }

  public void glMultiTexCoord1sv(int arg0, Addressable arg1) {
    glut_h.glMultiTexCoord1sv(arg0, arg1);
  }

  public void glMultiTexCoord1svARB(int arg0, Addressable arg1) {
    glut_h.glMultiTexCoord1svARB(arg0, arg1);
  }

  public void glMultiTexCoord2d(int arg0, double arg1, double arg2) {
    glut_h.glMultiTexCoord2d(arg0, arg1, arg2);
  }

  public void glMultiTexCoord2dARB(int arg0, double arg1, double arg2) {
    glut_h.glMultiTexCoord2dARB(arg0, arg1, arg2);
  }

  public void glMultiTexCoord2dv(int arg0, Addressable arg1) {
    glut_h.glMultiTexCoord2dv(arg0, arg1);
  }

  public void glMultiTexCoord2dvARB(int arg0, Addressable arg1) {
    glut_h.glMultiTexCoord2dvARB(arg0, arg1);
  }

  public void glMultiTexCoord2f(int arg0, float arg1, float arg2) {
    glut_h.glMultiTexCoord2f(arg0, arg1, arg2);
  }

  public void glMultiTexCoord2fARB(int arg0, float arg1, float arg2) {
    glut_h.glMultiTexCoord2fARB(arg0, arg1, arg2);
  }

  public void glMultiTexCoord2fv(int arg0, Addressable arg1) {
    glut_h.glMultiTexCoord2fv(arg0, arg1);
  }

  public void glMultiTexCoord2fvARB(int arg0, Addressable arg1) {
    glut_h.glMultiTexCoord2fvARB(arg0, arg1);
  }

  public void glMultiTexCoord2i(int arg0, int arg1, int arg2) {
    glut_h.glMultiTexCoord2i(arg0, arg1, arg2);
  }

  public void glMultiTexCoord2iARB(int arg0, int arg1, int arg2) {
    glut_h.glMultiTexCoord2iARB(arg0, arg1, arg2);
  }

  public void glMultiTexCoord2iv(int arg0, Addressable arg1) {
    glut_h.glMultiTexCoord2iv(arg0, arg1);
  }

  public void glMultiTexCoord2ivARB(int arg0, Addressable arg1) {
    glut_h.glMultiTexCoord2ivARB(arg0, arg1);
  }

  public void glMultiTexCoord2s(int arg0, short arg1, short arg2) {
    glut_h.glMultiTexCoord2s(arg0, arg1, arg2);
  }

  public void glMultiTexCoord2sARB(int arg0, short arg1, short arg2) {
    glut_h.glMultiTexCoord2sARB(arg0, arg1, arg2);
  }

  public void glMultiTexCoord2sv(int arg0, Addressable arg1) {
    glut_h.glMultiTexCoord2sv(arg0, arg1);
  }

  public void glMultiTexCoord2svARB(int arg0, Addressable arg1) {
    glut_h.glMultiTexCoord2svARB(arg0, arg1);
  }

  public void glMultiTexCoord3d(int arg0, double arg1, double arg2, double arg3) {
    glut_h.glMultiTexCoord3d(arg0, arg1, arg2, arg3);
  }

  public void glMultiTexCoord3dARB(int arg0, double arg1, double arg2, double arg3) {
    glut_h.glMultiTexCoord3dARB(arg0, arg1, arg2, arg3);
  }

  public void glMultiTexCoord3dv(int arg0, Addressable arg1) {
    glut_h.glMultiTexCoord3dv(arg0, arg1);
  }

  public void glMultiTexCoord3dvARB(int arg0, Addressable arg1) {
    glut_h.glMultiTexCoord3dvARB(arg0, arg1);
  }

  public void glMultiTexCoord3f(int arg0, float arg1, float arg2, float arg3) {
    glut_h.glMultiTexCoord3f(arg0, arg1, arg2, arg3);
  }

  public void glMultiTexCoord3fARB(int arg0, float arg1, float arg2, float arg3) {
    glut_h.glMultiTexCoord3fARB(arg0, arg1, arg2, arg3);
  }

  public void glMultiTexCoord3fv(int arg0, Addressable arg1) {
    glut_h.glMultiTexCoord3fv(arg0, arg1);
  }

  public void glMultiTexCoord3fvARB(int arg0, Addressable arg1) {
    glut_h.glMultiTexCoord3fvARB(arg0, arg1);
  }

  public void glMultiTexCoord3i(int arg0, int arg1, int arg2, int arg3) {
    glut_h.glMultiTexCoord3i(arg0, arg1, arg2, arg3);
  }

  public void glMultiTexCoord3iARB(int arg0, int arg1, int arg2, int arg3) {
    glut_h.glMultiTexCoord3iARB(arg0, arg1, arg2, arg3);
  }

  public void glMultiTexCoord3iv(int arg0, Addressable arg1) {
    glut_h.glMultiTexCoord3iv(arg0, arg1);
  }

  public void glMultiTexCoord3ivARB(int arg0, Addressable arg1) {
    glut_h.glMultiTexCoord3ivARB(arg0, arg1);
  }

  public void glMultiTexCoord3s(int arg0, short arg1, short arg2, short arg3) {
    glut_h.glMultiTexCoord3s(arg0, arg1, arg2, arg3);
  }

  public void glMultiTexCoord3sARB(int arg0, short arg1, short arg2, short arg3) {
    glut_h.glMultiTexCoord3sARB(arg0, arg1, arg2, arg3);
  }

  public void glMultiTexCoord3sv(int arg0, Addressable arg1) {
    glut_h.glMultiTexCoord3sv(arg0, arg1);
  }

  public void glMultiTexCoord3svARB(int arg0, Addressable arg1) {
    glut_h.glMultiTexCoord3svARB(arg0, arg1);
  }

  public void glMultiTexCoord4d(int arg0, double arg1, double arg2, double arg3, double arg4) {
    glut_h.glMultiTexCoord4d(arg0, arg1, arg2, arg3, arg4);
  }

  public void glMultiTexCoord4dARB(int arg0, double arg1, double arg2, double arg3, double arg4) {
    glut_h.glMultiTexCoord4dARB(arg0, arg1, arg2, arg3, arg4);
  }

  public void glMultiTexCoord4dv(int arg0, Addressable arg1) {
    glut_h.glMultiTexCoord4dv(arg0, arg1);
  }

  public void glMultiTexCoord4dvARB(int arg0, Addressable arg1) {
    glut_h.glMultiTexCoord4dvARB(arg0, arg1);
  }

  public void glMultiTexCoord4f(int arg0, float arg1, float arg2, float arg3, float arg4) {
    glut_h.glMultiTexCoord4f(arg0, arg1, arg2, arg3, arg4);
  }

  public void glMultiTexCoord4fARB(int arg0, float arg1, float arg2, float arg3, float arg4) {
    glut_h.glMultiTexCoord4fARB(arg0, arg1, arg2, arg3, arg4);
  }

  public void glMultiTexCoord4fv(int arg0, Addressable arg1) {
    glut_h.glMultiTexCoord4fv(arg0, arg1);
  }

  public void glMultiTexCoord4fvARB(int arg0, Addressable arg1) {
    glut_h.glMultiTexCoord4fvARB(arg0, arg1);
  }

  public void glMultiTexCoord4i(int arg0, int arg1, int arg2, int arg3, int arg4) {
    glut_h.glMultiTexCoord4i(arg0, arg1, arg2, arg3, arg4);
  }

  public void glMultiTexCoord4iARB(int arg0, int arg1, int arg2, int arg3, int arg4) {
    glut_h.glMultiTexCoord4iARB(arg0, arg1, arg2, arg3, arg4);
  }

  public void glMultiTexCoord4iv(int arg0, Addressable arg1) {
    glut_h.glMultiTexCoord4iv(arg0, arg1);
  }

  public void glMultiTexCoord4ivARB(int arg0, Addressable arg1) {
    glut_h.glMultiTexCoord4ivARB(arg0, arg1);
  }

  public void glMultiTexCoord4s(int arg0, short arg1, short arg2, short arg3, short arg4) {
    glut_h.glMultiTexCoord4s(arg0, arg1, arg2, arg3, arg4);
  }

  public void glMultiTexCoord4sARB(int arg0, short arg1, short arg2, short arg3, short arg4) {
    glut_h.glMultiTexCoord4sARB(arg0, arg1, arg2, arg3, arg4);
  }

  public void glMultiTexCoord4sv(int arg0, Addressable arg1) {
    glut_h.glMultiTexCoord4sv(arg0, arg1);
  }

  public void glMultiTexCoord4svARB(int arg0, Addressable arg1) {
    glut_h.glMultiTexCoord4svARB(arg0, arg1);
  }

  public void glNewList(int arg0, int arg1) {
    glut_h.glNewList(arg0, arg1);
  }

  public void glNormal3b(byte arg0, byte arg1, byte arg2) {
    glut_h.glNormal3b(arg0, arg1, arg2);
  }

  public void glNormal3bv(Addressable arg0) {
    glut_h.glNormal3bv(arg0);
  }

  public void glNormal3d(double arg0, double arg1, double arg2) {
    glut_h.glNormal3d(arg0, arg1, arg2);
  }

  public void glNormal3dv(Addressable arg0) {
    glut_h.glNormal3dv(arg0);
  }

  public void glNormal3f(float arg0, float arg1, float arg2) {
    glut_h.glNormal3f(arg0, arg1, arg2);
  }

  public void glNormal3fv(Addressable arg0) {
    glut_h.glNormal3fv(arg0);
  }

  public void glNormal3i(int arg0, int arg1, int arg2) {
    glut_h.glNormal3i(arg0, arg1, arg2);
  }

  public void glNormal3iv(Addressable arg0) {
    glut_h.glNormal3iv(arg0);
  }

  public void glNormal3s(short arg0, short arg1, short arg2) {
    glut_h.glNormal3s(arg0, arg1, arg2);
  }

  public void glNormal3sv(Addressable arg0) {
    glut_h.glNormal3sv(arg0);
  }

  public void glNormalPointer(int arg0, int arg1, Addressable arg2) {
    glut_h.glNormalPointer(arg0, arg1, arg2);
  }

  public void glOrtho(double arg0, double arg1, double arg2, double arg3, double arg4, double arg5) {
    glut_h.glOrtho(arg0, arg1, arg2, arg3, arg4, arg5);
  }

  public void glPassThrough(float arg0) {
    glut_h.glPassThrough(arg0);
  }

  public void glPixelMapfv(int arg0, int arg1, Addressable arg2) {
    glut_h.glPixelMapfv(arg0, arg1, arg2);
  }

  public void glPixelMapuiv(int arg0, int arg1, Addressable arg2) {
    glut_h.glPixelMapuiv(arg0, arg1, arg2);
  }

  public void glPixelMapusv(int arg0, int arg1, Addressable arg2) {
    glut_h.glPixelMapusv(arg0, arg1, arg2);
  }

  public void glPixelStoref(int arg0, float arg1) {
    glut_h.glPixelStoref(arg0, arg1);
  }

  public void glPixelStorei(int arg0, int arg1) {
    glut_h.glPixelStorei(arg0, arg1);
  }

  public void glPixelTransferf(int arg0, float arg1) {
    glut_h.glPixelTransferf(arg0, arg1);
  }

  public void glPixelTransferi(int arg0, int arg1) {
    glut_h.glPixelTransferi(arg0, arg1);
  }

  public void glPixelZoom(float arg0, float arg1) {
    glut_h.glPixelZoom(arg0, arg1);
  }

  public void glPointSize(float arg0) {
    glut_h.glPointSize(arg0);
  }

  public void glPolygonMode(int arg0, int arg1) {
    glut_h.glPolygonMode(arg0, arg1);
  }

  public void glPolygonOffset(float arg0, float arg1) {
    glut_h.glPolygonOffset(arg0, arg1);
  }

  public void glPolygonStipple(Addressable arg0) {
    glut_h.glPolygonStipple(arg0);
  }

  public void glPopAttrib() {
    glut_h.glPopAttrib();
  }

  public void glPopClientAttrib() {
    glut_h.glPopClientAttrib();
  }

  public void glPopMatrix() {
    glut_h.glPopMatrix();
  }

  public void glPopName() {
    glut_h.glPopName();
  }

  public void glPrioritizeTextures(int arg0, Addressable arg1, Addressable arg2) {
    glut_h.glPrioritizeTextures(arg0, arg1, arg2);
  }

  public void glPushAttrib(int arg0) {
    glut_h.glPushAttrib(arg0);
  }

  public void glPushClientAttrib(int arg0) {
    glut_h.glPushClientAttrib(arg0);
  }

  public void glPushMatrix() {
    glut_h.glPushMatrix();
  }

  public void glPushName(int arg0) {
    glut_h.glPushName(arg0);
  }

  public void glRasterPos2d(double arg0, double arg1) {
    glut_h.glRasterPos2d(arg0, arg1);
  }

  public void glRasterPos2dv(Addressable arg0) {
    glut_h.glRasterPos2dv(arg0);
  }

  public void glRasterPos2f(float arg0, float arg1) {
    glut_h.glRasterPos2f(arg0, arg1);
  }

  public void glRasterPos2fv(Addressable arg0) {
    glut_h.glRasterPos2fv(arg0);
  }

  public void glRasterPos2i(int arg0, int arg1) {
    glut_h.glRasterPos2i(arg0, arg1);
  }

  public void glRasterPos2iv(Addressable arg0) {
    glut_h.glRasterPos2iv(arg0);
  }

  public void glRasterPos2s(short arg0, short arg1) {
    glut_h.glRasterPos2s(arg0, arg1);
  }

  public void glRasterPos2sv(Addressable arg0) {
    glut_h.glRasterPos2sv(arg0);
  }

  public void glRasterPos3d(double arg0, double arg1, double arg2) {
    glut_h.glRasterPos3d(arg0, arg1, arg2);
  }

  public void glRasterPos3dv(Addressable arg0) {
    glut_h.glRasterPos3dv(arg0);
  }

  public void glRasterPos3f(float arg0, float arg1, float arg2) {
    glut_h.glRasterPos3f(arg0, arg1, arg2);
  }

  public void glRasterPos3fv(Addressable arg0) {
    glut_h.glRasterPos3fv(arg0);
  }

  public void glRasterPos3i(int arg0, int arg1, int arg2) {
    glut_h.glRasterPos3i(arg0, arg1, arg2);
  }

  public void glRasterPos3iv(Addressable arg0) {
    glut_h.glRasterPos3iv(arg0);
  }

  public void glRasterPos3s(short arg0, short arg1, short arg2) {
    glut_h.glRasterPos3s(arg0, arg1, arg2);
  }

  public void glRasterPos3sv(Addressable arg0) {
    glut_h.glRasterPos3sv(arg0);
  }

  public void glRasterPos4d(double arg0, double arg1, double arg2, double arg3) {
    glut_h.glRasterPos4d(arg0, arg1, arg2, arg3);
  }

  public void glRasterPos4dv(Addressable arg0) {
    glut_h.glRasterPos4dv(arg0);
  }

  public void glRasterPos4f(float arg0, float arg1, float arg2, float arg3) {
    glut_h.glRasterPos4f(arg0, arg1, arg2, arg3);
  }

  public void glRasterPos4fv(Addressable arg0) {
    glut_h.glRasterPos4fv(arg0);
  }

  public void glRasterPos4i(int arg0, int arg1, int arg2, int arg3) {
    glut_h.glRasterPos4i(arg0, arg1, arg2, arg3);
  }

  public void glRasterPos4iv(Addressable arg0) {
    glut_h.glRasterPos4iv(arg0);
  }

  public void glRasterPos4s(short arg0, short arg1, short arg2, short arg3) {
    glut_h.glRasterPos4s(arg0, arg1, arg2, arg3);
  }

  public void glRasterPos4sv(Addressable arg0) {
    glut_h.glRasterPos4sv(arg0);
  }

  public void glReadBuffer(int arg0) {
    glut_h.glReadBuffer(arg0);
  }

  public void glReadPixels(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, Addressable arg6) {
    glut_h.glReadPixels(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
  }

  public void glRectd(double arg0, double arg1, double arg2, double arg3) {
    glut_h.glRectd(arg0, arg1, arg2, arg3);
  }

  public void glRectdv(Addressable arg0, Addressable arg1) {
    glut_h.glRectdv(arg0, arg1);
  }

  public void glRectf(float arg0, float arg1, float arg2, float arg3) {
    glut_h.glRectf(arg0, arg1, arg2, arg3);
  }

  public void glRectfv(Addressable arg0, Addressable arg1) {
    glut_h.glRectfv(arg0, arg1);
  }

  public void glRecti(int arg0, int arg1, int arg2, int arg3) {
    glut_h.glRecti(arg0, arg1, arg2, arg3);
  }

  public void glRectiv(Addressable arg0, Addressable arg1) {
    glut_h.glRectiv(arg0, arg1);
  }

  public void glRects(short arg0, short arg1, short arg2, short arg3) {
    glut_h.glRects(arg0, arg1, arg2, arg3);
  }

  public void glRectsv(Addressable arg0, Addressable arg1) {
    glut_h.glRectsv(arg0, arg1);
  }

  public int glRenderMode(int arg0) {
    return glut_h.glRenderMode(arg0);
  }

  public void glResetHistogram(int arg0) {
    glut_h.glResetHistogram(arg0);
  }

  public void glResetMinmax(int arg0) {
    glut_h.glResetMinmax(arg0);
  }

  public void glRotated(double arg0, double arg1, double arg2, double arg3) {
    glut_h.glRotated(arg0, arg1, arg2, arg3);
  }

  public void glRotatef(float arg0, float arg1, float arg2, float arg3) {
    glut_h.glRotatef(arg0, arg1, arg2, arg3);
  }

  public void glSampleCoverage(float arg0, byte arg1) {
    glut_h.glSampleCoverage(arg0, arg1);
  }

  public void glScaled(double arg0, double arg1, double arg2) {
    glut_h.glScaled(arg0, arg1, arg2);
  }

  public void glScalef(float arg0, float arg1, float arg2) {
    glut_h.glScalef(arg0, arg1, arg2);
  }

  public void glScissor(int arg0, int arg1, int arg2, int arg3) {
    glut_h.glScissor(arg0, arg1, arg2, arg3);
  }

  public void glSelectBuffer(int arg0, Addressable arg1) {
    glut_h.glSelectBuffer(arg0, arg1);
  }

  public void glSeparableFilter2D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, Addressable arg6, Addressable arg7) {
    glut_h.glSeparableFilter2D(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7);
  }

  public void glShadeModel(int arg0) {
    glut_h.glShadeModel(arg0);
  }

  public void glStencilFunc(int arg0, int arg1, int arg2) {
    glut_h.glStencilFunc(arg0, arg1, arg2);
  }

  public void glStencilMask(int arg0) {
    glut_h.glStencilMask(arg0);
  }

  public void glStencilOp(int arg0, int arg1, int arg2) {
    glut_h.glStencilOp(arg0, arg1, arg2);
  }

  public void glTexCoord1d(double arg0) {
    glut_h.glTexCoord1d(arg0);
  }

  public void glTexCoord1dv(Addressable arg0) {
    glut_h.glTexCoord1dv(arg0);
  }

  public void glTexCoord1f(float arg0) {
    glut_h.glTexCoord1f(arg0);
  }

  public void glTexCoord1fv(Addressable arg0) {
    glut_h.glTexCoord1fv(arg0);
  }

  public void glTexCoord1i(int arg0) {
    glut_h.glTexCoord1i(arg0);
  }

  public void glTexCoord1iv(Addressable arg0) {
    glut_h.glTexCoord1iv(arg0);
  }

  public void glTexCoord1s(short arg0) {
    glut_h.glTexCoord1s(arg0);
  }

  public void glTexCoord1sv(Addressable arg0) {
    glut_h.glTexCoord1sv(arg0);
  }

  public void glTexCoord2d(double arg0, double arg1) {
    glut_h.glTexCoord2d(arg0, arg1);
  }

  public void glTexCoord2dv(Addressable arg0) {
    glut_h.glTexCoord2dv(arg0);
  }

  public void glTexCoord2f(float arg0, float arg1) {
    glut_h.glTexCoord2f(arg0, arg1);
  }

  public void glTexCoord2fv(Addressable arg0) {
    glut_h.glTexCoord2fv(arg0);
  }

  public void glTexCoord2i(int arg0, int arg1) {
    glut_h.glTexCoord2i(arg0, arg1);
  }

  public void glTexCoord2iv(Addressable arg0) {
    glut_h.glTexCoord2iv(arg0);
  }

  public void glTexCoord2s(short arg0, short arg1) {
    glut_h.glTexCoord2s(arg0, arg1);
  }

  public void glTexCoord2sv(Addressable arg0) {
    glut_h.glTexCoord2sv(arg0);
  }

  public void glTexCoord3d(double arg0, double arg1, double arg2) {
    glut_h.glTexCoord3d(arg0, arg1, arg2);
  }

  public void glTexCoord3dv(Addressable arg0) {
    glut_h.glTexCoord3dv(arg0);
  }

  public void glTexCoord3f(float arg0, float arg1, float arg2) {
    glut_h.glTexCoord3f(arg0, arg1, arg2);
  }

  public void glTexCoord3fv(Addressable arg0) {
    glut_h.glTexCoord3fv(arg0);
  }

  public void glTexCoord3i(int arg0, int arg1, int arg2) {
    glut_h.glTexCoord3i(arg0, arg1, arg2);
  }

  public void glTexCoord3iv(Addressable arg0) {
    glut_h.glTexCoord3iv(arg0);
  }

  public void glTexCoord3s(short arg0, short arg1, short arg2) {
    glut_h.glTexCoord3s(arg0, arg1, arg2);
  }

  public void glTexCoord3sv(Addressable arg0) {
    glut_h.glTexCoord3sv(arg0);
  }

  public void glTexCoord4d(double arg0, double arg1, double arg2, double arg3) {
    glut_h.glTexCoord4d(arg0, arg1, arg2, arg3);
  }

  public void glTexCoord4dv(Addressable arg0) {
    glut_h.glTexCoord4dv(arg0);
  }

  public void glTexCoord4f(float arg0, float arg1, float arg2, float arg3) {
    glut_h.glTexCoord4f(arg0, arg1, arg2, arg3);
  }

  public void glTexCoord4fv(Addressable arg0) {
    glut_h.glTexCoord4fv(arg0);
  }

  public void glTexCoord4i(int arg0, int arg1, int arg2, int arg3) {
    glut_h.glTexCoord4i(arg0, arg1, arg2, arg3);
  }

  public void glTexCoord4iv(Addressable arg0) {
    glut_h.glTexCoord4iv(arg0);
  }

  public void glTexCoord4s(short arg0, short arg1, short arg2, short arg3) {
    glut_h.glTexCoord4s(arg0, arg1, arg2, arg3);
  }

  public void glTexCoord4sv(Addressable arg0) {
    glut_h.glTexCoord4sv(arg0);
  }

  public void glTexCoordPointer(int arg0, int arg1, int arg2, Addressable arg3) {
    glut_h.glTexCoordPointer(arg0, arg1, arg2, arg3);
  }

  public void glTexEnvf(int arg0, int arg1, float arg2) {
    glut_h.glTexEnvf(arg0, arg1, arg2);
  }

  public void glTexEnvfv(int arg0, int arg1, Addressable arg2) {
    glut_h.glTexEnvfv(arg0, arg1, arg2);
  }

  public void glTexEnvi(int arg0, int arg1, int arg2) {
    glut_h.glTexEnvi(arg0, arg1, arg2);
  }

  public void glTexEnviv(int arg0, int arg1, Addressable arg2) {
    glut_h.glTexEnviv(arg0, arg1, arg2);
  }

  public void glTexGend(int arg0, int arg1, double arg2) {
    glut_h.glTexGend(arg0, arg1, arg2);
  }

  public void glTexGendv(int arg0, int arg1, Addressable arg2) {
    glut_h.glTexGendv(arg0, arg1, arg2);
  }

  public void glTexGenf(int arg0, int arg1, float arg2) {
    glut_h.glTexGenf(arg0, arg1, arg2);
  }

  public void glTexGenfv(int arg0, int arg1, Addressable arg2) {
    glut_h.glTexGenfv(arg0, arg1, arg2);
  }

  public void glTexGeni(int arg0, int arg1, int arg2) {
    glut_h.glTexGeni(arg0, arg1, arg2);
  }

  public void glTexGeniv(int arg0, int arg1, Addressable arg2) {
    glut_h.glTexGeniv(arg0, arg1, arg2);
  }

  public void glTexImage1D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, Addressable arg7) {
    glut_h.glTexImage1D(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7);
  }

  public void glTexImage2D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, Addressable arg8) {
    glut_h.glTexImage2D(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
  }

  public void glTexImage3D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, Addressable arg9) {
    glut_h.glTexImage3D(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9);
  }

  public void glTexParameterf(int arg0, int arg1, float arg2) {
    glut_h.glTexParameterf(arg0, arg1, arg2);
  }

  public void glTexParameterfv(int arg0, int arg1, Addressable arg2) {
    glut_h.glTexParameterfv(arg0, arg1, arg2);
  }

  public void glTexParameteri(int arg0, int arg1, int arg2) {
    glut_h.glTexParameteri(arg0, arg1, arg2);
  }

  public void glTexParameteriv(int arg0, int arg1, Addressable arg2) {
    glut_h.glTexParameteriv(arg0, arg1, arg2);
  }

  public void glTexSubImage1D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, Addressable arg6) {
    glut_h.glTexSubImage1D(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
  }

  public void glTexSubImage2D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, Addressable arg8) {
    glut_h.glTexSubImage2D(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
  }

  public void glTexSubImage3D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, Addressable arg10) {
    glut_h.glTexSubImage3D(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10);
  }

  public void glTranslated(double arg0, double arg1, double arg2) {
    glut_h.glTranslated(arg0, arg1, arg2);
  }

  public void glTranslatef(float arg0, float arg1, float arg2) {
    glut_h.glTranslatef(arg0, arg1, arg2);
  }

  public void glVertex2d(double arg0, double arg1) {
    glut_h.glVertex2d(arg0, arg1);
  }

  public void glVertex2dv(Addressable arg0) {
    glut_h.glVertex2dv(arg0);
  }

  public void glVertex2f(float arg0, float arg1) {
    glut_h.glVertex2f(arg0, arg1);
  }

  public void glVertex2fv(Addressable arg0) {
    glut_h.glVertex2fv(arg0);
  }

  public void glVertex2i(int arg0, int arg1) {
    glut_h.glVertex2i(arg0, arg1);
  }

  public void glVertex2iv(Addressable arg0) {
    glut_h.glVertex2iv(arg0);
  }

  public void glVertex2s(short arg0, short arg1) {
    glut_h.glVertex2s(arg0, arg1);
  }

  public void glVertex2sv(Addressable arg0) {
    glut_h.glVertex2sv(arg0);
  }

  public void glVertex3d(double arg0, double arg1, double arg2) {
    glut_h.glVertex3d(arg0, arg1, arg2);
  }

  public void glVertex3dv(Addressable arg0) {
    glut_h.glVertex3dv(arg0);
  }

  public void glVertex3f(float arg0, float arg1, float arg2) {
    glut_h.glVertex3f(arg0, arg1, arg2);
  }

  public void glVertex3fv(Addressable arg0) {
    glut_h.glVertex3fv(arg0);
  }

  public void glVertex3i(int arg0, int arg1, int arg2) {
    glut_h.glVertex3i(arg0, arg1, arg2);
  }

  public void glVertex3iv(Addressable arg0) {
    glut_h.glVertex3iv(arg0);
  }

  public void glVertex3s(short arg0, short arg1, short arg2) {
    glut_h.glVertex3s(arg0, arg1, arg2);
  }

  public void glVertex3sv(Addressable arg0) {
    glut_h.glVertex3sv(arg0);
  }

  public void glVertex4d(double arg0, double arg1, double arg2, double arg3) {
    glut_h.glVertex4d(arg0, arg1, arg2, arg3);
  }

  public void glVertex4dv(Addressable arg0) {
    glut_h.glVertex4dv(arg0);
  }

  public void glVertex4f(float arg0, float arg1, float arg2, float arg3) {
    glut_h.glVertex4f(arg0, arg1, arg2, arg3);
  }

  public void glVertex4fv(Addressable arg0) {
    glut_h.glVertex4fv(arg0);
  }

  public void glVertex4i(int arg0, int arg1, int arg2, int arg3) {
    glut_h.glVertex4i(arg0, arg1, arg2, arg3);
  }

  public void glVertex4iv(Addressable arg0) {
    glut_h.glVertex4iv(arg0);
  }

  public void glVertex4s(short arg0, short arg1, short arg2, short arg3) {
    glut_h.glVertex4s(arg0, arg1, arg2, arg3);
  }

  public void glVertex4sv(Addressable arg0) {
    glut_h.glVertex4sv(arg0);
  }

  public void glVertexPointer(int arg0, int arg1, int arg2, Addressable arg3) {
    glut_h.glVertexPointer(arg0, arg1, arg2, arg3);
  }

  public void glViewport(int arg0, int arg1, int arg2, int arg3) {
    glut_h.glViewport(arg0, arg1, arg2, arg3);
  }

}
