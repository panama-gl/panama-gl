package jextract.gl.generate.java;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public abstract class JavaWriter {

  protected String className;
  protected String classPackage;
  protected List<String> imports = new ArrayList<>();
  protected List<String> extensions = new ArrayList<>();
  protected String tab = "  ";
  protected String tab2 = "    ";

  public abstract void start(StringBuffer sb);
  public abstract void close(StringBuffer sb);

  public void writeTo(StringBuffer sb, String file) throws IOException {
    FileWriter fw = new FileWriter(file);
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
        if(i<extensions.size()-2)
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




}
