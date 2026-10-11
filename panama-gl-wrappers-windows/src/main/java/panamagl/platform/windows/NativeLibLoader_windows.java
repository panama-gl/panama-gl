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
package panamagl.platform.windows;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HexFormat;
import opengl.windows.NativeLibLoader;

/**
 * Load the DLL required by the Windows bindings : opengl32, glu32 and freeglut.
 *
 * opengl32 and glu32 are part of Windows. freeglut is not : it is loaded from the
 * <code>java.library.path</code> if available, otherwise from the freeglut.dll embedded in this jar
 * for the CPU of the JVM (x86_64 or aarch64), which is extracted in the temporary directory
 * before being loaded.
 *
 * The embedded freeglut.dll are cross-compiled with
 * <code>scripts/windows/build-freeglut-cross.sh</code> of the panama-gl-bindings project.
 */
public class NativeLibLoader_windows {
  public static final String GLUT = "freeglut";

  /** Folder of the jar containing the embedded native libraries, followed by the CPU name. */
  public static final String NATIVES = "natives/windows-";

  protected static boolean glutLoaded = false;

  /** Load OpenGL related DLL : opengl32, glu32, freeglut */
  public static void load() {
    NativeLibLoader.loadGL();
    NativeLibLoader.loadGLU();
    loadGLUT();
  }

  /** Load required windows DLL : user32, gdi32, kernel32 */
  public static void loadWindowsDLLs() {
    NativeLibLoader.loadWindowsDLLs();
  }

  /**
   * Load freeglut from the <code>java.library.path</code>, or from the freeglut.dll embedded in
   * this jar if not found there.
   */
  public static synchronized void loadGLUT() {
    if (glutLoaded)
      return;

    try {
      System.loadLibrary(GLUT);
    } catch (UnsatisfiedLinkError notInLibraryPath) {
      String resource = resource(GLUT, System.getProperty("os.arch"));
      try {
        System.load(extract(resource, tempDirectory()).toString());
      } catch (IOException | UnsatisfiedLinkError e) {
        UnsatisfiedLinkError error = new UnsatisfiedLinkError(
            "Could not load " + GLUT + " from java.library.path nor from embedded " + resource
                + " : " + e.getMessage());
        error.addSuppressed(notInLibraryPath);
        error.initCause(e);
        throw error;
      }
    }
    glutLoaded = true;
  }

  /**
   * Path of an embedded DLL in the jar for the given CPU, as given by the <code>os.arch</code>
   * system property.
   */
  public static String resource(String library, String cpu) {
    return NATIVES + normalizeCPU(cpu) + "/" + library + ".dll";
  }

  /** Java reports amd64 on Intel/AMD CPUs and aarch64 on ARM64 CPUs. */
  protected static String normalizeCPU(String cpu) {
    switch (cpu) {
      case "amd64":
      case "x86_64":
        return "x86_64";
      case "aarch64":
      case "arm64":
        return "aarch64";
      default:
        return cpu;
    }
  }

  /**
   * Extract a resource of this jar in a sub-folder of the given directory named after the hash of
   * the resource content, and return the path of the extracted file.
   *
   * A file already extracted by a previous run, possibly loaded by another running JVM, is reused
   * instead of being written again, so that the temporary directory does not fill up with a copy
   * per run.
   */
  public static Path extract(String resource, Path directory) throws IOException {
    byte[] content;
    try (InputStream in = NativeLibLoader_windows.class.getClassLoader().getResourceAsStream(resource)) {
      if (in == null)
        throw new IOException(resource + " is not embedded in the classpath");
      content = in.readAllBytes();
    }

    Path folder = directory.resolve(sha256(content).substring(0, 16));
    Path file = folder.resolve(Path.of(resource).getFileName().toString());

    if (Files.isRegularFile(file) && Files.size(file) == content.length)
      return file;

    // Write a temporary file then move it, so that a concurrent JVM never loads a partial file
    Files.createDirectories(folder);
    Path temp = Files.createTempFile(folder, file.getFileName().toString(), ".tmp");
    try {
      Files.write(temp, content);
      Files.move(temp, file, StandardCopyOption.ATOMIC_MOVE);
    } catch (IOException e) {
      // Another JVM may have extracted and loaded the same file meanwhile
      if (!Files.isRegularFile(file) || Files.size(file) != content.length)
        throw e;
    } finally {
      Files.deleteIfExists(temp);
    }
    return file;
  }

  protected static Path tempDirectory() {
    return Path.of(System.getProperty("java.io.tmpdir"), "panamagl");
  }

  protected static String sha256(byte[] content) {
    try {
      return HexFormat.of().formatHex(MessageDigest.getInstance("SHA-256").digest(content));
    } catch (NoSuchAlgorithmException e) {
      throw new IllegalStateException(e);
    }
  }
}
