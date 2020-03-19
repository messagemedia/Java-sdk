package com.messagemedia.api.models;

import java.util.*;

public class BodyTextBuilder {
    //the instance to build
    private BodyText bodyText;

    /**
     * Default constructor to initialize the instance
     */
    public BodyTextBuilder() {
        bodyText = new BodyText();
    }

    public BodyTextBuilder type(String type) {
        bodyText.setType(type);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public BodyText build() {
        return bodyText;
    }
}