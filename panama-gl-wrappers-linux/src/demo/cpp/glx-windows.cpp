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

Display *dpy;             /* display variable */
XVisualInfo *vi;          /* visual variable */
Window win;               /* window variable */
GLXDrawable drawable;     /* drawable variable */
GLXContext cx, cxTemp;    /* rendering context variables */

/* Code to open a display and get a visual. */

/* Create a GLX context. */
cx = glXCreateContext(dpy, vi, 0, GL_FALSE);
if (!cx) {
    fprintf(stderr, "Cannot create context.\n");
    exit(-1);
}

        .
/* Connect the context to the window. */
glXMakeCurrent(dpy, win, cx);

        .
/* When it's time to destroy the rendering context. . . */
cx = glXGetCurrentContext;
glXDestroyContext(dpy, cx);
