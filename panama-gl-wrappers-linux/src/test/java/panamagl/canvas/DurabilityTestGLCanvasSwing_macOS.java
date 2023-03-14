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
package panamagl.canvas;

import org.junit.Test;
import panamagl.factory.PanamaGLFactory;
import panamagl.platform.Platform;

/**
 * This test is intentionnaly named DurabilityTest* to be ignored by maven
 * while running tests (surefire config keeps Test* or *Test or ITTest*)
 */
// VM ARGS : --enable-native-access=ALL-UNNAMED --enable-preview -Djava.library.path=.://usr/lib/x86_64-linux-gnu/
//@Ignore("Will add to specific build profile later.")
public class DurabilityTestGLCanvasSwing_macOS {
  public static int WAIT_FOR_RENDER_DISPATCHED_MS = 200;

  @Test
  public void whenPanelIsAdded_ThenGLEventListenerIsInvoked() throws InterruptedException {
    if (!new Platform().isUnix())
     return;
    
    PanamaGLFactory factory = PanamaGLFactory.select();
    
    DurabilityTestGLCanvasSwing.whenPanelIsAdded_ThenGLEventListenerIsInvoked(factory);
  }
}
