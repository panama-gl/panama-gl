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
package demos.panamagl.rendering;

import java.util.Random;

/** Deterministic 2D gradient noise (Perlin's improved noise) and fractal sums of it. */
public class Noise {
  protected final int[] p = new int[512];

  public Noise(long seed) {
    int[] perm = new int[256];
    for (int i = 0; i < 256; i++)
      perm[i] = i;
    Random r = new Random(seed);
    for (int i = 255; i > 0; i--) {
      int j = r.nextInt(i + 1);
      int t = perm[i];
      perm[i] = perm[j];
      perm[j] = t;
    }
    for (int i = 0; i < 512; i++)
      p[i] = perm[i & 255];
  }

  static double fade(double t) {
    return t * t * t * (t * (t * 6 - 15) + 10);
  }

  static double grad(int h, double x, double y) {
    switch (h & 7) {
      case 0: return x + y;
      case 1: return -x + y;
      case 2: return x - y;
      case 3: return -x - y;
      case 4: return x;
      case 5: return -x;
      case 6: return y;
      default: return -y;
    }
  }

  /** @return noise in about [-1, 1]. */
  public double noise(double x, double y) {
    int xi = (int) Math.floor(x) & 255, yi = (int) Math.floor(y) & 255;
    double xf = x - Math.floor(x), yf = y - Math.floor(y);
    double u = fade(xf), v = fade(yf);
    int aa = p[p[xi] + yi], ab = p[p[xi] + yi + 1], ba = p[p[xi + 1] + yi], bb = p[p[xi + 1] + yi + 1];
    double x1 = lerp(grad(aa, xf, yf), grad(ba, xf - 1, yf), u);
    double x2 = lerp(grad(ab, xf, yf - 1), grad(bb, xf - 1, yf - 1), u);
    return lerp(x1, x2, v);
  }

  /** Fractal sum of noise. */
  public double fbm(double x, double y, int octaves) {
    double sum = 0, amp = 0.5, f = 1;
    for (int i = 0; i < octaves; i++) {
      sum += amp * noise(x * f, y * f);
      f *= 2.03;
      amp *= 0.5;
    }
    return sum;
  }

  /** Ridged fractal sum : sharp crests, like mountain ranges, in about [0, 1]. */
  public double ridged(double x, double y, int octaves) {
    double sum = 0, amp = 0.5, f = 1, weight = 1;
    for (int i = 0; i < octaves; i++) {
      double n = 1 - Math.abs(noise(x * f, y * f));
      n *= n * weight;
      weight = Math.min(1, n * 2);
      sum += n * amp;
      f *= 2.1;
      amp *= 0.5;
    }
    return sum;
  }

  static double lerp(double a, double b, double t) {
    return a + t * (b - a);
  }
}
