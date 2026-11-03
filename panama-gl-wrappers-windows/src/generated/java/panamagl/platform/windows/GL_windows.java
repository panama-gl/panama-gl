package panamagl.platform.windows; 

import java.lang.foreign.MemorySegment;
import opengl.glext.*;
import opengl.windows.gl_h;

public class GL_windows extends panamagl.opengl.AGL implements panamagl.opengl.GL, panamagl.opengl.GLU, panamagl.opengl.GLUT {
  public GL_windows() {
    setFunctionLoader(new panamagl.platform.windows.GLFunctionLoader_windows());
  }

  public void glAccum(int op, float value) {
    gl_h.glAccum(op, value);
  }

  public void glAlphaFunc(int func, float ref) {
    gl_h.glAlphaFunc(func, ref);
  }

  public byte glAreTexturesResident(int n, MemorySegment textures, MemorySegment residences) {
    return gl_h.glAreTexturesResident(n, textures, residences);
  }

  public void glArrayElement(int i) {
    gl_h.glArrayElement(i);
  }

  public void glBegin(int mode) {
    gl_h.glBegin(mode);
  }

  public void glBindTexture(int target, int texture) {
    gl_h.glBindTexture(target, texture);
  }

  public void glBitmap(int width, int height, float xorig, float yorig, float xmove, float ymove, MemorySegment bitmap) {
    gl_h.glBitmap(width, height, xorig, yorig, xmove, ymove, bitmap);
  }

  public void glBlendFunc(int sfactor, int dfactor) {
    gl_h.glBlendFunc(sfactor, dfactor);
  }

  public void glCallList(int list) {
    gl_h.glCallList(list);
  }

  public void glCallLists(int n, int type, MemorySegment lists) {
    gl_h.glCallLists(n, type, lists);
  }

  public void glClear(int mask) {
    gl_h.glClear(mask);
  }

  public void glClearAccum(float red, float green, float blue, float alpha) {
    gl_h.glClearAccum(red, green, blue, alpha);
  }

  public void glClearColor(float red, float green, float blue, float alpha) {
    gl_h.glClearColor(red, green, blue, alpha);
  }

  public void glClearDepth(double depth) {
    gl_h.glClearDepth(depth);
  }

  public void glClearIndex(float c) {
    gl_h.glClearIndex(c);
  }

  public void glClearStencil(int s) {
    gl_h.glClearStencil(s);
  }

  public void glClipPlane(int plane, MemorySegment equation) {
    gl_h.glClipPlane(plane, equation);
  }

  public void glColor3b(byte red, byte green, byte blue) {
    gl_h.glColor3b(red, green, blue);
  }

  public void glColor3bv(MemorySegment v) {
    gl_h.glColor3bv(v);
  }

  public void glColor3d(double red, double green, double blue) {
    gl_h.glColor3d(red, green, blue);
  }

  public void glColor3dv(MemorySegment v) {
    gl_h.glColor3dv(v);
  }

  public void glColor3f(float red, float green, float blue) {
    gl_h.glColor3f(red, green, blue);
  }

  public void glColor3fv(MemorySegment v) {
    gl_h.glColor3fv(v);
  }

  public void glColor3i(int red, int green, int blue) {
    gl_h.glColor3i(red, green, blue);
  }

  public void glColor3iv(MemorySegment v) {
    gl_h.glColor3iv(v);
  }

  public void glColor3s(short red, short green, short blue) {
    gl_h.glColor3s(red, green, blue);
  }

  public void glColor3sv(MemorySegment v) {
    gl_h.glColor3sv(v);
  }

  public void glColor3ub(byte red, byte green, byte blue) {
    gl_h.glColor3ub(red, green, blue);
  }

  public void glColor3ubv(MemorySegment v) {
    gl_h.glColor3ubv(v);
  }

  public void glColor3ui(int red, int green, int blue) {
    gl_h.glColor3ui(red, green, blue);
  }

  public void glColor3uiv(MemorySegment v) {
    gl_h.glColor3uiv(v);
  }

  public void glColor3us(short red, short green, short blue) {
    gl_h.glColor3us(red, green, blue);
  }

  public void glColor3usv(MemorySegment v) {
    gl_h.glColor3usv(v);
  }

  public void glColor4b(byte red, byte green, byte blue, byte alpha) {
    gl_h.glColor4b(red, green, blue, alpha);
  }

  public void glColor4bv(MemorySegment v) {
    gl_h.glColor4bv(v);
  }

  public void glColor4d(double red, double green, double blue, double alpha) {
    gl_h.glColor4d(red, green, blue, alpha);
  }

  public void glColor4dv(MemorySegment v) {
    gl_h.glColor4dv(v);
  }

  public void glColor4f(float red, float green, float blue, float alpha) {
    gl_h.glColor4f(red, green, blue, alpha);
  }

  public void glColor4fv(MemorySegment v) {
    gl_h.glColor4fv(v);
  }

  public void glColor4i(int red, int green, int blue, int alpha) {
    gl_h.glColor4i(red, green, blue, alpha);
  }

  public void glColor4iv(MemorySegment v) {
    gl_h.glColor4iv(v);
  }

  public void glColor4s(short red, short green, short blue, short alpha) {
    gl_h.glColor4s(red, green, blue, alpha);
  }

  public void glColor4sv(MemorySegment v) {
    gl_h.glColor4sv(v);
  }

  public void glColor4ub(byte red, byte green, byte blue, byte alpha) {
    gl_h.glColor4ub(red, green, blue, alpha);
  }

  public void glColor4ubv(MemorySegment v) {
    gl_h.glColor4ubv(v);
  }

  public void glColor4ui(int red, int green, int blue, int alpha) {
    gl_h.glColor4ui(red, green, blue, alpha);
  }

  public void glColor4uiv(MemorySegment v) {
    gl_h.glColor4uiv(v);
  }

  public void glColor4us(short red, short green, short blue, short alpha) {
    gl_h.glColor4us(red, green, blue, alpha);
  }

  public void glColor4usv(MemorySegment v) {
    gl_h.glColor4usv(v);
  }

  public void glColorMask(byte red, byte green, byte blue, byte alpha) {
    gl_h.glColorMask(red, green, blue, alpha);
  }

  public void glColorMaterial(int face, int mode) {
    gl_h.glColorMaterial(face, mode);
  }

  public void glColorPointer(int size, int type, int stride, MemorySegment pointer) {
    gl_h.glColorPointer(size, type, stride, pointer);
  }

  public void glCopyPixels(int x, int y, int width, int height, int type) {
    gl_h.glCopyPixels(x, y, width, height, type);
  }

  public void glCopyTexImage1D(int target, int level, int internalformat, int x, int y, int width, int border) {
    gl_h.glCopyTexImage1D(target, level, internalformat, x, y, width, border);
  }

  public void glCopyTexImage2D(int target, int level, int internalformat, int x, int y, int width, int height, int border) {
    gl_h.glCopyTexImage2D(target, level, internalformat, x, y, width, height, border);
  }

  public void glCopyTexSubImage1D(int target, int level, int xoffset, int x, int y, int width) {
    gl_h.glCopyTexSubImage1D(target, level, xoffset, x, y, width);
  }

  public void glCopyTexSubImage2D(int target, int level, int xoffset, int yoffset, int x, int y, int width, int height) {
    gl_h.glCopyTexSubImage2D(target, level, xoffset, yoffset, x, y, width, height);
  }

  public void glCullFace(int mode) {
    gl_h.glCullFace(mode);
  }

  public void glDeleteLists(int list, int range) {
    gl_h.glDeleteLists(list, range);
  }

  public void glDeleteTextures(int n, MemorySegment textures) {
    gl_h.glDeleteTextures(n, textures);
  }

  public void glDepthFunc(int func) {
    gl_h.glDepthFunc(func);
  }

  public void glDepthMask(byte flag) {
    gl_h.glDepthMask(flag);
  }

  public void glDepthRange(double n, double f) {
    gl_h.glDepthRange(n, f);
  }

  public void glDisable(int cap) {
    gl_h.glDisable(cap);
  }

  public void glDisableClientState(int array) {
    gl_h.glDisableClientState(array);
  }

  public void glDrawArrays(int mode, int first, int count) {
    gl_h.glDrawArrays(mode, first, count);
  }

  public void glDrawBuffer(int buf) {
    gl_h.glDrawBuffer(buf);
  }

  public void glDrawElements(int mode, int count, int type, MemorySegment indices) {
    gl_h.glDrawElements(mode, count, type, indices);
  }

  public void glDrawPixels(int width, int height, int format, int type, MemorySegment pixels) {
    gl_h.glDrawPixels(width, height, format, type, pixels);
  }

  public void glEdgeFlag(byte flag) {
    gl_h.glEdgeFlag(flag);
  }

  public void glEdgeFlagPointer(int stride, MemorySegment pointer) {
    gl_h.glEdgeFlagPointer(stride, pointer);
  }

  public void glEdgeFlagv(MemorySegment flag) {
    gl_h.glEdgeFlagv(flag);
  }

  public void glEnable(int cap) {
    gl_h.glEnable(cap);
  }

  public void glEnableClientState(int array) {
    gl_h.glEnableClientState(array);
  }

  public void glEnd() {
    gl_h.glEnd();
  }

  public void glEndList() {
    gl_h.glEndList();
  }

  public void glEvalCoord1d(double u) {
    gl_h.glEvalCoord1d(u);
  }

  public void glEvalCoord1dv(MemorySegment u) {
    gl_h.glEvalCoord1dv(u);
  }

  public void glEvalCoord1f(float u) {
    gl_h.glEvalCoord1f(u);
  }

  public void glEvalCoord1fv(MemorySegment u) {
    gl_h.glEvalCoord1fv(u);
  }

  public void glEvalCoord2d(double u, double v) {
    gl_h.glEvalCoord2d(u, v);
  }

  public void glEvalCoord2dv(MemorySegment u) {
    gl_h.glEvalCoord2dv(u);
  }

  public void glEvalCoord2f(float u, float v) {
    gl_h.glEvalCoord2f(u, v);
  }

  public void glEvalCoord2fv(MemorySegment u) {
    gl_h.glEvalCoord2fv(u);
  }

  public void glEvalMesh1(int mode, int i1, int i2) {
    gl_h.glEvalMesh1(mode, i1, i2);
  }

  public void glEvalMesh2(int mode, int i1, int i2, int j1, int j2) {
    gl_h.glEvalMesh2(mode, i1, i2, j1, j2);
  }

  public void glEvalPoint1(int i) {
    gl_h.glEvalPoint1(i);
  }

  public void glEvalPoint2(int i, int j) {
    gl_h.glEvalPoint2(i, j);
  }

  public void glFeedbackBuffer(int size, int type, MemorySegment buffer) {
    gl_h.glFeedbackBuffer(size, type, buffer);
  }

  public void glFinish() {
    gl_h.glFinish();
  }

  public void glFlush() {
    gl_h.glFlush();
  }

  public void glFogf(int pname, float param) {
    gl_h.glFogf(pname, param);
  }

  public void glFogfv(int pname, MemorySegment params) {
    gl_h.glFogfv(pname, params);
  }

  public void glFogi(int pname, int param) {
    gl_h.glFogi(pname, param);
  }

  public void glFogiv(int pname, MemorySegment params) {
    gl_h.glFogiv(pname, params);
  }

  public void glFrontFace(int mode) {
    gl_h.glFrontFace(mode);
  }

  public void glFrustum(double left, double right, double bottom, double top, double zNear, double zFar) {
    gl_h.glFrustum(left, right, bottom, top, zNear, zFar);
  }

  public int glGenLists(int range) {
    return gl_h.glGenLists(range);
  }

  public void glGenTextures(int n, MemorySegment textures) {
    gl_h.glGenTextures(n, textures);
  }

  public void glGetBooleanv(int pname, MemorySegment data) {
    gl_h.glGetBooleanv(pname, data);
  }

  public void glGetClipPlane(int plane, MemorySegment equation) {
    gl_h.glGetClipPlane(plane, equation);
  }

  public void glGetDoublev(int pname, MemorySegment data) {
    gl_h.glGetDoublev(pname, data);
  }

  public int glGetError() {
    return gl_h.glGetError();
  }

  public void glGetFloatv(int pname, MemorySegment data) {
    gl_h.glGetFloatv(pname, data);
  }

  public void glGetIntegerv(int pname, MemorySegment data) {
    gl_h.glGetIntegerv(pname, data);
  }

  public void glGetLightfv(int light, int pname, MemorySegment params) {
    gl_h.glGetLightfv(light, pname, params);
  }

  public void glGetLightiv(int light, int pname, MemorySegment params) {
    gl_h.glGetLightiv(light, pname, params);
  }

  public void glGetMapdv(int target, int query, MemorySegment v) {
    gl_h.glGetMapdv(target, query, v);
  }

  public void glGetMapfv(int target, int query, MemorySegment v) {
    gl_h.glGetMapfv(target, query, v);
  }

  public void glGetMapiv(int target, int query, MemorySegment v) {
    gl_h.glGetMapiv(target, query, v);
  }

  public void glGetMaterialfv(int face, int pname, MemorySegment params) {
    gl_h.glGetMaterialfv(face, pname, params);
  }

  public void glGetMaterialiv(int face, int pname, MemorySegment params) {
    gl_h.glGetMaterialiv(face, pname, params);
  }

  public void glGetPixelMapfv(int map, MemorySegment values) {
    gl_h.glGetPixelMapfv(map, values);
  }

  public void glGetPixelMapuiv(int map, MemorySegment values) {
    gl_h.glGetPixelMapuiv(map, values);
  }

  public void glGetPixelMapusv(int map, MemorySegment values) {
    gl_h.glGetPixelMapusv(map, values);
  }

  public void glGetPointerv(int pname, MemorySegment params) {
    gl_h.glGetPointerv(pname, params);
  }

  public void glGetPolygonStipple(MemorySegment mask) {
    gl_h.glGetPolygonStipple(mask);
  }

  public MemorySegment glGetString(int name) {
    return gl_h.glGetString(name);
  }

  public void glGetTexEnvfv(int target, int pname, MemorySegment params) {
    gl_h.glGetTexEnvfv(target, pname, params);
  }

  public void glGetTexEnviv(int target, int pname, MemorySegment params) {
    gl_h.glGetTexEnviv(target, pname, params);
  }

  public void glGetTexGendv(int coord, int pname, MemorySegment params) {
    gl_h.glGetTexGendv(coord, pname, params);
  }

  public void glGetTexGenfv(int coord, int pname, MemorySegment params) {
    gl_h.glGetTexGenfv(coord, pname, params);
  }

  public void glGetTexGeniv(int coord, int pname, MemorySegment params) {
    gl_h.glGetTexGeniv(coord, pname, params);
  }

  public void glGetTexImage(int target, int level, int format, int type, MemorySegment pixels) {
    gl_h.glGetTexImage(target, level, format, type, pixels);
  }

  public void glGetTexLevelParameterfv(int target, int level, int pname, MemorySegment params) {
    gl_h.glGetTexLevelParameterfv(target, level, pname, params);
  }

  public void glGetTexLevelParameteriv(int target, int level, int pname, MemorySegment params) {
    gl_h.glGetTexLevelParameteriv(target, level, pname, params);
  }

  public void glGetTexParameterfv(int target, int pname, MemorySegment params) {
    gl_h.glGetTexParameterfv(target, pname, params);
  }

  public void glGetTexParameteriv(int target, int pname, MemorySegment params) {
    gl_h.glGetTexParameteriv(target, pname, params);
  }

  public void glHint(int target, int mode) {
    gl_h.glHint(target, mode);
  }

  public void glIndexMask(int mask) {
    gl_h.glIndexMask(mask);
  }

  public void glIndexPointer(int type, int stride, MemorySegment pointer) {
    gl_h.glIndexPointer(type, stride, pointer);
  }

  public void glIndexd(double c) {
    gl_h.glIndexd(c);
  }

  public void glIndexdv(MemorySegment c) {
    gl_h.glIndexdv(c);
  }

  public void glIndexf(float c) {
    gl_h.glIndexf(c);
  }

  public void glIndexfv(MemorySegment c) {
    gl_h.glIndexfv(c);
  }

  public void glIndexi(int c) {
    gl_h.glIndexi(c);
  }

  public void glIndexiv(MemorySegment c) {
    gl_h.glIndexiv(c);
  }

  public void glIndexs(short c) {
    gl_h.glIndexs(c);
  }

  public void glIndexsv(MemorySegment c) {
    gl_h.glIndexsv(c);
  }

  public void glIndexub(byte c) {
    gl_h.glIndexub(c);
  }

  public void glIndexubv(MemorySegment c) {
    gl_h.glIndexubv(c);
  }

  public void glInitNames() {
    gl_h.glInitNames();
  }

  public void glInterleavedArrays(int format, int stride, MemorySegment pointer) {
    gl_h.glInterleavedArrays(format, stride, pointer);
  }

  public byte glIsEnabled(int cap) {
    return gl_h.glIsEnabled(cap);
  }

  public byte glIsList(int list) {
    return gl_h.glIsList(list);
  }

  public byte glIsTexture(int texture) {
    return gl_h.glIsTexture(texture);
  }

  public void glLightModelf(int pname, float param) {
    gl_h.glLightModelf(pname, param);
  }

  public void glLightModelfv(int pname, MemorySegment params) {
    gl_h.glLightModelfv(pname, params);
  }

  public void glLightModeli(int pname, int param) {
    gl_h.glLightModeli(pname, param);
  }

  public void glLightModeliv(int pname, MemorySegment params) {
    gl_h.glLightModeliv(pname, params);
  }

  public void glLightf(int light, int pname, float param) {
    gl_h.glLightf(light, pname, param);
  }

  public void glLightfv(int light, int pname, MemorySegment params) {
    gl_h.glLightfv(light, pname, params);
  }

  public void glLighti(int light, int pname, int param) {
    gl_h.glLighti(light, pname, param);
  }

  public void glLightiv(int light, int pname, MemorySegment params) {
    gl_h.glLightiv(light, pname, params);
  }

  public void glLineStipple(int factor, short pattern) {
    gl_h.glLineStipple(factor, pattern);
  }

  public void glLineWidth(float width) {
    gl_h.glLineWidth(width);
  }

  public void glListBase(int base) {
    gl_h.glListBase(base);
  }

  public void glLoadIdentity() {
    gl_h.glLoadIdentity();
  }

  public void glLoadMatrixd(MemorySegment m) {
    gl_h.glLoadMatrixd(m);
  }

  public void glLoadMatrixf(MemorySegment m) {
    gl_h.glLoadMatrixf(m);
  }

  public void glLoadName(int name) {
    gl_h.glLoadName(name);
  }

  public void glLogicOp(int opcode) {
    gl_h.glLogicOp(opcode);
  }

  public void glMap1d(int target, double u1, double u2, int stride, int order, MemorySegment points) {
    gl_h.glMap1d(target, u1, u2, stride, order, points);
  }

  public void glMap1f(int target, float u1, float u2, int stride, int order, MemorySegment points) {
    gl_h.glMap1f(target, u1, u2, stride, order, points);
  }

  public void glMap2d(int target, double u1, double u2, int ustride, int uorder, double v1, double v2, int vstride, int vorder, MemorySegment points) {
    gl_h.glMap2d(target, u1, u2, ustride, uorder, v1, v2, vstride, vorder, points);
  }

  public void glMap2f(int target, float u1, float u2, int ustride, int uorder, float v1, float v2, int vstride, int vorder, MemorySegment points) {
    gl_h.glMap2f(target, u1, u2, ustride, uorder, v1, v2, vstride, vorder, points);
  }

  public void glMapGrid1d(int un, double u1, double u2) {
    gl_h.glMapGrid1d(un, u1, u2);
  }

  public void glMapGrid1f(int un, float u1, float u2) {
    gl_h.glMapGrid1f(un, u1, u2);
  }

  public void glMapGrid2d(int un, double u1, double u2, int vn, double v1, double v2) {
    gl_h.glMapGrid2d(un, u1, u2, vn, v1, v2);
  }

  public void glMapGrid2f(int un, float u1, float u2, int vn, float v1, float v2) {
    gl_h.glMapGrid2f(un, u1, u2, vn, v1, v2);
  }

  public void glMaterialf(int face, int pname, float param) {
    gl_h.glMaterialf(face, pname, param);
  }

  public void glMaterialfv(int face, int pname, MemorySegment params) {
    gl_h.glMaterialfv(face, pname, params);
  }

  public void glMateriali(int face, int pname, int param) {
    gl_h.glMateriali(face, pname, param);
  }

  public void glMaterialiv(int face, int pname, MemorySegment params) {
    gl_h.glMaterialiv(face, pname, params);
  }

  public void glMatrixMode(int mode) {
    gl_h.glMatrixMode(mode);
  }

  public void glMultMatrixd(MemorySegment m) {
    gl_h.glMultMatrixd(m);
  }

  public void glMultMatrixf(MemorySegment m) {
    gl_h.glMultMatrixf(m);
  }

  public void glNewList(int list, int mode) {
    gl_h.glNewList(list, mode);
  }

  public void glNormal3b(byte nx, byte ny, byte nz) {
    gl_h.glNormal3b(nx, ny, nz);
  }

  public void glNormal3bv(MemorySegment v) {
    gl_h.glNormal3bv(v);
  }

  public void glNormal3d(double nx, double ny, double nz) {
    gl_h.glNormal3d(nx, ny, nz);
  }

  public void glNormal3dv(MemorySegment v) {
    gl_h.glNormal3dv(v);
  }

  public void glNormal3f(float nx, float ny, float nz) {
    gl_h.glNormal3f(nx, ny, nz);
  }

  public void glNormal3fv(MemorySegment v) {
    gl_h.glNormal3fv(v);
  }

  public void glNormal3i(int nx, int ny, int nz) {
    gl_h.glNormal3i(nx, ny, nz);
  }

  public void glNormal3iv(MemorySegment v) {
    gl_h.glNormal3iv(v);
  }

  public void glNormal3s(short nx, short ny, short nz) {
    gl_h.glNormal3s(nx, ny, nz);
  }

  public void glNormal3sv(MemorySegment v) {
    gl_h.glNormal3sv(v);
  }

  public void glNormalPointer(int type, int stride, MemorySegment pointer) {
    gl_h.glNormalPointer(type, stride, pointer);
  }

  public void glOrtho(double left, double right, double bottom, double top, double zNear, double zFar) {
    gl_h.glOrtho(left, right, bottom, top, zNear, zFar);
  }

  public void glPassThrough(float token) {
    gl_h.glPassThrough(token);
  }

  public void glPixelMapfv(int map, int mapsize, MemorySegment values) {
    gl_h.glPixelMapfv(map, mapsize, values);
  }

  public void glPixelMapuiv(int map, int mapsize, MemorySegment values) {
    gl_h.glPixelMapuiv(map, mapsize, values);
  }

  public void glPixelMapusv(int map, int mapsize, MemorySegment values) {
    gl_h.glPixelMapusv(map, mapsize, values);
  }

  public void glPixelStoref(int pname, float param) {
    gl_h.glPixelStoref(pname, param);
  }

  public void glPixelStorei(int pname, int param) {
    gl_h.glPixelStorei(pname, param);
  }

  public void glPixelTransferf(int pname, float param) {
    gl_h.glPixelTransferf(pname, param);
  }

  public void glPixelTransferi(int pname, int param) {
    gl_h.glPixelTransferi(pname, param);
  }

  public void glPixelZoom(float xfactor, float yfactor) {
    gl_h.glPixelZoom(xfactor, yfactor);
  }

  public void glPointSize(float size) {
    gl_h.glPointSize(size);
  }

  public void glPolygonMode(int face, int mode) {
    gl_h.glPolygonMode(face, mode);
  }

  public void glPolygonOffset(float factor, float units) {
    gl_h.glPolygonOffset(factor, units);
  }

  public void glPolygonStipple(MemorySegment mask) {
    gl_h.glPolygonStipple(mask);
  }

  public void glPopAttrib() {
    gl_h.glPopAttrib();
  }

  public void glPopClientAttrib() {
    gl_h.glPopClientAttrib();
  }

  public void glPopMatrix() {
    gl_h.glPopMatrix();
  }

  public void glPopName() {
    gl_h.glPopName();
  }

  public void glPrioritizeTextures(int n, MemorySegment textures, MemorySegment priorities) {
    gl_h.glPrioritizeTextures(n, textures, priorities);
  }

  public void glPushAttrib(int mask) {
    gl_h.glPushAttrib(mask);
  }

  public void glPushClientAttrib(int mask) {
    gl_h.glPushClientAttrib(mask);
  }

  public void glPushMatrix() {
    gl_h.glPushMatrix();
  }

  public void glPushName(int name) {
    gl_h.glPushName(name);
  }

  public void glRasterPos2d(double x, double y) {
    gl_h.glRasterPos2d(x, y);
  }

  public void glRasterPos2dv(MemorySegment v) {
    gl_h.glRasterPos2dv(v);
  }

  public void glRasterPos2f(float x, float y) {
    gl_h.glRasterPos2f(x, y);
  }

  public void glRasterPos2fv(MemorySegment v) {
    gl_h.glRasterPos2fv(v);
  }

  public void glRasterPos2i(int x, int y) {
    gl_h.glRasterPos2i(x, y);
  }

  public void glRasterPos2iv(MemorySegment v) {
    gl_h.glRasterPos2iv(v);
  }

  public void glRasterPos2s(short x, short y) {
    gl_h.glRasterPos2s(x, y);
  }

  public void glRasterPos2sv(MemorySegment v) {
    gl_h.glRasterPos2sv(v);
  }

  public void glRasterPos3d(double x, double y, double z) {
    gl_h.glRasterPos3d(x, y, z);
  }

  public void glRasterPos3dv(MemorySegment v) {
    gl_h.glRasterPos3dv(v);
  }

  public void glRasterPos3f(float x, float y, float z) {
    gl_h.glRasterPos3f(x, y, z);
  }

  public void glRasterPos3fv(MemorySegment v) {
    gl_h.glRasterPos3fv(v);
  }

  public void glRasterPos3i(int x, int y, int z) {
    gl_h.glRasterPos3i(x, y, z);
  }

  public void glRasterPos3iv(MemorySegment v) {
    gl_h.glRasterPos3iv(v);
  }

  public void glRasterPos3s(short x, short y, short z) {
    gl_h.glRasterPos3s(x, y, z);
  }

  public void glRasterPos3sv(MemorySegment v) {
    gl_h.glRasterPos3sv(v);
  }

  public void glRasterPos4d(double x, double y, double z, double w) {
    gl_h.glRasterPos4d(x, y, z, w);
  }

  public void glRasterPos4dv(MemorySegment v) {
    gl_h.glRasterPos4dv(v);
  }

  public void glRasterPos4f(float x, float y, float z, float w) {
    gl_h.glRasterPos4f(x, y, z, w);
  }

  public void glRasterPos4fv(MemorySegment v) {
    gl_h.glRasterPos4fv(v);
  }

  public void glRasterPos4i(int x, int y, int z, int w) {
    gl_h.glRasterPos4i(x, y, z, w);
  }

  public void glRasterPos4iv(MemorySegment v) {
    gl_h.glRasterPos4iv(v);
  }

  public void glRasterPos4s(short x, short y, short z, short w) {
    gl_h.glRasterPos4s(x, y, z, w);
  }

  public void glRasterPos4sv(MemorySegment v) {
    gl_h.glRasterPos4sv(v);
  }

  public void glReadBuffer(int src) {
    gl_h.glReadBuffer(src);
  }

  public void glReadPixels(int x, int y, int width, int height, int format, int type, MemorySegment pixels) {
    gl_h.glReadPixels(x, y, width, height, format, type, pixels);
  }

  public void glRectd(double x1, double y1, double x2, double y2) {
    gl_h.glRectd(x1, y1, x2, y2);
  }

  public void glRectdv(MemorySegment v1, MemorySegment v2) {
    gl_h.glRectdv(v1, v2);
  }

  public void glRectf(float x1, float y1, float x2, float y2) {
    gl_h.glRectf(x1, y1, x2, y2);
  }

  public void glRectfv(MemorySegment v1, MemorySegment v2) {
    gl_h.glRectfv(v1, v2);
  }

  public void glRecti(int x1, int y1, int x2, int y2) {
    gl_h.glRecti(x1, y1, x2, y2);
  }

  public void glRectiv(MemorySegment v1, MemorySegment v2) {
    gl_h.glRectiv(v1, v2);
  }

  public void glRects(short x1, short y1, short x2, short y2) {
    gl_h.glRects(x1, y1, x2, y2);
  }

  public void glRectsv(MemorySegment v1, MemorySegment v2) {
    gl_h.glRectsv(v1, v2);
  }

  public int glRenderMode(int mode) {
    return gl_h.glRenderMode(mode);
  }

  public void glRotated(double angle, double x, double y, double z) {
    gl_h.glRotated(angle, x, y, z);
  }

  public void glRotatef(float angle, float x, float y, float z) {
    gl_h.glRotatef(angle, x, y, z);
  }

  public void glScaled(double x, double y, double z) {
    gl_h.glScaled(x, y, z);
  }

  public void glScalef(float x, float y, float z) {
    gl_h.glScalef(x, y, z);
  }

  public void glScissor(int x, int y, int width, int height) {
    gl_h.glScissor(x, y, width, height);
  }

  public void glSelectBuffer(int size, MemorySegment buffer) {
    gl_h.glSelectBuffer(size, buffer);
  }

  public void glShadeModel(int mode) {
    gl_h.glShadeModel(mode);
  }

  public void glStencilFunc(int func, int ref, int mask) {
    gl_h.glStencilFunc(func, ref, mask);
  }

  public void glStencilMask(int mask) {
    gl_h.glStencilMask(mask);
  }

  public void glStencilOp(int fail, int zfail, int zpass) {
    gl_h.glStencilOp(fail, zfail, zpass);
  }

  public void glTexCoord1d(double s) {
    gl_h.glTexCoord1d(s);
  }

  public void glTexCoord1dv(MemorySegment v) {
    gl_h.glTexCoord1dv(v);
  }

  public void glTexCoord1f(float s) {
    gl_h.glTexCoord1f(s);
  }

  public void glTexCoord1fv(MemorySegment v) {
    gl_h.glTexCoord1fv(v);
  }

  public void glTexCoord1i(int s) {
    gl_h.glTexCoord1i(s);
  }

  public void glTexCoord1iv(MemorySegment v) {
    gl_h.glTexCoord1iv(v);
  }

  public void glTexCoord1s(short s) {
    gl_h.glTexCoord1s(s);
  }

  public void glTexCoord1sv(MemorySegment v) {
    gl_h.glTexCoord1sv(v);
  }

  public void glTexCoord2d(double s, double t) {
    gl_h.glTexCoord2d(s, t);
  }

  public void glTexCoord2dv(MemorySegment v) {
    gl_h.glTexCoord2dv(v);
  }

  public void glTexCoord2f(float s, float t) {
    gl_h.glTexCoord2f(s, t);
  }

  public void glTexCoord2fv(MemorySegment v) {
    gl_h.glTexCoord2fv(v);
  }

  public void glTexCoord2i(int s, int t) {
    gl_h.glTexCoord2i(s, t);
  }

  public void glTexCoord2iv(MemorySegment v) {
    gl_h.glTexCoord2iv(v);
  }

  public void glTexCoord2s(short s, short t) {
    gl_h.glTexCoord2s(s, t);
  }

  public void glTexCoord2sv(MemorySegment v) {
    gl_h.glTexCoord2sv(v);
  }

  public void glTexCoord3d(double s, double t, double r) {
    gl_h.glTexCoord3d(s, t, r);
  }

  public void glTexCoord3dv(MemorySegment v) {
    gl_h.glTexCoord3dv(v);
  }

  public void glTexCoord3f(float s, float t, float r) {
    gl_h.glTexCoord3f(s, t, r);
  }

  public void glTexCoord3fv(MemorySegment v) {
    gl_h.glTexCoord3fv(v);
  }

  public void glTexCoord3i(int s, int t, int r) {
    gl_h.glTexCoord3i(s, t, r);
  }

  public void glTexCoord3iv(MemorySegment v) {
    gl_h.glTexCoord3iv(v);
  }

  public void glTexCoord3s(short s, short t, short r) {
    gl_h.glTexCoord3s(s, t, r);
  }

  public void glTexCoord3sv(MemorySegment v) {
    gl_h.glTexCoord3sv(v);
  }

  public void glTexCoord4d(double s, double t, double r, double q) {
    gl_h.glTexCoord4d(s, t, r, q);
  }

  public void glTexCoord4dv(MemorySegment v) {
    gl_h.glTexCoord4dv(v);
  }

  public void glTexCoord4f(float s, float t, float r, float q) {
    gl_h.glTexCoord4f(s, t, r, q);
  }

  public void glTexCoord4fv(MemorySegment v) {
    gl_h.glTexCoord4fv(v);
  }

  public void glTexCoord4i(int s, int t, int r, int q) {
    gl_h.glTexCoord4i(s, t, r, q);
  }

  public void glTexCoord4iv(MemorySegment v) {
    gl_h.glTexCoord4iv(v);
  }

  public void glTexCoord4s(short s, short t, short r, short q) {
    gl_h.glTexCoord4s(s, t, r, q);
  }

  public void glTexCoord4sv(MemorySegment v) {
    gl_h.glTexCoord4sv(v);
  }

  public void glTexCoordPointer(int size, int type, int stride, MemorySegment pointer) {
    gl_h.glTexCoordPointer(size, type, stride, pointer);
  }

  public void glTexEnvf(int target, int pname, float param) {
    gl_h.glTexEnvf(target, pname, param);
  }

  public void glTexEnvfv(int target, int pname, MemorySegment params) {
    gl_h.glTexEnvfv(target, pname, params);
  }

  public void glTexEnvi(int target, int pname, int param) {
    gl_h.glTexEnvi(target, pname, param);
  }

  public void glTexEnviv(int target, int pname, MemorySegment params) {
    gl_h.glTexEnviv(target, pname, params);
  }

  public void glTexGend(int coord, int pname, double param) {
    gl_h.glTexGend(coord, pname, param);
  }

  public void glTexGendv(int coord, int pname, MemorySegment params) {
    gl_h.glTexGendv(coord, pname, params);
  }

  public void glTexGenf(int coord, int pname, float param) {
    gl_h.glTexGenf(coord, pname, param);
  }

  public void glTexGenfv(int coord, int pname, MemorySegment params) {
    gl_h.glTexGenfv(coord, pname, params);
  }

  public void glTexGeni(int coord, int pname, int param) {
    gl_h.glTexGeni(coord, pname, param);
  }

  public void glTexGeniv(int coord, int pname, MemorySegment params) {
    gl_h.glTexGeniv(coord, pname, params);
  }

  public void glTexImage1D(int target, int level, int internalformat, int width, int border, int format, int type, MemorySegment pixels) {
    gl_h.glTexImage1D(target, level, internalformat, width, border, format, type, pixels);
  }

  public void glTexImage2D(int target, int level, int internalformat, int width, int height, int border, int format, int type, MemorySegment pixels) {
    gl_h.glTexImage2D(target, level, internalformat, width, height, border, format, type, pixels);
  }

  public void glTexParameterf(int target, int pname, float param) {
    gl_h.glTexParameterf(target, pname, param);
  }

  public void glTexParameterfv(int target, int pname, MemorySegment params) {
    gl_h.glTexParameterfv(target, pname, params);
  }

  public void glTexParameteri(int target, int pname, int param) {
    gl_h.glTexParameteri(target, pname, param);
  }

  public void glTexParameteriv(int target, int pname, MemorySegment params) {
    gl_h.glTexParameteriv(target, pname, params);
  }

  public void glTexSubImage1D(int target, int level, int xoffset, int width, int format, int type, MemorySegment pixels) {
    gl_h.glTexSubImage1D(target, level, xoffset, width, format, type, pixels);
  }

  public void glTexSubImage2D(int target, int level, int xoffset, int yoffset, int width, int height, int format, int type, MemorySegment pixels) {
    gl_h.glTexSubImage2D(target, level, xoffset, yoffset, width, height, format, type, pixels);
  }

  public void glTranslated(double x, double y, double z) {
    gl_h.glTranslated(x, y, z);
  }

  public void glTranslatef(float x, float y, float z) {
    gl_h.glTranslatef(x, y, z);
  }

  public void glVertex2d(double x, double y) {
    gl_h.glVertex2d(x, y);
  }

  public void glVertex2dv(MemorySegment v) {
    gl_h.glVertex2dv(v);
  }

  public void glVertex2f(float x, float y) {
    gl_h.glVertex2f(x, y);
  }

  public void glVertex2fv(MemorySegment v) {
    gl_h.glVertex2fv(v);
  }

  public void glVertex2i(int x, int y) {
    gl_h.glVertex2i(x, y);
  }

  public void glVertex2iv(MemorySegment v) {
    gl_h.glVertex2iv(v);
  }

  public void glVertex2s(short x, short y) {
    gl_h.glVertex2s(x, y);
  }

  public void glVertex2sv(MemorySegment v) {
    gl_h.glVertex2sv(v);
  }

  public void glVertex3d(double x, double y, double z) {
    gl_h.glVertex3d(x, y, z);
  }

  public void glVertex3dv(MemorySegment v) {
    gl_h.glVertex3dv(v);
  }

  public void glVertex3f(float x, float y, float z) {
    gl_h.glVertex3f(x, y, z);
  }

  public void glVertex3fv(MemorySegment v) {
    gl_h.glVertex3fv(v);
  }

  public void glVertex3i(int x, int y, int z) {
    gl_h.glVertex3i(x, y, z);
  }

  public void glVertex3iv(MemorySegment v) {
    gl_h.glVertex3iv(v);
  }

  public void glVertex3s(short x, short y, short z) {
    gl_h.glVertex3s(x, y, z);
  }

  public void glVertex3sv(MemorySegment v) {
    gl_h.glVertex3sv(v);
  }

  public void glVertex4d(double x, double y, double z, double w) {
    gl_h.glVertex4d(x, y, z, w);
  }

  public void glVertex4dv(MemorySegment v) {
    gl_h.glVertex4dv(v);
  }

  public void glVertex4f(float x, float y, float z, float w) {
    gl_h.glVertex4f(x, y, z, w);
  }

  public void glVertex4fv(MemorySegment v) {
    gl_h.glVertex4fv(v);
  }

  public void glVertex4i(int x, int y, int z, int w) {
    gl_h.glVertex4i(x, y, z, w);
  }

  public void glVertex4iv(MemorySegment v) {
    gl_h.glVertex4iv(v);
  }

  public void glVertex4s(short x, short y, short z, short w) {
    gl_h.glVertex4s(x, y, z, w);
  }

  public void glVertex4sv(MemorySegment v) {
    gl_h.glVertex4sv(v);
  }

  public void glVertexPointer(int size, int type, int stride, MemorySegment pointer) {
    gl_h.glVertexPointer(size, type, stride, pointer);
  }

  public void glViewport(int x, int y, int width, int height) {
    gl_h.glViewport(x, y, width, height);
  }

  public void gluBeginCurve(MemorySegment arg0) {
    gl_h.gluBeginCurve(arg0);
  }

  public void gluBeginPolygon(MemorySegment arg0) {
    gl_h.gluBeginPolygon(arg0);
  }

  public void gluBeginSurface(MemorySegment arg0) {
    gl_h.gluBeginSurface(arg0);
  }

  public void gluBeginTrim(MemorySegment arg0) {
    gl_h.gluBeginTrim(arg0);
  }

  public int gluBuild1DMipmaps(int arg0, int arg1, int arg2, int arg3, int arg4, MemorySegment arg5) {
    return gl_h.gluBuild1DMipmaps(arg0, arg1, arg2, arg3, arg4, arg5);
  }

  public int gluBuild2DMipmaps(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, MemorySegment arg6) {
    return gl_h.gluBuild2DMipmaps(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
  }

  public void gluCylinder(MemorySegment arg0, double arg1, double arg2, double arg3, int arg4, int arg5) {
    gl_h.gluCylinder(arg0, arg1, arg2, arg3, arg4, arg5);
  }

  public void gluDeleteNurbsRenderer(MemorySegment arg0) {
    gl_h.gluDeleteNurbsRenderer(arg0);
  }

  public void gluDeleteQuadric(MemorySegment arg0) {
    gl_h.gluDeleteQuadric(arg0);
  }

  public void gluDeleteTess(MemorySegment arg0) {
    gl_h.gluDeleteTess(arg0);
  }

  public void gluDisk(MemorySegment arg0, double arg1, double arg2, int arg3, int arg4) {
    gl_h.gluDisk(arg0, arg1, arg2, arg3, arg4);
  }

  public void gluEndCurve(MemorySegment arg0) {
    gl_h.gluEndCurve(arg0);
  }

  public void gluEndPolygon(MemorySegment arg0) {
    gl_h.gluEndPolygon(arg0);
  }

  public void gluEndSurface(MemorySegment arg0) {
    gl_h.gluEndSurface(arg0);
  }

  public void gluEndTrim(MemorySegment arg0) {
    gl_h.gluEndTrim(arg0);
  }

  public MemorySegment gluErrorString(int arg0) {
    return gl_h.gluErrorString(arg0);
  }

  public MemorySegment gluErrorUnicodeStringEXT(int arg0) {
    return gl_h.gluErrorUnicodeStringEXT(arg0);
  }

  public void gluGetNurbsProperty(MemorySegment arg0, int arg1, MemorySegment arg2) {
    gl_h.gluGetNurbsProperty(arg0, arg1, arg2);
  }

  public MemorySegment gluGetString(int arg0) {
    return gl_h.gluGetString(arg0);
  }

  public void gluGetTessProperty(MemorySegment arg0, int arg1, MemorySegment arg2) {
    gl_h.gluGetTessProperty(arg0, arg1, arg2);
  }

  public void gluLoadSamplingMatrices(MemorySegment arg0, MemorySegment arg1, MemorySegment arg2, MemorySegment arg3) {
    gl_h.gluLoadSamplingMatrices(arg0, arg1, arg2, arg3);
  }

  public void gluLookAt(double arg0, double arg1, double arg2, double arg3, double arg4, double arg5, double arg6, double arg7, double arg8) {
    gl_h.gluLookAt(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
  }

  public MemorySegment gluNewNurbsRenderer() {
    return gl_h.gluNewNurbsRenderer();
  }

  public MemorySegment gluNewQuadric() {
    return gl_h.gluNewQuadric();
  }

  public MemorySegment gluNewTess() {
    return gl_h.gluNewTess();
  }

  public void gluNextContour(MemorySegment arg0, int arg1) {
    gl_h.gluNextContour(arg0, arg1);
  }

  public void gluNurbsCallback(MemorySegment arg0, int arg1, MemorySegment arg2) {
    gl_h.gluNurbsCallback(arg0, arg1, arg2);
  }

  public void gluNurbsCurve(MemorySegment arg0, int arg1, MemorySegment arg2, int arg3, MemorySegment arg4, int arg5, int arg6) {
    gl_h.gluNurbsCurve(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
  }

  public void gluNurbsProperty(MemorySegment arg0, int arg1, float arg2) {
    gl_h.gluNurbsProperty(arg0, arg1, arg2);
  }

  public void gluNurbsSurface(MemorySegment arg0, int arg1, MemorySegment arg2, int arg3, MemorySegment arg4, int arg5, int arg6, MemorySegment arg7, int arg8, int arg9, int arg10) {
    gl_h.gluNurbsSurface(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10);
  }

  public void gluOrtho2D(double arg0, double arg1, double arg2, double arg3) {
    gl_h.gluOrtho2D(arg0, arg1, arg2, arg3);
  }

  public void gluPartialDisk(MemorySegment arg0, double arg1, double arg2, int arg3, int arg4, double arg5, double arg6) {
    gl_h.gluPartialDisk(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
  }

  public void gluPerspective(double arg0, double arg1, double arg2, double arg3) {
    gl_h.gluPerspective(arg0, arg1, arg2, arg3);
  }

  public void gluPickMatrix(double arg0, double arg1, double arg2, double arg3, MemorySegment arg4) {
    gl_h.gluPickMatrix(arg0, arg1, arg2, arg3, arg4);
  }

  public int gluProject(double arg0, double arg1, double arg2, MemorySegment arg3, MemorySegment arg4, MemorySegment arg5, MemorySegment arg6, MemorySegment arg7, MemorySegment arg8) {
    return gl_h.gluProject(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
  }

  public void gluPwlCurve(MemorySegment arg0, int arg1, MemorySegment arg2, int arg3, int arg4) {
    gl_h.gluPwlCurve(arg0, arg1, arg2, arg3, arg4);
  }

  public void gluQuadricCallback(MemorySegment arg0, int arg1, MemorySegment arg2) {
    gl_h.gluQuadricCallback(arg0, arg1, arg2);
  }

  public void gluQuadricDrawStyle(MemorySegment arg0, int arg1) {
    gl_h.gluQuadricDrawStyle(arg0, arg1);
  }

  public void gluQuadricNormals(MemorySegment arg0, int arg1) {
    gl_h.gluQuadricNormals(arg0, arg1);
  }

  public void gluQuadricOrientation(MemorySegment arg0, int arg1) {
    gl_h.gluQuadricOrientation(arg0, arg1);
  }

  public void gluQuadricTexture(MemorySegment arg0, byte arg1) {
    gl_h.gluQuadricTexture(arg0, arg1);
  }

  public int gluScaleImage(int arg0, int arg1, int arg2, int arg3, MemorySegment arg4, int arg5, int arg6, int arg7, MemorySegment arg8) {
    return gl_h.gluScaleImage(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
  }

  public void gluSphere(MemorySegment arg0, double arg1, int arg2, int arg3) {
    gl_h.gluSphere(arg0, arg1, arg2, arg3);
  }

  public void gluTessBeginContour(MemorySegment arg0) {
    gl_h.gluTessBeginContour(arg0);
  }

  public void gluTessBeginPolygon(MemorySegment arg0, MemorySegment arg1) {
    gl_h.gluTessBeginPolygon(arg0, arg1);
  }

  public void gluTessCallback(MemorySegment arg0, int arg1, MemorySegment arg2) {
    gl_h.gluTessCallback(arg0, arg1, arg2);
  }

  public void gluTessEndContour(MemorySegment arg0) {
    gl_h.gluTessEndContour(arg0);
  }

  public void gluTessEndPolygon(MemorySegment arg0) {
    gl_h.gluTessEndPolygon(arg0);
  }

  public void gluTessNormal(MemorySegment arg0, double arg1, double arg2, double arg3) {
    gl_h.gluTessNormal(arg0, arg1, arg2, arg3);
  }

  public void gluTessProperty(MemorySegment arg0, int arg1, double arg2) {
    gl_h.gluTessProperty(arg0, arg1, arg2);
  }

  public void gluTessVertex(MemorySegment arg0, MemorySegment arg1, MemorySegment arg2) {
    gl_h.gluTessVertex(arg0, arg1, arg2);
  }

  public int gluUnProject(double arg0, double arg1, double arg2, MemorySegment arg3, MemorySegment arg4, MemorySegment arg5, MemorySegment arg6, MemorySegment arg7, MemorySegment arg8) {
    return gl_h.gluUnProject(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
  }

  public void glutAddMenuEntry(MemorySegment arg0, int arg1) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutAddMenuEntry(arg0, arg1);
  }

  public void glutAddSubMenu(MemorySegment arg0, int arg1) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutAddSubMenu(arg0, arg1);
  }

  public void glutAppStatusFunc(MemorySegment arg0) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutAppStatusFunc(arg0);
  }

  public void glutAppStatusFuncUcall(MemorySegment arg0, MemorySegment arg1) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutAppStatusFuncUcall(arg0, arg1);
  }

  public void glutAttachMenu(int arg0) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutAttachMenu(arg0);
  }

  public void glutBitmapCharacter(MemorySegment arg0, int arg1) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutBitmapCharacter(arg0, arg1);
  }

  public int glutBitmapHeight(MemorySegment arg0) {
    panamagl.platform.windows.GLUT_windows.init();
    return gl_h.glutBitmapHeight(arg0);
  }

  public int glutBitmapLength(MemorySegment arg0, MemorySegment arg1) {
    panamagl.platform.windows.GLUT_windows.init();
    return gl_h.glutBitmapLength(arg0, arg1);
  }

  public void glutBitmapString(MemorySegment arg0, MemorySegment arg1) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutBitmapString(arg0, arg1);
  }

  public int glutBitmapWidth(MemorySegment arg0, int arg1) {
    panamagl.platform.windows.GLUT_windows.init();
    return gl_h.glutBitmapWidth(arg0, arg1);
  }

  public void glutButtonBoxFunc(MemorySegment arg0) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutButtonBoxFunc(arg0);
  }

  public void glutButtonBoxFuncUcall(MemorySegment arg0, MemorySegment arg1) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutButtonBoxFuncUcall(arg0, arg1);
  }

  public void glutChangeToMenuEntry(int arg0, MemorySegment arg1, int arg2) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutChangeToMenuEntry(arg0, arg1, arg2);
  }

  public void glutChangeToSubMenu(int arg0, MemorySegment arg1, int arg2) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutChangeToSubMenu(arg0, arg1, arg2);
  }

  public void glutCloseFunc(MemorySegment arg0) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutCloseFunc(arg0);
  }

  public void glutCloseFuncUcall(MemorySegment arg0, MemorySegment arg1) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutCloseFuncUcall(arg0, arg1);
  }

  public void glutCopyColormap(int arg0) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutCopyColormap(arg0);
  }

  public int glutCreateMenu(MemorySegment arg0) {
    panamagl.platform.windows.GLUT_windows.init();
    return gl_h.glutCreateMenu(arg0);
  }

  public int glutCreateMenuUcall(MemorySegment arg0, MemorySegment arg1) {
    panamagl.platform.windows.GLUT_windows.init();
    return gl_h.glutCreateMenuUcall(arg0, arg1);
  }

  /*public int glutCreateMenuUcall_ATEXIT_HACK(MemorySegment arg0, MemorySegment arg1) {
    return gl_h.glutCreateMenuUcall_ATEXIT_HACK(arg0, arg1);
  }

  public int glutCreateMenu_ATEXIT_HACK(MemorySegment arg0) {
    return gl_h.glutCreateMenu_ATEXIT_HACK(arg0);
  }*/

  public int glutCreateSubWindow(int arg0, int arg1, int arg2, int arg3, int arg4) {
    panamagl.platform.windows.GLUT_windows.init();
    return gl_h.glutCreateSubWindow(arg0, arg1, arg2, arg3, arg4);
  }

  public int glutCreateWindow(MemorySegment arg0) {
    panamagl.platform.windows.GLUT_windows.init();
    return gl_h.glutCreateWindow(arg0);
  }

  public int glutCreateWindow_ATEXIT_HACK(MemorySegment arg0) {
    return -1;//gl_h.glutCreateWindow_ATEXIT_HACK(arg0);
  }

  public void glutDestroyMenu(int arg0) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutDestroyMenu(arg0);
  }

  public void glutDestroyWindow(int arg0) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutDestroyWindow(arg0);
  }

  public void glutDetachMenu(int arg0) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutDetachMenu(arg0);
  }

  public int glutDeviceGet(int arg0) {
    panamagl.platform.windows.GLUT_windows.init();
    return gl_h.glutDeviceGet(arg0);
  }

  public void glutDialsFunc(MemorySegment arg0) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutDialsFunc(arg0);
  }

  public void glutDialsFuncUcall(MemorySegment arg0, MemorySegment arg1) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutDialsFuncUcall(arg0, arg1);
  }

  public void glutDisplayFunc(MemorySegment arg0) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutDisplayFunc(arg0);
  }

  public void glutDisplayFuncUcall(MemorySegment arg0, MemorySegment arg1) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutDisplayFuncUcall(arg0, arg1);
  }

  public int glutEnterGameMode() {
    panamagl.platform.windows.GLUT_windows.init();
    return gl_h.glutEnterGameMode();
  }

  public void glutEntryFunc(MemorySegment arg0) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutEntryFunc(arg0);
  }

  public void glutEntryFuncUcall(MemorySegment arg0, MemorySegment arg1) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutEntryFuncUcall(arg0, arg1);
  }

  public void glutEstablishOverlay() {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutEstablishOverlay();
  }

  public void glutExit() {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutExit();
  }

  public int glutExtensionSupported(MemorySegment arg0) {
    panamagl.platform.windows.GLUT_windows.init();
    return gl_h.glutExtensionSupported(arg0);
  }

  public void glutForceJoystickFunc() {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutForceJoystickFunc();
  }

  public void glutFullScreen() {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutFullScreen();
  }

  public void glutFullScreenToggle() {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutFullScreenToggle();
  }

  public int glutGameModeGet(int arg0) {
    panamagl.platform.windows.GLUT_windows.init();
    return gl_h.glutGameModeGet(arg0);
  }

  public void glutGameModeString(MemorySegment arg0) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutGameModeString(arg0);
  }

  public int glutGet(int arg0) {
    panamagl.platform.windows.GLUT_windows.init();
    return gl_h.glutGet(arg0);
  }

  public float glutGetColor(int arg0, int arg1) {
    panamagl.platform.windows.GLUT_windows.init();
    return gl_h.glutGetColor(arg0, arg1);
  }

  public int glutGetMenu() {
    panamagl.platform.windows.GLUT_windows.init();
    return gl_h.glutGetMenu();
  }

  public MemorySegment glutGetMenuData() {
    panamagl.platform.windows.GLUT_windows.init();
    return gl_h.glutGetMenuData();
  }

  public MemorySegment glutGetModeValues(int arg0, MemorySegment arg1) {
    panamagl.platform.windows.GLUT_windows.init();
    return gl_h.glutGetModeValues(arg0, arg1);
  }

  public int glutGetModifiers() {
    panamagl.platform.windows.GLUT_windows.init();
    return gl_h.glutGetModifiers();
  }

  public MemorySegment glutGetProcAddress(MemorySegment arg0) {
    panamagl.platform.windows.GLUT_windows.init();
    return gl_h.glutGetProcAddress(arg0);
  }

  public int glutGetWindow() {
    panamagl.platform.windows.GLUT_windows.init();
    return gl_h.glutGetWindow();
  }

  public MemorySegment glutGetWindowData() {
    panamagl.platform.windows.GLUT_windows.init();
    return gl_h.glutGetWindowData();
  }

  public void glutHideOverlay() {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutHideOverlay();
  }

  public void glutHideWindow() {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutHideWindow();
  }

  public void glutIconifyWindow() {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutIconifyWindow();
  }

  public void glutIdleFunc(MemorySegment arg0) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutIdleFunc(arg0);
  }

  public void glutIdleFuncUcall(MemorySegment arg0, MemorySegment arg1) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutIdleFuncUcall(arg0, arg1);
  }

  public void glutIgnoreKeyRepeat(int arg0) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutIgnoreKeyRepeat(arg0);
  }

  public void glutInit(MemorySegment arg0, MemorySegment arg1) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutInit(arg0, arg1);
  }

  public void glutInitContextFlags(int arg0) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutInitContextFlags(arg0);
  }

  public void glutInitContextFunc(MemorySegment arg0) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutInitContextFunc(arg0);
  }

  public void glutInitContextFuncUcall(MemorySegment arg0, MemorySegment arg1) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutInitContextFuncUcall(arg0, arg1);
  }

  public void glutInitContextProfile(int arg0) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutInitContextProfile(arg0);
  }

  public void glutInitContextVersion(int arg0, int arg1) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutInitContextVersion(arg0, arg1);
  }

  public void glutInitDisplayMode(int arg0) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutInitDisplayMode(arg0);
  }

  public void glutInitDisplayString(MemorySegment arg0) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutInitDisplayString(arg0);
  }

  public void glutInitErrorFunc(MemorySegment arg0) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutInitErrorFunc(arg0);
  }

  public void glutInitErrorFuncUcall(MemorySegment arg0, MemorySegment arg1) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutInitErrorFuncUcall(arg0, arg1);
  }

  public void glutInitWarningFunc(MemorySegment arg0) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutInitWarningFunc(arg0);
  }

  public void glutInitWarningFuncUcall(MemorySegment arg0, MemorySegment arg1) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutInitWarningFuncUcall(arg0, arg1);
  }

  public void glutInitWindowPosition(int arg0, int arg1) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutInitWindowPosition(arg0, arg1);
  }

  public void glutInitWindowSize(int arg0, int arg1) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutInitWindowSize(arg0, arg1);
  }

  public void glutInit_ATEXIT_HACK(MemorySegment arg0, MemorySegment arg1) {
    //gl_h.glutInit_ATEXIT_HACK(arg0, arg1);
  }

  public void glutJoystickFunc(MemorySegment arg0, int arg1) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutJoystickFunc(arg0, arg1);
  }

  public void glutJoystickFuncUcall(MemorySegment arg0, int arg1, MemorySegment arg2) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutJoystickFuncUcall(arg0, arg1, arg2);
  }

  public void glutJoystickGetCenter(int arg0, MemorySegment arg1) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutJoystickGetCenter(arg0, arg1);
  }

  public float glutJoystickGetDeadBand(int arg0, int arg1) {
    panamagl.platform.windows.GLUT_windows.init();
    return gl_h.glutJoystickGetDeadBand(arg0, arg1);
  }

  public void glutJoystickGetMaxRange(int arg0, MemorySegment arg1) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutJoystickGetMaxRange(arg0, arg1);
  }

  public void glutJoystickGetMinRange(int arg0, MemorySegment arg1) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutJoystickGetMinRange(arg0, arg1);
  }

  public int glutJoystickGetNumAxes(int arg0) {
    panamagl.platform.windows.GLUT_windows.init();
    return gl_h.glutJoystickGetNumAxes(arg0);
  }

  public int glutJoystickGetNumButtons(int arg0) {
    panamagl.platform.windows.GLUT_windows.init();
    return gl_h.glutJoystickGetNumButtons(arg0);
  }

  public float glutJoystickGetSaturation(int arg0, int arg1) {
    panamagl.platform.windows.GLUT_windows.init();
    return gl_h.glutJoystickGetSaturation(arg0, arg1);
  }

  public int glutJoystickNotWorking(int arg0) {
    panamagl.platform.windows.GLUT_windows.init();
    return gl_h.glutJoystickNotWorking(arg0);
  }

  public void glutJoystickSetCenter(int arg0, MemorySegment arg1) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutJoystickSetCenter(arg0, arg1);
  }

  public void glutJoystickSetDeadBand(int arg0, int arg1, float arg2) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutJoystickSetDeadBand(arg0, arg1, arg2);
  }

  public void glutJoystickSetMaxRange(int arg0, MemorySegment arg1) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutJoystickSetMaxRange(arg0, arg1);
  }

  public void glutJoystickSetMinRange(int arg0, MemorySegment arg1) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutJoystickSetMinRange(arg0, arg1);
  }

  public void glutJoystickSetSaturation(int arg0, int arg1, float arg2) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutJoystickSetSaturation(arg0, arg1, arg2);
  }

  public void glutKeyboardFunc(MemorySegment arg0) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutKeyboardFunc(arg0);
  }

  public void glutKeyboardFuncUcall(MemorySegment arg0, MemorySegment arg1) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutKeyboardFuncUcall(arg0, arg1);
  }

  public void glutKeyboardUpFunc(MemorySegment arg0) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutKeyboardUpFunc(arg0);
  }

  public void glutKeyboardUpFuncUcall(MemorySegment arg0, MemorySegment arg1) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutKeyboardUpFuncUcall(arg0, arg1);
  }

  public int glutLayerGet(int arg0) {
    panamagl.platform.windows.GLUT_windows.init();
    return gl_h.glutLayerGet(arg0);
  }

  public void glutLeaveFullScreen() {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutLeaveFullScreen();
  }

  public void glutLeaveGameMode() {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutLeaveGameMode();
  }

  public void glutLeaveMainLoop() {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutLeaveMainLoop();
  }

  public void glutMainLoop() {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutMainLoop();
  }

  public void glutMainLoopEvent() {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutMainLoopEvent();
  }

  public void glutMenuDestroyFunc(MemorySegment arg0) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutMenuDestroyFunc(arg0);
  }

  public void glutMenuDestroyFuncUcall(MemorySegment arg0, MemorySegment arg1) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutMenuDestroyFuncUcall(arg0, arg1);
  }

  public void glutMenuStateFunc(MemorySegment arg0) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutMenuStateFunc(arg0);
  }

  public void glutMenuStatusFunc(MemorySegment arg0) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutMenuStatusFunc(arg0);
  }

  public void glutMenuStatusFuncUcall(MemorySegment arg0, MemorySegment arg1) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutMenuStatusFuncUcall(arg0, arg1);
  }

  public void glutMotionFunc(MemorySegment arg0) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutMotionFunc(arg0);
  }

  public void glutMotionFuncUcall(MemorySegment arg0, MemorySegment arg1) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutMotionFuncUcall(arg0, arg1);
  }

  public void glutMouseFunc(MemorySegment arg0) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutMouseFunc(arg0);
  }

  public void glutMouseFuncUcall(MemorySegment arg0, MemorySegment arg1) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutMouseFuncUcall(arg0, arg1);
  }

  public void glutMouseWheelFunc(MemorySegment arg0) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutMouseWheelFunc(arg0);
  }

  public void glutMouseWheelFuncUcall(MemorySegment arg0, MemorySegment arg1) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutMouseWheelFuncUcall(arg0, arg1);
  }

  public void glutMultiButtonFunc(MemorySegment arg0) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutMultiButtonFunc(arg0);
  }

  public void glutMultiButtonFuncUcall(MemorySegment arg0, MemorySegment arg1) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutMultiButtonFuncUcall(arg0, arg1);
  }

  public void glutMultiEntryFunc(MemorySegment arg0) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutMultiEntryFunc(arg0);
  }

  public void glutMultiEntryFuncUcall(MemorySegment arg0, MemorySegment arg1) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutMultiEntryFuncUcall(arg0, arg1);
  }

  public void glutMultiMotionFunc(MemorySegment arg0) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutMultiMotionFunc(arg0);
  }

  public void glutMultiMotionFuncUcall(MemorySegment arg0, MemorySegment arg1) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutMultiMotionFuncUcall(arg0, arg1);
  }

  public void glutMultiPassiveFunc(MemorySegment arg0) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutMultiPassiveFunc(arg0);
  }

  public void glutMultiPassiveFuncUcall(MemorySegment arg0, MemorySegment arg1) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutMultiPassiveFuncUcall(arg0, arg1);
  }

  public void glutOverlayDisplayFunc(MemorySegment arg0) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutOverlayDisplayFunc(arg0);
  }

  public void glutOverlayDisplayFuncUcall(MemorySegment arg0, MemorySegment arg1) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutOverlayDisplayFuncUcall(arg0, arg1);
  }

  public void glutPassiveMotionFunc(MemorySegment arg0) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutPassiveMotionFunc(arg0);
  }

  public void glutPassiveMotionFuncUcall(MemorySegment arg0, MemorySegment arg1) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutPassiveMotionFuncUcall(arg0, arg1);
  }

  public void glutPopWindow() {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutPopWindow();
  }

  public void glutPositionFunc(MemorySegment arg0) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutPositionFunc(arg0);
  }

  public void glutPositionFuncUcall(MemorySegment arg0, MemorySegment arg1) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutPositionFuncUcall(arg0, arg1);
  }

  public void glutPositionWindow(int arg0, int arg1) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutPositionWindow(arg0, arg1);
  }

  public void glutPostOverlayRedisplay() {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutPostOverlayRedisplay();
  }

  public void glutPostRedisplay() {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutPostRedisplay();
  }

  public void glutPostWindowOverlayRedisplay(int arg0) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutPostWindowOverlayRedisplay(arg0);
  }

  public void glutPostWindowRedisplay(int arg0) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutPostWindowRedisplay(arg0);
  }

  public void glutPushWindow() {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutPushWindow();
  }

  public void glutRemoveMenuItem(int arg0) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutRemoveMenuItem(arg0);
  }

  public void glutRemoveOverlay() {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutRemoveOverlay();
  }

  public void glutReportErrors() {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutReportErrors();
  }

  public void glutReshapeFunc(MemorySegment arg0) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutReshapeFunc(arg0);
  }

  public void glutReshapeFuncUcall(MemorySegment arg0, MemorySegment arg1) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutReshapeFuncUcall(arg0, arg1);
  }

  public void glutReshapeWindow(int arg0, int arg1) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutReshapeWindow(arg0, arg1);
  }

  public void glutSetColor(int arg0, float arg1, float arg2, float arg3) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutSetColor(arg0, arg1, arg2, arg3);
  }

  public void glutSetCursor(int arg0) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutSetCursor(arg0);
  }

  public void glutSetIconTitle(MemorySegment arg0) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutSetIconTitle(arg0);
  }

  public void glutSetKeyRepeat(int arg0) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutSetKeyRepeat(arg0);
  }

  public void glutSetMenu(int arg0) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutSetMenu(arg0);
  }

  public void glutSetMenuData(MemorySegment arg0) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutSetMenuData(arg0);
  }

  public void glutSetMenuFont(int arg0, MemorySegment arg1) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutSetMenuFont(arg0, arg1);
  }

  public void glutSetOption(int arg0, int arg1) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutSetOption(arg0, arg1);
  }

  public void glutSetVertexAttribCoord3(int arg0) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutSetVertexAttribCoord3(arg0);
  }

  public void glutSetVertexAttribNormal(int arg0) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutSetVertexAttribNormal(arg0);
  }

  public void glutSetVertexAttribTexCoord2(int arg0) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutSetVertexAttribTexCoord2(arg0);
  }

  public void glutSetWindow(int arg0) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutSetWindow(arg0);
  }

  public void glutSetWindowData(MemorySegment arg0) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutSetWindowData(arg0);
  }

  public void glutSetWindowTitle(MemorySegment arg0) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutSetWindowTitle(arg0);
  }

  public void glutSetupVideoResizing() {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutSetupVideoResizing();
  }

  public void glutShowOverlay() {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutShowOverlay();
  }

  public void glutShowWindow() {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutShowWindow();
  }

  public void glutSolidCone(double arg0, double arg1, int arg2, int arg3) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutSolidCone(arg0, arg1, arg2, arg3);
  }

  public void glutSolidCube(double arg0) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutSolidCube(arg0);
  }

  public void glutSolidCylinder(double arg0, double arg1, int arg2, int arg3) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutSolidCylinder(arg0, arg1, arg2, arg3);
  }

  public void glutSolidDodecahedron() {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutSolidDodecahedron();
  }

  public void glutSolidIcosahedron() {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutSolidIcosahedron();
  }

  public void glutSolidOctahedron() {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutSolidOctahedron();
  }

  public void glutSolidRhombicDodecahedron() {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutSolidRhombicDodecahedron();
  }

  public void glutSolidSierpinskiSponge(int arg0, MemorySegment arg1, double arg2) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutSolidSierpinskiSponge(arg0, arg1, arg2);
  }

  public void glutSolidSphere(double arg0, int arg1, int arg2) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutSolidSphere(arg0, arg1, arg2);
  }

  public void glutSolidTeacup(double arg0) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutSolidTeacup(arg0);
  }

  public void glutSolidTeapot(double arg0) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutSolidTeapot(arg0);
  }

  public void glutSolidTeaspoon(double arg0) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutSolidTeaspoon(arg0);
  }

  public void glutSolidTetrahedron() {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutSolidTetrahedron();
  }

  public void glutSolidTorus(double arg0, double arg1, int arg2, int arg3) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutSolidTorus(arg0, arg1, arg2, arg3);
  }

  public void glutSpaceballButtonFunc(MemorySegment arg0) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutSpaceballButtonFunc(arg0);
  }

  public void glutSpaceballButtonFuncUcall(MemorySegment arg0, MemorySegment arg1) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutSpaceballButtonFuncUcall(arg0, arg1);
  }

  public void glutSpaceballMotionFunc(MemorySegment arg0) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutSpaceballMotionFunc(arg0);
  }

  public void glutSpaceballMotionFuncUcall(MemorySegment arg0, MemorySegment arg1) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutSpaceballMotionFuncUcall(arg0, arg1);
  }

  public void glutSpaceballRotateFunc(MemorySegment arg0) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutSpaceballRotateFunc(arg0);
  }

  public void glutSpaceballRotateFuncUcall(MemorySegment arg0, MemorySegment arg1) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutSpaceballRotateFuncUcall(arg0, arg1);
  }

  public void glutSpecialFunc(MemorySegment arg0) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutSpecialFunc(arg0);
  }

  public void glutSpecialFuncUcall(MemorySegment arg0, MemorySegment arg1) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutSpecialFuncUcall(arg0, arg1);
  }

  public void glutSpecialUpFunc(MemorySegment arg0) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutSpecialUpFunc(arg0);
  }

  public void glutSpecialUpFuncUcall(MemorySegment arg0, MemorySegment arg1) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutSpecialUpFuncUcall(arg0, arg1);
  }

  public void glutStopVideoResizing() {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutStopVideoResizing();
  }

  public void glutStrokeCharacter(MemorySegment arg0, int arg1) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutStrokeCharacter(arg0, arg1);
  }

  public float glutStrokeHeight(MemorySegment arg0) {
    panamagl.platform.windows.GLUT_windows.init();
    return gl_h.glutStrokeHeight(arg0);
  }

  public int glutStrokeLength(MemorySegment arg0, MemorySegment arg1) {
    panamagl.platform.windows.GLUT_windows.init();
    return gl_h.glutStrokeLength(arg0, arg1);
  }

  public float glutStrokeLengthf(MemorySegment arg0, MemorySegment arg1) {
    panamagl.platform.windows.GLUT_windows.init();
    return gl_h.glutStrokeLengthf(arg0, arg1);
  }

  public void glutStrokeString(MemorySegment arg0, MemorySegment arg1) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutStrokeString(arg0, arg1);
  }

  public int glutStrokeWidth(MemorySegment arg0, int arg1) {
    panamagl.platform.windows.GLUT_windows.init();
    return gl_h.glutStrokeWidth(arg0, arg1);
  }

  public float glutStrokeWidthf(MemorySegment arg0, int arg1) {
    panamagl.platform.windows.GLUT_windows.init();
    return gl_h.glutStrokeWidthf(arg0, arg1);
  }

  public void glutSwapBuffers() {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutSwapBuffers();
  }

  public void glutTabletButtonFunc(MemorySegment arg0) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutTabletButtonFunc(arg0);
  }

  public void glutTabletButtonFuncUcall(MemorySegment arg0, MemorySegment arg1) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutTabletButtonFuncUcall(arg0, arg1);
  }

  public void glutTabletMotionFunc(MemorySegment arg0) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutTabletMotionFunc(arg0);
  }

  public void glutTabletMotionFuncUcall(MemorySegment arg0, MemorySegment arg1) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutTabletMotionFuncUcall(arg0, arg1);
  }

  public void glutTimerFunc(int arg0, MemorySegment arg1, int arg2) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutTimerFunc(arg0, arg1, arg2);
  }

  public void glutTimerFuncUcall(int arg0, MemorySegment arg1, int arg2, MemorySegment arg3) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutTimerFuncUcall(arg0, arg1, arg2, arg3);
  }

  public void glutUseLayer(int arg0) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutUseLayer(arg0);
  }

  public void glutVideoPan(int arg0, int arg1, int arg2, int arg3) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutVideoPan(arg0, arg1, arg2, arg3);
  }

  public void glutVideoResize(int arg0, int arg1, int arg2, int arg3) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutVideoResize(arg0, arg1, arg2, arg3);
  }

  public int glutVideoResizeGet(int arg0) {
    panamagl.platform.windows.GLUT_windows.init();
    return gl_h.glutVideoResizeGet(arg0);
  }

  public void glutVisibilityFunc(MemorySegment arg0) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutVisibilityFunc(arg0);
  }

  public void glutVisibilityFuncUcall(MemorySegment arg0, MemorySegment arg1) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutVisibilityFuncUcall(arg0, arg1);
  }

  public void glutWMCloseFunc(MemorySegment arg0) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutWMCloseFunc(arg0);
  }

  public void glutWMCloseFuncUcall(MemorySegment arg0, MemorySegment arg1) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutWMCloseFuncUcall(arg0, arg1);
  }

  public void glutWarpPointer(int arg0, int arg1) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutWarpPointer(arg0, arg1);
  }

  public void glutWindowStatusFunc(MemorySegment arg0) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutWindowStatusFunc(arg0);
  }

  public void glutWindowStatusFuncUcall(MemorySegment arg0, MemorySegment arg1) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutWindowStatusFuncUcall(arg0, arg1);
  }

  public void glutWireCone(double arg0, double arg1, int arg2, int arg3) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutWireCone(arg0, arg1, arg2, arg3);
  }

  public void glutWireCube(double arg0) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutWireCube(arg0);
  }

  public void glutWireCylinder(double arg0, double arg1, int arg2, int arg3) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutWireCylinder(arg0, arg1, arg2, arg3);
  }

  public void glutWireDodecahedron() {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutWireDodecahedron();
  }

  public void glutWireIcosahedron() {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutWireIcosahedron();
  }

  public void glutWireOctahedron() {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutWireOctahedron();
  }

  public void glutWireRhombicDodecahedron() {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutWireRhombicDodecahedron();
  }

  public void glutWireSierpinskiSponge(int arg0, MemorySegment arg1, double arg2) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutWireSierpinskiSponge(arg0, arg1, arg2);
  }

  public void glutWireSphere(double arg0, int arg1, int arg2) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutWireSphere(arg0, arg1, arg2);
  }

  public void glutWireTeacup(double arg0) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutWireTeacup(arg0);
  }

  public void glutWireTeapot(double arg0) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutWireTeapot(arg0);
  }

  public void glutWireTeaspoon(double arg0) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutWireTeaspoon(arg0);
  }

  public void glutWireTetrahedron() {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutWireTetrahedron();
  }

  public void glutWireTorus(double arg0, double arg1, int arg2, int arg3) {
    panamagl.platform.windows.GLUT_windows.init();
    gl_h.glutWireTorus(arg0, arg1, arg2, arg3);
  }

  public void glMultiTexImage3DEXT(int texunit, int target, int level, int internalformat, int width, int height, int depth, int border, int format, int type, MemorySegment pixels) {
    PFNGLMULTITEXIMAGE3DEXTPROC.invoke(load("glMultiTexImage3DEXT"), texunit, target, level, internalformat, width, height, depth, border, format, type, pixels);
  }

  public int glCheckFramebufferStatusOES(int target) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMulticastBarrierNV() {
    PFNGLMULTICASTBARRIERNVPROC.invoke(load("glMulticastBarrierNV"));
  }

  public void glTextureMaterialEXT(int face, int mode) {
    PFNGLTEXTUREMATERIALEXTPROC.invoke(load("glTextureMaterialEXT"), face, mode);
  }

  public void glInstrumentsBufferSGIX(int size, MemorySegment buffer) {
    PFNGLINSTRUMENTSBUFFERSGIXPROC.invoke(load("glInstrumentsBufferSGIX"), size, buffer);
  }

  public void glPrimitiveRestartNV() {
    PFNGLPRIMITIVERESTARTNVPROC.invoke(load("glPrimitiveRestartNV"));
  }

  public void glGetInfoLogARB(int obj, int maxLength, MemorySegment length, MemorySegment infoLog) {
    opengl.windows.PFNGLGETINFOLOGARBPROC.invoke(load("glGetInfoLogARB"), obj, maxLength, length, infoLog);
  }

  public void glBufferAddressRangeNV(int pname, int index, long address, long length) {
    PFNGLBUFFERADDRESSRANGENVPROC.invoke(load("glBufferAddressRangeNV"), pname, index, address, length);
  }

  public void glNamedFramebufferParameteri(int framebuffer, int pname, int param) {
    PFNGLNAMEDFRAMEBUFFERPARAMETERIPROC.invoke(load("glNamedFramebufferParameteri"), framebuffer, pname, param);
  }

  public void glClipPlanex(int plane, MemorySegment equation) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBinormal3bvEXT(MemorySegment v) {
    PFNGLBINORMAL3BVEXTPROC.invoke(load("glBinormal3bvEXT"), v);
  }

  public void glCopyColorSubTable(int target, int start, int x, int y, int width) {
    PFNGLCOPYCOLORSUBTABLEEXTPROC.invoke(load("glCopyColorSubTable"), target, start, x, y, width);
  }

  public void glUniform1iv(int location, int count, MemorySegment value) {
    PFNGLUNIFORM1IVPROC.invoke(load("glUniform1iv"), location, count, value);
  }

  public void glVertex4bOES(byte x, byte y, byte z, byte w) {
    PFNGLVERTEX4BOESPROC.invoke(load("glVertex4bOES"), x, y, z, w);
  }

  public void glVertex4xOES(int x, int y, int z) {
    PFNGLVERTEX4XOESPROC.invoke(load("glVertex4xOES"), x, y, z);
  }

  public void glVertexAttrib1fvNV(int index, MemorySegment v) {
    PFNGLVERTEXATTRIB1FVNVPROC.invoke(load("glVertexAttrib1fvNV"), index, v);
  }

  public void glGetnUniformuivARB(int program, int location, int bufSize, MemorySegment params) {
    PFNGLGETNUNIFORMUIVARBPROC.invoke(load("glGetnUniformuivARB"), program, location, bufSize, params);
  }

  public void glNamedBufferData(int buffer, long size, MemorySegment data, int usage) {
    PFNGLNAMEDBUFFERDATAPROC.invoke(load("glNamedBufferData"), buffer, size, data, usage);
  }

  public void glUniform4uiEXT(int location, int v0, int v1, int v2, int v3) {
    PFNGLUNIFORM4UIEXTPROC.invoke(load("glUniform4uiEXT"), location, v0, v1, v2, v3);
  }

  public void glFogCoorddv(MemorySegment coord) {
    PFNGLFOGCOORDDVPROC.invoke(load("glFogCoorddv"), coord);
  }

  public void glWindowPos2sMESA(short x, short y) {
    PFNGLWINDOWPOS2SMESAPROC.invoke(load("glWindowPos2sMESA"), x, y);
  }

  public void glWindowPos2dMESA(double x, double y) {
    PFNGLWINDOWPOS2DMESAPROC.invoke(load("glWindowPos2dMESA"), x, y);
  }

  public void glPixelTransformParameteriEXT(int target, int pname, int param) {
    PFNGLPIXELTRANSFORMPARAMETERIEXTPROC.invoke(load("glPixelTransformParameteriEXT"), target, pname, param);
  }

  public void glProgramEnvParameterI4ivNV(int target, int index, MemorySegment params) {
    PFNGLPROGRAMENVPARAMETERI4IVNVPROC.invoke(load("glProgramEnvParameterI4ivNV"), target, index, params);
  }

  public void glTexBufferRangeEXT(int target, int internalformat, int buffer, long offset, long size) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetTextureLevelParameterivEXT(int texture, int target, int level, int pname, MemorySegment params) {
    PFNGLGETTEXTURELEVELPARAMETERIVEXTPROC.invoke(load("glGetTextureLevelParameterivEXT"), texture, target, level, pname, params);
  }

  public void glRectxvOES(MemorySegment v1, MemorySegment v2) {
    PFNGLRECTXVOESPROC.invoke(load("glRectxvOES"), v1, v2);
  }

  public void glVertexAttrib4fARB(int index, float x, float y, float z, float w) {
    PFNGLVERTEXATTRIB4FARBPROC.invoke(load("glVertexAttrib4fARB"), index, x, y, z, w);
  }

  public void glGetQueryBufferObjectiv(int id, int buffer, int pname, long offset) {
    PFNGLGETQUERYBUFFEROBJECTIVPROC.invoke(load("glGetQueryBufferObjectiv"), id, buffer, pname, offset);
  }

  public void glUniform1ui64vARB(int location, int count, MemorySegment value) {
    PFNGLUNIFORM1UI64VARBPROC.invoke(load("glUniform1ui64vARB"), location, count, value);
  }

  public void glVertexAttrib2hvNV(int index, MemorySegment v) {
    PFNGLVERTEXATTRIB2HVNVPROC.invoke(load("glVertexAttrib2hvNV"), index, v);
  }

  public void glVertexAttrib2svNV(int index, MemorySegment v) {
    PFNGLVERTEXATTRIB2SVNVPROC.invoke(load("glVertexAttrib2svNV"), index, v);
  }

  public void glGetImageTransformParameterivHP(int target, int pname, MemorySegment params) {
    PFNGLGETIMAGETRANSFORMPARAMETERIVHPPROC.invoke(load("glGetImageTransformParameterivHP"), target, pname, params);
  }

  public void glReplacementCodeuiColor3fVertex3fvSUN(MemorySegment rc, MemorySegment c, MemorySegment v) {
    PFNGLREPLACEMENTCODEUICOLOR3FVERTEX3FVSUNPROC.invoke(load("glReplacementCodeuiColor3fVertex3fvSUN"), rc, c, v);
  }

  public void glFragmentLightModeliSGIX(int pname, int param) {
    PFNGLFRAGMENTLIGHTMODELISGIXPROC.invoke(load("glFragmentLightModeliSGIX"), pname, param);
  }

  public void glMultiTexCoord2hNV(int target, short s, short t) {
    PFNGLMULTITEXCOORD2HNVPROC.invoke(load("glMultiTexCoord2hNV"), target, s, t);
  }

  public void glMakeImageHandleNonResidentARB(long handle) {
    PFNGLMAKEIMAGEHANDLENONRESIDENTARBPROC.invoke(load("glMakeImageHandleNonResidentARB"), handle);
  }

  public void glVertexStream1svATI(int stream, MemorySegment coords) {
    PFNGLVERTEXSTREAM1SVATIPROC.invoke(load("glVertexStream1svATI"), stream, coords);
  }

  public void glImportSemaphoreWin32NameEXT(int semaphore, int handleType, MemorySegment name) {
    PFNGLIMPORTSEMAPHOREWIN32NAMEEXTPROC.invoke(load("glImportSemaphoreWin32NameEXT"), semaphore, handleType, name);
  }

  public String glGetStringi(int name, int index) {
    return string(PFNGLGETSTRINGIPROC.invoke(load("glGetStringi"), name, index));
  }

  public void glVertexAttribL1ui64vARB(int index, MemorySegment v) {
    PFNGLVERTEXATTRIBL1UI64VARBPROC.invoke(load("glVertexAttribL1ui64vARB"), index, v);
  }

  public void glSecondaryColor3bEXT(byte red, byte green, byte blue) {
    PFNGLSECONDARYCOLOR3BEXTPROC.invoke(load("glSecondaryColor3bEXT"), red, green, blue);
  }

  public void glGetPixelTexGenParameterfvSGIS(int pname, MemorySegment params) {
    PFNGLGETPIXELTEXGENPARAMETERFVSGISPROC.invoke(load("glGetPixelTexGenParameterfvSGIS"), pname, params);
  }

  public void glClipControlEXT(int origin, int depth) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glClipPlanef(int p, MemorySegment eqn) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniform2dvEXT(int program, int location, int count, MemorySegment value) {
    PFNGLPROGRAMUNIFORM2DVEXTPROC.invoke(load("glProgramUniform2dvEXT"), program, location, count, value);
  }

  public void glGetPathSpacingNV(int pathListMode, int numPaths, int pathNameType, MemorySegment paths, int pathBase, float advanceScale, float kerningScale, int transformType, MemorySegment returnedSpacing) {
    PFNGLGETPATHSPACINGNVPROC.invoke(load("glGetPathSpacingNV"), pathListMode, numPaths, pathNameType, paths, pathBase, advanceScale, kerningScale, transformType, returnedSpacing);
  }

  public void glClearNamedBufferDataEXT(int buffer, int internalformat, int format, int type, MemorySegment data) {
    PFNGLCLEARNAMEDBUFFERDATAEXTPROC.invoke(load("glClearNamedBufferDataEXT"), buffer, internalformat, format, type, data);
  }

  public void glColor4ubVertex2fSUN(byte r, byte g, byte b, byte a, float x, float y) {
    PFNGLCOLOR4UBVERTEX2FSUNPROC.invoke(load("glColor4ubVertex2fSUN"), r, g, b, a, x, y);
  }

  public void glPointSizexOES(int size) {
    PFNGLPOINTSIZEXOESPROC.invoke(load("glPointSizexOES"), size);
  }

  public void glRequestResidentProgramsNV(int n, MemorySegment programs) {
    PFNGLREQUESTRESIDENTPROGRAMSNVPROC.invoke(load("glRequestResidentProgramsNV"), n, programs);
  }

  public void glGetnMapfv(int target, int query, int bufSize, MemorySegment v) {
    PFNGLGETNMAPFVPROC.invoke(load("glGetnMapfv"), target, query, bufSize, v);
  }

  public void glMultiTexGenfEXT(int texunit, int coord, int pname, float param) {
    PFNGLMULTITEXGENFEXTPROC.invoke(load("glMultiTexGenfEXT"), texunit, coord, pname, param);
  }

  public void glClearPixelLocalStorageuiEXT(int offset, int n, MemorySegment values) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glClearTexImageEXT(int texture, int level, int format, int type, MemorySegment data) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetTextureParameterIivEXT(int texture, int target, int pname, MemorySegment params) {
    PFNGLGETTEXTUREPARAMETERIIVEXTPROC.invoke(load("glGetTextureParameterIivEXT"), texture, target, pname, params);
  }

  public void glOrthoxOES(int l, int r, int b, int t, int n, int f) {
    PFNGLORTHOXOESPROC.invoke(load("glOrthoxOES"), l, r, b, t, n, f);
  }

  public void glGetMapParameterivNV(int target, int pname, MemorySegment params) {
    PFNGLGETMAPPARAMETERIVNVPROC.invoke(load("glGetMapParameterivNV"), target, pname, params);
  }

  public void glImportMemoryWin32HandleEXT(int memory, long size, int handleType, MemorySegment handle) {
    PFNGLIMPORTMEMORYWIN32HANDLEEXTPROC.invoke(load("glImportMemoryWin32HandleEXT"), memory, size, handleType, handle);
  }

  public void glGetShaderSourceARB(int obj, int maxLength, MemorySegment length, MemorySegment source) {
    opengl.windows.PFNGLGETSHADERSOURCEARBPROC.invoke(load("glGetShaderSourceARB"), obj, maxLength, length, source);
  }

  public void glCoverFillPathNV(int path, int coverMode) {
    PFNGLCOVERFILLPATHNVPROC.invoke(load("glCoverFillPathNV"), path, coverMode);
  }

  public int glGetVaryingLocationNV(int program, MemorySegment name) {
    return PFNGLGETVARYINGLOCATIONNVPROC.invoke(load("glGetVaryingLocationNV"), program, name);
  }

  public void glDrawCommandsAddressNV(int primitiveMode, MemorySegment indirects, MemorySegment sizes, int count) {
    PFNGLDRAWCOMMANDSADDRESSNVPROC.invoke(load("glDrawCommandsAddressNV"), primitiveMode, indirects, sizes, count);
  }

  public void glBindTextureUnit(int unit, int texture) {
    PFNGLBINDTEXTUREUNITPROC.invoke(load("glBindTextureUnit"), unit, texture);
  }

  public MemorySegment glMapBufferARB(int target, int access) {
    return PFNGLMAPBUFFERARBPROC.invoke(load("glMapBufferARB"), target, access);
  }

  public void glUniform1dv(int location, int count, MemorySegment value) {
    PFNGLUNIFORM1DVPROC.invoke(load("glUniform1dv"), location, count, value);
  }

  public void glTexStorageAttribs3DEXT(int target, int levels, int internalformat, int width, int height, int depth, int attrib_list) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glPrimitiveBoundingBoxOES(float minX, float minY, float minZ, float minW, float maxX, float maxY, float maxZ, float maxW) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribI4bvEXT(int index, MemorySegment v) {
    PFNGLVERTEXATTRIBI4BVEXTPROC.invoke(load("glVertexAttribI4bvEXT"), index, v);
  }

  public void glGetProgramResourceiv(int program, int programInterface, int index, int propCount, MemorySegment props, int count, MemorySegment length, MemorySegment params) {
    PFNGLGETPROGRAMRESOURCEIVPROC.invoke(load("glGetProgramResourceiv"), program, programInterface, index, propCount, props, count, length, params);
  }

  public void glVertexAttribI1ivEXT(int index, MemorySegment v) {
    PFNGLVERTEXATTRIBI1IVEXTPROC.invoke(load("glVertexAttribI1ivEXT"), index, v);
  }

  public void glMemoryObjectParameterivEXT(int memoryObject, int pname, MemorySegment params) {
    PFNGLMEMORYOBJECTPARAMETERIVEXTPROC.invoke(load("glMemoryObjectParameterivEXT"), memoryObject, pname, params);
  }

  public void glGetColorTableSGI(int target, int format, int type, MemorySegment table) {
    PFNGLGETCOLORTABLESGIPROC.invoke(load("glGetColorTableSGI"), target, format, type, table);
  }

  public void glGetObjectBufferivATI(int buffer, int pname, MemorySegment params) {
    PFNGLGETOBJECTBUFFERIVATIPROC.invoke(load("glGetObjectBufferivATI"), buffer, pname, params);
  }

  public void glTexCoord2bvOES(MemorySegment coords) {
    PFNGLTEXCOORD2BVOESPROC.invoke(load("glTexCoord2bvOES"), coords);
  }

  public void glNamedFramebufferTexture3DEXT(int framebuffer, int attachment, int textarget, int texture, int level, int zoffset) {
    PFNGLNAMEDFRAMEBUFFERTEXTURE3DEXTPROC.invoke(load("glNamedFramebufferTexture3DEXT"), framebuffer, attachment, textarget, texture, level, zoffset);
  }

  public void glUniform3i64NV(int location, long x, long y, long z) {
    PFNGLUNIFORM3I64NVPROC.invoke(load("glUniform3i64NV"), location, x, y, z);
  }

  public void glDrawMeshTasksIndirectNV(long indirect) {
    PFNGLDRAWMESHTASKSINDIRECTNVPROC.invoke(load("glDrawMeshTasksIndirectNV"), indirect);
  }

  public void glGetnMapdv(int target, int query, int bufSize, MemorySegment v) {
    PFNGLGETNMAPDVPROC.invoke(load("glGetnMapdv"), target, query, bufSize, v);
  }

  public void glConvolutionFilter1DEXT(int target, int internalformat, int width, int format, int type, MemorySegment image) {
    PFNGLCONVOLUTIONFILTER1DEXTPROC.invoke(load("glConvolutionFilter1DEXT"), target, internalformat, width, format, type, image);
  }

  public void glCopyImageSubDataEXT(int srcName, int srcTarget, int srcLevel, int srcX, int srcY, int srcZ, int dstName, int dstTarget, int dstLevel, int dstX, int dstY, int dstZ, int srcWidth, int srcHeight, int srcDepth) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDeleteVertexArrays(int n, MemorySegment arrays) {
    PFNGLDELETEVERTEXARRAYSPROC.invoke(load("glDeleteVertexArrays"), n, arrays);
  }

  public void glGetUniformSubroutineuiv(int shadertype, int location, MemorySegment params) {
    PFNGLGETUNIFORMSUBROUTINEUIVPROC.invoke(load("glGetUniformSubroutineuiv"), shadertype, location, params);
  }

  public void glFogCoordfv(MemorySegment coord) {
    PFNGLFOGCOORDFVPROC.invoke(load("glFogCoordfv"), coord);
  }

  public void glProgramUniformHandleui64vARB(int program, int location, int count, MemorySegment values) {
    PFNGLPROGRAMUNIFORMHANDLEUI64VARBPROC.invoke(load("glProgramUniformHandleui64vARB"), program, location, count, values);
  }

  public void glCompressedTextureImage3DEXT(int texture, int target, int level, int internalformat, int width, int height, int depth, int border, int imageSize, MemorySegment bits) {
    PFNGLCOMPRESSEDTEXTUREIMAGE3DEXTPROC.invoke(load("glCompressedTextureImage3DEXT"), texture, target, level, internalformat, width, height, depth, border, imageSize, bits);
  }

  public byte glIsStateNV(int state) {
    return PFNGLISSTATENVPROC.invoke(load("glIsStateNV"), state);
  }

  public void glDeleteFramebuffers(int n, MemorySegment framebuffers) {
    PFNGLDELETEFRAMEBUFFERSPROC.invoke(load("glDeleteFramebuffers"), n, framebuffers);
  }

  public void glUniform1fv(int location, int count, MemorySegment value) {
    PFNGLUNIFORM1FVPROC.invoke(load("glUniform1fv"), location, count, value);
  }

  public void glVertexAttribL1i64vNV(int index, MemorySegment v) {
    PFNGLVERTEXATTRIBL1I64VNVPROC.invoke(load("glVertexAttribL1i64vNV"), index, v);
  }

  public void glSamplerParameterIiv(int sampler, int pname, MemorySegment param) {
    PFNGLSAMPLERPARAMETERIIVPROC.invoke(load("glSamplerParameterIiv"), sampler, pname, param);
  }

  public void glGetShaderiv(int shader, int pname, MemorySegment params) {
    PFNGLGETSHADERIVPROC.invoke(load("glGetShaderiv"), shader, pname, params);
  }

  public void glVariantPointerEXT(int id, int type, int stride, MemorySegment addr) {
    PFNGLVARIANTPOINTEREXTPROC.invoke(load("glVariantPointerEXT"), id, type, stride, addr);
  }

  public void glVariantfvEXT(int id, MemorySegment addr) {
    PFNGLVARIANTFVEXTPROC.invoke(load("glVariantfvEXT"), id, addr);
  }

  public void glBindFragDataLocation(int program, int color, MemorySegment name) {
    PFNGLBINDFRAGDATALOCATIONPROC.invoke(load("glBindFragDataLocation"), program, color, name);
  }

  public void glProgramUniformMatrix3x2fvEXT(int program, int location, int count, byte transpose, MemorySegment value) {
    PFNGLPROGRAMUNIFORMMATRIX3X2FVEXTPROC.invoke(load("glProgramUniformMatrix3x2fvEXT"), program, location, count, transpose, value);
  }

  public void glVertexAttrib1dvARB(int index, MemorySegment v) {
    PFNGLVERTEXATTRIB1DVARBPROC.invoke(load("glVertexAttrib1dvARB"), index, v);
  }

  public void glGetIntegerui64vNV(int value, MemorySegment result) {
    PFNGLGETINTEGERUI64VNVPROC.invoke(load("glGetIntegerui64vNV"), value, result);
  }

  public void glTexCoord3hvNV(MemorySegment v) {
    PFNGLTEXCOORD3HVNVPROC.invoke(load("glTexCoord3hvNV"), v);
  }

  public void glWeightPathsNV(int resultPath, int numPaths, MemorySegment paths, MemorySegment weights) {
    PFNGLWEIGHTPATHSNVPROC.invoke(load("glWeightPathsNV"), resultPath, numPaths, paths, weights);
  }

  public void glMultiDrawElementsIndirect(int mode, int type, MemorySegment indirect, int drawcount, int stride) {
    PFNGLMULTIDRAWELEMENTSINDIRECTPROC.invoke(load("glMultiDrawElementsIndirect"), mode, type, indirect, drawcount, stride);
  }

  public void glBufferStorageEXT(int target, long size, MemorySegment data, int flags) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexCoordP3ui(int texture, int type, int coords) {
    PFNGLMULTITEXCOORDP3UIPROC.invoke(load("glMultiTexCoordP3ui"), texture, type, coords);
  }

  public void glGetCompressedTexImage(int target, int level, MemorySegment img) {
    PFNGLGETCOMPRESSEDTEXIMAGEPROC.invoke(load("glGetCompressedTexImage"), target, level, img);
  }

  public int glPathGlyphIndexRangeNV(int fontTarget, MemorySegment fontName, int fontStyle, int pathParameterTemplate, float emScale, MemorySegment baseAndCount) {
    return PFNGLPATHGLYPHINDEXRANGENVPROC.invoke(load("glPathGlyphIndexRangeNV"), fontTarget, fontName, fontStyle, pathParameterTemplate, emScale, baseAndCount);
  }

  public void glProgramParameter4fvNV(int target, int index, MemorySegment v) {
    PFNGLPROGRAMPARAMETER4FVNVPROC.invoke(load("glProgramParameter4fvNV"), target, index, v);
  }

  public void glUniform2uiv(int location, int count, MemorySegment value) {
    PFNGLUNIFORM2UIVPROC.invoke(load("glUniform2uiv"), location, count, value);
  }

  public void glResetMinmaxEXT(int target) {
    PFNGLRESETMINMAXEXTPROC.invoke(load("glResetMinmaxEXT"), target);
  }

  public void glBindTransformFeedbackNV(int target, int id) {
    PFNGLBINDTRANSFORMFEEDBACKNVPROC.invoke(load("glBindTransformFeedbackNV"), target, id);
  }

  public void glMultiTexCoord3sv(int target, MemorySegment v) {
    PFNGLMULTITEXCOORD3SVARBPROC.invoke(load("glMultiTexCoord3sv"), target, v);
  }

  public void glVertexAttrib1fv(int index, MemorySegment v) {
    PFNGLVERTEXATTRIB1FVPROC.invoke(load("glVertexAttrib1fv"), index, v);
  }

  public void glVertexWeighthNV(short weight) {
    PFNGLVERTEXWEIGHTHNVPROC.invoke(load("glVertexWeighthNV"), weight);
  }

  public void glPixelTexGenParameteriSGIS(int pname, int param) {
    PFNGLPIXELTEXGENPARAMETERISGISPROC.invoke(load("glPixelTexGenParameteriSGIS"), pname, param);
  }

  public void glVertexAttribL4i64NV(int index, long x, long y, long z, long w) {
    PFNGLVERTEXATTRIBL4I64NVPROC.invoke(load("glVertexAttribL4i64NV"), index, x, y, z, w);
  }

  public void glStencilClearTagEXT(int stencilTagBits, int stencilClearTag) {
    PFNGLSTENCILCLEARTAGEXTPROC.invoke(load("glStencilClearTagEXT"), stencilTagBits, stencilClearTag);
  }

  public void glBeginQuery(int target, int id) {
    PFNGLBEGINQUERYPROC.invoke(load("glBeginQuery"), target, id);
  }

  public void glGetFloati_v(int target, int index, MemorySegment data) {
    PFNGLGETFLOATI_VPROC.invoke(load("glGetFloati_v"), target, index, data);
  }

  public void glVertexAttrib4NbvARB(int index, MemorySegment v) {
    PFNGLVERTEXATTRIB4NBVARBPROC.invoke(load("glVertexAttrib4NbvARB"), index, v);
  }

  public void glVertexAttrib4hNV(int index, short x, short y, short z, short w) {
    PFNGLVERTEXATTRIB4HNVPROC.invoke(load("glVertexAttrib4hNV"), index, x, y, z, w);
  }

  public byte glIsEnabledi(int target, int index) {
    return PFNGLISENABLEDIPROC.invoke(load("glIsEnabledi"), target, index);
  }

  public void glProgramUniform2dEXT(int program, int location, double x, double y) {
    PFNGLPROGRAMUNIFORM2DEXTPROC.invoke(load("glProgramUniform2dEXT"), program, location, x, y);
  }

  public int glGetDebugMessageLog(int count, int bufSize, MemorySegment sources, MemorySegment types, MemorySegment ids, MemorySegment severities, MemorySegment lengths, MemorySegment messageLog) {
    return PFNGLGETDEBUGMESSAGELOGPROC.invoke(load("glGetDebugMessageLog"), count, bufSize, sources, types, ids, severities, lengths, messageLog);
  }

  public void glVertexAttrib1dv(int index, MemorySegment v) {
    PFNGLVERTEXATTRIB1DVPROC.invoke(load("glVertexAttrib1dv"), index, v);
  }

  public int glCreateProgressFenceNVX() {
    return PFNGLCREATEPROGRESSFENCENVXPROC.invoke(load("glCreateProgressFenceNVX"));
  }

  public void glPointParameterxvOES(int pname, MemorySegment params) {
    PFNGLPOINTPARAMETERXVOESPROC.invoke(load("glPointParameterxvOES"), pname, params);
  }

  public void glPixelTexGenParameterfvSGIS(int pname, MemorySegment params) {
    PFNGLPIXELTEXGENPARAMETERFVSGISPROC.invoke(load("glPixelTexGenParameterfvSGIS"), pname, params);
  }

  public void glMultiDrawMeshTasksIndirectCountNV(long indirect, long drawcount, int maxdrawcount, int stride) {
    PFNGLMULTIDRAWMESHTASKSINDIRECTCOUNTNVPROC.invoke(load("glMultiDrawMeshTasksIndirectCountNV"), indirect, drawcount, maxdrawcount, stride);
  }

  public void glPathCoordsNV(int path, int numCoords, int coordType, MemorySegment coords) {
    PFNGLPATHCOORDSNVPROC.invoke(load("glPathCoordsNV"), path, numCoords, coordType, coords);
  }

  public void glGetIntegerIndexedvEXT(int target, int index, MemorySegment data) {
    PFNGLGETINTEGERINDEXEDVEXTPROC.invoke(load("glGetIntegerIndexedvEXT"), target, index, data);
  }

  public int glCheckNamedFramebufferStatus(int framebuffer, int target) {
    return PFNGLCHECKNAMEDFRAMEBUFFERSTATUSPROC.invoke(load("glCheckNamedFramebufferStatus"), framebuffer, target);
  }

  public void glMultiTexEnvivEXT(int texunit, int target, int pname, MemorySegment params) {
    PFNGLMULTITEXENVIVEXTPROC.invoke(load("glMultiTexEnvivEXT"), texunit, target, pname, params);
  }

  public byte glTestFenceNV(int fence) {
    return PFNGLTESTFENCENVPROC.invoke(load("glTestFenceNV"), fence);
  }

  public void glTextureBuffer(int texture, int internalformat, int buffer) {
    PFNGLTEXTUREBUFFERPROC.invoke(load("glTextureBuffer"), texture, internalformat, buffer);
  }

  public int glObjectUnpurgeableAPPLE(int objectType, int name, int option) {
    return PFNGLOBJECTUNPURGEABLEAPPLEPROC.invoke(load("glObjectUnpurgeableAPPLE"), objectType, name, option);
  }

  public void glBindVideoCaptureStreamTextureNV(int video_capture_slot, int stream, int frame_region, int target, int texture) {
    PFNGLBINDVIDEOCAPTURESTREAMTEXTURENVPROC.invoke(load("glBindVideoCaptureStreamTextureNV"), video_capture_slot, stream, frame_region, target, texture);
  }

  public void glBlendFuncSeparateINGR(int sfactorRGB, int dfactorRGB, int sfactorAlpha, int dfactorAlpha) {
    PFNGLBLENDFUNCSEPARATEINGRPROC.invoke(load("glBlendFuncSeparateINGR"), sfactorRGB, dfactorRGB, sfactorAlpha, dfactorAlpha);
  }

  public byte glIsPathNV(int path) {
    return PFNGLISPATHNVPROC.invoke(load("glIsPathNV"), path);
  }

  public void glMinSampleShadingOES(float value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetMemoryObjectParameterivEXT(int memoryObject, int pname, MemorySegment params) {
    PFNGLGETMEMORYOBJECTPARAMETERIVEXTPROC.invoke(load("glGetMemoryObjectParameterivEXT"), memoryObject, pname, params);
  }

  public void glMatrixOrthoEXT(int mode, double left, double right, double bottom, double top, double zNear, double zFar) {
    PFNGLMATRIXORTHOEXTPROC.invoke(load("glMatrixOrthoEXT"), mode, left, right, bottom, top, zNear, zFar);
  }

  public void glDepthRangeIndexeddNV(int index, double n, double f) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniform3fEXT(int program, int location, float v0, float v1, float v2) {
    PFNGLPROGRAMUNIFORM3FEXTPROC.invoke(load("glProgramUniform3fEXT"), program, location, v0, v1, v2);
  }

  public void glMultiDrawElementsBaseVertexEXT(int mode, MemorySegment count, int type, MemorySegment indices, int drawcount, MemorySegment basevertex) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetnMapiv(int target, int query, int bufSize, MemorySegment v) {
    PFNGLGETNMAPIVPROC.invoke(load("glGetnMapiv"), target, query, bufSize, v);
  }

  public void glProgramUniform1uiv(int program, int location, int count, MemorySegment value) {
    PFNGLPROGRAMUNIFORM1UIVPROC.invoke(load("glProgramUniform1uiv"), program, location, count, value);
  }

  public void glUniformMatrix3dv(int location, int count, byte transpose, MemorySegment value) {
    PFNGLUNIFORMMATRIX3DVPROC.invoke(load("glUniformMatrix3dv"), location, count, transpose, value);
  }

  public void glUniform1ui64ARB(int location, long x) {
    PFNGLUNIFORM1UI64ARBPROC.invoke(load("glUniform1ui64ARB"), location, x);
  }

  public void glDeleteCommandListsNV(int n, MemorySegment lists) {
    PFNGLDELETECOMMANDLISTSNVPROC.invoke(load("glDeleteCommandListsNV"), n, lists);
  }

  public void glSignalVkFenceNV(long vkFence) {
    PFNGLSIGNALVKFENCENVPROC.invoke(load("glSignalVkFenceNV"), vkFence);
  }

  public void glVertexAttribI1iv(int index, MemorySegment v) {
    PFNGLVERTEXATTRIBI1IVPROC.invoke(load("glVertexAttribI1iv"), index, v);
  }

  public void glCoverStrokePathNV(int path, int coverMode) {
    PFNGLCOVERSTROKEPATHNVPROC.invoke(load("glCoverStrokePathNV"), path, coverMode);
  }

  public void glDisableVertexArrayAttrib(int vaobj, int index) {
    PFNGLDISABLEVERTEXARRAYATTRIBPROC.invoke(load("glDisableVertexArrayAttrib"), vaobj, index);
  }

  public void glNamedFramebufferRenderbuffer(int framebuffer, int attachment, int renderbuffertarget, int renderbuffer) {
    PFNGLNAMEDFRAMEBUFFERRENDERBUFFERPROC.invoke(load("glNamedFramebufferRenderbuffer"), framebuffer, attachment, renderbuffertarget, renderbuffer);
  }

  public void glNamedFramebufferTextureLayerEXT(int framebuffer, int attachment, int texture, int level, int layer) {
    PFNGLNAMEDFRAMEBUFFERTEXTURELAYEREXTPROC.invoke(load("glNamedFramebufferTextureLayerEXT"), framebuffer, attachment, texture, level, layer);
  }

  public void glSecondaryColorP3uiv(int type, MemorySegment color) {
    PFNGLSECONDARYCOLORP3UIVPROC.invoke(load("glSecondaryColorP3uiv"), type, color);
  }

  public void glTexStorage1D(int target, int levels, int internalformat, int width) {
    PFNGLTEXSTORAGE1DPROC.invoke(load("glTexStorage1D"), target, levels, internalformat, width);
  }

  public void glTextureStorageMem3DMultisampleEXT(int texture, int samples, int internalFormat, int width, int height, int depth, byte fixedSampleLocations, int memory, long offset) {
    PFNGLTEXTURESTORAGEMEM3DMULTISAMPLEEXTPROC.invoke(load("glTextureStorageMem3DMultisampleEXT"), texture, samples, internalFormat, width, height, depth, fixedSampleLocations, memory, offset);
  }

  public void glGetProgramNamedParameterfvNV(int id, int len, MemorySegment name, MemorySegment params) {
    PFNGLGETPROGRAMNAMEDPARAMETERFVNVPROC.invoke(load("glGetProgramNamedParameterfvNV"), id, len, name, params);
  }

  public void glCompressedMultiTexSubImage3DEXT(int texunit, int target, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int format, int imageSize, MemorySegment bits) {
    PFNGLCOMPRESSEDMULTITEXSUBIMAGE3DEXTPROC.invoke(load("glCompressedMultiTexSubImage3DEXT"), texunit, target, level, xoffset, yoffset, zoffset, width, height, depth, format, imageSize, bits);
  }

  public void glEndTransformFeedback() {
    PFNGLENDTRANSFORMFEEDBACKPROC.invoke(load("glEndTransformFeedback"));
  }

  public void glVertexAttrib2sNV(int index, short x, short y) {
    PFNGLVERTEXATTRIB2SNVPROC.invoke(load("glVertexAttrib2sNV"), index, x, y);
  }

  public void glTexGenxOES(int coord, int pname, int param) {
    PFNGLTEXGENXOESPROC.invoke(load("glTexGenxOES"), coord, pname, param);
  }

  public void glMultiTexSubImage1DEXT(int texunit, int target, int level, int xoffset, int width, int format, int type, MemorySegment pixels) {
    PFNGLMULTITEXSUBIMAGE1DEXTPROC.invoke(load("glMultiTexSubImage1DEXT"), texunit, target, level, xoffset, width, format, type, pixels);
  }

  public void glUniformMatrix3fv(int location, int count, byte transpose, MemorySegment value) {
    PFNGLUNIFORMMATRIX3FVPROC.invoke(load("glUniformMatrix3fv"), location, count, transpose, value);
  }

  public void glTexStorage2D(int target, int levels, int internalformat, int width, int height) {
    PFNGLTEXSTORAGE2DPROC.invoke(load("glTexStorage2D"), target, levels, internalformat, width, height);
  }

  public void glReplacementCodeuiSUN(int code) {
    PFNGLREPLACEMENTCODEUISUNPROC.invoke(load("glReplacementCodeuiSUN"), code);
  }

  public void glGetUniformIndices(int program, int uniformCount, MemorySegment uniformNames, MemorySegment uniformIndices) {
    PFNGLGETUNIFORMINDICESPROC.invoke(load("glGetUniformIndices"), program, uniformCount, uniformNames, uniformIndices);
  }

  public void glReplacementCodeuiTexCoord2fVertex3fvSUN(MemorySegment rc, MemorySegment tc, MemorySegment v) {
    PFNGLREPLACEMENTCODEUITEXCOORD2FVERTEX3FVSUNPROC.invoke(load("glReplacementCodeuiTexCoord2fVertex3fvSUN"), rc, tc, v);
  }

  public void glBindProgramPipelineEXT(int pipeline) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMapVertexAttrib1fAPPLE(int index, int size, float u1, float u2, int stride, int order, MemorySegment points) {
    PFNGLMAPVERTEXATTRIB1FAPPLEPROC.invoke(load("glMapVertexAttrib1fAPPLE"), index, size, u1, u2, stride, order, points);
  }

  public void glEnableClientStateiEXT(int array, int index) {
    PFNGLENABLECLIENTSTATEIEXTPROC.invoke(load("glEnableClientStateiEXT"), array, index);
  }

  public void glWindowPos3ivARB(MemorySegment v) {
    PFNGLWINDOWPOS3IVARBPROC.invoke(load("glWindowPos3ivARB"), v);
  }

  public void glMultiTexCoord1bvOES(int texture, MemorySegment coords) {
    PFNGLMULTITEXCOORD1BVOESPROC.invoke(load("glMultiTexCoord1bvOES"), texture, coords);
  }

  public void glVertexAttribI2uivEXT(int index, MemorySegment v) {
    PFNGLVERTEXATTRIBI2UIVEXTPROC.invoke(load("glVertexAttribI2uivEXT"), index, v);
  }

  public void glVertexAttribL4d(int index, double x, double y, double z, double w) {
    PFNGLVERTEXATTRIBL4DPROC.invoke(load("glVertexAttribL4d"), index, x, y, z, w);
  }

  public void glTexStorage3D(int target, int levels, int internalformat, int width, int height, int depth) {
    PFNGLTEXSTORAGE3DPROC.invoke(load("glTexStorage3D"), target, levels, internalformat, width, height, depth);
  }

  public void glVDPAUSurfaceAccessNV(long surface, int access) {
    PFNGLVDPAUSURFACEACCESSNVPROC.invoke(load("glVDPAUSurfaceAccessNV"), surface, access);
  }

  public void glGenQueries(int n, MemorySegment ids) {
    PFNGLGENQUERIESPROC.invoke(load("glGenQueries"), n, ids);
  }

  public byte glIsMemoryObjectEXT(int memoryObject) {
    return PFNGLISMEMORYOBJECTEXTPROC.invoke(load("glIsMemoryObjectEXT"), memoryObject);
  }

  public int glGetProgramResourceLocationIndexEXT(int program, int programInterface, MemorySegment name) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttrib3dARB(int index, double x, double y, double z) {
    PFNGLVERTEXATTRIB3DARBPROC.invoke(load("glVertexAttrib3dARB"), index, x, y, z);
  }

  public void glGetActiveSubroutineUniformiv(int program, int shadertype, int index, int pname, MemorySegment values) {
    PFNGLGETACTIVESUBROUTINEUNIFORMIVPROC.invoke(load("glGetActiveSubroutineUniformiv"), program, shadertype, index, pname, values);
  }

  public int glPollAsyncSGIX(MemorySegment markerp) {
    return PFNGLPOLLASYNCSGIXPROC.invoke(load("glPollAsyncSGIX"), markerp);
  }

  public void glEnableVertexArrayEXT(int vaobj, int array) {
    PFNGLENABLEVERTEXARRAYEXTPROC.invoke(load("glEnableVertexArrayEXT"), vaobj, array);
  }

  public void glFlushPixelDataRangeNV(int target) {
    PFNGLFLUSHPIXELDATARANGENVPROC.invoke(load("glFlushPixelDataRangeNV"), target);
  }

  public void glMultiTexCoord3iARB(int target, int s, int t, int r) {
    PFNGLMULTITEXCOORD3IARBPROC.invoke(load("glMultiTexCoord3iARB"), target, s, t, r);
  }

  public void glResetMinmax(int target) {
    PFNGLRESETMINMAXEXTPROC.invoke(load("glResetMinmax"), target);
  }

  public void glTexCoord4fVertex4fvSUN(MemorySegment tc, MemorySegment v) {
    PFNGLTEXCOORD4FVERTEX4FVSUNPROC.invoke(load("glTexCoord4fVertex4fvSUN"), tc, v);
  }

  public void glFogCoorddvEXT(MemorySegment coord) {
    PFNGLFOGCOORDDVEXTPROC.invoke(load("glFogCoorddvEXT"), coord);
  }

  public void glVertexAttrib4uivARB(int index, MemorySegment v) {
    PFNGLVERTEXATTRIB4UIVARBPROC.invoke(load("glVertexAttrib4uivARB"), index, v);
  }

  public void glGetTranslatedShaderSourceANGLE(int shader, int bufSize, MemorySegment length, MemorySegment source) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetTransformFeedbacki64_v(int xfb, int pname, int index, MemorySegment param) {
    PFNGLGETTRANSFORMFEEDBACKI64_VPROC.invoke(load("glGetTransformFeedbacki64_v"), xfb, pname, index, param);
  }

  public void glMultiDrawElementsBaseVertex(int mode, MemorySegment count, int type, MemorySegment indices, int drawcount, MemorySegment basevertex) {
    PFNGLMULTIDRAWELEMENTSBASEVERTEXPROC.invoke(load("glMultiDrawElementsBaseVertex"), mode, count, type, indices, drawcount, basevertex);
  }

  public void glProgramUniform1ui64ARB(int program, int location, long x) {
    PFNGLPROGRAMUNIFORM1UI64ARBPROC.invoke(load("glProgramUniform1ui64ARB"), program, location, x);
  }

  public void glUniformMatrix3x2fv(int location, int count, byte transpose, MemorySegment value) {
    PFNGLUNIFORMMATRIX3X2FVPROC.invoke(load("glUniformMatrix3x2fv"), location, count, transpose, value);
  }

  public void glBinormal3fEXT(float bx, float by, float bz) {
    PFNGLBINORMAL3FEXTPROC.invoke(load("glBinormal3fEXT"), bx, by, bz);
  }

  public void glFlushMappedNamedBufferRange(int buffer, long offset, long length) {
    PFNGLFLUSHMAPPEDNAMEDBUFFERRANGEPROC.invoke(load("glFlushMappedNamedBufferRange"), buffer, offset, length);
  }

  public void glUseShaderProgramEXT(int type, int program) {
    PFNGLUSESHADERPROGRAMEXTPROC.invoke(load("glUseShaderProgramEXT"), type, program);
  }

  public void glLightxv(int light, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetColorTableParameteriv(int target, int pname, MemorySegment params) {
    PFNGLGETCOLORTABLEPARAMETERIVEXTPROC.invoke(load("glGetColorTableParameteriv"), target, pname, params);
  }

  public void glTexCoordP4ui(int type, int coords) {
    PFNGLTEXCOORDP4UIPROC.invoke(load("glTexCoordP4ui"), type, coords);
  }

  public void glNamedFramebufferRenderbufferEXT(int framebuffer, int attachment, int renderbuffertarget, int renderbuffer) {
    PFNGLNAMEDFRAMEBUFFERRENDERBUFFEREXTPROC.invoke(load("glNamedFramebufferRenderbufferEXT"), framebuffer, attachment, renderbuffertarget, renderbuffer);
  }

  public void glVertexAttribI1iEXT(int index, int x) {
    PFNGLVERTEXATTRIBI1IEXTPROC.invoke(load("glVertexAttribI1iEXT"), index, x);
  }

  public void glGetActiveUniformBlockiv(int program, int uniformBlockIndex, int pname, MemorySegment params) {
    PFNGLGETACTIVEUNIFORMBLOCKIVPROC.invoke(load("glGetActiveUniformBlockiv"), program, uniformBlockIndex, pname, params);
  }

  public short glGetStageIndexNV(int shadertype) {
    return PFNGLGETSTAGEINDEXNVPROC.invoke(load("glGetStageIndexNV"), shadertype);
  }

  public void glProgramUniformMatrix2fv(int program, int location, int count, byte transpose, MemorySegment value) {
    PFNGLPROGRAMUNIFORMMATRIX2FVPROC.invoke(load("glProgramUniformMatrix2fv"), program, location, count, transpose, value);
  }

  public void glSecondaryColor3uiEXT(int red, int green, int blue) {
    PFNGLSECONDARYCOLOR3UIEXTPROC.invoke(load("glSecondaryColor3uiEXT"), red, green, blue);
  }

  public void glUniform1iARB(int location, int v0) {
    PFNGLUNIFORM1IARBPROC.invoke(load("glUniform1iARB"), location, v0);
  }

  public void glCompileShaderIncludeARB(int shader, int count, MemorySegment path, MemorySegment length) {
    PFNGLCOMPILESHADERINCLUDEARBPROC.invoke(load("glCompileShaderIncludeARB"), shader, count, path, length);
  }

  public void glFramebufferTexture1DEXT(int target, int attachment, int textarget, int texture, int level) {
    PFNGLFRAMEBUFFERTEXTURE1DEXTPROC.invoke(load("glFramebufferTexture1DEXT"), target, attachment, textarget, texture, level);
  }

  public void glGetPerfQueryInfoINTEL(int queryId, int queryNameLength, MemorySegment queryName, MemorySegment dataSize, MemorySegment noCounters, MemorySegment noInstances, MemorySegment capsMask) {
    PFNGLGETPERFQUERYINFOINTELPROC.invoke(load("glGetPerfQueryInfoINTEL"), queryId, queryNameLength, queryName, dataSize, noCounters, noInstances, capsMask);
  }

  public void glUseProgramStagesEXT(int pipeline, int stages, int program) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexCoord4svARB(int target, MemorySegment v) {
    PFNGLMULTITEXCOORD4SVARBPROC.invoke(load("glMultiTexCoord4svARB"), target, v);
  }

  public void glTexStorageSparseAMD(int target, int internalFormat, int width, int height, int depth, int layers, int flags) {
    PFNGLTEXSTORAGESPARSEAMDPROC.invoke(load("glTexStorageSparseAMD"), target, internalFormat, width, height, depth, layers, flags);
  }

  public void glDrawArraysInstancedNV(int mode, int first, int count, int primcount) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glColor4xvOES(MemorySegment components) {
    PFNGLCOLOR4XVOESPROC.invoke(load("glColor4xvOES"), components);
  }

  public void glUniform2i64ARB(int location, long x, long y) {
    PFNGLUNIFORM2I64ARBPROC.invoke(load("glUniform2i64ARB"), location, x, y);
  }

  public void glVertexAttrib4Nbv(int index, MemorySegment v) {
    PFNGLVERTEXATTRIB4NBVPROC.invoke(load("glVertexAttrib4Nbv"), index, v);
  }

  public void glGetInteger64vAPPLE(int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDeleteMemoryObjectsEXT(int n, MemorySegment memoryObjects) {
    PFNGLDELETEMEMORYOBJECTSEXTPROC.invoke(load("glDeleteMemoryObjectsEXT"), n, memoryObjects);
  }

  public void glMultiTexParameterivEXT(int texunit, int target, int pname, MemorySegment params) {
    PFNGLMULTITEXPARAMETERIVEXTPROC.invoke(load("glMultiTexParameterivEXT"), texunit, target, pname, params);
  }

  public void glVertexAttribI3uiEXT(int index, int x, int y, int z) {
    PFNGLVERTEXATTRIBI3UIEXTPROC.invoke(load("glVertexAttribI3uiEXT"), index, x, y, z);
  }

  public void glBinormal3fvEXT(MemorySegment v) {
    PFNGLBINORMAL3FVEXTPROC.invoke(load("glBinormal3fvEXT"), v);
  }

  public void glProgramUniformMatrix2x3dvEXT(int program, int location, int count, byte transpose, MemorySegment value) {
    PFNGLPROGRAMUNIFORMMATRIX2X3DVEXTPROC.invoke(load("glProgramUniformMatrix2x3dvEXT"), program, location, count, transpose, value);
  }

  public void glLoadMatrixx(MemorySegment m) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribL2dv(int index, MemorySegment v) {
    PFNGLVERTEXATTRIBL2DVPROC.invoke(load("glVertexAttribL2dv"), index, v);
  }

  public void glGetCombinerOutputParameterfvNV(int stage, int portion, int pname, MemorySegment params) {
    PFNGLGETCOMBINEROUTPUTPARAMETERFVNVPROC.invoke(load("glGetCombinerOutputParameterfvNV"), stage, portion, pname, params);
  }

  public void glStencilOpSeparateATI(int face, int sfail, int dpfail, int dppass) {
    PFNGLSTENCILOPSEPARATEATIPROC.invoke(load("glStencilOpSeparateATI"), face, sfail, dpfail, dppass);
  }

  public void glMinSampleShading(float value) {
    PFNGLMINSAMPLESHADINGPROC.invoke(load("glMinSampleShading"), value);
  }

  public void glProgramUniformMatrix2dv(int program, int location, int count, byte transpose, MemorySegment value) {
    PFNGLPROGRAMUNIFORMMATRIX2DVPROC.invoke(load("glProgramUniformMatrix2dv"), program, location, count, transpose, value);
  }

  public void glNamedCopyBufferSubDataEXT(int readBuffer, int writeBuffer, long readOffset, long writeOffset, long size) {
    PFNGLNAMEDCOPYBUFFERSUBDATAEXTPROC.invoke(load("glNamedCopyBufferSubDataEXT"), readBuffer, writeBuffer, readOffset, writeOffset, size);
  }

  public void glValidateProgram(int program) {
    PFNGLVALIDATEPROGRAMPROC.invoke(load("glValidateProgram"), program);
  }

  public void glVertexStream3sATI(int stream, short x, short y, short z) {
    PFNGLVERTEXSTREAM3SATIPROC.invoke(load("glVertexStream3sATI"), stream, x, y, z);
  }

  public void glTextureStorageMem3DEXT(int texture, int levels, int internalFormat, int width, int height, int depth, int memory, long offset) {
    PFNGLTEXTURESTORAGEMEM3DEXTPROC.invoke(load("glTextureStorageMem3DEXT"), texture, levels, internalFormat, width, height, depth, memory, offset);
  }

  public void glProgramUniformMatrix3x4dvEXT(int program, int location, int count, byte transpose, MemorySegment value) {
    PFNGLPROGRAMUNIFORMMATRIX3X4DVEXTPROC.invoke(load("glProgramUniformMatrix3x4dvEXT"), program, location, count, transpose, value);
  }

  public void glDeleteVertexArraysOES(int n, MemorySegment arrays) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDeleteVertexShaderEXT(int id) {
    PFNGLDELETEVERTEXSHADEREXTPROC.invoke(load("glDeleteVertexShaderEXT"), id);
  }

  public void glNamedFramebufferTextureLayer(int framebuffer, int attachment, int texture, int level, int layer) {
    PFNGLNAMEDFRAMEBUFFERTEXTURELAYERPROC.invoke(load("glNamedFramebufferTextureLayer"), framebuffer, attachment, texture, level, layer);
  }

  public void glGetTexFilterFuncSGIS(int target, int filter, MemorySegment weights) {
    PFNGLGETTEXFILTERFUNCSGISPROC.invoke(load("glGetTexFilterFuncSGIS"), target, filter, weights);
  }

  public void glProgramLocalParameter4fvARB(int target, int index, MemorySegment params) {
    PFNGLPROGRAMLOCALPARAMETER4FVARBPROC.invoke(load("glProgramLocalParameter4fvARB"), target, index, params);
  }

  public void glGetLocalConstantBooleanvEXT(int id, int value, MemorySegment data) {
    PFNGLGETLOCALCONSTANTBOOLEANVEXTPROC.invoke(load("glGetLocalConstantBooleanvEXT"), id, value, data);
  }

  public byte glTestObjectAPPLE(int object, int name) {
    return PFNGLTESTOBJECTAPPLEPROC.invoke(load("glTestObjectAPPLE"), object, name);
  }

  public void glCopyTexImage2DEXT(int target, int level, int internalformat, int x, int y, int width, int height, int border) {
    PFNGLCOPYTEXIMAGE2DEXTPROC.invoke(load("glCopyTexImage2DEXT"), target, level, internalformat, x, y, width, height, border);
  }

  public void glVertexStream2fATI(int stream, float x, float y) {
    PFNGLVERTEXSTREAM2FATIPROC.invoke(load("glVertexStream2fATI"), stream, x, y);
  }

  public void glProgramUniform3i64vNV(int program, int location, int count, MemorySegment value) {
    PFNGLPROGRAMUNIFORM3I64VNVPROC.invoke(load("glProgramUniform3i64vNV"), program, location, count, value);
  }

  public void glResizeBuffersMESA() {
    PFNGLRESIZEBUFFERSMESAPROC.invoke(load("glResizeBuffersMESA"));
  }

  public void glDrawElementsInstancedBaseVertexBaseInstanceEXT(int mode, int count, int type, MemorySegment indices, int instancecount, int basevertex, int baseinstance) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetArrayObjectfvATI(int array, int pname, MemorySegment params) {
    PFNGLGETARRAYOBJECTFVATIPROC.invoke(load("glGetArrayObjectfvATI"), array, pname, params);
  }

  public void glMultiDrawElementsIndirectEXT(int mode, int type, MemorySegment indirect, int drawcount, int stride) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramParameters4fvNV(int target, int index, int count, MemorySegment v) {
    PFNGLPROGRAMPARAMETERS4FVNVPROC.invoke(load("glProgramParameters4fvNV"), target, index, count, v);
  }

  public void glUniformHandleui64NV(int location, long value) {
    PFNGLUNIFORMHANDLEUI64NVPROC.invoke(load("glUniformHandleui64NV"), location, value);
  }

  public void glVertexAttrib4Nusv(int index, MemorySegment v) {
    PFNGLVERTEXATTRIB4NUSVPROC.invoke(load("glVertexAttrib4Nusv"), index, v);
  }

  public void glVertexStream1dATI(int stream, double x) {
    PFNGLVERTEXSTREAM1DATIPROC.invoke(load("glVertexStream1dATI"), stream, x);
  }

  public void glMultiTexCoord1svARB(int target, MemorySegment v) {
    PFNGLMULTITEXCOORD1SVARBPROC.invoke(load("glMultiTexCoord1svARB"), target, v);
  }

  public void glProgramParameteri(int program, int pname, int value) {
    PFNGLPROGRAMPARAMETERIPROC.invoke(load("glProgramParameteri"), program, pname, value);
  }

  public void glBindFramebufferEXT(int target, int framebuffer) {
    PFNGLBINDFRAMEBUFFEREXTPROC.invoke(load("glBindFramebufferEXT"), target, framebuffer);
  }

  public void glUniform1ui(int location, int v0) {
    PFNGLUNIFORM1UIPROC.invoke(load("glUniform1ui"), location, v0);
  }

  public void glGetTexParameterIivOES(int target, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexCoordP3uiv(int texture, int type, MemorySegment coords) {
    PFNGLMULTITEXCOORDP3UIVPROC.invoke(load("glMultiTexCoordP3uiv"), texture, type, coords);
  }

  public void glClearBufferuiv(int buffer, int drawbuffer, MemorySegment value) {
    PFNGLCLEARBUFFERUIVPROC.invoke(load("glClearBufferuiv"), buffer, drawbuffer, value);
  }

  public void glDeleteQueryResourceTagNV(int n, MemorySegment tagIds) {
    PFNGLDELETEQUERYRESOURCETAGNVPROC.invoke(load("glDeleteQueryResourceTagNV"), n, tagIds);
  }

  public void glGetBufferPointervARB(int target, int pname, MemorySegment params) {
    PFNGLGETBUFFERPOINTERVARBPROC.invoke(load("glGetBufferPointervARB"), target, pname, params);
  }

  public void glSampleMaskSGIS(float value, byte invert) {
    PFNGLSAMPLEMASKSGISPROC.invoke(load("glSampleMaskSGIS"), value, invert);
  }

  public void glTexEnvxOES(int target, int pname, int param) {
    PFNGLTEXENVXOESPROC.invoke(load("glTexEnvxOES"), target, pname, param);
  }

  public void glDebugMessageInsertARB(int source, int type, int id, int severity, int length, MemorySegment buf) {
    PFNGLDEBUGMESSAGEINSERTARBPROC.invoke(load("glDebugMessageInsertARB"), source, type, id, severity, length, buf);
  }

  public void glGetTexBumpParameterivATI(int pname, MemorySegment param) {
    PFNGLGETTEXBUMPPARAMETERIVATIPROC.invoke(load("glGetTexBumpParameterivATI"), pname, param);
  }

  public void glDepthRangeArrayfvOES(int first, int count, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFragmentColorMaterialSGIX(int face, int mode) {
    PFNGLFRAGMENTCOLORMATERIALSGIXPROC.invoke(load("glFragmentColorMaterialSGIX"), face, mode);
  }

  public void glGetDetailTexFuncSGIS(int target, MemorySegment points) {
    PFNGLGETDETAILTEXFUNCSGISPROC.invoke(load("glGetDetailTexFuncSGIS"), target, points);
  }

  public void glQueryCounterEXT(int id, int target) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMulticastCopyBufferSubDataNV(int readGpu, int writeGpuMask, int readBuffer, int writeBuffer, long readOffset, long writeOffset, long size) {
    PFNGLMULTICASTCOPYBUFFERSUBDATANVPROC.invoke(load("glMulticastCopyBufferSubDataNV"), readGpu, writeGpuMask, readBuffer, writeBuffer, readOffset, writeOffset, size);
  }

  public void glGetPointervEXT(int pname, MemorySegment params) {
    PFNGLGETPOINTERVEXTPROC.invoke(load("glGetPointervEXT"), pname, params);
  }

  public void glTexParameterx(int target, int pname, int param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexCoord4sv(int target, MemorySegment v) {
    PFNGLMULTITEXCOORD4SVARBPROC.invoke(load("glMultiTexCoord4sv"), target, v);
  }

  public void glVertexAttrib4Niv(int index, MemorySegment v) {
    PFNGLVERTEXATTRIB4NIVPROC.invoke(load("glVertexAttrib4Niv"), index, v);
  }

  public void glVideoCaptureStreamParameterdvNV(int video_capture_slot, int stream, int pname, MemorySegment params) {
    PFNGLVIDEOCAPTURESTREAMPARAMETERDVNVPROC.invoke(load("glVideoCaptureStreamParameterdvNV"), video_capture_slot, stream, pname, params);
  }

  public void glGetSharpenTexFuncSGIS(int target, MemorySegment points) {
    PFNGLGETSHARPENTEXFUNCSGISPROC.invoke(load("glGetSharpenTexFuncSGIS"), target, points);
  }

  public void glTextureViewOES(int texture, int target, int origtexture, int internalformat, int minlevel, int numlevels, int minlayer, int numlayers) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetPathDashArrayNV(int path, MemorySegment dashArray) {
    PFNGLGETPATHDASHARRAYNVPROC.invoke(load("glGetPathDashArrayNV"), path, dashArray);
  }

  public void glPixelTransformParameterivEXT(int target, int pname, MemorySegment params) {
    PFNGLPIXELTRANSFORMPARAMETERIVEXTPROC.invoke(load("glPixelTransformParameterivEXT"), target, pname, params);
  }

  public void glGetColorTableParameterfv(int target, int pname, MemorySegment params) {
    PFNGLGETCOLORTABLEPARAMETERFVEXTPROC.invoke(load("glGetColorTableParameterfv"), target, pname, params);
  }

  public void glGetBufferPointerv(int target, int pname, MemorySegment params) {
    PFNGLGETBUFFERPOINTERVPROC.invoke(load("glGetBufferPointerv"), target, pname, params);
  }

  public void glProgramLocalParameter4dARB(int target, int index, double x, double y, double z, double w) {
    PFNGLPROGRAMLOCALPARAMETER4DARBPROC.invoke(load("glProgramLocalParameter4dARB"), target, index, x, y, z, w);
  }

  public void glSignalSemaphoreEXT(int semaphore, int numBufferBarriers, MemorySegment buffers, int numTextureBarriers, MemorySegment textures, MemorySegment dstLayouts) {
    PFNGLSIGNALSEMAPHOREEXTPROC.invoke(load("glSignalSemaphoreEXT"), semaphore, numBufferBarriers, buffers, numTextureBarriers, textures, dstLayouts);
  }

  public void glGetTexGenivOES(int coord, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTextureParameterfvEXT(int texture, int target, int pname, MemorySegment params) {
    PFNGLTEXTUREPARAMETERFVEXTPROC.invoke(load("glTextureParameterfvEXT"), texture, target, pname, params);
  }

  public void glLightx(int light, int pname, int param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribL1dEXT(int index, double x) {
    PFNGLVERTEXATTRIBL1DEXTPROC.invoke(load("glVertexAttribL1dEXT"), index, x);
  }

  public void glDrawTexxOES(int x, int y, int z, int width, int height) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexCoord4dv(int target, MemorySegment v) {
    PFNGLMULTITEXCOORD4DVARBPROC.invoke(load("glMultiTexCoord4dv"), target, v);
  }

  public void glPresentFrameDualFillNV(int video_slot, long minPresentTime, int beginPresentTimeId, int presentDurationId, int type, int target0, int fill0, int target1, int fill1, int target2, int fill2, int target3, int fill3) {
    PFNGLPRESENTFRAMEDUALFILLNVPROC.invoke(load("glPresentFrameDualFillNV"), video_slot, minPresentTime, beginPresentTimeId, presentDurationId, type, target0, fill0, target1, fill1, target2, fill2, target3, fill3);
  }

  public void glGetMinmaxParameterivEXT(int target, int pname, MemorySegment params) {
    PFNGLGETMINMAXPARAMETERIVEXTPROC.invoke(load("glGetMinmaxParameterivEXT"), target, pname, params);
  }

  public void glLGPUInterlockNVX() {
    PFNGLLGPUINTERLOCKNVXPROC.invoke(load("glLGPUInterlockNVX"));
  }

  public void glBindBufferRange(int target, int index, int buffer, long offset, long size) {
    PFNGLBINDBUFFERRANGEPROC.invoke(load("glBindBufferRange"), target, index, buffer, offset, size);
  }

  public void glCombinerParameterfvNV(int pname, MemorySegment params) {
    PFNGLCOMBINERPARAMETERFVNVPROC.invoke(load("glCombinerParameterfvNV"), pname, params);
  }

  public void glMultMatrixx(MemorySegment m) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glPathSubCoordsNV(int path, int coordStart, int numCoords, int coordType, MemorySegment coords) {
    PFNGLPATHSUBCOORDSNVPROC.invoke(load("glPathSubCoordsNV"), path, coordStart, numCoords, coordType, coords);
  }

  public void glVertexStream3fvATI(int stream, MemorySegment coords) {
    PFNGLVERTEXSTREAM3FVATIPROC.invoke(load("glVertexStream3fvATI"), stream, coords);
  }

  public void glReferencePlaneSGIX(MemorySegment equation) {
    PFNGLREFERENCEPLANESGIXPROC.invoke(load("glReferencePlaneSGIX"), equation);
  }

  public void glWindowPos4iMESA(int x, int y, int z, int w) {
    PFNGLWINDOWPOS4IMESAPROC.invoke(load("glWindowPos4iMESA"), x, y, z, w);
  }

  public void glGetPixelTransformParameterivEXT(int target, int pname, MemorySegment params) {
    PFNGLGETPIXELTRANSFORMPARAMETERIVEXTPROC.invoke(load("glGetPixelTransformParameterivEXT"), target, pname, params);
  }

  public void glQueryObjectParameteruiAMD(int target, int id, int pname, int param) {
    PFNGLQUERYOBJECTPARAMETERUIAMDPROC.invoke(load("glQueryObjectParameteruiAMD"), target, id, pname, param);
  }

  public void glBlendEquationiEXT(int buf, int mode) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDebugMessageControlKHR(int source, int type, int severity, int count, MemorySegment ids, byte enabled) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glWindowPos3iARB(int x, int y, int z) {
    PFNGLWINDOWPOS3IARBPROC.invoke(load("glWindowPos3iARB"), x, y, z);
  }

  public void glBindShadingRateImageNV(int texture) {
    PFNGLBINDSHADINGRATEIMAGENVPROC.invoke(load("glBindShadingRateImageNV"), texture);
  }

  public void glVertexArrayVertexAttribIFormatEXT(int vaobj, int attribindex, int size, int type, int relativeoffset) {
    PFNGLVERTEXARRAYVERTEXATTRIBIFORMATEXTPROC.invoke(load("glVertexArrayVertexAttribIFormatEXT"), vaobj, attribindex, size, type, relativeoffset);
  }

  public void glTextureImage3DMultisampleCoverageNV(int texture, int target, int coverageSamples, int colorSamples, int internalFormat, int width, int height, int depth, byte fixedSampleLocations) {
    PFNGLTEXTUREIMAGE3DMULTISAMPLECOVERAGENVPROC.invoke(load("glTextureImage3DMultisampleCoverageNV"), texture, target, coverageSamples, colorSamples, internalFormat, width, height, depth, fixedSampleLocations);
  }

  public void glMultiTexCoord3ivARB(int target, MemorySegment v) {
    PFNGLMULTITEXCOORD3IVARBPROC.invoke(load("glMultiTexCoord3ivARB"), target, v);
  }

  public void glProgramUniform2ui64vARB(int program, int location, int count, MemorySegment value) {
    PFNGLPROGRAMUNIFORM2UI64VARBPROC.invoke(load("glProgramUniform2ui64vARB"), program, location, count, value);
  }

  public void glMultiTexCoord4fv(int target, MemorySegment v) {
    PFNGLMULTITEXCOORD4FVARBPROC.invoke(load("glMultiTexCoord4fv"), target, v);
  }

  public void glGetBufferParameteri64v(int target, int pname, MemorySegment params) {
    PFNGLGETBUFFERPARAMETERI64VPROC.invoke(load("glGetBufferParameteri64v"), target, pname, params);
  }

  public void glRasterPos4xOES(int x, int y, int z, int w) {
    PFNGLRASTERPOS4XOESPROC.invoke(load("glRasterPos4xOES"), x, y, z, w);
  }

  public void glTextureColorMaskSGIS(byte red, byte green, byte blue, byte alpha) {
    PFNGLTEXTURECOLORMASKSGISPROC.invoke(load("glTextureColorMaskSGIS"), red, green, blue, alpha);
  }

  public void glGetListParameterivSGIX(int list, int pname, MemorySegment params) {
    PFNGLGETLISTPARAMETERIVSGIXPROC.invoke(load("glGetListParameterivSGIX"), list, pname, params);
  }

  public void glVertexArrayColorOffsetEXT(int vaobj, int buffer, int size, int type, int stride, long offset) {
    PFNGLVERTEXARRAYCOLOROFFSETEXTPROC.invoke(load("glVertexArrayColorOffsetEXT"), vaobj, buffer, size, type, stride, offset);
  }

  public void glBlendFuncSeparateEXT(int sfactorRGB, int dfactorRGB, int sfactorAlpha, int dfactorAlpha) {
    PFNGLBLENDFUNCSEPARATEEXTPROC.invoke(load("glBlendFuncSeparateEXT"), sfactorRGB, dfactorRGB, sfactorAlpha, dfactorAlpha);
  }

  public void glDebugMessageInsertAMD(int category, int severity, int id, int length, MemorySegment buf) {
    PFNGLDEBUGMESSAGEINSERTAMDPROC.invoke(load("glDebugMessageInsertAMD"), category, severity, id, length, buf);
  }

  public void glBeginConditionalRenderNV(int id, int mode) {
    PFNGLBEGINCONDITIONALRENDERNVPROC.invoke(load("glBeginConditionalRenderNV"), id, mode);
  }

  public void glMultiDrawArraysIndirectCount(int mode, MemorySegment indirect, long drawcount, int maxdrawcount, int stride) {
    PFNGLMULTIDRAWARRAYSINDIRECTCOUNTPROC.invoke(load("glMultiDrawArraysIndirectCount"), mode, indirect, drawcount, maxdrawcount, stride);
  }

  public void glDeleteRenderbuffers(int n, MemorySegment renderbuffers) {
    PFNGLDELETERENDERBUFFERSPROC.invoke(load("glDeleteRenderbuffers"), n, renderbuffers);
  }

  public void glProgramUniform3i64vARB(int program, int location, int count, MemorySegment value) {
    PFNGLPROGRAMUNIFORM3I64VARBPROC.invoke(load("glProgramUniform3i64vARB"), program, location, count, value);
  }

  public void glVertexAttribI1ui(int index, int x) {
    PFNGLVERTEXATTRIBI1UIPROC.invoke(load("glVertexAttribI1ui"), index, x);
  }

  public void glDisableVariantClientStateEXT(int id) {
    PFNGLDISABLEVARIANTCLIENTSTATEEXTPROC.invoke(load("glDisableVariantClientStateEXT"), id);
  }

  public void glColor4xOES(int red, int green, int blue, int alpha) {
    PFNGLCOLOR4XOESPROC.invoke(load("glColor4xOES"), red, green, blue, alpha);
  }

  public void glStencilOpValueAMD(int face, int value) {
    PFNGLSTENCILOPVALUEAMDPROC.invoke(load("glStencilOpValueAMD"), face, value);
  }

  public void glGenRenderbuffersOES(int n, MemorySegment renderbuffers) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttrib4Nuiv(int index, MemorySegment v) {
    PFNGLVERTEXATTRIB4NUIVPROC.invoke(load("glVertexAttrib4Nuiv"), index, v);
  }

  public void glNamedBufferPageCommitmentARB(int buffer, long offset, long size, byte commit) {
    PFNGLNAMEDBUFFERPAGECOMMITMENTARBPROC.invoke(load("glNamedBufferPageCommitmentARB"), buffer, offset, size, commit);
  }

  public void glMultiTexGeniEXT(int texunit, int coord, int pname, int param) {
    PFNGLMULTITEXGENIEXTPROC.invoke(load("glMultiTexGeniEXT"), texunit, coord, pname, param);
  }

  public void glGetnUniformivEXT(int program, int location, int bufSize, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertex4xvOES(MemorySegment coords) {
    PFNGLVERTEX4XVOESPROC.invoke(load("glVertex4xvOES"), coords);
  }

  public void glDeleteFramebuffersOES(int n, MemorySegment framebuffers) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniform4uiv(int program, int location, int count, MemorySegment value) {
    PFNGLPROGRAMUNIFORM4UIVPROC.invoke(load("glProgramUniform4uiv"), program, location, count, value);
  }

  public void glTexBufferOES(int target, int internalformat, int buffer) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glSpecializeShaderARB(int shader, MemorySegment pEntryPoint, int numSpecializationConstants, MemorySegment pConstantIndex, MemorySegment pConstantValue) {
    PFNGLSPECIALIZESHADERARBPROC.invoke(load("glSpecializeShaderARB"), shader, pEntryPoint, numSpecializationConstants, pConstantIndex, pConstantValue);
  }

  public void glEvalMapsNV(int target, int mode) {
    PFNGLEVALMAPSNVPROC.invoke(load("glEvalMapsNV"), target, mode);
  }

  public void glMulticastBufferSubDataNV(int gpuMask, int buffer, long offset, long size, MemorySegment data) {
    PFNGLMULTICASTBUFFERSUBDATANVPROC.invoke(load("glMulticastBufferSubDataNV"), gpuMask, buffer, offset, size, data);
  }

  public void glMatrixScalefEXT(int mode, float x, float y, float z) {
    PFNGLMATRIXSCALEFEXTPROC.invoke(load("glMatrixScalefEXT"), mode, x, y, z);
  }

  public void glMultiTexCoord4iv(int target, MemorySegment v) {
    PFNGLMULTITEXCOORD4IVARBPROC.invoke(load("glMultiTexCoord4iv"), target, v);
  }

  public void glGetProgramStageiv(int program, int shadertype, int pname, MemorySegment values) {
    PFNGLGETPROGRAMSTAGEIVPROC.invoke(load("glGetProgramStageiv"), program, shadertype, pname, values);
  }

  public void glGetnCompressedTexImageARB(int target, int lod, int bufSize, MemorySegment img) {
    PFNGLGETNCOMPRESSEDTEXIMAGEARBPROC.invoke(load("glGetnCompressedTexImageARB"), target, lod, bufSize, img);
  }

  public void glLGPUNamedBufferSubDataNVX(int gpuMask, int buffer, long offset, long size, MemorySegment data) {
    PFNGLLGPUNAMEDBUFFERSUBDATANVXPROC.invoke(load("glLGPUNamedBufferSubDataNVX"), gpuMask, buffer, offset, size, data);
  }

  public void glProgramUniform1uivEXT(int program, int location, int count, MemorySegment value) {
    PFNGLPROGRAMUNIFORM1UIVEXTPROC.invoke(load("glProgramUniform1uivEXT"), program, location, count, value);
  }

  public void glGetLocalConstantIntegervEXT(int id, int value, MemorySegment data) {
    PFNGLGETLOCALCONSTANTINTEGERVEXTPROC.invoke(load("glGetLocalConstantIntegervEXT"), id, value, data);
  }

  public void glTextureSubImage3D(int texture, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int format, int type, MemorySegment pixels) {
    PFNGLTEXTURESUBIMAGE3DPROC.invoke(load("glTextureSubImage3D"), texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels);
  }

  public void glVertexAttribI3uiv(int index, MemorySegment v) {
    PFNGLVERTEXATTRIBI3UIVPROC.invoke(load("glVertexAttribI3uiv"), index, v);
  }

  public void glClearTexImage(int texture, int level, int format, int type, MemorySegment data) {
    PFNGLCLEARTEXIMAGEPROC.invoke(load("glClearTexImage"), texture, level, format, type, data);
  }

  public void glTangent3fEXT(float tx, float ty, float tz) {
    PFNGLTANGENT3FEXTPROC.invoke(load("glTangent3fEXT"), tx, ty, tz);
  }

  public void glVertexAttrib1sv(int index, MemorySegment v) {
    PFNGLVERTEXATTRIB1SVPROC.invoke(load("glVertexAttrib1sv"), index, v);
  }

  public void glExtGetBuffersQCOM(MemorySegment buffers, int maxBuffers, MemorySegment numBuffers) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetMultiTexParameterivEXT(int texunit, int target, int pname, MemorySegment params) {
    PFNGLGETMULTITEXPARAMETERIVEXTPROC.invoke(load("glGetMultiTexParameterivEXT"), texunit, target, pname, params);
  }

  public void glMaterialxOES(int face, int pname, int param) {
    PFNGLMATERIALXOESPROC.invoke(load("glMaterialxOES"), face, pname, param);
  }

  public void glMaxShaderCompilerThreadsKHR(int count) {
    PFNGLMAXSHADERCOMPILERTHREADSKHRPROC.invoke(load("glMaxShaderCompilerThreadsKHR"), count);
  }

  public void glVertex2hvNV(MemorySegment v) {
    PFNGLVERTEX2HVNVPROC.invoke(load("glVertex2hvNV"), v);
  }

  public void glDrawTexivOES(MemorySegment coords) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGenFencesNV(int n, MemorySegment fences) {
    PFNGLGENFENCESNVPROC.invoke(load("glGenFencesNV"), n, fences);
  }

  public void glMulticastScissorArrayvNVX(int gpu, int first, int count, MemorySegment v) {
    PFNGLMULTICASTSCISSORARRAYVNVXPROC.invoke(load("glMulticastScissorArrayvNVX"), gpu, first, count, v);
  }

  public void glViewportArrayvOES(int first, int count, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTextureSubImage2D(int texture, int level, int xoffset, int yoffset, int width, int height, int format, int type, MemorySegment pixels) {
    PFNGLTEXTURESUBIMAGE2DPROC.invoke(load("glTextureSubImage2D"), texture, level, xoffset, yoffset, width, height, format, type, pixels);
  }

  public void glVertexAttrib1hNV(int index, short x) {
    PFNGLVERTEXATTRIB1HNVPROC.invoke(load("glVertexAttrib1hNV"), index, x);
  }

  public void glDebugMessageControl(int source, int type, int severity, int count, MemorySegment ids, byte enabled) {
    PFNGLDEBUGMESSAGECONTROLPROC.invoke(load("glDebugMessageControl"), source, type, severity, count, ids, enabled);
  }

  public void glUniform3i64vARB(int location, int count, MemorySegment value) {
    PFNGLUNIFORM3I64VARBPROC.invoke(load("glUniform3i64vARB"), location, count, value);
  }

  public void glFlushMappedNamedBufferRangeEXT(int buffer, long offset, long length) {
    PFNGLFLUSHMAPPEDNAMEDBUFFERRANGEEXTPROC.invoke(load("glFlushMappedNamedBufferRangeEXT"), buffer, offset, length);
  }

  public void glArrayObjectATI(int array, int size, int type, int stride, int buffer, int offset) {
    PFNGLARRAYOBJECTATIPROC.invoke(load("glArrayObjectATI"), array, size, type, stride, buffer, offset);
  }

  public void glGetActiveUniformBlockName(int program, int uniformBlockIndex, int bufSize, MemorySegment length, MemorySegment uniformBlockName) {
    PFNGLGETACTIVEUNIFORMBLOCKNAMEPROC.invoke(load("glGetActiveUniformBlockName"), program, uniformBlockIndex, bufSize, length, uniformBlockName);
  }

  public void glGetColorTable(int target, int format, int type, MemorySegment table) {
    PFNGLGETCOLORTABLEEXTPROC.invoke(load("glGetColorTable"), target, format, type, table);
  }

  public void glRenderbufferStorageMultisampleAPPLE(int target, int samples, int internalformat, int width, int height) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public byte glIsProgramARB(int program) {
    return PFNGLISPROGRAMARBPROC.invoke(load("glIsProgramARB"), program);
  }

  public void glBlitFramebufferEXT(int srcX0, int srcY0, int srcX1, int srcY1, int dstX0, int dstY0, int dstX1, int dstY1, int mask, int filter) {
    PFNGLBLITFRAMEBUFFEREXTPROC.invoke(load("glBlitFramebufferEXT"), srcX0, srcY0, srcX1, srcY1, dstX0, dstY0, dstX1, dstY1, mask, filter);
  }

  public int glAsyncCopyBufferSubDataNVX(int waitSemaphoreCount, MemorySegment waitSemaphoreArray, MemorySegment fenceValueArray, int readGpu, int writeGpuMask, int readBuffer, int writeBuffer, long readOffset, long writeOffset, long size, int signalSemaphoreCount, MemorySegment signalSemaphoreArray, MemorySegment signalValueArray) {
    return PFNGLASYNCCOPYBUFFERSUBDATANVXPROC.invoke(load("glAsyncCopyBufferSubDataNVX"), waitSemaphoreCount, waitSemaphoreArray, fenceValueArray, readGpu, writeGpuMask, readBuffer, writeBuffer, readOffset, writeOffset, size, signalSemaphoreCount, signalSemaphoreArray, signalValueArray);
  }

  public void glProgramEnvParameterI4iNV(int target, int index, int x, int y, int z, int w) {
    PFNGLPROGRAMENVPARAMETERI4INVPROC.invoke(load("glProgramEnvParameterI4iNV"), target, index, x, y, z, w);
  }

  public void glTexSubImage4DSGIS(int target, int level, int xoffset, int yoffset, int zoffset, int woffset, int width, int height, int depth, int size4d, int format, int type, MemorySegment pixels) {
    PFNGLTEXSUBIMAGE4DSGISPROC.invoke(load("glTexSubImage4DSGIS"), target, level, xoffset, yoffset, zoffset, woffset, width, height, depth, size4d, format, type, pixels);
  }

  public void glGetProgramivNV(int id, int pname, MemorySegment params) {
    PFNGLGETPROGRAMIVNVPROC.invoke(load("glGetProgramivNV"), id, pname, params);
  }

  public void glInvalidateTexSubImage(int texture, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth) {
    PFNGLINVALIDATETEXSUBIMAGEPROC.invoke(load("glInvalidateTexSubImage"), texture, level, xoffset, yoffset, zoffset, width, height, depth);
  }

  public void glVertexAttrib4dvNV(int index, MemorySegment v) {
    PFNGLVERTEXATTRIB4DVNVPROC.invoke(load("glVertexAttrib4dvNV"), index, v);
  }

  public void glEndTransformFeedbackEXT() {
    PFNGLENDTRANSFORMFEEDBACKEXTPROC.invoke(load("glEndTransformFeedbackEXT"));
  }

  public void glTextureSubImage1D(int texture, int level, int xoffset, int width, int format, int type, MemorySegment pixels) {
    PFNGLTEXTURESUBIMAGE1DPROC.invoke(load("glTextureSubImage1D"), texture, level, xoffset, width, format, type, pixels);
  }

  public void glGetMultiTexGenfvEXT(int texunit, int coord, int pname, MemorySegment params) {
    PFNGLGETMULTITEXGENFVEXTPROC.invoke(load("glGetMultiTexGenfvEXT"), texunit, coord, pname, params);
  }

  public void glCompressedTexImage2DARB(int target, int level, int internalformat, int width, int height, int border, int imageSize, MemorySegment data) {
    PFNGLCOMPRESSEDTEXIMAGE2DARBPROC.invoke(load("glCompressedTexImage2DARB"), target, level, internalformat, width, height, border, imageSize, data);
  }

  public void glPathStringNV(int path, int format, int length, MemorySegment pathString) {
    PFNGLPATHSTRINGNVPROC.invoke(load("glPathStringNV"), path, format, length, pathString);
  }

  public void glGetMapControlPointsNV(int target, int index, int type, int ustride, int vstride, byte packed, MemorySegment points) {
    PFNGLGETMAPCONTROLPOINTSNVPROC.invoke(load("glGetMapControlPointsNV"), target, index, type, ustride, vstride, packed, points);
  }

  public void glDeformationMap3dSGIX(int target, double u1, double u2, int ustride, int uorder, double v1, double v2, int vstride, int vorder, double w1, double w2, int wstride, int worder, MemorySegment points) {
    PFNGLDEFORMATIONMAP3DSGIXPROC.invoke(load("glDeformationMap3dSGIX"), target, u1, u2, ustride, uorder, v1, v2, vstride, vorder, w1, w2, wstride, worder, points);
  }

  public void glGetPointerIndexedvEXT(int target, int index, MemorySegment data) {
    PFNGLGETPOINTERINDEXEDVEXTPROC.invoke(load("glGetPointerIndexedvEXT"), target, index, data);
  }

  public void glGetVertexAttribivNV(int index, int pname, MemorySegment params) {
    PFNGLGETVERTEXATTRIBIVNVPROC.invoke(load("glGetVertexAttribivNV"), index, pname, params);
  }

  public void glProgramUniform3i64ARB(int program, int location, long x, long y, long z) {
    PFNGLPROGRAMUNIFORM3I64ARBPROC.invoke(load("glProgramUniform3i64ARB"), program, location, x, y, z);
  }

  public void glSetLocalConstantEXT(int id, int type, MemorySegment addr) {
    PFNGLSETLOCALCONSTANTEXTPROC.invoke(load("glSetLocalConstantEXT"), id, type, addr);
  }

  public byte glIsVertexArray(int array) {
    return PFNGLISVERTEXARRAYPROC.invoke(load("glIsVertexArray"), array);
  }

  public void glFramebufferTexture2DMultisampleEXT(int target, int attachment, int textarget, int texture, int level, int samples) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexCoord1sARB(int target, short s) {
    PFNGLMULTITEXCOORD1SARBPROC.invoke(load("glMultiTexCoord1sARB"), target, s);
  }

  public int glVideoCaptureNV(int video_capture_slot, MemorySegment sequence_num, MemorySegment capture_time) {
    return PFNGLVIDEOCAPTURENVPROC.invoke(load("glVideoCaptureNV"), video_capture_slot, sequence_num, capture_time);
  }

  public void glGetnMinmax(int target, byte reset, int format, int type, int bufSize, MemorySegment values) {
    PFNGLGETNMINMAXPROC.invoke(load("glGetnMinmax"), target, reset, format, type, bufSize, values);
  }

  public MemorySegment glFenceSync(int condition, int flags) {
    return PFNGLFENCESYNCPROC.invoke(load("glFenceSync"), condition, flags);
  }

  public void glFramebufferDrawBufferEXT(int framebuffer, int mode) {
    PFNGLFRAMEBUFFERDRAWBUFFEREXTPROC.invoke(load("glFramebufferDrawBufferEXT"), framebuffer, mode);
  }

  public void glFogx(int pname, int param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBindAttribLocation(int program, int index, MemorySegment name) {
    PFNGLBINDATTRIBLOCATIONPROC.invoke(load("glBindAttribLocation"), program, index, name);
  }

  public void glListDrawCommandsStatesClientNV(int list, int segment, MemorySegment indirects, MemorySegment sizes, MemorySegment states, MemorySegment fbos, int count) {
    PFNGLLISTDRAWCOMMANDSSTATESCLIENTNVPROC.invoke(load("glListDrawCommandsStatesClientNV"), list, segment, indirects, sizes, states, fbos, count);
  }

  public void glGetProgramPipelineivEXT(int pipeline, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glRasterPos2xvOES(MemorySegment coords) {
    PFNGLRASTERPOS2XVOESPROC.invoke(load("glRasterPos2xvOES"), coords);
  }

  public void glProgramUniformMatrix3fvEXT(int program, int location, int count, byte transpose, MemorySegment value) {
    PFNGLPROGRAMUNIFORMMATRIX3FVEXTPROC.invoke(load("glProgramUniformMatrix3fvEXT"), program, location, count, transpose, value);
  }

  public void glGetMaterialxv(int face, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetnUniformfvEXT(int program, int location, int bufSize, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniformMatrix4x2fvEXT(int program, int location, int count, byte transpose, MemorySegment value) {
    PFNGLPROGRAMUNIFORMMATRIX4X2FVEXTPROC.invoke(load("glProgramUniformMatrix4x2fvEXT"), program, location, count, transpose, value);
  }

  public void glDeformSGIX(int mask) {
    PFNGLDEFORMSGIXPROC.invoke(load("glDeformSGIX"), mask);
  }

  public void glStartTilingQCOM(int x, int y, int width, int height, int preserveMask) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glSecondaryColor3dvEXT(MemorySegment v) {
    PFNGLSECONDARYCOLOR3DVEXTPROC.invoke(load("glSecondaryColor3dvEXT"), v);
  }

  public void glTexCoordPointerListIBM(int size, int type, int stride, MemorySegment pointer, int ptrstride) {
    PFNGLTEXCOORDPOINTERLISTIBMPROC.invoke(load("glTexCoordPointerListIBM"), size, type, stride, pointer, ptrstride);
  }

  public void glEndFragmentShaderATI() {
    PFNGLENDFRAGMENTSHADERATIPROC.invoke(load("glEndFragmentShaderATI"));
  }

  public void glProgramUniform3iEXT(int program, int location, int v0, int v1, int v2) {
    PFNGLPROGRAMUNIFORM3IEXTPROC.invoke(load("glProgramUniform3iEXT"), program, location, v0, v1, v2);
  }

  public void glVertexAttrib1fNV(int index, float x) {
    PFNGLVERTEXATTRIB1FNVPROC.invoke(load("glVertexAttrib1fNV"), index, x);
  }

  public void glBindAttribLocationARB(int programObj, int index, MemorySegment name) {
    opengl.windows.PFNGLBINDATTRIBLOCATIONARBPROC.invoke(load("glBindAttribLocationARB"), programObj, index, name);
  }

  public void glLightxvOES(int light, int pname, MemorySegment params) {
    PFNGLLIGHTXVOESPROC.invoke(load("glLightxvOES"), light, pname, params);
  }

  public void glGetHistogramEXT(int target, byte reset, int format, int type, MemorySegment values) {
    PFNGLGETHISTOGRAMEXTPROC.invoke(load("glGetHistogramEXT"), target, reset, format, type, values);
  }

  public void glFramebufferSampleLocationsfvNV(int target, int start, int count, MemorySegment v) {
    PFNGLFRAMEBUFFERSAMPLELOCATIONSFVNVPROC.invoke(load("glFramebufferSampleLocationsfvNV"), target, start, count, v);
  }

  public void glNamedBufferStorageExternalEXT(int buffer, long offset, long size, MemorySegment clientBuffer, int flags) {
    PFNGLNAMEDBUFFERSTORAGEEXTERNALEXTPROC.invoke(load("glNamedBufferStorageExternalEXT"), buffer, offset, size, clientBuffer, flags);
  }

  public void glTexEnvx(int target, int pname, int param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribP4uiv(int index, int type, byte normalized, MemorySegment value) {
    PFNGLVERTEXATTRIBP4UIVPROC.invoke(load("glVertexAttribP4uiv"), index, type, normalized, value);
  }

  public void glGetQueryivARB(int target, int pname, MemorySegment params) {
    PFNGLGETQUERYIVARBPROC.invoke(load("glGetQueryivARB"), target, pname, params);
  }

  public void glInvalidateSubFramebuffer(int target, int numAttachments, MemorySegment attachments, int x, int y, int width, int height) {
    PFNGLINVALIDATESUBFRAMEBUFFERPROC.invoke(load("glInvalidateSubFramebuffer"), target, numAttachments, attachments, x, y, width, height);
  }

  public void glEvalCoord1xOES(int u) {
    PFNGLEVALCOORD1XOESPROC.invoke(load("glEvalCoord1xOES"), u);
  }

  public void glMultiTexCoord2fvARB(int target, MemorySegment v) {
    PFNGLMULTITEXCOORD2FVARBPROC.invoke(load("glMultiTexCoord2fvARB"), target, v);
  }

  public void glTexCoord2fVertex3fvSUN(MemorySegment tc, MemorySegment v) {
    PFNGLTEXCOORD2FVERTEX3FVSUNPROC.invoke(load("glTexCoord2fVertex3fvSUN"), tc, v);
  }

  public void glWindowPos2fvMESA(MemorySegment v) {
    PFNGLWINDOWPOS2FVMESAPROC.invoke(load("glWindowPos2fvMESA"), v);
  }

  public void glWeightfvARB(int size, MemorySegment weights) {
    PFNGLWEIGHTFVARBPROC.invoke(load("glWeightfvARB"), size, weights);
  }

  public void glProgramUniform4i(int program, int location, int v0, int v1, int v2, int v3) {
    PFNGLPROGRAMUNIFORM4IPROC.invoke(load("glProgramUniform4i"), program, location, v0, v1, v2, v3);
  }

  public void glProgramUniform4d(int program, int location, double v0, double v1, double v2, double v3) {
    PFNGLPROGRAMUNIFORM4DPROC.invoke(load("glProgramUniform4d"), program, location, v0, v1, v2, v3);
  }

  public void glProgramUniform4f(int program, int location, float v0, float v1, float v2, float v3) {
    PFNGLPROGRAMUNIFORM4FPROC.invoke(load("glProgramUniform4f"), program, location, v0, v1, v2, v3);
  }

  public void glDrawArraysEXT(int mode, int first, int count) {
    PFNGLDRAWARRAYSEXTPROC.invoke(load("glDrawArraysEXT"), mode, first, count);
  }

  public void glPointParameteriNV(int pname, int param) {
    PFNGLPOINTPARAMETERINVPROC.invoke(load("glPointParameteriNV"), pname, param);
  }

  public void glEGLImageTargetTexture2DOES(int target, MemorySegment image) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFeedbackBufferxOES(int n, int type, MemorySegment buffer) {
    PFNGLFEEDBACKBUFFERXOESPROC.invoke(load("glFeedbackBufferxOES"), n, type, buffer);
  }

  public void glBufferParameteriAPPLE(int target, int pname, int param) {
    PFNGLBUFFERPARAMETERIAPPLEPROC.invoke(load("glBufferParameteriAPPLE"), target, pname, param);
  }

  public void glPatchParameteriOES(int pname, int value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBufferDataARB(int target, long size, MemorySegment data, int usage) {
    PFNGLBUFFERDATAARBPROC.invoke(load("glBufferDataARB"), target, size, data, usage);
  }

  public void glGetLocalConstantFloatvEXT(int id, int value, MemorySegment data) {
    PFNGLGETLOCALCONSTANTFLOATVEXTPROC.invoke(load("glGetLocalConstantFloatvEXT"), id, value, data);
  }

  public void glWaitSemaphoreui64NVX(int waitGpu, int fenceObjectCount, MemorySegment semaphoreArray, MemorySegment fenceValueArray) {
    PFNGLWAITSEMAPHOREUI64NVXPROC.invoke(load("glWaitSemaphoreui64NVX"), waitGpu, fenceObjectCount, semaphoreArray, fenceValueArray);
  }

  public void glDeleteSyncAPPLE(MemorySegment sync) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glEndTilingQCOM(int preserveMask) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glWriteMaskEXT(int res, int in, int outX, int outY, int outZ, int outW) {
    PFNGLWRITEMASKEXTPROC.invoke(load("glWriteMaskEXT"), res, in, outX, outY, outZ, outW);
  }

  public void glGetFramebufferAttachmentParameteriv(int target, int attachment, int pname, MemorySegment params) {
    PFNGLGETFRAMEBUFFERATTACHMENTPARAMETERIVPROC.invoke(load("glGetFramebufferAttachmentParameteriv"), target, attachment, pname, params);
  }

  public void glTextureImage3DEXT(int texture, int target, int level, int internalformat, int width, int height, int depth, int border, int format, int type, MemorySegment pixels) {
    PFNGLTEXTUREIMAGE3DEXTPROC.invoke(load("glTextureImage3DEXT"), texture, target, level, internalformat, width, height, depth, border, format, type, pixels);
  }

  public void glPixelTransferxOES(int pname, int param) {
    PFNGLPIXELTRANSFERXOESPROC.invoke(load("glPixelTransferxOES"), pname, param);
  }

  public void glProgramUniform2f(int program, int location, float v0, float v1) {
    PFNGLPROGRAMUNIFORM2FPROC.invoke(load("glProgramUniform2f"), program, location, v0, v1);
  }

  public void glProgramUniform2i(int program, int location, int v0, int v1) {
    PFNGLPROGRAMUNIFORM2IPROC.invoke(load("glProgramUniform2i"), program, location, v0, v1);
  }

  public void glTexCoord2xvOES(MemorySegment coords) {
    PFNGLTEXCOORD2XVOESPROC.invoke(load("glTexCoord2xvOES"), coords);
  }

  public void glDrawArraysInstanced(int mode, int first, int count, int instancecount) {
    PFNGLDRAWARRAYSINSTANCEDPROC.invoke(load("glDrawArraysInstanced"), mode, first, count, instancecount);
  }

  public void glVertexAttribs4dvNV(int index, int count, MemorySegment v) {
    PFNGLVERTEXATTRIBS4DVNVPROC.invoke(load("glVertexAttribs4dvNV"), index, count, v);
  }

  public void glDrawTexxvOES(MemorySegment coords) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTextureParameterIivEXT(int texture, int target, int pname, MemorySegment params) {
    PFNGLTEXTUREPARAMETERIIVEXTPROC.invoke(load("glTextureParameterIivEXT"), texture, target, pname, params);
  }

  public void glDisableVertexAttribArrayARB(int index) {
    PFNGLDISABLEVERTEXATTRIBARRAYARBPROC.invoke(load("glDisableVertexAttribArrayARB"), index);
  }

  public void glProgramUniform2d(int program, int location, double v0, double v1) {
    PFNGLPROGRAMUNIFORM2DPROC.invoke(load("glProgramUniform2d"), program, location, v0, v1);
  }

  public void glProgramEnvParameterI4uiNV(int target, int index, int x, int y, int z, int w) {
    PFNGLPROGRAMENVPARAMETERI4UINVPROC.invoke(load("glProgramEnvParameterI4uiNV"), target, index, x, y, z, w);
  }

  public void glUniform4iARB(int location, int v0, int v1, int v2, int v3) {
    PFNGLUNIFORM4IARBPROC.invoke(load("glUniform4iARB"), location, v0, v1, v2, v3);
  }

  public void glProgramUniform3f(int program, int location, float v0, float v1, float v2) {
    PFNGLPROGRAMUNIFORM3FPROC.invoke(load("glProgramUniform3f"), program, location, v0, v1, v2);
  }

  public void glProgramUniform3i(int program, int location, int v0, int v1, int v2) {
    PFNGLPROGRAMUNIFORM3IPROC.invoke(load("glProgramUniform3i"), program, location, v0, v1, v2);
  }

  public void glGetNextPerfQueryIdINTEL(int queryId, MemorySegment nextQueryId) {
    PFNGLGETNEXTPERFQUERYIDINTELPROC.invoke(load("glGetNextPerfQueryIdINTEL"), queryId, nextQueryId);
  }

  public void glMapGrid2xOES(int n, int u1, int u2, int v1, int v2) {
    PFNGLMAPGRID2XOESPROC.invoke(load("glMapGrid2xOES"), n, u1, u2, v1, v2);
  }

  public void glProgramUniform3d(int program, int location, double v0, double v1, double v2) {
    PFNGLPROGRAMUNIFORM3DPROC.invoke(load("glProgramUniform3d"), program, location, v0, v1, v2);
  }

  public void glDepthRangedNV(double zNear, double zFar) {
    PFNGLDEPTHRANGEDNVPROC.invoke(load("glDepthRangedNV"), zNear, zFar);
  }

  public void glWindowPos3dvMESA(MemorySegment v) {
    PFNGLWINDOWPOS3DVMESAPROC.invoke(load("glWindowPos3dvMESA"), v);
  }

  public void glClearColorx(int red, int green, int blue, int alpha) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glCompileShader(int shader) {
    PFNGLCOMPILESHADERPROC.invoke(load("glCompileShader"), shader);
  }

  public void glMultiTexRenderbufferEXT(int texunit, int target, int renderbuffer) {
    PFNGLMULTITEXRENDERBUFFEREXTPROC.invoke(load("glMultiTexRenderbufferEXT"), texunit, target, renderbuffer);
  }

  public void glSamplerParameterIuivEXT(int sampler, int pname, MemorySegment param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glRenderbufferStorageMultisampleEXT(int target, int samples, int internalformat, int width, int height) {
    PFNGLRENDERBUFFERSTORAGEMULTISAMPLEEXTPROC.invoke(load("glRenderbufferStorageMultisampleEXT"), target, samples, internalformat, width, height);
  }

  public void glDisableVertexArrayAttribEXT(int vaobj, int index) {
    PFNGLDISABLEVERTEXARRAYATTRIBEXTPROC.invoke(load("glDisableVertexArrayAttribEXT"), vaobj, index);
  }

  public void glSecondaryColor3hNV(short red, short green, short blue) {
    PFNGLSECONDARYCOLOR3HNVPROC.invoke(load("glSecondaryColor3hNV"), red, green, blue);
  }

  public void glShaderOp3EXT(int op, int res, int arg1, int arg2, int arg3) {
    PFNGLSHADEROP3EXTPROC.invoke(load("glShaderOp3EXT"), op, res, arg1, arg2, arg3);
  }

  public byte glIsRenderbuffer(int renderbuffer) {
    return PFNGLISRENDERBUFFERPROC.invoke(load("glIsRenderbuffer"), renderbuffer);
  }

  public void glResolveMultisampleFramebufferAPPLE() {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMatrixMult3x3fNV(int matrixMode, MemorySegment m) {
    PFNGLMATRIXMULT3X3FNVPROC.invoke(load("glMatrixMult3x3fNV"), matrixMode, m);
  }

  public void glGetProgramResourceName(int program, int programInterface, int index, int bufSize, MemorySegment length, MemorySegment name) {
    PFNGLGETPROGRAMRESOURCENAMEPROC.invoke(load("glGetProgramResourceName"), program, programInterface, index, bufSize, length, name);
  }

  public void glMultiTexGendvEXT(int texunit, int coord, int pname, MemorySegment params) {
    PFNGLMULTITEXGENDVEXTPROC.invoke(load("glMultiTexGendvEXT"), texunit, coord, pname, params);
  }

  public void glNamedRenderbufferStorageMultisampleEXT(int renderbuffer, int samples, int internalformat, int width, int height) {
    PFNGLNAMEDRENDERBUFFERSTORAGEMULTISAMPLEEXTPROC.invoke(load("glNamedRenderbufferStorageMultisampleEXT"), renderbuffer, samples, internalformat, width, height);
  }

  public void glDeleteOcclusionQueriesNV(int n, MemorySegment ids) {
    PFNGLDELETEOCCLUSIONQUERIESNVPROC.invoke(load("glDeleteOcclusionQueriesNV"), n, ids);
  }

  public void glColorMaskIndexedEXT(int index, byte r, byte g, byte b, byte a) {
    PFNGLCOLORMASKINDEXEDEXTPROC.invoke(load("glColorMaskIndexedEXT"), index, r, g, b, a);
  }

  public void glCopyTextureImage1DEXT(int texture, int target, int level, int internalformat, int x, int y, int width, int border) {
    PFNGLCOPYTEXTUREIMAGE1DEXTPROC.invoke(load("glCopyTextureImage1DEXT"), texture, target, level, internalformat, x, y, width, border);
  }

  public void glUniformMatrix4dv(int location, int count, byte transpose, MemorySegment value) {
    PFNGLUNIFORMMATRIX4DVPROC.invoke(load("glUniformMatrix4dv"), location, count, transpose, value);
  }

  public void glColor3fVertex3fvSUN(MemorySegment c, MemorySegment v) {
    PFNGLCOLOR3FVERTEX3FVSUNPROC.invoke(load("glColor3fVertex3fvSUN"), c, v);
  }

  public void glGetCombinerOutputParameterivNV(int stage, int portion, int pname, MemorySegment params) {
    PFNGLGETCOMBINEROUTPUTPARAMETERIVNVPROC.invoke(load("glGetCombinerOutputParameterivNV"), stage, portion, pname, params);
  }

  public void glMatrixTranslatedEXT(int mode, double x, double y, double z) {
    PFNGLMATRIXTRANSLATEDEXTPROC.invoke(load("glMatrixTranslatedEXT"), mode, x, y, z);
  }

  public void glReplacementCodeuiColor4fNormal3fVertex3fSUN(int rc, float r, float g, float b, float a, float nx, float ny, float nz, float x, float y, float z) {
    PFNGLREPLACEMENTCODEUICOLOR4FNORMAL3FVERTEX3FSUNPROC.invoke(load("glReplacementCodeuiColor4fNormal3fVertex3fSUN"), rc, r, g, b, a, nx, ny, nz, x, y, z);
  }

  public void glPrioritizeTexturesxOES(int n, MemorySegment textures, MemorySegment priorities) {
    PFNGLPRIORITIZETEXTURESXOESPROC.invoke(load("glPrioritizeTexturesxOES"), n, textures, priorities);
  }

  public void glGetSemaphoreParameterui64vEXT(int semaphore, int pname, MemorySegment params) {
    PFNGLGETSEMAPHOREPARAMETERUI64VEXTPROC.invoke(load("glGetSemaphoreParameterui64vEXT"), semaphore, pname, params);
  }

  public void glVertexStream3ivATI(int stream, MemorySegment coords) {
    PFNGLVERTEXSTREAM3IVATIPROC.invoke(load("glVertexStream3ivATI"), stream, coords);
  }

  public void glUniformMatrix2x3fvNV(int location, int count, byte transpose, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glCreateBuffers(int n, MemorySegment buffers) {
    PFNGLCREATEBUFFERSPROC.invoke(load("glCreateBuffers"), n, buffers);
  }

  public void glMultiDrawMeshTasksIndirectNV(long indirect, int drawcount, int stride) {
    PFNGLMULTIDRAWMESHTASKSINDIRECTNVPROC.invoke(load("glMultiDrawMeshTasksIndirectNV"), indirect, drawcount, stride);
  }

  public void glTangent3iEXT(int tx, int ty, int tz) {
    PFNGLTANGENT3IEXTPROC.invoke(load("glTangent3iEXT"), tx, ty, tz);
  }

  public void glVertexAttribP4ui(int index, int type, byte normalized, int value) {
    PFNGLVERTEXATTRIBP4UIPROC.invoke(load("glVertexAttribP4ui"), index, type, normalized, value);
  }

  public void glClearDepthfOES(float depth) {
    PFNGLCLEARDEPTHFOESPROC.invoke(load("glClearDepthfOES"), depth);
  }

  public void glGetVideoi64vNV(int video_slot, int pname, MemorySegment params) {
    PFNGLGETVIDEOI64VNVPROC.invoke(load("glGetVideoi64vNV"), video_slot, pname, params);
  }

  public void glMultiTexCoordP2ui(int texture, int type, int coords) {
    PFNGLMULTITEXCOORDP2UIPROC.invoke(load("glMultiTexCoordP2ui"), texture, type, coords);
  }

  public void glProgramUniform3fvEXT(int program, int location, int count, MemorySegment value) {
    PFNGLPROGRAMUNIFORM3FVEXTPROC.invoke(load("glProgramUniform3fvEXT"), program, location, count, value);
  }

  public void glScissorIndexedvNV(int index, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTextureImage3DMultisampleNV(int texture, int target, int samples, int internalFormat, int width, int height, int depth, byte fixedSampleLocations) {
    PFNGLTEXTUREIMAGE3DMULTISAMPLENVPROC.invoke(load("glTextureImage3DMultisampleNV"), texture, target, samples, internalFormat, width, height, depth, fixedSampleLocations);
  }

  public void glWeightusvARB(int size, MemorySegment weights) {
    PFNGLWEIGHTUSVARBPROC.invoke(load("glWeightusvARB"), size, weights);
  }

  public void glGetDriverControlsQCOM(MemorySegment num, int size, MemorySegment driverControls) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetTexGenxvOES(int coord, int pname, MemorySegment params) {
    PFNGLGETTEXGENXVOESPROC.invoke(load("glGetTexGenxvOES"), coord, pname, params);
  }

  public void glMultiTexCoord2sv(int target, MemorySegment v) {
    PFNGLMULTITEXCOORD2SVARBPROC.invoke(load("glMultiTexCoord2sv"), target, v);
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
    PFNGLWINDOWPOS4DVMESAPROC.invoke(load("glWindowPos4dvMESA"), v);
  }

  public void glVertexAttrib4NusvARB(int index, MemorySegment v) {
    PFNGLVERTEXATTRIB4NUSVARBPROC.invoke(load("glVertexAttrib4NusvARB"), index, v);
  }

  public void glCopyMultiTexImage2DEXT(int texunit, int target, int level, int internalformat, int x, int y, int width, int height, int border) {
    PFNGLCOPYMULTITEXIMAGE2DEXTPROC.invoke(load("glCopyMultiTexImage2DEXT"), texunit, target, level, internalformat, x, y, width, height, border);
  }

  public void glVertexArrayRangeNV(int length, MemorySegment pointer) {
    PFNGLVERTEXARRAYRANGENVPROC.invoke(load("glVertexArrayRangeNV"), length, pointer);
  }

  public void glBlendEquationSeparateiARB(int buf, int modeRGB, int modeAlpha) {
    PFNGLBLENDEQUATIONSEPARATEIARBPROC.invoke(load("glBlendEquationSeparateiARB"), buf, modeRGB, modeAlpha);
  }

  public void glUseProgram(int program) {
    PFNGLUSEPROGRAMPROC.invoke(load("glUseProgram"), program);
  }

  public void glGetProgramInterfaceiv(int program, int programInterface, int pname, MemorySegment params) {
    PFNGLGETPROGRAMINTERFACEIVPROC.invoke(load("glGetProgramInterfaceiv"), program, programInterface, pname, params);
  }

  public void glVariantArrayObjectATI(int id, int type, int stride, int buffer, int offset) {
    PFNGLVARIANTARRAYOBJECTATIPROC.invoke(load("glVariantArrayObjectATI"), id, type, stride, buffer, offset);
  }

  public void glEndOcclusionQueryNV() {
    PFNGLENDOCCLUSIONQUERYNVPROC.invoke(load("glEndOcclusionQueryNV"));
  }

  public void glUniformMatrix4fv(int location, int count, byte transpose, MemorySegment value) {
    PFNGLUNIFORMMATRIX4FVPROC.invoke(load("glUniformMatrix4fv"), location, count, transpose, value);
  }

  public void glBeginConditionalRenderNVX(int id) {
    PFNGLBEGINCONDITIONALRENDERNVXPROC.invoke(load("glBeginConditionalRenderNVX"), id);
  }

  public void glMultiTexCoord2xvOES(int texture, MemorySegment coords) {
    PFNGLMULTITEXCOORD2XVOESPROC.invoke(load("glMultiTexCoord2xvOES"), texture, coords);
  }

  public void glGetPixelTexGenParameterivSGIS(int pname, MemorySegment params) {
    PFNGLGETPIXELTEXGENPARAMETERIVSGISPROC.invoke(load("glGetPixelTexGenParameterivSGIS"), pname, params);
  }

  public void glSemaphoreParameterui64vEXT(int semaphore, int pname, MemorySegment params) {
    PFNGLSEMAPHOREPARAMETERUI64VEXTPROC.invoke(load("glSemaphoreParameterui64vEXT"), semaphore, pname, params);
  }

  public void glImportMemoryWin32NameEXT(int memory, long size, int handleType, MemorySegment name) {
    PFNGLIMPORTMEMORYWIN32NAMEEXTPROC.invoke(load("glImportMemoryWin32NameEXT"), memory, size, handleType, name);
  }

  public void glVertexAttribI4ivEXT(int index, MemorySegment v) {
    PFNGLVERTEXATTRIBI4IVEXTPROC.invoke(load("glVertexAttribI4ivEXT"), index, v);
  }

  public void glDebugMessageCallbackARB(MemorySegment callback, MemorySegment userParam) {
    PFNGLDEBUGMESSAGECALLBACKARBPROC.invoke(load("glDebugMessageCallbackARB"), callback, userParam);
  }

  public int glGenSymbolsEXT(int datatype, int storagetype, int range, int components) {
    return PFNGLGENSYMBOLSEXTPROC.invoke(load("glGenSymbolsEXT"), datatype, storagetype, range, components);
  }

  public void glVertexAttrib3dNV(int index, double x, double y, double z) {
    PFNGLVERTEXATTRIB3DNVPROC.invoke(load("glVertexAttrib3dNV"), index, x, y, z);
  }

  public void glTexCoordP4uiv(int type, MemorySegment coords) {
    PFNGLTEXCOORDP4UIVPROC.invoke(load("glTexCoordP4uiv"), type, coords);
  }

  public void glEvalCoord1xvOES(MemorySegment coords) {
    PFNGLEVALCOORD1XVOESPROC.invoke(load("glEvalCoord1xvOES"), coords);
  }

  public void glWindowPos3dARB(double x, double y, double z) {
    PFNGLWINDOWPOS3DARBPROC.invoke(load("glWindowPos3dARB"), x, y, z);
  }

  public void glCopyTextureLevelsAPPLE(int destinationTexture, int sourceTexture, int sourceBaseLevel, int sourceLevelCount) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glPathDashArrayNV(int path, int dashCount, MemorySegment dashArray) {
    PFNGLPATHDASHARRAYNVPROC.invoke(load("glPathDashArrayNV"), path, dashCount, dashArray);
  }

  public void glGetFragmentMaterialfvSGIX(int face, int pname, MemorySegment params) {
    PFNGLGETFRAGMENTMATERIALFVSGIXPROC.invoke(load("glGetFragmentMaterialfvSGIX"), face, pname, params);
  }

  public void glGetTexBumpParameterfvATI(int pname, MemorySegment param) {
    PFNGLGETTEXBUMPPARAMETERFVATIPROC.invoke(load("glGetTexBumpParameterfvATI"), pname, param);
  }

  public void glSampleCoverage(float value, byte invert) {
    PFNGLSAMPLECOVERAGEPROC.invoke(load("glSampleCoverage"), value, invert);
  }

  public void glVertexAttribI3uivEXT(int index, MemorySegment v) {
    PFNGLVERTEXATTRIBI3UIVEXTPROC.invoke(load("glVertexAttribI3uivEXT"), index, v);
  }

  public void glGetTexParameterxvOES(int target, int pname, MemorySegment params) {
    PFNGLGETTEXPARAMETERXVOESPROC.invoke(load("glGetTexParameterxvOES"), target, pname, params);
  }

  public void glGetBooleanIndexedvEXT(int target, int index, MemorySegment data) {
    PFNGLGETBOOLEANINDEXEDVEXTPROC.invoke(load("glGetBooleanIndexedvEXT"), target, index, data);
  }

  public void glMultiTexCoord3fvARB(int target, MemorySegment v) {
    PFNGLMULTITEXCOORD3FVARBPROC.invoke(load("glMultiTexCoord3fvARB"), target, v);
  }

  public void glVertexStream2iATI(int stream, int x, int y) {
    PFNGLVERTEXSTREAM2IATIPROC.invoke(load("glVertexStream2iATI"), stream, x, y);
  }

  public void glGenPerfMonitorsAMD(int n, MemorySegment monitors) {
    PFNGLGENPERFMONITORSAMDPROC.invoke(load("glGenPerfMonitorsAMD"), n, monitors);
  }

  public void glMultiTexCoord4xOES(int texture, int s, int t, int r, int q) {
    PFNGLMULTITEXCOORD4XOESPROC.invoke(load("glMultiTexCoord4xOES"), texture, s, t, r, q);
  }

  public void glNamedFramebufferParameteriEXT(int framebuffer, int pname, int param) {
    PFNGLNAMEDFRAMEBUFFERPARAMETERIEXTPROC.invoke(load("glNamedFramebufferParameteriEXT"), framebuffer, pname, param);
  }

  public void glReplacementCodeuiColor4fNormal3fVertex3fvSUN(MemorySegment rc, MemorySegment c, MemorySegment n, MemorySegment v) {
    PFNGLREPLACEMENTCODEUICOLOR4FNORMAL3FVERTEX3FVSUNPROC.invoke(load("glReplacementCodeuiColor4fNormal3fVertex3fvSUN"), rc, c, n, v);
  }

  public void glScissorIndexed(int index, int left, int bottom, int width, int height) {
    PFNGLSCISSORINDEXEDPROC.invoke(load("glScissorIndexed"), index, left, bottom, width, height);
  }

  public void glMatrixLoadIdentityEXT(int mode) {
    PFNGLMATRIXLOADIDENTITYEXTPROC.invoke(load("glMatrixLoadIdentityEXT"), mode);
  }

  public void glReplacementCodeuiTexCoord2fNormal3fVertex3fSUN(int rc, float s, float t, float nx, float ny, float nz, float x, float y, float z) {
    PFNGLREPLACEMENTCODEUITEXCOORD2FNORMAL3FVERTEX3FSUNPROC.invoke(load("glReplacementCodeuiTexCoord2fNormal3fVertex3fSUN"), rc, s, t, nx, ny, nz, x, y, z);
  }

  public void glSamplerParameteri(int sampler, int pname, int param) {
    PFNGLSAMPLERPARAMETERIPROC.invoke(load("glSamplerParameteri"), sampler, pname, param);
  }

  public void glDeleteProgramPipelinesEXT(int n, MemorySegment pipelines) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glSamplerParameterf(int sampler, int pname, float param) {
    PFNGLSAMPLERPARAMETERFPROC.invoke(load("glSamplerParameterf"), sampler, pname, param);
  }

  public void glSecondaryColor3uivEXT(MemorySegment v) {
    PFNGLSECONDARYCOLOR3UIVEXTPROC.invoke(load("glSecondaryColor3uivEXT"), v);
  }

  public void glSampleCoverageARB(float value, byte invert) {
    PFNGLSAMPLECOVERAGEARBPROC.invoke(load("glSampleCoverageARB"), value, invert);
  }

  public void glWeightPointerARB(int size, int type, int stride, MemorySegment pointer) {
    PFNGLWEIGHTPOINTERARBPROC.invoke(load("glWeightPointerARB"), size, type, stride, pointer);
  }

  public void glProgramUniform2i64NV(int program, int location, long x, long y) {
    PFNGLPROGRAMUNIFORM2I64NVPROC.invoke(load("glProgramUniform2i64NV"), program, location, x, y);
  }

  public void glDrawTransformFeedbackStream(int mode, int id, int stream) {
    PFNGLDRAWTRANSFORMFEEDBACKSTREAMPROC.invoke(load("glDrawTransformFeedbackStream"), mode, id, stream);
  }

  public void glTextureRangeAPPLE(int target, int length, MemorySegment pointer) {
    PFNGLTEXTURERANGEAPPLEPROC.invoke(load("glTextureRangeAPPLE"), target, length, pointer);
  }

  public void glBinormal3ivEXT(MemorySegment v) {
    PFNGLBINORMAL3IVEXTPROC.invoke(load("glBinormal3ivEXT"), v);
  }

  public void glPolygonOffsetClampEXT(float factor, float units, float clamp) {
    PFNGLPOLYGONOFFSETCLAMPEXTPROC.invoke(load("glPolygonOffsetClampEXT"), factor, units, clamp);
  }

  public void glNormalStream3fvATI(int stream, MemorySegment coords) {
    PFNGLNORMALSTREAM3FVATIPROC.invoke(load("glNormalStream3fvATI"), stream, coords);
  }

  public void glEndQueryIndexed(int target, int index) {
    PFNGLENDQUERYINDEXEDPROC.invoke(load("glEndQueryIndexed"), target, index);
  }

  public void glPrimitiveBoundingBoxEXT(float minX, float minY, float minZ, float minW, float maxX, float maxY, float maxZ, float maxW) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexCoord4bOES(int texture, byte s, byte t, byte r, byte q) {
    PFNGLMULTITEXCOORD4BOESPROC.invoke(load("glMultiTexCoord4bOES"), texture, s, t, r, q);
  }

  public void glStopInstrumentsSGIX(int marker) {
    PFNGLSTOPINSTRUMENTSSGIXPROC.invoke(load("glStopInstrumentsSGIX"), marker);
  }

  public void glMakeTextureHandleResidentARB(long handle) {
    PFNGLMAKETEXTUREHANDLERESIDENTARBPROC.invoke(load("glMakeTextureHandleResidentARB"), handle);
  }

  public void glVertexStream2fvATI(int stream, MemorySegment coords) {
    PFNGLVERTEXSTREAM2FVATIPROC.invoke(load("glVertexStream2fvATI"), stream, coords);
  }

  public void glProgramLocalParameterI4uivNV(int target, int index, MemorySegment params) {
    PFNGLPROGRAMLOCALPARAMETERI4UIVNVPROC.invoke(load("glProgramLocalParameterI4uivNV"), target, index, params);
  }

  public void glBufferSubDataARB(int target, long offset, long size, MemorySegment data) {
    PFNGLBUFFERSUBDATAARBPROC.invoke(load("glBufferSubDataARB"), target, offset, size, data);
  }

  public void glProgramUniformui64vNV(int program, int location, int count, MemorySegment value) {
    PFNGLPROGRAMUNIFORMUI64VNVPROC.invoke(load("glProgramUniformui64vNV"), program, location, count, value);
  }

  public void glProgramUniformMatrix2x4dv(int program, int location, int count, byte transpose, MemorySegment value) {
    PFNGLPROGRAMUNIFORMMATRIX2X4DVPROC.invoke(load("glProgramUniformMatrix2x4dv"), program, location, count, transpose, value);
  }

  public void glTexCoord2xOES(int s, int t) {
    PFNGLTEXCOORD2XOESPROC.invoke(load("glTexCoord2xOES"), s, t);
  }

  public void glVertexAttribL1dv(int index, MemorySegment v) {
    PFNGLVERTEXATTRIBL1DVPROC.invoke(load("glVertexAttribL1dv"), index, v);
  }

  public void glGenOcclusionQueriesNV(int n, MemorySegment ids) {
    PFNGLGENOCCLUSIONQUERIESNVPROC.invoke(load("glGenOcclusionQueriesNV"), n, ids);
  }

  public void glBlitFramebufferNV(int srcX0, int srcY0, int srcX1, int srcY1, int dstX0, int dstY0, int dstX1, int dstY1, int mask, int filter) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFlushMappedBufferRangeAPPLE(int target, long offset, long size) {
    PFNGLFLUSHMAPPEDBUFFERRANGEAPPLEPROC.invoke(load("glFlushMappedBufferRangeAPPLE"), target, offset, size);
  }

  public void glGetObjectLabelKHR(int identifier, int name, int bufSize, MemorySegment length, MemorySegment label) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribL2d(int index, double x, double y) {
    PFNGLVERTEXATTRIBL2DPROC.invoke(load("glVertexAttribL2d"), index, x, y);
  }

  public void glWindowPos3fvARB(MemorySegment v) {
    PFNGLWINDOWPOS3FVARBPROC.invoke(load("glWindowPos3fvARB"), v);
  }

  public void glPushClientAttribDefaultEXT(int mask) {
    PFNGLPUSHCLIENTATTRIBDEFAULTEXTPROC.invoke(load("glPushClientAttribDefaultEXT"), mask);
  }

  public void glMultiTexCoord2hvNV(int target, MemorySegment v) {
    PFNGLMULTITEXCOORD2HVNVPROC.invoke(load("glMultiTexCoord2hvNV"), target, v);
  }

  public void glVariantbvEXT(int id, MemorySegment addr) {
    PFNGLVARIANTBVEXTPROC.invoke(load("glVariantbvEXT"), id, addr);
  }

  public void glProgramUniform2i64vARB(int program, int location, int count, MemorySegment value) {
    PFNGLPROGRAMUNIFORM2I64VARBPROC.invoke(load("glProgramUniform2i64vARB"), program, location, count, value);
  }

  public void glDepthRangefOES(float n, float f) {
    PFNGLDEPTHRANGEFOESPROC.invoke(load("glDepthRangefOES"), n, f);
  }

  public long glVDPAURegisterVideoSurfaceNV(MemorySegment vdpSurface, int target, int numTextureNames, MemorySegment textureNames) {
    return PFNGLVDPAUREGISTERVIDEOSURFACENVPROC.invoke(load("glVDPAURegisterVideoSurfaceNV"), vdpSurface, target, numTextureNames, textureNames);
  }

  public void glGetVertexAttribdvARB(int index, int pname, MemorySegment params) {
    PFNGLGETVERTEXATTRIBDVARBPROC.invoke(load("glGetVertexAttribdvARB"), index, pname, params);
  }

  public void glVertexAttribL3d(int index, double x, double y, double z) {
    PFNGLVERTEXATTRIBL3DPROC.invoke(load("glVertexAttribL3d"), index, x, y, z);
  }

  public void glUniformMatrix3x2dv(int location, int count, byte transpose, MemorySegment value) {
    PFNGLUNIFORMMATRIX3X2DVPROC.invoke(load("glUniformMatrix3x2dv"), location, count, transpose, value);
  }

  public void glGetnMapivARB(int target, int query, int bufSize, MemorySegment v) {
    PFNGLGETNMAPIVARBPROC.invoke(load("glGetnMapivARB"), target, query, bufSize, v);
  }

  public void glBindBuffer(int target, int buffer) {
    PFNGLBINDBUFFERPROC.invoke(load("glBindBuffer"), target, buffer);
  }

  public void glTexCoordP3ui(int type, int coords) {
    PFNGLTEXCOORDP3UIPROC.invoke(load("glTexCoordP3ui"), type, coords);
  }

  public void glUniform1i64vNV(int location, int count, MemorySegment value) {
    PFNGLUNIFORM1I64VNVPROC.invoke(load("glUniform1i64vNV"), location, count, value);
  }

  public void glColor3fVertex3fSUN(float r, float g, float b, float x, float y, float z) {
    PFNGLCOLOR3FVERTEX3FSUNPROC.invoke(load("glColor3fVertex3fSUN"), r, g, b, x, y, z);
  }

  public void glPrioritizeTexturesEXT(int n, MemorySegment textures, MemorySegment priorities) {
    PFNGLPRIORITIZETEXTURESEXTPROC.invoke(load("glPrioritizeTexturesEXT"), n, textures, priorities);
  }

  public void glVertexAttrib1sARB(int index, short x) {
    PFNGLVERTEXATTRIB1SARBPROC.invoke(load("glVertexAttrib1sARB"), index, x);
  }

  public void glProgramUniformHandleui64vIMG(int program, int location, int count, MemorySegment values) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultTransposeMatrixdARB(MemorySegment m) {
    PFNGLMULTTRANSPOSEMATRIXDARBPROC.invoke(load("glMultTransposeMatrixdARB"), m);
  }

  public void glVertexAttribIPointerEXT(int index, int size, int type, int stride, MemorySegment pointer) {
    PFNGLVERTEXATTRIBIPOINTEREXTPROC.invoke(load("glVertexAttribIPointerEXT"), index, size, type, stride, pointer);
  }

  public void glVertexArrayParameteriAPPLE(int pname, int param) {
    PFNGLVERTEXARRAYPARAMETERIAPPLEPROC.invoke(load("glVertexArrayParameteriAPPLE"), pname, param);
  }

  public void glProgramUniformMatrix3fv(int program, int location, int count, byte transpose, MemorySegment value) {
    PFNGLPROGRAMUNIFORMMATRIX3FVPROC.invoke(load("glProgramUniformMatrix3fv"), program, location, count, transpose, value);
  }

  public void glTexCoord2bOES(byte s, byte t) {
    PFNGLTEXCOORD2BOESPROC.invoke(load("glTexCoord2bOES"), s, t);
  }

  public void glProgramUniform1ivEXT(int program, int location, int count, MemorySegment value) {
    PFNGLPROGRAMUNIFORM1IVEXTPROC.invoke(load("glProgramUniform1ivEXT"), program, location, count, value);
  }

  public void glVertexAttribs2svNV(int index, int count, MemorySegment v) {
    PFNGLVERTEXATTRIBS2SVNVPROC.invoke(load("glVertexAttribs2svNV"), index, count, v);
  }

  public void glShaderSourceARB(int shaderObj, int count, MemorySegment string, MemorySegment length) {
    opengl.windows.PFNGLSHADERSOURCEARBPROC.invoke(load("glShaderSourceARB"), shaderObj, count, string, length);
  }

  public void glCompressedTexSubImage2DARB(int target, int level, int xoffset, int yoffset, int width, int height, int format, int imageSize, MemorySegment data) {
    PFNGLCOMPRESSEDTEXSUBIMAGE2DARBPROC.invoke(load("glCompressedTexSubImage2DARB"), target, level, xoffset, yoffset, width, height, format, imageSize, data);
  }

  public void glGetNamedBufferParameteri64v(int buffer, int pname, MemorySegment params) {
    PFNGLGETNAMEDBUFFERPARAMETERI64VPROC.invoke(load("glGetNamedBufferParameteri64v"), buffer, pname, params);
  }

  public void glGetActiveUniformARB(int programObj, int index, int maxLength, MemorySegment length, MemorySegment size, MemorySegment type, MemorySegment name) {
    opengl.windows.PFNGLGETACTIVEUNIFORMARBPROC.invoke(load("glGetActiveUniformARB"), programObj, index, maxLength, length, size, type, name);
  }

  public void glVertexAttribL1d(int index, double x) {
    PFNGLVERTEXATTRIBL1DPROC.invoke(load("glVertexAttribL1d"), index, x);
  }

  public void glApplyTextureEXT(int mode) {
    PFNGLAPPLYTEXTUREEXTPROC.invoke(load("glApplyTextureEXT"), mode);
  }

  public void glDebugMessageCallbackAMD(MemorySegment callback, MemorySegment userParam) {
    PFNGLDEBUGMESSAGECALLBACKAMDPROC.invoke(load("glDebugMessageCallbackAMD"), callback, userParam);
  }

  public void glMulticastGetQueryObjecti64vNV(int gpu, int id, int pname, MemorySegment params) {
    PFNGLMULTICASTGETQUERYOBJECTI64VNVPROC.invoke(load("glMulticastGetQueryObjecti64vNV"), gpu, id, pname, params);
  }

  public void glTexParameterIuivEXT(int target, int pname, MemorySegment params) {
    PFNGLTEXPARAMETERIUIVEXTPROC.invoke(load("glTexParameterIuivEXT"), target, pname, params);
  }

  public void glDeleteTransformFeedbacksNV(int n, MemorySegment ids) {
    PFNGLDELETETRANSFORMFEEDBACKSNVPROC.invoke(load("glDeleteTransformFeedbacksNV"), n, ids);
  }

  public void glResetMemoryObjectParameterNV(int memory, int pname) {
    PFNGLRESETMEMORYOBJECTPARAMETERNVPROC.invoke(load("glResetMemoryObjectParameterNV"), memory, pname);
  }

  public void glTexturePageCommitmentEXT(int texture, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, byte commit) {
    PFNGLTEXTUREPAGECOMMITMENTEXTPROC.invoke(load("glTexturePageCommitmentEXT"), texture, level, xoffset, yoffset, zoffset, width, height, depth, commit);
  }

  public void glDrawArraysInstancedBaseInstanceEXT(int mode, int first, int count, int instancecount, int baseinstance) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public byte glIsProgramNV(int id) {
    return PFNGLISPROGRAMNVPROC.invoke(load("glIsProgramNV"), id);
  }

  public void glTextureBufferRange(int texture, int internalformat, int buffer, long offset, long size) {
    PFNGLTEXTUREBUFFERRANGEPROC.invoke(load("glTextureBufferRange"), texture, internalformat, buffer, offset, size);
  }

  public void glBeginQueryEXT(int target, int id) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetQueryObjectivEXT(int id, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glPixelTexGenParameterivSGIS(int pname, MemorySegment params) {
    PFNGLPIXELTEXGENPARAMETERIVSGISPROC.invoke(load("glPixelTexGenParameterivSGIS"), pname, params);
  }

  public void glGetVertexAttribLui64vARB(int index, int pname, MemorySegment params) {
    PFNGLGETVERTEXATTRIBLUI64VARBPROC.invoke(load("glGetVertexAttribLui64vARB"), index, pname, params);
  }

  public void glGetnUniformdvARB(int program, int location, int bufSize, MemorySegment params) {
    PFNGLGETNUNIFORMDVARBPROC.invoke(load("glGetnUniformdvARB"), program, location, bufSize, params);
  }

  public void glProgramUniformMatrix3dv(int program, int location, int count, byte transpose, MemorySegment value) {
    PFNGLPROGRAMUNIFORMMATRIX3DVPROC.invoke(load("glProgramUniformMatrix3dv"), program, location, count, transpose, value);
  }

  public void glGetLightxv(int light, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetVertexAttribIuivEXT(int index, int pname, MemorySegment params) {
    PFNGLGETVERTEXATTRIBIUIVEXTPROC.invoke(load("glGetVertexAttribIuivEXT"), index, pname, params);
  }

  public void glTexCoord2hNV(short s, short t) {
    PFNGLTEXCOORD2HNVPROC.invoke(load("glTexCoord2hNV"), s, t);
  }

  public void glBlendFuncSeparateiARB(int buf, int srcRGB, int dstRGB, int srcAlpha, int dstAlpha) {
    PFNGLBLENDFUNCSEPARATEIARBPROC.invoke(load("glBlendFuncSeparateiARB"), buf, srcRGB, dstRGB, srcAlpha, dstAlpha);
  }

  public void glNamedProgramLocalParametersI4ivEXT(int program, int target, int index, int count, MemorySegment params) {
    PFNGLNAMEDPROGRAMLOCALPARAMETERSI4IVEXTPROC.invoke(load("glNamedProgramLocalParametersI4ivEXT"), program, target, index, count, params);
  }

  public void glGenRenderbuffersEXT(int n, MemorySegment renderbuffers) {
    PFNGLGENRENDERBUFFERSEXTPROC.invoke(load("glGenRenderbuffersEXT"), n, renderbuffers);
  }

  public void glTextureSubImage1DEXT(int texture, int target, int level, int xoffset, int width, int format, int type, MemorySegment pixels) {
    PFNGLTEXTURESUBIMAGE1DEXTPROC.invoke(load("glTextureSubImage1DEXT"), texture, target, level, xoffset, width, format, type, pixels);
  }

  public void glCompressedTextureSubImage3DEXT(int texture, int target, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int format, int imageSize, MemorySegment bits) {
    PFNGLCOMPRESSEDTEXTURESUBIMAGE3DEXTPROC.invoke(load("glCompressedTextureSubImage3DEXT"), texture, target, level, xoffset, yoffset, zoffset, width, height, depth, format, imageSize, bits);
  }

  public void glVertexAttribs2hvNV(int index, int n, MemorySegment v) {
    PFNGLVERTEXATTRIBS2HVNVPROC.invoke(load("glVertexAttribs2hvNV"), index, n, v);
  }

  public void glTextureFoveationParametersQCOM(int texture, int layer, int focalPoint, float focalX, float focalY, float gainX, float gainY, float foveaArea) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDrawElementsInstancedBaseInstance(int mode, int count, int type, MemorySegment indices, int instancecount, int baseinstance) {
    PFNGLDRAWELEMENTSINSTANCEDBASEINSTANCEPROC.invoke(load("glDrawElementsInstancedBaseInstance"), mode, count, type, indices, instancecount, baseinstance);
  }

  public void glProgramUniform2ui64ARB(int program, int location, long x, long y) {
    PFNGLPROGRAMUNIFORM2UI64ARBPROC.invoke(load("glProgramUniform2ui64ARB"), program, location, x, y);
  }

  public void glMatrixPopEXT(int mode) {
    PFNGLMATRIXPOPEXTPROC.invoke(load("glMatrixPopEXT"), mode);
  }

  public void glGetNamedStringARB(int namelen, MemorySegment name, int bufSize, MemorySegment stringlen, MemorySegment string) {
    PFNGLGETNAMEDSTRINGARBPROC.invoke(load("glGetNamedStringARB"), namelen, name, bufSize, stringlen, string);
  }

  public void glDeleteFramebuffersEXT(int n, MemorySegment framebuffers) {
    PFNGLDELETEFRAMEBUFFERSEXTPROC.invoke(load("glDeleteFramebuffersEXT"), n, framebuffers);
  }

  public void glDispatchCompute(int num_groups_x, int num_groups_y, int num_groups_z) {
    PFNGLDISPATCHCOMPUTEPROC.invoke(load("glDispatchCompute"), num_groups_x, num_groups_y, num_groups_z);
  }

  public void glProgramUniformMatrix2x4fv(int program, int location, int count, byte transpose, MemorySegment value) {
    PFNGLPROGRAMUNIFORMMATRIX2X4FVPROC.invoke(load("glProgramUniformMatrix2x4fv"), program, location, count, transpose, value);
  }

  public void glUpdateObjectBufferATI(int buffer, int offset, int size, MemorySegment pointer, int preserve) {
    PFNGLUPDATEOBJECTBUFFERATIPROC.invoke(load("glUpdateObjectBufferATI"), buffer, offset, size, pointer, preserve);
  }

  public void glTextureBufferEXT(int texture, int target, int internalformat, int buffer) {
    PFNGLTEXTUREBUFFEREXTPROC.invoke(load("glTextureBufferEXT"), texture, target, internalformat, buffer);
  }

  public void glWeightbvARB(int size, MemorySegment weights) {
    PFNGLWEIGHTBVARBPROC.invoke(load("glWeightbvARB"), size, weights);
  }

  public void glDrawElementsInstancedARB(int mode, int count, int type, MemorySegment indices, int primcount) {
    PFNGLDRAWELEMENTSINSTANCEDARBPROC.invoke(load("glDrawElementsInstancedARB"), mode, count, type, indices, primcount);
  }

  public void glMulticastBlitFramebufferNV(int srcGpu, int dstGpu, int srcX0, int srcY0, int srcX1, int srcY1, int dstX0, int dstY0, int dstX1, int dstY1, int mask, int filter) {
    PFNGLMULTICASTBLITFRAMEBUFFERNVPROC.invoke(load("glMulticastBlitFramebufferNV"), srcGpu, dstGpu, srcX0, srcY0, srcX1, srcY1, dstX0, dstY0, dstX1, dstY1, mask, filter);
  }

  public void glClearNamedBufferSubData(int buffer, int internalformat, long offset, long size, int format, int type, MemorySegment data) {
    PFNGLCLEARNAMEDBUFFERSUBDATAPROC.invoke(load("glClearNamedBufferSubData"), buffer, internalformat, offset, size, format, type, data);
  }

  public void glVertexAttribs1fvNV(int index, int count, MemorySegment v) {
    PFNGLVERTEXATTRIBS1FVNVPROC.invoke(load("glVertexAttribs1fvNV"), index, count, v);
  }

  public void glMinmaxEXT(int target, int internalformat, byte sink) {
    PFNGLMINMAXEXTPROC.invoke(load("glMinmaxEXT"), target, internalformat, sink);
  }

  public void glProgramUniform4i64ARB(int program, int location, long x, long y, long z, long w) {
    PFNGLPROGRAMUNIFORM4I64ARBPROC.invoke(load("glProgramUniform4i64ARB"), program, location, x, y, z, w);
  }

  public void glNormalStream3bATI(int stream, byte nx, byte ny, byte nz) {
    PFNGLNORMALSTREAM3BATIPROC.invoke(load("glNormalStream3bATI"), stream, nx, ny, nz);
  }

  public void glTessellationModeAMD(int mode) {
    PFNGLTESSELLATIONMODEAMDPROC.invoke(load("glTessellationModeAMD"), mode);
  }

  public void glGetTexParameterIuiv(int target, int pname, MemorySegment params) {
    PFNGLGETTEXPARAMETERIUIVPROC.invoke(load("glGetTexParameterIuiv"), target, pname, params);
  }

  public void glOrthof(float l, float r, float b, float t, float n, float f) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribBinding(int attribindex, int bindingindex) {
    PFNGLVERTEXATTRIBBINDINGPROC.invoke(load("glVertexAttribBinding"), attribindex, bindingindex);
  }

  public void glSamplerParameterfv(int sampler, int pname, MemorySegment param) {
    PFNGLSAMPLERPARAMETERFVPROC.invoke(load("glSamplerParameterfv"), sampler, pname, param);
  }

  public void glTexCoordP1uiv(int type, MemorySegment coords) {
    PFNGLTEXCOORDP1UIVPROC.invoke(load("glTexCoordP1uiv"), type, coords);
  }

  public void glGenProgramPipelines(int n, MemorySegment pipelines) {
    PFNGLGENPROGRAMPIPELINESPROC.invoke(load("glGenProgramPipelines"), n, pipelines);
  }

  public void glMulticastViewportPositionWScaleNVX(int gpu, int index, float xcoeff, float ycoeff) {
    PFNGLMULTICASTVIEWPORTPOSITIONWSCALENVXPROC.invoke(load("glMulticastViewportPositionWScaleNVX"), gpu, index, xcoeff, ycoeff);
  }

  public void glOrthox(int l, int r, int b, int t, int n, int f) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glNamedBufferStorageEXT(int buffer, long size, MemorySegment data, int flags) {
    PFNGLNAMEDBUFFERSTORAGEEXTPROC.invoke(load("glNamedBufferStorageEXT"), buffer, size, data, flags);
  }

  public void glVertexAttribP1uiv(int index, int type, byte normalized, MemorySegment value) {
    PFNGLVERTEXATTRIBP1UIVPROC.invoke(load("glVertexAttribP1uiv"), index, type, normalized, value);
  }

  public void glTexParameterIiv(int target, int pname, MemorySegment params) {
    PFNGLTEXPARAMETERIIVPROC.invoke(load("glTexParameterIiv"), target, pname, params);
  }

  public void glMatrixLoadTransposedEXT(int mode, MemorySegment m) {
    PFNGLMATRIXLOADTRANSPOSEDEXTPROC.invoke(load("glMatrixLoadTransposedEXT"), mode, m);
  }

  public void glGetVertexAttribLdvEXT(int index, int pname, MemorySegment params) {
    PFNGLGETVERTEXATTRIBLDVEXTPROC.invoke(load("glGetVertexAttribLdvEXT"), index, pname, params);
  }

  public void glUniformBufferEXT(int program, int location, int buffer) {
    PFNGLUNIFORMBUFFEREXTPROC.invoke(load("glUniformBufferEXT"), program, location, buffer);
  }

  public void glGetFirstPerfQueryIdINTEL(MemorySegment queryId) {
    PFNGLGETFIRSTPERFQUERYIDINTELPROC.invoke(load("glGetFirstPerfQueryIdINTEL"), queryId);
  }

  public void glSamplerParameteriv(int sampler, int pname, MemorySegment param) {
    PFNGLSAMPLERPARAMETERIVPROC.invoke(load("glSamplerParameteriv"), sampler, pname, param);
  }

  public void glTexEnvxv(int target, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glEndConditionalRenderNVX() {
    PFNGLENDCONDITIONALRENDERNVXPROC.invoke(load("glEndConditionalRenderNVX"));
  }

  public void glShadingRateSampleOrderCustomNV(int rate, int samples, MemorySegment locations) {
    PFNGLSHADINGRATESAMPLEORDERCUSTOMNVPROC.invoke(load("glShadingRateSampleOrderCustomNV"), rate, samples, locations);
  }

  public void glGetAttachedShaders(int program, int maxCount, MemorySegment count, MemorySegment shaders) {
    PFNGLGETATTACHEDSHADERSPROC.invoke(load("glGetAttachedShaders"), program, maxCount, count, shaders);
  }

  public void glGetVariantArrayObjectivATI(int id, int pname, MemorySegment params) {
    PFNGLGETVARIANTARRAYOBJECTIVATIPROC.invoke(load("glGetVariantArrayObjectivATI"), id, pname, params);
  }

  public void glVertexAttrib2fvARB(int index, MemorySegment v) {
    PFNGLVERTEXATTRIB2FVARBPROC.invoke(load("glVertexAttrib2fvARB"), index, v);
  }

  public void glSemaphoreParameterivNV(int semaphore, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFramebufferTextureLayerDownsampleIMG(int target, int attachment, int texture, int level, int layer, int xscale, int yscale) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetConvolutionParameterivEXT(int target, int pname, MemorySegment params) {
    PFNGLGETCONVOLUTIONPARAMETERIVEXTPROC.invoke(load("glGetConvolutionParameterivEXT"), target, pname, params);
  }

  public void glGetActiveUniformsiv(int program, int uniformCount, MemorySegment uniformIndices, int pname, MemorySegment params) {
    PFNGLGETACTIVEUNIFORMSIVPROC.invoke(load("glGetActiveUniformsiv"), program, uniformCount, uniformIndices, pname, params);
  }

  public void glNamedFramebufferTexture(int framebuffer, int attachment, int texture, int level) {
    PFNGLNAMEDFRAMEBUFFERTEXTUREPROC.invoke(load("glNamedFramebufferTexture"), framebuffer, attachment, texture, level);
  }

  public void glUniformMatrix3fvARB(int location, int count, byte transpose, MemorySegment value) {
    PFNGLUNIFORMMATRIX3FVARBPROC.invoke(load("glUniformMatrix3fvARB"), location, count, transpose, value);
  }

  public void glTransformPathNV(int resultPath, int srcPath, int transformType, MemorySegment transformValues) {
    PFNGLTRANSFORMPATHNVPROC.invoke(load("glTransformPathNV"), resultPath, srcPath, transformType, transformValues);
  }

  public void glUniform1fARB(int location, float v0) {
    PFNGLUNIFORM1FARBPROC.invoke(load("glUniform1fARB"), location, v0);
  }

  public void glDisableDriverControlQCOM(int driverControl) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glExtGetProgramsQCOM(MemorySegment programs, int maxPrograms, MemorySegment numPrograms) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniform4i64vARB(int location, int count, MemorySegment value) {
    PFNGLUNIFORM4I64VARBPROC.invoke(load("glUniform4i64vARB"), location, count, value);
  }

  public void glMultiTexCoord3dv(int target, MemorySegment v) {
    PFNGLMULTITEXCOORD3DVARBPROC.invoke(load("glMultiTexCoord3dv"), target, v);
  }

  public void glBindSamplers(int first, int count, MemorySegment samplers) {
    PFNGLBINDSAMPLERSPROC.invoke(load("glBindSamplers"), first, count, samplers);
  }

  public void glMap2xOES(int target, int u1, int u2, int ustride, int uorder, int v1, int v2, int vstride, int vorder, int points) {
    PFNGLMAP2XOESPROC.invoke(load("glMap2xOES"), target, u1, u2, ustride, uorder, v1, v2, vstride, vorder, points);
  }

  public void glUniform3ui64NV(int location, long x, long y, long z) {
    PFNGLUNIFORM3UI64NVPROC.invoke(load("glUniform3ui64NV"), location, x, y, z);
  }

  public void glViewportIndexedfvNV(int index, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public byte glIsVariantEnabledEXT(int id, int cap) {
    return PFNGLISVARIANTENABLEDEXTPROC.invoke(load("glIsVariantEnabledEXT"), id, cap);
  }

  public void glGetFramebufferParameterfvAMD(int target, int pname, int numsamples, int pixelindex, int size, MemorySegment values) {
    PFNGLGETFRAMEBUFFERPARAMETERFVAMDPROC.invoke(load("glGetFramebufferParameterfvAMD"), target, pname, numsamples, pixelindex, size, values);
  }

  public void glProgramUniform1ui64vNV(int program, int location, int count, MemorySegment value) {
    PFNGLPROGRAMUNIFORM1UI64VNVPROC.invoke(load("glProgramUniform1ui64vNV"), program, location, count, value);
  }

  public void glExecuteProgramNV(int target, int id, MemorySegment params) {
    PFNGLEXECUTEPROGRAMNVPROC.invoke(load("glExecuteProgramNV"), target, id, params);
  }

  public void glFragmentMaterialfSGIX(int face, int pname, float param) {
    PFNGLFRAGMENTMATERIALFSGIXPROC.invoke(load("glFragmentMaterialfSGIX"), face, pname, param);
  }

  public void glEnablei(int target, int index) {
    PFNGLENABLEIPROC.invoke(load("glEnablei"), target, index);
  }

  public void glReplacementCodePointerSUN(int type, int stride, MemorySegment pointer) {
    PFNGLREPLACEMENTCODEPOINTERSUNPROC.invoke(load("glReplacementCodePointerSUN"), type, stride, pointer);
  }

  public void glUniform4ui64NV(int location, long x, long y, long z, long w) {
    PFNGLUNIFORM4UI64NVPROC.invoke(load("glUniform4ui64NV"), location, x, y, z, w);
  }

  public void glColorMaski(int index, byte r, byte g, byte b, byte a) {
    PFNGLCOLORMASKIPROC.invoke(load("glColorMaski"), index, r, g, b, a);
  }

  public void glSyncTextureINTEL(int texture) {
    PFNGLSYNCTEXTUREINTELPROC.invoke(load("glSyncTextureINTEL"), texture);
  }

  public void glUniform2ui64NV(int location, long x, long y) {
    PFNGLUNIFORM2UI64NVPROC.invoke(load("glUniform2ui64NV"), location, x, y);
  }

  public void glCopyConvolutionFilter1D(int target, int internalformat, int x, int y, int width) {
    PFNGLCOPYCONVOLUTIONFILTER1DEXTPROC.invoke(load("glCopyConvolutionFilter1D"), target, internalformat, x, y, width);
  }

  public void glMultiTexCoord3fv(int target, MemorySegment v) {
    PFNGLMULTITEXCOORD3FVARBPROC.invoke(load("glMultiTexCoord3fv"), target, v);
  }

  public void glMultiTexCoord4fARB(int target, float s, float t, float r, float q) {
    PFNGLMULTITEXCOORD4FARBPROC.invoke(load("glMultiTexCoord4fARB"), target, s, t, r, q);
  }

  public void glNamedProgramLocalParametersI4uivEXT(int program, int target, int index, int count, MemorySegment params) {
    PFNGLNAMEDPROGRAMLOCALPARAMETERSI4UIVEXTPROC.invoke(load("glNamedProgramLocalParametersI4uivEXT"), program, target, index, count, params);
  }

  public void glMakeImageHandleNonResidentNV(long handle) {
    PFNGLMAKEIMAGEHANDLENONRESIDENTNVPROC.invoke(load("glMakeImageHandleNonResidentNV"), handle);
  }

  public void glGenNamesAMD(int identifier, int num, MemorySegment names) {
    PFNGLGENNAMESAMDPROC.invoke(load("glGenNamesAMD"), identifier, num, names);
  }

  public void glGetIntegeri_v(int target, int index, MemorySegment data) {
    PFNGLGETINTEGERI_VPROC.invoke(load("glGetIntegeri_v"), target, index, data);
  }

  public void glProgramUniform4ivEXT(int program, int location, int count, MemorySegment value) {
    PFNGLPROGRAMUNIFORM4IVEXTPROC.invoke(load("glProgramUniform4ivEXT"), program, location, count, value);
  }

  public void glGetMultiTexParameterIivEXT(int texunit, int target, int pname, MemorySegment params) {
    PFNGLGETMULTITEXPARAMETERIIVEXTPROC.invoke(load("glGetMultiTexParameterIivEXT"), texunit, target, pname, params);
  }

  public void glAttachObjectARB(int containerObj, int obj) {
    opengl.windows.PFNGLATTACHOBJECTARBPROC.invoke(load("glAttachObjectARB"), containerObj, obj);
  }

  public void glCurrentPaletteMatrixARB(int index) {
    PFNGLCURRENTPALETTEMATRIXARBPROC.invoke(load("glCurrentPaletteMatrixARB"), index);
  }

  public MemorySegment glImportSyncEXT(int external_sync_type, long external_sync, int flags) {
    return PFNGLIMPORTSYNCEXTPROC.invoke(load("glImportSyncEXT"), external_sync_type, external_sync, flags);
  }

  public int glGetFramebufferPixelLocalStorageSizeEXT(int target) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glCopyConvolutionFilter2D(int target, int internalformat, int x, int y, int width, int height) {
    PFNGLCOPYCONVOLUTIONFILTER2DEXTPROC.invoke(load("glCopyConvolutionFilter2D"), target, internalformat, x, y, width, height);
  }

  public void glVertex4hNV(short x, short y, short z, short w) {
    PFNGLVERTEX4HNVPROC.invoke(load("glVertex4hNV"), x, y, z, w);
  }

  public void glDisableVertexAttribAPPLE(int index, int pname) {
    PFNGLDISABLEVERTEXATTRIBAPPLEPROC.invoke(load("glDisableVertexAttribAPPLE"), index, pname);
  }

  public void glMatrixMultTransposedEXT(int mode, MemorySegment m) {
    PFNGLMATRIXMULTTRANSPOSEDEXTPROC.invoke(load("glMatrixMultTransposedEXT"), mode, m);
  }

  public void glGetBufferParameteriv(int target, int pname, MemorySegment params) {
    PFNGLGETBUFFERPARAMETERIVPROC.invoke(load("glGetBufferParameteriv"), target, pname, params);
  }

  public void glExtGetFramebuffersQCOM(MemorySegment framebuffers, int maxFramebuffers, MemorySegment numFramebuffers) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDrawBuffers(int n, MemorySegment bufs) {
    PFNGLDRAWBUFFERSPROC.invoke(load("glDrawBuffers"), n, bufs);
  }

  public void glSharpenTexFuncSGIS(int target, int n, MemorySegment points) {
    PFNGLSHARPENTEXFUNCSGISPROC.invoke(load("glSharpenTexFuncSGIS"), target, n, points);
  }

  public void glSamplePatternSGIS(int pattern) {
    PFNGLSAMPLEPATTERNSGISPROC.invoke(load("glSamplePatternSGIS"), pattern);
  }

  public void glGetInternalformatSampleivNV(int target, int internalformat, int samples, int pname, int count, MemorySegment params) {
    PFNGLGETINTERNALFORMATSAMPLEIVNVPROC.invoke(load("glGetInternalformatSampleivNV"), target, internalformat, samples, pname, count, params);
  }

  public void glDebugMessageControlARB(int source, int type, int severity, int count, MemorySegment ids, byte enabled) {
    PFNGLDEBUGMESSAGECONTROLARBPROC.invoke(load("glDebugMessageControlARB"), source, type, severity, count, ids, enabled);
  }

  public void glGetNamedProgramLocalParameterfvEXT(int program, int target, int index, MemorySegment params) {
    PFNGLGETNAMEDPROGRAMLOCALPARAMETERFVEXTPROC.invoke(load("glGetNamedProgramLocalParameterfvEXT"), program, target, index, params);
  }

  public void glGetSemaphoreParameterivNV(int semaphore, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glStencilMaskSeparate(int face, int mask) {
    PFNGLSTENCILMASKSEPARATEPROC.invoke(load("glStencilMaskSeparate"), face, mask);
  }

  public void glGetVideoui64vNV(int video_slot, int pname, MemorySegment params) {
    PFNGLGETVIDEOUI64VNVPROC.invoke(load("glGetVideoui64vNV"), video_slot, pname, params);
  }

  public void glDrawElementsInstancedBaseVertexEXT(int mode, int count, int type, MemorySegment indices, int instancecount, int basevertex) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGenQueriesARB(int n, MemorySegment ids) {
    PFNGLGENQUERIESARBPROC.invoke(load("glGenQueriesARB"), n, ids);
  }

  public void glGetDoublei_v(int target, int index, MemorySegment data) {
    PFNGLGETDOUBLEI_VPROC.invoke(load("glGetDoublei_v"), target, index, data);
  }

  public void glBlendFuncIndexedAMD(int buf, int src, int dst) {
    PFNGLBLENDFUNCINDEXEDAMDPROC.invoke(load("glBlendFuncIndexedAMD"), buf, src, dst);
  }

  public void glDetachObjectARB(int containerObj, int attachedObj) {
    opengl.windows.PFNGLDETACHOBJECTARBPROC.invoke(load("glDetachObjectARB"), containerObj, attachedObj);
  }

  public void glMaxShaderCompilerThreadsARB(int count) {
    PFNGLMAXSHADERCOMPILERTHREADSARBPROC.invoke(load("glMaxShaderCompilerThreadsARB"), count);
  }

  public void glMultiTexCoord3iv(int target, MemorySegment v) {
    PFNGLMULTITEXCOORD3IVARBPROC.invoke(load("glMultiTexCoord3iv"), target, v);
  }

  public void glMultiTexCoord3dARB(int target, double s, double t, double r) {
    PFNGLMULTITEXCOORD3DARBPROC.invoke(load("glMultiTexCoord3dARB"), target, s, t, r);
  }

  public void glGetColorTableParameterivEXT(int target, int pname, MemorySegment params) {
    PFNGLGETCOLORTABLEPARAMETERIVEXTPROC.invoke(load("glGetColorTableParameterivEXT"), target, pname, params);
  }

  public void glBinormal3iEXT(int bx, int by, int bz) {
    PFNGLBINORMAL3IEXTPROC.invoke(load("glBinormal3iEXT"), bx, by, bz);
  }

  public void glExtrapolateTex2DQCOM(int src1, int src2, int output, float scaleFactor) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetVertexAttribfvNV(int index, int pname, MemorySegment params) {
    PFNGLGETVERTEXATTRIBFVNVPROC.invoke(load("glGetVertexAttribfvNV"), index, pname, params);
  }

  public void glDisableVertexArrayEXT(int vaobj, int array) {
    PFNGLDISABLEVERTEXARRAYEXTPROC.invoke(load("glDisableVertexArrayEXT"), vaobj, array);
  }

  public void glProgramUniform1ui64vARB(int program, int location, int count, MemorySegment value) {
    PFNGLPROGRAMUNIFORM1UI64VARBPROC.invoke(load("glProgramUniform1ui64vARB"), program, location, count, value);
  }

  public void glGetNamedProgramStringEXT(int program, int target, int pname, MemorySegment string) {
    PFNGLGETNAMEDPROGRAMSTRINGEXTPROC.invoke(load("glGetNamedProgramStringEXT"), program, target, pname, string);
  }

  public void glNamedProgramLocalParameter4dEXT(int program, int target, int index, double x, double y, double z, double w) {
    PFNGLNAMEDPROGRAMLOCALPARAMETER4DEXTPROC.invoke(load("glNamedProgramLocalParameter4dEXT"), program, target, index, x, y, z, w);
  }

  public void glEndPerfQueryINTEL(int queryHandle) {
    PFNGLENDPERFQUERYINTELPROC.invoke(load("glEndPerfQueryINTEL"), queryHandle);
  }

  public byte glAcquireKeyedMutexWin32EXT(int memory, long key, int timeout) {
    return PFNGLACQUIREKEYEDMUTEXWIN32EXTPROC.invoke(load("glAcquireKeyedMutexWin32EXT"), memory, key, timeout);
  }

  public void glGetMultiTexParameterfvEXT(int texunit, int target, int pname, MemorySegment params) {
    PFNGLGETMULTITEXPARAMETERFVEXTPROC.invoke(load("glGetMultiTexParameterfvEXT"), texunit, target, pname, params);
  }

  public void glProgramUniformMatrix2x4fvEXT(int program, int location, int count, byte transpose, MemorySegment value) {
    PFNGLPROGRAMUNIFORMMATRIX2X4FVEXTPROC.invoke(load("glProgramUniformMatrix2x4fvEXT"), program, location, count, transpose, value);
  }

  public void glVertexAttribDivisorANGLE(int index, int divisor) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public byte glIsRenderbufferOES(int renderbuffer) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribs4ubvNV(int index, int count, MemorySegment v) {
    PFNGLVERTEXATTRIBS4UBVNVPROC.invoke(load("glVertexAttribs4ubvNV"), index, count, v);
  }

  public void glGetClipPlanexOES(int plane, MemorySegment equation) {
    PFNGLGETCLIPPLANEXOESPROC.invoke(load("glGetClipPlanexOES"), plane, equation);
  }

  public void glUniformui64NV(int location, long value) {
    PFNGLUNIFORMUI64NVPROC.invoke(load("glUniformui64NV"), location, value);
  }

  public void glTextureParameterivEXT(int texture, int target, int pname, MemorySegment params) {
    PFNGLTEXTUREPARAMETERIVEXTPROC.invoke(load("glTextureParameterivEXT"), texture, target, pname, params);
  }

  public void glProgramUniform3uiv(int program, int location, int count, MemorySegment value) {
    PFNGLPROGRAMUNIFORM3UIVPROC.invoke(load("glProgramUniform3uiv"), program, location, count, value);
  }

  public void glUniformMatrix4x3fvNV(int location, int count, byte transpose, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttrib3sv(int index, MemorySegment v) {
    PFNGLVERTEXATTRIB3SVPROC.invoke(load("glVertexAttrib3sv"), index, v);
  }

  public void glColorSubTable(int target, int start, int count, int format, int type, MemorySegment data) {
    PFNGLCOLORSUBTABLEEXTPROC.invoke(load("glColorSubTable"), target, start, count, format, type, data);
  }

  public byte glAreTexturesResidentEXT(int n, MemorySegment textures, MemorySegment residences) {
    return PFNGLARETEXTURESRESIDENTEXTPROC.invoke(load("glAreTexturesResidentEXT"), n, textures, residences);
  }

  public void glScalexOES(int x, int y, int z) {
    PFNGLSCALEXOESPROC.invoke(load("glScalexOES"), x, y, z);
  }

  public void glGetConvolutionParameteriv(int target, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public byte glTestFenceAPPLE(int fence) {
    return PFNGLTESTFENCEAPPLEPROC.invoke(load("glTestFenceAPPLE"), fence);
  }

  public void glMultiTexSubImage2DEXT(int texunit, int target, int level, int xoffset, int yoffset, int width, int height, int format, int type, MemorySegment pixels) {
    PFNGLMULTITEXSUBIMAGE2DEXTPROC.invoke(load("glMultiTexSubImage2DEXT"), texunit, target, level, xoffset, yoffset, width, height, format, type, pixels);
  }

  public void glGetConvolutionParameterfv(int target, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glClampColor(int target, int clamp) {
    PFNGLCLAMPCOLORPROC.invoke(load("glClampColor"), target, clamp);
  }

  public void glCompressedTextureImage2DEXT(int texture, int target, int level, int internalformat, int width, int height, int border, int imageSize, MemorySegment bits) {
    PFNGLCOMPRESSEDTEXTUREIMAGE2DEXTPROC.invoke(load("glCompressedTextureImage2DEXT"), texture, target, level, internalformat, width, height, border, imageSize, bits);
  }

  public void glVertexAttrib2dARB(int index, double x, double y) {
    PFNGLVERTEXATTRIB2DARBPROC.invoke(load("glVertexAttrib2dARB"), index, x, y);
  }

  public void glGetProgramStringARB(int target, int pname, MemorySegment string) {
    PFNGLGETPROGRAMSTRINGARBPROC.invoke(load("glGetProgramStringARB"), target, pname, string);
  }

  public void glArrayElementEXT(int i) {
    PFNGLARRAYELEMENTEXTPROC.invoke(load("glArrayElementEXT"), i);
  }

  public void glVertexPointerListIBM(int size, int type, int stride, MemorySegment pointer, int ptrstride) {
    PFNGLVERTEXPOINTERLISTIBMPROC.invoke(load("glVertexPointerListIBM"), size, type, stride, pointer, ptrstride);
  }

  public void glImageTransformParameteriHP(int target, int pname, int param) {
    PFNGLIMAGETRANSFORMPARAMETERIHPPROC.invoke(load("glImageTransformParameteriHP"), target, pname, param);
  }

  public void glGetProgramNamedParameterdvNV(int id, int len, MemorySegment name, MemorySegment params) {
    PFNGLGETPROGRAMNAMEDPARAMETERDVNVPROC.invoke(load("glGetProgramNamedParameterdvNV"), id, len, name, params);
  }

  public void glProgramUniform1iv(int program, int location, int count, MemorySegment value) {
    PFNGLPROGRAMUNIFORM1IVPROC.invoke(load("glProgramUniform1iv"), program, location, count, value);
  }

  public void glSamplerParameterIuivOES(int sampler, int pname, MemorySegment param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMulticastCopyImageSubDataNV(int srcGpu, int dstGpuMask, int srcName, int srcTarget, int srcLevel, int srcX, int srcY, int srcZ, int dstName, int dstTarget, int dstLevel, int dstX, int dstY, int dstZ, int srcWidth, int srcHeight, int srcDepth) {
    PFNGLMULTICASTCOPYIMAGESUBDATANVPROC.invoke(load("glMulticastCopyImageSubDataNV"), srcGpu, dstGpuMask, srcName, srcTarget, srcLevel, srcX, srcY, srcZ, dstName, dstTarget, dstLevel, dstX, dstY, dstZ, srcWidth, srcHeight, srcDepth);
  }

  public void glBlendFunciEXT(int buf, int src, int dst) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetMultiTexEnvfvEXT(int texunit, int target, int pname, MemorySegment params) {
    PFNGLGETMULTITEXENVFVEXTPROC.invoke(load("glGetMultiTexEnvfvEXT"), texunit, target, pname, params);
  }

  public void glDisableiEXT(int target, int index) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFrustumxOES(int l, int r, int b, int t, int n, int f) {
    PFNGLFRUSTUMXOESPROC.invoke(load("glFrustumxOES"), l, r, b, t, n, f);
  }

  public void glGetFixedv(int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glCreateFramebuffers(int n, MemorySegment framebuffers) {
    PFNGLCREATEFRAMEBUFFERSPROC.invoke(load("glCreateFramebuffers"), n, framebuffers);
  }

  public void glGetAttachedObjectsARB(int containerObj, int maxCount, MemorySegment count, MemorySegment obj) {
    opengl.windows.PFNGLGETATTACHEDOBJECTSARBPROC.invoke(load("glGetAttachedObjectsARB"), containerObj, maxCount, count, obj);
  }

  public void glTexCoord2hvNV(MemorySegment v) {
    PFNGLTEXCOORD2HVNVPROC.invoke(load("glTexCoord2hvNV"), v);
  }

  public void glTangent3fvEXT(MemorySegment v) {
    PFNGLTANGENT3FVEXTPROC.invoke(load("glTangent3fvEXT"), v);
  }

  public void glInsertEventMarkerEXT(int length, MemorySegment marker) {
    PFNGLINSERTEVENTMARKEREXTPROC.invoke(load("glInsertEventMarkerEXT"), length, marker);
  }

  public void glBindSampler(int unit, int sampler) {
    PFNGLBINDSAMPLERPROC.invoke(load("glBindSampler"), unit, sampler);
  }

  public void glVertexAttrib4NuivARB(int index, MemorySegment v) {
    PFNGLVERTEXATTRIB4NUIVARBPROC.invoke(load("glVertexAttrib4NuivARB"), index, v);
  }

  public void glGetCompressedTextureSubImage(int texture, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int bufSize, MemorySegment pixels) {
    PFNGLGETCOMPRESSEDTEXTURESUBIMAGEPROC.invoke(load("glGetCompressedTextureSubImage"), texture, level, xoffset, yoffset, zoffset, width, height, depth, bufSize, pixels);
  }

  public void glGetObjectPtrLabelKHR(MemorySegment ptr, int bufSize, MemorySegment length, MemorySegment label) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttrib3fARB(int index, float x, float y, float z) {
    PFNGLVERTEXATTRIB3FARBPROC.invoke(load("glVertexAttrib3fARB"), index, x, y, z);
  }

  public void glDeleteProgram(int program) {
    PFNGLDELETEPROGRAMPROC.invoke(load("glDeleteProgram"), program);
  }

  public void glMulticastGetQueryObjectivNV(int gpu, int id, int pname, MemorySegment params) {
    PFNGLMULTICASTGETQUERYOBJECTIVNVPROC.invoke(load("glMulticastGetQueryObjectivNV"), gpu, id, pname, params);
  }

  public void glProgramUniform1dvEXT(int program, int location, int count, MemorySegment value) {
    PFNGLPROGRAMUNIFORM1DVEXTPROC.invoke(load("glProgramUniform1dvEXT"), program, location, count, value);
  }

  public long glGetImageHandleNV(int texture, int level, byte layered, int layer, int format) {
    return PFNGLGETIMAGEHANDLENVPROC.invoke(load("glGetImageHandleNV"), texture, level, layered, layer, format);
  }

  public void glGenVertexArraysOES(int n, MemorySegment arrays) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glClearColorxOES(int red, int green, int blue, int alpha) {
    PFNGLCLEARCOLORXOESPROC.invoke(load("glClearColorxOES"), red, green, blue, alpha);
  }

  public void glNamedFramebufferTexture2DEXT(int framebuffer, int attachment, int textarget, int texture, int level) {
    PFNGLNAMEDFRAMEBUFFERTEXTURE2DEXTPROC.invoke(load("glNamedFramebufferTexture2DEXT"), framebuffer, attachment, textarget, texture, level);
  }

  public void glMultiTexCoord4ivARB(int target, MemorySegment v) {
    PFNGLMULTITEXCOORD4IVARBPROC.invoke(load("glMultiTexCoord4ivARB"), target, v);
  }

  public void glExtractComponentEXT(int res, int src, int num) {
    PFNGLEXTRACTCOMPONENTEXTPROC.invoke(load("glExtractComponentEXT"), res, src, num);
  }

  public void glFramebufferTextureLayerARB(int target, int attachment, int texture, int level, int layer) {
    PFNGLFRAMEBUFFERTEXTURELAYERARBPROC.invoke(load("glFramebufferTextureLayerARB"), target, attachment, texture, level, layer);
  }

  public void glGetTextureParameterIiv(int texture, int pname, MemorySegment params) {
    PFNGLGETTEXTUREPARAMETERIIVPROC.invoke(load("glGetTextureParameterIiv"), texture, pname, params);
  }

  public void glVertexAttribP3uiv(int index, int type, byte normalized, MemorySegment value) {
    PFNGLVERTEXATTRIBP3UIVPROC.invoke(load("glVertexAttribP3uiv"), index, type, normalized, value);
  }

  public void glTransformFeedbackVaryingsEXT(int program, int count, MemorySegment varyings, int bufferMode) {
    PFNGLTRANSFORMFEEDBACKVARYINGSEXTPROC.invoke(load("glTransformFeedbackVaryingsEXT"), program, count, varyings, bufferMode);
  }

  public void glVertexAttribI2uiEXT(int index, int x, int y) {
    PFNGLVERTEXATTRIBI2UIEXTPROC.invoke(load("glVertexAttribI2uiEXT"), index, x, y);
  }

  public int glGetFragDataLocation(int program, MemorySegment name) {
    return PFNGLGETFRAGDATALOCATIONPROC.invoke(load("glGetFragDataLocation"), program, name);
  }

  public void glSecondaryColor3ubvEXT(MemorySegment v) {
    PFNGLSECONDARYCOLOR3UBVEXTPROC.invoke(load("glSecondaryColor3ubvEXT"), v);
  }

  public void glFlushVertexArrayRangeNV() {
    PFNGLFLUSHVERTEXARRAYRANGENVPROC.invoke(load("glFlushVertexArrayRangeNV"));
  }

  public void glMultiTexGenivEXT(int texunit, int coord, int pname, MemorySegment params) {
    PFNGLMULTITEXGENIVEXTPROC.invoke(load("glMultiTexGenivEXT"), texunit, coord, pname, params);
  }

  public void glReleaseShaderCompiler() {
    PFNGLRELEASESHADERCOMPILERPROC.invoke(load("glReleaseShaderCompiler"));
  }

  public void glCallCommandListNV(int list) {
    PFNGLCALLCOMMANDLISTNVPROC.invoke(load("glCallCommandListNV"), list);
  }

  public void glVertexAttrib1hvNV(int index, MemorySegment v) {
    PFNGLVERTEXATTRIB1HVNVPROC.invoke(load("glVertexAttrib1hvNV"), index, v);
  }

  public void glColor4ubVertex3fvSUN(MemorySegment c, MemorySegment v) {
    PFNGLCOLOR4UBVERTEX3FVSUNPROC.invoke(load("glColor4ubVertex3fvSUN"), c, v);
  }

  public void glEnableiNV(int target, int index) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexCoord4hNV(int target, short s, short t, short r, short q) {
    PFNGLMULTITEXCOORD4HNVPROC.invoke(load("glMultiTexCoord4hNV"), target, s, t, r, q);
  }

  public void glVertexAttrib4sARB(int index, short x, short y, short z, short w) {
    PFNGLVERTEXATTRIB4SARBPROC.invoke(load("glVertexAttrib4sARB"), index, x, y, z, w);
  }

  public int glGetCommandHeaderNV(int tokenID, int size) {
    return PFNGLGETCOMMANDHEADERNVPROC.invoke(load("glGetCommandHeaderNV"), tokenID, size);
  }

  public void glGetnUniformivKHR(int program, int location, int bufSize, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public byte glUnmapBufferARB(int target) {
    return PFNGLUNMAPBUFFERARBPROC.invoke(load("glUnmapBufferARB"), target);
  }

  public byte glUnmapNamedBufferEXT(int buffer) {
    return PFNGLUNMAPNAMEDBUFFEREXTPROC.invoke(load("glUnmapNamedBufferEXT"), buffer);
  }

  public void glGetNamedProgramLocalParameterdvEXT(int program, int target, int index, MemorySegment params) {
    PFNGLGETNAMEDPROGRAMLOCALPARAMETERDVEXTPROC.invoke(load("glGetNamedProgramLocalParameterdvEXT"), program, target, index, params);
  }

  public void glVertexAttribL3i64NV(int index, long x, long y, long z) {
    PFNGLVERTEXATTRIBL3I64NVPROC.invoke(load("glVertexAttribL3i64NV"), index, x, y, z);
  }

  public void glDeleteSemaphoresEXT(int n, MemorySegment semaphores) {
    PFNGLDELETESEMAPHORESEXTPROC.invoke(load("glDeleteSemaphoresEXT"), n, semaphores);
  }

  public void glGetBufferParameterivARB(int target, int pname, MemorySegment params) {
    PFNGLGETBUFFERPARAMETERIVARBPROC.invoke(load("glGetBufferParameterivARB"), target, pname, params);
  }

  public void glVertexAttrib1svNV(int index, MemorySegment v) {
    PFNGLVERTEXATTRIB1SVNVPROC.invoke(load("glVertexAttrib1svNV"), index, v);
  }

  public void glMultiTexCoord2f(int target, float s, float t) {
    PFNGLMULTITEXCOORD2FARBPROC.invoke(load("glMultiTexCoord2f"), target, s, t);
  }

  public void glMultiTexCoord2d(int target, double s, double t) {
    PFNGLMULTITEXCOORD2DARBPROC.invoke(load("glMultiTexCoord2d"), target, s, t);
  }

  public void glMultiTexCoord2i(int target, int s, int t) {
    PFNGLMULTITEXCOORD2IARBPROC.invoke(load("glMultiTexCoord2i"), target, s, t);
  }

  public void glReadnPixelsKHR(int x, int y, int width, int height, int format, int type, int bufSize, MemorySegment data) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribI3iv(int index, MemorySegment v) {
    PFNGLVERTEXATTRIBI3IVPROC.invoke(load("glVertexAttribI3iv"), index, v);
  }

  public void glUniformMatrix4x3dv(int location, int count, byte transpose, MemorySegment value) {
    PFNGLUNIFORMMATRIX4X3DVPROC.invoke(load("glUniformMatrix4x3dv"), location, count, transpose, value);
  }

  public void glMultiTexCoord1s(int target, short s) {
    PFNGLMULTITEXCOORD1SARBPROC.invoke(load("glMultiTexCoord1s"), target, s);
  }

  public void glDrawTransformFeedbackInstancedEXT(int mode, int id, int instancecount) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glNormalPointervINTEL(int type, MemorySegment pointer) {
    PFNGLNORMALPOINTERVINTELPROC.invoke(load("glNormalPointervINTEL"), type, pointer);
  }

  public void glUniformMatrix3x4fvNV(int location, int count, byte transpose, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetPathParameterfvNV(int path, int pname, MemorySegment value) {
    PFNGLGETPATHPARAMETERFVNVPROC.invoke(load("glGetPathParameterfvNV"), path, pname, value);
  }

  public MemorySegment glFenceSyncAPPLE(int condition, int flags) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniform2i64NV(int location, long x, long y) {
    PFNGLUNIFORM2I64NVPROC.invoke(load("glUniform2i64NV"), location, x, y);
  }

  public byte glIsShader(int shader) {
    return PFNGLISSHADERPROC.invoke(load("glIsShader"), shader);
  }

  public void glMultiTexCoord1f(int target, float s) {
    PFNGLMULTITEXCOORD1FARBPROC.invoke(load("glMultiTexCoord1f"), target, s);
  }

  public void glBlendFunci(int buf, int src, int dst) {
    PFNGLBLENDFUNCIPROC.invoke(load("glBlendFunci"), buf, src, dst);
  }

  public void glMultiTexCoord1d(int target, double s) {
    PFNGLMULTITEXCOORD1DARBPROC.invoke(load("glMultiTexCoord1d"), target, s);
  }

  public void glMultiTexCoord1i(int target, int s) {
    PFNGLMULTITEXCOORD1IARBPROC.invoke(load("glMultiTexCoord1i"), target, s);
  }

  public void glClipPlanexIMG(int p, MemorySegment eqn) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniform4fvARB(int location, int count, MemorySegment value) {
    PFNGLUNIFORM4FVARBPROC.invoke(load("glUniform4fvARB"), location, count, value);
  }

  public void glGetProgramParameterdvNV(int target, int index, int pname, MemorySegment params) {
    PFNGLGETPROGRAMPARAMETERDVNVPROC.invoke(load("glGetProgramParameterdvNV"), target, index, pname, params);
  }

  public void glPointSizex(int size) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetInternalformati64v(int target, int internalformat, int pname, int count, MemorySegment params) {
    PFNGLGETINTERNALFORMATI64VPROC.invoke(load("glGetInternalformati64v"), target, internalformat, pname, count, params);
  }

  public void glGetNamedBufferParameteriv(int buffer, int pname, MemorySegment params) {
    PFNGLGETNAMEDBUFFERPARAMETERIVPROC.invoke(load("glGetNamedBufferParameteriv"), buffer, pname, params);
  }

  public int glPathGlyphIndexArrayNV(int firstPathName, int fontTarget, MemorySegment fontName, int fontStyle, int firstGlyphIndex, int numGlyphs, int pathParameterTemplate, float emScale) {
    return PFNGLPATHGLYPHINDEXARRAYNVPROC.invoke(load("glPathGlyphIndexArrayNV"), firstPathName, fontTarget, fontName, fontStyle, firstGlyphIndex, numGlyphs, pathParameterTemplate, emScale);
  }

  public void glGetVariantIntegervEXT(int id, int value, MemorySegment data) {
    PFNGLGETVARIANTINTEGERVEXTPROC.invoke(load("glGetVariantIntegervEXT"), id, value, data);
  }

  public void glUniform4ui64vNV(int location, int count, MemorySegment value) {
    PFNGLUNIFORM4UI64VNVPROC.invoke(load("glUniform4ui64vNV"), location, count, value);
  }

  public void glSecondaryColor3uiv(MemorySegment v) {
    PFNGLSECONDARYCOLOR3UIVPROC.invoke(load("glSecondaryColor3uiv"), v);
  }

  public void glFinishFenceAPPLE(int fence) {
    PFNGLFINISHFENCEAPPLEPROC.invoke(load("glFinishFenceAPPLE"), fence);
  }

  public void glUniformMatrix4x3fv(int location, int count, byte transpose, MemorySegment value) {
    PFNGLUNIFORMMATRIX4X3FVPROC.invoke(load("glUniformMatrix4x3fv"), location, count, transpose, value);
  }

  public void glConvolutionFilter2DEXT(int target, int internalformat, int width, int height, int format, int type, MemorySegment image) {
    PFNGLCONVOLUTIONFILTER2DEXTPROC.invoke(load("glConvolutionFilter2DEXT"), target, internalformat, width, height, format, type, image);
  }

  public void glVertexBindingDivisor(int bindingindex, int divisor) {
    PFNGLVERTEXBINDINGDIVISORPROC.invoke(load("glVertexBindingDivisor"), bindingindex, divisor);
  }

  public void glDrawBuffersARB(int n, MemorySegment bufs) {
    PFNGLDRAWBUFFERSARBPROC.invoke(load("glDrawBuffersARB"), n, bufs);
  }

  public void glMultiTexCoord4iARB(int target, int s, int t, int r, int q) {
    PFNGLMULTITEXCOORD4IARBPROC.invoke(load("glMultiTexCoord4iARB"), target, s, t, r, q);
  }

  public void glDebugMessageCallbackKHR(MemorySegment callback, MemorySegment userParam) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniform4i64vNV(int program, int location, int count, MemorySegment value) {
    PFNGLPROGRAMUNIFORM4I64VNVPROC.invoke(load("glProgramUniform4i64vNV"), program, location, count, value);
  }

  public void glGenTransformFeedbacks(int n, MemorySegment ids) {
    PFNGLGENTRANSFORMFEEDBACKSPROC.invoke(load("glGenTransformFeedbacks"), n, ids);
  }

  public void glVertexAttrib2dNV(int index, double x, double y) {
    PFNGLVERTEXATTRIB2DNVPROC.invoke(load("glVertexAttrib2dNV"), index, x, y);
  }

  public void glSecondaryColorFormatNV(int size, int type, int stride) {
    PFNGLSECONDARYCOLORFORMATNVPROC.invoke(load("glSecondaryColorFormatNV"), size, type, stride);
  }

  public void glSetFragmentShaderConstantATI(int dst, MemorySegment value) {
    PFNGLSETFRAGMENTSHADERCONSTANTATIPROC.invoke(load("glSetFragmentShaderConstantATI"), dst, value);
  }

  public void glMakeBufferResidentNV(int target, int access) {
    PFNGLMAKEBUFFERRESIDENTNVPROC.invoke(load("glMakeBufferResidentNV"), target, access);
  }

  public void glEGLImageTargetTextureStorageEXT(int texture, MemorySegment image, MemorySegment attrib_list) {
    PFNGLEGLIMAGETARGETTEXTURESTORAGEEXTPROC.invoke(load("glEGLImageTargetTextureStorageEXT"), texture, image, attrib_list);
  }

  public void glVertexAttrib3fv(int index, MemorySegment v) {
    PFNGLVERTEXATTRIB3FVPROC.invoke(load("glVertexAttrib3fv"), index, v);
  }

  public void glGetPixelMapxv(int map, int size, MemorySegment values) {
    PFNGLGETPIXELMAPXVPROC.invoke(load("glGetPixelMapxv"), map, size, values);
  }

  public void glVertexAttribI4usvEXT(int index, MemorySegment v) {
    PFNGLVERTEXATTRIBI4USVEXTPROC.invoke(load("glVertexAttribI4usvEXT"), index, v);
  }

  public void glDisableiNV(int target, int index) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public byte glVDPAUIsSurfaceNV(long surface) {
    return PFNGLVDPAUISSURFACENVPROC.invoke(load("glVDPAUIsSurfaceNV"), surface);
  }

  public void glBlendEquationSeparate(int modeRGB, int modeAlpha) {
    PFNGLBLENDEQUATIONSEPARATEPROC.invoke(load("glBlendEquationSeparate"), modeRGB, modeAlpha);
  }

  public void glGetTextureLevelParameterfvEXT(int texture, int target, int level, int pname, MemorySegment params) {
    PFNGLGETTEXTURELEVELPARAMETERFVEXTPROC.invoke(load("glGetTextureLevelParameterfvEXT"), texture, target, level, pname, params);
  }

  public void glImageTransformParameterivHP(int target, int pname, MemorySegment params) {
    PFNGLIMAGETRANSFORMPARAMETERIVHPPROC.invoke(load("glImageTransformParameterivHP"), target, pname, params);
  }

  public void glColorFormatNV(int size, int type, int stride) {
    PFNGLCOLORFORMATNVPROC.invoke(load("glColorFormatNV"), size, type, stride);
  }

  public void glGetUniformuiv(int program, int location, MemorySegment params) {
    PFNGLGETUNIFORMUIVPROC.invoke(load("glGetUniformuiv"), program, location, params);
  }

  public void glVertex3bOES(byte x, byte y, byte z) {
    PFNGLVERTEX3BOESPROC.invoke(load("glVertex3bOES"), x, y, z);
  }

  public void glProgramUniform4fEXT(int program, int location, float v0, float v1, float v2, float v3) {
    PFNGLPROGRAMUNIFORM4FEXTPROC.invoke(load("glProgramUniform4fEXT"), program, location, v0, v1, v2, v3);
  }

  public void glMultiTexCoord1sv(int target, MemorySegment v) {
    PFNGLMULTITEXCOORD1SVARBPROC.invoke(load("glMultiTexCoord1sv"), target, v);
  }

  public void glTransformFeedbackVaryingsNV(int program, int count, MemorySegment locations, int bufferMode) {
    PFNGLTRANSFORMFEEDBACKVARYINGSNVPROC.invoke(load("glTransformFeedbackVaryingsNV"), program, count, locations, bufferMode);
  }

  public void glSecondaryColor3ubv(MemorySegment v) {
    PFNGLSECONDARYCOLOR3UBVPROC.invoke(load("glSecondaryColor3ubv"), v);
  }

  public void glSeparableFilter2D(int target, int internalformat, int width, int height, int format, int type, MemorySegment row, MemorySegment column) {
    PFNGLSEPARABLEFILTER2DEXTPROC.invoke(load("glSeparableFilter2D"), target, internalformat, width, height, format, type, row, column);
  }

  public void glDeleteVertexArraysAPPLE(int n, MemorySegment arrays) {
    PFNGLDELETEVERTEXARRAYSAPPLEPROC.invoke(load("glDeleteVertexArraysAPPLE"), n, arrays);
  }

  public void glGetPathMetricsNV(int metricQueryMask, int numPaths, int pathNameType, MemorySegment paths, int pathBase, int stride, MemorySegment metrics) {
    PFNGLGETPATHMETRICSNVPROC.invoke(load("glGetPathMetricsNV"), metricQueryMask, numPaths, pathNameType, paths, pathBase, stride, metrics);
  }

  public void glProgramUniform3dEXT(int program, int location, double x, double y, double z) {
    PFNGLPROGRAMUNIFORM3DEXTPROC.invoke(load("glProgramUniform3dEXT"), program, location, x, y, z);
  }

  public void glProgramUniformMatrix4x3fv(int program, int location, int count, byte transpose, MemorySegment value) {
    PFNGLPROGRAMUNIFORMMATRIX4X3FVPROC.invoke(load("glProgramUniformMatrix4x3fv"), program, location, count, transpose, value);
  }

  public void glMultiTexCoord4s(int target, short s, short t, short r, short q) {
    PFNGLMULTITEXCOORD4SARBPROC.invoke(load("glMultiTexCoord4s"), target, s, t, r, q);
  }

  public void glDisableClientStateIndexedEXT(int array, int index) {
    PFNGLDISABLECLIENTSTATEINDEXEDEXTPROC.invoke(load("glDisableClientStateIndexedEXT"), array, index);
  }

  public void glGetMultiTexLevelParameterivEXT(int texunit, int target, int level, int pname, MemorySegment params) {
    PFNGLGETMULTITEXLEVELPARAMETERIVEXTPROC.invoke(load("glGetMultiTexLevelParameterivEXT"), texunit, target, level, pname, params);
  }

  public void glMultiTexCoord4x(int texture, int s, int t, int r, int q) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glPathGlyphsNV(int firstPathName, int fontTarget, MemorySegment fontName, int fontStyle, int numGlyphs, int type, MemorySegment charcodes, int handleMissingGlyphs, int pathParameterTemplate, float emScale) {
    PFNGLPATHGLYPHSNVPROC.invoke(load("glPathGlyphsNV"), firstPathName, fontTarget, fontName, fontStyle, numGlyphs, type, charcodes, handleMissingGlyphs, pathParameterTemplate, emScale);
  }

  public void glVertex3xOES(int x, int y) {
    PFNGLVERTEX3XOESPROC.invoke(load("glVertex3xOES"), x, y);
  }

  public void glNamedFramebufferDrawBuffers(int framebuffer, int n, MemorySegment bufs) {
    PFNGLNAMEDFRAMEBUFFERDRAWBUFFERSPROC.invoke(load("glNamedFramebufferDrawBuffers"), framebuffer, n, bufs);
  }

  public void glVertexAttribI4iEXT(int index, int x, int y, int z, int w) {
    PFNGLVERTEXATTRIBI4IEXTPROC.invoke(load("glVertexAttribI4iEXT"), index, x, y, z, w);
  }

  public void glMultiDrawElementsIndirectBindlessCountNV(int mode, int type, MemorySegment indirect, int drawCount, int maxDrawCount, int stride, int vertexBufferCount) {
    PFNGLMULTIDRAWELEMENTSINDIRECTBINDLESSCOUNTNVPROC.invoke(load("glMultiDrawElementsIndirectBindlessCountNV"), mode, type, indirect, drawCount, maxDrawCount, stride, vertexBufferCount);
  }

  public int glCreateProgramObjectARB() {
    return opengl.windows.PFNGLCREATEPROGRAMOBJECTARBPROC.invoke(load("glCreateProgramObjectARB"));
  }

  public void glBindBufferARB(int target, int buffer) {
    PFNGLBINDBUFFERARBPROC.invoke(load("glBindBufferARB"), target, buffer);
  }

  public void glMultiTexCoord4d(int target, double s, double t, double r, double q) {
    PFNGLMULTITEXCOORD4DARBPROC.invoke(load("glMultiTexCoord4d"), target, s, t, r, q);
  }

  public void glTextureParameterfEXT(int texture, int target, int pname, float param) {
    PFNGLTEXTUREPARAMETERFEXTPROC.invoke(load("glTextureParameterfEXT"), texture, target, pname, param);
  }

  public void glVertexAttrib3dv(int index, MemorySegment v) {
    PFNGLVERTEXATTRIB3DVPROC.invoke(load("glVertexAttrib3dv"), index, v);
  }

  public void glMultiTexCoord4i(int target, int s, int t, int r, int q) {
    PFNGLMULTITEXCOORD4IARBPROC.invoke(load("glMultiTexCoord4i"), target, s, t, r, q);
  }

  public void glDrawElementsBaseVertex(int mode, int count, int type, MemorySegment indices, int basevertex) {
    PFNGLDRAWELEMENTSBASEVERTEXPROC.invoke(load("glDrawElementsBaseVertex"), mode, count, type, indices, basevertex);
  }

  public void glMultiTexCoord4f(int target, float s, float t, float r, float q) {
    PFNGLMULTITEXCOORD4FARBPROC.invoke(load("glMultiTexCoord4f"), target, s, t, r, q);
  }

  public void glVertexAttribL4dv(int index, MemorySegment v) {
    PFNGLVERTEXATTRIBL4DVPROC.invoke(load("glVertexAttribL4dv"), index, v);
  }

  public void glUniform4fARB(int location, float v0, float v1, float v2, float v3) {
    PFNGLUNIFORM4FARBPROC.invoke(load("glUniform4fARB"), location, v0, v1, v2, v3);
  }

  public void glWindowPos2ivMESA(MemorySegment v) {
    PFNGLWINDOWPOS2IVMESAPROC.invoke(load("glWindowPos2ivMESA"), v);
  }

  public void glMultiTexCoord3s(int target, short s, short t, short r) {
    PFNGLMULTITEXCOORD3SARBPROC.invoke(load("glMultiTexCoord3s"), target, s, t, r);
  }

  public void glFlushMappedBufferRangeEXT(int target, long offset, long length) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetnPixelMapfv(int map, int bufSize, MemorySegment values) {
    PFNGLGETNPIXELMAPFVPROC.invoke(load("glGetnPixelMapfv"), map, bufSize, values);
  }

  public void glGetFogFuncSGIS(MemorySegment points) {
    PFNGLGETFOGFUNCSGISPROC.invoke(load("glGetFogFuncSGIS"), points);
  }

  public void glProgramUniform1ui(int program, int location, int v0) {
    PFNGLPROGRAMUNIFORM1UIPROC.invoke(load("glProgramUniform1ui"), program, location, v0);
  }

  public void glUniform3ivARB(int location, int count, MemorySegment value) {
    PFNGLUNIFORM3IVARBPROC.invoke(load("glUniform3ivARB"), location, count, value);
  }

  public void glMultiTexCoord3d(int target, double s, double t, double r) {
    PFNGLMULTITEXCOORD3DARBPROC.invoke(load("glMultiTexCoord3d"), target, s, t, r);
  }

  public void glDiscardFramebufferEXT(int target, int numAttachments, MemorySegment attachments) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexCoord3f(int target, float s, float t, float r) {
    PFNGLMULTITEXCOORD3FARBPROC.invoke(load("glMultiTexCoord3f"), target, s, t, r);
  }

  public void glProgramUniformMatrix4x3dv(int program, int location, int count, byte transpose, MemorySegment value) {
    PFNGLPROGRAMUNIFORMMATRIX4X3DVPROC.invoke(load("glProgramUniformMatrix4x3dv"), program, location, count, transpose, value);
  }

  public void glVertex3xvOES(MemorySegment coords) {
    PFNGLVERTEX3XVOESPROC.invoke(load("glVertex3xvOES"), coords);
  }

  public void glMultiTexCoord3i(int target, int s, int t, int r) {
    PFNGLMULTITEXCOORD3IARBPROC.invoke(load("glMultiTexCoord3i"), target, s, t, r);
  }

  public int glCreateShaderObjectARB(int shaderType) {
    return opengl.windows.PFNGLCREATESHADEROBJECTARBPROC.invoke(load("glCreateShaderObjectARB"), shaderType);
  }

  public void glMultiTexCoord2s(int target, short s, short t) {
    PFNGLMULTITEXCOORD2SARBPROC.invoke(load("glMultiTexCoord2s"), target, s, t);
  }

  public void glMapVertexAttrib2fAPPLE(int index, int size, float u1, float u2, int ustride, int uorder, float v1, float v2, int vstride, int vorder, MemorySegment points) {
    PFNGLMAPVERTEXATTRIB2FAPPLEPROC.invoke(load("glMapVertexAttrib2fAPPLE"), index, size, u1, u2, ustride, uorder, v1, v2, vstride, vorder, points);
  }

  public void glCullParameterdvEXT(int pname, MemorySegment params) {
    PFNGLCULLPARAMETERDVEXTPROC.invoke(load("glCullParameterdvEXT"), pname, params);
  }

  public void glVertexStream2sATI(int stream, short x, short y) {
    PFNGLVERTEXSTREAM2SATIPROC.invoke(load("glVertexStream2sATI"), stream, x, y);
  }

  public void glVertexAttrib4dv(int index, MemorySegment v) {
    PFNGLVERTEXATTRIB4DVPROC.invoke(load("glVertexAttrib4dv"), index, v);
  }

  public void glListParameterivSGIX(int list, int pname, MemorySegment params) {
    PFNGLLISTPARAMETERIVSGIXPROC.invoke(load("glListParameterivSGIX"), list, pname, params);
  }

  public void glRenderbufferStorage(int target, int internalformat, int width, int height) {
    PFNGLRENDERBUFFERSTORAGEPROC.invoke(load("glRenderbufferStorage"), target, internalformat, width, height);
  }

  public void glGetHistogramParameteriv(int target, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexArrayBindVertexBufferEXT(int vaobj, int bindingindex, int buffer, long offset, int stride) {
    PFNGLVERTEXARRAYBINDVERTEXBUFFEREXTPROC.invoke(load("glVertexArrayBindVertexBufferEXT"), vaobj, bindingindex, buffer, offset, stride);
  }

  public void glWindowPos4ivMESA(MemorySegment v) {
    PFNGLWINDOWPOS4IVMESAPROC.invoke(load("glWindowPos4ivMESA"), v);
  }

  public void glMultiTexCoord2iv(int target, MemorySegment v) {
    PFNGLMULTITEXCOORD2IVARBPROC.invoke(load("glMultiTexCoord2iv"), target, v);
  }

  public void glTextureStorageMem2DEXT(int texture, int levels, int internalFormat, int width, int height, int memory, long offset) {
    PFNGLTEXTURESTORAGEMEM2DEXTPROC.invoke(load("glTextureStorageMem2DEXT"), texture, levels, internalFormat, width, height, memory, offset);
  }

  public void glGetListParameterfvSGIX(int list, int pname, MemorySegment params) {
    PFNGLGETLISTPARAMETERFVSGIXPROC.invoke(load("glGetListParameterfvSGIX"), list, pname, params);
  }

  public void glPathStencilFuncNV(int func, int ref, int mask) {
    PFNGLPATHSTENCILFUNCNVPROC.invoke(load("glPathStencilFuncNV"), func, ref, mask);
  }

  public void glAlphaFragmentOp3ATI(int op, int dst, int dstMod, int arg1, int arg1Rep, int arg1Mod, int arg2, int arg2Rep, int arg2Mod, int arg3, int arg3Rep, int arg3Mod) {
    PFNGLALPHAFRAGMENTOP3ATIPROC.invoke(load("glAlphaFragmentOp3ATI"), op, dst, dstMod, arg1, arg1Rep, arg1Mod, arg2, arg2Rep, arg2Mod, arg3, arg3Rep, arg3Mod);
  }

  public void glProgramUniformHandleui64IMG(int program, int location, long value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glSampleCoveragex(int value, byte invert) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetInvariantBooleanvEXT(int id, int value, MemorySegment data) {
    PFNGLGETINVARIANTBOOLEANVEXTPROC.invoke(load("glGetInvariantBooleanvEXT"), id, value, data);
  }

  public void glGetMultiTexParameterIuivEXT(int texunit, int target, int pname, MemorySegment params) {
    PFNGLGETMULTITEXPARAMETERIUIVEXTPROC.invoke(load("glGetMultiTexParameterIuivEXT"), texunit, target, pname, params);
  }

  public void glGetInteger64v(int pname, MemorySegment data) {
    PFNGLGETINTEGER64VPROC.invoke(load("glGetInteger64v"), pname, data);
  }

  public void glSamplerParameterIivOES(int sampler, int pname, MemorySegment param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetTexParameterIuivEXT(int target, int pname, MemorySegment params) {
    PFNGLGETTEXPARAMETERIUIVEXTPROC.invoke(load("glGetTexParameterIuivEXT"), target, pname, params);
  }

  public void glWindowPos2fv(MemorySegment v) {
    PFNGLWINDOWPOS2FVPROC.invoke(load("glWindowPos2fv"), v);
  }

  public void glAlphaFuncQCOM(int func, float ref) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public int glFinishAsyncSGIX(MemorySegment markerp) {
    return PFNGLFINISHASYNCSGIXPROC.invoke(load("glFinishAsyncSGIX"), markerp);
  }

  public void glGetSynciv(MemorySegment sync, int pname, int count, MemorySegment length, MemorySegment values) {
    PFNGLGETSYNCIVPROC.invoke(load("glGetSynciv"), sync, pname, count, length, values);
  }

  public void glWindowPos3fMESA(float x, float y, float z) {
    PFNGLWINDOWPOS3FMESAPROC.invoke(load("glWindowPos3fMESA"), x, y, z);
  }

  public void glVertexArraySecondaryColorOffsetEXT(int vaobj, int buffer, int size, int type, int stride, long offset) {
    PFNGLVERTEXARRAYSECONDARYCOLOROFFSETEXTPROC.invoke(load("glVertexArraySecondaryColorOffsetEXT"), vaobj, buffer, size, type, stride, offset);
  }

  public void glVertexAttrib4bv(int index, MemorySegment v) {
    PFNGLVERTEXATTRIB4BVPROC.invoke(load("glVertexAttrib4bv"), index, v);
  }

  public void glProgramParameter4dvNV(int target, int index, MemorySegment v) {
    PFNGLPROGRAMPARAMETER4DVNVPROC.invoke(load("glProgramParameter4dvNV"), target, index, v);
  }

  public void glProgramNamedParameter4dNV(int id, int len, MemorySegment name, double x, double y, double z, double w) {
    PFNGLPROGRAMNAMEDPARAMETER4DNVPROC.invoke(load("glProgramNamedParameter4dNV"), id, len, name, x, y, z, w);
  }

  public void glMultiTexEnviEXT(int texunit, int target, int pname, int param) {
    PFNGLMULTITEXENVIEXTPROC.invoke(load("glMultiTexEnviEXT"), texunit, target, pname, param);
  }

  public void glVertexAttrib4sNV(int index, short x, short y, short z, short w) {
    PFNGLVERTEXATTRIB4SNVPROC.invoke(load("glVertexAttrib4sNV"), index, x, y, z, w);
  }

  public void glConservativeRasterParameterfNV(int pname, float value) {
    PFNGLCONSERVATIVERASTERPARAMETERFNVPROC.invoke(load("glConservativeRasterParameterfNV"), pname, value);
  }

  public void glBindImageTextureEXT(int index, int texture, int level, byte layered, int layer, int access, int format) {
    PFNGLBINDIMAGETEXTUREEXTPROC.invoke(load("glBindImageTextureEXT"), index, texture, level, layered, layer, access, format);
  }

  public void glVertexStream1fATI(int stream, float x) {
    PFNGLVERTEXSTREAM1FATIPROC.invoke(load("glVertexStream1fATI"), stream, x);
  }

  public void glExtGetProgramBinarySourceQCOM(int program, int shadertype, MemorySegment source, MemorySegment length) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glImportSemaphoreFdEXT(int semaphore, int handleType, int fd) {
    PFNGLIMPORTSEMAPHOREFDEXTPROC.invoke(load("glImportSemaphoreFdEXT"), semaphore, handleType, fd);
  }

  public void glGetHistogramParameterfv(int target, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGenBuffers(int n, MemorySegment buffers) {
    PFNGLGENBUFFERSPROC.invoke(load("glGenBuffers"), n, buffers);
  }

  public void glMultiDrawArraysIndirectBindlessNV(int mode, MemorySegment indirect, int drawCount, int stride, int vertexBufferCount) {
    PFNGLMULTIDRAWARRAYSINDIRECTBINDLESSNVPROC.invoke(load("glMultiDrawArraysIndirectBindlessNV"), mode, indirect, drawCount, stride, vertexBufferCount);
  }

  public void glMulticastGetQueryObjectuivNV(int gpu, int id, int pname, MemorySegment params) {
    PFNGLMULTICASTGETQUERYOBJECTUIVNVPROC.invoke(load("glMulticastGetQueryObjectuivNV"), gpu, id, pname, params);
  }

  public void glNamedRenderbufferStorageEXT(int renderbuffer, int internalformat, int width, int height) {
    PFNGLNAMEDRENDERBUFFERSTORAGEEXTPROC.invoke(load("glNamedRenderbufferStorageEXT"), renderbuffer, internalformat, width, height);
  }

  public void glReplacementCodeuiTexCoord2fColor4fNormal3fVertex3fSUN(int rc, float s, float t, float r, float g, float b, float a, float nx, float ny, float nz, float x, float y, float z) {
    PFNGLREPLACEMENTCODEUITEXCOORD2FCOLOR4FNORMAL3FVERTEX3FSUNPROC.invoke(load("glReplacementCodeuiTexCoord2fColor4fNormal3fVertex3fSUN"), rc, s, t, r, g, b, a, nx, ny, nz, x, y, z);
  }

  public void glVertexAttrib3dvNV(int index, MemorySegment v) {
    PFNGLVERTEXATTRIB3DVNVPROC.invoke(load("glVertexAttrib3dvNV"), index, v);
  }

  public void glWindowPos2dv(MemorySegment v) {
    PFNGLWINDOWPOS2DVPROC.invoke(load("glWindowPos2dv"), v);
  }

  public void glProgramUniform3ui64ARB(int program, int location, long x, long y, long z) {
    PFNGLPROGRAMUNIFORM3UI64ARBPROC.invoke(load("glProgramUniform3ui64ARB"), program, location, x, y, z);
  }

  public void glVertexAttribIFormatNV(int index, int size, int type, int stride) {
    PFNGLVERTEXATTRIBIFORMATNVPROC.invoke(load("glVertexAttribIFormatNV"), index, size, type, stride);
  }

  public void glCurrentPaletteMatrixOES(int matrixpaletteindex) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFramebufferTextureOES(int target, int attachment, int texture, int level) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexCoord4xvOES(int texture, MemorySegment coords) {
    PFNGLMULTITEXCOORD4XVOESPROC.invoke(load("glMultiTexCoord4xvOES"), texture, coords);
  }

  public int glCreateShaderProgramv(int type, int count, MemorySegment strings) {
    return PFNGLCREATESHADERPROGRAMVPROC.invoke(load("glCreateShaderProgramv"), type, count, strings);
  }

  public void glGetnSeparableFilterARB(int target, int format, int type, int rowBufSize, MemorySegment row, int columnBufSize, MemorySegment column, MemorySegment span) {
    PFNGLGETNSEPARABLEFILTERARBPROC.invoke(load("glGetnSeparableFilterARB"), target, format, type, rowBufSize, row, columnBufSize, column, span);
  }

  public void glProgramUniformMatrix4fv(int program, int location, int count, byte transpose, MemorySegment value) {
    PFNGLPROGRAMUNIFORMMATRIX4FVPROC.invoke(load("glProgramUniformMatrix4fv"), program, location, count, transpose, value);
  }

  public void glGetTransformFeedbackVarying(int program, int index, int bufSize, MemorySegment length, MemorySegment size, MemorySegment type, MemorySegment name) {
    PFNGLGETTRANSFORMFEEDBACKVARYINGPROC.invoke(load("glGetTransformFeedbackVarying"), program, index, bufSize, length, size, type, name);
  }

  public void glVertexAttrib4fvNV(int index, MemorySegment v) {
    PFNGLVERTEXATTRIB4FVNVPROC.invoke(load("glVertexAttrib4fvNV"), index, v);
  }

  public void glSubpixelPrecisionBiasNV(int xbits, int ybits) {
    PFNGLSUBPIXELPRECISIONBIASNVPROC.invoke(load("glSubpixelPrecisionBiasNV"), xbits, ybits);
  }

  public void glDrawBuffersATI(int n, MemorySegment bufs) {
    PFNGLDRAWBUFFERSATIPROC.invoke(load("glDrawBuffersATI"), n, bufs);
  }

  public void glFogxv(int pname, MemorySegment param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniform2uiEXT(int program, int location, int v0, int v1) {
    PFNGLPROGRAMUNIFORM2UIEXTPROC.invoke(load("glProgramUniform2uiEXT"), program, location, v0, v1);
  }

  public void glVertexAttribLFormat(int attribindex, int size, int type, int relativeoffset) {
    PFNGLVERTEXATTRIBLFORMATPROC.invoke(load("glVertexAttribLFormat"), attribindex, size, type, relativeoffset);
  }

  public void glDisableIndexedEXT(int target, int index) {
    PFNGLDISABLEINDEXEDEXTPROC.invoke(load("glDisableIndexedEXT"), target, index);
  }

  public int glGetDebugMessageLogKHR(int count, int bufSize, MemorySegment sources, MemorySegment types, MemorySegment ids, MemorySegment severities, MemorySegment lengths, MemorySegment messageLog) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttrib4dvARB(int index, MemorySegment v) {
    PFNGLVERTEXATTRIB4DVARBPROC.invoke(load("glVertexAttrib4dvARB"), index, v);
  }

  public void glTexImage4DSGIS(int target, int level, int internalformat, int width, int height, int depth, int size4d, int border, int format, int type, MemorySegment pixels) {
    PFNGLTEXIMAGE4DSGISPROC.invoke(load("glTexImage4DSGIS"), target, level, internalformat, width, height, depth, size4d, border, format, type, pixels);
  }

  public void glProgramUniformMatrix4dv(int program, int location, int count, byte transpose, MemorySegment value) {
    PFNGLPROGRAMUNIFORMMATRIX4DVPROC.invoke(load("glProgramUniformMatrix4dv"), program, location, count, transpose, value);
  }

  public void glDeleteTexturesEXT(int n, MemorySegment textures) {
    PFNGLDELETETEXTURESEXTPROC.invoke(load("glDeleteTexturesEXT"), n, textures);
  }

  public void glNamedFramebufferReadBuffer(int framebuffer, int src) {
    PFNGLNAMEDFRAMEBUFFERREADBUFFERPROC.invoke(load("glNamedFramebufferReadBuffer"), framebuffer, src);
  }

  public void glGetVideoCaptureivNV(int video_capture_slot, int pname, MemorySegment params) {
    PFNGLGETVIDEOCAPTUREIVNVPROC.invoke(load("glGetVideoCaptureivNV"), video_capture_slot, pname, params);
  }

  public void glNormalStream3dvATI(int stream, MemorySegment coords) {
    PFNGLNORMALSTREAM3DVATIPROC.invoke(load("glNormalStream3dvATI"), stream, coords);
  }

  public void glTangent3bvEXT(MemorySegment v) {
    PFNGLTANGENT3BVEXTPROC.invoke(load("glTangent3bvEXT"), v);
  }

  public void glWindowPos2iv(MemorySegment v) {
    PFNGLWINDOWPOS2IVPROC.invoke(load("glWindowPos2iv"), v);
  }

  public void glVertexArrayAttribLFormat(int vaobj, int attribindex, int size, int type, int relativeoffset) {
    PFNGLVERTEXARRAYATTRIBLFORMATPROC.invoke(load("glVertexArrayAttribLFormat"), vaobj, attribindex, size, type, relativeoffset);
  }

  public void glTexSubImage1DEXT(int target, int level, int xoffset, int width, int format, int type, MemorySegment pixels) {
    PFNGLTEXSUBIMAGE1DEXTPROC.invoke(load("glTexSubImage1DEXT"), target, level, xoffset, width, format, type, pixels);
  }

  public void glGetProgramSubroutineParameteruivNV(int target, int index, MemorySegment param) {
    PFNGLGETPROGRAMSUBROUTINEPARAMETERUIVNVPROC.invoke(load("glGetProgramSubroutineParameteruivNV"), target, index, param);
  }

  public void glTessellationFactorAMD(float factor) {
    PFNGLTESSELLATIONFACTORAMDPROC.invoke(load("glTessellationFactorAMD"), factor);
  }

  public void glDrawTexfvOES(MemorySegment coords) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBlendBarrierKHR() {
    PFNGLBLENDBARRIERKHRPROC.invoke(load("glBlendBarrierKHR"));
  }

  public void glDrawVkImageNV(long vkImage, int sampler, float x0, float y0, float x1, float y1, float z, float s0, float t0, float s1, float t1) {
    PFNGLDRAWVKIMAGENVPROC.invoke(load("glDrawVkImageNV"), vkImage, sampler, x0, y0, x1, y1, z, s0, t0, s1, t1);
  }

  public void glGetMinmaxParameterfv(int target, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribI3ui(int index, int x, int y, int z) {
    PFNGLVERTEXATTRIBI3UIPROC.invoke(load("glVertexAttribI3ui"), index, x, y, z);
  }

  public void glWindowPos3fvMESA(MemorySegment v) {
    PFNGLWINDOWPOS3FVMESAPROC.invoke(load("glWindowPos3fvMESA"), v);
  }

  public void glMulticastGetQueryObjectui64vNV(int gpu, int id, int pname, MemorySegment params) {
    PFNGLMULTICASTGETQUERYOBJECTUI64VNVPROC.invoke(load("glMulticastGetQueryObjectui64vNV"), gpu, id, pname, params);
  }

  public void glTextureBufferRangeEXT(int texture, int target, int internalformat, int buffer, long offset, long size) {
    PFNGLTEXTUREBUFFERRANGEEXTPROC.invoke(load("glTextureBufferRangeEXT"), texture, target, internalformat, buffer, offset, size);
  }

  public void glProgramBinaryOES(int program, int binaryFormat, MemorySegment binary, int length) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetLightxOES(int light, int pname, MemorySegment params) {
    PFNGLGETLIGHTXOESPROC.invoke(load("glGetLightxOES"), light, pname, params);
  }

  public void glEndConditionalRenderNV() {
    PFNGLENDCONDITIONALRENDERNVPROC.invoke(load("glEndConditionalRenderNV"));
  }

  public void glPatchParameteri(int pname, int value) {
    PFNGLPATCHPARAMETERIPROC.invoke(load("glPatchParameteri"), pname, value);
  }

  public void glMultiDrawElementsIndirectBindlessNV(int mode, int type, MemorySegment indirect, int drawCount, int stride, int vertexBufferCount) {
    PFNGLMULTIDRAWELEMENTSINDIRECTBINDLESSNVPROC.invoke(load("glMultiDrawElementsIndirectBindlessNV"), mode, type, indirect, drawCount, stride, vertexBufferCount);
  }

  public void glDeleteBuffersARB(int n, MemorySegment buffers) {
    PFNGLDELETEBUFFERSARBPROC.invoke(load("glDeleteBuffersARB"), n, buffers);
  }

  public void glVertexAttribL3ui64vNV(int index, MemorySegment v) {
    PFNGLVERTEXATTRIBL3UI64VNVPROC.invoke(load("glVertexAttribL3ui64vNV"), index, v);
  }

  public void glGetArrayObjectivATI(int array, int pname, MemorySegment params) {
    PFNGLGETARRAYOBJECTIVATIPROC.invoke(load("glGetArrayObjectivATI"), array, pname, params);
  }

  public void glBlendBarrierNV() {
    PFNGLBLENDBARRIERNVPROC.invoke(load("glBlendBarrierNV"));
  }

  public void glNormalStream3svATI(int stream, MemorySegment coords) {
    PFNGLNORMALSTREAM3SVATIPROC.invoke(load("glNormalStream3svATI"), stream, coords);
  }

  public void glTangent3dEXT(double tx, double ty, double tz) {
    PFNGLTANGENT3DEXTPROC.invoke(load("glTangent3dEXT"), tx, ty, tz);
  }

  public void glGetMinmaxParameteriv(int target, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVariantusvEXT(int id, MemorySegment addr) {
    PFNGLVARIANTUSVEXTPROC.invoke(load("glVariantusvEXT"), id, addr);
  }

  public void glLightxOES(int light, int pname, int param) {
    PFNGLLIGHTXOESPROC.invoke(load("glLightxOES"), light, pname, param);
  }

  public void glDepthBoundsEXT(double zmin, double zmax) {
    PFNGLDEPTHBOUNDSEXTPROC.invoke(load("glDepthBoundsEXT"), zmin, zmax);
  }

  public void glProgramUniform3uivEXT(int program, int location, int count, MemorySegment value) {
    PFNGLPROGRAMUNIFORM3UIVEXTPROC.invoke(load("glProgramUniform3uivEXT"), program, location, count, value);
  }

  public void glGetVertexArrayPointervEXT(int vaobj, int pname, MemorySegment param) {
    PFNGLGETVERTEXARRAYPOINTERVEXTPROC.invoke(load("glGetVertexArrayPointervEXT"), vaobj, pname, param);
  }

  public void glTexPageCommitmentARB(int target, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, byte commit) {
    PFNGLTEXPAGECOMMITMENTARBPROC.invoke(load("glTexPageCommitmentARB"), target, level, xoffset, yoffset, zoffset, width, height, depth, commit);
  }

  public void glCompileShaderARB(int shaderObj) {
    opengl.windows.PFNGLCOMPILESHADERARBPROC.invoke(load("glCompileShaderARB"), shaderObj);
  }

  public void glBinormal3sEXT(short bx, short by, short bz) {
    PFNGLBINORMAL3SEXTPROC.invoke(load("glBinormal3sEXT"), bx, by, bz);
  }

  public void glBeginVideoCaptureNV(int video_capture_slot) {
    PFNGLBEGINVIDEOCAPTURENVPROC.invoke(load("glBeginVideoCaptureNV"), video_capture_slot);
  }

  public void glCompressedMultiTexImage1DEXT(int texunit, int target, int level, int internalformat, int width, int border, int imageSize, MemorySegment bits) {
    PFNGLCOMPRESSEDMULTITEXIMAGE1DEXTPROC.invoke(load("glCompressedMultiTexImage1DEXT"), texunit, target, level, internalformat, width, border, imageSize, bits);
  }

  public void glClearNamedBufferSubDataEXT(int buffer, int internalformat, long offset, long size, int format, int type, MemorySegment data) {
    PFNGLCLEARNAMEDBUFFERSUBDATAEXTPROC.invoke(load("glClearNamedBufferSubDataEXT"), buffer, internalformat, offset, size, format, type, data);
  }

  public void glGetInvariantIntegervEXT(int id, int value, MemorySegment data) {
    PFNGLGETINVARIANTINTEGERVEXTPROC.invoke(load("glGetInvariantIntegervEXT"), id, value, data);
  }

  public void glCreateSemaphoresNV(int n, MemorySegment semaphores) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexCoord1bOES(int texture, byte s) {
    PFNGLMULTITEXCOORD1BOESPROC.invoke(load("glMultiTexCoord1bOES"), texture, s);
  }

  public void glConvolutionParameterxvOES(int target, int pname, MemorySegment params) {
    PFNGLCONVOLUTIONPARAMETERXVOESPROC.invoke(load("glConvolutionParameterxvOES"), target, pname, params);
  }

  public byte glIsTransformFeedbackNV(int id) {
    return PFNGLISTRANSFORMFEEDBACKNVPROC.invoke(load("glIsTransformFeedbackNV"), id);
  }

  public void glRectxOES(int x1, int y1, int x2, int y2) {
    PFNGLRECTXOESPROC.invoke(load("glRectxOES"), x1, y1, x2, y2);
  }

  public void glNormal3fVertex3fvSUN(MemorySegment n, MemorySegment v) {
    PFNGLNORMAL3FVERTEX3FVSUNPROC.invoke(load("glNormal3fVertex3fvSUN"), n, v);
  }

  public void glBindRenderbufferEXT(int target, int renderbuffer) {
    PFNGLBINDRENDERBUFFEREXTPROC.invoke(load("glBindRenderbufferEXT"), target, renderbuffer);
  }

  public void glFramebufferTextureFaceEXT(int target, int attachment, int texture, int level, int face) {
    PFNGLFRAMEBUFFERTEXTUREFACEEXTPROC.invoke(load("glFramebufferTextureFaceEXT"), target, attachment, texture, level, face);
  }

  public void glGetMaterialxOES(int face, int pname, int param) {
    PFNGLGETMATERIALXOESPROC.invoke(load("glGetMaterialxOES"), face, pname, param);
  }

  public void glMultiTexCoord1xOES(int texture, int s) {
    PFNGLMULTITEXCOORD1XOESPROC.invoke(load("glMultiTexCoord1xOES"), texture, s);
  }

  public void glViewportIndexedfv(int index, MemorySegment v) {
    PFNGLVIEWPORTINDEXEDFVPROC.invoke(load("glViewportIndexedfv"), index, v);
  }

  public void glDrawArraysInstancedARB(int mode, int first, int count, int primcount) {
    PFNGLDRAWARRAYSINSTANCEDARBPROC.invoke(load("glDrawArraysInstancedARB"), mode, first, count, primcount);
  }

  public void glProgramParameters4dvNV(int target, int index, int count, MemorySegment v) {
    PFNGLPROGRAMPARAMETERS4DVNVPROC.invoke(load("glProgramParameters4dvNV"), target, index, count, v);
  }

  public void glBlendEquationSeparatei(int buf, int modeRGB, int modeAlpha) {
    PFNGLBLENDEQUATIONSEPARATEIPROC.invoke(load("glBlendEquationSeparatei"), buf, modeRGB, modeAlpha);
  }

  public void glGetNamedBufferSubData(int buffer, long offset, long size, MemorySegment data) {
    PFNGLGETNAMEDBUFFERSUBDATAPROC.invoke(load("glGetNamedBufferSubData"), buffer, offset, size, data);
  }

  public void glTransformFeedbackStreamAttribsNV(int count, MemorySegment attribs, int nbuffers, MemorySegment bufstreams, int bufferMode) {
    PFNGLTRANSFORMFEEDBACKSTREAMATTRIBSNVPROC.invoke(load("glTransformFeedbackStreamAttribsNV"), count, attribs, nbuffers, bufstreams, bufferMode);
  }

  public void glProgramUniformMatrix2fvEXT(int program, int location, int count, byte transpose, MemorySegment value) {
    PFNGLPROGRAMUNIFORMMATRIX2FVEXTPROC.invoke(load("glProgramUniformMatrix2fvEXT"), program, location, count, transpose, value);
  }

  public void glPushGroupMarkerEXT(int length, MemorySegment marker) {
    PFNGLPUSHGROUPMARKEREXTPROC.invoke(load("glPushGroupMarkerEXT"), length, marker);
  }

  public void glFramebufferFetchBarrierQCOM() {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glPixelTexGenParameterfSGIS(int pname, float param) {
    PFNGLPIXELTEXGENPARAMETERFSGISPROC.invoke(load("glPixelTexGenParameterfSGIS"), pname, param);
  }

  public void glProgramEnvParameter4dvARB(int target, int index, MemorySegment params) {
    PFNGLPROGRAMENVPARAMETER4DVARBPROC.invoke(load("glProgramEnvParameter4dvARB"), target, index, params);
  }

  public void glGetnMapdvARB(int target, int query, int bufSize, MemorySegment v) {
    PFNGLGETNMAPDVARBPROC.invoke(load("glGetnMapdvARB"), target, query, bufSize, v);
  }

  public void glTangentPointerEXT(int type, int stride, MemorySegment pointer) {
    PFNGLTANGENTPOINTEREXTPROC.invoke(load("glTangentPointerEXT"), type, stride, pointer);
  }

  public void glProgramUniform1fv(int program, int location, int count, MemorySegment value) {
    PFNGLPROGRAMUNIFORM1FVPROC.invoke(load("glProgramUniform1fv"), program, location, count, value);
  }

  public void glMatrixMultdEXT(int mode, MemorySegment m) {
    PFNGLMATRIXMULTDEXTPROC.invoke(load("glMatrixMultdEXT"), mode, m);
  }

  public void glDrawArraysInstancedANGLE(int mode, int first, int count, int primcount) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glNamedProgramLocalParameter4dvEXT(int program, int target, int index, MemorySegment params) {
    PFNGLNAMEDPROGRAMLOCALPARAMETER4DVEXTPROC.invoke(load("glNamedProgramLocalParameter4dvEXT"), program, target, index, params);
  }

  public void glCompressedTexImage3DARB(int target, int level, int internalformat, int width, int height, int depth, int border, int imageSize, MemorySegment data) {
    PFNGLCOMPRESSEDTEXIMAGE3DARBPROC.invoke(load("glCompressedTexImage3DARB"), target, level, internalformat, width, height, depth, border, imageSize, data);
  }

  public void glMultiTexCoord2dv(int target, MemorySegment v) {
    PFNGLMULTITEXCOORD2DVARBPROC.invoke(load("glMultiTexCoord2dv"), target, v);
  }

  public void glStencilStrokePathInstancedNV(int numPaths, int pathNameType, MemorySegment paths, int pathBase, int reference, int mask, int transformType, MemorySegment transformValues) {
    PFNGLSTENCILSTROKEPATHINSTANCEDNVPROC.invoke(load("glStencilStrokePathInstancedNV"), numPaths, pathNameType, paths, pathBase, reference, mask, transformType, transformValues);
  }

  public void glGetVertexArrayPointeri_vEXT(int vaobj, int index, int pname, MemorySegment param) {
    PFNGLGETVERTEXARRAYPOINTERI_VEXTPROC.invoke(load("glGetVertexArrayPointeri_vEXT"), vaobj, index, pname, param);
  }

  public void glNormal3hNV(short nx, short ny, short nz) {
    PFNGLNORMAL3HNVPROC.invoke(load("glNormal3hNV"), nx, ny, nz);
  }

  public void glPopGroupMarkerEXT() {
    PFNGLPOPGROUPMARKEREXTPROC.invoke(load("glPopGroupMarkerEXT"));
  }

  public int glGetProgramResourceLocation(int program, int programInterface, MemorySegment name) {
    return PFNGLGETPROGRAMRESOURCELOCATIONPROC.invoke(load("glGetProgramResourceLocation"), program, programInterface, name);
  }

  public void glMultiTexCoord2dvARB(int target, MemorySegment v) {
    PFNGLMULTITEXCOORD2DVARBPROC.invoke(load("glMultiTexCoord2dvARB"), target, v);
  }

  public void glWindowPos2ivARB(MemorySegment v) {
    PFNGLWINDOWPOS2IVARBPROC.invoke(load("glWindowPos2ivARB"), v);
  }

  public void glGetHistogram(int target, byte reset, int format, int type, MemorySegment values) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribL2dEXT(int index, double x, double y) {
    PFNGLVERTEXATTRIBL2DEXTPROC.invoke(load("glVertexAttribL2dEXT"), index, x, y);
  }

  public void glBlendFunciOES(int buf, int src, int dst) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniform1dv(int program, int location, int count, MemorySegment value) {
    PFNGLPROGRAMUNIFORM1DVPROC.invoke(load("glProgramUniform1dv"), program, location, count, value);
  }

  public void glVertex3hNV(short x, short y, short z) {
    PFNGLVERTEX3HNVPROC.invoke(load("glVertex3hNV"), x, y, z);
  }

  public void glRasterPos3xOES(int x, int y, int z) {
    PFNGLRASTERPOS3XOESPROC.invoke(load("glRasterPos3xOES"), x, y, z);
  }

  public void glGetHistogramParameterxvOES(int target, int pname, MemorySegment params) {
    PFNGLGETHISTOGRAMPARAMETERXVOESPROC.invoke(load("glGetHistogramParameterxvOES"), target, pname, params);
  }

  public void glMultiTexCoord2fv(int target, MemorySegment v) {
    PFNGLMULTITEXCOORD2FVARBPROC.invoke(load("glMultiTexCoord2fv"), target, v);
  }

  public void glProgramUniform4ui64NV(int program, int location, long x, long y, long z, long w) {
    PFNGLPROGRAMUNIFORM4UI64NVPROC.invoke(load("glProgramUniform4ui64NV"), program, location, x, y, z, w);
  }

  public void glVertexArrayVertexAttribLFormatEXT(int vaobj, int attribindex, int size, int type, int relativeoffset) {
    PFNGLVERTEXARRAYVERTEXATTRIBLFORMATEXTPROC.invoke(load("glVertexArrayVertexAttribLFormatEXT"), vaobj, attribindex, size, type, relativeoffset);
  }

  public void glLockArraysEXT(int first, int count) {
    PFNGLLOCKARRAYSEXTPROC.invoke(load("glLockArraysEXT"), first, count);
  }

  public void glEdgeFlagPointerEXT(int stride, int count, MemorySegment pointer) {
    PFNGLEDGEFLAGPOINTEREXTPROC.invoke(load("glEdgeFlagPointerEXT"), stride, count, pointer);
  }

  public void glEndQueryARB(int target) {
    PFNGLENDQUERYARBPROC.invoke(load("glEndQueryARB"), target);
  }

  public void glNamedFramebufferTextureFaceEXT(int framebuffer, int attachment, int texture, int level, int face) {
    PFNGLNAMEDFRAMEBUFFERTEXTUREFACEEXTPROC.invoke(load("glNamedFramebufferTextureFaceEXT"), framebuffer, attachment, texture, level, face);
  }

  public void glVertexAttribPointerARB(int index, int size, int type, byte normalized, int stride, MemorySegment pointer) {
    PFNGLVERTEXATTRIBPOINTERARBPROC.invoke(load("glVertexAttribPointerARB"), index, size, type, normalized, stride, pointer);
  }

  public void glSecondaryColor3svEXT(MemorySegment v) {
    PFNGLSECONDARYCOLOR3SVEXTPROC.invoke(load("glSecondaryColor3svEXT"), v);
  }

  public void glFogxvOES(int pname, MemorySegment param) {
    PFNGLFOGXVOESPROC.invoke(load("glFogxvOES"), pname, param);
  }

  public void glDrawRangeElementsBaseVertex(int mode, int start, int end, int count, int type, MemorySegment indices, int basevertex) {
    PFNGLDRAWRANGEELEMENTSBASEVERTEXPROC.invoke(load("glDrawRangeElementsBaseVertex"), mode, start, end, count, type, indices, basevertex);
  }

  public int glGetGraphicsResetStatusEXT() {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBeginTransformFeedback(int primitiveMode) {
    PFNGLBEGINTRANSFORMFEEDBACKPROC.invoke(load("glBeginTransformFeedback"), primitiveMode);
  }

  public void glObjectPtrLabel(MemorySegment ptr, int length, MemorySegment label) {
    PFNGLOBJECTPTRLABELPROC.invoke(load("glObjectPtrLabel"), ptr, length, label);
  }

  public void glUploadGpuMaskNVX(int mask) {
    PFNGLUPLOADGPUMASKNVXPROC.invoke(load("glUploadGpuMaskNVX"), mask);
  }

  public void glGetFinalCombinerInputParameterfvNV(int variable, int pname, MemorySegment params) {
    PFNGLGETFINALCOMBINERINPUTPARAMETERFVNVPROC.invoke(load("glGetFinalCombinerInputParameterfvNV"), variable, pname, params);
  }

  public void glUnlockArraysEXT() {
    PFNGLUNLOCKARRAYSEXTPROC.invoke(load("glUnlockArraysEXT"));
  }

  public void glGetTexParameterIiv(int target, int pname, MemorySegment params) {
    PFNGLGETTEXPARAMETERIIVPROC.invoke(load("glGetTexParameterIiv"), target, pname, params);
  }

  public void glVertexArrayMultiTexCoordOffsetEXT(int vaobj, int buffer, int texunit, int size, int type, int stride, long offset) {
    PFNGLVERTEXARRAYMULTITEXCOORDOFFSETEXTPROC.invoke(load("glVertexArrayMultiTexCoordOffsetEXT"), vaobj, buffer, texunit, size, type, stride, offset);
  }

  public void glMultiTexCoord1hNV(int target, short s) {
    PFNGLMULTITEXCOORD1HNVPROC.invoke(load("glMultiTexCoord1hNV"), target, s);
  }

  public void glVertexAttrib4Nub(int index, byte x, byte y, byte z, byte w) {
    PFNGLVERTEXATTRIB4NUBPROC.invoke(load("glVertexAttrib4Nub"), index, x, y, z, w);
  }

  public void glProgramLocalParameterI4ivNV(int target, int index, MemorySegment params) {
    PFNGLPROGRAMLOCALPARAMETERI4IVNVPROC.invoke(load("glProgramLocalParameterI4ivNV"), target, index, params);
  }

  public void glSetInvariantEXT(int id, int type, MemorySegment addr) {
    PFNGLSETINVARIANTEXTPROC.invoke(load("glSetInvariantEXT"), id, type, addr);
  }

  public byte glIsQuery(int id) {
    return PFNGLISQUERYPROC.invoke(load("glIsQuery"), id);
  }

  public void glFogCoordPointerEXT(int type, int stride, MemorySegment pointer) {
    PFNGLFOGCOORDPOINTEREXTPROC.invoke(load("glFogCoordPointerEXT"), type, stride, pointer);
  }

  public void glProgramBufferParametersfvNV(int target, int bindingIndex, int wordIndex, int count, MemorySegment params) {
    PFNGLPROGRAMBUFFERPARAMETERSFVNVPROC.invoke(load("glProgramBufferParametersfvNV"), target, bindingIndex, wordIndex, count, params);
  }

  public void glCombinerParameterivNV(int pname, MemorySegment params) {
    PFNGLCOMBINERPARAMETERIVNVPROC.invoke(load("glCombinerParameterivNV"), pname, params);
  }

  public void glGetnUniformfv(int program, int location, int bufSize, MemorySegment params) {
    PFNGLGETNUNIFORMFVPROC.invoke(load("glGetnUniformfv"), program, location, bufSize, params);
  }

  public void glPathParameterfNV(int path, int pname, float value) {
    PFNGLPATHPARAMETERFNVPROC.invoke(load("glPathParameterfNV"), path, pname, value);
  }

  public void glVertexAttrib4Nsv(int index, MemorySegment v) {
    PFNGLVERTEXATTRIB4NSVPROC.invoke(load("glVertexAttrib4Nsv"), index, v);
  }

  public void glProgramUniform4i64vARB(int program, int location, int count, MemorySegment value) {
    PFNGLPROGRAMUNIFORM4I64VARBPROC.invoke(load("glProgramUniform4i64vARB"), program, location, count, value);
  }

  public void glMakeNamedBufferResidentNV(int buffer, int access) {
    PFNGLMAKENAMEDBUFFERRESIDENTNVPROC.invoke(load("glMakeNamedBufferResidentNV"), buffer, access);
  }

  public void glInvalidateNamedFramebufferSubData(int framebuffer, int numAttachments, MemorySegment attachments, int x, int y, int width, int height) {
    PFNGLINVALIDATENAMEDFRAMEBUFFERSUBDATAPROC.invoke(load("glInvalidateNamedFramebufferSubData"), framebuffer, numAttachments, attachments, x, y, width, height);
  }

  public void glColorPointerListIBM(int size, int type, int stride, MemorySegment pointer, int ptrstride) {
    PFNGLCOLORPOINTERLISTIBMPROC.invoke(load("glColorPointerListIBM"), size, type, stride, pointer, ptrstride);
  }

  public byte glIsCommandListNV(int list) {
    return PFNGLISCOMMANDLISTNVPROC.invoke(load("glIsCommandListNV"), list);
  }

  public void glEdgeFlagFormatNV(int stride) {
    PFNGLEDGEFLAGFORMATNVPROC.invoke(load("glEdgeFlagFormatNV"), stride);
  }

  public void glGetColorTableParameterfvSGI(int target, int pname, MemorySegment params) {
    PFNGLGETCOLORTABLEPARAMETERFVSGIPROC.invoke(load("glGetColorTableParameterfvSGI"), target, pname, params);
  }

  public void glGetTransformFeedbacki_v(int xfb, int pname, int index, MemorySegment param) {
    PFNGLGETTRANSFORMFEEDBACKI_VPROC.invoke(load("glGetTransformFeedbacki_v"), xfb, pname, index, param);
  }

  public void glScissorArrayv(int first, int count, MemorySegment v) {
    PFNGLSCISSORARRAYVPROC.invoke(load("glScissorArrayv"), first, count, v);
  }

  public void glStartInstrumentsSGIX() {
    PFNGLSTARTINSTRUMENTSSGIXPROC.invoke(load("glStartInstrumentsSGIX"));
  }

  public void glReplacementCodeubvSUN(MemorySegment code) {
    PFNGLREPLACEMENTCODEUBVSUNPROC.invoke(load("glReplacementCodeubvSUN"), code);
  }

  public void glMultiTexCoord2svARB(int target, MemorySegment v) {
    PFNGLMULTITEXCOORD2SVARBPROC.invoke(load("glMultiTexCoord2svARB"), target, v);
  }

  public void glMultiDrawElementsIndirectCount(int mode, int type, MemorySegment indirect, long drawcount, int maxdrawcount, int stride) {
    PFNGLMULTIDRAWELEMENTSINDIRECTCOUNTPROC.invoke(load("glMultiDrawElementsIndirectCount"), mode, type, indirect, drawcount, maxdrawcount, stride);
  }

  public void glNormalStream3sATI(int stream, short nx, short ny, short nz) {
    PFNGLNORMALSTREAM3SATIPROC.invoke(load("glNormalStream3sATI"), stream, nx, ny, nz);
  }

  public void glMatrixIndexubvARB(int size, MemorySegment indices) {
    PFNGLMATRIXINDEXUBVARBPROC.invoke(load("glMatrixIndexubvARB"), size, indices);
  }

  public void glGenerateTextureMipmapEXT(int texture, int target) {
    PFNGLGENERATETEXTUREMIPMAPEXTPROC.invoke(load("glGenerateTextureMipmapEXT"), texture, target);
  }

  public void glDebugMessageEnableAMD(int category, int severity, int count, MemorySegment ids, byte enabled) {
    PFNGLDEBUGMESSAGEENABLEAMDPROC.invoke(load("glDebugMessageEnableAMD"), category, severity, count, ids, enabled);
  }

  public void glPointParameterfvSGIS(int pname, MemorySegment params) {
    PFNGLPOINTPARAMETERFVSGISPROC.invoke(load("glPointParameterfvSGIS"), pname, params);
  }

  public void glIndexxOES(int component) {
    PFNGLINDEXXOESPROC.invoke(load("glIndexxOES"), component);
  }

  public int glGetUniformLocation(int program, MemorySegment name) {
    return PFNGLGETUNIFORMLOCATIONPROC.invoke(load("glGetUniformLocation"), program, name);
  }

  public void glPrimitiveBoundingBox(float minX, float minY, float minZ, float minW, float maxX, float maxY, float maxZ, float maxW) {
    PFNGLPRIMITIVEBOUNDINGBOXARBPROC.invoke(load("glPrimitiveBoundingBox"), minX, minY, minZ, minW, maxX, maxY, maxZ, maxW);
  }

  public void glCopyTexSubImage1DEXT(int target, int level, int xoffset, int x, int y, int width) {
    PFNGLCOPYTEXSUBIMAGE1DEXTPROC.invoke(load("glCopyTexSubImage1DEXT"), target, level, xoffset, x, y, width);
  }

  public void glVertexStream4dATI(int stream, double x, double y, double z, double w) {
    PFNGLVERTEXSTREAM4DATIPROC.invoke(load("glVertexStream4dATI"), stream, x, y, z, w);
  }

  public void glSpriteParameterfvSGIX(int pname, MemorySegment params) {
    PFNGLSPRITEPARAMETERFVSGIXPROC.invoke(load("glSpriteParameterfvSGIX"), pname, params);
  }

  public void glGlobalAlphaFactoriSUN(int factor) {
    PFNGLGLOBALALPHAFACTORISUNPROC.invoke(load("glGlobalAlphaFactoriSUN"), factor);
  }

  public void glConvolutionParameterxOES(int target, int pname, int param) {
    PFNGLCONVOLUTIONPARAMETERXOESPROC.invoke(load("glConvolutionParameterxOES"), target, pname, param);
  }

  public void glMultiTexCoord3xvOES(int texture, MemorySegment coords) {
    PFNGLMULTITEXCOORD3XVOESPROC.invoke(load("glMultiTexCoord3xvOES"), texture, coords);
  }

  public void glBlendParameteriNV(int pname, int value) {
    PFNGLBLENDPARAMETERINVPROC.invoke(load("glBlendParameteriNV"), pname, value);
  }

  public void glGetMultisamplefv(int pname, int index, MemorySegment val) {
    PFNGLGETMULTISAMPLEFVPROC.invoke(load("glGetMultisamplefv"), pname, index, val);
  }

  public byte glIsQueryARB(int id) {
    return PFNGLISQUERYARBPROC.invoke(load("glIsQueryARB"), id);
  }

  public void glGetInternalformativ(int target, int internalformat, int pname, int count, MemorySegment params) {
    PFNGLGETINTERNALFORMATIVPROC.invoke(load("glGetInternalformativ"), target, internalformat, pname, count, params);
  }

  public void glDepthRangeArrayfvNV(int first, int count, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBufferSubData(int target, long offset, long size, MemorySegment data) {
    PFNGLBUFFERSUBDATAPROC.invoke(load("glBufferSubData"), target, offset, size, data);
  }

  public void glRenderbufferStorageMultisampleNV(int target, int samples, int internalformat, int width, int height) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetSyncivAPPLE(MemorySegment sync, int pname, int count, MemorySegment length, MemorySegment values) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttrib4ubvNV(int index, MemorySegment v) {
    PFNGLVERTEXATTRIB4UBVNVPROC.invoke(load("glVertexAttrib4ubvNV"), index, v);
  }

  public int glBindTextureUnitParameterEXT(int unit, int value) {
    return PFNGLBINDTEXTUREUNITPARAMETEREXTPROC.invoke(load("glBindTextureUnitParameterEXT"), unit, value);
  }

  public void glVertexWeightfvEXT(MemorySegment weight) {
    PFNGLVERTEXWEIGHTFVEXTPROC.invoke(load("glVertexWeightfvEXT"), weight);
  }

  public void glTextureParameteriEXT(int texture, int target, int pname, int param) {
    PFNGLTEXTUREPARAMETERIEXTPROC.invoke(load("glTextureParameteriEXT"), texture, target, pname, param);
  }

  public int glCreateShaderProgramEXT(int type, MemorySegment string) {
    return PFNGLCREATESHADERPROGRAMEXTPROC.invoke(load("glCreateShaderProgramEXT"), type, string);
  }

  public void glClearDepthf(float d) {
    PFNGLCLEARDEPTHFPROC.invoke(load("glClearDepthf"), d);
  }

  public void glTextureImage2DMultisampleNV(int texture, int target, int samples, int internalFormat, int width, int height, byte fixedSampleLocations) {
    PFNGLTEXTUREIMAGE2DMULTISAMPLENVPROC.invoke(load("glTextureImage2DMultisampleNV"), texture, target, samples, internalFormat, width, height, fixedSampleLocations);
  }

  public void glDisableVertexAttribArray(int index) {
    PFNGLDISABLEVERTEXATTRIBARRAYPROC.invoke(load("glDisableVertexAttribArray"), index);
  }

  public void glGetDoubleIndexedvEXT(int target, int index, MemorySegment data) {
    PFNGLGETDOUBLEINDEXEDVEXTPROC.invoke(load("glGetDoubleIndexedvEXT"), target, index, data);
  }

  public void glProgramUniform4iEXT(int program, int location, int v0, int v1, int v2, int v3) {
    PFNGLPROGRAMUNIFORM4IEXTPROC.invoke(load("glProgramUniform4iEXT"), program, location, v0, v1, v2, v3);
  }

  public void glClearDepthx(int depth) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTextureBarrier() {
    PFNGLTEXTUREBARRIERPROC.invoke(load("glTextureBarrier"));
  }

  public void glNamedStringARB(int type, int namelen, MemorySegment name, int stringlen, MemorySegment string) {
    PFNGLNAMEDSTRINGARBPROC.invoke(load("glNamedStringARB"), type, namelen, name, stringlen, string);
  }

  public void glTexCoord1xvOES(MemorySegment coords) {
    PFNGLTEXCOORD1XVOESPROC.invoke(load("glTexCoord1xvOES"), coords);
  }

  public void glGetUniformfvARB(int programObj, int location, MemorySegment params) {
    opengl.windows.PFNGLGETUNIFORMFVARBPROC.invoke(load("glGetUniformfvARB"), programObj, location, params);
  }

  public void glTexCoordPointervINTEL(int size, int type, MemorySegment pointer) {
    PFNGLTEXCOORDPOINTERVINTELPROC.invoke(load("glTexCoordPointervINTEL"), size, type, pointer);
  }

  public void glVertexArrayVertexAttribFormatEXT(int vaobj, int attribindex, int size, int type, byte normalized, int relativeoffset) {
    PFNGLVERTEXARRAYVERTEXATTRIBFORMATEXTPROC.invoke(load("glVertexArrayVertexAttribFormatEXT"), vaobj, attribindex, size, type, normalized, relativeoffset);
  }

  public void glTexCoord2fColor3fVertex3fvSUN(MemorySegment tc, MemorySegment c, MemorySegment v) {
    PFNGLTEXCOORD2FCOLOR3FVERTEX3FVSUNPROC.invoke(load("glTexCoord2fColor3fVertex3fvSUN"), tc, c, v);
  }

  public void glGetVariantArrayObjectfvATI(int id, int pname, MemorySegment params) {
    PFNGLGETVARIANTARRAYOBJECTFVATIPROC.invoke(load("glGetVariantArrayObjectfvATI"), id, pname, params);
  }

  public void glProgramUniform4fvEXT(int program, int location, int count, MemorySegment value) {
    PFNGLPROGRAMUNIFORM4FVEXTPROC.invoke(load("glProgramUniform4fvEXT"), program, location, count, value);
  }

  public void glProgramUniform2i64vNV(int program, int location, int count, MemorySegment value) {
    PFNGLPROGRAMUNIFORM2I64VNVPROC.invoke(load("glProgramUniform2i64vNV"), program, location, count, value);
  }

  public void glMultiTexCoordP4ui(int texture, int type, int coords) {
    PFNGLMULTITEXCOORDP4UIPROC.invoke(load("glMultiTexCoordP4ui"), texture, type, coords);
  }

  public void glGetnUniformdv(int program, int location, int bufSize, MemorySegment params) {
    PFNGLGETNUNIFORMDVPROC.invoke(load("glGetnUniformdv"), program, location, bufSize, params);
  }

  public void glInvalidateTexImage(int texture, int level) {
    PFNGLINVALIDATETEXIMAGEPROC.invoke(load("glInvalidateTexImage"), texture, level);
  }

  public byte glIsRenderbufferEXT(int renderbuffer) {
    return PFNGLISRENDERBUFFEREXTPROC.invoke(load("glIsRenderbufferEXT"), renderbuffer);
  }

  public void glProgramUniform3uiEXT(int program, int location, int v0, int v1, int v2) {
    PFNGLPROGRAMUNIFORM3UIEXTPROC.invoke(load("glProgramUniform3uiEXT"), program, location, v0, v1, v2);
  }

  public void glDeleteNamedStringARB(int namelen, MemorySegment name) {
    PFNGLDELETENAMEDSTRINGARBPROC.invoke(load("glDeleteNamedStringARB"), namelen, name);
  }

  public void glReplacementCodeuiTexCoord2fNormal3fVertex3fvSUN(MemorySegment rc, MemorySegment tc, MemorySegment n, MemorySegment v) {
    PFNGLREPLACEMENTCODEUITEXCOORD2FNORMAL3FVERTEX3FVSUNPROC.invoke(load("glReplacementCodeuiTexCoord2fNormal3fVertex3fvSUN"), rc, tc, n, v);
  }

  public void glBindTextures(int first, int count, MemorySegment textures) {
    PFNGLBINDTEXTURESPROC.invoke(load("glBindTextures"), first, count, textures);
  }

  public void glEndQuery(int target) {
    PFNGLENDQUERYPROC.invoke(load("glEndQuery"), target);
  }

  public void glNamedFramebufferSampleLocationsfvNV(int framebuffer, int start, int count, MemorySegment v) {
    PFNGLNAMEDFRAMEBUFFERSAMPLELOCATIONSFVNVPROC.invoke(load("glNamedFramebufferSampleLocationsfvNV"), framebuffer, start, count, v);
  }

  public void glProgramUniform1i64vARB(int program, int location, int count, MemorySegment value) {
    PFNGLPROGRAMUNIFORM1I64VARBPROC.invoke(load("glProgramUniform1i64vARB"), program, location, count, value);
  }

  public void glBlitFramebuffer(int srcX0, int srcY0, int srcX1, int srcY1, int dstX0, int dstY0, int dstX1, int dstY1, int mask, int filter) {
    PFNGLBLITFRAMEBUFFERPROC.invoke(load("glBlitFramebuffer"), srcX0, srcY0, srcX1, srcY1, dstX0, dstY0, dstX1, dstY1, mask, filter);
  }

  public void glStencilThenCoverFillPathInstancedNV(int numPaths, int pathNameType, MemorySegment paths, int pathBase, int fillMode, int mask, int coverMode, int transformType, MemorySegment transformValues) {
    PFNGLSTENCILTHENCOVERFILLPATHINSTANCEDNVPROC.invoke(load("glStencilThenCoverFillPathInstancedNV"), numPaths, pathNameType, paths, pathBase, fillMode, mask, coverMode, transformType, transformValues);
  }

  public void glUniformSubroutinesuiv(int shadertype, int count, MemorySegment indices) {
    PFNGLUNIFORMSUBROUTINESUIVPROC.invoke(load("glUniformSubroutinesuiv"), shadertype, count, indices);
  }

  public void glIndexPointerListIBM(int type, int stride, MemorySegment pointer, int ptrstride) {
    PFNGLINDEXPOINTERLISTIBMPROC.invoke(load("glIndexPointerListIBM"), type, stride, pointer, ptrstride);
  }

  public void glVertexStream4dvATI(int stream, MemorySegment coords) {
    PFNGLVERTEXSTREAM4DVATIPROC.invoke(load("glVertexStream4dvATI"), stream, coords);
  }

  public void glUniform3ui64ARB(int location, long x, long y, long z) {
    PFNGLUNIFORM3UI64ARBPROC.invoke(load("glUniform3ui64ARB"), location, x, y, z);
  }

  public void glVertexArrayVertexAttribLOffsetEXT(int vaobj, int buffer, int index, int size, int type, int stride, long offset) {
    PFNGLVERTEXARRAYVERTEXATTRIBLOFFSETEXTPROC.invoke(load("glVertexArrayVertexAttribLOffsetEXT"), vaobj, buffer, index, size, type, stride, offset);
  }

  public void glValidateProgramARB(int programObj) {
    opengl.windows.PFNGLVALIDATEPROGRAMARBPROC.invoke(load("glValidateProgramARB"), programObj);
  }

  public void glBeginVertexShaderEXT() {
    PFNGLBEGINVERTEXSHADEREXTPROC.invoke(load("glBeginVertexShaderEXT"));
  }

  public void glBlendFuncSeparateIndexedAMD(int buf, int srcRGB, int dstRGB, int srcAlpha, int dstAlpha) {
    PFNGLBLENDFUNCSEPARATEINDEXEDAMDPROC.invoke(load("glBlendFuncSeparateIndexedAMD"), buf, srcRGB, dstRGB, srcAlpha, dstAlpha);
  }

  public void glGetnTexImageARB(int target, int level, int format, int type, int bufSize, MemorySegment img) {
    PFNGLGETNTEXIMAGEARBPROC.invoke(load("glGetnTexImageARB"), target, level, format, type, bufSize, img);
  }

  public void glTexCoord1hNV(short s) {
    PFNGLTEXCOORD1HNVPROC.invoke(load("glTexCoord1hNV"), s);
  }

  public int glGetAttribLocationARB(int programObj, MemorySegment name) {
    return opengl.windows.PFNGLGETATTRIBLOCATIONARBPROC.invoke(load("glGetAttribLocationARB"), programObj, name);
  }

  public void glMemoryBarrierEXT(int barriers) {
    PFNGLMEMORYBARRIEREXTPROC.invoke(load("glMemoryBarrierEXT"), barriers);
  }

  public void glGetNamedBufferSubDataEXT(int buffer, long offset, long size, MemorySegment data) {
    PFNGLGETNAMEDBUFFERSUBDATAEXTPROC.invoke(load("glGetNamedBufferSubDataEXT"), buffer, offset, size, data);
  }

  public void glEnableClientStateIndexedEXT(int array, int index) {
    PFNGLENABLECLIENTSTATEINDEXEDEXTPROC.invoke(load("glEnableClientStateIndexedEXT"), array, index);
  }

  public void glScissorIndexedv(int index, MemorySegment v) {
    PFNGLSCISSORINDEXEDVPROC.invoke(load("glScissorIndexedv"), index, v);
  }

  public void glWindowPos2fvARB(MemorySegment v) {
    PFNGLWINDOWPOS2FVARBPROC.invoke(load("glWindowPos2fvARB"), v);
  }

  public void glCoverageModulationTableNV(int n, MemorySegment v) {
    PFNGLCOVERAGEMODULATIONTABLENVPROC.invoke(load("glCoverageModulationTableNV"), n, v);
  }

  public void glTexStorageMem1DEXT(int target, int levels, int internalFormat, int width, int memory, long offset) {
    PFNGLTEXSTORAGEMEM1DEXTPROC.invoke(load("glTexStorageMem1DEXT"), target, levels, internalFormat, width, memory, offset);
  }

  public void glFramebufferShadingRateEXT(int target, int attachment, int texture, int baseLayer, int numLayers, int texelWidth, int texelHeight) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttrib3fNV(int index, float x, float y, float z) {
    PFNGLVERTEXATTRIB3FNVPROC.invoke(load("glVertexAttrib3fNV"), index, x, y, z);
  }

  public void glWindowPos4svMESA(MemorySegment v) {
    PFNGLWINDOWPOS4SVMESAPROC.invoke(load("glWindowPos4svMESA"), v);
  }

  public void glMultiTexCoordP2uiv(int texture, int type, MemorySegment coords) {
    PFNGLMULTITEXCOORDP2UIVPROC.invoke(load("glMultiTexCoordP2uiv"), texture, type, coords);
  }

  public void glCompressedTextureSubImage2DEXT(int texture, int target, int level, int xoffset, int yoffset, int width, int height, int format, int imageSize, MemorySegment bits) {
    PFNGLCOMPRESSEDTEXTURESUBIMAGE2DEXTPROC.invoke(load("glCompressedTextureSubImage2DEXT"), texture, target, level, xoffset, yoffset, width, height, format, imageSize, bits);
  }

  public void glTextureStorage3DMultisample(int texture, int samples, int internalformat, int width, int height, int depth, byte fixedsamplelocations) {
    PFNGLTEXTURESTORAGE3DMULTISAMPLEPROC.invoke(load("glTextureStorage3DMultisample"), texture, samples, internalformat, width, height, depth, fixedsamplelocations);
  }

  public void glVertexAttribDivisorARB(int index, int divisor) {
    PFNGLVERTEXATTRIBDIVISORARBPROC.invoke(load("glVertexAttribDivisorARB"), index, divisor);
  }

  public void glShadingRateImagePaletteNV(int viewport, int first, int count, MemorySegment rates) {
    PFNGLSHADINGRATEIMAGEPALETTENVPROC.invoke(load("glShadingRateImagePaletteNV"), viewport, first, count, rates);
  }

  public void glTextureStorage2DEXT(int texture, int target, int levels, int internalformat, int width, int height) {
    PFNGLTEXTURESTORAGE2DEXTPROC.invoke(load("glTextureStorage2DEXT"), texture, target, levels, internalformat, width, height);
  }

  public void glObjectPtrLabelKHR(MemorySegment ptr, int length, MemorySegment label) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public byte glIsImageHandleResidentARB(long handle) {
    return PFNGLISIMAGEHANDLERESIDENTARBPROC.invoke(load("glIsImageHandleResidentARB"), handle);
  }

  public void glPresentFrameKeyedNV(int video_slot, long minPresentTime, int beginPresentTimeId, int presentDurationId, int type, int target0, int fill0, int key0, int target1, int fill1, int key1) {
    PFNGLPRESENTFRAMEKEYEDNVPROC.invoke(load("glPresentFrameKeyedNV"), video_slot, minPresentTime, beginPresentTimeId, presentDurationId, type, target0, fill0, key0, target1, fill1, key1);
  }

  public void glLoadTransposeMatrixfARB(MemorySegment m) {
    PFNGLLOADTRANSPOSEMATRIXFARBPROC.invoke(load("glLoadTransposeMatrixfARB"), m);
  }

  public void glGetNamedBufferParameterivEXT(int buffer, int pname, MemorySegment params) {
    PFNGLGETNAMEDBUFFERPARAMETERIVEXTPROC.invoke(load("glGetNamedBufferParameterivEXT"), buffer, pname, params);
  }

  public void glMultiDrawArraysIndirectCountARB(int mode, MemorySegment indirect, long drawcount, int maxdrawcount, int stride) {
    PFNGLMULTIDRAWARRAYSINDIRECTCOUNTARBPROC.invoke(load("glMultiDrawArraysIndirectCountARB"), mode, indirect, drawcount, maxdrawcount, stride);
  }

  public void glDisableiOES(int target, int index) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexCoord1fARB(int target, float s) {
    PFNGLMULTITEXCOORD1FARBPROC.invoke(load("glMultiTexCoord1fARB"), target, s);
  }

  public void glScissorArrayvNV(int first, int count, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glWeightivARB(int size, MemorySegment weights) {
    PFNGLWEIGHTIVARBPROC.invoke(load("glWeightivARB"), size, weights);
  }

  public void glGetNamedBufferParameterui64vNV(int buffer, int pname, MemorySegment params) {
    PFNGLGETNAMEDBUFFERPARAMETERUI64VNVPROC.invoke(load("glGetNamedBufferParameterui64vNV"), buffer, pname, params);
  }

  public void glTextureImage2DEXT(int texture, int target, int level, int internalformat, int width, int height, int border, int format, int type, MemorySegment pixels) {
    PFNGLTEXTUREIMAGE2DEXTPROC.invoke(load("glTextureImage2DEXT"), texture, target, level, internalformat, width, height, border, format, type, pixels);
  }

  public int glCheckFramebufferStatusEXT(int target) {
    return PFNGLCHECKFRAMEBUFFERSTATUSEXTPROC.invoke(load("glCheckFramebufferStatusEXT"), target);
  }

  public void glBeginConditionalRender(int id, int mode) {
    PFNGLBEGINCONDITIONALRENDERPROC.invoke(load("glBeginConditionalRender"), id, mode);
  }

  public void glBlendEquation(int mode) {
    PFNGLBLENDEQUATIONPROC.invoke(load("glBlendEquation"), mode);
  }

  public void glGenerateMipmap(int target) {
    PFNGLGENERATEMIPMAPPROC.invoke(load("glGenerateMipmap"), target);
  }

  public void glVertexAttribDivisor(int index, int divisor) {
    PFNGLVERTEXATTRIBDIVISORPROC.invoke(load("glVertexAttribDivisor"), index, divisor);
  }

  public void glTexStorage2DMultisample(int target, int samples, int internalformat, int width, int height, byte fixedsamplelocations) {
    PFNGLTEXSTORAGE2DMULTISAMPLEPROC.invoke(load("glTexStorage2DMultisample"), target, samples, internalformat, width, height, fixedsamplelocations);
  }

  public void glGetVertexArrayIndexediv(int vaobj, int index, int pname, MemorySegment param) {
    PFNGLGETVERTEXARRAYINDEXEDIVPROC.invoke(load("glGetVertexArrayIndexediv"), vaobj, index, pname, param);
  }

  public void glVertexStream1iATI(int stream, int x) {
    PFNGLVERTEXSTREAM1IATIPROC.invoke(load("glVertexStream1iATI"), stream, x);
  }

  public void glGetUniformui64vNV(int program, int location, MemorySegment params) {
    PFNGLGETUNIFORMUI64VNVPROC.invoke(load("glGetUniformui64vNV"), program, location, params);
  }

  public void glPathParameterivNV(int path, int pname, MemorySegment value) {
    PFNGLPATHPARAMETERIVNVPROC.invoke(load("glPathParameterivNV"), path, pname, value);
  }

  public void glUniformMatrix4x2dv(int location, int count, byte transpose, MemorySegment value) {
    PFNGLUNIFORMMATRIX4X2DVPROC.invoke(load("glUniformMatrix4x2dv"), location, count, transpose, value);
  }

  public void glGetPerfCounterInfoINTEL(int queryId, int counterId, int counterNameLength, MemorySegment counterName, int counterDescLength, MemorySegment counterDesc, MemorySegment counterOffset, MemorySegment counterDataSize, MemorySegment counterTypeEnum, MemorySegment counterDataTypeEnum, MemorySegment rawCounterMaxValue) {
    PFNGLGETPERFCOUNTERINFOINTELPROC.invoke(load("glGetPerfCounterInfoINTEL"), queryId, counterId, counterNameLength, counterName, counterDescLength, counterDesc, counterOffset, counterDataSize, counterTypeEnum, counterDataTypeEnum, rawCounterMaxValue);
  }

  public int glGetHandleARB(int pname) {
    return opengl.windows.PFNGLGETHANDLEARBPROC.invoke(load("glGetHandleARB"), pname);
  }

  public void glGetSeparableFilterEXT(int target, int format, int type, MemorySegment row, MemorySegment column, MemorySegment span) {
    PFNGLGETSEPARABLEFILTEREXTPROC.invoke(load("glGetSeparableFilterEXT"), target, format, type, row, column, span);
  }

  public MemorySegment glMapObjectBufferATI(int buffer) {
    return PFNGLMAPOBJECTBUFFERATIPROC.invoke(load("glMapObjectBufferATI"), buffer);
  }

  public void glProgramPathFragmentInputGenNV(int program, int location, int genMode, int components, MemorySegment coeffs) {
    PFNGLPROGRAMPATHFRAGMENTINPUTGENNVPROC.invoke(load("glProgramPathFragmentInputGenNV"), program, location, genMode, components, coeffs);
  }

  public void glLineWidthxOES(int width) {
    PFNGLLINEWIDTHXOESPROC.invoke(load("glLineWidthxOES"), width);
  }

  public void glTexCoordP2uiv(int type, MemorySegment coords) {
    PFNGLTEXCOORDP2UIVPROC.invoke(load("glTexCoordP2uiv"), type, coords);
  }

  public void glMultiDrawElementArrayAPPLE(int mode, MemorySegment first, MemorySegment count, int primcount) {
    PFNGLMULTIDRAWELEMENTARRAYAPPLEPROC.invoke(load("glMultiDrawElementArrayAPPLE"), mode, first, count, primcount);
  }

  public void glVertexAttrib2fv(int index, MemorySegment v) {
    PFNGLVERTEXATTRIB2FVPROC.invoke(load("glVertexAttrib2fv"), index, v);
  }

  public void glValidateProgramPipelineEXT(int pipeline) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glSecondaryColorPointerEXT(int size, int type, int stride, MemorySegment pointer) {
    PFNGLSECONDARYCOLORPOINTEREXTPROC.invoke(load("glSecondaryColorPointerEXT"), size, type, stride, pointer);
  }

  public void glVertexAttrib4usvARB(int index, MemorySegment v) {
    PFNGLVERTEXATTRIB4USVARBPROC.invoke(load("glVertexAttrib4usvARB"), index, v);
  }

  public void glWindowPos4fMESA(float x, float y, float z, float w) {
    PFNGLWINDOWPOS4FMESAPROC.invoke(load("glWindowPos4fMESA"), x, y, z, w);
  }

  public void glSamplerParameterIivEXT(int sampler, int pname, MemorySegment param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetProgramLocalParameterfvARB(int target, int index, MemorySegment params) {
    PFNGLGETPROGRAMLOCALPARAMETERFVARBPROC.invoke(load("glGetProgramLocalParameterfvARB"), target, index, params);
  }

  public void glGetVertexAttribivARB(int index, int pname, MemorySegment params) {
    PFNGLGETVERTEXATTRIBIVARBPROC.invoke(load("glGetVertexAttribivARB"), index, pname, params);
  }

  public void glExtGetRenderbuffersQCOM(MemorySegment renderbuffers, int maxRenderbuffers, MemorySegment numRenderbuffers) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttrib2dv(int index, MemorySegment v) {
    PFNGLVERTEXATTRIB2DVPROC.invoke(load("glVertexAttrib2dv"), index, v);
  }

  public void glVertexAttribL3dv(int index, MemorySegment v) {
    PFNGLVERTEXATTRIBL3DVPROC.invoke(load("glVertexAttribL3dv"), index, v);
  }

  public void glUniformMatrix4x2fv(int location, int count, byte transpose, MemorySegment value) {
    PFNGLUNIFORMMATRIX4X2FVPROC.invoke(load("glUniformMatrix4x2fv"), location, count, transpose, value);
  }

  public void glMultiTexCoord2sARB(int target, short s, short t) {
    PFNGLMULTITEXCOORD2SARBPROC.invoke(load("glMultiTexCoord2sARB"), target, s, t);
  }

  public void glGetActiveVaryingNV(int program, int index, int bufSize, MemorySegment length, MemorySegment size, MemorySegment type, MemorySegment name) {
    PFNGLGETACTIVEVARYINGNVPROC.invoke(load("glGetActiveVaryingNV"), program, index, bufSize, length, size, type, name);
  }

  public void glMultiDrawArrays(int mode, MemorySegment first, MemorySegment count, int drawcount) {
    PFNGLMULTIDRAWARRAYSPROC.invoke(load("glMultiDrawArrays"), mode, first, count, drawcount);
  }

  public void glRotatex(int angle, int x, int y, int z) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public int glGetAttribLocation(int program, MemorySegment name) {
    return PFNGLGETATTRIBLOCATIONPROC.invoke(load("glGetAttribLocation"), program, name);
  }

  public void glVertexArrayTexCoordOffsetEXT(int vaobj, int buffer, int size, int type, int stride, long offset) {
    PFNGLVERTEXARRAYTEXCOORDOFFSETEXTPROC.invoke(load("glVertexArrayTexCoordOffsetEXT"), vaobj, buffer, size, type, stride, offset);
  }

  public void glVertexAttribs1dvNV(int index, int count, MemorySegment v) {
    PFNGLVERTEXATTRIBS1DVNVPROC.invoke(load("glVertexAttribs1dvNV"), index, count, v);
  }

  public void glWindowPos2sv(MemorySegment v) {
    PFNGLWINDOWPOS2SVPROC.invoke(load("glWindowPos2sv"), v);
  }

  public int glCreateShader(int type) {
    return PFNGLCREATESHADERPROC.invoke(load("glCreateShader"), type);
  }

  public void glProgramUniformMatrix4x2dv(int program, int location, int count, byte transpose, MemorySegment value) {
    PFNGLPROGRAMUNIFORMMATRIX4X2DVPROC.invoke(load("glProgramUniformMatrix4x2dv"), program, location, count, transpose, value);
  }

  public void glTexCoord1bOES(byte s) {
    PFNGLTEXCOORD1BOESPROC.invoke(load("glTexCoord1bOES"), s);
  }

  public void glTexGenfvOES(int coord, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiDrawArraysIndirect(int mode, MemorySegment indirect, int drawcount, int stride) {
    PFNGLMULTIDRAWARRAYSINDIRECTPROC.invoke(load("glMultiDrawArraysIndirect"), mode, indirect, drawcount, stride);
  }

  public void glDeleteProgramsARB(int n, MemorySegment programs) {
    PFNGLDELETEPROGRAMSARBPROC.invoke(load("glDeleteProgramsARB"), n, programs);
  }

  public void glMatrixIndexPointerOES(int size, int type, int stride, MemorySegment pointer) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramLocalParameter4fARB(int target, int index, float x, float y, float z, float w) {
    PFNGLPROGRAMLOCALPARAMETER4FARBPROC.invoke(load("glProgramLocalParameter4fARB"), target, index, x, y, z, w);
  }

  public void glUniformMatrix2dv(int location, int count, byte transpose, MemorySegment value) {
    PFNGLUNIFORMMATRIX2DVPROC.invoke(load("glUniformMatrix2dv"), location, count, transpose, value);
  }

  public void glMapParameterfvNV(int target, int pname, MemorySegment params) {
    PFNGLMAPPARAMETERFVNVPROC.invoke(load("glMapParameterfvNV"), target, pname, params);
  }

  public byte glIsNameAMD(int identifier, int name) {
    return PFNGLISNAMEAMDPROC.invoke(load("glIsNameAMD"), identifier, name);
  }

  public void glMultTransposeMatrixxOES(MemorySegment m) {
    PFNGLMULTTRANSPOSEMATRIXXOESPROC.invoke(load("glMultTransposeMatrixxOES"), m);
  }

  public void glWindowPos2i(int x, int y) {
    PFNGLWINDOWPOS2IPROC.invoke(load("glWindowPos2i"), x, y);
  }

  public void glVertexAttribI2iv(int index, MemorySegment v) {
    PFNGLVERTEXATTRIBI2IVPROC.invoke(load("glVertexAttribI2iv"), index, v);
  }

  public void glWindowPos2f(float x, float y) {
    PFNGLWINDOWPOS2FPROC.invoke(load("glWindowPos2f"), x, y);
  }

  public void glWindowPos2d(double x, double y) {
    PFNGLWINDOWPOS2DPROC.invoke(load("glWindowPos2d"), x, y);
  }

  public void glGetNamedFramebufferParameteriv(int framebuffer, int pname, MemorySegment param) {
    PFNGLGETNAMEDFRAMEBUFFERPARAMETERIVPROC.invoke(load("glGetNamedFramebufferParameteriv"), framebuffer, pname, param);
  }

  public void glMultiDrawArraysIndirectAMD(int mode, MemorySegment indirect, int primcount, int stride) {
    PFNGLMULTIDRAWARRAYSINDIRECTAMDPROC.invoke(load("glMultiDrawArraysIndirectAMD"), mode, indirect, primcount, stride);
  }

  public void glCopyConvolutionFilter1DEXT(int target, int internalformat, int x, int y, int width) {
    PFNGLCOPYCONVOLUTIONFILTER1DEXTPROC.invoke(load("glCopyConvolutionFilter1DEXT"), target, internalformat, x, y, width);
  }

  public void glTexParameterxOES(int target, int pname, int param) {
    PFNGLTEXPARAMETERXOESPROC.invoke(load("glTexParameterxOES"), target, pname, param);
  }

  public void glGetTrackMatrixivNV(int target, int address, int pname, MemorySegment params) {
    PFNGLGETTRACKMATRIXIVNVPROC.invoke(load("glGetTrackMatrixivNV"), target, address, pname, params);
  }

  public void glWindowPos3s(short x, short y, short z) {
    PFNGLWINDOWPOS3SPROC.invoke(load("glWindowPos3s"), x, y, z);
  }

  public void glGetActiveAttrib(int program, int index, int bufSize, MemorySegment length, MemorySegment size, MemorySegment type, MemorySegment name) {
    PFNGLGETACTIVEATTRIBPROC.invoke(load("glGetActiveAttrib"), program, index, bufSize, length, size, type, name);
  }

  public void glProgramUniformMatrix4dvEXT(int program, int location, int count, byte transpose, MemorySegment value) {
    PFNGLPROGRAMUNIFORMMATRIX4DVEXTPROC.invoke(load("glProgramUniformMatrix4dvEXT"), program, location, count, transpose, value);
  }

  public void glClearColorIiEXT(int red, int green, int blue, int alpha) {
    PFNGLCLEARCOLORIIEXTPROC.invoke(load("glClearColorIiEXT"), red, green, blue, alpha);
  }

  public void glWindowPos3i(int x, int y, int z) {
    PFNGLWINDOWPOS3IPROC.invoke(load("glWindowPos3i"), x, y, z);
  }

  public void glWindowPos3f(float x, float y, float z) {
    PFNGLWINDOWPOS3FPROC.invoke(load("glWindowPos3f"), x, y, z);
  }

  public void glColor3hNV(short red, short green, short blue) {
    PFNGLCOLOR3HNVPROC.invoke(load("glColor3hNV"), red, green, blue);
  }

  public void glWindowPos3d(double x, double y, double z) {
    PFNGLWINDOWPOS3DPROC.invoke(load("glWindowPos3d"), x, y, z);
  }

  public void glBlitFramebufferANGLE(int srcX0, int srcY0, int srcX1, int srcY1, int dstX0, int dstY0, int dstX1, int dstY1, int mask, int filter) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetTexParameterIuivOES(int target, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMatrixTranslatefEXT(int mode, float x, float y, float z) {
    PFNGLMATRIXTRANSLATEFEXTPROC.invoke(load("glMatrixTranslatefEXT"), mode, x, y, z);
  }

  public void glUniformMatrix2fv(int location, int count, byte transpose, MemorySegment value) {
    PFNGLUNIFORMMATRIX2FVPROC.invoke(load("glUniformMatrix2fv"), location, count, transpose, value);
  }

  public void glMultiTexCoord1dvARB(int target, MemorySegment v) {
    PFNGLMULTITEXCOORD1DVARBPROC.invoke(load("glMultiTexCoord1dvARB"), target, v);
  }

  public void glQueryCounter(int id, int target) {
    PFNGLQUERYCOUNTERPROC.invoke(load("glQueryCounter"), id, target);
  }

  public void glColorTableSGI(int target, int internalformat, int width, int format, int type, MemorySegment table) {
    PFNGLCOLORTABLESGIPROC.invoke(load("glColorTableSGI"), target, internalformat, width, format, type, table);
  }

  public void glGetVertexAttribIiv(int index, int pname, MemorySegment params) {
    PFNGLGETVERTEXATTRIBIIVPROC.invoke(load("glGetVertexAttribIiv"), index, pname, params);
  }

  public void glCopyMultiTexImage1DEXT(int texunit, int target, int level, int internalformat, int x, int y, int width, int border) {
    PFNGLCOPYMULTITEXIMAGE1DEXTPROC.invoke(load("glCopyMultiTexImage1DEXT"), texunit, target, level, internalformat, x, y, width, border);
  }

  public void glColorPointerEXT(int size, int type, int stride, int count, MemorySegment pointer) {
    PFNGLCOLORPOINTEREXTPROC.invoke(load("glColorPointerEXT"), size, type, stride, count, pointer);
  }

  public void glPointParameterfvEXT(int pname, MemorySegment params) {
    PFNGLPOINTPARAMETERFVEXTPROC.invoke(load("glPointParameterfvEXT"), pname, params);
  }

  public void glTexCoord1xOES(int s) {
    PFNGLTEXCOORD1XOESPROC.invoke(load("glTexCoord1xOES"), s);
  }

  public void glWindowPos2s(short x, short y) {
    PFNGLWINDOWPOS2SPROC.invoke(load("glWindowPos2s"), x, y);
  }

  public void glProgramUniformui64NV(int program, int location, long value) {
    PFNGLPROGRAMUNIFORMUI64NVPROC.invoke(load("glProgramUniformui64NV"), program, location, value);
  }

  public void glShaderSource(int shader, int count, MemorySegment string, MemorySegment length) {
    PFNGLSHADERSOURCEPROC.invoke(load("glShaderSource"), shader, count, string, length);
  }

  public void glBindBufferRangeNV(int target, int index, int buffer, long offset, long size) {
    PFNGLBINDBUFFERRANGENVPROC.invoke(load("glBindBufferRangeNV"), target, index, buffer, offset, size);
  }

  public void glClearNamedFramebufferfv(int framebuffer, int buffer, int drawbuffer, MemorySegment value) {
    PFNGLCLEARNAMEDFRAMEBUFFERFVPROC.invoke(load("glClearNamedFramebufferfv"), framebuffer, buffer, drawbuffer, value);
  }

  public void glDrawTextureNV(int texture, int sampler, float x0, float y0, float x1, float y1, float z, float s0, float t0, float s1, float t1) {
    PFNGLDRAWTEXTURENVPROC.invoke(load("glDrawTextureNV"), texture, sampler, x0, y0, x1, y1, z, s0, t0, s1, t1);
  }

  public void glFramebufferFoveationParametersQCOM(int framebuffer, int layer, int focalPoint, float focalX, float focalY, float gainX, float gainY, float foveaArea) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBindVideoCaptureStreamBufferNV(int video_capture_slot, int stream, int frame_region, long offset) {
    PFNGLBINDVIDEOCAPTURESTREAMBUFFERNVPROC.invoke(load("glBindVideoCaptureStreamBufferNV"), video_capture_slot, stream, frame_region, offset);
  }

  public void glTextureStorage2D(int texture, int levels, int internalformat, int width, int height) {
    PFNGLTEXTURESTORAGE2DPROC.invoke(load("glTextureStorage2D"), texture, levels, internalformat, width, height);
  }

  public void glTexStorageMem2DMultisampleEXT(int target, int samples, int internalFormat, int width, int height, byte fixedSampleLocations, int memory, long offset) {
    PFNGLTEXSTORAGEMEM2DMULTISAMPLEEXTPROC.invoke(load("glTexStorageMem2DMultisampleEXT"), target, samples, internalFormat, width, height, fixedSampleLocations, memory, offset);
  }

  public void glFlushStaticDataIBM(int target) {
    PFNGLFLUSHSTATICDATAIBMPROC.invoke(load("glFlushStaticDataIBM"), target);
  }

  public void glTangent3ivEXT(MemorySegment v) {
    PFNGLTANGENT3IVEXTPROC.invoke(load("glTangent3ivEXT"), v);
  }

  public void glWindowPos3iv(MemorySegment v) {
    PFNGLWINDOWPOS3IVPROC.invoke(load("glWindowPos3iv"), v);
  }

  public void glGetProgramStringNV(int id, int pname, MemorySegment program) {
    PFNGLGETPROGRAMSTRINGNVPROC.invoke(load("glGetProgramStringNV"), id, pname, program);
  }

  public void glGetQueryObjectuivEXT(int id, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttrib4f(int index, float x, float y, float z, float w) {
    PFNGLVERTEXATTRIB4FPROC.invoke(load("glVertexAttrib4f"), index, x, y, z, w);
  }

  public void glTextureStorage1D(int texture, int levels, int internalformat, int width) {
    PFNGLTEXTURESTORAGE1DPROC.invoke(load("glTextureStorage1D"), texture, levels, internalformat, width);
  }

  public void glVertexAttrib4d(int index, double x, double y, double z, double w) {
    PFNGLVERTEXATTRIB4DPROC.invoke(load("glVertexAttrib4d"), index, x, y, z, w);
  }

  public void glGetVertexAttribdv(int index, int pname, MemorySegment params) {
    PFNGLGETVERTEXATTRIBDVPROC.invoke(load("glGetVertexAttribdv"), index, pname, params);
  }

  public void glEvaluateDepthValuesARB() {
    PFNGLEVALUATEDEPTHVALUESARBPROC.invoke(load("glEvaluateDepthValuesARB"));
  }

  public void glTextureViewEXT(int texture, int target, int origtexture, int internalformat, int minlevel, int numlevels, int minlayer, int numlayers) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glPathParameterfvNV(int path, int pname, MemorySegment value) {
    PFNGLPATHPARAMETERFVNVPROC.invoke(load("glPathParameterfvNV"), path, pname, value);
  }

  public void glBindFragDataLocationEXT(int program, int color, MemorySegment name) {
    PFNGLBINDFRAGDATALOCATIONEXTPROC.invoke(load("glBindFragDataLocationEXT"), program, color, name);
  }

  public void glVertexAttrib4s(int index, short x, short y, short z, short w) {
    PFNGLVERTEXATTRIB4SPROC.invoke(load("glVertexAttrib4s"), index, x, y, z, w);
  }

  public void glBeginTransformFeedbackEXT(int primitiveMode) {
    PFNGLBEGINTRANSFORMFEEDBACKEXTPROC.invoke(load("glBeginTransformFeedbackEXT"), primitiveMode);
  }

  public void glSetFenceAPPLE(int fence) {
    PFNGLSETFENCEAPPLEPROC.invoke(load("glSetFenceAPPLE"), fence);
  }

  public void glFreeObjectBufferATI(int buffer) {
    PFNGLFREEOBJECTBUFFERATIPROC.invoke(load("glFreeObjectBufferATI"), buffer);
  }

  public void glBlendColorEXT(float red, float green, float blue, float alpha) {
    PFNGLBLENDCOLOREXTPROC.invoke(load("glBlendColorEXT"), red, green, blue, alpha);
  }

  public byte glIsImageHandleResidentNV(long handle) {
    return PFNGLISIMAGEHANDLERESIDENTNVPROC.invoke(load("glIsImageHandleResidentNV"), handle);
  }

  public void glVertexP3uiv(int type, MemorySegment value) {
    PFNGLVERTEXP3UIVPROC.invoke(load("glVertexP3uiv"), type, value);
  }

  public void glFramebufferTextureEXT(int target, int attachment, int texture, int level) {
    PFNGLFRAMEBUFFERTEXTUREEXTPROC.invoke(load("glFramebufferTextureEXT"), target, attachment, texture, level);
  }

  public void glUniform3fvARB(int location, int count, MemorySegment value) {
    PFNGLUNIFORM3FVARBPROC.invoke(load("glUniform3fvARB"), location, count, value);
  }

  public void glMultiTexCoord1iv(int target, MemorySegment v) {
    PFNGLMULTITEXCOORD1IVARBPROC.invoke(load("glMultiTexCoord1iv"), target, v);
  }

  public void glColorFragmentOp3ATI(int op, int dst, int dstMask, int dstMod, int arg1, int arg1Rep, int arg1Mod, int arg2, int arg2Rep, int arg2Mod, int arg3, int arg3Rep, int arg3Mod) {
    PFNGLCOLORFRAGMENTOP3ATIPROC.invoke(load("glColorFragmentOp3ATI"), op, dst, dstMask, dstMod, arg1, arg1Rep, arg1Mod, arg2, arg2Rep, arg2Mod, arg3, arg3Rep, arg3Mod);
  }

  public void glProgramBufferParametersIivNV(int target, int bindingIndex, int wordIndex, int count, MemorySegment params) {
    PFNGLPROGRAMBUFFERPARAMETERSIIVNVPROC.invoke(load("glProgramBufferParametersIivNV"), target, bindingIndex, wordIndex, count, params);
  }

  public void glBlendColor(float red, float green, float blue, float alpha) {
    PFNGLBLENDCOLORPROC.invoke(load("glBlendColor"), red, green, blue, alpha);
  }

  public void glStencilThenCoverStrokePathNV(int path, int reference, int mask, int coverMode) {
    PFNGLSTENCILTHENCOVERSTROKEPATHNVPROC.invoke(load("glStencilThenCoverStrokePathNV"), path, reference, mask, coverMode);
  }

  public void glVertexAttribL4dvEXT(int index, MemorySegment v) {
    PFNGLVERTEXATTRIBL4DVEXTPROC.invoke(load("glVertexAttribL4dvEXT"), index, v);
  }

  public void glDebugMessageInsertKHR(int source, int type, int id, int severity, int length, MemorySegment buf) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public byte glReleaseKeyedMutexWin32EXT(int memory, long key) {
    return PFNGLRELEASEKEYEDMUTEXWIN32EXTPROC.invoke(load("glReleaseKeyedMutexWin32EXT"), memory, key);
  }

  public void glSignalSemaphoreui64NVX(int signalGpu, int fenceObjectCount, MemorySegment semaphoreArray, MemorySegment fenceValueArray) {
    PFNGLSIGNALSEMAPHOREUI64NVXPROC.invoke(load("glSignalSemaphoreui64NVX"), signalGpu, fenceObjectCount, semaphoreArray, fenceValueArray);
  }

  public void glGetCompressedTexImageARB(int target, int level, MemorySegment img) {
    PFNGLGETCOMPRESSEDTEXIMAGEARBPROC.invoke(load("glGetCompressedTexImageARB"), target, level, img);
  }

  public void glVertexAttribL2ui64NV(int index, long x, long y) {
    PFNGLVERTEXATTRIBL2UI64NVPROC.invoke(load("glVertexAttribL2ui64NV"), index, x, y);
  }

  public void glVertexArrayElementBuffer(int vaobj, int buffer) {
    PFNGLVERTEXARRAYELEMENTBUFFERPROC.invoke(load("glVertexArrayElementBuffer"), vaobj, buffer);
  }

  public void glColor4ubVertex2fvSUN(MemorySegment c, MemorySegment v) {
    PFNGLCOLOR4UBVERTEX2FVSUNPROC.invoke(load("glColor4ubVertex2fvSUN"), c, v);
  }

  public void glTextureStorage3D(int texture, int levels, int internalformat, int width, int height, int depth) {
    PFNGLTEXTURESTORAGE3DPROC.invoke(load("glTextureStorage3D"), texture, levels, internalformat, width, height, depth);
  }

  public void glProgramUniformMatrix4x2fv(int program, int location, int count, byte transpose, MemorySegment value) {
    PFNGLPROGRAMUNIFORMMATRIX4X2FVPROC.invoke(load("glProgramUniformMatrix4x2fv"), program, location, count, transpose, value);
  }

  public void glUniform4uivEXT(int location, int count, MemorySegment value) {
    PFNGLUNIFORM4UIVEXTPROC.invoke(load("glUniform4uivEXT"), location, count, value);
  }

  public void glBindMultiTextureEXT(int texunit, int target, int texture) {
    PFNGLBINDMULTITEXTUREEXTPROC.invoke(load("glBindMultiTextureEXT"), texunit, target, texture);
  }

  public MemorySegment glMapNamedBufferRange(int buffer, long offset, long length, int access) {
    return PFNGLMAPNAMEDBUFFERRANGEPROC.invoke(load("glMapNamedBufferRange"), buffer, offset, length, access);
  }

  public void glVertexAttribs2fvNV(int index, int count, MemorySegment v) {
    PFNGLVERTEXATTRIBS2FVNVPROC.invoke(load("glVertexAttribs2fvNV"), index, count, v);
  }

  public void glWindowPos3fv(MemorySegment v) {
    PFNGLWINDOWPOS3FVPROC.invoke(load("glWindowPos3fv"), v);
  }

  public void glGlobalAlphaFactoruiSUN(int factor) {
    PFNGLGLOBALALPHAFACTORUISUNPROC.invoke(load("glGlobalAlphaFactoruiSUN"), factor);
  }

  public void glClearNamedFramebufferfi(int framebuffer, int buffer, int drawbuffer, float depth, int stencil) {
    PFNGLCLEARNAMEDFRAMEBUFFERFIPROC.invoke(load("glClearNamedFramebufferfi"), framebuffer, buffer, drawbuffer, depth, stencil);
  }

  public void glNamedRenderbufferStorageMultisample(int renderbuffer, int samples, int internalformat, int width, int height) {
    PFNGLNAMEDRENDERBUFFERSTORAGEMULTISAMPLEPROC.invoke(load("glNamedRenderbufferStorageMultisample"), renderbuffer, samples, internalformat, width, height);
  }

  public void glGetTexParameterIivEXT(int target, int pname, MemorySegment params) {
    PFNGLGETTEXPARAMETERIIVEXTPROC.invoke(load("glGetTexParameterIivEXT"), target, pname, params);
  }

  public void glCombinerParameterfNV(int pname, float param) {
    PFNGLCOMBINERPARAMETERFNVPROC.invoke(load("glCombinerParameterfNV"), pname, param);
  }

  public void glGetVertexAttribfv(int index, int pname, MemorySegment params) {
    PFNGLGETVERTEXATTRIBFVPROC.invoke(load("glGetVertexAttribfv"), index, pname, params);
  }

  public void glPointParameterx(int pname, int param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glSampleMaskEXT(float value, byte invert) {
    PFNGLSAMPLEMASKEXTPROC.invoke(load("glSampleMaskEXT"), value, invert);
  }

  public void glCopyTextureSubImage2DEXT(int texture, int target, int level, int xoffset, int yoffset, int x, int y, int width, int height) {
    PFNGLCOPYTEXTURESUBIMAGE2DEXTPROC.invoke(load("glCopyTextureSubImage2DEXT"), texture, target, level, xoffset, yoffset, x, y, width, height);
  }

  public void glVertexAttribL4i64vNV(int index, MemorySegment v) {
    PFNGLVERTEXATTRIBL4I64VNVPROC.invoke(load("glVertexAttribL4i64vNV"), index, v);
  }

  public void glResetHistogram(int target) {
    PFNGLRESETHISTOGRAMEXTPROC.invoke(load("glResetHistogram"), target);
  }

  public void glMaterialxvOES(int face, int pname, MemorySegment param) {
    PFNGLMATERIALXVOESPROC.invoke(load("glMaterialxvOES"), face, pname, param);
  }

  public void glGetFinalCombinerInputParameterivNV(int variable, int pname, MemorySegment params) {
    PFNGLGETFINALCOMBINERINPUTPARAMETERIVNVPROC.invoke(load("glGetFinalCombinerInputParameterivNV"), variable, pname, params);
  }

  public void glPointParameteri(int pname, int param) {
    PFNGLPOINTPARAMETERIPROC.invoke(load("glPointParameteri"), pname, param);
  }

  public void glPointParameterf(int pname, float param) {
    PFNGLPOINTPARAMETERFPROC.invoke(load("glPointParameterf"), pname, param);
  }

  public void glDepthRangeArrayv(int first, int count, MemorySegment v) {
    PFNGLDEPTHRANGEARRAYVPROC.invoke(load("glDepthRangeArrayv"), first, count, v);
  }

  public void glGetnConvolutionFilterARB(int target, int format, int type, int bufSize, MemorySegment image) {
    PFNGLGETNCONVOLUTIONFILTERARBPROC.invoke(load("glGetnConvolutionFilterARB"), target, format, type, bufSize, image);
  }

  public void glColor4x(int red, int green, int blue, int alpha) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetVertexAttribIivEXT(int index, int pname, MemorySegment params) {
    PFNGLGETVERTEXATTRIBIIVEXTPROC.invoke(load("glGetVertexAttribIivEXT"), index, pname, params);
  }

  public void glVertexAttrib4svARB(int index, MemorySegment v) {
    PFNGLVERTEXATTRIB4SVARBPROC.invoke(load("glVertexAttrib4svARB"), index, v);
  }

  public void glTexBufferARB(int target, int internalformat, int buffer) {
    PFNGLTEXBUFFERARBPROC.invoke(load("glTexBufferARB"), target, internalformat, buffer);
  }

  public void glTextureStorage2DMultisampleEXT(int texture, int target, int samples, int internalformat, int width, int height, byte fixedsamplelocations) {
    PFNGLTEXTURESTORAGE2DMULTISAMPLEEXTPROC.invoke(load("glTextureStorage2DMultisampleEXT"), texture, target, samples, internalformat, width, height, fixedsamplelocations);
  }

  public void glReadnPixelsARB(int x, int y, int width, int height, int format, int type, int bufSize, MemorySegment data) {
    PFNGLREADNPIXELSARBPROC.invoke(load("glReadnPixelsARB"), x, y, width, height, format, type, bufSize, data);
  }

  public void glTexCoordPointerEXT(int size, int type, int stride, int count, MemorySegment pointer) {
    PFNGLTEXCOORDPOINTEREXTPROC.invoke(load("glTexCoordPointerEXT"), size, type, stride, count, pointer);
  }

  public void glFragmentLightModelfSGIX(int pname, float param) {
    PFNGLFRAGMENTLIGHTMODELFSGIXPROC.invoke(load("glFragmentLightModelfSGIX"), pname, param);
  }

  public void glMakeTextureHandleResidentNV(long handle) {
    PFNGLMAKETEXTUREHANDLERESIDENTNVPROC.invoke(load("glMakeTextureHandleResidentNV"), handle);
  }

  public void glVertexAttribI2ui(int index, int x, int y) {
    PFNGLVERTEXATTRIBI2UIPROC.invoke(load("glVertexAttribI2ui"), index, x, y);
  }

  public void glPrimitiveRestartIndex(int index) {
    PFNGLPRIMITIVERESTARTINDEXPROC.invoke(load("glPrimitiveRestartIndex"), index);
  }

  public void glWeightuivARB(int size, MemorySegment weights) {
    PFNGLWEIGHTUIVARBPROC.invoke(load("glWeightuivARB"), size, weights);
  }

  public void glLightModelxv(int pname, MemorySegment param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexStorageMem3DMultisampleEXT(int target, int samples, int internalFormat, int width, int height, int depth, byte fixedSampleLocations, int memory, long offset) {
    PFNGLTEXSTORAGEMEM3DMULTISAMPLEEXTPROC.invoke(load("glTexStorageMem3DMultisampleEXT"), target, samples, internalFormat, width, height, depth, fixedSampleLocations, memory, offset);
  }

  public MemorySegment glMapBufferRange(int target, long offset, long length, int access) {
    return PFNGLMAPBUFFERRANGEPROC.invoke(load("glMapBufferRange"), target, offset, length, access);
  }

  public void glVertexAttribs3hvNV(int index, int n, MemorySegment v) {
    PFNGLVERTEXATTRIBS3HVNVPROC.invoke(load("glVertexAttribs3hvNV"), index, n, v);
  }

  public byte glIsFramebuffer(int framebuffer) {
    return PFNGLISFRAMEBUFFERPROC.invoke(load("glIsFramebuffer"), framebuffer);
  }

  public void glGetVertexAttribArrayObjectfvATI(int index, int pname, MemorySegment params) {
    PFNGLGETVERTEXATTRIBARRAYOBJECTFVATIPROC.invoke(load("glGetVertexAttribArrayObjectfvATI"), index, pname, params);
  }

  public void glUniform2i64vARB(int location, int count, MemorySegment value) {
    PFNGLUNIFORM2I64VARBPROC.invoke(load("glUniform2i64vARB"), location, count, value);
  }

  public void glGetShaderSource(int shader, int bufSize, MemorySegment length, MemorySegment source) {
    PFNGLGETSHADERSOURCEPROC.invoke(load("glGetShaderSource"), shader, bufSize, length, source);
  }

  public void glVertexAttribs3svNV(int index, int count, MemorySegment v) {
    PFNGLVERTEXATTRIBS3SVNVPROC.invoke(load("glVertexAttribs3svNV"), index, count, v);
  }

  public void glGetVertexAttribiv(int index, int pname, MemorySegment params) {
    PFNGLGETVERTEXATTRIBIVPROC.invoke(load("glGetVertexAttribiv"), index, pname, params);
  }

  public void glVertexAttribL2i64vNV(int index, MemorySegment v) {
    PFNGLVERTEXATTRIBL2I64VNVPROC.invoke(load("glVertexAttribL2i64vNV"), index, v);
  }

  public void glCompressedTexSubImage1DARB(int target, int level, int xoffset, int width, int format, int imageSize, MemorySegment data) {
    PFNGLCOMPRESSEDTEXSUBIMAGE1DARBPROC.invoke(load("glCompressedTexSubImage1DARB"), target, level, xoffset, width, format, imageSize, data);
  }

  public void glCoverStrokePathInstancedNV(int numPaths, int pathNameType, MemorySegment paths, int pathBase, int coverMode, int transformType, MemorySegment transformValues) {
    PFNGLCOVERSTROKEPATHINSTANCEDNVPROC.invoke(load("glCoverStrokePathInstancedNV"), numPaths, pathNameType, paths, pathBase, coverMode, transformType, transformValues);
  }

  public void glUniform2uivEXT(int location, int count, MemorySegment value) {
    PFNGLUNIFORM2UIVEXTPROC.invoke(load("glUniform2uivEXT"), location, count, value);
  }

  public void glClearNamedFramebufferiv(int framebuffer, int buffer, int drawbuffer, MemorySegment value) {
    PFNGLCLEARNAMEDFRAMEBUFFERIVPROC.invoke(load("glClearNamedFramebufferiv"), framebuffer, buffer, drawbuffer, value);
  }

  public void glTexStorage3DEXT(int target, int levels, int internalformat, int width, int height, int depth) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetProgramBinary(int program, int bufSize, MemorySegment length, MemorySegment binaryFormat, MemorySegment binary) {
    PFNGLGETPROGRAMBINARYPROC.invoke(load("glGetProgramBinary"), program, bufSize, length, binaryFormat, binary);
  }

  public void glRenderbufferStorageMultisampleAdvancedAMD(int target, int samples, int storageSamples, int internalformat, int width, int height) {
    PFNGLRENDERBUFFERSTORAGEMULTISAMPLEADVANCEDAMDPROC.invoke(load("glRenderbufferStorageMultisampleAdvancedAMD"), target, samples, storageSamples, internalformat, width, height);
  }

  public void glWindowPos2svMESA(MemorySegment v) {
    PFNGLWINDOWPOS2SVMESAPROC.invoke(load("glWindowPos2svMESA"), v);
  }

  public void glElementPointerAPPLE(int type, MemorySegment pointer) {
    PFNGLELEMENTPOINTERAPPLEPROC.invoke(load("glElementPointerAPPLE"), type, pointer);
  }

  public void glGetQueryObjectiv(int id, int pname, MemorySegment params) {
    PFNGLGETQUERYOBJECTIVPROC.invoke(load("glGetQueryObjectiv"), id, pname, params);
  }

  public byte glIsProgramPipelineEXT(int pipeline) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glColorP4uiv(int type, MemorySegment color) {
    PFNGLCOLORP4UIVPROC.invoke(load("glColorP4uiv"), type, color);
  }

  public void glBindTransformFeedback(int target, int id) {
    PFNGLBINDTRANSFORMFEEDBACKPROC.invoke(load("glBindTransformFeedback"), target, id);
  }

  public void glPointParameterfEXT(int pname, float param) {
    PFNGLPOINTPARAMETERFEXTPROC.invoke(load("glPointParameterfEXT"), pname, param);
  }

  public void glGetPathParameterivNV(int path, int pname, MemorySegment value) {
    PFNGLGETPATHPARAMETERIVNVPROC.invoke(load("glGetPathParameterivNV"), path, pname, value);
  }

  public void glGenQueryResourceTagNV(int n, MemorySegment tagIds) {
    PFNGLGENQUERYRESOURCETAGNVPROC.invoke(load("glGenQueryResourceTagNV"), n, tagIds);
  }

  public void glObjectLabel(int identifier, int name, int length, MemorySegment label) {
    PFNGLOBJECTLABELPROC.invoke(load("glObjectLabel"), identifier, name, length, label);
  }

  public void glVDPAUGetSurfaceivNV(long surface, int pname, int count, MemorySegment length, MemorySegment values) {
    PFNGLVDPAUGETSURFACEIVNVPROC.invoke(load("glVDPAUGetSurfaceivNV"), surface, pname, count, length, values);
  }

  public void glUnmapTexture2DINTEL(int texture, int level) {
    PFNGLUNMAPTEXTURE2DINTELPROC.invoke(load("glUnmapTexture2DINTEL"), texture, level);
  }

  public void glVertexStream1fvATI(int stream, MemorySegment coords) {
    PFNGLVERTEXSTREAM1FVATIPROC.invoke(load("glVertexStream1fvATI"), stream, coords);
  }

  public int glGetUniformLocationARB(int programObj, MemorySegment name) {
    return opengl.windows.PFNGLGETUNIFORMLOCATIONARBPROC.invoke(load("glGetUniformLocationARB"), programObj, name);
  }

  public void glDeleteFencesAPPLE(int n, MemorySegment fences) {
    PFNGLDELETEFENCESAPPLEPROC.invoke(load("glDeleteFencesAPPLE"), n, fences);
  }

  public void glGetTransformFeedbackiv(int xfb, int pname, MemorySegment param) {
    PFNGLGETTRANSFORMFEEDBACKIVPROC.invoke(load("glGetTransformFeedbackiv"), xfb, pname, param);
  }

  public void glVertexAttribParameteriAMD(int index, int pname, int param) {
    PFNGLVERTEXATTRIBPARAMETERIAMDPROC.invoke(load("glVertexAttribParameteriAMD"), index, pname, param);
  }

  public void glFragmentCoverageColorNV(int color) {
    PFNGLFRAGMENTCOVERAGECOLORNVPROC.invoke(load("glFragmentCoverageColorNV"), color);
  }

  public int glGetProgramResourceLocationIndex(int program, int programInterface, MemorySegment name) {
    return PFNGLGETPROGRAMRESOURCELOCATIONINDEXPROC.invoke(load("glGetProgramResourceLocationIndex"), program, programInterface, name);
  }

  public void glGetImageTransformParameterfvHP(int target, int pname, MemorySegment params) {
    PFNGLGETIMAGETRANSFORMPARAMETERFVHPPROC.invoke(load("glGetImageTransformParameterfvHP"), target, pname, params);
  }

  public void glProgramUniform1i64NV(int program, int location, long x) {
    PFNGLPROGRAMUNIFORM1I64NVPROC.invoke(load("glProgramUniform1i64NV"), program, location, x);
  }

  public byte glIsBufferARB(int buffer) {
    return PFNGLISBUFFERARBPROC.invoke(load("glIsBufferARB"), buffer);
  }

  public void glGetVertexAttribLui64vNV(int index, int pname, MemorySegment params) {
    PFNGLGETVERTEXATTRIBLUI64VNVPROC.invoke(load("glGetVertexAttribLui64vNV"), index, pname, params);
  }

  public void glProgramParameteriARB(int program, int pname, int value) {
    PFNGLPROGRAMPARAMETERIARBPROC.invoke(load("glProgramParameteriARB"), program, pname, value);
  }

  public void glActiveStencilFaceEXT(int face) {
    PFNGLACTIVESTENCILFACEEXTPROC.invoke(load("glActiveStencilFaceEXT"), face);
  }

  public void glMultiTexCoord4dARB(int target, double s, double t, double r, double q) {
    PFNGLMULTITEXCOORD4DARBPROC.invoke(load("glMultiTexCoord4dARB"), target, s, t, r, q);
  }

  public void glLoadTransposeMatrixxOES(MemorySegment m) {
    PFNGLLOADTRANSPOSEMATRIXXOESPROC.invoke(load("glLoadTransposeMatrixxOES"), m);
  }

  public void glVertexStream4svATI(int stream, MemorySegment coords) {
    PFNGLVERTEXSTREAM4SVATIPROC.invoke(load("glVertexStream4svATI"), stream, coords);
  }

  public void glTexEnvxvOES(int target, int pname, MemorySegment params) {
    PFNGLTEXENVXVOESPROC.invoke(load("glTexEnvxvOES"), target, pname, params);
  }

  public void glNamedProgramLocalParameterI4uiEXT(int program, int target, int index, int x, int y, int z, int w) {
    PFNGLNAMEDPROGRAMLOCALPARAMETERI4UIEXTPROC.invoke(load("glNamedProgramLocalParameterI4uiEXT"), program, target, index, x, y, z, w);
  }

  public void glFogCoordFormatNV(int type, int stride) {
    PFNGLFOGCOORDFORMATNVPROC.invoke(load("glFogCoordFormatNV"), type, stride);
  }

  public void glGetIntegeri_vEXT(int target, int index, MemorySegment data) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glCreateRenderbuffers(int n, MemorySegment renderbuffers) {
    PFNGLCREATERENDERBUFFERSPROC.invoke(load("glCreateRenderbuffers"), n, renderbuffers);
  }

  public void glGetFramebufferParameterivMESA(int target, int pname, MemorySegment params) {
    PFNGLGETFRAMEBUFFERPARAMETERIVMESAPROC.invoke(load("glGetFramebufferParameterivMESA"), target, pname, params);
  }

  public void glGetConvolutionParameterfvEXT(int target, int pname, MemorySegment params) {
    PFNGLGETCONVOLUTIONPARAMETERFVEXTPROC.invoke(load("glGetConvolutionParameterfvEXT"), target, pname, params);
  }

  public void glTexCoord2fColor4fNormal3fVertex3fvSUN(MemorySegment tc, MemorySegment c, MemorySegment n, MemorySegment v) {
    PFNGLTEXCOORD2FCOLOR4FNORMAL3FVERTEX3FVSUNPROC.invoke(load("glTexCoord2fColor4fNormal3fVertex3fvSUN"), tc, c, n, v);
  }

  public void glReadnPixels(int x, int y, int width, int height, int format, int type, int bufSize, MemorySegment data) {
    PFNGLREADNPIXELSPROC.invoke(load("glReadnPixels"), x, y, width, height, format, type, bufSize, data);
  }

  public void glCombinerInputNV(int stage, int portion, int variable, int input, int mapping, int componentUsage) {
    PFNGLCOMBINERINPUTNVPROC.invoke(load("glCombinerInputNV"), stage, portion, variable, input, mapping, componentUsage);
  }

  public long glVDPAURegisterOutputSurfaceNV(MemorySegment vdpSurface, int target, int numTextureNames, MemorySegment textureNames) {
    return PFNGLVDPAUREGISTEROUTPUTSURFACENVPROC.invoke(load("glVDPAURegisterOutputSurfaceNV"), vdpSurface, target, numTextureNames, textureNames);
  }

  public void glMultiTexEnvfEXT(int texunit, int target, int pname, float param) {
    PFNGLMULTITEXENVFEXTPROC.invoke(load("glMultiTexEnvfEXT"), texunit, target, pname, param);
  }

  public byte glIsProgramPipeline(int pipeline) {
    return PFNGLISPROGRAMPIPELINEPROC.invoke(load("glIsProgramPipeline"), pipeline);
  }

  public int glPathMemoryGlyphIndexArrayNV(int firstPathName, int fontTarget, long fontSize, MemorySegment fontData, int faceIndex, int firstGlyphIndex, int numGlyphs, int pathParameterTemplate, float emScale) {
    return PFNGLPATHMEMORYGLYPHINDEXARRAYNVPROC.invoke(load("glPathMemoryGlyphIndexArrayNV"), firstPathName, fontTarget, fontSize, fontData, faceIndex, firstGlyphIndex, numGlyphs, pathParameterTemplate, emScale);
  }

  public void glVertexAttrib1d(int index, double x) {
    PFNGLVERTEXATTRIB1DPROC.invoke(load("glVertexAttrib1d"), index, x);
  }

  public void glWindowPos2sARB(short x, short y) {
    PFNGLWINDOWPOS2SARBPROC.invoke(load("glWindowPos2sARB"), x, y);
  }

  public void glLinkProgramARB(int programObj) {
    opengl.windows.PFNGLLINKPROGRAMARBPROC.invoke(load("glLinkProgramARB"), programObj);
  }

  public void glUniform4ivARB(int location, int count, MemorySegment value) {
    PFNGLUNIFORM4IVARBPROC.invoke(load("glUniform4ivARB"), location, count, value);
  }

  public void glVertexAttrib1f(int index, float x) {
    PFNGLVERTEXATTRIB1FPROC.invoke(load("glVertexAttrib1f"), index, x);
  }

  public void glDeleteQueriesEXT(int n, MemorySegment ids) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultTransposeMatrixfARB(MemorySegment m) {
    PFNGLMULTTRANSPOSEMATRIXFARBPROC.invoke(load("glMultTransposeMatrixfARB"), m);
  }

  public void glVertexAttrib1s(int index, short x) {
    PFNGLVERTEXATTRIB1SPROC.invoke(load("glVertexAttrib1s"), index, x);
  }

  public void glGetnUniformuiv(int program, int location, int bufSize, MemorySegment params) {
    PFNGLGETNUNIFORMUIVPROC.invoke(load("glGetnUniformuiv"), program, location, bufSize, params);
  }

  public void glCopyImageSubDataOES(int srcName, int srcTarget, int srcLevel, int srcX, int srcY, int srcZ, int dstName, int dstTarget, int dstLevel, int dstX, int dstY, int dstZ, int srcWidth, int srcHeight, int srcDepth) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBindRenderbufferOES(int target, int renderbuffer) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glPassThroughxOES(int token) {
    PFNGLPASSTHROUGHXOESPROC.invoke(load("glPassThroughxOES"), token);
  }

  public void glGlobalAlphaFactorfSUN(float factor) {
    PFNGLGLOBALALPHAFACTORFSUNPROC.invoke(load("glGlobalAlphaFactorfSUN"), factor);
  }

  public void glVertexStream2ivATI(int stream, MemorySegment coords) {
    PFNGLVERTEXSTREAM2IVATIPROC.invoke(load("glVertexStream2ivATI"), stream, coords);
  }

  public void glVertexAttribL4ui64NV(int index, long x, long y, long z, long w) {
    PFNGLVERTEXATTRIBL4UI64NVPROC.invoke(load("glVertexAttribL4ui64NV"), index, x, y, z, w);
  }

  public void glNamedBufferPageCommitmentMemNV(int buffer, long offset, long size, int memory, long memOffset, byte commit) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexCoord3hvNV(int target, MemorySegment v) {
    PFNGLMULTITEXCOORD3HVNVPROC.invoke(load("glMultiTexCoord3hvNV"), target, v);
  }

  public void glFramebufferDrawBuffersEXT(int framebuffer, int n, MemorySegment bufs) {
    PFNGLFRAMEBUFFERDRAWBUFFERSEXTPROC.invoke(load("glFramebufferDrawBuffersEXT"), framebuffer, n, bufs);
  }

  public int glNewObjectBufferATI(int size, MemorySegment pointer, int usage) {
    return PFNGLNEWOBJECTBUFFERATIPROC.invoke(load("glNewObjectBufferATI"), size, pointer, usage);
  }

  public void glTextureStorage3DMultisampleEXT(int texture, int target, int samples, int internalformat, int width, int height, int depth, byte fixedsamplelocations) {
    PFNGLTEXTURESTORAGE3DMULTISAMPLEEXTPROC.invoke(load("glTextureStorage3DMultisampleEXT"), texture, target, samples, internalformat, width, height, depth, fixedsamplelocations);
  }

  public void glWindowPos3dv(MemorySegment v) {
    PFNGLWINDOWPOS3DVPROC.invoke(load("glWindowPos3dv"), v);
  }

  public void glSecondaryColor3usv(MemorySegment v) {
    PFNGLSECONDARYCOLOR3USVPROC.invoke(load("glSecondaryColor3usv"), v);
  }

  public void glGetnUniformuivKHR(int program, int location, int bufSize, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertex2xvOES(MemorySegment coords) {
    PFNGLVERTEX2XVOESPROC.invoke(load("glVertex2xvOES"), coords);
  }

  public void glVertexAttrib3f(int index, float x, float y, float z) {
    PFNGLVERTEXATTRIB3FPROC.invoke(load("glVertexAttrib3f"), index, x, y, z);
  }

  public void glVertexAttrib3d(int index, double x, double y, double z) {
    PFNGLVERTEXATTRIB3DPROC.invoke(load("glVertexAttrib3d"), index, x, y, z);
  }

  public void glMultiTexCoord2bvOES(int texture, MemorySegment coords) {
    PFNGLMULTITEXCOORD2BVOESPROC.invoke(load("glMultiTexCoord2bvOES"), texture, coords);
  }

  public void glGetProgramEnvParameterfvARB(int target, int index, MemorySegment params) {
    PFNGLGETPROGRAMENVPARAMETERFVARBPROC.invoke(load("glGetProgramEnvParameterfvARB"), target, index, params);
  }

  public void glMakeImageHandleResidentARB(long handle, int access) {
    PFNGLMAKEIMAGEHANDLERESIDENTARBPROC.invoke(load("glMakeImageHandleResidentARB"), handle, access);
  }

  public void glMultiTexCoord1dv(int target, MemorySegment v) {
    PFNGLMULTITEXCOORD1DVARBPROC.invoke(load("glMultiTexCoord1dv"), target, v);
  }

  public void glUniform1ui64vNV(int location, int count, MemorySegment value) {
    PFNGLUNIFORM1UI64VNVPROC.invoke(load("glUniform1ui64vNV"), location, count, value);
  }

  public void glMatrixLoadTransposefEXT(int mode, MemorySegment m) {
    PFNGLMATRIXLOADTRANSPOSEFEXTPROC.invoke(load("glMatrixLoadTransposefEXT"), mode, m);
  }

  public void glResolveDepthValuesNV() {
    PFNGLRESOLVEDEPTHVALUESNVPROC.invoke(load("glResolveDepthValuesNV"));
  }

  public void glVertexAttrib3s(int index, short x, short y, short z) {
    PFNGLVERTEXATTRIB3SPROC.invoke(load("glVertexAttrib3s"), index, x, y, z);
  }

  public void glMultTransposeMatrixf(MemorySegment m) {
    PFNGLMULTTRANSPOSEMATRIXFARBPROC.invoke(load("glMultTransposeMatrixf"), m);
  }

  public void glSecondaryColor3sEXT(short red, short green, short blue) {
    PFNGLSECONDARYCOLOR3SEXTPROC.invoke(load("glSecondaryColor3sEXT"), red, green, blue);
  }

  public void glGetVertexAttribLi64vNV(int index, int pname, MemorySegment params) {
    PFNGLGETVERTEXATTRIBLI64VNVPROC.invoke(load("glGetVertexAttribLi64vNV"), index, pname, params);
  }

  public void glBlendEquationiOES(int buf, int mode) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttrib2f(int index, float x, float y) {
    PFNGLVERTEXATTRIB2FPROC.invoke(load("glVertexAttrib2f"), index, x, y);
  }

  public void glVertexAttrib2d(int index, double x, double y) {
    PFNGLVERTEXATTRIB2DPROC.invoke(load("glVertexAttrib2d"), index, x, y);
  }

  public void glCopyImageSubData(int srcName, int srcTarget, int srcLevel, int srcX, int srcY, int srcZ, int dstName, int dstTarget, int dstLevel, int dstX, int dstY, int dstZ, int srcWidth, int srcHeight, int srcDepth) {
    PFNGLCOPYIMAGESUBDATAPROC.invoke(load("glCopyImageSubData"), srcName, srcTarget, srcLevel, srcX, srcY, srcZ, dstName, dstTarget, dstLevel, dstX, dstY, dstZ, srcWidth, srcHeight, srcDepth);
  }

  public void glMultTransposeMatrixd(MemorySegment m) {
    PFNGLMULTTRANSPOSEMATRIXDARBPROC.invoke(load("glMultTransposeMatrixd"), m);
  }

  public byte glIsSync(MemorySegment sync) {
    return PFNGLISSYNCPROC.invoke(load("glIsSync"), sync);
  }

  public void glMatrixRotatedEXT(int mode, double angle, double x, double y, double z) {
    PFNGLMATRIXROTATEDEXTPROC.invoke(load("glMatrixRotatedEXT"), mode, angle, x, y, z);
  }

  public void glMultiTexCoord4fvARB(int target, MemorySegment v) {
    PFNGLMULTITEXCOORD4FVARBPROC.invoke(load("glMultiTexCoord4fvARB"), target, v);
  }

  public void glVertexAttrib2sv(int index, MemorySegment v) {
    PFNGLVERTEXATTRIB2SVPROC.invoke(load("glVertexAttrib2sv"), index, v);
  }

  public void glMultiDrawElementsEXT(int mode, MemorySegment count, int type, MemorySegment indices, int primcount) {
    PFNGLMULTIDRAWELEMENTSEXTPROC.invoke(load("glMultiDrawElementsEXT"), mode, count, type, indices, primcount);
  }

  public void glVertexAttrib2s(int index, short x, short y) {
    PFNGLVERTEXATTRIB2SPROC.invoke(load("glVertexAttrib2s"), index, x, y);
  }

  public void glMap1xOES(int target, int u1, int u2, int stride, int order, int points) {
    PFNGLMAP1XOESPROC.invoke(load("glMap1xOES"), target, u1, u2, stride, order, points);
  }

  public void glMultiTexCoord1fv(int target, MemorySegment v) {
    PFNGLMULTITEXCOORD1FVARBPROC.invoke(load("glMultiTexCoord1fv"), target, v);
  }

  public void glTexCoord4hNV(short s, short t, short r, short q) {
    PFNGLTEXCOORD4HNVPROC.invoke(load("glTexCoord4hNV"), s, t, r, q);
  }

  public byte glIsFenceNV(int fence) {
    return PFNGLISFENCENVPROC.invoke(load("glIsFenceNV"), fence);
  }

  public void glLinkProgram(int program) {
    PFNGLLINKPROGRAMPROC.invoke(load("glLinkProgram"), program);
  }

  public void glFramebufferTexture3DOES(int target, int attachment, int textarget, int texture, int level, int zoffset) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexP2ui(int type, int value) {
    PFNGLVERTEXP2UIPROC.invoke(load("glVertexP2ui"), type, value);
  }

  public void glGetFixedvOES(int pname, MemorySegment params) {
    PFNGLGETFIXEDVOESPROC.invoke(load("glGetFixedvOES"), pname, params);
  }

  public void glLoadIdentityDeformationMapSGIX(int mask) {
    PFNGLLOADIDENTITYDEFORMATIONMAPSGIXPROC.invoke(load("glLoadIdentityDeformationMapSGIX"), mask);
  }

  public void glDrawMeshTasksNV(int first, int count) {
    PFNGLDRAWMESHTASKSNVPROC.invoke(load("glDrawMeshTasksNV"), first, count);
  }

  public void glVertexAttrib1fvARB(int index, MemorySegment v) {
    PFNGLVERTEXATTRIB1FVARBPROC.invoke(load("glVertexAttrib1fvARB"), index, v);
  }

  public void glHintPGI(int target, int mode) {
    PFNGLHINTPGIPROC.invoke(load("glHintPGI"), target, mode);
  }

  public void glBindRenderbuffer(int target, int renderbuffer) {
    PFNGLBINDRENDERBUFFERPROC.invoke(load("glBindRenderbuffer"), target, renderbuffer);
  }

  public void glAlphaFuncxOES(int func, int ref) {
    PFNGLALPHAFUNCXOESPROC.invoke(load("glAlphaFuncxOES"), func, ref);
  }

  public void glVertexAttribL3dEXT(int index, double x, double y, double z) {
    PFNGLVERTEXATTRIBL3DEXTPROC.invoke(load("glVertexAttribL3dEXT"), index, x, y, z);
  }

  public void glTexGeniOES(int coord, int pname, int param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUseProgramStages(int pipeline, int stages, int program) {
    PFNGLUSEPROGRAMSTAGESPROC.invoke(load("glUseProgramStages"), pipeline, stages, program);
  }

  public void glNamedBufferDataEXT(int buffer, long size, MemorySegment data, int usage) {
    PFNGLNAMEDBUFFERDATAEXTPROC.invoke(load("glNamedBufferDataEXT"), buffer, size, data, usage);
  }

  public void glBufferAttachMemoryNV(int target, int memory, long offset) {
    PFNGLBUFFERATTACHMEMORYNVPROC.invoke(load("glBufferAttachMemoryNV"), target, memory, offset);
  }

  public void glUniform4ui64ARB(int location, long x, long y, long z, long w) {
    PFNGLUNIFORM4UI64ARBPROC.invoke(load("glUniform4ui64ARB"), location, x, y, z, w);
  }

  public void glProgramSubroutineParametersuivNV(int target, int count, MemorySegment params) {
    PFNGLPROGRAMSUBROUTINEPARAMETERSUIVNVPROC.invoke(load("glProgramSubroutineParametersuivNV"), target, count, params);
  }

  public void glSecondaryColorPointerListIBM(int size, int type, int stride, MemorySegment pointer, int ptrstride) {
    PFNGLSECONDARYCOLORPOINTERLISTIBMPROC.invoke(load("glSecondaryColorPointerListIBM"), size, type, stride, pointer, ptrstride);
  }

  public void glUniform3fARB(int location, float v0, float v1, float v2) {
    PFNGLUNIFORM3FARBPROC.invoke(load("glUniform3fARB"), location, v0, v1, v2);
  }

  public void glProgramUniform1fEXT(int program, int location, float v0) {
    PFNGLPROGRAMUNIFORM1FEXTPROC.invoke(load("glProgramUniform1fEXT"), program, location, v0);
  }

  public void glVertexBlendARB(int count) {
    PFNGLVERTEXBLENDARBPROC.invoke(load("glVertexBlendARB"), count);
  }

  public void glGenProgramsNV(int n, MemorySegment programs) {
    PFNGLGENPROGRAMSNVPROC.invoke(load("glGenProgramsNV"), n, programs);
  }

  public void glNamedFramebufferTextureEXT(int framebuffer, int attachment, int texture, int level) {
    PFNGLNAMEDFRAMEBUFFERTEXTUREEXTPROC.invoke(load("glNamedFramebufferTextureEXT"), framebuffer, attachment, texture, level);
  }

  public void glScissorIndexedNV(int index, int left, int bottom, int width, int height) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribI1uiEXT(int index, int x) {
    PFNGLVERTEXATTRIBI1UIEXTPROC.invoke(load("glVertexAttribI1uiEXT"), index, x);
  }

  public void glFragmentLightivSGIX(int light, int pname, MemorySegment params) {
    PFNGLFRAGMENTLIGHTIVSGIXPROC.invoke(load("glFragmentLightivSGIX"), light, pname, params);
  }

  public void glUniformMatrix4fvARB(int location, int count, byte transpose, MemorySegment value) {
    PFNGLUNIFORMMATRIX4FVARBPROC.invoke(load("glUniformMatrix4fvARB"), location, count, transpose, value);
  }

  public void glTexCoord1hvNV(MemorySegment v) {
    PFNGLTEXCOORD1HVNVPROC.invoke(load("glTexCoord1hvNV"), v);
  }

  public void glGetVideoCaptureStreamfvNV(int video_capture_slot, int stream, int pname, MemorySegment params) {
    PFNGLGETVIDEOCAPTURESTREAMFVNVPROC.invoke(load("glGetVideoCaptureStreamfvNV"), video_capture_slot, stream, pname, params);
  }

  public void glMatrixIndexuivARB(int size, MemorySegment indices) {
    PFNGLMATRIXINDEXUIVARBPROC.invoke(load("glMatrixIndexuivARB"), size, indices);
  }

  public void glMultiTexCoord3bvOES(int texture, MemorySegment coords) {
    PFNGLMULTITEXCOORD3BVOESPROC.invoke(load("glMultiTexCoord3bvOES"), texture, coords);
  }

  public void glClearNamedBufferData(int buffer, int internalformat, int format, int type, MemorySegment data) {
    PFNGLCLEARNAMEDBUFFERDATAPROC.invoke(load("glClearNamedBufferData"), buffer, internalformat, format, type, data);
  }

  public void glFramebufferSamplePositionsfvAMD(int target, int numsamples, int pixelindex, MemorySegment values) {
    PFNGLFRAMEBUFFERSAMPLEPOSITIONSFVAMDPROC.invoke(load("glFramebufferSamplePositionsfvAMD"), target, numsamples, pixelindex, values);
  }

  public void glCoverFillPathInstancedNV(int numPaths, int pathNameType, MemorySegment paths, int pathBase, int coverMode, int transformType, MemorySegment transformValues) {
    PFNGLCOVERFILLPATHINSTANCEDNVPROC.invoke(load("glCoverFillPathInstancedNV"), numPaths, pathNameType, paths, pathBase, coverMode, transformType, transformValues);
  }

  public void glTextureParameterIiv(int texture, int pname, MemorySegment params) {
    PFNGLTEXTUREPARAMETERIIVPROC.invoke(load("glTextureParameterIiv"), texture, pname, params);
  }

  public void glGetHistogramParameterfvEXT(int target, int pname, MemorySegment params) {
    PFNGLGETHISTOGRAMPARAMETERFVEXTPROC.invoke(load("glGetHistogramParameterfvEXT"), target, pname, params);
  }

  public void glGetMultiTexLevelParameterfvEXT(int texunit, int target, int level, int pname, MemorySegment params) {
    PFNGLGETMULTITEXLEVELPARAMETERFVEXTPROC.invoke(load("glGetMultiTexLevelParameterfvEXT"), texunit, target, level, pname, params);
  }

  public void glGenSemaphoresEXT(int n, MemorySegment semaphores) {
    PFNGLGENSEMAPHORESEXTPROC.invoke(load("glGenSemaphoresEXT"), n, semaphores);
  }

  public void glCopyMultiTexSubImage3DEXT(int texunit, int target, int level, int xoffset, int yoffset, int zoffset, int x, int y, int width, int height) {
    PFNGLCOPYMULTITEXSUBIMAGE3DEXTPROC.invoke(load("glCopyMultiTexSubImage3DEXT"), texunit, target, level, xoffset, yoffset, zoffset, x, y, width, height);
  }

  public void glUniformMatrix4x2fvNV(int location, int count, byte transpose, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetFragmentShadingRatesEXT(int samples, int maxCount, MemorySegment count, MemorySegment shadingRates) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVariantsvEXT(int id, MemorySegment addr) {
    PFNGLVARIANTSVEXTPROC.invoke(load("glVariantsvEXT"), id, addr);
  }

  public void glBinormal3bEXT(byte bx, byte by, byte bz) {
    PFNGLBINORMAL3BEXTPROC.invoke(load("glBinormal3bEXT"), bx, by, bz);
  }

  public void glCompressedMultiTexImage2DEXT(int texunit, int target, int level, int internalformat, int width, int height, int border, int imageSize, MemorySegment bits) {
    PFNGLCOMPRESSEDMULTITEXIMAGE2DEXTPROC.invoke(load("glCompressedMultiTexImage2DEXT"), texunit, target, level, internalformat, width, height, border, imageSize, bits);
  }

  public void glAsyncMarkerSGIX(int marker) {
    PFNGLASYNCMARKERSGIXPROC.invoke(load("glAsyncMarkerSGIX"), marker);
  }

  public void glMultiTexSubImage3DEXT(int texunit, int target, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int format, int type, MemorySegment pixels) {
    PFNGLMULTITEXSUBIMAGE3DEXTPROC.invoke(load("glMultiTexSubImage3DEXT"), texunit, target, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels);
  }

  public int glGetFragDataIndexEXT(int program, MemorySegment name) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glReplacementCodeuivSUN(MemorySegment code) {
    PFNGLREPLACEMENTCODEUIVSUNPROC.invoke(load("glReplacementCodeuivSUN"), code);
  }

  public void glMapParameterivNV(int target, int pname, MemorySegment params) {
    PFNGLMAPPARAMETERIVNVPROC.invoke(load("glMapParameterivNV"), target, pname, params);
  }

  public void glGenVertexArrays(int n, MemorySegment arrays) {
    PFNGLGENVERTEXARRAYSPROC.invoke(load("glGenVertexArrays"), n, arrays);
  }

  public int glGetFragDataLocationEXT(int program, MemorySegment name) {
    return PFNGLGETFRAGDATALOCATIONEXTPROC.invoke(load("glGetFragDataLocationEXT"), program, name);
  }

  public void glColor4fNormal3fVertex3fvSUN(MemorySegment c, MemorySegment n, MemorySegment v) {
    PFNGLCOLOR4FNORMAL3FVERTEX3FVSUNPROC.invoke(load("glColor4fNormal3fVertex3fvSUN"), c, n, v);
  }

  public void glProgramLocalParametersI4uivNV(int target, int index, int count, MemorySegment params) {
    PFNGLPROGRAMLOCALPARAMETERSI4UIVNVPROC.invoke(load("glProgramLocalParametersI4uivNV"), target, index, count, params);
  }

  public void glEnableVertexArrayAttrib(int vaobj, int index) {
    PFNGLENABLEVERTEXARRAYATTRIBPROC.invoke(load("glEnableVertexArrayAttrib"), vaobj, index);
  }

  public void glLoadTransposeMatrixd(MemorySegment m) {
    PFNGLLOADTRANSPOSEMATRIXDARBPROC.invoke(load("glLoadTransposeMatrixd"), m);
  }

  public void glLoadTransposeMatrixf(MemorySegment m) {
    PFNGLLOADTRANSPOSEMATRIXFARBPROC.invoke(load("glLoadTransposeMatrixf"), m);
  }

  public void glProgramLocalParameterI4uiNV(int target, int index, int x, int y, int z, int w) {
    PFNGLPROGRAMLOCALPARAMETERI4UINVPROC.invoke(load("glProgramLocalParameterI4uiNV"), target, index, x, y, z, w);
  }

  public void glGenFramebuffers(int n, MemorySegment framebuffers) {
    PFNGLGENFRAMEBUFFERSPROC.invoke(load("glGenFramebuffers"), n, framebuffers);
  }

  public void glBindFragDataLocationIndexedEXT(int program, int colorNumber, int index, MemorySegment name) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glHistogram(int target, int width, int internalformat, byte sink) {
    PFNGLHISTOGRAMEXTPROC.invoke(load("glHistogram"), target, width, internalformat, sink);
  }

  public void glClientActiveTexture(int texture) {
    PFNGLCLIENTACTIVETEXTUREARBPROC.invoke(load("glClientActiveTexture"), texture);
  }

  public void glVertexWeightPointerEXT(int size, int type, int stride, MemorySegment pointer) {
    PFNGLVERTEXWEIGHTPOINTEREXTPROC.invoke(load("glVertexWeightPointerEXT"), size, type, stride, pointer);
  }

  public void glTexFilterFuncSGIS(int target, int filter, int n, MemorySegment weights) {
    PFNGLTEXFILTERFUNCSGISPROC.invoke(load("glTexFilterFuncSGIS"), target, filter, n, weights);
  }

  public void glVertexAttrib1dARB(int index, double x) {
    PFNGLVERTEXATTRIB1DARBPROC.invoke(load("glVertexAttrib1dARB"), index, x);
  }

  public void glBlendColorxOES(int red, int green, int blue, int alpha) {
    PFNGLBLENDCOLORXOESPROC.invoke(load("glBlendColorxOES"), red, green, blue, alpha);
  }

  public byte glIsEnablediEXT(int target, int index) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glRenderbufferStorageMultisampleIMG(int target, int samples, int internalformat, int width, int height) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetVertexAttribIuiv(int index, int pname, MemorySegment params) {
    PFNGLGETVERTEXATTRIBIUIVPROC.invoke(load("glGetVertexAttribIuiv"), index, pname, params);
  }

  public void glMultiTexCoord1iARB(int target, int s) {
    PFNGLMULTITEXCOORD1IARBPROC.invoke(load("glMultiTexCoord1iARB"), target, s);
  }

  public void glColorPointervINTEL(int size, int type, MemorySegment pointer) {
    PFNGLCOLORPOINTERVINTELPROC.invoke(load("glColorPointervINTEL"), size, type, pointer);
  }

  public void glCompressedTexSubImage3DOES(int target, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int format, int imageSize, MemorySegment data) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDeleteStatesNV(int n, MemorySegment states) {
    PFNGLDELETESTATESNVPROC.invoke(load("glDeleteStatesNV"), n, states);
  }

  public void glClientWaitSemaphoreui64NVX(int fenceObjectCount, MemorySegment semaphoreArray, MemorySegment fenceValueArray) {
    PFNGLCLIENTWAITSEMAPHOREUI64NVXPROC.invoke(load("glClientWaitSemaphoreui64NVX"), fenceObjectCount, semaphoreArray, fenceValueArray);
  }

  public void glGetProgramParameterfvNV(int target, int index, int pname, MemorySegment params) {
    PFNGLGETPROGRAMPARAMETERFVNVPROC.invoke(load("glGetProgramParameterfvNV"), target, index, pname, params);
  }

  public void glSetMultisamplefvAMD(int pname, int index, MemorySegment val) {
    PFNGLSETMULTISAMPLEFVAMDPROC.invoke(load("glSetMultisamplefvAMD"), pname, index, val);
  }

  public void glActiveProgramEXT(int program) {
    PFNGLACTIVEPROGRAMEXTPROC.invoke(load("glActiveProgramEXT"), program);
  }

  public void glTranslatexOES(int x, int y, int z) {
    PFNGLTRANSLATEXOESPROC.invoke(load("glTranslatexOES"), x, y, z);
  }

  public void glVertexAttrib2fNV(int index, float x, float y) {
    PFNGLVERTEXATTRIB2FNVPROC.invoke(load("glVertexAttrib2fNV"), index, x, y);
  }

  public void glMakeTextureHandleNonResidentNV(long handle) {
    PFNGLMAKETEXTUREHANDLENONRESIDENTNVPROC.invoke(load("glMakeTextureHandleNonResidentNV"), handle);
  }

  public void glGetTextureParameterivEXT(int texture, int target, int pname, MemorySegment params) {
    PFNGLGETTEXTUREPARAMETERIVEXTPROC.invoke(load("glGetTextureParameterivEXT"), texture, target, pname, params);
  }

  public void glGetPerfMonitorGroupStringAMD(int group, int bufSize, MemorySegment length, MemorySegment groupString) {
    PFNGLGETPERFMONITORGROUPSTRINGAMDPROC.invoke(load("glGetPerfMonitorGroupStringAMD"), group, bufSize, length, groupString);
  }

  public void glVertexAttribL1ui64vNV(int index, MemorySegment v) {
    PFNGLVERTEXATTRIBL1UI64VNVPROC.invoke(load("glVertexAttribL1ui64vNV"), index, v);
  }

  public void glGetActiveUniform(int program, int index, int bufSize, MemorySegment length, MemorySegment size, MemorySegment type, MemorySegment name) {
    PFNGLGETACTIVEUNIFORMPROC.invoke(load("glGetActiveUniform"), program, index, bufSize, length, size, type, name);
  }

  public void glVertex2bOES(byte x, byte y) {
    PFNGLVERTEX2BOESPROC.invoke(load("glVertex2bOES"), x, y);
  }

  public void glBindVertexShaderEXT(int id) {
    PFNGLBINDVERTEXSHADEREXTPROC.invoke(load("glBindVertexShaderEXT"), id);
  }

  public void glUniform3i64vNV(int location, int count, MemorySegment value) {
    PFNGLUNIFORM3I64VNVPROC.invoke(load("glUniform3i64vNV"), location, count, value);
  }

  public void glVertexAttribI3iEXT(int index, int x, int y, int z) {
    PFNGLVERTEXATTRIBI3IEXTPROC.invoke(load("glVertexAttribI3iEXT"), index, x, y, z);
  }

  public void glVertexAttribI4svEXT(int index, MemorySegment v) {
    PFNGLVERTEXATTRIBI4SVEXTPROC.invoke(load("glVertexAttribI4svEXT"), index, v);
  }

  public void glOrthofOES(float l, float r, float b, float t, float n, float f) {
    PFNGLORTHOFOESPROC.invoke(load("glOrthofOES"), l, r, b, t, n, f);
  }

  public void glGetObjectPtrLabel(MemorySegment ptr, int bufSize, MemorySegment length, MemorySegment label) {
    PFNGLGETOBJECTPTRLABELPROC.invoke(load("glGetObjectPtrLabel"), ptr, bufSize, length, label);
  }

  public void glMultiDrawArraysEXT(int mode, MemorySegment first, MemorySegment count, int primcount) {
    PFNGLMULTIDRAWARRAYSEXTPROC.invoke(load("glMultiDrawArraysEXT"), mode, first, count, primcount);
  }

  public void glCombinerOutputNV(int stage, int portion, int abOutput, int cdOutput, int sumOutput, int scale, int bias, byte abDotProduct, byte cdDotProduct, byte muxSum) {
    PFNGLCOMBINEROUTPUTNVPROC.invoke(load("glCombinerOutputNV"), stage, portion, abOutput, cdOutput, sumOutput, scale, bias, abDotProduct, cdDotProduct, muxSum);
  }

  public void glTexImage3DOES(int target, int level, int internalformat, int width, int height, int depth, int border, int format, int type, MemorySegment pixels) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertex2xOES(int x) {
    PFNGLVERTEX2XOESPROC.invoke(load("glVertex2xOES"), x);
  }

  public void glBindVertexArray(int array) {
    PFNGLBINDVERTEXARRAYPROC.invoke(load("glBindVertexArray"), array);
  }

  public void glNamedFramebufferTexture1DEXT(int framebuffer, int attachment, int textarget, int texture, int level) {
    PFNGLNAMEDFRAMEBUFFERTEXTURE1DEXTPROC.invoke(load("glNamedFramebufferTexture1DEXT"), framebuffer, attachment, textarget, texture, level);
  }

  public void glGetMultiTexImageEXT(int texunit, int target, int level, int format, int type, MemorySegment pixels) {
    PFNGLGETMULTITEXIMAGEEXTPROC.invoke(load("glGetMultiTexImageEXT"), texunit, target, level, format, type, pixels);
  }

  public void glLightModelxvOES(int pname, MemorySegment param) {
    PFNGLLIGHTMODELXVOESPROC.invoke(load("glLightModelxvOES"), pname, param);
  }

  public void glVertexAttrib3fvNV(int index, MemorySegment v) {
    PFNGLVERTEXATTRIB3FVNVPROC.invoke(load("glVertexAttrib3fvNV"), index, v);
  }

  public void glDeleteRenderbuffersOES(int n, MemorySegment renderbuffers) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public int glGenFragmentShadersATI(int range) {
    return PFNGLGENFRAGMENTSHADERSATIPROC.invoke(load("glGenFragmentShadersATI"), range);
  }

  public void glCopyColorTable(int target, int internalformat, int x, int y, int width) {
    PFNGLCOPYCOLORTABLESGIPROC.invoke(load("glCopyColorTable"), target, internalformat, x, y, width);
  }

  public void glHistogramEXT(int target, int width, int internalformat, byte sink) {
    PFNGLHISTOGRAMEXTPROC.invoke(load("glHistogramEXT"), target, width, internalformat, sink);
  }

  public void glTexCoordP3uiv(int type, MemorySegment coords) {
    PFNGLTEXCOORDP3UIVPROC.invoke(load("glTexCoordP3uiv"), type, coords);
  }

  public void glBindImageTexture(int unit, int texture, int level, byte layered, int layer, int access, int format) {
    PFNGLBINDIMAGETEXTUREPROC.invoke(load("glBindImageTexture"), unit, texture, level, layered, layer, access, format);
  }

  public void glGetnUniformfvKHR(int program, int location, int bufSize, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glNamedProgramLocalParameter4fEXT(int program, int target, int index, float x, float y, float z, float w) {
    PFNGLNAMEDPROGRAMLOCALPARAMETER4FEXTPROC.invoke(load("glNamedProgramLocalParameter4fEXT"), program, target, index, x, y, z, w);
  }

  public void glWaitSync(MemorySegment sync, int flags, long timeout) {
    PFNGLWAITSYNCPROC.invoke(load("glWaitSync"), sync, flags, timeout);
  }

  public void glVertexAttrib4svNV(int index, MemorySegment v) {
    PFNGLVERTEXATTRIB4SVNVPROC.invoke(load("glVertexAttrib4svNV"), index, v);
  }

  public void glGenVertexArraysAPPLE(int n, MemorySegment arrays) {
    PFNGLGENVERTEXARRAYSAPPLEPROC.invoke(load("glGenVertexArraysAPPLE"), n, arrays);
  }

  public void glListParameteriSGIX(int list, int pname, int param) {
    PFNGLLISTPARAMETERISGIXPROC.invoke(load("glListParameteriSGIX"), list, pname, param);
  }

  public void glGetIntegerui64i_vNV(int value, int index, MemorySegment result) {
    PFNGLGETINTEGERUI64I_VNVPROC.invoke(load("glGetIntegerui64i_vNV"), value, index, result);
  }

  public void glProgramUniform3ui(int program, int location, int v0, int v1, int v2) {
    PFNGLPROGRAMUNIFORM3UIPROC.invoke(load("glProgramUniform3ui"), program, location, v0, v1, v2);
  }

  public void glTextureRenderbufferEXT(int texture, int target, int renderbuffer) {
    PFNGLTEXTURERENDERBUFFEREXTPROC.invoke(load("glTextureRenderbufferEXT"), texture, target, renderbuffer);
  }

  public void glElementPointerATI(int type, MemorySegment pointer) {
    PFNGLELEMENTPOINTERATIPROC.invoke(load("glElementPointerATI"), type, pointer);
  }

  public void glSecondaryColor3hvNV(MemorySegment v) {
    PFNGLSECONDARYCOLOR3HVNVPROC.invoke(load("glSecondaryColor3hvNV"), v);
  }

  public void glColor4fNormal3fVertex3fSUN(float r, float g, float b, float a, float nx, float ny, float nz, float x, float y, float z) {
    PFNGLCOLOR4FNORMAL3FVERTEX3FSUNPROC.invoke(load("glColor4fNormal3fVertex3fSUN"), r, g, b, a, nx, ny, nz, x, y, z);
  }

  public void glVertexStream1sATI(int stream, short x) {
    PFNGLVERTEXSTREAM1SATIPROC.invoke(load("glVertexStream1sATI"), stream, x);
  }

  public byte glExtIsProgramBinaryQCOM(int program) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGenFramebuffersEXT(int n, MemorySegment framebuffers) {
    PFNGLGENFRAMEBUFFERSEXTPROC.invoke(load("glGenFramebuffersEXT"), n, framebuffers);
  }

  public void glNormal3fVertex3fSUN(float nx, float ny, float nz, float x, float y, float z) {
    PFNGLNORMAL3FVERTEX3FSUNPROC.invoke(load("glNormal3fVertex3fSUN"), nx, ny, nz, x, y, z);
  }

  public void glVertexAttrib4hvNV(int index, MemorySegment v) {
    PFNGLVERTEXATTRIB4HVNVPROC.invoke(load("glVertexAttrib4hvNV"), index, v);
  }

  public void glProgramUniformMatrix2x3fvEXT(int program, int location, int count, byte transpose, MemorySegment value) {
    PFNGLPROGRAMUNIFORMMATRIX2X3FVEXTPROC.invoke(load("glProgramUniformMatrix2x3fvEXT"), program, location, count, transpose, value);
  }

  public void glTextureAttachMemoryNV(int texture, int memory, long offset) {
    PFNGLTEXTUREATTACHMEMORYNVPROC.invoke(load("glTextureAttachMemoryNV"), texture, memory, offset);
  }

  public void glProgramUniform1i64ARB(int program, int location, long x) {
    PFNGLPROGRAMUNIFORM1I64ARBPROC.invoke(load("glProgramUniform1i64ARB"), program, location, x);
  }

  public void glDrawRangeElementsBaseVertexEXT(int mode, int start, int end, int count, int type, MemorySegment indices, int basevertex) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetObjectLabelEXT(int type, int object, int bufSize, MemorySegment length, MemorySegment label) {
    PFNGLGETOBJECTLABELEXTPROC.invoke(load("glGetObjectLabelEXT"), type, object, bufSize, length, label);
  }

  public void glTextureView(int texture, int target, int origtexture, int internalformat, int minlevel, int numlevels, int minlayer, int numlayers) {
    PFNGLTEXTUREVIEWPROC.invoke(load("glTextureView"), texture, target, origtexture, internalformat, minlevel, numlevels, minlayer, numlayers);
  }

  public void glImportMemoryFdEXT(int memory, long size, int handleType, int fd) {
    PFNGLIMPORTMEMORYFDEXTPROC.invoke(load("glImportMemoryFdEXT"), memory, size, handleType, fd);
  }

  public void glMatrixMult3x2fNV(int matrixMode, MemorySegment m) {
    PFNGLMATRIXMULT3X2FNVPROC.invoke(load("glMatrixMult3x2fNV"), matrixMode, m);
  }

  public long glGetTextureSamplerHandleIMG(int texture, int sampler) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniform4ui64vARB(int location, int count, MemorySegment value) {
    PFNGLUNIFORM4UI64VARBPROC.invoke(load("glUniform4ui64vARB"), location, count, value);
  }

  public void glVertexAttribP1ui(int index, int type, byte normalized, int value) {
    PFNGLVERTEXATTRIBP1UIPROC.invoke(load("glVertexAttribP1ui"), index, type, normalized, value);
  }

  public void glLightEnviSGIX(int pname, int param) {
    PFNGLLIGHTENVISGIXPROC.invoke(load("glLightEnviSGIX"), pname, param);
  }

  public void glBinormal3svEXT(MemorySegment v) {
    PFNGLBINORMAL3SVEXTPROC.invoke(load("glBinormal3svEXT"), v);
  }

  public void glBeginOcclusionQueryNV(int id) {
    PFNGLBEGINOCCLUSIONQUERYNVPROC.invoke(load("glBeginOcclusionQueryNV"), id);
  }

  public byte glIsVertexArrayOES(int array) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDrawArraysIndirect(int mode, MemorySegment indirect) {
    PFNGLDRAWARRAYSINDIRECTPROC.invoke(load("glDrawArraysIndirect"), mode, indirect);
  }

  public byte glIsPointInFillPathNV(int path, int mask, float x, float y) {
    return PFNGLISPOINTINFILLPATHNVPROC.invoke(load("glIsPointInFillPathNV"), path, mask, x, y);
  }

  public void glTextureStorageMem1DEXT(int texture, int levels, int internalFormat, int width, int memory, long offset) {
    PFNGLTEXTURESTORAGEMEM1DEXTPROC.invoke(load("glTextureStorageMem1DEXT"), texture, levels, internalFormat, width, memory, offset);
  }

  public void glFragmentLightModelfvSGIX(int pname, MemorySegment params) {
    PFNGLFRAGMENTLIGHTMODELFVSGIXPROC.invoke(load("glFragmentLightModelfvSGIX"), pname, params);
  }

  public void glGetNamedFramebufferParameterivEXT(int framebuffer, int pname, MemorySegment params) {
    PFNGLGETNAMEDFRAMEBUFFERPARAMETERIVEXTPROC.invoke(load("glGetNamedFramebufferParameterivEXT"), framebuffer, pname, params);
  }

  public void glActiveShaderProgram(int pipeline, int program) {
    PFNGLACTIVESHADERPROGRAMPROC.invoke(load("glActiveShaderProgram"), pipeline, program);
  }

  public void glTexEstimateMotionQCOM(int ref, int target, int output) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDrawTexiOES(int x, int y, int z, int width, int height) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glNamedBufferStorageMemEXT(int buffer, long size, int memory, long offset) {
    PFNGLNAMEDBUFFERSTORAGEMEMEXTPROC.invoke(load("glNamedBufferStorageMemEXT"), buffer, size, memory, offset);
  }

  public void glGetSamplerParameterIivEXT(int sampler, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexGenxvOES(int coord, int pname, MemorySegment params) {
    PFNGLTEXGENXVOESPROC.invoke(load("glTexGenxvOES"), coord, pname, params);
  }

  public void glTextureParameteriv(int texture, int pname, MemorySegment param) {
    PFNGLTEXTUREPARAMETERIVPROC.invoke(load("glTextureParameteriv"), texture, pname, param);
  }

  public byte glIsTransformFeedback(int id) {
    return PFNGLISTRANSFORMFEEDBACKPROC.invoke(load("glIsTransformFeedback"), id);
  }

  public void glWaitVkSemaphoreNV(long vkSemaphore) {
    PFNGLWAITVKSEMAPHORENVPROC.invoke(load("glWaitVkSemaphoreNV"), vkSemaphore);
  }

  public void glMapBufferRangeEXT(int target, long offset, long length, int access) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glWeightubvARB(int size, MemorySegment weights) {
    PFNGLWEIGHTUBVARBPROC.invoke(load("glWeightubvARB"), size, weights);
  }

  public void glBlendFuncSeparateiOES(int buf, int srcRGB, int dstRGB, int srcAlpha, int dstAlpha) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDrawRangeElements(int mode, int start, int end, int count, int type, MemorySegment indices) {
    PFNGLDRAWRANGEELEMENTSPROC.invoke(load("glDrawRangeElements"), mode, start, end, count, type, indices);
  }

  public void glDrawTransformFeedbackStreamInstanced(int mode, int id, int stream, int instancecount) {
    PFNGLDRAWTRANSFORMFEEDBACKSTREAMINSTANCEDPROC.invoke(load("glDrawTransformFeedbackStreamInstanced"), mode, id, stream, instancecount);
  }

  public void glVDPAUFiniNV() {
    PFNGLVDPAUFININVPROC.invoke(load("glVDPAUFiniNV"));
  }

  public void glGetProgramEnvParameterIuivNV(int target, int index, MemorySegment params) {
    PFNGLGETPROGRAMENVPARAMETERIUIVNVPROC.invoke(load("glGetProgramEnvParameterIuivNV"), target, index, params);
  }

  public void glProgramUniformMatrix3x2dvEXT(int program, int location, int count, byte transpose, MemorySegment value) {
    PFNGLPROGRAMUNIFORMMATRIX3X2DVEXTPROC.invoke(load("glProgramUniformMatrix3x2dvEXT"), program, location, count, transpose, value);
  }

  public void glGetSamplerParameterIuivOES(int sampler, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribDivisorNV(int index, int divisor) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glWindowPos3sv(MemorySegment v) {
    PFNGLWINDOWPOS3SVPROC.invoke(load("glWindowPos3sv"), v);
  }

  public void glVertexP2uiv(int type, MemorySegment value) {
    PFNGLVERTEXP2UIVPROC.invoke(load("glVertexP2uiv"), type, value);
  }

  public void glUniformMatrix2x4fv(int location, int count, byte transpose, MemorySegment value) {
    PFNGLUNIFORMMATRIX2X4FVPROC.invoke(load("glUniformMatrix2x4fv"), location, count, transpose, value);
  }

  public void glTexCoord2fColor3fVertex3fSUN(float s, float t, float r, float g, float b, float x, float y, float z) {
    PFNGLTEXCOORD2FCOLOR3FVERTEX3FSUNPROC.invoke(load("glTexCoord2fColor3fVertex3fSUN"), s, t, r, g, b, x, y, z);
  }

  public void glProgramUniform3ui64vNV(int program, int location, int count, MemorySegment value) {
    PFNGLPROGRAMUNIFORM3UI64VNVPROC.invoke(load("glProgramUniform3ui64vNV"), program, location, count, value);
  }

  public void glProgramUniformHandleui64NV(int program, int location, long value) {
    PFNGLPROGRAMUNIFORMHANDLEUI64NVPROC.invoke(load("glProgramUniformHandleui64NV"), program, location, value);
  }

  public void glWindowPos3ivMESA(MemorySegment v) {
    PFNGLWINDOWPOS3IVMESAPROC.invoke(load("glWindowPos3ivMESA"), v);
  }

  public void glNamedFramebufferSamplePositionsfvAMD(int framebuffer, int numsamples, int pixelindex, MemorySegment values) {
    PFNGLNAMEDFRAMEBUFFERSAMPLEPOSITIONSFVAMDPROC.invoke(load("glNamedFramebufferSamplePositionsfvAMD"), framebuffer, numsamples, pixelindex, values);
  }

  public void glGetSamplerParameterIivOES(int sampler, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiDrawElementsIndirectAMD(int mode, int type, MemorySegment indirect, int primcount, int stride) {
    PFNGLMULTIDRAWELEMENTSINDIRECTAMDPROC.invoke(load("glMultiDrawElementsIndirectAMD"), mode, type, indirect, primcount, stride);
  }

  public void glClipPlanefOES(int plane, MemorySegment equation) {
    PFNGLCLIPPLANEFOESPROC.invoke(load("glClipPlanefOES"), plane, equation);
  }

  public void glInvalidateFramebuffer(int target, int numAttachments, MemorySegment attachments) {
    PFNGLINVALIDATEFRAMEBUFFERPROC.invoke(load("glInvalidateFramebuffer"), target, numAttachments, attachments);
  }

  public void glLGPUCopyImageSubDataNVX(int sourceGpu, int destinationGpuMask, int srcName, int srcTarget, int srcLevel, int srcX, int srxY, int srcZ, int dstName, int dstTarget, int dstLevel, int dstX, int dstY, int dstZ, int width, int height, int depth) {
    PFNGLLGPUCOPYIMAGESUBDATANVXPROC.invoke(load("glLGPUCopyImageSubDataNVX"), sourceGpu, destinationGpuMask, srcName, srcTarget, srcLevel, srcX, srxY, srcZ, dstName, dstTarget, dstLevel, dstX, dstY, dstZ, width, height, depth);
  }

  public void glVertexStream3dvATI(int stream, MemorySegment coords) {
    PFNGLVERTEXSTREAM3DVATIPROC.invoke(load("glVertexStream3dvATI"), stream, coords);
  }

  public void glMultiTexGenfvEXT(int texunit, int coord, int pname, MemorySegment params) {
    PFNGLMULTITEXGENFVEXTPROC.invoke(load("glMultiTexGenfvEXT"), texunit, coord, pname, params);
  }

  public void glWaitSemaphoreEXT(int semaphore, int numBufferBarriers, MemorySegment buffers, int numTextureBarriers, MemorySegment textures, MemorySegment srcLayouts) {
    PFNGLWAITSEMAPHOREEXTPROC.invoke(load("glWaitSemaphoreEXT"), semaphore, numBufferBarriers, buffers, numTextureBarriers, textures, srcLayouts);
  }

  public void glRenderGpuMaskNV(int mask) {
    PFNGLRENDERGPUMASKNVPROC.invoke(load("glRenderGpuMaskNV"), mask);
  }

  public void glColorTableParameterivSGI(int target, int pname, MemorySegment params) {
    PFNGLCOLORTABLEPARAMETERIVSGIPROC.invoke(load("glColorTableParameterivSGI"), target, pname, params);
  }

  public void glGetMultiTexEnvivEXT(int texunit, int target, int pname, MemorySegment params) {
    PFNGLGETMULTITEXENVIVEXTPROC.invoke(load("glGetMultiTexEnvivEXT"), texunit, target, pname, params);
  }

  public void glMakeNamedBufferNonResidentNV(int buffer) {
    PFNGLMAKENAMEDBUFFERNONRESIDENTNVPROC.invoke(load("glMakeNamedBufferNonResidentNV"), buffer);
  }

  public void glProgramLocalParametersI4ivNV(int target, int index, int count, MemorySegment params) {
    PFNGLPROGRAMLOCALPARAMETERSI4IVNVPROC.invoke(load("glProgramLocalParametersI4ivNV"), target, index, count, params);
  }

  public void glGetMultiTexGendvEXT(int texunit, int coord, int pname, MemorySegment params) {
    PFNGLGETMULTITEXGENDVEXTPROC.invoke(load("glGetMultiTexGendvEXT"), texunit, coord, pname, params);
  }

  public void glGlobalAlphaFactorusSUN(short factor) {
    PFNGLGLOBALALPHAFACTORUSSUNPROC.invoke(load("glGlobalAlphaFactorusSUN"), factor);
  }

  public void glClearDepthxOES(int depth) {
    PFNGLCLEARDEPTHXOESPROC.invoke(load("glClearDepthxOES"), depth);
  }

  public void glTextureParameterIuiv(int texture, int pname, MemorySegment params) {
    PFNGLTEXTUREPARAMETERIUIVPROC.invoke(load("glTextureParameterIuiv"), texture, pname, params);
  }

  public void glGetnColorTable(int target, int format, int type, int bufSize, MemorySegment table) {
    PFNGLGETNCOLORTABLEPROC.invoke(load("glGetnColorTable"), target, format, type, bufSize, table);
  }

  public void glVertexAttrib4dNV(int index, double x, double y, double z, double w) {
    PFNGLVERTEXATTRIB4DNVPROC.invoke(load("glVertexAttrib4dNV"), index, x, y, z, w);
  }

  public byte glIsBuffer(int buffer) {
    return PFNGLISBUFFERPROC.invoke(load("glIsBuffer"), buffer);
  }

  public void glTexCoord3hNV(short s, short t, short r) {
    PFNGLTEXCOORD3HNVPROC.invoke(load("glTexCoord3hNV"), s, t, r);
  }

  public void glTexSubImage2DEXT(int target, int level, int xoffset, int yoffset, int width, int height, int format, int type, MemorySegment pixels) {
    PFNGLTEXSUBIMAGE2DEXTPROC.invoke(load("glTexSubImage2DEXT"), target, level, xoffset, yoffset, width, height, format, type, pixels);
  }

  public void glTextureNormalEXT(int mode) {
    PFNGLTEXTURENORMALEXTPROC.invoke(load("glTextureNormalEXT"), mode);
  }

  public void glExtTexObjectStateOverrideiQCOM(int target, int pname, int param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMinSampleShadingARB(float value) {
    PFNGLMINSAMPLESHADINGARBPROC.invoke(load("glMinSampleShadingARB"), value);
  }

  public void glBufferStorage(int target, long size, MemorySegment data, int flags) {
    PFNGLBUFFERSTORAGEPROC.invoke(load("glBufferStorage"), target, size, data, flags);
  }

  public void glPointParameterfSGIS(int pname, float param) {
    PFNGLPOINTPARAMETERFSGISPROC.invoke(load("glPointParameterfSGIS"), pname, param);
  }

  public void glShaderOp1EXT(int op, int res, int arg1) {
    PFNGLSHADEROP1EXTPROC.invoke(load("glShaderOp1EXT"), op, res, arg1);
  }

  public void glViewportPositionWScaleNV(int index, float xcoeff, float ycoeff) {
    PFNGLVIEWPORTPOSITIONWSCALENVPROC.invoke(load("glViewportPositionWScaleNV"), index, xcoeff, ycoeff);
  }

  public void glTexCoord4bvOES(MemorySegment coords) {
    PFNGLTEXCOORD4BVOESPROC.invoke(load("glTexCoord4bvOES"), coords);
  }

  public void glTexImage3DEXT(int target, int level, int internalformat, int width, int height, int depth, int border, int format, int type, MemorySegment pixels) {
    PFNGLTEXIMAGE3DEXTPROC.invoke(load("glTexImage3DEXT"), target, level, internalformat, width, height, depth, border, format, type, pixels);
  }

  public void glUniform2uiEXT(int location, int v0, int v1) {
    PFNGLUNIFORM2UIEXTPROC.invoke(load("glUniform2uiEXT"), location, v0, v1);
  }

  public void glProgramUniform1uiEXT(int program, int location, int v0) {
    PFNGLPROGRAMUNIFORM1UIEXTPROC.invoke(load("glProgramUniform1uiEXT"), program, location, v0);
  }

  public void glVertexAttrib4NsvARB(int index, MemorySegment v) {
    PFNGLVERTEXATTRIB4NSVARBPROC.invoke(load("glVertexAttrib4NsvARB"), index, v);
  }

  public void glDrawTransformFeedbackEXT(int mode, int id) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexStorage3DMultisampleOES(int target, int samples, int internalformat, int width, int height, int depth, byte fixedsamplelocations) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetVariantPointervEXT(int id, int value, MemorySegment data) {
    PFNGLGETVARIANTPOINTERVEXTPROC.invoke(load("glGetVariantPointervEXT"), id, value, data);
  }

  public void glVertexAttribI3ivEXT(int index, MemorySegment v) {
    PFNGLVERTEXATTRIBI3IVEXTPROC.invoke(load("glVertexAttribI3ivEXT"), index, v);
  }

  public void glBlendEquationSeparateEXT(int modeRGB, int modeAlpha) {
    PFNGLBLENDEQUATIONSEPARATEEXTPROC.invoke(load("glBlendEquationSeparateEXT"), modeRGB, modeAlpha);
  }

  public void glMapVertexAttrib1dAPPLE(int index, int size, double u1, double u2, int stride, int order, MemorySegment points) {
    PFNGLMAPVERTEXATTRIB1DAPPLEPROC.invoke(load("glMapVertexAttrib1dAPPLE"), index, size, u1, u2, stride, order, points);
  }

  public void glSelectPerfMonitorCountersAMD(int monitor, byte enable, int group, int numCounters, MemorySegment counterList) {
    PFNGLSELECTPERFMONITORCOUNTERSAMDPROC.invoke(load("glSelectPerfMonitorCountersAMD"), monitor, enable, group, numCounters, counterList);
  }

  public void glProgramUniform4uivEXT(int program, int location, int count, MemorySegment value) {
    PFNGLPROGRAMUNIFORM4UIVEXTPROC.invoke(load("glProgramUniform4uivEXT"), program, location, count, value);
  }

  public void glColorP3ui(int type, int color) {
    PFNGLCOLORP3UIPROC.invoke(load("glColorP3ui"), type, color);
  }

  public void glCreateCommandListsNV(int n, MemorySegment lists) {
    PFNGLCREATECOMMANDLISTSNVPROC.invoke(load("glCreateCommandListsNV"), n, lists);
  }

  public MemorySegment glMapBuffer(int target, int access) {
    return PFNGLMAPBUFFERPROC.invoke(load("glMapBuffer"), target, access);
  }

  public void glPathCommandsNV(int path, int numCommands, MemorySegment commands, int numCoords, int coordType, MemorySegment coords) {
    PFNGLPATHCOMMANDSNVPROC.invoke(load("glPathCommandsNV"), path, numCommands, commands, numCoords, coordType, coords);
  }

  public void glViewportArrayvNV(int first, int count, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGenerateTextureMipmap(int texture) {
    PFNGLGENERATETEXTUREMIPMAPPROC.invoke(load("glGenerateTextureMipmap"), texture);
  }

  public void glVertexAttrib2dvNV(int index, MemorySegment v) {
    PFNGLVERTEXATTRIB2DVNVPROC.invoke(load("glVertexAttrib2dvNV"), index, v);
  }

  public void glEnableVertexAttribArrayARB(int index) {
    PFNGLENABLEVERTEXATTRIBARRAYARBPROC.invoke(load("glEnableVertexAttribArrayARB"), index);
  }

  public MemorySegment glMapNamedBufferEXT(int buffer, int access) {
    return PFNGLMAPNAMEDBUFFEREXTPROC.invoke(load("glMapNamedBufferEXT"), buffer, access);
  }

  public void glClipControl(int origin, int depth) {
    PFNGLCLIPCONTROLPROC.invoke(load("glClipControl"), origin, depth);
  }

  public int glBindLightParameterEXT(int light, int value) {
    return PFNGLBINDLIGHTPARAMETEREXTPROC.invoke(load("glBindLightParameterEXT"), light, value);
  }

  public void glWindowPos4fvMESA(MemorySegment v) {
    PFNGLWINDOWPOS4FVMESAPROC.invoke(load("glWindowPos4fvMESA"), v);
  }

  public void glBindBufferBase(int target, int index, int buffer) {
    PFNGLBINDBUFFERBASEPROC.invoke(load("glBindBufferBase"), target, index, buffer);
  }

  public void glDrawTexfOES(float x, float y, float z, float width, float height) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttrib3dvARB(int index, MemorySegment v) {
    PFNGLVERTEXATTRIB3DVARBPROC.invoke(load("glVertexAttrib3dvARB"), index, v);
  }

  public void glVertexAttribArrayObjectATI(int index, int size, int type, byte normalized, int stride, int buffer, int offset) {
    PFNGLVERTEXATTRIBARRAYOBJECTATIPROC.invoke(load("glVertexAttribArrayObjectATI"), index, size, type, normalized, stride, buffer, offset);
  }

  public void glGetCompressedTextureImageEXT(int texture, int target, int lod, MemorySegment img) {
    PFNGLGETCOMPRESSEDTEXTUREIMAGEEXTPROC.invoke(load("glGetCompressedTextureImageEXT"), texture, target, lod, img);
  }

  public byte glIsOcclusionQueryNV(int id) {
    return PFNGLISOCCLUSIONQUERYNVPROC.invoke(load("glIsOcclusionQueryNV"), id);
  }

  public void glGetInteger64vEXT(int pname, MemorySegment data) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glCopyTexSubImage3DOES(int target, int level, int xoffset, int yoffset, int zoffset, int x, int y, int width, int height) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFogCoordhNV(short fog) {
    PFNGLFOGCOORDHNVPROC.invoke(load("glFogCoordhNV"), fog);
  }

  public void glRenderbufferStorageEXT(int target, int internalformat, int width, int height) {
    PFNGLRENDERBUFFERSTORAGEEXTPROC.invoke(load("glRenderbufferStorageEXT"), target, internalformat, width, height);
  }

  public void glVertex4hvNV(MemorySegment v) {
    PFNGLVERTEX4HVNVPROC.invoke(load("glVertex4hvNV"), v);
  }

  public void glVertexArrayVertexBuffer(int vaobj, int bindingindex, int buffer, long offset, int stride) {
    PFNGLVERTEXARRAYVERTEXBUFFERPROC.invoke(load("glVertexArrayVertexBuffer"), vaobj, bindingindex, buffer, offset, stride);
  }

  public void glWeightPointerOES(int size, int type, int stride, MemorySegment pointer) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBlendEquationiARB(int buf, int mode) {
    PFNGLBLENDEQUATIONIARBPROC.invoke(load("glBlendEquationiARB"), buf, mode);
  }

  public int glCreateProgram() {
    return PFNGLCREATEPROGRAMPROC.invoke(load("glCreateProgram"));
  }

  public void glMultiTexImage1DEXT(int texunit, int target, int level, int internalformat, int width, int border, int format, int type, MemorySegment pixels) {
    PFNGLMULTITEXIMAGE1DEXTPROC.invoke(load("glMultiTexImage1DEXT"), texunit, target, level, internalformat, width, border, format, type, pixels);
  }

  public void glTexCoordFormatNV(int size, int type, int stride) {
    PFNGLTEXCOORDFORMATNVPROC.invoke(load("glTexCoordFormatNV"), size, type, stride);
  }

  public void glTextureBarrierNV() {
    PFNGLTEXTUREBARRIERNVPROC.invoke(load("glTextureBarrierNV"));
  }

  public void glTexStorageMem3DEXT(int target, int levels, int internalFormat, int width, int height, int depth, int memory, long offset) {
    PFNGLTEXSTORAGEMEM3DEXTPROC.invoke(load("glTexStorageMem3DEXT"), target, levels, internalFormat, width, height, depth, memory, offset);
  }

  public void glGetCompressedTextureImage(int texture, int level, int bufSize, MemorySegment pixels) {
    PFNGLGETCOMPRESSEDTEXTUREIMAGEPROC.invoke(load("glGetCompressedTextureImage"), texture, level, bufSize, pixels);
  }

  public void glProgramUniform3fv(int program, int location, int count, MemorySegment value) {
    PFNGLPROGRAMUNIFORM3FVPROC.invoke(load("glProgramUniform3fv"), program, location, count, value);
  }

  public void glProgramUniform3i64NV(int program, int location, long x, long y, long z) {
    PFNGLPROGRAMUNIFORM3I64NVPROC.invoke(load("glProgramUniform3i64NV"), program, location, x, y, z);
  }

  public void glDepthRangex(int n, int f) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexArrayVertexAttribOffsetEXT(int vaobj, int buffer, int index, int size, int type, byte normalized, int stride, long offset) {
    PFNGLVERTEXARRAYVERTEXATTRIBOFFSETEXTPROC.invoke(load("glVertexArrayVertexAttribOffsetEXT"), vaobj, buffer, index, size, type, normalized, stride, offset);
  }

  public void glProgramNamedParameter4fvNV(int id, int len, MemorySegment name, MemorySegment v) {
    PFNGLPROGRAMNAMEDPARAMETER4FVNVPROC.invoke(load("glProgramNamedParameter4fvNV"), id, len, name, v);
  }

  public void glSecondaryColor3iEXT(int red, int green, int blue) {
    PFNGLSECONDARYCOLOR3IEXTPROC.invoke(load("glSecondaryColor3iEXT"), red, green, blue);
  }

  public void glDetailTexFuncSGIS(int target, int n, MemorySegment points) {
    PFNGLDETAILTEXFUNCSGISPROC.invoke(load("glDetailTexFuncSGIS"), target, n, points);
  }

  public void glTexGenfOES(int coord, int pname, float param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glNamedBufferPageCommitmentEXT(int buffer, long offset, long size, byte commit) {
    PFNGLNAMEDBUFFERPAGECOMMITMENTEXTPROC.invoke(load("glNamedBufferPageCommitmentEXT"), buffer, offset, size, commit);
  }

  public void glGetFramebufferAttachmentParameterivOES(int target, int attachment, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDepthRangef(float n, float f) {
    PFNGLDEPTHRANGEFPROC.invoke(load("glDepthRangef"), n, f);
  }

  public void glProgramUniformHandleui64vNV(int program, int location, int count, MemorySegment values) {
    PFNGLPROGRAMUNIFORMHANDLEUI64VNVPROC.invoke(load("glProgramUniformHandleui64vNV"), program, location, count, values);
  }

  public void glVertexAttrib4ubNV(int index, byte x, byte y, byte z, byte w) {
    PFNGLVERTEXATTRIB4UBNVPROC.invoke(load("glVertexAttrib4ubNV"), index, x, y, z, w);
  }

  public void glBinormal3dvEXT(MemorySegment v) {
    PFNGLBINORMAL3DVEXTPROC.invoke(load("glBinormal3dvEXT"), v);
  }

  public long glGetTextureSamplerHandleARB(int texture, int sampler) {
    return PFNGLGETTEXTURESAMPLERHANDLEARBPROC.invoke(load("glGetTextureSamplerHandleARB"), texture, sampler);
  }

  public void glGetFenceivNV(int fence, int pname, MemorySegment params) {
    PFNGLGETFENCEIVNVPROC.invoke(load("glGetFenceivNV"), fence, pname, params);
  }

  public void glUniform4f(int location, float v0, float v1, float v2, float v3) {
    PFNGLUNIFORM4FPROC.invoke(load("glUniform4f"), location, v0, v1, v2, v3);
  }

  public void glUniform4i(int location, int v0, int v1, int v2, int v3) {
    PFNGLUNIFORM4IPROC.invoke(load("glUniform4i"), location, v0, v1, v2, v3);
  }

  public void glPauseTransformFeedbackNV() {
    PFNGLPAUSETRANSFORMFEEDBACKNVPROC.invoke(load("glPauseTransformFeedbackNV"));
  }

  public void glUniform4i64ARB(int location, long x, long y, long z, long w) {
    PFNGLUNIFORM4I64ARBPROC.invoke(load("glUniform4i64ARB"), location, x, y, z, w);
  }

  public void glVDPAUMapSurfacesNV(int numSurfaces, MemorySegment surfaces) {
    PFNGLVDPAUMAPSURFACESNVPROC.invoke(load("glVDPAUMapSurfacesNV"), numSurfaces, surfaces);
  }

  public int glGetFragDataIndex(int program, MemorySegment name) {
    return PFNGLGETFRAGDATAINDEXPROC.invoke(load("glGetFragDataIndex"), program, name);
  }

  public void glGetnUniformivARB(int program, int location, int bufSize, MemorySegment params) {
    PFNGLGETNUNIFORMIVARBPROC.invoke(load("glGetnUniformivARB"), program, location, bufSize, params);
  }

  public void glDebugMessageInsert(int source, int type, int id, int severity, int length, MemorySegment buf) {
    PFNGLDEBUGMESSAGEINSERTPROC.invoke(load("glDebugMessageInsert"), source, type, id, severity, length, buf);
  }

  public void glPixelTexGenSGIX(int mode) {
    PFNGLPIXELTEXGENSGIXPROC.invoke(load("glPixelTexGenSGIX"), mode);
  }

  public void glSecondaryColor3bvEXT(MemorySegment v) {
    PFNGLSECONDARYCOLOR3BVEXTPROC.invoke(load("glSecondaryColor3bvEXT"), v);
  }

  public void glAlphaFragmentOp1ATI(int op, int dst, int dstMod, int arg1, int arg1Rep, int arg1Mod) {
    PFNGLALPHAFRAGMENTOP1ATIPROC.invoke(load("glAlphaFragmentOp1ATI"), op, dst, dstMod, arg1, arg1Rep, arg1Mod);
  }

  public void glProgramUniform3dv(int program, int location, int count, MemorySegment value) {
    PFNGLPROGRAMUNIFORM3DVPROC.invoke(load("glProgramUniform3dv"), program, location, count, value);
  }

  public int glBindTexGenParameterEXT(int unit, int coord, int value) {
    return PFNGLBINDTEXGENPARAMETEREXTPROC.invoke(load("glBindTexGenParameterEXT"), unit, coord, value);
  }

  public void glColorTableEXT(int target, int internalFormat, int width, int format, int type, MemorySegment table) {
    PFNGLCOLORTABLEEXTPROC.invoke(load("glColorTableEXT"), target, internalFormat, width, format, type, table);
  }

  public void glUniform3iARB(int location, int v0, int v1, int v2) {
    PFNGLUNIFORM3IARBPROC.invoke(load("glUniform3iARB"), location, v0, v1, v2);
  }

  public void glEnableiEXT(int target, int index) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexGenivOES(int coord, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetProgramiv(int program, int pname, MemorySegment params) {
    PFNGLGETPROGRAMIVPROC.invoke(load("glGetProgramiv"), program, pname, params);
  }

  public void glLabelObjectEXT(int type, int object, int length, MemorySegment label) {
    PFNGLLABELOBJECTEXTPROC.invoke(load("glLabelObjectEXT"), type, object, length, label);
  }

  public void glGetShaderPrecisionFormat(int shadertype, int precisiontype, MemorySegment range, MemorySegment precision) {
    PFNGLGETSHADERPRECISIONFORMATPROC.invoke(load("glGetShaderPrecisionFormat"), shadertype, precisiontype, range, precision);
  }

  public void glPopDebugGroup() {
    PFNGLPOPDEBUGGROUPPROC.invoke(load("glPopDebugGroup"));
  }

  public void glSecondaryColor3ubEXT(byte red, byte green, byte blue) {
    PFNGLSECONDARYCOLOR3UBEXTPROC.invoke(load("glSecondaryColor3ubEXT"), red, green, blue);
  }

  public void glVertexAttrib3svARB(int index, MemorySegment v) {
    PFNGLVERTEXATTRIB3SVARBPROC.invoke(load("glVertexAttrib3svARB"), index, v);
  }

  public void glProgramUniform3ui64NV(int program, int location, long x, long y, long z) {
    PFNGLPROGRAMUNIFORM3UI64NVPROC.invoke(load("glProgramUniform3ui64NV"), program, location, x, y, z);
  }

  public byte glIsNamedBufferResidentNV(int buffer) {
    return PFNGLISNAMEDBUFFERRESIDENTNVPROC.invoke(load("glIsNamedBufferResidentNV"), buffer);
  }

  public void glShadingRateCombinerOpsEXT(int combinerOp0, int combinerOp1) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetnUniformiv(int program, int location, int bufSize, MemorySegment params) {
    PFNGLGETNUNIFORMIVPROC.invoke(load("glGetnUniformiv"), program, location, bufSize, params);
  }

  public void glProgramLocalParameter4dvARB(int target, int index, MemorySegment params) {
    PFNGLPROGRAMLOCALPARAMETER4DVARBPROC.invoke(load("glProgramLocalParameter4dvARB"), target, index, params);
  }

  public void glProgramUniform2fvEXT(int program, int location, int count, MemorySegment value) {
    PFNGLPROGRAMUNIFORM2FVEXTPROC.invoke(load("glProgramUniform2fvEXT"), program, location, count, value);
  }

  public void glVertexStream4fATI(int stream, float x, float y, float z, float w) {
    PFNGLVERTEXSTREAM4FATIPROC.invoke(load("glVertexStream4fATI"), stream, x, y, z, w);
  }

  public void glColorMaskiEXT(int index, byte r, byte g, byte b, byte a) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexCoord4xvOES(MemorySegment coords) {
    PFNGLTEXCOORD4XVOESPROC.invoke(load("glTexCoord4xvOES"), coords);
  }

  public void glGetQueryObjectui64v(int id, int pname, MemorySegment params) {
    PFNGLGETQUERYOBJECTUI64VPROC.invoke(load("glGetQueryObjectui64v"), id, pname, params);
  }

  public void glNamedRenderbufferStorage(int renderbuffer, int internalformat, int width, int height) {
    PFNGLNAMEDRENDERBUFFERSTORAGEPROC.invoke(load("glNamedRenderbufferStorage"), renderbuffer, internalformat, width, height);
  }

  public void glUnmapObjectBufferATI(int buffer) {
    PFNGLUNMAPOBJECTBUFFERATIPROC.invoke(load("glUnmapObjectBufferATI"), buffer);
  }

  public void glVertexStream3dATI(int stream, double x, double y, double z) {
    PFNGLVERTEXSTREAM3DATIPROC.invoke(load("glVertexStream3dATI"), stream, x, y, z);
  }

  public void glMaterialx(int face, int pname, int param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniform2ivARB(int location, int count, MemorySegment value) {
    PFNGLUNIFORM2IVARBPROC.invoke(load("glUniform2ivARB"), location, count, value);
  }

  public void glListParameterfvSGIX(int list, int pname, MemorySegment params) {
    PFNGLLISTPARAMETERFVSGIXPROC.invoke(load("glListParameterfvSGIX"), list, pname, params);
  }

  public void glDeleteProgramPipelines(int n, MemorySegment pipelines) {
    PFNGLDELETEPROGRAMPIPELINESPROC.invoke(load("glDeleteProgramPipelines"), n, pipelines);
  }

  public void glTexEstimateMotionRegionsQCOM(int ref, int target, int output, int mask) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glSampleMapATI(int dst, int interp, int swizzle) {
    PFNGLSAMPLEMAPATIPROC.invoke(load("glSampleMapATI"), dst, interp, swizzle);
  }

  public void glFramebufferParameteriMESA(int target, int pname, int param) {
    PFNGLFRAMEBUFFERPARAMETERIMESAPROC.invoke(load("glFramebufferParameteriMESA"), target, pname, param);
  }

  public void glViewportIndexedfOES(int index, float x, float y, float w, float h) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramNamedParameter4fNV(int id, int len, MemorySegment name, float x, float y, float z, float w) {
    PFNGLPROGRAMNAMEDPARAMETER4FNVPROC.invoke(load("glProgramNamedParameter4fNV"), id, len, name, x, y, z, w);
  }

  public void glConvolutionParameteriEXT(int target, int pname, int params) {
    PFNGLCONVOLUTIONPARAMETERIEXTPROC.invoke(load("glConvolutionParameteriEXT"), target, pname, params);
  }

  public void glAccumxOES(int op, int value) {
    PFNGLACCUMXOESPROC.invoke(load("glAccumxOES"), op, value);
  }

  public void glProgramUniform3iv(int program, int location, int count, MemorySegment value) {
    PFNGLPROGRAMUNIFORM3IVPROC.invoke(load("glProgramUniform3iv"), program, location, count, value);
  }

  public void glGetUniformivARB(int programObj, int location, MemorySegment params) {
    opengl.windows.PFNGLGETUNIFORMIVARBPROC.invoke(load("glGetUniformivARB"), programObj, location, params);
  }

  public byte glIsProgram(int program) {
    return PFNGLISPROGRAMPROC.invoke(load("glIsProgram"), program);
  }

  public void glGetDoublei_vEXT(int pname, int index, MemorySegment params) {
    PFNGLGETDOUBLEI_VEXTPROC.invoke(load("glGetDoublei_vEXT"), pname, index, params);
  }

  public void glUniformui64vNV(int location, int count, MemorySegment value) {
    PFNGLUNIFORMUI64VNVPROC.invoke(load("glUniformui64vNV"), location, count, value);
  }

  public byte glIsVertexArrayAPPLE(int array) {
    return PFNGLISVERTEXARRAYAPPLEPROC.invoke(load("glIsVertexArrayAPPLE"), array);
  }

  public void glGetProgramPipelineInfoLog(int pipeline, int bufSize, MemorySegment length, MemorySegment infoLog) {
    PFNGLGETPROGRAMPIPELINEINFOLOGPROC.invoke(load("glGetProgramPipelineInfoLog"), pipeline, bufSize, length, infoLog);
  }

  public void glLoadMatrixxOES(MemorySegment m) {
    PFNGLLOADMATRIXXOESPROC.invoke(load("glLoadMatrixxOES"), m);
  }

  public void glGetPathTexGenfvNV(int texCoordSet, int pname, MemorySegment value) {
    PFNGLGETPATHTEXGENFVNVPROC.invoke(load("glGetPathTexGenfvNV"), texCoordSet, pname, value);
  }

  public void glGetPathCoordsNV(int path, MemorySegment coords) {
    PFNGLGETPATHCOORDSNVPROC.invoke(load("glGetPathCoordsNV"), path, coords);
  }

  public void glVertexAttribI4uivEXT(int index, MemorySegment v) {
    PFNGLVERTEXATTRIBI4UIVEXTPROC.invoke(load("glVertexAttribI4uivEXT"), index, v);
  }

  public void glCopyPathNV(int resultPath, int srcPath) {
    PFNGLCOPYPATHNVPROC.invoke(load("glCopyPathNV"), resultPath, srcPath);
  }

  public void glSamplePatternEXT(int pattern) {
    PFNGLSAMPLEPATTERNEXTPROC.invoke(load("glSamplePatternEXT"), pattern);
  }

  public void glVertexAttribL2ui64vNV(int index, MemorySegment v) {
    PFNGLVERTEXATTRIBL2UI64VNVPROC.invoke(load("glVertexAttribL2ui64vNV"), index, v);
  }

  public void glGetMapxvOES(int target, int query, MemorySegment v) {
    PFNGLGETMAPXVOESPROC.invoke(load("glGetMapxvOES"), target, query, v);
  }

  public void glShadingRateImageBarrierNV(byte synchronize) {
    PFNGLSHADINGRATEIMAGEBARRIERNVPROC.invoke(load("glShadingRateImageBarrierNV"), synchronize);
  }

  public void glApplyFramebufferAttachmentCMAAINTEL() {
    PFNGLAPPLYFRAMEBUFFERATTACHMENTCMAAINTELPROC.invoke(load("glApplyFramebufferAttachmentCMAAINTEL"));
  }

  public void glProgramUniform2ui64NV(int program, int location, long x, long y) {
    PFNGLPROGRAMUNIFORM2UI64NVPROC.invoke(load("glProgramUniform2ui64NV"), program, location, x, y);
  }

  public void glBindProgramARB(int target, int program) {
    PFNGLBINDPROGRAMARBPROC.invoke(load("glBindProgramARB"), target, program);
  }

  public void glReplacementCodeuiNormal3fVertex3fSUN(int rc, float nx, float ny, float nz, float x, float y, float z) {
    PFNGLREPLACEMENTCODEUINORMAL3FVERTEX3FSUNPROC.invoke(load("glReplacementCodeuiNormal3fVertex3fSUN"), rc, nx, ny, nz, x, y, z);
  }

  public void glNamedBufferSubDataEXT(int buffer, long offset, long size, MemorySegment data) {
    PFNGLNAMEDBUFFERSUBDATAEXTPROC.invoke(load("glNamedBufferSubDataEXT"), buffer, offset, size, data);
  }

  public void glClearBufferfv(int buffer, int drawbuffer, MemorySegment value) {
    PFNGLCLEARBUFFERFVPROC.invoke(load("glClearBufferfv"), buffer, drawbuffer, value);
  }

  public void glGetSamplerParameterfv(int sampler, int pname, MemorySegment params) {
    PFNGLGETSAMPLERPARAMETERFVPROC.invoke(load("glGetSamplerParameterfv"), sampler, pname, params);
  }

  public void glClearBufferfi(int buffer, int drawbuffer, float depth, int stencil) {
    PFNGLCLEARBUFFERFIPROC.invoke(load("glClearBufferfi"), buffer, drawbuffer, depth, stencil);
  }

  public void glGetFragmentLightfvSGIX(int light, int pname, MemorySegment params) {
    PFNGLGETFRAGMENTLIGHTFVSGIXPROC.invoke(load("glGetFragmentLightfvSGIX"), light, pname, params);
  }

  public void glNormal3x(int nx, int ny, int nz) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDrawRangeElementsBaseVertexOES(int mode, int start, int end, int count, int type, MemorySegment indices, int basevertex) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public int glAsyncCopyImageSubDataNVX(int waitSemaphoreCount, MemorySegment waitSemaphoreArray, MemorySegment waitValueArray, int srcGpu, int dstGpuMask, int srcName, int srcTarget, int srcLevel, int srcX, int srcY, int srcZ, int dstName, int dstTarget, int dstLevel, int dstX, int dstY, int dstZ, int srcWidth, int srcHeight, int srcDepth, int signalSemaphoreCount, MemorySegment signalSemaphoreArray, MemorySegment signalValueArray) {
    return PFNGLASYNCCOPYIMAGESUBDATANVXPROC.invoke(load("glAsyncCopyImageSubDataNVX"), waitSemaphoreCount, waitSemaphoreArray, waitValueArray, srcGpu, dstGpuMask, srcName, srcTarget, srcLevel, srcX, srcY, srcZ, dstName, dstTarget, dstLevel, dstX, dstY, dstZ, srcWidth, srcHeight, srcDepth, signalSemaphoreCount, signalSemaphoreArray, signalValueArray);
  }

  public void glClearBufferiv(int buffer, int drawbuffer, MemorySegment value) {
    PFNGLCLEARBUFFERIVPROC.invoke(load("glClearBufferiv"), buffer, drawbuffer, value);
  }

  public void glTangent3bEXT(byte tx, byte ty, byte tz) {
    PFNGLTANGENT3BEXTPROC.invoke(load("glTangent3bEXT"), tx, ty, tz);
  }

  public void glCopyNamedBufferSubData(int readBuffer, int writeBuffer, long readOffset, long writeOffset, long size) {
    PFNGLCOPYNAMEDBUFFERSUBDATAPROC.invoke(load("glCopyNamedBufferSubData"), readBuffer, writeBuffer, readOffset, writeOffset, size);
  }

  public void glDeleteTransformFeedbacks(int n, MemorySegment ids) {
    PFNGLDELETETRANSFORMFEEDBACKSPROC.invoke(load("glDeleteTransformFeedbacks"), n, ids);
  }

  public void glProgramEnvParameterI4uivNV(int target, int index, MemorySegment params) {
    PFNGLPROGRAMENVPARAMETERI4UIVNVPROC.invoke(load("glProgramEnvParameterI4uivNV"), target, index, params);
  }

  public void glCompressedTexSubImage2D(int target, int level, int xoffset, int yoffset, int width, int height, int format, int imageSize, MemorySegment data) {
    PFNGLCOMPRESSEDTEXSUBIMAGE2DPROC.invoke(load("glCompressedTexSubImage2D"), target, level, xoffset, yoffset, width, height, format, imageSize, data);
  }

  public void glSampleMaski(int maskNumber, int mask) {
    PFNGLSAMPLEMASKIPROC.invoke(load("glSampleMaski"), maskNumber, mask);
  }

  public void glMatrixPushEXT(int mode) {
    PFNGLMATRIXPUSHEXTPROC.invoke(load("glMatrixPushEXT"), mode);
  }

  public void glVertexArrayVertexAttribBindingEXT(int vaobj, int attribindex, int bindingindex) {
    PFNGLVERTEXARRAYVERTEXATTRIBBINDINGEXTPROC.invoke(load("glVertexArrayVertexAttribBindingEXT"), vaobj, attribindex, bindingindex);
  }

  public void glEGLImageTargetTexStorageEXT(int target, MemorySegment image, MemorySegment attrib_list) {
    PFNGLEGLIMAGETARGETTEXSTORAGEEXTPROC.invoke(load("glEGLImageTargetTexStorageEXT"), target, image, attrib_list);
  }

  public void glGetNamedStringivARB(int namelen, MemorySegment name, int pname, MemorySegment params) {
    PFNGLGETNAMEDSTRINGIVARBPROC.invoke(load("glGetNamedStringivARB"), namelen, name, pname, params);
  }

  public void glFinishFenceNV(int fence) {
    PFNGLFINISHFENCENVPROC.invoke(load("glFinishFenceNV"), fence);
  }

  public void glGetTextureParameterfv(int texture, int pname, MemorySegment params) {
    PFNGLGETTEXTUREPARAMETERFVPROC.invoke(load("glGetTextureParameterfv"), texture, pname, params);
  }

  public void glDrawElementsInstancedANGLE(int mode, int count, int type, MemorySegment indices, int primcount) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttrib4sv(int index, MemorySegment v) {
    PFNGLVERTEXATTRIB4SVPROC.invoke(load("glVertexAttrib4sv"), index, v);
  }

  public void glBindVertexBuffers(int first, int count, MemorySegment buffers, MemorySegment offsets, MemorySegment strides) {
    PFNGLBINDVERTEXBUFFERSPROC.invoke(load("glBindVertexBuffers"), first, count, buffers, offsets, strides);
  }

  public void glVertexAttribI4bv(int index, MemorySegment v) {
    PFNGLVERTEXATTRIBI4BVPROC.invoke(load("glVertexAttribI4bv"), index, v);
  }

  public void glDeletePerfMonitorsAMD(int n, MemorySegment monitors) {
    PFNGLDELETEPERFMONITORSAMDPROC.invoke(load("glDeletePerfMonitorsAMD"), n, monitors);
  }

  public void glGetSamplerParameteriv(int sampler, int pname, MemorySegment params) {
    PFNGLGETSAMPLERPARAMETERIVPROC.invoke(load("glGetSamplerParameteriv"), sampler, pname, params);
  }

  public void glCompressedTexSubImage1D(int target, int level, int xoffset, int width, int format, int imageSize, MemorySegment data) {
    PFNGLCOMPRESSEDTEXSUBIMAGE1DPROC.invoke(load("glCompressedTexSubImage1D"), target, level, xoffset, width, format, imageSize, data);
  }

  public void glMultiTexCoord3dvARB(int target, MemorySegment v) {
    PFNGLMULTITEXCOORD3DVARBPROC.invoke(load("glMultiTexCoord3dvARB"), target, v);
  }

  public void glConvolutionParameteri(int target, int pname, int params) {
    PFNGLCONVOLUTIONPARAMETERIEXTPROC.invoke(load("glConvolutionParameteri"), target, pname, params);
  }

  public void glBindProgramPipeline(int pipeline) {
    PFNGLBINDPROGRAMPIPELINEPROC.invoke(load("glBindProgramPipeline"), pipeline);
  }

  public void glConvolutionParameterf(int target, int pname, float params) {
    PFNGLCONVOLUTIONPARAMETERFEXTPROC.invoke(load("glConvolutionParameterf"), target, pname, params);
  }

  public void glScissorIndexedvOES(int index, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBindTextureEXT(int target, int texture) {
    PFNGLBINDTEXTUREEXTPROC.invoke(load("glBindTextureEXT"), target, texture);
  }

  public void glGetUniformi64vNV(int program, int location, MemorySegment params) {
    PFNGLGETUNIFORMI64VNVPROC.invoke(load("glGetUniformi64vNV"), program, location, params);
  }

  public void glDrawElementsInstancedBaseVertex(int mode, int count, int type, MemorySegment indices, int instancecount, int basevertex) {
    PFNGLDRAWELEMENTSINSTANCEDBASEVERTEXPROC.invoke(load("glDrawElementsInstancedBaseVertex"), mode, count, type, indices, instancecount, basevertex);
  }

  public void glVertexAttrib3hNV(int index, short x, short y, short z) {
    PFNGLVERTEXATTRIB3HNVPROC.invoke(load("glVertexAttrib3hNV"), index, x, y, z);
  }

  public void glGetInvariantFloatvEXT(int id, int value, MemorySegment data) {
    PFNGLGETINVARIANTFLOATVEXTPROC.invoke(load("glGetInvariantFloatvEXT"), id, value, data);
  }

  public void glCreateQueries(int target, int n, MemorySegment ids) {
    PFNGLCREATEQUERIESPROC.invoke(load("glCreateQueries"), target, n, ids);
  }

  public void glCreateTransformFeedbacks(int n, MemorySegment ids) {
    PFNGLCREATETRANSFORMFEEDBACKSPROC.invoke(load("glCreateTransformFeedbacks"), n, ids);
  }

  public void glEnableVertexAttribArray(int index) {
    PFNGLENABLEVERTEXATTRIBARRAYPROC.invoke(load("glEnableVertexAttribArray"), index);
  }

  public void glBeginTransformFeedbackNV(int primitiveMode) {
    PFNGLBEGINTRANSFORMFEEDBACKNVPROC.invoke(load("glBeginTransformFeedbackNV"), primitiveMode);
  }

  public void glProgramUniformHandleui64ARB(int program, int location, long value) {
    PFNGLPROGRAMUNIFORMHANDLEUI64ARBPROC.invoke(load("glProgramUniformHandleui64ARB"), program, location, value);
  }

  public void glImageTransformParameterfvHP(int target, int pname, MemorySegment params) {
    PFNGLIMAGETRANSFORMPARAMETERFVHPPROC.invoke(load("glImageTransformParameterfvHP"), target, pname, params);
  }

  public void glClearBufferData(int target, int internalformat, int format, int type, MemorySegment data) {
    PFNGLCLEARBUFFERDATAPROC.invoke(load("glClearBufferData"), target, internalformat, format, type, data);
  }

  public void glWindowPos2fARB(float x, float y) {
    PFNGLWINDOWPOS2FARBPROC.invoke(load("glWindowPos2fARB"), x, y);
  }

  public void glGetActiveAttribARB(int programObj, int index, int maxLength, MemorySegment length, MemorySegment size, MemorySegment type, MemorySegment name) {
    opengl.windows.PFNGLGETACTIVEATTRIBARBPROC.invoke(load("glGetActiveAttribARB"), programObj, index, maxLength, length, size, type, name);
  }

  public void glUniform1fvARB(int location, int count, MemorySegment value) {
    PFNGLUNIFORM1FVARBPROC.invoke(load("glUniform1fvARB"), location, count, value);
  }

  public long glGetImageHandleARB(int texture, int level, byte layered, int layer, int format) {
    return PFNGLGETIMAGEHANDLEARBPROC.invoke(load("glGetImageHandleARB"), texture, level, layered, layer, format);
  }

  public void glGetFloati_vNV(int target, int index, MemorySegment data) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glCompressedTexSubImage3D(int target, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int format, int imageSize, MemorySegment data) {
    PFNGLCOMPRESSEDTEXSUBIMAGE3DPROC.invoke(load("glCompressedTexSubImage3D"), target, level, xoffset, yoffset, zoffset, width, height, depth, format, imageSize, data);
  }

  public void glSwizzleEXT(int res, int in, int outX, int outY, int outZ, int outW) {
    PFNGLSWIZZLEEXTPROC.invoke(load("glSwizzleEXT"), res, in, outX, outY, outZ, outW);
  }

  public void glCopyBufferSubData(int readTarget, int writeTarget, long readOffset, long writeOffset, long size) {
    PFNGLCOPYBUFFERSUBDATAPROC.invoke(load("glCopyBufferSubData"), readTarget, writeTarget, readOffset, writeOffset, size);
  }

  public void glMatrixMultfEXT(int mode, MemorySegment m) {
    PFNGLMATRIXMULTFEXTPROC.invoke(load("glMatrixMultfEXT"), mode, m);
  }

  public void glUniform2ui64vNV(int location, int count, MemorySegment value) {
    PFNGLUNIFORM2UI64VNVPROC.invoke(load("glUniform2ui64vNV"), location, count, value);
  }

  public void glProgramUniform2uiv(int program, int location, int count, MemorySegment value) {
    PFNGLPROGRAMUNIFORM2UIVPROC.invoke(load("glProgramUniform2uiv"), program, location, count, value);
  }

  public void glProgramUniformMatrix4x3dvEXT(int program, int location, int count, byte transpose, MemorySegment value) {
    PFNGLPROGRAMUNIFORMMATRIX4X3DVEXTPROC.invoke(load("glProgramUniformMatrix4x3dvEXT"), program, location, count, transpose, value);
  }

  public void glDispatchComputeIndirect(long indirect) {
    PFNGLDISPATCHCOMPUTEINDIRECTPROC.invoke(load("glDispatchComputeIndirect"), indirect);
  }

  public void glGetTextureParameteriv(int texture, int pname, MemorySegment params) {
    PFNGLGETTEXTUREPARAMETERIVPROC.invoke(load("glGetTextureParameteriv"), texture, pname, params);
  }

  public void glMultiTexCoord2bOES(int texture, byte s, byte t) {
    PFNGLMULTITEXCOORD2BOESPROC.invoke(load("glMultiTexCoord2bOES"), texture, s, t);
  }

  public void glMultiTexCoord2xOES(int texture, int s, int t) {
    PFNGLMULTITEXCOORD2XOESPROC.invoke(load("glMultiTexCoord2xOES"), texture, s, t);
  }

  public void glGenerateMultiTexMipmapEXT(int texunit, int target) {
    PFNGLGENERATEMULTITEXMIPMAPEXTPROC.invoke(load("glGenerateMultiTexMipmapEXT"), texunit, target);
  }

  public void glStencilThenCoverFillPathNV(int path, int fillMode, int mask, int coverMode) {
    PFNGLSTENCILTHENCOVERFILLPATHNVPROC.invoke(load("glStencilThenCoverFillPathNV"), path, fillMode, mask, coverMode);
  }

  public void glUniform2fvARB(int location, int count, MemorySegment value) {
    PFNGLUNIFORM2FVARBPROC.invoke(load("glUniform2fvARB"), location, count, value);
  }

  public void glVertexArrayFogCoordOffsetEXT(int vaobj, int buffer, int type, int stride, long offset) {
    PFNGLVERTEXARRAYFOGCOORDOFFSETEXTPROC.invoke(load("glVertexArrayFogCoordOffsetEXT"), vaobj, buffer, type, stride, offset);
  }

  public void glClearDepthdNV(double depth) {
    PFNGLCLEARDEPTHDNVPROC.invoke(load("glClearDepthdNV"), depth);
  }

  public void glGetQueryObjectuiv(int id, int pname, MemorySegment params) {
    PFNGLGETQUERYOBJECTUIVPROC.invoke(load("glGetQueryObjectuiv"), id, pname, params);
  }

  public void glExtGetTexLevelParameterivQCOM(int texture, int face, int level, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glPassTexCoordATI(int dst, int coord, int swizzle) {
    PFNGLPASSTEXCOORDATIPROC.invoke(load("glPassTexCoordATI"), dst, coord, swizzle);
  }

  public void glMatrixLoadfEXT(int mode, MemorySegment m) {
    PFNGLMATRIXLOADFEXTPROC.invoke(load("glMatrixLoadfEXT"), mode, m);
  }

  public void glDeleteAsyncMarkersSGIX(int marker, int range) {
    PFNGLDELETEASYNCMARKERSSGIXPROC.invoke(load("glDeleteAsyncMarkersSGIX"), marker, range);
  }

  public void glDrawMeshArraysSUN(int mode, int first, int count, int width) {
    PFNGLDRAWMESHARRAYSSUNPROC.invoke(load("glDrawMeshArraysSUN"), mode, first, count, width);
  }

  public void glGetVertexAttribPointervNV(int index, int pname, MemorySegment pointer) {
    PFNGLGETVERTEXATTRIBPOINTERVNVPROC.invoke(load("glGetVertexAttribPointervNV"), index, pname, pointer);
  }

  public void glGetnPixelMapusvARB(int map, int bufSize, MemorySegment values) {
    PFNGLGETNPIXELMAPUSVARBPROC.invoke(load("glGetnPixelMapusvARB"), map, bufSize, values);
  }

  public int glGetInstrumentsSGIX() {
    return PFNGLGETINSTRUMENTSSGIXPROC.invoke(load("glGetInstrumentsSGIX"));
  }

  public void glGenRenderbuffers(int n, MemorySegment renderbuffers) {
    PFNGLGENRENDERBUFFERSPROC.invoke(load("glGenRenderbuffers"), n, renderbuffers);
  }

  public byte glIsAsyncMarkerSGIX(int marker) {
    return PFNGLISASYNCMARKERSGIXPROC.invoke(load("glIsAsyncMarkerSGIX"), marker);
  }

  public void glVertexAttribs3fvNV(int index, int count, MemorySegment v) {
    PFNGLVERTEXATTRIBS3FVNVPROC.invoke(load("glVertexAttribs3fvNV"), index, count, v);
  }

  public void glVertexAttrib1sNV(int index, short x) {
    PFNGLVERTEXATTRIB1SNVPROC.invoke(load("glVertexAttrib1sNV"), index, x);
  }

  public void glTexParameterxv(int target, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniformMatrix3x4fvEXT(int program, int location, int count, byte transpose, MemorySegment value) {
    PFNGLPROGRAMUNIFORMMATRIX3X4FVEXTPROC.invoke(load("glProgramUniformMatrix3x4fvEXT"), program, location, count, transpose, value);
  }

  public void glSecondaryColor3fvEXT(MemorySegment v) {
    PFNGLSECONDARYCOLOR3FVEXTPROC.invoke(load("glSecondaryColor3fvEXT"), v);
  }

  public void glBlendEquationEXT(int mode) {
    PFNGLBLENDEQUATIONEXTPROC.invoke(load("glBlendEquationEXT"), mode);
  }

  public void glBeginPerfQueryINTEL(int queryHandle) {
    PFNGLBEGINPERFQUERYINTELPROC.invoke(load("glBeginPerfQueryINTEL"), queryHandle);
  }

  public void glFlushVertexArrayRangeAPPLE(int length, MemorySegment pointer) {
    PFNGLFLUSHVERTEXARRAYRANGEAPPLEPROC.invoke(load("glFlushVertexArrayRangeAPPLE"), length, pointer);
  }

  public void glProgramUniform2ui(int program, int location, int v0, int v1) {
    PFNGLPROGRAMUNIFORM2UIPROC.invoke(load("glProgramUniform2ui"), program, location, v0, v1);
  }

  public void glBlendEquationSeparateiEXT(int buf, int modeRGB, int modeAlpha) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMakeImageHandleResidentNV(long handle, int access) {
    PFNGLMAKEIMAGEHANDLERESIDENTNVPROC.invoke(load("glMakeImageHandleResidentNV"), handle, access);
  }

  public void glGetFloatIndexedvEXT(int target, int index, MemorySegment data) {
    PFNGLGETFLOATINDEXEDVEXTPROC.invoke(load("glGetFloatIndexedvEXT"), target, index, data);
  }

  public void glMultiTexCoord3sARB(int target, short s, short t, short r) {
    PFNGLMULTITEXCOORD3SARBPROC.invoke(load("glMultiTexCoord3sARB"), target, s, t, r);
  }

  public void glGetSamplerParameterIuivEXT(int sampler, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glInterpolatePathsNV(int resultPath, int pathA, int pathB, float weight) {
    PFNGLINTERPOLATEPATHSNVPROC.invoke(load("glInterpolatePathsNV"), resultPath, pathA, pathB, weight);
  }

  public void glUniform4fv(int location, int count, MemorySegment value) {
    PFNGLUNIFORM4FVPROC.invoke(load("glUniform4fv"), location, count, value);
  }

  public void glVertexAttribs2dvNV(int index, int count, MemorySegment v) {
    PFNGLVERTEXATTRIBS2DVNVPROC.invoke(load("glVertexAttribs2dvNV"), index, count, v);
  }

  public void glBindBuffersRange(int target, int first, int count, MemorySegment buffers, MemorySegment offsets, MemorySegment sizes) {
    PFNGLBINDBUFFERSRANGEPROC.invoke(load("glBindBuffersRange"), target, first, count, buffers, offsets, sizes);
  }

  public void glPathStencilDepthOffsetNV(float factor, float units) {
    PFNGLPATHSTENCILDEPTHOFFSETNVPROC.invoke(load("glPathStencilDepthOffsetNV"), factor, units);
  }

  public void glShaderStorageBlockBinding(int program, int storageBlockIndex, int storageBlockBinding) {
    PFNGLSHADERSTORAGEBLOCKBINDINGPROC.invoke(load("glShaderStorageBlockBinding"), program, storageBlockIndex, storageBlockBinding);
  }

  public void glVertexAttribs4svNV(int index, int count, MemorySegment v) {
    PFNGLVERTEXATTRIBS4SVNVPROC.invoke(load("glVertexAttribs4svNV"), index, count, v);
  }

  public void glBeginQueryIndexed(int target, int index, int id) {
    PFNGLBEGINQUERYINDEXEDPROC.invoke(load("glBeginQueryIndexed"), target, index, id);
  }

  public void glFramebufferTexture3DEXT(int target, int attachment, int textarget, int texture, int level, int zoffset) {
    PFNGLFRAMEBUFFERTEXTURE3DEXTPROC.invoke(load("glFramebufferTexture3DEXT"), target, attachment, textarget, texture, level, zoffset);
  }

  public void glGetVideoCaptureStreamivNV(int video_capture_slot, int stream, int pname, MemorySegment params) {
    PFNGLGETVIDEOCAPTURESTREAMIVNVPROC.invoke(load("glGetVideoCaptureStreamivNV"), video_capture_slot, stream, pname, params);
  }

  public void glStencilFillPathInstancedNV(int numPaths, int pathNameType, MemorySegment paths, int pathBase, int fillMode, int mask, int transformType, MemorySegment transformValues) {
    PFNGLSTENCILFILLPATHINSTANCEDNVPROC.invoke(load("glStencilFillPathInstancedNV"), numPaths, pathNameType, paths, pathBase, fillMode, mask, transformType, transformValues);
  }

  public void glUniform4iv(int location, int count, MemorySegment value) {
    PFNGLUNIFORM4IVPROC.invoke(load("glUniform4iv"), location, count, value);
  }

  public void glVertexAttribI4iv(int index, MemorySegment v) {
    PFNGLVERTEXATTRIBI4IVPROC.invoke(load("glVertexAttribI4iv"), index, v);
  }

  public void glProgramUniformMatrix4x2dvEXT(int program, int location, int count, byte transpose, MemorySegment value) {
    PFNGLPROGRAMUNIFORMMATRIX4X2DVEXTPROC.invoke(load("glProgramUniformMatrix4x2dvEXT"), program, location, count, transpose, value);
  }

  public void glCopyColorSubTableEXT(int target, int start, int x, int y, int width) {
    PFNGLCOPYCOLORSUBTABLEEXTPROC.invoke(load("glCopyColorSubTableEXT"), target, start, x, y, width);
  }

  public void glGetProgramPipelineInfoLogEXT(int pipeline, int bufSize, MemorySegment length, MemorySegment infoLog) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glWindowPos3svARB(MemorySegment v) {
    PFNGLWINDOWPOS3SVARBPROC.invoke(load("glWindowPos3svARB"), v);
  }

  public int glGetDebugMessageLogARB(int count, int bufSize, MemorySegment sources, MemorySegment types, MemorySegment ids, MemorySegment severities, MemorySegment lengths, MemorySegment messageLog) {
    return PFNGLGETDEBUGMESSAGELOGARBPROC.invoke(load("glGetDebugMessageLogARB"), count, bufSize, sources, types, ids, severities, lengths, messageLog);
  }

  public void glVDPAUInitNV(MemorySegment vdpDevice, MemorySegment getProcAddress) {
    PFNGLVDPAUINITNVPROC.invoke(load("glVDPAUInitNV"), vdpDevice, getProcAddress);
  }

  public void glWeightsvARB(int size, MemorySegment weights) {
    PFNGLWEIGHTSVARBPROC.invoke(load("glWeightsvARB"), size, weights);
  }

  public void glVertexAttribs4hvNV(int index, int n, MemorySegment v) {
    PFNGLVERTEXATTRIBS4HVNVPROC.invoke(load("glVertexAttribs4hvNV"), index, n, v);
  }

  public void glGetUniformui64vARB(int program, int location, MemorySegment params) {
    PFNGLGETUNIFORMUI64VARBPROC.invoke(load("glGetUniformui64vARB"), program, location, params);
  }

  public void glMultiTexCoordPointerEXT(int texunit, int size, int type, int stride, MemorySegment pointer) {
    PFNGLMULTITEXCOORDPOINTEREXTPROC.invoke(load("glMultiTexCoordPointerEXT"), texunit, size, type, stride, pointer);
  }

  public void glClearNamedFramebufferuiv(int framebuffer, int buffer, int drawbuffer, MemorySegment value) {
    PFNGLCLEARNAMEDFRAMEBUFFERUIVPROC.invoke(load("glClearNamedFramebufferuiv"), framebuffer, buffer, drawbuffer, value);
  }

  public void glFragmentLightfvSGIX(int light, int pname, MemorySegment params) {
    PFNGLFRAGMENTLIGHTFVSGIXPROC.invoke(load("glFragmentLightfvSGIX"), light, pname, params);
  }

  public void glTexSubImage3DOES(int target, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int format, int type, MemorySegment pixels) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniform4uiEXT(int program, int location, int v0, int v1, int v2, int v3) {
    PFNGLPROGRAMUNIFORM4UIEXTPROC.invoke(load("glProgramUniform4uiEXT"), program, location, v0, v1, v2, v3);
  }

  public void glGenTexturesEXT(int n, MemorySegment textures) {
    PFNGLGENTEXTURESEXTPROC.invoke(load("glGenTexturesEXT"), n, textures);
  }

  public void glDispatchComputeGroupSizeARB(int num_groups_x, int num_groups_y, int num_groups_z, int group_size_x, int group_size_y, int group_size_z) {
    PFNGLDISPATCHCOMPUTEGROUPSIZEARBPROC.invoke(load("glDispatchComputeGroupSizeARB"), num_groups_x, num_groups_y, num_groups_z, group_size_x, group_size_y, group_size_z);
  }

  public void glColor3hvNV(MemorySegment v) {
    PFNGLCOLOR3HVNVPROC.invoke(load("glColor3hvNV"), v);
  }

  public void glLoadPaletteFromModelViewMatrixOES() {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDepthRangexOES(int n, int f) {
    PFNGLDEPTHRANGEXOESPROC.invoke(load("glDepthRangexOES"), n, f);
  }

  public long glGetTextureSamplerHandleNV(int texture, int sampler) {
    return PFNGLGETTEXTURESAMPLERHANDLENVPROC.invoke(load("glGetTextureSamplerHandleNV"), texture, sampler);
  }

  public void glProgramVertexLimitNV(int target, int limit) {
    PFNGLPROGRAMVERTEXLIMITNVPROC.invoke(load("glProgramVertexLimitNV"), target, limit);
  }

  public void glCreateSamplers(int n, MemorySegment samplers) {
    PFNGLCREATESAMPLERSPROC.invoke(load("glCreateSamplers"), n, samplers);
  }

  public void glVertexAttrib4NubvARB(int index, MemorySegment v) {
    PFNGLVERTEXATTRIB4NUBVARBPROC.invoke(load("glVertexAttrib4NubvARB"), index, v);
  }

  public void glDeleteNamesAMD(int identifier, int num, MemorySegment names) {
    PFNGLDELETENAMESAMDPROC.invoke(load("glDeleteNamesAMD"), identifier, num, names);
  }

  public void glTextureStorage1DEXT(int texture, int target, int levels, int internalformat, int width) {
    PFNGLTEXTURESTORAGE1DEXTPROC.invoke(load("glTextureStorage1DEXT"), texture, target, levels, internalformat, width);
  }

  public void glVertexPointerEXT(int size, int type, int stride, int count, MemorySegment pointer) {
    PFNGLVERTEXPOINTEREXTPROC.invoke(load("glVertexPointerEXT"), size, type, stride, count, pointer);
  }

  public void glVertexStream1ivATI(int stream, MemorySegment coords) {
    PFNGLVERTEXSTREAM1IVATIPROC.invoke(load("glVertexStream1ivATI"), stream, coords);
  }

  public void glColorFragmentOp1ATI(int op, int dst, int dstMask, int dstMod, int arg1, int arg1Rep, int arg1Mod) {
    PFNGLCOLORFRAGMENTOP1ATIPROC.invoke(load("glColorFragmentOp1ATI"), op, dst, dstMask, dstMod, arg1, arg1Rep, arg1Mod);
  }

  public void glLineWidthx(int width) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetVertexAttribArrayObjectivATI(int index, int pname, MemorySegment params) {
    PFNGLGETVERTEXATTRIBARRAYOBJECTIVATIPROC.invoke(load("glGetVertexAttribArrayObjectivATI"), index, pname, params);
  }

  public void glGetColorTableParameterivSGI(int target, int pname, MemorySegment params) {
    PFNGLGETCOLORTABLEPARAMETERIVSGIPROC.invoke(load("glGetColorTableParameterivSGI"), target, pname, params);
  }

  public void glPrimitiveBoundingBoxARB(float minX, float minY, float minZ, float minW, float maxX, float maxY, float maxZ, float maxW) {
    PFNGLPRIMITIVEBOUNDINGBOXARBPROC.invoke(load("glPrimitiveBoundingBoxARB"), minX, minY, minZ, minW, maxX, maxY, maxZ, maxW);
  }

  public void glUniformMatrix2x3fv(int location, int count, byte transpose, MemorySegment value) {
    PFNGLUNIFORMMATRIX2X3FVPROC.invoke(load("glUniformMatrix2x3fv"), location, count, transpose, value);
  }

  public void glTextureImage1DEXT(int texture, int target, int level, int internalformat, int width, int border, int format, int type, MemorySegment pixels) {
    PFNGLTEXTUREIMAGE1DEXTPROC.invoke(load("glTextureImage1DEXT"), texture, target, level, internalformat, width, border, format, type, pixels);
  }

  public int glGetDebugMessageLogAMD(int count, int bufSize, MemorySegment categories, MemorySegment severities, MemorySegment ids, MemorySegment lengths, MemorySegment message) {
    return PFNGLGETDEBUGMESSAGELOGAMDPROC.invoke(load("glGetDebugMessageLogAMD"), count, bufSize, categories, severities, ids, lengths, message);
  }

  public void glLightModelx(int pname, int param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public int glQueryResourceNV(int queryType, int tagId, int count, MemorySegment buffer) {
    return PFNGLQUERYRESOURCENVPROC.invoke(load("glQueryResourceNV"), queryType, tagId, count, buffer);
  }

  public void glTexAttachMemoryNV(int target, int memory, long offset) {
    PFNGLTEXATTACHMEMORYNVPROC.invoke(load("glTexAttachMemoryNV"), target, memory, offset);
  }

  public long glGetUniformOffsetEXT(int program, int location) {
    return PFNGLGETUNIFORMOFFSETEXTPROC.invoke(load("glGetUniformOffsetEXT"), program, location);
  }

  public void glDeleteShader(int shader) {
    PFNGLDELETESHADERPROC.invoke(load("glDeleteShader"), shader);
  }

  public void glUniform3uiv(int location, int count, MemorySegment value) {
    PFNGLUNIFORM3UIVPROC.invoke(load("glUniform3uiv"), location, count, value);
  }

  public void glColorTableParameterfvSGI(int target, int pname, MemorySegment params) {
    PFNGLCOLORTABLEPARAMETERFVSGIPROC.invoke(load("glColorTableParameterfvSGI"), target, pname, params);
  }

  public void glDrawCommandsStatesNV(int buffer, MemorySegment indirects, MemorySegment sizes, MemorySegment states, MemorySegment fbos, int count) {
    PFNGLDRAWCOMMANDSSTATESNVPROC.invoke(load("glDrawCommandsStatesNV"), buffer, indirects, sizes, states, fbos, count);
  }

  public void glGetQueryivEXT(int target, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexArrayVertexOffsetEXT(int vaobj, int buffer, int size, int type, int stride, long offset) {
    PFNGLVERTEXARRAYVERTEXOFFSETEXTPROC.invoke(load("glVertexArrayVertexOffsetEXT"), vaobj, buffer, size, type, stride, offset);
  }

  public void glVertexAttrib4iv(int index, MemorySegment v) {
    PFNGLVERTEXATTRIB4IVPROC.invoke(load("glVertexAttrib4iv"), index, v);
  }

  public void glEdgeFlagPointerListIBM(int stride, MemorySegment pointer, int ptrstride) {
    PFNGLEDGEFLAGPOINTERLISTIBMPROC.invoke(load("glEdgeFlagPointerListIBM"), stride, pointer, ptrstride);
  }

  public void glVertexAttrib4fv(int index, MemorySegment v) {
    PFNGLVERTEXATTRIB4FVPROC.invoke(load("glVertexAttrib4fv"), index, v);
  }

  public void glVertexStream3svATI(int stream, MemorySegment coords) {
    PFNGLVERTEXSTREAM3SVATIPROC.invoke(load("glVertexStream3svATI"), stream, coords);
  }

  public void glGetNamedBufferPointerv(int buffer, int pname, MemorySegment params) {
    PFNGLGETNAMEDBUFFERPOINTERVPROC.invoke(load("glGetNamedBufferPointerv"), buffer, pname, params);
  }

  public void glIndexMaterialEXT(int face, int mode) {
    PFNGLINDEXMATERIALEXTPROC.invoke(load("glIndexMaterialEXT"), face, mode);
  }

  public void glScissorExclusiveNV(int x, int y, int width, int height) {
    PFNGLSCISSOREXCLUSIVENVPROC.invoke(load("glScissorExclusiveNV"), x, y, width, height);
  }

  public void glDeleteObjectARB(int obj) {
    opengl.windows.PFNGLDELETEOBJECTARBPROC.invoke(load("glDeleteObjectARB"), obj);
  }

  public void glMultiModeDrawArraysIBM(MemorySegment mode, MemorySegment first, MemorySegment count, int primcount, int modestride) {
    PFNGLMULTIMODEDRAWARRAYSIBMPROC.invoke(load("glMultiModeDrawArraysIBM"), mode, first, count, primcount, modestride);
  }

  public void glMatrixLoad3x2fNV(int matrixMode, MemorySegment m) {
    PFNGLMATRIXLOAD3X2FNVPROC.invoke(load("glMatrixLoad3x2fNV"), matrixMode, m);
  }

  public void glCompressedMultiTexSubImage2DEXT(int texunit, int target, int level, int xoffset, int yoffset, int width, int height, int format, int imageSize, MemorySegment bits) {
    PFNGLCOMPRESSEDMULTITEXSUBIMAGE2DEXTPROC.invoke(load("glCompressedMultiTexSubImage2DEXT"), texunit, target, level, xoffset, yoffset, width, height, format, imageSize, bits);
  }

  public void glGetMemoryObjectDetachedResourcesuivNV(int memory, int pname, int first, int count, MemorySegment params) {
    PFNGLGETMEMORYOBJECTDETACHEDRESOURCESUIVNVPROC.invoke(load("glGetMemoryObjectDetachedResourcesuivNV"), memory, pname, first, count, params);
  }

  public void glTexSubImage3D(int target, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int format, int type, MemorySegment pixels) {
    PFNGLTEXSUBIMAGE3DPROC.invoke(load("glTexSubImage3D"), target, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels);
  }

  public void glWindowPos3iMESA(int x, int y, int z) {
    PFNGLWINDOWPOS3IMESAPROC.invoke(load("glWindowPos3iMESA"), x, y, z);
  }

  public void glCreateTextures(int target, int n, MemorySegment textures) {
    PFNGLCREATETEXTURESPROC.invoke(load("glCreateTextures"), target, n, textures);
  }

  public void glDrawBuffersIndexedEXT(int n, MemorySegment location, MemorySegment indices) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniform4i64vNV(int location, int count, MemorySegment value) {
    PFNGLUNIFORM4I64VNVPROC.invoke(load("glUniform4i64vNV"), location, count, value);
  }

  public void glLoadTransposeMatrixdARB(MemorySegment m) {
    PFNGLLOADTRANSPOSEMATRIXDARBPROC.invoke(load("glLoadTransposeMatrixdARB"), m);
  }

  public void glVertexAttribL3dvEXT(int index, MemorySegment v) {
    PFNGLVERTEXATTRIBL3DVEXTPROC.invoke(load("glVertexAttribL3dvEXT"), index, v);
  }

  public void glGetnUniformfvARB(int program, int location, int bufSize, MemorySegment params) {
    PFNGLGETNUNIFORMFVARBPROC.invoke(load("glGetnUniformfvARB"), program, location, bufSize, params);
  }

  public void glCompressedTextureSubImage1DEXT(int texture, int target, int level, int xoffset, int width, int format, int imageSize, MemorySegment bits) {
    PFNGLCOMPRESSEDTEXTURESUBIMAGE1DEXTPROC.invoke(load("glCompressedTextureSubImage1DEXT"), texture, target, level, xoffset, width, format, imageSize, bits);
  }

  public void glUniformMatrix2x3dv(int location, int count, byte transpose, MemorySegment value) {
    PFNGLUNIFORMMATRIX2X3DVPROC.invoke(load("glUniformMatrix2x3dv"), location, count, transpose, value);
  }

  public void glFrustumx(int l, int r, int b, int t, int n, int f) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniform4dv(int location, int count, MemorySegment value) {
    PFNGLUNIFORM4DVPROC.invoke(load("glUniform4dv"), location, count, value);
  }

  public void glFrustumf(float l, float r, float b, float t, float n, float f) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFramebufferTextureMultisampleMultiviewOVR(int target, int attachment, int texture, int level, int samples, int baseViewIndex, int numViews) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribI4sv(int index, MemorySegment v) {
    PFNGLVERTEXATTRIBI4SVPROC.invoke(load("glVertexAttribI4sv"), index, v);
  }

  public void glGetNamedRenderbufferParameteriv(int renderbuffer, int pname, MemorySegment params) {
    PFNGLGETNAMEDRENDERBUFFERPARAMETERIVPROC.invoke(load("glGetNamedRenderbufferParameteriv"), renderbuffer, pname, params);
  }

  public void glProgramEnvParameter4dARB(int target, int index, double x, double y, double z, double w) {
    PFNGLPROGRAMENVPARAMETER4DARBPROC.invoke(load("glProgramEnvParameter4dARB"), target, index, x, y, z, w);
  }

  public void glCopyTextureSubImage1DEXT(int texture, int target, int level, int xoffset, int x, int y, int width) {
    PFNGLCOPYTEXTURESUBIMAGE1DEXTPROC.invoke(load("glCopyTextureSubImage1DEXT"), texture, target, level, xoffset, x, y, width);
  }

  public void glVertexArrayVertexBindingDivisorEXT(int vaobj, int bindingindex, int divisor) {
    PFNGLVERTEXARRAYVERTEXBINDINGDIVISOREXTPROC.invoke(load("glVertexArrayVertexBindingDivisorEXT"), vaobj, bindingindex, divisor);
  }

  public void glFramebufferTexture1D(int target, int attachment, int textarget, int texture, int level) {
    PFNGLFRAMEBUFFERTEXTURE1DPROC.invoke(load("glFramebufferTexture1D"), target, attachment, textarget, texture, level);
  }

  public void glFramebufferFetchBarrierEXT() {
    PFNGLFRAMEBUFFERFETCHBARRIEREXTPROC.invoke(load("glFramebufferFetchBarrierEXT"));
  }

  public void glLightModelxOES(int pname, int param) {
    PFNGLLIGHTMODELXOESPROC.invoke(load("glLightModelxOES"), pname, param);
  }

  public void glTexImage3DMultisample(int target, int samples, int internalformat, int width, int height, int depth, byte fixedsamplelocations) {
    PFNGLTEXIMAGE3DMULTISAMPLEPROC.invoke(load("glTexImage3DMultisample"), target, samples, internalformat, width, height, depth, fixedsamplelocations);
  }

  public void glUniform1i64NV(int location, long x) {
    PFNGLUNIFORM1I64NVPROC.invoke(load("glUniform1i64NV"), location, x);
  }

  public void glProgramUniformMatrix3x2dv(int program, int location, int count, byte transpose, MemorySegment value) {
    PFNGLPROGRAMUNIFORMMATRIX3X2DVPROC.invoke(load("glProgramUniformMatrix3x2dv"), program, location, count, transpose, value);
  }

  public void glRenderbufferStorageOES(int target, int internalformat, int width, int height) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexRenderbufferNV(int target, int renderbuffer) {
    PFNGLTEXRENDERBUFFERNVPROC.invoke(load("glTexRenderbufferNV"), target, renderbuffer);
  }

  public void glPolygonOffsetEXT(float factor, float bias) {
    PFNGLPOLYGONOFFSETEXTPROC.invoke(load("glPolygonOffsetEXT"), factor, bias);
  }

  public void glProgramUniform4dEXT(int program, int location, double x, double y, double z, double w) {
    PFNGLPROGRAMUNIFORM4DEXTPROC.invoke(load("glProgramUniform4dEXT"), program, location, x, y, z, w);
  }

  public void glCreateMemoryObjectsEXT(int n, MemorySegment memoryObjects) {
    PFNGLCREATEMEMORYOBJECTSEXTPROC.invoke(load("glCreateMemoryObjectsEXT"), n, memoryObjects);
  }

  public void glMatrixRotatefEXT(int mode, float angle, float x, float y, float z) {
    PFNGLMATRIXROTATEFEXTPROC.invoke(load("glMatrixRotatefEXT"), mode, angle, x, y, z);
  }

  public void glGetPerfMonitorCounterStringAMD(int group, int counter, int bufSize, MemorySegment length, MemorySegment counterString) {
    PFNGLGETPERFMONITORCOUNTERSTRINGAMDPROC.invoke(load("glGetPerfMonitorCounterStringAMD"), group, counter, bufSize, length, counterString);
  }

  public void glUniformMatrix2x4dv(int location, int count, byte transpose, MemorySegment value) {
    PFNGLUNIFORMMATRIX2X4DVPROC.invoke(load("glUniformMatrix2x4dv"), location, count, transpose, value);
  }

  public void glVertexAttribI4ui(int index, int x, int y, int z, int w) {
    PFNGLVERTEXATTRIBI4UIPROC.invoke(load("glVertexAttribI4ui"), index, x, y, z, w);
  }

  public void glGetColorTableEXT(int target, int format, int type, MemorySegment data) {
    PFNGLGETCOLORTABLEEXTPROC.invoke(load("glGetColorTableEXT"), target, format, type, data);
  }

  public void glFlushMappedBufferRange(int target, long offset, long length) {
    PFNGLFLUSHMAPPEDBUFFERRANGEPROC.invoke(load("glFlushMappedBufferRange"), target, offset, length);
  }

  public void glGetTextureImageEXT(int texture, int target, int level, int format, int type, MemorySegment pixels) {
    PFNGLGETTEXTUREIMAGEEXTPROC.invoke(load("glGetTextureImageEXT"), texture, target, level, format, type, pixels);
  }

  public void glResumeTransformFeedbackNV() {
    PFNGLRESUMETRANSFORMFEEDBACKNVPROC.invoke(load("glResumeTransformFeedbackNV"));
  }

  public void glBindBufferBaseNV(int target, int index, int buffer) {
    PFNGLBINDBUFFERBASENVPROC.invoke(load("glBindBufferBaseNV"), target, index, buffer);
  }

  public void glCopyConvolutionFilter2DEXT(int target, int internalformat, int x, int y, int width, int height) {
    PFNGLCOPYCONVOLUTIONFILTER2DEXTPROC.invoke(load("glCopyConvolutionFilter2DEXT"), target, internalformat, x, y, width, height);
  }

  public void glTransformFeedbackVaryings(int program, int count, MemorySegment varyings, int bufferMode) {
    PFNGLTRANSFORMFEEDBACKVARYINGSPROC.invoke(load("glTransformFeedbackVaryings"), program, count, varyings, bufferMode);
  }

  public void glProgramLocalParameterI4iNV(int target, int index, int x, int y, int z, int w) {
    PFNGLPROGRAMLOCALPARAMETERI4INVPROC.invoke(load("glProgramLocalParameterI4iNV"), target, index, x, y, z, w);
  }

  public void glUniform3ui64vNV(int location, int count, MemorySegment value) {
    PFNGLUNIFORM3UI64VNVPROC.invoke(load("glUniform3ui64vNV"), location, count, value);
  }

  public void glScalex(int x, int y, int z) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetMapAttribParameterfvNV(int target, int index, int pname, MemorySegment params) {
    PFNGLGETMAPATTRIBPARAMETERFVNVPROC.invoke(load("glGetMapAttribParameterfvNV"), target, index, pname, params);
  }

  public void glEnableiOES(int target, int index) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glRenderbufferStorageMultisampleANGLE(int target, int samples, int internalformat, int width, int height) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFramebufferTexture3D(int target, int attachment, int textarget, int texture, int level, int zoffset) {
    PFNGLFRAMEBUFFERTEXTURE3DPROC.invoke(load("glFramebufferTexture3D"), target, attachment, textarget, texture, level, zoffset);
  }

  public void glMultiTexCoordP4uiv(int texture, int type, MemorySegment coords) {
    PFNGLMULTITEXCOORDP4UIVPROC.invoke(load("glMultiTexCoordP4uiv"), texture, type, coords);
  }

  public void glProgramUniform2i64ARB(int program, int location, long x, long y) {
    PFNGLPROGRAMUNIFORM2I64ARBPROC.invoke(load("glProgramUniform2i64ARB"), program, location, x, y);
  }

  public void glMultMatrixxOES(MemorySegment m) {
    PFNGLMULTMATRIXXOESPROC.invoke(load("glMultMatrixxOES"), m);
  }

  public void glTexParameterxvOES(int target, int pname, MemorySegment params) {
    PFNGLTEXPARAMETERXVOESPROC.invoke(load("glTexParameterxvOES"), target, pname, params);
  }

  public void glEndVertexShaderEXT() {
    PFNGLENDVERTEXSHADEREXTPROC.invoke(load("glEndVertexShaderEXT"));
  }

  public void glQueryResourceTagNV(int tagId, MemorySegment tagString) {
    PFNGLQUERYRESOURCETAGNVPROC.invoke(load("glQueryResourceTagNV"), tagId, tagString);
  }

  public void glVertex2bvOES(MemorySegment coords) {
    PFNGLVERTEX2BVOESPROC.invoke(load("glVertex2bvOES"), coords);
  }

  public void glTexStorage2DEXT(int target, int levels, int internalformat, int width, int height) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetnUniformi64vARB(int program, int location, int bufSize, MemorySegment params) {
    PFNGLGETNUNIFORMI64VARBPROC.invoke(load("glGetnUniformi64vARB"), program, location, bufSize, params);
  }

  public void glProgramUniform3dvEXT(int program, int location, int count, MemorySegment value) {
    PFNGLPROGRAMUNIFORM3DVEXTPROC.invoke(load("glProgramUniform3dvEXT"), program, location, count, value);
  }

  public void glFramebufferTexture2D(int target, int attachment, int textarget, int texture, int level) {
    PFNGLFRAMEBUFFERTEXTURE2DPROC.invoke(load("glFramebufferTexture2D"), target, attachment, textarget, texture, level);
  }

  public void glBlendEquationSeparateiOES(int buf, int modeRGB, int modeAlpha) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexParameterIuiv(int target, int pname, MemorySegment params) {
    PFNGLTEXPARAMETERIUIVPROC.invoke(load("glTexParameterIuiv"), target, pname, params);
  }

  public void glDeleteRenderbuffersEXT(int n, MemorySegment renderbuffers) {
    PFNGLDELETERENDERBUFFERSEXTPROC.invoke(load("glDeleteRenderbuffersEXT"), n, renderbuffers);
  }

  public void glGetUnsignedBytevEXT(int pname, MemorySegment data) {
    PFNGLGETUNSIGNEDBYTEVEXTPROC.invoke(load("glGetUnsignedBytevEXT"), pname, data);
  }

  public byte glIsSemaphoreEXT(int semaphore) {
    return PFNGLISSEMAPHOREEXTPROC.invoke(load("glIsSemaphoreEXT"), semaphore);
  }

  public void glVertexStream4iATI(int stream, int x, int y, int z, int w) {
    PFNGLVERTEXSTREAM4IATIPROC.invoke(load("glVertexStream4iATI"), stream, x, y, z, w);
  }

  public void glDrawElementArrayAPPLE(int mode, int first, int count) {
    PFNGLDRAWELEMENTARRAYAPPLEPROC.invoke(load("glDrawElementArrayAPPLE"), mode, first, count);
  }

  public void glFogCoordf(float coord) {
    PFNGLFOGCOORDFPROC.invoke(load("glFogCoordf"), coord);
  }

  public void glFogCoordd(double coord) {
    PFNGLFOGCOORDDPROC.invoke(load("glFogCoordd"), coord);
  }

  public void glBeginPerfMonitorAMD(int monitor) {
    PFNGLBEGINPERFMONITORAMDPROC.invoke(load("glBeginPerfMonitorAMD"), monitor);
  }

  public void glBlendFuncSeparateiEXT(int buf, int srcRGB, int dstRGB, int srcAlpha, int dstAlpha) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFogCoorddEXT(double coord) {
    PFNGLFOGCOORDDEXTPROC.invoke(load("glFogCoorddEXT"), coord);
  }

  public void glGetOcclusionQueryivNV(int id, int pname, MemorySegment params) {
    PFNGLGETOCCLUSIONQUERYIVNVPROC.invoke(load("glGetOcclusionQueryivNV"), id, pname, params);
  }

  public void glMultiTexCoord2fARB(int target, float s, float t) {
    PFNGLMULTITEXCOORD2FARBPROC.invoke(load("glMultiTexCoord2fARB"), target, s, t);
  }

  public void glFragmentLightModelivSGIX(int pname, MemorySegment params) {
    PFNGLFRAGMENTLIGHTMODELIVSGIXPROC.invoke(load("glFragmentLightModelivSGIX"), pname, params);
  }

  public void glGetFragmentMaterialivSGIX(int face, int pname, MemorySegment params) {
    PFNGLGETFRAGMENTMATERIALIVSGIXPROC.invoke(load("glGetFragmentMaterialivSGIX"), face, pname, params);
  }

  public void glDrawElementsInstancedEXT(int mode, int count, int type, MemorySegment indices, int primcount) {
    PFNGLDRAWELEMENTSINSTANCEDEXTPROC.invoke(load("glDrawElementsInstancedEXT"), mode, count, type, indices, primcount);
  }

  public void glVertexBlendEnviATI(int pname, int param) {
    PFNGLVERTEXBLENDENVIATIPROC.invoke(load("glVertexBlendEnviATI"), pname, param);
  }

  public void glClampColorARB(int target, int clamp) {
    PFNGLCLAMPCOLORARBPROC.invoke(load("glClampColorARB"), target, clamp);
  }

  public void glTexCoord2fVertex3fSUN(float s, float t, float x, float y, float z) {
    PFNGLTEXCOORD2FVERTEX3FSUNPROC.invoke(load("glTexCoord2fVertex3fSUN"), s, t, x, y, z);
  }

  public void glCreatePerfQueryINTEL(int queryId, MemorySegment queryHandle) {
    PFNGLCREATEPERFQUERYINTELPROC.invoke(load("glCreatePerfQueryINTEL"), queryId, queryHandle);
  }

  public void glConvolutionFilter2D(int target, int internalformat, int width, int height, int format, int type, MemorySegment image) {
    PFNGLCONVOLUTIONFILTER2DEXTPROC.invoke(load("glConvolutionFilter2D"), target, internalformat, width, height, format, type, image);
  }

  public void glGetQueryObjectivARB(int id, int pname, MemorySegment params) {
    PFNGLGETQUERYOBJECTIVARBPROC.invoke(load("glGetQueryObjectivARB"), id, pname, params);
  }

  public void glUniform3ui64vARB(int location, int count, MemorySegment value) {
    PFNGLUNIFORM3UI64VARBPROC.invoke(load("glUniform3ui64vARB"), location, count, value);
  }

  public void glGetHistogramParameterivEXT(int target, int pname, MemorySegment params) {
    PFNGLGETHISTOGRAMPARAMETERIVEXTPROC.invoke(load("glGetHistogramParameterivEXT"), target, pname, params);
  }

  public void glGetMapAttribParameterivNV(int target, int index, int pname, MemorySegment params) {
    PFNGLGETMAPATTRIBPARAMETERIVNVPROC.invoke(load("glGetMapAttribParameterivNV"), target, index, pname, params);
  }

  public void glProgramUniform4ui64vNV(int program, int location, int count, MemorySegment value) {
    PFNGLPROGRAMUNIFORM4UI64VNVPROC.invoke(load("glProgramUniform4ui64vNV"), program, location, count, value);
  }

  public void glViewportIndexedfvOES(int index, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniformMatrix3x2fv(int program, int location, int count, byte transpose, MemorySegment value) {
    PFNGLPROGRAMUNIFORMMATRIX3X2FVPROC.invoke(load("glProgramUniformMatrix3x2fv"), program, location, count, transpose, value);
  }

  public void glGetPathTexGenivNV(int texCoordSet, int pname, MemorySegment value) {
    PFNGLGETPATHTEXGENIVNVPROC.invoke(load("glGetPathTexGenivNV"), texCoordSet, pname, value);
  }

  public void glBufferPageCommitmentARB(int target, long offset, long size, byte commit) {
    PFNGLBUFFERPAGECOMMITMENTARBPROC.invoke(load("glBufferPageCommitmentARB"), target, offset, size, commit);
  }

  public void glNormal3xOES(int nx, int ny, int nz) {
    PFNGLNORMAL3XOESPROC.invoke(load("glNormal3xOES"), nx, ny, nz);
  }

  public void glBeginQueryARB(int target, int id) {
    PFNGLBEGINQUERYARBPROC.invoke(load("glBeginQueryARB"), target, id);
  }

  public void glConvolutionFilter1D(int target, int internalformat, int width, int format, int type, MemorySegment image) {
    PFNGLCONVOLUTIONFILTER1DEXTPROC.invoke(load("glConvolutionFilter1D"), target, internalformat, width, format, type, image);
  }

  public void glVertexArrayIndexOffsetEXT(int vaobj, int buffer, int type, int stride, long offset) {
    PFNGLVERTEXARRAYINDEXOFFSETEXTPROC.invoke(load("glVertexArrayIndexOffsetEXT"), vaobj, buffer, type, stride, offset);
  }

  public void glExtGetTexSubImageQCOM(int target, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int format, int type, MemorySegment texels) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGenTransformFeedbacksNV(int n, MemorySegment ids) {
    PFNGLGENTRANSFORMFEEDBACKSNVPROC.invoke(load("glGenTransformFeedbacksNV"), n, ids);
  }

  public void glImportSemaphoreWin32HandleEXT(int semaphore, int handleType, MemorySegment handle) {
    PFNGLIMPORTSEMAPHOREWIN32HANDLEEXTPROC.invoke(load("glImportSemaphoreWin32HandleEXT"), semaphore, handleType, handle);
  }

  public void glBindVertexBuffer(int bindingindex, int buffer, long offset, int stride) {
    PFNGLBINDVERTEXBUFFERPROC.invoke(load("glBindVertexBuffer"), bindingindex, buffer, offset, stride);
  }

  public void glSecondaryColor3fEXT(float red, float green, float blue) {
    PFNGLSECONDARYCOLOR3FEXTPROC.invoke(load("glSecondaryColor3fEXT"), red, green, blue);
  }

  public void glMultiTexCoord1dARB(int target, double s) {
    PFNGLMULTITEXCOORD1DARBPROC.invoke(load("glMultiTexCoord1dARB"), target, s);
  }

  public void glColorSubTableEXT(int target, int start, int count, int format, int type, MemorySegment data) {
    PFNGLCOLORSUBTABLEEXTPROC.invoke(load("glColorSubTableEXT"), target, start, count, format, type, data);
  }

  public void glGetVertexArrayIntegervEXT(int vaobj, int pname, MemorySegment param) {
    PFNGLGETVERTEXARRAYINTEGERVEXTPROC.invoke(load("glGetVertexArrayIntegervEXT"), vaobj, pname, param);
  }

  public void glSecondaryColorP3ui(int type, int color) {
    PFNGLSECONDARYCOLORP3UIPROC.invoke(load("glSecondaryColorP3ui"), type, color);
  }

  public void glColorMaskiOES(int index, byte r, byte g, byte b, byte a) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniform2dv(int program, int location, int count, MemorySegment value) {
    PFNGLPROGRAMUNIFORM2DVPROC.invoke(load("glProgramUniform2dv"), program, location, count, value);
  }

  public void glGetPerfMonitorGroupsAMD(MemorySegment numGroups, int groupsSize, MemorySegment groups) {
    PFNGLGETPERFMONITORGROUPSAMDPROC.invoke(load("glGetPerfMonitorGroupsAMD"), numGroups, groupsSize, groups);
  }

  public void glIndexFormatNV(int type, int stride) {
    PFNGLINDEXFORMATNVPROC.invoke(load("glIndexFormatNV"), type, stride);
  }

  public void glUniform3uiEXT(int location, int v0, int v1, int v2) {
    PFNGLUNIFORM3UIEXTPROC.invoke(load("glUniform3uiEXT"), location, v0, v1, v2);
  }

  public void glCopyTexSubImage2DEXT(int target, int level, int xoffset, int yoffset, int x, int y, int width, int height) {
    PFNGLCOPYTEXSUBIMAGE2DEXTPROC.invoke(load("glCopyTexSubImage2DEXT"), target, level, xoffset, yoffset, x, y, width, height);
  }

  public void glVDPAUUnmapSurfacesNV(int numSurface, MemorySegment surfaces) {
    PFNGLVDPAUUNMAPSURFACESNVPROC.invoke(load("glVDPAUUnmapSurfacesNV"), numSurface, surfaces);
  }

  public void glVertexAttribI4uiEXT(int index, int x, int y, int z, int w) {
    PFNGLVERTEXATTRIBI4UIEXTPROC.invoke(load("glVertexAttribI4uiEXT"), index, x, y, z, w);
  }

  public void glProgramUniformMatrix3dvEXT(int program, int location, int count, byte transpose, MemorySegment value) {
    PFNGLPROGRAMUNIFORMMATRIX3DVEXTPROC.invoke(load("glProgramUniformMatrix3dvEXT"), program, location, count, transpose, value);
  }

  public void glRenderbufferStorageMultisample(int target, int samples, int internalformat, int width, int height) {
    PFNGLRENDERBUFFERSTORAGEMULTISAMPLEPROC.invoke(load("glRenderbufferStorageMultisample"), target, samples, internalformat, width, height);
  }

  public void glGetPerfMonitorCounterInfoAMD(int group, int counter, int pname, MemorySegment data) {
    PFNGLGETPERFMONITORCOUNTERINFOAMDPROC.invoke(load("glGetPerfMonitorCounterInfoAMD"), group, counter, pname, data);
  }

  public void glGetVertexAttribfvARB(int index, int pname, MemorySegment params) {
    PFNGLGETVERTEXATTRIBFVARBPROC.invoke(load("glGetVertexAttribfvARB"), index, pname, params);
  }

  public void glVertexAttrib2fARB(int index, float x, float y) {
    PFNGLVERTEXATTRIB2FARBPROC.invoke(load("glVertexAttrib2fARB"), index, x, y);
  }

  public byte glIsSampler(int sampler) {
    return PFNGLISSAMPLERPROC.invoke(load("glIsSampler"), sampler);
  }

  public void glGetQueryObjecti64v(int id, int pname, MemorySegment params) {
    PFNGLGETQUERYOBJECTI64VPROC.invoke(load("glGetQueryObjecti64v"), id, pname, params);
  }

  public void glWindowPos2fMESA(float x, float y) {
    PFNGLWINDOWPOS2FMESAPROC.invoke(load("glWindowPos2fMESA"), x, y);
  }

  public void glDeformationMap3fSGIX(int target, float u1, float u2, int ustride, int uorder, float v1, float v2, int vstride, int vorder, float w1, float w2, int wstride, int worder, MemorySegment points) {
    PFNGLDEFORMATIONMAP3FSGIXPROC.invoke(load("glDeformationMap3fSGIX"), target, u1, u2, ustride, uorder, v1, v2, vstride, vorder, w1, w2, wstride, worder, points);
  }

  public void glReplacementCodeubSUN(byte code) {
    PFNGLREPLACEMENTCODEUBSUNPROC.invoke(load("glReplacementCodeubSUN"), code);
  }

  public void glBindVertexArrayOES(int array) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetBufferSubDataARB(int target, long offset, long size, MemorySegment data) {
    PFNGLGETBUFFERSUBDATAARBPROC.invoke(load("glGetBufferSubDataARB"), target, offset, size, data);
  }

  public void glVertexAttribL2i64NV(int index, long x, long y) {
    PFNGLVERTEXATTRIBL2I64NVPROC.invoke(load("glVertexAttribL2i64NV"), index, x, y);
  }

  public void glSecondaryColor3d(double red, double green, double blue) {
    PFNGLSECONDARYCOLOR3DPROC.invoke(load("glSecondaryColor3d"), red, green, blue);
  }

  public void glTexCoord4xOES(int s, int t, int r, int q) {
    PFNGLTEXCOORD4XOESPROC.invoke(load("glTexCoord4xOES"), s, t, r, q);
  }

  public void glFramebufferFoveationConfigQCOM(int framebuffer, int numLayers, int focalPointsPerLayer, int requestedFeatures, MemorySegment providedFeatures) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glSecondaryColor3f(float red, float green, float blue) {
    PFNGLSECONDARYCOLOR3FPROC.invoke(load("glSecondaryColor3f"), red, green, blue);
  }

  public void glSecondaryColor3b(byte red, byte green, byte blue) {
    PFNGLSECONDARYCOLOR3BPROC.invoke(load("glSecondaryColor3b"), red, green, blue);
  }

  public void glSecondaryColor3i(int red, int green, int blue) {
    PFNGLSECONDARYCOLOR3IPROC.invoke(load("glSecondaryColor3i"), red, green, blue);
  }

  public void glSecondaryColor3s(short red, short green, short blue) {
    PFNGLSECONDARYCOLOR3SPROC.invoke(load("glSecondaryColor3s"), red, green, blue);
  }

  public void glDeletePathsNV(int path, int range) {
    PFNGLDELETEPATHSNVPROC.invoke(load("glDeletePathsNV"), path, range);
  }

  public void glWindowPos3sARB(short x, short y, short z) {
    PFNGLWINDOWPOS3SARBPROC.invoke(load("glWindowPos3sARB"), x, y, z);
  }

  public void glWindowPos3dvARB(MemorySegment v) {
    PFNGLWINDOWPOS3DVARBPROC.invoke(load("glWindowPos3dvARB"), v);
  }

  public void glSampleMaskIndexedNV(int index, int mask) {
    PFNGLSAMPLEMASKINDEXEDNVPROC.invoke(load("glSampleMaskIndexedNV"), index, mask);
  }

  public void glNamedBufferSubData(int buffer, long offset, long size, MemorySegment data) {
    PFNGLNAMEDBUFFERSUBDATAPROC.invoke(load("glNamedBufferSubData"), buffer, offset, size, data);
  }

  public void glGenQueriesEXT(int n, MemorySegment ids) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexCoord1ivARB(int target, MemorySegment v) {
    PFNGLMULTITEXCOORD1IVARBPROC.invoke(load("glMultiTexCoord1ivARB"), target, v);
  }

  public void glMultiTexCoord4hvNV(int target, MemorySegment v) {
    PFNGLMULTITEXCOORD4HVNVPROC.invoke(load("glMultiTexCoord4hvNV"), target, v);
  }

  public void glShaderBinary(int count, MemorySegment shaders, int binaryFormat, MemorySegment binary, int length) {
    PFNGLSHADERBINARYPROC.invoke(load("glShaderBinary"), count, shaders, binaryFormat, binary, length);
  }

  public void glBufferPageCommitmentMemNV(int target, long offset, long size, int memory, long memOffset, byte commit) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexCoord4bOES(byte s, byte t, byte r, byte q) {
    PFNGLTEXCOORD4BOESPROC.invoke(load("glTexCoord4bOES"), s, t, r, q);
  }

  public void glCoverageModulationNV(int components) {
    PFNGLCOVERAGEMODULATIONNVPROC.invoke(load("glCoverageModulationNV"), components);
  }

  public void glDeletePerfQueryINTEL(int queryHandle) {
    PFNGLDELETEPERFQUERYINTELPROC.invoke(load("glDeletePerfQueryINTEL"), queryHandle);
  }

  public void glGetUniformi64vARB(int program, int location, MemorySegment params) {
    PFNGLGETUNIFORMI64VARBPROC.invoke(load("glGetUniformi64vARB"), program, location, params);
  }

  public void glTexStorage3DMultisample(int target, int samples, int internalformat, int width, int height, int depth, byte fixedsamplelocations) {
    PFNGLTEXSTORAGE3DMULTISAMPLEPROC.invoke(load("glTexStorage3DMultisample"), target, samples, internalformat, width, height, depth, fixedsamplelocations);
  }

  public void glMultiModeDrawElementsIBM(MemorySegment mode, MemorySegment count, int type, MemorySegment indices, int primcount, int modestride) {
    PFNGLMULTIMODEDRAWELEMENTSIBMPROC.invoke(load("glMultiModeDrawElementsIBM"), mode, count, type, indices, primcount, modestride);
  }

  public void glTexCoord2fColor4ubVertex3fSUN(float s, float t, byte r, byte g, byte b, byte a, float x, float y, float z) {
    PFNGLTEXCOORD2FCOLOR4UBVERTEX3FSUNPROC.invoke(load("glTexCoord2fColor4ubVertex3fSUN"), s, t, r, g, b, a, x, y, z);
  }

  public void glUniform4i64NV(int location, long x, long y, long z, long w) {
    PFNGLUNIFORM4I64NVPROC.invoke(load("glUniform4i64NV"), location, x, y, z, w);
  }

  public void glFinalCombinerInputNV(int variable, int input, int mapping, int componentUsage) {
    PFNGLFINALCOMBINERINPUTNVPROC.invoke(load("glFinalCombinerInputNV"), variable, input, mapping, componentUsage);
  }

  public void glMultiDrawElements(int mode, MemorySegment count, int type, MemorySegment indices, int drawcount) {
    PFNGLMULTIDRAWELEMENTSPROC.invoke(load("glMultiDrawElements"), mode, count, type, indices, drawcount);
  }

  public void glProgramUniform1iEXT(int program, int location, int v0) {
    PFNGLPROGRAMUNIFORM1IEXTPROC.invoke(load("glProgramUniform1iEXT"), program, location, v0);
  }

  public void glTexImage3D(int target, int level, int internalformat, int width, int height, int depth, int border, int format, int type, MemorySegment pixels) {
    PFNGLTEXIMAGE3DPROC.invoke(load("glTexImage3D"), target, level, internalformat, width, height, depth, border, format, type, pixels);
  }

  public void glShadingRateQCOM(int rate) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGlobalAlphaFactordSUN(double factor) {
    PFNGLGLOBALALPHAFACTORDSUNPROC.invoke(load("glGlobalAlphaFactordSUN"), factor);
  }

  public void glGetSamplerParameterIuiv(int sampler, int pname, MemorySegment params) {
    PFNGLGETSAMPLERPARAMETERIUIVPROC.invoke(load("glGetSamplerParameterIuiv"), sampler, pname, params);
  }

  public void glFinishTextureSUNX() {
    PFNGLFINISHTEXTURESUNXPROC.invoke(load("glFinishTextureSUNX"));
  }

  public void glVertexAttrib3sARB(int index, short x, short y, short z) {
    PFNGLVERTEXATTRIB3SARBPROC.invoke(load("glVertexAttrib3sARB"), index, x, y, z);
  }

  public void glFramebufferRenderbufferOES(int target, int attachment, int renderbuffertarget, int renderbuffer) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glNormalStream3fATI(int stream, float nx, float ny, float nz) {
    PFNGLNORMALSTREAM3FATIPROC.invoke(load("glNormalStream3fATI"), stream, nx, ny, nz);
  }

  public void glPathParameteriNV(int path, int pname, int value) {
    PFNGLPATHPARAMETERINVPROC.invoke(load("glPathParameteriNV"), path, pname, value);
  }

  public void glNamedBufferStorage(int buffer, long size, MemorySegment data, int flags) {
    PFNGLNAMEDBUFFERSTORAGEPROC.invoke(load("glNamedBufferStorage"), buffer, size, data, flags);
  }

  public void glBindBufferOffsetNV(int target, int index, int buffer, long offset) {
    PFNGLBINDBUFFEROFFSETNVPROC.invoke(load("glBindBufferOffsetNV"), target, index, buffer, offset);
  }

  public void glVertexAttribFormatNV(int index, int size, int type, byte normalized, int stride) {
    PFNGLVERTEXATTRIBFORMATNVPROC.invoke(load("glVertexAttribFormatNV"), index, size, type, normalized, stride);
  }

  public void glBlendFuncSeparate(int sfactorRGB, int dfactorRGB, int sfactorAlpha, int dfactorAlpha) {
    PFNGLBLENDFUNCSEPARATEPROC.invoke(load("glBlendFuncSeparate"), sfactorRGB, dfactorRGB, sfactorAlpha, dfactorAlpha);
  }

  public void glMultiDrawElementsIndirectCountARB(int mode, int type, MemorySegment indirect, long drawcount, int maxdrawcount, int stride) {
    PFNGLMULTIDRAWELEMENTSINDIRECTCOUNTARBPROC.invoke(load("glMultiDrawElementsIndirectCountARB"), mode, type, indirect, drawcount, maxdrawcount, stride);
  }

  public void glBufferData(int target, long size, MemorySegment data, int usage) {
    PFNGLBUFFERDATAPROC.invoke(load("glBufferData"), target, size, data, usage);
  }

  public void glMapControlPointsNV(int target, int index, int type, int ustride, int vstride, int uorder, int vorder, byte packed, MemorySegment points) {
    PFNGLMAPCONTROLPOINTSNVPROC.invoke(load("glMapControlPointsNV"), target, index, type, ustride, vstride, uorder, vorder, packed, points);
  }

  public void glTextureSubImage3DEXT(int texture, int target, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int format, int type, MemorySegment pixels) {
    PFNGLTEXTURESUBIMAGE3DEXTPROC.invoke(load("glTextureSubImage3DEXT"), texture, target, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels);
  }

  public void glDetachShader(int program, int shader) {
    PFNGLDETACHSHADERPROC.invoke(load("glDetachShader"), program, shader);
  }

  public void glTexBuffer(int target, int internalformat, int buffer) {
    PFNGLTEXBUFFERPROC.invoke(load("glTexBuffer"), target, internalformat, buffer);
  }

  public void glGetPointeri_vEXT(int pname, int index, MemorySegment params) {
    PFNGLGETPOINTERI_VEXTPROC.invoke(load("glGetPointeri_vEXT"), pname, index, params);
  }

  public void glClientActiveTextureARB(int texture) {
    PFNGLCLIENTACTIVETEXTUREARBPROC.invoke(load("glClientActiveTextureARB"), texture);
  }

  public void glProgramUniform2iv(int program, int location, int count, MemorySegment value) {
    PFNGLPROGRAMUNIFORM2IVPROC.invoke(load("glProgramUniform2iv"), program, location, count, value);
  }

  public byte glIsEnabledIndexedEXT(int target, int index) {
    return PFNGLISENABLEDINDEXEDEXTPROC.invoke(load("glIsEnabledIndexedEXT"), target, index);
  }

  public void glCopyColorTableSGI(int target, int internalformat, int x, int y, int width) {
    PFNGLCOPYCOLORTABLESGIPROC.invoke(load("glCopyColorTableSGI"), target, internalformat, x, y, width);
  }

  public byte glIsTextureHandleResidentNV(long handle) {
    return PFNGLISTEXTUREHANDLERESIDENTNVPROC.invoke(load("glIsTextureHandleResidentNV"), handle);
  }

  public void glInvalidateBufferSubData(int buffer, long offset, long length) {
    PFNGLINVALIDATEBUFFERSUBDATAPROC.invoke(load("glInvalidateBufferSubData"), buffer, offset, length);
  }

  public int glGenAsyncMarkersSGIX(int range) {
    return PFNGLGENASYNCMARKERSSGIXPROC.invoke(load("glGenAsyncMarkersSGIX"), range);
  }

  public void glGetProgramInfoLog(int program, int bufSize, MemorySegment length, MemorySegment infoLog) {
    PFNGLGETPROGRAMINFOLOGPROC.invoke(load("glGetProgramInfoLog"), program, bufSize, length, infoLog);
  }

  public void glMatrixMultTranspose3x3fNV(int matrixMode, MemorySegment m) {
    PFNGLMATRIXMULTTRANSPOSE3X3FNVPROC.invoke(load("glMatrixMultTranspose3x3fNV"), matrixMode, m);
  }

  public void glFragmentMaterialivSGIX(int face, int pname, MemorySegment params) {
    PFNGLFRAGMENTMATERIALIVSGIXPROC.invoke(load("glFragmentMaterialivSGIX"), face, pname, params);
  }

  public void glMatrixLoadTranspose3x3fNV(int matrixMode, MemorySegment m) {
    PFNGLMATRIXLOADTRANSPOSE3X3FNVPROC.invoke(load("glMatrixLoadTranspose3x3fNV"), matrixMode, m);
  }

  public byte glPointAlongPathNV(int path, int startSegment, int numSegments, float distance, MemorySegment x, MemorySegment y, MemorySegment tangentX, MemorySegment tangentY) {
    return PFNGLPOINTALONGPATHNVPROC.invoke(load("glPointAlongPathNV"), path, startSegment, numSegments, distance, x, y, tangentX, tangentY);
  }

  public void glGetVertexArrayIndexed64iv(int vaobj, int index, int pname, MemorySegment param) {
    PFNGLGETVERTEXARRAYINDEXED64IVPROC.invoke(load("glGetVertexArrayIndexed64iv"), vaobj, index, pname, param);
  }

  public void glProgramUniform2fv(int program, int location, int count, MemorySegment value) {
    PFNGLPROGRAMUNIFORM2FVPROC.invoke(load("glProgramUniform2fv"), program, location, count, value);
  }

  public void glGetFramebufferAttachmentParameterivEXT(int target, int attachment, int pname, MemorySegment params) {
    PFNGLGETFRAMEBUFFERATTACHMENTPARAMETERIVEXTPROC.invoke(load("glGetFramebufferAttachmentParameterivEXT"), target, attachment, pname, params);
  }

  public void glVariantdvEXT(int id, MemorySegment addr) {
    PFNGLVARIANTDVEXTPROC.invoke(load("glVariantdvEXT"), id, addr);
  }

  public void glTexImage2DMultisampleCoverageNV(int target, int coverageSamples, int colorSamples, int internalFormat, int width, int height, byte fixedSampleLocations) {
    PFNGLTEXIMAGE2DMULTISAMPLECOVERAGENVPROC.invoke(load("glTexImage2DMultisampleCoverageNV"), target, coverageSamples, colorSamples, internalFormat, width, height, fixedSampleLocations);
  }

  public void glVertexAttribI2uiv(int index, MemorySegment v) {
    PFNGLVERTEXATTRIBI2UIVPROC.invoke(load("glVertexAttribI2uiv"), index, v);
  }

  public void glNamedRenderbufferStorageMultisampleAdvancedAMD(int renderbuffer, int samples, int storageSamples, int internalformat, int width, int height) {
    PFNGLNAMEDRENDERBUFFERSTORAGEMULTISAMPLEADVANCEDAMDPROC.invoke(load("glNamedRenderbufferStorageMultisampleAdvancedAMD"), renderbuffer, samples, storageSamples, internalformat, width, height);
  }

  public void glEnableVariantClientStateEXT(int id) {
    PFNGLENABLEVARIANTCLIENTSTATEEXTPROC.invoke(load("glEnableVariantClientStateEXT"), id);
  }

  public void glBufferStorageExternalEXT(int target, long offset, long size, MemorySegment clientBuffer, int flags) {
    PFNGLBUFFERSTORAGEEXTERNALEXTPROC.invoke(load("glBufferStorageExternalEXT"), target, offset, size, clientBuffer, flags);
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
    PFNGLGETNCOLORTABLEARBPROC.invoke(load("glGetnColorTableARB"), target, format, type, bufSize, table);
  }

  public void glDrawTransformFeedback(int mode, int id) {
    PFNGLDRAWTRANSFORMFEEDBACKPROC.invoke(load("glDrawTransformFeedback"), mode, id);
  }

  public void glUniform4ui(int location, int v0, int v1, int v2, int v3) {
    PFNGLUNIFORM4UIPROC.invoke(load("glUniform4ui"), location, v0, v1, v2, v3);
  }

  public void glUniform1ui64NV(int location, long x) {
    PFNGLUNIFORM1UI64NVPROC.invoke(load("glUniform1ui64NV"), location, x);
  }

  public void glPathSubCommandsNV(int path, int commandStart, int commandsToDelete, int numCommands, MemorySegment commands, int numCoords, int coordType, MemorySegment coords) {
    PFNGLPATHSUBCOMMANDSNVPROC.invoke(load("glPathSubCommandsNV"), path, commandStart, commandsToDelete, numCommands, commands, numCoords, coordType, coords);
  }

  public void glMultiTexParameterIivEXT(int texunit, int target, int pname, MemorySegment params) {
    PFNGLMULTITEXPARAMETERIIVEXTPROC.invoke(load("glMultiTexParameterIivEXT"), texunit, target, pname, params);
  }

  public void glTextureImage2DMultisampleCoverageNV(int texture, int target, int coverageSamples, int colorSamples, int internalFormat, int width, int height, byte fixedSampleLocations) {
    PFNGLTEXTUREIMAGE2DMULTISAMPLECOVERAGENVPROC.invoke(load("glTextureImage2DMultisampleCoverageNV"), texture, target, coverageSamples, colorSamples, internalFormat, width, height, fixedSampleLocations);
  }

  public void glWeightdvARB(int size, MemorySegment weights) {
    PFNGLWEIGHTDVARBPROC.invoke(load("glWeightdvARB"), size, weights);
  }

  public void glMultiTexCoord3svARB(int target, MemorySegment v) {
    PFNGLMULTITEXCOORD3SVARBPROC.invoke(load("glMultiTexCoord3svARB"), target, v);
  }

  public void glCopyBufferSubDataNV(int readTarget, int writeTarget, long readOffset, long writeOffset, long size) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBufferStorageMemEXT(int target, long size, int memory, long offset) {
    PFNGLBUFFERSTORAGEMEMEXTPROC.invoke(load("glBufferStorageMemEXT"), target, size, memory, offset);
  }

  public void glPointParameteriv(int pname, MemorySegment params) {
    PFNGLPOINTPARAMETERIVPROC.invoke(load("glPointParameteriv"), pname, params);
  }

  public void glBeginFragmentShaderATI() {
    PFNGLBEGINFRAGMENTSHADERATIPROC.invoke(load("glBeginFragmentShaderATI"));
  }

  public void glDrawElementsInstancedBaseInstanceEXT(int mode, int count, int type, MemorySegment indices, int instancecount, int baseinstance) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniform3ui64vARB(int program, int location, int count, MemorySegment value) {
    PFNGLPROGRAMUNIFORM3UI64VARBPROC.invoke(load("glProgramUniform3ui64vARB"), program, location, count, value);
  }

  public void glVertexAttribI4uiv(int index, MemorySegment v) {
    PFNGLVERTEXATTRIBI4UIVPROC.invoke(load("glVertexAttribI4uiv"), index, v);
  }

  public void glGetProgramLocalParameterIuivNV(int target, int index, MemorySegment params) {
    PFNGLGETPROGRAMLOCALPARAMETERIUIVNVPROC.invoke(load("glGetProgramLocalParameterIuivNV"), target, index, params);
  }

  public void glVertexAttrib2dvARB(int index, MemorySegment v) {
    PFNGLVERTEXATTRIB2DVARBPROC.invoke(load("glVertexAttrib2dvARB"), index, v);
  }

  public void glCompressedMultiTexImage3DEXT(int texunit, int target, int level, int internalformat, int width, int height, int depth, int border, int imageSize, MemorySegment bits) {
    PFNGLCOMPRESSEDMULTITEXIMAGE3DEXTPROC.invoke(load("glCompressedMultiTexImage3DEXT"), texunit, target, level, internalformat, width, height, depth, border, imageSize, bits);
  }

  public void glNormalStream3iATI(int stream, int nx, int ny, int nz) {
    PFNGLNORMALSTREAM3IATIPROC.invoke(load("glNormalStream3iATI"), stream, nx, ny, nz);
  }

  public void glPushDebugGroup(int source, int id, int length, MemorySegment message) {
    PFNGLPUSHDEBUGGROUPPROC.invoke(load("glPushDebugGroup"), source, id, length, message);
  }

  public void glMultiDrawArraysIndirectBindlessCountNV(int mode, MemorySegment indirect, int drawCount, int maxDrawCount, int stride, int vertexBufferCount) {
    PFNGLMULTIDRAWARRAYSINDIRECTBINDLESSCOUNTNVPROC.invoke(load("glMultiDrawArraysIndirectBindlessCountNV"), mode, indirect, drawCount, maxDrawCount, stride, vertexBufferCount);
  }

  public void glGetObjectParameterivAPPLE(int objectType, int name, int pname, MemorySegment params) {
    PFNGLGETOBJECTPARAMETERIVAPPLEPROC.invoke(load("glGetObjectParameterivAPPLE"), objectType, name, pname, params);
  }

  public void glTexStorageAttribs2DEXT(int target, int levels, int internalformat, int width, int height, int attrib_list) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribLPointerEXT(int index, int size, int type, int stride, MemorySegment pointer) {
    PFNGLVERTEXATTRIBLPOINTEREXTPROC.invoke(load("glVertexAttribLPointerEXT"), index, size, type, stride, pointer);
  }

  public long glVDPAURegisterVideoSurfaceWithPictureStructureNV(MemorySegment vdpSurface, int target, int numTextureNames, MemorySegment textureNames, byte isFrameStructure) {
    return PFNGLVDPAUREGISTERVIDEOSURFACEWITHPICTURESTRUCTURENVPROC.invoke(load("glVDPAURegisterVideoSurfaceWithPictureStructureNV"), vdpSurface, target, numTextureNames, textureNames, isFrameStructure);
  }

  public void glAlphaFuncx(int func, int ref) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetConvolutionParameterxvOES(int target, int pname, MemorySegment params) {
    PFNGLGETCONVOLUTIONPARAMETERXVOESPROC.invoke(load("glGetConvolutionParameterxvOES"), target, pname, params);
  }

  public void glTbufferMask3DFX(int mask) {
    PFNGLTBUFFERMASK3DFXPROC.invoke(load("glTbufferMask3DFX"), mask);
  }

  public void glUniformHandleui64vIMG(int location, int count, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetCoverageModulationTableNV(int bufSize, MemorySegment v) {
    PFNGLGETCOVERAGEMODULATIONTABLENVPROC.invoke(load("glGetCoverageModulationTableNV"), bufSize, v);
  }

  public void glInvalidateNamedFramebufferData(int framebuffer, int numAttachments, MemorySegment attachments) {
    PFNGLINVALIDATENAMEDFRAMEBUFFERDATAPROC.invoke(load("glInvalidateNamedFramebufferData"), framebuffer, numAttachments, attachments);
  }

  public void glColor4ubVertex3fSUN(byte r, byte g, byte b, byte a, float x, float y, float z) {
    PFNGLCOLOR4UBVERTEX3FSUNPROC.invoke(load("glColor4ubVertex3fSUN"), r, g, b, a, x, y, z);
  }

  public void glVertexAttribPointer(int index, int size, int type, byte normalized, int stride, MemorySegment pointer) {
    PFNGLVERTEXATTRIBPOINTERPROC.invoke(load("glVertexAttribPointer"), index, size, type, normalized, stride, pointer);
  }

  public void glCoverageMaskNV(byte mask) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFragmentLightiSGIX(int light, int pname, int param) {
    PFNGLFRAGMENTLIGHTISGIXPROC.invoke(load("glFragmentLightiSGIX"), light, pname, param);
  }

  public void glBlendFunciARB(int buf, int src, int dst) {
    PFNGLBLENDFUNCIARBPROC.invoke(load("glBlendFunciARB"), buf, src, dst);
  }

  public void glMultiTexCoord2iARB(int target, int s, int t) {
    PFNGLMULTITEXCOORD2IARBPROC.invoke(load("glMultiTexCoord2iARB"), target, s, t);
  }

  public void glConvolutionParameterivEXT(int target, int pname, MemorySegment params) {
    PFNGLCONVOLUTIONPARAMETERIVEXTPROC.invoke(load("glConvolutionParameterivEXT"), target, pname, params);
  }

  public void glFramebufferRenderbufferEXT(int target, int attachment, int renderbuffertarget, int renderbuffer) {
    PFNGLFRAMEBUFFERRENDERBUFFEREXTPROC.invoke(load("glFramebufferRenderbufferEXT"), target, attachment, renderbuffertarget, renderbuffer);
  }

  public void glGetUnsignedBytei_vEXT(int target, int index, MemorySegment data) {
    PFNGLGETUNSIGNEDBYTEI_VEXTPROC.invoke(load("glGetUnsignedBytei_vEXT"), target, index, data);
  }

  public void glNormal3hvNV(MemorySegment v) {
    PFNGLNORMAL3HVNVPROC.invoke(load("glNormal3hvNV"), v);
  }

  public void glFramebufferTextureLayerEXT(int target, int attachment, int texture, int level, int layer) {
    PFNGLFRAMEBUFFERTEXTURELAYEREXTPROC.invoke(load("glFramebufferTextureLayerEXT"), target, attachment, texture, level, layer);
  }

  public void glActiveTextureARB(int texture) {
    PFNGLACTIVETEXTUREARBPROC.invoke(load("glActiveTextureARB"), texture);
  }

  public void glBlendEquationOES(int mode) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGenerateMipmapOES(int target) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniform4uiv(int location, int count, MemorySegment value) {
    PFNGLUNIFORM4UIVPROC.invoke(load("glUniform4uiv"), location, count, value);
  }

  public void glDeleteQueriesARB(int n, MemorySegment ids) {
    PFNGLDELETEQUERIESARBPROC.invoke(load("glDeleteQueriesARB"), n, ids);
  }

  public void glNormalP3uiv(int type, MemorySegment coords) {
    PFNGLNORMALP3UIVPROC.invoke(load("glNormalP3uiv"), type, coords);
  }

  public void glVertexAttribI4ubvEXT(int index, MemorySegment v) {
    PFNGLVERTEXATTRIBI4UBVEXTPROC.invoke(load("glVertexAttribI4ubvEXT"), index, v);
  }

  public void glBindBufferRangeEXT(int target, int index, int buffer, long offset, long size) {
    PFNGLBINDBUFFERRANGEEXTPROC.invoke(load("glBindBufferRangeEXT"), target, index, buffer, offset, size);
  }

  public void glVertexAttrib2hNV(int index, short x, short y) {
    PFNGLVERTEXATTRIB2HNVPROC.invoke(load("glVertexAttrib2hNV"), index, x, y);
  }

  public void glPointParameterfv(int pname, MemorySegment params) {
    PFNGLPOINTPARAMETERFVPROC.invoke(load("glPointParameterfv"), pname, params);
  }

  public void glDrawCommandsStatesAddressNV(MemorySegment indirects, MemorySegment sizes, MemorySegment states, MemorySegment fbos, int count) {
    PFNGLDRAWCOMMANDSSTATESADDRESSNVPROC.invoke(load("glDrawCommandsStatesAddressNV"), indirects, sizes, states, fbos, count);
  }

  public void glCoverageOperationNV(int operation) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBindImageTextures(int first, int count, MemorySegment textures) {
    PFNGLBINDIMAGETEXTURESPROC.invoke(load("glBindImageTextures"), first, count, textures);
  }

  public void glNamedRenderbufferStorageMultisampleCoverageEXT(int renderbuffer, int coverageSamples, int colorSamples, int internalformat, int width, int height) {
    PFNGLNAMEDRENDERBUFFERSTORAGEMULTISAMPLECOVERAGEEXTPROC.invoke(load("glNamedRenderbufferStorageMultisampleCoverageEXT"), renderbuffer, coverageSamples, colorSamples, internalformat, width, height);
  }

  public void glMultiTexEnvfvEXT(int texunit, int target, int pname, MemorySegment params) {
    PFNGLMULTITEXENVFVEXTPROC.invoke(load("glMultiTexEnvfvEXT"), texunit, target, pname, params);
  }

  public void glUniform3uivEXT(int location, int count, MemorySegment value) {
    PFNGLUNIFORM3UIVEXTPROC.invoke(load("glUniform3uivEXT"), location, count, value);
  }

  public void glTagSampleBufferSGIX() {
    PFNGLTAGSAMPLEBUFFERSGIXPROC.invoke(load("glTagSampleBufferSGIX"));
  }

  public void glUniform3iv(int location, int count, MemorySegment value) {
    PFNGLUNIFORM3IVPROC.invoke(load("glUniform3iv"), location, count, value);
  }

  public void glProgramUniform1dEXT(int program, int location, double x) {
    PFNGLPROGRAMUNIFORM1DEXTPROC.invoke(load("glProgramUniform1dEXT"), program, location, x);
  }

  public void glClipPlanefIMG(int p, MemorySegment eqn) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribL1ui64ARB(int index, long x) {
    PFNGLVERTEXATTRIBL1UI64ARBPROC.invoke(load("glVertexAttribL1ui64ARB"), index, x);
  }

  public void glIndexFuncEXT(int func, float ref) {
    PFNGLINDEXFUNCEXTPROC.invoke(load("glIndexFuncEXT"), func, ref);
  }

  public void glUniform3i64ARB(int location, long x, long y, long z) {
    PFNGLUNIFORM3I64ARBPROC.invoke(load("glUniform3i64ARB"), location, x, y, z);
  }

  public void glGetnMapfvARB(int target, int query, int bufSize, MemorySegment v) {
    PFNGLGETNMAPFVARBPROC.invoke(load("glGetnMapfvARB"), target, query, bufSize, v);
  }

  public void glClearBufferSubData(int target, int internalformat, long offset, long size, int format, int type, MemorySegment data) {
    PFNGLCLEARBUFFERSUBDATAPROC.invoke(load("glClearBufferSubData"), target, internalformat, offset, size, format, type, data);
  }

  public void glCompressedTexImage3DOES(int target, int level, int internalformat, int width, int height, int depth, int border, int imageSize, MemorySegment data) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetnMinmaxARB(int target, byte reset, int format, int type, int bufSize, MemorySegment values) {
    PFNGLGETNMINMAXARBPROC.invoke(load("glGetnMinmaxARB"), target, reset, format, type, bufSize, values);
  }

  public void glGetQueryObjectui64vEXT(int id, int pname, MemorySegment params) {
    PFNGLGETQUERYOBJECTUI64VEXTPROC.invoke(load("glGetQueryObjectui64vEXT"), id, pname, params);
  }

  public void glGetMultiTexGenivEXT(int texunit, int coord, int pname, MemorySegment params) {
    PFNGLGETMULTITEXGENIVEXTPROC.invoke(load("glGetMultiTexGenivEXT"), texunit, coord, pname, params);
  }

  public void glProvokingVertex(int mode) {
    PFNGLPROVOKINGVERTEXPROC.invoke(load("glProvokingVertex"), mode);
  }

  public void glGetTexLevelParameterxvOES(int target, int level, int pname, MemorySegment params) {
    PFNGLGETTEXLEVELPARAMETERXVOESPROC.invoke(load("glGetTexLevelParameterxvOES"), target, level, pname, params);
  }

  public byte glIsVertexAttribEnabledAPPLE(int index, int pname) {
    return PFNGLISVERTEXATTRIBENABLEDAPPLEPROC.invoke(load("glIsVertexAttribEnabledAPPLE"), index, pname);
  }

  public void glEndPerfMonitorAMD(int monitor) {
    PFNGLENDPERFMONITORAMDPROC.invoke(load("glEndPerfMonitorAMD"), monitor);
  }

  public void glGetNamedFramebufferParameterfvAMD(int framebuffer, int pname, int numsamples, int pixelindex, int size, MemorySegment values) {
    PFNGLGETNAMEDFRAMEBUFFERPARAMETERFVAMDPROC.invoke(load("glGetNamedFramebufferParameterfvAMD"), framebuffer, pname, numsamples, pixelindex, size, values);
  }

  public void glDrawRangeElementArrayATI(int mode, int start, int end, int count) {
    PFNGLDRAWRANGEELEMENTARRAYATIPROC.invoke(load("glDrawRangeElementArrayATI"), mode, start, end, count);
  }

  public void glEGLImageTargetRenderbufferStorageOES(int target, MemorySegment image) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetVariantFloatvEXT(int id, int value, MemorySegment data) {
    PFNGLGETVARIANTFLOATVEXTPROC.invoke(load("glGetVariantFloatvEXT"), id, value, data);
  }

  public void glBlendEquationSeparateIndexedAMD(int buf, int modeRGB, int modeAlpha) {
    PFNGLBLENDEQUATIONSEPARATEINDEXEDAMDPROC.invoke(load("glBlendEquationSeparateIndexedAMD"), buf, modeRGB, modeAlpha);
  }

  public void glPNTrianglesiATI(int pname, int param) {
    PFNGLPNTRIANGLESIATIPROC.invoke(load("glPNTrianglesiATI"), pname, param);
  }

  public void glFragmentMaterialfvSGIX(int face, int pname, MemorySegment params) {
    PFNGLFRAGMENTMATERIALFVSGIXPROC.invoke(load("glFragmentMaterialfvSGIX"), face, pname, params);
  }

  public void glStencilFuncSeparateATI(int frontfunc, int backfunc, int ref, int mask) {
    PFNGLSTENCILFUNCSEPARATEATIPROC.invoke(load("glStencilFuncSeparateATI"), frontfunc, backfunc, ref, mask);
  }

  public void glCreateStatesNV(int n, MemorySegment states) {
    PFNGLCREATESTATESNVPROC.invoke(load("glCreateStatesNV"), n, states);
  }

  public void glTextureLightEXT(int pname) {
    PFNGLTEXTURELIGHTEXTPROC.invoke(load("glTextureLightEXT"), pname);
  }

  public void glMatrixIndexPointerARB(int size, int type, int stride, MemorySegment pointer) {
    PFNGLMATRIXINDEXPOINTERARBPROC.invoke(load("glMatrixIndexPointerARB"), size, type, stride, pointer);
  }

  public void glTexCoord4fVertex4fSUN(float s, float t, float p, float q, float x, float y, float z, float w) {
    PFNGLTEXCOORD4FVERTEX4FSUNPROC.invoke(load("glTexCoord4fVertex4fSUN"), s, t, p, q, x, y, z, w);
  }

  public void glPixelMapx(int map, int size, MemorySegment values) {
    PFNGLPIXELMAPXPROC.invoke(load("glPixelMapx"), map, size, values);
  }

  public void glNormalPointerListIBM(int type, int stride, MemorySegment pointer, int ptrstride) {
    PFNGLNORMALPOINTERLISTIBMPROC.invoke(load("glNormalPointerListIBM"), type, stride, pointer, ptrstride);
  }

  public byte glIsEnablediNV(int target, int index) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniform2fARB(int location, float v0, float v1) {
    PFNGLUNIFORM2FARBPROC.invoke(load("glUniform2fARB"), location, v0, v1);
  }

  public void glVariantubvEXT(int id, MemorySegment addr) {
    PFNGLVARIANTUBVEXTPROC.invoke(load("glVariantubvEXT"), id, addr);
  }

  public void glStringMarkerGREMEDY(int len, MemorySegment string) {
    PFNGLSTRINGMARKERGREMEDYPROC.invoke(load("glStringMarkerGREMEDY"), len, string);
  }

  public void glSignalVkSemaphoreNV(long vkSemaphore) {
    PFNGLSIGNALVKSEMAPHORENVPROC.invoke(load("glSignalVkSemaphoreNV"), vkSemaphore);
  }

  public void glDrawTransformFeedbackInstanced(int mode, int id, int instancecount) {
    PFNGLDRAWTRANSFORMFEEDBACKINSTANCEDPROC.invoke(load("glDrawTransformFeedbackInstanced"), mode, id, instancecount);
  }

  public void glScissorIndexedOES(int index, int left, int bottom, int width, int height) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetTextureLevelParameterfv(int texture, int level, int pname, MemorySegment params) {
    PFNGLGETTEXTURELEVELPARAMETERFVPROC.invoke(load("glGetTextureLevelParameterfv"), texture, level, pname, params);
  }

  public void glVideoCaptureStreamParameterivNV(int video_capture_slot, int stream, int pname, MemorySegment params) {
    PFNGLVIDEOCAPTURESTREAMPARAMETERIVNVPROC.invoke(load("glVideoCaptureStreamParameterivNV"), video_capture_slot, stream, pname, params);
  }

  public void glGlobalAlphaFactorubSUN(byte factor) {
    PFNGLGLOBALALPHAFACTORUBSUNPROC.invoke(load("glGlobalAlphaFactorubSUN"), factor);
  }

  public void glCullParameterfvEXT(int pname, MemorySegment params) {
    PFNGLCULLPARAMETERFVEXTPROC.invoke(load("glCullParameterfvEXT"), pname, params);
  }

  public void glUniformBlockBinding(int program, int uniformBlockIndex, int uniformBlockBinding) {
    PFNGLUNIFORMBLOCKBINDINGPROC.invoke(load("glUniformBlockBinding"), program, uniformBlockIndex, uniformBlockBinding);
  }

  public void glCopyMultiTexSubImage2DEXT(int texunit, int target, int level, int xoffset, int yoffset, int x, int y, int width, int height) {
    PFNGLCOPYMULTITEXSUBIMAGE2DEXTPROC.invoke(load("glCopyMultiTexSubImage2DEXT"), texunit, target, level, xoffset, yoffset, x, y, width, height);
  }

  public void glClientAttribDefaultEXT(int mask) {
    PFNGLCLIENTATTRIBDEFAULTEXTPROC.invoke(load("glClientAttribDefaultEXT"), mask);
  }

  public int glCheckFramebufferStatus(int target) {
    return PFNGLCHECKFRAMEBUFFERSTATUSPROC.invoke(load("glCheckFramebufferStatus"), target);
  }

  public void glDeleteProgramsNV(int n, MemorySegment programs) {
    PFNGLDELETEPROGRAMSNVPROC.invoke(load("glDeleteProgramsNV"), n, programs);
  }

  public void glGlobalAlphaFactorsSUN(short factor) {
    PFNGLGLOBALALPHAFACTORSSUNPROC.invoke(load("glGlobalAlphaFactorsSUN"), factor);
  }

  public void glListParameterfSGIX(int list, int pname, float param) {
    PFNGLLISTPARAMETERFSGIXPROC.invoke(load("glListParameterfSGIX"), list, pname, param);
  }

  public void glGetnPixelMapfvARB(int map, int bufSize, MemorySegment values) {
    PFNGLGETNPIXELMAPFVARBPROC.invoke(load("glGetnPixelMapfvARB"), map, bufSize, values);
  }

  public void glGetActiveUniformName(int program, int uniformIndex, int bufSize, MemorySegment length, MemorySegment uniformName) {
    PFNGLGETACTIVEUNIFORMNAMEPROC.invoke(load("glGetActiveUniformName"), program, uniformIndex, bufSize, length, uniformName);
  }

  public void glBlendEquationIndexedAMD(int buf, int mode) {
    PFNGLBLENDEQUATIONINDEXEDAMDPROC.invoke(load("glBlendEquationIndexedAMD"), buf, mode);
  }

  public void glDrawElementsInstanced(int mode, int count, int type, MemorySegment indices, int instancecount) {
    PFNGLDRAWELEMENTSINSTANCEDPROC.invoke(load("glDrawElementsInstanced"), mode, count, type, indices, instancecount);
  }

  public void glProgramUniform2fEXT(int program, int location, float v0, float v1) {
    PFNGLPROGRAMUNIFORM2FEXTPROC.invoke(load("glProgramUniform2fEXT"), program, location, v0, v1);
  }

  public void glMultiTexParameterfEXT(int texunit, int target, int pname, float param) {
    PFNGLMULTITEXPARAMETERFEXTPROC.invoke(load("glMultiTexParameterfEXT"), texunit, target, pname, param);
  }

  public void glGetPathCommandsNV(int path, MemorySegment commands) {
    PFNGLGETPATHCOMMANDSNVPROC.invoke(load("glGetPathCommandsNV"), path, commands);
  }

  public void glResumeTransformFeedback() {
    PFNGLRESUMETRANSFORMFEEDBACKPROC.invoke(load("glResumeTransformFeedback"));
  }

  public void glGetProgramResourcefvNV(int program, int programInterface, int index, int propCount, MemorySegment props, int count, MemorySegment length, MemorySegment params) {
    PFNGLGETPROGRAMRESOURCEFVNVPROC.invoke(load("glGetProgramResourcefvNV"), program, programInterface, index, propCount, props, count, length, params);
  }

  public void glShadingRateSampleOrderNV(int order) {
    PFNGLSHADINGRATESAMPLEORDERNVPROC.invoke(load("glShadingRateSampleOrderNV"), order);
  }

  public void glGetProgramBinaryOES(int program, int bufSize, MemorySegment length, MemorySegment binaryFormat, MemorySegment binary) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glCopyTextureSubImage3DEXT(int texture, int target, int level, int xoffset, int yoffset, int zoffset, int x, int y, int width, int height) {
    PFNGLCOPYTEXTURESUBIMAGE3DEXTPROC.invoke(load("glCopyTextureSubImage3DEXT"), texture, target, level, xoffset, yoffset, zoffset, x, y, width, height);
  }

  public void glMulticastWaitSyncNV(int signalGpu, int waitGpuMask) {
    PFNGLMULTICASTWAITSYNCNVPROC.invoke(load("glMulticastWaitSyncNV"), signalGpu, waitGpuMask);
  }

  public void glMinmax(int target, int internalformat, byte sink) {
    PFNGLMINMAXEXTPROC.invoke(load("glMinmax"), target, internalformat, sink);
  }

  public void glVertexAttribP3ui(int index, int type, byte normalized, int value) {
    PFNGLVERTEXATTRIBP3UIPROC.invoke(load("glVertexAttribP3ui"), index, type, normalized, value);
  }

  public void glVertexPointervINTEL(int size, int type, MemorySegment pointer) {
    PFNGLVERTEXPOINTERVINTELPROC.invoke(load("glVertexPointervINTEL"), size, type, pointer);
  }

  public void glBindFramebuffer(int target, int framebuffer) {
    PFNGLBINDFRAMEBUFFERPROC.invoke(load("glBindFramebuffer"), target, framebuffer);
  }

  public void glColor3xvOES(MemorySegment components) {
    PFNGLCOLOR3XVOESPROC.invoke(load("glColor3xvOES"), components);
  }

  public void glDeleteQueries(int n, MemorySegment ids) {
    PFNGLDELETEQUERIESPROC.invoke(load("glDeleteQueries"), n, ids);
  }

  public void glMakeBufferNonResidentNV(int target) {
    PFNGLMAKEBUFFERNONRESIDENTNVPROC.invoke(load("glMakeBufferNonResidentNV"), target);
  }

  public void glVertexStream2dvATI(int stream, MemorySegment coords) {
    PFNGLVERTEXSTREAM2DVATIPROC.invoke(load("glVertexStream2dvATI"), stream, coords);
  }

  public void glTransformFeedbackAttribsNV(int count, MemorySegment attribs, int bufferMode) {
    PFNGLTRANSFORMFEEDBACKATTRIBSNVPROC.invoke(load("glTransformFeedbackAttribsNV"), count, attribs, bufferMode);
  }

  public void glSecondaryColor3usvEXT(MemorySegment v) {
    PFNGLSECONDARYCOLOR3USVEXTPROC.invoke(load("glSecondaryColor3usvEXT"), v);
  }

  public void glGetUniformiv(int program, int location, MemorySegment params) {
    PFNGLGETUNIFORMIVPROC.invoke(load("glGetUniformiv"), program, location, params);
  }

  public byte glIsFenceAPPLE(int fence) {
    return PFNGLISFENCEAPPLEPROC.invoke(load("glIsFenceAPPLE"), fence);
  }

  public void glFrustumfOES(float l, float r, float b, float t, float n, float f) {
    PFNGLFRUSTUMFOESPROC.invoke(load("glFrustumfOES"), l, r, b, t, n, f);
  }

  public void glUniform3dv(int location, int count, MemorySegment value) {
    PFNGLUNIFORM3DVPROC.invoke(load("glUniform3dv"), location, count, value);
  }

  public void glColorTableParameteriv(int target, int pname, MemorySegment params) {
    PFNGLCOLORTABLEPARAMETERIVSGIPROC.invoke(load("glColorTableParameteriv"), target, pname, params);
  }

  public void glGetShaderInfoLog(int shader, int bufSize, MemorySegment length, MemorySegment infoLog) {
    PFNGLGETSHADERINFOLOGPROC.invoke(load("glGetShaderInfoLog"), shader, bufSize, length, infoLog);
  }

  public void glSecondaryColor3dEXT(double red, double green, double blue) {
    PFNGLSECONDARYCOLOR3DEXTPROC.invoke(load("glSecondaryColor3dEXT"), red, green, blue);
  }

  public void glVertexAttribI4usv(int index, MemorySegment v) {
    PFNGLVERTEXATTRIBI4USVPROC.invoke(load("glVertexAttribI4usv"), index, v);
  }

  public void glDrawBuffersEXT(int n, MemorySegment bufs) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniformMatrix2x4dvEXT(int program, int location, int count, byte transpose, MemorySegment value) {
    PFNGLPROGRAMUNIFORMMATRIX2X4DVEXTPROC.invoke(load("glProgramUniformMatrix2x4dvEXT"), program, location, count, transpose, value);
  }

  public void glCopyTexImage1DEXT(int target, int level, int internalformat, int x, int y, int width, int border) {
    PFNGLCOPYTEXIMAGE1DEXTPROC.invoke(load("glCopyTexImage1DEXT"), target, level, internalformat, x, y, width, border);
  }

  public int glCreateShaderProgramvEXT(int type, int count, MemorySegment strings) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFramebufferTexture(int target, int attachment, int texture, int level) {
    PFNGLFRAMEBUFFERTEXTUREPROC.invoke(load("glFramebufferTexture"), target, attachment, texture, level);
  }

  public void glNamedProgramLocalParameters4fvEXT(int program, int target, int index, int count, MemorySegment params) {
    PFNGLNAMEDPROGRAMLOCALPARAMETERS4FVEXTPROC.invoke(load("glNamedProgramLocalParameters4fvEXT"), program, target, index, count, params);
  }

  public void glGetVideoivNV(int video_slot, int pname, MemorySegment params) {
    PFNGLGETVIDEOIVNVPROC.invoke(load("glGetVideoivNV"), video_slot, pname, params);
  }

  public void glGetNamedRenderbufferParameterivEXT(int renderbuffer, int pname, MemorySegment params) {
    PFNGLGETNAMEDRENDERBUFFERPARAMETERIVEXTPROC.invoke(load("glGetNamedRenderbufferParameterivEXT"), renderbuffer, pname, params);
  }

  public void glCompressedTextureSubImage3D(int texture, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int format, int imageSize, MemorySegment data) {
    PFNGLCOMPRESSEDTEXTURESUBIMAGE3DPROC.invoke(load("glCompressedTextureSubImage3D"), texture, level, xoffset, yoffset, zoffset, width, height, depth, format, imageSize, data);
  }

  public void glGetClipPlanefOES(int plane, MemorySegment equation) {
    PFNGLGETCLIPPLANEFOESPROC.invoke(load("glGetClipPlanefOES"), plane, equation);
  }

  public void glMapVertexAttrib2dAPPLE(int index, int size, double u1, double u2, int ustride, int uorder, double v1, double v2, int vstride, int vorder, MemorySegment points) {
    PFNGLMAPVERTEXATTRIB2DAPPLEPROC.invoke(load("glMapVertexAttrib2dAPPLE"), index, size, u1, u2, ustride, uorder, v1, v2, vstride, vorder, points);
  }

  public void glFinishObjectAPPLE(int object, int name) {
    PFNGLFINISHOBJECTAPPLEPROC.invoke(load("glFinishObjectAPPLE"), object, name);
  }

  public void glVertexAttrib1dvNV(int index, MemorySegment v) {
    PFNGLVERTEXATTRIB1DVNVPROC.invoke(load("glVertexAttrib1dvNV"), index, v);
  }

  public void glGetRenderbufferParameterivOES(int target, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glViewportIndexedfNV(int index, float x, float y, float w, float h) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexGendEXT(int texunit, int coord, int pname, double param) {
    PFNGLMULTITEXGENDEXTPROC.invoke(load("glMultiTexGendEXT"), texunit, coord, pname, param);
  }

  public void glGetnUniformui64vARB(int program, int location, int bufSize, MemorySegment params) {
    PFNGLGETNUNIFORMUI64VARBPROC.invoke(load("glGetnUniformui64vARB"), program, location, bufSize, params);
  }

  public void glTexCoord1bvOES(MemorySegment coords) {
    PFNGLTEXCOORD1BVOESPROC.invoke(load("glTexCoord1bvOES"), coords);
  }

  public void glVertexArrayAttribFormat(int vaobj, int attribindex, int size, int type, byte normalized, int relativeoffset) {
    PFNGLVERTEXARRAYATTRIBFORMATPROC.invoke(load("glVertexArrayAttribFormat"), vaobj, attribindex, size, type, normalized, relativeoffset);
  }

  public void glFogCoordPointerListIBM(int type, int stride, MemorySegment pointer, int ptrstride) {
    PFNGLFOGCOORDPOINTERLISTIBMPROC.invoke(load("glFogCoordPointerListIBM"), type, stride, pointer, ptrstride);
  }

  public void glVertexArrayAttribIFormat(int vaobj, int attribindex, int size, int type, int relativeoffset) {
    PFNGLVERTEXARRAYATTRIBIFORMATPROC.invoke(load("glVertexArrayAttribIFormat"), vaobj, attribindex, size, type, relativeoffset);
  }

  public void glReplacementCodeuiColor4ubVertex3fvSUN(MemorySegment rc, MemorySegment c, MemorySegment v) {
    PFNGLREPLACEMENTCODEUICOLOR4UBVERTEX3FVSUNPROC.invoke(load("glReplacementCodeuiColor4ubVertex3fvSUN"), rc, c, v);
  }

  public void glUniform3fv(int location, int count, MemorySegment value) {
    PFNGLUNIFORM3FVPROC.invoke(load("glUniform3fv"), location, count, value);
  }

  public void glGetPixelTransformParameterfvEXT(int target, int pname, MemorySegment params) {
    PFNGLGETPIXELTRANSFORMPARAMETERFVEXTPROC.invoke(load("glGetPixelTransformParameterfvEXT"), target, pname, params);
  }

  public void glMatrixLoad3x3fNV(int matrixMode, MemorySegment m) {
    PFNGLMATRIXLOAD3X3FNVPROC.invoke(load("glMatrixLoad3x3fNV"), matrixMode, m);
  }

  public void glProgramLocalParameters4fvEXT(int target, int index, int count, MemorySegment params) {
    PFNGLPROGRAMLOCALPARAMETERS4FVEXTPROC.invoke(load("glProgramLocalParameters4fvEXT"), target, index, count, params);
  }

  public void glVertexArrayVertexBuffers(int vaobj, int first, int count, MemorySegment buffers, MemorySegment offsets, MemorySegment strides) {
    PFNGLVERTEXARRAYVERTEXBUFFERSPROC.invoke(load("glVertexArrayVertexBuffers"), vaobj, first, count, buffers, offsets, strides);
  }

  public void glDrawElementsBaseVertexOES(int mode, int count, int type, MemorySegment indices, int basevertex) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexCoordP1uiv(int texture, int type, MemorySegment coords) {
    PFNGLMULTITEXCOORDP1UIVPROC.invoke(load("glMultiTexCoordP1uiv"), texture, type, coords);
  }

  public void glVertexAttrib4dARB(int index, double x, double y, double z, double w) {
    PFNGLVERTEXATTRIB4DARBPROC.invoke(load("glVertexAttrib4dARB"), index, x, y, z, w);
  }

  public void glWindowPos3sMESA(short x, short y, short z) {
    PFNGLWINDOWPOS3SMESAPROC.invoke(load("glWindowPos3sMESA"), x, y, z);
  }

  public void glColorTableParameterfv(int target, int pname, MemorySegment params) {
    PFNGLCOLORTABLEPARAMETERFVSGIPROC.invoke(load("glColorTableParameterfv"), target, pname, params);
  }

  public void glGetUniformdv(int program, int location, MemorySegment params) {
    PFNGLGETUNIFORMDVPROC.invoke(load("glGetUniformdv"), program, location, params);
  }

  public void glGetVertexAttribPointerv(int index, int pname, MemorySegment pointer) {
    PFNGLGETVERTEXATTRIBPOINTERVPROC.invoke(load("glGetVertexAttribPointerv"), index, pname, pointer);
  }

  public void glTransformFeedbackBufferRange(int xfb, int index, int buffer, long offset, long size) {
    PFNGLTRANSFORMFEEDBACKBUFFERRANGEPROC.invoke(load("glTransformFeedbackBufferRange"), xfb, index, buffer, offset, size);
  }

  public void glVertexAttrib2fvNV(int index, MemorySegment v) {
    PFNGLVERTEXATTRIB2FVNVPROC.invoke(load("glVertexAttrib2fvNV"), index, v);
  }

  public void glViewportIndexedf(int index, float x, float y, float w, float h) {
    PFNGLVIEWPORTINDEXEDFPROC.invoke(load("glViewportIndexedf"), index, x, y, w, h);
  }

  public void glCompressedTextureSubImage1D(int texture, int level, int xoffset, int width, int format, int imageSize, MemorySegment data) {
    PFNGLCOMPRESSEDTEXTURESUBIMAGE1DPROC.invoke(load("glCompressedTextureSubImage1D"), texture, level, xoffset, width, format, imageSize, data);
  }

  public void glProgramUniform1fvEXT(int program, int location, int count, MemorySegment value) {
    PFNGLPROGRAMUNIFORM1FVEXTPROC.invoke(load("glProgramUniform1fvEXT"), program, location, count, value);
  }

  public void glColor4hNV(short red, short green, short blue, short alpha) {
    PFNGLCOLOR4HNVPROC.invoke(load("glColor4hNV"), red, green, blue, alpha);
  }

  public void glPauseTransformFeedback() {
    PFNGLPAUSETRANSFORMFEEDBACKPROC.invoke(load("glPauseTransformFeedback"));
  }

  public long glGetTextureHandleNV(int texture) {
    return PFNGLGETTEXTUREHANDLENVPROC.invoke(load("glGetTextureHandleNV"), texture);
  }

  public void glTexBumpParameterivATI(int pname, MemorySegment param) {
    PFNGLTEXBUMPPARAMETERIVATIPROC.invoke(load("glTexBumpParameterivATI"), pname, param);
  }

  public void glExtGetShadersQCOM(MemorySegment shaders, int maxShaders, MemorySegment numShaders) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFramebufferTexture2DOES(int target, int attachment, int textarget, int texture, int level) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexCoordP1ui(int texture, int type, int coords) {
    PFNGLMULTITEXCOORDP1UIPROC.invoke(load("glMultiTexCoordP1ui"), texture, type, coords);
  }

  public void glPolygonOffsetx(int factor, int units) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glCreateVertexArrays(int n, MemorySegment arrays) {
    PFNGLCREATEVERTEXARRAYSPROC.invoke(load("glCreateVertexArrays"), n, arrays);
  }

  public void glIndexPointerEXT(int type, int stride, int count, MemorySegment pointer) {
    PFNGLINDEXPOINTEREXTPROC.invoke(load("glIndexPointerEXT"), type, stride, count, pointer);
  }

  public void glWindowPos2dvMESA(MemorySegment v) {
    PFNGLWINDOWPOS2DVMESAPROC.invoke(load("glWindowPos2dvMESA"), v);
  }

  public void glGetBufferSubData(int target, long offset, long size, MemorySegment data) {
    PFNGLGETBUFFERSUBDATAPROC.invoke(load("glGetBufferSubData"), target, offset, size, data);
  }

  public void glUniform2i64vNV(int location, int count, MemorySegment value) {
    PFNGLUNIFORM2I64VNVPROC.invoke(load("glUniform2i64vNV"), location, count, value);
  }

  public void glCompressedTextureSubImage2D(int texture, int level, int xoffset, int yoffset, int width, int height, int format, int imageSize, MemorySegment data) {
    PFNGLCOMPRESSEDTEXTURESUBIMAGE2DPROC.invoke(load("glCompressedTextureSubImage2D"), texture, level, xoffset, yoffset, width, height, format, imageSize, data);
  }

  public void glDrawTransformFeedbackNV(int mode, int id) {
    PFNGLDRAWTRANSFORMFEEDBACKNVPROC.invoke(load("glDrawTransformFeedbackNV"), mode, id);
  }

  public void glTexCoord2fColor4ubVertex3fvSUN(MemorySegment tc, MemorySegment c, MemorySegment v) {
    PFNGLTEXCOORD2FCOLOR4UBVERTEX3FVSUNPROC.invoke(load("glTexCoord2fColor4ubVertex3fvSUN"), tc, c, v);
  }

  public void glGetFragmentLightivSGIX(int light, int pname, MemorySegment params) {
    PFNGLGETFRAGMENTLIGHTIVSGIXPROC.invoke(load("glGetFragmentLightivSGIX"), light, pname, params);
  }

  public void glTangent3dvEXT(MemorySegment v) {
    PFNGLTANGENT3DVEXTPROC.invoke(load("glTangent3dvEXT"), v);
  }

  public void glVertexAttrib4fNV(int index, float x, float y, float z, float w) {
    PFNGLVERTEXATTRIB4FNVPROC.invoke(load("glVertexAttrib4fNV"), index, x, y, z, w);
  }

  public void glTexCoord4hvNV(MemorySegment v) {
    PFNGLTEXCOORD4HVNVPROC.invoke(load("glTexCoord4hvNV"), v);
  }

  public void glTexSubImage3DEXT(int target, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int format, int type, MemorySegment pixels) {
    PFNGLTEXSUBIMAGE3DEXTPROC.invoke(load("glTexSubImage3DEXT"), target, level, xoffset, yoffset, zoffset, width, height, depth, format, type, pixels);
  }

  public void glGetnPixelMapusv(int map, int bufSize, MemorySegment values) {
    PFNGLGETNPIXELMAPUSVPROC.invoke(load("glGetnPixelMapusv"), map, bufSize, values);
  }

  public void glGetUniformfv(int program, int location, MemorySegment params) {
    PFNGLGETUNIFORMFVPROC.invoke(load("glGetUniformfv"), program, location, params);
  }

  public void glBinormal3dEXT(double bx, double by, double bz) {
    PFNGLBINORMAL3DEXTPROC.invoke(load("glBinormal3dEXT"), bx, by, bz);
  }

  public void glPathFogGenNV(int genMode) {
    PFNGLPATHFOGGENNVPROC.invoke(load("glPathFogGenNV"), genMode);
  }

  public void glDepthRangeIndexedfOES(int index, float n, float f) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public int glGetSubroutineIndex(int program, int shadertype, MemorySegment name) {
    return PFNGLGETSUBROUTINEINDEXPROC.invoke(load("glGetSubroutineIndex"), program, shadertype, name);
  }

  public void glBitmapxOES(int width, int height, int xorig, int yorig, int xmove, int ymove, MemorySegment bitmap) {
    PFNGLBITMAPXOESPROC.invoke(load("glBitmapxOES"), width, height, xorig, yorig, xmove, ymove, bitmap);
  }

  public void glVertexArrayVertexAttribDivisorEXT(int vaobj, int index, int divisor) {
    PFNGLVERTEXARRAYVERTEXATTRIBDIVISOREXTPROC.invoke(load("glVertexArrayVertexAttribDivisorEXT"), vaobj, index, divisor);
  }

  public void glProgramStringARB(int target, int format, int len, MemorySegment string) {
    PFNGLPROGRAMSTRINGARBPROC.invoke(load("glProgramStringARB"), target, format, len, string);
  }

  public void glVertexAttrib3svNV(int index, MemorySegment v) {
    PFNGLVERTEXATTRIB3SVNVPROC.invoke(load("glVertexAttrib3svNV"), index, v);
  }

  public long glGetTextureHandleARB(int texture) {
    return PFNGLGETTEXTUREHANDLEARBPROC.invoke(load("glGetTextureHandleARB"), texture);
  }

  public void glVertexAttrib4bvARB(int index, MemorySegment v) {
    PFNGLVERTEXATTRIB4BVARBPROC.invoke(load("glVertexAttrib4bvARB"), index, v);
  }

  public void glVertexAttrib2svARB(int index, MemorySegment v) {
    PFNGLVERTEXATTRIB2SVARBPROC.invoke(load("glVertexAttrib2svARB"), index, v);
  }

  public void glMultiTexCoord2ivARB(int target, MemorySegment v) {
    PFNGLMULTITEXCOORD2IVARBPROC.invoke(load("glMultiTexCoord2ivARB"), target, v);
  }

  public void glDepthRangeIndexedfNV(int index, float n, float f) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glColorFragmentOp2ATI(int op, int dst, int dstMask, int dstMod, int arg1, int arg1Rep, int arg1Mod, int arg2, int arg2Rep, int arg2Mod) {
    PFNGLCOLORFRAGMENTOP2ATIPROC.invoke(load("glColorFragmentOp2ATI"), op, dst, dstMask, dstMod, arg1, arg1Rep, arg1Mod, arg2, arg2Rep, arg2Mod);
  }

  public void glFramebufferSampleLocationsfvARB(int target, int start, int count, MemorySegment v) {
    PFNGLFRAMEBUFFERSAMPLELOCATIONSFVARBPROC.invoke(load("glFramebufferSampleLocationsfvARB"), target, start, count, v);
  }

  public void glTexCoord2fNormal3fVertex3fSUN(float s, float t, float nx, float ny, float nz, float x, float y, float z) {
    PFNGLTEXCOORD2FNORMAL3FVERTEX3FSUNPROC.invoke(load("glTexCoord2fNormal3fVertex3fSUN"), s, t, nx, ny, nz, x, y, z);
  }

  public void glGetQueryBufferObjectui64v(int id, int buffer, int pname, long offset) {
    PFNGLGETQUERYBUFFEROBJECTUI64VPROC.invoke(load("glGetQueryBufferObjectui64v"), id, buffer, pname, offset);
  }

  public void glFramebufferTexture2DMultisampleIMG(int target, int attachment, int textarget, int texture, int level, int samples) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glPathCoverDepthFuncNV(int func) {
    PFNGLPATHCOVERDEPTHFUNCNVPROC.invoke(load("glPathCoverDepthFuncNV"), func);
  }

  public void glVertexAttrib3hvNV(int index, MemorySegment v) {
    PFNGLVERTEXATTRIB3HVNVPROC.invoke(load("glVertexAttrib3hvNV"), index, v);
  }

  public void glVertexAttribI1uivEXT(int index, MemorySegment v) {
    PFNGLVERTEXATTRIBI1UIVEXTPROC.invoke(load("glVertexAttribI1uivEXT"), index, v);
  }

  public int glGetSubroutineUniformLocation(int program, int shadertype, MemorySegment name) {
    return PFNGLGETSUBROUTINEUNIFORMLOCATIONPROC.invoke(load("glGetSubroutineUniformLocation"), program, shadertype, name);
  }

  public byte glIsFramebufferEXT(int framebuffer) {
    return PFNGLISFRAMEBUFFEREXTPROC.invoke(load("glIsFramebufferEXT"), framebuffer);
  }

  public void glProgramUniformMatrix2dvEXT(int program, int location, int count, byte transpose, MemorySegment value) {
    PFNGLPROGRAMUNIFORMMATRIX2DVEXTPROC.invoke(load("glProgramUniformMatrix2dvEXT"), program, location, count, transpose, value);
  }

  public void glBlitNamedFramebuffer(int readFramebuffer, int drawFramebuffer, int srcX0, int srcY0, int srcX1, int srcY1, int dstX0, int dstY0, int dstX1, int dstY1, int mask, int filter) {
    PFNGLBLITNAMEDFRAMEBUFFERPROC.invoke(load("glBlitNamedFramebuffer"), readFramebuffer, drawFramebuffer, srcX0, srcY0, srcX1, srcY1, dstX0, dstY0, dstX1, dstY1, mask, filter);
  }

  public void glVariantivEXT(int id, MemorySegment addr) {
    PFNGLVARIANTIVEXTPROC.invoke(load("glVariantivEXT"), id, addr);
  }

  public void glGetBooleani_v(int target, int index, MemorySegment data) {
    PFNGLGETBOOLEANI_VPROC.invoke(load("glGetBooleani_v"), target, index, data);
  }

  public void glGetQueryiv(int target, int pname, MemorySegment params) {
    PFNGLGETQUERYIVPROC.invoke(load("glGetQueryiv"), target, pname, params);
  }

  public void glGetVariantBooleanvEXT(int id, int value, MemorySegment data) {
    PFNGLGETVARIANTBOOLEANVEXTPROC.invoke(load("glGetVariantBooleanvEXT"), id, value, data);
  }

  public void glBindBufferBaseEXT(int target, int index, int buffer) {
    PFNGLBINDBUFFERBASEEXTPROC.invoke(load("glBindBufferBaseEXT"), target, index, buffer);
  }

  public void glVertexStream4ivATI(int stream, MemorySegment coords) {
    PFNGLVERTEXSTREAM4IVATIPROC.invoke(load("glVertexStream4ivATI"), stream, coords);
  }

  public void glStencilStrokePathNV(int path, int reference, int mask) {
    PFNGLSTENCILSTROKEPATHNVPROC.invoke(load("glStencilStrokePathNV"), path, reference, mask);
  }

  public void glGetnHistogram(int target, byte reset, int format, int type, int bufSize, MemorySegment values) {
    PFNGLGETNHISTOGRAMPROC.invoke(load("glGetnHistogram"), target, reset, format, type, bufSize, values);
  }

  public void glUseProgramObjectARB(int programObj) {
    opengl.windows.PFNGLUSEPROGRAMOBJECTARBPROC.invoke(load("glUseProgramObjectARB"), programObj);
  }

  public void glGetActiveAtomicCounterBufferiv(int program, int bufferIndex, int pname, MemorySegment params) {
    PFNGLGETACTIVEATOMICCOUNTERBUFFERIVPROC.invoke(load("glGetActiveAtomicCounterBufferiv"), program, bufferIndex, pname, params);
  }

  public void glTexCoord4fColor4fNormal3fVertex4fvSUN(MemorySegment tc, MemorySegment c, MemorySegment n, MemorySegment v) {
    PFNGLTEXCOORD4FCOLOR4FNORMAL3FVERTEX4FVSUNPROC.invoke(load("glTexCoord4fColor4fNormal3fVertex4fvSUN"), tc, c, n, v);
  }

  public MemorySegment glMapNamedBufferRangeEXT(int buffer, long offset, long length, int access) {
    return PFNGLMAPNAMEDBUFFERRANGEEXTPROC.invoke(load("glMapNamedBufferRangeEXT"), buffer, offset, length, access);
  }

  public void glGenProgramsARB(int n, MemorySegment programs) {
    PFNGLGENPROGRAMSARBPROC.invoke(load("glGenProgramsARB"), n, programs);
  }

  public void glEndTransformFeedbackNV() {
    PFNGLENDTRANSFORMFEEDBACKNVPROC.invoke(load("glEndTransformFeedbackNV"));
  }

  public void glProgramUniform1ui64NV(int program, int location, long x) {
    PFNGLPROGRAMUNIFORM1UI64NVPROC.invoke(load("glProgramUniform1ui64NV"), program, location, x);
  }

  public void glProgramEnvParameter4fvARB(int target, int index, MemorySegment params) {
    PFNGLPROGRAMENVPARAMETER4FVARBPROC.invoke(load("glProgramEnvParameter4fvARB"), target, index, params);
  }

  public void glVertex3hvNV(MemorySegment v) {
    PFNGLVERTEX3HVNVPROC.invoke(load("glVertex3hvNV"), v);
  }

  public void glGetVideouivNV(int video_slot, int pname, MemorySegment params) {
    PFNGLGETVIDEOUIVNVPROC.invoke(load("glGetVideouivNV"), video_slot, pname, params);
  }

  public void glPointParameterxv(int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetnPixelMapuivARB(int map, int bufSize, MemorySegment values) {
    PFNGLGETNPIXELMAPUIVARBPROC.invoke(load("glGetnPixelMapuivARB"), map, bufSize, values);
  }

  public byte glIsTextureHandleResidentARB(long handle) {
    return PFNGLISTEXTUREHANDLERESIDENTARBPROC.invoke(load("glIsTextureHandleResidentARB"), handle);
  }

  public void glNamedFramebufferDrawBuffer(int framebuffer, int buf) {
    PFNGLNAMEDFRAMEBUFFERDRAWBUFFERPROC.invoke(load("glNamedFramebufferDrawBuffer"), framebuffer, buf);
  }

  public void glTextureStorage3DEXT(int texture, int target, int levels, int internalformat, int width, int height, int depth) {
    PFNGLTEXTURESTORAGE3DEXTPROC.invoke(load("glTextureStorage3DEXT"), texture, target, levels, internalformat, width, height, depth);
  }

  public void glUniform1i64vARB(int location, int count, MemorySegment value) {
    PFNGLUNIFORM1I64VARBPROC.invoke(load("glUniform1i64vARB"), location, count, value);
  }

  public void glGetObjectBufferfvATI(int buffer, int pname, MemorySegment params) {
    PFNGLGETOBJECTBUFFERFVATIPROC.invoke(load("glGetObjectBufferfvATI"), buffer, pname, params);
  }

  public int glPollInstrumentsSGIX(MemorySegment marker_p) {
    return PFNGLPOLLINSTRUMENTSSGIXPROC.invoke(load("glPollInstrumentsSGIX"), marker_p);
  }

  public void glGetDriverControlStringQCOM(int driverControl, int bufSize, MemorySegment length, MemorySegment driverControlString) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFramebufferParameteri(int target, int pname, int param) {
    PFNGLFRAMEBUFFERPARAMETERIPROC.invoke(load("glFramebufferParameteri"), target, pname, param);
  }

  public void glGenFencesAPPLE(int n, MemorySegment fences) {
    PFNGLGENFENCESAPPLEPROC.invoke(load("glGenFencesAPPLE"), n, fences);
  }

  public void glViewportArrayv(int first, int count, MemorySegment v) {
    PFNGLVIEWPORTARRAYVPROC.invoke(load("glViewportArrayv"), first, count, v);
  }

  public void glGetObjectParameterivARB(int obj, int pname, MemorySegment params) {
    opengl.windows.PFNGLGETOBJECTPARAMETERIVARBPROC.invoke(load("glGetObjectParameterivARB"), obj, pname, params);
  }

  public void glTexImage3DMultisampleCoverageNV(int target, int coverageSamples, int colorSamples, int internalFormat, int width, int height, int depth, byte fixedSampleLocations) {
    PFNGLTEXIMAGE3DMULTISAMPLECOVERAGENVPROC.invoke(load("glTexImage3DMultisampleCoverageNV"), target, coverageSamples, colorSamples, internalFormat, width, height, depth, fixedSampleLocations);
  }

  public void glProgramUniformMatrix2x3fv(int program, int location, int count, byte transpose, MemorySegment value) {
    PFNGLPROGRAMUNIFORMMATRIX2X3FVPROC.invoke(load("glProgramUniformMatrix2x3fv"), program, location, count, transpose, value);
  }

  public void glMapGrid1xOES(int n, int u1, int u2) {
    PFNGLMAPGRID1XOESPROC.invoke(load("glMapGrid1xOES"), n, u1, u2);
  }

  public void glGetPerfMonitorCountersAMD(int group, MemorySegment numCounters, MemorySegment maxActiveCounters, int counterSize, MemorySegment counters) {
    PFNGLGETPERFMONITORCOUNTERSAMDPROC.invoke(load("glGetPerfMonitorCountersAMD"), group, numCounters, maxActiveCounters, counterSize, counters);
  }

  public void glFramebufferTextureFaceARB(int target, int attachment, int texture, int level, int face) {
    PFNGLFRAMEBUFFERTEXTUREFACEARBPROC.invoke(load("glFramebufferTextureFaceARB"), target, attachment, texture, level, face);
  }

  public void glTangent3sEXT(short tx, short ty, short tz) {
    PFNGLTANGENT3SEXTPROC.invoke(load("glTangent3sEXT"), tx, ty, tz);
  }

  public void glTexStorageMem2DEXT(int target, int levels, int internalFormat, int width, int height, int memory, long offset) {
    PFNGLTEXSTORAGEMEM2DEXTPROC.invoke(load("glTexStorageMem2DEXT"), target, levels, internalFormat, width, height, memory, offset);
  }

  public void glGetnPixelMapuiv(int map, int bufSize, MemorySegment values) {
    PFNGLGETNPIXELMAPUIVPROC.invoke(load("glGetnPixelMapuiv"), map, bufSize, values);
  }

  public void glTexCoordP2ui(int type, int coords) {
    PFNGLTEXCOORDP2UIPROC.invoke(load("glTexCoordP2ui"), type, coords);
  }

  public void glGetLightxvOES(int light, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexCoord4bvOES(int texture, MemorySegment coords) {
    PFNGLMULTITEXCOORD4BVOESPROC.invoke(load("glMultiTexCoord4bvOES"), texture, coords);
  }

  public void glPolygonOffsetxOES(int factor, int units) {
    PFNGLPOLYGONOFFSETXOESPROC.invoke(load("glPolygonOffsetxOES"), factor, units);
  }

  public void glNamedProgramLocalParameter4fvEXT(int program, int target, int index, MemorySegment params) {
    PFNGLNAMEDPROGRAMLOCALPARAMETER4FVEXTPROC.invoke(load("glNamedProgramLocalParameter4fvEXT"), program, target, index, params);
  }

  public void glClearTexSubImage(int texture, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int format, int type, MemorySegment data) {
    PFNGLCLEARTEXSUBIMAGEPROC.invoke(load("glClearTexSubImage"), texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, data);
  }

  public void glVertexAttribI2iEXT(int index, int x, int y) {
    PFNGLVERTEXATTRIBI2IEXTPROC.invoke(load("glVertexAttribI2iEXT"), index, x, y);
  }

  public void glFramebufferTextureLayer(int target, int attachment, int texture, int level, int layer) {
    PFNGLFRAMEBUFFERTEXTURELAYERPROC.invoke(load("glFramebufferTextureLayer"), target, attachment, texture, level, layer);
  }

  public void glGetVertexAttribLdv(int index, int pname, MemorySegment params) {
    PFNGLGETVERTEXATTRIBLDVPROC.invoke(load("glGetVertexAttribLdv"), index, pname, params);
  }

  public void glVertexP4uiv(int type, MemorySegment value) {
    PFNGLVERTEXP4UIVPROC.invoke(load("glVertexP4uiv"), type, value);
  }

  public void glReplacementCodeuiColor3fVertex3fSUN(int rc, float r, float g, float b, float x, float y, float z) {
    PFNGLREPLACEMENTCODEUICOLOR3FVERTEX3FSUNPROC.invoke(load("glReplacementCodeuiColor3fVertex3fSUN"), rc, r, g, b, x, y, z);
  }

  public void glGetTexParameterxv(int target, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMulticastViewportArrayvNVX(int gpu, int first, int count, MemorySegment v) {
    PFNGLMULTICASTVIEWPORTARRAYVNVXPROC.invoke(load("glMulticastViewportArrayvNVX"), gpu, first, count, v);
  }

  public void glSampleCoveragexOES(int value, byte invert) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glReplacementCodeuiVertex3fvSUN(MemorySegment rc, MemorySegment v) {
    PFNGLREPLACEMENTCODEUIVERTEX3FVSUNPROC.invoke(load("glReplacementCodeuiVertex3fvSUN"), rc, v);
  }

  public void glDeleteFencesNV(int n, MemorySegment fences) {
    PFNGLDELETEFENCESNVPROC.invoke(load("glDeleteFencesNV"), n, fences);
  }

  public void glGetSamplerParameterIiv(int sampler, int pname, MemorySegment params) {
    PFNGLGETSAMPLERPARAMETERIIVPROC.invoke(load("glGetSamplerParameterIiv"), sampler, pname, params);
  }

  public void glVertexAttribPointerNV(int index, int fsize, int type, int stride, MemorySegment pointer) {
    PFNGLVERTEXATTRIBPOINTERNVPROC.invoke(load("glVertexAttribPointerNV"), index, fsize, type, stride, pointer);
  }

  public void glVertexStream4sATI(int stream, short x, short y, short z, short w) {
    PFNGLVERTEXSTREAM4SATIPROC.invoke(load("glVertexStream4sATI"), stream, x, y, z, w);
  }

  public void glProgramUniformMatrix2x3dv(int program, int location, int count, byte transpose, MemorySegment value) {
    PFNGLPROGRAMUNIFORMMATRIX2X3DVPROC.invoke(load("glProgramUniformMatrix2x3dv"), program, location, count, transpose, value);
  }

  public void glBlendBarrier() {
    PFNGLBLENDBARRIERKHRPROC.invoke(load("glBlendBarrier"));
  }

  public void glFramebufferTexture2DEXT(int target, int attachment, int textarget, int texture, int level) {
    PFNGLFRAMEBUFFERTEXTURE2DEXTPROC.invoke(load("glFramebufferTexture2DEXT"), target, attachment, textarget, texture, level);
  }

  public void glPolygonOffsetClamp(float factor, float units, float clamp) {
    PFNGLPOLYGONOFFSETCLAMPPROC.invoke(load("glPolygonOffsetClamp"), factor, units, clamp);
  }

  public void glTexCoord3bvOES(MemorySegment coords) {
    PFNGLTEXCOORD3BVOESPROC.invoke(load("glTexCoord3bvOES"), coords);
  }

  public void glUniformMatrix3x2fvNV(int location, int count, byte transpose, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniform1i64vNV(int program, int location, int count, MemorySegment value) {
    PFNGLPROGRAMUNIFORM1I64VNVPROC.invoke(load("glProgramUniform1i64vNV"), program, location, count, value);
  }

  public void glPathGlyphRangeNV(int firstPathName, int fontTarget, MemorySegment fontName, int fontStyle, int firstGlyph, int numGlyphs, int handleMissingGlyphs, int pathParameterTemplate, float emScale) {
    PFNGLPATHGLYPHRANGENVPROC.invoke(load("glPathGlyphRangeNV"), firstPathName, fontTarget, fontName, fontStyle, firstGlyph, numGlyphs, handleMissingGlyphs, pathParameterTemplate, emScale);
  }

  public void glPopDebugGroupKHR() {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexArrayBindingDivisor(int vaobj, int bindingindex, int divisor) {
    PFNGLVERTEXARRAYBINDINGDIVISORPROC.invoke(load("glVertexArrayBindingDivisor"), vaobj, bindingindex, divisor);
  }

  public void glProgramBufferParametersIuivNV(int target, int bindingIndex, int wordIndex, int count, MemorySegment params) {
    PFNGLPROGRAMBUFFERPARAMETERSIUIVNVPROC.invoke(load("glProgramBufferParametersIuivNV"), target, bindingIndex, wordIndex, count, params);
  }

  public void glBinormalPointerEXT(int type, int stride, MemorySegment pointer) {
    PFNGLBINORMALPOINTEREXTPROC.invoke(load("glBinormalPointerEXT"), type, stride, pointer);
  }

  public void glStencilFillPathNV(int path, int fillMode, int mask) {
    PFNGLSTENCILFILLPATHNVPROC.invoke(load("glStencilFillPathNV"), path, fillMode, mask);
  }

  public void glReplacementCodeuiNormal3fVertex3fvSUN(MemorySegment rc, MemorySegment n, MemorySegment v) {
    PFNGLREPLACEMENTCODEUINORMAL3FVERTEX3FVSUNPROC.invoke(load("glReplacementCodeuiNormal3fVertex3fvSUN"), rc, n, v);
  }

  public void glUniform2ui64vARB(int location, int count, MemorySegment value) {
    PFNGLUNIFORM2UI64VARBPROC.invoke(load("glUniform2ui64vARB"), location, count, value);
  }

  public void glDrawElementsInstancedBaseVertexOES(int mode, int count, int type, MemorySegment indices, int instancecount, int basevertex) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexStream3fATI(int stream, float x, float y, float z) {
    PFNGLVERTEXSTREAM3FATIPROC.invoke(load("glVertexStream3fATI"), stream, x, y, z);
  }

  public void glCombinerParameteriNV(int pname, int param) {
    PFNGLCOMBINERPARAMETERINVPROC.invoke(load("glCombinerParameteriNV"), pname, param);
  }

  public int glGetGraphicsResetStatus() {
    return PFNGLGETGRAPHICSRESETSTATUSPROC.invoke(load("glGetGraphicsResetStatus"));
  }

  public void glVertexAttrib4ivARB(int index, MemorySegment v) {
    PFNGLVERTEXATTRIB4IVARBPROC.invoke(load("glVertexAttrib4ivARB"), index, v);
  }

  public void glNamedProgramLocalParameterI4uivEXT(int program, int target, int index, MemorySegment params) {
    PFNGLNAMEDPROGRAMLOCALPARAMETERI4UIVEXTPROC.invoke(load("glNamedProgramLocalParameterI4uivEXT"), program, target, index, params);
  }

  public void glEnableVertexArrayAttribEXT(int vaobj, int index) {
    PFNGLENABLEVERTEXARRAYATTRIBEXTPROC.invoke(load("glEnableVertexArrayAttribEXT"), vaobj, index);
  }

  public void glPointParameterivNV(int pname, MemorySegment params) {
    PFNGLPOINTPARAMETERIVNVPROC.invoke(load("glPointParameterivNV"), pname, params);
  }

  public void glWindowPos3dMESA(double x, double y, double z) {
    PFNGLWINDOWPOS3DMESAPROC.invoke(load("glWindowPos3dMESA"), x, y, z);
  }

  public void glReadInstrumentsSGIX(int marker) {
    PFNGLREADINSTRUMENTSSGIXPROC.invoke(load("glReadInstrumentsSGIX"), marker);
  }

  public void glNormalPointerEXT(int type, int stride, int count, MemorySegment pointer) {
    PFNGLNORMALPOINTEREXTPROC.invoke(load("glNormalPointerEXT"), type, stride, count, pointer);
  }

  public void glRasterPos3xvOES(MemorySegment coords) {
    PFNGLRASTERPOS3XVOESPROC.invoke(load("glRasterPos3xvOES"), coords);
  }

  public void glUniform3ui(int location, int v0, int v1, int v2) {
    PFNGLUNIFORM3UIPROC.invoke(load("glUniform3ui"), location, v0, v1, v2);
  }

  public void glMatrixScaledEXT(int mode, double x, double y, double z) {
    PFNGLMATRIXSCALEDEXTPROC.invoke(load("glMatrixScaledEXT"), mode, x, y, z);
  }

  public void glCopyTextureSubImage3D(int texture, int level, int xoffset, int yoffset, int zoffset, int x, int y, int width, int height) {
    PFNGLCOPYTEXTURESUBIMAGE3DPROC.invoke(load("glCopyTextureSubImage3D"), texture, level, xoffset, yoffset, zoffset, x, y, width, height);
  }

  public void glGetPathColorGenivNV(int color, int pname, MemorySegment value) {
    PFNGLGETPATHCOLORGENIVNVPROC.invoke(load("glGetPathColorGenivNV"), color, pname, value);
  }

  public void glProgramUniform1d(int program, int location, double v0) {
    PFNGLPROGRAMUNIFORM1DPROC.invoke(load("glProgramUniform1d"), program, location, v0);
  }

  public byte glUnmapNamedBuffer(int buffer) {
    return PFNGLUNMAPNAMEDBUFFERPROC.invoke(load("glUnmapNamedBuffer"), buffer);
  }

  public void glDrawArraysInstancedEXT(int mode, int start, int count, int primcount) {
    PFNGLDRAWARRAYSINSTANCEDEXTPROC.invoke(load("glDrawArraysInstancedEXT"), mode, start, count, primcount);
  }

  public void glProgramUniform1f(int program, int location, float v0) {
    PFNGLPROGRAMUNIFORM1FPROC.invoke(load("glProgramUniform1f"), program, location, v0);
  }

  public void glProgramUniform1i(int program, int location, int v0) {
    PFNGLPROGRAMUNIFORM1IPROC.invoke(load("glProgramUniform1i"), program, location, v0);
  }

  public void glFrameTerminatorGREMEDY() {
    PFNGLFRAMETERMINATORGREMEDYPROC.invoke(load("glFrameTerminatorGREMEDY"));
  }

  public void glVertexStream2svATI(int stream, MemorySegment coords) {
    PFNGLVERTEXSTREAM2SVATIPROC.invoke(load("glVertexStream2svATI"), stream, coords);
  }

  public void glFrameZoomSGIX(int factor) {
    PFNGLFRAMEZOOMSGIXPROC.invoke(load("glFrameZoomSGIX"), factor);
  }

  public void glGetTextureImage(int texture, int level, int format, int type, int bufSize, MemorySegment pixels) {
    PFNGLGETTEXTUREIMAGEPROC.invoke(load("glGetTextureImage"), texture, level, format, type, bufSize, pixels);
  }

  public void glPixelTransformParameterfvEXT(int target, int pname, MemorySegment params) {
    PFNGLPIXELTRANSFORMPARAMETERFVEXTPROC.invoke(load("glPixelTransformParameterfvEXT"), target, pname, params);
  }

  public MemorySegment glGetVkProcAddrNV(MemorySegment name) {
    return PFNGLGETVKPROCADDRNVPROC.invoke(load("glGetVkProcAddrNV"), name);
  }

  public void glCopyTextureSubImage2D(int texture, int level, int xoffset, int yoffset, int x, int y, int width, int height) {
    PFNGLCOPYTEXTURESUBIMAGE2DPROC.invoke(load("glCopyTextureSubImage2D"), texture, level, xoffset, yoffset, x, y, width, height);
  }

  public byte glIsBufferResidentNV(int target) {
    return PFNGLISBUFFERRESIDENTNVPROC.invoke(load("glIsBufferResidentNV"), target);
  }

  public int glClientWaitSyncAPPLE(MemorySegment sync, int flags, long timeout) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexStream2dATI(int stream, double x, double y) {
    PFNGLVERTEXSTREAM2DATIPROC.invoke(load("glVertexStream2dATI"), stream, x, y);
  }

  public void glCopyImageSubDataNV(int srcName, int srcTarget, int srcLevel, int srcX, int srcY, int srcZ, int dstName, int dstTarget, int dstLevel, int dstX, int dstY, int dstZ, int width, int height, int depth) {
    PFNGLCOPYIMAGESUBDATANVPROC.invoke(load("glCopyImageSubDataNV"), srcName, srcTarget, srcLevel, srcX, srcY, srcZ, dstName, dstTarget, dstLevel, dstX, dstY, dstZ, width, height, depth);
  }

  public void glActiveShaderProgramEXT(int pipeline, int program) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glColorP3uiv(int type, MemorySegment color) {
    PFNGLCOLORP3UIVPROC.invoke(load("glColorP3uiv"), type, color);
  }

  public int glClientWaitSync(MemorySegment sync, int flags, long timeout) {
    return PFNGLCLIENTWAITSYNCPROC.invoke(load("glClientWaitSync"), sync, flags, timeout);
  }

  public void glReplacementCodeuiTexCoord2fVertex3fSUN(int rc, float s, float t, float x, float y, float z) {
    PFNGLREPLACEMENTCODEUITEXCOORD2FVERTEX3FSUNPROC.invoke(load("glReplacementCodeuiTexCoord2fVertex3fSUN"), rc, s, t, x, y, z);
  }

  public void glGetVertexArrayIntegeri_vEXT(int vaobj, int index, int pname, MemorySegment param) {
    PFNGLGETVERTEXARRAYINTEGERI_VEXTPROC.invoke(load("glGetVertexArrayIntegeri_vEXT"), vaobj, index, pname, param);
  }

  public void glScissorExclusiveArrayvNV(int first, int count, MemorySegment v) {
    PFNGLSCISSOREXCLUSIVEARRAYVNVPROC.invoke(load("glScissorExclusiveArrayvNV"), first, count, v);
  }

  public void glVertexAttrib4fvARB(int index, MemorySegment v) {
    PFNGLVERTEXATTRIB4FVARBPROC.invoke(load("glVertexAttrib4fvARB"), index, v);
  }

  public void glTexParameterIivEXT(int target, int pname, MemorySegment params) {
    PFNGLTEXPARAMETERIIVEXTPROC.invoke(load("glTexParameterIivEXT"), target, pname, params);
  }

  public void glVertexAttribL4dEXT(int index, double x, double y, double z, double w) {
    PFNGLVERTEXATTRIBL4DEXTPROC.invoke(load("glVertexAttribL4dEXT"), index, x, y, z, w);
  }

  public void glCompressedTexImage1DARB(int target, int level, int internalformat, int width, int border, int imageSize, MemorySegment data) {
    PFNGLCOMPRESSEDTEXIMAGE1DARBPROC.invoke(load("glCompressedTexImage1DARB"), target, level, internalformat, width, border, imageSize, data);
  }

  public void glCopyTextureSubImage1D(int texture, int level, int xoffset, int x, int y, int width) {
    PFNGLCOPYTEXTURESUBIMAGE1DPROC.invoke(load("glCopyTextureSubImage1D"), texture, level, xoffset, x, y, width);
  }

  public void glVertexAttribI1uiv(int index, MemorySegment v) {
    PFNGLVERTEXATTRIBI1UIVPROC.invoke(load("glVertexAttribI1uiv"), index, v);
  }

  public void glPatchParameteriEXT(int pname, int value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexPageCommitmentEXT(int target, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, byte commit) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramUniform2uivEXT(int program, int location, int count, MemorySegment value) {
    PFNGLPROGRAMUNIFORM2UIVEXTPROC.invoke(load("glProgramUniform2uivEXT"), program, location, count, value);
  }

  public void glMultiTexImage2DEXT(int texunit, int target, int level, int internalformat, int width, int height, int border, int format, int type, MemorySegment pixels) {
    PFNGLMULTITEXIMAGE2DEXTPROC.invoke(load("glMultiTexImage2DEXT"), texunit, target, level, internalformat, width, height, border, format, type, pixels);
  }

  public void glGetRenderbufferParameteriv(int target, int pname, MemorySegment params) {
    PFNGLGETRENDERBUFFERPARAMETERIVPROC.invoke(load("glGetRenderbufferParameteriv"), target, pname, params);
  }

  public void glColor3xOES(int red, int green, int blue) {
    PFNGLCOLOR3XOESPROC.invoke(load("glColor3xOES"), red, green, blue);
  }

  public void glEnableVertexAttribAPPLE(int index, int pname) {
    PFNGLENABLEVERTEXATTRIBAPPLEPROC.invoke(load("glEnableVertexAttribAPPLE"), index, pname);
  }

  public void glTangent3svEXT(MemorySegment v) {
    PFNGLTANGENT3SVEXTPROC.invoke(load("glTangent3svEXT"), v);
  }

  public void glAttachShader(int program, int shader) {
    PFNGLATTACHSHADERPROC.invoke(load("glAttachShader"), program, shader);
  }

  public void glGetNamedProgramLocalParameterIuivEXT(int program, int target, int index, MemorySegment params) {
    PFNGLGETNAMEDPROGRAMLOCALPARAMETERIUIVEXTPROC.invoke(load("glGetNamedProgramLocalParameterIuivEXT"), program, target, index, params);
  }

  public void glPatchParameterfv(int pname, MemorySegment values) {
    PFNGLPATCHPARAMETERFVPROC.invoke(load("glPatchParameterfv"), pname, values);
  }

  public void glGetTexParameterPointervAPPLE(int target, int pname, MemorySegment params) {
    PFNGLGETTEXPARAMETERPOINTERVAPPLEPROC.invoke(load("glGetTexParameterPointervAPPLE"), target, pname, params);
  }

  public void glNormalFormatNV(int type, int stride) {
    PFNGLNORMALFORMATNVPROC.invoke(load("glNormalFormatNV"), type, stride);
  }

  public void glMemoryBarrierByRegion(int barriers) {
    PFNGLMEMORYBARRIERBYREGIONPROC.invoke(load("glMemoryBarrierByRegion"), barriers);
  }

  public void glGetSeparableFilter(int target, int format, int type, MemorySegment row, MemorySegment column, MemorySegment span) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTexCoord4fColor4fNormal3fVertex4fSUN(float s, float t, float p, float q, float r, float g, float b, float a, float nx, float ny, float nz, float x, float y, float z, float w) {
    PFNGLTEXCOORD4FCOLOR4FNORMAL3FVERTEX4FSUNPROC.invoke(load("glTexCoord4fColor4fNormal3fVertex4fSUN"), s, t, p, q, r, g, b, a, nx, ny, nz, x, y, z, w);
  }

  public void glNormalStream3bvATI(int stream, MemorySegment coords) {
    PFNGLNORMALSTREAM3BVATIPROC.invoke(load("glNormalStream3bvATI"), stream, coords);
  }

  public int glGenPathsNV(int range) {
    return PFNGLGENPATHSNVPROC.invoke(load("glGenPathsNV"), range);
  }

  public void glGetNamedProgramivEXT(int program, int target, int pname, MemorySegment params) {
    PFNGLGETNAMEDPROGRAMIVEXTPROC.invoke(load("glGetNamedProgramivEXT"), program, target, pname, params);
  }

  public void glVertexP4ui(int type, int value) {
    PFNGLVERTEXP4UIPROC.invoke(load("glVertexP4ui"), type, value);
  }

  public void glVertexAttribL2dvEXT(int index, MemorySegment v) {
    PFNGLVERTEXATTRIBL2DVEXTPROC.invoke(load("glVertexAttribL2dvEXT"), index, v);
  }

  public int glGetGraphicsResetStatusARB() {
    return PFNGLGETGRAPHICSRESETSTATUSARBPROC.invoke(load("glGetGraphicsResetStatusARB"));
  }

  public void glVertex3bvOES(MemorySegment coords) {
    PFNGLVERTEX3BVOESPROC.invoke(load("glVertex3bvOES"), coords);
  }

  public void glGetTextureParameterfvEXT(int texture, int target, int pname, MemorySegment params) {
    PFNGLGETTEXTUREPARAMETERFVEXTPROC.invoke(load("glGetTextureParameterfvEXT"), texture, target, pname, params);
  }

  public void glTexParameterIuivOES(int target, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glProgramNamedParameter4dvNV(int id, int len, MemorySegment name, MemorySegment v) {
    PFNGLPROGRAMNAMEDPARAMETER4DVNVPROC.invoke(load("glProgramNamedParameter4dvNV"), id, len, name, v);
  }

  public void glWindowPos2iARB(int x, int y) {
    PFNGLWINDOWPOS2IARBPROC.invoke(load("glWindowPos2iARB"), x, y);
  }

  public void glGetFramebufferParameteriv(int target, int pname, MemorySegment params) {
    PFNGLGETFRAMEBUFFERPARAMETERIVPROC.invoke(load("glGetFramebufferParameteriv"), target, pname, params);
  }

  public void glMultiTexCoord1xvOES(int texture, MemorySegment coords) {
    PFNGLMULTITEXCOORD1XVOESPROC.invoke(load("glMultiTexCoord1xvOES"), texture, coords);
  }

  public void glDepthRangeArraydvNV(int first, int count, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniformHandleui64ARB(int location, long value) {
    PFNGLUNIFORMHANDLEUI64ARBPROC.invoke(load("glUniformHandleui64ARB"), location, value);
  }

  public void glSpecializeShader(int shader, MemorySegment pEntryPoint, int numSpecializationConstants, MemorySegment pConstantIndex, MemorySegment pConstantValue) {
    PFNGLSPECIALIZESHADERPROC.invoke(load("glSpecializeShader"), shader, pEntryPoint, numSpecializationConstants, pConstantIndex, pConstantValue);
  }

  public void glVertexBlendEnvfATI(int pname, float param) {
    PFNGLVERTEXBLENDENVFATIPROC.invoke(load("glVertexBlendEnvfATI"), pname, param);
  }

  public void glProgramParameter4dNV(int target, int index, double x, double y, double z, double w) {
    PFNGLPROGRAMPARAMETER4DNVPROC.invoke(load("glProgramParameter4dNV"), target, index, x, y, z, w);
  }

  public void glObjectLabelKHR(int identifier, int name, int length, MemorySegment label) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetMultisamplefvNV(int pname, int index, MemorySegment val) {
    PFNGLGETMULTISAMPLEFVNVPROC.invoke(load("glGetMultisamplefvNV"), pname, index, val);
  }

  public void glEndQueryEXT(int target) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBindVertexArrayAPPLE(int array) {
    PFNGLBINDVERTEXARRAYAPPLEPROC.invoke(load("glBindVertexArrayAPPLE"), array);
  }

  public void glGetQueryBufferObjectuiv(int id, int buffer, int pname, long offset) {
    PFNGLGETQUERYBUFFEROBJECTUIVPROC.invoke(load("glGetQueryBufferObjectuiv"), id, buffer, pname, offset);
  }

  public void glUniform2iARB(int location, int v0, int v1) {
    PFNGLUNIFORM2IARBPROC.invoke(load("glUniform2iARB"), location, v0, v1);
  }

  public void glTexBufferRange(int target, int internalformat, int buffer, long offset, long size) {
    PFNGLTEXBUFFERRANGEPROC.invoke(load("glTexBufferRange"), target, internalformat, buffer, offset, size);
  }

  public void glProgramUniformMatrix4x3fvEXT(int program, int location, int count, byte transpose, MemorySegment value) {
    PFNGLPROGRAMUNIFORMMATRIX4X3FVEXTPROC.invoke(load("glProgramUniformMatrix4x3fvEXT"), program, location, count, transpose, value);
  }

  public void glSpriteParameteriSGIX(int pname, int param) {
    PFNGLSPRITEPARAMETERISGIXPROC.invoke(load("glSpriteParameteriSGIX"), pname, param);
  }

  public void glDrawArraysInstancedBaseInstance(int mode, int first, int count, int instancecount, int baseinstance) {
    PFNGLDRAWARRAYSINSTANCEDBASEINSTANCEPROC.invoke(load("glDrawArraysInstancedBaseInstance"), mode, first, count, instancecount, baseinstance);
  }

  public void glTexParameterIivOES(int target, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetRenderbufferParameterivEXT(int target, int pname, MemorySegment params) {
    PFNGLGETRENDERBUFFERPARAMETERIVEXTPROC.invoke(load("glGetRenderbufferParameterivEXT"), target, pname, params);
  }

  public void glGetUniformuivEXT(int program, int location, MemorySegment params) {
    PFNGLGETUNIFORMUIVEXTPROC.invoke(load("glGetUniformuivEXT"), program, location, params);
  }

  public void glVertexAttribL3ui64NV(int index, long x, long y, long z) {
    PFNGLVERTEXATTRIBL3UI64NVPROC.invoke(load("glVertexAttribL3ui64NV"), index, x, y, z);
  }

  public void glGetnHistogramARB(int target, byte reset, int format, int type, int bufSize, MemorySegment values) {
    PFNGLGETNHISTOGRAMARBPROC.invoke(load("glGetnHistogramARB"), target, reset, format, type, bufSize, values);
  }

  public void glSecondaryColor3iv(MemorySegment v) {
    PFNGLSECONDARYCOLOR3IVPROC.invoke(load("glSecondaryColor3iv"), v);
  }

  public void glWindowPos2dARB(double x, double y) {
    PFNGLWINDOWPOS2DARBPROC.invoke(load("glWindowPos2dARB"), x, y);
  }

  public byte glIsPointInStrokePathNV(int path, float x, float y) {
    return PFNGLISPOINTINSTROKEPATHNVPROC.invoke(load("glIsPointInStrokePathNV"), path, x, y);
  }

  public void glBlendFuncSeparateOES(int srcRGB, int dstRGB, int srcAlpha, int dstAlpha) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glReadBufferIndexedEXT(int src, int index) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetFramebufferParameterivEXT(int framebuffer, int pname, MemorySegment params) {
    PFNGLGETFRAMEBUFFERPARAMETERIVEXTPROC.invoke(load("glGetFramebufferParameterivEXT"), framebuffer, pname, params);
  }

  public void glProgramEnvParametersI4ivNV(int target, int index, int count, MemorySegment params) {
    PFNGLPROGRAMENVPARAMETERSI4IVNVPROC.invoke(load("glProgramEnvParametersI4ivNV"), target, index, count, params);
  }

  public void glGetNamedFramebufferAttachmentParameteriv(int framebuffer, int attachment, int pname, MemorySegment params) {
    PFNGLGETNAMEDFRAMEBUFFERATTACHMENTPARAMETERIVPROC.invoke(load("glGetNamedFramebufferAttachmentParameteriv"), framebuffer, attachment, pname, params);
  }

  public void glEndVideoCaptureNV(int video_capture_slot) {
    PFNGLENDVIDEOCAPTURENVPROC.invoke(load("glEndVideoCaptureNV"), video_capture_slot);
  }

  public void glMatrixLoaddEXT(int mode, MemorySegment m) {
    PFNGLMATRIXLOADDEXTPROC.invoke(load("glMatrixLoaddEXT"), mode, m);
  }

  public void glWindowPos3fARB(float x, float y, float z) {
    PFNGLWINDOWPOS3FARBPROC.invoke(load("glWindowPos3fARB"), x, y, z);
  }

  public void glWindowPos2svARB(MemorySegment v) {
    PFNGLWINDOWPOS2SVARBPROC.invoke(load("glWindowPos2svARB"), v);
  }

  public void glGetOcclusionQueryuivNV(int id, int pname, MemorySegment params) {
    PFNGLGETOCCLUSIONQUERYUIVNVPROC.invoke(load("glGetOcclusionQueryuivNV"), id, pname, params);
  }

  public void glGetTextureSubImage(int texture, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int format, int type, int bufSize, MemorySegment pixels) {
    PFNGLGETTEXTURESUBIMAGEPROC.invoke(load("glGetTextureSubImage"), texture, level, xoffset, yoffset, zoffset, width, height, depth, format, type, bufSize, pixels);
  }

  public void glVertexArrayNormalOffsetEXT(int vaobj, int buffer, int type, int stride, long offset) {
    PFNGLVERTEXARRAYNORMALOFFSETEXTPROC.invoke(load("glVertexArrayNormalOffsetEXT"), vaobj, buffer, type, stride, offset);
  }

  public void glGetTransformFeedbackVaryingEXT(int program, int index, int bufSize, MemorySegment length, MemorySegment size, MemorySegment type, MemorySegment name) {
    PFNGLGETTRANSFORMFEEDBACKVARYINGEXTPROC.invoke(load("glGetTransformFeedbackVaryingEXT"), program, index, bufSize, length, size, type, name);
  }

  public void glProvokingVertexEXT(int mode) {
    PFNGLPROVOKINGVERTEXEXTPROC.invoke(load("glProvokingVertexEXT"), mode);
  }

  public void glProgramUniform2ui64vNV(int program, int location, int count, MemorySegment value) {
    PFNGLPROGRAMUNIFORM2UI64VNVPROC.invoke(load("glProgramUniform2ui64vNV"), program, location, count, value);
  }

  public void glTrackMatrixNV(int target, int address, int matrix, int transform) {
    PFNGLTRACKMATRIXNVPROC.invoke(load("glTrackMatrixNV"), target, address, matrix, transform);
  }

  public void glTexCoord2fColor4fNormal3fVertex3fSUN(float s, float t, float r, float g, float b, float a, float nx, float ny, float nz, float x, float y, float z) {
    PFNGLTEXCOORD2FCOLOR4FNORMAL3FVERTEX3FSUNPROC.invoke(load("glTexCoord2fColor4fNormal3fVertex3fSUN"), s, t, r, g, b, a, nx, ny, nz, x, y, z);
  }

  public void glConvolutionParameteriv(int target, int pname, MemorySegment params) {
    PFNGLCONVOLUTIONPARAMETERIVEXTPROC.invoke(load("glConvolutionParameteriv"), target, pname, params);
  }

  public void glRasterPos2xOES(int x, int y) {
    PFNGLRASTERPOS2XOESPROC.invoke(load("glRasterPos2xOES"), x, y);
  }

  public void glVertexAttribL3i64vNV(int index, MemorySegment v) {
    PFNGLVERTEXATTRIBL3I64VNVPROC.invoke(load("glVertexAttribL3i64vNV"), index, v);
  }

  public void glResetHistogramEXT(int target) {
    PFNGLRESETHISTOGRAMEXTPROC.invoke(load("glResetHistogramEXT"), target);
  }

  public void glFlushRasterSGIX() {
    PFNGLFLUSHRASTERSGIXPROC.invoke(load("glFlushRasterSGIX"));
  }

  public void glGetCombinerInputParameterfvNV(int stage, int portion, int variable, int pname, MemorySegment params) {
    PFNGLGETCOMBINERINPUTPARAMETERFVNVPROC.invoke(load("glGetCombinerInputParameterfvNV"), stage, portion, variable, pname, params);
  }

  public void glMultiTexCoord3xOES(int texture, int s, int t, int r) {
    PFNGLMULTITEXCOORD3XOESPROC.invoke(load("glMultiTexCoord3xOES"), texture, s, t, r);
  }

  public void glSpriteParameterfSGIX(int pname, float param) {
    PFNGLSPRITEPARAMETERFSGIXPROC.invoke(load("glSpriteParameterfSGIX"), pname, param);
  }

  public void glGetVertexArrayiv(int vaobj, int pname, MemorySegment param) {
    PFNGLGETVERTEXARRAYIVPROC.invoke(load("glGetVertexArrayiv"), vaobj, pname, param);
  }

  public void glVertexAttribs3dvNV(int index, int count, MemorySegment v) {
    PFNGLVERTEXATTRIBS3DVNVPROC.invoke(load("glVertexAttribs3dvNV"), index, count, v);
  }

  public void glUniformHandleui64vNV(int location, int count, MemorySegment value) {
    PFNGLUNIFORMHANDLEUI64VNVPROC.invoke(load("glUniformHandleui64vNV"), location, count, value);
  }

  public void glVertexAttrib4Nubv(int index, MemorySegment v) {
    PFNGLVERTEXATTRIB4NUBVPROC.invoke(load("glVertexAttrib4Nubv"), index, v);
  }

  public void glVertexFormatNV(int size, int type, int stride) {
    PFNGLVERTEXFORMATNVPROC.invoke(load("glVertexFormatNV"), size, type, stride);
  }

  public long glGetTextureHandleIMG(int texture) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttrib4ubv(int index, MemorySegment v) {
    PFNGLVERTEXATTRIB4UBVPROC.invoke(load("glVertexAttrib4ubv"), index, v);
  }

  public void glMulticastFramebufferSampleLocationsfvNV(int gpu, int framebuffer, int start, int count, MemorySegment v) {
    PFNGLMULTICASTFRAMEBUFFERSAMPLELOCATIONSFVNVPROC.invoke(load("glMulticastFramebufferSampleLocationsfvNV"), gpu, framebuffer, start, count, v);
  }

  public int glGetProgramResourceIndex(int program, int programInterface, MemorySegment name) {
    return PFNGLGETPROGRAMRESOURCEINDEXPROC.invoke(load("glGetProgramResourceIndex"), program, programInterface, name);
  }

  public void glProgramEnvParametersI4uivNV(int target, int index, int count, MemorySegment params) {
    PFNGLPROGRAMENVPARAMETERSI4UIVNVPROC.invoke(load("glProgramEnvParametersI4uivNV"), target, index, count, params);
  }

  public void glProgramParameter4fNV(int target, int index, float x, float y, float z, float w) {
    PFNGLPROGRAMPARAMETER4FNVPROC.invoke(load("glProgramParameter4fNV"), target, index, x, y, z, w);
  }

  public void glMultiTexParameterfvEXT(int texunit, int target, int pname, MemorySegment params) {
    PFNGLMULTITEXPARAMETERFVEXTPROC.invoke(load("glMultiTexParameterfvEXT"), texunit, target, pname, params);
  }

  public void glMultiTexCoord3bOES(int texture, byte s, byte t, byte r) {
    PFNGLMULTITEXCOORD3BOESPROC.invoke(load("glMultiTexCoord3bOES"), texture, s, t, r);
  }

  public void glGetTextureParameterIuiv(int texture, int pname, MemorySegment params) {
    PFNGLGETTEXTUREPARAMETERIUIVPROC.invoke(load("glGetTextureParameterIuiv"), texture, pname, params);
  }

  public int glQueryMatrixxOES(MemorySegment mantissa, MemorySegment exponent) {
    return PFNGLQUERYMATRIXXOESPROC.invoke(load("glQueryMatrixxOES"), mantissa, exponent);
  }

  public void glVertexP3ui(int type, int value) {
    PFNGLVERTEXP3UIPROC.invoke(load("glVertexP3ui"), type, value);
  }

  public void glGetPathMetricRangeNV(int metricQueryMask, int firstPathName, int numPaths, int stride, MemorySegment metrics) {
    PFNGLGETPATHMETRICRANGENVPROC.invoke(load("glGetPathMetricRangeNV"), metricQueryMask, firstPathName, numPaths, stride, metrics);
  }

  public void glMultiTexBufferEXT(int texunit, int target, int internalformat, int buffer) {
    PFNGLMULTITEXBUFFEREXTPROC.invoke(load("glMultiTexBufferEXT"), texunit, target, internalformat, buffer);
  }

  public void glGetnPolygonStippleARB(int bufSize, MemorySegment pattern) {
    PFNGLGETNPOLYGONSTIPPLEARBPROC.invoke(load("glGetnPolygonStippleARB"), bufSize, pattern);
  }

  public void glMultiTexCoord3hNV(int target, short s, short t, short r) {
    PFNGLMULTITEXCOORD3HNVPROC.invoke(load("glMultiTexCoord3hNV"), target, s, t, r);
  }

  public void glAlphaToCoverageDitherControlNV(int mode) {
    PFNGLALPHATOCOVERAGEDITHERCONTROLNVPROC.invoke(load("glAlphaToCoverageDitherControlNV"), mode);
  }

  public void glVertexAttribIFormat(int attribindex, int size, int type, int relativeoffset) {
    PFNGLVERTEXATTRIBIFORMATPROC.invoke(load("glVertexAttribIFormat"), attribindex, size, type, relativeoffset);
  }

  public void glUniform2d(int location, double x, double y) {
    PFNGLUNIFORM2DPROC.invoke(load("glUniform2d"), location, x, y);
  }

  public void glPixelZoomxOES(int xfactor, int yfactor) {
    PFNGLPIXELZOOMXOESPROC.invoke(load("glPixelZoomxOES"), xfactor, yfactor);
  }

  public void glUniform2f(int location, float v0, float v1) {
    PFNGLUNIFORM2FPROC.invoke(load("glUniform2f"), location, v0, v1);
  }

  public void glVertexAttrib4ubvARB(int index, MemorySegment v) {
    PFNGLVERTEXATTRIB4UBVARBPROC.invoke(load("glVertexAttrib4ubvARB"), index, v);
  }

  public void glColor4hvNV(MemorySegment v) {
    PFNGLCOLOR4HVNVPROC.invoke(load("glColor4hvNV"), v);
  }

  public void glUniform2i(int location, int v0, int v1) {
    PFNGLUNIFORM2IPROC.invoke(load("glUniform2i"), location, v0, v1);
  }

  public void glMultiTexCoord1fvARB(int target, MemorySegment v) {
    PFNGLMULTITEXCOORD1FVARBPROC.invoke(load("glMultiTexCoord1fvARB"), target, v);
  }

  public void glEnableDriverControlQCOM(int driverControl) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFragmentMaterialiSGIX(int face, int pname, int param) {
    PFNGLFRAGMENTMATERIALISGIXPROC.invoke(load("glFragmentMaterialiSGIX"), face, pname, param);
  }

  public void glGetVertexAttribPointervARB(int index, int pname, MemorySegment pointer) {
    PFNGLGETVERTEXATTRIBPOINTERVARBPROC.invoke(load("glGetVertexAttribPointervARB"), index, pname, pointer);
  }

  public MemorySegment glMapTexture2DINTEL(int texture, int level, int access, MemorySegment stride, MemorySegment layout) {
    return PFNGLMAPTEXTURE2DINTELPROC.invoke(load("glMapTexture2DINTEL"), texture, level, access, stride, layout);
  }

  public void glProgramUniform4ui(int program, int location, int v0, int v1, int v2, int v3) {
    PFNGLPROGRAMUNIFORM4UIPROC.invoke(load("glProgramUniform4ui"), program, location, v0, v1, v2, v3);
  }

  public void glGenBuffersARB(int n, MemorySegment buffers) {
    PFNGLGENBUFFERSARBPROC.invoke(load("glGenBuffersARB"), n, buffers);
  }

  public void glVertexAttribP2uiv(int index, int type, byte normalized, MemorySegment value) {
    PFNGLVERTEXATTRIBP2UIVPROC.invoke(load("glVertexAttribP2uiv"), index, type, normalized, value);
  }

  public void glUniform3d(int location, double x, double y, double z) {
    PFNGLUNIFORM3DPROC.invoke(load("glUniform3d"), location, x, y, z);
  }

  public void glClientActiveVertexStreamATI(int stream) {
    PFNGLCLIENTACTIVEVERTEXSTREAMATIPROC.invoke(load("glClientActiveVertexStreamATI"), stream);
  }

  public void glUniform3f(int location, float v0, float v1, float v2) {
    PFNGLUNIFORM3FPROC.invoke(load("glUniform3f"), location, v0, v1, v2);
  }

  public void glUniform2fv(int location, int count, MemorySegment value) {
    PFNGLUNIFORM2FVPROC.invoke(load("glUniform2fv"), location, count, value);
  }

  public void glUniform3i(int location, int v0, int v1, int v2) {
    PFNGLUNIFORM3IPROC.invoke(load("glUniform3i"), location, v0, v1, v2);
  }

  public void glSecondaryColor3fv(MemorySegment v) {
    PFNGLSECONDARYCOLOR3FVPROC.invoke(load("glSecondaryColor3fv"), v);
  }

  public void glDrawElementsInstancedNV(int mode, int count, int type, MemorySegment indices, int primcount) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniform4d(int location, double x, double y, double z, double w) {
    PFNGLUNIFORM4DPROC.invoke(load("glUniform4d"), location, x, y, z, w);
  }

  public void glCopyTextureImage2DEXT(int texture, int target, int level, int internalformat, int x, int y, int width, int height, int border) {
    PFNGLCOPYTEXTUREIMAGE2DEXTPROC.invoke(load("glCopyTextureImage2DEXT"), texture, target, level, internalformat, x, y, width, height, border);
  }

  public void glProgramUniform3ivEXT(int program, int location, int count, MemorySegment value) {
    PFNGLPROGRAMUNIFORM3IVEXTPROC.invoke(load("glProgramUniform3ivEXT"), program, location, count, value);
  }

  public byte glIsQueryEXT(int id) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glStateCaptureNV(int state, int mode) {
    PFNGLSTATECAPTURENVPROC.invoke(load("glStateCaptureNV"), state, mode);
  }

  public void glGetQueryIndexediv(int target, int index, int pname, MemorySegment params) {
    PFNGLGETQUERYINDEXEDIVPROC.invoke(load("glGetQueryIndexediv"), target, index, pname, params);
  }

  public void glWindowPos3svMESA(MemorySegment v) {
    PFNGLWINDOWPOS3SVMESAPROC.invoke(load("glWindowPos3svMESA"), v);
  }

  public void glEvalCoord2xOES(int u, int v) {
    PFNGLEVALCOORD2XOESPROC.invoke(load("glEvalCoord2xOES"), u, v);
  }

  public void glGetActiveSubroutineUniformName(int program, int shadertype, int index, int bufSize, MemorySegment length, MemorySegment name) {
    PFNGLGETACTIVESUBROUTINEUNIFORMNAMEPROC.invoke(load("glGetActiveSubroutineUniformName"), program, shadertype, index, bufSize, length, name);
  }

  public void glTexBumpParameterfvATI(int pname, MemorySegment param) {
    PFNGLTEXBUMPPARAMETERFVATIPROC.invoke(load("glTexBumpParameterfvATI"), pname, param);
  }

  public void glUniform1i64ARB(int location, long x) {
    PFNGLUNIFORM1I64ARBPROC.invoke(load("glUniform1i64ARB"), location, x);
  }

  public void glGetObjectParameterfvARB(int obj, int pname, MemorySegment params) {
    opengl.windows.PFNGLGETOBJECTPARAMETERFVARBPROC.invoke(load("glGetObjectParameterfvARB"), obj, pname, params);
  }

  public void glUniform2iv(int location, int count, MemorySegment value) {
    PFNGLUNIFORM2IVPROC.invoke(load("glUniform2iv"), location, count, value);
  }

  public void glBindFragDataLocationIndexed(int program, int colorNumber, int index, MemorySegment name) {
    PFNGLBINDFRAGDATALOCATIONINDEXEDPROC.invoke(load("glBindFragDataLocationIndexed"), program, colorNumber, index, name);
  }

  public void glProgramUniform2ivEXT(int program, int location, int count, MemorySegment value) {
    PFNGLPROGRAMUNIFORM2IVEXTPROC.invoke(load("glProgramUniform2ivEXT"), program, location, count, value);
  }

  public void glVertexWeighthvNV(MemorySegment weight) {
    PFNGLVERTEXWEIGHTHVNVPROC.invoke(load("glVertexWeighthvNV"), weight);
  }

  public void glGetQueryBufferObjecti64v(int id, int buffer, int pname, long offset) {
    PFNGLGETQUERYBUFFEROBJECTI64VPROC.invoke(load("glGetQueryBufferObjecti64v"), id, buffer, pname, offset);
  }

  public void glReplacementCodeuiVertex3fSUN(int rc, float x, float y, float z) {
    PFNGLREPLACEMENTCODEUIVERTEX3FSUNPROC.invoke(load("glReplacementCodeuiVertex3fSUN"), rc, x, y, z);
  }

  public void glClipPlanexOES(int plane, MemorySegment equation) {
    PFNGLCLIPPLANEXOESPROC.invoke(load("glClipPlanexOES"), plane, equation);
  }

  public void glVertexAttrib1dNV(int index, double x) {
    PFNGLVERTEXATTRIB1DNVPROC.invoke(load("glVertexAttrib1dNV"), index, x);
  }

  public void glUniform1uiEXT(int location, int v0) {
    PFNGLUNIFORM1UIEXTPROC.invoke(load("glUniform1uiEXT"), location, v0);
  }

  public void glStencilThenCoverStrokePathInstancedNV(int numPaths, int pathNameType, MemorySegment paths, int pathBase, int reference, int mask, int coverMode, int transformType, MemorySegment transformValues) {
    PFNGLSTENCILTHENCOVERSTROKEPATHINSTANCEDNVPROC.invoke(load("glStencilThenCoverStrokePathInstancedNV"), numPaths, pathNameType, paths, pathBase, reference, mask, coverMode, transformType, transformValues);
  }

  public void glPrimitiveRestartIndexNV(int index) {
    PFNGLPRIMITIVERESTARTINDEXNVPROC.invoke(load("glPrimitiveRestartIndexNV"), index);
  }

  public void glPointParameterxOES(int pname, int param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniform1d(int location, double x) {
    PFNGLUNIFORM1DPROC.invoke(load("glUniform1d"), location, x);
  }

  public void glTextureParameteri(int texture, int pname, int param) {
    PFNGLTEXTUREPARAMETERIPROC.invoke(load("glTextureParameteri"), texture, pname, param);
  }

  public void glUniform1f(int location, float v0) {
    PFNGLUNIFORM1FPROC.invoke(load("glUniform1f"), location, v0);
  }

  public void glDisablei(int target, int index) {
    PFNGLDISABLEIPROC.invoke(load("glDisablei"), target, index);
  }

  public void glTextureParameterf(int texture, int pname, float param) {
    PFNGLTEXTUREPARAMETERFPROC.invoke(load("glTextureParameterf"), texture, pname, param);
  }

  public void glUniform1i(int location, int v0) {
    PFNGLUNIFORM1IPROC.invoke(load("glUniform1i"), location, v0);
  }

  public void glColorTable(int target, int internalformat, int width, int format, int type, MemorySegment table) {
    PFNGLCOLORTABLEEXTPROC.invoke(load("glColorTable"), target, internalformat, width, format, type, table);
  }

  public void glBindBuffersBase(int target, int first, int count, MemorySegment buffers) {
    PFNGLBINDBUFFERSBASEPROC.invoke(load("glBindBuffersBase"), target, first, count, buffers);
  }

  public void glExtGetBufferPointervQCOM(int target, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public byte glIsEnablediOES(int target, int index) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetCompressedMultiTexImageEXT(int texunit, int target, int lod, MemorySegment img) {
    PFNGLGETCOMPRESSEDMULTITEXIMAGEEXTPROC.invoke(load("glGetCompressedMultiTexImageEXT"), texunit, target, lod, img);
  }

  public void glVertexAttrib4NubARB(int index, byte x, byte y, byte z, byte w) {
    PFNGLVERTEXATTRIB4NUBARBPROC.invoke(load("glVertexAttrib4NubARB"), index, x, y, z, w);
  }

  public void glGetnConvolutionFilter(int target, int format, int type, int bufSize, MemorySegment image) {
    PFNGLGETNCONVOLUTIONFILTERPROC.invoke(load("glGetnConvolutionFilter"), target, format, type, bufSize, image);
  }

  public void glMatrixIndexusvARB(int size, MemorySegment indices) {
    PFNGLMATRIXINDEXUSVARBPROC.invoke(load("glMatrixIndexusvARB"), size, indices);
  }

  public void glVertexAttribI4i(int index, int x, int y, int z, int w) {
    PFNGLVERTEXATTRIBI4IPROC.invoke(load("glVertexAttribI4i"), index, x, y, z, w);
  }

  public void glTextureStorage2DMultisample(int texture, int samples, int internalformat, int width, int height, byte fixedsamplelocations) {
    PFNGLTEXTURESTORAGE2DMULTISAMPLEPROC.invoke(load("glTextureStorage2DMultisample"), texture, samples, internalformat, width, height, fixedsamplelocations);
  }

  public MemorySegment glMapNamedBuffer(int buffer, int access) {
    return PFNGLMAPNAMEDBUFFERPROC.invoke(load("glMapNamedBuffer"), buffer, access);
  }

  public void glGetFloati_vEXT(int pname, int index, MemorySegment params) {
    PFNGLGETFLOATI_VEXTPROC.invoke(load("glGetFloati_vEXT"), pname, index, params);
  }

  public void glGetObjectLabel(int identifier, int name, int bufSize, MemorySegment length, MemorySegment label) {
    PFNGLGETOBJECTLABELPROC.invoke(load("glGetObjectLabel"), identifier, name, bufSize, length, label);
  }

  public void glGetPerfQueryIdByNameINTEL(MemorySegment queryName, MemorySegment queryId) {
    PFNGLGETPERFQUERYIDBYNAMEINTELPROC.invoke(load("glGetPerfQueryIdByNameINTEL"), queryName, queryId);
  }

  public void glSecondaryColor3bv(MemorySegment v) {
    PFNGLSECONDARYCOLOR3BVPROC.invoke(load("glSecondaryColor3bv"), v);
  }

  public void glMultiDrawArraysIndirectEXT(int mode, MemorySegment indirect, int drawcount, int stride) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDrawElementArrayATI(int mode, int count) {
    PFNGLDRAWELEMENTARRAYATIPROC.invoke(load("glDrawElementArrayATI"), mode, count);
  }

  public void glMemoryBarrier(int barriers) {
    PFNGLMEMORYBARRIERPROC.invoke(load("glMemoryBarrier"), barriers);
  }

  public void glUniform1uiv(int location, int count, MemorySegment value) {
    PFNGLUNIFORM1UIVPROC.invoke(load("glUniform1uiv"), location, count, value);
  }

  public void glGetnPolygonStipple(int bufSize, MemorySegment pattern) {
    PFNGLGETNPOLYGONSTIPPLEPROC.invoke(load("glGetnPolygonStipple"), bufSize, pattern);
  }

  public void glVertexAttribDivisorEXT(int index, int divisor) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMapBufferOES(int target, int access) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glTextureStorageSparseAMD(int texture, int target, int internalFormat, int width, int height, int depth, int layers, int flags) {
    PFNGLTEXTURESTORAGESPARSEAMDPROC.invoke(load("glTextureStorageSparseAMD"), texture, target, internalFormat, width, height, depth, layers, flags);
  }

  public void glFogCoordhvNV(MemorySegment fog) {
    PFNGLFOGCOORDHVNVPROC.invoke(load("glFogCoordhvNV"), fog);
  }

  public void glSamplerParameterIuiv(int sampler, int pname, MemorySegment param) {
    PFNGLSAMPLERPARAMETERIUIVPROC.invoke(load("glSamplerParameterIuiv"), sampler, pname, param);
  }

  public void glDeleteFragmentShaderATI(int id) {
    PFNGLDELETEFRAGMENTSHADERATIPROC.invoke(load("glDeleteFragmentShaderATI"), id);
  }

  public void glVertexAttribI2i(int index, int x, int y) {
    PFNGLVERTEXATTRIBI2IPROC.invoke(load("glVertexAttribI2i"), index, x, y);
  }

  public void glDeleteSync(MemorySegment sync) {
    PFNGLDELETESYNCPROC.invoke(load("glDeleteSync"), sync);
  }

  public byte glIsNamedStringARB(int namelen, MemorySegment name) {
    return PFNGLISNAMEDSTRINGARBPROC.invoke(load("glIsNamedStringARB"), namelen, name);
  }

  public float glGetPathLengthNV(int path, int startSegment, int numSegments) {
    return PFNGLGETPATHLENGTHNVPROC.invoke(load("glGetPathLengthNV"), path, startSegment, numSegments);
  }

  public void glBindFramebufferOES(int target, int framebuffer) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glActiveVaryingNV(int program, MemorySegment name) {
    PFNGLACTIVEVARYINGNVPROC.invoke(load("glActiveVaryingNV"), program, name);
  }

  public void glUniform2dv(int location, int count, MemorySegment value) {
    PFNGLUNIFORM2DVPROC.invoke(load("glUniform2dv"), location, count, value);
  }

  public void glNamedProgramLocalParameterI4ivEXT(int program, int target, int index, MemorySegment params) {
    PFNGLNAMEDPROGRAMLOCALPARAMETERI4IVEXTPROC.invoke(load("glNamedProgramLocalParameterI4ivEXT"), program, target, index, params);
  }

  public void glSecondaryColor3dv(MemorySegment v) {
    PFNGLSECONDARYCOLOR3DVPROC.invoke(load("glSecondaryColor3dv"), v);
  }

  public void glTexBufferRangeOES(int target, int internalformat, int buffer, long offset, long size) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFramebufferTexture2DDownsampleIMG(int target, int attachment, int textarget, int texture, int level, int xscale, int yscale) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glUniform1ivARB(int location, int count, MemorySegment value) {
    PFNGLUNIFORM1IVARBPROC.invoke(load("glUniform1ivARB"), location, count, value);
  }

  public void glColorP4ui(int type, int color) {
    PFNGLCOLORP4UIPROC.invoke(load("glColorP4ui"), type, color);
  }

  public void glCompressedMultiTexSubImage1DEXT(int texunit, int target, int level, int xoffset, int width, int format, int imageSize, MemorySegment bits) {
    PFNGLCOMPRESSEDMULTITEXSUBIMAGE1DEXTPROC.invoke(load("glCompressedMultiTexSubImage1DEXT"), texunit, target, level, xoffset, width, format, imageSize, bits);
  }

  public void glVertexAttrib4uiv(int index, MemorySegment v) {
    PFNGLVERTEXATTRIB4UIVPROC.invoke(load("glVertexAttrib4uiv"), index, v);
  }

  public void glVertexAttribI3i(int index, int x, int y, int z) {
    PFNGLVERTEXATTRIBI3IPROC.invoke(load("glVertexAttribI3i"), index, x, y, z);
  }

  public void glGetPerfMonitorCounterDataAMD(int monitor, int pname, int dataSize, MemorySegment data, MemorySegment bytesWritten) {
    PFNGLGETPERFMONITORCOUNTERDATAAMDPROC.invoke(load("glGetPerfMonitorCounterDataAMD"), monitor, pname, dataSize, data, bytesWritten);
  }

  public void glBindProgramNV(int target, int id) {
    PFNGLBINDPROGRAMNVPROC.invoke(load("glBindProgramNV"), target, id);
  }

  public void glDeleteSamplers(int count, MemorySegment samplers) {
    PFNGLDELETESAMPLERSPROC.invoke(load("glDeleteSamplers"), count, samplers);
  }

  public void glGetProgramEnvParameterIivNV(int target, int index, MemorySegment params) {
    PFNGLGETPROGRAMENVPARAMETERIIVNVPROC.invoke(load("glGetProgramEnvParameterIivNV"), target, index, params);
  }

  public void glClearColorIuiEXT(int red, int green, int blue, int alpha) {
    PFNGLCLEARCOLORIUIEXTPROC.invoke(load("glClearColorIuiEXT"), red, green, blue, alpha);
  }

  public void glVertexAttribs4fvNV(int index, int count, MemorySegment v) {
    PFNGLVERTEXATTRIBS4FVNVPROC.invoke(load("glVertexAttribs4fvNV"), index, count, v);
  }

  public void glProgramUniformMatrix3x4dv(int program, int location, int count, byte transpose, MemorySegment value) {
    PFNGLPROGRAMUNIFORMMATRIX3X4DVPROC.invoke(load("glProgramUniformMatrix3x4dv"), program, location, count, transpose, value);
  }

  public void glUniformHandleui64vARB(int location, int count, MemorySegment value) {
    PFNGLUNIFORMHANDLEUI64VARBPROC.invoke(load("glUniformHandleui64vARB"), location, count, value);
  }

  public void glVideoCaptureStreamParameterfvNV(int video_capture_slot, int stream, int pname, MemorySegment params) {
    PFNGLVIDEOCAPTURESTREAMPARAMETERFVNVPROC.invoke(load("glVideoCaptureStreamParameterfvNV"), video_capture_slot, stream, pname, params);
  }

  public void glPathTexGenNV(int texCoordSet, int genMode, int components, MemorySegment coeffs) {
    PFNGLPATHTEXGENNVPROC.invoke(load("glPathTexGenNV"), texCoordSet, genMode, components, coeffs);
  }

  public void glImageTransformParameterfHP(int target, int pname, float param) {
    PFNGLIMAGETRANSFORMPARAMETERFHPPROC.invoke(load("glImageTransformParameterfHP"), target, pname, param);
  }

  public void glNormal3xvOES(MemorySegment coords) {
    PFNGLNORMAL3XVOESPROC.invoke(load("glNormal3xvOES"), coords);
  }

  public void glProgramUniform4dvEXT(int program, int location, int count, MemorySegment value) {
    PFNGLPROGRAMUNIFORM4DVEXTPROC.invoke(load("glProgramUniform4dvEXT"), program, location, count, value);
  }

  public void glGetTexGenfvOES(int coord, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glPixelDataRangeNV(int target, int length, MemorySegment pointer) {
    PFNGLPIXELDATARANGENVPROC.invoke(load("glPixelDataRangeNV"), target, length, pointer);
  }

  public void glPointParameterfvARB(int pname, MemorySegment params) {
    PFNGLPOINTPARAMETERFVARBPROC.invoke(load("glPointParameterfvARB"), pname, params);
  }

  public void glVertexAttribLPointer(int index, int size, int type, int stride, MemorySegment pointer) {
    PFNGLVERTEXATTRIBLPOINTERPROC.invoke(load("glVertexAttribLPointer"), index, size, type, stride, pointer);
  }

  public void glGetPerfQueryDataINTEL(int queryHandle, int flags, int dataSize, MemorySegment data, MemorySegment bytesWritten) {
    PFNGLGETPERFQUERYDATAINTELPROC.invoke(load("glGetPerfQueryDataINTEL"), queryHandle, flags, dataSize, data, bytesWritten);
  }

  public void glGetMapParameterfvNV(int target, int pname, MemorySegment params) {
    PFNGLGETMAPPARAMETERFVNVPROC.invoke(load("glGetMapParameterfvNV"), target, pname, params);
  }

  public void glGetMinmaxParameterfvEXT(int target, int pname, MemorySegment params) {
    PFNGLGETMINMAXPARAMETERFVEXTPROC.invoke(load("glGetMinmaxParameterfvEXT"), target, pname, params);
  }

  public void glBindFragmentShaderATI(int id) {
    PFNGLBINDFRAGMENTSHADERATIPROC.invoke(load("glBindFragmentShaderATI"), id);
  }

  public void glVertexAttribI1i(int index, int x) {
    PFNGLVERTEXATTRIBI1IPROC.invoke(load("glVertexAttribI1i"), index, x);
  }

  public void glVertexAttrib3sNV(int index, short x, short y, short z) {
    PFNGLVERTEXATTRIB3SNVPROC.invoke(load("glVertexAttrib3sNV"), index, x, y, z);
  }

  public void glVertexAttrib3fvARB(int index, MemorySegment v) {
    PFNGLVERTEXATTRIB3FVARBPROC.invoke(load("glVertexAttrib3fvARB"), index, v);
  }

  public void glProgramUniform4ui64vARB(int program, int location, int count, MemorySegment value) {
    PFNGLPROGRAMUNIFORM4UI64VARBPROC.invoke(load("glProgramUniform4ui64vARB"), program, location, count, value);
  }

  public void glProgramBinary(int program, int binaryFormat, MemorySegment binary, int length) {
    PFNGLPROGRAMBINARYPROC.invoke(load("glProgramBinary"), program, binaryFormat, binary, length);
  }

  public void glUniformMatrix2fvARB(int location, int count, byte transpose, MemorySegment value) {
    PFNGLUNIFORMMATRIX2FVARBPROC.invoke(load("glUniformMatrix2fvARB"), location, count, transpose, value);
  }

  public void glVertexAttribP2ui(int index, int type, byte normalized, int value) {
    PFNGLVERTEXATTRIBP2UIPROC.invoke(load("glVertexAttribP2ui"), index, type, normalized, value);
  }

  public void glFogCoordfEXT(float coord) {
    PFNGLFOGCOORDFEXTPROC.invoke(load("glFogCoordfEXT"), coord);
  }

  public void glVertexStream4fvATI(int stream, MemorySegment coords) {
    PFNGLVERTEXSTREAM4FVATIPROC.invoke(load("glVertexStream4fvATI"), stream, coords);
  }

  public void glProgramEnvParameter4fARB(int target, int index, float x, float y, float z, float w) {
    PFNGLPROGRAMENVPARAMETER4FARBPROC.invoke(load("glProgramEnvParameter4fARB"), target, index, x, y, z, w);
  }

  public void glSecondaryColor3usEXT(short red, short green, short blue) {
    PFNGLSECONDARYCOLOR3USEXTPROC.invoke(load("glSecondaryColor3usEXT"), red, green, blue);
  }

  public void glConvolutionParameterfv(int target, int pname, MemorySegment params) {
    PFNGLCONVOLUTIONPARAMETERFVEXTPROC.invoke(load("glConvolutionParameterfv"), target, pname, params);
  }

  public void glCommandListSegmentsNV(int list, int segments) {
    PFNGLCOMMANDLISTSEGMENTSNVPROC.invoke(load("glCommandListSegmentsNV"), list, segments);
  }

  public void glMakeTextureHandleNonResidentARB(long handle) {
    PFNGLMAKETEXTUREHANDLENONRESIDENTARBPROC.invoke(load("glMakeTextureHandleNonResidentARB"), handle);
  }

  public void glDrawTexsOES(short x, short y, short z, short width, short height) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public byte glUnmapBufferOES(int target) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertex4bvOES(MemorySegment coords) {
    PFNGLVERTEX4BVOESPROC.invoke(load("glVertex4bvOES"), coords);
  }

  public void glWindowPos2dvARB(MemorySegment v) {
    PFNGLWINDOWPOS2DVARBPROC.invoke(load("glWindowPos2dvARB"), v);
  }

  public void glCompressedTexSubImage3DARB(int target, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int format, int imageSize, MemorySegment data) {
    PFNGLCOMPRESSEDTEXSUBIMAGE3DARBPROC.invoke(load("glCompressedTexSubImage3DARB"), target, level, xoffset, yoffset, zoffset, width, height, depth, format, imageSize, data);
  }

  public void glDrawElementsIndirect(int mode, int type, MemorySegment indirect) {
    PFNGLDRAWELEMENTSINDIRECTPROC.invoke(load("glDrawElementsIndirect"), mode, type, indirect);
  }

  public void glReplacementCodeusSUN(short code) {
    PFNGLREPLACEMENTCODEUSSUNPROC.invoke(load("glReplacementCodeusSUN"), code);
  }

  public void glUniformMatrix2x4fvNV(int location, int count, byte transpose, MemorySegment value) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glBindBufferOffsetEXT(int target, int index, int buffer, long offset) {
    PFNGLBINDBUFFEROFFSETEXTPROC.invoke(load("glBindBufferOffsetEXT"), target, index, buffer, offset);
  }

  public void glExtGetTexturesQCOM(MemorySegment textures, int maxTextures, MemorySegment numTextures) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glScissorArrayvOES(int first, int count, MemorySegment v) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glRasterPos4xvOES(MemorySegment coords) {
    PFNGLRASTERPOS4XVOESPROC.invoke(load("glRasterPos4xvOES"), coords);
  }

  public void glVertexArrayVertexAttribIOffsetEXT(int vaobj, int buffer, int index, int size, int type, int stride, long offset) {
    PFNGLVERTEXARRAYVERTEXATTRIBIOFFSETEXTPROC.invoke(load("glVertexArrayVertexAttribIOffsetEXT"), vaobj, buffer, index, size, type, stride, offset);
  }

  public void glGetMinmaxEXT(int target, byte reset, int format, int type, MemorySegment values) {
    PFNGLGETMINMAXEXTPROC.invoke(load("glGetMinmaxEXT"), target, reset, format, type, values);
  }

  public void glGetPathColorGenfvNV(int color, int pname, MemorySegment value) {
    PFNGLGETPATHCOLORGENFVNVPROC.invoke(load("glGetPathColorGenfvNV"), color, pname, value);
  }

  public void glWindowPos4dMESA(double x, double y, double z, double w) {
    PFNGLWINDOWPOS4DMESAPROC.invoke(load("glWindowPos4dMESA"), x, y, z, w);
  }

  public void glVertexAttribL4ui64vNV(int index, MemorySegment v) {
    PFNGLVERTEXATTRIBL4UI64VNVPROC.invoke(load("glVertexAttribL4ui64vNV"), index, v);
  }

  public void glBlendFuncSeparatei(int buf, int srcRGB, int dstRGB, int srcAlpha, int dstAlpha) {
    PFNGLBLENDFUNCSEPARATEIPROC.invoke(load("glBlendFuncSeparatei"), buf, srcRGB, dstRGB, srcAlpha, dstAlpha);
  }

  public void glCreateProgramPipelines(int n, MemorySegment pipelines) {
    PFNGLCREATEPROGRAMPIPELINESPROC.invoke(load("glCreateProgramPipelines"), n, pipelines);
  }

  public void glFogxOES(int pname, int param) {
    PFNGLFOGXOESPROC.invoke(load("glFogxOES"), pname, param);
  }

  public void glTexImage2DMultisample(int target, int samples, int internalformat, int width, int height, byte fixedsamplelocations) {
    PFNGLTEXIMAGE2DMULTISAMPLEPROC.invoke(load("glTexImage2DMultisample"), target, samples, internalformat, width, height, fixedsamplelocations);
  }

  public int glObjectPurgeableAPPLE(int objectType, int name, int option) {
    return PFNGLOBJECTPURGEABLEAPPLEPROC.invoke(load("glObjectPurgeableAPPLE"), objectType, name, option);
  }

  public void glViewportSwizzleNV(int index, int swizzlex, int swizzley, int swizzlez, int swizzlew) {
    PFNGLVIEWPORTSWIZZLENVPROC.invoke(load("glViewportSwizzleNV"), index, swizzlex, swizzley, swizzlez, swizzlew);
  }

  public void glMultiTexCoord3fARB(int target, float s, float t, float r) {
    PFNGLMULTITEXCOORD3FARBPROC.invoke(load("glMultiTexCoord3fARB"), target, s, t, r);
  }

  public void glDisableClientStateiEXT(int array, int index) {
    PFNGLDISABLECLIENTSTATEIEXTPROC.invoke(load("glDisableClientStateiEXT"), array, index);
  }

  public void glGetShadingRateImagePaletteNV(int viewport, int entry, MemorySegment rate) {
    PFNGLGETSHADINGRATEIMAGEPALETTENVPROC.invoke(load("glGetShadingRateImagePaletteNV"), viewport, entry, rate);
  }

  public void glVertexAttribL1i64NV(int index, long x) {
    PFNGLVERTEXATTRIBL1I64NVPROC.invoke(load("glVertexAttribL1i64NV"), index, x);
  }

  public void glTextureSubImage2DEXT(int texture, int target, int level, int xoffset, int yoffset, int width, int height, int format, int type, MemorySegment pixels) {
    PFNGLTEXTURESUBIMAGE2DEXTPROC.invoke(load("glTextureSubImage2DEXT"), texture, target, level, xoffset, yoffset, width, height, format, type, pixels);
  }

  public void glFragmentLightfSGIX(int light, int pname, float param) {
    PFNGLFRAGMENTLIGHTFSGIXPROC.invoke(load("glFragmentLightfSGIX"), light, pname, param);
  }

  public void glGlobalAlphaFactorbSUN(byte factor) {
    PFNGLGLOBALALPHAFACTORBSUNPROC.invoke(load("glGlobalAlphaFactorbSUN"), factor);
  }

  public void glVertexStream3iATI(int stream, int x, int y, int z) {
    PFNGLVERTEXSTREAM3IATIPROC.invoke(load("glVertexStream3iATI"), stream, x, y, z);
  }

  public int glBindParameterEXT(int value) {
    return PFNGLBINDPARAMETEREXTPROC.invoke(load("glBindParameterEXT"), value);
  }

  public void glDrawElementsBaseVertexEXT(int mode, int count, int type, MemorySegment indices, int basevertex) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexArrayRangeAPPLE(int length, MemorySegment pointer) {
    PFNGLVERTEXARRAYRANGEAPPLEPROC.invoke(load("glVertexArrayRangeAPPLE"), length, pointer);
  }

  public void glGetColorTableParameterfvEXT(int target, int pname, MemorySegment params) {
    PFNGLGETCOLORTABLEPARAMETERFVEXTPROC.invoke(load("glGetColorTableParameterfvEXT"), target, pname, params);
  }

  public void glRasterSamplesEXT(int samples, byte fixedsamplelocations) {
    PFNGLRASTERSAMPLESEXTPROC.invoke(load("glRasterSamplesEXT"), samples, fixedsamplelocations);
  }

  public void glNormalStream3dATI(int stream, double nx, double ny, double nz) {
    PFNGLNORMALSTREAM3DATIPROC.invoke(load("glNormalStream3dATI"), stream, nx, ny, nz);
  }

  public void glProgramUniform4i64NV(int program, int location, long x, long y, long z, long w) {
    PFNGLPROGRAMUNIFORM4I64NVPROC.invoke(load("glProgramUniform4i64NV"), program, location, x, y, z, w);
  }

  public void glGetVertexAttribdvNV(int index, int pname, MemorySegment params) {
    PFNGLGETVERTEXATTRIBDVNVPROC.invoke(load("glGetVertexAttribdvNV"), index, pname, params);
  }

  public void glUniform2ui64ARB(int location, long x, long y) {
    PFNGLUNIFORM2UI64ARBPROC.invoke(load("glUniform2ui64ARB"), location, x, y);
  }

  public void glGetProgramLocalParameterdvARB(int target, int index, MemorySegment params) {
    PFNGLGETPROGRAMLOCALPARAMETERDVARBPROC.invoke(load("glGetProgramLocalParameterdvARB"), target, index, params);
  }

  public byte glIsSyncAPPLE(MemorySegment sync) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttrib4usv(int index, MemorySegment v) {
    PFNGLVERTEXATTRIB4USVPROC.invoke(load("glVertexAttrib4usv"), index, v);
  }

  public void glGetQueryObjectuivARB(int id, int pname, MemorySegment params) {
    PFNGLGETQUERYOBJECTUIVARBPROC.invoke(load("glGetQueryObjectuivARB"), id, pname, params);
  }

  public void glFogFuncSGIS(int n, MemorySegment points) {
    PFNGLFOGFUNCSGISPROC.invoke(load("glFogFuncSGIS"), n, points);
  }

  public void glProgramUniformMatrix3x4fv(int program, int location, int count, byte transpose, MemorySegment value) {
    PFNGLPROGRAMUNIFORMMATRIX3X4FVPROC.invoke(load("glProgramUniformMatrix3x4fv"), program, location, count, transpose, value);
  }

  public void glFramebufferReadBufferEXT(int framebuffer, int mode) {
    PFNGLFRAMEBUFFERREADBUFFEREXTPROC.invoke(load("glFramebufferReadBufferEXT"), framebuffer, mode);
  }

  public void glTextureParameterfv(int texture, int pname, MemorySegment param) {
    PFNGLTEXTUREPARAMETERFVPROC.invoke(load("glTextureParameterfv"), texture, pname, param);
  }

  public void glGetMaterialxvOES(int face, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexCoord2dARB(int target, double s, double t) {
    PFNGLMULTITEXCOORD2DARBPROC.invoke(load("glMultiTexCoord2dARB"), target, s, t);
  }

  public int glGetUniformBlockIndex(int program, MemorySegment uniformBlockName) {
    return PFNGLGETUNIFORMBLOCKINDEXPROC.invoke(load("glGetUniformBlockIndex"), program, uniformBlockName);
  }

  public void glInvalidateBufferData(int buffer) {
    PFNGLINVALIDATEBUFFERDATAPROC.invoke(load("glInvalidateBufferData"), buffer);
  }

  public void glTransformFeedbackBufferBase(int xfb, int index, int buffer) {
    PFNGLTRANSFORMFEEDBACKBUFFERBASEPROC.invoke(load("glTransformFeedbackBufferBase"), xfb, index, buffer);
  }

  public void glPolygonModeNV(int face, int mode) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glNamedFramebufferSampleLocationsfvARB(int framebuffer, int start, int count, MemorySegment v) {
    PFNGLNAMEDFRAMEBUFFERSAMPLELOCATIONSFVARBPROC.invoke(load("glNamedFramebufferSampleLocationsfvARB"), framebuffer, start, count, v);
  }

  public void glVertexArrayAttribBinding(int vaobj, int attribindex, int bindingindex) {
    PFNGLVERTEXARRAYATTRIBBINDINGPROC.invoke(load("glVertexArrayAttribBinding"), vaobj, attribindex, bindingindex);
  }

  public void glTextureStorageMem2DMultisampleEXT(int texture, int samples, int internalFormat, int width, int height, byte fixedSampleLocations, int memory, long offset) {
    PFNGLTEXTURESTORAGEMEM2DMULTISAMPLEEXTPROC.invoke(load("glTextureStorageMem2DMultisampleEXT"), texture, samples, internalFormat, width, height, fixedSampleLocations, memory, offset);
  }

  public void glGetNamedBufferPointervEXT(int buffer, int pname, MemorySegment params) {
    PFNGLGETNAMEDBUFFERPOINTERVEXTPROC.invoke(load("glGetNamedBufferPointervEXT"), buffer, pname, params);
  }

  public void glUniformMatrix3x4fv(int location, int count, byte transpose, MemorySegment value) {
    PFNGLUNIFORMMATRIX3X4FVPROC.invoke(load("glUniformMatrix3x4fv"), location, count, transpose, value);
  }

  public void glGetTexEnvxv(int target, int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glCompressedTexImage3D(int target, int level, int internalformat, int width, int height, int depth, int border, int imageSize, MemorySegment data) {
    PFNGLCOMPRESSEDTEXIMAGE3DPROC.invoke(load("glCompressedTexImage3D"), target, level, internalformat, width, height, depth, border, imageSize, data);
  }

  public void glMultiTexCoord1hvNV(int target, MemorySegment v) {
    PFNGLMULTITEXCOORD1HVNVPROC.invoke(load("glMultiTexCoord1hvNV"), target, v);
  }

  public byte glUnmapBuffer(int target) {
    return PFNGLUNMAPBUFFERPROC.invoke(load("glUnmapBuffer"), target);
  }

  public void glTranslatex(int x, int y, int z) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexParameterIuivEXT(int texunit, int target, int pname, MemorySegment params) {
    PFNGLMULTITEXPARAMETERIUIVEXTPROC.invoke(load("glMultiTexParameterIuivEXT"), texunit, target, pname, params);
  }

  public void glTexCoord3xvOES(MemorySegment coords) {
    PFNGLTEXCOORD3XVOESPROC.invoke(load("glTexCoord3xvOES"), coords);
  }

  public void glGetnTexImage(int target, int level, int format, int type, int bufSize, MemorySegment pixels) {
    PFNGLGETNTEXIMAGEPROC.invoke(load("glGetnTexImage"), target, level, format, type, bufSize, pixels);
  }

  public void glReadnPixelsEXT(int x, int y, int width, int height, int format, int type, int bufSize, MemorySegment data) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribL1dvEXT(int index, MemorySegment v) {
    PFNGLVERTEXATTRIBL1DVEXTPROC.invoke(load("glVertexAttribL1dvEXT"), index, v);
  }

  public void glCopyMultiTexSubImage1DEXT(int texunit, int target, int level, int xoffset, int x, int y, int width) {
    PFNGLCOPYMULTITEXSUBIMAGE1DEXTPROC.invoke(load("glCopyMultiTexSubImage1DEXT"), texunit, target, level, xoffset, x, y, width);
  }

  public void glTexCoord3xOES(int s, int t, int r) {
    PFNGLTEXCOORD3XOESPROC.invoke(load("glTexCoord3xOES"), s, t, r);
  }

  public void glProgramUniform4dv(int program, int location, int count, MemorySegment value) {
    PFNGLPROGRAMUNIFORM4DVPROC.invoke(load("glProgramUniform4dv"), program, location, count, value);
  }

  public void glGetConvolutionFilter(int target, int format, int type, MemorySegment image) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glConservativeRasterParameteriNV(int pname, int param) {
    PFNGLCONSERVATIVERASTERPARAMETERINVPROC.invoke(load("glConservativeRasterParameteriNV"), pname, param);
  }

  public void glEnableIndexedEXT(int target, int index) {
    PFNGLENABLEINDEXEDEXTPROC.invoke(load("glEnableIndexedEXT"), target, index);
  }

  public void glUniformMatrix3x4dv(int location, int count, byte transpose, MemorySegment value) {
    PFNGLUNIFORMMATRIX3X4DVPROC.invoke(load("glUniformMatrix3x4dv"), location, count, transpose, value);
  }

  public void glPointParameterfARB(int pname, float param) {
    PFNGLPOINTPARAMETERFARBPROC.invoke(load("glPointParameterfARB"), pname, param);
  }

  public void glGetClipPlanex(int plane, MemorySegment equation) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glMultiTexCoord4sARB(int target, short s, short t, short r, short q) {
    PFNGLMULTITEXCOORD4SARBPROC.invoke(load("glMultiTexCoord4sARB"), target, s, t, r, q);
  }

  public void glGetnCompressedTexImage(int target, int lod, int bufSize, MemorySegment pixels) {
    PFNGLGETNCOMPRESSEDTEXIMAGEPROC.invoke(load("glGetnCompressedTexImage"), target, lod, bufSize, pixels);
  }

  public void glNormalStream3ivATI(int stream, MemorySegment coords) {
    PFNGLNORMALSTREAM3IVATIPROC.invoke(load("glNormalStream3ivATI"), stream, coords);
  }

  public void glGenFramebuffersOES(int n, MemorySegment framebuffers) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribLFormatNV(int index, int size, int type, int stride) {
    PFNGLVERTEXATTRIBLFORMATNVPROC.invoke(load("glVertexAttribLFormatNV"), index, size, type, stride);
  }

  public void glShaderOp2EXT(int op, int res, int arg1, int arg2) {
    PFNGLSHADEROP2EXTPROC.invoke(load("glShaderOp2EXT"), op, res, arg1, arg2);
  }

  public void glGetActiveSubroutineName(int program, int shadertype, int index, int bufSize, MemorySegment length, MemorySegment name) {
    PFNGLGETACTIVESUBROUTINENAMEPROC.invoke(load("glGetActiveSubroutineName"), program, shadertype, index, bufSize, length, name);
  }

  public void glGetClipPlanef(int plane, MemorySegment equation) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glNamedProgramStringEXT(int program, int target, int format, int len, MemorySegment string) {
    PFNGLNAMEDPROGRAMSTRINGEXTPROC.invoke(load("glNamedProgramStringEXT"), program, target, format, len, string);
  }

  public void glProgramUniformMatrix4fvEXT(int program, int location, int count, byte transpose, MemorySegment value) {
    PFNGLPROGRAMUNIFORMMATRIX4FVEXTPROC.invoke(load("glProgramUniformMatrix4fvEXT"), program, location, count, transpose, value);
  }

  public void glMatrixFrustumEXT(int mode, double left, double right, double bottom, double top, double zNear, double zFar) {
    PFNGLMATRIXFRUSTUMEXTPROC.invoke(load("glMatrixFrustumEXT"), mode, left, right, bottom, top, zNear, zFar);
  }

  public void glTexCoordP1ui(int type, int coords) {
    PFNGLTEXCOORDP1UIPROC.invoke(load("glTexCoordP1ui"), type, coords);
  }

  public void glCompressedTexImage1D(int target, int level, int internalformat, int width, int border, int imageSize, MemorySegment data) {
    PFNGLCOMPRESSEDTEXIMAGE1DPROC.invoke(load("glCompressedTexImage1D"), target, level, internalformat, width, border, imageSize, data);
  }

  public void glGetTexEnvxvOES(int target, int pname, MemorySegment params) {
    PFNGLGETTEXENVXVOESPROC.invoke(load("glGetTexEnvxvOES"), target, pname, params);
  }

  public void glTexCoord3bOES(byte s, byte t, byte r) {
    PFNGLTEXCOORD3BOESPROC.invoke(load("glTexCoord3bOES"), s, t, r);
  }

  public void glStencilOpSeparate(int face, int sfail, int dpfail, int dppass) {
    PFNGLSTENCILOPSEPARATEPROC.invoke(load("glStencilOpSeparate"), face, sfail, dpfail, dppass);
  }

  public void glPixelTransformParameterfEXT(int target, int pname, float param) {
    PFNGLPIXELTRANSFORMPARAMETERFEXTPROC.invoke(load("glPixelTransformParameterfEXT"), target, pname, param);
  }

  public void glConvolutionParameterfEXT(int target, int pname, float params) {
    PFNGLCONVOLUTIONPARAMETERFEXTPROC.invoke(load("glConvolutionParameterfEXT"), target, pname, params);
  }

  public void glGetFloati_vOES(int target, int index, MemorySegment data) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetProgramLocalParameterIivNV(int target, int index, MemorySegment params) {
    PFNGLGETPROGRAMLOCALPARAMETERIIVNVPROC.invoke(load("glGetProgramLocalParameterIivNV"), target, index, params);
  }

  public void glGetMinmax(int target, byte reset, int format, int type, MemorySegment values) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glFogCoordfvEXT(MemorySegment coord) {
    PFNGLFOGCOORDFVEXTPROC.invoke(load("glFogCoordfvEXT"), coord);
  }

  public void glSetFenceNV(int fence, int condition) {
    PFNGLSETFENCENVPROC.invoke(load("glSetFenceNV"), fence, condition);
  }

  public void glVertexAttribI2ivEXT(int index, MemorySegment v) {
    PFNGLVERTEXATTRIBI2IVEXTPROC.invoke(load("glVertexAttribI2ivEXT"), index, v);
  }

  public void glCompressedTexImage2D(int target, int level, int internalformat, int width, int height, int border, int imageSize, MemorySegment data) {
    PFNGLCOMPRESSEDTEXIMAGE2DPROC.invoke(load("glCompressedTexImage2D"), target, level, internalformat, width, height, border, imageSize, data);
  }

  public void glMultiTexCoord4dvARB(int target, MemorySegment v) {
    PFNGLMULTITEXCOORD4DVARBPROC.invoke(load("glMultiTexCoord4dvARB"), target, v);
  }

  public void glLoadProgramNV(int target, int id, int len, MemorySegment program) {
    PFNGLLOADPROGRAMNVPROC.invoke(load("glLoadProgramNV"), target, id, len, program);
  }

  public void glFramebufferPixelLocalStorageSizeEXT(int target, int size) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetTextureParameterIuivEXT(int texture, int target, int pname, MemorySegment params) {
    PFNGLGETTEXTUREPARAMETERIUIVEXTPROC.invoke(load("glGetTextureParameterIuivEXT"), texture, target, pname, params);
  }

  public void glDepthRangeIndexed(int index, double n, double f) {
    PFNGLDEPTHRANGEINDEXEDPROC.invoke(load("glDepthRangeIndexed"), index, n, f);
  }

  public void glConvolutionParameterfvEXT(int target, int pname, MemorySegment params) {
    PFNGLCONVOLUTIONPARAMETERFVEXTPROC.invoke(load("glConvolutionParameterfvEXT"), target, pname, params);
  }

  public void glUniform1uivEXT(int location, int count, MemorySegment value) {
    PFNGLUNIFORM1UIVEXTPROC.invoke(load("glUniform1uivEXT"), location, count, value);
  }

  public void glDeleteBuffers(int n, MemorySegment buffers) {
    PFNGLDELETEBUFFERSPROC.invoke(load("glDeleteBuffers"), n, buffers);
  }

  public void glNamedProgramLocalParameterI4iEXT(int program, int target, int index, int x, int y, int z, int w) {
    PFNGLNAMEDPROGRAMLOCALPARAMETERI4IEXTPROC.invoke(load("glNamedProgramLocalParameterI4iEXT"), program, target, index, x, y, z, w);
  }

  public void glIndexxvOES(MemorySegment component) {
    PFNGLINDEXXVOESPROC.invoke(load("glIndexxvOES"), component);
  }

  public void glTexStorage1DEXT(int target, int levels, int internalformat, int width) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glCopyTexSubImage3D(int target, int level, int xoffset, int yoffset, int zoffset, int x, int y, int width, int height) {
    PFNGLCOPYTEXSUBIMAGE3DPROC.invoke(load("glCopyTexSubImage3D"), target, level, xoffset, yoffset, zoffset, x, y, width, height);
  }

  public void glGetnSeparableFilter(int target, int format, int type, int rowBufSize, MemorySegment row, int columnBufSize, MemorySegment column, MemorySegment span) {
    PFNGLGETNSEPARABLEFILTERPROC.invoke(load("glGetnSeparableFilter"), target, format, type, rowBufSize, row, columnBufSize, column, span);
  }

  public void glNormalP3ui(int type, int coords) {
    PFNGLNORMALP3UIPROC.invoke(load("glNormalP3ui"), type, coords);
  }

  public void glCompileCommandListNV(int list) {
    PFNGLCOMPILECOMMANDLISTNVPROC.invoke(load("glCompileCommandListNV"), list);
  }

  public int glGetGraphicsResetStatusKHR() {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttrib4NivARB(int index, MemorySegment v) {
    PFNGLVERTEXATTRIB4NIVARBPROC.invoke(load("glVertexAttrib4NivARB"), index, v);
  }

  public byte glIsObjectBufferATI(int buffer) {
    return PFNGLISOBJECTBUFFERATIPROC.invoke(load("glIsObjectBufferATI"), buffer);
  }

  public void glNamedBufferAttachMemoryNV(int buffer, int memory, long offset) {
    PFNGLNAMEDBUFFERATTACHMEMORYNVPROC.invoke(load("glNamedBufferAttachMemoryNV"), buffer, memory, offset);
  }

  public void glReplacementCodeusvSUN(MemorySegment code) {
    PFNGLREPLACEMENTCODEUSVSUNPROC.invoke(load("glReplacementCodeusvSUN"), code);
  }

  public void glIglooInterfaceSGIX(int pname, MemorySegment params) {
    PFNGLIGLOOINTERFACESGIXPROC.invoke(load("glIglooInterfaceSGIX"), pname, params);
  }

  public void glReadBufferNV(int mode) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGetCombinerStageParameterfvNV(int stage, int pname, MemorySegment params) {
    PFNGLGETCOMBINERSTAGEPARAMETERFVNVPROC.invoke(load("glGetCombinerStageParameterfvNV"), stage, pname, params);
  }

  public void glDrawElementsInstancedBaseVertexBaseInstance(int mode, int count, int type, MemorySegment indices, int instancecount, int basevertex, int baseinstance) {
    PFNGLDRAWELEMENTSINSTANCEDBASEVERTEXBASEINSTANCEPROC.invoke(load("glDrawElementsInstancedBaseVertexBaseInstance"), mode, count, type, indices, instancecount, basevertex, baseinstance);
  }

  public void glGenerateMipmapEXT(int target) {
    PFNGLGENERATEMIPMAPEXTPROC.invoke(load("glGenerateMipmapEXT"), target);
  }

  public void glVertexArrayEdgeFlagOffsetEXT(int vaobj, int buffer, int stride, long offset) {
    PFNGLVERTEXARRAYEDGEFLAGOFFSETEXTPROC.invoke(load("glVertexArrayEdgeFlagOffsetEXT"), vaobj, buffer, stride, offset);
  }

  public void glDrawRangeElementsEXT(int mode, int start, int end, int count, int type, MemorySegment indices) {
    PFNGLDRAWRANGEELEMENTSEXTPROC.invoke(load("glDrawRangeElementsEXT"), mode, start, end, count, type, indices);
  }

  public void glProgramUniform4iv(int program, int location, int count, MemorySegment value) {
    PFNGLPROGRAMUNIFORM4IVPROC.invoke(load("glProgramUniform4iv"), program, location, count, value);
  }

  public void glVertexAttribI4ubv(int index, MemorySegment v) {
    PFNGLVERTEXATTRIBI4UBVPROC.invoke(load("glVertexAttribI4ubv"), index, v);
  }

  public byte glIsFramebufferOES(int framebuffer) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glDrawTexsvOES(MemorySegment coords) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glStencilFuncSeparate(int face, int func, int ref, int mask) {
    PFNGLSTENCILFUNCSEPARATEPROC.invoke(load("glStencilFuncSeparate"), face, func, ref, mask);
  }

  public void glVertexAttribs1hvNV(int index, int n, MemorySegment v) {
    PFNGLVERTEXATTRIBS1HVNVPROC.invoke(load("glVertexAttribs1hvNV"), index, n, v);
  }

  public void glGetProgramEnvParameterdvARB(int target, int index, MemorySegment params) {
    PFNGLGETPROGRAMENVPARAMETERDVARBPROC.invoke(load("glGetProgramEnvParameterdvARB"), target, index, params);
  }

  public int glCheckNamedFramebufferStatusEXT(int framebuffer, int target) {
    return PFNGLCHECKNAMEDFRAMEBUFFERSTATUSEXTPROC.invoke(load("glCheckNamedFramebufferStatusEXT"), framebuffer, target);
  }

  public void glGetInteger64i_v(int target, int index, MemorySegment data) {
    PFNGLGETINTEGER64I_VPROC.invoke(load("glGetInteger64i_v"), target, index, data);
  }

  public void glVertexAttribs1svNV(int index, int count, MemorySegment v) {
    PFNGLVERTEXATTRIBS1SVNVPROC.invoke(load("glVertexAttribs1svNV"), index, count, v);
  }

  public void glClearTexSubImageEXT(int texture, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int format, int type, MemorySegment data) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glReplacementCodeuiColor4ubVertex3fSUN(int rc, byte r, byte g, byte b, byte a, float x, float y, float z) {
    PFNGLREPLACEMENTCODEUICOLOR4UBVERTEX3FSUNPROC.invoke(load("glReplacementCodeuiColor4ubVertex3fSUN"), rc, r, g, b, a, x, y, z);
  }

  public void glGetTextureLevelParameteriv(int texture, int level, int pname, MemorySegment params) {
    PFNGLGETTEXTURELEVELPARAMETERIVPROC.invoke(load("glGetTextureLevelParameteriv"), texture, level, pname, params);
  }

  public void glTexPageCommitmentMemNV(int target, int layer, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int memory, long offset, byte commit) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glGenProgramPipelinesEXT(int n, MemorySegment pipelines) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glPixelStorex(int pname, int param) {
    PFNGLPIXELSTOREXPROC.invoke(load("glPixelStorex"), pname, param);
  }

  public void glRotatexOES(int angle, int x, int y, int z) {
    PFNGLROTATEXOESPROC.invoke(load("glRotatexOES"), angle, x, y, z);
  }

  public void glProgramUniform4fv(int program, int location, int count, MemorySegment value) {
    PFNGLPROGRAMUNIFORM4FVPROC.invoke(load("glProgramUniform4fv"), program, location, count, value);
  }

  public void glSecondaryColor3sv(MemorySegment v) {
    PFNGLSECONDARYCOLOR3SVPROC.invoke(load("glSecondaryColor3sv"), v);
  }

  public void glVertexAttrib1svARB(int index, MemorySegment v) {
    PFNGLVERTEXATTRIB1SVARBPROC.invoke(load("glVertexAttrib1svARB"), index, v);
  }

  public void glDrawCommandsNV(int primitiveMode, int buffer, MemorySegment indirects, MemorySegment sizes, int count) {
    PFNGLDRAWCOMMANDSNVPROC.invoke(load("glDrawCommandsNV"), primitiveMode, buffer, indirects, sizes, count);
  }

  public void glReplacementCodeuiTexCoord2fColor4fNormal3fVertex3fvSUN(MemorySegment rc, MemorySegment tc, MemorySegment c, MemorySegment n, MemorySegment v) {
    PFNGLREPLACEMENTCODEUITEXCOORD2FCOLOR4FNORMAL3FVERTEX3FVSUNPROC.invoke(load("glReplacementCodeuiTexCoord2fColor4fNormal3fVertex3fvSUN"), rc, tc, c, n, v);
  }

  public void glPathColorGenNV(int color, int genMode, int colorFormat, MemorySegment coeffs) {
    PFNGLPATHCOLORGENNVPROC.invoke(load("glPathColorGenNV"), color, genMode, colorFormat, coeffs);
  }

  public void glVertexWeightfEXT(float weight) {
    PFNGLVERTEXWEIGHTFEXTPROC.invoke(load("glVertexWeightfEXT"), weight);
  }

  public void glTexBufferEXT(int target, int internalformat, int buffer) {
    PFNGLTEXBUFFEREXTPROC.invoke(load("glTexBufferEXT"), target, internalformat, buffer);
  }

  public void glMatrixMultTransposefEXT(int mode, MemorySegment m) {
    PFNGLMATRIXMULTTRANSPOSEFEXTPROC.invoke(load("glMatrixMultTransposefEXT"), mode, m);
  }

  public void glVDPAUUnregisterSurfaceNV(long surface) {
    PFNGLVDPAUUNREGISTERSURFACENVPROC.invoke(load("glVDPAUUnregisterSurfaceNV"), surface);
  }

  public void glMultiDrawRangeElementArrayAPPLE(int mode, int start, int end, MemorySegment first, MemorySegment count, int primcount) {
    PFNGLMULTIDRAWRANGEELEMENTARRAYAPPLEPROC.invoke(load("glMultiDrawRangeElementArrayAPPLE"), mode, start, end, first, count, primcount);
  }

  public void glVertexAttribL1ui64NV(int index, long x) {
    PFNGLVERTEXATTRIBL1UI64NVPROC.invoke(load("glVertexAttribL1ui64NV"), index, x);
  }

  public int glGetUniformBufferSizeEXT(int program, int location) {
    return PFNGLGETUNIFORMBUFFERSIZEEXTPROC.invoke(load("glGetUniformBufferSizeEXT"), program, location);
  }

  public void glSecondaryColor3ivEXT(MemorySegment v) {
    PFNGLSECONDARYCOLOR3IVEXTPROC.invoke(load("glSecondaryColor3ivEXT"), v);
  }

  public void glVertex2hNV(short x, short y) {
    PFNGLVERTEX2HNVPROC.invoke(load("glVertex2hNV"), x, y);
  }

  public void glSpriteParameterivSGIX(int pname, MemorySegment params) {
    PFNGLSPRITEPARAMETERIVSGIXPROC.invoke(load("glSpriteParameterivSGIX"), pname, params);
  }

  public void glValidateProgramPipeline(int pipeline) {
    PFNGLVALIDATEPROGRAMPIPELINEPROC.invoke(load("glValidateProgramPipeline"), pipeline);
  }

  public void glGetCombinerInputParameterivNV(int stage, int portion, int variable, int pname, MemorySegment params) {
    PFNGLGETCOMBINERINPUTPARAMETERIVNVPROC.invoke(load("glGetCombinerInputParameterivNV"), stage, portion, variable, pname, params);
  }

  public void glGetProgramPipelineiv(int pipeline, int pname, MemorySegment params) {
    PFNGLGETPROGRAMPIPELINEIVPROC.invoke(load("glGetProgramPipelineiv"), pipeline, pname, params);
  }

  public void glRenderbufferStorageMultisampleCoverageNV(int target, int coverageSamples, int colorSamples, int internalformat, int width, int height) {
    PFNGLRENDERBUFFERSTORAGEMULTISAMPLECOVERAGENVPROC.invoke(load("glRenderbufferStorageMultisampleCoverageNV"), target, coverageSamples, colorSamples, internalformat, width, height);
  }

  public void glGetNamedFramebufferAttachmentParameterivEXT(int framebuffer, int attachment, int pname, MemorySegment params) {
    PFNGLGETNAMEDFRAMEBUFFERATTACHMENTPARAMETERIVEXTPROC.invoke(load("glGetNamedFramebufferAttachmentParameterivEXT"), framebuffer, attachment, pname, params);
  }

  public void glWindowPos2iMESA(int x, int y) {
    PFNGLWINDOWPOS2IMESAPROC.invoke(load("glWindowPos2iMESA"), x, y);
  }

  public void glDrawRangeElementArrayAPPLE(int mode, int start, int end, int first, int count) {
    PFNGLDRAWRANGEELEMENTARRAYAPPLEPROC.invoke(load("glDrawRangeElementArrayAPPLE"), mode, start, end, first, count);
  }

  public void glGetProgramivARB(int target, int pname, MemorySegment params) {
    PFNGLGETPROGRAMIVARBPROC.invoke(load("glGetProgramivARB"), target, pname, params);
  }

  public void glGetPointervKHR(int pname, MemorySegment params) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public int glGenVertexShadersEXT(int range) {
    return PFNGLGENVERTEXSHADERSEXTPROC.invoke(load("glGenVertexShadersEXT"), range);
  }

  public void glSecondaryColor3ub(byte red, byte green, byte blue) {
    PFNGLSECONDARYCOLOR3UBPROC.invoke(load("glSecondaryColor3ub"), red, green, blue);
  }

  public void glEvalCoord2xvOES(MemorySegment coords) {
    PFNGLEVALCOORD2XVOESPROC.invoke(load("glEvalCoord2xvOES"), coords);
  }

  public void glTextureParameterIuivEXT(int texture, int target, int pname, MemorySegment params) {
    PFNGLTEXTUREPARAMETERIUIVEXTPROC.invoke(load("glTextureParameterIuivEXT"), texture, target, pname, params);
  }

  public void glUniform2ui(int location, int v0, int v1) {
    PFNGLUNIFORM2UIPROC.invoke(load("glUniform2ui"), location, v0, v1);
  }

  public void glProgramParameteriEXT(int program, int pname, int value) {
    PFNGLPROGRAMPARAMETERIEXTPROC.invoke(load("glProgramParameteriEXT"), program, pname, value);
  }

  public void glPointSizePointerOES(int type, int stride, MemorySegment pointer) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glSecondaryColor3ui(int red, int green, int blue) {
    PFNGLSECONDARYCOLOR3UIPROC.invoke(load("glSecondaryColor3ui"), red, green, blue);
  }

  public void glBlendEquationi(int buf, int mode) {
    PFNGLBLENDEQUATIONIPROC.invoke(load("glBlendEquationi"), buf, mode);
  }

  public void glSecondaryColor3us(short red, short green, short blue) {
    PFNGLSECONDARYCOLOR3USPROC.invoke(load("glSecondaryColor3us"), red, green, blue);
  }

  public void glMaterialxv(int face, int pname, MemorySegment param) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glWindowRectanglesEXT(int mode, int count, MemorySegment box) {
    PFNGLWINDOWRECTANGLESEXTPROC.invoke(load("glWindowRectanglesEXT"), mode, count, box);
  }

  public void glVertexAttrib1fARB(int index, float x) {
    PFNGLVERTEXATTRIB1FARBPROC.invoke(load("glVertexAttrib1fARB"), index, x);
  }

  public void glGetConvolutionFilterEXT(int target, int format, int type, MemorySegment image) {
    PFNGLGETCONVOLUTIONFILTEREXTPROC.invoke(load("glGetConvolutionFilterEXT"), target, format, type, image);
  }

  public void glGetNamedProgramLocalParameterIivEXT(int program, int target, int index, MemorySegment params) {
    PFNGLGETNAMEDPROGRAMLOCALPARAMETERIIVEXTPROC.invoke(load("glGetNamedProgramLocalParameterIivEXT"), program, target, index, params);
  }

  public void glCopyTexSubImage3DEXT(int target, int level, int xoffset, int yoffset, int zoffset, int x, int y, int width, int height) {
    PFNGLCOPYTEXSUBIMAGE3DEXTPROC.invoke(load("glCopyTexSubImage3DEXT"), target, level, xoffset, yoffset, zoffset, x, y, width, height);
  }

  public void glEndConditionalRender() {
    PFNGLENDCONDITIONALRENDERPROC.invoke(load("glEndConditionalRender"));
  }

  public void glGetShadingRateSampleLocationivNV(int rate, int samples, int index, MemorySegment location) {
    PFNGLGETSHADINGRATESAMPLELOCATIONIVNVPROC.invoke(load("glGetShadingRateSampleLocationivNV"), rate, samples, index, location);
  }

  public void glGetBufferParameterui64vNV(int target, int pname, MemorySegment params) {
    PFNGLGETBUFFERPARAMETERUI64VNVPROC.invoke(load("glGetBufferParameterui64vNV"), target, pname, params);
  }

  public void glPNTrianglesfATI(int pname, float param) {
    PFNGLPNTRIANGLESFATIPROC.invoke(load("glPNTrianglesfATI"), pname, param);
  }

  public void glGetVideoCaptureStreamdvNV(int video_capture_slot, int stream, int pname, MemorySegment params) {
    PFNGLGETVIDEOCAPTURESTREAMDVNVPROC.invoke(load("glGetVideoCaptureStreamdvNV"), video_capture_slot, stream, pname, params);
  }

  public void glProgramEnvParameters4fvEXT(int target, int index, int count, MemorySegment params) {
    PFNGLPROGRAMENVPARAMETERS4FVEXTPROC.invoke(load("glProgramEnvParameters4fvEXT"), target, index, count, params);
  }

  public void glGenSamplers(int count, MemorySegment samplers) {
    PFNGLGENSAMPLERSPROC.invoke(load("glGenSamplers"), count, samplers);
  }

  public byte glIsTextureEXT(int texture) {
    return PFNGLISTEXTUREEXTPROC.invoke(load("glIsTextureEXT"), texture);
  }

  public MemorySegment glCreateSyncFromCLeventARB(MemorySegment context, MemorySegment event, int flags) {
    return PFNGLCREATESYNCFROMCLEVENTARBPROC.invoke(load("glCreateSyncFromCLeventARB"), context, event, flags);
  }

  public void glSeparableFilter2DEXT(int target, int internalformat, int width, int height, int format, int type, MemorySegment row, MemorySegment column) {
    PFNGLSEPARABLEFILTER2DEXTPROC.invoke(load("glSeparableFilter2DEXT"), target, internalformat, width, height, format, type, row, column);
  }

  public void glDebugMessageCallback(MemorySegment callback, MemorySegment userParam) {
    PFNGLDEBUGMESSAGECALLBACKPROC.invoke(load("glDebugMessageCallback"), callback, userParam);
  }

  public void glFramebufferTextureARB(int target, int attachment, int texture, int level) {
    PFNGLFRAMEBUFFERTEXTUREARBPROC.invoke(load("glFramebufferTextureARB"), target, attachment, texture, level);
  }

  public void glSecondaryColorPointer(int size, int type, int stride, MemorySegment pointer) {
    PFNGLSECONDARYCOLORPOINTERPROC.invoke(load("glSecondaryColorPointer"), size, type, stride, pointer);
  }

  public void glAlphaFragmentOp2ATI(int op, int dst, int dstMod, int arg1, int arg1Rep, int arg1Mod, int arg2, int arg2Rep, int arg2Mod) {
    PFNGLALPHAFRAGMENTOP2ATIPROC.invoke(load("glAlphaFragmentOp2ATI"), op, dst, dstMod, arg1, arg1Rep, arg1Mod, arg2, arg2Rep, arg2Mod);
  }

  public void glProgramUniform4ui64ARB(int program, int location, long x, long y, long z, long w) {
    PFNGLPROGRAMUNIFORM4UI64ARBPROC.invoke(load("glProgramUniform4ui64ARB"), program, location, x, y, z, w);
  }

  public void glMultiTexParameteriEXT(int texunit, int target, int pname, int param) {
    PFNGLMULTITEXPARAMETERIEXTPROC.invoke(load("glMultiTexParameteriEXT"), texunit, target, pname, param);
  }

  public void glGetQueryObjecti64vEXT(int id, int pname, MemorySegment params) {
    PFNGLGETQUERYOBJECTI64VEXTPROC.invoke(load("glGetQueryObjecti64vEXT"), id, pname, params);
  }

  public void glCompressedTextureImage1DEXT(int texture, int target, int level, int internalformat, int width, int border, int imageSize, MemorySegment bits) {
    PFNGLCOMPRESSEDTEXTUREIMAGE1DEXTPROC.invoke(load("glCompressedTextureImage1DEXT"), texture, target, level, internalformat, width, border, imageSize, bits);
  }

  public void glFogCoordPointer(int type, int stride, MemorySegment pointer) {
    PFNGLFOGCOORDPOINTERPROC.invoke(load("glFogCoordPointer"), type, stride, pointer);
  }

  public void glWindowPos4sMESA(short x, short y, short z, short w) {
    PFNGLWINDOWPOS4SMESAPROC.invoke(load("glWindowPos4sMESA"), x, y, z, w);
  }

  public void glProgramUniform2iEXT(int program, int location, int v0, int v1) {
    PFNGLPROGRAMUNIFORM2IEXTPROC.invoke(load("glProgramUniform2iEXT"), program, location, v0, v1);
  }

  public void glTexCoord2fNormal3fVertex3fvSUN(MemorySegment tc, MemorySegment n, MemorySegment v) {
    PFNGLTEXCOORD2FNORMAL3FVERTEX3FVSUNPROC.invoke(load("glTexCoord2fNormal3fVertex3fvSUN"), tc, n, v);
  }

  public void glFramebufferTextureMultiviewOVR(int target, int attachment, int texture, int level, int baseViewIndex, int numViews) {
    PFNGLFRAMEBUFFERTEXTUREMULTIVIEWOVRPROC.invoke(load("glFramebufferTextureMultiviewOVR"), target, attachment, texture, level, baseViewIndex, numViews);
  }

  public void glInsertComponentEXT(int res, int src, int num) {
    PFNGLINSERTCOMPONENTEXTPROC.invoke(load("glInsertComponentEXT"), res, src, num);
  }

  public void glTexturePageCommitmentMemNV(int texture, int layer, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int memory, long offset, byte commit) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glPushDebugGroupKHR(int source, int id, int length, MemorySegment message) {
    throw new RuntimeException("This method is not available in the generated binding.");
  }

  public void glVertexAttribIPointer(int index, int size, int type, int stride, MemorySegment pointer) {
    PFNGLVERTEXATTRIBIPOINTERPROC.invoke(load("glVertexAttribIPointer"), index, size, type, stride, pointer);
  }

  public void glGetTransformFeedbackVaryingNV(int program, int index, MemorySegment location) {
    PFNGLGETTRANSFORMFEEDBACKVARYINGNVPROC.invoke(load("glGetTransformFeedbackVaryingNV"), program, index, location);
  }

  public void glDepthBoundsdNV(double zmin, double zmax) {
    PFNGLDEPTHBOUNDSDNVPROC.invoke(load("glDepthBoundsdNV"), zmin, zmax);
  }

  public void glVertexStream1dvATI(int stream, MemorySegment coords) {
    PFNGLVERTEXSTREAM1DVATIPROC.invoke(load("glVertexStream1dvATI"), stream, coords);
  }

  public void glFramebufferRenderbuffer(int target, int attachment, int renderbuffertarget, int renderbuffer) {
    PFNGLFRAMEBUFFERRENDERBUFFERPROC.invoke(load("glFramebufferRenderbuffer"), target, attachment, renderbuffertarget, renderbuffer);
  }

  public void glClearAccumxOES(int red, int green, int blue, int alpha) {
    PFNGLCLEARACCUMXOESPROC.invoke(load("glClearAccumxOES"), red, green, blue, alpha);
  }

  public void glVariantuivEXT(int id, MemorySegment addr) {
    PFNGLVARIANTUIVEXTPROC.invoke(load("glVariantuivEXT"), id, addr);
  }

  public void glCombinerStageParameterfvNV(int stage, int pname, MemorySegment params) {
    PFNGLCOMBINERSTAGEPARAMETERFVNVPROC.invoke(load("glCombinerStageParameterfvNV"), stage, pname, params);
  }

  public byte glAreProgramsResidentNV(int n, MemorySegment programs, MemorySegment residences) {
    return PFNGLAREPROGRAMSRESIDENTNVPROC.invoke(load("glAreProgramsResidentNV"), n, programs, residences);
  }

  public void glActiveTexture(int texture) {
    PFNGLACTIVETEXTUREPROC.invoke(load("glActiveTexture"), texture);
  }

  public void glVertexAttribFormat(int attribindex, int size, int type, byte normalized, int relativeoffset) {
    PFNGLVERTEXATTRIBFORMATPROC.invoke(load("glVertexAttribFormat"), attribindex, size, type, normalized, relativeoffset);
  }

  public void glVertexAttrib2sARB(int index, short x, short y) {
    PFNGLVERTEXATTRIB2SARBPROC.invoke(load("glVertexAttrib2sARB"), index, x, y);
  }

  public int glBindMaterialParameterEXT(int face, int value) {
    return PFNGLBINDMATERIALPARAMETEREXTPROC.invoke(load("glBindMaterialParameterEXT"), face, value);
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
