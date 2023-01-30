/*******************************************************************************
 * Copyright (c) 2022, 2023 Martin Pernollet & contributors.
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
package org.jzy3d.painters;

import java.lang.foreign.MemorySegment;
import java.lang.foreign.MemorySession;
import java.lang.foreign.SegmentAllocator;
import org.jzy3d.chart.Chart;
import org.jzy3d.maths.Rectangle;

public interface PanamaGLPainter extends IPainter{
    public MemorySession getScope();

    public SegmentAllocator getAllocator();

    public MemorySegment alloc(double[] value);

    public MemorySegment alloc(float[] value);

    public MemorySegment alloc(int[] value);

    public MemorySegment alloc(String value);

    public String glGetString(int stringID);

    /**
     * This temporary helper allows starting a GLUT window like an AWT Frame would start
     * for a Jzy3D chart.
     *
     * IT IS NOT the name of an existing GLUT function.
     *
     * @param chart
     * @param bounds
     * @param title
     * @param message
     */
    public void glutStart(Chart chart, Rectangle bounds, String title, String message);


    public void glutSwapBuffers();

    public void glutPostRedisplay();

    public int glutGetWindowWidth();
    public int glutGetWindowHeight();

}
