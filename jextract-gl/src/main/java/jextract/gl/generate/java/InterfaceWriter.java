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

import java.lang.reflect.Method;
import java.util.List;

public class InterfaceWriter extends JavaWriter{
  String tab = "  ";
  String tab2 = "    ";

  public InterfaceWriter(String classPackage, String className) {
    this.classPackage = classPackage;
    this.className = className;
  }
    
  @Override
  public void start(StringBuffer sb) {
    writePackage(sb);
    writeImports(sb);
    
    sb.append("public interface " + className + " " + writeExtends() + " {\n");
  }
  
  @Override
  public void close(StringBuffer sb) {
    sb.append("}\n");
  }

  /** Generate an interface method declaration based on a base type definition. */
  public void method(StringBuffer sb, String name, List<Arg> input, String outputType) {
    StringBuffer argBuffer = new StringBuffer();

    
    String methodDecl = "public " + outputType + " " + name + "(";
    
    argBuffer.append(methodDecl);

    // arguments
    int k = 0;
    for (Arg arg : input) {
      String declare = arg.getTypeName() + " " + arg.getName();

        if (k == 0) {
          argBuffer.append(declare);
        } else {
          argBuffer.append(", " + declare);
        }
      k++;

    }

    argBuffer.append(");\n");

    if (!sb.toString().contains(argBuffer.toString())) {
      sb.append("  " + argBuffer.toString());
    }
  }
  
  /** Generate an interface method declaration based on a Java method definition. */
  public void method(StringBuffer sb, Method method) {
    List<Arg> in = getInputArgs(method);
    Arg o = getOutputArg(method);
    
    //method(sb, method.getName(), in, o, null, null);
        
    String methodName = "public " + o.typeName + " " + method.getName() + "(";
    //StringBuffer argBuffer = new StringBuffer();

    sb.append(methodName);

    int k = 0;
    for (Arg arg : in) {
      String typeName = arg.getTypeName();
      int id = typeName.lastIndexOf(".");
      
      if(id!=-1) {
        typeName = typeName.substring(id+1);
      }
      
      String declare = typeName + " " + arg.getName();

        if (k == 0) {
          sb.append(declare);
        } else {
          sb.append(", " + declare);
        }
      k++;

    }

    sb.append(");\n");
  }

}
