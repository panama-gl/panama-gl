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
package panamagl.os.macos;


import java.lang.foreign.Addressable;
import java.lang.foreign.MemoryAddress;
import java.lang.foreign.MemorySegment;
import opengl.macos.v10_15_7.glut_h;
import panamagl.opengl.AbstractGL;
import panamagl.opengl.GL;

/**
 * Look above ^^ this is how you link to platform binding.
 */
public class GL_macOS extends AbstractGL implements GL {
  public GL_macOS() {
    super();
  }

  @Override
  public String gluErrorString(int err_string) {
    MemoryAddress a = glut_h.gluErrorString(err_string);
    return a.getUtf8String(0);
  }

  @Override
  public int glGetError() {
    return glut_h.glGetError();
  }

  @Override
  public String glGetString(int stringID) {
    MemoryAddress a = glut_h.glGetString(stringID);
    return a.getUtf8String(0);
  }

  @Override
  public void glGenTextures(int size, MemorySegment ids) {
    glut_h.glGenTextures(1, ids);
  }

  @Override
  public void glBindTexture(int textureType, int textureId) {
    glut_h.glBindTexture(glut_h.GL_TEXTURE_2D(), textureId);
  }

  @Override
  public void glTexImage2D(int texture, int level, int internalFormat, int width, int height,
      int border, int format, int type, MemorySegment pixels) {
    glut_h.glTexImage2D(texture, level, internalFormat, width, height, border, format, type,
        pixels);
  }

  @Override
  public void glTexParameteri(int target, int pname, int param) {
    glut_h.glTexParameteri(target, pname, param);
  }

  @Override
  public void glGenFramebuffers(int id, MemorySegment frameBuffer) {
    glut_h.glGenFramebuffers(1, frameBuffer);
  }

  @Override
  public void glBindFramebuffer(int frameExt, int frameBufferId) {
    glut_h.glBindFramebuffer(frameExt, frameBufferId);
  }

  @Override
  public void glFramebufferTexture2D(int frameBufferExt, int colorAttachement, int texture,
      int textureId, int level) {
    glut_h.glFramebufferTexture2D(frameBufferExt, colorAttachement, texture, textureId, level);
  }

  @Override
  public void glGenRenderbuffers(int n, MemorySegment depthRb) {
    glut_h.glGenRenderbuffers(1, depthRb);
  }

  @Override
  public void glBindRenderbuffer(int renderBufferExt, int depthRbId) {
    glut_h.glBindRenderbuffer(renderBufferExt, depthRbId);
  }

  @Override
  public void glRenderbufferStorage(int renderBufferExt, int depthComponent, int width,
      int height) {
    glut_h.glRenderbufferStorage(renderBufferExt, depthComponent, width, height);
  }

  @Override
  public void glFramebufferRenderbuffer(int frameBufferExt, int depthAttachmentExt,
      int renderBufferExt, int depthRbId) {
    glut_h.glFramebufferRenderbuffer(frameBufferExt, depthAttachmentExt, renderBufferExt,
        depthRbId);
  }

  @Override
  public int glCheckFramebufferStatus(int frameBufferExt) {
    return glut_h.glCheckFramebufferStatus(frameBufferExt);
  }

  @Override
  public void glDeleteTextures(int size, Addressable textureBuffers) {
    glut_h.glDeleteTextures(size, textureBuffers);

  }

  @Override
  public void glDeleteRenderbuffers(int size, Addressable renderBuffers) {
    glut_h.glDeleteRenderbuffers(size, renderBuffers);

  }

  @Override
  public void glDeleteFramebuffers(int size, Addressable frameBuffers) {
    glut_h.glDeleteFramebuffers(size, frameBuffers);
  }

  @Override
  public void glReadPixels(int x, int y, int width, int height, int format, int type,
      MemorySegment pixelsRead) {
    glut_h.glReadPixels(x, y, width, height, format, type, pixelsRead);
  }

  @Override
  public void glClearColor(float r, float g, float b, float a) {
    glut_h.glClearColor(r, g, b, a);
  }

  @Override
  public void glClearDepth(float depth) {
    glut_h.glClearDepth(depth);
  }

  @Override
  public void glClear(int mask) {
    glut_h.glClear(mask);
  }


  // CONSTANTS ---------------------------

  @Override
  public int GL_TEXTURE_2D() {
    return glut_h.GL_TEXTURE_2D();
  }

  @Override
  public int GL_TEXTURE_WRAP_S() {
    return glut_h.GL_TEXTURE_WRAP_S();
  }

  @Override
  public int GL_REPEAT() {
    return glut_h.GL_REPEAT();
  }

  @Override
  public int GL_TEXTURE_WRAP_T() {
    return glut_h.GL_TEXTURE_WRAP_T();
  }

  @Override
  public int GL_TEXTURE_MIN_FILTER() {
    return glut_h.GL_TEXTURE_MIN_FILTER();
  }

  @Override
  public int GL_TEXTURE_MAG_FILTER() {
    return glut_h.GL_TEXTURE_MAG_FILTER();
  }

  @Override
  public int GL_NEAREST() {
    return glut_h.GL_NEAREST();
  }

  @Override
  public int GL_RGBA8() {
    return glut_h.GL_RGBA8();
  }

