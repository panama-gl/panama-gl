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

#include <GL/glx.h>
#include <GL/gl.h>
#include <unistd.h>
#include <iostream>

#include <stdlib.h>
#include <string.h>
#include <stdio.h>

#define GLX_CONTEXT_MAJOR_VERSION_ARB       0x2091
#define GLX_CONTEXT_MINOR_VERSION_ARB       0x2092
typedef GLXContext (*glXCreateContextAttribsARBProc)(Display*, GLXFBConfig, GLXContext, Bool, const int*);

int main (int argc, char ** argv)
{
    Display *display = XOpenDisplay(0);

    glXCreateContextAttribsARBProc glXCreateContextAttribsARB = NULL;

    const char *extensions = glXQueryExtensionsString(display, DefaultScreen(display));
    std::cout << extensions << std::endl;

    static int visual_attribs[] =
    {
        GLX_RENDER_TYPE, GLX_RGBA_BIT,
        GLX_DRAWABLE_TYPE, GLX_WINDOW_BIT,
        GLX_DOUBLEBUFFER, true,
        GLX_RED_SIZE, 1,
        GLX_GREEN_SIZE, 1,
        GLX_BLUE_SIZE, 1,
        None
     };

    std::cout << "Getting framebuffer config" << std::endl;
    int fbcount;
    GLXFBConfig *fbc = glXChooseFBConfig(display, DefaultScreen(display), visual_attribs, &fbcount);
    if (!fbc)
    {
        std::cout << "Failed to retrieve a framebuffer config" << std::endl;
        return 1;
    }

    std::cout << "Getting XVisualInfo" << std::endl;
    XVisualInfo *vi = glXGetVisualFromFBConfig(display, fbc[0]);

    XSetWindowAttributes swa;
    std::cout << "Creating colormap" << std::endl;
    swa.colormap = XCreateColormap(display, RootWindow(display, vi->screen), vi->visual, AllocNone);
    swa.border_pixel = 0;
    swa.event_mask = StructureNotifyMask;

    std::cout << "Creating window" << std::endl;
    Window win = XCreateWindow(display, RootWindow(display, vi->screen), 0, 0, 100, 100, 0, vi->depth, InputOutput, vi->visual, CWBorderPixel|CWColormap|CWEventMask, &swa);
    if (!win)
    {
        std::cout << "Failed to create window." << std::endl;
        return 1;
    }

    std::cout << "Mapping window" << std::endl;
    XMapWindow(display, win);

    // Create an oldstyle context first, to get the correct function pointer for glXCreateContextAttribsARB
    GLXContext ctx_old = glXCreateContext(display, vi, 0, GL_TRUE);
    glXCreateContextAttribsARB =  (glXCreateContextAttribsARBProc)glXGetProcAddress((const GLubyte*)"glXCreateContextAttribsARB");
    glXMakeCurrent(display, 0, 0);
    glXDestroyContext(display, ctx_old);

    if (glXCreateContextAttribsARB == NULL)
    {
        std::cout << "glXCreateContextAttribsARB entry point not found. Aborting." << std::endl;
        return false;
    }

    static int context_attribs[] =
    {
        GLX_CONTEXT_MAJOR_VERSION_ARB, 3,
        GLX_CONTEXT_MINOR_VERSION_ARB, 0,
        None
    };

    std::cout << "Creating context" << std::endl;
    GLXContext ctx = glXCreateContextAttribsARB(display, fbc[0], NULL, true, context_attribs);
    if (!ctx)
    {
        std::cout << "Failed to create GL3 context." << std::endl;
        return 1;
    }

    std::cout << "Making context current" << std::endl;
    glXMakeCurrent(display, win, ctx);

        glClearColor (0, 0.5, 1, 1);
        glClear (GL_COLOR_BUFFER_BIT);
        glXSwapBuffers (display, win);

        sleep(1);

        glClearColor (1, 0.5, 0, 1);
        glClear (GL_COLOR_BUFFER_BIT);
        glXSwapBuffers (display, win);

        sleep(1);

    ctx = glXGetCurrentContext();
    glXMakeCurrent(display, 0, 0);
    glXDestroyContext(display, ctx);
}
