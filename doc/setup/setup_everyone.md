# Install JDK with Panama

Currently using JDK 19

* [OpenJDK JDK 19](https://jdk.java.net/19/) to use PanamaGL
* [JExtract](https://jdk.java.net/jextract/) to generate PanamaGL bindings
* Get the most recent IDE version allowing to compile to class version 63.* (JDK 19). E.g. eclipse users should get 2022-12 so that it knows class versions for JDK19 (using JDK 19 for building is not enough).

# Install platform specific tools

Platform specific doc provides command or links to install required tools and libraries in case on which to provide new bindings :
* [Linux](setup_ubuntu.md)
* [macOS](setup_macos.md)
* [Windows](setup_windows.md)

These document provides templates for using JExtract. Convenient scripts for generating bindings with JExtract 19 are provided in [panama-gl-bindings:scripts/](https://gitlab.com/jzy3d/panama-gl-bindings/-/tree/main/scripts)

# Install build tool

* Maven 3 on the command line
