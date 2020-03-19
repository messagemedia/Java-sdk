package com.messagemedia.api.models;

import java.util.*;

public class PrimaryButtonBackgroundColorBuilder {
    //the instance to build
    private PrimaryButtonBackgroundColor primaryButtonBackgroundColor;

    /**
     * Default constructor to initialize the instance
     */
    public PrimaryButtonBackgroundColorBuilder() {
        primaryButtonBackgroundColor = new PrimaryButtonBackgroundColor();
    }

    public PrimaryButtonBackgroundColorBuilder type(String type) {
        primaryButtonBackgroundColor.setType(type);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public PrimaryButtonBackgroundColor build() {
        return primaryButtonBackgroundColor;
    }
}