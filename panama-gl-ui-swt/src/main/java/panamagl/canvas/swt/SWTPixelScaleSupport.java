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

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Monitor;
import panamagl.canvas.PixelScale;
import panamagl.canvas.PixelScaleListener;

/**
 * HiDPI plumbing for {@link panamagl.canvas.swt.GLCanvasSWT GLCanvasSWT}.
 *
 * <p>Reads the pixel scale platform by platform:
 * <ul>
 * <li><b>cocoa</b>: {@link MacOSBackingScaleFactor#read(org.eclipse.swt.widgets.Control)}, because
 *     SWT's {@code Monitor.getZoom()} returns 100 on Retina;</li>
 * <li><b>gtk / win32</b>: {@code canvas.getMonitor().getZoom() / 100.0}.</li>
 * </ul>
 *
 * <p>Wires {@link SWT#ZoomChanged} on the display (available since SWT 4.24 / 3.122 — confirmed in
 * 3.126.0). On macOS, additionally listens to {@link SWT#Move} on the canvas because cocoa does
 * not fire ZoomChanged when the window is moved between Retina and non-Retina monitors.
 */
public class SWTPixelScaleSupport {

  private final Canvas canvas;
  private final List<PixelScaleListener> listeners = new CopyOnWriteArrayList<>();
  private volatile PixelScale lastScale = PixelScale.IDENTITY;

  private Listener zoomChangedListener;
  private Listener moveListener;
  private Display display;

  public SWTPixelScaleSupport(Canvas canvas) {
    this.canvas = canvas;
  }

  /** Read the current pixel scale based on the platform-specific source. */
  public PixelScale read() {
    if (canvas.isDisposed()) {
      return lastScale;
    }
    if ("cocoa".equals(SWT.getPlatform())) {
      double s = MacOSBackingScaleFactor.read(canvas);
      return new PixelScale(s, s);
    }
    Monitor monitor = canvas.getMonitor();
    double s = monitor != null ? monitor.getZoom() / 100.0 : 1.0;
    return new PixelScale(s, s);
  }

  public PixelScale current() {
    return lastScale;
  }

  /**
   * Install listeners. Idempotent. Must be called from the SWT display thread.
   */
  public void start() {
    if (zoomChangedListener != null) {
      return;
    }
    lastScale = read();

    display = canvas.getDisplay();

    zoomChangedListener = event -> recheckAndFire();
    display.addListener(SWT.ZoomChanged, zoomChangedListener);

    // On macOS, ZoomChanged does not fire when the window is moved between monitors of different
    // backing scale (e.g. Retina <-> external 1x screen). Use Move on the canvas to detect that.
    if ("cocoa".equals(SWT.getPlatform())) {
      moveListener = event -> recheckAndFire();
      canvas.addListener(SWT.Move, moveListener);
    }
  }

  public void stop() {
    if (zoomChangedListener == null) {
      return;
    }
    if (display != null && !display.isDisposed()) {
      display.removeListener(SWT.ZoomChanged, zoomChangedListener);
    }
    if (moveListener != null && !canvas.isDisposed()) {
      canvas.removeListener(SWT.Move, moveListener);
    }
    zoomChangedListener = null;
    moveListener = null;
    display = null;
  }

  public void addListener(PixelScaleListener l) {
    listeners.add(l);
  }

  public void removeListener(PixelScaleListener l) {
    listeners.remove(l);
  }

  private void recheckAndFire() {
    PixelScale prev = lastScale;
    PixelScale next = read();
    if (next.equals(prev)) {
      return;
    }
    lastScale = next;
    for (PixelScaleListener l : listeners) {
      l.pixelScaleChanged(prev, next);
    }
  }
}
