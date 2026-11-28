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
package panamagl.platform.natives;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.FileTime;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HexFormat;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;
import java.util.stream.Stream;
import panamagl.platform.natives.NativeBundleException.Reason;

/**
 * Native libraries embedded in the classpath, extracted to the file system and loaded.
 *
 * <p>A bundle is a folder of the classpath, <code>natives/&lt;os&gt;-&lt;cpu&gt;/&lt;bundle&gt;/</code>
 * (e.g. <code>natives/windows-x86_64/mesa-llvmpipe/</code>), with a {@value #MANIFEST} manifest :
 *
 * <pre>
 * bundle=mesa-llvmpipe
 * version=26.3.1
 * platform=windows-x86_64
 * load=dxil.dll,opengl32.dll          # the libraries to load, dependencies first
 * file.opengl32.dll=&lt;SHA-256&gt;       # every file of the bundle, with its hash
 * size.opengl32.dll=&lt;bytes&gt;          # and its size
 * </pre>
 *
 * Files that are not libraries (e.g. the json manifest of a Vulkan driver) are listed as files
 * but not loaded. A single library that predates bundles, e.g. <code>natives/windows-x86_64/freeglut.dll</code>,
 * can be handled the same way with {@link #ofResources(String, String, ClassLoader, List, List)},
 * which hashes it instead of reading a manifest.
 *
 * <h2>Extraction</h2>
 *
 * The files of a bundle are extracted together, so that a library finds the files next to it, in a
 * folder named after the bundle and the hash of its content : <code>&lt;base&gt;/mesa-llvmpipe-3f2a9c.../</code>.
 * Two versions of a bundle never share a folder, and a library loaded by a process is never
 * overwritten (Windows forbids it) by another version. The base folder is the first usable of
 *
 * <ol>
 * <li>the system property {@value #DIRECTORY_PROPERTY}, if set : then the only one tried,</li>
 * <li><code>&lt;java.io.tmpdir&gt;/panamagl-natives-&lt;user&gt;</code>,</li>
 * <li><code>&lt;user.home&gt;/.panamagl/natives</code>.</li>
 * </ol>
 *
 * A base folder is unusable if it cannot be written, or, on POSIX file systems, if it belongs to
 * another user (who could replace the libraries).
 *
 * <p>Each file is
 * <ul>
 * <li>reused if already extracted, by a previous run or by another running JVM, and identical to the
 * manifest (size and SHA-256) : nothing is written ;</li>
 * <li>otherwise copied from the classpath to a temporary file of the folder, verified against the
 * manifest, then moved atomically in place : a concurrent JVM never sees a partial file. A file of
 * the classpath that differs from the manifest (corrupted jar) is never extracted ;</li>
 * <li>temporary files left by a JVM killed during an extraction are removed after one hour.</li>
 * </ul>
 *
 * <h2>Loading</h2>
 *
 * {@link #load()} loads the libraries of the <code>load</code> list in order. A library whose
 * dependency is not loaded yet fails to load (Windows does not look for the dependencies of a DLL
 * in its folder) : such a library is retried once the others are loaded, until all are loaded or
 * none can be, which then throws a {@link NativeBundleException} with the error of each library.
 */
public class NativeBundle {
  /** The root folder of bundles in the classpath. */
  public static final String NATIVES = "natives/";

  /** The name of the manifest in the folder of a bundle. */
  public static final String MANIFEST = "bundle.properties";

  /** System property giving the folder where bundles are extracted. */
  public static final String DIRECTORY_PROPERTY = "panamagl.natives.dir";

  /** Temporary files older than this are left by an interrupted extraction and removed. */
  static final Duration STALE = Duration.ofHours(1);

  static final String TEMP_SUFFIX = ".tmp";

  static final Pattern SAFE_NAME = Pattern.compile("[A-Za-z0-9_+\\-][A-Za-z0-9_+.\\-]*");
  static final Pattern SHA256 = Pattern.compile("[0-9a-f]{64}");

