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
package jextract.gl.java;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Only accepts OpenGL public methods.
 * 
 * Reject GL constants, an non GL methods.
 * 
 * @author Martin Pernollet
 *
 */
public class AcceptsGLMethod implements AcceptsMethod {
  @Override
  public boolean accepts(Method method) {
    // reject non public
    if (!Modifier.isPublic(method.getModifiers())) {
      return false;
    } 
    else {
      String name = method.getName();
      return acceptsName(name);
    }
  }

  protected boolean acceptsName(String name) {
    // reject method handle
    if (name.endsWith("$MH")) {
      return false;
    }

    // only keep methods in gl, glu, glut
    else if (name.startsWith("gl")) {

      // but reject constants
      // 
      //if (name.contains("_")) {
      //  return false;
      //} else {
        return true;
      //}
    }
    else if (name.startsWith("_")) {
      return false;
    }
    else
      return false;
  }
}
