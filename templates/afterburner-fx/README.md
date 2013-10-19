Afterburner.fx project template
-------------------------------

You've just created a basic [Afterburner.fx][afterburner.fx] application. It provides the
standard project structure and simple configurations for both [Gradle][gradle] and
[Maven][maven] to build and run the project.

The project's structure is laid out as follows

    <proj>
      |
      +- src
          |
          +- main
              |
              +- java
              |
                 // application sources
              |
              Â+- resource
              |
                 // FXML and CSS

To compile and run the application with Gradle

    gradlew run

To compile and run the application with Maven

    mvn jfx:run

Additional information on specific settings for Gradle and Maven plugins can be found on
ther respective sites

 * [javafx-gradle][]
 * [javafx-maven][]

[gradle]: http://www.gradle.org
[maven]: http://maven.apache.org
[javafx-gradle]: https://bitbucket.org/shemnon/javafx-gradle
[javafx-maven]: http://zenjava.com/javafx/maven
[afterburner.fx]: http://afterburner.adam-bien.com
