package panamagl.os.macos.x86_64;

import panamagl.os.Platform;

public class MacOSTest {
  /**
   * Indicate a message in console if not running on macos
   * @return
   */
  public boolean checkPlatform() {
    Platform os = new Platform();
    boolean ismacos = os.isMac();

    if(!ismacos) {
      System.err.println(" !! \n    Skip test since not on macOS : " + os + "\n !!");
    }
    
    return ismacos;
  }
  

}
