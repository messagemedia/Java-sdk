package com.messagemedia.api.models;

import java.util.*;

public class SecondaryButtonTextColorBuilder {
    //the instance to build
    private SecondaryButtonTextColor secondaryButtonTextColor;

    /**
     * Default constructor to initialize the instance
     */
    public SecondaryButtonTextColorBuilder() {
        secondaryButtonTextColor = new SecondaryButtonTextColor();
    }

    public SecondaryButtonTextColorBuilder type(String type) {
        secondaryButtonTextColor.setType(type);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public SecondaryButtonTextColor build() {
        return secondaryButtonTextColor;
    }
}