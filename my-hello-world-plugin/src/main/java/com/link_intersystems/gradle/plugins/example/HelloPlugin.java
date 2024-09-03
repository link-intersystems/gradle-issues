package com.link_intersystems.gradle.plugins.example;

import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.logging.Logger;
import org.slf4j.LoggerFactory;

public class HelloPlugin implements Plugin<Project> {

    private Logger logger = (Logger) LoggerFactory.getLogger(HelloPlugin.class);

    @Override
    public void apply(Project project) {
        logger.lifecycle("Hello {}!", project.getName());
    }
}
