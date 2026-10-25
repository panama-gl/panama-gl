// The Khronos glext.h, generated the same way on every OS to check that its declarations do not
// depend on the OS. The base types of gl.h, which glext.h requires, are declared here instead of
// including the gl.h of the OS, which already declares a part of glext.h (e.g. OpenGL 1.2 to 2.1
// on macOS, the ARB_multitexture function pointers in Mesa).
#define APIENTRY
#define APIENTRYP APIENTRY *
#define GLAPI extern

typedef unsigned int GLenum;
typedef unsigned char GLboolean;
typedef unsigned int GLbitfield;
typedef void GLvoid;
typedef signed char GLbyte;
typedef short GLshort;
typedef int GLint;
typedef unsigned char GLubyte;
typedef unsigned short GLushort;
typedef unsigned int GLuint;
typedef int GLsizei;
typedef float GLfloat;
typedef float GLclampf;
typedef double GLdouble;
typedef double GLclampd;

#include <GL/glext.h>
