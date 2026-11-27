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

import static demos.panamagl.rendering.M4.*;
import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import panamagl.opengl.GL;

/**
 * A mountain lake at sunset : a procedural terrain of about 130 000 triangles with shadows of the
 * low sun baked by marching the height map, forests of display lists, a procedural sky, fog, and a
 * lake reflecting the landscape.
 *
 * <p>The reflection is rendered first, mirrored under the water level, copied into a texture with
 * glCopyTexSubImage2D, then sampled by the shader of the water with ripples and a Fresnel term.
 * Exercises vertex buffer objects of many triangles, display lists, textures, clip by discard and
 * blending.
 */
public class LandscapeScene implements Scene {
  static final int GRID = 256;
  static final float SIZE = 7f;

  static final String SKY_FRAGMENT = """
      #version 120
      uniform vec2 resolution;
      uniform vec3 forward;
      uniform vec3 right;
      uniform vec3 up;
      uniform float tanHalfFov;
      uniform vec3 sun;
      uniform float mirror;
      float hash(vec2 p) { return fract(sin(dot(p, vec2(127.1, 311.7))) * 43758.5453); }
      float noise(vec2 p) {
        vec2 i = floor(p), f = fract(p);
        f = f * f * (3.0 - 2.0 * f);
        return mix(mix(hash(i), hash(i + vec2(1.0, 0.0)), f.x),
                   mix(hash(i + vec2(0.0, 1.0)), hash(i + vec2(1.0, 1.0)), f.x), f.y);
      }
      void main() {
        vec2 uv = (2.0 * gl_FragCoord.xy - resolution) / resolution.y;
        vec3 dir = normalize(forward + (right * uv.x + up * uv.y) * tanHalfFov);
        dir.y *= mirror;
        float h = max(dir.y, 0.0);
        vec3 sky = mix(vec3(0.95, 0.62, 0.38), vec3(0.22, 0.36, 0.62), pow(h, 0.45));
        float s = max(dot(dir, sun), 0.0);
        sky += vec3(1.0, 0.7, 0.4) * pow(s, 12.0) * 0.6 + vec3(1.0, 0.95, 0.8) * smoothstep(0.9985, 0.9992, s) * 3.0;
        // Clouds on a plane high above
        if (dir.y > 0.02) {
          vec2 p = dir.xz / dir.y * 2.0;
          float c = noise(p) * 0.6 + noise(p * 2.3) * 0.3 + noise(p * 5.1) * 0.1;
          c = smoothstep(0.45, 0.85, c) * smoothstep(0.02, 0.2, dir.y);
          vec3 cloud = mix(vec3(0.55, 0.45, 0.5), vec3(1.0, 0.78, 0.6), pow(s, 3.0));
          sky = mix(sky, cloud, c * 0.8);
        }
        gl_FragColor = vec4(sky, 1.0);
      }
      """;

  static final String SCREEN_VERTEX = """
      #version 120
      void main() {
        gl_Position = gl_Vertex;
      }
      """;

  static final String TERRAIN_VERTEX = """
      #version 120
      varying vec3 vWorld;
      varying vec3 vNormal;
      varying vec4 vColor;
      void main() {
        vWorld = (gl_TextureMatrix[0] * gl_Vertex).xyz;
        vNormal = gl_Normal;
        vColor = gl_Color;
        gl_Position = gl_ModelViewProjectionMatrix * gl_Vertex;
      }
      """;

  /** Shared lighting and fog, the alpha of the color being the baked sun shadow. */
  static final String LIGHTING = """
      uniform vec3 sun;
      uniform vec3 eye;
      vec3 fog(vec3 color, vec3 world) {
        vec3 d = world - eye;
        float dist = length(d);
        float amount = 1.0 - exp(-dist * 0.075);
        float toSun = pow(max(dot(normalize(d), sun), 0.0), 6.0);
        vec3 fogColor = mix(vec3(0.55, 0.55, 0.62), vec3(1.0, 0.72, 0.45), toSun);
        return mix(color, fogColor, amount);
      }
      vec3 shade(vec3 albedo, vec3 n, float shadow) {
        float diffuse = max(dot(n, sun), 0.0) * shadow;
        vec3 ambient = mix(vec3(0.20, 0.17, 0.16), vec3(0.32, 0.42, 0.60), n.y * 0.5 + 0.5);
        return albedo * (vec3(1.0, 0.82, 0.62) * diffuse * 1.9 + ambient * 0.8);
      }
      """;

