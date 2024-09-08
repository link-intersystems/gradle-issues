plugins {
    `java-gradle-plugin`
    `maven-publish`
    // uncomment after ./gradlew publishToMavenLocal
    // id("my-hello-world")
}

gradlePlugin {
    plugins {
        create("hello-world") {
            id = "my-hello-world"
            implementationClass = "com.link_intersystems.gradle.plugins.example.HelloPlugin"
        }
    }
}
