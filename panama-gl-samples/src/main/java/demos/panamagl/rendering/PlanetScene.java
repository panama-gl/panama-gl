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
import java.util.Random;
import panamagl.opengl.GL;

/**
 * A procedural planet lit by its sun : continents, specular oceans, ice caps, clouds and city lights
 * on the night side, an atmosphere glowing on the limb, a moon casting its shadow on the planet, the
 * sun and its corona, and a field of stars.
 *
 * <p>Exercises vertex buffer objects, GLSL noise in fragment shaders, additive blending, face
 * culling, depth mask, points and billboards.
 */
public class PlanetScene implements Scene {
  /** 3D value noise and its fractal sum, in GLSL 1.20. */
  static final String NOISE = """
      float hash(vec3 p) {
        p = fract(p * 0.3183099 + 0.1);
        p *= 17.0;
        return fract(p.x * p.y * p.z * (p.x + p.y + p.z));
      }
      float noise(vec3 x) {
        vec3 i = floor(x);
        vec3 f = fract(x);
        f = f * f * (3.0 - 2.0 * f);
        return mix(mix(mix(hash(i), hash(i + vec3(1.0, 0.0, 0.0)), f.x),
                       mix(hash(i + vec3(0.0, 1.0, 0.0)), hash(i + vec3(1.0, 1.0, 0.0)), f.x), f.y),
                   mix(mix(hash(i + vec3(0.0, 0.0, 1.0)), hash(i + vec3(1.0, 0.0, 1.0)), f.x),
                       mix(hash(i + vec3(0.0, 1.0, 1.0)), hash(i + vec3(1.0, 1.0, 1.0)), f.x), f.y), f.z);
      }
      float fbm(vec3 p) {
        float s = 0.0, a = 0.5;
        for (int i = 0; i < 6; i++) {
          s += a * noise(p);
          p = p * 2.02 + vec3(1.7, 9.2, 3.1);
          a *= 0.5;
        }
        return s;
      }
      vec3 rotateY(vec3 p, float a) {
        float c = cos(a), s = sin(a);
        return vec3(c * p.x + s * p.z, p.y, -s * p.x + c * p.z);
      }
      // Fraction of the sun light reaching p, given a sphere (center, radius) that may occlude it
      float eclipse(vec3 p, vec3 l, vec3 center, float radius) {
        vec3 toC = center - p;
        float along = dot(toC, l);
        if (along <= 0.0) return 1.0;
        float miss = length(toC - l * along);
        return smoothstep(radius * 0.8, radius * 1.15, miss);
      }
      """;

  static final String SPHERE_VERTEX = """
      #version 120
      uniform vec3 center;
      uniform float radius;
      varying vec3 vObject;
      varying vec3 vWorld;
      void main() {
        vObject = gl_Vertex.xyz;
        vWorld = center + gl_Vertex.xyz * radius;
        gl_Position = gl_ModelViewProjectionMatrix * vec4(vWorld, 1.0);
      }
      """;