  static final String TERRAIN_FRAGMENT = "#version 120\n" + LIGHTING + """
      uniform float clipUnderWater;
      uniform float shadowScale;
      varying vec3 vWorld;
      varying vec3 vNormal;
      varying vec4 vColor;
      void main() {
        if (clipUnderWater > 0.5 && vWorld.y < 0.0) discard;
        vec3 c = shade(vColor.rgb, normalize(vNormal), vColor.a * shadowScale);
        gl_FragColor = vec4(fog(c, vWorld), 1.0);
      }
      """;

  static final String WATER_FRAGMENT = "#version 120\n" + LIGHTING + """
      uniform sampler2D reflection;
      uniform vec2 resolution;
      varying vec3 vWorld;
      varying vec3 vNormal;
      varying vec4 vColor;
      float wave(vec2 p) {
        return sin(p.x * 9.0 + p.y * 3.0) * 0.5 + sin(p.x * -4.0 + p.y * 11.0) * 0.35
            + sin(p.x * 17.0 - p.y * 13.0) * 0.15;
      }
      void main() {
        vec2 p = vWorld.xz;
        float e = 0.02;
        vec3 n = normalize(vec3(-(wave(p + vec2(e, 0.0)) - wave(p)) / e * 0.012, 1.0,
                                -(wave(p + vec2(0.0, e)) - wave(p)) / e * 0.012));
        vec3 v = normalize(eye - vWorld);
        float fresnel = 0.04 + 0.96 * pow(1.0 - max(dot(n, v), 0.0), 5.0);
        vec2 uv = gl_FragCoord.xy / resolution + n.xz * 0.06;
        vec3 reflected = texture2D(reflection, uv).rgb;
        vec3 deep = vec3(0.04, 0.12, 0.16);
        vec3 color = mix(deep, reflected, clamp(fresnel * 1.4 + 0.5, 0.0, 1.0));
        float glitter = pow(max(dot(reflect(-sun, n), v), 0.0), 220.0);
        color += vec3(1.0, 0.85, 0.6) * glitter * 4.0;
        gl_FragColor = vec4(fog(color, vWorld), mix(0.78, 1.0, fresnel));
      }
      """;

  protected GLSL sky, terrain, water;
  protected Mesh mesh;
  protected int treeList;
  protected List<float[]> trees = new ArrayList<>();
  protected int texture;
  protected int width, height;
  protected Arena arena;

  protected final float[] sunDir = normalize(v(-0.8, 0.3, -0.35));
  protected final float[] eye = v(-1.0, 2.4, 7.4);
  protected final float[] target = v(0.5, 0.3, -1.2);
  protected final float fov = 55f;

  protected float[] heights;

  @Override
  public String getName() {
    return "landscape";
  }

  /** Height of the terrain at grid coordinates. */
  protected float heightAt(Noise noise, double x, double z) {
    double ridges = noise.ridged(x * 0.2 + 3.1, z * 0.2 - 1.7, 6) * 1.9;
    double hills = noise.fbm(x * 0.45, z * 0.45, 5) * 0.35;
    // A valley holding the lake, in the middle
    double lake = Math.exp(-((x - 0.4) * (x - 0.4) * 0.08 + (z + 0.6) * (z + 0.6) * 0.11)) * 1.5;
    // Mountains rise far from the camera
    double far = Math.max(0, -z) * 0.12;
    return (float) (ridges * (0.55 + far) + hills - lake - 0.05);
  }