  /** Loads a library : {@link #SYSTEM} by default, replaceable by tests. */
  @FunctionalInterface
  public interface LibraryLoader {
    void load(Path library);
  }

  /** Loads a library with {@link System#load(String)}. */
  public static final LibraryLoader SYSTEM = library -> System.load(library.toString());

  /** Folder of each bundle extracted by this JVM, by {@link #getId()}. */
  static final Map<String, Path> EXTRACTED = new ConcurrentHashMap<>();
  static final Map<String, Object> LOCKS = new ConcurrentHashMap<>();

  protected final String name;
  protected final String platform;
  protected final String version;
  protected final ClassLoader classLoader;
  protected final Map<String, String> resources; // file name -> resource path
  protected final Map<String, String> hashes; // file name -> SHA-256
  protected final Map<String, Long> sizes; // file name -> size
  protected final List<String> load;
  protected final Properties properties;
  protected final String id;

  protected NativeBundle(String name, String platform, String version, ClassLoader classLoader,
      Map<String, String> resources, Map<String, String> hashes, Map<String, Long> sizes,
      List<String> load, Properties properties) {
    this.name = name;
    this.platform = platform;
    this.version = version;
    this.classLoader = classLoader;
    this.resources = Collections.unmodifiableMap(resources);
    this.hashes = Collections.unmodifiableMap(hashes);
    this.sizes = Collections.unmodifiableMap(sizes);
    this.load = List.copyOf(load);
    this.properties = properties;

    // The id changes with the content of any file, its name, or the load order
    StringBuilder content = new StringBuilder(name);
    hashes.forEach((file, hash) -> content.append('\n').append(file).append('=').append(hash));
    content.append("\nload=").append(String.join(",", load));
    this.id = name + "-" + sha256(content.toString().getBytes(StandardCharsets.UTF_8)).substring(0, 16);
  }

  // ---------------------------------------------------------------------------------------------
  // Platform

  /** @return the platform of this JVM, e.g. <code>windows-x86_64</code>, <code>linux-aarch64</code>. */
  public static String platform() {
    return os(System.getProperty("os.name")) + "-" + cpu(System.getProperty("os.arch"));
  }

  /** @return windows, macos or linux for the given <code>os.name</code>, else its lower case. */
  public static String os(String osName) {
    String os = osName.toLowerCase(Locale.ROOT);
    if (os.startsWith("windows"))
      return "windows";
    if (os.startsWith("mac") || os.startsWith("darwin"))
      return "macos";
    if (os.startsWith("linux"))
      return "linux";
    return os.replaceAll("[^a-z0-9]", "");
  }

  /** @return x86_64 or aarch64 for the names Java gives to these CPUs, else its lower case. */
  public static String cpu(String osArch) {
    String cpu = osArch.toLowerCase(Locale.ROOT);
    switch (cpu) {
      case "amd64":
      case "x86_64":
      case "x64":
        return "x86_64";
      case "aarch64":
      case "arm64":
        return "aarch64";
      default:
        return cpu;
    }
  }

  // ---------------------------------------------------------------------------------------------
  // Find

  /** @return the classpath folder of a bundle, e.g. <code>natives/windows-x86_64/mesa-zink/</code>. */
  public static String folder(String name, String platform) {
    return NATIVES + platform + "/" + name + "/";
  }

  /** @return true if the bundle is in the classpath for the platform of this JVM. */
  public static boolean exists(String name) {
    return exists(name, platform(), defaultClassLoader());
  }

  public static boolean exists(String name, String platform, ClassLoader classLoader) {
    return classLoader.getResource(folder(name, platform) + MANIFEST) != null;
  }

  /**
   * @return the bundle of the given name for the platform of this JVM.
   * @throws NativeBundleException NOT_FOUND if not in the classpath, INVALID_MANIFEST if its
   *         manifest is malformed.
   */
  public static NativeBundle find(String name) {
    return find(name, platform(), defaultClassLoader());
  }

