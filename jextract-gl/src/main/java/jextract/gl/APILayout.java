package jextract.gl;

public interface APILayout {
  String getOutputFolder(APIPlatform platform);
  String getPlatformPackage(APIPlatform platform);
}