  @Override
  public void init(GL gl, Arena arena, int width, int height) {
    this.width = width;
    this.height = height;
    this.arena = arena;
    sky = new GLSL(gl, SCREEN_VERTEX, SKY_FRAGMENT);
    terrain = new GLSL(gl, TERRAIN_VERTEX, TERRAIN_FRAGMENT);
    water = new GLSL(gl, TERRAIN_VERTEX, WATER_FRAGMENT);
    buildTerrain(gl);
    buildTrees(gl);

    MemorySegment id = arena.allocate(ValueLayout.JAVA_INT);
    gl.glGenTextures(1, id);
    texture = id.get(ValueLayout.JAVA_INT, 0);
    gl.glBindTexture(GL.GL_TEXTURE_2D, texture);
    gl.glTexParameteri(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MIN_FILTER, GL.GL_LINEAR);
    gl.glTexParameteri(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MAG_FILTER, GL.GL_LINEAR);
    gl.glTexParameteri(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_S, GL.GL_CLAMP_TO_EDGE);
    gl.glTexParameteri(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_T, GL.GL_CLAMP_TO_EDGE);
    gl.glTexImage2D(GL.GL_TEXTURE_2D, 0, GL.GL_RGBA, width, height, 0, GL.GL_RGBA,
        GL.GL_UNSIGNED_BYTE, MemorySegment.NULL);
    gl.glBindTexture(GL.GL_TEXTURE_2D, 0);
  }

  protected void buildTerrain(GL gl) {
    Noise noise = new Noise(7);
    int n = GRID + 1;
    heights = new float[n * n];
    float[] pos = new float[n * n * 3];
    for (int j = 0; j < n; j++) {
      for (int i = 0; i < n; i++) {
        float x = (i / (float) GRID * 2 - 1) * SIZE, z = (j / (float) GRID * 2 - 1) * SIZE;
        float y = heightAt(noise, x, z);
        heights[j * n + i] = y;
        int k = (j * n + i) * 3;
        pos[k] = x;
        pos[k + 1] = y;
        pos[k + 2] = z;
      }
    }
    float cell = 2 * SIZE / GRID;
    float[] nor = new float[n * n * 3];
    float[] col = new float[n * n * 4];
    Random r = new Random(3);
    for (int j = 0; j < n; j++) {
      for (int i = 0; i < n; i++) {
        float hl = heights[j * n + Math.max(i - 1, 0)], hr = heights[j * n + Math.min(i + 1, GRID)];
        float hd = heights[Math.max(j - 1, 0) * n + i], hu = heights[Math.min(j + 1, GRID) * n + i];
        float[] normal = normalize(v(hl - hr, 2 * cell, hd - hu));
        int k = (j * n + i) * 3;
        nor[k] = normal[0];
        nor[k + 1] = normal[1];
        nor[k + 2] = normal[2];

        float y = heights[j * n + i];
        float[] albedo = albedo(y, normal[1], r.nextFloat());
        int c = (j * n + i) * 4;
        col[c] = albedo[0];
        col[c + 1] = albedo[1];
        col[c + 2] = albedo[2];
        col[c + 3] = shadow(i, j, n, cell);
      }
    }
    int[] idx = new int[GRID * GRID * 6];
    int k = 0;
    for (int j = 0; j < GRID; j++) {
      for (int i = 0; i < GRID; i++) {
        int a = j * n + i, b = a + n;
        idx[k++] = a; idx[k++] = b; idx[k++] = a + 1;
        idx[k++] = a + 1; idx[k++] = b; idx[k++] = b + 1;
      }
    }
    mesh = new Mesh(gl, pos, nor, col, idx);
  }

  /** Sand, grass, forest floor, rock and snow, depending on height and slope. */
  protected float[] albedo(float y, float up, float jitter) {
    float[] sand = v(0.70, 0.62, 0.45), grass = v(0.22, 0.36, 0.10), rock = v(0.40, 0.37, 0.34),
        snow = v(0.92, 0.93, 0.97), mud = v(0.30, 0.26, 0.20);
    float[] c;
    if (y < 0)
      c = mix(sand, mud, Math.min(1, -y * 2));
    else if (y < 0.08f)
      c = sand;
    else
      c = mix(grass, scale(grass, 0.7f), jitter);
    c = mix(c, rock, smooth(0.78f, 0.62f, up));
    c = mix(c, snow, smooth(1.15f, 1.4f, y) * smooth(0.5f, 0.7f, up));
    return c;
  }

