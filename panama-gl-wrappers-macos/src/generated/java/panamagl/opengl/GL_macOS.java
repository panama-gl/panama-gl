package panamagl.opengl; 

import opengl.macos.v10_15_7.glut_h;
import static opengl.macos.v10_15_7.glut_h.*;
import java.lang.foreign.*;

public class GL_macOS implements GL_1_0, GL_1_1, GL_1_2, GL_1_3 {
  public void glAccum(int arg0, float arg1) {
    glut_h.glAccum(arg0, arg1);
  }

  public void glActiveStencilFaceEXT(int arg0) {
    glut_h.glActiveStencilFaceEXT(arg0);
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

  public void glAttachObjectARB(Addressable arg0, Addressable arg1) {
    glut_h.glAttachObjectARB(arg0, arg1);
  }

  public void glAttachShader(int arg0, int arg1) {
    glut_h.glAttachShader(arg0, arg1);
  }

  public void glBegin(int arg0) {
    glut_h.glBegin(arg0);
  }

  public void glBeginConditionalRenderNV(int arg0, int arg1) {
    glut_h.glBeginConditionalRenderNV(arg0, arg1);
  }

  public void glBeginQuery(int arg0, int arg1) {
    glut_h.glBeginQuery(arg0, arg1);
  }

  public void glBeginQueryARB(int arg0, int arg1) {
    glut_h.glBeginQueryARB(arg0, arg1);
  }

  public void glBeginTransformFeedbackEXT(int arg0) {
    glut_h.glBeginTransformFeedbackEXT(arg0);
  }

  public void glBindAttribLocation(int arg0, int arg1, Addressable arg2) {
    glut_h.glBindAttribLocation(arg0, arg1, arg2);
  }

  public void glBindAttribLocationARB(Addressable arg0, int arg1, Addressable arg2) {
    glut_h.glBindAttribLocationARB(arg0, arg1, arg2);
  }

  public void glBindBuffer(int arg0, int arg1) {
    glut_h.glBindBuffer(arg0, arg1);
  }

  public void glBindBufferARB(int arg0, int arg1) {
    glut_h.glBindBufferARB(arg0, arg1);
  }

  public void glBindBufferBaseEXT(int arg0, int arg1, int arg2) {
    glut_h.glBindBufferBaseEXT(arg0, arg1, arg2);
  }

  public void glBindBufferOffsetEXT(int arg0, int arg1, int arg2, long arg3) {
    glut_h.glBindBufferOffsetEXT(arg0, arg1, arg2, arg3);
  }

  public void glBindBufferRangeEXT(int arg0, int arg1, int arg2, long arg3, long arg4) {
    glut_h.glBindBufferRangeEXT(arg0, arg1, arg2, arg3, arg4);
  }

  public void glBindFragDataLocationEXT(int arg0, int arg1, Addressable arg2) {
    glut_h.glBindFragDataLocationEXT(arg0, arg1, arg2);
  }

  public void glBindFramebuffer(int arg0, int arg1) {
    glut_h.glBindFramebuffer(arg0, arg1);
  }

  public void glBindFramebufferEXT(int arg0, int arg1) {
    glut_h.glBindFramebufferEXT(arg0, arg1);
  }

  public void glBindProgramARB(int arg0, int arg1) {
    glut_h.glBindProgramARB(arg0, arg1);
  }

  public void glBindRenderbuffer(int arg0, int arg1) {
    glut_h.glBindRenderbuffer(arg0, arg1);
  }

  public void glBindRenderbufferEXT(int arg0, int arg1) {
    glut_h.glBindRenderbufferEXT(arg0, arg1);
  }

  public void glBindTexture(int arg0, int arg1) {
    glut_h.glBindTexture(arg0, arg1);
  }

  public void glBindVertexArrayAPPLE(int arg0) {
    glut_h.glBindVertexArrayAPPLE(arg0);
  }

  public void glBitmap(int arg0, int arg1, float arg2, float arg3, float arg4, float arg5, Addressable arg6) {
    glut_h.glBitmap(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
  }

  public void glBlendColor(float arg0, float arg1, float arg2, float arg3) {
    glut_h.glBlendColor(arg0, arg1, arg2, arg3);
  }

  public void glBlendColorEXT(float arg0, float arg1, float arg2, float arg3) {
    glut_h.glBlendColorEXT(arg0, arg1, arg2, arg3);
  }

  public void glBlendEquation(int arg0) {
    glut_h.glBlendEquation(arg0);
  }

  public void glBlendEquationEXT(int arg0) {
    glut_h.glBlendEquationEXT(arg0);
  }

  public void glBlendEquationSeparate(int arg0, int arg1) {
    glut_h.glBlendEquationSeparate(arg0, arg1);
  }

  public void glBlendEquationSeparateEXT(int arg0, int arg1) {
    glut_h.glBlendEquationSeparateEXT(arg0, arg1);
  }

  public void glBlendFunc(int arg0, int arg1) {
    glut_h.glBlendFunc(arg0, arg1);
  }

  public void glBlendFuncSeparate(int arg0, int arg1, int arg2, int arg3) {
    glut_h.glBlendFuncSeparate(arg0, arg1, arg2, arg3);
  }

  public void glBlendFuncSeparateEXT(int arg0, int arg1, int arg2, int arg3) {
    glut_h.glBlendFuncSeparateEXT(arg0, arg1, arg2, arg3);
  }

  public void glBlitFramebuffer(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9) {
    glut_h.glBlitFramebuffer(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9);
  }

  public void glBlitFramebufferEXT(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9) {
    glut_h.glBlitFramebufferEXT(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9);
  }

  public void glBufferData(int arg0, long arg1, Addressable arg2, int arg3) {
    glut_h.glBufferData(arg0, arg1, arg2, arg3);
  }

  public void glBufferDataARB(int arg0, long arg1, Addressable arg2, int arg3) {
    glut_h.glBufferDataARB(arg0, arg1, arg2, arg3);
  }

  public void glBufferParameteriAPPLE(int arg0, int arg1, int arg2) {
    glut_h.glBufferParameteriAPPLE(arg0, arg1, arg2);
  }

  public void glBufferSubData(int arg0, long arg1, long arg2, Addressable arg3) {
    glut_h.glBufferSubData(arg0, arg1, arg2, arg3);
  }

  public void glBufferSubDataARB(int arg0, long arg1, long arg2, Addressable arg3) {
    glut_h.glBufferSubDataARB(arg0, arg1, arg2, arg3);
  }

  public void glCallList(int arg0) {
    glut_h.glCallList(arg0);
  }

  public void glCallLists(int arg0, int arg1, Addressable arg2) {
    glut_h.glCallLists(arg0, arg1, arg2);
  }

  public int glCheckFramebufferStatus(int arg0) {
    return glut_h.glCheckFramebufferStatus(arg0);
  }

  public int glCheckFramebufferStatusEXT(int arg0) {
    return glut_h.glCheckFramebufferStatusEXT(arg0);
  }

  public void glClampColorARB(int arg0, int arg1) {
    glut_h.glClampColorARB(arg0, arg1);
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

  public void glClearColorIiEXT(int arg0, int arg1, int arg2, int arg3) {
    glut_h.glClearColorIiEXT(arg0, arg1, arg2, arg3);
  }

  public void glClearColorIuiEXT(int arg0, int arg1, int arg2, int arg3) {
    glut_h.glClearColorIuiEXT(arg0, arg1, arg2, arg3);
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

  public int glClientWaitSync(Addressable arg0, int arg1, long arg2) {
    return glut_h.glClientWaitSync(arg0, arg1, arg2);
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

  public void glColorMaskIndexedEXT(int arg0, byte arg1, byte arg2, byte arg3, byte arg4) {
    glut_h.glColorMaskIndexedEXT(arg0, arg1, arg2, arg3, arg4);
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

  public void glCompileShader(int arg0) {
    glut_h.glCompileShader(arg0);
  }

  public void glCompileShaderARB(Addressable arg0) {
    glut_h.glCompileShaderARB(arg0);
  }

  public void glCompressedTexImage1D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, Addressable arg6) {
    glut_h.glCompressedTexImage1D(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
  }

  public void glCompressedTexImage1DARB(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, Addressable arg6) {
    glut_h.glCompressedTexImage1DARB(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
  }

  public void glCompressedTexImage2D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, Addressable arg7) {
    glut_h.glCompressedTexImage2D(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7);
  }

  public void glCompressedTexImage2DARB(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, Addressable arg7) {
    glut_h.glCompressedTexImage2DARB(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7);
  }

  public void glCompressedTexImage3D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, Addressable arg8) {
    glut_h.glCompressedTexImage3D(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
  }

  public void glCompressedTexImage3DARB(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, Addressable arg8) {
    glut_h.glCompressedTexImage3DARB(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
  }

  public void glCompressedTexSubImage1D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, Addressable arg6) {
    glut_h.glCompressedTexSubImage1D(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
  }

  public void glCompressedTexSubImage1DARB(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, Addressable arg6) {
    glut_h.glCompressedTexSubImage1DARB(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
  }

  public void glCompressedTexSubImage2D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, Addressable arg8) {
    glut_h.glCompressedTexSubImage2D(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
  }

  public void glCompressedTexSubImage2DARB(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, Addressable arg8) {
    glut_h.glCompressedTexSubImage2DARB(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
  }

  public void glCompressedTexSubImage3D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, Addressable arg10) {
    glut_h.glCompressedTexSubImage3D(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10);
  }

  public void glCompressedTexSubImage3DARB(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, Addressable arg10) {
    glut_h.glCompressedTexSubImage3DARB(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10);
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

  public int glCreateProgram() {
    return glut_h.glCreateProgram();
  }

  public MemoryAddress glCreateProgramObjectARB() {
    return glut_h.glCreateProgramObjectARB();
  }

  public int glCreateShader(int arg0) {
    return glut_h.glCreateShader(arg0);
  }

  public MemoryAddress glCreateShaderObjectARB(int arg0) {
    return glut_h.glCreateShaderObjectARB(arg0);
  }

  public void glCullFace(int arg0) {
    glut_h.glCullFace(arg0);
  }

  public void glDeleteBuffers(int arg0, Addressable arg1) {
    glut_h.glDeleteBuffers(arg0, arg1);
  }

  public void glDeleteBuffersARB(int arg0, Addressable arg1) {
    glut_h.glDeleteBuffersARB(arg0, arg1);
  }

  public void glDeleteFencesAPPLE(int arg0, Addressable arg1) {
    glut_h.glDeleteFencesAPPLE(arg0, arg1);
  }

  public void glDeleteFramebuffers(int arg0, Addressable arg1) {
    glut_h.glDeleteFramebuffers(arg0, arg1);
  }

  public void glDeleteFramebuffersEXT(int arg0, Addressable arg1) {
    glut_h.glDeleteFramebuffersEXT(arg0, arg1);
  }

  public void glDeleteLists(int arg0, int arg1) {
    glut_h.glDeleteLists(arg0, arg1);
  }

  public void glDeleteObjectARB(Addressable arg0) {
    glut_h.glDeleteObjectARB(arg0);
  }

  public void glDeleteProgram(int arg0) {
    glut_h.glDeleteProgram(arg0);
  }

  public void glDeleteProgramsARB(int arg0, Addressable arg1) {
    glut_h.glDeleteProgramsARB(arg0, arg1);
  }

  public void glDeleteQueries(int arg0, Addressable arg1) {
    glut_h.glDeleteQueries(arg0, arg1);
  }

  public void glDeleteQueriesARB(int arg0, Addressable arg1) {
    glut_h.glDeleteQueriesARB(arg0, arg1);
  }

  public void glDeleteRenderbuffers(int arg0, Addressable arg1) {
    glut_h.glDeleteRenderbuffers(arg0, arg1);
  }

  public void glDeleteRenderbuffersEXT(int arg0, Addressable arg1) {
    glut_h.glDeleteRenderbuffersEXT(arg0, arg1);
  }

  public void glDeleteShader(int arg0) {
    glut_h.glDeleteShader(arg0);
  }

  public void glDeleteSync(Addressable arg0) {
    glut_h.glDeleteSync(arg0);
  }

  public void glDeleteTextures(int arg0, Addressable arg1) {
    glut_h.glDeleteTextures(arg0, arg1);
  }

  public void glDeleteVertexArraysAPPLE(int arg0, Addressable arg1) {
    glut_h.glDeleteVertexArraysAPPLE(arg0, arg1);
  }

  public void glDepthBoundsEXT(double arg0, double arg1) {
    glut_h.glDepthBoundsEXT(arg0, arg1);
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

  public void glDetachObjectARB(Addressable arg0, Addressable arg1) {
    glut_h.glDetachObjectARB(arg0, arg1);
  }

  public void glDetachShader(int arg0, int arg1) {
    glut_h.glDetachShader(arg0, arg1);
  }

  public void glDisable(int arg0) {
    glut_h.glDisable(arg0);
  }

  public void glDisableClientState(int arg0) {
    glut_h.glDisableClientState(arg0);
  }

  public void glDisableIndexedEXT(int arg0, int arg1) {
    glut_h.glDisableIndexedEXT(arg0, arg1);
  }

  public void glDisableVertexAttribAPPLE(int arg0, int arg1) {
    glut_h.glDisableVertexAttribAPPLE(arg0, arg1);
  }

  public void glDisableVertexAttribArray(int arg0) {
    glut_h.glDisableVertexAttribArray(arg0);
  }

  public void glDisableVertexAttribArrayARB(int arg0) {
    glut_h.glDisableVertexAttribArrayARB(arg0);
  }

  public void glDrawArrays(int arg0, int arg1, int arg2) {
    glut_h.glDrawArrays(arg0, arg1, arg2);
  }

  public void glDrawArraysInstancedARB(int arg0, int arg1, int arg2, int arg3) {
    glut_h.glDrawArraysInstancedARB(arg0, arg1, arg2, arg3);
  }

  public void glDrawBuffer(int arg0) {
    glut_h.glDrawBuffer(arg0);
  }

  public void glDrawBuffers(int arg0, Addressable arg1) {
    glut_h.glDrawBuffers(arg0, arg1);
  }

  public void glDrawBuffersARB(int arg0, Addressable arg1) {
    glut_h.glDrawBuffersARB(arg0, arg1);
  }

  public void glDrawElementArrayAPPLE(int arg0, int arg1, int arg2) {
    glut_h.glDrawElementArrayAPPLE(arg0, arg1, arg2);
  }

  public void glDrawElements(int arg0, int arg1, int arg2, Addressable arg3) {
    glut_h.glDrawElements(arg0, arg1, arg2, arg3);
  }

  public void glDrawElementsBaseVertex(int arg0, int arg1, int arg2, Addressable arg3, int arg4) {
    glut_h.glDrawElementsBaseVertex(arg0, arg1, arg2, arg3, arg4);
  }

  public void glDrawElementsInstancedARB(int arg0, int arg1, int arg2, Addressable arg3, int arg4) {
    glut_h.glDrawElementsInstancedARB(arg0, arg1, arg2, arg3, arg4);
  }

  public void glDrawElementsInstancedBaseVertex(int arg0, int arg1, int arg2, Addressable arg3, int arg4, int arg5) {
    glut_h.glDrawElementsInstancedBaseVertex(arg0, arg1, arg2, arg3, arg4, arg5);
  }

  public void glDrawPixels(int arg0, int arg1, int arg2, int arg3, Addressable arg4) {
    glut_h.glDrawPixels(arg0, arg1, arg2, arg3, arg4);
  }

  public void glDrawRangeElementArrayAPPLE(int arg0, int arg1, int arg2, int arg3, int arg4) {
    glut_h.glDrawRangeElementArrayAPPLE(arg0, arg1, arg2, arg3, arg4);
  }

  public void glDrawRangeElements(int arg0, int arg1, int arg2, int arg3, int arg4, Addressable arg5) {
    glut_h.glDrawRangeElements(arg0, arg1, arg2, arg3, arg4, arg5);
  }

  public void glDrawRangeElementsBaseVertex(int arg0, int arg1, int arg2, int arg3, int arg4, Addressable arg5, int arg6) {
    glut_h.glDrawRangeElementsBaseVertex(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
  }

  public void glDrawRangeElementsEXT(int arg0, int arg1, int arg2, int arg3, int arg4, Addressable arg5) {
    glut_h.glDrawRangeElementsEXT(arg0, arg1, arg2, arg3, arg4, arg5);
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

  public void glElementPointerAPPLE(int arg0, Addressable arg1) {
    glut_h.glElementPointerAPPLE(arg0, arg1);
  }

  public void glEnable(int arg0) {
    glut_h.glEnable(arg0);
  }

  public void glEnableClientState(int arg0) {
    glut_h.glEnableClientState(arg0);
  }

  public void glEnableIndexedEXT(int arg0, int arg1) {
    glut_h.glEnableIndexedEXT(arg0, arg1);
  }

  public void glEnableVertexAttribAPPLE(int arg0, int arg1) {
    glut_h.glEnableVertexAttribAPPLE(arg0, arg1);
  }

  public void glEnableVertexAttribArray(int arg0) {
    glut_h.glEnableVertexAttribArray(arg0);
  }

  public void glEnableVertexAttribArrayARB(int arg0) {
    glut_h.glEnableVertexAttribArrayARB(arg0);
  }

  public void glEnd() {
    glut_h.glEnd();
  }

  public void glEndConditionalRenderNV() {
    glut_h.glEndConditionalRenderNV();
  }

  public void glEndList() {
    glut_h.glEndList();
  }

  public void glEndQuery(int arg0) {
    glut_h.glEndQuery(arg0);
  }

  public void glEndQueryARB(int arg0) {
    glut_h.glEndQueryARB(arg0);
  }

  public void glEndTransformFeedbackEXT() {
    glut_h.glEndTransformFeedbackEXT();
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

  public MemoryAddress glFenceSync(int arg0, int arg1) {
    return glut_h.glFenceSync(arg0, arg1);
  }

  public void glFinish() {
    glut_h.glFinish();
  }

  public void glFinishFenceAPPLE(int arg0) {
    glut_h.glFinishFenceAPPLE(arg0);
  }

  public void glFinishObjectAPPLE(int arg0, int arg1) {
    glut_h.glFinishObjectAPPLE(arg0, arg1);
  }

  public void glFlush() {
    glut_h.glFlush();
  }

  public void glFlushMappedBufferRangeAPPLE(int arg0, long arg1, long arg2) {
    glut_h.glFlushMappedBufferRangeAPPLE(arg0, arg1, arg2);
  }

  public void glFlushVertexArrayRangeAPPLE(int arg0, Addressable arg1) {
    glut_h.glFlushVertexArrayRangeAPPLE(arg0, arg1);
  }

  public void glFogCoordPointer(int arg0, int arg1, Addressable arg2) {
    glut_h.glFogCoordPointer(arg0, arg1, arg2);
  }

  public void glFogCoordPointerEXT(int arg0, int arg1, Addressable arg2) {
    glut_h.glFogCoordPointerEXT(arg0, arg1, arg2);
  }

  public void glFogCoordd(double arg0) {
    glut_h.glFogCoordd(arg0);
  }

  public void glFogCoorddEXT(double arg0) {
    glut_h.glFogCoorddEXT(arg0);
  }

  public void glFogCoorddv(Addressable arg0) {
    glut_h.glFogCoorddv(arg0);
  }

  public void glFogCoorddvEXT(Addressable arg0) {
    glut_h.glFogCoorddvEXT(arg0);
  }

  public void glFogCoordf(float arg0) {
    glut_h.glFogCoordf(arg0);
  }

  public void glFogCoordfEXT(float arg0) {
    glut_h.glFogCoordfEXT(arg0);
  }

  public void glFogCoordfv(Addressable arg0) {
    glut_h.glFogCoordfv(arg0);
  }

  public void glFogCoordfvEXT(Addressable arg0) {
    glut_h.glFogCoordfvEXT(arg0);
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

  public void glFramebufferRenderbuffer(int arg0, int arg1, int arg2, int arg3) {
    glut_h.glFramebufferRenderbuffer(arg0, arg1, arg2, arg3);
  }

  public void glFramebufferRenderbufferEXT(int arg0, int arg1, int arg2, int arg3) {
    glut_h.glFramebufferRenderbufferEXT(arg0, arg1, arg2, arg3);
  }

  public void glFramebufferTexture1D(int arg0, int arg1, int arg2, int arg3, int arg4) {
    glut_h.glFramebufferTexture1D(arg0, arg1, arg2, arg3, arg4);
  }

  public void glFramebufferTexture1DEXT(int arg0, int arg1, int arg2, int arg3, int arg4) {
    glut_h.glFramebufferTexture1DEXT(arg0, arg1, arg2, arg3, arg4);
  }

  public void glFramebufferTexture2D(int arg0, int arg1, int arg2, int arg3, int arg4) {
    glut_h.glFramebufferTexture2D(arg0, arg1, arg2, arg3, arg4);
  }

  public void glFramebufferTexture2DEXT(int arg0, int arg1, int arg2, int arg3, int arg4) {
    glut_h.glFramebufferTexture2DEXT(arg0, arg1, arg2, arg3, arg4);
  }

  public void glFramebufferTexture3D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5) {
    glut_h.glFramebufferTexture3D(arg0, arg1, arg2, arg3, arg4, arg5);
  }

  public void glFramebufferTexture3DEXT(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5) {
    glut_h.glFramebufferTexture3DEXT(arg0, arg1, arg2, arg3, arg4, arg5);
  }

  public void glFramebufferTextureEXT(int arg0, int arg1, int arg2, int arg3) {
    glut_h.glFramebufferTextureEXT(arg0, arg1, arg2, arg3);
  }

  public void glFramebufferTextureFaceEXT(int arg0, int arg1, int arg2, int arg3, int arg4) {
    glut_h.glFramebufferTextureFaceEXT(arg0, arg1, arg2, arg3, arg4);
  }

  public void glFramebufferTextureLayer(int arg0, int arg1, int arg2, int arg3, int arg4) {
    glut_h.glFramebufferTextureLayer(arg0, arg1, arg2, arg3, arg4);
  }

  public void glFramebufferTextureLayerEXT(int arg0, int arg1, int arg2, int arg3, int arg4) {
    glut_h.glFramebufferTextureLayerEXT(arg0, arg1, arg2, arg3, arg4);
  }

  public void glFrontFace(int arg0) {
    glut_h.glFrontFace(arg0);
  }

  public void glFrustum(double arg0, double arg1, double arg2, double arg3, double arg4, double arg5) {
    glut_h.glFrustum(arg0, arg1, arg2, arg3, arg4, arg5);
  }

  public void glGenBuffers(int arg0, Addressable arg1) {
    glut_h.glGenBuffers(arg0, arg1);
  }

  public void glGenBuffersARB(int arg0, Addressable arg1) {
    glut_h.glGenBuffersARB(arg0, arg1);
  }

  public void glGenFencesAPPLE(int arg0, Addressable arg1) {
    glut_h.glGenFencesAPPLE(arg0, arg1);
  }

  public void glGenFramebuffers(int arg0, Addressable arg1) {
    glut_h.glGenFramebuffers(arg0, arg1);
  }

  public void glGenFramebuffersEXT(int arg0, Addressable arg1) {
    glut_h.glGenFramebuffersEXT(arg0, arg1);
  }

  public int glGenLists(int arg0) {
    return glut_h.glGenLists(arg0);
  }

  public void glGenProgramsARB(int arg0, Addressable arg1) {
    glut_h.glGenProgramsARB(arg0, arg1);
  }

  public void glGenQueries(int arg0, Addressable arg1) {
    glut_h.glGenQueries(arg0, arg1);
  }

  public void glGenQueriesARB(int arg0, Addressable arg1) {
    glut_h.glGenQueriesARB(arg0, arg1);
  }

  public void glGenRenderbuffers(int arg0, Addressable arg1) {
    glut_h.glGenRenderbuffers(arg0, arg1);
  }

  public void glGenRenderbuffersEXT(int arg0, Addressable arg1) {
    glut_h.glGenRenderbuffersEXT(arg0, arg1);
  }

  public void glGenTextures(int arg0, Addressable arg1) {
    glut_h.glGenTextures(arg0, arg1);
  }

  public void glGenVertexArraysAPPLE(int arg0, Addressable arg1) {
    glut_h.glGenVertexArraysAPPLE(arg0, arg1);
  }

  public void glGenerateMipmap(int arg0) {
    glut_h.glGenerateMipmap(arg0);
  }

  public void glGenerateMipmapEXT(int arg0) {
    glut_h.glGenerateMipmapEXT(arg0);
  }

  public void glGetActiveAttrib(int arg0, int arg1, int arg2, Addressable arg3, Addressable arg4, Addressable arg5, Addressable arg6) {
    glut_h.glGetActiveAttrib(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
  }

  public void glGetActiveAttribARB(Addressable arg0, int arg1, int arg2, Addressable arg3, Addressable arg4, Addressable arg5, Addressable arg6) {
    glut_h.glGetActiveAttribARB(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
  }

  public void glGetActiveUniform(int arg0, int arg1, int arg2, Addressable arg3, Addressable arg4, Addressable arg5, Addressable arg6) {
    glut_h.glGetActiveUniform(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
  }

  public void glGetActiveUniformARB(Addressable arg0, int arg1, int arg2, Addressable arg3, Addressable arg4, Addressable arg5, Addressable arg6) {
    glut_h.glGetActiveUniformARB(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
  }

  public void glGetAttachedObjectsARB(Addressable arg0, int arg1, Addressable arg2, Addressable arg3) {
    glut_h.glGetAttachedObjectsARB(arg0, arg1, arg2, arg3);
  }

  public void glGetAttachedShaders(int arg0, int arg1, Addressable arg2, Addressable arg3) {
    glut_h.glGetAttachedShaders(arg0, arg1, arg2, arg3);
  }

  public int glGetAttribLocation(int arg0, Addressable arg1) {
    return glut_h.glGetAttribLocation(arg0, arg1);
  }

  public int glGetAttribLocationARB(Addressable arg0, Addressable arg1) {
    return glut_h.glGetAttribLocationARB(arg0, arg1);
  }

  public void glGetBooleanIndexedvEXT(int arg0, int arg1, Addressable arg2) {
    glut_h.glGetBooleanIndexedvEXT(arg0, arg1, arg2);
  }

  public void glGetBooleanv(int arg0, Addressable arg1) {
    glut_h.glGetBooleanv(arg0, arg1);
  }

  public void glGetBufferParameteriv(int arg0, int arg1, Addressable arg2) {
    glut_h.glGetBufferParameteriv(arg0, arg1, arg2);
  }

  public void glGetBufferParameterivARB(int arg0, int arg1, Addressable arg2) {
    glut_h.glGetBufferParameterivARB(arg0, arg1, arg2);
  }

  public void glGetBufferPointerv(int arg0, int arg1, Addressable arg2) {
    glut_h.glGetBufferPointerv(arg0, arg1, arg2);
  }

  public void glGetBufferPointervARB(int arg0, int arg1, Addressable arg2) {
    glut_h.glGetBufferPointervARB(arg0, arg1, arg2);
  }

  public void glGetBufferSubData(int arg0, long arg1, long arg2, Addressable arg3) {
    glut_h.glGetBufferSubData(arg0, arg1, arg2, arg3);
  }

  public void glGetBufferSubDataARB(int arg0, long arg1, long arg2, Addressable arg3) {
    glut_h.glGetBufferSubDataARB(arg0, arg1, arg2, arg3);
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

  public void glGetCompressedTexImageARB(int arg0, int arg1, Addressable arg2) {
    glut_h.glGetCompressedTexImageARB(arg0, arg1, arg2);
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

  public int glGetFragDataLocationEXT(int arg0, Addressable arg1) {
    return glut_h.glGetFragDataLocationEXT(arg0, arg1);
  }

  public void glGetFramebufferAttachmentParameteriv(int arg0, int arg1, int arg2, Addressable arg3) {
    glut_h.glGetFramebufferAttachmentParameteriv(arg0, arg1, arg2, arg3);
  }

  public void glGetFramebufferAttachmentParameterivEXT(int arg0, int arg1, int arg2, Addressable arg3) {
    glut_h.glGetFramebufferAttachmentParameterivEXT(arg0, arg1, arg2, arg3);
  }

  public MemoryAddress glGetHandleARB(int arg0) {
    return glut_h.glGetHandleARB(arg0);
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

  public void glGetInfoLogARB(Addressable arg0, int arg1, Addressable arg2, Addressable arg3) {
    glut_h.glGetInfoLogARB(arg0, arg1, arg2, arg3);
  }

  public void glGetInteger64v(int arg0, Addressable arg1) {
    glut_h.glGetInteger64v(arg0, arg1);
  }

  public void glGetIntegerIndexedvEXT(int arg0, int arg1, Addressable arg2) {
    glut_h.glGetIntegerIndexedvEXT(arg0, arg1, arg2);
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

  public void glGetObjectLabelEXT(int arg0, int arg1, int arg2, Addressable arg3, Addressable arg4) {
    glut_h.glGetObjectLabelEXT(arg0, arg1, arg2, arg3, arg4);
  }

  public void glGetObjectParameterfvARB(Addressable arg0, int arg1, Addressable arg2) {
    glut_h.glGetObjectParameterfvARB(arg0, arg1, arg2);
  }

  public void glGetObjectParameterivAPPLE(int arg0, int arg1, int arg2, Addressable arg3) {
    glut_h.glGetObjectParameterivAPPLE(arg0, arg1, arg2, arg3);
  }

  public void glGetObjectParameterivARB(Addressable arg0, int arg1, Addressable arg2) {
    glut_h.glGetObjectParameterivARB(arg0, arg1, arg2);
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

  public void glGetProgramEnvParameterdvARB(int arg0, int arg1, Addressable arg2) {
    glut_h.glGetProgramEnvParameterdvARB(arg0, arg1, arg2);
  }

  public void glGetProgramEnvParameterfvARB(int arg0, int arg1, Addressable arg2) {
    glut_h.glGetProgramEnvParameterfvARB(arg0, arg1, arg2);
  }

  public void glGetProgramInfoLog(int arg0, int arg1, Addressable arg2, Addressable arg3) {
    glut_h.glGetProgramInfoLog(arg0, arg1, arg2, arg3);
  }

  public void glGetProgramLocalParameterdvARB(int arg0, int arg1, Addressable arg2) {
    glut_h.glGetProgramLocalParameterdvARB(arg0, arg1, arg2);
  }

  public void glGetProgramLocalParameterfvARB(int arg0, int arg1, Addressable arg2) {
    glut_h.glGetProgramLocalParameterfvARB(arg0, arg1, arg2);
  }

  public void glGetProgramStringARB(int arg0, int arg1, Addressable arg2) {
    glut_h.glGetProgramStringARB(arg0, arg1, arg2);
  }

  public void glGetProgramiv(int arg0, int arg1, Addressable arg2) {
    glut_h.glGetProgramiv(arg0, arg1, arg2);
  }

  public void glGetProgramivARB(int arg0, int arg1, Addressable arg2) {
    glut_h.glGetProgramivARB(arg0, arg1, arg2);
  }

  public void glGetQueryObjecti64vEXT(int arg0, int arg1, Addressable arg2) {
    glut_h.glGetQueryObjecti64vEXT(arg0, arg1, arg2);
  }

  public void glGetQueryObjectiv(int arg0, int arg1, Addressable arg2) {
    glut_h.glGetQueryObjectiv(arg0, arg1, arg2);
  }

  public void glGetQueryObjectivARB(int arg0, int arg1, Addressable arg2) {
    glut_h.glGetQueryObjectivARB(arg0, arg1, arg2);
  }

  public void glGetQueryObjectui64vEXT(int arg0, int arg1, Addressable arg2) {
    glut_h.glGetQueryObjectui64vEXT(arg0, arg1, arg2);
  }

  public void glGetQueryObjectuiv(int arg0, int arg1, Addressable arg2) {
    glut_h.glGetQueryObjectuiv(arg0, arg1, arg2);
  }

  public void glGetQueryObjectuivARB(int arg0, int arg1, Addressable arg2) {
    glut_h.glGetQueryObjectuivARB(arg0, arg1, arg2);
  }

  public void glGetQueryiv(int arg0, int arg1, Addressable arg2) {
    glut_h.glGetQueryiv(arg0, arg1, arg2);
  }

  public void glGetQueryivARB(int arg0, int arg1, Addressable arg2) {
    glut_h.glGetQueryivARB(arg0, arg1, arg2);
  }

  public void glGetRenderbufferParameteriv(int arg0, int arg1, Addressable arg2) {
    glut_h.glGetRenderbufferParameteriv(arg0, arg1, arg2);
  }

  public void glGetRenderbufferParameterivEXT(int arg0, int arg1, Addressable arg2) {
    glut_h.glGetRenderbufferParameterivEXT(arg0, arg1, arg2);
  }

  public void glGetSeparableFilter(int arg0, int arg1, int arg2, Addressable arg3, Addressable arg4, Addressable arg5) {
    glut_h.glGetSeparableFilter(arg0, arg1, arg2, arg3, arg4, arg5);
  }

  public void glGetShaderInfoLog(int arg0, int arg1, Addressable arg2, Addressable arg3) {
    glut_h.glGetShaderInfoLog(arg0, arg1, arg2, arg3);
  }

  public void glGetShaderSource(int arg0, int arg1, Addressable arg2, Addressable arg3) {
    glut_h.glGetShaderSource(arg0, arg1, arg2, arg3);
  }

  public void glGetShaderSourceARB(Addressable arg0, int arg1, Addressable arg2, Addressable arg3) {
    glut_h.glGetShaderSourceARB(arg0, arg1, arg2, arg3);
  }

  public void glGetShaderiv(int arg0, int arg1, Addressable arg2) {
    glut_h.glGetShaderiv(arg0, arg1, arg2);
  }

  public String glGetString(int arg0) {
    return glut_h.glGetString(arg0).getUtf8String(0);
  }

  public void glGetSynciv(Addressable arg0, int arg1, int arg2, Addressable arg3, Addressable arg4) {
    glut_h.glGetSynciv(arg0, arg1, arg2, arg3, arg4);
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

  public void glGetTexParameterIivEXT(int arg0, int arg1, Addressable arg2) {
    glut_h.glGetTexParameterIivEXT(arg0, arg1, arg2);
  }

  public void glGetTexParameterIuivEXT(int arg0, int arg1, Addressable arg2) {
    glut_h.glGetTexParameterIuivEXT(arg0, arg1, arg2);
  }

  public void glGetTexParameterPointervAPPLE(int arg0, int arg1, Addressable arg2) {
    glut_h.glGetTexParameterPointervAPPLE(arg0, arg1, arg2);
  }

  public void glGetTexParameterfv(int arg0, int arg1, Addressable arg2) {
    glut_h.glGetTexParameterfv(arg0, arg1, arg2);
  }

  public void glGetTexParameteriv(int arg0, int arg1, Addressable arg2) {
    glut_h.glGetTexParameteriv(arg0, arg1, arg2);
  }

  public void glGetTransformFeedbackVaryingEXT(int arg0, int arg1, int arg2, Addressable arg3, Addressable arg4, Addressable arg5, Addressable arg6) {
    glut_h.glGetTransformFeedbackVaryingEXT(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
  }

  public int glGetUniformBufferSizeEXT(int arg0, int arg1) {
    return glut_h.glGetUniformBufferSizeEXT(arg0, arg1);
  }

  public int glGetUniformLocation(int arg0, Addressable arg1) {
    return glut_h.glGetUniformLocation(arg0, arg1);
  }

  public int glGetUniformLocationARB(Addressable arg0, Addressable arg1) {
    return glut_h.glGetUniformLocationARB(arg0, arg1);
  }

  public long glGetUniformOffsetEXT(int arg0, int arg1) {
    return glut_h.glGetUniformOffsetEXT(arg0, arg1);
  }

  public void glGetUniformfv(int arg0, int arg1, Addressable arg2) {
    glut_h.glGetUniformfv(arg0, arg1, arg2);
  }

  public void glGetUniformfvARB(Addressable arg0, int arg1, Addressable arg2) {
    glut_h.glGetUniformfvARB(arg0, arg1, arg2);
  }

  public void glGetUniformiv(int arg0, int arg1, Addressable arg2) {
    glut_h.glGetUniformiv(arg0, arg1, arg2);
  }

  public void glGetUniformivARB(Addressable arg0, int arg1, Addressable arg2) {
    glut_h.glGetUniformivARB(arg0, arg1, arg2);
  }

  public void glGetUniformuivEXT(int arg0, int arg1, Addressable arg2) {
    glut_h.glGetUniformuivEXT(arg0, arg1, arg2);
  }

  public void glGetVertexAttribIivEXT(int arg0, int arg1, Addressable arg2) {
    glut_h.glGetVertexAttribIivEXT(arg0, arg1, arg2);
  }

  public void glGetVertexAttribIuivEXT(int arg0, int arg1, Addressable arg2) {
    glut_h.glGetVertexAttribIuivEXT(arg0, arg1, arg2);
  }

  public void glGetVertexAttribPointerv(int arg0, int arg1, Addressable arg2) {
    glut_h.glGetVertexAttribPointerv(arg0, arg1, arg2);
  }

  public void glGetVertexAttribPointervARB(int arg0, int arg1, Addressable arg2) {
    glut_h.glGetVertexAttribPointervARB(arg0, arg1, arg2);
  }

  public void glGetVertexAttribdv(int arg0, int arg1, Addressable arg2) {
    glut_h.glGetVertexAttribdv(arg0, arg1, arg2);
  }

  public void glGetVertexAttribdvARB(int arg0, int arg1, Addressable arg2) {
    glut_h.glGetVertexAttribdvARB(arg0, arg1, arg2);
  }

  public void glGetVertexAttribfv(int arg0, int arg1, Addressable arg2) {
    glut_h.glGetVertexAttribfv(arg0, arg1, arg2);
  }

  public void glGetVertexAttribfvARB(int arg0, int arg1, Addressable arg2) {
    glut_h.glGetVertexAttribfvARB(arg0, arg1, arg2);
  }

  public void glGetVertexAttribiv(int arg0, int arg1, Addressable arg2) {
    glut_h.glGetVertexAttribiv(arg0, arg1, arg2);
  }

  public void glGetVertexAttribivARB(int arg0, int arg1, Addressable arg2) {
    glut_h.glGetVertexAttribivARB(arg0, arg1, arg2);
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

  public void glInsertEventMarkerEXT(int arg0, Addressable arg1) {
    glut_h.glInsertEventMarkerEXT(arg0, arg1);
  }

  public void glInterleavedArrays(int arg0, int arg1, Addressable arg2) {
    glut_h.glInterleavedArrays(arg0, arg1, arg2);
  }

  public byte glIsBuffer(int arg0) {
    return glut_h.glIsBuffer(arg0);
  }

  public byte glIsBufferARB(int arg0) {
    return glut_h.glIsBufferARB(arg0);
  }

  public byte glIsEnabled(int arg0) {
    return glut_h.glIsEnabled(arg0);
  }

  public byte glIsEnabledIndexedEXT(int arg0, int arg1) {
    return glut_h.glIsEnabledIndexedEXT(arg0, arg1);
  }

  public byte glIsFenceAPPLE(int arg0) {
    return glut_h.glIsFenceAPPLE(arg0);
  }

  public byte glIsFramebuffer(int arg0) {
    return glut_h.glIsFramebuffer(arg0);
  }

  public byte glIsFramebufferEXT(int arg0) {
    return glut_h.glIsFramebufferEXT(arg0);
  }

  public byte glIsList(int arg0) {
    return glut_h.glIsList(arg0);
  }

  public byte glIsProgram(int arg0) {
    return glut_h.glIsProgram(arg0);
  }

  public byte glIsProgramARB(int arg0) {
    return glut_h.glIsProgramARB(arg0);
  }

  public byte glIsQuery(int arg0) {
    return glut_h.glIsQuery(arg0);
  }

  public byte glIsQueryARB(int arg0) {
    return glut_h.glIsQueryARB(arg0);
  }

  public byte glIsRenderbuffer(int arg0) {
    return glut_h.glIsRenderbuffer(arg0);
  }

  public byte glIsRenderbufferEXT(int arg0) {
    return glut_h.glIsRenderbufferEXT(arg0);
  }

  public byte glIsShader(int arg0) {
    return glut_h.glIsShader(arg0);
  }

  public byte glIsSync(Addressable arg0) {
    return glut_h.glIsSync(arg0);
  }

  public byte glIsTexture(int arg0) {
    return glut_h.glIsTexture(arg0);
  }

  public byte glIsVertexArrayAPPLE(int arg0) {
    return glut_h.glIsVertexArrayAPPLE(arg0);
  }

  public byte glIsVertexAttribEnabledAPPLE(int arg0, int arg1) {
    return glut_h.glIsVertexAttribEnabledAPPLE(arg0, arg1);
  }

  public void glLabelObjectEXT(int arg0, int arg1, int arg2, Addressable arg3) {
    glut_h.glLabelObjectEXT(arg0, arg1, arg2, arg3);
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

  public void glLinkProgram(int arg0) {
    glut_h.glLinkProgram(arg0);
  }

  public void glLinkProgramARB(Addressable arg0) {
    glut_h.glLinkProgramARB(arg0);
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

  public void glLoadTransposeMatrixdARB(Addressable arg0) {
    glut_h.glLoadTransposeMatrixdARB(arg0);
  }

  public void glLoadTransposeMatrixf(Addressable arg0) {
    glut_h.glLoadTransposeMatrixf(arg0);
  }

  public void glLoadTransposeMatrixfARB(Addressable arg0) {
    glut_h.glLoadTransposeMatrixfARB(arg0);
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

  public MemoryAddress glMapBuffer(int arg0, int arg1) {
    return glut_h.glMapBuffer(arg0, arg1);
  }

  public MemoryAddress glMapBufferARB(int arg0, int arg1) {
    return glut_h.glMapBufferARB(arg0, arg1);
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

  public void glMapVertexAttrib1dAPPLE(int arg0, int arg1, double arg2, double arg3, int arg4, int arg5, Addressable arg6) {
    glut_h.glMapVertexAttrib1dAPPLE(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
  }

  public void glMapVertexAttrib1fAPPLE(int arg0, int arg1, float arg2, float arg3, int arg4, int arg5, Addressable arg6) {
    glut_h.glMapVertexAttrib1fAPPLE(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
  }

  public void glMapVertexAttrib2dAPPLE(int arg0, int arg1, double arg2, double arg3, int arg4, int arg5, double arg6, double arg7, int arg8, int arg9, Addressable arg10) {
    glut_h.glMapVertexAttrib2dAPPLE(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10);
  }

  public void glMapVertexAttrib2fAPPLE(int arg0, int arg1, float arg2, float arg3, int arg4, int arg5, float arg6, float arg7, int arg8, int arg9, Addressable arg10) {
    glut_h.glMapVertexAttrib2fAPPLE(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10);
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

  public void glMultTransposeMatrixdARB(Addressable arg0) {
    glut_h.glMultTransposeMatrixdARB(arg0);
  }

  public void glMultTransposeMatrixf(Addressable arg0) {
    glut_h.glMultTransposeMatrixf(arg0);
  }

  public void glMultTransposeMatrixfARB(Addressable arg0) {
    glut_h.glMultTransposeMatrixfARB(arg0);
  }

  public void glMultiDrawArrays(int arg0, Addressable arg1, Addressable arg2, int arg3) {
    glut_h.glMultiDrawArrays(arg0, arg1, arg2, arg3);
  }

  public void glMultiDrawArraysEXT(int arg0, Addressable arg1, Addressable arg2, int arg3) {
    glut_h.glMultiDrawArraysEXT(arg0, arg1, arg2, arg3);
  }

  public void glMultiDrawElementArrayAPPLE(int arg0, Addressable arg1, Addressable arg2, int arg3) {
    glut_h.glMultiDrawElementArrayAPPLE(arg0, arg1, arg2, arg3);
  }

  public void glMultiDrawElements(int arg0, Addressable arg1, int arg2, Addressable arg3, int arg4) {
    glut_h.glMultiDrawElements(arg0, arg1, arg2, arg3, arg4);
  }

  public void glMultiDrawElementsBaseVertex(int arg0, Addressable arg1, int arg2, Addressable arg3, int arg4, Addressable arg5) {
    glut_h.glMultiDrawElementsBaseVertex(arg0, arg1, arg2, arg3, arg4, arg5);
  }

  public void glMultiDrawElementsEXT(int arg0, Addressable arg1, int arg2, Addressable arg3, int arg4) {
    glut_h.glMultiDrawElementsEXT(arg0, arg1, arg2, arg3, arg4);
  }

  public void glMultiDrawRangeElementArrayAPPLE(int arg0, int arg1, int arg2, Addressable arg3, Addressable arg4, int arg5) {
    glut_h.glMultiDrawRangeElementArrayAPPLE(arg0, arg1, arg2, arg3, arg4, arg5);
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

  public int glObjectPurgeableAPPLE(int arg0, int arg1, int arg2) {
    return glut_h.glObjectPurgeableAPPLE(arg0, arg1, arg2);
  }

  public int glObjectUnpurgeableAPPLE(int arg0, int arg1, int arg2) {
    return glut_h.glObjectUnpurgeableAPPLE(arg0, arg1, arg2);
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

  public void glPointParameterf(int arg0, float arg1) {
    glut_h.glPointParameterf(arg0, arg1);
  }

  public void glPointParameterfARB(int arg0, float arg1) {
    glut_h.glPointParameterfARB(arg0, arg1);
  }

  public void glPointParameterfv(int arg0, Addressable arg1) {
    glut_h.glPointParameterfv(arg0, arg1);
  }

  public void glPointParameterfvARB(int arg0, Addressable arg1) {
    glut_h.glPointParameterfvARB(arg0, arg1);
  }

  public void glPointParameteri(int arg0, int arg1) {
    glut_h.glPointParameteri(arg0, arg1);
  }

  public void glPointParameteriNV(int arg0, int arg1) {
    glut_h.glPointParameteriNV(arg0, arg1);
  }

  public void glPointParameteriv(int arg0, Addressable arg1) {
    glut_h.glPointParameteriv(arg0, arg1);
  }

  public void glPointParameterivNV(int arg0, Addressable arg1) {
    glut_h.glPointParameterivNV(arg0, arg1);
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

  public void glPopGroupMarkerEXT() {
    glut_h.glPopGroupMarkerEXT();
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

  public void glProgramEnvParameter4dARB(int arg0, int arg1, double arg2, double arg3, double arg4, double arg5) {
    glut_h.glProgramEnvParameter4dARB(arg0, arg1, arg2, arg3, arg4, arg5);
  }

  public void glProgramEnvParameter4dvARB(int arg0, int arg1, Addressable arg2) {
    glut_h.glProgramEnvParameter4dvARB(arg0, arg1, arg2);
  }

  public void glProgramEnvParameter4fARB(int arg0, int arg1, float arg2, float arg3, float arg4, float arg5) {
    glut_h.glProgramEnvParameter4fARB(arg0, arg1, arg2, arg3, arg4, arg5);
  }

  public void glProgramEnvParameter4fvARB(int arg0, int arg1, Addressable arg2) {
    glut_h.glProgramEnvParameter4fvARB(arg0, arg1, arg2);
  }

  public void glProgramEnvParameters4fvEXT(int arg0, int arg1, int arg2, Addressable arg3) {
    glut_h.glProgramEnvParameters4fvEXT(arg0, arg1, arg2, arg3);
  }

  public void glProgramLocalParameter4dARB(int arg0, int arg1, double arg2, double arg3, double arg4, double arg5) {
    glut_h.glProgramLocalParameter4dARB(arg0, arg1, arg2, arg3, arg4, arg5);
  }

  public void glProgramLocalParameter4dvARB(int arg0, int arg1, Addressable arg2) {
    glut_h.glProgramLocalParameter4dvARB(arg0, arg1, arg2);
  }

  public void glProgramLocalParameter4fARB(int arg0, int arg1, float arg2, float arg3, float arg4, float arg5) {
    glut_h.glProgramLocalParameter4fARB(arg0, arg1, arg2, arg3, arg4, arg5);
  }

  public void glProgramLocalParameter4fvARB(int arg0, int arg1, Addressable arg2) {
    glut_h.glProgramLocalParameter4fvARB(arg0, arg1, arg2);
  }

  public void glProgramLocalParameters4fvEXT(int arg0, int arg1, int arg2, Addressable arg3) {
    glut_h.glProgramLocalParameters4fvEXT(arg0, arg1, arg2, arg3);
  }

  public void glProgramParameteriEXT(int arg0, int arg1, int arg2) {
    glut_h.glProgramParameteriEXT(arg0, arg1, arg2);
  }

  public void glProgramStringARB(int arg0, int arg1, int arg2, Addressable arg3) {
    glut_h.glProgramStringARB(arg0, arg1, arg2, arg3);
  }

  public void glProvokingVertex(int arg0) {
    glut_h.glProvokingVertex(arg0);
  }

  public void glProvokingVertexEXT(int arg0) {
    glut_h.glProvokingVertexEXT(arg0);
  }

  public void glPushAttrib(int arg0) {
    glut_h.glPushAttrib(arg0);
  }

  public void glPushClientAttrib(int arg0) {
    glut_h.glPushClientAttrib(arg0);
  }

  public void glPushGroupMarkerEXT(int arg0, Addressable arg1) {
    glut_h.glPushGroupMarkerEXT(arg0, arg1);
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

  public void glRenderbufferStorage(int arg0, int arg1, int arg2, int arg3) {
    glut_h.glRenderbufferStorage(arg0, arg1, arg2, arg3);
  }

  public void glRenderbufferStorageEXT(int arg0, int arg1, int arg2, int arg3) {
    glut_h.glRenderbufferStorageEXT(arg0, arg1, arg2, arg3);
  }

  public void glRenderbufferStorageMultisample(int arg0, int arg1, int arg2, int arg3, int arg4) {
    glut_h.glRenderbufferStorageMultisample(arg0, arg1, arg2, arg3, arg4);
  }

  public void glRenderbufferStorageMultisampleEXT(int arg0, int arg1, int arg2, int arg3, int arg4) {
    glut_h.glRenderbufferStorageMultisampleEXT(arg0, arg1, arg2, arg3, arg4);
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

  public void glSampleCoverageARB(float arg0, byte arg1) {
    glut_h.glSampleCoverageARB(arg0, arg1);
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

  public void glSecondaryColor3b(byte arg0, byte arg1, byte arg2) {
    glut_h.glSecondaryColor3b(arg0, arg1, arg2);
  }

  public void glSecondaryColor3bEXT(byte arg0, byte arg1, byte arg2) {
    glut_h.glSecondaryColor3bEXT(arg0, arg1, arg2);
  }

  public void glSecondaryColor3bv(Addressable arg0) {
    glut_h.glSecondaryColor3bv(arg0);
  }

  public void glSecondaryColor3bvEXT(Addressable arg0) {
    glut_h.glSecondaryColor3bvEXT(arg0);
  }

  public void glSecondaryColor3d(double arg0, double arg1, double arg2) {
    glut_h.glSecondaryColor3d(arg0, arg1, arg2);
  }

  public void glSecondaryColor3dEXT(double arg0, double arg1, double arg2) {
    glut_h.glSecondaryColor3dEXT(arg0, arg1, arg2);
  }

  public void glSecondaryColor3dv(Addressable arg0) {
    glut_h.glSecondaryColor3dv(arg0);
  }

  public void glSecondaryColor3dvEXT(Addressable arg0) {
    glut_h.glSecondaryColor3dvEXT(arg0);
  }

  public void glSecondaryColor3f(float arg0, float arg1, float arg2) {
    glut_h.glSecondaryColor3f(arg0, arg1, arg2);
  }

  public void glSecondaryColor3fEXT(float arg0, float arg1, float arg2) {
    glut_h.glSecondaryColor3fEXT(arg0, arg1, arg2);
  }

  public void glSecondaryColor3fv(Addressable arg0) {
    glut_h.glSecondaryColor3fv(arg0);
  }

  public void glSecondaryColor3fvEXT(Addressable arg0) {
    glut_h.glSecondaryColor3fvEXT(arg0);
  }

  public void glSecondaryColor3i(int arg0, int arg1, int arg2) {
    glut_h.glSecondaryColor3i(arg0, arg1, arg2);
  }

  public void glSecondaryColor3iEXT(int arg0, int arg1, int arg2) {
    glut_h.glSecondaryColor3iEXT(arg0, arg1, arg2);
  }

  public void glSecondaryColor3iv(Addressable arg0) {
    glut_h.glSecondaryColor3iv(arg0);
  }

  public void glSecondaryColor3ivEXT(Addressable arg0) {
    glut_h.glSecondaryColor3ivEXT(arg0);
  }

  public void glSecondaryColor3s(short arg0, short arg1, short arg2) {
    glut_h.glSecondaryColor3s(arg0, arg1, arg2);
  }

  public void glSecondaryColor3sEXT(short arg0, short arg1, short arg2) {
    glut_h.glSecondaryColor3sEXT(arg0, arg1, arg2);
  }

  public void glSecondaryColor3sv(Addressable arg0) {
    glut_h.glSecondaryColor3sv(arg0);
  }

  public void glSecondaryColor3svEXT(Addressable arg0) {
    glut_h.glSecondaryColor3svEXT(arg0);
  }

  public void glSecondaryColor3ub(byte arg0, byte arg1, byte arg2) {
    glut_h.glSecondaryColor3ub(arg0, arg1, arg2);
  }

  public void glSecondaryColor3ubEXT(byte arg0, byte arg1, byte arg2) {
    glut_h.glSecondaryColor3ubEXT(arg0, arg1, arg2);
  }

  public void glSecondaryColor3ubv(Addressable arg0) {
    glut_h.glSecondaryColor3ubv(arg0);
  }

  public void glSecondaryColor3ubvEXT(Addressable arg0) {
    glut_h.glSecondaryColor3ubvEXT(arg0);
  }

  public void glSecondaryColor3ui(int arg0, int arg1, int arg2) {
    glut_h.glSecondaryColor3ui(arg0, arg1, arg2);
  }

  public void glSecondaryColor3uiEXT(int arg0, int arg1, int arg2) {
    glut_h.glSecondaryColor3uiEXT(arg0, arg1, arg2);
  }

  public void glSecondaryColor3uiv(Addressable arg0) {
    glut_h.glSecondaryColor3uiv(arg0);
  }

  public void glSecondaryColor3uivEXT(Addressable arg0) {
    glut_h.glSecondaryColor3uivEXT(arg0);
  }

  public void glSecondaryColor3us(short arg0, short arg1, short arg2) {
    glut_h.glSecondaryColor3us(arg0, arg1, arg2);
  }

  public void glSecondaryColor3usEXT(short arg0, short arg1, short arg2) {
    glut_h.glSecondaryColor3usEXT(arg0, arg1, arg2);
  }

  public void glSecondaryColor3usv(Addressable arg0) {
    glut_h.glSecondaryColor3usv(arg0);
  }

  public void glSecondaryColor3usvEXT(Addressable arg0) {
    glut_h.glSecondaryColor3usvEXT(arg0);
  }

  public void glSecondaryColorPointer(int arg0, int arg1, int arg2, Addressable arg3) {
    glut_h.glSecondaryColorPointer(arg0, arg1, arg2, arg3);
  }

  public void glSecondaryColorPointerEXT(int arg0, int arg1, int arg2, Addressable arg3) {
    glut_h.glSecondaryColorPointerEXT(arg0, arg1, arg2, arg3);
  }

  public void glSelectBuffer(int arg0, Addressable arg1) {
    glut_h.glSelectBuffer(arg0, arg1);
  }

  public void glSeparableFilter2D(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, Addressable arg6, Addressable arg7) {
    glut_h.glSeparableFilter2D(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7);
  }

  public void glSetFenceAPPLE(int arg0) {
    glut_h.glSetFenceAPPLE(arg0);
  }

  public void glShadeModel(int arg0) {
    glut_h.glShadeModel(arg0);
  }

  public void glShaderSource(int arg0, int arg1, Addressable arg2, Addressable arg3) {
    glut_h.glShaderSource(arg0, arg1, arg2, arg3);
  }

  public void glShaderSourceARB(Addressable arg0, int arg1, Addressable arg2, Addressable arg3) {
    glut_h.glShaderSourceARB(arg0, arg1, arg2, arg3);
  }

  public void glStencilFunc(int arg0, int arg1, int arg2) {
    glut_h.glStencilFunc(arg0, arg1, arg2);
  }

  public void glStencilFuncSeparate(int arg0, int arg1, int arg2, int arg3) {
    glut_h.glStencilFuncSeparate(arg0, arg1, arg2, arg3);
  }

  public void glStencilFuncSeparateATI(int arg0, int arg1, int arg2, int arg3) {
    glut_h.glStencilFuncSeparateATI(arg0, arg1, arg2, arg3);
  }

  public void glStencilMask(int arg0) {
    glut_h.glStencilMask(arg0);
  }

  public void glStencilMaskSeparate(int arg0, int arg1) {
    glut_h.glStencilMaskSeparate(arg0, arg1);
  }

  public void glStencilOp(int arg0, int arg1, int arg2) {
    glut_h.glStencilOp(arg0, arg1, arg2);
  }

  public void glStencilOpSeparate(int arg0, int arg1, int arg2, int arg3) {
    glut_h.glStencilOpSeparate(arg0, arg1, arg2, arg3);
  }

  public void glStencilOpSeparateATI(int arg0, int arg1, int arg2, int arg3) {
    glut_h.glStencilOpSeparateATI(arg0, arg1, arg2, arg3);
  }

  public byte glTestFenceAPPLE(int arg0) {
    return glut_h.glTestFenceAPPLE(arg0);
  }

  public byte glTestObjectAPPLE(int arg0, int arg1) {
    return glut_h.glTestObjectAPPLE(arg0, arg1);
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

  public void glTexParameterIivEXT(int arg0, int arg1, Addressable arg2) {
    glut_h.glTexParameterIivEXT(arg0, arg1, arg2);
  }

  public void glTexParameterIuivEXT(int arg0, int arg1, Addressable arg2) {
    glut_h.glTexParameterIuivEXT(arg0, arg1, arg2);
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

  public void glTextureBarrierNV() {
    glut_h.glTextureBarrierNV();
  }

  public void glTextureRangeAPPLE(int arg0, int arg1, Addressable arg2) {
    glut_h.glTextureRangeAPPLE(arg0, arg1, arg2);
  }

  public void glTransformFeedbackVaryingsEXT(int arg0, int arg1, Addressable arg2, int arg3) {
    glut_h.glTransformFeedbackVaryingsEXT(arg0, arg1, arg2, arg3);
  }

  public void glTranslated(double arg0, double arg1, double arg2) {
    glut_h.glTranslated(arg0, arg1, arg2);
  }

  public void glTranslatef(float arg0, float arg1, float arg2) {
    glut_h.glTranslatef(arg0, arg1, arg2);
  }

  public void glUniform1f(int arg0, float arg1) {
    glut_h.glUniform1f(arg0, arg1);
  }

  public void glUniform1fARB(int arg0, float arg1) {
    glut_h.glUniform1fARB(arg0, arg1);
  }

  public void glUniform1fv(int arg0, int arg1, Addressable arg2) {
    glut_h.glUniform1fv(arg0, arg1, arg2);
  }

  public void glUniform1fvARB(int arg0, int arg1, Addressable arg2) {
    glut_h.glUniform1fvARB(arg0, arg1, arg2);
  }

  public void glUniform1i(int arg0, int arg1) {
    glut_h.glUniform1i(arg0, arg1);
  }

  public void glUniform1iARB(int arg0, int arg1) {
    glut_h.glUniform1iARB(arg0, arg1);
  }

  public void glUniform1iv(int arg0, int arg1, Addressable arg2) {
    glut_h.glUniform1iv(arg0, arg1, arg2);
  }

  public void glUniform1ivARB(int arg0, int arg1, Addressable arg2) {
    glut_h.glUniform1ivARB(arg0, arg1, arg2);
  }

  public void glUniform1uiEXT(int arg0, int arg1) {
    glut_h.glUniform1uiEXT(arg0, arg1);
  }

  public void glUniform1uivEXT(int arg0, int arg1, Addressable arg2) {
    glut_h.glUniform1uivEXT(arg0, arg1, arg2);
  }

  public void glUniform2f(int arg0, float arg1, float arg2) {
    glut_h.glUniform2f(arg0, arg1, arg2);
  }

  public void glUniform2fARB(int arg0, float arg1, float arg2) {
    glut_h.glUniform2fARB(arg0, arg1, arg2);
  }

  public void glUniform2fv(int arg0, int arg1, Addressable arg2) {
    glut_h.glUniform2fv(arg0, arg1, arg2);
  }

  public void glUniform2fvARB(int arg0, int arg1, Addressable arg2) {
    glut_h.glUniform2fvARB(arg0, arg1, arg2);
  }

  public void glUniform2i(int arg0, int arg1, int arg2) {
    glut_h.glUniform2i(arg0, arg1, arg2);
  }

  public void glUniform2iARB(int arg0, int arg1, int arg2) {
    glut_h.glUniform2iARB(arg0, arg1, arg2);
  }

  public void glUniform2iv(int arg0, int arg1, Addressable arg2) {
    glut_h.glUniform2iv(arg0, arg1, arg2);
  }

  public void glUniform2ivARB(int arg0, int arg1, Addressable arg2) {
    glut_h.glUniform2ivARB(arg0, arg1, arg2);
  }

  public void glUniform2uiEXT(int arg0, int arg1, int arg2) {
    glut_h.glUniform2uiEXT(arg0, arg1, arg2);
  }

  public void glUniform2uivEXT(int arg0, int arg1, Addressable arg2) {
    glut_h.glUniform2uivEXT(arg0, arg1, arg2);
  }

  public void glUniform3f(int arg0, float arg1, float arg2, float arg3) {
    glut_h.glUniform3f(arg0, arg1, arg2, arg3);
  }

  public void glUniform3fARB(int arg0, float arg1, float arg2, float arg3) {
    glut_h.glUniform3fARB(arg0, arg1, arg2, arg3);
  }

  public void glUniform3fv(int arg0, int arg1, Addressable arg2) {
    glut_h.glUniform3fv(arg0, arg1, arg2);
  }

  public void glUniform3fvARB(int arg0, int arg1, Addressable arg2) {
    glut_h.glUniform3fvARB(arg0, arg1, arg2);
  }

  public void glUniform3i(int arg0, int arg1, int arg2, int arg3) {
    glut_h.glUniform3i(arg0, arg1, arg2, arg3);
  }

  public void glUniform3iARB(int arg0, int arg1, int arg2, int arg3) {
    glut_h.glUniform3iARB(arg0, arg1, arg2, arg3);
  }

  public void glUniform3iv(int arg0, int arg1, Addressable arg2) {
    glut_h.glUniform3iv(arg0, arg1, arg2);
  }

  public void glUniform3ivARB(int arg0, int arg1, Addressable arg2) {
    glut_h.glUniform3ivARB(arg0, arg1, arg2);
  }

  public void glUniform3uiEXT(int arg0, int arg1, int arg2, int arg3) {
    glut_h.glUniform3uiEXT(arg0, arg1, arg2, arg3);
  }

  public void glUniform3uivEXT(int arg0, int arg1, Addressable arg2) {
    glut_h.glUniform3uivEXT(arg0, arg1, arg2);
  }

  public void glUniform4f(int arg0, float arg1, float arg2, float arg3, float arg4) {
    glut_h.glUniform4f(arg0, arg1, arg2, arg3, arg4);
  }

  public void glUniform4fARB(int arg0, float arg1, float arg2, float arg3, float arg4) {
    glut_h.glUniform4fARB(arg0, arg1, arg2, arg3, arg4);
  }

  public void glUniform4fv(int arg0, int arg1, Addressable arg2) {
    glut_h.glUniform4fv(arg0, arg1, arg2);
  }

  public void glUniform4fvARB(int arg0, int arg1, Addressable arg2) {
    glut_h.glUniform4fvARB(arg0, arg1, arg2);
  }

  public void glUniform4i(int arg0, int arg1, int arg2, int arg3, int arg4) {
    glut_h.glUniform4i(arg0, arg1, arg2, arg3, arg4);
  }

  public void glUniform4iARB(int arg0, int arg1, int arg2, int arg3, int arg4) {
    glut_h.glUniform4iARB(arg0, arg1, arg2, arg3, arg4);
  }

  public void glUniform4iv(int arg0, int arg1, Addressable arg2) {
    glut_h.glUniform4iv(arg0, arg1, arg2);
  }

  public void glUniform4ivARB(int arg0, int arg1, Addressable arg2) {
    glut_h.glUniform4ivARB(arg0, arg1, arg2);
  }

  public void glUniform4uiEXT(int arg0, int arg1, int arg2, int arg3, int arg4) {
    glut_h.glUniform4uiEXT(arg0, arg1, arg2, arg3, arg4);
  }

  public void glUniform4uivEXT(int arg0, int arg1, Addressable arg2) {
    glut_h.glUniform4uivEXT(arg0, arg1, arg2);
  }

  public void glUniformBufferEXT(int arg0, int arg1, int arg2) {
    glut_h.glUniformBufferEXT(arg0, arg1, arg2);
  }

  public void glUniformMatrix2fv(int arg0, int arg1, byte arg2, Addressable arg3) {
    glut_h.glUniformMatrix2fv(arg0, arg1, arg2, arg3);
  }

  public void glUniformMatrix2fvARB(int arg0, int arg1, byte arg2, Addressable arg3) {
    glut_h.glUniformMatrix2fvARB(arg0, arg1, arg2, arg3);
  }

  public void glUniformMatrix2x3fv(int arg0, int arg1, byte arg2, Addressable arg3) {
    glut_h.glUniformMatrix2x3fv(arg0, arg1, arg2, arg3);
  }

  public void glUniformMatrix2x4fv(int arg0, int arg1, byte arg2, Addressable arg3) {
    glut_h.glUniformMatrix2x4fv(arg0, arg1, arg2, arg3);
  }

  public void glUniformMatrix3fv(int arg0, int arg1, byte arg2, Addressable arg3) {
    glut_h.glUniformMatrix3fv(arg0, arg1, arg2, arg3);
  }

  public void glUniformMatrix3fvARB(int arg0, int arg1, byte arg2, Addressable arg3) {
    glut_h.glUniformMatrix3fvARB(arg0, arg1, arg2, arg3);
  }

  public void glUniformMatrix3x2fv(int arg0, int arg1, byte arg2, Addressable arg3) {
    glut_h.glUniformMatrix3x2fv(arg0, arg1, arg2, arg3);
  }

  public void glUniformMatrix3x4fv(int arg0, int arg1, byte arg2, Addressable arg3) {
    glut_h.glUniformMatrix3x4fv(arg0, arg1, arg2, arg3);
  }

  public void glUniformMatrix4fv(int arg0, int arg1, byte arg2, Addressable arg3) {
    glut_h.glUniformMatrix4fv(arg0, arg1, arg2, arg3);
  }

  public void glUniformMatrix4fvARB(int arg0, int arg1, byte arg2, Addressable arg3) {
    glut_h.glUniformMatrix4fvARB(arg0, arg1, arg2, arg3);
  }

  public void glUniformMatrix4x2fv(int arg0, int arg1, byte arg2, Addressable arg3) {
    glut_h.glUniformMatrix4x2fv(arg0, arg1, arg2, arg3);
  }

  public void glUniformMatrix4x3fv(int arg0, int arg1, byte arg2, Addressable arg3) {
    glut_h.glUniformMatrix4x3fv(arg0, arg1, arg2, arg3);
  }

  public byte glUnmapBuffer(int arg0) {
    return glut_h.glUnmapBuffer(arg0);
  }

  public byte glUnmapBufferARB(int arg0) {
    return glut_h.glUnmapBufferARB(arg0);
  }

  public void glUseProgram(int arg0) {
    glut_h.glUseProgram(arg0);
  }

  public void glUseProgramObjectARB(Addressable arg0) {
    glut_h.glUseProgramObjectARB(arg0);
  }

  public void glValidateProgram(int arg0) {
    glut_h.glValidateProgram(arg0);
  }

  public void glValidateProgramARB(Addressable arg0) {
    glut_h.glValidateProgramARB(arg0);
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

  public void glVertexArrayParameteriAPPLE(int arg0, int arg1) {
    glut_h.glVertexArrayParameteriAPPLE(arg0, arg1);
  }

  public void glVertexArrayRangeAPPLE(int arg0, Addressable arg1) {
    glut_h.glVertexArrayRangeAPPLE(arg0, arg1);
  }

  public void glVertexAttrib1d(int arg0, double arg1) {
    glut_h.glVertexAttrib1d(arg0, arg1);
  }

  public void glVertexAttrib1dARB(int arg0, double arg1) {
    glut_h.glVertexAttrib1dARB(arg0, arg1);
  }

  public void glVertexAttrib1dv(int arg0, Addressable arg1) {
    glut_h.glVertexAttrib1dv(arg0, arg1);
  }

  public void glVertexAttrib1dvARB(int arg0, Addressable arg1) {
    glut_h.glVertexAttrib1dvARB(arg0, arg1);
  }

  public void glVertexAttrib1f(int arg0, float arg1) {
    glut_h.glVertexAttrib1f(arg0, arg1);
  }

  public void glVertexAttrib1fARB(int arg0, float arg1) {
    glut_h.glVertexAttrib1fARB(arg0, arg1);
  }

  public void glVertexAttrib1fv(int arg0, Addressable arg1) {
    glut_h.glVertexAttrib1fv(arg0, arg1);
  }

  public void glVertexAttrib1fvARB(int arg0, Addressable arg1) {
    glut_h.glVertexAttrib1fvARB(arg0, arg1);
  }

  public void glVertexAttrib1s(int arg0, short arg1) {
    glut_h.glVertexAttrib1s(arg0, arg1);
  }

  public void glVertexAttrib1sARB(int arg0, short arg1) {
    glut_h.glVertexAttrib1sARB(arg0, arg1);
  }

  public void glVertexAttrib1sv(int arg0, Addressable arg1) {
    glut_h.glVertexAttrib1sv(arg0, arg1);
  }

  public void glVertexAttrib1svARB(int arg0, Addressable arg1) {
    glut_h.glVertexAttrib1svARB(arg0, arg1);
  }

  public void glVertexAttrib2d(int arg0, double arg1, double arg2) {
    glut_h.glVertexAttrib2d(arg0, arg1, arg2);
  }

  public void glVertexAttrib2dARB(int arg0, double arg1, double arg2) {
    glut_h.glVertexAttrib2dARB(arg0, arg1, arg2);
  }

  public void glVertexAttrib2dv(int arg0, Addressable arg1) {
    glut_h.glVertexAttrib2dv(arg0, arg1);
  }

  public void glVertexAttrib2dvARB(int arg0, Addressable arg1) {
    glut_h.glVertexAttrib2dvARB(arg0, arg1);
  }

  public void glVertexAttrib2f(int arg0, float arg1, float arg2) {
    glut_h.glVertexAttrib2f(arg0, arg1, arg2);
  }

  public void glVertexAttrib2fARB(int arg0, float arg1, float arg2) {
    glut_h.glVertexAttrib2fARB(arg0, arg1, arg2);
  }

  public void glVertexAttrib2fv(int arg0, Addressable arg1) {
    glut_h.glVertexAttrib2fv(arg0, arg1);
  }

  public void glVertexAttrib2fvARB(int arg0, Addressable arg1) {
    glut_h.glVertexAttrib2fvARB(arg0, arg1);
  }

  public void glVertexAttrib2s(int arg0, short arg1, short arg2) {
    glut_h.glVertexAttrib2s(arg0, arg1, arg2);
  }

  public void glVertexAttrib2sARB(int arg0, short arg1, short arg2) {
    glut_h.glVertexAttrib2sARB(arg0, arg1, arg2);
  }

  public void glVertexAttrib2sv(int arg0, Addressable arg1) {
    glut_h.glVertexAttrib2sv(arg0, arg1);
  }

  public void glVertexAttrib2svARB(int arg0, Addressable arg1) {
    glut_h.glVertexAttrib2svARB(arg0, arg1);
  }

  public void glVertexAttrib3d(int arg0, double arg1, double arg2, double arg3) {
    glut_h.glVertexAttrib3d(arg0, arg1, arg2, arg3);
  }

  public void glVertexAttrib3dARB(int arg0, double arg1, double arg2, double arg3) {
    glut_h.glVertexAttrib3dARB(arg0, arg1, arg2, arg3);
  }

  public void glVertexAttrib3dv(int arg0, Addressable arg1) {
    glut_h.glVertexAttrib3dv(arg0, arg1);
  }

  public void glVertexAttrib3dvARB(int arg0, Addressable arg1) {
    glut_h.glVertexAttrib3dvARB(arg0, arg1);
  }

  public void glVertexAttrib3f(int arg0, float arg1, float arg2, float arg3) {
    glut_h.glVertexAttrib3f(arg0, arg1, arg2, arg3);
  }

  public void glVertexAttrib3fARB(int arg0, float arg1, float arg2, float arg3) {
    glut_h.glVertexAttrib3fARB(arg0, arg1, arg2, arg3);
  }

  public void glVertexAttrib3fv(int arg0, Addressable arg1) {
    glut_h.glVertexAttrib3fv(arg0, arg1);
  }

  public void glVertexAttrib3fvARB(int arg0, Addressable arg1) {
    glut_h.glVertexAttrib3fvARB(arg0, arg1);
  }

  public void glVertexAttrib3s(int arg0, short arg1, short arg2, short arg3) {
    glut_h.glVertexAttrib3s(arg0, arg1, arg2, arg3);
  }

  public void glVertexAttrib3sARB(int arg0, short arg1, short arg2, short arg3) {
    glut_h.glVertexAttrib3sARB(arg0, arg1, arg2, arg3);
  }

  public void glVertexAttrib3sv(int arg0, Addressable arg1) {
    glut_h.glVertexAttrib3sv(arg0, arg1);
  }

  public void glVertexAttrib3svARB(int arg0, Addressable arg1) {
    glut_h.glVertexAttrib3svARB(arg0, arg1);
  }

  public void glVertexAttrib4Nbv(int arg0, Addressable arg1) {
    glut_h.glVertexAttrib4Nbv(arg0, arg1);
  }

  public void glVertexAttrib4NbvARB(int arg0, Addressable arg1) {
    glut_h.glVertexAttrib4NbvARB(arg0, arg1);
  }

  public void glVertexAttrib4Niv(int arg0, Addressable arg1) {
    glut_h.glVertexAttrib4Niv(arg0, arg1);
  }

  public void glVertexAttrib4NivARB(int arg0, Addressable arg1) {
    glut_h.glVertexAttrib4NivARB(arg0, arg1);
  }

  public void glVertexAttrib4Nsv(int arg0, Addressable arg1) {
    glut_h.glVertexAttrib4Nsv(arg0, arg1);
  }

  public void glVertexAttrib4NsvARB(int arg0, Addressable arg1) {
    glut_h.glVertexAttrib4NsvARB(arg0, arg1);
  }

  public void glVertexAttrib4Nub(int arg0, byte arg1, byte arg2, byte arg3, byte arg4) {
    glut_h.glVertexAttrib4Nub(arg0, arg1, arg2, arg3, arg4);
  }

  public void glVertexAttrib4NubARB(int arg0, byte arg1, byte arg2, byte arg3, byte arg4) {
    glut_h.glVertexAttrib4NubARB(arg0, arg1, arg2, arg3, arg4);
  }

  public void glVertexAttrib4Nubv(int arg0, Addressable arg1) {
    glut_h.glVertexAttrib4Nubv(arg0, arg1);
  }

  public void glVertexAttrib4NubvARB(int arg0, Addressable arg1) {
    glut_h.glVertexAttrib4NubvARB(arg0, arg1);
  }

  public void glVertexAttrib4Nuiv(int arg0, Addressable arg1) {
    glut_h.glVertexAttrib4Nuiv(arg0, arg1);
  }

  public void glVertexAttrib4NuivARB(int arg0, Addressable arg1) {
    glut_h.glVertexAttrib4NuivARB(arg0, arg1);
  }

  public void glVertexAttrib4Nusv(int arg0, Addressable arg1) {
    glut_h.glVertexAttrib4Nusv(arg0, arg1);
  }

  public void glVertexAttrib4NusvARB(int arg0, Addressable arg1) {
    glut_h.glVertexAttrib4NusvARB(arg0, arg1);
  }

  public void glVertexAttrib4bv(int arg0, Addressable arg1) {
    glut_h.glVertexAttrib4bv(arg0, arg1);
  }

  public void glVertexAttrib4bvARB(int arg0, Addressable arg1) {
    glut_h.glVertexAttrib4bvARB(arg0, arg1);
  }

  public void glVertexAttrib4d(int arg0, double arg1, double arg2, double arg3, double arg4) {
    glut_h.glVertexAttrib4d(arg0, arg1, arg2, arg3, arg4);
  }

  public void glVertexAttrib4dARB(int arg0, double arg1, double arg2, double arg3, double arg4) {
    glut_h.glVertexAttrib4dARB(arg0, arg1, arg2, arg3, arg4);
  }

  public void glVertexAttrib4dv(int arg0, Addressable arg1) {
    glut_h.glVertexAttrib4dv(arg0, arg1);
  }

  public void glVertexAttrib4dvARB(int arg0, Addressable arg1) {
    glut_h.glVertexAttrib4dvARB(arg0, arg1);
  }

  public void glVertexAttrib4f(int arg0, float arg1, float arg2, float arg3, float arg4) {
    glut_h.glVertexAttrib4f(arg0, arg1, arg2, arg3, arg4);
  }

  public void glVertexAttrib4fARB(int arg0, float arg1, float arg2, float arg3, float arg4) {
    glut_h.glVertexAttrib4fARB(arg0, arg1, arg2, arg3, arg4);
  }

  public void glVertexAttrib4fv(int arg0, Addressable arg1) {
    glut_h.glVertexAttrib4fv(arg0, arg1);
  }

  public void glVertexAttrib4fvARB(int arg0, Addressable arg1) {
    glut_h.glVertexAttrib4fvARB(arg0, arg1);
  }

  public void glVertexAttrib4iv(int arg0, Addressable arg1) {
    glut_h.glVertexAttrib4iv(arg0, arg1);
  }

  public void glVertexAttrib4ivARB(int arg0, Addressable arg1) {
    glut_h.glVertexAttrib4ivARB(arg0, arg1);
  }

  public void glVertexAttrib4s(int arg0, short arg1, short arg2, short arg3, short arg4) {
    glut_h.glVertexAttrib4s(arg0, arg1, arg2, arg3, arg4);
  }

  public void glVertexAttrib4sARB(int arg0, short arg1, short arg2, short arg3, short arg4) {
    glut_h.glVertexAttrib4sARB(arg0, arg1, arg2, arg3, arg4);
  }

  public void glVertexAttrib4sv(int arg0, Addressable arg1) {
    glut_h.glVertexAttrib4sv(arg0, arg1);
  }

  public void glVertexAttrib4svARB(int arg0, Addressable arg1) {
    glut_h.glVertexAttrib4svARB(arg0, arg1);
  }

  public void glVertexAttrib4ubv(int arg0, Addressable arg1) {
    glut_h.glVertexAttrib4ubv(arg0, arg1);
  }

  public void glVertexAttrib4ubvARB(int arg0, Addressable arg1) {
    glut_h.glVertexAttrib4ubvARB(arg0, arg1);
  }

  public void glVertexAttrib4uiv(int arg0, Addressable arg1) {
    glut_h.glVertexAttrib4uiv(arg0, arg1);
  }

  public void glVertexAttrib4uivARB(int arg0, Addressable arg1) {
    glut_h.glVertexAttrib4uivARB(arg0, arg1);
  }

  public void glVertexAttrib4usv(int arg0, Addressable arg1) {
    glut_h.glVertexAttrib4usv(arg0, arg1);
  }

  public void glVertexAttrib4usvARB(int arg0, Addressable arg1) {
    glut_h.glVertexAttrib4usvARB(arg0, arg1);
  }

  public void glVertexAttribDivisorARB(int arg0, int arg1) {
    glut_h.glVertexAttribDivisorARB(arg0, arg1);
  }

  public void glVertexAttribI1iEXT(int arg0, int arg1) {
    glut_h.glVertexAttribI1iEXT(arg0, arg1);
  }

  public void glVertexAttribI1ivEXT(int arg0, Addressable arg1) {
    glut_h.glVertexAttribI1ivEXT(arg0, arg1);
  }

  public void glVertexAttribI1uiEXT(int arg0, int arg1) {
    glut_h.glVertexAttribI1uiEXT(arg0, arg1);
  }

  public void glVertexAttribI1uivEXT(int arg0, Addressable arg1) {
    glut_h.glVertexAttribI1uivEXT(arg0, arg1);
  }

  public void glVertexAttribI2iEXT(int arg0, int arg1, int arg2) {
    glut_h.glVertexAttribI2iEXT(arg0, arg1, arg2);
  }

  public void glVertexAttribI2ivEXT(int arg0, Addressable arg1) {
    glut_h.glVertexAttribI2ivEXT(arg0, arg1);
  }

  public void glVertexAttribI2uiEXT(int arg0, int arg1, int arg2) {
    glut_h.glVertexAttribI2uiEXT(arg0, arg1, arg2);
  }

  public void glVertexAttribI2uivEXT(int arg0, Addressable arg1) {
    glut_h.glVertexAttribI2uivEXT(arg0, arg1);
  }

  public void glVertexAttribI3iEXT(int arg0, int arg1, int arg2, int arg3) {
    glut_h.glVertexAttribI3iEXT(arg0, arg1, arg2, arg3);
  }

  public void glVertexAttribI3ivEXT(int arg0, Addressable arg1) {
    glut_h.glVertexAttribI3ivEXT(arg0, arg1);
  }

  public void glVertexAttribI3uiEXT(int arg0, int arg1, int arg2, int arg3) {
    glut_h.glVertexAttribI3uiEXT(arg0, arg1, arg2, arg3);
  }

  public void glVertexAttribI3uivEXT(int arg0, Addressable arg1) {
    glut_h.glVertexAttribI3uivEXT(arg0, arg1);
  }

  public void glVertexAttribI4bvEXT(int arg0, Addressable arg1) {
    glut_h.glVertexAttribI4bvEXT(arg0, arg1);
  }

  public void glVertexAttribI4iEXT(int arg0, int arg1, int arg2, int arg3, int arg4) {
    glut_h.glVertexAttribI4iEXT(arg0, arg1, arg2, arg3, arg4);
  }

  public void glVertexAttribI4ivEXT(int arg0, Addressable arg1) {
    glut_h.glVertexAttribI4ivEXT(arg0, arg1);
  }

  public void glVertexAttribI4svEXT(int arg0, Addressable arg1) {
    glut_h.glVertexAttribI4svEXT(arg0, arg1);
  }

  public void glVertexAttribI4ubvEXT(int arg0, Addressable arg1) {
    glut_h.glVertexAttribI4ubvEXT(arg0, arg1);
  }

  public void glVertexAttribI4uiEXT(int arg0, int arg1, int arg2, int arg3, int arg4) {
    glut_h.glVertexAttribI4uiEXT(arg0, arg1, arg2, arg3, arg4);
  }

  public void glVertexAttribI4uivEXT(int arg0, Addressable arg1) {
    glut_h.glVertexAttribI4uivEXT(arg0, arg1);
  }

  public void glVertexAttribI4usvEXT(int arg0, Addressable arg1) {
    glut_h.glVertexAttribI4usvEXT(arg0, arg1);
  }

  public void glVertexAttribIPointerEXT(int arg0, int arg1, int arg2, int arg3, Addressable arg4) {
    glut_h.glVertexAttribIPointerEXT(arg0, arg1, arg2, arg3, arg4);
  }

  public void glVertexAttribPointer(int arg0, int arg1, int arg2, byte arg3, int arg4, Addressable arg5) {
    glut_h.glVertexAttribPointer(arg0, arg1, arg2, arg3, arg4, arg5);
  }

  public void glVertexAttribPointerARB(int arg0, int arg1, int arg2, byte arg3, int arg4, Addressable arg5) {
    glut_h.glVertexAttribPointerARB(arg0, arg1, arg2, arg3, arg4, arg5);
  }

  public void glVertexBlendARB(int arg0) {
    glut_h.glVertexBlendARB(arg0);
  }

  public void glVertexPointer(int arg0, int arg1, int arg2, Addressable arg3) {
    glut_h.glVertexPointer(arg0, arg1, arg2, arg3);
  }

  public void glViewport(int arg0, int arg1, int arg2, int arg3) {
    glut_h.glViewport(arg0, arg1, arg2, arg3);
  }

  public void glWaitSync(Addressable arg0, int arg1, long arg2) {
    glut_h.glWaitSync(arg0, arg1, arg2);
  }

  public void glWeightPointerARB(int arg0, int arg1, int arg2, Addressable arg3) {
    glut_h.glWeightPointerARB(arg0, arg1, arg2, arg3);
  }

  public void glWeightbvARB(int arg0, Addressable arg1) {
    glut_h.glWeightbvARB(arg0, arg1);
  }

  public void glWeightdvARB(int arg0, Addressable arg1) {
    glut_h.glWeightdvARB(arg0, arg1);
  }

  public void glWeightfvARB(int arg0, Addressable arg1) {
    glut_h.glWeightfvARB(arg0, arg1);
  }

  public void glWeightivARB(int arg0, Addressable arg1) {
    glut_h.glWeightivARB(arg0, arg1);
  }

  public void glWeightsvARB(int arg0, Addressable arg1) {
    glut_h.glWeightsvARB(arg0, arg1);
  }

  public void glWeightubvARB(int arg0, Addressable arg1) {
    glut_h.glWeightubvARB(arg0, arg1);
  }

  public void glWeightuivARB(int arg0, Addressable arg1) {
    glut_h.glWeightuivARB(arg0, arg1);
  }

  public void glWeightusvARB(int arg0, Addressable arg1) {
    glut_h.glWeightusvARB(arg0, arg1);
  }

  public void glWindowPos2d(double arg0, double arg1) {
    glut_h.glWindowPos2d(arg0, arg1);
  }

  public void glWindowPos2dARB(double arg0, double arg1) {
    glut_h.glWindowPos2dARB(arg0, arg1);
  }

  public void glWindowPos2dv(Addressable arg0) {
    glut_h.glWindowPos2dv(arg0);
  }

  public void glWindowPos2dvARB(Addressable arg0) {
    glut_h.glWindowPos2dvARB(arg0);
  }

  public void glWindowPos2f(float arg0, float arg1) {
    glut_h.glWindowPos2f(arg0, arg1);
  }

  public void glWindowPos2fARB(float arg0, float arg1) {
    glut_h.glWindowPos2fARB(arg0, arg1);
  }

  public void glWindowPos2fv(Addressable arg0) {
    glut_h.glWindowPos2fv(arg0);
  }

  public void glWindowPos2fvARB(Addressable arg0) {
    glut_h.glWindowPos2fvARB(arg0);
  }

  public void glWindowPos2i(int arg0, int arg1) {
    glut_h.glWindowPos2i(arg0, arg1);
  }

  public void glWindowPos2iARB(int arg0, int arg1) {
    glut_h.glWindowPos2iARB(arg0, arg1);
  }

  public void glWindowPos2iv(Addressable arg0) {
    glut_h.glWindowPos2iv(arg0);
  }

  public void glWindowPos2ivARB(Addressable arg0) {
    glut_h.glWindowPos2ivARB(arg0);
  }

  public void glWindowPos2s(short arg0, short arg1) {
    glut_h.glWindowPos2s(arg0, arg1);
  }

  public void glWindowPos2sARB(short arg0, short arg1) {
    glut_h.glWindowPos2sARB(arg0, arg1);
  }

  public void glWindowPos2sv(Addressable arg0) {
    glut_h.glWindowPos2sv(arg0);
  }

  public void glWindowPos2svARB(Addressable arg0) {
    glut_h.glWindowPos2svARB(arg0);
  }

  public void glWindowPos3d(double arg0, double arg1, double arg2) {
    glut_h.glWindowPos3d(arg0, arg1, arg2);
  }

  public void glWindowPos3dARB(double arg0, double arg1, double arg2) {
    glut_h.glWindowPos3dARB(arg0, arg1, arg2);
  }

  public void glWindowPos3dv(Addressable arg0) {
    glut_h.glWindowPos3dv(arg0);
  }

  public void glWindowPos3dvARB(Addressable arg0) {
    glut_h.glWindowPos3dvARB(arg0);
  }

  public void glWindowPos3f(float arg0, float arg1, float arg2) {
    glut_h.glWindowPos3f(arg0, arg1, arg2);
  }

  public void glWindowPos3fARB(float arg0, float arg1, float arg2) {
    glut_h.glWindowPos3fARB(arg0, arg1, arg2);
  }

  public void glWindowPos3fv(Addressable arg0) {
    glut_h.glWindowPos3fv(arg0);
  }

  public void glWindowPos3fvARB(Addressable arg0) {
    glut_h.glWindowPos3fvARB(arg0);
  }

  public void glWindowPos3i(int arg0, int arg1, int arg2) {
    glut_h.glWindowPos3i(arg0, arg1, arg2);
  }

  public void glWindowPos3iARB(int arg0, int arg1, int arg2) {
    glut_h.glWindowPos3iARB(arg0, arg1, arg2);
  }

  public void glWindowPos3iv(Addressable arg0) {
    glut_h.glWindowPos3iv(arg0);
  }

  public void glWindowPos3ivARB(Addressable arg0) {
    glut_h.glWindowPos3ivARB(arg0);
  }

  public void glWindowPos3s(short arg0, short arg1, short arg2) {
    glut_h.glWindowPos3s(arg0, arg1, arg2);
  }

  public void glWindowPos3sARB(short arg0, short arg1, short arg2) {
    glut_h.glWindowPos3sARB(arg0, arg1, arg2);
  }

  public void glWindowPos3sv(Addressable arg0) {
    glut_h.glWindowPos3sv(arg0);
  }

  public void glWindowPos3svARB(Addressable arg0) {
    glut_h.glWindowPos3svARB(arg0);
  }

}
