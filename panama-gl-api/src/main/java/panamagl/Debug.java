/*******************************************************************************
 * Copyright (c) 2022, 2023 Martin Pernollet & contributors.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301, USA
 *******************************************************************************/
package panamagl;

/**
 * A lightweight logging module without complex configuration, inspired from JOGL.
 * 
 * To debug a class using this, add -Dcom.package.Class or -Dcom.package.Class$SubClass in the
 * program arguments to enable a particular class
 * 
 * 
 * @author Martin Pernollet
 */
public class Debug {
  static boolean debug = check(Debug.class);

  /**
   * Will enable debugging if any of the input class appears in the program arguments as
   * -Dcom.package.Class or -Dcom.package.Class$SubClass
   * 
   * @param clazz
   * @return
   */
  public static boolean check(Class<?>... clazz) {
    for (Class<?> c : clazz) {
      if (check(c.getName())) {
        return true;
      }
    }

    return false;
  }

  /**
   * Will enable debugging the input class appears in the program arguments as -Dcom.package.Class
   * or -Dcom.package.Class$SubClass
   * 
   * @param clazz
   * @return
   */
  public static boolean check(Class<?> clazz) {
    return check(clazz.getName()) || check(clazz.getSimpleName());
  }

  public static boolean check(String name) {
    String command = System.getProperty("sun.java.command");

    Debug.debug(debug, "panamagl.Debug.check() : " + command);

    if (command.contains(name)) {
      return true;
    } else {
      return false;
    }
    // System.out.println("Debug for '" + name + "':'" + p + "'");

    // System.out.println(System.getProperties());

    // return Boolean.parseBoolean(p);
  }

  public static void debug(String message) {
    System.out.println(message);
  }

  public static void debug(boolean debug, String message) {
    if (debug)
      System.out.println(message);
  }

  public static void debug(boolean debug, Class<?> clazz, String message) {
    if (debug)
      System.out.println(clazz.getSimpleName() + " : " + message);
  }


  public static void print(double input[]) {
    for (int i = 0; i < input.length; i++) {
      System.out.print(input[i] + "|");
    }
    System.out.println("");
  }

  public static void print(float input[]) {
    for (int i = 0; i < input.length; i++) {
      System.out.print(input[i] + "|");
    }
    System.out.println("");
  }

  public static void print(byte input[]) {
    for (int i = 0; i < input.length; i++) {
      System.out.print(input[i] + "|");
    }
    System.out.println("");
  }

  public static void print(int input[]) {
    for (int i = 0; i < input.length; i++) {
      System.out.print(input[i] + "|");
    }
    System.out.println("");
  }

  public static void print(long input[]) {
    for (int i = 0; i < input.length; i++) {
      System.out.print(input[i] + "|");
    }
    System.out.println("");
  }

  public static void print(char input[]) {
    for (int i = 0; i < input.length; i++) {
      System.out.print(input[i] + "|");
    }
    System.out.println("");
  }

  public static void print(double input[][]) {
    for (int i = 0; i < input.length; i++) {
      for (int j = 0; j < input[i].length; j++) {
        System.out.print(input[i][j] + "\t");
      }
      System.out.println();
    }
  }

  public static void print(float input[][]) {
    for (int i = 0; i < input.length; i++) {
      for (int j = 0; j < input[i].length; j++) {
        System.out.print(input[i][j] + "\t");
      }
      System.out.println();
    }
  }

  public static void print(int input[][]) {
    for (int i = 0; i < input.length; i++) {
      for (int j = 0; j < input[i].length; j++) {
        System.out.print(input[i][j] + "\t");
      }
      System.out.println();
    }
  }

  public static void print(String info, double input[]) {
    System.out.print(info);
    print(input);
  }

  public static void print(String info, float input[]) {
    System.out.print(info);
    print(input);
  }

  public static void print(String info, int input[]) {
    System.out.print(info);
    print(input);
  }

  public static void print(String info, long input[]) {
    System.out.print(info);
    print(input);
  }

  public static void print(String info, char input[]) {
    System.out.print(info);
    print(input);
  }

  public static void print(String info, byte input[]) {
    System.out.print(info);
    print(input);
  }

}
