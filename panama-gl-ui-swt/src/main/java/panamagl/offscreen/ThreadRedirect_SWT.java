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
package panamagl.offscreen;

import org.eclipse.swt.widgets.Display;

/**
 * Redirects execution to the SWT UI thread via {@link Display#asyncExec(Runnable)}.
 *
 * If already on the display thread, runs synchronously to avoid unnecessary scheduling.
 */
public class ThreadRedirect_SWT implements ThreadRedirect {
  protected final Display display;

  public ThreadRedirect_SWT(Display display) {
    this.display = display;
  }

  @Override
  public void run(Runnable runnable) {
    if (display.isDisposed()) {
      return;
    }
    if (Thread.currentThread() == display.getThread()) {
      runnable.run();
    } else {
      display.asyncExec(runnable);
    }
  }
}
