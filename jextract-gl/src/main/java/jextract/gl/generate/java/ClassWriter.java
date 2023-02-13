package jextract.gl.generate.java;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;
import jextract.gl.xml.model.CommandWrap;

public class ClassWriter extends JavaWriter {
  List<String> implement;

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
    sb.append("public class " + className);
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

  public void method(StringBuffer sb, String name, List<Arg> in, Arg out, List<Code> body) {
    method(sb, name, in, out, body, null);
  }

  public void method(StringBuffer sb, String name, List<Arg> in, Arg out, List<Code> body,
      List<Exception> throwz) {

    // Visibility
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
    StringBuffer sbargs = new StringBuffer();

    if (in != null) {
      for (int i = 0; i < in.size(); i++) {
        Arg arg = in.get(i);

        sbargs.append(arg.name);
        if (i < in.size() - 1)
          sbargs.append(", ");
      }
    }

    // Wrapping line
    Code c;

    if (out == null)
      c = new Code(wrapped + "." + name + "(" + sbargs.toString() + ");");
    else {
      c = new Code("return " + wrapped + "." + name + "(" + sbargs.toString() + ");");

    }
    method(sb, name, in, out, List.of(c), throwz);
  }

  public void wrapper(StringBuffer sb, Class<?> wrapped, Method wrappedMethod,
      CommandWrap specInterface) {
    List<Arg> argsIn = getArgsIn(wrappedMethod);
    Arg argOut = getArgOut(wrappedMethod);


    if (specInterface.getArgs().size() != argsIn.size()) {
      System.out.println(wrappedMethod.getName());
      // System.out.println(argsIn);

      print("- interface : ", specInterface.getArgs());
      print("- wrapper   : ", argsIn);
    } else {
      for (int i = 0; i < argsIn.size(); i++) {
        if (!argsIn.get(i).typeName.equals(specInterface.getArgs().get(i).typeName)) {
          System.out.println(wrappedMethod.getName() + "\t MISMATCH  on "
              + specInterface.getArgs().get(i).name + " : " + argsIn.get(i).typeName + " / spec : "
              + specInterface.getArgs().get(i).typeName);
        }
      }
    }


    wrapper(sb, wrappedMethod.getName(), argsIn, argOut, wrapped.getSimpleName(), null);
  }

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
    if (!retType.getName().equals("void")) {
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

  public void addImplement(List<String> implement) {
    this.implement = implement;
  }
}