  public static NativeBundle find(String name, String platform, ClassLoader classLoader) {
    String folder = folder(name, platform);
    Properties p = new Properties();
    try (InputStream in = classLoader.getResourceAsStream(folder + MANIFEST)) {
      if (in == null)
        throw new NativeBundleException(Reason.NOT_FOUND,
            "Native bundle " + name + " for " + platform + " not in the classpath : " + folder
                + MANIFEST + " not found");
      try (Reader r = new java.io.InputStreamReader(in, StandardCharsets.UTF_8)) {
        p.load(r);
      }
    } catch (IOException | IllegalArgumentException e) {
      throw new NativeBundleException(Reason.INVALID_MANIFEST,
          "Could not read " + folder + MANIFEST + " : " + e.getMessage(), e);
    }
    return fromManifest(name, platform, classLoader, folder, p);
  }

  static NativeBundle fromManifest(String name, String platform, ClassLoader classLoader,
      String folder, Properties p) {
    String where = folder + MANIFEST;
    check(name.equals(p.getProperty("bundle")),
        where + " : bundle=" + p.getProperty("bundle") + ", expected " + name);
    String declared = p.getProperty("platform");
    check(declared == null || declared.equals(platform),
        where + " : platform=" + declared + ", expected " + platform);

    Map<String, String> resources = new LinkedHashMap<>();
    Map<String, String> hashes = new LinkedHashMap<>();
    Map<String, Long> sizes = new LinkedHashMap<>();
    p.stringPropertyNames().stream().filter(k -> k.startsWith("file.")).sorted().forEach(k -> {
      String file = k.substring("file.".length());
      check(isSafeName(file), where + " : unsafe file name '" + file + "'");
      String hash = p.getProperty(k).trim().toLowerCase(Locale.ROOT);
      check(SHA256.matcher(hash).matches(), where + " : " + k + " is not a SHA-256");
      String size = p.getProperty("size." + file);
      check(size != null && size.trim().matches("[0-9]+"), where + " : size." + file + " missing");
      resources.put(file, folder + file);
      hashes.put(file, hash);
      sizes.put(file, Long.parseLong(size.trim()));
    });
    check(!hashes.isEmpty(), where + " : no file");
    checkCaseInsensitiveNames(hashes.keySet(), where);

    List<String> load = list(p.getProperty("load", ""));
    for (String library : load)
      check(hashes.containsKey(library), where + " : load refers to " + library + ", not a file of the bundle");
    return new NativeBundle(name, platform, p.getProperty("version", ""), classLoader, resources,
        hashes, sizes, load, p);
  }

  /**
   * A bundle made of resources of the classpath without manifest, e.g. a library embedded before
   * bundles existed. The resources are hashed to verify the extracted files.
   *
   * @param resources the paths of the files in the classpath; their file names must differ.
   * @param load the file names of the libraries to load, in order.
   */
  public static NativeBundle ofResources(String name, String platform, ClassLoader classLoader,
      List<String> resources, List<String> load) {
    Map<String, String> files = new LinkedHashMap<>();
    Map<String, String> hashes = new LinkedHashMap<>();
    Map<String, Long> sizes = new LinkedHashMap<>();
    for (String resource : resources) {
      String file = resource.substring(resource.lastIndexOf('/') + 1);
      check(isSafeName(file), "unsafe file name '" + file + "'");
      check(!files.containsKey(file), "two resources named " + file);
      try (InputStream in = classLoader.getResourceAsStream(resource)) {
        if (in == null)
          throw new NativeBundleException(Reason.NOT_FOUND, resource + " not in the classpath");
        MessageDigest digest = sha256();
        long size = new DigestInputStream(in, digest).transferTo(OutputStream.nullOutputStream());
        files.put(file, resource);
        hashes.put(file, HexFormat.of().formatHex(digest.digest()));
        sizes.put(file, size);
      } catch (IOException e) {
        throw new NativeBundleException(Reason.CORRUPTED, "Could not read " + resource, e);
      }
    }
    checkCaseInsensitiveNames(hashes.keySet(), name);
    for (String library : load)
      check(hashes.containsKey(library), "load refers to " + library + ", not a resource");
    return new NativeBundle(name, platform, "", classLoader, files, hashes, sizes, load,
        new Properties());
  }

