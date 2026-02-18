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
package panamagl;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.Assert;
import org.junit.Test;
import panamagl.canvas.GLCanvas;

public class TestAnimator {
  @Test
  public void animator() throws InterruptedException {

    GLCanvas canvas = mock(GLCanvas.class);

    when(canvas.isVisible()).thenReturn(true);

    // How many loops we want to observe before asserting timing
    final int TARGET_LOOPS = 10;
    // Generous timeout: even a very slow CI runner should complete 10x40ms in 10s
    final long TIMEOUT_MS = 10_000;

    Animator a = new Animator(canvas);
    a.setSleepTime(Animator.RETINAL_PERSISTENCE); // 40ms

    Assert.assertEquals("Animator should start at 0 loops", 0, a.getLoops());

    long start = System.currentTimeMillis();
    a.start();

    // Wait until TARGET_LOOPS iterations are done (machine-speed-independent)
    while (a.getLoops() < TARGET_LOOPS && (System.currentTimeMillis() - start) < TIMEOUT_MS) {
      Thread.sleep(20);
    }

    a.stop();
    long elapsed = System.currentTimeMillis() - start;

    // 1. Verify the animator actually ran the required number of loops
    Assert.assertTrue(
        "Animator should complete at least " + TARGET_LOOPS + " loops, got " + a.getLoops(),
        a.getLoops() >= TARGET_LOOPS);

    // 2. Verify average time per loop is consistent with sleepTime.
    //    Each loop sleeps ~sleepTime, so elapsed/loops should be in [sleepTime*0.5 , sleepTime*4].
    //    The upper bound is intentionally large to absorb CI scheduler jitter.
    long avgMs = elapsed / a.getLoops();
    long minAvg = Animator.RETINAL_PERSISTENCE / 2;           // 20ms  — way below expected
    long maxAvg = Animator.RETINAL_PERSISTENCE * 4;           // 160ms — way above expected
    Assert.assertTrue(
        "Avg loop time " + avgMs + "ms should be >= " + minAvg + "ms (sleepTime=" + Animator.RETINAL_PERSISTENCE + "ms)",
        avgMs >= minAvg);
    Assert.assertTrue(
        "Avg loop time " + avgMs + "ms should be <= " + maxAvg + "ms (sleepTime=" + Animator.RETINAL_PERSISTENCE + "ms)",
        avgMs <= maxAvg);
  }
}
