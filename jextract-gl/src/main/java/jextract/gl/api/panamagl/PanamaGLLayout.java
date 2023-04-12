package jextract.gl.api.panamagl;

import jextract.gl.APILayout;
import jextract.gl.APIPlatform;
import jextract.gl.APIPlatform.CPU;
import jextract.gl.APIPlatform.OS;

public class PanamaGLLayout implements APILayout{
  public static String ROOT = "../";
  public static String GL_INTERFACE_SOURCES = ROOT+"panama-gl-api/src/generated/java/";
  public static String GL_MACOS_SOURCES = ROOT+"panama-gl-wrappers-macos/src/generated/java/";
  public static String GL_LINUX_SOURCES = ROOT+"panama-gl-wrappers-linux/src/generated/java/";
  public static String GL_WINDOWS_SOURCES = ROOT+"panama-gl-wrappers-windows/src/generated/java/";
  
  public static String GL_PACKAGE = "panamagl.opengl";
  
  public static String GL_PACKAGE_MACOS_x64 = "panamagl.platform.macos.x64";
  public static String GL_PACKAGE_MACOS_arm = "panamagl.platform.macos.arm";
  public static String GL_PACKAGE_LINUX_x64 = "panamagl.platform.linux.x64";
  public static String GL_PACKAGE_WINDOWS_x64 = "panamagl.platform.windows.x64";


  @Override
  public String getOutputFolder(APIPlatform platform) {
    if(OS.macOS.equals(platform.os)) {
      return GL_MACOS_SOURCES;
    }
    else if(OS.linux.equals(platform.os)) {
      return GL_LINUX_SOURCES;
    }
    else if(OS.windows.equals(platform.os)) {
      return GL_WINDOWS_SOURCES;
    }
    return GL_INTERFACE_SOURCES;
  }

  @Override
  public String getPlatformPackage(APIPlatform platform) {
    if(OS.macOS.equals(platform.os)) {
      if(CPU.x64.equals(platform.cpu))
        return GL_PACKAGE_MACOS_x64;
      else if(CPU.arm.equals(platform.cpu))
        return GL_PACKAGE_MACOS_arm;
    }
    else if(OS.linux.equals(platform.os)) {
      if(CPU.x64.equals(platform.cpu))
        return GL_PACKAGE_LINUX_x64;
    }
    else if(OS.windows.equals(platform.os)) {
      if(CPU.x64.equals(platform.cpu))
        return GL_PACKAGE_WINDOWS_x64;
    }
    return GL_PACKAGE;  
    }

}
