# PanamaGL

PanamaGL is a Java library allowing real time 2D & 3D Graphics on `Linux`, `macOs` and `Windows` as of Java `22`.

PanamaGL can run on `AWT`, `JavaFX`, `Swing` and `SWT`.

The library is based on multi-platform bindings to the `OpenGL` native library and other per-os companion libraries (`CGL` for macOS, `GLX` for Linux and `WGL` for Windows). Most of the code is generated with JExtract





## Compatibility

- Windowing toolkits : `AWT`, `JavaFX`, `Swing` and `SWT`.
- JDK Versions : `22`
- OS : `linux`, `macOS`, `Windows`

## How to use

### Dependencies

One of the following Maven dependencies should be added to your project according to the UI framework of your application :

#### Supported toolkits

##### AWT dependency


```xml
<dependency>
  <groupId>org.jzy3d</groupId>
  <artifactId>panama-gl-ui-awt</artifactId>
  <version>1.2.0</version>
</dependency>
```
##### JavaFX dependency

```xml
<dependency>
  <groupId>org.jzy3d</groupId>
  <artifactId>panama-gl-ui-javafx</artifactId>
  <version>1.2.0</version>
</dependency>
```

##### Swing dependency
```xml
<dependency>
  <groupId>org.jzy3d</groupId>
  <artifactId>panama-gl-ui-swing</artifactId>
  <version>1.2.0</version>
</dependency>
```

#### Repository

The following repositories should be added to the list of candidate Maven repositories :
```xml
<repositories>
  <repository>
    <id>jzy3d-snapshots</id>
    <name>Jzy3d Snapshots</name>
    <url>https://maven.jzy3d.org/snapshots/</url>
  </repository>
  <repository>
    <id>jzy3d-releases</id>
    <name>Jzy3d Releases</name>
    <url>https://maven.jzy3d.org/releases/</url>
  </repository>
</repositories>
```

### Building a 3D rendering Java application

#### Listener

A rendering application must define when and what should be rendered through a class implementing the four `init()`, `display()`, `reshape()` and `destroy()` hooks of a `GLEventListener`.

```java
public class DrawingListener implements GLEventListener{
  public void init(GL gl) {
    gl.glClearColor(1f, 1f, 1f, 1f);
  }

  public void display(GL gl) {
    gl.glBegin(GL.GL_POINT);
    gl.glColor3f(0.2f, 0.2f, 1f);
    gl.glVertex3f(0.2f, 0.2f, 1f);
    gl.glEnd();
  }

  public void reshape(GL gl, int x, int y, int width, int height) {
    gl.glViewport(x, y, width, height);
  }

  public void destroy(GL gl) {}
}
```

The listener will be invoked by the `AWT thread`.

:warning: OpenGL being single threaded, a `GLEventListener` should never try delegating tasks to other threads otherwise OpenGL errors will occur.

#### Canvas


The application must then instantiate a `GLCanvas` according to the UI framework it is based on. It requires a factory that (described later) and must register the `GLEventListener` that will be executed upon init, render or resize of the canvas.

```java
GLCanvas canvas = new GLCanvasSwing(factory);
panel.setGLEventListener(listener);
```

Available canvases :
* `GLCanvasAWT`
* `GLCanvasJavaFX`
* `GLCanvasSwing`


#### Factory

All per-platform components required to perform drawing are provided by a factory. The `PanamaGLFactory` that is considered compliant with the computer running the program will be elected after the bellow call :

```java
PanamaGLFactory factory = PanamaGLFactory.select();
```

Which returns one of
* `PanamaGLFactory_linux`
* `PanamaGLFactory_macOS`
* `PanamaGLFactory_windows`

Once the canvas gets added to a component hierarchy, a couple of classes will be initialized by the `PanamaGLFactory`.

* The `OffscreenRenderer` will schedule rendering in the appropriate thread and generate images to be displayed by the canvas. It uses an OS-dependent implementation of `FBO` to initialize and use the GPU buffers. All these objects are used PanamaGL `GLCanvas` internally.
* The `GLContext` will provide description of the GPU capabilities (supported OpenGL version, etc). The context is returned by the `GLCanvas` once it has initialized.
* The `GL` instance will allow invoking drawing instructions. It is provided as an input argument of the `GLEventListener` that you implement.


<img src="doc/panama-gl-main-classes.png">




### Wrapping up through an example

This is one of the examples available in the `panama-gl-samples` maven module in this project.

#### A simple Java Window to render OpenGL

This example application uses the `TeapotGLEventListener` defined later to draw a teapot in a Java Swing Frame.

