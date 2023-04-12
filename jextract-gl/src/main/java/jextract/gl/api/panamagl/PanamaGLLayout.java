package jextract.gl.api.panamagl;

import jextract.gl.APILayout;
import jextract.gl.APIPlatform;
import jextract.gl.APIPlatform.CPU;
import jextract.gl.APIPlatform.OS;

public class PanamaGLLayout implements APILayout {
  public static String GL_PACKAGE = "panamagl.opengl";
  public static String GL_PACKAGE_MACOS_x64 = "panamagl.platform.macos.x64";
  public static String GL_PACKAGE_MACOS_arm = "panamagl.platform.macos.arm";
  public static String GL_PACKAGE_LINUX_x64 = "panamagl.platform.linux.x64";
  public static String GL_PACKAGE_WINDOWS_x64 = "panamagl.platform.windows.x64";

  protected String root;
  protected String glSourcesAPI;
  protected String glSourcesMacOS;
  protected String glSourcesLinux;
  protected String glSourcesWindows;

  public PanamaGLLayout() {
    this("../");
  }

  public PanamaGLLayout(String root) {
    this.root = root;

    this.glSourcesAPI = root + "panama-gl-api/" + MAVEN_GENERATED_JAVA_FOLDER;
    this.glSourcesMacOS = root + "panama-gl-wrappers-macos/" + MAVEN_GENERATED_JAVA_FOLDER;
    this.glSourcesLinux = root + "panama-gl-wrappers-linux/" + MAVEN_GENERATED_JAVA_FOLDER;
    this.glSourcesWindows = root + "panama-gl-wrappers-windows/" + MAVEN_GENERATED_JAVA_FOLDER;

  }



  @Override
  public String getOutputFolder(APIPlatform platform) {
    if (OS.api.equals(platform.os)) {
      return glSourcesAPI;
    } else if (OS.macOS.equals(platform.os)) {
      return glSourcesMacOS;
    } else if (OS.linux.equals(platform.os)) {
      return glSourcesLinux;
    } else if (OS.windows.equals(platform.os)) {
      return glSourcesWindows;
    }
    return null;
  }

  @Override
  public String getPlatformPackage(APIPlatform platform) {
    if (OS.macOS.equals(platform.os)) {
      if (CPU.x64.equals(platform.cpu))
        return GL_PACKAGE_MACOS_x64;
      else if (CPU.arm.equals(platform.cpu))
        return GL_PACKAGE_MACOS_arm;
    } else if (OS.linux.equals(platform.os)) {
      if (CPU.x64.equals(platform.cpu))
        return GL_PACKAGE_LINUX_x64;
    } else if (OS.windows.equals(platform.os)) {
      if (CPU.x64.equals(platform.cpu))
        return GL_PACKAGE_WINDOWS_x64;
    }
    return GL_PACKAGE;
  }

}