  /** Baked shadow of the low sun : march the height map towards the sun. */
  protected float shadow(int i, int j, int n, float cell) {
    float x = i, z = j, y = heights[j * n + i] + 0.01f;
    float step = 1f;
    float[] d = normalize(v(sunDir[0], 0, sunDir[2]));
    float rise = sunDir[1] / (float) Math.sqrt(sunDir[0] * sunDir[0] + sunDir[2] * sunDir[2]) * cell;
    float light = 1;
    for (int s = 0; s < 200; s++) {
      x += d[0] * step;
      z += d[2] * step;
      y += rise * step;
      if (x < 0 || z < 0 || x > GRID || z > GRID || y > 3)
        break;
      float h = heights[Math.round(z) * n + Math.round(x)];
      light = Math.min(light, smooth(-0.06f, 0.02f, y - h));
      if (light <= 0)
        break;
    }
    return light;
  }

  protected void buildTrees(GL gl) {
    Random r = new Random(11);
    int n = GRID + 1;
    float cell = 2 * SIZE / GRID;
    for (int t = 0; t < 6000 && trees.size() < 650; t++) {
      int i = 2 + r.nextInt(GRID - 4), j = 2 + r.nextInt(GRID - 4);
      float y = heights[j * n + i];
      float slope = Math.abs(heights[j * n + i + 1] - heights[j * n + i - 1]) / (2 * cell);
      if (y < 0.12f || y > 1.05f || slope > 0.55f)
        continue;
      float x = (i / (float) GRID * 2 - 1) * SIZE, z = (j / (float) GRID * 2 - 1) * SIZE;
      float shade = shadow(i, j, n, cell);
      trees.add(new float[] {x, y, z, 0.7f + r.nextFloat() * 0.6f, r.nextFloat() * 360, shade});
    }
    // One tree : a trunk and two cones of foliage, built with GLU quadrics
    MemorySegment quadric = gl.gluNewQuadric();
    gl.gluQuadricNormals(quadric, 100000 /* GLU_SMOOTH */);
    treeList = gl.glGenLists(1);
    gl.glNewList(treeList, GL.GL_COMPILE);
    gl.glPushMatrix();
    gl.glRotatef(-90, 1, 0, 0);
    gl.glColor4f(0.30f, 0.20f, 0.12f, 1f);
    gl.gluCylinder(quadric, 0.012, 0.010, 0.06, 6, 1);
    gl.glTranslatef(0, 0, 0.04f);
    gl.glColor4f(0.07f, 0.20f, 0.08f, 1f);
    gl.gluCylinder(quadric, 0.06, 0.0, 0.14, 8, 2);
    gl.glTranslatef(0, 0, 0.07f);
    gl.gluCylinder(quadric, 0.045, 0.0, 0.11, 8, 2);
    gl.glPopMatrix();
    gl.glEndList();
    gl.gluDeleteQuadric(quadric);
  }

  @Override
  public void display(GL gl, float time) {
    gl.glViewport(0, 0, width, height);
    float[] view = lookAt(eye, target, v(0, 1, 0));
    float[] projection = perspective(fov, (float) width / height, 0.05f, 60f);

    // 1. Reflection : the sky and the landscape mirrored under the water level, in the texture
    gl.glClearColor(0, 0, 0, 1);
    gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
    drawSky(gl, -1);
    gl.glEnable(GL.GL_DEPTH_TEST);
    load(gl, GL.GL_PROJECTION, projection);
    load(gl, GL.GL_MODELVIEW, view);
    gl.glScalef(1, -1, 1);
    drawLand(gl, true);
    gl.glBindTexture(GL.GL_TEXTURE_2D, texture);
    gl.glCopyTexSubImage2D(GL.GL_TEXTURE_2D, 0, 0, 0, 0, 0, width, height);
    gl.glBindTexture(GL.GL_TEXTURE_2D, 0);

    // 2. The landscape
    gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
    drawSky(gl, 1);
    gl.glEnable(GL.GL_DEPTH_TEST);
    load(gl, GL.GL_PROJECTION, projection);
    load(gl, GL.GL_MODELVIEW, view);
    drawLand(gl, false);

    // 3. The lake, blended over the drowned terrain
    gl.glEnable(GL.GL_BLEND);
    gl.glBlendFunc(GL.GL_SRC_ALPHA, GL.GL_ONE_MINUS_SRC_ALPHA);
    gl.glActiveTexture(GL.GL_TEXTURE0);
    gl.glBindTexture(GL.GL_TEXTURE_2D, texture);
    water.use();
    water.set("sun", sunDir).set("eye", eye).set("resolution", width, height).setInt("reflection", 0);
    gl.glBegin(GL.GL_QUADS);
    gl.glNormal3f(0, 1, 0);
    gl.glVertex3f(-SIZE, 0, -SIZE);
    gl.glVertex3f(-SIZE, 0, SIZE);
    gl.glVertex3f(SIZE, 0, SIZE);
    gl.glVertex3f(SIZE, 0, -SIZE);
    gl.glEnd();
    GLSL.none(gl);
    gl.glBindTexture(GL.GL_TEXTURE_2D, 0);
    gl.glDisable(GL.GL_BLEND);
  }

