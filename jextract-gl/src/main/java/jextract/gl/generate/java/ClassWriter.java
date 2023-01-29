package jextract.gl.generate.java;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;
import jextract.gl.generate.java.ClassWriter.Arg;

public class ClassWriter {
  String className;
  String classPackage;
  List<String> imports = new ArrayList<>();
  
  public ClassWriter(String classPackage, String className) {
    this.classPackage = classPackage;
    this.className = className;
  }
  
  public void writeTo(StringBuffer sb, String file) throws IOException {
    FileWriter fw = new FileWriter(file);
    fw.write(sb.toString());
    fw.close();
  }
  
  // --------------------------------------------------
  
  public void addImport(String imprt) {
    imports.add(imprt);
  }

  public void start(StringBuffer sb) {
    if(classPackage!=null) {
      sb.append("package "  + classPackage + "; \n\n");
    }
    for(String imprt: imports) {
      sb.append("import " + imprt + ";\n");
      
    }
    sb.append("\n");
    
    sb.append("public class " + className + " {\n");
  }
  
  public void close(StringBuffer sb) {
    sb.append("}\n");
  }

  // --------------------------------------------------

  // --------------------------------------------------
  
  String tab = "  ";
  String tab2 = "    ";
  //StringBuffer sb = new StringBuffer();
  
  public static class Arg{
    Class<?> cc;
    String name;
    public Arg(Class<?> cc, String name) {
      this.cc = cc;
      this.name = name;
    }
    public Arg(Class<?> cc) {
      this.cc = cc;
    }
    
    
  }
  
  public static class Code{
    String line;
    public Code(String line) {
      this.line = line;
    }
  }

  public void method(StringBuffer sb, String name, List<Code> body) {
    method(sb, name, null, null, body, null);
  }
  public void method(StringBuffer sb, String name, List<Arg> in, Arg out, List<Code> body) {
    method(sb, name, in, out, body, null);
  }  
  
  public void method(StringBuffer sb, String name, List<Arg> in, Arg out, List<Code> body, List<Exception> throwz) {
    
    // Visibility
    sb.append(tab + "public ");
    
    // Output type
    if(out==null) {
      sb.append("void ");
    }
    else {
      typeName(sb, out.cc);
    }
    
    // Input arguments
    sb.append(name+"(");
    
    if(in != null) {
      for (int i = 0; i < in.size(); i++) {
        Arg arg = in.get(i);
        
        typeName(sb, arg.cc);
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
  
  public void typeName(StringBuffer sb, Class<?> type) {
    if(type.equals(Integer.class)) {
      sb.append("int ");
    }
    else if(type.equals(Float.class)) {
      sb.append("float ");
    }
    else if(type.equals(Double.class)) {
      sb.append("double ");
    }
    else if(type.equals(Long.class)) {
      sb.append("long ");
    }
    else {
      sb.append(type.getSimpleName() + " ");          
    }
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
  
  public void wrapper(StringBuffer sb, String name, List<Arg> in, Arg out, String wrapped, List<Exception> throwz) {
    StringBuffer sbargs = new StringBuffer();
    
    if(in!=null) {
      for (int i = 0; i < in.size(); i++) {
        Arg arg = in.get(i);
        
        sbargs.append(arg.name);
        if(i<in.size()-1)
          sbargs.append(", ");
      }
    }
    
    // Wrapping line
    Code c;
    
    if(out==null)
      c = new Code(wrapped + "." + name + "(" + sbargs.toString() + ");");
    else {
      c = new Code("return " + wrapped + "." + name + "(" + sbargs.toString() + ");");
      
    }
    method(sb, name, in, out, List.of(c), throwz);
  }
  
  public void wrapper(StringBuffer sb, Class<?> wrapped, Method method) {
    List<Arg> argsIn = new ArrayList<>();
    for(Parameter param : method.getParameters()) {
      Arg arg = new Arg(param.getType(), param.getName());
      argsIn.add(arg);

    }
    
    Arg argOut = null;
    
    Class<?> retType = method.getReturnType();
    if(!retType.getName().equals("void")) {
      //method.retu
        argOut = new Arg(retType);
    }
    
    //List<Class<?>> throwz = Arrays.asList(method.getExceptionTypes());
    
    wrapper(sb, method.getName(), argsIn, argOut, wrapped.getSimpleName(), null);
  }
}
