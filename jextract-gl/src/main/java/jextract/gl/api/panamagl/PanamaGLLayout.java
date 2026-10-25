package jextract.gl.api.panamagl;

import jextract.gl.APILayout;
import jextract.gl.APIPlatform;
import jextract.gl.APIPlatform.OS;

public class PanamaGLLayout implements APILayout {
  public static String GL_PACKAGE = "panamagl.opengl";
  public static String GL_PACKAGE_MACOS = "panamagl.platform.macos";
  public static String GL_PACKAGE_LINUX = "panamagl.platform.linux";
  public static String GL_PACKAGE_WINDOWS = "panamagl.platform.windows";

  protected String root;
  protected String glSourcesAPI;
  protected String glSourcesMacOS;
  protected String glSourcesLinux;
  protected String glSourcesWindows;

  public PanamaGLLayout() {
    this("../");
  }

  public PanamaGLLayout(String root) {
    reset(root);
  }

  public void reset(String root) {
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
      return GL_PACKAGE_MACOS;
    } else if (OS.linux.equals(platform.os)) {
      return GL_PACKAGE_LINUX;
    } else if (OS.windows.equals(platform.os)) {
      return GL_PACKAGE_WINDOWS;
    }
    return GL_PACKAGE;
  }

}
