package com.messagemedia.api.models;

import java.util.*;

public class PrimaryButtonTextBuilder {
    //the instance to build
    private PrimaryButtonText primaryButtonText;

    /**
     * Default constructor to initialize the instance
     */
    public PrimaryButtonTextBuilder() {
        primaryButtonText = new PrimaryButtonText();
    }

    public PrimaryButtonTextBuilder type(String type) {
        primaryButtonText.setType(type);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public PrimaryButtonText build() {
        return primaryButtonText;
    }
}