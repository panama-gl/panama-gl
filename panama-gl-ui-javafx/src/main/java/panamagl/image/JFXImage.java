package panamagl.image;

import java.io.IOException;
import javafx.scene.image.WritableImage;
import panamagl.Image;

public class JFXImage implements Image<WritableImage>{
  WritableImage image;

  public JFXImage(WritableImage image) {
    this.image = image;
  }

  @Override
  public WritableImage getImage() {
    return image;
  }

  @Override
  public void save(String file) throws IOException {
    throw new RuntimeException("Not implemented yet");
    
  }
  
  public void setImage(WritableImage image) {
    this.image = image;
  }
  
  @Override
  public int getWidth() {
    return (int)image.getWidth();
  }
  
  @Override
  public int getHeight() {
    return (int)image.getHeight();
  }

}
