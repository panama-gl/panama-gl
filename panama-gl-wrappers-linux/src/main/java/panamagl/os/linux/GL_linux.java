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
package panamagl.os.linux;


import java.lang.foreign.Addressable;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import opengl.ubuntu.v20.glut_h;
import panamagl.opengl.AbstractGL;
import panamagl.opengl.GL;

/**
 * Look above ^^ this is how you link to platform binding.
 */
public class GL_linux extends AbstractGL implements GL  {
    public GL_linux() {
        this(false);
    }

    public GL_linux(boolean forceLoadGlut){
        super();
    }
    
    @Override
    public String gluErrorString(int err_string) {
      return glut_h.gluErrorString(err_string).toString();
    }
    
    @Override
    public int glGetError() {
      return glut_h.glGetError();
    }

    @Override
    public String glGetString(int stringID){
        return glut_h.glGetString(stringID).getUtf8String(0);
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
    public void glTexImage2D(int texture, int level, int internalFormat, int width, int height, int border, int format, int type, MemorySegment pixels){
        glut_h.glTexImage2D(texture, level, internalFormat, width, height, border, format, type, pixels);
    }

    @Override
    public void glTexParameteri(int target, int pname, int param) {
        glut_h.glTexParameteri(target, pname, param);

    }

    @Override
    public void glGenFramebuffers(int id, MemorySegment frameBuffer){
     // glut_h.glGenFramebuffers(1, frameBuffer);

    }

    @Override
    public void glBindFramebuffer(int frameExt, int frameBufferId){
      //glut_h.glBindFramebuffer(frameExt, frameBufferId);
    }

    @Override
    public void glFramebufferTexture2D(int frameBufferExt, int colorAttachement, int texture, int textureId, int level){
        //glut_h.glFramebufferTexture2D(frameBufferExt, colorAttachement, texture, textureId, level);
    }

    @Override
    public void glGenRenderbuffers(int n, MemorySegment depthRb){
        //glut_h.glGenRenderbuffers(1, depthRb);
    }

    @Override
    public void glBindRenderbuffer(int renderBufferExt, int depthRbId){
        //glut_h.glBindRenderbuffer(renderBufferExt, depthRbId);
    }

    @Override
    public void glRenderbufferStorage(int renderBufferExt, int depthComponent, int width, int height){
        //glut_h.glRenderbufferStorage(renderBufferExt, depthComponent, width, height);
    }

    @Override
    public void glFramebufferRenderbuffer(int frameBufferExt, int depthAttachmentExt, int renderBufferExt, int depthRbId){
        //glut_h.glFramebufferRenderbuffer(frameBufferExt, depthAttachmentExt, renderBufferExt, depthRbId);
    }

    @Override
    public int glCheckFramebufferStatus(int frameBufferExt){
      return -1;
        //return glut_h.glCheckFramebufferStatus(frameBufferExt);
    }

    @Override
    public void glDeleteTextures(int size, Addressable textureBuffers) {
        glut_h.glDeleteTextures(size, textureBuffers);

    }

    @Override
    public void glDeleteRenderbuffers(int size, Addressable renderBuffers) {
        //glut_h.glDeleteRenderbuffers(size, renderBuffers);

    }

    @Override
    public void glDeleteFramebuffers(int size, Addressable frameBuffers) {
        //glut_h.glDeleteFramebuffers(size, frameBuffers);
    }

    @Override
    public void glReadPixels(int x, int y, int width, int height, int format, int type, MemorySegment pixelsRead){
        glut_h.glReadPixels(x, y, width, height, format, type, pixelsRead);
    }

    @Override
    public void glClearDepth(float depth){
        glut_h.glClearDepth(depth);
    }


    // CONSTANTS ---------------------------

    @Override
    public int GL_TEXTURE_2D(){return glut_h.GL_TEXTURE_2D();}
    @Override
    public int GL_TEXTURE_WRAP_S(){return glut_h.GL_TEXTURE_WRAP_S();}
    @Override
    public int GL_REPEAT(){return glut_h.GL_REPEAT();}
    @Override
    public int GL_TEXTURE_WRAP_T(){return glut_h.GL_TEXTURE_WRAP_T();}
    @Override
    public int GL_TEXTURE_MIN_FILTER(){return glut_h.GL_TEXTURE_MIN_FILTER();}
    @Override
    public int GL_TEXTURE_MAG_FILTER(){return glut_h.GL_TEXTURE_MAG_FILTER();}
    @Override
    public int GL_NEAREST(){return glut_h.GL_NEAREST();}
    @Override
    public int GL_RGBA8(){return glut_h.GL_RGBA8();}
    @Override
    public int GL_BGRA(){return glut_h.GL_BGRA();}
    @Override
    public int GL_FRAMEBUFFER(){return glut_h.GL_FRAMEBUFFER();}
    @Override
    public int GL_COLOR_ATTACHMENT0(){return glut_h.GL_COLOR_ATTACHMENT0();}
    @Override
    public int GL_RENDERBUFFER(){return glut_h.GL_RENDERBUFFER();}
    @Override
    public int GL_DEPTH_COMPONENT24(){return glut_h.GL_DEPTH_COMPONENT24();}
    @Override
    public int GL_DEPTH_ATTACHMENT(){return glut_h.GL_DEPTH_ATTACHMENT();}
    @Override
    public int GL_COLOR_BUFFER_BIT(){return glut_h.GL_COLOR_BUFFER_BIT();}
    @Override
    public int GL_DEPTH_BUFFER_BIT(){return glut_h.GL_DEPTH_BUFFER_BIT();}
    @Override
    public int GL_BYTE(){return glut_h.GL_BYTE();}
    @Override
    public int GL_UNSIGNED_BYTE(){return glut_h.GL_UNSIGNED_BYTE();}
    @Override
    public int GL_FRAMEBUFFER_COMPLETE(){return glut_h.GL_FRAMEBUFFER_COMPLETE();}


    @Override
    public int GL_PROJECTION() {
      // TODO Auto-generated method stub
      return 0;
    }

    @Override
    public int GL_MODELVIEW() {
      // TODO Auto-generated method stub
      return 0;
    }

    @Override
    public int GL_QUADS() {
      // TODO Auto-generated method stub
      return 0;
    }

    @Override
    public int GL_SMOOTH() {
      // TODO Auto-generated method stub
      return 0;
    }


    
    @Override
    public void glLoadIdentity() {
      glut_h.glLoadIdentity();
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

    
    
    
    @Override
    public void glScalef(float x, float y, float z) {
      glut_h.glScalef(x, y, z);
    }

    @Override
    public void glTranslatef(float x, float y, float z) {
      glut_h.glTranslatef(x, y, z);
    }

    @Override
    public void glRotatef(float angle, float x, float y, float z) {
      glut_h.glRotatef(angle, x, y, z);
    }

    @Override
    public void glEnable(int type) {
      glut_h.glEnable(type);
    }

    @Override
    public void glDisable(int type) {
      glut_h.glDisable(type);
    }

    // GL GEOMETRY

    @Override
    public void glPointSize(float width) {
      glut_h.glPointSize(width);
    }

    @Override
    public void glLineWidth(float width) {
      glut_h.glLineWidth(width);
    }

    @Override
    public void glBegin(int type) {
      glut_h.glBegin(type);
    }

    @Override
    public void glColor3f(float r, float g, float b) {
      glut_h.glColor3f(r, b, b);
    }

    @Override
    public void glColor4f(float r, float g, float b, float a) {
      glut_h.glColor4f(r, g, b, a);
    }

    @Override
    public void glVertex3f(float x, float y, float z) {
      glut_h.glVertex3f(x, y, z);
    }

    @Override
    public void glVertex3d(double x, double y, double z) {
      glut_h.glVertex3d(x, y, z);
    }

    @Override
    public void glEnd() {
      glut_h.glEnd();
    }

    @Override
    public void glFrontFace(int mode) {
      glut_h.glFrontFace(mode);
    }

    @Override
    public void glCullFace(int mode) {
      glut_h.glCullFace(mode);
    }

    @Override
    public void glPolygonMode(int frontOrBack, int fill) {
      glut_h.glPolygonMode(frontOrBack, fill);
    }

    /**
     * @see {@link #glEnable_PolygonOffsetFill()}
     */
    @Override
    public void glPolygonOffset(float factor, float units) {
      glut_h.glPolygonOffset(factor, units); 
    }

    String OFFSET_FILL_NOT_IMPLEMENTED = "not in jopengl.glut_h. \n"
        + "Was added to OpenGL 2 (https://www.khronos.org/registry/OpenGL-Refpages/gl4/html/glPolygonOffset.xhtml). \n"
        + "You may desactivate offset fill with drawable.setPolygonOffsetFillEnable(false). \n"
        + "More here : https://github.com/jzy3d/jGL/issues/3";

    @Override
    public void glLineStipple(int factor, short pattern) {
      glut_h.glLineStipple(factor, pattern);
    }

    // GL TEXTURE

    @Override
    public void glTexCoord2f(float s, float t) {
      glut_h.glTexCoord2f(s, t);
    }

    @Override
    public void glTexEnvf(int target, int pname, float param) {
      glut_h.glTexEnvf(target, pname, param);
    }

    @Override
    public void glTexEnvi(int target, int pname, int param) {
      glut_h.glTexEnvi(target, pname, param);
    }

    @Override
    public void glRasterPos3f(float x, float y, float z) {
      glut_h.glRasterPos3f(x, y, z);
    }


    @Override
    public void glPixelZoom(float xfactor, float yfactor) {
     if (xfactor != 1 || yfactor != 1)
       throw new RuntimeException("x:" + xfactor + "y:" + yfactor);
     //glut_h.glPixelZoom(xfactor, yfactor);

    }

    @Override
    public void glPixelStorei(int pname, int param) {
      glut_h.glPixelStorei(pname, param);
    }

    @Override
    public void glBitmap(int width, int height, float xorig, float yorig, float xmove, float ymove,
        byte[] bitmap, int bitmap_offset) {
      throw new RuntimeException("not implemented");
      //glut_h.glBitmap(width, height, xorig, yorig, xmove, ymove, bitmap,
      // bitmap_offset);
    }


    // elements of GL spec picked in JOGL GL interface
    public static final int GL_RGBA = 0x1908;
    public static final int GL_UNSIGNED_BYTE = 0x1401;

    /* ****************************** TEXT *********************************/

    /**
     * Process the given font length to further process alignement.
     *
     * Will only return a valid width for known {@link Font} (Helevetica and Times Roman).
     *
     * Getting text width of any string can be done {@link #getTextLengthInPixels(Font, String)}.
     */
    @Override
    public int glutBitmapLength(int font, String string) {
      /*if (font == Font.BITMAP_HELVETICA_12) {
        return 6 * string.length();
      } else if (font == Font.BITMAP_HELVETICA_18) {
        return 9 * string.length();
      } else if (font == Font.BITMAP_TIMES_ROMAN_10) {
        return 5 * string.length();
      } else if (font == Font.BITMAP_TIMES_ROMAN_24) {
        return 12 * string.length();
      }
      return 6 * string.length();*/
      return -1;
    }



    @Override
    public void glutBitmapString(int font, String string) {
      //logger.error("glutBitmapString : not available in generated code");
      //opengl.glut_h.glutBitmapString(font, alloc(string));

      // Use freeglut
      ///opt/X11/include/GL/freeglut.h
    }

    // GL LISTS

    @Override
    public int glGenLists(int range) {
      return glut_h.glGenLists(range);
    }

    @Override
    public void glNewList(int list, int mode) {
      glut_h.glNewList(list, mode);
    }


    @Override
    public void glEndList() {
      glut_h.glEndList();
    }

    @Override
    public void glCallList(int list) {
      glut_h.glCallList(list);
    }

    @Override
    public boolean glIsList(int list) {
      //logger.error("to be implemented");
      throw new RuntimeException("to be implemented");
      // opengl.glut_h.glIsList(list);
    }

    @Override
    public void glDeleteLists(int list, int range) {
      glut_h.glDeleteLists(list, range);
    }

    // GLU

    /*@Override
    public void gluDisk(double inner, double outer, int slices, int loops) {
      logger.error("to be implemented");

      // GLUquadricObj qobj = opengl.glut_h.gluNewQuadric();
      // qobj.Normals = opengl.glut_h.GLU_NONE(); // https://github.com/jzy3d/jzy3d-api/issues/179
      // opengl.glut_h.gluDisk(qobj, inner, outer, slices, loops);
    }*/

    @Override
    public void glutSolidSphere(double radius, int slices, int stacks) {
      glut_h.glutSolidSphere(radius, slices, stacks);
    }

    @Override
    public void glutSolidTeapot(float scale) {
      glut_h.glutSolidTeapot(scale);
    }

    @Override
    public void glutWireTeapot(float scale) {
      glut_h.glutWireTeapot(scale);
    }

    @Override
    public void gluSphere(double radius, int slices, int stacks) {
      throw new RuntimeException("to be implemented");
      //logger.error("to be implemented");
      // GLUquadricObj qobj = opengl.glut_h.gluNewQuadric();
      // opengl.glut_h.gluSphere(qobj, radius, slices, stacks);
    }

    @Override
    public void gluCylinder(double base, double top, double height, int slices, int stacks) {
      throw new RuntimeException("to be implemented");

      // GLUquadricObj qobj = opengl.glut_h.gluNewQuadric();
      // opengl.glut_h.gluCylinder(qobj, base, top, height, slices, stacks);
    }

    @Override
    public void glutSolidCube(float size) {
      glut_h.glutSolidCube(size);

    }

    // GL FEEDBACK BUFER

    @Override
    public void glFeedbackBuffer(int size, int type, FloatBuffer buffer) {
      glut_h.glFeedbackBuffer(size, type, alloc(buffer.array()));
    }

    @Override
    public int glRenderMode(int mode) {
      return glut_h.glRenderMode(mode);
    }

    @Override
    public void glPassThrough(float token) {
      glut_h.glPassThrough(token);
    }



    @Override
    public void glStencilMask(int mask) {
      glut_h.glStencilMask(mask);
    }

    @Override
    public void glClearStencil(int s) {
      glut_h.glClearStencil(s);
    }


    // GL VIEWPOINT

    @Override
    public void glOrtho(double left, double right, double bottom, double top, double near_val, double far_val) {
      glut_h.glOrtho(left, right, bottom, top, near_val, far_val);
    }

    @Override
    public void gluOrtho2D(double left, double right, double bottom, double top) {
      glut_h.gluOrtho2D(left, right, bottom, top);
    }

    @Override
    public void gluPerspective(double fovy, double aspect, double zNear, double zFar) {
      glut_h.gluPerspective(fovy, aspect, zNear, zFar);
    }

    @Override
    public void glFrustum(double left, double right, double bottom, double top, double zNear, double zFar) {
      glut_h.glFrustum(left, right, bottom, top, zNear, zFar);
    }

    @Override
    public void gluLookAt(float eyeX, float eyeY, float eyeZ, float centerX, float centerY, float centerZ, float upX,
        float upY, float upZ) {
      glut_h.gluLookAt(eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ);
    }

    @Override
    public void glViewport(int x, int y, int width, int height) {
      glut_h.glViewport(x, y, width, height);
    }

    @Override
    public void glClipPlane(int plane, double[] equation) {
      glut_h.glClipPlane(clipPlaneId(plane), alloc(equation));
    }

    @Override
    public void glEnable_ClipPlane(int plane) {
      glut_h.glEnable(clipPlaneId(plane));
    }

    @Override
    public void glDisable_ClipPlane(int plane) {
      glut_h.glDisable(clipPlaneId(plane));
    }
    
    /** Return the GL clip plane ID according to an ID in [0;5]*/
    @Override
    public int clipPlaneId(int id) {
      switch (id) {
        case 0:
          return glut_h.GL_CLIP_PLANE0();
        case 1:
          return glut_h.GL_CLIP_PLANE1();
        case 2:
          return glut_h.GL_CLIP_PLANE2();
        case 3:
          return glut_h.GL_CLIP_PLANE3();
        case 4:
          return glut_h.GL_CLIP_PLANE4();
        case 5:
          return glut_h.GL_CLIP_PLANE5();
        default:
          throw new IllegalArgumentException("Expect a plane ID in [0;5]");
      }
    }


    @Override
    public boolean gluUnProject(float winX, float winY, float winZ, float[] model, int model_offset, float[] proj,
        int proj_offset, int[] view, int view_offset, float[] objPos, int objPos_offset) {
      // throw new NotImplementedException();

      double objX[] = new double[1];
      double objY[] = new double[1];
      double objZ[] = new double[1];

      int st = glut_h.gluUnProject((double)winX, (double)winY, (double)winZ, alloc(dbl(model)), alloc(dbl(proj)), alloc(view), alloc(objX), alloc(objY), alloc(objZ));

      objPos[0] = (float) objX[0];
      objPos[1] = (float) objY[0];
      objPos[2] = (float) objZ[0];

      return st == 1;
    }

    protected double[] dbl(float[] values) {
      double[] dbl = new double[values.length];
      for (int i = 0; i < values.length; i++) {
        dbl[i] = values[i];
      }
      return dbl;
    }

    @Override
    public boolean gluProject(float objX, float objY, float objZ, float[] model, int model_offset,
        float[] proj, int proj_offset, int[] view, int view_offset, float[] winPos,
        int winPos_offset) {
      // throw new NotImplementedException();
      // opengl.glut_h.gluProject(objx, objy, objz, model, proj, viewport, winx, winy,
      // winz)

      double[] modelD = new double[model.length];
      for (int i = 0; i < model.length; i++) {
        modelD[i] = model[i];
      }

      // double[] winy = new double[1];
      // double[] winz = new double[1];

      double[] projD = new double[proj.length];
      for (int i = 0; i < proj.length; i++) {
        projD[i] = proj[i];
      }

      double[] winx = new double[1];
      double[] winy = new double[1];
      double[] winz = new double[1];

      int out = glut_h.gluProject(objX, objY, objZ, alloc(modelD), alloc(projD), alloc(view), alloc(winx), alloc(winy), alloc(winz));

      // winPos[0], winPos[1], winPos[2];
      winPos[0] = (float) winx[0];
      winPos[1] = (float) winy[0];
      winPos[2] = (float) winz[0];

      return out == 1;
    }

    // GL GET

    @Override
    public void glGetIntegerv(int pname, int[] data, int data_offset) {
      glut_h.glGetIntegerv(pname, alloc(data));
    }

    @Override
    public void glGetDoublev(int pname, double[] params, int params_offset) {
      glut_h.glGetDoublev(pname, alloc(params));
    }

    @Override
    public void glGetFloatv(int pname, float[] data, int data_offset) {
      glut_h.glGetFloatv(pname, alloc(data));
    }

    @Override
    public void glDepthFunc(int func) {
      glut_h.glDepthFunc(func);
    }

    @Override
    public void glDepthRangef(float near, float far) {
      // printGLDepthRange();
      glut_h.glDepthRange(near, far);
    }

    @Override
    public void glBlendFunc(int sfactor, int dfactor) {
      glut_h.glBlendFunc(sfactor, dfactor);
    }

    @Override
    public void glHint(int target, int mode) {
      throw new RuntimeException(
          "not in jopengl.glut_h. https://www.khronos.org/registry/OpenGL-Refpages/gl2.1/xhtml/glHint.xml");
      // opengl.glut_h.glHint(target, mode);

    }

    // GL LIGHTS

    @Override
    public void glShadeModel(int mode) {
      glut_h.glShadeModel(mode);
    }

    /*@Override
    public void glShadeModel_Smooth() {
      glut_h.glShadeModel(glut_h.GL_SMOOTH());
    }

    @Override
    public void glShadeModel_Flat() {
      glut_h.glShadeModel(glut_h.GL_FLAT());
    }*/

    @Override
    public void glMaterialfv(int face, int pname, float[] params, int params_offset) {
      glut_h.glMaterialfv(face, pname, alloc(params));
    }

    @Override
    public void glNormal3f(float nx, float ny, float nz) {
      glut_h.glNormal3f(nx, ny, nz);
    }

    /*@Override
    public void glLightf(int light, Attenuation.Type attenuationType, float value) {
      if (Attenuation.Type.CONSTANT.equals(attenuationType)) {
        glLightf(light, glut_h.GL_CONSTANT_ATTENUATION(), value);
      } else if (Attenuation.Type.LINEAR.equals(attenuationType)) {
        glLightf(light, glut_h.GL_LINEAR_ATTENUATION(), value);
      } else if (Attenuation.Type.QUADRATIC.equals(attenuationType)) {
        glLightf(light, glut_h.GL_QUADRATIC_ATTENUATION(), value);
      }
    }*/

    @Override
    public void glLightf(int light, int pname, float value) {
      glut_h.glLightf(lightId(light), pname, value);
    }

    @Override
    public void glLightfv(int light, int pname, float[] params, int params_offset) {
      glut_h.glLightfv(lightId(light), pname, alloc(params));
    }

    @Override
    public void glLight_Position(int lightId, float[] positionZero) {
      glLightfv(lightId, glut_h.GL_POSITION(), positionZero, 0);
    }

    @Override
    public void glLight_Shininess(int lightId, float value) {
      glLightf(lightId, glut_h.GL_SHININESS(), value);
    }

    @Override
    public void glEnable_Light(int light) {
      glEnable(lightId(light));
    }

    @Override
    public void glDisable_Light(int light) {
      glEnable(lightId(light));
    }

    protected int lightId(int id) {
      switch (id) {
      case 0:
        return glut_h.GL_LIGHT0();
      case 1:
        return glut_h.GL_LIGHT1();
      case (2):
        return glut_h.GL_LIGHT2();
      case 3:
        return glut_h.GL_LIGHT3();
      case 4:
        return glut_h.GL_LIGHT4();
      case 5:
        return glut_h.GL_LIGHT5();
      case 6:
        return glut_h.GL_LIGHT6();
      case 7:
        return glut_h.GL_LIGHT7();
      }
      throw new IllegalArgumentException("Unsupported light ID '" + id + "'");
    }

    @Override
    public void glLightModeli(int mode, int value) {
      glut_h.glLightModeli(mode, value);
    }

    @Override
    public void glLightModelfv(int mode, float[] value) {
      glut_h.glLightModelfv(mode, alloc(value));
    }

    // GL OTHER

    @Override
    public void glClearColor(float red, float green, float blue, float alpha) {
      glut_h.glClearColor(red, green, blue, alpha);
    }

    @Override
    public void glClearDepth(double d) {
      glut_h.glClearDepth(d);
    }

    @Override
    public void glClear(int mask) {
      glut_h.glClear(mask);
    }

    // GL PICKING

    @Override
    public void glInitNames() {
      glut_h.glInitNames();
    }

    @Override
    public void glLoadName(int name) {
      glut_h.glLoadName(name);
    }

    @Override
    public void glPushName(int name) {
      glut_h.glPushName(name);
    }

    @Override
    public void glPopName() {
      glut_h.glPopName();
    }

    @Override
    public void glSelectBuffer(int size, IntBuffer buffer) {
      glut_h.glSelectBuffer(size, allocator.allocateArray(ValueLayout.JAVA_INT, buffer.array()));
    }

    @Override
    public void gluPickMatrix(double x, double y, double delX, double delY, int[] viewport, int viewport_offset) {
      glut_h.gluPickMatrix(x, y, delX, delY, allocator.allocateArray(ValueLayout.JAVA_INT, viewport));
    }

    @Override
    public void glFlush() {
      glut_h.glFlush();
    }

    @Override
    public void glEvalCoord2f(float u, float v) {
      glut_h.glEvalCoord2f(u, v);
    }

    @Override
    public void glMap2f(int target, float u1, float u2, int ustride, int uorder, float v1, float v2, int vstride,
        int vorder, FloatBuffer points) {
      throw new RuntimeException("NEED TO CONVERT FloatBuffer to float[][][]");
      // opengl.glut_h.glMap2f(target, u1, u2, ustride, uorder, v1, v2, vstride,
      // vorder, points);
      // (target, u1, u2, ustride, uorder, v1, v2, vstride, vorder, points);
    }

    @Override
    public int GL_BACK() {
      return glut_h.GL_BACK();
    }


    @Override
    public int GL_VENDOR() {
      return glut_h.GL_VENDOR();
    }


    @Override
    public int GL_VERSION() {
      return glut_h.GL_VERSION();
    }


    @Override
    public int GL_EXTENSIONS() {
      return glut_h.GL_EXTENSIONS();
    }


    @Override
    public int GL_LESS() {
      return glut_h.GL_LESS();
    }


    @Override
    public int GL_SRC_ALPHA() {
      return glut_h.GL_SRC_ALPHA();
    }


    @Override
    public int GL_BLEND() {
      return glut_h.GL_BLEND();
    }


    @Override
    public int GL_ALPHA_TEST() {
      return glut_h.GL_ALPHA_TEST();
    }


    @Override
    public int GL_POLYGON_SMOOTH() {
      return glut_h.GL_POLYGON_SMOOTH();
    }


    @Override
    public int GL_LINE_SMOOTH() {
      return glut_h.GL_LINE_SMOOTH();
    }


    @Override
    public int GL_POINT_SMOOTH() {
      return glut_h.GL_POINT_SMOOTH();
    }


    @Override
    public int GL_VIEWPORT() {
      return glut_h.GL_VIEWPORT();
    }


    @Override
    public int GL_PROJECTION_MATRIX() {
      return glut_h.GL_PROJECTION_MATRIX();
    }


    @Override
    public int GL_MODELVIEW_MATRIX() {
      return glut_h.GL_MODELVIEW_MATRIX();
    }


    @Override
    public int GL_FRONT_AND_BACK() {
      return glut_h.GL_FRONT_AND_BACK();
    }


    @Override
    public int GL_FILL() {
      return glut_h.GL_FILL();
    }


    @Override
    public int GL_LINE() {
      return glut_h.GL_LINE();
    }


    @Override
    public int GL_PACK_ALIGNMENT() {
      return glut_h.GL_PACK_ALIGNMENT();
    }


    @Override
    public int GL_UNPACK_ALIGNMENT() {
      return glut_h.GL_UNPACK_ALIGNMENT();
    }


    @Override
    public int GL_COMPILE() {
      return glut_h.GL_COMPILE();
    }


    @Override
    public int GL_COMPILE_AND_EXECUTE() {
      return glut_h.GL_COMPILE_AND_EXECUTE();
    }

    @Override
    public int GL_LIGHT1() {
      
      return glut_h.GL_LIGHT1();
    }


    @Override
    public int GL_LIGHT2() {
      
      return glut_h.GL_LIGHT2();
    }


    @Override
    public int GL_LIGHT3() {
      
      return glut_h.GL_LIGHT3();
    }


    @Override
    public int GL_LIGHT4() {
      
      return glut_h.GL_LIGHT4();
    }


    @Override
    public int GL_LIGHT5() {
      
      return glut_h.GL_LIGHT5();
    }


    @Override
    public int GL_LIGHT6() {
      
      return glut_h.GL_LIGHT6();
    }


    @Override
    public int GL_LIGHT7() {
      
      return glut_h.GL_LIGHT7();
    }


    @Override
    public int GL_RENDER() {
      
      return glut_h.GL_RENDER();
    }


    @Override
    public int GL_SELECT() {
      
      return glut_h.GL_SELECT();
    }


    @Override
    public int GL_FEEDBACK() {
      
      return glut_h.GL_FEEDBACK();
    }


    @Override
    public int GL_ALWAYS() {
      
      return glut_h.GL_ALWAYS();
    }


    @Override
    public int GL_EQUAL() {
      
      return glut_h.GL_EQUAL();
    }


    @Override
    public int GL_TRUE() {
      
      return glut_h.GL_TRUE();
    }


    @Override
    public int GL_FALSE() {
      
      return glut_h.GL_FALSE();
    }


    @Override
    public int GL_DECR() {
      
      return glut_h.GL_DECR();
    }


    @Override
    public int GL_INCR() {
      
      return glut_h.GL_INCR();
    }


    @Override
    public int GL_INVERT() {
      
      return glut_h.GL_INVERT();
    }


    @Override
    public int GL_KEEP() {
      
      return glut_h.GL_KEEP();
    }


    @Override
    public int GL_REPLACE() {
      
      return glut_h.GL_REPLACE();
    }


    @Override
    public int GL_ZERO() {
      
      return glut_h.GL_ZERO();
    }


    @Override
    public int GL_CLIP_PLANE0() {
      
      return glut_h.GL_CLIP_PLANE0();
    }


    @Override
    public int GL_CLIP_PLANE1() {
      
      return glut_h.GL_CLIP_PLANE1();
    }


    @Override
    public int GL_CLIP_PLANE2() {
      
      return glut_h.GL_CLIP_PLANE2();
    }


    @Override
    public int GL_CLIP_PLANE3() {
      
      return glut_h.GL_CLIP_PLANE3();
    }


    @Override
    public int GL_CLIP_PLANE4() {
      
      return glut_h.GL_CLIP_PLANE4();
    }


    @Override
    public int GL_CLIP_PLANE5() {
      
      return glut_h.GL_CLIP_PLANE5();
    }


    @Override
    public int GL_DEPTH_RANGE() {
      return glut_h.GL_DEPTH_RANGE();
    }


    @Override
    public int GL_FLAT() {
      return glut_h.GL_FLAT();
    }


    @Override
    public int GL_CONSTANT_ATTENUATION() {
      return glut_h.GL_CONSTANT_ATTENUATION();
    }


    @Override
    public int GL_LINEAR_ATTENUATION() {
      
      return glut_h.GL_LINEAR_ATTENUATION();
    }


    @Override
    public int GL_QUADRATIC_ATTENUATION() {
      
      return glut_h.GL_QUADRATIC_ATTENUATION();
    }


    @Override
    public int GL_LIGHT_MODEL_TWO_SIDE() {
      
      return glut_h.GL_LIGHT_MODEL_TWO_SIDE();
    }


    @Override
    public int GL_LIGHT_MODEL_LOCAL_VIEWER() {
      
      return glut_h.GL_LIGHT_MODEL_LOCAL_VIEWER();
    }


    @Override
    public int GL_LIGHT_MODEL_AMBIENT() {
      
      return glut_h.GL_LIGHT_MODEL_AMBIENT();
    }


    @Override
    public int GL_GREATER() {
      
      return glut_h.GL_GREATER();
    }


    @Override
    public int GL_GEQUAL() {
      
      return glut_h.GL_GEQUAL();
    }


    @Override
    public int GL_NEVER() {
      
      return glut_h.GL_NEVER();
    }


    @Override
    public int GL_NOTEQUAL() {
      
      return glut_h.GL_NOTEQUAL();
    }


    @Override
    public void glStencilOp(int int1, int int2, int int3) {
      glut_h.glStencilOp(int1, int2, int3);
      
    }


    @Override
    public void glStencilFunc(int gl_GREATER, int ref, int mask) {
      glut_h.glStencilFunc(gl_GREATER, ref, mask);
      
    }
    
    @Override
    public int GL_LINE_STIPPLE() {
      return glut_h.GL_LINE_STIPPLE();
    }


    @Override
    public int GL_POLYGON() {
      return glut_h.GL_POLYGON();
    }


    @Override
    public int GL_TRIANGLES() {
      return glut_h.GL_TRIANGLES();
    }


    @Override
    public int GL_POINTS() {
      return glut_h.GL_POINTS();
    }


    @Override
    public int GL_LINE_STRIP() {
      return glut_h.GL_LINE_STRIP();
    }


    @Override
    public int GL_LINE_LOOP() {
      return glut_h.GL_LINE_LOOP();
    }


    @Override
    public int GL_LINES() {
      return glut_h.GL_LINES();
    }


    @Override
    public int GL_CULL_FACE() {
      return glut_h.GL_CULL_FACE();
    }


    @Override
    public int GL_CCW() {
      return glut_h.GL_CCW();
    }


    @Override
    public int GL_COLOR_MATERIAL() {
      return glut_h.GL_COLOR_MATERIAL();
    }


    @Override
    public int GL_POINT_SMOOTH_HINT() {
      return glut_h.GL_POINT_SMOOTH_HINT();
    }


    @Override
    public int GL_STENCIL() {
      return glut_h.GL_STENCIL();
    }


    @Override
    public int GL_POLYGON_OFFSET_LINE() {
      return glut_h.GL_POLYGON_OFFSET_LINE();
    }


    @Override
    public int GL_POLYGON_OFFSET_FILL() {
      return glut_h.GL_POLYGON_OFFSET_FILL();
    }
}
