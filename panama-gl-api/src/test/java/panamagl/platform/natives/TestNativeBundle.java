package panamagl.platform.natives;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileTime;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import panamagl.platform.natives.NativeBundleException.Reason;

/**
 * Native bundles : manifest validation, extraction, reuse, corruption, concurrency, fallback
 * folders and loading order. Each test builds its own classpath in a temporary folder, and loads
 * libraries with a fake loader : no native code is involved.
 */
public class TestNativeBundle {
  static final String PLATFORM = "testos-x86_64";

  @Rule
  public TemporaryFolder tmp = new TemporaryFolder();

  Path classpath;
  Path base;
  String previousDirectory;

  @Before
  public void before() throws IOException {
    classpath = tmp.newFolder("classpath").toPath();
    base = tmp.newFolder("base").toPath();
    previousDirectory = System.getProperty(NativeBundle.DIRECTORY_PROPERTY);
    NativeBundle.EXTRACTED.clear();
  }

  @After
  public void after() {
    if (previousDirectory == null)
      System.clearProperty(NativeBundle.DIRECTORY_PROPERTY);
    else
      System.setProperty(NativeBundle.DIRECTORY_PROPERTY, previousDirectory);
    NativeBundle.EXTRACTED.clear();
  }

  // ---------------------------------------------------------------------------------------------
  // Helpers

  /** Write a bundle and its manifest in the temporary classpath. */
  Path bundle(String name, Map<String, String> files, String load, String... extraLines)
      throws IOException {
    Path folder = classpath.resolve("natives").resolve(PLATFORM).resolve(name);
    Files.createDirectories(folder);
    StringBuilder manifest = new StringBuilder("bundle=" + name + "\nversion=1.0\nplatform="
        + PLATFORM + "\nload=" + load + "\n");
    for (Map.Entry<String, String> f : files.entrySet()) {
      byte[] content = f.getValue().getBytes(StandardCharsets.UTF_8);
      Files.write(folder.resolve(f.getKey()), content);
      manifest.append("file.").append(f.getKey()).append('=').append(NativeBundle.sha256(content))
          .append("\nsize.").append(f.getKey()).append('=').append(content.length).append('\n');
    }
    for (String line : extraLines)
      manifest.append(line).append('\n');
    Files.writeString(folder.resolve(NativeBundle.MANIFEST), manifest.toString());
    return folder;
  }

  Path simpleBundle() throws IOException {
    return bundle("lib", files("dep.dll", "dependency", "app.dll", "application"), "dep.dll,app.dll");
  }

  static Map<String, String> files(String... nameContent) {
    Map<String, String> files = new LinkedHashMap<>();
    for (int i = 0; i < nameContent.length; i += 2)
      files.put(nameContent[i], nameContent[i + 1]);
    return files;
  }

  ClassLoader loader() throws IOException {
    return new URLClassLoader(new URL[] {classpath.toUri().toURL()}, null);
  }

  NativeBundle find(String name) throws IOException {
    return NativeBundle.find(name, PLATFORM, loader());
  }

  static void expect(Reason reason, Runnable action) {
    try {
      action.run();
      fail("expected " + reason);
    } catch (NativeBundleException e) {
      assertEquals(e.getMessage(), reason, e.getReason());
    }
  }

  // ---------------------------------------------------------------------------------------------
  // Platform

  @Test
  public void platformNames() {
    assertEquals("windows", NativeBundle.os("Windows 11"));
    assertEquals("windows", NativeBundle.os("Windows Server 2022"));
    assertEquals("macos", NativeBundle.os("Mac OS X"));
    assertEquals("linux", NativeBundle.os("Linux"));
    assertEquals("freebsd", NativeBundle.os("FreeBSD"));
    assertEquals("x86_64", NativeBundle.cpu("amd64"));
    assertEquals("x86_64", NativeBundle.cpu("x86_64"));
    assertEquals("aarch64", NativeBundle.cpu("aarch64"));
    assertEquals("aarch64", NativeBundle.cpu("arm64"));
    assertEquals("riscv64", NativeBundle.cpu("riscv64"));
    assertTrue(NativeBundle.platform().matches("[a-z0-9]+-[a-z0-9_]+"));
  }

  // ---------------------------------------------------------------------------------------------
  // Manifest

