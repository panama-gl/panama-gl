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
    String p = System.getProperty(name);
    
    return Boolean.parseBoolean(p);
  }
  
  public static void debug(String message) {
    System.out.println(message);
  }
}
