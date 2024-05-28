package panamagl.platform.windows.x64; 

import java.lang.foreign.MemorySegment;
import freeglut.windows.x86.freeglut_h;

public class GL_windows_x64 extends panamagl.opengl.AGL implements panamagl.opengl.GL, panamagl.opengl.GLU, panamagl.opengl.GLUT {
  public void glAccum(int op, float value) {
    freeglut_h.glAccum(op, value);
  }

  public void glAlphaFunc(int func, float ref) {
    freeglut_h.glAlphaFunc(func, ref);
  }

  public byte glAreTexturesResident(int n, MemorySegment textures, MemorySegment residences) {
    return freeglut_h.glAreTexturesResident(n, textures, residences);
  }

  public void glArrayElement(int i) {
    freeglut_h.glArrayElement(i);
  }

  public void glBegin(int mode) {
    freeglut_h.glBegin(mode);
  }

  public void glBindTexture(int target, int texture) {
    freeglut_h.glBindTexture(target, texture);
  }

  public void glBitmap(int width, int height, float xorig, float yorig, float xmove, float ymove, MemorySegment bitmap) {
    freeglut_h.glBitmap(width, height, xorig, yorig, xmove, ymove, bitmap);
  }

  public void glBlendFunc(int sfactor, int dfactor) {
    freeglut_h.glBlendFunc(sfactor, dfactor);
  }

  public void glCallList(int list) {
    freeglut_h.glCallList(list);
  }

  public void glCallLists(int n, int type, MemorySegment lists) {
    freeglut_h.glCallLists(n, type, lists);
  }

  public void glClear(int mask) {
    freeglut_h.glClear(mask);
  }

  public void glClearAccum(float red, float green, float blue, float alpha) {
    freeglut_h.glClearAccum(red, green, blue, alpha);
  }

  public void glClearColor(float red, float green, float blue, float alpha) {
    freeglut_h.glClearColor(red, green, blue, alpha);
  }

  public void glClearDepth(double depth) {
    freeglut_h.glClearDepth(depth);
  }

  public void glClearIndex(float c) {
    freeglut_h.glClearIndex(c);
  }

  public void glClearStencil(int s) {
    freeglut_h.glClearStencil(s);
  }

  public void glClipPlane(int plane, MemorySegment equation) {
    freeglut_h.glClipPlane(plane, equation);
  }

  public void glColor3b(byte red, byte green, byte blue) {
    freeglut_h.glColor3b(red, green, blue);
  }

  public void glColor3bv(MemorySegment v) {
    freeglut_h.glColor3bv(v);
  }

  public void glColor3d(double red, double green, double blue) {
    freeglut_h.glColor3d(red, green, blue);
  }

  public void glColor3dv(MemorySegment v) {
    freeglut_h.glColor3dv(v);
  }

  public void glColor3f(float red, float green, float blue) {
    freeglut_h.glColor3f(red, green, blue);
  }

  public void glColor3fv(MemorySegment v) {
    freeglut_h.glColor3fv(v);
  }

  public void glColor3i(int red, int green, int blue) {
    freeglut_h.glColor3i(red, green, blue);
  }

  public void glColor3iv(MemorySegment v) {
    freeglut_h.glColor3iv(v);
  }

  public void glColor3s(short red, short green, short blue) {
    freeglut_h.glColor3s(red, green, blue);
  }

  public void glColor3sv(MemorySegment v) {
    freeglut_h.glColor3sv(v);
  }

  public void glColor3ub(byte red, byte green, byte blue) {
    freeglut_h.glColor3ub(red, green, blue);
  }

  public void glColor3ubv(MemorySegment v) {
    freeglut_h.glColor3ubv(v);
  }

  public void glColor3ui(int red, int green, int blue) {
    freeglut_h.glColor3ui(red, green, blue);
  }

  public void glColor3uiv(MemorySegment v) {
    freeglut_h.glColor3uiv(v);
  }

  public void glColor3us(short red, short green, short blue) {
    freeglut_h.glColor3us(red, green, blue);
  }

  public void glColor3usv(MemorySegment v) {
    freeglut_h.glColor3usv(v);
  }

  public void glColor4b(byte red, byte green, byte blue, byte alpha) {
    freeglut_h.glColor4b(red, green, blue, alpha);
  }

  public void glColor4bv(MemorySegment v) {
    freeglut_h.glColor4bv(v);
  }

  public void glColor4d(double red, double green, double blue, double alpha) {
    freeglut_h.glColor4d(red, green, blue, alpha);
  }

  public void glColor4dv(MemorySegment v) {
    freeglut_h.glColor4dv(v);
  }

  public void glColor4f(float red, float green, float blue, float alpha) {
    freeglut_h.glColor4f(red, green, blue, alpha);
  }

  public void glColor4fv(MemorySegment v) {
    freeglut_h.glColor4fv(v);
  }

  public void glColor4i(int red, int green, int blue, int alpha) {
    freeglut_h.glColor4i(red, green, blue, alpha);
  }

  public void glColor4iv(MemorySegment v) {
    freeglut_h.glColor4iv(v);
  }

  public void glColor4s(short red, short green, short blue, short alpha) {
    freeglut_h.glColor4s(red, green, blue, alpha);
  }

  public void glColor4sv(MemorySegment v) {
    freeglut_h.glColor4sv(v);
  }

  public void glColor4ub(byte red, byte green, byte blue, byte alpha) {
    freeglut_h.glColor4ub(red, green, blue, alpha);
  }

  public void glColor4ubv(MemorySegment v) {
    freeglut_h.glColor4ubv(v);
  }

  public void glColor4ui(int red, int green, int blue, int alpha) {
    freeglut_h.glColor4ui(red, green, blue, alpha);
  }

  public void glColor4uiv(MemorySegment v) {
    freeglut_h.glColor4uiv(v);
  }

  public void glColor4us(short red, short green, short blue, short alpha) {
    freeglut_h.glColor4us(red, green, blue, alpha);
  }

  public void glColor4usv(MemorySegment v) {
    freeglut_h.glColor4usv(v);
  }

  public void glColorMask(byte red, byte green, byte blue, byte alpha) {
    freeglut_h.glColorMask(red, green, blue, alpha);
  }

  public void glColorMaterial(int face, int mode) {
    freeglut_h.glColorMaterial(face, mode);
  }

  public void glColorPointer(int size, int type, int stride, MemorySegment pointer) {
    freeglut_h.glColorPointer(size, type, stride, pointer);
  }

  public void glCopyPixels(int x, int y, int width, int height, int type) {
    freeglut_h.glCopyPixels(x, y, width, height, type);
  }

  public void glCopyTexImage1D(int target, int level, int internalformat, int x, int y, int width, int border) {
    freeglut_h.glCopyTexImage1D(target, level, internalformat, x, y, width, border);
  }

  public void glCopyTexImage2D(int target, int level, int internalformat, int x, int y, int width, int height, int border) {
    freeglut_h.glCopyTexImage2D(target, level, internalformat, x, y, width, height, border);
  }

  public void glCopyTexSubImage1D(int target, int level, int xoffset, int x, int y, int width) {
    freeglut_h.glCopyTexSubImage1D(target, level, xoffset, x, y, width);
  }

  public void glCopyTexSubImage2D(int target, int level, int xoffset, int yoffset, int x, int y, int width, int height) {
    freeglut_h.glCopyTexSubImage2D(target, level, xoffset, yoffset, x, y, width, height);
  }

  public void glCullFace(int mode) {
    freeglut_h.glCullFace(mode);
  }

  public void glDeleteLists(int list, int range) {
    freeglut_h.glDeleteLists(list, range);
  }

  public void glDeleteTextures(int n, MemorySegment textures) {
    freeglut_h.glDeleteTextures(n, textures);
  }

  public void glDepthFunc(int func) {
    freeglut_h.glDepthFunc(func);
  }

  public void glDepthMask(byte flag) {
    freeglut_h.glDepthMask(flag);
  }

  public void glDepthRange(double n, double f) {
    freeglut_h.glDepthRange(n, f);
  }

  public void glDisable(int cap) {
    freeglut_h.glDisable(cap);
  }

  public void glDisableClientState(int array) {
    freeglut_h.glDisableClientState(array);
  }

  public void glDrawArrays(int mode, int first, int count) {
    freeglut_h.glDrawArrays(mode, first, count);
  }

  public void glDrawBuffer(int buf) {
    freeglut_h.glDrawBuffer(buf);
  }

  public void glDrawElements(int mode, int count, int type, MemorySegment indices) {
    freeglut_h.glDrawElements(mode, count, type, indices);
  }

  public void glDrawPixels(int width, int height, int format, int type, MemorySegment pixels) {
    freeglut_h.glDrawPixels(width, height, format, type, pixels);
  }

  public void glEdgeFlag(byte flag) {
    freeglut_h.glEdgeFlag(flag);
  }

  public void glEdgeFlagPointer(int stride, MemorySegment pointer) {
    freeglut_h.glEdgeFlagPointer(stride, pointer);
  }

  public void glEdgeFlagv(MemorySegment flag) {
    freeglut_h.glEdgeFlagv(flag);
  }

  public void glEnable(int cap) {
    freeglut_h.glEnable(cap);
  }

  public void glEnableClientState(int array) {
    freeglut_h.glEnableClientState(array);
  }

  public void glEnd() {
    freeglut_h.glEnd();
  }

  public void glEndList() {
    freeglut_h.glEndList();
  }

  public void glEvalCoord1d(double u) {
    freeglut_h.glEvalCoord1d(u);
  }

  public void glEvalCoord1dv(MemorySegment u) {
    freeglut_h.glEvalCoord1dv(u);
  }

  public void glEvalCoord1f(float u) {
    freeglut_h.glEvalCoord1f(u);
  }

  public void glEvalCoord1fv(MemorySegment u) {
    freeglut_h.glEvalCoord1fv(u);
  }

  public void glEvalCoord2d(double u, double v) {
    freeglut_h.glEvalCoord2d(u, v);
  }

  public void glEvalCoord2dv(MemorySegment u) {
    freeglut_h.glEvalCoord2dv(u);
  }

  public void glEvalCoord2f(float u, float v) {
    freeglut_h.glEvalCoord2f(u, v);
  }

  public void glEvalCoord2fv(MemorySegment u) {
    freeglut_h.glEvalCoord2fv(u);
  }

  public void glEvalMesh1(int mode, int i1, int i2) {
    freeglut_h.glEvalMesh1(mode, i1, i2);
  }

  public void glEvalMesh2(int mode, int i1, int i2, int j1, int j2) {
    freeglut_h.glEvalMesh2(mode, i1, i2, j1, j2);
  }

  public void glEvalPoint1(int i) {
    freeglut_h.glEvalPoint1(i);
  }

  public void glEvalPoint2(int i, int j) {
    freeglut_h.glEvalPoint2(i, j);
  }

  public void glFeedbackBuffer(int size, int type, MemorySegment buffer) {
    freeglut_h.glFeedbackBuffer(size, type, buffer);
  }

  public void glFinish() {
    freeglut_h.glFinish();
  }

  public void glFlush() {
    freeglut_h.glFlush();
  }

  public void glFogf(int pname, float param) {
    freeglut_h.glFogf(pname, param);
  }

  public void glFogfv(int pname, MemorySegment params) {
    freeglut_h.glFogfv(pname, params);
  }

  public void glFogi(int pname, int param) {
    freeglut_h.glFogi(pname, param);
  }

  public void glFogiv(int pname, MemorySegment params) {
    freeglut_h.glFogiv(pname, params);
  }

  public void glFrontFace(int mode) {
    freeglut_h.glFrontFace(mode);
  }

  public void glFrustum(double left, double right, double bottom, double top, double zNear, double zFar) {
    freeglut_h.glFrustum(left, right, bottom, top, zNear, zFar);
  }

  public int glGenLists(int range) {
    return freeglut_h.glGenLists(range);
  }

  public void glGenTextures(int n, MemorySegment textures) {
    freeglut_h.glGenTextures(n, textures);
  }

  public void glGetBooleanv(int pname, MemorySegment data) {
    freeglut_h.glGetBooleanv(pname, data);
  }

  public void glGetClipPlane(int plane, MemorySegment equation) {
    freeglut_h.glGetClipPlane(plane, equation);
  }

  public void glGetDoublev(int pname, MemorySegment data) {
    freeglut_h.glGetDoublev(pname, data);
  }

  public int glGetError() {
    return freeglut_h.glGetError();
  }

  public void glGetFloatv(int pname, MemorySegment data) {
    freeglut_h.glGetFloatv(pname, data);
  }

  public void glGetIntegerv(int pname, MemorySegment data) {
    freeglut_h.glGetIntegerv(pname, data);
  }

  public void glGetLightfv(int light, int pname, MemorySegment params) {
    freeglut_h.glGetLightfv(light, pname, params);
  }

  public void glGetLightiv(int light, int pname, MemorySegment params) {
    freeglut_h.glGetLightiv(light, pname, params);
  }

  public void glGetMapdv(int target, int query, MemorySegment v) {
    freeglut_h.glGetMapdv(target, query, v);
  }

  public void glGetMapfv(int target, int query, MemorySegment v) {
    freeglut_h.glGetMapfv(target, query, v);
  }

  public void glGetMapiv(int target, int query, MemorySegment v) {
    freeglut_h.glGetMapiv(target, query, v);
  }

  public void glGetMaterialfv(int face, int pname, MemorySegment params) {
    freeglut_h.glGetMaterialfv(face, pname, params);
  }

  public void glGetMaterialiv(int face, int pname, MemorySegment params) {
    freeglut_h.glGetMaterialiv(face, pname, params);
  }

  public void glGetPixelMapfv(int map, MemorySegment values) {
    freeglut_h.glGetPixelMapfv(map, values);
  }

  public void glGetPixelMapuiv(int map, MemorySegment values) {
    freeglut_h.glGetPixelMapuiv(map, values);
  }

  public void glGetPixelMapusv(int map, MemorySegment values) {
    freeglut_h.glGetPixelMapusv(map, values);
  }

  public void glGetPointerv(int pname, MemorySegment params) {
    freeglut_h.glGetPointerv(pname, params);
  }

  public void glGetPolygonStipple(MemorySegment mask) {
    freeglut_h.glGetPolygonStipple(mask);
  }

  public MemorySegment glGetString(int name) {
    return freeglut_h.glGetString(name);
  }

  public void glGetTexEnvfv(int target, int pname, MemorySegment params) {
    freeglut_h.glGetTexEnvfv(target, pname, params);
  }

  public void glGetTexEnviv(int target, int pname, MemorySegment params) {
    freeglut_h.glGetTexEnviv(target, pname, params);
  }

  public void glGetTexGendv(int coord, int pname, MemorySegment params) {
    freeglut_h.glGetTexGendv(coord, pname, params);
  }

  public void glGetTexGenfv(int coord, int pname, MemorySegment params) {
    freeglut_h.glGetTexGenfv(coord, pname, params);
  }

  public void glGetTexGeniv(int coord, int pname, MemorySegment params) {
    freeglut_h.glGetTexGeniv(coord, pname, params);
  }

  public void glGetTexImage(int target, int level, int format, int type, MemorySegment pixels) {
    freeglut_h.glGetTexImage(target, level, format, type, pixels);
  }

  public void glGetTexLevelParameterfv(int target, int level, int pname, MemorySegment params) {
    freeglut_h.glGetTexLevelParameterfv(target, level, pname, params);
  }

  public void glGetTexLevelParameteriv(int target, int level, int pname, MemorySegment params) {
    freeglut_h.glGetTexLevelParameteriv(target, level, pname, params);
  }

  public void glGetTexParameterfv(int target, int pname, MemorySegment params) {
    freeglut_h.glGetTexParameterfv(target, pname, params);
  }

  public void glGetTexParameteriv(int target, int pname, MemorySegment params) {
    freeglut_h.glGetTexParameteriv(target, pname, params);
  }

  public void glHint(int target, int mode) {
    freeglut_h.glHint(target, mode);
  }

  public void glIndexMask(int mask) {
    freeglut_h.glIndexMask(mask);
  }

  public void glIndexPointer(int type, int stride, MemorySegment pointer) {
    freeglut_h.glIndexPointer(type, stride, pointer);
  }

  public void glIndexd(double c) {
    freeglut_h.glIndexd(c);
  }

  public void glIndexdv(MemorySegment c) {
    freeglut_h.glIndexdv(c);
  }

  public void glIndexf(float c) {
    freeglut_h.glIndexf(c);
  }

  public void glIndexfv(MemorySegment c) {
    freeglut_h.glIndexfv(c);
  }

  public void glIndexi(int c) {
    freeglut_h.glIndexi(c);
  }

  public void glIndexiv(MemorySegment c) {
    freeglut_h.glIndexiv(c);
  }

  public void glIndexs(short c) {
    freeglut_h.glIndexs(c);
  }

  public void glIndexsv(MemorySegment c) {
    freeglut_h.glIndexsv(c);
  }

  public void glIndexub(byte c) {
    freeglut_h.glIndexub(c);
  }

  public void glIndexubv(MemorySegment c) {
    freeglut_h.glIndexubv(c);
  }

  public void glInitNames() {
    freeglut_h.glInitNames();
  }

  public void glInterleavedArrays(int format, int stride, MemorySegment pointer) {
    freeglut_h.glInterleavedArrays(format, stride, pointer);
  }

  public byte glIsEnabled(int cap) {
    return freeglut_h.glIsEnabled(cap);
  }

  public byte glIsList(int list) {
    return freeglut_h.glIsList(list);
  }

  public byte glIsTexture(int texture) {
    return freeglut_h.glIsTexture(texture);
  }

  public void glLightModelf(int pname, float param) {
    freeglut_h.glLightModelf(pname, param);
  }

  public void glLightModelfv(int pname, MemorySegment params) {
    freeglut_h.glLightModelfv(pname, params);
  }

  public void glLightModeli(int pname, int param) {
    freeglut_h.glLightModeli(pname, param);
  }

  public void glLightModeliv(int pname, MemorySegment params) {
    freeglut_h.glLightModeliv(pname, params);
  }

  public void glLightf(int light, int pname, float param) {
    freeglut_h.glLightf(light, pname, param);
  }

  public void glLightfv(int light, int pname, MemorySegment params) {
    freeglut_h.glLightfv(light, pname, params);
  }

  public void glLighti(int light, int pname, int param) {
    freeglut_h.glLighti(light, pname, param);
  }

  public void glLightiv(int light, int pname, MemorySegment params) {
    freeglut_h.glLightiv(light, pname, params);
  }

  public void glLineStipple(int factor, short pattern) {
    freeglut_h.glLineStipple(factor, pattern);
  }

  public void glLineWidth(float width) {
    freeglut_h.glLineWidth(width);
  }

  public void glListBase(int base) {
    freeglut_h.glListBase(base);
  }

  public void glLoadIdentity() {
    freeglut_h.glLoadIdentity();
  }

  public void glLoadMatrixd(MemorySegment m) {
    freeglut_h.glLoadMatrixd(m);
  }

  public void glLoadMatrixf(MemorySegment m) {
    freeglut_h.glLoadMatrixf(m);
  }

  public void glLoadName(int name) {
    freeglut_h.glLoadName(name);
  }

  public void glLogicOp(int opcode) {
    freeglut_h.glLogicOp(opcode);
  }

  public void glMap1d(int target, double u1, double u2, int stride, int order, MemorySegment points) {
    freeglut_h.glMap1d(target, u1, u2, stride, order, points);
  }

  public void glMap1f(int target, float u1, float u2, int stride, int order, MemorySegment points) {
    freeglut_h.glMap1f(target, u1, u2, stride, order, points);
  }

  public void glMap2d(int target, double u1, double u2, int ustride, int uorder, double v1, double v2, int vstride, int vorder, MemorySegment points) {
    freeglut_h.glMap2d(target, u1, u2, ustride, uorder, v1, v2, vstride, vorder, points);
  }

  public void glMap2f(int target, float u1, float u2, int ustride, int uorder, float v1, float v2, int vstride, int vorder, MemorySegment points) {
    freeglut_h.glMap2f(target, u1, u2, ustride, uorder, v1, v2, vstride, vorder, points);
  }

  public void glMapGrid1d(int un, double u1, double u2) {
    freeglut_h.glMapGrid1d(un, u1, u2);
  }

  public void glMapGrid1f(int un, float u1, float u2) {
    freeglut_h.glMapGrid1f(un, u1, u2);
  }

  public void glMapGrid2d(int un, double u1, double u2, int vn, double v1, double v2) {
    freeglut_h.glMapGrid2d(un, u1, u2, vn, v1, v2);
  }

  public void glMapGrid2f(int un, float u1, float u2, int vn, float v1, float v2) {
    freeglut_h.glMapGrid2f(un, u1, u2, vn, v1, v2);
  }

  public void glMaterialf(int face, int pname, float param) {
    freeglut_h.glMaterialf(face, pname, param);
  }

  public void glMaterialfv(int face, int pname, MemorySegment params) {
    freeglut_h.glMaterialfv(face, pname, params);
  }

  public void glMateriali(int face, int pname, int param) {
    freeglut_h.glMateriali(face, pname, param);
  }

  public void glMaterialiv(int face, int pname, MemorySegment params) {
    freeglut_h.glMaterialiv(face, pname, params);
  }

  public void glMatrixMode(int mode) {
    freeglut_h.glMatrixMode(mode);
  }

  public void glMultMatrixd(MemorySegment m) {
    freeglut_h.glMultMatrixd(m);
  }

  public void glMultMatrixf(MemorySegment m) {
    freeglut_h.glMultMatrixf(m);
  }

  public void glNewList(int list, int mode) {
    freeglut_h.glNewList(list, mode);
  }

  public void glNormal3b(byte nx, byte ny, byte nz) {
    freeglut_h.glNormal3b(nx, ny, nz);
  }

  public void glNormal3bv(MemorySegment v) {
    freeglut_h.glNormal3bv(v);
  }

  public void glNormal3d(double nx, double ny, double nz) {
    freeglut_h.glNormal3d(nx, ny, nz);
  }

  public void glNormal3dv(MemorySegment v) {
    freeglut_h.glNormal3dv(v);
  }

  public void glNormal3f(float nx, float ny, float nz) {
    freeglut_h.glNormal3f(nx, ny, nz);
  }

  public void glNormal3fv(MemorySegment v) {
    freeglut_h.glNormal3fv(v);
  }

  public void glNormal3i(int nx, int ny, int nz) {
    freeglut_h.glNormal3i(nx, ny, nz);
  }

  public void glNormal3iv(MemorySegment v) {
    freeglut_h.glNormal3iv(v);
  }

  public void glNormal3s(short nx, short ny, short nz) {
    freeglut_h.glNormal3s(nx, ny, nz);
  }

  public void glNormal3sv(MemorySegment v) {
    freeglut_h.glNormal3sv(v);
  }

  public void glNormalPointer(int type, int stride, MemorySegment pointer) {
    freeglut_h.glNormalPointer(type, stride, pointer);
  }

  public void glOrtho(double left, double right, double bottom, double top, double zNear, double zFar) {
    freeglut_h.glOrtho(left, right, bottom, top, zNear, zFar);
  }

  public void glPassThrough(float token) {
    freeglut_h.glPassThrough(token);
  }

  public void glPixelMapfv(int map, int mapsize, MemorySegment values) {
    freeglut_h.glPixelMapfv(map, mapsize, values);
  }

  public void glPixelMapuiv(int map, int mapsize, MemorySegment values) {
    freeglut_h.glPixelMapuiv(map, mapsize, values);
  }

  public void glPixelMapusv(int map, int mapsize, MemorySegment values) {
    freeglut_h.glPixelMapusv(map, mapsize, values);
  }

  public void glPixelStoref(int pname, float param) {
    freeglut_h.glPixelStoref(pname, param);
  }

  public void glPixelStorei(int pname, int param) {
    freeglut_h.glPixelStorei(pname, param);
  }

  public void glPixelTransferf(int pname, float param) {
    freeglut_h.glPixelTransferf(pname, param);
  }

  public void glPixelTransferi(int pname, int param) {
    freeglut_h.glPixelTransferi(pname, param);
  }

  public void glPixelZoom(float xfactor, float yfactor) {
    freeglut_h.glPixelZoom(xfactor, yfactor);
  }

  public void glPointSize(float size) {
    freeglut_h.glPointSize(size);
  }

  public void glPolygonMode(int face, int mode) {
    freeglut_h.glPolygonMode(face, mode);
  }

  public void glPolygonOffset(float factor, float units) {
    freeglut_h.glPolygonOffset(factor, units);
  }

  public void glPolygonStipple(MemorySegment mask) {
    freeglut_h.glPolygonStipple(mask);
  }

  public void glPopAttrib() {
    freeglut_h.glPopAttrib();
  }

  public void glPopClientAttrib() {
    freeglut_h.glPopClientAttrib();
  }

  public void glPopMatrix() {
    freeglut_h.glPopMatrix();
  }

  public void glPopName() {
    freeglut_h.glPopName();
  }

  public void glPrioritizeTextures(int n, MemorySegment textures, MemorySegment priorities) {
    freeglut_h.glPrioritizeTextures(n, textures, priorities);
  }

  public void glPushAttrib(int mask) {
    freeglut_h.glPushAttrib(mask);
  }

  public void glPushClientAttrib(int mask) {
    freeglut_h.glPushClientAttrib(mask);
  }

  public void glPushMatrix() {
    freeglut_h.glPushMatrix();
  }

  public void glPushName(int name) {
    freeglut_h.glPushName(name);
  }

  public void glRasterPos2d(double x, double y) {
    freeglut_h.glRasterPos2d(x, y);
  }

  public void glRasterPos2dv(MemorySegment v) {
    freeglut_h.glRasterPos2dv(v);
  }

  public void glRasterPos2f(float x, float y) {
    freeglut_h.glRasterPos2f(x, y);
  }

  public void glRasterPos2fv(MemorySegment v) {
    freeglut_h.glRasterPos2fv(v);
  }

  public void glRasterPos2i(int x, int y) {
    freeglut_h.glRasterPos2i(x, y);
  }

  public void glRasterPos2iv(MemorySegment v) {
    freeglut_h.glRasterPos2iv(v);
  }

  public void glRasterPos2s(short x, short y) {
    freeglut_h.glRasterPos2s(x, y);
  }

  public void glRasterPos2sv(MemorySegment v) {
    freeglut_h.glRasterPos2sv(v);
  }

  public void glRasterPos3d(double x, double y, double z) {
    freeglut_h.glRasterPos3d(x, y, z);
  }

  public void glRasterPos3dv(MemorySegment v) {
    freeglut_h.glRasterPos3dv(v);
  }

  public void glRasterPos3f(float x, float y, float z) {
    freeglut_h.glRasterPos3f(x, y, z);
  }

  public void glRasterPos3fv(MemorySegment v) {
    freeglut_h.glRasterPos3fv(v);
  }

  public void glRasterPos3i(int x, int y, int z) {
    freeglut_h.glRasterPos3i(x, y, z);
  }

  public void glRasterPos3iv(MemorySegment v) {
    freeglut_h.glRasterPos3iv(v);
  }

  public void glRasterPos3s(short x, short y, short z) {
    freeglut_h.glRasterPos3s(x, y, z);
  }

  public void glRasterPos3sv(MemorySegment v) {
    freeglut_h.glRasterPos3sv(v);
  }

  public void glRasterPos4d(double x, double y, double z, double w) {
    freeglut_h.glRasterPos4d(x, y, z, w);
  }

  public void glRasterPos4dv(MemorySegment v) {
    freeglut_h.glRasterPos4dv(v);
  }

  public void glRasterPos4f(float x, float y, float z, float w) {
    freeglut_h.glRasterPos4f(x, y, z, w);
  }

  public void glRasterPos4fv(MemorySegment v) {
    freeglut_h.glRasterPos4fv(v);
  }

  public void glRasterPos4i(int x, int y, int z, int w) {
    freeglut_h.glRasterPos4i(x, y, z, w);
  }

  public void glRasterPos4iv(MemorySegment v) {
    freeglut_h.glRasterPos4iv(v);
  }

  public void glRasterPos4s(short x, short y, short z, short w) {
    freeglut_h.glRasterPos4s(x, y, z, w);
  }

  public void glRasterPos4sv(MemorySegment v) {
    freeglut_h.glRasterPos4sv(v);
  }

  public void glReadBuffer(int src) {
    freeglut_h.glReadBuffer(src);
  }

  public void glReadPixels(int x, int y, int width, int height, int format, int type, MemorySegment pixels) {
    freeglut_h.glReadPixels(x, y, width, height, format, type, pixels);
  }

  public void glRectd(double x1, double y1, double x2, double y2) {
    freeglut_h.glRectd(x1, y1, x2, y2);
  }

  public void glRectdv(MemorySegment v1, MemorySegment v2) {
    freeglut_h.glRectdv(v1, v2);
  }

  public void glRectf(float x1, float y1, float x2, float y2) {
    freeglut_h.glRectf(x1, y1, x2, y2);
  }

  public void glRectfv(MemorySegment v1, MemorySegment v2) {
    freeglut_h.glRectfv(v1, v2);
  }

  public void glRecti(int x1, int y1, int x2, int y2) {
    freeglut_h.glRecti(x1, y1, x2, y2);
  }

  public void glRectiv(MemorySegment v1, MemorySegment v2) {
    freeglut_h.glRectiv(v1, v2);
  }

  public void glRects(short x1, short y1, short x2, short y2) {
    freeglut_h.glRects(x1, y1, x2, y2);
  }

  public void glRectsv(MemorySegment v1, MemorySegment v2) {
    freeglut_h.glRectsv(v1, v2);
  }

  public int glRenderMode(int mode) {
    return freeglut_h.glRenderMode(mode);
  }

  public void glRotated(double angle, double x, double y, double z) {
    freeglut_h.glRotated(angle, x, y, z);
  }

  public void glRotatef(float angle, float x, float y, float z) {
    freeglut_h.glRotatef(angle, x, y, z);
  }

  public void glScaled(double x, double y, double z) {
    freeglut_h.glScaled(x, y, z);
  }

  public void glScalef(float x, float y, float z) {
    freeglut_h.glScalef(x, y, z);
  }

  public void glScissor(int x, int y, int width, int height) {
    freeglut_h.glScissor(x, y, width, height);
  }

  public void glSelectBuffer(int size, MemorySegment buffer) {
    freeglut_h.glSelectBuffer(size, buffer);
  }

  public void glShadeModel(int mode) {
    freeglut_h.glShadeModel(mode);
  }

  public void glStencilFunc(int func, int ref, int mask) {
    freeglut_h.glStencilFunc(func, ref, mask);
  }

  public void glStencilMask(int mask) {
    freeglut_h.glStencilMask(mask);
  }

  public void glStencilOp(int fail, int zfail, int zpass) {
    freeglut_h.glStencilOp(fail, zfail, zpass);
  }

  public void glTexCoord1d(double s) {
    freeglut_h.glTexCoord1d(s);
  }

  public void glTexCoord1dv(MemorySegment v) {
    freeglut_h.glTexCoord1dv(v);
  }

  public void glTexCoord1f(float s) {
    freeglut_h.glTexCoord1f(s);
  }

  public void glTexCoord1fv(MemorySegment v) {
    freeglut_h.glTexCoord1fv(v);
  }

  public void glTexCoord1i(int s) {
    freeglut_h.glTexCoord1i(s);
  }

  public void glTexCoord1iv(MemorySegment v) {
    freeglut_h.glTexCoord1iv(v);
  }

  public void glTexCoord1s(short s) {
    freeglut_h.glTexCoord1s(s);
  }

  public void glTexCoord1sv(MemorySegment v) {
    freeglut_h.glTexCoord1sv(v);
  }

  public void glTexCoord2d(double s, double t) {
    freeglut_h.glTexCoord2d(s, t);
  }

  public void glTexCoord2dv(MemorySegment v) {
    freeglut_h.glTexCoord2dv(v);
  }

  public void glTexCoord2f(float s, float t) {
    freeglut_h.glTexCoord2f(s, t);
  }

  public void glTexCoord2fv(MemorySegment v) {
    freeglut_h.glTexCoord2fv(v);
  }

  public void glTexCoord2i(int s, int t) {
    freeglut_h.glTexCoord2i(s, t);
  }

  public void glTexCoord2iv(MemorySegment v) {
    freeglut_h.glTexCoord2iv(v);
  }

  public void glTexCoord2s(short s, short t) {
    freeglut_h.glTexCoord2s(s, t);
  }

  public void glTexCoord2sv(MemorySegment v) {
    freeglut_h.glTexCoord2sv(v);
  }

  public void glTexCoord3d(double s, double t, double r) {
    freeglut_h.glTexCoord3d(s, t, r);
  }

  public void glTexCoord3dv(MemorySegment v) {
    freeglut_h.glTexCoord3dv(v);
  }

  public void glTexCoord3f(float s, float t, float r) {
    freeglut_h.glTexCoord3f(s, t, r);
  }

  public void glTexCoord3fv(MemorySegment v) {
    freeglut_h.glTexCoord3fv(v);
  }

  public void glTexCoord3i(int s, int t, int r) {
    freeglut_h.glTexCoord3i(s, t, r);
  }

  public void glTexCoord3iv(MemorySegment v) {
    freeglut_h.glTexCoord3iv(v);
  }

  public void glTexCoord3s(short s, short t, short r) {
    freeglut_h.glTexCoord3s(s, t, r);
  }

  public void glTexCoord3sv(MemorySegment v) {
    freeglut_h.glTexCoord3sv(v);
  }

  public void glTexCoord4d(double s, double t, double r, double q) {
    freeglut_h.glTexCoord4d(s, t, r, q);
  }

  public void glTexCoord4dv(MemorySegment v) {
    freeglut_h.glTexCoord4dv(v);
  }

  public void glTexCoord4f(float s, float t, float r, float q) {
    freeglut_h.glTexCoord4f(s, t, r, q);
  }

