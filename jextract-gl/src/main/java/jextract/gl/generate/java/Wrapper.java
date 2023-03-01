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
package jextract.gl.generate.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import jextract.gl.java.AcceptsMethod;

public class Wrapper {
  public Set<Class<?>> wrapped;
  // Class<?> wrapped = opengl.ubuntu.v20.glut_h.class;
  public AcceptsMethod accepts;
  public String className;
  public String packge;
  public String javaFile;
  public List<String> implement = new ArrayList<>();
  public List<String> extend = new ArrayList<>();
  public String platform;
  
  public void setFileIn(String folder) {
    javaFile = folder + packge.replace(".", "/") + "/" + className + ".java";
  }


  public void addImplement(String impl) {
    implement.add(impl);
  }

  public void addImplement(List<String> impl) {
    implement.addAll(impl);
  }
  public void addExtension(String impl) {
    extend.add(impl);
  }

  public void addExtension(List<String> impl) {
    extend.addAll(impl);
  }

}
