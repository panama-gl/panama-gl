/*******************************************************************************
 * Copyright (c) 2022 Martin Pernollet & contributors.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301, USA
 *******************************************************************************/
package org.jzy3d.plot3d.rendering.view;

import org.jzy3d.painters.PanamaGLPainter;

public class PanamaGLRenderer {
  protected View view;
  
  protected boolean init = false;
  
  public PanamaGLRenderer(View view) {
    this.view = view;
  }

  public void display() {
    if(!init) {
      view.init();
      init = true;
    }
    view.clear();
    view.render();

    PanamaGLPainter painter = (PanamaGLPainter)view.getPainter();

    painter.glutSwapBuffers();
  }

  public void reshape(int width, int height) {
    display();
  }

  public void onIdle() {
    PanamaGLPainter painter = (PanamaGLPainter)view.getPainter();
    painter.glutPostRedisplay();
  }

}
