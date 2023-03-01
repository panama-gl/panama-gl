package panamagl.platform.macos.x86; 

import opengl.macos.v10_15_7.glut_h;
import static opengl.macos.v10_15_7.glut_h.*;
import java.lang.foreign.*;

public class GL_macOS_x86 extends panamagl.opengl.AGL implements panamagl.opengl.GL, panamagl.opengl.GLU, panamagl.opengl.GLUT {
  public void glAccum(int op, float value) {
    glut_h.glAccum(op, value);
  }

  public void glActiveStencilFaceEXT(int face) {
    glut_h.glActiveStencilFaceEXT(face);
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

  public void glAttachObjectARB(Addressable containerObj, Addressable obj) {
    glut_h.glAttachObjectARB(containerObj, obj);
  }

  public void glAttachShader(int program, int shader) {
    glut_h.glAttachShader(program, shader);
  }

  public void glBegin(int mode) {
    glut_h.glBegin(mode);
  }

  public void glBeginConditionalRenderNV(int id, int mode) {
    glut_h.glBeginConditionalRenderNV(id, mode);
  }

  public void glBeginQuery(int target, int id) {
    glut_h.glBeginQuery(target, id);
  }

  public void glBeginQueryARB(int target, int id) {
    glut_h.glBeginQueryARB(target, id);
  }

  public void glBeginTransformFeedbackEXT(int primitiveMode) {
    glut_h.glBeginTransformFeedbackEXT(primitiveMode);
  }

  public void glBindAttribLocation(int program, int index, Addressable name) {
    glut_h.glBindAttribLocation(program, index, name);
  }

  public void glBindAttribLocationARB(Addressable programObj, int index, Addressable name) {
    glut_h.glBindAttribLocationARB(programObj, index, name);
  }

  public void glBindBuffer(int target, int buffer) {
    glut_h.glBindBuffer(target, buffer);
  }

  public void glBindBufferARB(int target, int buffer) {
    glut_h.glBindBufferARB(target, buffer);
  }

  public void glBindBufferBaseEXT(int target, int index, int buffer) {
    glut_h.glBindBufferBaseEXT(target, index, buffer);
  }

  public void glBindBufferOffsetEXT(int target, int index, int buffer, long offset) {
    glut_h.glBindBufferOffsetEXT(target, index, buffer, offset);
  }

  public void glBindBufferRangeEXT(int target, int index, int buffer, long offset, long size) {
    glut_h.glBindBufferRangeEXT(target, index, buffer, offset, size);
  }

  public void glBindFragDataLocationEXT(int program, int color, Addressable name) {
    glut_h.glBindFragDataLocationEXT(program, color, name);
  }

  public void glBindFramebuffer(int target, int framebuffer) {
    glut_h.glBindFramebuffer(target, framebuffer);
  }

  public void glBindFramebufferEXT(int target, int framebuffer) {
    glut_h.glBindFramebufferEXT(target, framebuffer);
  }

  public void glBindProgramARB(int target, int program) {
    glut_h.glBindProgramARB(target, program);
  }

  public void glBindRenderbuffer(int target, int renderbuffer) {
    glut_h.glBindRenderbuffer(target, renderbuffer);
  }

  public void glBindRenderbufferEXT(int target, int renderbuffer) {
    glut_h.glBindRenderbufferEXT(target, renderbuffer);
  }

  public void glBindTexture(int target, int texture) {
    glut_h.glBindTexture(target, texture);
  }

  public void glBindVertexArrayAPPLE(int array) {
    glut_h.glBindVertexArrayAPPLE(array);
  }

  public void glBitmap(int width, int height, float xorig, float yorig, float xmove, float ymove, Addressable bitmap) {
    glut_h.glBitmap(width, height, xorig, yorig, xmove, ymove, bitmap);
  }

  public void glBlendColor(float red, float green, float blue, float alpha) {
    glut_h.glBlendColor(red, green, blue, alpha);
  }

  public void glBlendColorEXT(float red, float green, float blue, float alpha) {
    glut_h.glBlendColorEXT(red, green, blue, alpha);
  }

  public void glBlendEquation(int mode) {
    glut_h.glBlendEquation(mode);
  }

  public void glBlendEquationEXT(int mode) {
    glut_h.glBlendEquationEXT(mode);
  }

  public void glBlendEquationSeparate(int modeRGB, int modeAlpha) {
    glut_h.glBlendEquationSeparate(modeRGB, modeAlpha);
  }

  public void glBlendEquationSeparateEXT(int modeRGB, int modeAlpha) {
    glut_h.glBlendEquationSeparateEXT(modeRGB, modeAlpha);
  }

  public void glBlendFunc(int sfactor, int dfactor) {
    glut_h.glBlendFunc(sfactor, dfactor);
  }

  public void glBlendFuncSeparate(int sfactorRGB, int dfactorRGB, int sfactorAlpha, int dfactorAlpha) {
    glut_h.glBlendFuncSeparate(sfactorRGB, dfactorRGB, sfactorAlpha, dfactorAlpha);
  }

  public void glBlendFuncSeparateEXT(int sfactorRGB, int dfactorRGB, int sfactorAlpha, int dfactorAlpha) {
    glut_h.glBlendFuncSeparateEXT(sfactorRGB, dfactorRGB, sfactorAlpha, dfactorAlpha);
  }

  public void glBlitFramebuffer(int srcX0, int srcY0, int srcX1, int srcY1, int dstX0, int dstY0, int dstX1, int dstY1, int mask, int filter) {
    glut_h.glBlitFramebuffer(srcX0, srcY0, srcX1, srcY1, dstX0, dstY0, dstX1, dstY1, mask, filter);
  }

  public void glBlitFramebufferEXT(int srcX0, int srcY0, int srcX1, int srcY1, int dstX0, int dstY0, int dstX1, int dstY1, int mask, int filter) {
    glut_h.glBlitFramebufferEXT(srcX0, srcY0, srcX1, srcY1, dstX0, dstY0, dstX1, dstY1, mask, filter);
  }

  public void glBufferData(int target, long size, Addressable data, int usage) {
    glut_h.glBufferData(target, size, data, usage);
  }

  public void glBufferDataARB(int target, long size, Addressable data, int usage) {
    glut_h.glBufferDataARB(target, size, data, usage);
  }

  public void glBufferParameteriAPPLE(int target, int pname, int param) {
    glut_h.glBufferParameteriAPPLE(target, pname, param);
  }

  public void glBufferSubData(int target, long offset, long size, Addressable data) {
    glut_h.glBufferSubData(target, offset, size, data);
  }

  public void glBufferSubDataARB(int target, long offset, long size, Addressable data) {
    glut_h.glBufferSubDataARB(target, offset, size, data);
  }

  public void glCallList(int list) {
    glut_h.glCallList(list);
  }

  public void glCallLists(int n, int type, Addressable lists) {
    glut_h.glCallLists(n, type, lists);
  }

  public int glCheckFramebufferStatus(int target) {
    return glut_h.glCheckFramebufferStatus(target);
  }

  public int glCheckFramebufferStatusEXT(int target) {
    return glut_h.glCheckFramebufferStatusEXT(target);
  }

  public void glClampColorARB(int target, int clamp) {
    glut_h.glClampColorARB(target, clamp);
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

  public void glClearColorIiEXT(int red, int green, int blue, int alpha) {
    glut_h.glClearColorIiEXT(red, green, blue, alpha);
  }

  public void glClearColorIuiEXT(int red, int green, int blue, int alpha) {
    glut_h.glClearColorIuiEXT(red, green, blue, alpha);
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

  public int glClientWaitSync(Addressable sync, int flags, long timeout) {
    return glut_h.glClientWaitSync(sync, flags, timeout);
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

  public void glColorMaskIndexedEXT(int index, byte r, byte g, byte b, byte a) {
    glut_h.glColorMaskIndexedEXT(index, r, g, b, a);
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

  public void glCompileShader(int shader) {
    glut_h.glCompileShader(shader);
  }

  public void glCompileShaderARB(Addressable shaderObj) {
    glut_h.glCompileShaderARB(shaderObj);
  }

  public void glCompressedTexImage1D(int target, int level, int internalformat, int width, int border, int imageSize, Addressable data) {
    glut_h.glCompressedTexImage1D(target, level, internalformat, width, border, imageSize, data);
  }

  public void glCompressedTexImage1DARB(int target, int level, int internalformat, int width, int border, int imageSize, Addressable data) {
    glut_h.glCompressedTexImage1DARB(target, level, internalformat, width, border, imageSize, data);
  }

  public void glCompressedTexImage2D(int target, int level, int internalformat, int width, int height, int border, int imageSize, Addressable data) {
    glut_h.glCompressedTexImage2D(target, level, internalformat, width, height, border, imageSize, data);
  }

  public void glCompressedTexImage2DARB(int target, int level, int internalformat, int width, int height, int border, int imageSize, Addressable data) {
    glut_h.glCompressedTexImage2DARB(target, level, internalformat, width, height, border, imageSize, data);
  }

  public void glCompressedTexImage3D(int target, int level, int internalformat, int width, int height, int depth, int border, int imageSize, Addressable data) {
    glut_h.glCompressedTexImage3D(target, level, internalformat, width, height, depth, border, imageSize, data);
  }

  public void glCompressedTexImage3DARB(int target, int level, int internalformat, int width, int height, int depth, int border, int imageSize, Addressable data) {
    glut_h.glCompressedTexImage3DARB(target, level, internalformat, width, height, depth, border, imageSize, data);
  }

  public void glCompressedTexSubImage1D(int target, int level, int xoffset, int width, int format, int imageSize, Addressable data) {
    glut_h.glCompressedTexSubImage1D(target, level, xoffset, width, format, imageSize, data);
  }

  public void glCompressedTexSubImage1DARB(int target, int level, int xoffset, int width, int format, int imageSize, Addressable data) {
    glut_h.glCompressedTexSubImage1DARB(target, level, xoffset, width, format, imageSize, data);
  }

  public void glCompressedTexSubImage2D(int target, int level, int xoffset, int yoffset, int width, int height, int format, int imageSize, Addressable data) {
    glut_h.glCompressedTexSubImage2D(target, level, xoffset, yoffset, width, height, format, imageSize, data);
  }

  public void glCompressedTexSubImage2DARB(int target, int level, int xoffset, int yoffset, int width, int height, int format, int imageSize, Addressable data) {
    glut_h.glCompressedTexSubImage2DARB(target, level, xoffset, yoffset, width, height, format, imageSize, data);
  }

  public void glCompressedTexSubImage3D(int target, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int format, int imageSize, Addressable data) {
    glut_h.glCompressedTexSubImage3D(target, level, xoffset, yoffset, zoffset, width, height, depth, format, imageSize, data);
  }

  public void glCompressedTexSubImage3DARB(int target, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int format, int imageSize, Addressable data) {
    glut_h.glCompressedTexSubImage3DARB(target, level, xoffset, yoffset, zoffset, width, height, depth, format, imageSize, data);
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

  public int glCreateProgram() {
    return glut_h.glCreateProgram();
  }

  public MemoryAddress glCreateProgramObjectARB() {
    return glut_h.glCreateProgramObjectARB();
  }

  public int glCreateShader(int type) {
    return glut_h.glCreateShader(type);
  }

  public MemoryAddress glCreateShaderObjectARB(int shaderType) {
    return glut_h.glCreateShaderObjectARB(shaderType);
  }

  public void glCullFace(int mode) {
    glut_h.glCullFace(mode);
  }

  public void glDeleteBuffers(int n, Addressable buffers) {
    glut_h.glDeleteBuffers(n, buffers);
  }

  public void glDeleteBuffersARB(int n, Addressable buffers) {
    glut_h.glDeleteBuffersARB(n, buffers);
  }

  public void glDeleteFencesAPPLE(int n, Addressable fences) {
    glut_h.glDeleteFencesAPPLE(n, fences);
  }

  public void glDeleteFramebuffers(int n, Addressable framebuffers) {
    glut_h.glDeleteFramebuffers(n, framebuffers);
  }

  public void glDeleteFramebuffersEXT(int n, Addressable framebuffers) {
    glut_h.glDeleteFramebuffersEXT(n, framebuffers);
  }

  public void glDeleteLists(int list, int range) {
    glut_h.glDeleteLists(list, range);
  }

  public void glDeleteObjectARB(Addressable obj) {
    glut_h.glDeleteObjectARB(obj);
  }

  public void glDeleteProgram(int program) {
    glut_h.glDeleteProgram(program);
  }

  public void glDeleteProgramsARB(int n, Addressable programs) {
    glut_h.glDeleteProgramsARB(n, programs);
  }

  public void glDeleteQueries(int n, Addressable ids) {
    glut_h.glDeleteQueries(n, ids);
  }

  public void glDeleteQueriesARB(int n, Addressable ids) {
    glut_h.glDeleteQueriesARB(n, ids);
  }

  public void glDeleteRenderbuffers(int n, Addressable renderbuffers) {
    glut_h.glDeleteRenderbuffers(n, renderbuffers);
  }

  public void glDeleteRenderbuffersEXT(int n, Addressable renderbuffers) {
    glut_h.glDeleteRenderbuffersEXT(n, renderbuffers);
  }

  public void glDeleteShader(int shader) {
    glut_h.glDeleteShader(shader);
  }

  public void glDeleteSync(Addressable sync) {
    glut_h.glDeleteSync(sync);
  }

  public void glDeleteTextures(int n, Addressable textures) {
    glut_h.glDeleteTextures(n, textures);
  }

  public void glDeleteVertexArraysAPPLE(int n, Addressable arrays) {
    glut_h.glDeleteVertexArraysAPPLE(n, arrays);
  }

  public void glDepthBoundsEXT(double zmin, double zmax) {
    glut_h.glDepthBoundsEXT(zmin, zmax);
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

  public void glDetachObjectARB(Addressable containerObj, Addressable attachedObj) {
    glut_h.glDetachObjectARB(containerObj, attachedObj);
  }

  public void glDetachShader(int program, int shader) {
    glut_h.glDetachShader(program, shader);
  }

  public void glDisable(int cap) {
    glut_h.glDisable(cap);
  }

  public void glDisableClientState(int array) {
    glut_h.glDisableClientState(array);
  }

  public void glDisableIndexedEXT(int target, int index) {
    glut_h.glDisableIndexedEXT(target, index);
  }

  public void glDisableVertexAttribAPPLE(int index, int pname) {
    glut_h.glDisableVertexAttribAPPLE(index, pname);
  }

  public void glDisableVertexAttribArray(int index) {
    glut_h.glDisableVertexAttribArray(index);
  }

  public void glDisableVertexAttribArrayARB(int index) {
    glut_h.glDisableVertexAttribArrayARB(index);
  }

  public void glDrawArrays(int mode, int first, int count) {
    glut_h.glDrawArrays(mode, first, count);
  }

  public void glDrawArraysInstancedARB(int mode, int first, int count, int primcount) {
    glut_h.glDrawArraysInstancedARB(mode, first, count, primcount);
  }

  public void glDrawBuffer(int buf) {
    glut_h.glDrawBuffer(buf);
  }

  public void glDrawBuffers(int n, Addressable bufs) {
    glut_h.glDrawBuffers(n, bufs);
  }

  public void glDrawBuffersARB(int n, Addressable bufs) {
    glut_h.glDrawBuffersARB(n, bufs);
  }

  public void glDrawElementArrayAPPLE(int mode, int first, int count) {
    glut_h.glDrawElementArrayAPPLE(mode, first, count);
  }

  public void glDrawElements(int mode, int count, int type, Addressable indices) {
    glut_h.glDrawElements(mode, count, type, indices);
  }

  public void glDrawElementsBaseVertex(int mode, int count, int type, Addressable indices, int basevertex) {
    glut_h.glDrawElementsBaseVertex(mode, count, type, indices, basevertex);
  }

  public void glDrawElementsInstancedARB(int mode, int count, int type, Addressable indices, int primcount) {
    glut_h.glDrawElementsInstancedARB(mode, count, type, indices, primcount);
  }

  public void glDrawElementsInstancedBaseVertex(int mode, int count, int type, Addressable indices, int instancecount, int basevertex) {
    glut_h.glDrawElementsInstancedBaseVertex(mode, count, type, indices, instancecount, basevertex);
  }

  public void glDrawPixels(int width, int height, int format, int type, Addressable pixels) {
    glut_h.glDrawPixels(width, height, format, type, pixels);
  }

  public void glDrawRangeElementArrayAPPLE(int mode, int start, int end, int first, int count) {
    glut_h.glDrawRangeElementArrayAPPLE(mode, start, end, first, count);
  }

  public void glDrawRangeElements(int mode, int start, int end, int count, int type, Addressable indices) {
    glut_h.glDrawRangeElements(mode, start, end, count, type, indices);
  }

  public void glDrawRangeElementsBaseVertex(int mode, int start, int end, int count, int type, Addressable indices, int basevertex) {
    glut_h.glDrawRangeElementsBaseVertex(mode, start, end, count, type, indices, basevertex);
  }

  public void glDrawRangeElementsEXT(int mode, int start, int end, int count, int type, Addressable indices) {
    glut_h.glDrawRangeElementsEXT(mode, start, end, count, type, indices);
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

  public void glElementPointerAPPLE(int type, Addressable pointer) {
    glut_h.glElementPointerAPPLE(type, pointer);
  }

  public void glEnable(int cap) {
    glut_h.glEnable(cap);
  }

  public void glEnableClientState(int array) {
    glut_h.glEnableClientState(array);
  }

  public void glEnableIndexedEXT(int target, int index) {
    glut_h.glEnableIndexedEXT(target, index);
  }

  public void glEnableVertexAttribAPPLE(int index, int pname) {
    glut_h.glEnableVertexAttribAPPLE(index, pname);
  }

  public void glEnableVertexAttribArray(int index) {
    glut_h.glEnableVertexAttribArray(index);
  }

  public void glEnableVertexAttribArrayARB(int index) {
    glut_h.glEnableVertexAttribArrayARB(index);
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

  public void glEndQuery(int target) {
    glut_h.glEndQuery(target);
  }

  public void glEndQueryARB(int target) {
    glut_h.glEndQueryARB(target);
  }

  public void glEndTransformFeedbackEXT() {
    glut_h.glEndTransformFeedbackEXT();
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

  public MemoryAddress glFenceSync(int condition, int flags) {
    return glut_h.glFenceSync(condition, flags);
  }

  public void glFinish() {
    glut_h.glFinish();
  }

  public void glFinishFenceAPPLE(int fence) {
    glut_h.glFinishFenceAPPLE(fence);
  }

  public void glFinishObjectAPPLE(int object, int name) {
    glut_h.glFinishObjectAPPLE(object, name);
  }

  public void glFlush() {
    glut_h.glFlush();
  }

  public void glFlushMappedBufferRangeAPPLE(int target, long offset, long size) {
    glut_h.glFlushMappedBufferRangeAPPLE(target, offset, size);
  }

  public void glFlushVertexArrayRangeAPPLE(int length, Addressable pointer) {
    glut_h.glFlushVertexArrayRangeAPPLE(length, pointer);
  }

  public void glFogCoordPointer(int type, int stride, Addressable pointer) {
    glut_h.glFogCoordPointer(type, stride, pointer);
  }

  public void glFogCoordPointerEXT(int type, int stride, Addressable pointer) {
    glut_h.glFogCoordPointerEXT(type, stride, pointer);
  }

  public void glFogCoordd(double coord) {
    glut_h.glFogCoordd(coord);
  }

  public void glFogCoorddEXT(double coord) {
    glut_h.glFogCoorddEXT(coord);
  }

  public void glFogCoorddv(Addressable coord) {
    glut_h.glFogCoorddv(coord);
  }

  public void glFogCoorddvEXT(Addressable coord) {
    glut_h.glFogCoorddvEXT(coord);
  }

  public void glFogCoordf(float coord) {
    glut_h.glFogCoordf(coord);
  }

  public void glFogCoordfEXT(float coord) {
    glut_h.glFogCoordfEXT(coord);
  }

  public void glFogCoordfv(Addressable coord) {
    glut_h.glFogCoordfv(coord);
  }

  public void glFogCoordfvEXT(Addressable coord) {
    glut_h.glFogCoordfvEXT(coord);
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

  public void glFramebufferRenderbuffer(int target, int attachment, int renderbuffertarget, int renderbuffer) {
    glut_h.glFramebufferRenderbuffer(target, attachment, renderbuffertarget, renderbuffer);
  }

  public void glFramebufferRenderbufferEXT(int target, int attachment, int renderbuffertarget, int renderbuffer) {
    glut_h.glFramebufferRenderbufferEXT(target, attachment, renderbuffertarget, renderbuffer);
  }

  public void glFramebufferTexture1D(int target, int attachment, int textarget, int texture, int level) {
    glut_h.glFramebufferTexture1D(target, attachment, textarget, texture, level);
  }

  public void glFramebufferTexture1DEXT(int target, int attachment, int textarget, int texture, int level) {
    glut_h.glFramebufferTexture1DEXT(target, attachment, textarget, texture, level);
  }

  public void glFramebufferTexture2D(int target, int attachment, int textarget, int texture, int level) {
    glut_h.glFramebufferTexture2D(target, attachment, textarget, texture, level);
  }

  public void glFramebufferTexture2DEXT(int target, int attachment, int textarget, int texture, int level) {
    glut_h.glFramebufferTexture2DEXT(target, attachment, textarget, texture, level);
  }

  public void glFramebufferTexture3D(int target, int attachment, int textarget, int texture, int level, int zoffset) {
    glut_h.glFramebufferTexture3D(target, attachment, textarget, texture, level, zoffset);
  }

  public void glFramebufferTexture3DEXT(int target, int attachment, int textarget, int texture, int level, int zoffset) {
    glut_h.glFramebufferTexture3DEXT(target, attachment, textarget, texture, level, zoffset);
  }

  public void glFramebufferTextureEXT(int target, int attachment, int texture, int level) {
    glut_h.glFramebufferTextureEXT(target, attachment, texture, level);
  }

  public void glFramebufferTextureFaceEXT(int target, int attachment, int texture, int level, int face) {
    glut_h.glFramebufferTextureFaceEXT(target, attachment, texture, level, face);
  }

  public void glFramebufferTextureLayer(int target, int attachment, int texture, int level, int layer) {
    glut_h.glFramebufferTextureLayer(target, attachment, texture, level, layer);
  }

  public void glFramebufferTextureLayerEXT(int target, int attachment, int texture, int level, int layer) {
    glut_h.glFramebufferTextureLayerEXT(target, attachment, texture, level, layer);
  }

  public void glFrontFace(int mode) {
    glut_h.glFrontFace(mode);
  }

  public void glFrustum(double left, double right, double bottom, double top, double zNear, double zFar) {
    glut_h.glFrustum(left, right, bottom, top, zNear, zFar);
  }

  public void glGenBuffers(int n, Addressable buffers) {
    glut_h.glGenBuffers(n, buffers);
  }

  public void glGenBuffersARB(int n, Addressable buffers) {
    glut_h.glGenBuffersARB(n, buffers);
  }

  public void glGenFencesAPPLE(int n, Addressable fences) {
    glut_h.glGenFencesAPPLE(n, fences);
  }

  public void glGenFramebuffers(int n, Addressable framebuffers) {
    glut_h.glGenFramebuffers(n, framebuffers);
  }

  public void glGenFramebuffersEXT(int n, Addressable framebuffers) {
    glut_h.glGenFramebuffersEXT(n, framebuffers);
  }

  public int glGenLists(int range) {
    return glut_h.glGenLists(range);
  }

  public void glGenProgramsARB(int n, Addressable programs) {
    glut_h.glGenProgramsARB(n, programs);
  }

  public void glGenQueries(int n, Addressable ids) {
    glut_h.glGenQueries(n, ids);
  }

  public void glGenQueriesARB(int n, Addressable ids) {
    glut_h.glGenQueriesARB(n, ids);
  }

  public void glGenRenderbuffers(int n, Addressable renderbuffers) {
    glut_h.glGenRenderbuffers(n, renderbuffers);
  }

  public void glGenRenderbuffersEXT(int n, Addressable renderbuffers) {
    glut_h.glGenRenderbuffersEXT(n, renderbuffers);
  }

  public void glGenTextures(int n, Addressable textures) {
    glut_h.glGenTextures(n, textures);
  }

  public void glGenVertexArraysAPPLE(int n, Addressable arrays) {
    glut_h.glGenVertexArraysAPPLE(n, arrays);
  }

  public void glGenerateMipmap(int target) {
    glut_h.glGenerateMipmap(target);
  }

  public void glGenerateMipmapEXT(int target) {
    glut_h.glGenerateMipmapEXT(target);
  }

  public void glGetActiveAttrib(int program, int index, int bufSize, Addressable length, Addressable size, Addressable type, Addressable name) {
    glut_h.glGetActiveAttrib(program, index, bufSize, length, size, type, name);
  }

  public void glGetActiveAttribARB(Addressable programObj, int index, int maxLength, Addressable length, Addressable size, Addressable type, Addressable name) {
    glut_h.glGetActiveAttribARB(programObj, index, maxLength, length, size, type, name);
  }

  public void glGetActiveUniform(int program, int index, int bufSize, Addressable length, Addressable size, Addressable type, Addressable name) {
    glut_h.glGetActiveUniform(program, index, bufSize, length, size, type, name);
  }

  public void glGetActiveUniformARB(Addressable programObj, int index, int maxLength, Addressable length, Addressable size, Addressable type, Addressable name) {
    glut_h.glGetActiveUniformARB(programObj, index, maxLength, length, size, type, name);
  }

  public void glGetAttachedObjectsARB(Addressable containerObj, int maxCount, Addressable count, Addressable obj) {
    glut_h.glGetAttachedObjectsARB(containerObj, maxCount, count, obj);
  }

  public void glGetAttachedShaders(int program, int maxCount, Addressable count, Addressable shaders) {
    glut_h.glGetAttachedShaders(program, maxCount, count, shaders);
  }

  public int glGetAttribLocation(int program, Addressable name) {
    return glut_h.glGetAttribLocation(program, name);
  }

  public int glGetAttribLocationARB(Addressable programObj, Addressable name) {
    return glut_h.glGetAttribLocationARB(programObj, name);
  }

  public void glGetBooleanIndexedvEXT(int target, int index, Addressable data) {
    glut_h.glGetBooleanIndexedvEXT(target, index, data);
  }

  public void glGetBooleanv(int pname, Addressable data) {
    glut_h.glGetBooleanv(pname, data);
  }

  public void glGetBufferParameteriv(int target, int pname, Addressable params) {
    glut_h.glGetBufferParameteriv(target, pname, params);
  }

  public void glGetBufferParameterivARB(int target, int pname, Addressable params) {
    glut_h.glGetBufferParameterivARB(target, pname, params);
  }

  public void glGetBufferPointerv(int target, int pname, Addressable params) {
    glut_h.glGetBufferPointerv(target, pname, params);
  }

  public void glGetBufferPointervARB(int target, int pname, Addressable params) {
    glut_h.glGetBufferPointervARB(target, pname, params);
  }

  public void glGetBufferSubData(int target, long offset, long size, Addressable data) {
    glut_h.glGetBufferSubData(target, offset, size, data);
  }

  public void glGetBufferSubDataARB(int target, long offset, long size, Addressable data) {
    glut_h.glGetBufferSubDataARB(target, offset, size, data);
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

  public void glGetCompressedTexImageARB(int target, int level, Addressable img) {
    glut_h.glGetCompressedTexImageARB(target, level, img);
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

  public int glGetFragDataLocationEXT(int program, Addressable name) {
    return glut_h.glGetFragDataLocationEXT(program, name);
  }

  public void glGetFramebufferAttachmentParameteriv(int target, int attachment, int pname, Addressable params) {
    glut_h.glGetFramebufferAttachmentParameteriv(target, attachment, pname, params);
  }

  public void glGetFramebufferAttachmentParameterivEXT(int target, int attachment, int pname, Addressable params) {
    glut_h.glGetFramebufferAttachmentParameterivEXT(target, attachment, pname, params);
  }

  public MemoryAddress glGetHandleARB(int pname) {
    return glut_h.glGetHandleARB(pname);
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

  public void glGetInfoLogARB(Addressable obj, int maxLength, Addressable length, Addressable infoLog) {
    glut_h.glGetInfoLogARB(obj, maxLength, length, infoLog);
  }

  public void glGetInteger64v(int pname, Addressable data) {
    glut_h.glGetInteger64v(pname, data);
  }

  public void glGetIntegerIndexedvEXT(int target, int index, Addressable data) {
    glut_h.glGetIntegerIndexedvEXT(target, index, data);
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

  public void glGetObjectLabelEXT(int type, int object, int bufSize, Addressable length, Addressable label) {
    glut_h.glGetObjectLabelEXT(type, object, bufSize, length, label);
  }

  public void glGetObjectParameterfvARB(Addressable obj, int pname, Addressable params) {
    glut_h.glGetObjectParameterfvARB(obj, pname, params);
  }

  public void glGetObjectParameterivAPPLE(int objectType, int name, int pname, Addressable params) {
    glut_h.glGetObjectParameterivAPPLE(objectType, name, pname, params);
  }

  public void glGetObjectParameterivARB(Addressable obj, int pname, Addressable params) {
    glut_h.glGetObjectParameterivARB(obj, pname, params);
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

  public void glGetProgramEnvParameterdvARB(int target, int index, Addressable params) {
    glut_h.glGetProgramEnvParameterdvARB(target, index, params);
  }

  public void glGetProgramEnvParameterfvARB(int target, int index, Addressable params) {
    glut_h.glGetProgramEnvParameterfvARB(target, index, params);
  }

  public void glGetProgramInfoLog(int program, int bufSize, Addressable length, Addressable infoLog) {
    glut_h.glGetProgramInfoLog(program, bufSize, length, infoLog);
  }

  public void glGetProgramLocalParameterdvARB(int target, int index, Addressable params) {
    glut_h.glGetProgramLocalParameterdvARB(target, index, params);
  }

  public void glGetProgramLocalParameterfvARB(int target, int index, Addressable params) {
    glut_h.glGetProgramLocalParameterfvARB(target, index, params);
  }

  public void glGetProgramStringARB(int target, int pname, Addressable string) {
    glut_h.glGetProgramStringARB(target, pname, string);
  }

  public void glGetProgramiv(int program, int pname, Addressable params) {
    glut_h.glGetProgramiv(program, pname, params);
  }

  public void glGetProgramivARB(int target, int pname, Addressable params) {
    glut_h.glGetProgramivARB(target, pname, params);
  }

  public void glGetQueryObjecti64vEXT(int id, int pname, Addressable params) {
    glut_h.glGetQueryObjecti64vEXT(id, pname, params);
  }

  public void glGetQueryObjectiv(int id, int pname, Addressable params) {
    glut_h.glGetQueryObjectiv(id, pname, params);
  }

  public void glGetQueryObjectivARB(int id, int pname, Addressable params) {
    glut_h.glGetQueryObjectivARB(id, pname, params);
  }

  public void glGetQueryObjectui64vEXT(int id, int pname, Addressable params) {
    glut_h.glGetQueryObjectui64vEXT(id, pname, params);
  }

  public void glGetQueryObjectuiv(int id, int pname, Addressable params) {
    glut_h.glGetQueryObjectuiv(id, pname, params);
  }

  public void glGetQueryObjectuivARB(int id, int pname, Addressable params) {
    glut_h.glGetQueryObjectuivARB(id, pname, params);
  }

  public void glGetQueryiv(int target, int pname, Addressable params) {
    glut_h.glGetQueryiv(target, pname, params);
  }

  public void glGetQueryivARB(int target, int pname, Addressable params) {
    glut_h.glGetQueryivARB(target, pname, params);
  }

  public void glGetRenderbufferParameteriv(int target, int pname, Addressable params) {
    glut_h.glGetRenderbufferParameteriv(target, pname, params);
  }

  public void glGetRenderbufferParameterivEXT(int target, int pname, Addressable params) {
    glut_h.glGetRenderbufferParameterivEXT(target, pname, params);
  }

  public void glGetSeparableFilter(int target, int format, int type, Addressable row, Addressable column, Addressable span) {
    glut_h.glGetSeparableFilter(target, format, type, row, column, span);
  }

  public void glGetShaderInfoLog(int shader, int bufSize, Addressable length, Addressable infoLog) {
    glut_h.glGetShaderInfoLog(shader, bufSize, length, infoLog);
  }

  public void glGetShaderSource(int shader, int bufSize, Addressable length, Addressable source) {
    glut_h.glGetShaderSource(shader, bufSize, length, source);
  }

  public void glGetShaderSourceARB(Addressable obj, int maxLength, Addressable length, Addressable source) {
    glut_h.glGetShaderSourceARB(obj, maxLength, length, source);
  }

  public void glGetShaderiv(int shader, int pname, Addressable params) {
    glut_h.glGetShaderiv(shader, pname, params);
  }

  public String glGetString(int name) {
    return glut_h.glGetString(name).getUtf8String(0);
  }

  public void glGetSynciv(Addressable sync, int pname, int count, Addressable length, Addressable values) {
    glut_h.glGetSynciv(sync, pname, count, length, values);
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

  public void glGetTexParameterIivEXT(int target, int pname, Addressable params) {
    glut_h.glGetTexParameterIivEXT(target, pname, params);
  }

  public void glGetTexParameterIuivEXT(int target, int pname, Addressable params) {
    glut_h.glGetTexParameterIuivEXT(target, pname, params);
  }

  public void glGetTexParameterPointervAPPLE(int target, int pname, Addressable params) {
    glut_h.glGetTexParameterPointervAPPLE(target, pname, params);
  }

  public void glGetTexParameterfv(int target, int pname, Addressable params) {
    glut_h.glGetTexParameterfv(target, pname, params);
  }

  public void glGetTexParameteriv(int target, int pname, Addressable params) {
    glut_h.glGetTexParameteriv(target, pname, params);
  }

  public void glGetTransformFeedbackVaryingEXT(int program, int index, int bufSize, Addressable length, Addressable size, Addressable type, Addressable name) {
    glut_h.glGetTransformFeedbackVaryingEXT(program, index, bufSize, length, size, type, name);
  }

  public int glGetUniformBufferSizeEXT(int program, int location) {
    return glut_h.glGetUniformBufferSizeEXT(program, location);
  }

  public int glGetUniformLocation(int program, Addressable name) {
    return glut_h.glGetUniformLocation(program, name);
  }

  public int glGetUniformLocationARB(Addressable programObj, Addressable name) {
    return glut_h.glGetUniformLocationARB(programObj, name);
  }

  public long glGetUniformOffsetEXT(int program, int location) {
    return glut_h.glGetUniformOffsetEXT(program, location);
  }

  public void glGetUniformfv(int program, int location, Addressable params) {
    glut_h.glGetUniformfv(program, location, params);
  }

  public void glGetUniformfvARB(Addressable programObj, int location, Addressable params) {
    glut_h.glGetUniformfvARB(programObj, location, params);
  }

  public void glGetUniformiv(int program, int location, Addressable params) {
    glut_h.glGetUniformiv(program, location, params);
  }

  public void glGetUniformivARB(Addressable programObj, int location, Addressable params) {
    glut_h.glGetUniformivARB(programObj, location, params);
  }

  public void glGetUniformuivEXT(int program, int location, Addressable params) {
    glut_h.glGetUniformuivEXT(program, location, params);
  }

  public void glGetVertexAttribIivEXT(int index, int pname, Addressable params) {
    glut_h.glGetVertexAttribIivEXT(index, pname, params);
  }

  public void glGetVertexAttribIuivEXT(int index, int pname, Addressable params) {
    glut_h.glGetVertexAttribIuivEXT(index, pname, params);
  }

  public void glGetVertexAttribPointerv(int index, int pname, Addressable pointer) {
    glut_h.glGetVertexAttribPointerv(index, pname, pointer);
  }

  public void glGetVertexAttribPointervARB(int index, int pname, Addressable pointer) {
    glut_h.glGetVertexAttribPointervARB(index, pname, pointer);
  }

  public void glGetVertexAttribdv(int index, int pname, Addressable params) {
    glut_h.glGetVertexAttribdv(index, pname, params);
  }

  public void glGetVertexAttribdvARB(int index, int pname, Addressable params) {
    glut_h.glGetVertexAttribdvARB(index, pname, params);
  }

  public void glGetVertexAttribfv(int index, int pname, Addressable params) {
    glut_h.glGetVertexAttribfv(index, pname, params);
  }

  public void glGetVertexAttribfvARB(int index, int pname, Addressable params) {
    glut_h.glGetVertexAttribfvARB(index, pname, params);
  }

  public void glGetVertexAttribiv(int index, int pname, Addressable params) {
    glut_h.glGetVertexAttribiv(index, pname, params);
  }

  public void glGetVertexAttribivARB(int index, int pname, Addressable params) {
    glut_h.glGetVertexAttribivARB(index, pname, params);
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

  public void glInsertEventMarkerEXT(int length, Addressable marker) {
    glut_h.glInsertEventMarkerEXT(length, marker);
  }

  public void glInterleavedArrays(int format, int stride, Addressable pointer) {
    glut_h.glInterleavedArrays(format, stride, pointer);
  }

  public byte glIsBuffer(int buffer) {
    return glut_h.glIsBuffer(buffer);
  }

  public byte glIsBufferARB(int buffer) {
    return glut_h.glIsBufferARB(buffer);
  }

  public byte glIsEnabled(int cap) {
    return glut_h.glIsEnabled(cap);
  }

  public byte glIsEnabledIndexedEXT(int target, int index) {
    return glut_h.glIsEnabledIndexedEXT(target, index);
  }

  public byte glIsFenceAPPLE(int fence) {
    return glut_h.glIsFenceAPPLE(fence);
  }

  public byte glIsFramebuffer(int framebuffer) {
    return glut_h.glIsFramebuffer(framebuffer);
  }

  public byte glIsFramebufferEXT(int framebuffer) {
    return glut_h.glIsFramebufferEXT(framebuffer);
  }

  public byte glIsList(int list) {
    return glut_h.glIsList(list);
  }

  public byte glIsProgram(int program) {
    return glut_h.glIsProgram(program);
  }

  public byte glIsProgramARB(int program) {
    return glut_h.glIsProgramARB(program);
  }

  public byte glIsQuery(int id) {
    return glut_h.glIsQuery(id);
  }

  public byte glIsQueryARB(int id) {
    return glut_h.glIsQueryARB(id);
  }

  public byte glIsRenderbuffer(int renderbuffer) {
    return glut_h.glIsRenderbuffer(renderbuffer);
  }

  public byte glIsRenderbufferEXT(int renderbuffer) {
    return glut_h.glIsRenderbufferEXT(renderbuffer);
  }

  public byte glIsShader(int shader) {
    return glut_h.glIsShader(shader);
  }

  public byte glIsSync(Addressable sync) {
    return glut_h.glIsSync(sync);
  }

  public byte glIsTexture(int texture) {
    return glut_h.glIsTexture(texture);
  }

  public byte glIsVertexArrayAPPLE(int array) {
    return glut_h.glIsVertexArrayAPPLE(array);
  }

  public byte glIsVertexAttribEnabledAPPLE(int index, int pname) {
    return glut_h.glIsVertexAttribEnabledAPPLE(index, pname);
  }

  public void glLabelObjectEXT(int type, int object, int length, Addressable label) {
    glut_h.glLabelObjectEXT(type, object, length, label);
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

  public void glLinkProgram(int program) {
    glut_h.glLinkProgram(program);
  }

  public void glLinkProgramARB(Addressable programObj) {
    glut_h.glLinkProgramARB(programObj);
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

  public void glLoadTransposeMatrixdARB(Addressable m) {
    glut_h.glLoadTransposeMatrixdARB(m);
  }

  public void glLoadTransposeMatrixf(Addressable m) {
    glut_h.glLoadTransposeMatrixf(m);
  }

  public void glLoadTransposeMatrixfARB(Addressable m) {
    glut_h.glLoadTransposeMatrixfARB(m);
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

  public MemoryAddress glMapBuffer(int target, int access) {
    return glut_h.glMapBuffer(target, access);
  }

  public MemoryAddress glMapBufferARB(int target, int access) {
    return glut_h.glMapBufferARB(target, access);
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

  public void glMapVertexAttrib1dAPPLE(int index, int size, double u1, double u2, int stride, int order, Addressable points) {
    glut_h.glMapVertexAttrib1dAPPLE(index, size, u1, u2, stride, order, points);
  }

  public void glMapVertexAttrib1fAPPLE(int index, int size, float u1, float u2, int stride, int order, Addressable points) {
    glut_h.glMapVertexAttrib1fAPPLE(index, size, u1, u2, stride, order, points);
  }

  public void glMapVertexAttrib2dAPPLE(int index, int size, double u1, double u2, int ustride, int uorder, double v1, double v2, int vstride, int vorder, Addressable points) {
    glut_h.glMapVertexAttrib2dAPPLE(index, size, u1, u2, ustride, uorder, v1, v2, vstride, vorder, points);
  }

  public void glMapVertexAttrib2fAPPLE(int index, int size, float u1, float u2, int ustride, int uorder, float v1, float v2, int vstride, int vorder, Addressable points) {
    glut_h.glMapVertexAttrib2fAPPLE(index, size, u1, u2, ustride, uorder, v1, v2, vstride, vorder, points);
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

  public void glMultTransposeMatrixdARB(Addressable m) {
    glut_h.glMultTransposeMatrixdARB(m);
  }

  public void glMultTransposeMatrixf(Addressable m) {
    glut_h.glMultTransposeMatrixf(m);
  }

  public void glMultTransposeMatrixfARB(Addressable m) {
    glut_h.glMultTransposeMatrixfARB(m);
  }

  public void glMultiDrawArrays(int mode, Addressable first, Addressable count, int drawcount) {
    glut_h.glMultiDrawArrays(mode, first, count, drawcount);
  }

  public void glMultiDrawArraysEXT(int mode, Addressable first, Addressable count, int primcount) {
    glut_h.glMultiDrawArraysEXT(mode, first, count, primcount);
  }

  public void glMultiDrawElementArrayAPPLE(int mode, Addressable first, Addressable count, int primcount) {
    glut_h.glMultiDrawElementArrayAPPLE(mode, first, count, primcount);
  }

  public void glMultiDrawElements(int mode, Addressable count, int type, Addressable indices, int drawcount) {
    glut_h.glMultiDrawElements(mode, count, type, indices, drawcount);
  }

  public void glMultiDrawElementsBaseVertex(int mode, Addressable count, int type, Addressable indices, int drawcount, Addressable basevertex) {
    glut_h.glMultiDrawElementsBaseVertex(mode, count, type, indices, drawcount, basevertex);
  }

  public void glMultiDrawElementsEXT(int mode, Addressable count, int type, Addressable indices, int primcount) {
    glut_h.glMultiDrawElementsEXT(mode, count, type, indices, primcount);
  }

  public void glMultiDrawRangeElementArrayAPPLE(int mode, int start, int end, Addressable first, Addressable count, int primcount) {
    glut_h.glMultiDrawRangeElementArrayAPPLE(mode, start, end, first, count, primcount);
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

  public int glObjectPurgeableAPPLE(int objectType, int name, int option) {
    return glut_h.glObjectPurgeableAPPLE(objectType, name, option);
  }

  public int glObjectUnpurgeableAPPLE(int objectType, int name, int option) {
    return glut_h.glObjectUnpurgeableAPPLE(objectType, name, option);
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

  public void glPointParameterf(int pname, float param) {
    glut_h.glPointParameterf(pname, param);
  }

  public void glPointParameterfARB(int pname, float param) {
    glut_h.glPointParameterfARB(pname, param);
  }

  public void glPointParameterfv(int pname, Addressable params) {
    glut_h.glPointParameterfv(pname, params);
  }

  public void glPointParameterfvARB(int pname, Addressable params) {
    glut_h.glPointParameterfvARB(pname, params);
  }

  public void glPointParameteri(int pname, int param) {
    glut_h.glPointParameteri(pname, param);
  }

  public void glPointParameteriNV(int pname, int param) {
    glut_h.glPointParameteriNV(pname, param);
  }

  public void glPointParameteriv(int pname, Addressable params) {
    glut_h.glPointParameteriv(pname, params);
  }

  public void glPointParameterivNV(int pname, Addressable params) {
    glut_h.glPointParameterivNV(pname, params);
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

  public void glPopGroupMarkerEXT() {
    glut_h.glPopGroupMarkerEXT();
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

  public void glProgramEnvParameter4dARB(int target, int index, double x, double y, double z, double w) {
    glut_h.glProgramEnvParameter4dARB(target, index, x, y, z, w);
  }

  public void glProgramEnvParameter4dvARB(int target, int index, Addressable params) {
    glut_h.glProgramEnvParameter4dvARB(target, index, params);
  }

  public void glProgramEnvParameter4fARB(int target, int index, float x, float y, float z, float w) {
    glut_h.glProgramEnvParameter4fARB(target, index, x, y, z, w);
  }

  public void glProgramEnvParameter4fvARB(int target, int index, Addressable params) {
    glut_h.glProgramEnvParameter4fvARB(target, index, params);
  }

  public void glProgramEnvParameters4fvEXT(int target, int index, int count, Addressable params) {
    glut_h.glProgramEnvParameters4fvEXT(target, index, count, params);
  }

  public void glProgramLocalParameter4dARB(int target, int index, double x, double y, double z, double w) {
    glut_h.glProgramLocalParameter4dARB(target, index, x, y, z, w);
  }

  public void glProgramLocalParameter4dvARB(int target, int index, Addressable params) {
    glut_h.glProgramLocalParameter4dvARB(target, index, params);
  }

  public void glProgramLocalParameter4fARB(int target, int index, float x, float y, float z, float w) {
    glut_h.glProgramLocalParameter4fARB(target, index, x, y, z, w);
  }

  public void glProgramLocalParameter4fvARB(int target, int index, Addressable params) {
    glut_h.glProgramLocalParameter4fvARB(target, index, params);
  }

  public void glProgramLocalParameters4fvEXT(int target, int index, int count, Addressable params) {
    glut_h.glProgramLocalParameters4fvEXT(target, index, count, params);
  }

  public void glProgramParameteriEXT(int program, int pname, int value) {
    glut_h.glProgramParameteriEXT(program, pname, value);
  }

  public void glProgramStringARB(int target, int format, int len, Addressable string) {
    glut_h.glProgramStringARB(target, format, len, string);
  }

  public void glProvokingVertex(int mode) {
    glut_h.glProvokingVertex(mode);
  }

  public void glProvokingVertexEXT(int mode) {
    glut_h.glProvokingVertexEXT(mode);
  }

  public void glPushAttrib(int mask) {
    glut_h.glPushAttrib(mask);
  }

  public void glPushClientAttrib(int mask) {
    glut_h.glPushClientAttrib(mask);
  }

  public void glPushGroupMarkerEXT(int length, Addressable marker) {
    glut_h.glPushGroupMarkerEXT(length, marker);
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

  public void glRenderbufferStorage(int target, int internalformat, int width, int height) {
    glut_h.glRenderbufferStorage(target, internalformat, width, height);
  }

  public void glRenderbufferStorageEXT(int target, int internalformat, int width, int height) {
    glut_h.glRenderbufferStorageEXT(target, internalformat, width, height);
  }

  public void glRenderbufferStorageMultisample(int target, int samples, int internalformat, int width, int height) {
    glut_h.glRenderbufferStorageMultisample(target, samples, internalformat, width, height);
  }

  public void glRenderbufferStorageMultisampleEXT(int target, int samples, int internalformat, int width, int height) {
    glut_h.glRenderbufferStorageMultisampleEXT(target, samples, internalformat, width, height);
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

  public void glSampleCoverageARB(float value, byte invert) {
    glut_h.glSampleCoverageARB(value, invert);
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

  public void glSecondaryColor3b(byte red, byte green, byte blue) {
    glut_h.glSecondaryColor3b(red, green, blue);
  }

  public void glSecondaryColor3bEXT(byte red, byte green, byte blue) {
    glut_h.glSecondaryColor3bEXT(red, green, blue);
  }

  public void glSecondaryColor3bv(Addressable v) {
    glut_h.glSecondaryColor3bv(v);
  }

  public void glSecondaryColor3bvEXT(Addressable v) {
    glut_h.glSecondaryColor3bvEXT(v);
  }

  public void glSecondaryColor3d(double red, double green, double blue) {
    glut_h.glSecondaryColor3d(red, green, blue);
  }

  public void glSecondaryColor3dEXT(double red, double green, double blue) {
    glut_h.glSecondaryColor3dEXT(red, green, blue);
  }

  public void glSecondaryColor3dv(Addressable v) {
    glut_h.glSecondaryColor3dv(v);
  }

  public void glSecondaryColor3dvEXT(Addressable v) {
    glut_h.glSecondaryColor3dvEXT(v);
  }

  public void glSecondaryColor3f(float red, float green, float blue) {
    glut_h.glSecondaryColor3f(red, green, blue);
  }

  public void glSecondaryColor3fEXT(float red, float green, float blue) {
    glut_h.glSecondaryColor3fEXT(red, green, blue);
  }

  public void glSecondaryColor3fv(Addressable v) {
    glut_h.glSecondaryColor3fv(v);
  }

  public void glSecondaryColor3fvEXT(Addressable v) {
    glut_h.glSecondaryColor3fvEXT(v);
  }

  public void glSecondaryColor3i(int red, int green, int blue) {
    glut_h.glSecondaryColor3i(red, green, blue);
  }

  public void glSecondaryColor3iEXT(int red, int green, int blue) {
    glut_h.glSecondaryColor3iEXT(red, green, blue);
  }

  public void glSecondaryColor3iv(Addressable v) {
    glut_h.glSecondaryColor3iv(v);
  }

  public void glSecondaryColor3ivEXT(Addressable v) {
    glut_h.glSecondaryColor3ivEXT(v);
  }

  public void glSecondaryColor3s(short red, short green, short blue) {
    glut_h.glSecondaryColor3s(red, green, blue);
  }

  public void glSecondaryColor3sEXT(short red, short green, short blue) {
    glut_h.glSecondaryColor3sEXT(red, green, blue);
  }

  public void glSecondaryColor3sv(Addressable v) {
    glut_h.glSecondaryColor3sv(v);
  }

  public void glSecondaryColor3svEXT(Addressable v) {
    glut_h.glSecondaryColor3svEXT(v);
  }

  public void glSecondaryColor3ub(byte red, byte green, byte blue) {
    glut_h.glSecondaryColor3ub(red, green, blue);
  }

  public void glSecondaryColor3ubEXT(byte red, byte green, byte blue) {
    glut_h.glSecondaryColor3ubEXT(red, green, blue);
  }

  public void glSecondaryColor3ubv(Addressable v) {
    glut_h.glSecondaryColor3ubv(v);
  }

  public void glSecondaryColor3ubvEXT(Addressable v) {
    glut_h.glSecondaryColor3ubvEXT(v);
  }

  public void glSecondaryColor3ui(int red, int green, int blue) {
    glut_h.glSecondaryColor3ui(red, green, blue);
  }

  public void glSecondaryColor3uiEXT(int red, int green, int blue) {
    glut_h.glSecondaryColor3uiEXT(red, green, blue);
  }

  public void glSecondaryColor3uiv(Addressable v) {
    glut_h.glSecondaryColor3uiv(v);
  }

  public void glSecondaryColor3uivEXT(Addressable v) {
    glut_h.glSecondaryColor3uivEXT(v);
  }

  public void glSecondaryColor3us(short red, short green, short blue) {
    glut_h.glSecondaryColor3us(red, green, blue);
  }

  public void glSecondaryColor3usEXT(short red, short green, short blue) {
    glut_h.glSecondaryColor3usEXT(red, green, blue);
  }

  public void glSecondaryColor3usv(Addressable v) {
    glut_h.glSecondaryColor3usv(v);
  }

  public void glSecondaryColor3usvEXT(Addressable v) {
    glut_h.glSecondaryColor3usvEXT(v);
  }

  public void glSecondaryColorPointer(int size, int type, int stride, Addressable pointer) {
    glut_h.glSecondaryColorPointer(size, type, stride, pointer);
  }

  public void glSecondaryColorPointerEXT(int size, int type, int stride, Addressable pointer) {
    glut_h.glSecondaryColorPointerEXT(size, type, stride, pointer);
  }

  public void glSelectBuffer(int size, Addressable buffer) {
    glut_h.glSelectBuffer(size, buffer);
  }

  public void glSeparableFilter2D(int target, int internalformat, int width, int height, int format, int type, Addressable row, Addressable column) {
    glut_h.glSeparableFilter2D(target, internalformat, width, height, format, type, row, column);
  }

  public void glSetFenceAPPLE(int fence) {
    glut_h.glSetFenceAPPLE(fence);
  }

  public void glShadeModel(int mode) {
    glut_h.glShadeModel(mode);
  }

  public void glShaderSource(int shader, int count, Addressable string, Addressable length) {
    glut_h.glShaderSource(shader, count, string, length);
  }

  public void glShaderSourceARB(Addressable shaderObj, int count, Addressable string, Addressable length) {
    glut_h.glShaderSourceARB(shaderObj, count, string, length);
  }

  public void glStencilFunc(int func, int ref, int mask) {
    glut_h.glStencilFunc(func, ref, mask);
  }

  public void glStencilFuncSeparate(int face, int func, int ref, int mask) {
    glut_h.glStencilFuncSeparate(face, func, ref, mask);
  }

  public void glStencilFuncSeparateATI(int frontfunc, int backfunc, int ref, int mask) {
    glut_h.glStencilFuncSeparateATI(frontfunc, backfunc, ref, mask);
  }

  public void glStencilMask(int mask) {
    glut_h.glStencilMask(mask);
  }

  public void glStencilMaskSeparate(int face, int mask) {
    glut_h.glStencilMaskSeparate(face, mask);
  }

  public void glStencilOp(int fail, int zfail, int zpass) {
    glut_h.glStencilOp(fail, zfail, zpass);
  }

  public void glStencilOpSeparate(int face, int sfail, int dpfail, int dppass) {
    glut_h.glStencilOpSeparate(face, sfail, dpfail, dppass);
  }

  public void glStencilOpSeparateATI(int face, int sfail, int dpfail, int dppass) {
    glut_h.glStencilOpSeparateATI(face, sfail, dpfail, dppass);
  }

  public byte glTestFenceAPPLE(int fence) {
    return glut_h.glTestFenceAPPLE(fence);
  }

  public byte glTestObjectAPPLE(int object, int name) {
    return glut_h.glTestObjectAPPLE(object, name);
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

  public void glTexParameterIivEXT(int target, int pname, Addressable params) {
    glut_h.glTexParameterIivEXT(target, pname, params);
  }

  public void glTexParameterIuivEXT(int target, int pname, Addressable params) {
    glut_h.glTexParameterIuivEXT(target, pname, params);
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

  public void glTextureBarrierNV() {
    glut_h.glTextureBarrierNV();
  }

  public void glTextureRangeAPPLE(int target, int length, Addressable pointer) {
    glut_h.glTextureRangeAPPLE(target, length, pointer);
  }

  public void glTransformFeedbackVaryingsEXT(int program, int count, Addressable varyings, int bufferMode) {
    glut_h.glTransformFeedbackVaryingsEXT(program, count, varyings, bufferMode);
  }

  public void glTranslated(double x, double y, double z) {
    glut_h.glTranslated(x, y, z);
  }

  public void glTranslatef(float x, float y, float z) {
    glut_h.glTranslatef(x, y, z);
  }

  public void glUniform1f(int location, float v0) {
    glut_h.glUniform1f(location, v0);
  }

  public void glUniform1fARB(int location, float v0) {
    glut_h.glUniform1fARB(location, v0);
  }

  public void glUniform1fv(int location, int count, Addressable value) {
    glut_h.glUniform1fv(location, count, value);
  }

  public void glUniform1fvARB(int location, int count, Addressable value) {
    glut_h.glUniform1fvARB(location, count, value);
  }

  public void glUniform1i(int location, int v0) {
    glut_h.glUniform1i(location, v0);
  }

  public void glUniform1iARB(int location, int v0) {
    glut_h.glUniform1iARB(location, v0);
  }

  public void glUniform1iv(int location, int count, Addressable value) {
    glut_h.glUniform1iv(location, count, value);
  }

  public void glUniform1ivARB(int location, int count, Addressable value) {
    glut_h.glUniform1ivARB(location, count, value);
  }

  public void glUniform1uiEXT(int location, int v0) {
    glut_h.glUniform1uiEXT(location, v0);
  }

  public void glUniform1uivEXT(int location, int count, Addressable value) {
    glut_h.glUniform1uivEXT(location, count, value);
  }

  public void glUniform2f(int location, float v0, float v1) {
    glut_h.glUniform2f(location, v0, v1);
  }

  public void glUniform2fARB(int location, float v0, float v1) {
    glut_h.glUniform2fARB(location, v0, v1);
  }

  public void glUniform2fv(int location, int count, Addressable value) {
    glut_h.glUniform2fv(location, count, value);
  }

  public void glUniform2fvARB(int location, int count, Addressable value) {
    glut_h.glUniform2fvARB(location, count, value);
  }

  public void glUniform2i(int location, int v0, int v1) {
    glut_h.glUniform2i(location, v0, v1);
  }

  public void glUniform2iARB(int location, int v0, int v1) {
    glut_h.glUniform2iARB(location, v0, v1);
  }

  public void glUniform2iv(int location, int count, Addressable value) {
    glut_h.glUniform2iv(location, count, value);
  }

  public void glUniform2ivARB(int location, int count, Addressable value) {
    glut_h.glUniform2ivARB(location, count, value);
  }

  public void glUniform2uiEXT(int location, int v0, int v1) {
    glut_h.glUniform2uiEXT(location, v0, v1);
  }

  public void glUniform2uivEXT(int location, int count, Addressable value) {
    glut_h.glUniform2uivEXT(location, count, value);
  }

  public void glUniform3f(int location, float v0, float v1, float v2) {
    glut_h.glUniform3f(location, v0, v1, v2);
  }

  public void glUniform3fARB(int location, float v0, float v1, float v2) {
    glut_h.glUniform3fARB(location, v0, v1, v2);
  }

  public void glUniform3fv(int location, int count, Addressable value) {
    glut_h.glUniform3fv(location, count, value);
  }

  public void glUniform3fvARB(int location, int count, Addressable value) {
    glut_h.glUniform3fvARB(location, count, value);
  }

  public void glUniform3i(int location, int v0, int v1, int v2) {
    glut_h.glUniform3i(location, v0, v1, v2);
  }

  public void glUniform3iARB(int location, int v0, int v1, int v2) {
    glut_h.glUniform3iARB(location, v0, v1, v2);
  }

  public void glUniform3iv(int location, int count, Addressable value) {
    glut_h.glUniform3iv(location, count, value);
  }

  public void glUniform3ivARB(int location, int count, Addressable value) {
    glut_h.glUniform3ivARB(location, count, value);
  }

  public void glUniform3uiEXT(int location, int v0, int v1, int v2) {
    glut_h.glUniform3uiEXT(location, v0, v1, v2);
  }

  public void glUniform3uivEXT(int location, int count, Addressable value) {
    glut_h.glUniform3uivEXT(location, count, value);
  }

  public void glUniform4f(int location, float v0, float v1, float v2, float v3) {
    glut_h.glUniform4f(location, v0, v1, v2, v3);
  }

  public void glUniform4fARB(int location, float v0, float v1, float v2, float v3) {
    glut_h.glUniform4fARB(location, v0, v1, v2, v3);
  }

  public void glUniform4fv(int location, int count, Addressable value) {
    glut_h.glUniform4fv(location, count, value);
  }

  public void glUniform4fvARB(int location, int count, Addressable value) {
    glut_h.glUniform4fvARB(location, count, value);
  }

  public void glUniform4i(int location, int v0, int v1, int v2, int v3) {
    glut_h.glUniform4i(location, v0, v1, v2, v3);
  }

  public void glUniform4iARB(int location, int v0, int v1, int v2, int v3) {
    glut_h.glUniform4iARB(location, v0, v1, v2, v3);
  }

  public void glUniform4iv(int location, int count, Addressable value) {
    glut_h.glUniform4iv(location, count, value);
  }

  public void glUniform4ivARB(int location, int count, Addressable value) {
    glut_h.glUniform4ivARB(location, count, value);
  }

  public void glUniform4uiEXT(int location, int v0, int v1, int v2, int v3) {
    glut_h.glUniform4uiEXT(location, v0, v1, v2, v3);
  }

  public void glUniform4uivEXT(int location, int count, Addressable value) {
    glut_h.glUniform4uivEXT(location, count, value);
  }

  public void glUniformBufferEXT(int program, int location, int buffer) {
    glut_h.glUniformBufferEXT(program, location, buffer);
  }

  public void glUniformMatrix2fv(int location, int count, byte transpose, Addressable value) {
    glut_h.glUniformMatrix2fv(location, count, transpose, value);
  }

  public void glUniformMatrix2fvARB(int location, int count, byte transpose, Addressable value) {
    glut_h.glUniformMatrix2fvARB(location, count, transpose, value);
  }

  public void glUniformMatrix2x3fv(int location, int count, byte transpose, Addressable value) {
    glut_h.glUniformMatrix2x3fv(location, count, transpose, value);
  }

  public void glUniformMatrix2x4fv(int location, int count, byte transpose, Addressable value) {
    glut_h.glUniformMatrix2x4fv(location, count, transpose, value);
  }

  public void glUniformMatrix3fv(int location, int count, byte transpose, Addressable value) {
    glut_h.glUniformMatrix3fv(location, count, transpose, value);
  }

  public void glUniformMatrix3fvARB(int location, int count, byte transpose, Addressable value) {
    glut_h.glUniformMatrix3fvARB(location, count, transpose, value);
  }

  public void glUniformMatrix3x2fv(int location, int count, byte transpose, Addressable value) {
    glut_h.glUniformMatrix3x2fv(location, count, transpose, value);
  }

  public void glUniformMatrix3x4fv(int location, int count, byte transpose, Addressable value) {
    glut_h.glUniformMatrix3x4fv(location, count, transpose, value);
  }

  public void glUniformMatrix4fv(int location, int count, byte transpose, Addressable value) {
    glut_h.glUniformMatrix4fv(location, count, transpose, value);
  }

  public void glUniformMatrix4fvARB(int location, int count, byte transpose, Addressable value) {
    glut_h.glUniformMatrix4fvARB(location, count, transpose, value);
  }

  public void glUniformMatrix4x2fv(int location, int count, byte transpose, Addressable value) {
    glut_h.glUniformMatrix4x2fv(location, count, transpose, value);
  }

  public void glUniformMatrix4x3fv(int location, int count, byte transpose, Addressable value) {
    glut_h.glUniformMatrix4x3fv(location, count, transpose, value);
  }

  public byte glUnmapBuffer(int target) {
    return glut_h.glUnmapBuffer(target);
  }

  public byte glUnmapBufferARB(int target) {
    return glut_h.glUnmapBufferARB(target);
  }

  public void glUseProgram(int program) {
    glut_h.glUseProgram(program);
  }

  public void glUseProgramObjectARB(Addressable programObj) {
    glut_h.glUseProgramObjectARB(programObj);
  }

  public void glValidateProgram(int program) {
    glut_h.glValidateProgram(program);
  }

  public void glValidateProgramARB(Addressable programObj) {
    glut_h.glValidateProgramARB(programObj);
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

  public void glVertexArrayParameteriAPPLE(int pname, int param) {
    glut_h.glVertexArrayParameteriAPPLE(pname, param);
  }

  public void glVertexArrayRangeAPPLE(int length, Addressable pointer) {
    glut_h.glVertexArrayRangeAPPLE(length, pointer);
  }

  public void glVertexAttrib1d(int index, double x) {
    glut_h.glVertexAttrib1d(index, x);
  }

  public void glVertexAttrib1dARB(int index, double x) {
    glut_h.glVertexAttrib1dARB(index, x);
  }

  public void glVertexAttrib1dv(int index, Addressable v) {
    glut_h.glVertexAttrib1dv(index, v);
  }

  public void glVertexAttrib1dvARB(int index, Addressable v) {
    glut_h.glVertexAttrib1dvARB(index, v);
  }

  public void glVertexAttrib1f(int index, float x) {
    glut_h.glVertexAttrib1f(index, x);
  }

  public void glVertexAttrib1fARB(int index, float x) {
    glut_h.glVertexAttrib1fARB(index, x);
  }

  public void glVertexAttrib1fv(int index, Addressable v) {
    glut_h.glVertexAttrib1fv(index, v);
  }

  public void glVertexAttrib1fvARB(int index, Addressable v) {
    glut_h.glVertexAttrib1fvARB(index, v);
  }

  public void glVertexAttrib1s(int index, short x) {
    glut_h.glVertexAttrib1s(index, x);
  }

  public void glVertexAttrib1sARB(int index, short x) {
    glut_h.glVertexAttrib1sARB(index, x);
  }

  public void glVertexAttrib1sv(int index, Addressable v) {
    glut_h.glVertexAttrib1sv(index, v);
  }

  public void glVertexAttrib1svARB(int index, Addressable v) {
    glut_h.glVertexAttrib1svARB(index, v);
  }

  public void glVertexAttrib2d(int index, double x, double y) {
    glut_h.glVertexAttrib2d(index, x, y);
  }

  public void glVertexAttrib2dARB(int index, double x, double y) {
    glut_h.glVertexAttrib2dARB(index, x, y);
  }

  public void glVertexAttrib2dv(int index, Addressable v) {
    glut_h.glVertexAttrib2dv(index, v);
  }

  public void glVertexAttrib2dvARB(int index, Addressable v) {
    glut_h.glVertexAttrib2dvARB(index, v);
  }

  public void glVertexAttrib2f(int index, float x, float y) {
    glut_h.glVertexAttrib2f(index, x, y);
  }

  public void glVertexAttrib2fARB(int index, float x, float y) {
    glut_h.glVertexAttrib2fARB(index, x, y);
  }

  public void glVertexAttrib2fv(int index, Addressable v) {
    glut_h.glVertexAttrib2fv(index, v);
  }

  public void glVertexAttrib2fvARB(int index, Addressable v) {
    glut_h.glVertexAttrib2fvARB(index, v);
  }

  public void glVertexAttrib2s(int index, short x, short y) {
    glut_h.glVertexAttrib2s(index, x, y);
  }

  public void glVertexAttrib2sARB(int index, short x, short y) {
    glut_h.glVertexAttrib2sARB(index, x, y);
  }

  public void glVertexAttrib2sv(int index, Addressable v) {
    glut_h.glVertexAttrib2sv(index, v);
  }

  public void glVertexAttrib2svARB(int index, Addressable v) {
    glut_h.glVertexAttrib2svARB(index, v);
  }

  public void glVertexAttrib3d(int index, double x, double y, double z) {
    glut_h.glVertexAttrib3d(index, x, y, z);
  }

  public void glVertexAttrib3dARB(int index, double x, double y, double z) {
    glut_h.glVertexAttrib3dARB(index, x, y, z);
  }

  public void glVertexAttrib3dv(int index, Addressable v) {
    glut_h.glVertexAttrib3dv(index, v);
  }

  public void glVertexAttrib3dvARB(int index, Addressable v) {
    glut_h.glVertexAttrib3dvARB(index, v);
  }

  public void glVertexAttrib3f(int index, float x, float y, float z) {
    glut_h.glVertexAttrib3f(index, x, y, z);
  }

  public void glVertexAttrib3fARB(int index, float x, float y, float z) {
    glut_h.glVertexAttrib3fARB(index, x, y, z);
  }

  public void glVertexAttrib3fv(int index, Addressable v) {
    glut_h.glVertexAttrib3fv(index, v);
  }

  public void glVertexAttrib3fvARB(int index, Addressable v) {
    glut_h.glVertexAttrib3fvARB(index, v);
  }

  public void glVertexAttrib3s(int index, short x, short y, short z) {
    glut_h.glVertexAttrib3s(index, x, y, z);
  }

  public void glVertexAttrib3sARB(int index, short x, short y, short z) {
    glut_h.glVertexAttrib3sARB(index, x, y, z);
  }

  public void glVertexAttrib3sv(int index, Addressable v) {
    glut_h.glVertexAttrib3sv(index, v);
  }

  public void glVertexAttrib3svARB(int index, Addressable v) {
    glut_h.glVertexAttrib3svARB(index, v);
  }

  public void glVertexAttrib4Nbv(int index, Addressable v) {
    glut_h.glVertexAttrib4Nbv(index, v);
  }

  public void glVertexAttrib4NbvARB(int index, Addressable v) {
    glut_h.glVertexAttrib4NbvARB(index, v);
  }

  public void glVertexAttrib4Niv(int index, Addressable v) {
    glut_h.glVertexAttrib4Niv(index, v);
  }

  public void glVertexAttrib4NivARB(int index, Addressable v) {
    glut_h.glVertexAttrib4NivARB(index, v);
  }

  public void glVertexAttrib4Nsv(int index, Addressable v) {
    glut_h.glVertexAttrib4Nsv(index, v);
  }

  public void glVertexAttrib4NsvARB(int index, Addressable v) {
    glut_h.glVertexAttrib4NsvARB(index, v);
  }

  public void glVertexAttrib4Nub(int index, byte x, byte y, byte z, byte w) {
    glut_h.glVertexAttrib4Nub(index, x, y, z, w);
  }

  public void glVertexAttrib4NubARB(int index, byte x, byte y, byte z, byte w) {
    glut_h.glVertexAttrib4NubARB(index, x, y, z, w);
  }

  public void glVertexAttrib4Nubv(int index, Addressable v) {
    glut_h.glVertexAttrib4Nubv(index, v);
  }

  public void glVertexAttrib4NubvARB(int index, Addressable v) {
    glut_h.glVertexAttrib4NubvARB(index, v);
  }

  public void glVertexAttrib4Nuiv(int index, Addressable v) {
    glut_h.glVertexAttrib4Nuiv(index, v);
  }

  public void glVertexAttrib4NuivARB(int index, Addressable v) {
    glut_h.glVertexAttrib4NuivARB(index, v);
  }

  public void glVertexAttrib4Nusv(int index, Addressable v) {
    glut_h.glVertexAttrib4Nusv(index, v);
  }

  public void glVertexAttrib4NusvARB(int index, Addressable v) {
    glut_h.glVertexAttrib4NusvARB(index, v);
  }

  public void glVertexAttrib4bv(int index, Addressable v) {
    glut_h.glVertexAttrib4bv(index, v);
  }

  public void glVertexAttrib4bvARB(int index, Addressable v) {
    glut_h.glVertexAttrib4bvARB(index, v);
  }

  public void glVertexAttrib4d(int index, double x, double y, double z, double w) {
    glut_h.glVertexAttrib4d(index, x, y, z, w);
  }

  public void glVertexAttrib4dARB(int index, double x, double y, double z, double w) {
    glut_h.glVertexAttrib4dARB(index, x, y, z, w);
  }

  public void glVertexAttrib4dv(int index, Addressable v) {
    glut_h.glVertexAttrib4dv(index, v);
  }

  public void glVertexAttrib4dvARB(int index, Addressable v) {
    glut_h.glVertexAttrib4dvARB(index, v);
  }

  public void glVertexAttrib4f(int index, float x, float y, float z, float w) {
    glut_h.glVertexAttrib4f(index, x, y, z, w);
  }

  public void glVertexAttrib4fARB(int index, float x, float y, float z, float w) {
    glut_h.glVertexAttrib4fARB(index, x, y, z, w);
  }

  public void glVertexAttrib4fv(int index, Addressable v) {
    glut_h.glVertexAttrib4fv(index, v);
  }

  public void glVertexAttrib4fvARB(int index, Addressable v) {
    glut_h.glVertexAttrib4fvARB(index, v);
  }

  public void glVertexAttrib4iv(int index, Addressable v) {
    glut_h.glVertexAttrib4iv(index, v);
  }

  public void glVertexAttrib4ivARB(int index, Addressable v) {
    glut_h.glVertexAttrib4ivARB(index, v);
  }

  public void glVertexAttrib4s(int index, short x, short y, short z, short w) {
    glut_h.glVertexAttrib4s(index, x, y, z, w);
  }

  public void glVertexAttrib4sARB(int index, short x, short y, short z, short w) {
    glut_h.glVertexAttrib4sARB(index, x, y, z, w);
  }

  public void glVertexAttrib4sv(int index, Addressable v) {
    glut_h.glVertexAttrib4sv(index, v);
  }

  public void glVertexAttrib4svARB(int index, Addressable v) {
    glut_h.glVertexAttrib4svARB(index, v);
  }

  public void glVertexAttrib4ubv(int index, Addressable v) {
    glut_h.glVertexAttrib4ubv(index, v);
  }

  public void glVertexAttrib4ubvARB(int index, Addressable v) {
    glut_h.glVertexAttrib4ubvARB(index, v);
  }

  public void glVertexAttrib4uiv(int index, Addressable v) {
    glut_h.glVertexAttrib4uiv(index, v);
  }

  public void glVertexAttrib4uivARB(int index, Addressable v) {
    glut_h.glVertexAttrib4uivARB(index, v);
  }

  public void glVertexAttrib4usv(int index, Addressable v) {
    glut_h.glVertexAttrib4usv(index, v);
  }

  public void glVertexAttrib4usvARB(int index, Addressable v) {
    glut_h.glVertexAttrib4usvARB(index, v);
  }

  public void glVertexAttribDivisorARB(int index, int divisor) {
    glut_h.glVertexAttribDivisorARB(index, divisor);
  }

  public void glVertexAttribI1iEXT(int index, int x) {
    glut_h.glVertexAttribI1iEXT(index, x);
  }

  public void glVertexAttribI1ivEXT(int index, Addressable v) {
    glut_h.glVertexAttribI1ivEXT(index, v);
  }

  public void glVertexAttribI1uiEXT(int index, int x) {
    glut_h.glVertexAttribI1uiEXT(index, x);
  }

  public void glVertexAttribI1uivEXT(int index, Addressable v) {
    glut_h.glVertexAttribI1uivEXT(index, v);
  }

  public void glVertexAttribI2iEXT(int index, int x, int y) {
    glut_h.glVertexAttribI2iEXT(index, x, y);
  }

  public void glVertexAttribI2ivEXT(int index, Addressable v) {
    glut_h.glVertexAttribI2ivEXT(index, v);
  }

  public void glVertexAttribI2uiEXT(int index, int x, int y) {
    glut_h.glVertexAttribI2uiEXT(index, x, y);
  }

  public void glVertexAttribI2uivEXT(int index, Addressable v) {
    glut_h.glVertexAttribI2uivEXT(index, v);
  }

  public void glVertexAttribI3iEXT(int index, int x, int y, int z) {
    glut_h.glVertexAttribI3iEXT(index, x, y, z);
  }

  public void glVertexAttribI3ivEXT(int index, Addressable v) {
    glut_h.glVertexAttribI3ivEXT(index, v);
  }

  public void glVertexAttribI3uiEXT(int index, int x, int y, int z) {
    glut_h.glVertexAttribI3uiEXT(index, x, y, z);
  }

  public void glVertexAttribI3uivEXT(int index, Addressable v) {
    glut_h.glVertexAttribI3uivEXT(index, v);
  }

  public void glVertexAttribI4bvEXT(int index, Addressable v) {
    glut_h.glVertexAttribI4bvEXT(index, v);
  }

  public void glVertexAttribI4iEXT(int index, int x, int y, int z, int w) {
    glut_h.glVertexAttribI4iEXT(index, x, y, z, w);
  }

  public void glVertexAttribI4ivEXT(int index, Addressable v) {
    glut_h.glVertexAttribI4ivEXT(index, v);
  }

  public void glVertexAttribI4svEXT(int index, Addressable v) {
    glut_h.glVertexAttribI4svEXT(index, v);
  }

  public void glVertexAttribI4ubvEXT(int index, Addressable v) {
    glut_h.glVertexAttribI4ubvEXT(index, v);
  }

  public void glVertexAttribI4uiEXT(int index, int x, int y, int z, int w) {
    glut_h.glVertexAttribI4uiEXT(index, x, y, z, w);
  }

  public void glVertexAttribI4uivEXT(int index, Addressable v) {
    glut_h.glVertexAttribI4uivEXT(index, v);
  }

  public void glVertexAttribI4usvEXT(int index, Addressable v) {
    glut_h.glVertexAttribI4usvEXT(index, v);
  }

  public void glVertexAttribIPointerEXT(int index, int size, int type, int stride, Addressable pointer) {
    glut_h.glVertexAttribIPointerEXT(index, size, type, stride, pointer);
  }

  public void glVertexAttribPointer(int index, int size, int type, byte normalized, int stride, Addressable pointer) {
    glut_h.glVertexAttribPointer(index, size, type, normalized, stride, pointer);
  }

  public void glVertexAttribPointerARB(int index, int size, int type, byte normalized, int stride, Addressable pointer) {
    glut_h.glVertexAttribPointerARB(index, size, type, normalized, stride, pointer);
  }

  public void glVertexBlendARB(int count) {
    glut_h.glVertexBlendARB(count);
  }

  public void glVertexPointer(int size, int type, int stride, Addressable pointer) {
    glut_h.glVertexPointer(size, type, stride, pointer);
  }

  public void glViewport(int x, int y, int width, int height) {
    glut_h.glViewport(x, y, width, height);
  }

  public void glWaitSync(Addressable sync, int flags, long timeout) {
    glut_h.glWaitSync(sync, flags, timeout);
  }

  public void glWeightPointerARB(int size, int type, int stride, Addressable pointer) {
    glut_h.glWeightPointerARB(size, type, stride, pointer);
  }

  public void glWeightbvARB(int size, Addressable weights) {
    glut_h.glWeightbvARB(size, weights);
  }

  public void glWeightdvARB(int size, Addressable weights) {
    glut_h.glWeightdvARB(size, weights);
  }

  public void glWeightfvARB(int size, Addressable weights) {
    glut_h.glWeightfvARB(size, weights);
  }

  public void glWeightivARB(int size, Addressable weights) {
    glut_h.glWeightivARB(size, weights);
  }

  public void glWeightsvARB(int size, Addressable weights) {
    glut_h.glWeightsvARB(size, weights);
  }

  public void glWeightubvARB(int size, Addressable weights) {
    glut_h.glWeightubvARB(size, weights);
  }

  public void glWeightuivARB(int size, Addressable weights) {
    glut_h.glWeightuivARB(size, weights);
  }

  public void glWeightusvARB(int size, Addressable weights) {
    glut_h.glWeightusvARB(size, weights);
  }

  public void glWindowPos2d(double x, double y) {
    glut_h.glWindowPos2d(x, y);
  }

  public void glWindowPos2dARB(double x, double y) {
    glut_h.glWindowPos2dARB(x, y);
  }

  public void glWindowPos2dv(Addressable v) {
    glut_h.glWindowPos2dv(v);
  }

  public void glWindowPos2dvARB(Addressable v) {
    glut_h.glWindowPos2dvARB(v);
  }

  public void glWindowPos2f(float x, float y) {
    glut_h.glWindowPos2f(x, y);
  }

  public void glWindowPos2fARB(float x, float y) {
    glut_h.glWindowPos2fARB(x, y);
  }

  public void glWindowPos2fv(Addressable v) {
    glut_h.glWindowPos2fv(v);
  }

  public void glWindowPos2fvARB(Addressable v) {
    glut_h.glWindowPos2fvARB(v);
  }

  public void glWindowPos2i(int x, int y) {
    glut_h.glWindowPos2i(x, y);
  }

  public void glWindowPos2iARB(int x, int y) {
    glut_h.glWindowPos2iARB(x, y);
  }

  public void glWindowPos2iv(Addressable v) {
    glut_h.glWindowPos2iv(v);
  }

  public void glWindowPos2ivARB(Addressable v) {
    glut_h.glWindowPos2ivARB(v);
  }

  public void glWindowPos2s(short x, short y) {
    glut_h.glWindowPos2s(x, y);
  }

  public void glWindowPos2sARB(short x, short y) {
    glut_h.glWindowPos2sARB(x, y);
  }

  public void glWindowPos2sv(Addressable v) {
    glut_h.glWindowPos2sv(v);
  }

  public void glWindowPos2svARB(Addressable v) {
    glut_h.glWindowPos2svARB(v);
  }

  public void glWindowPos3d(double x, double y, double z) {
    glut_h.glWindowPos3d(x, y, z);
  }

  public void glWindowPos3dARB(double x, double y, double z) {
    glut_h.glWindowPos3dARB(x, y, z);
  }

  public void glWindowPos3dv(Addressable v) {
    glut_h.glWindowPos3dv(v);
  }

  public void glWindowPos3dvARB(Addressable v) {
    glut_h.glWindowPos3dvARB(v);
  }

  public void glWindowPos3f(float x, float y, float z) {
    glut_h.glWindowPos3f(x, y, z);
  }

  public void glWindowPos3fARB(float x, float y, float z) {
    glut_h.glWindowPos3fARB(x, y, z);
  }

  public void glWindowPos3fv(Addressable v) {
    glut_h.glWindowPos3fv(v);
  }

  public void glWindowPos3fvARB(Addressable v) {
    glut_h.glWindowPos3fvARB(v);
  }

  public void glWindowPos3i(int x, int y, int z) {
    glut_h.glWindowPos3i(x, y, z);
  }

  public void glWindowPos3iARB(int x, int y, int z) {
    glut_h.glWindowPos3iARB(x, y, z);
  }

  public void glWindowPos3iv(Addressable v) {
    glut_h.glWindowPos3iv(v);
  }

  public void glWindowPos3ivARB(Addressable v) {
    glut_h.glWindowPos3ivARB(v);
  }

  public void glWindowPos3s(short x, short y, short z) {
    glut_h.glWindowPos3s(x, y, z);
  }

  public void glWindowPos3sARB(short x, short y, short z) {
    glut_h.glWindowPos3sARB(x, y, z);
  }

  public void glWindowPos3sv(Addressable v) {
    glut_h.glWindowPos3sv(v);
  }

  public void glWindowPos3svARB(Addressable v) {
    glut_h.glWindowPos3svARB(v);
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

  public void glutCheckLoop() {
    glut_h.glutCheckLoop();
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

  public MemoryAddress glutGetProcAddress(Addressable arg0) {
    return glut_h.glutGetProcAddress(arg0);
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

  public void glutSurfaceTexture(int arg0, int arg1, int arg2) {
    glut_h.glutSurfaceTexture(arg0, arg1, arg2);
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

  public void glutWMCloseFunc(Addressable arg0) {
    glut_h.glutWMCloseFunc(arg0);
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

}
