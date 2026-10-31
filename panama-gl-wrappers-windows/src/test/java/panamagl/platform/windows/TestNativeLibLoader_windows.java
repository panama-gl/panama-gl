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
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

/**
 * Check how freeglut is found : in the java.library.path, otherwise in the classpath where the
 * optional panama-gl-bindings-windows-freeglut jar embeds it for each Windows CPU.
 */
public class TestNativeLibLoader_windows extends WindowsTest {
  @Rule
  public TemporaryFolder folder = new TemporaryFolder();

  /** Pure logic, checked on any platform. */
  @Test
  public void resourceIsNamedAfterTheCPU() {
    Assert.assertEquals("natives/windows-x86_64/freeglut.dll",
        NativeLibLoader_windows.resource("freeglut", "amd64"));
    Assert.assertEquals("natives/windows-x86_64/freeglut.dll",
        NativeLibLoader_windows.resource("freeglut", "x86_64"));
    Assert.assertEquals("natives/windows-aarch64/freeglut.dll",
        NativeLibLoader_windows.resource("freeglut", "aarch64"));
    Assert.assertEquals("natives/windows-aarch64/freeglut.dll",
        NativeLibLoader_windows.resource("freeglut", "arm64"));
  }

  /** Pure Java, checked on any platform with a resource that is always in the classpath. */
  @Test
  public void extractOnceInAFolderNamedAfterTheContent() throws IOException {
    String resource = NativeLibLoader_windows.class.getName().replace('.', '/') + ".class";
    Path directory = folder.getRoot().toPath();

    // When extracting
    Path file = NativeLibLoader_windows.extract(resource, directory);

    // Then the file has the content of the resource
    Assert.assertEquals("NativeLibLoader_windows.class", file.getFileName().toString());
    Assert.assertEquals(directory, file.getParent().getParent());
    try (InputStream in = getClass().getClassLoader().getResourceAsStream(resource)) {
      Assert.assertArrayEquals(in.readAllBytes(), Files.readAllBytes(file));
    }

    // When extracting again
    long modified = Files.getLastModifiedTime(file).toMillis();
    Path again = NativeLibLoader_windows.extract(resource, directory);

    // Then the extracted file is reused
    Assert.assertEquals(file, again);
    Assert.assertEquals(modified, Files.getLastModifiedTime(again).toMillis());
    try (var files = Files.list(file.getParent())) {
      Assert.assertEquals(1, files.count());
    }
  }

  @Test(expected = IOException.class)
  public void extractMissingResourceFails() throws IOException {
    NativeLibLoader_windows.extract("natives/windows-unknown/freeglut.dll", folder.getRoot().toPath());
  }

  /**
   * The optional jar, a test dependency on Windows, embeds freeglut for both CPUs, and the DLL of the
   * CPU of the JVM loads. Fails on CI if the jar is not in the classpath, skipped elsewhere.
   */
  @Test
  public void embeddedFreeglutLoadsOnThisCPU() throws IOException {
    if (!checkPlatform())
      return;

    for (String cpu : new String[] {"amd64", "aarch64"}) {
      String resource = NativeLibLoader_windows.resource(NativeLibLoader_windows.GLUT, cpu);
      assumeOrFailOnCI(resource + " is in the classpath (" + NativeLibLoader_windows.GLUT_ARTIFACT
          + ")", getClass().getClassLoader().getResource(resource) != null);
    }

    String resource =
        NativeLibLoader_windows.resource(NativeLibLoader_windows.GLUT, System.getProperty("os.arch"));
    System.load(NativeLibLoader_windows.extract(resource, folder.getRoot().toPath()).toString());
  }

  @Test
  public void loadGLUT() {
    if (!checkPlatform())
      return;

    NativeLibLoader_windows.loadGLUT();

    Assert.assertTrue(NativeLibLoader_windows.isGLUTLoaded());
  }
}
