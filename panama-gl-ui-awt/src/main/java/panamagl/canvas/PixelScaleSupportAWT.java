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

import java.awt.Component;
import java.awt.GraphicsConfiguration;
import java.awt.event.HierarchyEvent;
import java.awt.event.HierarchyListener;
import java.beans.PropertyChangeListener;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javax.swing.SwingUtilities;

/**
 * Shared HiDPI plumbing for AWT and Swing canvases.
 *
 * <p>Reads the current pixel scale via
 * {@link GraphicsConfiguration#getDefaultTransform()} (Java 9+) and notifies registered
 * {@link PixelScaleListener}s when it changes. Three signals trigger a re-check:
 *
 * <ul>
 * <li>{@code "graphicsConfiguration"} property change — fired when the component is moved between
 *     monitors of different DPI;</li>
 * <li>{@link HierarchyEvent#DISPLAYABILITY_CHANGED} — captures the initial value once the component
 *     is attached to a peer;</li>
 * <li>polling on a background thread (default 200&nbsp;ms) — fallback for cases where neither of
 *     the above fires (some JVMs, mixed-DPI setups).</li>
 * </ul>
 *
 * <p>Listeners always run on the EDT.
 */
public class PixelScaleSupportAWT {

  /**
   * Default polling interval in milliseconds. Polling is enabled by default to cover platforms or
   * JVMs where AWT does not publish {@code graphicsConfiguration} property change events
   * consistently.
   */
  public static final long DEFAULT_POLL_INTERVAL_MS = 200;

  private final Component component;
  private final List<PixelScaleListener> listeners = new CopyOnWriteArrayList<>();
  private volatile PixelScale lastScale = PixelScale.IDENTITY;
  private volatile boolean pollingEnabled;
  private long pollIntervalMs;

  private PropertyChangeListener gcListener;
  private HierarchyListener hierarchyListener;
  private ScheduledExecutorService poller;
  private ScheduledFuture<?> pollerFuture;

  public PixelScaleSupportAWT(Component component) {
    this(component, true, DEFAULT_POLL_INTERVAL_MS);
  }

  public PixelScaleSupportAWT(Component component, boolean pollingEnabled, long pollIntervalMs) {
    this.component = component;
    this.pollingEnabled = pollingEnabled;
    this.pollIntervalMs = pollIntervalMs;
  }

  /**
   * Read the current pixel scale from the component's {@link GraphicsConfiguration}. Returns the
   * last known value if the component is not yet displayable.
   */
  public PixelScale read() {
    GraphicsConfiguration gc = component.getGraphicsConfiguration();
    if (gc == null) {
      return lastScale;
    }
    var t = gc.getDefaultTransform();
    return new PixelScale(t.getScaleX(), t.getScaleY());
  }

  /** Last value reported to listeners. Updated only on the EDT. */
  public PixelScale current() {
    return lastScale;
  }

  /**
   * Install all listeners and start the polling thread (if enabled). Idempotent — calling twice has
   * no effect.
   */
  public synchronized void start() {
    if (gcListener != null) {
      return;
    }

    // Initial value: best-effort read; the real value will arrive via DISPLAYABILITY_CHANGED.
    lastScale = read();

    gcListener = evt -> SwingUtilities.invokeLater(this::recheckAndFire);
    component.addPropertyChangeListener("graphicsConfiguration", gcListener);

    hierarchyListener = e -> {
      if ((e.getChangeFlags() & HierarchyEvent.DISPLAYABILITY_CHANGED) != 0) {
        SwingUtilities.invokeLater(this::recheckAndFire);
      }
    };
    component.addHierarchyListener(hierarchyListener);

    if (pollingEnabled) {
      poller = Executors.newSingleThreadScheduledExecutor(r -> {
        Thread t = new Thread(r, "PanamaGL-AWTPixelScalePoller");
        t.setDaemon(true);
        return t;
      });
      pollerFuture = poller.scheduleWithFixedDelay(
          () -> SwingUtilities.invokeLater(this::recheckAndFire),
          pollIntervalMs, pollIntervalMs, TimeUnit.MILLISECONDS);
    }
  }

  /** Remove listeners and stop polling. Idempotent. */
  public synchronized void stop() {
    if (gcListener != null) {
      component.removePropertyChangeListener("graphicsConfiguration", gcListener);
      gcListener = null;
    }
    if (hierarchyListener != null) {
      component.removeHierarchyListener(hierarchyListener);
      hierarchyListener = null;
    }
    if (pollerFuture != null) {
      pollerFuture.cancel(false);
      pollerFuture = null;
    }
    if (poller != null) {
      poller.shutdownNow();
      poller = null;
    }
  }

  public void addListener(PixelScaleListener l) {
    listeners.add(l);
  }

  public void removeListener(PixelScaleListener l) {
    listeners.remove(l);
  }

  public boolean isPollingEnabled() {
    return pollingEnabled;
  }

  /**
   * Enable or disable the polling fallback at runtime. Takes effect on the next {@link #start()}
   * call — call {@link #stop()} then {@link #start()} to restart the poller.
   */
  public void setPollingEnabled(boolean pollingEnabled) {
    this.pollingEnabled = pollingEnabled;
  }

  public long getPollIntervalMs() {
    return pollIntervalMs;
  }

  public void setPollIntervalMs(long pollIntervalMs) {
    this.pollIntervalMs = pollIntervalMs;
  }

  /**
   * Read the current scale and, if it differs from {@link #lastScale}, fire listeners. Must run on
   * the EDT — schedule via {@link SwingUtilities#invokeLater(Runnable)} from non-EDT callers.
   */
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
