Install
* Freeglut is optional : only GLUT functions (e.g. `glutSolidTeapot`) and the GLUT context need it, and the tests and samples get it from the `panama-gl-bindings-windows-freeglut` jar. To use your own, install for example the Freeglut MSVC Package from [there](https://www.transmissionzero.co.uk/software/freeglut-devel/) and add its `bin\x64` folder to the `java.library.path`.
* CLang

## How I built the OpenGL wrappers

See the OpenGL example in [JExtract samples](https://github.com/openjdk/jextract/tree/master/samples).

### Generate OpenGL Java wrappers with JExtract

This allows generating OpenGL Java Wrapper. The generated packages are already in `src/main/java` so you don't need to do it,
it is just a helper for adding wrappers for new platforms.

#### General pattern

```
jextract -d {OUTPUT_DIR} --source -t {PACKAGE_NAME} \
-lGL \
-l{GLUT_LIB} \
-I {GL_AND_GLUT_INCLUDE_DIR} \
-C{ARGS_FOR_CLANG} \
{GLUT_HEADER_FILE}
```