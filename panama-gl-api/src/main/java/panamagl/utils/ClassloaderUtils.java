package panamagl.utils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import panamagl.Debug;

public class ClassloaderUtils {
  static boolean debug = Debug.check(ClassloaderUtils.class);

  public static List<Class<?>> findFactoryClasses(String packge, Class<?> implem, Class<?> exclude) throws ClassNotFoundException, IOException {
    Class<?>[] classes = getClasses(packge);
    

    List<Class<?>> factories = new ArrayList<>();

    for (Class<?> clazz : classes) {
      if(clazz.equals(exclude)) 
        continue;
      
      for (Class<?> interf : clazz.getInterfaces()) {
        if (interf.equals(implem)) {
          factories.add(clazz);
        }
      }
    }

    return factories;
  }
  
  
  /////////////////////////////////////////////////////
  //
  // LOAD ALL CLASS FROM CLASSLOADER
  //
  /////////////////////////////////////////////////////

  public static  Class<?>[] getClasses(String packageName) throws ClassNotFoundException, IOException {
    ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
    assert classLoader != null;
    String path = packageName.replace('.', '/');
    Enumeration<URL> resources = classLoader.getResources(path);
    List<File> dirs = new ArrayList<File>();
    while (resources.hasMoreElements()) {
      URL resource = resources.nextElement();
      dirs.add(new File(resource.getFile()));
    }
    ArrayList<Class<?>> classes = new ArrayList<Class<?>>();
    for (File directory : dirs) {
      classes.addAll(findClasses(directory, packageName));
    }
    return classes.toArray(new Class[classes.size()]);
  }

  /**
   * Recursive method used to find all classes in a given directory and subdirs.
   *
   * @param directory The base directory
   * @param packageName The package name for classes found inside the base directory
   * @return The classes
   * @throws ClassNotFoundException
   */
  public static List<Class<?>> findClasses(File directory, String packageName)
      throws ClassNotFoundException {

    Debug.debug(debug, "Search in " + directory);

    List<Class<?>> classes = new ArrayList<Class<?>>();
    if (!directory.exists()) {
      return classes;
    }
    File[] files = directory.listFiles();
    for (File file : files) {
      if (file.isDirectory()) {
        assert !file.getName().contains(".");
        classes.addAll(findClasses(file, packageName + "." + file.getName()));
      } else if (file.getName().endsWith(".class")) {
        classes.add(Class
            .forName(packageName + '.' + file.getName().substring(0, file.getName().length() - 6)));
      }
    }
    return classes;
  }
}
