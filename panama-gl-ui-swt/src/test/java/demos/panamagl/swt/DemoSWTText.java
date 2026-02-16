package demos.panamagl.swt;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import panamagl.GLEventListener;
import panamagl.canvas.swt.GLCanvasSWT_direct;
import panamagl.factory.PanamaGLFactory;
import panamagl.opengl.GL;

public class DemoSWTText implements GLEventListener {
	
	
	private GLCanvasSWT_direct canvas;

	public DemoSWTText(GLCanvasSWT_direct canvas) {
		this.canvas = canvas;
	}

	public static void main(String[] args) {
		PanamaGLFactory factory = PanamaGLFactory.select();
		System.out.println("Factory selected: "+factory);
		final Display display = new Display();
		Shell shell = new Shell(display);
		shell.setText("Some Strings");
		shell.setLayout(new FillLayout());
		GLCanvasSWT_direct canvas = new GLCanvasSWT_direct(shell, SWT.NONE, factory);
		Font font = new Font(display, "Arial", 48, SWT.BOLD);
		
		canvas.setFont(font);
		canvas.addDisposeListener(e -> font.dispose());
		DemoSWTText torus = new DemoSWTText(canvas);
		canvas.setGLEventListener(torus);
		shell.setSize(640, 480);
		shell.open();
		while(!shell.isDisposed()) {
			if(!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
	}

	@Override
	public void init(GL gl) {
		
	}

	@Override
	public void display(GL gl) {
		Display display = canvas.getDisplay();
		canvas.clear();
		canvas.orthographic();
		canvas.setColor(display.getSystemColor(SWT.COLOR_BLUE));
		canvas.drawString("Hello OpenGL", 100, 100);
		//canvas.setColor(display.getSystemColor(SWT.COLOR_DARK_RED));
		//gl.glLoadIdentity();
		//drawRect(gl, 100, 100, 200, 200);
		drawRect(gl, -100, -100, 200, 200);
		//drawRect(gl, -0.5, -0.5, 1, 1);
	}

	@Override
	public void reshape(GL gl, int x, int y, int width, int height) {
		gl.glViewport(0, 0, width, height);
	}

	@Override
	public void dispose(GL gl) {
	}
	
	private void drawRect(GL gl, double x, double y, double w, double h) {
		gl.glBegin(GL.GL_QUADS);
		gl.glVertex3d(x, y, 0);
		gl.glVertex3d(x + w, y, 0);
		gl.glVertex3d(x + w, y + h, 0);
		gl.glVertex3d(x, y + h, 0);
		gl.glEnd();

	}

}
