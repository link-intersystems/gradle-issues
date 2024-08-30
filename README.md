This repositories is used to discuss a Gradle issue.

The ckicken-egg-problem won't let you use the actual
verison of a plugin within the plugin's project.

But why is it not ok to use the previous version?

## How to reproduce the issue

1. publish the current plugin version 1 to your maven local repository

       # pTML is the abbreviation for publishToMavenLocal 
       ./gradlew pTML
2. Increment the version in the `gradle.properties`

       group = com.link-intersystems.gradle.plugins.example
       #version = 1
       # use the incremented version after ./gradlew publishToMavenLocal
       version = 2
3. Use the previous plugin version in the `build.gradle.kts`

       plugins {
          `java-gradle-plugin`
          `maven-publish`
           id("my-hello-world") version "1"
       }
4. Try to build the project

       ./gradlew clean build

       * What went wrong:
          Could not apply requested plugin [id: 'my-hello-world', version: '1'] as it does not provide a plugin with id 'my-hello-world'. This is caused by an incorrect plugin implementation. Please contact the plugin author(s).
       > Plugin with id 'my-hello-world' not found.
5. Revert the changes

       git checkout .
6. Add the `other-project` as a composite build to the root project's settings

       includeBuild("other-project")
7. Build the composite build `other-project` and it works

       ./gradlew :other-project:clean :other-project:build

       > Configure project :other-project
       Hello other-project!

    Why does it not work in the plugin's project itself, but when used in any other project?
    Since the previous version is used it can not be a chicken-egg-problem.

