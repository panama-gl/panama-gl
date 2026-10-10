package panamagl.platform.linux.x64; 

import glext.linux.x86.glext_h;
import java.lang.foreign.*;
import opengl.linux.x86.*;

public class GL_linux_x64 extends panamagl.opengl.AGL implements panamagl.opengl.GL, panamagl.opengl.GLU, panamagl.opengl.GLUT {
  public GL_linux_x64() {
    setFunctionLoader(new panamagl.platform.linux.GLFunctionLoader_linux());
  }

  public void glAccum(int op, float value) {
    glext_h.glAccum(op, value);
  }

  public void glActiveTexture(int texture) {
    glext_h.glActiveTexture(texture);
  }

  public void glActiveTextureARB(int texture) {
    glext_h.glActiveTextureARB(texture);
  }

  public void glAlphaFunc(int func, float ref) {
    glext_h.glAlphaFunc(func, ref);
  }

  public byte glAreTexturesResident(int n, MemorySegment textures, MemorySegment residences) {
    return glext_h.glAreTexturesResident(n, textures, residences);
  }

  public void glArrayElement(int i) {
    glext_h.glArrayElement(i);
  }

  public void glBegin(int mode) {
    glext_h.glBegin(mode);
  }

  public void glBindTexture(int target, int texture) {
    glext_h.glBindTexture(target, texture);
  }

  public void glBitmap(int width, int height, float xorig, float yorig, float xmove, float ymove, MemorySegment bitmap) {
    glext_h.glBitmap(width, height, xorig, yorig, xmove, ymove, bitmap);
  }

  public void glBlendColor(float red, float green, float blue, float alpha) {
    glext_h.glBlendColor(red, green, blue, alpha);
  }

  public void glBlendEquation(int mode) {
    glext_h.glBlendEquation(mode);
  }

  public void glBlendFunc(int sfactor, int dfactor) {
    glext_h.glBlendFunc(sfactor, dfactor);
  }

  public void glCallList(int list) {
    glext_h.glCallList(list);
  }

  public void glCallLists(int n, int type, MemorySegment lists) {
    glext_h.glCallLists(n, type, lists);
  }

  public void glClear(int mask) {
    glext_h.glClear(mask);
  }

  public void glClearAccum(float red, float green, float blue, float alpha) {
    glext_h.glClearAccum(red, green, blue, alpha);
  }

  public void glClearColor(float red, float green, float blue, float alpha) {
    glext_h.glClearColor(red, green, blue, alpha);
  }

  public void glClearDepth(double depth) {
    glext_h.glClearDepth(depth);
  }

  public void glClearIndex(float c) {
    glext_h.glClearIndex(c);
  }

  public void glClearStencil(int s) {
    glext_h.glClearStencil(s);
  }

  public void glClientActiveTexture(int texture) {
    glext_h.glClientActiveTexture(texture);
  }

  public void glClientActiveTextureARB(int texture) {
    glext_h.glClientActiveTextureARB(texture);
  }

  public void glClipPlane(int plane, MemorySegment equation) {
    glext_h.glClipPlane(plane, equation);
  }

  public void glColor3b(byte red, byte green, byte blue) {
    glext_h.glColor3b(red, green, blue);
  }

  public void glColor3bv(MemorySegment v) {
    glext_h.glColor3bv(v);
  }

  public void glColor3d(double red, double green, double blue) {
    glext_h.glColor3d(red, green, blue);
  }

  public void glColor3dv(MemorySegment v) {
    glext_h.glColor3dv(v);
  }

  public void glColor3f(float red, float green, float blue) {
    glext_h.glColor3f(red, green, blue);
  }

  public void glColor3fv(MemorySegment v) {
    glext_h.glColor3fv(v);
  }

  public void glColor3i(int red, int green, int blue) {
    glext_h.glColor3i(red, green, blue);
  }

  public void glColor3iv(MemorySegment v) {
    glext_h.glColor3iv(v);
  }

  public void glColor3s(short red, short green, short blue) {
    glext_h.glColor3s(red, green, blue);
  }

  public void glColor3sv(MemorySegment v) {
    glext_h.glColor3sv(v);
  }

  public void glColor3ub(byte red, byte green, byte blue) {
    glext_h.glColor3ub(red, green, blue);
  }

  public void glColor3ubv(MemorySegment v) {
    glext_h.glColor3ubv(v);
  }

  public void glColor3ui(int red, int green, int blue) {
    glext_h.glColor3ui(red, green, blue);
  }

  public void glColor3uiv(MemorySegment v) {
    glext_h.glColor3uiv(v);
  }

  public void glColor3us(short red, short green, short blue) {
    glext_h.glColor3us(red, green, blue);
  }

  public void glColor3usv(MemorySegment v) {
    glext_h.glColor3usv(v);
  }

  public void glColor4b(byte red, byte green, byte blue, byte alpha) {
    glext_h.glColor4b(red, green, blue, alpha);
  }

  public void glColor4bv(MemorySegment v) {
    glext_h.glColor4bv(v);
  }

  public void glColor4d(double red, double green, double blue, double alpha) {
    glext_h.glColor4d(red, green, blue, alpha);
  }

  public void glColor4dv(MemorySegment v) {
    glext_h.glColor4dv(v);
  }

  public void glColor4f(float red, float green, float blue, float alpha) {
    glext_h.glColor4f(red, green, blue, alpha);
  }

  public void glColor4fv(MemorySegment v) {
    glext_h.glColor4fv(v);
  }

  public void glColor4i(int red, int green, int blue, int alpha) {
    glext_h.glColor4i(red, green, blue, alpha);
  }

  public void glColor4iv(MemorySegment v) {
    glext_h.glColor4iv(v);
  }

  public void glColor4s(short red, short green, short blue, short alpha) {
    glext_h.glColor4s(red, green, blue, alpha);
  }

  public void glColor4sv(MemorySegment v) {
    glext_h.glColor4sv(v);
  }

  public void glColor4ub(byte red, byte green, byte blue, byte alpha) {
    glext_h.glColor4ub(red, green, blue, alpha);
  }

  public void glColor4ubv(MemorySegment v) {
    glext_h.glColor4ubv(v);
  }

  public void glColor4ui(int red, int green, int blue, int alpha) {
    glext_h.glColor4ui(red, green, blue, alpha);
  }

  public void glColor4uiv(MemorySegment v) {
    glext_h.glColor4uiv(v);
  }

  public void glColor4us(short red, short green, short blue, short alpha) {
    glext_h.glColor4us(red, green, blue, alpha);
  }

  public void glColor4usv(MemorySegment v) {
    glext_h.glColor4usv(v);
  }

  public void glColorMask(byte red, byte green, byte blue, byte alpha) {
    glext_h.glColorMask(red, green, blue, alpha);
  }

  public void glColorMaterial(int face, int mode) {
    glext_h.glColorMaterial(face, mode);
  }

  public void glColorPointer(int size, int type, int stride, MemorySegment pointer) {
    glext_h.glColorPointer(size, type, stride, pointer);
  }

  public void glColorSubTable(int target, int start, int count, int format, int type, MemorySegment data) {
    glext_h.glColorSubTable(target, start, count, format, type, data);
  }

  public void glColorTable(int target, int internalformat, int width, int format, int type, MemorySegment table) {
    glext_h.glColorTable(target, internalformat, width, format, type, table);
  }

  public void glColorTableParameterfv(int target, int pname, MemorySegment params) {
    glext_h.glColorTableParameterfv(target, pname, params);
  }

  public void glColorTableParameteriv(int target, int pname, MemorySegment params) {
    glext_h.glColorTableParameteriv(target, pname, params);
  }

  public void glCompressedTexImage1D(int target, int level, int internalformat, int width, int border, int imageSize, MemorySegment data) {
    glext_h.glCompressedTexImage1D(target, level, internalformat, width, border, imageSize, data);
  }

  public void glCompressedTexImage2D(int target, int level, int internalformat, int width, int height, int border, int imageSize, MemorySegment data) {
    glext_h.glCompressedTexImage2D(target, level, internalformat, width, height, border, imageSize, data);
  }

  public void glCompressedTexImage3D(int target, int level, int internalformat, int width, int height, int depth, int border, int imageSize, MemorySegment data) {
    glext_h.glCompressedTexImage3D(target, level, internalformat, width, height, depth, border, imageSize, data);
  }

  public void glCompressedTexSubImage1D(int target, int level, int xoffset, int width, int format, int imageSize, MemorySegment data) {
    glext_h.glCompressedTexSubImage1D(target, level, xoffset, width, format, imageSize, data);
  }

  public void glCompressedTexSubImage2D(int target, int level, int xoffset, int yoffset, int width, int height, int format, int imageSize, MemorySegment data) {
    glext_h.glCompressedTexSubImage2D(target, level, xoffset, yoffset, width, height, format, imageSize, data);
  }

  public void glCompressedTexSubImage3D(int target, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int format, int imageSize, MemorySegment data) {
    glext_h.glCompressedTexSubImage3D(target, level, xoffset, yoffset, zoffset, width, height, depth, format, imageSize, data);
  }

  public void glConvolutionFilter1D(int target, int internalformat, int width, int format, int type, MemorySegment image) {
    glext_h.glConvolutionFilter1D(target, internalformat, width, format, type, image);
  }

  public void glConvolutionFilter2D(int target, int internalformat, int width, int height, int format, int type, MemorySegment image) {
    glext_h.glConvolutionFilter2D(target, internalformat, width, height, format, type, image);
  }

  public void glConvolutionParameterf(int target, int pname, float params) {
    glext_h.glConvolutionParameterf(target, pname, params);
  }

  public void glConvolutionParameterfv(int target, int pname, MemorySegment params) {
    glext_h.glConvolutionParameterfv(target, pname, params);
  }

  public void glConvolutionParameteri(int target, int pname, int params) {
    glext_h.glConvolutionParameteri(target, pname, params);
  }

  public void glConvolutionParameteriv(int target, int pname, MemorySegment params) {
    glext_h.glConvolutionParameteriv(target, pname, params);
  }

  public void glCopyColorSubTable(int target, int start, int x, int y, int width) {
    glext_h.glCopyColorSubTable(target, start, x, y, width);
  }

  public void glCopyColorTable(int target, int internalformat, int x, int y, int width) {
    glext_h.glCopyColorTable(target, internalformat, x, y, width);
  }

  public void glCopyConvolutionFilter1D(int target, int internalformat, int x, int y, int width) {
    glext_h.glCopyConvolutionFilter1D(target, internalformat, x, y, width);
  }

  public void glCopyConvolutionFilter2D(int target, int internalformat, int x, int y, int width, int height) {
    glext_h.glCopyConvolutionFilter2D(target, internalformat, x, y, width, height);
  }

  public void glCopyPixels(int x, int y, int width, int height, int type) {
    glext_h.glCopyPixels(x, y, width, height, type);
  }

  public void glCopyTexImage1D(int target, int level, int internalformat, int x, int y, int width, int border) {
    glext_h.glCopyTexImage1D(target, level, internalformat, x, y, width, border);
  }

  public void glCopyTexImage2D(int target, int level, int internalformat, int x, int y, int width, int height, int border) {
    glext_h.glCopyTexImage2D(target, level, internalformat, x, y, width, height, border);
  }

  public void glCopyTexSubImage1D(int target, int level, int xoffset, int x, int y, int width) {
    glext_h.glCopyTexSubImage1D(target, level, xoffset, x, y, width);
  }

  public void glCopyTexSubImage2D(int target, int level, int xoffset, int yoffset, int x, int y, int width, int height) {
    glext_h.glCopyTexSubImage2D(target, level, xoffset, yoffset, x, y, width, height);
  }

  public void glCopyTexSubImage3D(int target, int level, int xoffset, int yoffset, int zoffset, int x, int y, int width, int height) {
    glext_h.glCopyTexSubImage3D(target, level, xoffset, yoffset, zoffset, x, y, width, height);
  }

  public void glCullFace(int mode) {
    glext_h.glCullFace(mode);
  }

  public void glDeleteLists(int list, int range) {
    glext_h.glDeleteLists(list, range);
  }

  public void glDeleteTextures(int n, MemorySegment textures) {
    glext_h.glDeleteTextures(n, textures);
  }

  public void glDepthFunc(int func) {
    glext_h.glDepthFunc(func);
  }

  public void glDepthMask(byte flag) {
    glext_h.glDepthMask(flag);
  }

  public void glDepthRange(double n, double f) {
    glext_h.glDepthRange(n, f);
  }

  public void glDisable(int cap) {
    glext_h.glDisable(cap);
  }

  public void glDisableClientState(int array) {
    glext_h.glDisableClientState(array);
  }

  public void glDrawArrays(int mode, int first, int count) {
    glext_h.glDrawArrays(mode, first, count);
  }

  public void glDrawBuffer(int buf) {
    glext_h.glDrawBuffer(buf);
  }

  public void glDrawElements(int mode, int count, int type, MemorySegment indices) {
    glext_h.glDrawElements(mode, count, type, indices);
  }

  public void glDrawPixels(int width, int height, int format, int type, MemorySegment pixels) {
    glext_h.glDrawPixels(width, height, format, type, pixels);
  }

  public void glDrawRangeElements(int mode, int start, int end, int count, int type, MemorySegment indices) {
    glext_h.glDrawRangeElements(mode, start, end, count, type, indices);
  }

  public void glEdgeFlag(byte flag) {
    glext_h.glEdgeFlag(flag);
  }

  public void glEdgeFlagPointer(int stride, MemorySegment pointer) {
    glext_h.glEdgeFlagPointer(stride, pointer);
  }

  public void glEdgeFlagv(MemorySegment flag) {
    glext_h.glEdgeFlagv(flag);
  }

  public void glEnable(int cap) {
    glext_h.glEnable(cap);
  }

  public void glEnableClientState(int array) {
    glext_h.glEnableClientState(array);
  }

  public void glEnd() {
    glext_h.glEnd();
  }

  public void glEndList() {
    glext_h.glEndList();
  }

  public void glEvalCoord1d(double u) {
    glext_h.glEvalCoord1d(u);
  }

  public void glEvalCoord1dv(MemorySegment u) {
    glext_h.glEvalCoord1dv(u);
  }

  public void glEvalCoord1f(float u) {
    glext_h.glEvalCoord1f(u);
  }

  public void glEvalCoord1fv(MemorySegment u) {
    glext_h.glEvalCoord1fv(u);
  }

  public void glEvalCoord2d(double u, double v) {
    glext_h.glEvalCoord2d(u, v);
  }

  public void glEvalCoord2dv(MemorySegment u) {
    glext_h.glEvalCoord2dv(u);
  }

  public void glEvalCoord2f(float u, float v) {
    glext_h.glEvalCoord2f(u, v);
  }

  public void glEvalCoord2fv(MemorySegment u) {
    glext_h.glEvalCoord2fv(u);
  }

  public void glEvalMesh1(int mode, int i1, int i2) {
    glext_h.glEvalMesh1(mode, i1, i2);
  }

  public void glEvalMesh2(int mode, int i1, int i2, int j1, int j2) {
    glext_h.glEvalMesh2(mode, i1, i2, j1, j2);
  }

  public void glEvalPoint1(int i) {
    glext_h.glEvalPoint1(i);
  }

  public void glEvalPoint2(int i, int j) {
    glext_h.glEvalPoint2(i, j);
  }

  public void glFeedbackBuffer(int size, int type, MemorySegment buffer) {
    glext_h.glFeedbackBuffer(size, type, buffer);
  }

  public void glFinish() {
    glext_h.glFinish();
  }

  public void glFlush() {
    glext_h.glFlush();
  }

  public void glFogf(int pname, float param) {
    glext_h.glFogf(pname, param);
  }

  public void glFogfv(int pname, MemorySegment params) {
    glext_h.glFogfv(pname, params);
  }

  public void glFogi(int pname, int param) {
    glext_h.glFogi(pname, param);
  }

  public void glFogiv(int pname, MemorySegment params) {
    glext_h.glFogiv(pname, params);
  }

  public void glFrontFace(int mode) {
    glext_h.glFrontFace(mode);
  }

  public void glFrustum(double left, double right, double bottom, double top, double zNear, double zFar) {
    glext_h.glFrustum(left, right, bottom, top, zNear, zFar);
  }

  public int glGenLists(int range) {
    return glext_h.glGenLists(range);
  }

  public void glGenTextures(int n, MemorySegment textures) {
    glext_h.glGenTextures(n, textures);
  }

  public void glGetBooleanv(int pname, MemorySegment data) {
    glext_h.glGetBooleanv(pname, data);
  }

  public void glGetClipPlane(int plane, MemorySegment equation) {
    glext_h.glGetClipPlane(plane, equation);
  }

  public void glGetColorTable(int target, int format, int type, MemorySegment table) {
    glext_h.glGetColorTable(target, format, type, table);
  }

  public void glGetColorTableParameterfv(int target, int pname, MemorySegment params) {
    glext_h.glGetColorTableParameterfv(target, pname, params);
  }

  public void glGetColorTableParameteriv(int target, int pname, MemorySegment params) {
    glext_h.glGetColorTableParameteriv(target, pname, params);
  }

  public void glGetCompressedTexImage(int target, int level, MemorySegment img) {
    glext_h.glGetCompressedTexImage(target, level, img);
  }

  public void glGetConvolutionFilter(int target, int format, int type, MemorySegment image) {
    glext_h.glGetConvolutionFilter(target, format, type, image);
  }

  public void glGetConvolutionParameterfv(int target, int pname, MemorySegment params) {
    glext_h.glGetConvolutionParameterfv(target, pname, params);
  }

  public void glGetConvolutionParameteriv(int target, int pname, MemorySegment params) {
    glext_h.glGetConvolutionParameteriv(target, pname, params);
  }

  public void glGetDoublev(int pname, MemorySegment data) {
    glext_h.glGetDoublev(pname, data);
  }

  public int glGetError() {
    return glext_h.glGetError();
  }

  public void glGetFloatv(int pname, MemorySegment data) {
    glext_h.glGetFloatv(pname, data);
  }

  public void glGetHistogram(int target, byte reset, int format, int type, MemorySegment values) {
    glext_h.glGetHistogram(target, reset, format, type, values);
  }

  public void glGetHistogramParameterfv(int target, int pname, MemorySegment params) {
    glext_h.glGetHistogramParameterfv(target, pname, params);
  }

  public void glGetHistogramParameteriv(int target, int pname, MemorySegment params) {
    glext_h.glGetHistogramParameteriv(target, pname, params);
  }

  public void glGetIntegerv(int pname, MemorySegment data) {
    glext_h.glGetIntegerv(pname, data);
  }

  public void glGetLightfv(int light, int pname, MemorySegment params) {
    glext_h.glGetLightfv(light, pname, params);
  }

  public void glGetLightiv(int light, int pname, MemorySegment params) {
    glext_h.glGetLightiv(light, pname, params);
  }

  public void glGetMapdv(int target, int query, MemorySegment v) {
    glext_h.glGetMapdv(target, query, v);
  }

  public void glGetMapfv(int target, int query, MemorySegment v) {
    glext_h.glGetMapfv(target, query, v);
  }

  public void glGetMapiv(int target, int query, MemorySegment v) {
    glext_h.glGetMapiv(target, query, v);
  }

  public void glGetMaterialfv(int face, int pname, MemorySegment params) {
    glext_h.glGetMaterialfv(face, pname, params);
  }

  public void glGetMaterialiv(int face, int pname, MemorySegment params) {
    glext_h.glGetMaterialiv(face, pname, params);
  }

  public void glGetMinmax(int target, byte reset, int format, int type, MemorySegment values) {
    glext_h.glGetMinmax(target, reset, format, type, values);
  }

  public void glGetMinmaxParameterfv(int target, int pname, MemorySegment params) {
    glext_h.glGetMinmaxParameterfv(target, pname, params);
  }

  public void glGetMinmaxParameteriv(int target, int pname, MemorySegment params) {
    glext_h.glGetMinmaxParameteriv(target, pname, params);
  }

  public void glGetPixelMapfv(int map, MemorySegment values) {
    glext_h.glGetPixelMapfv(map, values);
  }

  public void glGetPixelMapuiv(int map, MemorySegment values) {
    glext_h.glGetPixelMapuiv(map, values);
  }

  public void glGetPixelMapusv(int map, MemorySegment values) {
    glext_h.glGetPixelMapusv(map, values);
  }

  public void glGetPointerv(int pname, MemorySegment params) {
    glext_h.glGetPointerv(pname, params);
  }

  public void glGetPolygonStipple(MemorySegment mask) {
    glext_h.glGetPolygonStipple(mask);
  }

  public void glGetSeparableFilter(int target, int format, int type, MemorySegment row, MemorySegment column, MemorySegment span) {
    glext_h.glGetSeparableFilter(target, format, type, row, column, span);
  }

  public MemorySegment glGetString(int name) {
    return glext_h.glGetString(name);
  }

  public void glGetTexEnvfv(int target, int pname, MemorySegment params) {
    glext_h.glGetTexEnvfv(target, pname, params);
  }

  public void glGetTexEnviv(int target, int pname, MemorySegment params) {
    glext_h.glGetTexEnviv(target, pname, params);
  }

  public void glGetTexGendv(int coord, int pname, MemorySegment params) {
    glext_h.glGetTexGendv(coord, pname, params);
  }

  public void glGetTexGenfv(int coord, int pname, MemorySegment params) {
    glext_h.glGetTexGenfv(coord, pname, params);
  }

  public void glGetTexGeniv(int coord, int pname, MemorySegment params) {
    glext_h.glGetTexGeniv(coord, pname, params);
  }

  public void glGetTexImage(int target, int level, int format, int type, MemorySegment pixels) {
    glext_h.glGetTexImage(target, level, format, type, pixels);
  }

  public void glGetTexLevelParameterfv(int target, int level, int pname, MemorySegment params) {
    glext_h.glGetTexLevelParameterfv(target, level, pname, params);
  }

  public void glGetTexLevelParameteriv(int target, int level, int pname, MemorySegment params) {
    glext_h.glGetTexLevelParameteriv(target, level, pname, params);
  }

  public void glGetTexParameterfv(int target, int pname, MemorySegment params) {
    glext_h.glGetTexParameterfv(target, pname, params);
  }

  public void glGetTexParameteriv(int target, int pname, MemorySegment params) {
    glext_h.glGetTexParameteriv(target, pname, params);
  }

  public void glHint(int target, int mode) {
    glext_h.glHint(target, mode);
  }

  public void glHistogram(int target, int width, int internalformat, byte sink) {
    glext_h.glHistogram(target, width, internalformat, sink);
  }

  public void glIndexMask(int mask) {
    glext_h.glIndexMask(mask);
  }

  public void glIndexPointer(int type, int stride, MemorySegment pointer) {
    glext_h.glIndexPointer(type, stride, pointer);
  }

  public void glIndexd(double c) {
    glext_h.glIndexd(c);
  }

  public void glIndexdv(MemorySegment c) {
    glext_h.glIndexdv(c);
  }

  public void glIndexf(float c) {
    glext_h.glIndexf(c);
  }

  public void glIndexfv(MemorySegment c) {
    glext_h.glIndexfv(c);
  }

  public void glIndexi(int c) {
    glext_h.glIndexi(c);
  }

  public void glIndexiv(MemorySegment c) {
    glext_h.glIndexiv(c);
  }

  public void glIndexs(short c) {
    glext_h.glIndexs(c);
  }

  public void glIndexsv(MemorySegment c) {
    glext_h.glIndexsv(c);
  }

  public void glIndexub(byte c) {
    glext_h.glIndexub(c);
  }

  public void glIndexubv(MemorySegment c) {
    glext_h.glIndexubv(c);
  }

  public void glInitNames() {
    glext_h.glInitNames();
  }

  public void glInterleavedArrays(int format, int stride, MemorySegment pointer) {
    glext_h.glInterleavedArrays(format, stride, pointer);
  }

  public byte glIsEnabled(int cap) {
    return glext_h.glIsEnabled(cap);
  }

  public byte glIsList(int list) {
    return glext_h.glIsList(list);
  }

  public byte glIsTexture(int texture) {
    return glext_h.glIsTexture(texture);
  }

  public void glLightModelf(int pname, float param) {
    glext_h.glLightModelf(pname, param);
  }

  public void glLightModelfv(int pname, MemorySegment params) {
    glext_h.glLightModelfv(pname, params);
  }

  public void glLightModeli(int pname, int param) {
    glext_h.glLightModeli(pname, param);
  }

  public void glLightModeliv(int pname, MemorySegment params) {
    glext_h.glLightModeliv(pname, params);
  }

  public void glLightf(int light, int pname, float param) {
    glext_h.glLightf(light, pname, param);
  }

  public void glLightfv(int light, int pname, MemorySegment params) {
    glext_h.glLightfv(light, pname, params);
  }

  public void glLighti(int light, int pname, int param) {
    glext_h.glLighti(light, pname, param);
  }

  public void glLightiv(int light, int pname, MemorySegment params) {
    glext_h.glLightiv(light, pname, params);
  }

  public void glLineStipple(int factor, short pattern) {
    glext_h.glLineStipple(factor, pattern);
  }

  public void glLineWidth(float width) {
    glext_h.glLineWidth(width);
  }

  public void glListBase(int base) {
    glext_h.glListBase(base);
  }

  public void glLoadIdentity() {
    glext_h.glLoadIdentity();
  }

  public void glLoadMatrixd(MemorySegment m) {
    glext_h.glLoadMatrixd(m);
  }

  public void glLoadMatrixf(MemorySegment m) {
    glext_h.glLoadMatrixf(m);
  }

  public void glLoadName(int name) {
    glext_h.glLoadName(name);
  }

  public void glLoadTransposeMatrixd(MemorySegment m) {
    glext_h.glLoadTransposeMatrixd(m);
  }

  public void glLoadTransposeMatrixf(MemorySegment m) {
    glext_h.glLoadTransposeMatrixf(m);
  }

  public void glLogicOp(int opcode) {
    glext_h.glLogicOp(opcode);
  }

  public void glMap1d(int target, double u1, double u2, int stride, int order, MemorySegment points) {
    glext_h.glMap1d(target, u1, u2, stride, order, points);
  }

  public void glMap1f(int target, float u1, float u2, int stride, int order, MemorySegment points) {
    glext_h.glMap1f(target, u1, u2, stride, order, points);
  }

  public void glMap2d(int target, double u1, double u2, int ustride, int uorder, double v1, double v2, int vstride, int vorder, MemorySegment points) {
    glext_h.glMap2d(target, u1, u2, ustride, uorder, v1, v2, vstride, vorder, points);
  }

  public void glMap2f(int target, float u1, float u2, int ustride, int uorder, float v1, float v2, int vstride, int vorder, MemorySegment points) {
    glext_h.glMap2f(target, u1, u2, ustride, uorder, v1, v2, vstride, vorder, points);
  }

  public void glMapGrid1d(int un, double u1, double u2) {
    glext_h.glMapGrid1d(un, u1, u2);
  }

  public void glMapGrid1f(int un, float u1, float u2) {
    glext_h.glMapGrid1f(un, u1, u2);
  }

  public void glMapGrid2d(int un, double u1, double u2, int vn, double v1, double v2) {
    glext_h.glMapGrid2d(un, u1, u2, vn, v1, v2);
  }

  public void glMapGrid2f(int un, float u1, float u2, int vn, float v1, float v2) {
    glext_h.glMapGrid2f(un, u1, u2, vn, v1, v2);
  }

  public void glMaterialf(int face, int pname, float param) {
    glext_h.glMaterialf(face, pname, param);
  }

  public void glMaterialfv(int face, int pname, MemorySegment params) {
    glext_h.glMaterialfv(face, pname, params);
  }

  public void glMateriali(int face, int pname, int param) {
    glext_h.glMateriali(face, pname, param);
  }

  public void glMaterialiv(int face, int pname, MemorySegment params) {
    glext_h.glMaterialiv(face, pname, params);
  }

  public void glMatrixMode(int mode) {
    glext_h.glMatrixMode(mode);
  }

  public void glMinmax(int target, int internalformat, byte sink) {
    glext_h.glMinmax(target, internalformat, sink);
  }

  public void glMultMatrixd(MemorySegment m) {
    glext_h.glMultMatrixd(m);
  }

  public void glMultMatrixf(MemorySegment m) {
    glext_h.glMultMatrixf(m);
  }

  public void glMultTransposeMatrixd(MemorySegment m) {
    glext_h.glMultTransposeMatrixd(m);
  }

  public void glMultTransposeMatrixf(MemorySegment m) {
    glext_h.glMultTransposeMatrixf(m);
  }

  public void glMultiTexCoord1d(int target, double s) {
    glext_h.glMultiTexCoord1d(target, s);
  }

  public void glMultiTexCoord1dARB(int target, double s) {
    glext_h.glMultiTexCoord1dARB(target, s);
  }

  public void glMultiTexCoord1dv(int target, MemorySegment v) {
    glext_h.glMultiTexCoord1dv(target, v);
  }

  public void glMultiTexCoord1dvARB(int target, MemorySegment v) {
    glext_h.glMultiTexCoord1dvARB(target, v);
  }

  public void glMultiTexCoord1f(int target, float s) {
    glext_h.glMultiTexCoord1f(target, s);
  }

  public void glMultiTexCoord1fARB(int target, float s) {
    glext_h.glMultiTexCoord1fARB(target, s);
  }

  public void glMultiTexCoord1fv(int target, MemorySegment v) {
    glext_h.glMultiTexCoord1fv(target, v);
  }

  public void glMultiTexCoord1fvARB(int target, MemorySegment v) {
    glext_h.glMultiTexCoord1fvARB(target, v);
  }

  public void glMultiTexCoord1i(int target, int s) {
    glext_h.glMultiTexCoord1i(target, s);
  }

  public void glMultiTexCoord1iARB(int target, int s) {
    glext_h.glMultiTexCoord1iARB(target, s);
  }

  public void glMultiTexCoord1iv(int target, MemorySegment v) {
    glext_h.glMultiTexCoord1iv(target, v);
  }

  public void glMultiTexCoord1ivARB(int target, MemorySegment v) {
    glext_h.glMultiTexCoord1ivARB(target, v);
  }

  public void glMultiTexCoord1s(int target, short s) {
    glext_h.glMultiTexCoord1s(target, s);
  }

  public void glMultiTexCoord1sARB(int target, short s) {
    glext_h.glMultiTexCoord1sARB(target, s);
  }

  public void glMultiTexCoord1sv(int target, MemorySegment v) {
    glext_h.glMultiTexCoord1sv(target, v);
  }

  public void glMultiTexCoord1svARB(int target, MemorySegment v) {
    glext_h.glMultiTexCoord1svARB(target, v);
  }

  public void glMultiTexCoord2d(int target, double s, double t) {
    glext_h.glMultiTexCoord2d(target, s, t);
  }

  public void glMultiTexCoord2dARB(int target, double s, double t) {
    glext_h.glMultiTexCoord2dARB(target, s, t);
  }

  public void glMultiTexCoord2dv(int target, MemorySegment v) {
    glext_h.glMultiTexCoord2dv(target, v);
  }

  public void glMultiTexCoord2dvARB(int target, MemorySegment v) {
    glext_h.glMultiTexCoord2dvARB(target, v);
  }

  public void glMultiTexCoord2f(int target, float s, float t) {
    glext_h.glMultiTexCoord2f(target, s, t);
  }

  public void glMultiTexCoord2fARB(int target, float s, float t) {
    glext_h.glMultiTexCoord2fARB(target, s, t);
  }

  public void glMultiTexCoord2fv(int target, MemorySegment v) {
    glext_h.glMultiTexCoord2fv(target, v);
  }

  public void glMultiTexCoord2fvARB(int target, MemorySegment v) {
    glext_h.glMultiTexCoord2fvARB(target, v);
  }

  public void glMultiTexCoord2i(int target, int s, int t) {
    glext_h.glMultiTexCoord2i(target, s, t);
  }

  public void glMultiTexCoord2iARB(int target, int s, int t) {
    glext_h.glMultiTexCoord2iARB(target, s, t);
  }

  public void glMultiTexCoord2iv(int target, MemorySegment v) {
    glext_h.glMultiTexCoord2iv(target, v);
  }

  public void glMultiTexCoord2ivARB(int target, MemorySegment v) {
    glext_h.glMultiTexCoord2ivARB(target, v);
  }

  public void glMultiTexCoord2s(int target, short s, short t) {
    glext_h.glMultiTexCoord2s(target, s, t);
  }

  public void glMultiTexCoord2sARB(int target, short s, short t) {
    glext_h.glMultiTexCoord2sARB(target, s, t);
  }

  public void glMultiTexCoord2sv(int target, MemorySegment v) {
    glext_h.glMultiTexCoord2sv(target, v);
  }

  public void glMultiTexCoord2svARB(int target, MemorySegment v) {
    glext_h.glMultiTexCoord2svARB(target, v);
  }

  public void glMultiTexCoord3d(int target, double s, double t, double r) {
    glext_h.glMultiTexCoord3d(target, s, t, r);
  }

  public void glMultiTexCoord3dARB(int target, double s, double t, double r) {
    glext_h.glMultiTexCoord3dARB(target, s, t, r);
  }

  public void glMultiTexCoord3dv(int target, MemorySegment v) {
    glext_h.glMultiTexCoord3dv(target, v);
  }

  public void glMultiTexCoord3dvARB(int target, MemorySegment v) {
    glext_h.glMultiTexCoord3dvARB(target, v);
  }

  public void glMultiTexCoord3f(int target, float s, float t, float r) {
    glext_h.glMultiTexCoord3f(target, s, t, r);
  }

  public void glMultiTexCoord3fARB(int target, float s, float t, float r) {
    glext_h.glMultiTexCoord3fARB(target, s, t, r);
  }

  public void glMultiTexCoord3fv(int target, MemorySegment v) {
    glext_h.glMultiTexCoord3fv(target, v);
  }

  public void glMultiTexCoord3fvARB(int target, MemorySegment v) {
    glext_h.glMultiTexCoord3fvARB(target, v);
  }

  public void glMultiTexCoord3i(int target, int s, int t, int r) {
    glext_h.glMultiTexCoord3i(target, s, t, r);
  }

  public void glMultiTexCoord3iARB(int target, int s, int t, int r) {
    glext_h.glMultiTexCoord3iARB(target, s, t, r);
  }

  public void glMultiTexCoord3iv(int target, MemorySegment v) {
    glext_h.glMultiTexCoord3iv(target, v);
  }

  public void glMultiTexCoord3ivARB(int target, MemorySegment v) {
    glext_h.glMultiTexCoord3ivARB(target, v);
  }

  public void glMultiTexCoord3s(int target, short s, short t, short r) {
    glext_h.glMultiTexCoord3s(target, s, t, r);
  }

  public void glMultiTexCoord3sARB(int target, short s, short t, short r) {
    glext_h.glMultiTexCoord3sARB(target, s, t, r);
  }

  public void glMultiTexCoord3sv(int target, MemorySegment v) {
    glext_h.glMultiTexCoord3sv(target, v);
  }

  public void glMultiTexCoord3svARB(int target, MemorySegment v) {
    glext_h.glMultiTexCoord3svARB(target, v);
  }

  public void glMultiTexCoord4d(int target, double s, double t, double r, double q) {
    glext_h.glMultiTexCoord4d(target, s, t, r, q);
  }

  public void glMultiTexCoord4dARB(int target, double s, double t, double r, double q) {
    glext_h.glMultiTexCoord4dARB(target, s, t, r, q);
  }

  public void glMultiTexCoord4dv(int target, MemorySegment v) {
    glext_h.glMultiTexCoord4dv(target, v);
  }

  public void glMultiTexCoord4dvARB(int target, MemorySegment v) {
    glext_h.glMultiTexCoord4dvARB(target, v);
  }

  public void glMultiTexCoord4f(int target, float s, float t, float r, float q) {
    glext_h.glMultiTexCoord4f(target, s, t, r, q);
  }

  public void glMultiTexCoord4fARB(int target, float s, float t, float r, float q) {
    glext_h.glMultiTexCoord4fARB(target, s, t, r, q);
  }

  public void glMultiTexCoord4fv(int target, MemorySegment v) {
    glext_h.glMultiTexCoord4fv(target, v);
  }

  public void glMultiTexCoord4fvARB(int target, MemorySegment v) {
    glext_h.glMultiTexCoord4fvARB(target, v);
  }

  public void glMultiTexCoord4i(int target, int s, int t, int r, int q) {
    glext_h.glMultiTexCoord4i(target, s, t, r, q);
  }

  public void glMultiTexCoord4iARB(int target, int s, int t, int r, int q) {
    glext_h.glMultiTexCoord4iARB(target, s, t, r, q);
  }

  public void glMultiTexCoord4iv(int target, MemorySegment v) {
    glext_h.glMultiTexCoord4iv(target, v);
  }

  public void glMultiTexCoord4ivARB(int target, MemorySegment v) {
    glext_h.glMultiTexCoord4ivARB(target, v);
  }

  public void glMultiTexCoord4s(int target, short s, short t, short r, short q) {
    glext_h.glMultiTexCoord4s(target, s, t, r, q);
  }

  public void glMultiTexCoord4sARB(int target, short s, short t, short r, short q) {
    glext_h.glMultiTexCoord4sARB(target, s, t, r, q);
  }

  public void glMultiTexCoord4sv(int target, MemorySegment v) {
    glext_h.glMultiTexCoord4sv(target, v);
  }

  public void glMultiTexCoord4svARB(int target, MemorySegment v) {
    glext_h.glMultiTexCoord4svARB(target, v);
  }

  public void glNewList(int list, int mode) {
    glext_h.glNewList(list, mode);
  }

  public void glNormal3b(byte nx, byte ny, byte nz) {
    glext_h.glNormal3b(nx, ny, nz);
  }

  public void glNormal3bv(MemorySegment v) {
    glext_h.glNormal3bv(v);
  }

  public void glNormal3d(double nx, double ny, double nz) {
    glext_h.glNormal3d(nx, ny, nz);
  }

  public void glNormal3dv(MemorySegment v) {
    glext_h.glNormal3dv(v);
  }

  public void glNormal3f(float nx, float ny, float nz) {
    glext_h.glNormal3f(nx, ny, nz);
  }

  public void glNormal3fv(MemorySegment v) {
    glext_h.glNormal3fv(v);
  }

  public void glNormal3i(int nx, int ny, int nz) {
    glext_h.glNormal3i(nx, ny, nz);
  }

  public void glNormal3iv(MemorySegment v) {
    glext_h.glNormal3iv(v);
  }

  public void glNormal3s(short nx, short ny, short nz) {
    glext_h.glNormal3s(nx, ny, nz);
  }

  public void glNormal3sv(MemorySegment v) {
    glext_h.glNormal3sv(v);
  }

  public void glNormalPointer(int type, int stride, MemorySegment pointer) {
    glext_h.glNormalPointer(type, stride, pointer);
  }

  public void glOrtho(double left, double right, double bottom, double top, double zNear, double zFar) {
    glext_h.glOrtho(left, right, bottom, top, zNear, zFar);
  }

  public void glPassThrough(float token) {
    glext_h.glPassThrough(token);
  }

  public void glPixelMapfv(int map, int mapsize, MemorySegment values) {
    glext_h.glPixelMapfv(map, mapsize, values);
  }

  public void glPixelMapuiv(int map, int mapsize, MemorySegment values) {
    glext_h.glPixelMapuiv(map, mapsize, values);
  }

  public void glPixelMapusv(int map, int mapsize, MemorySegment values) {
    glext_h.glPixelMapusv(map, mapsize, values);
  }

  public void glPixelStoref(int pname, float param) {
    glext_h.glPixelStoref(pname, param);
  }

  public void glPixelStorei(int pname, int param) {
    glext_h.glPixelStorei(pname, param);
  }

  public void glPixelTransferf(int pname, float param) {
    glext_h.glPixelTransferf(pname, param);
  }

  public void glPixelTransferi(int pname, int param) {
    glext_h.glPixelTransferi(pname, param);
  }

  public void glPixelZoom(float xfactor, float yfactor) {
    glext_h.glPixelZoom(xfactor, yfactor);
  }

  public void glPointSize(float size) {
    glext_h.glPointSize(size);
  }

  public void glPolygonMode(int face, int mode) {
    glext_h.glPolygonMode(face, mode);
  }

  public void glPolygonOffset(float factor, float units) {
    glext_h.glPolygonOffset(factor, units);
  }

  public void glPolygonStipple(MemorySegment mask) {
    glext_h.glPolygonStipple(mask);
  }

  public void glPopAttrib() {
    glext_h.glPopAttrib();
  }

  public void glPopClientAttrib() {
    glext_h.glPopClientAttrib();
  }

  public void glPopMatrix() {
    glext_h.glPopMatrix();
  }

  public void glPopName() {
    glext_h.glPopName();
  }

  public void glPrioritizeTextures(int n, MemorySegment textures, MemorySegment priorities) {
    glext_h.glPrioritizeTextures(n, textures, priorities);
  }

  public void glPushAttrib(int mask) {
    glext_h.glPushAttrib(mask);
  }

  public void glPushClientAttrib(int mask) {
    glext_h.glPushClientAttrib(mask);
  }

  public void glPushMatrix() {
    glext_h.glPushMatrix();
  }

  public void glPushName(int name) {
    glext_h.glPushName(name);
  }

  public void glRasterPos2d(double x, double y) {
    glext_h.glRasterPos2d(x, y);
  }

  public void glRasterPos2dv(MemorySegment v) {
    glext_h.glRasterPos2dv(v);
  }

  public void glRasterPos2f(float x, float y) {
    glext_h.glRasterPos2f(x, y);
  }

  public void glRasterPos2fv(MemorySegment v) {
    glext_h.glRasterPos2fv(v);
  }

  public void glRasterPos2i(int x, int y) {
    glext_h.glRasterPos2i(x, y);
  }

  public void glRasterPos2iv(MemorySegment v) {
    glext_h.glRasterPos2iv(v);
  }

  public void glRasterPos2s(short x, short y) {
    glext_h.glRasterPos2s(x, y);
  }

  public void glRasterPos2sv(MemorySegment v) {
    glext_h.glRasterPos2sv(v);
  }

  public void glRasterPos3d(double x, double y, double z) {
    glext_h.glRasterPos3d(x, y, z);
  }

  public void glRasterPos3dv(MemorySegment v) {
    glext_h.glRasterPos3dv(v);
  }

  public void glRasterPos3f(float x, float y, float z) {
    glext_h.glRasterPos3f(x, y, z);
  }

  public void glRasterPos3fv(MemorySegment v) {
    glext_h.glRasterPos3fv(v);
  }

  public void glRasterPos3i(int x, int y, int z) {
    glext_h.glRasterPos3i(x, y, z);
  }

  public void glRasterPos3iv(MemorySegment v) {
    glext_h.glRasterPos3iv(v);
  }

  public void glRasterPos3s(short x, short y, short z) {
    glext_h.glRasterPos3s(x, y, z);
  }

  public void glRasterPos3sv(MemorySegment v) {
    glext_h.glRasterPos3sv(v);
  }

  public void glRasterPos4d(double x, double y, double z, double w) {
    glext_h.glRasterPos4d(x, y, z, w);
  }

  public void glRasterPos4dv(MemorySegment v) {
    glext_h.glRasterPos4dv(v);
  }

  public void glRasterPos4f(float x, float y, float z, float w) {
    glext_h.glRasterPos4f(x, y, z, w);
  }

  public void glRasterPos4fv(MemorySegment v) {
    glext_h.glRasterPos4fv(v);
  }

  public void glRasterPos4i(int x, int y, int z, int w) {
    glext_h.glRasterPos4i(x, y, z, w);
  }

  public void glRasterPos4iv(MemorySegment v) {
    glext_h.glRasterPos4iv(v);
  }

  public void glRasterPos4s(short x, short y, short z, short w) {
    glext_h.glRasterPos4s(x, y, z, w);
  }

  public void glRasterPos4sv(MemorySegment v) {
    glext_h.glRasterPos4sv(v);
  }

  public void glReadBuffer(int src) {
    glext_h.glReadBuffer(src);
  }

  public void glReadPixels(int x, int y, int width, int height, int format, int type, MemorySegment pixels) {
    glext_h.glReadPixels(x, y, width, height, format, type, pixels);
  }

  public void glRectd(double x1, double y1, double x2, double y2) {
    glext_h.glRectd(x1, y1, x2, y2);
  }

  public void glRectdv(MemorySegment v1, MemorySegment v2) {
    glext_h.glRectdv(v1, v2);
  }

  public void glRectf(float x1, float y1, float x2, float y2) {
    glext_h.glRectf(x1, y1, x2, y2);
  }

  public void glRectfv(MemorySegment v1, MemorySegment v2) {
    glext_h.glRectfv(v1, v2);
  }

  public void glRecti(int x1, int y1, int x2, int y2) {
    glext_h.glRecti(x1, y1, x2, y2);
  }

  public void glRectiv(MemorySegment v1, MemorySegment v2) {
    glext_h.glRectiv(v1, v2);
  }

  public void glRects(short x1, short y1, short x2, short y2) {
    glext_h.glRects(x1, y1, x2, y2);
  }

  public void glRectsv(MemorySegment v1, MemorySegment v2) {
    glext_h.glRectsv(v1, v2);
  }

  public int glRenderMode(int mode) {
    return glext_h.glRenderMode(mode);
  }

  public void glResetHistogram(int target) {
    glext_h.glResetHistogram(target);
  }

  public void glResetMinmax(int target) {
    glext_h.glResetMinmax(target);
  }

  public void glRotated(double angle, double x, double y, double z) {
    glext_h.glRotated(angle, x, y, z);
  }

  public void glRotatef(float angle, float x, float y, float z) {
    glext_h.glRotatef(angle, x, y, z);
  }

  public void glSampleCoverage(float value, byte invert) {
    glext_h.glSampleCoverage(value, invert);
  }

  public void glScaled(double x, double y, double z) {
    glext_h.glScaled(x, y, z);
  }

  public void glScalef(float x, float y, float z) {
    glext_h.glScalef(x, y, z);
  }

  public void glScissor(int x, int y, int width, int height) {
    glext_h.glScissor(x, y, width, height);
  }

  public void glSelectBuffer(int size, MemorySegment buffer) {
    glext_h.glSelectBuffer(size, buffer);
  }

  public void glSeparableFilter2D(int target, int internalformat, int width, int height, int format, int type, MemorySegment row, MemorySegment column) {
    glext_h.glSeparableFilter2D(target, internalformat, width, height, format, type, row, column);
  }

  public void glShadeModel(int mode) {
    glext_h.glShadeModel(mode);
  }

  public void glStencilFunc(int func, int ref, int mask) {
    glext_h.glStencilFunc(func, ref, mask);
  }

  public void glStencilMask(int mask) {
    glext_h.glStencilMask(mask);
  }

  public void glStencilOp(int fail, int zfail, int zpass) {
    glext_h.glStencilOp(fail, zfail, zpass);
  }

  public void glTexCoord1d(double s) {
    glext_h.glTexCoord1d(s);
  }

  public void glTexCoord1dv(MemorySegment v) {
    glext_h.glTexCoord1dv(v);
  }

  public void glTexCoord1f(float s) {
    glext_h.glTexCoord1f(s);
  }

  public void glTexCoord1fv(MemorySegment v) {
    glext_h.glTexCoord1fv(v);
  }

  public void glTexCoord1i(int s) {
    glext_h.glTexCoord1i(s);
  }

  public void glTexCoord1iv(MemorySegment v) {
    glext_h.glTexCoord1iv(v);
  }

  public void glTexCoord1s(short s) {
    glext_h.glTexCoord1s(s);
  }

  public void glTexCoord1sv(MemorySegment v) {
    glext_h.glTexCoord1sv(v);
  }

  public void glTexCoord2d(double s, double t) {
    glext_h.glTexCoord2d(s, t);
  }

  public void glTexCoord2dv(MemorySegment v) {
    glext_h.glTexCoord2dv(v);
  }

  public void glTexCoord2f(float s, float t) {
    glext_h.glTexCoord2f(s, t);
  }

  public void glTexCoord2fv(MemorySegment v) {
    glext_h.glTexCoord2fv(v);
  }

  public void glTexCoord2i(int s, int t) {
    glext_h.glTexCoord2i(s, t);
  }

  public void glTexCoord2iv(MemorySegment v) {
    glext_h.glTexCoord2iv(v);
  }

  public void glTexCoord2s(short s, short t) {
    glext_h.glTexCoord2s(s, t);
  }

  public void glTexCoord2sv(MemorySegment v) {
    glext_h.glTexCoord2sv(v);
  }

  public void glTexCoord3d(double s, double t, double r) {
    glext_h.glTexCoord3d(s, t, r);
  }

  public void glTexCoord3dv(MemorySegment v) {
    glext_h.glTexCoord3dv(v);
  }

  public void glTexCoord3f(float s, float t, float r) {
    glext_h.glTexCoord3f(s, t, r);
  }

  public void glTexCoord3fv(MemorySegment v) {
    glext_h.glTexCoord3fv(v);
  }

  public void glTexCoord3i(int s, int t, int r) {
    glext_h.glTexCoord3i(s, t, r);
  }

  public void glTexCoord3iv(MemorySegment v) {
    glext_h.glTexCoord3iv(v);
  }

  public void glTexCoord3s(short s, short t, short r) {
    glext_h.glTexCoord3s(s, t, r);
  }

  public void glTexCoord3sv(MemorySegment v) {
    glext_h.glTexCoord3sv(v);
  }

  public void glTexCoord4d(double s, double t, double r, double q) {
    glext_h.glTexCoord4d(s, t, r, q);
  }

  public void glTexCoord4dv(MemorySegment v) {
    glext_h.glTexCoord4dv(v);
  }

  public void glTexCoord4f(float s, float t, float r, float q) {
    glext_h.glTexCoord4f(s, t, r, q);
  }

  public void glTexCoord4fv(MemorySegment v) {
    glext_h.glTexCoord4fv(v);
  }

  public void glTexCoord4i(int s, int t, int r, int q) {
    glext_h.glTexCoord4i(s, t, r, q);
  }

  public void glTexCoord4iv(MemorySegment v) {
    glext_h.glTexCoord4iv(v);
  }

  public void glTexCoord4s(short s, short t, short r, short q) {
    glext_h.glTexCoord4s(s, t, r, q);
  }

  public void glTexCoord4sv(MemorySegment v) {
    glext_h.glTexCoord4sv(v);
  }

  public void glTexCoordPointer(int size, int type, int stride, MemorySegment pointer) {
    glext_h.glTexCoordPointer(size, type, stride, pointer);
  }

  public void glTexEnvf(int target, int pname, float param) {
    glext_h.glTexEnvf(target, pname, param);
  }

  public void glTexEnvfv(int target, int pname, MemorySegment params) {
    glext_h.glTexEnvfv(target, pname, params);
  }

  public void glTexEnvi(int target, int pname, int param) {
    glext_h.glTexEnvi(target, pname, param);
  }

  public void glTexEnviv(int target, int pname, MemorySegment params) {
    glext_h.glTexEnviv(target, pname, params);
  }

  public void glTexGend(int coord, int pname, double param) {
    glext_h.glTexGend(coord, pname, param);
  }

  public void glTexGendv(int coord, int pname, MemorySegment params) {
    glext_h.glTexGendv(coord, pname, params);
  }

  public void glTexGenf(int coord, int pname, float param) {
    glext_h.glTexGenf(coord, pname, param);
  }

  public void glTexGenfv(int coord, int pname, MemorySegment params) {
    glext_h.glTexGenfv(coord, pname, params);
  }

  public void glTexGeni(int coord, int pname, int param) {
    glext_h.glTexGeni(coord, pname, param);
  }

  public void glTexGeniv(int coord, int pname, MemorySegment params) {
    glext_h.glTexGeniv(coord, pname, params);
  }

  public void glTexImage1D(int target, int level, int internalformat, int width, int border, int format, int type, MemorySegment pixels) {
    glext_h.glTexImage1D(target, level, internalformat, width, border, format, type, pixels);
  }

  public void glTexImage2D(int target, int level, int internalformat, int width, int height, int border, int format, int type, MemorySegment pixels) {
    glext_h.glTexImage2D(target, level, internalformat, width, height, border, format, type, pixels);
  }

  public void glTexImage3D(int target, int level, int internalformat, int width, int height, int depth, int border, int format, int type, MemorySegment pixels) {
    glext_h.glTexImage3D(target, level, internalformat, width, height, depth, border, format, type, pixels);
  }

  public void glTexParameterf(int target, int pname, float param) {
    glext_h.glTexParameterf(target, pname, param);
  }

  public void glTexParameterfv(int target, int pname, MemorySegment params) {
    glext_h.glTexParameterfv(target, pname, params);
  }

  public void glTexParameteri(int target, int pname, int param) {
    glext_h.glTexParameteri(target, pname, param);
  }

  public void glTexParameteriv(int target, int pname, MemorySegment params) {
    glext_h.glTexParameteriv(target, pname, params);
  }

  public void glTexSubImage1D(int target, int level, int xoffset, int width, int format, int type, MemorySegment pixels) {
    glext_h.glTexSubImage1D(target, level, xoffset, width, format, type, pixels);
  }

  public void glTexSubImage2D(int target, int level, int xoffset, int yoffset, int width, int height, int format, int type, MemorySegment pixels) {
    glext_h.glTexSubImage2D(target, level, xoffset, yoffset, width, height, format, type, pixels);
  }

  public void glTexSubImage3D(int target, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int format, int type, MemorySegment pixels) {
    glext_h.glTexSubImage3D(target, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels);
  }

  public void glTranslated(double x, double y, double z) {
    glext_h.glTranslated(x, y, z);
  }

  public void glTranslatef(float x, float y, float z) {
    glext_h.glTranslatef(x, y, z);
  }

  public void glVertex2d(double x, double y) {
    glext_h.glVertex2d(x, y);
  }

  public void glVertex2dv(MemorySegment v) {
    glext_h.glVertex2dv(v);
  }

  public void glVertex2f(float x, float y) {
    glext_h.glVertex2f(x, y);
  }

  public void glVertex2fv(MemorySegment v) {
    glext_h.glVertex2fv(v);
  }

  public void glVertex2i(int x, int y) {
    glext_h.glVertex2i(x, y);
  }

  public void glVertex2iv(MemorySegment v) {
    glext_h.glVertex2iv(v);
  }

  public void glVertex2s(short x, short y) {
    glext_h.glVertex2s(x, y);
  }

  public void glVertex2sv(MemorySegment v) {
    glext_h.glVertex2sv(v);
  }

  public void glVertex3d(double x, double y, double z) {
    glext_h.glVertex3d(x, y, z);
  }

  public void glVertex3dv(MemorySegment v) {
    glext_h.glVertex3dv(v);
  }

  public void glVertex3f(float x, float y, float z) {
    glext_h.glVertex3f(x, y, z);
  }

  public void glVertex3fv(MemorySegment v) {
    glext_h.glVertex3fv(v);
  }

  public void glVertex3i(int x, int y, int z) {
    glext_h.glVertex3i(x, y, z);
  }

  public void glVertex3iv(MemorySegment v) {
    glext_h.glVertex3iv(v);
  }

  public void glVertex3s(short x, short y, short z) {
    glext_h.glVertex3s(x, y, z);
  }

  public void glVertex3sv(MemorySegment v) {
    glext_h.glVertex3sv(v);
  }

  public void glVertex4d(double x, double y, double z, double w) {
    glext_h.glVertex4d(x, y, z, w);
  }

  public void glVertex4dv(MemorySegment v) {
    glext_h.glVertex4dv(v);
  }

  public void glVertex4f(float x, float y, float z, float w) {
    glext_h.glVertex4f(x, y, z, w);
  }

  public void glVertex4fv(MemorySegment v) {
    glext_h.glVertex4fv(v);
  }

  public void glVertex4i(int x, int y, int z, int w) {
    glext_h.glVertex4i(x, y, z, w);
  }

  public void glVertex4iv(MemorySegment v) {
    glext_h.glVertex4iv(v);
  }

  public void glVertex4s(short x, short y, short z, short w) {
    glext_h.glVertex4s(x, y, z, w);
  }

  public void glVertex4sv(MemorySegment v) {
    glext_h.glVertex4sv(v);
  }

  public void glVertexPointer(int size, int type, int stride, MemorySegment pointer) {
    glext_h.glVertexPointer(size, type, stride, pointer);
  }

  public void glViewport(int x, int y, int width, int height) {
    glext_h.glViewport(x, y, width, height);
  }

  public void gluBeginCurve(MemorySegment arg0) {
    glext_h.gluBeginCurve(arg0);
  }

  public void gluBeginPolygon(MemorySegment arg0) {
    glext_h.gluBeginPolygon(arg0);
  }

  public void gluBeginSurface(MemorySegment arg0) {
    glext_h.gluBeginSurface(arg0);
  }

  public void gluBeginTrim(MemorySegment arg0) {
    glext_h.gluBeginTrim(arg0);
  }

  public int gluBuild1DMipmapLevels(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, MemorySegment arg8) {
    return glext_h.gluBuild1DMipmapLevels(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
  }

  public int gluBuild1DMipmaps(int arg0, int arg1, int arg2, int arg3, int arg4, MemorySegment arg5) {
    return glext_h.gluBuild1DMipmaps(arg0, arg1, arg2, arg3, arg4, arg5);
  }

  public int gluBuild2DMipmapLevels(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, MemorySegment arg9) {
    return glext_h.gluBuild2DMipmapLevels(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9);
  }

  public int gluBuild2DMipmaps(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, MemorySegment arg6) {
    return glext_h.gluBuild2DMipmaps(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
  }

  public int gluBuild3DMipmapLevels(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, MemorySegment arg10) {
    return glext_h.gluBuild3DMipmapLevels(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10);
  }

  public int gluBuild3DMipmaps(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, MemorySegment arg7) {
    return glext_h.gluBuild3DMipmaps(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7);
  }

  public byte gluCheckExtension(MemorySegment arg0, MemorySegment arg1) {
    return glext_h.gluCheckExtension(arg0, arg1);
  }

  public void gluCylinder(MemorySegment arg0, double arg1, double arg2, double arg3, int arg4, int arg5) {
    glext_h.gluCylinder(arg0, arg1, arg2, arg3, arg4, arg5);
  }

  public void gluDeleteNurbsRenderer(MemorySegment arg0) {
    glext_h.gluDeleteNurbsRenderer(arg0);
  }

  public void gluDeleteQuadric(MemorySegment arg0) {
    glext_h.gluDeleteQuadric(arg0);
  }

  public void gluDeleteTess(MemorySegment arg0) {
    glext_h.gluDeleteTess(arg0);
  }

  public void gluDisk(MemorySegment arg0, double arg1, double arg2, int arg3, int arg4) {
    glext_h.gluDisk(arg0, arg1, arg2, arg3, arg4);
  }

  public void gluEndCurve(MemorySegment arg0) {
    glext_h.gluEndCurve(arg0);
  }

  public void gluEndPolygon(MemorySegment arg0) {
    glext_h.gluEndPolygon(arg0);
  }

  public void gluEndSurface(MemorySegment arg0) {
    glext_h.gluEndSurface(arg0);
  }

  public void gluEndTrim(MemorySegment arg0) {
    glext_h.gluEndTrim(arg0);
  }

  public MemorySegment gluErrorString(int arg0) {
    return glext_h.gluErrorString(arg0);
  }

  public void gluGetNurbsProperty(MemorySegment arg0, int arg1, MemorySegment arg2) {
    glext_h.gluGetNurbsProperty(arg0, arg1, arg2);
  }

  public MemorySegment gluGetString(int arg0) {
    return glext_h.gluGetString(arg0);
  }

  public void gluGetTessProperty(MemorySegment arg0, int arg1, MemorySegment arg2) {
    glext_h.gluGetTessProperty(arg0, arg1, arg2);
  }

  public void gluLoadSamplingMatrices(MemorySegment arg0, MemorySegment arg1, MemorySegment arg2, MemorySegment arg3) {
    glext_h.gluLoadSamplingMatrices(arg0, arg1, arg2, arg3);
  }

  public void gluLookAt(double arg0, double arg1, double arg2, double arg3, double arg4, double arg5, double arg6, double arg7, double arg8) {
    glext_h.gluLookAt(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
  }

  public MemorySegment gluNewNurbsRenderer() {
    return glext_h.gluNewNurbsRenderer();
  }

  public MemorySegment gluNewQuadric() {
    return glext_h.gluNewQuadric();
  }

  public MemorySegment gluNewTess() {
    return glext_h.gluNewTess();
  }

  public void gluNextContour(MemorySegment arg0, int arg1) {
    glext_h.gluNextContour(arg0, arg1);
  }

  public void gluNurbsCallback(MemorySegment arg0, int arg1, MemorySegment arg2) {
    glext_h.gluNurbsCallback(arg0, arg1, arg2);
  }

  public void gluNurbsCallbackData(MemorySegment arg0, MemorySegment arg1) {
    glext_h.gluNurbsCallbackData(arg0, arg1);
  }

  public void gluNurbsCallbackDataEXT(MemorySegment arg0, MemorySegment arg1) {
    glext_h.gluNurbsCallbackDataEXT(arg0, arg1);
  }

  public void gluNurbsCurve(MemorySegment arg0, int arg1, MemorySegment arg2, int arg3, MemorySegment arg4, int arg5, int arg6) {
    glext_h.gluNurbsCurve(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
  }

  public void gluNurbsProperty(MemorySegment arg0, int arg1, float arg2) {
    glext_h.gluNurbsProperty(arg0, arg1, arg2);
  }

  public void gluNurbsSurface(MemorySegment arg0, int arg1, MemorySegment arg2, int arg3, MemorySegment arg4, int arg5, int arg6, MemorySegment arg7, int arg8, int arg9, int arg10) {
    glext_h.gluNurbsSurface(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10);
  }

  public void gluOrtho2D(double arg0, double arg1, double arg2, double arg3) {
    glext_h.gluOrtho2D(arg0, arg1, arg2, arg3);
  }

  public void gluPartialDisk(MemorySegment arg0, double arg1, double arg2, int arg3, int arg4, double arg5, double arg6) {
    glext_h.gluPartialDisk(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
  }

  public void gluPerspective(double arg0, double arg1, double arg2, double arg3) {
    glext_h.gluPerspective(arg0, arg1, arg2, arg3);
  }

  public void gluPickMatrix(double arg0, double arg1, double arg2, double arg3, MemorySegment arg4) {
    glext_h.gluPickMatrix(arg0, arg1, arg2, arg3, arg4);
  }

  public int gluProject(double arg0, double arg1, double arg2, MemorySegment arg3, MemorySegment arg4, MemorySegment arg5, MemorySegment arg6, MemorySegment arg7, MemorySegment arg8) {
    return glext_h.gluProject(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
  }

  public void gluPwlCurve(MemorySegment arg0, int arg1, MemorySegment arg2, int arg3, int arg4) {
    glext_h.gluPwlCurve(arg0, arg1, arg2, arg3, arg4);
  }

  public void gluQuadricCallback(MemorySegment arg0, int arg1, MemorySegment arg2) {
    glext_h.gluQuadricCallback(arg0, arg1, arg2);
  }

  public void gluQuadricDrawStyle(MemorySegment arg0, int arg1) {
    glext_h.gluQuadricDrawStyle(arg0, arg1);
  }

  public void gluQuadricNormals(MemorySegment arg0, int arg1) {
    glext_h.gluQuadricNormals(arg0, arg1);
  }

  public void gluQuadricOrientation(MemorySegment arg0, int arg1) {
    glext_h.gluQuadricOrientation(arg0, arg1);
  }

  public void gluQuadricTexture(MemorySegment arg0, byte arg1) {
    glext_h.gluQuadricTexture(arg0, arg1);
  }

  public int gluScaleImage(int arg0, int arg1, int arg2, int arg3, MemorySegment arg4, int arg5, int arg6, int arg7, MemorySegment arg8) {
    return glext_h.gluScaleImage(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
  }

  public void gluSphere(MemorySegment arg0, double arg1, int arg2, int arg3) {
    glext_h.gluSphere(arg0, arg1, arg2, arg3);
  }

  public void gluTessBeginContour(MemorySegment arg0) {
    glext_h.gluTessBeginContour(arg0);
  }

  public void gluTessBeginPolygon(MemorySegment arg0, MemorySegment arg1) {
    glext_h.gluTessBeginPolygon(arg0, arg1);
  }

  public void gluTessCallback(MemorySegment arg0, int arg1, MemorySegment arg2) {
    glext_h.gluTessCallback(arg0, arg1, arg2);
  }

  public void gluTessEndContour(MemorySegment arg0) {
    glext_h.gluTessEndContour(arg0);
  }

  public void gluTessEndPolygon(MemorySegment arg0) {
    glext_h.gluTessEndPolygon(arg0);
  }

  public void gluTessNormal(MemorySegment arg0, double arg1, double arg2, double arg3) {
    glext_h.gluTessNormal(arg0, arg1, arg2, arg3);
  }

  public void gluTessProperty(MemorySegment arg0, int arg1, double arg2) {
    glext_h.gluTessProperty(arg0, arg1, arg2);
  }

  public void gluTessVertex(MemorySegment arg0, MemorySegment arg1, MemorySegment arg2) {
    glext_h.gluTessVertex(arg0, arg1, arg2);
  }

  public int gluUnProject(double arg0, double arg1, double arg2, MemorySegment arg3, MemorySegment arg4, MemorySegment arg5, MemorySegment arg6, MemorySegment arg7, MemorySegment arg8) {
    return glext_h.gluUnProject(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
  }

  public int gluUnProject4(double arg0, double arg1, double arg2, double arg3, MemorySegment arg4, MemorySegment arg5, MemorySegment arg6, double arg7, double arg8, MemorySegment arg9, MemorySegment arg10, MemorySegment arg11, MemorySegment arg12) {
    return glext_h.gluUnProject4(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12);
  }

  public void glutAddMenuEntry(MemorySegment arg0, int arg1) {
    glext_h.glutAddMenuEntry(arg0, arg1);
  }

  public void glutAddSubMenu(MemorySegment arg0, int arg1) {
    glext_h.glutAddSubMenu(arg0, arg1);
  }

  public void glutAttachMenu(int arg0) {
    glext_h.glutAttachMenu(arg0);
  }

  public void glutBitmap8By13(MemorySegment arg0) {
    glext_h.glutBitmap8By13();
  }

  public MemorySegment glutBitmap9By15() {
    return glext_h.glutBitmap9By15();
  }

  public void glutBitmapCharacter(MemorySegment arg0, int arg1) {
    glext_h.glutBitmapCharacter(arg0, arg1);
  }

  public MemorySegment glutBitmapHelvetica10() {
    //glext_h.glutBitmapHelvetica10(arg0);
    return null;
  }

  public void glutBitmapHelvetica12(MemorySegment arg0) {
    glext_h.glutBitmapHelvetica12(arg0);
  }

  public MemorySegment glutBitmapHelvetica18() {
    return glext_h.glutBitmapHelvetica18();
  }

  public int glutBitmapLength(MemorySegment arg0, MemorySegment arg1) {
    return glext_h.glutBitmapLength(arg0, arg1);
  }

  public MemorySegment glutBitmapTimesRoman10() {
    return glext_h.glutBitmapTimesRoman10();
  }

  public MemorySegment glutBitmapTimesRoman24() {
    //glext_h.glutBitmapTimesRoman24(arg0);
    return null;
  }

  public int glutBitmapWidth(MemorySegment arg0, int arg1) {
    return glext_h.glutBitmapWidth(arg0, arg1);
  }

  public void glutButtonBoxFunc(MemorySegment arg0) {
    glext_h.glutButtonBoxFunc(arg0);
  }

  public void glutChangeToMenuEntry(int arg0, MemorySegment arg1, int arg2) {
    glext_h.glutChangeToMenuEntry(arg0, arg1, arg2);
  }

  public void glutChangeToSubMenu(int arg0, MemorySegment arg1, int arg2) {
    glext_h.glutChangeToSubMenu(arg0, arg1, arg2);
  }

  public void glutCopyColormap(int arg0) {
    glext_h.glutCopyColormap(arg0);
  }

  public int glutCreateMenu(MemorySegment arg0) {
    return glext_h.glutCreateMenu(arg0);
  }

  public int glutCreateSubWindow(int arg0, int arg1, int arg2, int arg3, int arg4) {
    return glext_h.glutCreateSubWindow(arg0, arg1, arg2, arg3, arg4);
  }

  public int glutCreateWindow(MemorySegment arg0) {
    return glext_h.glutCreateWindow(arg0);
  }

  public void glutDestroyMenu(int arg0) {
    glext_h.glutDestroyMenu(arg0);
  }

  public void glutDestroyWindow(int arg0) {
    glext_h.glutDestroyWindow(arg0);
  }

  public void glutDetachMenu(int arg0) {
    glext_h.glutDetachMenu(arg0);
  }

  public int glutDeviceGet(int arg0) {
    return glext_h.glutDeviceGet(arg0);
  }

  public void glutDialsFunc(MemorySegment arg0) {
    glext_h.glutDialsFunc(arg0);
  }

  public void glutDisplayFunc(MemorySegment arg0) {
    glext_h.glutDisplayFunc(arg0);
  }

  public int glutEnterGameMode() {
    return glext_h.glutEnterGameMode();
  }

  public void glutEntryFunc(MemorySegment arg0) {
    glext_h.glutEntryFunc(arg0);
  }

  public void glutEstablishOverlay() {
    glext_h.glutEstablishOverlay();
  }

  public int glutExtensionSupported(MemorySegment arg0) {
    return glext_h.glutExtensionSupported(arg0);
  }

  public void glutForceJoystickFunc() {
    glext_h.glutForceJoystickFunc();
  }

  public void glutFullScreen() {
    glext_h.glutFullScreen();
  }

  public int glutGameModeGet(int arg0) {
    return glext_h.glutGameModeGet(arg0);
  }

  public void glutGameModeString(MemorySegment arg0) {
    glext_h.glutGameModeString(arg0);
  }

  public int glutGet(int arg0) {
    return glext_h.glutGet(arg0);
  }

  public float glutGetColor(int arg0, int arg1) {
    return glext_h.glutGetColor(arg0, arg1);
  }

  public int glutGetMenu() {
    return glext_h.glutGetMenu();
  }

  public int glutGetModifiers() {
    return glext_h.glutGetModifiers();
  }

  public int glutGetWindow() {
    return glext_h.glutGetWindow();
  }

  public void glutHideOverlay() {
    glext_h.glutHideOverlay();
  }

  public void glutHideWindow() {
    glext_h.glutHideWindow();
  }

  public void glutIconifyWindow() {
    glext_h.glutIconifyWindow();
  }

  public void glutIdleFunc(MemorySegment arg0) {
    glext_h.glutIdleFunc(arg0);
  }

  public void glutIgnoreKeyRepeat(int arg0) {
    glext_h.glutIgnoreKeyRepeat(arg0);
  }

  public void glutInit(MemorySegment arg0, MemorySegment arg1) {
    glext_h.glutInit(arg0, arg1);
  }

  public void glutInitDisplayMode(int arg0) {
    glext_h.glutInitDisplayMode(arg0);
  }

  public void glutInitDisplayString(MemorySegment arg0) {
    glext_h.glutInitDisplayString(arg0);
  }

  public void glutInitWindowPosition(int arg0, int arg1) {
    glext_h.glutInitWindowPosition(arg0, arg1);
  }

  public void glutInitWindowSize(int arg0, int arg1) {
    glext_h.glutInitWindowSize(arg0, arg1);
  }

  public void glutJoystickFunc(MemorySegment arg0, int arg1) {
    glext_h.glutJoystickFunc(arg0, arg1);
  }

  public void glutKeyboardFunc(MemorySegment arg0) {
    glext_h.glutKeyboardFunc(arg0);
  }

  public void glutKeyboardUpFunc(MemorySegment arg0) {
    glext_h.glutKeyboardUpFunc(arg0);
  }

  public int glutLayerGet(int arg0) {
    return glext_h.glutLayerGet(arg0);
  }

  public void glutLeaveGameMode() {
    glext_h.glutLeaveGameMode();
  }

  public void glutMainLoop() {
    glext_h.glutMainLoop();
  }

  public void glutMenuStateFunc(MemorySegment arg0) {
    glext_h.glutMenuStateFunc(arg0);
  }

  public void glutMenuStatusFunc(MemorySegment arg0) {
    glext_h.glutMenuStatusFunc(arg0);
  }

  public void glutMotionFunc(MemorySegment arg0) {
    glext_h.glutMotionFunc(arg0);
  }

  public void glutMouseFunc(MemorySegment arg0) {
    glext_h.glutMouseFunc(arg0);
  }

  public void glutOverlayDisplayFunc(MemorySegment arg0) {
    glext_h.glutOverlayDisplayFunc(arg0);
  }

  public void glutPassiveMotionFunc(MemorySegment arg0) {
    glext_h.glutPassiveMotionFunc(arg0);
  }

  public void glutPopWindow() {
    glext_h.glutPopWindow();
  }

  public void glutPositionWindow(int arg0, int arg1) {
    glext_h.glutPositionWindow(arg0, arg1);
  }

  public void glutPostOverlayRedisplay() {
    glext_h.glutPostOverlayRedisplay();
  }

  public void glutPostRedisplay() {
    glext_h.glutPostRedisplay();
  }

  public void glutPostWindowOverlayRedisplay(int arg0) {
    glext_h.glutPostWindowOverlayRedisplay(arg0);
  }

  public void glutPostWindowRedisplay(int arg0) {
    glext_h.glutPostWindowRedisplay(arg0);
  }

  public void glutPushWindow() {
    glext_h.glutPushWindow();
  }

  public void glutRemoveMenuItem(int arg0) {
    glext_h.glutRemoveMenuItem(arg0);
  }

  public void glutRemoveOverlay() {
    glext_h.glutRemoveOverlay();
  }

  public void glutReportErrors() {
    glext_h.glutReportErrors();
  }

  public void glutReshapeFunc(MemorySegment arg0) {
    glext_h.glutReshapeFunc(arg0);
  }

  public void glutReshapeWindow(int arg0, int arg1) {
    glext_h.glutReshapeWindow(arg0, arg1);
  }

  public void glutSetColor(int arg0, float arg1, float arg2, float arg3) {
    glext_h.glutSetColor(arg0, arg1, arg2, arg3);
  }

  public void glutSetCursor(int arg0) {
    glext_h.glutSetCursor(arg0);
  }

  public void glutSetIconTitle(MemorySegment arg0) {
    glext_h.glutSetIconTitle(arg0);
  }

  public void glutSetKeyRepeat(int arg0) {
    glext_h.glutSetKeyRepeat(arg0);
  }

  public void glutSetMenu(int arg0) {
    glext_h.glutSetMenu(arg0);
  }

  public void glutSetWindow(int arg0) {
    glext_h.glutSetWindow(arg0);
  }

  public void glutSetWindowTitle(MemorySegment arg0) {
    glext_h.glutSetWindowTitle(arg0);
  }

  public void glutSetupVideoResizing() {
    glext_h.glutSetupVideoResizing();
  }

  public void glutShowOverlay() {
    glext_h.glutShowOverlay();
  }

  public void glutShowWindow() {
    glext_h.glutShowWindow();
  }

  public void glutSolidCone(double arg0, double arg1, int arg2, int arg3) {
    glext_h.glutSolidCone(arg0, arg1, arg2, arg3);
  }

  public void glutSolidCube(double arg0) {
    glext_h.glutSolidCube(arg0);
  }

  public void glutSolidDodecahedron() {
    glext_h.glutSolidDodecahedron();
  }

  public void glutSolidIcosahedron() {
    glext_h.glutSolidIcosahedron();
  }

  public void glutSolidOctahedron() {
    glext_h.glutSolidOctahedron();
  }

  public void glutSolidSphere(double arg0, int arg1, int arg2) {
    glext_h.glutSolidSphere(arg0, arg1, arg2);
  }

  public void glutSolidTeapot(double arg0) {
    glext_h.glutSolidTeapot(arg0);
  }

  public void glutSolidTetrahedron() {
    glext_h.glutSolidTetrahedron();
  }

  public void glutSolidTorus(double arg0, double arg1, int arg2, int arg3) {
    glext_h.glutSolidTorus(arg0, arg1, arg2, arg3);
  }

  public void glutSpaceballButtonFunc(MemorySegment arg0) {
    glext_h.glutSpaceballButtonFunc(arg0);
  }

  public void glutSpaceballMotionFunc(MemorySegment arg0) {
    glext_h.glutSpaceballMotionFunc(arg0);
  }

  public void glutSpaceballRotateFunc(MemorySegment arg0) {
    glext_h.glutSpaceballRotateFunc(arg0);
  }

  public void glutSpecialFunc(MemorySegment arg0) {
    glext_h.glutSpecialFunc(arg0);
  }

  public void glutSpecialUpFunc(MemorySegment arg0) {
    glext_h.glutSpecialUpFunc(arg0);
  }

  public void glutStopVideoResizing() {
    glext_h.glutStopVideoResizing();
  }

  public void glutStrokeCharacter(MemorySegment arg0, int arg1) {
    glext_h.glutStrokeCharacter(arg0, arg1);
  }

  public int glutStrokeLength(MemorySegment arg0, MemorySegment arg1) {
    return glext_h.glutStrokeLength(arg0, arg1);
  }

  public MemorySegment glutStrokeMonoRoman() {
    return glext_h.glutStrokeMonoRoman();
  }

  public void glutStrokeRoman(MemorySegment arg0) {
    glext_h.glutStrokeRoman(arg0);
  }

  public int glutStrokeWidth(MemorySegment arg0, int arg1) {
    return glext_h.glutStrokeWidth(arg0, arg1);
  }

  public void glutSwapBuffers() {
    glext_h.glutSwapBuffers();
  }

  public void glutTabletButtonFunc(MemorySegment arg0) {
    glext_h.glutTabletButtonFunc(arg0);
  }

  public void glutTabletMotionFunc(MemorySegment arg0) {
    glext_h.glutTabletMotionFunc(arg0);
  }

  public void glutTimerFunc(int arg0, MemorySegment arg1, int arg2) {
    glext_h.glutTimerFunc(arg0, arg1, arg2);
  }

  public void glutUseLayer(int arg0) {
    glext_h.glutUseLayer(arg0);
  }

  public void glutVideoPan(int arg0, int arg1, int arg2, int arg3) {
    glext_h.glutVideoPan(arg0, arg1, arg2, arg3);
  }

  public void glutVideoResize(int arg0, int arg1, int arg2, int arg3) {
    glext_h.glutVideoResize(arg0, arg1, arg2, arg3);
  }

  public int glutVideoResizeGet(int arg0) {
    return glext_h.glutVideoResizeGet(arg0);
  }

  public void glutVisibilityFunc(MemorySegment arg0) {
    glext_h.glutVisibilityFunc(arg0);
  }

  public void glutWarpPointer(int arg0, int arg1) {
    glext_h.glutWarpPointer(arg0, arg1);
  }

  public void glutWindowStatusFunc(MemorySegment arg0) {
    glext_h.glutWindowStatusFunc(arg0);
  }

  public void glutWireCone(double arg0, double arg1, int arg2, int arg3) {
    glext_h.glutWireCone(arg0, arg1, arg2, arg3);
  }

  public void glutWireCube(double arg0) {
    glext_h.glutWireCube(arg0);
  }

  public void glutWireDodecahedron() {
    glext_h.glutWireDodecahedron();
  }

  public void glutWireIcosahedron() {
    glext_h.glutWireIcosahedron();
  }

  public void glutWireOctahedron() {
    glext_h.glutWireOctahedron();
  }

  public void glutWireSphere(double arg0, int arg1, int arg2) {
    glext_h.glutWireSphere(arg0, arg1, arg2);
  }

  public void glutWireTeapot(double arg0) {
    glext_h.glutWireTeapot(arg0);
  }

  public void glutWireTetrahedron() {
    glext_h.glutWireTetrahedron();
  }

  public void glutWireTorus(double arg0, double arg1, int arg2, int arg3) {
    glext_h.glutWireTorus(arg0, arg1, arg2, arg3);
  }

  public void glMultiTexImage3DEXT(int texunit, int target, int level, int internalformat, int width, int height, int depth, int border, int format, int type, MemorySegment pixels) {
    PFNGLMULTITEXIMAGE3DEXTPROC.invoke(address("glMultiTexImage3DEXT"), texunit, target, level, internalformat, width, height, depth, border, format, type, pixels);
  }

  public int glCheckFramebufferStatusOES(int target) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMulticastBarrierNV() {
    PFNGLMULTICASTBARRIERNVPROC.invoke(address("glMulticastBarrierNV"));
  }

  public void glTextureMaterialEXT(int face, int mode) {
    PFNGLTEXTUREMATERIALEXTPROC.invoke(address("glTextureMaterialEXT"), face, mode);
  }

  public void glInstrumentsBufferSGIX(int size, MemorySegment buffer) {
    PFNGLINSTRUMENTSBUFFERSGIXPROC.invoke(address("glInstrumentsBufferSGIX"), size, buffer);
  }

  public void glPrimitiveRestartNV() {
    PFNGLPRIMITIVERESTARTNVPROC.invoke(address("glPrimitiveRestartNV"));
  }

  public void glGetInfoLogARB(int obj, int maxLength, MemorySegment length, MemorySegment infoLog) {
    PFNGLGETINFOLOGARBPROC.invoke(address("glGetInfoLogARB"), obj, maxLength, length, infoLog);
  }

  public void glBufferAddressRangeNV(int pname, int index, long address, long length) {
    PFNGLBUFFERADDRESSRANGENVPROC.invoke(address("glBufferAddressRangeNV"), pname, index, address, length);
  }

  public void glNamedFramebufferParameteri(int framebuffer, int pname, int param) {
    PFNGLNAMEDFRAMEBUFFERPARAMETERIPROC.invoke(address("glNamedFramebufferParameteri"), framebuffer, pname, param);
  }

  public void glClipPlanex(int plane, MemorySegment equation) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBinormal3bvEXT(MemorySegment v) {
    PFNGLBINORMAL3BVEXTPROC.invoke(address("glBinormal3bvEXT"), v);
  }

  public void glUniform1iv(int location, int count, MemorySegment value) {
    PFNGLUNIFORM1IVPROC.invoke(address("glUniform1iv"), location, count, value);
  }

  public void glVertex4bOES(byte x, byte y, byte z, byte w) {
    PFNGLVERTEX4BOESPROC.invoke(address("glVertex4bOES"), x, y, z, w);
  }

  public void glVertex4xOES(int x, int y, int z) {
    PFNGLVERTEX4XOESPROC.invoke(address("glVertex4xOES"), x, y, z);
  }

  public void glVertexAttrib1fvNV(int index, MemorySegment v) {
    PFNGLVERTEXATTRIB1FVNVPROC.invoke(address("glVertexAttrib1fvNV"), index, v);
  }

  public void glGetnUniformuivARB(int program, int location, int bufSize, MemorySegment params) {
    PFNGLGETNUNIFORMUIVARBPROC.invoke(address("glGetnUniformuivARB"), program, location, bufSize, params);
  }

  public void glNamedBufferData(int buffer, long size, MemorySegment data, int usage) {
    PFNGLNAMEDBUFFERDATAPROC.invoke(address("glNamedBufferData"), buffer, size, data, usage);
  }

  public void glUniform4uiEXT(int location, int v0, int v1, int v2, int v3) {
    PFNGLUNIFORM4UIEXTPROC.invoke(address("glUniform4uiEXT"), location, v0, v1, v2, v3);
  }

  public void glFogCoorddv(MemorySegment coord) {
    PFNGLFOGCOORDDVPROC.invoke(address("glFogCoorddv"), coord);
  }

  public void glWindowPos2sMESA(short x, short y) {
    PFNGLWINDOWPOS2SMESAPROC.invoke(address("glWindowPos2sMESA"), x, y);
  }

  public void glWindowPos2dMESA(double x, double y) {
    PFNGLWINDOWPOS2DMESAPROC.invoke(address("glWindowPos2dMESA"), x, y);
  }

  public void glPixelTransformParameteriEXT(int target, int pname, int param) {
    PFNGLPIXELTRANSFORMPARAMETERIEXTPROC.invoke(address("glPixelTransformParameteriEXT"), target, pname, param);
  }

  public void glProgramEnvParameterI4ivNV(int target, int index, MemorySegment params) {
    PFNGLPROGRAMENVPARAMETERI4IVNVPROC.invoke(address("glProgramEnvParameterI4ivNV"), target, index, params);
  }

  public void glTexBufferRangeEXT(int target, int internalformat, int buffer, long offset, long size) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetTextureLevelParameterivEXT(int texture, int target, int level, int pname, MemorySegment params) {
    PFNGLGETTEXTURELEVELPARAMETERIVEXTPROC.invoke(address("glGetTextureLevelParameterivEXT"), texture, target, level, pname, params);
  }

  public void glRectxvOES(MemorySegment v1, MemorySegment v2) {
    PFNGLRECTXVOESPROC.invoke(address("glRectxvOES"), v1, v2);
  }

  public void glVertexAttrib4fARB(int index, float x, float y, float z, float w) {
    PFNGLVERTEXATTRIB4FARBPROC.invoke(address("glVertexAttrib4fARB"), index, x, y, z, w);
  }

  public void glGetQueryBufferObjectiv(int id, int buffer, int pname, long offset) {
    PFNGLGETQUERYBUFFEROBJECTIVPROC.invoke(address("glGetQueryBufferObjectiv"), id, buffer, pname, offset);
  }

  public void glUniform1ui64vARB(int location, int count, MemorySegment value) {
    PFNGLUNIFORM1UI64VARBPROC.invoke(address("glUniform1ui64vARB"), location, count, value);
  }

  public void glVertexAttrib2hvNV(int index, MemorySegment v) {
    PFNGLVERTEXATTRIB2HVNVPROC.invoke(address("glVertexAttrib2hvNV"), index, v);
  }

  public void glVertexAttrib2svNV(int index, MemorySegment v) {
    PFNGLVERTEXATTRIB2SVNVPROC.invoke(address("glVertexAttrib2svNV"), index, v);
  }

  public void glGetImageTransformParameterivHP(int target, int pname, MemorySegment params) {
    PFNGLGETIMAGETRANSFORMPARAMETERIVHPPROC.invoke(address("glGetImageTransformParameterivHP"), target, pname, params);
  }

  public void glReplacementCodeuiColor3fVertex3fvSUN(MemorySegment rc, MemorySegment c, MemorySegment v) {
    PFNGLREPLACEMENTCODEUICOLOR3FVERTEX3FVSUNPROC.invoke(address("glReplacementCodeuiColor3fVertex3fvSUN"), rc, c, v);
  }

  public void glFragmentLightModeliSGIX(int pname, int param) {
    PFNGLFRAGMENTLIGHTMODELISGIXPROC.invoke(address("glFragmentLightModeliSGIX"), pname, param);
  }

  public void glMultiTexCoord2hNV(int target, short s, short t) {
    PFNGLMULTITEXCOORD2HNVPROC.invoke(address("glMultiTexCoord2hNV"), target, s, t);
  }

  public void glMakeImageHandleNonResidentARB(long handle) {
    PFNGLMAKEIMAGEHANDLENONRESIDENTARBPROC.invoke(address("glMakeImageHandleNonResidentARB"), handle);
  }

  public void glVertexStream1svATI(int stream, MemorySegment coords) {
    PFNGLVERTEXSTREAM1SVATIPROC.invoke(address("glVertexStream1svATI"), stream, coords);
  }

  public void glImportSemaphoreWin32NameEXT(int semaphore, int handleType, MemorySegment name) {
    PFNGLIMPORTSEMAPHOREWIN32NAMEEXTPROC.invoke(address("glImportSemaphoreWin32NameEXT"), semaphore, handleType, name);
  }

  public String glGetStringi(int name, int index) {
    return string(PFNGLGETSTRINGIPROC.invoke(address("glGetStringi"), name, index));
  }

  public void glVertexAttribL1ui64vARB(int index, MemorySegment v) {
    PFNGLVERTEXATTRIBL1UI64VARBPROC.invoke(address("glVertexAttribL1ui64vARB"), index, v);
  }

  public void glSecondaryColor3bEXT(byte red, byte green, byte blue) {
    PFNGLSECONDARYCOLOR3BEXTPROC.invoke(address("glSecondaryColor3bEXT"), red, green, blue);
  }

  public void glGetPixelTexGenParameterfvSGIS(int pname, MemorySegment params) {
    PFNGLGETPIXELTEXGENPARAMETERFVSGISPROC.invoke(address("glGetPixelTexGenParameterfvSGIS"), pname, params);
  }

  public void glClipControlEXT(int origin, int depth) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glClipPlanef(int p, MemorySegment eqn) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniform2dvEXT(int program, int location, int count, MemorySegment value) {
    PFNGLPROGRAMUNIFORM2DVEXTPROC.invoke(address("glProgramUniform2dvEXT"), program, location, count, value);
  }

  public void glGetPathSpacingNV(int pathListMode, int numPaths, int pathNameType, MemorySegment paths, int pathBase, float advanceScale, float kerningScale, int transformType, MemorySegment returnedSpacing) {
    PFNGLGETPATHSPACINGNVPROC.invoke(address("glGetPathSpacingNV"), pathListMode, numPaths, pathNameType, paths, pathBase, advanceScale, kerningScale, transformType, returnedSpacing);
  }

  public void glClearNamedBufferDataEXT(int buffer, int internalformat, int format, int type, MemorySegment data) {
    PFNGLCLEARNAMEDBUFFERDATAEXTPROC.invoke(address("glClearNamedBufferDataEXT"), buffer, internalformat, format, type, data);
  }

  public void glColor4ubVertex2fSUN(byte r, byte g, byte b, byte a, float x, float y) {
    PFNGLCOLOR4UBVERTEX2FSUNPROC.invoke(address("glColor4ubVertex2fSUN"), r, g, b, a, x, y);
  }

  public void glPointSizexOES(int size) {
    PFNGLPOINTSIZEXOESPROC.invoke(address("glPointSizexOES"), size);
  }

  public void glRequestResidentProgramsNV(int n, MemorySegment programs) {
    PFNGLREQUESTRESIDENTPROGRAMSNVPROC.invoke(address("glRequestResidentProgramsNV"), n, programs);
  }

  public void glGetnMapfv(int target, int query, int bufSize, MemorySegment v) {
    PFNGLGETNMAPFVPROC.invoke(address("glGetnMapfv"), target, query, bufSize, v);
  }

  public void glMultiTexGenfEXT(int texunit, int coord, int pname, float param) {
    PFNGLMULTITEXGENFEXTPROC.invoke(address("glMultiTexGenfEXT"), texunit, coord, pname, param);
  }

  public void glClearPixelLocalStorageuiEXT(int offset, int n, MemorySegment values) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glClearTexImageEXT(int texture, int level, int format, int type, MemorySegment data) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetTextureParameterIivEXT(int texture, int target, int pname, MemorySegment params) {
    PFNGLGETTEXTUREPARAMETERIIVEXTPROC.invoke(address("glGetTextureParameterIivEXT"), texture, target, pname, params);
  }

  public void glOrthoxOES(int l, int r, int b, int t, int n, int f) {
    PFNGLORTHOXOESPROC.invoke(address("glOrthoxOES"), l, r, b, t, n, f);
  }

  public void glGetMapParameterivNV(int target, int pname, MemorySegment params) {
    PFNGLGETMAPPARAMETERIVNVPROC.invoke(address("glGetMapParameterivNV"), target, pname, params);
  }

  public void glImportMemoryWin32HandleEXT(int memory, long size, int handleType, MemorySegment handle) {
    PFNGLIMPORTMEMORYWIN32HANDLEEXTPROC.invoke(address("glImportMemoryWin32HandleEXT"), memory, size, handleType, handle);
  }

  public void glGetShaderSourceARB(int obj, int maxLength, MemorySegment length, MemorySegment source) {
    PFNGLGETSHADERSOURCEARBPROC.invoke(address("glGetShaderSourceARB"), obj, maxLength, length, source);
  }

  public void glCoverFillPathNV(int path, int coverMode) {
    PFNGLCOVERFILLPATHNVPROC.invoke(address("glCoverFillPathNV"), path, coverMode);
  }

  public int glGetVaryingLocationNV(int program, MemorySegment name) {
    return PFNGLGETVARYINGLOCATIONNVPROC.invoke(address("glGetVaryingLocationNV"), program, name);
  }

  public void glDrawCommandsAddressNV(int primitiveMode, MemorySegment indirects, MemorySegment sizes, int count) {
    PFNGLDRAWCOMMANDSADDRESSNVPROC.invoke(address("glDrawCommandsAddressNV"), primitiveMode, indirects, sizes, count);
  }

  public void glBindTextureUnit(int unit, int texture) {
    PFNGLBINDTEXTUREUNITPROC.invoke(address("glBindTextureUnit"), unit, texture);
  }

  public MemorySegment glMapBufferARB(int target, int access) {
    return PFNGLMAPBUFFERARBPROC.invoke(address("glMapBufferARB"), target, access);
  }

  public void glUniform1dv(int location, int count, MemorySegment value) {
    PFNGLUNIFORM1DVPROC.invoke(address("glUniform1dv"), location, count, value);
  }

  public void glTexStorageAttribs3DEXT(int target, int levels, int internalformat, int width, int height, int depth, int attrib_list) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glPrimitiveBoundingBoxOES(float minX, float minY, float minZ, float minW, float maxX, float maxY, float maxZ, float maxW) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribI4bvEXT(int index, MemorySegment v) {
    PFNGLVERTEXATTRIBI4BVEXTPROC.invoke(address("glVertexAttribI4bvEXT"), index, v);
  }

  public void glGetProgramResourceiv(int program, int programInterface, int index, int propCount, MemorySegment props, int count, MemorySegment length, MemorySegment params) {
    PFNGLGETPROGRAMRESOURCEIVPROC.invoke(address("glGetProgramResourceiv"), program, programInterface, index, propCount, props, count, length, params);
  }

  public void glVertexAttribI1ivEXT(int index, MemorySegment v) {
    PFNGLVERTEXATTRIBI1IVEXTPROC.invoke(address("glVertexAttribI1ivEXT"), index, v);
  }

  public void glMemoryObjectParameterivEXT(int memoryObject, int pname, MemorySegment params) {
    PFNGLMEMORYOBJECTPARAMETERIVEXTPROC.invoke(address("glMemoryObjectParameterivEXT"), memoryObject, pname, params);
  }

  public void glGetColorTableSGI(int target, int format, int type, MemorySegment table) {
    PFNGLGETCOLORTABLESGIPROC.invoke(address("glGetColorTableSGI"), target, format, type, table);
  }

  public void glGetObjectBufferivATI(int buffer, int pname, MemorySegment params) {
    PFNGLGETOBJECTBUFFERIVATIPROC.invoke(address("glGetObjectBufferivATI"), buffer, pname, params);
  }

  public void glTexCoord2bvOES(MemorySegment coords) {
    PFNGLTEXCOORD2BVOESPROC.invoke(address("glTexCoord2bvOES"), coords);
  }

  public void glNamedFramebufferTexture3DEXT(int framebuffer, int attachment, int textarget, int texture, int level, int zoffset) {
    PFNGLNAMEDFRAMEBUFFERTEXTURE3DEXTPROC.invoke(address("glNamedFramebufferTexture3DEXT"), framebuffer, attachment, textarget, texture, level, zoffset);
  }

  public void glUniform3i64NV(int location, long x, long y, long z) {
    PFNGLUNIFORM3I64NVPROC.invoke(address("glUniform3i64NV"), location, x, y, z);
  }

  public void glDrawMeshTasksIndirectNV(long indirect) {
    PFNGLDRAWMESHTASKSINDIRECTNVPROC.invoke(address("glDrawMeshTasksIndirectNV"), indirect);
  }

  public void glGetnMapdv(int target, int query, int bufSize, MemorySegment v) {
    PFNGLGETNMAPDVPROC.invoke(address("glGetnMapdv"), target, query, bufSize, v);
  }

  public void glConvolutionFilter1DEXT(int target, int internalformat, int width, int format, int type, MemorySegment image) {
    PFNGLCONVOLUTIONFILTER1DEXTPROC.invoke(address("glConvolutionFilter1DEXT"), target, internalformat, width, format, type, image);
  }

  public void glCopyImageSubDataEXT(int srcName, int srcTarget, int srcLevel, int srcX, int srcY, int srcZ, int dstName, int dstTarget, int dstLevel, int dstX, int dstY, int dstZ, int srcWidth, int srcHeight, int srcDepth) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDeleteVertexArrays(int n, MemorySegment arrays) {
    PFNGLDELETEVERTEXARRAYSPROC.invoke(address("glDeleteVertexArrays"), n, arrays);
  }

  public void glGetUniformSubroutineuiv(int shadertype, int location, MemorySegment params) {
    PFNGLGETUNIFORMSUBROUTINEUIVPROC.invoke(address("glGetUniformSubroutineuiv"), shadertype, location, params);
  }

  public void glFogCoordfv(MemorySegment coord) {
    PFNGLFOGCOORDFVPROC.invoke(address("glFogCoordfv"), coord);
  }

  public void glProgramUniformHandleui64vARB(int program, int location, int count, MemorySegment values) {
    PFNGLPROGRAMUNIFORMHANDLEUI64VARBPROC.invoke(address("glProgramUniformHandleui64vARB"), program, location, count, values);
  }

  public void glCompressedTextureImage3DEXT(int texture, int target, int level, int internalformat, int width, int height, int depth, int border, int imageSize, MemorySegment bits) {
    PFNGLCOMPRESSEDTEXTUREIMAGE3DEXTPROC.invoke(address("glCompressedTextureImage3DEXT"), texture, target, level, internalformat, width, height, depth, border, imageSize, bits);
  }

  public byte glIsStateNV(int state) {
    return PFNGLISSTATENVPROC.invoke(address("glIsStateNV"), state);
  }

  public void glDeleteFramebuffers(int n, MemorySegment framebuffers) {
    PFNGLDELETEFRAMEBUFFERSPROC.invoke(address("glDeleteFramebuffers"), n, framebuffers);
  }

  public void glUniform1fv(int location, int count, MemorySegment value) {
    PFNGLUNIFORM1FVPROC.invoke(address("glUniform1fv"), location, count, value);
  }

  public void glVertexAttribL1i64vNV(int index, MemorySegment v) {
    PFNGLVERTEXATTRIBL1I64VNVPROC.invoke(address("glVertexAttribL1i64vNV"), index, v);
  }

  public void glSamplerParameterIiv(int sampler, int pname, MemorySegment param) {
    PFNGLSAMPLERPARAMETERIIVPROC.invoke(address("glSamplerParameterIiv"), sampler, pname, param);
  }

  public void glGetShaderiv(int shader, int pname, MemorySegment params) {
    PFNGLGETSHADERIVPROC.invoke(address("glGetShaderiv"), shader, pname, params);
  }

  public void glVariantPointerEXT(int id, int type, int stride, MemorySegment addr) {
    PFNGLVARIANTPOINTEREXTPROC.invoke(address("glVariantPointerEXT"), id, type, stride, addr);
  }

  public void glVariantfvEXT(int id, MemorySegment addr) {
    PFNGLVARIANTFVEXTPROC.invoke(address("glVariantfvEXT"), id, addr);
  }

  public void glBindFragDataLocation(int program, int color, MemorySegment name) {
    PFNGLBINDFRAGDATALOCATIONPROC.invoke(address("glBindFragDataLocation"), program, color, name);
  }

  public void glProgramUniformMatrix3x2fvEXT(int program, int location, int count, byte transpose, MemorySegment value) {
    PFNGLPROGRAMUNIFORMMATRIX3X2FVEXTPROC.invoke(address("glProgramUniformMatrix3x2fvEXT"), program, location, count, transpose, value);
  }

  public void glVertexAttrib1dvARB(int index, MemorySegment v) {
    PFNGLVERTEXATTRIB1DVARBPROC.invoke(address("glVertexAttrib1dvARB"), index, v);
  }

  public void glGetIntegerui64vNV(int value, MemorySegment result) {
    PFNGLGETINTEGERUI64VNVPROC.invoke(address("glGetIntegerui64vNV"), value, result);
  }

  public void glTexCoord3hvNV(MemorySegment v) {
    PFNGLTEXCOORD3HVNVPROC.invoke(address("glTexCoord3hvNV"), v);
  }

  public void glWeightPathsNV(int resultPath, int numPaths, MemorySegment paths, MemorySegment weights) {
    PFNGLWEIGHTPATHSNVPROC.invoke(address("glWeightPathsNV"), resultPath, numPaths, paths, weights);
  }

  public void glMultiDrawElementsIndirect(int mode, int type, MemorySegment indirect, int drawcount, int stride) {
    PFNGLMULTIDRAWELEMENTSINDIRECTPROC.invoke(address("glMultiDrawElementsIndirect"), mode, type, indirect, drawcount, stride);
  }

  public void glBufferStorageEXT(int target, long size, MemorySegment data, int flags) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexCoordP3ui(int texture, int type, int coords) {
    PFNGLMULTITEXCOORDP3UIPROC.invoke(address("glMultiTexCoordP3ui"), texture, type, coords);
  }

  public int glPathGlyphIndexRangeNV(int fontTarget, MemorySegment fontName, int fontStyle, int pathParameterTemplate, float emScale, MemorySegment baseAndCount) {
    return PFNGLPATHGLYPHINDEXRANGENVPROC.invoke(address("glPathGlyphIndexRangeNV"), fontTarget, fontName, fontStyle, pathParameterTemplate, emScale, baseAndCount);
  }

  public void glProgramParameter4fvNV(int target, int index, MemorySegment v) {
    PFNGLPROGRAMPARAMETER4FVNVPROC.invoke(address("glProgramParameter4fvNV"), target, index, v);
  }

  public void glUniform2uiv(int location, int count, MemorySegment value) {
    PFNGLUNIFORM2UIVPROC.invoke(address("glUniform2uiv"), location, count, value);
  }

  public void glResetMinmaxEXT(int target) {
    PFNGLRESETMINMAXEXTPROC.invoke(address("glResetMinmaxEXT"), target);
  }

  public void glBindTransformFeedbackNV(int target, int id) {
    PFNGLBINDTRANSFORMFEEDBACKNVPROC.invoke(address("glBindTransformFeedbackNV"), target, id);
  }

  public void glVertexAttrib1fv(int index, MemorySegment v) {
    PFNGLVERTEXATTRIB1FVPROC.invoke(address("glVertexAttrib1fv"), index, v);
  }

  public void glVertexWeighthNV(short weight) {
    PFNGLVERTEXWEIGHTHNVPROC.invoke(address("glVertexWeighthNV"), weight);
  }

  public void glPixelTexGenParameteriSGIS(int pname, int param) {
    PFNGLPIXELTEXGENPARAMETERISGISPROC.invoke(address("glPixelTexGenParameteriSGIS"), pname, param);
  }

  public void glVertexAttribL4i64NV(int index, long x, long y, long z, long w) {
    PFNGLVERTEXATTRIBL4I64NVPROC.invoke(address("glVertexAttribL4i64NV"), index, x, y, z, w);
  }

  public void glStencilClearTagEXT(int stencilTagBits, int stencilClearTag) {
    PFNGLSTENCILCLEARTAGEXTPROC.invoke(address("glStencilClearTagEXT"), stencilTagBits, stencilClearTag);
  }

  public void glBeginQuery(int target, int id) {
    PFNGLBEGINQUERYPROC.invoke(address("glBeginQuery"), target, id);
  }

  public void glGetFloati_v(int target, int index, MemorySegment data) {
    PFNGLGETFLOATI_VPROC.invoke(address("glGetFloati_v"), target, index, data);
  }

  public void glVertexAttrib4NbvARB(int index, MemorySegment v) {
    PFNGLVERTEXATTRIB4NBVARBPROC.invoke(address("glVertexAttrib4NbvARB"), index, v);
  }

  public void glVertexAttrib4hNV(int index, short x, short y, short z, short w) {
    PFNGLVERTEXATTRIB4HNVPROC.invoke(address("glVertexAttrib4hNV"), index, x, y, z, w);
  }

  public byte glIsEnabledi(int target, int index) {
    return PFNGLISENABLEDIPROC.invoke(address("glIsEnabledi"), target, index);
  }

  public void glProgramUniform2dEXT(int program, int location, double x, double y) {
    PFNGLPROGRAMUNIFORM2DEXTPROC.invoke(address("glProgramUniform2dEXT"), program, location, x, y);
  }

  public int glGetDebugMessageLog(int count, int bufSize, MemorySegment sources, MemorySegment types, MemorySegment ids, MemorySegment severities, MemorySegment lengths, MemorySegment messageLog) {
    return PFNGLGETDEBUGMESSAGELOGPROC.invoke(address("glGetDebugMessageLog"), count, bufSize, sources, types, ids, severities, lengths, messageLog);
  }

  public void glVertexAttrib1dv(int index, MemorySegment v) {
    PFNGLVERTEXATTRIB1DVPROC.invoke(address("glVertexAttrib1dv"), index, v);
  }

  public int glCreateProgressFenceNVX() {
    return PFNGLCREATEPROGRESSFENCENVXPROC.invoke(address("glCreateProgressFenceNVX"));
  }

  public void glPointParameterxvOES(int pname, MemorySegment params) {
    PFNGLPOINTPARAMETERXVOESPROC.invoke(address("glPointParameterxvOES"), pname, params);
  }

  public void glPixelTexGenParameterfvSGIS(int pname, MemorySegment params) {
    PFNGLPIXELTEXGENPARAMETERFVSGISPROC.invoke(address("glPixelTexGenParameterfvSGIS"), pname, params);
  }

  public void glMultiDrawMeshTasksIndirectCountNV(long indirect, long drawcount, int maxdrawcount, int stride) {
    PFNGLMULTIDRAWMESHTASKSINDIRECTCOUNTNVPROC.invoke(address("glMultiDrawMeshTasksIndirectCountNV"), indirect, drawcount, maxdrawcount, stride);
  }

  public void glPathCoordsNV(int path, int numCoords, int coordType, MemorySegment coords) {
    PFNGLPATHCOORDSNVPROC.invoke(address("glPathCoordsNV"), path, numCoords, coordType, coords);
  }

  public void glGetIntegerIndexedvEXT(int target, int index, MemorySegment data) {
    PFNGLGETINTEGERINDEXEDVEXTPROC.invoke(address("glGetIntegerIndexedvEXT"), target, index, data);
  }

  public int glCheckNamedFramebufferStatus(int framebuffer, int target) {
    return PFNGLCHECKNAMEDFRAMEBUFFERSTATUSPROC.invoke(address("glCheckNamedFramebufferStatus"), framebuffer, target);
  }

  public void glMultiTexEnvivEXT(int texunit, int target, int pname, MemorySegment params) {
    PFNGLMULTITEXENVIVEXTPROC.invoke(address("glMultiTexEnvivEXT"), texunit, target, pname, params);
  }

  public byte glTestFenceNV(int fence) {
    return PFNGLTESTFENCENVPROC.invoke(address("glTestFenceNV"), fence);
  }

  public void glTextureBuffer(int texture, int internalformat, int buffer) {
    PFNGLTEXTUREBUFFERPROC.invoke(address("glTextureBuffer"), texture, internalformat, buffer);
  }

  public int glObjectUnpurgeableAPPLE(int objectType, int name, int option) {
    return PFNGLOBJECTUNPURGEABLEAPPLEPROC.invoke(address("glObjectUnpurgeableAPPLE"), objectType, name, option);
  }

  public void glBindVideoCaptureStreamTextureNV(int video_capture_slot, int stream, int frame_region, int target, int texture) {
    PFNGLBINDVIDEOCAPTURESTREAMTEXTURENVPROC.invoke(address("glBindVideoCaptureStreamTextureNV"), video_capture_slot, stream, frame_region, target, texture);
  }

  public void glBlendFuncSeparateINGR(int sfactorRGB, int dfactorRGB, int sfactorAlpha, int dfactorAlpha) {
    PFNGLBLENDFUNCSEPARATEINGRPROC.invoke(address("glBlendFuncSeparateINGR"), sfactorRGB, dfactorRGB, sfactorAlpha, dfactorAlpha);
  }

  public byte glIsPathNV(int path) {
    return PFNGLISPATHNVPROC.invoke(address("glIsPathNV"), path);
  }

  public void glMinSampleShadingOES(float value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetMemoryObjectParameterivEXT(int memoryObject, int pname, MemorySegment params) {
    PFNGLGETMEMORYOBJECTPARAMETERIVEXTPROC.invoke(address("glGetMemoryObjectParameterivEXT"), memoryObject, pname, params);
  }

  public void glMatrixOrthoEXT(int mode, double left, double right, double bottom, double top, double zNear, double zFar) {
    PFNGLMATRIXORTHOEXTPROC.invoke(address("glMatrixOrthoEXT"), mode, left, right, bottom, top, zNear, zFar);
  }

  public void glDepthRangeIndexeddNV(int index, double n, double f) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniform3fEXT(int program, int location, float v0, float v1, float v2) {
    PFNGLPROGRAMUNIFORM3FEXTPROC.invoke(address("glProgramUniform3fEXT"), program, location, v0, v1, v2);
  }

  public void glMultiDrawElementsBaseVertexEXT(int mode, MemorySegment count, int type, MemorySegment indices, int drawcount, MemorySegment basevertex) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetnMapiv(int target, int query, int bufSize, MemorySegment v) {
    PFNGLGETNMAPIVPROC.invoke(address("glGetnMapiv"), target, query, bufSize, v);
  }

  public void glProgramUniform1uiv(int program, int location, int count, MemorySegment value) {
    PFNGLPROGRAMUNIFORM1UIVPROC.invoke(address("glProgramUniform1uiv"), program, location, count, value);
  }

  public void glUniformMatrix3dv(int location, int count, byte transpose, MemorySegment value) {
    PFNGLUNIFORMMATRIX3DVPROC.invoke(address("glUniformMatrix3dv"), location, count, transpose, value);
  }

  public void glUniform1ui64ARB(int location, long x) {
    PFNGLUNIFORM1UI64ARBPROC.invoke(address("glUniform1ui64ARB"), location, x);
  }

  public void glDeleteCommandListsNV(int n, MemorySegment lists) {
    PFNGLDELETECOMMANDLISTSNVPROC.invoke(address("glDeleteCommandListsNV"), n, lists);
  }

  public void glSignalVkFenceNV(long vkFence) {
    PFNGLSIGNALVKFENCENVPROC.invoke(address("glSignalVkFenceNV"), vkFence);
  }

  public void glVertexAttribI1iv(int index, MemorySegment v) {
    PFNGLVERTEXATTRIBI1IVPROC.invoke(address("glVertexAttribI1iv"), index, v);
  }

  public void glCoverStrokePathNV(int path, int coverMode) {
    PFNGLCOVERSTROKEPATHNVPROC.invoke(address("glCoverStrokePathNV"), path, coverMode);
  }

  public void glDisableVertexArrayAttrib(int vaobj, int index) {
    PFNGLDISABLEVERTEXARRAYATTRIBPROC.invoke(address("glDisableVertexArrayAttrib"), vaobj, index);
  }

  public void glNamedFramebufferRenderbuffer(int framebuffer, int attachment, int renderbuffertarget, int renderbuffer) {
    PFNGLNAMEDFRAMEBUFFERRENDERBUFFERPROC.invoke(address("glNamedFramebufferRenderbuffer"), framebuffer, attachment, renderbuffertarget, renderbuffer);
  }

  public void glNamedFramebufferTextureLayerEXT(int framebuffer, int attachment, int texture, int level, int layer) {
    PFNGLNAMEDFRAMEBUFFERTEXTURELAYEREXTPROC.invoke(address("glNamedFramebufferTextureLayerEXT"), framebuffer, attachment, texture, level, layer);
  }

  public void glSecondaryColorP3uiv(int type, MemorySegment color) {
    PFNGLSECONDARYCOLORP3UIVPROC.invoke(address("glSecondaryColorP3uiv"), type, color);
  }

  public void glTexStorage1D(int target, int levels, int internalformat, int width) {
    PFNGLTEXSTORAGE1DPROC.invoke(address("glTexStorage1D"), target, levels, internalformat, width);
  }

  public void glTextureStorageMem3DMultisampleEXT(int texture, int samples, int internalFormat, int width, int height, int depth, byte fixedSampleLocations, int memory, long offset) {
    PFNGLTEXTURESTORAGEMEM3DMULTISAMPLEEXTPROC.invoke(address("glTextureStorageMem3DMultisampleEXT"), texture, samples, internalFormat, width, height, depth, fixedSampleLocations, memory, offset);
  }

  public void glGetProgramNamedParameterfvNV(int id, int len, MemorySegment name, MemorySegment params) {
    PFNGLGETPROGRAMNAMEDPARAMETERFVNVPROC.invoke(address("glGetProgramNamedParameterfvNV"), id, len, name, params);
  }

  public void glCompressedMultiTexSubImage3DEXT(int texunit, int target, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int format, int imageSize, MemorySegment bits) {
    PFNGLCOMPRESSEDMULTITEXSUBIMAGE3DEXTPROC.invoke(address("glCompressedMultiTexSubImage3DEXT"), texunit, target, level, xoffset, yoffset, zoffset, width, height, depth, format, imageSize, bits);
  }

  public void glEndTransformFeedback() {
    PFNGLENDTRANSFORMFEEDBACKPROC.invoke(address("glEndTransformFeedback"));
  }

  public void glVertexAttrib2sNV(int index, short x, short y) {
    PFNGLVERTEXATTRIB2SNVPROC.invoke(address("glVertexAttrib2sNV"), index, x, y);
  }

  public void glTexGenxOES(int coord, int pname, int param) {
    PFNGLTEXGENXOESPROC.invoke(address("glTexGenxOES"), coord, pname, param);
  }

  public void glMultiTexSubImage1DEXT(int texunit, int target, int level, int xoffset, int width, int format, int type, MemorySegment pixels) {
    PFNGLMULTITEXSUBIMAGE1DEXTPROC.invoke(address("glMultiTexSubImage1DEXT"), texunit, target, level, xoffset, width, format, type, pixels);
  }

  public void glUniformMatrix3fv(int location, int count, byte transpose, MemorySegment value) {
    PFNGLUNIFORMMATRIX3FVPROC.invoke(address("glUniformMatrix3fv"), location, count, transpose, value);
  }

  public void glTexStorage2D(int target, int levels, int internalformat, int width, int height) {
    PFNGLTEXSTORAGE2DPROC.invoke(address("glTexStorage2D"), target, levels, internalformat, width, height);
  }

  public void glReplacementCodeuiSUN(int code) {
    PFNGLREPLACEMENTCODEUISUNPROC.invoke(address("glReplacementCodeuiSUN"), code);
  }

  public void glGetUniformIndices(int program, int uniformCount, MemorySegment uniformNames, MemorySegment uniformIndices) {
    PFNGLGETUNIFORMINDICESPROC.invoke(address("glGetUniformIndices"), program, uniformCount, uniformNames, uniformIndices);
  }

  public void glReplacementCodeuiTexCoord2fVertex3fvSUN(MemorySegment rc, MemorySegment tc, MemorySegment v) {
    PFNGLREPLACEMENTCODEUITEXCOORD2FVERTEX3FVSUNPROC.invoke(address("glReplacementCodeuiTexCoord2fVertex3fvSUN"), rc, tc, v);
  }

  public void glBindProgramPipelineEXT(int pipeline) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMapVertexAttrib1fAPPLE(int index, int size, float u1, float u2, int stride, int order, MemorySegment points) {
    PFNGLMAPVERTEXATTRIB1FAPPLEPROC.invoke(address("glMapVertexAttrib1fAPPLE"), index, size, u1, u2, stride, order, points);
  }

  public void glEnableClientStateiEXT(int array, int index) {
    PFNGLENABLECLIENTSTATEIEXTPROC.invoke(address("glEnableClientStateiEXT"), array, index);
  }

  public void glWindowPos3ivARB(MemorySegment v) {
    PFNGLWINDOWPOS3IVARBPROC.invoke(address("glWindowPos3ivARB"), v);
  }

  public void glMultiTexCoord1bvOES(int texture, MemorySegment coords) {
    PFNGLMULTITEXCOORD1BVOESPROC.invoke(address("glMultiTexCoord1bvOES"), texture, coords);
  }

  public void glVertexAttribI2uivEXT(int index, MemorySegment v) {
    PFNGLVERTEXATTRIBI2UIVEXTPROC.invoke(address("glVertexAttribI2uivEXT"), index, v);
  }

  public void glVertexAttribL4d(int index, double x, double y, double z, double w) {
    PFNGLVERTEXATTRIBL4DPROC.invoke(address("glVertexAttribL4d"), index, x, y, z, w);
  }

  public void glTexStorage3D(int target, int levels, int internalformat, int width, int height, int depth) {
    PFNGLTEXSTORAGE3DPROC.invoke(address("glTexStorage3D"), target, levels, internalformat, width, height, depth);
  }

  public void glVDPAUSurfaceAccessNV(long surface, int access) {
    PFNGLVDPAUSURFACEACCESSNVPROC.invoke(address("glVDPAUSurfaceAccessNV"), surface, access);
  }

  public void glGenQueries(int n, MemorySegment ids) {
    PFNGLGENQUERIESPROC.invoke(address("glGenQueries"), n, ids);
  }

  public byte glIsMemoryObjectEXT(int memoryObject) {
    return PFNGLISMEMORYOBJECTEXTPROC.invoke(address("glIsMemoryObjectEXT"), memoryObject);
  }

  public int glGetProgramResourceLocationIndexEXT(int program, int programInterface, MemorySegment name) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttrib3dARB(int index, double x, double y, double z) {
    PFNGLVERTEXATTRIB3DARBPROC.invoke(address("glVertexAttrib3dARB"), index, x, y, z);
  }

  public void glGetActiveSubroutineUniformiv(int program, int shadertype, int index, int pname, MemorySegment values) {
    PFNGLGETACTIVESUBROUTINEUNIFORMIVPROC.invoke(address("glGetActiveSubroutineUniformiv"), program, shadertype, index, pname, values);
  }

  public int glPollAsyncSGIX(MemorySegment markerp) {
    return PFNGLPOLLASYNCSGIXPROC.invoke(address("glPollAsyncSGIX"), markerp);
  }

  public void glEnableVertexArrayEXT(int vaobj, int array) {
    PFNGLENABLEVERTEXARRAYEXTPROC.invoke(address("glEnableVertexArrayEXT"), vaobj, array);
  }

  public void glFlushPixelDataRangeNV(int target) {
    PFNGLFLUSHPIXELDATARANGENVPROC.invoke(address("glFlushPixelDataRangeNV"), target);
  }

  public void glTexCoord4fVertex4fvSUN(MemorySegment tc, MemorySegment v) {
    PFNGLTEXCOORD4FVERTEX4FVSUNPROC.invoke(address("glTexCoord4fVertex4fvSUN"), tc, v);
  }

  public void glFogCoorddvEXT(MemorySegment coord) {
    PFNGLFOGCOORDDVEXTPROC.invoke(address("glFogCoorddvEXT"), coord);
  }

  public void glVertexAttrib4uivARB(int index, MemorySegment v) {
    PFNGLVERTEXATTRIB4UIVARBPROC.invoke(address("glVertexAttrib4uivARB"), index, v);
  }

  public void glGetTranslatedShaderSourceANGLE(int shader, int bufSize, MemorySegment length, MemorySegment source) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetTransformFeedbacki64_v(int xfb, int pname, int index, MemorySegment param) {
    PFNGLGETTRANSFORMFEEDBACKI64_VPROC.invoke(address("glGetTransformFeedbacki64_v"), xfb, pname, index, param);
  }

  public void glMultiDrawElementsBaseVertex(int mode, MemorySegment count, int type, MemorySegment indices, int drawcount, MemorySegment basevertex) {
    PFNGLMULTIDRAWELEMENTSBASEVERTEXPROC.invoke(address("glMultiDrawElementsBaseVertex"), mode, count, type, indices, drawcount, basevertex);
  }

  public void glProgramUniform1ui64ARB(int program, int location, long x) {
    PFNGLPROGRAMUNIFORM1UI64ARBPROC.invoke(address("glProgramUniform1ui64ARB"), program, location, x);
  }

  public void glUniformMatrix3x2fv(int location, int count, byte transpose, MemorySegment value) {
    PFNGLUNIFORMMATRIX3X2FVPROC.invoke(address("glUniformMatrix3x2fv"), location, count, transpose, value);
  }

  public void glBinormal3fEXT(float bx, float by, float bz) {
    PFNGLBINORMAL3FEXTPROC.invoke(address("glBinormal3fEXT"), bx, by, bz);
  }

  public void glFlushMappedNamedBufferRange(int buffer, long offset, long length) {
    PFNGLFLUSHMAPPEDNAMEDBUFFERRANGEPROC.invoke(address("glFlushMappedNamedBufferRange"), buffer, offset, length);
  }

  public void glUseShaderProgramEXT(int type, int program) {
    PFNGLUSESHADERPROGRAMEXTPROC.invoke(address("glUseShaderProgramEXT"), type, program);
  }

  public void glLightxv(int light, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexCoordP4ui(int type, int coords) {
    PFNGLTEXCOORDP4UIPROC.invoke(address("glTexCoordP4ui"), type, coords);
  }

  public void glNamedFramebufferRenderbufferEXT(int framebuffer, int attachment, int renderbuffertarget, int renderbuffer) {
    PFNGLNAMEDFRAMEBUFFERRENDERBUFFEREXTPROC.invoke(address("glNamedFramebufferRenderbufferEXT"), framebuffer, attachment, renderbuffertarget, renderbuffer);
  }

  public void glVertexAttribI1iEXT(int index, int x) {
    PFNGLVERTEXATTRIBI1IEXTPROC.invoke(address("glVertexAttribI1iEXT"), index, x);
  }

  public void glGetActiveUniformBlockiv(int program, int uniformBlockIndex, int pname, MemorySegment params) {
    PFNGLGETACTIVEUNIFORMBLOCKIVPROC.invoke(address("glGetActiveUniformBlockiv"), program, uniformBlockIndex, pname, params);
  }

  public short glGetStageIndexNV(int shadertype) {
    return PFNGLGETSTAGEINDEXNVPROC.invoke(address("glGetStageIndexNV"), shadertype);
  }

  public void glProgramUniformMatrix2fv(int program, int location, int count, byte transpose, MemorySegment value) {
    PFNGLPROGRAMUNIFORMMATRIX2FVPROC.invoke(address("glProgramUniformMatrix2fv"), program, location, count, transpose, value);
  }

  public void glSecondaryColor3uiEXT(int red, int green, int blue) {
    PFNGLSECONDARYCOLOR3UIEXTPROC.invoke(address("glSecondaryColor3uiEXT"), red, green, blue);
  }

  public void glUniform1iARB(int location, int v0) {
    PFNGLUNIFORM1IARBPROC.invoke(address("glUniform1iARB"), location, v0);
  }

  public void glCompileShaderIncludeARB(int shader, int count, MemorySegment path, MemorySegment length) {
    PFNGLCOMPILESHADERINCLUDEARBPROC.invoke(address("glCompileShaderIncludeARB"), shader, count, path, length);
  }

  public void glFramebufferTexture1DEXT(int target, int attachment, int textarget, int texture, int level) {
    PFNGLFRAMEBUFFERTEXTURE1DEXTPROC.invoke(address("glFramebufferTexture1DEXT"), target, attachment, textarget, texture, level);
  }

  public void glGetPerfQueryInfoINTEL(int queryId, int queryNameLength, MemorySegment queryName, MemorySegment dataSize, MemorySegment noCounters, MemorySegment noInstances, MemorySegment capsMask) {
    PFNGLGETPERFQUERYINFOINTELPROC.invoke(address("glGetPerfQueryInfoINTEL"), queryId, queryNameLength, queryName, dataSize, noCounters, noInstances, capsMask);
  }

  public void glUseProgramStagesEXT(int pipeline, int stages, int program) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexStorageSparseAMD(int target, int internalFormat, int width, int height, int depth, int layers, int flags) {
    PFNGLTEXSTORAGESPARSEAMDPROC.invoke(address("glTexStorageSparseAMD"), target, internalFormat, width, height, depth, layers, flags);
  }

  public void glDrawArraysInstancedNV(int mode, int first, int count, int primcount) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glColor4xvOES(MemorySegment components) {
    PFNGLCOLOR4XVOESPROC.invoke(address("glColor4xvOES"), components);
  }

  public void glUniform2i64ARB(int location, long x, long y) {
    PFNGLUNIFORM2I64ARBPROC.invoke(address("glUniform2i64ARB"), location, x, y);
  }

  public void glVertexAttrib4Nbv(int index, MemorySegment v) {
    PFNGLVERTEXATTRIB4NBVPROC.invoke(address("glVertexAttrib4Nbv"), index, v);
  }

  public void glGetInteger64vAPPLE(int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDeleteMemoryObjectsEXT(int n, MemorySegment memoryObjects) {
    PFNGLDELETEMEMORYOBJECTSEXTPROC.invoke(address("glDeleteMemoryObjectsEXT"), n, memoryObjects);
  }

  public void glMultiTexParameterivEXT(int texunit, int target, int pname, MemorySegment params) {
    PFNGLMULTITEXPARAMETERIVEXTPROC.invoke(address("glMultiTexParameterivEXT"), texunit, target, pname, params);
  }

  public void glVertexAttribI3uiEXT(int index, int x, int y, int z) {
    PFNGLVERTEXATTRIBI3UIEXTPROC.invoke(address("glVertexAttribI3uiEXT"), index, x, y, z);
  }

  public void glBinormal3fvEXT(MemorySegment v) {
    PFNGLBINORMAL3FVEXTPROC.invoke(address("glBinormal3fvEXT"), v);
  }

  public void glProgramUniformMatrix2x3dvEXT(int program, int location, int count, byte transpose, MemorySegment value) {
    PFNGLPROGRAMUNIFORMMATRIX2X3DVEXTPROC.invoke(address("glProgramUniformMatrix2x3dvEXT"), program, location, count, transpose, value);
  }

  public void glLoadMatrixx(MemorySegment m) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribL2dv(int index, MemorySegment v) {
    PFNGLVERTEXATTRIBL2DVPROC.invoke(address("glVertexAttribL2dv"), index, v);
  }

  public void glGetCombinerOutputParameterfvNV(int stage, int portion, int pname, MemorySegment params) {
    PFNGLGETCOMBINEROUTPUTPARAMETERFVNVPROC.invoke(address("glGetCombinerOutputParameterfvNV"), stage, portion, pname, params);
  }

  public void glStencilOpSeparateATI(int face, int sfail, int dpfail, int dppass) {
    PFNGLSTENCILOPSEPARATEATIPROC.invoke(address("glStencilOpSeparateATI"), face, sfail, dpfail, dppass);
  }

  public void glMinSampleShading(float value) {
    PFNGLMINSAMPLESHADINGPROC.invoke(address("glMinSampleShading"), value);
  }

  public void glProgramUniformMatrix2dv(int program, int location, int count, byte transpose, MemorySegment value) {
    PFNGLPROGRAMUNIFORMMATRIX2DVPROC.invoke(address("glProgramUniformMatrix2dv"), program, location, count, transpose, value);
  }

  public void glNamedCopyBufferSubDataEXT(int readBuffer, int writeBuffer, long readOffset, long writeOffset, long size) {
    PFNGLNAMEDCOPYBUFFERSUBDATAEXTPROC.invoke(address("glNamedCopyBufferSubDataEXT"), readBuffer, writeBuffer, readOffset, writeOffset, size);
  }

  public void glValidateProgram(int program) {
    PFNGLVALIDATEPROGRAMPROC.invoke(address("glValidateProgram"), program);
  }

  public void glVertexStream3sATI(int stream, short x, short y, short z) {
    PFNGLVERTEXSTREAM3SATIPROC.invoke(address("glVertexStream3sATI"), stream, x, y, z);
  }

  public void glTextureStorageMem3DEXT(int texture, int levels, int internalFormat, int width, int height, int depth, int memory, long offset) {
    PFNGLTEXTURESTORAGEMEM3DEXTPROC.invoke(address("glTextureStorageMem3DEXT"), texture, levels, internalFormat, width, height, depth, memory, offset);
  }

  public void glProgramUniformMatrix3x4dvEXT(int program, int location, int count, byte transpose, MemorySegment value) {
    PFNGLPROGRAMUNIFORMMATRIX3X4DVEXTPROC.invoke(address("glProgramUniformMatrix3x4dvEXT"), program, location, count, transpose, value);
  }

  public void glDeleteVertexArraysOES(int n, MemorySegment arrays) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDeleteVertexShaderEXT(int id) {
    PFNGLDELETEVERTEXSHADEREXTPROC.invoke(address("glDeleteVertexShaderEXT"), id);
  }

  public void glNamedFramebufferTextureLayer(int framebuffer, int attachment, int texture, int level, int layer) {
    PFNGLNAMEDFRAMEBUFFERTEXTURELAYERPROC.invoke(address("glNamedFramebufferTextureLayer"), framebuffer, attachment, texture, level, layer);
  }

  public void glGetTexFilterFuncSGIS(int target, int filter, MemorySegment weights) {
    PFNGLGETTEXFILTERFUNCSGISPROC.invoke(address("glGetTexFilterFuncSGIS"), target, filter, weights);
  }

  public void glProgramLocalParameter4fvARB(int target, int index, MemorySegment params) {
    PFNGLPROGRAMLOCALPARAMETER4FVARBPROC.invoke(address("glProgramLocalParameter4fvARB"), target, index, params);
  }

  public void glGetLocalConstantBooleanvEXT(int id, int value, MemorySegment data) {
    PFNGLGETLOCALCONSTANTBOOLEANVEXTPROC.invoke(address("glGetLocalConstantBooleanvEXT"), id, value, data);
  }

  public byte glTestObjectAPPLE(int object, int name) {
    return PFNGLTESTOBJECTAPPLEPROC.invoke(address("glTestObjectAPPLE"), object, name);
  }

  public void glCopyTexImage2DEXT(int target, int level, int internalformat, int x, int y, int width, int height, int border) {
    PFNGLCOPYTEXIMAGE2DEXTPROC.invoke(address("glCopyTexImage2DEXT"), target, level, internalformat, x, y, width, height, border);
  }

  public void glVertexStream2fATI(int stream, float x, float y) {
    PFNGLVERTEXSTREAM2FATIPROC.invoke(address("glVertexStream2fATI"), stream, x, y);
  }

  public void glProgramUniform3i64vNV(int program, int location, int count, MemorySegment value) {
    PFNGLPROGRAMUNIFORM3I64VNVPROC.invoke(address("glProgramUniform3i64vNV"), program, location, count, value);
  }

  public void glResizeBuffersMESA() {
    PFNGLRESIZEBUFFERSMESAPROC.invoke(address("glResizeBuffersMESA"));
  }

  public void glDrawElementsInstancedBaseVertexBaseInstanceEXT(int mode, int count, int type, MemorySegment indices, int instancecount, int basevertex, int baseinstance) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetArrayObjectfvATI(int array, int pname, MemorySegment params) {
    PFNGLGETARRAYOBJECTFVATIPROC.invoke(address("glGetArrayObjectfvATI"), array, pname, params);
  }

  public void glMultiDrawElementsIndirectEXT(int mode, int type, MemorySegment indirect, int drawcount, int stride) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramParameters4fvNV(int target, int index, int count, MemorySegment v) {
    PFNGLPROGRAMPARAMETERS4FVNVPROC.invoke(address("glProgramParameters4fvNV"), target, index, count, v);
  }

  public void glUniformHandleui64NV(int location, long value) {
    PFNGLUNIFORMHANDLEUI64NVPROC.invoke(address("glUniformHandleui64NV"), location, value);
  }

  public void glVertexAttrib4Nusv(int index, MemorySegment v) {
    PFNGLVERTEXATTRIB4NUSVPROC.invoke(address("glVertexAttrib4Nusv"), index, v);
  }

  public void glVertexStream1dATI(int stream, double x) {
    PFNGLVERTEXSTREAM1DATIPROC.invoke(address("glVertexStream1dATI"), stream, x);
  }

  public void glProgramParameteri(int program, int pname, int value) {
    PFNGLPROGRAMPARAMETERIPROC.invoke(address("glProgramParameteri"), program, pname, value);
  }

  public void glBindFramebufferEXT(int target, int framebuffer) {
    PFNGLBINDFRAMEBUFFEREXTPROC.invoke(address("glBindFramebufferEXT"), target, framebuffer);
  }

  public void glUniform1ui(int location, int v0) {
    PFNGLUNIFORM1UIPROC.invoke(address("glUniform1ui"), location, v0);
  }

  public void glGetTexParameterIivOES(int target, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexCoordP3uiv(int texture, int type, MemorySegment coords) {
    PFNGLMULTITEXCOORDP3UIVPROC.invoke(address("glMultiTexCoordP3uiv"), texture, type, coords);
  }

  public void glClearBufferuiv(int buffer, int drawbuffer, MemorySegment value) {
    PFNGLCLEARBUFFERUIVPROC.invoke(address("glClearBufferuiv"), buffer, drawbuffer, value);
  }

  public void glDeleteQueryResourceTagNV(int n, MemorySegment tagIds) {
    PFNGLDELETEQUERYRESOURCETAGNVPROC.invoke(address("glDeleteQueryResourceTagNV"), n, tagIds);
  }

  public void glGetBufferPointervARB(int target, int pname, MemorySegment params) {
    PFNGLGETBUFFERPOINTERVARBPROC.invoke(address("glGetBufferPointervARB"), target, pname, params);
  }

  public void glSampleMaskSGIS(float value, byte invert) {
    PFNGLSAMPLEMASKSGISPROC.invoke(address("glSampleMaskSGIS"), value, invert);
  }

  public void glTexEnvxOES(int target, int pname, int param) {
    PFNGLTEXENVXOESPROC.invoke(address("glTexEnvxOES"), target, pname, param);
  }

  public void glDebugMessageInsertARB(int source, int type, int id, int severity, int length, MemorySegment buf) {
    PFNGLDEBUGMESSAGEINSERTARBPROC.invoke(address("glDebugMessageInsertARB"), source, type, id, severity, length, buf);
  }

  public void glGetTexBumpParameterivATI(int pname, MemorySegment param) {
    PFNGLGETTEXBUMPPARAMETERIVATIPROC.invoke(address("glGetTexBumpParameterivATI"), pname, param);
  }

  public void glDepthRangeArrayfvOES(int first, int count, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFragmentColorMaterialSGIX(int face, int mode) {
    PFNGLFRAGMENTCOLORMATERIALSGIXPROC.invoke(address("glFragmentColorMaterialSGIX"), face, mode);
  }

  public void glGetDetailTexFuncSGIS(int target, MemorySegment points) {
    PFNGLGETDETAILTEXFUNCSGISPROC.invoke(address("glGetDetailTexFuncSGIS"), target, points);
  }

  public void glQueryCounterEXT(int id, int target) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMulticastCopyBufferSubDataNV(int readGpu, int writeGpuMask, int readBuffer, int writeBuffer, long readOffset, long writeOffset, long size) {
    PFNGLMULTICASTCOPYBUFFERSUBDATANVPROC.invoke(address("glMulticastCopyBufferSubDataNV"), readGpu, writeGpuMask, readBuffer, writeBuffer, readOffset, writeOffset, size);
  }

  public void glGetPointervEXT(int pname, MemorySegment params) {
    PFNGLGETPOINTERVEXTPROC.invoke(address("glGetPointervEXT"), pname, params);
  }

  public void glTexParameterx(int target, int pname, int param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttrib4Niv(int index, MemorySegment v) {
    PFNGLVERTEXATTRIB4NIVPROC.invoke(address("glVertexAttrib4Niv"), index, v);
  }

  public void glVideoCaptureStreamParameterdvNV(int video_capture_slot, int stream, int pname, MemorySegment params) {
    PFNGLVIDEOCAPTURESTREAMPARAMETERDVNVPROC.invoke(address("glVideoCaptureStreamParameterdvNV"), video_capture_slot, stream, pname, params);
  }

  public void glGetSharpenTexFuncSGIS(int target, MemorySegment points) {
    PFNGLGETSHARPENTEXFUNCSGISPROC.invoke(address("glGetSharpenTexFuncSGIS"), target, points);
  }

  public void glTextureViewOES(int texture, int target, int origtexture, int internalformat, int minlevel, int numlevels, int minlayer, int numlayers) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetPathDashArrayNV(int path, MemorySegment dashArray) {
    PFNGLGETPATHDASHARRAYNVPROC.invoke(address("glGetPathDashArrayNV"), path, dashArray);
  }

  public void glPixelTransformParameterivEXT(int target, int pname, MemorySegment params) {
    PFNGLPIXELTRANSFORMPARAMETERIVEXTPROC.invoke(address("glPixelTransformParameterivEXT"), target, pname, params);
  }

  public void glGetBufferPointerv(int target, int pname, MemorySegment params) {
    PFNGLGETBUFFERPOINTERVPROC.invoke(address("glGetBufferPointerv"), target, pname, params);
  }

  public void glProgramLocalParameter4dARB(int target, int index, double x, double y, double z, double w) {
    PFNGLPROGRAMLOCALPARAMETER4DARBPROC.invoke(address("glProgramLocalParameter4dARB"), target, index, x, y, z, w);
  }

  public void glSignalSemaphoreEXT(int semaphore, int numBufferBarriers, MemorySegment buffers, int numTextureBarriers, MemorySegment textures, MemorySegment dstLayouts) {
    PFNGLSIGNALSEMAPHOREEXTPROC.invoke(address("glSignalSemaphoreEXT"), semaphore, numBufferBarriers, buffers, numTextureBarriers, textures, dstLayouts);
  }

  public void glGetTexGenivOES(int coord, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTextureParameterfvEXT(int texture, int target, int pname, MemorySegment params) {
    PFNGLTEXTUREPARAMETERFVEXTPROC.invoke(address("glTextureParameterfvEXT"), texture, target, pname, params);
  }

  public void glLightx(int light, int pname, int param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribL1dEXT(int index, double x) {
    PFNGLVERTEXATTRIBL1DEXTPROC.invoke(address("glVertexAttribL1dEXT"), index, x);
  }

  public void glDrawTexxOES(int x, int y, int z, int width, int height) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glPresentFrameDualFillNV(int video_slot, long minPresentTime, int beginPresentTimeId, int presentDurationId, int type, int target0, int fill0, int target1, int fill1, int target2, int fill2, int target3, int fill3) {
    PFNGLPRESENTFRAMEDUALFILLNVPROC.invoke(address("glPresentFrameDualFillNV"), video_slot, minPresentTime, beginPresentTimeId, presentDurationId, type, target0, fill0, target1, fill1, target2, fill2, target3, fill3);
  }

  public void glGetMinmaxParameterivEXT(int target, int pname, MemorySegment params) {
    PFNGLGETMINMAXPARAMETERIVEXTPROC.invoke(address("glGetMinmaxParameterivEXT"), target, pname, params);
  }

  public void glLGPUInterlockNVX() {
    PFNGLLGPUINTERLOCKNVXPROC.invoke(address("glLGPUInterlockNVX"));
  }

  public void glBindBufferRange(int target, int index, int buffer, long offset, long size) {
    PFNGLBINDBUFFERRANGEPROC.invoke(address("glBindBufferRange"), target, index, buffer, offset, size);
  }

  public void glCombinerParameterfvNV(int pname, MemorySegment params) {
    PFNGLCOMBINERPARAMETERFVNVPROC.invoke(address("glCombinerParameterfvNV"), pname, params);
  }

  public void glMultMatrixx(MemorySegment m) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glPathSubCoordsNV(int path, int coordStart, int numCoords, int coordType, MemorySegment coords) {
    PFNGLPATHSUBCOORDSNVPROC.invoke(address("glPathSubCoordsNV"), path, coordStart, numCoords, coordType, coords);
  }

  public void glVertexStream3fvATI(int stream, MemorySegment coords) {
    PFNGLVERTEXSTREAM3FVATIPROC.invoke(address("glVertexStream3fvATI"), stream, coords);
  }

  public void glReferencePlaneSGIX(MemorySegment equation) {
    PFNGLREFERENCEPLANESGIXPROC.invoke(address("glReferencePlaneSGIX"), equation);
  }

  public void glWindowPos4iMESA(int x, int y, int z, int w) {
    PFNGLWINDOWPOS4IMESAPROC.invoke(address("glWindowPos4iMESA"), x, y, z, w);
  }

  public void glGetPixelTransformParameterivEXT(int target, int pname, MemorySegment params) {
    PFNGLGETPIXELTRANSFORMPARAMETERIVEXTPROC.invoke(address("glGetPixelTransformParameterivEXT"), target, pname, params);
  }

  public void glQueryObjectParameteruiAMD(int target, int id, int pname, int param) {
    PFNGLQUERYOBJECTPARAMETERUIAMDPROC.invoke(address("glQueryObjectParameteruiAMD"), target, id, pname, param);
  }

  public void glBlendEquationiEXT(int buf, int mode) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDebugMessageControlKHR(int source, int type, int severity, int count, MemorySegment ids, byte enabled) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glWindowPos3iARB(int x, int y, int z) {
    PFNGLWINDOWPOS3IARBPROC.invoke(address("glWindowPos3iARB"), x, y, z);
  }

  public void glBindShadingRateImageNV(int texture) {
    PFNGLBINDSHADINGRATEIMAGENVPROC.invoke(address("glBindShadingRateImageNV"), texture);
  }

  public void glVertexArrayVertexAttribIFormatEXT(int vaobj, int attribindex, int size, int type, int relativeoffset) {
    PFNGLVERTEXARRAYVERTEXATTRIBIFORMATEXTPROC.invoke(address("glVertexArrayVertexAttribIFormatEXT"), vaobj, attribindex, size, type, relativeoffset);
  }

  public void glTextureImage3DMultisampleCoverageNV(int texture, int target, int coverageSamples, int colorSamples, int internalFormat, int width, int height, int depth, byte fixedSampleLocations) {
    PFNGLTEXTUREIMAGE3DMULTISAMPLECOVERAGENVPROC.invoke(address("glTextureImage3DMultisampleCoverageNV"), texture, target, coverageSamples, colorSamples, internalFormat, width, height, depth, fixedSampleLocations);
  }

  public void glProgramUniform2ui64vARB(int program, int location, int count, MemorySegment value) {
    PFNGLPROGRAMUNIFORM2UI64VARBPROC.invoke(address("glProgramUniform2ui64vARB"), program, location, count, value);
  }

  public void glGetBufferParameteri64v(int target, int pname, MemorySegment params) {
    PFNGLGETBUFFERPARAMETERI64VPROC.invoke(address("glGetBufferParameteri64v"), target, pname, params);
  }

  public void glRasterPos4xOES(int x, int y, int z, int w) {
    PFNGLRASTERPOS4XOESPROC.invoke(address("glRasterPos4xOES"), x, y, z, w);
  }

  public void glTextureColorMaskSGIS(byte red, byte green, byte blue, byte alpha) {
    PFNGLTEXTURECOLORMASKSGISPROC.invoke(address("glTextureColorMaskSGIS"), red, green, blue, alpha);
  }

  public void glGetListParameterivSGIX(int list, int pname, MemorySegment params) {
    PFNGLGETLISTPARAMETERIVSGIXPROC.invoke(address("glGetListParameterivSGIX"), list, pname, params);
  }

  public void glVertexArrayColorOffsetEXT(int vaobj, int buffer, int size, int type, int stride, long offset) {
    PFNGLVERTEXARRAYCOLOROFFSETEXTPROC.invoke(address("glVertexArrayColorOffsetEXT"), vaobj, buffer, size, type, stride, offset);
  }

  public void glBlendFuncSeparateEXT(int sfactorRGB, int dfactorRGB, int sfactorAlpha, int dfactorAlpha) {
    PFNGLBLENDFUNCSEPARATEEXTPROC.invoke(address("glBlendFuncSeparateEXT"), sfactorRGB, dfactorRGB, sfactorAlpha, dfactorAlpha);
  }

  public void glDebugMessageInsertAMD(int category, int severity, int id, int length, MemorySegment buf) {
    PFNGLDEBUGMESSAGEINSERTAMDPROC.invoke(address("glDebugMessageInsertAMD"), category, severity, id, length, buf);
  }

  public void glBeginConditionalRenderNV(int id, int mode) {
    PFNGLBEGINCONDITIONALRENDERNVPROC.invoke(address("glBeginConditionalRenderNV"), id, mode);
  }

  public void glMultiDrawArraysIndirectCount(int mode, MemorySegment indirect, long drawcount, int maxdrawcount, int stride) {
    PFNGLMULTIDRAWARRAYSINDIRECTCOUNTPROC.invoke(address("glMultiDrawArraysIndirectCount"), mode, indirect, drawcount, maxdrawcount, stride);
  }

  public void glDeleteRenderbuffers(int n, MemorySegment renderbuffers) {
    PFNGLDELETERENDERBUFFERSPROC.invoke(address("glDeleteRenderbuffers"), n, renderbuffers);
  }

  public void glProgramUniform3i64vARB(int program, int location, int count, MemorySegment value) {
    PFNGLPROGRAMUNIFORM3I64VARBPROC.invoke(address("glProgramUniform3i64vARB"), program, location, count, value);
  }

  public void glVertexAttribI1ui(int index, int x) {
    PFNGLVERTEXATTRIBI1UIPROC.invoke(address("glVertexAttribI1ui"), index, x);
  }

  public void glDisableVariantClientStateEXT(int id) {
    PFNGLDISABLEVARIANTCLIENTSTATEEXTPROC.invoke(address("glDisableVariantClientStateEXT"), id);
  }

  public void glColor4xOES(int red, int green, int blue, int alpha) {
    PFNGLCOLOR4XOESPROC.invoke(address("glColor4xOES"), red, green, blue, alpha);
  }

  public void glStencilOpValueAMD(int face, int value) {
    PFNGLSTENCILOPVALUEAMDPROC.invoke(address("glStencilOpValueAMD"), face, value);
  }

  public void glGenRenderbuffersOES(int n, MemorySegment renderbuffers) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttrib4Nuiv(int index, MemorySegment v) {
    PFNGLVERTEXATTRIB4NUIVPROC.invoke(address("glVertexAttrib4Nuiv"), index, v);
  }

  public void glNamedBufferPageCommitmentARB(int buffer, long offset, long size, byte commit) {
    PFNGLNAMEDBUFFERPAGECOMMITMENTARBPROC.invoke(address("glNamedBufferPageCommitmentARB"), buffer, offset, size, commit);
  }

  public void glMultiTexGeniEXT(int texunit, int coord, int pname, int param) {
    PFNGLMULTITEXGENIEXTPROC.invoke(address("glMultiTexGeniEXT"), texunit, coord, pname, param);
  }

  public void glGetnUniformivEXT(int program, int location, int bufSize, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertex4xvOES(MemorySegment coords) {
    PFNGLVERTEX4XVOESPROC.invoke(address("glVertex4xvOES"), coords);
  }

  public void glDeleteFramebuffersOES(int n, MemorySegment framebuffers) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniform4uiv(int program, int location, int count, MemorySegment value) {
    PFNGLPROGRAMUNIFORM4UIVPROC.invoke(address("glProgramUniform4uiv"), program, location, count, value);
  }

  public void glTexBufferOES(int target, int internalformat, int buffer) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glSpecializeShaderARB(int shader, MemorySegment pEntryPoint, int numSpecializationConstants, MemorySegment pConstantIndex, MemorySegment pConstantValue) {
    PFNGLSPECIALIZESHADERARBPROC.invoke(address("glSpecializeShaderARB"), shader, pEntryPoint, numSpecializationConstants, pConstantIndex, pConstantValue);
  }

  public void glEvalMapsNV(int target, int mode) {
    PFNGLEVALMAPSNVPROC.invoke(address("glEvalMapsNV"), target, mode);
  }

  public void glMulticastBufferSubDataNV(int gpuMask, int buffer, long offset, long size, MemorySegment data) {
    PFNGLMULTICASTBUFFERSUBDATANVPROC.invoke(address("glMulticastBufferSubDataNV"), gpuMask, buffer, offset, size, data);
  }

  public void glMatrixScalefEXT(int mode, float x, float y, float z) {
    PFNGLMATRIXSCALEFEXTPROC.invoke(address("glMatrixScalefEXT"), mode, x, y, z);
  }

  public void glGetProgramStageiv(int program, int shadertype, int pname, MemorySegment values) {
    PFNGLGETPROGRAMSTAGEIVPROC.invoke(address("glGetProgramStageiv"), program, shadertype, pname, values);
  }

  public void glGetnCompressedTexImageARB(int target, int lod, int bufSize, MemorySegment img) {
    PFNGLGETNCOMPRESSEDTEXIMAGEARBPROC.invoke(address("glGetnCompressedTexImageARB"), target, lod, bufSize, img);
  }

  public void glLGPUNamedBufferSubDataNVX(int gpuMask, int buffer, long offset, long size, MemorySegment data) {
    PFNGLLGPUNAMEDBUFFERSUBDATANVXPROC.invoke(address("glLGPUNamedBufferSubDataNVX"), gpuMask, buffer, offset, size, data);
  }

  public void glProgramUniform1uivEXT(int program, int location, int count, MemorySegment value) {
    PFNGLPROGRAMUNIFORM1UIVEXTPROC.invoke(address("glProgramUniform1uivEXT"), program, location, count, value);
  }

  public void glGetLocalConstantIntegervEXT(int id, int value, MemorySegment data) {
    PFNGLGETLOCALCONSTANTINTEGERVEXTPROC.invoke(address("glGetLocalConstantIntegervEXT"), id, value, data);
  }

  public void glTextureSubImage3D(int texture, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int format, int type, MemorySegment pixels) {
    PFNGLTEXTURESUBIMAGE3DPROC.invoke(address("glTextureSubImage3D"), texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels);
  }

  public void glVertexAttribI3uiv(int index, MemorySegment v) {
    PFNGLVERTEXATTRIBI3UIVPROC.invoke(address("glVertexAttribI3uiv"), index, v);
  }

  public void glClearTexImage(int texture, int level, int format, int type, MemorySegment data) {
    PFNGLCLEARTEXIMAGEPROC.invoke(address("glClearTexImage"), texture, level, format, type, data);
  }

  public void glTangent3fEXT(float tx, float ty, float tz) {
    PFNGLTANGENT3FEXTPROC.invoke(address("glTangent3fEXT"), tx, ty, tz);
  }

  public void glVertexAttrib1sv(int index, MemorySegment v) {
    PFNGLVERTEXATTRIB1SVPROC.invoke(address("glVertexAttrib1sv"), index, v);
  }

  public void glExtGetBuffersQCOM(MemorySegment buffers, int maxBuffers, MemorySegment numBuffers) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetMultiTexParameterivEXT(int texunit, int target, int pname, MemorySegment params) {
    PFNGLGETMULTITEXPARAMETERIVEXTPROC.invoke(address("glGetMultiTexParameterivEXT"), texunit, target, pname, params);
  }

  public void glMaterialxOES(int face, int pname, int param) {
    PFNGLMATERIALXOESPROC.invoke(address("glMaterialxOES"), face, pname, param);
  }

  public void glMaxShaderCompilerThreadsKHR(int count) {
    PFNGLMAXSHADERCOMPILERTHREADSKHRPROC.invoke(address("glMaxShaderCompilerThreadsKHR"), count);
  }

  public void glVertex2hvNV(MemorySegment v) {
    PFNGLVERTEX2HVNVPROC.invoke(address("glVertex2hvNV"), v);
  }

  public void glDrawTexivOES(MemorySegment coords) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGenFencesNV(int n, MemorySegment fences) {
    PFNGLGENFENCESNVPROC.invoke(address("glGenFencesNV"), n, fences);
  }

  public void glMulticastScissorArrayvNVX(int gpu, int first, int count, MemorySegment v) {
    PFNGLMULTICASTSCISSORARRAYVNVXPROC.invoke(address("glMulticastScissorArrayvNVX"), gpu, first, count, v);
  }

  public void glViewportArrayvOES(int first, int count, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTextureSubImage2D(int texture, int level, int xoffset, int yoffset, int width, int height, int format, int type, MemorySegment pixels) {
    PFNGLTEXTURESUBIMAGE2DPROC.invoke(address("glTextureSubImage2D"), texture, level, xoffset, yoffset, width, height, format, type, pixels);
  }

  public void glVertexAttrib1hNV(int index, short x) {
    PFNGLVERTEXATTRIB1HNVPROC.invoke(address("glVertexAttrib1hNV"), index, x);
  }

  public void glDebugMessageControl(int source, int type, int severity, int count, MemorySegment ids, byte enabled) {
    PFNGLDEBUGMESSAGECONTROLPROC.invoke(address("glDebugMessageControl"), source, type, severity, count, ids, enabled);
  }

  public void glUniform3i64vARB(int location, int count, MemorySegment value) {
    PFNGLUNIFORM3I64VARBPROC.invoke(address("glUniform3i64vARB"), location, count, value);
  }

  public void glFlushMappedNamedBufferRangeEXT(int buffer, long offset, long length) {
    PFNGLFLUSHMAPPEDNAMEDBUFFERRANGEEXTPROC.invoke(address("glFlushMappedNamedBufferRangeEXT"), buffer, offset, length);
  }

  public void glArrayObjectATI(int array, int size, int type, int stride, int buffer, int offset) {
    PFNGLARRAYOBJECTATIPROC.invoke(address("glArrayObjectATI"), array, size, type, stride, buffer, offset);
  }

  public void glGetActiveUniformBlockName(int program, int uniformBlockIndex, int bufSize, MemorySegment length, MemorySegment uniformBlockName) {
    PFNGLGETACTIVEUNIFORMBLOCKNAMEPROC.invoke(address("glGetActiveUniformBlockName"), program, uniformBlockIndex, bufSize, length, uniformBlockName);
  }

  public void glRenderbufferStorageMultisampleAPPLE(int target, int samples, int internalformat, int width, int height) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public byte glIsProgramARB(int program) {
    return PFNGLISPROGRAMARBPROC.invoke(address("glIsProgramARB"), program);
  }

  public void glBlitFramebufferEXT(int srcX0, int srcY0, int srcX1, int srcY1, int dstX0, int dstY0, int dstX1, int dstY1, int mask, int filter) {
    PFNGLBLITFRAMEBUFFEREXTPROC.invoke(address("glBlitFramebufferEXT"), srcX0, srcY0, srcX1, srcY1, dstX0, dstY0, dstX1, dstY1, mask, filter);
  }

  public int glAsyncCopyBufferSubDataNVX(int waitSemaphoreCount, MemorySegment waitSemaphoreArray, MemorySegment fenceValueArray, int readGpu, int writeGpuMask, int readBuffer, int writeBuffer, long readOffset, long writeOffset, long size, int signalSemaphoreCount, MemorySegment signalSemaphoreArray, MemorySegment signalValueArray) {
    return PFNGLASYNCCOPYBUFFERSUBDATANVXPROC.invoke(address("glAsyncCopyBufferSubDataNVX"), waitSemaphoreCount, waitSemaphoreArray, fenceValueArray, readGpu, writeGpuMask, readBuffer, writeBuffer, readOffset, writeOffset, size, signalSemaphoreCount, signalSemaphoreArray, signalValueArray);
  }

  public void glProgramEnvParameterI4iNV(int target, int index, int x, int y, int z, int w) {
    PFNGLPROGRAMENVPARAMETERI4INVPROC.invoke(address("glProgramEnvParameterI4iNV"), target, index, x, y, z, w);
  }

  public void glTexSubImage4DSGIS(int target, int level, int xoffset, int yoffset, int zoffset, int woffset, int width, int height, int depth, int size4d, int format, int type, MemorySegment pixels) {
    PFNGLTEXSUBIMAGE4DSGISPROC.invoke(address("glTexSubImage4DSGIS"), target, level, xoffset, yoffset, zoffset, woffset, width, height, depth, size4d, format, type, pixels);
  }

  public void glGetProgramivNV(int id, int pname, MemorySegment params) {
    PFNGLGETPROGRAMIVNVPROC.invoke(address("glGetProgramivNV"), id, pname, params);
  }

  public void glInvalidateTexSubImage(int texture, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth) {
    PFNGLINVALIDATETEXSUBIMAGEPROC.invoke(address("glInvalidateTexSubImage"), texture, level, xoffset, yoffset, zoffset, width, height, depth);
  }

  public void glVertexAttrib4dvNV(int index, MemorySegment v) {
    PFNGLVERTEXATTRIB4DVNVPROC.invoke(address("glVertexAttrib4dvNV"), index, v);
  }

  public void glEndTransformFeedbackEXT() {
    PFNGLENDTRANSFORMFEEDBACKEXTPROC.invoke(address("glEndTransformFeedbackEXT"));
  }

  public void glTextureSubImage1D(int texture, int level, int xoffset, int width, int format, int type, MemorySegment pixels) {
    PFNGLTEXTURESUBIMAGE1DPROC.invoke(address("glTextureSubImage1D"), texture, level, xoffset, width, format, type, pixels);
  }

  public void glGetMultiTexGenfvEXT(int texunit, int coord, int pname, MemorySegment params) {
    PFNGLGETMULTITEXGENFVEXTPROC.invoke(address("glGetMultiTexGenfvEXT"), texunit, coord, pname, params);
  }

  public void glCompressedTexImage2DARB(int target, int level, int internalformat, int width, int height, int border, int imageSize, MemorySegment data) {
    PFNGLCOMPRESSEDTEXIMAGE2DARBPROC.invoke(address("glCompressedTexImage2DARB"), target, level, internalformat, width, height, border, imageSize, data);
  }

  public void glPathStringNV(int path, int format, int length, MemorySegment pathString) {
    PFNGLPATHSTRINGNVPROC.invoke(address("glPathStringNV"), path, format, length, pathString);
  }

  public void glGetMapControlPointsNV(int target, int index, int type, int ustride, int vstride, byte packed, MemorySegment points) {
    PFNGLGETMAPCONTROLPOINTSNVPROC.invoke(address("glGetMapControlPointsNV"), target, index, type, ustride, vstride, packed, points);
  }

  public void glDeformationMap3dSGIX(int target, double u1, double u2, int ustride, int uorder, double v1, double v2, int vstride, int vorder, double w1, double w2, int wstride, int worder, MemorySegment points) {
    PFNGLDEFORMATIONMAP3DSGIXPROC.invoke(address("glDeformationMap3dSGIX"), target, u1, u2, ustride, uorder, v1, v2, vstride, vorder, w1, w2, wstride, worder, points);
  }

  public void glGetPointerIndexedvEXT(int target, int index, MemorySegment data) {
    PFNGLGETPOINTERINDEXEDVEXTPROC.invoke(address("glGetPointerIndexedvEXT"), target, index, data);
  }

  public void glGetVertexAttribivNV(int index, int pname, MemorySegment params) {
    PFNGLGETVERTEXATTRIBIVNVPROC.invoke(address("glGetVertexAttribivNV"), index, pname, params);
  }

  public void glProgramUniform3i64ARB(int program, int location, long x, long y, long z) {
    PFNGLPROGRAMUNIFORM3I64ARBPROC.invoke(address("glProgramUniform3i64ARB"), program, location, x, y, z);
  }

  public void glSetLocalConstantEXT(int id, int type, MemorySegment addr) {
    PFNGLSETLOCALCONSTANTEXTPROC.invoke(address("glSetLocalConstantEXT"), id, type, addr);
  }

  public byte glIsVertexArray(int array) {
    return PFNGLISVERTEXARRAYPROC.invoke(address("glIsVertexArray"), array);
  }

  public void glFramebufferTexture2DMultisampleEXT(int target, int attachment, int textarget, int texture, int level, int samples) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public int glVideoCaptureNV(int video_capture_slot, MemorySegment sequence_num, MemorySegment capture_time) {
    return PFNGLVIDEOCAPTURENVPROC.invoke(address("glVideoCaptureNV"), video_capture_slot, sequence_num, capture_time);
  }

  public void glGetnMinmax(int target, byte reset, int format, int type, int bufSize, MemorySegment values) {
    PFNGLGETNMINMAXPROC.invoke(address("glGetnMinmax"), target, reset, format, type, bufSize, values);
  }

  public MemorySegment glFenceSync(int condition, int flags) {
    return PFNGLFENCESYNCPROC.invoke(address("glFenceSync"), condition, flags);
  }

  public void glFramebufferDrawBufferEXT(int framebuffer, int mode) {
    PFNGLFRAMEBUFFERDRAWBUFFEREXTPROC.invoke(address("glFramebufferDrawBufferEXT"), framebuffer, mode);
  }

  public void glFogx(int pname, int param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBindAttribLocation(int program, int index, MemorySegment name) {
    PFNGLBINDATTRIBLOCATIONPROC.invoke(address("glBindAttribLocation"), program, index, name);
  }

  public void glListDrawCommandsStatesClientNV(int list, int segment, MemorySegment indirects, MemorySegment sizes, MemorySegment states, MemorySegment fbos, int count) {
    PFNGLLISTDRAWCOMMANDSSTATESCLIENTNVPROC.invoke(address("glListDrawCommandsStatesClientNV"), list, segment, indirects, sizes, states, fbos, count);
  }

  public void glGetProgramPipelineivEXT(int pipeline, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glRasterPos2xvOES(MemorySegment coords) {
    PFNGLRASTERPOS2XVOESPROC.invoke(address("glRasterPos2xvOES"), coords);
  }

  public void glProgramUniformMatrix3fvEXT(int program, int location, int count, byte transpose, MemorySegment value) {
    PFNGLPROGRAMUNIFORMMATRIX3FVEXTPROC.invoke(address("glProgramUniformMatrix3fvEXT"), program, location, count, transpose, value);
  }

  public void glGetMaterialxv(int face, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetnUniformfvEXT(int program, int location, int bufSize, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniformMatrix4x2fvEXT(int program, int location, int count, byte transpose, MemorySegment value) {
    PFNGLPROGRAMUNIFORMMATRIX4X2FVEXTPROC.invoke(address("glProgramUniformMatrix4x2fvEXT"), program, location, count, transpose, value);
  }

  public void glDeformSGIX(int mask) {
    PFNGLDEFORMSGIXPROC.invoke(address("glDeformSGIX"), mask);
  }

  public void glStartTilingQCOM(int x, int y, int width, int height, int preserveMask) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glSecondaryColor3dvEXT(MemorySegment v) {
    PFNGLSECONDARYCOLOR3DVEXTPROC.invoke(address("glSecondaryColor3dvEXT"), v);
  }

  public void glTexCoordPointerListIBM(int size, int type, int stride, MemorySegment pointer, int ptrstride) {
    PFNGLTEXCOORDPOINTERLISTIBMPROC.invoke(address("glTexCoordPointerListIBM"), size, type, stride, pointer, ptrstride);
  }

  public void glEndFragmentShaderATI() {
    PFNGLENDFRAGMENTSHADERATIPROC.invoke(address("glEndFragmentShaderATI"));
  }

  public void glProgramUniform3iEXT(int program, int location, int v0, int v1, int v2) {
    PFNGLPROGRAMUNIFORM3IEXTPROC.invoke(address("glProgramUniform3iEXT"), program, location, v0, v1, v2);
  }

  public void glVertexAttrib1fNV(int index, float x) {
    PFNGLVERTEXATTRIB1FNVPROC.invoke(address("glVertexAttrib1fNV"), index, x);
  }

  public void glBindAttribLocationARB(int programObj, int index, MemorySegment name) {
    PFNGLBINDATTRIBLOCATIONARBPROC.invoke(address("glBindAttribLocationARB"), programObj, index, name);
  }

  public void glLightxvOES(int light, int pname, MemorySegment params) {
    PFNGLLIGHTXVOESPROC.invoke(address("glLightxvOES"), light, pname, params);
  }

  public void glGetHistogramEXT(int target, byte reset, int format, int type, MemorySegment values) {
    PFNGLGETHISTOGRAMEXTPROC.invoke(address("glGetHistogramEXT"), target, reset, format, type, values);
  }

  public void glFramebufferSampleLocationsfvNV(int target, int start, int count, MemorySegment v) {
    PFNGLFRAMEBUFFERSAMPLELOCATIONSFVNVPROC.invoke(address("glFramebufferSampleLocationsfvNV"), target, start, count, v);
  }

  public void glNamedBufferStorageExternalEXT(int buffer, long offset, long size, MemorySegment clientBuffer, int flags) {
    PFNGLNAMEDBUFFERSTORAGEEXTERNALEXTPROC.invoke(address("glNamedBufferStorageExternalEXT"), buffer, offset, size, clientBuffer, flags);
  }

  public void glTexEnvx(int target, int pname, int param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribP4uiv(int index, int type, byte normalized, MemorySegment value) {
    PFNGLVERTEXATTRIBP4UIVPROC.invoke(address("glVertexAttribP4uiv"), index, type, normalized, value);
  }

  public void glGetQueryivARB(int target, int pname, MemorySegment params) {
    PFNGLGETQUERYIVARBPROC.invoke(address("glGetQueryivARB"), target, pname, params);
  }

  public void glInvalidateSubFramebuffer(int target, int numAttachments, MemorySegment attachments, int x, int y, int width, int height) {
    PFNGLINVALIDATESUBFRAMEBUFFERPROC.invoke(address("glInvalidateSubFramebuffer"), target, numAttachments, attachments, x, y, width, height);
  }

  public void glEvalCoord1xOES(int u) {
    PFNGLEVALCOORD1XOESPROC.invoke(address("glEvalCoord1xOES"), u);
  }

  public void glTexCoord2fVertex3fvSUN(MemorySegment tc, MemorySegment v) {
    PFNGLTEXCOORD2FVERTEX3FVSUNPROC.invoke(address("glTexCoord2fVertex3fvSUN"), tc, v);
  }

  public void glWindowPos2fvMESA(MemorySegment v) {
    PFNGLWINDOWPOS2FVMESAPROC.invoke(address("glWindowPos2fvMESA"), v);
  }

  public void glWeightfvARB(int size, MemorySegment weights) {
    PFNGLWEIGHTFVARBPROC.invoke(address("glWeightfvARB"), size, weights);
  }

  public void glProgramUniform4i(int program, int location, int v0, int v1, int v2, int v3) {
    PFNGLPROGRAMUNIFORM4IPROC.invoke(address("glProgramUniform4i"), program, location, v0, v1, v2, v3);
  }

  public void glProgramUniform4d(int program, int location, double v0, double v1, double v2, double v3) {
    PFNGLPROGRAMUNIFORM4DPROC.invoke(address("glProgramUniform4d"), program, location, v0, v1, v2, v3);
  }

  public void glProgramUniform4f(int program, int location, float v0, float v1, float v2, float v3) {
    PFNGLPROGRAMUNIFORM4FPROC.invoke(address("glProgramUniform4f"), program, location, v0, v1, v2, v3);
  }

  public void glDrawArraysEXT(int mode, int first, int count) {
    PFNGLDRAWARRAYSEXTPROC.invoke(address("glDrawArraysEXT"), mode, first, count);
  }

  public void glPointParameteriNV(int pname, int param) {
    PFNGLPOINTPARAMETERINVPROC.invoke(address("glPointParameteriNV"), pname, param);
  }

  public void glEGLImageTargetTexture2DOES(int target, MemorySegment image) {
    PFNGLEGLIMAGETARGETTEXTURE2DOESPROC.invoke(address("glEGLImageTargetTexture2DOES"), target, image);
  }

  public void glFeedbackBufferxOES(int n, int type, MemorySegment buffer) {
    PFNGLFEEDBACKBUFFERXOESPROC.invoke(address("glFeedbackBufferxOES"), n, type, buffer);
  }

  public void glBufferParameteriAPPLE(int target, int pname, int param) {
    PFNGLBUFFERPARAMETERIAPPLEPROC.invoke(address("glBufferParameteriAPPLE"), target, pname, param);
  }

  public void glPatchParameteriOES(int pname, int value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBufferDataARB(int target, long size, MemorySegment data, int usage) {
    PFNGLBUFFERDATAARBPROC.invoke(address("glBufferDataARB"), target, size, data, usage);
  }

  public void glGetLocalConstantFloatvEXT(int id, int value, MemorySegment data) {
    PFNGLGETLOCALCONSTANTFLOATVEXTPROC.invoke(address("glGetLocalConstantFloatvEXT"), id, value, data);
  }

  public void glWaitSemaphoreui64NVX(int waitGpu, int fenceObjectCount, MemorySegment semaphoreArray, MemorySegment fenceValueArray) {
    PFNGLWAITSEMAPHOREUI64NVXPROC.invoke(address("glWaitSemaphoreui64NVX"), waitGpu, fenceObjectCount, semaphoreArray, fenceValueArray);
  }

  public void glDeleteSyncAPPLE(MemorySegment sync) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glEndTilingQCOM(int preserveMask) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glWriteMaskEXT(int res, int in, int outX, int outY, int outZ, int outW) {
    PFNGLWRITEMASKEXTPROC.invoke(address("glWriteMaskEXT"), res, in, outX, outY, outZ, outW);
  }

  public void glGetFramebufferAttachmentParameteriv(int target, int attachment, int pname, MemorySegment params) {
    PFNGLGETFRAMEBUFFERATTACHMENTPARAMETERIVPROC.invoke(address("glGetFramebufferAttachmentParameteriv"), target, attachment, pname, params);
  }

  public void glTextureImage3DEXT(int texture, int target, int level, int internalformat, int width, int height, int depth, int border, int format, int type, MemorySegment pixels) {
    PFNGLTEXTUREIMAGE3DEXTPROC.invoke(address("glTextureImage3DEXT"), texture, target, level, internalformat, width, height, depth, border, format, type, pixels);
  }

  public void glPixelTransferxOES(int pname, int param) {
    PFNGLPIXELTRANSFERXOESPROC.invoke(address("glPixelTransferxOES"), pname, param);
  }

  public void glProgramUniform2f(int program, int location, float v0, float v1) {
    PFNGLPROGRAMUNIFORM2FPROC.invoke(address("glProgramUniform2f"), program, location, v0, v1);
  }

  public void glProgramUniform2i(int program, int location, int v0, int v1) {
    PFNGLPROGRAMUNIFORM2IPROC.invoke(address("glProgramUniform2i"), program, location, v0, v1);
  }

  public void glTexCoord2xvOES(MemorySegment coords) {
    PFNGLTEXCOORD2XVOESPROC.invoke(address("glTexCoord2xvOES"), coords);
  }

  public void glDrawArraysInstanced(int mode, int first, int count, int instancecount) {
    PFNGLDRAWARRAYSINSTANCEDPROC.invoke(address("glDrawArraysInstanced"), mode, first, count, instancecount);
  }

  public void glVertexAttribs4dvNV(int index, int count, MemorySegment v) {
    PFNGLVERTEXATTRIBS4DVNVPROC.invoke(address("glVertexAttribs4dvNV"), index, count, v);
  }

  public void glDrawTexxvOES(MemorySegment coords) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTextureParameterIivEXT(int texture, int target, int pname, MemorySegment params) {
    PFNGLTEXTUREPARAMETERIIVEXTPROC.invoke(address("glTextureParameterIivEXT"), texture, target, pname, params);
  }

  public void glDisableVertexAttribArrayARB(int index) {
    PFNGLDISABLEVERTEXATTRIBARRAYARBPROC.invoke(address("glDisableVertexAttribArrayARB"), index);
  }

  public void glProgramUniform2d(int program, int location, double v0, double v1) {
    PFNGLPROGRAMUNIFORM2DPROC.invoke(address("glProgramUniform2d"), program, location, v0, v1);
  }

  public void glProgramEnvParameterI4uiNV(int target, int index, int x, int y, int z, int w) {
    PFNGLPROGRAMENVPARAMETERI4UINVPROC.invoke(address("glProgramEnvParameterI4uiNV"), target, index, x, y, z, w);
  }

  public void glUniform4iARB(int location, int v0, int v1, int v2, int v3) {
    PFNGLUNIFORM4IARBPROC.invoke(address("glUniform4iARB"), location, v0, v1, v2, v3);
  }

  public void glProgramUniform3f(int program, int location, float v0, float v1, float v2) {
    PFNGLPROGRAMUNIFORM3FPROC.invoke(address("glProgramUniform3f"), program, location, v0, v1, v2);
  }

  public void glProgramUniform3i(int program, int location, int v0, int v1, int v2) {
    PFNGLPROGRAMUNIFORM3IPROC.invoke(address("glProgramUniform3i"), program, location, v0, v1, v2);
  }

  public void glGetNextPerfQueryIdINTEL(int queryId, MemorySegment nextQueryId) {
    PFNGLGETNEXTPERFQUERYIDINTELPROC.invoke(address("glGetNextPerfQueryIdINTEL"), queryId, nextQueryId);
  }

  public void glMapGrid2xOES(int n, int u1, int u2, int v1, int v2) {
    PFNGLMAPGRID2XOESPROC.invoke(address("glMapGrid2xOES"), n, u1, u2, v1, v2);
  }

  public void glProgramUniform3d(int program, int location, double v0, double v1, double v2) {
    PFNGLPROGRAMUNIFORM3DPROC.invoke(address("glProgramUniform3d"), program, location, v0, v1, v2);
  }

  public void glDepthRangedNV(double zNear, double zFar) {
    PFNGLDEPTHRANGEDNVPROC.invoke(address("glDepthRangedNV"), zNear, zFar);
  }

  public void glWindowPos3dvMESA(MemorySegment v) {
    PFNGLWINDOWPOS3DVMESAPROC.invoke(address("glWindowPos3dvMESA"), v);
  }

  public void glClearColorx(int red, int green, int blue, int alpha) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glCompileShader(int shader) {
    PFNGLCOMPILESHADERPROC.invoke(address("glCompileShader"), shader);
  }

  public void glMultiTexRenderbufferEXT(int texunit, int target, int renderbuffer) {
    PFNGLMULTITEXRENDERBUFFEREXTPROC.invoke(address("glMultiTexRenderbufferEXT"), texunit, target, renderbuffer);
  }

  public void glSamplerParameterIuivEXT(int sampler, int pname, MemorySegment param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glRenderbufferStorageMultisampleEXT(int target, int samples, int internalformat, int width, int height) {
    PFNGLRENDERBUFFERSTORAGEMULTISAMPLEEXTPROC.invoke(address("glRenderbufferStorageMultisampleEXT"), target, samples, internalformat, width, height);
  }

  public void glDisableVertexArrayAttribEXT(int vaobj, int index) {
    PFNGLDISABLEVERTEXARRAYATTRIBEXTPROC.invoke(address("glDisableVertexArrayAttribEXT"), vaobj, index);
  }

  public void glSecondaryColor3hNV(short red, short green, short blue) {
    PFNGLSECONDARYCOLOR3HNVPROC.invoke(address("glSecondaryColor3hNV"), red, green, blue);
  }

  public void glShaderOp3EXT(int op, int res, int arg1, int arg2, int arg3) {
    PFNGLSHADEROP3EXTPROC.invoke(address("glShaderOp3EXT"), op, res, arg1, arg2, arg3);
  }

  public byte glIsRenderbuffer(int renderbuffer) {
    return PFNGLISRENDERBUFFERPROC.invoke(address("glIsRenderbuffer"), renderbuffer);
  }

  public void glResolveMultisampleFramebufferAPPLE() {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMatrixMult3x3fNV(int matrixMode, MemorySegment m) {
    PFNGLMATRIXMULT3X3FNVPROC.invoke(address("glMatrixMult3x3fNV"), matrixMode, m);
  }

  public void glGetProgramResourceName(int program, int programInterface, int index, int bufSize, MemorySegment length, MemorySegment name) {
    PFNGLGETPROGRAMRESOURCENAMEPROC.invoke(address("glGetProgramResourceName"), program, programInterface, index, bufSize, length, name);
  }

  public void glMultiTexGendvEXT(int texunit, int coord, int pname, MemorySegment params) {
    PFNGLMULTITEXGENDVEXTPROC.invoke(address("glMultiTexGendvEXT"), texunit, coord, pname, params);
  }

  public void glNamedRenderbufferStorageMultisampleEXT(int renderbuffer, int samples, int internalformat, int width, int height) {
    PFNGLNAMEDRENDERBUFFERSTORAGEMULTISAMPLEEXTPROC.invoke(address("glNamedRenderbufferStorageMultisampleEXT"), renderbuffer, samples, internalformat, width, height);
  }

  public void glDeleteOcclusionQueriesNV(int n, MemorySegment ids) {
    PFNGLDELETEOCCLUSIONQUERIESNVPROC.invoke(address("glDeleteOcclusionQueriesNV"), n, ids);
  }

  public void glColorMaskIndexedEXT(int index, byte r, byte g, byte b, byte a) {
    PFNGLCOLORMASKINDEXEDEXTPROC.invoke(address("glColorMaskIndexedEXT"), index, r, g, b, a);
  }

  public void glCopyTextureImage1DEXT(int texture, int target, int level, int internalformat, int x, int y, int width, int border) {
    PFNGLCOPYTEXTUREIMAGE1DEXTPROC.invoke(address("glCopyTextureImage1DEXT"), texture, target, level, internalformat, x, y, width, border);
  }

  public void glUniformMatrix4dv(int location, int count, byte transpose, MemorySegment value) {
    PFNGLUNIFORMMATRIX4DVPROC.invoke(address("glUniformMatrix4dv"), location, count, transpose, value);
  }

  public void glColor3fVertex3fvSUN(MemorySegment c, MemorySegment v) {
    PFNGLCOLOR3FVERTEX3FVSUNPROC.invoke(address("glColor3fVertex3fvSUN"), c, v);
  }

  public void glGetCombinerOutputParameterivNV(int stage, int portion, int pname, MemorySegment params) {
    PFNGLGETCOMBINEROUTPUTPARAMETERIVNVPROC.invoke(address("glGetCombinerOutputParameterivNV"), stage, portion, pname, params);
  }

  public void glMatrixTranslatedEXT(int mode, double x, double y, double z) {
    PFNGLMATRIXTRANSLATEDEXTPROC.invoke(address("glMatrixTranslatedEXT"), mode, x, y, z);
  }

  public void glReplacementCodeuiColor4fNormal3fVertex3fSUN(int rc, float r, float g, float b, float a, float nx, float ny, float nz, float x, float y, float z) {
    PFNGLREPLACEMENTCODEUICOLOR4FNORMAL3FVERTEX3FSUNPROC.invoke(address("glReplacementCodeuiColor4fNormal3fVertex3fSUN"), rc, r, g, b, a, nx, ny, nz, x, y, z);
  }

  public void glPrioritizeTexturesxOES(int n, MemorySegment textures, MemorySegment priorities) {
    PFNGLPRIORITIZETEXTURESXOESPROC.invoke(address("glPrioritizeTexturesxOES"), n, textures, priorities);
  }

  public void glGetSemaphoreParameterui64vEXT(int semaphore, int pname, MemorySegment params) {
    PFNGLGETSEMAPHOREPARAMETERUI64VEXTPROC.invoke(address("glGetSemaphoreParameterui64vEXT"), semaphore, pname, params);
  }

  public void glVertexStream3ivATI(int stream, MemorySegment coords) {
    PFNGLVERTEXSTREAM3IVATIPROC.invoke(address("glVertexStream3ivATI"), stream, coords);
  }

  public void glUniformMatrix2x3fvNV(int location, int count, byte transpose, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glCreateBuffers(int n, MemorySegment buffers) {
    PFNGLCREATEBUFFERSPROC.invoke(address("glCreateBuffers"), n, buffers);
  }

  public void glMultiDrawMeshTasksIndirectNV(long indirect, int drawcount, int stride) {
    PFNGLMULTIDRAWMESHTASKSINDIRECTNVPROC.invoke(address("glMultiDrawMeshTasksIndirectNV"), indirect, drawcount, stride);
  }

  public void glTangent3iEXT(int tx, int ty, int tz) {
    PFNGLTANGENT3IEXTPROC.invoke(address("glTangent3iEXT"), tx, ty, tz);
  }

  public void glVertexAttribP4ui(int index, int type, byte normalized, int value) {
    PFNGLVERTEXATTRIBP4UIPROC.invoke(address("glVertexAttribP4ui"), index, type, normalized, value);
  }

  public void glClearDepthfOES(float depth) {
    PFNGLCLEARDEPTHFOESPROC.invoke(address("glClearDepthfOES"), depth);
  }

  public void glGetVideoi64vNV(int video_slot, int pname, MemorySegment params) {
    PFNGLGETVIDEOI64VNVPROC.invoke(address("glGetVideoi64vNV"), video_slot, pname, params);
  }

  public void glMultiTexCoordP2ui(int texture, int type, int coords) {
    PFNGLMULTITEXCOORDP2UIPROC.invoke(address("glMultiTexCoordP2ui"), texture, type, coords);
  }

  public void glProgramUniform3fvEXT(int program, int location, int count, MemorySegment value) {
    PFNGLPROGRAMUNIFORM3FVEXTPROC.invoke(address("glProgramUniform3fvEXT"), program, location, count, value);
  }

  public void glScissorIndexedvNV(int index, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTextureImage3DMultisampleNV(int texture, int target, int samples, int internalFormat, int width, int height, int depth, byte fixedSampleLocations) {
    PFNGLTEXTUREIMAGE3DMULTISAMPLENVPROC.invoke(address("glTextureImage3DMultisampleNV"), texture, target, samples, internalFormat, width, height, depth, fixedSampleLocations);
  }

  public void glWeightusvARB(int size, MemorySegment weights) {
    PFNGLWEIGHTUSVARBPROC.invoke(address("glWeightusvARB"), size, weights);
  }

  public void glGetDriverControlsQCOM(MemorySegment num, int size, MemorySegment driverControls) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetTexGenxvOES(int coord, int pname, MemorySegment params) {
    PFNGLGETTEXGENXVOESPROC.invoke(address("glGetTexGenxvOES"), coord, pname, params);
  }

  public void glShadingRateEXT(int rate) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glWaitSyncAPPLE(MemorySegment sync, int flags, long timeout) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniformHandleui64IMG(int location, long value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glWindowPos4dvMESA(MemorySegment v) {
    PFNGLWINDOWPOS4DVMESAPROC.invoke(address("glWindowPos4dvMESA"), v);
  }

  public void glVertexAttrib4NusvARB(int index, MemorySegment v) {
    PFNGLVERTEXATTRIB4NUSVARBPROC.invoke(address("glVertexAttrib4NusvARB"), index, v);
  }

  public void glCopyMultiTexImage2DEXT(int texunit, int target, int level, int internalformat, int x, int y, int width, int height, int border) {
    PFNGLCOPYMULTITEXIMAGE2DEXTPROC.invoke(address("glCopyMultiTexImage2DEXT"), texunit, target, level, internalformat, x, y, width, height, border);
  }

  public void glVertexArrayRangeNV(int length, MemorySegment pointer) {
    PFNGLVERTEXARRAYRANGENVPROC.invoke(address("glVertexArrayRangeNV"), length, pointer);
  }

  public void glBlendEquationSeparateiARB(int buf, int modeRGB, int modeAlpha) {
    PFNGLBLENDEQUATIONSEPARATEIARBPROC.invoke(address("glBlendEquationSeparateiARB"), buf, modeRGB, modeAlpha);
  }

  public void glUseProgram(int program) {
    PFNGLUSEPROGRAMPROC.invoke(address("glUseProgram"), program);
  }

  public void glGetProgramInterfaceiv(int program, int programInterface, int pname, MemorySegment params) {
    PFNGLGETPROGRAMINTERFACEIVPROC.invoke(address("glGetProgramInterfaceiv"), program, programInterface, pname, params);
  }

  public void glVariantArrayObjectATI(int id, int type, int stride, int buffer, int offset) {
    PFNGLVARIANTARRAYOBJECTATIPROC.invoke(address("glVariantArrayObjectATI"), id, type, stride, buffer, offset);
  }

  public void glEndOcclusionQueryNV() {
    PFNGLENDOCCLUSIONQUERYNVPROC.invoke(address("glEndOcclusionQueryNV"));
  }

  public void glUniformMatrix4fv(int location, int count, byte transpose, MemorySegment value) {
    PFNGLUNIFORMMATRIX4FVPROC.invoke(address("glUniformMatrix4fv"), location, count, transpose, value);
  }

  public void glBeginConditionalRenderNVX(int id) {
    PFNGLBEGINCONDITIONALRENDERNVXPROC.invoke(address("glBeginConditionalRenderNVX"), id);
  }

  public void glMultiTexCoord2xvOES(int texture, MemorySegment coords) {
    PFNGLMULTITEXCOORD2XVOESPROC.invoke(address("glMultiTexCoord2xvOES"), texture, coords);
  }

  public void glGetPixelTexGenParameterivSGIS(int pname, MemorySegment params) {
    PFNGLGETPIXELTEXGENPARAMETERIVSGISPROC.invoke(address("glGetPixelTexGenParameterivSGIS"), pname, params);
  }

  public void glSemaphoreParameterui64vEXT(int semaphore, int pname, MemorySegment params) {
    PFNGLSEMAPHOREPARAMETERUI64VEXTPROC.invoke(address("glSemaphoreParameterui64vEXT"), semaphore, pname, params);
  }

  public void glImportMemoryWin32NameEXT(int memory, long size, int handleType, MemorySegment name) {
    PFNGLIMPORTMEMORYWIN32NAMEEXTPROC.invoke(address("glImportMemoryWin32NameEXT"), memory, size, handleType, name);
  }

  public void glVertexAttribI4ivEXT(int index, MemorySegment v) {
    PFNGLVERTEXATTRIBI4IVEXTPROC.invoke(address("glVertexAttribI4ivEXT"), index, v);
  }

  public void glDebugMessageCallbackARB(MemorySegment callback, MemorySegment userParam) {
    PFNGLDEBUGMESSAGECALLBACKARBPROC.invoke(address("glDebugMessageCallbackARB"), callback, userParam);
  }

  public int glGenSymbolsEXT(int datatype, int storagetype, int range, int components) {
    return PFNGLGENSYMBOLSEXTPROC.invoke(address("glGenSymbolsEXT"), datatype, storagetype, range, components);
  }

  public void glVertexAttrib3dNV(int index, double x, double y, double z) {
    PFNGLVERTEXATTRIB3DNVPROC.invoke(address("glVertexAttrib3dNV"), index, x, y, z);
  }

  public void glTexCoordP4uiv(int type, MemorySegment coords) {
    PFNGLTEXCOORDP4UIVPROC.invoke(address("glTexCoordP4uiv"), type, coords);
  }

  public void glEvalCoord1xvOES(MemorySegment coords) {
    PFNGLEVALCOORD1XVOESPROC.invoke(address("glEvalCoord1xvOES"), coords);
  }

  public void glWindowPos3dARB(double x, double y, double z) {
    PFNGLWINDOWPOS3DARBPROC.invoke(address("glWindowPos3dARB"), x, y, z);
  }

  public void glCopyTextureLevelsAPPLE(int destinationTexture, int sourceTexture, int sourceBaseLevel, int sourceLevelCount) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glPathDashArrayNV(int path, int dashCount, MemorySegment dashArray) {
    PFNGLPATHDASHARRAYNVPROC.invoke(address("glPathDashArrayNV"), path, dashCount, dashArray);
  }

  public void glGetFragmentMaterialfvSGIX(int face, int pname, MemorySegment params) {
    PFNGLGETFRAGMENTMATERIALFVSGIXPROC.invoke(address("glGetFragmentMaterialfvSGIX"), face, pname, params);
  }

  public void glGetTexBumpParameterfvATI(int pname, MemorySegment param) {
    PFNGLGETTEXBUMPPARAMETERFVATIPROC.invoke(address("glGetTexBumpParameterfvATI"), pname, param);
  }

  public void glVertexAttribI3uivEXT(int index, MemorySegment v) {
    PFNGLVERTEXATTRIBI3UIVEXTPROC.invoke(address("glVertexAttribI3uivEXT"), index, v);
  }

  public void glGetTexParameterxvOES(int target, int pname, MemorySegment params) {
    PFNGLGETTEXPARAMETERXVOESPROC.invoke(address("glGetTexParameterxvOES"), target, pname, params);
  }

  public void glGetBooleanIndexedvEXT(int target, int index, MemorySegment data) {
    PFNGLGETBOOLEANINDEXEDVEXTPROC.invoke(address("glGetBooleanIndexedvEXT"), target, index, data);
  }

  public void glVertexStream2iATI(int stream, int x, int y) {
    PFNGLVERTEXSTREAM2IATIPROC.invoke(address("glVertexStream2iATI"), stream, x, y);
  }

  public void glGenPerfMonitorsAMD(int n, MemorySegment monitors) {
    PFNGLGENPERFMONITORSAMDPROC.invoke(address("glGenPerfMonitorsAMD"), n, monitors);
  }

  public void glMultiTexCoord4xOES(int texture, int s, int t, int r, int q) {
    PFNGLMULTITEXCOORD4XOESPROC.invoke(address("glMultiTexCoord4xOES"), texture, s, t, r, q);
  }

  public void glNamedFramebufferParameteriEXT(int framebuffer, int pname, int param) {
    PFNGLNAMEDFRAMEBUFFERPARAMETERIEXTPROC.invoke(address("glNamedFramebufferParameteriEXT"), framebuffer, pname, param);
  }

  public void glReplacementCodeuiColor4fNormal3fVertex3fvSUN(MemorySegment rc, MemorySegment c, MemorySegment n, MemorySegment v) {
    PFNGLREPLACEMENTCODEUICOLOR4FNORMAL3FVERTEX3FVSUNPROC.invoke(address("glReplacementCodeuiColor4fNormal3fVertex3fvSUN"), rc, c, n, v);
  }

  public void glScissorIndexed(int index, int left, int bottom, int width, int height) {
    PFNGLSCISSORINDEXEDPROC.invoke(address("glScissorIndexed"), index, left, bottom, width, height);
  }

  public void glMatrixLoadIdentityEXT(int mode) {
    PFNGLMATRIXLOADIDENTITYEXTPROC.invoke(address("glMatrixLoadIdentityEXT"), mode);
  }

  public void glReplacementCodeuiTexCoord2fNormal3fVertex3fSUN(int rc, float s, float t, float nx, float ny, float nz, float x, float y, float z) {
    PFNGLREPLACEMENTCODEUITEXCOORD2FNORMAL3FVERTEX3FSUNPROC.invoke(address("glReplacementCodeuiTexCoord2fNormal3fVertex3fSUN"), rc, s, t, nx, ny, nz, x, y, z);
  }

  public void glSamplerParameteri(int sampler, int pname, int param) {
    PFNGLSAMPLERPARAMETERIPROC.invoke(address("glSamplerParameteri"), sampler, pname, param);
  }

  public void glDeleteProgramPipelinesEXT(int n, MemorySegment pipelines) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glSamplerParameterf(int sampler, int pname, float param) {
    PFNGLSAMPLERPARAMETERFPROC.invoke(address("glSamplerParameterf"), sampler, pname, param);
  }

  public void glSecondaryColor3uivEXT(MemorySegment v) {
    PFNGLSECONDARYCOLOR3UIVEXTPROC.invoke(address("glSecondaryColor3uivEXT"), v);
  }

  public void glSampleCoverageARB(float value, byte invert) {
    PFNGLSAMPLECOVERAGEARBPROC.invoke(address("glSampleCoverageARB"), value, invert);
  }

  public void glWeightPointerARB(int size, int type, int stride, MemorySegment pointer) {
    PFNGLWEIGHTPOINTERARBPROC.invoke(address("glWeightPointerARB"), size, type, stride, pointer);
  }

  public void glProgramUniform2i64NV(int program, int location, long x, long y) {
    PFNGLPROGRAMUNIFORM2I64NVPROC.invoke(address("glProgramUniform2i64NV"), program, location, x, y);
  }

  public void glDrawTransformFeedbackStream(int mode, int id, int stream) {
    PFNGLDRAWTRANSFORMFEEDBACKSTREAMPROC.invoke(address("glDrawTransformFeedbackStream"), mode, id, stream);
  }

  public void glTextureRangeAPPLE(int target, int length, MemorySegment pointer) {
    PFNGLTEXTURERANGEAPPLEPROC.invoke(address("glTextureRangeAPPLE"), target, length, pointer);
  }

  public void glBinormal3ivEXT(MemorySegment v) {
    PFNGLBINORMAL3IVEXTPROC.invoke(address("glBinormal3ivEXT"), v);
  }

  public void glPolygonOffsetClampEXT(float factor, float units, float clamp) {
    PFNGLPOLYGONOFFSETCLAMPEXTPROC.invoke(address("glPolygonOffsetClampEXT"), factor, units, clamp);
  }

  public void glNormalStream3fvATI(int stream, MemorySegment coords) {
    PFNGLNORMALSTREAM3FVATIPROC.invoke(address("glNormalStream3fvATI"), stream, coords);
  }

  public void glEndQueryIndexed(int target, int index) {
    PFNGLENDQUERYINDEXEDPROC.invoke(address("glEndQueryIndexed"), target, index);
  }

  public void glPrimitiveBoundingBoxEXT(float minX, float minY, float minZ, float minW, float maxX, float maxY, float maxZ, float maxW) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexCoord4bOES(int texture, byte s, byte t, byte r, byte q) {
    PFNGLMULTITEXCOORD4BOESPROC.invoke(address("glMultiTexCoord4bOES"), texture, s, t, r, q);
  }

  public void glStopInstrumentsSGIX(int marker) {
    PFNGLSTOPINSTRUMENTSSGIXPROC.invoke(address("glStopInstrumentsSGIX"), marker);
  }

  public void glMakeTextureHandleResidentARB(long handle) {
    PFNGLMAKETEXTUREHANDLERESIDENTARBPROC.invoke(address("glMakeTextureHandleResidentARB"), handle);
  }

  public void glVertexStream2fvATI(int stream, MemorySegment coords) {
    PFNGLVERTEXSTREAM2FVATIPROC.invoke(address("glVertexStream2fvATI"), stream, coords);
  }

  public void glProgramLocalParameterI4uivNV(int target, int index, MemorySegment params) {
    PFNGLPROGRAMLOCALPARAMETERI4UIVNVPROC.invoke(address("glProgramLocalParameterI4uivNV"), target, index, params);
  }

  public void glBufferSubDataARB(int target, long offset, long size, MemorySegment data) {
    PFNGLBUFFERSUBDATAARBPROC.invoke(address("glBufferSubDataARB"), target, offset, size, data);
  }

  public void glProgramUniformui64vNV(int program, int location, int count, MemorySegment value) {
    PFNGLPROGRAMUNIFORMUI64VNVPROC.invoke(address("glProgramUniformui64vNV"), program, location, count, value);
  }

  public void glProgramUniformMatrix2x4dv(int program, int location, int count, byte transpose, MemorySegment value) {
    PFNGLPROGRAMUNIFORMMATRIX2X4DVPROC.invoke(address("glProgramUniformMatrix2x4dv"), program, location, count, transpose, value);
  }

  public void glTexCoord2xOES(int s, int t) {
    PFNGLTEXCOORD2XOESPROC.invoke(address("glTexCoord2xOES"), s, t);
  }

  public void glVertexAttribL1dv(int index, MemorySegment v) {
    PFNGLVERTEXATTRIBL1DVPROC.invoke(address("glVertexAttribL1dv"), index, v);
  }

  public void glGenOcclusionQueriesNV(int n, MemorySegment ids) {
    PFNGLGENOCCLUSIONQUERIESNVPROC.invoke(address("glGenOcclusionQueriesNV"), n, ids);
  }

  public void glBlitFramebufferNV(int srcX0, int srcY0, int srcX1, int srcY1, int dstX0, int dstY0, int dstX1, int dstY1, int mask, int filter) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFlushMappedBufferRangeAPPLE(int target, long offset, long size) {
    PFNGLFLUSHMAPPEDBUFFERRANGEAPPLEPROC.invoke(address("glFlushMappedBufferRangeAPPLE"), target, offset, size);
  }

  public void glGetObjectLabelKHR(int identifier, int name, int bufSize, MemorySegment length, MemorySegment label) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribL2d(int index, double x, double y) {
    PFNGLVERTEXATTRIBL2DPROC.invoke(address("glVertexAttribL2d"), index, x, y);
  }

  public void glWindowPos3fvARB(MemorySegment v) {
    PFNGLWINDOWPOS3FVARBPROC.invoke(address("glWindowPos3fvARB"), v);
  }

  public void glPushClientAttribDefaultEXT(int mask) {
    PFNGLPUSHCLIENTATTRIBDEFAULTEXTPROC.invoke(address("glPushClientAttribDefaultEXT"), mask);
  }

  public void glMultiTexCoord2hvNV(int target, MemorySegment v) {
    PFNGLMULTITEXCOORD2HVNVPROC.invoke(address("glMultiTexCoord2hvNV"), target, v);
  }

  public void glVariantbvEXT(int id, MemorySegment addr) {
    PFNGLVARIANTBVEXTPROC.invoke(address("glVariantbvEXT"), id, addr);
  }

  public void glProgramUniform2i64vARB(int program, int location, int count, MemorySegment value) {
    PFNGLPROGRAMUNIFORM2I64VARBPROC.invoke(address("glProgramUniform2i64vARB"), program, location, count, value);
  }

  public void glDepthRangefOES(float n, float f) {
    PFNGLDEPTHRANGEFOESPROC.invoke(address("glDepthRangefOES"), n, f);
  }

  public long glVDPAURegisterVideoSurfaceNV(MemorySegment vdpSurface, int target, int numTextureNames, MemorySegment textureNames) {
    return PFNGLVDPAUREGISTERVIDEOSURFACENVPROC.invoke(address("glVDPAURegisterVideoSurfaceNV"), vdpSurface, target, numTextureNames, textureNames);
  }

  public void glGetVertexAttribdvARB(int index, int pname, MemorySegment params) {
    PFNGLGETVERTEXATTRIBDVARBPROC.invoke(address("glGetVertexAttribdvARB"), index, pname, params);
  }

  public void glVertexAttribL3d(int index, double x, double y, double z) {
    PFNGLVERTEXATTRIBL3DPROC.invoke(address("glVertexAttribL3d"), index, x, y, z);
  }

  public void glUniformMatrix3x2dv(int location, int count, byte transpose, MemorySegment value) {
    PFNGLUNIFORMMATRIX3X2DVPROC.invoke(address("glUniformMatrix3x2dv"), location, count, transpose, value);
  }

  public void glGetnMapivARB(int target, int query, int bufSize, MemorySegment v) {
    PFNGLGETNMAPIVARBPROC.invoke(address("glGetnMapivARB"), target, query, bufSize, v);
  }

  public void glBindBuffer(int target, int buffer) {
    PFNGLBINDBUFFERPROC.invoke(address("glBindBuffer"), target, buffer);
  }

  public void glTexCoordP3ui(int type, int coords) {
    PFNGLTEXCOORDP3UIPROC.invoke(address("glTexCoordP3ui"), type, coords);
  }

  public void glUniform1i64vNV(int location, int count, MemorySegment value) {
    PFNGLUNIFORM1I64VNVPROC.invoke(address("glUniform1i64vNV"), location, count, value);
  }

  public void glColor3fVertex3fSUN(float r, float g, float b, float x, float y, float z) {
    PFNGLCOLOR3FVERTEX3FSUNPROC.invoke(address("glColor3fVertex3fSUN"), r, g, b, x, y, z);
  }

  public void glPrioritizeTexturesEXT(int n, MemorySegment textures, MemorySegment priorities) {
    PFNGLPRIORITIZETEXTURESEXTPROC.invoke(address("glPrioritizeTexturesEXT"), n, textures, priorities);
  }

  public void glVertexAttrib1sARB(int index, short x) {
    PFNGLVERTEXATTRIB1SARBPROC.invoke(address("glVertexAttrib1sARB"), index, x);
  }

  public void glProgramUniformHandleui64vIMG(int program, int location, int count, MemorySegment values) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultTransposeMatrixdARB(MemorySegment m) {
    PFNGLMULTTRANSPOSEMATRIXDARBPROC.invoke(address("glMultTransposeMatrixdARB"), m);
  }

  public void glVertexAttribIPointerEXT(int index, int size, int type, int stride, MemorySegment pointer) {
    PFNGLVERTEXATTRIBIPOINTEREXTPROC.invoke(address("glVertexAttribIPointerEXT"), index, size, type, stride, pointer);
  }

  public void glVertexArrayParameteriAPPLE(int pname, int param) {
    PFNGLVERTEXARRAYPARAMETERIAPPLEPROC.invoke(address("glVertexArrayParameteriAPPLE"), pname, param);
  }

  public void glProgramUniformMatrix3fv(int program, int location, int count, byte transpose, MemorySegment value) {
    PFNGLPROGRAMUNIFORMMATRIX3FVPROC.invoke(address("glProgramUniformMatrix3fv"), program, location, count, transpose, value);
  }

  public void glTexCoord2bOES(byte s, byte t) {
    PFNGLTEXCOORD2BOESPROC.invoke(address("glTexCoord2bOES"), s, t);
  }

  public void glProgramUniform1ivEXT(int program, int location, int count, MemorySegment value) {
    PFNGLPROGRAMUNIFORM1IVEXTPROC.invoke(address("glProgramUniform1ivEXT"), program, location, count, value);
  }

  public void glVertexAttribs2svNV(int index, int count, MemorySegment v) {
    PFNGLVERTEXATTRIBS2SVNVPROC.invoke(address("glVertexAttribs2svNV"), index, count, v);
  }

  public void glShaderSourceARB(int shaderObj, int count, MemorySegment string, MemorySegment length) {
    PFNGLSHADERSOURCEARBPROC.invoke(address("glShaderSourceARB"), shaderObj, count, string, length);
  }

  public void glCompressedTexSubImage2DARB(int target, int level, int xoffset, int yoffset, int width, int height, int format, int imageSize, MemorySegment data) {
    PFNGLCOMPRESSEDTEXSUBIMAGE2DARBPROC.invoke(address("glCompressedTexSubImage2DARB"), target, level, xoffset, yoffset, width, height, format, imageSize, data);
  }

  public void glGetNamedBufferParameteri64v(int buffer, int pname, MemorySegment params) {
    PFNGLGETNAMEDBUFFERPARAMETERI64VPROC.invoke(address("glGetNamedBufferParameteri64v"), buffer, pname, params);
  }

  public void glGetActiveUniformARB(int programObj, int index, int maxLength, MemorySegment length, MemorySegment size, MemorySegment type, MemorySegment name) {
    PFNGLGETACTIVEUNIFORMARBPROC.invoke(address("glGetActiveUniformARB"), programObj, index, maxLength, length, size, type, name);
  }

  public void glVertexAttribL1d(int index, double x) {
    PFNGLVERTEXATTRIBL1DPROC.invoke(address("glVertexAttribL1d"), index, x);
  }

  public void glApplyTextureEXT(int mode) {
    PFNGLAPPLYTEXTUREEXTPROC.invoke(address("glApplyTextureEXT"), mode);
  }

  public void glDebugMessageCallbackAMD(MemorySegment callback, MemorySegment userParam) {
    PFNGLDEBUGMESSAGECALLBACKAMDPROC.invoke(address("glDebugMessageCallbackAMD"), callback, userParam);
  }

  public void glMulticastGetQueryObjecti64vNV(int gpu, int id, int pname, MemorySegment params) {
    PFNGLMULTICASTGETQUERYOBJECTI64VNVPROC.invoke(address("glMulticastGetQueryObjecti64vNV"), gpu, id, pname, params);
  }

  public void glTexParameterIuivEXT(int target, int pname, MemorySegment params) {
    PFNGLTEXPARAMETERIUIVEXTPROC.invoke(address("glTexParameterIuivEXT"), target, pname, params);
  }

  public void glDeleteTransformFeedbacksNV(int n, MemorySegment ids) {
    PFNGLDELETETRANSFORMFEEDBACKSNVPROC.invoke(address("glDeleteTransformFeedbacksNV"), n, ids);
  }

  public void glResetMemoryObjectParameterNV(int memory, int pname) {
    PFNGLRESETMEMORYOBJECTPARAMETERNVPROC.invoke(address("glResetMemoryObjectParameterNV"), memory, pname);
  }

  public void glTexturePageCommitmentEXT(int texture, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, byte commit) {
    PFNGLTEXTUREPAGECOMMITMENTEXTPROC.invoke(address("glTexturePageCommitmentEXT"), texture, level, xoffset, yoffset, zoffset, width, height, depth, commit);
  }

  public void glDrawArraysInstancedBaseInstanceEXT(int mode, int first, int count, int instancecount, int baseinstance) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public byte glIsProgramNV(int id) {
    return PFNGLISPROGRAMNVPROC.invoke(address("glIsProgramNV"), id);
  }

  public void glTextureBufferRange(int texture, int internalformat, int buffer, long offset, long size) {
    PFNGLTEXTUREBUFFERRANGEPROC.invoke(address("glTextureBufferRange"), texture, internalformat, buffer, offset, size);
  }

  public void glBeginQueryEXT(int target, int id) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetQueryObjectivEXT(int id, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glPixelTexGenParameterivSGIS(int pname, MemorySegment params) {
    PFNGLPIXELTEXGENPARAMETERIVSGISPROC.invoke(address("glPixelTexGenParameterivSGIS"), pname, params);
  }

  public void glGetVertexAttribLui64vARB(int index, int pname, MemorySegment params) {
    PFNGLGETVERTEXATTRIBLUI64VARBPROC.invoke(address("glGetVertexAttribLui64vARB"), index, pname, params);
  }

  public void glGetnUniformdvARB(int program, int location, int bufSize, MemorySegment params) {
    PFNGLGETNUNIFORMDVARBPROC.invoke(address("glGetnUniformdvARB"), program, location, bufSize, params);
  }

  public void glProgramUniformMatrix3dv(int program, int location, int count, byte transpose, MemorySegment value) {
    PFNGLPROGRAMUNIFORMMATRIX3DVPROC.invoke(address("glProgramUniformMatrix3dv"), program, location, count, transpose, value);
  }

  public void glGetLightxv(int light, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetVertexAttribIuivEXT(int index, int pname, MemorySegment params) {
    PFNGLGETVERTEXATTRIBIUIVEXTPROC.invoke(address("glGetVertexAttribIuivEXT"), index, pname, params);
  }

  public void glTexCoord2hNV(short s, short t) {
    PFNGLTEXCOORD2HNVPROC.invoke(address("glTexCoord2hNV"), s, t);
  }

  public void glBlendFuncSeparateiARB(int buf, int srcRGB, int dstRGB, int srcAlpha, int dstAlpha) {
    PFNGLBLENDFUNCSEPARATEIARBPROC.invoke(address("glBlendFuncSeparateiARB"), buf, srcRGB, dstRGB, srcAlpha, dstAlpha);
  }

  public void glNamedProgramLocalParametersI4ivEXT(int program, int target, int index, int count, MemorySegment params) {
    PFNGLNAMEDPROGRAMLOCALPARAMETERSI4IVEXTPROC.invoke(address("glNamedProgramLocalParametersI4ivEXT"), program, target, index, count, params);
  }

  public void glGenRenderbuffersEXT(int n, MemorySegment renderbuffers) {
    PFNGLGENRENDERBUFFERSEXTPROC.invoke(address("glGenRenderbuffersEXT"), n, renderbuffers);
  }

  public void glTextureSubImage1DEXT(int texture, int target, int level, int xoffset, int width, int format, int type, MemorySegment pixels) {
    PFNGLTEXTURESUBIMAGE1DEXTPROC.invoke(address("glTextureSubImage1DEXT"), texture, target, level, xoffset, width, format, type, pixels);
  }

  public void glCompressedTextureSubImage3DEXT(int texture, int target, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int format, int imageSize, MemorySegment bits) {
    PFNGLCOMPRESSEDTEXTURESUBIMAGE3DEXTPROC.invoke(address("glCompressedTextureSubImage3DEXT"), texture, target, level, xoffset, yoffset, zoffset, width, height, depth, format, imageSize, bits);
  }

  public void glVertexAttribs2hvNV(int index, int n, MemorySegment v) {
    PFNGLVERTEXATTRIBS2HVNVPROC.invoke(address("glVertexAttribs2hvNV"), index, n, v);
  }

  public void glTextureFoveationParametersQCOM(int texture, int layer, int focalPoint, float focalX, float focalY, float gainX, float gainY, float foveaArea) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDrawElementsInstancedBaseInstance(int mode, int count, int type, MemorySegment indices, int instancecount, int baseinstance) {
    PFNGLDRAWELEMENTSINSTANCEDBASEINSTANCEPROC.invoke(address("glDrawElementsInstancedBaseInstance"), mode, count, type, indices, instancecount, baseinstance);
  }

  public void glProgramUniform2ui64ARB(int program, int location, long x, long y) {
    PFNGLPROGRAMUNIFORM2UI64ARBPROC.invoke(address("glProgramUniform2ui64ARB"), program, location, x, y);
  }

  public void glMatrixPopEXT(int mode) {
    PFNGLMATRIXPOPEXTPROC.invoke(address("glMatrixPopEXT"), mode);
  }

  public void glGetNamedStringARB(int namelen, MemorySegment name, int bufSize, MemorySegment stringlen, MemorySegment string) {
    PFNGLGETNAMEDSTRINGARBPROC.invoke(address("glGetNamedStringARB"), namelen, name, bufSize, stringlen, string);
  }

  public void glDeleteFramebuffersEXT(int n, MemorySegment framebuffers) {
    PFNGLDELETEFRAMEBUFFERSEXTPROC.invoke(address("glDeleteFramebuffersEXT"), n, framebuffers);
  }

  public void glDispatchCompute(int num_groups_x, int num_groups_y, int num_groups_z) {
    PFNGLDISPATCHCOMPUTEPROC.invoke(address("glDispatchCompute"), num_groups_x, num_groups_y, num_groups_z);
  }

  public void glProgramUniformMatrix2x4fv(int program, int location, int count, byte transpose, MemorySegment value) {
    PFNGLPROGRAMUNIFORMMATRIX2X4FVPROC.invoke(address("glProgramUniformMatrix2x4fv"), program, location, count, transpose, value);
  }

  public void glUpdateObjectBufferATI(int buffer, int offset, int size, MemorySegment pointer, int preserve) {
    PFNGLUPDATEOBJECTBUFFERATIPROC.invoke(address("glUpdateObjectBufferATI"), buffer, offset, size, pointer, preserve);
  }

  public void glTextureBufferEXT(int texture, int target, int internalformat, int buffer) {
    PFNGLTEXTUREBUFFEREXTPROC.invoke(address("glTextureBufferEXT"), texture, target, internalformat, buffer);
  }

  public void glWeightbvARB(int size, MemorySegment weights) {
    PFNGLWEIGHTBVARBPROC.invoke(address("glWeightbvARB"), size, weights);
  }

  public void glDrawElementsInstancedARB(int mode, int count, int type, MemorySegment indices, int primcount) {
    PFNGLDRAWELEMENTSINSTANCEDARBPROC.invoke(address("glDrawElementsInstancedARB"), mode, count, type, indices, primcount);
  }

  public void glMulticastBlitFramebufferNV(int srcGpu, int dstGpu, int srcX0, int srcY0, int srcX1, int srcY1, int dstX0, int dstY0, int dstX1, int dstY1, int mask, int filter) {
    PFNGLMULTICASTBLITFRAMEBUFFERNVPROC.invoke(address("glMulticastBlitFramebufferNV"), srcGpu, dstGpu, srcX0, srcY0, srcX1, srcY1, dstX0, dstY0, dstX1, dstY1, mask, filter);
  }

  public void glClearNamedBufferSubData(int buffer, int internalformat, long offset, long size, int format, int type, MemorySegment data) {
    PFNGLCLEARNAMEDBUFFERSUBDATAPROC.invoke(address("glClearNamedBufferSubData"), buffer, internalformat, offset, size, format, type, data);
  }

  public void glVertexAttribs1fvNV(int index, int count, MemorySegment v) {
    PFNGLVERTEXATTRIBS1FVNVPROC.invoke(address("glVertexAttribs1fvNV"), index, count, v);
  }

  public void glMinmaxEXT(int target, int internalformat, byte sink) {
    PFNGLMINMAXEXTPROC.invoke(address("glMinmaxEXT"), target, internalformat, sink);
  }

  public void glProgramUniform4i64ARB(int program, int location, long x, long y, long z, long w) {
    PFNGLPROGRAMUNIFORM4I64ARBPROC.invoke(address("glProgramUniform4i64ARB"), program, location, x, y, z, w);
  }

  public void glNormalStream3bATI(int stream, byte nx, byte ny, byte nz) {
    PFNGLNORMALSTREAM3BATIPROC.invoke(address("glNormalStream3bATI"), stream, nx, ny, nz);
  }

  public void glTessellationModeAMD(int mode) {
    PFNGLTESSELLATIONMODEAMDPROC.invoke(address("glTessellationModeAMD"), mode);
  }

  public void glGetTexParameterIuiv(int target, int pname, MemorySegment params) {
    PFNGLGETTEXPARAMETERIUIVPROC.invoke(address("glGetTexParameterIuiv"), target, pname, params);
  }

  public void glOrthof(float l, float r, float b, float t, float n, float f) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribBinding(int attribindex, int bindingindex) {
    PFNGLVERTEXATTRIBBINDINGPROC.invoke(address("glVertexAttribBinding"), attribindex, bindingindex);
  }

  public void glSamplerParameterfv(int sampler, int pname, MemorySegment param) {
    PFNGLSAMPLERPARAMETERFVPROC.invoke(address("glSamplerParameterfv"), sampler, pname, param);
  }

  public void glTexCoordP1uiv(int type, MemorySegment coords) {
    PFNGLTEXCOORDP1UIVPROC.invoke(address("glTexCoordP1uiv"), type, coords);
  }

  public void glGenProgramPipelines(int n, MemorySegment pipelines) {
    PFNGLGENPROGRAMPIPELINESPROC.invoke(address("glGenProgramPipelines"), n, pipelines);
  }

  public void glMulticastViewportPositionWScaleNVX(int gpu, int index, float xcoeff, float ycoeff) {
    PFNGLMULTICASTVIEWPORTPOSITIONWSCALENVXPROC.invoke(address("glMulticastViewportPositionWScaleNVX"), gpu, index, xcoeff, ycoeff);
  }

  public void glOrthox(int l, int r, int b, int t, int n, int f) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glNamedBufferStorageEXT(int buffer, long size, MemorySegment data, int flags) {
    PFNGLNAMEDBUFFERSTORAGEEXTPROC.invoke(address("glNamedBufferStorageEXT"), buffer, size, data, flags);
  }

  public void glVertexAttribP1uiv(int index, int type, byte normalized, MemorySegment value) {
    PFNGLVERTEXATTRIBP1UIVPROC.invoke(address("glVertexAttribP1uiv"), index, type, normalized, value);
  }

  public void glTexParameterIiv(int target, int pname, MemorySegment params) {
    PFNGLTEXPARAMETERIIVPROC.invoke(address("glTexParameterIiv"), target, pname, params);
  }

  public void glMatrixLoadTransposedEXT(int mode, MemorySegment m) {
    PFNGLMATRIXLOADTRANSPOSEDEXTPROC.invoke(address("glMatrixLoadTransposedEXT"), mode, m);
  }

  public void glGetVertexAttribLdvEXT(int index, int pname, MemorySegment params) {
    PFNGLGETVERTEXATTRIBLDVEXTPROC.invoke(address("glGetVertexAttribLdvEXT"), index, pname, params);
  }

  public void glUniformBufferEXT(int program, int location, int buffer) {
    PFNGLUNIFORMBUFFEREXTPROC.invoke(address("glUniformBufferEXT"), program, location, buffer);
  }

  public void glGetFirstPerfQueryIdINTEL(MemorySegment queryId) {
    PFNGLGETFIRSTPERFQUERYIDINTELPROC.invoke(address("glGetFirstPerfQueryIdINTEL"), queryId);
  }

  public void glSamplerParameteriv(int sampler, int pname, MemorySegment param) {
    PFNGLSAMPLERPARAMETERIVPROC.invoke(address("glSamplerParameteriv"), sampler, pname, param);
  }

  public void glTexEnvxv(int target, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glEndConditionalRenderNVX() {
    PFNGLENDCONDITIONALRENDERNVXPROC.invoke(address("glEndConditionalRenderNVX"));
  }

  public void glShadingRateSampleOrderCustomNV(int rate, int samples, MemorySegment locations) {
    PFNGLSHADINGRATESAMPLEORDERCUSTOMNVPROC.invoke(address("glShadingRateSampleOrderCustomNV"), rate, samples, locations);
  }

  public void glGetAttachedShaders(int program, int maxCount, MemorySegment count, MemorySegment shaders) {
    PFNGLGETATTACHEDSHADERSPROC.invoke(address("glGetAttachedShaders"), program, maxCount, count, shaders);
  }

  public void glGetVariantArrayObjectivATI(int id, int pname, MemorySegment params) {
    PFNGLGETVARIANTARRAYOBJECTIVATIPROC.invoke(address("glGetVariantArrayObjectivATI"), id, pname, params);
  }

  public void glVertexAttrib2fvARB(int index, MemorySegment v) {
    PFNGLVERTEXATTRIB2FVARBPROC.invoke(address("glVertexAttrib2fvARB"), index, v);
  }

  public void glSemaphoreParameterivNV(int semaphore, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFramebufferTextureLayerDownsampleIMG(int target, int attachment, int texture, int level, int layer, int xscale, int yscale) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetConvolutionParameterivEXT(int target, int pname, MemorySegment params) {
    PFNGLGETCONVOLUTIONPARAMETERIVEXTPROC.invoke(address("glGetConvolutionParameterivEXT"), target, pname, params);
  }

  public void glGetActiveUniformsiv(int program, int uniformCount, MemorySegment uniformIndices, int pname, MemorySegment params) {
    PFNGLGETACTIVEUNIFORMSIVPROC.invoke(address("glGetActiveUniformsiv"), program, uniformCount, uniformIndices, pname, params);
  }

  public void glNamedFramebufferTexture(int framebuffer, int attachment, int texture, int level) {
    PFNGLNAMEDFRAMEBUFFERTEXTUREPROC.invoke(address("glNamedFramebufferTexture"), framebuffer, attachment, texture, level);
  }

  public void glUniformMatrix3fvARB(int location, int count, byte transpose, MemorySegment value) {
    PFNGLUNIFORMMATRIX3FVARBPROC.invoke(address("glUniformMatrix3fvARB"), location, count, transpose, value);
  }

  public void glTransformPathNV(int resultPath, int srcPath, int transformType, MemorySegment transformValues) {
    PFNGLTRANSFORMPATHNVPROC.invoke(address("glTransformPathNV"), resultPath, srcPath, transformType, transformValues);
  }

  public void glUniform1fARB(int location, float v0) {
    PFNGLUNIFORM1FARBPROC.invoke(address("glUniform1fARB"), location, v0);
  }

  public void glDisableDriverControlQCOM(int driverControl) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glExtGetProgramsQCOM(MemorySegment programs, int maxPrograms, MemorySegment numPrograms) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniform4i64vARB(int location, int count, MemorySegment value) {
    PFNGLUNIFORM4I64VARBPROC.invoke(address("glUniform4i64vARB"), location, count, value);
  }

  public void glBindSamplers(int first, int count, MemorySegment samplers) {
    PFNGLBINDSAMPLERSPROC.invoke(address("glBindSamplers"), first, count, samplers);
  }

  public void glMap2xOES(int target, int u1, int u2, int ustride, int uorder, int v1, int v2, int vstride, int vorder, int points) {
    PFNGLMAP2XOESPROC.invoke(address("glMap2xOES"), target, u1, u2, ustride, uorder, v1, v2, vstride, vorder, points);
  }

  public void glUniform3ui64NV(int location, long x, long y, long z) {
    PFNGLUNIFORM3UI64NVPROC.invoke(address("glUniform3ui64NV"), location, x, y, z);
  }

  public void glViewportIndexedfvNV(int index, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public byte glIsVariantEnabledEXT(int id, int cap) {
    return PFNGLISVARIANTENABLEDEXTPROC.invoke(address("glIsVariantEnabledEXT"), id, cap);
  }

  public void glGetFramebufferParameterfvAMD(int target, int pname, int numsamples, int pixelindex, int size, MemorySegment values) {
    PFNGLGETFRAMEBUFFERPARAMETERFVAMDPROC.invoke(address("glGetFramebufferParameterfvAMD"), target, pname, numsamples, pixelindex, size, values);
  }

  public void glProgramUniform1ui64vNV(int program, int location, int count, MemorySegment value) {
    PFNGLPROGRAMUNIFORM1UI64VNVPROC.invoke(address("glProgramUniform1ui64vNV"), program, location, count, value);
  }

  public void glExecuteProgramNV(int target, int id, MemorySegment params) {
    PFNGLEXECUTEPROGRAMNVPROC.invoke(address("glExecuteProgramNV"), target, id, params);
  }

  public void glFragmentMaterialfSGIX(int face, int pname, float param) {
    PFNGLFRAGMENTMATERIALFSGIXPROC.invoke(address("glFragmentMaterialfSGIX"), face, pname, param);
  }

  public void glEnablei(int target, int index) {
    PFNGLENABLEIPROC.invoke(address("glEnablei"), target, index);
  }

  public void glReplacementCodePointerSUN(int type, int stride, MemorySegment pointer) {
    PFNGLREPLACEMENTCODEPOINTERSUNPROC.invoke(address("glReplacementCodePointerSUN"), type, stride, pointer);
  }

  public void glUniform4ui64NV(int location, long x, long y, long z, long w) {
    PFNGLUNIFORM4UI64NVPROC.invoke(address("glUniform4ui64NV"), location, x, y, z, w);
  }

  public void glColorMaski(int index, byte r, byte g, byte b, byte a) {
    PFNGLCOLORMASKIPROC.invoke(address("glColorMaski"), index, r, g, b, a);
  }

  public void glSyncTextureINTEL(int texture) {
    PFNGLSYNCTEXTUREINTELPROC.invoke(address("glSyncTextureINTEL"), texture);
  }

  public void glUniform2ui64NV(int location, long x, long y) {
    PFNGLUNIFORM2UI64NVPROC.invoke(address("glUniform2ui64NV"), location, x, y);
  }

  public void glNamedProgramLocalParametersI4uivEXT(int program, int target, int index, int count, MemorySegment params) {
    PFNGLNAMEDPROGRAMLOCALPARAMETERSI4UIVEXTPROC.invoke(address("glNamedProgramLocalParametersI4uivEXT"), program, target, index, count, params);
  }

  public void glMakeImageHandleNonResidentNV(long handle) {
    PFNGLMAKEIMAGEHANDLENONRESIDENTNVPROC.invoke(address("glMakeImageHandleNonResidentNV"), handle);
  }

  public void glGenNamesAMD(int identifier, int num, MemorySegment names) {
    PFNGLGENNAMESAMDPROC.invoke(address("glGenNamesAMD"), identifier, num, names);
  }

  public void glGetIntegeri_v(int target, int index, MemorySegment data) {
    PFNGLGETINTEGERI_VPROC.invoke(address("glGetIntegeri_v"), target, index, data);
  }

  public void glProgramUniform4ivEXT(int program, int location, int count, MemorySegment value) {
    PFNGLPROGRAMUNIFORM4IVEXTPROC.invoke(address("glProgramUniform4ivEXT"), program, location, count, value);
  }

  public void glGetMultiTexParameterIivEXT(int texunit, int target, int pname, MemorySegment params) {
    PFNGLGETMULTITEXPARAMETERIIVEXTPROC.invoke(address("glGetMultiTexParameterIivEXT"), texunit, target, pname, params);
  }

  public void glAttachObjectARB(int containerObj, int obj) {
    PFNGLATTACHOBJECTARBPROC.invoke(address("glAttachObjectARB"), containerObj, obj);
  }

  public void glCurrentPaletteMatrixARB(int index) {
    PFNGLCURRENTPALETTEMATRIXARBPROC.invoke(address("glCurrentPaletteMatrixARB"), index);
  }

  public MemorySegment glImportSyncEXT(int external_sync_type, long external_sync, int flags) {
    return PFNGLIMPORTSYNCEXTPROC.invoke(address("glImportSyncEXT"), external_sync_type, external_sync, flags);
  }

  public int glGetFramebufferPixelLocalStorageSizeEXT(int target) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertex4hNV(short x, short y, short z, short w) {
    PFNGLVERTEX4HNVPROC.invoke(address("glVertex4hNV"), x, y, z, w);
  }

  public void glDisableVertexAttribAPPLE(int index, int pname) {
    PFNGLDISABLEVERTEXATTRIBAPPLEPROC.invoke(address("glDisableVertexAttribAPPLE"), index, pname);
  }

  public void glMatrixMultTransposedEXT(int mode, MemorySegment m) {
    PFNGLMATRIXMULTTRANSPOSEDEXTPROC.invoke(address("glMatrixMultTransposedEXT"), mode, m);
  }

  public void glGetBufferParameteriv(int target, int pname, MemorySegment params) {
    PFNGLGETBUFFERPARAMETERIVPROC.invoke(address("glGetBufferParameteriv"), target, pname, params);
  }

  public void glExtGetFramebuffersQCOM(MemorySegment framebuffers, int maxFramebuffers, MemorySegment numFramebuffers) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDrawBuffers(int n, MemorySegment bufs) {
    PFNGLDRAWBUFFERSPROC.invoke(address("glDrawBuffers"), n, bufs);
  }

  public void glSharpenTexFuncSGIS(int target, int n, MemorySegment points) {
    PFNGLSHARPENTEXFUNCSGISPROC.invoke(address("glSharpenTexFuncSGIS"), target, n, points);
  }

  public void glSamplePatternSGIS(int pattern) {
    PFNGLSAMPLEPATTERNSGISPROC.invoke(address("glSamplePatternSGIS"), pattern);
  }

  public void glGetInternalformatSampleivNV(int target, int internalformat, int samples, int pname, int count, MemorySegment params) {
    PFNGLGETINTERNALFORMATSAMPLEIVNVPROC.invoke(address("glGetInternalformatSampleivNV"), target, internalformat, samples, pname, count, params);
  }

  public void glDebugMessageControlARB(int source, int type, int severity, int count, MemorySegment ids, byte enabled) {
    PFNGLDEBUGMESSAGECONTROLARBPROC.invoke(address("glDebugMessageControlARB"), source, type, severity, count, ids, enabled);
  }

  public void glGetNamedProgramLocalParameterfvEXT(int program, int target, int index, MemorySegment params) {
    PFNGLGETNAMEDPROGRAMLOCALPARAMETERFVEXTPROC.invoke(address("glGetNamedProgramLocalParameterfvEXT"), program, target, index, params);
  }

  public void glGetSemaphoreParameterivNV(int semaphore, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glStencilMaskSeparate(int face, int mask) {
    PFNGLSTENCILMASKSEPARATEPROC.invoke(address("glStencilMaskSeparate"), face, mask);
  }

  public void glGetVideoui64vNV(int video_slot, int pname, MemorySegment params) {
    PFNGLGETVIDEOUI64VNVPROC.invoke(address("glGetVideoui64vNV"), video_slot, pname, params);
  }

  public void glDrawElementsInstancedBaseVertexEXT(int mode, int count, int type, MemorySegment indices, int instancecount, int basevertex) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGenQueriesARB(int n, MemorySegment ids) {
    PFNGLGENQUERIESARBPROC.invoke(address("glGenQueriesARB"), n, ids);
  }

  public void glGetDoublei_v(int target, int index, MemorySegment data) {
    PFNGLGETDOUBLEI_VPROC.invoke(address("glGetDoublei_v"), target, index, data);
  }

  public void glBlendFuncIndexedAMD(int buf, int src, int dst) {
    PFNGLBLENDFUNCINDEXEDAMDPROC.invoke(address("glBlendFuncIndexedAMD"), buf, src, dst);
  }

  public void glDetachObjectARB(int containerObj, int attachedObj) {
    PFNGLDETACHOBJECTARBPROC.invoke(address("glDetachObjectARB"), containerObj, attachedObj);
  }

  public void glMaxShaderCompilerThreadsARB(int count) {
    PFNGLMAXSHADERCOMPILERTHREADSARBPROC.invoke(address("glMaxShaderCompilerThreadsARB"), count);
  }

  public void glGetColorTableParameterivEXT(int target, int pname, MemorySegment params) {
    PFNGLGETCOLORTABLEPARAMETERIVEXTPROC.invoke(address("glGetColorTableParameterivEXT"), target, pname, params);
  }

  public void glBinormal3iEXT(int bx, int by, int bz) {
    PFNGLBINORMAL3IEXTPROC.invoke(address("glBinormal3iEXT"), bx, by, bz);
  }

  public void glExtrapolateTex2DQCOM(int src1, int src2, int output, float scaleFactor) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetVertexAttribfvNV(int index, int pname, MemorySegment params) {
    PFNGLGETVERTEXATTRIBFVNVPROC.invoke(address("glGetVertexAttribfvNV"), index, pname, params);
  }

  public void glDisableVertexArrayEXT(int vaobj, int array) {
    PFNGLDISABLEVERTEXARRAYEXTPROC.invoke(address("glDisableVertexArrayEXT"), vaobj, array);
  }

  public void glProgramUniform1ui64vARB(int program, int location, int count, MemorySegment value) {
    PFNGLPROGRAMUNIFORM1UI64VARBPROC.invoke(address("glProgramUniform1ui64vARB"), program, location, count, value);
  }

  public void glGetNamedProgramStringEXT(int program, int target, int pname, MemorySegment string) {
    PFNGLGETNAMEDPROGRAMSTRINGEXTPROC.invoke(address("glGetNamedProgramStringEXT"), program, target, pname, string);
  }

  public void glNamedProgramLocalParameter4dEXT(int program, int target, int index, double x, double y, double z, double w) {
    PFNGLNAMEDPROGRAMLOCALPARAMETER4DEXTPROC.invoke(address("glNamedProgramLocalParameter4dEXT"), program, target, index, x, y, z, w);
  }

  public void glEndPerfQueryINTEL(int queryHandle) {
    PFNGLENDPERFQUERYINTELPROC.invoke(address("glEndPerfQueryINTEL"), queryHandle);
  }

  public byte glAcquireKeyedMutexWin32EXT(int memory, long key, int timeout) {
    return PFNGLACQUIREKEYEDMUTEXWIN32EXTPROC.invoke(address("glAcquireKeyedMutexWin32EXT"), memory, key, timeout);
  }

  public void glGetMultiTexParameterfvEXT(int texunit, int target, int pname, MemorySegment params) {
    PFNGLGETMULTITEXPARAMETERFVEXTPROC.invoke(address("glGetMultiTexParameterfvEXT"), texunit, target, pname, params);
  }

  public void glProgramUniformMatrix2x4fvEXT(int program, int location, int count, byte transpose, MemorySegment value) {
    PFNGLPROGRAMUNIFORMMATRIX2X4FVEXTPROC.invoke(address("glProgramUniformMatrix2x4fvEXT"), program, location, count, transpose, value);
  }

  public void glVertexAttribDivisorANGLE(int index, int divisor) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public byte glIsRenderbufferOES(int renderbuffer) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribs4ubvNV(int index, int count, MemorySegment v) {
    PFNGLVERTEXATTRIBS4UBVNVPROC.invoke(address("glVertexAttribs4ubvNV"), index, count, v);
  }

  public void glGetClipPlanexOES(int plane, MemorySegment equation) {
    PFNGLGETCLIPPLANEXOESPROC.invoke(address("glGetClipPlanexOES"), plane, equation);
  }

  public void glUniformui64NV(int location, long value) {
    PFNGLUNIFORMUI64NVPROC.invoke(address("glUniformui64NV"), location, value);
  }

  public void glTextureParameterivEXT(int texture, int target, int pname, MemorySegment params) {
    PFNGLTEXTUREPARAMETERIVEXTPROC.invoke(address("glTextureParameterivEXT"), texture, target, pname, params);
  }

  public void glProgramUniform3uiv(int program, int location, int count, MemorySegment value) {
    PFNGLPROGRAMUNIFORM3UIVPROC.invoke(address("glProgramUniform3uiv"), program, location, count, value);
  }

  public void glUniformMatrix4x3fvNV(int location, int count, byte transpose, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttrib3sv(int index, MemorySegment v) {
    PFNGLVERTEXATTRIB3SVPROC.invoke(address("glVertexAttrib3sv"), index, v);
  }

  public byte glAreTexturesResidentEXT(int n, MemorySegment textures, MemorySegment residences) {
    return PFNGLARETEXTURESRESIDENTEXTPROC.invoke(address("glAreTexturesResidentEXT"), n, textures, residences);
  }

  public void glScalexOES(int x, int y, int z) {
    PFNGLSCALEXOESPROC.invoke(address("glScalexOES"), x, y, z);
  }

  public byte glTestFenceAPPLE(int fence) {
    return PFNGLTESTFENCEAPPLEPROC.invoke(address("glTestFenceAPPLE"), fence);
  }

  public void glMultiTexSubImage2DEXT(int texunit, int target, int level, int xoffset, int yoffset, int width, int height, int format, int type, MemorySegment pixels) {
    PFNGLMULTITEXSUBIMAGE2DEXTPROC.invoke(address("glMultiTexSubImage2DEXT"), texunit, target, level, xoffset, yoffset, width, height, format, type, pixels);
  }

  public void glClampColor(int target, int clamp) {
    PFNGLCLAMPCOLORPROC.invoke(address("glClampColor"), target, clamp);
  }

  public void glCompressedTextureImage2DEXT(int texture, int target, int level, int internalformat, int width, int height, int border, int imageSize, MemorySegment bits) {
    PFNGLCOMPRESSEDTEXTUREIMAGE2DEXTPROC.invoke(address("glCompressedTextureImage2DEXT"), texture, target, level, internalformat, width, height, border, imageSize, bits);
  }

  public void glVertexAttrib2dARB(int index, double x, double y) {
    PFNGLVERTEXATTRIB2DARBPROC.invoke(address("glVertexAttrib2dARB"), index, x, y);
  }

  public void glGetProgramStringARB(int target, int pname, MemorySegment string) {
    PFNGLGETPROGRAMSTRINGARBPROC.invoke(address("glGetProgramStringARB"), target, pname, string);
  }

  public void glArrayElementEXT(int i) {
    PFNGLARRAYELEMENTEXTPROC.invoke(address("glArrayElementEXT"), i);
  }

  public void glVertexPointerListIBM(int size, int type, int stride, MemorySegment pointer, int ptrstride) {
    PFNGLVERTEXPOINTERLISTIBMPROC.invoke(address("glVertexPointerListIBM"), size, type, stride, pointer, ptrstride);
  }

  public void glImageTransformParameteriHP(int target, int pname, int param) {
    PFNGLIMAGETRANSFORMPARAMETERIHPPROC.invoke(address("glImageTransformParameteriHP"), target, pname, param);
  }

  public void glGetProgramNamedParameterdvNV(int id, int len, MemorySegment name, MemorySegment params) {
    PFNGLGETPROGRAMNAMEDPARAMETERDVNVPROC.invoke(address("glGetProgramNamedParameterdvNV"), id, len, name, params);
  }

  public void glProgramUniform1iv(int program, int location, int count, MemorySegment value) {
    PFNGLPROGRAMUNIFORM1IVPROC.invoke(address("glProgramUniform1iv"), program, location, count, value);
  }

  public void glSamplerParameterIuivOES(int sampler, int pname, MemorySegment param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMulticastCopyImageSubDataNV(int srcGpu, int dstGpuMask, int srcName, int srcTarget, int srcLevel, int srcX, int srcY, int srcZ, int dstName, int dstTarget, int dstLevel, int dstX, int dstY, int dstZ, int srcWidth, int srcHeight, int srcDepth) {
    PFNGLMULTICASTCOPYIMAGESUBDATANVPROC.invoke(address("glMulticastCopyImageSubDataNV"), srcGpu, dstGpuMask, srcName, srcTarget, srcLevel, srcX, srcY, srcZ, dstName, dstTarget, dstLevel, dstX, dstY, dstZ, srcWidth, srcHeight, srcDepth);
  }

  public void glBlendFunciEXT(int buf, int src, int dst) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetMultiTexEnvfvEXT(int texunit, int target, int pname, MemorySegment params) {
    PFNGLGETMULTITEXENVFVEXTPROC.invoke(address("glGetMultiTexEnvfvEXT"), texunit, target, pname, params);
  }

  public void glDisableiEXT(int target, int index) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFrustumxOES(int l, int r, int b, int t, int n, int f) {
    PFNGLFRUSTUMXOESPROC.invoke(address("glFrustumxOES"), l, r, b, t, n, f);
  }

  public void glGetFixedv(int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glCreateFramebuffers(int n, MemorySegment framebuffers) {
    PFNGLCREATEFRAMEBUFFERSPROC.invoke(address("glCreateFramebuffers"), n, framebuffers);
  }

  public void glGetAttachedObjectsARB(int containerObj, int maxCount, MemorySegment count, MemorySegment obj) {
    PFNGLGETATTACHEDOBJECTSARBPROC.invoke(address("glGetAttachedObjectsARB"), containerObj, maxCount, count, obj);
  }

  public void glTexCoord2hvNV(MemorySegment v) {
    PFNGLTEXCOORD2HVNVPROC.invoke(address("glTexCoord2hvNV"), v);
  }

  public void glTangent3fvEXT(MemorySegment v) {
    PFNGLTANGENT3FVEXTPROC.invoke(address("glTangent3fvEXT"), v);
  }

  public void glInsertEventMarkerEXT(int length, MemorySegment marker) {
    PFNGLINSERTEVENTMARKEREXTPROC.invoke(address("glInsertEventMarkerEXT"), length, marker);
  }

  public void glBindSampler(int unit, int sampler) {
    PFNGLBINDSAMPLERPROC.invoke(address("glBindSampler"), unit, sampler);
  }

  public void glVertexAttrib4NuivARB(int index, MemorySegment v) {
    PFNGLVERTEXATTRIB4NUIVARBPROC.invoke(address("glVertexAttrib4NuivARB"), index, v);
  }

  public void glGetCompressedTextureSubImage(int texture, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int bufSize, MemorySegment pixels) {
    PFNGLGETCOMPRESSEDTEXTURESUBIMAGEPROC.invoke(address("glGetCompressedTextureSubImage"), texture, level, xoffset, yoffset, zoffset, width, height, depth, bufSize, pixels);
  }

  public void glGetObjectPtrLabelKHR(MemorySegment ptr, int bufSize, MemorySegment length, MemorySegment label) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttrib3fARB(int index, float x, float y, float z) {
    PFNGLVERTEXATTRIB3FARBPROC.invoke(address("glVertexAttrib3fARB"), index, x, y, z);
  }

  public void glDeleteProgram(int program) {
    PFNGLDELETEPROGRAMPROC.invoke(address("glDeleteProgram"), program);
  }

  public void glMulticastGetQueryObjectivNV(int gpu, int id, int pname, MemorySegment params) {
    PFNGLMULTICASTGETQUERYOBJECTIVNVPROC.invoke(address("glMulticastGetQueryObjectivNV"), gpu, id, pname, params);
  }

  public void glProgramUniform1dvEXT(int program, int location, int count, MemorySegment value) {
    PFNGLPROGRAMUNIFORM1DVEXTPROC.invoke(address("glProgramUniform1dvEXT"), program, location, count, value);
  }

  public long glGetImageHandleNV(int texture, int level, byte layered, int layer, int format) {
    return PFNGLGETIMAGEHANDLENVPROC.invoke(address("glGetImageHandleNV"), texture, level, layered, layer, format);
  }

  public void glGenVertexArraysOES(int n, MemorySegment arrays) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glClearColorxOES(int red, int green, int blue, int alpha) {
    PFNGLCLEARCOLORXOESPROC.invoke(address("glClearColorxOES"), red, green, blue, alpha);
  }

  public void glNamedFramebufferTexture2DEXT(int framebuffer, int attachment, int textarget, int texture, int level) {
    PFNGLNAMEDFRAMEBUFFERTEXTURE2DEXTPROC.invoke(address("glNamedFramebufferTexture2DEXT"), framebuffer, attachment, textarget, texture, level);
  }

  public void glExtractComponentEXT(int res, int src, int num) {
    PFNGLEXTRACTCOMPONENTEXTPROC.invoke(address("glExtractComponentEXT"), res, src, num);
  }

  public void glFramebufferTextureLayerARB(int target, int attachment, int texture, int level, int layer) {
    PFNGLFRAMEBUFFERTEXTURELAYERARBPROC.invoke(address("glFramebufferTextureLayerARB"), target, attachment, texture, level, layer);
  }

  public void glGetTextureParameterIiv(int texture, int pname, MemorySegment params) {
    PFNGLGETTEXTUREPARAMETERIIVPROC.invoke(address("glGetTextureParameterIiv"), texture, pname, params);
  }

  public void glVertexAttribP3uiv(int index, int type, byte normalized, MemorySegment value) {
    PFNGLVERTEXATTRIBP3UIVPROC.invoke(address("glVertexAttribP3uiv"), index, type, normalized, value);
  }

  public void glTransformFeedbackVaryingsEXT(int program, int count, MemorySegment varyings, int bufferMode) {
    PFNGLTRANSFORMFEEDBACKVARYINGSEXTPROC.invoke(address("glTransformFeedbackVaryingsEXT"), program, count, varyings, bufferMode);
  }

  public void glVertexAttribI2uiEXT(int index, int x, int y) {
    PFNGLVERTEXATTRIBI2UIEXTPROC.invoke(address("glVertexAttribI2uiEXT"), index, x, y);
  }

  public int glGetFragDataLocation(int program, MemorySegment name) {
    return PFNGLGETFRAGDATALOCATIONPROC.invoke(address("glGetFragDataLocation"), program, name);
  }

  public void glSecondaryColor3ubvEXT(MemorySegment v) {
    PFNGLSECONDARYCOLOR3UBVEXTPROC.invoke(address("glSecondaryColor3ubvEXT"), v);
  }

  public void glFlushVertexArrayRangeNV() {
    PFNGLFLUSHVERTEXARRAYRANGENVPROC.invoke(address("glFlushVertexArrayRangeNV"));
  }

  public void glMultiTexGenivEXT(int texunit, int coord, int pname, MemorySegment params) {
    PFNGLMULTITEXGENIVEXTPROC.invoke(address("glMultiTexGenivEXT"), texunit, coord, pname, params);
  }

  public void glReleaseShaderCompiler() {
    PFNGLRELEASESHADERCOMPILERPROC.invoke(address("glReleaseShaderCompiler"));
  }

  public void glCallCommandListNV(int list) {
    PFNGLCALLCOMMANDLISTNVPROC.invoke(address("glCallCommandListNV"), list);
  }

  public void glVertexAttrib1hvNV(int index, MemorySegment v) {
    PFNGLVERTEXATTRIB1HVNVPROC.invoke(address("glVertexAttrib1hvNV"), index, v);
  }

  public void glColor4ubVertex3fvSUN(MemorySegment c, MemorySegment v) {
    PFNGLCOLOR4UBVERTEX3FVSUNPROC.invoke(address("glColor4ubVertex3fvSUN"), c, v);
  }

  public void glEnableiNV(int target, int index) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexCoord4hNV(int target, short s, short t, short r, short q) {
    PFNGLMULTITEXCOORD4HNVPROC.invoke(address("glMultiTexCoord4hNV"), target, s, t, r, q);
  }

  public void glVertexAttrib4sARB(int index, short x, short y, short z, short w) {
    PFNGLVERTEXATTRIB4SARBPROC.invoke(address("glVertexAttrib4sARB"), index, x, y, z, w);
  }

  public int glGetCommandHeaderNV(int tokenID, int size) {
    return PFNGLGETCOMMANDHEADERNVPROC.invoke(address("glGetCommandHeaderNV"), tokenID, size);
  }

  public void glGetnUniformivKHR(int program, int location, int bufSize, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public byte glUnmapBufferARB(int target) {
    return PFNGLUNMAPBUFFERARBPROC.invoke(address("glUnmapBufferARB"), target);
  }

  public byte glUnmapNamedBufferEXT(int buffer) {
    return PFNGLUNMAPNAMEDBUFFEREXTPROC.invoke(address("glUnmapNamedBufferEXT"), buffer);
  }

  public void glGetNamedProgramLocalParameterdvEXT(int program, int target, int index, MemorySegment params) {
    PFNGLGETNAMEDPROGRAMLOCALPARAMETERDVEXTPROC.invoke(address("glGetNamedProgramLocalParameterdvEXT"), program, target, index, params);
  }

  public void glVertexAttribL3i64NV(int index, long x, long y, long z) {
    PFNGLVERTEXATTRIBL3I64NVPROC.invoke(address("glVertexAttribL3i64NV"), index, x, y, z);
  }

  public void glDeleteSemaphoresEXT(int n, MemorySegment semaphores) {
    PFNGLDELETESEMAPHORESEXTPROC.invoke(address("glDeleteSemaphoresEXT"), n, semaphores);
  }

  public void glGetBufferParameterivARB(int target, int pname, MemorySegment params) {
    PFNGLGETBUFFERPARAMETERIVARBPROC.invoke(address("glGetBufferParameterivARB"), target, pname, params);
  }

  public void glVertexAttrib1svNV(int index, MemorySegment v) {
    PFNGLVERTEXATTRIB1SVNVPROC.invoke(address("glVertexAttrib1svNV"), index, v);
  }

  public void glReadnPixelsKHR(int x, int y, int width, int height, int format, int type, int bufSize, MemorySegment data) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribI3iv(int index, MemorySegment v) {
    PFNGLVERTEXATTRIBI3IVPROC.invoke(address("glVertexAttribI3iv"), index, v);
  }

  public void glUniformMatrix4x3dv(int location, int count, byte transpose, MemorySegment value) {
    PFNGLUNIFORMMATRIX4X3DVPROC.invoke(address("glUniformMatrix4x3dv"), location, count, transpose, value);
  }

  public void glDrawTransformFeedbackInstancedEXT(int mode, int id, int instancecount) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glNormalPointervINTEL(int type, MemorySegment pointer) {
    PFNGLNORMALPOINTERVINTELPROC.invoke(address("glNormalPointervINTEL"), type, pointer);
  }

  public void glUniformMatrix3x4fvNV(int location, int count, byte transpose, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetPathParameterfvNV(int path, int pname, MemorySegment value) {
    PFNGLGETPATHPARAMETERFVNVPROC.invoke(address("glGetPathParameterfvNV"), path, pname, value);
  }

  public MemorySegment glFenceSyncAPPLE(int condition, int flags) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniform2i64NV(int location, long x, long y) {
    PFNGLUNIFORM2I64NVPROC.invoke(address("glUniform2i64NV"), location, x, y);
  }

  public byte glIsShader(int shader) {
    return PFNGLISSHADERPROC.invoke(address("glIsShader"), shader);
  }

  public void glBlendFunci(int buf, int src, int dst) {
    PFNGLBLENDFUNCIPROC.invoke(address("glBlendFunci"), buf, src, dst);
  }

  public void glClipPlanexIMG(int p, MemorySegment eqn) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniform4fvARB(int location, int count, MemorySegment value) {
    PFNGLUNIFORM4FVARBPROC.invoke(address("glUniform4fvARB"), location, count, value);
  }

  public void glGetProgramParameterdvNV(int target, int index, int pname, MemorySegment params) {
    PFNGLGETPROGRAMPARAMETERDVNVPROC.invoke(address("glGetProgramParameterdvNV"), target, index, pname, params);
  }

  public void glPointSizex(int size) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetInternalformati64v(int target, int internalformat, int pname, int count, MemorySegment params) {
    PFNGLGETINTERNALFORMATI64VPROC.invoke(address("glGetInternalformati64v"), target, internalformat, pname, count, params);
  }

  public void glGetNamedBufferParameteriv(int buffer, int pname, MemorySegment params) {
    PFNGLGETNAMEDBUFFERPARAMETERIVPROC.invoke(address("glGetNamedBufferParameteriv"), buffer, pname, params);
  }

  public int glPathGlyphIndexArrayNV(int firstPathName, int fontTarget, MemorySegment fontName, int fontStyle, int firstGlyphIndex, int numGlyphs, int pathParameterTemplate, float emScale) {
    return PFNGLPATHGLYPHINDEXARRAYNVPROC.invoke(address("glPathGlyphIndexArrayNV"), firstPathName, fontTarget, fontName, fontStyle, firstGlyphIndex, numGlyphs, pathParameterTemplate, emScale);
  }

  public void glGetVariantIntegervEXT(int id, int value, MemorySegment data) {
    PFNGLGETVARIANTINTEGERVEXTPROC.invoke(address("glGetVariantIntegervEXT"), id, value, data);
  }

  public void glUniform4ui64vNV(int location, int count, MemorySegment value) {
    PFNGLUNIFORM4UI64VNVPROC.invoke(address("glUniform4ui64vNV"), location, count, value);
  }

  public void glSecondaryColor3uiv(MemorySegment v) {
    PFNGLSECONDARYCOLOR3UIVPROC.invoke(address("glSecondaryColor3uiv"), v);
  }

  public void glFinishFenceAPPLE(int fence) {
    PFNGLFINISHFENCEAPPLEPROC.invoke(address("glFinishFenceAPPLE"), fence);
  }

  public void glUniformMatrix4x3fv(int location, int count, byte transpose, MemorySegment value) {
    PFNGLUNIFORMMATRIX4X3FVPROC.invoke(address("glUniformMatrix4x3fv"), location, count, transpose, value);
  }

  public void glConvolutionFilter2DEXT(int target, int internalformat, int width, int height, int format, int type, MemorySegment image) {
    PFNGLCONVOLUTIONFILTER2DEXTPROC.invoke(address("glConvolutionFilter2DEXT"), target, internalformat, width, height, format, type, image);
  }

  public void glVertexBindingDivisor(int bindingindex, int divisor) {
    PFNGLVERTEXBINDINGDIVISORPROC.invoke(address("glVertexBindingDivisor"), bindingindex, divisor);
  }

  public void glDrawBuffersARB(int n, MemorySegment bufs) {
    PFNGLDRAWBUFFERSARBPROC.invoke(address("glDrawBuffersARB"), n, bufs);
  }

  public void glDebugMessageCallbackKHR(MemorySegment callback, MemorySegment userParam) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniform4i64vNV(int program, int location, int count, MemorySegment value) {
    PFNGLPROGRAMUNIFORM4I64VNVPROC.invoke(address("glProgramUniform4i64vNV"), program, location, count, value);
  }

  public void glGenTransformFeedbacks(int n, MemorySegment ids) {
    PFNGLGENTRANSFORMFEEDBACKSPROC.invoke(address("glGenTransformFeedbacks"), n, ids);
  }

  public void glVertexAttrib2dNV(int index, double x, double y) {
    PFNGLVERTEXATTRIB2DNVPROC.invoke(address("glVertexAttrib2dNV"), index, x, y);
  }

  public void glSecondaryColorFormatNV(int size, int type, int stride) {
    PFNGLSECONDARYCOLORFORMATNVPROC.invoke(address("glSecondaryColorFormatNV"), size, type, stride);
  }

  public void glSetFragmentShaderConstantATI(int dst, MemorySegment value) {
    PFNGLSETFRAGMENTSHADERCONSTANTATIPROC.invoke(address("glSetFragmentShaderConstantATI"), dst, value);
  }

  public void glMakeBufferResidentNV(int target, int access) {
    PFNGLMAKEBUFFERRESIDENTNVPROC.invoke(address("glMakeBufferResidentNV"), target, access);
  }

  public void glEGLImageTargetTextureStorageEXT(int texture, MemorySegment image, MemorySegment attrib_list) {
    PFNGLEGLIMAGETARGETTEXTURESTORAGEEXTPROC.invoke(address("glEGLImageTargetTextureStorageEXT"), texture, image, attrib_list);
  }

  public void glVertexAttrib3fv(int index, MemorySegment v) {
    PFNGLVERTEXATTRIB3FVPROC.invoke(address("glVertexAttrib3fv"), index, v);
  }

  public void glGetPixelMapxv(int map, int size, MemorySegment values) {
    PFNGLGETPIXELMAPXVPROC.invoke(address("glGetPixelMapxv"), map, size, values);
  }

  public void glVertexAttribI4usvEXT(int index, MemorySegment v) {
    PFNGLVERTEXATTRIBI4USVEXTPROC.invoke(address("glVertexAttribI4usvEXT"), index, v);
  }

  public void glDisableiNV(int target, int index) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public byte glVDPAUIsSurfaceNV(long surface) {
    return PFNGLVDPAUISSURFACENVPROC.invoke(address("glVDPAUIsSurfaceNV"), surface);
  }

  public void glBlendEquationSeparate(int modeRGB, int modeAlpha) {
    PFNGLBLENDEQUATIONSEPARATEPROC.invoke(address("glBlendEquationSeparate"), modeRGB, modeAlpha);
  }

  public void glGetTextureLevelParameterfvEXT(int texture, int target, int level, int pname, MemorySegment params) {
    PFNGLGETTEXTURELEVELPARAMETERFVEXTPROC.invoke(address("glGetTextureLevelParameterfvEXT"), texture, target, level, pname, params);
  }

  public void glImageTransformParameterivHP(int target, int pname, MemorySegment params) {
    PFNGLIMAGETRANSFORMPARAMETERIVHPPROC.invoke(address("glImageTransformParameterivHP"), target, pname, params);
  }

  public void glColorFormatNV(int size, int type, int stride) {
    PFNGLCOLORFORMATNVPROC.invoke(address("glColorFormatNV"), size, type, stride);
  }

  public void glGetUniformuiv(int program, int location, MemorySegment params) {
    PFNGLGETUNIFORMUIVPROC.invoke(address("glGetUniformuiv"), program, location, params);
  }

  public void glVertex3bOES(byte x, byte y, byte z) {
    PFNGLVERTEX3BOESPROC.invoke(address("glVertex3bOES"), x, y, z);
  }

  public void glProgramUniform4fEXT(int program, int location, float v0, float v1, float v2, float v3) {
    PFNGLPROGRAMUNIFORM4FEXTPROC.invoke(address("glProgramUniform4fEXT"), program, location, v0, v1, v2, v3);
  }

  public void glTransformFeedbackVaryingsNV(int program, int count, MemorySegment locations, int bufferMode) {
    PFNGLTRANSFORMFEEDBACKVARYINGSNVPROC.invoke(address("glTransformFeedbackVaryingsNV"), program, count, locations, bufferMode);
  }

  public void glSecondaryColor3ubv(MemorySegment v) {
    PFNGLSECONDARYCOLOR3UBVPROC.invoke(address("glSecondaryColor3ubv"), v);
  }

  public void glDeleteVertexArraysAPPLE(int n, MemorySegment arrays) {
    PFNGLDELETEVERTEXARRAYSAPPLEPROC.invoke(address("glDeleteVertexArraysAPPLE"), n, arrays);
  }

  public void glGetPathMetricsNV(int metricQueryMask, int numPaths, int pathNameType, MemorySegment paths, int pathBase, int stride, MemorySegment metrics) {
    PFNGLGETPATHMETRICSNVPROC.invoke(address("glGetPathMetricsNV"), metricQueryMask, numPaths, pathNameType, paths, pathBase, stride, metrics);
  }

  public void glProgramUniform3dEXT(int program, int location, double x, double y, double z) {
    PFNGLPROGRAMUNIFORM3DEXTPROC.invoke(address("glProgramUniform3dEXT"), program, location, x, y, z);
  }

  public void glProgramUniformMatrix4x3fv(int program, int location, int count, byte transpose, MemorySegment value) {
    PFNGLPROGRAMUNIFORMMATRIX4X3FVPROC.invoke(address("glProgramUniformMatrix4x3fv"), program, location, count, transpose, value);
  }

  public void glDisableClientStateIndexedEXT(int array, int index) {
    PFNGLDISABLECLIENTSTATEINDEXEDEXTPROC.invoke(address("glDisableClientStateIndexedEXT"), array, index);
  }

  public void glGetMultiTexLevelParameterivEXT(int texunit, int target, int level, int pname, MemorySegment params) {
    PFNGLGETMULTITEXLEVELPARAMETERIVEXTPROC.invoke(address("glGetMultiTexLevelParameterivEXT"), texunit, target, level, pname, params);
  }

  public void glMultiTexCoord4x(int texture, int s, int t, int r, int q) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glPathGlyphsNV(int firstPathName, int fontTarget, MemorySegment fontName, int fontStyle, int numGlyphs, int type, MemorySegment charcodes, int handleMissingGlyphs, int pathParameterTemplate, float emScale) {
    PFNGLPATHGLYPHSNVPROC.invoke(address("glPathGlyphsNV"), firstPathName, fontTarget, fontName, fontStyle, numGlyphs, type, charcodes, handleMissingGlyphs, pathParameterTemplate, emScale);
  }

  public void glVertex3xOES(int x, int y) {
    PFNGLVERTEX3XOESPROC.invoke(address("glVertex3xOES"), x, y);
  }

  public void glNamedFramebufferDrawBuffers(int framebuffer, int n, MemorySegment bufs) {
    PFNGLNAMEDFRAMEBUFFERDRAWBUFFERSPROC.invoke(address("glNamedFramebufferDrawBuffers"), framebuffer, n, bufs);
  }

  public void glVertexAttribI4iEXT(int index, int x, int y, int z, int w) {
    PFNGLVERTEXATTRIBI4IEXTPROC.invoke(address("glVertexAttribI4iEXT"), index, x, y, z, w);
  }

  public void glMultiDrawElementsIndirectBindlessCountNV(int mode, int type, MemorySegment indirect, int drawCount, int maxDrawCount, int stride, int vertexBufferCount) {
    PFNGLMULTIDRAWELEMENTSINDIRECTBINDLESSCOUNTNVPROC.invoke(address("glMultiDrawElementsIndirectBindlessCountNV"), mode, type, indirect, drawCount, maxDrawCount, stride, vertexBufferCount);
  }

  public int glCreateProgramObjectARB() {
    return PFNGLCREATEPROGRAMOBJECTARBPROC.invoke(address("glCreateProgramObjectARB"));
  }

  public void glBindBufferARB(int target, int buffer) {
    PFNGLBINDBUFFERARBPROC.invoke(address("glBindBufferARB"), target, buffer);
  }

  public void glTextureParameterfEXT(int texture, int target, int pname, float param) {
    PFNGLTEXTUREPARAMETERFEXTPROC.invoke(address("glTextureParameterfEXT"), texture, target, pname, param);
  }

  public void glVertexAttrib3dv(int index, MemorySegment v) {
    PFNGLVERTEXATTRIB3DVPROC.invoke(address("glVertexAttrib3dv"), index, v);
  }

  public void glDrawElementsBaseVertex(int mode, int count, int type, MemorySegment indices, int basevertex) {
    PFNGLDRAWELEMENTSBASEVERTEXPROC.invoke(address("glDrawElementsBaseVertex"), mode, count, type, indices, basevertex);
  }

  public void glVertexAttribL4dv(int index, MemorySegment v) {
    PFNGLVERTEXATTRIBL4DVPROC.invoke(address("glVertexAttribL4dv"), index, v);
  }

  public void glUniform4fARB(int location, float v0, float v1, float v2, float v3) {
    PFNGLUNIFORM4FARBPROC.invoke(address("glUniform4fARB"), location, v0, v1, v2, v3);
  }

  public void glWindowPos2ivMESA(MemorySegment v) {
    PFNGLWINDOWPOS2IVMESAPROC.invoke(address("glWindowPos2ivMESA"), v);
  }

  public void glFlushMappedBufferRangeEXT(int target, long offset, long length) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetnPixelMapfv(int map, int bufSize, MemorySegment values) {
    PFNGLGETNPIXELMAPFVPROC.invoke(address("glGetnPixelMapfv"), map, bufSize, values);
  }

  public void glGetFogFuncSGIS(MemorySegment points) {
    PFNGLGETFOGFUNCSGISPROC.invoke(address("glGetFogFuncSGIS"), points);
  }

  public void glProgramUniform1ui(int program, int location, int v0) {
    PFNGLPROGRAMUNIFORM1UIPROC.invoke(address("glProgramUniform1ui"), program, location, v0);
  }

  public void glUniform3ivARB(int location, int count, MemorySegment value) {
    PFNGLUNIFORM3IVARBPROC.invoke(address("glUniform3ivARB"), location, count, value);
  }

  public void glDiscardFramebufferEXT(int target, int numAttachments, MemorySegment attachments) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniformMatrix4x3dv(int program, int location, int count, byte transpose, MemorySegment value) {
    PFNGLPROGRAMUNIFORMMATRIX4X3DVPROC.invoke(address("glProgramUniformMatrix4x3dv"), program, location, count, transpose, value);
  }

  public void glVertex3xvOES(MemorySegment coords) {
    PFNGLVERTEX3XVOESPROC.invoke(address("glVertex3xvOES"), coords);
  }

  public int glCreateShaderObjectARB(int shaderType) {
    return PFNGLCREATESHADEROBJECTARBPROC.invoke(address("glCreateShaderObjectARB"), shaderType);
  }

  public void glMapVertexAttrib2fAPPLE(int index, int size, float u1, float u2, int ustride, int uorder, float v1, float v2, int vstride, int vorder, MemorySegment points) {
    PFNGLMAPVERTEXATTRIB2FAPPLEPROC.invoke(address("glMapVertexAttrib2fAPPLE"), index, size, u1, u2, ustride, uorder, v1, v2, vstride, vorder, points);
  }

  public void glCullParameterdvEXT(int pname, MemorySegment params) {
    PFNGLCULLPARAMETERDVEXTPROC.invoke(address("glCullParameterdvEXT"), pname, params);
  }

  public void glVertexStream2sATI(int stream, short x, short y) {
    PFNGLVERTEXSTREAM2SATIPROC.invoke(address("glVertexStream2sATI"), stream, x, y);
  }

  public void glVertexAttrib4dv(int index, MemorySegment v) {
    PFNGLVERTEXATTRIB4DVPROC.invoke(address("glVertexAttrib4dv"), index, v);
  }

  public void glListParameterivSGIX(int list, int pname, MemorySegment params) {
    PFNGLLISTPARAMETERIVSGIXPROC.invoke(address("glListParameterivSGIX"), list, pname, params);
  }

  public void glRenderbufferStorage(int target, int internalformat, int width, int height) {
    PFNGLRENDERBUFFERSTORAGEPROC.invoke(address("glRenderbufferStorage"), target, internalformat, width, height);
  }

  public void glVertexArrayBindVertexBufferEXT(int vaobj, int bindingindex, int buffer, long offset, int stride) {
    PFNGLVERTEXARRAYBINDVERTEXBUFFEREXTPROC.invoke(address("glVertexArrayBindVertexBufferEXT"), vaobj, bindingindex, buffer, offset, stride);
  }

  public void glWindowPos4ivMESA(MemorySegment v) {
    PFNGLWINDOWPOS4IVMESAPROC.invoke(address("glWindowPos4ivMESA"), v);
  }

  public void glTextureStorageMem2DEXT(int texture, int levels, int internalFormat, int width, int height, int memory, long offset) {
    PFNGLTEXTURESTORAGEMEM2DEXTPROC.invoke(address("glTextureStorageMem2DEXT"), texture, levels, internalFormat, width, height, memory, offset);
  }

  public void glGetListParameterfvSGIX(int list, int pname, MemorySegment params) {
    PFNGLGETLISTPARAMETERFVSGIXPROC.invoke(address("glGetListParameterfvSGIX"), list, pname, params);
  }

  public void glPathStencilFuncNV(int func, int ref, int mask) {
    PFNGLPATHSTENCILFUNCNVPROC.invoke(address("glPathStencilFuncNV"), func, ref, mask);
  }

  public void glAlphaFragmentOp3ATI(int op, int dst, int dstMod, int arg1, int arg1Rep, int arg1Mod, int arg2, int arg2Rep, int arg2Mod, int arg3, int arg3Rep, int arg3Mod) {
    PFNGLALPHAFRAGMENTOP3ATIPROC.invoke(address("glAlphaFragmentOp3ATI"), op, dst, dstMod, arg1, arg1Rep, arg1Mod, arg2, arg2Rep, arg2Mod, arg3, arg3Rep, arg3Mod);
  }

  public void glProgramUniformHandleui64IMG(int program, int location, long value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glSampleCoveragex(int value, byte invert) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetInvariantBooleanvEXT(int id, int value, MemorySegment data) {
    PFNGLGETINVARIANTBOOLEANVEXTPROC.invoke(address("glGetInvariantBooleanvEXT"), id, value, data);
  }

  public void glGetMultiTexParameterIuivEXT(int texunit, int target, int pname, MemorySegment params) {
    PFNGLGETMULTITEXPARAMETERIUIVEXTPROC.invoke(address("glGetMultiTexParameterIuivEXT"), texunit, target, pname, params);
  }

  public void glGetInteger64v(int pname, MemorySegment data) {
    PFNGLGETINTEGER64VPROC.invoke(address("glGetInteger64v"), pname, data);
  }

  public void glSamplerParameterIivOES(int sampler, int pname, MemorySegment param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetTexParameterIuivEXT(int target, int pname, MemorySegment params) {
    PFNGLGETTEXPARAMETERIUIVEXTPROC.invoke(address("glGetTexParameterIuivEXT"), target, pname, params);
  }

  public void glWindowPos2fv(MemorySegment v) {
    PFNGLWINDOWPOS2FVPROC.invoke(address("glWindowPos2fv"), v);
  }

  public void glAlphaFuncQCOM(int func, float ref) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public int glFinishAsyncSGIX(MemorySegment markerp) {
    return PFNGLFINISHASYNCSGIXPROC.invoke(address("glFinishAsyncSGIX"), markerp);
  }

  public void glGetSynciv(MemorySegment sync, int pname, int count, MemorySegment length, MemorySegment values) {
    PFNGLGETSYNCIVPROC.invoke(address("glGetSynciv"), sync, pname, count, length, values);
  }

  public void glWindowPos3fMESA(float x, float y, float z) {
    PFNGLWINDOWPOS3FMESAPROC.invoke(address("glWindowPos3fMESA"), x, y, z);
  }

  public void glVertexArraySecondaryColorOffsetEXT(int vaobj, int buffer, int size, int type, int stride, long offset) {
    PFNGLVERTEXARRAYSECONDARYCOLOROFFSETEXTPROC.invoke(address("glVertexArraySecondaryColorOffsetEXT"), vaobj, buffer, size, type, stride, offset);
  }

  public void glVertexAttrib4bv(int index, MemorySegment v) {
    PFNGLVERTEXATTRIB4BVPROC.invoke(address("glVertexAttrib4bv"), index, v);
  }

  public void glProgramParameter4dvNV(int target, int index, MemorySegment v) {
    PFNGLPROGRAMPARAMETER4DVNVPROC.invoke(address("glProgramParameter4dvNV"), target, index, v);
  }

  public void glProgramNamedParameter4dNV(int id, int len, MemorySegment name, double x, double y, double z, double w) {
    PFNGLPROGRAMNAMEDPARAMETER4DNVPROC.invoke(address("glProgramNamedParameter4dNV"), id, len, name, x, y, z, w);
  }

  public void glMultiTexEnviEXT(int texunit, int target, int pname, int param) {
    PFNGLMULTITEXENVIEXTPROC.invoke(address("glMultiTexEnviEXT"), texunit, target, pname, param);
  }

  public void glVertexAttrib4sNV(int index, short x, short y, short z, short w) {
    PFNGLVERTEXATTRIB4SNVPROC.invoke(address("glVertexAttrib4sNV"), index, x, y, z, w);
  }

  public void glConservativeRasterParameterfNV(int pname, float value) {
    PFNGLCONSERVATIVERASTERPARAMETERFNVPROC.invoke(address("glConservativeRasterParameterfNV"), pname, value);
  }

  public void glBindImageTextureEXT(int index, int texture, int level, byte layered, int layer, int access, int format) {
    PFNGLBINDIMAGETEXTUREEXTPROC.invoke(address("glBindImageTextureEXT"), index, texture, level, layered, layer, access, format);
  }

  public void glVertexStream1fATI(int stream, float x) {
    PFNGLVERTEXSTREAM1FATIPROC.invoke(address("glVertexStream1fATI"), stream, x);
  }

  public void glExtGetProgramBinarySourceQCOM(int program, int shadertype, MemorySegment source, MemorySegment length) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glImportSemaphoreFdEXT(int semaphore, int handleType, int fd) {
    PFNGLIMPORTSEMAPHOREFDEXTPROC.invoke(address("glImportSemaphoreFdEXT"), semaphore, handleType, fd);
  }

  public void glGenBuffers(int n, MemorySegment buffers) {
    PFNGLGENBUFFERSPROC.invoke(address("glGenBuffers"), n, buffers);
  }

  public void glMultiDrawArraysIndirectBindlessNV(int mode, MemorySegment indirect, int drawCount, int stride, int vertexBufferCount) {
    PFNGLMULTIDRAWARRAYSINDIRECTBINDLESSNVPROC.invoke(address("glMultiDrawArraysIndirectBindlessNV"), mode, indirect, drawCount, stride, vertexBufferCount);
  }

  public void glMulticastGetQueryObjectuivNV(int gpu, int id, int pname, MemorySegment params) {
    PFNGLMULTICASTGETQUERYOBJECTUIVNVPROC.invoke(address("glMulticastGetQueryObjectuivNV"), gpu, id, pname, params);
  }

  public void glNamedRenderbufferStorageEXT(int renderbuffer, int internalformat, int width, int height) {
    PFNGLNAMEDRENDERBUFFERSTORAGEEXTPROC.invoke(address("glNamedRenderbufferStorageEXT"), renderbuffer, internalformat, width, height);
  }

  public void glReplacementCodeuiTexCoord2fColor4fNormal3fVertex3fSUN(int rc, float s, float t, float r, float g, float b, float a, float nx, float ny, float nz, float x, float y, float z) {
    PFNGLREPLACEMENTCODEUITEXCOORD2FCOLOR4FNORMAL3FVERTEX3FSUNPROC.invoke(address("glReplacementCodeuiTexCoord2fColor4fNormal3fVertex3fSUN"), rc, s, t, r, g, b, a, nx, ny, nz, x, y, z);
  }

  public void glVertexAttrib3dvNV(int index, MemorySegment v) {
    PFNGLVERTEXATTRIB3DVNVPROC.invoke(address("glVertexAttrib3dvNV"), index, v);
  }

  public void glWindowPos2dv(MemorySegment v) {
    PFNGLWINDOWPOS2DVPROC.invoke(address("glWindowPos2dv"), v);
  }

  public void glProgramUniform3ui64ARB(int program, int location, long x, long y, long z) {
    PFNGLPROGRAMUNIFORM3UI64ARBPROC.invoke(address("glProgramUniform3ui64ARB"), program, location, x, y, z);
  }

  public void glVertexAttribIFormatNV(int index, int size, int type, int stride) {
    PFNGLVERTEXATTRIBIFORMATNVPROC.invoke(address("glVertexAttribIFormatNV"), index, size, type, stride);
  }

  public void glCurrentPaletteMatrixOES(int matrixpaletteindex) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFramebufferTextureOES(int target, int attachment, int texture, int level) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexCoord4xvOES(int texture, MemorySegment coords) {
    PFNGLMULTITEXCOORD4XVOESPROC.invoke(address("glMultiTexCoord4xvOES"), texture, coords);
  }

  public int glCreateShaderProgramv(int type, int count, MemorySegment strings) {
    return PFNGLCREATESHADERPROGRAMVPROC.invoke(address("glCreateShaderProgramv"), type, count, strings);
  }

  public void glGetnSeparableFilterARB(int target, int format, int type, int rowBufSize, MemorySegment row, int columnBufSize, MemorySegment column, MemorySegment span) {
    PFNGLGETNSEPARABLEFILTERARBPROC.invoke(address("glGetnSeparableFilterARB"), target, format, type, rowBufSize, row, columnBufSize, column, span);
  }

  public void glProgramUniformMatrix4fv(int program, int location, int count, byte transpose, MemorySegment value) {
    PFNGLPROGRAMUNIFORMMATRIX4FVPROC.invoke(address("glProgramUniformMatrix4fv"), program, location, count, transpose, value);
  }

  public void glGetTransformFeedbackVarying(int program, int index, int bufSize, MemorySegment length, MemorySegment size, MemorySegment type, MemorySegment name) {
    PFNGLGETTRANSFORMFEEDBACKVARYINGPROC.invoke(address("glGetTransformFeedbackVarying"), program, index, bufSize, length, size, type, name);
  }

  public void glVertexAttrib4fvNV(int index, MemorySegment v) {
    PFNGLVERTEXATTRIB4FVNVPROC.invoke(address("glVertexAttrib4fvNV"), index, v);
  }

  public void glSubpixelPrecisionBiasNV(int xbits, int ybits) {
    PFNGLSUBPIXELPRECISIONBIASNVPROC.invoke(address("glSubpixelPrecisionBiasNV"), xbits, ybits);
  }

  public void glDrawBuffersATI(int n, MemorySegment bufs) {
    PFNGLDRAWBUFFERSATIPROC.invoke(address("glDrawBuffersATI"), n, bufs);
  }

  public void glFogxv(int pname, MemorySegment param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniform2uiEXT(int program, int location, int v0, int v1) {
    PFNGLPROGRAMUNIFORM2UIEXTPROC.invoke(address("glProgramUniform2uiEXT"), program, location, v0, v1);
  }

  public void glVertexAttribLFormat(int attribindex, int size, int type, int relativeoffset) {
    PFNGLVERTEXATTRIBLFORMATPROC.invoke(address("glVertexAttribLFormat"), attribindex, size, type, relativeoffset);
  }

  public void glDisableIndexedEXT(int target, int index) {
    PFNGLDISABLEINDEXEDEXTPROC.invoke(address("glDisableIndexedEXT"), target, index);
  }

  public int glGetDebugMessageLogKHR(int count, int bufSize, MemorySegment sources, MemorySegment types, MemorySegment ids, MemorySegment severities, MemorySegment lengths, MemorySegment messageLog) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttrib4dvARB(int index, MemorySegment v) {
    PFNGLVERTEXATTRIB4DVARBPROC.invoke(address("glVertexAttrib4dvARB"), index, v);
  }

  public void glTexImage4DSGIS(int target, int level, int internalformat, int width, int height, int depth, int size4d, int border, int format, int type, MemorySegment pixels) {
    PFNGLTEXIMAGE4DSGISPROC.invoke(address("glTexImage4DSGIS"), target, level, internalformat, width, height, depth, size4d, border, format, type, pixels);
  }

  public void glProgramUniformMatrix4dv(int program, int location, int count, byte transpose, MemorySegment value) {
    PFNGLPROGRAMUNIFORMMATRIX4DVPROC.invoke(address("glProgramUniformMatrix4dv"), program, location, count, transpose, value);
  }

  public void glDeleteTexturesEXT(int n, MemorySegment textures) {
    PFNGLDELETETEXTURESEXTPROC.invoke(address("glDeleteTexturesEXT"), n, textures);
  }

  public void glNamedFramebufferReadBuffer(int framebuffer, int src) {
    PFNGLNAMEDFRAMEBUFFERREADBUFFERPROC.invoke(address("glNamedFramebufferReadBuffer"), framebuffer, src);
  }

  public void glGetVideoCaptureivNV(int video_capture_slot, int pname, MemorySegment params) {
    PFNGLGETVIDEOCAPTUREIVNVPROC.invoke(address("glGetVideoCaptureivNV"), video_capture_slot, pname, params);
  }

  public void glNormalStream3dvATI(int stream, MemorySegment coords) {
    PFNGLNORMALSTREAM3DVATIPROC.invoke(address("glNormalStream3dvATI"), stream, coords);
  }

  public void glTangent3bvEXT(MemorySegment v) {
    PFNGLTANGENT3BVEXTPROC.invoke(address("glTangent3bvEXT"), v);
  }

  public void glWindowPos2iv(MemorySegment v) {
    PFNGLWINDOWPOS2IVPROC.invoke(address("glWindowPos2iv"), v);
  }

  public void glVertexArrayAttribLFormat(int vaobj, int attribindex, int size, int type, int relativeoffset) {
    PFNGLVERTEXARRAYATTRIBLFORMATPROC.invoke(address("glVertexArrayAttribLFormat"), vaobj, attribindex, size, type, relativeoffset);
  }

  public void glTexSubImage1DEXT(int target, int level, int xoffset, int width, int format, int type, MemorySegment pixels) {
    PFNGLTEXSUBIMAGE1DEXTPROC.invoke(address("glTexSubImage1DEXT"), target, level, xoffset, width, format, type, pixels);
  }

  public void glGetProgramSubroutineParameteruivNV(int target, int index, MemorySegment param) {
    PFNGLGETPROGRAMSUBROUTINEPARAMETERUIVNVPROC.invoke(address("glGetProgramSubroutineParameteruivNV"), target, index, param);
  }

  public void glTessellationFactorAMD(float factor) {
    PFNGLTESSELLATIONFACTORAMDPROC.invoke(address("glTessellationFactorAMD"), factor);
  }

  public void glDrawTexfvOES(MemorySegment coords) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBlendBarrierKHR() {
    PFNGLBLENDBARRIERKHRPROC.invoke(address("glBlendBarrierKHR"));
  }

  public void glDrawVkImageNV(long vkImage, int sampler, float x0, float y0, float x1, float y1, float z, float s0, float t0, float s1, float t1) {
    PFNGLDRAWVKIMAGENVPROC.invoke(address("glDrawVkImageNV"), vkImage, sampler, x0, y0, x1, y1, z, s0, t0, s1, t1);
  }

  public void glVertexAttribI3ui(int index, int x, int y, int z) {
    PFNGLVERTEXATTRIBI3UIPROC.invoke(address("glVertexAttribI3ui"), index, x, y, z);
  }

  public void glWindowPos3fvMESA(MemorySegment v) {
    PFNGLWINDOWPOS3FVMESAPROC.invoke(address("glWindowPos3fvMESA"), v);
  }

  public void glMulticastGetQueryObjectui64vNV(int gpu, int id, int pname, MemorySegment params) {
    PFNGLMULTICASTGETQUERYOBJECTUI64VNVPROC.invoke(address("glMulticastGetQueryObjectui64vNV"), gpu, id, pname, params);
  }

  public void glTextureBufferRangeEXT(int texture, int target, int internalformat, int buffer, long offset, long size) {
    PFNGLTEXTUREBUFFERRANGEEXTPROC.invoke(address("glTextureBufferRangeEXT"), texture, target, internalformat, buffer, offset, size);
  }

  public void glProgramBinaryOES(int program, int binaryFormat, MemorySegment binary, int length) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetLightxOES(int light, int pname, MemorySegment params) {
    PFNGLGETLIGHTXOESPROC.invoke(address("glGetLightxOES"), light, pname, params);
  }

  public void glEndConditionalRenderNV() {
    PFNGLENDCONDITIONALRENDERNVPROC.invoke(address("glEndConditionalRenderNV"));
  }

  public void glPatchParameteri(int pname, int value) {
    PFNGLPATCHPARAMETERIPROC.invoke(address("glPatchParameteri"), pname, value);
  }

  public void glMultiDrawElementsIndirectBindlessNV(int mode, int type, MemorySegment indirect, int drawCount, int stride, int vertexBufferCount) {
    PFNGLMULTIDRAWELEMENTSINDIRECTBINDLESSNVPROC.invoke(address("glMultiDrawElementsIndirectBindlessNV"), mode, type, indirect, drawCount, stride, vertexBufferCount);
  }

  public void glDeleteBuffersARB(int n, MemorySegment buffers) {
    PFNGLDELETEBUFFERSARBPROC.invoke(address("glDeleteBuffersARB"), n, buffers);
  }

  public void glVertexAttribL3ui64vNV(int index, MemorySegment v) {
    PFNGLVERTEXATTRIBL3UI64VNVPROC.invoke(address("glVertexAttribL3ui64vNV"), index, v);
  }

  public void glGetArrayObjectivATI(int array, int pname, MemorySegment params) {
    PFNGLGETARRAYOBJECTIVATIPROC.invoke(address("glGetArrayObjectivATI"), array, pname, params);
  }

  public void glBlendBarrierNV() {
    PFNGLBLENDBARRIERNVPROC.invoke(address("glBlendBarrierNV"));
  }

  public void glNormalStream3svATI(int stream, MemorySegment coords) {
    PFNGLNORMALSTREAM3SVATIPROC.invoke(address("glNormalStream3svATI"), stream, coords);
  }

  public void glTangent3dEXT(double tx, double ty, double tz) {
    PFNGLTANGENT3DEXTPROC.invoke(address("glTangent3dEXT"), tx, ty, tz);
  }

  public void glVariantusvEXT(int id, MemorySegment addr) {
    PFNGLVARIANTUSVEXTPROC.invoke(address("glVariantusvEXT"), id, addr);
  }

  public void glLightxOES(int light, int pname, int param) {
    PFNGLLIGHTXOESPROC.invoke(address("glLightxOES"), light, pname, param);
  }

  public void glDepthBoundsEXT(double zmin, double zmax) {
    PFNGLDEPTHBOUNDSEXTPROC.invoke(address("glDepthBoundsEXT"), zmin, zmax);
  }

  public void glProgramUniform3uivEXT(int program, int location, int count, MemorySegment value) {
    PFNGLPROGRAMUNIFORM3UIVEXTPROC.invoke(address("glProgramUniform3uivEXT"), program, location, count, value);
  }

  public void glGetVertexArrayPointervEXT(int vaobj, int pname, MemorySegment param) {
    PFNGLGETVERTEXARRAYPOINTERVEXTPROC.invoke(address("glGetVertexArrayPointervEXT"), vaobj, pname, param);
  }

  public void glTexPageCommitmentARB(int target, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, byte commit) {
    PFNGLTEXPAGECOMMITMENTARBPROC.invoke(address("glTexPageCommitmentARB"), target, level, xoffset, yoffset, zoffset, width, height, depth, commit);
  }

  public void glCompileShaderARB(int shaderObj) {
    PFNGLCOMPILESHADERARBPROC.invoke(address("glCompileShaderARB"), shaderObj);
  }

  public void glBinormal3sEXT(short bx, short by, short bz) {
    PFNGLBINORMAL3SEXTPROC.invoke(address("glBinormal3sEXT"), bx, by, bz);
  }

  public void glBeginVideoCaptureNV(int video_capture_slot) {
    PFNGLBEGINVIDEOCAPTURENVPROC.invoke(address("glBeginVideoCaptureNV"), video_capture_slot);
  }

  public void glCompressedMultiTexImage1DEXT(int texunit, int target, int level, int internalformat, int width, int border, int imageSize, MemorySegment bits) {
    PFNGLCOMPRESSEDMULTITEXIMAGE1DEXTPROC.invoke(address("glCompressedMultiTexImage1DEXT"), texunit, target, level, internalformat, width, border, imageSize, bits);
  }

  public void glClearNamedBufferSubDataEXT(int buffer, int internalformat, long offset, long size, int format, int type, MemorySegment data) {
    PFNGLCLEARNAMEDBUFFERSUBDATAEXTPROC.invoke(address("glClearNamedBufferSubDataEXT"), buffer, internalformat, offset, size, format, type, data);
  }

  public void glGetInvariantIntegervEXT(int id, int value, MemorySegment data) {
    PFNGLGETINVARIANTINTEGERVEXTPROC.invoke(address("glGetInvariantIntegervEXT"), id, value, data);
  }

  public void glCreateSemaphoresNV(int n, MemorySegment semaphores) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexCoord1bOES(int texture, byte s) {
    PFNGLMULTITEXCOORD1BOESPROC.invoke(address("glMultiTexCoord1bOES"), texture, s);
  }

  public void glConvolutionParameterxvOES(int target, int pname, MemorySegment params) {
    PFNGLCONVOLUTIONPARAMETERXVOESPROC.invoke(address("glConvolutionParameterxvOES"), target, pname, params);
  }

  public byte glIsTransformFeedbackNV(int id) {
    return PFNGLISTRANSFORMFEEDBACKNVPROC.invoke(address("glIsTransformFeedbackNV"), id);
  }

  public void glRectxOES(int x1, int y1, int x2, int y2) {
    PFNGLRECTXOESPROC.invoke(address("glRectxOES"), x1, y1, x2, y2);
  }

  public void glNormal3fVertex3fvSUN(MemorySegment n, MemorySegment v) {
    PFNGLNORMAL3FVERTEX3FVSUNPROC.invoke(address("glNormal3fVertex3fvSUN"), n, v);
  }

  public void glBindRenderbufferEXT(int target, int renderbuffer) {
    PFNGLBINDRENDERBUFFEREXTPROC.invoke(address("glBindRenderbufferEXT"), target, renderbuffer);
  }

  public void glFramebufferTextureFaceEXT(int target, int attachment, int texture, int level, int face) {
    PFNGLFRAMEBUFFERTEXTUREFACEEXTPROC.invoke(address("glFramebufferTextureFaceEXT"), target, attachment, texture, level, face);
  }

  public void glGetMaterialxOES(int face, int pname, int param) {
    PFNGLGETMATERIALXOESPROC.invoke(address("glGetMaterialxOES"), face, pname, param);
  }

  public void glMultiTexCoord1xOES(int texture, int s) {
    PFNGLMULTITEXCOORD1XOESPROC.invoke(address("glMultiTexCoord1xOES"), texture, s);
  }

  public void glViewportIndexedfv(int index, MemorySegment v) {
    PFNGLVIEWPORTINDEXEDFVPROC.invoke(address("glViewportIndexedfv"), index, v);
  }

  public void glDrawArraysInstancedARB(int mode, int first, int count, int primcount) {
    PFNGLDRAWARRAYSINSTANCEDARBPROC.invoke(address("glDrawArraysInstancedARB"), mode, first, count, primcount);
  }

  public void glProgramParameters4dvNV(int target, int index, int count, MemorySegment v) {
    PFNGLPROGRAMPARAMETERS4DVNVPROC.invoke(address("glProgramParameters4dvNV"), target, index, count, v);
  }

  public void glBlendEquationSeparatei(int buf, int modeRGB, int modeAlpha) {
    PFNGLBLENDEQUATIONSEPARATEIPROC.invoke(address("glBlendEquationSeparatei"), buf, modeRGB, modeAlpha);
  }

  public void glGetNamedBufferSubData(int buffer, long offset, long size, MemorySegment data) {
    PFNGLGETNAMEDBUFFERSUBDATAPROC.invoke(address("glGetNamedBufferSubData"), buffer, offset, size, data);
  }

  public void glTransformFeedbackStreamAttribsNV(int count, MemorySegment attribs, int nbuffers, MemorySegment bufstreams, int bufferMode) {
    PFNGLTRANSFORMFEEDBACKSTREAMATTRIBSNVPROC.invoke(address("glTransformFeedbackStreamAttribsNV"), count, attribs, nbuffers, bufstreams, bufferMode);
  }

  public void glProgramUniformMatrix2fvEXT(int program, int location, int count, byte transpose, MemorySegment value) {
    PFNGLPROGRAMUNIFORMMATRIX2FVEXTPROC.invoke(address("glProgramUniformMatrix2fvEXT"), program, location, count, transpose, value);
  }

  public void glPushGroupMarkerEXT(int length, MemorySegment marker) {
    PFNGLPUSHGROUPMARKEREXTPROC.invoke(address("glPushGroupMarkerEXT"), length, marker);
  }

  public void glFramebufferFetchBarrierQCOM() {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glPixelTexGenParameterfSGIS(int pname, float param) {
    PFNGLPIXELTEXGENPARAMETERFSGISPROC.invoke(address("glPixelTexGenParameterfSGIS"), pname, param);
  }

  public void glProgramEnvParameter4dvARB(int target, int index, MemorySegment params) {
    PFNGLPROGRAMENVPARAMETER4DVARBPROC.invoke(address("glProgramEnvParameter4dvARB"), target, index, params);
  }

  public void glGetnMapdvARB(int target, int query, int bufSize, MemorySegment v) {
    PFNGLGETNMAPDVARBPROC.invoke(address("glGetnMapdvARB"), target, query, bufSize, v);
  }

  public void glTangentPointerEXT(int type, int stride, MemorySegment pointer) {
    PFNGLTANGENTPOINTEREXTPROC.invoke(address("glTangentPointerEXT"), type, stride, pointer);
  }

  public void glProgramUniform1fv(int program, int location, int count, MemorySegment value) {
    PFNGLPROGRAMUNIFORM1FVPROC.invoke(address("glProgramUniform1fv"), program, location, count, value);
  }

  public void glMatrixMultdEXT(int mode, MemorySegment m) {
    PFNGLMATRIXMULTDEXTPROC.invoke(address("glMatrixMultdEXT"), mode, m);
  }

  public void glDrawArraysInstancedANGLE(int mode, int first, int count, int primcount) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glNamedProgramLocalParameter4dvEXT(int program, int target, int index, MemorySegment params) {
    PFNGLNAMEDPROGRAMLOCALPARAMETER4DVEXTPROC.invoke(address("glNamedProgramLocalParameter4dvEXT"), program, target, index, params);
  }

  public void glCompressedTexImage3DARB(int target, int level, int internalformat, int width, int height, int depth, int border, int imageSize, MemorySegment data) {
    PFNGLCOMPRESSEDTEXIMAGE3DARBPROC.invoke(address("glCompressedTexImage3DARB"), target, level, internalformat, width, height, depth, border, imageSize, data);
  }

  public void glStencilStrokePathInstancedNV(int numPaths, int pathNameType, MemorySegment paths, int pathBase, int reference, int mask, int transformType, MemorySegment transformValues) {
    PFNGLSTENCILSTROKEPATHINSTANCEDNVPROC.invoke(address("glStencilStrokePathInstancedNV"), numPaths, pathNameType, paths, pathBase, reference, mask, transformType, transformValues);
  }

  public void glGetVertexArrayPointeri_vEXT(int vaobj, int index, int pname, MemorySegment param) {
    PFNGLGETVERTEXARRAYPOINTERI_VEXTPROC.invoke(address("glGetVertexArrayPointeri_vEXT"), vaobj, index, pname, param);
  }

  public void glNormal3hNV(short nx, short ny, short nz) {
    PFNGLNORMAL3HNVPROC.invoke(address("glNormal3hNV"), nx, ny, nz);
  }

  public void glPopGroupMarkerEXT() {
    PFNGLPOPGROUPMARKEREXTPROC.invoke(address("glPopGroupMarkerEXT"));
  }

  public int glGetProgramResourceLocation(int program, int programInterface, MemorySegment name) {
    return PFNGLGETPROGRAMRESOURCELOCATIONPROC.invoke(address("glGetProgramResourceLocation"), program, programInterface, name);
  }

  public void glWindowPos2ivARB(MemorySegment v) {
    PFNGLWINDOWPOS2IVARBPROC.invoke(address("glWindowPos2ivARB"), v);
  }

  public void glVertexAttribL2dEXT(int index, double x, double y) {
    PFNGLVERTEXATTRIBL2DEXTPROC.invoke(address("glVertexAttribL2dEXT"), index, x, y);
  }

  public void glBlendFunciOES(int buf, int src, int dst) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniform1dv(int program, int location, int count, MemorySegment value) {
    PFNGLPROGRAMUNIFORM1DVPROC.invoke(address("glProgramUniform1dv"), program, location, count, value);
  }

  public void glVertex3hNV(short x, short y, short z) {
    PFNGLVERTEX3HNVPROC.invoke(address("glVertex3hNV"), x, y, z);
  }

  public void glRasterPos3xOES(int x, int y, int z) {
    PFNGLRASTERPOS3XOESPROC.invoke(address("glRasterPos3xOES"), x, y, z);
  }

  public void glGetHistogramParameterxvOES(int target, int pname, MemorySegment params) {
    PFNGLGETHISTOGRAMPARAMETERXVOESPROC.invoke(address("glGetHistogramParameterxvOES"), target, pname, params);
  }

  public void glProgramUniform4ui64NV(int program, int location, long x, long y, long z, long w) {
    PFNGLPROGRAMUNIFORM4UI64NVPROC.invoke(address("glProgramUniform4ui64NV"), program, location, x, y, z, w);
  }

  public void glVertexArrayVertexAttribLFormatEXT(int vaobj, int attribindex, int size, int type, int relativeoffset) {
    PFNGLVERTEXARRAYVERTEXATTRIBLFORMATEXTPROC.invoke(address("glVertexArrayVertexAttribLFormatEXT"), vaobj, attribindex, size, type, relativeoffset);
  }

  public void glLockArraysEXT(int first, int count) {
    PFNGLLOCKARRAYSEXTPROC.invoke(address("glLockArraysEXT"), first, count);
  }

  public void glEdgeFlagPointerEXT(int stride, int count, MemorySegment pointer) {
    PFNGLEDGEFLAGPOINTEREXTPROC.invoke(address("glEdgeFlagPointerEXT"), stride, count, pointer);
  }

  public void glEndQueryARB(int target) {
    PFNGLENDQUERYARBPROC.invoke(address("glEndQueryARB"), target);
  }

  public void glNamedFramebufferTextureFaceEXT(int framebuffer, int attachment, int texture, int level, int face) {
    PFNGLNAMEDFRAMEBUFFERTEXTUREFACEEXTPROC.invoke(address("glNamedFramebufferTextureFaceEXT"), framebuffer, attachment, texture, level, face);
  }

  public void glVertexAttribPointerARB(int index, int size, int type, byte normalized, int stride, MemorySegment pointer) {
    PFNGLVERTEXATTRIBPOINTERARBPROC.invoke(address("glVertexAttribPointerARB"), index, size, type, normalized, stride, pointer);
  }

  public void glSecondaryColor3svEXT(MemorySegment v) {
    PFNGLSECONDARYCOLOR3SVEXTPROC.invoke(address("glSecondaryColor3svEXT"), v);
  }

  public void glFogxvOES(int pname, MemorySegment param) {
    PFNGLFOGXVOESPROC.invoke(address("glFogxvOES"), pname, param);
  }

  public void glDrawRangeElementsBaseVertex(int mode, int start, int end, int count, int type, MemorySegment indices, int basevertex) {
    PFNGLDRAWRANGEELEMENTSBASEVERTEXPROC.invoke(address("glDrawRangeElementsBaseVertex"), mode, start, end, count, type, indices, basevertex);
  }

  public int glGetGraphicsResetStatusEXT() {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBeginTransformFeedback(int primitiveMode) {
    PFNGLBEGINTRANSFORMFEEDBACKPROC.invoke(address("glBeginTransformFeedback"), primitiveMode);
  }

  public void glObjectPtrLabel(MemorySegment ptr, int length, MemorySegment label) {
    PFNGLOBJECTPTRLABELPROC.invoke(address("glObjectPtrLabel"), ptr, length, label);
  }

  public void glUploadGpuMaskNVX(int mask) {
    PFNGLUPLOADGPUMASKNVXPROC.invoke(address("glUploadGpuMaskNVX"), mask);
  }

  public void glGetFinalCombinerInputParameterfvNV(int variable, int pname, MemorySegment params) {
    PFNGLGETFINALCOMBINERINPUTPARAMETERFVNVPROC.invoke(address("glGetFinalCombinerInputParameterfvNV"), variable, pname, params);
  }

  public void glUnlockArraysEXT() {
    PFNGLUNLOCKARRAYSEXTPROC.invoke(address("glUnlockArraysEXT"));
  }

  public void glGetTexParameterIiv(int target, int pname, MemorySegment params) {
    PFNGLGETTEXPARAMETERIIVPROC.invoke(address("glGetTexParameterIiv"), target, pname, params);
  }

  public void glVertexArrayMultiTexCoordOffsetEXT(int vaobj, int buffer, int texunit, int size, int type, int stride, long offset) {
    PFNGLVERTEXARRAYMULTITEXCOORDOFFSETEXTPROC.invoke(address("glVertexArrayMultiTexCoordOffsetEXT"), vaobj, buffer, texunit, size, type, stride, offset);
  }

  public void glMultiTexCoord1hNV(int target, short s) {
    PFNGLMULTITEXCOORD1HNVPROC.invoke(address("glMultiTexCoord1hNV"), target, s);
  }

  public void glVertexAttrib4Nub(int index, byte x, byte y, byte z, byte w) {
    PFNGLVERTEXATTRIB4NUBPROC.invoke(address("glVertexAttrib4Nub"), index, x, y, z, w);
  }

  public void glProgramLocalParameterI4ivNV(int target, int index, MemorySegment params) {
    PFNGLPROGRAMLOCALPARAMETERI4IVNVPROC.invoke(address("glProgramLocalParameterI4ivNV"), target, index, params);
  }

  public void glSetInvariantEXT(int id, int type, MemorySegment addr) {
    PFNGLSETINVARIANTEXTPROC.invoke(address("glSetInvariantEXT"), id, type, addr);
  }

  public byte glIsQuery(int id) {
    return PFNGLISQUERYPROC.invoke(address("glIsQuery"), id);
  }

  public void glFogCoordPointerEXT(int type, int stride, MemorySegment pointer) {
    PFNGLFOGCOORDPOINTEREXTPROC.invoke(address("glFogCoordPointerEXT"), type, stride, pointer);
  }

  public void glProgramBufferParametersfvNV(int target, int bindingIndex, int wordIndex, int count, MemorySegment params) {
    PFNGLPROGRAMBUFFERPARAMETERSFVNVPROC.invoke(address("glProgramBufferParametersfvNV"), target, bindingIndex, wordIndex, count, params);
  }

  public void glCombinerParameterivNV(int pname, MemorySegment params) {
    PFNGLCOMBINERPARAMETERIVNVPROC.invoke(address("glCombinerParameterivNV"), pname, params);
  }

  public void glGetnUniformfv(int program, int location, int bufSize, MemorySegment params) {
    PFNGLGETNUNIFORMFVPROC.invoke(address("glGetnUniformfv"), program, location, bufSize, params);
  }

  public void glPathParameterfNV(int path, int pname, float value) {
    PFNGLPATHPARAMETERFNVPROC.invoke(address("glPathParameterfNV"), path, pname, value);
  }

  public void glVertexAttrib4Nsv(int index, MemorySegment v) {
    PFNGLVERTEXATTRIB4NSVPROC.invoke(address("glVertexAttrib4Nsv"), index, v);
  }

  public void glProgramUniform4i64vARB(int program, int location, int count, MemorySegment value) {
    PFNGLPROGRAMUNIFORM4I64VARBPROC.invoke(address("glProgramUniform4i64vARB"), program, location, count, value);
  }

  public void glMakeNamedBufferResidentNV(int buffer, int access) {
    PFNGLMAKENAMEDBUFFERRESIDENTNVPROC.invoke(address("glMakeNamedBufferResidentNV"), buffer, access);
  }

  public void glInvalidateNamedFramebufferSubData(int framebuffer, int numAttachments, MemorySegment attachments, int x, int y, int width, int height) {
    PFNGLINVALIDATENAMEDFRAMEBUFFERSUBDATAPROC.invoke(address("glInvalidateNamedFramebufferSubData"), framebuffer, numAttachments, attachments, x, y, width, height);
  }

  public void glColorPointerListIBM(int size, int type, int stride, MemorySegment pointer, int ptrstride) {
    PFNGLCOLORPOINTERLISTIBMPROC.invoke(address("glColorPointerListIBM"), size, type, stride, pointer, ptrstride);
  }

  public byte glIsCommandListNV(int list) {
    return PFNGLISCOMMANDLISTNVPROC.invoke(address("glIsCommandListNV"), list);
  }

  public void glEdgeFlagFormatNV(int stride) {
    PFNGLEDGEFLAGFORMATNVPROC.invoke(address("glEdgeFlagFormatNV"), stride);
  }

  public void glGetColorTableParameterfvSGI(int target, int pname, MemorySegment params) {
    PFNGLGETCOLORTABLEPARAMETERFVSGIPROC.invoke(address("glGetColorTableParameterfvSGI"), target, pname, params);
  }

  public void glGetTransformFeedbacki_v(int xfb, int pname, int index, MemorySegment param) {
    PFNGLGETTRANSFORMFEEDBACKI_VPROC.invoke(address("glGetTransformFeedbacki_v"), xfb, pname, index, param);
  }

  public void glScissorArrayv(int first, int count, MemorySegment v) {
    PFNGLSCISSORARRAYVPROC.invoke(address("glScissorArrayv"), first, count, v);
  }

  public void glStartInstrumentsSGIX() {
    PFNGLSTARTINSTRUMENTSSGIXPROC.invoke(address("glStartInstrumentsSGIX"));
  }

  public void glReplacementCodeubvSUN(MemorySegment code) {
    PFNGLREPLACEMENTCODEUBVSUNPROC.invoke(address("glReplacementCodeubvSUN"), code);
  }

  public void glMultiDrawElementsIndirectCount(int mode, int type, MemorySegment indirect, long drawcount, int maxdrawcount, int stride) {
    PFNGLMULTIDRAWELEMENTSINDIRECTCOUNTPROC.invoke(address("glMultiDrawElementsIndirectCount"), mode, type, indirect, drawcount, maxdrawcount, stride);
  }

  public void glNormalStream3sATI(int stream, short nx, short ny, short nz) {
    PFNGLNORMALSTREAM3SATIPROC.invoke(address("glNormalStream3sATI"), stream, nx, ny, nz);
  }

  public void glMatrixIndexubvARB(int size, MemorySegment indices) {
    PFNGLMATRIXINDEXUBVARBPROC.invoke(address("glMatrixIndexubvARB"), size, indices);
  }

  public void glGenerateTextureMipmapEXT(int texture, int target) {
    PFNGLGENERATETEXTUREMIPMAPEXTPROC.invoke(address("glGenerateTextureMipmapEXT"), texture, target);
  }

  public void glDebugMessageEnableAMD(int category, int severity, int count, MemorySegment ids, byte enabled) {
    PFNGLDEBUGMESSAGEENABLEAMDPROC.invoke(address("glDebugMessageEnableAMD"), category, severity, count, ids, enabled);
  }

  public void glPointParameterfvSGIS(int pname, MemorySegment params) {
    PFNGLPOINTPARAMETERFVSGISPROC.invoke(address("glPointParameterfvSGIS"), pname, params);
  }

  public void glIndexxOES(int component) {
    PFNGLINDEXXOESPROC.invoke(address("glIndexxOES"), component);
  }

  public int glGetUniformLocation(int program, MemorySegment name) {
    return PFNGLGETUNIFORMLOCATIONPROC.invoke(address("glGetUniformLocation"), program, name);
  }

  public void glPrimitiveBoundingBox(float minX, float minY, float minZ, float minW, float maxX, float maxY, float maxZ, float maxW) {
    PFNGLPRIMITIVEBOUNDINGBOXARBPROC.invoke(address("glPrimitiveBoundingBox"), minX, minY, minZ, minW, maxX, maxY, maxZ, maxW);
  }

  public void glCopyTexSubImage1DEXT(int target, int level, int xoffset, int x, int y, int width) {
    PFNGLCOPYTEXSUBIMAGE1DEXTPROC.invoke(address("glCopyTexSubImage1DEXT"), target, level, xoffset, x, y, width);
  }

  public void glVertexStream4dATI(int stream, double x, double y, double z, double w) {
    PFNGLVERTEXSTREAM4DATIPROC.invoke(address("glVertexStream4dATI"), stream, x, y, z, w);
  }

  public void glSpriteParameterfvSGIX(int pname, MemorySegment params) {
    PFNGLSPRITEPARAMETERFVSGIXPROC.invoke(address("glSpriteParameterfvSGIX"), pname, params);
  }

  public void glGlobalAlphaFactoriSUN(int factor) {
    PFNGLGLOBALALPHAFACTORISUNPROC.invoke(address("glGlobalAlphaFactoriSUN"), factor);
  }

  public void glConvolutionParameterxOES(int target, int pname, int param) {
    PFNGLCONVOLUTIONPARAMETERXOESPROC.invoke(address("glConvolutionParameterxOES"), target, pname, param);
  }

  public void glMultiTexCoord3xvOES(int texture, MemorySegment coords) {
    PFNGLMULTITEXCOORD3XVOESPROC.invoke(address("glMultiTexCoord3xvOES"), texture, coords);
  }

  public void glBlendParameteriNV(int pname, int value) {
    PFNGLBLENDPARAMETERINVPROC.invoke(address("glBlendParameteriNV"), pname, value);
  }

  public void glGetMultisamplefv(int pname, int index, MemorySegment val) {
    PFNGLGETMULTISAMPLEFVPROC.invoke(address("glGetMultisamplefv"), pname, index, val);
  }

  public byte glIsQueryARB(int id) {
    return PFNGLISQUERYARBPROC.invoke(address("glIsQueryARB"), id);
  }

  public void glGetInternalformativ(int target, int internalformat, int pname, int count, MemorySegment params) {
    PFNGLGETINTERNALFORMATIVPROC.invoke(address("glGetInternalformativ"), target, internalformat, pname, count, params);
  }

  public void glDepthRangeArrayfvNV(int first, int count, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBufferSubData(int target, long offset, long size, MemorySegment data) {
    PFNGLBUFFERSUBDATAPROC.invoke(address("glBufferSubData"), target, offset, size, data);
  }

  public void glRenderbufferStorageMultisampleNV(int target, int samples, int internalformat, int width, int height) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetSyncivAPPLE(MemorySegment sync, int pname, int count, MemorySegment length, MemorySegment values) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttrib4ubvNV(int index, MemorySegment v) {
    PFNGLVERTEXATTRIB4UBVNVPROC.invoke(address("glVertexAttrib4ubvNV"), index, v);
  }

  public int glBindTextureUnitParameterEXT(int unit, int value) {
    return PFNGLBINDTEXTUREUNITPARAMETEREXTPROC.invoke(address("glBindTextureUnitParameterEXT"), unit, value);
  }

  public void glVertexWeightfvEXT(MemorySegment weight) {
    PFNGLVERTEXWEIGHTFVEXTPROC.invoke(address("glVertexWeightfvEXT"), weight);
  }

  public void glTextureParameteriEXT(int texture, int target, int pname, int param) {
    PFNGLTEXTUREPARAMETERIEXTPROC.invoke(address("glTextureParameteriEXT"), texture, target, pname, param);
  }

  public int glCreateShaderProgramEXT(int type, MemorySegment string) {
    return PFNGLCREATESHADERPROGRAMEXTPROC.invoke(address("glCreateShaderProgramEXT"), type, string);
  }

  public void glClearDepthf(float d) {
    PFNGLCLEARDEPTHFPROC.invoke(address("glClearDepthf"), d);
  }

  public void glTextureImage2DMultisampleNV(int texture, int target, int samples, int internalFormat, int width, int height, byte fixedSampleLocations) {
    PFNGLTEXTUREIMAGE2DMULTISAMPLENVPROC.invoke(address("glTextureImage2DMultisampleNV"), texture, target, samples, internalFormat, width, height, fixedSampleLocations);
  }

  public void glDisableVertexAttribArray(int index) {
    PFNGLDISABLEVERTEXATTRIBARRAYPROC.invoke(address("glDisableVertexAttribArray"), index);
  }

  public void glGetDoubleIndexedvEXT(int target, int index, MemorySegment data) {
    PFNGLGETDOUBLEINDEXEDVEXTPROC.invoke(address("glGetDoubleIndexedvEXT"), target, index, data);
  }

  public void glProgramUniform4iEXT(int program, int location, int v0, int v1, int v2, int v3) {
    PFNGLPROGRAMUNIFORM4IEXTPROC.invoke(address("glProgramUniform4iEXT"), program, location, v0, v1, v2, v3);
  }

  public void glClearDepthx(int depth) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTextureBarrier() {
    PFNGLTEXTUREBARRIERPROC.invoke(address("glTextureBarrier"));
  }

  public void glNamedStringARB(int type, int namelen, MemorySegment name, int stringlen, MemorySegment string) {
    PFNGLNAMEDSTRINGARBPROC.invoke(address("glNamedStringARB"), type, namelen, name, stringlen, string);
  }

  public void glTexCoord1xvOES(MemorySegment coords) {
    PFNGLTEXCOORD1XVOESPROC.invoke(address("glTexCoord1xvOES"), coords);
  }

  public void glGetUniformfvARB(int programObj, int location, MemorySegment params) {
    PFNGLGETUNIFORMFVARBPROC.invoke(address("glGetUniformfvARB"), programObj, location, params);
  }

  public void glTexCoordPointervINTEL(int size, int type, MemorySegment pointer) {
    PFNGLTEXCOORDPOINTERVINTELPROC.invoke(address("glTexCoordPointervINTEL"), size, type, pointer);
  }

  public void glVertexArrayVertexAttribFormatEXT(int vaobj, int attribindex, int size, int type, byte normalized, int relativeoffset) {
    PFNGLVERTEXARRAYVERTEXATTRIBFORMATEXTPROC.invoke(address("glVertexArrayVertexAttribFormatEXT"), vaobj, attribindex, size, type, normalized, relativeoffset);
  }

  public void glTexCoord2fColor3fVertex3fvSUN(MemorySegment tc, MemorySegment c, MemorySegment v) {
    PFNGLTEXCOORD2FCOLOR3FVERTEX3FVSUNPROC.invoke(address("glTexCoord2fColor3fVertex3fvSUN"), tc, c, v);
  }

  public void glGetVariantArrayObjectfvATI(int id, int pname, MemorySegment params) {
    PFNGLGETVARIANTARRAYOBJECTFVATIPROC.invoke(address("glGetVariantArrayObjectfvATI"), id, pname, params);
  }

  public void glProgramUniform4fvEXT(int program, int location, int count, MemorySegment value) {
    PFNGLPROGRAMUNIFORM4FVEXTPROC.invoke(address("glProgramUniform4fvEXT"), program, location, count, value);
  }

  public void glProgramUniform2i64vNV(int program, int location, int count, MemorySegment value) {
    PFNGLPROGRAMUNIFORM2I64VNVPROC.invoke(address("glProgramUniform2i64vNV"), program, location, count, value);
  }

  public void glMultiTexCoordP4ui(int texture, int type, int coords) {
    PFNGLMULTITEXCOORDP4UIPROC.invoke(address("glMultiTexCoordP4ui"), texture, type, coords);
  }

  public void glGetnUniformdv(int program, int location, int bufSize, MemorySegment params) {
    PFNGLGETNUNIFORMDVPROC.invoke(address("glGetnUniformdv"), program, location, bufSize, params);
  }

  public void glInvalidateTexImage(int texture, int level) {
    PFNGLINVALIDATETEXIMAGEPROC.invoke(address("glInvalidateTexImage"), texture, level);
  }

  public byte glIsRenderbufferEXT(int renderbuffer) {
    return PFNGLISRENDERBUFFEREXTPROC.invoke(address("glIsRenderbufferEXT"), renderbuffer);
  }

  public void glProgramUniform3uiEXT(int program, int location, int v0, int v1, int v2) {
    PFNGLPROGRAMUNIFORM3UIEXTPROC.invoke(address("glProgramUniform3uiEXT"), program, location, v0, v1, v2);
  }

  public void glDeleteNamedStringARB(int namelen, MemorySegment name) {
    PFNGLDELETENAMEDSTRINGARBPROC.invoke(address("glDeleteNamedStringARB"), namelen, name);
  }

  public void glReplacementCodeuiTexCoord2fNormal3fVertex3fvSUN(MemorySegment rc, MemorySegment tc, MemorySegment n, MemorySegment v) {
    PFNGLREPLACEMENTCODEUITEXCOORD2FNORMAL3FVERTEX3FVSUNPROC.invoke(address("glReplacementCodeuiTexCoord2fNormal3fVertex3fvSUN"), rc, tc, n, v);
  }

  public void glBindTextures(int first, int count, MemorySegment textures) {
    PFNGLBINDTEXTURESPROC.invoke(address("glBindTextures"), first, count, textures);
  }

  public void glEndQuery(int target) {
    PFNGLENDQUERYPROC.invoke(address("glEndQuery"), target);
  }

  public void glNamedFramebufferSampleLocationsfvNV(int framebuffer, int start, int count, MemorySegment v) {
    PFNGLNAMEDFRAMEBUFFERSAMPLELOCATIONSFVNVPROC.invoke(address("glNamedFramebufferSampleLocationsfvNV"), framebuffer, start, count, v);
  }

  public void glProgramUniform1i64vARB(int program, int location, int count, MemorySegment value) {
    PFNGLPROGRAMUNIFORM1I64VARBPROC.invoke(address("glProgramUniform1i64vARB"), program, location, count, value);
  }

  public void glBlitFramebuffer(int srcX0, int srcY0, int srcX1, int srcY1, int dstX0, int dstY0, int dstX1, int dstY1, int mask, int filter) {
    PFNGLBLITFRAMEBUFFERPROC.invoke(address("glBlitFramebuffer"), srcX0, srcY0, srcX1, srcY1, dstX0, dstY0, dstX1, dstY1, mask, filter);
  }

  public void glStencilThenCoverFillPathInstancedNV(int numPaths, int pathNameType, MemorySegment paths, int pathBase, int fillMode, int mask, int coverMode, int transformType, MemorySegment transformValues) {
    PFNGLSTENCILTHENCOVERFILLPATHINSTANCEDNVPROC.invoke(address("glStencilThenCoverFillPathInstancedNV"), numPaths, pathNameType, paths, pathBase, fillMode, mask, coverMode, transformType, transformValues);
  }

  public void glUniformSubroutinesuiv(int shadertype, int count, MemorySegment indices) {
    PFNGLUNIFORMSUBROUTINESUIVPROC.invoke(address("glUniformSubroutinesuiv"), shadertype, count, indices);
  }

  public void glIndexPointerListIBM(int type, int stride, MemorySegment pointer, int ptrstride) {
    PFNGLINDEXPOINTERLISTIBMPROC.invoke(address("glIndexPointerListIBM"), type, stride, pointer, ptrstride);
  }

  public void glVertexStream4dvATI(int stream, MemorySegment coords) {
    PFNGLVERTEXSTREAM4DVATIPROC.invoke(address("glVertexStream4dvATI"), stream, coords);
  }

  public void glUniform3ui64ARB(int location, long x, long y, long z) {
    PFNGLUNIFORM3UI64ARBPROC.invoke(address("glUniform3ui64ARB"), location, x, y, z);
  }

  public void glVertexArrayVertexAttribLOffsetEXT(int vaobj, int buffer, int index, int size, int type, int stride, long offset) {
    PFNGLVERTEXARRAYVERTEXATTRIBLOFFSETEXTPROC.invoke(address("glVertexArrayVertexAttribLOffsetEXT"), vaobj, buffer, index, size, type, stride, offset);
  }

  public void glValidateProgramARB(int programObj) {
    PFNGLVALIDATEPROGRAMARBPROC.invoke(address("glValidateProgramARB"), programObj);
  }

  public void glBeginVertexShaderEXT() {
    PFNGLBEGINVERTEXSHADEREXTPROC.invoke(address("glBeginVertexShaderEXT"));
  }

  public void glBlendFuncSeparateIndexedAMD(int buf, int srcRGB, int dstRGB, int srcAlpha, int dstAlpha) {
    PFNGLBLENDFUNCSEPARATEINDEXEDAMDPROC.invoke(address("glBlendFuncSeparateIndexedAMD"), buf, srcRGB, dstRGB, srcAlpha, dstAlpha);
  }

  public void glGetnTexImageARB(int target, int level, int format, int type, int bufSize, MemorySegment img) {
    PFNGLGETNTEXIMAGEARBPROC.invoke(address("glGetnTexImageARB"), target, level, format, type, bufSize, img);
  }

  public void glTexCoord1hNV(short s) {
    PFNGLTEXCOORD1HNVPROC.invoke(address("glTexCoord1hNV"), s);
  }

  public int glGetAttribLocationARB(int programObj, MemorySegment name) {
    return PFNGLGETATTRIBLOCATIONARBPROC.invoke(address("glGetAttribLocationARB"), programObj, name);
  }

  public void glMemoryBarrierEXT(int barriers) {
    PFNGLMEMORYBARRIEREXTPROC.invoke(address("glMemoryBarrierEXT"), barriers);
  }

  public void glGetNamedBufferSubDataEXT(int buffer, long offset, long size, MemorySegment data) {
    PFNGLGETNAMEDBUFFERSUBDATAEXTPROC.invoke(address("glGetNamedBufferSubDataEXT"), buffer, offset, size, data);
  }

  public void glEnableClientStateIndexedEXT(int array, int index) {
    PFNGLENABLECLIENTSTATEINDEXEDEXTPROC.invoke(address("glEnableClientStateIndexedEXT"), array, index);
  }

  public void glScissorIndexedv(int index, MemorySegment v) {
    PFNGLSCISSORINDEXEDVPROC.invoke(address("glScissorIndexedv"), index, v);
  }

  public void glWindowPos2fvARB(MemorySegment v) {
    PFNGLWINDOWPOS2FVARBPROC.invoke(address("glWindowPos2fvARB"), v);
  }

  public void glCoverageModulationTableNV(int n, MemorySegment v) {
    PFNGLCOVERAGEMODULATIONTABLENVPROC.invoke(address("glCoverageModulationTableNV"), n, v);
  }

  public void glTexStorageMem1DEXT(int target, int levels, int internalFormat, int width, int memory, long offset) {
    PFNGLTEXSTORAGEMEM1DEXTPROC.invoke(address("glTexStorageMem1DEXT"), target, levels, internalFormat, width, memory, offset);
  }

  public void glFramebufferShadingRateEXT(int target, int attachment, int texture, int baseLayer, int numLayers, int texelWidth, int texelHeight) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttrib3fNV(int index, float x, float y, float z) {
    PFNGLVERTEXATTRIB3FNVPROC.invoke(address("glVertexAttrib3fNV"), index, x, y, z);
  }

  public void glWindowPos4svMESA(MemorySegment v) {
    PFNGLWINDOWPOS4SVMESAPROC.invoke(address("glWindowPos4svMESA"), v);
  }

  public void glMultiTexCoordP2uiv(int texture, int type, MemorySegment coords) {
    PFNGLMULTITEXCOORDP2UIVPROC.invoke(address("glMultiTexCoordP2uiv"), texture, type, coords);
  }

  public void glCompressedTextureSubImage2DEXT(int texture, int target, int level, int xoffset, int yoffset, int width, int height, int format, int imageSize, MemorySegment bits) {
    PFNGLCOMPRESSEDTEXTURESUBIMAGE2DEXTPROC.invoke(address("glCompressedTextureSubImage2DEXT"), texture, target, level, xoffset, yoffset, width, height, format, imageSize, bits);
  }

  public void glTextureStorage3DMultisample(int texture, int samples, int internalformat, int width, int height, int depth, byte fixedsamplelocations) {
    PFNGLTEXTURESTORAGE3DMULTISAMPLEPROC.invoke(address("glTextureStorage3DMultisample"), texture, samples, internalformat, width, height, depth, fixedsamplelocations);
  }

  public void glVertexAttribDivisorARB(int index, int divisor) {
    PFNGLVERTEXATTRIBDIVISORARBPROC.invoke(address("glVertexAttribDivisorARB"), index, divisor);
  }

  public void glShadingRateImagePaletteNV(int viewport, int first, int count, MemorySegment rates) {
    PFNGLSHADINGRATEIMAGEPALETTENVPROC.invoke(address("glShadingRateImagePaletteNV"), viewport, first, count, rates);
  }

  public void glTextureStorage2DEXT(int texture, int target, int levels, int internalformat, int width, int height) {
    PFNGLTEXTURESTORAGE2DEXTPROC.invoke(address("glTextureStorage2DEXT"), texture, target, levels, internalformat, width, height);
  }

  public void glObjectPtrLabelKHR(MemorySegment ptr, int length, MemorySegment label) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public byte glIsImageHandleResidentARB(long handle) {
    return PFNGLISIMAGEHANDLERESIDENTARBPROC.invoke(address("glIsImageHandleResidentARB"), handle);
  }

  public void glPresentFrameKeyedNV(int video_slot, long minPresentTime, int beginPresentTimeId, int presentDurationId, int type, int target0, int fill0, int key0, int target1, int fill1, int key1) {
    PFNGLPRESENTFRAMEKEYEDNVPROC.invoke(address("glPresentFrameKeyedNV"), video_slot, minPresentTime, beginPresentTimeId, presentDurationId, type, target0, fill0, key0, target1, fill1, key1);
  }

  public void glLoadTransposeMatrixfARB(MemorySegment m) {
    PFNGLLOADTRANSPOSEMATRIXFARBPROC.invoke(address("glLoadTransposeMatrixfARB"), m);
  }

  public void glGetNamedBufferParameterivEXT(int buffer, int pname, MemorySegment params) {
    PFNGLGETNAMEDBUFFERPARAMETERIVEXTPROC.invoke(address("glGetNamedBufferParameterivEXT"), buffer, pname, params);
  }

  public void glMultiDrawArraysIndirectCountARB(int mode, MemorySegment indirect, long drawcount, int maxdrawcount, int stride) {
    PFNGLMULTIDRAWARRAYSINDIRECTCOUNTARBPROC.invoke(address("glMultiDrawArraysIndirectCountARB"), mode, indirect, drawcount, maxdrawcount, stride);
  }

  public void glDisableiOES(int target, int index) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glScissorArrayvNV(int first, int count, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glWeightivARB(int size, MemorySegment weights) {
    PFNGLWEIGHTIVARBPROC.invoke(address("glWeightivARB"), size, weights);
  }

  public void glGetNamedBufferParameterui64vNV(int buffer, int pname, MemorySegment params) {
    PFNGLGETNAMEDBUFFERPARAMETERUI64VNVPROC.invoke(address("glGetNamedBufferParameterui64vNV"), buffer, pname, params);
  }

  public void glTextureImage2DEXT(int texture, int target, int level, int internalformat, int width, int height, int border, int format, int type, MemorySegment pixels) {
    PFNGLTEXTUREIMAGE2DEXTPROC.invoke(address("glTextureImage2DEXT"), texture, target, level, internalformat, width, height, border, format, type, pixels);
  }

  public int glCheckFramebufferStatusEXT(int target) {
    return PFNGLCHECKFRAMEBUFFERSTATUSEXTPROC.invoke(address("glCheckFramebufferStatusEXT"), target);
  }

  public void glBeginConditionalRender(int id, int mode) {
    PFNGLBEGINCONDITIONALRENDERPROC.invoke(address("glBeginConditionalRender"), id, mode);
  }

  public void glGenerateMipmap(int target) {
    PFNGLGENERATEMIPMAPPROC.invoke(address("glGenerateMipmap"), target);
  }

  public void glVertexAttribDivisor(int index, int divisor) {
    PFNGLVERTEXATTRIBDIVISORPROC.invoke(address("glVertexAttribDivisor"), index, divisor);
  }

  public void glTexStorage2DMultisample(int target, int samples, int internalformat, int width, int height, byte fixedsamplelocations) {
    PFNGLTEXSTORAGE2DMULTISAMPLEPROC.invoke(address("glTexStorage2DMultisample"), target, samples, internalformat, width, height, fixedsamplelocations);
  }

  public void glGetVertexArrayIndexediv(int vaobj, int index, int pname, MemorySegment param) {
    PFNGLGETVERTEXARRAYINDEXEDIVPROC.invoke(address("glGetVertexArrayIndexediv"), vaobj, index, pname, param);
  }

  public void glVertexStream1iATI(int stream, int x) {
    PFNGLVERTEXSTREAM1IATIPROC.invoke(address("glVertexStream1iATI"), stream, x);
  }

  public void glGetUniformui64vNV(int program, int location, MemorySegment params) {
    PFNGLGETUNIFORMUI64VNVPROC.invoke(address("glGetUniformui64vNV"), program, location, params);
  }

  public void glPathParameterivNV(int path, int pname, MemorySegment value) {
    PFNGLPATHPARAMETERIVNVPROC.invoke(address("glPathParameterivNV"), path, pname, value);
  }

  public void glUniformMatrix4x2dv(int location, int count, byte transpose, MemorySegment value) {
    PFNGLUNIFORMMATRIX4X2DVPROC.invoke(address("glUniformMatrix4x2dv"), location, count, transpose, value);
  }

  public void glGetPerfCounterInfoINTEL(int queryId, int counterId, int counterNameLength, MemorySegment counterName, int counterDescLength, MemorySegment counterDesc, MemorySegment counterOffset, MemorySegment counterDataSize, MemorySegment counterTypeEnum, MemorySegment counterDataTypeEnum, MemorySegment rawCounterMaxValue) {
    PFNGLGETPERFCOUNTERINFOINTELPROC.invoke(address("glGetPerfCounterInfoINTEL"), queryId, counterId, counterNameLength, counterName, counterDescLength, counterDesc, counterOffset, counterDataSize, counterTypeEnum, counterDataTypeEnum, rawCounterMaxValue);
  }

  public int glGetHandleARB(int pname) {
    return PFNGLGETHANDLEARBPROC.invoke(address("glGetHandleARB"), pname);
  }

  public void glGetSeparableFilterEXT(int target, int format, int type, MemorySegment row, MemorySegment column, MemorySegment span) {
    PFNGLGETSEPARABLEFILTEREXTPROC.invoke(address("glGetSeparableFilterEXT"), target, format, type, row, column, span);
  }

  public MemorySegment glMapObjectBufferATI(int buffer) {
    return PFNGLMAPOBJECTBUFFERATIPROC.invoke(address("glMapObjectBufferATI"), buffer);
  }

  public void glProgramPathFragmentInputGenNV(int program, int location, int genMode, int components, MemorySegment coeffs) {
    PFNGLPROGRAMPATHFRAGMENTINPUTGENNVPROC.invoke(address("glProgramPathFragmentInputGenNV"), program, location, genMode, components, coeffs);
  }

  public void glLineWidthxOES(int width) {
    PFNGLLINEWIDTHXOESPROC.invoke(address("glLineWidthxOES"), width);
  }

  public void glTexCoordP2uiv(int type, MemorySegment coords) {
    PFNGLTEXCOORDP2UIVPROC.invoke(address("glTexCoordP2uiv"), type, coords);
  }

  public void glMultiDrawElementArrayAPPLE(int mode, MemorySegment first, MemorySegment count, int primcount) {
    PFNGLMULTIDRAWELEMENTARRAYAPPLEPROC.invoke(address("glMultiDrawElementArrayAPPLE"), mode, first, count, primcount);
  }

  public void glVertexAttrib2fv(int index, MemorySegment v) {
    PFNGLVERTEXATTRIB2FVPROC.invoke(address("glVertexAttrib2fv"), index, v);
  }

  public void glValidateProgramPipelineEXT(int pipeline) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glSecondaryColorPointerEXT(int size, int type, int stride, MemorySegment pointer) {
    PFNGLSECONDARYCOLORPOINTEREXTPROC.invoke(address("glSecondaryColorPointerEXT"), size, type, stride, pointer);
  }

  public void glVertexAttrib4usvARB(int index, MemorySegment v) {
    PFNGLVERTEXATTRIB4USVARBPROC.invoke(address("glVertexAttrib4usvARB"), index, v);
  }

  public void glWindowPos4fMESA(float x, float y, float z, float w) {
    PFNGLWINDOWPOS4FMESAPROC.invoke(address("glWindowPos4fMESA"), x, y, z, w);
  }

  public void glSamplerParameterIivEXT(int sampler, int pname, MemorySegment param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetProgramLocalParameterfvARB(int target, int index, MemorySegment params) {
    PFNGLGETPROGRAMLOCALPARAMETERFVARBPROC.invoke(address("glGetProgramLocalParameterfvARB"), target, index, params);
  }

  public void glGetVertexAttribivARB(int index, int pname, MemorySegment params) {
    PFNGLGETVERTEXATTRIBIVARBPROC.invoke(address("glGetVertexAttribivARB"), index, pname, params);
  }

  public void glExtGetRenderbuffersQCOM(MemorySegment renderbuffers, int maxRenderbuffers, MemorySegment numRenderbuffers) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttrib2dv(int index, MemorySegment v) {
    PFNGLVERTEXATTRIB2DVPROC.invoke(address("glVertexAttrib2dv"), index, v);
  }

  public void glVertexAttribL3dv(int index, MemorySegment v) {
    PFNGLVERTEXATTRIBL3DVPROC.invoke(address("glVertexAttribL3dv"), index, v);
  }

  public void glUniformMatrix4x2fv(int location, int count, byte transpose, MemorySegment value) {
    PFNGLUNIFORMMATRIX4X2FVPROC.invoke(address("glUniformMatrix4x2fv"), location, count, transpose, value);
  }

  public void glGetActiveVaryingNV(int program, int index, int bufSize, MemorySegment length, MemorySegment size, MemorySegment type, MemorySegment name) {
    PFNGLGETACTIVEVARYINGNVPROC.invoke(address("glGetActiveVaryingNV"), program, index, bufSize, length, size, type, name);
  }

  public void glMultiDrawArrays(int mode, MemorySegment first, MemorySegment count, int drawcount) {
    PFNGLMULTIDRAWARRAYSPROC.invoke(address("glMultiDrawArrays"), mode, first, count, drawcount);
  }

  public void glRotatex(int angle, int x, int y, int z) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public int glGetAttribLocation(int program, MemorySegment name) {
    return PFNGLGETATTRIBLOCATIONPROC.invoke(address("glGetAttribLocation"), program, name);
  }

  public void glVertexArrayTexCoordOffsetEXT(int vaobj, int buffer, int size, int type, int stride, long offset) {
    PFNGLVERTEXARRAYTEXCOORDOFFSETEXTPROC.invoke(address("glVertexArrayTexCoordOffsetEXT"), vaobj, buffer, size, type, stride, offset);
  }

  public void glVertexAttribs1dvNV(int index, int count, MemorySegment v) {
    PFNGLVERTEXATTRIBS1DVNVPROC.invoke(address("glVertexAttribs1dvNV"), index, count, v);
  }

  public void glWindowPos2sv(MemorySegment v) {
    PFNGLWINDOWPOS2SVPROC.invoke(address("glWindowPos2sv"), v);
  }

  public int glCreateShader(int type) {
    return PFNGLCREATESHADERPROC.invoke(address("glCreateShader"), type);
  }

  public void glProgramUniformMatrix4x2dv(int program, int location, int count, byte transpose, MemorySegment value) {
    PFNGLPROGRAMUNIFORMMATRIX4X2DVPROC.invoke(address("glProgramUniformMatrix4x2dv"), program, location, count, transpose, value);
  }

  public void glTexCoord1bOES(byte s) {
    PFNGLTEXCOORD1BOESPROC.invoke(address("glTexCoord1bOES"), s);
  }

  public void glTexGenfvOES(int coord, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiDrawArraysIndirect(int mode, MemorySegment indirect, int drawcount, int stride) {
    PFNGLMULTIDRAWARRAYSINDIRECTPROC.invoke(address("glMultiDrawArraysIndirect"), mode, indirect, drawcount, stride);
  }

  public void glDeleteProgramsARB(int n, MemorySegment programs) {
    PFNGLDELETEPROGRAMSARBPROC.invoke(address("glDeleteProgramsARB"), n, programs);
  }

  public void glMatrixIndexPointerOES(int size, int type, int stride, MemorySegment pointer) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramLocalParameter4fARB(int target, int index, float x, float y, float z, float w) {
    PFNGLPROGRAMLOCALPARAMETER4FARBPROC.invoke(address("glProgramLocalParameter4fARB"), target, index, x, y, z, w);
  }

  public void glUniformMatrix2dv(int location, int count, byte transpose, MemorySegment value) {
    PFNGLUNIFORMMATRIX2DVPROC.invoke(address("glUniformMatrix2dv"), location, count, transpose, value);
  }

  public void glMapParameterfvNV(int target, int pname, MemorySegment params) {
    PFNGLMAPPARAMETERFVNVPROC.invoke(address("glMapParameterfvNV"), target, pname, params);
  }

  public byte glIsNameAMD(int identifier, int name) {
    return PFNGLISNAMEAMDPROC.invoke(address("glIsNameAMD"), identifier, name);
  }

  public void glMultTransposeMatrixxOES(MemorySegment m) {
    PFNGLMULTTRANSPOSEMATRIXXOESPROC.invoke(address("glMultTransposeMatrixxOES"), m);
  }

  public void glWindowPos2i(int x, int y) {
    PFNGLWINDOWPOS2IPROC.invoke(address("glWindowPos2i"), x, y);
  }

  public void glVertexAttribI2iv(int index, MemorySegment v) {
    PFNGLVERTEXATTRIBI2IVPROC.invoke(address("glVertexAttribI2iv"), index, v);
  }

  public void glWindowPos2f(float x, float y) {
    PFNGLWINDOWPOS2FPROC.invoke(address("glWindowPos2f"), x, y);
  }

  public void glWindowPos2d(double x, double y) {
    PFNGLWINDOWPOS2DPROC.invoke(address("glWindowPos2d"), x, y);
  }

  public void glGetNamedFramebufferParameteriv(int framebuffer, int pname, MemorySegment param) {
    PFNGLGETNAMEDFRAMEBUFFERPARAMETERIVPROC.invoke(address("glGetNamedFramebufferParameteriv"), framebuffer, pname, param);
  }

  public void glMultiDrawArraysIndirectAMD(int mode, MemorySegment indirect, int primcount, int stride) {
    PFNGLMULTIDRAWARRAYSINDIRECTAMDPROC.invoke(address("glMultiDrawArraysIndirectAMD"), mode, indirect, primcount, stride);
  }

  public void glCopyConvolutionFilter1DEXT(int target, int internalformat, int x, int y, int width) {
    PFNGLCOPYCONVOLUTIONFILTER1DEXTPROC.invoke(address("glCopyConvolutionFilter1DEXT"), target, internalformat, x, y, width);
  }

  public void glTexParameterxOES(int target, int pname, int param) {
    PFNGLTEXPARAMETERXOESPROC.invoke(address("glTexParameterxOES"), target, pname, param);
  }

  public void glGetTrackMatrixivNV(int target, int address, int pname, MemorySegment params) {
    PFNGLGETTRACKMATRIXIVNVPROC.invoke(address("glGetTrackMatrixivNV"), target, address, pname, params);
  }

  public void glWindowPos3s(short x, short y, short z) {
    PFNGLWINDOWPOS3SPROC.invoke(address("glWindowPos3s"), x, y, z);
  }

  public void glGetActiveAttrib(int program, int index, int bufSize, MemorySegment length, MemorySegment size, MemorySegment type, MemorySegment name) {
    PFNGLGETACTIVEATTRIBPROC.invoke(address("glGetActiveAttrib"), program, index, bufSize, length, size, type, name);
  }

  public void glProgramUniformMatrix4dvEXT(int program, int location, int count, byte transpose, MemorySegment value) {
    PFNGLPROGRAMUNIFORMMATRIX4DVEXTPROC.invoke(address("glProgramUniformMatrix4dvEXT"), program, location, count, transpose, value);
  }

  public void glClearColorIiEXT(int red, int green, int blue, int alpha) {
    PFNGLCLEARCOLORIIEXTPROC.invoke(address("glClearColorIiEXT"), red, green, blue, alpha);
  }

  public void glWindowPos3i(int x, int y, int z) {
    PFNGLWINDOWPOS3IPROC.invoke(address("glWindowPos3i"), x, y, z);
  }

  public void glWindowPos3f(float x, float y, float z) {
    PFNGLWINDOWPOS3FPROC.invoke(address("glWindowPos3f"), x, y, z);
  }

  public void glColor3hNV(short red, short green, short blue) {
    PFNGLCOLOR3HNVPROC.invoke(address("glColor3hNV"), red, green, blue);
  }

  public void glWindowPos3d(double x, double y, double z) {
    PFNGLWINDOWPOS3DPROC.invoke(address("glWindowPos3d"), x, y, z);
  }

  public void glBlitFramebufferANGLE(int srcX0, int srcY0, int srcX1, int srcY1, int dstX0, int dstY0, int dstX1, int dstY1, int mask, int filter) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetTexParameterIuivOES(int target, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMatrixTranslatefEXT(int mode, float x, float y, float z) {
    PFNGLMATRIXTRANSLATEFEXTPROC.invoke(address("glMatrixTranslatefEXT"), mode, x, y, z);
  }

  public void glUniformMatrix2fv(int location, int count, byte transpose, MemorySegment value) {
    PFNGLUNIFORMMATRIX2FVPROC.invoke(address("glUniformMatrix2fv"), location, count, transpose, value);
  }

  public void glQueryCounter(int id, int target) {
    PFNGLQUERYCOUNTERPROC.invoke(address("glQueryCounter"), id, target);
  }

  public void glColorTableSGI(int target, int internalformat, int width, int format, int type, MemorySegment table) {
    PFNGLCOLORTABLESGIPROC.invoke(address("glColorTableSGI"), target, internalformat, width, format, type, table);
  }

  public void glGetVertexAttribIiv(int index, int pname, MemorySegment params) {
    PFNGLGETVERTEXATTRIBIIVPROC.invoke(address("glGetVertexAttribIiv"), index, pname, params);
  }

  public void glCopyMultiTexImage1DEXT(int texunit, int target, int level, int internalformat, int x, int y, int width, int border) {
    PFNGLCOPYMULTITEXIMAGE1DEXTPROC.invoke(address("glCopyMultiTexImage1DEXT"), texunit, target, level, internalformat, x, y, width, border);
  }

  public void glColorPointerEXT(int size, int type, int stride, int count, MemorySegment pointer) {
    PFNGLCOLORPOINTEREXTPROC.invoke(address("glColorPointerEXT"), size, type, stride, count, pointer);
  }

  public void glPointParameterfvEXT(int pname, MemorySegment params) {
    PFNGLPOINTPARAMETERFVEXTPROC.invoke(address("glPointParameterfvEXT"), pname, params);
  }

  public void glTexCoord1xOES(int s) {
    PFNGLTEXCOORD1XOESPROC.invoke(address("glTexCoord1xOES"), s);
  }

  public void glWindowPos2s(short x, short y) {
    PFNGLWINDOWPOS2SPROC.invoke(address("glWindowPos2s"), x, y);
  }

  public void glProgramUniformui64NV(int program, int location, long value) {
    PFNGLPROGRAMUNIFORMUI64NVPROC.invoke(address("glProgramUniformui64NV"), program, location, value);
  }

  public void glShaderSource(int shader, int count, MemorySegment string, MemorySegment length) {
    PFNGLSHADERSOURCEPROC.invoke(address("glShaderSource"), shader, count, string, length);
  }

  public void glBindBufferRangeNV(int target, int index, int buffer, long offset, long size) {
    PFNGLBINDBUFFERRANGENVPROC.invoke(address("glBindBufferRangeNV"), target, index, buffer, offset, size);
  }

  public void glClearNamedFramebufferfv(int framebuffer, int buffer, int drawbuffer, MemorySegment value) {
    PFNGLCLEARNAMEDFRAMEBUFFERFVPROC.invoke(address("glClearNamedFramebufferfv"), framebuffer, buffer, drawbuffer, value);
  }

  public void glDrawTextureNV(int texture, int sampler, float x0, float y0, float x1, float y1, float z, float s0, float t0, float s1, float t1) {
    PFNGLDRAWTEXTURENVPROC.invoke(address("glDrawTextureNV"), texture, sampler, x0, y0, x1, y1, z, s0, t0, s1, t1);
  }

  public void glFramebufferFoveationParametersQCOM(int framebuffer, int layer, int focalPoint, float focalX, float focalY, float gainX, float gainY, float foveaArea) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBindVideoCaptureStreamBufferNV(int video_capture_slot, int stream, int frame_region, long offset) {
    PFNGLBINDVIDEOCAPTURESTREAMBUFFERNVPROC.invoke(address("glBindVideoCaptureStreamBufferNV"), video_capture_slot, stream, frame_region, offset);
  }

  public void glTextureStorage2D(int texture, int levels, int internalformat, int width, int height) {
    PFNGLTEXTURESTORAGE2DPROC.invoke(address("glTextureStorage2D"), texture, levels, internalformat, width, height);
  }

  public void glTexStorageMem2DMultisampleEXT(int target, int samples, int internalFormat, int width, int height, byte fixedSampleLocations, int memory, long offset) {
    PFNGLTEXSTORAGEMEM2DMULTISAMPLEEXTPROC.invoke(address("glTexStorageMem2DMultisampleEXT"), target, samples, internalFormat, width, height, fixedSampleLocations, memory, offset);
  }

  public void glFlushStaticDataIBM(int target) {
    PFNGLFLUSHSTATICDATAIBMPROC.invoke(address("glFlushStaticDataIBM"), target);
  }

  public void glTangent3ivEXT(MemorySegment v) {
    PFNGLTANGENT3IVEXTPROC.invoke(address("glTangent3ivEXT"), v);
  }

  public void glWindowPos3iv(MemorySegment v) {
    PFNGLWINDOWPOS3IVPROC.invoke(address("glWindowPos3iv"), v);
  }

  public void glGetProgramStringNV(int id, int pname, MemorySegment program) {
    PFNGLGETPROGRAMSTRINGNVPROC.invoke(address("glGetProgramStringNV"), id, pname, program);
  }

  public void glGetQueryObjectuivEXT(int id, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttrib4f(int index, float x, float y, float z, float w) {
    PFNGLVERTEXATTRIB4FPROC.invoke(address("glVertexAttrib4f"), index, x, y, z, w);
  }

  public void glTextureStorage1D(int texture, int levels, int internalformat, int width) {
    PFNGLTEXTURESTORAGE1DPROC.invoke(address("glTextureStorage1D"), texture, levels, internalformat, width);
  }

  public void glVertexAttrib4d(int index, double x, double y, double z, double w) {
    PFNGLVERTEXATTRIB4DPROC.invoke(address("glVertexAttrib4d"), index, x, y, z, w);
  }

  public void glGetVertexAttribdv(int index, int pname, MemorySegment params) {
    PFNGLGETVERTEXATTRIBDVPROC.invoke(address("glGetVertexAttribdv"), index, pname, params);
  }

  public void glEvaluateDepthValuesARB() {
    PFNGLEVALUATEDEPTHVALUESARBPROC.invoke(address("glEvaluateDepthValuesARB"));
  }

  public void glTextureViewEXT(int texture, int target, int origtexture, int internalformat, int minlevel, int numlevels, int minlayer, int numlayers) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glPathParameterfvNV(int path, int pname, MemorySegment value) {
    PFNGLPATHPARAMETERFVNVPROC.invoke(address("glPathParameterfvNV"), path, pname, value);
  }

  public void glBindFragDataLocationEXT(int program, int color, MemorySegment name) {
    PFNGLBINDFRAGDATALOCATIONEXTPROC.invoke(address("glBindFragDataLocationEXT"), program, color, name);
  }

  public void glVertexAttrib4s(int index, short x, short y, short z, short w) {
    PFNGLVERTEXATTRIB4SPROC.invoke(address("glVertexAttrib4s"), index, x, y, z, w);
  }

  public void glBeginTransformFeedbackEXT(int primitiveMode) {
    PFNGLBEGINTRANSFORMFEEDBACKEXTPROC.invoke(address("glBeginTransformFeedbackEXT"), primitiveMode);
  }

  public void glSetFenceAPPLE(int fence) {
    PFNGLSETFENCEAPPLEPROC.invoke(address("glSetFenceAPPLE"), fence);
  }

  public void glFreeObjectBufferATI(int buffer) {
    PFNGLFREEOBJECTBUFFERATIPROC.invoke(address("glFreeObjectBufferATI"), buffer);
  }

  public void glBlendColorEXT(float red, float green, float blue, float alpha) {
    PFNGLBLENDCOLOREXTPROC.invoke(address("glBlendColorEXT"), red, green, blue, alpha);
  }

  public byte glIsImageHandleResidentNV(long handle) {
    return PFNGLISIMAGEHANDLERESIDENTNVPROC.invoke(address("glIsImageHandleResidentNV"), handle);
  }

  public void glVertexP3uiv(int type, MemorySegment value) {
    PFNGLVERTEXP3UIVPROC.invoke(address("glVertexP3uiv"), type, value);
  }

  public void glFramebufferTextureEXT(int target, int attachment, int texture, int level) {
    PFNGLFRAMEBUFFERTEXTUREEXTPROC.invoke(address("glFramebufferTextureEXT"), target, attachment, texture, level);
  }

  public void glUniform3fvARB(int location, int count, MemorySegment value) {
    PFNGLUNIFORM3FVARBPROC.invoke(address("glUniform3fvARB"), location, count, value);
  }

  public void glColorFragmentOp3ATI(int op, int dst, int dstMask, int dstMod, int arg1, int arg1Rep, int arg1Mod, int arg2, int arg2Rep, int arg2Mod, int arg3, int arg3Rep, int arg3Mod) {
    PFNGLCOLORFRAGMENTOP3ATIPROC.invoke(address("glColorFragmentOp3ATI"), op, dst, dstMask, dstMod, arg1, arg1Rep, arg1Mod, arg2, arg2Rep, arg2Mod, arg3, arg3Rep, arg3Mod);
  }

  public void glProgramBufferParametersIivNV(int target, int bindingIndex, int wordIndex, int count, MemorySegment params) {
    PFNGLPROGRAMBUFFERPARAMETERSIIVNVPROC.invoke(address("glProgramBufferParametersIivNV"), target, bindingIndex, wordIndex, count, params);
  }

  public void glStencilThenCoverStrokePathNV(int path, int reference, int mask, int coverMode) {
    PFNGLSTENCILTHENCOVERSTROKEPATHNVPROC.invoke(address("glStencilThenCoverStrokePathNV"), path, reference, mask, coverMode);
  }

  public void glVertexAttribL4dvEXT(int index, MemorySegment v) {
    PFNGLVERTEXATTRIBL4DVEXTPROC.invoke(address("glVertexAttribL4dvEXT"), index, v);
  }

  public void glDebugMessageInsertKHR(int source, int type, int id, int severity, int length, MemorySegment buf) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public byte glReleaseKeyedMutexWin32EXT(int memory, long key) {
    return PFNGLRELEASEKEYEDMUTEXWIN32EXTPROC.invoke(address("glReleaseKeyedMutexWin32EXT"), memory, key);
  }

  public void glSignalSemaphoreui64NVX(int signalGpu, int fenceObjectCount, MemorySegment semaphoreArray, MemorySegment fenceValueArray) {
    PFNGLSIGNALSEMAPHOREUI64NVXPROC.invoke(address("glSignalSemaphoreui64NVX"), signalGpu, fenceObjectCount, semaphoreArray, fenceValueArray);
  }

  public void glGetCompressedTexImageARB(int target, int level, MemorySegment img) {
    PFNGLGETCOMPRESSEDTEXIMAGEARBPROC.invoke(address("glGetCompressedTexImageARB"), target, level, img);
  }

  public void glVertexAttribL2ui64NV(int index, long x, long y) {
    PFNGLVERTEXATTRIBL2UI64NVPROC.invoke(address("glVertexAttribL2ui64NV"), index, x, y);
  }

  public void glVertexArrayElementBuffer(int vaobj, int buffer) {
    PFNGLVERTEXARRAYELEMENTBUFFERPROC.invoke(address("glVertexArrayElementBuffer"), vaobj, buffer);
  }

  public void glColor4ubVertex2fvSUN(MemorySegment c, MemorySegment v) {
    PFNGLCOLOR4UBVERTEX2FVSUNPROC.invoke(address("glColor4ubVertex2fvSUN"), c, v);
  }

  public void glTextureStorage3D(int texture, int levels, int internalformat, int width, int height, int depth) {
    PFNGLTEXTURESTORAGE3DPROC.invoke(address("glTextureStorage3D"), texture, levels, internalformat, width, height, depth);
  }

  public void glProgramUniformMatrix4x2fv(int program, int location, int count, byte transpose, MemorySegment value) {
    PFNGLPROGRAMUNIFORMMATRIX4X2FVPROC.invoke(address("glProgramUniformMatrix4x2fv"), program, location, count, transpose, value);
  }

  public void glUniform4uivEXT(int location, int count, MemorySegment value) {
    PFNGLUNIFORM4UIVEXTPROC.invoke(address("glUniform4uivEXT"), location, count, value);
  }

  public void glBindMultiTextureEXT(int texunit, int target, int texture) {
    PFNGLBINDMULTITEXTUREEXTPROC.invoke(address("glBindMultiTextureEXT"), texunit, target, texture);
  }

  public MemorySegment glMapNamedBufferRange(int buffer, long offset, long length, int access) {
    return PFNGLMAPNAMEDBUFFERRANGEPROC.invoke(address("glMapNamedBufferRange"), buffer, offset, length, access);
  }

  public void glVertexAttribs2fvNV(int index, int count, MemorySegment v) {
    PFNGLVERTEXATTRIBS2FVNVPROC.invoke(address("glVertexAttribs2fvNV"), index, count, v);
  }

  public void glWindowPos3fv(MemorySegment v) {
    PFNGLWINDOWPOS3FVPROC.invoke(address("glWindowPos3fv"), v);
  }

  public void glGlobalAlphaFactoruiSUN(int factor) {
    PFNGLGLOBALALPHAFACTORUISUNPROC.invoke(address("glGlobalAlphaFactoruiSUN"), factor);
  }

  public void glClearNamedFramebufferfi(int framebuffer, int buffer, int drawbuffer, float depth, int stencil) {
    PFNGLCLEARNAMEDFRAMEBUFFERFIPROC.invoke(address("glClearNamedFramebufferfi"), framebuffer, buffer, drawbuffer, depth, stencil);
  }

  public void glNamedRenderbufferStorageMultisample(int renderbuffer, int samples, int internalformat, int width, int height) {
    PFNGLNAMEDRENDERBUFFERSTORAGEMULTISAMPLEPROC.invoke(address("glNamedRenderbufferStorageMultisample"), renderbuffer, samples, internalformat, width, height);
  }

  public void glGetTexParameterIivEXT(int target, int pname, MemorySegment params) {
    PFNGLGETTEXPARAMETERIIVEXTPROC.invoke(address("glGetTexParameterIivEXT"), target, pname, params);
  }

  public void glCombinerParameterfNV(int pname, float param) {
    PFNGLCOMBINERPARAMETERFNVPROC.invoke(address("glCombinerParameterfNV"), pname, param);
  }

  public void glGetVertexAttribfv(int index, int pname, MemorySegment params) {
    PFNGLGETVERTEXATTRIBFVPROC.invoke(address("glGetVertexAttribfv"), index, pname, params);
  }

  public void glPointParameterx(int pname, int param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glSampleMaskEXT(float value, byte invert) {
    PFNGLSAMPLEMASKEXTPROC.invoke(address("glSampleMaskEXT"), value, invert);
  }

  public void glCopyTextureSubImage2DEXT(int texture, int target, int level, int xoffset, int yoffset, int x, int y, int width, int height) {
    PFNGLCOPYTEXTURESUBIMAGE2DEXTPROC.invoke(address("glCopyTextureSubImage2DEXT"), texture, target, level, xoffset, yoffset, x, y, width, height);
  }

  public void glVertexAttribL4i64vNV(int index, MemorySegment v) {
    PFNGLVERTEXATTRIBL4I64VNVPROC.invoke(address("glVertexAttribL4i64vNV"), index, v);
  }

  public void glMaterialxvOES(int face, int pname, MemorySegment param) {
    PFNGLMATERIALXVOESPROC.invoke(address("glMaterialxvOES"), face, pname, param);
  }

  public void glGetFinalCombinerInputParameterivNV(int variable, int pname, MemorySegment params) {
    PFNGLGETFINALCOMBINERINPUTPARAMETERIVNVPROC.invoke(address("glGetFinalCombinerInputParameterivNV"), variable, pname, params);
  }

  public void glPointParameteri(int pname, int param) {
    PFNGLPOINTPARAMETERIPROC.invoke(address("glPointParameteri"), pname, param);
  }

  public void glPointParameterf(int pname, float param) {
    PFNGLPOINTPARAMETERFPROC.invoke(address("glPointParameterf"), pname, param);
  }

  public void glDepthRangeArrayv(int first, int count, MemorySegment v) {
    PFNGLDEPTHRANGEARRAYVPROC.invoke(address("glDepthRangeArrayv"), first, count, v);
  }

  public void glGetnConvolutionFilterARB(int target, int format, int type, int bufSize, MemorySegment image) {
    PFNGLGETNCONVOLUTIONFILTERARBPROC.invoke(address("glGetnConvolutionFilterARB"), target, format, type, bufSize, image);
  }

  public void glColor4x(int red, int green, int blue, int alpha) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetVertexAttribIivEXT(int index, int pname, MemorySegment params) {
    PFNGLGETVERTEXATTRIBIIVEXTPROC.invoke(address("glGetVertexAttribIivEXT"), index, pname, params);
  }

  public void glVertexAttrib4svARB(int index, MemorySegment v) {
    PFNGLVERTEXATTRIB4SVARBPROC.invoke(address("glVertexAttrib4svARB"), index, v);
  }

  public void glTexBufferARB(int target, int internalformat, int buffer) {
    PFNGLTEXBUFFERARBPROC.invoke(address("glTexBufferARB"), target, internalformat, buffer);
  }

  public void glTextureStorage2DMultisampleEXT(int texture, int target, int samples, int internalformat, int width, int height, byte fixedsamplelocations) {
    PFNGLTEXTURESTORAGE2DMULTISAMPLEEXTPROC.invoke(address("glTextureStorage2DMultisampleEXT"), texture, target, samples, internalformat, width, height, fixedsamplelocations);
  }

  public void glReadnPixelsARB(int x, int y, int width, int height, int format, int type, int bufSize, MemorySegment data) {
    PFNGLREADNPIXELSARBPROC.invoke(address("glReadnPixelsARB"), x, y, width, height, format, type, bufSize, data);
  }

  public void glTexCoordPointerEXT(int size, int type, int stride, int count, MemorySegment pointer) {
    PFNGLTEXCOORDPOINTEREXTPROC.invoke(address("glTexCoordPointerEXT"), size, type, stride, count, pointer);
  }

  public void glFragmentLightModelfSGIX(int pname, float param) {
    PFNGLFRAGMENTLIGHTMODELFSGIXPROC.invoke(address("glFragmentLightModelfSGIX"), pname, param);
  }

  public void glMakeTextureHandleResidentNV(long handle) {
    PFNGLMAKETEXTUREHANDLERESIDENTNVPROC.invoke(address("glMakeTextureHandleResidentNV"), handle);
  }

  public void glVertexAttribI2ui(int index, int x, int y) {
    PFNGLVERTEXATTRIBI2UIPROC.invoke(address("glVertexAttribI2ui"), index, x, y);
  }

  public void glPrimitiveRestartIndex(int index) {
    PFNGLPRIMITIVERESTARTINDEXPROC.invoke(address("glPrimitiveRestartIndex"), index);
  }

  public void glWeightuivARB(int size, MemorySegment weights) {
    PFNGLWEIGHTUIVARBPROC.invoke(address("glWeightuivARB"), size, weights);
  }

  public void glLightModelxv(int pname, MemorySegment param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexStorageMem3DMultisampleEXT(int target, int samples, int internalFormat, int width, int height, int depth, byte fixedSampleLocations, int memory, long offset) {
    PFNGLTEXSTORAGEMEM3DMULTISAMPLEEXTPROC.invoke(address("glTexStorageMem3DMultisampleEXT"), target, samples, internalFormat, width, height, depth, fixedSampleLocations, memory, offset);
  }

  public MemorySegment glMapBufferRange(int target, long offset, long length, int access) {
    return PFNGLMAPBUFFERRANGEPROC.invoke(address("glMapBufferRange"), target, offset, length, access);
  }

  public void glVertexAttribs3hvNV(int index, int n, MemorySegment v) {
    PFNGLVERTEXATTRIBS3HVNVPROC.invoke(address("glVertexAttribs3hvNV"), index, n, v);
  }

  public byte glIsFramebuffer(int framebuffer) {
    return PFNGLISFRAMEBUFFERPROC.invoke(address("glIsFramebuffer"), framebuffer);
  }

  public void glGetVertexAttribArrayObjectfvATI(int index, int pname, MemorySegment params) {
    PFNGLGETVERTEXATTRIBARRAYOBJECTFVATIPROC.invoke(address("glGetVertexAttribArrayObjectfvATI"), index, pname, params);
  }

  public void glUniform2i64vARB(int location, int count, MemorySegment value) {
    PFNGLUNIFORM2I64VARBPROC.invoke(address("glUniform2i64vARB"), location, count, value);
  }

  public void glGetShaderSource(int shader, int bufSize, MemorySegment length, MemorySegment source) {
    PFNGLGETSHADERSOURCEPROC.invoke(address("glGetShaderSource"), shader, bufSize, length, source);
  }

  public void glVertexAttribs3svNV(int index, int count, MemorySegment v) {
    PFNGLVERTEXATTRIBS3SVNVPROC.invoke(address("glVertexAttribs3svNV"), index, count, v);
  }

  public void glGetVertexAttribiv(int index, int pname, MemorySegment params) {
    PFNGLGETVERTEXATTRIBIVPROC.invoke(address("glGetVertexAttribiv"), index, pname, params);
  }

  public void glVertexAttribL2i64vNV(int index, MemorySegment v) {
    PFNGLVERTEXATTRIBL2I64VNVPROC.invoke(address("glVertexAttribL2i64vNV"), index, v);
  }

  public void glCompressedTexSubImage1DARB(int target, int level, int xoffset, int width, int format, int imageSize, MemorySegment data) {
    PFNGLCOMPRESSEDTEXSUBIMAGE1DARBPROC.invoke(address("glCompressedTexSubImage1DARB"), target, level, xoffset, width, format, imageSize, data);
  }

  public void glCoverStrokePathInstancedNV(int numPaths, int pathNameType, MemorySegment paths, int pathBase, int coverMode, int transformType, MemorySegment transformValues) {
    PFNGLCOVERSTROKEPATHINSTANCEDNVPROC.invoke(address("glCoverStrokePathInstancedNV"), numPaths, pathNameType, paths, pathBase, coverMode, transformType, transformValues);
  }

  public void glUniform2uivEXT(int location, int count, MemorySegment value) {
    PFNGLUNIFORM2UIVEXTPROC.invoke(address("glUniform2uivEXT"), location, count, value);
  }

  public void glClearNamedFramebufferiv(int framebuffer, int buffer, int drawbuffer, MemorySegment value) {
    PFNGLCLEARNAMEDFRAMEBUFFERIVPROC.invoke(address("glClearNamedFramebufferiv"), framebuffer, buffer, drawbuffer, value);
  }

  public void glTexStorage3DEXT(int target, int levels, int internalformat, int width, int height, int depth) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetProgramBinary(int program, int bufSize, MemorySegment length, MemorySegment binaryFormat, MemorySegment binary) {
    PFNGLGETPROGRAMBINARYPROC.invoke(address("glGetProgramBinary"), program, bufSize, length, binaryFormat, binary);
  }

  public void glRenderbufferStorageMultisampleAdvancedAMD(int target, int samples, int storageSamples, int internalformat, int width, int height) {
    PFNGLRENDERBUFFERSTORAGEMULTISAMPLEADVANCEDAMDPROC.invoke(address("glRenderbufferStorageMultisampleAdvancedAMD"), target, samples, storageSamples, internalformat, width, height);
  }

  public void glWindowPos2svMESA(MemorySegment v) {
    PFNGLWINDOWPOS2SVMESAPROC.invoke(address("glWindowPos2svMESA"), v);
  }

  public void glElementPointerAPPLE(int type, MemorySegment pointer) {
    PFNGLELEMENTPOINTERAPPLEPROC.invoke(address("glElementPointerAPPLE"), type, pointer);
  }

  public void glGetQueryObjectiv(int id, int pname, MemorySegment params) {
    PFNGLGETQUERYOBJECTIVPROC.invoke(address("glGetQueryObjectiv"), id, pname, params);
  }

  public byte glIsProgramPipelineEXT(int pipeline) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glColorP4uiv(int type, MemorySegment color) {
    PFNGLCOLORP4UIVPROC.invoke(address("glColorP4uiv"), type, color);
  }

  public void glBindTransformFeedback(int target, int id) {
    PFNGLBINDTRANSFORMFEEDBACKPROC.invoke(address("glBindTransformFeedback"), target, id);
  }

  public void glPointParameterfEXT(int pname, float param) {
    PFNGLPOINTPARAMETERFEXTPROC.invoke(address("glPointParameterfEXT"), pname, param);
  }

  public void glGetPathParameterivNV(int path, int pname, MemorySegment value) {
    PFNGLGETPATHPARAMETERIVNVPROC.invoke(address("glGetPathParameterivNV"), path, pname, value);
  }

  public void glGenQueryResourceTagNV(int n, MemorySegment tagIds) {
    PFNGLGENQUERYRESOURCETAGNVPROC.invoke(address("glGenQueryResourceTagNV"), n, tagIds);
  }

  public void glObjectLabel(int identifier, int name, int length, MemorySegment label) {
    PFNGLOBJECTLABELPROC.invoke(address("glObjectLabel"), identifier, name, length, label);
  }

  public void glVDPAUGetSurfaceivNV(long surface, int pname, int count, MemorySegment length, MemorySegment values) {
    PFNGLVDPAUGETSURFACEIVNVPROC.invoke(address("glVDPAUGetSurfaceivNV"), surface, pname, count, length, values);
  }

  public void glUnmapTexture2DINTEL(int texture, int level) {
    PFNGLUNMAPTEXTURE2DINTELPROC.invoke(address("glUnmapTexture2DINTEL"), texture, level);
  }

  public void glVertexStream1fvATI(int stream, MemorySegment coords) {
    PFNGLVERTEXSTREAM1FVATIPROC.invoke(address("glVertexStream1fvATI"), stream, coords);
  }

  public int glGetUniformLocationARB(int programObj, MemorySegment name) {
    return PFNGLGETUNIFORMLOCATIONARBPROC.invoke(address("glGetUniformLocationARB"), programObj, name);
  }

  public void glDeleteFencesAPPLE(int n, MemorySegment fences) {
    PFNGLDELETEFENCESAPPLEPROC.invoke(address("glDeleteFencesAPPLE"), n, fences);
  }

  public void glGetTransformFeedbackiv(int xfb, int pname, MemorySegment param) {
    PFNGLGETTRANSFORMFEEDBACKIVPROC.invoke(address("glGetTransformFeedbackiv"), xfb, pname, param);
  }

  public void glVertexAttribParameteriAMD(int index, int pname, int param) {
    PFNGLVERTEXATTRIBPARAMETERIAMDPROC.invoke(address("glVertexAttribParameteriAMD"), index, pname, param);
  }

  public void glFragmentCoverageColorNV(int color) {
    PFNGLFRAGMENTCOVERAGECOLORNVPROC.invoke(address("glFragmentCoverageColorNV"), color);
  }

  public int glGetProgramResourceLocationIndex(int program, int programInterface, MemorySegment name) {
    return PFNGLGETPROGRAMRESOURCELOCATIONINDEXPROC.invoke(address("glGetProgramResourceLocationIndex"), program, programInterface, name);
  }

  public void glGetImageTransformParameterfvHP(int target, int pname, MemorySegment params) {
    PFNGLGETIMAGETRANSFORMPARAMETERFVHPPROC.invoke(address("glGetImageTransformParameterfvHP"), target, pname, params);
  }

  public void glProgramUniform1i64NV(int program, int location, long x) {
    PFNGLPROGRAMUNIFORM1I64NVPROC.invoke(address("glProgramUniform1i64NV"), program, location, x);
  }

  public byte glIsBufferARB(int buffer) {
    return PFNGLISBUFFERARBPROC.invoke(address("glIsBufferARB"), buffer);
  }

  public void glGetVertexAttribLui64vNV(int index, int pname, MemorySegment params) {
    PFNGLGETVERTEXATTRIBLUI64VNVPROC.invoke(address("glGetVertexAttribLui64vNV"), index, pname, params);
  }

  public void glProgramParameteriARB(int program, int pname, int value) {
    PFNGLPROGRAMPARAMETERIARBPROC.invoke(address("glProgramParameteriARB"), program, pname, value);
  }

  public void glActiveStencilFaceEXT(int face) {
    PFNGLACTIVESTENCILFACEEXTPROC.invoke(address("glActiveStencilFaceEXT"), face);
  }

  public void glLoadTransposeMatrixxOES(MemorySegment m) {
    PFNGLLOADTRANSPOSEMATRIXXOESPROC.invoke(address("glLoadTransposeMatrixxOES"), m);
  }

  public void glVertexStream4svATI(int stream, MemorySegment coords) {
    PFNGLVERTEXSTREAM4SVATIPROC.invoke(address("glVertexStream4svATI"), stream, coords);
  }

  public void glTexEnvxvOES(int target, int pname, MemorySegment params) {
    PFNGLTEXENVXVOESPROC.invoke(address("glTexEnvxvOES"), target, pname, params);
  }

  public void glNamedProgramLocalParameterI4uiEXT(int program, int target, int index, int x, int y, int z, int w) {
    PFNGLNAMEDPROGRAMLOCALPARAMETERI4UIEXTPROC.invoke(address("glNamedProgramLocalParameterI4uiEXT"), program, target, index, x, y, z, w);
  }

  public void glFogCoordFormatNV(int type, int stride) {
    PFNGLFOGCOORDFORMATNVPROC.invoke(address("glFogCoordFormatNV"), type, stride);
  }

  public void glGetIntegeri_vEXT(int target, int index, MemorySegment data) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glCreateRenderbuffers(int n, MemorySegment renderbuffers) {
    PFNGLCREATERENDERBUFFERSPROC.invoke(address("glCreateRenderbuffers"), n, renderbuffers);
  }

  public void glGetFramebufferParameterivMESA(int target, int pname, MemorySegment params) {
    PFNGLGETFRAMEBUFFERPARAMETERIVMESAPROC.invoke(address("glGetFramebufferParameterivMESA"), target, pname, params);
  }

  public void glGetConvolutionParameterfvEXT(int target, int pname, MemorySegment params) {
    PFNGLGETCONVOLUTIONPARAMETERFVEXTPROC.invoke(address("glGetConvolutionParameterfvEXT"), target, pname, params);
  }

  public void glTexCoord2fColor4fNormal3fVertex3fvSUN(MemorySegment tc, MemorySegment c, MemorySegment n, MemorySegment v) {
    PFNGLTEXCOORD2FCOLOR4FNORMAL3FVERTEX3FVSUNPROC.invoke(address("glTexCoord2fColor4fNormal3fVertex3fvSUN"), tc, c, n, v);
  }

  public void glReadnPixels(int x, int y, int width, int height, int format, int type, int bufSize, MemorySegment data) {
    PFNGLREADNPIXELSPROC.invoke(address("glReadnPixels"), x, y, width, height, format, type, bufSize, data);
  }

  public void glCombinerInputNV(int stage, int portion, int variable, int input, int mapping, int componentUsage) {
    PFNGLCOMBINERINPUTNVPROC.invoke(address("glCombinerInputNV"), stage, portion, variable, input, mapping, componentUsage);
  }

  public long glVDPAURegisterOutputSurfaceNV(MemorySegment vdpSurface, int target, int numTextureNames, MemorySegment textureNames) {
    return PFNGLVDPAUREGISTEROUTPUTSURFACENVPROC.invoke(address("glVDPAURegisterOutputSurfaceNV"), vdpSurface, target, numTextureNames, textureNames);
  }

  public void glMultiTexEnvfEXT(int texunit, int target, int pname, float param) {
    PFNGLMULTITEXENVFEXTPROC.invoke(address("glMultiTexEnvfEXT"), texunit, target, pname, param);
  }

  public byte glIsProgramPipeline(int pipeline) {
    return PFNGLISPROGRAMPIPELINEPROC.invoke(address("glIsProgramPipeline"), pipeline);
  }

  public int glPathMemoryGlyphIndexArrayNV(int firstPathName, int fontTarget, long fontSize, MemorySegment fontData, int faceIndex, int firstGlyphIndex, int numGlyphs, int pathParameterTemplate, float emScale) {
    return PFNGLPATHMEMORYGLYPHINDEXARRAYNVPROC.invoke(address("glPathMemoryGlyphIndexArrayNV"), firstPathName, fontTarget, fontSize, fontData, faceIndex, firstGlyphIndex, numGlyphs, pathParameterTemplate, emScale);
  }

  public void glVertexAttrib1d(int index, double x) {
    PFNGLVERTEXATTRIB1DPROC.invoke(address("glVertexAttrib1d"), index, x);
  }

  public void glWindowPos2sARB(short x, short y) {
    PFNGLWINDOWPOS2SARBPROC.invoke(address("glWindowPos2sARB"), x, y);
  }

  public void glLinkProgramARB(int programObj) {
    PFNGLLINKPROGRAMARBPROC.invoke(address("glLinkProgramARB"), programObj);
  }

  public void glUniform4ivARB(int location, int count, MemorySegment value) {
    PFNGLUNIFORM4IVARBPROC.invoke(address("glUniform4ivARB"), location, count, value);
  }

  public void glVertexAttrib1f(int index, float x) {
    PFNGLVERTEXATTRIB1FPROC.invoke(address("glVertexAttrib1f"), index, x);
  }

  public void glDeleteQueriesEXT(int n, MemorySegment ids) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultTransposeMatrixfARB(MemorySegment m) {
    PFNGLMULTTRANSPOSEMATRIXFARBPROC.invoke(address("glMultTransposeMatrixfARB"), m);
  }

  public void glVertexAttrib1s(int index, short x) {
    PFNGLVERTEXATTRIB1SPROC.invoke(address("glVertexAttrib1s"), index, x);
  }

  public void glGetnUniformuiv(int program, int location, int bufSize, MemorySegment params) {
    PFNGLGETNUNIFORMUIVPROC.invoke(address("glGetnUniformuiv"), program, location, bufSize, params);
  }

  public void glCopyImageSubDataOES(int srcName, int srcTarget, int srcLevel, int srcX, int srcY, int srcZ, int dstName, int dstTarget, int dstLevel, int dstX, int dstY, int dstZ, int srcWidth, int srcHeight, int srcDepth) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBindRenderbufferOES(int target, int renderbuffer) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glPassThroughxOES(int token) {
    PFNGLPASSTHROUGHXOESPROC.invoke(address("glPassThroughxOES"), token);
  }

  public void glGlobalAlphaFactorfSUN(float factor) {
    PFNGLGLOBALALPHAFACTORFSUNPROC.invoke(address("glGlobalAlphaFactorfSUN"), factor);
  }

  public void glVertexStream2ivATI(int stream, MemorySegment coords) {
    PFNGLVERTEXSTREAM2IVATIPROC.invoke(address("glVertexStream2ivATI"), stream, coords);
  }

  public void glVertexAttribL4ui64NV(int index, long x, long y, long z, long w) {
    PFNGLVERTEXATTRIBL4UI64NVPROC.invoke(address("glVertexAttribL4ui64NV"), index, x, y, z, w);
  }

  public void glNamedBufferPageCommitmentMemNV(int buffer, long offset, long size, int memory, long memOffset, byte commit) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexCoord3hvNV(int target, MemorySegment v) {
    PFNGLMULTITEXCOORD3HVNVPROC.invoke(address("glMultiTexCoord3hvNV"), target, v);
  }

  public void glFramebufferDrawBuffersEXT(int framebuffer, int n, MemorySegment bufs) {
    PFNGLFRAMEBUFFERDRAWBUFFERSEXTPROC.invoke(address("glFramebufferDrawBuffersEXT"), framebuffer, n, bufs);
  }

  public int glNewObjectBufferATI(int size, MemorySegment pointer, int usage) {
    return PFNGLNEWOBJECTBUFFERATIPROC.invoke(address("glNewObjectBufferATI"), size, pointer, usage);
  }

  public void glTextureStorage3DMultisampleEXT(int texture, int target, int samples, int internalformat, int width, int height, int depth, byte fixedsamplelocations) {
    PFNGLTEXTURESTORAGE3DMULTISAMPLEEXTPROC.invoke(address("glTextureStorage3DMultisampleEXT"), texture, target, samples, internalformat, width, height, depth, fixedsamplelocations);
  }

  public void glWindowPos3dv(MemorySegment v) {
    PFNGLWINDOWPOS3DVPROC.invoke(address("glWindowPos3dv"), v);
  }

  public void glSecondaryColor3usv(MemorySegment v) {
    PFNGLSECONDARYCOLOR3USVPROC.invoke(address("glSecondaryColor3usv"), v);
  }

  public void glGetnUniformuivKHR(int program, int location, int bufSize, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertex2xvOES(MemorySegment coords) {
    PFNGLVERTEX2XVOESPROC.invoke(address("glVertex2xvOES"), coords);
  }

  public void glVertexAttrib3f(int index, float x, float y, float z) {
    PFNGLVERTEXATTRIB3FPROC.invoke(address("glVertexAttrib3f"), index, x, y, z);
  }

  public void glVertexAttrib3d(int index, double x, double y, double z) {
    PFNGLVERTEXATTRIB3DPROC.invoke(address("glVertexAttrib3d"), index, x, y, z);
  }

  public void glMultiTexCoord2bvOES(int texture, MemorySegment coords) {
    PFNGLMULTITEXCOORD2BVOESPROC.invoke(address("glMultiTexCoord2bvOES"), texture, coords);
  }

  public void glGetProgramEnvParameterfvARB(int target, int index, MemorySegment params) {
    PFNGLGETPROGRAMENVPARAMETERFVARBPROC.invoke(address("glGetProgramEnvParameterfvARB"), target, index, params);
  }

  public void glMakeImageHandleResidentARB(long handle, int access) {
    PFNGLMAKEIMAGEHANDLERESIDENTARBPROC.invoke(address("glMakeImageHandleResidentARB"), handle, access);
  }

  public void glUniform1ui64vNV(int location, int count, MemorySegment value) {
    PFNGLUNIFORM1UI64VNVPROC.invoke(address("glUniform1ui64vNV"), location, count, value);
  }

  public void glMatrixLoadTransposefEXT(int mode, MemorySegment m) {
    PFNGLMATRIXLOADTRANSPOSEFEXTPROC.invoke(address("glMatrixLoadTransposefEXT"), mode, m);
  }

  public void glResolveDepthValuesNV() {
    PFNGLRESOLVEDEPTHVALUESNVPROC.invoke(address("glResolveDepthValuesNV"));
  }

  public void glVertexAttrib3s(int index, short x, short y, short z) {
    PFNGLVERTEXATTRIB3SPROC.invoke(address("glVertexAttrib3s"), index, x, y, z);
  }

  public void glSecondaryColor3sEXT(short red, short green, short blue) {
    PFNGLSECONDARYCOLOR3SEXTPROC.invoke(address("glSecondaryColor3sEXT"), red, green, blue);
  }

  public void glGetVertexAttribLi64vNV(int index, int pname, MemorySegment params) {
    PFNGLGETVERTEXATTRIBLI64VNVPROC.invoke(address("glGetVertexAttribLi64vNV"), index, pname, params);
  }

  public void glBlendEquationiOES(int buf, int mode) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttrib2f(int index, float x, float y) {
    PFNGLVERTEXATTRIB2FPROC.invoke(address("glVertexAttrib2f"), index, x, y);
  }

  public void glVertexAttrib2d(int index, double x, double y) {
    PFNGLVERTEXATTRIB2DPROC.invoke(address("glVertexAttrib2d"), index, x, y);
  }

  public void glCopyImageSubData(int srcName, int srcTarget, int srcLevel, int srcX, int srcY, int srcZ, int dstName, int dstTarget, int dstLevel, int dstX, int dstY, int dstZ, int srcWidth, int srcHeight, int srcDepth) {
    PFNGLCOPYIMAGESUBDATAPROC.invoke(address("glCopyImageSubData"), srcName, srcTarget, srcLevel, srcX, srcY, srcZ, dstName, dstTarget, dstLevel, dstX, dstY, dstZ, srcWidth, srcHeight, srcDepth);
  }

  public byte glIsSync(MemorySegment sync) {
    return PFNGLISSYNCPROC.invoke(address("glIsSync"), sync);
  }

  public void glMatrixRotatedEXT(int mode, double angle, double x, double y, double z) {
    PFNGLMATRIXROTATEDEXTPROC.invoke(address("glMatrixRotatedEXT"), mode, angle, x, y, z);
  }

  public void glVertexAttrib2sv(int index, MemorySegment v) {
    PFNGLVERTEXATTRIB2SVPROC.invoke(address("glVertexAttrib2sv"), index, v);
  }

  public void glMultiDrawElementsEXT(int mode, MemorySegment count, int type, MemorySegment indices, int primcount) {
    PFNGLMULTIDRAWELEMENTSEXTPROC.invoke(address("glMultiDrawElementsEXT"), mode, count, type, indices, primcount);
  }

  public void glVertexAttrib2s(int index, short x, short y) {
    PFNGLVERTEXATTRIB2SPROC.invoke(address("glVertexAttrib2s"), index, x, y);
  }

  public void glMap1xOES(int target, int u1, int u2, int stride, int order, int points) {
    PFNGLMAP1XOESPROC.invoke(address("glMap1xOES"), target, u1, u2, stride, order, points);
  }

  public void glTexCoord4hNV(short s, short t, short r, short q) {
    PFNGLTEXCOORD4HNVPROC.invoke(address("glTexCoord4hNV"), s, t, r, q);
  }

  public byte glIsFenceNV(int fence) {
    return PFNGLISFENCENVPROC.invoke(address("glIsFenceNV"), fence);
  }

  public void glLinkProgram(int program) {
    PFNGLLINKPROGRAMPROC.invoke(address("glLinkProgram"), program);
  }

  public void glFramebufferTexture3DOES(int target, int attachment, int textarget, int texture, int level, int zoffset) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexP2ui(int type, int value) {
    PFNGLVERTEXP2UIPROC.invoke(address("glVertexP2ui"), type, value);
  }

  public void glGetFixedvOES(int pname, MemorySegment params) {
    PFNGLGETFIXEDVOESPROC.invoke(address("glGetFixedvOES"), pname, params);
  }

  public void glLoadIdentityDeformationMapSGIX(int mask) {
    PFNGLLOADIDENTITYDEFORMATIONMAPSGIXPROC.invoke(address("glLoadIdentityDeformationMapSGIX"), mask);
  }

  public void glDrawMeshTasksNV(int first, int count) {
    PFNGLDRAWMESHTASKSNVPROC.invoke(address("glDrawMeshTasksNV"), first, count);
  }

  public void glVertexAttrib1fvARB(int index, MemorySegment v) {
    PFNGLVERTEXATTRIB1FVARBPROC.invoke(address("glVertexAttrib1fvARB"), index, v);
  }

  public void glHintPGI(int target, int mode) {
    PFNGLHINTPGIPROC.invoke(address("glHintPGI"), target, mode);
  }

  public void glBindRenderbuffer(int target, int renderbuffer) {
    PFNGLBINDRENDERBUFFERPROC.invoke(address("glBindRenderbuffer"), target, renderbuffer);
  }

  public void glAlphaFuncxOES(int func, int ref) {
    PFNGLALPHAFUNCXOESPROC.invoke(address("glAlphaFuncxOES"), func, ref);
  }

  public void glVertexAttribL3dEXT(int index, double x, double y, double z) {
    PFNGLVERTEXATTRIBL3DEXTPROC.invoke(address("glVertexAttribL3dEXT"), index, x, y, z);
  }

  public void glTexGeniOES(int coord, int pname, int param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUseProgramStages(int pipeline, int stages, int program) {
    PFNGLUSEPROGRAMSTAGESPROC.invoke(address("glUseProgramStages"), pipeline, stages, program);
  }

  public void glNamedBufferDataEXT(int buffer, long size, MemorySegment data, int usage) {
    PFNGLNAMEDBUFFERDATAEXTPROC.invoke(address("glNamedBufferDataEXT"), buffer, size, data, usage);
  }

  public void glBufferAttachMemoryNV(int target, int memory, long offset) {
    PFNGLBUFFERATTACHMEMORYNVPROC.invoke(address("glBufferAttachMemoryNV"), target, memory, offset);
  }

  public void glUniform4ui64ARB(int location, long x, long y, long z, long w) {
    PFNGLUNIFORM4UI64ARBPROC.invoke(address("glUniform4ui64ARB"), location, x, y, z, w);
  }

  public void glProgramSubroutineParametersuivNV(int target, int count, MemorySegment params) {
    PFNGLPROGRAMSUBROUTINEPARAMETERSUIVNVPROC.invoke(address("glProgramSubroutineParametersuivNV"), target, count, params);
  }

  public void glSecondaryColorPointerListIBM(int size, int type, int stride, MemorySegment pointer, int ptrstride) {
    PFNGLSECONDARYCOLORPOINTERLISTIBMPROC.invoke(address("glSecondaryColorPointerListIBM"), size, type, stride, pointer, ptrstride);
  }

  public void glUniform3fARB(int location, float v0, float v1, float v2) {
    PFNGLUNIFORM3FARBPROC.invoke(address("glUniform3fARB"), location, v0, v1, v2);
  }

  public void glProgramUniform1fEXT(int program, int location, float v0) {
    PFNGLPROGRAMUNIFORM1FEXTPROC.invoke(address("glProgramUniform1fEXT"), program, location, v0);
  }

  public void glVertexBlendARB(int count) {
    PFNGLVERTEXBLENDARBPROC.invoke(address("glVertexBlendARB"), count);
  }

  public void glGenProgramsNV(int n, MemorySegment programs) {
    PFNGLGENPROGRAMSNVPROC.invoke(address("glGenProgramsNV"), n, programs);
  }

  public void glNamedFramebufferTextureEXT(int framebuffer, int attachment, int texture, int level) {
    PFNGLNAMEDFRAMEBUFFERTEXTUREEXTPROC.invoke(address("glNamedFramebufferTextureEXT"), framebuffer, attachment, texture, level);
  }

  public void glScissorIndexedNV(int index, int left, int bottom, int width, int height) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribI1uiEXT(int index, int x) {
    PFNGLVERTEXATTRIBI1UIEXTPROC.invoke(address("glVertexAttribI1uiEXT"), index, x);
  }

  public void glFragmentLightivSGIX(int light, int pname, MemorySegment params) {
    PFNGLFRAGMENTLIGHTIVSGIXPROC.invoke(address("glFragmentLightivSGIX"), light, pname, params);
  }

  public void glUniformMatrix4fvARB(int location, int count, byte transpose, MemorySegment value) {
    PFNGLUNIFORMMATRIX4FVARBPROC.invoke(address("glUniformMatrix4fvARB"), location, count, transpose, value);
  }

  public void glTexCoord1hvNV(MemorySegment v) {
    PFNGLTEXCOORD1HVNVPROC.invoke(address("glTexCoord1hvNV"), v);
  }

  public void glGetVideoCaptureStreamfvNV(int video_capture_slot, int stream, int pname, MemorySegment params) {
    PFNGLGETVIDEOCAPTURESTREAMFVNVPROC.invoke(address("glGetVideoCaptureStreamfvNV"), video_capture_slot, stream, pname, params);
  }

  public void glMatrixIndexuivARB(int size, MemorySegment indices) {
    PFNGLMATRIXINDEXUIVARBPROC.invoke(address("glMatrixIndexuivARB"), size, indices);
  }

  public void glMultiTexCoord3bvOES(int texture, MemorySegment coords) {
    PFNGLMULTITEXCOORD3BVOESPROC.invoke(address("glMultiTexCoord3bvOES"), texture, coords);
  }

  public void glClearNamedBufferData(int buffer, int internalformat, int format, int type, MemorySegment data) {
    PFNGLCLEARNAMEDBUFFERDATAPROC.invoke(address("glClearNamedBufferData"), buffer, internalformat, format, type, data);
  }

  public void glFramebufferSamplePositionsfvAMD(int target, int numsamples, int pixelindex, MemorySegment values) {
    PFNGLFRAMEBUFFERSAMPLEPOSITIONSFVAMDPROC.invoke(address("glFramebufferSamplePositionsfvAMD"), target, numsamples, pixelindex, values);
  }

  public void glCoverFillPathInstancedNV(int numPaths, int pathNameType, MemorySegment paths, int pathBase, int coverMode, int transformType, MemorySegment transformValues) {
    PFNGLCOVERFILLPATHINSTANCEDNVPROC.invoke(address("glCoverFillPathInstancedNV"), numPaths, pathNameType, paths, pathBase, coverMode, transformType, transformValues);
  }

  public void glTextureParameterIiv(int texture, int pname, MemorySegment params) {
    PFNGLTEXTUREPARAMETERIIVPROC.invoke(address("glTextureParameterIiv"), texture, pname, params);
  }

  public void glGetHistogramParameterfvEXT(int target, int pname, MemorySegment params) {
    PFNGLGETHISTOGRAMPARAMETERFVEXTPROC.invoke(address("glGetHistogramParameterfvEXT"), target, pname, params);
  }

  public void glGetMultiTexLevelParameterfvEXT(int texunit, int target, int level, int pname, MemorySegment params) {
    PFNGLGETMULTITEXLEVELPARAMETERFVEXTPROC.invoke(address("glGetMultiTexLevelParameterfvEXT"), texunit, target, level, pname, params);
  }

  public void glGenSemaphoresEXT(int n, MemorySegment semaphores) {
    PFNGLGENSEMAPHORESEXTPROC.invoke(address("glGenSemaphoresEXT"), n, semaphores);
  }

  public void glCopyMultiTexSubImage3DEXT(int texunit, int target, int level, int xoffset, int yoffset, int zoffset, int x, int y, int width, int height) {
    PFNGLCOPYMULTITEXSUBIMAGE3DEXTPROC.invoke(address("glCopyMultiTexSubImage3DEXT"), texunit, target, level, xoffset, yoffset, zoffset, x, y, width, height);
  }

  public void glUniformMatrix4x2fvNV(int location, int count, byte transpose, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetFragmentShadingRatesEXT(int samples, int maxCount, MemorySegment count, MemorySegment shadingRates) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVariantsvEXT(int id, MemorySegment addr) {
    PFNGLVARIANTSVEXTPROC.invoke(address("glVariantsvEXT"), id, addr);
  }

  public void glBinormal3bEXT(byte bx, byte by, byte bz) {
    PFNGLBINORMAL3BEXTPROC.invoke(address("glBinormal3bEXT"), bx, by, bz);
  }

  public void glCompressedMultiTexImage2DEXT(int texunit, int target, int level, int internalformat, int width, int height, int border, int imageSize, MemorySegment bits) {
    PFNGLCOMPRESSEDMULTITEXIMAGE2DEXTPROC.invoke(address("glCompressedMultiTexImage2DEXT"), texunit, target, level, internalformat, width, height, border, imageSize, bits);
  }

  public void glAsyncMarkerSGIX(int marker) {
    PFNGLASYNCMARKERSGIXPROC.invoke(address("glAsyncMarkerSGIX"), marker);
  }

  public void glMultiTexSubImage3DEXT(int texunit, int target, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int format, int type, MemorySegment pixels) {
    PFNGLMULTITEXSUBIMAGE3DEXTPROC.invoke(address("glMultiTexSubImage3DEXT"), texunit, target, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels);
  }

  public int glGetFragDataIndexEXT(int program, MemorySegment name) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glReplacementCodeuivSUN(MemorySegment code) {
    PFNGLREPLACEMENTCODEUIVSUNPROC.invoke(address("glReplacementCodeuivSUN"), code);
  }

  public void glMapParameterivNV(int target, int pname, MemorySegment params) {
    PFNGLMAPPARAMETERIVNVPROC.invoke(address("glMapParameterivNV"), target, pname, params);
  }

  public void glGenVertexArrays(int n, MemorySegment arrays) {
    PFNGLGENVERTEXARRAYSPROC.invoke(address("glGenVertexArrays"), n, arrays);
  }

  public int glGetFragDataLocationEXT(int program, MemorySegment name) {
    return PFNGLGETFRAGDATALOCATIONEXTPROC.invoke(address("glGetFragDataLocationEXT"), program, name);
  }

  public void glColor4fNormal3fVertex3fvSUN(MemorySegment c, MemorySegment n, MemorySegment v) {
    PFNGLCOLOR4FNORMAL3FVERTEX3FVSUNPROC.invoke(address("glColor4fNormal3fVertex3fvSUN"), c, n, v);
  }

  public void glProgramLocalParametersI4uivNV(int target, int index, int count, MemorySegment params) {
    PFNGLPROGRAMLOCALPARAMETERSI4UIVNVPROC.invoke(address("glProgramLocalParametersI4uivNV"), target, index, count, params);
  }

  public void glEnableVertexArrayAttrib(int vaobj, int index) {
    PFNGLENABLEVERTEXARRAYATTRIBPROC.invoke(address("glEnableVertexArrayAttrib"), vaobj, index);
  }

  public void glProgramLocalParameterI4uiNV(int target, int index, int x, int y, int z, int w) {
    PFNGLPROGRAMLOCALPARAMETERI4UINVPROC.invoke(address("glProgramLocalParameterI4uiNV"), target, index, x, y, z, w);
  }

  public void glGenFramebuffers(int n, MemorySegment framebuffers) {
    PFNGLGENFRAMEBUFFERSPROC.invoke(address("glGenFramebuffers"), n, framebuffers);
  }

  public void glBindFragDataLocationIndexedEXT(int program, int colorNumber, int index, MemorySegment name) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexWeightPointerEXT(int size, int type, int stride, MemorySegment pointer) {
    PFNGLVERTEXWEIGHTPOINTEREXTPROC.invoke(address("glVertexWeightPointerEXT"), size, type, stride, pointer);
  }

  public void glTexFilterFuncSGIS(int target, int filter, int n, MemorySegment weights) {
    PFNGLTEXFILTERFUNCSGISPROC.invoke(address("glTexFilterFuncSGIS"), target, filter, n, weights);
  }

  public void glVertexAttrib1dARB(int index, double x) {
    PFNGLVERTEXATTRIB1DARBPROC.invoke(address("glVertexAttrib1dARB"), index, x);
  }

  public void glBlendColorxOES(int red, int green, int blue, int alpha) {
    PFNGLBLENDCOLORXOESPROC.invoke(address("glBlendColorxOES"), red, green, blue, alpha);
  }

  public byte glIsEnablediEXT(int target, int index) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glRenderbufferStorageMultisampleIMG(int target, int samples, int internalformat, int width, int height) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetVertexAttribIuiv(int index, int pname, MemorySegment params) {
    PFNGLGETVERTEXATTRIBIUIVPROC.invoke(address("glGetVertexAttribIuiv"), index, pname, params);
  }

  public void glColorPointervINTEL(int size, int type, MemorySegment pointer) {
    PFNGLCOLORPOINTERVINTELPROC.invoke(address("glColorPointervINTEL"), size, type, pointer);
  }

  public void glCompressedTexSubImage3DOES(int target, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int format, int imageSize, MemorySegment data) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDeleteStatesNV(int n, MemorySegment states) {
    PFNGLDELETESTATESNVPROC.invoke(address("glDeleteStatesNV"), n, states);
  }

  public void glClientWaitSemaphoreui64NVX(int fenceObjectCount, MemorySegment semaphoreArray, MemorySegment fenceValueArray) {
    PFNGLCLIENTWAITSEMAPHOREUI64NVXPROC.invoke(address("glClientWaitSemaphoreui64NVX"), fenceObjectCount, semaphoreArray, fenceValueArray);
  }

  public void glGetProgramParameterfvNV(int target, int index, int pname, MemorySegment params) {
    PFNGLGETPROGRAMPARAMETERFVNVPROC.invoke(address("glGetProgramParameterfvNV"), target, index, pname, params);
  }

  public void glSetMultisamplefvAMD(int pname, int index, MemorySegment val) {
    PFNGLSETMULTISAMPLEFVAMDPROC.invoke(address("glSetMultisamplefvAMD"), pname, index, val);
  }

  public void glActiveProgramEXT(int program) {
    PFNGLACTIVEPROGRAMEXTPROC.invoke(address("glActiveProgramEXT"), program);
  }

  public void glTranslatexOES(int x, int y, int z) {
    PFNGLTRANSLATEXOESPROC.invoke(address("glTranslatexOES"), x, y, z);
  }

  public void glVertexAttrib2fNV(int index, float x, float y) {
    PFNGLVERTEXATTRIB2FNVPROC.invoke(address("glVertexAttrib2fNV"), index, x, y);
  }

  public void glMakeTextureHandleNonResidentNV(long handle) {
    PFNGLMAKETEXTUREHANDLENONRESIDENTNVPROC.invoke(address("glMakeTextureHandleNonResidentNV"), handle);
  }

  public void glGetTextureParameterivEXT(int texture, int target, int pname, MemorySegment params) {
    PFNGLGETTEXTUREPARAMETERIVEXTPROC.invoke(address("glGetTextureParameterivEXT"), texture, target, pname, params);
  }

  public void glGetPerfMonitorGroupStringAMD(int group, int bufSize, MemorySegment length, MemorySegment groupString) {
    PFNGLGETPERFMONITORGROUPSTRINGAMDPROC.invoke(address("glGetPerfMonitorGroupStringAMD"), group, bufSize, length, groupString);
  }

  public void glVertexAttribL1ui64vNV(int index, MemorySegment v) {
    PFNGLVERTEXATTRIBL1UI64VNVPROC.invoke(address("glVertexAttribL1ui64vNV"), index, v);
  }

  public void glGetActiveUniform(int program, int index, int bufSize, MemorySegment length, MemorySegment size, MemorySegment type, MemorySegment name) {
    PFNGLGETACTIVEUNIFORMPROC.invoke(address("glGetActiveUniform"), program, index, bufSize, length, size, type, name);
  }

  public void glVertex2bOES(byte x, byte y) {
    PFNGLVERTEX2BOESPROC.invoke(address("glVertex2bOES"), x, y);
  }

  public void glBindVertexShaderEXT(int id) {
    PFNGLBINDVERTEXSHADEREXTPROC.invoke(address("glBindVertexShaderEXT"), id);
  }

  public void glUniform3i64vNV(int location, int count, MemorySegment value) {
    PFNGLUNIFORM3I64VNVPROC.invoke(address("glUniform3i64vNV"), location, count, value);
  }

  public void glVertexAttribI3iEXT(int index, int x, int y, int z) {
    PFNGLVERTEXATTRIBI3IEXTPROC.invoke(address("glVertexAttribI3iEXT"), index, x, y, z);
  }

  public void glVertexAttribI4svEXT(int index, MemorySegment v) {
    PFNGLVERTEXATTRIBI4SVEXTPROC.invoke(address("glVertexAttribI4svEXT"), index, v);
  }

  public void glOrthofOES(float l, float r, float b, float t, float n, float f) {
    PFNGLORTHOFOESPROC.invoke(address("glOrthofOES"), l, r, b, t, n, f);
  }

  public void glGetObjectPtrLabel(MemorySegment ptr, int bufSize, MemorySegment length, MemorySegment label) {
    PFNGLGETOBJECTPTRLABELPROC.invoke(address("glGetObjectPtrLabel"), ptr, bufSize, length, label);
  }

  public void glMultiDrawArraysEXT(int mode, MemorySegment first, MemorySegment count, int primcount) {
    PFNGLMULTIDRAWARRAYSEXTPROC.invoke(address("glMultiDrawArraysEXT"), mode, first, count, primcount);
  }

  public void glCombinerOutputNV(int stage, int portion, int abOutput, int cdOutput, int sumOutput, int scale, int bias, byte abDotProduct, byte cdDotProduct, byte muxSum) {
    PFNGLCOMBINEROUTPUTNVPROC.invoke(address("glCombinerOutputNV"), stage, portion, abOutput, cdOutput, sumOutput, scale, bias, abDotProduct, cdDotProduct, muxSum);
  }

  public void glTexImage3DOES(int target, int level, int internalformat, int width, int height, int depth, int border, int format, int type, MemorySegment pixels) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertex2xOES(int x) {
    PFNGLVERTEX2XOESPROC.invoke(address("glVertex2xOES"), x);
  }

  public void glBindVertexArray(int array) {
    PFNGLBINDVERTEXARRAYPROC.invoke(address("glBindVertexArray"), array);
  }

  public void glNamedFramebufferTexture1DEXT(int framebuffer, int attachment, int textarget, int texture, int level) {
    PFNGLNAMEDFRAMEBUFFERTEXTURE1DEXTPROC.invoke(address("glNamedFramebufferTexture1DEXT"), framebuffer, attachment, textarget, texture, level);
  }

  public void glGetMultiTexImageEXT(int texunit, int target, int level, int format, int type, MemorySegment pixels) {
    PFNGLGETMULTITEXIMAGEEXTPROC.invoke(address("glGetMultiTexImageEXT"), texunit, target, level, format, type, pixels);
  }

  public void glLightModelxvOES(int pname, MemorySegment param) {
    PFNGLLIGHTMODELXVOESPROC.invoke(address("glLightModelxvOES"), pname, param);
  }

  public void glVertexAttrib3fvNV(int index, MemorySegment v) {
    PFNGLVERTEXATTRIB3FVNVPROC.invoke(address("glVertexAttrib3fvNV"), index, v);
  }

  public void glDeleteRenderbuffersOES(int n, MemorySegment renderbuffers) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public int glGenFragmentShadersATI(int range) {
    return PFNGLGENFRAGMENTSHADERSATIPROC.invoke(address("glGenFragmentShadersATI"), range);
  }

  public void glHistogramEXT(int target, int width, int internalformat, byte sink) {
    PFNGLHISTOGRAMEXTPROC.invoke(address("glHistogramEXT"), target, width, internalformat, sink);
  }

  public void glTexCoordP3uiv(int type, MemorySegment coords) {
    PFNGLTEXCOORDP3UIVPROC.invoke(address("glTexCoordP3uiv"), type, coords);
  }

  public void glBindImageTexture(int unit, int texture, int level, byte layered, int layer, int access, int format) {
    PFNGLBINDIMAGETEXTUREPROC.invoke(address("glBindImageTexture"), unit, texture, level, layered, layer, access, format);
  }

  public void glGetnUniformfvKHR(int program, int location, int bufSize, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glNamedProgramLocalParameter4fEXT(int program, int target, int index, float x, float y, float z, float w) {
    PFNGLNAMEDPROGRAMLOCALPARAMETER4FEXTPROC.invoke(address("glNamedProgramLocalParameter4fEXT"), program, target, index, x, y, z, w);
  }

  public void glWaitSync(MemorySegment sync, int flags, long timeout) {
    PFNGLWAITSYNCPROC.invoke(address("glWaitSync"), sync, flags, timeout);
  }

  public void glVertexAttrib4svNV(int index, MemorySegment v) {
    PFNGLVERTEXATTRIB4SVNVPROC.invoke(address("glVertexAttrib4svNV"), index, v);
  }

  public void glGenVertexArraysAPPLE(int n, MemorySegment arrays) {
    PFNGLGENVERTEXARRAYSAPPLEPROC.invoke(address("glGenVertexArraysAPPLE"), n, arrays);
  }

  public void glListParameteriSGIX(int list, int pname, int param) {
    PFNGLLISTPARAMETERISGIXPROC.invoke(address("glListParameteriSGIX"), list, pname, param);
  }

  public void glGetIntegerui64i_vNV(int value, int index, MemorySegment result) {
    PFNGLGETINTEGERUI64I_VNVPROC.invoke(address("glGetIntegerui64i_vNV"), value, index, result);
  }

  public void glProgramUniform3ui(int program, int location, int v0, int v1, int v2) {
    PFNGLPROGRAMUNIFORM3UIPROC.invoke(address("glProgramUniform3ui"), program, location, v0, v1, v2);
  }

  public void glTextureRenderbufferEXT(int texture, int target, int renderbuffer) {
    PFNGLTEXTURERENDERBUFFEREXTPROC.invoke(address("glTextureRenderbufferEXT"), texture, target, renderbuffer);
  }

  public void glElementPointerATI(int type, MemorySegment pointer) {
    PFNGLELEMENTPOINTERATIPROC.invoke(address("glElementPointerATI"), type, pointer);
  }

  public void glSecondaryColor3hvNV(MemorySegment v) {
    PFNGLSECONDARYCOLOR3HVNVPROC.invoke(address("glSecondaryColor3hvNV"), v);
  }

  public void glColor4fNormal3fVertex3fSUN(float r, float g, float b, float a, float nx, float ny, float nz, float x, float y, float z) {
    PFNGLCOLOR4FNORMAL3FVERTEX3FSUNPROC.invoke(address("glColor4fNormal3fVertex3fSUN"), r, g, b, a, nx, ny, nz, x, y, z);
  }

  public void glVertexStream1sATI(int stream, short x) {
    PFNGLVERTEXSTREAM1SATIPROC.invoke(address("glVertexStream1sATI"), stream, x);
  }

  public byte glExtIsProgramBinaryQCOM(int program) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGenFramebuffersEXT(int n, MemorySegment framebuffers) {
    PFNGLGENFRAMEBUFFERSEXTPROC.invoke(address("glGenFramebuffersEXT"), n, framebuffers);
  }

  public void glNormal3fVertex3fSUN(float nx, float ny, float nz, float x, float y, float z) {
    PFNGLNORMAL3FVERTEX3FSUNPROC.invoke(address("glNormal3fVertex3fSUN"), nx, ny, nz, x, y, z);
  }

  public void glVertexAttrib4hvNV(int index, MemorySegment v) {
    PFNGLVERTEXATTRIB4HVNVPROC.invoke(address("glVertexAttrib4hvNV"), index, v);
  }

  public void glProgramUniformMatrix2x3fvEXT(int program, int location, int count, byte transpose, MemorySegment value) {
    PFNGLPROGRAMUNIFORMMATRIX2X3FVEXTPROC.invoke(address("glProgramUniformMatrix2x3fvEXT"), program, location, count, transpose, value);
  }

  public void glTextureAttachMemoryNV(int texture, int memory, long offset) {
    PFNGLTEXTUREATTACHMEMORYNVPROC.invoke(address("glTextureAttachMemoryNV"), texture, memory, offset);
  }

  public void glProgramUniform1i64ARB(int program, int location, long x) {
    PFNGLPROGRAMUNIFORM1I64ARBPROC.invoke(address("glProgramUniform1i64ARB"), program, location, x);
  }

  public void glDrawRangeElementsBaseVertexEXT(int mode, int start, int end, int count, int type, MemorySegment indices, int basevertex) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetObjectLabelEXT(int type, int object, int bufSize, MemorySegment length, MemorySegment label) {
    PFNGLGETOBJECTLABELEXTPROC.invoke(address("glGetObjectLabelEXT"), type, object, bufSize, length, label);
  }

  public void glTextureView(int texture, int target, int origtexture, int internalformat, int minlevel, int numlevels, int minlayer, int numlayers) {
    PFNGLTEXTUREVIEWPROC.invoke(address("glTextureView"), texture, target, origtexture, internalformat, minlevel, numlevels, minlayer, numlayers);
  }

  public void glImportMemoryFdEXT(int memory, long size, int handleType, int fd) {
    PFNGLIMPORTMEMORYFDEXTPROC.invoke(address("glImportMemoryFdEXT"), memory, size, handleType, fd);
  }

  public void glMatrixMult3x2fNV(int matrixMode, MemorySegment m) {
    PFNGLMATRIXMULT3X2FNVPROC.invoke(address("glMatrixMult3x2fNV"), matrixMode, m);
  }

  public long glGetTextureSamplerHandleIMG(int texture, int sampler) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniform4ui64vARB(int location, int count, MemorySegment value) {
    PFNGLUNIFORM4UI64VARBPROC.invoke(address("glUniform4ui64vARB"), location, count, value);
  }

  public void glVertexAttribP1ui(int index, int type, byte normalized, int value) {
    PFNGLVERTEXATTRIBP1UIPROC.invoke(address("glVertexAttribP1ui"), index, type, normalized, value);
  }

  public void glLightEnviSGIX(int pname, int param) {
    PFNGLLIGHTENVISGIXPROC.invoke(address("glLightEnviSGIX"), pname, param);
  }

  public void glBinormal3svEXT(MemorySegment v) {
    PFNGLBINORMAL3SVEXTPROC.invoke(address("glBinormal3svEXT"), v);
  }

  public void glBeginOcclusionQueryNV(int id) {
    PFNGLBEGINOCCLUSIONQUERYNVPROC.invoke(address("glBeginOcclusionQueryNV"), id);
  }

  public byte glIsVertexArrayOES(int array) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDrawArraysIndirect(int mode, MemorySegment indirect) {
    PFNGLDRAWARRAYSINDIRECTPROC.invoke(address("glDrawArraysIndirect"), mode, indirect);
  }

  public byte glIsPointInFillPathNV(int path, int mask, float x, float y) {
    return PFNGLISPOINTINFILLPATHNVPROC.invoke(address("glIsPointInFillPathNV"), path, mask, x, y);
  }

  public void glTextureStorageMem1DEXT(int texture, int levels, int internalFormat, int width, int memory, long offset) {
    PFNGLTEXTURESTORAGEMEM1DEXTPROC.invoke(address("glTextureStorageMem1DEXT"), texture, levels, internalFormat, width, memory, offset);
  }

  public void glFragmentLightModelfvSGIX(int pname, MemorySegment params) {
    PFNGLFRAGMENTLIGHTMODELFVSGIXPROC.invoke(address("glFragmentLightModelfvSGIX"), pname, params);
  }

  public void glGetNamedFramebufferParameterivEXT(int framebuffer, int pname, MemorySegment params) {
    PFNGLGETNAMEDFRAMEBUFFERPARAMETERIVEXTPROC.invoke(address("glGetNamedFramebufferParameterivEXT"), framebuffer, pname, params);
  }

  public void glActiveShaderProgram(int pipeline, int program) {
    PFNGLACTIVESHADERPROGRAMPROC.invoke(address("glActiveShaderProgram"), pipeline, program);
  }

  public void glTexEstimateMotionQCOM(int ref, int target, int output) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDrawTexiOES(int x, int y, int z, int width, int height) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glNamedBufferStorageMemEXT(int buffer, long size, int memory, long offset) {
    PFNGLNAMEDBUFFERSTORAGEMEMEXTPROC.invoke(address("glNamedBufferStorageMemEXT"), buffer, size, memory, offset);
  }

  public void glGetSamplerParameterIivEXT(int sampler, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexGenxvOES(int coord, int pname, MemorySegment params) {
    PFNGLTEXGENXVOESPROC.invoke(address("glTexGenxvOES"), coord, pname, params);
  }

  public void glTextureParameteriv(int texture, int pname, MemorySegment param) {
    PFNGLTEXTUREPARAMETERIVPROC.invoke(address("glTextureParameteriv"), texture, pname, param);
  }

  public byte glIsTransformFeedback(int id) {
    return PFNGLISTRANSFORMFEEDBACKPROC.invoke(address("glIsTransformFeedback"), id);
  }

  public void glWaitVkSemaphoreNV(long vkSemaphore) {
    PFNGLWAITVKSEMAPHORENVPROC.invoke(address("glWaitVkSemaphoreNV"), vkSemaphore);
  }

  public void glMapBufferRangeEXT(int target, long offset, long length, int access) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glWeightubvARB(int size, MemorySegment weights) {
    PFNGLWEIGHTUBVARBPROC.invoke(address("glWeightubvARB"), size, weights);
  }

  public void glBlendFuncSeparateiOES(int buf, int srcRGB, int dstRGB, int srcAlpha, int dstAlpha) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDrawTransformFeedbackStreamInstanced(int mode, int id, int stream, int instancecount) {
    PFNGLDRAWTRANSFORMFEEDBACKSTREAMINSTANCEDPROC.invoke(address("glDrawTransformFeedbackStreamInstanced"), mode, id, stream, instancecount);
  }

  public void glVDPAUFiniNV() {
    PFNGLVDPAUFININVPROC.invoke(address("glVDPAUFiniNV"));
  }

  public void glGetProgramEnvParameterIuivNV(int target, int index, MemorySegment params) {
    PFNGLGETPROGRAMENVPARAMETERIUIVNVPROC.invoke(address("glGetProgramEnvParameterIuivNV"), target, index, params);
  }

  public void glProgramUniformMatrix3x2dvEXT(int program, int location, int count, byte transpose, MemorySegment value) {
    PFNGLPROGRAMUNIFORMMATRIX3X2DVEXTPROC.invoke(address("glProgramUniformMatrix3x2dvEXT"), program, location, count, transpose, value);
  }

  public void glGetSamplerParameterIuivOES(int sampler, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribDivisorNV(int index, int divisor) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glWindowPos3sv(MemorySegment v) {
    PFNGLWINDOWPOS3SVPROC.invoke(address("glWindowPos3sv"), v);
  }

  public void glVertexP2uiv(int type, MemorySegment value) {
    PFNGLVERTEXP2UIVPROC.invoke(address("glVertexP2uiv"), type, value);
  }

  public void glUniformMatrix2x4fv(int location, int count, byte transpose, MemorySegment value) {
    PFNGLUNIFORMMATRIX2X4FVPROC.invoke(address("glUniformMatrix2x4fv"), location, count, transpose, value);
  }

  public void glTexCoord2fColor3fVertex3fSUN(float s, float t, float r, float g, float b, float x, float y, float z) {
    PFNGLTEXCOORD2FCOLOR3FVERTEX3FSUNPROC.invoke(address("glTexCoord2fColor3fVertex3fSUN"), s, t, r, g, b, x, y, z);
  }

  public void glProgramUniform3ui64vNV(int program, int location, int count, MemorySegment value) {
    PFNGLPROGRAMUNIFORM3UI64VNVPROC.invoke(address("glProgramUniform3ui64vNV"), program, location, count, value);
  }

  public void glProgramUniformHandleui64NV(int program, int location, long value) {
    PFNGLPROGRAMUNIFORMHANDLEUI64NVPROC.invoke(address("glProgramUniformHandleui64NV"), program, location, value);
  }

  public void glWindowPos3ivMESA(MemorySegment v) {
    PFNGLWINDOWPOS3IVMESAPROC.invoke(address("glWindowPos3ivMESA"), v);
  }

  public void glNamedFramebufferSamplePositionsfvAMD(int framebuffer, int numsamples, int pixelindex, MemorySegment values) {
    PFNGLNAMEDFRAMEBUFFERSAMPLEPOSITIONSFVAMDPROC.invoke(address("glNamedFramebufferSamplePositionsfvAMD"), framebuffer, numsamples, pixelindex, values);
  }

  public void glGetSamplerParameterIivOES(int sampler, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiDrawElementsIndirectAMD(int mode, int type, MemorySegment indirect, int primcount, int stride) {
    PFNGLMULTIDRAWELEMENTSINDIRECTAMDPROC.invoke(address("glMultiDrawElementsIndirectAMD"), mode, type, indirect, primcount, stride);
  }

  public void glClipPlanefOES(int plane, MemorySegment equation) {
    PFNGLCLIPPLANEFOESPROC.invoke(address("glClipPlanefOES"), plane, equation);
  }

  public void glInvalidateFramebuffer(int target, int numAttachments, MemorySegment attachments) {
    PFNGLINVALIDATEFRAMEBUFFERPROC.invoke(address("glInvalidateFramebuffer"), target, numAttachments, attachments);
  }

  public void glLGPUCopyImageSubDataNVX(int sourceGpu, int destinationGpuMask, int srcName, int srcTarget, int srcLevel, int srcX, int srxY, int srcZ, int dstName, int dstTarget, int dstLevel, int dstX, int dstY, int dstZ, int width, int height, int depth) {
    PFNGLLGPUCOPYIMAGESUBDATANVXPROC.invoke(address("glLGPUCopyImageSubDataNVX"), sourceGpu, destinationGpuMask, srcName, srcTarget, srcLevel, srcX, srxY, srcZ, dstName, dstTarget, dstLevel, dstX, dstY, dstZ, width, height, depth);
  }

  public void glVertexStream3dvATI(int stream, MemorySegment coords) {
    PFNGLVERTEXSTREAM3DVATIPROC.invoke(address("glVertexStream3dvATI"), stream, coords);
  }

  public void glMultiTexGenfvEXT(int texunit, int coord, int pname, MemorySegment params) {
    PFNGLMULTITEXGENFVEXTPROC.invoke(address("glMultiTexGenfvEXT"), texunit, coord, pname, params);
  }

  public void glWaitSemaphoreEXT(int semaphore, int numBufferBarriers, MemorySegment buffers, int numTextureBarriers, MemorySegment textures, MemorySegment srcLayouts) {
    PFNGLWAITSEMAPHOREEXTPROC.invoke(address("glWaitSemaphoreEXT"), semaphore, numBufferBarriers, buffers, numTextureBarriers, textures, srcLayouts);
  }

  public void glRenderGpuMaskNV(int mask) {
    PFNGLRENDERGPUMASKNVPROC.invoke(address("glRenderGpuMaskNV"), mask);
  }

  public void glColorTableParameterivSGI(int target, int pname, MemorySegment params) {
    PFNGLCOLORTABLEPARAMETERIVSGIPROC.invoke(address("glColorTableParameterivSGI"), target, pname, params);
  }

  public void glGetMultiTexEnvivEXT(int texunit, int target, int pname, MemorySegment params) {
    PFNGLGETMULTITEXENVIVEXTPROC.invoke(address("glGetMultiTexEnvivEXT"), texunit, target, pname, params);
  }

  public void glMakeNamedBufferNonResidentNV(int buffer) {
    PFNGLMAKENAMEDBUFFERNONRESIDENTNVPROC.invoke(address("glMakeNamedBufferNonResidentNV"), buffer);
  }

  public void glProgramLocalParametersI4ivNV(int target, int index, int count, MemorySegment params) {
    PFNGLPROGRAMLOCALPARAMETERSI4IVNVPROC.invoke(address("glProgramLocalParametersI4ivNV"), target, index, count, params);
  }

  public void glGetMultiTexGendvEXT(int texunit, int coord, int pname, MemorySegment params) {
    PFNGLGETMULTITEXGENDVEXTPROC.invoke(address("glGetMultiTexGendvEXT"), texunit, coord, pname, params);
  }

  public void glGlobalAlphaFactorusSUN(short factor) {
    PFNGLGLOBALALPHAFACTORUSSUNPROC.invoke(address("glGlobalAlphaFactorusSUN"), factor);
  }

  public void glClearDepthxOES(int depth) {
    PFNGLCLEARDEPTHXOESPROC.invoke(address("glClearDepthxOES"), depth);
  }

  public void glTextureParameterIuiv(int texture, int pname, MemorySegment params) {
    PFNGLTEXTUREPARAMETERIUIVPROC.invoke(address("glTextureParameterIuiv"), texture, pname, params);
  }

  public void glGetnColorTable(int target, int format, int type, int bufSize, MemorySegment table) {
    PFNGLGETNCOLORTABLEPROC.invoke(address("glGetnColorTable"), target, format, type, bufSize, table);
  }

  public void glVertexAttrib4dNV(int index, double x, double y, double z, double w) {
    PFNGLVERTEXATTRIB4DNVPROC.invoke(address("glVertexAttrib4dNV"), index, x, y, z, w);
  }

  public byte glIsBuffer(int buffer) {
    return PFNGLISBUFFERPROC.invoke(address("glIsBuffer"), buffer);
  }

  public void glTexCoord3hNV(short s, short t, short r) {
    PFNGLTEXCOORD3HNVPROC.invoke(address("glTexCoord3hNV"), s, t, r);
  }

  public void glTexSubImage2DEXT(int target, int level, int xoffset, int yoffset, int width, int height, int format, int type, MemorySegment pixels) {
    PFNGLTEXSUBIMAGE2DEXTPROC.invoke(address("glTexSubImage2DEXT"), target, level, xoffset, yoffset, width, height, format, type, pixels);
  }

  public void glTextureNormalEXT(int mode) {
    PFNGLTEXTURENORMALEXTPROC.invoke(address("glTextureNormalEXT"), mode);
  }

  public void glExtTexObjectStateOverrideiQCOM(int target, int pname, int param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMinSampleShadingARB(float value) {
    PFNGLMINSAMPLESHADINGARBPROC.invoke(address("glMinSampleShadingARB"), value);
  }

  public void glBufferStorage(int target, long size, MemorySegment data, int flags) {
    PFNGLBUFFERSTORAGEPROC.invoke(address("glBufferStorage"), target, size, data, flags);
  }

  public void glPointParameterfSGIS(int pname, float param) {
    PFNGLPOINTPARAMETERFSGISPROC.invoke(address("glPointParameterfSGIS"), pname, param);
  }

  public void glShaderOp1EXT(int op, int res, int arg1) {
    PFNGLSHADEROP1EXTPROC.invoke(address("glShaderOp1EXT"), op, res, arg1);
  }

  public void glViewportPositionWScaleNV(int index, float xcoeff, float ycoeff) {
    PFNGLVIEWPORTPOSITIONWSCALENVPROC.invoke(address("glViewportPositionWScaleNV"), index, xcoeff, ycoeff);
  }

  public void glTexCoord4bvOES(MemorySegment coords) {
    PFNGLTEXCOORD4BVOESPROC.invoke(address("glTexCoord4bvOES"), coords);
  }

  public void glTexImage3DEXT(int target, int level, int internalformat, int width, int height, int depth, int border, int format, int type, MemorySegment pixels) {
    PFNGLTEXIMAGE3DEXTPROC.invoke(address("glTexImage3DEXT"), target, level, internalformat, width, height, depth, border, format, type, pixels);
  }

  public void glUniform2uiEXT(int location, int v0, int v1) {
    PFNGLUNIFORM2UIEXTPROC.invoke(address("glUniform2uiEXT"), location, v0, v1);
  }

  public void glProgramUniform1uiEXT(int program, int location, int v0) {
    PFNGLPROGRAMUNIFORM1UIEXTPROC.invoke(address("glProgramUniform1uiEXT"), program, location, v0);
  }

  public void glVertexAttrib4NsvARB(int index, MemorySegment v) {
    PFNGLVERTEXATTRIB4NSVARBPROC.invoke(address("glVertexAttrib4NsvARB"), index, v);
  }

  public void glDrawTransformFeedbackEXT(int mode, int id) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexStorage3DMultisampleOES(int target, int samples, int internalformat, int width, int height, int depth, byte fixedsamplelocations) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetVariantPointervEXT(int id, int value, MemorySegment data) {
    PFNGLGETVARIANTPOINTERVEXTPROC.invoke(address("glGetVariantPointervEXT"), id, value, data);
  }

  public void glVertexAttribI3ivEXT(int index, MemorySegment v) {
    PFNGLVERTEXATTRIBI3IVEXTPROC.invoke(address("glVertexAttribI3ivEXT"), index, v);
  }

  public void glBlendEquationSeparateEXT(int modeRGB, int modeAlpha) {
    PFNGLBLENDEQUATIONSEPARATEEXTPROC.invoke(address("glBlendEquationSeparateEXT"), modeRGB, modeAlpha);
  }

  public void glMapVertexAttrib1dAPPLE(int index, int size, double u1, double u2, int stride, int order, MemorySegment points) {
    PFNGLMAPVERTEXATTRIB1DAPPLEPROC.invoke(address("glMapVertexAttrib1dAPPLE"), index, size, u1, u2, stride, order, points);
  }

  public void glSelectPerfMonitorCountersAMD(int monitor, byte enable, int group, int numCounters, MemorySegment counterList) {
    PFNGLSELECTPERFMONITORCOUNTERSAMDPROC.invoke(address("glSelectPerfMonitorCountersAMD"), monitor, enable, group, numCounters, counterList);
  }

  public void glProgramUniform4uivEXT(int program, int location, int count, MemorySegment value) {
    PFNGLPROGRAMUNIFORM4UIVEXTPROC.invoke(address("glProgramUniform4uivEXT"), program, location, count, value);
  }

  public void glColorP3ui(int type, int color) {
    PFNGLCOLORP3UIPROC.invoke(address("glColorP3ui"), type, color);
  }

  public void glCreateCommandListsNV(int n, MemorySegment lists) {
    PFNGLCREATECOMMANDLISTSNVPROC.invoke(address("glCreateCommandListsNV"), n, lists);
  }

  public MemorySegment glMapBuffer(int target, int access) {
    return PFNGLMAPBUFFERPROC.invoke(address("glMapBuffer"), target, access);
  }

  public void glPathCommandsNV(int path, int numCommands, MemorySegment commands, int numCoords, int coordType, MemorySegment coords) {
    PFNGLPATHCOMMANDSNVPROC.invoke(address("glPathCommandsNV"), path, numCommands, commands, numCoords, coordType, coords);
  }

  public void glViewportArrayvNV(int first, int count, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGenerateTextureMipmap(int texture) {
    PFNGLGENERATETEXTUREMIPMAPPROC.invoke(address("glGenerateTextureMipmap"), texture);
  }

  public void glVertexAttrib2dvNV(int index, MemorySegment v) {
    PFNGLVERTEXATTRIB2DVNVPROC.invoke(address("glVertexAttrib2dvNV"), index, v);
  }

  public void glEnableVertexAttribArrayARB(int index) {
    PFNGLENABLEVERTEXATTRIBARRAYARBPROC.invoke(address("glEnableVertexAttribArrayARB"), index);
  }

  public MemorySegment glMapNamedBufferEXT(int buffer, int access) {
    return PFNGLMAPNAMEDBUFFEREXTPROC.invoke(address("glMapNamedBufferEXT"), buffer, access);
  }

  public void glClipControl(int origin, int depth) {
    PFNGLCLIPCONTROLPROC.invoke(address("glClipControl"), origin, depth);
  }

  public int glBindLightParameterEXT(int light, int value) {
    return PFNGLBINDLIGHTPARAMETEREXTPROC.invoke(address("glBindLightParameterEXT"), light, value);
  }

  public void glWindowPos4fvMESA(MemorySegment v) {
    PFNGLWINDOWPOS4FVMESAPROC.invoke(address("glWindowPos4fvMESA"), v);
  }

  public void glBindBufferBase(int target, int index, int buffer) {
    PFNGLBINDBUFFERBASEPROC.invoke(address("glBindBufferBase"), target, index, buffer);
  }

  public void glDrawTexfOES(float x, float y, float z, float width, float height) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttrib3dvARB(int index, MemorySegment v) {
    PFNGLVERTEXATTRIB3DVARBPROC.invoke(address("glVertexAttrib3dvARB"), index, v);
  }

  public void glVertexAttribArrayObjectATI(int index, int size, int type, byte normalized, int stride, int buffer, int offset) {
    PFNGLVERTEXATTRIBARRAYOBJECTATIPROC.invoke(address("glVertexAttribArrayObjectATI"), index, size, type, normalized, stride, buffer, offset);
  }

  public void glGetCompressedTextureImageEXT(int texture, int target, int lod, MemorySegment img) {
    PFNGLGETCOMPRESSEDTEXTUREIMAGEEXTPROC.invoke(address("glGetCompressedTextureImageEXT"), texture, target, lod, img);
  }

  public byte glIsOcclusionQueryNV(int id) {
    return PFNGLISOCCLUSIONQUERYNVPROC.invoke(address("glIsOcclusionQueryNV"), id);
  }

  public void glGetInteger64vEXT(int pname, MemorySegment data) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glCopyTexSubImage3DOES(int target, int level, int xoffset, int yoffset, int zoffset, int x, int y, int width, int height) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFogCoordhNV(short fog) {
    PFNGLFOGCOORDHNVPROC.invoke(address("glFogCoordhNV"), fog);
  }

  public void glRenderbufferStorageEXT(int target, int internalformat, int width, int height) {
    PFNGLRENDERBUFFERSTORAGEEXTPROC.invoke(address("glRenderbufferStorageEXT"), target, internalformat, width, height);
  }

  public void glVertex4hvNV(MemorySegment v) {
    PFNGLVERTEX4HVNVPROC.invoke(address("glVertex4hvNV"), v);
  }

  public void glVertexArrayVertexBuffer(int vaobj, int bindingindex, int buffer, long offset, int stride) {
    PFNGLVERTEXARRAYVERTEXBUFFERPROC.invoke(address("glVertexArrayVertexBuffer"), vaobj, bindingindex, buffer, offset, stride);
  }

  public void glWeightPointerOES(int size, int type, int stride, MemorySegment pointer) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBlendEquationiARB(int buf, int mode) {
    PFNGLBLENDEQUATIONIARBPROC.invoke(address("glBlendEquationiARB"), buf, mode);
  }

  public int glCreateProgram() {
    return PFNGLCREATEPROGRAMPROC.invoke(address("glCreateProgram"));
  }

  public void glMultiTexImage1DEXT(int texunit, int target, int level, int internalformat, int width, int border, int format, int type, MemorySegment pixels) {
    PFNGLMULTITEXIMAGE1DEXTPROC.invoke(address("glMultiTexImage1DEXT"), texunit, target, level, internalformat, width, border, format, type, pixels);
  }

  public void glTexCoordFormatNV(int size, int type, int stride) {
    PFNGLTEXCOORDFORMATNVPROC.invoke(address("glTexCoordFormatNV"), size, type, stride);
  }

  public void glTextureBarrierNV() {
    PFNGLTEXTUREBARRIERNVPROC.invoke(address("glTextureBarrierNV"));
  }

  public void glTexStorageMem3DEXT(int target, int levels, int internalFormat, int width, int height, int depth, int memory, long offset) {
    PFNGLTEXSTORAGEMEM3DEXTPROC.invoke(address("glTexStorageMem3DEXT"), target, levels, internalFormat, width, height, depth, memory, offset);
  }

  public void glGetCompressedTextureImage(int texture, int level, int bufSize, MemorySegment pixels) {
    PFNGLGETCOMPRESSEDTEXTUREIMAGEPROC.invoke(address("glGetCompressedTextureImage"), texture, level, bufSize, pixels);
  }

  public void glProgramUniform3fv(int program, int location, int count, MemorySegment value) {
    PFNGLPROGRAMUNIFORM3FVPROC.invoke(address("glProgramUniform3fv"), program, location, count, value);
  }

  public void glProgramUniform3i64NV(int program, int location, long x, long y, long z) {
    PFNGLPROGRAMUNIFORM3I64NVPROC.invoke(address("glProgramUniform3i64NV"), program, location, x, y, z);
  }

  public void glDepthRangex(int n, int f) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexArrayVertexAttribOffsetEXT(int vaobj, int buffer, int index, int size, int type, byte normalized, int stride, long offset) {
    PFNGLVERTEXARRAYVERTEXATTRIBOFFSETEXTPROC.invoke(address("glVertexArrayVertexAttribOffsetEXT"), vaobj, buffer, index, size, type, normalized, stride, offset);
  }

  public void glProgramNamedParameter4fvNV(int id, int len, MemorySegment name, MemorySegment v) {
    PFNGLPROGRAMNAMEDPARAMETER4FVNVPROC.invoke(address("glProgramNamedParameter4fvNV"), id, len, name, v);
  }

  public void glSecondaryColor3iEXT(int red, int green, int blue) {
    PFNGLSECONDARYCOLOR3IEXTPROC.invoke(address("glSecondaryColor3iEXT"), red, green, blue);
  }

  public void glDetailTexFuncSGIS(int target, int n, MemorySegment points) {
    PFNGLDETAILTEXFUNCSGISPROC.invoke(address("glDetailTexFuncSGIS"), target, n, points);
  }

  public void glTexGenfOES(int coord, int pname, float param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glNamedBufferPageCommitmentEXT(int buffer, long offset, long size, byte commit) {
    PFNGLNAMEDBUFFERPAGECOMMITMENTEXTPROC.invoke(address("glNamedBufferPageCommitmentEXT"), buffer, offset, size, commit);
  }

  public void glGetFramebufferAttachmentParameterivOES(int target, int attachment, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDepthRangef(float n, float f) {
    PFNGLDEPTHRANGEFPROC.invoke(address("glDepthRangef"), n, f);
  }

  public void glProgramUniformHandleui64vNV(int program, int location, int count, MemorySegment values) {
    PFNGLPROGRAMUNIFORMHANDLEUI64VNVPROC.invoke(address("glProgramUniformHandleui64vNV"), program, location, count, values);
  }

  public void glVertexAttrib4ubNV(int index, byte x, byte y, byte z, byte w) {
    PFNGLVERTEXATTRIB4UBNVPROC.invoke(address("glVertexAttrib4ubNV"), index, x, y, z, w);
  }

  public void glBinormal3dvEXT(MemorySegment v) {
    PFNGLBINORMAL3DVEXTPROC.invoke(address("glBinormal3dvEXT"), v);
  }

  public long glGetTextureSamplerHandleARB(int texture, int sampler) {
    return PFNGLGETTEXTURESAMPLERHANDLEARBPROC.invoke(address("glGetTextureSamplerHandleARB"), texture, sampler);
  }

  public void glGetFenceivNV(int fence, int pname, MemorySegment params) {
    PFNGLGETFENCEIVNVPROC.invoke(address("glGetFenceivNV"), fence, pname, params);
  }

  public void glUniform4f(int location, float v0, float v1, float v2, float v3) {
    PFNGLUNIFORM4FPROC.invoke(address("glUniform4f"), location, v0, v1, v2, v3);
  }

  public void glUniform4i(int location, int v0, int v1, int v2, int v3) {
    PFNGLUNIFORM4IPROC.invoke(address("glUniform4i"), location, v0, v1, v2, v3);
  }

  public void glPauseTransformFeedbackNV() {
    PFNGLPAUSETRANSFORMFEEDBACKNVPROC.invoke(address("glPauseTransformFeedbackNV"));
  }

  public void glUniform4i64ARB(int location, long x, long y, long z, long w) {
    PFNGLUNIFORM4I64ARBPROC.invoke(address("glUniform4i64ARB"), location, x, y, z, w);
  }

  public void glVDPAUMapSurfacesNV(int numSurfaces, MemorySegment surfaces) {
    PFNGLVDPAUMAPSURFACESNVPROC.invoke(address("glVDPAUMapSurfacesNV"), numSurfaces, surfaces);
  }

  public int glGetFragDataIndex(int program, MemorySegment name) {
    return PFNGLGETFRAGDATAINDEXPROC.invoke(address("glGetFragDataIndex"), program, name);
  }

  public void glGetnUniformivARB(int program, int location, int bufSize, MemorySegment params) {
    PFNGLGETNUNIFORMIVARBPROC.invoke(address("glGetnUniformivARB"), program, location, bufSize, params);
  }

  public void glDebugMessageInsert(int source, int type, int id, int severity, int length, MemorySegment buf) {
    PFNGLDEBUGMESSAGEINSERTPROC.invoke(address("glDebugMessageInsert"), source, type, id, severity, length, buf);
  }

  public void glPixelTexGenSGIX(int mode) {
    PFNGLPIXELTEXGENSGIXPROC.invoke(address("glPixelTexGenSGIX"), mode);
  }

  public void glSecondaryColor3bvEXT(MemorySegment v) {
    PFNGLSECONDARYCOLOR3BVEXTPROC.invoke(address("glSecondaryColor3bvEXT"), v);
  }

  public void glAlphaFragmentOp1ATI(int op, int dst, int dstMod, int arg1, int arg1Rep, int arg1Mod) {
    PFNGLALPHAFRAGMENTOP1ATIPROC.invoke(address("glAlphaFragmentOp1ATI"), op, dst, dstMod, arg1, arg1Rep, arg1Mod);
  }

  public void glProgramUniform3dv(int program, int location, int count, MemorySegment value) {
    PFNGLPROGRAMUNIFORM3DVPROC.invoke(address("glProgramUniform3dv"), program, location, count, value);
  }

  public int glBindTexGenParameterEXT(int unit, int coord, int value) {
    return PFNGLBINDTEXGENPARAMETEREXTPROC.invoke(address("glBindTexGenParameterEXT"), unit, coord, value);
  }

  public void glColorTableEXT(int target, int internalFormat, int width, int format, int type, MemorySegment table) {
    PFNGLCOLORTABLEEXTPROC.invoke(address("glColorTableEXT"), target, internalFormat, width, format, type, table);
  }

  public void glUniform3iARB(int location, int v0, int v1, int v2) {
    PFNGLUNIFORM3IARBPROC.invoke(address("glUniform3iARB"), location, v0, v1, v2);
  }

  public void glEnableiEXT(int target, int index) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexGenivOES(int coord, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetProgramiv(int program, int pname, MemorySegment params) {
    PFNGLGETPROGRAMIVPROC.invoke(address("glGetProgramiv"), program, pname, params);
  }

  public void glLabelObjectEXT(int type, int object, int length, MemorySegment label) {
    PFNGLLABELOBJECTEXTPROC.invoke(address("glLabelObjectEXT"), type, object, length, label);
  }

  public void glGetShaderPrecisionFormat(int shadertype, int precisiontype, MemorySegment range, MemorySegment precision) {
    PFNGLGETSHADERPRECISIONFORMATPROC.invoke(address("glGetShaderPrecisionFormat"), shadertype, precisiontype, range, precision);
  }

  public void glPopDebugGroup() {
    PFNGLPOPDEBUGGROUPPROC.invoke(address("glPopDebugGroup"));
  }

  public void glSecondaryColor3ubEXT(byte red, byte green, byte blue) {
    PFNGLSECONDARYCOLOR3UBEXTPROC.invoke(address("glSecondaryColor3ubEXT"), red, green, blue);
  }

  public void glVertexAttrib3svARB(int index, MemorySegment v) {
    PFNGLVERTEXATTRIB3SVARBPROC.invoke(address("glVertexAttrib3svARB"), index, v);
  }

  public void glProgramUniform3ui64NV(int program, int location, long x, long y, long z) {
    PFNGLPROGRAMUNIFORM3UI64NVPROC.invoke(address("glProgramUniform3ui64NV"), program, location, x, y, z);
  }

  public byte glIsNamedBufferResidentNV(int buffer) {
    return PFNGLISNAMEDBUFFERRESIDENTNVPROC.invoke(address("glIsNamedBufferResidentNV"), buffer);
  }

  public void glShadingRateCombinerOpsEXT(int combinerOp0, int combinerOp1) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetnUniformiv(int program, int location, int bufSize, MemorySegment params) {
    PFNGLGETNUNIFORMIVPROC.invoke(address("glGetnUniformiv"), program, location, bufSize, params);
  }

  public void glProgramLocalParameter4dvARB(int target, int index, MemorySegment params) {
    PFNGLPROGRAMLOCALPARAMETER4DVARBPROC.invoke(address("glProgramLocalParameter4dvARB"), target, index, params);
  }

  public void glProgramUniform2fvEXT(int program, int location, int count, MemorySegment value) {
    PFNGLPROGRAMUNIFORM2FVEXTPROC.invoke(address("glProgramUniform2fvEXT"), program, location, count, value);
  }

  public void glVertexStream4fATI(int stream, float x, float y, float z, float w) {
    PFNGLVERTEXSTREAM4FATIPROC.invoke(address("glVertexStream4fATI"), stream, x, y, z, w);
  }

  public void glColorMaskiEXT(int index, byte r, byte g, byte b, byte a) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexCoord4xvOES(MemorySegment coords) {
    PFNGLTEXCOORD4XVOESPROC.invoke(address("glTexCoord4xvOES"), coords);
  }

  public void glGetQueryObjectui64v(int id, int pname, MemorySegment params) {
    PFNGLGETQUERYOBJECTUI64VPROC.invoke(address("glGetQueryObjectui64v"), id, pname, params);
  }

  public void glNamedRenderbufferStorage(int renderbuffer, int internalformat, int width, int height) {
    PFNGLNAMEDRENDERBUFFERSTORAGEPROC.invoke(address("glNamedRenderbufferStorage"), renderbuffer, internalformat, width, height);
  }

  public void glUnmapObjectBufferATI(int buffer) {
    PFNGLUNMAPOBJECTBUFFERATIPROC.invoke(address("glUnmapObjectBufferATI"), buffer);
  }

  public void glVertexStream3dATI(int stream, double x, double y, double z) {
    PFNGLVERTEXSTREAM3DATIPROC.invoke(address("glVertexStream3dATI"), stream, x, y, z);
  }

  public void glMaterialx(int face, int pname, int param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniform2ivARB(int location, int count, MemorySegment value) {
    PFNGLUNIFORM2IVARBPROC.invoke(address("glUniform2ivARB"), location, count, value);
  }

  public void glListParameterfvSGIX(int list, int pname, MemorySegment params) {
    PFNGLLISTPARAMETERFVSGIXPROC.invoke(address("glListParameterfvSGIX"), list, pname, params);
  }

  public void glDeleteProgramPipelines(int n, MemorySegment pipelines) {
    PFNGLDELETEPROGRAMPIPELINESPROC.invoke(address("glDeleteProgramPipelines"), n, pipelines);
  }

  public void glTexEstimateMotionRegionsQCOM(int ref, int target, int output, int mask) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glSampleMapATI(int dst, int interp, int swizzle) {
    PFNGLSAMPLEMAPATIPROC.invoke(address("glSampleMapATI"), dst, interp, swizzle);
  }

  public void glFramebufferParameteriMESA(int target, int pname, int param) {
    PFNGLFRAMEBUFFERPARAMETERIMESAPROC.invoke(address("glFramebufferParameteriMESA"), target, pname, param);
  }

  public void glViewportIndexedfOES(int index, float x, float y, float w, float h) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramNamedParameter4fNV(int id, int len, MemorySegment name, float x, float y, float z, float w) {
    PFNGLPROGRAMNAMEDPARAMETER4FNVPROC.invoke(address("glProgramNamedParameter4fNV"), id, len, name, x, y, z, w);
  }

  public void glConvolutionParameteriEXT(int target, int pname, int params) {
    PFNGLCONVOLUTIONPARAMETERIEXTPROC.invoke(address("glConvolutionParameteriEXT"), target, pname, params);
  }

  public void glAccumxOES(int op, int value) {
    PFNGLACCUMXOESPROC.invoke(address("glAccumxOES"), op, value);
  }

  public void glProgramUniform3iv(int program, int location, int count, MemorySegment value) {
    PFNGLPROGRAMUNIFORM3IVPROC.invoke(address("glProgramUniform3iv"), program, location, count, value);
  }

  public void glGetUniformivARB(int programObj, int location, MemorySegment params) {
    PFNGLGETUNIFORMIVARBPROC.invoke(address("glGetUniformivARB"), programObj, location, params);
  }

  public byte glIsProgram(int program) {
    return PFNGLISPROGRAMPROC.invoke(address("glIsProgram"), program);
  }

  public void glGetDoublei_vEXT(int pname, int index, MemorySegment params) {
    PFNGLGETDOUBLEI_VEXTPROC.invoke(address("glGetDoublei_vEXT"), pname, index, params);
  }

  public void glUniformui64vNV(int location, int count, MemorySegment value) {
    PFNGLUNIFORMUI64VNVPROC.invoke(address("glUniformui64vNV"), location, count, value);
  }

  public byte glIsVertexArrayAPPLE(int array) {
    return PFNGLISVERTEXARRAYAPPLEPROC.invoke(address("glIsVertexArrayAPPLE"), array);
  }

  public void glGetProgramPipelineInfoLog(int pipeline, int bufSize, MemorySegment length, MemorySegment infoLog) {
    PFNGLGETPROGRAMPIPELINEINFOLOGPROC.invoke(address("glGetProgramPipelineInfoLog"), pipeline, bufSize, length, infoLog);
  }

  public void glLoadMatrixxOES(MemorySegment m) {
    PFNGLLOADMATRIXXOESPROC.invoke(address("glLoadMatrixxOES"), m);
  }

  public void glGetPathTexGenfvNV(int texCoordSet, int pname, MemorySegment value) {
    PFNGLGETPATHTEXGENFVNVPROC.invoke(address("glGetPathTexGenfvNV"), texCoordSet, pname, value);
  }

  public void glGetPathCoordsNV(int path, MemorySegment coords) {
    PFNGLGETPATHCOORDSNVPROC.invoke(address("glGetPathCoordsNV"), path, coords);
  }

  public void glVertexAttribI4uivEXT(int index, MemorySegment v) {
    PFNGLVERTEXATTRIBI4UIVEXTPROC.invoke(address("glVertexAttribI4uivEXT"), index, v);
  }

  public void glCopyPathNV(int resultPath, int srcPath) {
    PFNGLCOPYPATHNVPROC.invoke(address("glCopyPathNV"), resultPath, srcPath);
  }

  public void glSamplePatternEXT(int pattern) {
    PFNGLSAMPLEPATTERNEXTPROC.invoke(address("glSamplePatternEXT"), pattern);
  }

  public void glVertexAttribL2ui64vNV(int index, MemorySegment v) {
    PFNGLVERTEXATTRIBL2UI64VNVPROC.invoke(address("glVertexAttribL2ui64vNV"), index, v);
  }

  public void glGetMapxvOES(int target, int query, MemorySegment v) {
    PFNGLGETMAPXVOESPROC.invoke(address("glGetMapxvOES"), target, query, v);
  }

  public void glShadingRateImageBarrierNV(byte synchronize) {
    PFNGLSHADINGRATEIMAGEBARRIERNVPROC.invoke(address("glShadingRateImageBarrierNV"), synchronize);
  }

  public void glApplyFramebufferAttachmentCMAAINTEL() {
    PFNGLAPPLYFRAMEBUFFERATTACHMENTCMAAINTELPROC.invoke(address("glApplyFramebufferAttachmentCMAAINTEL"));
  }

  public void glProgramUniform2ui64NV(int program, int location, long x, long y) {
    PFNGLPROGRAMUNIFORM2UI64NVPROC.invoke(address("glProgramUniform2ui64NV"), program, location, x, y);
  }

  public void glBindProgramARB(int target, int program) {
    PFNGLBINDPROGRAMARBPROC.invoke(address("glBindProgramARB"), target, program);
  }

  public void glReplacementCodeuiNormal3fVertex3fSUN(int rc, float nx, float ny, float nz, float x, float y, float z) {
    PFNGLREPLACEMENTCODEUINORMAL3FVERTEX3FSUNPROC.invoke(address("glReplacementCodeuiNormal3fVertex3fSUN"), rc, nx, ny, nz, x, y, z);
  }

  public void glNamedBufferSubDataEXT(int buffer, long offset, long size, MemorySegment data) {
    PFNGLNAMEDBUFFERSUBDATAEXTPROC.invoke(address("glNamedBufferSubDataEXT"), buffer, offset, size, data);
  }

  public void glClearBufferfv(int buffer, int drawbuffer, MemorySegment value) {
    PFNGLCLEARBUFFERFVPROC.invoke(address("glClearBufferfv"), buffer, drawbuffer, value);
  }

  public void glGetSamplerParameterfv(int sampler, int pname, MemorySegment params) {
    PFNGLGETSAMPLERPARAMETERFVPROC.invoke(address("glGetSamplerParameterfv"), sampler, pname, params);
  }

  public void glClearBufferfi(int buffer, int drawbuffer, float depth, int stencil) {
    PFNGLCLEARBUFFERFIPROC.invoke(address("glClearBufferfi"), buffer, drawbuffer, depth, stencil);
  }

  public void glGetFragmentLightfvSGIX(int light, int pname, MemorySegment params) {
    PFNGLGETFRAGMENTLIGHTFVSGIXPROC.invoke(address("glGetFragmentLightfvSGIX"), light, pname, params);
  }

  public void glNormal3x(int nx, int ny, int nz) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDrawRangeElementsBaseVertexOES(int mode, int start, int end, int count, int type, MemorySegment indices, int basevertex) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public int glAsyncCopyImageSubDataNVX(int waitSemaphoreCount, MemorySegment waitSemaphoreArray, MemorySegment waitValueArray, int srcGpu, int dstGpuMask, int srcName, int srcTarget, int srcLevel, int srcX, int srcY, int srcZ, int dstName, int dstTarget, int dstLevel, int dstX, int dstY, int dstZ, int srcWidth, int srcHeight, int srcDepth, int signalSemaphoreCount, MemorySegment signalSemaphoreArray, MemorySegment signalValueArray) {
    return PFNGLASYNCCOPYIMAGESUBDATANVXPROC.invoke(address("glAsyncCopyImageSubDataNVX"), waitSemaphoreCount, waitSemaphoreArray, waitValueArray, srcGpu, dstGpuMask, srcName, srcTarget, srcLevel, srcX, srcY, srcZ, dstName, dstTarget, dstLevel, dstX, dstY, dstZ, srcWidth, srcHeight, srcDepth, signalSemaphoreCount, signalSemaphoreArray, signalValueArray);
  }

  public void glClearBufferiv(int buffer, int drawbuffer, MemorySegment value) {
    PFNGLCLEARBUFFERIVPROC.invoke(address("glClearBufferiv"), buffer, drawbuffer, value);
  }

  public void glTangent3bEXT(byte tx, byte ty, byte tz) {
    PFNGLTANGENT3BEXTPROC.invoke(address("glTangent3bEXT"), tx, ty, tz);
  }

  public void glCopyNamedBufferSubData(int readBuffer, int writeBuffer, long readOffset, long writeOffset, long size) {
    PFNGLCOPYNAMEDBUFFERSUBDATAPROC.invoke(address("glCopyNamedBufferSubData"), readBuffer, writeBuffer, readOffset, writeOffset, size);
  }

  public void glDeleteTransformFeedbacks(int n, MemorySegment ids) {
    PFNGLDELETETRANSFORMFEEDBACKSPROC.invoke(address("glDeleteTransformFeedbacks"), n, ids);
  }

  public void glProgramEnvParameterI4uivNV(int target, int index, MemorySegment params) {
    PFNGLPROGRAMENVPARAMETERI4UIVNVPROC.invoke(address("glProgramEnvParameterI4uivNV"), target, index, params);
  }

  public void glSampleMaski(int maskNumber, int mask) {
    PFNGLSAMPLEMASKIPROC.invoke(address("glSampleMaski"), maskNumber, mask);
  }

  public void glMatrixPushEXT(int mode) {
    PFNGLMATRIXPUSHEXTPROC.invoke(address("glMatrixPushEXT"), mode);
  }

  public void glVertexArrayVertexAttribBindingEXT(int vaobj, int attribindex, int bindingindex) {
    PFNGLVERTEXARRAYVERTEXATTRIBBINDINGEXTPROC.invoke(address("glVertexArrayVertexAttribBindingEXT"), vaobj, attribindex, bindingindex);
  }

  public void glEGLImageTargetTexStorageEXT(int target, MemorySegment image, MemorySegment attrib_list) {
    PFNGLEGLIMAGETARGETTEXSTORAGEEXTPROC.invoke(address("glEGLImageTargetTexStorageEXT"), target, image, attrib_list);
  }

  public void glGetNamedStringivARB(int namelen, MemorySegment name, int pname, MemorySegment params) {
    PFNGLGETNAMEDSTRINGIVARBPROC.invoke(address("glGetNamedStringivARB"), namelen, name, pname, params);
  }

  public void glFinishFenceNV(int fence) {
    PFNGLFINISHFENCENVPROC.invoke(address("glFinishFenceNV"), fence);
  }

  public void glGetTextureParameterfv(int texture, int pname, MemorySegment params) {
    PFNGLGETTEXTUREPARAMETERFVPROC.invoke(address("glGetTextureParameterfv"), texture, pname, params);
  }

  public void glDrawElementsInstancedANGLE(int mode, int count, int type, MemorySegment indices, int primcount) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttrib4sv(int index, MemorySegment v) {
    PFNGLVERTEXATTRIB4SVPROC.invoke(address("glVertexAttrib4sv"), index, v);
  }

  public void glBindVertexBuffers(int first, int count, MemorySegment buffers, MemorySegment offsets, MemorySegment strides) {
    PFNGLBINDVERTEXBUFFERSPROC.invoke(address("glBindVertexBuffers"), first, count, buffers, offsets, strides);
  }

  public void glVertexAttribI4bv(int index, MemorySegment v) {
    PFNGLVERTEXATTRIBI4BVPROC.invoke(address("glVertexAttribI4bv"), index, v);
  }

  public void glDeletePerfMonitorsAMD(int n, MemorySegment monitors) {
    PFNGLDELETEPERFMONITORSAMDPROC.invoke(address("glDeletePerfMonitorsAMD"), n, monitors);
  }

  public void glGetSamplerParameteriv(int sampler, int pname, MemorySegment params) {
    PFNGLGETSAMPLERPARAMETERIVPROC.invoke(address("glGetSamplerParameteriv"), sampler, pname, params);
  }

  public void glBindProgramPipeline(int pipeline) {
    PFNGLBINDPROGRAMPIPELINEPROC.invoke(address("glBindProgramPipeline"), pipeline);
  }

  public void glScissorIndexedvOES(int index, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBindTextureEXT(int target, int texture) {
    PFNGLBINDTEXTUREEXTPROC.invoke(address("glBindTextureEXT"), target, texture);
  }

  public void glGetUniformi64vNV(int program, int location, MemorySegment params) {
    PFNGLGETUNIFORMI64VNVPROC.invoke(address("glGetUniformi64vNV"), program, location, params);
  }

  public void glDrawElementsInstancedBaseVertex(int mode, int count, int type, MemorySegment indices, int instancecount, int basevertex) {
    PFNGLDRAWELEMENTSINSTANCEDBASEVERTEXPROC.invoke(address("glDrawElementsInstancedBaseVertex"), mode, count, type, indices, instancecount, basevertex);
  }

  public void glVertexAttrib3hNV(int index, short x, short y, short z) {
    PFNGLVERTEXATTRIB3HNVPROC.invoke(address("glVertexAttrib3hNV"), index, x, y, z);
  }

  public void glGetInvariantFloatvEXT(int id, int value, MemorySegment data) {
    PFNGLGETINVARIANTFLOATVEXTPROC.invoke(address("glGetInvariantFloatvEXT"), id, value, data);
  }

  public void glCreateQueries(int target, int n, MemorySegment ids) {
    PFNGLCREATEQUERIESPROC.invoke(address("glCreateQueries"), target, n, ids);
  }

  public void glCreateTransformFeedbacks(int n, MemorySegment ids) {
    PFNGLCREATETRANSFORMFEEDBACKSPROC.invoke(address("glCreateTransformFeedbacks"), n, ids);
  }

  public void glEnableVertexAttribArray(int index) {
    PFNGLENABLEVERTEXATTRIBARRAYPROC.invoke(address("glEnableVertexAttribArray"), index);
  }

  public void glBeginTransformFeedbackNV(int primitiveMode) {
    PFNGLBEGINTRANSFORMFEEDBACKNVPROC.invoke(address("glBeginTransformFeedbackNV"), primitiveMode);
  }

  public void glProgramUniformHandleui64ARB(int program, int location, long value) {
    PFNGLPROGRAMUNIFORMHANDLEUI64ARBPROC.invoke(address("glProgramUniformHandleui64ARB"), program, location, value);
  }

  public void glImageTransformParameterfvHP(int target, int pname, MemorySegment params) {
    PFNGLIMAGETRANSFORMPARAMETERFVHPPROC.invoke(address("glImageTransformParameterfvHP"), target, pname, params);
  }

  public void glClearBufferData(int target, int internalformat, int format, int type, MemorySegment data) {
    PFNGLCLEARBUFFERDATAPROC.invoke(address("glClearBufferData"), target, internalformat, format, type, data);
  }

  public void glWindowPos2fARB(float x, float y) {
    PFNGLWINDOWPOS2FARBPROC.invoke(address("glWindowPos2fARB"), x, y);
  }

  public void glGetActiveAttribARB(int programObj, int index, int maxLength, MemorySegment length, MemorySegment size, MemorySegment type, MemorySegment name) {
    PFNGLGETACTIVEATTRIBARBPROC.invoke(address("glGetActiveAttribARB"), programObj, index, maxLength, length, size, type, name);
  }

  public void glUniform1fvARB(int location, int count, MemorySegment value) {
    PFNGLUNIFORM1FVARBPROC.invoke(address("glUniform1fvARB"), location, count, value);
  }

  public long glGetImageHandleARB(int texture, int level, byte layered, int layer, int format) {
    return PFNGLGETIMAGEHANDLEARBPROC.invoke(address("glGetImageHandleARB"), texture, level, layered, layer, format);
  }

  public void glGetFloati_vNV(int target, int index, MemorySegment data) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glSwizzleEXT(int res, int in, int outX, int outY, int outZ, int outW) {
    PFNGLSWIZZLEEXTPROC.invoke(address("glSwizzleEXT"), res, in, outX, outY, outZ, outW);
  }

  public void glCopyBufferSubData(int readTarget, int writeTarget, long readOffset, long writeOffset, long size) {
    PFNGLCOPYBUFFERSUBDATAPROC.invoke(address("glCopyBufferSubData"), readTarget, writeTarget, readOffset, writeOffset, size);
  }

  public void glMatrixMultfEXT(int mode, MemorySegment m) {
    PFNGLMATRIXMULTFEXTPROC.invoke(address("glMatrixMultfEXT"), mode, m);
  }

  public void glUniform2ui64vNV(int location, int count, MemorySegment value) {
    PFNGLUNIFORM2UI64VNVPROC.invoke(address("glUniform2ui64vNV"), location, count, value);
  }

  public void glProgramUniform2uiv(int program, int location, int count, MemorySegment value) {
    PFNGLPROGRAMUNIFORM2UIVPROC.invoke(address("glProgramUniform2uiv"), program, location, count, value);
  }

  public void glProgramUniformMatrix4x3dvEXT(int program, int location, int count, byte transpose, MemorySegment value) {
    PFNGLPROGRAMUNIFORMMATRIX4X3DVEXTPROC.invoke(address("glProgramUniformMatrix4x3dvEXT"), program, location, count, transpose, value);
  }

  public void glDispatchComputeIndirect(long indirect) {
    PFNGLDISPATCHCOMPUTEINDIRECTPROC.invoke(address("glDispatchComputeIndirect"), indirect);
  }

  public void glGetTextureParameteriv(int texture, int pname, MemorySegment params) {
    PFNGLGETTEXTUREPARAMETERIVPROC.invoke(address("glGetTextureParameteriv"), texture, pname, params);
  }

  public void glMultiTexCoord2bOES(int texture, byte s, byte t) {
    PFNGLMULTITEXCOORD2BOESPROC.invoke(address("glMultiTexCoord2bOES"), texture, s, t);
  }

  public void glMultiTexCoord2xOES(int texture, int s, int t) {
    PFNGLMULTITEXCOORD2XOESPROC.invoke(address("glMultiTexCoord2xOES"), texture, s, t);
  }

  public void glGenerateMultiTexMipmapEXT(int texunit, int target) {
    PFNGLGENERATEMULTITEXMIPMAPEXTPROC.invoke(address("glGenerateMultiTexMipmapEXT"), texunit, target);
  }

  public void glStencilThenCoverFillPathNV(int path, int fillMode, int mask, int coverMode) {
    PFNGLSTENCILTHENCOVERFILLPATHNVPROC.invoke(address("glStencilThenCoverFillPathNV"), path, fillMode, mask, coverMode);
  }

  public void glUniform2fvARB(int location, int count, MemorySegment value) {
    PFNGLUNIFORM2FVARBPROC.invoke(address("glUniform2fvARB"), location, count, value);
  }

  public void glVertexArrayFogCoordOffsetEXT(int vaobj, int buffer, int type, int stride, long offset) {
    PFNGLVERTEXARRAYFOGCOORDOFFSETEXTPROC.invoke(address("glVertexArrayFogCoordOffsetEXT"), vaobj, buffer, type, stride, offset);
  }

  public void glClearDepthdNV(double depth) {
    PFNGLCLEARDEPTHDNVPROC.invoke(address("glClearDepthdNV"), depth);
  }

  public void glGetQueryObjectuiv(int id, int pname, MemorySegment params) {
    PFNGLGETQUERYOBJECTUIVPROC.invoke(address("glGetQueryObjectuiv"), id, pname, params);
  }

  public void glExtGetTexLevelParameterivQCOM(int texture, int face, int level, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glPassTexCoordATI(int dst, int coord, int swizzle) {
    PFNGLPASSTEXCOORDATIPROC.invoke(address("glPassTexCoordATI"), dst, coord, swizzle);
  }

  public void glMatrixLoadfEXT(int mode, MemorySegment m) {
    PFNGLMATRIXLOADFEXTPROC.invoke(address("glMatrixLoadfEXT"), mode, m);
  }

  public void glDeleteAsyncMarkersSGIX(int marker, int range) {
    PFNGLDELETEASYNCMARKERSSGIXPROC.invoke(address("glDeleteAsyncMarkersSGIX"), marker, range);
  }

  public void glDrawMeshArraysSUN(int mode, int first, int count, int width) {
    PFNGLDRAWMESHARRAYSSUNPROC.invoke(address("glDrawMeshArraysSUN"), mode, first, count, width);
  }

  public void glGetVertexAttribPointervNV(int index, int pname, MemorySegment pointer) {
    PFNGLGETVERTEXATTRIBPOINTERVNVPROC.invoke(address("glGetVertexAttribPointervNV"), index, pname, pointer);
  }

  public void glGetnPixelMapusvARB(int map, int bufSize, MemorySegment values) {
    PFNGLGETNPIXELMAPUSVARBPROC.invoke(address("glGetnPixelMapusvARB"), map, bufSize, values);
  }

  public int glGetInstrumentsSGIX() {
    return PFNGLGETINSTRUMENTSSGIXPROC.invoke(address("glGetInstrumentsSGIX"));
  }

  public void glGenRenderbuffers(int n, MemorySegment renderbuffers) {
    PFNGLGENRENDERBUFFERSPROC.invoke(address("glGenRenderbuffers"), n, renderbuffers);
  }

  public byte glIsAsyncMarkerSGIX(int marker) {
    return PFNGLISASYNCMARKERSGIXPROC.invoke(address("glIsAsyncMarkerSGIX"), marker);
  }

  public void glVertexAttribs3fvNV(int index, int count, MemorySegment v) {
    PFNGLVERTEXATTRIBS3FVNVPROC.invoke(address("glVertexAttribs3fvNV"), index, count, v);
  }

  public void glVertexAttrib1sNV(int index, short x) {
    PFNGLVERTEXATTRIB1SNVPROC.invoke(address("glVertexAttrib1sNV"), index, x);
  }

  public void glTexParameterxv(int target, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniformMatrix3x4fvEXT(int program, int location, int count, byte transpose, MemorySegment value) {
    PFNGLPROGRAMUNIFORMMATRIX3X4FVEXTPROC.invoke(address("glProgramUniformMatrix3x4fvEXT"), program, location, count, transpose, value);
  }

  public void glSecondaryColor3fvEXT(MemorySegment v) {
    PFNGLSECONDARYCOLOR3FVEXTPROC.invoke(address("glSecondaryColor3fvEXT"), v);
  }

  public void glBlendEquationEXT(int mode) {
    PFNGLBLENDEQUATIONEXTPROC.invoke(address("glBlendEquationEXT"), mode);
  }

  public void glBeginPerfQueryINTEL(int queryHandle) {
    PFNGLBEGINPERFQUERYINTELPROC.invoke(address("glBeginPerfQueryINTEL"), queryHandle);
  }

  public void glFlushVertexArrayRangeAPPLE(int length, MemorySegment pointer) {
    PFNGLFLUSHVERTEXARRAYRANGEAPPLEPROC.invoke(address("glFlushVertexArrayRangeAPPLE"), length, pointer);
  }

  public void glProgramUniform2ui(int program, int location, int v0, int v1) {
    PFNGLPROGRAMUNIFORM2UIPROC.invoke(address("glProgramUniform2ui"), program, location, v0, v1);
  }

  public void glBlendEquationSeparateiEXT(int buf, int modeRGB, int modeAlpha) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMakeImageHandleResidentNV(long handle, int access) {
    PFNGLMAKEIMAGEHANDLERESIDENTNVPROC.invoke(address("glMakeImageHandleResidentNV"), handle, access);
  }

  public void glGetFloatIndexedvEXT(int target, int index, MemorySegment data) {
    PFNGLGETFLOATINDEXEDVEXTPROC.invoke(address("glGetFloatIndexedvEXT"), target, index, data);
  }

  public void glGetSamplerParameterIuivEXT(int sampler, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glInterpolatePathsNV(int resultPath, int pathA, int pathB, float weight) {
    PFNGLINTERPOLATEPATHSNVPROC.invoke(address("glInterpolatePathsNV"), resultPath, pathA, pathB, weight);
  }

  public void glUniform4fv(int location, int count, MemorySegment value) {
    PFNGLUNIFORM4FVPROC.invoke(address("glUniform4fv"), location, count, value);
  }

  public void glVertexAttribs2dvNV(int index, int count, MemorySegment v) {
    PFNGLVERTEXATTRIBS2DVNVPROC.invoke(address("glVertexAttribs2dvNV"), index, count, v);
  }

  public void glBindBuffersRange(int target, int first, int count, MemorySegment buffers, MemorySegment offsets, MemorySegment sizes) {
    PFNGLBINDBUFFERSRANGEPROC.invoke(address("glBindBuffersRange"), target, first, count, buffers, offsets, sizes);
  }

  public void glPathStencilDepthOffsetNV(float factor, float units) {
    PFNGLPATHSTENCILDEPTHOFFSETNVPROC.invoke(address("glPathStencilDepthOffsetNV"), factor, units);
  }

  public void glShaderStorageBlockBinding(int program, int storageBlockIndex, int storageBlockBinding) {
    PFNGLSHADERSTORAGEBLOCKBINDINGPROC.invoke(address("glShaderStorageBlockBinding"), program, storageBlockIndex, storageBlockBinding);
  }

  public void glVertexAttribs4svNV(int index, int count, MemorySegment v) {
    PFNGLVERTEXATTRIBS4SVNVPROC.invoke(address("glVertexAttribs4svNV"), index, count, v);
  }

  public void glBeginQueryIndexed(int target, int index, int id) {
    PFNGLBEGINQUERYINDEXEDPROC.invoke(address("glBeginQueryIndexed"), target, index, id);
  }

  public void glFramebufferTexture3DEXT(int target, int attachment, int textarget, int texture, int level, int zoffset) {
    PFNGLFRAMEBUFFERTEXTURE3DEXTPROC.invoke(address("glFramebufferTexture3DEXT"), target, attachment, textarget, texture, level, zoffset);
  }

  public void glGetVideoCaptureStreamivNV(int video_capture_slot, int stream, int pname, MemorySegment params) {
    PFNGLGETVIDEOCAPTURESTREAMIVNVPROC.invoke(address("glGetVideoCaptureStreamivNV"), video_capture_slot, stream, pname, params);
  }

  public void glStencilFillPathInstancedNV(int numPaths, int pathNameType, MemorySegment paths, int pathBase, int fillMode, int mask, int transformType, MemorySegment transformValues) {
    PFNGLSTENCILFILLPATHINSTANCEDNVPROC.invoke(address("glStencilFillPathInstancedNV"), numPaths, pathNameType, paths, pathBase, fillMode, mask, transformType, transformValues);
  }

  public void glUniform4iv(int location, int count, MemorySegment value) {
    PFNGLUNIFORM4IVPROC.invoke(address("glUniform4iv"), location, count, value);
  }

  public void glVertexAttribI4iv(int index, MemorySegment v) {
    PFNGLVERTEXATTRIBI4IVPROC.invoke(address("glVertexAttribI4iv"), index, v);
  }

  public void glProgramUniformMatrix4x2dvEXT(int program, int location, int count, byte transpose, MemorySegment value) {
    PFNGLPROGRAMUNIFORMMATRIX4X2DVEXTPROC.invoke(address("glProgramUniformMatrix4x2dvEXT"), program, location, count, transpose, value);
  }

  public void glCopyColorSubTableEXT(int target, int start, int x, int y, int width) {
    PFNGLCOPYCOLORSUBTABLEEXTPROC.invoke(address("glCopyColorSubTableEXT"), target, start, x, y, width);
  }

  public void glGetProgramPipelineInfoLogEXT(int pipeline, int bufSize, MemorySegment length, MemorySegment infoLog) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glWindowPos3svARB(MemorySegment v) {
    PFNGLWINDOWPOS3SVARBPROC.invoke(address("glWindowPos3svARB"), v);
  }

  public int glGetDebugMessageLogARB(int count, int bufSize, MemorySegment sources, MemorySegment types, MemorySegment ids, MemorySegment severities, MemorySegment lengths, MemorySegment messageLog) {
    return PFNGLGETDEBUGMESSAGELOGARBPROC.invoke(address("glGetDebugMessageLogARB"), count, bufSize, sources, types, ids, severities, lengths, messageLog);
  }

  public void glVDPAUInitNV(MemorySegment vdpDevice, MemorySegment getProcAddress) {
    PFNGLVDPAUINITNVPROC.invoke(address("glVDPAUInitNV"), vdpDevice, getProcAddress);
  }

  public void glWeightsvARB(int size, MemorySegment weights) {
    PFNGLWEIGHTSVARBPROC.invoke(address("glWeightsvARB"), size, weights);
  }

  public void glVertexAttribs4hvNV(int index, int n, MemorySegment v) {
    PFNGLVERTEXATTRIBS4HVNVPROC.invoke(address("glVertexAttribs4hvNV"), index, n, v);
  }

  public void glGetUniformui64vARB(int program, int location, MemorySegment params) {
    PFNGLGETUNIFORMUI64VARBPROC.invoke(address("glGetUniformui64vARB"), program, location, params);
  }

  public void glMultiTexCoordPointerEXT(int texunit, int size, int type, int stride, MemorySegment pointer) {
    PFNGLMULTITEXCOORDPOINTEREXTPROC.invoke(address("glMultiTexCoordPointerEXT"), texunit, size, type, stride, pointer);
  }

  public void glClearNamedFramebufferuiv(int framebuffer, int buffer, int drawbuffer, MemorySegment value) {
    PFNGLCLEARNAMEDFRAMEBUFFERUIVPROC.invoke(address("glClearNamedFramebufferuiv"), framebuffer, buffer, drawbuffer, value);
  }

  public void glFragmentLightfvSGIX(int light, int pname, MemorySegment params) {
    PFNGLFRAGMENTLIGHTFVSGIXPROC.invoke(address("glFragmentLightfvSGIX"), light, pname, params);
  }

  public void glTexSubImage3DOES(int target, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int format, int type, MemorySegment pixels) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniform4uiEXT(int program, int location, int v0, int v1, int v2, int v3) {
    PFNGLPROGRAMUNIFORM4UIEXTPROC.invoke(address("glProgramUniform4uiEXT"), program, location, v0, v1, v2, v3);
  }

  public void glGenTexturesEXT(int n, MemorySegment textures) {
    PFNGLGENTEXTURESEXTPROC.invoke(address("glGenTexturesEXT"), n, textures);
  }

  public void glDispatchComputeGroupSizeARB(int num_groups_x, int num_groups_y, int num_groups_z, int group_size_x, int group_size_y, int group_size_z) {
    PFNGLDISPATCHCOMPUTEGROUPSIZEARBPROC.invoke(address("glDispatchComputeGroupSizeARB"), num_groups_x, num_groups_y, num_groups_z, group_size_x, group_size_y, group_size_z);
  }

  public void glColor3hvNV(MemorySegment v) {
    PFNGLCOLOR3HVNVPROC.invoke(address("glColor3hvNV"), v);
  }

  public void glLoadPaletteFromModelViewMatrixOES() {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDepthRangexOES(int n, int f) {
    PFNGLDEPTHRANGEXOESPROC.invoke(address("glDepthRangexOES"), n, f);
  }

  public long glGetTextureSamplerHandleNV(int texture, int sampler) {
    return PFNGLGETTEXTURESAMPLERHANDLENVPROC.invoke(address("glGetTextureSamplerHandleNV"), texture, sampler);
  }

  public void glProgramVertexLimitNV(int target, int limit) {
    PFNGLPROGRAMVERTEXLIMITNVPROC.invoke(address("glProgramVertexLimitNV"), target, limit);
  }

  public void glCreateSamplers(int n, MemorySegment samplers) {
    PFNGLCREATESAMPLERSPROC.invoke(address("glCreateSamplers"), n, samplers);
  }

  public void glVertexAttrib4NubvARB(int index, MemorySegment v) {
    PFNGLVERTEXATTRIB4NUBVARBPROC.invoke(address("glVertexAttrib4NubvARB"), index, v);
  }

  public void glDeleteNamesAMD(int identifier, int num, MemorySegment names) {
    PFNGLDELETENAMESAMDPROC.invoke(address("glDeleteNamesAMD"), identifier, num, names);
  }

  public void glTextureStorage1DEXT(int texture, int target, int levels, int internalformat, int width) {
    PFNGLTEXTURESTORAGE1DEXTPROC.invoke(address("glTextureStorage1DEXT"), texture, target, levels, internalformat, width);
  }

  public void glVertexPointerEXT(int size, int type, int stride, int count, MemorySegment pointer) {
    PFNGLVERTEXPOINTEREXTPROC.invoke(address("glVertexPointerEXT"), size, type, stride, count, pointer);
  }

  public void glVertexStream1ivATI(int stream, MemorySegment coords) {
    PFNGLVERTEXSTREAM1IVATIPROC.invoke(address("glVertexStream1ivATI"), stream, coords);
  }

  public void glColorFragmentOp1ATI(int op, int dst, int dstMask, int dstMod, int arg1, int arg1Rep, int arg1Mod) {
    PFNGLCOLORFRAGMENTOP1ATIPROC.invoke(address("glColorFragmentOp1ATI"), op, dst, dstMask, dstMod, arg1, arg1Rep, arg1Mod);
  }

  public void glLineWidthx(int width) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetVertexAttribArrayObjectivATI(int index, int pname, MemorySegment params) {
    PFNGLGETVERTEXATTRIBARRAYOBJECTIVATIPROC.invoke(address("glGetVertexAttribArrayObjectivATI"), index, pname, params);
  }

  public void glGetColorTableParameterivSGI(int target, int pname, MemorySegment params) {
    PFNGLGETCOLORTABLEPARAMETERIVSGIPROC.invoke(address("glGetColorTableParameterivSGI"), target, pname, params);
  }

  public void glPrimitiveBoundingBoxARB(float minX, float minY, float minZ, float minW, float maxX, float maxY, float maxZ, float maxW) {
    PFNGLPRIMITIVEBOUNDINGBOXARBPROC.invoke(address("glPrimitiveBoundingBoxARB"), minX, minY, minZ, minW, maxX, maxY, maxZ, maxW);
  }

  public void glUniformMatrix2x3fv(int location, int count, byte transpose, MemorySegment value) {
    PFNGLUNIFORMMATRIX2X3FVPROC.invoke(address("glUniformMatrix2x3fv"), location, count, transpose, value);
  }

  public void glTextureImage1DEXT(int texture, int target, int level, int internalformat, int width, int border, int format, int type, MemorySegment pixels) {
    PFNGLTEXTUREIMAGE1DEXTPROC.invoke(address("glTextureImage1DEXT"), texture, target, level, internalformat, width, border, format, type, pixels);
  }

  public int glGetDebugMessageLogAMD(int count, int bufSize, MemorySegment categories, MemorySegment severities, MemorySegment ids, MemorySegment lengths, MemorySegment message) {
    return PFNGLGETDEBUGMESSAGELOGAMDPROC.invoke(address("glGetDebugMessageLogAMD"), count, bufSize, categories, severities, ids, lengths, message);
  }

  public void glLightModelx(int pname, int param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public int glQueryResourceNV(int queryType, int tagId, int count, MemorySegment buffer) {
    return PFNGLQUERYRESOURCENVPROC.invoke(address("glQueryResourceNV"), queryType, tagId, count, buffer);
  }

  public void glTexAttachMemoryNV(int target, int memory, long offset) {
    PFNGLTEXATTACHMEMORYNVPROC.invoke(address("glTexAttachMemoryNV"), target, memory, offset);
  }

  public long glGetUniformOffsetEXT(int program, int location) {
    return PFNGLGETUNIFORMOFFSETEXTPROC.invoke(address("glGetUniformOffsetEXT"), program, location);
  }

  public void glDeleteShader(int shader) {
    PFNGLDELETESHADERPROC.invoke(address("glDeleteShader"), shader);
  }

  public void glUniform3uiv(int location, int count, MemorySegment value) {
    PFNGLUNIFORM3UIVPROC.invoke(address("glUniform3uiv"), location, count, value);
  }

  public void glColorTableParameterfvSGI(int target, int pname, MemorySegment params) {
    PFNGLCOLORTABLEPARAMETERFVSGIPROC.invoke(address("glColorTableParameterfvSGI"), target, pname, params);
  }

  public void glDrawCommandsStatesNV(int buffer, MemorySegment indirects, MemorySegment sizes, MemorySegment states, MemorySegment fbos, int count) {
    PFNGLDRAWCOMMANDSSTATESNVPROC.invoke(address("glDrawCommandsStatesNV"), buffer, indirects, sizes, states, fbos, count);
  }

  public void glGetQueryivEXT(int target, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexArrayVertexOffsetEXT(int vaobj, int buffer, int size, int type, int stride, long offset) {
    PFNGLVERTEXARRAYVERTEXOFFSETEXTPROC.invoke(address("glVertexArrayVertexOffsetEXT"), vaobj, buffer, size, type, stride, offset);
  }

  public void glVertexAttrib4iv(int index, MemorySegment v) {
    PFNGLVERTEXATTRIB4IVPROC.invoke(address("glVertexAttrib4iv"), index, v);
  }

  public void glEdgeFlagPointerListIBM(int stride, MemorySegment pointer, int ptrstride) {
    PFNGLEDGEFLAGPOINTERLISTIBMPROC.invoke(address("glEdgeFlagPointerListIBM"), stride, pointer, ptrstride);
  }

  public void glVertexAttrib4fv(int index, MemorySegment v) {
    PFNGLVERTEXATTRIB4FVPROC.invoke(address("glVertexAttrib4fv"), index, v);
  }

  public void glVertexStream3svATI(int stream, MemorySegment coords) {
    PFNGLVERTEXSTREAM3SVATIPROC.invoke(address("glVertexStream3svATI"), stream, coords);
  }

  public void glGetNamedBufferPointerv(int buffer, int pname, MemorySegment params) {
    PFNGLGETNAMEDBUFFERPOINTERVPROC.invoke(address("glGetNamedBufferPointerv"), buffer, pname, params);
  }

  public void glIndexMaterialEXT(int face, int mode) {
    PFNGLINDEXMATERIALEXTPROC.invoke(address("glIndexMaterialEXT"), face, mode);
  }

  public void glScissorExclusiveNV(int x, int y, int width, int height) {
    PFNGLSCISSOREXCLUSIVENVPROC.invoke(address("glScissorExclusiveNV"), x, y, width, height);
  }

  public void glDeleteObjectARB(int obj) {
    PFNGLDELETEOBJECTARBPROC.invoke(address("glDeleteObjectARB"), obj);
  }

  public void glMultiModeDrawArraysIBM(MemorySegment mode, MemorySegment first, MemorySegment count, int primcount, int modestride) {
    PFNGLMULTIMODEDRAWARRAYSIBMPROC.invoke(address("glMultiModeDrawArraysIBM"), mode, first, count, primcount, modestride);
  }

  public void glMatrixLoad3x2fNV(int matrixMode, MemorySegment m) {
    PFNGLMATRIXLOAD3X2FNVPROC.invoke(address("glMatrixLoad3x2fNV"), matrixMode, m);
  }

  public void glCompressedMultiTexSubImage2DEXT(int texunit, int target, int level, int xoffset, int yoffset, int width, int height, int format, int imageSize, MemorySegment bits) {
    PFNGLCOMPRESSEDMULTITEXSUBIMAGE2DEXTPROC.invoke(address("glCompressedMultiTexSubImage2DEXT"), texunit, target, level, xoffset, yoffset, width, height, format, imageSize, bits);
  }

  public void glGetMemoryObjectDetachedResourcesuivNV(int memory, int pname, int first, int count, MemorySegment params) {
    PFNGLGETMEMORYOBJECTDETACHEDRESOURCESUIVNVPROC.invoke(address("glGetMemoryObjectDetachedResourcesuivNV"), memory, pname, first, count, params);
  }

  public void glWindowPos3iMESA(int x, int y, int z) {
    PFNGLWINDOWPOS3IMESAPROC.invoke(address("glWindowPos3iMESA"), x, y, z);
  }

  public void glCreateTextures(int target, int n, MemorySegment textures) {
    PFNGLCREATETEXTURESPROC.invoke(address("glCreateTextures"), target, n, textures);
  }

  public void glDrawBuffersIndexedEXT(int n, MemorySegment location, MemorySegment indices) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniform4i64vNV(int location, int count, MemorySegment value) {
    PFNGLUNIFORM4I64VNVPROC.invoke(address("glUniform4i64vNV"), location, count, value);
  }

  public void glLoadTransposeMatrixdARB(MemorySegment m) {
    PFNGLLOADTRANSPOSEMATRIXDARBPROC.invoke(address("glLoadTransposeMatrixdARB"), m);
  }

  public void glVertexAttribL3dvEXT(int index, MemorySegment v) {
    PFNGLVERTEXATTRIBL3DVEXTPROC.invoke(address("glVertexAttribL3dvEXT"), index, v);
  }

  public void glGetnUniformfvARB(int program, int location, int bufSize, MemorySegment params) {
    PFNGLGETNUNIFORMFVARBPROC.invoke(address("glGetnUniformfvARB"), program, location, bufSize, params);
  }

  public void glCompressedTextureSubImage1DEXT(int texture, int target, int level, int xoffset, int width, int format, int imageSize, MemorySegment bits) {
    PFNGLCOMPRESSEDTEXTURESUBIMAGE1DEXTPROC.invoke(address("glCompressedTextureSubImage1DEXT"), texture, target, level, xoffset, width, format, imageSize, bits);
  }

  public void glUniformMatrix2x3dv(int location, int count, byte transpose, MemorySegment value) {
    PFNGLUNIFORMMATRIX2X3DVPROC.invoke(address("glUniformMatrix2x3dv"), location, count, transpose, value);
  }

  public void glFrustumx(int l, int r, int b, int t, int n, int f) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniform4dv(int location, int count, MemorySegment value) {
    PFNGLUNIFORM4DVPROC.invoke(address("glUniform4dv"), location, count, value);
  }

  public void glFrustumf(float l, float r, float b, float t, float n, float f) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFramebufferTextureMultisampleMultiviewOVR(int target, int attachment, int texture, int level, int samples, int baseViewIndex, int numViews) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribI4sv(int index, MemorySegment v) {
    PFNGLVERTEXATTRIBI4SVPROC.invoke(address("glVertexAttribI4sv"), index, v);
  }

  public void glGetNamedRenderbufferParameteriv(int renderbuffer, int pname, MemorySegment params) {
    PFNGLGETNAMEDRENDERBUFFERPARAMETERIVPROC.invoke(address("glGetNamedRenderbufferParameteriv"), renderbuffer, pname, params);
  }

  public void glProgramEnvParameter4dARB(int target, int index, double x, double y, double z, double w) {
    PFNGLPROGRAMENVPARAMETER4DARBPROC.invoke(address("glProgramEnvParameter4dARB"), target, index, x, y, z, w);
  }

  public void glCopyTextureSubImage1DEXT(int texture, int target, int level, int xoffset, int x, int y, int width) {
    PFNGLCOPYTEXTURESUBIMAGE1DEXTPROC.invoke(address("glCopyTextureSubImage1DEXT"), texture, target, level, xoffset, x, y, width);
  }

  public void glVertexArrayVertexBindingDivisorEXT(int vaobj, int bindingindex, int divisor) {
    PFNGLVERTEXARRAYVERTEXBINDINGDIVISOREXTPROC.invoke(address("glVertexArrayVertexBindingDivisorEXT"), vaobj, bindingindex, divisor);
  }

  public void glFramebufferTexture1D(int target, int attachment, int textarget, int texture, int level) {
    PFNGLFRAMEBUFFERTEXTURE1DPROC.invoke(address("glFramebufferTexture1D"), target, attachment, textarget, texture, level);
  }

  public void glFramebufferFetchBarrierEXT() {
    PFNGLFRAMEBUFFERFETCHBARRIEREXTPROC.invoke(address("glFramebufferFetchBarrierEXT"));
  }

  public void glLightModelxOES(int pname, int param) {
    PFNGLLIGHTMODELXOESPROC.invoke(address("glLightModelxOES"), pname, param);
  }

  public void glTexImage3DMultisample(int target, int samples, int internalformat, int width, int height, int depth, byte fixedsamplelocations) {
    PFNGLTEXIMAGE3DMULTISAMPLEPROC.invoke(address("glTexImage3DMultisample"), target, samples, internalformat, width, height, depth, fixedsamplelocations);
  }

  public void glUniform1i64NV(int location, long x) {
    PFNGLUNIFORM1I64NVPROC.invoke(address("glUniform1i64NV"), location, x);
  }

  public void glProgramUniformMatrix3x2dv(int program, int location, int count, byte transpose, MemorySegment value) {
    PFNGLPROGRAMUNIFORMMATRIX3X2DVPROC.invoke(address("glProgramUniformMatrix3x2dv"), program, location, count, transpose, value);
  }

  public void glRenderbufferStorageOES(int target, int internalformat, int width, int height) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexRenderbufferNV(int target, int renderbuffer) {
    PFNGLTEXRENDERBUFFERNVPROC.invoke(address("glTexRenderbufferNV"), target, renderbuffer);
  }

  public void glPolygonOffsetEXT(float factor, float bias) {
    PFNGLPOLYGONOFFSETEXTPROC.invoke(address("glPolygonOffsetEXT"), factor, bias);
  }

  public void glProgramUniform4dEXT(int program, int location, double x, double y, double z, double w) {
    PFNGLPROGRAMUNIFORM4DEXTPROC.invoke(address("glProgramUniform4dEXT"), program, location, x, y, z, w);
  }

  public void glCreateMemoryObjectsEXT(int n, MemorySegment memoryObjects) {
    PFNGLCREATEMEMORYOBJECTSEXTPROC.invoke(address("glCreateMemoryObjectsEXT"), n, memoryObjects);
  }

  public void glMatrixRotatefEXT(int mode, float angle, float x, float y, float z) {
    PFNGLMATRIXROTATEFEXTPROC.invoke(address("glMatrixRotatefEXT"), mode, angle, x, y, z);
  }

  public void glGetPerfMonitorCounterStringAMD(int group, int counter, int bufSize, MemorySegment length, MemorySegment counterString) {
    PFNGLGETPERFMONITORCOUNTERSTRINGAMDPROC.invoke(address("glGetPerfMonitorCounterStringAMD"), group, counter, bufSize, length, counterString);
  }

  public void glUniformMatrix2x4dv(int location, int count, byte transpose, MemorySegment value) {
    PFNGLUNIFORMMATRIX2X4DVPROC.invoke(address("glUniformMatrix2x4dv"), location, count, transpose, value);
  }

  public void glVertexAttribI4ui(int index, int x, int y, int z, int w) {
    PFNGLVERTEXATTRIBI4UIPROC.invoke(address("glVertexAttribI4ui"), index, x, y, z, w);
  }

  public void glGetColorTableEXT(int target, int format, int type, MemorySegment data) {
    PFNGLGETCOLORTABLEEXTPROC.invoke(address("glGetColorTableEXT"), target, format, type, data);
  }

  public void glFlushMappedBufferRange(int target, long offset, long length) {
    PFNGLFLUSHMAPPEDBUFFERRANGEPROC.invoke(address("glFlushMappedBufferRange"), target, offset, length);
  }

  public void glGetTextureImageEXT(int texture, int target, int level, int format, int type, MemorySegment pixels) {
    PFNGLGETTEXTUREIMAGEEXTPROC.invoke(address("glGetTextureImageEXT"), texture, target, level, format, type, pixels);
  }

  public void glResumeTransformFeedbackNV() {
    PFNGLRESUMETRANSFORMFEEDBACKNVPROC.invoke(address("glResumeTransformFeedbackNV"));
  }

  public void glBindBufferBaseNV(int target, int index, int buffer) {
    PFNGLBINDBUFFERBASENVPROC.invoke(address("glBindBufferBaseNV"), target, index, buffer);
  }

  public void glCopyConvolutionFilter2DEXT(int target, int internalformat, int x, int y, int width, int height) {
    PFNGLCOPYCONVOLUTIONFILTER2DEXTPROC.invoke(address("glCopyConvolutionFilter2DEXT"), target, internalformat, x, y, width, height);
  }

  public void glTransformFeedbackVaryings(int program, int count, MemorySegment varyings, int bufferMode) {
    PFNGLTRANSFORMFEEDBACKVARYINGSPROC.invoke(address("glTransformFeedbackVaryings"), program, count, varyings, bufferMode);
  }

  public void glProgramLocalParameterI4iNV(int target, int index, int x, int y, int z, int w) {
    PFNGLPROGRAMLOCALPARAMETERI4INVPROC.invoke(address("glProgramLocalParameterI4iNV"), target, index, x, y, z, w);
  }

  public void glUniform3ui64vNV(int location, int count, MemorySegment value) {
    PFNGLUNIFORM3UI64VNVPROC.invoke(address("glUniform3ui64vNV"), location, count, value);
  }

  public void glScalex(int x, int y, int z) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetMapAttribParameterfvNV(int target, int index, int pname, MemorySegment params) {
    PFNGLGETMAPATTRIBPARAMETERFVNVPROC.invoke(address("glGetMapAttribParameterfvNV"), target, index, pname, params);
  }

  public void glEnableiOES(int target, int index) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glRenderbufferStorageMultisampleANGLE(int target, int samples, int internalformat, int width, int height) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFramebufferTexture3D(int target, int attachment, int textarget, int texture, int level, int zoffset) {
    PFNGLFRAMEBUFFERTEXTURE3DPROC.invoke(address("glFramebufferTexture3D"), target, attachment, textarget, texture, level, zoffset);
  }

  public void glMultiTexCoordP4uiv(int texture, int type, MemorySegment coords) {
    PFNGLMULTITEXCOORDP4UIVPROC.invoke(address("glMultiTexCoordP4uiv"), texture, type, coords);
  }

  public void glProgramUniform2i64ARB(int program, int location, long x, long y) {
    PFNGLPROGRAMUNIFORM2I64ARBPROC.invoke(address("glProgramUniform2i64ARB"), program, location, x, y);
  }

  public void glMultMatrixxOES(MemorySegment m) {
    PFNGLMULTMATRIXXOESPROC.invoke(address("glMultMatrixxOES"), m);
  }

  public void glTexParameterxvOES(int target, int pname, MemorySegment params) {
    PFNGLTEXPARAMETERXVOESPROC.invoke(address("glTexParameterxvOES"), target, pname, params);
  }

  public void glEndVertexShaderEXT() {
    PFNGLENDVERTEXSHADEREXTPROC.invoke(address("glEndVertexShaderEXT"));
  }

  public void glQueryResourceTagNV(int tagId, MemorySegment tagString) {
    PFNGLQUERYRESOURCETAGNVPROC.invoke(address("glQueryResourceTagNV"), tagId, tagString);
  }

  public void glVertex2bvOES(MemorySegment coords) {
    PFNGLVERTEX2BVOESPROC.invoke(address("glVertex2bvOES"), coords);
  }

  public void glTexStorage2DEXT(int target, int levels, int internalformat, int width, int height) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetnUniformi64vARB(int program, int location, int bufSize, MemorySegment params) {
    PFNGLGETNUNIFORMI64VARBPROC.invoke(address("glGetnUniformi64vARB"), program, location, bufSize, params);
  }

  public void glProgramUniform3dvEXT(int program, int location, int count, MemorySegment value) {
    PFNGLPROGRAMUNIFORM3DVEXTPROC.invoke(address("glProgramUniform3dvEXT"), program, location, count, value);
  }

  public void glFramebufferTexture2D(int target, int attachment, int textarget, int texture, int level) {
    PFNGLFRAMEBUFFERTEXTURE2DPROC.invoke(address("glFramebufferTexture2D"), target, attachment, textarget, texture, level);
  }

  public void glBlendEquationSeparateiOES(int buf, int modeRGB, int modeAlpha) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexParameterIuiv(int target, int pname, MemorySegment params) {
    PFNGLTEXPARAMETERIUIVPROC.invoke(address("glTexParameterIuiv"), target, pname, params);
  }

  public void glDeleteRenderbuffersEXT(int n, MemorySegment renderbuffers) {
    PFNGLDELETERENDERBUFFERSEXTPROC.invoke(address("glDeleteRenderbuffersEXT"), n, renderbuffers);
  }

  public void glGetUnsignedBytevEXT(int pname, MemorySegment data) {
    PFNGLGETUNSIGNEDBYTEVEXTPROC.invoke(address("glGetUnsignedBytevEXT"), pname, data);
  }

  public byte glIsSemaphoreEXT(int semaphore) {
    return PFNGLISSEMAPHOREEXTPROC.invoke(address("glIsSemaphoreEXT"), semaphore);
  }

  public void glVertexStream4iATI(int stream, int x, int y, int z, int w) {
    PFNGLVERTEXSTREAM4IATIPROC.invoke(address("glVertexStream4iATI"), stream, x, y, z, w);
  }

  public void glDrawElementArrayAPPLE(int mode, int first, int count) {
    PFNGLDRAWELEMENTARRAYAPPLEPROC.invoke(address("glDrawElementArrayAPPLE"), mode, first, count);
  }

  public void glFogCoordf(float coord) {
    PFNGLFOGCOORDFPROC.invoke(address("glFogCoordf"), coord);
  }

  public void glFogCoordd(double coord) {
    PFNGLFOGCOORDDPROC.invoke(address("glFogCoordd"), coord);
  }

  public void glBeginPerfMonitorAMD(int monitor) {
    PFNGLBEGINPERFMONITORAMDPROC.invoke(address("glBeginPerfMonitorAMD"), monitor);
  }

  public void glBlendFuncSeparateiEXT(int buf, int srcRGB, int dstRGB, int srcAlpha, int dstAlpha) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFogCoorddEXT(double coord) {
    PFNGLFOGCOORDDEXTPROC.invoke(address("glFogCoorddEXT"), coord);
  }

  public void glGetOcclusionQueryivNV(int id, int pname, MemorySegment params) {
    PFNGLGETOCCLUSIONQUERYIVNVPROC.invoke(address("glGetOcclusionQueryivNV"), id, pname, params);
  }

  public void glFragmentLightModelivSGIX(int pname, MemorySegment params) {
    PFNGLFRAGMENTLIGHTMODELIVSGIXPROC.invoke(address("glFragmentLightModelivSGIX"), pname, params);
  }

  public void glGetFragmentMaterialivSGIX(int face, int pname, MemorySegment params) {
    PFNGLGETFRAGMENTMATERIALIVSGIXPROC.invoke(address("glGetFragmentMaterialivSGIX"), face, pname, params);
  }

  public void glDrawElementsInstancedEXT(int mode, int count, int type, MemorySegment indices, int primcount) {
    PFNGLDRAWELEMENTSINSTANCEDEXTPROC.invoke(address("glDrawElementsInstancedEXT"), mode, count, type, indices, primcount);
  }

  public void glVertexBlendEnviATI(int pname, int param) {
    PFNGLVERTEXBLENDENVIATIPROC.invoke(address("glVertexBlendEnviATI"), pname, param);
  }

  public void glClampColorARB(int target, int clamp) {
    PFNGLCLAMPCOLORARBPROC.invoke(address("glClampColorARB"), target, clamp);
  }

  public void glTexCoord2fVertex3fSUN(float s, float t, float x, float y, float z) {
    PFNGLTEXCOORD2FVERTEX3FSUNPROC.invoke(address("glTexCoord2fVertex3fSUN"), s, t, x, y, z);
  }

  public void glCreatePerfQueryINTEL(int queryId, MemorySegment queryHandle) {
    PFNGLCREATEPERFQUERYINTELPROC.invoke(address("glCreatePerfQueryINTEL"), queryId, queryHandle);
  }

  public void glGetQueryObjectivARB(int id, int pname, MemorySegment params) {
    PFNGLGETQUERYOBJECTIVARBPROC.invoke(address("glGetQueryObjectivARB"), id, pname, params);
  }

  public void glUniform3ui64vARB(int location, int count, MemorySegment value) {
    PFNGLUNIFORM3UI64VARBPROC.invoke(address("glUniform3ui64vARB"), location, count, value);
  }

  public void glGetHistogramParameterivEXT(int target, int pname, MemorySegment params) {
    PFNGLGETHISTOGRAMPARAMETERIVEXTPROC.invoke(address("glGetHistogramParameterivEXT"), target, pname, params);
  }

  public void glGetMapAttribParameterivNV(int target, int index, int pname, MemorySegment params) {
    PFNGLGETMAPATTRIBPARAMETERIVNVPROC.invoke(address("glGetMapAttribParameterivNV"), target, index, pname, params);
  }

  public void glProgramUniform4ui64vNV(int program, int location, int count, MemorySegment value) {
    PFNGLPROGRAMUNIFORM4UI64VNVPROC.invoke(address("glProgramUniform4ui64vNV"), program, location, count, value);
  }

  public void glViewportIndexedfvOES(int index, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniformMatrix3x2fv(int program, int location, int count, byte transpose, MemorySegment value) {
    PFNGLPROGRAMUNIFORMMATRIX3X2FVPROC.invoke(address("glProgramUniformMatrix3x2fv"), program, location, count, transpose, value);
  }

  public void glGetPathTexGenivNV(int texCoordSet, int pname, MemorySegment value) {
    PFNGLGETPATHTEXGENIVNVPROC.invoke(address("glGetPathTexGenivNV"), texCoordSet, pname, value);
  }

  public void glBufferPageCommitmentARB(int target, long offset, long size, byte commit) {
    PFNGLBUFFERPAGECOMMITMENTARBPROC.invoke(address("glBufferPageCommitmentARB"), target, offset, size, commit);
  }

  public void glNormal3xOES(int nx, int ny, int nz) {
    PFNGLNORMAL3XOESPROC.invoke(address("glNormal3xOES"), nx, ny, nz);
  }

  public void glBeginQueryARB(int target, int id) {
    PFNGLBEGINQUERYARBPROC.invoke(address("glBeginQueryARB"), target, id);
  }

  public void glVertexArrayIndexOffsetEXT(int vaobj, int buffer, int type, int stride, long offset) {
    PFNGLVERTEXARRAYINDEXOFFSETEXTPROC.invoke(address("glVertexArrayIndexOffsetEXT"), vaobj, buffer, type, stride, offset);
  }

  public void glExtGetTexSubImageQCOM(int target, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int format, int type, MemorySegment texels) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGenTransformFeedbacksNV(int n, MemorySegment ids) {
    PFNGLGENTRANSFORMFEEDBACKSNVPROC.invoke(address("glGenTransformFeedbacksNV"), n, ids);
  }

  public void glImportSemaphoreWin32HandleEXT(int semaphore, int handleType, MemorySegment handle) {
    PFNGLIMPORTSEMAPHOREWIN32HANDLEEXTPROC.invoke(address("glImportSemaphoreWin32HandleEXT"), semaphore, handleType, handle);
  }

  public void glBindVertexBuffer(int bindingindex, int buffer, long offset, int stride) {
    PFNGLBINDVERTEXBUFFERPROC.invoke(address("glBindVertexBuffer"), bindingindex, buffer, offset, stride);
  }

  public void glSecondaryColor3fEXT(float red, float green, float blue) {
    PFNGLSECONDARYCOLOR3FEXTPROC.invoke(address("glSecondaryColor3fEXT"), red, green, blue);
  }

  public void glColorSubTableEXT(int target, int start, int count, int format, int type, MemorySegment data) {
    PFNGLCOLORSUBTABLEEXTPROC.invoke(address("glColorSubTableEXT"), target, start, count, format, type, data);
  }

  public void glGetVertexArrayIntegervEXT(int vaobj, int pname, MemorySegment param) {
    PFNGLGETVERTEXARRAYINTEGERVEXTPROC.invoke(address("glGetVertexArrayIntegervEXT"), vaobj, pname, param);
  }

  public void glSecondaryColorP3ui(int type, int color) {
    PFNGLSECONDARYCOLORP3UIPROC.invoke(address("glSecondaryColorP3ui"), type, color);
  }

  public void glColorMaskiOES(int index, byte r, byte g, byte b, byte a) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniform2dv(int program, int location, int count, MemorySegment value) {
    PFNGLPROGRAMUNIFORM2DVPROC.invoke(address("glProgramUniform2dv"), program, location, count, value);
  }

  public void glGetPerfMonitorGroupsAMD(MemorySegment numGroups, int groupsSize, MemorySegment groups) {
    PFNGLGETPERFMONITORGROUPSAMDPROC.invoke(address("glGetPerfMonitorGroupsAMD"), numGroups, groupsSize, groups);
  }

  public void glIndexFormatNV(int type, int stride) {
    PFNGLINDEXFORMATNVPROC.invoke(address("glIndexFormatNV"), type, stride);
  }

  public void glUniform3uiEXT(int location, int v0, int v1, int v2) {
    PFNGLUNIFORM3UIEXTPROC.invoke(address("glUniform3uiEXT"), location, v0, v1, v2);
  }

  public void glCopyTexSubImage2DEXT(int target, int level, int xoffset, int yoffset, int x, int y, int width, int height) {
    PFNGLCOPYTEXSUBIMAGE2DEXTPROC.invoke(address("glCopyTexSubImage2DEXT"), target, level, xoffset, yoffset, x, y, width, height);
  }

  public void glVDPAUUnmapSurfacesNV(int numSurface, MemorySegment surfaces) {
    PFNGLVDPAUUNMAPSURFACESNVPROC.invoke(address("glVDPAUUnmapSurfacesNV"), numSurface, surfaces);
  }

  public void glVertexAttribI4uiEXT(int index, int x, int y, int z, int w) {
    PFNGLVERTEXATTRIBI4UIEXTPROC.invoke(address("glVertexAttribI4uiEXT"), index, x, y, z, w);
  }

  public void glProgramUniformMatrix3dvEXT(int program, int location, int count, byte transpose, MemorySegment value) {
    PFNGLPROGRAMUNIFORMMATRIX3DVEXTPROC.invoke(address("glProgramUniformMatrix3dvEXT"), program, location, count, transpose, value);
  }

  public void glRenderbufferStorageMultisample(int target, int samples, int internalformat, int width, int height) {
    PFNGLRENDERBUFFERSTORAGEMULTISAMPLEPROC.invoke(address("glRenderbufferStorageMultisample"), target, samples, internalformat, width, height);
  }

  public void glGetPerfMonitorCounterInfoAMD(int group, int counter, int pname, MemorySegment data) {
    PFNGLGETPERFMONITORCOUNTERINFOAMDPROC.invoke(address("glGetPerfMonitorCounterInfoAMD"), group, counter, pname, data);
  }

  public void glGetVertexAttribfvARB(int index, int pname, MemorySegment params) {
    PFNGLGETVERTEXATTRIBFVARBPROC.invoke(address("glGetVertexAttribfvARB"), index, pname, params);
  }

  public void glVertexAttrib2fARB(int index, float x, float y) {
    PFNGLVERTEXATTRIB2FARBPROC.invoke(address("glVertexAttrib2fARB"), index, x, y);
  }

  public byte glIsSampler(int sampler) {
    return PFNGLISSAMPLERPROC.invoke(address("glIsSampler"), sampler);
  }

  public void glGetQueryObjecti64v(int id, int pname, MemorySegment params) {
    PFNGLGETQUERYOBJECTI64VPROC.invoke(address("glGetQueryObjecti64v"), id, pname, params);
  }

  public void glWindowPos2fMESA(float x, float y) {
    PFNGLWINDOWPOS2FMESAPROC.invoke(address("glWindowPos2fMESA"), x, y);
  }

  public void glDeformationMap3fSGIX(int target, float u1, float u2, int ustride, int uorder, float v1, float v2, int vstride, int vorder, float w1, float w2, int wstride, int worder, MemorySegment points) {
    PFNGLDEFORMATIONMAP3FSGIXPROC.invoke(address("glDeformationMap3fSGIX"), target, u1, u2, ustride, uorder, v1, v2, vstride, vorder, w1, w2, wstride, worder, points);
  }

  public void glReplacementCodeubSUN(byte code) {
    PFNGLREPLACEMENTCODEUBSUNPROC.invoke(address("glReplacementCodeubSUN"), code);
  }

  public void glBindVertexArrayOES(int array) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetBufferSubDataARB(int target, long offset, long size, MemorySegment data) {
    PFNGLGETBUFFERSUBDATAARBPROC.invoke(address("glGetBufferSubDataARB"), target, offset, size, data);
  }

  public void glVertexAttribL2i64NV(int index, long x, long y) {
    PFNGLVERTEXATTRIBL2I64NVPROC.invoke(address("glVertexAttribL2i64NV"), index, x, y);
  }

  public void glSecondaryColor3d(double red, double green, double blue) {
    PFNGLSECONDARYCOLOR3DPROC.invoke(address("glSecondaryColor3d"), red, green, blue);
  }

  public void glTexCoord4xOES(int s, int t, int r, int q) {
    PFNGLTEXCOORD4XOESPROC.invoke(address("glTexCoord4xOES"), s, t, r, q);
  }

  public void glFramebufferFoveationConfigQCOM(int framebuffer, int numLayers, int focalPointsPerLayer, int requestedFeatures, MemorySegment providedFeatures) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glSecondaryColor3f(float red, float green, float blue) {
    PFNGLSECONDARYCOLOR3FPROC.invoke(address("glSecondaryColor3f"), red, green, blue);
  }

  public void glSecondaryColor3b(byte red, byte green, byte blue) {
    PFNGLSECONDARYCOLOR3BPROC.invoke(address("glSecondaryColor3b"), red, green, blue);
  }

  public void glSecondaryColor3i(int red, int green, int blue) {
    PFNGLSECONDARYCOLOR3IPROC.invoke(address("glSecondaryColor3i"), red, green, blue);
  }

  public void glSecondaryColor3s(short red, short green, short blue) {
    PFNGLSECONDARYCOLOR3SPROC.invoke(address("glSecondaryColor3s"), red, green, blue);
  }

  public void glDeletePathsNV(int path, int range) {
    PFNGLDELETEPATHSNVPROC.invoke(address("glDeletePathsNV"), path, range);
  }

  public void glWindowPos3sARB(short x, short y, short z) {
    PFNGLWINDOWPOS3SARBPROC.invoke(address("glWindowPos3sARB"), x, y, z);
  }

  public void glWindowPos3dvARB(MemorySegment v) {
    PFNGLWINDOWPOS3DVARBPROC.invoke(address("glWindowPos3dvARB"), v);
  }

  public void glSampleMaskIndexedNV(int index, int mask) {
    PFNGLSAMPLEMASKINDEXEDNVPROC.invoke(address("glSampleMaskIndexedNV"), index, mask);
  }

  public void glNamedBufferSubData(int buffer, long offset, long size, MemorySegment data) {
    PFNGLNAMEDBUFFERSUBDATAPROC.invoke(address("glNamedBufferSubData"), buffer, offset, size, data);
  }

  public void glGenQueriesEXT(int n, MemorySegment ids) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexCoord4hvNV(int target, MemorySegment v) {
    PFNGLMULTITEXCOORD4HVNVPROC.invoke(address("glMultiTexCoord4hvNV"), target, v);
  }

  public void glShaderBinary(int count, MemorySegment shaders, int binaryFormat, MemorySegment binary, int length) {
    PFNGLSHADERBINARYPROC.invoke(address("glShaderBinary"), count, shaders, binaryFormat, binary, length);
  }

  public void glBufferPageCommitmentMemNV(int target, long offset, long size, int memory, long memOffset, byte commit) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexCoord4bOES(byte s, byte t, byte r, byte q) {
    PFNGLTEXCOORD4BOESPROC.invoke(address("glTexCoord4bOES"), s, t, r, q);
  }

  public void glCoverageModulationNV(int components) {
    PFNGLCOVERAGEMODULATIONNVPROC.invoke(address("glCoverageModulationNV"), components);
  }

  public void glDeletePerfQueryINTEL(int queryHandle) {
    PFNGLDELETEPERFQUERYINTELPROC.invoke(address("glDeletePerfQueryINTEL"), queryHandle);
  }

  public void glGetUniformi64vARB(int program, int location, MemorySegment params) {
    PFNGLGETUNIFORMI64VARBPROC.invoke(address("glGetUniformi64vARB"), program, location, params);
  }

  public void glTexStorage3DMultisample(int target, int samples, int internalformat, int width, int height, int depth, byte fixedsamplelocations) {
    PFNGLTEXSTORAGE3DMULTISAMPLEPROC.invoke(address("glTexStorage3DMultisample"), target, samples, internalformat, width, height, depth, fixedsamplelocations);
  }

  public void glMultiModeDrawElementsIBM(MemorySegment mode, MemorySegment count, int type, MemorySegment indices, int primcount, int modestride) {
    PFNGLMULTIMODEDRAWELEMENTSIBMPROC.invoke(address("glMultiModeDrawElementsIBM"), mode, count, type, indices, primcount, modestride);
  }

  public void glTexCoord2fColor4ubVertex3fSUN(float s, float t, byte r, byte g, byte b, byte a, float x, float y, float z) {
    PFNGLTEXCOORD2FCOLOR4UBVERTEX3FSUNPROC.invoke(address("glTexCoord2fColor4ubVertex3fSUN"), s, t, r, g, b, a, x, y, z);
  }

  public void glUniform4i64NV(int location, long x, long y, long z, long w) {
    PFNGLUNIFORM4I64NVPROC.invoke(address("glUniform4i64NV"), location, x, y, z, w);
  }

  public void glFinalCombinerInputNV(int variable, int input, int mapping, int componentUsage) {
    PFNGLFINALCOMBINERINPUTNVPROC.invoke(address("glFinalCombinerInputNV"), variable, input, mapping, componentUsage);
  }

  public void glMultiDrawElements(int mode, MemorySegment count, int type, MemorySegment indices, int drawcount) {
    PFNGLMULTIDRAWELEMENTSPROC.invoke(address("glMultiDrawElements"), mode, count, type, indices, drawcount);
  }

  public void glProgramUniform1iEXT(int program, int location, int v0) {
    PFNGLPROGRAMUNIFORM1IEXTPROC.invoke(address("glProgramUniform1iEXT"), program, location, v0);
  }

  public void glShadingRateQCOM(int rate) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGlobalAlphaFactordSUN(double factor) {
    PFNGLGLOBALALPHAFACTORDSUNPROC.invoke(address("glGlobalAlphaFactordSUN"), factor);
  }

  public void glGetSamplerParameterIuiv(int sampler, int pname, MemorySegment params) {
    PFNGLGETSAMPLERPARAMETERIUIVPROC.invoke(address("glGetSamplerParameterIuiv"), sampler, pname, params);
  }

  public void glFinishTextureSUNX() {
    PFNGLFINISHTEXTURESUNXPROC.invoke(address("glFinishTextureSUNX"));
  }

  public void glVertexAttrib3sARB(int index, short x, short y, short z) {
    PFNGLVERTEXATTRIB3SARBPROC.invoke(address("glVertexAttrib3sARB"), index, x, y, z);
  }

  public void glFramebufferRenderbufferOES(int target, int attachment, int renderbuffertarget, int renderbuffer) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glNormalStream3fATI(int stream, float nx, float ny, float nz) {
    PFNGLNORMALSTREAM3FATIPROC.invoke(address("glNormalStream3fATI"), stream, nx, ny, nz);
  }

  public void glPathParameteriNV(int path, int pname, int value) {
    PFNGLPATHPARAMETERINVPROC.invoke(address("glPathParameteriNV"), path, pname, value);
  }

  public void glNamedBufferStorage(int buffer, long size, MemorySegment data, int flags) {
    PFNGLNAMEDBUFFERSTORAGEPROC.invoke(address("glNamedBufferStorage"), buffer, size, data, flags);
  }

  public void glBindBufferOffsetNV(int target, int index, int buffer, long offset) {
    PFNGLBINDBUFFEROFFSETNVPROC.invoke(address("glBindBufferOffsetNV"), target, index, buffer, offset);
  }

  public void glVertexAttribFormatNV(int index, int size, int type, byte normalized, int stride) {
    PFNGLVERTEXATTRIBFORMATNVPROC.invoke(address("glVertexAttribFormatNV"), index, size, type, normalized, stride);
  }

  public void glBlendFuncSeparate(int sfactorRGB, int dfactorRGB, int sfactorAlpha, int dfactorAlpha) {
    PFNGLBLENDFUNCSEPARATEPROC.invoke(address("glBlendFuncSeparate"), sfactorRGB, dfactorRGB, sfactorAlpha, dfactorAlpha);
  }

  public void glMultiDrawElementsIndirectCountARB(int mode, int type, MemorySegment indirect, long drawcount, int maxdrawcount, int stride) {
    PFNGLMULTIDRAWELEMENTSINDIRECTCOUNTARBPROC.invoke(address("glMultiDrawElementsIndirectCountARB"), mode, type, indirect, drawcount, maxdrawcount, stride);
  }

  public void glBufferData(int target, long size, MemorySegment data, int usage) {
    PFNGLBUFFERDATAPROC.invoke(address("glBufferData"), target, size, data, usage);
  }

  public void glMapControlPointsNV(int target, int index, int type, int ustride, int vstride, int uorder, int vorder, byte packed, MemorySegment points) {
    PFNGLMAPCONTROLPOINTSNVPROC.invoke(address("glMapControlPointsNV"), target, index, type, ustride, vstride, uorder, vorder, packed, points);
  }

  public void glTextureSubImage3DEXT(int texture, int target, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int format, int type, MemorySegment pixels) {
    PFNGLTEXTURESUBIMAGE3DEXTPROC.invoke(address("glTextureSubImage3DEXT"), texture, target, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels);
  }

  public void glDetachShader(int program, int shader) {
    PFNGLDETACHSHADERPROC.invoke(address("glDetachShader"), program, shader);
  }

  public void glTexBuffer(int target, int internalformat, int buffer) {
    PFNGLTEXBUFFERPROC.invoke(address("glTexBuffer"), target, internalformat, buffer);
  }

  public void glGetPointeri_vEXT(int pname, int index, MemorySegment params) {
    PFNGLGETPOINTERI_VEXTPROC.invoke(address("glGetPointeri_vEXT"), pname, index, params);
  }

  public void glProgramUniform2iv(int program, int location, int count, MemorySegment value) {
    PFNGLPROGRAMUNIFORM2IVPROC.invoke(address("glProgramUniform2iv"), program, location, count, value);
  }

  public byte glIsEnabledIndexedEXT(int target, int index) {
    return PFNGLISENABLEDINDEXEDEXTPROC.invoke(address("glIsEnabledIndexedEXT"), target, index);
  }

  public void glCopyColorTableSGI(int target, int internalformat, int x, int y, int width) {
    PFNGLCOPYCOLORTABLESGIPROC.invoke(address("glCopyColorTableSGI"), target, internalformat, x, y, width);
  }

  public byte glIsTextureHandleResidentNV(long handle) {
    return PFNGLISTEXTUREHANDLERESIDENTNVPROC.invoke(address("glIsTextureHandleResidentNV"), handle);
  }

  public void glInvalidateBufferSubData(int buffer, long offset, long length) {
    PFNGLINVALIDATEBUFFERSUBDATAPROC.invoke(address("glInvalidateBufferSubData"), buffer, offset, length);
  }

  public int glGenAsyncMarkersSGIX(int range) {
    return PFNGLGENASYNCMARKERSSGIXPROC.invoke(address("glGenAsyncMarkersSGIX"), range);
  }

  public void glGetProgramInfoLog(int program, int bufSize, MemorySegment length, MemorySegment infoLog) {
    PFNGLGETPROGRAMINFOLOGPROC.invoke(address("glGetProgramInfoLog"), program, bufSize, length, infoLog);
  }

  public void glMatrixMultTranspose3x3fNV(int matrixMode, MemorySegment m) {
    PFNGLMATRIXMULTTRANSPOSE3X3FNVPROC.invoke(address("glMatrixMultTranspose3x3fNV"), matrixMode, m);
  }

  public void glFragmentMaterialivSGIX(int face, int pname, MemorySegment params) {
    PFNGLFRAGMENTMATERIALIVSGIXPROC.invoke(address("glFragmentMaterialivSGIX"), face, pname, params);
  }

  public void glMatrixLoadTranspose3x3fNV(int matrixMode, MemorySegment m) {
    PFNGLMATRIXLOADTRANSPOSE3X3FNVPROC.invoke(address("glMatrixLoadTranspose3x3fNV"), matrixMode, m);
  }

  public byte glPointAlongPathNV(int path, int startSegment, int numSegments, float distance, MemorySegment x, MemorySegment y, MemorySegment tangentX, MemorySegment tangentY) {
    return PFNGLPOINTALONGPATHNVPROC.invoke(address("glPointAlongPathNV"), path, startSegment, numSegments, distance, x, y, tangentX, tangentY);
  }

  public void glGetVertexArrayIndexed64iv(int vaobj, int index, int pname, MemorySegment param) {
    PFNGLGETVERTEXARRAYINDEXED64IVPROC.invoke(address("glGetVertexArrayIndexed64iv"), vaobj, index, pname, param);
  }

  public void glProgramUniform2fv(int program, int location, int count, MemorySegment value) {
    PFNGLPROGRAMUNIFORM2FVPROC.invoke(address("glProgramUniform2fv"), program, location, count, value);
  }

  public void glGetFramebufferAttachmentParameterivEXT(int target, int attachment, int pname, MemorySegment params) {
    PFNGLGETFRAMEBUFFERATTACHMENTPARAMETERIVEXTPROC.invoke(address("glGetFramebufferAttachmentParameterivEXT"), target, attachment, pname, params);
  }

  public void glVariantdvEXT(int id, MemorySegment addr) {
    PFNGLVARIANTDVEXTPROC.invoke(address("glVariantdvEXT"), id, addr);
  }

  public void glTexImage2DMultisampleCoverageNV(int target, int coverageSamples, int colorSamples, int internalFormat, int width, int height, byte fixedSampleLocations) {
    PFNGLTEXIMAGE2DMULTISAMPLECOVERAGENVPROC.invoke(address("glTexImage2DMultisampleCoverageNV"), target, coverageSamples, colorSamples, internalFormat, width, height, fixedSampleLocations);
  }

  public void glVertexAttribI2uiv(int index, MemorySegment v) {
    PFNGLVERTEXATTRIBI2UIVPROC.invoke(address("glVertexAttribI2uiv"), index, v);
  }

  public void glNamedRenderbufferStorageMultisampleAdvancedAMD(int renderbuffer, int samples, int storageSamples, int internalformat, int width, int height) {
    PFNGLNAMEDRENDERBUFFERSTORAGEMULTISAMPLEADVANCEDAMDPROC.invoke(address("glNamedRenderbufferStorageMultisampleAdvancedAMD"), renderbuffer, samples, storageSamples, internalformat, width, height);
  }

  public void glEnableVariantClientStateEXT(int id) {
    PFNGLENABLEVARIANTCLIENTSTATEEXTPROC.invoke(address("glEnableVariantClientStateEXT"), id);
  }

  public void glBufferStorageExternalEXT(int target, long offset, long size, MemorySegment clientBuffer, int flags) {
    PFNGLBUFFERSTORAGEEXTERNALEXTPROC.invoke(address("glBufferStorageExternalEXT"), target, offset, size, clientBuffer, flags);
  }

  public void glGetBufferPointervOES(int target, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBlendEquationSeparateOES(int modeRGB, int modeAlpha) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDrawBuffersNV(int n, MemorySegment bufs) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetnColorTableARB(int target, int format, int type, int bufSize, MemorySegment table) {
    PFNGLGETNCOLORTABLEARBPROC.invoke(address("glGetnColorTableARB"), target, format, type, bufSize, table);
  }

  public void glDrawTransformFeedback(int mode, int id) {
    PFNGLDRAWTRANSFORMFEEDBACKPROC.invoke(address("glDrawTransformFeedback"), mode, id);
  }

  public void glUniform4ui(int location, int v0, int v1, int v2, int v3) {
    PFNGLUNIFORM4UIPROC.invoke(address("glUniform4ui"), location, v0, v1, v2, v3);
  }

  public void glUniform1ui64NV(int location, long x) {
    PFNGLUNIFORM1UI64NVPROC.invoke(address("glUniform1ui64NV"), location, x);
  }

  public void glPathSubCommandsNV(int path, int commandStart, int commandsToDelete, int numCommands, MemorySegment commands, int numCoords, int coordType, MemorySegment coords) {
    PFNGLPATHSUBCOMMANDSNVPROC.invoke(address("glPathSubCommandsNV"), path, commandStart, commandsToDelete, numCommands, commands, numCoords, coordType, coords);
  }

  public void glMultiTexParameterIivEXT(int texunit, int target, int pname, MemorySegment params) {
    PFNGLMULTITEXPARAMETERIIVEXTPROC.invoke(address("glMultiTexParameterIivEXT"), texunit, target, pname, params);
  }

  public void glTextureImage2DMultisampleCoverageNV(int texture, int target, int coverageSamples, int colorSamples, int internalFormat, int width, int height, byte fixedSampleLocations) {
    PFNGLTEXTUREIMAGE2DMULTISAMPLECOVERAGENVPROC.invoke(address("glTextureImage2DMultisampleCoverageNV"), texture, target, coverageSamples, colorSamples, internalFormat, width, height, fixedSampleLocations);
  }

  public void glWeightdvARB(int size, MemorySegment weights) {
    PFNGLWEIGHTDVARBPROC.invoke(address("glWeightdvARB"), size, weights);
  }

  public void glCopyBufferSubDataNV(int readTarget, int writeTarget, long readOffset, long writeOffset, long size) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBufferStorageMemEXT(int target, long size, int memory, long offset) {
    PFNGLBUFFERSTORAGEMEMEXTPROC.invoke(address("glBufferStorageMemEXT"), target, size, memory, offset);
  }

  public void glPointParameteriv(int pname, MemorySegment params) {
    PFNGLPOINTPARAMETERIVPROC.invoke(address("glPointParameteriv"), pname, params);
  }

  public void glBeginFragmentShaderATI() {
    PFNGLBEGINFRAGMENTSHADERATIPROC.invoke(address("glBeginFragmentShaderATI"));
  }

  public void glDrawElementsInstancedBaseInstanceEXT(int mode, int count, int type, MemorySegment indices, int instancecount, int baseinstance) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniform3ui64vARB(int program, int location, int count, MemorySegment value) {
    PFNGLPROGRAMUNIFORM3UI64VARBPROC.invoke(address("glProgramUniform3ui64vARB"), program, location, count, value);
  }

  public void glVertexAttribI4uiv(int index, MemorySegment v) {
    PFNGLVERTEXATTRIBI4UIVPROC.invoke(address("glVertexAttribI4uiv"), index, v);
  }

  public void glGetProgramLocalParameterIuivNV(int target, int index, MemorySegment params) {
    PFNGLGETPROGRAMLOCALPARAMETERIUIVNVPROC.invoke(address("glGetProgramLocalParameterIuivNV"), target, index, params);
  }

  public void glVertexAttrib2dvARB(int index, MemorySegment v) {
    PFNGLVERTEXATTRIB2DVARBPROC.invoke(address("glVertexAttrib2dvARB"), index, v);
  }

  public void glCompressedMultiTexImage3DEXT(int texunit, int target, int level, int internalformat, int width, int height, int depth, int border, int imageSize, MemorySegment bits) {
    PFNGLCOMPRESSEDMULTITEXIMAGE3DEXTPROC.invoke(address("glCompressedMultiTexImage3DEXT"), texunit, target, level, internalformat, width, height, depth, border, imageSize, bits);
  }

  public void glNormalStream3iATI(int stream, int nx, int ny, int nz) {
    PFNGLNORMALSTREAM3IATIPROC.invoke(address("glNormalStream3iATI"), stream, nx, ny, nz);
  }

  public void glPushDebugGroup(int source, int id, int length, MemorySegment message) {
    PFNGLPUSHDEBUGGROUPPROC.invoke(address("glPushDebugGroup"), source, id, length, message);
  }

  public void glMultiDrawArraysIndirectBindlessCountNV(int mode, MemorySegment indirect, int drawCount, int maxDrawCount, int stride, int vertexBufferCount) {
    PFNGLMULTIDRAWARRAYSINDIRECTBINDLESSCOUNTNVPROC.invoke(address("glMultiDrawArraysIndirectBindlessCountNV"), mode, indirect, drawCount, maxDrawCount, stride, vertexBufferCount);
  }

  public void glGetObjectParameterivAPPLE(int objectType, int name, int pname, MemorySegment params) {
    PFNGLGETOBJECTPARAMETERIVAPPLEPROC.invoke(address("glGetObjectParameterivAPPLE"), objectType, name, pname, params);
  }

  public void glTexStorageAttribs2DEXT(int target, int levels, int internalformat, int width, int height, int attrib_list) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribLPointerEXT(int index, int size, int type, int stride, MemorySegment pointer) {
    PFNGLVERTEXATTRIBLPOINTEREXTPROC.invoke(address("glVertexAttribLPointerEXT"), index, size, type, stride, pointer);
  }

  public long glVDPAURegisterVideoSurfaceWithPictureStructureNV(MemorySegment vdpSurface, int target, int numTextureNames, MemorySegment textureNames, byte isFrameStructure) {
    return PFNGLVDPAUREGISTERVIDEOSURFACEWITHPICTURESTRUCTURENVPROC.invoke(address("glVDPAURegisterVideoSurfaceWithPictureStructureNV"), vdpSurface, target, numTextureNames, textureNames, isFrameStructure);
  }

  public void glAlphaFuncx(int func, int ref) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetConvolutionParameterxvOES(int target, int pname, MemorySegment params) {
    PFNGLGETCONVOLUTIONPARAMETERXVOESPROC.invoke(address("glGetConvolutionParameterxvOES"), target, pname, params);
  }

  public void glTbufferMask3DFX(int mask) {
    PFNGLTBUFFERMASK3DFXPROC.invoke(address("glTbufferMask3DFX"), mask);
  }

  public void glUniformHandleui64vIMG(int location, int count, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetCoverageModulationTableNV(int bufSize, MemorySegment v) {
    PFNGLGETCOVERAGEMODULATIONTABLENVPROC.invoke(address("glGetCoverageModulationTableNV"), bufSize, v);
  }

  public void glInvalidateNamedFramebufferData(int framebuffer, int numAttachments, MemorySegment attachments) {
    PFNGLINVALIDATENAMEDFRAMEBUFFERDATAPROC.invoke(address("glInvalidateNamedFramebufferData"), framebuffer, numAttachments, attachments);
  }

  public void glColor4ubVertex3fSUN(byte r, byte g, byte b, byte a, float x, float y, float z) {
    PFNGLCOLOR4UBVERTEX3FSUNPROC.invoke(address("glColor4ubVertex3fSUN"), r, g, b, a, x, y, z);
  }

  public void glVertexAttribPointer(int index, int size, int type, byte normalized, int stride, MemorySegment pointer) {
    PFNGLVERTEXATTRIBPOINTERPROC.invoke(address("glVertexAttribPointer"), index, size, type, normalized, stride, pointer);
  }

  public void glCoverageMaskNV(byte mask) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFragmentLightiSGIX(int light, int pname, int param) {
    PFNGLFRAGMENTLIGHTISGIXPROC.invoke(address("glFragmentLightiSGIX"), light, pname, param);
  }

  public void glBlendFunciARB(int buf, int src, int dst) {
    PFNGLBLENDFUNCIARBPROC.invoke(address("glBlendFunciARB"), buf, src, dst);
  }

  public void glConvolutionParameterivEXT(int target, int pname, MemorySegment params) {
    PFNGLCONVOLUTIONPARAMETERIVEXTPROC.invoke(address("glConvolutionParameterivEXT"), target, pname, params);
  }

  public void glFramebufferRenderbufferEXT(int target, int attachment, int renderbuffertarget, int renderbuffer) {
    PFNGLFRAMEBUFFERRENDERBUFFEREXTPROC.invoke(address("glFramebufferRenderbufferEXT"), target, attachment, renderbuffertarget, renderbuffer);
  }

  public void glGetUnsignedBytei_vEXT(int target, int index, MemorySegment data) {
    PFNGLGETUNSIGNEDBYTEI_VEXTPROC.invoke(address("glGetUnsignedBytei_vEXT"), target, index, data);
  }

  public void glNormal3hvNV(MemorySegment v) {
    PFNGLNORMAL3HVNVPROC.invoke(address("glNormal3hvNV"), v);
  }

  public void glFramebufferTextureLayerEXT(int target, int attachment, int texture, int level, int layer) {
    PFNGLFRAMEBUFFERTEXTURELAYEREXTPROC.invoke(address("glFramebufferTextureLayerEXT"), target, attachment, texture, level, layer);
  }

  public void glBlendEquationOES(int mode) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGenerateMipmapOES(int target) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniform4uiv(int location, int count, MemorySegment value) {
    PFNGLUNIFORM4UIVPROC.invoke(address("glUniform4uiv"), location, count, value);
  }

  public void glDeleteQueriesARB(int n, MemorySegment ids) {
    PFNGLDELETEQUERIESARBPROC.invoke(address("glDeleteQueriesARB"), n, ids);
  }

  public void glNormalP3uiv(int type, MemorySegment coords) {
    PFNGLNORMALP3UIVPROC.invoke(address("glNormalP3uiv"), type, coords);
  }

  public void glVertexAttribI4ubvEXT(int index, MemorySegment v) {
    PFNGLVERTEXATTRIBI4UBVEXTPROC.invoke(address("glVertexAttribI4ubvEXT"), index, v);
  }

  public void glBindBufferRangeEXT(int target, int index, int buffer, long offset, long size) {
    PFNGLBINDBUFFERRANGEEXTPROC.invoke(address("glBindBufferRangeEXT"), target, index, buffer, offset, size);
  }

  public void glVertexAttrib2hNV(int index, short x, short y) {
    PFNGLVERTEXATTRIB2HNVPROC.invoke(address("glVertexAttrib2hNV"), index, x, y);
  }

  public void glPointParameterfv(int pname, MemorySegment params) {
    PFNGLPOINTPARAMETERFVPROC.invoke(address("glPointParameterfv"), pname, params);
  }

  public void glDrawCommandsStatesAddressNV(MemorySegment indirects, MemorySegment sizes, MemorySegment states, MemorySegment fbos, int count) {
    PFNGLDRAWCOMMANDSSTATESADDRESSNVPROC.invoke(address("glDrawCommandsStatesAddressNV"), indirects, sizes, states, fbos, count);
  }

  public void glCoverageOperationNV(int operation) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBindImageTextures(int first, int count, MemorySegment textures) {
    PFNGLBINDIMAGETEXTURESPROC.invoke(address("glBindImageTextures"), first, count, textures);
  }

  public void glNamedRenderbufferStorageMultisampleCoverageEXT(int renderbuffer, int coverageSamples, int colorSamples, int internalformat, int width, int height) {
    PFNGLNAMEDRENDERBUFFERSTORAGEMULTISAMPLECOVERAGEEXTPROC.invoke(address("glNamedRenderbufferStorageMultisampleCoverageEXT"), renderbuffer, coverageSamples, colorSamples, internalformat, width, height);
  }

  public void glMultiTexEnvfvEXT(int texunit, int target, int pname, MemorySegment params) {
    PFNGLMULTITEXENVFVEXTPROC.invoke(address("glMultiTexEnvfvEXT"), texunit, target, pname, params);
  }

  public void glUniform3uivEXT(int location, int count, MemorySegment value) {
    PFNGLUNIFORM3UIVEXTPROC.invoke(address("glUniform3uivEXT"), location, count, value);
  }

  public void glTagSampleBufferSGIX() {
    PFNGLTAGSAMPLEBUFFERSGIXPROC.invoke(address("glTagSampleBufferSGIX"));
  }

  public void glUniform3iv(int location, int count, MemorySegment value) {
    PFNGLUNIFORM3IVPROC.invoke(address("glUniform3iv"), location, count, value);
  }

  public void glProgramUniform1dEXT(int program, int location, double x) {
    PFNGLPROGRAMUNIFORM1DEXTPROC.invoke(address("glProgramUniform1dEXT"), program, location, x);
  }

  public void glClipPlanefIMG(int p, MemorySegment eqn) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribL1ui64ARB(int index, long x) {
    PFNGLVERTEXATTRIBL1UI64ARBPROC.invoke(address("glVertexAttribL1ui64ARB"), index, x);
  }

  public void glIndexFuncEXT(int func, float ref) {
    PFNGLINDEXFUNCEXTPROC.invoke(address("glIndexFuncEXT"), func, ref);
  }

  public void glUniform3i64ARB(int location, long x, long y, long z) {
    PFNGLUNIFORM3I64ARBPROC.invoke(address("glUniform3i64ARB"), location, x, y, z);
  }

  public void glGetnMapfvARB(int target, int query, int bufSize, MemorySegment v) {
    PFNGLGETNMAPFVARBPROC.invoke(address("glGetnMapfvARB"), target, query, bufSize, v);
  }

  public void glClearBufferSubData(int target, int internalformat, long offset, long size, int format, int type, MemorySegment data) {
    PFNGLCLEARBUFFERSUBDATAPROC.invoke(address("glClearBufferSubData"), target, internalformat, offset, size, format, type, data);
  }

  public void glCompressedTexImage3DOES(int target, int level, int internalformat, int width, int height, int depth, int border, int imageSize, MemorySegment data) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetnMinmaxARB(int target, byte reset, int format, int type, int bufSize, MemorySegment values) {
    PFNGLGETNMINMAXARBPROC.invoke(address("glGetnMinmaxARB"), target, reset, format, type, bufSize, values);
  }

  public void glGetQueryObjectui64vEXT(int id, int pname, MemorySegment params) {
    PFNGLGETQUERYOBJECTUI64VEXTPROC.invoke(address("glGetQueryObjectui64vEXT"), id, pname, params);
  }

  public void glGetMultiTexGenivEXT(int texunit, int coord, int pname, MemorySegment params) {
    PFNGLGETMULTITEXGENIVEXTPROC.invoke(address("glGetMultiTexGenivEXT"), texunit, coord, pname, params);
  }

  public void glProvokingVertex(int mode) {
    PFNGLPROVOKINGVERTEXPROC.invoke(address("glProvokingVertex"), mode);
  }

  public void glGetTexLevelParameterxvOES(int target, int level, int pname, MemorySegment params) {
    PFNGLGETTEXLEVELPARAMETERXVOESPROC.invoke(address("glGetTexLevelParameterxvOES"), target, level, pname, params);
  }

  public byte glIsVertexAttribEnabledAPPLE(int index, int pname) {
    return PFNGLISVERTEXATTRIBENABLEDAPPLEPROC.invoke(address("glIsVertexAttribEnabledAPPLE"), index, pname);
  }

  public void glEndPerfMonitorAMD(int monitor) {
    PFNGLENDPERFMONITORAMDPROC.invoke(address("glEndPerfMonitorAMD"), monitor);
  }

  public void glGetNamedFramebufferParameterfvAMD(int framebuffer, int pname, int numsamples, int pixelindex, int size, MemorySegment values) {
    PFNGLGETNAMEDFRAMEBUFFERPARAMETERFVAMDPROC.invoke(address("glGetNamedFramebufferParameterfvAMD"), framebuffer, pname, numsamples, pixelindex, size, values);
  }

  public void glDrawRangeElementArrayATI(int mode, int start, int end, int count) {
    PFNGLDRAWRANGEELEMENTARRAYATIPROC.invoke(address("glDrawRangeElementArrayATI"), mode, start, end, count);
  }

  public void glEGLImageTargetRenderbufferStorageOES(int target, MemorySegment image) {
    PFNGLEGLIMAGETARGETRENDERBUFFERSTORAGEOESPROC.invoke(address("glEGLImageTargetRenderbufferStorageOES"), target, image);
  }

  public void glGetVariantFloatvEXT(int id, int value, MemorySegment data) {
    PFNGLGETVARIANTFLOATVEXTPROC.invoke(address("glGetVariantFloatvEXT"), id, value, data);
  }

  public void glBlendEquationSeparateIndexedAMD(int buf, int modeRGB, int modeAlpha) {
    PFNGLBLENDEQUATIONSEPARATEINDEXEDAMDPROC.invoke(address("glBlendEquationSeparateIndexedAMD"), buf, modeRGB, modeAlpha);
  }

  public void glPNTrianglesiATI(int pname, int param) {
    PFNGLPNTRIANGLESIATIPROC.invoke(address("glPNTrianglesiATI"), pname, param);
  }

  public void glFragmentMaterialfvSGIX(int face, int pname, MemorySegment params) {
    PFNGLFRAGMENTMATERIALFVSGIXPROC.invoke(address("glFragmentMaterialfvSGIX"), face, pname, params);
  }

  public void glStencilFuncSeparateATI(int frontfunc, int backfunc, int ref, int mask) {
    PFNGLSTENCILFUNCSEPARATEATIPROC.invoke(address("glStencilFuncSeparateATI"), frontfunc, backfunc, ref, mask);
  }

  public void glCreateStatesNV(int n, MemorySegment states) {
    PFNGLCREATESTATESNVPROC.invoke(address("glCreateStatesNV"), n, states);
  }

  public void glTextureLightEXT(int pname) {
    PFNGLTEXTURELIGHTEXTPROC.invoke(address("glTextureLightEXT"), pname);
  }

  public void glMatrixIndexPointerARB(int size, int type, int stride, MemorySegment pointer) {
    PFNGLMATRIXINDEXPOINTERARBPROC.invoke(address("glMatrixIndexPointerARB"), size, type, stride, pointer);
  }

  public void glTexCoord4fVertex4fSUN(float s, float t, float p, float q, float x, float y, float z, float w) {
    PFNGLTEXCOORD4FVERTEX4FSUNPROC.invoke(address("glTexCoord4fVertex4fSUN"), s, t, p, q, x, y, z, w);
  }

  public void glPixelMapx(int map, int size, MemorySegment values) {
    PFNGLPIXELMAPXPROC.invoke(address("glPixelMapx"), map, size, values);
  }

  public void glNormalPointerListIBM(int type, int stride, MemorySegment pointer, int ptrstride) {
    PFNGLNORMALPOINTERLISTIBMPROC.invoke(address("glNormalPointerListIBM"), type, stride, pointer, ptrstride);
  }

  public byte glIsEnablediNV(int target, int index) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniform2fARB(int location, float v0, float v1) {
    PFNGLUNIFORM2FARBPROC.invoke(address("glUniform2fARB"), location, v0, v1);
  }

  public void glVariantubvEXT(int id, MemorySegment addr) {
    PFNGLVARIANTUBVEXTPROC.invoke(address("glVariantubvEXT"), id, addr);
  }

  public void glStringMarkerGREMEDY(int len, MemorySegment string) {
    PFNGLSTRINGMARKERGREMEDYPROC.invoke(address("glStringMarkerGREMEDY"), len, string);
  }

  public void glSignalVkSemaphoreNV(long vkSemaphore) {
    PFNGLSIGNALVKSEMAPHORENVPROC.invoke(address("glSignalVkSemaphoreNV"), vkSemaphore);
  }

  public void glDrawTransformFeedbackInstanced(int mode, int id, int instancecount) {
    PFNGLDRAWTRANSFORMFEEDBACKINSTANCEDPROC.invoke(address("glDrawTransformFeedbackInstanced"), mode, id, instancecount);
  }

  public void glScissorIndexedOES(int index, int left, int bottom, int width, int height) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetTextureLevelParameterfv(int texture, int level, int pname, MemorySegment params) {
    PFNGLGETTEXTURELEVELPARAMETERFVPROC.invoke(address("glGetTextureLevelParameterfv"), texture, level, pname, params);
  }

  public void glVideoCaptureStreamParameterivNV(int video_capture_slot, int stream, int pname, MemorySegment params) {
    PFNGLVIDEOCAPTURESTREAMPARAMETERIVNVPROC.invoke(address("glVideoCaptureStreamParameterivNV"), video_capture_slot, stream, pname, params);
  }

  public void glGlobalAlphaFactorubSUN(byte factor) {
    PFNGLGLOBALALPHAFACTORUBSUNPROC.invoke(address("glGlobalAlphaFactorubSUN"), factor);
  }

  public void glCullParameterfvEXT(int pname, MemorySegment params) {
    PFNGLCULLPARAMETERFVEXTPROC.invoke(address("glCullParameterfvEXT"), pname, params);
  }

  public void glUniformBlockBinding(int program, int uniformBlockIndex, int uniformBlockBinding) {
    PFNGLUNIFORMBLOCKBINDINGPROC.invoke(address("glUniformBlockBinding"), program, uniformBlockIndex, uniformBlockBinding);
  }

  public void glCopyMultiTexSubImage2DEXT(int texunit, int target, int level, int xoffset, int yoffset, int x, int y, int width, int height) {
    PFNGLCOPYMULTITEXSUBIMAGE2DEXTPROC.invoke(address("glCopyMultiTexSubImage2DEXT"), texunit, target, level, xoffset, yoffset, x, y, width, height);
  }

  public void glClientAttribDefaultEXT(int mask) {
    PFNGLCLIENTATTRIBDEFAULTEXTPROC.invoke(address("glClientAttribDefaultEXT"), mask);
  }

  public int glCheckFramebufferStatus(int target) {
    return PFNGLCHECKFRAMEBUFFERSTATUSPROC.invoke(address("glCheckFramebufferStatus"), target);
  }

  public void glDeleteProgramsNV(int n, MemorySegment programs) {
    PFNGLDELETEPROGRAMSNVPROC.invoke(address("glDeleteProgramsNV"), n, programs);
  }

  public void glGlobalAlphaFactorsSUN(short factor) {
    PFNGLGLOBALALPHAFACTORSSUNPROC.invoke(address("glGlobalAlphaFactorsSUN"), factor);
  }

  public void glListParameterfSGIX(int list, int pname, float param) {
    PFNGLLISTPARAMETERFSGIXPROC.invoke(address("glListParameterfSGIX"), list, pname, param);
  }

  public void glGetnPixelMapfvARB(int map, int bufSize, MemorySegment values) {
    PFNGLGETNPIXELMAPFVARBPROC.invoke(address("glGetnPixelMapfvARB"), map, bufSize, values);
  }

  public void glGetActiveUniformName(int program, int uniformIndex, int bufSize, MemorySegment length, MemorySegment uniformName) {
    PFNGLGETACTIVEUNIFORMNAMEPROC.invoke(address("glGetActiveUniformName"), program, uniformIndex, bufSize, length, uniformName);
  }

  public void glBlendEquationIndexedAMD(int buf, int mode) {
    PFNGLBLENDEQUATIONINDEXEDAMDPROC.invoke(address("glBlendEquationIndexedAMD"), buf, mode);
  }

  public void glDrawElementsInstanced(int mode, int count, int type, MemorySegment indices, int instancecount) {
    PFNGLDRAWELEMENTSINSTANCEDPROC.invoke(address("glDrawElementsInstanced"), mode, count, type, indices, instancecount);
  }

  public void glProgramUniform2fEXT(int program, int location, float v0, float v1) {
    PFNGLPROGRAMUNIFORM2FEXTPROC.invoke(address("glProgramUniform2fEXT"), program, location, v0, v1);
  }

  public void glMultiTexParameterfEXT(int texunit, int target, int pname, float param) {
    PFNGLMULTITEXPARAMETERFEXTPROC.invoke(address("glMultiTexParameterfEXT"), texunit, target, pname, param);
  }

  public void glGetPathCommandsNV(int path, MemorySegment commands) {
    PFNGLGETPATHCOMMANDSNVPROC.invoke(address("glGetPathCommandsNV"), path, commands);
  }

  public void glResumeTransformFeedback() {
    PFNGLRESUMETRANSFORMFEEDBACKPROC.invoke(address("glResumeTransformFeedback"));
  }

  public void glGetProgramResourcefvNV(int program, int programInterface, int index, int propCount, MemorySegment props, int count, MemorySegment length, MemorySegment params) {
    PFNGLGETPROGRAMRESOURCEFVNVPROC.invoke(address("glGetProgramResourcefvNV"), program, programInterface, index, propCount, props, count, length, params);
  }

  public void glShadingRateSampleOrderNV(int order) {
    PFNGLSHADINGRATESAMPLEORDERNVPROC.invoke(address("glShadingRateSampleOrderNV"), order);
  }

  public void glGetProgramBinaryOES(int program, int bufSize, MemorySegment length, MemorySegment binaryFormat, MemorySegment binary) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glCopyTextureSubImage3DEXT(int texture, int target, int level, int xoffset, int yoffset, int zoffset, int x, int y, int width, int height) {
    PFNGLCOPYTEXTURESUBIMAGE3DEXTPROC.invoke(address("glCopyTextureSubImage3DEXT"), texture, target, level, xoffset, yoffset, zoffset, x, y, width, height);
  }

  public void glMulticastWaitSyncNV(int signalGpu, int waitGpuMask) {
    PFNGLMULTICASTWAITSYNCNVPROC.invoke(address("glMulticastWaitSyncNV"), signalGpu, waitGpuMask);
  }

  public void glVertexAttribP3ui(int index, int type, byte normalized, int value) {
    PFNGLVERTEXATTRIBP3UIPROC.invoke(address("glVertexAttribP3ui"), index, type, normalized, value);
  }

  public void glVertexPointervINTEL(int size, int type, MemorySegment pointer) {
    PFNGLVERTEXPOINTERVINTELPROC.invoke(address("glVertexPointervINTEL"), size, type, pointer);
  }

  public void glBindFramebuffer(int target, int framebuffer) {
    PFNGLBINDFRAMEBUFFERPROC.invoke(address("glBindFramebuffer"), target, framebuffer);
  }

  public void glColor3xvOES(MemorySegment components) {
    PFNGLCOLOR3XVOESPROC.invoke(address("glColor3xvOES"), components);
  }

  public void glDeleteQueries(int n, MemorySegment ids) {
    PFNGLDELETEQUERIESPROC.invoke(address("glDeleteQueries"), n, ids);
  }

  public void glMakeBufferNonResidentNV(int target) {
    PFNGLMAKEBUFFERNONRESIDENTNVPROC.invoke(address("glMakeBufferNonResidentNV"), target);
  }

  public void glVertexStream2dvATI(int stream, MemorySegment coords) {
    PFNGLVERTEXSTREAM2DVATIPROC.invoke(address("glVertexStream2dvATI"), stream, coords);
  }

  public void glTransformFeedbackAttribsNV(int count, MemorySegment attribs, int bufferMode) {
    PFNGLTRANSFORMFEEDBACKATTRIBSNVPROC.invoke(address("glTransformFeedbackAttribsNV"), count, attribs, bufferMode);
  }

  public void glSecondaryColor3usvEXT(MemorySegment v) {
    PFNGLSECONDARYCOLOR3USVEXTPROC.invoke(address("glSecondaryColor3usvEXT"), v);
  }

  public void glGetUniformiv(int program, int location, MemorySegment params) {
    PFNGLGETUNIFORMIVPROC.invoke(address("glGetUniformiv"), program, location, params);
  }

  public byte glIsFenceAPPLE(int fence) {
    return PFNGLISFENCEAPPLEPROC.invoke(address("glIsFenceAPPLE"), fence);
  }

  public void glFrustumfOES(float l, float r, float b, float t, float n, float f) {
    PFNGLFRUSTUMFOESPROC.invoke(address("glFrustumfOES"), l, r, b, t, n, f);
  }

  public void glUniform3dv(int location, int count, MemorySegment value) {
    PFNGLUNIFORM3DVPROC.invoke(address("glUniform3dv"), location, count, value);
  }

  public void glGetShaderInfoLog(int shader, int bufSize, MemorySegment length, MemorySegment infoLog) {
    PFNGLGETSHADERINFOLOGPROC.invoke(address("glGetShaderInfoLog"), shader, bufSize, length, infoLog);
  }

  public void glSecondaryColor3dEXT(double red, double green, double blue) {
    PFNGLSECONDARYCOLOR3DEXTPROC.invoke(address("glSecondaryColor3dEXT"), red, green, blue);
  }

  public void glVertexAttribI4usv(int index, MemorySegment v) {
    PFNGLVERTEXATTRIBI4USVPROC.invoke(address("glVertexAttribI4usv"), index, v);
  }

  public void glDrawBuffersEXT(int n, MemorySegment bufs) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniformMatrix2x4dvEXT(int program, int location, int count, byte transpose, MemorySegment value) {
    PFNGLPROGRAMUNIFORMMATRIX2X4DVEXTPROC.invoke(address("glProgramUniformMatrix2x4dvEXT"), program, location, count, transpose, value);
  }

  public void glCopyTexImage1DEXT(int target, int level, int internalformat, int x, int y, int width, int border) {
    PFNGLCOPYTEXIMAGE1DEXTPROC.invoke(address("glCopyTexImage1DEXT"), target, level, internalformat, x, y, width, border);
  }

  public int glCreateShaderProgramvEXT(int type, int count, MemorySegment strings) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFramebufferTexture(int target, int attachment, int texture, int level) {
    PFNGLFRAMEBUFFERTEXTUREPROC.invoke(address("glFramebufferTexture"), target, attachment, texture, level);
  }

  public void glNamedProgramLocalParameters4fvEXT(int program, int target, int index, int count, MemorySegment params) {
    PFNGLNAMEDPROGRAMLOCALPARAMETERS4FVEXTPROC.invoke(address("glNamedProgramLocalParameters4fvEXT"), program, target, index, count, params);
  }

  public void glGetVideoivNV(int video_slot, int pname, MemorySegment params) {
    PFNGLGETVIDEOIVNVPROC.invoke(address("glGetVideoivNV"), video_slot, pname, params);
  }

  public void glGetNamedRenderbufferParameterivEXT(int renderbuffer, int pname, MemorySegment params) {
    PFNGLGETNAMEDRENDERBUFFERPARAMETERIVEXTPROC.invoke(address("glGetNamedRenderbufferParameterivEXT"), renderbuffer, pname, params);
  }

  public void glCompressedTextureSubImage3D(int texture, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int format, int imageSize, MemorySegment data) {
    PFNGLCOMPRESSEDTEXTURESUBIMAGE3DPROC.invoke(address("glCompressedTextureSubImage3D"), texture, level, xoffset, yoffset, zoffset, width, height, depth, format, imageSize, data);
  }

  public void glGetClipPlanefOES(int plane, MemorySegment equation) {
    PFNGLGETCLIPPLANEFOESPROC.invoke(address("glGetClipPlanefOES"), plane, equation);
  }

  public void glMapVertexAttrib2dAPPLE(int index, int size, double u1, double u2, int ustride, int uorder, double v1, double v2, int vstride, int vorder, MemorySegment points) {
    PFNGLMAPVERTEXATTRIB2DAPPLEPROC.invoke(address("glMapVertexAttrib2dAPPLE"), index, size, u1, u2, ustride, uorder, v1, v2, vstride, vorder, points);
  }

  public void glFinishObjectAPPLE(int object, int name) {
    PFNGLFINISHOBJECTAPPLEPROC.invoke(address("glFinishObjectAPPLE"), object, name);
  }

  public void glVertexAttrib1dvNV(int index, MemorySegment v) {
    PFNGLVERTEXATTRIB1DVNVPROC.invoke(address("glVertexAttrib1dvNV"), index, v);
  }

  public void glGetRenderbufferParameterivOES(int target, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glViewportIndexedfNV(int index, float x, float y, float w, float h) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexGendEXT(int texunit, int coord, int pname, double param) {
    PFNGLMULTITEXGENDEXTPROC.invoke(address("glMultiTexGendEXT"), texunit, coord, pname, param);
  }

  public void glGetnUniformui64vARB(int program, int location, int bufSize, MemorySegment params) {
    PFNGLGETNUNIFORMUI64VARBPROC.invoke(address("glGetnUniformui64vARB"), program, location, bufSize, params);
  }

  public void glTexCoord1bvOES(MemorySegment coords) {
    PFNGLTEXCOORD1BVOESPROC.invoke(address("glTexCoord1bvOES"), coords);
  }

  public void glVertexArrayAttribFormat(int vaobj, int attribindex, int size, int type, byte normalized, int relativeoffset) {
    PFNGLVERTEXARRAYATTRIBFORMATPROC.invoke(address("glVertexArrayAttribFormat"), vaobj, attribindex, size, type, normalized, relativeoffset);
  }

  public void glFogCoordPointerListIBM(int type, int stride, MemorySegment pointer, int ptrstride) {
    PFNGLFOGCOORDPOINTERLISTIBMPROC.invoke(address("glFogCoordPointerListIBM"), type, stride, pointer, ptrstride);
  }

  public void glVertexArrayAttribIFormat(int vaobj, int attribindex, int size, int type, int relativeoffset) {
    PFNGLVERTEXARRAYATTRIBIFORMATPROC.invoke(address("glVertexArrayAttribIFormat"), vaobj, attribindex, size, type, relativeoffset);
  }

  public void glReplacementCodeuiColor4ubVertex3fvSUN(MemorySegment rc, MemorySegment c, MemorySegment v) {
    PFNGLREPLACEMENTCODEUICOLOR4UBVERTEX3FVSUNPROC.invoke(address("glReplacementCodeuiColor4ubVertex3fvSUN"), rc, c, v);
  }

  public void glUniform3fv(int location, int count, MemorySegment value) {
    PFNGLUNIFORM3FVPROC.invoke(address("glUniform3fv"), location, count, value);
  }

  public void glGetPixelTransformParameterfvEXT(int target, int pname, MemorySegment params) {
    PFNGLGETPIXELTRANSFORMPARAMETERFVEXTPROC.invoke(address("glGetPixelTransformParameterfvEXT"), target, pname, params);
  }

  public void glMatrixLoad3x3fNV(int matrixMode, MemorySegment m) {
    PFNGLMATRIXLOAD3X3FNVPROC.invoke(address("glMatrixLoad3x3fNV"), matrixMode, m);
  }

  public void glProgramLocalParameters4fvEXT(int target, int index, int count, MemorySegment params) {
    PFNGLPROGRAMLOCALPARAMETERS4FVEXTPROC.invoke(address("glProgramLocalParameters4fvEXT"), target, index, count, params);
  }

  public void glVertexArrayVertexBuffers(int vaobj, int first, int count, MemorySegment buffers, MemorySegment offsets, MemorySegment strides) {
    PFNGLVERTEXARRAYVERTEXBUFFERSPROC.invoke(address("glVertexArrayVertexBuffers"), vaobj, first, count, buffers, offsets, strides);
  }

  public void glDrawElementsBaseVertexOES(int mode, int count, int type, MemorySegment indices, int basevertex) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexCoordP1uiv(int texture, int type, MemorySegment coords) {
    PFNGLMULTITEXCOORDP1UIVPROC.invoke(address("glMultiTexCoordP1uiv"), texture, type, coords);
  }

  public void glVertexAttrib4dARB(int index, double x, double y, double z, double w) {
    PFNGLVERTEXATTRIB4DARBPROC.invoke(address("glVertexAttrib4dARB"), index, x, y, z, w);
  }

  public void glWindowPos3sMESA(short x, short y, short z) {
    PFNGLWINDOWPOS3SMESAPROC.invoke(address("glWindowPos3sMESA"), x, y, z);
  }

  public void glGetUniformdv(int program, int location, MemorySegment params) {
    PFNGLGETUNIFORMDVPROC.invoke(address("glGetUniformdv"), program, location, params);
  }

  public void glGetVertexAttribPointerv(int index, int pname, MemorySegment pointer) {
    PFNGLGETVERTEXATTRIBPOINTERVPROC.invoke(address("glGetVertexAttribPointerv"), index, pname, pointer);
  }

  public void glTransformFeedbackBufferRange(int xfb, int index, int buffer, long offset, long size) {
    PFNGLTRANSFORMFEEDBACKBUFFERRANGEPROC.invoke(address("glTransformFeedbackBufferRange"), xfb, index, buffer, offset, size);
  }

  public void glVertexAttrib2fvNV(int index, MemorySegment v) {
    PFNGLVERTEXATTRIB2FVNVPROC.invoke(address("glVertexAttrib2fvNV"), index, v);
  }

  public void glViewportIndexedf(int index, float x, float y, float w, float h) {
    PFNGLVIEWPORTINDEXEDFPROC.invoke(address("glViewportIndexedf"), index, x, y, w, h);
  }

  public void glCompressedTextureSubImage1D(int texture, int level, int xoffset, int width, int format, int imageSize, MemorySegment data) {
    PFNGLCOMPRESSEDTEXTURESUBIMAGE1DPROC.invoke(address("glCompressedTextureSubImage1D"), texture, level, xoffset, width, format, imageSize, data);
  }

  public void glProgramUniform1fvEXT(int program, int location, int count, MemorySegment value) {
    PFNGLPROGRAMUNIFORM1FVEXTPROC.invoke(address("glProgramUniform1fvEXT"), program, location, count, value);
  }

  public void glColor4hNV(short red, short green, short blue, short alpha) {
    PFNGLCOLOR4HNVPROC.invoke(address("glColor4hNV"), red, green, blue, alpha);
  }

  public void glPauseTransformFeedback() {
    PFNGLPAUSETRANSFORMFEEDBACKPROC.invoke(address("glPauseTransformFeedback"));
  }

  public long glGetTextureHandleNV(int texture) {
    return PFNGLGETTEXTUREHANDLENVPROC.invoke(address("glGetTextureHandleNV"), texture);
  }

  public void glTexBumpParameterivATI(int pname, MemorySegment param) {
    PFNGLTEXBUMPPARAMETERIVATIPROC.invoke(address("glTexBumpParameterivATI"), pname, param);
  }

  public void glExtGetShadersQCOM(MemorySegment shaders, int maxShaders, MemorySegment numShaders) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFramebufferTexture2DOES(int target, int attachment, int textarget, int texture, int level) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexCoordP1ui(int texture, int type, int coords) {
    PFNGLMULTITEXCOORDP1UIPROC.invoke(address("glMultiTexCoordP1ui"), texture, type, coords);
  }

  public void glPolygonOffsetx(int factor, int units) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glCreateVertexArrays(int n, MemorySegment arrays) {
    PFNGLCREATEVERTEXARRAYSPROC.invoke(address("glCreateVertexArrays"), n, arrays);
  }

  public void glIndexPointerEXT(int type, int stride, int count, MemorySegment pointer) {
    PFNGLINDEXPOINTEREXTPROC.invoke(address("glIndexPointerEXT"), type, stride, count, pointer);
  }

  public void glWindowPos2dvMESA(MemorySegment v) {
    PFNGLWINDOWPOS2DVMESAPROC.invoke(address("glWindowPos2dvMESA"), v);
  }

  public void glGetBufferSubData(int target, long offset, long size, MemorySegment data) {
    PFNGLGETBUFFERSUBDATAPROC.invoke(address("glGetBufferSubData"), target, offset, size, data);
  }

  public void glUniform2i64vNV(int location, int count, MemorySegment value) {
    PFNGLUNIFORM2I64VNVPROC.invoke(address("glUniform2i64vNV"), location, count, value);
  }

  public void glCompressedTextureSubImage2D(int texture, int level, int xoffset, int yoffset, int width, int height, int format, int imageSize, MemorySegment data) {
    PFNGLCOMPRESSEDTEXTURESUBIMAGE2DPROC.invoke(address("glCompressedTextureSubImage2D"), texture, level, xoffset, yoffset, width, height, format, imageSize, data);
  }

  public void glDrawTransformFeedbackNV(int mode, int id) {
    PFNGLDRAWTRANSFORMFEEDBACKNVPROC.invoke(address("glDrawTransformFeedbackNV"), mode, id);
  }

  public void glTexCoord2fColor4ubVertex3fvSUN(MemorySegment tc, MemorySegment c, MemorySegment v) {
    PFNGLTEXCOORD2FCOLOR4UBVERTEX3FVSUNPROC.invoke(address("glTexCoord2fColor4ubVertex3fvSUN"), tc, c, v);
  }

  public void glGetFragmentLightivSGIX(int light, int pname, MemorySegment params) {
    PFNGLGETFRAGMENTLIGHTIVSGIXPROC.invoke(address("glGetFragmentLightivSGIX"), light, pname, params);
  }

  public void glTangent3dvEXT(MemorySegment v) {
    PFNGLTANGENT3DVEXTPROC.invoke(address("glTangent3dvEXT"), v);
  }

  public void glVertexAttrib4fNV(int index, float x, float y, float z, float w) {
    PFNGLVERTEXATTRIB4FNVPROC.invoke(address("glVertexAttrib4fNV"), index, x, y, z, w);
  }

  public void glTexCoord4hvNV(MemorySegment v) {
    PFNGLTEXCOORD4HVNVPROC.invoke(address("glTexCoord4hvNV"), v);
  }

  public void glTexSubImage3DEXT(int target, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int format, int type, MemorySegment pixels) {
    PFNGLTEXSUBIMAGE3DEXTPROC.invoke(address("glTexSubImage3DEXT"), target, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels);
  }

  public void glGetnPixelMapusv(int map, int bufSize, MemorySegment values) {
    PFNGLGETNPIXELMAPUSVPROC.invoke(address("glGetnPixelMapusv"), map, bufSize, values);
  }

  public void glGetUniformfv(int program, int location, MemorySegment params) {
    PFNGLGETUNIFORMFVPROC.invoke(address("glGetUniformfv"), program, location, params);
  }

  public void glBinormal3dEXT(double bx, double by, double bz) {
    PFNGLBINORMAL3DEXTPROC.invoke(address("glBinormal3dEXT"), bx, by, bz);
  }

  public void glPathFogGenNV(int genMode) {
    PFNGLPATHFOGGENNVPROC.invoke(address("glPathFogGenNV"), genMode);
  }

  public void glDepthRangeIndexedfOES(int index, float n, float f) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public int glGetSubroutineIndex(int program, int shadertype, MemorySegment name) {
    return PFNGLGETSUBROUTINEINDEXPROC.invoke(address("glGetSubroutineIndex"), program, shadertype, name);
  }

  public void glBitmapxOES(int width, int height, int xorig, int yorig, int xmove, int ymove, MemorySegment bitmap) {
    PFNGLBITMAPXOESPROC.invoke(address("glBitmapxOES"), width, height, xorig, yorig, xmove, ymove, bitmap);
  }

  public void glVertexArrayVertexAttribDivisorEXT(int vaobj, int index, int divisor) {
    PFNGLVERTEXARRAYVERTEXATTRIBDIVISOREXTPROC.invoke(address("glVertexArrayVertexAttribDivisorEXT"), vaobj, index, divisor);
  }

  public void glProgramStringARB(int target, int format, int len, MemorySegment string) {
    PFNGLPROGRAMSTRINGARBPROC.invoke(address("glProgramStringARB"), target, format, len, string);
  }

  public void glVertexAttrib3svNV(int index, MemorySegment v) {
    PFNGLVERTEXATTRIB3SVNVPROC.invoke(address("glVertexAttrib3svNV"), index, v);
  }

  public long glGetTextureHandleARB(int texture) {
    return PFNGLGETTEXTUREHANDLEARBPROC.invoke(address("glGetTextureHandleARB"), texture);
  }

  public void glVertexAttrib4bvARB(int index, MemorySegment v) {
    PFNGLVERTEXATTRIB4BVARBPROC.invoke(address("glVertexAttrib4bvARB"), index, v);
  }

  public void glVertexAttrib2svARB(int index, MemorySegment v) {
    PFNGLVERTEXATTRIB2SVARBPROC.invoke(address("glVertexAttrib2svARB"), index, v);
  }

  public void glDepthRangeIndexedfNV(int index, float n, float f) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glColorFragmentOp2ATI(int op, int dst, int dstMask, int dstMod, int arg1, int arg1Rep, int arg1Mod, int arg2, int arg2Rep, int arg2Mod) {
    PFNGLCOLORFRAGMENTOP2ATIPROC.invoke(address("glColorFragmentOp2ATI"), op, dst, dstMask, dstMod, arg1, arg1Rep, arg1Mod, arg2, arg2Rep, arg2Mod);
  }

  public void glFramebufferSampleLocationsfvARB(int target, int start, int count, MemorySegment v) {
    PFNGLFRAMEBUFFERSAMPLELOCATIONSFVARBPROC.invoke(address("glFramebufferSampleLocationsfvARB"), target, start, count, v);
  }

  public void glTexCoord2fNormal3fVertex3fSUN(float s, float t, float nx, float ny, float nz, float x, float y, float z) {
    PFNGLTEXCOORD2FNORMAL3FVERTEX3FSUNPROC.invoke(address("glTexCoord2fNormal3fVertex3fSUN"), s, t, nx, ny, nz, x, y, z);
  }

  public void glGetQueryBufferObjectui64v(int id, int buffer, int pname, long offset) {
    PFNGLGETQUERYBUFFEROBJECTUI64VPROC.invoke(address("glGetQueryBufferObjectui64v"), id, buffer, pname, offset);
  }

  public void glFramebufferTexture2DMultisampleIMG(int target, int attachment, int textarget, int texture, int level, int samples) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glPathCoverDepthFuncNV(int func) {
    PFNGLPATHCOVERDEPTHFUNCNVPROC.invoke(address("glPathCoverDepthFuncNV"), func);
  }

  public void glVertexAttrib3hvNV(int index, MemorySegment v) {
    PFNGLVERTEXATTRIB3HVNVPROC.invoke(address("glVertexAttrib3hvNV"), index, v);
  }

  public void glVertexAttribI1uivEXT(int index, MemorySegment v) {
    PFNGLVERTEXATTRIBI1UIVEXTPROC.invoke(address("glVertexAttribI1uivEXT"), index, v);
  }

  public int glGetSubroutineUniformLocation(int program, int shadertype, MemorySegment name) {
    return PFNGLGETSUBROUTINEUNIFORMLOCATIONPROC.invoke(address("glGetSubroutineUniformLocation"), program, shadertype, name);
  }

  public byte glIsFramebufferEXT(int framebuffer) {
    return PFNGLISFRAMEBUFFEREXTPROC.invoke(address("glIsFramebufferEXT"), framebuffer);
  }

  public void glProgramUniformMatrix2dvEXT(int program, int location, int count, byte transpose, MemorySegment value) {
    PFNGLPROGRAMUNIFORMMATRIX2DVEXTPROC.invoke(address("glProgramUniformMatrix2dvEXT"), program, location, count, transpose, value);
  }

  public void glBlitNamedFramebuffer(int readFramebuffer, int drawFramebuffer, int srcX0, int srcY0, int srcX1, int srcY1, int dstX0, int dstY0, int dstX1, int dstY1, int mask, int filter) {
    PFNGLBLITNAMEDFRAMEBUFFERPROC.invoke(address("glBlitNamedFramebuffer"), readFramebuffer, drawFramebuffer, srcX0, srcY0, srcX1, srcY1, dstX0, dstY0, dstX1, dstY1, mask, filter);
  }

  public void glVariantivEXT(int id, MemorySegment addr) {
    PFNGLVARIANTIVEXTPROC.invoke(address("glVariantivEXT"), id, addr);
  }

  public void glGetBooleani_v(int target, int index, MemorySegment data) {
    PFNGLGETBOOLEANI_VPROC.invoke(address("glGetBooleani_v"), target, index, data);
  }

  public void glGetQueryiv(int target, int pname, MemorySegment params) {
    PFNGLGETQUERYIVPROC.invoke(address("glGetQueryiv"), target, pname, params);
  }

  public void glGetVariantBooleanvEXT(int id, int value, MemorySegment data) {
    PFNGLGETVARIANTBOOLEANVEXTPROC.invoke(address("glGetVariantBooleanvEXT"), id, value, data);
  }

  public void glBindBufferBaseEXT(int target, int index, int buffer) {
    PFNGLBINDBUFFERBASEEXTPROC.invoke(address("glBindBufferBaseEXT"), target, index, buffer);
  }

  public void glVertexStream4ivATI(int stream, MemorySegment coords) {
    PFNGLVERTEXSTREAM4IVATIPROC.invoke(address("glVertexStream4ivATI"), stream, coords);
  }

  public void glStencilStrokePathNV(int path, int reference, int mask) {
    PFNGLSTENCILSTROKEPATHNVPROC.invoke(address("glStencilStrokePathNV"), path, reference, mask);
  }

  public void glGetnHistogram(int target, byte reset, int format, int type, int bufSize, MemorySegment values) {
    PFNGLGETNHISTOGRAMPROC.invoke(address("glGetnHistogram"), target, reset, format, type, bufSize, values);
  }

  public void glUseProgramObjectARB(int programObj) {
    PFNGLUSEPROGRAMOBJECTARBPROC.invoke(address("glUseProgramObjectARB"), programObj);
  }

  public void glGetActiveAtomicCounterBufferiv(int program, int bufferIndex, int pname, MemorySegment params) {
    PFNGLGETACTIVEATOMICCOUNTERBUFFERIVPROC.invoke(address("glGetActiveAtomicCounterBufferiv"), program, bufferIndex, pname, params);
  }

  public void glTexCoord4fColor4fNormal3fVertex4fvSUN(MemorySegment tc, MemorySegment c, MemorySegment n, MemorySegment v) {
    PFNGLTEXCOORD4FCOLOR4FNORMAL3FVERTEX4FVSUNPROC.invoke(address("glTexCoord4fColor4fNormal3fVertex4fvSUN"), tc, c, n, v);
  }

  public MemorySegment glMapNamedBufferRangeEXT(int buffer, long offset, long length, int access) {
    return PFNGLMAPNAMEDBUFFERRANGEEXTPROC.invoke(address("glMapNamedBufferRangeEXT"), buffer, offset, length, access);
  }

  public void glGenProgramsARB(int n, MemorySegment programs) {
    PFNGLGENPROGRAMSARBPROC.invoke(address("glGenProgramsARB"), n, programs);
  }

  public void glEndTransformFeedbackNV() {
    PFNGLENDTRANSFORMFEEDBACKNVPROC.invoke(address("glEndTransformFeedbackNV"));
  }

  public void glProgramUniform1ui64NV(int program, int location, long x) {
    PFNGLPROGRAMUNIFORM1UI64NVPROC.invoke(address("glProgramUniform1ui64NV"), program, location, x);
  }

  public void glProgramEnvParameter4fvARB(int target, int index, MemorySegment params) {
    PFNGLPROGRAMENVPARAMETER4FVARBPROC.invoke(address("glProgramEnvParameter4fvARB"), target, index, params);
  }

  public void glVertex3hvNV(MemorySegment v) {
    PFNGLVERTEX3HVNVPROC.invoke(address("glVertex3hvNV"), v);
  }

  public void glGetVideouivNV(int video_slot, int pname, MemorySegment params) {
    PFNGLGETVIDEOUIVNVPROC.invoke(address("glGetVideouivNV"), video_slot, pname, params);
  }

  public void glPointParameterxv(int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetnPixelMapuivARB(int map, int bufSize, MemorySegment values) {
    PFNGLGETNPIXELMAPUIVARBPROC.invoke(address("glGetnPixelMapuivARB"), map, bufSize, values);
  }

  public byte glIsTextureHandleResidentARB(long handle) {
    return PFNGLISTEXTUREHANDLERESIDENTARBPROC.invoke(address("glIsTextureHandleResidentARB"), handle);
  }

  public void glNamedFramebufferDrawBuffer(int framebuffer, int buf) {
    PFNGLNAMEDFRAMEBUFFERDRAWBUFFERPROC.invoke(address("glNamedFramebufferDrawBuffer"), framebuffer, buf);
  }

  public void glTextureStorage3DEXT(int texture, int target, int levels, int internalformat, int width, int height, int depth) {
    PFNGLTEXTURESTORAGE3DEXTPROC.invoke(address("glTextureStorage3DEXT"), texture, target, levels, internalformat, width, height, depth);
  }

  public void glUniform1i64vARB(int location, int count, MemorySegment value) {
    PFNGLUNIFORM1I64VARBPROC.invoke(address("glUniform1i64vARB"), location, count, value);
  }

  public void glGetObjectBufferfvATI(int buffer, int pname, MemorySegment params) {
    PFNGLGETOBJECTBUFFERFVATIPROC.invoke(address("glGetObjectBufferfvATI"), buffer, pname, params);
  }

  public int glPollInstrumentsSGIX(MemorySegment marker_p) {
    return PFNGLPOLLINSTRUMENTSSGIXPROC.invoke(address("glPollInstrumentsSGIX"), marker_p);
  }

  public void glGetDriverControlStringQCOM(int driverControl, int bufSize, MemorySegment length, MemorySegment driverControlString) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFramebufferParameteri(int target, int pname, int param) {
    PFNGLFRAMEBUFFERPARAMETERIPROC.invoke(address("glFramebufferParameteri"), target, pname, param);
  }

  public void glGenFencesAPPLE(int n, MemorySegment fences) {
    PFNGLGENFENCESAPPLEPROC.invoke(address("glGenFencesAPPLE"), n, fences);
  }

  public void glViewportArrayv(int first, int count, MemorySegment v) {
    PFNGLVIEWPORTARRAYVPROC.invoke(address("glViewportArrayv"), first, count, v);
  }

  public void glGetObjectParameterivARB(int obj, int pname, MemorySegment params) {
    PFNGLGETOBJECTPARAMETERIVARBPROC.invoke(address("glGetObjectParameterivARB"), obj, pname, params);
  }

  public void glTexImage3DMultisampleCoverageNV(int target, int coverageSamples, int colorSamples, int internalFormat, int width, int height, int depth, byte fixedSampleLocations) {
    PFNGLTEXIMAGE3DMULTISAMPLECOVERAGENVPROC.invoke(address("glTexImage3DMultisampleCoverageNV"), target, coverageSamples, colorSamples, internalFormat, width, height, depth, fixedSampleLocations);
  }

  public void glProgramUniformMatrix2x3fv(int program, int location, int count, byte transpose, MemorySegment value) {
    PFNGLPROGRAMUNIFORMMATRIX2X3FVPROC.invoke(address("glProgramUniformMatrix2x3fv"), program, location, count, transpose, value);
  }

  public void glMapGrid1xOES(int n, int u1, int u2) {
    PFNGLMAPGRID1XOESPROC.invoke(address("glMapGrid1xOES"), n, u1, u2);
  }

  public void glGetPerfMonitorCountersAMD(int group, MemorySegment numCounters, MemorySegment maxActiveCounters, int counterSize, MemorySegment counters) {
    PFNGLGETPERFMONITORCOUNTERSAMDPROC.invoke(address("glGetPerfMonitorCountersAMD"), group, numCounters, maxActiveCounters, counterSize, counters);
  }

  public void glFramebufferTextureFaceARB(int target, int attachment, int texture, int level, int face) {
    PFNGLFRAMEBUFFERTEXTUREFACEARBPROC.invoke(address("glFramebufferTextureFaceARB"), target, attachment, texture, level, face);
  }

  public void glTangent3sEXT(short tx, short ty, short tz) {
    PFNGLTANGENT3SEXTPROC.invoke(address("glTangent3sEXT"), tx, ty, tz);
  }

  public void glTexStorageMem2DEXT(int target, int levels, int internalFormat, int width, int height, int memory, long offset) {
    PFNGLTEXSTORAGEMEM2DEXTPROC.invoke(address("glTexStorageMem2DEXT"), target, levels, internalFormat, width, height, memory, offset);
  }

  public void glGetnPixelMapuiv(int map, int bufSize, MemorySegment values) {
    PFNGLGETNPIXELMAPUIVPROC.invoke(address("glGetnPixelMapuiv"), map, bufSize, values);
  }

  public void glTexCoordP2ui(int type, int coords) {
    PFNGLTEXCOORDP2UIPROC.invoke(address("glTexCoordP2ui"), type, coords);
  }

  public void glGetLightxvOES(int light, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexCoord4bvOES(int texture, MemorySegment coords) {
    PFNGLMULTITEXCOORD4BVOESPROC.invoke(address("glMultiTexCoord4bvOES"), texture, coords);
  }

  public void glPolygonOffsetxOES(int factor, int units) {
    PFNGLPOLYGONOFFSETXOESPROC.invoke(address("glPolygonOffsetxOES"), factor, units);
  }

  public void glNamedProgramLocalParameter4fvEXT(int program, int target, int index, MemorySegment params) {
    PFNGLNAMEDPROGRAMLOCALPARAMETER4FVEXTPROC.invoke(address("glNamedProgramLocalParameter4fvEXT"), program, target, index, params);
  }

  public void glClearTexSubImage(int texture, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int format, int type, MemorySegment data) {
    PFNGLCLEARTEXSUBIMAGEPROC.invoke(address("glClearTexSubImage"), texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, data);
  }

  public void glVertexAttribI2iEXT(int index, int x, int y) {
    PFNGLVERTEXATTRIBI2IEXTPROC.invoke(address("glVertexAttribI2iEXT"), index, x, y);
  }

  public void glFramebufferTextureLayer(int target, int attachment, int texture, int level, int layer) {
    PFNGLFRAMEBUFFERTEXTURELAYERPROC.invoke(address("glFramebufferTextureLayer"), target, attachment, texture, level, layer);
  }

  public void glGetVertexAttribLdv(int index, int pname, MemorySegment params) {
    PFNGLGETVERTEXATTRIBLDVPROC.invoke(address("glGetVertexAttribLdv"), index, pname, params);
  }

  public void glVertexP4uiv(int type, MemorySegment value) {
    PFNGLVERTEXP4UIVPROC.invoke(address("glVertexP4uiv"), type, value);
  }

  public void glReplacementCodeuiColor3fVertex3fSUN(int rc, float r, float g, float b, float x, float y, float z) {
    PFNGLREPLACEMENTCODEUICOLOR3FVERTEX3FSUNPROC.invoke(address("glReplacementCodeuiColor3fVertex3fSUN"), rc, r, g, b, x, y, z);
  }

  public void glGetTexParameterxv(int target, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMulticastViewportArrayvNVX(int gpu, int first, int count, MemorySegment v) {
    PFNGLMULTICASTVIEWPORTARRAYVNVXPROC.invoke(address("glMulticastViewportArrayvNVX"), gpu, first, count, v);
  }

  public void glSampleCoveragexOES(int value, byte invert) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glReplacementCodeuiVertex3fvSUN(MemorySegment rc, MemorySegment v) {
    PFNGLREPLACEMENTCODEUIVERTEX3FVSUNPROC.invoke(address("glReplacementCodeuiVertex3fvSUN"), rc, v);
  }

  public void glDeleteFencesNV(int n, MemorySegment fences) {
    PFNGLDELETEFENCESNVPROC.invoke(address("glDeleteFencesNV"), n, fences);
  }

  public void glGetSamplerParameterIiv(int sampler, int pname, MemorySegment params) {
    PFNGLGETSAMPLERPARAMETERIIVPROC.invoke(address("glGetSamplerParameterIiv"), sampler, pname, params);
  }

  public void glVertexAttribPointerNV(int index, int fsize, int type, int stride, MemorySegment pointer) {
    PFNGLVERTEXATTRIBPOINTERNVPROC.invoke(address("glVertexAttribPointerNV"), index, fsize, type, stride, pointer);
  }

  public void glVertexStream4sATI(int stream, short x, short y, short z, short w) {
    PFNGLVERTEXSTREAM4SATIPROC.invoke(address("glVertexStream4sATI"), stream, x, y, z, w);
  }

  public void glProgramUniformMatrix2x3dv(int program, int location, int count, byte transpose, MemorySegment value) {
    PFNGLPROGRAMUNIFORMMATRIX2X3DVPROC.invoke(address("glProgramUniformMatrix2x3dv"), program, location, count, transpose, value);
  }

  public void glBlendBarrier() {
    PFNGLBLENDBARRIERKHRPROC.invoke(address("glBlendBarrier"));
  }

  public void glFramebufferTexture2DEXT(int target, int attachment, int textarget, int texture, int level) {
    PFNGLFRAMEBUFFERTEXTURE2DEXTPROC.invoke(address("glFramebufferTexture2DEXT"), target, attachment, textarget, texture, level);
  }

  public void glPolygonOffsetClamp(float factor, float units, float clamp) {
    PFNGLPOLYGONOFFSETCLAMPPROC.invoke(address("glPolygonOffsetClamp"), factor, units, clamp);
  }

  public void glTexCoord3bvOES(MemorySegment coords) {
    PFNGLTEXCOORD3BVOESPROC.invoke(address("glTexCoord3bvOES"), coords);
  }

  public void glUniformMatrix3x2fvNV(int location, int count, byte transpose, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniform1i64vNV(int program, int location, int count, MemorySegment value) {
    PFNGLPROGRAMUNIFORM1I64VNVPROC.invoke(address("glProgramUniform1i64vNV"), program, location, count, value);
  }

  public void glPathGlyphRangeNV(int firstPathName, int fontTarget, MemorySegment fontName, int fontStyle, int firstGlyph, int numGlyphs, int handleMissingGlyphs, int pathParameterTemplate, float emScale) {
    PFNGLPATHGLYPHRANGENVPROC.invoke(address("glPathGlyphRangeNV"), firstPathName, fontTarget, fontName, fontStyle, firstGlyph, numGlyphs, handleMissingGlyphs, pathParameterTemplate, emScale);
  }

  public void glPopDebugGroupKHR() {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexArrayBindingDivisor(int vaobj, int bindingindex, int divisor) {
    PFNGLVERTEXARRAYBINDINGDIVISORPROC.invoke(address("glVertexArrayBindingDivisor"), vaobj, bindingindex, divisor);
  }

  public void glProgramBufferParametersIuivNV(int target, int bindingIndex, int wordIndex, int count, MemorySegment params) {
    PFNGLPROGRAMBUFFERPARAMETERSIUIVNVPROC.invoke(address("glProgramBufferParametersIuivNV"), target, bindingIndex, wordIndex, count, params);
  }

  public void glBinormalPointerEXT(int type, int stride, MemorySegment pointer) {
    PFNGLBINORMALPOINTEREXTPROC.invoke(address("glBinormalPointerEXT"), type, stride, pointer);
  }

  public void glStencilFillPathNV(int path, int fillMode, int mask) {
    PFNGLSTENCILFILLPATHNVPROC.invoke(address("glStencilFillPathNV"), path, fillMode, mask);
  }

  public void glReplacementCodeuiNormal3fVertex3fvSUN(MemorySegment rc, MemorySegment n, MemorySegment v) {
    PFNGLREPLACEMENTCODEUINORMAL3FVERTEX3FVSUNPROC.invoke(address("glReplacementCodeuiNormal3fVertex3fvSUN"), rc, n, v);
  }

  public void glUniform2ui64vARB(int location, int count, MemorySegment value) {
    PFNGLUNIFORM2UI64VARBPROC.invoke(address("glUniform2ui64vARB"), location, count, value);
  }

  public void glDrawElementsInstancedBaseVertexOES(int mode, int count, int type, MemorySegment indices, int instancecount, int basevertex) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexStream3fATI(int stream, float x, float y, float z) {
    PFNGLVERTEXSTREAM3FATIPROC.invoke(address("glVertexStream3fATI"), stream, x, y, z);
  }

  public void glCombinerParameteriNV(int pname, int param) {
    PFNGLCOMBINERPARAMETERINVPROC.invoke(address("glCombinerParameteriNV"), pname, param);
  }

  public int glGetGraphicsResetStatus() {
    return PFNGLGETGRAPHICSRESETSTATUSPROC.invoke(address("glGetGraphicsResetStatus"));
  }

  public void glVertexAttrib4ivARB(int index, MemorySegment v) {
    PFNGLVERTEXATTRIB4IVARBPROC.invoke(address("glVertexAttrib4ivARB"), index, v);
  }

  public void glNamedProgramLocalParameterI4uivEXT(int program, int target, int index, MemorySegment params) {
    PFNGLNAMEDPROGRAMLOCALPARAMETERI4UIVEXTPROC.invoke(address("glNamedProgramLocalParameterI4uivEXT"), program, target, index, params);
  }

  public void glEnableVertexArrayAttribEXT(int vaobj, int index) {
    PFNGLENABLEVERTEXARRAYATTRIBEXTPROC.invoke(address("glEnableVertexArrayAttribEXT"), vaobj, index);
  }

  public void glPointParameterivNV(int pname, MemorySegment params) {
    PFNGLPOINTPARAMETERIVNVPROC.invoke(address("glPointParameterivNV"), pname, params);
  }

  public void glWindowPos3dMESA(double x, double y, double z) {
    PFNGLWINDOWPOS3DMESAPROC.invoke(address("glWindowPos3dMESA"), x, y, z);
  }

  public void glReadInstrumentsSGIX(int marker) {
    PFNGLREADINSTRUMENTSSGIXPROC.invoke(address("glReadInstrumentsSGIX"), marker);
  }

  public void glNormalPointerEXT(int type, int stride, int count, MemorySegment pointer) {
    PFNGLNORMALPOINTEREXTPROC.invoke(address("glNormalPointerEXT"), type, stride, count, pointer);
  }

  public void glRasterPos3xvOES(MemorySegment coords) {
    PFNGLRASTERPOS3XVOESPROC.invoke(address("glRasterPos3xvOES"), coords);
  }

  public void glUniform3ui(int location, int v0, int v1, int v2) {
    PFNGLUNIFORM3UIPROC.invoke(address("glUniform3ui"), location, v0, v1, v2);
  }

  public void glMatrixScaledEXT(int mode, double x, double y, double z) {
    PFNGLMATRIXSCALEDEXTPROC.invoke(address("glMatrixScaledEXT"), mode, x, y, z);
  }

  public void glCopyTextureSubImage3D(int texture, int level, int xoffset, int yoffset, int zoffset, int x, int y, int width, int height) {
    PFNGLCOPYTEXTURESUBIMAGE3DPROC.invoke(address("glCopyTextureSubImage3D"), texture, level, xoffset, yoffset, zoffset, x, y, width, height);
  }

  public void glGetPathColorGenivNV(int color, int pname, MemorySegment value) {
    PFNGLGETPATHCOLORGENIVNVPROC.invoke(address("glGetPathColorGenivNV"), color, pname, value);
  }

  public void glProgramUniform1d(int program, int location, double v0) {
    PFNGLPROGRAMUNIFORM1DPROC.invoke(address("glProgramUniform1d"), program, location, v0);
  }

  public byte glUnmapNamedBuffer(int buffer) {
    return PFNGLUNMAPNAMEDBUFFERPROC.invoke(address("glUnmapNamedBuffer"), buffer);
  }

  public void glDrawArraysInstancedEXT(int mode, int start, int count, int primcount) {
    PFNGLDRAWARRAYSINSTANCEDEXTPROC.invoke(address("glDrawArraysInstancedEXT"), mode, start, count, primcount);
  }

  public void glProgramUniform1f(int program, int location, float v0) {
    PFNGLPROGRAMUNIFORM1FPROC.invoke(address("glProgramUniform1f"), program, location, v0);
  }

  public void glProgramUniform1i(int program, int location, int v0) {
    PFNGLPROGRAMUNIFORM1IPROC.invoke(address("glProgramUniform1i"), program, location, v0);
  }

  public void glFrameTerminatorGREMEDY() {
    PFNGLFRAMETERMINATORGREMEDYPROC.invoke(address("glFrameTerminatorGREMEDY"));
  }

  public void glVertexStream2svATI(int stream, MemorySegment coords) {
    PFNGLVERTEXSTREAM2SVATIPROC.invoke(address("glVertexStream2svATI"), stream, coords);
  }

  public void glFrameZoomSGIX(int factor) {
    PFNGLFRAMEZOOMSGIXPROC.invoke(address("glFrameZoomSGIX"), factor);
  }

  public void glGetTextureImage(int texture, int level, int format, int type, int bufSize, MemorySegment pixels) {
    PFNGLGETTEXTUREIMAGEPROC.invoke(address("glGetTextureImage"), texture, level, format, type, bufSize, pixels);
  }

  public void glPixelTransformParameterfvEXT(int target, int pname, MemorySegment params) {
    PFNGLPIXELTRANSFORMPARAMETERFVEXTPROC.invoke(address("glPixelTransformParameterfvEXT"), target, pname, params);
  }

  public MemorySegment glGetVkProcAddrNV(MemorySegment name) {
    return PFNGLGETVKPROCADDRNVPROC.invoke(address("glGetVkProcAddrNV"), name);
  }

  public void glCopyTextureSubImage2D(int texture, int level, int xoffset, int yoffset, int x, int y, int width, int height) {
    PFNGLCOPYTEXTURESUBIMAGE2DPROC.invoke(address("glCopyTextureSubImage2D"), texture, level, xoffset, yoffset, x, y, width, height);
  }

  public byte glIsBufferResidentNV(int target) {
    return PFNGLISBUFFERRESIDENTNVPROC.invoke(address("glIsBufferResidentNV"), target);
  }

  public int glClientWaitSyncAPPLE(MemorySegment sync, int flags, long timeout) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexStream2dATI(int stream, double x, double y) {
    PFNGLVERTEXSTREAM2DATIPROC.invoke(address("glVertexStream2dATI"), stream, x, y);
  }

  public void glCopyImageSubDataNV(int srcName, int srcTarget, int srcLevel, int srcX, int srcY, int srcZ, int dstName, int dstTarget, int dstLevel, int dstX, int dstY, int dstZ, int width, int height, int depth) {
    PFNGLCOPYIMAGESUBDATANVPROC.invoke(address("glCopyImageSubDataNV"), srcName, srcTarget, srcLevel, srcX, srcY, srcZ, dstName, dstTarget, dstLevel, dstX, dstY, dstZ, width, height, depth);
  }

  public void glActiveShaderProgramEXT(int pipeline, int program) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glColorP3uiv(int type, MemorySegment color) {
    PFNGLCOLORP3UIVPROC.invoke(address("glColorP3uiv"), type, color);
  }

  public int glClientWaitSync(MemorySegment sync, int flags, long timeout) {
    return PFNGLCLIENTWAITSYNCPROC.invoke(address("glClientWaitSync"), sync, flags, timeout);
  }

  public void glReplacementCodeuiTexCoord2fVertex3fSUN(int rc, float s, float t, float x, float y, float z) {
    PFNGLREPLACEMENTCODEUITEXCOORD2FVERTEX3FSUNPROC.invoke(address("glReplacementCodeuiTexCoord2fVertex3fSUN"), rc, s, t, x, y, z);
  }

  public void glGetVertexArrayIntegeri_vEXT(int vaobj, int index, int pname, MemorySegment param) {
    PFNGLGETVERTEXARRAYINTEGERI_VEXTPROC.invoke(address("glGetVertexArrayIntegeri_vEXT"), vaobj, index, pname, param);
  }

  public void glScissorExclusiveArrayvNV(int first, int count, MemorySegment v) {
    PFNGLSCISSOREXCLUSIVEARRAYVNVPROC.invoke(address("glScissorExclusiveArrayvNV"), first, count, v);
  }

  public void glVertexAttrib4fvARB(int index, MemorySegment v) {
    PFNGLVERTEXATTRIB4FVARBPROC.invoke(address("glVertexAttrib4fvARB"), index, v);
  }

  public void glTexParameterIivEXT(int target, int pname, MemorySegment params) {
    PFNGLTEXPARAMETERIIVEXTPROC.invoke(address("glTexParameterIivEXT"), target, pname, params);
  }

  public void glVertexAttribL4dEXT(int index, double x, double y, double z, double w) {
    PFNGLVERTEXATTRIBL4DEXTPROC.invoke(address("glVertexAttribL4dEXT"), index, x, y, z, w);
  }

  public void glCompressedTexImage1DARB(int target, int level, int internalformat, int width, int border, int imageSize, MemorySegment data) {
    PFNGLCOMPRESSEDTEXIMAGE1DARBPROC.invoke(address("glCompressedTexImage1DARB"), target, level, internalformat, width, border, imageSize, data);
  }

  public void glCopyTextureSubImage1D(int texture, int level, int xoffset, int x, int y, int width) {
    PFNGLCOPYTEXTURESUBIMAGE1DPROC.invoke(address("glCopyTextureSubImage1D"), texture, level, xoffset, x, y, width);
  }

  public void glVertexAttribI1uiv(int index, MemorySegment v) {
    PFNGLVERTEXATTRIBI1UIVPROC.invoke(address("glVertexAttribI1uiv"), index, v);
  }

  public void glPatchParameteriEXT(int pname, int value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexPageCommitmentEXT(int target, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, byte commit) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniform2uivEXT(int program, int location, int count, MemorySegment value) {
    PFNGLPROGRAMUNIFORM2UIVEXTPROC.invoke(address("glProgramUniform2uivEXT"), program, location, count, value);
  }

  public void glMultiTexImage2DEXT(int texunit, int target, int level, int internalformat, int width, int height, int border, int format, int type, MemorySegment pixels) {
    PFNGLMULTITEXIMAGE2DEXTPROC.invoke(address("glMultiTexImage2DEXT"), texunit, target, level, internalformat, width, height, border, format, type, pixels);
  }

  public void glGetRenderbufferParameteriv(int target, int pname, MemorySegment params) {
    PFNGLGETRENDERBUFFERPARAMETERIVPROC.invoke(address("glGetRenderbufferParameteriv"), target, pname, params);
  }

  public void glColor3xOES(int red, int green, int blue) {
    PFNGLCOLOR3XOESPROC.invoke(address("glColor3xOES"), red, green, blue);
  }

  public void glEnableVertexAttribAPPLE(int index, int pname) {
    PFNGLENABLEVERTEXATTRIBAPPLEPROC.invoke(address("glEnableVertexAttribAPPLE"), index, pname);
  }

  public void glTangent3svEXT(MemorySegment v) {
    PFNGLTANGENT3SVEXTPROC.invoke(address("glTangent3svEXT"), v);
  }

  public void glAttachShader(int program, int shader) {
    PFNGLATTACHSHADERPROC.invoke(address("glAttachShader"), program, shader);
  }

  public void glGetNamedProgramLocalParameterIuivEXT(int program, int target, int index, MemorySegment params) {
    PFNGLGETNAMEDPROGRAMLOCALPARAMETERIUIVEXTPROC.invoke(address("glGetNamedProgramLocalParameterIuivEXT"), program, target, index, params);
  }

  public void glPatchParameterfv(int pname, MemorySegment values) {
    PFNGLPATCHPARAMETERFVPROC.invoke(address("glPatchParameterfv"), pname, values);
  }

  public void glGetTexParameterPointervAPPLE(int target, int pname, MemorySegment params) {
    PFNGLGETTEXPARAMETERPOINTERVAPPLEPROC.invoke(address("glGetTexParameterPointervAPPLE"), target, pname, params);
  }

  public void glNormalFormatNV(int type, int stride) {
    PFNGLNORMALFORMATNVPROC.invoke(address("glNormalFormatNV"), type, stride);
  }

  public void glMemoryBarrierByRegion(int barriers) {
    PFNGLMEMORYBARRIERBYREGIONPROC.invoke(address("glMemoryBarrierByRegion"), barriers);
  }

  public void glTexCoord4fColor4fNormal3fVertex4fSUN(float s, float t, float p, float q, float r, float g, float b, float a, float nx, float ny, float nz, float x, float y, float z, float w) {
    PFNGLTEXCOORD4FCOLOR4FNORMAL3FVERTEX4FSUNPROC.invoke(address("glTexCoord4fColor4fNormal3fVertex4fSUN"), s, t, p, q, r, g, b, a, nx, ny, nz, x, y, z, w);
  }

  public void glNormalStream3bvATI(int stream, MemorySegment coords) {
    PFNGLNORMALSTREAM3BVATIPROC.invoke(address("glNormalStream3bvATI"), stream, coords);
  }

  public int glGenPathsNV(int range) {
    return PFNGLGENPATHSNVPROC.invoke(address("glGenPathsNV"), range);
  }

  public void glGetNamedProgramivEXT(int program, int target, int pname, MemorySegment params) {
    PFNGLGETNAMEDPROGRAMIVEXTPROC.invoke(address("glGetNamedProgramivEXT"), program, target, pname, params);
  }

  public void glVertexP4ui(int type, int value) {
    PFNGLVERTEXP4UIPROC.invoke(address("glVertexP4ui"), type, value);
  }

  public void glVertexAttribL2dvEXT(int index, MemorySegment v) {
    PFNGLVERTEXATTRIBL2DVEXTPROC.invoke(address("glVertexAttribL2dvEXT"), index, v);
  }

  public int glGetGraphicsResetStatusARB() {
    return PFNGLGETGRAPHICSRESETSTATUSARBPROC.invoke(address("glGetGraphicsResetStatusARB"));
  }

  public void glVertex3bvOES(MemorySegment coords) {
    PFNGLVERTEX3BVOESPROC.invoke(address("glVertex3bvOES"), coords);
  }

  public void glGetTextureParameterfvEXT(int texture, int target, int pname, MemorySegment params) {
    PFNGLGETTEXTUREPARAMETERFVEXTPROC.invoke(address("glGetTextureParameterfvEXT"), texture, target, pname, params);
  }

  public void glTexParameterIuivOES(int target, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramNamedParameter4dvNV(int id, int len, MemorySegment name, MemorySegment v) {
    PFNGLPROGRAMNAMEDPARAMETER4DVNVPROC.invoke(address("glProgramNamedParameter4dvNV"), id, len, name, v);
  }

  public void glWindowPos2iARB(int x, int y) {
    PFNGLWINDOWPOS2IARBPROC.invoke(address("glWindowPos2iARB"), x, y);
  }

  public void glGetFramebufferParameteriv(int target, int pname, MemorySegment params) {
    PFNGLGETFRAMEBUFFERPARAMETERIVPROC.invoke(address("glGetFramebufferParameteriv"), target, pname, params);
  }

  public void glMultiTexCoord1xvOES(int texture, MemorySegment coords) {
    PFNGLMULTITEXCOORD1XVOESPROC.invoke(address("glMultiTexCoord1xvOES"), texture, coords);
  }

  public void glDepthRangeArraydvNV(int first, int count, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniformHandleui64ARB(int location, long value) {
    PFNGLUNIFORMHANDLEUI64ARBPROC.invoke(address("glUniformHandleui64ARB"), location, value);
  }

  public void glSpecializeShader(int shader, MemorySegment pEntryPoint, int numSpecializationConstants, MemorySegment pConstantIndex, MemorySegment pConstantValue) {
    PFNGLSPECIALIZESHADERPROC.invoke(address("glSpecializeShader"), shader, pEntryPoint, numSpecializationConstants, pConstantIndex, pConstantValue);
  }

  public void glVertexBlendEnvfATI(int pname, float param) {
    PFNGLVERTEXBLENDENVFATIPROC.invoke(address("glVertexBlendEnvfATI"), pname, param);
  }

  public void glProgramParameter4dNV(int target, int index, double x, double y, double z, double w) {
    PFNGLPROGRAMPARAMETER4DNVPROC.invoke(address("glProgramParameter4dNV"), target, index, x, y, z, w);
  }

  public void glObjectLabelKHR(int identifier, int name, int length, MemorySegment label) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetMultisamplefvNV(int pname, int index, MemorySegment val) {
    PFNGLGETMULTISAMPLEFVNVPROC.invoke(address("glGetMultisamplefvNV"), pname, index, val);
  }

  public void glEndQueryEXT(int target) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBindVertexArrayAPPLE(int array) {
    PFNGLBINDVERTEXARRAYAPPLEPROC.invoke(address("glBindVertexArrayAPPLE"), array);
  }

  public void glGetQueryBufferObjectuiv(int id, int buffer, int pname, long offset) {
    PFNGLGETQUERYBUFFEROBJECTUIVPROC.invoke(address("glGetQueryBufferObjectuiv"), id, buffer, pname, offset);
  }

  public void glUniform2iARB(int location, int v0, int v1) {
    PFNGLUNIFORM2IARBPROC.invoke(address("glUniform2iARB"), location, v0, v1);
  }

  public void glTexBufferRange(int target, int internalformat, int buffer, long offset, long size) {
    PFNGLTEXBUFFERRANGEPROC.invoke(address("glTexBufferRange"), target, internalformat, buffer, offset, size);
  }

  public void glProgramUniformMatrix4x3fvEXT(int program, int location, int count, byte transpose, MemorySegment value) {
    PFNGLPROGRAMUNIFORMMATRIX4X3FVEXTPROC.invoke(address("glProgramUniformMatrix4x3fvEXT"), program, location, count, transpose, value);
  }

  public void glSpriteParameteriSGIX(int pname, int param) {
    PFNGLSPRITEPARAMETERISGIXPROC.invoke(address("glSpriteParameteriSGIX"), pname, param);
  }

  public void glDrawArraysInstancedBaseInstance(int mode, int first, int count, int instancecount, int baseinstance) {
    PFNGLDRAWARRAYSINSTANCEDBASEINSTANCEPROC.invoke(address("glDrawArraysInstancedBaseInstance"), mode, first, count, instancecount, baseinstance);
  }

  public void glTexParameterIivOES(int target, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetRenderbufferParameterivEXT(int target, int pname, MemorySegment params) {
    PFNGLGETRENDERBUFFERPARAMETERIVEXTPROC.invoke(address("glGetRenderbufferParameterivEXT"), target, pname, params);
  }

  public void glGetUniformuivEXT(int program, int location, MemorySegment params) {
    PFNGLGETUNIFORMUIVEXTPROC.invoke(address("glGetUniformuivEXT"), program, location, params);
  }

  public void glVertexAttribL3ui64NV(int index, long x, long y, long z) {
    PFNGLVERTEXATTRIBL3UI64NVPROC.invoke(address("glVertexAttribL3ui64NV"), index, x, y, z);
  }

  public void glGetnHistogramARB(int target, byte reset, int format, int type, int bufSize, MemorySegment values) {
    PFNGLGETNHISTOGRAMARBPROC.invoke(address("glGetnHistogramARB"), target, reset, format, type, bufSize, values);
  }

  public void glSecondaryColor3iv(MemorySegment v) {
    PFNGLSECONDARYCOLOR3IVPROC.invoke(address("glSecondaryColor3iv"), v);
  }

  public void glWindowPos2dARB(double x, double y) {
    PFNGLWINDOWPOS2DARBPROC.invoke(address("glWindowPos2dARB"), x, y);
  }

  public byte glIsPointInStrokePathNV(int path, float x, float y) {
    return PFNGLISPOINTINSTROKEPATHNVPROC.invoke(address("glIsPointInStrokePathNV"), path, x, y);
  }

  public void glBlendFuncSeparateOES(int srcRGB, int dstRGB, int srcAlpha, int dstAlpha) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glReadBufferIndexedEXT(int src, int index) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetFramebufferParameterivEXT(int framebuffer, int pname, MemorySegment params) {
    PFNGLGETFRAMEBUFFERPARAMETERIVEXTPROC.invoke(address("glGetFramebufferParameterivEXT"), framebuffer, pname, params);
  }

  public void glProgramEnvParametersI4ivNV(int target, int index, int count, MemorySegment params) {
    PFNGLPROGRAMENVPARAMETERSI4IVNVPROC.invoke(address("glProgramEnvParametersI4ivNV"), target, index, count, params);
  }

  public void glGetNamedFramebufferAttachmentParameteriv(int framebuffer, int attachment, int pname, MemorySegment params) {
    PFNGLGETNAMEDFRAMEBUFFERATTACHMENTPARAMETERIVPROC.invoke(address("glGetNamedFramebufferAttachmentParameteriv"), framebuffer, attachment, pname, params);
  }

  public void glEndVideoCaptureNV(int video_capture_slot) {
    PFNGLENDVIDEOCAPTURENVPROC.invoke(address("glEndVideoCaptureNV"), video_capture_slot);
  }

  public void glMatrixLoaddEXT(int mode, MemorySegment m) {
    PFNGLMATRIXLOADDEXTPROC.invoke(address("glMatrixLoaddEXT"), mode, m);
  }

  public void glWindowPos3fARB(float x, float y, float z) {
    PFNGLWINDOWPOS3FARBPROC.invoke(address("glWindowPos3fARB"), x, y, z);
  }

  public void glWindowPos2svARB(MemorySegment v) {
    PFNGLWINDOWPOS2SVARBPROC.invoke(address("glWindowPos2svARB"), v);
  }

  public void glGetOcclusionQueryuivNV(int id, int pname, MemorySegment params) {
    PFNGLGETOCCLUSIONQUERYUIVNVPROC.invoke(address("glGetOcclusionQueryuivNV"), id, pname, params);
  }

  public void glGetTextureSubImage(int texture, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int format, int type, int bufSize, MemorySegment pixels) {
    PFNGLGETTEXTURESUBIMAGEPROC.invoke(address("glGetTextureSubImage"), texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, bufSize, pixels);
  }

  public void glVertexArrayNormalOffsetEXT(int vaobj, int buffer, int type, int stride, long offset) {
    PFNGLVERTEXARRAYNORMALOFFSETEXTPROC.invoke(address("glVertexArrayNormalOffsetEXT"), vaobj, buffer, type, stride, offset);
  }

  public void glGetTransformFeedbackVaryingEXT(int program, int index, int bufSize, MemorySegment length, MemorySegment size, MemorySegment type, MemorySegment name) {
    PFNGLGETTRANSFORMFEEDBACKVARYINGEXTPROC.invoke(address("glGetTransformFeedbackVaryingEXT"), program, index, bufSize, length, size, type, name);
  }

  public void glProvokingVertexEXT(int mode) {
    PFNGLPROVOKINGVERTEXEXTPROC.invoke(address("glProvokingVertexEXT"), mode);
  }

  public void glProgramUniform2ui64vNV(int program, int location, int count, MemorySegment value) {
    PFNGLPROGRAMUNIFORM2UI64VNVPROC.invoke(address("glProgramUniform2ui64vNV"), program, location, count, value);
  }

  public void glTrackMatrixNV(int target, int address, int matrix, int transform) {
    PFNGLTRACKMATRIXNVPROC.invoke(address("glTrackMatrixNV"), target, address, matrix, transform);
  }

  public void glTexCoord2fColor4fNormal3fVertex3fSUN(float s, float t, float r, float g, float b, float a, float nx, float ny, float nz, float x, float y, float z) {
    PFNGLTEXCOORD2FCOLOR4FNORMAL3FVERTEX3FSUNPROC.invoke(address("glTexCoord2fColor4fNormal3fVertex3fSUN"), s, t, r, g, b, a, nx, ny, nz, x, y, z);
  }

  public void glRasterPos2xOES(int x, int y) {
    PFNGLRASTERPOS2XOESPROC.invoke(address("glRasterPos2xOES"), x, y);
  }

  public void glVertexAttribL3i64vNV(int index, MemorySegment v) {
    PFNGLVERTEXATTRIBL3I64VNVPROC.invoke(address("glVertexAttribL3i64vNV"), index, v);
  }

  public void glResetHistogramEXT(int target) {
    PFNGLRESETHISTOGRAMEXTPROC.invoke(address("glResetHistogramEXT"), target);
  }

  public void glFlushRasterSGIX() {
    PFNGLFLUSHRASTERSGIXPROC.invoke(address("glFlushRasterSGIX"));
  }

  public void glGetCombinerInputParameterfvNV(int stage, int portion, int variable, int pname, MemorySegment params) {
    PFNGLGETCOMBINERINPUTPARAMETERFVNVPROC.invoke(address("glGetCombinerInputParameterfvNV"), stage, portion, variable, pname, params);
  }

  public void glMultiTexCoord3xOES(int texture, int s, int t, int r) {
    PFNGLMULTITEXCOORD3XOESPROC.invoke(address("glMultiTexCoord3xOES"), texture, s, t, r);
  }

  public void glSpriteParameterfSGIX(int pname, float param) {
    PFNGLSPRITEPARAMETERFSGIXPROC.invoke(address("glSpriteParameterfSGIX"), pname, param);
  }

  public void glGetVertexArrayiv(int vaobj, int pname, MemorySegment param) {
    PFNGLGETVERTEXARRAYIVPROC.invoke(address("glGetVertexArrayiv"), vaobj, pname, param);
  }

  public void glVertexAttribs3dvNV(int index, int count, MemorySegment v) {
    PFNGLVERTEXATTRIBS3DVNVPROC.invoke(address("glVertexAttribs3dvNV"), index, count, v);
  }

  public void glUniformHandleui64vNV(int location, int count, MemorySegment value) {
    PFNGLUNIFORMHANDLEUI64VNVPROC.invoke(address("glUniformHandleui64vNV"), location, count, value);
  }

  public void glVertexAttrib4Nubv(int index, MemorySegment v) {
    PFNGLVERTEXATTRIB4NUBVPROC.invoke(address("glVertexAttrib4Nubv"), index, v);
  }

  public void glVertexFormatNV(int size, int type, int stride) {
    PFNGLVERTEXFORMATNVPROC.invoke(address("glVertexFormatNV"), size, type, stride);
  }

  public long glGetTextureHandleIMG(int texture) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttrib4ubv(int index, MemorySegment v) {
    PFNGLVERTEXATTRIB4UBVPROC.invoke(address("glVertexAttrib4ubv"), index, v);
  }

  public void glMulticastFramebufferSampleLocationsfvNV(int gpu, int framebuffer, int start, int count, MemorySegment v) {
    PFNGLMULTICASTFRAMEBUFFERSAMPLELOCATIONSFVNVPROC.invoke(address("glMulticastFramebufferSampleLocationsfvNV"), gpu, framebuffer, start, count, v);
  }

  public int glGetProgramResourceIndex(int program, int programInterface, MemorySegment name) {
    return PFNGLGETPROGRAMRESOURCEINDEXPROC.invoke(address("glGetProgramResourceIndex"), program, programInterface, name);
  }

  public void glProgramEnvParametersI4uivNV(int target, int index, int count, MemorySegment params) {
    PFNGLPROGRAMENVPARAMETERSI4UIVNVPROC.invoke(address("glProgramEnvParametersI4uivNV"), target, index, count, params);
  }

  public void glProgramParameter4fNV(int target, int index, float x, float y, float z, float w) {
    PFNGLPROGRAMPARAMETER4FNVPROC.invoke(address("glProgramParameter4fNV"), target, index, x, y, z, w);
  }

  public void glMultiTexParameterfvEXT(int texunit, int target, int pname, MemorySegment params) {
    PFNGLMULTITEXPARAMETERFVEXTPROC.invoke(address("glMultiTexParameterfvEXT"), texunit, target, pname, params);
  }

  public void glMultiTexCoord3bOES(int texture, byte s, byte t, byte r) {
    PFNGLMULTITEXCOORD3BOESPROC.invoke(address("glMultiTexCoord3bOES"), texture, s, t, r);
  }

  public void glGetTextureParameterIuiv(int texture, int pname, MemorySegment params) {
    PFNGLGETTEXTUREPARAMETERIUIVPROC.invoke(address("glGetTextureParameterIuiv"), texture, pname, params);
  }

  public int glQueryMatrixxOES(MemorySegment mantissa, MemorySegment exponent) {
    return PFNGLQUERYMATRIXXOESPROC.invoke(address("glQueryMatrixxOES"), mantissa, exponent);
  }

  public void glVertexP3ui(int type, int value) {
    PFNGLVERTEXP3UIPROC.invoke(address("glVertexP3ui"), type, value);
  }

  public void glGetPathMetricRangeNV(int metricQueryMask, int firstPathName, int numPaths, int stride, MemorySegment metrics) {
    PFNGLGETPATHMETRICRANGENVPROC.invoke(address("glGetPathMetricRangeNV"), metricQueryMask, firstPathName, numPaths, stride, metrics);
  }

  public void glMultiTexBufferEXT(int texunit, int target, int internalformat, int buffer) {
    PFNGLMULTITEXBUFFEREXTPROC.invoke(address("glMultiTexBufferEXT"), texunit, target, internalformat, buffer);
  }

  public void glGetnPolygonStippleARB(int bufSize, MemorySegment pattern) {
    PFNGLGETNPOLYGONSTIPPLEARBPROC.invoke(address("glGetnPolygonStippleARB"), bufSize, pattern);
  }

  public void glMultiTexCoord3hNV(int target, short s, short t, short r) {
    PFNGLMULTITEXCOORD3HNVPROC.invoke(address("glMultiTexCoord3hNV"), target, s, t, r);
  }

  public void glAlphaToCoverageDitherControlNV(int mode) {
    PFNGLALPHATOCOVERAGEDITHERCONTROLNVPROC.invoke(address("glAlphaToCoverageDitherControlNV"), mode);
  }

  public void glVertexAttribIFormat(int attribindex, int size, int type, int relativeoffset) {
    PFNGLVERTEXATTRIBIFORMATPROC.invoke(address("glVertexAttribIFormat"), attribindex, size, type, relativeoffset);
  }

  public void glUniform2d(int location, double x, double y) {
    PFNGLUNIFORM2DPROC.invoke(address("glUniform2d"), location, x, y);
  }

  public void glPixelZoomxOES(int xfactor, int yfactor) {
    PFNGLPIXELZOOMXOESPROC.invoke(address("glPixelZoomxOES"), xfactor, yfactor);
  }

  public void glUniform2f(int location, float v0, float v1) {
    PFNGLUNIFORM2FPROC.invoke(address("glUniform2f"), location, v0, v1);
  }

  public void glVertexAttrib4ubvARB(int index, MemorySegment v) {
    PFNGLVERTEXATTRIB4UBVARBPROC.invoke(address("glVertexAttrib4ubvARB"), index, v);
  }

  public void glColor4hvNV(MemorySegment v) {
    PFNGLCOLOR4HVNVPROC.invoke(address("glColor4hvNV"), v);
  }

  public void glUniform2i(int location, int v0, int v1) {
    PFNGLUNIFORM2IPROC.invoke(address("glUniform2i"), location, v0, v1);
  }

  public void glEnableDriverControlQCOM(int driverControl) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFragmentMaterialiSGIX(int face, int pname, int param) {
    PFNGLFRAGMENTMATERIALISGIXPROC.invoke(address("glFragmentMaterialiSGIX"), face, pname, param);
  }

  public void glGetVertexAttribPointervARB(int index, int pname, MemorySegment pointer) {
    PFNGLGETVERTEXATTRIBPOINTERVARBPROC.invoke(address("glGetVertexAttribPointervARB"), index, pname, pointer);
  }

  public MemorySegment glMapTexture2DINTEL(int texture, int level, int access, MemorySegment stride, MemorySegment layout) {
    return PFNGLMAPTEXTURE2DINTELPROC.invoke(address("glMapTexture2DINTEL"), texture, level, access, stride, layout);
  }

  public void glProgramUniform4ui(int program, int location, int v0, int v1, int v2, int v3) {
    PFNGLPROGRAMUNIFORM4UIPROC.invoke(address("glProgramUniform4ui"), program, location, v0, v1, v2, v3);
  }

  public void glGenBuffersARB(int n, MemorySegment buffers) {
    PFNGLGENBUFFERSARBPROC.invoke(address("glGenBuffersARB"), n, buffers);
  }

  public void glVertexAttribP2uiv(int index, int type, byte normalized, MemorySegment value) {
    PFNGLVERTEXATTRIBP2UIVPROC.invoke(address("glVertexAttribP2uiv"), index, type, normalized, value);
  }

  public void glUniform3d(int location, double x, double y, double z) {
    PFNGLUNIFORM3DPROC.invoke(address("glUniform3d"), location, x, y, z);
  }

  public void glClientActiveVertexStreamATI(int stream) {
    PFNGLCLIENTACTIVEVERTEXSTREAMATIPROC.invoke(address("glClientActiveVertexStreamATI"), stream);
  }

  public void glUniform3f(int location, float v0, float v1, float v2) {
    PFNGLUNIFORM3FPROC.invoke(address("glUniform3f"), location, v0, v1, v2);
  }

  public void glUniform2fv(int location, int count, MemorySegment value) {
    PFNGLUNIFORM2FVPROC.invoke(address("glUniform2fv"), location, count, value);
  }

  public void glUniform3i(int location, int v0, int v1, int v2) {
    PFNGLUNIFORM3IPROC.invoke(address("glUniform3i"), location, v0, v1, v2);
  }

  public void glSecondaryColor3fv(MemorySegment v) {
    PFNGLSECONDARYCOLOR3FVPROC.invoke(address("glSecondaryColor3fv"), v);
  }

  public void glDrawElementsInstancedNV(int mode, int count, int type, MemorySegment indices, int primcount) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniform4d(int location, double x, double y, double z, double w) {
    PFNGLUNIFORM4DPROC.invoke(address("glUniform4d"), location, x, y, z, w);
  }

  public void glCopyTextureImage2DEXT(int texture, int target, int level, int internalformat, int x, int y, int width, int height, int border) {
    PFNGLCOPYTEXTUREIMAGE2DEXTPROC.invoke(address("glCopyTextureImage2DEXT"), texture, target, level, internalformat, x, y, width, height, border);
  }

  public void glProgramUniform3ivEXT(int program, int location, int count, MemorySegment value) {
    PFNGLPROGRAMUNIFORM3IVEXTPROC.invoke(address("glProgramUniform3ivEXT"), program, location, count, value);
  }

  public byte glIsQueryEXT(int id) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glStateCaptureNV(int state, int mode) {
    PFNGLSTATECAPTURENVPROC.invoke(address("glStateCaptureNV"), state, mode);
  }

  public void glGetQueryIndexediv(int target, int index, int pname, MemorySegment params) {
    PFNGLGETQUERYINDEXEDIVPROC.invoke(address("glGetQueryIndexediv"), target, index, pname, params);
  }

  public void glWindowPos3svMESA(MemorySegment v) {
    PFNGLWINDOWPOS3SVMESAPROC.invoke(address("glWindowPos3svMESA"), v);
  }

  public void glEvalCoord2xOES(int u, int v) {
    PFNGLEVALCOORD2XOESPROC.invoke(address("glEvalCoord2xOES"), u, v);
  }

  public void glGetActiveSubroutineUniformName(int program, int shadertype, int index, int bufSize, MemorySegment length, MemorySegment name) {
    PFNGLGETACTIVESUBROUTINEUNIFORMNAMEPROC.invoke(address("glGetActiveSubroutineUniformName"), program, shadertype, index, bufSize, length, name);
  }

  public void glTexBumpParameterfvATI(int pname, MemorySegment param) {
    PFNGLTEXBUMPPARAMETERFVATIPROC.invoke(address("glTexBumpParameterfvATI"), pname, param);
  }

  public void glUniform1i64ARB(int location, long x) {
    PFNGLUNIFORM1I64ARBPROC.invoke(address("glUniform1i64ARB"), location, x);
  }

  public void glGetObjectParameterfvARB(int obj, int pname, MemorySegment params) {
    PFNGLGETOBJECTPARAMETERFVARBPROC.invoke(address("glGetObjectParameterfvARB"), obj, pname, params);
  }

  public void glUniform2iv(int location, int count, MemorySegment value) {
    PFNGLUNIFORM2IVPROC.invoke(address("glUniform2iv"), location, count, value);
  }

  public void glBindFragDataLocationIndexed(int program, int colorNumber, int index, MemorySegment name) {
    PFNGLBINDFRAGDATALOCATIONINDEXEDPROC.invoke(address("glBindFragDataLocationIndexed"), program, colorNumber, index, name);
  }

  public void glProgramUniform2ivEXT(int program, int location, int count, MemorySegment value) {
    PFNGLPROGRAMUNIFORM2IVEXTPROC.invoke(address("glProgramUniform2ivEXT"), program, location, count, value);
  }

  public void glVertexWeighthvNV(MemorySegment weight) {
    PFNGLVERTEXWEIGHTHVNVPROC.invoke(address("glVertexWeighthvNV"), weight);
  }

  public void glGetQueryBufferObjecti64v(int id, int buffer, int pname, long offset) {
    PFNGLGETQUERYBUFFEROBJECTI64VPROC.invoke(address("glGetQueryBufferObjecti64v"), id, buffer, pname, offset);
  }

  public void glReplacementCodeuiVertex3fSUN(int rc, float x, float y, float z) {
    PFNGLREPLACEMENTCODEUIVERTEX3FSUNPROC.invoke(address("glReplacementCodeuiVertex3fSUN"), rc, x, y, z);
  }

  public void glClipPlanexOES(int plane, MemorySegment equation) {
    PFNGLCLIPPLANEXOESPROC.invoke(address("glClipPlanexOES"), plane, equation);
  }

  public void glVertexAttrib1dNV(int index, double x) {
    PFNGLVERTEXATTRIB1DNVPROC.invoke(address("glVertexAttrib1dNV"), index, x);
  }

  public void glUniform1uiEXT(int location, int v0) {
    PFNGLUNIFORM1UIEXTPROC.invoke(address("glUniform1uiEXT"), location, v0);
  }

  public void glStencilThenCoverStrokePathInstancedNV(int numPaths, int pathNameType, MemorySegment paths, int pathBase, int reference, int mask, int coverMode, int transformType, MemorySegment transformValues) {
    PFNGLSTENCILTHENCOVERSTROKEPATHINSTANCEDNVPROC.invoke(address("glStencilThenCoverStrokePathInstancedNV"), numPaths, pathNameType, paths, pathBase, reference, mask, coverMode, transformType, transformValues);
  }

  public void glPrimitiveRestartIndexNV(int index) {
    PFNGLPRIMITIVERESTARTINDEXNVPROC.invoke(address("glPrimitiveRestartIndexNV"), index);
  }

  public void glPointParameterxOES(int pname, int param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniform1d(int location, double x) {
    PFNGLUNIFORM1DPROC.invoke(address("glUniform1d"), location, x);
  }

  public void glTextureParameteri(int texture, int pname, int param) {
    PFNGLTEXTUREPARAMETERIPROC.invoke(address("glTextureParameteri"), texture, pname, param);
  }

  public void glUniform1f(int location, float v0) {
    PFNGLUNIFORM1FPROC.invoke(address("glUniform1f"), location, v0);
  }

  public void glDisablei(int target, int index) {
    PFNGLDISABLEIPROC.invoke(address("glDisablei"), target, index);
  }

  public void glTextureParameterf(int texture, int pname, float param) {
    PFNGLTEXTUREPARAMETERFPROC.invoke(address("glTextureParameterf"), texture, pname, param);
  }

  public void glUniform1i(int location, int v0) {
    PFNGLUNIFORM1IPROC.invoke(address("glUniform1i"), location, v0);
  }

  public void glBindBuffersBase(int target, int first, int count, MemorySegment buffers) {
    PFNGLBINDBUFFERSBASEPROC.invoke(address("glBindBuffersBase"), target, first, count, buffers);
  }

  public void glExtGetBufferPointervQCOM(int target, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public byte glIsEnablediOES(int target, int index) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetCompressedMultiTexImageEXT(int texunit, int target, int lod, MemorySegment img) {
    PFNGLGETCOMPRESSEDMULTITEXIMAGEEXTPROC.invoke(address("glGetCompressedMultiTexImageEXT"), texunit, target, lod, img);
  }

  public void glVertexAttrib4NubARB(int index, byte x, byte y, byte z, byte w) {
    PFNGLVERTEXATTRIB4NUBARBPROC.invoke(address("glVertexAttrib4NubARB"), index, x, y, z, w);
  }

  public void glGetnConvolutionFilter(int target, int format, int type, int bufSize, MemorySegment image) {
    PFNGLGETNCONVOLUTIONFILTERPROC.invoke(address("glGetnConvolutionFilter"), target, format, type, bufSize, image);
  }

  public void glMatrixIndexusvARB(int size, MemorySegment indices) {
    PFNGLMATRIXINDEXUSVARBPROC.invoke(address("glMatrixIndexusvARB"), size, indices);
  }

  public void glVertexAttribI4i(int index, int x, int y, int z, int w) {
    PFNGLVERTEXATTRIBI4IPROC.invoke(address("glVertexAttribI4i"), index, x, y, z, w);
  }

  public void glTextureStorage2DMultisample(int texture, int samples, int internalformat, int width, int height, byte fixedsamplelocations) {
    PFNGLTEXTURESTORAGE2DMULTISAMPLEPROC.invoke(address("glTextureStorage2DMultisample"), texture, samples, internalformat, width, height, fixedsamplelocations);
  }

  public MemorySegment glMapNamedBuffer(int buffer, int access) {
    return PFNGLMAPNAMEDBUFFERPROC.invoke(address("glMapNamedBuffer"), buffer, access);
  }

  public void glGetFloati_vEXT(int pname, int index, MemorySegment params) {
    PFNGLGETFLOATI_VEXTPROC.invoke(address("glGetFloati_vEXT"), pname, index, params);
  }

  public void glGetObjectLabel(int identifier, int name, int bufSize, MemorySegment length, MemorySegment label) {
    PFNGLGETOBJECTLABELPROC.invoke(address("glGetObjectLabel"), identifier, name, bufSize, length, label);
  }

  public void glGetPerfQueryIdByNameINTEL(MemorySegment queryName, MemorySegment queryId) {
    PFNGLGETPERFQUERYIDBYNAMEINTELPROC.invoke(address("glGetPerfQueryIdByNameINTEL"), queryName, queryId);
  }

  public void glSecondaryColor3bv(MemorySegment v) {
    PFNGLSECONDARYCOLOR3BVPROC.invoke(address("glSecondaryColor3bv"), v);
  }

  public void glMultiDrawArraysIndirectEXT(int mode, MemorySegment indirect, int drawcount, int stride) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDrawElementArrayATI(int mode, int count) {
    PFNGLDRAWELEMENTARRAYATIPROC.invoke(address("glDrawElementArrayATI"), mode, count);
  }

  public void glMemoryBarrier(int barriers) {
    PFNGLMEMORYBARRIERPROC.invoke(address("glMemoryBarrier"), barriers);
  }

  public void glUniform1uiv(int location, int count, MemorySegment value) {
    PFNGLUNIFORM1UIVPROC.invoke(address("glUniform1uiv"), location, count, value);
  }

  public void glGetnPolygonStipple(int bufSize, MemorySegment pattern) {
    PFNGLGETNPOLYGONSTIPPLEPROC.invoke(address("glGetnPolygonStipple"), bufSize, pattern);
  }

  public void glVertexAttribDivisorEXT(int index, int divisor) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMapBufferOES(int target, int access) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTextureStorageSparseAMD(int texture, int target, int internalFormat, int width, int height, int depth, int layers, int flags) {
    PFNGLTEXTURESTORAGESPARSEAMDPROC.invoke(address("glTextureStorageSparseAMD"), texture, target, internalFormat, width, height, depth, layers, flags);
  }

  public void glFogCoordhvNV(MemorySegment fog) {
    PFNGLFOGCOORDHVNVPROC.invoke(address("glFogCoordhvNV"), fog);
  }

  public void glSamplerParameterIuiv(int sampler, int pname, MemorySegment param) {
    PFNGLSAMPLERPARAMETERIUIVPROC.invoke(address("glSamplerParameterIuiv"), sampler, pname, param);
  }

  public void glDeleteFragmentShaderATI(int id) {
    PFNGLDELETEFRAGMENTSHADERATIPROC.invoke(address("glDeleteFragmentShaderATI"), id);
  }

  public void glVertexAttribI2i(int index, int x, int y) {
    PFNGLVERTEXATTRIBI2IPROC.invoke(address("glVertexAttribI2i"), index, x, y);
  }

  public void glDeleteSync(MemorySegment sync) {
    PFNGLDELETESYNCPROC.invoke(address("glDeleteSync"), sync);
  }

  public byte glIsNamedStringARB(int namelen, MemorySegment name) {
    return PFNGLISNAMEDSTRINGARBPROC.invoke(address("glIsNamedStringARB"), namelen, name);
  }

  public float glGetPathLengthNV(int path, int startSegment, int numSegments) {
    return PFNGLGETPATHLENGTHNVPROC.invoke(address("glGetPathLengthNV"), path, startSegment, numSegments);
  }

  public void glBindFramebufferOES(int target, int framebuffer) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glActiveVaryingNV(int program, MemorySegment name) {
    PFNGLACTIVEVARYINGNVPROC.invoke(address("glActiveVaryingNV"), program, name);
  }

  public void glUniform2dv(int location, int count, MemorySegment value) {
    PFNGLUNIFORM2DVPROC.invoke(address("glUniform2dv"), location, count, value);
  }

  public void glNamedProgramLocalParameterI4ivEXT(int program, int target, int index, MemorySegment params) {
    PFNGLNAMEDPROGRAMLOCALPARAMETERI4IVEXTPROC.invoke(address("glNamedProgramLocalParameterI4ivEXT"), program, target, index, params);
  }

  public void glSecondaryColor3dv(MemorySegment v) {
    PFNGLSECONDARYCOLOR3DVPROC.invoke(address("glSecondaryColor3dv"), v);
  }

  public void glTexBufferRangeOES(int target, int internalformat, int buffer, long offset, long size) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFramebufferTexture2DDownsampleIMG(int target, int attachment, int textarget, int texture, int level, int xscale, int yscale) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniform1ivARB(int location, int count, MemorySegment value) {
    PFNGLUNIFORM1IVARBPROC.invoke(address("glUniform1ivARB"), location, count, value);
  }

  public void glColorP4ui(int type, int color) {
    PFNGLCOLORP4UIPROC.invoke(address("glColorP4ui"), type, color);
  }

  public void glCompressedMultiTexSubImage1DEXT(int texunit, int target, int level, int xoffset, int width, int format, int imageSize, MemorySegment bits) {
    PFNGLCOMPRESSEDMULTITEXSUBIMAGE1DEXTPROC.invoke(address("glCompressedMultiTexSubImage1DEXT"), texunit, target, level, xoffset, width, format, imageSize, bits);
  }

  public void glVertexAttrib4uiv(int index, MemorySegment v) {
    PFNGLVERTEXATTRIB4UIVPROC.invoke(address("glVertexAttrib4uiv"), index, v);
  }

  public void glVertexAttribI3i(int index, int x, int y, int z) {
    PFNGLVERTEXATTRIBI3IPROC.invoke(address("glVertexAttribI3i"), index, x, y, z);
  }

  public void glGetPerfMonitorCounterDataAMD(int monitor, int pname, int dataSize, MemorySegment data, MemorySegment bytesWritten) {
    PFNGLGETPERFMONITORCOUNTERDATAAMDPROC.invoke(address("glGetPerfMonitorCounterDataAMD"), monitor, pname, dataSize, data, bytesWritten);
  }

  public void glBindProgramNV(int target, int id) {
    PFNGLBINDPROGRAMNVPROC.invoke(address("glBindProgramNV"), target, id);
  }

  public void glDeleteSamplers(int count, MemorySegment samplers) {
    PFNGLDELETESAMPLERSPROC.invoke(address("glDeleteSamplers"), count, samplers);
  }

  public void glGetProgramEnvParameterIivNV(int target, int index, MemorySegment params) {
    PFNGLGETPROGRAMENVPARAMETERIIVNVPROC.invoke(address("glGetProgramEnvParameterIivNV"), target, index, params);
  }

  public void glClearColorIuiEXT(int red, int green, int blue, int alpha) {
    PFNGLCLEARCOLORIUIEXTPROC.invoke(address("glClearColorIuiEXT"), red, green, blue, alpha);
  }

  public void glVertexAttribs4fvNV(int index, int count, MemorySegment v) {
    PFNGLVERTEXATTRIBS4FVNVPROC.invoke(address("glVertexAttribs4fvNV"), index, count, v);
  }

  public void glProgramUniformMatrix3x4dv(int program, int location, int count, byte transpose, MemorySegment value) {
    PFNGLPROGRAMUNIFORMMATRIX3X4DVPROC.invoke(address("glProgramUniformMatrix3x4dv"), program, location, count, transpose, value);
  }

  public void glUniformHandleui64vARB(int location, int count, MemorySegment value) {
    PFNGLUNIFORMHANDLEUI64VARBPROC.invoke(address("glUniformHandleui64vARB"), location, count, value);
  }

  public void glVideoCaptureStreamParameterfvNV(int video_capture_slot, int stream, int pname, MemorySegment params) {
    PFNGLVIDEOCAPTURESTREAMPARAMETERFVNVPROC.invoke(address("glVideoCaptureStreamParameterfvNV"), video_capture_slot, stream, pname, params);
  }

  public void glPathTexGenNV(int texCoordSet, int genMode, int components, MemorySegment coeffs) {
    PFNGLPATHTEXGENNVPROC.invoke(address("glPathTexGenNV"), texCoordSet, genMode, components, coeffs);
  }

  public void glImageTransformParameterfHP(int target, int pname, float param) {
    PFNGLIMAGETRANSFORMPARAMETERFHPPROC.invoke(address("glImageTransformParameterfHP"), target, pname, param);
  }

  public void glNormal3xvOES(MemorySegment coords) {
    PFNGLNORMAL3XVOESPROC.invoke(address("glNormal3xvOES"), coords);
  }

  public void glProgramUniform4dvEXT(int program, int location, int count, MemorySegment value) {
    PFNGLPROGRAMUNIFORM4DVEXTPROC.invoke(address("glProgramUniform4dvEXT"), program, location, count, value);
  }

  public void glGetTexGenfvOES(int coord, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glPixelDataRangeNV(int target, int length, MemorySegment pointer) {
    PFNGLPIXELDATARANGENVPROC.invoke(address("glPixelDataRangeNV"), target, length, pointer);
  }

  public void glPointParameterfvARB(int pname, MemorySegment params) {
    PFNGLPOINTPARAMETERFVARBPROC.invoke(address("glPointParameterfvARB"), pname, params);
  }

  public void glVertexAttribLPointer(int index, int size, int type, int stride, MemorySegment pointer) {
    PFNGLVERTEXATTRIBLPOINTERPROC.invoke(address("glVertexAttribLPointer"), index, size, type, stride, pointer);
  }

  public void glGetPerfQueryDataINTEL(int queryHandle, int flags, int dataSize, MemorySegment data, MemorySegment bytesWritten) {
    PFNGLGETPERFQUERYDATAINTELPROC.invoke(address("glGetPerfQueryDataINTEL"), queryHandle, flags, dataSize, data, bytesWritten);
  }

  public void glGetMapParameterfvNV(int target, int pname, MemorySegment params) {
    PFNGLGETMAPPARAMETERFVNVPROC.invoke(address("glGetMapParameterfvNV"), target, pname, params);
  }

  public void glGetMinmaxParameterfvEXT(int target, int pname, MemorySegment params) {
    PFNGLGETMINMAXPARAMETERFVEXTPROC.invoke(address("glGetMinmaxParameterfvEXT"), target, pname, params);
  }

  public void glBindFragmentShaderATI(int id) {
    PFNGLBINDFRAGMENTSHADERATIPROC.invoke(address("glBindFragmentShaderATI"), id);
  }

  public void glVertexAttribI1i(int index, int x) {
    PFNGLVERTEXATTRIBI1IPROC.invoke(address("glVertexAttribI1i"), index, x);
  }

  public void glVertexAttrib3sNV(int index, short x, short y, short z) {
    PFNGLVERTEXATTRIB3SNVPROC.invoke(address("glVertexAttrib3sNV"), index, x, y, z);
  }

  public void glVertexAttrib3fvARB(int index, MemorySegment v) {
    PFNGLVERTEXATTRIB3FVARBPROC.invoke(address("glVertexAttrib3fvARB"), index, v);
  }

  public void glProgramUniform4ui64vARB(int program, int location, int count, MemorySegment value) {
    PFNGLPROGRAMUNIFORM4UI64VARBPROC.invoke(address("glProgramUniform4ui64vARB"), program, location, count, value);
  }

  public void glProgramBinary(int program, int binaryFormat, MemorySegment binary, int length) {
    PFNGLPROGRAMBINARYPROC.invoke(address("glProgramBinary"), program, binaryFormat, binary, length);
  }

  public void glUniformMatrix2fvARB(int location, int count, byte transpose, MemorySegment value) {
    PFNGLUNIFORMMATRIX2FVARBPROC.invoke(address("glUniformMatrix2fvARB"), location, count, transpose, value);
  }

  public void glVertexAttribP2ui(int index, int type, byte normalized, int value) {
    PFNGLVERTEXATTRIBP2UIPROC.invoke(address("glVertexAttribP2ui"), index, type, normalized, value);
  }

  public void glFogCoordfEXT(float coord) {
    PFNGLFOGCOORDFEXTPROC.invoke(address("glFogCoordfEXT"), coord);
  }

  public void glVertexStream4fvATI(int stream, MemorySegment coords) {
    PFNGLVERTEXSTREAM4FVATIPROC.invoke(address("glVertexStream4fvATI"), stream, coords);
  }

  public void glProgramEnvParameter4fARB(int target, int index, float x, float y, float z, float w) {
    PFNGLPROGRAMENVPARAMETER4FARBPROC.invoke(address("glProgramEnvParameter4fARB"), target, index, x, y, z, w);
  }

  public void glSecondaryColor3usEXT(short red, short green, short blue) {
    PFNGLSECONDARYCOLOR3USEXTPROC.invoke(address("glSecondaryColor3usEXT"), red, green, blue);
  }

  public void glCommandListSegmentsNV(int list, int segments) {
    PFNGLCOMMANDLISTSEGMENTSNVPROC.invoke(address("glCommandListSegmentsNV"), list, segments);
  }

  public void glMakeTextureHandleNonResidentARB(long handle) {
    PFNGLMAKETEXTUREHANDLENONRESIDENTARBPROC.invoke(address("glMakeTextureHandleNonResidentARB"), handle);
  }

  public void glDrawTexsOES(short x, short y, short z, short width, short height) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public byte glUnmapBufferOES(int target) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertex4bvOES(MemorySegment coords) {
    PFNGLVERTEX4BVOESPROC.invoke(address("glVertex4bvOES"), coords);
  }

  public void glWindowPos2dvARB(MemorySegment v) {
    PFNGLWINDOWPOS2DVARBPROC.invoke(address("glWindowPos2dvARB"), v);
  }

  public void glCompressedTexSubImage3DARB(int target, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int format, int imageSize, MemorySegment data) {
    PFNGLCOMPRESSEDTEXSUBIMAGE3DARBPROC.invoke(address("glCompressedTexSubImage3DARB"), target, level, xoffset, yoffset, zoffset, width, height, depth, format, imageSize, data);
  }

  public void glDrawElementsIndirect(int mode, int type, MemorySegment indirect) {
    PFNGLDRAWELEMENTSINDIRECTPROC.invoke(address("glDrawElementsIndirect"), mode, type, indirect);
  }

  public void glReplacementCodeusSUN(short code) {
    PFNGLREPLACEMENTCODEUSSUNPROC.invoke(address("glReplacementCodeusSUN"), code);
  }

  public void glUniformMatrix2x4fvNV(int location, int count, byte transpose, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBindBufferOffsetEXT(int target, int index, int buffer, long offset) {
    PFNGLBINDBUFFEROFFSETEXTPROC.invoke(address("glBindBufferOffsetEXT"), target, index, buffer, offset);
  }

  public void glExtGetTexturesQCOM(MemorySegment textures, int maxTextures, MemorySegment numTextures) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glScissorArrayvOES(int first, int count, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glRasterPos4xvOES(MemorySegment coords) {
    PFNGLRASTERPOS4XVOESPROC.invoke(address("glRasterPos4xvOES"), coords);
  }

  public void glVertexArrayVertexAttribIOffsetEXT(int vaobj, int buffer, int index, int size, int type, int stride, long offset) {
    PFNGLVERTEXARRAYVERTEXATTRIBIOFFSETEXTPROC.invoke(address("glVertexArrayVertexAttribIOffsetEXT"), vaobj, buffer, index, size, type, stride, offset);
  }

  public void glGetMinmaxEXT(int target, byte reset, int format, int type, MemorySegment values) {
    PFNGLGETMINMAXEXTPROC.invoke(address("glGetMinmaxEXT"), target, reset, format, type, values);
  }

  public void glGetPathColorGenfvNV(int color, int pname, MemorySegment value) {
    PFNGLGETPATHCOLORGENFVNVPROC.invoke(address("glGetPathColorGenfvNV"), color, pname, value);
  }

  public void glWindowPos4dMESA(double x, double y, double z, double w) {
    PFNGLWINDOWPOS4DMESAPROC.invoke(address("glWindowPos4dMESA"), x, y, z, w);
  }

  public void glVertexAttribL4ui64vNV(int index, MemorySegment v) {
    PFNGLVERTEXATTRIBL4UI64VNVPROC.invoke(address("glVertexAttribL4ui64vNV"), index, v);
  }

  public void glBlendFuncSeparatei(int buf, int srcRGB, int dstRGB, int srcAlpha, int dstAlpha) {
    PFNGLBLENDFUNCSEPARATEIPROC.invoke(address("glBlendFuncSeparatei"), buf, srcRGB, dstRGB, srcAlpha, dstAlpha);
  }

  public void glCreateProgramPipelines(int n, MemorySegment pipelines) {
    PFNGLCREATEPROGRAMPIPELINESPROC.invoke(address("glCreateProgramPipelines"), n, pipelines);
  }

  public void glFogxOES(int pname, int param) {
    PFNGLFOGXOESPROC.invoke(address("glFogxOES"), pname, param);
  }

  public void glTexImage2DMultisample(int target, int samples, int internalformat, int width, int height, byte fixedsamplelocations) {
    PFNGLTEXIMAGE2DMULTISAMPLEPROC.invoke(address("glTexImage2DMultisample"), target, samples, internalformat, width, height, fixedsamplelocations);
  }

  public int glObjectPurgeableAPPLE(int objectType, int name, int option) {
    return PFNGLOBJECTPURGEABLEAPPLEPROC.invoke(address("glObjectPurgeableAPPLE"), objectType, name, option);
  }

  public void glViewportSwizzleNV(int index, int swizzlex, int swizzley, int swizzlez, int swizzlew) {
    PFNGLVIEWPORTSWIZZLENVPROC.invoke(address("glViewportSwizzleNV"), index, swizzlex, swizzley, swizzlez, swizzlew);
  }

  public void glDisableClientStateiEXT(int array, int index) {
    PFNGLDISABLECLIENTSTATEIEXTPROC.invoke(address("glDisableClientStateiEXT"), array, index);
  }

  public void glGetShadingRateImagePaletteNV(int viewport, int entry, MemorySegment rate) {
    PFNGLGETSHADINGRATEIMAGEPALETTENVPROC.invoke(address("glGetShadingRateImagePaletteNV"), viewport, entry, rate);
  }

  public void glVertexAttribL1i64NV(int index, long x) {
    PFNGLVERTEXATTRIBL1I64NVPROC.invoke(address("glVertexAttribL1i64NV"), index, x);
  }

  public void glTextureSubImage2DEXT(int texture, int target, int level, int xoffset, int yoffset, int width, int height, int format, int type, MemorySegment pixels) {
    PFNGLTEXTURESUBIMAGE2DEXTPROC.invoke(address("glTextureSubImage2DEXT"), texture, target, level, xoffset, yoffset, width, height, format, type, pixels);
  }

  public void glFragmentLightfSGIX(int light, int pname, float param) {
    PFNGLFRAGMENTLIGHTFSGIXPROC.invoke(address("glFragmentLightfSGIX"), light, pname, param);
  }

  public void glGlobalAlphaFactorbSUN(byte factor) {
    PFNGLGLOBALALPHAFACTORBSUNPROC.invoke(address("glGlobalAlphaFactorbSUN"), factor);
  }

  public void glVertexStream3iATI(int stream, int x, int y, int z) {
    PFNGLVERTEXSTREAM3IATIPROC.invoke(address("glVertexStream3iATI"), stream, x, y, z);
  }

  public int glBindParameterEXT(int value) {
    return PFNGLBINDPARAMETEREXTPROC.invoke(address("glBindParameterEXT"), value);
  }

  public void glDrawElementsBaseVertexEXT(int mode, int count, int type, MemorySegment indices, int basevertex) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexArrayRangeAPPLE(int length, MemorySegment pointer) {
    PFNGLVERTEXARRAYRANGEAPPLEPROC.invoke(address("glVertexArrayRangeAPPLE"), length, pointer);
  }

  public void glGetColorTableParameterfvEXT(int target, int pname, MemorySegment params) {
    PFNGLGETCOLORTABLEPARAMETERFVEXTPROC.invoke(address("glGetColorTableParameterfvEXT"), target, pname, params);
  }

  public void glRasterSamplesEXT(int samples, byte fixedsamplelocations) {
    PFNGLRASTERSAMPLESEXTPROC.invoke(address("glRasterSamplesEXT"), samples, fixedsamplelocations);
  }

  public void glNormalStream3dATI(int stream, double nx, double ny, double nz) {
    PFNGLNORMALSTREAM3DATIPROC.invoke(address("glNormalStream3dATI"), stream, nx, ny, nz);
  }

  public void glProgramUniform4i64NV(int program, int location, long x, long y, long z, long w) {
    PFNGLPROGRAMUNIFORM4I64NVPROC.invoke(address("glProgramUniform4i64NV"), program, location, x, y, z, w);
  }

  public void glGetVertexAttribdvNV(int index, int pname, MemorySegment params) {
    PFNGLGETVERTEXATTRIBDVNVPROC.invoke(address("glGetVertexAttribdvNV"), index, pname, params);
  }

  public void glUniform2ui64ARB(int location, long x, long y) {
    PFNGLUNIFORM2UI64ARBPROC.invoke(address("glUniform2ui64ARB"), location, x, y);
  }

  public void glGetProgramLocalParameterdvARB(int target, int index, MemorySegment params) {
    PFNGLGETPROGRAMLOCALPARAMETERDVARBPROC.invoke(address("glGetProgramLocalParameterdvARB"), target, index, params);
  }

  public byte glIsSyncAPPLE(MemorySegment sync) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttrib4usv(int index, MemorySegment v) {
    PFNGLVERTEXATTRIB4USVPROC.invoke(address("glVertexAttrib4usv"), index, v);
  }

  public void glGetQueryObjectuivARB(int id, int pname, MemorySegment params) {
    PFNGLGETQUERYOBJECTUIVARBPROC.invoke(address("glGetQueryObjectuivARB"), id, pname, params);
  }

  public void glFogFuncSGIS(int n, MemorySegment points) {
    PFNGLFOGFUNCSGISPROC.invoke(address("glFogFuncSGIS"), n, points);
  }

  public void glProgramUniformMatrix3x4fv(int program, int location, int count, byte transpose, MemorySegment value) {
    PFNGLPROGRAMUNIFORMMATRIX3X4FVPROC.invoke(address("glProgramUniformMatrix3x4fv"), program, location, count, transpose, value);
  }

  public void glFramebufferReadBufferEXT(int framebuffer, int mode) {
    PFNGLFRAMEBUFFERREADBUFFEREXTPROC.invoke(address("glFramebufferReadBufferEXT"), framebuffer, mode);
  }

  public void glTextureParameterfv(int texture, int pname, MemorySegment param) {
    PFNGLTEXTUREPARAMETERFVPROC.invoke(address("glTextureParameterfv"), texture, pname, param);
  }

  public void glGetMaterialxvOES(int face, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public int glGetUniformBlockIndex(int program, MemorySegment uniformBlockName) {
    return PFNGLGETUNIFORMBLOCKINDEXPROC.invoke(address("glGetUniformBlockIndex"), program, uniformBlockName);
  }

  public void glInvalidateBufferData(int buffer) {
    PFNGLINVALIDATEBUFFERDATAPROC.invoke(address("glInvalidateBufferData"), buffer);
  }

  public void glTransformFeedbackBufferBase(int xfb, int index, int buffer) {
    PFNGLTRANSFORMFEEDBACKBUFFERBASEPROC.invoke(address("glTransformFeedbackBufferBase"), xfb, index, buffer);
  }

  public void glPolygonModeNV(int face, int mode) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glNamedFramebufferSampleLocationsfvARB(int framebuffer, int start, int count, MemorySegment v) {
    PFNGLNAMEDFRAMEBUFFERSAMPLELOCATIONSFVARBPROC.invoke(address("glNamedFramebufferSampleLocationsfvARB"), framebuffer, start, count, v);
  }

  public void glVertexArrayAttribBinding(int vaobj, int attribindex, int bindingindex) {
    PFNGLVERTEXARRAYATTRIBBINDINGPROC.invoke(address("glVertexArrayAttribBinding"), vaobj, attribindex, bindingindex);
  }

  public void glTextureStorageMem2DMultisampleEXT(int texture, int samples, int internalFormat, int width, int height, byte fixedSampleLocations, int memory, long offset) {
    PFNGLTEXTURESTORAGEMEM2DMULTISAMPLEEXTPROC.invoke(address("glTextureStorageMem2DMultisampleEXT"), texture, samples, internalFormat, width, height, fixedSampleLocations, memory, offset);
  }

  public void glGetNamedBufferPointervEXT(int buffer, int pname, MemorySegment params) {
    PFNGLGETNAMEDBUFFERPOINTERVEXTPROC.invoke(address("glGetNamedBufferPointervEXT"), buffer, pname, params);
  }

  public void glUniformMatrix3x4fv(int location, int count, byte transpose, MemorySegment value) {
    PFNGLUNIFORMMATRIX3X4FVPROC.invoke(address("glUniformMatrix3x4fv"), location, count, transpose, value);
  }

  public void glGetTexEnvxv(int target, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexCoord1hvNV(int target, MemorySegment v) {
    PFNGLMULTITEXCOORD1HVNVPROC.invoke(address("glMultiTexCoord1hvNV"), target, v);
  }

  public byte glUnmapBuffer(int target) {
    return PFNGLUNMAPBUFFERPROC.invoke(address("glUnmapBuffer"), target);
  }

  public void glTranslatex(int x, int y, int z) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexParameterIuivEXT(int texunit, int target, int pname, MemorySegment params) {
    PFNGLMULTITEXPARAMETERIUIVEXTPROC.invoke(address("glMultiTexParameterIuivEXT"), texunit, target, pname, params);
  }

  public void glTexCoord3xvOES(MemorySegment coords) {
    PFNGLTEXCOORD3XVOESPROC.invoke(address("glTexCoord3xvOES"), coords);
  }

  public void glGetnTexImage(int target, int level, int format, int type, int bufSize, MemorySegment pixels) {
    PFNGLGETNTEXIMAGEPROC.invoke(address("glGetnTexImage"), target, level, format, type, bufSize, pixels);
  }

  public void glReadnPixelsEXT(int x, int y, int width, int height, int format, int type, int bufSize, MemorySegment data) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribL1dvEXT(int index, MemorySegment v) {
    PFNGLVERTEXATTRIBL1DVEXTPROC.invoke(address("glVertexAttribL1dvEXT"), index, v);
  }

  public void glCopyMultiTexSubImage1DEXT(int texunit, int target, int level, int xoffset, int x, int y, int width) {
    PFNGLCOPYMULTITEXSUBIMAGE1DEXTPROC.invoke(address("glCopyMultiTexSubImage1DEXT"), texunit, target, level, xoffset, x, y, width);
  }

  public void glTexCoord3xOES(int s, int t, int r) {
    PFNGLTEXCOORD3XOESPROC.invoke(address("glTexCoord3xOES"), s, t, r);
  }

  public void glProgramUniform4dv(int program, int location, int count, MemorySegment value) {
    PFNGLPROGRAMUNIFORM4DVPROC.invoke(address("glProgramUniform4dv"), program, location, count, value);
  }

  public void glConservativeRasterParameteriNV(int pname, int param) {
    PFNGLCONSERVATIVERASTERPARAMETERINVPROC.invoke(address("glConservativeRasterParameteriNV"), pname, param);
  }

  public void glEnableIndexedEXT(int target, int index) {
    PFNGLENABLEINDEXEDEXTPROC.invoke(address("glEnableIndexedEXT"), target, index);
  }

  public void glUniformMatrix3x4dv(int location, int count, byte transpose, MemorySegment value) {
    PFNGLUNIFORMMATRIX3X4DVPROC.invoke(address("glUniformMatrix3x4dv"), location, count, transpose, value);
  }

  public void glPointParameterfARB(int pname, float param) {
    PFNGLPOINTPARAMETERFARBPROC.invoke(address("glPointParameterfARB"), pname, param);
  }

  public void glGetClipPlanex(int plane, MemorySegment equation) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetnCompressedTexImage(int target, int lod, int bufSize, MemorySegment pixels) {
    PFNGLGETNCOMPRESSEDTEXIMAGEPROC.invoke(address("glGetnCompressedTexImage"), target, lod, bufSize, pixels);
  }

  public void glNormalStream3ivATI(int stream, MemorySegment coords) {
    PFNGLNORMALSTREAM3IVATIPROC.invoke(address("glNormalStream3ivATI"), stream, coords);
  }

  public void glGenFramebuffersOES(int n, MemorySegment framebuffers) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribLFormatNV(int index, int size, int type, int stride) {
    PFNGLVERTEXATTRIBLFORMATNVPROC.invoke(address("glVertexAttribLFormatNV"), index, size, type, stride);
  }

  public void glShaderOp2EXT(int op, int res, int arg1, int arg2) {
    PFNGLSHADEROP2EXTPROC.invoke(address("glShaderOp2EXT"), op, res, arg1, arg2);
  }

  public void glGetActiveSubroutineName(int program, int shadertype, int index, int bufSize, MemorySegment length, MemorySegment name) {
    PFNGLGETACTIVESUBROUTINENAMEPROC.invoke(address("glGetActiveSubroutineName"), program, shadertype, index, bufSize, length, name);
  }

  public void glGetClipPlanef(int plane, MemorySegment equation) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glNamedProgramStringEXT(int program, int target, int format, int len, MemorySegment string) {
    PFNGLNAMEDPROGRAMSTRINGEXTPROC.invoke(address("glNamedProgramStringEXT"), program, target, format, len, string);
  }

  public void glProgramUniformMatrix4fvEXT(int program, int location, int count, byte transpose, MemorySegment value) {
    PFNGLPROGRAMUNIFORMMATRIX4FVEXTPROC.invoke(address("glProgramUniformMatrix4fvEXT"), program, location, count, transpose, value);
  }

  public void glMatrixFrustumEXT(int mode, double left, double right, double bottom, double top, double zNear, double zFar) {
    PFNGLMATRIXFRUSTUMEXTPROC.invoke(address("glMatrixFrustumEXT"), mode, left, right, bottom, top, zNear, zFar);
  }

  public void glTexCoordP1ui(int type, int coords) {
    PFNGLTEXCOORDP1UIPROC.invoke(address("glTexCoordP1ui"), type, coords);
  }

  public void glGetTexEnvxvOES(int target, int pname, MemorySegment params) {
    PFNGLGETTEXENVXVOESPROC.invoke(address("glGetTexEnvxvOES"), target, pname, params);
  }

  public void glTexCoord3bOES(byte s, byte t, byte r) {
    PFNGLTEXCOORD3BOESPROC.invoke(address("glTexCoord3bOES"), s, t, r);
  }

  public void glStencilOpSeparate(int face, int sfail, int dpfail, int dppass) {
    PFNGLSTENCILOPSEPARATEPROC.invoke(address("glStencilOpSeparate"), face, sfail, dpfail, dppass);
  }

  public void glPixelTransformParameterfEXT(int target, int pname, float param) {
    PFNGLPIXELTRANSFORMPARAMETERFEXTPROC.invoke(address("glPixelTransformParameterfEXT"), target, pname, param);
  }

  public void glConvolutionParameterfEXT(int target, int pname, float params) {
    PFNGLCONVOLUTIONPARAMETERFEXTPROC.invoke(address("glConvolutionParameterfEXT"), target, pname, params);
  }

  public void glGetFloati_vOES(int target, int index, MemorySegment data) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetProgramLocalParameterIivNV(int target, int index, MemorySegment params) {
    PFNGLGETPROGRAMLOCALPARAMETERIIVNVPROC.invoke(address("glGetProgramLocalParameterIivNV"), target, index, params);
  }

  public void glFogCoordfvEXT(MemorySegment coord) {
    PFNGLFOGCOORDFVEXTPROC.invoke(address("glFogCoordfvEXT"), coord);
  }

  public void glSetFenceNV(int fence, int condition) {
    PFNGLSETFENCENVPROC.invoke(address("glSetFenceNV"), fence, condition);
  }

  public void glVertexAttribI2ivEXT(int index, MemorySegment v) {
    PFNGLVERTEXATTRIBI2IVEXTPROC.invoke(address("glVertexAttribI2ivEXT"), index, v);
  }

  public void glLoadProgramNV(int target, int id, int len, MemorySegment program) {
    PFNGLLOADPROGRAMNVPROC.invoke(address("glLoadProgramNV"), target, id, len, program);
  }

  public void glFramebufferPixelLocalStorageSizeEXT(int target, int size) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetTextureParameterIuivEXT(int texture, int target, int pname, MemorySegment params) {
    PFNGLGETTEXTUREPARAMETERIUIVEXTPROC.invoke(address("glGetTextureParameterIuivEXT"), texture, target, pname, params);
  }

  public void glDepthRangeIndexed(int index, double n, double f) {
    PFNGLDEPTHRANGEINDEXEDPROC.invoke(address("glDepthRangeIndexed"), index, n, f);
  }

  public void glConvolutionParameterfvEXT(int target, int pname, MemorySegment params) {
    PFNGLCONVOLUTIONPARAMETERFVEXTPROC.invoke(address("glConvolutionParameterfvEXT"), target, pname, params);
  }

  public void glUniform1uivEXT(int location, int count, MemorySegment value) {
    PFNGLUNIFORM1UIVEXTPROC.invoke(address("glUniform1uivEXT"), location, count, value);
  }

  public void glDeleteBuffers(int n, MemorySegment buffers) {
    PFNGLDELETEBUFFERSPROC.invoke(address("glDeleteBuffers"), n, buffers);
  }

  public void glNamedProgramLocalParameterI4iEXT(int program, int target, int index, int x, int y, int z, int w) {
    PFNGLNAMEDPROGRAMLOCALPARAMETERI4IEXTPROC.invoke(address("glNamedProgramLocalParameterI4iEXT"), program, target, index, x, y, z, w);
  }

  public void glIndexxvOES(MemorySegment component) {
    PFNGLINDEXXVOESPROC.invoke(address("glIndexxvOES"), component);
  }

  public void glTexStorage1DEXT(int target, int levels, int internalformat, int width) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetnSeparableFilter(int target, int format, int type, int rowBufSize, MemorySegment row, int columnBufSize, MemorySegment column, MemorySegment span) {
    PFNGLGETNSEPARABLEFILTERPROC.invoke(address("glGetnSeparableFilter"), target, format, type, rowBufSize, row, columnBufSize, column, span);
  }

  public void glNormalP3ui(int type, int coords) {
    PFNGLNORMALP3UIPROC.invoke(address("glNormalP3ui"), type, coords);
  }

  public void glCompileCommandListNV(int list) {
    PFNGLCOMPILECOMMANDLISTNVPROC.invoke(address("glCompileCommandListNV"), list);
  }

  public int glGetGraphicsResetStatusKHR() {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttrib4NivARB(int index, MemorySegment v) {
    PFNGLVERTEXATTRIB4NIVARBPROC.invoke(address("glVertexAttrib4NivARB"), index, v);
  }

  public byte glIsObjectBufferATI(int buffer) {
    return PFNGLISOBJECTBUFFERATIPROC.invoke(address("glIsObjectBufferATI"), buffer);
  }

  public void glNamedBufferAttachMemoryNV(int buffer, int memory, long offset) {
    PFNGLNAMEDBUFFERATTACHMEMORYNVPROC.invoke(address("glNamedBufferAttachMemoryNV"), buffer, memory, offset);
  }

  public void glReplacementCodeusvSUN(MemorySegment code) {
    PFNGLREPLACEMENTCODEUSVSUNPROC.invoke(address("glReplacementCodeusvSUN"), code);
  }

  public void glIglooInterfaceSGIX(int pname, MemorySegment params) {
    PFNGLIGLOOINTERFACESGIXPROC.invoke(address("glIglooInterfaceSGIX"), pname, params);
  }

  public void glReadBufferNV(int mode) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetCombinerStageParameterfvNV(int stage, int pname, MemorySegment params) {
    PFNGLGETCOMBINERSTAGEPARAMETERFVNVPROC.invoke(address("glGetCombinerStageParameterfvNV"), stage, pname, params);
  }

  public void glDrawElementsInstancedBaseVertexBaseInstance(int mode, int count, int type, MemorySegment indices, int instancecount, int basevertex, int baseinstance) {
    PFNGLDRAWELEMENTSINSTANCEDBASEVERTEXBASEINSTANCEPROC.invoke(address("glDrawElementsInstancedBaseVertexBaseInstance"), mode, count, type, indices, instancecount, basevertex, baseinstance);
  }

  public void glGenerateMipmapEXT(int target) {
    PFNGLGENERATEMIPMAPEXTPROC.invoke(address("glGenerateMipmapEXT"), target);
  }

  public void glVertexArrayEdgeFlagOffsetEXT(int vaobj, int buffer, int stride, long offset) {
    PFNGLVERTEXARRAYEDGEFLAGOFFSETEXTPROC.invoke(address("glVertexArrayEdgeFlagOffsetEXT"), vaobj, buffer, stride, offset);
  }

  public void glDrawRangeElementsEXT(int mode, int start, int end, int count, int type, MemorySegment indices) {
    PFNGLDRAWRANGEELEMENTSEXTPROC.invoke(address("glDrawRangeElementsEXT"), mode, start, end, count, type, indices);
  }

  public void glProgramUniform4iv(int program, int location, int count, MemorySegment value) {
    PFNGLPROGRAMUNIFORM4IVPROC.invoke(address("glProgramUniform4iv"), program, location, count, value);
  }

  public void glVertexAttribI4ubv(int index, MemorySegment v) {
    PFNGLVERTEXATTRIBI4UBVPROC.invoke(address("glVertexAttribI4ubv"), index, v);
  }

  public byte glIsFramebufferOES(int framebuffer) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDrawTexsvOES(MemorySegment coords) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glStencilFuncSeparate(int face, int func, int ref, int mask) {
    PFNGLSTENCILFUNCSEPARATEPROC.invoke(address("glStencilFuncSeparate"), face, func, ref, mask);
  }

  public void glVertexAttribs1hvNV(int index, int n, MemorySegment v) {
    PFNGLVERTEXATTRIBS1HVNVPROC.invoke(address("glVertexAttribs1hvNV"), index, n, v);
  }

  public void glGetProgramEnvParameterdvARB(int target, int index, MemorySegment params) {
    PFNGLGETPROGRAMENVPARAMETERDVARBPROC.invoke(address("glGetProgramEnvParameterdvARB"), target, index, params);
  }

  public int glCheckNamedFramebufferStatusEXT(int framebuffer, int target) {
    return PFNGLCHECKNAMEDFRAMEBUFFERSTATUSEXTPROC.invoke(address("glCheckNamedFramebufferStatusEXT"), framebuffer, target);
  }

  public void glGetInteger64i_v(int target, int index, MemorySegment data) {
    PFNGLGETINTEGER64I_VPROC.invoke(address("glGetInteger64i_v"), target, index, data);
  }

  public void glVertexAttribs1svNV(int index, int count, MemorySegment v) {
    PFNGLVERTEXATTRIBS1SVNVPROC.invoke(address("glVertexAttribs1svNV"), index, count, v);
  }

  public void glClearTexSubImageEXT(int texture, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int format, int type, MemorySegment data) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glReplacementCodeuiColor4ubVertex3fSUN(int rc, byte r, byte g, byte b, byte a, float x, float y, float z) {
    PFNGLREPLACEMENTCODEUICOLOR4UBVERTEX3FSUNPROC.invoke(address("glReplacementCodeuiColor4ubVertex3fSUN"), rc, r, g, b, a, x, y, z);
  }

  public void glGetTextureLevelParameteriv(int texture, int level, int pname, MemorySegment params) {
    PFNGLGETTEXTURELEVELPARAMETERIVPROC.invoke(address("glGetTextureLevelParameteriv"), texture, level, pname, params);
  }

  public void glTexPageCommitmentMemNV(int target, int layer, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int memory, long offset, byte commit) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGenProgramPipelinesEXT(int n, MemorySegment pipelines) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glPixelStorex(int pname, int param) {
    PFNGLPIXELSTOREXPROC.invoke(address("glPixelStorex"), pname, param);
  }

  public void glRotatexOES(int angle, int x, int y, int z) {
    PFNGLROTATEXOESPROC.invoke(address("glRotatexOES"), angle, x, y, z);
  }

  public void glProgramUniform4fv(int program, int location, int count, MemorySegment value) {
    PFNGLPROGRAMUNIFORM4FVPROC.invoke(address("glProgramUniform4fv"), program, location, count, value);
  }

  public void glSecondaryColor3sv(MemorySegment v) {
    PFNGLSECONDARYCOLOR3SVPROC.invoke(address("glSecondaryColor3sv"), v);
  }

  public void glVertexAttrib1svARB(int index, MemorySegment v) {
    PFNGLVERTEXATTRIB1SVARBPROC.invoke(address("glVertexAttrib1svARB"), index, v);
  }

  public void glDrawCommandsNV(int primitiveMode, int buffer, MemorySegment indirects, MemorySegment sizes, int count) {
    PFNGLDRAWCOMMANDSNVPROC.invoke(address("glDrawCommandsNV"), primitiveMode, buffer, indirects, sizes, count);
  }

  public void glReplacementCodeuiTexCoord2fColor4fNormal3fVertex3fvSUN(MemorySegment rc, MemorySegment tc, MemorySegment c, MemorySegment n, MemorySegment v) {
    PFNGLREPLACEMENTCODEUITEXCOORD2FCOLOR4FNORMAL3FVERTEX3FVSUNPROC.invoke(address("glReplacementCodeuiTexCoord2fColor4fNormal3fVertex3fvSUN"), rc, tc, c, n, v);
  }

  public void glPathColorGenNV(int color, int genMode, int colorFormat, MemorySegment coeffs) {
    PFNGLPATHCOLORGENNVPROC.invoke(address("glPathColorGenNV"), color, genMode, colorFormat, coeffs);
  }

  public void glVertexWeightfEXT(float weight) {
    PFNGLVERTEXWEIGHTFEXTPROC.invoke(address("glVertexWeightfEXT"), weight);
  }

  public void glTexBufferEXT(int target, int internalformat, int buffer) {
    PFNGLTEXBUFFEREXTPROC.invoke(address("glTexBufferEXT"), target, internalformat, buffer);
  }

  public void glMatrixMultTransposefEXT(int mode, MemorySegment m) {
    PFNGLMATRIXMULTTRANSPOSEFEXTPROC.invoke(address("glMatrixMultTransposefEXT"), mode, m);
  }

  public void glVDPAUUnregisterSurfaceNV(long surface) {
    PFNGLVDPAUUNREGISTERSURFACENVPROC.invoke(address("glVDPAUUnregisterSurfaceNV"), surface);
  }

  public void glMultiDrawRangeElementArrayAPPLE(int mode, int start, int end, MemorySegment first, MemorySegment count, int primcount) {
    PFNGLMULTIDRAWRANGEELEMENTARRAYAPPLEPROC.invoke(address("glMultiDrawRangeElementArrayAPPLE"), mode, start, end, first, count, primcount);
  }

  public void glVertexAttribL1ui64NV(int index, long x) {
    PFNGLVERTEXATTRIBL1UI64NVPROC.invoke(address("glVertexAttribL1ui64NV"), index, x);
  }

  public int glGetUniformBufferSizeEXT(int program, int location) {
    return PFNGLGETUNIFORMBUFFERSIZEEXTPROC.invoke(address("glGetUniformBufferSizeEXT"), program, location);
  }

  public void glSecondaryColor3ivEXT(MemorySegment v) {
    PFNGLSECONDARYCOLOR3IVEXTPROC.invoke(address("glSecondaryColor3ivEXT"), v);
  }

  public void glVertex2hNV(short x, short y) {
    PFNGLVERTEX2HNVPROC.invoke(address("glVertex2hNV"), x, y);
  }

  public void glSpriteParameterivSGIX(int pname, MemorySegment params) {
    PFNGLSPRITEPARAMETERIVSGIXPROC.invoke(address("glSpriteParameterivSGIX"), pname, params);
  }

  public void glValidateProgramPipeline(int pipeline) {
    PFNGLVALIDATEPROGRAMPIPELINEPROC.invoke(address("glValidateProgramPipeline"), pipeline);
  }

  public void glGetCombinerInputParameterivNV(int stage, int portion, int variable, int pname, MemorySegment params) {
    PFNGLGETCOMBINERINPUTPARAMETERIVNVPROC.invoke(address("glGetCombinerInputParameterivNV"), stage, portion, variable, pname, params);
  }

  public void glGetProgramPipelineiv(int pipeline, int pname, MemorySegment params) {
    PFNGLGETPROGRAMPIPELINEIVPROC.invoke(address("glGetProgramPipelineiv"), pipeline, pname, params);
  }

  public void glRenderbufferStorageMultisampleCoverageNV(int target, int coverageSamples, int colorSamples, int internalformat, int width, int height) {
    PFNGLRENDERBUFFERSTORAGEMULTISAMPLECOVERAGENVPROC.invoke(address("glRenderbufferStorageMultisampleCoverageNV"), target, coverageSamples, colorSamples, internalformat, width, height);
  }

  public void glGetNamedFramebufferAttachmentParameterivEXT(int framebuffer, int attachment, int pname, MemorySegment params) {
    PFNGLGETNAMEDFRAMEBUFFERATTACHMENTPARAMETERIVEXTPROC.invoke(address("glGetNamedFramebufferAttachmentParameterivEXT"), framebuffer, attachment, pname, params);
  }

  public void glWindowPos2iMESA(int x, int y) {
    PFNGLWINDOWPOS2IMESAPROC.invoke(address("glWindowPos2iMESA"), x, y);
  }

  public void glDrawRangeElementArrayAPPLE(int mode, int start, int end, int first, int count) {
    PFNGLDRAWRANGEELEMENTARRAYAPPLEPROC.invoke(address("glDrawRangeElementArrayAPPLE"), mode, start, end, first, count);
  }

  public void glGetProgramivARB(int target, int pname, MemorySegment params) {
    PFNGLGETPROGRAMIVARBPROC.invoke(address("glGetProgramivARB"), target, pname, params);
  }

  public void glGetPointervKHR(int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public int glGenVertexShadersEXT(int range) {
    return PFNGLGENVERTEXSHADERSEXTPROC.invoke(address("glGenVertexShadersEXT"), range);
  }

  public void glSecondaryColor3ub(byte red, byte green, byte blue) {
    PFNGLSECONDARYCOLOR3UBPROC.invoke(address("glSecondaryColor3ub"), red, green, blue);
  }

  public void glEvalCoord2xvOES(MemorySegment coords) {
    PFNGLEVALCOORD2XVOESPROC.invoke(address("glEvalCoord2xvOES"), coords);
  }

  public void glTextureParameterIuivEXT(int texture, int target, int pname, MemorySegment params) {
    PFNGLTEXTUREPARAMETERIUIVEXTPROC.invoke(address("glTextureParameterIuivEXT"), texture, target, pname, params);
  }

  public void glUniform2ui(int location, int v0, int v1) {
    PFNGLUNIFORM2UIPROC.invoke(address("glUniform2ui"), location, v0, v1);
  }

  public void glProgramParameteriEXT(int program, int pname, int value) {
    PFNGLPROGRAMPARAMETERIEXTPROC.invoke(address("glProgramParameteriEXT"), program, pname, value);
  }

  public void glPointSizePointerOES(int type, int stride, MemorySegment pointer) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glSecondaryColor3ui(int red, int green, int blue) {
    PFNGLSECONDARYCOLOR3UIPROC.invoke(address("glSecondaryColor3ui"), red, green, blue);
  }

  public void glBlendEquationi(int buf, int mode) {
    PFNGLBLENDEQUATIONIPROC.invoke(address("glBlendEquationi"), buf, mode);
  }

  public void glSecondaryColor3us(short red, short green, short blue) {
    PFNGLSECONDARYCOLOR3USPROC.invoke(address("glSecondaryColor3us"), red, green, blue);
  }

  public void glMaterialxv(int face, int pname, MemorySegment param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glWindowRectanglesEXT(int mode, int count, MemorySegment box) {
    PFNGLWINDOWRECTANGLESEXTPROC.invoke(address("glWindowRectanglesEXT"), mode, count, box);
  }

  public void glVertexAttrib1fARB(int index, float x) {
    PFNGLVERTEXATTRIB1FARBPROC.invoke(address("glVertexAttrib1fARB"), index, x);
  }

  public void glGetConvolutionFilterEXT(int target, int format, int type, MemorySegment image) {
    PFNGLGETCONVOLUTIONFILTEREXTPROC.invoke(address("glGetConvolutionFilterEXT"), target, format, type, image);
  }

  public void glGetNamedProgramLocalParameterIivEXT(int program, int target, int index, MemorySegment params) {
    PFNGLGETNAMEDPROGRAMLOCALPARAMETERIIVEXTPROC.invoke(address("glGetNamedProgramLocalParameterIivEXT"), program, target, index, params);
  }

  public void glCopyTexSubImage3DEXT(int target, int level, int xoffset, int yoffset, int zoffset, int x, int y, int width, int height) {
    PFNGLCOPYTEXSUBIMAGE3DEXTPROC.invoke(address("glCopyTexSubImage3DEXT"), target, level, xoffset, yoffset, zoffset, x, y, width, height);
  }

  public void glEndConditionalRender() {
    PFNGLENDCONDITIONALRENDERPROC.invoke(address("glEndConditionalRender"));
  }

  public void glGetShadingRateSampleLocationivNV(int rate, int samples, int index, MemorySegment location) {
    PFNGLGETSHADINGRATESAMPLELOCATIONIVNVPROC.invoke(address("glGetShadingRateSampleLocationivNV"), rate, samples, index, location);
  }

  public void glGetBufferParameterui64vNV(int target, int pname, MemorySegment params) {
    PFNGLGETBUFFERPARAMETERUI64VNVPROC.invoke(address("glGetBufferParameterui64vNV"), target, pname, params);
  }

  public void glPNTrianglesfATI(int pname, float param) {
    PFNGLPNTRIANGLESFATIPROC.invoke(address("glPNTrianglesfATI"), pname, param);
  }

  public void glGetVideoCaptureStreamdvNV(int video_capture_slot, int stream, int pname, MemorySegment params) {
    PFNGLGETVIDEOCAPTURESTREAMDVNVPROC.invoke(address("glGetVideoCaptureStreamdvNV"), video_capture_slot, stream, pname, params);
  }

  public void glProgramEnvParameters4fvEXT(int target, int index, int count, MemorySegment params) {
    PFNGLPROGRAMENVPARAMETERS4FVEXTPROC.invoke(address("glProgramEnvParameters4fvEXT"), target, index, count, params);
  }

  public void glGenSamplers(int count, MemorySegment samplers) {
    PFNGLGENSAMPLERSPROC.invoke(address("glGenSamplers"), count, samplers);
  }

  public byte glIsTextureEXT(int texture) {
    return PFNGLISTEXTUREEXTPROC.invoke(address("glIsTextureEXT"), texture);
  }

  public MemorySegment glCreateSyncFromCLeventARB(MemorySegment context, MemorySegment event, int flags) {
    return PFNGLCREATESYNCFROMCLEVENTARBPROC.invoke(address("glCreateSyncFromCLeventARB"), context, event, flags);
  }

  public void glSeparableFilter2DEXT(int target, int internalformat, int width, int height, int format, int type, MemorySegment row, MemorySegment column) {
    PFNGLSEPARABLEFILTER2DEXTPROC.invoke(address("glSeparableFilter2DEXT"), target, internalformat, width, height, format, type, row, column);
  }

  public void glDebugMessageCallback(MemorySegment callback, MemorySegment userParam) {
    PFNGLDEBUGMESSAGECALLBACKPROC.invoke(address("glDebugMessageCallback"), callback, userParam);
  }

  public void glFramebufferTextureARB(int target, int attachment, int texture, int level) {
    PFNGLFRAMEBUFFERTEXTUREARBPROC.invoke(address("glFramebufferTextureARB"), target, attachment, texture, level);
  }

  public void glSecondaryColorPointer(int size, int type, int stride, MemorySegment pointer) {
    PFNGLSECONDARYCOLORPOINTERPROC.invoke(address("glSecondaryColorPointer"), size, type, stride, pointer);
  }

  public void glAlphaFragmentOp2ATI(int op, int dst, int dstMod, int arg1, int arg1Rep, int arg1Mod, int arg2, int arg2Rep, int arg2Mod) {
    PFNGLALPHAFRAGMENTOP2ATIPROC.invoke(address("glAlphaFragmentOp2ATI"), op, dst, dstMod, arg1, arg1Rep, arg1Mod, arg2, arg2Rep, arg2Mod);
  }

  public void glProgramUniform4ui64ARB(int program, int location, long x, long y, long z, long w) {
    PFNGLPROGRAMUNIFORM4UI64ARBPROC.invoke(address("glProgramUniform4ui64ARB"), program, location, x, y, z, w);
  }

  public void glMultiTexParameteriEXT(int texunit, int target, int pname, int param) {
    PFNGLMULTITEXPARAMETERIEXTPROC.invoke(address("glMultiTexParameteriEXT"), texunit, target, pname, param);
  }

  public void glGetQueryObjecti64vEXT(int id, int pname, MemorySegment params) {
    PFNGLGETQUERYOBJECTI64VEXTPROC.invoke(address("glGetQueryObjecti64vEXT"), id, pname, params);
  }

  public void glCompressedTextureImage1DEXT(int texture, int target, int level, int internalformat, int width, int border, int imageSize, MemorySegment bits) {
    PFNGLCOMPRESSEDTEXTUREIMAGE1DEXTPROC.invoke(address("glCompressedTextureImage1DEXT"), texture, target, level, internalformat, width, border, imageSize, bits);
  }

  public void glFogCoordPointer(int type, int stride, MemorySegment pointer) {
    PFNGLFOGCOORDPOINTERPROC.invoke(address("glFogCoordPointer"), type, stride, pointer);
  }

  public void glWindowPos4sMESA(short x, short y, short z, short w) {
    PFNGLWINDOWPOS4SMESAPROC.invoke(address("glWindowPos4sMESA"), x, y, z, w);
  }

  public void glProgramUniform2iEXT(int program, int location, int v0, int v1) {
    PFNGLPROGRAMUNIFORM2IEXTPROC.invoke(address("glProgramUniform2iEXT"), program, location, v0, v1);
  }

  public void glTexCoord2fNormal3fVertex3fvSUN(MemorySegment tc, MemorySegment n, MemorySegment v) {
    PFNGLTEXCOORD2FNORMAL3FVERTEX3FVSUNPROC.invoke(address("glTexCoord2fNormal3fVertex3fvSUN"), tc, n, v);
  }

  public void glFramebufferTextureMultiviewOVR(int target, int attachment, int texture, int level, int baseViewIndex, int numViews) {
    PFNGLFRAMEBUFFERTEXTUREMULTIVIEWOVRPROC.invoke(address("glFramebufferTextureMultiviewOVR"), target, attachment, texture, level, baseViewIndex, numViews);
  }

  public void glInsertComponentEXT(int res, int src, int num) {
    PFNGLINSERTCOMPONENTEXTPROC.invoke(address("glInsertComponentEXT"), res, src, num);
  }

  public void glTexturePageCommitmentMemNV(int texture, int layer, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int memory, long offset, byte commit) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glPushDebugGroupKHR(int source, int id, int length, MemorySegment message) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribIPointer(int index, int size, int type, int stride, MemorySegment pointer) {
    PFNGLVERTEXATTRIBIPOINTERPROC.invoke(address("glVertexAttribIPointer"), index, size, type, stride, pointer);
  }

  public void glGetTransformFeedbackVaryingNV(int program, int index, MemorySegment location) {
    PFNGLGETTRANSFORMFEEDBACKVARYINGNVPROC.invoke(address("glGetTransformFeedbackVaryingNV"), program, index, location);
  }

  public void glDepthBoundsdNV(double zmin, double zmax) {
    PFNGLDEPTHBOUNDSDNVPROC.invoke(address("glDepthBoundsdNV"), zmin, zmax);
  }

  public void glVertexStream1dvATI(int stream, MemorySegment coords) {
    PFNGLVERTEXSTREAM1DVATIPROC.invoke(address("glVertexStream1dvATI"), stream, coords);
  }

  public void glFramebufferRenderbuffer(int target, int attachment, int renderbuffertarget, int renderbuffer) {
    PFNGLFRAMEBUFFERRENDERBUFFERPROC.invoke(address("glFramebufferRenderbuffer"), target, attachment, renderbuffertarget, renderbuffer);
  }

  public void glClearAccumxOES(int red, int green, int blue, int alpha) {
    PFNGLCLEARACCUMXOESPROC.invoke(address("glClearAccumxOES"), red, green, blue, alpha);
  }

  public void glVariantuivEXT(int id, MemorySegment addr) {
    PFNGLVARIANTUIVEXTPROC.invoke(address("glVariantuivEXT"), id, addr);
  }

  public void glCombinerStageParameterfvNV(int stage, int pname, MemorySegment params) {
    PFNGLCOMBINERSTAGEPARAMETERFVNVPROC.invoke(address("glCombinerStageParameterfvNV"), stage, pname, params);
  }

  public byte glAreProgramsResidentNV(int n, MemorySegment programs, MemorySegment residences) {
    return PFNGLAREPROGRAMSRESIDENTNVPROC.invoke(address("glAreProgramsResidentNV"), n, programs, residences);
  }

  public void glVertexAttribFormat(int attribindex, int size, int type, byte normalized, int relativeoffset) {
    PFNGLVERTEXATTRIBFORMATPROC.invoke(address("glVertexAttribFormat"), attribindex, size, type, normalized, relativeoffset);
  }

  public void glVertexAttrib2sARB(int index, short x, short y) {
    PFNGLVERTEXATTRIB2SARBPROC.invoke(address("glVertexAttrib2sARB"), index, x, y);
  }

  public int glBindMaterialParameterEXT(int face, int value) {
    return PFNGLBINDMATERIALPARAMETEREXTPROC.invoke(address("glBindMaterialParameterEXT"), face, value);
  }

  @Override
  public void glutCheckLoop() {
    // TODO Auto-generated method stub
    
  }

  @Override
  public MemorySegment glutGetProcAddress(MemorySegment arg0) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void glutStrokeMonoRoman(MemorySegment arg0) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void glutSurfaceTexture(int arg0, int arg1, int arg2) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void glutWMCloseFunc(MemorySegment arg0) {
    // TODO Auto-generated method stub
    
  }

}
