rootProject.name = "gradle-use-previous-plugin-version-issue"

pluginManagement {
    repositories {
        mavenLocal()
        gradlePluginPortal()
    }
}

plugins {
    id("my-hello-world") version "1" apply false
}

include(":my-hello-world-plugin")
//includeBuild("other-project")