  public void glTexCoord4fv(MemorySegment v) {
    freeglut_h.glTexCoord4fv(v);
  }

  public void glTexCoord4i(int s, int t, int r, int q) {
    freeglut_h.glTexCoord4i(s, t, r, q);
  }

  public void glTexCoord4iv(MemorySegment v) {
    freeglut_h.glTexCoord4iv(v);
  }

  public void glTexCoord4s(short s, short t, short r, short q) {
    freeglut_h.glTexCoord4s(s, t, r, q);
  }

  public void glTexCoord4sv(MemorySegment v) {
    freeglut_h.glTexCoord4sv(v);
  }

  public void glTexCoordPointer(int size, int type, int stride, MemorySegment pointer) {
    freeglut_h.glTexCoordPointer(size, type, stride, pointer);
  }

  public void glTexEnvf(int target, int pname, float param) {
    freeglut_h.glTexEnvf(target, pname, param);
  }

  public void glTexEnvfv(int target, int pname, MemorySegment params) {
    freeglut_h.glTexEnvfv(target, pname, params);
  }

  public void glTexEnvi(int target, int pname, int param) {
    freeglut_h.glTexEnvi(target, pname, param);
  }

  public void glTexEnviv(int target, int pname, MemorySegment params) {
    freeglut_h.glTexEnviv(target, pname, params);
  }

  public void glTexGend(int coord, int pname, double param) {
    freeglut_h.glTexGend(coord, pname, param);
  }

  public void glTexGendv(int coord, int pname, MemorySegment params) {
    freeglut_h.glTexGendv(coord, pname, params);
  }

  public void glTexGenf(int coord, int pname, float param) {
    freeglut_h.glTexGenf(coord, pname, param);
  }

  public void glTexGenfv(int coord, int pname, MemorySegment params) {
    freeglut_h.glTexGenfv(coord, pname, params);
  }

  public void glTexGeni(int coord, int pname, int param) {
    freeglut_h.glTexGeni(coord, pname, param);
  }

  public void glTexGeniv(int coord, int pname, MemorySegment params) {
    freeglut_h.glTexGeniv(coord, pname, params);
  }

  public void glTexImage1D(int target, int level, int internalformat, int width, int border, int format, int type, MemorySegment pixels) {
    freeglut_h.glTexImage1D(target, level, internalformat, width, border, format, type, pixels);
  }

  public void glTexImage2D(int target, int level, int internalformat, int width, int height, int border, int format, int type, MemorySegment pixels) {
    freeglut_h.glTexImage2D(target, level, internalformat, width, height, border, format, type, pixels);
  }

  public void glTexParameterf(int target, int pname, float param) {
    freeglut_h.glTexParameterf(target, pname, param);
  }

  public void glTexParameterfv(int target, int pname, MemorySegment params) {
    freeglut_h.glTexParameterfv(target, pname, params);
  }

  public void glTexParameteri(int target, int pname, int param) {
    freeglut_h.glTexParameteri(target, pname, param);
  }

  public void glTexParameteriv(int target, int pname, MemorySegment params) {
    freeglut_h.glTexParameteriv(target, pname, params);
  }

  public void glTexSubImage1D(int target, int level, int xoffset, int width, int format, int type, MemorySegment pixels) {
    freeglut_h.glTexSubImage1D(target, level, xoffset, width, format, type, pixels);
  }

  public void glTexSubImage2D(int target, int level, int xoffset, int yoffset, int width, int height, int format, int type, MemorySegment pixels) {
    freeglut_h.glTexSubImage2D(target, level, xoffset, yoffset, width, height, format, type, pixels);
  }

  public void glTranslated(double x, double y, double z) {
    freeglut_h.glTranslated(x, y, z);
  }

  public void glTranslatef(float x, float y, float z) {
    freeglut_h.glTranslatef(x, y, z);
  }

  public void glVertex2d(double x, double y) {
    freeglut_h.glVertex2d(x, y);
  }

  public void glVertex2dv(MemorySegment v) {
    freeglut_h.glVertex2dv(v);
  }

  public void glVertex2f(float x, float y) {
    freeglut_h.glVertex2f(x, y);
  }

  public void glVertex2fv(MemorySegment v) {
    freeglut_h.glVertex2fv(v);
  }

  public void glVertex2i(int x, int y) {
    freeglut_h.glVertex2i(x, y);
  }

  public void glVertex2iv(MemorySegment v) {
    freeglut_h.glVertex2iv(v);
  }

  public void glVertex2s(short x, short y) {
    freeglut_h.glVertex2s(x, y);
  }

  public void glVertex2sv(MemorySegment v) {
    freeglut_h.glVertex2sv(v);
  }

  public void glVertex3d(double x, double y, double z) {
    freeglut_h.glVertex3d(x, y, z);
  }

  public void glVertex3dv(MemorySegment v) {
    freeglut_h.glVertex3dv(v);
  }

  public void glVertex3f(float x, float y, float z) {
    freeglut_h.glVertex3f(x, y, z);
  }

  public void glVertex3fv(MemorySegment v) {
    freeglut_h.glVertex3fv(v);
  }

  public void glVertex3i(int x, int y, int z) {
    freeglut_h.glVertex3i(x, y, z);
  }

  public void glVertex3iv(MemorySegment v) {
    freeglut_h.glVertex3iv(v);
  }

  public void glVertex3s(short x, short y, short z) {
    freeglut_h.glVertex3s(x, y, z);
  }

  public void glVertex3sv(MemorySegment v) {
    freeglut_h.glVertex3sv(v);
  }

  public void glVertex4d(double x, double y, double z, double w) {
    freeglut_h.glVertex4d(x, y, z, w);
  }

  public void glVertex4dv(MemorySegment v) {
    freeglut_h.glVertex4dv(v);
  }

  public void glVertex4f(float x, float y, float z, float w) {
    freeglut_h.glVertex4f(x, y, z, w);
  }

  public void glVertex4fv(MemorySegment v) {
    freeglut_h.glVertex4fv(v);
  }

  public void glVertex4i(int x, int y, int z, int w) {
    freeglut_h.glVertex4i(x, y, z, w);
  }

  public void glVertex4iv(MemorySegment v) {
    freeglut_h.glVertex4iv(v);
  }

  public void glVertex4s(short x, short y, short z, short w) {
    freeglut_h.glVertex4s(x, y, z, w);
  }

  public void glVertex4sv(MemorySegment v) {
    freeglut_h.glVertex4sv(v);
  }

  public void glVertexPointer(int size, int type, int stride, MemorySegment pointer) {
    freeglut_h.glVertexPointer(size, type, stride, pointer);
  }

  public void glViewport(int x, int y, int width, int height) {
    freeglut_h.glViewport(x, y, width, height);
  }

  public void gluBeginCurve(MemorySegment arg0) {
    freeglut_h.gluBeginCurve(arg0);
  }

  public void gluBeginPolygon(MemorySegment arg0) {
    freeglut_h.gluBeginPolygon(arg0);
  }

  public void gluBeginSurface(MemorySegment arg0) {
    freeglut_h.gluBeginSurface(arg0);
  }

  public void gluBeginTrim(MemorySegment arg0) {
    freeglut_h.gluBeginTrim(arg0);
  }

  public int gluBuild1DMipmaps(int arg0, int arg1, int arg2, int arg3, int arg4, MemorySegment arg5) {
    return freeglut_h.gluBuild1DMipmaps(arg0, arg1, arg2, arg3, arg4, arg5);
  }