```java
package demos.panamagl.swing;

import java.awt.BorderLayout;
import java.lang.foreign.Arena;
import java.lang.foreign.ValueLayout;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import panamagl.Animator;
import panamagl.GLEventAdapter;
import panamagl.canvas.GLCanvasSwing;
import panamagl.factory.PanamaGLFactory;
import panamagl.opengl.GL;
import panamagl.opengl.GLError;

/**
 * VM arguments to add :
 *
 * for all : --enable-native-access=ALL-UNNAMED
 * macos   : -Djava.library.path=.:/System/Library/Frameworks/OpenGL.framework/Versions/Current/Libraries/
 * linux   : -Djava.library.path=.:/usr/lib/x86_64-linux-gnu/
 * windows : -Djava.library.path="C:\Windows\system32;.\freeglut-MSVC-3.0.0-2.mp\freeglut\bin\x64"
 */
public class PanamaGL_Demo {

  public static void main(String[] args) throws Exception {

    // The Open GL code to render a scene
    GLEventAdapter listener = PanamaGLDemoListener();

    // Detect the current platform and required classes
    PanamaGLFactory factory = PanamaGLFactory.select();

    // Create a panel to render into
    GLCanvasSwing panel = new GLCanvasSwing(factory);

    // Link the panel to the scene we want to render
    panel.setGLEventListener(listener);

    // Create frame to add the panel
    final JFrame frame = new JFrame(DemoTeapot_Onscreen_Swing.class.getSimpleName());
    frame.getContentPane().setLayout(new BorderLayout());
    frame.setBounds(0, 0, 800, 600);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Add the OpenGL panel to the frame
    Runnable show = new Runnable() {
      @Override
      public void run() {
        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
        frame.setBounds(0, 0, 800, 700);
      }
    };


    // Use this to avoid Swing hangs
    SwingUtilities.invokeLater(show);
    //show.run();

    // Start animating
    Animator a = new Animator(panel);
    a.start();
  }
}

```


#### A simple OpenGL scene

The below demonstrates how to extend a `GLEventAdapter` to to invoke drawing instruction through OpenGL.



```java

/**
 * OpenGL code to render a teapot.
 */
public static GLEventAdapter PanamaGLDemoListener() {
  return new GLEventAdapter() {

    /** When GL Canvas init. */
    public void init(GL gl) {

      Arena arena = Arena.ofConfined();

      // Reset Background color
      gl.glClearColor(1f, 1f, 1f, 1f);

      // Setup Lighting
      gl.glShadeModel(GL.GL_SMOOTH);

      var pos = arena.allocateFrom(ValueLayout.JAVA_FLOAT, new float[] {0.0f, 15.0f, -15.0f, 0});
      gl.glLightfv(GL.GL_LIGHT0, GL.GL_POSITION, pos);

      var spec = arena.allocateFrom(ValueLayout.JAVA_FLOAT, new float[] {1, 1, 1, 0});
      gl.glLightfv(GL.GL_LIGHT0, GL.GL_AMBIENT, spec);
      gl.glLightfv(GL.GL_LIGHT0, GL.GL_DIFFUSE, spec);
      gl.glLightfv(GL.GL_LIGHT0, GL.GL_SPECULAR, spec);

      var shini = arena.allocateFrom(ValueLayout.JAVA_FLOAT, 113);
      gl.glMaterialfv(GL.GL_FRONT, GL.GL_SHININESS, shini);
      gl.glEnable(GL.GL_LIGHTING);
      gl.glEnable(GL.GL_LIGHT0);
      gl.glEnable(GL.GL_DEPTH_TEST);

      // Throw runtime exceptions if an OpenGL occured
      GLError.checkAndThrow(gl);
    }

    /** When GL Canvas displays. */
    public void display(GL gl) {

      // Reset Background
      gl.glClearColor(1f, 1f, 1f, 1f);
      gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);

      // Reset model matrix state
      gl.glPushMatrix();
      gl.glRotatef(-20f, 1f, 1f, 0f);
      gl.glRotatef(rot, 0f, 1f, 0f);

      // Draws a colored teapot
      gl.glColor3f(0.2f, 0.2f, 1f);
      gl.glutSolidTeapot(0.5d);

      // Restore model matrix state
      gl.glPopMatrix();

      // Rotate
      rot += 0.45;

      // Throw runtime exceptions if an OpenGL occured
      GLError.checkAndThrow(gl);
    }

    /** When GL Canvas resizes. */
    @Override
    public void reshape(GL gl, int x, int y, int width, int height) {

      // Resize OpenGL viewport
      gl.glViewport(x, y, width, height);
    }

    protected float rot = 0;

  };
}
```



