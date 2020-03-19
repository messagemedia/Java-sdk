package com.messagemedia.api.models;

import java.util.*;

public class TemplateBuilder {
    //the instance to build
    private Template template;

    /**
     * Default constructor to initialize the instance
     */
    public TemplateBuilder() {
        template = new Template();
    }

    public TemplateBuilder id(String id) {
        template.setId(id);
        return this;
    }

    public TemplateBuilder name(String name) {
        template.setName(name);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public Template build() {
        return template;
    }
}