/*******************************************************************************
 * Copyright (c) 2023 Martin Pernollet and others
 *
 * This program and the accompanying materials are made available under the terms of the Eclipse
 * Public License 2.0 which is available at http://www.eclipse.org/legal/epl-2.0.
 *
 * This Source Code may also be made available under the following Secondary Licenses when the
 * conditions for such availability set forth in the Eclipse Public License, v. 2.0 are satisfied:
 * GNU General Public License, version 2 with the GNU Classpath Exception which is available at
 * https://www.gnu.org/software/classpath/license.html.
 *
 * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
 ********************************************************************************/
package panamagl.canvas.swt;

import java.awt.GraphicsEnvironment;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.junit.After;
import org.junit.Assert;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;
import panamagl.canvas.PixelScale;
import panamagl.canvas.PixelScaleListener;

public class TestSWTPixelScaleSupport {

  private Display display;
  private Shell shell;
  private Canvas canvas;

  @Before
  public void setup() {
    Assume.assumeFalse(GraphicsEnvironment.isHeadless());
    display = Display.getDefault();
    shell = new Shell(display);
    canvas = new Canvas(shell, SWT.NONE);
  }

  @After
  public void teardown() {
    if (shell != null && !shell.isDisposed()) {
      shell.dispose();
    }
  }

  @Test
  public void read_returnsPositiveScale() {
    SWTPixelScaleSupport support = new SWTPixelScaleSupport(canvas);
    PixelScale s = support.read();
    Assert.assertNotNull(s);
    Assert.assertTrue("scale.x must be > 0, was " + s.x(), s.x() > 0);
    Assert.assertTrue("scale.y must be > 0, was " + s.y(), s.y() > 0);
  }

  @Test
  public void start_isIdempotent() {
    SWTPixelScaleSupport support = new SWTPixelScaleSupport(canvas);
    support.start();
    support.start(); // must not throw
    support.stop();
  }

  @Test
  public void stop_isIdempotent() {
    SWTPixelScaleSupport support = new SWTPixelScaleSupport(canvas);
    support.stop(); // before start
    support.start();
    support.stop();
    support.stop(); // double stop
  }

  @Test
  public void start_then_stop_capturesInitialValue() {
    SWTPixelScaleSupport support = new SWTPixelScaleSupport(canvas);
    support.start();
    PixelScale s = support.current();
    Assert.assertNotNull(s);
    Assert.assertTrue(s.x() > 0);
    support.stop();
  }

  @Test
  public void listeners_canBeAddedAndRemoved() {
    SWTPixelScaleSupport support = new SWTPixelScaleSupport(canvas);
    PixelScaleListener l = (o, n) -> {};
    support.addListener(l);
    support.removeListener(l);
  }

  @Test
  public void onCocoa_scaleIsAtLeastOne() {
    Assume.assumeTrue("cocoa".equals(SWT.getPlatform()));
    SWTPixelScaleSupport support = new SWTPixelScaleSupport(canvas);
    PixelScale s = support.read();
    // Backing scale factor is always >= 1.0 on cocoa.
    Assert.assertTrue("backing scale >= 1.0 expected, got " + s.x(), s.x() >= 1.0);
  }
}
