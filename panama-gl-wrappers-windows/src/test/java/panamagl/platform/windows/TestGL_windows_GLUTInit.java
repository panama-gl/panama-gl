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
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.Assert;
import org.junit.Test;

/**
 * Check that every GLUT method of {@link GL_windows} invoking the binding invokes
 * {@link GLUT_windows#init()} first, as freeglut must be loaded and initialized before any GLUT
 * function : a regenerated wrapper missing it would crash at the first GLUT call when freeglut is
 * not loaded yet. Reads the generated source, hence checked on any platform.
 */
public class TestGL_windows_GLUTInit {
  static final Path SOURCE =
      Path.of("src/generated/java/panamagl/platform/windows/GL_windows.java");

  static final String INIT = "panamagl.platform.windows.GLUT_windows.init();";

  static final Pattern METHOD =
      Pattern.compile("\n  public [^\n(]* (\\w+)\\([^\n]*\\) \\{\n(.*?)\n  \\}", Pattern.DOTALL);

  @Test
  public void glutMethodsInitGLUTFirst() throws IOException {
    WindowsTest.assumeOrFailOnCI(SOURCE + " is readable from " + Path.of("").toAbsolutePath(),
        Files.isRegularFile(SOURCE));

    String source = withoutComments(Files.readString(SOURCE));

    List<String> missing = new ArrayList<>();
    int glutMethods = 0;

    Matcher m = METHOD.matcher(source);
    while (m.find()) {
      String body = m.group(2);
      if (!body.contains("gl_h.glut"))
        continue;
      glutMethods++;
      if (!body.strip().startsWith(INIT))
        missing.add(m.group(1));
    }

    Assert.assertTrue("GLUT methods found : " + glutMethods, glutMethods > 200);
    Assert.assertTrue("GLUT methods not invoking " + INIT + " first : " + missing,
        missing.isEmpty());
  }

  /** Methods that do not invoke GLUT must not load it. */
  @Test
  public void glMethodsDoNotInitGLUT() throws IOException {
    WindowsTest.assumeOrFailOnCI(SOURCE + " is readable", Files.isRegularFile(SOURCE));

    String source = withoutComments(Files.readString(SOURCE));

    List<String> unexpected = new ArrayList<>();
    Matcher m = METHOD.matcher(source);
    while (m.find()) {
      if (m.group(2).contains(INIT) && !m.group(2).contains("gl_h.glut"))
        unexpected.add(m.group(1));
    }
    Assert.assertTrue("Methods initializing GLUT without invoking it : " + unexpected,
        unexpected.isEmpty());
  }

  /** Remove commented code, e.g. stubs whose GLUT call is commented. */
  static String withoutComments(String source) {
    return source.replaceAll("(?s)/\\*.*?\\*/", "").replaceAll("//[^\n]*", "");
  }
}
