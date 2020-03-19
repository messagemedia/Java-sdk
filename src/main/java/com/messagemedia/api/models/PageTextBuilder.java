package com.messagemedia.api.models;

import java.util.*;

public class PageTextBuilder {
    //the instance to build
    private PageText pageText;

    /**
     * Default constructor to initialize the instance
     */
    public PageTextBuilder() {
        pageText = new PageText();
    }

    public PageTextBuilder type(String type) {
        pageText.setType(type);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public PageText build() {
        return pageText;
    }
}