package hellofx;

import panamagl.offscreen.FBOReader;
import panamagl.offscreen.OffscreenRenderer;
import panamagl.offscreen.ThreadRedirect_JFX;
import panamagl.platform.windows.OffscreenRenderer_windows;
import panamagl.platform.windows.x64.PanamaGLFactory_windows_x64;

public class PanamaGLFactory_windows_JFX extends PanamaGLFactory_windows_x64{
  @Override
  public OffscreenRenderer newOffscreenRenderer(FBOReader reader) {
    OffscreenRenderer or = new OffscreenRenderer_windows(this, reader) ;
    or.setThreadRedirect(new ThreadRedirect_JFX());
    return or;
  }

}
