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

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.Test;
import jextract.gl.generate.java.Arg;
import jextract.gl.generate.java.ClassWriter;
import jextract.gl.generate.java.Wrapper;
import jextract.gl.xml.model.GLCommand;
import junit.framework.Assert;

// TODO : achieve Method.Class mocking to test
// wrapJavaBinding
// 
public class TestGenerateWrapperFromBindings {
  @Test
  public void wrapJavaBinding() throws Exception {
    
    // Given wrapper configuration
    Class<?> wrapped = Class.class; // usually glut_h, but here anything
    Wrapper wrapper = new Wrapper();
    wrapper.wrapped = Set.of(wrapped);
    
    // ---------------------------------------
    // Given a registry of java bindings
    
    String METHOD_NAME = "glutTralala";
    Parameter[] input = {Mocks.param("anInteger", Integer.class)};
    Method m1 = Mocks.method(METHOD_NAME, input, String.class);
    
    Map<Class<?>, List<Method>> bindingRegistry = new HashMap<>();
    bindingRegistry.put(wrapped, List.of(m1));

    
    // ---------------------------------------
    // Given a registry of opengl commands that matches the bindings
    Map<String, GLCommand> glRegistry = new HashMap<>();
    GLCommand glCommand = new GLCommand(METHOD_NAME, List.of(new Arg(Integer.class.getName(), "anInteger")), "String");
    glRegistry.put(METHOD_NAME, glCommand);
    
    
    // ---------------------------------------
    // When generating binding
    
    ClassWriter classWriter = new ClassWriter("","");
    StringBuffer javaCode = new StringBuffer();
    
    GenerateWrapperFromBindings g = new GenerateWrapperFromBindings();
    g.wrapJavaBinding(classWriter, wrapper, glRegistry, bindingRegistry, javaCode);
    
    // Then the wrapping is successful
    Assert.assertEquals(1, g.methodFound);
    Assert.assertEquals(0, g.methodNotFound);
    
  }

  /**
   * Check that a method found in binding - but not in spec - yield to a wrapping.
   * 
   * This is used to wrap GLU and GLUT which appear in binding but not in specification.
   */
  @Test
  public void wrapUnspecifiedMethod() throws Exception {

    // Wrapper declaration
    Class<?> wrapped = Class.class; // usually glut_h, but here anything
    Wrapper wrapper = new Wrapper();
    wrapper.wrapped = Set.of(wrapped);
    
    // Given : a java binding registry containing a single void method
    String METHOD_NAME = "glutTralala";
    Parameter[] input = { Mocks.param("anInteger", Integer.class) };
    Method m1 = Mocks.method(METHOD_NAME, input, String.class);
    Map<Class<?>, List<Method>> javaMethodRegistry = new HashMap<>();
    javaMethodRegistry.put(wrapped, List.of(m1));
    
    
    // ---------------------------------------
    // When wrapping unspecified methods

    ClassWriter classWriter = new ClassWriter("", "");
    
    Method bindedMethod = m1; 
    Set<String> autoWrappedMethodNames = new HashSet<>();
    StringBuffer javaCode = new StringBuffer();
    
    GenerateWrapperFromBindings g = new GenerateWrapperFromBindings();
    g.wrapUnspecifiedMethod(classWriter, wrapped, bindedMethod, autoWrappedMethodNames, javaCode);

    
    // Then : the generated method name is available
    Assert.assertTrue(autoWrappedMethodNames.contains(METHOD_NAME));
    
    // Then : the generated method is available with its input/output types
    List<Method> methods = g.getAutoWrappedMethods();
    
    Assert.assertTrue(methods.get(0).getName().contains(METHOD_NAME));
    Assert.assertEquals(1, methods.get(0).getParameters().length);
    Assert.assertTrue(javaCode.toString().contains("public String "+METHOD_NAME+"(int anInteger)"));
    Assert.assertEquals(String.class, methods.get(0).getReturnType());
    
  }
  

  

  @Test
  public void wrapUnavailableMethods() throws Exception {
    
    // Given : a registry containing a command to wrap
    Map<String, GLCommand> glRegistry = new HashMap<>();
    glRegistry.put("glBegin", new GLCommand("glBegin", "void"));
    
    // Given : an empty set of binded command, meaning
    // the previous command has not been wrapped already
    List<GLCommand> wrappedCommands = new ArrayList<>();
    
    // ---------------------------------------    
    // When initializing a generator
    GenerateWrapperFromBindings g = new GenerateWrapperFromBindings();
    
    // Then it has not work yet
    Assert.assertEquals(0, g.nUnimplemented);
    Assert.assertTrue(g.addUnimplementedMethodsUponMissingBinding);
    
    // ---------------------------------------
    // When wrapping unavailable methods
    ClassWriter classWriter = new ClassWriter("", "");
    StringBuffer javaCode = new StringBuffer();
    
    g.wrapUnavailableMethods(classWriter, glRegistry, wrappedCommands, javaCode);
    
    // Then : counter increments
    Assert.assertEquals(1, g.nUnimplemented);
    
    // Then : code throwing exception is generated
    Assert.assertTrue(javaCode.toString().contains("public void glBegin()"));
    Assert.assertTrue(javaCode.toString().contains("throw new RuntimeException"));
    
    // Then : the list of wrapped command contains a reference to this newly generated 
    // wrapper
    Assert.assertEquals(new GLCommand("glBegin", "void"), wrappedCommands.get(0));
    
  }

}
