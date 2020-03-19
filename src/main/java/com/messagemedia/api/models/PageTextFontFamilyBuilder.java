package com.messagemedia.api.models;

import java.util.*;

public class PageTextFontFamilyBuilder {
    //the instance to build
    private PageTextFontFamily pageTextFontFamily;

    /**
     * Default constructor to initialize the instance
     */
    public PageTextFontFamilyBuilder() {
        pageTextFontFamily = new PageTextFontFamily();
    }

    public PageTextFontFamilyBuilder type(String type) {
        pageTextFontFamily.setType(type);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public PageTextFontFamily build() {
        return pageTextFontFamily;
    }
}