package panamagl.offscreen;

import javafx.application.Platform;

public class ThreadRedirect_JFX implements ThreadRedirect{

  @Override
  public void run(Runnable runnable) {
    Platform.runLater(runnable);    
  }

}