  public int gluBuild2DMipmaps(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, MemorySegment arg6) {
    return freeglut_h.gluBuild2DMipmaps(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
  }

  public void gluCylinder(MemorySegment arg0, double arg1, double arg2, double arg3, int arg4, int arg5) {
    freeglut_h.gluCylinder(arg0, arg1, arg2, arg3, arg4, arg5);
  }

  public void gluDeleteNurbsRenderer(MemorySegment arg0) {
    freeglut_h.gluDeleteNurbsRenderer(arg0);
  }

  public void gluDeleteQuadric(MemorySegment arg0) {
    freeglut_h.gluDeleteQuadric(arg0);
  }

  public void gluDeleteTess(MemorySegment arg0) {
    freeglut_h.gluDeleteTess(arg0);
  }

  public void gluDisk(MemorySegment arg0, double arg1, double arg2, int arg3, int arg4) {
    freeglut_h.gluDisk(arg0, arg1, arg2, arg3, arg4);
  }

  public void gluEndCurve(MemorySegment arg0) {
    freeglut_h.gluEndCurve(arg0);
  }

  public void gluEndPolygon(MemorySegment arg0) {
    freeglut_h.gluEndPolygon(arg0);
  }

  public void gluEndSurface(MemorySegment arg0) {
    freeglut_h.gluEndSurface(arg0);
  }

  public void gluEndTrim(MemorySegment arg0) {
    freeglut_h.gluEndTrim(arg0);
  }

  public MemorySegment gluErrorString(int arg0) {
    return freeglut_h.gluErrorString(arg0);
  }

  public MemorySegment gluErrorUnicodeStringEXT(int arg0) {
    return freeglut_h.gluErrorUnicodeStringEXT(arg0);
  }

  public void gluGetNurbsProperty(MemorySegment arg0, int arg1, MemorySegment arg2) {
    freeglut_h.gluGetNurbsProperty(arg0, arg1, arg2);
  }

  public MemorySegment gluGetString(int arg0) {
    return freeglut_h.gluGetString(arg0);
  }

  public void gluGetTessProperty(MemorySegment arg0, int arg1, MemorySegment arg2) {
    freeglut_h.gluGetTessProperty(arg0, arg1, arg2);
  }

  public void gluLoadSamplingMatrices(MemorySegment arg0, MemorySegment arg1, MemorySegment arg2, MemorySegment arg3) {
    freeglut_h.gluLoadSamplingMatrices(arg0, arg1, arg2, arg3);
  }

  public void gluLookAt(double arg0, double arg1, double arg2, double arg3, double arg4, double arg5, double arg6, double arg7, double arg8) {
    freeglut_h.gluLookAt(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
  }

  public MemorySegment gluNewNurbsRenderer() {
    return freeglut_h.gluNewNurbsRenderer();
  }

  public MemorySegment gluNewQuadric() {
    return freeglut_h.gluNewQuadric();
  }

  public MemorySegment gluNewTess() {
    return freeglut_h.gluNewTess();
  }

  public void gluNextContour(MemorySegment arg0, int arg1) {
    freeglut_h.gluNextContour(arg0, arg1);
  }

  public void gluNurbsCallback(MemorySegment arg0, int arg1, MemorySegment arg2) {
    freeglut_h.gluNurbsCallback(arg0, arg1, arg2);
  }

  public void gluNurbsCurve(MemorySegment arg0, int arg1, MemorySegment arg2, int arg3, MemorySegment arg4, int arg5, int arg6) {
    freeglut_h.gluNurbsCurve(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
  }

  public void gluNurbsProperty(MemorySegment arg0, int arg1, float arg2) {
    freeglut_h.gluNurbsProperty(arg0, arg1, arg2);
  }

  public void gluNurbsSurface(MemorySegment arg0, int arg1, MemorySegment arg2, int arg3, MemorySegment arg4, int arg5, int arg6, MemorySegment arg7, int arg8, int arg9, int arg10) {
    freeglut_h.gluNurbsSurface(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10);
  }

  public void gluOrtho2D(double arg0, double arg1, double arg2, double arg3) {
    freeglut_h.gluOrtho2D(arg0, arg1, arg2, arg3);
  }

  public void gluPartialDisk(MemorySegment arg0, double arg1, double arg2, int arg3, int arg4, double arg5, double arg6) {
    freeglut_h.gluPartialDisk(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
  }

  public void gluPerspective(double arg0, double arg1, double arg2, double arg3) {
    freeglut_h.gluPerspective(arg0, arg1, arg2, arg3);
  }

  public void gluPickMatrix(double arg0, double arg1, double arg2, double arg3, MemorySegment arg4) {
    freeglut_h.gluPickMatrix(arg0, arg1, arg2, arg3, arg4);
  }

  public int gluProject(double arg0, double arg1, double arg2, MemorySegment arg3, MemorySegment arg4, MemorySegment arg5, MemorySegment arg6, MemorySegment arg7, MemorySegment arg8) {
    return freeglut_h.gluProject(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
  }

  public void gluPwlCurve(MemorySegment arg0, int arg1, MemorySegment arg2, int arg3, int arg4) {
    freeglut_h.gluPwlCurve(arg0, arg1, arg2, arg3, arg4);
  }

  public void gluQuadricCallback(MemorySegment arg0, int arg1, MemorySegment arg2) {
    freeglut_h.gluQuadricCallback(arg0, arg1, arg2);
  }

  public void gluQuadricDrawStyle(MemorySegment arg0, int arg1) {
    freeglut_h.gluQuadricDrawStyle(arg0, arg1);
  }

  public void gluQuadricNormals(MemorySegment arg0, int arg1) {
    freeglut_h.gluQuadricNormals(arg0, arg1);
  }

  public void gluQuadricOrientation(MemorySegment arg0, int arg1) {
    freeglut_h.gluQuadricOrientation(arg0, arg1);
  }

  public void gluQuadricTexture(MemorySegment arg0, byte arg1) {
    freeglut_h.gluQuadricTexture(arg0, arg1);
  }

  public int gluScaleImage(int arg0, int arg1, int arg2, int arg3, MemorySegment arg4, int arg5, int arg6, int arg7, MemorySegment arg8) {
    return freeglut_h.gluScaleImage(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
  }

  public void gluSphere(MemorySegment arg0, double arg1, int arg2, int arg3) {
    freeglut_h.gluSphere(arg0, arg1, arg2, arg3);
  }

  public void gluTessBeginContour(MemorySegment arg0) {
    freeglut_h.gluTessBeginContour(arg0);
  }

  public void gluTessBeginPolygon(MemorySegment arg0, MemorySegment arg1) {
    freeglut_h.gluTessBeginPolygon(arg0, arg1);
  }

  public void gluTessCallback(MemorySegment arg0, int arg1, MemorySegment arg2) {
    freeglut_h.gluTessCallback(arg0, arg1, arg2);
  }

  public void gluTessEndContour(MemorySegment arg0) {
    freeglut_h.gluTessEndContour(arg0);
  }

  public void gluTessEndPolygon(MemorySegment arg0) {
    freeglut_h.gluTessEndPolygon(arg0);
  }

  public void gluTessNormal(MemorySegment arg0, double arg1, double arg2, double arg3) {
    freeglut_h.gluTessNormal(arg0, arg1, arg2, arg3);
  }

  public void gluTessProperty(MemorySegment arg0, int arg1, double arg2) {
    freeglut_h.gluTessProperty(arg0, arg1, arg2);
  }

  public void gluTessVertex(MemorySegment arg0, MemorySegment arg1, MemorySegment arg2) {
    freeglut_h.gluTessVertex(arg0, arg1, arg2);
  }

  public int gluUnProject(double arg0, double arg1, double arg2, MemorySegment arg3, MemorySegment arg4, MemorySegment arg5, MemorySegment arg6, MemorySegment arg7, MemorySegment arg8) {
    return freeglut_h.gluUnProject(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
  }

  public void glutAddMenuEntry(MemorySegment arg0, int arg1) {
    freeglut_h.glutAddMenuEntry(arg0, arg1);
  }

  public void glutAddSubMenu(MemorySegment arg0, int arg1) {
    freeglut_h.glutAddSubMenu(arg0, arg1);
  }

  public void glutAppStatusFunc(MemorySegment arg0) {
    freeglut_h.glutAppStatusFunc(arg0);
  }

  public void glutAppStatusFuncUcall(MemorySegment arg0, MemorySegment arg1) {
    freeglut_h.glutAppStatusFuncUcall(arg0, arg1);
  }

  public void glutAttachMenu(int arg0) {
    freeglut_h.glutAttachMenu(arg0);
  }

  public void glutBitmapCharacter(MemorySegment arg0, int arg1) {
    freeglut_h.glutBitmapCharacter(arg0, arg1);
  }

  public int glutBitmapHeight(MemorySegment arg0) {
    return freeglut_h.glutBitmapHeight(arg0);
  }

  public int glutBitmapLength(MemorySegment arg0, MemorySegment arg1) {
    return freeglut_h.glutBitmapLength(arg0, arg1);
  }

  public void glutBitmapString(MemorySegment arg0, MemorySegment arg1) {
    freeglut_h.glutBitmapString(arg0, arg1);
  }

  public int glutBitmapWidth(MemorySegment arg0, int arg1) {
    return freeglut_h.glutBitmapWidth(arg0, arg1);
  }

  public void glutButtonBoxFunc(MemorySegment arg0) {
    freeglut_h.glutButtonBoxFunc(arg0);
  }

  public void glutButtonBoxFuncUcall(MemorySegment arg0, MemorySegment arg1) {
    freeglut_h.glutButtonBoxFuncUcall(arg0, arg1);
  }

  public void glutChangeToMenuEntry(int arg0, MemorySegment arg1, int arg2) {
    freeglut_h.glutChangeToMenuEntry(arg0, arg1, arg2);
  }

  public void glutChangeToSubMenu(int arg0, MemorySegment arg1, int arg2) {
    freeglut_h.glutChangeToSubMenu(arg0, arg1, arg2);
  }

  public void glutCloseFunc(MemorySegment arg0) {
    freeglut_h.glutCloseFunc(arg0);
  }

  public void glutCloseFuncUcall(MemorySegment arg0, MemorySegment arg1) {
    freeglut_h.glutCloseFuncUcall(arg0, arg1);
  }

  public void glutCopyColormap(int arg0) {
    freeglut_h.glutCopyColormap(arg0);
  }

  public int glutCreateMenu(MemorySegment arg0) {
    return freeglut_h.glutCreateMenu(arg0);
  }

  public int glutCreateMenuUcall(MemorySegment arg0, MemorySegment arg1) {
    return freeglut_h.glutCreateMenuUcall(arg0, arg1);
  }

  /*public int glutCreateMenuUcall_ATEXIT_HACK(MemorySegment arg0, MemorySegment arg1) {
    return freeglut_h.glutCreateMenuUcall_ATEXIT_HACK(arg0, arg1);
  }

  public int glutCreateMenu_ATEXIT_HACK(MemorySegment arg0) {
    return freeglut_h.glutCreateMenu_ATEXIT_HACK(arg0);
  }*/

  public int glutCreateSubWindow(int arg0, int arg1, int arg2, int arg3, int arg4) {
    return freeglut_h.glutCreateSubWindow(arg0, arg1, arg2, arg3, arg4);
  }

  public int glutCreateWindow(MemorySegment arg0) {
    return freeglut_h.glutCreateWindow(arg0);
  }

  public int glutCreateWindow_ATEXIT_HACK(MemorySegment arg0) {
    return -1;//freeglut_h.glutCreateWindow_ATEXIT_HACK(arg0);
  }

  public void glutDestroyMenu(int arg0) {
    freeglut_h.glutDestroyMenu(arg0);
  }

  public void glutDestroyWindow(int arg0) {
    freeglut_h.glutDestroyWindow(arg0);
  }

  public void glutDetachMenu(int arg0) {
    freeglut_h.glutDetachMenu(arg0);
  }

  public int glutDeviceGet(int arg0) {
    return freeglut_h.glutDeviceGet(arg0);
  }

  public void glutDialsFunc(MemorySegment arg0) {
    freeglut_h.glutDialsFunc(arg0);
  }

  public void glutDialsFuncUcall(MemorySegment arg0, MemorySegment arg1) {
    freeglut_h.glutDialsFuncUcall(arg0, arg1);
  }

  public void glutDisplayFunc(MemorySegment arg0) {
    freeglut_h.glutDisplayFunc(arg0);
  }

  public void glutDisplayFuncUcall(MemorySegment arg0, MemorySegment arg1) {
    freeglut_h.glutDisplayFuncUcall(arg0, arg1);
  }

  public int glutEnterGameMode() {
    return freeglut_h.glutEnterGameMode();
  }

  public void glutEntryFunc(MemorySegment arg0) {
    freeglut_h.glutEntryFunc(arg0);
  }

  public void glutEntryFuncUcall(MemorySegment arg0, MemorySegment arg1) {
    freeglut_h.glutEntryFuncUcall(arg0, arg1);
  }

  public void glutEstablishOverlay() {
    freeglut_h.glutEstablishOverlay();
  }

  public void glutExit() {
    freeglut_h.glutExit();
  }

  public int glutExtensionSupported(MemorySegment arg0) {
    return freeglut_h.glutExtensionSupported(arg0);
  }

  public void glutForceJoystickFunc() {
    freeglut_h.glutForceJoystickFunc();
  }

  public void glutFullScreen() {
    freeglut_h.glutFullScreen();
  }

  public void glutFullScreenToggle() {
    freeglut_h.glutFullScreenToggle();
  }

  public int glutGameModeGet(int arg0) {
    return freeglut_h.glutGameModeGet(arg0);
  }

  public void glutGameModeString(MemorySegment arg0) {
    freeglut_h.glutGameModeString(arg0);
  }

  public int glutGet(int arg0) {
    return freeglut_h.glutGet(arg0);
  }

  public float glutGetColor(int arg0, int arg1) {
    return freeglut_h.glutGetColor(arg0, arg1);
  }

  public int glutGetMenu() {
    return freeglut_h.glutGetMenu();
  }

  public MemorySegment glutGetMenuData() {
    return freeglut_h.glutGetMenuData();
  }

  public MemorySegment glutGetModeValues(int arg0, MemorySegment arg1) {
    return freeglut_h.glutGetModeValues(arg0, arg1);
  }

  public int glutGetModifiers() {
    return freeglut_h.glutGetModifiers();
  }

  public MemorySegment glutGetProcAddress(MemorySegment arg0) {
    return freeglut_h.glutGetProcAddress(arg0);
  }

  public int glutGetWindow() {
    return freeglut_h.glutGetWindow();
  }

  public MemorySegment glutGetWindowData() {
    return freeglut_h.glutGetWindowData();
  }

  public void glutHideOverlay() {
    freeglut_h.glutHideOverlay();
  }

  public void glutHideWindow() {
    freeglut_h.glutHideWindow();
  }

  public void glutIconifyWindow() {
    freeglut_h.glutIconifyWindow();
  }

  public void glutIdleFunc(MemorySegment arg0) {
    freeglut_h.glutIdleFunc(arg0);
  }

  public void glutIdleFuncUcall(MemorySegment arg0, MemorySegment arg1) {
    freeglut_h.glutIdleFuncUcall(arg0, arg1);
  }

  public void glutIgnoreKeyRepeat(int arg0) {
    freeglut_h.glutIgnoreKeyRepeat(arg0);
  }

  public void glutInit(MemorySegment arg0, MemorySegment arg1) {
    freeglut_h.glutInit(arg0, arg1);
  }

  public void glutInitContextFlags(int arg0) {
    freeglut_h.glutInitContextFlags(arg0);
  }

  public void glutInitContextFunc(MemorySegment arg0) {
    freeglut_h.glutInitContextFunc(arg0);
  }

  public void glutInitContextFuncUcall(MemorySegment arg0, MemorySegment arg1) {
    freeglut_h.glutInitContextFuncUcall(arg0, arg1);
  }

  public void glutInitContextProfile(int arg0) {
    freeglut_h.glutInitContextProfile(arg0);
  }

  public void glutInitContextVersion(int arg0, int arg1) {
    freeglut_h.glutInitContextVersion(arg0, arg1);
  }

  public void glutInitDisplayMode(int arg0) {
    freeglut_h.glutInitDisplayMode(arg0);
  }

  public void glutInitDisplayString(MemorySegment arg0) {
    freeglut_h.glutInitDisplayString(arg0);
  }

  public void glutInitErrorFunc(MemorySegment arg0) {
    freeglut_h.glutInitErrorFunc(arg0);
  }

  public void glutInitErrorFuncUcall(MemorySegment arg0, MemorySegment arg1) {
    freeglut_h.glutInitErrorFuncUcall(arg0, arg1);
  }

  public void glutInitWarningFunc(MemorySegment arg0) {
    freeglut_h.glutInitWarningFunc(arg0);
  }

  public void glutInitWarningFuncUcall(MemorySegment arg0, MemorySegment arg1) {
    freeglut_h.glutInitWarningFuncUcall(arg0, arg1);
  }

  public void glutInitWindowPosition(int arg0, int arg1) {
    freeglut_h.glutInitWindowPosition(arg0, arg1);
  }

  public void glutInitWindowSize(int arg0, int arg1) {
    freeglut_h.glutInitWindowSize(arg0, arg1);
  }

  public void glutInit_ATEXIT_HACK(MemorySegment arg0, MemorySegment arg1) {
    //freeglut_h.glutInit_ATEXIT_HACK(arg0, arg1);
  }

  public void glutJoystickFunc(MemorySegment arg0, int arg1) {
    freeglut_h.glutJoystickFunc(arg0, arg1);
  }

  public void glutJoystickFuncUcall(MemorySegment arg0, int arg1, MemorySegment arg2) {
    freeglut_h.glutJoystickFuncUcall(arg0, arg1, arg2);
  }

  public void glutJoystickGetCenter(int arg0, MemorySegment arg1) {
    freeglut_h.glutJoystickGetCenter(arg0, arg1);
  }

  public float glutJoystickGetDeadBand(int arg0, int arg1) {
    return freeglut_h.glutJoystickGetDeadBand(arg0, arg1);
  }

  public void glutJoystickGetMaxRange(int arg0, MemorySegment arg1) {
    freeglut_h.glutJoystickGetMaxRange(arg0, arg1);
  }

  public void glutJoystickGetMinRange(int arg0, MemorySegment arg1) {
    freeglut_h.glutJoystickGetMinRange(arg0, arg1);
  }

  public int glutJoystickGetNumAxes(int arg0) {
    return freeglut_h.glutJoystickGetNumAxes(arg0);
  }

  public int glutJoystickGetNumButtons(int arg0) {
    return freeglut_h.glutJoystickGetNumButtons(arg0);
  }

  public float glutJoystickGetSaturation(int arg0, int arg1) {
    return freeglut_h.glutJoystickGetSaturation(arg0, arg1);
  }

  public int glutJoystickNotWorking(int arg0) {
    return freeglut_h.glutJoystickNotWorking(arg0);
  }

  public void glutJoystickSetCenter(int arg0, MemorySegment arg1) {
    freeglut_h.glutJoystickSetCenter(arg0, arg1);
  }

  public void glutJoystickSetDeadBand(int arg0, int arg1, float arg2) {
    freeglut_h.glutJoystickSetDeadBand(arg0, arg1, arg2);
  }

  public void glutJoystickSetMaxRange(int arg0, MemorySegment arg1) {
    freeglut_h.glutJoystickSetMaxRange(arg0, arg1);
  }

  public void glutJoystickSetMinRange(int arg0, MemorySegment arg1) {
    freeglut_h.glutJoystickSetMinRange(arg0, arg1);
  }

  public void glutJoystickSetSaturation(int arg0, int arg1, float arg2) {
    freeglut_h.glutJoystickSetSaturation(arg0, arg1, arg2);
  }

  public void glutKeyboardFunc(MemorySegment arg0) {
    freeglut_h.glutKeyboardFunc(arg0);
  }

  public void glutKeyboardFuncUcall(MemorySegment arg0, MemorySegment arg1) {
    freeglut_h.glutKeyboardFuncUcall(arg0, arg1);
  }

  public void glutKeyboardUpFunc(MemorySegment arg0) {
    freeglut_h.glutKeyboardUpFunc(arg0);
  }

  public void glutKeyboardUpFuncUcall(MemorySegment arg0, MemorySegment arg1) {
    freeglut_h.glutKeyboardUpFuncUcall(arg0, arg1);
  }

  public int glutLayerGet(int arg0) {
    return freeglut_h.glutLayerGet(arg0);
  }

  public void glutLeaveFullScreen() {
    freeglut_h.glutLeaveFullScreen();
  }

  public void glutLeaveGameMode() {
    freeglut_h.glutLeaveGameMode();
  }

  public void glutLeaveMainLoop() {
    freeglut_h.glutLeaveMainLoop();
  }

  public void glutMainLoop() {
    freeglut_h.glutMainLoop();
  }

  public void glutMainLoopEvent() {
    freeglut_h.glutMainLoopEvent();
  }

  public void glutMenuDestroyFunc(MemorySegment arg0) {
    freeglut_h.glutMenuDestroyFunc(arg0);
  }

  public void glutMenuDestroyFuncUcall(MemorySegment arg0, MemorySegment arg1) {
    freeglut_h.glutMenuDestroyFuncUcall(arg0, arg1);
  }

  public void glutMenuStateFunc(MemorySegment arg0) {
    freeglut_h.glutMenuStateFunc(arg0);
  }

  public void glutMenuStatusFunc(MemorySegment arg0) {
    freeglut_h.glutMenuStatusFunc(arg0);
  }

  public void glutMenuStatusFuncUcall(MemorySegment arg0, MemorySegment arg1) {
    freeglut_h.glutMenuStatusFuncUcall(arg0, arg1);
  }

  public void glutMotionFunc(MemorySegment arg0) {
    freeglut_h.glutMotionFunc(arg0);
  }

  public void glutMotionFuncUcall(MemorySegment arg0, MemorySegment arg1) {
    freeglut_h.glutMotionFuncUcall(arg0, arg1);
  }

  public void glutMouseFunc(MemorySegment arg0) {
    freeglut_h.glutMouseFunc(arg0);
  }

  public void glutMouseFuncUcall(MemorySegment arg0, MemorySegment arg1) {
    freeglut_h.glutMouseFuncUcall(arg0, arg1);
  }

  public void glutMouseWheelFunc(MemorySegment arg0) {
    freeglut_h.glutMouseWheelFunc(arg0);
  }

  public void glutMouseWheelFuncUcall(MemorySegment arg0, MemorySegment arg1) {
    freeglut_h.glutMouseWheelFuncUcall(arg0, arg1);
  }

  public void glutMultiButtonFunc(MemorySegment arg0) {
    freeglut_h.glutMultiButtonFunc(arg0);
  }

  public void glutMultiButtonFuncUcall(MemorySegment arg0, MemorySegment arg1) {
    freeglut_h.glutMultiButtonFuncUcall(arg0, arg1);
  }

  public void glutMultiEntryFunc(MemorySegment arg0) {
    freeglut_h.glutMultiEntryFunc(arg0);
  }

  public void glutMultiEntryFuncUcall(MemorySegment arg0, MemorySegment arg1) {
    freeglut_h.glutMultiEntryFuncUcall(arg0, arg1);
  }

  public void glutMultiMotionFunc(MemorySegment arg0) {
    freeglut_h.glutMultiMotionFunc(arg0);
  }

  public void glutMultiMotionFuncUcall(MemorySegment arg0, MemorySegment arg1) {
    freeglut_h.glutMultiMotionFuncUcall(arg0, arg1);
  }

  public void glutMultiPassiveFunc(MemorySegment arg0) {
    freeglut_h.glutMultiPassiveFunc(arg0);
  }

  public void glutMultiPassiveFuncUcall(MemorySegment arg0, MemorySegment arg1) {
    freeglut_h.glutMultiPassiveFuncUcall(arg0, arg1);
  }

  public void glutOverlayDisplayFunc(MemorySegment arg0) {
    freeglut_h.glutOverlayDisplayFunc(arg0);
  }

  public void glutOverlayDisplayFuncUcall(MemorySegment arg0, MemorySegment arg1) {
    freeglut_h.glutOverlayDisplayFuncUcall(arg0, arg1);
  }

  public void glutPassiveMotionFunc(MemorySegment arg0) {
    freeglut_h.glutPassiveMotionFunc(arg0);
  }

  public void glutPassiveMotionFuncUcall(MemorySegment arg0, MemorySegment arg1) {
    freeglut_h.glutPassiveMotionFuncUcall(arg0, arg1);
  }

  public void glutPopWindow() {
    freeglut_h.glutPopWindow();
  }

  public void glutPositionFunc(MemorySegment arg0) {
    freeglut_h.glutPositionFunc(arg0);
  }

  public void glutPositionFuncUcall(MemorySegment arg0, MemorySegment arg1) {
    freeglut_h.glutPositionFuncUcall(arg0, arg1);
  }

  public void glutPositionWindow(int arg0, int arg1) {
    freeglut_h.glutPositionWindow(arg0, arg1);
  }

  public void glutPostOverlayRedisplay() {
    freeglut_h.glutPostOverlayRedisplay();
  }

  public void glutPostRedisplay() {
    freeglut_h.glutPostRedisplay();
  }

  public void glutPostWindowOverlayRedisplay(int arg0) {
    freeglut_h.glutPostWindowOverlayRedisplay(arg0);
  }

  public void glutPostWindowRedisplay(int arg0) {
    freeglut_h.glutPostWindowRedisplay(arg0);
  }

  public void glutPushWindow() {
    freeglut_h.glutPushWindow();
  }

  public void glutRemoveMenuItem(int arg0) {
    freeglut_h.glutRemoveMenuItem(arg0);
  }

  public void glutRemoveOverlay() {
    freeglut_h.glutRemoveOverlay();
  }

  public void glutReportErrors() {
    freeglut_h.glutReportErrors();
  }

  public void glutReshapeFunc(MemorySegment arg0) {
    freeglut_h.glutReshapeFunc(arg0);
  }

  public void glutReshapeFuncUcall(MemorySegment arg0, MemorySegment arg1) {
    freeglut_h.glutReshapeFuncUcall(arg0, arg1);
  }

  public void glutReshapeWindow(int arg0, int arg1) {
    freeglut_h.glutReshapeWindow(arg0, arg1);
  }

  public void glutSetColor(int arg0, float arg1, float arg2, float arg3) {
    freeglut_h.glutSetColor(arg0, arg1, arg2, arg3);
  }

  public void glutSetCursor(int arg0) {
    freeglut_h.glutSetCursor(arg0);
  }

  public void glutSetIconTitle(MemorySegment arg0) {
    freeglut_h.glutSetIconTitle(arg0);
  }

  public void glutSetKeyRepeat(int arg0) {
    freeglut_h.glutSetKeyRepeat(arg0);
  }

  public void glutSetMenu(int arg0) {
    freeglut_h.glutSetMenu(arg0);
  }

  public void glutSetMenuData(MemorySegment arg0) {
    freeglut_h.glutSetMenuData(arg0);
  }

  public void glutSetMenuFont(int arg0, MemorySegment arg1) {
    freeglut_h.glutSetMenuFont(arg0, arg1);
  }

  public void glutSetOption(int arg0, int arg1) {
    freeglut_h.glutSetOption(arg0, arg1);
  }

  public void glutSetVertexAttribCoord3(int arg0) {
    freeglut_h.glutSetVertexAttribCoord3(arg0);
  }

  public void glutSetVertexAttribNormal(int arg0) {
    freeglut_h.glutSetVertexAttribNormal(arg0);
  }

  public void glutSetVertexAttribTexCoord2(int arg0) {
    freeglut_h.glutSetVertexAttribTexCoord2(arg0);
  }

  public void glutSetWindow(int arg0) {
    freeglut_h.glutSetWindow(arg0);
  }

  public void glutSetWindowData(MemorySegment arg0) {
    freeglut_h.glutSetWindowData(arg0);
  }

  public void glutSetWindowTitle(MemorySegment arg0) {
    freeglut_h.glutSetWindowTitle(arg0);
  }

  public void glutSetupVideoResizing() {
    freeglut_h.glutSetupVideoResizing();
  }

  public void glutShowOverlay() {
    freeglut_h.glutShowOverlay();
  }

  public void glutShowWindow() {
    freeglut_h.glutShowWindow();
  }

  public void glutSolidCone(double arg0, double arg1, int arg2, int arg3) {
    freeglut_h.glutSolidCone(arg0, arg1, arg2, arg3);
  }

  public void glutSolidCube(double arg0) {
    freeglut_h.glutSolidCube(arg0);
  }

  public void glutSolidCylinder(double arg0, double arg1, int arg2, int arg3) {
    freeglut_h.glutSolidCylinder(arg0, arg1, arg2, arg3);
  }

  public void glutSolidDodecahedron() {
    freeglut_h.glutSolidDodecahedron();
  }

  public void glutSolidIcosahedron() {
    freeglut_h.glutSolidIcosahedron();
  }

  public void glutSolidOctahedron() {
    freeglut_h.glutSolidOctahedron();
  }

  public void glutSolidRhombicDodecahedron() {
    freeglut_h.glutSolidRhombicDodecahedron();
  }

  public void glutSolidSierpinskiSponge(int arg0, MemorySegment arg1, double arg2) {
    freeglut_h.glutSolidSierpinskiSponge(arg0, arg1, arg2);
  }

  public void glutSolidSphere(double arg0, int arg1, int arg2) {
    freeglut_h.glutSolidSphere(arg0, arg1, arg2);
  }

  public void glutSolidTeacup(double arg0) {
    freeglut_h.glutSolidTeacup(arg0);
  }

  public void glutSolidTeapot(double arg0) {
    freeglut_h.glutSolidTeapot(arg0);
  }

  public void glutSolidTeaspoon(double arg0) {
    freeglut_h.glutSolidTeaspoon(arg0);
  }

  public void glutSolidTetrahedron() {
    freeglut_h.glutSolidTetrahedron();
  }

  public void glutSolidTorus(double arg0, double arg1, int arg2, int arg3) {
    freeglut_h.glutSolidTorus(arg0, arg1, arg2, arg3);
  }

  public void glutSpaceballButtonFunc(MemorySegment arg0) {
    freeglut_h.glutSpaceballButtonFunc(arg0);
  }

  public void glutSpaceballButtonFuncUcall(MemorySegment arg0, MemorySegment arg1) {
    freeglut_h.glutSpaceballButtonFuncUcall(arg0, arg1);
  }

  public void glutSpaceballMotionFunc(MemorySegment arg0) {
    freeglut_h.glutSpaceballMotionFunc(arg0);
  }

  public void glutSpaceballMotionFuncUcall(MemorySegment arg0, MemorySegment arg1) {
    freeglut_h.glutSpaceballMotionFuncUcall(arg0, arg1);
  }

  public void glutSpaceballRotateFunc(MemorySegment arg0) {
    freeglut_h.glutSpaceballRotateFunc(arg0);
  }

  public void glutSpaceballRotateFuncUcall(MemorySegment arg0, MemorySegment arg1) {
    freeglut_h.glutSpaceballRotateFuncUcall(arg0, arg1);
  }

  public void glutSpecialFunc(MemorySegment arg0) {
    freeglut_h.glutSpecialFunc(arg0);
  }

  public void glutSpecialFuncUcall(MemorySegment arg0, MemorySegment arg1) {
    freeglut_h.glutSpecialFuncUcall(arg0, arg1);
  }

  public void glutSpecialUpFunc(MemorySegment arg0) {
    freeglut_h.glutSpecialUpFunc(arg0);
  }

  public void glutSpecialUpFuncUcall(MemorySegment arg0, MemorySegment arg1) {
    freeglut_h.glutSpecialUpFuncUcall(arg0, arg1);
  }

  public void glutStopVideoResizing() {
    freeglut_h.glutStopVideoResizing();
  }

  public void glutStrokeCharacter(MemorySegment arg0, int arg1) {
    freeglut_h.glutStrokeCharacter(arg0, arg1);
  }

  public float glutStrokeHeight(MemorySegment arg0) {
    return freeglut_h.glutStrokeHeight(arg0);
  }

  public int glutStrokeLength(MemorySegment arg0, MemorySegment arg1) {
    return freeglut_h.glutStrokeLength(arg0, arg1);
  }

  public float glutStrokeLengthf(MemorySegment arg0, MemorySegment arg1) {
    return freeglut_h.glutStrokeLengthf(arg0, arg1);
  }

  public void glutStrokeString(MemorySegment arg0, MemorySegment arg1) {
    freeglut_h.glutStrokeString(arg0, arg1);
  }

  public int glutStrokeWidth(MemorySegment arg0, int arg1) {
    return freeglut_h.glutStrokeWidth(arg0, arg1);
  }

  public float glutStrokeWidthf(MemorySegment arg0, int arg1) {
    return freeglut_h.glutStrokeWidthf(arg0, arg1);
  }

  public void glutSwapBuffers() {
    freeglut_h.glutSwapBuffers();
  }

  public void glutTabletButtonFunc(MemorySegment arg0) {
    freeglut_h.glutTabletButtonFunc(arg0);
  }

  public void glutTabletButtonFuncUcall(MemorySegment arg0, MemorySegment arg1) {
    freeglut_h.glutTabletButtonFuncUcall(arg0, arg1);
  }

  public void glutTabletMotionFunc(MemorySegment arg0) {
    freeglut_h.glutTabletMotionFunc(arg0);
  }

  public void glutTabletMotionFuncUcall(MemorySegment arg0, MemorySegment arg1) {
    freeglut_h.glutTabletMotionFuncUcall(arg0, arg1);
  }

  public void glutTimerFunc(int arg0, MemorySegment arg1, int arg2) {
    freeglut_h.glutTimerFunc(arg0, arg1, arg2);
  }

  public void glutTimerFuncUcall(int arg0, MemorySegment arg1, int arg2, MemorySegment arg3) {
    freeglut_h.glutTimerFuncUcall(arg0, arg1, arg2, arg3);
  }

  public void glutUseLayer(int arg0) {
    freeglut_h.glutUseLayer(arg0);
  }

  public void glutVideoPan(int arg0, int arg1, int arg2, int arg3) {
    freeglut_h.glutVideoPan(arg0, arg1, arg2, arg3);
  }

  public void glutVideoResize(int arg0, int arg1, int arg2, int arg3) {
    freeglut_h.glutVideoResize(arg0, arg1, arg2, arg3);
  }

  public int glutVideoResizeGet(int arg0) {
    return freeglut_h.glutVideoResizeGet(arg0);
  }

  public void glutVisibilityFunc(MemorySegment arg0) {
    freeglut_h.glutVisibilityFunc(arg0);
  }

  public void glutVisibilityFuncUcall(MemorySegment arg0, MemorySegment arg1) {
    freeglut_h.glutVisibilityFuncUcall(arg0, arg1);
  }

  public void glutWMCloseFunc(MemorySegment arg0) {
    freeglut_h.glutWMCloseFunc(arg0);
  }

  public void glutWMCloseFuncUcall(MemorySegment arg0, MemorySegment arg1) {
    freeglut_h.glutWMCloseFuncUcall(arg0, arg1);
  }

  public void glutWarpPointer(int arg0, int arg1) {
    freeglut_h.glutWarpPointer(arg0, arg1);
  }

  public void glutWindowStatusFunc(MemorySegment arg0) {
    freeglut_h.glutWindowStatusFunc(arg0);
  }

  public void glutWindowStatusFuncUcall(MemorySegment arg0, MemorySegment arg1) {
    freeglut_h.glutWindowStatusFuncUcall(arg0, arg1);
  }

  public void glutWireCone(double arg0, double arg1, int arg2, int arg3) {
    freeglut_h.glutWireCone(arg0, arg1, arg2, arg3);
  }

  public void glutWireCube(double arg0) {
    freeglut_h.glutWireCube(arg0);
  }

  public void glutWireCylinder(double arg0, double arg1, int arg2, int arg3) {
    freeglut_h.glutWireCylinder(arg0, arg1, arg2, arg3);
  }

  public void glutWireDodecahedron() {
    freeglut_h.glutWireDodecahedron();
  }

  public void glutWireIcosahedron() {
    freeglut_h.glutWireIcosahedron();
  }

  public void glutWireOctahedron() {
    freeglut_h.glutWireOctahedron();
  }

  public void glutWireRhombicDodecahedron() {
    freeglut_h.glutWireRhombicDodecahedron();
  }

  public void glutWireSierpinskiSponge(int arg0, MemorySegment arg1, double arg2) {
    freeglut_h.glutWireSierpinskiSponge(arg0, arg1, arg2);
  }

  public void glutWireSphere(double arg0, int arg1, int arg2) {
    freeglut_h.glutWireSphere(arg0, arg1, arg2);
  }

  public void glutWireTeacup(double arg0) {
    freeglut_h.glutWireTeacup(arg0);
  }

  public void glutWireTeapot(double arg0) {
    freeglut_h.glutWireTeapot(arg0);
  }

  public void glutWireTeaspoon(double arg0) {
    freeglut_h.glutWireTeaspoon(arg0);
  }

  public void glutWireTetrahedron() {
    freeglut_h.glutWireTetrahedron();
  }

  public void glutWireTorus(double arg0, double arg1, int arg2, int arg3) {
    freeglut_h.glutWireTorus(arg0, arg1, arg2, arg3);
  }

  public void glMultiTexImage3DEXT(int texunit, int target, int level, int internalformat, int width, int height, int depth, int border, int format, int type, MemorySegment pixels) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public int glCheckFramebufferStatusOES(int target) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMulticastBarrierNV() {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTextureMaterialEXT(int face, int mode) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glInstrumentsBufferSGIX(int size, MemorySegment buffer) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glPrimitiveRestartNV() {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetInfoLogARB(MemorySegment obj, int maxLength, MemorySegment length, MemorySegment infoLog) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBufferAddressRangeNV(int pname, int index, long address, long length) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glNamedFramebufferParameteri(int framebuffer, int pname, int param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glClipPlanex(int plane, MemorySegment equation) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBinormal3bvEXT(MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glCopyColorSubTable(int target, int start, int x, int y, int width) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniform1iv(int location, int count, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertex4bOES(byte x, byte y, byte z, byte w) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertex4xOES(int x, int y, int z) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttrib1fvNV(int index, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetnUniformuivARB(int program, int location, int bufSize, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glNamedBufferData(int buffer, long size, MemorySegment data, int usage) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniform4uiEXT(int location, int v0, int v1, int v2, int v3) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFogCoorddv(MemorySegment coord) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glWindowPos2sMESA(short x, short y) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glWindowPos2dMESA(double x, double y) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glPixelTransformParameteriEXT(int target, int pname, int param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramEnvParameterI4ivNV(int target, int index, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexBufferRangeEXT(int target, int internalformat, int buffer, long offset, long size) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetTextureLevelParameterivEXT(int texture, int target, int level, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glRectxvOES(MemorySegment v1, MemorySegment v2) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttrib4fARB(int index, float x, float y, float z, float w) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetQueryBufferObjectiv(int id, int buffer, int pname, long offset) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniform1ui64vARB(int location, int count, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttrib2hvNV(int index, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttrib2svNV(int index, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetImageTransformParameterivHP(int target, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glReplacementCodeuiColor3fVertex3fvSUN(MemorySegment rc, MemorySegment c, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFragmentLightModeliSGIX(int pname, int param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexCoord2hNV(int target, short s, short t) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMakeImageHandleNonResidentARB(long handle) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexStream1svATI(int stream, MemorySegment coords) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glImportSemaphoreWin32NameEXT(int semaphore, int handleType, MemorySegment name) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public String glGetStringi(int name, int index) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribL1ui64vARB(int index, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glSecondaryColor3bEXT(byte red, byte green, byte blue) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetPixelTexGenParameterfvSGIS(int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glClipControlEXT(int origin, int depth) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glClipPlanef(int p, MemorySegment eqn) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniform2dvEXT(int program, int location, int count, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetPathSpacingNV(int pathListMode, int numPaths, int pathNameType, MemorySegment paths, int pathBase, float advanceScale, float kerningScale, int transformType, MemorySegment returnedSpacing) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glClearNamedBufferDataEXT(int buffer, int internalformat, int format, int type, MemorySegment data) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glColor4ubVertex2fSUN(byte r, byte g, byte b, byte a, float x, float y) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glPointSizexOES(int size) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glRequestResidentProgramsNV(int n, MemorySegment programs) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetnMapfv(int target, int query, int bufSize, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexGenfEXT(int texunit, int coord, int pname, float param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glClearPixelLocalStorageuiEXT(int offset, int n, MemorySegment values) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glClearTexImageEXT(int texture, int level, int format, int type, MemorySegment data) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetTextureParameterIivEXT(int texture, int target, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glOrthoxOES(int l, int r, int b, int t, int n, int f) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetMapParameterivNV(int target, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glImportMemoryWin32HandleEXT(int memory, long size, int handleType, MemorySegment handle) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetShaderSourceARB(MemorySegment obj, int maxLength, MemorySegment length, MemorySegment source) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glCoverFillPathNV(int path, int coverMode) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public int glGetVaryingLocationNV(int program, MemorySegment name) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDrawCommandsAddressNV(int primitiveMode, MemorySegment indirects, MemorySegment sizes, int count) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBindTextureUnit(int unit, int texture) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMapBufferARB(int target, int access) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniform1dv(int location, int count, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexStorageAttribs3DEXT(int target, int levels, int internalformat, int width, int height, int depth, int attrib_list) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glPrimitiveBoundingBoxOES(float minX, float minY, float minZ, float minW, float maxX, float maxY, float maxZ, float maxW) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribI4bvEXT(int index, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetProgramResourceiv(int program, int programInterface, int index, int propCount, MemorySegment props, int count, MemorySegment length, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribI1ivEXT(int index, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMemoryObjectParameterivEXT(int memoryObject, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetColorTableSGI(int target, int format, int type, MemorySegment table) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetObjectBufferivATI(int buffer, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexCoord2bvOES(MemorySegment coords) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glNamedFramebufferTexture3DEXT(int framebuffer, int attachment, int textarget, int texture, int level, int zoffset) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniform3i64NV(int location, long x, long y, long z) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDrawMeshTasksIndirectNV(long indirect) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetnMapdv(int target, int query, int bufSize, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glConvolutionFilter1DEXT(int target, int internalformat, int width, int format, int type, MemorySegment image) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glCopyImageSubDataEXT(int srcName, int srcTarget, int srcLevel, int srcX, int srcY, int srcZ, int dstName, int dstTarget, int dstLevel, int dstX, int dstY, int dstZ, int srcWidth, int srcHeight, int srcDepth) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDeleteVertexArrays(int n, MemorySegment arrays) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetUniformSubroutineuiv(int shadertype, int location, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFogCoordfv(MemorySegment coord) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniformHandleui64vARB(int program, int location, int count, MemorySegment values) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glCompressedTextureImage3DEXT(int texture, int target, int level, int internalformat, int width, int height, int depth, int border, int imageSize, MemorySegment bits) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public byte glIsStateNV(int state) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDeleteFramebuffers(int n, MemorySegment framebuffers) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniform1fv(int location, int count, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribL1i64vNV(int index, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glSamplerParameterIiv(int sampler, int pname, MemorySegment param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetShaderiv(int shader, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVariantPointerEXT(int id, int type, int stride, MemorySegment addr) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVariantfvEXT(int id, MemorySegment addr) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBindFragDataLocation(int program, int color, MemorySegment name) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniformMatrix3x2fvEXT(int program, int location, int count, byte transpose, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttrib1dvARB(int index, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetIntegerui64vNV(int value, MemorySegment result) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexCoord3hvNV(MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glWeightPathsNV(int resultPath, int numPaths, MemorySegment paths, MemorySegment weights) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiDrawElementsIndirect(int mode, int type, MemorySegment indirect, int drawcount, int stride) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBufferStorageEXT(int target, long size, MemorySegment data, int flags) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexCoordP3ui(int texture, int type, int coords) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetCompressedTexImage(int target, int level, MemorySegment img) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public int glPathGlyphIndexRangeNV(int fontTarget, MemorySegment fontName, int fontStyle, int pathParameterTemplate, float emScale, MemorySegment baseAndCount) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramParameter4fvNV(int target, int index, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniform2uiv(int location, int count, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glResetMinmaxEXT(int target) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBindTransformFeedbackNV(int target, int id) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexCoord3sv(int target, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttrib1fv(int index, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexWeighthNV(short weight) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glPixelTexGenParameteriSGIS(int pname, int param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribL4i64NV(int index, long x, long y, long z, long w) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glStencilClearTagEXT(int stencilTagBits, int stencilClearTag) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBeginQuery(int target, int id) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetFloati_v(int target, int index, MemorySegment data) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttrib4NbvARB(int index, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttrib4hNV(int index, short x, short y, short z, short w) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public byte glIsEnabledi(int target, int index) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniform2dEXT(int program, int location, double x, double y) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public int glGetDebugMessageLog(int count, int bufSize, MemorySegment sources, MemorySegment types, MemorySegment ids, MemorySegment severities, MemorySegment lengths, MemorySegment messageLog) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttrib1dv(int index, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public int glCreateProgressFenceNVX() {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glPointParameterxvOES(int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glPixelTexGenParameterfvSGIS(int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiDrawMeshTasksIndirectCountNV(long indirect, long drawcount, int maxdrawcount, int stride) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glPathCoordsNV(int path, int numCoords, int coordType, MemorySegment coords) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetIntegerIndexedvEXT(int target, int index, MemorySegment data) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public int glCheckNamedFramebufferStatus(int framebuffer, int target) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexEnvivEXT(int texunit, int target, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public byte glTestFenceNV(int fence) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTextureBuffer(int texture, int internalformat, int buffer) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public int glObjectUnpurgeableAPPLE(int objectType, int name, int option) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBindVideoCaptureStreamTextureNV(int video_capture_slot, int stream, int frame_region, int target, int texture) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBlendFuncSeparateINGR(int sfactorRGB, int dfactorRGB, int sfactorAlpha, int dfactorAlpha) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public byte glIsPathNV(int path) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMinSampleShadingOES(float value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetMemoryObjectParameterivEXT(int memoryObject, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMatrixOrthoEXT(int mode, double left, double right, double bottom, double top, double zNear, double zFar) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDepthRangeIndexeddNV(int index, double n, double f) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniform3fEXT(int program, int location, float v0, float v1, float v2) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiDrawElementsBaseVertexEXT(int mode, MemorySegment count, int type, MemorySegment indices, int drawcount, MemorySegment basevertex) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetnMapiv(int target, int query, int bufSize, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniform1uiv(int program, int location, int count, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniformMatrix3dv(int location, int count, byte transpose, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniform1ui64ARB(int location, long x) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDeleteCommandListsNV(int n, MemorySegment lists) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glSignalVkFenceNV(long vkFence) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribI1iv(int index, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glCoverStrokePathNV(int path, int coverMode) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDisableVertexArrayAttrib(int vaobj, int index) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glNamedFramebufferRenderbuffer(int framebuffer, int attachment, int renderbuffertarget, int renderbuffer) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glNamedFramebufferTextureLayerEXT(int framebuffer, int attachment, int texture, int level, int layer) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glSecondaryColorP3uiv(int type, MemorySegment color) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexStorage1D(int target, int levels, int internalformat, int width) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTextureStorageMem3DMultisampleEXT(int texture, int samples, int internalFormat, int width, int height, int depth, byte fixedSampleLocations, int memory, long offset) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetProgramNamedParameterfvNV(int id, int len, MemorySegment name, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glCompressedMultiTexSubImage3DEXT(int texunit, int target, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int format, int imageSize, MemorySegment bits) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glEndTransformFeedback() {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttrib2sNV(int index, short x, short y) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexGenxOES(int coord, int pname, int param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexSubImage1DEXT(int texunit, int target, int level, int xoffset, int width, int format, int type, MemorySegment pixels) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniformMatrix3fv(int location, int count, byte transpose, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexStorage2D(int target, int levels, int internalformat, int width, int height) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glReplacementCodeuiSUN(int code) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetUniformIndices(int program, int uniformCount, MemorySegment uniformNames, MemorySegment uniformIndices) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glReplacementCodeuiTexCoord2fVertex3fvSUN(MemorySegment rc, MemorySegment tc, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBindProgramPipelineEXT(int pipeline) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMapVertexAttrib1fAPPLE(int index, int size, float u1, float u2, int stride, int order, MemorySegment points) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glEnableClientStateiEXT(int array, int index) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glWindowPos3ivARB(MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexCoord1bvOES(int texture, MemorySegment coords) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribI2uivEXT(int index, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribL4d(int index, double x, double y, double z, double w) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexStorage3D(int target, int levels, int internalformat, int width, int height, int depth) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVDPAUSurfaceAccessNV(int surface, int access) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGenQueries(int n, MemorySegment ids) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public byte glIsMemoryObjectEXT(int memoryObject) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public int glGetProgramResourceLocationIndexEXT(int program, int programInterface, MemorySegment name) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttrib3dARB(int index, double x, double y, double z) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetActiveSubroutineUniformiv(int program, int shadertype, int index, int pname, MemorySegment values) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public int glPollAsyncSGIX(MemorySegment markerp) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glEnableVertexArrayEXT(int vaobj, int array) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFlushPixelDataRangeNV(int target) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexCoord3iARB(int target, int s, int t, int r) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glResetMinmax(int target) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexCoord4fVertex4fvSUN(MemorySegment tc, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFogCoorddvEXT(MemorySegment coord) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttrib4uivARB(int index, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetTranslatedShaderSourceANGLE(int shader, int bufSize, MemorySegment length, MemorySegment source) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetTransformFeedbacki64_v(int xfb, int pname, int index, MemorySegment param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiDrawElementsBaseVertex(int mode, MemorySegment count, int type, MemorySegment indices, int drawcount, MemorySegment basevertex) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniform1ui64ARB(int program, int location, long x) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniformMatrix3x2fv(int location, int count, byte transpose, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBinormal3fEXT(float bx, float by, float bz) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFlushMappedNamedBufferRange(int buffer, long offset, long length) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUseShaderProgramEXT(int type, int program) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glLightxv(int light, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetColorTableParameteriv(int target, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexCoordP4ui(int type, int coords) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glNamedFramebufferRenderbufferEXT(int framebuffer, int attachment, int renderbuffertarget, int renderbuffer) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribI1iEXT(int index, int x) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetActiveUniformBlockiv(int program, int uniformBlockIndex, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public short glGetStageIndexNV(int shadertype) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniformMatrix2fv(int program, int location, int count, byte transpose, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glSecondaryColor3uiEXT(int red, int green, int blue) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniform1iARB(int location, int v0) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glCompileShaderIncludeARB(int shader, int count, MemorySegment path, MemorySegment length) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFramebufferTexture1DEXT(int target, int attachment, int textarget, int texture, int level) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetPerfQueryInfoINTEL(int queryId, int queryNameLength, MemorySegment queryName, MemorySegment dataSize, MemorySegment noCounters, MemorySegment noInstances, MemorySegment capsMask) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUseProgramStagesEXT(int pipeline, int stages, int program) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexCoord4svARB(int target, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexStorageSparseAMD(int target, int internalFormat, int width, int height, int depth, int layers, int flags) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDrawArraysInstancedNV(int mode, int first, int count, int primcount) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glColor4xvOES(MemorySegment components) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniform2i64ARB(int location, int x, int y) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttrib4Nbv(int index, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetInteger64vAPPLE(int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDeleteMemoryObjectsEXT(int n, MemorySegment memoryObjects) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexParameterivEXT(int texunit, int target, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribI3uiEXT(int index, int x, int y, int z) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBinormal3fvEXT(MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniformMatrix2x3dvEXT(int program, int location, int count, byte transpose, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glLoadMatrixx(MemorySegment m) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribL2dv(int index, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetCombinerOutputParameterfvNV(int stage, int portion, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glStencilOpSeparateATI(int face, int sfail, int dpfail, int dppass) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMinSampleShading(float value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniformMatrix2dv(int program, int location, int count, byte transpose, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glNamedCopyBufferSubDataEXT(int readBuffer, int writeBuffer, long readOffset, long writeOffset, long size) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glValidateProgram(int program) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexStream3sATI(int stream, short x, short y, short z) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTextureStorageMem3DEXT(int texture, int levels, int internalFormat, int width, int height, int depth, int memory, long offset) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniformMatrix3x4dvEXT(int program, int location, int count, byte transpose, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDeleteVertexArraysOES(int n, MemorySegment arrays) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDeleteVertexShaderEXT(int id) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glNamedFramebufferTextureLayer(int framebuffer, int attachment, int texture, int level, int layer) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetTexFilterFuncSGIS(int target, int filter, MemorySegment weights) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramLocalParameter4fvARB(int target, int index, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetLocalConstantBooleanvEXT(int id, int value, MemorySegment data) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public byte glTestObjectAPPLE(int object, int name) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glCopyTexImage2DEXT(int target, int level, int internalformat, int x, int y, int width, int height, int border) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexStream2fATI(int stream, float x, float y) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniform3i64vNV(int program, int location, int count, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glResizeBuffersMESA() {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDrawElementsInstancedBaseVertexBaseInstanceEXT(int mode, int count, int type, MemorySegment indices, int instancecount, int basevertex, int baseinstance) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetArrayObjectfvATI(int array, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiDrawElementsIndirectEXT(int mode, int type, MemorySegment indirect, int drawcount, int stride) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramParameters4fvNV(int target, int index, int count, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniformHandleui64NV(int location, long value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttrib4Nusv(int index, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexStream1dATI(int stream, double x) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexCoord1svARB(int target, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramParameteri(int program, int pname, int value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBindFramebufferEXT(int target, int framebuffer) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniform1ui(int location, int v0) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetTexParameterIivOES(int target, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexCoordP3uiv(int texture, int type, MemorySegment coords) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glClearBufferuiv(int buffer, int drawbuffer, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDeleteQueryResourceTagNV(int n, MemorySegment tagIds) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetBufferPointervARB(int target, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glSampleMaskSGIS(float value, byte invert) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexEnvxOES(int target, int pname, int param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDebugMessageInsertARB(int source, int type, int id, int severity, int length, MemorySegment buf) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetTexBumpParameterivATI(int pname, MemorySegment param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDepthRangeArrayfvOES(int first, int count, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFragmentColorMaterialSGIX(int face, int mode) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetDetailTexFuncSGIS(int target, MemorySegment points) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glQueryCounterEXT(int id, int target) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMulticastCopyBufferSubDataNV(int readGpu, int writeGpuMask, int readBuffer, int writeBuffer, long readOffset, long writeOffset, long size) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetPointervEXT(int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexParameterx(int target, int pname, int param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexCoord4sv(int target, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttrib4Niv(int index, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVideoCaptureStreamParameterdvNV(int video_capture_slot, int stream, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetSharpenTexFuncSGIS(int target, MemorySegment points) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTextureViewOES(int texture, int target, int origtexture, int internalformat, int minlevel, int numlevels, int minlayer, int numlayers) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetPathDashArrayNV(int path, MemorySegment dashArray) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glPixelTransformParameterivEXT(int target, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetColorTableParameterfv(int target, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetBufferPointerv(int target, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramLocalParameter4dARB(int target, int index, double x, double y, double z, double w) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glSignalSemaphoreEXT(int semaphore, int numBufferBarriers, MemorySegment buffers, int numTextureBarriers, MemorySegment textures, MemorySegment dstLayouts) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetTexGenivOES(int coord, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTextureParameterfvEXT(int texture, int target, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glLightx(int light, int pname, int param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribL1dEXT(int index, double x) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDrawTexxOES(int x, int y, int z, int width, int height) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexCoord4dv(int target, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glPresentFrameDualFillNV(int video_slot, long minPresentTime, int beginPresentTimeId, int presentDurationId, int type, int target0, int fill0, int target1, int fill1, int target2, int fill2, int target3, int fill3) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetMinmaxParameterivEXT(int target, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glLGPUInterlockNVX() {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBindBufferRange(int target, int index, int buffer, long offset, long size) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glCombinerParameterfvNV(int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultMatrixx(MemorySegment m) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glPathSubCoordsNV(int path, int coordStart, int numCoords, int coordType, MemorySegment coords) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexStream3fvATI(int stream, MemorySegment coords) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glReferencePlaneSGIX(MemorySegment equation) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glWindowPos4iMESA(int x, int y, int z, int w) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetPixelTransformParameterivEXT(int target, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glQueryObjectParameteruiAMD(int target, int id, int pname, int param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBlendEquationiEXT(int buf, int mode) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDebugMessageControlKHR(int source, int type, int severity, int count, MemorySegment ids, byte enabled) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glWindowPos3iARB(int x, int y, int z) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBindShadingRateImageNV(int texture) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexArrayVertexAttribIFormatEXT(int vaobj, int attribindex, int size, int type, int relativeoffset) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTextureImage3DMultisampleCoverageNV(int texture, int target, int coverageSamples, int colorSamples, int internalFormat, int width, int height, int depth, byte fixedSampleLocations) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexCoord3ivARB(int target, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniform2ui64vARB(int program, int location, int count, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexCoord4fv(int target, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetBufferParameteri64v(int target, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glRasterPos4xOES(int x, int y, int z, int w) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTextureColorMaskSGIS(byte red, byte green, byte blue, byte alpha) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetListParameterivSGIX(int list, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexArrayColorOffsetEXT(int vaobj, int buffer, int size, int type, int stride, long offset) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBlendFuncSeparateEXT(int sfactorRGB, int dfactorRGB, int sfactorAlpha, int dfactorAlpha) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDebugMessageInsertAMD(int category, int severity, int id, int length, MemorySegment buf) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBeginConditionalRenderNV(int id, int mode) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiDrawArraysIndirectCount(int mode, MemorySegment indirect, long drawcount, int maxdrawcount, int stride) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDeleteRenderbuffers(int n, MemorySegment renderbuffers) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniform3i64vARB(int program, int location, int count, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribI1ui(int index, int x) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDisableVariantClientStateEXT(int id) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glColor4xOES(int red, int green, int blue, int alpha) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glStencilOpValueAMD(int face, int value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGenRenderbuffersOES(int n, MemorySegment renderbuffers) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttrib4Nuiv(int index, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glNamedBufferPageCommitmentARB(int buffer, long offset, long size, byte commit) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexGeniEXT(int texunit, int coord, int pname, int param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetnUniformivEXT(int program, int location, int bufSize, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertex4xvOES(MemorySegment coords) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDeleteFramebuffersOES(int n, MemorySegment framebuffers) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniform4uiv(int program, int location, int count, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexBufferOES(int target, int internalformat, int buffer) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glSpecializeShaderARB(int shader, MemorySegment pEntryPoint, int numSpecializationConstants, MemorySegment pConstantIndex, MemorySegment pConstantValue) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glEvalMapsNV(int target, int mode) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMulticastBufferSubDataNV(int gpuMask, int buffer, long offset, long size, MemorySegment data) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMatrixScalefEXT(int mode, float x, float y, float z) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexCoord4iv(int target, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetProgramStageiv(int program, int shadertype, int pname, MemorySegment values) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetnCompressedTexImageARB(int target, int lod, int bufSize, MemorySegment img) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glLGPUNamedBufferSubDataNVX(int gpuMask, int buffer, long offset, long size, MemorySegment data) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniform1uivEXT(int program, int location, int count, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetLocalConstantIntegervEXT(int id, int value, MemorySegment data) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTextureSubImage3D(int texture, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int format, int type, MemorySegment pixels) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribI3uiv(int index, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glClearTexImage(int texture, int level, int format, int type, MemorySegment data) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTangent3fEXT(float tx, float ty, float tz) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttrib1sv(int index, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glExtGetBuffersQCOM(MemorySegment buffers, int maxBuffers, MemorySegment numBuffers) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetMultiTexParameterivEXT(int texunit, int target, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMaterialxOES(int face, int pname, int param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMaxShaderCompilerThreadsKHR(int count) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertex2hvNV(MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDrawTexivOES(MemorySegment coords) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGenFencesNV(int n, MemorySegment fences) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMulticastScissorArrayvNVX(int gpu, int first, int count, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glViewportArrayvOES(int first, int count, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTextureSubImage2D(int texture, int level, int xoffset, int yoffset, int width, int height, int format, int type, MemorySegment pixels) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttrib1hNV(int index, short x) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDebugMessageControl(int source, int type, int severity, int count, MemorySegment ids, byte enabled) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniform3i64vARB(int location, int count, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFlushMappedNamedBufferRangeEXT(int buffer, long offset, long length) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glArrayObjectATI(int array, int size, int type, int stride, int buffer, int offset) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetActiveUniformBlockName(int program, int uniformBlockIndex, int bufSize, MemorySegment length, MemorySegment uniformBlockName) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetColorTable(int target, int format, int type, MemorySegment table) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glRenderbufferStorageMultisampleAPPLE(int target, int samples, int internalformat, int width, int height) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public byte glIsProgramARB(int program) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBlitFramebufferEXT(int srcX0, int srcY0, int srcX1, int srcY1, int dstX0, int dstY0, int dstX1, int dstY1, int mask, int filter) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public int glAsyncCopyBufferSubDataNVX(int waitSemaphoreCount, MemorySegment waitSemaphoreArray, MemorySegment fenceValueArray, int readGpu, int writeGpuMask, int readBuffer, int writeBuffer, long readOffset, long writeOffset, long size, int signalSemaphoreCount, MemorySegment signalSemaphoreArray, MemorySegment signalValueArray) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramEnvParameterI4iNV(int target, int index, int x, int y, int z, int w) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexSubImage4DSGIS(int target, int level, int xoffset, int yoffset, int zoffset, int woffset, int width, int height, int depth, int size4d, int format, int type, MemorySegment pixels) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetProgramivNV(int id, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glInvalidateTexSubImage(int texture, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttrib4dvNV(int index, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glEndTransformFeedbackEXT() {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTextureSubImage1D(int texture, int level, int xoffset, int width, int format, int type, MemorySegment pixels) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetMultiTexGenfvEXT(int texunit, int coord, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glCompressedTexImage2DARB(int target, int level, int internalformat, int width, int height, int border, int imageSize, MemorySegment data) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glPathStringNV(int path, int format, int length, MemorySegment pathString) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetMapControlPointsNV(int target, int index, int type, int ustride, int vstride, byte packed, MemorySegment points) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDeformationMap3dSGIX(int target, double u1, double u2, int ustride, int uorder, double v1, double v2, int vstride, int vorder, double w1, double w2, int wstride, int worder, MemorySegment points) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetPointerIndexedvEXT(int target, int index, MemorySegment data) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetVertexAttribivNV(int index, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniform3i64ARB(int program, int location, int x, int y, int z) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glSetLocalConstantEXT(int id, int type, MemorySegment addr) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public byte glIsVertexArray(int array) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFramebufferTexture2DMultisampleEXT(int target, int attachment, int textarget, int texture, int level, int samples) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexCoord1sARB(int target, short s) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public int glVideoCaptureNV(int video_capture_slot, MemorySegment sequence_num, MemorySegment capture_time) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetnMinmax(int target, byte reset, int format, int type, int bufSize, MemorySegment values) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public MemorySegment glFenceSync(int condition, int flags) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFramebufferDrawBufferEXT(int framebuffer, int mode) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFogx(int pname, int param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBindAttribLocation(int program, int index, MemorySegment name) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glListDrawCommandsStatesClientNV(int list, int segment, MemorySegment indirects, MemorySegment sizes, MemorySegment states, MemorySegment fbos, int count) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetProgramPipelineivEXT(int pipeline, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glRasterPos2xvOES(MemorySegment coords) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniformMatrix3fvEXT(int program, int location, int count, byte transpose, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetMaterialxv(int face, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetnUniformfvEXT(int program, int location, int bufSize, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniformMatrix4x2fvEXT(int program, int location, int count, byte transpose, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDeformSGIX(int mask) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glStartTilingQCOM(int x, int y, int width, int height, int preserveMask) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glSecondaryColor3dvEXT(MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexCoordPointerListIBM(int size, int type, int stride, MemorySegment pointer, int ptrstride) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glEndFragmentShaderATI() {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniform3iEXT(int program, int location, int v0, int v1, int v2) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttrib1fNV(int index, float x) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBindAttribLocationARB(MemorySegment programObj, int index, MemorySegment name) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glLightxvOES(int light, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetHistogramEXT(int target, byte reset, int format, int type, MemorySegment values) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFramebufferSampleLocationsfvNV(int target, int start, int count, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glNamedBufferStorageExternalEXT(int buffer, long offset, long size, MemorySegment clientBuffer, int flags) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexEnvx(int target, int pname, int param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribP4uiv(int index, int type, byte normalized, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetQueryivARB(int target, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glInvalidateSubFramebuffer(int target, int numAttachments, MemorySegment attachments, int x, int y, int width, int height) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glEvalCoord1xOES(int u) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexCoord2fvARB(int target, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexCoord2fVertex3fvSUN(MemorySegment tc, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glWindowPos2fvMESA(MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glWeightfvARB(int size, MemorySegment weights) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniform4i(int program, int location, int v0, int v1, int v2, int v3) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniform4d(int program, int location, double v0, double v1, double v2, double v3) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniform4f(int program, int location, float v0, float v1, float v2, float v3) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDrawArraysEXT(int mode, int first, int count) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glPointParameteriNV(int pname, int param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glEGLImageTargetTexture2DOES(int target, int image) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFeedbackBufferxOES(int n, int type, MemorySegment buffer) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBufferParameteriAPPLE(int target, int pname, int param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glPatchParameteriOES(int pname, int value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBufferDataARB(int target, long size, MemorySegment data, int usage) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetLocalConstantFloatvEXT(int id, int value, MemorySegment data) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glWaitSemaphoreui64NVX(int waitGpu, int fenceObjectCount, MemorySegment semaphoreArray, MemorySegment fenceValueArray) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDeleteSyncAPPLE(MemorySegment sync) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glEndTilingQCOM(int preserveMask) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glWriteMaskEXT(int res, int in, int outX, int outY, int outZ, int outW) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetFramebufferAttachmentParameteriv(int target, int attachment, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTextureImage3DEXT(int texture, int target, int level, int internalformat, int width, int height, int depth, int border, int format, int type, MemorySegment pixels) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glPixelTransferxOES(int pname, int param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniform2f(int program, int location, float v0, float v1) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniform2i(int program, int location, int v0, int v1) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexCoord2xvOES(MemorySegment coords) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDrawArraysInstanced(int mode, int first, int count, int instancecount) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribs4dvNV(int index, int count, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDrawTexxvOES(MemorySegment coords) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTextureParameterIivEXT(int texture, int target, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDisableVertexAttribArrayARB(int index) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniform2d(int program, int location, double v0, double v1) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramEnvParameterI4uiNV(int target, int index, int x, int y, int z, int w) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniform4iARB(int location, int v0, int v1, int v2, int v3) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniform3f(int program, int location, float v0, float v1, float v2) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniform3i(int program, int location, int v0, int v1, int v2) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetNextPerfQueryIdINTEL(int queryId, MemorySegment nextQueryId) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMapGrid2xOES(int n, int u1, int u2, int v1, int v2) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniform3d(int program, int location, double v0, double v1, double v2) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDepthRangedNV(double zNear, double zFar) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glWindowPos3dvMESA(MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glClearColorx(int red, int green, int blue, int alpha) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glCompileShader(int shader) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexRenderbufferEXT(int texunit, int target, int renderbuffer) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glSamplerParameterIuivEXT(int sampler, int pname, MemorySegment param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glRenderbufferStorageMultisampleEXT(int target, int samples, int internalformat, int width, int height) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDisableVertexArrayAttribEXT(int vaobj, int index) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glSecondaryColor3hNV(short red, short green, short blue) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glShaderOp3EXT(int op, int res, int arg1, int arg2, int arg3) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public byte glIsRenderbuffer(int renderbuffer) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glResolveMultisampleFramebufferAPPLE() {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMatrixMult3x3fNV(int matrixMode, MemorySegment m) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetProgramResourceName(int program, int programInterface, int index, int bufSize, MemorySegment length, MemorySegment name) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexGendvEXT(int texunit, int coord, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glNamedRenderbufferStorageMultisampleEXT(int renderbuffer, int samples, int internalformat, int width, int height) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDeleteOcclusionQueriesNV(int n, MemorySegment ids) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glColorMaskIndexedEXT(int index, byte r, byte g, byte b, byte a) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glCopyTextureImage1DEXT(int texture, int target, int level, int internalformat, int x, int y, int width, int border) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniformMatrix4dv(int location, int count, byte transpose, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glColor3fVertex3fvSUN(MemorySegment c, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetCombinerOutputParameterivNV(int stage, int portion, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMatrixTranslatedEXT(int mode, double x, double y, double z) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glReplacementCodeuiColor4fNormal3fVertex3fSUN(int rc, float r, float g, float b, float a, float nx, float ny, float nz, float x, float y, float z) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glPrioritizeTexturesxOES(int n, MemorySegment textures, MemorySegment priorities) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetSemaphoreParameterui64vEXT(int semaphore, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexStream3ivATI(int stream, MemorySegment coords) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniformMatrix2x3fvNV(int location, int count, byte transpose, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glCreateBuffers(int n, MemorySegment buffers) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiDrawMeshTasksIndirectNV(long indirect, int drawcount, int stride) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTangent3iEXT(int tx, int ty, int tz) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribP4ui(int index, int type, byte normalized, int value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glClearDepthfOES(float depth) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetVideoi64vNV(int video_slot, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexCoordP2ui(int texture, int type, int coords) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniform3fvEXT(int program, int location, int count, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glScissorIndexedvNV(int index, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTextureImage3DMultisampleNV(int texture, int target, int samples, int internalFormat, int width, int height, int depth, byte fixedSampleLocations) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glWeightusvARB(int size, MemorySegment weights) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetDriverControlsQCOM(MemorySegment num, int size, MemorySegment driverControls) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetTexGenxvOES(int coord, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexCoord2sv(int target, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
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
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttrib4NusvARB(int index, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glCopyMultiTexImage2DEXT(int texunit, int target, int level, int internalformat, int x, int y, int width, int height, int border) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexArrayRangeNV(int length, MemorySegment pointer) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBlendEquationSeparateiARB(int buf, int modeRGB, int modeAlpha) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUseProgram(int program) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetProgramInterfaceiv(int program, int programInterface, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVariantArrayObjectATI(int id, int type, int stride, int buffer, int offset) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glEndOcclusionQueryNV() {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniformMatrix4fv(int location, int count, byte transpose, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBeginConditionalRenderNVX(int id) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexCoord2xvOES(int texture, MemorySegment coords) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetPixelTexGenParameterivSGIS(int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glSemaphoreParameterui64vEXT(int semaphore, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glImportMemoryWin32NameEXT(int memory, long size, int handleType, MemorySegment name) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribI4ivEXT(int index, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDebugMessageCallbackARB(MemorySegment callback, MemorySegment userParam) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public int glGenSymbolsEXT(int datatype, int storagetype, int range, int components) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttrib3dNV(int index, double x, double y, double z) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexCoordP4uiv(int type, MemorySegment coords) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glEvalCoord1xvOES(MemorySegment coords) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glWindowPos3dARB(double x, double y, double z) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glCopyTextureLevelsAPPLE(int destinationTexture, int sourceTexture, int sourceBaseLevel, int sourceLevelCount) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glPathDashArrayNV(int path, int dashCount, MemorySegment dashArray) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetFragmentMaterialfvSGIX(int face, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetTexBumpParameterfvATI(int pname, MemorySegment param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glSampleCoverage(float value, byte invert) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribI3uivEXT(int index, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetTexParameterxvOES(int target, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetBooleanIndexedvEXT(int target, int index, MemorySegment data) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexCoord3fvARB(int target, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexStream2iATI(int stream, int x, int y) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGenPerfMonitorsAMD(int n, MemorySegment monitors) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexCoord4xOES(int texture, int s, int t, int r, int q) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glNamedFramebufferParameteriEXT(int framebuffer, int pname, int param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glReplacementCodeuiColor4fNormal3fVertex3fvSUN(MemorySegment rc, MemorySegment c, MemorySegment n, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glScissorIndexed(int index, int left, int bottom, int width, int height) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMatrixLoadIdentityEXT(int mode) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glReplacementCodeuiTexCoord2fNormal3fVertex3fSUN(int rc, float s, float t, float nx, float ny, float nz, float x, float y, float z) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glSamplerParameteri(int sampler, int pname, int param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDeleteProgramPipelinesEXT(int n, MemorySegment pipelines) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glSamplerParameterf(int sampler, int pname, float param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glSecondaryColor3uivEXT(MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glSampleCoverageARB(float value, byte invert) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glWeightPointerARB(int size, int type, int stride, MemorySegment pointer) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniform2i64NV(int program, int location, long x, long y) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDrawTransformFeedbackStream(int mode, int id, int stream) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTextureRangeAPPLE(int target, int length, MemorySegment pointer) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBinormal3ivEXT(MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glPolygonOffsetClampEXT(float factor, float units, float clamp) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glNormalStream3fvATI(int stream, MemorySegment coords) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glEndQueryIndexed(int target, int index) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glPrimitiveBoundingBoxEXT(float minX, float minY, float minZ, float minW, float maxX, float maxY, float maxZ, float maxW) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexCoord4bOES(int texture, byte s, byte t, byte r, byte q) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glStopInstrumentsSGIX(int marker) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMakeTextureHandleResidentARB(long handle) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexStream2fvATI(int stream, MemorySegment coords) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramLocalParameterI4uivNV(int target, int index, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBufferSubDataARB(int target, long offset, long size, MemorySegment data) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniformui64vNV(int program, int location, int count, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniformMatrix2x4dv(int program, int location, int count, byte transpose, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexCoord2xOES(int s, int t) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribL1dv(int index, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGenOcclusionQueriesNV(int n, MemorySegment ids) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBlitFramebufferNV(int srcX0, int srcY0, int srcX1, int srcY1, int dstX0, int dstY0, int dstX1, int dstY1, int mask, int filter) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFlushMappedBufferRangeAPPLE(int target, long offset, long size) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetObjectLabelKHR(int identifier, int name, int bufSize, MemorySegment length, MemorySegment label) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribL2d(int index, double x, double y) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glWindowPos3fvARB(MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glPushClientAttribDefaultEXT(int mask) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexCoord2hvNV(int target, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVariantbvEXT(int id, MemorySegment addr) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniform2i64vARB(int program, int location, int count, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDepthRangefOES(float n, float f) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public int glVDPAURegisterVideoSurfaceNV(MemorySegment vdpSurface, int target, int numTextureNames, MemorySegment textureNames) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetVertexAttribdvARB(int index, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribL3d(int index, double x, double y, double z) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniformMatrix3x2dv(int location, int count, byte transpose, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetnMapivARB(int target, int query, int bufSize, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBindBuffer(int target, int buffer) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexCoordP3ui(int type, int coords) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniform1i64vNV(int location, int count, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glColor3fVertex3fSUN(float r, float g, float b, float x, float y, float z) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glPrioritizeTexturesEXT(int n, MemorySegment textures, MemorySegment priorities) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttrib1sARB(int index, short x) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniformHandleui64vIMG(int program, int location, int count, MemorySegment values) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultTransposeMatrixdARB(MemorySegment m) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribIPointerEXT(int index, int size, int type, int stride, MemorySegment pointer) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexArrayParameteriAPPLE(int pname, int param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniformMatrix3fv(int program, int location, int count, byte transpose, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexCoord2bOES(byte s, byte t) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniform1ivEXT(int program, int location, int count, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribs2svNV(int index, int count, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glShaderSourceARB(MemorySegment shaderObj, int count, MemorySegment string, MemorySegment length) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glCompressedTexSubImage2DARB(int target, int level, int xoffset, int yoffset, int width, int height, int format, int imageSize, MemorySegment data) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetNamedBufferParameteri64v(int buffer, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetActiveUniformARB(MemorySegment programObj, int index, int maxLength, MemorySegment length, MemorySegment size, MemorySegment type, MemorySegment name) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribL1d(int index, double x) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glApplyTextureEXT(int mode) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDebugMessageCallbackAMD(MemorySegment callback, MemorySegment userParam) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMulticastGetQueryObjecti64vNV(int gpu, int id, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexParameterIuivEXT(int target, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDeleteTransformFeedbacksNV(int n, MemorySegment ids) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glResetMemoryObjectParameterNV(int memory, int pname) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexturePageCommitmentEXT(int texture, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, byte commit) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDrawArraysInstancedBaseInstanceEXT(int mode, int first, int count, int instancecount, int baseinstance) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public byte glIsProgramNV(int id) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTextureBufferRange(int texture, int internalformat, int buffer, long offset, long size) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBeginQueryEXT(int target, int id) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetQueryObjectivEXT(int id, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glPixelTexGenParameterivSGIS(int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetVertexAttribLui64vARB(int index, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetnUniformdvARB(int program, int location, int bufSize, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniformMatrix3dv(int program, int location, int count, byte transpose, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetLightxv(int light, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetVertexAttribIuivEXT(int index, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexCoord2hNV(short s, short t) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBlendFuncSeparateiARB(int buf, int srcRGB, int dstRGB, int srcAlpha, int dstAlpha) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glNamedProgramLocalParametersI4ivEXT(int program, int target, int index, int count, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGenRenderbuffersEXT(int n, MemorySegment renderbuffers) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTextureSubImage1DEXT(int texture, int target, int level, int xoffset, int width, int format, int type, MemorySegment pixels) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glCompressedTextureSubImage3DEXT(int texture, int target, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int format, int imageSize, MemorySegment bits) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribs2hvNV(int index, int n, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTextureFoveationParametersQCOM(int texture, int layer, int focalPoint, float focalX, float focalY, float gainX, float gainY, float foveaArea) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDrawElementsInstancedBaseInstance(int mode, int count, int type, MemorySegment indices, int instancecount, int baseinstance) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniform2ui64ARB(int program, int location, long x, long y) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMatrixPopEXT(int mode) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetNamedStringARB(int namelen, MemorySegment name, int bufSize, MemorySegment stringlen, MemorySegment string) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDeleteFramebuffersEXT(int n, MemorySegment framebuffers) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDispatchCompute(int num_groups_x, int num_groups_y, int num_groups_z) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniformMatrix2x4fv(int program, int location, int count, byte transpose, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUpdateObjectBufferATI(int buffer, int offset, int size, MemorySegment pointer, int preserve) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTextureBufferEXT(int texture, int target, int internalformat, int buffer) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glWeightbvARB(int size, MemorySegment weights) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDrawElementsInstancedARB(int mode, int count, int type, MemorySegment indices, int primcount) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMulticastBlitFramebufferNV(int srcGpu, int dstGpu, int srcX0, int srcY0, int srcX1, int srcY1, int dstX0, int dstY0, int dstX1, int dstY1, int mask, int filter) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glClearNamedBufferSubData(int buffer, int internalformat, long offset, long size, int format, int type, MemorySegment data) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribs1fvNV(int index, int count, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMinmaxEXT(int target, int internalformat, byte sink) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniform4i64ARB(int program, int location, int x, int y, int z, int w) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glNormalStream3bATI(int stream, byte nx, byte ny, byte nz) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTessellationModeAMD(int mode) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetTexParameterIuiv(int target, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glOrthof(float l, float r, float b, float t, float n, float f) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribBinding(int attribindex, int bindingindex) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glSamplerParameterfv(int sampler, int pname, MemorySegment param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexCoordP1uiv(int type, MemorySegment coords) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGenProgramPipelines(int n, MemorySegment pipelines) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMulticastViewportPositionWScaleNVX(int gpu, int index, float xcoeff, float ycoeff) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glOrthox(int l, int r, int b, int t, int n, int f) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glNamedBufferStorageEXT(int buffer, long size, MemorySegment data, int flags) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribP1uiv(int index, int type, byte normalized, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexParameterIiv(int target, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMatrixLoadTransposedEXT(int mode, MemorySegment m) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetVertexAttribLdvEXT(int index, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniformBufferEXT(int program, int location, int buffer) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetFirstPerfQueryIdINTEL(MemorySegment queryId) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glSamplerParameteriv(int sampler, int pname, MemorySegment param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexEnvxv(int target, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glEndConditionalRenderNVX() {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glShadingRateSampleOrderCustomNV(int rate, int samples, MemorySegment locations) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetAttachedShaders(int program, int maxCount, MemorySegment count, MemorySegment shaders) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetVariantArrayObjectivATI(int id, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttrib2fvARB(int index, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glSemaphoreParameterivNV(int semaphore, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFramebufferTextureLayerDownsampleIMG(int target, int attachment, int texture, int level, int layer, int xscale, int yscale) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetConvolutionParameterivEXT(int target, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetActiveUniformsiv(int program, int uniformCount, MemorySegment uniformIndices, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glNamedFramebufferTexture(int framebuffer, int attachment, int texture, int level) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniformMatrix3fvARB(int location, int count, byte transpose, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTransformPathNV(int resultPath, int srcPath, int transformType, MemorySegment transformValues) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniform1fARB(int location, float v0) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDisableDriverControlQCOM(int driverControl) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glExtGetProgramsQCOM(MemorySegment programs, int maxPrograms, MemorySegment numPrograms) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniform4i64vARB(int location, int count, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexCoord3dv(int target, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBindSamplers(int first, int count, MemorySegment samplers) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMap2xOES(int target, int u1, int u2, int ustride, int uorder, int v1, int v2, int vstride, int vorder, int points) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniform3ui64NV(int location, long x, long y, long z) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glViewportIndexedfvNV(int index, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public byte glIsVariantEnabledEXT(int id, int cap) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetFramebufferParameterfvAMD(int target, int pname, int numsamples, int pixelindex, int size, MemorySegment values) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniform1ui64vNV(int program, int location, int count, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glExecuteProgramNV(int target, int id, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFragmentMaterialfSGIX(int face, int pname, float param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glEnablei(int target, int index) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glReplacementCodePointerSUN(int type, int stride, MemorySegment pointer) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniform4ui64NV(int location, long x, long y, long z, long w) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glColorMaski(int index, byte r, byte g, byte b, byte a) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glSyncTextureINTEL(int texture) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniform2ui64NV(int location, long x, long y) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glCopyConvolutionFilter1D(int target, int internalformat, int x, int y, int width) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexCoord3fv(int target, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexCoord4fARB(int target, float s, float t, float r, float q) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glNamedProgramLocalParametersI4uivEXT(int program, int target, int index, int count, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMakeImageHandleNonResidentNV(long handle) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGenNamesAMD(int identifier, int num, MemorySegment names) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetIntegeri_v(int target, int index, MemorySegment data) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniform4ivEXT(int program, int location, int count, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetMultiTexParameterIivEXT(int texunit, int target, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glAttachObjectARB(MemorySegment containerObj, MemorySegment obj) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glCurrentPaletteMatrixARB(int index) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public MemorySegment glImportSyncEXT(int external_sync_type, long external_sync, int flags) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public int glGetFramebufferPixelLocalStorageSizeEXT(int target) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glCopyConvolutionFilter2D(int target, int internalformat, int x, int y, int width, int height) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertex4hNV(short x, short y, short z, short w) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDisableVertexAttribAPPLE(int index, int pname) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMatrixMultTransposedEXT(int mode, MemorySegment m) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetBufferParameteriv(int target, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glExtGetFramebuffersQCOM(MemorySegment framebuffers, int maxFramebuffers, MemorySegment numFramebuffers) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDrawBuffers(int n, MemorySegment bufs) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glSharpenTexFuncSGIS(int target, int n, MemorySegment points) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glSamplePatternSGIS(int pattern) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetInternalformatSampleivNV(int target, int internalformat, int samples, int pname, int count, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDebugMessageControlARB(int source, int type, int severity, int count, MemorySegment ids, byte enabled) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetNamedProgramLocalParameterfvEXT(int program, int target, int index, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetSemaphoreParameterivNV(int semaphore, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glStencilMaskSeparate(int face, int mask) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetVideoui64vNV(int video_slot, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDrawElementsInstancedBaseVertexEXT(int mode, int count, int type, MemorySegment indices, int instancecount, int basevertex) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGenQueriesARB(int n, MemorySegment ids) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetDoublei_v(int target, int index, MemorySegment data) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBlendFuncIndexedAMD(int buf, int src, int dst) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDetachObjectARB(MemorySegment containerObj, MemorySegment attachedObj) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMaxShaderCompilerThreadsARB(int count) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexCoord3iv(int target, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexCoord3dARB(int target, double s, double t, double r) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetColorTableParameterivEXT(int target, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBinormal3iEXT(int bx, int by, int bz) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glExtrapolateTex2DQCOM(int src1, int src2, int output, float scaleFactor) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetVertexAttribfvNV(int index, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDisableVertexArrayEXT(int vaobj, int array) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniform1ui64vARB(int program, int location, int count, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetNamedProgramStringEXT(int program, int target, int pname, MemorySegment string) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glNamedProgramLocalParameter4dEXT(int program, int target, int index, double x, double y, double z, double w) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glEndPerfQueryINTEL(int queryHandle) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public byte glAcquireKeyedMutexWin32EXT(int memory, long key, int timeout) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetMultiTexParameterfvEXT(int texunit, int target, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniformMatrix2x4fvEXT(int program, int location, int count, byte transpose, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribDivisorANGLE(int index, int divisor) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public byte glIsRenderbufferOES(int renderbuffer) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribs4ubvNV(int index, int count, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetClipPlanexOES(int plane, MemorySegment equation) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniformui64NV(int location, long value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTextureParameterivEXT(int texture, int target, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniform3uiv(int program, int location, int count, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniformMatrix4x3fvNV(int location, int count, byte transpose, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttrib3sv(int index, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glColorSubTable(int target, int start, int count, int format, int type, MemorySegment data) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public byte glAreTexturesResidentEXT(int n, MemorySegment textures, MemorySegment residences) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glScalexOES(int x, int y, int z) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetConvolutionParameteriv(int target, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public byte glTestFenceAPPLE(int fence) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexSubImage2DEXT(int texunit, int target, int level, int xoffset, int yoffset, int width, int height, int format, int type, MemorySegment pixels) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetConvolutionParameterfv(int target, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glClampColor(int target, int clamp) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glCompressedTextureImage2DEXT(int texture, int target, int level, int internalformat, int width, int height, int border, int imageSize, MemorySegment bits) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttrib2dARB(int index, double x, double y) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetProgramStringARB(int target, int pname, MemorySegment string) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glArrayElementEXT(int i) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexPointerListIBM(int size, int type, int stride, MemorySegment pointer, int ptrstride) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glImageTransformParameteriHP(int target, int pname, int param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetProgramNamedParameterdvNV(int id, int len, MemorySegment name, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniform1iv(int program, int location, int count, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glSamplerParameterIuivOES(int sampler, int pname, MemorySegment param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMulticastCopyImageSubDataNV(int srcGpu, int dstGpuMask, int srcName, int srcTarget, int srcLevel, int srcX, int srcY, int srcZ, int dstName, int dstTarget, int dstLevel, int dstX, int dstY, int dstZ, int srcWidth, int srcHeight, int srcDepth) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBlendFunciEXT(int buf, int src, int dst) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetMultiTexEnvfvEXT(int texunit, int target, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDisableiEXT(int target, int index) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFrustumxOES(int l, int r, int b, int t, int n, int f) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetFixedv(int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glCreateFramebuffers(int n, MemorySegment framebuffers) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetAttachedObjectsARB(MemorySegment containerObj, int maxCount, MemorySegment count, MemorySegment obj) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexCoord2hvNV(MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTangent3fvEXT(MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glInsertEventMarkerEXT(int length, MemorySegment marker) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBindSampler(int unit, int sampler) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttrib4NuivARB(int index, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetCompressedTextureSubImage(int texture, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int bufSize, MemorySegment pixels) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetObjectPtrLabelKHR(MemorySegment ptr, int bufSize, MemorySegment length, MemorySegment label) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttrib3fARB(int index, float x, float y, float z) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDeleteProgram(int program) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMulticastGetQueryObjectivNV(int gpu, int id, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniform1dvEXT(int program, int location, int count, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public long glGetImageHandleNV(int texture, int level, byte layered, int layer, int format) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGenVertexArraysOES(int n, MemorySegment arrays) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glClearColorxOES(int red, int green, int blue, int alpha) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glNamedFramebufferTexture2DEXT(int framebuffer, int attachment, int textarget, int texture, int level) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexCoord4ivARB(int target, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glExtractComponentEXT(int res, int src, int num) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFramebufferTextureLayerARB(int target, int attachment, int texture, int level, int layer) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetTextureParameterIiv(int texture, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribP3uiv(int index, int type, byte normalized, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTransformFeedbackVaryingsEXT(int program, int count, MemorySegment varyings, int bufferMode) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribI2uiEXT(int index, int x, int y) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public int glGetFragDataLocation(int program, MemorySegment name) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glSecondaryColor3ubvEXT(MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFlushVertexArrayRangeNV() {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexGenivEXT(int texunit, int coord, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glReleaseShaderCompiler() {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glCallCommandListNV(int list) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttrib1hvNV(int index, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glColor4ubVertex3fvSUN(MemorySegment c, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glEnableiNV(int target, int index) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexCoord4hNV(int target, short s, short t, short r, short q) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttrib4sARB(int index, short x, short y, short z, short w) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public int glGetCommandHeaderNV(int tokenID, int size) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetnUniformivKHR(int program, int location, int bufSize, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public byte glUnmapBufferARB(int target) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public byte glUnmapNamedBufferEXT(int buffer) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetNamedProgramLocalParameterdvEXT(int program, int target, int index, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribL3i64NV(int index, long x, long y, long z) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDeleteSemaphoresEXT(int n, MemorySegment semaphores) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetBufferParameterivARB(int target, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttrib1svNV(int index, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexCoord2f(int target, float s, float t) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexCoord2d(int target, double s, double t) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexCoord2i(int target, int s, int t) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glReadnPixelsKHR(int x, int y, int width, int height, int format, int type, int bufSize, MemorySegment data) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribI3iv(int index, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniformMatrix4x3dv(int location, int count, byte transpose, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexCoord1s(int target, short s) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDrawTransformFeedbackInstancedEXT(int mode, int id, int instancecount) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glNormalPointervINTEL(int type, MemorySegment pointer) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniformMatrix3x4fvNV(int location, int count, byte transpose, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetPathParameterfvNV(int path, int pname, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public MemorySegment glFenceSyncAPPLE(int condition, int flags) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniform2i64NV(int location, long x, long y) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public byte glIsShader(int shader) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexCoord1f(int target, float s) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBlendFunci(int buf, int src, int dst) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexCoord1d(int target, double s) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexCoord1i(int target, int s) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glClipPlanexIMG(int p, MemorySegment eqn) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniform4fvARB(int location, int count, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetProgramParameterdvNV(int target, int index, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glPointSizex(int size) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetInternalformati64v(int target, int internalformat, int pname, int count, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetNamedBufferParameteriv(int buffer, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public int glPathGlyphIndexArrayNV(int firstPathName, int fontTarget, MemorySegment fontName, int fontStyle, int firstGlyphIndex, int numGlyphs, int pathParameterTemplate, float emScale) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetVariantIntegervEXT(int id, int value, MemorySegment data) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniform4ui64vNV(int location, int count, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glSecondaryColor3uiv(MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFinishFenceAPPLE(int fence) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniformMatrix4x3fv(int location, int count, byte transpose, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glConvolutionFilter2DEXT(int target, int internalformat, int width, int height, int format, int type, MemorySegment image) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexBindingDivisor(int bindingindex, int divisor) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDrawBuffersARB(int n, MemorySegment bufs) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexCoord4iARB(int target, int s, int t, int r, int q) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDebugMessageCallbackKHR(MemorySegment callback, MemorySegment userParam) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniform4i64vNV(int program, int location, int count, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGenTransformFeedbacks(int n, MemorySegment ids) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttrib2dNV(int index, double x, double y) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glSecondaryColorFormatNV(int size, int type, int stride) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glSetFragmentShaderConstantATI(int dst, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMakeBufferResidentNV(int target, int access) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glEGLImageTargetTextureStorageEXT(int texture, int image, int attrib_list) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttrib3fv(int index, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetPixelMapxv(int map, int size, MemorySegment values) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribI4usvEXT(int index, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDisableiNV(int target, int index) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public byte glVDPAUIsSurfaceNV(int surface) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBlendEquationSeparate(int modeRGB, int modeAlpha) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetTextureLevelParameterfvEXT(int texture, int target, int level, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glImageTransformParameterivHP(int target, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glColorFormatNV(int size, int type, int stride) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetUniformuiv(int program, int location, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertex3bOES(byte x, byte y, byte z) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniform4fEXT(int program, int location, float v0, float v1, float v2, float v3) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexCoord1sv(int target, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTransformFeedbackVaryingsNV(int program, int count, MemorySegment locations, int bufferMode) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glSecondaryColor3ubv(MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glSeparableFilter2D(int target, int internalformat, int width, int height, int format, int type, MemorySegment row, MemorySegment column) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDeleteVertexArraysAPPLE(int n, MemorySegment arrays) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetPathMetricsNV(int metricQueryMask, int numPaths, int pathNameType, MemorySegment paths, int pathBase, int stride, MemorySegment metrics) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniform3dEXT(int program, int location, double x, double y, double z) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniformMatrix4x3fv(int program, int location, int count, byte transpose, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexCoord4s(int target, short s, short t, short r, short q) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDisableClientStateIndexedEXT(int array, int index) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetMultiTexLevelParameterivEXT(int texunit, int target, int level, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexCoord4x(int texture, int s, int t, int r, int q) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glPathGlyphsNV(int firstPathName, int fontTarget, MemorySegment fontName, int fontStyle, int numGlyphs, int type, MemorySegment charcodes, int handleMissingGlyphs, int pathParameterTemplate, float emScale) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertex3xOES(int x, int y) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glNamedFramebufferDrawBuffers(int framebuffer, int n, MemorySegment bufs) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribI4iEXT(int index, int x, int y, int z, int w) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiDrawElementsIndirectBindlessCountNV(int mode, int type, MemorySegment indirect, int drawCount, int maxDrawCount, int stride, int vertexBufferCount) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public MemorySegment glCreateProgramObjectARB() {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBindBufferARB(int target, int buffer) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexCoord4d(int target, double s, double t, double r, double q) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTextureParameterfEXT(int texture, int target, int pname, float param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttrib3dv(int index, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexCoord4i(int target, int s, int t, int r, int q) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDrawElementsBaseVertex(int mode, int count, int type, MemorySegment indices, int basevertex) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexCoord4f(int target, float s, float t, float r, float q) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribL4dv(int index, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniform4fARB(int location, float v0, float v1, float v2, float v3) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glWindowPos2ivMESA(MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexCoord3s(int target, short s, short t, short r) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFlushMappedBufferRangeEXT(int target, long offset, long length) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetnPixelMapfv(int map, int bufSize, MemorySegment values) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetFogFuncSGIS(MemorySegment points) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniform1ui(int program, int location, int v0) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniform3ivARB(int location, int count, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexCoord3d(int target, double s, double t, double r) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDiscardFramebufferEXT(int target, int numAttachments, MemorySegment attachments) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexCoord3f(int target, float s, float t, float r) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniformMatrix4x3dv(int program, int location, int count, byte transpose, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertex3xvOES(MemorySegment coords) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexCoord3i(int target, int s, int t, int r) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public MemorySegment glCreateShaderObjectARB(int shaderType) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexCoord2s(int target, short s, short t) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMapVertexAttrib2fAPPLE(int index, int size, float u1, float u2, int ustride, int uorder, float v1, float v2, int vstride, int vorder, MemorySegment points) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glCullParameterdvEXT(int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexStream2sATI(int stream, short x, short y) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttrib4dv(int index, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glListParameterivSGIX(int list, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glRenderbufferStorage(int target, int internalformat, int width, int height) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetHistogramParameteriv(int target, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexArrayBindVertexBufferEXT(int vaobj, int bindingindex, int buffer, long offset, int stride) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glWindowPos4ivMESA(MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexCoord2iv(int target, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTextureStorageMem2DEXT(int texture, int levels, int internalFormat, int width, int height, int memory, long offset) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetListParameterfvSGIX(int list, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glPathStencilFuncNV(int func, int ref, int mask) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glAlphaFragmentOp3ATI(int op, int dst, int dstMod, int arg1, int arg1Rep, int arg1Mod, int arg2, int arg2Rep, int arg2Mod, int arg3, int arg3Rep, int arg3Mod) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniformHandleui64IMG(int program, int location, long value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glSampleCoveragex(int value, byte invert) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetInvariantBooleanvEXT(int id, int value, MemorySegment data) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetMultiTexParameterIuivEXT(int texunit, int target, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetInteger64v(int pname, MemorySegment data) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glSamplerParameterIivOES(int sampler, int pname, MemorySegment param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetTexParameterIuivEXT(int target, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glWindowPos2fv(MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glAlphaFuncQCOM(int func, float ref) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public int glFinishAsyncSGIX(MemorySegment markerp) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetSynciv(MemorySegment sync, int pname, int count, MemorySegment length, MemorySegment values) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glWindowPos3fMESA(float x, float y, float z) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexArraySecondaryColorOffsetEXT(int vaobj, int buffer, int size, int type, int stride, long offset) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttrib4bv(int index, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramParameter4dvNV(int target, int index, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramNamedParameter4dNV(int id, int len, MemorySegment name, double x, double y, double z, double w) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexEnviEXT(int texunit, int target, int pname, int param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttrib4sNV(int index, short x, short y, short z, short w) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glConservativeRasterParameterfNV(int pname, float value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBindImageTextureEXT(int index, int texture, int level, byte layered, int layer, int access, int format) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexStream1fATI(int stream, float x) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glExtGetProgramBinarySourceQCOM(int program, int shadertype, MemorySegment source, MemorySegment length) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glImportSemaphoreFdEXT(int semaphore, int handleType, int fd) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetHistogramParameterfv(int target, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGenBuffers(int n, MemorySegment buffers) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiDrawArraysIndirectBindlessNV(int mode, MemorySegment indirect, int drawCount, int stride, int vertexBufferCount) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMulticastGetQueryObjectuivNV(int gpu, int id, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glNamedRenderbufferStorageEXT(int renderbuffer, int internalformat, int width, int height) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glReplacementCodeuiTexCoord2fColor4fNormal3fVertex3fSUN(int rc, float s, float t, float r, float g, float b, float a, float nx, float ny, float nz, float x, float y, float z) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttrib3dvNV(int index, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glWindowPos2dv(MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniform3ui64ARB(int program, int location, long x, long y, long z) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribIFormatNV(int index, int size, int type, int stride) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glCurrentPaletteMatrixOES(int matrixpaletteindex) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFramebufferTextureOES(int target, int attachment, int texture, int level) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexCoord4xvOES(int texture, MemorySegment coords) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public int glCreateShaderProgramv(int type, int count, MemorySegment strings) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetnSeparableFilterARB(int target, int format, int type, int rowBufSize, MemorySegment row, int columnBufSize, MemorySegment column, MemorySegment span) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniformMatrix4fv(int program, int location, int count, byte transpose, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetTransformFeedbackVarying(int program, int index, int bufSize, MemorySegment length, MemorySegment size, MemorySegment type, MemorySegment name) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttrib4fvNV(int index, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glSubpixelPrecisionBiasNV(int xbits, int ybits) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDrawBuffersATI(int n, MemorySegment bufs) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFogxv(int pname, MemorySegment param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniform2uiEXT(int program, int location, int v0, int v1) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribLFormat(int attribindex, int size, int type, int relativeoffset) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDisableIndexedEXT(int target, int index) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public int glGetDebugMessageLogKHR(int count, int bufSize, MemorySegment sources, MemorySegment types, MemorySegment ids, MemorySegment severities, MemorySegment lengths, MemorySegment messageLog) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttrib4dvARB(int index, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexImage4DSGIS(int target, int level, int internalformat, int width, int height, int depth, int size4d, int border, int format, int type, MemorySegment pixels) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniformMatrix4dv(int program, int location, int count, byte transpose, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDeleteTexturesEXT(int n, MemorySegment textures) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glNamedFramebufferReadBuffer(int framebuffer, int src) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetVideoCaptureivNV(int video_capture_slot, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glNormalStream3dvATI(int stream, MemorySegment coords) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTangent3bvEXT(MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glWindowPos2iv(MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexArrayAttribLFormat(int vaobj, int attribindex, int size, int type, int relativeoffset) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexSubImage1DEXT(int target, int level, int xoffset, int width, int format, int type, MemorySegment pixels) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetProgramSubroutineParameteruivNV(int target, int index, MemorySegment param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTessellationFactorAMD(float factor) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDrawTexfvOES(MemorySegment coords) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBlendBarrierKHR() {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDrawVkImageNV(long vkImage, int sampler, float x0, float y0, float x1, float y1, float z, float s0, float t0, float s1, float t1) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetMinmaxParameterfv(int target, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribI3ui(int index, int x, int y, int z) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glWindowPos3fvMESA(MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMulticastGetQueryObjectui64vNV(int gpu, int id, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTextureBufferRangeEXT(int texture, int target, int internalformat, int buffer, long offset, long size) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramBinaryOES(int program, int binaryFormat, MemorySegment binary, int length) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetLightxOES(int light, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glEndConditionalRenderNV() {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glPatchParameteri(int pname, int value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiDrawElementsIndirectBindlessNV(int mode, int type, MemorySegment indirect, int drawCount, int stride, int vertexBufferCount) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDeleteBuffersARB(int n, MemorySegment buffers) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribL3ui64vNV(int index, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetArrayObjectivATI(int array, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBlendBarrierNV() {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glNormalStream3svATI(int stream, MemorySegment coords) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTangent3dEXT(double tx, double ty, double tz) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetMinmaxParameteriv(int target, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVariantusvEXT(int id, MemorySegment addr) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glLightxOES(int light, int pname, int param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDepthBoundsEXT(double zmin, double zmax) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniform3uivEXT(int program, int location, int count, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetVertexArrayPointervEXT(int vaobj, int pname, MemorySegment param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexPageCommitmentARB(int target, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, byte commit) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glCompileShaderARB(MemorySegment shaderObj) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBinormal3sEXT(short bx, short by, short bz) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBeginVideoCaptureNV(int video_capture_slot) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glCompressedMultiTexImage1DEXT(int texunit, int target, int level, int internalformat, int width, int border, int imageSize, MemorySegment bits) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glClearNamedBufferSubDataEXT(int buffer, int internalformat, long offset, long size, int format, int type, MemorySegment data) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetInvariantIntegervEXT(int id, int value, MemorySegment data) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glCreateSemaphoresNV(int n, MemorySegment semaphores) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexCoord1bOES(int texture, byte s) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glConvolutionParameterxvOES(int target, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public byte glIsTransformFeedbackNV(int id) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glRectxOES(int x1, int y1, int x2, int y2) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glNormal3fVertex3fvSUN(MemorySegment n, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBindRenderbufferEXT(int target, int renderbuffer) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFramebufferTextureFaceEXT(int target, int attachment, int texture, int level, int face) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetMaterialxOES(int face, int pname, int param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexCoord1xOES(int texture, int s) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glViewportIndexedfv(int index, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDrawArraysInstancedARB(int mode, int first, int count, int primcount) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramParameters4dvNV(int target, int index, int count, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBlendEquationSeparatei(int buf, int modeRGB, int modeAlpha) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetNamedBufferSubData(int buffer, long offset, long size, MemorySegment data) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTransformFeedbackStreamAttribsNV(int count, MemorySegment attribs, int nbuffers, MemorySegment bufstreams, int bufferMode) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniformMatrix2fvEXT(int program, int location, int count, byte transpose, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glPushGroupMarkerEXT(int length, MemorySegment marker) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFramebufferFetchBarrierQCOM() {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glPixelTexGenParameterfSGIS(int pname, float param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramEnvParameter4dvARB(int target, int index, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetnMapdvARB(int target, int query, int bufSize, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTangentPointerEXT(int type, int stride, MemorySegment pointer) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniform1fv(int program, int location, int count, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMatrixMultdEXT(int mode, MemorySegment m) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDrawArraysInstancedANGLE(int mode, int first, int count, int primcount) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glNamedProgramLocalParameter4dvEXT(int program, int target, int index, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glCompressedTexImage3DARB(int target, int level, int internalformat, int width, int height, int depth, int border, int imageSize, MemorySegment data) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexCoord2dv(int target, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glStencilStrokePathInstancedNV(int numPaths, int pathNameType, MemorySegment paths, int pathBase, int reference, int mask, int transformType, MemorySegment transformValues) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetVertexArrayPointeri_vEXT(int vaobj, int index, int pname, MemorySegment param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glNormal3hNV(short nx, short ny, short nz) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glPopGroupMarkerEXT() {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public int glGetProgramResourceLocation(int program, int programInterface, MemorySegment name) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexCoord2dvARB(int target, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glWindowPos2ivARB(MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetHistogram(int target, byte reset, int format, int type, MemorySegment values) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribL2dEXT(int index, double x, double y) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBlendFunciOES(int buf, int src, int dst) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniform1dv(int program, int location, int count, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertex3hNV(short x, short y, short z) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glRasterPos3xOES(int x, int y, int z) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetHistogramParameterxvOES(int target, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexCoord2fv(int target, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniform4ui64NV(int program, int location, long x, long y, long z, long w) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexArrayVertexAttribLFormatEXT(int vaobj, int attribindex, int size, int type, int relativeoffset) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glLockArraysEXT(int first, int count) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glEdgeFlagPointerEXT(int stride, int count, MemorySegment pointer) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glEndQueryARB(int target) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glNamedFramebufferTextureFaceEXT(int framebuffer, int attachment, int texture, int level, int face) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribPointerARB(int index, int size, int type, byte normalized, int stride, MemorySegment pointer) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glSecondaryColor3svEXT(MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFogxvOES(int pname, MemorySegment param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDrawRangeElementsBaseVertex(int mode, int start, int end, int count, int type, MemorySegment indices, int basevertex) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public int glGetGraphicsResetStatusEXT() {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBeginTransformFeedback(int primitiveMode) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glObjectPtrLabel(MemorySegment ptr, int length, MemorySegment label) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUploadGpuMaskNVX(int mask) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetFinalCombinerInputParameterfvNV(int variable, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUnlockArraysEXT() {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetTexParameterIiv(int target, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexArrayMultiTexCoordOffsetEXT(int vaobj, int buffer, int texunit, int size, int type, int stride, long offset) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexCoord1hNV(int target, short s) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttrib4Nub(int index, byte x, byte y, byte z, byte w) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramLocalParameterI4ivNV(int target, int index, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glSetInvariantEXT(int id, int type, MemorySegment addr) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public byte glIsQuery(int id) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFogCoordPointerEXT(int type, int stride, MemorySegment pointer) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramBufferParametersfvNV(int target, int bindingIndex, int wordIndex, int count, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glCombinerParameterivNV(int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetnUniformfv(int program, int location, int bufSize, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glPathParameterfNV(int path, int pname, float value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttrib4Nsv(int index, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniform4i64vARB(int program, int location, int count, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMakeNamedBufferResidentNV(int buffer, int access) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glInvalidateNamedFramebufferSubData(int framebuffer, int numAttachments, MemorySegment attachments, int x, int y, int width, int height) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glColorPointerListIBM(int size, int type, int stride, MemorySegment pointer, int ptrstride) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public byte glIsCommandListNV(int list) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glEdgeFlagFormatNV(int stride) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetColorTableParameterfvSGI(int target, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetTransformFeedbacki_v(int xfb, int pname, int index, MemorySegment param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glScissorArrayv(int first, int count, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glStartInstrumentsSGIX() {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glReplacementCodeubvSUN(MemorySegment code) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexCoord2svARB(int target, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiDrawElementsIndirectCount(int mode, int type, MemorySegment indirect, long drawcount, int maxdrawcount, int stride) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glNormalStream3sATI(int stream, short nx, short ny, short nz) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMatrixIndexubvARB(int size, MemorySegment indices) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGenerateTextureMipmapEXT(int texture, int target) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDebugMessageEnableAMD(int category, int severity, int count, MemorySegment ids, byte enabled) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glPointParameterfvSGIS(int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glIndexxOES(int component) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public int glGetUniformLocation(int program, MemorySegment name) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glPrimitiveBoundingBox(float minX, float minY, float minZ, float minW, float maxX, float maxY, float maxZ, float maxW) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glCopyTexSubImage1DEXT(int target, int level, int xoffset, int x, int y, int width) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexStream4dATI(int stream, double x, double y, double z, double w) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glSpriteParameterfvSGIX(int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGlobalAlphaFactoriSUN(int factor) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glConvolutionParameterxOES(int target, int pname, int param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexCoord3xvOES(int texture, MemorySegment coords) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBlendParameteriNV(int pname, int value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetMultisamplefv(int pname, int index, MemorySegment val) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public byte glIsQueryARB(int id) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetInternalformativ(int target, int internalformat, int pname, int count, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDepthRangeArrayfvNV(int first, int count, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBufferSubData(int target, long offset, long size, MemorySegment data) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glRenderbufferStorageMultisampleNV(int target, int samples, int internalformat, int width, int height) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetSyncivAPPLE(MemorySegment sync, int pname, int count, MemorySegment length, MemorySegment values) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttrib4ubvNV(int index, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public int glBindTextureUnitParameterEXT(int unit, int value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexWeightfvEXT(MemorySegment weight) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTextureParameteriEXT(int texture, int target, int pname, int param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public int glCreateShaderProgramEXT(int type, MemorySegment string) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glClearDepthf(float d) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTextureImage2DMultisampleNV(int texture, int target, int samples, int internalFormat, int width, int height, byte fixedSampleLocations) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDisableVertexAttribArray(int index) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetDoubleIndexedvEXT(int target, int index, MemorySegment data) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniform4iEXT(int program, int location, int v0, int v1, int v2, int v3) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glClearDepthx(int depth) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTextureBarrier() {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glNamedStringARB(int type, int namelen, MemorySegment name, int stringlen, MemorySegment string) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexCoord1xvOES(MemorySegment coords) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetUniformfvARB(MemorySegment programObj, int location, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexCoordPointervINTEL(int size, int type, MemorySegment pointer) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexArrayVertexAttribFormatEXT(int vaobj, int attribindex, int size, int type, byte normalized, int relativeoffset) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexCoord2fColor3fVertex3fvSUN(MemorySegment tc, MemorySegment c, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetVariantArrayObjectfvATI(int id, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniform4fvEXT(int program, int location, int count, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniform2i64vNV(int program, int location, int count, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexCoordP4ui(int texture, int type, int coords) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetnUniformdv(int program, int location, int bufSize, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glInvalidateTexImage(int texture, int level) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public byte glIsRenderbufferEXT(int renderbuffer) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniform3uiEXT(int program, int location, int v0, int v1, int v2) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDeleteNamedStringARB(int namelen, MemorySegment name) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glReplacementCodeuiTexCoord2fNormal3fVertex3fvSUN(MemorySegment rc, MemorySegment tc, MemorySegment n, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBindTextures(int first, int count, MemorySegment textures) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glEndQuery(int target) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glNamedFramebufferSampleLocationsfvNV(int framebuffer, int start, int count, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniform1i64vARB(int program, int location, int count, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBlitFramebuffer(int srcX0, int srcY0, int srcX1, int srcY1, int dstX0, int dstY0, int dstX1, int dstY1, int mask, int filter) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glStencilThenCoverFillPathInstancedNV(int numPaths, int pathNameType, MemorySegment paths, int pathBase, int fillMode, int mask, int coverMode, int transformType, MemorySegment transformValues) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniformSubroutinesuiv(int shadertype, int count, MemorySegment indices) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glIndexPointerListIBM(int type, int stride, MemorySegment pointer, int ptrstride) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexStream4dvATI(int stream, MemorySegment coords) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniform3ui64ARB(int location, long x, long y, long z) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexArrayVertexAttribLOffsetEXT(int vaobj, int buffer, int index, int size, int type, int stride, long offset) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glValidateProgramARB(MemorySegment programObj) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBeginVertexShaderEXT() {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBlendFuncSeparateIndexedAMD(int buf, int srcRGB, int dstRGB, int srcAlpha, int dstAlpha) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetnTexImageARB(int target, int level, int format, int type, int bufSize, MemorySegment img) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexCoord1hNV(short s) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public int glGetAttribLocationARB(MemorySegment programObj, MemorySegment name) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMemoryBarrierEXT(int barriers) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetNamedBufferSubDataEXT(int buffer, long offset, long size, MemorySegment data) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glEnableClientStateIndexedEXT(int array, int index) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glScissorIndexedv(int index, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glWindowPos2fvARB(MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glCoverageModulationTableNV(int n, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexStorageMem1DEXT(int target, int levels, int internalFormat, int width, int memory, long offset) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFramebufferShadingRateEXT(int target, int attachment, int texture, int baseLayer, int numLayers, int texelWidth, int texelHeight) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttrib3fNV(int index, float x, float y, float z) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glWindowPos4svMESA(MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexCoordP2uiv(int texture, int type, MemorySegment coords) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glCompressedTextureSubImage2DEXT(int texture, int target, int level, int xoffset, int yoffset, int width, int height, int format, int imageSize, MemorySegment bits) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTextureStorage3DMultisample(int texture, int samples, int internalformat, int width, int height, int depth, byte fixedsamplelocations) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribDivisorARB(int index, int divisor) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glShadingRateImagePaletteNV(int viewport, int first, int count, MemorySegment rates) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTextureStorage2DEXT(int texture, int target, int levels, int internalformat, int width, int height) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glObjectPtrLabelKHR(MemorySegment ptr, int length, MemorySegment label) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public byte glIsImageHandleResidentARB(long handle) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glPresentFrameKeyedNV(int video_slot, long minPresentTime, int beginPresentTimeId, int presentDurationId, int type, int target0, int fill0, int key0, int target1, int fill1, int key1) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glLoadTransposeMatrixfARB(MemorySegment m) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetNamedBufferParameterivEXT(int buffer, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiDrawArraysIndirectCountARB(int mode, MemorySegment indirect, long drawcount, int maxdrawcount, int stride) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDisableiOES(int target, int index) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexCoord1fARB(int target, float s) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glScissorArrayvNV(int first, int count, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glWeightivARB(int size, MemorySegment weights) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetNamedBufferParameterui64vNV(int buffer, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTextureImage2DEXT(int texture, int target, int level, int internalformat, int width, int height, int border, int format, int type, MemorySegment pixels) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public int glCheckFramebufferStatusEXT(int target) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBeginConditionalRender(int id, int mode) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBlendEquation(int mode) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGenerateMipmap(int target) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribDivisor(int index, int divisor) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexStorage2DMultisample(int target, int samples, int internalformat, int width, int height, byte fixedsamplelocations) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetVertexArrayIndexediv(int vaobj, int index, int pname, MemorySegment param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexStream1iATI(int stream, int x) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetUniformui64vNV(int program, int location, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glPathParameterivNV(int path, int pname, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniformMatrix4x2dv(int location, int count, byte transpose, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetPerfCounterInfoINTEL(int queryId, int counterId, int counterNameLength, MemorySegment counterName, int counterDescLength, MemorySegment counterDesc, MemorySegment counterOffset, MemorySegment counterDataSize, MemorySegment counterTypeEnum, MemorySegment counterDataTypeEnum, MemorySegment rawCounterMaxValue) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public MemorySegment glGetHandleARB(int pname) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetSeparableFilterEXT(int target, int format, int type, MemorySegment row, MemorySegment column, MemorySegment span) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMapObjectBufferATI(int buffer) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramPathFragmentInputGenNV(int program, int location, int genMode, int components, MemorySegment coeffs) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glLineWidthxOES(int width) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexCoordP2uiv(int type, MemorySegment coords) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiDrawElementArrayAPPLE(int mode, MemorySegment first, MemorySegment count, int primcount) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttrib2fv(int index, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glValidateProgramPipelineEXT(int pipeline) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glSecondaryColorPointerEXT(int size, int type, int stride, MemorySegment pointer) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttrib4usvARB(int index, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glWindowPos4fMESA(float x, float y, float z, float w) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glSamplerParameterIivEXT(int sampler, int pname, MemorySegment param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetProgramLocalParameterfvARB(int target, int index, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetVertexAttribivARB(int index, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glExtGetRenderbuffersQCOM(MemorySegment renderbuffers, int maxRenderbuffers, MemorySegment numRenderbuffers) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttrib2dv(int index, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribL3dv(int index, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniformMatrix4x2fv(int location, int count, byte transpose, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexCoord2sARB(int target, short s, short t) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetActiveVaryingNV(int program, int index, int bufSize, MemorySegment length, MemorySegment size, MemorySegment type, MemorySegment name) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiDrawArrays(int mode, MemorySegment first, MemorySegment count, int drawcount) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glRotatex(int angle, int x, int y, int z) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public int glGetAttribLocation(int program, MemorySegment name) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexArrayTexCoordOffsetEXT(int vaobj, int buffer, int size, int type, int stride, long offset) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribs1dvNV(int index, int count, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glWindowPos2sv(MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public int glCreateShader(int type) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniformMatrix4x2dv(int program, int location, int count, byte transpose, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexCoord1bOES(byte s) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexGenfvOES(int coord, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiDrawArraysIndirect(int mode, MemorySegment indirect, int drawcount, int stride) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDeleteProgramsARB(int n, MemorySegment programs) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMatrixIndexPointerOES(int size, int type, int stride, MemorySegment pointer) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramLocalParameter4fARB(int target, int index, float x, float y, float z, float w) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniformMatrix2dv(int location, int count, byte transpose, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMapParameterfvNV(int target, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public byte glIsNameAMD(int identifier, int name) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultTransposeMatrixxOES(MemorySegment m) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glWindowPos2i(int x, int y) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribI2iv(int index, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glWindowPos2f(float x, float y) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glWindowPos2d(double x, double y) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetNamedFramebufferParameteriv(int framebuffer, int pname, MemorySegment param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiDrawArraysIndirectAMD(int mode, MemorySegment indirect, int primcount, int stride) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glCopyConvolutionFilter1DEXT(int target, int internalformat, int x, int y, int width) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexParameterxOES(int target, int pname, int param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetTrackMatrixivNV(int target, int address, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glWindowPos3s(short x, short y, short z) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetActiveAttrib(int program, int index, int bufSize, MemorySegment length, MemorySegment size, MemorySegment type, MemorySegment name) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniformMatrix4dvEXT(int program, int location, int count, byte transpose, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glClearColorIiEXT(int red, int green, int blue, int alpha) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glWindowPos3i(int x, int y, int z) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glWindowPos3f(float x, float y, float z) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glColor3hNV(short red, short green, short blue) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glWindowPos3d(double x, double y, double z) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBlitFramebufferANGLE(int srcX0, int srcY0, int srcX1, int srcY1, int dstX0, int dstY0, int dstX1, int dstY1, int mask, int filter) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetTexParameterIuivOES(int target, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMatrixTranslatefEXT(int mode, float x, float y, float z) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniformMatrix2fv(int location, int count, byte transpose, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexCoord1dvARB(int target, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glQueryCounter(int id, int target) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glColorTableSGI(int target, int internalformat, int width, int format, int type, MemorySegment table) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetVertexAttribIiv(int index, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glCopyMultiTexImage1DEXT(int texunit, int target, int level, int internalformat, int x, int y, int width, int border) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glColorPointerEXT(int size, int type, int stride, int count, MemorySegment pointer) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glPointParameterfvEXT(int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexCoord1xOES(int s) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glWindowPos2s(short x, short y) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniformui64NV(int program, int location, long value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glShaderSource(int shader, int count, MemorySegment string, MemorySegment length) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBindBufferRangeNV(int target, int index, int buffer, long offset, long size) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glClearNamedFramebufferfv(int framebuffer, int buffer, int drawbuffer, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDrawTextureNV(int texture, int sampler, float x0, float y0, float x1, float y1, float z, float s0, float t0, float s1, float t1) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFramebufferFoveationParametersQCOM(int framebuffer, int layer, int focalPoint, float focalX, float focalY, float gainX, float gainY, float foveaArea) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBindVideoCaptureStreamBufferNV(int video_capture_slot, int stream, int frame_region, long offset) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTextureStorage2D(int texture, int levels, int internalformat, int width, int height) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexStorageMem2DMultisampleEXT(int target, int samples, int internalFormat, int width, int height, byte fixedSampleLocations, int memory, long offset) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFlushStaticDataIBM(int target) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTangent3ivEXT(MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glWindowPos3iv(MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetProgramStringNV(int id, int pname, MemorySegment program) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetQueryObjectuivEXT(int id, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttrib4f(int index, float x, float y, float z, float w) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTextureStorage1D(int texture, int levels, int internalformat, int width) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttrib4d(int index, double x, double y, double z, double w) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetVertexAttribdv(int index, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glEvaluateDepthValuesARB() {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTextureViewEXT(int texture, int target, int origtexture, int internalformat, int minlevel, int numlevels, int minlayer, int numlayers) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glPathParameterfvNV(int path, int pname, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBindFragDataLocationEXT(int program, int color, MemorySegment name) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttrib4s(int index, short x, short y, short z, short w) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBeginTransformFeedbackEXT(int primitiveMode) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glSetFenceAPPLE(int fence) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFreeObjectBufferATI(int buffer) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBlendColorEXT(float red, float green, float blue, float alpha) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public byte glIsImageHandleResidentNV(long handle) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexP3uiv(int type, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFramebufferTextureEXT(int target, int attachment, int texture, int level) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniform3fvARB(int location, int count, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexCoord1iv(int target, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glColorFragmentOp3ATI(int op, int dst, int dstMask, int dstMod, int arg1, int arg1Rep, int arg1Mod, int arg2, int arg2Rep, int arg2Mod, int arg3, int arg3Rep, int arg3Mod) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramBufferParametersIivNV(int target, int bindingIndex, int wordIndex, int count, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBlendColor(float red, float green, float blue, float alpha) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glStencilThenCoverStrokePathNV(int path, int reference, int mask, int coverMode) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribL4dvEXT(int index, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDebugMessageInsertKHR(int source, int type, int id, int severity, int length, MemorySegment buf) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public byte glReleaseKeyedMutexWin32EXT(int memory, long key) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glSignalSemaphoreui64NVX(int signalGpu, int fenceObjectCount, MemorySegment semaphoreArray, MemorySegment fenceValueArray) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetCompressedTexImageARB(int target, int level, MemorySegment img) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribL2ui64NV(int index, long x, long y) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexArrayElementBuffer(int vaobj, int buffer) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glColor4ubVertex2fvSUN(MemorySegment c, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTextureStorage3D(int texture, int levels, int internalformat, int width, int height, int depth) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniformMatrix4x2fv(int program, int location, int count, byte transpose, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniform4uivEXT(int location, int count, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBindMultiTextureEXT(int texunit, int target, int texture) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMapNamedBufferRange(int buffer, long offset, long length, int access) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribs2fvNV(int index, int count, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glWindowPos3fv(MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGlobalAlphaFactoruiSUN(int factor) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glClearNamedFramebufferfi(int framebuffer, int buffer, int drawbuffer, float depth, int stencil) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glNamedRenderbufferStorageMultisample(int renderbuffer, int samples, int internalformat, int width, int height) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetTexParameterIivEXT(int target, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glCombinerParameterfNV(int pname, float param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetVertexAttribfv(int index, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glPointParameterx(int pname, int param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glSampleMaskEXT(float value, byte invert) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glCopyTextureSubImage2DEXT(int texture, int target, int level, int xoffset, int yoffset, int x, int y, int width, int height) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribL4i64vNV(int index, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glResetHistogram(int target) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMaterialxvOES(int face, int pname, MemorySegment param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetFinalCombinerInputParameterivNV(int variable, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glPointParameteri(int pname, int param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glPointParameterf(int pname, float param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDepthRangeArrayv(int first, int count, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetnConvolutionFilterARB(int target, int format, int type, int bufSize, MemorySegment image) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glColor4x(int red, int green, int blue, int alpha) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetVertexAttribIivEXT(int index, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttrib4svARB(int index, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexBufferARB(int target, int internalformat, int buffer) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTextureStorage2DMultisampleEXT(int texture, int target, int samples, int internalformat, int width, int height, byte fixedsamplelocations) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glReadnPixelsARB(int x, int y, int width, int height, int format, int type, int bufSize, MemorySegment data) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexCoordPointerEXT(int size, int type, int stride, int count, MemorySegment pointer) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFragmentLightModelfSGIX(int pname, float param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMakeTextureHandleResidentNV(long handle) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribI2ui(int index, int x, int y) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glPrimitiveRestartIndex(int index) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glWeightuivARB(int size, MemorySegment weights) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glLightModelxv(int pname, MemorySegment param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexStorageMem3DMultisampleEXT(int target, int samples, int internalFormat, int width, int height, int depth, byte fixedSampleLocations, int memory, long offset) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMapBufferRange(int target, long offset, long length, int access) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribs3hvNV(int index, int n, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public byte glIsFramebuffer(int framebuffer) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetVertexAttribArrayObjectfvATI(int index, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniform2i64vARB(int location, int count, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetShaderSource(int shader, int bufSize, MemorySegment length, MemorySegment source) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribs3svNV(int index, int count, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetVertexAttribiv(int index, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribL2i64vNV(int index, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glCompressedTexSubImage1DARB(int target, int level, int xoffset, int width, int format, int imageSize, MemorySegment data) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glCoverStrokePathInstancedNV(int numPaths, int pathNameType, MemorySegment paths, int pathBase, int coverMode, int transformType, MemorySegment transformValues) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniform2uivEXT(int location, int count, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glClearNamedFramebufferiv(int framebuffer, int buffer, int drawbuffer, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexStorage3DEXT(int target, int levels, int internalformat, int width, int height, int depth) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetProgramBinary(int program, int bufSize, MemorySegment length, MemorySegment binaryFormat, MemorySegment binary) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glRenderbufferStorageMultisampleAdvancedAMD(int target, int samples, int storageSamples, int internalformat, int width, int height) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glWindowPos2svMESA(MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glElementPointerAPPLE(int type, MemorySegment pointer) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetQueryObjectiv(int id, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public byte glIsProgramPipelineEXT(int pipeline) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glColorP4uiv(int type, MemorySegment color) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBindTransformFeedback(int target, int id) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glPointParameterfEXT(int pname, float param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetPathParameterivNV(int path, int pname, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGenQueryResourceTagNV(int n, MemorySegment tagIds) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glObjectLabel(int identifier, int name, int length, MemorySegment label) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVDPAUGetSurfaceivNV(int surface, int pname, int count, MemorySegment length, MemorySegment values) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUnmapTexture2DINTEL(int texture, int level) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexStream1fvATI(int stream, MemorySegment coords) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public int glGetUniformLocationARB(MemorySegment programObj, MemorySegment name) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDeleteFencesAPPLE(int n, MemorySegment fences) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetTransformFeedbackiv(int xfb, int pname, MemorySegment param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribParameteriAMD(int index, int pname, int param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFragmentCoverageColorNV(int color) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public int glGetProgramResourceLocationIndex(int program, int programInterface, MemorySegment name) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetImageTransformParameterfvHP(int target, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniform1i64NV(int program, int location, long x) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public byte glIsBufferARB(int buffer) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetVertexAttribLui64vNV(int index, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramParameteriARB(int program, int pname, int value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glActiveStencilFaceEXT(int face) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexCoord4dARB(int target, double s, double t, double r, double q) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glLoadTransposeMatrixxOES(MemorySegment m) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexStream4svATI(int stream, MemorySegment coords) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexEnvxvOES(int target, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glNamedProgramLocalParameterI4uiEXT(int program, int target, int index, int x, int y, int z, int w) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFogCoordFormatNV(int type, int stride) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetIntegeri_vEXT(int target, int index, MemorySegment data) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glCreateRenderbuffers(int n, MemorySegment renderbuffers) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetFramebufferParameterivMESA(int target, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetConvolutionParameterfvEXT(int target, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexCoord2fColor4fNormal3fVertex3fvSUN(MemorySegment tc, MemorySegment c, MemorySegment n, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glReadnPixels(int x, int y, int width, int height, int format, int type, int bufSize, MemorySegment data) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glCombinerInputNV(int stage, int portion, int variable, int input, int mapping, int componentUsage) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public int glVDPAURegisterOutputSurfaceNV(MemorySegment vdpSurface, int target, int numTextureNames, MemorySegment textureNames) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexEnvfEXT(int texunit, int target, int pname, float param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public byte glIsProgramPipeline(int pipeline) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public int glPathMemoryGlyphIndexArrayNV(int firstPathName, int fontTarget, long fontSize, MemorySegment fontData, int faceIndex, int firstGlyphIndex, int numGlyphs, int pathParameterTemplate, float emScale) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttrib1d(int index, double x) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glWindowPos2sARB(short x, short y) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glLinkProgramARB(MemorySegment programObj) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniform4ivARB(int location, int count, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttrib1f(int index, float x) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDeleteQueriesEXT(int n, MemorySegment ids) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultTransposeMatrixfARB(MemorySegment m) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttrib1s(int index, short x) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetnUniformuiv(int program, int location, int bufSize, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glCopyImageSubDataOES(int srcName, int srcTarget, int srcLevel, int srcX, int srcY, int srcZ, int dstName, int dstTarget, int dstLevel, int dstX, int dstY, int dstZ, int srcWidth, int srcHeight, int srcDepth) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBindRenderbufferOES(int target, int renderbuffer) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glPassThroughxOES(int token) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGlobalAlphaFactorfSUN(float factor) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexStream2ivATI(int stream, MemorySegment coords) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribL4ui64NV(int index, long x, long y, long z, long w) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glNamedBufferPageCommitmentMemNV(int buffer, long offset, long size, int memory, long memOffset, byte commit) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexCoord3hvNV(int target, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFramebufferDrawBuffersEXT(int framebuffer, int n, MemorySegment bufs) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public int glNewObjectBufferATI(int size, MemorySegment pointer, int usage) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTextureStorage3DMultisampleEXT(int texture, int target, int samples, int internalformat, int width, int height, int depth, byte fixedsamplelocations) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glWindowPos3dv(MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glSecondaryColor3usv(MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetnUniformuivKHR(int program, int location, int bufSize, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertex2xvOES(MemorySegment coords) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttrib3f(int index, float x, float y, float z) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttrib3d(int index, double x, double y, double z) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexCoord2bvOES(int texture, MemorySegment coords) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetProgramEnvParameterfvARB(int target, int index, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMakeImageHandleResidentARB(long handle, int access) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexCoord1dv(int target, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniform1ui64vNV(int location, int count, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMatrixLoadTransposefEXT(int mode, MemorySegment m) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glResolveDepthValuesNV() {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttrib3s(int index, short x, short y, short z) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultTransposeMatrixf(MemorySegment m) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glSecondaryColor3sEXT(short red, short green, short blue) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetVertexAttribLi64vNV(int index, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBlendEquationiOES(int buf, int mode) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttrib2f(int index, float x, float y) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttrib2d(int index, double x, double y) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glCopyImageSubData(int srcName, int srcTarget, int srcLevel, int srcX, int srcY, int srcZ, int dstName, int dstTarget, int dstLevel, int dstX, int dstY, int dstZ, int srcWidth, int srcHeight, int srcDepth) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultTransposeMatrixd(MemorySegment m) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public byte glIsSync(MemorySegment sync) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMatrixRotatedEXT(int mode, double angle, double x, double y, double z) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexCoord4fvARB(int target, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttrib2sv(int index, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiDrawElementsEXT(int mode, MemorySegment count, int type, MemorySegment indices, int primcount) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttrib2s(int index, short x, short y) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMap1xOES(int target, int u1, int u2, int stride, int order, int points) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexCoord1fv(int target, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexCoord4hNV(short s, short t, short r, short q) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public byte glIsFenceNV(int fence) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glLinkProgram(int program) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFramebufferTexture3DOES(int target, int attachment, int textarget, int texture, int level, int zoffset) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexP2ui(int type, int value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetFixedvOES(int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glLoadIdentityDeformationMapSGIX(int mask) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDrawMeshTasksNV(int first, int count) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttrib1fvARB(int index, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glHintPGI(int target, int mode) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBindRenderbuffer(int target, int renderbuffer) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glAlphaFuncxOES(int func, int ref) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribL3dEXT(int index, double x, double y, double z) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexGeniOES(int coord, int pname, int param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUseProgramStages(int pipeline, int stages, int program) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glNamedBufferDataEXT(int buffer, long size, MemorySegment data, int usage) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBufferAttachMemoryNV(int target, int memory, long offset) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniform4ui64ARB(int location, long x, long y, long z, long w) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramSubroutineParametersuivNV(int target, int count, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glSecondaryColorPointerListIBM(int size, int type, int stride, MemorySegment pointer, int ptrstride) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniform3fARB(int location, float v0, float v1, float v2) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniform1fEXT(int program, int location, float v0) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexBlendARB(int count) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGenProgramsNV(int n, MemorySegment programs) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glNamedFramebufferTextureEXT(int framebuffer, int attachment, int texture, int level) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glScissorIndexedNV(int index, int left, int bottom, int width, int height) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribI1uiEXT(int index, int x) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFragmentLightivSGIX(int light, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniformMatrix4fvARB(int location, int count, byte transpose, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexCoord1hvNV(MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetVideoCaptureStreamfvNV(int video_capture_slot, int stream, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMatrixIndexuivARB(int size, MemorySegment indices) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexCoord3bvOES(int texture, MemorySegment coords) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glClearNamedBufferData(int buffer, int internalformat, int format, int type, MemorySegment data) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFramebufferSamplePositionsfvAMD(int target, int numsamples, int pixelindex, MemorySegment values) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glCoverFillPathInstancedNV(int numPaths, int pathNameType, MemorySegment paths, int pathBase, int coverMode, int transformType, MemorySegment transformValues) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTextureParameterIiv(int texture, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetHistogramParameterfvEXT(int target, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetMultiTexLevelParameterfvEXT(int texunit, int target, int level, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGenSemaphoresEXT(int n, MemorySegment semaphores) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glCopyMultiTexSubImage3DEXT(int texunit, int target, int level, int xoffset, int yoffset, int zoffset, int x, int y, int width, int height) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniformMatrix4x2fvNV(int location, int count, byte transpose, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetFragmentShadingRatesEXT(int samples, int maxCount, MemorySegment count, MemorySegment shadingRates) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVariantsvEXT(int id, MemorySegment addr) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBinormal3bEXT(byte bx, byte by, byte bz) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glCompressedMultiTexImage2DEXT(int texunit, int target, int level, int internalformat, int width, int height, int border, int imageSize, MemorySegment bits) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glAsyncMarkerSGIX(int marker) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexSubImage3DEXT(int texunit, int target, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int format, int type, MemorySegment pixels) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public int glGetFragDataIndexEXT(int program, MemorySegment name) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glReplacementCodeuivSUN(MemorySegment code) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMapParameterivNV(int target, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGenVertexArrays(int n, MemorySegment arrays) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public int glGetFragDataLocationEXT(int program, MemorySegment name) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glColor4fNormal3fVertex3fvSUN(MemorySegment c, MemorySegment n, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramLocalParametersI4uivNV(int target, int index, int count, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glEnableVertexArrayAttrib(int vaobj, int index) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glLoadTransposeMatrixd(MemorySegment m) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glLoadTransposeMatrixf(MemorySegment m) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramLocalParameterI4uiNV(int target, int index, int x, int y, int z, int w) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGenFramebuffers(int n, MemorySegment framebuffers) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBindFragDataLocationIndexedEXT(int program, int colorNumber, int index, MemorySegment name) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glHistogram(int target, int width, int internalformat, byte sink) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glClientActiveTexture(int texture) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexWeightPointerEXT(int size, int type, int stride, MemorySegment pointer) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexFilterFuncSGIS(int target, int filter, int n, MemorySegment weights) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttrib1dARB(int index, double x) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBlendColorxOES(int red, int green, int blue, int alpha) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public byte glIsEnablediEXT(int target, int index) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glRenderbufferStorageMultisampleIMG(int target, int samples, int internalformat, int width, int height) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetVertexAttribIuiv(int index, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexCoord1iARB(int target, int s) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glColorPointervINTEL(int size, int type, MemorySegment pointer) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glCompressedTexSubImage3DOES(int target, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int format, int imageSize, MemorySegment data) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDeleteStatesNV(int n, MemorySegment states) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glClientWaitSemaphoreui64NVX(int fenceObjectCount, MemorySegment semaphoreArray, MemorySegment fenceValueArray) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetProgramParameterfvNV(int target, int index, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glSetMultisamplefvAMD(int pname, int index, MemorySegment val) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glActiveProgramEXT(int program) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTranslatexOES(int x, int y, int z) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttrib2fNV(int index, float x, float y) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMakeTextureHandleNonResidentNV(long handle) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetTextureParameterivEXT(int texture, int target, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetPerfMonitorGroupStringAMD(int group, int bufSize, MemorySegment length, MemorySegment groupString) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribL1ui64vNV(int index, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetActiveUniform(int program, int index, int bufSize, MemorySegment length, MemorySegment size, MemorySegment type, MemorySegment name) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertex2bOES(byte x, byte y) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBindVertexShaderEXT(int id) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniform3i64vNV(int location, int count, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribI3iEXT(int index, int x, int y, int z) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribI4svEXT(int index, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glOrthofOES(float l, float r, float b, float t, float n, float f) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetObjectPtrLabel(MemorySegment ptr, int bufSize, MemorySegment length, MemorySegment label) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiDrawArraysEXT(int mode, MemorySegment first, MemorySegment count, int primcount) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glCombinerOutputNV(int stage, int portion, int abOutput, int cdOutput, int sumOutput, int scale, int bias, byte abDotProduct, byte cdDotProduct, byte muxSum) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexImage3DOES(int target, int level, int internalformat, int width, int height, int depth, int border, int format, int type, MemorySegment pixels) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertex2xOES(int x) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBindVertexArray(int array) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glNamedFramebufferTexture1DEXT(int framebuffer, int attachment, int textarget, int texture, int level) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetMultiTexImageEXT(int texunit, int target, int level, int format, int type, MemorySegment pixels) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glLightModelxvOES(int pname, MemorySegment param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttrib3fvNV(int index, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDeleteRenderbuffersOES(int n, MemorySegment renderbuffers) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public int glGenFragmentShadersATI(int range) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glCopyColorTable(int target, int internalformat, int x, int y, int width) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glHistogramEXT(int target, int width, int internalformat, byte sink) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexCoordP3uiv(int type, MemorySegment coords) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBindImageTexture(int unit, int texture, int level, byte layered, int layer, int access, int format) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetnUniformfvKHR(int program, int location, int bufSize, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glNamedProgramLocalParameter4fEXT(int program, int target, int index, float x, float y, float z, float w) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glWaitSync(MemorySegment sync, int flags, long timeout) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttrib4svNV(int index, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGenVertexArraysAPPLE(int n, MemorySegment arrays) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glListParameteriSGIX(int list, int pname, int param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetIntegerui64i_vNV(int value, int index, MemorySegment result) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniform3ui(int program, int location, int v0, int v1, int v2) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTextureRenderbufferEXT(int texture, int target, int renderbuffer) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glElementPointerATI(int type, MemorySegment pointer) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glSecondaryColor3hvNV(MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glColor4fNormal3fVertex3fSUN(float r, float g, float b, float a, float nx, float ny, float nz, float x, float y, float z) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexStream1sATI(int stream, short x) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public byte glExtIsProgramBinaryQCOM(int program) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGenFramebuffersEXT(int n, MemorySegment framebuffers) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glNormal3fVertex3fSUN(float nx, float ny, float nz, float x, float y, float z) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttrib4hvNV(int index, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniformMatrix2x3fvEXT(int program, int location, int count, byte transpose, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTextureAttachMemoryNV(int texture, int memory, long offset) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniform1i64ARB(int program, int location, int x) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDrawRangeElementsBaseVertexEXT(int mode, int start, int end, int count, int type, MemorySegment indices, int basevertex) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetObjectLabelEXT(int type, int object, int bufSize, MemorySegment length, MemorySegment label) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTextureView(int texture, int target, int origtexture, int internalformat, int minlevel, int numlevels, int minlayer, int numlayers) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glImportMemoryFdEXT(int memory, long size, int handleType, int fd) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMatrixMult3x2fNV(int matrixMode, MemorySegment m) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public long glGetTextureSamplerHandleIMG(int texture, int sampler) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniform4ui64vARB(int location, int count, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribP1ui(int index, int type, byte normalized, int value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glLightEnviSGIX(int pname, int param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBinormal3svEXT(MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBeginOcclusionQueryNV(int id) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public byte glIsVertexArrayOES(int array) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDrawArraysIndirect(int mode, MemorySegment indirect) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public byte glIsPointInFillPathNV(int path, int mask, float x, float y) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTextureStorageMem1DEXT(int texture, int levels, int internalFormat, int width, int memory, long offset) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFragmentLightModelfvSGIX(int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetNamedFramebufferParameterivEXT(int framebuffer, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glActiveShaderProgram(int pipeline, int program) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexEstimateMotionQCOM(int ref, int target, int output) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDrawTexiOES(int x, int y, int z, int width, int height) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glNamedBufferStorageMemEXT(int buffer, long size, int memory, long offset) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetSamplerParameterIivEXT(int sampler, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexGenxvOES(int coord, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTextureParameteriv(int texture, int pname, MemorySegment param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public byte glIsTransformFeedback(int id) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glWaitVkSemaphoreNV(long vkSemaphore) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMapBufferRangeEXT(int target, long offset, long length, int access) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glWeightubvARB(int size, MemorySegment weights) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBlendFuncSeparateiOES(int buf, int srcRGB, int dstRGB, int srcAlpha, int dstAlpha) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDrawRangeElements(int mode, int start, int end, int count, int type, MemorySegment indices) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDrawTransformFeedbackStreamInstanced(int mode, int id, int stream, int instancecount) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVDPAUFiniNV() {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetProgramEnvParameterIuivNV(int target, int index, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniformMatrix3x2dvEXT(int program, int location, int count, byte transpose, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetSamplerParameterIuivOES(int sampler, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribDivisorNV(int index, int divisor) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glWindowPos3sv(MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexP2uiv(int type, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniformMatrix2x4fv(int location, int count, byte transpose, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexCoord2fColor3fVertex3fSUN(float s, float t, float r, float g, float b, float x, float y, float z) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniform3ui64vNV(int program, int location, int count, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniformHandleui64NV(int program, int location, long value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glWindowPos3ivMESA(MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glNamedFramebufferSamplePositionsfvAMD(int framebuffer, int numsamples, int pixelindex, MemorySegment values) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetSamplerParameterIivOES(int sampler, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiDrawElementsIndirectAMD(int mode, int type, MemorySegment indirect, int primcount, int stride) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glClipPlanefOES(int plane, MemorySegment equation) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glInvalidateFramebuffer(int target, int numAttachments, MemorySegment attachments) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glLGPUCopyImageSubDataNVX(int sourceGpu, int destinationGpuMask, int srcName, int srcTarget, int srcLevel, int srcX, int srxY, int srcZ, int dstName, int dstTarget, int dstLevel, int dstX, int dstY, int dstZ, int width, int height, int depth) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexStream3dvATI(int stream, MemorySegment coords) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexGenfvEXT(int texunit, int coord, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glWaitSemaphoreEXT(int semaphore, int numBufferBarriers, MemorySegment buffers, int numTextureBarriers, MemorySegment textures, MemorySegment srcLayouts) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glRenderGpuMaskNV(int mask) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glColorTableParameterivSGI(int target, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetMultiTexEnvivEXT(int texunit, int target, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMakeNamedBufferNonResidentNV(int buffer) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramLocalParametersI4ivNV(int target, int index, int count, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetMultiTexGendvEXT(int texunit, int coord, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGlobalAlphaFactorusSUN(short factor) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glClearDepthxOES(int depth) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTextureParameterIuiv(int texture, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetnColorTable(int target, int format, int type, int bufSize, MemorySegment table) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttrib4dNV(int index, double x, double y, double z, double w) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public byte glIsBuffer(int buffer) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexCoord3hNV(short s, short t, short r) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexSubImage2DEXT(int target, int level, int xoffset, int yoffset, int width, int height, int format, int type, MemorySegment pixels) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTextureNormalEXT(int mode) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glExtTexObjectStateOverrideiQCOM(int target, int pname, int param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMinSampleShadingARB(float value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBufferStorage(int target, long size, MemorySegment data, int flags) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glPointParameterfSGIS(int pname, float param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glShaderOp1EXT(int op, int res, int arg1) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glViewportPositionWScaleNV(int index, float xcoeff, float ycoeff) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexCoord4bvOES(MemorySegment coords) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexImage3DEXT(int target, int level, int internalformat, int width, int height, int depth, int border, int format, int type, MemorySegment pixels) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniform2uiEXT(int location, int v0, int v1) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniform1uiEXT(int program, int location, int v0) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttrib4NsvARB(int index, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDrawTransformFeedbackEXT(int mode, int id) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexStorage3DMultisampleOES(int target, int samples, int internalformat, int width, int height, int depth, byte fixedsamplelocations) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetVariantPointervEXT(int id, int value, MemorySegment data) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribI3ivEXT(int index, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBlendEquationSeparateEXT(int modeRGB, int modeAlpha) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMapVertexAttrib1dAPPLE(int index, int size, double u1, double u2, int stride, int order, MemorySegment points) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glSelectPerfMonitorCountersAMD(int monitor, byte enable, int group, int numCounters, MemorySegment counterList) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniform4uivEXT(int program, int location, int count, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glColorP3ui(int type, int color) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glCreateCommandListsNV(int n, MemorySegment lists) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public MemorySegment glMapBuffer(int target, int access) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glPathCommandsNV(int path, int numCommands, MemorySegment commands, int numCoords, int coordType, MemorySegment coords) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glViewportArrayvNV(int first, int count, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGenerateTextureMipmap(int texture) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttrib2dvNV(int index, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glEnableVertexAttribArrayARB(int index) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMapNamedBufferEXT(int buffer, int access) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glClipControl(int origin, int depth) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public int glBindLightParameterEXT(int light, int value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glWindowPos4fvMESA(MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBindBufferBase(int target, int index, int buffer) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDrawTexfOES(float x, float y, float z, float width, float height) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttrib3dvARB(int index, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribArrayObjectATI(int index, int size, int type, byte normalized, int stride, int buffer, int offset) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetCompressedTextureImageEXT(int texture, int target, int lod, MemorySegment img) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public byte glIsOcclusionQueryNV(int id) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetInteger64vEXT(int pname, MemorySegment data) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glCopyTexSubImage3DOES(int target, int level, int xoffset, int yoffset, int zoffset, int x, int y, int width, int height) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFogCoordhNV(short fog) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glRenderbufferStorageEXT(int target, int internalformat, int width, int height) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertex4hvNV(MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexArrayVertexBuffer(int vaobj, int bindingindex, int buffer, long offset, int stride) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glWeightPointerOES(int size, int type, int stride, MemorySegment pointer) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBlendEquationiARB(int buf, int mode) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public int glCreateProgram() {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexImage1DEXT(int texunit, int target, int level, int internalformat, int width, int border, int format, int type, MemorySegment pixels) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexCoordFormatNV(int size, int type, int stride) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTextureBarrierNV() {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexStorageMem3DEXT(int target, int levels, int internalFormat, int width, int height, int depth, int memory, long offset) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetCompressedTextureImage(int texture, int level, int bufSize, MemorySegment pixels) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniform3fv(int program, int location, int count, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniform3i64NV(int program, int location, long x, long y, long z) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDepthRangex(int n, int f) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexArrayVertexAttribOffsetEXT(int vaobj, int buffer, int index, int size, int type, byte normalized, int stride, long offset) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramNamedParameter4fvNV(int id, int len, MemorySegment name, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glSecondaryColor3iEXT(int red, int green, int blue) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDetailTexFuncSGIS(int target, int n, MemorySegment points) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexGenfOES(int coord, int pname, float param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glNamedBufferPageCommitmentEXT(int buffer, long offset, long size, byte commit) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetFramebufferAttachmentParameterivOES(int target, int attachment, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDepthRangef(float n, float f) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniformHandleui64vNV(int program, int location, int count, MemorySegment values) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttrib4ubNV(int index, byte x, byte y, byte z, byte w) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBinormal3dvEXT(MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public long glGetTextureSamplerHandleARB(int texture, int sampler) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetFenceivNV(int fence, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniform4f(int location, float v0, float v1, float v2, float v3) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniform4i(int location, int v0, int v1, int v2, int v3) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glPauseTransformFeedbackNV() {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniform4i64ARB(int location, int x, int y, int z, int w) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVDPAUMapSurfacesNV(int numSurfaces, MemorySegment surfaces) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public int glGetFragDataIndex(int program, MemorySegment name) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetnUniformivARB(int program, int location, int bufSize, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDebugMessageInsert(int source, int type, int id, int severity, int length, MemorySegment buf) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glPixelTexGenSGIX(int mode) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glSecondaryColor3bvEXT(MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glAlphaFragmentOp1ATI(int op, int dst, int dstMod, int arg1, int arg1Rep, int arg1Mod) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniform3dv(int program, int location, int count, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public int glBindTexGenParameterEXT(int unit, int coord, int value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glColorTableEXT(int target, int internalFormat, int width, int format, int type, MemorySegment table) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniform3iARB(int location, int v0, int v1, int v2) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glEnableiEXT(int target, int index) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexGenivOES(int coord, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetProgramiv(int program, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glLabelObjectEXT(int type, int object, int length, MemorySegment label) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetShaderPrecisionFormat(int shadertype, int precisiontype, MemorySegment range, MemorySegment precision) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glPopDebugGroup() {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glSecondaryColor3ubEXT(byte red, byte green, byte blue) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttrib3svARB(int index, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniform3ui64NV(int program, int location, long x, long y, long z) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public byte glIsNamedBufferResidentNV(int buffer) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glShadingRateCombinerOpsEXT(int combinerOp0, int combinerOp1) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetnUniformiv(int program, int location, int bufSize, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramLocalParameter4dvARB(int target, int index, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniform2fvEXT(int program, int location, int count, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexStream4fATI(int stream, float x, float y, float z, float w) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glColorMaskiEXT(int index, byte r, byte g, byte b, byte a) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexCoord4xvOES(MemorySegment coords) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetQueryObjectui64v(int id, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glNamedRenderbufferStorage(int renderbuffer, int internalformat, int width, int height) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUnmapObjectBufferATI(int buffer) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexStream3dATI(int stream, double x, double y, double z) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMaterialx(int face, int pname, int param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniform2ivARB(int location, int count, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glListParameterfvSGIX(int list, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDeleteProgramPipelines(int n, MemorySegment pipelines) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexEstimateMotionRegionsQCOM(int ref, int target, int output, int mask) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glSampleMapATI(int dst, int interp, int swizzle) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFramebufferParameteriMESA(int target, int pname, int param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glViewportIndexedfOES(int index, float x, float y, float w, float h) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramNamedParameter4fNV(int id, int len, MemorySegment name, float x, float y, float z, float w) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glConvolutionParameteriEXT(int target, int pname, int params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glAccumxOES(int op, int value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniform3iv(int program, int location, int count, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetUniformivARB(MemorySegment programObj, int location, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public byte glIsProgram(int program) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetDoublei_vEXT(int pname, int index, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniformui64vNV(int location, int count, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public byte glIsVertexArrayAPPLE(int array) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetProgramPipelineInfoLog(int pipeline, int bufSize, MemorySegment length, MemorySegment infoLog) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glLoadMatrixxOES(MemorySegment m) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetPathTexGenfvNV(int texCoordSet, int pname, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetPathCoordsNV(int path, MemorySegment coords) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribI4uivEXT(int index, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glCopyPathNV(int resultPath, int srcPath) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glSamplePatternEXT(int pattern) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribL2ui64vNV(int index, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetMapxvOES(int target, int query, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glShadingRateImageBarrierNV(byte synchronize) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glApplyFramebufferAttachmentCMAAINTEL() {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniform2ui64NV(int program, int location, long x, long y) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBindProgramARB(int target, int program) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glReplacementCodeuiNormal3fVertex3fSUN(int rc, float nx, float ny, float nz, float x, float y, float z) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glNamedBufferSubDataEXT(int buffer, long offset, long size, MemorySegment data) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glClearBufferfv(int buffer, int drawbuffer, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetSamplerParameterfv(int sampler, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glClearBufferfi(int buffer, int drawbuffer, float depth, int stencil) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetFragmentLightfvSGIX(int light, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glNormal3x(int nx, int ny, int nz) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDrawRangeElementsBaseVertexOES(int mode, int start, int end, int count, int type, MemorySegment indices, int basevertex) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public int glAsyncCopyImageSubDataNVX(int waitSemaphoreCount, MemorySegment waitSemaphoreArray, MemorySegment waitValueArray, int srcGpu, int dstGpuMask, int srcName, int srcTarget, int srcLevel, int srcX, int srcY, int srcZ, int dstName, int dstTarget, int dstLevel, int dstX, int dstY, int dstZ, int srcWidth, int srcHeight, int srcDepth, int signalSemaphoreCount, MemorySegment signalSemaphoreArray, MemorySegment signalValueArray) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glClearBufferiv(int buffer, int drawbuffer, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTangent3bEXT(byte tx, byte ty, byte tz) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glCopyNamedBufferSubData(int readBuffer, int writeBuffer, long readOffset, long writeOffset, long size) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDeleteTransformFeedbacks(int n, MemorySegment ids) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramEnvParameterI4uivNV(int target, int index, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glCompressedTexSubImage2D(int target, int level, int xoffset, int yoffset, int width, int height, int format, int imageSize, MemorySegment data) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glSampleMaski(int maskNumber, int mask) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMatrixPushEXT(int mode) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexArrayVertexAttribBindingEXT(int vaobj, int attribindex, int bindingindex) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glEGLImageTargetTexStorageEXT(int target, int image, int attrib_list) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetNamedStringivARB(int namelen, MemorySegment name, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFinishFenceNV(int fence) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetTextureParameterfv(int texture, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDrawElementsInstancedANGLE(int mode, int count, int type, MemorySegment indices, int primcount) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttrib4sv(int index, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBindVertexBuffers(int first, int count, MemorySegment buffers, MemorySegment offsets, MemorySegment strides) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribI4bv(int index, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDeletePerfMonitorsAMD(int n, MemorySegment monitors) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetSamplerParameteriv(int sampler, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glCompressedTexSubImage1D(int target, int level, int xoffset, int width, int format, int imageSize, MemorySegment data) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexCoord3dvARB(int target, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glConvolutionParameteri(int target, int pname, int params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBindProgramPipeline(int pipeline) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glConvolutionParameterf(int target, int pname, float params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glScissorIndexedvOES(int index, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBindTextureEXT(int target, int texture) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetUniformi64vNV(int program, int location, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDrawElementsInstancedBaseVertex(int mode, int count, int type, MemorySegment indices, int instancecount, int basevertex) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttrib3hNV(int index, short x, short y, short z) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetInvariantFloatvEXT(int id, int value, MemorySegment data) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glCreateQueries(int target, int n, MemorySegment ids) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glCreateTransformFeedbacks(int n, MemorySegment ids) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glEnableVertexAttribArray(int index) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBeginTransformFeedbackNV(int primitiveMode) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniformHandleui64ARB(int program, int location, long value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glImageTransformParameterfvHP(int target, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glClearBufferData(int target, int internalformat, int format, int type, MemorySegment data) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glWindowPos2fARB(float x, float y) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetActiveAttribARB(MemorySegment programObj, int index, int maxLength, MemorySegment length, MemorySegment size, MemorySegment type, MemorySegment name) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniform1fvARB(int location, int count, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public long glGetImageHandleARB(int texture, int level, byte layered, int layer, int format) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetFloati_vNV(int target, int index, MemorySegment data) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glCompressedTexSubImage3D(int target, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int format, int imageSize, MemorySegment data) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glSwizzleEXT(int res, int in, int outX, int outY, int outZ, int outW) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glCopyBufferSubData(int readTarget, int writeTarget, long readOffset, long writeOffset, long size) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMatrixMultfEXT(int mode, MemorySegment m) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniform2ui64vNV(int location, int count, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniform2uiv(int program, int location, int count, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniformMatrix4x3dvEXT(int program, int location, int count, byte transpose, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDispatchComputeIndirect(long indirect) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetTextureParameteriv(int texture, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexCoord2bOES(int texture, byte s, byte t) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexCoord2xOES(int texture, int s, int t) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGenerateMultiTexMipmapEXT(int texunit, int target) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glStencilThenCoverFillPathNV(int path, int fillMode, int mask, int coverMode) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniform2fvARB(int location, int count, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexArrayFogCoordOffsetEXT(int vaobj, int buffer, int type, int stride, long offset) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glClearDepthdNV(double depth) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetQueryObjectuiv(int id, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glExtGetTexLevelParameterivQCOM(int texture, int face, int level, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glPassTexCoordATI(int dst, int coord, int swizzle) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMatrixLoadfEXT(int mode, MemorySegment m) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDeleteAsyncMarkersSGIX(int marker, int range) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDrawMeshArraysSUN(int mode, int first, int count, int width) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetVertexAttribPointervNV(int index, int pname, MemorySegment pointer) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetnPixelMapusvARB(int map, int bufSize, MemorySegment values) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public int glGetInstrumentsSGIX() {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGenRenderbuffers(int n, MemorySegment renderbuffers) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public byte glIsAsyncMarkerSGIX(int marker) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribs3fvNV(int index, int count, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttrib1sNV(int index, short x) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexParameterxv(int target, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniformMatrix3x4fvEXT(int program, int location, int count, byte transpose, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glSecondaryColor3fvEXT(MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBlendEquationEXT(int mode) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBeginPerfQueryINTEL(int queryHandle) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFlushVertexArrayRangeAPPLE(int length, MemorySegment pointer) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniform2ui(int program, int location, int v0, int v1) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBlendEquationSeparateiEXT(int buf, int modeRGB, int modeAlpha) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMakeImageHandleResidentNV(long handle, int access) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetFloatIndexedvEXT(int target, int index, MemorySegment data) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexCoord3sARB(int target, short s, short t, short r) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetSamplerParameterIuivEXT(int sampler, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glInterpolatePathsNV(int resultPath, int pathA, int pathB, float weight) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniform4fv(int location, int count, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribs2dvNV(int index, int count, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBindBuffersRange(int target, int first, int count, MemorySegment buffers, MemorySegment offsets, MemorySegment sizes) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glPathStencilDepthOffsetNV(float factor, float units) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glShaderStorageBlockBinding(int program, int storageBlockIndex, int storageBlockBinding) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribs4svNV(int index, int count, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBeginQueryIndexed(int target, int index, int id) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFramebufferTexture3DEXT(int target, int attachment, int textarget, int texture, int level, int zoffset) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetVideoCaptureStreamivNV(int video_capture_slot, int stream, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glStencilFillPathInstancedNV(int numPaths, int pathNameType, MemorySegment paths, int pathBase, int fillMode, int mask, int transformType, MemorySegment transformValues) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniform4iv(int location, int count, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribI4iv(int index, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniformMatrix4x2dvEXT(int program, int location, int count, byte transpose, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glCopyColorSubTableEXT(int target, int start, int x, int y, int width) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetProgramPipelineInfoLogEXT(int pipeline, int bufSize, MemorySegment length, MemorySegment infoLog) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glWindowPos3svARB(MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public int glGetDebugMessageLogARB(int count, int bufSize, MemorySegment sources, MemorySegment types, MemorySegment ids, MemorySegment severities, MemorySegment lengths, MemorySegment messageLog) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVDPAUInitNV(MemorySegment vdpDevice, MemorySegment getProcAddress) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glWeightsvARB(int size, MemorySegment weights) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribs4hvNV(int index, int n, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetUniformui64vARB(int program, int location, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexCoordPointerEXT(int texunit, int size, int type, int stride, MemorySegment pointer) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glClearNamedFramebufferuiv(int framebuffer, int buffer, int drawbuffer, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFragmentLightfvSGIX(int light, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexSubImage3DOES(int target, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int format, int type, MemorySegment pixels) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniform4uiEXT(int program, int location, int v0, int v1, int v2, int v3) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGenTexturesEXT(int n, MemorySegment textures) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDispatchComputeGroupSizeARB(int num_groups_x, int num_groups_y, int num_groups_z, int group_size_x, int group_size_y, int group_size_z) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glColor3hvNV(MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glLoadPaletteFromModelViewMatrixOES() {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDepthRangexOES(int n, int f) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public long glGetTextureSamplerHandleNV(int texture, int sampler) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramVertexLimitNV(int target, int limit) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glCreateSamplers(int n, MemorySegment samplers) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttrib4NubvARB(int index, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDeleteNamesAMD(int identifier, int num, MemorySegment names) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTextureStorage1DEXT(int texture, int target, int levels, int internalformat, int width) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexPointerEXT(int size, int type, int stride, int count, MemorySegment pointer) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexStream1ivATI(int stream, MemorySegment coords) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glColorFragmentOp1ATI(int op, int dst, int dstMask, int dstMod, int arg1, int arg1Rep, int arg1Mod) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glLineWidthx(int width) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetVertexAttribArrayObjectivATI(int index, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetColorTableParameterivSGI(int target, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glPrimitiveBoundingBoxARB(float minX, float minY, float minZ, float minW, float maxX, float maxY, float maxZ, float maxW) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniformMatrix2x3fv(int location, int count, byte transpose, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTextureImage1DEXT(int texture, int target, int level, int internalformat, int width, int border, int format, int type, MemorySegment pixels) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public int glGetDebugMessageLogAMD(int count, int bufSize, MemorySegment categories, MemorySegment severities, MemorySegment ids, MemorySegment lengths, MemorySegment message) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glLightModelx(int pname, int param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public int glQueryResourceNV(int queryType, int tagId, int count, MemorySegment buffer) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexAttachMemoryNV(int target, int memory, long offset) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public long glGetUniformOffsetEXT(int program, int location) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDeleteShader(int shader) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniform3uiv(int location, int count, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glColorTableParameterfvSGI(int target, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDrawCommandsStatesNV(int buffer, MemorySegment indirects, MemorySegment sizes, MemorySegment states, MemorySegment fbos, int count) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetQueryivEXT(int target, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexArrayVertexOffsetEXT(int vaobj, int buffer, int size, int type, int stride, long offset) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttrib4iv(int index, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glEdgeFlagPointerListIBM(int stride, byte pointer, int ptrstride) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttrib4fv(int index, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexStream3svATI(int stream, MemorySegment coords) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetNamedBufferPointerv(int buffer, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glIndexMaterialEXT(int face, int mode) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glScissorExclusiveNV(int x, int y, int width, int height) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDeleteObjectARB(MemorySegment obj) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiModeDrawArraysIBM(MemorySegment mode, MemorySegment first, MemorySegment count, int primcount, int modestride) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMatrixLoad3x2fNV(int matrixMode, MemorySegment m) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glCompressedMultiTexSubImage2DEXT(int texunit, int target, int level, int xoffset, int yoffset, int width, int height, int format, int imageSize, MemorySegment bits) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetMemoryObjectDetachedResourcesuivNV(int memory, int pname, int first, int count, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexSubImage3D(int target, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int format, int type, MemorySegment pixels) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glWindowPos3iMESA(int x, int y, int z) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glCreateTextures(int target, int n, MemorySegment textures) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDrawBuffersIndexedEXT(int n, MemorySegment location, MemorySegment indices) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniform4i64vNV(int location, int count, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glLoadTransposeMatrixdARB(MemorySegment m) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribL3dvEXT(int index, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetnUniformfvARB(int program, int location, int bufSize, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glCompressedTextureSubImage1DEXT(int texture, int target, int level, int xoffset, int width, int format, int imageSize, MemorySegment bits) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniformMatrix2x3dv(int location, int count, byte transpose, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFrustumx(int l, int r, int b, int t, int n, int f) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniform4dv(int location, int count, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFrustumf(float l, float r, float b, float t, float n, float f) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFramebufferTextureMultisampleMultiviewOVR(int target, int attachment, int texture, int level, int samples, int baseViewIndex, int numViews) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribI4sv(int index, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetNamedRenderbufferParameteriv(int renderbuffer, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramEnvParameter4dARB(int target, int index, double x, double y, double z, double w) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glCopyTextureSubImage1DEXT(int texture, int target, int level, int xoffset, int x, int y, int width) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexArrayVertexBindingDivisorEXT(int vaobj, int bindingindex, int divisor) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFramebufferTexture1D(int target, int attachment, int textarget, int texture, int level) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFramebufferFetchBarrierEXT() {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glLightModelxOES(int pname, int param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexImage3DMultisample(int target, int samples, int internalformat, int width, int height, int depth, byte fixedsamplelocations) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniform1i64NV(int location, long x) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniformMatrix3x2dv(int program, int location, int count, byte transpose, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glRenderbufferStorageOES(int target, int internalformat, int width, int height) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexRenderbufferNV(int target, int renderbuffer) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glPolygonOffsetEXT(float factor, float bias) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniform4dEXT(int program, int location, double x, double y, double z, double w) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glCreateMemoryObjectsEXT(int n, MemorySegment memoryObjects) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMatrixRotatefEXT(int mode, float angle, float x, float y, float z) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetPerfMonitorCounterStringAMD(int group, int counter, int bufSize, MemorySegment length, MemorySegment counterString) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniformMatrix2x4dv(int location, int count, byte transpose, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribI4ui(int index, int x, int y, int z, int w) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetColorTableEXT(int target, int format, int type, MemorySegment data) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFlushMappedBufferRange(int target, long offset, long length) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetTextureImageEXT(int texture, int target, int level, int format, int type, MemorySegment pixels) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glResumeTransformFeedbackNV() {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBindBufferBaseNV(int target, int index, int buffer) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glCopyConvolutionFilter2DEXT(int target, int internalformat, int x, int y, int width, int height) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTransformFeedbackVaryings(int program, int count, MemorySegment varyings, int bufferMode) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramLocalParameterI4iNV(int target, int index, int x, int y, int z, int w) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniform3ui64vNV(int location, int count, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glScalex(int x, int y, int z) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetMapAttribParameterfvNV(int target, int index, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glEnableiOES(int target, int index) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glRenderbufferStorageMultisampleANGLE(int target, int samples, int internalformat, int width, int height) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFramebufferTexture3D(int target, int attachment, int textarget, int texture, int level, int zoffset) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexCoordP4uiv(int texture, int type, MemorySegment coords) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniform2i64ARB(int program, int location, int x, int y) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultMatrixxOES(MemorySegment m) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexParameterxvOES(int target, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glEndVertexShaderEXT() {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glQueryResourceTagNV(int tagId, MemorySegment tagString) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertex2bvOES(MemorySegment coords) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexStorage2DEXT(int target, int levels, int internalformat, int width, int height) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetnUniformi64vARB(int program, int location, int bufSize, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniform3dvEXT(int program, int location, int count, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFramebufferTexture2D(int target, int attachment, int textarget, int texture, int level) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBlendEquationSeparateiOES(int buf, int modeRGB, int modeAlpha) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexParameterIuiv(int target, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDeleteRenderbuffersEXT(int n, MemorySegment renderbuffers) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetUnsignedBytevEXT(int pname, MemorySegment data) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public byte glIsSemaphoreEXT(int semaphore) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexStream4iATI(int stream, int x, int y, int z, int w) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDrawElementArrayAPPLE(int mode, int first, int count) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFogCoordf(float coord) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFogCoordd(double coord) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBeginPerfMonitorAMD(int monitor) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBlendFuncSeparateiEXT(int buf, int srcRGB, int dstRGB, int srcAlpha, int dstAlpha) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFogCoorddEXT(double coord) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetOcclusionQueryivNV(int id, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexCoord2fARB(int target, float s, float t) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFragmentLightModelivSGIX(int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetFragmentMaterialivSGIX(int face, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDrawElementsInstancedEXT(int mode, int count, int type, MemorySegment indices, int primcount) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexBlendEnviATI(int pname, int param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glClampColorARB(int target, int clamp) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexCoord2fVertex3fSUN(float s, float t, float x, float y, float z) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glCreatePerfQueryINTEL(int queryId, MemorySegment queryHandle) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glConvolutionFilter2D(int target, int internalformat, int width, int height, int format, int type, MemorySegment image) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetQueryObjectivARB(int id, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniform3ui64vARB(int location, int count, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetHistogramParameterivEXT(int target, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetMapAttribParameterivNV(int target, int index, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniform4ui64vNV(int program, int location, int count, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glViewportIndexedfvOES(int index, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniformMatrix3x2fv(int program, int location, int count, byte transpose, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetPathTexGenivNV(int texCoordSet, int pname, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBufferPageCommitmentARB(int target, long offset, long size, byte commit) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glNormal3xOES(int nx, int ny, int nz) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBeginQueryARB(int target, int id) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glConvolutionFilter1D(int target, int internalformat, int width, int format, int type, MemorySegment image) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexArrayIndexOffsetEXT(int vaobj, int buffer, int type, int stride, long offset) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glExtGetTexSubImageQCOM(int target, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int format, int type, MemorySegment texels) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGenTransformFeedbacksNV(int n, MemorySegment ids) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glImportSemaphoreWin32HandleEXT(int semaphore, int handleType, MemorySegment handle) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBindVertexBuffer(int bindingindex, int buffer, long offset, int stride) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glSecondaryColor3fEXT(float red, float green, float blue) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexCoord1dARB(int target, double s) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glColorSubTableEXT(int target, int start, int count, int format, int type, MemorySegment data) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetVertexArrayIntegervEXT(int vaobj, int pname, MemorySegment param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glSecondaryColorP3ui(int type, int color) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glColorMaskiOES(int index, byte r, byte g, byte b, byte a) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniform2dv(int program, int location, int count, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetPerfMonitorGroupsAMD(MemorySegment numGroups, int groupsSize, MemorySegment groups) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glIndexFormatNV(int type, int stride) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniform3uiEXT(int location, int v0, int v1, int v2) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glCopyTexSubImage2DEXT(int target, int level, int xoffset, int yoffset, int x, int y, int width, int height) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVDPAUUnmapSurfacesNV(int numSurface, MemorySegment surfaces) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribI4uiEXT(int index, int x, int y, int z, int w) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniformMatrix3dvEXT(int program, int location, int count, byte transpose, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glRenderbufferStorageMultisample(int target, int samples, int internalformat, int width, int height) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetPerfMonitorCounterInfoAMD(int group, int counter, int pname, MemorySegment data) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetVertexAttribfvARB(int index, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttrib2fARB(int index, float x, float y) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public byte glIsSampler(int sampler) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetQueryObjecti64v(int id, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glWindowPos2fMESA(float x, float y) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDeformationMap3fSGIX(int target, float u1, float u2, int ustride, int uorder, float v1, float v2, int vstride, int vorder, float w1, float w2, int wstride, int worder, MemorySegment points) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glReplacementCodeubSUN(byte code) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBindVertexArrayOES(int array) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetBufferSubDataARB(int target, long offset, long size, MemorySegment data) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribL2i64NV(int index, long x, long y) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glSecondaryColor3d(double red, double green, double blue) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexCoord4xOES(int s, int t, int r, int q) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFramebufferFoveationConfigQCOM(int framebuffer, int numLayers, int focalPointsPerLayer, int requestedFeatures, MemorySegment providedFeatures) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glSecondaryColor3f(float red, float green, float blue) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glSecondaryColor3b(byte red, byte green, byte blue) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glSecondaryColor3i(int red, int green, int blue) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glSecondaryColor3s(short red, short green, short blue) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDeletePathsNV(int path, int range) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glWindowPos3sARB(short x, short y, short z) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glWindowPos3dvARB(MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glSampleMaskIndexedNV(int index, int mask) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glNamedBufferSubData(int buffer, long offset, long size, MemorySegment data) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGenQueriesEXT(int n, MemorySegment ids) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexCoord1ivARB(int target, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexCoord4hvNV(int target, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glShaderBinary(int count, MemorySegment shaders, int binaryFormat, MemorySegment binary, int length) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBufferPageCommitmentMemNV(int target, long offset, long size, int memory, long memOffset, byte commit) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexCoord4bOES(byte s, byte t, byte r, byte q) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glCoverageModulationNV(int components) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDeletePerfQueryINTEL(int queryHandle) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetUniformi64vARB(int program, int location, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexStorage3DMultisample(int target, int samples, int internalformat, int width, int height, int depth, byte fixedsamplelocations) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiModeDrawElementsIBM(MemorySegment mode, MemorySegment count, int type, MemorySegment indices, int primcount, int modestride) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexCoord2fColor4ubVertex3fSUN(float s, float t, byte r, byte g, byte b, byte a, float x, float y, float z) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniform4i64NV(int location, long x, long y, long z, long w) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFinalCombinerInputNV(int variable, int input, int mapping, int componentUsage) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiDrawElements(int mode, MemorySegment count, int type, MemorySegment indices, int drawcount) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniform1iEXT(int program, int location, int v0) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexImage3D(int target, int level, int internalformat, int width, int height, int depth, int border, int format, int type, MemorySegment pixels) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glShadingRateQCOM(int rate) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGlobalAlphaFactordSUN(double factor) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetSamplerParameterIuiv(int sampler, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFinishTextureSUNX() {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttrib3sARB(int index, short x, short y, short z) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFramebufferRenderbufferOES(int target, int attachment, int renderbuffertarget, int renderbuffer) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glNormalStream3fATI(int stream, float nx, float ny, float nz) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glPathParameteriNV(int path, int pname, int value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glNamedBufferStorage(int buffer, long size, MemorySegment data, int flags) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBindBufferOffsetNV(int target, int index, int buffer, long offset) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribFormatNV(int index, int size, int type, byte normalized, int stride) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBlendFuncSeparate(int sfactorRGB, int dfactorRGB, int sfactorAlpha, int dfactorAlpha) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiDrawElementsIndirectCountARB(int mode, int type, MemorySegment indirect, long drawcount, int maxdrawcount, int stride) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBufferData(int target, long size, MemorySegment data, int usage) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMapControlPointsNV(int target, int index, int type, int ustride, int vstride, int uorder, int vorder, byte packed, MemorySegment points) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTextureSubImage3DEXT(int texture, int target, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int format, int type, MemorySegment pixels) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDetachShader(int program, int shader) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexBuffer(int target, int internalformat, int buffer) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetPointeri_vEXT(int pname, int index, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glClientActiveTextureARB(int texture) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniform2iv(int program, int location, int count, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public byte glIsEnabledIndexedEXT(int target, int index) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glCopyColorTableSGI(int target, int internalformat, int x, int y, int width) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public byte glIsTextureHandleResidentNV(long handle) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glInvalidateBufferSubData(int buffer, long offset, long length) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public int glGenAsyncMarkersSGIX(int range) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetProgramInfoLog(int program, int bufSize, MemorySegment length, MemorySegment infoLog) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMatrixMultTranspose3x3fNV(int matrixMode, MemorySegment m) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFragmentMaterialivSGIX(int face, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMatrixLoadTranspose3x3fNV(int matrixMode, MemorySegment m) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public byte glPointAlongPathNV(int path, int startSegment, int numSegments, float distance, MemorySegment x, MemorySegment y, MemorySegment tangentX, MemorySegment tangentY) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetVertexArrayIndexed64iv(int vaobj, int index, int pname, MemorySegment param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniform2fv(int program, int location, int count, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetFramebufferAttachmentParameterivEXT(int target, int attachment, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVariantdvEXT(int id, MemorySegment addr) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexImage2DMultisampleCoverageNV(int target, int coverageSamples, int colorSamples, int internalFormat, int width, int height, byte fixedSampleLocations) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribI2uiv(int index, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glNamedRenderbufferStorageMultisampleAdvancedAMD(int renderbuffer, int samples, int storageSamples, int internalformat, int width, int height) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glEnableVariantClientStateEXT(int id) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBufferStorageExternalEXT(int target, long offset, long size, MemorySegment clientBuffer, int flags) {
    throw new RuntimeException("This method is not available in the generated binding.");
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
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDrawTransformFeedback(int mode, int id) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniform4ui(int location, int v0, int v1, int v2, int v3) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniform1ui64NV(int location, long x) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glPathSubCommandsNV(int path, int commandStart, int commandsToDelete, int numCommands, MemorySegment commands, int numCoords, int coordType, MemorySegment coords) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexParameterIivEXT(int texunit, int target, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTextureImage2DMultisampleCoverageNV(int texture, int target, int coverageSamples, int colorSamples, int internalFormat, int width, int height, byte fixedSampleLocations) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glWeightdvARB(int size, MemorySegment weights) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexCoord3svARB(int target, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glCopyBufferSubDataNV(int readTarget, int writeTarget, long readOffset, long writeOffset, long size) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBufferStorageMemEXT(int target, long size, int memory, long offset) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glPointParameteriv(int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBeginFragmentShaderATI() {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDrawElementsInstancedBaseInstanceEXT(int mode, int count, int type, MemorySegment indices, int instancecount, int baseinstance) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniform3ui64vARB(int program, int location, int count, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribI4uiv(int index, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetProgramLocalParameterIuivNV(int target, int index, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttrib2dvARB(int index, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glCompressedMultiTexImage3DEXT(int texunit, int target, int level, int internalformat, int width, int height, int depth, int border, int imageSize, MemorySegment bits) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glNormalStream3iATI(int stream, int nx, int ny, int nz) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glPushDebugGroup(int source, int id, int length, MemorySegment message) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiDrawArraysIndirectBindlessCountNV(int mode, MemorySegment indirect, int drawCount, int maxDrawCount, int stride, int vertexBufferCount) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetObjectParameterivAPPLE(int objectType, int name, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexStorageAttribs2DEXT(int target, int levels, int internalformat, int width, int height, int attrib_list) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribLPointerEXT(int index, int size, int type, int stride, MemorySegment pointer) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public int glVDPAURegisterVideoSurfaceWithPictureStructureNV(MemorySegment vdpSurface, int target, int numTextureNames, MemorySegment textureNames, byte isFrameStructure) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glAlphaFuncx(int func, int ref) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetConvolutionParameterxvOES(int target, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTbufferMask3DFX(int mask) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniformHandleui64vIMG(int location, int count, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetCoverageModulationTableNV(int bufSize, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glInvalidateNamedFramebufferData(int framebuffer, int numAttachments, MemorySegment attachments) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glColor4ubVertex3fSUN(byte r, byte g, byte b, byte a, float x, float y, float z) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribPointer(int index, int size, int type, byte normalized, int stride, MemorySegment pointer) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glCoverageMaskNV(byte mask) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFragmentLightiSGIX(int light, int pname, int param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBlendFunciARB(int buf, int src, int dst) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexCoord2iARB(int target, int s, int t) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glConvolutionParameterivEXT(int target, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFramebufferRenderbufferEXT(int target, int attachment, int renderbuffertarget, int renderbuffer) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetUnsignedBytei_vEXT(int target, int index, MemorySegment data) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glNormal3hvNV(MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFramebufferTextureLayerEXT(int target, int attachment, int texture, int level, int layer) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glActiveTextureARB(int texture) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBlendEquationOES(int mode) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGenerateMipmapOES(int target) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniform4uiv(int location, int count, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDeleteQueriesARB(int n, MemorySegment ids) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glNormalP3uiv(int type, MemorySegment coords) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribI4ubvEXT(int index, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBindBufferRangeEXT(int target, int index, int buffer, long offset, long size) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttrib2hNV(int index, short x, short y) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glPointParameterfv(int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDrawCommandsStatesAddressNV(MemorySegment indirects, MemorySegment sizes, MemorySegment states, MemorySegment fbos, int count) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glCoverageOperationNV(int operation) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBindImageTextures(int first, int count, MemorySegment textures) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glNamedRenderbufferStorageMultisampleCoverageEXT(int renderbuffer, int coverageSamples, int colorSamples, int internalformat, int width, int height) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexEnvfvEXT(int texunit, int target, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniform3uivEXT(int location, int count, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTagSampleBufferSGIX() {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniform3iv(int location, int count, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniform1dEXT(int program, int location, double x) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glClipPlanefIMG(int p, MemorySegment eqn) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribL1ui64ARB(int index, long x) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glIndexFuncEXT(int func, float ref) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniform3i64ARB(int location, int x, int y, int z) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetnMapfvARB(int target, int query, int bufSize, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glClearBufferSubData(int target, int internalformat, long offset, long size, int format, int type, MemorySegment data) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glCompressedTexImage3DOES(int target, int level, int internalformat, int width, int height, int depth, int border, int imageSize, MemorySegment data) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetnMinmaxARB(int target, byte reset, int format, int type, int bufSize, MemorySegment values) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetQueryObjectui64vEXT(int id, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetMultiTexGenivEXT(int texunit, int coord, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProvokingVertex(int mode) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetTexLevelParameterxvOES(int target, int level, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public byte glIsVertexAttribEnabledAPPLE(int index, int pname) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glEndPerfMonitorAMD(int monitor) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetNamedFramebufferParameterfvAMD(int framebuffer, int pname, int numsamples, int pixelindex, int size, MemorySegment values) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDrawRangeElementArrayATI(int mode, int start, int end, int count) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glEGLImageTargetRenderbufferStorageOES(int target, int image) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetVariantFloatvEXT(int id, int value, MemorySegment data) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBlendEquationSeparateIndexedAMD(int buf, int modeRGB, int modeAlpha) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glPNTrianglesiATI(int pname, int param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFragmentMaterialfvSGIX(int face, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glStencilFuncSeparateATI(int frontfunc, int backfunc, int ref, int mask) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glCreateStatesNV(int n, MemorySegment states) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTextureLightEXT(int pname) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMatrixIndexPointerARB(int size, int type, int stride, MemorySegment pointer) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexCoord4fVertex4fSUN(float s, float t, float p, float q, float x, float y, float z, float w) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glPixelMapx(int map, int size, MemorySegment values) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glNormalPointerListIBM(int type, int stride, MemorySegment pointer, int ptrstride) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public byte glIsEnablediNV(int target, int index) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniform2fARB(int location, float v0, float v1) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVariantubvEXT(int id, MemorySegment addr) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glStringMarkerGREMEDY(int len, MemorySegment string) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glSignalVkSemaphoreNV(long vkSemaphore) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDrawTransformFeedbackInstanced(int mode, int id, int instancecount) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glScissorIndexedOES(int index, int left, int bottom, int width, int height) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetTextureLevelParameterfv(int texture, int level, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVideoCaptureStreamParameterivNV(int video_capture_slot, int stream, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGlobalAlphaFactorubSUN(byte factor) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glCullParameterfvEXT(int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniformBlockBinding(int program, int uniformBlockIndex, int uniformBlockBinding) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glCopyMultiTexSubImage2DEXT(int texunit, int target, int level, int xoffset, int yoffset, int x, int y, int width, int height) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glClientAttribDefaultEXT(int mask) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public int glCheckFramebufferStatus(int target) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDeleteProgramsNV(int n, MemorySegment programs) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGlobalAlphaFactorsSUN(short factor) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glListParameterfSGIX(int list, int pname, float param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetnPixelMapfvARB(int map, int bufSize, MemorySegment values) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetActiveUniformName(int program, int uniformIndex, int bufSize, MemorySegment length, MemorySegment uniformName) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBlendEquationIndexedAMD(int buf, int mode) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDrawElementsInstanced(int mode, int count, int type, MemorySegment indices, int instancecount) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniform2fEXT(int program, int location, float v0, float v1) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexParameterfEXT(int texunit, int target, int pname, float param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetPathCommandsNV(int path, MemorySegment commands) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glResumeTransformFeedback() {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetProgramResourcefvNV(int program, int programInterface, int index, int propCount, MemorySegment props, int count, MemorySegment length, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glShadingRateSampleOrderNV(int order) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetProgramBinaryOES(int program, int bufSize, MemorySegment length, MemorySegment binaryFormat, MemorySegment binary) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glCopyTextureSubImage3DEXT(int texture, int target, int level, int xoffset, int yoffset, int zoffset, int x, int y, int width, int height) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMulticastWaitSyncNV(int signalGpu, int waitGpuMask) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMinmax(int target, int internalformat, byte sink) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribP3ui(int index, int type, byte normalized, int value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexPointervINTEL(int size, int type, MemorySegment pointer) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBindFramebuffer(int target, int framebuffer) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glColor3xvOES(MemorySegment components) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDeleteQueries(int n, MemorySegment ids) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMakeBufferNonResidentNV(int target) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexStream2dvATI(int stream, MemorySegment coords) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTransformFeedbackAttribsNV(int count, MemorySegment attribs, int bufferMode) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glSecondaryColor3usvEXT(MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetUniformiv(int program, int location, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public byte glIsFenceAPPLE(int fence) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFrustumfOES(float l, float r, float b, float t, float n, float f) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniform3dv(int location, int count, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glColorTableParameteriv(int target, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetShaderInfoLog(int shader, int bufSize, MemorySegment length, MemorySegment infoLog) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glSecondaryColor3dEXT(double red, double green, double blue) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribI4usv(int index, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDrawBuffersEXT(int n, MemorySegment bufs) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniformMatrix2x4dvEXT(int program, int location, int count, byte transpose, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glCopyTexImage1DEXT(int target, int level, int internalformat, int x, int y, int width, int border) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public int glCreateShaderProgramvEXT(int type, int count, MemorySegment strings) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFramebufferTexture(int target, int attachment, int texture, int level) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glNamedProgramLocalParameters4fvEXT(int program, int target, int index, int count, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetVideoivNV(int video_slot, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetNamedRenderbufferParameterivEXT(int renderbuffer, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glCompressedTextureSubImage3D(int texture, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int format, int imageSize, MemorySegment data) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetClipPlanefOES(int plane, MemorySegment equation) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMapVertexAttrib2dAPPLE(int index, int size, double u1, double u2, int ustride, int uorder, double v1, double v2, int vstride, int vorder, MemorySegment points) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFinishObjectAPPLE(int object, int name) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttrib1dvNV(int index, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetRenderbufferParameterivOES(int target, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glViewportIndexedfNV(int index, float x, float y, float w, float h) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexGendEXT(int texunit, int coord, int pname, double param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetnUniformui64vARB(int program, int location, int bufSize, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexCoord1bvOES(MemorySegment coords) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexArrayAttribFormat(int vaobj, int attribindex, int size, int type, byte normalized, int relativeoffset) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFogCoordPointerListIBM(int type, int stride, MemorySegment pointer, int ptrstride) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexArrayAttribIFormat(int vaobj, int attribindex, int size, int type, int relativeoffset) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glReplacementCodeuiColor4ubVertex3fvSUN(MemorySegment rc, MemorySegment c, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniform3fv(int location, int count, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetPixelTransformParameterfvEXT(int target, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMatrixLoad3x3fNV(int matrixMode, MemorySegment m) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramLocalParameters4fvEXT(int target, int index, int count, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexArrayVertexBuffers(int vaobj, int first, int count, MemorySegment buffers, MemorySegment offsets, MemorySegment strides) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDrawElementsBaseVertexOES(int mode, int count, int type, MemorySegment indices, int basevertex) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexCoordP1uiv(int texture, int type, MemorySegment coords) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttrib4dARB(int index, double x, double y, double z, double w) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glWindowPos3sMESA(short x, short y, short z) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glColorTableParameterfv(int target, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetUniformdv(int program, int location, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetVertexAttribPointerv(int index, int pname, MemorySegment pointer) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTransformFeedbackBufferRange(int xfb, int index, int buffer, long offset, long size) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttrib2fvNV(int index, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glViewportIndexedf(int index, float x, float y, float w, float h) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glCompressedTextureSubImage1D(int texture, int level, int xoffset, int width, int format, int imageSize, MemorySegment data) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniform1fvEXT(int program, int location, int count, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glColor4hNV(short red, short green, short blue, short alpha) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glPauseTransformFeedback() {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public long glGetTextureHandleNV(int texture) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexBumpParameterivATI(int pname, MemorySegment param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glExtGetShadersQCOM(MemorySegment shaders, int maxShaders, MemorySegment numShaders) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFramebufferTexture2DOES(int target, int attachment, int textarget, int texture, int level) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexCoordP1ui(int texture, int type, int coords) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glPolygonOffsetx(int factor, int units) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glCreateVertexArrays(int n, MemorySegment arrays) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glIndexPointerEXT(int type, int stride, int count, MemorySegment pointer) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glWindowPos2dvMESA(MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetBufferSubData(int target, long offset, long size, MemorySegment data) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniform2i64vNV(int location, int count, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glCompressedTextureSubImage2D(int texture, int level, int xoffset, int yoffset, int width, int height, int format, int imageSize, MemorySegment data) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDrawTransformFeedbackNV(int mode, int id) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexCoord2fColor4ubVertex3fvSUN(MemorySegment tc, MemorySegment c, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetFragmentLightivSGIX(int light, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTangent3dvEXT(MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttrib4fNV(int index, float x, float y, float z, float w) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexCoord4hvNV(MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexSubImage3DEXT(int target, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int format, int type, MemorySegment pixels) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetnPixelMapusv(int map, int bufSize, MemorySegment values) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetUniformfv(int program, int location, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBinormal3dEXT(double bx, double by, double bz) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glPathFogGenNV(int genMode) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDepthRangeIndexedfOES(int index, float n, float f) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public int glGetSubroutineIndex(int program, int shadertype, MemorySegment name) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBitmapxOES(int width, int height, int xorig, int yorig, int xmove, int ymove, MemorySegment bitmap) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexArrayVertexAttribDivisorEXT(int vaobj, int index, int divisor) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramStringARB(int target, int format, int len, MemorySegment string) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttrib3svNV(int index, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public long glGetTextureHandleARB(int texture) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttrib4bvARB(int index, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttrib2svARB(int index, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexCoord2ivARB(int target, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDepthRangeIndexedfNV(int index, float n, float f) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glColorFragmentOp2ATI(int op, int dst, int dstMask, int dstMod, int arg1, int arg1Rep, int arg1Mod, int arg2, int arg2Rep, int arg2Mod) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFramebufferSampleLocationsfvARB(int target, int start, int count, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexCoord2fNormal3fVertex3fSUN(float s, float t, float nx, float ny, float nz, float x, float y, float z) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetQueryBufferObjectui64v(int id, int buffer, int pname, long offset) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFramebufferTexture2DMultisampleIMG(int target, int attachment, int textarget, int texture, int level, int samples) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glPathCoverDepthFuncNV(int func) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttrib3hvNV(int index, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribI1uivEXT(int index, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public int glGetSubroutineUniformLocation(int program, int shadertype, MemorySegment name) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public byte glIsFramebufferEXT(int framebuffer) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniformMatrix2dvEXT(int program, int location, int count, byte transpose, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBlitNamedFramebuffer(int readFramebuffer, int drawFramebuffer, int srcX0, int srcY0, int srcX1, int srcY1, int dstX0, int dstY0, int dstX1, int dstY1, int mask, int filter) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVariantivEXT(int id, MemorySegment addr) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetBooleani_v(int target, int index, MemorySegment data) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetQueryiv(int target, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetVariantBooleanvEXT(int id, int value, MemorySegment data) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBindBufferBaseEXT(int target, int index, int buffer) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexStream4ivATI(int stream, MemorySegment coords) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glStencilStrokePathNV(int path, int reference, int mask) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetnHistogram(int target, byte reset, int format, int type, int bufSize, MemorySegment values) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUseProgramObjectARB(MemorySegment programObj) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetActiveAtomicCounterBufferiv(int program, int bufferIndex, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexCoord4fColor4fNormal3fVertex4fvSUN(MemorySegment tc, MemorySegment c, MemorySegment n, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMapNamedBufferRangeEXT(int buffer, long offset, long length, int access) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGenProgramsARB(int n, MemorySegment programs) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glEndTransformFeedbackNV() {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniform1ui64NV(int program, int location, long x) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramEnvParameter4fvARB(int target, int index, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertex3hvNV(MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetVideouivNV(int video_slot, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glPointParameterxv(int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetnPixelMapuivARB(int map, int bufSize, MemorySegment values) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public byte glIsTextureHandleResidentARB(long handle) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glNamedFramebufferDrawBuffer(int framebuffer, int buf) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTextureStorage3DEXT(int texture, int target, int levels, int internalformat, int width, int height, int depth) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniform1i64vARB(int location, int count, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetObjectBufferfvATI(int buffer, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public int glPollInstrumentsSGIX(MemorySegment marker_p) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetDriverControlStringQCOM(int driverControl, int bufSize, MemorySegment length, MemorySegment driverControlString) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFramebufferParameteri(int target, int pname, int param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGenFencesAPPLE(int n, MemorySegment fences) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glViewportArrayv(int first, int count, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetObjectParameterivARB(MemorySegment obj, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexImage3DMultisampleCoverageNV(int target, int coverageSamples, int colorSamples, int internalFormat, int width, int height, int depth, byte fixedSampleLocations) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniformMatrix2x3fv(int program, int location, int count, byte transpose, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMapGrid1xOES(int n, int u1, int u2) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetPerfMonitorCountersAMD(int group, MemorySegment numCounters, MemorySegment maxActiveCounters, int counterSize, MemorySegment counters) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFramebufferTextureFaceARB(int target, int attachment, int texture, int level, int face) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTangent3sEXT(short tx, short ty, short tz) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexStorageMem2DEXT(int target, int levels, int internalFormat, int width, int height, int memory, long offset) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetnPixelMapuiv(int map, int bufSize, MemorySegment values) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexCoordP2ui(int type, int coords) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetLightxvOES(int light, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexCoord4bvOES(int texture, MemorySegment coords) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glPolygonOffsetxOES(int factor, int units) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glNamedProgramLocalParameter4fvEXT(int program, int target, int index, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glClearTexSubImage(int texture, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int format, int type, MemorySegment data) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribI2iEXT(int index, int x, int y) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFramebufferTextureLayer(int target, int attachment, int texture, int level, int layer) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetVertexAttribLdv(int index, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexP4uiv(int type, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glReplacementCodeuiColor3fVertex3fSUN(int rc, float r, float g, float b, float x, float y, float z) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetTexParameterxv(int target, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMulticastViewportArrayvNVX(int gpu, int first, int count, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glSampleCoveragexOES(int value, byte invert) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glReplacementCodeuiVertex3fvSUN(MemorySegment rc, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDeleteFencesNV(int n, MemorySegment fences) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetSamplerParameterIiv(int sampler, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribPointerNV(int index, int fsize, int type, int stride, MemorySegment pointer) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexStream4sATI(int stream, short x, short y, short z, short w) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniformMatrix2x3dv(int program, int location, int count, byte transpose, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBlendBarrier() {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFramebufferTexture2DEXT(int target, int attachment, int textarget, int texture, int level) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glPolygonOffsetClamp(float factor, float units, float clamp) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexCoord3bvOES(MemorySegment coords) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniformMatrix3x2fvNV(int location, int count, byte transpose, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniform1i64vNV(int program, int location, int count, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glPathGlyphRangeNV(int firstPathName, int fontTarget, MemorySegment fontName, int fontStyle, int firstGlyph, int numGlyphs, int handleMissingGlyphs, int pathParameterTemplate, float emScale) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glPopDebugGroupKHR() {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexArrayBindingDivisor(int vaobj, int bindingindex, int divisor) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramBufferParametersIuivNV(int target, int bindingIndex, int wordIndex, int count, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBinormalPointerEXT(int type, int stride, MemorySegment pointer) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glStencilFillPathNV(int path, int fillMode, int mask) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glReplacementCodeuiNormal3fVertex3fvSUN(MemorySegment rc, MemorySegment n, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniform2ui64vARB(int location, int count, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDrawElementsInstancedBaseVertexOES(int mode, int count, int type, MemorySegment indices, int instancecount, int basevertex) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexStream3fATI(int stream, float x, float y, float z) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glCombinerParameteriNV(int pname, int param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public int glGetGraphicsResetStatus() {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttrib4ivARB(int index, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glNamedProgramLocalParameterI4uivEXT(int program, int target, int index, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glEnableVertexArrayAttribEXT(int vaobj, int index) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glPointParameterivNV(int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glWindowPos3dMESA(double x, double y, double z) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glReadInstrumentsSGIX(int marker) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glNormalPointerEXT(int type, int stride, int count, MemorySegment pointer) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glRasterPos3xvOES(MemorySegment coords) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniform3ui(int location, int v0, int v1, int v2) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMatrixScaledEXT(int mode, double x, double y, double z) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glCopyTextureSubImage3D(int texture, int level, int xoffset, int yoffset, int zoffset, int x, int y, int width, int height) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetPathColorGenivNV(int color, int pname, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniform1d(int program, int location, double v0) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public byte glUnmapNamedBuffer(int buffer) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDrawArraysInstancedEXT(int mode, int start, int count, int primcount) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniform1f(int program, int location, float v0) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniform1i(int program, int location, int v0) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFrameTerminatorGREMEDY() {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexStream2svATI(int stream, MemorySegment coords) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFrameZoomSGIX(int factor) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetTextureImage(int texture, int level, int format, int type, int bufSize, MemorySegment pixels) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glPixelTransformParameterfvEXT(int target, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public int glGetVkProcAddrNV(MemorySegment name) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glCopyTextureSubImage2D(int texture, int level, int xoffset, int yoffset, int x, int y, int width, int height) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public byte glIsBufferResidentNV(int target) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public int glClientWaitSyncAPPLE(MemorySegment sync, int flags, long timeout) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexStream2dATI(int stream, double x, double y) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glCopyImageSubDataNV(int srcName, int srcTarget, int srcLevel, int srcX, int srcY, int srcZ, int dstName, int dstTarget, int dstLevel, int dstX, int dstY, int dstZ, int width, int height, int depth) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glActiveShaderProgramEXT(int pipeline, int program) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glColorP3uiv(int type, MemorySegment color) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public int glClientWaitSync(MemorySegment sync, int flags, long timeout) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glReplacementCodeuiTexCoord2fVertex3fSUN(int rc, float s, float t, float x, float y, float z) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetVertexArrayIntegeri_vEXT(int vaobj, int index, int pname, MemorySegment param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glScissorExclusiveArrayvNV(int first, int count, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttrib4fvARB(int index, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexParameterIivEXT(int target, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribL4dEXT(int index, double x, double y, double z, double w) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glCompressedTexImage1DARB(int target, int level, int internalformat, int width, int border, int imageSize, MemorySegment data) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glCopyTextureSubImage1D(int texture, int level, int xoffset, int x, int y, int width) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribI1uiv(int index, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glPatchParameteriEXT(int pname, int value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexPageCommitmentEXT(int target, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, byte commit) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniform2uivEXT(int program, int location, int count, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexImage2DEXT(int texunit, int target, int level, int internalformat, int width, int height, int border, int format, int type, MemorySegment pixels) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetRenderbufferParameteriv(int target, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glColor3xOES(int red, int green, int blue) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glEnableVertexAttribAPPLE(int index, int pname) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTangent3svEXT(MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glAttachShader(int program, int shader) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetNamedProgramLocalParameterIuivEXT(int program, int target, int index, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glPatchParameterfv(int pname, MemorySegment values) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetTexParameterPointervAPPLE(int target, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glNormalFormatNV(int type, int stride) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMemoryBarrierByRegion(int barriers) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetSeparableFilter(int target, int format, int type, MemorySegment row, MemorySegment column, MemorySegment span) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexCoord4fColor4fNormal3fVertex4fSUN(float s, float t, float p, float q, float r, float g, float b, float a, float nx, float ny, float nz, float x, float y, float z, float w) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glNormalStream3bvATI(int stream, MemorySegment coords) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public int glGenPathsNV(int range) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetNamedProgramivEXT(int program, int target, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexP4ui(int type, int value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribL2dvEXT(int index, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public int glGetGraphicsResetStatusARB() {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertex3bvOES(MemorySegment coords) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetTextureParameterfvEXT(int texture, int target, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexParameterIuivOES(int target, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramNamedParameter4dvNV(int id, int len, MemorySegment name, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glWindowPos2iARB(int x, int y) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetFramebufferParameteriv(int target, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexCoord1xvOES(int texture, MemorySegment coords) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDepthRangeArraydvNV(int first, int count, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniformHandleui64ARB(int location, long value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glSpecializeShader(int shader, MemorySegment pEntryPoint, int numSpecializationConstants, MemorySegment pConstantIndex, MemorySegment pConstantValue) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexBlendEnvfATI(int pname, float param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramParameter4dNV(int target, int index, double x, double y, double z, double w) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glObjectLabelKHR(int identifier, int name, int length, MemorySegment label) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetMultisamplefvNV(int pname, int index, MemorySegment val) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glEndQueryEXT(int target) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBindVertexArrayAPPLE(int array) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetQueryBufferObjectuiv(int id, int buffer, int pname, long offset) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniform2iARB(int location, int v0, int v1) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexBufferRange(int target, int internalformat, int buffer, long offset, long size) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniformMatrix4x3fvEXT(int program, int location, int count, byte transpose, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glSpriteParameteriSGIX(int pname, int param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDrawArraysInstancedBaseInstance(int mode, int first, int count, int instancecount, int baseinstance) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexParameterIivOES(int target, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetRenderbufferParameterivEXT(int target, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetUniformuivEXT(int program, int location, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribL3ui64NV(int index, long x, long y, long z) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetnHistogramARB(int target, byte reset, int format, int type, int bufSize, MemorySegment values) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glSecondaryColor3iv(MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glWindowPos2dARB(double x, double y) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public byte glIsPointInStrokePathNV(int path, float x, float y) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBlendFuncSeparateOES(int srcRGB, int dstRGB, int srcAlpha, int dstAlpha) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glReadBufferIndexedEXT(int src, int index) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetFramebufferParameterivEXT(int framebuffer, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramEnvParametersI4ivNV(int target, int index, int count, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetNamedFramebufferAttachmentParameteriv(int framebuffer, int attachment, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glEndVideoCaptureNV(int video_capture_slot) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMatrixLoaddEXT(int mode, MemorySegment m) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glWindowPos3fARB(float x, float y, float z) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glWindowPos2svARB(MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetOcclusionQueryuivNV(int id, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetTextureSubImage(int texture, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int format, int type, int bufSize, MemorySegment pixels) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexArrayNormalOffsetEXT(int vaobj, int buffer, int type, int stride, long offset) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetTransformFeedbackVaryingEXT(int program, int index, int bufSize, MemorySegment length, MemorySegment size, MemorySegment type, MemorySegment name) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProvokingVertexEXT(int mode) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniform2ui64vNV(int program, int location, int count, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTrackMatrixNV(int target, int address, int matrix, int transform) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexCoord2fColor4fNormal3fVertex3fSUN(float s, float t, float r, float g, float b, float a, float nx, float ny, float nz, float x, float y, float z) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glConvolutionParameteriv(int target, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glRasterPos2xOES(int x, int y) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribL3i64vNV(int index, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glResetHistogramEXT(int target) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFlushRasterSGIX() {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetCombinerInputParameterfvNV(int stage, int portion, int variable, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexCoord3xOES(int texture, int s, int t, int r) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glSpriteParameterfSGIX(int pname, float param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetVertexArrayiv(int vaobj, int pname, MemorySegment param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribs3dvNV(int index, int count, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniformHandleui64vNV(int location, int count, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttrib4Nubv(int index, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexFormatNV(int size, int type, int stride) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public long glGetTextureHandleIMG(int texture) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttrib4ubv(int index, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMulticastFramebufferSampleLocationsfvNV(int gpu, int framebuffer, int start, int count, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public int glGetProgramResourceIndex(int program, int programInterface, MemorySegment name) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramEnvParametersI4uivNV(int target, int index, int count, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramParameter4fNV(int target, int index, float x, float y, float z, float w) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexParameterfvEXT(int texunit, int target, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexCoord3bOES(int texture, byte s, byte t, byte r) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetTextureParameterIuiv(int texture, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public int glQueryMatrixxOES(MemorySegment mantissa, MemorySegment exponent) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexP3ui(int type, int value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetPathMetricRangeNV(int metricQueryMask, int firstPathName, int numPaths, int stride, MemorySegment metrics) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexBufferEXT(int texunit, int target, int internalformat, int buffer) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetnPolygonStippleARB(int bufSize, MemorySegment pattern) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexCoord3hNV(int target, short s, short t, short r) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glAlphaToCoverageDitherControlNV(int mode) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribIFormat(int attribindex, int size, int type, int relativeoffset) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniform2d(int location, double x, double y) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glPixelZoomxOES(int xfactor, int yfactor) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniform2f(int location, float v0, float v1) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttrib4ubvARB(int index, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glColor4hvNV(MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniform2i(int location, int v0, int v1) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexCoord1fvARB(int target, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glEnableDriverControlQCOM(int driverControl) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFragmentMaterialiSGIX(int face, int pname, int param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetVertexAttribPointervARB(int index, int pname, MemorySegment pointer) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMapTexture2DINTEL(int texture, int level, int access, MemorySegment stride, MemorySegment layout) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniform4ui(int program, int location, int v0, int v1, int v2, int v3) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGenBuffersARB(int n, MemorySegment buffers) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribP2uiv(int index, int type, byte normalized, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniform3d(int location, double x, double y, double z) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glClientActiveVertexStreamATI(int stream) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniform3f(int location, float v0, float v1, float v2) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniform2fv(int location, int count, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniform3i(int location, int v0, int v1, int v2) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glSecondaryColor3fv(MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDrawElementsInstancedNV(int mode, int count, int type, MemorySegment indices, int primcount) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniform4d(int location, double x, double y, double z, double w) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glCopyTextureImage2DEXT(int texture, int target, int level, int internalformat, int x, int y, int width, int height, int border) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniform3ivEXT(int program, int location, int count, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public byte glIsQueryEXT(int id) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glStateCaptureNV(int state, int mode) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetQueryIndexediv(int target, int index, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glWindowPos3svMESA(MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glEvalCoord2xOES(int u, int v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetActiveSubroutineUniformName(int program, int shadertype, int index, int bufSize, MemorySegment length, MemorySegment name) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexBumpParameterfvATI(int pname, MemorySegment param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniform1i64ARB(int location, int x) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetObjectParameterfvARB(MemorySegment obj, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniform2iv(int location, int count, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBindFragDataLocationIndexed(int program, int colorNumber, int index, MemorySegment name) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniform2ivEXT(int program, int location, int count, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexWeighthvNV(MemorySegment weight) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetQueryBufferObjecti64v(int id, int buffer, int pname, long offset) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glReplacementCodeuiVertex3fSUN(int rc, float x, float y, float z) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glClipPlanexOES(int plane, MemorySegment equation) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttrib1dNV(int index, double x) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniform1uiEXT(int location, int v0) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glStencilThenCoverStrokePathInstancedNV(int numPaths, int pathNameType, MemorySegment paths, int pathBase, int reference, int mask, int coverMode, int transformType, MemorySegment transformValues) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glPrimitiveRestartIndexNV(int index) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glPointParameterxOES(int pname, int param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniform1d(int location, double x) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTextureParameteri(int texture, int pname, int param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniform1f(int location, float v0) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDisablei(int target, int index) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTextureParameterf(int texture, int pname, float param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniform1i(int location, int v0) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glColorTable(int target, int internalformat, int width, int format, int type, MemorySegment table) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBindBuffersBase(int target, int first, int count, MemorySegment buffers) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glExtGetBufferPointervQCOM(int target, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public byte glIsEnablediOES(int target, int index) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetCompressedMultiTexImageEXT(int texunit, int target, int lod, MemorySegment img) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttrib4NubARB(int index, byte x, byte y, byte z, byte w) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetnConvolutionFilter(int target, int format, int type, int bufSize, MemorySegment image) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMatrixIndexusvARB(int size, MemorySegment indices) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribI4i(int index, int x, int y, int z, int w) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTextureStorage2DMultisample(int texture, int samples, int internalformat, int width, int height, byte fixedsamplelocations) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMapNamedBuffer(int buffer, int access) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetFloati_vEXT(int pname, int index, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetObjectLabel(int identifier, int name, int bufSize, MemorySegment length, MemorySegment label) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetPerfQueryIdByNameINTEL(MemorySegment queryName, MemorySegment queryId) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glSecondaryColor3bv(MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiDrawArraysIndirectEXT(int mode, MemorySegment indirect, int drawcount, int stride) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDrawElementArrayATI(int mode, int count) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMemoryBarrier(int barriers) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniform1uiv(int location, int count, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetnPolygonStipple(int bufSize, MemorySegment pattern) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribDivisorEXT(int index, int divisor) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMapBufferOES(int target, int access) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTextureStorageSparseAMD(int texture, int target, int internalFormat, int width, int height, int depth, int layers, int flags) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFogCoordhvNV(MemorySegment fog) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glSamplerParameterIuiv(int sampler, int pname, MemorySegment param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDeleteFragmentShaderATI(int id) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribI2i(int index, int x, int y) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDeleteSync(MemorySegment sync) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public byte glIsNamedStringARB(int namelen, MemorySegment name) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public float glGetPathLengthNV(int path, int startSegment, int numSegments) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBindFramebufferOES(int target, int framebuffer) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glActiveVaryingNV(int program, MemorySegment name) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniform2dv(int location, int count, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glNamedProgramLocalParameterI4ivEXT(int program, int target, int index, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glSecondaryColor3dv(MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexBufferRangeOES(int target, int internalformat, int buffer, long offset, long size) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFramebufferTexture2DDownsampleIMG(int target, int attachment, int textarget, int texture, int level, int xscale, int yscale) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniform1ivARB(int location, int count, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glColorP4ui(int type, int color) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glCompressedMultiTexSubImage1DEXT(int texunit, int target, int level, int xoffset, int width, int format, int imageSize, MemorySegment bits) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttrib4uiv(int index, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribI3i(int index, int x, int y, int z) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetPerfMonitorCounterDataAMD(int monitor, int pname, int dataSize, MemorySegment data, MemorySegment bytesWritten) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBindProgramNV(int target, int id) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDeleteSamplers(int count, MemorySegment samplers) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetProgramEnvParameterIivNV(int target, int index, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glClearColorIuiEXT(int red, int green, int blue, int alpha) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribs4fvNV(int index, int count, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniformMatrix3x4dv(int program, int location, int count, byte transpose, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniformHandleui64vARB(int location, int count, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVideoCaptureStreamParameterfvNV(int video_capture_slot, int stream, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glPathTexGenNV(int texCoordSet, int genMode, int components, MemorySegment coeffs) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glImageTransformParameterfHP(int target, int pname, float param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glNormal3xvOES(MemorySegment coords) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniform4dvEXT(int program, int location, int count, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetTexGenfvOES(int coord, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glPixelDataRangeNV(int target, int length, MemorySegment pointer) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glPointParameterfvARB(int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribLPointer(int index, int size, int type, int stride, MemorySegment pointer) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetPerfQueryDataINTEL(int queryHandle, int flags, int dataSize, MemorySegment data, MemorySegment bytesWritten) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetMapParameterfvNV(int target, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetMinmaxParameterfvEXT(int target, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBindFragmentShaderATI(int id) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribI1i(int index, int x) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttrib3sNV(int index, short x, short y, short z) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttrib3fvARB(int index, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniform4ui64vARB(int program, int location, int count, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramBinary(int program, int binaryFormat, MemorySegment binary, int length) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniformMatrix2fvARB(int location, int count, byte transpose, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribP2ui(int index, int type, byte normalized, int value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFogCoordfEXT(float coord) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexStream4fvATI(int stream, MemorySegment coords) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramEnvParameter4fARB(int target, int index, float x, float y, float z, float w) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glSecondaryColor3usEXT(short red, short green, short blue) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glConvolutionParameterfv(int target, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glCommandListSegmentsNV(int list, int segments) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMakeTextureHandleNonResidentARB(long handle) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDrawTexsOES(short x, short y, short z, short width, short height) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public byte glUnmapBufferOES(int target) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertex4bvOES(MemorySegment coords) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glWindowPos2dvARB(MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glCompressedTexSubImage3DARB(int target, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int format, int imageSize, MemorySegment data) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDrawElementsIndirect(int mode, int type, MemorySegment indirect) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glReplacementCodeusSUN(short code) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniformMatrix2x4fvNV(int location, int count, byte transpose, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBindBufferOffsetEXT(int target, int index, int buffer, long offset) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glExtGetTexturesQCOM(MemorySegment textures, int maxTextures, MemorySegment numTextures) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glScissorArrayvOES(int first, int count, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glRasterPos4xvOES(MemorySegment coords) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexArrayVertexAttribIOffsetEXT(int vaobj, int buffer, int index, int size, int type, int stride, long offset) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetMinmaxEXT(int target, byte reset, int format, int type, MemorySegment values) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetPathColorGenfvNV(int color, int pname, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glWindowPos4dMESA(double x, double y, double z, double w) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribL4ui64vNV(int index, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBlendFuncSeparatei(int buf, int srcRGB, int dstRGB, int srcAlpha, int dstAlpha) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glCreateProgramPipelines(int n, MemorySegment pipelines) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFogxOES(int pname, int param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexImage2DMultisample(int target, int samples, int internalformat, int width, int height, byte fixedsamplelocations) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public int glObjectPurgeableAPPLE(int objectType, int name, int option) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glViewportSwizzleNV(int index, int swizzlex, int swizzley, int swizzlez, int swizzlew) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexCoord3fARB(int target, float s, float t, float r) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDisableClientStateiEXT(int array, int index) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetShadingRateImagePaletteNV(int viewport, int entry, MemorySegment rate) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribL1i64NV(int index, long x) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTextureSubImage2DEXT(int texture, int target, int level, int xoffset, int yoffset, int width, int height, int format, int type, MemorySegment pixels) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFragmentLightfSGIX(int light, int pname, float param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGlobalAlphaFactorbSUN(byte factor) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexStream3iATI(int stream, int x, int y, int z) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public int glBindParameterEXT(int value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDrawElementsBaseVertexEXT(int mode, int count, int type, MemorySegment indices, int basevertex) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexArrayRangeAPPLE(int length, MemorySegment pointer) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetColorTableParameterfvEXT(int target, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glRasterSamplesEXT(int samples, byte fixedsamplelocations) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glNormalStream3dATI(int stream, double nx, double ny, double nz) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniform4i64NV(int program, int location, long x, long y, long z, long w) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetVertexAttribdvNV(int index, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniform2ui64ARB(int location, long x, long y) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetProgramLocalParameterdvARB(int target, int index, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public byte glIsSyncAPPLE(MemorySegment sync) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttrib4usv(int index, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetQueryObjectuivARB(int id, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFogFuncSGIS(int n, MemorySegment points) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniformMatrix3x4fv(int program, int location, int count, byte transpose, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFramebufferReadBufferEXT(int framebuffer, int mode) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTextureParameterfv(int texture, int pname, MemorySegment param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetMaterialxvOES(int face, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexCoord2dARB(int target, double s, double t) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public int glGetUniformBlockIndex(int program, MemorySegment uniformBlockName) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glInvalidateBufferData(int buffer) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTransformFeedbackBufferBase(int xfb, int index, int buffer) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glPolygonModeNV(int face, int mode) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glNamedFramebufferSampleLocationsfvARB(int framebuffer, int start, int count, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexArrayAttribBinding(int vaobj, int attribindex, int bindingindex) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTextureStorageMem2DMultisampleEXT(int texture, int samples, int internalFormat, int width, int height, byte fixedSampleLocations, int memory, long offset) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetNamedBufferPointervEXT(int buffer, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniformMatrix3x4fv(int location, int count, byte transpose, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetTexEnvxv(int target, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glCompressedTexImage3D(int target, int level, int internalformat, int width, int height, int depth, int border, int imageSize, MemorySegment data) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexCoord1hvNV(int target, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public byte glUnmapBuffer(int target) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTranslatex(int x, int y, int z) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexParameterIuivEXT(int texunit, int target, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexCoord3xvOES(MemorySegment coords) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetnTexImage(int target, int level, int format, int type, int bufSize, MemorySegment pixels) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glReadnPixelsEXT(int x, int y, int width, int height, int format, int type, int bufSize, MemorySegment data) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribL1dvEXT(int index, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glCopyMultiTexSubImage1DEXT(int texunit, int target, int level, int xoffset, int x, int y, int width) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexCoord3xOES(int s, int t, int r) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniform4dv(int program, int location, int count, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetConvolutionFilter(int target, int format, int type, MemorySegment image) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glConservativeRasterParameteriNV(int pname, int param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glEnableIndexedEXT(int target, int index) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniformMatrix3x4dv(int location, int count, byte transpose, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glPointParameterfARB(int pname, float param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetClipPlanex(int plane, MemorySegment equation) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexCoord4sARB(int target, short s, short t, short r, short q) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetnCompressedTexImage(int target, int lod, int bufSize, MemorySegment pixels) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glNormalStream3ivATI(int stream, MemorySegment coords) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGenFramebuffersOES(int n, MemorySegment framebuffers) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribLFormatNV(int index, int size, int type, int stride) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glShaderOp2EXT(int op, int res, int arg1, int arg2) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetActiveSubroutineName(int program, int shadertype, int index, int bufSize, MemorySegment length, MemorySegment name) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetClipPlanef(int plane, MemorySegment equation) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glNamedProgramStringEXT(int program, int target, int format, int len, MemorySegment string) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniformMatrix4fvEXT(int program, int location, int count, byte transpose, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMatrixFrustumEXT(int mode, double left, double right, double bottom, double top, double zNear, double zFar) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexCoordP1ui(int type, int coords) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glCompressedTexImage1D(int target, int level, int internalformat, int width, int border, int imageSize, MemorySegment data) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetTexEnvxvOES(int target, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexCoord3bOES(byte s, byte t, byte r) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glStencilOpSeparate(int face, int sfail, int dpfail, int dppass) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glPixelTransformParameterfEXT(int target, int pname, float param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glConvolutionParameterfEXT(int target, int pname, float params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetFloati_vOES(int target, int index, MemorySegment data) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetProgramLocalParameterIivNV(int target, int index, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetMinmax(int target, byte reset, int format, int type, MemorySegment values) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFogCoordfvEXT(MemorySegment coord) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glSetFenceNV(int fence, int condition) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribI2ivEXT(int index, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glCompressedTexImage2D(int target, int level, int internalformat, int width, int height, int border, int imageSize, MemorySegment data) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexCoord4dvARB(int target, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glLoadProgramNV(int target, int id, int len, MemorySegment program) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFramebufferPixelLocalStorageSizeEXT(int target, int size) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetTextureParameterIuivEXT(int texture, int target, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDepthRangeIndexed(int index, double n, double f) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glConvolutionParameterfvEXT(int target, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniform1uivEXT(int location, int count, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDeleteBuffers(int n, MemorySegment buffers) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glNamedProgramLocalParameterI4iEXT(int program, int target, int index, int x, int y, int z, int w) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glIndexxvOES(MemorySegment component) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexStorage1DEXT(int target, int levels, int internalformat, int width) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glCopyTexSubImage3D(int target, int level, int xoffset, int yoffset, int zoffset, int x, int y, int width, int height) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetnSeparableFilter(int target, int format, int type, int rowBufSize, MemorySegment row, int columnBufSize, MemorySegment column, MemorySegment span) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glNormalP3ui(int type, int coords) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glCompileCommandListNV(int list) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public int glGetGraphicsResetStatusKHR() {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttrib4NivARB(int index, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public byte glIsObjectBufferATI(int buffer) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glNamedBufferAttachMemoryNV(int buffer, int memory, long offset) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glReplacementCodeusvSUN(MemorySegment code) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glIglooInterfaceSGIX(int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glReadBufferNV(int mode) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetCombinerStageParameterfvNV(int stage, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDrawElementsInstancedBaseVertexBaseInstance(int mode, int count, int type, MemorySegment indices, int instancecount, int basevertex, int baseinstance) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGenerateMipmapEXT(int target) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexArrayEdgeFlagOffsetEXT(int vaobj, int buffer, int stride, long offset) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDrawRangeElementsEXT(int mode, int start, int end, int count, int type, MemorySegment indices) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniform4iv(int program, int location, int count, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribI4ubv(int index, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public byte glIsFramebufferOES(int framebuffer) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDrawTexsvOES(MemorySegment coords) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glStencilFuncSeparate(int face, int func, int ref, int mask) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribs1hvNV(int index, int n, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetProgramEnvParameterdvARB(int target, int index, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public int glCheckNamedFramebufferStatusEXT(int framebuffer, int target) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetInteger64i_v(int target, int index, MemorySegment data) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribs1svNV(int index, int count, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glClearTexSubImageEXT(int texture, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int format, int type, MemorySegment data) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glReplacementCodeuiColor4ubVertex3fSUN(int rc, byte r, byte g, byte b, byte a, float x, float y, float z) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetTextureLevelParameteriv(int texture, int level, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexPageCommitmentMemNV(int target, int layer, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int memory, long offset, byte commit) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGenProgramPipelinesEXT(int n, MemorySegment pipelines) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glPixelStorex(int pname, int param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glRotatexOES(int angle, int x, int y, int z) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniform4fv(int program, int location, int count, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glSecondaryColor3sv(MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttrib1svARB(int index, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDrawCommandsNV(int primitiveMode, int buffer, MemorySegment indirects, MemorySegment sizes, int count) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glReplacementCodeuiTexCoord2fColor4fNormal3fVertex3fvSUN(MemorySegment rc, MemorySegment tc, MemorySegment c, MemorySegment n, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glPathColorGenNV(int color, int genMode, int colorFormat, MemorySegment coeffs) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexWeightfEXT(float weight) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexBufferEXT(int target, int internalformat, int buffer) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMatrixMultTransposefEXT(int mode, MemorySegment m) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVDPAUUnregisterSurfaceNV(int surface) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiDrawRangeElementArrayAPPLE(int mode, int start, int end, MemorySegment first, MemorySegment count, int primcount) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribL1ui64NV(int index, long x) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public int glGetUniformBufferSizeEXT(int program, int location) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glSecondaryColor3ivEXT(MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertex2hNV(short x, short y) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glSpriteParameterivSGIX(int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glValidateProgramPipeline(int pipeline) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetCombinerInputParameterivNV(int stage, int portion, int variable, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetProgramPipelineiv(int pipeline, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glRenderbufferStorageMultisampleCoverageNV(int target, int coverageSamples, int colorSamples, int internalformat, int width, int height) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetNamedFramebufferAttachmentParameterivEXT(int framebuffer, int attachment, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glWindowPos2iMESA(int x, int y) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDrawRangeElementArrayAPPLE(int mode, int start, int end, int first, int count) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetProgramivARB(int target, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetPointervKHR(int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public int glGenVertexShadersEXT(int range) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glSecondaryColor3ub(byte red, byte green, byte blue) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glEvalCoord2xvOES(MemorySegment coords) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTextureParameterIuivEXT(int texture, int target, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniform2ui(int location, int v0, int v1) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramParameteriEXT(int program, int pname, int value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glPointSizePointerOES(int type, int stride, MemorySegment pointer) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glSecondaryColor3ui(int red, int green, int blue) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBlendEquationi(int buf, int mode) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glSecondaryColor3us(short red, short green, short blue) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMaterialxv(int face, int pname, MemorySegment param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glWindowRectanglesEXT(int mode, int count, MemorySegment box) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttrib1fARB(int index, float x) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetConvolutionFilterEXT(int target, int format, int type, MemorySegment image) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetNamedProgramLocalParameterIivEXT(int program, int target, int index, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glCopyTexSubImage3DEXT(int target, int level, int xoffset, int yoffset, int zoffset, int x, int y, int width, int height) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glEndConditionalRender() {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetShadingRateSampleLocationivNV(int rate, int samples, int index, MemorySegment location) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetBufferParameterui64vNV(int target, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glPNTrianglesfATI(int pname, float param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetVideoCaptureStreamdvNV(int video_capture_slot, int stream, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramEnvParameters4fvEXT(int target, int index, int count, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGenSamplers(int count, MemorySegment samplers) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public byte glIsTextureEXT(int texture) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public MemorySegment glCreateSyncFromCLeventARB(MemorySegment context, MemorySegment event, int flags) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glSeparableFilter2DEXT(int target, int internalformat, int width, int height, int format, int type, MemorySegment row, MemorySegment column) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDebugMessageCallback(MemorySegment callback, MemorySegment userParam) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFramebufferTextureARB(int target, int attachment, int texture, int level) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glSecondaryColorPointer(int size, int type, int stride, MemorySegment pointer) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glAlphaFragmentOp2ATI(int op, int dst, int dstMod, int arg1, int arg1Rep, int arg1Mod, int arg2, int arg2Rep, int arg2Mod) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniform4ui64ARB(int program, int location, long x, long y, long z, long w) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexParameteriEXT(int texunit, int target, int pname, int param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetQueryObjecti64vEXT(int id, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glCompressedTextureImage1DEXT(int texture, int target, int level, int internalformat, int width, int border, int imageSize, MemorySegment bits) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFogCoordPointer(int type, int stride, MemorySegment pointer) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glWindowPos4sMESA(short x, short y, short z, short w) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniform2iEXT(int program, int location, int v0, int v1) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexCoord2fNormal3fVertex3fvSUN(MemorySegment tc, MemorySegment n, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFramebufferTextureMultiviewOVR(int target, int attachment, int texture, int level, int baseViewIndex, int numViews) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glInsertComponentEXT(int res, int src, int num) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexturePageCommitmentMemNV(int texture, int layer, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int memory, long offset, byte commit) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glPushDebugGroupKHR(int source, int id, int length, MemorySegment message) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribIPointer(int index, int size, int type, int stride, MemorySegment pointer) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetTransformFeedbackVaryingNV(int program, int index, MemorySegment location) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDepthBoundsdNV(double zmin, double zmax) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexStream1dvATI(int stream, MemorySegment coords) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFramebufferRenderbuffer(int target, int attachment, int renderbuffertarget, int renderbuffer) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glClearAccumxOES(int red, int green, int blue, int alpha) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVariantuivEXT(int id, MemorySegment addr) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glCombinerStageParameterfvNV(int stage, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public byte glAreProgramsResidentNV(int n, MemorySegment programs, MemorySegment residences) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glActiveTexture(int texture) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribFormat(int attribindex, int size, int type, byte normalized, int relativeoffset) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttrib2sARB(int index, short x, short y) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public int glBindMaterialParameterEXT(int face, int value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  @Override
  public void glutCheckLoop() {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void glutSurfaceTexture(int arg0, int arg1, int arg2) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public int gluBuild1DMipmapLevels(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5,
      int arg6, int arg7, MemorySegment arg8) {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public int gluBuild2DMipmapLevels(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5,
      int arg6, int arg7, int arg8, MemorySegment arg9) {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public int gluBuild3DMipmapLevels(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5,
      int arg6, int arg7, int arg8, int arg9, MemorySegment arg10) {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public int gluBuild3DMipmaps(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6,
      MemorySegment arg7) {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public byte gluCheckExtension(MemorySegment arg0, MemorySegment arg1) {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public void gluNurbsCallbackData(MemorySegment arg0, MemorySegment arg1) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void gluNurbsCallbackDataEXT(MemorySegment arg0, MemorySegment arg1) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public int gluUnProject4(double arg0, double arg1, double arg2, double arg3, MemorySegment arg4,
      MemorySegment arg5, MemorySegment arg6, double arg7, double arg8, MemorySegment arg9,
      MemorySegment arg10, MemorySegment arg11, MemorySegment arg12) {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public void glutBitmap8By13(MemorySegment arg0) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public MemorySegment glutBitmap9By15() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public MemorySegment glutBitmapHelvetica10() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void glutBitmapHelvetica12(MemorySegment arg0) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public MemorySegment glutBitmapHelvetica18() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public MemorySegment glutBitmapTimesRoman10() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public MemorySegment glutBitmapTimesRoman24() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void glutStrokeMonoRoman(MemorySegment arg0) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void glutStrokeRoman(MemorySegment arg0) {
    // TODO Auto-generated method stub
    
  }

}
