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

/**
 * A {@link GLContext} is responsible for establishing an OpenGL context with the OS
 * libraries, allowing to then invoke OpenGL methods.
 *
 * The actual context will depend on OS resolution and available implementations.
 * Each OS requires dedicated libraries able to initiate a context
 *
 * <ul>
 *     <li>Linux : GLX, ?</li>
 *     <li>macOS : GLUT, CGL, ?</li>
 *     <li>Windows : GLUT, WGL, ?</li>
 * </ul>
 * 
 * @author Martin Pernollet
 */
public interface GLContext {
    void init();
    void destroy();
    
    boolean isInitialized();
}