  @Override
  public int GL_BGRA() {
    return glut_h.GL_BGRA();
  }

  @Override
  public int GL_FRAMEBUFFER() {
    return glut_h.GL_FRAMEBUFFER();
  }

  @Override
  public int GL_COLOR_ATTACHMENT0() {
    return glut_h.GL_COLOR_ATTACHMENT0();
  }

  @Override
  public int GL_RENDERBUFFER() {
    return glut_h.GL_RENDERBUFFER();
  }

  @Override
  public int GL_DEPTH_COMPONENT24() {
    return glut_h.GL_DEPTH_COMPONENT24();
  }

  @Override
  public int GL_DEPTH_ATTACHMENT() {
    return glut_h.GL_DEPTH_ATTACHMENT();
  }

  @Override
  public int GL_COLOR_BUFFER_BIT() {
    return glut_h.GL_COLOR_BUFFER_BIT();
  }

  @Override
  public int GL_DEPTH_BUFFER_BIT() {
    return glut_h.GL_DEPTH_BUFFER_BIT();
  }

  @Override
  public int GL_BYTE() {
    return glut_h.GL_BYTE();
  }

  @Override
  public int GL_UNSIGNED_BYTE() {
    return glut_h.GL_UNSIGNED_BYTE();
  }

  @Override
  public int GL_FRAMEBUFFER_COMPLETE() {
    return glut_h.GL_FRAMEBUFFER_COMPLETE();
  }

  @Override
  public int GL_PROJECTION() {
    return glut_h.GL_PROJECTION();
  }


  @Override
  public int GL_MODELVIEW() {
    return glut_h.GL_MODELVIEW();
  }

  @Override
  public int GL_QUADS() {
    return glut_h.GL_QUADS();
  }
  
  @Override
  public void glShadeModel(int model) {
    glut_h.glShadeModel(model);    
  }

  @Override
  public void glEnable(int id) {
    glut_h.glEnable(id);
  }

  @Override
  public int GL_SMOOTH() {
    return glut_h.GL_SMOOTH();
  }

  @Override
  public void glLoadIdentity() {
    glut_h.glLoadIdentity();
  }

  @Override
  public void glTranslatef(float x, float y, float z) {
    glut_h.glTranslatef(x, y, z);
  }

  @Override
  public void glRotatef(float rotate, float x, float y, float z) {
    glut_h.glRotatef(rotate, x, y, z);
  }

  @Override
  public void glBegin(int id) {
    glut_h.glBegin(id);
  }

  @Override
  public void glColor3f(float r, float g, float b) {
    glut_h.glColor3f(r, g, b);
  }

  @Override
  public void glVertex3f(float x, float y, float z) {
    glut_h.glVertex3f(x, y, z);
  }

  @Override
  public void glEnd() {
    glut_h.glEnd();
  }

  @Override
  public void glDepthFunc(int f) {
    glut_h.glDepthFunc(f);
  }

  @Override
  public void glHint(int h, int val) {
    glut_h.glHint(h, val);
  }

  @Override
  public void glMatrixMode(int p) {
    glut_h.glMatrixMode(p);
  }

  @Override
  public void glFrustum(float f, float fw, float g, float fh, float h, float i) {
    glut_h.glFrustum(f, fw, g, fh, h, i);
  }

  @Override
  public void glViewport(int x, int y, int width, int height) {
    glut_h.glViewport(x, y, width, height);
  }

  @Override
  public int GL_DEPTH_TEST() {
    return glut_h.GL_DEPTH_TEST();
  }

  @Override
  public int GL_LEQUAL() {
    return glut_h.GL_LEQUAL();
  }

  @Override
  public int GL_PERSPECTIVE_CORRECTION_HINT() {
    return glut_h.GL_PERSPECTIVE_CORRECTION_HINT();
  }

  @Override
  public int GL_NICEST() {
    return glut_h.GL_NICEST();
  }

  @Override
  public void glLightfv(int id, int p, MemorySegment pos) {
    glut_h.glLightfv(id, p, pos);
  }

  @Override
  public void glMaterialfv(int id, int shine, MemorySegment shini) {
    glut_h.glMaterialfv(id, shine, shini);
  }

  @Override
  public void glPushMatrix() {
    glut_h.glPushMatrix();
  }

  @Override
  public void glutSolidTeapot(double d) {
    glut_h.glutSolidTeapot(d);
  }

  @Override
  public void glPopMatrix() {
    glut_h.glPopMatrix();    
  }

  @Override
  public int GL_POSITION() {
    return glut_h.GL_POSITION();
  }

  @Override
  public int GL_LIGHT0() {
    return glut_h.GL_LIGHT0();
  }

  @Override
  public int GL_AMBIENT() {
    return glut_h.GL_AMBIENT();
  }

  @Override
  public int GL_DIFFUSE() {
    return glut_h.GL_DIFFUSE();
  }

  @Override
  public int GL_SPECULAR() {
    return glut_h.GL_SPECULAR();
  }

  @Override
  public int GL_FRONT() {
    return glut_h.GL_FRONT();
  }

  @Override
  public int GL_SHININESS() {
    return glut_h.GL_SHININESS();
  }

  @Override
  public int GL_LIGHTING() {
    return glut_h.GL_LIGHTING();
  }

  


}