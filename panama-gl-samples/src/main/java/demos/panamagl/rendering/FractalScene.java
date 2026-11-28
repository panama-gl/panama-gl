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

import java.lang.foreign.Arena;
import panamagl.opengl.GL;

/**
 * A raymarched fractal in the spirit of the demoscene : a flight along an endless, twisted corridor
 * of Menger sponges, lit by a warm light floating ahead, with soft shadows, ambient occlusion,
 * copper veins, an electric glow of the edges and fog.
 *
 * <p>Everything happens in a fragment shader drawn on a screen quad : this scene stresses the
 * translation of GLSL (loops, branches, many arithmetic operations) by each backend, e.g. to SPIR-V
 * for Zink or to DXIL for Mesa d3d12.
 */
public class FractalScene implements Scene {
  static final String VERTEX = """
      #version 120
      void main() {
        gl_Position = gl_Vertex;
      }
      """;

  static final String FRAGMENT = """
      #version 120
      uniform vec2 resolution;
      uniform float time;

      float sdBox(vec3 p, vec3 b) {
        vec3 q = abs(p) - b;
        return length(max(q, 0.0)) + min(max(q.x, max(q.y, q.z)), 0.0);
      }

      // An endless corridor of Menger sponges, twisted along its axis.
      // trap : how close the folds came to their center, to color the walls.
      float de(vec3 p, out vec4 trap) {
        float a = p.z * 0.16;
        float c = cos(a), s = sin(a);
        p.xy = vec2(c * p.x - s * p.y, s * p.x + c * p.y);
        p.z = mod(p.z, 2.0) - 1.0;
        float d = sdBox(p, vec3(1.0));
        float scale = 1.0;
        trap = vec4(1e9);
        for (int i = 0; i < 5; i++) {
          vec3 q = mod(p * scale, 2.0) - 1.0;
          scale *= 3.0;
          vec3 r = abs(1.0 - 3.0 * abs(q));
          float hole = (min(max(r.x, r.y), min(max(r.y, r.z), max(r.z, r.x))) - 1.0) / scale;
          d = max(d, hole);
          trap = min(trap, vec4(abs(q), dot(q, q)));
        }
        return d;
      }

      float de(vec3 p) {
        vec4 t;
        return de(p, t);
      }

      vec3 normalAt(vec3 p) {
        vec2 h = vec2(0.0008, 0.0);
        return normalize(vec3(de(p + h.xyy) - de(p - h.xyy), de(p + h.yxy) - de(p - h.yxy),
                              de(p + h.yyx) - de(p - h.yyx)));
      }

      float softShadow(vec3 p, vec3 l, float maxT) {
        float shade = 1.0, t = 0.01;
        for (int i = 0; i < 24; i++) {
          float d = de(p + l * t);
          shade = min(shade, 12.0 * d / t);
          t += clamp(d, 0.005, 0.15);
          if (shade < 0.01 || t > maxT) break;
        }
        return clamp(shade, 0.0, 1.0);
      }

      float ambientOcclusion(vec3 p, vec3 n) {
        float occ = 0.0, w = 1.0;
        for (int i = 1; i <= 5; i++) {
          float h = 0.025 * float(i);
          occ += w * (h - de(p + n * h));
          w *= 0.55;
        }
        return clamp(1.0 - 6.0 * occ, 0.0, 1.0);
      }

      void main() {
        vec2 uv = (2.0 * gl_FragCoord.xy - resolution) / resolution.y;

        // Flying along the corridor, with a slow sway
        float z = time * 0.55;
        vec3 eye = vec3(0.06 * sin(time * 0.7), 0.05 * cos(time * 0.5), z);
        vec3 target = vec3(0.12 * sin(time * 0.7 + 1.0), 0.0, z + 1.0);
        vec3 f = normalize(target - eye);
        vec3 r = normalize(cross(f, vec3(0.0, 1.0, 0.0)));
        vec3 u = cross(r, f);
        vec3 dir = normalize(f * 1.1 + r * uv.x + u * uv.y);

        // A warm light floating ahead in the corridor
        vec3 lightPos = vec3(0.0, 0.08, z + 1.6);
        vec3 fogColor = vec3(0.03, 0.05, 0.12);

        float t = 0.0, glow = 0.0;
        vec4 trap = vec4(0.0);
        bool hit = false;
        for (int i = 0; i < 120; i++) {
          vec3 p = eye + dir * t;
          float d = de(p, trap);
          glow += exp(-d * 60.0) * 0.008;
          if (d < 0.0004 * (1.0 + t)) { hit = true; break; }
          t += d * 0.95;
          if (t > 9.0) break;
        }

        vec3 color = fogColor;
        if (hit) {
          vec3 p = eye + dir * t;
          vec3 n = normalAt(p);
          vec3 toLight = lightPos - p;
          float dist = length(toLight);
          vec3 l = toLight / dist;
          float attenuation = 1.6 / (1.0 + 0.9 * dist * dist);
          float diffuse = max(dot(n, l), 0.0);
          float shadow = softShadow(p + n * 0.002, l, dist);
          float ao = ambientOcclusion(p, n);
          float specular = pow(max(dot(reflect(dir, n), l), 0.0), 40.0);

          // Stone and copper, depending on the depth of the fold
          vec3 stone = mix(vec3(0.55, 0.58, 0.65), vec3(0.20, 0.24, 0.34), smoothstep(0.0, 0.6, trap.x));
          vec3 copper = vec3(0.95, 0.50, 0.18);
          vec3 albedo = mix(stone, copper, smoothstep(0.25, 0.0, trap.w) * 0.85);

          vec3 warm = vec3(1.0, 0.78, 0.50);
          color = albedo * warm * diffuse * shadow * attenuation * 2.2;
          color += albedo * vec3(0.10, 0.16, 0.32) * ao;
          color += warm * specular * shadow * attenuation;
          color *= mix(0.4, 1.0, ao);
          color = mix(color, fogColor, 1.0 - exp(-0.08 * t * t));
        }
        // Glow of the edges and halo of the light
        color += vec3(0.20, 0.45, 1.0) * glow;
        vec3 toL = lightPos - eye;
        float along = dot(toL, dir);
        if (along > 0.0 && (!hit || along < t)) {
          float miss = length(toL - dir * along);
          color += vec3(1.0, 0.75, 0.45) * 0.0025 / (miss * miss + 0.002);
        }

        color = color / (1.0 + color);
        color = pow(color, vec3(0.4545));
        color *= 1.0 - 0.3 * dot(uv * 0.6, uv * 0.6);
        gl_FragColor = vec4(color, 1.0);
      }
      """;

  protected GLSL glsl;
  protected int width, height;

  @Override
  public String getName() {
    return "fractal";
  }

  @Override
  public void init(GL gl, Arena arena, int width, int height) {
    this.width = width;
    this.height = height;
    glsl = new GLSL(gl, VERTEX, FRAGMENT);
  }

  @Override
  public void display(GL gl, float time) {
    gl.glViewport(0, 0, width, height);
    gl.glDisable(GL.GL_DEPTH_TEST);
    gl.glDisable(GL.GL_LIGHTING);
    glsl.use();
    glsl.set("resolution", width, height).set("time", time);
    gl.glBegin(GL.GL_QUADS);
    gl.glVertex2f(-1, -1);
    gl.glVertex2f(1, -1);
    gl.glVertex2f(1, 1);
    gl.glVertex2f(-1, 1);
    gl.glEnd();
    GLSL.none(gl);
  }

  @Override
  public void dispose(GL gl) {
    glsl.dispose();
  }

  @Override
  public float referenceTime() {
    return 3f;
  }

  @Override
  public int timedFrames() {
    return 2;
  }
}
