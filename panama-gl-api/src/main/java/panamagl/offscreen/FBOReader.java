package panamagl.offscreen;

import panamagl.Image;
import panamagl.opengl.GL;

/**
 * An {@link FBOReader} reads a pixel buffer provided by an {@link FBO} and creates an {@link Image}
 * matching the target windowing toolkit.
 * 
 * While an {@link FBO} implementation relates to a target operating system (such as macOS, Windows,
 * Linux), an {@link FBOReader} relates to a target windowing toolkit (such as AWT, Swing, JavaFX,
 * SWT)
 * 
 * @author Martin Pernollet
 */
public interface FBOReader {
  Image<?> read(FBO fbo, GL gl);
}