  static final String PLANET_FRAGMENT = "#version 120\n" + NOISE + """
      uniform vec3 sun;
      uniform vec3 eye;
      uniform float spin;
      uniform vec3 moonCenter;
      uniform float moonRadius;
      varying vec3 vObject;
      varying vec3 vWorld;
      void main() {
        vec3 n = normalize(vWorld);
        vec3 v = normalize(eye - vWorld);
        vec3 q = rotateY(normalize(vObject), spin);

        // Terrain : continents emerge from the ocean
        float h = fbm(q * 2.3) + 0.25 * fbm(q * 9.0) - 0.68;
        float land = smoothstep(0.0, 0.02, h);
        float latitude = abs(q.y);
        vec3 ocean = mix(vec3(0.01, 0.04, 0.16), vec3(0.03, 0.22, 0.38), smoothstep(-0.12, 0.0, h));
        vec3 green = mix(vec3(0.10, 0.26, 0.06), vec3(0.30, 0.34, 0.12), smoothstep(0.0, 0.12, h));
        vec3 desert = vec3(0.62, 0.50, 0.30);
        float dry = smoothstep(0.55, 0.75, fbm(q * 3.1 + 7.0)) * (1.0 - smoothstep(0.35, 0.6, latitude));
        vec3 ground = mix(green, desert, dry);
        ground = mix(ground, vec3(0.42, 0.38, 0.34), smoothstep(0.14, 0.22, h));
        float ice = smoothstep(0.78, 0.86, latitude + 0.1 * fbm(q * 6.0));
        vec3 albedo = mix(mix(ocean, ground, land), vec3(0.92, 0.95, 1.0), ice);

        // Clouds, turning slightly faster than the ground
        float c = fbm(rotateY(q, 0.35) * 3.4 + vec3(0.0, 2.0, 0.0));
        float clouds = smoothstep(0.58, 0.78, c) * 0.75;

        // Sun light, eclipsed by the moon
        float day = max(dot(n, sun), 0.0);
        float shadow = eclipse(vWorld, sun, moonCenter, moonRadius);
        float specular = pow(max(dot(reflect(-sun, n), v), 0.0), 60.0) * (1.0 - land) * (1.0 - clouds)
            * smoothstep(0.0, 0.1, dot(n, sun));

        vec3 lit = albedo * day * shadow * 1.7 + vec3(1.0, 0.95, 0.85) * specular * shadow * 0.9;
        lit = mix(lit, vec3(1.0) * (day * shadow * 1.1 + 0.015), clouds);

        // City lights on the night side
        float night = smoothstep(0.08, -0.12, dot(n, sun));
        float cities = smoothstep(0.80, 0.9, noise(q * 70.0)) * smoothstep(0.45, 0.6, fbm(q * 4.0 + 3.0))
            * land * (1.0 - ice) * (1.0 - clouds);
        lit += vec3(1.0, 0.65, 0.3) * cities * night * 1.4;

        // Scattering near the limb
        float fresnel = pow(1.0 - max(dot(n, v), 0.0), 3.0);
        lit += vec3(0.25, 0.5, 1.0) * fresnel * smoothstep(-0.2, 0.5, dot(n, sun)) * 0.6;
        gl_FragColor = vec4(lit, 1.0);
      }
      """;

  static final String ATMOSPHERE_FRAGMENT = """
      #version 120
      uniform vec3 sun;
      uniform vec3 eye;
      varying vec3 vObject;
      varying vec3 vWorld;
      void main() {
        vec3 n = normalize(vWorld);
        vec3 v = normalize(eye - vWorld);
        float rim = pow(1.0 - abs(dot(n, v)), 2.5);
        float lit = smoothstep(-0.35, 0.4, dot(n, sun));
        // Blue on the day side, orange at the terminator
        vec3 color = mix(vec3(1.0, 0.45, 0.15), vec3(0.3, 0.6, 1.0), smoothstep(-0.1, 0.4, dot(n, sun)));
        gl_FragColor = vec4(color * rim * lit * 1.4, 1.0);
      }
      """;

  static final String MOON_FRAGMENT = "#version 120\n" + NOISE + """
      uniform vec3 sun;
      uniform vec3 planetCenter;
      uniform float planetRadius;
      varying vec3 vObject;
      varying vec3 vWorld;
      void main() {
        vec3 q = normalize(vObject);
        vec3 n = normalize(vWorld - (vWorld - q * 0.0));
        n = q;
        float craters = smoothstep(0.55, 0.7, noise(q * 9.0)) - smoothstep(0.72, 0.8, noise(q * 9.0));
        vec3 albedo = vec3(0.55, 0.53, 0.5) * (0.75 + 0.3 * fbm(q * 5.0)) - craters * 0.12;
        float day = max(dot(n, sun), 0.0) * eclipse(vWorld, sun, planetCenter, planetRadius);
        gl_FragColor = vec4(albedo * (day * 1.2 + 0.02), 1.0);
      }
      """;

