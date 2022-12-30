package panamagl;

/**
 * A lightweight logging module without complex configuration, inspired from JOGL.
 * 
 * @author Martin
 */
public class Debug {
  public static boolean check(Class<?> clazz) {
    return check(clazz.getName());
  }
  
  public static boolean check(String name) {
    String command = System.getProperty("sun.java.command");
    
    System.out.println(command);
    
    if(command.contains(name)) {
      return true;
    }
    else {
      return false;
    }
    //System.out.println("Debug for '" + name + "':'" + p + "'");
    
    //System.out.println(System.getProperties());
    
    //return Boolean.parseBoolean(p);
  }
  
  public static void debug(String message) {
    System.out.println(message);
  }
  
  public static void debug(boolean debug, String message) {
    if(debug)
      System.out.println(message);
  }

}
