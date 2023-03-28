/**
 * Copyright (c) 2019, 2023 Gluon All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification, are permitted
 * provided that the following conditions are met: * Redistributions of source code must retain the
 * above copyright notice, this list of conditions and the following disclaimer. * Redistributions
 * in binary form must reproduce the above copyright notice, this list of conditions and the
 * following disclaimer in the documentation and/or other materials provided with the distribution.
 * * Neither the name of Gluon, any associated website, nor the names of its contributors may be
 * used to endorse or promote products derived from this software without specific prior written
 * permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR
 * IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
 * FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL GLUON BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR
 * BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT
 * LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package hellofx;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import panamagl.factory.PanamaGLFactory;


public class HelloPanamaFX extends Application {

  public void start(Stage stage) {
    
    PanamaGLFactory factory = PanamaGLFactory.select();
    
    //OffscreenRenderer renderer = factory.newOffscreenRenderer(new FBOReader_AWT());
    
    String javaVersion = System.getProperty("java.version");
    String javafxVersion = System.getProperty("javafx.version");
    Label label =
        new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");

    ImageView imageView =
        new ImageView(new Image(HelloPanamaFX.class.getResourceAsStream("/hellofx/openduke.png")));
    imageView.setFitHeight(200);
    imageView.setPreserveRatio(true);

    VBox root = new VBox(30, imageView, label);
    root.setAlignment(Pos.CENTER);
    Scene scene = new Scene(root, 640, 480);
    scene.getStylesheets().add(HelloPanamaFX.class.getResource("styles.css").toExternalForm());
    stage.setScene(scene);
    stage.show();
  }
  
  /*protected void bind(final ImageView imageView, AWTChart chart) {

    // Set listener on renderer to update imageView
    renderer.addDisplayListener(new DisplayListener() {
      @Override
      public void onDisplay(Object image) {
        if (image != null) {
          javafx.scene.image.Image img = (javafx.scene.image.Image) image;

          //System.out.println("JavaFXOffscreenBinding.bind receives an image of size "
          //    + img.getWidth() + " x " + img.getHeight());

          imageView.setImage(img);

        } else {
          LOGGER.error("image is null while listening to renderer");
        }
      }
    });
  }*/

  public static void main(String[] args) {
    launch(args);
  }

}