  @Test
  public void findReadsTheManifest() throws IOException {
    simpleBundle();
    NativeBundle b = find("lib");
    assertEquals("lib", b.getName());
    assertEquals("1.0", b.getVersion());
    assertEquals(PLATFORM, b.getPlatform());
    assertEquals(List.of("dep.dll", "app.dll"), b.getLoad());
    assertEquals(Set.of("dep.dll", "app.dll"), new HashSet<>(b.getFiles()));
    assertTrue(b.getId().startsWith("lib-"));
    assertNull(b.getDirectory());
    assertTrue(NativeBundle.exists("lib", PLATFORM, loader()));
  }

  @Test
  public void bundleOfAnotherPlatformIsNotFound() throws IOException {
    simpleBundle();
    assertFalse(NativeBundle.exists("lib", "testos-aarch64", loader()));
    expect(Reason.NOT_FOUND, () -> {
      try {
        NativeBundle.find("lib", "testos-aarch64", loader());
      } catch (IOException e) {
        throw new IllegalStateException(e);
      }
    });
  }

  @Test
  public void manifestOfAnotherBundle() throws IOException {
    Path folder = simpleBundle();
    Path manifest = folder.resolve(NativeBundle.MANIFEST);
    Files.writeString(manifest, Files.readString(manifest).replace("bundle=lib", "bundle=other"));
    expect(Reason.INVALID_MANIFEST, () -> findUnchecked("lib"));
  }

  @Test
  public void manifestOfAnotherPlatform() throws IOException {
    Path folder = simpleBundle();
    Path manifest = folder.resolve(NativeBundle.MANIFEST);
    Files.writeString(manifest, Files.readString(manifest).replace("platform=" + PLATFORM, "platform=x-y"));
    expect(Reason.INVALID_MANIFEST, () -> findUnchecked("lib"));
  }

  @Test
  public void pathTraversalInAFileNameIsRejected() throws IOException {
    bundle("lib", files("app.dll", "a"), "app.dll",
        "file.../evil.dll=" + "0".repeat(64), "size.../evil.dll=1");
    expect(Reason.INVALID_MANIFEST, () -> findUnchecked("lib"));
  }

  @Test
  public void hiddenOrTemporaryFileNamesAreRejected() throws IOException {
    bundle("lib", files("app.dll", "a"), "app.dll", "file..hidden=" + "0".repeat(64), "size..hidden=1");
    expect(Reason.INVALID_MANIFEST, () -> findUnchecked("lib"));
  }

  @Test
  public void namesDifferingOnlyByCaseAreRejected() throws IOException {
    bundle("lib", files("app.dll", "a", "APP.dll", "b"), "app.dll");
    expect(Reason.INVALID_MANIFEST, () -> findUnchecked("lib"));
  }

  @Test
  public void loadListMustReferToFilesOfTheBundle() throws IOException {
    bundle("lib", files("app.dll", "a"), "app.dll,missing.dll");
    expect(Reason.INVALID_MANIFEST, () -> findUnchecked("lib"));
  }

  @Test
  public void malformedHashOrMissingSize() throws IOException {
    bundle("lib", files("app.dll", "a"), "app.dll", "file.b.dll=nothex", "size.b.dll=1");
    expect(Reason.INVALID_MANIFEST, () -> findUnchecked("lib"));

    bundle("lib2", files("app.dll", "a"), "app.dll", "file.c.dll=" + "0".repeat(64));
    expect(Reason.INVALID_MANIFEST, () -> findUnchecked("lib2"));
  }

  @Test
  public void bundleWithoutFile() throws IOException {
    bundle("lib", files(), "");
    expect(Reason.INVALID_MANIFEST, () -> findUnchecked("lib"));
  }

  NativeBundle findUnchecked(String name) {
    try {
      return find(name);
    } catch (IOException e) {
      throw new IllegalStateException(e);
    }
  }

  // ---------------------------------------------------------------------------------------------
  // Extraction

