package panamagl.os.macos;

import panamagl.os.OperatingSystem;

public class MacOSTest {
  /**
   * Indicate a message in console if not running on macos
   * @return
   */
  public boolean checkPlatform() {
    OperatingSystem os = new OperatingSystem();
    boolean ismacos = os.isMac();

    if(!ismacos) {
      System.err.println("Skip test since not on macOS : " + os);
    }
    
    return ismacos;
  }
  

}
