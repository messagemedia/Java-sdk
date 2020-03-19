package com.messagemedia.api.models;

import java.util.*;

public class HeadlineFontFamilyBuilder {
    //the instance to build
    private HeadlineFontFamily headlineFontFamily;

    /**
     * Default constructor to initialize the instance
     */
    public HeadlineFontFamilyBuilder() {
        headlineFontFamily = new HeadlineFontFamily();
    }

    public HeadlineFontFamilyBuilder type(String type) {
        headlineFontFamily.setType(type);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public HeadlineFontFamily build() {
        return headlineFontFamily;
    }
}