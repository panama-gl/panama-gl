package panamagl.platform.linux.x86; 

import opengl.ubuntu.v20.glut_h;
import static opengl.ubuntu.v20.glut_h.*;
import glxext.ubuntu.v20.glxext_h;
import static glxext.ubuntu.v20.glxext_h.*;
import glext.ubuntu.v20.glext_h;
import static glext.ubuntu.v20.glext_h.*;
import java.lang.foreign.*;

public class GL_linux_x86 extends panamagl.opengl.AGL implements panamagl.opengl.GL, panamagl.opengl.GLU, panamagl.opengl.GLUT {
  public void glAccum(int op, float value) {
    glut_h.glAccum(op, value);
  }

  public void glActiveTexture(int texture) {
    glut_h.glActiveTexture(texture);
  }

  public void glActiveTextureARB(int texture) {
    glut_h.glActiveTextureARB(texture);
  }

  public void glAlphaFunc(int func, float ref) {
    glut_h.glAlphaFunc(func, ref);
  }

  public byte glAreTexturesResident(int n, Addressable textures, Addressable residences) {
    return glut_h.glAreTexturesResident(n, textures, residences);
  }

  public void glArrayElement(int i) {
    glut_h.glArrayElement(i);
  }

  public void glBegin(int mode) {
    glut_h.glBegin(mode);
  }

  public void glBindTexture(int target, int texture) {
    glut_h.glBindTexture(target, texture);
  }

  public void glBitmap(int width, int height, float xorig, float yorig, float xmove, float ymove, Addressable bitmap) {
    glut_h.glBitmap(width, height, xorig, yorig, xmove, ymove, bitmap);
  }

  public void glBlendColor(float red, float green, float blue, float alpha) {
    glut_h.glBlendColor(red, green, blue, alpha);
  }

  public void glBlendEquation(int mode) {
    glut_h.glBlendEquation(mode);
  }

  public void glBlendFunc(int sfactor, int dfactor) {
    glut_h.glBlendFunc(sfactor, dfactor);
  }

  public void glCallList(int list) {
    glut_h.glCallList(list);
  }

  public void glCallLists(int n, int type, Addressable lists) {
    glut_h.glCallLists(n, type, lists);
  }

  public void glClear(int mask) {
    glut_h.glClear(mask);
  }

  public void glClearAccum(float red, float green, float blue, float alpha) {
    glut_h.glClearAccum(red, green, blue, alpha);
  }

  public void glClearColor(float red, float green, float blue, float alpha) {
    glut_h.glClearColor(red, green, blue, alpha);
  }

  public void glClearDepth(double depth) {
    glut_h.glClearDepth(depth);
  }

  public void glClearIndex(float c) {
    glut_h.glClearIndex(c);
  }

  public void glClearStencil(int s) {
    glut_h.glClearStencil(s);
  }

  public void glClientActiveTexture(int texture) {
    glut_h.glClientActiveTexture(texture);
  }

  public void glClientActiveTextureARB(int texture) {
    glut_h.glClientActiveTextureARB(texture);
  }

  public void glClipPlane(int plane, Addressable equation) {
    glut_h.glClipPlane(plane, equation);
  }

  public void glColor3b(byte red, byte green, byte blue) {
    glut_h.glColor3b(red, green, blue);
  }

  public void glColor3bv(Addressable v) {
    glut_h.glColor3bv(v);
  }

  public void glColor3d(double red, double green, double blue) {
    glut_h.glColor3d(red, green, blue);
  }

  public void glColor3dv(Addressable v) {
    glut_h.glColor3dv(v);
  }

  public void glColor3f(float red, float green, float blue) {
    glut_h.glColor3f(red, green, blue);
  }

  public void glColor3fv(Addressable v) {
    glut_h.glColor3fv(v);
  }

  public void glColor3i(int red, int green, int blue) {
    glut_h.glColor3i(red, green, blue);
  }

  public void glColor3iv(Addressable v) {
    glut_h.glColor3iv(v);
  }

  public void glColor3s(short red, short green, short blue) {
    glut_h.glColor3s(red, green, blue);
  }

  public void glColor3sv(Addressable v) {
    glut_h.glColor3sv(v);
  }

  public void glColor3ub(byte red, byte green, byte blue) {
    glut_h.glColor3ub(red, green, blue);
  }

  public void glColor3ubv(Addressable v) {
    glut_h.glColor3ubv(v);
  }

  public void glColor3ui(int red, int green, int blue) {
    glut_h.glColor3ui(red, green, blue);
  }

  public void glColor3uiv(Addressable v) {
    glut_h.glColor3uiv(v);
  }

  public void glColor3us(short red, short green, short blue) {
    glut_h.glColor3us(red, green, blue);
  }

  public void glColor3usv(Addressable v) {
    glut_h.glColor3usv(v);
  }

  public void glColor4b(byte red, byte green, byte blue, byte alpha) {
    glut_h.glColor4b(red, green, blue, alpha);
  }

  public void glColor4bv(Addressable v) {
    glut_h.glColor4bv(v);
  }

  public void glColor4d(double red, double green, double blue, double alpha) {
    glut_h.glColor4d(red, green, blue, alpha);
  }

  public void glColor4dv(Addressable v) {
    glut_h.glColor4dv(v);
  }

  public void glColor4f(float red, float green, float blue, float alpha) {
    glut_h.glColor4f(red, green, blue, alpha);
  }

  public void glColor4fv(Addressable v) {
    glut_h.glColor4fv(v);
  }

  public void glColor4i(int red, int green, int blue, int alpha) {
    glut_h.glColor4i(red, green, blue, alpha);
  }

  public void glColor4iv(Addressable v) {
    glut_h.glColor4iv(v);
  }

  public void glColor4s(short red, short green, short blue, short alpha) {
    glut_h.glColor4s(red, green, blue, alpha);
  }

  public void glColor4sv(Addressable v) {
    glut_h.glColor4sv(v);
  }

  public void glColor4ub(byte red, byte green, byte blue, byte alpha) {
    glut_h.glColor4ub(red, green, blue, alpha);
  }

  public void glColor4ubv(Addressable v) {
    glut_h.glColor4ubv(v);
  }

  public void glColor4ui(int red, int green, int blue, int alpha) {
    glut_h.glColor4ui(red, green, blue, alpha);
  }

  public void glColor4uiv(Addressable v) {
    glut_h.glColor4uiv(v);
  }

  public void glColor4us(short red, short green, short blue, short alpha) {
    glut_h.glColor4us(red, green, blue, alpha);
  }

  public void glColor4usv(Addressable v) {
    glut_h.glColor4usv(v);
  }

  public void glColorMask(byte red, byte green, byte blue, byte alpha) {
    glut_h.glColorMask(red, green, blue, alpha);
  }

  public void glColorMaterial(int face, int mode) {
    glut_h.glColorMaterial(face, mode);
  }

  public void glColorPointer(int size, int type, int stride, Addressable pointer) {
    glut_h.glColorPointer(size, type, stride, pointer);
  }

  public void glColorSubTable(int target, int start, int count, int format, int type, Addressable data) {
    glut_h.glColorSubTable(target, start, count, format, type, data);
  }

  public void glColorTable(int target, int internalformat, int width, int format, int type, Addressable table) {
    glut_h.glColorTable(target, internalformat, width, format, type, table);
  }

  public void glColorTableParameterfv(int target, int pname, Addressable params) {
    glut_h.glColorTableParameterfv(target, pname, params);
  }

  public void glColorTableParameteriv(int target, int pname, Addressable params) {
    glut_h.glColorTableParameteriv(target, pname, params);
  }

  public void glCompressedTexImage1D(int target, int level, int internalformat, int width, int border, int imageSize, Addressable data) {
    glut_h.glCompressedTexImage1D(target, level, internalformat, width, border, imageSize, data);
  }

  public void glCompressedTexImage2D(int target, int level, int internalformat, int width, int height, int border, int imageSize, Addressable data) {
    glut_h.glCompressedTexImage2D(target, level, internalformat, width, height, border, imageSize, data);
  }

  public void glCompressedTexImage3D(int target, int level, int internalformat, int width, int height, int depth, int border, int imageSize, Addressable data) {
    glut_h.glCompressedTexImage3D(target, level, internalformat, width, height, depth, border, imageSize, data);
  }

  public void glCompressedTexSubImage1D(int target, int level, int xoffset, int width, int format, int imageSize, Addressable data) {
    glut_h.glCompressedTexSubImage1D(target, level, xoffset, width, format, imageSize, data);
  }

  public void glCompressedTexSubImage2D(int target, int level, int xoffset, int yoffset, int width, int height, int format, int imageSize, Addressable data) {
    glut_h.glCompressedTexSubImage2D(target, level, xoffset, yoffset, width, height, format, imageSize, data);
  }

  public void glCompressedTexSubImage3D(int target, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int format, int imageSize, Addressable data) {
    glut_h.glCompressedTexSubImage3D(target, level, xoffset, yoffset, zoffset, width, height, depth, format, imageSize, data);
  }

  public void glConvolutionFilter1D(int target, int internalformat, int width, int format, int type, Addressable image) {
    glut_h.glConvolutionFilter1D(target, internalformat, width, format, type, image);
  }

  public void glConvolutionFilter2D(int target, int internalformat, int width, int height, int format, int type, Addressable image) {
    glut_h.glConvolutionFilter2D(target, internalformat, width, height, format, type, image);
  }

  public void glConvolutionParameterf(int target, int pname, float params) {
    glut_h.glConvolutionParameterf(target, pname, params);
  }

  public void glConvolutionParameterfv(int target, int pname, Addressable params) {
    glut_h.glConvolutionParameterfv(target, pname, params);
  }

  public void glConvolutionParameteri(int target, int pname, int params) {
    glut_h.glConvolutionParameteri(target, pname, params);
  }

  public void glConvolutionParameteriv(int target, int pname, Addressable params) {
    glut_h.glConvolutionParameteriv(target, pname, params);
  }

  public void glCopyColorSubTable(int target, int start, int x, int y, int width) {
    glut_h.glCopyColorSubTable(target, start, x, y, width);
  }

  public void glCopyColorTable(int target, int internalformat, int x, int y, int width) {
    glut_h.glCopyColorTable(target, internalformat, x, y, width);
  }

  public void glCopyConvolutionFilter1D(int target, int internalformat, int x, int y, int width) {
    glut_h.glCopyConvolutionFilter1D(target, internalformat, x, y, width);
  }

  public void glCopyConvolutionFilter2D(int target, int internalformat, int x, int y, int width, int height) {
    glut_h.glCopyConvolutionFilter2D(target, internalformat, x, y, width, height);
  }

  public void glCopyPixels(int x, int y, int width, int height, int type) {
    glut_h.glCopyPixels(x, y, width, height, type);
  }

  public void glCopyTexImage1D(int target, int level, int internalformat, int x, int y, int width, int border) {
    glut_h.glCopyTexImage1D(target, level, internalformat, x, y, width, border);
  }

  public void glCopyTexImage2D(int target, int level, int internalformat, int x, int y, int width, int height, int border) {
    glut_h.glCopyTexImage2D(target, level, internalformat, x, y, width, height, border);
  }

  public void glCopyTexSubImage1D(int target, int level, int xoffset, int x, int y, int width) {
    glut_h.glCopyTexSubImage1D(target, level, xoffset, x, y, width);
  }

  public void glCopyTexSubImage2D(int target, int level, int xoffset, int yoffset, int x, int y, int width, int height) {
    glut_h.glCopyTexSubImage2D(target, level, xoffset, yoffset, x, y, width, height);
  }

  public void glCopyTexSubImage3D(int target, int level, int xoffset, int yoffset, int zoffset, int x, int y, int width, int height) {
    glut_h.glCopyTexSubImage3D(target, level, xoffset, yoffset, zoffset, x, y, width, height);
  }

  public void glCullFace(int mode) {
    glut_h.glCullFace(mode);
  }

  public void glDeleteLists(int list, int range) {
    glut_h.glDeleteLists(list, range);
  }

  public void glDeleteTextures(int n, Addressable textures) {
    glut_h.glDeleteTextures(n, textures);
  }

  public void glDepthFunc(int func) {
    glut_h.glDepthFunc(func);
  }

  public void glDepthMask(byte flag) {
    glut_h.glDepthMask(flag);
  }

  public void glDepthRange(double n, double f) {
    glut_h.glDepthRange(n, f);
  }

  public void glDisable(int cap) {
    glut_h.glDisable(cap);
  }

  public void glDisableClientState(int array) {
    glut_h.glDisableClientState(array);
  }

  public void glDrawArrays(int mode, int first, int count) {
    glut_h.glDrawArrays(mode, first, count);
  }

  public void glDrawBuffer(int buf) {
    glut_h.glDrawBuffer(buf);
  }

  public void glDrawElements(int mode, int count, int type, Addressable indices) {
    glut_h.glDrawElements(mode, count, type, indices);
  }

  public void glDrawPixels(int width, int height, int format, int type, Addressable pixels) {
    glut_h.glDrawPixels(width, height, format, type, pixels);
  }

  public void glDrawRangeElements(int mode, int start, int end, int count, int type, Addressable indices) {
    glut_h.glDrawRangeElements(mode, start, end, count, type, indices);
  }

  public void glEdgeFlag(byte flag) {
    glut_h.glEdgeFlag(flag);
  }

  public void glEdgeFlagPointer(int stride, Addressable pointer) {
    glut_h.glEdgeFlagPointer(stride, pointer);
  }

  public void glEdgeFlagv(Addressable flag) {
    glut_h.glEdgeFlagv(flag);
  }

  public void glEnable(int cap) {
    glut_h.glEnable(cap);
  }

  public void glEnableClientState(int array) {
    glut_h.glEnableClientState(array);
  }

  public void glEnd() {
    glut_h.glEnd();
  }

  public void glEndList() {
    glut_h.glEndList();
  }

  public void glEvalCoord1d(double u) {
    glut_h.glEvalCoord1d(u);
  }

  public void glEvalCoord1dv(Addressable u) {
    glut_h.glEvalCoord1dv(u);
  }

  public void glEvalCoord1f(float u) {
    glut_h.glEvalCoord1f(u);
  }

  public void glEvalCoord1fv(Addressable u) {
    glut_h.glEvalCoord1fv(u);
  }

  public void glEvalCoord2d(double u, double v) {
    glut_h.glEvalCoord2d(u, v);
  }

  public void glEvalCoord2dv(Addressable u) {
    glut_h.glEvalCoord2dv(u);
  }

  public void glEvalCoord2f(float u, float v) {
    glut_h.glEvalCoord2f(u, v);
  }

  public void glEvalCoord2fv(Addressable u) {
    glut_h.glEvalCoord2fv(u);
  }

  public void glEvalMesh1(int mode, int i1, int i2) {
    glut_h.glEvalMesh1(mode, i1, i2);
  }

  public void glEvalMesh2(int mode, int i1, int i2, int j1, int j2) {
    glut_h.glEvalMesh2(mode, i1, i2, j1, j2);
  }

  public void glEvalPoint1(int i) {
    glut_h.glEvalPoint1(i);
  }

  public void glEvalPoint2(int i, int j) {
    glut_h.glEvalPoint2(i, j);
  }

  public void glFeedbackBuffer(int size, int type, Addressable buffer) {
    glut_h.glFeedbackBuffer(size, type, buffer);
  }

  public void glFinish() {
    glut_h.glFinish();
  }

  public void glFlush() {
    glut_h.glFlush();
  }

  public void glFogf(int pname, float param) {
    glut_h.glFogf(pname, param);
  }

  public void glFogfv(int pname, Addressable params) {
    glut_h.glFogfv(pname, params);
  }

  public void glFogi(int pname, int param) {
    glut_h.glFogi(pname, param);
  }

  public void glFogiv(int pname, Addressable params) {
    glut_h.glFogiv(pname, params);
  }

  public void glFrontFace(int mode) {
    glut_h.glFrontFace(mode);
  }

  public void glFrustum(double left, double right, double bottom, double top, double zNear, double zFar) {
    glut_h.glFrustum(left, right, bottom, top, zNear, zFar);
  }

  public int glGenLists(int range) {
    return glut_h.glGenLists(range);
  }

  public void glGenTextures(int n, Addressable textures) {
    glut_h.glGenTextures(n, textures);
  }

  public void glGetBooleanv(int pname, Addressable data) {
    glut_h.glGetBooleanv(pname, data);
  }

  public void glGetClipPlane(int plane, Addressable equation) {
    glut_h.glGetClipPlane(plane, equation);
  }

  public void glGetColorTable(int target, int format, int type, Addressable table) {
    glut_h.glGetColorTable(target, format, type, table);
  }

  public void glGetColorTableParameterfv(int target, int pname, Addressable params) {
    glut_h.glGetColorTableParameterfv(target, pname, params);
  }

  public void glGetColorTableParameteriv(int target, int pname, Addressable params) {
    glut_h.glGetColorTableParameteriv(target, pname, params);
  }

  public void glGetCompressedTexImage(int target, int level, Addressable img) {
    glut_h.glGetCompressedTexImage(target, level, img);
  }

  public void glGetConvolutionFilter(int target, int format, int type, Addressable image) {
    glut_h.glGetConvolutionFilter(target, format, type, image);
  }

  public void glGetConvolutionParameterfv(int target, int pname, Addressable params) {
    glut_h.glGetConvolutionParameterfv(target, pname, params);
  }

  public void glGetConvolutionParameteriv(int target, int pname, Addressable params) {
    glut_h.glGetConvolutionParameteriv(target, pname, params);
  }

  public void glGetDoublev(int pname, Addressable data) {
    glut_h.glGetDoublev(pname, data);
  }

  public int glGetError() {
    return glut_h.glGetError();
  }

  public void glGetFloatv(int pname, Addressable data) {
    glut_h.glGetFloatv(pname, data);
  }

  public void glGetHistogram(int target, byte reset, int format, int type, Addressable values) {
    glut_h.glGetHistogram(target, reset, format, type, values);
  }

  public void glGetHistogramParameterfv(int target, int pname, Addressable params) {
    glut_h.glGetHistogramParameterfv(target, pname, params);
  }

  public void glGetHistogramParameteriv(int target, int pname, Addressable params) {
    glut_h.glGetHistogramParameteriv(target, pname, params);
  }

  public void glGetIntegerv(int pname, Addressable data) {
    glut_h.glGetIntegerv(pname, data);
  }

  public void glGetLightfv(int light, int pname, Addressable params) {
    glut_h.glGetLightfv(light, pname, params);
  }

  public void glGetLightiv(int light, int pname, Addressable params) {
    glut_h.glGetLightiv(light, pname, params);
  }

  public void glGetMapdv(int target, int query, Addressable v) {
    glut_h.glGetMapdv(target, query, v);
  }

  public void glGetMapfv(int target, int query, Addressable v) {
    glut_h.glGetMapfv(target, query, v);
  }

  public void glGetMapiv(int target, int query, Addressable v) {
    glut_h.glGetMapiv(target, query, v);
  }

  public void glGetMaterialfv(int face, int pname, Addressable params) {
    glut_h.glGetMaterialfv(face, pname, params);
  }

  public void glGetMaterialiv(int face, int pname, Addressable params) {
    glut_h.glGetMaterialiv(face, pname, params);
  }

  public void glGetMinmax(int target, byte reset, int format, int type, Addressable values) {
    glut_h.glGetMinmax(target, reset, format, type, values);
  }

  public void glGetMinmaxParameterfv(int target, int pname, Addressable params) {
    glut_h.glGetMinmaxParameterfv(target, pname, params);
  }

  public void glGetMinmaxParameteriv(int target, int pname, Addressable params) {
    glut_h.glGetMinmaxParameteriv(target, pname, params);
  }

  public void glGetPixelMapfv(int map, Addressable values) {
    glut_h.glGetPixelMapfv(map, values);
  }

  public void glGetPixelMapuiv(int map, Addressable values) {
    glut_h.glGetPixelMapuiv(map, values);
  }

  public void glGetPixelMapusv(int map, Addressable values) {
    glut_h.glGetPixelMapusv(map, values);
  }

  public void glGetPointerv(int pname, Addressable params) {
    glut_h.glGetPointerv(pname, params);
  }

  public void glGetPolygonStipple(Addressable mask) {
    glut_h.glGetPolygonStipple(mask);
  }

  public void glGetSeparableFilter(int target, int format, int type, Addressable row, Addressable column, Addressable span) {
    glut_h.glGetSeparableFilter(target, format, type, row, column, span);
  }

  public String glGetString(int name) {
    return glut_h.glGetString(name).getUtf8String(0);
  }

  public void glGetTexEnvfv(int target, int pname, Addressable params) {
    glut_h.glGetTexEnvfv(target, pname, params);
  }

  public void glGetTexEnviv(int target, int pname, Addressable params) {
    glut_h.glGetTexEnviv(target, pname, params);
  }

  public void glGetTexGendv(int coord, int pname, Addressable params) {
    glut_h.glGetTexGendv(coord, pname, params);
  }

  public void glGetTexGenfv(int coord, int pname, Addressable params) {
    glut_h.glGetTexGenfv(coord, pname, params);
  }

  public void glGetTexGeniv(int coord, int pname, Addressable params) {
    glut_h.glGetTexGeniv(coord, pname, params);
  }

  public void glGetTexImage(int target, int level, int format, int type, Addressable pixels) {
    glut_h.glGetTexImage(target, level, format, type, pixels);
  }

  public void glGetTexLevelParameterfv(int target, int level, int pname, Addressable params) {
    glut_h.glGetTexLevelParameterfv(target, level, pname, params);
  }

  public void glGetTexLevelParameteriv(int target, int level, int pname, Addressable params) {
    glut_h.glGetTexLevelParameteriv(target, level, pname, params);
  }

  public void glGetTexParameterfv(int target, int pname, Addressable params) {
    glut_h.glGetTexParameterfv(target, pname, params);
  }

  public void glGetTexParameteriv(int target, int pname, Addressable params) {
    glut_h.glGetTexParameteriv(target, pname, params);
  }

  public void glHint(int target, int mode) {
    glut_h.glHint(target, mode);
  }

  public void glHistogram(int target, int width, int internalformat, byte sink) {
    glut_h.glHistogram(target, width, internalformat, sink);
  }

  public void glIndexMask(int mask) {
    glut_h.glIndexMask(mask);
  }

  public void glIndexPointer(int type, int stride, Addressable pointer) {
    glut_h.glIndexPointer(type, stride, pointer);
  }

  public void glIndexd(double c) {
    glut_h.glIndexd(c);
  }

  public void glIndexdv(Addressable c) {
    glut_h.glIndexdv(c);
  }

  public void glIndexf(float c) {
    glut_h.glIndexf(c);
  }

  public void glIndexfv(Addressable c) {
    glut_h.glIndexfv(c);
  }

  public void glIndexi(int c) {
    glut_h.glIndexi(c);
  }

  public void glIndexiv(Addressable c) {
    glut_h.glIndexiv(c);
  }

  public void glIndexs(short c) {
    glut_h.glIndexs(c);
  }

  public void glIndexsv(Addressable c) {
    glut_h.glIndexsv(c);
  }

  public void glIndexub(byte c) {
    glut_h.glIndexub(c);
  }

  public void glIndexubv(Addressable c) {
    glut_h.glIndexubv(c);
  }

  public void glInitNames() {
    glut_h.glInitNames();
  }

  public void glInterleavedArrays(int format, int stride, Addressable pointer) {
    glut_h.glInterleavedArrays(format, stride, pointer);
  }

  public byte glIsEnabled(int cap) {
    return glut_h.glIsEnabled(cap);
  }

  public byte glIsList(int list) {
    return glut_h.glIsList(list);
  }

  public byte glIsTexture(int texture) {
    return glut_h.glIsTexture(texture);
  }

  public void glLightModelf(int pname, float param) {
    glut_h.glLightModelf(pname, param);
  }

  public void glLightModelfv(int pname, Addressable params) {
    glut_h.glLightModelfv(pname, params);
  }

  public void glLightModeli(int pname, int param) {
    glut_h.glLightModeli(pname, param);
  }

  public void glLightModeliv(int pname, Addressable params) {
    glut_h.glLightModeliv(pname, params);
  }

  public void glLightf(int light, int pname, float param) {
    glut_h.glLightf(light, pname, param);
  }

  public void glLightfv(int light, int pname, Addressable params) {
    glut_h.glLightfv(light, pname, params);
  }

  public void glLighti(int light, int pname, int param) {
    glut_h.glLighti(light, pname, param);
  }

  public void glLightiv(int light, int pname, Addressable params) {
    glut_h.glLightiv(light, pname, params);
  }

  public void glLineStipple(int factor, short pattern) {
    glut_h.glLineStipple(factor, pattern);
  }

  public void glLineWidth(float width) {
    glut_h.glLineWidth(width);
  }

  public void glListBase(int base) {
    glut_h.glListBase(base);
  }

  public void glLoadIdentity() {
    glut_h.glLoadIdentity();
  }

  public void glLoadMatrixd(Addressable m) {
    glut_h.glLoadMatrixd(m);
  }

  public void glLoadMatrixf(Addressable m) {
    glut_h.glLoadMatrixf(m);
  }

  public void glLoadName(int name) {
    glut_h.glLoadName(name);
  }

  public void glLoadTransposeMatrixd(Addressable m) {
    glut_h.glLoadTransposeMatrixd(m);
  }

  public void glLoadTransposeMatrixf(Addressable m) {
    glut_h.glLoadTransposeMatrixf(m);
  }

  public void glLogicOp(int opcode) {
    glut_h.glLogicOp(opcode);
  }

  public void glMap1d(int target, double u1, double u2, int stride, int order, Addressable points) {
    glut_h.glMap1d(target, u1, u2, stride, order, points);
  }

  public void glMap1f(int target, float u1, float u2, int stride, int order, Addressable points) {
    glut_h.glMap1f(target, u1, u2, stride, order, points);
  }

  public void glMap2d(int target, double u1, double u2, int ustride, int uorder, double v1, double v2, int vstride, int vorder, Addressable points) {
    glut_h.glMap2d(target, u1, u2, ustride, uorder, v1, v2, vstride, vorder, points);
  }

  public void glMap2f(int target, float u1, float u2, int ustride, int uorder, float v1, float v2, int vstride, int vorder, Addressable points) {
    glut_h.glMap2f(target, u1, u2, ustride, uorder, v1, v2, vstride, vorder, points);
  }

  public void glMapGrid1d(int un, double u1, double u2) {
    glut_h.glMapGrid1d(un, u1, u2);
  }

  public void glMapGrid1f(int un, float u1, float u2) {
    glut_h.glMapGrid1f(un, u1, u2);
  }

  public void glMapGrid2d(int un, double u1, double u2, int vn, double v1, double v2) {
    glut_h.glMapGrid2d(un, u1, u2, vn, v1, v2);
  }

  public void glMapGrid2f(int un, float u1, float u2, int vn, float v1, float v2) {
    glut_h.glMapGrid2f(un, u1, u2, vn, v1, v2);
  }

  public void glMaterialf(int face, int pname, float param) {
    glut_h.glMaterialf(face, pname, param);
  }

  public void glMaterialfv(int face, int pname, Addressable params) {
    glut_h.glMaterialfv(face, pname, params);
  }

  public void glMateriali(int face, int pname, int param) {
    glut_h.glMateriali(face, pname, param);
  }

  public void glMaterialiv(int face, int pname, Addressable params) {
    glut_h.glMaterialiv(face, pname, params);
  }

  public void glMatrixMode(int mode) {
    glut_h.glMatrixMode(mode);
  }

  public void glMinmax(int target, int internalformat, byte sink) {
    glut_h.glMinmax(target, internalformat, sink);
  }

  public void glMultMatrixd(Addressable m) {
    glut_h.glMultMatrixd(m);
  }

  public void glMultMatrixf(Addressable m) {
    glut_h.glMultMatrixf(m);
  }

  public void glMultTransposeMatrixd(Addressable m) {
    glut_h.glMultTransposeMatrixd(m);
  }

  public void glMultTransposeMatrixf(Addressable m) {
    glut_h.glMultTransposeMatrixf(m);
  }

  public void glMultiTexCoord1d(int target, double s) {
    glut_h.glMultiTexCoord1d(target, s);
  }

  public void glMultiTexCoord1dARB(int target, double s) {
    glut_h.glMultiTexCoord1dARB(target, s);
  }

  public void glMultiTexCoord1dv(int target, Addressable v) {
    glut_h.glMultiTexCoord1dv(target, v);
  }

  public void glMultiTexCoord1dvARB(int target, Addressable v) {
    glut_h.glMultiTexCoord1dvARB(target, v);
  }

  public void glMultiTexCoord1f(int target, float s) {
    glut_h.glMultiTexCoord1f(target, s);
  }

  public void glMultiTexCoord1fARB(int target, float s) {
    glut_h.glMultiTexCoord1fARB(target, s);
  }

  public void glMultiTexCoord1fv(int target, Addressable v) {
    glut_h.glMultiTexCoord1fv(target, v);
  }

  public void glMultiTexCoord1fvARB(int target, Addressable v) {
    glut_h.glMultiTexCoord1fvARB(target, v);
  }

  public void glMultiTexCoord1i(int target, int s) {
    glut_h.glMultiTexCoord1i(target, s);
  }

  public void glMultiTexCoord1iARB(int target, int s) {
    glut_h.glMultiTexCoord1iARB(target, s);
  }

  public void glMultiTexCoord1iv(int target, Addressable v) {
    glut_h.glMultiTexCoord1iv(target, v);
  }

  public void glMultiTexCoord1ivARB(int target, Addressable v) {
    glut_h.glMultiTexCoord1ivARB(target, v);
  }

  public void glMultiTexCoord1s(int target, short s) {
    glut_h.glMultiTexCoord1s(target, s);
  }

  public void glMultiTexCoord1sARB(int target, short s) {
    glut_h.glMultiTexCoord1sARB(target, s);
  }

  public void glMultiTexCoord1sv(int target, Addressable v) {
    glut_h.glMultiTexCoord1sv(target, v);
  }

  public void glMultiTexCoord1svARB(int target, Addressable v) {
    glut_h.glMultiTexCoord1svARB(target, v);
  }

  public void glMultiTexCoord2d(int target, double s, double t) {
    glut_h.glMultiTexCoord2d(target, s, t);
  }

  public void glMultiTexCoord2dARB(int target, double s, double t) {
    glut_h.glMultiTexCoord2dARB(target, s, t);
  }

  public void glMultiTexCoord2dv(int target, Addressable v) {
    glut_h.glMultiTexCoord2dv(target, v);
  }

  public void glMultiTexCoord2dvARB(int target, Addressable v) {
    glut_h.glMultiTexCoord2dvARB(target, v);
  }

  public void glMultiTexCoord2f(int target, float s, float t) {
    glut_h.glMultiTexCoord2f(target, s, t);
  }

  public void glMultiTexCoord2fARB(int target, float s, float t) {
    glut_h.glMultiTexCoord2fARB(target, s, t);
  }

  public void glMultiTexCoord2fv(int target, Addressable v) {
    glut_h.glMultiTexCoord2fv(target, v);
  }

  public void glMultiTexCoord2fvARB(int target, Addressable v) {
    glut_h.glMultiTexCoord2fvARB(target, v);
  }

  public void glMultiTexCoord2i(int target, int s, int t) {
    glut_h.glMultiTexCoord2i(target, s, t);
  }

  public void glMultiTexCoord2iARB(int target, int s, int t) {
    glut_h.glMultiTexCoord2iARB(target, s, t);
  }

  public void glMultiTexCoord2iv(int target, Addressable v) {
    glut_h.glMultiTexCoord2iv(target, v);
  }

  public void glMultiTexCoord2ivARB(int target, Addressable v) {
    glut_h.glMultiTexCoord2ivARB(target, v);
  }

  public void glMultiTexCoord2s(int target, short s, short t) {
    glut_h.glMultiTexCoord2s(target, s, t);
  }

  public void glMultiTexCoord2sARB(int target, short s, short t) {
    glut_h.glMultiTexCoord2sARB(target, s, t);
  }

  public void glMultiTexCoord2sv(int target, Addressable v) {
    glut_h.glMultiTexCoord2sv(target, v);
  }

  public void glMultiTexCoord2svARB(int target, Addressable v) {
    glut_h.glMultiTexCoord2svARB(target, v);
  }

  public void glMultiTexCoord3d(int target, double s, double t, double r) {
    glut_h.glMultiTexCoord3d(target, s, t, r);
  }

  public void glMultiTexCoord3dARB(int target, double s, double t, double r) {
    glut_h.glMultiTexCoord3dARB(target, s, t, r);
  }

  public void glMultiTexCoord3dv(int target, Addressable v) {
    glut_h.glMultiTexCoord3dv(target, v);
  }

  public void glMultiTexCoord3dvARB(int target, Addressable v) {
    glut_h.glMultiTexCoord3dvARB(target, v);
  }

  public void glMultiTexCoord3f(int target, float s, float t, float r) {
    glut_h.glMultiTexCoord3f(target, s, t, r);
  }

  public void glMultiTexCoord3fARB(int target, float s, float t, float r) {
    glut_h.glMultiTexCoord3fARB(target, s, t, r);
  }

  public void glMultiTexCoord3fv(int target, Addressable v) {
    glut_h.glMultiTexCoord3fv(target, v);
  }

  public void glMultiTexCoord3fvARB(int target, Addressable v) {
    glut_h.glMultiTexCoord3fvARB(target, v);
  }

  public void glMultiTexCoord3i(int target, int s, int t, int r) {
    glut_h.glMultiTexCoord3i(target, s, t, r);
  }

  public void glMultiTexCoord3iARB(int target, int s, int t, int r) {
    glut_h.glMultiTexCoord3iARB(target, s, t, r);
  }

  public void glMultiTexCoord3iv(int target, Addressable v) {
    glut_h.glMultiTexCoord3iv(target, v);
  }

  public void glMultiTexCoord3ivARB(int target, Addressable v) {
    glut_h.glMultiTexCoord3ivARB(target, v);
  }

  public void glMultiTexCoord3s(int target, short s, short t, short r) {
    glut_h.glMultiTexCoord3s(target, s, t, r);
  }

  public void glMultiTexCoord3sARB(int target, short s, short t, short r) {
    glut_h.glMultiTexCoord3sARB(target, s, t, r);
  }

  public void glMultiTexCoord3sv(int target, Addressable v) {
    glut_h.glMultiTexCoord3sv(target, v);
  }

  public void glMultiTexCoord3svARB(int target, Addressable v) {
    glut_h.glMultiTexCoord3svARB(target, v);
  }

  public void glMultiTexCoord4d(int target, double s, double t, double r, double q) {
    glut_h.glMultiTexCoord4d(target, s, t, r, q);
  }

  public void glMultiTexCoord4dARB(int target, double s, double t, double r, double q) {
    glut_h.glMultiTexCoord4dARB(target, s, t, r, q);
  }

  public void glMultiTexCoord4dv(int target, Addressable v) {
    glut_h.glMultiTexCoord4dv(target, v);
  }

  public void glMultiTexCoord4dvARB(int target, Addressable v) {
    glut_h.glMultiTexCoord4dvARB(target, v);
  }

  public void glMultiTexCoord4f(int target, float s, float t, float r, float q) {
    glut_h.glMultiTexCoord4f(target, s, t, r, q);
  }

  public void glMultiTexCoord4fARB(int target, float s, float t, float r, float q) {
    glut_h.glMultiTexCoord4fARB(target, s, t, r, q);
  }

  public void glMultiTexCoord4fv(int target, Addressable v) {
    glut_h.glMultiTexCoord4fv(target, v);
  }

  public void glMultiTexCoord4fvARB(int target, Addressable v) {
    glut_h.glMultiTexCoord4fvARB(target, v);
  }

  public void glMultiTexCoord4i(int target, int s, int t, int r, int q) {
    glut_h.glMultiTexCoord4i(target, s, t, r, q);
  }

  public void glMultiTexCoord4iARB(int target, int s, int t, int r, int q) {
    glut_h.glMultiTexCoord4iARB(target, s, t, r, q);
  }

  public void glMultiTexCoord4iv(int target, Addressable v) {
    glut_h.glMultiTexCoord4iv(target, v);
  }

  public void glMultiTexCoord4ivARB(int target, Addressable v) {
    glut_h.glMultiTexCoord4ivARB(target, v);
  }

  public void glMultiTexCoord4s(int target, short s, short t, short r, short q) {
    glut_h.glMultiTexCoord4s(target, s, t, r, q);
  }

  public void glMultiTexCoord4sARB(int target, short s, short t, short r, short q) {
    glut_h.glMultiTexCoord4sARB(target, s, t, r, q);
  }

  public void glMultiTexCoord4sv(int target, Addressable v) {
    glut_h.glMultiTexCoord4sv(target, v);
  }

  public void glMultiTexCoord4svARB(int target, Addressable v) {
    glut_h.glMultiTexCoord4svARB(target, v);
  }

  public void glNewList(int list, int mode) {
    glut_h.glNewList(list, mode);
  }

  public void glNormal3b(byte nx, byte ny, byte nz) {
    glut_h.glNormal3b(nx, ny, nz);
  }

  public void glNormal3bv(Addressable v) {
    glut_h.glNormal3bv(v);
  }

  public void glNormal3d(double nx, double ny, double nz) {
    glut_h.glNormal3d(nx, ny, nz);
  }

  public void glNormal3dv(Addressable v) {
    glut_h.glNormal3dv(v);
  }

  public void glNormal3f(float nx, float ny, float nz) {
    glut_h.glNormal3f(nx, ny, nz);
  }

  public void glNormal3fv(Addressable v) {
    glut_h.glNormal3fv(v);
  }

  public void glNormal3i(int nx, int ny, int nz) {
    glut_h.glNormal3i(nx, ny, nz);
  }

  public void glNormal3iv(Addressable v) {
    glut_h.glNormal3iv(v);
  }

  public void glNormal3s(short nx, short ny, short nz) {
    glut_h.glNormal3s(nx, ny, nz);
  }

  public void glNormal3sv(Addressable v) {
    glut_h.glNormal3sv(v);
  }

  public void glNormalPointer(int type, int stride, Addressable pointer) {
    glut_h.glNormalPointer(type, stride, pointer);
  }

  public void glOrtho(double left, double right, double bottom, double top, double zNear, double zFar) {
    glut_h.glOrtho(left, right, bottom, top, zNear, zFar);
  }

  public void glPassThrough(float token) {
    glut_h.glPassThrough(token);
  }

  public void glPixelMapfv(int map, int mapsize, Addressable values) {
    glut_h.glPixelMapfv(map, mapsize, values);
  }

  public void glPixelMapuiv(int map, int mapsize, Addressable values) {
    glut_h.glPixelMapuiv(map, mapsize, values);
  }

  public void glPixelMapusv(int map, int mapsize, Addressable values) {
    glut_h.glPixelMapusv(map, mapsize, values);
  }

  public void glPixelStoref(int pname, float param) {
    glut_h.glPixelStoref(pname, param);
  }

  public void glPixelStorei(int pname, int param) {
    glut_h.glPixelStorei(pname, param);
  }

  public void glPixelTransferf(int pname, float param) {
    glut_h.glPixelTransferf(pname, param);
  }

  public void glPixelTransferi(int pname, int param) {
    glut_h.glPixelTransferi(pname, param);
  }

  public void glPixelZoom(float xfactor, float yfactor) {
    glut_h.glPixelZoom(xfactor, yfactor);
  }

  public void glPointSize(float size) {
    glut_h.glPointSize(size);
  }

  public void glPolygonMode(int face, int mode) {
    glut_h.glPolygonMode(face, mode);
  }

  public void glPolygonOffset(float factor, float units) {
    glut_h.glPolygonOffset(factor, units);
  }

  public void glPolygonStipple(Addressable mask) {
    glut_h.glPolygonStipple(mask);
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

  public void glPrioritizeTextures(int n, Addressable textures, Addressable priorities) {
    glut_h.glPrioritizeTextures(n, textures, priorities);
  }

  public void glPushAttrib(int mask) {
    glut_h.glPushAttrib(mask);
  }

  public void glPushClientAttrib(int mask) {
    glut_h.glPushClientAttrib(mask);
  }

  public void glPushMatrix() {
    glut_h.glPushMatrix();
  }

  public void glPushName(int name) {
    glut_h.glPushName(name);
  }

  public void glRasterPos2d(double x, double y) {
    glut_h.glRasterPos2d(x, y);
  }

  public void glRasterPos2dv(Addressable v) {
    glut_h.glRasterPos2dv(v);
  }

  public void glRasterPos2f(float x, float y) {
    glut_h.glRasterPos2f(x, y);
  }

  public void glRasterPos2fv(Addressable v) {
    glut_h.glRasterPos2fv(v);
  }

  public void glRasterPos2i(int x, int y) {
    glut_h.glRasterPos2i(x, y);
  }

  public void glRasterPos2iv(Addressable v) {
    glut_h.glRasterPos2iv(v);
  }

  public void glRasterPos2s(short x, short y) {
    glut_h.glRasterPos2s(x, y);
  }

  public void glRasterPos2sv(Addressable v) {
    glut_h.glRasterPos2sv(v);
  }

  public void glRasterPos3d(double x, double y, double z) {
    glut_h.glRasterPos3d(x, y, z);
  }

  public void glRasterPos3dv(Addressable v) {
    glut_h.glRasterPos3dv(v);
  }

  public void glRasterPos3f(float x, float y, float z) {
    glut_h.glRasterPos3f(x, y, z);
  }

  public void glRasterPos3fv(Addressable v) {
    glut_h.glRasterPos3fv(v);
  }

  public void glRasterPos3i(int x, int y, int z) {
    glut_h.glRasterPos3i(x, y, z);
  }

  public void glRasterPos3iv(Addressable v) {
    glut_h.glRasterPos3iv(v);
  }

  public void glRasterPos3s(short x, short y, short z) {
    glut_h.glRasterPos3s(x, y, z);
  }

  public void glRasterPos3sv(Addressable v) {
    glut_h.glRasterPos3sv(v);
  }

  public void glRasterPos4d(double x, double y, double z, double w) {
    glut_h.glRasterPos4d(x, y, z, w);
  }

  public void glRasterPos4dv(Addressable v) {
    glut_h.glRasterPos4dv(v);
  }

  public void glRasterPos4f(float x, float y, float z, float w) {
    glut_h.glRasterPos4f(x, y, z, w);
  }

  public void glRasterPos4fv(Addressable v) {
    glut_h.glRasterPos4fv(v);
  }

  public void glRasterPos4i(int x, int y, int z, int w) {
    glut_h.glRasterPos4i(x, y, z, w);
  }

  public void glRasterPos4iv(Addressable v) {
    glut_h.glRasterPos4iv(v);
  }

  public void glRasterPos4s(short x, short y, short z, short w) {
    glut_h.glRasterPos4s(x, y, z, w);
  }

  public void glRasterPos4sv(Addressable v) {
    glut_h.glRasterPos4sv(v);
  }

  public void glReadBuffer(int src) {
    glut_h.glReadBuffer(src);
  }

  public void glReadPixels(int x, int y, int width, int height, int format, int type, Addressable pixels) {
    glut_h.glReadPixels(x, y, width, height, format, type, pixels);
  }

  public void glRectd(double x1, double y1, double x2, double y2) {
    glut_h.glRectd(x1, y1, x2, y2);
  }

  public void glRectdv(Addressable v1, Addressable v2) {
    glut_h.glRectdv(v1, v2);
  }

  public void glRectf(float x1, float y1, float x2, float y2) {
    glut_h.glRectf(x1, y1, x2, y2);
  }

  public void glRectfv(Addressable v1, Addressable v2) {
    glut_h.glRectfv(v1, v2);
  }

  public void glRecti(int x1, int y1, int x2, int y2) {
    glut_h.glRecti(x1, y1, x2, y2);
  }

  public void glRectiv(Addressable v1, Addressable v2) {
    glut_h.glRectiv(v1, v2);
  }

  public void glRects(short x1, short y1, short x2, short y2) {
    glut_h.glRects(x1, y1, x2, y2);
  }

  public void glRectsv(Addressable v1, Addressable v2) {
    glut_h.glRectsv(v1, v2);
  }

  public int glRenderMode(int mode) {
    return glut_h.glRenderMode(mode);
  }

  public void glResetHistogram(int target) {
    glut_h.glResetHistogram(target);
  }

  public void glResetMinmax(int target) {
    glut_h.glResetMinmax(target);
  }

  public void glRotated(double angle, double x, double y, double z) {
    glut_h.glRotated(angle, x, y, z);
  }

  public void glRotatef(float angle, float x, float y, float z) {
    glut_h.glRotatef(angle, x, y, z);
  }

  public void glSampleCoverage(float value, byte invert) {
    glut_h.glSampleCoverage(value, invert);
  }

  public void glScaled(double x, double y, double z) {
    glut_h.glScaled(x, y, z);
  }

  public void glScalef(float x, float y, float z) {
    glut_h.glScalef(x, y, z);
  }

  public void glScissor(int x, int y, int width, int height) {
    glut_h.glScissor(x, y, width, height);
  }

  public void glSelectBuffer(int size, Addressable buffer) {
    glut_h.glSelectBuffer(size, buffer);
  }

  public void glSeparableFilter2D(int target, int internalformat, int width, int height, int format, int type, Addressable row, Addressable column) {
    glut_h.glSeparableFilter2D(target, internalformat, width, height, format, type, row, column);
  }

  public void glShadeModel(int mode) {
    glut_h.glShadeModel(mode);
  }

  public void glStencilFunc(int func, int ref, int mask) {
    glut_h.glStencilFunc(func, ref, mask);
  }

  public void glStencilMask(int mask) {
    glut_h.glStencilMask(mask);
  }

  public void glStencilOp(int fail, int zfail, int zpass) {
    glut_h.glStencilOp(fail, zfail, zpass);
  }

  public void glTexCoord1d(double s) {
    glut_h.glTexCoord1d(s);
  }

  public void glTexCoord1dv(Addressable v) {
    glut_h.glTexCoord1dv(v);
  }

  public void glTexCoord1f(float s) {
    glut_h.glTexCoord1f(s);
  }

  public void glTexCoord1fv(Addressable v) {
    glut_h.glTexCoord1fv(v);
  }

  public void glTexCoord1i(int s) {
    glut_h.glTexCoord1i(s);
  }

  public void glTexCoord1iv(Addressable v) {
    glut_h.glTexCoord1iv(v);
  }

  public void glTexCoord1s(short s) {
    glut_h.glTexCoord1s(s);
  }

  public void glTexCoord1sv(Addressable v) {
    glut_h.glTexCoord1sv(v);
  }

  public void glTexCoord2d(double s, double t) {
    glut_h.glTexCoord2d(s, t);
  }

  public void glTexCoord2dv(Addressable v) {
    glut_h.glTexCoord2dv(v);
  }

  public void glTexCoord2f(float s, float t) {
    glut_h.glTexCoord2f(s, t);
  }

  public void glTexCoord2fv(Addressable v) {
    glut_h.glTexCoord2fv(v);
  }

  public void glTexCoord2i(int s, int t) {
    glut_h.glTexCoord2i(s, t);
  }

  public void glTexCoord2iv(Addressable v) {
    glut_h.glTexCoord2iv(v);
  }

  public void glTexCoord2s(short s, short t) {
    glut_h.glTexCoord2s(s, t);
  }

  public void glTexCoord2sv(Addressable v) {
    glut_h.glTexCoord2sv(v);
  }

  public void glTexCoord3d(double s, double t, double r) {
    glut_h.glTexCoord3d(s, t, r);
  }

  public void glTexCoord3dv(Addressable v) {
    glut_h.glTexCoord3dv(v);
  }

  public void glTexCoord3f(float s, float t, float r) {
    glut_h.glTexCoord3f(s, t, r);
  }

  public void glTexCoord3fv(Addressable v) {
    glut_h.glTexCoord3fv(v);
  }

  public void glTexCoord3i(int s, int t, int r) {
    glut_h.glTexCoord3i(s, t, r);
  }

  public void glTexCoord3iv(Addressable v) {
    glut_h.glTexCoord3iv(v);
  }

  public void glTexCoord3s(short s, short t, short r) {
    glut_h.glTexCoord3s(s, t, r);
  }

  public void glTexCoord3sv(Addressable v) {
    glut_h.glTexCoord3sv(v);
  }

  public void glTexCoord4d(double s, double t, double r, double q) {
    glut_h.glTexCoord4d(s, t, r, q);
  }

  public void glTexCoord4dv(Addressable v) {
    glut_h.glTexCoord4dv(v);
  }

  public void glTexCoord4f(float s, float t, float r, float q) {
    glut_h.glTexCoord4f(s, t, r, q);
  }

  public void glTexCoord4fv(Addressable v) {
    glut_h.glTexCoord4fv(v);
  }

  public void glTexCoord4i(int s, int t, int r, int q) {
    glut_h.glTexCoord4i(s, t, r, q);
  }

  public void glTexCoord4iv(Addressable v) {
    glut_h.glTexCoord4iv(v);
  }

  public void glTexCoord4s(short s, short t, short r, short q) {
    glut_h.glTexCoord4s(s, t, r, q);
  }

  public void glTexCoord4sv(Addressable v) {
    glut_h.glTexCoord4sv(v);
  }

  public void glTexCoordPointer(int size, int type, int stride, Addressable pointer) {
    glut_h.glTexCoordPointer(size, type, stride, pointer);
  }

  public void glTexEnvf(int target, int pname, float param) {
    glut_h.glTexEnvf(target, pname, param);
  }

  public void glTexEnvfv(int target, int pname, Addressable params) {
    glut_h.glTexEnvfv(target, pname, params);
  }

  public void glTexEnvi(int target, int pname, int param) {
    glut_h.glTexEnvi(target, pname, param);
  }

  public void glTexEnviv(int target, int pname, Addressable params) {
    glut_h.glTexEnviv(target, pname, params);
  }

  public void glTexGend(int coord, int pname, double param) {
    glut_h.glTexGend(coord, pname, param);
  }

  public void glTexGendv(int coord, int pname, Addressable params) {
    glut_h.glTexGendv(coord, pname, params);
  }

  public void glTexGenf(int coord, int pname, float param) {
    glut_h.glTexGenf(coord, pname, param);
  }

  public void glTexGenfv(int coord, int pname, Addressable params) {
    glut_h.glTexGenfv(coord, pname, params);
  }

  public void glTexGeni(int coord, int pname, int param) {
    glut_h.glTexGeni(coord, pname, param);
  }

  public void glTexGeniv(int coord, int pname, Addressable params) {
    glut_h.glTexGeniv(coord, pname, params);
  }

  public void glTexImage1D(int target, int level, int internalformat, int width, int border, int format, int type, Addressable pixels) {
    glut_h.glTexImage1D(target, level, internalformat, width, border, format, type, pixels);
  }

  public void glTexImage2D(int target, int level, int internalformat, int width, int height, int border, int format, int type, Addressable pixels) {
    glut_h.glTexImage2D(target, level, internalformat, width, height, border, format, type, pixels);
  }

  public void glTexImage3D(int target, int level, int internalformat, int width, int height, int depth, int border, int format, int type, Addressable pixels) {
    glut_h.glTexImage3D(target, level, internalformat, width, height, depth, border, format, type, pixels);
  }

  public void glTexParameterf(int target, int pname, float param) {
    glut_h.glTexParameterf(target, pname, param);
  }

  public void glTexParameterfv(int target, int pname, Addressable params) {
    glut_h.glTexParameterfv(target, pname, params);
  }

  public void glTexParameteri(int target, int pname, int param) {
    glut_h.glTexParameteri(target, pname, param);
  }

  public void glTexParameteriv(int target, int pname, Addressable params) {
    glut_h.glTexParameteriv(target, pname, params);
  }

  public void glTexSubImage1D(int target, int level, int xoffset, int width, int format, int type, Addressable pixels) {
    glut_h.glTexSubImage1D(target, level, xoffset, width, format, type, pixels);
  }

  public void glTexSubImage2D(int target, int level, int xoffset, int yoffset, int width, int height, int format, int type, Addressable pixels) {
    glut_h.glTexSubImage2D(target, level, xoffset, yoffset, width, height, format, type, pixels);
  }

  public void glTexSubImage3D(int target, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int format, int type, Addressable pixels) {
    glut_h.glTexSubImage3D(target, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels);
  }

  public void glTranslated(double x, double y, double z) {
    glut_h.glTranslated(x, y, z);
  }

  public void glTranslatef(float x, float y, float z) {
    glut_h.glTranslatef(x, y, z);
  }

  public void glVertex2d(double x, double y) {
    glut_h.glVertex2d(x, y);
  }

  public void glVertex2dv(Addressable v) {
    glut_h.glVertex2dv(v);
  }

  public void glVertex2f(float x, float y) {
    glut_h.glVertex2f(x, y);
  }

  public void glVertex2fv(Addressable v) {
    glut_h.glVertex2fv(v);
  }

  public void glVertex2i(int x, int y) {
    glut_h.glVertex2i(x, y);
  }

  public void glVertex2iv(Addressable v) {
    glut_h.glVertex2iv(v);
  }

  public void glVertex2s(short x, short y) {
    glut_h.glVertex2s(x, y);
  }

  public void glVertex2sv(Addressable v) {
    glut_h.glVertex2sv(v);
  }

  public void glVertex3d(double x, double y, double z) {
    glut_h.glVertex3d(x, y, z);
  }

  public void glVertex3dv(Addressable v) {
    glut_h.glVertex3dv(v);
  }

  public void glVertex3f(float x, float y, float z) {
    glut_h.glVertex3f(x, y, z);
  }

  public void glVertex3fv(Addressable v) {
    glut_h.glVertex3fv(v);
  }

  public void glVertex3i(int x, int y, int z) {
    glut_h.glVertex3i(x, y, z);
  }

  public void glVertex3iv(Addressable v) {
    glut_h.glVertex3iv(v);
  }

  public void glVertex3s(short x, short y, short z) {
    glut_h.glVertex3s(x, y, z);
  }

  public void glVertex3sv(Addressable v) {
    glut_h.glVertex3sv(v);
  }

  public void glVertex4d(double x, double y, double z, double w) {
    glut_h.glVertex4d(x, y, z, w);
  }

  public void glVertex4dv(Addressable v) {
    glut_h.glVertex4dv(v);
  }

  public void glVertex4f(float x, float y, float z, float w) {
    glut_h.glVertex4f(x, y, z, w);
  }

  public void glVertex4fv(Addressable v) {
    glut_h.glVertex4fv(v);
  }

  public void glVertex4i(int x, int y, int z, int w) {
    glut_h.glVertex4i(x, y, z, w);
  }

  public void glVertex4iv(Addressable v) {
    glut_h.glVertex4iv(v);
  }

  public void glVertex4s(short x, short y, short z, short w) {
    glut_h.glVertex4s(x, y, z, w);
  }

  public void glVertex4sv(Addressable v) {
    glut_h.glVertex4sv(v);
  }

  public void glVertexPointer(int size, int type, int stride, Addressable pointer) {
    glut_h.glVertexPointer(size, type, stride, pointer);
  }

  public void glViewport(int x, int y, int width, int height) {
    glut_h.glViewport(x, y, width, height);
  }

  public void gluBeginCurve(Addressable arg0) {
    glut_h.gluBeginCurve(arg0);
  }

  public void gluBeginPolygon(Addressable arg0) {
    glut_h.gluBeginPolygon(arg0);
  }

  public void gluBeginSurface(Addressable arg0) {
    glut_h.gluBeginSurface(arg0);
  }

  public void gluBeginTrim(Addressable arg0) {
    glut_h.gluBeginTrim(arg0);
  }

  public int gluBuild1DMipmapLevels(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, Addressable arg8) {
    return glut_h.gluBuild1DMipmapLevels(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
  }

  public int gluBuild1DMipmaps(int arg0, int arg1, int arg2, int arg3, int arg4, Addressable arg5) {
    return glut_h.gluBuild1DMipmaps(arg0, arg1, arg2, arg3, arg4, arg5);
  }

  public int gluBuild2DMipmapLevels(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, Addressable arg9) {
    return glut_h.gluBuild2DMipmapLevels(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9);
  }

  public int gluBuild2DMipmaps(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, Addressable arg6) {
    return glut_h.gluBuild2DMipmaps(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
  }

  public int gluBuild3DMipmapLevels(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, Addressable arg10) {
    return glut_h.gluBuild3DMipmapLevels(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10);
  }

  public int gluBuild3DMipmaps(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, Addressable arg7) {
    return glut_h.gluBuild3DMipmaps(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7);
  }

  public byte gluCheckExtension(Addressable arg0, Addressable arg1) {
    return glut_h.gluCheckExtension(arg0, arg1);
  }

  public void gluCylinder(Addressable arg0, double arg1, double arg2, double arg3, int arg4, int arg5) {
    glut_h.gluCylinder(arg0, arg1, arg2, arg3, arg4, arg5);
  }

  public void gluDeleteNurbsRenderer(Addressable arg0) {
    glut_h.gluDeleteNurbsRenderer(arg0);
  }

  public void gluDeleteQuadric(Addressable arg0) {
    glut_h.gluDeleteQuadric(arg0);
  }

  public void gluDeleteTess(Addressable arg0) {
    glut_h.gluDeleteTess(arg0);
  }

  public void gluDisk(Addressable arg0, double arg1, double arg2, int arg3, int arg4) {
    glut_h.gluDisk(arg0, arg1, arg2, arg3, arg4);
  }

  public void gluEndCurve(Addressable arg0) {
    glut_h.gluEndCurve(arg0);
  }

  public void gluEndPolygon(Addressable arg0) {
    glut_h.gluEndPolygon(arg0);
  }

  public void gluEndSurface(Addressable arg0) {
    glut_h.gluEndSurface(arg0);
  }

  public void gluEndTrim(Addressable arg0) {
    glut_h.gluEndTrim(arg0);
  }

  public MemoryAddress gluErrorString(int arg0) {
    return glut_h.gluErrorString(arg0);
  }

  public void gluGetNurbsProperty(Addressable arg0, int arg1, Addressable arg2) {
    glut_h.gluGetNurbsProperty(arg0, arg1, arg2);
  }

  public MemoryAddress gluGetString(int arg0) {
    return glut_h.gluGetString(arg0);
  }

  public void gluGetTessProperty(Addressable arg0, int arg1, Addressable arg2) {
    glut_h.gluGetTessProperty(arg0, arg1, arg2);
  }

  public void gluLoadSamplingMatrices(Addressable arg0, Addressable arg1, Addressable arg2, Addressable arg3) {
    glut_h.gluLoadSamplingMatrices(arg0, arg1, arg2, arg3);
  }

  public void gluLookAt(double arg0, double arg1, double arg2, double arg3, double arg4, double arg5, double arg6, double arg7, double arg8) {
    glut_h.gluLookAt(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
  }

  public MemoryAddress gluNewNurbsRenderer() {
    return glut_h.gluNewNurbsRenderer();
  }

  public MemoryAddress gluNewQuadric() {
    return glut_h.gluNewQuadric();
  }

  public MemoryAddress gluNewTess() {
    return glut_h.gluNewTess();
  }

  public void gluNextContour(Addressable arg0, int arg1) {
    glut_h.gluNextContour(arg0, arg1);
  }

  public void gluNurbsCallback(Addressable arg0, int arg1, Addressable arg2) {
    glut_h.gluNurbsCallback(arg0, arg1, arg2);
  }

  public void gluNurbsCallbackData(Addressable arg0, Addressable arg1) {
    glut_h.gluNurbsCallbackData(arg0, arg1);
  }

  public void gluNurbsCallbackDataEXT(Addressable arg0, Addressable arg1) {
    glut_h.gluNurbsCallbackDataEXT(arg0, arg1);
  }

  public void gluNurbsCurve(Addressable arg0, int arg1, Addressable arg2, int arg3, Addressable arg4, int arg5, int arg6) {
    glut_h.gluNurbsCurve(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
  }

  public void gluNurbsProperty(Addressable arg0, int arg1, float arg2) {
    glut_h.gluNurbsProperty(arg0, arg1, arg2);
  }

  public void gluNurbsSurface(Addressable arg0, int arg1, Addressable arg2, int arg3, Addressable arg4, int arg5, int arg6, Addressable arg7, int arg8, int arg9, int arg10) {
    glut_h.gluNurbsSurface(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10);
  }

  public void gluOrtho2D(double arg0, double arg1, double arg2, double arg3) {
    glut_h.gluOrtho2D(arg0, arg1, arg2, arg3);
  }

  public void gluPartialDisk(Addressable arg0, double arg1, double arg2, int arg3, int arg4, double arg5, double arg6) {
    glut_h.gluPartialDisk(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
  }

  public void gluPerspective(double arg0, double arg1, double arg2, double arg3) {
    glut_h.gluPerspective(arg0, arg1, arg2, arg3);
  }

  public void gluPickMatrix(double arg0, double arg1, double arg2, double arg3, Addressable arg4) {
    glut_h.gluPickMatrix(arg0, arg1, arg2, arg3, arg4);
  }

  public int gluProject(double arg0, double arg1, double arg2, Addressable arg3, Addressable arg4, Addressable arg5, Addressable arg6, Addressable arg7, Addressable arg8) {
    return glut_h.gluProject(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
  }

  public void gluPwlCurve(Addressable arg0, int arg1, Addressable arg2, int arg3, int arg4) {
    glut_h.gluPwlCurve(arg0, arg1, arg2, arg3, arg4);
  }

  public void gluQuadricCallback(Addressable arg0, int arg1, Addressable arg2) {
    glut_h.gluQuadricCallback(arg0, arg1, arg2);
  }

  public void gluQuadricDrawStyle(Addressable arg0, int arg1) {
    glut_h.gluQuadricDrawStyle(arg0, arg1);
  }

  public void gluQuadricNormals(Addressable arg0, int arg1) {
    glut_h.gluQuadricNormals(arg0, arg1);
  }

  public void gluQuadricOrientation(Addressable arg0, int arg1) {
    glut_h.gluQuadricOrientation(arg0, arg1);
  }

  public void gluQuadricTexture(Addressable arg0, byte arg1) {
    glut_h.gluQuadricTexture(arg0, arg1);
  }

  public int gluScaleImage(int arg0, int arg1, int arg2, int arg3, Addressable arg4, int arg5, int arg6, int arg7, Addressable arg8) {
    return glut_h.gluScaleImage(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
  }

  public void gluSphere(Addressable arg0, double arg1, int arg2, int arg3) {
    glut_h.gluSphere(arg0, arg1, arg2, arg3);
  }

  public void gluTessBeginContour(Addressable arg0) {
    glut_h.gluTessBeginContour(arg0);
  }

  public void gluTessBeginPolygon(Addressable arg0, Addressable arg1) {
    glut_h.gluTessBeginPolygon(arg0, arg1);
  }

  public void gluTessCallback(Addressable arg0, int arg1, Addressable arg2) {
    glut_h.gluTessCallback(arg0, arg1, arg2);
  }

  public void gluTessEndContour(Addressable arg0) {
    glut_h.gluTessEndContour(arg0);
  }

  public void gluTessEndPolygon(Addressable arg0) {
    glut_h.gluTessEndPolygon(arg0);
  }

  public void gluTessNormal(Addressable arg0, double arg1, double arg2, double arg3) {
    glut_h.gluTessNormal(arg0, arg1, arg2, arg3);
  }

  public void gluTessProperty(Addressable arg0, int arg1, double arg2) {
    glut_h.gluTessProperty(arg0, arg1, arg2);
  }

  public void gluTessVertex(Addressable arg0, Addressable arg1, Addressable arg2) {
    glut_h.gluTessVertex(arg0, arg1, arg2);
  }

  public int gluUnProject(double arg0, double arg1, double arg2, Addressable arg3, Addressable arg4, Addressable arg5, Addressable arg6, Addressable arg7, Addressable arg8) {
    return glut_h.gluUnProject(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
  }

  public int gluUnProject4(double arg0, double arg1, double arg2, double arg3, Addressable arg4, Addressable arg5, Addressable arg6, double arg7, double arg8, Addressable arg9, Addressable arg10, Addressable arg11, Addressable arg12) {
    return glut_h.gluUnProject4(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12);
  }

  public void glutAddMenuEntry(Addressable arg0, int arg1) {
    glut_h.glutAddMenuEntry(arg0, arg1);
  }

  public void glutAddSubMenu(Addressable arg0, int arg1) {
    glut_h.glutAddSubMenu(arg0, arg1);
  }

  public void glutAttachMenu(int arg0) {
    glut_h.glutAttachMenu(arg0);
  }

  public void glutBitmapCharacter(Addressable arg0, int arg1) {
    glut_h.glutBitmapCharacter(arg0, arg1);
  }

  public int glutBitmapLength(Addressable arg0, Addressable arg1) {
    return glut_h.glutBitmapLength(arg0, arg1);
  }

  public int glutBitmapWidth(Addressable arg0, int arg1) {
    return glut_h.glutBitmapWidth(arg0, arg1);
  }

  public void glutButtonBoxFunc(Addressable arg0) {
    glut_h.glutButtonBoxFunc(arg0);
  }

  public void glutChangeToMenuEntry(int arg0, Addressable arg1, int arg2) {
    glut_h.glutChangeToMenuEntry(arg0, arg1, arg2);
  }

  public void glutChangeToSubMenu(int arg0, Addressable arg1, int arg2) {
    glut_h.glutChangeToSubMenu(arg0, arg1, arg2);
  }

  public void glutCopyColormap(int arg0) {
    glut_h.glutCopyColormap(arg0);
  }

  public int glutCreateMenu(Addressable arg0) {
    return glut_h.glutCreateMenu(arg0);
  }

  public int glutCreateSubWindow(int arg0, int arg1, int arg2, int arg3, int arg4) {
    return glut_h.glutCreateSubWindow(arg0, arg1, arg2, arg3, arg4);
  }

  public int glutCreateWindow(Addressable arg0) {
    return glut_h.glutCreateWindow(arg0);
  }

  public void glutDestroyMenu(int arg0) {
    glut_h.glutDestroyMenu(arg0);
  }

  public void glutDestroyWindow(int arg0) {
    glut_h.glutDestroyWindow(arg0);
  }

  public void glutDetachMenu(int arg0) {
    glut_h.glutDetachMenu(arg0);
  }

  public int glutDeviceGet(int arg0) {
    return glut_h.glutDeviceGet(arg0);
  }

  public void glutDialsFunc(Addressable arg0) {
    glut_h.glutDialsFunc(arg0);
  }

  public void glutDisplayFunc(Addressable arg0) {
    glut_h.glutDisplayFunc(arg0);
  }

  public int glutEnterGameMode() {
    return glut_h.glutEnterGameMode();
  }

  public void glutEntryFunc(Addressable arg0) {
    glut_h.glutEntryFunc(arg0);
  }

  public void glutEstablishOverlay() {
    glut_h.glutEstablishOverlay();
  }

  public int glutExtensionSupported(Addressable arg0) {
    return glut_h.glutExtensionSupported(arg0);
  }

  public void glutForceJoystickFunc() {
    glut_h.glutForceJoystickFunc();
  }

  public void glutFullScreen() {
    glut_h.glutFullScreen();
  }

  public int glutGameModeGet(int arg0) {
    return glut_h.glutGameModeGet(arg0);
  }

  public void glutGameModeString(Addressable arg0) {
    glut_h.glutGameModeString(arg0);
  }

  public int glutGet(int arg0) {
    return glut_h.glutGet(arg0);
  }

  public float glutGetColor(int arg0, int arg1) {
    return glut_h.glutGetColor(arg0, arg1);
  }

  public int glutGetMenu() {
    return glut_h.glutGetMenu();
  }

  public int glutGetModifiers() {
    return glut_h.glutGetModifiers();
  }

  public int glutGetWindow() {
    return glut_h.glutGetWindow();
  }

  public void glutHideOverlay() {
    glut_h.glutHideOverlay();
  }

  public void glutHideWindow() {
    glut_h.glutHideWindow();
  }

  public void glutIconifyWindow() {
    glut_h.glutIconifyWindow();
  }

  public void glutIdleFunc(Addressable arg0) {
    glut_h.glutIdleFunc(arg0);
  }

  public void glutIgnoreKeyRepeat(int arg0) {
    glut_h.glutIgnoreKeyRepeat(arg0);
  }

  public void glutInit(Addressable arg0, Addressable arg1) {
    glut_h.glutInit(arg0, arg1);
  }

  public void glutInitDisplayMode(int arg0) {
    glut_h.glutInitDisplayMode(arg0);
  }

  public void glutInitDisplayString(Addressable arg0) {
    glut_h.glutInitDisplayString(arg0);
  }

  public void glutInitWindowPosition(int arg0, int arg1) {
    glut_h.glutInitWindowPosition(arg0, arg1);
  }

  public void glutInitWindowSize(int arg0, int arg1) {
    glut_h.glutInitWindowSize(arg0, arg1);
  }

  public void glutJoystickFunc(Addressable arg0, int arg1) {
    glut_h.glutJoystickFunc(arg0, arg1);
  }

  public void glutKeyboardFunc(Addressable arg0) {
    glut_h.glutKeyboardFunc(arg0);
  }

  public void glutKeyboardUpFunc(Addressable arg0) {
    glut_h.glutKeyboardUpFunc(arg0);
  }

  public int glutLayerGet(int arg0) {
    return glut_h.glutLayerGet(arg0);
  }

  public void glutLeaveGameMode() {
    glut_h.glutLeaveGameMode();
  }

  public void glutMainLoop() {
    glut_h.glutMainLoop();
  }

  public void glutMenuStateFunc(Addressable arg0) {
    glut_h.glutMenuStateFunc(arg0);
  }

  public void glutMenuStatusFunc(Addressable arg0) {
    glut_h.glutMenuStatusFunc(arg0);
  }

  public void glutMotionFunc(Addressable arg0) {
    glut_h.glutMotionFunc(arg0);
  }

  public void glutMouseFunc(Addressable arg0) {
    glut_h.glutMouseFunc(arg0);
  }

  public void glutOverlayDisplayFunc(Addressable arg0) {
    glut_h.glutOverlayDisplayFunc(arg0);
  }

  public void glutPassiveMotionFunc(Addressable arg0) {
    glut_h.glutPassiveMotionFunc(arg0);
  }

  public void glutPopWindow() {
    glut_h.glutPopWindow();
  }

  public void glutPositionWindow(int arg0, int arg1) {
    glut_h.glutPositionWindow(arg0, arg1);
  }

  public void glutPostOverlayRedisplay() {
    glut_h.glutPostOverlayRedisplay();
  }

  public void glutPostRedisplay() {
    glut_h.glutPostRedisplay();
  }

  public void glutPostWindowOverlayRedisplay(int arg0) {
    glut_h.glutPostWindowOverlayRedisplay(arg0);
  }

  public void glutPostWindowRedisplay(int arg0) {
    glut_h.glutPostWindowRedisplay(arg0);
  }

  public void glutPushWindow() {
    glut_h.glutPushWindow();
  }

  public void glutRemoveMenuItem(int arg0) {
    glut_h.glutRemoveMenuItem(arg0);
  }

  public void glutRemoveOverlay() {
    glut_h.glutRemoveOverlay();
  }

  public void glutReportErrors() {
    glut_h.glutReportErrors();
  }

  public void glutReshapeFunc(Addressable arg0) {
    glut_h.glutReshapeFunc(arg0);
  }

  public void glutReshapeWindow(int arg0, int arg1) {
    glut_h.glutReshapeWindow(arg0, arg1);
  }

  public void glutSetColor(int arg0, float arg1, float arg2, float arg3) {
    glut_h.glutSetColor(arg0, arg1, arg2, arg3);
  }

  public void glutSetCursor(int arg0) {
    glut_h.glutSetCursor(arg0);
  }

  public void glutSetIconTitle(Addressable arg0) {
    glut_h.glutSetIconTitle(arg0);
  }

  public void glutSetKeyRepeat(int arg0) {
    glut_h.glutSetKeyRepeat(arg0);
  }

  public void glutSetMenu(int arg0) {
    glut_h.glutSetMenu(arg0);
  }

  public void glutSetWindow(int arg0) {
    glut_h.glutSetWindow(arg0);
  }

  public void glutSetWindowTitle(Addressable arg0) {
    glut_h.glutSetWindowTitle(arg0);
  }

  public void glutSetupVideoResizing() {
    glut_h.glutSetupVideoResizing();
  }

  public void glutShowOverlay() {
    glut_h.glutShowOverlay();
  }

  public void glutShowWindow() {
    glut_h.glutShowWindow();
  }

  public void glutSolidCone(double arg0, double arg1, int arg2, int arg3) {
    glut_h.glutSolidCone(arg0, arg1, arg2, arg3);
  }

  public void glutSolidCube(double arg0) {
    glut_h.glutSolidCube(arg0);
  }

  public void glutSolidDodecahedron() {
    glut_h.glutSolidDodecahedron();
  }

  public void glutSolidIcosahedron() {
    glut_h.glutSolidIcosahedron();
  }

  public void glutSolidOctahedron() {
    glut_h.glutSolidOctahedron();
  }

  public void glutSolidSphere(double arg0, int arg1, int arg2) {
    glut_h.glutSolidSphere(arg0, arg1, arg2);
  }

  public void glutSolidTeapot(double arg0) {
    glut_h.glutSolidTeapot(arg0);
  }

  public void glutSolidTetrahedron() {
    glut_h.glutSolidTetrahedron();
  }

  public void glutSolidTorus(double arg0, double arg1, int arg2, int arg3) {
    glut_h.glutSolidTorus(arg0, arg1, arg2, arg3);
  }

  public void glutSpaceballButtonFunc(Addressable arg0) {
    glut_h.glutSpaceballButtonFunc(arg0);
  }

  public void glutSpaceballMotionFunc(Addressable arg0) {
    glut_h.glutSpaceballMotionFunc(arg0);
  }

  public void glutSpaceballRotateFunc(Addressable arg0) {
    glut_h.glutSpaceballRotateFunc(arg0);
  }

  public void glutSpecialFunc(Addressable arg0) {
    glut_h.glutSpecialFunc(arg0);
  }

  public void glutSpecialUpFunc(Addressable arg0) {
    glut_h.glutSpecialUpFunc(arg0);
  }

  public void glutStopVideoResizing() {
    glut_h.glutStopVideoResizing();
  }

  public void glutStrokeCharacter(Addressable arg0, int arg1) {
    glut_h.glutStrokeCharacter(arg0, arg1);
  }

  public int glutStrokeLength(Addressable arg0, Addressable arg1) {
    return glut_h.glutStrokeLength(arg0, arg1);
  }

  public int glutStrokeWidth(Addressable arg0, int arg1) {
    return glut_h.glutStrokeWidth(arg0, arg1);
  }

  public void glutSwapBuffers() {
    glut_h.glutSwapBuffers();
  }

  public void glutTabletButtonFunc(Addressable arg0) {
    glut_h.glutTabletButtonFunc(arg0);
  }

  public void glutTabletMotionFunc(Addressable arg0) {
    glut_h.glutTabletMotionFunc(arg0);
  }

  public void glutTimerFunc(int arg0, Addressable arg1, int arg2) {
    glut_h.glutTimerFunc(arg0, arg1, arg2);
  }

  public void glutUseLayer(int arg0) {
    glut_h.glutUseLayer(arg0);
  }

  public void glutVideoPan(int arg0, int arg1, int arg2, int arg3) {
    glut_h.glutVideoPan(arg0, arg1, arg2, arg3);
  }

  public void glutVideoResize(int arg0, int arg1, int arg2, int arg3) {
    glut_h.glutVideoResize(arg0, arg1, arg2, arg3);
  }

  public int glutVideoResizeGet(int arg0) {
    return glut_h.glutVideoResizeGet(arg0);
  }

  public void glutVisibilityFunc(Addressable arg0) {
    glut_h.glutVisibilityFunc(arg0);
  }

  public void glutWarpPointer(int arg0, int arg1) {
    glut_h.glutWarpPointer(arg0, arg1);
  }

  public void glutWindowStatusFunc(Addressable arg0) {
    glut_h.glutWindowStatusFunc(arg0);
  }

  public void glutWireCone(double arg0, double arg1, int arg2, int arg3) {
    glut_h.glutWireCone(arg0, arg1, arg2, arg3);
  }

  public void glutWireCube(double arg0) {
    glut_h.glutWireCube(arg0);
  }

  public void glutWireDodecahedron() {
    glut_h.glutWireDodecahedron();
  }

  public void glutWireIcosahedron() {
    glut_h.glutWireIcosahedron();
  }

  public void glutWireOctahedron() {
    glut_h.glutWireOctahedron();
  }

  public void glutWireSphere(double arg0, int arg1, int arg2) {
    glut_h.glutWireSphere(arg0, arg1, arg2);
  }

  public void glutWireTeapot(double arg0) {
    glut_h.glutWireTeapot(arg0);
  }

  public void glutWireTetrahedron() {
    glut_h.glutWireTetrahedron();
  }

  public void glutWireTorus(double arg0, double arg1, int arg2, int arg3) {
    glut_h.glutWireTorus(arg0, arg1, arg2, arg3);
  }

  public void glAccumxOES(int op, int value) {
    glext_h.glAccumxOES(op, value);
  }

  public byte glAcquireKeyedMutexWin32EXT(int memory, long key, int timeout) {
    return glext_h.glAcquireKeyedMutexWin32EXT(memory, key, timeout);
  }

  public void glActiveProgramEXT(int program) {
    glext_h.glActiveProgramEXT(program);
  }

  public void glActiveShaderProgram(int pipeline, int program) {
    glext_h.glActiveShaderProgram(pipeline, program);
  }

  public void glActiveStencilFaceEXT(int face) {
    glext_h.glActiveStencilFaceEXT(face);
  }

  public void glActiveVaryingNV(int program, Addressable name) {
    glext_h.glActiveVaryingNV(program, name);
  }

  public void glAlphaFragmentOp1ATI(int op, int dst, int dstMod, int arg1, int arg1Rep, int arg1Mod) {
    glext_h.glAlphaFragmentOp1ATI(op, dst, dstMod, arg1, arg1Rep, arg1Mod);
  }

  public void glAlphaFragmentOp2ATI(int op, int dst, int dstMod, int arg1, int arg1Rep, int arg1Mod, int arg2, int arg2Rep, int arg2Mod) {
    glext_h.glAlphaFragmentOp2ATI(op, dst, dstMod, arg1, arg1Rep, arg1Mod, arg2, arg2Rep, arg2Mod);
  }

  public void glAlphaFragmentOp3ATI(int op, int dst, int dstMod, int arg1, int arg1Rep, int arg1Mod, int arg2, int arg2Rep, int arg2Mod, int arg3, int arg3Rep, int arg3Mod) {
    glext_h.glAlphaFragmentOp3ATI(op, dst, dstMod, arg1, arg1Rep, arg1Mod, arg2, arg2Rep, arg2Mod, arg3, arg3Rep, arg3Mod);
  }

  public void glAlphaFuncxOES(int func, int ref) {
    glext_h.glAlphaFuncxOES(func, ref);
  }

  public void glAlphaToCoverageDitherControlNV(int mode) {
    glext_h.glAlphaToCoverageDitherControlNV(mode);
  }

  public void glApplyFramebufferAttachmentCMAAINTEL() {
    glext_h.glApplyFramebufferAttachmentCMAAINTEL();
  }

  public void glApplyTextureEXT(int mode) {
    glext_h.glApplyTextureEXT(mode);
  }

  public byte glAreProgramsResidentNV(int n, Addressable programs, Addressable residences) {
    return glext_h.glAreProgramsResidentNV(n, programs, residences);
  }

  public byte glAreTexturesResidentEXT(int n, Addressable textures, Addressable residences) {
    return glext_h.glAreTexturesResidentEXT(n, textures, residences);
  }

  public void glArrayElementEXT(int i) {
    glext_h.glArrayElementEXT(i);
  }

  public void glArrayObjectATI(int array, int size, int type, int stride, int buffer, int offset) {
    glext_h.glArrayObjectATI(array, size, type, stride, buffer, offset);
  }

  public int glAsyncCopyBufferSubDataNVX(int waitSemaphoreCount, Addressable waitSemaphoreArray, Addressable fenceValueArray, int readGpu, int writeGpuMask, int readBuffer, int writeBuffer, long readOffset, long writeOffset, long size, int signalSemaphoreCount, Addressable signalSemaphoreArray, Addressable signalValueArray) {
    return glext_h.glAsyncCopyBufferSubDataNVX(waitSemaphoreCount, waitSemaphoreArray, fenceValueArray, readGpu, writeGpuMask, readBuffer, writeBuffer, readOffset, writeOffset, size, signalSemaphoreCount, signalSemaphoreArray, signalValueArray);
  }

  public int glAsyncCopyImageSubDataNVX(int waitSemaphoreCount, Addressable waitSemaphoreArray, Addressable waitValueArray, int srcGpu, int dstGpuMask, int srcName, int srcTarget, int srcLevel, int srcX, int srcY, int srcZ, int dstName, int dstTarget, int dstLevel, int dstX, int dstY, int dstZ, int srcWidth, int srcHeight, int srcDepth, int signalSemaphoreCount, Addressable signalSemaphoreArray, Addressable signalValueArray) {
    return glext_h.glAsyncCopyImageSubDataNVX(waitSemaphoreCount, waitSemaphoreArray, waitValueArray, srcGpu, dstGpuMask, srcName, srcTarget, srcLevel, srcX, srcY, srcZ, dstName, dstTarget, dstLevel, dstX, dstY, dstZ, srcWidth, srcHeight, srcDepth, signalSemaphoreCount, signalSemaphoreArray, signalValueArray);
  }

  public void glAsyncMarkerSGIX(int marker) {
    glext_h.glAsyncMarkerSGIX(marker);
  }

  public void glAttachObjectARB(int containerObj, int obj) {
    glext_h.glAttachObjectARB(containerObj, obj);
  }

  public void glAttachShader(int program, int shader) {
    glext_h.glAttachShader(program, shader);
  }

  public void glBeginConditionalRender(int id, int mode) {
    glext_h.glBeginConditionalRender(id, mode);
  }

  public void glBeginConditionalRenderNV(int id, int mode) {
    glext_h.glBeginConditionalRenderNV(id, mode);
  }

  public void glBeginConditionalRenderNVX(int id) {
    glext_h.glBeginConditionalRenderNVX(id);
  }

  public void glBeginFragmentShaderATI() {
    glext_h.glBeginFragmentShaderATI();
  }

  public void glBeginOcclusionQueryNV(int id) {
    glext_h.glBeginOcclusionQueryNV(id);
  }

  public void glBeginPerfMonitorAMD(int monitor) {
    glext_h.glBeginPerfMonitorAMD(monitor);
  }

  public void glBeginPerfQueryINTEL(int queryHandle) {
    glext_h.glBeginPerfQueryINTEL(queryHandle);
  }

  public void glBeginQuery(int target, int id) {
    glext_h.glBeginQuery(target, id);
  }

  public void glBeginQueryARB(int target, int id) {
    glext_h.glBeginQueryARB(target, id);
  }

  public void glBeginQueryIndexed(int target, int index, int id) {
    glext_h.glBeginQueryIndexed(target, index, id);
  }

  public void glBeginTransformFeedback(int primitiveMode) {
    glext_h.glBeginTransformFeedback(primitiveMode);
  }

  public void glBeginTransformFeedbackEXT(int primitiveMode) {
    glext_h.glBeginTransformFeedbackEXT(primitiveMode);
  }

  public void glBeginTransformFeedbackNV(int primitiveMode) {
    glext_h.glBeginTransformFeedbackNV(primitiveMode);
  }

  public void glBeginVertexShaderEXT() {
    glext_h.glBeginVertexShaderEXT();
  }

  public void glBeginVideoCaptureNV(int video_capture_slot) {
    glext_h.glBeginVideoCaptureNV(video_capture_slot);
  }

  public void glBindAttribLocation(int program, int index, Addressable name) {
    glext_h.glBindAttribLocation(program, index, name);
  }

  public void glBindAttribLocationARB(int programObj, int index, Addressable name) {
    glext_h.glBindAttribLocationARB(programObj, index, name);
  }

  public void glBindBuffer(int target, int buffer) {
    glext_h.glBindBuffer(target, buffer);
  }

  public void glBindBufferARB(int target, int buffer) {
    glext_h.glBindBufferARB(target, buffer);
  }

  public void glBindBufferBase(int target, int index, int buffer) {
    glext_h.glBindBufferBase(target, index, buffer);
  }

  public void glBindBufferBaseEXT(int target, int index, int buffer) {
    glext_h.glBindBufferBaseEXT(target, index, buffer);
  }

  public void glBindBufferBaseNV(int target, int index, int buffer) {
    glext_h.glBindBufferBaseNV(target, index, buffer);
  }

  public void glBindBufferOffsetEXT(int target, int index, int buffer, long offset) {
    glext_h.glBindBufferOffsetEXT(target, index, buffer, offset);
  }

  public void glBindBufferOffsetNV(int target, int index, int buffer, long offset) {
    glext_h.glBindBufferOffsetNV(target, index, buffer, offset);
  }

  public void glBindBufferRange(int target, int index, int buffer, long offset, long size) {
    glext_h.glBindBufferRange(target, index, buffer, offset, size);
  }

  public void glBindBufferRangeEXT(int target, int index, int buffer, long offset, long size) {
    glext_h.glBindBufferRangeEXT(target, index, buffer, offset, size);
  }

  public void glBindBufferRangeNV(int target, int index, int buffer, long offset, long size) {
    glext_h.glBindBufferRangeNV(target, index, buffer, offset, size);
  }

  public void glBindBuffersBase(int target, int first, int count, Addressable buffers) {
    glext_h.glBindBuffersBase(target, first, count, buffers);
  }

  public void glBindBuffersRange(int target, int first, int count, Addressable buffers, Addressable offsets, Addressable sizes) {
    glext_h.glBindBuffersRange(target, first, count, buffers, offsets, sizes);
  }

  public void glBindFragDataLocation(int program, int color, Addressable name) {
    glext_h.glBindFragDataLocation(program, color, name);
  }

  public void glBindFragDataLocationEXT(int program, int color, Addressable name) {
    glext_h.glBindFragDataLocationEXT(program, color, name);
  }

  public void glBindFragDataLocationIndexed(int program, int colorNumber, int index, Addressable name) {
    glext_h.glBindFragDataLocationIndexed(program, colorNumber, index, name);
  }

  public void glBindFragmentShaderATI(int id) {
    glext_h.glBindFragmentShaderATI(id);
  }

  public void glBindFramebuffer(int target, int framebuffer) {
    glext_h.glBindFramebuffer(target, framebuffer);
  }

  public void glBindFramebufferEXT(int target, int framebuffer) {
    glext_h.glBindFramebufferEXT(target, framebuffer);
  }

  public void glBindImageTexture(int unit, int texture, int level, byte layered, int layer, int access, int format) {
    glext_h.glBindImageTexture(unit, texture, level, layered, layer, access, format);
  }

  public void glBindImageTextureEXT(int index, int texture, int level, byte layered, int layer, int access, int format) {
    glext_h.glBindImageTextureEXT(index, texture, level, layered, layer, access, format);
  }

  public void glBindImageTextures(int first, int count, Addressable textures) {
    glext_h.glBindImageTextures(first, count, textures);
  }

  public int glBindLightParameterEXT(int light, int value) {
    return glext_h.glBindLightParameterEXT(light, value);
  }

  public int glBindMaterialParameterEXT(int face, int value) {
    return glext_h.glBindMaterialParameterEXT(face, value);
  }

  public void glBindMultiTextureEXT(int texunit, int target, int texture) {
    glext_h.glBindMultiTextureEXT(texunit, target, texture);
  }

  public int glBindParameterEXT(int value) {
    return glext_h.glBindParameterEXT(value);
  }

  public void glBindProgramARB(int target, int program) {
    glext_h.glBindProgramARB(target, program);
  }

  public void glBindProgramNV(int target, int id) {
    glext_h.glBindProgramNV(target, id);
  }

  public void glBindProgramPipeline(int pipeline) {
    glext_h.glBindProgramPipeline(pipeline);
  }

  public void glBindRenderbuffer(int target, int renderbuffer) {
    glext_h.glBindRenderbuffer(target, renderbuffer);
  }

  public void glBindRenderbufferEXT(int target, int renderbuffer) {
    glext_h.glBindRenderbufferEXT(target, renderbuffer);
  }

  public void glBindSampler(int unit, int sampler) {
    glext_h.glBindSampler(unit, sampler);
  }

  public void glBindSamplers(int first, int count, Addressable samplers) {
    glext_h.glBindSamplers(first, count, samplers);
  }

  public void glBindShadingRateImageNV(int texture) {
    glext_h.glBindShadingRateImageNV(texture);
  }

  public int glBindTexGenParameterEXT(int unit, int coord, int value) {
    return glext_h.glBindTexGenParameterEXT(unit, coord, value);
  }

  public void glBindTextureEXT(int target, int texture) {
    glext_h.glBindTextureEXT(target, texture);
  }

  public void glBindTextureUnit(int unit, int texture) {
    glext_h.glBindTextureUnit(unit, texture);
  }

  public int glBindTextureUnitParameterEXT(int unit, int value) {
    return glext_h.glBindTextureUnitParameterEXT(unit, value);
  }

  public void glBindTextures(int first, int count, Addressable textures) {
    glext_h.glBindTextures(first, count, textures);
  }

  public void glBindTransformFeedback(int target, int id) {
    glext_h.glBindTransformFeedback(target, id);
  }

  public void glBindTransformFeedbackNV(int target, int id) {
    glext_h.glBindTransformFeedbackNV(target, id);
  }

  public void glBindVertexArray(int array) {
    glext_h.glBindVertexArray(array);
  }

  public void glBindVertexArrayAPPLE(int array) {
    glext_h.glBindVertexArrayAPPLE(array);
  }

  public void glBindVertexBuffer(int bindingindex, int buffer, long offset, int stride) {
    glext_h.glBindVertexBuffer(bindingindex, buffer, offset, stride);
  }

  public void glBindVertexBuffers(int first, int count, Addressable buffers, Addressable offsets, Addressable strides) {
    glext_h.glBindVertexBuffers(first, count, buffers, offsets, strides);
  }

  public void glBindVertexShaderEXT(int id) {
    glext_h.glBindVertexShaderEXT(id);
  }

  public void glBindVideoCaptureStreamBufferNV(int video_capture_slot, int stream, int frame_region, long offset) {
    glext_h.glBindVideoCaptureStreamBufferNV(video_capture_slot, stream, frame_region, offset);
  }

  public void glBindVideoCaptureStreamTextureNV(int video_capture_slot, int stream, int frame_region, int target, int texture) {
    glext_h.glBindVideoCaptureStreamTextureNV(video_capture_slot, stream, frame_region, target, texture);
  }

  public void glBinormal3bEXT(byte bx, byte by, byte bz) {
    glext_h.glBinormal3bEXT(bx, by, bz);
  }

  public void glBinormal3bvEXT(Addressable v) {
    glext_h.glBinormal3bvEXT(v);
  }

  public void glBinormal3dEXT(double bx, double by, double bz) {
    glext_h.glBinormal3dEXT(bx, by, bz);
  }

  public void glBinormal3dvEXT(Addressable v) {
    glext_h.glBinormal3dvEXT(v);
  }

  public void glBinormal3fEXT(float bx, float by, float bz) {
    glext_h.glBinormal3fEXT(bx, by, bz);
  }

  public void glBinormal3fvEXT(Addressable v) {
    glext_h.glBinormal3fvEXT(v);
  }

  public void glBinormal3iEXT(int bx, int by, int bz) {
    glext_h.glBinormal3iEXT(bx, by, bz);
  }

  public void glBinormal3ivEXT(Addressable v) {
    glext_h.glBinormal3ivEXT(v);
  }

  public void glBinormal3sEXT(short bx, short by, short bz) {
    glext_h.glBinormal3sEXT(bx, by, bz);
  }

  public void glBinormal3svEXT(Addressable v) {
    glext_h.glBinormal3svEXT(v);
  }

  public void glBinormalPointerEXT(int type, int stride, Addressable pointer) {
    glext_h.glBinormalPointerEXT(type, stride, pointer);
  }

  public void glBitmapxOES(int width, int height, int xorig, int yorig, int xmove, int ymove, Addressable bitmap) {
    glext_h.glBitmapxOES(width, height, xorig, yorig, xmove, ymove, bitmap);
  }

  public void glBlendBarrierKHR() {
    glext_h.glBlendBarrierKHR();
  }

  public void glBlendBarrierNV() {
    glext_h.glBlendBarrierNV();
  }

  public void glBlendColorEXT(float red, float green, float blue, float alpha) {
    glext_h.glBlendColorEXT(red, green, blue, alpha);
  }

  public void glBlendColorxOES(int red, int green, int blue, int alpha) {
    glext_h.glBlendColorxOES(red, green, blue, alpha);
  }

  public void glBlendEquationEXT(int mode) {
    glext_h.glBlendEquationEXT(mode);
  }

  public void glBlendEquationIndexedAMD(int buf, int mode) {
    glext_h.glBlendEquationIndexedAMD(buf, mode);
  }

  public void glBlendEquationSeparate(int modeRGB, int modeAlpha) {
    glext_h.glBlendEquationSeparate(modeRGB, modeAlpha);
  }

  public void glBlendEquationSeparateEXT(int modeRGB, int modeAlpha) {
    glext_h.glBlendEquationSeparateEXT(modeRGB, modeAlpha);
  }

  public void glBlendEquationSeparateIndexedAMD(int buf, int modeRGB, int modeAlpha) {
    glext_h.glBlendEquationSeparateIndexedAMD(buf, modeRGB, modeAlpha);
  }

  public void glBlendEquationSeparatei(int buf, int modeRGB, int modeAlpha) {
    glext_h.glBlendEquationSeparatei(buf, modeRGB, modeAlpha);
  }

  public void glBlendEquationSeparateiARB(int buf, int modeRGB, int modeAlpha) {
    glext_h.glBlendEquationSeparateiARB(buf, modeRGB, modeAlpha);
  }

  public void glBlendEquationi(int buf, int mode) {
    glext_h.glBlendEquationi(buf, mode);
  }

  public void glBlendEquationiARB(int buf, int mode) {
    glext_h.glBlendEquationiARB(buf, mode);
  }

  public void glBlendFuncIndexedAMD(int buf, int src, int dst) {
    glext_h.glBlendFuncIndexedAMD(buf, src, dst);
  }

  public void glBlendFuncSeparate(int sfactorRGB, int dfactorRGB, int sfactorAlpha, int dfactorAlpha) {
    glext_h.glBlendFuncSeparate(sfactorRGB, dfactorRGB, sfactorAlpha, dfactorAlpha);
  }

  public void glBlendFuncSeparateEXT(int sfactorRGB, int dfactorRGB, int sfactorAlpha, int dfactorAlpha) {
    glext_h.glBlendFuncSeparateEXT(sfactorRGB, dfactorRGB, sfactorAlpha, dfactorAlpha);
  }

  public void glBlendFuncSeparateINGR(int sfactorRGB, int dfactorRGB, int sfactorAlpha, int dfactorAlpha) {
    glext_h.glBlendFuncSeparateINGR(sfactorRGB, dfactorRGB, sfactorAlpha, dfactorAlpha);
  }

  public void glBlendFuncSeparateIndexedAMD(int buf, int srcRGB, int dstRGB, int srcAlpha, int dstAlpha) {
    glext_h.glBlendFuncSeparateIndexedAMD(buf, srcRGB, dstRGB, srcAlpha, dstAlpha);
  }

  public void glBlendFuncSeparatei(int buf, int srcRGB, int dstRGB, int srcAlpha, int dstAlpha) {
    glext_h.glBlendFuncSeparatei(buf, srcRGB, dstRGB, srcAlpha, dstAlpha);
  }

  public void glBlendFuncSeparateiARB(int buf, int srcRGB, int dstRGB, int srcAlpha, int dstAlpha) {
    glext_h.glBlendFuncSeparateiARB(buf, srcRGB, dstRGB, srcAlpha, dstAlpha);
  }

  public void glBlendFunci(int buf, int src, int dst) {
    glext_h.glBlendFunci(buf, src, dst);
  }

  public void glBlendFunciARB(int buf, int src, int dst) {
    glext_h.glBlendFunciARB(buf, src, dst);
  }

  public void glBlendParameteriNV(int pname, int value) {
    glext_h.glBlendParameteriNV(pname, value);
  }

  public void glBlitFramebuffer(int srcX0, int srcY0, int srcX1, int srcY1, int dstX0, int dstY0, int dstX1, int dstY1, int mask, int filter) {
    glext_h.glBlitFramebuffer(srcX0, srcY0, srcX1, srcY1, dstX0, dstY0, dstX1, dstY1, mask, filter);
  }

  public void glBlitFramebufferEXT(int srcX0, int srcY0, int srcX1, int srcY1, int dstX0, int dstY0, int dstX1, int dstY1, int mask, int filter) {
    glext_h.glBlitFramebufferEXT(srcX0, srcY0, srcX1, srcY1, dstX0, dstY0, dstX1, dstY1, mask, filter);
  }

  public void glBlitNamedFramebuffer(int readFramebuffer, int drawFramebuffer, int srcX0, int srcY0, int srcX1, int srcY1, int dstX0, int dstY0, int dstX1, int dstY1, int mask, int filter) {
    glext_h.glBlitNamedFramebuffer(readFramebuffer, drawFramebuffer, srcX0, srcY0, srcX1, srcY1, dstX0, dstY0, dstX1, dstY1, mask, filter);
  }

  public void glBufferAddressRangeNV(int pname, int index, long address, long length) {
    glext_h.glBufferAddressRangeNV(pname, index, address, length);
  }

  public void glBufferAttachMemoryNV(int target, int memory, long offset) {
    glext_h.glBufferAttachMemoryNV(target, memory, offset);
  }

  public void glBufferData(int target, long size, Addressable data, int usage) {
    glext_h.glBufferData(target, size, data, usage);
  }

  public void glBufferDataARB(int target, long size, Addressable data, int usage) {
    glext_h.glBufferDataARB(target, size, data, usage);
  }

  public void glBufferPageCommitmentARB(int target, long offset, long size, byte commit) {
    glext_h.glBufferPageCommitmentARB(target, offset, size, commit);
  }

  public void glBufferParameteriAPPLE(int target, int pname, int param) {
    glext_h.glBufferParameteriAPPLE(target, pname, param);
  }

  public void glBufferStorage(int target, long size, Addressable data, int flags) {
    glext_h.glBufferStorage(target, size, data, flags);
  }

  public void glBufferStorageExternalEXT(int target, long offset, long size, Addressable clientBuffer, int flags) {
    glext_h.glBufferStorageExternalEXT(target, offset, size, clientBuffer, flags);
  }

  public void glBufferStorageMemEXT(int target, long size, int memory, long offset) {
    glext_h.glBufferStorageMemEXT(target, size, memory, offset);
  }

  public void glBufferSubData(int target, long offset, long size, Addressable data) {
    glext_h.glBufferSubData(target, offset, size, data);
  }

  public void glBufferSubDataARB(int target, long offset, long size, Addressable data) {
    glext_h.glBufferSubDataARB(target, offset, size, data);
  }

  public void glCallCommandListNV(int list) {
    glext_h.glCallCommandListNV(list);
  }

  public int glCheckFramebufferStatus(int target) {
    return glext_h.glCheckFramebufferStatus(target);
  }

  public int glCheckFramebufferStatusEXT(int target) {
    return glext_h.glCheckFramebufferStatusEXT(target);
  }

  public int glCheckNamedFramebufferStatus(int framebuffer, int target) {
    return glext_h.glCheckNamedFramebufferStatus(framebuffer, target);
  }

  public int glCheckNamedFramebufferStatusEXT(int framebuffer, int target) {
    return glext_h.glCheckNamedFramebufferStatusEXT(framebuffer, target);
  }

  public void glClampColor(int target, int clamp) {
    glext_h.glClampColor(target, clamp);
  }

  public void glClampColorARB(int target, int clamp) {
    glext_h.glClampColorARB(target, clamp);
  }

  public void glClearAccumxOES(int red, int green, int blue, int alpha) {
    glext_h.glClearAccumxOES(red, green, blue, alpha);
  }

  public void glClearBufferData(int target, int internalformat, int format, int type, Addressable data) {
    glext_h.glClearBufferData(target, internalformat, format, type, data);
  }

  public void glClearBufferSubData(int target, int internalformat, long offset, long size, int format, int type, Addressable data) {
    glext_h.glClearBufferSubData(target, internalformat, offset, size, format, type, data);
  }

  public void glClearBufferfi(int buffer, int drawbuffer, float depth, int stencil) {
    glext_h.glClearBufferfi(buffer, drawbuffer, depth, stencil);
  }

  public void glClearBufferfv(int buffer, int drawbuffer, Addressable value) {
    glext_h.glClearBufferfv(buffer, drawbuffer, value);
  }

  public void glClearBufferiv(int buffer, int drawbuffer, Addressable value) {
    glext_h.glClearBufferiv(buffer, drawbuffer, value);
  }

  public void glClearBufferuiv(int buffer, int drawbuffer, Addressable value) {
    glext_h.glClearBufferuiv(buffer, drawbuffer, value);
  }

  public void glClearColorIiEXT(int red, int green, int blue, int alpha) {
    glext_h.glClearColorIiEXT(red, green, blue, alpha);
  }

  public void glClearColorIuiEXT(int red, int green, int blue, int alpha) {
    glext_h.glClearColorIuiEXT(red, green, blue, alpha);
  }

  public void glClearColorxOES(int red, int green, int blue, int alpha) {
    glext_h.glClearColorxOES(red, green, blue, alpha);
  }

  public void glClearDepthdNV(double depth) {
    glext_h.glClearDepthdNV(depth);
  }

  public void glClearDepthf(float d) {
    glext_h.glClearDepthf(d);
  }

  public void glClearDepthfOES(float depth) {
    glext_h.glClearDepthfOES(depth);
  }

  public void glClearDepthxOES(int depth) {
    glext_h.glClearDepthxOES(depth);
  }

  public void glClearNamedBufferData(int buffer, int internalformat, int format, int type, Addressable data) {
    glext_h.glClearNamedBufferData(buffer, internalformat, format, type, data);
  }

  public void glClearNamedBufferDataEXT(int buffer, int internalformat, int format, int type, Addressable data) {
    glext_h.glClearNamedBufferDataEXT(buffer, internalformat, format, type, data);
  }

  public void glClearNamedBufferSubData(int buffer, int internalformat, long offset, long size, int format, int type, Addressable data) {
    glext_h.glClearNamedBufferSubData(buffer, internalformat, offset, size, format, type, data);
  }

  public void glClearNamedBufferSubDataEXT(int buffer, int internalformat, long offset, long size, int format, int type, Addressable data) {
    glext_h.glClearNamedBufferSubDataEXT(buffer, internalformat, offset, size, format, type, data);
  }

  public void glClearNamedFramebufferfi(int framebuffer, int buffer, int drawbuffer, float depth, int stencil) {
    glext_h.glClearNamedFramebufferfi(framebuffer, buffer, drawbuffer, depth, stencil);
  }

  public void glClearNamedFramebufferfv(int framebuffer, int buffer, int drawbuffer, Addressable value) {
    glext_h.glClearNamedFramebufferfv(framebuffer, buffer, drawbuffer, value);
  }

  public void glClearNamedFramebufferiv(int framebuffer, int buffer, int drawbuffer, Addressable value) {
    glext_h.glClearNamedFramebufferiv(framebuffer, buffer, drawbuffer, value);
  }

  public void glClearNamedFramebufferuiv(int framebuffer, int buffer, int drawbuffer, Addressable value) {
    glext_h.glClearNamedFramebufferuiv(framebuffer, buffer, drawbuffer, value);
  }

  public void glClearTexImage(int texture, int level, int format, int type, Addressable data) {
    glext_h.glClearTexImage(texture, level, format, type, data);
  }

  public void glClearTexSubImage(int texture, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int format, int type, Addressable data) {
    glext_h.glClearTexSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, data);
  }

  public void glClientActiveVertexStreamATI(int stream) {
    glext_h.glClientActiveVertexStreamATI(stream);
  }

  public void glClientAttribDefaultEXT(int mask) {
    glext_h.glClientAttribDefaultEXT(mask);
  }

  public void glClientWaitSemaphoreui64NVX(int fenceObjectCount, Addressable semaphoreArray, Addressable fenceValueArray) {
    glext_h.glClientWaitSemaphoreui64NVX(fenceObjectCount, semaphoreArray, fenceValueArray);
  }

  public int glClientWaitSync(Addressable sync, int flags, long timeout) {
    return glext_h.glClientWaitSync(sync, flags, timeout);
  }

  public void glClipControl(int origin, int depth) {
    glext_h.glClipControl(origin, depth);
  }

  public void glClipPlanefOES(int plane, Addressable equation) {
    glext_h.glClipPlanefOES(plane, equation);
  }

  public void glClipPlanexOES(int plane, Addressable equation) {
    glext_h.glClipPlanexOES(plane, equation);
  }

  public void glColor3fVertex3fSUN(float r, float g, float b, float x, float y, float z) {
    glext_h.glColor3fVertex3fSUN(r, g, b, x, y, z);
  }

  public void glColor3fVertex3fvSUN(Addressable c, Addressable v) {
    glext_h.glColor3fVertex3fvSUN(c, v);
  }

  public void glColor3hNV(short red, short green, short blue) {
    glext_h.glColor3hNV(red, green, blue);
  }

  public void glColor3hvNV(Addressable v) {
    glext_h.glColor3hvNV(v);
  }

  public void glColor3xOES(int red, int green, int blue) {
    glext_h.glColor3xOES(red, green, blue);
  }

  public void glColor3xvOES(Addressable components) {
    glext_h.glColor3xvOES(components);
  }

  public void glColor4fNormal3fVertex3fSUN(float r, float g, float b, float a, float nx, float ny, float nz, float x, float y, float z) {
    glext_h.glColor4fNormal3fVertex3fSUN(r, g, b, a, nx, ny, nz, x, y, z);
  }

  public void glColor4fNormal3fVertex3fvSUN(Addressable c, Addressable n, Addressable v) {
    glext_h.glColor4fNormal3fVertex3fvSUN(c, n, v);
  }

  public void glColor4hNV(short red, short green, short blue, short alpha) {
    glext_h.glColor4hNV(red, green, blue, alpha);
  }

  public void glColor4hvNV(Addressable v) {
    glext_h.glColor4hvNV(v);
  }

  public void glColor4ubVertex2fSUN(byte r, byte g, byte b, byte a, float x, float y) {
    glext_h.glColor4ubVertex2fSUN(r, g, b, a, x, y);
  }

  public void glColor4ubVertex2fvSUN(Addressable c, Addressable v) {
    glext_h.glColor4ubVertex2fvSUN(c, v);
  }

  public void glColor4ubVertex3fSUN(byte r, byte g, byte b, byte a, float x, float y, float z) {
    glext_h.glColor4ubVertex3fSUN(r, g, b, a, x, y, z);
  }

  public void glColor4ubVertex3fvSUN(Addressable c, Addressable v) {
    glext_h.glColor4ubVertex3fvSUN(c, v);
  }

  public void glColor4xOES(int red, int green, int blue, int alpha) {
    glext_h.glColor4xOES(red, green, blue, alpha);
  }

  public void glColor4xvOES(Addressable components) {
    glext_h.glColor4xvOES(components);
  }

  public void glColorFormatNV(int size, int type, int stride) {
    glext_h.glColorFormatNV(size, type, stride);
  }

  public void glColorFragmentOp1ATI(int op, int dst, int dstMask, int dstMod, int arg1, int arg1Rep, int arg1Mod) {
    glext_h.glColorFragmentOp1ATI(op, dst, dstMask, dstMod, arg1, arg1Rep, arg1Mod);
  }

  public void glColorFragmentOp2ATI(int op, int dst, int dstMask, int dstMod, int arg1, int arg1Rep, int arg1Mod, int arg2, int arg2Rep, int arg2Mod) {
    glext_h.glColorFragmentOp2ATI(op, dst, dstMask, dstMod, arg1, arg1Rep, arg1Mod, arg2, arg2Rep, arg2Mod);
  }

  public void glColorFragmentOp3ATI(int op, int dst, int dstMask, int dstMod, int arg1, int arg1Rep, int arg1Mod, int arg2, int arg2Rep, int arg2Mod, int arg3, int arg3Rep, int arg3Mod) {
    glext_h.glColorFragmentOp3ATI(op, dst, dstMask, dstMod, arg1, arg1Rep, arg1Mod, arg2, arg2Rep, arg2Mod, arg3, arg3Rep, arg3Mod);
  }

  public void glColorMaskIndexedEXT(int index, byte r, byte g, byte b, byte a) {
    glext_h.glColorMaskIndexedEXT(index, r, g, b, a);
  }

  public void glColorMaski(int index, byte r, byte g, byte b, byte a) {
    glext_h.glColorMaski(index, r, g, b, a);
  }

  public void glColorP3ui(int type, int color) {
    glext_h.glColorP3ui(type, color);
  }

  public void glColorP3uiv(int type, Addressable color) {
    glext_h.glColorP3uiv(type, color);
  }

  public void glColorP4ui(int type, int color) {
    glext_h.glColorP4ui(type, color);
  }

  public void glColorP4uiv(int type, Addressable color) {
    glext_h.glColorP4uiv(type, color);
  }

  public void glColorPointerEXT(int size, int type, int stride, int count, Addressable pointer) {
    glext_h.glColorPointerEXT(size, type, stride, count, pointer);
  }

  public void glColorPointerListIBM(int size, int type, int stride, Addressable pointer, int ptrstride) {
    glext_h.glColorPointerListIBM(size, type, stride, pointer, ptrstride);
  }

  public void glColorPointervINTEL(int size, int type, Addressable pointer) {
    glext_h.glColorPointervINTEL(size, type, pointer);
  }

  public void glColorSubTableEXT(int target, int start, int count, int format, int type, Addressable data) {
    glext_h.glColorSubTableEXT(target, start, count, format, type, data);
  }

  public void glColorTableEXT(int target, int internalFormat, int width, int format, int type, Addressable table) {
    glext_h.glColorTableEXT(target, internalFormat, width, format, type, table);
  }

  public void glColorTableParameterfvSGI(int target, int pname, Addressable params) {
    glext_h.glColorTableParameterfvSGI(target, pname, params);
  }

  public void glColorTableParameterivSGI(int target, int pname, Addressable params) {
    glext_h.glColorTableParameterivSGI(target, pname, params);
  }

  public void glColorTableSGI(int target, int internalformat, int width, int format, int type, Addressable table) {
    glext_h.glColorTableSGI(target, internalformat, width, format, type, table);
  }

  public void glCombinerInputNV(int stage, int portion, int variable, int input, int mapping, int componentUsage) {
    glext_h.glCombinerInputNV(stage, portion, variable, input, mapping, componentUsage);
  }

  public void glCombinerOutputNV(int stage, int portion, int abOutput, int cdOutput, int sumOutput, int scale, int bias, byte abDotProduct, byte cdDotProduct, byte muxSum) {
    glext_h.glCombinerOutputNV(stage, portion, abOutput, cdOutput, sumOutput, scale, bias, abDotProduct, cdDotProduct, muxSum);
  }

  public void glCombinerParameterfNV(int pname, float param) {
    glext_h.glCombinerParameterfNV(pname, param);
  }

  public void glCombinerParameterfvNV(int pname, Addressable params) {
    glext_h.glCombinerParameterfvNV(pname, params);
  }

  public void glCombinerParameteriNV(int pname, int param) {
    glext_h.glCombinerParameteriNV(pname, param);
  }

  public void glCombinerParameterivNV(int pname, Addressable params) {
    glext_h.glCombinerParameterivNV(pname, params);
  }

  public void glCombinerStageParameterfvNV(int stage, int pname, Addressable params) {
    glext_h.glCombinerStageParameterfvNV(stage, pname, params);
  }

  public void glCommandListSegmentsNV(int list, int segments) {
    glext_h.glCommandListSegmentsNV(list, segments);
  }

  public void glCompileCommandListNV(int list) {
    glext_h.glCompileCommandListNV(list);
  }

  public void glCompileShader(int shader) {
    glext_h.glCompileShader(shader);
  }

  public void glCompileShaderARB(int shaderObj) {
    glext_h.glCompileShaderARB(shaderObj);
  }

  public void glCompileShaderIncludeARB(int shader, int count, Addressable path, Addressable length) {
    glext_h.glCompileShaderIncludeARB(shader, count, path, length);
  }

  public void glCompressedMultiTexImage1DEXT(int texunit, int target, int level, int internalformat, int width, int border, int imageSize, Addressable bits) {
    glext_h.glCompressedMultiTexImage1DEXT(texunit, target, level, internalformat, width, border, imageSize, bits);
  }

  public void glCompressedMultiTexImage2DEXT(int texunit, int target, int level, int internalformat, int width, int height, int border, int imageSize, Addressable bits) {
    glext_h.glCompressedMultiTexImage2DEXT(texunit, target, level, internalformat, width, height, border, imageSize, bits);
  }

  public void glCompressedMultiTexImage3DEXT(int texunit, int target, int level, int internalformat, int width, int height, int depth, int border, int imageSize, Addressable bits) {
    glext_h.glCompressedMultiTexImage3DEXT(texunit, target, level, internalformat, width, height, depth, border, imageSize, bits);
  }

  public void glCompressedMultiTexSubImage1DEXT(int texunit, int target, int level, int xoffset, int width, int format, int imageSize, Addressable bits) {
    glext_h.glCompressedMultiTexSubImage1DEXT(texunit, target, level, xoffset, width, format, imageSize, bits);
  }

  public void glCompressedMultiTexSubImage2DEXT(int texunit, int target, int level, int xoffset, int yoffset, int width, int height, int format, int imageSize, Addressable bits) {
    glext_h.glCompressedMultiTexSubImage2DEXT(texunit, target, level, xoffset, yoffset, width, height, format, imageSize, bits);
  }

  public void glCompressedMultiTexSubImage3DEXT(int texunit, int target, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int format, int imageSize, Addressable bits) {
    glext_h.glCompressedMultiTexSubImage3DEXT(texunit, target, level, xoffset, yoffset, zoffset, width, height, depth, format, imageSize, bits);
  }

  public void glCompressedTexImage1DARB(int target, int level, int internalformat, int width, int border, int imageSize, Addressable data) {
    glext_h.glCompressedTexImage1DARB(target, level, internalformat, width, border, imageSize, data);
  }

  public void glCompressedTexImage2DARB(int target, int level, int internalformat, int width, int height, int border, int imageSize, Addressable data) {
    glext_h.glCompressedTexImage2DARB(target, level, internalformat, width, height, border, imageSize, data);
  }

  public void glCompressedTexImage3DARB(int target, int level, int internalformat, int width, int height, int depth, int border, int imageSize, Addressable data) {
    glext_h.glCompressedTexImage3DARB(target, level, internalformat, width, height, depth, border, imageSize, data);
  }

  public void glCompressedTexSubImage1DARB(int target, int level, int xoffset, int width, int format, int imageSize, Addressable data) {
    glext_h.glCompressedTexSubImage1DARB(target, level, xoffset, width, format, imageSize, data);
  }

  public void glCompressedTexSubImage2DARB(int target, int level, int xoffset, int yoffset, int width, int height, int format, int imageSize, Addressable data) {
    glext_h.glCompressedTexSubImage2DARB(target, level, xoffset, yoffset, width, height, format, imageSize, data);
  }

  public void glCompressedTexSubImage3DARB(int target, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int format, int imageSize, Addressable data) {
    glext_h.glCompressedTexSubImage3DARB(target, level, xoffset, yoffset, zoffset, width, height, depth, format, imageSize, data);
  }

  public void glCompressedTextureImage1DEXT(int texture, int target, int level, int internalformat, int width, int border, int imageSize, Addressable bits) {
    glext_h.glCompressedTextureImage1DEXT(texture, target, level, internalformat, width, border, imageSize, bits);
  }

  public void glCompressedTextureImage2DEXT(int texture, int target, int level, int internalformat, int width, int height, int border, int imageSize, Addressable bits) {
    glext_h.glCompressedTextureImage2DEXT(texture, target, level, internalformat, width, height, border, imageSize, bits);
  }

  public void glCompressedTextureImage3DEXT(int texture, int target, int level, int internalformat, int width, int height, int depth, int border, int imageSize, Addressable bits) {
    glext_h.glCompressedTextureImage3DEXT(texture, target, level, internalformat, width, height, depth, border, imageSize, bits);
  }

  public void glCompressedTextureSubImage1D(int texture, int level, int xoffset, int width, int format, int imageSize, Addressable data) {
    glext_h.glCompressedTextureSubImage1D(texture, level, xoffset, width, format, imageSize, data);
  }

  public void glCompressedTextureSubImage1DEXT(int texture, int target, int level, int xoffset, int width, int format, int imageSize, Addressable bits) {
    glext_h.glCompressedTextureSubImage1DEXT(texture, target, level, xoffset, width, format, imageSize, bits);
  }

  public void glCompressedTextureSubImage2D(int texture, int level, int xoffset, int yoffset, int width, int height, int format, int imageSize, Addressable data) {
    glext_h.glCompressedTextureSubImage2D(texture, level, xoffset, yoffset, width, height, format, imageSize, data);
  }

  public void glCompressedTextureSubImage2DEXT(int texture, int target, int level, int xoffset, int yoffset, int width, int height, int format, int imageSize, Addressable bits) {
    glext_h.glCompressedTextureSubImage2DEXT(texture, target, level, xoffset, yoffset, width, height, format, imageSize, bits);
  }

  public void glCompressedTextureSubImage3D(int texture, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int format, int imageSize, Addressable data) {
    glext_h.glCompressedTextureSubImage3D(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, imageSize, data);
  }

  public void glCompressedTextureSubImage3DEXT(int texture, int target, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int format, int imageSize, Addressable bits) {
    glext_h.glCompressedTextureSubImage3DEXT(texture, target, level, xoffset, yoffset, zoffset, width, height, depth, format, imageSize, bits);
  }

  public void glConservativeRasterParameterfNV(int pname, float value) {
    glext_h.glConservativeRasterParameterfNV(pname, value);
  }

  public void glConservativeRasterParameteriNV(int pname, int param) {
    glext_h.glConservativeRasterParameteriNV(pname, param);
  }

  public void glConvolutionFilter1DEXT(int target, int internalformat, int width, int format, int type, Addressable image) {
    glext_h.glConvolutionFilter1DEXT(target, internalformat, width, format, type, image);
  }

  public void glConvolutionFilter2DEXT(int target, int internalformat, int width, int height, int format, int type, Addressable image) {
    glext_h.glConvolutionFilter2DEXT(target, internalformat, width, height, format, type, image);
  }

  public void glConvolutionParameterfEXT(int target, int pname, float params) {
    glext_h.glConvolutionParameterfEXT(target, pname, params);
  }

  public void glConvolutionParameterfvEXT(int target, int pname, Addressable params) {
    glext_h.glConvolutionParameterfvEXT(target, pname, params);
  }

  public void glConvolutionParameteriEXT(int target, int pname, int params) {
    glext_h.glConvolutionParameteriEXT(target, pname, params);
  }

  public void glConvolutionParameterivEXT(int target, int pname, Addressable params) {
    glext_h.glConvolutionParameterivEXT(target, pname, params);
  }

  public void glConvolutionParameterxOES(int target, int pname, int param) {
    glext_h.glConvolutionParameterxOES(target, pname, param);
  }

  public void glConvolutionParameterxvOES(int target, int pname, Addressable params) {
    glext_h.glConvolutionParameterxvOES(target, pname, params);
  }

  public void glCopyBufferSubData(int readTarget, int writeTarget, long readOffset, long writeOffset, long size) {
    glext_h.glCopyBufferSubData(readTarget, writeTarget, readOffset, writeOffset, size);
  }

  public void glCopyColorSubTableEXT(int target, int start, int x, int y, int width) {
    glext_h.glCopyColorSubTableEXT(target, start, x, y, width);
  }

  public void glCopyColorTableSGI(int target, int internalformat, int x, int y, int width) {
    glext_h.glCopyColorTableSGI(target, internalformat, x, y, width);
  }

  public void glCopyConvolutionFilter1DEXT(int target, int internalformat, int x, int y, int width) {
    glext_h.glCopyConvolutionFilter1DEXT(target, internalformat, x, y, width);
  }

  public void glCopyConvolutionFilter2DEXT(int target, int internalformat, int x, int y, int width, int height) {
    glext_h.glCopyConvolutionFilter2DEXT(target, internalformat, x, y, width, height);
  }

  public void glCopyImageSubData(int srcName, int srcTarget, int srcLevel, int srcX, int srcY, int srcZ, int dstName, int dstTarget, int dstLevel, int dstX, int dstY, int dstZ, int srcWidth, int srcHeight, int srcDepth) {
    glext_h.glCopyImageSubData(srcName, srcTarget, srcLevel, srcX, srcY, srcZ, dstName, dstTarget, dstLevel, dstX, dstY, dstZ, srcWidth, srcHeight, srcDepth);
  }

  public void glCopyImageSubDataNV(int srcName, int srcTarget, int srcLevel, int srcX, int srcY, int srcZ, int dstName, int dstTarget, int dstLevel, int dstX, int dstY, int dstZ, int width, int height, int depth) {
    glext_h.glCopyImageSubDataNV(srcName, srcTarget, srcLevel, srcX, srcY, srcZ, dstName, dstTarget, dstLevel, dstX, dstY, dstZ, width, height, depth);
  }

  public void glCopyMultiTexImage1DEXT(int texunit, int target, int level, int internalformat, int x, int y, int width, int border) {
    glext_h.glCopyMultiTexImage1DEXT(texunit, target, level, internalformat, x, y, width, border);
  }

  public void glCopyMultiTexImage2DEXT(int texunit, int target, int level, int internalformat, int x, int y, int width, int height, int border) {
    glext_h.glCopyMultiTexImage2DEXT(texunit, target, level, internalformat, x, y, width, height, border);
  }

  public void glCopyMultiTexSubImage1DEXT(int texunit, int target, int level, int xoffset, int x, int y, int width) {
    glext_h.glCopyMultiTexSubImage1DEXT(texunit, target, level, xoffset, x, y, width);
  }

  public void glCopyMultiTexSubImage2DEXT(int texunit, int target, int level, int xoffset, int yoffset, int x, int y, int width, int height) {
    glext_h.glCopyMultiTexSubImage2DEXT(texunit, target, level, xoffset, yoffset, x, y, width, height);
  }

  public void glCopyMultiTexSubImage3DEXT(int texunit, int target, int level, int xoffset, int yoffset, int zoffset, int x, int y, int width, int height) {
    glext_h.glCopyMultiTexSubImage3DEXT(texunit, target, level, xoffset, yoffset, zoffset, x, y, width, height);
  }

  public void glCopyNamedBufferSubData(int readBuffer, int writeBuffer, long readOffset, long writeOffset, long size) {
    glext_h.glCopyNamedBufferSubData(readBuffer, writeBuffer, readOffset, writeOffset, size);
  }

  public void glCopyPathNV(int resultPath, int srcPath) {
    glext_h.glCopyPathNV(resultPath, srcPath);
  }

  public void glCopyTexImage1DEXT(int target, int level, int internalformat, int x, int y, int width, int border) {
    glext_h.glCopyTexImage1DEXT(target, level, internalformat, x, y, width, border);
  }

  public void glCopyTexImage2DEXT(int target, int level, int internalformat, int x, int y, int width, int height, int border) {
    glext_h.glCopyTexImage2DEXT(target, level, internalformat, x, y, width, height, border);
  }

  public void glCopyTexSubImage1DEXT(int target, int level, int xoffset, int x, int y, int width) {
    glext_h.glCopyTexSubImage1DEXT(target, level, xoffset, x, y, width);
  }

  public void glCopyTexSubImage2DEXT(int target, int level, int xoffset, int yoffset, int x, int y, int width, int height) {
    glext_h.glCopyTexSubImage2DEXT(target, level, xoffset, yoffset, x, y, width, height);
  }

  public void glCopyTexSubImage3DEXT(int target, int level, int xoffset, int yoffset, int zoffset, int x, int y, int width, int height) {
    glext_h.glCopyTexSubImage3DEXT(target, level, xoffset, yoffset, zoffset, x, y, width, height);
  }

  public void glCopyTextureImage1DEXT(int texture, int target, int level, int internalformat, int x, int y, int width, int border) {
    glext_h.glCopyTextureImage1DEXT(texture, target, level, internalformat, x, y, width, border);
  }

  public void glCopyTextureImage2DEXT(int texture, int target, int level, int internalformat, int x, int y, int width, int height, int border) {
    glext_h.glCopyTextureImage2DEXT(texture, target, level, internalformat, x, y, width, height, border);
  }

  public void glCopyTextureSubImage1D(int texture, int level, int xoffset, int x, int y, int width) {
    glext_h.glCopyTextureSubImage1D(texture, level, xoffset, x, y, width);
  }

  public void glCopyTextureSubImage1DEXT(int texture, int target, int level, int xoffset, int x, int y, int width) {
    glext_h.glCopyTextureSubImage1DEXT(texture, target, level, xoffset, x, y, width);
  }

  public void glCopyTextureSubImage2D(int texture, int level, int xoffset, int yoffset, int x, int y, int width, int height) {
    glext_h.glCopyTextureSubImage2D(texture, level, xoffset, yoffset, x, y, width, height);
  }

  public void glCopyTextureSubImage2DEXT(int texture, int target, int level, int xoffset, int yoffset, int x, int y, int width, int height) {
    glext_h.glCopyTextureSubImage2DEXT(texture, target, level, xoffset, yoffset, x, y, width, height);
  }

  public void glCopyTextureSubImage3D(int texture, int level, int xoffset, int yoffset, int zoffset, int x, int y, int width, int height) {
    glext_h.glCopyTextureSubImage3D(texture, level, xoffset, yoffset, zoffset, x, y, width, height);
  }

  public void glCopyTextureSubImage3DEXT(int texture, int target, int level, int xoffset, int yoffset, int zoffset, int x, int y, int width, int height) {
    glext_h.glCopyTextureSubImage3DEXT(texture, target, level, xoffset, yoffset, zoffset, x, y, width, height);
  }

  public void glCoverFillPathInstancedNV(int numPaths, int pathNameType, Addressable paths, int pathBase, int coverMode, int transformType, Addressable transformValues) {
    glext_h.glCoverFillPathInstancedNV(numPaths, pathNameType, paths, pathBase, coverMode, transformType, transformValues);
  }

  public void glCoverFillPathNV(int path, int coverMode) {
    glext_h.glCoverFillPathNV(path, coverMode);
  }

  public void glCoverStrokePathInstancedNV(int numPaths, int pathNameType, Addressable paths, int pathBase, int coverMode, int transformType, Addressable transformValues) {
    glext_h.glCoverStrokePathInstancedNV(numPaths, pathNameType, paths, pathBase, coverMode, transformType, transformValues);
  }

  public void glCoverStrokePathNV(int path, int coverMode) {
    glext_h.glCoverStrokePathNV(path, coverMode);
  }

  public void glCoverageModulationNV(int components) {
    glext_h.glCoverageModulationNV(components);
  }

  public void glCoverageModulationTableNV(int n, Addressable v) {
    glext_h.glCoverageModulationTableNV(n, v);
  }

  public void glCreateBuffers(int n, Addressable buffers) {
    glext_h.glCreateBuffers(n, buffers);
  }

  public void glCreateCommandListsNV(int n, Addressable lists) {
    glext_h.glCreateCommandListsNV(n, lists);
  }

  public void glCreateFramebuffers(int n, Addressable framebuffers) {
    glext_h.glCreateFramebuffers(n, framebuffers);
  }

  public void glCreateMemoryObjectsEXT(int n, Addressable memoryObjects) {
    glext_h.glCreateMemoryObjectsEXT(n, memoryObjects);
  }

  public void glCreatePerfQueryINTEL(int queryId, Addressable queryHandle) {
    glext_h.glCreatePerfQueryINTEL(queryId, queryHandle);
  }

  public int glCreateProgram() {
    return glext_h.glCreateProgram();
  }

  public int glCreateProgramObjectARB() {
    return glext_h.glCreateProgramObjectARB();
  }

  public void glCreateProgramPipelines(int n, Addressable pipelines) {
    glext_h.glCreateProgramPipelines(n, pipelines);
  }

  public int glCreateProgressFenceNVX() {
    return glext_h.glCreateProgressFenceNVX();
  }

  public void glCreateQueries(int target, int n, Addressable ids) {
    glext_h.glCreateQueries(target, n, ids);
  }

  public void glCreateRenderbuffers(int n, Addressable renderbuffers) {
    glext_h.glCreateRenderbuffers(n, renderbuffers);
  }

  public void glCreateSamplers(int n, Addressable samplers) {
    glext_h.glCreateSamplers(n, samplers);
  }

  public int glCreateShader(int type) {
    return glext_h.glCreateShader(type);
  }

  public int glCreateShaderObjectARB(int shaderType) {
    return glext_h.glCreateShaderObjectARB(shaderType);
  }

  public int glCreateShaderProgramEXT(int type, Addressable string) {
    return glext_h.glCreateShaderProgramEXT(type, string);
  }

  public int glCreateShaderProgramv(int type, int count, Addressable strings) {
    return glext_h.glCreateShaderProgramv(type, count, strings);
  }

  public void glCreateStatesNV(int n, Addressable states) {
    glext_h.glCreateStatesNV(n, states);
  }

  public MemoryAddress glCreateSyncFromCLeventARB(Addressable context, Addressable event, int flags) {
    return glext_h.glCreateSyncFromCLeventARB(context, event, flags);
  }

  public void glCreateTextures(int target, int n, Addressable textures) {
    glext_h.glCreateTextures(target, n, textures);
  }

  public void glCreateTransformFeedbacks(int n, Addressable ids) {
    glext_h.glCreateTransformFeedbacks(n, ids);
  }

  public void glCreateVertexArrays(int n, Addressable arrays) {
    glext_h.glCreateVertexArrays(n, arrays);
  }

  public void glCullParameterdvEXT(int pname, Addressable params) {
    glext_h.glCullParameterdvEXT(pname, params);
  }

  public void glCullParameterfvEXT(int pname, Addressable params) {
    glext_h.glCullParameterfvEXT(pname, params);
  }

  public void glCurrentPaletteMatrixARB(int index) {
    glext_h.glCurrentPaletteMatrixARB(index);
  }

  public void glDebugMessageCallback(Addressable callback, Addressable userParam) {
    glext_h.glDebugMessageCallback(callback, userParam);
  }

  public void glDebugMessageCallbackAMD(Addressable callback, Addressable userParam) {
    glext_h.glDebugMessageCallbackAMD(callback, userParam);
  }

  public void glDebugMessageCallbackARB(Addressable callback, Addressable userParam) {
    glext_h.glDebugMessageCallbackARB(callback, userParam);
  }

  public void glDebugMessageControl(int source, int type, int severity, int count, Addressable ids, byte enabled) {
    glext_h.glDebugMessageControl(source, type, severity, count, ids, enabled);
  }

  public void glDebugMessageControlARB(int source, int type, int severity, int count, Addressable ids, byte enabled) {
    glext_h.glDebugMessageControlARB(source, type, severity, count, ids, enabled);
  }

  public void glDebugMessageEnableAMD(int category, int severity, int count, Addressable ids, byte enabled) {
    glext_h.glDebugMessageEnableAMD(category, severity, count, ids, enabled);
  }

  public void glDebugMessageInsert(int source, int type, int id, int severity, int length, Addressable buf) {
    glext_h.glDebugMessageInsert(source, type, id, severity, length, buf);
  }

  public void glDebugMessageInsertAMD(int category, int severity, int id, int length, Addressable buf) {
    glext_h.glDebugMessageInsertAMD(category, severity, id, length, buf);
  }

  public void glDebugMessageInsertARB(int source, int type, int id, int severity, int length, Addressable buf) {
    glext_h.glDebugMessageInsertARB(source, type, id, severity, length, buf);
  }

  public void glDeformSGIX(int mask) {
    glext_h.glDeformSGIX(mask);
  }

  public void glDeformationMap3dSGIX(int target, double u1, double u2, int ustride, int uorder, double v1, double v2, int vstride, int vorder, double w1, double w2, int wstride, int worder, Addressable points) {
    glext_h.glDeformationMap3dSGIX(target, u1, u2, ustride, uorder, v1, v2, vstride, vorder, w1, w2, wstride, worder, points);
  }

  public void glDeformationMap3fSGIX(int target, float u1, float u2, int ustride, int uorder, float v1, float v2, int vstride, int vorder, float w1, float w2, int wstride, int worder, Addressable points) {
    glext_h.glDeformationMap3fSGIX(target, u1, u2, ustride, uorder, v1, v2, vstride, vorder, w1, w2, wstride, worder, points);
  }

  public void glDeleteAsyncMarkersSGIX(int marker, int range) {
    glext_h.glDeleteAsyncMarkersSGIX(marker, range);
  }

  public void glDeleteBuffers(int n, Addressable buffers) {
    glext_h.glDeleteBuffers(n, buffers);
  }

  public void glDeleteBuffersARB(int n, Addressable buffers) {
    glext_h.glDeleteBuffersARB(n, buffers);
  }

  public void glDeleteCommandListsNV(int n, Addressable lists) {
    glext_h.glDeleteCommandListsNV(n, lists);
  }

  public void glDeleteFencesAPPLE(int n, Addressable fences) {
    glext_h.glDeleteFencesAPPLE(n, fences);
  }

  public void glDeleteFencesNV(int n, Addressable fences) {
    glext_h.glDeleteFencesNV(n, fences);
  }

  public void glDeleteFragmentShaderATI(int id) {
    glext_h.glDeleteFragmentShaderATI(id);
  }

  public void glDeleteFramebuffers(int n, Addressable framebuffers) {
    glext_h.glDeleteFramebuffers(n, framebuffers);
  }

  public void glDeleteFramebuffersEXT(int n, Addressable framebuffers) {
    glext_h.glDeleteFramebuffersEXT(n, framebuffers);
  }

  public void glDeleteMemoryObjectsEXT(int n, Addressable memoryObjects) {
    glext_h.glDeleteMemoryObjectsEXT(n, memoryObjects);
  }

  public void glDeleteNamedStringARB(int namelen, Addressable name) {
    glext_h.glDeleteNamedStringARB(namelen, name);
  }

  public void glDeleteNamesAMD(int identifier, int num, Addressable names) {
    glext_h.glDeleteNamesAMD(identifier, num, names);
  }

  public void glDeleteObjectARB(int obj) {
    glext_h.glDeleteObjectARB(obj);
  }

  public void glDeleteOcclusionQueriesNV(int n, Addressable ids) {
    glext_h.glDeleteOcclusionQueriesNV(n, ids);
  }

  public void glDeletePathsNV(int path, int range) {
    glext_h.glDeletePathsNV(path, range);
  }

  public void glDeletePerfMonitorsAMD(int n, Addressable monitors) {
    glext_h.glDeletePerfMonitorsAMD(n, monitors);
  }

  public void glDeletePerfQueryINTEL(int queryHandle) {
    glext_h.glDeletePerfQueryINTEL(queryHandle);
  }

  public void glDeleteProgram(int program) {
    glext_h.glDeleteProgram(program);
  }

  public void glDeleteProgramPipelines(int n, Addressable pipelines) {
    glext_h.glDeleteProgramPipelines(n, pipelines);
  }

  public void glDeleteProgramsARB(int n, Addressable programs) {
    glext_h.glDeleteProgramsARB(n, programs);
  }

  public void glDeleteProgramsNV(int n, Addressable programs) {
    glext_h.glDeleteProgramsNV(n, programs);
  }

  public void glDeleteQueries(int n, Addressable ids) {
    glext_h.glDeleteQueries(n, ids);
  }

  public void glDeleteQueriesARB(int n, Addressable ids) {
    glext_h.glDeleteQueriesARB(n, ids);
  }

  public void glDeleteQueryResourceTagNV(int n, Addressable tagIds) {
    glext_h.glDeleteQueryResourceTagNV(n, tagIds);
  }

  public void glDeleteRenderbuffers(int n, Addressable renderbuffers) {
    glext_h.glDeleteRenderbuffers(n, renderbuffers);
  }

  public void glDeleteRenderbuffersEXT(int n, Addressable renderbuffers) {
    glext_h.glDeleteRenderbuffersEXT(n, renderbuffers);
  }

  public void glDeleteSamplers(int count, Addressable samplers) {
    glext_h.glDeleteSamplers(count, samplers);
  }

  public void glDeleteSemaphoresEXT(int n, Addressable semaphores) {
    glext_h.glDeleteSemaphoresEXT(n, semaphores);
  }

  public void glDeleteShader(int shader) {
    glext_h.glDeleteShader(shader);
  }

  public void glDeleteStatesNV(int n, Addressable states) {
    glext_h.glDeleteStatesNV(n, states);
  }

  public void glDeleteSync(Addressable sync) {
    glext_h.glDeleteSync(sync);
  }

  public void glDeleteTexturesEXT(int n, Addressable textures) {
    glext_h.glDeleteTexturesEXT(n, textures);
  }

  public void glDeleteTransformFeedbacks(int n, Addressable ids) {
    glext_h.glDeleteTransformFeedbacks(n, ids);
  }

  public void glDeleteTransformFeedbacksNV(int n, Addressable ids) {
    glext_h.glDeleteTransformFeedbacksNV(n, ids);
  }

  public void glDeleteVertexArrays(int n, Addressable arrays) {
    glext_h.glDeleteVertexArrays(n, arrays);
  }

  public void glDeleteVertexArraysAPPLE(int n, Addressable arrays) {
    glext_h.glDeleteVertexArraysAPPLE(n, arrays);
  }

  public void glDeleteVertexShaderEXT(int id) {
    glext_h.glDeleteVertexShaderEXT(id);
  }

  public void glDepthBoundsEXT(double zmin, double zmax) {
    glext_h.glDepthBoundsEXT(zmin, zmax);
  }

  public void glDepthBoundsdNV(double zmin, double zmax) {
    glext_h.glDepthBoundsdNV(zmin, zmax);
  }

  public void glDepthRangeArrayv(int first, int count, Addressable v) {
    glext_h.glDepthRangeArrayv(first, count, v);
  }

  public void glDepthRangeIndexed(int index, double n, double f) {
    glext_h.glDepthRangeIndexed(index, n, f);
  }

  public void glDepthRangedNV(double zNear, double zFar) {
    glext_h.glDepthRangedNV(zNear, zFar);
  }

  public void glDepthRangef(float n, float f) {
    glext_h.glDepthRangef(n, f);
  }

  public void glDepthRangefOES(float n, float f) {
    glext_h.glDepthRangefOES(n, f);
  }

  public void glDepthRangexOES(int n, int f) {
    glext_h.glDepthRangexOES(n, f);
  }

  public void glDetachObjectARB(int containerObj, int attachedObj) {
    glext_h.glDetachObjectARB(containerObj, attachedObj);
  }

  public void glDetachShader(int program, int shader) {
    glext_h.glDetachShader(program, shader);
  }

  public void glDetailTexFuncSGIS(int target, int n, Addressable points) {
    glext_h.glDetailTexFuncSGIS(target, n, points);
  }

  public void glDisableClientStateIndexedEXT(int array, int index) {
    glext_h.glDisableClientStateIndexedEXT(array, index);
  }

  public void glDisableClientStateiEXT(int array, int index) {
    glext_h.glDisableClientStateiEXT(array, index);
  }

  public void glDisableIndexedEXT(int target, int index) {
    glext_h.glDisableIndexedEXT(target, index);
  }

  public void glDisableVariantClientStateEXT(int id) {
    glext_h.glDisableVariantClientStateEXT(id);
  }

  public void glDisableVertexArrayAttrib(int vaobj, int index) {
    glext_h.glDisableVertexArrayAttrib(vaobj, index);
  }

  public void glDisableVertexArrayAttribEXT(int vaobj, int index) {
    glext_h.glDisableVertexArrayAttribEXT(vaobj, index);
  }

  public void glDisableVertexArrayEXT(int vaobj, int array) {
    glext_h.glDisableVertexArrayEXT(vaobj, array);
  }

  public void glDisableVertexAttribAPPLE(int index, int pname) {
    glext_h.glDisableVertexAttribAPPLE(index, pname);
  }

  public void glDisableVertexAttribArray(int index) {
    glext_h.glDisableVertexAttribArray(index);
  }

  public void glDisableVertexAttribArrayARB(int index) {
    glext_h.glDisableVertexAttribArrayARB(index);
  }

  public void glDisablei(int target, int index) {
    glext_h.glDisablei(target, index);
  }

  public void glDispatchCompute(int num_groups_x, int num_groups_y, int num_groups_z) {
    glext_h.glDispatchCompute(num_groups_x, num_groups_y, num_groups_z);
  }

  public void glDispatchComputeGroupSizeARB(int num_groups_x, int num_groups_y, int num_groups_z, int group_size_x, int group_size_y, int group_size_z) {
    glext_h.glDispatchComputeGroupSizeARB(num_groups_x, num_groups_y, num_groups_z, group_size_x, group_size_y, group_size_z);
  }

  public void glDispatchComputeIndirect(long indirect) {
    glext_h.glDispatchComputeIndirect(indirect);
  }

  public void glDrawArraysEXT(int mode, int first, int count) {
    glext_h.glDrawArraysEXT(mode, first, count);
  }

  public void glDrawArraysIndirect(int mode, Addressable indirect) {
    glext_h.glDrawArraysIndirect(mode, indirect);
  }

  public void glDrawArraysInstanced(int mode, int first, int count, int instancecount) {
    glext_h.glDrawArraysInstanced(mode, first, count, instancecount);
  }

  public void glDrawArraysInstancedARB(int mode, int first, int count, int primcount) {
    glext_h.glDrawArraysInstancedARB(mode, first, count, primcount);
  }

  public void glDrawArraysInstancedBaseInstance(int mode, int first, int count, int instancecount, int baseinstance) {
    glext_h.glDrawArraysInstancedBaseInstance(mode, first, count, instancecount, baseinstance);
  }

  public void glDrawArraysInstancedEXT(int mode, int start, int count, int primcount) {
    glext_h.glDrawArraysInstancedEXT(mode, start, count, primcount);
  }

  public void glDrawBuffers(int n, Addressable bufs) {
    glext_h.glDrawBuffers(n, bufs);
  }

  public void glDrawBuffersARB(int n, Addressable bufs) {
    glext_h.glDrawBuffersARB(n, bufs);
  }

  public void glDrawBuffersATI(int n, Addressable bufs) {
    glext_h.glDrawBuffersATI(n, bufs);
  }

  public void glDrawCommandsAddressNV(int primitiveMode, Addressable indirects, Addressable sizes, int count) {
    glext_h.glDrawCommandsAddressNV(primitiveMode, indirects, sizes, count);
  }

  public void glDrawCommandsNV(int primitiveMode, int buffer, Addressable indirects, Addressable sizes, int count) {
    glext_h.glDrawCommandsNV(primitiveMode, buffer, indirects, sizes, count);
  }

  public void glDrawCommandsStatesAddressNV(Addressable indirects, Addressable sizes, Addressable states, Addressable fbos, int count) {
    glext_h.glDrawCommandsStatesAddressNV(indirects, sizes, states, fbos, count);
  }

  public void glDrawCommandsStatesNV(int buffer, Addressable indirects, Addressable sizes, Addressable states, Addressable fbos, int count) {
    glext_h.glDrawCommandsStatesNV(buffer, indirects, sizes, states, fbos, count);
  }

  public void glDrawElementArrayAPPLE(int mode, int first, int count) {
    glext_h.glDrawElementArrayAPPLE(mode, first, count);
  }

  public void glDrawElementArrayATI(int mode, int count) {
    glext_h.glDrawElementArrayATI(mode, count);
  }

  public void glDrawElementsBaseVertex(int mode, int count, int type, Addressable indices, int basevertex) {
    glext_h.glDrawElementsBaseVertex(mode, count, type, indices, basevertex);
  }

  public void glDrawElementsIndirect(int mode, int type, Addressable indirect) {
    glext_h.glDrawElementsIndirect(mode, type, indirect);
  }

  public void glDrawElementsInstanced(int mode, int count, int type, Addressable indices, int instancecount) {
    glext_h.glDrawElementsInstanced(mode, count, type, indices, instancecount);
  }

  public void glDrawElementsInstancedARB(int mode, int count, int type, Addressable indices, int primcount) {
    glext_h.glDrawElementsInstancedARB(mode, count, type, indices, primcount);
  }

  public void glDrawElementsInstancedBaseInstance(int mode, int count, int type, Addressable indices, int instancecount, int baseinstance) {
    glext_h.glDrawElementsInstancedBaseInstance(mode, count, type, indices, instancecount, baseinstance);
  }

  public void glDrawElementsInstancedBaseVertex(int mode, int count, int type, Addressable indices, int instancecount, int basevertex) {
    glext_h.glDrawElementsInstancedBaseVertex(mode, count, type, indices, instancecount, basevertex);
  }

  public void glDrawElementsInstancedBaseVertexBaseInstance(int mode, int count, int type, Addressable indices, int instancecount, int basevertex, int baseinstance) {
    glext_h.glDrawElementsInstancedBaseVertexBaseInstance(mode, count, type, indices, instancecount, basevertex, baseinstance);
  }

  public void glDrawElementsInstancedEXT(int mode, int count, int type, Addressable indices, int primcount) {
    glext_h.glDrawElementsInstancedEXT(mode, count, type, indices, primcount);
  }

  public void glDrawMeshArraysSUN(int mode, int first, int count, int width) {
    glext_h.glDrawMeshArraysSUN(mode, first, count, width);
  }

  public void glDrawMeshTasksIndirectNV(long indirect) {
    glext_h.glDrawMeshTasksIndirectNV(indirect);
  }

  public void glDrawMeshTasksNV(int first, int count) {
    glext_h.glDrawMeshTasksNV(first, count);
  }

  public void glDrawRangeElementArrayAPPLE(int mode, int start, int end, int first, int count) {
    glext_h.glDrawRangeElementArrayAPPLE(mode, start, end, first, count);
  }

  public void glDrawRangeElementArrayATI(int mode, int start, int end, int count) {
    glext_h.glDrawRangeElementArrayATI(mode, start, end, count);
  }

  public void glDrawRangeElementsBaseVertex(int mode, int start, int end, int count, int type, Addressable indices, int basevertex) {
    glext_h.glDrawRangeElementsBaseVertex(mode, start, end, count, type, indices, basevertex);
  }

  public void glDrawRangeElementsEXT(int mode, int start, int end, int count, int type, Addressable indices) {
    glext_h.glDrawRangeElementsEXT(mode, start, end, count, type, indices);
  }

  public void glDrawTextureNV(int texture, int sampler, float x0, float y0, float x1, float y1, float z, float s0, float t0, float s1, float t1) {
    glext_h.glDrawTextureNV(texture, sampler, x0, y0, x1, y1, z, s0, t0, s1, t1);
  }

  public void glDrawTransformFeedback(int mode, int id) {
    glext_h.glDrawTransformFeedback(mode, id);
  }

  public void glDrawTransformFeedbackInstanced(int mode, int id, int instancecount) {
    glext_h.glDrawTransformFeedbackInstanced(mode, id, instancecount);
  }

  public void glDrawTransformFeedbackNV(int mode, int id) {
    glext_h.glDrawTransformFeedbackNV(mode, id);
  }

  public void glDrawTransformFeedbackStream(int mode, int id, int stream) {
    glext_h.glDrawTransformFeedbackStream(mode, id, stream);
  }

  public void glDrawTransformFeedbackStreamInstanced(int mode, int id, int stream, int instancecount) {
    glext_h.glDrawTransformFeedbackStreamInstanced(mode, id, stream, instancecount);
  }

  public void glDrawVkImageNV(long vkImage, int sampler, float x0, float y0, float x1, float y1, float z, float s0, float t0, float s1, float t1) {
    glext_h.glDrawVkImageNV(vkImage, sampler, x0, y0, x1, y1, z, s0, t0, s1, t1);
  }

  public void glEGLImageTargetRenderbufferStorageOES(int target, Addressable image) {
    glext_h.glEGLImageTargetRenderbufferStorageOES(target, image);
  }

  public void glEGLImageTargetTexStorageEXT(int target, Addressable image, Addressable attrib_list) {
    glext_h.glEGLImageTargetTexStorageEXT(target, image, attrib_list);
  }

  public void glEGLImageTargetTexture2DOES(int target, Addressable image) {
    glext_h.glEGLImageTargetTexture2DOES(target, image);
  }

  public void glEGLImageTargetTextureStorageEXT(int texture, Addressable image, Addressable attrib_list) {
    glext_h.glEGLImageTargetTextureStorageEXT(texture, image, attrib_list);
  }

  public void glEdgeFlagFormatNV(int stride) {
    glext_h.glEdgeFlagFormatNV(stride);
  }

  public void glEdgeFlagPointerEXT(int stride, int count, Addressable pointer) {
    glext_h.glEdgeFlagPointerEXT(stride, count, pointer);
  }

  public void glEdgeFlagPointerListIBM(int stride, Addressable pointer, int ptrstride) {
    glext_h.glEdgeFlagPointerListIBM(stride, pointer, ptrstride);
  }

  public void glElementPointerAPPLE(int type, Addressable pointer) {
    glext_h.glElementPointerAPPLE(type, pointer);
  }

  public void glElementPointerATI(int type, Addressable pointer) {
    glext_h.glElementPointerATI(type, pointer);
  }

  public void glEnableClientStateIndexedEXT(int array, int index) {
    glext_h.glEnableClientStateIndexedEXT(array, index);
  }

  public void glEnableClientStateiEXT(int array, int index) {
    glext_h.glEnableClientStateiEXT(array, index);
  }

  public void glEnableIndexedEXT(int target, int index) {
    glext_h.glEnableIndexedEXT(target, index);
  }

  public void glEnableVariantClientStateEXT(int id) {
    glext_h.glEnableVariantClientStateEXT(id);
  }

  public void glEnableVertexArrayAttrib(int vaobj, int index) {
    glext_h.glEnableVertexArrayAttrib(vaobj, index);
  }

  public void glEnableVertexArrayAttribEXT(int vaobj, int index) {
    glext_h.glEnableVertexArrayAttribEXT(vaobj, index);
  }

  public void glEnableVertexArrayEXT(int vaobj, int array) {
    glext_h.glEnableVertexArrayEXT(vaobj, array);
  }

  public void glEnableVertexAttribAPPLE(int index, int pname) {
    glext_h.glEnableVertexAttribAPPLE(index, pname);
  }

  public void glEnableVertexAttribArray(int index) {
    glext_h.glEnableVertexAttribArray(index);
  }

  public void glEnableVertexAttribArrayARB(int index) {
    glext_h.glEnableVertexAttribArrayARB(index);
  }

  public void glEnablei(int target, int index) {
    glext_h.glEnablei(target, index);
  }

  public void glEndConditionalRender() {
    glext_h.glEndConditionalRender();
  }

  public void glEndConditionalRenderNV() {
    glext_h.glEndConditionalRenderNV();
  }

  public void glEndConditionalRenderNVX() {
    glext_h.glEndConditionalRenderNVX();
  }

  public void glEndFragmentShaderATI() {
    glext_h.glEndFragmentShaderATI();
  }

  public void glEndOcclusionQueryNV() {
    glext_h.glEndOcclusionQueryNV();
  }

  public void glEndPerfMonitorAMD(int monitor) {
    glext_h.glEndPerfMonitorAMD(monitor);
  }

  public void glEndPerfQueryINTEL(int queryHandle) {
    glext_h.glEndPerfQueryINTEL(queryHandle);
  }

  public void glEndQuery(int target) {
    glext_h.glEndQuery(target);
  }

  public void glEndQueryARB(int target) {
    glext_h.glEndQueryARB(target);
  }

  public void glEndQueryIndexed(int target, int index) {
    glext_h.glEndQueryIndexed(target, index);
  }

  public void glEndTransformFeedback() {
    glext_h.glEndTransformFeedback();
  }

  public void glEndTransformFeedbackEXT() {
    glext_h.glEndTransformFeedbackEXT();
  }

  public void glEndTransformFeedbackNV() {
    glext_h.glEndTransformFeedbackNV();
  }

  public void glEndVertexShaderEXT() {
    glext_h.glEndVertexShaderEXT();
  }

  public void glEndVideoCaptureNV(int video_capture_slot) {
    glext_h.glEndVideoCaptureNV(video_capture_slot);
  }

  public void glEvalCoord1xOES(int u) {
    glext_h.glEvalCoord1xOES(u);
  }

  public void glEvalCoord1xvOES(Addressable coords) {
    glext_h.glEvalCoord1xvOES(coords);
  }

  public void glEvalCoord2xOES(int u, int v) {
    glext_h.glEvalCoord2xOES(u, v);
  }

  public void glEvalCoord2xvOES(Addressable coords) {
    glext_h.glEvalCoord2xvOES(coords);
  }

  public void glEvalMapsNV(int target, int mode) {
    glext_h.glEvalMapsNV(target, mode);
  }

  public void glEvaluateDepthValuesARB() {
    glext_h.glEvaluateDepthValuesARB();
  }

  public void glExecuteProgramNV(int target, int id, Addressable params) {
    glext_h.glExecuteProgramNV(target, id, params);
  }

  public void glExtractComponentEXT(int res, int src, int num) {
    glext_h.glExtractComponentEXT(res, src, num);
  }

  public void glFeedbackBufferxOES(int n, int type, Addressable buffer) {
    glext_h.glFeedbackBufferxOES(n, type, buffer);
  }

  public MemoryAddress glFenceSync(int condition, int flags) {
    return glext_h.glFenceSync(condition, flags);
  }

  public void glFinalCombinerInputNV(int variable, int input, int mapping, int componentUsage) {
    glext_h.glFinalCombinerInputNV(variable, input, mapping, componentUsage);
  }

  public int glFinishAsyncSGIX(Addressable markerp) {
    return glext_h.glFinishAsyncSGIX(markerp);
  }

  public void glFinishFenceAPPLE(int fence) {
    glext_h.glFinishFenceAPPLE(fence);
  }

  public void glFinishFenceNV(int fence) {
    glext_h.glFinishFenceNV(fence);
  }

  public void glFinishObjectAPPLE(int object, int name) {
    glext_h.glFinishObjectAPPLE(object, name);
  }

  public void glFinishTextureSUNX() {
    glext_h.glFinishTextureSUNX();
  }

  public void glFlushMappedBufferRange(int target, long offset, long length) {
    glext_h.glFlushMappedBufferRange(target, offset, length);
  }

  public void glFlushMappedBufferRangeAPPLE(int target, long offset, long size) {
    glext_h.glFlushMappedBufferRangeAPPLE(target, offset, size);
  }

  public void glFlushMappedNamedBufferRange(int buffer, long offset, long length) {
    glext_h.glFlushMappedNamedBufferRange(buffer, offset, length);
  }

  public void glFlushMappedNamedBufferRangeEXT(int buffer, long offset, long length) {
    glext_h.glFlushMappedNamedBufferRangeEXT(buffer, offset, length);
  }

  public void glFlushPixelDataRangeNV(int target) {
    glext_h.glFlushPixelDataRangeNV(target);
  }

  public void glFlushRasterSGIX() {
    glext_h.glFlushRasterSGIX();
  }

  public void glFlushStaticDataIBM(int target) {
    glext_h.glFlushStaticDataIBM(target);
  }

  public void glFlushVertexArrayRangeAPPLE(int length, Addressable pointer) {
    glext_h.glFlushVertexArrayRangeAPPLE(length, pointer);
  }

  public void glFlushVertexArrayRangeNV() {
    glext_h.glFlushVertexArrayRangeNV();
  }

  public void glFogCoordFormatNV(int type, int stride) {
    glext_h.glFogCoordFormatNV(type, stride);
  }

  public void glFogCoordPointer(int type, int stride, Addressable pointer) {
    glext_h.glFogCoordPointer(type, stride, pointer);
  }

  public void glFogCoordPointerEXT(int type, int stride, Addressable pointer) {
    glext_h.glFogCoordPointerEXT(type, stride, pointer);
  }

  public void glFogCoordPointerListIBM(int type, int stride, Addressable pointer, int ptrstride) {
    glext_h.glFogCoordPointerListIBM(type, stride, pointer, ptrstride);
  }

  public void glFogCoordd(double coord) {
    glext_h.glFogCoordd(coord);
  }

  public void glFogCoorddEXT(double coord) {
    glext_h.glFogCoorddEXT(coord);
  }

  public void glFogCoorddv(Addressable coord) {
    glext_h.glFogCoorddv(coord);
  }

  public void glFogCoorddvEXT(Addressable coord) {
    glext_h.glFogCoorddvEXT(coord);
  }

  public void glFogCoordf(float coord) {
    glext_h.glFogCoordf(coord);
  }

  public void glFogCoordfEXT(float coord) {
    glext_h.glFogCoordfEXT(coord);
  }

  public void glFogCoordfv(Addressable coord) {
    glext_h.glFogCoordfv(coord);
  }

  public void glFogCoordfvEXT(Addressable coord) {
    glext_h.glFogCoordfvEXT(coord);
  }

  public void glFogCoordhNV(short fog) {
    glext_h.glFogCoordhNV(fog);
  }

  public void glFogCoordhvNV(Addressable fog) {
    glext_h.glFogCoordhvNV(fog);
  }

  public void glFogFuncSGIS(int n, Addressable points) {
    glext_h.glFogFuncSGIS(n, points);
  }

  public void glFogxOES(int pname, int param) {
    glext_h.glFogxOES(pname, param);
  }

  public void glFogxvOES(int pname, Addressable param) {
    glext_h.glFogxvOES(pname, param);
  }

  public void glFragmentColorMaterialSGIX(int face, int mode) {
    glext_h.glFragmentColorMaterialSGIX(face, mode);
  }

  public void glFragmentCoverageColorNV(int color) {
    glext_h.glFragmentCoverageColorNV(color);
  }

  public void glFragmentLightModelfSGIX(int pname, float param) {
    glext_h.glFragmentLightModelfSGIX(pname, param);
  }

  public void glFragmentLightModelfvSGIX(int pname, Addressable params) {
    glext_h.glFragmentLightModelfvSGIX(pname, params);
  }

  public void glFragmentLightModeliSGIX(int pname, int param) {
    glext_h.glFragmentLightModeliSGIX(pname, param);
  }

  public void glFragmentLightModelivSGIX(int pname, Addressable params) {
    glext_h.glFragmentLightModelivSGIX(pname, params);
  }

  public void glFragmentLightfSGIX(int light, int pname, float param) {
    glext_h.glFragmentLightfSGIX(light, pname, param);
  }

  public void glFragmentLightfvSGIX(int light, int pname, Addressable params) {
    glext_h.glFragmentLightfvSGIX(light, pname, params);
  }

  public void glFragmentLightiSGIX(int light, int pname, int param) {
    glext_h.glFragmentLightiSGIX(light, pname, param);
  }

  public void glFragmentLightivSGIX(int light, int pname, Addressable params) {
    glext_h.glFragmentLightivSGIX(light, pname, params);
  }

  public void glFragmentMaterialfSGIX(int face, int pname, float param) {
    glext_h.glFragmentMaterialfSGIX(face, pname, param);
  }

  public void glFragmentMaterialfvSGIX(int face, int pname, Addressable params) {
    glext_h.glFragmentMaterialfvSGIX(face, pname, params);
  }

  public void glFragmentMaterialiSGIX(int face, int pname, int param) {
    glext_h.glFragmentMaterialiSGIX(face, pname, param);
  }

  public void glFragmentMaterialivSGIX(int face, int pname, Addressable params) {
    glext_h.glFragmentMaterialivSGIX(face, pname, params);
  }

  public void glFrameTerminatorGREMEDY() {
    glext_h.glFrameTerminatorGREMEDY();
  }

  public void glFrameZoomSGIX(int factor) {
    glext_h.glFrameZoomSGIX(factor);
  }

  public void glFramebufferDrawBufferEXT(int framebuffer, int mode) {
    glext_h.glFramebufferDrawBufferEXT(framebuffer, mode);
  }

  public void glFramebufferDrawBuffersEXT(int framebuffer, int n, Addressable bufs) {
    glext_h.glFramebufferDrawBuffersEXT(framebuffer, n, bufs);
  }

  public void glFramebufferFetchBarrierEXT() {
    glext_h.glFramebufferFetchBarrierEXT();
  }

  public void glFramebufferParameteri(int target, int pname, int param) {
    glext_h.glFramebufferParameteri(target, pname, param);
  }

  public void glFramebufferParameteriMESA(int target, int pname, int param) {
    glext_h.glFramebufferParameteriMESA(target, pname, param);
  }

  public void glFramebufferReadBufferEXT(int framebuffer, int mode) {
    glext_h.glFramebufferReadBufferEXT(framebuffer, mode);
  }

  public void glFramebufferRenderbuffer(int target, int attachment, int renderbuffertarget, int renderbuffer) {
    glext_h.glFramebufferRenderbuffer(target, attachment, renderbuffertarget, renderbuffer);
  }

  public void glFramebufferRenderbufferEXT(int target, int attachment, int renderbuffertarget, int renderbuffer) {
    glext_h.glFramebufferRenderbufferEXT(target, attachment, renderbuffertarget, renderbuffer);
  }

  public void glFramebufferSampleLocationsfvARB(int target, int start, int count, Addressable v) {
    glext_h.glFramebufferSampleLocationsfvARB(target, start, count, v);
  }

  public void glFramebufferSampleLocationsfvNV(int target, int start, int count, Addressable v) {
    glext_h.glFramebufferSampleLocationsfvNV(target, start, count, v);
  }

  public void glFramebufferSamplePositionsfvAMD(int target, int numsamples, int pixelindex, Addressable values) {
    glext_h.glFramebufferSamplePositionsfvAMD(target, numsamples, pixelindex, values);
  }

  public void glFramebufferTexture(int target, int attachment, int texture, int level) {
    glext_h.glFramebufferTexture(target, attachment, texture, level);
  }

  public void glFramebufferTexture1D(int target, int attachment, int textarget, int texture, int level) {
    glext_h.glFramebufferTexture1D(target, attachment, textarget, texture, level);
  }

  public void glFramebufferTexture1DEXT(int target, int attachment, int textarget, int texture, int level) {
    glext_h.glFramebufferTexture1DEXT(target, attachment, textarget, texture, level);
  }

  public void glFramebufferTexture2D(int target, int attachment, int textarget, int texture, int level) {
    glext_h.glFramebufferTexture2D(target, attachment, textarget, texture, level);
  }

  public void glFramebufferTexture2DEXT(int target, int attachment, int textarget, int texture, int level) {
    glext_h.glFramebufferTexture2DEXT(target, attachment, textarget, texture, level);
  }

  public void glFramebufferTexture3D(int target, int attachment, int textarget, int texture, int level, int zoffset) {
    glext_h.glFramebufferTexture3D(target, attachment, textarget, texture, level, zoffset);
  }

  public void glFramebufferTexture3DEXT(int target, int attachment, int textarget, int texture, int level, int zoffset) {
    glext_h.glFramebufferTexture3DEXT(target, attachment, textarget, texture, level, zoffset);
  }

  public void glFramebufferTextureARB(int target, int attachment, int texture, int level) {
    glext_h.glFramebufferTextureARB(target, attachment, texture, level);
  }

  public void glFramebufferTextureEXT(int target, int attachment, int texture, int level) {
    glext_h.glFramebufferTextureEXT(target, attachment, texture, level);
  }

  public void glFramebufferTextureFaceARB(int target, int attachment, int texture, int level, int face) {
    glext_h.glFramebufferTextureFaceARB(target, attachment, texture, level, face);
  }

  public void glFramebufferTextureFaceEXT(int target, int attachment, int texture, int level, int face) {
    glext_h.glFramebufferTextureFaceEXT(target, attachment, texture, level, face);
  }

  public void glFramebufferTextureLayer(int target, int attachment, int texture, int level, int layer) {
    glext_h.glFramebufferTextureLayer(target, attachment, texture, level, layer);
  }

  public void glFramebufferTextureLayerARB(int target, int attachment, int texture, int level, int layer) {
    glext_h.glFramebufferTextureLayerARB(target, attachment, texture, level, layer);
  }

  public void glFramebufferTextureLayerEXT(int target, int attachment, int texture, int level, int layer) {
    glext_h.glFramebufferTextureLayerEXT(target, attachment, texture, level, layer);
  }

  public void glFramebufferTextureMultiviewOVR(int target, int attachment, int texture, int level, int baseViewIndex, int numViews) {
    glext_h.glFramebufferTextureMultiviewOVR(target, attachment, texture, level, baseViewIndex, numViews);
  }

  public void glFreeObjectBufferATI(int buffer) {
    glext_h.glFreeObjectBufferATI(buffer);
  }

  public void glFrustumfOES(float l, float r, float b, float t, float n, float f) {
    glext_h.glFrustumfOES(l, r, b, t, n, f);
  }

  public void glFrustumxOES(int l, int r, int b, int t, int n, int f) {
    glext_h.glFrustumxOES(l, r, b, t, n, f);
  }

  public int glGenAsyncMarkersSGIX(int range) {
    return glext_h.glGenAsyncMarkersSGIX(range);
  }

  public void glGenBuffers(int n, Addressable buffers) {
    glext_h.glGenBuffers(n, buffers);
  }

  public void glGenBuffersARB(int n, Addressable buffers) {
    glext_h.glGenBuffersARB(n, buffers);
  }

  public void glGenFencesAPPLE(int n, Addressable fences) {
    glext_h.glGenFencesAPPLE(n, fences);
  }

  public void glGenFencesNV(int n, Addressable fences) {
    glext_h.glGenFencesNV(n, fences);
  }

  public int glGenFragmentShadersATI(int range) {
    return glext_h.glGenFragmentShadersATI(range);
  }

  public void glGenFramebuffers(int n, Addressable framebuffers) {
    glext_h.glGenFramebuffers(n, framebuffers);
  }

  public void glGenFramebuffersEXT(int n, Addressable framebuffers) {
    glext_h.glGenFramebuffersEXT(n, framebuffers);
  }

  public void glGenNamesAMD(int identifier, int num, Addressable names) {
    glext_h.glGenNamesAMD(identifier, num, names);
  }

  public void glGenOcclusionQueriesNV(int n, Addressable ids) {
    glext_h.glGenOcclusionQueriesNV(n, ids);
  }

  public int glGenPathsNV(int range) {
    return glext_h.glGenPathsNV(range);
  }

  public void glGenPerfMonitorsAMD(int n, Addressable monitors) {
    glext_h.glGenPerfMonitorsAMD(n, monitors);
  }

  public void glGenProgramPipelines(int n, Addressable pipelines) {
    glext_h.glGenProgramPipelines(n, pipelines);
  }

  public void glGenProgramsARB(int n, Addressable programs) {
    glext_h.glGenProgramsARB(n, programs);
  }

  public void glGenProgramsNV(int n, Addressable programs) {
    glext_h.glGenProgramsNV(n, programs);
  }

  public void glGenQueries(int n, Addressable ids) {
    glext_h.glGenQueries(n, ids);
  }

  public void glGenQueriesARB(int n, Addressable ids) {
    glext_h.glGenQueriesARB(n, ids);
  }

  public void glGenQueryResourceTagNV(int n, Addressable tagIds) {
    glext_h.glGenQueryResourceTagNV(n, tagIds);
  }

  public void glGenRenderbuffers(int n, Addressable renderbuffers) {
    glext_h.glGenRenderbuffers(n, renderbuffers);
  }

  public void glGenRenderbuffersEXT(int n, Addressable renderbuffers) {
    glext_h.glGenRenderbuffersEXT(n, renderbuffers);
  }

  public void glGenSamplers(int count, Addressable samplers) {
    glext_h.glGenSamplers(count, samplers);
  }

  public void glGenSemaphoresEXT(int n, Addressable semaphores) {
    glext_h.glGenSemaphoresEXT(n, semaphores);
  }

  public int glGenSymbolsEXT(int datatype, int storagetype, int range, int components) {
    return glext_h.glGenSymbolsEXT(datatype, storagetype, range, components);
  }

  public void glGenTexturesEXT(int n, Addressable textures) {
    glext_h.glGenTexturesEXT(n, textures);
  }

  public void glGenTransformFeedbacks(int n, Addressable ids) {
    glext_h.glGenTransformFeedbacks(n, ids);
  }

  public void glGenTransformFeedbacksNV(int n, Addressable ids) {
    glext_h.glGenTransformFeedbacksNV(n, ids);
  }

  public void glGenVertexArrays(int n, Addressable arrays) {
    glext_h.glGenVertexArrays(n, arrays);
  }

  public void glGenVertexArraysAPPLE(int n, Addressable arrays) {
    glext_h.glGenVertexArraysAPPLE(n, arrays);
  }

  public int glGenVertexShadersEXT(int range) {
    return glext_h.glGenVertexShadersEXT(range);
  }

  public void glGenerateMipmap(int target) {
    glext_h.glGenerateMipmap(target);
  }

  public void glGenerateMipmapEXT(int target) {
    glext_h.glGenerateMipmapEXT(target);
  }

  public void glGenerateMultiTexMipmapEXT(int texunit, int target) {
    glext_h.glGenerateMultiTexMipmapEXT(texunit, target);
  }

  public void glGenerateTextureMipmap(int texture) {
    glext_h.glGenerateTextureMipmap(texture);
  }

  public void glGenerateTextureMipmapEXT(int texture, int target) {
    glext_h.glGenerateTextureMipmapEXT(texture, target);
  }

  public void glGetActiveAtomicCounterBufferiv(int program, int bufferIndex, int pname, Addressable params) {
    glext_h.glGetActiveAtomicCounterBufferiv(program, bufferIndex, pname, params);
  }

  public void glGetActiveAttrib(int program, int index, int bufSize, Addressable length, Addressable size, Addressable type, Addressable name) {
    glext_h.glGetActiveAttrib(program, index, bufSize, length, size, type, name);
  }

  public void glGetActiveAttribARB(int programObj, int index, int maxLength, Addressable length, Addressable size, Addressable type, Addressable name) {
    glext_h.glGetActiveAttribARB(programObj, index, maxLength, length, size, type, name);
  }

  public void glGetActiveSubroutineName(int program, int shadertype, int index, int bufSize, Addressable length, Addressable name) {
    glext_h.glGetActiveSubroutineName(program, shadertype, index, bufSize, length, name);
  }

  public void glGetActiveSubroutineUniformName(int program, int shadertype, int index, int bufSize, Addressable length, Addressable name) {
    glext_h.glGetActiveSubroutineUniformName(program, shadertype, index, bufSize, length, name);
  }

  public void glGetActiveSubroutineUniformiv(int program, int shadertype, int index, int pname, Addressable values) {
    glext_h.glGetActiveSubroutineUniformiv(program, shadertype, index, pname, values);
  }

  public void glGetActiveUniform(int program, int index, int bufSize, Addressable length, Addressable size, Addressable type, Addressable name) {
    glext_h.glGetActiveUniform(program, index, bufSize, length, size, type, name);
  }

  public void glGetActiveUniformARB(int programObj, int index, int maxLength, Addressable length, Addressable size, Addressable type, Addressable name) {
    glext_h.glGetActiveUniformARB(programObj, index, maxLength, length, size, type, name);
  }

  public void glGetActiveUniformBlockName(int program, int uniformBlockIndex, int bufSize, Addressable length, Addressable uniformBlockName) {
    glext_h.glGetActiveUniformBlockName(program, uniformBlockIndex, bufSize, length, uniformBlockName);
  }

  public void glGetActiveUniformBlockiv(int program, int uniformBlockIndex, int pname, Addressable params) {
    glext_h.glGetActiveUniformBlockiv(program, uniformBlockIndex, pname, params);
  }

  public void glGetActiveUniformName(int program, int uniformIndex, int bufSize, Addressable length, Addressable uniformName) {
    glext_h.glGetActiveUniformName(program, uniformIndex, bufSize, length, uniformName);
  }

  public void glGetActiveUniformsiv(int program, int uniformCount, Addressable uniformIndices, int pname, Addressable params) {
    glext_h.glGetActiveUniformsiv(program, uniformCount, uniformIndices, pname, params);
  }

  public void glGetActiveVaryingNV(int program, int index, int bufSize, Addressable length, Addressable size, Addressable type, Addressable name) {
    glext_h.glGetActiveVaryingNV(program, index, bufSize, length, size, type, name);
  }

  public void glGetArrayObjectfvATI(int array, int pname, Addressable params) {
    glext_h.glGetArrayObjectfvATI(array, pname, params);
  }

  public void glGetArrayObjectivATI(int array, int pname, Addressable params) {
    glext_h.glGetArrayObjectivATI(array, pname, params);
  }

  public void glGetAttachedObjectsARB(int containerObj, int maxCount, Addressable count, Addressable obj) {
    glext_h.glGetAttachedObjectsARB(containerObj, maxCount, count, obj);
  }

  public void glGetAttachedShaders(int program, int maxCount, Addressable count, Addressable shaders) {
    glext_h.glGetAttachedShaders(program, maxCount, count, shaders);
  }

  public int glGetAttribLocation(int program, Addressable name) {
    return glext_h.glGetAttribLocation(program, name);
  }

  public int glGetAttribLocationARB(int programObj, Addressable name) {
    return glext_h.glGetAttribLocationARB(programObj, name);
  }

  public void glGetBooleanIndexedvEXT(int target, int index, Addressable data) {
    glext_h.glGetBooleanIndexedvEXT(target, index, data);
  }

  public void glGetBooleani_v(int target, int index, Addressable data) {
    glext_h.glGetBooleani_v(target, index, data);
  }

  public void glGetBufferParameteri64v(int target, int pname, Addressable params) {
    glext_h.glGetBufferParameteri64v(target, pname, params);
  }

  public void glGetBufferParameteriv(int target, int pname, Addressable params) {
    glext_h.glGetBufferParameteriv(target, pname, params);
  }

  public void glGetBufferParameterivARB(int target, int pname, Addressable params) {
    glext_h.glGetBufferParameterivARB(target, pname, params);
  }

  public void glGetBufferParameterui64vNV(int target, int pname, Addressable params) {
    glext_h.glGetBufferParameterui64vNV(target, pname, params);
  }

  public void glGetBufferPointerv(int target, int pname, Addressable params) {
    glext_h.glGetBufferPointerv(target, pname, params);
  }

  public void glGetBufferPointervARB(int target, int pname, Addressable params) {
    glext_h.glGetBufferPointervARB(target, pname, params);
  }

  public void glGetBufferSubData(int target, long offset, long size, Addressable data) {
    glext_h.glGetBufferSubData(target, offset, size, data);
  }

  public void glGetBufferSubDataARB(int target, long offset, long size, Addressable data) {
    glext_h.glGetBufferSubDataARB(target, offset, size, data);
  }

  public void glGetClipPlanefOES(int plane, Addressable equation) {
    glext_h.glGetClipPlanefOES(plane, equation);
  }

  public void glGetClipPlanexOES(int plane, Addressable equation) {
    glext_h.glGetClipPlanexOES(plane, equation);
  }

  public void glGetColorTableEXT(int target, int format, int type, Addressable data) {
    glext_h.glGetColorTableEXT(target, format, type, data);
  }

  public void glGetColorTableParameterfvEXT(int target, int pname, Addressable params) {
    glext_h.glGetColorTableParameterfvEXT(target, pname, params);
  }

  public void glGetColorTableParameterfvSGI(int target, int pname, Addressable params) {
    glext_h.glGetColorTableParameterfvSGI(target, pname, params);
  }

  public void glGetColorTableParameterivEXT(int target, int pname, Addressable params) {
    glext_h.glGetColorTableParameterivEXT(target, pname, params);
  }

  public void glGetColorTableParameterivSGI(int target, int pname, Addressable params) {
    glext_h.glGetColorTableParameterivSGI(target, pname, params);
  }

  public void glGetColorTableSGI(int target, int format, int type, Addressable table) {
    glext_h.glGetColorTableSGI(target, format, type, table);
  }

  public void glGetCombinerInputParameterfvNV(int stage, int portion, int variable, int pname, Addressable params) {
    glext_h.glGetCombinerInputParameterfvNV(stage, portion, variable, pname, params);
  }

  public void glGetCombinerInputParameterivNV(int stage, int portion, int variable, int pname, Addressable params) {
    glext_h.glGetCombinerInputParameterivNV(stage, portion, variable, pname, params);
  }

  public void glGetCombinerOutputParameterfvNV(int stage, int portion, int pname, Addressable params) {
    glext_h.glGetCombinerOutputParameterfvNV(stage, portion, pname, params);
  }

  public void glGetCombinerOutputParameterivNV(int stage, int portion, int pname, Addressable params) {
    glext_h.glGetCombinerOutputParameterivNV(stage, portion, pname, params);
  }

  public void glGetCombinerStageParameterfvNV(int stage, int pname, Addressable params) {
    glext_h.glGetCombinerStageParameterfvNV(stage, pname, params);
  }

  public int glGetCommandHeaderNV(int tokenID, int size) {
    return glext_h.glGetCommandHeaderNV(tokenID, size);
  }

  public void glGetCompressedMultiTexImageEXT(int texunit, int target, int lod, Addressable img) {
    glext_h.glGetCompressedMultiTexImageEXT(texunit, target, lod, img);
  }

  public void glGetCompressedTexImageARB(int target, int level, Addressable img) {
    glext_h.glGetCompressedTexImageARB(target, level, img);
  }

  public void glGetCompressedTextureImage(int texture, int level, int bufSize, Addressable pixels) {
    glext_h.glGetCompressedTextureImage(texture, level, bufSize, pixels);
  }

  public void glGetCompressedTextureImageEXT(int texture, int target, int lod, Addressable img) {
    glext_h.glGetCompressedTextureImageEXT(texture, target, lod, img);
  }

  public void glGetCompressedTextureSubImage(int texture, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int bufSize, Addressable pixels) {
    glext_h.glGetCompressedTextureSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, bufSize, pixels);
  }

  public void glGetConvolutionFilterEXT(int target, int format, int type, Addressable image) {
    glext_h.glGetConvolutionFilterEXT(target, format, type, image);
  }

  public void glGetConvolutionParameterfvEXT(int target, int pname, Addressable params) {
    glext_h.glGetConvolutionParameterfvEXT(target, pname, params);
  }

  public void glGetConvolutionParameterivEXT(int target, int pname, Addressable params) {
    glext_h.glGetConvolutionParameterivEXT(target, pname, params);
  }

  public void glGetConvolutionParameterxvOES(int target, int pname, Addressable params) {
    glext_h.glGetConvolutionParameterxvOES(target, pname, params);
  }

  public void glGetCoverageModulationTableNV(int bufSize, Addressable v) {
    glext_h.glGetCoverageModulationTableNV(bufSize, v);
  }

  public int glGetDebugMessageLog(int count, int bufSize, Addressable sources, Addressable types, Addressable ids, Addressable severities, Addressable lengths, Addressable messageLog) {
    return glext_h.glGetDebugMessageLog(count, bufSize, sources, types, ids, severities, lengths, messageLog);
  }

  public int glGetDebugMessageLogAMD(int count, int bufSize, Addressable categories, Addressable severities, Addressable ids, Addressable lengths, Addressable message) {
    return glext_h.glGetDebugMessageLogAMD(count, bufSize, categories, severities, ids, lengths, message);
  }

  public int glGetDebugMessageLogARB(int count, int bufSize, Addressable sources, Addressable types, Addressable ids, Addressable severities, Addressable lengths, Addressable messageLog) {
    return glext_h.glGetDebugMessageLogARB(count, bufSize, sources, types, ids, severities, lengths, messageLog);
  }

  public void glGetDetailTexFuncSGIS(int target, Addressable points) {
    glext_h.glGetDetailTexFuncSGIS(target, points);
  }

  public void glGetDoubleIndexedvEXT(int target, int index, Addressable data) {
    glext_h.glGetDoubleIndexedvEXT(target, index, data);
  }

  public void glGetDoublei_v(int target, int index, Addressable data) {
    glext_h.glGetDoublei_v(target, index, data);
  }

  public void glGetDoublei_vEXT(int pname, int index, Addressable params) {
    glext_h.glGetDoublei_vEXT(pname, index, params);
  }

  public void glGetFenceivNV(int fence, int pname, Addressable params) {
    glext_h.glGetFenceivNV(fence, pname, params);
  }

  public void glGetFinalCombinerInputParameterfvNV(int variable, int pname, Addressable params) {
    glext_h.glGetFinalCombinerInputParameterfvNV(variable, pname, params);
  }

  public void glGetFinalCombinerInputParameterivNV(int variable, int pname, Addressable params) {
    glext_h.glGetFinalCombinerInputParameterivNV(variable, pname, params);
  }

  public void glGetFirstPerfQueryIdINTEL(Addressable queryId) {
    glext_h.glGetFirstPerfQueryIdINTEL(queryId);
  }

  public void glGetFixedvOES(int pname, Addressable params) {
    glext_h.glGetFixedvOES(pname, params);
  }

  public void glGetFloatIndexedvEXT(int target, int index, Addressable data) {
    glext_h.glGetFloatIndexedvEXT(target, index, data);
  }

  public void glGetFloati_v(int target, int index, Addressable data) {
    glext_h.glGetFloati_v(target, index, data);
  }

  public void glGetFloati_vEXT(int pname, int index, Addressable params) {
    glext_h.glGetFloati_vEXT(pname, index, params);
  }

  public void glGetFogFuncSGIS(Addressable points) {
    glext_h.glGetFogFuncSGIS(points);
  }

  public int glGetFragDataIndex(int program, Addressable name) {
    return glext_h.glGetFragDataIndex(program, name);
  }

  public int glGetFragDataLocation(int program, Addressable name) {
    return glext_h.glGetFragDataLocation(program, name);
  }

  public int glGetFragDataLocationEXT(int program, Addressable name) {
    return glext_h.glGetFragDataLocationEXT(program, name);
  }

  public void glGetFragmentLightfvSGIX(int light, int pname, Addressable params) {
    glext_h.glGetFragmentLightfvSGIX(light, pname, params);
  }

  public void glGetFragmentLightivSGIX(int light, int pname, Addressable params) {
    glext_h.glGetFragmentLightivSGIX(light, pname, params);
  }

  public void glGetFragmentMaterialfvSGIX(int face, int pname, Addressable params) {
    glext_h.glGetFragmentMaterialfvSGIX(face, pname, params);
  }

  public void glGetFragmentMaterialivSGIX(int face, int pname, Addressable params) {
    glext_h.glGetFragmentMaterialivSGIX(face, pname, params);
  }

  public void glGetFramebufferAttachmentParameteriv(int target, int attachment, int pname, Addressable params) {
    glext_h.glGetFramebufferAttachmentParameteriv(target, attachment, pname, params);
  }

  public void glGetFramebufferAttachmentParameterivEXT(int target, int attachment, int pname, Addressable params) {
    glext_h.glGetFramebufferAttachmentParameterivEXT(target, attachment, pname, params);
  }

  public void glGetFramebufferParameterfvAMD(int target, int pname, int numsamples, int pixelindex, int size, Addressable values) {
    glext_h.glGetFramebufferParameterfvAMD(target, pname, numsamples, pixelindex, size, values);
  }

  public void glGetFramebufferParameteriv(int target, int pname, Addressable params) {
    glext_h.glGetFramebufferParameteriv(target, pname, params);
  }

  public void glGetFramebufferParameterivEXT(int framebuffer, int pname, Addressable params) {
    glext_h.glGetFramebufferParameterivEXT(framebuffer, pname, params);
  }

  public void glGetFramebufferParameterivMESA(int target, int pname, Addressable params) {
    glext_h.glGetFramebufferParameterivMESA(target, pname, params);
  }

  public int glGetGraphicsResetStatus() {
    return glext_h.glGetGraphicsResetStatus();
  }

  public int glGetGraphicsResetStatusARB() {
    return glext_h.glGetGraphicsResetStatusARB();
  }

  public int glGetHandleARB(int pname) {
    return glext_h.glGetHandleARB(pname);
  }

  public void glGetHistogramEXT(int target, byte reset, int format, int type, Addressable values) {
    glext_h.glGetHistogramEXT(target, reset, format, type, values);
  }

  public void glGetHistogramParameterfvEXT(int target, int pname, Addressable params) {
    glext_h.glGetHistogramParameterfvEXT(target, pname, params);
  }

  public void glGetHistogramParameterivEXT(int target, int pname, Addressable params) {
    glext_h.glGetHistogramParameterivEXT(target, pname, params);
  }

  public void glGetHistogramParameterxvOES(int target, int pname, Addressable params) {
    glext_h.glGetHistogramParameterxvOES(target, pname, params);
  }

  public long glGetImageHandleARB(int texture, int level, byte layered, int layer, int format) {
    return glext_h.glGetImageHandleARB(texture, level, layered, layer, format);
  }

  public long glGetImageHandleNV(int texture, int level, byte layered, int layer, int format) {
    return glext_h.glGetImageHandleNV(texture, level, layered, layer, format);
  }

  public void glGetImageTransformParameterfvHP(int target, int pname, Addressable params) {
    glext_h.glGetImageTransformParameterfvHP(target, pname, params);
  }

  public void glGetImageTransformParameterivHP(int target, int pname, Addressable params) {
    glext_h.glGetImageTransformParameterivHP(target, pname, params);
  }

  public void glGetInfoLogARB(int obj, int maxLength, Addressable length, Addressable infoLog) {
    glext_h.glGetInfoLogARB(obj, maxLength, length, infoLog);
  }

  public int glGetInstrumentsSGIX() {
    return glext_h.glGetInstrumentsSGIX();
  }

  public void glGetInteger64i_v(int target, int index, Addressable data) {
    glext_h.glGetInteger64i_v(target, index, data);
  }

  public void glGetInteger64v(int pname, Addressable data) {
    glext_h.glGetInteger64v(pname, data);
  }

  public void glGetIntegerIndexedvEXT(int target, int index, Addressable data) {
    glext_h.glGetIntegerIndexedvEXT(target, index, data);
  }

  public void glGetIntegeri_v(int target, int index, Addressable data) {
    glext_h.glGetIntegeri_v(target, index, data);
  }

  public void glGetIntegerui64i_vNV(int value, int index, Addressable result) {
    glext_h.glGetIntegerui64i_vNV(value, index, result);
  }

  public void glGetIntegerui64vNV(int value, Addressable result) {
    glext_h.glGetIntegerui64vNV(value, result);
  }

  public void glGetInternalformatSampleivNV(int target, int internalformat, int samples, int pname, int count, Addressable params) {
    glext_h.glGetInternalformatSampleivNV(target, internalformat, samples, pname, count, params);
  }

  public void glGetInternalformati64v(int target, int internalformat, int pname, int count, Addressable params) {
    glext_h.glGetInternalformati64v(target, internalformat, pname, count, params);
  }

  public void glGetInternalformativ(int target, int internalformat, int pname, int count, Addressable params) {
    glext_h.glGetInternalformativ(target, internalformat, pname, count, params);
  }

  public void glGetInvariantBooleanvEXT(int id, int value, Addressable data) {
    glext_h.glGetInvariantBooleanvEXT(id, value, data);
  }

  public void glGetInvariantFloatvEXT(int id, int value, Addressable data) {
    glext_h.glGetInvariantFloatvEXT(id, value, data);
  }

  public void glGetInvariantIntegervEXT(int id, int value, Addressable data) {
    glext_h.glGetInvariantIntegervEXT(id, value, data);
  }

  public void glGetLightxOES(int light, int pname, Addressable params) {
    glext_h.glGetLightxOES(light, pname, params);
  }

  public void glGetListParameterfvSGIX(int list, int pname, Addressable params) {
    glext_h.glGetListParameterfvSGIX(list, pname, params);
  }

  public void glGetListParameterivSGIX(int list, int pname, Addressable params) {
    glext_h.glGetListParameterivSGIX(list, pname, params);
  }

  public void glGetLocalConstantBooleanvEXT(int id, int value, Addressable data) {
    glext_h.glGetLocalConstantBooleanvEXT(id, value, data);
  }

  public void glGetLocalConstantFloatvEXT(int id, int value, Addressable data) {
    glext_h.glGetLocalConstantFloatvEXT(id, value, data);
  }

  public void glGetLocalConstantIntegervEXT(int id, int value, Addressable data) {
    glext_h.glGetLocalConstantIntegervEXT(id, value, data);
  }

  public void glGetMapAttribParameterfvNV(int target, int index, int pname, Addressable params) {
    glext_h.glGetMapAttribParameterfvNV(target, index, pname, params);
  }

  public void glGetMapAttribParameterivNV(int target, int index, int pname, Addressable params) {
    glext_h.glGetMapAttribParameterivNV(target, index, pname, params);
  }

  public void glGetMapControlPointsNV(int target, int index, int type, int ustride, int vstride, byte packed, Addressable points) {
    glext_h.glGetMapControlPointsNV(target, index, type, ustride, vstride, packed, points);
  }

  public void glGetMapParameterfvNV(int target, int pname, Addressable params) {
    glext_h.glGetMapParameterfvNV(target, pname, params);
  }

  public void glGetMapParameterivNV(int target, int pname, Addressable params) {
    glext_h.glGetMapParameterivNV(target, pname, params);
  }

  public void glGetMapxvOES(int target, int query, Addressable v) {
    glext_h.glGetMapxvOES(target, query, v);
  }

  public void glGetMaterialxOES(int face, int pname, int param) {
    glext_h.glGetMaterialxOES(face, pname, param);
  }

  public void glGetMemoryObjectDetachedResourcesuivNV(int memory, int pname, int first, int count, Addressable params) {
    glext_h.glGetMemoryObjectDetachedResourcesuivNV(memory, pname, first, count, params);
  }

  public void glGetMemoryObjectParameterivEXT(int memoryObject, int pname, Addressable params) {
    glext_h.glGetMemoryObjectParameterivEXT(memoryObject, pname, params);
  }

  public void glGetMinmaxEXT(int target, byte reset, int format, int type, Addressable values) {
    glext_h.glGetMinmaxEXT(target, reset, format, type, values);
  }

  public void glGetMinmaxParameterfvEXT(int target, int pname, Addressable params) {
    glext_h.glGetMinmaxParameterfvEXT(target, pname, params);
  }

  public void glGetMinmaxParameterivEXT(int target, int pname, Addressable params) {
    glext_h.glGetMinmaxParameterivEXT(target, pname, params);
  }

  public void glGetMultiTexEnvfvEXT(int texunit, int target, int pname, Addressable params) {
    glext_h.glGetMultiTexEnvfvEXT(texunit, target, pname, params);
  }

  public void glGetMultiTexEnvivEXT(int texunit, int target, int pname, Addressable params) {
    glext_h.glGetMultiTexEnvivEXT(texunit, target, pname, params);
  }

  public void glGetMultiTexGendvEXT(int texunit, int coord, int pname, Addressable params) {
    glext_h.glGetMultiTexGendvEXT(texunit, coord, pname, params);
  }

  public void glGetMultiTexGenfvEXT(int texunit, int coord, int pname, Addressable params) {
    glext_h.glGetMultiTexGenfvEXT(texunit, coord, pname, params);
  }

  public void glGetMultiTexGenivEXT(int texunit, int coord, int pname, Addressable params) {
    glext_h.glGetMultiTexGenivEXT(texunit, coord, pname, params);
  }

  public void glGetMultiTexImageEXT(int texunit, int target, int level, int format, int type, Addressable pixels) {
    glext_h.glGetMultiTexImageEXT(texunit, target, level, format, type, pixels);
  }

  public void glGetMultiTexLevelParameterfvEXT(int texunit, int target, int level, int pname, Addressable params) {
    glext_h.glGetMultiTexLevelParameterfvEXT(texunit, target, level, pname, params);
  }

  public void glGetMultiTexLevelParameterivEXT(int texunit, int target, int level, int pname, Addressable params) {
    glext_h.glGetMultiTexLevelParameterivEXT(texunit, target, level, pname, params);
  }

  public void glGetMultiTexParameterIivEXT(int texunit, int target, int pname, Addressable params) {
    glext_h.glGetMultiTexParameterIivEXT(texunit, target, pname, params);
  }

  public void glGetMultiTexParameterIuivEXT(int texunit, int target, int pname, Addressable params) {
    glext_h.glGetMultiTexParameterIuivEXT(texunit, target, pname, params);
  }

  public void glGetMultiTexParameterfvEXT(int texunit, int target, int pname, Addressable params) {
    glext_h.glGetMultiTexParameterfvEXT(texunit, target, pname, params);
  }

  public void glGetMultiTexParameterivEXT(int texunit, int target, int pname, Addressable params) {
    glext_h.glGetMultiTexParameterivEXT(texunit, target, pname, params);
  }

  public void glGetMultisamplefv(int pname, int index, Addressable val) {
    glext_h.glGetMultisamplefv(pname, index, val);
  }

  public void glGetMultisamplefvNV(int pname, int index, Addressable val) {
    glext_h.glGetMultisamplefvNV(pname, index, val);
  }

  public void glGetNamedBufferParameteri64v(int buffer, int pname, Addressable params) {
    glext_h.glGetNamedBufferParameteri64v(buffer, pname, params);
  }

  public void glGetNamedBufferParameteriv(int buffer, int pname, Addressable params) {
    glext_h.glGetNamedBufferParameteriv(buffer, pname, params);
  }

  public void glGetNamedBufferParameterivEXT(int buffer, int pname, Addressable params) {
    glext_h.glGetNamedBufferParameterivEXT(buffer, pname, params);
  }

  public void glGetNamedBufferParameterui64vNV(int buffer, int pname, Addressable params) {
    glext_h.glGetNamedBufferParameterui64vNV(buffer, pname, params);
  }

  public void glGetNamedBufferPointerv(int buffer, int pname, Addressable params) {
    glext_h.glGetNamedBufferPointerv(buffer, pname, params);
  }

  public void glGetNamedBufferPointervEXT(int buffer, int pname, Addressable params) {
    glext_h.glGetNamedBufferPointervEXT(buffer, pname, params);
  }

  public void glGetNamedBufferSubData(int buffer, long offset, long size, Addressable data) {
    glext_h.glGetNamedBufferSubData(buffer, offset, size, data);
  }

  public void glGetNamedBufferSubDataEXT(int buffer, long offset, long size, Addressable data) {
    glext_h.glGetNamedBufferSubDataEXT(buffer, offset, size, data);
  }

  public void glGetNamedFramebufferAttachmentParameteriv(int framebuffer, int attachment, int pname, Addressable params) {
    glext_h.glGetNamedFramebufferAttachmentParameteriv(framebuffer, attachment, pname, params);
  }

  public void glGetNamedFramebufferAttachmentParameterivEXT(int framebuffer, int attachment, int pname, Addressable params) {
    glext_h.glGetNamedFramebufferAttachmentParameterivEXT(framebuffer, attachment, pname, params);
  }

  public void glGetNamedFramebufferParameterfvAMD(int framebuffer, int pname, int numsamples, int pixelindex, int size, Addressable values) {
    glext_h.glGetNamedFramebufferParameterfvAMD(framebuffer, pname, numsamples, pixelindex, size, values);
  }

  public void glGetNamedFramebufferParameteriv(int framebuffer, int pname, Addressable param) {
    glext_h.glGetNamedFramebufferParameteriv(framebuffer, pname, param);
  }

  public void glGetNamedFramebufferParameterivEXT(int framebuffer, int pname, Addressable params) {
    glext_h.glGetNamedFramebufferParameterivEXT(framebuffer, pname, params);
  }

  public void glGetNamedProgramLocalParameterIivEXT(int program, int target, int index, Addressable params) {
    glext_h.glGetNamedProgramLocalParameterIivEXT(program, target, index, params);
  }

  public void glGetNamedProgramLocalParameterIuivEXT(int program, int target, int index, Addressable params) {
    glext_h.glGetNamedProgramLocalParameterIuivEXT(program, target, index, params);
  }

  public void glGetNamedProgramLocalParameterdvEXT(int program, int target, int index, Addressable params) {
    glext_h.glGetNamedProgramLocalParameterdvEXT(program, target, index, params);
  }

  public void glGetNamedProgramLocalParameterfvEXT(int program, int target, int index, Addressable params) {
    glext_h.glGetNamedProgramLocalParameterfvEXT(program, target, index, params);
  }

  public void glGetNamedProgramStringEXT(int program, int target, int pname, Addressable string) {
    glext_h.glGetNamedProgramStringEXT(program, target, pname, string);
  }

  public void glGetNamedProgramivEXT(int program, int target, int pname, Addressable params) {
    glext_h.glGetNamedProgramivEXT(program, target, pname, params);
  }

  public void glGetNamedRenderbufferParameteriv(int renderbuffer, int pname, Addressable params) {
    glext_h.glGetNamedRenderbufferParameteriv(renderbuffer, pname, params);
  }

  public void glGetNamedRenderbufferParameterivEXT(int renderbuffer, int pname, Addressable params) {
    glext_h.glGetNamedRenderbufferParameterivEXT(renderbuffer, pname, params);
  }

  public void glGetNamedStringARB(int namelen, Addressable name, int bufSize, Addressable stringlen, Addressable string) {
    glext_h.glGetNamedStringARB(namelen, name, bufSize, stringlen, string);
  }

  public void glGetNamedStringivARB(int namelen, Addressable name, int pname, Addressable params) {
    glext_h.glGetNamedStringivARB(namelen, name, pname, params);
  }

  public void glGetNextPerfQueryIdINTEL(int queryId, Addressable nextQueryId) {
    glext_h.glGetNextPerfQueryIdINTEL(queryId, nextQueryId);
  }

  public void glGetObjectBufferfvATI(int buffer, int pname, Addressable params) {
    glext_h.glGetObjectBufferfvATI(buffer, pname, params);
  }

  public void glGetObjectBufferivATI(int buffer, int pname, Addressable params) {
    glext_h.glGetObjectBufferivATI(buffer, pname, params);
  }

  public void glGetObjectLabel(int identifier, int name, int bufSize, Addressable length, Addressable label) {
    glext_h.glGetObjectLabel(identifier, name, bufSize, length, label);
  }

  public void glGetObjectLabelEXT(int type, int object, int bufSize, Addressable length, Addressable label) {
    glext_h.glGetObjectLabelEXT(type, object, bufSize, length, label);
  }

  public void glGetObjectParameterfvARB(int obj, int pname, Addressable params) {
    glext_h.glGetObjectParameterfvARB(obj, pname, params);
  }

  public void glGetObjectParameterivAPPLE(int objectType, int name, int pname, Addressable params) {
    glext_h.glGetObjectParameterivAPPLE(objectType, name, pname, params);
  }

  public void glGetObjectParameterivARB(int obj, int pname, Addressable params) {
    glext_h.glGetObjectParameterivARB(obj, pname, params);
  }

  public void glGetObjectPtrLabel(Addressable ptr, int bufSize, Addressable length, Addressable label) {
    glext_h.glGetObjectPtrLabel(ptr, bufSize, length, label);
  }

  public void glGetOcclusionQueryivNV(int id, int pname, Addressable params) {
    glext_h.glGetOcclusionQueryivNV(id, pname, params);
  }

  public void glGetOcclusionQueryuivNV(int id, int pname, Addressable params) {
    glext_h.glGetOcclusionQueryuivNV(id, pname, params);
  }

  public void glGetPathColorGenfvNV(int color, int pname, Addressable value) {
    glext_h.glGetPathColorGenfvNV(color, pname, value);
  }

  public void glGetPathColorGenivNV(int color, int pname, Addressable value) {
    glext_h.glGetPathColorGenivNV(color, pname, value);
  }

  public void glGetPathCommandsNV(int path, Addressable commands) {
    glext_h.glGetPathCommandsNV(path, commands);
  }

  public void glGetPathCoordsNV(int path, Addressable coords) {
    glext_h.glGetPathCoordsNV(path, coords);
  }

  public void glGetPathDashArrayNV(int path, Addressable dashArray) {
    glext_h.glGetPathDashArrayNV(path, dashArray);
  }

  public float glGetPathLengthNV(int path, int startSegment, int numSegments) {
    return glext_h.glGetPathLengthNV(path, startSegment, numSegments);
  }

  public void glGetPathMetricRangeNV(int metricQueryMask, int firstPathName, int numPaths, int stride, Addressable metrics) {
    glext_h.glGetPathMetricRangeNV(metricQueryMask, firstPathName, numPaths, stride, metrics);
  }

  public void glGetPathMetricsNV(int metricQueryMask, int numPaths, int pathNameType, Addressable paths, int pathBase, int stride, Addressable metrics) {
    glext_h.glGetPathMetricsNV(metricQueryMask, numPaths, pathNameType, paths, pathBase, stride, metrics);
  }

  public void glGetPathParameterfvNV(int path, int pname, Addressable value) {
    glext_h.glGetPathParameterfvNV(path, pname, value);
  }

  public void glGetPathParameterivNV(int path, int pname, Addressable value) {
    glext_h.glGetPathParameterivNV(path, pname, value);
  }

  public void glGetPathSpacingNV(int pathListMode, int numPaths, int pathNameType, Addressable paths, int pathBase, float advanceScale, float kerningScale, int transformType, Addressable returnedSpacing) {
    glext_h.glGetPathSpacingNV(pathListMode, numPaths, pathNameType, paths, pathBase, advanceScale, kerningScale, transformType, returnedSpacing);
  }

  public void glGetPathTexGenfvNV(int texCoordSet, int pname, Addressable value) {
    glext_h.glGetPathTexGenfvNV(texCoordSet, pname, value);
  }

  public void glGetPathTexGenivNV(int texCoordSet, int pname, Addressable value) {
    glext_h.glGetPathTexGenivNV(texCoordSet, pname, value);
  }

  public void glGetPerfCounterInfoINTEL(int queryId, int counterId, int counterNameLength, Addressable counterName, int counterDescLength, Addressable counterDesc, Addressable counterOffset, Addressable counterDataSize, Addressable counterTypeEnum, Addressable counterDataTypeEnum, Addressable rawCounterMaxValue) {
    glext_h.glGetPerfCounterInfoINTEL(queryId, counterId, counterNameLength, counterName, counterDescLength, counterDesc, counterOffset, counterDataSize, counterTypeEnum, counterDataTypeEnum, rawCounterMaxValue);
  }

  public void glGetPerfMonitorCounterDataAMD(int monitor, int pname, int dataSize, Addressable data, Addressable bytesWritten) {
    glext_h.glGetPerfMonitorCounterDataAMD(monitor, pname, dataSize, data, bytesWritten);
  }

  public void glGetPerfMonitorCounterInfoAMD(int group, int counter, int pname, Addressable data) {
    glext_h.glGetPerfMonitorCounterInfoAMD(group, counter, pname, data);
  }

  public void glGetPerfMonitorCounterStringAMD(int group, int counter, int bufSize, Addressable length, Addressable counterString) {
    glext_h.glGetPerfMonitorCounterStringAMD(group, counter, bufSize, length, counterString);
  }

  public void glGetPerfMonitorCountersAMD(int group, Addressable numCounters, Addressable maxActiveCounters, int counterSize, Addressable counters) {
    glext_h.glGetPerfMonitorCountersAMD(group, numCounters, maxActiveCounters, counterSize, counters);
  }

  public void glGetPerfMonitorGroupStringAMD(int group, int bufSize, Addressable length, Addressable groupString) {
    glext_h.glGetPerfMonitorGroupStringAMD(group, bufSize, length, groupString);
  }

  public void glGetPerfMonitorGroupsAMD(Addressable numGroups, int groupsSize, Addressable groups) {
    glext_h.glGetPerfMonitorGroupsAMD(numGroups, groupsSize, groups);
  }

  public void glGetPerfQueryDataINTEL(int queryHandle, int flags, int dataSize, Addressable data, Addressable bytesWritten) {
    glext_h.glGetPerfQueryDataINTEL(queryHandle, flags, dataSize, data, bytesWritten);
  }

  public void glGetPerfQueryIdByNameINTEL(Addressable queryName, Addressable queryId) {
    glext_h.glGetPerfQueryIdByNameINTEL(queryName, queryId);
  }

  public void glGetPerfQueryInfoINTEL(int queryId, int queryNameLength, Addressable queryName, Addressable dataSize, Addressable noCounters, Addressable noInstances, Addressable capsMask) {
    glext_h.glGetPerfQueryInfoINTEL(queryId, queryNameLength, queryName, dataSize, noCounters, noInstances, capsMask);
  }

  public void glGetPixelMapxv(int map, int size, Addressable values) {
    glext_h.glGetPixelMapxv(map, size, values);
  }

  public void glGetPixelTexGenParameterfvSGIS(int pname, Addressable params) {
    glext_h.glGetPixelTexGenParameterfvSGIS(pname, params);
  }

  public void glGetPixelTexGenParameterivSGIS(int pname, Addressable params) {
    glext_h.glGetPixelTexGenParameterivSGIS(pname, params);
  }

  public void glGetPixelTransformParameterfvEXT(int target, int pname, Addressable params) {
    glext_h.glGetPixelTransformParameterfvEXT(target, pname, params);
  }

  public void glGetPixelTransformParameterivEXT(int target, int pname, Addressable params) {
    glext_h.glGetPixelTransformParameterivEXT(target, pname, params);
  }

  public void glGetPointerIndexedvEXT(int target, int index, Addressable data) {
    glext_h.glGetPointerIndexedvEXT(target, index, data);
  }

  public void glGetPointeri_vEXT(int pname, int index, Addressable params) {
    glext_h.glGetPointeri_vEXT(pname, index, params);
  }

  public void glGetPointervEXT(int pname, Addressable params) {
    glext_h.glGetPointervEXT(pname, params);
  }

  public void glGetProgramBinary(int program, int bufSize, Addressable length, Addressable binaryFormat, Addressable binary) {
    glext_h.glGetProgramBinary(program, bufSize, length, binaryFormat, binary);
  }

  public void glGetProgramEnvParameterIivNV(int target, int index, Addressable params) {
    glext_h.glGetProgramEnvParameterIivNV(target, index, params);
  }

  public void glGetProgramEnvParameterIuivNV(int target, int index, Addressable params) {
    glext_h.glGetProgramEnvParameterIuivNV(target, index, params);
  }

  public void glGetProgramEnvParameterdvARB(int target, int index, Addressable params) {
    glext_h.glGetProgramEnvParameterdvARB(target, index, params);
  }

  public void glGetProgramEnvParameterfvARB(int target, int index, Addressable params) {
    glext_h.glGetProgramEnvParameterfvARB(target, index, params);
  }

  public void glGetProgramInfoLog(int program, int bufSize, Addressable length, Addressable infoLog) {
    glext_h.glGetProgramInfoLog(program, bufSize, length, infoLog);
  }

  public void glGetProgramInterfaceiv(int program, int programInterface, int pname, Addressable params) {
    glext_h.glGetProgramInterfaceiv(program, programInterface, pname, params);
  }

  public void glGetProgramLocalParameterIivNV(int target, int index, Addressable params) {
    glext_h.glGetProgramLocalParameterIivNV(target, index, params);
  }

  public void glGetProgramLocalParameterIuivNV(int target, int index, Addressable params) {
    glext_h.glGetProgramLocalParameterIuivNV(target, index, params);
  }

  public void glGetProgramLocalParameterdvARB(int target, int index, Addressable params) {
    glext_h.glGetProgramLocalParameterdvARB(target, index, params);
  }

  public void glGetProgramLocalParameterfvARB(int target, int index, Addressable params) {
    glext_h.glGetProgramLocalParameterfvARB(target, index, params);
  }

  public void glGetProgramNamedParameterdvNV(int id, int len, Addressable name, Addressable params) {
    glext_h.glGetProgramNamedParameterdvNV(id, len, name, params);
  }

  public void glGetProgramNamedParameterfvNV(int id, int len, Addressable name, Addressable params) {
    glext_h.glGetProgramNamedParameterfvNV(id, len, name, params);
  }

  public void glGetProgramParameterdvNV(int target, int index, int pname, Addressable params) {
    glext_h.glGetProgramParameterdvNV(target, index, pname, params);
  }

  public void glGetProgramParameterfvNV(int target, int index, int pname, Addressable params) {
    glext_h.glGetProgramParameterfvNV(target, index, pname, params);
  }

  public void glGetProgramPipelineInfoLog(int pipeline, int bufSize, Addressable length, Addressable infoLog) {
    glext_h.glGetProgramPipelineInfoLog(pipeline, bufSize, length, infoLog);
  }

  public void glGetProgramPipelineiv(int pipeline, int pname, Addressable params) {
    glext_h.glGetProgramPipelineiv(pipeline, pname, params);
  }

  public int glGetProgramResourceIndex(int program, int programInterface, Addressable name) {
    return glext_h.glGetProgramResourceIndex(program, programInterface, name);
  }

  public int glGetProgramResourceLocation(int program, int programInterface, Addressable name) {
    return glext_h.glGetProgramResourceLocation(program, programInterface, name);
  }

  public int glGetProgramResourceLocationIndex(int program, int programInterface, Addressable name) {
    return glext_h.glGetProgramResourceLocationIndex(program, programInterface, name);
  }

  public void glGetProgramResourceName(int program, int programInterface, int index, int bufSize, Addressable length, Addressable name) {
    glext_h.glGetProgramResourceName(program, programInterface, index, bufSize, length, name);
  }

  public void glGetProgramResourcefvNV(int program, int programInterface, int index, int propCount, Addressable props, int count, Addressable length, Addressable params) {
    glext_h.glGetProgramResourcefvNV(program, programInterface, index, propCount, props, count, length, params);
  }

  public void glGetProgramResourceiv(int program, int programInterface, int index, int propCount, Addressable props, int count, Addressable length, Addressable params) {
    glext_h.glGetProgramResourceiv(program, programInterface, index, propCount, props, count, length, params);
  }

  public void glGetProgramStageiv(int program, int shadertype, int pname, Addressable values) {
    glext_h.glGetProgramStageiv(program, shadertype, pname, values);
  }

  public void glGetProgramStringARB(int target, int pname, Addressable string) {
    glext_h.glGetProgramStringARB(target, pname, string);
  }

  public void glGetProgramStringNV(int id, int pname, Addressable program) {
    glext_h.glGetProgramStringNV(id, pname, program);
  }

  public void glGetProgramSubroutineParameteruivNV(int target, int index, Addressable param) {
    glext_h.glGetProgramSubroutineParameteruivNV(target, index, param);
  }

  public void glGetProgramiv(int program, int pname, Addressable params) {
    glext_h.glGetProgramiv(program, pname, params);
  }

  public void glGetProgramivARB(int target, int pname, Addressable params) {
    glext_h.glGetProgramivARB(target, pname, params);
  }

  public void glGetProgramivNV(int id, int pname, Addressable params) {
    glext_h.glGetProgramivNV(id, pname, params);
  }

  public void glGetQueryBufferObjecti64v(int id, int buffer, int pname, long offset) {
    glext_h.glGetQueryBufferObjecti64v(id, buffer, pname, offset);
  }

  public void glGetQueryBufferObjectiv(int id, int buffer, int pname, long offset) {
    glext_h.glGetQueryBufferObjectiv(id, buffer, pname, offset);
  }

  public void glGetQueryBufferObjectui64v(int id, int buffer, int pname, long offset) {
    glext_h.glGetQueryBufferObjectui64v(id, buffer, pname, offset);
  }

  public void glGetQueryBufferObjectuiv(int id, int buffer, int pname, long offset) {
    glext_h.glGetQueryBufferObjectuiv(id, buffer, pname, offset);
  }

  public void glGetQueryIndexediv(int target, int index, int pname, Addressable params) {
    glext_h.glGetQueryIndexediv(target, index, pname, params);
  }

  public void glGetQueryObjecti64v(int id, int pname, Addressable params) {
    glext_h.glGetQueryObjecti64v(id, pname, params);
  }

  public void glGetQueryObjecti64vEXT(int id, int pname, Addressable params) {
    glext_h.glGetQueryObjecti64vEXT(id, pname, params);
  }

  public void glGetQueryObjectiv(int id, int pname, Addressable params) {
    glext_h.glGetQueryObjectiv(id, pname, params);
  }

  public void glGetQueryObjectivARB(int id, int pname, Addressable params) {
    glext_h.glGetQueryObjectivARB(id, pname, params);
  }

  public void glGetQueryObjectui64v(int id, int pname, Addressable params) {
    glext_h.glGetQueryObjectui64v(id, pname, params);
  }

  public void glGetQueryObjectui64vEXT(int id, int pname, Addressable params) {
    glext_h.glGetQueryObjectui64vEXT(id, pname, params);
  }

  public void glGetQueryObjectuiv(int id, int pname, Addressable params) {
    glext_h.glGetQueryObjectuiv(id, pname, params);
  }

  public void glGetQueryObjectuivARB(int id, int pname, Addressable params) {
    glext_h.glGetQueryObjectuivARB(id, pname, params);
  }

  public void glGetQueryiv(int target, int pname, Addressable params) {
    glext_h.glGetQueryiv(target, pname, params);
  }

  public void glGetQueryivARB(int target, int pname, Addressable params) {
    glext_h.glGetQueryivARB(target, pname, params);
  }

  public void glGetRenderbufferParameteriv(int target, int pname, Addressable params) {
    glext_h.glGetRenderbufferParameteriv(target, pname, params);
  }

  public void glGetRenderbufferParameterivEXT(int target, int pname, Addressable params) {
    glext_h.glGetRenderbufferParameterivEXT(target, pname, params);
  }

  public void glGetSamplerParameterIiv(int sampler, int pname, Addressable params) {
    glext_h.glGetSamplerParameterIiv(sampler, pname, params);
  }

  public void glGetSamplerParameterIuiv(int sampler, int pname, Addressable params) {
    glext_h.glGetSamplerParameterIuiv(sampler, pname, params);
  }

  public void glGetSamplerParameterfv(int sampler, int pname, Addressable params) {
    glext_h.glGetSamplerParameterfv(sampler, pname, params);
  }

  public void glGetSamplerParameteriv(int sampler, int pname, Addressable params) {
    glext_h.glGetSamplerParameteriv(sampler, pname, params);
  }

  public void glGetSemaphoreParameterui64vEXT(int semaphore, int pname, Addressable params) {
    glext_h.glGetSemaphoreParameterui64vEXT(semaphore, pname, params);
  }

  public void glGetSeparableFilterEXT(int target, int format, int type, Addressable row, Addressable column, Addressable span) {
    glext_h.glGetSeparableFilterEXT(target, format, type, row, column, span);
  }

  public void glGetShaderInfoLog(int shader, int bufSize, Addressable length, Addressable infoLog) {
    glext_h.glGetShaderInfoLog(shader, bufSize, length, infoLog);
  }

  public void glGetShaderPrecisionFormat(int shadertype, int precisiontype, Addressable range, Addressable precision) {
    glext_h.glGetShaderPrecisionFormat(shadertype, precisiontype, range, precision);
  }

  public void glGetShaderSource(int shader, int bufSize, Addressable length, Addressable source) {
    glext_h.glGetShaderSource(shader, bufSize, length, source);
  }

  public void glGetShaderSourceARB(int obj, int maxLength, Addressable length, Addressable source) {
    glext_h.glGetShaderSourceARB(obj, maxLength, length, source);
  }

  public void glGetShaderiv(int shader, int pname, Addressable params) {
    glext_h.glGetShaderiv(shader, pname, params);
  }

  public void glGetShadingRateImagePaletteNV(int viewport, int entry, Addressable rate) {
    glext_h.glGetShadingRateImagePaletteNV(viewport, entry, rate);
  }

  public void glGetShadingRateSampleLocationivNV(int rate, int samples, int index, Addressable location) {
    glext_h.glGetShadingRateSampleLocationivNV(rate, samples, index, location);
  }

  public void glGetSharpenTexFuncSGIS(int target, Addressable points) {
    glext_h.glGetSharpenTexFuncSGIS(target, points);
  }

  public short glGetStageIndexNV(int shadertype) {
    return glext_h.glGetStageIndexNV(shadertype);
  }

  public String glGetStringi(int name, int index) {
    return glext_h.glGetStringi(name, index).getUtf8String(0);
  }

  public int glGetSubroutineIndex(int program, int shadertype, Addressable name) {
    return glext_h.glGetSubroutineIndex(program, shadertype, name);
  }

  public int glGetSubroutineUniformLocation(int program, int shadertype, Addressable name) {
    return glext_h.glGetSubroutineUniformLocation(program, shadertype, name);
  }

  public void glGetSynciv(Addressable sync, int pname, int count, Addressable length, Addressable values) {
    glext_h.glGetSynciv(sync, pname, count, length, values);
  }

  public void glGetTexBumpParameterfvATI(int pname, Addressable param) {
    glext_h.glGetTexBumpParameterfvATI(pname, param);
  }

  public void glGetTexBumpParameterivATI(int pname, Addressable param) {
    glext_h.glGetTexBumpParameterivATI(pname, param);
  }

  public void glGetTexEnvxvOES(int target, int pname, Addressable params) {
    glext_h.glGetTexEnvxvOES(target, pname, params);
  }

  public void glGetTexFilterFuncSGIS(int target, int filter, Addressable weights) {
    glext_h.glGetTexFilterFuncSGIS(target, filter, weights);
  }

  public void glGetTexGenxvOES(int coord, int pname, Addressable params) {
    glext_h.glGetTexGenxvOES(coord, pname, params);
  }

  public void glGetTexLevelParameterxvOES(int target, int level, int pname, Addressable params) {
    glext_h.glGetTexLevelParameterxvOES(target, level, pname, params);
  }

  public void glGetTexParameterIiv(int target, int pname, Addressable params) {
    glext_h.glGetTexParameterIiv(target, pname, params);
  }

  public void glGetTexParameterIivEXT(int target, int pname, Addressable params) {
    glext_h.glGetTexParameterIivEXT(target, pname, params);
  }

  public void glGetTexParameterIuiv(int target, int pname, Addressable params) {
    glext_h.glGetTexParameterIuiv(target, pname, params);
  }

  public void glGetTexParameterIuivEXT(int target, int pname, Addressable params) {
    glext_h.glGetTexParameterIuivEXT(target, pname, params);
  }

  public void glGetTexParameterPointervAPPLE(int target, int pname, Addressable params) {
    glext_h.glGetTexParameterPointervAPPLE(target, pname, params);
  }

  public void glGetTexParameterxvOES(int target, int pname, Addressable params) {
    glext_h.glGetTexParameterxvOES(target, pname, params);
  }

  public long glGetTextureHandleARB(int texture) {
    return glext_h.glGetTextureHandleARB(texture);
  }

  public long glGetTextureHandleNV(int texture) {
    return glext_h.glGetTextureHandleNV(texture);
  }

  public void glGetTextureImage(int texture, int level, int format, int type, int bufSize, Addressable pixels) {
    glext_h.glGetTextureImage(texture, level, format, type, bufSize, pixels);
  }

  public void glGetTextureImageEXT(int texture, int target, int level, int format, int type, Addressable pixels) {
    glext_h.glGetTextureImageEXT(texture, target, level, format, type, pixels);
  }

  public void glGetTextureLevelParameterfv(int texture, int level, int pname, Addressable params) {
    glext_h.glGetTextureLevelParameterfv(texture, level, pname, params);
  }

  public void glGetTextureLevelParameterfvEXT(int texture, int target, int level, int pname, Addressable params) {
    glext_h.glGetTextureLevelParameterfvEXT(texture, target, level, pname, params);
  }

  public void glGetTextureLevelParameteriv(int texture, int level, int pname, Addressable params) {
    glext_h.glGetTextureLevelParameteriv(texture, level, pname, params);
  }

  public void glGetTextureLevelParameterivEXT(int texture, int target, int level, int pname, Addressable params) {
    glext_h.glGetTextureLevelParameterivEXT(texture, target, level, pname, params);
  }

  public void glGetTextureParameterIiv(int texture, int pname, Addressable params) {
    glext_h.glGetTextureParameterIiv(texture, pname, params);
  }

  public void glGetTextureParameterIivEXT(int texture, int target, int pname, Addressable params) {
    glext_h.glGetTextureParameterIivEXT(texture, target, pname, params);
  }

  public void glGetTextureParameterIuiv(int texture, int pname, Addressable params) {
    glext_h.glGetTextureParameterIuiv(texture, pname, params);
  }

  public void glGetTextureParameterIuivEXT(int texture, int target, int pname, Addressable params) {
    glext_h.glGetTextureParameterIuivEXT(texture, target, pname, params);
  }

  public void glGetTextureParameterfv(int texture, int pname, Addressable params) {
    glext_h.glGetTextureParameterfv(texture, pname, params);
  }

  public void glGetTextureParameterfvEXT(int texture, int target, int pname, Addressable params) {
    glext_h.glGetTextureParameterfvEXT(texture, target, pname, params);
  }

  public void glGetTextureParameteriv(int texture, int pname, Addressable params) {
    glext_h.glGetTextureParameteriv(texture, pname, params);
  }

  public void glGetTextureParameterivEXT(int texture, int target, int pname, Addressable params) {
    glext_h.glGetTextureParameterivEXT(texture, target, pname, params);
  }

  public long glGetTextureSamplerHandleARB(int texture, int sampler) {
    return glext_h.glGetTextureSamplerHandleARB(texture, sampler);
  }

  public long glGetTextureSamplerHandleNV(int texture, int sampler) {
    return glext_h.glGetTextureSamplerHandleNV(texture, sampler);
  }

  public void glGetTextureSubImage(int texture, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int format, int type, int bufSize, Addressable pixels) {
    glext_h.glGetTextureSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, bufSize, pixels);
  }

  public void glGetTrackMatrixivNV(int target, int address, int pname, Addressable params) {
    glext_h.glGetTrackMatrixivNV(target, address, pname, params);
  }

  public void glGetTransformFeedbackVarying(int program, int index, int bufSize, Addressable length, Addressable size, Addressable type, Addressable name) {
    glext_h.glGetTransformFeedbackVarying(program, index, bufSize, length, size, type, name);
  }

  public void glGetTransformFeedbackVaryingEXT(int program, int index, int bufSize, Addressable length, Addressable size, Addressable type, Addressable name) {
    glext_h.glGetTransformFeedbackVaryingEXT(program, index, bufSize, length, size, type, name);
  }

  public void glGetTransformFeedbackVaryingNV(int program, int index, Addressable location) {
    glext_h.glGetTransformFeedbackVaryingNV(program, index, location);
  }

  public void glGetTransformFeedbacki64_v(int xfb, int pname, int index, Addressable param) {
    glext_h.glGetTransformFeedbacki64_v(xfb, pname, index, param);
  }

  public void glGetTransformFeedbacki_v(int xfb, int pname, int index, Addressable param) {
    glext_h.glGetTransformFeedbacki_v(xfb, pname, index, param);
  }

  public void glGetTransformFeedbackiv(int xfb, int pname, Addressable param) {
    glext_h.glGetTransformFeedbackiv(xfb, pname, param);
  }

  public int glGetUniformBlockIndex(int program, Addressable uniformBlockName) {
    return glext_h.glGetUniformBlockIndex(program, uniformBlockName);
  }

  public int glGetUniformBufferSizeEXT(int program, int location) {
    return glext_h.glGetUniformBufferSizeEXT(program, location);
  }

  public void glGetUniformIndices(int program, int uniformCount, Addressable uniformNames, Addressable uniformIndices) {
    glext_h.glGetUniformIndices(program, uniformCount, uniformNames, uniformIndices);
  }

  public int glGetUniformLocation(int program, Addressable name) {
    return glext_h.glGetUniformLocation(program, name);
  }

  public int glGetUniformLocationARB(int programObj, Addressable name) {
    return glext_h.glGetUniformLocationARB(programObj, name);
  }

  public long glGetUniformOffsetEXT(int program, int location) {
    return glext_h.glGetUniformOffsetEXT(program, location);
  }

  public void glGetUniformSubroutineuiv(int shadertype, int location, Addressable params) {
    glext_h.glGetUniformSubroutineuiv(shadertype, location, params);
  }

  public void glGetUniformdv(int program, int location, Addressable params) {
    glext_h.glGetUniformdv(program, location, params);
  }

  public void glGetUniformfv(int program, int location, Addressable params) {
    glext_h.glGetUniformfv(program, location, params);
  }

  public void glGetUniformfvARB(int programObj, int location, Addressable params) {
    glext_h.glGetUniformfvARB(programObj, location, params);
  }

  public void glGetUniformi64vARB(int program, int location, Addressable params) {
    glext_h.glGetUniformi64vARB(program, location, params);
  }

  public void glGetUniformi64vNV(int program, int location, Addressable params) {
    glext_h.glGetUniformi64vNV(program, location, params);
  }

  public void glGetUniformiv(int program, int location, Addressable params) {
    glext_h.glGetUniformiv(program, location, params);
  }

  public void glGetUniformivARB(int programObj, int location, Addressable params) {
    glext_h.glGetUniformivARB(programObj, location, params);
  }

  public void glGetUniformui64vARB(int program, int location, Addressable params) {
    glext_h.glGetUniformui64vARB(program, location, params);
  }

  public void glGetUniformui64vNV(int program, int location, Addressable params) {
    glext_h.glGetUniformui64vNV(program, location, params);
  }

  public void glGetUniformuiv(int program, int location, Addressable params) {
    glext_h.glGetUniformuiv(program, location, params);
  }

  public void glGetUniformuivEXT(int program, int location, Addressable params) {
    glext_h.glGetUniformuivEXT(program, location, params);
  }

  public void glGetUnsignedBytei_vEXT(int target, int index, Addressable data) {
    glext_h.glGetUnsignedBytei_vEXT(target, index, data);
  }

  public void glGetUnsignedBytevEXT(int pname, Addressable data) {
    glext_h.glGetUnsignedBytevEXT(pname, data);
  }

  public void glGetVariantArrayObjectfvATI(int id, int pname, Addressable params) {
    glext_h.glGetVariantArrayObjectfvATI(id, pname, params);
  }

  public void glGetVariantArrayObjectivATI(int id, int pname, Addressable params) {
    glext_h.glGetVariantArrayObjectivATI(id, pname, params);
  }

  public void glGetVariantBooleanvEXT(int id, int value, Addressable data) {
    glext_h.glGetVariantBooleanvEXT(id, value, data);
  }

  public void glGetVariantFloatvEXT(int id, int value, Addressable data) {
    glext_h.glGetVariantFloatvEXT(id, value, data);
  }

  public void glGetVariantIntegervEXT(int id, int value, Addressable data) {
    glext_h.glGetVariantIntegervEXT(id, value, data);
  }

  public void glGetVariantPointervEXT(int id, int value, Addressable data) {
    glext_h.glGetVariantPointervEXT(id, value, data);
  }

  public int glGetVaryingLocationNV(int program, Addressable name) {
    return glext_h.glGetVaryingLocationNV(program, name);
  }

  public void glGetVertexArrayIndexed64iv(int vaobj, int index, int pname, Addressable param) {
    glext_h.glGetVertexArrayIndexed64iv(vaobj, index, pname, param);
  }

  public void glGetVertexArrayIndexediv(int vaobj, int index, int pname, Addressable param) {
    glext_h.glGetVertexArrayIndexediv(vaobj, index, pname, param);
  }

  public void glGetVertexArrayIntegeri_vEXT(int vaobj, int index, int pname, Addressable param) {
    glext_h.glGetVertexArrayIntegeri_vEXT(vaobj, index, pname, param);
  }

  public void glGetVertexArrayIntegervEXT(int vaobj, int pname, Addressable param) {
    glext_h.glGetVertexArrayIntegervEXT(vaobj, pname, param);
  }

  public void glGetVertexArrayPointeri_vEXT(int vaobj, int index, int pname, Addressable param) {
    glext_h.glGetVertexArrayPointeri_vEXT(vaobj, index, pname, param);
  }

  public void glGetVertexArrayPointervEXT(int vaobj, int pname, Addressable param) {
    glext_h.glGetVertexArrayPointervEXT(vaobj, pname, param);
  }

  public void glGetVertexArrayiv(int vaobj, int pname, Addressable param) {
    glext_h.glGetVertexArrayiv(vaobj, pname, param);
  }

  public void glGetVertexAttribArrayObjectfvATI(int index, int pname, Addressable params) {
    glext_h.glGetVertexAttribArrayObjectfvATI(index, pname, params);
  }

  public void glGetVertexAttribArrayObjectivATI(int index, int pname, Addressable params) {
    glext_h.glGetVertexAttribArrayObjectivATI(index, pname, params);
  }

  public void glGetVertexAttribIiv(int index, int pname, Addressable params) {
    glext_h.glGetVertexAttribIiv(index, pname, params);
  }

  public void glGetVertexAttribIivEXT(int index, int pname, Addressable params) {
    glext_h.glGetVertexAttribIivEXT(index, pname, params);
  }

  public void glGetVertexAttribIuiv(int index, int pname, Addressable params) {
    glext_h.glGetVertexAttribIuiv(index, pname, params);
  }

  public void glGetVertexAttribIuivEXT(int index, int pname, Addressable params) {
    glext_h.glGetVertexAttribIuivEXT(index, pname, params);
  }

  public void glGetVertexAttribLdv(int index, int pname, Addressable params) {
    glext_h.glGetVertexAttribLdv(index, pname, params);
  }

  public void glGetVertexAttribLdvEXT(int index, int pname, Addressable params) {
    glext_h.glGetVertexAttribLdvEXT(index, pname, params);
  }

  public void glGetVertexAttribLi64vNV(int index, int pname, Addressable params) {
    glext_h.glGetVertexAttribLi64vNV(index, pname, params);
  }

  public void glGetVertexAttribLui64vARB(int index, int pname, Addressable params) {
    glext_h.glGetVertexAttribLui64vARB(index, pname, params);
  }

  public void glGetVertexAttribLui64vNV(int index, int pname, Addressable params) {
    glext_h.glGetVertexAttribLui64vNV(index, pname, params);
  }

  public void glGetVertexAttribPointerv(int index, int pname, Addressable pointer) {
    glext_h.glGetVertexAttribPointerv(index, pname, pointer);
  }

  public void glGetVertexAttribPointervARB(int index, int pname, Addressable pointer) {
    glext_h.glGetVertexAttribPointervARB(index, pname, pointer);
  }

  public void glGetVertexAttribPointervNV(int index, int pname, Addressable pointer) {
    glext_h.glGetVertexAttribPointervNV(index, pname, pointer);
  }

  public void glGetVertexAttribdv(int index, int pname, Addressable params) {
    glext_h.glGetVertexAttribdv(index, pname, params);
  }

  public void glGetVertexAttribdvARB(int index, int pname, Addressable params) {
    glext_h.glGetVertexAttribdvARB(index, pname, params);
  }

  public void glGetVertexAttribdvNV(int index, int pname, Addressable params) {
    glext_h.glGetVertexAttribdvNV(index, pname, params);
  }

  public void glGetVertexAttribfv(int index, int pname, Addressable params) {
    glext_h.glGetVertexAttribfv(index, pname, params);
  }

  public void glGetVertexAttribfvARB(int index, int pname, Addressable params) {
    glext_h.glGetVertexAttribfvARB(index, pname, params);
  }

  public void glGetVertexAttribfvNV(int index, int pname, Addressable params) {
    glext_h.glGetVertexAttribfvNV(index, pname, params);
  }

  public void glGetVertexAttribiv(int index, int pname, Addressable params) {
    glext_h.glGetVertexAttribiv(index, pname, params);
  }

  public void glGetVertexAttribivARB(int index, int pname, Addressable params) {
    glext_h.glGetVertexAttribivARB(index, pname, params);
  }

  public void glGetVertexAttribivNV(int index, int pname, Addressable params) {
    glext_h.glGetVertexAttribivNV(index, pname, params);
  }

  public void glGetVideoCaptureStreamdvNV(int video_capture_slot, int stream, int pname, Addressable params) {
    glext_h.glGetVideoCaptureStreamdvNV(video_capture_slot, stream, pname, params);
  }

  public void glGetVideoCaptureStreamfvNV(int video_capture_slot, int stream, int pname, Addressable params) {
    glext_h.glGetVideoCaptureStreamfvNV(video_capture_slot, stream, pname, params);
  }

  public void glGetVideoCaptureStreamivNV(int video_capture_slot, int stream, int pname, Addressable params) {
    glext_h.glGetVideoCaptureStreamivNV(video_capture_slot, stream, pname, params);
  }

  public void glGetVideoCaptureivNV(int video_capture_slot, int pname, Addressable params) {
    glext_h.glGetVideoCaptureivNV(video_capture_slot, pname, params);
  }

  public void glGetVideoi64vNV(int video_slot, int pname, Addressable params) {
    glext_h.glGetVideoi64vNV(video_slot, pname, params);
  }

  public void glGetVideoivNV(int video_slot, int pname, Addressable params) {
    glext_h.glGetVideoivNV(video_slot, pname, params);
  }

  public void glGetVideoui64vNV(int video_slot, int pname, Addressable params) {
    glext_h.glGetVideoui64vNV(video_slot, pname, params);
  }

  public void glGetVideouivNV(int video_slot, int pname, Addressable params) {
    glext_h.glGetVideouivNV(video_slot, pname, params);
  }

  public MemoryAddress glGetVkProcAddrNV(Addressable name) {
    return glext_h.glGetVkProcAddrNV(name);
  }

  public void glGetnColorTable(int target, int format, int type, int bufSize, Addressable table) {
    glext_h.glGetnColorTable(target, format, type, bufSize, table);
  }

  public void glGetnColorTableARB(int target, int format, int type, int bufSize, Addressable table) {
    glext_h.glGetnColorTableARB(target, format, type, bufSize, table);
  }

  public void glGetnCompressedTexImage(int target, int lod, int bufSize, Addressable pixels) {
    glext_h.glGetnCompressedTexImage(target, lod, bufSize, pixels);
  }

  public void glGetnCompressedTexImageARB(int target, int lod, int bufSize, Addressable img) {
    glext_h.glGetnCompressedTexImageARB(target, lod, bufSize, img);
  }

  public void glGetnConvolutionFilter(int target, int format, int type, int bufSize, Addressable image) {
    glext_h.glGetnConvolutionFilter(target, format, type, bufSize, image);
  }

  public void glGetnConvolutionFilterARB(int target, int format, int type, int bufSize, Addressable image) {
    glext_h.glGetnConvolutionFilterARB(target, format, type, bufSize, image);
  }

  public void glGetnHistogram(int target, byte reset, int format, int type, int bufSize, Addressable values) {
    glext_h.glGetnHistogram(target, reset, format, type, bufSize, values);
  }

  public void glGetnHistogramARB(int target, byte reset, int format, int type, int bufSize, Addressable values) {
    glext_h.glGetnHistogramARB(target, reset, format, type, bufSize, values);
  }

  public void glGetnMapdv(int target, int query, int bufSize, Addressable v) {
    glext_h.glGetnMapdv(target, query, bufSize, v);
  }

  public void glGetnMapdvARB(int target, int query, int bufSize, Addressable v) {
    glext_h.glGetnMapdvARB(target, query, bufSize, v);
  }

  public void glGetnMapfv(int target, int query, int bufSize, Addressable v) {
    glext_h.glGetnMapfv(target, query, bufSize, v);
  }

  public void glGetnMapfvARB(int target, int query, int bufSize, Addressable v) {
    glext_h.glGetnMapfvARB(target, query, bufSize, v);
  }

  public void glGetnMapiv(int target, int query, int bufSize, Addressable v) {
    glext_h.glGetnMapiv(target, query, bufSize, v);
  }

  public void glGetnMapivARB(int target, int query, int bufSize, Addressable v) {
    glext_h.glGetnMapivARB(target, query, bufSize, v);
  }

  public void glGetnMinmax(int target, byte reset, int format, int type, int bufSize, Addressable values) {
    glext_h.glGetnMinmax(target, reset, format, type, bufSize, values);
  }

  public void glGetnMinmaxARB(int target, byte reset, int format, int type, int bufSize, Addressable values) {
    glext_h.glGetnMinmaxARB(target, reset, format, type, bufSize, values);
  }

  public void glGetnPixelMapfv(int map, int bufSize, Addressable values) {
    glext_h.glGetnPixelMapfv(map, bufSize, values);
  }

  public void glGetnPixelMapfvARB(int map, int bufSize, Addressable values) {
    glext_h.glGetnPixelMapfvARB(map, bufSize, values);
  }

  public void glGetnPixelMapuiv(int map, int bufSize, Addressable values) {
    glext_h.glGetnPixelMapuiv(map, bufSize, values);
  }

  public void glGetnPixelMapuivARB(int map, int bufSize, Addressable values) {
    glext_h.glGetnPixelMapuivARB(map, bufSize, values);
  }

  public void glGetnPixelMapusv(int map, int bufSize, Addressable values) {
    glext_h.glGetnPixelMapusv(map, bufSize, values);
  }

  public void glGetnPixelMapusvARB(int map, int bufSize, Addressable values) {
    glext_h.glGetnPixelMapusvARB(map, bufSize, values);
  }

  public void glGetnPolygonStipple(int bufSize, Addressable pattern) {
    glext_h.glGetnPolygonStipple(bufSize, pattern);
  }

  public void glGetnPolygonStippleARB(int bufSize, Addressable pattern) {
    glext_h.glGetnPolygonStippleARB(bufSize, pattern);
  }

  public void glGetnSeparableFilter(int target, int format, int type, int rowBufSize, Addressable row, int columnBufSize, Addressable column, Addressable span) {
    glext_h.glGetnSeparableFilter(target, format, type, rowBufSize, row, columnBufSize, column, span);
  }

  public void glGetnSeparableFilterARB(int target, int format, int type, int rowBufSize, Addressable row, int columnBufSize, Addressable column, Addressable span) {
    glext_h.glGetnSeparableFilterARB(target, format, type, rowBufSize, row, columnBufSize, column, span);
  }

  public void glGetnTexImage(int target, int level, int format, int type, int bufSize, Addressable pixels) {
    glext_h.glGetnTexImage(target, level, format, type, bufSize, pixels);
  }

  public void glGetnTexImageARB(int target, int level, int format, int type, int bufSize, Addressable img) {
    glext_h.glGetnTexImageARB(target, level, format, type, bufSize, img);
  }

  public void glGetnUniformdv(int program, int location, int bufSize, Addressable params) {
    glext_h.glGetnUniformdv(program, location, bufSize, params);
  }

  public void glGetnUniformdvARB(int program, int location, int bufSize, Addressable params) {
    glext_h.glGetnUniformdvARB(program, location, bufSize, params);
  }

  public void glGetnUniformfv(int program, int location, int bufSize, Addressable params) {
    glext_h.glGetnUniformfv(program, location, bufSize, params);
  }

  public void glGetnUniformfvARB(int program, int location, int bufSize, Addressable params) {
    glext_h.glGetnUniformfvARB(program, location, bufSize, params);
  }

  public void glGetnUniformi64vARB(int program, int location, int bufSize, Addressable params) {
    glext_h.glGetnUniformi64vARB(program, location, bufSize, params);
  }

  public void glGetnUniformiv(int program, int location, int bufSize, Addressable params) {
    glext_h.glGetnUniformiv(program, location, bufSize, params);
  }

  public void glGetnUniformivARB(int program, int location, int bufSize, Addressable params) {
    glext_h.glGetnUniformivARB(program, location, bufSize, params);
  }

  public void glGetnUniformui64vARB(int program, int location, int bufSize, Addressable params) {
    glext_h.glGetnUniformui64vARB(program, location, bufSize, params);
  }

  public void glGetnUniformuiv(int program, int location, int bufSize, Addressable params) {
    glext_h.glGetnUniformuiv(program, location, bufSize, params);
  }

  public void glGetnUniformuivARB(int program, int location, int bufSize, Addressable params) {
    glext_h.glGetnUniformuivARB(program, location, bufSize, params);
  }

  public void glGlobalAlphaFactorbSUN(byte factor) {
    glext_h.glGlobalAlphaFactorbSUN(factor);
  }

  public void glGlobalAlphaFactordSUN(double factor) {
    glext_h.glGlobalAlphaFactordSUN(factor);
  }

  public void glGlobalAlphaFactorfSUN(float factor) {
    glext_h.glGlobalAlphaFactorfSUN(factor);
  }

  public void glGlobalAlphaFactoriSUN(int factor) {
    glext_h.glGlobalAlphaFactoriSUN(factor);
  }

  public void glGlobalAlphaFactorsSUN(short factor) {
    glext_h.glGlobalAlphaFactorsSUN(factor);
  }

  public void glGlobalAlphaFactorubSUN(byte factor) {
    glext_h.glGlobalAlphaFactorubSUN(factor);
  }

  public void glGlobalAlphaFactoruiSUN(int factor) {
    glext_h.glGlobalAlphaFactoruiSUN(factor);
  }

  public void glGlobalAlphaFactorusSUN(short factor) {
    glext_h.glGlobalAlphaFactorusSUN(factor);
  }

  public void glHintPGI(int target, int mode) {
    glext_h.glHintPGI(target, mode);
  }

  public void glHistogramEXT(int target, int width, int internalformat, byte sink) {
    glext_h.glHistogramEXT(target, width, internalformat, sink);
  }

  public void glIglooInterfaceSGIX(int pname, Addressable params) {
    glext_h.glIglooInterfaceSGIX(pname, params);
  }

  public void glImageTransformParameterfHP(int target, int pname, float param) {
    glext_h.glImageTransformParameterfHP(target, pname, param);
  }

  public void glImageTransformParameterfvHP(int target, int pname, Addressable params) {
    glext_h.glImageTransformParameterfvHP(target, pname, params);
  }

  public void glImageTransformParameteriHP(int target, int pname, int param) {
    glext_h.glImageTransformParameteriHP(target, pname, param);
  }

  public void glImageTransformParameterivHP(int target, int pname, Addressable params) {
    glext_h.glImageTransformParameterivHP(target, pname, params);
  }

  public void glImportMemoryFdEXT(int memory, long size, int handleType, int fd) {
    glext_h.glImportMemoryFdEXT(memory, size, handleType, fd);
  }

  public void glImportMemoryWin32HandleEXT(int memory, long size, int handleType, Addressable handle) {
    glext_h.glImportMemoryWin32HandleEXT(memory, size, handleType, handle);
  }

  public void glImportMemoryWin32NameEXT(int memory, long size, int handleType, Addressable name) {
    glext_h.glImportMemoryWin32NameEXT(memory, size, handleType, name);
  }

  public void glImportSemaphoreFdEXT(int semaphore, int handleType, int fd) {
    glext_h.glImportSemaphoreFdEXT(semaphore, handleType, fd);
  }

  public void glImportSemaphoreWin32HandleEXT(int semaphore, int handleType, Addressable handle) {
    glext_h.glImportSemaphoreWin32HandleEXT(semaphore, handleType, handle);
  }

  public void glImportSemaphoreWin32NameEXT(int semaphore, int handleType, Addressable name) {
    glext_h.glImportSemaphoreWin32NameEXT(semaphore, handleType, name);
  }

  public MemoryAddress glImportSyncEXT(int external_sync_type, long external_sync, int flags) {
    return glext_h.glImportSyncEXT(external_sync_type, external_sync, flags);
  }

  public void glIndexFormatNV(int type, int stride) {
    glext_h.glIndexFormatNV(type, stride);
  }

  public void glIndexFuncEXT(int func, float ref) {
    glext_h.glIndexFuncEXT(func, ref);
  }

  public void glIndexMaterialEXT(int face, int mode) {
    glext_h.glIndexMaterialEXT(face, mode);
  }

  public void glIndexPointerEXT(int type, int stride, int count, Addressable pointer) {
    glext_h.glIndexPointerEXT(type, stride, count, pointer);
  }

  public void glIndexPointerListIBM(int type, int stride, Addressable pointer, int ptrstride) {
    glext_h.glIndexPointerListIBM(type, stride, pointer, ptrstride);
  }

  public void glIndexxOES(int component) {
    glext_h.glIndexxOES(component);
  }

  public void glIndexxvOES(Addressable component) {
    glext_h.glIndexxvOES(component);
  }

  public void glInsertComponentEXT(int res, int src, int num) {
    glext_h.glInsertComponentEXT(res, src, num);
  }

  public void glInsertEventMarkerEXT(int length, Addressable marker) {
    glext_h.glInsertEventMarkerEXT(length, marker);
  }

  public void glInstrumentsBufferSGIX(int size, Addressable buffer) {
    glext_h.glInstrumentsBufferSGIX(size, buffer);
  }

  public void glInterpolatePathsNV(int resultPath, int pathA, int pathB, float weight) {
    glext_h.glInterpolatePathsNV(resultPath, pathA, pathB, weight);
  }

  public void glInvalidateBufferData(int buffer) {
    glext_h.glInvalidateBufferData(buffer);
  }

  public void glInvalidateBufferSubData(int buffer, long offset, long length) {
    glext_h.glInvalidateBufferSubData(buffer, offset, length);
  }

  public void glInvalidateFramebuffer(int target, int numAttachments, Addressable attachments) {
    glext_h.glInvalidateFramebuffer(target, numAttachments, attachments);
  }

  public void glInvalidateNamedFramebufferData(int framebuffer, int numAttachments, Addressable attachments) {
    glext_h.glInvalidateNamedFramebufferData(framebuffer, numAttachments, attachments);
  }

  public void glInvalidateNamedFramebufferSubData(int framebuffer, int numAttachments, Addressable attachments, int x, int y, int width, int height) {
    glext_h.glInvalidateNamedFramebufferSubData(framebuffer, numAttachments, attachments, x, y, width, height);
  }

  public void glInvalidateSubFramebuffer(int target, int numAttachments, Addressable attachments, int x, int y, int width, int height) {
    glext_h.glInvalidateSubFramebuffer(target, numAttachments, attachments, x, y, width, height);
  }

  public void glInvalidateTexImage(int texture, int level) {
    glext_h.glInvalidateTexImage(texture, level);
  }

  public void glInvalidateTexSubImage(int texture, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth) {
    glext_h.glInvalidateTexSubImage(texture, level, xoffset, yoffset, zoffset, width, height, depth);
  }

  public byte glIsAsyncMarkerSGIX(int marker) {
    return glext_h.glIsAsyncMarkerSGIX(marker);
  }

  public byte glIsBuffer(int buffer) {
    return glext_h.glIsBuffer(buffer);
  }

  public byte glIsBufferARB(int buffer) {
    return glext_h.glIsBufferARB(buffer);
  }

  public byte glIsBufferResidentNV(int target) {
    return glext_h.glIsBufferResidentNV(target);
  }

  public byte glIsCommandListNV(int list) {
    return glext_h.glIsCommandListNV(list);
  }

  public byte glIsEnabledIndexedEXT(int target, int index) {
    return glext_h.glIsEnabledIndexedEXT(target, index);
  }

  public byte glIsEnabledi(int target, int index) {
    return glext_h.glIsEnabledi(target, index);
  }

  public byte glIsFenceAPPLE(int fence) {
    return glext_h.glIsFenceAPPLE(fence);
  }

  public byte glIsFenceNV(int fence) {
    return glext_h.glIsFenceNV(fence);
  }

  public byte glIsFramebuffer(int framebuffer) {
    return glext_h.glIsFramebuffer(framebuffer);
  }

  public byte glIsFramebufferEXT(int framebuffer) {
    return glext_h.glIsFramebufferEXT(framebuffer);
  }

  public byte glIsImageHandleResidentARB(long handle) {
    return glext_h.glIsImageHandleResidentARB(handle);
  }

  public byte glIsImageHandleResidentNV(long handle) {
    return glext_h.glIsImageHandleResidentNV(handle);
  }

  public byte glIsMemoryObjectEXT(int memoryObject) {
    return glext_h.glIsMemoryObjectEXT(memoryObject);
  }

  public byte glIsNameAMD(int identifier, int name) {
    return glext_h.glIsNameAMD(identifier, name);
  }

  public byte glIsNamedBufferResidentNV(int buffer) {
    return glext_h.glIsNamedBufferResidentNV(buffer);
  }

  public byte glIsNamedStringARB(int namelen, Addressable name) {
    return glext_h.glIsNamedStringARB(namelen, name);
  }

  public byte glIsObjectBufferATI(int buffer) {
    return glext_h.glIsObjectBufferATI(buffer);
  }

  public byte glIsOcclusionQueryNV(int id) {
    return glext_h.glIsOcclusionQueryNV(id);
  }

  public byte glIsPathNV(int path) {
    return glext_h.glIsPathNV(path);
  }

  public byte glIsPointInFillPathNV(int path, int mask, float x, float y) {
    return glext_h.glIsPointInFillPathNV(path, mask, x, y);
  }

  public byte glIsPointInStrokePathNV(int path, float x, float y) {
    return glext_h.glIsPointInStrokePathNV(path, x, y);
  }

  public byte glIsProgram(int program) {
    return glext_h.glIsProgram(program);
  }

  public byte glIsProgramARB(int program) {
    return glext_h.glIsProgramARB(program);
  }

  public byte glIsProgramNV(int id) {
    return glext_h.glIsProgramNV(id);
  }

  public byte glIsProgramPipeline(int pipeline) {
    return glext_h.glIsProgramPipeline(pipeline);
  }

  public byte glIsQuery(int id) {
    return glext_h.glIsQuery(id);
  }

  public byte glIsQueryARB(int id) {
    return glext_h.glIsQueryARB(id);
  }

  public byte glIsRenderbuffer(int renderbuffer) {
    return glext_h.glIsRenderbuffer(renderbuffer);
  }

  public byte glIsRenderbufferEXT(int renderbuffer) {
    return glext_h.glIsRenderbufferEXT(renderbuffer);
  }

  public byte glIsSampler(int sampler) {
    return glext_h.glIsSampler(sampler);
  }

  public byte glIsSemaphoreEXT(int semaphore) {
    return glext_h.glIsSemaphoreEXT(semaphore);
  }

  public byte glIsShader(int shader) {
    return glext_h.glIsShader(shader);
  }

  public byte glIsStateNV(int state) {
    return glext_h.glIsStateNV(state);
  }

  public byte glIsSync(Addressable sync) {
    return glext_h.glIsSync(sync);
  }

  public byte glIsTextureEXT(int texture) {
    return glext_h.glIsTextureEXT(texture);
  }

  public byte glIsTextureHandleResidentARB(long handle) {
    return glext_h.glIsTextureHandleResidentARB(handle);
  }

  public byte glIsTextureHandleResidentNV(long handle) {
    return glext_h.glIsTextureHandleResidentNV(handle);
  }

  public byte glIsTransformFeedback(int id) {
    return glext_h.glIsTransformFeedback(id);
  }

  public byte glIsTransformFeedbackNV(int id) {
    return glext_h.glIsTransformFeedbackNV(id);
  }

  public byte glIsVariantEnabledEXT(int id, int cap) {
    return glext_h.glIsVariantEnabledEXT(id, cap);
  }

  public byte glIsVertexArray(int array) {
    return glext_h.glIsVertexArray(array);
  }

  public byte glIsVertexArrayAPPLE(int array) {
    return glext_h.glIsVertexArrayAPPLE(array);
  }

  public byte glIsVertexAttribEnabledAPPLE(int index, int pname) {
    return glext_h.glIsVertexAttribEnabledAPPLE(index, pname);
  }

  public void glLGPUCopyImageSubDataNVX(int sourceGpu, int destinationGpuMask, int srcName, int srcTarget, int srcLevel, int srcX, int srxY, int srcZ, int dstName, int dstTarget, int dstLevel, int dstX, int dstY, int dstZ, int width, int height, int depth) {
    glext_h.glLGPUCopyImageSubDataNVX(sourceGpu, destinationGpuMask, srcName, srcTarget, srcLevel, srcX, srxY, srcZ, dstName, dstTarget, dstLevel, dstX, dstY, dstZ, width, height, depth);
  }

  public void glLGPUInterlockNVX() {
    glext_h.glLGPUInterlockNVX();
  }

  public void glLGPUNamedBufferSubDataNVX(int gpuMask, int buffer, long offset, long size, Addressable data) {
    glext_h.glLGPUNamedBufferSubDataNVX(gpuMask, buffer, offset, size, data);
  }

  public void glLabelObjectEXT(int type, int object, int length, Addressable label) {
    glext_h.glLabelObjectEXT(type, object, length, label);
  }

  public void glLightEnviSGIX(int pname, int param) {
    glext_h.glLightEnviSGIX(pname, param);
  }

  public void glLightModelxOES(int pname, int param) {
    glext_h.glLightModelxOES(pname, param);
  }

  public void glLightModelxvOES(int pname, Addressable param) {
    glext_h.glLightModelxvOES(pname, param);
  }

  public void glLightxOES(int light, int pname, int param) {
    glext_h.glLightxOES(light, pname, param);
  }

  public void glLightxvOES(int light, int pname, Addressable params) {
    glext_h.glLightxvOES(light, pname, params);
  }

  public void glLineWidthxOES(int width) {
    glext_h.glLineWidthxOES(width);
  }

  public void glLinkProgram(int program) {
    glext_h.glLinkProgram(program);
  }

  public void glLinkProgramARB(int programObj) {
    glext_h.glLinkProgramARB(programObj);
  }

  public void glListDrawCommandsStatesClientNV(int list, int segment, Addressable indirects, Addressable sizes, Addressable states, Addressable fbos, int count) {
    glext_h.glListDrawCommandsStatesClientNV(list, segment, indirects, sizes, states, fbos, count);
  }

  public void glListParameterfSGIX(int list, int pname, float param) {
    glext_h.glListParameterfSGIX(list, pname, param);
  }

  public void glListParameterfvSGIX(int list, int pname, Addressable params) {
    glext_h.glListParameterfvSGIX(list, pname, params);
  }

  public void glListParameteriSGIX(int list, int pname, int param) {
    glext_h.glListParameteriSGIX(list, pname, param);
  }

  public void glListParameterivSGIX(int list, int pname, Addressable params) {
    glext_h.glListParameterivSGIX(list, pname, params);
  }

  public void glLoadIdentityDeformationMapSGIX(int mask) {
    glext_h.glLoadIdentityDeformationMapSGIX(mask);
  }

  public void glLoadMatrixxOES(Addressable m) {
    glext_h.glLoadMatrixxOES(m);
  }

  public void glLoadProgramNV(int target, int id, int len, Addressable program) {
    glext_h.glLoadProgramNV(target, id, len, program);
  }

  public void glLoadTransposeMatrixdARB(Addressable m) {
    glext_h.glLoadTransposeMatrixdARB(m);
  }

  public void glLoadTransposeMatrixfARB(Addressable m) {
    glext_h.glLoadTransposeMatrixfARB(m);
  }

  public void glLoadTransposeMatrixxOES(Addressable m) {
    glext_h.glLoadTransposeMatrixxOES(m);
  }

  public void glLockArraysEXT(int first, int count) {
    glext_h.glLockArraysEXT(first, count);
  }

  public void glMakeBufferNonResidentNV(int target) {
    glext_h.glMakeBufferNonResidentNV(target);
  }

  public void glMakeBufferResidentNV(int target, int access) {
    glext_h.glMakeBufferResidentNV(target, access);
  }

  public void glMakeImageHandleNonResidentARB(long handle) {
    glext_h.glMakeImageHandleNonResidentARB(handle);
  }

  public void glMakeImageHandleNonResidentNV(long handle) {
    glext_h.glMakeImageHandleNonResidentNV(handle);
  }

  public void glMakeImageHandleResidentARB(long handle, int access) {
    glext_h.glMakeImageHandleResidentARB(handle, access);
  }

  public void glMakeImageHandleResidentNV(long handle, int access) {
    glext_h.glMakeImageHandleResidentNV(handle, access);
  }

  public void glMakeNamedBufferNonResidentNV(int buffer) {
    glext_h.glMakeNamedBufferNonResidentNV(buffer);
  }

  public void glMakeNamedBufferResidentNV(int buffer, int access) {
    glext_h.glMakeNamedBufferResidentNV(buffer, access);
  }

  public void glMakeTextureHandleNonResidentARB(long handle) {
    glext_h.glMakeTextureHandleNonResidentARB(handle);
  }

  public void glMakeTextureHandleNonResidentNV(long handle) {
    glext_h.glMakeTextureHandleNonResidentNV(handle);
  }

  public void glMakeTextureHandleResidentARB(long handle) {
    glext_h.glMakeTextureHandleResidentARB(handle);
  }

  public void glMakeTextureHandleResidentNV(long handle) {
    glext_h.glMakeTextureHandleResidentNV(handle);
  }

  public void glMap1xOES(int target, int u1, int u2, int stride, int order, int points) {
    glext_h.glMap1xOES(target, u1, u2, stride, order, points);
  }

  public void glMap2xOES(int target, int u1, int u2, int ustride, int uorder, int v1, int v2, int vstride, int vorder, int points) {
    glext_h.glMap2xOES(target, u1, u2, ustride, uorder, v1, v2, vstride, vorder, points);
  }

  public MemoryAddress glMapBuffer(int target, int access) {
    return glext_h.glMapBuffer(target, access);
  }

  public MemoryAddress glMapBufferARB(int target, int access) {
    return glext_h.glMapBufferARB(target, access);
  }

  public MemoryAddress glMapBufferRange(int target, long offset, long length, int access) {
    return glext_h.glMapBufferRange(target, offset, length, access);
  }

  public void glMapControlPointsNV(int target, int index, int type, int ustride, int vstride, int uorder, int vorder, byte packed, Addressable points) {
    glext_h.glMapControlPointsNV(target, index, type, ustride, vstride, uorder, vorder, packed, points);
  }

  public void glMapGrid1xOES(int n, int u1, int u2) {
    glext_h.glMapGrid1xOES(n, u1, u2);
  }

  public void glMapGrid2xOES(int n, int u1, int u2, int v1, int v2) {
    glext_h.glMapGrid2xOES(n, u1, u2, v1, v2);
  }

  public MemoryAddress glMapNamedBuffer(int buffer, int access) {
    return glext_h.glMapNamedBuffer(buffer, access);
  }

  public MemoryAddress glMapNamedBufferEXT(int buffer, int access) {
    return glext_h.glMapNamedBufferEXT(buffer, access);
  }

  public MemoryAddress glMapNamedBufferRange(int buffer, long offset, long length, int access) {
    return glext_h.glMapNamedBufferRange(buffer, offset, length, access);
  }

  public MemoryAddress glMapNamedBufferRangeEXT(int buffer, long offset, long length, int access) {
    return glext_h.glMapNamedBufferRangeEXT(buffer, offset, length, access);
  }

  public MemoryAddress glMapObjectBufferATI(int buffer) {
    return glext_h.glMapObjectBufferATI(buffer);
  }

  public void glMapParameterfvNV(int target, int pname, Addressable params) {
    glext_h.glMapParameterfvNV(target, pname, params);
  }

  public void glMapParameterivNV(int target, int pname, Addressable params) {
    glext_h.glMapParameterivNV(target, pname, params);
  }

  public MemoryAddress glMapTexture2DINTEL(int texture, int level, int access, Addressable stride, Addressable layout) {
    return glext_h.glMapTexture2DINTEL(texture, level, access, stride, layout);
  }

  public void glMapVertexAttrib1dAPPLE(int index, int size, double u1, double u2, int stride, int order, Addressable points) {
    glext_h.glMapVertexAttrib1dAPPLE(index, size, u1, u2, stride, order, points);
  }

  public void glMapVertexAttrib1fAPPLE(int index, int size, float u1, float u2, int stride, int order, Addressable points) {
    glext_h.glMapVertexAttrib1fAPPLE(index, size, u1, u2, stride, order, points);
  }

  public void glMapVertexAttrib2dAPPLE(int index, int size, double u1, double u2, int ustride, int uorder, double v1, double v2, int vstride, int vorder, Addressable points) {
    glext_h.glMapVertexAttrib2dAPPLE(index, size, u1, u2, ustride, uorder, v1, v2, vstride, vorder, points);
  }

  public void glMapVertexAttrib2fAPPLE(int index, int size, float u1, float u2, int ustride, int uorder, float v1, float v2, int vstride, int vorder, Addressable points) {
    glext_h.glMapVertexAttrib2fAPPLE(index, size, u1, u2, ustride, uorder, v1, v2, vstride, vorder, points);
  }

  public void glMaterialxOES(int face, int pname, int param) {
    glext_h.glMaterialxOES(face, pname, param);
  }

  public void glMaterialxvOES(int face, int pname, Addressable param) {
    glext_h.glMaterialxvOES(face, pname, param);
  }

  public void glMatrixFrustumEXT(int mode, double left, double right, double bottom, double top, double zNear, double zFar) {
    glext_h.glMatrixFrustumEXT(mode, left, right, bottom, top, zNear, zFar);
  }

  public void glMatrixIndexPointerARB(int size, int type, int stride, Addressable pointer) {
    glext_h.glMatrixIndexPointerARB(size, type, stride, pointer);
  }

  public void glMatrixIndexubvARB(int size, Addressable indices) {
    glext_h.glMatrixIndexubvARB(size, indices);
  }

  public void glMatrixIndexuivARB(int size, Addressable indices) {
    glext_h.glMatrixIndexuivARB(size, indices);
  }

  public void glMatrixIndexusvARB(int size, Addressable indices) {
    glext_h.glMatrixIndexusvARB(size, indices);
  }

  public void glMatrixLoad3x2fNV(int matrixMode, Addressable m) {
    glext_h.glMatrixLoad3x2fNV(matrixMode, m);
  }

  public void glMatrixLoad3x3fNV(int matrixMode, Addressable m) {
    glext_h.glMatrixLoad3x3fNV(matrixMode, m);
  }

  public void glMatrixLoadIdentityEXT(int mode) {
    glext_h.glMatrixLoadIdentityEXT(mode);
  }

  public void glMatrixLoadTranspose3x3fNV(int matrixMode, Addressable m) {
    glext_h.glMatrixLoadTranspose3x3fNV(matrixMode, m);
  }

  public void glMatrixLoadTransposedEXT(int mode, Addressable m) {
    glext_h.glMatrixLoadTransposedEXT(mode, m);
  }

  public void glMatrixLoadTransposefEXT(int mode, Addressable m) {
    glext_h.glMatrixLoadTransposefEXT(mode, m);
  }

  public void glMatrixLoaddEXT(int mode, Addressable m) {
    glext_h.glMatrixLoaddEXT(mode, m);
  }

  public void glMatrixLoadfEXT(int mode, Addressable m) {
    glext_h.glMatrixLoadfEXT(mode, m);
  }

  public void glMatrixMult3x2fNV(int matrixMode, Addressable m) {
    glext_h.glMatrixMult3x2fNV(matrixMode, m);
  }

  public void glMatrixMult3x3fNV(int matrixMode, Addressable m) {
    glext_h.glMatrixMult3x3fNV(matrixMode, m);
  }

  public void glMatrixMultTranspose3x3fNV(int matrixMode, Addressable m) {
    glext_h.glMatrixMultTranspose3x3fNV(matrixMode, m);
  }

  public void glMatrixMultTransposedEXT(int mode, Addressable m) {
    glext_h.glMatrixMultTransposedEXT(mode, m);
  }

  public void glMatrixMultTransposefEXT(int mode, Addressable m) {
    glext_h.glMatrixMultTransposefEXT(mode, m);
  }

  public void glMatrixMultdEXT(int mode, Addressable m) {
    glext_h.glMatrixMultdEXT(mode, m);
  }

  public void glMatrixMultfEXT(int mode, Addressable m) {
    glext_h.glMatrixMultfEXT(mode, m);
  }

  public void glMatrixOrthoEXT(int mode, double left, double right, double bottom, double top, double zNear, double zFar) {
    glext_h.glMatrixOrthoEXT(mode, left, right, bottom, top, zNear, zFar);
  }

  public void glMatrixPopEXT(int mode) {
    glext_h.glMatrixPopEXT(mode);
  }

  public void glMatrixPushEXT(int mode) {
    glext_h.glMatrixPushEXT(mode);
  }

  public void glMatrixRotatedEXT(int mode, double angle, double x, double y, double z) {
    glext_h.glMatrixRotatedEXT(mode, angle, x, y, z);
  }

  public void glMatrixRotatefEXT(int mode, float angle, float x, float y, float z) {
    glext_h.glMatrixRotatefEXT(mode, angle, x, y, z);
  }

  public void glMatrixScaledEXT(int mode, double x, double y, double z) {
    glext_h.glMatrixScaledEXT(mode, x, y, z);
  }

  public void glMatrixScalefEXT(int mode, float x, float y, float z) {
    glext_h.glMatrixScalefEXT(mode, x, y, z);
  }

  public void glMatrixTranslatedEXT(int mode, double x, double y, double z) {
    glext_h.glMatrixTranslatedEXT(mode, x, y, z);
  }

  public void glMatrixTranslatefEXT(int mode, float x, float y, float z) {
    glext_h.glMatrixTranslatefEXT(mode, x, y, z);
  }

  public void glMaxShaderCompilerThreadsARB(int count) {
    glext_h.glMaxShaderCompilerThreadsARB(count);
  }

  public void glMaxShaderCompilerThreadsKHR(int count) {
    glext_h.glMaxShaderCompilerThreadsKHR(count);
  }

  public void glMemoryBarrier(int barriers) {
    glext_h.glMemoryBarrier(barriers);
  }

  public void glMemoryBarrierByRegion(int barriers) {
    glext_h.glMemoryBarrierByRegion(barriers);
  }

  public void glMemoryBarrierEXT(int barriers) {
    glext_h.glMemoryBarrierEXT(barriers);
  }

  public void glMemoryObjectParameterivEXT(int memoryObject, int pname, Addressable params) {
    glext_h.glMemoryObjectParameterivEXT(memoryObject, pname, params);
  }

  public void glMinSampleShading(float value) {
    glext_h.glMinSampleShading(value);
  }

  public void glMinSampleShadingARB(float value) {
    glext_h.glMinSampleShadingARB(value);
  }

  public void glMinmaxEXT(int target, int internalformat, byte sink) {
    glext_h.glMinmaxEXT(target, internalformat, sink);
  }

  public void glMultMatrixxOES(Addressable m) {
    glext_h.glMultMatrixxOES(m);
  }

  public void glMultTransposeMatrixdARB(Addressable m) {
    glext_h.glMultTransposeMatrixdARB(m);
  }

  public void glMultTransposeMatrixfARB(Addressable m) {
    glext_h.glMultTransposeMatrixfARB(m);
  }

  public void glMultTransposeMatrixxOES(Addressable m) {
    glext_h.glMultTransposeMatrixxOES(m);
  }

  public void glMultiDrawArrays(int mode, Addressable first, Addressable count, int drawcount) {
    glext_h.glMultiDrawArrays(mode, first, count, drawcount);
  }

  public void glMultiDrawArraysEXT(int mode, Addressable first, Addressable count, int primcount) {
    glext_h.glMultiDrawArraysEXT(mode, first, count, primcount);
  }

  public void glMultiDrawArraysIndirect(int mode, Addressable indirect, int drawcount, int stride) {
    glext_h.glMultiDrawArraysIndirect(mode, indirect, drawcount, stride);
  }

  public void glMultiDrawArraysIndirectAMD(int mode, Addressable indirect, int primcount, int stride) {
    glext_h.glMultiDrawArraysIndirectAMD(mode, indirect, primcount, stride);
  }

  public void glMultiDrawArraysIndirectBindlessCountNV(int mode, Addressable indirect, int drawCount, int maxDrawCount, int stride, int vertexBufferCount) {
    glext_h.glMultiDrawArraysIndirectBindlessCountNV(mode, indirect, drawCount, maxDrawCount, stride, vertexBufferCount);
  }

  public void glMultiDrawArraysIndirectBindlessNV(int mode, Addressable indirect, int drawCount, int stride, int vertexBufferCount) {
    glext_h.glMultiDrawArraysIndirectBindlessNV(mode, indirect, drawCount, stride, vertexBufferCount);
  }

  public void glMultiDrawArraysIndirectCount(int mode, Addressable indirect, long drawcount, int maxdrawcount, int stride) {
    glext_h.glMultiDrawArraysIndirectCount(mode, indirect, drawcount, maxdrawcount, stride);
  }

  public void glMultiDrawArraysIndirectCountARB(int mode, Addressable indirect, long drawcount, int maxdrawcount, int stride) {
    glext_h.glMultiDrawArraysIndirectCountARB(mode, indirect, drawcount, maxdrawcount, stride);
  }

  public void glMultiDrawElementArrayAPPLE(int mode, Addressable first, Addressable count, int primcount) {
    glext_h.glMultiDrawElementArrayAPPLE(mode, first, count, primcount);
  }

  public void glMultiDrawElements(int mode, Addressable count, int type, Addressable indices, int drawcount) {
    glext_h.glMultiDrawElements(mode, count, type, indices, drawcount);
  }

  public void glMultiDrawElementsBaseVertex(int mode, Addressable count, int type, Addressable indices, int drawcount, Addressable basevertex) {
    glext_h.glMultiDrawElementsBaseVertex(mode, count, type, indices, drawcount, basevertex);
  }

  public void glMultiDrawElementsEXT(int mode, Addressable count, int type, Addressable indices, int primcount) {
    glext_h.glMultiDrawElementsEXT(mode, count, type, indices, primcount);
  }

  public void glMultiDrawElementsIndirect(int mode, int type, Addressable indirect, int drawcount, int stride) {
    glext_h.glMultiDrawElementsIndirect(mode, type, indirect, drawcount, stride);
  }

  public void glMultiDrawElementsIndirectAMD(int mode, int type, Addressable indirect, int primcount, int stride) {
    glext_h.glMultiDrawElementsIndirectAMD(mode, type, indirect, primcount, stride);
  }

  public void glMultiDrawElementsIndirectBindlessCountNV(int mode, int type, Addressable indirect, int drawCount, int maxDrawCount, int stride, int vertexBufferCount) {
    glext_h.glMultiDrawElementsIndirectBindlessCountNV(mode, type, indirect, drawCount, maxDrawCount, stride, vertexBufferCount);
  }

  public void glMultiDrawElementsIndirectBindlessNV(int mode, int type, Addressable indirect, int drawCount, int stride, int vertexBufferCount) {
    glext_h.glMultiDrawElementsIndirectBindlessNV(mode, type, indirect, drawCount, stride, vertexBufferCount);
  }

  public void glMultiDrawElementsIndirectCount(int mode, int type, Addressable indirect, long drawcount, int maxdrawcount, int stride) {
    glext_h.glMultiDrawElementsIndirectCount(mode, type, indirect, drawcount, maxdrawcount, stride);
  }

  public void glMultiDrawElementsIndirectCountARB(int mode, int type, Addressable indirect, long drawcount, int maxdrawcount, int stride) {
    glext_h.glMultiDrawElementsIndirectCountARB(mode, type, indirect, drawcount, maxdrawcount, stride);
  }

  public void glMultiDrawMeshTasksIndirectCountNV(long indirect, long drawcount, int maxdrawcount, int stride) {
    glext_h.glMultiDrawMeshTasksIndirectCountNV(indirect, drawcount, maxdrawcount, stride);
  }

  public void glMultiDrawMeshTasksIndirectNV(long indirect, int drawcount, int stride) {
    glext_h.glMultiDrawMeshTasksIndirectNV(indirect, drawcount, stride);
  }

  public void glMultiDrawRangeElementArrayAPPLE(int mode, int start, int end, Addressable first, Addressable count, int primcount) {
    glext_h.glMultiDrawRangeElementArrayAPPLE(mode, start, end, first, count, primcount);
  }

  public void glMultiModeDrawArraysIBM(Addressable mode, Addressable first, Addressable count, int primcount, int modestride) {
    glext_h.glMultiModeDrawArraysIBM(mode, first, count, primcount, modestride);
  }

  public void glMultiModeDrawElementsIBM(Addressable mode, Addressable count, int type, Addressable indices, int primcount, int modestride) {
    glext_h.glMultiModeDrawElementsIBM(mode, count, type, indices, primcount, modestride);
  }

  public void glMultiTexBufferEXT(int texunit, int target, int internalformat, int buffer) {
    glext_h.glMultiTexBufferEXT(texunit, target, internalformat, buffer);
  }

  public void glMultiTexCoord1bOES(int texture, byte s) {
    glext_h.glMultiTexCoord1bOES(texture, s);
  }

  public void glMultiTexCoord1bvOES(int texture, Addressable coords) {
    glext_h.glMultiTexCoord1bvOES(texture, coords);
  }

  public void glMultiTexCoord1hNV(int target, short s) {
    glext_h.glMultiTexCoord1hNV(target, s);
  }

  public void glMultiTexCoord1hvNV(int target, Addressable v) {
    glext_h.glMultiTexCoord1hvNV(target, v);
  }

  public void glMultiTexCoord1xOES(int texture, int s) {
    glext_h.glMultiTexCoord1xOES(texture, s);
  }

  public void glMultiTexCoord1xvOES(int texture, Addressable coords) {
    glext_h.glMultiTexCoord1xvOES(texture, coords);
  }

  public void glMultiTexCoord2bOES(int texture, byte s, byte t) {
    glext_h.glMultiTexCoord2bOES(texture, s, t);
  }

  public void glMultiTexCoord2bvOES(int texture, Addressable coords) {
    glext_h.glMultiTexCoord2bvOES(texture, coords);
  }

  public void glMultiTexCoord2hNV(int target, short s, short t) {
    glext_h.glMultiTexCoord2hNV(target, s, t);
  }

  public void glMultiTexCoord2hvNV(int target, Addressable v) {
    glext_h.glMultiTexCoord2hvNV(target, v);
  }

  public void glMultiTexCoord2xOES(int texture, int s, int t) {
    glext_h.glMultiTexCoord2xOES(texture, s, t);
  }

  public void glMultiTexCoord2xvOES(int texture, Addressable coords) {
    glext_h.glMultiTexCoord2xvOES(texture, coords);
  }

  public void glMultiTexCoord3bOES(int texture, byte s, byte t, byte r) {
    glext_h.glMultiTexCoord3bOES(texture, s, t, r);
  }

  public void glMultiTexCoord3bvOES(int texture, Addressable coords) {
    glext_h.glMultiTexCoord3bvOES(texture, coords);
  }

  public void glMultiTexCoord3hNV(int target, short s, short t, short r) {
    glext_h.glMultiTexCoord3hNV(target, s, t, r);
  }

  public void glMultiTexCoord3hvNV(int target, Addressable v) {
    glext_h.glMultiTexCoord3hvNV(target, v);
  }

  public void glMultiTexCoord3xOES(int texture, int s, int t, int r) {
    glext_h.glMultiTexCoord3xOES(texture, s, t, r);
  }

  public void glMultiTexCoord3xvOES(int texture, Addressable coords) {
    glext_h.glMultiTexCoord3xvOES(texture, coords);
  }

  public void glMultiTexCoord4bOES(int texture, byte s, byte t, byte r, byte q) {
    glext_h.glMultiTexCoord4bOES(texture, s, t, r, q);
  }

  public void glMultiTexCoord4bvOES(int texture, Addressable coords) {
    glext_h.glMultiTexCoord4bvOES(texture, coords);
  }

  public void glMultiTexCoord4hNV(int target, short s, short t, short r, short q) {
    glext_h.glMultiTexCoord4hNV(target, s, t, r, q);
  }

  public void glMultiTexCoord4hvNV(int target, Addressable v) {
    glext_h.glMultiTexCoord4hvNV(target, v);
  }

  public void glMultiTexCoord4xOES(int texture, int s, int t, int r, int q) {
    glext_h.glMultiTexCoord4xOES(texture, s, t, r, q);
  }

  public void glMultiTexCoord4xvOES(int texture, Addressable coords) {
    glext_h.glMultiTexCoord4xvOES(texture, coords);
  }

  public void glMultiTexCoordP1ui(int texture, int type, int coords) {
    glext_h.glMultiTexCoordP1ui(texture, type, coords);
  }

  public void glMultiTexCoordP1uiv(int texture, int type, Addressable coords) {
    glext_h.glMultiTexCoordP1uiv(texture, type, coords);
  }

  public void glMultiTexCoordP2ui(int texture, int type, int coords) {
    glext_h.glMultiTexCoordP2ui(texture, type, coords);
  }

  public void glMultiTexCoordP2uiv(int texture, int type, Addressable coords) {
    glext_h.glMultiTexCoordP2uiv(texture, type, coords);
  }

  public void glMultiTexCoordP3ui(int texture, int type, int coords) {
    glext_h.glMultiTexCoordP3ui(texture, type, coords);
  }

  public void glMultiTexCoordP3uiv(int texture, int type, Addressable coords) {
    glext_h.glMultiTexCoordP3uiv(texture, type, coords);
  }

  public void glMultiTexCoordP4ui(int texture, int type, int coords) {
    glext_h.glMultiTexCoordP4ui(texture, type, coords);
  }

  public void glMultiTexCoordP4uiv(int texture, int type, Addressable coords) {
    glext_h.glMultiTexCoordP4uiv(texture, type, coords);
  }

  public void glMultiTexCoordPointerEXT(int texunit, int size, int type, int stride, Addressable pointer) {
    glext_h.glMultiTexCoordPointerEXT(texunit, size, type, stride, pointer);
  }

  public void glMultiTexEnvfEXT(int texunit, int target, int pname, float param) {
    glext_h.glMultiTexEnvfEXT(texunit, target, pname, param);
  }

  public void glMultiTexEnvfvEXT(int texunit, int target, int pname, Addressable params) {
    glext_h.glMultiTexEnvfvEXT(texunit, target, pname, params);
  }

  public void glMultiTexEnviEXT(int texunit, int target, int pname, int param) {
    glext_h.glMultiTexEnviEXT(texunit, target, pname, param);
  }

  public void glMultiTexEnvivEXT(int texunit, int target, int pname, Addressable params) {
    glext_h.glMultiTexEnvivEXT(texunit, target, pname, params);
  }

  public void glMultiTexGendEXT(int texunit, int coord, int pname, double param) {
    glext_h.glMultiTexGendEXT(texunit, coord, pname, param);
  }

  public void glMultiTexGendvEXT(int texunit, int coord, int pname, Addressable params) {
    glext_h.glMultiTexGendvEXT(texunit, coord, pname, params);
  }

  public void glMultiTexGenfEXT(int texunit, int coord, int pname, float param) {
    glext_h.glMultiTexGenfEXT(texunit, coord, pname, param);
  }

  public void glMultiTexGenfvEXT(int texunit, int coord, int pname, Addressable params) {
    glext_h.glMultiTexGenfvEXT(texunit, coord, pname, params);
  }

  public void glMultiTexGeniEXT(int texunit, int coord, int pname, int param) {
    glext_h.glMultiTexGeniEXT(texunit, coord, pname, param);
  }

  public void glMultiTexGenivEXT(int texunit, int coord, int pname, Addressable params) {
    glext_h.glMultiTexGenivEXT(texunit, coord, pname, params);
  }

  public void glMultiTexImage1DEXT(int texunit, int target, int level, int internalformat, int width, int border, int format, int type, Addressable pixels) {
    glext_h.glMultiTexImage1DEXT(texunit, target, level, internalformat, width, border, format, type, pixels);
  }

  public void glMultiTexImage2DEXT(int texunit, int target, int level, int internalformat, int width, int height, int border, int format, int type, Addressable pixels) {
    glext_h.glMultiTexImage2DEXT(texunit, target, level, internalformat, width, height, border, format, type, pixels);
  }

  public void glMultiTexImage3DEXT(int texunit, int target, int level, int internalformat, int width, int height, int depth, int border, int format, int type, Addressable pixels) {
    glext_h.glMultiTexImage3DEXT(texunit, target, level, internalformat, width, height, depth, border, format, type, pixels);
  }

  public void glMultiTexParameterIivEXT(int texunit, int target, int pname, Addressable params) {
    glext_h.glMultiTexParameterIivEXT(texunit, target, pname, params);
  }

  public void glMultiTexParameterIuivEXT(int texunit, int target, int pname, Addressable params) {
    glext_h.glMultiTexParameterIuivEXT(texunit, target, pname, params);
  }

  public void glMultiTexParameterfEXT(int texunit, int target, int pname, float param) {
    glext_h.glMultiTexParameterfEXT(texunit, target, pname, param);
  }

  public void glMultiTexParameterfvEXT(int texunit, int target, int pname, Addressable params) {
    glext_h.glMultiTexParameterfvEXT(texunit, target, pname, params);
  }

  public void glMultiTexParameteriEXT(int texunit, int target, int pname, int param) {
    glext_h.glMultiTexParameteriEXT(texunit, target, pname, param);
  }

  public void glMultiTexParameterivEXT(int texunit, int target, int pname, Addressable params) {
    glext_h.glMultiTexParameterivEXT(texunit, target, pname, params);
  }

  public void glMultiTexRenderbufferEXT(int texunit, int target, int renderbuffer) {
    glext_h.glMultiTexRenderbufferEXT(texunit, target, renderbuffer);
  }

  public void glMultiTexSubImage1DEXT(int texunit, int target, int level, int xoffset, int width, int format, int type, Addressable pixels) {
    glext_h.glMultiTexSubImage1DEXT(texunit, target, level, xoffset, width, format, type, pixels);
  }

  public void glMultiTexSubImage2DEXT(int texunit, int target, int level, int xoffset, int yoffset, int width, int height, int format, int type, Addressable pixels) {
    glext_h.glMultiTexSubImage2DEXT(texunit, target, level, xoffset, yoffset, width, height, format, type, pixels);
  }

  public void glMultiTexSubImage3DEXT(int texunit, int target, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int format, int type, Addressable pixels) {
    glext_h.glMultiTexSubImage3DEXT(texunit, target, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels);
  }

  public void glMulticastBarrierNV() {
    glext_h.glMulticastBarrierNV();
  }

  public void glMulticastBlitFramebufferNV(int srcGpu, int dstGpu, int srcX0, int srcY0, int srcX1, int srcY1, int dstX0, int dstY0, int dstX1, int dstY1, int mask, int filter) {
    glext_h.glMulticastBlitFramebufferNV(srcGpu, dstGpu, srcX0, srcY0, srcX1, srcY1, dstX0, dstY0, dstX1, dstY1, mask, filter);
  }

  public void glMulticastBufferSubDataNV(int gpuMask, int buffer, long offset, long size, Addressable data) {
    glext_h.glMulticastBufferSubDataNV(gpuMask, buffer, offset, size, data);
  }

  public void glMulticastCopyBufferSubDataNV(int readGpu, int writeGpuMask, int readBuffer, int writeBuffer, long readOffset, long writeOffset, long size) {
    glext_h.glMulticastCopyBufferSubDataNV(readGpu, writeGpuMask, readBuffer, writeBuffer, readOffset, writeOffset, size);
  }

  public void glMulticastCopyImageSubDataNV(int srcGpu, int dstGpuMask, int srcName, int srcTarget, int srcLevel, int srcX, int srcY, int srcZ, int dstName, int dstTarget, int dstLevel, int dstX, int dstY, int dstZ, int srcWidth, int srcHeight, int srcDepth) {
    glext_h.glMulticastCopyImageSubDataNV(srcGpu, dstGpuMask, srcName, srcTarget, srcLevel, srcX, srcY, srcZ, dstName, dstTarget, dstLevel, dstX, dstY, dstZ, srcWidth, srcHeight, srcDepth);
  }

  public void glMulticastFramebufferSampleLocationsfvNV(int gpu, int framebuffer, int start, int count, Addressable v) {
    glext_h.glMulticastFramebufferSampleLocationsfvNV(gpu, framebuffer, start, count, v);
  }

  public void glMulticastGetQueryObjecti64vNV(int gpu, int id, int pname, Addressable params) {
    glext_h.glMulticastGetQueryObjecti64vNV(gpu, id, pname, params);
  }

  public void glMulticastGetQueryObjectivNV(int gpu, int id, int pname, Addressable params) {
    glext_h.glMulticastGetQueryObjectivNV(gpu, id, pname, params);
  }

  public void glMulticastGetQueryObjectui64vNV(int gpu, int id, int pname, Addressable params) {
    glext_h.glMulticastGetQueryObjectui64vNV(gpu, id, pname, params);
  }

  public void glMulticastGetQueryObjectuivNV(int gpu, int id, int pname, Addressable params) {
    glext_h.glMulticastGetQueryObjectuivNV(gpu, id, pname, params);
  }

  public void glMulticastScissorArrayvNVX(int gpu, int first, int count, Addressable v) {
    glext_h.glMulticastScissorArrayvNVX(gpu, first, count, v);
  }

  public void glMulticastViewportArrayvNVX(int gpu, int first, int count, Addressable v) {
    glext_h.glMulticastViewportArrayvNVX(gpu, first, count, v);
  }

  public void glMulticastViewportPositionWScaleNVX(int gpu, int index, float xcoeff, float ycoeff) {
    glext_h.glMulticastViewportPositionWScaleNVX(gpu, index, xcoeff, ycoeff);
  }

  public void glMulticastWaitSyncNV(int signalGpu, int waitGpuMask) {
    glext_h.glMulticastWaitSyncNV(signalGpu, waitGpuMask);
  }

  public void glNamedBufferAttachMemoryNV(int buffer, int memory, long offset) {
    glext_h.glNamedBufferAttachMemoryNV(buffer, memory, offset);
  }

  public void glNamedBufferData(int buffer, long size, Addressable data, int usage) {
    glext_h.glNamedBufferData(buffer, size, data, usage);
  }

  public void glNamedBufferDataEXT(int buffer, long size, Addressable data, int usage) {
    glext_h.glNamedBufferDataEXT(buffer, size, data, usage);
  }

  public void glNamedBufferPageCommitmentARB(int buffer, long offset, long size, byte commit) {
    glext_h.glNamedBufferPageCommitmentARB(buffer, offset, size, commit);
  }

  public void glNamedBufferPageCommitmentEXT(int buffer, long offset, long size, byte commit) {
    glext_h.glNamedBufferPageCommitmentEXT(buffer, offset, size, commit);
  }

  public void glNamedBufferStorage(int buffer, long size, Addressable data, int flags) {
    glext_h.glNamedBufferStorage(buffer, size, data, flags);
  }

  public void glNamedBufferStorageEXT(int buffer, long size, Addressable data, int flags) {
    glext_h.glNamedBufferStorageEXT(buffer, size, data, flags);
  }

  public void glNamedBufferStorageExternalEXT(int buffer, long offset, long size, Addressable clientBuffer, int flags) {
    glext_h.glNamedBufferStorageExternalEXT(buffer, offset, size, clientBuffer, flags);
  }

  public void glNamedBufferStorageMemEXT(int buffer, long size, int memory, long offset) {
    glext_h.glNamedBufferStorageMemEXT(buffer, size, memory, offset);
  }

  public void glNamedBufferSubData(int buffer, long offset, long size, Addressable data) {
    glext_h.glNamedBufferSubData(buffer, offset, size, data);
  }

  public void glNamedBufferSubDataEXT(int buffer, long offset, long size, Addressable data) {
    glext_h.glNamedBufferSubDataEXT(buffer, offset, size, data);
  }

  public void glNamedCopyBufferSubDataEXT(int readBuffer, int writeBuffer, long readOffset, long writeOffset, long size) {
    glext_h.glNamedCopyBufferSubDataEXT(readBuffer, writeBuffer, readOffset, writeOffset, size);
  }

  public void glNamedFramebufferDrawBuffer(int framebuffer, int buf) {
    glext_h.glNamedFramebufferDrawBuffer(framebuffer, buf);
  }

  public void glNamedFramebufferDrawBuffers(int framebuffer, int n, Addressable bufs) {
    glext_h.glNamedFramebufferDrawBuffers(framebuffer, n, bufs);
  }

  public void glNamedFramebufferParameteri(int framebuffer, int pname, int param) {
    glext_h.glNamedFramebufferParameteri(framebuffer, pname, param);
  }

  public void glNamedFramebufferParameteriEXT(int framebuffer, int pname, int param) {
    glext_h.glNamedFramebufferParameteriEXT(framebuffer, pname, param);
  }

  public void glNamedFramebufferReadBuffer(int framebuffer, int src) {
    glext_h.glNamedFramebufferReadBuffer(framebuffer, src);
  }

  public void glNamedFramebufferRenderbuffer(int framebuffer, int attachment, int renderbuffertarget, int renderbuffer) {
    glext_h.glNamedFramebufferRenderbuffer(framebuffer, attachment, renderbuffertarget, renderbuffer);
  }

  public void glNamedFramebufferRenderbufferEXT(int framebuffer, int attachment, int renderbuffertarget, int renderbuffer) {
    glext_h.glNamedFramebufferRenderbufferEXT(framebuffer, attachment, renderbuffertarget, renderbuffer);
  }

  public void glNamedFramebufferSampleLocationsfvARB(int framebuffer, int start, int count, Addressable v) {
    glext_h.glNamedFramebufferSampleLocationsfvARB(framebuffer, start, count, v);
  }

  public void glNamedFramebufferSampleLocationsfvNV(int framebuffer, int start, int count, Addressable v) {
    glext_h.glNamedFramebufferSampleLocationsfvNV(framebuffer, start, count, v);
  }

  public void glNamedFramebufferSamplePositionsfvAMD(int framebuffer, int numsamples, int pixelindex, Addressable values) {
    glext_h.glNamedFramebufferSamplePositionsfvAMD(framebuffer, numsamples, pixelindex, values);
  }

  public void glNamedFramebufferTexture(int framebuffer, int attachment, int texture, int level) {
    glext_h.glNamedFramebufferTexture(framebuffer, attachment, texture, level);
  }

  public void glNamedFramebufferTexture1DEXT(int framebuffer, int attachment, int textarget, int texture, int level) {
    glext_h.glNamedFramebufferTexture1DEXT(framebuffer, attachment, textarget, texture, level);
  }

  public void glNamedFramebufferTexture2DEXT(int framebuffer, int attachment, int textarget, int texture, int level) {
    glext_h.glNamedFramebufferTexture2DEXT(framebuffer, attachment, textarget, texture, level);
  }

  public void glNamedFramebufferTexture3DEXT(int framebuffer, int attachment, int textarget, int texture, int level, int zoffset) {
    glext_h.glNamedFramebufferTexture3DEXT(framebuffer, attachment, textarget, texture, level, zoffset);
  }

  public void glNamedFramebufferTextureEXT(int framebuffer, int attachment, int texture, int level) {
    glext_h.glNamedFramebufferTextureEXT(framebuffer, attachment, texture, level);
  }

  public void glNamedFramebufferTextureFaceEXT(int framebuffer, int attachment, int texture, int level, int face) {
    glext_h.glNamedFramebufferTextureFaceEXT(framebuffer, attachment, texture, level, face);
  }

  public void glNamedFramebufferTextureLayer(int framebuffer, int attachment, int texture, int level, int layer) {
    glext_h.glNamedFramebufferTextureLayer(framebuffer, attachment, texture, level, layer);
  }

  public void glNamedFramebufferTextureLayerEXT(int framebuffer, int attachment, int texture, int level, int layer) {
    glext_h.glNamedFramebufferTextureLayerEXT(framebuffer, attachment, texture, level, layer);
  }

  public void glNamedProgramLocalParameter4dEXT(int program, int target, int index, double x, double y, double z, double w) {
    glext_h.glNamedProgramLocalParameter4dEXT(program, target, index, x, y, z, w);
  }

  public void glNamedProgramLocalParameter4dvEXT(int program, int target, int index, Addressable params) {
    glext_h.glNamedProgramLocalParameter4dvEXT(program, target, index, params);
  }

  public void glNamedProgramLocalParameter4fEXT(int program, int target, int index, float x, float y, float z, float w) {
    glext_h.glNamedProgramLocalParameter4fEXT(program, target, index, x, y, z, w);
  }

  public void glNamedProgramLocalParameter4fvEXT(int program, int target, int index, Addressable params) {
    glext_h.glNamedProgramLocalParameter4fvEXT(program, target, index, params);
  }

  public void glNamedProgramLocalParameterI4iEXT(int program, int target, int index, int x, int y, int z, int w) {
    glext_h.glNamedProgramLocalParameterI4iEXT(program, target, index, x, y, z, w);
  }

  public void glNamedProgramLocalParameterI4ivEXT(int program, int target, int index, Addressable params) {
    glext_h.glNamedProgramLocalParameterI4ivEXT(program, target, index, params);
  }

  public void glNamedProgramLocalParameterI4uiEXT(int program, int target, int index, int x, int y, int z, int w) {
    glext_h.glNamedProgramLocalParameterI4uiEXT(program, target, index, x, y, z, w);
  }

  public void glNamedProgramLocalParameterI4uivEXT(int program, int target, int index, Addressable params) {
    glext_h.glNamedProgramLocalParameterI4uivEXT(program, target, index, params);
  }

  public void glNamedProgramLocalParameters4fvEXT(int program, int target, int index, int count, Addressable params) {
    glext_h.glNamedProgramLocalParameters4fvEXT(program, target, index, count, params);
  }

  public void glNamedProgramLocalParametersI4ivEXT(int program, int target, int index, int count, Addressable params) {
    glext_h.glNamedProgramLocalParametersI4ivEXT(program, target, index, count, params);
  }

  public void glNamedProgramLocalParametersI4uivEXT(int program, int target, int index, int count, Addressable params) {
    glext_h.glNamedProgramLocalParametersI4uivEXT(program, target, index, count, params);
  }

  public void glNamedProgramStringEXT(int program, int target, int format, int len, Addressable string) {
    glext_h.glNamedProgramStringEXT(program, target, format, len, string);
  }

  public void glNamedRenderbufferStorage(int renderbuffer, int internalformat, int width, int height) {
    glext_h.glNamedRenderbufferStorage(renderbuffer, internalformat, width, height);
  }

  public void glNamedRenderbufferStorageEXT(int renderbuffer, int internalformat, int width, int height) {
    glext_h.glNamedRenderbufferStorageEXT(renderbuffer, internalformat, width, height);
  }

  public void glNamedRenderbufferStorageMultisample(int renderbuffer, int samples, int internalformat, int width, int height) {
    glext_h.glNamedRenderbufferStorageMultisample(renderbuffer, samples, internalformat, width, height);
  }

  public void glNamedRenderbufferStorageMultisampleAdvancedAMD(int renderbuffer, int samples, int storageSamples, int internalformat, int width, int height) {
    glext_h.glNamedRenderbufferStorageMultisampleAdvancedAMD(renderbuffer, samples, storageSamples, internalformat, width, height);
  }

  public void glNamedRenderbufferStorageMultisampleCoverageEXT(int renderbuffer, int coverageSamples, int colorSamples, int internalformat, int width, int height) {
    glext_h.glNamedRenderbufferStorageMultisampleCoverageEXT(renderbuffer, coverageSamples, colorSamples, internalformat, width, height);
  }

  public void glNamedRenderbufferStorageMultisampleEXT(int renderbuffer, int samples, int internalformat, int width, int height) {
    glext_h.glNamedRenderbufferStorageMultisampleEXT(renderbuffer, samples, internalformat, width, height);
  }

  public void glNamedStringARB(int type, int namelen, Addressable name, int stringlen, Addressable string) {
    glext_h.glNamedStringARB(type, namelen, name, stringlen, string);
  }

  public int glNewObjectBufferATI(int size, Addressable pointer, int usage) {
    return glext_h.glNewObjectBufferATI(size, pointer, usage);
  }

  public void glNormal3fVertex3fSUN(float nx, float ny, float nz, float x, float y, float z) {
    glext_h.glNormal3fVertex3fSUN(nx, ny, nz, x, y, z);
  }

  public void glNormal3fVertex3fvSUN(Addressable n, Addressable v) {
    glext_h.glNormal3fVertex3fvSUN(n, v);
  }

  public void glNormal3hNV(short nx, short ny, short nz) {
    glext_h.glNormal3hNV(nx, ny, nz);
  }

  public void glNormal3hvNV(Addressable v) {
    glext_h.glNormal3hvNV(v);
  }

  public void glNormal3xOES(int nx, int ny, int nz) {
    glext_h.glNormal3xOES(nx, ny, nz);
  }

  public void glNormal3xvOES(Addressable coords) {
    glext_h.glNormal3xvOES(coords);
  }

  public void glNormalFormatNV(int type, int stride) {
    glext_h.glNormalFormatNV(type, stride);
  }

  public void glNormalP3ui(int type, int coords) {
    glext_h.glNormalP3ui(type, coords);
  }

  public void glNormalP3uiv(int type, Addressable coords) {
    glext_h.glNormalP3uiv(type, coords);
  }

  public void glNormalPointerEXT(int type, int stride, int count, Addressable pointer) {
    glext_h.glNormalPointerEXT(type, stride, count, pointer);
  }

  public void glNormalPointerListIBM(int type, int stride, Addressable pointer, int ptrstride) {
    glext_h.glNormalPointerListIBM(type, stride, pointer, ptrstride);
  }

  public void glNormalPointervINTEL(int type, Addressable pointer) {
    glext_h.glNormalPointervINTEL(type, pointer);
  }

  public void glNormalStream3bATI(int stream, byte nx, byte ny, byte nz) {
    glext_h.glNormalStream3bATI(stream, nx, ny, nz);
  }

  public void glNormalStream3bvATI(int stream, Addressable coords) {
    glext_h.glNormalStream3bvATI(stream, coords);
  }

  public void glNormalStream3dATI(int stream, double nx, double ny, double nz) {
    glext_h.glNormalStream3dATI(stream, nx, ny, nz);
  }

  public void glNormalStream3dvATI(int stream, Addressable coords) {
    glext_h.glNormalStream3dvATI(stream, coords);
  }

  public void glNormalStream3fATI(int stream, float nx, float ny, float nz) {
    glext_h.glNormalStream3fATI(stream, nx, ny, nz);
  }

  public void glNormalStream3fvATI(int stream, Addressable coords) {
    glext_h.glNormalStream3fvATI(stream, coords);
  }

  public void glNormalStream3iATI(int stream, int nx, int ny, int nz) {
    glext_h.glNormalStream3iATI(stream, nx, ny, nz);
  }

  public void glNormalStream3ivATI(int stream, Addressable coords) {
    glext_h.glNormalStream3ivATI(stream, coords);
  }

  public void glNormalStream3sATI(int stream, short nx, short ny, short nz) {
    glext_h.glNormalStream3sATI(stream, nx, ny, nz);
  }

  public void glNormalStream3svATI(int stream, Addressable coords) {
    glext_h.glNormalStream3svATI(stream, coords);
  }

  public void glObjectLabel(int identifier, int name, int length, Addressable label) {
    glext_h.glObjectLabel(identifier, name, length, label);
  }

  public void glObjectPtrLabel(Addressable ptr, int length, Addressable label) {
    glext_h.glObjectPtrLabel(ptr, length, label);
  }

  public int glObjectPurgeableAPPLE(int objectType, int name, int option) {
    return glext_h.glObjectPurgeableAPPLE(objectType, name, option);
  }

  public int glObjectUnpurgeableAPPLE(int objectType, int name, int option) {
    return glext_h.glObjectUnpurgeableAPPLE(objectType, name, option);
  }

  public void glOrthofOES(float l, float r, float b, float t, float n, float f) {
    glext_h.glOrthofOES(l, r, b, t, n, f);
  }

  public void glOrthoxOES(int l, int r, int b, int t, int n, int f) {
    glext_h.glOrthoxOES(l, r, b, t, n, f);
  }

  public void glPNTrianglesfATI(int pname, float param) {
    glext_h.glPNTrianglesfATI(pname, param);
  }

  public void glPNTrianglesiATI(int pname, int param) {
    glext_h.glPNTrianglesiATI(pname, param);
  }

  public void glPassTexCoordATI(int dst, int coord, int swizzle) {
    glext_h.glPassTexCoordATI(dst, coord, swizzle);
  }

  public void glPassThroughxOES(int token) {
    glext_h.glPassThroughxOES(token);
  }

  public void glPatchParameterfv(int pname, Addressable values) {
    glext_h.glPatchParameterfv(pname, values);
  }

  public void glPatchParameteri(int pname, int value) {
    glext_h.glPatchParameteri(pname, value);
  }

  public void glPathColorGenNV(int color, int genMode, int colorFormat, Addressable coeffs) {
    glext_h.glPathColorGenNV(color, genMode, colorFormat, coeffs);
  }

  public void glPathCommandsNV(int path, int numCommands, Addressable commands, int numCoords, int coordType, Addressable coords) {
    glext_h.glPathCommandsNV(path, numCommands, commands, numCoords, coordType, coords);
  }

  public void glPathCoordsNV(int path, int numCoords, int coordType, Addressable coords) {
    glext_h.glPathCoordsNV(path, numCoords, coordType, coords);
  }

  public void glPathCoverDepthFuncNV(int func) {
    glext_h.glPathCoverDepthFuncNV(func);
  }

  public void glPathDashArrayNV(int path, int dashCount, Addressable dashArray) {
    glext_h.glPathDashArrayNV(path, dashCount, dashArray);
  }

  public void glPathFogGenNV(int genMode) {
    glext_h.glPathFogGenNV(genMode);
  }

  public int glPathGlyphIndexArrayNV(int firstPathName, int fontTarget, Addressable fontName, int fontStyle, int firstGlyphIndex, int numGlyphs, int pathParameterTemplate, float emScale) {
    return glext_h.glPathGlyphIndexArrayNV(firstPathName, fontTarget, fontName, fontStyle, firstGlyphIndex, numGlyphs, pathParameterTemplate, emScale);
  }

  public int glPathGlyphIndexRangeNV(int fontTarget, Addressable fontName, int fontStyle, int pathParameterTemplate, float emScale, Addressable baseAndCount) {
    return glext_h.glPathGlyphIndexRangeNV(fontTarget, fontName, fontStyle, pathParameterTemplate, emScale, baseAndCount);
  }

  public void glPathGlyphRangeNV(int firstPathName, int fontTarget, Addressable fontName, int fontStyle, int firstGlyph, int numGlyphs, int handleMissingGlyphs, int pathParameterTemplate, float emScale) {
    glext_h.glPathGlyphRangeNV(firstPathName, fontTarget, fontName, fontStyle, firstGlyph, numGlyphs, handleMissingGlyphs, pathParameterTemplate, emScale);
  }

  public void glPathGlyphsNV(int firstPathName, int fontTarget, Addressable fontName, int fontStyle, int numGlyphs, int type, Addressable charcodes, int handleMissingGlyphs, int pathParameterTemplate, float emScale) {
    glext_h.glPathGlyphsNV(firstPathName, fontTarget, fontName, fontStyle, numGlyphs, type, charcodes, handleMissingGlyphs, pathParameterTemplate, emScale);
  }

  public int glPathMemoryGlyphIndexArrayNV(int firstPathName, int fontTarget, long fontSize, Addressable fontData, int faceIndex, int firstGlyphIndex, int numGlyphs, int pathParameterTemplate, float emScale) {
    return glext_h.glPathMemoryGlyphIndexArrayNV(firstPathName, fontTarget, fontSize, fontData, faceIndex, firstGlyphIndex, numGlyphs, pathParameterTemplate, emScale);
  }

  public void glPathParameterfNV(int path, int pname, float value) {
    glext_h.glPathParameterfNV(path, pname, value);
  }

  public void glPathParameterfvNV(int path, int pname, Addressable value) {
    glext_h.glPathParameterfvNV(path, pname, value);
  }

  public void glPathParameteriNV(int path, int pname, int value) {
    glext_h.glPathParameteriNV(path, pname, value);
  }

  public void glPathParameterivNV(int path, int pname, Addressable value) {
    glext_h.glPathParameterivNV(path, pname, value);
  }

  public void glPathStencilDepthOffsetNV(float factor, float units) {
    glext_h.glPathStencilDepthOffsetNV(factor, units);
  }

  public void glPathStencilFuncNV(int func, int ref, int mask) {
    glext_h.glPathStencilFuncNV(func, ref, mask);
  }

  public void glPathStringNV(int path, int format, int length, Addressable pathString) {
    glext_h.glPathStringNV(path, format, length, pathString);
  }

  public void glPathSubCommandsNV(int path, int commandStart, int commandsToDelete, int numCommands, Addressable commands, int numCoords, int coordType, Addressable coords) {
    glext_h.glPathSubCommandsNV(path, commandStart, commandsToDelete, numCommands, commands, numCoords, coordType, coords);
  }

  public void glPathSubCoordsNV(int path, int coordStart, int numCoords, int coordType, Addressable coords) {
    glext_h.glPathSubCoordsNV(path, coordStart, numCoords, coordType, coords);
  }

  public void glPathTexGenNV(int texCoordSet, int genMode, int components, Addressable coeffs) {
    glext_h.glPathTexGenNV(texCoordSet, genMode, components, coeffs);
  }

  public void glPauseTransformFeedback() {
    glext_h.glPauseTransformFeedback();
  }

  public void glPauseTransformFeedbackNV() {
    glext_h.glPauseTransformFeedbackNV();
  }

  public void glPixelDataRangeNV(int target, int length, Addressable pointer) {
    glext_h.glPixelDataRangeNV(target, length, pointer);
  }

  public void glPixelMapx(int map, int size, Addressable values) {
    glext_h.glPixelMapx(map, size, values);
  }

  public void glPixelStorex(int pname, int param) {
    glext_h.glPixelStorex(pname, param);
  }

  public void glPixelTexGenParameterfSGIS(int pname, float param) {
    glext_h.glPixelTexGenParameterfSGIS(pname, param);
  }

  public void glPixelTexGenParameterfvSGIS(int pname, Addressable params) {
    glext_h.glPixelTexGenParameterfvSGIS(pname, params);
  }

  public void glPixelTexGenParameteriSGIS(int pname, int param) {
    glext_h.glPixelTexGenParameteriSGIS(pname, param);
  }

  public void glPixelTexGenParameterivSGIS(int pname, Addressable params) {
    glext_h.glPixelTexGenParameterivSGIS(pname, params);
  }

  public void glPixelTexGenSGIX(int mode) {
    glext_h.glPixelTexGenSGIX(mode);
  }

  public void glPixelTransferxOES(int pname, int param) {
    glext_h.glPixelTransferxOES(pname, param);
  }

  public void glPixelTransformParameterfEXT(int target, int pname, float param) {
    glext_h.glPixelTransformParameterfEXT(target, pname, param);
  }

  public void glPixelTransformParameterfvEXT(int target, int pname, Addressable params) {
    glext_h.glPixelTransformParameterfvEXT(target, pname, params);
  }

  public void glPixelTransformParameteriEXT(int target, int pname, int param) {
    glext_h.glPixelTransformParameteriEXT(target, pname, param);
  }

  public void glPixelTransformParameterivEXT(int target, int pname, Addressable params) {
    glext_h.glPixelTransformParameterivEXT(target, pname, params);
  }

  public void glPixelZoomxOES(int xfactor, int yfactor) {
    glext_h.glPixelZoomxOES(xfactor, yfactor);
  }

  public byte glPointAlongPathNV(int path, int startSegment, int numSegments, float distance, Addressable x, Addressable y, Addressable tangentX, Addressable tangentY) {
    return glext_h.glPointAlongPathNV(path, startSegment, numSegments, distance, x, y, tangentX, tangentY);
  }

  public void glPointParameterf(int pname, float param) {
    glext_h.glPointParameterf(pname, param);
  }

  public void glPointParameterfARB(int pname, float param) {
    glext_h.glPointParameterfARB(pname, param);
  }

  public void glPointParameterfEXT(int pname, float param) {
    glext_h.glPointParameterfEXT(pname, param);
  }

  public void glPointParameterfSGIS(int pname, float param) {
    glext_h.glPointParameterfSGIS(pname, param);
  }

  public void glPointParameterfv(int pname, Addressable params) {
    glext_h.glPointParameterfv(pname, params);
  }

  public void glPointParameterfvARB(int pname, Addressable params) {
    glext_h.glPointParameterfvARB(pname, params);
  }

  public void glPointParameterfvEXT(int pname, Addressable params) {
    glext_h.glPointParameterfvEXT(pname, params);
  }

  public void glPointParameterfvSGIS(int pname, Addressable params) {
    glext_h.glPointParameterfvSGIS(pname, params);
  }

  public void glPointParameteri(int pname, int param) {
    glext_h.glPointParameteri(pname, param);
  }

  public void glPointParameteriNV(int pname, int param) {
    glext_h.glPointParameteriNV(pname, param);
  }

  public void glPointParameteriv(int pname, Addressable params) {
    glext_h.glPointParameteriv(pname, params);
  }

  public void glPointParameterivNV(int pname, Addressable params) {
    glext_h.glPointParameterivNV(pname, params);
  }

  public void glPointParameterxvOES(int pname, Addressable params) {
    glext_h.glPointParameterxvOES(pname, params);
  }

  public void glPointSizexOES(int size) {
    glext_h.glPointSizexOES(size);
  }

  public int glPollAsyncSGIX(Addressable markerp) {
    return glext_h.glPollAsyncSGIX(markerp);
  }

  public int glPollInstrumentsSGIX(Addressable marker_p) {
    return glext_h.glPollInstrumentsSGIX(marker_p);
  }

  public void glPolygonOffsetClamp(float factor, float units, float clamp) {
    glext_h.glPolygonOffsetClamp(factor, units, clamp);
  }

  public void glPolygonOffsetClampEXT(float factor, float units, float clamp) {
    glext_h.glPolygonOffsetClampEXT(factor, units, clamp);
  }

  public void glPolygonOffsetEXT(float factor, float bias) {
    glext_h.glPolygonOffsetEXT(factor, bias);
  }

  public void glPolygonOffsetxOES(int factor, int units) {
    glext_h.glPolygonOffsetxOES(factor, units);
  }

  public void glPopDebugGroup() {
    glext_h.glPopDebugGroup();
  }

  public void glPopGroupMarkerEXT() {
    glext_h.glPopGroupMarkerEXT();
  }

  public void glPresentFrameDualFillNV(int video_slot, long minPresentTime, int beginPresentTimeId, int presentDurationId, int type, int target0, int fill0, int target1, int fill1, int target2, int fill2, int target3, int fill3) {
    glext_h.glPresentFrameDualFillNV(video_slot, minPresentTime, beginPresentTimeId, presentDurationId, type, target0, fill0, target1, fill1, target2, fill2, target3, fill3);
  }

  public void glPresentFrameKeyedNV(int video_slot, long minPresentTime, int beginPresentTimeId, int presentDurationId, int type, int target0, int fill0, int key0, int target1, int fill1, int key1) {
    glext_h.glPresentFrameKeyedNV(video_slot, minPresentTime, beginPresentTimeId, presentDurationId, type, target0, fill0, key0, target1, fill1, key1);
  }

  public void glPrimitiveBoundingBoxARB(float minX, float minY, float minZ, float minW, float maxX, float maxY, float maxZ, float maxW) {
    glext_h.glPrimitiveBoundingBoxARB(minX, minY, minZ, minW, maxX, maxY, maxZ, maxW);
  }

  public void glPrimitiveRestartIndex(int index) {
    glext_h.glPrimitiveRestartIndex(index);
  }

  public void glPrimitiveRestartIndexNV(int index) {
    glext_h.glPrimitiveRestartIndexNV(index);
  }

  public void glPrimitiveRestartNV() {
    glext_h.glPrimitiveRestartNV();
  }

  public void glPrioritizeTexturesEXT(int n, Addressable textures, Addressable priorities) {
    glext_h.glPrioritizeTexturesEXT(n, textures, priorities);
  }

  public void glPrioritizeTexturesxOES(int n, Addressable textures, Addressable priorities) {
    glext_h.glPrioritizeTexturesxOES(n, textures, priorities);
  }

  public void glProgramBinary(int program, int binaryFormat, Addressable binary, int length) {
    glext_h.glProgramBinary(program, binaryFormat, binary, length);
  }

  public void glProgramBufferParametersIivNV(int target, int bindingIndex, int wordIndex, int count, Addressable params) {
    glext_h.glProgramBufferParametersIivNV(target, bindingIndex, wordIndex, count, params);
  }

  public void glProgramBufferParametersIuivNV(int target, int bindingIndex, int wordIndex, int count, Addressable params) {
    glext_h.glProgramBufferParametersIuivNV(target, bindingIndex, wordIndex, count, params);
  }

  public void glProgramBufferParametersfvNV(int target, int bindingIndex, int wordIndex, int count, Addressable params) {
    glext_h.glProgramBufferParametersfvNV(target, bindingIndex, wordIndex, count, params);
  }

  public void glProgramEnvParameter4dARB(int target, int index, double x, double y, double z, double w) {
    glext_h.glProgramEnvParameter4dARB(target, index, x, y, z, w);
  }

  public void glProgramEnvParameter4dvARB(int target, int index, Addressable params) {
    glext_h.glProgramEnvParameter4dvARB(target, index, params);
  }

  public void glProgramEnvParameter4fARB(int target, int index, float x, float y, float z, float w) {
    glext_h.glProgramEnvParameter4fARB(target, index, x, y, z, w);
  }

  public void glProgramEnvParameter4fvARB(int target, int index, Addressable params) {
    glext_h.glProgramEnvParameter4fvARB(target, index, params);
  }

  public void glProgramEnvParameterI4iNV(int target, int index, int x, int y, int z, int w) {
    glext_h.glProgramEnvParameterI4iNV(target, index, x, y, z, w);
  }

  public void glProgramEnvParameterI4ivNV(int target, int index, Addressable params) {
    glext_h.glProgramEnvParameterI4ivNV(target, index, params);
  }

  public void glProgramEnvParameterI4uiNV(int target, int index, int x, int y, int z, int w) {
    glext_h.glProgramEnvParameterI4uiNV(target, index, x, y, z, w);
  }

  public void glProgramEnvParameterI4uivNV(int target, int index, Addressable params) {
    glext_h.glProgramEnvParameterI4uivNV(target, index, params);
  }

  public void glProgramEnvParameters4fvEXT(int target, int index, int count, Addressable params) {
    glext_h.glProgramEnvParameters4fvEXT(target, index, count, params);
  }

  public void glProgramEnvParametersI4ivNV(int target, int index, int count, Addressable params) {
    glext_h.glProgramEnvParametersI4ivNV(target, index, count, params);
  }

  public void glProgramEnvParametersI4uivNV(int target, int index, int count, Addressable params) {
    glext_h.glProgramEnvParametersI4uivNV(target, index, count, params);
  }

  public void glProgramLocalParameter4dARB(int target, int index, double x, double y, double z, double w) {
    glext_h.glProgramLocalParameter4dARB(target, index, x, y, z, w);
  }

  public void glProgramLocalParameter4dvARB(int target, int index, Addressable params) {
    glext_h.glProgramLocalParameter4dvARB(target, index, params);
  }

  public void glProgramLocalParameter4fARB(int target, int index, float x, float y, float z, float w) {
    glext_h.glProgramLocalParameter4fARB(target, index, x, y, z, w);
  }

  public void glProgramLocalParameter4fvARB(int target, int index, Addressable params) {
    glext_h.glProgramLocalParameter4fvARB(target, index, params);
  }

  public void glProgramLocalParameterI4iNV(int target, int index, int x, int y, int z, int w) {
    glext_h.glProgramLocalParameterI4iNV(target, index, x, y, z, w);
  }

  public void glProgramLocalParameterI4ivNV(int target, int index, Addressable params) {
    glext_h.glProgramLocalParameterI4ivNV(target, index, params);
  }

  public void glProgramLocalParameterI4uiNV(int target, int index, int x, int y, int z, int w) {
    glext_h.glProgramLocalParameterI4uiNV(target, index, x, y, z, w);
  }

  public void glProgramLocalParameterI4uivNV(int target, int index, Addressable params) {
    glext_h.glProgramLocalParameterI4uivNV(target, index, params);
  }

  public void glProgramLocalParameters4fvEXT(int target, int index, int count, Addressable params) {
    glext_h.glProgramLocalParameters4fvEXT(target, index, count, params);
  }

  public void glProgramLocalParametersI4ivNV(int target, int index, int count, Addressable params) {
    glext_h.glProgramLocalParametersI4ivNV(target, index, count, params);
  }

  public void glProgramLocalParametersI4uivNV(int target, int index, int count, Addressable params) {
    glext_h.glProgramLocalParametersI4uivNV(target, index, count, params);
  }

  public void glProgramNamedParameter4dNV(int id, int len, Addressable name, double x, double y, double z, double w) {
    glext_h.glProgramNamedParameter4dNV(id, len, name, x, y, z, w);
  }

  public void glProgramNamedParameter4dvNV(int id, int len, Addressable name, Addressable v) {
    glext_h.glProgramNamedParameter4dvNV(id, len, name, v);
  }

  public void glProgramNamedParameter4fNV(int id, int len, Addressable name, float x, float y, float z, float w) {
    glext_h.glProgramNamedParameter4fNV(id, len, name, x, y, z, w);
  }

  public void glProgramNamedParameter4fvNV(int id, int len, Addressable name, Addressable v) {
    glext_h.glProgramNamedParameter4fvNV(id, len, name, v);
  }

  public void glProgramParameter4dNV(int target, int index, double x, double y, double z, double w) {
    glext_h.glProgramParameter4dNV(target, index, x, y, z, w);
  }

  public void glProgramParameter4dvNV(int target, int index, Addressable v) {
    glext_h.glProgramParameter4dvNV(target, index, v);
  }

  public void glProgramParameter4fNV(int target, int index, float x, float y, float z, float w) {
    glext_h.glProgramParameter4fNV(target, index, x, y, z, w);
  }

  public void glProgramParameter4fvNV(int target, int index, Addressable v) {
    glext_h.glProgramParameter4fvNV(target, index, v);
  }

  public void glProgramParameteri(int program, int pname, int value) {
    glext_h.glProgramParameteri(program, pname, value);
  }

  public void glProgramParameteriARB(int program, int pname, int value) {
    glext_h.glProgramParameteriARB(program, pname, value);
  }

  public void glProgramParameteriEXT(int program, int pname, int value) {
    glext_h.glProgramParameteriEXT(program, pname, value);
  }

  public void glProgramParameters4dvNV(int target, int index, int count, Addressable v) {
    glext_h.glProgramParameters4dvNV(target, index, count, v);
  }

  public void glProgramParameters4fvNV(int target, int index, int count, Addressable v) {
    glext_h.glProgramParameters4fvNV(target, index, count, v);
  }

  public void glProgramPathFragmentInputGenNV(int program, int location, int genMode, int components, Addressable coeffs) {
    glext_h.glProgramPathFragmentInputGenNV(program, location, genMode, components, coeffs);
  }

  public void glProgramStringARB(int target, int format, int len, Addressable string) {
    glext_h.glProgramStringARB(target, format, len, string);
  }

  public void glProgramSubroutineParametersuivNV(int target, int count, Addressable params) {
    glext_h.glProgramSubroutineParametersuivNV(target, count, params);
  }

  public void glProgramUniform1d(int program, int location, double v0) {
    glext_h.glProgramUniform1d(program, location, v0);
  }

  public void glProgramUniform1dEXT(int program, int location, double x) {
    glext_h.glProgramUniform1dEXT(program, location, x);
  }

  public void glProgramUniform1dv(int program, int location, int count, Addressable value) {
    glext_h.glProgramUniform1dv(program, location, count, value);
  }

  public void glProgramUniform1dvEXT(int program, int location, int count, Addressable value) {
    glext_h.glProgramUniform1dvEXT(program, location, count, value);
  }

  public void glProgramUniform1f(int program, int location, float v0) {
    glext_h.glProgramUniform1f(program, location, v0);
  }

  public void glProgramUniform1fEXT(int program, int location, float v0) {
    glext_h.glProgramUniform1fEXT(program, location, v0);
  }

  public void glProgramUniform1fv(int program, int location, int count, Addressable value) {
    glext_h.glProgramUniform1fv(program, location, count, value);
  }

  public void glProgramUniform1fvEXT(int program, int location, int count, Addressable value) {
    glext_h.glProgramUniform1fvEXT(program, location, count, value);
  }

  public void glProgramUniform1i(int program, int location, int v0) {
    glext_h.glProgramUniform1i(program, location, v0);
  }

  public void glProgramUniform1i64ARB(int program, int location, long x) {
    glext_h.glProgramUniform1i64ARB(program, location, x);
  }

  public void glProgramUniform1i64NV(int program, int location, long x) {
    glext_h.glProgramUniform1i64NV(program, location, x);
  }

  public void glProgramUniform1i64vARB(int program, int location, int count, Addressable value) {
    glext_h.glProgramUniform1i64vARB(program, location, count, value);
  }

  public void glProgramUniform1i64vNV(int program, int location, int count, Addressable value) {
    glext_h.glProgramUniform1i64vNV(program, location, count, value);
  }

  public void glProgramUniform1iEXT(int program, int location, int v0) {
    glext_h.glProgramUniform1iEXT(program, location, v0);
  }

  public void glProgramUniform1iv(int program, int location, int count, Addressable value) {
    glext_h.glProgramUniform1iv(program, location, count, value);
  }

  public void glProgramUniform1ivEXT(int program, int location, int count, Addressable value) {
    glext_h.glProgramUniform1ivEXT(program, location, count, value);
  }

  public void glProgramUniform1ui(int program, int location, int v0) {
    glext_h.glProgramUniform1ui(program, location, v0);
  }

  public void glProgramUniform1ui64ARB(int program, int location, long x) {
    glext_h.glProgramUniform1ui64ARB(program, location, x);
  }

  public void glProgramUniform1ui64NV(int program, int location, long x) {
    glext_h.glProgramUniform1ui64NV(program, location, x);
  }

  public void glProgramUniform1ui64vARB(int program, int location, int count, Addressable value) {
    glext_h.glProgramUniform1ui64vARB(program, location, count, value);
  }

  public void glProgramUniform1ui64vNV(int program, int location, int count, Addressable value) {
    glext_h.glProgramUniform1ui64vNV(program, location, count, value);
  }

  public void glProgramUniform1uiEXT(int program, int location, int v0) {
    glext_h.glProgramUniform1uiEXT(program, location, v0);
  }

  public void glProgramUniform1uiv(int program, int location, int count, Addressable value) {
    glext_h.glProgramUniform1uiv(program, location, count, value);
  }

  public void glProgramUniform1uivEXT(int program, int location, int count, Addressable value) {
    glext_h.glProgramUniform1uivEXT(program, location, count, value);
  }

  public void glProgramUniform2d(int program, int location, double v0, double v1) {
    glext_h.glProgramUniform2d(program, location, v0, v1);
  }

  public void glProgramUniform2dEXT(int program, int location, double x, double y) {
    glext_h.glProgramUniform2dEXT(program, location, x, y);
  }

  public void glProgramUniform2dv(int program, int location, int count, Addressable value) {
    glext_h.glProgramUniform2dv(program, location, count, value);
  }

  public void glProgramUniform2dvEXT(int program, int location, int count, Addressable value) {
    glext_h.glProgramUniform2dvEXT(program, location, count, value);
  }

  public void glProgramUniform2f(int program, int location, float v0, float v1) {
    glext_h.glProgramUniform2f(program, location, v0, v1);
  }

  public void glProgramUniform2fEXT(int program, int location, float v0, float v1) {
    glext_h.glProgramUniform2fEXT(program, location, v0, v1);
  }

  public void glProgramUniform2fv(int program, int location, int count, Addressable value) {
    glext_h.glProgramUniform2fv(program, location, count, value);
  }

  public void glProgramUniform2fvEXT(int program, int location, int count, Addressable value) {
    glext_h.glProgramUniform2fvEXT(program, location, count, value);
  }

  public void glProgramUniform2i(int program, int location, int v0, int v1) {
    glext_h.glProgramUniform2i(program, location, v0, v1);
  }

  public void glProgramUniform2i64ARB(int program, int location, long x, long y) {
    glext_h.glProgramUniform2i64ARB(program, location, x, y);
  }

  public void glProgramUniform2i64NV(int program, int location, long x, long y) {
    glext_h.glProgramUniform2i64NV(program, location, x, y);
  }

  public void glProgramUniform2i64vARB(int program, int location, int count, Addressable value) {
    glext_h.glProgramUniform2i64vARB(program, location, count, value);
  }

  public void glProgramUniform2i64vNV(int program, int location, int count, Addressable value) {
    glext_h.glProgramUniform2i64vNV(program, location, count, value);
  }

  public void glProgramUniform2iEXT(int program, int location, int v0, int v1) {
    glext_h.glProgramUniform2iEXT(program, location, v0, v1);
  }

  public void glProgramUniform2iv(int program, int location, int count, Addressable value) {
    glext_h.glProgramUniform2iv(program, location, count, value);
  }

  public void glProgramUniform2ivEXT(int program, int location, int count, Addressable value) {
    glext_h.glProgramUniform2ivEXT(program, location, count, value);
  }

  public void glProgramUniform2ui(int program, int location, int v0, int v1) {
    glext_h.glProgramUniform2ui(program, location, v0, v1);
  }

  public void glProgramUniform2ui64ARB(int program, int location, long x, long y) {
    glext_h.glProgramUniform2ui64ARB(program, location, x, y);
  }

  public void glProgramUniform2ui64NV(int program, int location, long x, long y) {
    glext_h.glProgramUniform2ui64NV(program, location, x, y);
  }

  public void glProgramUniform2ui64vARB(int program, int location, int count, Addressable value) {
    glext_h.glProgramUniform2ui64vARB(program, location, count, value);
  }

  public void glProgramUniform2ui64vNV(int program, int location, int count, Addressable value) {
    glext_h.glProgramUniform2ui64vNV(program, location, count, value);
  }

  public void glProgramUniform2uiEXT(int program, int location, int v0, int v1) {
    glext_h.glProgramUniform2uiEXT(program, location, v0, v1);
  }

  public void glProgramUniform2uiv(int program, int location, int count, Addressable value) {
    glext_h.glProgramUniform2uiv(program, location, count, value);
  }

  public void glProgramUniform2uivEXT(int program, int location, int count, Addressable value) {
    glext_h.glProgramUniform2uivEXT(program, location, count, value);
  }

  public void glProgramUniform3d(int program, int location, double v0, double v1, double v2) {
    glext_h.glProgramUniform3d(program, location, v0, v1, v2);
  }

  public void glProgramUniform3dEXT(int program, int location, double x, double y, double z) {
    glext_h.glProgramUniform3dEXT(program, location, x, y, z);
  }

  public void glProgramUniform3dv(int program, int location, int count, Addressable value) {
    glext_h.glProgramUniform3dv(program, location, count, value);
  }

  public void glProgramUniform3dvEXT(int program, int location, int count, Addressable value) {
    glext_h.glProgramUniform3dvEXT(program, location, count, value);
  }

  public void glProgramUniform3f(int program, int location, float v0, float v1, float v2) {
    glext_h.glProgramUniform3f(program, location, v0, v1, v2);
  }

  public void glProgramUniform3fEXT(int program, int location, float v0, float v1, float v2) {
    glext_h.glProgramUniform3fEXT(program, location, v0, v1, v2);
  }

  public void glProgramUniform3fv(int program, int location, int count, Addressable value) {
    glext_h.glProgramUniform3fv(program, location, count, value);
  }

  public void glProgramUniform3fvEXT(int program, int location, int count, Addressable value) {
    glext_h.glProgramUniform3fvEXT(program, location, count, value);
  }

  public void glProgramUniform3i(int program, int location, int v0, int v1, int v2) {
    glext_h.glProgramUniform3i(program, location, v0, v1, v2);
  }

  public void glProgramUniform3i64ARB(int program, int location, long x, long y, long z) {
    glext_h.glProgramUniform3i64ARB(program, location, x, y, z);
  }

  public void glProgramUniform3i64NV(int program, int location, long x, long y, long z) {
    glext_h.glProgramUniform3i64NV(program, location, x, y, z);
  }

  public void glProgramUniform3i64vARB(int program, int location, int count, Addressable value) {
    glext_h.glProgramUniform3i64vARB(program, location, count, value);
  }

  public void glProgramUniform3i64vNV(int program, int location, int count, Addressable value) {
    glext_h.glProgramUniform3i64vNV(program, location, count, value);
  }

  public void glProgramUniform3iEXT(int program, int location, int v0, int v1, int v2) {
    glext_h.glProgramUniform3iEXT(program, location, v0, v1, v2);
  }

  public void glProgramUniform3iv(int program, int location, int count, Addressable value) {
    glext_h.glProgramUniform3iv(program, location, count, value);
  }

  public void glProgramUniform3ivEXT(int program, int location, int count, Addressable value) {
    glext_h.glProgramUniform3ivEXT(program, location, count, value);
  }

  public void glProgramUniform3ui(int program, int location, int v0, int v1, int v2) {
    glext_h.glProgramUniform3ui(program, location, v0, v1, v2);
  }

  public void glProgramUniform3ui64ARB(int program, int location, long x, long y, long z) {
    glext_h.glProgramUniform3ui64ARB(program, location, x, y, z);
  }

  public void glProgramUniform3ui64NV(int program, int location, long x, long y, long z) {
    glext_h.glProgramUniform3ui64NV(program, location, x, y, z);
  }

  public void glProgramUniform3ui64vARB(int program, int location, int count, Addressable value) {
    glext_h.glProgramUniform3ui64vARB(program, location, count, value);
  }

  public void glProgramUniform3ui64vNV(int program, int location, int count, Addressable value) {
    glext_h.glProgramUniform3ui64vNV(program, location, count, value);
  }

  public void glProgramUniform3uiEXT(int program, int location, int v0, int v1, int v2) {
    glext_h.glProgramUniform3uiEXT(program, location, v0, v1, v2);
  }

  public void glProgramUniform3uiv(int program, int location, int count, Addressable value) {
    glext_h.glProgramUniform3uiv(program, location, count, value);
  }

  public void glProgramUniform3uivEXT(int program, int location, int count, Addressable value) {
    glext_h.glProgramUniform3uivEXT(program, location, count, value);
  }

  public void glProgramUniform4d(int program, int location, double v0, double v1, double v2, double v3) {
    glext_h.glProgramUniform4d(program, location, v0, v1, v2, v3);
  }

  public void glProgramUniform4dEXT(int program, int location, double x, double y, double z, double w) {
    glext_h.glProgramUniform4dEXT(program, location, x, y, z, w);
  }

  public void glProgramUniform4dv(int program, int location, int count, Addressable value) {
    glext_h.glProgramUniform4dv(program, location, count, value);
  }

  public void glProgramUniform4dvEXT(int program, int location, int count, Addressable value) {
    glext_h.glProgramUniform4dvEXT(program, location, count, value);
  }

  public void glProgramUniform4f(int program, int location, float v0, float v1, float v2, float v3) {
    glext_h.glProgramUniform4f(program, location, v0, v1, v2, v3);
  }

  public void glProgramUniform4fEXT(int program, int location, float v0, float v1, float v2, float v3) {
    glext_h.glProgramUniform4fEXT(program, location, v0, v1, v2, v3);
  }

  public void glProgramUniform4fv(int program, int location, int count, Addressable value) {
    glext_h.glProgramUniform4fv(program, location, count, value);
  }

  public void glProgramUniform4fvEXT(int program, int location, int count, Addressable value) {
    glext_h.glProgramUniform4fvEXT(program, location, count, value);
  }

  public void glProgramUniform4i(int program, int location, int v0, int v1, int v2, int v3) {
    glext_h.glProgramUniform4i(program, location, v0, v1, v2, v3);
  }

  public void glProgramUniform4i64ARB(int program, int location, long x, long y, long z, long w) {
    glext_h.glProgramUniform4i64ARB(program, location, x, y, z, w);
  }

  public void glProgramUniform4i64NV(int program, int location, long x, long y, long z, long w) {
    glext_h.glProgramUniform4i64NV(program, location, x, y, z, w);
  }

  public void glProgramUniform4i64vARB(int program, int location, int count, Addressable value) {
    glext_h.glProgramUniform4i64vARB(program, location, count, value);
  }

  public void glProgramUniform4i64vNV(int program, int location, int count, Addressable value) {
    glext_h.glProgramUniform4i64vNV(program, location, count, value);
  }

  public void glProgramUniform4iEXT(int program, int location, int v0, int v1, int v2, int v3) {
    glext_h.glProgramUniform4iEXT(program, location, v0, v1, v2, v3);
  }

  public void glProgramUniform4iv(int program, int location, int count, Addressable value) {
    glext_h.glProgramUniform4iv(program, location, count, value);
  }

  public void glProgramUniform4ivEXT(int program, int location, int count, Addressable value) {
    glext_h.glProgramUniform4ivEXT(program, location, count, value);
  }

  public void glProgramUniform4ui(int program, int location, int v0, int v1, int v2, int v3) {
    glext_h.glProgramUniform4ui(program, location, v0, v1, v2, v3);
  }

  public void glProgramUniform4ui64ARB(int program, int location, long x, long y, long z, long w) {
    glext_h.glProgramUniform4ui64ARB(program, location, x, y, z, w);
  }

  public void glProgramUniform4ui64NV(int program, int location, long x, long y, long z, long w) {
    glext_h.glProgramUniform4ui64NV(program, location, x, y, z, w);
  }

  public void glProgramUniform4ui64vARB(int program, int location, int count, Addressable value) {
    glext_h.glProgramUniform4ui64vARB(program, location, count, value);
  }

  public void glProgramUniform4ui64vNV(int program, int location, int count, Addressable value) {
    glext_h.glProgramUniform4ui64vNV(program, location, count, value);
  }

  public void glProgramUniform4uiEXT(int program, int location, int v0, int v1, int v2, int v3) {
    glext_h.glProgramUniform4uiEXT(program, location, v0, v1, v2, v3);
  }

  public void glProgramUniform4uiv(int program, int location, int count, Addressable value) {
    glext_h.glProgramUniform4uiv(program, location, count, value);
  }

  public void glProgramUniform4uivEXT(int program, int location, int count, Addressable value) {
    glext_h.glProgramUniform4uivEXT(program, location, count, value);
  }

  public void glProgramUniformHandleui64ARB(int program, int location, long value) {
    glext_h.glProgramUniformHandleui64ARB(program, location, value);
  }

  public void glProgramUniformHandleui64NV(int program, int location, long value) {
    glext_h.glProgramUniformHandleui64NV(program, location, value);
  }

  public void glProgramUniformHandleui64vARB(int program, int location, int count, Addressable values) {
    glext_h.glProgramUniformHandleui64vARB(program, location, count, values);
  }

  public void glProgramUniformHandleui64vNV(int program, int location, int count, Addressable values) {
    glext_h.glProgramUniformHandleui64vNV(program, location, count, values);
  }

  public void glProgramUniformMatrix2dv(int program, int location, int count, byte transpose, Addressable value) {
    glext_h.glProgramUniformMatrix2dv(program, location, count, transpose, value);
  }

  public void glProgramUniformMatrix2dvEXT(int program, int location, int count, byte transpose, Addressable value) {
    glext_h.glProgramUniformMatrix2dvEXT(program, location, count, transpose, value);
  }

  public void glProgramUniformMatrix2fv(int program, int location, int count, byte transpose, Addressable value) {
    glext_h.glProgramUniformMatrix2fv(program, location, count, transpose, value);
  }

  public void glProgramUniformMatrix2fvEXT(int program, int location, int count, byte transpose, Addressable value) {
    glext_h.glProgramUniformMatrix2fvEXT(program, location, count, transpose, value);
  }

  public void glProgramUniformMatrix2x3dv(int program, int location, int count, byte transpose, Addressable value) {
    glext_h.glProgramUniformMatrix2x3dv(program, location, count, transpose, value);
  }

  public void glProgramUniformMatrix2x3dvEXT(int program, int location, int count, byte transpose, Addressable value) {
    glext_h.glProgramUniformMatrix2x3dvEXT(program, location, count, transpose, value);
  }

  public void glProgramUniformMatrix2x3fv(int program, int location, int count, byte transpose, Addressable value) {
    glext_h.glProgramUniformMatrix2x3fv(program, location, count, transpose, value);
  }

  public void glProgramUniformMatrix2x3fvEXT(int program, int location, int count, byte transpose, Addressable value) {
    glext_h.glProgramUniformMatrix2x3fvEXT(program, location, count, transpose, value);
  }

  public void glProgramUniformMatrix2x4dv(int program, int location, int count, byte transpose, Addressable value) {
    glext_h.glProgramUniformMatrix2x4dv(program, location, count, transpose, value);
  }

  public void glProgramUniformMatrix2x4dvEXT(int program, int location, int count, byte transpose, Addressable value) {
    glext_h.glProgramUniformMatrix2x4dvEXT(program, location, count, transpose, value);
  }

  public void glProgramUniformMatrix2x4fv(int program, int location, int count, byte transpose, Addressable value) {
    glext_h.glProgramUniformMatrix2x4fv(program, location, count, transpose, value);
  }

  public void glProgramUniformMatrix2x4fvEXT(int program, int location, int count, byte transpose, Addressable value) {
    glext_h.glProgramUniformMatrix2x4fvEXT(program, location, count, transpose, value);
  }

  public void glProgramUniformMatrix3dv(int program, int location, int count, byte transpose, Addressable value) {
    glext_h.glProgramUniformMatrix3dv(program, location, count, transpose, value);
  }

  public void glProgramUniformMatrix3dvEXT(int program, int location, int count, byte transpose, Addressable value) {
    glext_h.glProgramUniformMatrix3dvEXT(program, location, count, transpose, value);
  }

  public void glProgramUniformMatrix3fv(int program, int location, int count, byte transpose, Addressable value) {
    glext_h.glProgramUniformMatrix3fv(program, location, count, transpose, value);
  }

  public void glProgramUniformMatrix3fvEXT(int program, int location, int count, byte transpose, Addressable value) {
    glext_h.glProgramUniformMatrix3fvEXT(program, location, count, transpose, value);
  }

  public void glProgramUniformMatrix3x2dv(int program, int location, int count, byte transpose, Addressable value) {
    glext_h.glProgramUniformMatrix3x2dv(program, location, count, transpose, value);
  }

  public void glProgramUniformMatrix3x2dvEXT(int program, int location, int count, byte transpose, Addressable value) {
    glext_h.glProgramUniformMatrix3x2dvEXT(program, location, count, transpose, value);
  }

  public void glProgramUniformMatrix3x2fv(int program, int location, int count, byte transpose, Addressable value) {
    glext_h.glProgramUniformMatrix3x2fv(program, location, count, transpose, value);
  }

  public void glProgramUniformMatrix3x2fvEXT(int program, int location, int count, byte transpose, Addressable value) {
    glext_h.glProgramUniformMatrix3x2fvEXT(program, location, count, transpose, value);
  }

  public void glProgramUniformMatrix3x4dv(int program, int location, int count, byte transpose, Addressable value) {
    glext_h.glProgramUniformMatrix3x4dv(program, location, count, transpose, value);
  }

  public void glProgramUniformMatrix3x4dvEXT(int program, int location, int count, byte transpose, Addressable value) {
    glext_h.glProgramUniformMatrix3x4dvEXT(program, location, count, transpose, value);
  }

  public void glProgramUniformMatrix3x4fv(int program, int location, int count, byte transpose, Addressable value) {
    glext_h.glProgramUniformMatrix3x4fv(program, location, count, transpose, value);
  }

  public void glProgramUniformMatrix3x4fvEXT(int program, int location, int count, byte transpose, Addressable value) {
    glext_h.glProgramUniformMatrix3x4fvEXT(program, location, count, transpose, value);
  }

  public void glProgramUniformMatrix4dv(int program, int location, int count, byte transpose, Addressable value) {
    glext_h.glProgramUniformMatrix4dv(program, location, count, transpose, value);
  }

  public void glProgramUniformMatrix4dvEXT(int program, int location, int count, byte transpose, Addressable value) {
    glext_h.glProgramUniformMatrix4dvEXT(program, location, count, transpose, value);
  }

  public void glProgramUniformMatrix4fv(int program, int location, int count, byte transpose, Addressable value) {
    glext_h.glProgramUniformMatrix4fv(program, location, count, transpose, value);
  }

  public void glProgramUniformMatrix4fvEXT(int program, int location, int count, byte transpose, Addressable value) {
    glext_h.glProgramUniformMatrix4fvEXT(program, location, count, transpose, value);
  }

  public void glProgramUniformMatrix4x2dv(int program, int location, int count, byte transpose, Addressable value) {
    glext_h.glProgramUniformMatrix4x2dv(program, location, count, transpose, value);
  }

  public void glProgramUniformMatrix4x2dvEXT(int program, int location, int count, byte transpose, Addressable value) {
    glext_h.glProgramUniformMatrix4x2dvEXT(program, location, count, transpose, value);
  }

  public void glProgramUniformMatrix4x2fv(int program, int location, int count, byte transpose, Addressable value) {
    glext_h.glProgramUniformMatrix4x2fv(program, location, count, transpose, value);
  }

  public void glProgramUniformMatrix4x2fvEXT(int program, int location, int count, byte transpose, Addressable value) {
    glext_h.glProgramUniformMatrix4x2fvEXT(program, location, count, transpose, value);
  }

  public void glProgramUniformMatrix4x3dv(int program, int location, int count, byte transpose, Addressable value) {
    glext_h.glProgramUniformMatrix4x3dv(program, location, count, transpose, value);
  }

  public void glProgramUniformMatrix4x3dvEXT(int program, int location, int count, byte transpose, Addressable value) {
    glext_h.glProgramUniformMatrix4x3dvEXT(program, location, count, transpose, value);
  }

  public void glProgramUniformMatrix4x3fv(int program, int location, int count, byte transpose, Addressable value) {
    glext_h.glProgramUniformMatrix4x3fv(program, location, count, transpose, value);
  }

  public void glProgramUniformMatrix4x3fvEXT(int program, int location, int count, byte transpose, Addressable value) {
    glext_h.glProgramUniformMatrix4x3fvEXT(program, location, count, transpose, value);
  }

  public void glProgramUniformui64NV(int program, int location, long value) {
    glext_h.glProgramUniformui64NV(program, location, value);
  }

  public void glProgramUniformui64vNV(int program, int location, int count, Addressable value) {
    glext_h.glProgramUniformui64vNV(program, location, count, value);
  }

  public void glProgramVertexLimitNV(int target, int limit) {
    glext_h.glProgramVertexLimitNV(target, limit);
  }

  public void glProvokingVertex(int mode) {
    glext_h.glProvokingVertex(mode);
  }

  public void glProvokingVertexEXT(int mode) {
    glext_h.glProvokingVertexEXT(mode);
  }

  public void glPushClientAttribDefaultEXT(int mask) {
    glext_h.glPushClientAttribDefaultEXT(mask);
  }

  public void glPushDebugGroup(int source, int id, int length, Addressable message) {
    glext_h.glPushDebugGroup(source, id, length, message);
  }

  public void glPushGroupMarkerEXT(int length, Addressable marker) {
    glext_h.glPushGroupMarkerEXT(length, marker);
  }

  public void glQueryCounter(int id, int target) {
    glext_h.glQueryCounter(id, target);
  }

  public int glQueryMatrixxOES(Addressable mantissa, Addressable exponent) {
    return glext_h.glQueryMatrixxOES(mantissa, exponent);
  }

  public void glQueryObjectParameteruiAMD(int target, int id, int pname, int param) {
    glext_h.glQueryObjectParameteruiAMD(target, id, pname, param);
  }

  public int glQueryResourceNV(int queryType, int tagId, int count, Addressable buffer) {
    return glext_h.glQueryResourceNV(queryType, tagId, count, buffer);
  }

  public void glQueryResourceTagNV(int tagId, Addressable tagString) {
    glext_h.glQueryResourceTagNV(tagId, tagString);
  }

  public void glRasterPos2xOES(int x, int y) {
    glext_h.glRasterPos2xOES(x, y);
  }

  public void glRasterPos2xvOES(Addressable coords) {
    glext_h.glRasterPos2xvOES(coords);
  }

  public void glRasterPos3xOES(int x, int y, int z) {
    glext_h.glRasterPos3xOES(x, y, z);
  }

  public void glRasterPos3xvOES(Addressable coords) {
    glext_h.glRasterPos3xvOES(coords);
  }

  public void glRasterPos4xOES(int x, int y, int z, int w) {
    glext_h.glRasterPos4xOES(x, y, z, w);
  }

  public void glRasterPos4xvOES(Addressable coords) {
    glext_h.glRasterPos4xvOES(coords);
  }

  public void glRasterSamplesEXT(int samples, byte fixedsamplelocations) {
    glext_h.glRasterSamplesEXT(samples, fixedsamplelocations);
  }

  public void glReadInstrumentsSGIX(int marker) {
    glext_h.glReadInstrumentsSGIX(marker);
  }

  public void glReadnPixels(int x, int y, int width, int height, int format, int type, int bufSize, Addressable data) {
    glext_h.glReadnPixels(x, y, width, height, format, type, bufSize, data);
  }

  public void glReadnPixelsARB(int x, int y, int width, int height, int format, int type, int bufSize, Addressable data) {
    glext_h.glReadnPixelsARB(x, y, width, height, format, type, bufSize, data);
  }

  public void glRectxOES(int x1, int y1, int x2, int y2) {
    glext_h.glRectxOES(x1, y1, x2, y2);
  }

  public void glRectxvOES(Addressable v1, Addressable v2) {
    glext_h.glRectxvOES(v1, v2);
  }

  public void glReferencePlaneSGIX(Addressable equation) {
    glext_h.glReferencePlaneSGIX(equation);
  }

  public byte glReleaseKeyedMutexWin32EXT(int memory, long key) {
    return glext_h.glReleaseKeyedMutexWin32EXT(memory, key);
  }

  public void glReleaseShaderCompiler() {
    glext_h.glReleaseShaderCompiler();
  }

  public void glRenderGpuMaskNV(int mask) {
    glext_h.glRenderGpuMaskNV(mask);
  }

  public void glRenderbufferStorage(int target, int internalformat, int width, int height) {
    glext_h.glRenderbufferStorage(target, internalformat, width, height);
  }

  public void glRenderbufferStorageEXT(int target, int internalformat, int width, int height) {
    glext_h.glRenderbufferStorageEXT(target, internalformat, width, height);
  }

  public void glRenderbufferStorageMultisample(int target, int samples, int internalformat, int width, int height) {
    glext_h.glRenderbufferStorageMultisample(target, samples, internalformat, width, height);
  }

  public void glRenderbufferStorageMultisampleAdvancedAMD(int target, int samples, int storageSamples, int internalformat, int width, int height) {
    glext_h.glRenderbufferStorageMultisampleAdvancedAMD(target, samples, storageSamples, internalformat, width, height);
  }

  public void glRenderbufferStorageMultisampleCoverageNV(int target, int coverageSamples, int colorSamples, int internalformat, int width, int height) {
    glext_h.glRenderbufferStorageMultisampleCoverageNV(target, coverageSamples, colorSamples, internalformat, width, height);
  }

  public void glRenderbufferStorageMultisampleEXT(int target, int samples, int internalformat, int width, int height) {
    glext_h.glRenderbufferStorageMultisampleEXT(target, samples, internalformat, width, height);
  }

  public void glReplacementCodePointerSUN(int type, int stride, Addressable pointer) {
    glext_h.glReplacementCodePointerSUN(type, stride, pointer);
  }

  public void glReplacementCodeubSUN(byte code) {
    glext_h.glReplacementCodeubSUN(code);
  }

  public void glReplacementCodeubvSUN(Addressable code) {
    glext_h.glReplacementCodeubvSUN(code);
  }

  public void glReplacementCodeuiColor3fVertex3fSUN(int rc, float r, float g, float b, float x, float y, float z) {
    glext_h.glReplacementCodeuiColor3fVertex3fSUN(rc, r, g, b, x, y, z);
  }

  public void glReplacementCodeuiColor3fVertex3fvSUN(Addressable rc, Addressable c, Addressable v) {
    glext_h.glReplacementCodeuiColor3fVertex3fvSUN(rc, c, v);
  }

  public void glReplacementCodeuiColor4fNormal3fVertex3fSUN(int rc, float r, float g, float b, float a, float nx, float ny, float nz, float x, float y, float z) {
    glext_h.glReplacementCodeuiColor4fNormal3fVertex3fSUN(rc, r, g, b, a, nx, ny, nz, x, y, z);
  }

  public void glReplacementCodeuiColor4fNormal3fVertex3fvSUN(Addressable rc, Addressable c, Addressable n, Addressable v) {
    glext_h.glReplacementCodeuiColor4fNormal3fVertex3fvSUN(rc, c, n, v);
  }

  public void glReplacementCodeuiColor4ubVertex3fSUN(int rc, byte r, byte g, byte b, byte a, float x, float y, float z) {
    glext_h.glReplacementCodeuiColor4ubVertex3fSUN(rc, r, g, b, a, x, y, z);
  }

  public void glReplacementCodeuiColor4ubVertex3fvSUN(Addressable rc, Addressable c, Addressable v) {
    glext_h.glReplacementCodeuiColor4ubVertex3fvSUN(rc, c, v);
  }

  public void glReplacementCodeuiNormal3fVertex3fSUN(int rc, float nx, float ny, float nz, float x, float y, float z) {
    glext_h.glReplacementCodeuiNormal3fVertex3fSUN(rc, nx, ny, nz, x, y, z);
  }

  public void glReplacementCodeuiNormal3fVertex3fvSUN(Addressable rc, Addressable n, Addressable v) {
    glext_h.glReplacementCodeuiNormal3fVertex3fvSUN(rc, n, v);
  }

  public void glReplacementCodeuiSUN(int code) {
    glext_h.glReplacementCodeuiSUN(code);
  }

  public void glReplacementCodeuiTexCoord2fColor4fNormal3fVertex3fSUN(int rc, float s, float t, float r, float g, float b, float a, float nx, float ny, float nz, float x, float y, float z) {
    glext_h.glReplacementCodeuiTexCoord2fColor4fNormal3fVertex3fSUN(rc, s, t, r, g, b, a, nx, ny, nz, x, y, z);
  }

  public void glReplacementCodeuiTexCoord2fColor4fNormal3fVertex3fvSUN(Addressable rc, Addressable tc, Addressable c, Addressable n, Addressable v) {
    glext_h.glReplacementCodeuiTexCoord2fColor4fNormal3fVertex3fvSUN(rc, tc, c, n, v);
  }

  public void glReplacementCodeuiTexCoord2fNormal3fVertex3fSUN(int rc, float s, float t, float nx, float ny, float nz, float x, float y, float z) {
    glext_h.glReplacementCodeuiTexCoord2fNormal3fVertex3fSUN(rc, s, t, nx, ny, nz, x, y, z);
  }

  public void glReplacementCodeuiTexCoord2fNormal3fVertex3fvSUN(Addressable rc, Addressable tc, Addressable n, Addressable v) {
    glext_h.glReplacementCodeuiTexCoord2fNormal3fVertex3fvSUN(rc, tc, n, v);
  }

  public void glReplacementCodeuiTexCoord2fVertex3fSUN(int rc, float s, float t, float x, float y, float z) {
    glext_h.glReplacementCodeuiTexCoord2fVertex3fSUN(rc, s, t, x, y, z);
  }

  public void glReplacementCodeuiTexCoord2fVertex3fvSUN(Addressable rc, Addressable tc, Addressable v) {
    glext_h.glReplacementCodeuiTexCoord2fVertex3fvSUN(rc, tc, v);
  }

  public void glReplacementCodeuiVertex3fSUN(int rc, float x, float y, float z) {
    glext_h.glReplacementCodeuiVertex3fSUN(rc, x, y, z);
  }

  public void glReplacementCodeuiVertex3fvSUN(Addressable rc, Addressable v) {
    glext_h.glReplacementCodeuiVertex3fvSUN(rc, v);
  }

  public void glReplacementCodeuivSUN(Addressable code) {
    glext_h.glReplacementCodeuivSUN(code);
  }

  public void glReplacementCodeusSUN(short code) {
    glext_h.glReplacementCodeusSUN(code);
  }

  public void glReplacementCodeusvSUN(Addressable code) {
    glext_h.glReplacementCodeusvSUN(code);
  }

  public void glRequestResidentProgramsNV(int n, Addressable programs) {
    glext_h.glRequestResidentProgramsNV(n, programs);
  }

  public void glResetHistogramEXT(int target) {
    glext_h.glResetHistogramEXT(target);
  }

  public void glResetMemoryObjectParameterNV(int memory, int pname) {
    glext_h.glResetMemoryObjectParameterNV(memory, pname);
  }

  public void glResetMinmaxEXT(int target) {
    glext_h.glResetMinmaxEXT(target);
  }

  public void glResizeBuffersMESA() {
    glext_h.glResizeBuffersMESA();
  }

  public void glResolveDepthValuesNV() {
    glext_h.glResolveDepthValuesNV();
  }

  public void glResumeTransformFeedback() {
    glext_h.glResumeTransformFeedback();
  }

  public void glResumeTransformFeedbackNV() {
    glext_h.glResumeTransformFeedbackNV();
  }

  public void glRotatexOES(int angle, int x, int y, int z) {
    glext_h.glRotatexOES(angle, x, y, z);
  }

  public void glSampleCoverageARB(float value, byte invert) {
    glext_h.glSampleCoverageARB(value, invert);
  }

  public void glSampleMapATI(int dst, int interp, int swizzle) {
    glext_h.glSampleMapATI(dst, interp, swizzle);
  }

  public void glSampleMaskEXT(float value, byte invert) {
    glext_h.glSampleMaskEXT(value, invert);
  }

  public void glSampleMaskIndexedNV(int index, int mask) {
    glext_h.glSampleMaskIndexedNV(index, mask);
  }

  public void glSampleMaskSGIS(float value, byte invert) {
    glext_h.glSampleMaskSGIS(value, invert);
  }

  public void glSampleMaski(int maskNumber, int mask) {
    glext_h.glSampleMaski(maskNumber, mask);
  }

  public void glSamplePatternEXT(int pattern) {
    glext_h.glSamplePatternEXT(pattern);
  }

  public void glSamplePatternSGIS(int pattern) {
    glext_h.glSamplePatternSGIS(pattern);
  }

  public void glSamplerParameterIiv(int sampler, int pname, Addressable param) {
    glext_h.glSamplerParameterIiv(sampler, pname, param);
  }

  public void glSamplerParameterIuiv(int sampler, int pname, Addressable param) {
    glext_h.glSamplerParameterIuiv(sampler, pname, param);
  }

  public void glSamplerParameterf(int sampler, int pname, float param) {
    glext_h.glSamplerParameterf(sampler, pname, param);
  }

  public void glSamplerParameterfv(int sampler, int pname, Addressable param) {
    glext_h.glSamplerParameterfv(sampler, pname, param);
  }

  public void glSamplerParameteri(int sampler, int pname, int param) {
    glext_h.glSamplerParameteri(sampler, pname, param);
  }

  public void glSamplerParameteriv(int sampler, int pname, Addressable param) {
    glext_h.glSamplerParameteriv(sampler, pname, param);
  }

  public void glScalexOES(int x, int y, int z) {
    glext_h.glScalexOES(x, y, z);
  }

  public void glScissorArrayv(int first, int count, Addressable v) {
    glext_h.glScissorArrayv(first, count, v);
  }

  public void glScissorExclusiveArrayvNV(int first, int count, Addressable v) {
    glext_h.glScissorExclusiveArrayvNV(first, count, v);
  }

  public void glScissorExclusiveNV(int x, int y, int width, int height) {
    glext_h.glScissorExclusiveNV(x, y, width, height);
  }

  public void glScissorIndexed(int index, int left, int bottom, int width, int height) {
    glext_h.glScissorIndexed(index, left, bottom, width, height);
  }

  public void glScissorIndexedv(int index, Addressable v) {
    glext_h.glScissorIndexedv(index, v);
  }

  public void glSecondaryColor3b(byte red, byte green, byte blue) {
    glext_h.glSecondaryColor3b(red, green, blue);
  }

  public void glSecondaryColor3bEXT(byte red, byte green, byte blue) {
    glext_h.glSecondaryColor3bEXT(red, green, blue);
  }

  public void glSecondaryColor3bv(Addressable v) {
    glext_h.glSecondaryColor3bv(v);
  }

  public void glSecondaryColor3bvEXT(Addressable v) {
    glext_h.glSecondaryColor3bvEXT(v);
  }

  public void glSecondaryColor3d(double red, double green, double blue) {
    glext_h.glSecondaryColor3d(red, green, blue);
  }

  public void glSecondaryColor3dEXT(double red, double green, double blue) {
    glext_h.glSecondaryColor3dEXT(red, green, blue);
  }

  public void glSecondaryColor3dv(Addressable v) {
    glext_h.glSecondaryColor3dv(v);
  }

  public void glSecondaryColor3dvEXT(Addressable v) {
    glext_h.glSecondaryColor3dvEXT(v);
  }

  public void glSecondaryColor3f(float red, float green, float blue) {
    glext_h.glSecondaryColor3f(red, green, blue);
  }

  public void glSecondaryColor3fEXT(float red, float green, float blue) {
    glext_h.glSecondaryColor3fEXT(red, green, blue);
  }

  public void glSecondaryColor3fv(Addressable v) {
    glext_h.glSecondaryColor3fv(v);
  }

  public void glSecondaryColor3fvEXT(Addressable v) {
    glext_h.glSecondaryColor3fvEXT(v);
  }

  public void glSecondaryColor3hNV(short red, short green, short blue) {
    glext_h.glSecondaryColor3hNV(red, green, blue);
  }

  public void glSecondaryColor3hvNV(Addressable v) {
    glext_h.glSecondaryColor3hvNV(v);
  }

  public void glSecondaryColor3i(int red, int green, int blue) {
    glext_h.glSecondaryColor3i(red, green, blue);
  }

  public void glSecondaryColor3iEXT(int red, int green, int blue) {
    glext_h.glSecondaryColor3iEXT(red, green, blue);
  }

  public void glSecondaryColor3iv(Addressable v) {
    glext_h.glSecondaryColor3iv(v);
  }

  public void glSecondaryColor3ivEXT(Addressable v) {
    glext_h.glSecondaryColor3ivEXT(v);
  }

  public void glSecondaryColor3s(short red, short green, short blue) {
    glext_h.glSecondaryColor3s(red, green, blue);
  }

  public void glSecondaryColor3sEXT(short red, short green, short blue) {
    glext_h.glSecondaryColor3sEXT(red, green, blue);
  }

  public void glSecondaryColor3sv(Addressable v) {
    glext_h.glSecondaryColor3sv(v);
  }

  public void glSecondaryColor3svEXT(Addressable v) {
    glext_h.glSecondaryColor3svEXT(v);
  }

  public void glSecondaryColor3ub(byte red, byte green, byte blue) {
    glext_h.glSecondaryColor3ub(red, green, blue);
  }

  public void glSecondaryColor3ubEXT(byte red, byte green, byte blue) {
    glext_h.glSecondaryColor3ubEXT(red, green, blue);
  }

  public void glSecondaryColor3ubv(Addressable v) {
    glext_h.glSecondaryColor3ubv(v);
  }

  public void glSecondaryColor3ubvEXT(Addressable v) {
    glext_h.glSecondaryColor3ubvEXT(v);
  }

  public void glSecondaryColor3ui(int red, int green, int blue) {
    glext_h.glSecondaryColor3ui(red, green, blue);
  }

  public void glSecondaryColor3uiEXT(int red, int green, int blue) {
    glext_h.glSecondaryColor3uiEXT(red, green, blue);
  }

  public void glSecondaryColor3uiv(Addressable v) {
    glext_h.glSecondaryColor3uiv(v);
  }

  public void glSecondaryColor3uivEXT(Addressable v) {
    glext_h.glSecondaryColor3uivEXT(v);
  }

  public void glSecondaryColor3us(short red, short green, short blue) {
    glext_h.glSecondaryColor3us(red, green, blue);
  }

  public void glSecondaryColor3usEXT(short red, short green, short blue) {
    glext_h.glSecondaryColor3usEXT(red, green, blue);
  }

  public void glSecondaryColor3usv(Addressable v) {
    glext_h.glSecondaryColor3usv(v);
  }

  public void glSecondaryColor3usvEXT(Addressable v) {
    glext_h.glSecondaryColor3usvEXT(v);
  }

  public void glSecondaryColorFormatNV(int size, int type, int stride) {
    glext_h.glSecondaryColorFormatNV(size, type, stride);
  }

  public void glSecondaryColorP3ui(int type, int color) {
    glext_h.glSecondaryColorP3ui(type, color);
  }

  public void glSecondaryColorP3uiv(int type, Addressable color) {
    glext_h.glSecondaryColorP3uiv(type, color);
  }

  public void glSecondaryColorPointer(int size, int type, int stride, Addressable pointer) {
    glext_h.glSecondaryColorPointer(size, type, stride, pointer);
  }

  public void glSecondaryColorPointerEXT(int size, int type, int stride, Addressable pointer) {
    glext_h.glSecondaryColorPointerEXT(size, type, stride, pointer);
  }

  public void glSecondaryColorPointerListIBM(int size, int type, int stride, Addressable pointer, int ptrstride) {
    glext_h.glSecondaryColorPointerListIBM(size, type, stride, pointer, ptrstride);
  }

  public void glSelectPerfMonitorCountersAMD(int monitor, byte enable, int group, int numCounters, Addressable counterList) {
    glext_h.glSelectPerfMonitorCountersAMD(monitor, enable, group, numCounters, counterList);
  }

  public void glSemaphoreParameterui64vEXT(int semaphore, int pname, Addressable params) {
    glext_h.glSemaphoreParameterui64vEXT(semaphore, pname, params);
  }

  public void glSeparableFilter2DEXT(int target, int internalformat, int width, int height, int format, int type, Addressable row, Addressable column) {
    glext_h.glSeparableFilter2DEXT(target, internalformat, width, height, format, type, row, column);
  }

  public void glSetFenceAPPLE(int fence) {
    glext_h.glSetFenceAPPLE(fence);
  }

  public void glSetFenceNV(int fence, int condition) {
    glext_h.glSetFenceNV(fence, condition);
  }

  public void glSetFragmentShaderConstantATI(int dst, Addressable value) {
    glext_h.glSetFragmentShaderConstantATI(dst, value);
  }

  public void glSetInvariantEXT(int id, int type, Addressable addr) {
    glext_h.glSetInvariantEXT(id, type, addr);
  }

  public void glSetLocalConstantEXT(int id, int type, Addressable addr) {
    glext_h.glSetLocalConstantEXT(id, type, addr);
  }

  public void glSetMultisamplefvAMD(int pname, int index, Addressable val) {
    glext_h.glSetMultisamplefvAMD(pname, index, val);
  }

  public void glShaderBinary(int count, Addressable shaders, int binaryFormat, Addressable binary, int length) {
    glext_h.glShaderBinary(count, shaders, binaryFormat, binary, length);
  }

  public void glShaderOp1EXT(int op, int res, int arg1) {
    glext_h.glShaderOp1EXT(op, res, arg1);
  }

  public void glShaderOp2EXT(int op, int res, int arg1, int arg2) {
    glext_h.glShaderOp2EXT(op, res, arg1, arg2);
  }

  public void glShaderOp3EXT(int op, int res, int arg1, int arg2, int arg3) {
    glext_h.glShaderOp3EXT(op, res, arg1, arg2, arg3);
  }

  public void glShaderSource(int shader, int count, Addressable string, Addressable length) {
    glext_h.glShaderSource(shader, count, string, length);
  }

  public void glShaderSourceARB(int shaderObj, int count, Addressable string, Addressable length) {
    glext_h.glShaderSourceARB(shaderObj, count, string, length);
  }

  public void glShaderStorageBlockBinding(int program, int storageBlockIndex, int storageBlockBinding) {
    glext_h.glShaderStorageBlockBinding(program, storageBlockIndex, storageBlockBinding);
  }

  public void glShadingRateImageBarrierNV(byte synchronize) {
    glext_h.glShadingRateImageBarrierNV(synchronize);
  }

  public void glShadingRateImagePaletteNV(int viewport, int first, int count, Addressable rates) {
    glext_h.glShadingRateImagePaletteNV(viewport, first, count, rates);
  }

  public void glShadingRateSampleOrderCustomNV(int rate, int samples, Addressable locations) {
    glext_h.glShadingRateSampleOrderCustomNV(rate, samples, locations);
  }

  public void glShadingRateSampleOrderNV(int order) {
    glext_h.glShadingRateSampleOrderNV(order);
  }

  public void glSharpenTexFuncSGIS(int target, int n, Addressable points) {
    glext_h.glSharpenTexFuncSGIS(target, n, points);
  }

  public void glSignalSemaphoreEXT(int semaphore, int numBufferBarriers, Addressable buffers, int numTextureBarriers, Addressable textures, Addressable dstLayouts) {
    glext_h.glSignalSemaphoreEXT(semaphore, numBufferBarriers, buffers, numTextureBarriers, textures, dstLayouts);
  }

  public void glSignalSemaphoreui64NVX(int signalGpu, int fenceObjectCount, Addressable semaphoreArray, Addressable fenceValueArray) {
    glext_h.glSignalSemaphoreui64NVX(signalGpu, fenceObjectCount, semaphoreArray, fenceValueArray);
  }

  public void glSignalVkFenceNV(long vkFence) {
    glext_h.glSignalVkFenceNV(vkFence);
  }

  public void glSignalVkSemaphoreNV(long vkSemaphore) {
    glext_h.glSignalVkSemaphoreNV(vkSemaphore);
  }

  public void glSpecializeShader(int shader, Addressable pEntryPoint, int numSpecializationConstants, Addressable pConstantIndex, Addressable pConstantValue) {
    glext_h.glSpecializeShader(shader, pEntryPoint, numSpecializationConstants, pConstantIndex, pConstantValue);
  }

  public void glSpecializeShaderARB(int shader, Addressable pEntryPoint, int numSpecializationConstants, Addressable pConstantIndex, Addressable pConstantValue) {
    glext_h.glSpecializeShaderARB(shader, pEntryPoint, numSpecializationConstants, pConstantIndex, pConstantValue);
  }

  public void glSpriteParameterfSGIX(int pname, float param) {
    glext_h.glSpriteParameterfSGIX(pname, param);
  }

  public void glSpriteParameterfvSGIX(int pname, Addressable params) {
    glext_h.glSpriteParameterfvSGIX(pname, params);
  }

  public void glSpriteParameteriSGIX(int pname, int param) {
    glext_h.glSpriteParameteriSGIX(pname, param);
  }

  public void glSpriteParameterivSGIX(int pname, Addressable params) {
    glext_h.glSpriteParameterivSGIX(pname, params);
  }

  public void glStartInstrumentsSGIX() {
    glext_h.glStartInstrumentsSGIX();
  }

  public void glStateCaptureNV(int state, int mode) {
    glext_h.glStateCaptureNV(state, mode);
  }

  public void glStencilClearTagEXT(int stencilTagBits, int stencilClearTag) {
    glext_h.glStencilClearTagEXT(stencilTagBits, stencilClearTag);
  }

  public void glStencilFillPathInstancedNV(int numPaths, int pathNameType, Addressable paths, int pathBase, int fillMode, int mask, int transformType, Addressable transformValues) {
    glext_h.glStencilFillPathInstancedNV(numPaths, pathNameType, paths, pathBase, fillMode, mask, transformType, transformValues);
  }

  public void glStencilFillPathNV(int path, int fillMode, int mask) {
    glext_h.glStencilFillPathNV(path, fillMode, mask);
  }

  public void glStencilFuncSeparate(int face, int func, int ref, int mask) {
    glext_h.glStencilFuncSeparate(face, func, ref, mask);
  }

  public void glStencilFuncSeparateATI(int frontfunc, int backfunc, int ref, int mask) {
    glext_h.glStencilFuncSeparateATI(frontfunc, backfunc, ref, mask);
  }

  public void glStencilMaskSeparate(int face, int mask) {
    glext_h.glStencilMaskSeparate(face, mask);
  }

  public void glStencilOpSeparate(int face, int sfail, int dpfail, int dppass) {
    glext_h.glStencilOpSeparate(face, sfail, dpfail, dppass);
  }

  public void glStencilOpSeparateATI(int face, int sfail, int dpfail, int dppass) {
    glext_h.glStencilOpSeparateATI(face, sfail, dpfail, dppass);
  }

  public void glStencilOpValueAMD(int face, int value) {
    glext_h.glStencilOpValueAMD(face, value);
  }

  public void glStencilStrokePathInstancedNV(int numPaths, int pathNameType, Addressable paths, int pathBase, int reference, int mask, int transformType, Addressable transformValues) {
    glext_h.glStencilStrokePathInstancedNV(numPaths, pathNameType, paths, pathBase, reference, mask, transformType, transformValues);
  }

  public void glStencilStrokePathNV(int path, int reference, int mask) {
    glext_h.glStencilStrokePathNV(path, reference, mask);
  }

  public void glStencilThenCoverFillPathInstancedNV(int numPaths, int pathNameType, Addressable paths, int pathBase, int fillMode, int mask, int coverMode, int transformType, Addressable transformValues) {
    glext_h.glStencilThenCoverFillPathInstancedNV(numPaths, pathNameType, paths, pathBase, fillMode, mask, coverMode, transformType, transformValues);
  }

  public void glStencilThenCoverFillPathNV(int path, int fillMode, int mask, int coverMode) {
    glext_h.glStencilThenCoverFillPathNV(path, fillMode, mask, coverMode);
  }

  public void glStencilThenCoverStrokePathInstancedNV(int numPaths, int pathNameType, Addressable paths, int pathBase, int reference, int mask, int coverMode, int transformType, Addressable transformValues) {
    glext_h.glStencilThenCoverStrokePathInstancedNV(numPaths, pathNameType, paths, pathBase, reference, mask, coverMode, transformType, transformValues);
  }

  public void glStencilThenCoverStrokePathNV(int path, int reference, int mask, int coverMode) {
    glext_h.glStencilThenCoverStrokePathNV(path, reference, mask, coverMode);
  }

  public void glStopInstrumentsSGIX(int marker) {
    glext_h.glStopInstrumentsSGIX(marker);
  }

  public void glStringMarkerGREMEDY(int len, Addressable string) {
    glext_h.glStringMarkerGREMEDY(len, string);
  }

  public void glSubpixelPrecisionBiasNV(int xbits, int ybits) {
    glext_h.glSubpixelPrecisionBiasNV(xbits, ybits);
  }

  public void glSwizzleEXT(int res, int in, int outX, int outY, int outZ, int outW) {
    glext_h.glSwizzleEXT(res, in, outX, outY, outZ, outW);
  }

  public void glSyncTextureINTEL(int texture) {
    glext_h.glSyncTextureINTEL(texture);
  }

  public void glTagSampleBufferSGIX() {
    glext_h.glTagSampleBufferSGIX();
  }

  public void glTangent3bEXT(byte tx, byte ty, byte tz) {
    glext_h.glTangent3bEXT(tx, ty, tz);
  }

  public void glTangent3bvEXT(Addressable v) {
    glext_h.glTangent3bvEXT(v);
  }

  public void glTangent3dEXT(double tx, double ty, double tz) {
    glext_h.glTangent3dEXT(tx, ty, tz);
  }

  public void glTangent3dvEXT(Addressable v) {
    glext_h.glTangent3dvEXT(v);
  }

  public void glTangent3fEXT(float tx, float ty, float tz) {
    glext_h.glTangent3fEXT(tx, ty, tz);
  }

  public void glTangent3fvEXT(Addressable v) {
    glext_h.glTangent3fvEXT(v);
  }

  public void glTangent3iEXT(int tx, int ty, int tz) {
    glext_h.glTangent3iEXT(tx, ty, tz);
  }

  public void glTangent3ivEXT(Addressable v) {
    glext_h.glTangent3ivEXT(v);
  }

  public void glTangent3sEXT(short tx, short ty, short tz) {
    glext_h.glTangent3sEXT(tx, ty, tz);
  }

  public void glTangent3svEXT(Addressable v) {
    glext_h.glTangent3svEXT(v);
  }

  public void glTangentPointerEXT(int type, int stride, Addressable pointer) {
    glext_h.glTangentPointerEXT(type, stride, pointer);
  }

  public void glTbufferMask3DFX(int mask) {
    glext_h.glTbufferMask3DFX(mask);
  }

  public void glTessellationFactorAMD(float factor) {
    glext_h.glTessellationFactorAMD(factor);
  }

  public void glTessellationModeAMD(int mode) {
    glext_h.glTessellationModeAMD(mode);
  }

  public byte glTestFenceAPPLE(int fence) {
    return glext_h.glTestFenceAPPLE(fence);
  }

  public byte glTestFenceNV(int fence) {
    return glext_h.glTestFenceNV(fence);
  }

  public byte glTestObjectAPPLE(int object, int name) {
    return glext_h.glTestObjectAPPLE(object, name);
  }

  public void glTexAttachMemoryNV(int target, int memory, long offset) {
    glext_h.glTexAttachMemoryNV(target, memory, offset);
  }

  public void glTexBuffer(int target, int internalformat, int buffer) {
    glext_h.glTexBuffer(target, internalformat, buffer);
  }

  public void glTexBufferARB(int target, int internalformat, int buffer) {
    glext_h.glTexBufferARB(target, internalformat, buffer);
  }

  public void glTexBufferEXT(int target, int internalformat, int buffer) {
    glext_h.glTexBufferEXT(target, internalformat, buffer);
  }

  public void glTexBufferRange(int target, int internalformat, int buffer, long offset, long size) {
    glext_h.glTexBufferRange(target, internalformat, buffer, offset, size);
  }

  public void glTexBumpParameterfvATI(int pname, Addressable param) {
    glext_h.glTexBumpParameterfvATI(pname, param);
  }

  public void glTexBumpParameterivATI(int pname, Addressable param) {
    glext_h.glTexBumpParameterivATI(pname, param);
  }

  public void glTexCoord1bOES(byte s) {
    glext_h.glTexCoord1bOES(s);
  }

  public void glTexCoord1bvOES(Addressable coords) {
    glext_h.glTexCoord1bvOES(coords);
  }

  public void glTexCoord1hNV(short s) {
    glext_h.glTexCoord1hNV(s);
  }

  public void glTexCoord1hvNV(Addressable v) {
    glext_h.glTexCoord1hvNV(v);
  }

  public void glTexCoord1xOES(int s) {
    glext_h.glTexCoord1xOES(s);
  }

  public void glTexCoord1xvOES(Addressable coords) {
    glext_h.glTexCoord1xvOES(coords);
  }

  public void glTexCoord2bOES(byte s, byte t) {
    glext_h.glTexCoord2bOES(s, t);
  }

  public void glTexCoord2bvOES(Addressable coords) {
    glext_h.glTexCoord2bvOES(coords);
  }

  public void glTexCoord2fColor3fVertex3fSUN(float s, float t, float r, float g, float b, float x, float y, float z) {
    glext_h.glTexCoord2fColor3fVertex3fSUN(s, t, r, g, b, x, y, z);
  }

  public void glTexCoord2fColor3fVertex3fvSUN(Addressable tc, Addressable c, Addressable v) {
    glext_h.glTexCoord2fColor3fVertex3fvSUN(tc, c, v);
  }

  public void glTexCoord2fColor4fNormal3fVertex3fSUN(float s, float t, float r, float g, float b, float a, float nx, float ny, float nz, float x, float y, float z) {
    glext_h.glTexCoord2fColor4fNormal3fVertex3fSUN(s, t, r, g, b, a, nx, ny, nz, x, y, z);
  }

  public void glTexCoord2fColor4fNormal3fVertex3fvSUN(Addressable tc, Addressable c, Addressable n, Addressable v) {
    glext_h.glTexCoord2fColor4fNormal3fVertex3fvSUN(tc, c, n, v);
  }

  public void glTexCoord2fColor4ubVertex3fSUN(float s, float t, byte r, byte g, byte b, byte a, float x, float y, float z) {
    glext_h.glTexCoord2fColor4ubVertex3fSUN(s, t, r, g, b, a, x, y, z);
  }

  public void glTexCoord2fColor4ubVertex3fvSUN(Addressable tc, Addressable c, Addressable v) {
    glext_h.glTexCoord2fColor4ubVertex3fvSUN(tc, c, v);
  }

  public void glTexCoord2fNormal3fVertex3fSUN(float s, float t, float nx, float ny, float nz, float x, float y, float z) {
    glext_h.glTexCoord2fNormal3fVertex3fSUN(s, t, nx, ny, nz, x, y, z);
  }

  public void glTexCoord2fNormal3fVertex3fvSUN(Addressable tc, Addressable n, Addressable v) {
    glext_h.glTexCoord2fNormal3fVertex3fvSUN(tc, n, v);
  }

  public void glTexCoord2fVertex3fSUN(float s, float t, float x, float y, float z) {
    glext_h.glTexCoord2fVertex3fSUN(s, t, x, y, z);
  }

  public void glTexCoord2fVertex3fvSUN(Addressable tc, Addressable v) {
    glext_h.glTexCoord2fVertex3fvSUN(tc, v);
  }

  public void glTexCoord2hNV(short s, short t) {
    glext_h.glTexCoord2hNV(s, t);
  }

  public void glTexCoord2hvNV(Addressable v) {
    glext_h.glTexCoord2hvNV(v);
  }

  public void glTexCoord2xOES(int s, int t) {
    glext_h.glTexCoord2xOES(s, t);
  }

  public void glTexCoord2xvOES(Addressable coords) {
    glext_h.glTexCoord2xvOES(coords);
  }

  public void glTexCoord3bOES(byte s, byte t, byte r) {
    glext_h.glTexCoord3bOES(s, t, r);
  }

  public void glTexCoord3bvOES(Addressable coords) {
    glext_h.glTexCoord3bvOES(coords);
  }

  public void glTexCoord3hNV(short s, short t, short r) {
    glext_h.glTexCoord3hNV(s, t, r);
  }

  public void glTexCoord3hvNV(Addressable v) {
    glext_h.glTexCoord3hvNV(v);
  }

  public void glTexCoord3xOES(int s, int t, int r) {
    glext_h.glTexCoord3xOES(s, t, r);
  }

  public void glTexCoord3xvOES(Addressable coords) {
    glext_h.glTexCoord3xvOES(coords);
  }

  public void glTexCoord4bOES(byte s, byte t, byte r, byte q) {
    glext_h.glTexCoord4bOES(s, t, r, q);
  }

  public void glTexCoord4bvOES(Addressable coords) {
    glext_h.glTexCoord4bvOES(coords);
  }

  public void glTexCoord4fColor4fNormal3fVertex4fSUN(float s, float t, float p, float q, float r, float g, float b, float a, float nx, float ny, float nz, float x, float y, float z, float w) {
    glext_h.glTexCoord4fColor4fNormal3fVertex4fSUN(s, t, p, q, r, g, b, a, nx, ny, nz, x, y, z, w);
  }

  public void glTexCoord4fColor4fNormal3fVertex4fvSUN(Addressable tc, Addressable c, Addressable n, Addressable v) {
    glext_h.glTexCoord4fColor4fNormal3fVertex4fvSUN(tc, c, n, v);
  }

  public void glTexCoord4fVertex4fSUN(float s, float t, float p, float q, float x, float y, float z, float w) {
    glext_h.glTexCoord4fVertex4fSUN(s, t, p, q, x, y, z, w);
  }

  public void glTexCoord4fVertex4fvSUN(Addressable tc, Addressable v) {
    glext_h.glTexCoord4fVertex4fvSUN(tc, v);
  }

  public void glTexCoord4hNV(short s, short t, short r, short q) {
    glext_h.glTexCoord4hNV(s, t, r, q);
  }

  public void glTexCoord4hvNV(Addressable v) {
    glext_h.glTexCoord4hvNV(v);
  }

  public void glTexCoord4xOES(int s, int t, int r, int q) {
    glext_h.glTexCoord4xOES(s, t, r, q);
  }

  public void glTexCoord4xvOES(Addressable coords) {
    glext_h.glTexCoord4xvOES(coords);
  }

  public void glTexCoordFormatNV(int size, int type, int stride) {
    glext_h.glTexCoordFormatNV(size, type, stride);
  }

  public void glTexCoordP1ui(int type, int coords) {
    glext_h.glTexCoordP1ui(type, coords);
  }

  public void glTexCoordP1uiv(int type, Addressable coords) {
    glext_h.glTexCoordP1uiv(type, coords);
  }

  public void glTexCoordP2ui(int type, int coords) {
    glext_h.glTexCoordP2ui(type, coords);
  }

  public void glTexCoordP2uiv(int type, Addressable coords) {
    glext_h.glTexCoordP2uiv(type, coords);
  }

  public void glTexCoordP3ui(int type, int coords) {
    glext_h.glTexCoordP3ui(type, coords);
  }

  public void glTexCoordP3uiv(int type, Addressable coords) {
    glext_h.glTexCoordP3uiv(type, coords);
  }

  public void glTexCoordP4ui(int type, int coords) {
    glext_h.glTexCoordP4ui(type, coords);
  }

  public void glTexCoordP4uiv(int type, Addressable coords) {
    glext_h.glTexCoordP4uiv(type, coords);
  }

  public void glTexCoordPointerEXT(int size, int type, int stride, int count, Addressable pointer) {
    glext_h.glTexCoordPointerEXT(size, type, stride, count, pointer);
  }

  public void glTexCoordPointerListIBM(int size, int type, int stride, Addressable pointer, int ptrstride) {
    glext_h.glTexCoordPointerListIBM(size, type, stride, pointer, ptrstride);
  }

  public void glTexCoordPointervINTEL(int size, int type, Addressable pointer) {
    glext_h.glTexCoordPointervINTEL(size, type, pointer);
  }

  public void glTexEnvxOES(int target, int pname, int param) {
    glext_h.glTexEnvxOES(target, pname, param);
  }

  public void glTexEnvxvOES(int target, int pname, Addressable params) {
    glext_h.glTexEnvxvOES(target, pname, params);
  }

  public void glTexFilterFuncSGIS(int target, int filter, int n, Addressable weights) {
    glext_h.glTexFilterFuncSGIS(target, filter, n, weights);
  }

  public void glTexGenxOES(int coord, int pname, int param) {
    glext_h.glTexGenxOES(coord, pname, param);
  }

  public void glTexGenxvOES(int coord, int pname, Addressable params) {
    glext_h.glTexGenxvOES(coord, pname, params);
  }

  public void glTexImage2DMultisample(int target, int samples, int internalformat, int width, int height, byte fixedsamplelocations) {
    glext_h.glTexImage2DMultisample(target, samples, internalformat, width, height, fixedsamplelocations);
  }

  public void glTexImage2DMultisampleCoverageNV(int target, int coverageSamples, int colorSamples, int internalFormat, int width, int height, byte fixedSampleLocations) {
    glext_h.glTexImage2DMultisampleCoverageNV(target, coverageSamples, colorSamples, internalFormat, width, height, fixedSampleLocations);
  }

  public void glTexImage3DEXT(int target, int level, int internalformat, int width, int height, int depth, int border, int format, int type, Addressable pixels) {
    glext_h.glTexImage3DEXT(target, level, internalformat, width, height, depth, border, format, type, pixels);
  }

  public void glTexImage3DMultisample(int target, int samples, int internalformat, int width, int height, int depth, byte fixedsamplelocations) {
    glext_h.glTexImage3DMultisample(target, samples, internalformat, width, height, depth, fixedsamplelocations);
  }

  public void glTexImage3DMultisampleCoverageNV(int target, int coverageSamples, int colorSamples, int internalFormat, int width, int height, int depth, byte fixedSampleLocations) {
    glext_h.glTexImage3DMultisampleCoverageNV(target, coverageSamples, colorSamples, internalFormat, width, height, depth, fixedSampleLocations);
  }

  public void glTexImage4DSGIS(int target, int level, int internalformat, int width, int height, int depth, int size4d, int border, int format, int type, Addressable pixels) {
    glext_h.glTexImage4DSGIS(target, level, internalformat, width, height, depth, size4d, border, format, type, pixels);
  }

  public void glTexPageCommitmentARB(int target, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, byte commit) {
    glext_h.glTexPageCommitmentARB(target, level, xoffset, yoffset, zoffset, width, height, depth, commit);
  }

  public void glTexParameterIiv(int target, int pname, Addressable params) {
    glext_h.glTexParameterIiv(target, pname, params);
  }

  public void glTexParameterIivEXT(int target, int pname, Addressable params) {
    glext_h.glTexParameterIivEXT(target, pname, params);
  }

  public void glTexParameterIuiv(int target, int pname, Addressable params) {
    glext_h.glTexParameterIuiv(target, pname, params);
  }

  public void glTexParameterIuivEXT(int target, int pname, Addressable params) {
    glext_h.glTexParameterIuivEXT(target, pname, params);
  }

  public void glTexParameterxOES(int target, int pname, int param) {
    glext_h.glTexParameterxOES(target, pname, param);
  }

  public void glTexParameterxvOES(int target, int pname, Addressable params) {
    glext_h.glTexParameterxvOES(target, pname, params);
  }

  public void glTexRenderbufferNV(int target, int renderbuffer) {
    glext_h.glTexRenderbufferNV(target, renderbuffer);
  }

  public void glTexStorage1D(int target, int levels, int internalformat, int width) {
    glext_h.glTexStorage1D(target, levels, internalformat, width);
  }

  public void glTexStorage2D(int target, int levels, int internalformat, int width, int height) {
    glext_h.glTexStorage2D(target, levels, internalformat, width, height);
  }

  public void glTexStorage2DMultisample(int target, int samples, int internalformat, int width, int height, byte fixedsamplelocations) {
    glext_h.glTexStorage2DMultisample(target, samples, internalformat, width, height, fixedsamplelocations);
  }

  public void glTexStorage3D(int target, int levels, int internalformat, int width, int height, int depth) {
    glext_h.glTexStorage3D(target, levels, internalformat, width, height, depth);
  }

  public void glTexStorage3DMultisample(int target, int samples, int internalformat, int width, int height, int depth, byte fixedsamplelocations) {
    glext_h.glTexStorage3DMultisample(target, samples, internalformat, width, height, depth, fixedsamplelocations);
  }

  public void glTexStorageMem1DEXT(int target, int levels, int internalFormat, int width, int memory, long offset) {
    glext_h.glTexStorageMem1DEXT(target, levels, internalFormat, width, memory, offset);
  }

  public void glTexStorageMem2DEXT(int target, int levels, int internalFormat, int width, int height, int memory, long offset) {
    glext_h.glTexStorageMem2DEXT(target, levels, internalFormat, width, height, memory, offset);
  }

  public void glTexStorageMem2DMultisampleEXT(int target, int samples, int internalFormat, int width, int height, byte fixedSampleLocations, int memory, long offset) {
    glext_h.glTexStorageMem2DMultisampleEXT(target, samples, internalFormat, width, height, fixedSampleLocations, memory, offset);
  }

  public void glTexStorageMem3DEXT(int target, int levels, int internalFormat, int width, int height, int depth, int memory, long offset) {
    glext_h.glTexStorageMem3DEXT(target, levels, internalFormat, width, height, depth, memory, offset);
  }

  public void glTexStorageMem3DMultisampleEXT(int target, int samples, int internalFormat, int width, int height, int depth, byte fixedSampleLocations, int memory, long offset) {
    glext_h.glTexStorageMem3DMultisampleEXT(target, samples, internalFormat, width, height, depth, fixedSampleLocations, memory, offset);
  }

  public void glTexStorageSparseAMD(int target, int internalFormat, int width, int height, int depth, int layers, int flags) {
    glext_h.glTexStorageSparseAMD(target, internalFormat, width, height, depth, layers, flags);
  }

  public void glTexSubImage1DEXT(int target, int level, int xoffset, int width, int format, int type, Addressable pixels) {
    glext_h.glTexSubImage1DEXT(target, level, xoffset, width, format, type, pixels);
  }

  public void glTexSubImage2DEXT(int target, int level, int xoffset, int yoffset, int width, int height, int format, int type, Addressable pixels) {
    glext_h.glTexSubImage2DEXT(target, level, xoffset, yoffset, width, height, format, type, pixels);
  }

  public void glTexSubImage3DEXT(int target, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int format, int type, Addressable pixels) {
    glext_h.glTexSubImage3DEXT(target, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels);
  }

  public void glTexSubImage4DSGIS(int target, int level, int xoffset, int yoffset, int zoffset, int woffset, int width, int height, int depth, int size4d, int format, int type, Addressable pixels) {
    glext_h.glTexSubImage4DSGIS(target, level, xoffset, yoffset, zoffset, woffset, width, height, depth, size4d, format, type, pixels);
  }

  public void glTextureAttachMemoryNV(int texture, int memory, long offset) {
    glext_h.glTextureAttachMemoryNV(texture, memory, offset);
  }

  public void glTextureBarrier() {
    glext_h.glTextureBarrier();
  }

  public void glTextureBarrierNV() {
    glext_h.glTextureBarrierNV();
  }

  public void glTextureBuffer(int texture, int internalformat, int buffer) {
    glext_h.glTextureBuffer(texture, internalformat, buffer);
  }

  public void glTextureBufferEXT(int texture, int target, int internalformat, int buffer) {
    glext_h.glTextureBufferEXT(texture, target, internalformat, buffer);
  }

  public void glTextureBufferRange(int texture, int internalformat, int buffer, long offset, long size) {
    glext_h.glTextureBufferRange(texture, internalformat, buffer, offset, size);
  }

  public void glTextureBufferRangeEXT(int texture, int target, int internalformat, int buffer, long offset, long size) {
    glext_h.glTextureBufferRangeEXT(texture, target, internalformat, buffer, offset, size);
  }

  public void glTextureColorMaskSGIS(byte red, byte green, byte blue, byte alpha) {
    glext_h.glTextureColorMaskSGIS(red, green, blue, alpha);
  }

  public void glTextureImage1DEXT(int texture, int target, int level, int internalformat, int width, int border, int format, int type, Addressable pixels) {
    glext_h.glTextureImage1DEXT(texture, target, level, internalformat, width, border, format, type, pixels);
  }

  public void glTextureImage2DEXT(int texture, int target, int level, int internalformat, int width, int height, int border, int format, int type, Addressable pixels) {
    glext_h.glTextureImage2DEXT(texture, target, level, internalformat, width, height, border, format, type, pixels);
  }

  public void glTextureImage2DMultisampleCoverageNV(int texture, int target, int coverageSamples, int colorSamples, int internalFormat, int width, int height, byte fixedSampleLocations) {
    glext_h.glTextureImage2DMultisampleCoverageNV(texture, target, coverageSamples, colorSamples, internalFormat, width, height, fixedSampleLocations);
  }

  public void glTextureImage2DMultisampleNV(int texture, int target, int samples, int internalFormat, int width, int height, byte fixedSampleLocations) {
    glext_h.glTextureImage2DMultisampleNV(texture, target, samples, internalFormat, width, height, fixedSampleLocations);
  }

  public void glTextureImage3DEXT(int texture, int target, int level, int internalformat, int width, int height, int depth, int border, int format, int type, Addressable pixels) {
    glext_h.glTextureImage3DEXT(texture, target, level, internalformat, width, height, depth, border, format, type, pixels);
  }

  public void glTextureImage3DMultisampleCoverageNV(int texture, int target, int coverageSamples, int colorSamples, int internalFormat, int width, int height, int depth, byte fixedSampleLocations) {
    glext_h.glTextureImage3DMultisampleCoverageNV(texture, target, coverageSamples, colorSamples, internalFormat, width, height, depth, fixedSampleLocations);
  }

  public void glTextureImage3DMultisampleNV(int texture, int target, int samples, int internalFormat, int width, int height, int depth, byte fixedSampleLocations) {
    glext_h.glTextureImage3DMultisampleNV(texture, target, samples, internalFormat, width, height, depth, fixedSampleLocations);
  }

  public void glTextureLightEXT(int pname) {
    glext_h.glTextureLightEXT(pname);
  }

  public void glTextureMaterialEXT(int face, int mode) {
    glext_h.glTextureMaterialEXT(face, mode);
  }

  public void glTextureNormalEXT(int mode) {
    glext_h.glTextureNormalEXT(mode);
  }

  public void glTexturePageCommitmentEXT(int texture, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, byte commit) {
    glext_h.glTexturePageCommitmentEXT(texture, level, xoffset, yoffset, zoffset, width, height, depth, commit);
  }

  public void glTextureParameterIiv(int texture, int pname, Addressable params) {
    glext_h.glTextureParameterIiv(texture, pname, params);
  }

  public void glTextureParameterIivEXT(int texture, int target, int pname, Addressable params) {
    glext_h.glTextureParameterIivEXT(texture, target, pname, params);
  }

  public void glTextureParameterIuiv(int texture, int pname, Addressable params) {
    glext_h.glTextureParameterIuiv(texture, pname, params);
  }

  public void glTextureParameterIuivEXT(int texture, int target, int pname, Addressable params) {
    glext_h.glTextureParameterIuivEXT(texture, target, pname, params);
  }

  public void glTextureParameterf(int texture, int pname, float param) {
    glext_h.glTextureParameterf(texture, pname, param);
  }

  public void glTextureParameterfEXT(int texture, int target, int pname, float param) {
    glext_h.glTextureParameterfEXT(texture, target, pname, param);
  }

  public void glTextureParameterfv(int texture, int pname, Addressable param) {
    glext_h.glTextureParameterfv(texture, pname, param);
  }

  public void glTextureParameterfvEXT(int texture, int target, int pname, Addressable params) {
    glext_h.glTextureParameterfvEXT(texture, target, pname, params);
  }

  public void glTextureParameteri(int texture, int pname, int param) {
    glext_h.glTextureParameteri(texture, pname, param);
  }

  public void glTextureParameteriEXT(int texture, int target, int pname, int param) {
    glext_h.glTextureParameteriEXT(texture, target, pname, param);
  }

  public void glTextureParameteriv(int texture, int pname, Addressable param) {
    glext_h.glTextureParameteriv(texture, pname, param);
  }

  public void glTextureParameterivEXT(int texture, int target, int pname, Addressable params) {
    glext_h.glTextureParameterivEXT(texture, target, pname, params);
  }

  public void glTextureRangeAPPLE(int target, int length, Addressable pointer) {
    glext_h.glTextureRangeAPPLE(target, length, pointer);
  }

  public void glTextureRenderbufferEXT(int texture, int target, int renderbuffer) {
    glext_h.glTextureRenderbufferEXT(texture, target, renderbuffer);
  }

  public void glTextureStorage1D(int texture, int levels, int internalformat, int width) {
    glext_h.glTextureStorage1D(texture, levels, internalformat, width);
  }

  public void glTextureStorage1DEXT(int texture, int target, int levels, int internalformat, int width) {
    glext_h.glTextureStorage1DEXT(texture, target, levels, internalformat, width);
  }

  public void glTextureStorage2D(int texture, int levels, int internalformat, int width, int height) {
    glext_h.glTextureStorage2D(texture, levels, internalformat, width, height);
  }

  public void glTextureStorage2DEXT(int texture, int target, int levels, int internalformat, int width, int height) {
    glext_h.glTextureStorage2DEXT(texture, target, levels, internalformat, width, height);
  }

  public void glTextureStorage2DMultisample(int texture, int samples, int internalformat, int width, int height, byte fixedsamplelocations) {
    glext_h.glTextureStorage2DMultisample(texture, samples, internalformat, width, height, fixedsamplelocations);
  }

  public void glTextureStorage2DMultisampleEXT(int texture, int target, int samples, int internalformat, int width, int height, byte fixedsamplelocations) {
    glext_h.glTextureStorage2DMultisampleEXT(texture, target, samples, internalformat, width, height, fixedsamplelocations);
  }

  public void glTextureStorage3D(int texture, int levels, int internalformat, int width, int height, int depth) {
    glext_h.glTextureStorage3D(texture, levels, internalformat, width, height, depth);
  }

  public void glTextureStorage3DEXT(int texture, int target, int levels, int internalformat, int width, int height, int depth) {
    glext_h.glTextureStorage3DEXT(texture, target, levels, internalformat, width, height, depth);
  }

  public void glTextureStorage3DMultisample(int texture, int samples, int internalformat, int width, int height, int depth, byte fixedsamplelocations) {
    glext_h.glTextureStorage3DMultisample(texture, samples, internalformat, width, height, depth, fixedsamplelocations);
  }

  public void glTextureStorage3DMultisampleEXT(int texture, int target, int samples, int internalformat, int width, int height, int depth, byte fixedsamplelocations) {
    glext_h.glTextureStorage3DMultisampleEXT(texture, target, samples, internalformat, width, height, depth, fixedsamplelocations);
  }

  public void glTextureStorageMem1DEXT(int texture, int levels, int internalFormat, int width, int memory, long offset) {
    glext_h.glTextureStorageMem1DEXT(texture, levels, internalFormat, width, memory, offset);
  }

  public void glTextureStorageMem2DEXT(int texture, int levels, int internalFormat, int width, int height, int memory, long offset) {
    glext_h.glTextureStorageMem2DEXT(texture, levels, internalFormat, width, height, memory, offset);
  }

  public void glTextureStorageMem2DMultisampleEXT(int texture, int samples, int internalFormat, int width, int height, byte fixedSampleLocations, int memory, long offset) {
    glext_h.glTextureStorageMem2DMultisampleEXT(texture, samples, internalFormat, width, height, fixedSampleLocations, memory, offset);
  }

  public void glTextureStorageMem3DEXT(int texture, int levels, int internalFormat, int width, int height, int depth, int memory, long offset) {
    glext_h.glTextureStorageMem3DEXT(texture, levels, internalFormat, width, height, depth, memory, offset);
  }

  public void glTextureStorageMem3DMultisampleEXT(int texture, int samples, int internalFormat, int width, int height, int depth, byte fixedSampleLocations, int memory, long offset) {
    glext_h.glTextureStorageMem3DMultisampleEXT(texture, samples, internalFormat, width, height, depth, fixedSampleLocations, memory, offset);
  }

  public void glTextureStorageSparseAMD(int texture, int target, int internalFormat, int width, int height, int depth, int layers, int flags) {
    glext_h.glTextureStorageSparseAMD(texture, target, internalFormat, width, height, depth, layers, flags);
  }

  public void glTextureSubImage1D(int texture, int level, int xoffset, int width, int format, int type, Addressable pixels) {
    glext_h.glTextureSubImage1D(texture, level, xoffset, width, format, type, pixels);
  }

  public void glTextureSubImage1DEXT(int texture, int target, int level, int xoffset, int width, int format, int type, Addressable pixels) {
    glext_h.glTextureSubImage1DEXT(texture, target, level, xoffset, width, format, type, pixels);
  }

  public void glTextureSubImage2D(int texture, int level, int xoffset, int yoffset, int width, int height, int format, int type, Addressable pixels) {
    glext_h.glTextureSubImage2D(texture, level, xoffset, yoffset, width, height, format, type, pixels);
  }

  public void glTextureSubImage2DEXT(int texture, int target, int level, int xoffset, int yoffset, int width, int height, int format, int type, Addressable pixels) {
    glext_h.glTextureSubImage2DEXT(texture, target, level, xoffset, yoffset, width, height, format, type, pixels);
  }

  public void glTextureSubImage3D(int texture, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int format, int type, Addressable pixels) {
    glext_h.glTextureSubImage3D(texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels);
  }

  public void glTextureSubImage3DEXT(int texture, int target, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int format, int type, Addressable pixels) {
    glext_h.glTextureSubImage3DEXT(texture, target, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels);
  }

  public void glTextureView(int texture, int target, int origtexture, int internalformat, int minlevel, int numlevels, int minlayer, int numlayers) {
    glext_h.glTextureView(texture, target, origtexture, internalformat, minlevel, numlevels, minlayer, numlayers);
  }

  public void glTrackMatrixNV(int target, int address, int matrix, int transform) {
    glext_h.glTrackMatrixNV(target, address, matrix, transform);
  }

  public void glTransformFeedbackAttribsNV(int count, Addressable attribs, int bufferMode) {
    glext_h.glTransformFeedbackAttribsNV(count, attribs, bufferMode);
  }

  public void glTransformFeedbackBufferBase(int xfb, int index, int buffer) {
    glext_h.glTransformFeedbackBufferBase(xfb, index, buffer);
  }

  public void glTransformFeedbackBufferRange(int xfb, int index, int buffer, long offset, long size) {
    glext_h.glTransformFeedbackBufferRange(xfb, index, buffer, offset, size);
  }

  public void glTransformFeedbackStreamAttribsNV(int count, Addressable attribs, int nbuffers, Addressable bufstreams, int bufferMode) {
    glext_h.glTransformFeedbackStreamAttribsNV(count, attribs, nbuffers, bufstreams, bufferMode);
  }

  public void glTransformFeedbackVaryings(int program, int count, Addressable varyings, int bufferMode) {
    glext_h.glTransformFeedbackVaryings(program, count, varyings, bufferMode);
  }

  public void glTransformFeedbackVaryingsEXT(int program, int count, Addressable varyings, int bufferMode) {
    glext_h.glTransformFeedbackVaryingsEXT(program, count, varyings, bufferMode);
  }

  public void glTransformFeedbackVaryingsNV(int program, int count, Addressable locations, int bufferMode) {
    glext_h.glTransformFeedbackVaryingsNV(program, count, locations, bufferMode);
  }

  public void glTransformPathNV(int resultPath, int srcPath, int transformType, Addressable transformValues) {
    glext_h.glTransformPathNV(resultPath, srcPath, transformType, transformValues);
  }

  public void glTranslatexOES(int x, int y, int z) {
    glext_h.glTranslatexOES(x, y, z);
  }

  public void glUniform1d(int location, double x) {
    glext_h.glUniform1d(location, x);
  }

  public void glUniform1dv(int location, int count, Addressable value) {
    glext_h.glUniform1dv(location, count, value);
  }

  public void glUniform1f(int location, float v0) {
    glext_h.glUniform1f(location, v0);
  }

  public void glUniform1fARB(int location, float v0) {
    glext_h.glUniform1fARB(location, v0);
  }

  public void glUniform1fv(int location, int count, Addressable value) {
    glext_h.glUniform1fv(location, count, value);
  }

  public void glUniform1fvARB(int location, int count, Addressable value) {
    glext_h.glUniform1fvARB(location, count, value);
  }

  public void glUniform1i(int location, int v0) {
    glext_h.glUniform1i(location, v0);
  }

  public void glUniform1i64ARB(int location, long x) {
    glext_h.glUniform1i64ARB(location, x);
  }

  public void glUniform1i64NV(int location, long x) {
    glext_h.glUniform1i64NV(location, x);
  }

  public void glUniform1i64vARB(int location, int count, Addressable value) {
    glext_h.glUniform1i64vARB(location, count, value);
  }

  public void glUniform1i64vNV(int location, int count, Addressable value) {
    glext_h.glUniform1i64vNV(location, count, value);
  }

  public void glUniform1iARB(int location, int v0) {
    glext_h.glUniform1iARB(location, v0);
  }

  public void glUniform1iv(int location, int count, Addressable value) {
    glext_h.glUniform1iv(location, count, value);
  }

  public void glUniform1ivARB(int location, int count, Addressable value) {
    glext_h.glUniform1ivARB(location, count, value);
  }

  public void glUniform1ui(int location, int v0) {
    glext_h.glUniform1ui(location, v0);
  }

  public void glUniform1ui64ARB(int location, long x) {
    glext_h.glUniform1ui64ARB(location, x);
  }

  public void glUniform1ui64NV(int location, long x) {
    glext_h.glUniform1ui64NV(location, x);
  }

  public void glUniform1ui64vARB(int location, int count, Addressable value) {
    glext_h.glUniform1ui64vARB(location, count, value);
  }

  public void glUniform1ui64vNV(int location, int count, Addressable value) {
    glext_h.glUniform1ui64vNV(location, count, value);
  }

  public void glUniform1uiEXT(int location, int v0) {
    glext_h.glUniform1uiEXT(location, v0);
  }

  public void glUniform1uiv(int location, int count, Addressable value) {
    glext_h.glUniform1uiv(location, count, value);
  }

  public void glUniform1uivEXT(int location, int count, Addressable value) {
    glext_h.glUniform1uivEXT(location, count, value);
  }

  public void glUniform2d(int location, double x, double y) {
    glext_h.glUniform2d(location, x, y);
  }

  public void glUniform2dv(int location, int count, Addressable value) {
    glext_h.glUniform2dv(location, count, value);
  }

  public void glUniform2f(int location, float v0, float v1) {
    glext_h.glUniform2f(location, v0, v1);
  }

  public void glUniform2fARB(int location, float v0, float v1) {
    glext_h.glUniform2fARB(location, v0, v1);
  }

  public void glUniform2fv(int location, int count, Addressable value) {
    glext_h.glUniform2fv(location, count, value);
  }

  public void glUniform2fvARB(int location, int count, Addressable value) {
    glext_h.glUniform2fvARB(location, count, value);
  }

  public void glUniform2i(int location, int v0, int v1) {
    glext_h.glUniform2i(location, v0, v1);
  }

  public void glUniform2i64ARB(int location, long x, long y) {
    glext_h.glUniform2i64ARB(location, x, y);
  }

  public void glUniform2i64NV(int location, long x, long y) {
    glext_h.glUniform2i64NV(location, x, y);
  }

  public void glUniform2i64vARB(int location, int count, Addressable value) {
    glext_h.glUniform2i64vARB(location, count, value);
  }

  public void glUniform2i64vNV(int location, int count, Addressable value) {
    glext_h.glUniform2i64vNV(location, count, value);
  }

  public void glUniform2iARB(int location, int v0, int v1) {
    glext_h.glUniform2iARB(location, v0, v1);
  }

  public void glUniform2iv(int location, int count, Addressable value) {
    glext_h.glUniform2iv(location, count, value);
  }

  public void glUniform2ivARB(int location, int count, Addressable value) {
    glext_h.glUniform2ivARB(location, count, value);
  }

  public void glUniform2ui(int location, int v0, int v1) {
    glext_h.glUniform2ui(location, v0, v1);
  }

  public void glUniform2ui64ARB(int location, long x, long y) {
    glext_h.glUniform2ui64ARB(location, x, y);
  }

  public void glUniform2ui64NV(int location, long x, long y) {
    glext_h.glUniform2ui64NV(location, x, y);
  }

  public void glUniform2ui64vARB(int location, int count, Addressable value) {
    glext_h.glUniform2ui64vARB(location, count, value);
  }

  public void glUniform2ui64vNV(int location, int count, Addressable value) {
    glext_h.glUniform2ui64vNV(location, count, value);
  }

  public void glUniform2uiEXT(int location, int v0, int v1) {
    glext_h.glUniform2uiEXT(location, v0, v1);
  }

  public void glUniform2uiv(int location, int count, Addressable value) {
    glext_h.glUniform2uiv(location, count, value);
  }

  public void glUniform2uivEXT(int location, int count, Addressable value) {
    glext_h.glUniform2uivEXT(location, count, value);
  }

  public void glUniform3d(int location, double x, double y, double z) {
    glext_h.glUniform3d(location, x, y, z);
  }

  public void glUniform3dv(int location, int count, Addressable value) {
    glext_h.glUniform3dv(location, count, value);
  }

  public void glUniform3f(int location, float v0, float v1, float v2) {
    glext_h.glUniform3f(location, v0, v1, v2);
  }

  public void glUniform3fARB(int location, float v0, float v1, float v2) {
    glext_h.glUniform3fARB(location, v0, v1, v2);
  }

  public void glUniform3fv(int location, int count, Addressable value) {
    glext_h.glUniform3fv(location, count, value);
  }

  public void glUniform3fvARB(int location, int count, Addressable value) {
    glext_h.glUniform3fvARB(location, count, value);
  }

  public void glUniform3i(int location, int v0, int v1, int v2) {
    glext_h.glUniform3i(location, v0, v1, v2);
  }

  public void glUniform3i64ARB(int location, long x, long y, long z) {
    glext_h.glUniform3i64ARB(location, x, y, z);
  }

  public void glUniform3i64NV(int location, long x, long y, long z) {
    glext_h.glUniform3i64NV(location, x, y, z);
  }

  public void glUniform3i64vARB(int location, int count, Addressable value) {
    glext_h.glUniform3i64vARB(location, count, value);
  }

  public void glUniform3i64vNV(int location, int count, Addressable value) {
    glext_h.glUniform3i64vNV(location, count, value);
  }

  public void glUniform3iARB(int location, int v0, int v1, int v2) {
    glext_h.glUniform3iARB(location, v0, v1, v2);
  }

  public void glUniform3iv(int location, int count, Addressable value) {
    glext_h.glUniform3iv(location, count, value);
  }

  public void glUniform3ivARB(int location, int count, Addressable value) {
    glext_h.glUniform3ivARB(location, count, value);
  }

  public void glUniform3ui(int location, int v0, int v1, int v2) {
    glext_h.glUniform3ui(location, v0, v1, v2);
  }

  public void glUniform3ui64ARB(int location, long x, long y, long z) {
    glext_h.glUniform3ui64ARB(location, x, y, z);
  }

  public void glUniform3ui64NV(int location, long x, long y, long z) {
    glext_h.glUniform3ui64NV(location, x, y, z);
  }

  public void glUniform3ui64vARB(int location, int count, Addressable value) {
    glext_h.glUniform3ui64vARB(location, count, value);
  }

  public void glUniform3ui64vNV(int location, int count, Addressable value) {
    glext_h.glUniform3ui64vNV(location, count, value);
  }

  public void glUniform3uiEXT(int location, int v0, int v1, int v2) {
    glext_h.glUniform3uiEXT(location, v0, v1, v2);
  }

  public void glUniform3uiv(int location, int count, Addressable value) {
    glext_h.glUniform3uiv(location, count, value);
  }

  public void glUniform3uivEXT(int location, int count, Addressable value) {
    glext_h.glUniform3uivEXT(location, count, value);
  }

  public void glUniform4d(int location, double x, double y, double z, double w) {
    glext_h.glUniform4d(location, x, y, z, w);
  }

  public void glUniform4dv(int location, int count, Addressable value) {
    glext_h.glUniform4dv(location, count, value);
  }

  public void glUniform4f(int location, float v0, float v1, float v2, float v3) {
    glext_h.glUniform4f(location, v0, v1, v2, v3);
  }

  public void glUniform4fARB(int location, float v0, float v1, float v2, float v3) {
    glext_h.glUniform4fARB(location, v0, v1, v2, v3);
  }

  public void glUniform4fv(int location, int count, Addressable value) {
    glext_h.glUniform4fv(location, count, value);
  }

  public void glUniform4fvARB(int location, int count, Addressable value) {
    glext_h.glUniform4fvARB(location, count, value);
  }

  public void glUniform4i(int location, int v0, int v1, int v2, int v3) {
    glext_h.glUniform4i(location, v0, v1, v2, v3);
  }

  public void glUniform4i64ARB(int location, long x, long y, long z, long w) {
    glext_h.glUniform4i64ARB(location, x, y, z, w);
  }

  public void glUniform4i64NV(int location, long x, long y, long z, long w) {
    glext_h.glUniform4i64NV(location, x, y, z, w);
  }

  public void glUniform4i64vARB(int location, int count, Addressable value) {
    glext_h.glUniform4i64vARB(location, count, value);
  }

  public void glUniform4i64vNV(int location, int count, Addressable value) {
    glext_h.glUniform4i64vNV(location, count, value);
  }

  public void glUniform4iARB(int location, int v0, int v1, int v2, int v3) {
    glext_h.glUniform4iARB(location, v0, v1, v2, v3);
  }

  public void glUniform4iv(int location, int count, Addressable value) {
    glext_h.glUniform4iv(location, count, value);
  }

  public void glUniform4ivARB(int location, int count, Addressable value) {
    glext_h.glUniform4ivARB(location, count, value);
  }

  public void glUniform4ui(int location, int v0, int v1, int v2, int v3) {
    glext_h.glUniform4ui(location, v0, v1, v2, v3);
  }

  public void glUniform4ui64ARB(int location, long x, long y, long z, long w) {
    glext_h.glUniform4ui64ARB(location, x, y, z, w);
  }

  public void glUniform4ui64NV(int location, long x, long y, long z, long w) {
    glext_h.glUniform4ui64NV(location, x, y, z, w);
  }

  public void glUniform4ui64vARB(int location, int count, Addressable value) {
    glext_h.glUniform4ui64vARB(location, count, value);
  }

  public void glUniform4ui64vNV(int location, int count, Addressable value) {
    glext_h.glUniform4ui64vNV(location, count, value);
  }

  public void glUniform4uiEXT(int location, int v0, int v1, int v2, int v3) {
    glext_h.glUniform4uiEXT(location, v0, v1, v2, v3);
  }

  public void glUniform4uiv(int location, int count, Addressable value) {
    glext_h.glUniform4uiv(location, count, value);
  }

  public void glUniform4uivEXT(int location, int count, Addressable value) {
    glext_h.glUniform4uivEXT(location, count, value);
  }

  public void glUniformBlockBinding(int program, int uniformBlockIndex, int uniformBlockBinding) {
    glext_h.glUniformBlockBinding(program, uniformBlockIndex, uniformBlockBinding);
  }

  public void glUniformBufferEXT(int program, int location, int buffer) {
    glext_h.glUniformBufferEXT(program, location, buffer);
  }

  public void glUniformHandleui64ARB(int location, long value) {
    glext_h.glUniformHandleui64ARB(location, value);
  }

  public void glUniformHandleui64NV(int location, long value) {
    glext_h.glUniformHandleui64NV(location, value);
  }

  public void glUniformHandleui64vARB(int location, int count, Addressable value) {
    glext_h.glUniformHandleui64vARB(location, count, value);
  }

  public void glUniformHandleui64vNV(int location, int count, Addressable value) {
    glext_h.glUniformHandleui64vNV(location, count, value);
  }

  public void glUniformMatrix2dv(int location, int count, byte transpose, Addressable value) {
    glext_h.glUniformMatrix2dv(location, count, transpose, value);
  }

  public void glUniformMatrix2fv(int location, int count, byte transpose, Addressable value) {
    glext_h.glUniformMatrix2fv(location, count, transpose, value);
  }

  public void glUniformMatrix2fvARB(int location, int count, byte transpose, Addressable value) {
    glext_h.glUniformMatrix2fvARB(location, count, transpose, value);
  }

  public void glUniformMatrix2x3dv(int location, int count, byte transpose, Addressable value) {
    glext_h.glUniformMatrix2x3dv(location, count, transpose, value);
  }

  public void glUniformMatrix2x3fv(int location, int count, byte transpose, Addressable value) {
    glext_h.glUniformMatrix2x3fv(location, count, transpose, value);
  }

  public void glUniformMatrix2x4dv(int location, int count, byte transpose, Addressable value) {
    glext_h.glUniformMatrix2x4dv(location, count, transpose, value);
  }

  public void glUniformMatrix2x4fv(int location, int count, byte transpose, Addressable value) {
    glext_h.glUniformMatrix2x4fv(location, count, transpose, value);
  }

  public void glUniformMatrix3dv(int location, int count, byte transpose, Addressable value) {
    glext_h.glUniformMatrix3dv(location, count, transpose, value);
  }

  public void glUniformMatrix3fv(int location, int count, byte transpose, Addressable value) {
    glext_h.glUniformMatrix3fv(location, count, transpose, value);
  }

  public void glUniformMatrix3fvARB(int location, int count, byte transpose, Addressable value) {
    glext_h.glUniformMatrix3fvARB(location, count, transpose, value);
  }

  public void glUniformMatrix3x2dv(int location, int count, byte transpose, Addressable value) {
    glext_h.glUniformMatrix3x2dv(location, count, transpose, value);
  }

  public void glUniformMatrix3x2fv(int location, int count, byte transpose, Addressable value) {
    glext_h.glUniformMatrix3x2fv(location, count, transpose, value);
  }

  public void glUniformMatrix3x4dv(int location, int count, byte transpose, Addressable value) {
    glext_h.glUniformMatrix3x4dv(location, count, transpose, value);
  }

  public void glUniformMatrix3x4fv(int location, int count, byte transpose, Addressable value) {
    glext_h.glUniformMatrix3x4fv(location, count, transpose, value);
  }

  public void glUniformMatrix4dv(int location, int count, byte transpose, Addressable value) {
    glext_h.glUniformMatrix4dv(location, count, transpose, value);
  }

  public void glUniformMatrix4fv(int location, int count, byte transpose, Addressable value) {
    glext_h.glUniformMatrix4fv(location, count, transpose, value);
  }

  public void glUniformMatrix4fvARB(int location, int count, byte transpose, Addressable value) {
    glext_h.glUniformMatrix4fvARB(location, count, transpose, value);
  }

  public void glUniformMatrix4x2dv(int location, int count, byte transpose, Addressable value) {
    glext_h.glUniformMatrix4x2dv(location, count, transpose, value);
  }

  public void glUniformMatrix4x2fv(int location, int count, byte transpose, Addressable value) {
    glext_h.glUniformMatrix4x2fv(location, count, transpose, value);
  }

  public void glUniformMatrix4x3dv(int location, int count, byte transpose, Addressable value) {
    glext_h.glUniformMatrix4x3dv(location, count, transpose, value);
  }

  public void glUniformMatrix4x3fv(int location, int count, byte transpose, Addressable value) {
    glext_h.glUniformMatrix4x3fv(location, count, transpose, value);
  }

  public void glUniformSubroutinesuiv(int shadertype, int count, Addressable indices) {
    glext_h.glUniformSubroutinesuiv(shadertype, count, indices);
  }

  public void glUniformui64NV(int location, long value) {
    glext_h.glUniformui64NV(location, value);
  }

  public void glUniformui64vNV(int location, int count, Addressable value) {
    glext_h.glUniformui64vNV(location, count, value);
  }

  public void glUnlockArraysEXT() {
    glext_h.glUnlockArraysEXT();
  }

  public byte glUnmapBuffer(int target) {
    return glext_h.glUnmapBuffer(target);
  }

  public byte glUnmapBufferARB(int target) {
    return glext_h.glUnmapBufferARB(target);
  }

  public byte glUnmapNamedBuffer(int buffer) {
    return glext_h.glUnmapNamedBuffer(buffer);
  }

  public byte glUnmapNamedBufferEXT(int buffer) {
    return glext_h.glUnmapNamedBufferEXT(buffer);
  }

  public void glUnmapObjectBufferATI(int buffer) {
    glext_h.glUnmapObjectBufferATI(buffer);
  }

  public void glUnmapTexture2DINTEL(int texture, int level) {
    glext_h.glUnmapTexture2DINTEL(texture, level);
  }

  public void glUpdateObjectBufferATI(int buffer, int offset, int size, Addressable pointer, int preserve) {
    glext_h.glUpdateObjectBufferATI(buffer, offset, size, pointer, preserve);
  }

  public void glUploadGpuMaskNVX(int mask) {
    glext_h.glUploadGpuMaskNVX(mask);
  }

  public void glUseProgram(int program) {
    glext_h.glUseProgram(program);
  }

  public void glUseProgramObjectARB(int programObj) {
    glext_h.glUseProgramObjectARB(programObj);
  }

  public void glUseProgramStages(int pipeline, int stages, int program) {
    glext_h.glUseProgramStages(pipeline, stages, program);
  }

  public void glUseShaderProgramEXT(int type, int program) {
    glext_h.glUseShaderProgramEXT(type, program);
  }

  public void glVDPAUFiniNV() {
    glext_h.glVDPAUFiniNV();
  }

  public void glVDPAUGetSurfaceivNV(long surface, int pname, int count, Addressable length, Addressable values) {
    glext_h.glVDPAUGetSurfaceivNV(surface, pname, count, length, values);
  }

  public void glVDPAUInitNV(Addressable vdpDevice, Addressable getProcAddress) {
    glext_h.glVDPAUInitNV(vdpDevice, getProcAddress);
  }

  public byte glVDPAUIsSurfaceNV(long surface) {
    return glext_h.glVDPAUIsSurfaceNV(surface);
  }

  public void glVDPAUMapSurfacesNV(int numSurfaces, Addressable surfaces) {
    glext_h.glVDPAUMapSurfacesNV(numSurfaces, surfaces);
  }

  public long glVDPAURegisterOutputSurfaceNV(Addressable vdpSurface, int target, int numTextureNames, Addressable textureNames) {
    return glext_h.glVDPAURegisterOutputSurfaceNV(vdpSurface, target, numTextureNames, textureNames);
  }

  public long glVDPAURegisterVideoSurfaceNV(Addressable vdpSurface, int target, int numTextureNames, Addressable textureNames) {
    return glext_h.glVDPAURegisterVideoSurfaceNV(vdpSurface, target, numTextureNames, textureNames);
  }

  public long glVDPAURegisterVideoSurfaceWithPictureStructureNV(Addressable vdpSurface, int target, int numTextureNames, Addressable textureNames, byte isFrameStructure) {
    return glext_h.glVDPAURegisterVideoSurfaceWithPictureStructureNV(vdpSurface, target, numTextureNames, textureNames, isFrameStructure);
  }

  public void glVDPAUSurfaceAccessNV(long surface, int access) {
    glext_h.glVDPAUSurfaceAccessNV(surface, access);
  }

  public void glVDPAUUnmapSurfacesNV(int numSurface, Addressable surfaces) {
    glext_h.glVDPAUUnmapSurfacesNV(numSurface, surfaces);
  }

  public void glVDPAUUnregisterSurfaceNV(long surface) {
    glext_h.glVDPAUUnregisterSurfaceNV(surface);
  }

  public void glValidateProgram(int program) {
    glext_h.glValidateProgram(program);
  }

  public void glValidateProgramARB(int programObj) {
    glext_h.glValidateProgramARB(programObj);
  }

  public void glValidateProgramPipeline(int pipeline) {
    glext_h.glValidateProgramPipeline(pipeline);
  }

  public void glVariantArrayObjectATI(int id, int type, int stride, int buffer, int offset) {
    glext_h.glVariantArrayObjectATI(id, type, stride, buffer, offset);
  }

  public void glVariantPointerEXT(int id, int type, int stride, Addressable addr) {
    glext_h.glVariantPointerEXT(id, type, stride, addr);
  }

  public void glVariantbvEXT(int id, Addressable addr) {
    glext_h.glVariantbvEXT(id, addr);
  }

  public void glVariantdvEXT(int id, Addressable addr) {
    glext_h.glVariantdvEXT(id, addr);
  }

  public void glVariantfvEXT(int id, Addressable addr) {
    glext_h.glVariantfvEXT(id, addr);
  }

  public void glVariantivEXT(int id, Addressable addr) {
    glext_h.glVariantivEXT(id, addr);
  }

  public void glVariantsvEXT(int id, Addressable addr) {
    glext_h.glVariantsvEXT(id, addr);
  }

  public void glVariantubvEXT(int id, Addressable addr) {
    glext_h.glVariantubvEXT(id, addr);
  }

  public void glVariantuivEXT(int id, Addressable addr) {
    glext_h.glVariantuivEXT(id, addr);
  }

  public void glVariantusvEXT(int id, Addressable addr) {
    glext_h.glVariantusvEXT(id, addr);
  }

  public void glVertex2bOES(byte x, byte y) {
    glext_h.glVertex2bOES(x, y);
  }

  public void glVertex2bvOES(Addressable coords) {
    glext_h.glVertex2bvOES(coords);
  }

  public void glVertex2hNV(short x, short y) {
    glext_h.glVertex2hNV(x, y);
  }

  public void glVertex2hvNV(Addressable v) {
    glext_h.glVertex2hvNV(v);
  }

  public void glVertex2xOES(int x) {
    glext_h.glVertex2xOES(x);
  }

  public void glVertex2xvOES(Addressable coords) {
    glext_h.glVertex2xvOES(coords);
  }

  public void glVertex3bOES(byte x, byte y, byte z) {
    glext_h.glVertex3bOES(x, y, z);
  }

  public void glVertex3bvOES(Addressable coords) {
    glext_h.glVertex3bvOES(coords);
  }

  public void glVertex3hNV(short x, short y, short z) {
    glext_h.glVertex3hNV(x, y, z);
  }

  public void glVertex3hvNV(Addressable v) {
    glext_h.glVertex3hvNV(v);
  }

  public void glVertex3xOES(int x, int y) {
    glext_h.glVertex3xOES(x, y);
  }

  public void glVertex3xvOES(Addressable coords) {
    glext_h.glVertex3xvOES(coords);
  }

  public void glVertex4bOES(byte x, byte y, byte z, byte w) {
    glext_h.glVertex4bOES(x, y, z, w);
  }

  public void glVertex4bvOES(Addressable coords) {
    glext_h.glVertex4bvOES(coords);
  }

  public void glVertex4hNV(short x, short y, short z, short w) {
    glext_h.glVertex4hNV(x, y, z, w);
  }

  public void glVertex4hvNV(Addressable v) {
    glext_h.glVertex4hvNV(v);
  }

  public void glVertex4xOES(int x, int y, int z) {
    glext_h.glVertex4xOES(x, y, z);
  }

  public void glVertex4xvOES(Addressable coords) {
    glext_h.glVertex4xvOES(coords);
  }

  public void glVertexArrayAttribBinding(int vaobj, int attribindex, int bindingindex) {
    glext_h.glVertexArrayAttribBinding(vaobj, attribindex, bindingindex);
  }

  public void glVertexArrayAttribFormat(int vaobj, int attribindex, int size, int type, byte normalized, int relativeoffset) {
    glext_h.glVertexArrayAttribFormat(vaobj, attribindex, size, type, normalized, relativeoffset);
  }

  public void glVertexArrayAttribIFormat(int vaobj, int attribindex, int size, int type, int relativeoffset) {
    glext_h.glVertexArrayAttribIFormat(vaobj, attribindex, size, type, relativeoffset);
  }

  public void glVertexArrayAttribLFormat(int vaobj, int attribindex, int size, int type, int relativeoffset) {
    glext_h.glVertexArrayAttribLFormat(vaobj, attribindex, size, type, relativeoffset);
  }

  public void glVertexArrayBindVertexBufferEXT(int vaobj, int bindingindex, int buffer, long offset, int stride) {
    glext_h.glVertexArrayBindVertexBufferEXT(vaobj, bindingindex, buffer, offset, stride);
  }

  public void glVertexArrayBindingDivisor(int vaobj, int bindingindex, int divisor) {
    glext_h.glVertexArrayBindingDivisor(vaobj, bindingindex, divisor);
  }

  public void glVertexArrayColorOffsetEXT(int vaobj, int buffer, int size, int type, int stride, long offset) {
    glext_h.glVertexArrayColorOffsetEXT(vaobj, buffer, size, type, stride, offset);
  }

  public void glVertexArrayEdgeFlagOffsetEXT(int vaobj, int buffer, int stride, long offset) {
    glext_h.glVertexArrayEdgeFlagOffsetEXT(vaobj, buffer, stride, offset);
  }

  public void glVertexArrayElementBuffer(int vaobj, int buffer) {
    glext_h.glVertexArrayElementBuffer(vaobj, buffer);
  }

  public void glVertexArrayFogCoordOffsetEXT(int vaobj, int buffer, int type, int stride, long offset) {
    glext_h.glVertexArrayFogCoordOffsetEXT(vaobj, buffer, type, stride, offset);
  }

  public void glVertexArrayIndexOffsetEXT(int vaobj, int buffer, int type, int stride, long offset) {
    glext_h.glVertexArrayIndexOffsetEXT(vaobj, buffer, type, stride, offset);
  }

  public void glVertexArrayMultiTexCoordOffsetEXT(int vaobj, int buffer, int texunit, int size, int type, int stride, long offset) {
    glext_h.glVertexArrayMultiTexCoordOffsetEXT(vaobj, buffer, texunit, size, type, stride, offset);
  }

  public void glVertexArrayNormalOffsetEXT(int vaobj, int buffer, int type, int stride, long offset) {
    glext_h.glVertexArrayNormalOffsetEXT(vaobj, buffer, type, stride, offset);
  }

  public void glVertexArrayParameteriAPPLE(int pname, int param) {
    glext_h.glVertexArrayParameteriAPPLE(pname, param);
  }

  public void glVertexArrayRangeAPPLE(int length, Addressable pointer) {
    glext_h.glVertexArrayRangeAPPLE(length, pointer);
  }

  public void glVertexArrayRangeNV(int length, Addressable pointer) {
    glext_h.glVertexArrayRangeNV(length, pointer);
  }

  public void glVertexArraySecondaryColorOffsetEXT(int vaobj, int buffer, int size, int type, int stride, long offset) {
    glext_h.glVertexArraySecondaryColorOffsetEXT(vaobj, buffer, size, type, stride, offset);
  }

  public void glVertexArrayTexCoordOffsetEXT(int vaobj, int buffer, int size, int type, int stride, long offset) {
    glext_h.glVertexArrayTexCoordOffsetEXT(vaobj, buffer, size, type, stride, offset);
  }

  public void glVertexArrayVertexAttribBindingEXT(int vaobj, int attribindex, int bindingindex) {
    glext_h.glVertexArrayVertexAttribBindingEXT(vaobj, attribindex, bindingindex);
  }

  public void glVertexArrayVertexAttribDivisorEXT(int vaobj, int index, int divisor) {
    glext_h.glVertexArrayVertexAttribDivisorEXT(vaobj, index, divisor);
  }

  public void glVertexArrayVertexAttribFormatEXT(int vaobj, int attribindex, int size, int type, byte normalized, int relativeoffset) {
    glext_h.glVertexArrayVertexAttribFormatEXT(vaobj, attribindex, size, type, normalized, relativeoffset);
  }

  public void glVertexArrayVertexAttribIFormatEXT(int vaobj, int attribindex, int size, int type, int relativeoffset) {
    glext_h.glVertexArrayVertexAttribIFormatEXT(vaobj, attribindex, size, type, relativeoffset);
  }

  public void glVertexArrayVertexAttribIOffsetEXT(int vaobj, int buffer, int index, int size, int type, int stride, long offset) {
    glext_h.glVertexArrayVertexAttribIOffsetEXT(vaobj, buffer, index, size, type, stride, offset);
  }

  public void glVertexArrayVertexAttribLFormatEXT(int vaobj, int attribindex, int size, int type, int relativeoffset) {
    glext_h.glVertexArrayVertexAttribLFormatEXT(vaobj, attribindex, size, type, relativeoffset);
  }

  public void glVertexArrayVertexAttribLOffsetEXT(int vaobj, int buffer, int index, int size, int type, int stride, long offset) {
    glext_h.glVertexArrayVertexAttribLOffsetEXT(vaobj, buffer, index, size, type, stride, offset);
  }

  public void glVertexArrayVertexAttribOffsetEXT(int vaobj, int buffer, int index, int size, int type, byte normalized, int stride, long offset) {
    glext_h.glVertexArrayVertexAttribOffsetEXT(vaobj, buffer, index, size, type, normalized, stride, offset);
  }

  public void glVertexArrayVertexBindingDivisorEXT(int vaobj, int bindingindex, int divisor) {
    glext_h.glVertexArrayVertexBindingDivisorEXT(vaobj, bindingindex, divisor);
  }

  public void glVertexArrayVertexBuffer(int vaobj, int bindingindex, int buffer, long offset, int stride) {
    glext_h.glVertexArrayVertexBuffer(vaobj, bindingindex, buffer, offset, stride);
  }

  public void glVertexArrayVertexBuffers(int vaobj, int first, int count, Addressable buffers, Addressable offsets, Addressable strides) {
    glext_h.glVertexArrayVertexBuffers(vaobj, first, count, buffers, offsets, strides);
  }

  public void glVertexArrayVertexOffsetEXT(int vaobj, int buffer, int size, int type, int stride, long offset) {
    glext_h.glVertexArrayVertexOffsetEXT(vaobj, buffer, size, type, stride, offset);
  }

  public void glVertexAttrib1d(int index, double x) {
    glext_h.glVertexAttrib1d(index, x);
  }

  public void glVertexAttrib1dARB(int index, double x) {
    glext_h.glVertexAttrib1dARB(index, x);
  }

  public void glVertexAttrib1dNV(int index, double x) {
    glext_h.glVertexAttrib1dNV(index, x);
  }

  public void glVertexAttrib1dv(int index, Addressable v) {
    glext_h.glVertexAttrib1dv(index, v);
  }

  public void glVertexAttrib1dvARB(int index, Addressable v) {
    glext_h.glVertexAttrib1dvARB(index, v);
  }

  public void glVertexAttrib1dvNV(int index, Addressable v) {
    glext_h.glVertexAttrib1dvNV(index, v);
  }

  public void glVertexAttrib1f(int index, float x) {
    glext_h.glVertexAttrib1f(index, x);
  }

  public void glVertexAttrib1fARB(int index, float x) {
    glext_h.glVertexAttrib1fARB(index, x);
  }

  public void glVertexAttrib1fNV(int index, float x) {
    glext_h.glVertexAttrib1fNV(index, x);
  }

  public void glVertexAttrib1fv(int index, Addressable v) {
    glext_h.glVertexAttrib1fv(index, v);
  }

  public void glVertexAttrib1fvARB(int index, Addressable v) {
    glext_h.glVertexAttrib1fvARB(index, v);
  }

  public void glVertexAttrib1fvNV(int index, Addressable v) {
    glext_h.glVertexAttrib1fvNV(index, v);
  }

  public void glVertexAttrib1hNV(int index, short x) {
    glext_h.glVertexAttrib1hNV(index, x);
  }

  public void glVertexAttrib1hvNV(int index, Addressable v) {
    glext_h.glVertexAttrib1hvNV(index, v);
  }

  public void glVertexAttrib1s(int index, short x) {
    glext_h.glVertexAttrib1s(index, x);
  }

  public void glVertexAttrib1sARB(int index, short x) {
    glext_h.glVertexAttrib1sARB(index, x);
  }

  public void glVertexAttrib1sNV(int index, short x) {
    glext_h.glVertexAttrib1sNV(index, x);
  }

  public void glVertexAttrib1sv(int index, Addressable v) {
    glext_h.glVertexAttrib1sv(index, v);
  }

  public void glVertexAttrib1svARB(int index, Addressable v) {
    glext_h.glVertexAttrib1svARB(index, v);
  }

  public void glVertexAttrib1svNV(int index, Addressable v) {
    glext_h.glVertexAttrib1svNV(index, v);
  }

  public void glVertexAttrib2d(int index, double x, double y) {
    glext_h.glVertexAttrib2d(index, x, y);
  }

  public void glVertexAttrib2dARB(int index, double x, double y) {
    glext_h.glVertexAttrib2dARB(index, x, y);
  }

  public void glVertexAttrib2dNV(int index, double x, double y) {
    glext_h.glVertexAttrib2dNV(index, x, y);
  }

  public void glVertexAttrib2dv(int index, Addressable v) {
    glext_h.glVertexAttrib2dv(index, v);
  }

  public void glVertexAttrib2dvARB(int index, Addressable v) {
    glext_h.glVertexAttrib2dvARB(index, v);
  }

  public void glVertexAttrib2dvNV(int index, Addressable v) {
    glext_h.glVertexAttrib2dvNV(index, v);
  }

  public void glVertexAttrib2f(int index, float x, float y) {
    glext_h.glVertexAttrib2f(index, x, y);
  }

  public void glVertexAttrib2fARB(int index, float x, float y) {
    glext_h.glVertexAttrib2fARB(index, x, y);
  }

  public void glVertexAttrib2fNV(int index, float x, float y) {
    glext_h.glVertexAttrib2fNV(index, x, y);
  }

  public void glVertexAttrib2fv(int index, Addressable v) {
    glext_h.glVertexAttrib2fv(index, v);
  }

  public void glVertexAttrib2fvARB(int index, Addressable v) {
    glext_h.glVertexAttrib2fvARB(index, v);
  }

  public void glVertexAttrib2fvNV(int index, Addressable v) {
    glext_h.glVertexAttrib2fvNV(index, v);
  }

  public void glVertexAttrib2hNV(int index, short x, short y) {
    glext_h.glVertexAttrib2hNV(index, x, y);
  }

  public void glVertexAttrib2hvNV(int index, Addressable v) {
    glext_h.glVertexAttrib2hvNV(index, v);
  }

  public void glVertexAttrib2s(int index, short x, short y) {
    glext_h.glVertexAttrib2s(index, x, y);
  }

  public void glVertexAttrib2sARB(int index, short x, short y) {
    glext_h.glVertexAttrib2sARB(index, x, y);
  }

  public void glVertexAttrib2sNV(int index, short x, short y) {
    glext_h.glVertexAttrib2sNV(index, x, y);
  }

  public void glVertexAttrib2sv(int index, Addressable v) {
    glext_h.glVertexAttrib2sv(index, v);
  }

  public void glVertexAttrib2svARB(int index, Addressable v) {
    glext_h.glVertexAttrib2svARB(index, v);
  }

  public void glVertexAttrib2svNV(int index, Addressable v) {
    glext_h.glVertexAttrib2svNV(index, v);
  }

  public void glVertexAttrib3d(int index, double x, double y, double z) {
    glext_h.glVertexAttrib3d(index, x, y, z);
  }

  public void glVertexAttrib3dARB(int index, double x, double y, double z) {
    glext_h.glVertexAttrib3dARB(index, x, y, z);
  }

  public void glVertexAttrib3dNV(int index, double x, double y, double z) {
    glext_h.glVertexAttrib3dNV(index, x, y, z);
  }

  public void glVertexAttrib3dv(int index, Addressable v) {
    glext_h.glVertexAttrib3dv(index, v);
  }

  public void glVertexAttrib3dvARB(int index, Addressable v) {
    glext_h.glVertexAttrib3dvARB(index, v);
  }

  public void glVertexAttrib3dvNV(int index, Addressable v) {
    glext_h.glVertexAttrib3dvNV(index, v);
  }

  public void glVertexAttrib3f(int index, float x, float y, float z) {
    glext_h.glVertexAttrib3f(index, x, y, z);
  }

  public void glVertexAttrib3fARB(int index, float x, float y, float z) {
    glext_h.glVertexAttrib3fARB(index, x, y, z);
  }

  public void glVertexAttrib3fNV(int index, float x, float y, float z) {
    glext_h.glVertexAttrib3fNV(index, x, y, z);
  }

  public void glVertexAttrib3fv(int index, Addressable v) {
    glext_h.glVertexAttrib3fv(index, v);
  }

  public void glVertexAttrib3fvARB(int index, Addressable v) {
    glext_h.glVertexAttrib3fvARB(index, v);
  }

  public void glVertexAttrib3fvNV(int index, Addressable v) {
    glext_h.glVertexAttrib3fvNV(index, v);
  }

  public void glVertexAttrib3hNV(int index, short x, short y, short z) {
    glext_h.glVertexAttrib3hNV(index, x, y, z);
  }

  public void glVertexAttrib3hvNV(int index, Addressable v) {
    glext_h.glVertexAttrib3hvNV(index, v);
  }

  public void glVertexAttrib3s(int index, short x, short y, short z) {
    glext_h.glVertexAttrib3s(index, x, y, z);
  }

  public void glVertexAttrib3sARB(int index, short x, short y, short z) {
    glext_h.glVertexAttrib3sARB(index, x, y, z);
  }

  public void glVertexAttrib3sNV(int index, short x, short y, short z) {
    glext_h.glVertexAttrib3sNV(index, x, y, z);
  }

  public void glVertexAttrib3sv(int index, Addressable v) {
    glext_h.glVertexAttrib3sv(index, v);
  }

  public void glVertexAttrib3svARB(int index, Addressable v) {
    glext_h.glVertexAttrib3svARB(index, v);
  }

  public void glVertexAttrib3svNV(int index, Addressable v) {
    glext_h.glVertexAttrib3svNV(index, v);
  }

  public void glVertexAttrib4Nbv(int index, Addressable v) {
    glext_h.glVertexAttrib4Nbv(index, v);
  }

  public void glVertexAttrib4NbvARB(int index, Addressable v) {
    glext_h.glVertexAttrib4NbvARB(index, v);
  }

  public void glVertexAttrib4Niv(int index, Addressable v) {
    glext_h.glVertexAttrib4Niv(index, v);
  }

  public void glVertexAttrib4NivARB(int index, Addressable v) {
    glext_h.glVertexAttrib4NivARB(index, v);
  }

  public void glVertexAttrib4Nsv(int index, Addressable v) {
    glext_h.glVertexAttrib4Nsv(index, v);
  }

  public void glVertexAttrib4NsvARB(int index, Addressable v) {
    glext_h.glVertexAttrib4NsvARB(index, v);
  }

  public void glVertexAttrib4Nub(int index, byte x, byte y, byte z, byte w) {
    glext_h.glVertexAttrib4Nub(index, x, y, z, w);
  }

  public void glVertexAttrib4NubARB(int index, byte x, byte y, byte z, byte w) {
    glext_h.glVertexAttrib4NubARB(index, x, y, z, w);
  }

  public void glVertexAttrib4Nubv(int index, Addressable v) {
    glext_h.glVertexAttrib4Nubv(index, v);
  }

  public void glVertexAttrib4NubvARB(int index, Addressable v) {
    glext_h.glVertexAttrib4NubvARB(index, v);
  }

  public void glVertexAttrib4Nuiv(int index, Addressable v) {
    glext_h.glVertexAttrib4Nuiv(index, v);
  }

  public void glVertexAttrib4NuivARB(int index, Addressable v) {
    glext_h.glVertexAttrib4NuivARB(index, v);
  }

  public void glVertexAttrib4Nusv(int index, Addressable v) {
    glext_h.glVertexAttrib4Nusv(index, v);
  }

  public void glVertexAttrib4NusvARB(int index, Addressable v) {
    glext_h.glVertexAttrib4NusvARB(index, v);
  }

  public void glVertexAttrib4bv(int index, Addressable v) {
    glext_h.glVertexAttrib4bv(index, v);
  }

  public void glVertexAttrib4bvARB(int index, Addressable v) {
    glext_h.glVertexAttrib4bvARB(index, v);
  }

  public void glVertexAttrib4d(int index, double x, double y, double z, double w) {
    glext_h.glVertexAttrib4d(index, x, y, z, w);
  }

  public void glVertexAttrib4dARB(int index, double x, double y, double z, double w) {
    glext_h.glVertexAttrib4dARB(index, x, y, z, w);
  }

  public void glVertexAttrib4dNV(int index, double x, double y, double z, double w) {
    glext_h.glVertexAttrib4dNV(index, x, y, z, w);
  }

  public void glVertexAttrib4dv(int index, Addressable v) {
    glext_h.glVertexAttrib4dv(index, v);
  }

  public void glVertexAttrib4dvARB(int index, Addressable v) {
    glext_h.glVertexAttrib4dvARB(index, v);
  }

  public void glVertexAttrib4dvNV(int index, Addressable v) {
    glext_h.glVertexAttrib4dvNV(index, v);
  }

  public void glVertexAttrib4f(int index, float x, float y, float z, float w) {
    glext_h.glVertexAttrib4f(index, x, y, z, w);
  }

  public void glVertexAttrib4fARB(int index, float x, float y, float z, float w) {
    glext_h.glVertexAttrib4fARB(index, x, y, z, w);
  }

  public void glVertexAttrib4fNV(int index, float x, float y, float z, float w) {
    glext_h.glVertexAttrib4fNV(index, x, y, z, w);
  }

  public void glVertexAttrib4fv(int index, Addressable v) {
    glext_h.glVertexAttrib4fv(index, v);
  }

  public void glVertexAttrib4fvARB(int index, Addressable v) {
    glext_h.glVertexAttrib4fvARB(index, v);
  }

  public void glVertexAttrib4fvNV(int index, Addressable v) {
    glext_h.glVertexAttrib4fvNV(index, v);
  }

  public void glVertexAttrib4hNV(int index, short x, short y, short z, short w) {
    glext_h.glVertexAttrib4hNV(index, x, y, z, w);
  }

  public void glVertexAttrib4hvNV(int index, Addressable v) {
    glext_h.glVertexAttrib4hvNV(index, v);
  }

  public void glVertexAttrib4iv(int index, Addressable v) {
    glext_h.glVertexAttrib4iv(index, v);
  }

  public void glVertexAttrib4ivARB(int index, Addressable v) {
    glext_h.glVertexAttrib4ivARB(index, v);
  }

  public void glVertexAttrib4s(int index, short x, short y, short z, short w) {
    glext_h.glVertexAttrib4s(index, x, y, z, w);
  }

  public void glVertexAttrib4sARB(int index, short x, short y, short z, short w) {
    glext_h.glVertexAttrib4sARB(index, x, y, z, w);
  }

  public void glVertexAttrib4sNV(int index, short x, short y, short z, short w) {
    glext_h.glVertexAttrib4sNV(index, x, y, z, w);
  }

  public void glVertexAttrib4sv(int index, Addressable v) {
    glext_h.glVertexAttrib4sv(index, v);
  }

  public void glVertexAttrib4svARB(int index, Addressable v) {
    glext_h.glVertexAttrib4svARB(index, v);
  }

  public void glVertexAttrib4svNV(int index, Addressable v) {
    glext_h.glVertexAttrib4svNV(index, v);
  }

  public void glVertexAttrib4ubNV(int index, byte x, byte y, byte z, byte w) {
    glext_h.glVertexAttrib4ubNV(index, x, y, z, w);
  }

  public void glVertexAttrib4ubv(int index, Addressable v) {
    glext_h.glVertexAttrib4ubv(index, v);
  }

  public void glVertexAttrib4ubvARB(int index, Addressable v) {
    glext_h.glVertexAttrib4ubvARB(index, v);
  }

  public void glVertexAttrib4ubvNV(int index, Addressable v) {
    glext_h.glVertexAttrib4ubvNV(index, v);
  }

  public void glVertexAttrib4uiv(int index, Addressable v) {
    glext_h.glVertexAttrib4uiv(index, v);
  }

  public void glVertexAttrib4uivARB(int index, Addressable v) {
    glext_h.glVertexAttrib4uivARB(index, v);
  }

  public void glVertexAttrib4usv(int index, Addressable v) {
    glext_h.glVertexAttrib4usv(index, v);
  }

  public void glVertexAttrib4usvARB(int index, Addressable v) {
    glext_h.glVertexAttrib4usvARB(index, v);
  }

  public void glVertexAttribArrayObjectATI(int index, int size, int type, byte normalized, int stride, int buffer, int offset) {
    glext_h.glVertexAttribArrayObjectATI(index, size, type, normalized, stride, buffer, offset);
  }

  public void glVertexAttribBinding(int attribindex, int bindingindex) {
    glext_h.glVertexAttribBinding(attribindex, bindingindex);
  }

  public void glVertexAttribDivisor(int index, int divisor) {
    glext_h.glVertexAttribDivisor(index, divisor);
  }

  public void glVertexAttribDivisorARB(int index, int divisor) {
    glext_h.glVertexAttribDivisorARB(index, divisor);
  }

  public void glVertexAttribFormat(int attribindex, int size, int type, byte normalized, int relativeoffset) {
    glext_h.glVertexAttribFormat(attribindex, size, type, normalized, relativeoffset);
  }

  public void glVertexAttribFormatNV(int index, int size, int type, byte normalized, int stride) {
    glext_h.glVertexAttribFormatNV(index, size, type, normalized, stride);
  }

  public void glVertexAttribI1i(int index, int x) {
    glext_h.glVertexAttribI1i(index, x);
  }

  public void glVertexAttribI1iEXT(int index, int x) {
    glext_h.glVertexAttribI1iEXT(index, x);
  }

  public void glVertexAttribI1iv(int index, Addressable v) {
    glext_h.glVertexAttribI1iv(index, v);
  }

  public void glVertexAttribI1ivEXT(int index, Addressable v) {
    glext_h.glVertexAttribI1ivEXT(index, v);
  }

  public void glVertexAttribI1ui(int index, int x) {
    glext_h.glVertexAttribI1ui(index, x);
  }

  public void glVertexAttribI1uiEXT(int index, int x) {
    glext_h.glVertexAttribI1uiEXT(index, x);
  }

  public void glVertexAttribI1uiv(int index, Addressable v) {
    glext_h.glVertexAttribI1uiv(index, v);
  }

  public void glVertexAttribI1uivEXT(int index, Addressable v) {
    glext_h.glVertexAttribI1uivEXT(index, v);
  }

  public void glVertexAttribI2i(int index, int x, int y) {
    glext_h.glVertexAttribI2i(index, x, y);
  }

  public void glVertexAttribI2iEXT(int index, int x, int y) {
    glext_h.glVertexAttribI2iEXT(index, x, y);
  }

  public void glVertexAttribI2iv(int index, Addressable v) {
    glext_h.glVertexAttribI2iv(index, v);
  }

  public void glVertexAttribI2ivEXT(int index, Addressable v) {
    glext_h.glVertexAttribI2ivEXT(index, v);
  }

  public void glVertexAttribI2ui(int index, int x, int y) {
    glext_h.glVertexAttribI2ui(index, x, y);
  }

  public void glVertexAttribI2uiEXT(int index, int x, int y) {
    glext_h.glVertexAttribI2uiEXT(index, x, y);
  }

  public void glVertexAttribI2uiv(int index, Addressable v) {
    glext_h.glVertexAttribI2uiv(index, v);
  }

  public void glVertexAttribI2uivEXT(int index, Addressable v) {
    glext_h.glVertexAttribI2uivEXT(index, v);
  }

  public void glVertexAttribI3i(int index, int x, int y, int z) {
    glext_h.glVertexAttribI3i(index, x, y, z);
  }

  public void glVertexAttribI3iEXT(int index, int x, int y, int z) {
    glext_h.glVertexAttribI3iEXT(index, x, y, z);
  }

  public void glVertexAttribI3iv(int index, Addressable v) {
    glext_h.glVertexAttribI3iv(index, v);
  }

  public void glVertexAttribI3ivEXT(int index, Addressable v) {
    glext_h.glVertexAttribI3ivEXT(index, v);
  }

  public void glVertexAttribI3ui(int index, int x, int y, int z) {
    glext_h.glVertexAttribI3ui(index, x, y, z);
  }

  public void glVertexAttribI3uiEXT(int index, int x, int y, int z) {
    glext_h.glVertexAttribI3uiEXT(index, x, y, z);
  }

  public void glVertexAttribI3uiv(int index, Addressable v) {
    glext_h.glVertexAttribI3uiv(index, v);
  }

  public void glVertexAttribI3uivEXT(int index, Addressable v) {
    glext_h.glVertexAttribI3uivEXT(index, v);
  }

  public void glVertexAttribI4bv(int index, Addressable v) {
    glext_h.glVertexAttribI4bv(index, v);
  }

  public void glVertexAttribI4bvEXT(int index, Addressable v) {
    glext_h.glVertexAttribI4bvEXT(index, v);
  }

  public void glVertexAttribI4i(int index, int x, int y, int z, int w) {
    glext_h.glVertexAttribI4i(index, x, y, z, w);
  }

  public void glVertexAttribI4iEXT(int index, int x, int y, int z, int w) {
    glext_h.glVertexAttribI4iEXT(index, x, y, z, w);
  }

  public void glVertexAttribI4iv(int index, Addressable v) {
    glext_h.glVertexAttribI4iv(index, v);
  }

  public void glVertexAttribI4ivEXT(int index, Addressable v) {
    glext_h.glVertexAttribI4ivEXT(index, v);
  }

  public void glVertexAttribI4sv(int index, Addressable v) {
    glext_h.glVertexAttribI4sv(index, v);
  }

  public void glVertexAttribI4svEXT(int index, Addressable v) {
    glext_h.glVertexAttribI4svEXT(index, v);
  }

  public void glVertexAttribI4ubv(int index, Addressable v) {
    glext_h.glVertexAttribI4ubv(index, v);
  }

  public void glVertexAttribI4ubvEXT(int index, Addressable v) {
    glext_h.glVertexAttribI4ubvEXT(index, v);
  }

  public void glVertexAttribI4ui(int index, int x, int y, int z, int w) {
    glext_h.glVertexAttribI4ui(index, x, y, z, w);
  }

  public void glVertexAttribI4uiEXT(int index, int x, int y, int z, int w) {
    glext_h.glVertexAttribI4uiEXT(index, x, y, z, w);
  }

  public void glVertexAttribI4uiv(int index, Addressable v) {
    glext_h.glVertexAttribI4uiv(index, v);
  }

  public void glVertexAttribI4uivEXT(int index, Addressable v) {
    glext_h.glVertexAttribI4uivEXT(index, v);
  }

  public void glVertexAttribI4usv(int index, Addressable v) {
    glext_h.glVertexAttribI4usv(index, v);
  }

  public void glVertexAttribI4usvEXT(int index, Addressable v) {
    glext_h.glVertexAttribI4usvEXT(index, v);
  }

  public void glVertexAttribIFormat(int attribindex, int size, int type, int relativeoffset) {
    glext_h.glVertexAttribIFormat(attribindex, size, type, relativeoffset);
  }

  public void glVertexAttribIFormatNV(int index, int size, int type, int stride) {
    glext_h.glVertexAttribIFormatNV(index, size, type, stride);
  }

  public void glVertexAttribIPointer(int index, int size, int type, int stride, Addressable pointer) {
    glext_h.glVertexAttribIPointer(index, size, type, stride, pointer);
  }

  public void glVertexAttribIPointerEXT(int index, int size, int type, int stride, Addressable pointer) {
    glext_h.glVertexAttribIPointerEXT(index, size, type, stride, pointer);
  }

  public void glVertexAttribL1d(int index, double x) {
    glext_h.glVertexAttribL1d(index, x);
  }

  public void glVertexAttribL1dEXT(int index, double x) {
    glext_h.glVertexAttribL1dEXT(index, x);
  }

  public void glVertexAttribL1dv(int index, Addressable v) {
    glext_h.glVertexAttribL1dv(index, v);
  }

  public void glVertexAttribL1dvEXT(int index, Addressable v) {
    glext_h.glVertexAttribL1dvEXT(index, v);
  }

  public void glVertexAttribL1i64NV(int index, long x) {
    glext_h.glVertexAttribL1i64NV(index, x);
  }

  public void glVertexAttribL1i64vNV(int index, Addressable v) {
    glext_h.glVertexAttribL1i64vNV(index, v);
  }

  public void glVertexAttribL1ui64ARB(int index, long x) {
    glext_h.glVertexAttribL1ui64ARB(index, x);
  }

  public void glVertexAttribL1ui64NV(int index, long x) {
    glext_h.glVertexAttribL1ui64NV(index, x);
  }

  public void glVertexAttribL1ui64vARB(int index, Addressable v) {
    glext_h.glVertexAttribL1ui64vARB(index, v);
  }

  public void glVertexAttribL1ui64vNV(int index, Addressable v) {
    glext_h.glVertexAttribL1ui64vNV(index, v);
  }

  public void glVertexAttribL2d(int index, double x, double y) {
    glext_h.glVertexAttribL2d(index, x, y);
  }

  public void glVertexAttribL2dEXT(int index, double x, double y) {
    glext_h.glVertexAttribL2dEXT(index, x, y);
  }

  public void glVertexAttribL2dv(int index, Addressable v) {
    glext_h.glVertexAttribL2dv(index, v);
  }

  public void glVertexAttribL2dvEXT(int index, Addressable v) {
    glext_h.glVertexAttribL2dvEXT(index, v);
  }

  public void glVertexAttribL2i64NV(int index, long x, long y) {
    glext_h.glVertexAttribL2i64NV(index, x, y);
  }

  public void glVertexAttribL2i64vNV(int index, Addressable v) {
    glext_h.glVertexAttribL2i64vNV(index, v);
  }

  public void glVertexAttribL2ui64NV(int index, long x, long y) {
    glext_h.glVertexAttribL2ui64NV(index, x, y);
  }

  public void glVertexAttribL2ui64vNV(int index, Addressable v) {
    glext_h.glVertexAttribL2ui64vNV(index, v);
  }

  public void glVertexAttribL3d(int index, double x, double y, double z) {
    glext_h.glVertexAttribL3d(index, x, y, z);
  }

  public void glVertexAttribL3dEXT(int index, double x, double y, double z) {
    glext_h.glVertexAttribL3dEXT(index, x, y, z);
  }

  public void glVertexAttribL3dv(int index, Addressable v) {
    glext_h.glVertexAttribL3dv(index, v);
  }

  public void glVertexAttribL3dvEXT(int index, Addressable v) {
    glext_h.glVertexAttribL3dvEXT(index, v);
  }

  public void glVertexAttribL3i64NV(int index, long x, long y, long z) {
    glext_h.glVertexAttribL3i64NV(index, x, y, z);
  }

  public void glVertexAttribL3i64vNV(int index, Addressable v) {
    glext_h.glVertexAttribL3i64vNV(index, v);
  }

  public void glVertexAttribL3ui64NV(int index, long x, long y, long z) {
    glext_h.glVertexAttribL3ui64NV(index, x, y, z);
  }

  public void glVertexAttribL3ui64vNV(int index, Addressable v) {
    glext_h.glVertexAttribL3ui64vNV(index, v);
  }

  public void glVertexAttribL4d(int index, double x, double y, double z, double w) {
    glext_h.glVertexAttribL4d(index, x, y, z, w);
  }

  public void glVertexAttribL4dEXT(int index, double x, double y, double z, double w) {
    glext_h.glVertexAttribL4dEXT(index, x, y, z, w);
  }

  public void glVertexAttribL4dv(int index, Addressable v) {
    glext_h.glVertexAttribL4dv(index, v);
  }

  public void glVertexAttribL4dvEXT(int index, Addressable v) {
    glext_h.glVertexAttribL4dvEXT(index, v);
  }

  public void glVertexAttribL4i64NV(int index, long x, long y, long z, long w) {
    glext_h.glVertexAttribL4i64NV(index, x, y, z, w);
  }

  public void glVertexAttribL4i64vNV(int index, Addressable v) {
    glext_h.glVertexAttribL4i64vNV(index, v);
  }

  public void glVertexAttribL4ui64NV(int index, long x, long y, long z, long w) {
    glext_h.glVertexAttribL4ui64NV(index, x, y, z, w);
  }

  public void glVertexAttribL4ui64vNV(int index, Addressable v) {
    glext_h.glVertexAttribL4ui64vNV(index, v);
  }

  public void glVertexAttribLFormat(int attribindex, int size, int type, int relativeoffset) {
    glext_h.glVertexAttribLFormat(attribindex, size, type, relativeoffset);
  }

  public void glVertexAttribLFormatNV(int index, int size, int type, int stride) {
    glext_h.glVertexAttribLFormatNV(index, size, type, stride);
  }

  public void glVertexAttribLPointer(int index, int size, int type, int stride, Addressable pointer) {
    glext_h.glVertexAttribLPointer(index, size, type, stride, pointer);
  }

  public void glVertexAttribLPointerEXT(int index, int size, int type, int stride, Addressable pointer) {
    glext_h.glVertexAttribLPointerEXT(index, size, type, stride, pointer);
  }

  public void glVertexAttribP1ui(int index, int type, byte normalized, int value) {
    glext_h.glVertexAttribP1ui(index, type, normalized, value);
  }

  public void glVertexAttribP1uiv(int index, int type, byte normalized, Addressable value) {
    glext_h.glVertexAttribP1uiv(index, type, normalized, value);
  }

  public void glVertexAttribP2ui(int index, int type, byte normalized, int value) {
    glext_h.glVertexAttribP2ui(index, type, normalized, value);
  }

  public void glVertexAttribP2uiv(int index, int type, byte normalized, Addressable value) {
    glext_h.glVertexAttribP2uiv(index, type, normalized, value);
  }

  public void glVertexAttribP3ui(int index, int type, byte normalized, int value) {
    glext_h.glVertexAttribP3ui(index, type, normalized, value);
  }

  public void glVertexAttribP3uiv(int index, int type, byte normalized, Addressable value) {
    glext_h.glVertexAttribP3uiv(index, type, normalized, value);
  }

  public void glVertexAttribP4ui(int index, int type, byte normalized, int value) {
    glext_h.glVertexAttribP4ui(index, type, normalized, value);
  }

  public void glVertexAttribP4uiv(int index, int type, byte normalized, Addressable value) {
    glext_h.glVertexAttribP4uiv(index, type, normalized, value);
  }

  public void glVertexAttribParameteriAMD(int index, int pname, int param) {
    glext_h.glVertexAttribParameteriAMD(index, pname, param);
  }

  public void glVertexAttribPointer(int index, int size, int type, byte normalized, int stride, Addressable pointer) {
    glext_h.glVertexAttribPointer(index, size, type, normalized, stride, pointer);
  }

  public void glVertexAttribPointerARB(int index, int size, int type, byte normalized, int stride, Addressable pointer) {
    glext_h.glVertexAttribPointerARB(index, size, type, normalized, stride, pointer);
  }

  public void glVertexAttribPointerNV(int index, int fsize, int type, int stride, Addressable pointer) {
    glext_h.glVertexAttribPointerNV(index, fsize, type, stride, pointer);
  }

  public void glVertexAttribs1dvNV(int index, int count, Addressable v) {
    glext_h.glVertexAttribs1dvNV(index, count, v);
  }

  public void glVertexAttribs1fvNV(int index, int count, Addressable v) {
    glext_h.glVertexAttribs1fvNV(index, count, v);
  }

  public void glVertexAttribs1hvNV(int index, int n, Addressable v) {
    glext_h.glVertexAttribs1hvNV(index, n, v);
  }

  public void glVertexAttribs1svNV(int index, int count, Addressable v) {
    glext_h.glVertexAttribs1svNV(index, count, v);
  }

  public void glVertexAttribs2dvNV(int index, int count, Addressable v) {
    glext_h.glVertexAttribs2dvNV(index, count, v);
  }

  public void glVertexAttribs2fvNV(int index, int count, Addressable v) {
    glext_h.glVertexAttribs2fvNV(index, count, v);
  }

  public void glVertexAttribs2hvNV(int index, int n, Addressable v) {
    glext_h.glVertexAttribs2hvNV(index, n, v);
  }

  public void glVertexAttribs2svNV(int index, int count, Addressable v) {
    glext_h.glVertexAttribs2svNV(index, count, v);
  }

  public void glVertexAttribs3dvNV(int index, int count, Addressable v) {
    glext_h.glVertexAttribs3dvNV(index, count, v);
  }

  public void glVertexAttribs3fvNV(int index, int count, Addressable v) {
    glext_h.glVertexAttribs3fvNV(index, count, v);
  }

  public void glVertexAttribs3hvNV(int index, int n, Addressable v) {
    glext_h.glVertexAttribs3hvNV(index, n, v);
  }

  public void glVertexAttribs3svNV(int index, int count, Addressable v) {
    glext_h.glVertexAttribs3svNV(index, count, v);
  }

  public void glVertexAttribs4dvNV(int index, int count, Addressable v) {
    glext_h.glVertexAttribs4dvNV(index, count, v);
  }

  public void glVertexAttribs4fvNV(int index, int count, Addressable v) {
    glext_h.glVertexAttribs4fvNV(index, count, v);
  }

  public void glVertexAttribs4hvNV(int index, int n, Addressable v) {
    glext_h.glVertexAttribs4hvNV(index, n, v);
  }

  public void glVertexAttribs4svNV(int index, int count, Addressable v) {
    glext_h.glVertexAttribs4svNV(index, count, v);
  }

  public void glVertexAttribs4ubvNV(int index, int count, Addressable v) {
    glext_h.glVertexAttribs4ubvNV(index, count, v);
  }

  public void glVertexBindingDivisor(int bindingindex, int divisor) {
    glext_h.glVertexBindingDivisor(bindingindex, divisor);
  }

  public void glVertexBlendARB(int count) {
    glext_h.glVertexBlendARB(count);
  }

  public void glVertexBlendEnvfATI(int pname, float param) {
    glext_h.glVertexBlendEnvfATI(pname, param);
  }

  public void glVertexBlendEnviATI(int pname, int param) {
    glext_h.glVertexBlendEnviATI(pname, param);
  }

  public void glVertexFormatNV(int size, int type, int stride) {
    glext_h.glVertexFormatNV(size, type, stride);
  }

  public void glVertexP2ui(int type, int value) {
    glext_h.glVertexP2ui(type, value);
  }

  public void glVertexP2uiv(int type, Addressable value) {
    glext_h.glVertexP2uiv(type, value);
  }

  public void glVertexP3ui(int type, int value) {
    glext_h.glVertexP3ui(type, value);
  }

  public void glVertexP3uiv(int type, Addressable value) {
    glext_h.glVertexP3uiv(type, value);
  }

  public void glVertexP4ui(int type, int value) {
    glext_h.glVertexP4ui(type, value);
  }

  public void glVertexP4uiv(int type, Addressable value) {
    glext_h.glVertexP4uiv(type, value);
  }

  public void glVertexPointerEXT(int size, int type, int stride, int count, Addressable pointer) {
    glext_h.glVertexPointerEXT(size, type, stride, count, pointer);
  }

  public void glVertexPointerListIBM(int size, int type, int stride, Addressable pointer, int ptrstride) {
    glext_h.glVertexPointerListIBM(size, type, stride, pointer, ptrstride);
  }

  public void glVertexPointervINTEL(int size, int type, Addressable pointer) {
    glext_h.glVertexPointervINTEL(size, type, pointer);
  }

  public void glVertexStream1dATI(int stream, double x) {
    glext_h.glVertexStream1dATI(stream, x);
  }

  public void glVertexStream1dvATI(int stream, Addressable coords) {
    glext_h.glVertexStream1dvATI(stream, coords);
  }

  public void glVertexStream1fATI(int stream, float x) {
    glext_h.glVertexStream1fATI(stream, x);
  }

  public void glVertexStream1fvATI(int stream, Addressable coords) {
    glext_h.glVertexStream1fvATI(stream, coords);
  }

  public void glVertexStream1iATI(int stream, int x) {
    glext_h.glVertexStream1iATI(stream, x);
  }

  public void glVertexStream1ivATI(int stream, Addressable coords) {
    glext_h.glVertexStream1ivATI(stream, coords);
  }

  public void glVertexStream1sATI(int stream, short x) {
    glext_h.glVertexStream1sATI(stream, x);
  }

  public void glVertexStream1svATI(int stream, Addressable coords) {
    glext_h.glVertexStream1svATI(stream, coords);
  }

  public void glVertexStream2dATI(int stream, double x, double y) {
    glext_h.glVertexStream2dATI(stream, x, y);
  }

  public void glVertexStream2dvATI(int stream, Addressable coords) {
    glext_h.glVertexStream2dvATI(stream, coords);
  }

  public void glVertexStream2fATI(int stream, float x, float y) {
    glext_h.glVertexStream2fATI(stream, x, y);
  }

  public void glVertexStream2fvATI(int stream, Addressable coords) {
    glext_h.glVertexStream2fvATI(stream, coords);
  }

  public void glVertexStream2iATI(int stream, int x, int y) {
    glext_h.glVertexStream2iATI(stream, x, y);
  }

  public void glVertexStream2ivATI(int stream, Addressable coords) {
    glext_h.glVertexStream2ivATI(stream, coords);
  }

  public void glVertexStream2sATI(int stream, short x, short y) {
    glext_h.glVertexStream2sATI(stream, x, y);
  }

  public void glVertexStream2svATI(int stream, Addressable coords) {
    glext_h.glVertexStream2svATI(stream, coords);
  }

  public void glVertexStream3dATI(int stream, double x, double y, double z) {
    glext_h.glVertexStream3dATI(stream, x, y, z);
  }

  public void glVertexStream3dvATI(int stream, Addressable coords) {
    glext_h.glVertexStream3dvATI(stream, coords);
  }

  public void glVertexStream3fATI(int stream, float x, float y, float z) {
    glext_h.glVertexStream3fATI(stream, x, y, z);
  }

  public void glVertexStream3fvATI(int stream, Addressable coords) {
    glext_h.glVertexStream3fvATI(stream, coords);
  }

  public void glVertexStream3iATI(int stream, int x, int y, int z) {
    glext_h.glVertexStream3iATI(stream, x, y, z);
  }

  public void glVertexStream3ivATI(int stream, Addressable coords) {
    glext_h.glVertexStream3ivATI(stream, coords);
  }

  public void glVertexStream3sATI(int stream, short x, short y, short z) {
    glext_h.glVertexStream3sATI(stream, x, y, z);
  }

  public void glVertexStream3svATI(int stream, Addressable coords) {
    glext_h.glVertexStream3svATI(stream, coords);
  }

  public void glVertexStream4dATI(int stream, double x, double y, double z, double w) {
    glext_h.glVertexStream4dATI(stream, x, y, z, w);
  }

  public void glVertexStream4dvATI(int stream, Addressable coords) {
    glext_h.glVertexStream4dvATI(stream, coords);
  }

  public void glVertexStream4fATI(int stream, float x, float y, float z, float w) {
    glext_h.glVertexStream4fATI(stream, x, y, z, w);
  }

  public void glVertexStream4fvATI(int stream, Addressable coords) {
    glext_h.glVertexStream4fvATI(stream, coords);
  }

  public void glVertexStream4iATI(int stream, int x, int y, int z, int w) {
    glext_h.glVertexStream4iATI(stream, x, y, z, w);
  }

  public void glVertexStream4ivATI(int stream, Addressable coords) {
    glext_h.glVertexStream4ivATI(stream, coords);
  }

  public void glVertexStream4sATI(int stream, short x, short y, short z, short w) {
    glext_h.glVertexStream4sATI(stream, x, y, z, w);
  }

  public void glVertexStream4svATI(int stream, Addressable coords) {
    glext_h.glVertexStream4svATI(stream, coords);
  }

  public void glVertexWeightPointerEXT(int size, int type, int stride, Addressable pointer) {
    glext_h.glVertexWeightPointerEXT(size, type, stride, pointer);
  }

  public void glVertexWeightfEXT(float weight) {
    glext_h.glVertexWeightfEXT(weight);
  }

  public void glVertexWeightfvEXT(Addressable weight) {
    glext_h.glVertexWeightfvEXT(weight);
  }

  public void glVertexWeighthNV(short weight) {
    glext_h.glVertexWeighthNV(weight);
  }

  public void glVertexWeighthvNV(Addressable weight) {
    glext_h.glVertexWeighthvNV(weight);
  }

  public int glVideoCaptureNV(int video_capture_slot, Addressable sequence_num, Addressable capture_time) {
    return glext_h.glVideoCaptureNV(video_capture_slot, sequence_num, capture_time);
  }

  public void glVideoCaptureStreamParameterdvNV(int video_capture_slot, int stream, int pname, Addressable params) {
    glext_h.glVideoCaptureStreamParameterdvNV(video_capture_slot, stream, pname, params);
  }

  public void glVideoCaptureStreamParameterfvNV(int video_capture_slot, int stream, int pname, Addressable params) {
    glext_h.glVideoCaptureStreamParameterfvNV(video_capture_slot, stream, pname, params);
  }

  public void glVideoCaptureStreamParameterivNV(int video_capture_slot, int stream, int pname, Addressable params) {
    glext_h.glVideoCaptureStreamParameterivNV(video_capture_slot, stream, pname, params);
  }

  public void glViewportArrayv(int first, int count, Addressable v) {
    glext_h.glViewportArrayv(first, count, v);
  }

  public void glViewportIndexedf(int index, float x, float y, float w, float h) {
    glext_h.glViewportIndexedf(index, x, y, w, h);
  }

  public void glViewportIndexedfv(int index, Addressable v) {
    glext_h.glViewportIndexedfv(index, v);
  }

  public void glViewportPositionWScaleNV(int index, float xcoeff, float ycoeff) {
    glext_h.glViewportPositionWScaleNV(index, xcoeff, ycoeff);
  }

  public void glViewportSwizzleNV(int index, int swizzlex, int swizzley, int swizzlez, int swizzlew) {
    glext_h.glViewportSwizzleNV(index, swizzlex, swizzley, swizzlez, swizzlew);
  }

  public void glWaitSemaphoreEXT(int semaphore, int numBufferBarriers, Addressable buffers, int numTextureBarriers, Addressable textures, Addressable srcLayouts) {
    glext_h.glWaitSemaphoreEXT(semaphore, numBufferBarriers, buffers, numTextureBarriers, textures, srcLayouts);
  }

  public void glWaitSemaphoreui64NVX(int waitGpu, int fenceObjectCount, Addressable semaphoreArray, Addressable fenceValueArray) {
    glext_h.glWaitSemaphoreui64NVX(waitGpu, fenceObjectCount, semaphoreArray, fenceValueArray);
  }

  public void glWaitSync(Addressable sync, int flags, long timeout) {
    glext_h.glWaitSync(sync, flags, timeout);
  }

  public void glWaitVkSemaphoreNV(long vkSemaphore) {
    glext_h.glWaitVkSemaphoreNV(vkSemaphore);
  }

  public void glWeightPathsNV(int resultPath, int numPaths, Addressable paths, Addressable weights) {
    glext_h.glWeightPathsNV(resultPath, numPaths, paths, weights);
  }

  public void glWeightPointerARB(int size, int type, int stride, Addressable pointer) {
    glext_h.glWeightPointerARB(size, type, stride, pointer);
  }

  public void glWeightbvARB(int size, Addressable weights) {
    glext_h.glWeightbvARB(size, weights);
  }

  public void glWeightdvARB(int size, Addressable weights) {
    glext_h.glWeightdvARB(size, weights);
  }

  public void glWeightfvARB(int size, Addressable weights) {
    glext_h.glWeightfvARB(size, weights);
  }

  public void glWeightivARB(int size, Addressable weights) {
    glext_h.glWeightivARB(size, weights);
  }

  public void glWeightsvARB(int size, Addressable weights) {
    glext_h.glWeightsvARB(size, weights);
  }

  public void glWeightubvARB(int size, Addressable weights) {
    glext_h.glWeightubvARB(size, weights);
  }

  public void glWeightuivARB(int size, Addressable weights) {
    glext_h.glWeightuivARB(size, weights);
  }

  public void glWeightusvARB(int size, Addressable weights) {
    glext_h.glWeightusvARB(size, weights);
  }

  public void glWindowPos2d(double x, double y) {
    glext_h.glWindowPos2d(x, y);
  }

  public void glWindowPos2dARB(double x, double y) {
    glext_h.glWindowPos2dARB(x, y);
  }

  public void glWindowPos2dMESA(double x, double y) {
    glext_h.glWindowPos2dMESA(x, y);
  }

  public void glWindowPos2dv(Addressable v) {
    glext_h.glWindowPos2dv(v);
  }

  public void glWindowPos2dvARB(Addressable v) {
    glext_h.glWindowPos2dvARB(v);
  }

  public void glWindowPos2dvMESA(Addressable v) {
    glext_h.glWindowPos2dvMESA(v);
  }

  public void glWindowPos2f(float x, float y) {
    glext_h.glWindowPos2f(x, y);
  }

  public void glWindowPos2fARB(float x, float y) {
    glext_h.glWindowPos2fARB(x, y);
  }

  public void glWindowPos2fMESA(float x, float y) {
    glext_h.glWindowPos2fMESA(x, y);
  }

  public void glWindowPos2fv(Addressable v) {
    glext_h.glWindowPos2fv(v);
  }

  public void glWindowPos2fvARB(Addressable v) {
    glext_h.glWindowPos2fvARB(v);
  }

  public void glWindowPos2fvMESA(Addressable v) {
    glext_h.glWindowPos2fvMESA(v);
  }

  public void glWindowPos2i(int x, int y) {
    glext_h.glWindowPos2i(x, y);
  }

  public void glWindowPos2iARB(int x, int y) {
    glext_h.glWindowPos2iARB(x, y);
  }

  public void glWindowPos2iMESA(int x, int y) {
    glext_h.glWindowPos2iMESA(x, y);
  }

  public void glWindowPos2iv(Addressable v) {
    glext_h.glWindowPos2iv(v);
  }

  public void glWindowPos2ivARB(Addressable v) {
    glext_h.glWindowPos2ivARB(v);
  }

  public void glWindowPos2ivMESA(Addressable v) {
    glext_h.glWindowPos2ivMESA(v);
  }

  public void glWindowPos2s(short x, short y) {
    glext_h.glWindowPos2s(x, y);
  }

  public void glWindowPos2sARB(short x, short y) {
    glext_h.glWindowPos2sARB(x, y);
  }

  public void glWindowPos2sMESA(short x, short y) {
    glext_h.glWindowPos2sMESA(x, y);
  }

  public void glWindowPos2sv(Addressable v) {
    glext_h.glWindowPos2sv(v);
  }

  public void glWindowPos2svARB(Addressable v) {
    glext_h.glWindowPos2svARB(v);
  }

  public void glWindowPos2svMESA(Addressable v) {
    glext_h.glWindowPos2svMESA(v);
  }

  public void glWindowPos3d(double x, double y, double z) {
    glext_h.glWindowPos3d(x, y, z);
  }

  public void glWindowPos3dARB(double x, double y, double z) {
    glext_h.glWindowPos3dARB(x, y, z);
  }

  public void glWindowPos3dMESA(double x, double y, double z) {
    glext_h.glWindowPos3dMESA(x, y, z);
  }

  public void glWindowPos3dv(Addressable v) {
    glext_h.glWindowPos3dv(v);
  }

  public void glWindowPos3dvARB(Addressable v) {
    glext_h.glWindowPos3dvARB(v);
  }

  public void glWindowPos3dvMESA(Addressable v) {
    glext_h.glWindowPos3dvMESA(v);
  }

  public void glWindowPos3f(float x, float y, float z) {
    glext_h.glWindowPos3f(x, y, z);
  }

  public void glWindowPos3fARB(float x, float y, float z) {
    glext_h.glWindowPos3fARB(x, y, z);
  }

  public void glWindowPos3fMESA(float x, float y, float z) {
    glext_h.glWindowPos3fMESA(x, y, z);
  }

  public void glWindowPos3fv(Addressable v) {
    glext_h.glWindowPos3fv(v);
  }

  public void glWindowPos3fvARB(Addressable v) {
    glext_h.glWindowPos3fvARB(v);
  }

  public void glWindowPos3fvMESA(Addressable v) {
    glext_h.glWindowPos3fvMESA(v);
  }

  public void glWindowPos3i(int x, int y, int z) {
    glext_h.glWindowPos3i(x, y, z);
  }

  public void glWindowPos3iARB(int x, int y, int z) {
    glext_h.glWindowPos3iARB(x, y, z);
  }

  public void glWindowPos3iMESA(int x, int y, int z) {
    glext_h.glWindowPos3iMESA(x, y, z);
  }

  public void glWindowPos3iv(Addressable v) {
    glext_h.glWindowPos3iv(v);
  }

  public void glWindowPos3ivARB(Addressable v) {
    glext_h.glWindowPos3ivARB(v);
  }

  public void glWindowPos3ivMESA(Addressable v) {
    glext_h.glWindowPos3ivMESA(v);
  }

  public void glWindowPos3s(short x, short y, short z) {
    glext_h.glWindowPos3s(x, y, z);
  }

  public void glWindowPos3sARB(short x, short y, short z) {
    glext_h.glWindowPos3sARB(x, y, z);
  }

  public void glWindowPos3sMESA(short x, short y, short z) {
    glext_h.glWindowPos3sMESA(x, y, z);
  }

  public void glWindowPos3sv(Addressable v) {
    glext_h.glWindowPos3sv(v);
  }

  public void glWindowPos3svARB(Addressable v) {
    glext_h.glWindowPos3svARB(v);
  }

  public void glWindowPos3svMESA(Addressable v) {
    glext_h.glWindowPos3svMESA(v);
  }

  public void glWindowPos4dMESA(double x, double y, double z, double w) {
    glext_h.glWindowPos4dMESA(x, y, z, w);
  }

  public void glWindowPos4dvMESA(Addressable v) {
    glext_h.glWindowPos4dvMESA(v);
  }

  public void glWindowPos4fMESA(float x, float y, float z, float w) {
    glext_h.glWindowPos4fMESA(x, y, z, w);
  }

  public void glWindowPos4fvMESA(Addressable v) {
    glext_h.glWindowPos4fvMESA(v);
  }

  public void glWindowPos4iMESA(int x, int y, int z, int w) {
    glext_h.glWindowPos4iMESA(x, y, z, w);
  }

  public void glWindowPos4ivMESA(Addressable v) {
    glext_h.glWindowPos4ivMESA(v);
  }

  public void glWindowPos4sMESA(short x, short y, short z, short w) {
    glext_h.glWindowPos4sMESA(x, y, z, w);
  }

  public void glWindowPos4svMESA(Addressable v) {
    glext_h.glWindowPos4svMESA(v);
  }

  public void glWindowRectanglesEXT(int mode, int count, Addressable box) {
    glext_h.glWindowRectanglesEXT(mode, count, box);
  }

  public void glWriteMaskEXT(int res, int in, int outX, int outY, int outZ, int outW) {
    glext_h.glWriteMaskEXT(res, in, outX, outY, outZ, outW);
  }

  public int glCheckFramebufferStatusOES(int target) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glClipPlanex(int plane, Addressable equation) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexBufferRangeEXT(int target, int internalformat, int buffer, long offset, long size) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glClipControlEXT(int origin, int depth) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glClipPlanef(int p, Addressable eqn) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glClearPixelLocalStorageuiEXT(int offset, int n, Addressable values) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glClearTexImageEXT(int texture, int level, int format, int type, Addressable data) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexStorageAttribs3DEXT(int target, int levels, int internalformat, int width, int height, int depth, int attrib_list) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glPrimitiveBoundingBoxOES(float minX, float minY, float minZ, float minW, float maxX, float maxY, float maxZ, float maxW) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glCopyImageSubDataEXT(int srcName, int srcTarget, int srcLevel, int srcX, int srcY, int srcZ, int dstName, int dstTarget, int dstLevel, int dstX, int dstY, int dstZ, int srcWidth, int srcHeight, int srcDepth) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBufferStorageEXT(int target, long size, Addressable data, int flags) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMinSampleShadingOES(float value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDepthRangeIndexeddNV(int index, double n, double f) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiDrawElementsBaseVertexEXT(int mode, Addressable count, int type, Addressable indices, int drawcount, Addressable basevertex) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBindProgramPipelineEXT(int pipeline) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public int glGetProgramResourceLocationIndexEXT(int program, int programInterface, Addressable name) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetTranslatedShaderSourceANGLE(int shader, int bufSize, Addressable length, Addressable source) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glLightxv(int light, int pname, Addressable params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUseProgramStagesEXT(int pipeline, int stages, int program) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDrawArraysInstancedNV(int mode, int first, int count, int primcount) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetInteger64vAPPLE(int pname, Addressable params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glLoadMatrixx(Addressable m) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDeleteVertexArraysOES(int n, Addressable arrays) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDrawElementsInstancedBaseVertexBaseInstanceEXT(int mode, int count, int type, Addressable indices, int instancecount, int basevertex, int baseinstance) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiDrawElementsIndirectEXT(int mode, int type, Addressable indirect, int drawcount, int stride) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetTexParameterIivOES(int target, int pname, Addressable params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDepthRangeArrayfvOES(int first, int count, Addressable v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glQueryCounterEXT(int id, int target) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexParameterx(int target, int pname, int param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTextureViewOES(int texture, int target, int origtexture, int internalformat, int minlevel, int numlevels, int minlayer, int numlayers) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetTexGenivOES(int coord, int pname, Addressable params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glLightx(int light, int pname, int param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDrawTexxOES(int x, int y, int z, int width, int height) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultMatrixx(Addressable m) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBlendEquationiEXT(int buf, int mode) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDebugMessageControlKHR(int source, int type, int severity, int count, Addressable ids, byte enabled) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGenRenderbuffersOES(int n, Addressable renderbuffers) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetnUniformivEXT(int program, int location, int bufSize, Addressable params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDeleteFramebuffersOES(int n, Addressable framebuffers) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexBufferOES(int target, int internalformat, int buffer) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glExtGetBuffersQCOM(Addressable buffers, int maxBuffers, Addressable numBuffers) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDrawTexivOES(Addressable coords) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glViewportArrayvOES(int first, int count, Addressable v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glRenderbufferStorageMultisampleAPPLE(int target, int samples, int internalformat, int width, int height) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFramebufferTexture2DMultisampleEXT(int target, int attachment, int textarget, int texture, int level, int samples) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFogx(int pname, int param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetProgramPipelineivEXT(int pipeline, int pname, Addressable params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetMaterialxv(int face, int pname, Addressable params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetnUniformfvEXT(int program, int location, int bufSize, Addressable params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glStartTilingQCOM(int x, int y, int width, int height, int preserveMask) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexEnvx(int target, int pname, int param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glPatchParameteriOES(int pname, int value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDeleteSyncAPPLE(Addressable sync) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glEndTilingQCOM(int preserveMask) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDrawTexxvOES(Addressable coords) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glClearColorx(int red, int green, int blue, int alpha) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glSamplerParameterIuivEXT(int sampler, int pname, Addressable param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glResolveMultisampleFramebufferAPPLE() {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniformMatrix2x3fvNV(int location, int count, byte transpose, Addressable value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glScissorIndexedvNV(int index, Addressable v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetDriverControlsQCOM(Addressable num, int size, Addressable driverControls) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glShadingRateEXT(int rate) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glWaitSyncAPPLE(Addressable sync, int flags, long timeout) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniformHandleui64IMG(int location, long value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glCopyTextureLevelsAPPLE(int destinationTexture, int sourceTexture, int sourceBaseLevel, int sourceLevelCount) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDeleteProgramPipelinesEXT(int n, Addressable pipelines) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glPrimitiveBoundingBoxEXT(float minX, float minY, float minZ, float minW, float maxX, float maxY, float maxZ, float maxW) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBlitFramebufferNV(int srcX0, int srcY0, int srcX1, int srcY1, int dstX0, int dstY0, int dstX1, int dstY1, int mask, int filter) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetObjectLabelKHR(int identifier, int name, int bufSize, Addressable length, Addressable label) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniformHandleui64vIMG(int program, int location, int count, Addressable values) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDrawArraysInstancedBaseInstanceEXT(int mode, int first, int count, int instancecount, int baseinstance) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBeginQueryEXT(int target, int id) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetQueryObjectivEXT(int id, int pname, Addressable params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetLightxv(int light, int pname, Addressable params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTextureFoveationParametersQCOM(int texture, int layer, int focalPoint, float focalX, float focalY, float gainX, float gainY, float foveaArea) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glOrthof(float l, float r, float b, float t, float n, float f) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glOrthox(int l, int r, int b, int t, int n, int f) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexEnvxv(int target, int pname, Addressable params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glSemaphoreParameterivNV(int semaphore, int pname, Addressable params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFramebufferTextureLayerDownsampleIMG(int target, int attachment, int texture, int level, int layer, int xscale, int yscale) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDisableDriverControlQCOM(int driverControl) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glExtGetProgramsQCOM(Addressable programs, int maxPrograms, Addressable numPrograms) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glViewportIndexedfvNV(int index, Addressable v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public int glGetFramebufferPixelLocalStorageSizeEXT(int target) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glExtGetFramebuffersQCOM(Addressable framebuffers, int maxFramebuffers, Addressable numFramebuffers) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetSemaphoreParameterivNV(int semaphore, int pname, Addressable params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDrawElementsInstancedBaseVertexEXT(int mode, int count, int type, Addressable indices, int instancecount, int basevertex) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glExtrapolateTex2DQCOM(int src1, int src2, int output, float scaleFactor) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribDivisorANGLE(int index, int divisor) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public byte glIsRenderbufferOES(int renderbuffer) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniformMatrix4x3fvNV(int location, int count, byte transpose, Addressable value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glSamplerParameterIuivOES(int sampler, int pname, Addressable param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBlendFunciEXT(int buf, int src, int dst) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDisableiEXT(int target, int index) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetFixedv(int pname, Addressable params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetObjectPtrLabelKHR(Addressable ptr, int bufSize, Addressable length, Addressable label) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGenVertexArraysOES(int n, Addressable arrays) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glEnableiNV(int target, int index) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetnUniformivKHR(int program, int location, int bufSize, Addressable params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glReadnPixelsKHR(int x, int y, int width, int height, int format, int type, int bufSize, Addressable data) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDrawTransformFeedbackInstancedEXT(int mode, int id, int instancecount) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniformMatrix3x4fvNV(int location, int count, byte transpose, Addressable value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public Addressable glFenceSyncAPPLE(int condition, int flags) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glClipPlanexIMG(int p, Addressable eqn) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glPointSizex(int size) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDebugMessageCallbackKHR(Addressable callback, Addressable userParam) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDisableiNV(int target, int index) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexCoord4x(int texture, int s, int t, int r, int q) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFlushMappedBufferRangeEXT(int target, long offset, long length) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDiscardFramebufferEXT(int target, int numAttachments, Addressable attachments) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniformHandleui64IMG(int program, int location, long value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glSampleCoveragex(int value, byte invert) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glSamplerParameterIivOES(int sampler, int pname, Addressable param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glAlphaFuncQCOM(int func, float ref) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glExtGetProgramBinarySourceQCOM(int program, int shadertype, Addressable source, Addressable length) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glCurrentPaletteMatrixOES(int matrixpaletteindex) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFramebufferTextureOES(int target, int attachment, int texture, int level) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFogxv(int pname, Addressable param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public int glGetDebugMessageLogKHR(int count, int bufSize, Addressable sources, Addressable types, Addressable ids, Addressable severities, Addressable lengths, Addressable messageLog) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDrawTexfvOES(Addressable coords) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramBinaryOES(int program, int binaryFormat, Addressable binary, int length) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glCreateSemaphoresNV(int n, Addressable semaphores) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFramebufferFetchBarrierQCOM() {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDrawArraysInstancedANGLE(int mode, int first, int count, int primcount) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBlendFunciOES(int buf, int src, int dst) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public int glGetGraphicsResetStatusEXT() {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glPrimitiveBoundingBox(float minX, float minY, float minZ, float minW, float maxX, float maxY, float maxZ, float maxW) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDepthRangeArrayfvNV(int first, int count, Addressable v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glRenderbufferStorageMultisampleNV(int target, int samples, int internalformat, int width, int height) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetSyncivAPPLE(Addressable sync, int pname, int count, Addressable length, Addressable values) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glClearDepthx(int depth) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFramebufferShadingRateEXT(int target, int attachment, int texture, int baseLayer, int numLayers, int texelWidth, int texelHeight) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glObjectPtrLabelKHR(Addressable ptr, int length, Addressable label) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDisableiOES(int target, int index) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glScissorArrayvNV(int first, int count, Addressable v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glValidateProgramPipelineEXT(int pipeline) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glSamplerParameterIivEXT(int sampler, int pname, Addressable param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glExtGetRenderbuffersQCOM(Addressable renderbuffers, int maxRenderbuffers, Addressable numRenderbuffers) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glRotatex(int angle, int x, int y, int z) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexGenfvOES(int coord, int pname, Addressable params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMatrixIndexPointerOES(int size, int type, int stride, Addressable pointer) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBlitFramebufferANGLE(int srcX0, int srcY0, int srcX1, int srcY1, int dstX0, int dstY0, int dstX1, int dstY1, int mask, int filter) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetTexParameterIuivOES(int target, int pname, Addressable params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFramebufferFoveationParametersQCOM(int framebuffer, int layer, int focalPoint, float focalX, float focalY, float gainX, float gainY, float foveaArea) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetQueryObjectuivEXT(int id, int pname, Addressable params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTextureViewEXT(int texture, int target, int origtexture, int internalformat, int minlevel, int numlevels, int minlayer, int numlayers) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDebugMessageInsertKHR(int source, int type, int id, int severity, int length, Addressable buf) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glPointParameterx(int pname, int param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glColor4x(int red, int green, int blue, int alpha) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glLightModelxv(int pname, Addressable param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexStorage3DEXT(int target, int levels, int internalformat, int width, int height, int depth) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public byte glIsProgramPipelineEXT(int pipeline) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetIntegeri_vEXT(int target, int index, Addressable data) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDeleteQueriesEXT(int n, Addressable ids) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glCopyImageSubDataOES(int srcName, int srcTarget, int srcLevel, int srcX, int srcY, int srcZ, int dstName, int dstTarget, int dstLevel, int dstX, int dstY, int dstZ, int srcWidth, int srcHeight, int srcDepth) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBindRenderbufferOES(int target, int renderbuffer) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glNamedBufferPageCommitmentMemNV(int buffer, long offset, long size, int memory, long memOffset, byte commit) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetnUniformuivKHR(int program, int location, int bufSize, Addressable params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBlendEquationiOES(int buf, int mode) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFramebufferTexture3DOES(int target, int attachment, int textarget, int texture, int level, int zoffset) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexGeniOES(int coord, int pname, int param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glScissorIndexedNV(int index, int left, int bottom, int width, int height) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniformMatrix4x2fvNV(int location, int count, byte transpose, Addressable value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetFragmentShadingRatesEXT(int samples, int maxCount, Addressable count, Addressable shadingRates) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public int glGetFragDataIndexEXT(int program, Addressable name) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBindFragDataLocationIndexedEXT(int program, int colorNumber, int index, Addressable name) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public byte glIsEnablediEXT(int target, int index) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glRenderbufferStorageMultisampleIMG(int target, int samples, int internalformat, int width, int height) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glCompressedTexSubImage3DOES(int target, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int format, int imageSize, Addressable data) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexImage3DOES(int target, int level, int internalformat, int width, int height, int depth, int border, int format, int type, Addressable pixels) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDeleteRenderbuffersOES(int n, Addressable renderbuffers) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetnUniformfvKHR(int program, int location, int bufSize, Addressable params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public byte glExtIsProgramBinaryQCOM(int program) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDrawRangeElementsBaseVertexEXT(int mode, int start, int end, int count, int type, Addressable indices, int basevertex) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public long glGetTextureSamplerHandleIMG(int texture, int sampler) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public byte glIsVertexArrayOES(int array) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexEstimateMotionQCOM(int ref, int target, int output) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDrawTexiOES(int x, int y, int z, int width, int height) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetSamplerParameterIivEXT(int sampler, int pname, Addressable params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMapBufferRangeEXT(int target, long offset, long length, int access) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBlendFuncSeparateiOES(int buf, int srcRGB, int dstRGB, int srcAlpha, int dstAlpha) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetSamplerParameterIuivOES(int sampler, int pname, Addressable params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribDivisorNV(int index, int divisor) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetSamplerParameterIivOES(int sampler, int pname, Addressable params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glExtTexObjectStateOverrideiQCOM(int target, int pname, int param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDrawTransformFeedbackEXT(int mode, int id) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexStorage3DMultisampleOES(int target, int samples, int internalformat, int width, int height, int depth, byte fixedsamplelocations) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glViewportArrayvNV(int first, int count, Addressable v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDrawTexfOES(float x, float y, float z, float width, float height) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetInteger64vEXT(int pname, Addressable data) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glCopyTexSubImage3DOES(int target, int level, int xoffset, int yoffset, int zoffset, int x, int y, int width, int height) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glWeightPointerOES(int size, int type, int stride, Addressable pointer) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDepthRangex(int n, int f) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexGenfOES(int coord, int pname, float param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetFramebufferAttachmentParameterivOES(int target, int attachment, int pname, Addressable params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glEnableiEXT(int target, int index) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexGenivOES(int coord, int pname, Addressable params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glShadingRateCombinerOpsEXT(int combinerOp0, int combinerOp1) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glColorMaskiEXT(int index, byte r, byte g, byte b, byte a) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMaterialx(int face, int pname, int param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexEstimateMotionRegionsQCOM(int ref, int target, int output, int mask) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glViewportIndexedfOES(int index, float x, float y, float w, float h) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glNormal3x(int nx, int ny, int nz) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDrawRangeElementsBaseVertexOES(int mode, int start, int end, int count, int type, Addressable indices, int basevertex) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDrawElementsInstancedANGLE(int mode, int count, int type, Addressable indices, int primcount) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glScissorIndexedvOES(int index, Addressable v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetFloati_vNV(int target, int index, Addressable data) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glExtGetTexLevelParameterivQCOM(int texture, int face, int level, int pname, Addressable params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexParameterxv(int target, int pname, Addressable params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBlendEquationSeparateiEXT(int buf, int modeRGB, int modeAlpha) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetSamplerParameterIuivEXT(int sampler, int pname, Addressable params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetProgramPipelineInfoLogEXT(int pipeline, int bufSize, Addressable length, Addressable infoLog) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexSubImage3DOES(int target, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int format, int type, Addressable pixels) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glLoadPaletteFromModelViewMatrixOES() {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glLineWidthx(int width) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glLightModelx(int pname, int param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetQueryivEXT(int target, int pname, Addressable params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDrawBuffersIndexedEXT(int n, Addressable location, Addressable indices) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFrustumx(int l, int r, int b, int t, int n, int f) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFrustumf(float l, float r, float b, float t, float n, float f) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFramebufferTextureMultisampleMultiviewOVR(int target, int attachment, int texture, int level, int samples, int baseViewIndex, int numViews) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glRenderbufferStorageOES(int target, int internalformat, int width, int height) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glScalex(int x, int y, int z) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glEnableiOES(int target, int index) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glRenderbufferStorageMultisampleANGLE(int target, int samples, int internalformat, int width, int height) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexStorage2DEXT(int target, int levels, int internalformat, int width, int height) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBlendEquationSeparateiOES(int buf, int modeRGB, int modeAlpha) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBlendFuncSeparateiEXT(int buf, int srcRGB, int dstRGB, int srcAlpha, int dstAlpha) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glViewportIndexedfvOES(int index, Addressable v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glExtGetTexSubImageQCOM(int target, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int format, int type, Addressable texels) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glColorMaskiOES(int index, byte r, byte g, byte b, byte a) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBindVertexArrayOES(int array) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFramebufferFoveationConfigQCOM(int framebuffer, int numLayers, int focalPointsPerLayer, int requestedFeatures, Addressable providedFeatures) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGenQueriesEXT(int n, Addressable ids) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBufferPageCommitmentMemNV(int target, long offset, long size, int memory, long memOffset, byte commit) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glShadingRateQCOM(int rate) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFramebufferRenderbufferOES(int target, int attachment, int renderbuffertarget, int renderbuffer) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetBufferPointervOES(int target, int pname, Addressable params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBlendEquationSeparateOES(int modeRGB, int modeAlpha) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDrawBuffersNV(int n, Addressable bufs) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glCopyBufferSubDataNV(int readTarget, int writeTarget, long readOffset, long writeOffset, long size) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDrawElementsInstancedBaseInstanceEXT(int mode, int count, int type, Addressable indices, int instancecount, int baseinstance) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexStorageAttribs2DEXT(int target, int levels, int internalformat, int width, int height, int attrib_list) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glAlphaFuncx(int func, int ref) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniformHandleui64vIMG(int location, int count, Addressable value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glCoverageMaskNV(byte mask) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBlendEquationOES(int mode) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGenerateMipmapOES(int target) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glCoverageOperationNV(int operation) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glClipPlanefIMG(int p, Addressable eqn) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glCompressedTexImage3DOES(int target, int level, int internalformat, int width, int height, int depth, int border, int imageSize, Addressable data) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public byte glIsEnablediNV(int target, int index) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glScissorIndexedOES(int index, int left, int bottom, int width, int height) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetProgramBinaryOES(int program, int bufSize, Addressable length, Addressable binaryFormat, Addressable binary) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDrawBuffersEXT(int n, Addressable bufs) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public int glCreateShaderProgramvEXT(int type, int count, Addressable strings) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetRenderbufferParameterivOES(int target, int pname, Addressable params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glViewportIndexedfNV(int index, float x, float y, float w, float h) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDrawElementsBaseVertexOES(int mode, int count, int type, Addressable indices, int basevertex) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glExtGetShadersQCOM(Addressable shaders, int maxShaders, Addressable numShaders) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFramebufferTexture2DOES(int target, int attachment, int textarget, int texture, int level) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glPolygonOffsetx(int factor, int units) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDepthRangeIndexedfOES(int index, float n, float f) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDepthRangeIndexedfNV(int index, float n, float f) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFramebufferTexture2DMultisampleIMG(int target, int attachment, int textarget, int texture, int level, int samples) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glPointParameterxv(int pname, Addressable params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetDriverControlStringQCOM(int driverControl, int bufSize, Addressable length, Addressable driverControlString) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetLightxvOES(int light, int pname, Addressable params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetTexParameterxv(int target, int pname, Addressable params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glSampleCoveragexOES(int value, byte invert) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBlendBarrier() {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniformMatrix3x2fvNV(int location, int count, byte transpose, Addressable value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glPopDebugGroupKHR() {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDrawElementsInstancedBaseVertexOES(int mode, int count, int type, Addressable indices, int instancecount, int basevertex) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public int glClientWaitSyncAPPLE(Addressable sync, int flags, long timeout) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glActiveShaderProgramEXT(int pipeline, int program) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glPatchParameteriEXT(int pname, int value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexPageCommitmentEXT(int target, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, byte commit) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexParameterIuivOES(int target, int pname, Addressable params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDepthRangeArraydvNV(int first, int count, Addressable v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glObjectLabelKHR(int identifier, int name, int length, Addressable label) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glEndQueryEXT(int target) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexParameterIivOES(int target, int pname, Addressable params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBlendFuncSeparateOES(int srcRGB, int dstRGB, int srcAlpha, int dstAlpha) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glReadBufferIndexedEXT(int src, int index) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public long glGetTextureHandleIMG(int texture) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glEnableDriverControlQCOM(int driverControl) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDrawElementsInstancedNV(int mode, int count, int type, Addressable indices, int primcount) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public byte glIsQueryEXT(int id) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glPointParameterxOES(int pname, int param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glExtGetBufferPointervQCOM(int target, Addressable params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public byte glIsEnablediOES(int target, int index) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiDrawArraysIndirectEXT(int mode, Addressable indirect, int drawcount, int stride) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribDivisorEXT(int index, int divisor) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMapBufferOES(int target, int access) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBindFramebufferOES(int target, int framebuffer) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexBufferRangeOES(int target, int internalformat, int buffer, long offset, long size) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFramebufferTexture2DDownsampleIMG(int target, int attachment, int textarget, int texture, int level, int xscale, int yscale) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetTexGenfvOES(int coord, int pname, Addressable params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDrawTexsOES(short x, short y, short z, short width, short height) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public byte glUnmapBufferOES(int target) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniformMatrix2x4fvNV(int location, int count, byte transpose, Addressable value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glExtGetTexturesQCOM(Addressable textures, int maxTextures, Addressable numTextures) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glScissorArrayvOES(int first, int count, Addressable v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDrawElementsBaseVertexEXT(int mode, int count, int type, Addressable indices, int basevertex) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public byte glIsSyncAPPLE(Addressable sync) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetMaterialxvOES(int face, int pname, Addressable params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glPolygonModeNV(int face, int mode) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetTexEnvxv(int target, int pname, Addressable params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTranslatex(int x, int y, int z) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glReadnPixelsEXT(int x, int y, int width, int height, int format, int type, int bufSize, Addressable data) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetClipPlanex(int plane, Addressable equation) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGenFramebuffersOES(int n, Addressable framebuffers) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetClipPlanef(int plane, Addressable equation) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetFloati_vOES(int target, int index, Addressable data) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFramebufferPixelLocalStorageSizeEXT(int target, int size) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexStorage1DEXT(int target, int levels, int internalformat, int width) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public int glGetGraphicsResetStatusKHR() {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glReadBufferNV(int mode) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public byte glIsFramebufferOES(int framebuffer) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDrawTexsvOES(Addressable coords) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glClearTexSubImageEXT(int texture, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int format, int type, Addressable data) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexPageCommitmentMemNV(int target, int layer, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int memory, long offset, byte commit) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGenProgramPipelinesEXT(int n, Addressable pipelines) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetPointervKHR(int pname, Addressable params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glPointSizePointerOES(int type, int stride, Addressable pointer) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMaterialxv(int face, int pname, Addressable param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexturePageCommitmentMemNV(int texture, int layer, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int memory, long offset, byte commit) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glPushDebugGroupKHR(int source, int id, int length, Addressable message) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  @Override
  public void glutCheckLoop() {
  }

  @Override
  public MemoryAddress glutGetProcAddress(Addressable arg0) {
    return null;
  }

  @Override
  public void glutSurfaceTexture(int arg0, int arg1, int arg2) {
  }

  @Override
  public void glutWMCloseFunc(Addressable arg0) {
  }

}
