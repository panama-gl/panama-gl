package jextract.gl.generate.java;

public class Arg {
  Class<?> type;
  String name;

  public Arg(Class<?> type, String name) {
    this.type = type;
    this.name = name;
  }

  public Arg(Class<?> cc) {
    this.type = cc;
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

}
