package opengl.ubuntu;


import java.lang.foreign.Addressable;
import java.lang.foreign.MemorySegment;
import opengl.AbstractGL;
import opengl.GL;
import opengl.ubuntu.v20.glut_h;

/**
 * Look above ^^ this is how you link to platform binding.
 */
public class GL_Ubuntu_20 extends AbstractGL implements GL  {
    public GL_Ubuntu_20() {
        this(false);
    }

    public GL_Ubuntu_20(boolean forceLoadGlut){
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
    public void glClearColor(float r, float g, float b, float a){
        glut_h.glClearColor(r, g, b, a);
    }

    @Override
    public void glClearDepth(float depth){
        glut_h.glClearDepth(depth);
    }

    @Override
    public void glClear(int mask){
        glut_h.glClear(mask);
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
    public void glShadeModel(int model) {
      // TODO Auto-generated method stub
      
    }

    @Override
    public void glEnable(int id) {
      // TODO Auto-generated method stub
      
    }

    @Override
    public void glLoadIdentity() {
      // TODO Auto-generated method stub
      
    }

    @Override
    public void glTranslatef(float x, float y, float z) {
      // TODO Auto-generated method stub
      
    }

    @Override
    public void glRotatef(float rotate, float x, float y, float z) {
      // TODO Auto-generated method stub
      
    }

    @Override
    public void glBegin(int id) {
      // TODO Auto-generated method stub
      
    }

    @Override
    public void glColor3f(float r, float g, float b) {
      // TODO Auto-generated method stub
      
    }

    @Override
    public void glVertex3f(float x, float y, float z) {
      // TODO Auto-generated method stub
      
    }

    @Override
    public void glEnd() {
      // TODO Auto-generated method stub
      
    }

    @Override
    public void glDepthFunc(int f) {
      // TODO Auto-generated method stub
      
    }

    @Override
    public void glHint(int h, int val) {
      // TODO Auto-generated method stub
      
    }

    @Override
    public void glMatrixMode(int p) {
      // TODO Auto-generated method stub
      
    }

    @Override
    public void glFrustum(float f, float fw, float g, float fh, float h, float i) {
      // TODO Auto-generated method stub
      
    }

    @Override
    public void glViewport(int x, int y, int width, int height) {
      // TODO Auto-generated method stub
      
    }

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
    public int GL_DEPTH_TEST() {
      // TODO Auto-generated method stub
      return 0;
    }

    @Override
    public int GL_LEQUAL() {
      // TODO Auto-generated method stub
      return 0;
    }

    @Override
    public int GL_PERSPECTIVE_CORRECTION_HINT() {
      // TODO Auto-generated method stub
      return 0;
    }

    @Override
    public int GL_NICEST() {
      // TODO Auto-generated method stub
      return 0;
    }

    @Override
    public void glLightfv(int id, int p, MemorySegment pos) {
      // TODO Auto-generated method stub
      
    }

    @Override
    public void glMaterialfv(int id, int shine, MemorySegment shini) {
      // TODO Auto-generated method stub
      
    }

    @Override
    public void glPushMatrix() {
      // TODO Auto-generated method stub
      
    }

    @Override
    public void glutSolidTeapot(double d) {
      // TODO Auto-generated method stub
      
    }

    @Override
    public void glPopMatrix() {
      // TODO Auto-generated method stub
      
    }

    @Override
    public int GL_POSITION() {
      // TODO Auto-generated method stub
      return 0;
    }

    @Override
    public int GL_LIGHT0() {
      // TODO Auto-generated method stub
      return 0;
    }

    @Override
    public int GL_AMBIENT() {
      // TODO Auto-generated method stub
      return 0;
    }

    @Override
    public int GL_DIFFUSE() {
      // TODO Auto-generated method stub
      return 0;
    }

    @Override
    public int GL_SPECULAR() {
      // TODO Auto-generated method stub
      return 0;
    }

    @Override
    public int GL_FRONT() {
      // TODO Auto-generated method stub
      return 0;
    }

    @Override
    public int GL_SHININESS() {
      // TODO Auto-generated method stub
      return 0;
    }

    @Override
    public int GL_LIGHTING() {
      // TODO Auto-generated method stub
      return 0;
    }



}
