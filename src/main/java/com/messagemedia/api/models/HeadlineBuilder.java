package com.messagemedia.api.models;

import java.util.*;

public class HeadlineBuilder {
    //the instance to build
    private Headline headline;

    /**
     * Default constructor to initialize the instance
     */
    public HeadlineBuilder() {
        headline = new Headline();
    }

    public HeadlineBuilder type(String type) {
        headline.setType(type);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public Headline build() {
        return headline;
    }
}