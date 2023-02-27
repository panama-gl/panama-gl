package jextract.gl.generate.java;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;



public abstract class JavaWriter {

  protected String className;
  protected String classPackage;
  protected List<String> imports = new ArrayList<>();
  protected List<String> extensions = new ArrayList<>();
  protected List<String> implement = new ArrayList<>();

  protected String tab = "  ";
  protected String tab2 = "    ";

  public abstract void start(StringBuffer sb);
  public abstract void close(StringBuffer sb);

  public void writeTo(StringBuffer sb, String file) throws IOException {
    File f = new File(file);
    if(!f.getParentFile().exists()) {
      f.getParentFile().mkdirs();
    }
    FileWriter fw = new FileWriter(f);
    fw.write(sb.toString());
    fw.close();
  }

  public void addImport(String imprt) {
    imports.add(imprt);
  }

  public void addExtension(String extension) {
    extensions.add(extension);
  }
  

  
  protected String writeExtends() {
    if(extensions==null || extensions.size()==0)
      return "";
    else {
      String ext = "extends ";
      for (int i = 0; i < extensions.size(); i++) {
        if(i<extensions.size()-1)
          ext+=extensions.get(i) + ", ";
        else
          ext+=extensions.get(i);
        
      }
      return ext;
    }
  }
  
  protected void writeImports(StringBuffer sb) {
    for(String imprt: imports) {
      sb.append("import " + imprt + ";\n");
      
    }
    sb.append("\n");
  }

  protected void writePackage(StringBuffer sb) {
    if(classPackage!=null) {
      sb.append("package "  + classPackage + "; \n\n");
    }
  }
  
  public void constant(StringBuffer sb, String name, String type, String value) {
    String line = "public static final " + type + " " + name + " = " + value + ";";

    // Check if this line of code as allready been writen
    if (!sb.toString().contains(line))
      sb.append("  " + line + "\n");
  }


  public Arg getOutputArg(Method method) {
    return new Arg(method.getReturnType().getName(), "out");
  }

  public List<Arg> getInputArgs(Method method) {
    List<Arg> in = new ArrayList<>();
    for(Parameter p: method.getParameters()) {
      Arg i = new Arg(p.getType().getName(), p.getName());
      in.add(i);
    }
    return in;
  }



}
