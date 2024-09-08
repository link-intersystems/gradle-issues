plugins {
    `java-gradle-plugin`
    `maven-publish`
    // uncomment after ./gradlew publishToMavenLocal
//    id("my-hello-world") version "1"
}

gradlePlugin {
    plugins {
        create("hello-world") {
            id = "my-hello-world"
            implementationClass = "com.link_intersystems.gradle.plugins.example.HelloPlugin"
        }
    }
}
