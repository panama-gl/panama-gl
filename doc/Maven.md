# Bump versions

PanamaGL and [panama-gl-bindings](https://github.com/panama-gl/panama-gl-bindings) have the same version : the wrappers depend on the bindings of `${project.version}`. To release a version, release the bindings of this version first, even unchanged, then PanamaGL.

```
mvn versions:set -DnewVersion="1.4.1"
```

Then update the version of `jextract-gl/pom.xml` (`version.panama`) and of the dependencies in `README.md`.
