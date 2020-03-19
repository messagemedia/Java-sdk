package com.messagemedia.api.models;

import java.util.*;

public class SecondaryButtonBackgroundColorBuilder {
    //the instance to build
    private SecondaryButtonBackgroundColor secondaryButtonBackgroundColor;

    /**
     * Default constructor to initialize the instance
     */
    public SecondaryButtonBackgroundColorBuilder() {
        secondaryButtonBackgroundColor = new SecondaryButtonBackgroundColor();
    }

    public SecondaryButtonBackgroundColorBuilder type(String type) {
        secondaryButtonBackgroundColor.setType(type);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public SecondaryButtonBackgroundColor build() {
        return secondaryButtonBackgroundColor;
    }
}