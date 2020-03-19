package com.messagemedia.api.models;

import java.util.*;

public class PageTextColorBuilder {
    //the instance to build
    private PageTextColor pageTextColor;

    /**
     * Default constructor to initialize the instance
     */
    public PageTextColorBuilder() {
        pageTextColor = new PageTextColor();
    }

    public PageTextColorBuilder type(String type) {
        pageTextColor.setType(type);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public PageTextColor build() {
        return pageTextColor;
    }
}