  @Test
  public void extractWritesEveryFileOnceAndReusesThem() throws Exception {
    simpleBundle();
    NativeBundle b = find("lib");
    Path folder = b.extract(List.of(base));

    // The real path : /var is /private/var on macOS, RUNNER~1 is runneradmin on Windows
    assertSame(base.resolve(b.getId()), folder);
    assertEquals("dependency", Files.readString(folder.resolve("dep.dll")));
    assertEquals("application", Files.readString(folder.resolve("app.dll")));
    assertEquals(folder, b.getDirectory());

    // When a new JVM (fresh registry) extracts it again : the files are not rewritten
    FileTime written = FileTime.from(Instant.parse("2020-01-01T00:00:00Z"));
    Files.setLastModifiedTime(folder.resolve("app.dll"), written);
    NativeBundle.EXTRACTED.clear();
    assertEquals(folder, find("lib").extract(List.of(base)));
    assertEquals(written, Files.getLastModifiedTime(folder.resolve("app.dll")));
    assertNoTemporaryFile(folder);
  }

  @Test
  public void modifiedOrTruncatedExtractedFilesAreReplaced() throws Exception {
    simpleBundle();
    Path folder = find("lib").extract(List.of(base));

    Files.writeString(folder.resolve("app.dll"), "applicatioN"); // same size, other content
    Files.writeString(folder.resolve("dep.dll"), "dep"); // truncated
    NativeBundle.EXTRACTED.clear();
    find("lib").extract(List.of(base));

    assertEquals("application", Files.readString(folder.resolve("app.dll")));
    assertEquals("dependency", Files.readString(folder.resolve("dep.dll")));
  }

  @Test
  public void deletedFileIsExtractedAgainEvenInTheSameJVM() throws Exception {
    simpleBundle();
    NativeBundle b = find("lib");
    Path folder = b.extract(List.of(base));
    Files.delete(folder.resolve("dep.dll"));
    assertEquals(folder, b.extract(List.of(base)));
    assertEquals("dependency", Files.readString(folder.resolve("dep.dll")));
  }

  @Test
  public void corruptedResourceIsNeverExtracted() throws Exception {
    Path folder = simpleBundle();
    Files.writeString(folder.resolve("app.dll"), "tampered!!!"); // jar content != manifest
    NativeBundle b = find("lib");

    expect(Reason.CORRUPTED, () -> b.extract(List.of(base)));
    Path target = base.resolve(b.getId());
    assertFalse(Files.exists(target.resolve("app.dll")));
    assertNoTemporaryFile(target);
  }

  @Test
  public void resourceListedButMissingFromTheClasspath() throws Exception {
    Path folder = simpleBundle();
    Files.delete(folder.resolve("dep.dll"));
    NativeBundle b = find("lib");
    expect(Reason.CORRUPTED, () -> b.extract(List.of(base)));
  }

  @Test
  public void versionsOfABundleAreExtractedInDifferentFolders() throws Exception {
    simpleBundle();
    Path v1 = find("lib").extract(List.of(base));
    bundle("lib", files("dep.dll", "dependency", "app.dll", "application v2"), "dep.dll,app.dll");
    Path v2 = find("lib").extract(List.of(base));

    assertNotEquals(v1, v2);
    assertEquals("application", Files.readString(v1.resolve("app.dll")));
    assertEquals("application v2", Files.readString(v2.resolve("app.dll")));
  }

  @Test
  public void staleTemporaryFilesAreRemovedRecentOnesKept() throws Exception {
    simpleBundle();
    NativeBundle b = find("lib");
    Path folder = base.resolve(b.getId());
    Files.createDirectories(folder);
    Path stale = Files.writeString(folder.resolve(".app.dll.123.tmp"), "partial");
    Files.setLastModifiedTime(stale, FileTime.from(Instant.now().minus(NativeBundle.STALE).minusSeconds(60)));
    Path recent = Files.writeString(folder.resolve(".app.dll.456.tmp"), "being written by another JVM");

    b.extract(List.of(base));
    assertFalse(Files.exists(stale));
    assertTrue(Files.exists(recent));
  }

  @Test
  public void unusableBaseFolderFallsBackToTheNextOne() throws Exception {
    simpleBundle();
    Path notAFolder = Files.writeString(base.resolve("file"), "x");
    Path fallback = base.resolve("fallback");

    Path folder = find("lib").extract(List.of(notAFolder, fallback));
    assertSame(fallback, folder.getParent());
  }

  @Test
  public void extractedFileThatCannotBeReplacedFallsBackToTheNextBase() throws Exception {
    simpleBundle();
    NativeBundle b = find("lib");
    // A folder in place of a file : as a library held open on Windows, it cannot be replaced
    Files.createDirectories(base.resolve(b.getId()).resolve("app.dll").resolve("in-use"));
    Path fallback = tmp.newFolder("fallback").toPath();

    Path folder = b.extract(List.of(base, fallback));
    assertSame(fallback.resolve(b.getId()), folder);
    assertEquals("application", Files.readString(folder.resolve("app.dll")));
  }

