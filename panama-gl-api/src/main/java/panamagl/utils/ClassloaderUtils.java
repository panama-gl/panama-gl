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
    
    if(debug) {

      for (Class<?> clazz : classes) {
        Debug.debug(debug, "ClassloaderUtils : found class " + clazz);
      }
      
      Debug.debug(debug, "ClassloaderUtils : excludes " + exclude);
      Debug.debug(debug, "ClassloaderUtils : implem " + implem);
      

    }
    

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
    //ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
    ClassLoader classLoader = ClassloaderUtils.class.getClassLoader();
    
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

    Debug.debug(debug, "ClassloaderUtils : Search in " + directory);

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
