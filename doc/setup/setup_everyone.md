# Install JDK with Panama

* [OpenJDK JDK 22](https://jdk.java.net/22/) to build PanamaGL
* [JExtract 22](https://jdk.java.net/jextract/) to generate PanamaGL bindings
* [JavaFX SDK 22](https://jdk.java.net/javafx22) to to build JavaFX canvas
* Get the most recent IDE version allowing to compile to class version for JDK 22. E.g. eclipse users should get 2024-03 so that it knows class versions for JDK22.

# Install platform specific tools

Platform specific doc provides command or links to install required tools and libraries in case on which to provide new bindings :
* [Linux](setup_ubuntu.md)
* [macOS](setup_macos.md)
* [Windows](setup_windows.md)

These document provides templates for using JExtract. Convenient scripts for generating bindings with JExtract 19 are provided in [panama-gl-bindings:scripts/](https://gitlab.com/jzy3d/panama-gl-bindings/-/tree/main/scripts)

# Install build tool

* Maven 3 on the command line
