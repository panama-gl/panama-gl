package panamagl.os.linux;

import panamagl.os.OperatingSystem;

public class LinuxTest {
  /**
   * Indicate a message in console if not running on macos
   * @return
   */
  public boolean checkPlatform() {
    OperatingSystem os = new OperatingSystem();
    boolean isunix = os.isUnix();

    if(!isunix) {
      System.err.println("Skip test since not on Linux : " + os);
    }
    
    return isunix;
  }
  

}