  @Test
  public void noUsableFolder() throws Exception {
    simpleBundle();
    Path a = Files.writeString(base.resolve("a"), "x");
    Path c = Files.writeString(base.resolve("c"), "x");
    try {
      find("lib").extract(List.of(a, c));
      fail();
    } catch (NativeBundleException e) {
      assertEquals(Reason.NOT_EXTRACTED, e.getReason());
      assertEquals(2, e.getSuppressed().length);
      assertTrue(e.getMessage().contains(NativeBundle.DIRECTORY_PROPERTY));
    }
  }

  @Test
  public void explicitFolderIsTheOnlyOneTried() throws Exception {
    // A space, and an accent where file names can hold it (not with an ASCII sun.jnu.encoding)
    String accent = java.nio.charset.Charset.forName(System.getProperty("sun.jnu.encoding", "UTF-8"))
        .newEncoder().canEncode("é") ? " é" : "";
    Path explicit = tmp.newFolder("with space" + accent).toPath();
    System.setProperty(NativeBundle.DIRECTORY_PROPERTY, explicit.toString());
    assertEquals(List.of(explicit), NativeBundle.candidateDirectories());

    simpleBundle();
    Path folder = find("lib").extract();
    assertSame(explicit, folder.getParent());

    System.clearProperty(NativeBundle.DIRECTORY_PROPERTY);
    List<Path> defaults = NativeBundle.candidateDirectories();
    assertTrue(defaults.get(0).getFileName().toString().startsWith("panamagl-natives-"));
  }

  @Test
  public void concurrentExtractionsInOneJVM() throws Exception {
    bundle("big", files("a.dll", "a".repeat(2_000_000), "b.dll", "b".repeat(1_000_000)), "a.dll,b.dll");
    ClassLoader loader = loader();
    List<Callable<Path>> tasks = new ArrayList<>();
    for (int i = 0; i < 8; i++)
      tasks.add(() -> NativeBundle.find("big", PLATFORM, loader).extract(List.of(base)));
    ExecutorService pool = Executors.newFixedThreadPool(8);
    try {
      Set<Path> folders = new HashSet<>();
      for (Future<Path> f : pool.invokeAll(tasks))
        folders.add(f.get());
      assertEquals(1, folders.size());
      Path folder = folders.iterator().next();
      assertEquals(2_000_000, Files.size(folder.resolve("a.dll")));
      assertNoTemporaryFile(folder);
    } finally {
      pool.shutdownNow();
    }
  }

  @Test
  public void concurrentExtractionsAsByConcurrentJVMs() throws Exception {
    // extractInto without the lock of the JVM, as two processes would run it
    bundle("big", files("a.dll", "a".repeat(3_000_000)), "a.dll");
    ClassLoader loader = loader();
    Path folder = base.resolve("shared");
    CountDownLatch start = new CountDownLatch(1);
    ExecutorService pool = Executors.newFixedThreadPool(6);
    try {
      List<Future<?>> runs = new ArrayList<>();
      for (int i = 0; i < 6; i++)
        runs.add(pool.submit(() -> {
          start.await();
          NativeBundle.find("big", PLATFORM, loader).extractInto(folder);
          return null;
        }));
      start.countDown();
      for (Future<?> r : runs)
        r.get();
      assertEquals("a".repeat(3_000_000), Files.readString(folder.resolve("a.dll")));
      assertNoTemporaryFile(folder);
    } finally {
      pool.shutdownNow();
    }
  }

  /** The same file, whatever the links or short names of the paths. */
  static void assertSame(Path expected, Path actual) throws IOException {
    assertTrue(expected + " is not " + actual, Files.isSameFile(expected, actual));
    assertEquals("not a real path : " + actual, actual.toRealPath(), actual);
  }

  static void assertNoTemporaryFile(Path folder) throws IOException {
    if (!Files.isDirectory(folder))
      return;
    try (var files = Files.list(folder)) {
      List<Path> temps = files.filter(f -> f.toString().endsWith(NativeBundle.TEMP_SUFFIX)).toList();
      assertTrue("temporary files left : " + temps, temps.isEmpty());
    }
  }