  // ---------------------------------------------------------------------------------------------
  // Extract

  /** @return the folder where the files of the bundle are, extracting them if needed. */
  public Path extract() {
    return extract(candidateDirectories());
  }

  /** Extract in the first usable of the given base folders. */
  public Path extract(List<Path> bases) {
    synchronized (LOCKS.computeIfAbsent(id, k -> new Object())) {
      Path done = EXTRACTED.get(id);
      if (done != null && isComplete(done))
        return done;

      List<Exception> failures = new ArrayList<>();
      for (Path base : bases) {
        try {
          if (!isUsable(base)) {
            failures.add(new IOException(base + " is not writable, or belongs to another user"));
            continue;
          }
          // The real path : on Windows, java.io.tmpdir may be a short 8.3 name (RUNNER~1) while
          // the loaded libraries are reported with long names
          Path folder = base.toRealPath().resolve(id);
          extractInto(folder);
          EXTRACTED.put(id, folder);
          return folder;
        } catch (IOException | SecurityException e) {
          failures.add(new IOException(base + " : " + e, e));
        }
      }
      NativeBundleException e = new NativeBundleException(Reason.NOT_EXTRACTED,
          "Could not extract native bundle " + id + " in any of " + bases + " (set -D"
              + DIRECTORY_PROPERTY + " to a writable folder)");
      failures.forEach(e::addSuppressed);
      throw e;
    }
  }

