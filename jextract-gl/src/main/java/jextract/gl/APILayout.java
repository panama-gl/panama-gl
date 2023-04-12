package jextract.gl;

public interface APILayout {
  public static String MAVEN_GENERATED_JAVA_FOLDER = "src/generated/java/";

  String getOutputFolder(APIPlatform platform);
  String getPlatformPackage(APIPlatform platform);
}
