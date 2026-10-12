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
package panamagl.platform;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import org.junit.Assert;
import org.junit.Test;
import panamagl.factory.PanamaGLFactory;
import panamagl.opengl.GL;
import panamagl.opengl.GLContext;

/**
 * Write the platform on which the tests of this build ran, and the OpenGL implementation PanamaGL
 * could use there, to <code>target/panamagl-platform.properties</code>.
 * 
 * The CI aggregates these files of all the runners to report the platforms PanamaGL is tested on.
 */
public class TestPlatformReport {
  public static final String REPORT_FILE = "target/panamagl-platform.properties";

  @Test
  public void whenSelectingFactoryForThisPlatform_ThenGLIsUsableAndReported() throws IOException {
    Platform platform = new Platform();

    Properties report = new Properties();
    report.setProperty("os.name", System.getProperty("os.name"));
    report.setProperty("os.version", System.getProperty("os.version"));
    report.setProperty("os.arch", System.getProperty("os.arch"));
    report.setProperty("java.version", System.getProperty("java.version"));
    report.setProperty("java.vendor", System.getProperty("java.vendor"));

    // Given the factory selected for this platform
    PanamaGLFactory factory = PanamaGLFactory.select();
    report.setProperty("factory", factory.getClass().getName());

    try {
      // When creating a context
      GLContext context = factory.newGLContext();
      GL gl = factory.newGL();
      report.setProperty("gl", gl.getClass().getName());

      // Then OpenGL can be invoked
      report.setProperty("gl.vendor", glString(gl, GL.GL_VENDOR));
      report.setProperty("gl.renderer", glString(gl, GL.GL_RENDERER));
      report.setProperty("gl.version", glString(gl, GL.GL_VERSION));

      context.destroy();
    } catch (RuntimeException | Error e) {
      report.setProperty("error", e.toString());
      throw e;
    } finally {
      write(report);
      System.out.println("TestPlatformReport : " + platform + " : " + report);
    }

    Assert.assertFalse(report.getProperty("gl.version").isEmpty());
  }

  protected static String glString(GL gl, int name) {
    return gl.glGetString(name).getString(0);
  }

  protected static void write(Properties report) throws IOException {
    File file = new File(REPORT_FILE);
    file.getParentFile().mkdirs();
    try (FileWriter writer = new FileWriter(file)) {
      report.store(writer, "Platform on which PanamaGL tests ran");
    }
  }
}
