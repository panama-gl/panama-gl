package jextract.gl.generate.java;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;

public class InterfaceWriter {
  String className;
  String classPackage;
  List<String> imports = new ArrayList<>();
  
  public InterfaceWriter(String classPackage, String className) {
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
    
    sb.append("public interface " + className + " {\n");
  }
  
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