  static final String SUN_VERTEX = """
      #version 120
      varying vec2 vUV;
      void main() {
        vUV = gl_MultiTexCoord0.xy;
        gl_Position = gl_ModelViewProjectionMatrix * gl_Vertex;
      }
      """;

  static final String SUN_FRAGMENT = """
      #version 120
      varying vec2 vUV;
      void main() {
        vec2 p = vUV * 2.0 - 1.0;
        float r = length(p);
        float a = atan(p.y, p.x);
        float core = smoothstep(0.05, 0.045, r);
        float corona = exp(-r * 12.0) * 1.5 + exp(-r * 3.0) * 0.8;
        float rays = pow(abs(sin(a * 7.0) * sin(a * 3.0 + 1.0)), 6.0) * exp(-r * 4.0) * 0.4;
        vec3 color = vec3(1.0, 0.97, 0.9) * core + vec3(1.0, 0.75, 0.4) * (corona + rays);
        gl_FragColor = vec4(color * smoothstep(1.0, 0.7, r), 1.0);
      }
      """;

  protected GLSL planet, atmosphere, moon, sunShader;
  protected Mesh sphere;
  protected float[] stars;
  protected int width, height;

  // Composition : the planet is half lit, the sun just out of the frame on the right, its corona
  // flaring into the image. The moon hangs above the day side and shades it.
  protected final float[] eye = v(0, 0.3, 2.9);
  protected final float[] target;
  protected final float[] sunDir;
  protected final float[] moonCenter;
  protected final float moonRadius = 0.15f;

  public PlanetScene() {
    float[] toPlanet = normalize(sub(v(0, 0, 0), eye));
    float[] look = rotateY(toPlanet, -20);
    target = add(eye, look);
    float[] toSun = normalize(add(rotateY(look, -62), v(0, 0.22, 0)));
    sunDir = normalize(add(eye, scale(toSun, 60)));
    // Shadow on the surface point between the sun direction and the camera
    float[] toCamera = normalize(eye);
    float[] across = normalize(sub(toCamera, scale(sunDir, dot(toCamera, sunDir))));
    double a = Math.toRadians(56);
    float[] shaded = add(scale(sunDir, (float) Math.cos(a)), scale(across, (float) Math.sin(a)));
    moonCenter = add(shaded, scale(sunDir, 0.55f));
  }

  static float[] rotateY(float[] d, double degrees) {
    double r = Math.toRadians(degrees), c = Math.cos(r), s = Math.sin(r);
    return v(c * d[0] + s * d[2], d[1], -s * d[0] + c * d[2]);
  }

  @Override
  public String getName() {
    return "planet";
  }

  @Override
  public void init(GL gl, Arena arena, int width, int height) {
    this.width = width;
    this.height = height;
    planet = new GLSL(gl, SPHERE_VERTEX, PLANET_FRAGMENT);
    atmosphere = new GLSL(gl, SPHERE_VERTEX, ATMOSPHERE_FRAGMENT);
    moon = new GLSL(gl, SPHERE_VERTEX, MOON_FRAGMENT);
    sunShader = new GLSL(gl, SUN_VERTEX, SUN_FRAGMENT);
    sphere = Mesh.sphere(gl, 160, 80);

    Random r = new Random(42);
    stars = new float[2000 * 4];
    for (int i = 0; i < 2000; i++) {
      double z = r.nextDouble() * 2 - 1, phi = r.nextDouble() * 2 * Math.PI, s = Math.sqrt(1 - z * z);
      stars[i * 4] = (float) (s * Math.cos(phi) * 40);
      stars[i * 4 + 1] = (float) (z * 40);
      stars[i * 4 + 2] = (float) (s * Math.sin(phi) * 40);
      stars[i * 4 + 3] = (float) Math.pow(r.nextDouble(), 3);
    }
  }

