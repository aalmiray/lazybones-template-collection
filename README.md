Lazybones Template Collection
-----------------------------

This project holds a set of templates to be used with [Lazybones][]
The current list contains the following templates

 * [afterburner.fx][]: kickstart a base Afterburner.fx application
 * [afterburner.gfx][]: kickstart a base Afterburner.gfx application (GroovyFX enabled)
 * [asciidoctor-gradle][]: setup a basic asciidoc project documentation
 * gradle-quickstart: setup a gradle project with cobertura, coveralls
   bintray, license and other useful settings

[Lazybones]: http://github.com/pledbrook/lazybones
[afterburner.fx]: http://afterburner.adam-bien.com
[afterburner.gfx]: https://bitbucket.org/bgoetzmann/afterburner.gfx/wiki/Home
[asciidoctor-gradle]: http://asciidoctor.org/docs/asciidoctor-gradle-plugin/

##How To


To install all templates use:
```gradle
gradlew installAllTemplates
```

If you want to install just one template use:
```gradle
gradlew installTemplate[TEMPLATENAME]
```

After installing the template use the following comand to create a project
```gradle
lazybones create [template] [version] [project-name]
```

To show all available Templates use:
```gradle
gradlew tasks --all
```