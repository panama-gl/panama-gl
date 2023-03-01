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

import java.lang.foreign.ValueLayout;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;
import jextract.gl.xml.model.GLCommand;

public class ClassWriter extends JavaWriter {

  public ClassWriter(String classPackage, String className) {
    super();
    this.classPackage = classPackage;
    this.className = className;
  }

  // --------------------------------------------------

  @Override
  public void start(StringBuffer sb) {
    writePackage(sb);
    writeImports(sb);
    writeClass(sb);
  }

  private void writeClass(StringBuffer sb) {
    sb.append("public class " + className + " " + writeExtends() );
    writeImplements(sb);
    sb.append(" {\n");
  }

  private void writeImplements(StringBuffer sb) {
    if (implement != null && implement.size() > 0) {
      int k = 0;
      sb.append(" implements ");
      for (String impl : implement) {
        sb.append(impl);
        k++;
        if(k<implement.size()) {
          sb.append(", ");
        }
      }
    }
  }

  @Override
  public void close(StringBuffer sb) {
    sb.append("}\n");
  }


  // --------------------------------------------------

  public void method(StringBuffer sb, String name, List<Code> body) {
    method(sb, name, null, null, body, null);
  }

  public void method(StringBuffer sb, String name, List<Arg> in, Arg out, Code body) {
    method(sb, name, in, out, List.of(body));
  }
  
  public void method(StringBuffer sb, String name, List<Arg> in, Arg out, List<Code> body) {
    method(sb, name, in, out, body, null);
  }

  public void method(StringBuffer sb, String name, List<Arg> in, Arg out, List<Code> body,
      List<Exception> throwz) {

    // Visibility
    //sb.append(tab + "@Override\n");
    sb.append(tab + "public ");

    // Output type
    if (out == null) {
      sb.append("void ");
    } else {
      out.typeName(sb);
    }

    // Input arguments
    sb.append(name + "(");

    if (in != null) {
      for (int i = 0; i < in.size(); i++) {
        Arg arg = in.get(i);

        arg.typeName(sb);
        sb.append(arg.name);
        if (i < in.size() - 1)
          sb.append(", ");
      }
    }

    sb.append(") ");

    // Exceptions

    if (throwz != null && throwz.size() > 0) {
      sb.append("throws ");
      for (int i = 0; i < throwz.size(); i++) {
        sb.append(throwz.get(i));
      }
    }

    // Start body
    sb.append("{\n");

    for (Code c : body) {
      sb.append(tab2 + c.line + "\n");
    }


    // End body
    sb.append(tab + "}\n\n");

  }



  // ------------------

  public void wrapper(StringBuffer sb, String name, String wrapped) {
    wrapper(sb, name, null, null, wrapped, null);
  }

  public void wrapper(StringBuffer sb, String name, List<Arg> in, String wrapped) {
    wrapper(sb, name, in, null, wrapped, null);
  }

  public void wrapper(StringBuffer sb, String name, List<Arg> in, Arg out, String wrapped) {
    wrapper(sb, name, in, out, wrapped, null);
  }

  public void wrapper(StringBuffer sb, String name, List<Arg> in, Arg out, String wrapped,
      List<Exception> throwz) {
    wrapper(sb, name, in, out, wrapped, throwz, null);
  }
  
  public void wrapper(StringBuffer sb, String name, List<Arg> in, Arg out, String wrapped,
      List<Exception> throwz, Code code) {
    StringBuffer sbargs = writeInputArgs(in);

    // Wrapping line
    Code c = code;

    // If na wrapping line(s) of code are given, generate default
    if(c==null) {
      if (out == null)
        c = new Code(wrapped + "." + name + "(" + sbargs.toString() + ");");
      else {
        c = new Code("return " + wrapped + "." + name + "(" + sbargs.toString() + ");");
      }
    }
    method(sb, name, in, out, List.of(c), throwz);
  }

  public static StringBuffer writeInputArgs(List<Arg> in) {
    StringBuffer sbargs = new StringBuffer();

    if (in != null) {
      for (int i = 0; i < in.size(); i++) {
        Arg arg = in.get(i);

        // use the expansion instead of parameter name
        if(arg.expand!=null) {
          sbargs.append(arg.expand);
        }
        // or simply param name copy
        else {
          sbargs.append(arg.name);
        }
        
        if (i < in.size() - 1)
          sbargs.append(", ");
      }
    }
    return sbargs;
  }

  // ================================================================
  // WRAPLETS TO MAKE TYPE GUESSING
  // ================================================================
  
  public class Wraplet{
    String spec;
    String impl;
    Code code;
    
    static boolean mismatch(Arg spec, Arg impl) {
      return !impl.typeName.equals(spec.typeName);
    }
    
    static boolean ignore(Arg spec, Arg impl) {
      return impl.typeName.equals("java.lang.foreign.Addressable") && spec.typeName.equals("Addressable");
    }
  }
  
  public class StringWraplet{
    String spec;
    String impl;
    Code code;
    
    static boolean match(String spec, String impl) {
      return "String".equals(spec) && ("MemoryAddress".equals(impl) || "java.lang.foreign.MemoryAddress".equals(impl));
    }
    
    static Code wraplet(String wrapped, String method, List<Arg> in) {
      Code c = null;
      c = new Code("return " + wrapped + "." + method + "(" + writeInputArgs(in).toString() + ").getUtf8String(0);");

      return c;
    }
  }

