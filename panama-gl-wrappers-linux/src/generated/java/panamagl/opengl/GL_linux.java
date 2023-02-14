package panamagl.opengl; 

import opengl.ubuntu.v20.glut_h;
import static opengl.ubuntu.v20.glut_h.*;
import java.lang.foreign.*;

public class GL_linux implements GL_1_0, GL_1_1, GL_1_2, GL_1_3 {
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

}
