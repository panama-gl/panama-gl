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
package org.jzy3d.chart;

import java.awt.Canvas;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.jzy3d.chart.factories.IFrame;
import org.jzy3d.maths.Rectangle;
import org.jzy3d.painters.PanamaGLPainter;

/**
 * This is not a real frame, but just a simple class calling the appropriate painter method to open a native frame.
 */
public class PanamaGLFrame implements IFrame {
    Thread glutBackgroundThread;

    public PanamaGLFrame(Chart chart) {
        this(chart, new Rectangle(0, 0, 800, 600), "");
    }

    public PanamaGLFrame(Chart chart, Rectangle bounds, String title) {
        initialize(chart, bounds, title);
    }

    @Override
    public void initialize(Chart chart, Rectangle bounds, String title) {
        initialize(chart, bounds, title, "PanamaGL");
    }

    @Override
    public void initialize(Chart chart, Rectangle bounds, String title, String message) {
        getPixelScaleWithShortFrame(chart);

        PanamaGLPainter painter = (PanamaGLPainter) chart.getPainter();

        painter.glutStart(chart, bounds, title, message);

        /*// Attempted access outside owning thread
        glutBackgroundThread = new Thread(new Runnable(){
            @Override
            public void run() {
                glutStart(chart, bounds, title, message);
            }
        });
        glutBackgroundThread.start();*/
    }

    private void getPixelScaleWithShortFrame(Chart chart) {
        CountDownLatch latch = new CountDownLatch(1);
        Canvas canvas = new Canvas(){
            @Override
            public void paint(Graphics g){
                System.out.println("PanamaGLFrame : Start painting dummy canvas to retrieve pixel scale");

                Graphics2D g2d = (Graphics2D)g;
                AffineTransform globalTransform = g2d.getTransform();
                float[] pixelScale = new float[2];
                pixelScale[0] = (float)globalTransform.getScaleX();
                pixelScale[1] = (float)globalTransform.getScaleY();

                chart.getCanvas().setPixelScale(pixelScale);

                System.out.println("scale.x:"+pixelScale[0]+" scale.y:"+pixelScale[1]);
                latch.countDown();
            }
        };

        Frame f = new Frame();
        f.add(canvas);
        f.setBounds(-10,-10,1,1);
        f.setVisible(true);
        try {
            latch.await(500, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        f.setVisible(false);
    }
}
