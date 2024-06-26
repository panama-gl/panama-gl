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
package demos.opengl;
import java.io.File;
import java.io.IOException;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.SymbolLookup;
import java.lang.invoke.MethodHandle;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

/**
 * WARN : not verified after bumping to JDK 22
 * 
 * ----------------------------
 * 
 * Allow verifying if all generated MethodHandle of the JExtract'ed libraries can be linked properly to native libraries.
 *
 * Run me with VM args :
 * <code>
 *     --enable-native-access=ALL-UNNAMED -Djava.library.path=.:/usr/lib/x86_64-linux-gnu/
 * </code>
 *
 * To build this program, you need to change RuntimeHelper to public as well as its lookup method. If you can't, just set it to null
 *
 * To verify that this program works properly, you need to make an explicit load of libraries and ensure that generated code
 * does not do it, as loading class names from the class path will trigger loading. E.g. do this :
 *
 * <code>
 *     public class glut_h extends glut_h_6 {
 *
 *     static {
 *         //System.loadLibrary("GL");
 *         //System.load("/usr/lib/x86_64-linux-gnu/libglut.so.3.9.0");
 *         //System.load("/usr/lib/x86_64-linux-gnu/libGLU.so.1.3.1");
 *     }
 * </code>
 *
 * And then manually load the libraries in the below check program
 */
@SuppressWarnings("rawtypes")
public class CheckLinkConsistency {

    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException {
        System.loadLibrary("GL");
        System.load("/usr/lib/x86_64-linux-gnu/libglut.so.3.9.0");
        System.load("/usr/lib/x86_64-linux-gnu/libGLU.so.1.3.1"); // Let's forget this on purpose to print missing links

        // If you can not modify RuntimeHelper.lookup() visibility, toggle to null
        SymbolLookup lookup = null;//RuntimeHelper.lookup();
        /*check(lookup, "glLoadIdentity");
        check(lookup, "gluLookAt");*/

        // use reflection to load all classes allowing to invok gl* methods
        String packageName = "opengl.ubuntu.v20";
        String classPattern = "constants\\$(\\d+)";
        String nativeFunctionPatternFilter = "gl.*";

        printLinkStatus(lookup, packageName, classPattern, nativeFunctionPatternFilter, Link.MISSING);

    }

    public static void printLinkStatus(SymbolLookup lookup, String packageName, String classPattern, String nativeFunctionPatternFilter, Link linkStatus) throws ClassNotFoundException, IOException, IllegalAccessException {
        Class[] classes = getClasses(packageName);

        System.out.println("----------------------------------------------------------------");
        System.out.println("Following native functions have link status : " + linkStatus);
        System.out.println("----------------------------------------------------------------");

        for(Class clazz: classes){
            // only check classes matching pattern
            if(Pattern.matches(classPattern, clazz.getSimpleName())){
                printLinkStatus(lookup, clazz, nativeFunctionPatternFilter, linkStatus);
            }
        }

        System.out.println("----------------------------------------------------------------");
        System.out.println("Done checking link status");
    }

    public static void printLinkStatus(SymbolLookup lookup, Class clazz, String nativeFunctionPatternFilter, Link linkStatus) throws IllegalAccessException {
        Field[] fields = clazz.getDeclaredFields();

        for(Field field: fields){
            // Only check MethodHandle fields in this class
            if(field.getType().equals(MethodHandle.class)){
                int cutNameAt = field.getName().indexOf("$");

                if(cutNameAt>0){
                    // remove the trailing $MH from field name to get the original
                    // method name as given in header file
                    String generatedMethod = field.getName().substring(0, cutNameAt);

                    if(Pattern.matches(nativeFunctionPatternFilter, generatedMethod)){
                        printLinkStatus(lookup, clazz, field, generatedMethod, linkStatus);
                    }
                }
            }
        }
    }

    public static void printLinkStatus(SymbolLookup lookup, Class clazz, Field field, String generatedMethod, Link linkStatus) throws IllegalAccessException {
        if(lookup!=null) {
            Optional<MemorySegment> memAddress = lookup.find(generatedMethod);

            if (memAddress.isEmpty() && Link.MISSING.equals(linkStatus)) {
                System.out.println(generatedMethod + ":\t (" + clazz.getSimpleName() + "." + field.getName()  + ") link is MISSING");
            }

            if (memAddress.isPresent() && Link.SUCCESS.equals(linkStatus)) {
                System.out.println(generatedMethod + ":\t (" + memAddress.get() + ") is linked");
            }
        }
        else {
            field.setAccessible(true); // bypass package protected field
            Object fieldValue = field.get(null);
            if (fieldValue == null && Link.MISSING.equals(linkStatus)) {
                System.out.println(generatedMethod + ":\t (" + clazz.getSimpleName() + "." + field.getName() + ") link is MISSING");
            }

            if (fieldValue != null && Link.SUCCESS.equals(linkStatus)) {
                System.out.println(generatedMethod + ":\t (" + clazz.getSimpleName() + "." + field.getName() + ") is linked");
            }
        }
    }

    enum Link{
        SUCCESS, MISSING
    }


    public static void check(SymbolLookup lookup, String function){
        System.out.println(function + ":" + lookup.find(function));
    }

    /////////////////////////////////////////////////////
    //
    //  LOAD ALL CLASS FROM CLASSLOADER
    //
    /////////////////////////////////////////////////////

    public static Class[] getClasses(String packageName)
            throws ClassNotFoundException, IOException {
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
     * @param directory   The base directory
     * @param packageName The package name for classes found inside the base directory
     * @return The classes
     * @throws ClassNotFoundException
     */
    private static List<Class> findClasses(File directory, String packageName) throws ClassNotFoundException {
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
                classes.add(Class.forName(packageName + '.' + file.getName().substring(0, file.getName().length() - 6)));
            }
        }
        return classes;
    }
}
