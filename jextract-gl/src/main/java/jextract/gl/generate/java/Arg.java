package jextract.gl.generate.java;

public class Arg {
  Class<?> type;
  String name;
  String typeName;

  public Arg(Class<?> type, String name) {
    this.name = name;
    this.type = type;
    this.typeName = type.getName();
  }

  public Arg(Class<?> type) {
    this(type, null);
  }

  public void typeName(StringBuffer sb) {
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

  public String getName() {
    return name;
  }

  public String getTypeName() {
    return typeName;
  }

  public void setTypeName(String typeName) {
    this.typeName = typeName;
  }
  
  

}
