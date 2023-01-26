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
package panamagl.opengl;


import java.lang.foreign.Addressable;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.MemorySession;
import java.lang.foreign.SegmentAllocator;


/**
 * A base GL interface for Panama based OpenGL binding.
 * 
 * @author Martin Pernollet
 */
public interface GL {
    MemorySession getScope();
    SegmentAllocator getAllocator();
    MemorySegment alloc(double[] value);
    MemorySegment alloc(float[] value);
    MemorySegment alloc(int[] value);
    MemorySegment alloc(String value);


    // General GL -----------------------

    void glClearColor(float r, float g, float b, float a);
    void glClearDepth(float depth);
    void glClear(int mask);
    String glGetString(int stringID);
    
    String gluErrorString(int err_string);
    int glGetError();


    // FBO ------------------------------

    void glGenTextures(int size, MemorySegment ids);
    void glBindTexture(int textureType, int textureId);
    void glTexParameteri(int target, int pname, int param);

    /**
     * https://registry.khronos.org/OpenGL-Refpages/gl4/html/glTexImage2D.xhtml
     * @param texture
     * @param level
     * @param internalFormat
     * @param width
     * @param height
     * @param border
     * @param format
     * @param type
     * @param pixels
     */
    void glTexImage2D(int texture, int level, int internalFormat, int width, int height, int border, int format, int type, MemorySegment pixels);
    void glGenFramebuffers(int id, MemorySegment frameBuffer);
    void glBindFramebuffer(int frameExt, int frameBufferId);
    void glFramebufferTexture2D(int frameBufferExt, int colorAttachement, int texture, int textureId, int level);
    void glGenRenderbuffers(int n, MemorySegment depthRb);
    void glBindRenderbuffer(int renderBufferExt, int depthRbId);
    void glRenderbufferStorage(int renderBufferExt, int depthComponent, int width, int height);
    void glFramebufferRenderbuffer(int frameBufferExt, int depthAttachmentExt, int renderBufferExt, int depthRbId);
    void glReadPixels(int x, int y, int width, int height, int format, int type, MemorySegment pixelsRead);
    int glCheckFramebufferStatus(int frameBufferExt);

    void glDeleteTextures(int size, Addressable textureBuffers);
    void glDeleteRenderbuffers(int size, Addressable renderBuffers);
    void glDeleteFramebuffers(int size, Addressable frameBuffers);
    
    void glShadeModel(int model);
    void glEnable(int id);
    void glLoadIdentity();
    void glTranslatef(float x, float y, float z);
    void glRotatef(float rotate, float x, float y, float z);
    void glBegin(int id);
    void glColor3f(float r, float g, float b);
    void glVertex3f(float x, float y, float z);
    void glEnd();
    void glDepthFunc(int f);
    void glHint(int h, int val);
    void glMatrixMode(int p);
    void glFrustum(float f, float fw, float g, float fh, float h, float i);
    void glViewport(int x, int y, int width, int height);
    void glLightfv(int id, int p, MemorySegment pos);
    void glMaterialfv(int id, int shine, MemorySegment shini);
    void glPushMatrix();
    void glutSolidTeapot(double d);
    void glPopMatrix();



    // TODO : how to generate this convenient wrapper in interface AND implementations?
    // TODO : how to load them as constants instead of methods, to remain consistent with JOGL?
    int GL_TEXTURE_2D();
    int GL_TEXTURE_WRAP_S();
    int GL_REPEAT();
    int GL_TEXTURE_WRAP_T();
    int GL_TEXTURE_MIN_FILTER();
    int GL_TEXTURE_MAG_FILTER();
    int GL_NEAREST();
    int GL_RGBA8();
    int GL_BGRA();
    int GL_UNSIGNED_BYTE();
    int GL_FRAMEBUFFER();
    int GL_COLOR_ATTACHMENT0();
    int GL_RENDERBUFFER();
    int GL_DEPTH_COMPONENT24();
    int GL_DEPTH_ATTACHMENT();
    int GL_COLOR_BUFFER_BIT();
    int GL_DEPTH_BUFFER_BIT();
    int GL_BYTE();
    int GL_FRAMEBUFFER_COMPLETE();
    int GL_PROJECTION();
    int GL_MODELVIEW();
    int GL_QUADS();
    int GL_SMOOTH();
    int GL_DEPTH_TEST();
    int GL_LEQUAL();
    int GL_PERSPECTIVE_CORRECTION_HINT();
    int GL_NICEST();
    int GL_POSITION();
    int GL_LIGHT0();
    int GL_AMBIENT();
    int GL_DIFFUSE();
    int GL_SPECULAR();
    int GL_FRONT();
    int GL_SHININESS();
    int GL_LIGHTING();
}

