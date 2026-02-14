/*******************************************************************************
 * Copyright (c) 2000, 2023 IBM Corporation and others.
 *
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Christoph Läubrich - adjusted to use panama
 *******************************************************************************/
package demos.panamagl.swt;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import panamagl.GLEventListener;
import panamagl.canvas.swt.GLCanvasSWT;
import panamagl.factory.PanamaGLFactory;
import panamagl.opengl.GL;

//LINUX: --enable-native-access=ALL-UNNAMED -Djava.library.path=.:/usr/lib/x86_64-linux-gnu/
public class DemoSWTThorus implements GLEventListener {
	
	int rot = 0;
	
	static void drawTorus(GL gl, float r, float R, int nsides, int rings) {
		float ringDelta = 2.0f * (float) Math.PI / rings;
		float sideDelta = 2.0f * (float) Math.PI / nsides;
		float theta = 0.0f, cosTheta = 1.0f, sinTheta = 0.0f;
		for (int i = rings - 1; i >= 0; i--) {
			float theta1 = theta + ringDelta;
			float cosTheta1 = (float) Math.cos(theta1);
			float sinTheta1 = (float) Math.sin(theta1);
			gl.glBegin(GL.GL_QUAD_STRIP);
			float phi = 0.0f;
			for (int j = nsides; j >= 0; j--) {
				phi += sideDelta;
				float cosPhi = (float) Math.cos(phi);
				float sinPhi = (float) Math.sin(phi);
				float dist = R + r * cosPhi;
				gl.glNormal3f(cosTheta1 * cosPhi, -sinTheta1 * cosPhi, sinPhi);
				gl.glVertex3f(cosTheta1 * dist, -sinTheta1 * dist, r * sinPhi);
				gl.glNormal3f(cosTheta * cosPhi, -sinTheta * cosPhi, sinPhi);
				gl.glVertex3f(cosTheta * dist, -sinTheta * dist, r * sinPhi);
			}
			gl.glEnd();
			theta = theta1;
			cosTheta = cosTheta1;
			sinTheta = sinTheta1;
		}
		
		//gl.glFlush();
	}
	
	public static void main(String[] args) {
		PanamaGLFactory factory = PanamaGLFactory.select();
		System.out.println("Factory selected: "+factory);
		final Display display = new Display();
		Shell shell = new Shell(display);
		shell.setText("SWT Thorus");
		shell.setLayout(new FillLayout());
		GLCanvasSWT canvas = new GLCanvasSWT(shell, SWT.NONE, factory);
		DemoSWTThorus torus = new DemoSWTThorus();
		canvas.setGLEventListener(torus);
		display.asyncExec(new Runnable() {

			
			@Override
			public void run() {
				torus.rot++;
				canvas.display();
				display.asyncExec(this);
			}
		});
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
		//System.out.println("TheTorus.init()");
		gl.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
		gl.glColor3f(1.0f, 0.0f, 0.0f);
		gl.glHint(GL.GL_PERSPECTIVE_CORRECTION_HINT, GL.GL_NICEST);
		gl.glClearDepth(1.0);
		gl.glLineWidth(2);
		gl.glEnable(GL.GL_DEPTH_TEST);
	}

	@Override
	public void display(GL gl) {
      //System.out.println("TheTorus.display()");
		gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
		gl.glClearColor(.3f, .5f, .8f, 1.0f);
		gl.glLoadIdentity();
		gl.glTranslatef(0.0f, 0.0f, -10.0f);
		float frot = rot;
		gl.glRotatef(0.15f * rot, 2.0f * frot, 10.0f * frot, 1.0f);
		gl.glRotatef(0.3f * rot, 3.0f * frot, 1.0f * frot, 1.0f);
		gl.glPolygonMode(GL.GL_FRONT_AND_BACK, GL.GL_LINE);
		gl.glColor3f(0.9f, 0.9f, 0.9f);
		drawTorus(gl, 1, 1.9f + ((float) Math.sin((0.004f * frot))), 15, 15);
	}

	@Override
	public void reshape(GL gl, int x, int y, int width, int height) {
		//System.out.println("TheTorus.reshape()");
		gl.glViewport(0, 0, width, height);
		float fAspect = (float) width / (float) height;
		gl.glMatrixMode(GL.GL_PROJECTION);
		gl.glLoadIdentity();
		float near = 0.5f;
		float bottom = -near * (float) Math.tan(45.f / 2);
		float left = fAspect * bottom;
		gl.glFrustum(left, -left, bottom, -bottom, near, 400.f);
		gl.glMatrixMode(GL.GL_MODELVIEW);
		gl.glLoadIdentity();
	}

	@Override
	public void dispose(GL gl) {
		//nothing here to do at the moment
		//System.out.println("TheTorus.dispose()");
	}
}
