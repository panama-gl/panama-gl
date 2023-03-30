package panamagl.factory;

import panamagl.offscreen.FBOReader;
import panamagl.offscreen.OffscreenRenderer;
import panamagl.offscreen.ThreadRedirect_JFX;
import panamagl.platform.macos.OffscreenRenderer_macOS;
import panamagl.platform.macos.arm.PanamaGLFactory_macOS_arm;
import panamagl.platform.windows.x64.PanamaGLFactory_windows_x64;

public class PanamaGLFactory_macOS_JFX extends PanamaGLFactory_macOS_arm{
  @Override
  public OffscreenRenderer newOffscreenRenderer(FBOReader reader) {
    OffscreenRenderer or = new OffscreenRenderer_macOS(this, reader) ;
    or.setThreadRedirect(new ThreadRedirect_JFX());
    return or;
  }

}
