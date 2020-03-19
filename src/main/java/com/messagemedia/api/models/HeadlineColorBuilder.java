package com.messagemedia.api.models;

import java.util.*;

public class HeadlineColorBuilder {
    //the instance to build
    private HeadlineColor headlineColor;

    /**
     * Default constructor to initialize the instance
     */
    public HeadlineColorBuilder() {
        headlineColor = new HeadlineColor();
    }

    public HeadlineColorBuilder type(String type) {
        headlineColor.setType(type);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public HeadlineColor build() {
        return headlineColor;
    }
}