package panamagl.os.linux;

import panamagl.os.Platform;

public class LinuxTest {
  /**
   * Indicate a message in console if not running on macos
   * @return
   */
  public boolean checkPlatform() {
    Platform os = new Platform();
    boolean isunix = os.isUnix();

    if(!isunix) {
      System.err.println(" !! \n    Skip test since not on Linux : " + os + "\n !!");
    }
    
    return isunix;
  }
  

}
