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
import java.nio.FloatBuffer;
import java.nio.IntBuffer;


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
    int GL_LIGHT1();
    int GL_LIGHT2();
    int GL_LIGHT3();
    int GL_LIGHT4();
    int GL_LIGHT5();
    int GL_LIGHT6();
    int GL_LIGHT7();
    int GL_AMBIENT();
    int GL_DIFFUSE();
    int GL_SPECULAR();
    int GL_FRONT();
    int GL_SHININESS();
    int GL_LIGHTING();
    
    void glScalef(float x, float y, float z);
    void glDisable(int type);
    void glPointSize(float width);
    void glLineWidth(float width);
    void glColor4f(float r, float g, float b, float a);
    void glVertex3d(double x, double y, double z);
    void glFrontFace(int mode);
    void glCullFace(int mode);
    void glPolygonMode(int frontOrBack, int fill);
    /**
     * @see {@link #glEnable_PolygonOffsetFill()}
     */
    void glPolygonOffset(float factor, float units);
    void glLineStipple(int factor, short pattern);
    void glTexCoord2f(float s, float t);
    void glTexEnvf(int target, int pname, float param);
    void glTexEnvi(int target, int pname, int param);
    void glRasterPos3f(float x, float y, float z);
    void glPixelZoom(float xfactor, float yfactor);
    void glPixelStorei(int pname, int param);
    void glBitmap(int width, int height, float xorig, float yorig, float xmove, float ymove,
        byte[] bitmap, int bitmap_offset);
    /**
     * Process the given font length to further process alignement.
     *
     * Will only return a valid width for known {@link Font} (Helevetica and Times Roman).
     *
     * Getting text width of any string can be done {@link #getTextLengthInPixels(Font, String)}.
     */
    int glutBitmapLength(int font, String string);
    void glutBitmapString(int font, String string);
    int glGenLists(int range);
    void glNewList(int list, int mode);
    void glEndList();
    void glCallList(int list);
    boolean glIsList(int list);
    void glDeleteLists(int list, int range);
    void glStencilMask(int mask);
    void glPassThrough(float token);
    int glRenderMode(int mode);
    void glFeedbackBuffer(int size, int type, FloatBuffer buffer);
    void glClearStencil(int s);
    void glOrtho(double left, double right, double bottom, double top, double near_val,
        double far_val);
    void gluOrtho2D(double left, double right, double bottom, double top);
    void gluPerspective(double fovy, double aspect, double zNear, double zFar);
    void glFrustum(double left, double right, double bottom, double top, double zNear, double zFar);
    void gluLookAt(float eyeX, float eyeY, float eyeZ, float centerX, float centerY, float centerZ,
        float upX, float upY, float upZ);
    void glClipPlane(int plane, double[] equation);
    void glEnable_ClipPlane(int plane);
    void glDisable_ClipPlane(int plane);
    /** Return the GL clip plane ID according to an ID in [0;5]*/
    int clipPlaneId(int id);
    boolean gluUnProject(float winX, float winY, float winZ, float[] model, int model_offset,
        float[] proj, int proj_offset, int[] view, int view_offset, float[] objPos,
        int objPos_offset);
    boolean gluProject(float objX, float objY, float objZ, float[] model, int model_offset,
        float[] proj, int proj_offset, int[] view, int view_offset, float[] winPos,
        int winPos_offset);
    void glGetIntegerv(int pname, int[] data, int data_offset);
    void glGetDoublev(int pname, double[] params, int params_offset);
    void glGetFloatv(int pname, float[] data, int data_offset);
    void glDepthRangef(float near, float far);
    void glBlendFunc(int sfactor, int dfactor);
    void glMaterialfv(int face, int pname, float[] params, int params_offset);
    void glNormal3f(float nx, float ny, float nz);
    void glLightf(int light, int pname, float value);
    void glLightfv(int light, int pname, float[] params, int params_offset);
    void glLight_Position(int lightId, float[] positionZero);
    void glLight_Shininess(int lightId, float value);
    void glEnable_Light(int light);
    void glDisable_Light(int light);
    void glLightModeli(int mode, int value);
    void glLightModelfv(int mode, float[] value);
    void glClearDepth(double d);
    void glInitNames();
    void glLoadName(int name);
    void glPushName(int name);
    void glPopName();
    void glSelectBuffer(int size, IntBuffer buffer);
    void gluPickMatrix(double x, double y, double delX, double delY, int[] viewport,
        int viewport_offset);
    void glFlush();
    void glEvalCoord2f(float u, float v);
    void glMap2f(int target, float u1, float u2, int ustride, int uorder, float v1, float v2,
        int vstride, int vorder, FloatBuffer points);
    int GL_BACK();
    int GL_VENDOR();
    int GL_VERSION();
    int GL_EXTENSIONS();
    int GL_LESS();
    int GL_SRC_ALPHA();
    int GL_BLEND();
    int GL_ALPHA_TEST();
    int GL_POLYGON_SMOOTH();
    int GL_LINE_SMOOTH();
    int GL_POINT_SMOOTH();
    int GL_VIEWPORT();
    int GL_PROJECTION_MATRIX();
    int GL_MODELVIEW_MATRIX();
    int GL_FRONT_AND_BACK();
    int GL_FILL();
    int GL_LINE();
    int GL_PACK_ALIGNMENT();
    int GL_UNPACK_ALIGNMENT();
    int GL_COMPILE();
    int GL_COMPILE_AND_EXECUTE();
    void glutSolidSphere(double radius, int slices, int stacks);
    void glutSolidTeapot(float scale);
    void glutWireTeapot(float scale);
    void gluSphere(double radius, int slices, int stacks);
    void gluCylinder(double base, double top, double height, int slices, int stacks);
    void glutSolidCube(float size);
    int GL_RENDER();
    int GL_SELECT();
    int GL_FEEDBACK();
    int GL_ALWAYS();
    int GL_EQUAL();
    int GL_TRUE();
    int GL_FALSE();
    int GL_DECR();
    int GL_INCR();
    int GL_INVERT();
    int GL_KEEP();
    int GL_REPLACE();
    int GL_ZERO();
    int GL_CLIP_PLANE0();
    int GL_CLIP_PLANE1();
    int GL_CLIP_PLANE2();
    int GL_CLIP_PLANE3();
    int GL_CLIP_PLANE4();
    int GL_CLIP_PLANE5();
    int GL_DEPTH_RANGE();
    int GL_FLAT();
    int GL_CONSTANT_ATTENUATION();
    int GL_LINEAR_ATTENUATION();
    int GL_QUADRATIC_ATTENUATION();
    int GL_LIGHT_MODEL_TWO_SIDE();
    int GL_LIGHT_MODEL_LOCAL_VIEWER();
    int GL_LIGHT_MODEL_AMBIENT();
    int GL_GREATER();
    int GL_GEQUAL();
    int GL_NEVER();
    int GL_NOTEQUAL();
    void glStencilOp(int int1, int int2, int int3);
    void glStencilFunc(int gl_GREATER, int ref, int mask);
    
    int GL_LINE_STIPPLE();
    int GL_POLYGON();
    int GL_TRIANGLES();
    int GL_POINTS();
    int GL_LINE_STRIP();
    int GL_LINE_LOOP();
    int GL_LINES();
    int GL_CULL_FACE();
    int GL_CCW();
    int GL_COLOR_MATERIAL();
    int GL_POINT_SMOOTH_HINT();
    int GL_STENCIL();
    int GL_POLYGON_OFFSET_LINE();
    int GL_POLYGON_OFFSET_FILL();
    int GL_ONE_MINUS_SRC_ALPHA();

}

