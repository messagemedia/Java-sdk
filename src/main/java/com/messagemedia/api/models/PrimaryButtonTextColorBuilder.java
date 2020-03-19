package com.messagemedia.api.models;

import java.util.*;

public class PrimaryButtonTextColorBuilder {
    //the instance to build
    private PrimaryButtonTextColor primaryButtonTextColor;

    /**
     * Default constructor to initialize the instance
     */
    public PrimaryButtonTextColorBuilder() {
        primaryButtonTextColor = new PrimaryButtonTextColor();
    }

    public PrimaryButtonTextColorBuilder type(String type) {
        primaryButtonTextColor.setType(type);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public PrimaryButtonTextColor build() {
        return primaryButtonTextColor;
    }
}