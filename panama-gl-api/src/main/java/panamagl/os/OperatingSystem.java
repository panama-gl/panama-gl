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
package panamagl.os;

public class OperatingSystem {
  public static OperatingSystem MACOS = new OperatingSystem("macos"); 
  public static OperatingSystem WINDOWS = new OperatingSystem("windows"); 
  public static OperatingSystem UNIX = new OperatingSystem("unix"); 

  protected String name;
  protected String version;
  protected String arch;
  
  protected String jvm;
  
  protected boolean windows;
  protected boolean mac;
  protected boolean unix;
  protected boolean solaris;

  public OperatingSystem() {
    this(System.getProperty("os.name"), System.getProperty("os.version"));  
  }

  public OperatingSystem(String osName) {
    this(osName, "?");
  }
  
  /** Mainly for test purpose.*/
  public OperatingSystem(String osName, String osVersion) {
    this.name = formatName(osName);
    this.version = osVersion;
    
    this.arch = System.getProperty("os.arch");
    this.jvm = System.getProperty("java.version");
    
    this.windows = (name.indexOf("win") >= 0);
    this.mac = (name.indexOf("mac") >= 0);
    this.unix =
        (name.indexOf("nix") >= 0 || name.indexOf("nux") >= 0 || name.indexOf("aix") > 0);
    this.solaris = (name.indexOf("sunos") >= 0);    
  }

  protected String formatName(String osName) {
    return osName.toLowerCase();
  }
  
  public OperatingSystem(String osName, String osVersion, String arch, String java, boolean windows, boolean mac, boolean unix, boolean solaris) {
    this.name = formatName(osName);
    this.version = osVersion;
    this.arch = arch;
    this.jvm = java;
    this.windows = windows;
    this.mac = mac;
    this.unix = unix;
    this.solaris = solaris;    
  }
  
  public String getName() {
    return name;
  }
  
  public String getVersion() {
    return version;
  }

  public String getJavaVersion() {
    return jvm;
  }

  public String getArch() {
    return arch;
  }

  public boolean isWindows() {
    return windows;
  }

  public boolean isMac() {
    return mac;
  }

  public boolean isUnix() {
    return unix;
  }

  public boolean isSolaris() {
    return solaris;
  }

  public String toString() {
    return "OS name:" + name + " version:" + version + " CPU:" +arch + " JVM:" + jvm;
  }

  public static void main(String[] args) {
    OperatingSystem os = new OperatingSystem();

    if (os.isWindows()) {
      System.out.println("This is Windows");
    } else if (os.isMac()) {
      System.out.println("This is Mac");
    } else if (os.isUnix()) {
      System.out.println("This is Unix or Linux");
    } else if (os.isSolaris()) {
      System.out.println("This is Solaris");
    } else {
      System.out.println("Your OS is not support!!");
    }
    
    System.out.println(os);
  }

}
