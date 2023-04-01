package panamagl.factory;

import panamagl.offscreen.FBOReader;
import panamagl.offscreen.OffscreenRenderer;
import panamagl.offscreen.ThreadRedirect_JFX;
import panamagl.platform.linux.OffscreenRenderer_linux;
import panamagl.platform.linux.x64.PanamaGLFactory_linux_x64;

public class PanamaGLFactory_linux_JFX extends PanamaGLFactory_linux_x64{
  @Override
  public OffscreenRenderer newOffscreenRenderer(FBOReader reader) {
    OffscreenRenderer or = new OffscreenRenderer_linux(this, reader) ;
    or.setThreadRedirect(new ThreadRedirect_JFX());
    return or;
  }

}
