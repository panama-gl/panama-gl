package panamagl.os.macos;

import panamagl.GLCanvas;
import panamagl.factory.APanamaGLFactory;
import panamagl.factory.PanamaGLFactory;
import panamagl.offscreen.FBO;
import panamagl.offscreen.OffscreenRenderer;
import panamagl.opengl.GL;
import panamagl.opengl.GLContext;

public abstract class APanamaGLFactory_macOS extends APanamaGLFactory {

	public APanamaGLFactory_macOS() {
		super();
	}

	/**
	   * Invoked by the {@link GLCanvas}, i.e. canvas that wishes to draw
	   * offscreen rendered image.
	   * 
	   * The offscreen renderer will initialize {@link GL}, {@link GLContext} and {@link FBO} 
	   * instances through this factory.
	   */
	@Override
	public OffscreenRenderer newOffscreenRenderer() {
	    return new OffscreenRenderer_macOS(this);
	  }

}