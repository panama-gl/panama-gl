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

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.stage.Screen;
import javafx.stage.Window;

/**
 * HiDPI plumbing for {@link GLCanvasJFX}.
 *
 * <p>Reads the current pixel scale from {@link Window#getRenderScaleX()} /
 * {@link Window#getRenderScaleY()} (the actual scale used by Prism — typically equal to the
 * screen output scale, but possibly capped by the JVM property {@code prism.allowhidpi}).
 *
 * <p>Falls back to {@link Screen#getOutputScaleX()} / {@link Screen#getOutputScaleY()} when the
 * canvas is not yet attached to a window — for example during construction.
 *
 * <p>Listeners are wired in cascade so that the scale-change events keep firing even when the
 * canvas is reparented to a different scene or stage:
 * {@code canvas.sceneProperty -> scene.windowProperty -> window.renderScaleX/Y}.
 *
 * <p>Unlike the AWT support, no polling is needed: JavaFX publishes a property change every time
 * the render scale changes (e.g. monitor switch, OS scaling change).
 */
public class PixelScaleSupportJFX {

  private final Canvas canvas;
  private final List<PixelScaleListener> listeners = new CopyOnWriteArrayList<>();
  private volatile PixelScale lastScale = PixelScale.IDENTITY;

  private ChangeListener<Scene> sceneListener;
  private ChangeListener<Window> windowListener;
  private ChangeListener<Number> scaleXListener;
  private ChangeListener<Number> scaleYListener;

  private Scene observedScene;
  private Window observedWindow;

  public PixelScaleSupportJFX(Canvas canvas) {
    this.canvas = canvas;
  }

  /** Read the current pixel scale, walking the canvas->scene->window chain when possible. */
  public PixelScale read() {
    Scene scene = canvas.getScene();
    Window window = scene != null ? scene.getWindow() : null;
    if (window != null) {
      return new PixelScale(window.getRenderScaleX(), window.getRenderScaleY());
    }
    Screen primary = Screen.getPrimary();
    if (primary != null) {
      return new PixelScale(primary.getOutputScaleX(), primary.getOutputScaleY());
    }
    return PixelScale.IDENTITY;
  }

  /** Last value reported to listeners. */
  public PixelScale current() {
    return lastScale;
  }

  /**
   * Wire the listener cascade. Idempotent. Must be called from the JavaFX application thread —
   * which is where {@link GLCanvasJFX} constructs its support.
   */
  public void start() {
    if (sceneListener != null) {
      return;
    }
    lastScale = read();

    scaleXListener = (obs, o, n) -> recheckAndFire();
    scaleYListener = (obs, o, n) -> recheckAndFire();
    windowListener = (obs, o, n) -> rewireWindow(o, n);
    sceneListener = (obs, o, n) -> rewireScene(o, n);

    canvas.sceneProperty().addListener(sceneListener);
    rewireScene(null, canvas.getScene());
  }

  public void stop() {
    if (sceneListener == null) {
      return;
    }
    canvas.sceneProperty().removeListener(sceneListener);
    rewireScene(observedScene, null);
    sceneListener = null;
    windowListener = null;
    scaleXListener = null;
    scaleYListener = null;
  }

  public void addListener(PixelScaleListener l) {
    listeners.add(l);
  }

  public void removeListener(PixelScaleListener l) {
    listeners.remove(l);
  }

  private void rewireScene(Scene oldScene, Scene newScene) {
    if (oldScene != null) {
      oldScene.windowProperty().removeListener(windowListener);
      rewireWindow(observedWindow, null);
    }
    observedScene = newScene;
    if (newScene != null) {
      newScene.windowProperty().addListener(windowListener);
      rewireWindow(null, newScene.getWindow());
    }
    recheckAndFire();
  }

  private void rewireWindow(Window oldWindow, Window newWindow) {
    if (oldWindow != null) {
      oldWindow.renderScaleXProperty().removeListener(scaleXListener);
      oldWindow.renderScaleYProperty().removeListener(scaleYListener);
    }
    observedWindow = newWindow;
    if (newWindow != null) {
      newWindow.renderScaleXProperty().addListener(scaleXListener);
      newWindow.renderScaleYProperty().addListener(scaleYListener);
    }
    recheckAndFire();
  }

  private void recheckAndFire() {
    PixelScale prev = lastScale;
    PixelScale next = read();
    if (next.equals(prev)) {
      return;
    }
    lastScale = next;
    Runnable fire = () -> {
      for (PixelScaleListener l : listeners) {
        l.pixelScaleChanged(prev, next);
      }
    };
    if (Platform.isFxApplicationThread()) {
      fire.run();
    } else {
      Platform.runLater(fire);
    }
  }
}
