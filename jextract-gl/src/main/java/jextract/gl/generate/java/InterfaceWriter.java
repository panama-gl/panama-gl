package jextract.gl.generate.java;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
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
      String declare = arg.getTypeName() + " " + arg.getName();

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