  public class AddressableInputIntWraplet{
    static boolean match(Arg spec, Arg impl) {
      return "Addressable".equals(spec.typeName) && ("int".equals(impl.typeName));
    }
    static String expand(Arg spec) {
      return spec.name + ".get(ValueLayout.JAVA_INT, 0)";
    }
  }
  
  public class ByteBufferWraplet{
    static boolean match(String methodName) {
      return methodName.equals("glMapBuffer");
    }
  }

  // ================================================================

  /**
   * Infer wrapping code based on potential type mismatch
   * 
   * @param sb
   * @param wrapped
   * @param wrappedMethod
   * @param specInterface
   */
  public void wrapper(StringBuffer sb, Class<?> wrapped, Method wrappedMethod,
      GLCommand specInterface) {
    List<Arg> argsIn = getArgsIn(wrappedMethod);
    Arg argOut = getArgOut(wrappedMethod);

    List<Exception> exceptions = null; 
    
    
    Code code = null;

    
    // Check type compatibility
    if (specInterface.getArgs().size() != argsIn.size()) {
      System.out.println(wrappedMethod.getName());
      // System.out.println(argsIn);

      print("- interface : ", specInterface.getArgs());
      print("- wrapper   : ", argsIn);
      
      throw new RuntimeException("interface do not match parameter number");
    } else {
      
      // Check type mismatch in input parameters
      for (int i = 0; i < argsIn.size(); i++) {
        
        // Force implementation to use the spec arg name
        argsIn.get(i).name = specInterface.getArgs().get(i).name;
        
        // Type mismatch WARNINGS
        
        Arg spec = specInterface.getArgs().get(i);
        Arg impl = argsIn.get(i);
        
        if (Wraplet.mismatch(spec, impl)) {
          
          // Ignore long class name difference
          if(Wraplet.ignore(spec, impl))
            continue;
          
          // Expand adressable content when IMPL expect int (and SPEC provides Addressable)
          /*else if(AddressableInputIntWraplet.match(spec, impl)){
            
            // mark the argument as being expandable (replace the variable reference
            // by a read expression : adressable.get(ValueLayout.JAVA_INT, 0)
            impl.expand = AddressableInputIntWraplet.expand(spec);
            
            // this is the type name that will be used to write 
            // the method parameters, so we have to fix the mismatch
            impl.typeName = "Addressable";
          }*/
          
          // Type mismatch not resolvable
          else {
            String error = wrappedMethod.getName() + "\t MISMATCH  on "
                + specInterface.getArgs().get(i).name + " : " + argsIn.get(i).typeName + " / spec : "
                + specInterface.getArgs().get(i).typeName;
            
            
            System.err.println(error);
            
            print("- interface : ", specInterface.getArgs());
            print("- wrapper   : ", argsIn);

            
            //throw new RuntimeException("Type " + error);
            
          }
        }
      }      
    }
    
    
    
    // Check type mismatch in output parameters
    if(argOut!=null && StringWraplet.match(specInterface.getOutputType(), argOut.getTypeName())) {
      
      // Generate a method call to extract string
      code = StringWraplet.wraplet(wrapped.getSimpleName(), wrappedMethod.getName(), argsIn);
      
      // Change the output type to the string type
      argOut.setType(String.class);
      argOut.setTypeName("String");
    }
    
    /*if("String".equals( specInterface.getOutputType()) && "MemoryAddress".equals(argOut.getTypeName())) {
      
    }*/



    wrapper(sb, wrappedMethod.getName(), argsIn, argOut, wrapped.getSimpleName(), exceptions, code);
  }
  
  public void wrapperNotImplemented(StringBuffer javaCode, GLCommand registryCommand) {
    // Wrapping line
    Code c = new Code("throw new RuntimeException(\"This method is not available in the generated binding.\");");

    Arg out = new Arg(registryCommand.getOutputType(), "out");
    
    method(javaCode, registryCommand.getName(), registryCommand.getArgs(), out, List.of(c), null);
  }
  
  public void wrapperAuto(StringBuffer sb, Class<?> wrapped, Method wrappedMethod) {
    List<Arg> argsIn = getArgsIn(wrappedMethod);
    Arg argOut = getArgOut(wrappedMethod);

    List<Exception> exceptions = null; 
    
    wrapper(sb, wrappedMethod.getName(), argsIn, argOut, wrapped.getSimpleName(), exceptions);
  }
  
  // ================================


  public void print(String head, List<Arg> args) {
    System.out.print(head);
    for (Arg a : args) {
      System.out.print(a.getTypeName() + " " + a.getName() + ", ");
    }
    System.out.println();
  }



  private Arg getArgOut(Method wrappedMethod) {
    Arg argOut = null;

    Class<?> retType = wrappedMethod.getReturnType();
    if (retType!=null && !retType.getName().equals("void")) {
      argOut = new Arg(retType);
    }
    return argOut;
  }

  private List<Arg> getArgsIn(Method wrappedMethod) {
    List<Arg> argsIn = new ArrayList<>();
    for (Parameter param : wrappedMethod.getParameters()) {
      Arg arg = new Arg(param.getType(), param.getName());
      argsIn.add(arg);

    }
    return argsIn;
  }



}
