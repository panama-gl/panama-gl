package jextract.gl.generate.java;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;

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
    
    sb.append("public class " + className + " {\n");
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
