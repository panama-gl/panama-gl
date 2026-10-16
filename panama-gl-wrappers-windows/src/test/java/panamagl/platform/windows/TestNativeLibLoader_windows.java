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
 * Check that freeglut is embedded in the jar for each Windows CPU and can be loaded without being
 * installed.
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

  /** Checked on any platform, as the jar is the same for all. */
  @Test
  public void freeglutIsEmbeddedForEachCPU() throws IOException {
    for (String cpu : new String[] {"amd64", "aarch64"}) {
      String resource = NativeLibLoader_windows.resource(NativeLibLoader_windows.GLUT, cpu);

      try (InputStream in = getClass().getClassLoader().getResourceAsStream(resource)) {
        Assert.assertNotNull(resource + " is missing", in);

        // A Windows DLL starts with the MZ header
        byte[] header = in.readNBytes(2);
        Assert.assertEquals('M', header[0]);
        Assert.assertEquals('Z', header[1]);
      }
    }
  }

  /** Pure Java, checked on any platform. */
  @Test
  public void extractOnceInAFolderNamedAfterTheContent() throws IOException {
    String resource = NativeLibLoader_windows.resource(NativeLibLoader_windows.GLUT, "amd64");
    Path directory = folder.getRoot().toPath();

    // When extracting
    Path file = NativeLibLoader_windows.extract(resource, directory);

    // Then the file has the content of the resource
    Assert.assertEquals("freeglut.dll", file.getFileName().toString());
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

  @Test
  public void embeddedFreeglutLoadsOnThisCPU() throws IOException {
    if (!checkPlatform())
      return;

    String resource =
        NativeLibLoader_windows.resource(NativeLibLoader_windows.GLUT, System.getProperty("os.arch"));

    System.load(NativeLibLoader_windows.extract(resource, folder.getRoot().toPath()).toString());
  }

  @Test
  public void loadGLUT() {
    if (!checkPlatform())
      return;

    NativeLibLoader_windows.loadGLUT();

    Assert.assertTrue(NativeLibLoader_windows.glutLoaded);
  }
}
