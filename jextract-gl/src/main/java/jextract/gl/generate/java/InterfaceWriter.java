package jextract.gl.generate.java;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;

public class InterfaceWriter extends JavaWriter{
  
  public InterfaceWriter(String classPackage, String className) {
    this.classPackage = classPackage;
    this.className = className;
  }
    
  // --------------------------------------------------
  
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

  // --------------------------------------------------
  
  

  // --------------------------------------------------
  
  String tab = "  ";
  String tab2 = "    ";
  //StringBuffer sb = new StringBuffer();
  
  

  public void method(StringBuffer sb, String name, List<Code> body) {
    method(sb, name, null, null, body, null);
  }
  public void method(StringBuffer sb, String name, List<Arg> in, Arg out, List<Code> body) {
    method(sb, name, in, out, body, null);
  }  

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

    
  public void method(StringBuffer sb, String name, List<Arg> in, Arg out, List<Code> body, List<Exception> throwz) {
    
    // Visibility
    sb.append(tab + "public ");
    
    // Output type
    if(out==null) {
      sb.append("void ");
    }
    else {
      out.typeName(sb);
    }
    
    // Input arguments
    sb.append(name+"(");
    
    if(in != null) {
      for (int i = 0; i < in.size(); i++) {
        Arg arg = in.get(i);
        
        out.typeName(sb);
        sb.append(arg.name);
        if(i<in.size()-1)
          sb.append(", ");
      }
    }
    
    sb.append(") ");
    
    // Exceptions
    
    if(throwz!=null && throwz.size()>0) {
      sb.append("throws ");
      for (int i = 0; i < throwz.size(); i++) {
        sb.append(throwz.get(i));
      }
    }
    
    // Start body
    sb.append("{\n");

    for(Code c: body) {
      sb.append(tab2 + c.line + "\n");
    }
    
  
    // End body
    sb.append(tab + "}\n\n");

  }
  

}
