

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


# License

All PanamaGL modules as well as JExtractGL are licensed under the [GPLv3 license](https://choosealicense.com/licenses/gpl-3.0/)

# Authors

Martin Pernollet
