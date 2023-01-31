# Troubleshooting

This page provides hints to resolve boring problems.

## Path issues

In case GL or GLUT libraries can't be resolved automatically, you may have to edit your VM arguments to indicate where are the libraries.
* linux : `-Djava.library.path=.:/usr/lib/x86_64-linux-gnu/`
* macOS : `-Djava.library.path=.:/System/Library/Frameworks/OpenGL.framework/Versions/Current/Libraries/`
* windows : 

## OpenGL issues

### Multithreading

OpenGL being a single threaded library, some OS require special configuration for tests.

It may worth reading the [JOGL guide about multithreading](https://jogamp.org/jogl/doc/userguide/).

#### macOS

On macOS, OpenGL must be invoked from main thread.
* Panama**GL** handles this on its own through `OffscreenRenderer_macOS`. It uses JOGL's OSXUtil to ensure a given OpenGL (init, display or resize) task is executed by main thread.
* Raw JExtract generated binding used by a program not using OSXUtil should use `-XstartOnFirstThread`.

### GLUT initialization

`glut_h.glutInit(...)` must be called only once in the lifetime of a program. As it might be called by other libs than PanamaGL, the factory initializer of a `GLContext` (e.g. `PanamaGLFactory_macOS.newGLContext()`) may return a `GLUTContext` initialized with `init(false)` to prevent calling `glut_h.glutInit(...)` a second time.

I suspect GLUT being init first by the JVM, hence the bypass in the macOS factory implementation. 


## FFM API 

### FFM require the preview libraries to be enabled

Use the `--enable-preview` JVM argument.

### OOM Exceptions

These JVM parameters have an effect on the available memory for Panama.
* `-XX:MaxDirectMemorySize=512m` is how one can tune the off-heap memory used by Panama.
* `-Xmx512m` had an effect when I was trying to resolve OOM (reducing available max memory helped triggering OOM faster).

Suggestions from Maurizio :
* If your application is using openConfined/openShared (w/o a cleaner parameter!), then, assuming it still calls `MemorySession::close` in the same places where it did in 17, nothing should have changed (in fact, the underlying implementation between 17 and 19 did not change much at all). In that case, all the memory segments associated with the session have their off-heap memory deallocated when the session is closed.
* If you are using openImplicit, or openConfined/Shared (with a cleaner parameter!) then you are at the mercy of the GC - which means that you should make sure that the implicit session containing no-longer needed data is truly unreachable from within your application.

