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
package jextract.gl.java;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.List;
import java.util.regex.Pattern;
import com.google.common.collect.ArrayListMultimap;

public class ClassMethodRegistry {

  static class AcceptsMethodAll implements AcceptsMethod {
    @Override
    public boolean accepts(Method method) {
      return true;
    }
  }
  
  public ArrayListMultimap<Class, Method> selectClassMethods(String packageName, String classPattern,
      AcceptsMethod acceptsMethod)
      throws ClassNotFoundException, IOException, IllegalAccessException {
    System.out.println("Loading classes from classpath");

    Class[] classes = getClasses(packageName);

    System.out.println("----------------------------------------------------------------");
    System.out.println("Browsing in " + packageName + " (" + classes.length + " classes)");
    System.out.println("----------------------------------------------------------------");

    
    ArrayListMultimap<Class, Method> select = ArrayListMultimap.create();
    
    for (Class clazz : classes) {
      // only check classes matching pattern
      if (Pattern.matches(classPattern, clazz.getSimpleName())) {
        System.out.println("Exploring " + clazz);
        
        List<Method> methods = selectMethods(clazz, acceptsMethod);
        
        select.putAll(clazz, methods);
      } 
      else {
        // System.out.println("ignore " + clazz);
      }
    }
    

    System.out.println("----------------------------------------------------------------");
    System.out.println("Done checking method");
    
    return select;
  }


  public List<Method> selectMethods(Class clazz, AcceptsMethod acceptsMethod)
      throws IllegalAccessException {
    
    List<Method> selected = new ArrayList<>();
    
    Method[] methods = clazz.getMethods();

    for (Method method : methods) {
      if (acceptsMethod.accepts(method)) {
        selected.add(method);
      }
    }
    
    return selected;
  }

  public void sort(List<Method> methods) {
    Collections.sort(methods, new Comparator<Method>() {
      @Override
      public int compare(Method o1, Method o2) {
        return o1.getName().compareTo(o2.getName());
      }
    });
  }
  
  public void print(List<Method> methods) {
    for (Method method : methods) {
        
      System.out.print(" - found method : " + method.getName() + "(");

      for (Parameter param : method.getParameters()) {
        System.out.print(param.getType() + ":" + param.getName() + ", ");
      }
      System.out.println(")");
    }
  }

  /////////////////////////////////////////////////////
  //
  // LOAD ALL CLASS FROM CLASSLOADER
  //
  /////////////////////////////////////////////////////

  protected Class[] getClasses(String packageName) throws ClassNotFoundException, IOException {
    ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
    assert classLoader != null;
    String path = packageName.replace('.', '/');
    Enumeration<URL> resources = classLoader.getResources(path);
    List<File> dirs = new ArrayList<File>();
    while (resources.hasMoreElements()) {
      URL resource = resources.nextElement();
      dirs.add(new File(resource.getFile()));
    }
    ArrayList<Class> classes = new ArrayList<Class>();
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
  protected List<Class> findClasses(File directory, String packageName)
      throws ClassNotFoundException {
    
    System.out.println("Search in " + directory);
    
    List<Class> classes = new ArrayList<Class>();
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
