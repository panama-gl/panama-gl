/*******************************************************************************
 * Copyright (c) 2022, 2023 Martin Pernollet & contributors.
 *
 * This library is free software; you can redistribute it and/or modify it under the terms of the
 * GNU Lesser General Public License as published by the Free Software Foundation; either version
 * 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License along with this library;
 * if not, write to the Free Software Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA
 * 02110-1301, USA
 *******************************************************************************/
package panamagl.canvas;

import java.awt.GraphicsEnvironment;
import java.awt.Panel;
import javax.swing.SwingUtilities;
import org.junit.Assert;
import org.junit.Assume;
import org.junit.Test;

public class TestAWTPixelScaleSupport {

  @org.junit.Before
  public void requireHeadful() {
    Assume.assumeFalse("AWT tests require a display", GraphicsEnvironment.isHeadless());
  }

  @Test
  public void read_returnsIdentity_whenComponentNotDisplayable() {
    Panel p = new Panel();
    AWTPixelScaleSupport support = new AWTPixelScaleSupport(p, false, 0);
    PixelScale s = support.read();
    // Not displayable yet -> support returns the cached lastScale, which starts at IDENTITY.
    Assert.assertEquals(PixelScale.IDENTITY, s);
  }

  @Test
  public void start_isIdempotent() {
    Panel p = new Panel();
    AWTPixelScaleSupport support = new AWTPixelScaleSupport(p, false, 0);
    support.start();
    support.start(); // must not throw or double-register
    support.stop();
  }

  @Test
  public void stop_isIdempotent() {
    Panel p = new Panel();
    AWTPixelScaleSupport support = new AWTPixelScaleSupport(p, false, 0);
    support.stop(); // before start
    support.start();
    support.stop();
    support.stop(); // double stop
  }

  @Test
  public void listeners_canBeAddedAndRemoved() {
    Panel p = new Panel();
    AWTPixelScaleSupport support = new AWTPixelScaleSupport(p, false, 0);
    PixelScaleListener l = (o, n) -> {};
    support.addListener(l);
    support.removeListener(l);
  }

  @Test
  public void pollingFlag_defaultsToTrue() {
    AWTPixelScaleSupport support = new AWTPixelScaleSupport(new Panel());
    Assert.assertTrue(support.isPollingEnabled());
    Assert.assertEquals(AWTPixelScaleSupport.DEFAULT_POLL_INTERVAL_MS, support.getPollIntervalMs());
  }

  @Test
  public void recheckOnEDT_doesNotThrow() throws Exception {
    Panel p = new Panel();
    AWTPixelScaleSupport support = new AWTPixelScaleSupport(p, false, 0);
    support.start();
    SwingUtilities.invokeAndWait(() -> {
      // Force a read on the EDT — current() should return a valid scale.
      Assert.assertNotNull(support.current());
    });
    support.stop();
  }
}
