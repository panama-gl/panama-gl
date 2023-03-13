
# Recommandations

## Collaborating on merge request

Gitlab recommandations [here](https://docs.gitlab.com/ee/user/project/merge_requests/allow_collaboration.html)

You may ask martin dot jzy3d dot org to invite you as developer on the project

## Formatters

It is nice to use the provided [code formatters](setup/formatters)

## Naming and coding conventions

* Abstract class name start with A : `AClass`
* No I in java interface names
* Platform specific classes end with OS and CPU name : `MyClass_macOS_x86_64`
* Fields should be `protected` and not `private`, to let anyone override classes more easily, without having to recopy the complete overriden class nor modifying the library to access a field 
* Avoid `static` as much as possible to let methods be overridable