  protected void drawSky(GL gl, float mirror) {
    float[] f = normalize(sub(target, eye));
    float[] r = normalize(cross(f, v(0, 1, 0)));
    float[] u = cross(r, f);
    gl.glDisable(GL.GL_DEPTH_TEST);
    gl.glMatrixMode(GL.GL_PROJECTION);
    gl.glLoadIdentity();
    gl.glMatrixMode(GL.GL_MODELVIEW);
    gl.glLoadIdentity();
    sky.use();
    sky.set("resolution", width, height).set("forward", f).set("right", r).set("up", u)
        .set("tanHalfFov", (float) Math.tan(Math.toRadians(fov / 2))).set("sun", sunDir)
        .set("mirror", mirror);
    gl.glBegin(GL.GL_QUADS);
    gl.glVertex2f(-1, -1);
    gl.glVertex2f(1, -1);
    gl.glVertex2f(1, 1);
    gl.glVertex2f(-1, 1);
    gl.glEnd();
    GLSL.none(gl);
  }

  /** The terrain and its trees, in world coordinates given by the texture matrix (identity). */
  protected void drawLand(GL gl, boolean mirrored) {
    gl.glMatrixMode(GL.GL_TEXTURE);
    gl.glLoadIdentity();
    gl.glMatrixMode(GL.GL_MODELVIEW);
    // Mirroring flips the winding of the triangles : no face culling here
    terrain.use();
    terrain.set("sun", sunDir).set("eye", eye).set("clipUnderWater", mirrored ? 1f : 0f)
        .set("shadowScale", 1f);
    mesh.draw();
    for (float[] t : trees) {
      // The world position of the tree vertices, for the fog and the clip, is set in the texture matrix
      gl.glMatrixMode(GL.GL_TEXTURE);
      gl.glLoadIdentity();
      gl.glTranslatef(t[0], t[1], t[2]);
      gl.glScalef(t[3], t[3], t[3]);
      gl.glMatrixMode(GL.GL_MODELVIEW);
      gl.glPushMatrix();
      gl.glTranslatef(t[0], t[1], t[2]);
      gl.glScalef(t[3], t[3], t[3]);
      gl.glRotatef(t[4], 0, 1, 0);
      // The baked shadow of the terrain at the foot of the tree
      terrain.set("shadowScale", t[5]);
      gl.glCallList(treeList);
      gl.glPopMatrix();
    }
    gl.glMatrixMode(GL.GL_TEXTURE);
    gl.glLoadIdentity();
    gl.glMatrixMode(GL.GL_MODELVIEW);
    GLSL.none(gl);
  }

  @Override
  public void dispose(GL gl) {
    sky.dispose();
    terrain.dispose();
    water.dispose();
    mesh.dispose();
    gl.glDeleteLists(treeList, 1);
    gl.glDeleteTextures(1, arena.allocateFrom(ValueLayout.JAVA_INT, texture));
    gl.glDisable(GL.GL_DEPTH_TEST);
  }

  @Override
  public float referenceTime() {
    return 0f;
  }

  @Override
  public int timedFrames() {
    return 4;
  }

  static float smooth(float e0, float e1, float x) {
    float t = Math.max(0, Math.min(1, (x - e0) / (e1 - e0)));
    return t * t * (3 - 2 * t);
  }

  static float[] mix(float[] a, float[] b, float t) {
    return v(a[0] + (b[0] - a[0]) * t, a[1] + (b[1] - a[1]) * t, a[2] + (b[2] - a[2]) * t);
  }
}
