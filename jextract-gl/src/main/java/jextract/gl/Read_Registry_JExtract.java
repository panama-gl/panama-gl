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
package jextract.gl;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;
import com.google.common.collect.ArrayListMultimap;
import jextract.gl.java.AcceptsGLMethod;
import jextract.gl.java.ClassMethodRegistry;
import opengl.ubuntu.v20.glut_h;

/**
 * Enumerate all OpenGL methods available for generated binding.
 *
 * Run me with VM args : --enable-preview
 *
 */
public class Read_Registry_JExtract {

  public static void main(String[] args)
      throws IOException, ClassNotFoundException, IllegalAccessException {

    // By direct usage
    byDirectLink();

    

  }

  protected static void byDirectLink() throws IllegalAccessException {
    ClassMethodRegistry registry = new ClassMethodRegistry();
    List<Method> methods = registry.selectMethods(glut_h.class, new AcceptsGLMethod());
    
    registry.sort(methods);
    registry.print(methods);
    
    System.out.println("Filtered to " + methods.size() + " methods (initially " + glut_h.class.getMethods().length + ")");
  }

  protected static ClassMethodRegistry byIntrospection()
      throws ClassNotFoundException, IOException, IllegalAccessException {
    ClassMethodRegistry registry  = new ClassMethodRegistry();

    // By introspection
    
    // use reflection to load all classes allowing to invok gl* methods
    String packageName = "opengl.ubuntu.v20";
    // String classPattern = "constants\\$(\\d+)";
    String classPattern = "glut_h";
    ArrayListMultimap<Class<?>, Method> cm = registry.selectClassMethods(packageName, classPattern, new AcceptsGLMethod());
    System.out.println(cm.values().size() + " GL/GLU/GLUT methods");
    return registry;
  }

  
}
