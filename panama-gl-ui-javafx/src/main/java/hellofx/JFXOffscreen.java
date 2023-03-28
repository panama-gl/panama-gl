package hellofx;

import panamagl.offscreen.OffscreenRenderer;

public class JFXOffscreen {
  OffscreenRenderer renderer;

  public JFXOffscreen(OffscreenRenderer renderer) {
    super();
    this.renderer = renderer;
    
    
    
  }
  
 /* protected void renderGLToImage(GLCanvas canvas, GLEventListener listener) {

    // Render GL
    if (listener != null)
      listener.display(gl);


    // FBO To image
    if (fbo != null) {
      Image<?> out = fbo.getImage(gl);
      
      SwingFXUtils.toFXImage(i, null);

      // Give back the image to the onscreen panel
      canvas.setScreenshot(out);

      // The image has been rendered in main thread,
      // now we want to notify the component that it is ready
      // for rendering in the AWT Thread

      canvas.repaint();
      
    } else {
      System.err.println("FBO is null!");
    }
  }*/
    
}