  /**
   * Extract every file in the folder, reusing the files already there. Safe against concurrent
   * JVMs extracting the same bundle : files are written aside then moved atomically.
   *
   * @throws NativeBundleException CORRUPTED if a resource differs from the manifest.
   * @throws IOException if the folder cannot hold the files : the caller tries another one.
   */
  void extractInto(Path folder) throws IOException {
    Files.createDirectories(folder);
    removeStaleTemporaryFiles(folder);

    for (String file : hashes.keySet()) {
      Path target = folder.resolve(file);
      if (isValid(target, file))
        continue;

      Path temp = Files.createTempFile(folder, "." + file + ".", TEMP_SUFFIX);
      try {
        MessageDigest digest = sha256();
        long size;
        try (InputStream in = classLoader.getResourceAsStream(resources.get(file))) {
          if (in == null)
            throw new NativeBundleException(Reason.CORRUPTED,
                resources.get(file) + " is listed by the bundle " + name + " but not in the classpath");
          try (OutputStream out = Files.newOutputStream(temp)) {
            size = new DigestInputStream(in, digest).transferTo(out);
          }
        }
        String hash = HexFormat.of().formatHex(digest.digest());
        if (size != sizes.get(file) || !hash.equals(hashes.get(file)))
          throw new NativeBundleException(Reason.CORRUPTED, resources.get(file) + " differs from "
              + "the manifest of " + name + " (" + size + " bytes, SHA-256 " + hash + ", expected "
              + sizes.get(file) + " bytes, " + hashes.get(file) + ") : the jar may be corrupted");
        try {
          Files.move(temp, target, StandardCopyOption.ATOMIC_MOVE,
              StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
          // Another JVM may have moved the same file meanwhile, or holds an invalid file opened
          if (!isValid(target, file))
            throw e;
        }
      } finally {
        Files.deleteIfExists(temp);
      }
    }
  }

  /** @return true if the file exists with the size and hash of the manifest. */
  boolean isValid(Path target, String file) throws IOException {
    if (!Files.isRegularFile(target) || Files.size(target) != sizes.get(file))
      return false;
    try (InputStream in = Files.newInputStream(target)) {
      MessageDigest digest = sha256();
      new DigestInputStream(in, digest).transferTo(OutputStream.nullOutputStream());
      return HexFormat.of().formatHex(digest.digest()).equals(hashes.get(file));
    }
  }

  /** Cheap check that a folder extracted by this JVM still holds its files. */
  boolean isComplete(Path folder) {
    try {
      for (Map.Entry<String, Long> e : sizes.entrySet()) {
        Path file = folder.resolve(e.getKey());
        if (!Files.isRegularFile(file) || Files.size(file) != e.getValue())
          return false;
      }
      return true;
    } catch (IOException e) {
      return false;
    }
  }

  static void removeStaleTemporaryFiles(Path folder) {
    Instant limit = Instant.now().minus(STALE);
    try (Stream<Path> files = Files.list(folder)) {
      files.filter(f -> f.getFileName().toString().endsWith(TEMP_SUFFIX)).forEach(f -> {
        try {
          FileTime modified = Files.getLastModifiedTime(f);
          if (modified.toInstant().isBefore(limit))
            Files.deleteIfExists(f);
        } catch (IOException ignored) {
          // in use or already removed by another JVM
        }
      });
    } catch (IOException ignored) {
      // the extraction reports the problems of the folder
    }
  }

  /**
   * @return true if files can be created in the base folder, created if needed, and, on POSIX
   *         file systems, if it belongs to the user running this JVM.
   */
  static boolean isUsable(Path base) {
    try {
      Files.createDirectories(base);
      Path probe = Files.createTempFile(base, ".probe", TEMP_SUFFIX);
      try {
        if (FileSystems.getDefault().supportedFileAttributeViews().contains("posix")
            && !Files.getOwner(base).equals(Files.getOwner(probe)))
          return false;
      } finally {
        Files.deleteIfExists(probe);
      }
      return true;
    } catch (IOException | SecurityException | UnsupportedOperationException e) {
      return false;
    }
  }

  /** @return the base folders tried by {@link #extract()}, in order. */
  public static List<Path> candidateDirectories() {
    String explicit = System.getProperty(DIRECTORY_PROPERTY);
    if (explicit != null && !explicit.isBlank())
      return List.of(Path.of(explicit));
    String user = System.getProperty("user.name", "user").replaceAll("[^A-Za-z0-9_.\\-]", "_");
    List<Path> bases = new ArrayList<>();
    bases.add(Path.of(System.getProperty("java.io.tmpdir"), "panamagl-natives-" + user));
    String home = System.getProperty("user.home");
    if (home != null && !home.isBlank())
      bases.add(Path.of(home, ".panamagl", "natives"));
    return bases;
  }

  // ---------------------------------------------------------------------------------------------
  // Load

  /** Extract the bundle if needed and load its libraries with {@link System#load(String)}. */
  public List<Path> load() {
    return load(SYSTEM);
  }

  /**
   * Extract the bundle if needed and load its libraries, retrying those whose dependencies were
   * not loaded yet.
   *
   * @return the libraries in the order they were loaded.
   * @throws NativeBundleException NOT_LOADED if some libraries cannot be loaded.
   */
  public List<Path> load(LibraryLoader loader) {
    Path folder = extract();
    List<String> pending = new ArrayList<>(load);
    List<Path> loaded = new ArrayList<>();
    Map<String, Throwable> errors = new LinkedHashMap<>();
    boolean progress = true;
    while (!pending.isEmpty() && progress) {
      progress = false;
      for (String library : List.copyOf(pending)) {
        Path path = folder.resolve(library);
        try {
          loader.load(path);
          loaded.add(path);
          pending.remove(library);
          errors.remove(library);
          progress = true;
        } catch (UnsatisfiedLinkError | IllegalArgumentException | SecurityException e) {
          errors.put(library, e);
        }
      }
    }
    if (!pending.isEmpty()) {
      NativeBundleException e = new NativeBundleException(Reason.NOT_LOADED,
          "Could not load " + pending + " of native bundle " + name + " from " + folder
              + (loaded.isEmpty() ? "" : " (loaded : " + loaded + ")") + " : "
              + errors.get(pending.get(0)).getMessage());
      errors.values().forEach(e::addSuppressed);
      throw e;
    }
    return loaded;
  }

  // ---------------------------------------------------------------------------------------------

  public String getName() {
    return name;
  }

  public String getPlatform() {
    return platform;
  }

  /** @return the version given by the manifest, empty if none. */
  public String getVersion() {
    return version;
  }

  /** @return the name of the folder of the extracted files : the name of the bundle and a hash. */
  public String getId() {
    return id;
  }

  /** @return the file names of the bundle. */
  public List<String> getFiles() {
    return List.copyOf(hashes.keySet());
  }

  /** @return the libraries to load, in order. */
  public List<String> getLoad() {
    return load;
  }

  /** @return a property of the manifest, e.g. <code>vulkan.icd</code>, or null. */
  public String getProperty(String key) {
    return properties.getProperty(key);
  }

  /** @return the folder where this JVM extracted the bundle, or null if not extracted yet. */
  public Path getDirectory() {
    return EXTRACTED.get(id);
  }

  @Override
  public String toString() {
    return "NativeBundle " + name + " " + version + " for " + platform + " " + getFiles();
  }

  // ---------------------------------------------------------------------------------------------

  /**
   * Extract a bundle of the classpath and print where, e.g. for an installer, or to declare the
   * Vulkan driver of a bundle in the registry of Windows :
   *
   * <pre>
   * java -cp ... panamagl.platform.natives.NativeBundle extract mesa-lavapipe            # the folder
   * java -cp ... panamagl.platform.natives.NativeBundle extract mesa-lavapipe vulkan.icd # a file
   * </pre>
   */
  public static void main(String[] args) {
    if (args.length < 2 || !args[0].equals("extract")) {
      System.err.println("usage : NativeBundle extract <bundle> [manifest property naming a file]");
      System.exit(2);
    }
    NativeBundle bundle = find(args[1]);
    Path folder = bundle.extract();
    if (args.length > 2) {
      String file = bundle.getProperty(args[2]);
      if (file == null || !bundle.getFiles().contains(file)) {
        System.err.println(args[2] + " does not name a file of " + bundle);
        System.exit(1);
      }
      System.out.println(folder.resolve(file));
    } else {
      System.out.println(folder);
    }
  }

  static ClassLoader defaultClassLoader() {
    ClassLoader context = Thread.currentThread().getContextClassLoader();
    return context != null ? context : NativeBundle.class.getClassLoader();
  }

  static boolean isSafeName(String file) {
    return SAFE_NAME.matcher(file).matches() && !file.equals(".") && !file.equals("..")
        && !file.endsWith(TEMP_SUFFIX);
  }

  static List<String> list(String value) {
    List<String> items = new ArrayList<>();
    for (String item : value.split(","))
      if (!item.isBlank())
        items.add(item.trim());
    return items;
  }

  /** Windows and macOS file systems ignore case : two such names would be the same file. */
  static void checkCaseInsensitiveNames(java.util.Collection<String> files, String where) {
    java.util.Set<String> seen = new java.util.HashSet<>();
    for (String file : files)
      check(seen.add(file.toLowerCase(Locale.ROOT)),
          where + " : several files named " + file + " ignoring case");
  }

  static void check(boolean condition, String message) {
    if (!condition)
      throw new NativeBundleException(Reason.INVALID_MANIFEST, message);
  }

  static MessageDigest sha256() {
    try {
      return MessageDigest.getInstance("SHA-256");
    } catch (NoSuchAlgorithmException e) {
      throw new IllegalStateException(e);
    }
  }

  static String sha256(byte[] content) {
    return HexFormat.of().formatHex(sha256().digest(content));
  }
}
