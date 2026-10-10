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
package jextract.gl.api.panamagl;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.Test;
import jextract.gl.Mocks;
import jextract.gl.api.panamagl.GenerateAPI_GL_Wrapper;
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
    classWriter.start();
    
    GenerateAPI_GL_Wrapper g = new GenerateAPI_GL_Wrapper();
    g.wrapJavaBinding(classWriter, wrapper, glRegistry, bindingRegistry);
    
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
    classWriter.start();
    
    Method bindedMethod = m1; 
    Set<String> autoWrappedMethodNames = new HashSet<>();
    
    GenerateAPI_GL_Wrapper g = new GenerateAPI_GL_Wrapper();
    g.wrapUnspecifiedMethod(classWriter, wrapped, bindedMethod, autoWrappedMethodNames);

    
    // Then : the generated method name is available
    Assert.assertTrue(autoWrappedMethodNames.contains(METHOD_NAME));
    
    // Then : the generated method is available with its input/output types
    List<Method> methods = g.getAutoWrappedMethods();
    
    Assert.assertTrue(methods.get(0).getName().contains(METHOD_NAME));
    Assert.assertEquals(1, methods.get(0).getParameters().length);
    Assert.assertTrue(classWriter.getCode().contains("public String "+METHOD_NAME+"(int anInteger)"));
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
    GenerateAPI_GL_Wrapper g = new GenerateAPI_GL_Wrapper();
    
    // Then it has not work yet
    Assert.assertEquals(0, g.nUnimplemented);
    Assert.assertTrue(g.addUnimplementedMethodsUponMissingBinding);
    
    // ---------------------------------------
    // When wrapping unavailable methods
    ClassWriter classWriter = new ClassWriter("", "");
    classWriter.start();
    
    // without function loader
    g.wrapUnavailableMethods(classWriter, new Wrapper(), glRegistry, wrappedCommands);
    
    // Then : counter increments
    Assert.assertEquals(1, g.nUnimplemented);
    
    // Then : code throwing exception is generated
    Assert.assertTrue(classWriter.getCode().contains("public void glBegin()"));
    Assert.assertTrue(classWriter.getCode().contains("throw new RuntimeException"));
    
    // Then : the list of wrapped command contains a reference to this newly generated 
    // wrapper
    Assert.assertEquals(new GLCommand("glBegin", "void"), wrappedCommands.get(0));
    
  }

  @Test
  public void wrapUnavailableMethods_withFunctionLoader() throws Exception {

    // Given : a registry containing commands missing from the static bindings, one having a
    // function pointer typedef, one having none
    Map<String, GLCommand> glRegistry = new HashMap<>();
    glRegistry.put("glGenBuffers", new GLCommand("glGenBuffers",
        List.of(new Arg(Integer.class, "n"), new Arg("MemorySegment", "buffers")), "void"));
    glRegistry.put("glNoTypedef", new GLCommand("glNoTypedef", "void"));
    List<GLCommand> wrappedCommands = new ArrayList<>();

    // Given : a wrapper resolving missing functions at runtime
    GenerateAPI_GL_Wrapper g = new GenerateAPI_GL_Wrapper();
    ClassWriter classWriter = new ClassWriter("", "");
    classWriter.start();

    g.wrapUnavailableMethods(classWriter, wrapperWithFunctionLoader(), glRegistry, wrappedCommands);

    // Then : the function is invoked through its function pointer class
    Assert.assertEquals(2, g.nUnimplemented);
    Assert.assertTrue(classWriter.getCode().contains(
        "PFNGLGENBUFFERSPROC.invoke(address(\"glGenBuffers\"), n, buffers);"));

    // Then : a function without typedef throws an exception
    Assert.assertTrue(classWriter.getCode().contains("public void glNoTypedef()"));
    Assert.assertTrue(classWriter.getCode().contains("throw new RuntimeException"));
  }

  @Test
  public void functionPointerOfAnAlias() throws Exception {

    // Given : a GL 1.3 command without typedef, which the registry declares as alias of an ARB
    // command having one
    GLCommand core = new GLCommand("glClientActiveTexture", List.of(new Arg(Integer.class, "texture")), "void");
    GLCommand arb = new GLCommand("glClientActiveTextureARB", List.of(new Arg(Integer.class, "texture")), "void");
    arb.setAlias("glClientActiveTexture");

    Map<String, GLCommand> glRegistry = new HashMap<>();
    glRegistry.put(core.getName(), core);
    glRegistry.put(arb.getName(), arb);

    // When
    GenerateAPI_GL_Wrapper g = new GenerateAPI_GL_Wrapper();
    Class<?> functionPointer = g.getFunctionPointer(wrapperWithFunctionLoader(), core, glRegistry);

    // Then : the typedef of the alias is used
    Assert.assertEquals(opengl.linux.x86.PFNGLCLIENTACTIVETEXTUREARBPROC.class, functionPointer);

    // Then : no function pointer without function loader
    Assert.assertNull(g.getFunctionPointer(new Wrapper(), core, glRegistry));
  }

  protected Wrapper wrapperWithFunctionLoader() {
    Wrapper wrapper = new Wrapper();
    wrapper.functionLoader = "panamagl.platform.linux.GLFunctionLoader_linux";
    wrapper.functionPointers = "opengl.linux.x86";
    return wrapper;
  }
}