## How to develop


### Structure

<img src="doc/panama-gl-structure.png">

### Inheritance

<img src="doc/panama-gl-inheritance.png">

- Build

- Tests per platform

- Generate bindings

- Generate wrappers


---------------------

PanamaGL aims at providing multiplatorm bindings to OpenGL using the Foreign Function & Memory API for JDK22 and later.

We here show how to use PanamaGL to run OpenGL based rendering application both as a standalone library AND embedded in the Java 3D Charts framework [Jzy3D](https://github.com/jzy3d/jzy3d-api), which already uses JOGL for GPU rendering and EmulGL for CPU rendering.

## Documentation

### Setup your computer
* [Setup base for everyone](doc/setup/setup_everyone.md)
* [Setup on Linux](doc/setup/setup_ubuntu.md)
* [Setup on macOS](doc/setup/setup_macos.md)
* [Setup on Windows](doc/setup/setup_windows.md)

### Help on technologies used in this project
* [Panama Foreign Help](doc/Panama-Foreign-help.md)
* [OpenGL Help](doc/OpenGL-help.md)
* [Modules Quickstart](https://openjdk.java.net/projects/jigsaw/quick-start)
* [Modules Cheatsheet](https://github.com/tfesenko/Java-Modules-JPMS-CheatSheet)

### Design of Panama GL
* [PanamaGL Design](doc/PanamaGL-Design.md)


## Demos

You can find demos in these projects
* [panama-gl-samples](panama-gl-samples) PanamaGL Swing & AWT Samples
* [panama-gl-jzy3d](panama-gl-jzy3d) Benchmarks
  * Jzy3D Native samples (direct draw to an OS window)
  * Jzy3D Embedded samples (indirect draw to a Java window)
* [panama-gl-wrappers-macos](panama-gl-wrappers-macos) Unit tests in src/test/java


### 3D offscreen GL demo

* `TestFBO_macOS` and `DemoFBO_Offscreen_macOS`

More details in [demo index](doc/PanamaGL-Demos.md)

### 3D onscreen GL demos

These two demo open a *native* window with Jzy3D (hence not a Java window yet). One can use the mouse to rotate the object, and double click to start an automatic rotation.

| `SurfaceDemoPanamaGL`| `TeapotDemoPanamaGL`|
|-|-|
| <img src="doc/panama-gl-surface.png"/> | <img src="./doc/panama-gl-teapot.png"/> |

More details in [demo index](doc/PanamaGL-Demos.md)


## Panama GL Design

The design of the library is defined [here](doc/PanamaGL-Design.md) but roughly described in the schema below.

<img src="doc/PanamaGL-Design.png"/>


## OpenGL Wrappers, Bindings, Natives

Let's clarify 3 words
* _Natives_ : native OpenGL libraries (`opengl.dll`, `libGL.dylib`, `libGL.so` with related `GL.h`). Up to now assumed to be available on developer computer.
* _Bindings_ : raw Java classes generated by `JExtract` to invoke _Native_ libraries. Precompiled, available on Maven, Stored [here](https://gitlab.com/jzy3d/panama-gl-bindings).
* _Wrappers_ : thin Java abstraction to fit a common GL interface defined by `panama-gl-core/GL`, wrapping _Bindings_.

This project only provides _Wrappers_ and depends on _Bindings_. This avoid the main projects to recompile large _Bindings_ file source folder and makes IDEs faster.

### Existing Wrappers & Bindings

| Binding | Platform | GPU | Branch |
| ------- | -------- | --- | ------ |
| Linux | Ubuntu 20 | Intel | in progress / Blocked by FBO on Ubuntu |
| Apple | macOS 10.15.7 | Intel | OK |
| Apple | macOS 11.4.0 M1 | M1 | in progress / Blocked by no Panama JDK on ARM yet (Oracle) |
| Microsoft | Windows 10 | Intel | in progress / Blocked by JDK19 |

### Building OpenGL bindings for your platform

To generate new bindings for your platform, see [the setup documentation of the bindings project](https://gitlab.com/jzy3d/panama-gl-bindings/-/tree/main/doc/setup)

* You _should_ only have to do this if you use a computer OS and version for which binding exist already.
* You _may not_ have to regenerate bindings for your OS if its version is supported by existing OS bindings at other versions


# License

All PanamaGL modules as well as JExtractGL are licensed under the [GPLv3 license](https://choosealicense.com/licenses/gpl-3.0/)

# Authors

* Martin Pernollet

* Maybe Manu
