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

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Control;

/**
 * Reads the Cocoa {@code -backingScaleFactor} of an SWT {@link Control} on macOS.
 *
 * <p>SWT's public {@code Monitor.getZoom()} returns 100 even on Retina, because SWT-Cocoa applies
 * its own auto-scaling transparently — but the underlying NSView still receives a 2&times;
 * backbuffer. To dimension the FBO correctly we need the raw Cocoa scale.
 *
 * <p>SWT 3.126.0's {@code NSWindow} does not expose {@code backingScaleFactor()} directly, but
 * {@code NSWindow.screen()} returns an {@code NSScreen} that does. The chain is therefore
 * {@code Control.view (NSView) -> window() (NSWindow) -> screen() (NSScreen) ->
 * backingScaleFactor()}.
 *
 * <p>All access goes through reflection so that this module compiles and runs on the Linux/Windows
 * SWT jars where {@code org.eclipse.swt.internal.cocoa} is absent. Any failure (wrong platform,
 * detached view, fallback resolution failed) returns {@code 1.0} silently.
 */
final class MacOSBackingScaleFactor {

  private MacOSBackingScaleFactor() {}

  /**
   * Best-effort read of the macOS backing scale factor for the given SWT {@link Control}. Returns
   * {@code 1.0} on non-cocoa platforms, when the view is not attached, or when reflection fails
   * for any reason.
   */
  static double read(Control control) {
    if (!"cocoa".equals(SWT.getPlatform())) {
      return 1.0;
    }
    try {
      // Control.view is a public field on cocoa SWT — direct field access, no setAccessible needed.
      Field viewField = control.getClass().getField("view");
      Object nsView = viewField.get(control);
      if (nsView == null) {
        return readFromMainScreen();
      }
      Method windowMethod = nsView.getClass().getMethod("window");
      Object nsWindow = windowMethod.invoke(nsView);
      if (nsWindow == null) {
        return readFromMainScreen();
      }
      Method screenMethod = nsWindow.getClass().getMethod("screen");
      Object nsScreen = screenMethod.invoke(nsWindow);
      if (nsScreen == null) {
        return readFromMainScreen();
      }
      Method bsfMethod = nsScreen.getClass().getMethod("backingScaleFactor");
      Object factor = bsfMethod.invoke(nsScreen);
      return factor instanceof Number ? ((Number) factor).doubleValue() : 1.0;
    } catch (NoSuchFieldException | NoSuchMethodException notSwtCocoa) {
      // Either we are running against a non-cocoa SWT jar, or the internal Cocoa API has shifted.
      return 1.0;
    } catch (Throwable t) {
      return 1.0;
    }
  }

  /**
   * Fallback when the view has no associated NSWindow (e.g. canvas not yet shown). Reads
   * {@code NSScreen.mainScreen().backingScaleFactor()}. Returns {@code 1.0} if the call fails.
   */
  private static double readFromMainScreen() {
    try {
      Class<?> nsScreenClass = Class.forName("org.eclipse.swt.internal.cocoa.NSScreen");
      Object mainScreen = nsScreenClass.getMethod("mainScreen").invoke(null);
      if (mainScreen == null) {
        return 1.0;
      }
      Object factor = nsScreenClass.getMethod("backingScaleFactor").invoke(mainScreen);
      return factor instanceof Number ? ((Number) factor).doubleValue() : 1.0;
    } catch (Throwable t) {
      return 1.0;
    }
  }
}
