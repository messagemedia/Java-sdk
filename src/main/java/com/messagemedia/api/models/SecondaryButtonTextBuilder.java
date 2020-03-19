package com.messagemedia.api.models;

import java.util.*;

public class SecondaryButtonTextBuilder {
    //the instance to build
    private SecondaryButtonText secondaryButtonText;

    /**
     * Default constructor to initialize the instance
     */
    public SecondaryButtonTextBuilder() {
        secondaryButtonText = new SecondaryButtonText();
    }

    public SecondaryButtonTextBuilder type(String type) {
        secondaryButtonText.setType(type);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public SecondaryButtonText build() {
        return secondaryButtonText;
    }
}