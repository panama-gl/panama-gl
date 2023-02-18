package jextract.gl.generate.java;

public class Arg {
  Class<?> type;
  String name;
  String typeName;
  String expand;

  public Arg(String typeName, String name) {
    this.name = name;
    this.type = Object.class;
    this.typeName = typeName;
  }

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
    else if(type.equals(String.class)) {
      sb.append("String ");
    }
    else if(type.equals(Object.class)) {
      sb.append(typeName + " ");
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

  public Class<?> getType() {
    return type;
  }

  public void setType(Class<?> type) {
    this.type = type;
  }

  public String getExpand() {
    return expand;
  }

  public void setExpand(String expand) {
    this.expand = expand;
  }
}
