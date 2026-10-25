

## Convert XML to XSD

https://www.convertsimple.com/convert-xml-to-xsd-xml-schema/


## Convert XSD to Java parsers

```
mvn jaxb2:xjc
```

if missing element check XSD


If "No schemas have been found" error, delete resource folder content and rerun, then reload mavn project

Edit the `Registry.Enums.Enum` class so that it can properly load the value field : replace "value1" by "value" in the annotation field:

```java
public static class Enum {

    @XmlValue
    protected String value;
    @XmlAttribute(name = "value")
    protected String value1;

```


## Generate Java code

### Generate source code

https://github.com/forge/roaster
https://stackoverflow.com/questions/121324/a-java-api-to-generate-java-source-files


### Generate byte code

https://www.baeldung.com/java-asm
https://topic.alibabacloud.com/a/asm-java-code-generation_1_27_32055951.html
https://stackoverflow.com/questions/5346908/generating-a-hello-world-class-with-the-java-asm-library


### Read existing glut_h binding to find all methods to wrap

https://stackoverflow.com/questions/2206065/java-parse-java-source-code-extract-methods


# Generate the GL API and its wrappers

`jextract.gl.api.panamagl.GenerateAPI` reads the OpenGL registry (`gl.xml`) and the bindings classes of `panama-gl-bindings` to write :
* the `GL_x_y` interfaces of each OpenGL version in `panama-gl-api`, and `GL` which extends `GL_1`, `GL_2`, `GL_3`, `GLU` and `GLUT`;
* the `GL_<os>` wrapper implementing `GL` for each OS, in the `src/generated/java` folder of `panama-gl-wrappers-<os>`, and its `PanamaGLFactory_<os>`. A wrapper serves all the CPUs of its OS, as the bindings do (see [Bindings per CPU](../doc/Bindings-per-CPU.md)).

Run its `main` from the `jextract-gl` folder, after `mvn install` of the root project. The `MACOS`, `LINUX` and `WINDOWS` flags of `GenerateAPI.run` select the generated OS.

For each command of the registry, the wrapper method is written as follows (`GenerateAPI_GL_Wrapper`) :

| Case | Wrapper method | Example |
|------|----------------|---------|
| The binding declares the function | Delegates to the static method of the binding | `gl_h.glClear(mask);` |
| The binding only declares its function pointer type | Invokes the `PFN...PROC` class of `Wrapper.functionPointers` with the address given by the `GLFunctionLoader` of the platform (`Wrapper.functionLoader`) | `PFNGLGENBUFFERSPROC.invoke(load("glGenBuffers"), n, buffers);` |
| Neither | Throws an exception | `throw new RuntimeException("This method is not available in the generated binding.");` |

* The function pointer classes are the ones of `opengl.glext` (panama-gl-bindings-glext) on all platforms (`GenerateAPI.FUNCTION_POINTERS`), as `FBO_windows` does : their signature only depends on OpenGL types.
* A command without function pointer type uses the one of a command that the registry declares as its alias (e.g. `PFNGLMULTITEXCOORD2FARBPROC` for `glMultiTexCoord2f`, since `gl.h` declares OpenGL 1.3 without function pointer types).
* The last two cases are written only if `addUnimplementedMethodsUponMissingBinding` is set for the platform.

The committed wrappers contain a few manual fixes (e.g. the `glutBitmap*` methods), which a regeneration overwrites : review the diff of the generated files before committing them.

# License

All PanamaGL modules as well as JExtractGL are licensed under the [GPLv3 license](https://choosealicense.com/licenses/gpl-3.0/)

# Authors

Martin Pernollet