  // ---------------------------------------------------------------------------------------------
  // Loading

  @Test
  public void librariesAreLoadedInOrder() throws Exception {
    System.setProperty(NativeBundle.DIRECTORY_PROPERTY, base.toString());
    simpleBundle();
    List<String> calls = new ArrayList<>();
    List<Path> loaded = find("lib").load(p -> calls.add(p.getFileName().toString()));
    assertEquals(List.of("dep.dll", "app.dll"), calls);
    assertEquals(2, loaded.size());
    assertTrue(Files.exists(loaded.get(0)));
  }

  @Test
  public void libraryIsRetriedOnceItsDependencyIsLoaded() throws Exception {
    System.setProperty(NativeBundle.DIRECTORY_PROPERTY, base.toString());
    // Listed in the wrong order : app.dll needs dep.dll, as Windows would report
    bundle("lib", files("app.dll", "a", "dep.dll", "d", "data.json", "{}"), "app.dll,dep.dll");
    Set<String> loaded = new HashSet<>();
    List<String> attempts = new ArrayList<>();
    List<Path> result = find("lib").load(p -> {
      String name = p.getFileName().toString();
      attempts.add(name);
      if (name.equals("app.dll") && !loaded.contains("dep.dll"))
        throw new UnsatisfiedLinkError("dependency of app.dll not found");
      loaded.add(name);
    });
    assertEquals(List.of("app.dll", "dep.dll", "app.dll"), attempts);
    assertEquals(List.of("dep.dll", "app.dll"),
        result.stream().map(p -> p.getFileName().toString()).toList());
  }

  @Test
  public void unloadableLibrariesReportEveryError() throws Exception {
    System.setProperty(NativeBundle.DIRECTORY_PROPERTY, base.toString());
    bundle("lib", files("a.dll", "a", "b.dll", "b", "ok.dll", "ok"), "a.dll,ok.dll,b.dll");
    try {
      find("lib").load(p -> {
        if (!p.getFileName().toString().equals("ok.dll"))
          throw new UnsatisfiedLinkError("cannot load " + p.getFileName());
      });
      fail();
    } catch (NativeBundleException e) {
      assertEquals(Reason.NOT_LOADED, e.getReason());
      assertTrue(e.getMessage(), e.getMessage().contains("[a.dll, b.dll]"));
      assertTrue(e.getMessage(), e.getMessage().contains("ok.dll"));
      assertEquals(2, e.getSuppressed().length);
    }
  }

  @Test
  public void bundleWithoutLibraryLoadsNothingButIsExtracted() throws Exception {
    System.setProperty(NativeBundle.DIRECTORY_PROPERTY, base.toString());
    bundle("vulkan", files("driver.dll", "d", "icd.json", "{}"), "", "vulkan.icd=icd.json");
    NativeBundle b = find("vulkan");
    assertEquals(Collections.emptyList(), b.load(p -> fail("nothing to load")));
    assertEquals("icd.json", b.getProperty("vulkan.icd"));
    assertTrue(Files.exists(b.getDirectory().resolve(b.getProperty("vulkan.icd"))));
  }

  // ---------------------------------------------------------------------------------------------
  // Resources without manifest

  @Test
  public void resourcesWithoutManifest() throws Exception {
    Path legacy = classpath.resolve("natives").resolve(PLATFORM);
    Files.createDirectories(legacy);
    Files.writeString(legacy.resolve("freeglut.dll"), "glut");
    String resource = "natives/" + PLATFORM + "/freeglut.dll";

    NativeBundle b = NativeBundle.ofResources("freeglut", PLATFORM, loader(), List.of(resource),
        List.of("freeglut.dll"));
    Path folder = b.extract(List.of(base));
    assertEquals("glut", Files.readString(folder.resolve("freeglut.dll")));

    // The id follows the content
    Files.writeString(legacy.resolve("freeglut.dll"), "glut 2");
    NativeBundle b2 = NativeBundle.ofResources("freeglut", PLATFORM, loader(), List.of(resource),
        List.of("freeglut.dll"));
    assertNotEquals(b.getId(), b2.getId());

    expect(Reason.NOT_FOUND, () -> {
      try {
        NativeBundle.ofResources("x", PLATFORM, loader(), List.of("natives/none.dll"), List.of());
      } catch (IOException e) {
        throw new IllegalStateException(e);
      }
    });
  }
}