  @Override
  public void display(GL gl, float time) {
    gl.glViewport(0, 0, width, height);
    gl.glClearColor(0, 0, 0, 1);
    gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
    gl.glDisable(GL.GL_LIGHTING);

    float[] view = lookAt(eye, target, v(0, 1, 0));
    load(gl, GL.GL_PROJECTION, perspective(58, (float) width / height, 0.1f, 100f));
    load(gl, GL.GL_MODELVIEW, view);

    // Stars, behind everything
    gl.glDisable(GL.GL_DEPTH_TEST);
    for (int pass = 0; pass < 2; pass++) {
      gl.glPointSize(pass == 0 ? 1f : 2f);
      gl.glBegin(GL.GL_POINTS);
      for (int i = 0; i < stars.length / 4; i++) {
        float b = stars[i * 4 + 3];
        if ((b > 0.6f) != (pass == 1))
          continue;
        gl.glColor3f(0.5f + b * 0.5f, 0.5f + b * 0.5f, 0.6f + b * 0.4f);
        gl.glVertex3f(stars[i * 4], stars[i * 4 + 1], stars[i * 4 + 2]);
      }
      gl.glEnd();
    }

    gl.glEnable(GL.GL_DEPTH_TEST);
    gl.glEnable(GL.GL_CULL_FACE);
    gl.glCullFace(GL.GL_BACK);
    gl.glFrontFace(GL.GL_CCW);

    // Planet
    float spin = time * 0.1f;
    planet.use();
    planet.set("center", 0, 0, 0).set("radius", 1f).set("sun", sunDir).set("eye", eye)
        .set("spin", spin).set("moonCenter", moonCenter).set("moonRadius", moonRadius);
    sphere.draw();

    // Moon
    moon.use();
    moon.set("center", moonCenter).set("radius", moonRadius).set("sun", sunDir)
        .set("planetCenter", 0, 0, 0).set("planetRadius", 1f);
    sphere.draw();

    // Atmosphere : additive shell around the planet
    gl.glEnable(GL.GL_BLEND);
    gl.glBlendFunc(GL.GL_ONE, GL.GL_ONE);
    gl.glDepthMask((byte) 0);
    atmosphere.use();
    atmosphere.set("center", 0, 0, 0).set("radius", 1.045f).set("sun", sunDir).set("eye", eye);
    sphere.draw();
    gl.glDisable(GL.GL_CULL_FACE);

    // Sun : billboard far along the sun direction, facing the camera
    float[] c = scale(sunDir, 40);
    float[] right = normalize(cross(sub(c, eye), v(0, 1, 0)));
    float[] up = normalize(cross(right, sub(c, eye)));
    float size = 34f;
    sunShader.use();
    gl.glBegin(GL.GL_QUADS);
    quadCorner(gl, c, right, up, -size, -size, 0, 0);
    quadCorner(gl, c, right, up, size, -size, 1, 0);
    quadCorner(gl, c, right, up, size, size, 1, 1);
    quadCorner(gl, c, right, up, -size, size, 0, 1);
    gl.glEnd();
    GLSL.none(gl);

    gl.glDepthMask((byte) 1);
    gl.glDisable(GL.GL_BLEND);
  }

  static void quadCorner(GL gl, float[] c, float[] right, float[] up, float x, float y, float u, float v) {
    gl.glTexCoord2f(u, v);
    gl.glVertex3f(c[0] + right[0] * x + up[0] * y, c[1] + right[1] * x + up[1] * y,
        c[2] + right[2] * x + up[2] * y);
  }

  @Override
  public void dispose(GL gl) {
    planet.dispose();
    atmosphere.dispose();
    moon.dispose();
    sunShader.dispose();
    sphere.dispose();
    gl.glDisable(GL.GL_DEPTH_TEST);
  }

  @Override
  public float referenceTime() {
    return 4f;
  }

  @Override
  public int timedFrames() {
    return 4;
  }
}
