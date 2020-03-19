package com.messagemedia.api.models;

import java.util.*;

public class PageTitleBuilder {
    //the instance to build
    private PageTitle pageTitle;

    /**
     * Default constructor to initialize the instance
     */
    public PageTitleBuilder() {
        pageTitle = new PageTitle();
    }

    public PageTitleBuilder type(String type) {
        pageTitle.setType(type);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public PageTitle build() {
        return pageTitle;
    }
}