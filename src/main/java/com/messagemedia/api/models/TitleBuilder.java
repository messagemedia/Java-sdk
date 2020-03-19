package com.messagemedia.api.models;

import java.util.*;

public class TitleBuilder {
    //the instance to build
    private Title title;

    /**
     * Default constructor to initialize the instance
     */
    public TitleBuilder() {
        title = new Title();
    }

    public TitleBuilder type(String type) {
        title.setType(type);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public Title build() {
        return title;
    }
}